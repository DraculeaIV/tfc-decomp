/*     */ package com.bioxx.tfc.Food;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FloraIndex
/*     */ {
/*     */   public String type;
/*     */   public int bloomStart;
/*     */   public int bloomFinish;
/*     */   public int harvestStart;
/*     */   public int harvestFinish;
/*  15 */   public int fruitHangTime = 1;
/*     */   public float minTemp;
/*  17 */   public float maxTemp = 38.0F;
/*  18 */   public float minBioTemp = 10.0F;
/*  19 */   public float maxBioTemp = 30.0F;
/*  20 */   public float minRain = 125.0F;
/*  21 */   public float maxRain = 2000.0F;
/*     */   public float minEVT;
/*  23 */   public float maxEVT = 16.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack output;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloraIndex(String n, int b1, int b2, int h1, int h2, ItemStack o) {
/*  35 */     this.minEVT = 0.25F;
/*  36 */     this.type = n;
/*  37 */     this.bloomStart = b1;
/*  38 */     this.bloomFinish = b2;
/*  39 */     this.harvestStart = h1;
/*  40 */     this.harvestFinish = h2;
/*  41 */     this.output = o;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex(String n, int h1, int h2, ItemStack o) {
/*  46 */     this.minEVT = 0.25F;
/*  47 */     this.type = n;
/*  48 */     this.bloomStart = 0;
/*  49 */     this.bloomFinish = 0;
/*  50 */     this.harvestStart = h1;
/*  51 */     this.harvestFinish = h2;
/*  52 */     this.output = o;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex setHangTime(int time) {
/*  57 */     this.fruitHangTime = time;
/*  58 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex setBioTemp(float min, float max) {
/*  63 */     this.minBioTemp = min;
/*  64 */     this.maxBioTemp = max;
/*  65 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex setRain(float min, float max) {
/*  70 */     this.minRain = min;
/*  71 */     this.maxRain = max;
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex setEVT(float min, float max) {
/*  77 */     this.minEVT = min;
/*  78 */     this.maxEVT = max;
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getOutput(Random r, int i) {
/*  84 */     ItemStack is = this.output.func_77946_l();
/*  85 */     is.field_77994_a += r.nextInt(i);
/*  86 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getOutput() {
/*  91 */     return this.output.func_77946_l();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inHarvest(int month) {
/*  96 */     return (month >= this.harvestStart && month <= this.harvestFinish);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean inBloom(int month) {
/* 101 */     return (month >= this.bloomStart && month <= this.bloomFinish);
/*     */   }
/*     */ 
/*     */   
/*     */   public FloraIndex setTemp(float min, float max) {
/* 106 */     this.minTemp = min;
/* 107 */     this.maxTemp = max;
/* 108 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\FloraIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */