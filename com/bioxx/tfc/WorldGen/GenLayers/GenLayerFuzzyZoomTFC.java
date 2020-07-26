/*    */ package com.bioxx.tfc.WorldGen.GenLayers;
/*    */ 
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ public class GenLayerFuzzyZoomTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerFuzzyZoomTFC(long par1, GenLayer par3GenLayer) {
/*  9 */     super(par1);
/* 10 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 20 */     int var5 = par1 >> 1;
/* 21 */     int var6 = par2 >> 1;
/* 22 */     int var7 = (par3 >> 1) + 3;
/* 23 */     int var8 = (par4 >> 1) + 3;
/* 24 */     int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
/* 25 */     int[] var10 = new int[var7 * 2 * var8 * 2];
/* 26 */     int var11 = var7 << 1;
/*    */ 
/*    */     
/* 29 */     for (int var12 = 0; var12 < var8 - 1; var12++) {
/*    */       
/* 31 */       int i = var12 << 1;
/* 32 */       int var14 = i * var11;
/* 33 */       int var15 = var9[0 + (var12 + 0) * var7];
/* 34 */       int var16 = var9[0 + (var12 + 1) * var7];
/*    */       
/* 36 */       for (int var17 = 0; var17 < var7 - 1; var17++) {
/*    */         
/* 38 */         func_75903_a((var17 + var5 << 1), (var12 + var6 << 1));
/* 39 */         int var18 = var9[var17 + 1 + (var12 + 0) * var7];
/* 40 */         int var19 = var9[var17 + 1 + (var12 + 1) * var7];
/* 41 */         var10[var14] = var15;
/* 42 */         var10[var14++ + var11] = choose(var15, var16);
/* 43 */         var10[var14] = choose(var15, var18);
/* 44 */         var10[var14++ + var11] = choose(var15, var18, var16, var19);
/* 45 */         var15 = var18;
/* 46 */         var16 = var19;
/*    */       } 
/*    */     } 
/*    */     
/* 50 */     int[] var20 = new int[par3 * par4];
/*    */     
/* 52 */     for (int var13 = 0; var13 < par4; var13++) {
/* 53 */       System.arraycopy(var10, (var13 + (par2 & 0x1)) * (var7 << 1) + (par1 & 0x1), var20, var13 * par3, par3);
/*    */     }
/* 55 */     return var20;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int choose(int par1, int par2) {
/* 63 */     return (func_75902_a(2) == 0) ? par1 : par2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int choose(int par1, int par2, int par3, int par4) {
/* 71 */     int var5 = func_75902_a(4);
/* 72 */     return (var5 == 0) ? par1 : ((var5 == 1) ? par2 : ((var5 == 2) ? par3 : par4));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\GenLayerFuzzyZoomTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */