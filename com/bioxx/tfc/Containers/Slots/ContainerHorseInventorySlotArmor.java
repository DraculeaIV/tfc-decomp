/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerHorseInventoryTFC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerHorseInventorySlotArmor
/*    */   extends Slot
/*    */ {
/*    */   private final EntityHorse horse;
/*    */   
/*    */   public ContainerHorseInventorySlotArmor(ContainerHorseInventoryTFC containerHorseInv, IInventory horseInv, int i, int j, int k, EntityHorse entityHorse) {
/* 21 */     super(horseInv, i, j, k);
/*    */     
/* 23 */     this.horse = entityHorse;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemStack) {
/* 32 */     return (super.func_75214_a(itemStack) && this.horse.func_110259_cr() && EntityHorse.func_146085_a(itemStack.func_77973_b()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_111238_b() {
/* 39 */     return this.horse.func_110259_cr();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\ContainerHorseInventorySlotArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */