/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BarrelPreservativeRecipe
/*     */ {
/*     */   private boolean requiresBrined;
/*     */   private boolean requiresPickled;
/*     */   private boolean requiresSalted;
/*     */   private boolean requiresDried;
/*     */   private boolean requiresSmoked;
/*     */   private boolean requiresInfused;
/*     */   private boolean requiresSealed;
/*     */   private boolean allowGrains = true;
/*     */   private boolean allowProteins = true;
/*     */   private boolean allowVegetables = true;
/*     */   private boolean allowFruit = true;
/*     */   private boolean allowDairy = true;
/*     */   private FluidStack liquidPerOz;
/*  30 */   private float environmentalDecayFactor = -1.0F;
/*  31 */   private float baseDecayModifier = -1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String preservingString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkForPreservation(TEBarrel barrel, FluidStack fluid, ItemStack itemStack, boolean sealed) {
/*  45 */     if (itemStack == null || fluid == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!(itemStack.func_77973_b() instanceof IFood))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (fluid.getFluid() != this.liquidPerOz.getFluid())
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     IFood iFood = (IFood)itemStack.func_77973_b();
/*  58 */     if (!this.allowGrains && iFood.getFoodGroup() == EnumFoodGroup.Grain)
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!this.allowProteins && iFood.getFoodGroup() == EnumFoodGroup.Protein)
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (!this.allowFruit && iFood.getFoodGroup() == EnumFoodGroup.Fruit)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     if (!this.allowVegetables && iFood.getFoodGroup() == EnumFoodGroup.Vegetable)
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     if (!this.allowDairy && iFood.getFoodGroup() == EnumFoodGroup.Dairy)
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     if (this.requiresBrined && !Food.isBrined(itemStack))
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     if (this.requiresPickled && !Food.isPickled(itemStack))
/*     */     {
/*  84 */       return false;
/*     */     }
/*  86 */     if (this.requiresSalted && !Food.isSalted(itemStack))
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     if (this.requiresDried && !Food.isDried(itemStack))
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     if (this.requiresSmoked && !Food.isSmoked(itemStack))
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     if (this.requiresInfused && !Food.isInfused(itemStack))
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     if (this.requiresSealed && !sealed)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     float w = Food.getWeight(itemStack);
/* 107 */     return (this.liquidPerOz.amount * w <= fluid.amount);
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe(FluidStack liquidPerOz, String unlocalizedPreservingLabel) {
/* 111 */     this.liquidPerOz = liquidPerOz;
/* 112 */     this.preservingString = unlocalizedPreservingLabel;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresBrined(boolean b) {
/* 117 */     this.requiresBrined = b;
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresPickled(boolean b) {
/* 123 */     this.requiresPickled = b;
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresSalted(boolean b) {
/* 129 */     this.requiresSalted = b;
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresDried(boolean b) {
/* 135 */     this.requiresDried = b;
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresSmoked(boolean b) {
/* 141 */     this.requiresSmoked = b;
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresInfused(boolean b) {
/* 147 */     this.requiresInfused = b;
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelPreservativeRecipe setRequiresSealed(boolean b) {
/* 153 */     this.requiresSealed = b;
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setAllowProtien(boolean b) {
/* 158 */     this.allowProteins = b;
/* 159 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setAllowGrains(boolean b) {
/* 163 */     this.allowGrains = b;
/* 164 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setAllowFruit(boolean b) {
/* 168 */     this.allowFruit = b;
/* 169 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setAllowVegetable(boolean b) {
/* 173 */     this.allowVegetables = b;
/* 174 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setAllowDairy(boolean b) {
/* 178 */     this.allowDairy = b;
/* 179 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setEnvironmentalDecayFactor(float rate) {
/* 183 */     this.environmentalDecayFactor = rate;
/* 184 */     return this;
/*     */   }
/*     */   
/*     */   public BarrelPreservativeRecipe setBaseDecayModifier(float rate) {
/* 188 */     this.baseDecayModifier = rate;
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getEnvironmentalDecayFactor() {
/* 194 */     return this.environmentalDecayFactor;
/*     */   }
/*     */   
/*     */   public float getBaseDecayModifier() {
/* 198 */     return this.baseDecayModifier;
/*     */   }
/*     */   
/*     */   public String getPreservingString() {
/* 202 */     return this.preservingString;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelPreservativeRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */