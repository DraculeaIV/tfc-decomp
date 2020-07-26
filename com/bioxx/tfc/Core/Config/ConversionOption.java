/*    */ package com.bioxx.tfc.Core.Config;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCCrafting;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConversionOption
/*    */   extends SyncingOption
/*    */ {
/*    */   public final ImmutableList<IRecipe> recipes;
/*    */   
/*    */   public ConversionOption(String name, IRecipe... shapelessRecipes) throws NoSuchFieldException, IllegalAccessException {
/* 20 */     super(name, TFCCrafting.class, TFC_ConfigFiles.getCraftingConfig(), "Conversion");
/* 21 */     if (shapelessRecipes.length == 0) throw new IllegalArgumentException("No recipes for conversion " + name); 
/* 22 */     this.recipes = ImmutableList.copyOf((Object[])shapelessRecipes);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ImmutableList<IRecipe> getRecipes() {
/* 28 */     return this.recipes;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 34 */     return this.name + "[default:" + this.defaultValue + " current:" + isAplied() + " config:" + inConfig() + " #ofRecipes:" + this.recipes.size() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Config\ConversionOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */