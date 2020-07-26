/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class LoomManager
/*    */ {
/* 13 */   private static final LoomManager INSTANCE = new LoomManager();
/*    */   
/*    */   public static final LoomManager getInstance() {
/* 16 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   private List<LoomRecipe> recipes;
/*    */   private Map<LoomRecipe, ResourceLocation> textures;
/*    */   
/*    */   private LoomManager() {
/* 24 */     this.recipes = new ArrayList<LoomRecipe>();
/* 25 */     this.textures = new HashMap<LoomRecipe, ResourceLocation>();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addRecipe(LoomRecipe recipe, ResourceLocation rl) {
/* 30 */     this.recipes.add(recipe);
/* 31 */     if (recipe != null) {
/* 32 */       this.textures.remove(recipe);
/* 33 */       this.textures.put(recipe, rl);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public LoomRecipe findMatchingRecipe(ItemStack item) {
/* 39 */     for (LoomRecipe recipe : this.recipes) {
/*    */       
/* 41 */       LoomRecipe lr = recipe;
/* 42 */       if (item != null && lr.matches(item).booleanValue())
/* 43 */         return lr; 
/*    */     } 
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public LoomRecipe findMatchingResult(ItemStack item) {
/* 50 */     for (LoomRecipe recipe : this.recipes) {
/*    */       
/* 52 */       LoomRecipe lr = recipe;
/* 53 */       if (item != null && lr.resultMatches(item).booleanValue())
/* 54 */         return lr; 
/*    */     } 
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public boolean hasPotentialRecipes(ItemStack item) {
/* 60 */     for (LoomRecipe recipe : this.recipes) {
/*    */       
/* 62 */       LoomRecipe lr = recipe;
/* 63 */       if (item != null && lr.partiallyMatches(item).booleanValue())
/* 64 */         return true; 
/*    */     } 
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public LoomRecipe findPotentialRecipes(ItemStack item) {
/* 70 */     for (LoomRecipe recipe : this.recipes) {
/*    */       
/* 72 */       LoomRecipe lr = recipe;
/* 73 */       if (item != null && lr.partiallyMatches(item).booleanValue())
/* 74 */         return lr; 
/*    */     } 
/* 76 */     return null;
/*    */   }
/*    */   
/*    */   public ResourceLocation findMatchingTexture(LoomRecipe recipe) {
/* 80 */     ResourceLocation rl = null;
/* 81 */     if (recipe != null) {
/* 82 */       rl = this.textures.remove(recipe);
/* 83 */       if (rl != null) {
/* 84 */         this.textures.put(recipe, rl);
/* 85 */         return rl;
/*    */       } 
/*    */     } 
/* 88 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<LoomRecipe> getRecipes() {
/* 93 */     return this.recipes;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\LoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */