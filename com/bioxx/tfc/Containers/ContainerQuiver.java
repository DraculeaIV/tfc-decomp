/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotQuiver;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerQuiver
/*     */   extends ContainerTFC
/*     */ {
/*  22 */   public InventoryCrafting containerInv = new InventoryCrafting(this, 4, 2);
/*     */ 
/*     */ 
/*     */   
/*     */   public ContainerQuiver(InventoryPlayer playerinv, World world, int x, int y, int z) {
/*  27 */     this.player = playerinv.field_70458_d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     this.bagsSlotNum = this.player.field_71071_by.field_70461_c;
/*     */ 
/*     */     
/*  35 */     layoutContainer((IInventory)playerinv, 0, 0);
/*     */     
/*  37 */     if (!world.field_72995_K)
/*  38 */       loadBagInventory(); 
/*  39 */     this.doItemSaving = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, int xSize, int ySize) {
/*  44 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 0, 53, 8));
/*  45 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 1, 71, 8));
/*  46 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 2, 89, 8));
/*  47 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 3, 107, 8));
/*  48 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 4, 53, 26));
/*  49 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 5, 71, 26));
/*  50 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 6, 89, 26));
/*  51 */     func_75146_a((Slot)new SlotQuiver((IInventory)this.containerInv, 7, 107, 26));
/*     */ 
/*     */     
/*     */     int row;
/*     */     
/*  56 */     for (row = 0; row < 9; row++) {
/*     */       
/*  58 */       if (row == this.bagsSlotNum) {
/*  59 */         func_75146_a((Slot)new SlotForShowOnly(playerInventory, row, 8 + row * 18, 112));
/*     */       } else {
/*  61 */         func_75146_a(new Slot(playerInventory, row, 8 + row * 18, 112));
/*     */       } 
/*     */     } 
/*  64 */     for (row = 0; row < 3; row++) {
/*     */       
/*  66 */       for (int col = 0; col < 9; col++) {
/*  67 */         func_75146_a(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 54 + row * 18));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void loadBagInventory() {
/*  73 */     if (this.player.field_71071_by.func_70301_a(this.bagsSlotNum) != null && this.player.field_71071_by
/*  74 */       .func_70301_a(this.bagsSlotNum).func_77942_o()) {
/*     */       
/*  76 */       NBTTagList nbttaglist = this.player.field_71071_by.func_70301_a(this.bagsSlotNum).func_77978_p().func_150295_c("Items", 10);
/*     */       
/*  78 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/*  80 */         this.isLoading = true;
/*  81 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  82 */         byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  83 */         if (byte0 >= 0 && byte0 < 8) {
/*  84 */           this.containerInv.func_70299_a(byte0, ItemStack.func_77949_a(nbttagcompound1));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveContents(ItemStack is) {
/*  92 */     NBTTagList nbttaglist = new NBTTagList();
/*  93 */     for (int i = 0; i < this.containerInv.func_70302_i_(); i++) {
/*     */       
/*  95 */       if (this.containerInv.func_70301_a(i) != null) {
/*     */         
/*  97 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  98 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  99 */         this.containerInv.func_70301_a(i).func_77955_b(nbttagcompound1);
/* 100 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 103 */     if (is != null) {
/*     */       
/* 105 */       if (!is.func_77942_o()) {
/* 106 */         is.func_77982_d(new NBTTagCompound());
/*     */       }
/* 108 */       is.func_77978_p().func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack loadContents(int slot) {
/* 116 */     if (this.player.field_71071_by.func_70301_a(this.bagsSlotNum) != null && this.player.field_71071_by
/* 117 */       .func_70301_a(this.bagsSlotNum).func_77942_o()) {
/*     */       
/* 119 */       NBTTagList nbttaglist = this.player.field_71071_by.func_70301_a(this.bagsSlotNum).func_77978_p().func_150295_c("Items", 10);
/* 120 */       if (nbttaglist != null)
/*     */       {
/* 122 */         for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */           
/* 124 */           NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 125 */           byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 126 */           if (byte0 == slot)
/* 127 */             return ItemStack.func_77949_a(nbttagcompound1); 
/*     */         } 
/*     */       }
/*     */     } 
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 143 */     ItemStack origStack = null;
/* 144 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/* 146 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 148 */       ItemStack slotStack = slot.func_75211_c();
/* 149 */       origStack = slotStack.func_77946_l();
/*     */       
/* 151 */       if (slotNum < 8) {
/*     */         
/* 153 */         if (!func_75135_a(slotStack, 8, this.field_75151_b.size(), true)) {
/* 154 */           return null;
/*     */         
/*     */         }
/*     */       }
/* 158 */       else if (!func_75135_a(slotStack, 0, 8, false)) {
/* 159 */         return null;
/*     */       } 
/*     */       
/* 162 */       if (slotStack.field_77994_a <= 0) {
/* 163 */         slot.func_75215_d(null);
/*     */       } else {
/* 165 */         slot.func_75218_e();
/*     */       } 
/* 167 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 168 */         return null;
/*     */       }
/* 170 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 173 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerQuiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */