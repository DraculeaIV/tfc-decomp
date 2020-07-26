/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotChest;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEChest;
/*     */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerChestTFC
/*     */   extends ContainerTFC
/*     */ {
/*     */   private IInventory lowerChestInventory;
/*     */   private int numRows;
/*     */   
/*     */   public ContainerChestTFC(IInventory playerInv, IInventory chestInv, World world, int x, int y, int z) {
/*  29 */     TEChest chest = (TEChest)chestInv;
/*  30 */     this.lowerChestInventory = chestInv;
/*     */     
/*  32 */     if (chest.field_145991_k != null) {
/*  33 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", (IInventory)chest.field_145991_k, chestInv);
/*     */     }
/*  35 */     if (chest.field_145990_j != null) {
/*  36 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", chestInv, (IInventory)chest.field_145990_j);
/*     */     }
/*  38 */     if (chest.field_145992_i != null) {
/*  39 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", (IInventory)chest.field_145992_i, chestInv);
/*     */     }
/*  41 */     if (chest.field_145988_l != null) {
/*  42 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", chestInv, (IInventory)chest.field_145988_l);
/*     */     }
/*  44 */     this.numRows = this.lowerChestInventory.func_70302_i_() / 9;
/*  45 */     this.lowerChestInventory.func_70295_k_();
/*  46 */     int var3 = (this.numRows - 4) * 18;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     for (int var4 = 0; var4 < this.numRows; var4++) {
/*     */       
/*  54 */       for (int var5 = 0; var5 < 9; var5++)
/*     */       {
/*  56 */         func_75146_a((Slot)(new SlotChest(this.lowerChestInventory, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18)).addItemException(getExceptions()));
/*     */       }
/*     */     } 
/*     */     
/*  60 */     PlayerInventory.buildInventoryLayout(this, (InventoryPlayer)playerInv, 8, var3 + 109, false, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Item> getExceptions() {
/*  65 */     List<Item> exceptions = new ArrayList<Item>();
/*  66 */     for (Item ingot : TEIngotPile.getIngots())
/*     */     {
/*  68 */       exceptions.add(ingot);
/*     */     }
/*  70 */     exceptions.add(TFCItems.logs);
/*  71 */     exceptions.add(Item.func_150898_a(TFCBlocks.barrel));
/*  72 */     exceptions.add(Item.func_150898_a(TFCBlocks.vessel));
/*  73 */     return exceptions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
/*  79 */     return this.lowerChestInventory.func_70300_a(par1EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  88 */     ItemStack origStack = null;
/*  89 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  91 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  93 */       ItemStack slotStack = slot.func_75211_c();
/*  94 */       origStack = slotStack.func_77946_l();
/*  95 */       int chestSlotCount = this.numRows * 9;
/*     */ 
/*     */       
/*  98 */       if (slotNum < chestSlotCount) {
/*     */         
/* 100 */         if (!func_75135_a(slotStack, chestSlotCount, this.field_75151_b.size(), true)) {
/* 101 */           return null;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 106 */       else if (!func_75135_a(slotStack, 0, chestSlotCount, false)) {
/* 107 */         return null;
/*     */       } 
/*     */       
/* 110 */       if (slotStack.field_77994_a <= 0) {
/* 111 */         slot.func_75215_d(null);
/*     */       } else {
/* 113 */         slot.func_75218_e();
/*     */       } 
/* 115 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 116 */         return null;
/*     */       }
/* 118 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 121 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer par1EntityPlayer) {
/* 130 */     super.func_75134_a(par1EntityPlayer);
/* 131 */     this.lowerChestInventory.func_70305_f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IInventory getLowerChestInventory() {
/* 139 */     return this.lowerChestInventory;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerChestTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */