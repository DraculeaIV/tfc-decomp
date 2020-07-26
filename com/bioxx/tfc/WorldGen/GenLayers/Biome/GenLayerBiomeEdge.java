/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerBiomeEdge
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerBiomeEdge(long par1, GenLayer par3GenLayer) {
/* 13 */     super(par1);
/* 14 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int xSize, int zSize) {
/* 24 */     int[] inCache = this.field_75909_a.func_75904_a(par1 - 1, par2 - 1, xSize + 2, zSize + 2);
/* 25 */     validateIntArray(inCache, xSize + 2, zSize + 2);
/* 26 */     int[] outCache = IntCache.func_76445_a(xSize * zSize);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     for (int z = 0; z < zSize; z++) {
/*    */       
/* 34 */       for (int x = 0; x < xSize; x++) {
/*    */         
/* 36 */         func_75903_a((x + par1), (z + par2));
/* 37 */         int thisID = inCache[x + 1 + (z + 1) * (xSize + 2)];
/*    */         
/* 39 */         int var10 = inCache[x + 1 + (z + 1 - 1) * (xSize + 2)];
/* 40 */         int var11 = inCache[x + 1 + 1 + (z + 1) * (xSize + 2)];
/* 41 */         int var12 = inCache[x + 1 - 1 + (z + 1) * (xSize + 2)];
/* 42 */         int var13 = inCache[x + 1 + (z + 1 + 1) * (xSize + 2)];
/*    */         
/* 44 */         if (thisID == TFCBiome.HIGH_HILLS.field_76756_M) {
/*    */           
/* 46 */           if (var10 == TFCBiome.HIGH_HILLS.field_76756_M && var11 == TFCBiome.HIGH_HILLS.field_76756_M && var12 == TFCBiome.HIGH_HILLS.field_76756_M && var13 == TFCBiome.HIGH_HILLS.field_76756_M) {
/* 47 */             outCache[x + z * xSize] = thisID;
/*    */           } else {
/* 49 */             outCache[x + z * xSize] = TFCBiome.HIGH_HILLS_EDGE.field_76756_M;
/*    */           } 
/* 51 */         } else if (thisID == TFCBiome.MOUNTAINS.field_76756_M) {
/*    */           
/* 53 */           if (var10 == TFCBiome.MOUNTAINS.field_76756_M && var11 == TFCBiome.MOUNTAINS.field_76756_M && var12 == TFCBiome.MOUNTAINS.field_76756_M && var13 == TFCBiome.MOUNTAINS.field_76756_M) {
/* 54 */             outCache[x + z * xSize] = thisID;
/*    */           } else {
/* 56 */             outCache[x + z * xSize] = TFCBiome.MOUNTAINS_EDGE.field_76756_M;
/*    */           } 
/* 58 */         } else if (thisID == TFCBiome.SWAMPLAND.field_76756_M) {
/*    */           
/* 60 */           if (var10 == TFCBiome.SWAMPLAND.field_76756_M && var11 == TFCBiome.SWAMPLAND.field_76756_M && var12 == TFCBiome.SWAMPLAND.field_76756_M && var13 == TFCBiome.SWAMPLAND.field_76756_M) {
/* 61 */             outCache[x + z * xSize] = thisID;
/*    */           } else {
/* 63 */             outCache[x + z * xSize] = TFCBiome.PLAINS.field_76756_M;
/*    */           } 
/* 65 */         } else if (thisID == TFCBiome.HIGH_PLAINS.field_76756_M) {
/*    */           
/* 67 */           if (var10 == TFCBiome.HIGH_PLAINS.field_76756_M && var11 == TFCBiome.HIGH_PLAINS.field_76756_M && var12 == TFCBiome.HIGH_PLAINS.field_76756_M && var13 == TFCBiome.HIGH_PLAINS.field_76756_M) {
/* 68 */             outCache[x + z * xSize] = thisID;
/*    */           } else {
/* 70 */             outCache[x + z * xSize] = TFCBiome.PLAINS.field_76756_M;
/*    */           } 
/*    */         } else {
/*    */           
/* 74 */           outCache[x + z * xSize] = thisID;
/*    */         } 
/*    */         
/* 77 */         validateInt(outCache, x + z * xSize);
/*    */       } 
/*    */     } 
/* 80 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerBiomeEdge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */