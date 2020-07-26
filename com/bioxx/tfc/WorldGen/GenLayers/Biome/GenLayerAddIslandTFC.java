/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerAddIslandTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerAddIslandTFC(long par1, GenLayer par3GenLayer) {
/* 12 */     super(par1);
/* 13 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 23 */     int var5 = par1 - 1;
/* 24 */     int var6 = par2 - 1;
/* 25 */     int var7 = par3 + 2;
/* 26 */     int var8 = par4 + 2;
/* 27 */     int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
/* 28 */     int[] var10 = IntCache.func_76445_a(par3 * par4);
/*    */     
/* 30 */     for (int var11 = 0; var11 < par4; var11++) {
/*    */       
/* 32 */       for (int var12 = 0; var12 < par3; var12++) {
/*    */         
/* 34 */         int var13 = var9[var12 + 0 + (var11 + 0) * var7];
/* 35 */         int var14 = var9[var12 + 2 + (var11 + 0) * var7];
/* 36 */         int var15 = var9[var12 + 0 + (var11 + 2) * var7];
/* 37 */         int var16 = var9[var12 + 2 + (var11 + 2) * var7];
/* 38 */         int var17 = var9[var12 + 1 + (var11 + 1) * var7];
/* 39 */         func_75903_a((var12 + par1), (var11 + par2));
/*    */         
/* 41 */         if (var17 == 0 && (var13 != 0 || var14 != 0 || var15 != 0 || var16 != 0)) {
/*    */           
/* 43 */           int var18 = 1;
/* 44 */           int var19 = 1;
/*    */           
/* 46 */           if (var13 != 0 && func_75902_a(var18++) == 0) {
/* 47 */             var19 = var13;
/*    */           }
/* 49 */           if (var14 != 0 && func_75902_a(var18++) == 0) {
/* 50 */             var19 = var14;
/*    */           }
/* 52 */           if (var15 != 0 && func_75902_a(var18++) == 0) {
/* 53 */             var19 = var15;
/*    */           }
/* 55 */           if (var16 != 0 && func_75902_a(var18++) == 0) {
/* 56 */             var19 = var16;
/*    */           }
/* 58 */           if (func_75902_a(3) == 0) {
/* 59 */             var10[var12 + var11 * par3] = var19;
/*    */           } else {
/* 61 */             var10[var12 + var11 * par3] = 0;
/*    */           } 
/* 63 */         } else if (var17 > 0 && (var13 == 0 || var14 == 0 || var15 == 0 || var16 == 0)) {
/*    */           
/* 65 */           if (func_75902_a(5) == 0) {
/* 66 */             var10[var12 + var11 * par3] = 0;
/*    */           } else {
/* 68 */             var10[var12 + var11 * par3] = var17;
/*    */           } 
/*    */         } else {
/*    */           
/* 72 */           var10[var12 + var11 * par3] = var17;
/*    */         } 
/*    */       } 
/*    */     } 
/* 76 */     return var10;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerAddIslandTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */