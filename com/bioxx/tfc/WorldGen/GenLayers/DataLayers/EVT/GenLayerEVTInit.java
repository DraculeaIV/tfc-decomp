/*    */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.EVT;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ 
/*    */ public class GenLayerEVTInit
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerEVTInit(long par1) {
/*  9 */     super(par1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int maxX, int maxZ) {
/* 19 */     int[] outCache = new int[maxX * maxZ];
/*    */     
/* 21 */     for (int z = 0; z < maxZ; z++) {
/*    */       
/* 23 */       for (int x = 0; x < maxX; x++) {
/*    */         
/* 25 */         func_75903_a((par1 + x), (par2 + z));
/* 26 */         int out = GenEVTLayer.LOW + func_75902_a(4);
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 31 */         if (out == GenEVTLayer.LOW && func_75902_a(4) == 0) {
/* 32 */           out += 1 + func_75902_a(2);
/*    */         }
/* 34 */         if (out == GenEVTLayer.LOW && func_75902_a(12) == 0)
/* 35 */           out--; 
/* 36 */         if (out == GenEVTLayer.HIGH && func_75902_a(12) == 0) {
/* 37 */           out++;
/*    */         }
/* 39 */         outCache[x + z * maxX] = out;
/*    */       } 
/*    */     } 
/*    */     
/* 43 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\EVT\GenLayerEVTInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */