/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerIslandTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerIslandTFC(long par1) {
/* 11 */     super(par1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int maxX, int maxZ) {
/* 21 */     int[] var5 = IntCache.func_76445_a(maxX * maxZ);
/*    */     
/* 23 */     for (int z = 0; z < maxZ; z++) {
/*    */       
/* 25 */       for (int x = 0; x < maxX; x++) {
/*    */         
/* 27 */         func_75903_a((par1 + x), (par2 + z));
/* 28 */         var5[x + z * maxX] = (func_75902_a(4) == 0) ? 1 : 0;
/*    */       } 
/*    */     } 
/*    */     
/* 32 */     if (par1 > -maxX && par1 <= 0 && par2 > -maxZ && par2 <= 0) {
/* 33 */       var5[-par1 + -par2 * maxX] = 1;
/*    */     }
/* 35 */     return var5;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerIslandTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */