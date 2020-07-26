/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import com.bioxx.tfc.WorldGen.TFCWorldType;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerBiomeTFC
/*    */   extends GenLayerTFC
/*    */ {
/* 14 */   private TFCBiome[] allowedBiomes = new TFCBiome[] { TFCBiome.OCEAN, TFCBiome.HIGH_HILLS, TFCBiome.PLAINS, TFCBiome.HIGH_PLAINS, TFCBiome.SWAMPLAND, TFCBiome.ROLLING_HILLS, TFCBiome.MOUNTAINS };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public GenLayerBiomeTFC(long par1, GenLayer par3GenLayer, TFCWorldType par4) {
/* 26 */     super(par1);
/* 27 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 37 */     int[] var5 = this.field_75909_a.func_75904_a(par1, par2, par3, par4);
/* 38 */     validateIntArray(var5, par3, par4);
/* 39 */     int[] var6 = IntCache.func_76445_a(par3 * par4);
/*    */     
/* 41 */     for (int var7 = 0; var7 < par4; var7++) {
/*    */       
/* 43 */       for (int var8 = 0; var8 < par3; var8++) {
/*    */         
/* 45 */         func_75903_a((var8 + par1), (var7 + par2));
/* 46 */         int id = var5[var8 + var7 * par3];
/* 47 */         if (TFC_Core.isOceanicBiome(id)) {
/* 48 */           var6[var8 + var7 * par3] = id;
/*    */         } else {
/* 50 */           var6[var8 + var7 * par3] = (this.allowedBiomes[func_75902_a(this.allowedBiomes.length)]).field_76756_M;
/*    */         } 
/* 52 */         validateInt(var6, var8 + var7 * par3);
/*    */       } 
/*    */     } 
/* 55 */     return var6;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerBiomeTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */