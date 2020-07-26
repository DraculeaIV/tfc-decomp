/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecipeSorterTFC
/*    */   implements Comparator
/*    */ {
/*    */   public final CraftingManagerTFC craftingManager;
/*    */   
/*    */   RecipeSorterTFC(CraftingManagerTFC craftingmanager) {
/* 15 */     this.craftingManager = craftingmanager;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Object obj, Object obj1) {
/* 21 */     return compareRecipes((IRecipe)obj, (IRecipe)obj1);
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareRecipes(IRecipe irecipe, IRecipe irecipe1) {
/* 26 */     if (irecipe instanceof net.minecraft.item.crafting.ShapelessRecipes && irecipe1 instanceof net.minecraft.item.crafting.ShapedRecipes)
/*    */     {
/* 28 */       return 1;
/*    */     }
/* 30 */     if (irecipe1 instanceof net.minecraft.item.crafting.ShapelessRecipes && irecipe instanceof net.minecraft.item.crafting.ShapedRecipes)
/*    */     {
/* 32 */       return -1;
/*    */     }
/* 34 */     if (irecipe1.func_77570_a() < irecipe.func_77570_a())
/*    */     {
/* 36 */       return -1;
/*    */     }
/* 38 */     return (irecipe1.func_77570_a() <= irecipe.func_77570_a()) ? 0 : 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\RecipeSorterTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */