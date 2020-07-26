/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotSizeSmallVessel;
/*     */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerVessel
/*     */   extends ContainerTFC
/*     */ {
/*     */   private World world;
/*  27 */   public InventoryCrafting containerInv = new InventoryCrafting(this, 2, 2);
/*     */   
/*     */   private List<Item> exceptions;
/*     */   
/*     */   public ContainerVessel(InventoryPlayer playerinv, World world, int x, int y, int z) {
/*  32 */     this.player = playerinv.field_70458_d;
/*  33 */     this.world = world;
/*  34 */     this.bagsSlotNum = this.player.field_71071_by.field_70461_c;
/*  35 */     this.exceptions = new ArrayList<Item>();
/*  36 */     for (Item ingot : TEIngotPile.getIngots())
/*     */     {
/*  38 */       this.exceptions.add(ingot);
/*     */     }
/*  40 */     layoutContainer((IInventory)playerinv, 0, 0);
/*     */     
/*  42 */     if (!world.field_72995_K)
/*  43 */       loadBagInventory(); 
/*  44 */     this.doItemSaving = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reloadContainer() {
/*  50 */     if (!this.world.field_72995_K) {
/*  51 */       loadBagInventory();
/*     */     }
/*     */   }
/*     */   
/*     */   public void loadBagInventory() {
/*  56 */     if (this.player.field_71071_by.func_70301_a(this.bagsSlotNum) != null && this.player.field_71071_by
/*  57 */       .func_70301_a(this.bagsSlotNum).func_77942_o()) {
/*     */       
/*  59 */       NBTTagList nbttaglist = this.player.field_71071_by.func_70301_a(this.bagsSlotNum).func_77978_p().func_150295_c("Items", 10);
/*  60 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/*  62 */         this.isLoading = true;
/*  63 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  64 */         byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  65 */         if (byte0 >= 0 && byte0 < 4) {
/*     */           
/*  67 */           ItemStack is = ItemStack.func_77949_a(nbttagcompound1);
/*  68 */           if (is.field_77994_a >= 1) {
/*  69 */             this.containerInv.func_70299_a(byte0, is);
/*     */           } else {
/*  71 */             this.containerInv.func_70299_a(byte0, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveContents(ItemStack is) {
/*  92 */     NBTTagList nbttaglist = new NBTTagList();
/*  93 */     for (int i = 0; i < this.containerInv.func_70302_i_(); i++) {
/*     */       
/*  95 */       ItemStack contentStack = this.containerInv.func_70301_a(i);
/*  96 */       if (contentStack != null && contentStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood)
/*     */       {
/*  98 */         if (Food.getDecay(contentStack) / 160.0F > 0.9F)
/*  99 */           this.containerInv.func_70299_a(i, null); 
/*     */       }
/* 101 */       if (contentStack != null) {
/*     */         
/* 103 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 104 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 105 */         contentStack.func_77955_b(nbttagcompound1);
/* 106 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 109 */     if (is != null) {
/*     */       
/* 111 */       if (!is.func_77942_o())
/* 112 */         is.func_77982_d(new NBTTagCompound()); 
/* 113 */       is.func_77978_p().func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack loadContents(int slot) {
/* 120 */     if (this.player.field_71071_by.func_70301_a(this.bagsSlotNum) != null && this.player.field_71071_by
/* 121 */       .func_70301_a(this.bagsSlotNum).func_77942_o()) {
/*     */       
/* 123 */       NBTTagList nbttaglist = this.player.field_71071_by.func_70301_a(this.bagsSlotNum).func_77978_p().func_150295_c("Items", 10);
/* 124 */       if (nbttaglist != null)
/*     */       {
/* 126 */         for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */           
/* 128 */           NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 129 */           byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 130 */           if (byte0 == slot)
/* 131 */             return ItemStack.func_77949_a(nbttagcompound1); 
/*     */         } 
/*     */       }
/*     */     } 
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, int xSize, int ySize) {
/* 146 */     func_75146_a((Slot)(new SlotSizeSmallVessel((IInventory)this.containerInv, 0, 71, 25)).addItemException(this.exceptions));
/* 147 */     func_75146_a((Slot)(new SlotSizeSmallVessel((IInventory)this.containerInv, 1, 89, 25)).addItemException(this.exceptions));
/* 148 */     func_75146_a((Slot)(new SlotSizeSmallVessel((IInventory)this.containerInv, 2, 71, 43)).addItemException(this.exceptions));
/* 149 */     func_75146_a((Slot)(new SlotSizeSmallVessel((IInventory)this.containerInv, 3, 89, 43)).addItemException(this.exceptions));
/*     */ 
/*     */     
/*     */     int row;
/*     */     
/* 154 */     for (row = 0; row < 9; row++) {
/*     */       
/* 156 */       if (row == this.bagsSlotNum) {
/* 157 */         func_75146_a((Slot)new SlotForShowOnly(playerInventory, row, 8 + row * 18, 148));
/*     */       } else {
/* 159 */         func_75146_a(new Slot(playerInventory, row, 8 + row * 18, 148));
/*     */       } 
/*     */     } 
/* 162 */     for (row = 0; row < 3; row++) {
/*     */       
/* 164 */       for (int col = 0; col < 9; col++) {
/* 165 */         func_75146_a(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 90 + row * 18));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 172 */     ItemStack origStack = null;
/* 173 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/* 175 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 177 */       ItemStack slotStack = slot.func_75211_c();
/* 178 */       origStack = slotStack.func_77946_l();
/*     */       
/* 180 */       if (slotNum < 4) {
/* 181 */         if (!func_75135_a(slotStack, 4, this.field_75151_b.size(), true)) {
/* 182 */           return null;
/*     */         
/*     */         }
/*     */       }
/* 186 */       else if (!func_75135_a(slotStack, 0, 4, false)) {
/* 187 */         return null;
/*     */       } 
/*     */       
/* 190 */       if (slotStack.field_77994_a <= 0) {
/* 191 */         slot.func_75215_d(null);
/*     */       } else {
/* 193 */         slot.func_75218_e();
/*     */       } 
/* 195 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 196 */         return null;
/*     */       }
/* 198 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 201 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */