/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotFoodBowl
/*    */   extends Slot
/*    */ {
/*    */   public SlotFoodBowl(IInventory par1iInventory, int par2, int par3, int par4) {
/* 12 */     super(par1iInventory, par2, par3, par4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack par1ItemStack) {
/* 18 */     return (par1ItemStack.func_77973_b() == Items.field_151054_z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotFoodBowl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */