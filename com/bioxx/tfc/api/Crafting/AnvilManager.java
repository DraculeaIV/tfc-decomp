/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class AnvilManager
/*     */ {
/*  14 */   private static final AnvilManager INSTANCE = new AnvilManager();
/*     */   
/*     */   public static final AnvilManager getInstance() {
/*  17 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public static World world;
/*     */   private List<AnvilRecipe> recipes;
/*     */   private List<AnvilRecipe> recipesWeld;
/*     */   private Map<String, PlanRecipe> plans;
/*     */   
/*     */   private AnvilManager() {
/*  27 */     this.recipes = new ArrayList<AnvilRecipe>();
/*  28 */     this.recipesWeld = new ArrayList<AnvilRecipe>();
/*  29 */     this.plans = new HashMap<String, PlanRecipe>();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRecipe(AnvilRecipe recipe) {
/*  34 */     this.recipes.add(recipe);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addWeldRecipe(AnvilRecipe recipe) {
/*  39 */     recipe.flux = true;
/*  40 */     this.recipesWeld.add(recipe);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearRecipes() {
/*  45 */     this.recipes.clear();
/*  46 */     this.recipesWeld.clear();
/*  47 */     this.plans.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPlan(String s, PlanRecipe r) {
/*  56 */     s = s.toLowerCase();
/*  57 */     if (!this.plans.containsKey(s)) {
/*  58 */       this.plans.put(s, r);
/*     */     }
/*     */   }
/*     */   
/*     */   public PlanRecipe getPlan(String s) {
/*  63 */     return this.plans.get(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe findMatchingRecipe(AnvilRecipe recipe) {
/*  68 */     for (int k = 0; k < this.recipes.size(); k++) {
/*     */       
/*  70 */       AnvilRecipe irecipe = this.recipes.get(k);
/*  71 */       if (irecipe != null && irecipe.matches(recipe)) {
/*  72 */         return irecipe;
/*     */       }
/*     */     } 
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe findMatchingWeldRecipe(AnvilRecipe recipe) {
/*  80 */     for (int k = 0; k < this.recipesWeld.size(); k++) {
/*     */       
/*  82 */       AnvilRecipe irecipe = this.recipesWeld.get(k);
/*  83 */       if (irecipe != null && irecipe.matches(recipe)) {
/*  84 */         return irecipe;
/*     */       }
/*     */     } 
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] findCompleteRecipe(AnvilRecipe recipe, int[] rules) {
/*  92 */     for (int k = 0; k < this.recipes.size(); k++) {
/*     */       
/*  94 */       AnvilRecipe irecipe = this.recipes.get(k);
/*  95 */       if (irecipe != null && irecipe.isComplete(INSTANCE, recipe, rules)) {
/*  96 */         return new Object[] { irecipe, irecipe.getCraftingResult(recipe.input1) };
/*     */       }
/*     */     } 
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack findCompleteWeldRecipe(AnvilRecipe recipe) {
/* 104 */     for (int k = 0; k < this.recipesWeld.size(); k++) {
/*     */       
/* 106 */       AnvilRecipe irecipe = this.recipesWeld.get(k);
/* 107 */       if (irecipe != null && irecipe.matches(recipe)) {
/* 108 */         return irecipe.getCraftingResult(recipe.input1);
/*     */       }
/*     */     } 
/* 111 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<AnvilRecipe> getRecipeList() {
/* 116 */     return this.recipes;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<AnvilRecipe> getWeldRecipeList() {
/* 121 */     return this.recipesWeld;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, PlanRecipe> getPlans() {
/* 126 */     return this.plans;
/*     */   }
/*     */ 
/*     */   
/*     */   public static NBTTagCompound getCraftTag(ItemStack is) {
/* 131 */     if (is.func_77942_o() && is.func_77978_p().func_74764_b("craftingTag"))
/*     */     {
/* 133 */       return (NBTTagCompound)is.func_77978_p().func_74781_a("craftingTag");
/*     */     }
/*     */     
/* 136 */     return new NBTTagCompound();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCraftTag(ItemStack is, NBTTagCompound nbt) {
/* 141 */     if (!is.func_77942_o())
/* 142 */       is.func_77982_d(new NBTTagCompound()); 
/* 143 */     is.func_77978_p().func_74782_a("craftingTag", (NBTBase)nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getDurabilityBuff(ItemStack is) {
/* 148 */     NBTTagCompound nbt = getCraftTag(is);
/* 149 */     return nbt.func_74760_g("durabuff");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDurabilityBuff(ItemStack is, float value) {
/* 154 */     NBTTagCompound nbt = getCraftTag(is);
/* 155 */     nbt.func_74776_a("durabuff", value);
/* 156 */     setCraftTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getDamageBuff(ItemStack is) {
/* 161 */     NBTTagCompound nbt = getCraftTag(is);
/* 162 */     return nbt.func_74760_g("damagebuff");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDamageBuff(ItemStack is, float value) {
/* 167 */     NBTTagCompound nbt = getCraftTag(is);
/* 168 */     nbt.func_74776_a("damagebuff", value);
/* 169 */     setCraftTag(is, nbt);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\AnvilManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */