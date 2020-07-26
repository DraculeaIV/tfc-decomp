/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class KilnRecipe
/*    */ {
/*    */   public ItemStack result;
/*    */   public ItemStack input1;
/*    */   public int kilnLevel;
/*    */   public boolean inheritsTag = true;
/*    */   
/*    */   public KilnRecipe(ItemStack in, int kl, ItemStack res) {
/* 14 */     this.input1 = in;
/* 15 */     this.result = res;
/* 16 */     this.kilnLevel = kl;
/*    */   }
/*    */ 
/*    */   
/*    */   public KilnRecipe(ItemStack in, int kl) {
/* 21 */     this.input1 = in;
/* 22 */     this.kilnLevel = kl;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean matches(KilnRecipe recipe) {
/* 30 */     return (areItemStacksEqual(this.input1, recipe.input1) && recipe.kilnLevel == this.kilnLevel);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isComplete(KilnRecipe recipe) {
/* 35 */     return (areItemStacksEqual(this.input1, recipe.input1) && recipe.kilnLevel == this.kilnLevel);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getInheritsTag() {
/* 40 */     return this.inheritsTag;
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean areItemStacksEqual(ItemStack is1, ItemStack is2) {
/* 45 */     if (is1 != null && is2 != null) {
/*    */       
/* 47 */       if (is1.func_77973_b() != is2.func_77973_b()) {
/* 48 */         return false;
/*    */       }
/* 50 */       if (is1.func_77960_j() != -1 && is1.func_77960_j() != is2.func_77960_j()) {
/* 51 */         return false;
/*    */       }
/* 53 */     } else if ((is1 == null && is2 != null) || (is1 != null && is2 == null)) {
/* 54 */       return false;
/*    */     } 
/* 56 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack getCraftingResult() {
/* 64 */     return this.result;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getKilnLevel() {
/* 69 */     return this.kilnLevel;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getInput1() {
/* 74 */     return this.input1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\KilnRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */