/*    */ package com.bioxx.tfc.WorldGen.GenLayers;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ public class GenLayerSmoothTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerSmoothTFC(long par1, GenLayer par3GenLayer) {
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
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 22 */     int var5 = par1 - 1;
/* 23 */     int var6 = par2 - 1;
/* 24 */     int var7 = par3 + 2;
/* 25 */     int var8 = par4 + 2;
/* 26 */     int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
/* 27 */     int[] var10 = new int[par3 * par4];
/*    */     
/* 29 */     for (int var11 = 0; var11 < par4; var11++) {
/*    */       
/* 31 */       for (int var12 = 0; var12 < par3; var12++) {
/*    */         
/* 33 */         int var13 = var9[var12 + 0 + (var11 + 1) * var7];
/* 34 */         int var14 = var9[var12 + 2 + (var11 + 1) * var7];
/* 35 */         int var15 = var9[var12 + 1 + (var11 + 0) * var7];
/* 36 */         int var16 = var9[var12 + 1 + (var11 + 2) * var7];
/* 37 */         int var17 = var9[var12 + 1 + (var11 + 1) * var7];
/*    */         
/* 39 */         if (var13 == var14 && var15 == var16) {
/*    */           
/* 41 */           func_75903_a((var12 + par1), (var11 + par2));
/* 42 */           if (func_75902_a(2) == 0) {
/* 43 */             var17 = var13;
/*    */           } else {
/* 45 */             var17 = var15;
/*    */           } 
/*    */         } else {
/*    */           
/* 49 */           if (var13 == var14)
/* 50 */             var17 = var13; 
/* 51 */           if (var15 == var16)
/* 52 */             var17 = var15; 
/*    */         } 
/* 54 */         if (var17 < 0)
/*    */           try {
/* 56 */             throw new Exception();
/* 57 */           } catch (Exception e) {
/*    */             
/* 59 */             TerraFirmaCraft.LOG.catching(e);
/*    */           }  
/* 61 */         var10[var12 + var11 * par3] = var17;
/*    */       } 
/*    */     } 
/* 64 */     return var10;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\GenLayerSmoothTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */