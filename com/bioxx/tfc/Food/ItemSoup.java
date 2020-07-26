/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSoup
/*    */   extends ItemMeal
/*    */ {
/*    */   public ItemSoup() {
/* 12 */     this.field_77787_bX = true;
/* 13 */     this.metaNames = new String[] { "Soup0", "Soup1", "Soup2", "Soup3" };
/* 14 */     this.metaIcons = new net.minecraft.util.IIcon[4];
/* 15 */     setFolder("food/");
/*    */   }
/*    */ 
/*    */   
/*    */   public float getFoodMaxWeight(ItemStack is) {
/* 20 */     return 24.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean renderDecay() {
/* 25 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean renderWeight() {
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemSoup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */