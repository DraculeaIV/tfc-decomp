/*    */ package com.bioxx.tfc.Containers;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ContainerHopper
/*    */   extends ContainerTFC
/*    */ {
/*    */   private final IInventory hopperInv;
/*    */   
/*    */   public ContainerHopper(InventoryPlayer playerInv, IInventory inv) {
/* 17 */     this.hopperInv = inv;
/* 18 */     inv.func_70295_k_();
/*    */ 
/*    */     
/* 21 */     for (int i = 0; i < inv.func_70302_i_(); i++)
/*    */     {
/* 23 */       func_75146_a(new Slot(inv, i, 44 + i * 18, 17));
/*    */     }
/*    */     
/* 26 */     PlayerInventory.buildInventoryLayout(this, playerInv, 8, 54, false, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 32 */     ItemStack origStack = null;
/* 33 */     Slot slot = this.field_75151_b.get(slotNum);
/*    */     
/* 35 */     if (slot != null && slot.func_75216_d()) {
/*    */       
/* 37 */       ItemStack slotStack = slot.func_75211_c();
/* 38 */       origStack = slotStack.func_77946_l();
/*    */       
/* 40 */       if (slotNum < 5) {
/*    */         
/* 42 */         if (!func_75135_a(slotStack, 5, this.field_75151_b.size(), true)) {
/* 43 */           return null;
/*    */         
/*    */         }
/*    */       }
/* 47 */       else if (!func_75135_a(slotStack, 0, 5, false)) {
/* 48 */         return null;
/*    */       } 
/*    */       
/* 51 */       if (slotStack.field_77994_a <= 0) {
/* 52 */         slot.func_75215_d(null);
/*    */       } else {
/* 54 */         slot.func_75218_e();
/*    */       } 
/* 56 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 57 */         return null;
/*    */       }
/* 59 */       slot.func_82870_a(player, slotStack);
/*    */     } 
/*    */     
/* 62 */     return origStack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 68 */     return this.hopperInv.func_70300_a(player);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75134_a(EntityPlayer player) {
/* 77 */     super.func_75134_a(player);
/* 78 */     this.hopperInv.func_70305_f();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */