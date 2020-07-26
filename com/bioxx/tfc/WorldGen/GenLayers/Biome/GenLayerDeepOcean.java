/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerDeepOcean
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerDeepOcean(long seed, GenLayerTFC parent) {
/* 12 */     super(seed);
/* 13 */     this.field_75909_a = parent;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int parX, int parZ, int parXSize, int parZSize) {
/* 23 */     int xSize = parXSize + 2;
/* 24 */     int zSize = parZSize + 2;
/*    */     
/* 26 */     int[] parentIDs = this.field_75909_a.func_75904_a(parX - 1, parZ - 1, xSize, zSize);
/* 27 */     validateIntArray(parentIDs, xSize, zSize);
/* 28 */     int[] outCache = IntCache.func_76445_a(parXSize * parZSize);
/*    */     
/* 30 */     for (int z = 0; z < parZSize; z++) {
/*    */       
/* 32 */       for (int x = 0; x < parXSize; x++) {
/*    */         
/* 34 */         int northID = parentIDs[x + 1 + z * xSize];
/* 35 */         int rightID = parentIDs[x + 2 + (z + 1) * xSize];
/* 36 */         int leftID = parentIDs[x + (z + 1) * xSize];
/* 37 */         int southID = parentIDs[x + 1 + (z + 2) * xSize];
/* 38 */         int thisID = parentIDs[x + 1 + (z + 1) * xSize];
/* 39 */         int oceanCount = 0;
/* 40 */         int outIndex = x + z * parXSize;
/*    */         
/* 42 */         if (northID == 0)
/*    */         {
/* 44 */           oceanCount++;
/*    */         }
/*    */         
/* 47 */         if (rightID == 0)
/*    */         {
/* 49 */           oceanCount++;
/*    */         }
/*    */         
/* 52 */         if (leftID == 0)
/*    */         {
/* 54 */           oceanCount++;
/*    */         }
/*    */         
/* 57 */         if (southID == 0)
/*    */         {
/* 59 */           oceanCount++;
/*    */         }
/*    */         
/* 62 */         if (thisID == 0 && oceanCount > 3) {
/*    */           
/* 64 */           outCache[outIndex] = TFCBiome.DEEP_OCEAN.field_76756_M;
/*    */         }
/*    */         else {
/*    */           
/* 68 */           outCache[outIndex] = thisID;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 73 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerDeepOcean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */