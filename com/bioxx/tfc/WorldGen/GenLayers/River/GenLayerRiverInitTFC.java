/*    */ package com.bioxx.tfc.WorldGen.GenLayers.River;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ 
/*    */ 
/*    */ public class GenLayerRiverInitTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerRiverInitTFC(long par1, GenLayer par3GenLayer) {
/* 12 */     super(par1);
/* 13 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int xCoord, int zCoord, int xSize, int zSize) {
/* 22 */     int[] parentCache = this.field_75909_a.func_75904_a(xCoord, zCoord, xSize, zSize);
/* 23 */     int[] outCache = new int[xSize * zSize];
/*    */     
/* 25 */     for (int z = 0; z < zSize; z++) {
/*    */       
/* 27 */       for (int x = 0; x < xSize; x++) {
/*    */         
/* 29 */         func_75903_a((x + xCoord), (z + zCoord));
/* 30 */         int index = x + z * xSize;
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 35 */         int id = parentCache[index];
/* 36 */         outCache[index] = (!TFC_Core.isOceanicBiome(id) && !TFC_Core.isMountainBiome(id)) ? 1 : 0;
/*    */       } 
/*    */     } 
/* 39 */     return outCache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\River\GenLayerRiverInitTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */