/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import java.util.Stack;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BarrelRecipe
/*     */ {
/*     */   public ItemStack recipeIS;
/*     */   public FluidStack recipeFluid;
/*     */   public ItemStack recipeOutIS;
/*     */   public FluidStack recipeOutFluid;
/*  18 */   public int sealTime = 8;
/*     */   public boolean removesLiquid = true;
/*     */   public boolean sealedRecipe = true;
/*  21 */   public int minTechLevel = 1;
/*     */   
/*     */   public boolean allowAnyStack = true;
/*     */   
/*     */   public BarrelRecipe(ItemStack inputItem, FluidStack inputFluid, ItemStack outIS, FluidStack outputFluid) {
/*  26 */     this.recipeIS = inputItem;
/*  27 */     this.recipeFluid = inputFluid;
/*  28 */     this.recipeOutIS = outIS;
/*  29 */     this.recipeOutFluid = outputFluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelRecipe(ItemStack inputItem, FluidStack inputFluid, ItemStack outIS, FluidStack outputFluid, int seal) {
/*  34 */     this(inputItem, inputFluid, outIS, outputFluid);
/*  35 */     this.sealTime = seal;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelRecipe setRemovesLiquid(boolean b) {
/*  40 */     this.removesLiquid = b;
/*  41 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelRecipe setAllowAnyStack(boolean b) {
/*  46 */     this.allowAnyStack = b;
/*  47 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelRecipe setMinTechLevel(int t) {
/*  52 */     this.minTechLevel = t;
/*  53 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarrelRecipe setSealedRecipe(boolean b) {
/*  58 */     this.sealedRecipe = b;
/*  59 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean matches(ItemStack item, FluidStack fluid) {
/*  64 */     boolean iStack = this.removesLiquid ? true : ((this.recipeIS != null && item != null && fluid != null && this.recipeFluid != null && item.field_77994_a >= (int)Math.ceil((fluid.amount / this.recipeFluid.amount))));
/*  65 */     boolean fStack = !this.removesLiquid ? true : ((this.recipeFluid != null && item != null && fluid != null && this.recipeOutFluid != null && fluid.amount >= item.field_77994_a * this.recipeOutFluid.amount));
/*     */     
/*  67 */     boolean anyStack = (!this.removesLiquid && !this.sealedRecipe && this.recipeOutIS == null && this.allowAnyStack);
/*  68 */     boolean itemsEqual = ((item == null && this.recipeIS == null) || OreDictionary.itemMatches(this.recipeIS, item, false));
/*     */     
/*  70 */     return Boolean.valueOf((((this.recipeIS != null && itemsEqual && (iStack || anyStack)) || this.recipeIS == null) && ((this.recipeFluid != null && this.recipeFluid
/*  71 */         .isFluidEqual(fluid) && (fStack || anyStack)) || this.recipeFluid == null)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isInFluid(FluidStack item) {
/*  76 */     return Boolean.valueOf(this.recipeFluid.isFluidEqual(item));
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getInItem() {
/*  81 */     return this.recipeIS;
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack getInFluid() {
/*  86 */     return this.recipeFluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getRecipeOutIS() {
/*  91 */     return this.recipeOutIS;
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack getRecipeOutFluid() {
/*  96 */     return this.recipeOutFluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSealTime() {
/* 101 */     return this.sealTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRemovesLiquid() {
/* 106 */     return this.removesLiquid;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinTechLevel() {
/* 111 */     return this.minTechLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAllowAnyStack() {
/* 116 */     return this.allowAnyStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecipeName() {
/* 121 */     String s = "";
/* 122 */     if (this.recipeOutIS != null) {
/*     */       
/* 124 */       if (this.recipeOutIS.field_77994_a > 1)
/* 125 */         s = s + this.recipeOutIS.field_77994_a + "x "; 
/* 126 */       s = s + this.recipeOutIS.func_82833_r();
/*     */     } 
/* 128 */     if (this.recipeOutFluid != null && !this.recipeFluid.isFluidEqual(this.recipeOutFluid))
/* 129 */       s = this.recipeOutFluid.getFluid().getLocalizedName(this.recipeOutFluid); 
/* 130 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSealedRecipe() {
/* 135 */     return this.sealedRecipe;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getnumberOfRuns(ItemStack inIS, FluidStack inFS) {
/* 140 */     int runs = 0;
/* 141 */     int div = 0;
/* 142 */     if (inIS != null && this.recipeIS != null) {
/*     */       
/* 144 */       runs = inIS.field_77994_a / this.recipeIS.field_77994_a;
/* 145 */       div = inFS.amount / (getInFluid()).amount;
/*     */     } 
/* 147 */     return Math.min(runs, div);
/*     */   }
/*     */ 
/*     */   
/*     */   public Stack<ItemStack> getResult(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 152 */     Stack<ItemStack> stackList = new Stack<ItemStack>();
/* 153 */     ItemStack outStack = null;
/*     */     
/* 155 */     if (this.recipeOutIS != null) {
/*     */       
/* 157 */       stackList.clear();
/* 158 */       outStack = this.recipeOutIS.func_77946_l();
/* 159 */       int outputCount = outStack.field_77994_a * getnumberOfRuns(inIS, inFS);
/* 160 */       int maxStackSize = outStack.func_77976_d();
/* 161 */       Item item = outStack.func_77973_b();
/* 162 */       int damage = outStack.func_77960_j();
/*     */       
/* 164 */       int remainder = outputCount % maxStackSize;
/* 165 */       if (remainder > 0) {
/*     */         
/* 167 */         stackList.push(new ItemStack(item, remainder, damage));
/* 168 */         outputCount -= remainder;
/*     */       } 
/*     */       
/* 171 */       while (outputCount >= maxStackSize) {
/*     */         
/* 173 */         stackList.push(new ItemStack(item, maxStackSize, damage));
/* 174 */         outputCount -= maxStackSize;
/*     */       } 
/* 176 */       return stackList;
/*     */     } 
/*     */     
/* 179 */     if (!this.removesLiquid && inIS != null && inFS != null) {
/*     */       
/* 181 */       stackList.clear();
/* 182 */       outStack = inIS.func_77946_l();
/* 183 */       outStack.field_77994_a -= inFS.amount / this.recipeOutFluid.amount;
/* 184 */       stackList.push(outStack);
/*     */     } 
/* 186 */     if (outStack == null) {
/*     */       
/* 188 */       stackList.clear();
/* 189 */       stackList.push(outStack);
/*     */     } 
/* 191 */     return stackList;
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack getResultFluid(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 196 */     if (this.recipeOutFluid != null) {
/*     */       
/* 198 */       FluidStack fs = null;
/*     */       
/* 200 */       if (this.recipeOutFluid.tag != null) {
/*     */         
/* 202 */         fs = new FluidStack(this.recipeOutFluid.getFluid(), this.recipeOutFluid.amount, (NBTTagCompound)this.recipeOutFluid.tag.func_74737_b());
/*     */       }
/*     */       else {
/*     */         
/* 206 */         fs = new FluidStack(this.recipeOutFluid.getFluid(), this.recipeOutFluid.amount);
/*     */       } 
/*     */       
/* 209 */       if (!this.removesLiquid && inFS != null) {
/*     */         
/* 211 */         fs.amount = inFS.amount;
/*     */       }
/* 213 */       else if (inIS != null) {
/*     */         
/* 215 */         fs.amount *= inIS.field_77994_a;
/*     */       } 
/* 217 */       return fs;
/*     */     } 
/* 219 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */