/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.oredict.OreDictionary;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoomRecipe
/*    */ {
/*    */   public ItemStack inItemStack;
/*    */   public ItemStack outItemStack;
/*    */   public int inSize;
/*    */   
/*    */   public LoomRecipe(ItemStack inputItem, ItemStack outIS) {
/* 15 */     this.inItemStack = inputItem;
/* 16 */     this.outItemStack = outIS;
/* 17 */     this.inSize = inputItem.field_77994_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public Boolean matches(ItemStack item) {
/* 22 */     boolean iStack = (this.inItemStack != null && item != null && item.field_77994_a == this.inItemStack.field_77994_a);
/*    */     
/* 24 */     boolean itemsEqual = OreDictionary.itemMatches(this.inItemStack, item, false);
/*    */     
/* 26 */     return Boolean.valueOf((iStack && itemsEqual));
/*    */   }
/*    */ 
/*    */   
/*    */   public Boolean resultMatches(ItemStack item) {
/* 31 */     boolean iStack = (this.outItemStack != null && item != null && item.field_77994_a == this.outItemStack.field_77994_a);
/*    */     
/* 33 */     boolean itemsEqual = OreDictionary.itemMatches(this.outItemStack, item, false);
/*    */     
/* 35 */     return Boolean.valueOf((iStack && itemsEqual));
/*    */   }
/*    */ 
/*    */   
/*    */   public Boolean partiallyMatches(ItemStack item) {
/* 40 */     boolean iStack = (this.inItemStack != null && item != null);
/*    */     
/* 42 */     boolean itemsEqual = OreDictionary.itemMatches(this.inItemStack, item, false);
/*    */     
/* 44 */     return Boolean.valueOf((iStack && itemsEqual));
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getInItem() {
/* 49 */     return this.inItemStack;
/*    */   }
/*    */   
/*    */   public int getReqSize() {
/* 53 */     return this.inSize;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRecipeName() {
/* 58 */     String s = "";
/* 59 */     if (this.outItemStack != null)
/* 60 */       s = this.outItemStack.func_82833_r(); 
/* 61 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getResult(ItemStack inIS) {
/* 66 */     ItemStack is = null;
/* 67 */     if (this.outItemStack != null) {
/*    */       
/* 69 */       is = this.outItemStack.func_77946_l();
/* 70 */       return is;
/*    */     } 
/* 72 */     return is;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getOutItemStack() {
/* 77 */     return this.outItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\LoomRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */