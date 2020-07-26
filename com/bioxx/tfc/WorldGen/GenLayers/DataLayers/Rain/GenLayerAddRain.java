/*    */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rain;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ public class GenLayerAddRain
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerAddRain(long par1, GenLayer par3GenLayer) {
/* 11 */     super(par1);
/* 12 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int xCoord, int zCoord, int xSize, int zSize) {
/* 22 */     int var5 = xCoord - 1;
/* 23 */     int var6 = zCoord - 1;
/* 24 */     int var7 = xSize + 2;
/* 25 */     int var8 = zSize + 2;
/* 26 */     int[] inCache = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
/* 27 */     int[] outCache = new int[xSize * zSize];
/*    */     
/* 29 */     for (int var11 = 0; var11 < zSize; var11++) {
/*    */       
/* 31 */       for (int var12 = 0; var12 < xSize; var12++) {
/*    */         
/* 33 */         int id0 = inCache[var12 + 0 + (var11 + 0) * var7];
/* 34 */         int id1 = inCache[var12 + 2 + (var11 + 0) * var7];
/* 35 */         int id2 = inCache[var12 + 0 + (var11 + 2) * var7];
/* 36 */         int id3 = inCache[var12 + 2 + (var11 + 2) * var7];
/* 37 */         int thisID = inCache[var12 + 1 + (var11 + 1) * var7];
/* 38 */         func_75903_a((var12 + xCoord), (var11 + zCoord));
/*    */         
/* 40 */         if (id0 > thisID || id1 > thisID || id2 > thisID || id3 > thisID) {
/*    */           
/* 42 */           int count = 1;
/* 43 */           int outID = thisID;
/*    */           
/* 45 */           if (id0 != 0 && func_75902_a(count++) == 0) {
/* 46 */             outID = id0 + 1;
/*    */           }
/* 48 */           if (id1 != 0 && func_75902_a(count++) == 0) {
/* 49 */             outID = id1 + 1;
/*    */           }
/* 51 */           if (id2 != 0 && func_75902_a(count++) == 0) {
/* 52 */             outID = id2 + 1;
/*    */           }
/* 54 */           if (id3 != 0 && func_75902_a(count++) == 0) {
/* 55 */             outID = id3 + 1;
/*    */           }
/* 57 */           if (func_75902_a(3) == 0 && outID <= GenRainLayerTFC.WET) {
/* 58 */             outCache[var12 + var11 * xSize] = outID;
/*    */           } else {
/* 60 */             outCache[var12 + var11 * xSize] = thisID;
/*    */           } 
/* 62 */         } else if (id0 < thisID || id1 < thisID || id2 < thisID || id3 < thisID) {
/*    */           
/* 64 */           int count = 1;
/* 65 */           int outID = thisID;
/*    */           
/* 67 */           if (id0 != 0 && func_75902_a(count++) == 0) {
/* 68 */             outID = id0 - 1;
/*    */           }
/* 70 */           if (id1 != 0 && func_75902_a(count++) == 0) {
/* 71 */             outID = id1 - 1;
/*    */           }
/* 73 */           if (id2 != 0 && func_75902_a(count++) == 0) {
/* 74 */             outID = id2 - 1;
/*    */           }
/* 76 */           if (id3 != 0 && func_75902_a(count++) == 0) {
/* 77 */             outID = id3 - 1;
/*    */           }
/* 79 */           if (func_75902_a(3) == 0 && outID >= GenRainLayerTFC.DRY) {
/* 80 */             outCache[var12 + var11 * xSize] = outID;
/*    */           } else {
/* 82 */             outCache[var12 + var11 * xSize] = thisID;
/*    */           } 
/*    */         } else {
/*    */           
/* 86 */           outCache[var12 + var11 * xSize] = thisID;
/*    */         } 
/*    */       } 
/*    */     } 
/* 90 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Rain\GenLayerAddRain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */