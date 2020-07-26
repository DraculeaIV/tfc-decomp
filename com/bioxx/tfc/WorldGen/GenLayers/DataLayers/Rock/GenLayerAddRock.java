/*    */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ public class GenLayerAddRock
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerAddRock(long par1, GenLayer par3GenLayer) {
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
/*    */   public int[] func_75904_a(int par1, int par2, int xMax, int zMax) {
/* 22 */     int var5 = par1 - 1;
/* 23 */     int var6 = par2 - 1;
/* 24 */     int var7 = xMax + 2;
/* 25 */     int var8 = zMax + 2;
/* 26 */     int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
/* 27 */     int[] outCache = new int[xMax * zMax];
/*    */     
/* 29 */     for (int z = 0; z < zMax; z++) {
/*    */       
/* 31 */       for (int x = 0; x < xMax; x++) {
/*    */         
/* 33 */         int var13 = var9[x + 0 + (z + 0) * var7];
/* 34 */         int var14 = var9[x + 2 + (z + 0) * var7];
/* 35 */         int var15 = var9[x + 0 + (z + 2) * var7];
/* 36 */         int var16 = var9[x + 2 + (z + 2) * var7];
/* 37 */         int thisID = var9[x + 1 + (z + 1) * var7];
/* 38 */         func_75903_a((x + par1), (z + par2));
/*    */ 
/*    */         
/* 41 */         int var18 = 1;
/* 42 */         int outID = thisID;
/*    */         
/* 44 */         if (func_75902_a(var18++) == 0) {
/* 45 */           outID = var13;
/*    */         }
/* 47 */         if (func_75902_a(var18++) == 0) {
/* 48 */           outID = var14;
/*    */         }
/* 50 */         if (func_75902_a(var18++) == 0) {
/* 51 */           outID = var15;
/*    */         }
/* 53 */         if (func_75902_a(var18++) == 0) {
/* 54 */           outID = var16;
/*    */         }
/* 56 */         if (func_75902_a(2) == 0) {
/* 57 */           outCache[x + z * xMax] = outID;
/*    */         } else {
/* 59 */           outCache[x + z * xMax] = thisID;
/*    */         } 
/*    */       } 
/*    */     } 
/* 63 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Rock\GenLayerAddRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */