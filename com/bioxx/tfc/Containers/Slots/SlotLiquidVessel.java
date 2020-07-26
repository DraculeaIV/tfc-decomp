/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotLiquidVessel
/*    */   extends Slot
/*    */ {
/*    */   public SlotLiquidVessel(IInventory iinventory, int i, int j, int k) {
/* 15 */     super(iinventory, i, j, k);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 21 */     return ((itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal && itemstack.func_77960_j() > 1) || (itemstack
/* 22 */       .func_77973_b() == TFCItems.ceramicMold && itemstack.func_77960_j() == 1) || (itemstack
/* 23 */       .func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold && itemstack.func_77960_j() > 0));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_75219_a() {
/* 29 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotLiquidVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */