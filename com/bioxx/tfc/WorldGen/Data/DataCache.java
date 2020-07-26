/*    */ package com.bioxx.tfc.WorldGen.Data;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.DataLayer;
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.WorldCacheManager;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.LongHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataCache
/*    */ {
/*    */   private final WorldCacheManager chunkManager;
/*    */   private long lastCleanupTime;
/* 20 */   private LongHashMap cacheMap = new LongHashMap();
/*    */   
/* 22 */   private List<DataCacheBlockTFC> cache = new ArrayList<DataCacheBlockTFC>();
/*    */   
/*    */   private int index;
/*    */   
/*    */   public DataCache(WorldCacheManager worldLayerManager) {
/* 27 */     this.chunkManager = worldLayerManager;
/*    */   }
/*    */ 
/*    */   
/*    */   public DataCache(WorldCacheManager par1, int ind) {
/* 32 */     this.chunkManager = par1;
/* 33 */     this.index = ind;
/*    */   }
/*    */ 
/*    */   
/*    */   public DataCacheBlockTFC getDataCacheBlock(GenLayerTFC indexLayers, int x, int y) {
/* 38 */     x >>= 4;
/* 39 */     y >>= 4;
/* 40 */     long var3 = x & 0xFFFFFFFFL | (y & 0xFFFFFFFFL) << 32L;
/* 41 */     DataCacheBlockTFC var5 = (DataCacheBlockTFC)this.cacheMap.func_76164_a(var3);
/* 42 */     if (var5 == null) {
/*    */       
/* 44 */       var5 = new DataCacheBlockTFC(this, indexLayers, x, y, this.index);
/* 45 */       this.cacheMap.func_76163_a(var3, var5);
/* 46 */       this.cache.add(var5);
/*    */     } 
/* 48 */     var5.lastAccessTime = MinecraftServer.func_130071_aq();
/* 49 */     return var5;
/*    */   }
/*    */ 
/*    */   
/*    */   public DataLayer getDataLayerAt(GenLayerTFC indexLayers, int par1, int par2) {
/* 54 */     return getDataCacheBlock(indexLayers, par1, par2).getDataLayerAt(par1, par2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cleanupCache() {
/* 59 */     long var1 = MinecraftServer.func_130071_aq();
/* 60 */     long var3 = var1 - this.lastCleanupTime;
/* 61 */     if (var3 > 7500L || var3 < 0L) {
/*    */       
/* 63 */       this.lastCleanupTime = var1;
/* 64 */       for (int var5 = 0; var5 < this.cache.size(); var5++) {
/*    */         
/* 66 */         DataCacheBlockTFC var6 = this.cache.get(var5);
/* 67 */         if (var6 != null) {
/*    */           
/* 69 */           long var7 = var1 - var6.lastAccessTime;
/* 70 */           if (var7 > 30000L || var7 < 0L) {
/*    */             
/* 72 */             this.cache.remove(var5--);
/* 73 */             long var9 = var6.xPosition & 0xFFFFFFFFL | (var6.zPosition & 0xFFFFFFFFL) << 32L;
/* 74 */             this.cacheMap.func_76159_d(var9);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public DataLayer[] getCachedData(GenLayerTFC indexLayers, int par1, int par2) {
/* 83 */     return (getDataCacheBlock(indexLayers, par1, par2)).data;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WorldCacheManager getChunkManager(DataCache cache) {
/* 91 */     return cache.chunkManager;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Data\DataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */