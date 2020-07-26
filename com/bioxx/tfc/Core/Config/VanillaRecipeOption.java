/*    */ package com.bioxx.tfc.Core.Config;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCCrafting;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.CraftingManager;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VanillaRecipeOption
/*    */   extends SyncingOption
/*    */ {
/*    */   public final ImmutableList<IRecipe> recipes;
/*    */   
/*    */   public VanillaRecipeOption(String name, ItemStack... toBeRemoved) throws NoSuchFieldException, IllegalAccessException {
/* 21 */     super(name, TFCCrafting.class, TFC_ConfigFiles.getCraftingConfig(), "Enable Vanilla Recipes");
/* 22 */     if (toBeRemoved.length == 0) throw new IllegalArgumentException("No items for removal " + name); 
/* 23 */     ImmutableList.Builder<IRecipe> builder = new ImmutableList.Builder();
/*    */     
/* 25 */     for (IRecipe recipe : CraftingManager.func_77594_a().func_77592_b()) {
/*    */       
/* 27 */       if (recipe == null)
/* 28 */         continue;  for (ItemStack out : toBeRemoved) {
/*    */         
/* 30 */         if (ItemStack.func_77989_b(out, recipe.func_77571_b())) {
/*    */           
/* 32 */           builder.add(recipe);
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 37 */     this.recipes = builder.build();
/*    */     
/* 39 */     CraftingManager.func_77594_a().func_77592_b().removeAll((Collection<?>)this.recipes);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ImmutableList<IRecipe> getRecipes() {
/* 45 */     return this.recipes;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return this.name + "[default:" + this.defaultValue + " current:" + isAplied() + " config:" + inConfig() + " #ofRecipes:" + this.recipes.size() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Config\VanillaRecipeOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */