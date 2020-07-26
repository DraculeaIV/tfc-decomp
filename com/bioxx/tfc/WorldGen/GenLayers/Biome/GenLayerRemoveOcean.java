/*    */ package com.bioxx.tfc.WorldGen.GenLayers.Biome;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ public class GenLayerRemoveOcean
/*    */   extends GenLayerTFC
/*    */ {
/*    */   private final int chance;
/*    */   private final boolean checkType;
/*    */   
/*    */   public GenLayerRemoveOcean(long par1, GenLayerTFC parent, int chance, boolean ct) {
/* 13 */     super(par1);
/* 14 */     this.field_75909_a = parent;
/* 15 */     this.chance = chance;
/* 16 */     this.checkType = ct;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int par1, int par2, int par3, int par4) {
/* 26 */     int i1 = par1 - 1;
/* 27 */     int j1 = par2 - 1;
/* 28 */     int k1 = par3 + 2;
/* 29 */     int l1 = par4 + 2;
/* 30 */     int[] biomes = this.field_75909_a.func_75904_a(i1, j1, k1, l1);
/* 31 */     int[] out = IntCache.func_76445_a(par3 * par4);
/*    */     
/* 33 */     for (int i2 = 0; i2 < par4; i2++) {
/*    */       
/* 35 */       for (int j2 = 0; j2 < par3; j2++) {
/*    */         
/* 37 */         int k2 = biomes[j2 + 1 + (i2 + 1 - 1) * (par3 + 2)];
/* 38 */         int l2 = biomes[j2 + 1 + 1 + (i2 + 1) * (par3 + 2)];
/* 39 */         int i3 = biomes[j2 + 1 - 1 + (i2 + 1) * (par3 + 2)];
/* 40 */         int j3 = biomes[j2 + 1 + (i2 + 1 + 1) * (par3 + 2)];
/* 41 */         int biome = biomes[j2 + 1 + (i2 + 1) * k1];
/* 42 */         out[j2 + i2 * par3] = biome;
/* 43 */         func_75903_a((j2 + par1), (i2 + par2));
/*    */         
/* 45 */         if (this.checkType && biome == 0 && k2 == 0 && l2 == 0 && i3 == 0 && j3 == 0 && func_75902_a(this.chance) == 0) {
/*    */           
/* 47 */           out[j2 + i2 * par3] = 1;
/*    */         }
/* 49 */         else if (!this.checkType && biome == 0 && k2 != 0 && l2 != 0 && i3 != 0 && j3 != 0) {
/*    */           
/* 51 */           out[j2 + i2 * par3] = 1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     return out;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\Biome\GenLayerRemoveOcean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */