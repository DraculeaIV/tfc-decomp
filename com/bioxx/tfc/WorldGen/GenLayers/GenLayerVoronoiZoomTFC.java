/*    */ package com.bioxx.tfc.WorldGen.GenLayers;
/*    */ 
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ public class GenLayerVoronoiZoomTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerVoronoiZoomTFC(long par1, GenLayer par3GenLayer) {
/*  9 */     super(par1);
/* 10 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 16 */     par1 -= 2;
/* 17 */     par2 -= 2;
/* 18 */     int i1 = par1 >> 2;
/* 19 */     int j1 = par2 >> 2;
/* 20 */     int k1 = (par3 >> 2) + 2;
/* 21 */     int l1 = (par4 >> 2) + 2;
/* 22 */     int[] aint = this.field_75909_a.func_75904_a(i1, j1, k1, l1);
/* 23 */     int i2 = k1 - 1 << 2;
/* 24 */     int j2 = l1 - 1 << 2;
/* 25 */     int[] aint1 = new int[i2 * j2];
/*    */ 
/*    */     
/* 28 */     for (int k2 = 0; k2 < l1 - 1; k2++) {
/*    */       
/* 30 */       int i = 0;
/* 31 */       int i3 = aint[i + 0 + (k2 + 0) * k1];
/*    */       
/* 33 */       for (int j3 = aint[i + 0 + (k2 + 1) * k1]; i < k1 - 1; i++) {
/*    */ 
/*    */         
/* 36 */         func_75903_a((i + i1 << 2), (k2 + j1 << 2));
/* 37 */         double d1 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 38 */         double d2 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 39 */         func_75903_a((i + i1 + 1 << 2), (k2 + j1 << 2));
/* 40 */         double d3 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 41 */         double d4 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 42 */         func_75903_a((i + i1 << 2), (k2 + j1 + 1 << 2));
/* 43 */         double d5 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 44 */         double d6 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 45 */         func_75903_a((i + i1 + 1 << 2), (k2 + j1 + 1 << 2));
/* 46 */         double d7 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 47 */         double d8 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 48 */         int k3 = aint[i + 1 + (k2 + 0) * k1] & 0xFF;
/* 49 */         int l3 = aint[i + 1 + (k2 + 1) * k1] & 0xFF;
/*    */         
/* 51 */         for (int i4 = 0; i4 < 4; i4++) {
/*    */           
/* 53 */           int j4 = ((k2 << 2) + i4) * i2 + (i << 2);
/*    */           
/* 55 */           for (int k4 = 0; k4 < 4; k4++) {
/*    */             
/* 57 */             double d9 = (i4 - d2) * (i4 - d2) + (k4 - d1) * (k4 - d1);
/* 58 */             double d10 = (i4 - d4) * (i4 - d4) + (k4 - d3) * (k4 - d3);
/* 59 */             double d11 = (i4 - d6) * (i4 - d6) + (k4 - d5) * (k4 - d5);
/* 60 */             double d12 = (i4 - d8) * (i4 - d8) + (k4 - d7) * (k4 - d7);
/*    */             
/* 62 */             if (d9 < d10 && d9 < d11 && d9 < d12) {
/*    */               
/* 64 */               aint1[j4++] = i3;
/*    */             }
/* 66 */             else if (d10 < d9 && d10 < d11 && d10 < d12) {
/*    */               
/* 68 */               aint1[j4++] = k3;
/*    */             }
/* 70 */             else if (d11 < d9 && d11 < d10 && d11 < d12) {
/*    */               
/* 72 */               aint1[j4++] = j3;
/*    */             }
/*    */             else {
/*    */               
/* 76 */               aint1[j4++] = l3;
/*    */             } 
/*    */           } 
/*    */         } 
/*    */         
/* 81 */         i3 = k3;
/* 82 */         j3 = l3;
/*    */       } 
/*    */     } 
/*    */     
/* 86 */     int[] aint2 = new int[par3 * par4];
/*    */     
/* 88 */     for (int l2 = 0; l2 < par4; l2++)
/*    */     {
/* 90 */       System.arraycopy(aint1, (l2 + (par2 & 0x3)) * i2 + (par1 & 0x3), aint2, l2 * par3, par3);
/*    */     }
/*    */     
/* 93 */     return aint2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\GenLayerVoronoiZoomTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */