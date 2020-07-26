/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BarrelManager
/*    */ {
/* 14 */   private static final BarrelManager INSTANCE = new BarrelManager();
/*    */   
/*    */   public static final BarrelManager getInstance() {
/* 17 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   private List<BarrelRecipe> recipes;
/*    */   private List<BarrelPreservativeRecipe> preservativeRecipes;
/*    */   
/*    */   private BarrelManager() {
/* 25 */     this.recipes = new ArrayList<BarrelRecipe>();
/* 26 */     this.preservativeRecipes = new ArrayList<BarrelPreservativeRecipe>();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addRecipe(BarrelRecipe recipe) {
/* 31 */     this.recipes.add(recipe);
/*    */   }
/*    */   
/*    */   public void addPreservative(BarrelPreservativeRecipe recipe) {
/* 35 */     this.preservativeRecipes.add(recipe);
/*    */   }
/*    */ 
/*    */   
/*    */   public BarrelRecipe findMatchingRecipe(ItemStack item, FluidStack fluid, boolean sealed, int techLevel) {
/* 40 */     for (BarrelRecipe recipe : this.recipes) {
/*    */       
/* 42 */       BarrelRecipe br = recipe;
/* 43 */       if (fluid != null && br.matches(item, fluid).booleanValue() && 
/* 44 */         br.sealedRecipe == sealed && br.minTechLevel <= techLevel)
/* 45 */         return br; 
/*    */     } 
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public BarrelPreservativeRecipe findMatchingPreservativeRepice(TEBarrel barrel, ItemStack item, FluidStack fluid, boolean sealed) {
/* 52 */     for (BarrelPreservativeRecipe recipe : this.preservativeRecipes) {
/* 53 */       if (recipe.checkForPreservation(barrel, fluid, item, sealed))
/* 54 */         return recipe; 
/*    */     } 
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<BarrelRecipe> getRecipes() {
/* 61 */     return this.recipes;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<BarrelPreservativeRecipe> getPreservatives() {
/* 66 */     return this.preservativeRecipes;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */