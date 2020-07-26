/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SlotFirepitOut
/*    */   extends Slot
/*    */ {
/*    */   private int slotMax;
/*    */   
/*    */   public SlotFirepitOut(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k) {
/* 15 */     super(iinventory, i, j, k);
/* 16 */     this.slotMax = 64;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 21 */     if (itemstack.func_77973_b() == TFCItems.ceramicMold && itemstack.func_77960_j() == 1) {
/*    */       
/* 23 */       this.slotMax = 1;
/* 24 */       return true;
/*    */     } 
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75215_d(ItemStack par1ItemStack) {
/* 31 */     if (par1ItemStack != null && par1ItemStack.func_77973_b() == TFCItems.ceramicMold && par1ItemStack.func_77960_j() == 1) {
/*    */       
/* 33 */       par1ItemStack.field_77994_a = 1;
/* 34 */       this.slotMax = 1;
/*    */     }
/*    */     else {
/*    */       
/* 38 */       this.slotMax = 64;
/*    */     } 
/* 40 */     super.func_75215_d(par1ItemStack);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_75219_a() {
/* 46 */     return this.slotMax;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotFirepitOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */