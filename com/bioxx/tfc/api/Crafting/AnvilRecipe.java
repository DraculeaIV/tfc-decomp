/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnvilRecipe
/*     */ {
/*     */   public ItemStack result;
/*  17 */   public String plan = "";
/*     */   public ItemStack input1;
/*     */   public ItemStack input2;
/*     */   public boolean flux;
/*     */   public int craftingValue;
/*     */   public int anvilreq;
/*     */   public boolean inheritsDamage;
/*  24 */   public int craftingXP = 1;
/*  25 */   public List<String> skillsList = new ArrayList<String>();
/*  26 */   public static int craftingBoundDefault = 50;
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack in2, String p, boolean flux, AnvilReq req, ItemStack result) {
/*  30 */     this(in, in2, p.toLowerCase(), 0, flux, req.Tier, result);
/*  31 */     this.craftingValue = 70 + (new Random(TFC_Core.getSuperSeed(AnvilManager.world) + ((in != null) ? Item.func_150891_b(in.func_77973_b()) : 0L) + ((result != null) ? Item.func_150891_b(result.func_77973_b()) : 0L))).nextInt(craftingBoundDefault);
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack in2, String p, AnvilReq req, ItemStack result) {
/*  36 */     this(in, in2, p.toLowerCase(), 0, false, req.Tier, result);
/*  37 */     this.craftingValue = 70 + (new Random(TFC_Core.getSuperSeed(AnvilManager.world) + ((in != null) ? Item.func_150891_b(in.func_77973_b()) : 0L) + ((result != null) ? Item.func_150891_b(result.func_77973_b()) : 0L))).nextInt(craftingBoundDefault);
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe setCraftingBound(int max) {
/*  42 */     this.craftingValue = 70 + (new Random(TFC_Core.getSuperSeed(AnvilManager.world) + ((this.input1 != null) ? Item.func_150891_b(this.input1.func_77973_b()) : 0L) + ((this.result != null) ? Item.func_150891_b(this.result.func_77973_b()) : 0L))).nextInt(max);
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack in2, String p, int cv, boolean flux, int req, ItemStack result) {
/*  48 */     this.input1 = in;
/*  49 */     this.input2 = in2;
/*  50 */     this.flux = flux;
/*  51 */     this.craftingValue = cv;
/*  52 */     this.anvilreq = req;
/*  53 */     this.result = result;
/*  54 */     this.inheritsDamage = false;
/*  55 */     this.plan = p;
/*  56 */     this.skillsList.add("skill.gensmith");
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack p, boolean flux, AnvilReq req) {
/*  61 */     this(in, p, flux, req.Tier);
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack p, boolean flux, int req) {
/*  66 */     this.input1 = in;
/*  67 */     this.input2 = p;
/*  68 */     this.flux = flux;
/*  69 */     this.anvilreq = req;
/*  70 */     this.inheritsDamage = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack p, String s, boolean flux, int req) {
/*  75 */     this(in, p, flux, req);
/*  76 */     this.plan = s;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack p, boolean flux, AnvilReq req, ItemStack res) {
/*  81 */     this(in, p, req, res);
/*  82 */     this.flux = flux;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe(ItemStack in, ItemStack p, AnvilReq req, ItemStack res) {
/*  87 */     this.input1 = in;
/*  88 */     this.input2 = p;
/*  89 */     this.anvilreq = req.Tier;
/*  90 */     this.result = res;
/*  91 */     this.inheritsDamage = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe clearRecipeSkills() {
/*  96 */     this.skillsList.clear();
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe setCraftingXP(int xp) {
/* 102 */     this.craftingXP = xp;
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe setInheritsDamage() {
/* 108 */     this.inheritsDamage = true;
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AnvilRecipe addRecipeSkill(String s) {
/* 114 */     this.skillsList.add(s);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(AnvilRecipe recipe) {
/* 123 */     if (areItemStacksEqual(this.input1, recipe.input1) && 
/* 124 */       areItemStacksEqual(this.input2, recipe.input2) && this.plan
/* 125 */       .equals(recipe.plan) && 
/* 126 */       AnvilReq.matches(this.anvilreq, recipe.anvilreq))
/*     */     {
/* 128 */       return (!this.flux || recipe.flux);
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete(AnvilManager am, AnvilRecipe recipe, int[] rules) {
/* 135 */     PlanRecipe pr = am.getPlan(recipe.plan);
/* 136 */     if (areItemStacksEqual(this.input1, recipe.input1) && 
/* 137 */       areItemStacksEqual(this.input2, recipe.input2) && this.plan
/* 138 */       .equals(recipe.plan) && pr.rules[0]
/* 139 */       .matches(rules, 0) && pr.rules[1].matches(rules, 1) && pr.rules[2].matches(rules, 2) && this.craftingValue == recipe.craftingValue && 
/* 140 */       AnvilReq.matches(this.anvilreq, recipe.anvilreq)) {
/* 141 */       if (this.flux && recipe.flux)
/* 142 */         return true; 
/* 143 */       if (!this.flux)
/* 144 */         return true; 
/* 145 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete(AnvilRecipe recipe) {
/* 150 */     if (recipe.input1 == this.input1 && recipe.input2 == this.input2 && this.craftingValue == recipe.craftingValue && this.plan
/* 151 */       .equals(recipe.plan) && AnvilReq.matches(this.anvilreq, recipe.anvilreq)) {
/* 152 */       if (this.flux && recipe.flux)
/* 153 */         return true; 
/* 154 */       if (!this.flux)
/* 155 */         return true; 
/* 156 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean areItemStacksEqual(ItemStack is1, ItemStack is2) {
/* 161 */     if (is1 != null && is2 != null) {
/*     */       
/* 163 */       if (is1.func_77973_b() != is2.func_77973_b()) {
/* 164 */         return false;
/*     */       }
/* 166 */       if (is1.func_77960_j() != 32767 && is1.func_77960_j() != is2.func_77960_j()) {
/* 167 */         return false;
/*     */       }
/* 169 */     } else if ((is1 == null && is2 != null) || (is1 != null && is2 == null)) {
/* 170 */       return false;
/*     */     } 
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCraftingResult() {
/* 180 */     return this.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getCraftingResult(ItemStack input) {
/* 188 */     ItemStack is = this.result.func_77946_l();
/* 189 */     if (this.inheritsDamage)
/* 190 */       is.func_77964_b(input.func_77960_j()); 
/* 191 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCraftingValue() {
/* 198 */     return this.craftingValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getSkillMult(EntityPlayer p) {
/* 203 */     float skill = 0.0F;
/* 204 */     float total = 0.0F;
/* 205 */     for (String s : this.skillsList) {
/*     */       
/* 207 */       total++;
/* 208 */       skill += TFC_Core.getSkillStats(p).getSkillMultiplier(s);
/*     */     } 
/* 210 */     if (total > 0.0F)
/* 211 */       return skill / total; 
/* 212 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlan() {
/* 217 */     return this.plan;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getInput1() {
/* 222 */     return this.input1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getInput2() {
/* 227 */     return this.input2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFlux() {
/* 232 */     return this.flux;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAnvilreq() {
/* 237 */     return this.anvilreq;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInheritsDamage() {
/* 242 */     return this.inheritsDamage;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCraftingXP() {
/* 247 */     return this.craftingXP;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getSkillsList() {
/* 252 */     return this.skillsList;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\AnvilRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */