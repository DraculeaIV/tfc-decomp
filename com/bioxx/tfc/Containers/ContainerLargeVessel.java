/*    */ package com.bioxx.tfc.Containers;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.Slots.SlotChest;
/*    */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*    */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*    */ import com.bioxx.tfc.TileEntities.TEVessel;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ContainerLargeVessel
/*    */   extends ContainerBarrel
/*    */ {
/*    */   public ContainerLargeVessel(InventoryPlayer inventoryplayer, TEVessel tileentitybarrel, World world, int x, int y, int z, int tab) {
/* 19 */     super(inventoryplayer, (TEBarrel)tileentitybarrel, world, x, y, z, tab);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void buildLayout() {
/* 25 */     if (this.guiTab == 0) {
/*    */ 
/*    */       
/* 28 */       if (!this.barrel.getSealed()) {
/* 29 */         func_75146_a((Slot)(new SlotChest((IInventory)this.barrel, 0, 80, 29)).setSize(EnumSize.MEDIUM).addItemException(ContainerBarrel.getExceptions()));
/*    */       } else {
/* 31 */         func_75146_a((Slot)new SlotForShowOnly((IInventory)this.barrel, 0, 80, 29));
/*    */       } 
/* 33 */     } else if (this.guiTab == 1) {
/*    */       
/* 35 */       for (int i = 0; i < 3; i++) {
/*    */         
/* 37 */         for (int k = 0; k < 3; k++) {
/*    */           
/* 39 */           if (!this.barrel.getSealed()) {
/* 40 */             func_75146_a((Slot)(new SlotChest((IInventory)this.barrel, k + i * 3, 71 + i * 18, 17 + k * 18)).setSize(EnumSize.MEDIUM).addItemException(ContainerChestTFC.getExceptions()));
/*    */           } else {
/* 42 */             func_75146_a((Slot)new SlotForShowOnly((IInventory)this.barrel, k + i * 3, 71 + i * 18, 17 + k * 18));
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 51 */     ItemStack origStack = null;
/* 52 */     Slot slot = this.field_75151_b.get(slotNum);
/*    */     
/* 54 */     if (!this.barrel.getSealed() && slot != null && slot.func_75216_d()) {
/*    */       
/* 56 */       ItemStack slotStack = slot.func_75211_c();
/* 57 */       origStack = slotStack.func_77946_l();
/*    */ 
/*    */       
/* 60 */       if (slotNum < 1 && this.guiTab == 0) {
/*    */         
/* 62 */         if (!func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
/* 63 */           return null;
/*    */         }
/*    */       }
/* 66 */       else if (slotNum < 9 && this.guiTab == 1) {
/*    */         
/* 68 */         if (!func_75135_a(slotStack, 9, this.field_75151_b.size(), true)) {
/* 69 */           return null;
/*    */         
/*    */         }
/*    */       
/*    */       }
/* 74 */       else if (this.guiTab == 1) {
/*    */         
/* 76 */         if (!func_75135_a(slotStack, 0, 9, false)) {
/* 77 */           return null;
/*    */         }
/*    */       }
/* 80 */       else if (this.guiTab == 0) {
/*    */         
/* 82 */         if (!func_75135_a(slotStack, 0, 1, false)) {
/* 83 */           return null;
/*    */         }
/*    */       } 
/*    */       
/* 87 */       if (slotStack.field_77994_a <= 0) {
/* 88 */         slot.func_75215_d(null);
/*    */       } else {
/* 90 */         slot.func_75218_e();
/*    */       } 
/* 92 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 93 */         return null;
/*    */       }
/* 95 */       slot.func_82870_a(player, slotStack);
/*    */     } 
/*    */     
/* 98 */     return origStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerLargeVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */