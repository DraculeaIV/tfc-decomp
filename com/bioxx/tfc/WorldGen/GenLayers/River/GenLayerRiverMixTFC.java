/*     */ package com.bioxx.tfc.WorldGen.GenLayers.River;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ 
/*     */ public class GenLayerRiverMixTFC
/*     */   extends GenLayerTFC
/*     */ {
/*     */   private GenLayer biomePatternGeneratorChain;
/*     */   private GenLayer riverPatternGeneratorChain;
/*     */   private int[] layerBiomes;
/*     */   private int[] layerRivers;
/*     */   private int[] layerOut;
/*     */   private int xn;
/*     */   private int xp;
/*     */   private int zn;
/*     */   private int zp;
/*     */   
/*     */   public GenLayerRiverMixTFC(long par1, GenLayer par3GenLayer, GenLayer par4GenLayer) {
/*  23 */     super(par1);
/*  24 */     this.biomePatternGeneratorChain = par3GenLayer;
/*  25 */     this.riverPatternGeneratorChain = par4GenLayer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] func_75904_a(int x, int z, int xSize, int zSize) {
/*  35 */     this.layerBiomes = this.biomePatternGeneratorChain.func_75904_a(x, z, xSize, zSize);
/*  36 */     this.layerRivers = this.riverPatternGeneratorChain.func_75904_a(x, z, xSize, zSize);
/*  37 */     this.layerOut = new int[xSize * zSize];
/*     */     
/*  39 */     for (int zElement = 0; zElement < zSize; zElement++) {
/*     */       
/*  41 */       for (int xElement = 0; xElement < xSize; xElement++) {
/*     */         
/*  43 */         int index = xElement + zElement * xSize;
/*  44 */         int b = this.layerBiomes[index];
/*  45 */         int r = this.layerRivers[index];
/*     */         
/*  47 */         this.xn = index - 1;
/*  48 */         this.xp = index + 1;
/*  49 */         this.zn = index - zSize;
/*  50 */         this.zp = index + zSize;
/*     */         
/*  52 */         if (TFC_Core.isOceanicBiome(b) || TFC_Core.isMountainBiome(b)) {
/*  53 */           this.layerOut[index] = b;
/*  54 */         } else if (r > 0) {
/*     */           
/*  56 */           this.layerOut[index] = r;
/*     */ 
/*     */           
/*  59 */           if (TFC_Core.isBeachBiome(b)) {
/*     */             
/*  61 */             this.layerOut[index] = TFCBiome.OCEAN.field_76756_M;
/*  62 */             if (inBounds(this.xn, this.layerOut) && this.layerOut[this.xn] == TFCBiome.RIVER.field_76756_M)
/*     */             {
/*  64 */               this.layerOut[this.xn] = TFCBiome.OCEAN.field_76756_M;
/*     */             }
/*  66 */             if (inBounds(this.zn, this.layerOut) && this.layerOut[this.zn] == TFCBiome.RIVER.field_76756_M)
/*     */             {
/*  68 */               this.layerOut[this.zn] = TFCBiome.OCEAN.field_76756_M;
/*     */             }
/*  70 */             if (inBounds(this.zp, this.layerOut) && TFC_Core.isOceanicBiome(this.layerBiomes[this.zp]) && this.layerRivers[this.zp] == 0)
/*     */             {
/*  72 */               this.layerOut[index] = b;
/*     */             }
/*  74 */             if (inBounds(this.zn, this.layerOut) && TFC_Core.isOceanicBiome(this.layerBiomes[this.zn]) && this.layerRivers[this.zn] == 0)
/*     */             {
/*  76 */               this.layerOut[index] = b;
/*     */             }
/*  78 */             if (inBounds(this.xn, this.layerOut) && TFC_Core.isOceanicBiome(this.layerBiomes[this.xn]) && this.layerRivers[this.xn] == 0)
/*     */             {
/*  80 */               this.layerOut[index] = b;
/*     */             }
/*  82 */             if (inBounds(this.xp, this.layerOut) && TFC_Core.isOceanicBiome(this.layerBiomes[this.xp]) && this.layerRivers[this.xp] == 0)
/*     */             {
/*  84 */               this.layerOut[index] = b;
/*     */             }
/*     */           } 
/*     */         } else {
/*     */           
/*  89 */           this.layerOut[index] = b;
/*     */         } 
/*     */         
/*  92 */         removeRiver(index, TFCBiome.LAKE.field_76756_M);
/*  93 */         removeRiver(index, TFCBiome.MOUNTAINS_EDGE.field_76756_M);
/*     */         
/*  95 */         validateInt(this.layerOut, index);
/*     */       } 
/*     */     } 
/*  98 */     return (int[])this.layerOut.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRiver(int index, int biomeToReplaceWith) {
/* 103 */     if (this.layerOut[index] == TFCBiome.RIVER.field_76756_M) {
/*     */       
/* 105 */       if (this.xn >= 0 && this.layerBiomes[this.xn] == biomeToReplaceWith)
/*     */       {
/* 107 */         this.layerOut[index] = biomeToReplaceWith;
/*     */       }
/* 109 */       if (this.zn >= 0 && this.layerBiomes[this.zn] == biomeToReplaceWith)
/*     */       {
/* 111 */         this.layerOut[index] = biomeToReplaceWith;
/*     */       }
/* 113 */       if (this.xp < this.layerBiomes.length && this.layerBiomes[this.xp] == biomeToReplaceWith)
/*     */       {
/* 115 */         this.layerOut[index] = biomeToReplaceWith;
/*     */       }
/* 117 */       if (this.zp < this.layerBiomes.length && this.layerBiomes[this.zp] == biomeToReplaceWith)
/*     */       {
/* 119 */         this.layerOut[index] = biomeToReplaceWith;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inBounds(int index, int[] array) {
/* 126 */     return (index < array.length && index >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/* 136 */     this.biomePatternGeneratorChain.func_75905_a(par1);
/* 137 */     this.riverPatternGeneratorChain.func_75905_a(par1);
/* 138 */     super.func_75905_a(par1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\River\GenLayerRiverMixTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */