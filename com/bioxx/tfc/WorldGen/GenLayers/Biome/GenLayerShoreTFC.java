/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ 
/*    */ public class GenLayerShoreTFC
/*    */   extends GenLayerTFC
/*    */ {
/*    */   public GenLayerShoreTFC(long par1, GenLayer par3GenLayer) {
/* 14 */     super(par1);
/* 15 */     this.field_75909_a = (GenLayerTFC)par3GenLayer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 25 */     int[] var5 = this.field_75909_a.func_75904_a(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
/* 26 */     int[] var6 = IntCache.func_76445_a(par3 * par4);
/*    */     
/* 28 */     for (int var7 = 0; var7 < par4; var7++) {
/*    */       
/* 30 */       for (int var8 = 0; var8 < par3; var8++) {
/*    */         
/* 32 */         func_75903_a((var7 + par1), (var8 + par2));
/* 33 */         int var9 = var5[var8 + 1 + (var7 + 1) * (par3 + 2)];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 39 */         if (!TFC_Core.isOceanicBiome(var9) && var9 != TFCBiome.RIVER.field_76756_M && var9 != TFCBiome.SWAMPLAND.field_76756_M && var9 != TFCBiome.HIGH_HILLS.field_76756_M) {
/*    */           
/* 41 */           int var10 = var5[var8 + 1 + (var7 + 1 - 1) * (par3 + 2)];
/* 42 */           int var11 = var5[var8 + 1 + 1 + (var7 + 1) * (par3 + 2)];
/* 43 */           int var12 = var5[var8 + 1 - 1 + (var7 + 1) * (par3 + 2)];
/* 44 */           int var13 = var5[var8 + 1 + (var7 + 1 + 1) * (par3 + 2)];
/*    */           
/* 46 */           if (!TFC_Core.isOceanicBiome(var10) && !TFC_Core.isOceanicBiome(var11) && !TFC_Core.isOceanicBiome(var12) && !TFC_Core.isOceanicBiome(var13)) {
/* 47 */             var6[var8 + var7 * par3] = var9;
/*    */           } else {
/*    */             
/* 50 */             int beachid = TFCBiome.BEACH.field_76756_M;
/* 51 */             if (TFC_Core.isMountainBiome(var9))
/* 52 */               beachid = TFCBiome.GRAVEL_BEACH.field_76756_M; 
/* 53 */             var6[var8 + var7 * par3] = beachid;
/*    */           }
/*    */         
/*    */         } else {
/*    */           
/* 58 */           var6[var8 + var7 * par3] = var9;
/*    */         } 
/*    */         
/* 61 */         validateInt(var6, var8 + var7 * par3);
/*    */       } 
/*    */     } 
/* 64 */     return var6;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerShoreTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */