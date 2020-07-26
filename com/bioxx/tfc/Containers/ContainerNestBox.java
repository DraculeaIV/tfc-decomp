/*    */ package com.bioxx.tfc.Containers;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.Slots.SlotOutputOnly;
/*    */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*    */ import com.bioxx.tfc.TileEntities.TENestBox;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerNestBox
/*    */   extends ContainerTFC
/*    */ {
/*    */   public ContainerNestBox(InventoryPlayer playerinv, TENestBox te, World world, int x, int y, int z) {
/* 22 */     this.player = playerinv.field_70458_d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 28 */     func_75146_a((Slot)new SlotOutputOnly((IInventory)te, 0, 71, 25));
/* 29 */     func_75146_a((Slot)new SlotOutputOnly((IInventory)te, 1, 89, 25));
/* 30 */     func_75146_a((Slot)new SlotOutputOnly((IInventory)te, 2, 71, 43));
/* 31 */     func_75146_a((Slot)new SlotOutputOnly((IInventory)te, 3, 89, 43));
/*    */     
/* 33 */     PlayerInventory.buildInventoryLayout(this, playerinv, 8, 90, false, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer var1) {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 45 */     ItemStack origStack = null;
/* 46 */     Slot slot = this.field_75151_b.get(slotNum);
/*    */     
/* 48 */     if (slot != null && slot.func_75216_d()) {
/*    */       
/* 50 */       ItemStack slotStack = slot.func_75211_c();
/* 51 */       origStack = slotStack.func_77946_l();
/*    */       
/* 53 */       if (slotNum < 4)
/*    */       {
/* 55 */         if (!func_75135_a(slotStack, 4, this.field_75151_b.size(), true)) {
/* 56 */           return null;
/*    */         }
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 65 */       if (slotStack.field_77994_a <= 0) {
/* 66 */         slot.func_75215_d(null);
/*    */       } else {
/* 68 */         slot.func_75218_e();
/*    */       } 
/* 70 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 71 */         return null;
/*    */       }
/* 73 */       slot.func_82870_a(player, slotStack);
/*    */     } 
/*    */     
/* 76 */     return origStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerNestBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */