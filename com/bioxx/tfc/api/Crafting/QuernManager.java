/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class QuernManager
/*    */ {
/* 10 */   private static final QuernManager INSTANCE = new QuernManager();
/*    */   
/*    */   public static final QuernManager getInstance() {
/* 13 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   private List<QuernRecipe> recipes;
/*    */   private List<ItemStack> validItems;
/*    */   
/*    */   private QuernManager() {
/* 21 */     this.recipes = new ArrayList<QuernRecipe>();
/* 22 */     this.validItems = new ArrayList<ItemStack>();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addRecipe(QuernRecipe recipe) {
/* 27 */     this.recipes.add(recipe);
/* 28 */     this.validItems.add(recipe.getInItem());
/*    */   }
/*    */ 
/*    */   
/*    */   public Boolean isValidItem(ItemStack is) {
/* 33 */     for (ItemStack vi : this.validItems) {
/*    */       
/* 35 */       ItemStack vis = vi;
/* 36 */       if (vis.func_77973_b() == is.func_77973_b() && vis.func_77960_j() == is.func_77960_j())
/* 37 */         return Boolean.valueOf(true); 
/*    */     } 
/* 39 */     return Boolean.valueOf(false);
/*    */   }
/*    */ 
/*    */   
/*    */   public QuernRecipe findMatchingRecipe(ItemStack is) {
/* 44 */     for (QuernRecipe recipe : this.recipes) {
/*    */       
/* 46 */       QuernRecipe qr = recipe;
/* 47 */       if (qr.isInItem(is).booleanValue())
/* 48 */         return qr; 
/*    */     } 
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<QuernRecipe> getRecipes() {
/* 55 */     return this.recipes;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<ItemStack> getValidItems() {
/* 60 */     return this.validItems;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\QuernManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */