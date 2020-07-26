/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemFoodMeat
/*    */   extends ItemFoodTFC
/*    */ {
/*    */   public ItemFoodMeat(EnumFoodGroup fg, int sw, int so, int sa, int bi, int um, boolean edible, boolean usable) {
/* 13 */     super(fg, sw, so, sa, bi, um, edible, usable);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getCookedLevelString(ItemStack is) {
/* 19 */     String s = "";
/* 20 */     if (Food.isCooked(is)) {
/*    */       
/* 22 */       s = s + " (";
/* 23 */       int cookedLevel = ((int)Food.getCooked(is) - 600) / 120;
/* 24 */       switch (cookedLevel) {
/*    */         case 0:
/* 26 */           s = s + TFC_Core.translate("food.cooked.rare"); break;
/* 27 */         case 1: s = s + TFC_Core.translate("food.cooked.medrare"); break;
/* 28 */         case 2: s = s + TFC_Core.translate("food.cooked.med"); break;
/* 29 */         case 3: s = s + TFC_Core.translate("food.cooked.medwell"); break;
/* 30 */         default: s = s + TFC_Core.translate("food.cooked.well"); break;
/*    */       } 
/* 32 */       s = s + ")";
/*    */     } 
/* 34 */     return s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemFoodMeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */