/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotBlocked;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotQuern;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotQuernGrain;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEQuern;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerQuern
/*     */   extends ContainerTFC
/*     */ {
/*     */   private World world;
/*     */   private TEQuern te;
/*     */   private EntityPlayer player;
/*     */   
/*     */   public ContainerQuern(InventoryPlayer playerinv, TEQuern pile, World world, int x, int y, int z) {
/*  27 */     this.player = playerinv.field_70458_d;
/*  28 */     this.te = pile;
/*  29 */     this.world = world;
/*     */ 
/*     */ 
/*     */     
/*  33 */     pile.func_70295_k_();
/*  34 */     layoutContainer((IInventory)playerinv, (IInventory)pile, 0, 0);
/*  35 */     PlayerInventory.buildInventoryLayout(this, playerinv, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer par1EntityPlayer) {
/*  44 */     super.func_75134_a(par1EntityPlayer);
/*  45 */     if (!this.world.field_72995_K) {
/*  46 */       this.te.func_70305_f();
/*     */     } else {
/*  48 */       this.te.func_145829_t();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int xSize, int ySize) {
/*  59 */     func_75146_a((Slot)new SlotQuernGrain(chestInventory, 0, 66, 47));
/*  60 */     func_75146_a((Slot)new SlotBlocked(chestInventory, 1, 93, 47));
/*  61 */     func_75146_a((Slot)new SlotQuern(chestInventory, 2, 93, 20));
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getPlayer() {
/*  66 */     return this.player;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  72 */     ItemStack origStack = null;
/*  73 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  75 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  77 */       ItemStack slotStack = slot.func_75211_c();
/*  78 */       origStack = slotStack.func_77946_l();
/*     */       
/*  80 */       if (slotNum < 3) {
/*     */         
/*  82 */         if (!func_75135_a(slotStack, 3, this.field_75151_b.size(), true)) {
/*  83 */           return null;
/*     */         
/*     */         }
/*     */       }
/*  87 */       else if (!func_75135_a(slotStack, 0, 3, false)) {
/*  88 */         return null;
/*     */       } 
/*     */       
/*  91 */       if (slotStack.field_77994_a <= 0) {
/*  92 */         slot.func_75215_d(null);
/*     */       } else {
/*  94 */         slot.func_75218_e();
/*     */       } 
/*  96 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/*  97 */         return null;
/*     */       }
/*  99 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 102 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */