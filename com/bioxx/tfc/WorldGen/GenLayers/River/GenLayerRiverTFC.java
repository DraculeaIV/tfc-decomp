/*    */ package com.bioxx.tfc.WorldGen.GenLayers.River;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ public class GenLayerRiverTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerRiverTFC(long par1, GenLayer par3GenLayer) {
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
/* 23 */     int i1 = par1 - 1;
/* 24 */     int j1 = par2 - 1;
/* 25 */     int k1 = par3 + 2;
/* 26 */     int l1 = par4 + 2;
/* 27 */     int[] aint = this.field_75909_a.func_75904_a(i1, j1, k1, l1);
/* 28 */     int[] aint1 = new int[par3 * par4];
/*    */     
/* 30 */     for (int i2 = 0; i2 < par4; i2++) {
/*    */       
/* 32 */       for (int j2 = 0; j2 < par3; j2++) {
/*    */         
/* 34 */         int k2 = calcWidth(aint[j2 + 0 + (i2 + 1) * k1]);
/* 35 */         int l2 = calcWidth(aint[j2 + 2 + (i2 + 1) * k1]);
/* 36 */         int i3 = calcWidth(aint[j2 + 1 + (i2 + 0) * k1]);
/* 37 */         int j3 = calcWidth(aint[j2 + 1 + (i2 + 2) * k1]);
/* 38 */         int k3 = calcWidth(aint[j2 + 1 + (i2 + 1) * k1]);
/*    */         
/* 40 */         if (k3 == k2 && k3 == i3 && k3 == l2 && k3 == j3) {
/*    */           
/* 42 */           aint1[j2 + i2 * par3] = 0;
/*    */         }
/*    */         else {
/*    */           
/* 46 */           aint1[j2 + i2 * par3] = TFCBiome.RIVER.field_76756_M;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     return aint1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int calcWidth(int i) {
/* 56 */     return (i >= 2) ? (2 + (i & 0x1)) : i;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\River\GenLayerRiverTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */