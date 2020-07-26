/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotMoldTool2
/*    */   extends Slot
/*    */ {
/*    */   public SlotMoldTool2(IInventory iinventory, int i, int j, int k) {
/* 16 */     super(iinventory, i, j, k);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 22 */     return (((itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold || itemstack
/* 23 */       .func_77973_b() == TFCItems.ceramicMold) && itemstack.func_77960_j() == 1) || (itemstack
/* 24 */       .func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal && TFC_ItemHeat.getIsLiquid(itemstack).booleanValue()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_75219_a() {
/* 30 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotMoldTool2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */