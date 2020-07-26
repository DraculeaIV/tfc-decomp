/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotBlocked;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotFoodOnly;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotSize;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerFoodPrep
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TEFoodPrep te;
/*     */   private EntityPlayer player;
/*     */   private int guiTab;
/*     */   
/*     */   public ContainerFoodPrep(InventoryPlayer playerinv, TEFoodPrep pile, World world, int x, int y, int z, int tab) {
/*  30 */     this.player = playerinv.field_70458_d;
/*  31 */     this.te = pile;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  36 */     this.guiTab = tab;
/*  37 */     pile.func_70295_k_();
/*  38 */     layoutContainer((IInventory)playerinv, (IInventory)pile, 0, 0);
/*  39 */     pile.lastTab = tab;
/*  40 */     PlayerInventory.buildInventoryLayout(this, playerinv, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer par1EntityPlayer) {
/*  49 */     super.func_75134_a(par1EntityPlayer);
/*  50 */     this.te.func_70305_f();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int xSize, int ySize) {
/*  61 */     if (this.guiTab == 0) {
/*     */       
/*  63 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 0, 44, 24)).addItemInclusion(new Item[] { TFCItems.wheatBread, TFCItems.barleyBread, TFCItems.oatBread, TFCItems.ryeBread, TFCItems.riceBread, TFCItems.cornBread
/*  64 */             }).setSize(EnumSize.HUGE));
/*  65 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 1, 62, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  66 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 2, 80, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  67 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 3, 98, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  68 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 4, 116, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*     */ 
/*     */     
/*     */     }
/*  72 */     else if (this.guiTab == 1) {
/*     */       
/*  74 */       func_75146_a((Slot)new SlotBlocked(chestInventory, 0, 15, 8));
/*  75 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 1, 53, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  76 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 2, 71, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  77 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 3, 89, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*  78 */       func_75146_a((Slot)(new SlotFoodOnly(chestInventory, 4, 107, 24)).addItemException(new Item[] { TFCItems.woodenBucketMilk }).setSize(EnumSize.HUGE));
/*     */     } 
/*     */     
/*  81 */     func_75146_a((Slot)new SlotBlocked(chestInventory, 6, 53, 46));
/*  82 */     func_75146_a((Slot)(new SlotSize(chestInventory, 7, 145, 8)).setSize(EnumSize.SMALL));
/*  83 */     func_75146_a((Slot)(new SlotSize(chestInventory, 8, 145, 26)).setSize(EnumSize.SMALL));
/*  84 */     func_75146_a((Slot)(new SlotSize(chestInventory, 9, 145, 44)).setSize(EnumSize.SMALL));
/*  85 */     func_75146_a((Slot)(new SlotSize(chestInventory, 10, 145, 62)).setSize(EnumSize.SMALL));
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getPlayer() {
/*  90 */     return this.player;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  96 */     ItemStack origStack = null;
/*  97 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  99 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 101 */       ItemStack slotStack = slot.func_75211_c();
/* 102 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/* 105 */       if (slotNum < 10) {
/*     */         
/* 107 */         if (!func_75135_a(slotStack, 10, this.field_75151_b.size(), true)) {
/* 108 */           return null;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 113 */       else if (!func_75135_a(slotStack, 0, 10, false)) {
/* 114 */         return null;
/*     */       } 
/*     */       
/* 117 */       if (slotStack.field_77994_a <= 0) {
/* 118 */         slot.func_75215_d(null);
/*     */       } else {
/* 120 */         slot.func_75218_e();
/*     */       } 
/* 122 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 123 */         return null;
/*     */       }
/* 125 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 128 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */