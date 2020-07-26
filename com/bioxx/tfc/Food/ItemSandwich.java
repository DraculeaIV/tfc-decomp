/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSandwich
/*    */   extends ItemMeal
/*    */ {
/*    */   public ItemSandwich() {
/* 19 */     this.field_77787_bX = true;
/* 20 */     this.metaNames = new String[] { "Sandwich Wheat", "Sandwich Oat", "Sandwich Barley", "Sandwich Rye", "Sandwich Corn", "Sandwich Rice" };
/* 21 */     this.metaIcons = new net.minecraft.util.IIcon[6];
/* 22 */     setFolder("food/");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addFGInformation(ItemStack is, List<String> arraylist) {
/* 28 */     int[] fg = Food.getFoodGroups(is);
/* 29 */     for (int i = 0; i < fg.length; i++) {
/*    */       
/* 31 */       if (i == 5 && fg[5] == fg[0])
/*    */         return; 
/* 33 */       if (fg[i] != -1) {
/* 34 */         arraylist.add(localize(fg[i]));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected float getEatAmount(FoodStatsTFC fs, float amount) {
/* 41 */     float eatAmount = Math.min(amount, 10.0F);
/* 42 */     float stomachDiff = fs.stomachLevel + eatAmount - fs.getMaxStomach(fs.player);
/* 43 */     if (stomachDiff > 0.0F)
/* 44 */       eatAmount -= stomachDiff; 
/* 45 */     return eatAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float getFillingBoost() {
/* 51 */     return 1.25F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected float[] getFoodWeights() {
/* 57 */     return new float[] { 2.0F, 3.0F, 2.0F, 2.0F, 1.0F };
/*    */   }
/*    */ 
/*    */   
/*    */   public float getFoodMaxWeight(ItemStack is) {
/* 62 */     return 10.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean renderDecay() {
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean renderWeight() {
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 78 */     list.add(createTag(new ItemStack((Item)this, 1)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static ItemStack createTag(ItemStack is) {
/* 84 */     ItemMeal.createTag(is);
/* 85 */     int[] foodGroups = { -1, -1, -1, -1 };
/* 86 */     Food.setFoodGroups(is, foodGroups);
/* 87 */     return is;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemSandwich.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */