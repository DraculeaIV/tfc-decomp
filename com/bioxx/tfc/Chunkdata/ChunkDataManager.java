/*     */ package com.bioxx.tfc.Chunkdata;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.util.LongHashMap;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkDataManager
/*     */ {
/*  15 */   private LongHashMap chunkmap = new LongHashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkDataManager(World world) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeData(int x, int z) {
/*  24 */     long key = ChunkCoordIntPair.func_77272_a(x, z);
/*  25 */     if (this.chunkmap.func_76161_b(key))
/*     */     {
/*  27 */       this.chunkmap.func_76159_d(key);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addData(long key, ChunkData cd) {
/*  33 */     this.chunkmap.func_76163_a(key, cd);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addData(Chunk chunk, ChunkData cd) {
/*  38 */     this.chunkmap.func_76163_a(ChunkCoordIntPair.func_77272_a(chunk.field_76635_g, chunk.field_76647_h), cd);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addData(int x, int z, ChunkData cd) {
/*  43 */     this.chunkmap.func_76163_a(ChunkCoordIntPair.func_77272_a(x, z), cd);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkData getData(int x, int z) {
/*  48 */     long key = ChunkCoordIntPair.func_77272_a(x, z);
/*  49 */     if (this.chunkmap.func_76161_b(key))
/*  50 */       return (ChunkData)this.chunkmap.func_76164_a(key); 
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkData getData(long key) {
/*  56 */     if (this.chunkmap.func_76161_b(key))
/*  57 */       return (ChunkData)this.chunkmap.func_76164_a(key); 
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasData(long key) {
/*  63 */     return this.chunkmap.func_76161_b(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addProtection(int x, int z, int amount) {
/*  68 */     ChunkData d = getData(x, z);
/*  69 */     if (d != null) {
/*     */       
/*  71 */       if (d.spawnProtection < 24 * TFC_Time.daysInMonth * TFCOptions.maxProtectionMonths)
/*  72 */         d.setSpawnProtectionWithUpdate(amount); 
/*  73 */       return true;
/*     */     } 
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFishPop(int x, int z, float fishPop) {
/*  80 */     ChunkData d = getData(x, z);
/*  81 */     if (d != null && fishPop >= 0.0F)
/*     */     {
/*  83 */       d.fishPop = fishPop;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFishPop(int x, int z) {
/*  89 */     ChunkData d = getData(x, z);
/*  90 */     if (d != null)
/*     */     {
/*  92 */       return (int)d.fishPop;
/*     */     }
/*  94 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean catchFish(int x, int z) {
/*  99 */     ChunkData d = getData(x, z);
/* 100 */     if (d != null)
/*     */     {
/* 102 */       if (d.fishPop > 0.0F) {
/* 103 */         d.fishPop--;
/* 104 */         return true;
/*     */       } 
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setLastVisted(int x, int z) {
/* 112 */     ChunkData d = getData(x, z);
/* 113 */     if (d != null) {
/*     */       
/* 115 */       d.lastVisited = TFC_Time.getTotalTicks();
/* 116 */       return true;
/*     */     } 
/* 118 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Chunkdata\ChunkDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */