/*    */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Stability;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.DataLayer;
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ 
/*    */ public class GenLayerStabilityInit
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerStabilityInit(long par1) {
/* 10 */     super(par1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int maxX, int maxZ) {
/* 16 */     int[] cache = new int[maxX * maxZ];
/*    */     
/* 18 */     for (int z = 0; z < maxZ; z++) {
/*    */       
/* 20 */       for (int x = 0; x < maxX; x++) {
/*    */         
/* 22 */         func_75903_a((par1 + x), (par2 + z));
/* 23 */         cache[x + z * maxX] = (func_75902_a(3) == 0) ? DataLayer.SEISMIC_UNSTABLE.layerID : DataLayer.SEISMIC_STABLE.layerID;
/*    */       } 
/*    */     } 
/*    */     
/* 27 */     return cache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Stability\GenLayerStabilityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */