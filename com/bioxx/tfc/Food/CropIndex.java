/*     */ package com.bioxx.tfc.Food;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CropIndex
/*     */ {
/*     */   public int growthTime;
/*     */   public String cropName;
/*     */   public int cycleType;
/*     */   public int cropId;
/*     */   public int numGrowthStages;
/*     */   public float minGrowthTemp;
/*     */   public float minAliveTemp;
/*     */   public float nutrientUsageMult;
/*     */   public int[] nutrientExtraRestore;
/*     */   public boolean dormantInFrost;
/*  28 */   public int maxLifespan = -1;
/*     */   
/*  30 */   public int chanceForOutput1 = 100;
/*     */   
/*     */   public Item output1;
/*     */   public float output1Avg;
/*  34 */   public int chanceForOutput2 = 100;
/*     */   
/*     */   public Item output2;
/*     */   public float output2Avg;
/*     */   public boolean needsSunlight = true;
/*  39 */   public float waterUsageMult = 1.0F;
/*     */   
/*     */   public Item seedItem;
/*     */   
/*     */   public CropIndex(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, Item seed) {
/*  44 */     this.growthTime = growth;
/*  45 */     this.cycleType = type;
/*  46 */     this.cropName = name.toLowerCase();
/*  47 */     this.cropId = id;
/*  48 */     this.numGrowthStages = stages;
/*  49 */     this.minGrowthTemp = minGTemp;
/*  50 */     this.minAliveTemp = minATemp;
/*  51 */     this.nutrientExtraRestore = new int[] { 0, 0, 0 };
/*  52 */     this.nutrientUsageMult = 1.0F;
/*  53 */     this.dormantInFrost = false;
/*  54 */     this.seedItem = seed;
/*     */   }
/*     */   
/*     */   public CropIndex(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, float nutrientUsageMultiplier, Item seed) {
/*  58 */     this(id, name, type, growth, stages, minGTemp, minATemp, seed);
/*  59 */     this.nutrientUsageMult = nutrientUsageMultiplier;
/*     */   }
/*     */   
/*     */   public CropIndex(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, float nutrientUsageMultiplier, Item seed, int[] nutriRestore) {
/*  63 */     this(id, name, type, growth, stages, minGTemp, minATemp, seed);
/*  64 */     this.nutrientExtraRestore = (int[])nutriRestore.clone();
/*  65 */     this.nutrientUsageMult = nutrientUsageMultiplier;
/*     */   }
/*     */ 
/*     */   
/*     */   public CropIndex setOutput1(Item o, float oAvg) {
/*  70 */     this.output1 = o;
/*  71 */     this.output1Avg = oAvg;
/*  72 */     return this;
/*     */   }
/*     */   
/*     */   public CropIndex setOutput2(Item o, float oAvg) {
/*  76 */     this.output2 = o;
/*  77 */     this.output2Avg = oAvg;
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public CropIndex setOutput1Chance(Item o, float oAvg, int chance) {
/*  82 */     this.output1 = o;
/*  83 */     this.output1Avg = oAvg;
/*  84 */     this.chanceForOutput1 = chance;
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public CropIndex setOutput2Chance(Item o, float oAvg, int chance) {
/*  89 */     this.output2 = o;
/*  90 */     this.output2Avg = oAvg;
/*  91 */     this.chanceForOutput2 = chance;
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public ItemStack getOutput1(TECrop crop) {
/*  96 */     if (this.output1 != null && crop.growth >= this.numGrowthStages) {
/*     */       
/*  98 */       ItemStack is = new ItemStack(this.output1);
/*  99 */       Random r = new Random();
/* 100 */       if (r.nextInt(100) < this.chanceForOutput1) {
/*     */         
/* 102 */         ItemFoodTFC.createTag(is, getWeight(this.output1Avg, r));
/* 103 */         addFlavorProfile(crop, is);
/* 104 */         return is;
/*     */       } 
/*     */     } 
/* 107 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack getOutput2(TECrop crop) {
/* 111 */     if (this.output2 != null && crop.growth >= this.numGrowthStages) {
/*     */       
/* 113 */       ItemStack is = new ItemStack(this.output2);
/* 114 */       Random r = new Random();
/* 115 */       if (r.nextInt(100) < this.chanceForOutput2) {
/*     */         
/* 117 */         ItemFoodTFC.createTag(is, getWeight(this.output2Avg, r));
/* 118 */         addFlavorProfile(crop, is);
/* 119 */         return is;
/*     */       } 
/*     */     } 
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private Random getGrowthRand(TECrop te) {
/* 127 */     Block farmBlock = te.func_145831_w().func_147439_a(te.field_145851_c, te.field_145848_d - 1, te.field_145849_e);
/*     */     
/* 129 */     if (!TFC_Core.isSoil(farmBlock)) {
/*     */ 
/*     */       
/* 132 */       int soilType1 = (farmBlock == TFCBlocks.tilledSoil) ? te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d - 1, te.field_145849_e) : (te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d - 1, te.field_145849_e) + 16);
/*     */       
/* 134 */       int soilType2 = (farmBlock == TFCBlocks.dirt) ? (te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d - 2, te.field_145849_e) * 2) : ((farmBlock == TFCBlocks.dirt2) ? ((te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d - 2, te.field_145849_e) + 16) * 2) : 0);
/*     */       
/* 136 */       int ph = (TFC_Climate.getCacheManager(te.func_145831_w()).getPHLayerAt(te.field_145851_c, te.field_145849_e)).data1 * 100;
/* 137 */       int drainage = 0;
/*     */       
/* 139 */       for (int y = 2; y < 8; y++) {
/*     */         
/* 141 */         if (TFC_Core.isGravel(te.func_145831_w().func_147439_a(te.field_145851_c, te.field_145848_d - y, te.field_145849_e)))
/*     */         {
/* 143 */           drainage++;
/*     */         }
/*     */       } 
/* 146 */       drainage *= 1000;
/*     */       
/* 148 */       return new Random((soilType1 + soilType2 + ph + drainage));
/*     */     } 
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addFlavorProfile(TECrop te, ItemStack outFood) {
/* 155 */     Random r = getGrowthRand(te);
/* 156 */     if (r != null)
/*     */     {
/* 158 */       Food.adjustFlavor(outFood, r);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getWeight(float average, Random r) {
/* 164 */     float weight = average + average * (10.0F * r.nextFloat() - 5.0F) / 100.0F;
/* 165 */     return Helper.roundNumber(weight, 10.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public CropIndex setNeedsSunlight(boolean b) {
/* 170 */     this.needsSunlight = b;
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CropIndex setWaterUsage(float m) {
/* 176 */     this.waterUsageMult = m;
/* 177 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CropIndex setGoesDormant(boolean b) {
/* 182 */     this.dormantInFrost = b;
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getSeed() {
/* 188 */     return new ItemStack(this.seedItem, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCycleType() {
/* 193 */     return this.cycleType;
/*     */   }
/*     */   
/*     */   public void onCropGrow(float stage) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\CropIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */