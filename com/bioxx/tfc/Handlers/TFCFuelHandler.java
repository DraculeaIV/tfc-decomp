/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import cpw.mods.fml.common.IFuelHandler;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class TFCFuelHandler
/*    */   implements IFuelHandler
/*    */ {
/* 13 */   public static Map<Item, Integer> fuelItems = new HashMap<Item, Integer>();
/*    */ 
/*    */   
/*    */   public static void registerFuel(Item item, int burnTime) {
/* 17 */     if (!fuelItems.containsKey(item)) {
/* 18 */       fuelItems.put(item, Integer.valueOf(burnTime));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int getBurnTime(ItemStack is) {
/* 24 */     Item item = is.func_77973_b();
/* 25 */     Integer burnTime = fuelItems.get(item);
/* 26 */     if (burnTime != null) return burnTime.intValue();
/*    */     
/* 28 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\TFCFuelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */