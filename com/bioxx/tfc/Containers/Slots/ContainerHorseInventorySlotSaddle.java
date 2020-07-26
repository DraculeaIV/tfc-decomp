/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerHorseInventoryTFC;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerHorseInventorySlotSaddle
/*    */   extends Slot
/*    */ {
/*    */   public ContainerHorseInventorySlotSaddle(ContainerHorseInventoryTFC par1ContainerHorseInventory, IInventory par2IInventory, int par3, int par4, int par5) {
/* 16 */     super(par2IInventory, par3, par4, par5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack par1ItemStack) {
/* 26 */     return (super.func_75214_a(par1ItemStack) && par1ItemStack.func_77973_b() == Items.field_151141_av && !func_75216_d());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\ContainerHorseInventorySlotSaddle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */