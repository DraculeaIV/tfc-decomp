/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotLogPile;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TELogPile;
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
/*     */ public class ContainerLogPile
/*     */   extends ContainerTFC
/*     */ {
/*     */   private World world;
/*     */   private TELogPile logpile;
/*     */   private EntityPlayer player;
/*     */   
/*     */   public ContainerLogPile(InventoryPlayer playerinv, TELogPile pile, World world, int x, int y, int z) {
/*  25 */     this.player = playerinv.field_70458_d;
/*  26 */     this.logpile = pile;
/*  27 */     this.world = world;
/*     */ 
/*     */ 
/*     */     
/*  31 */     pile.func_70295_k_();
/*  32 */     layoutContainer((IInventory)playerinv, (IInventory)pile, 0, 0);
/*  33 */     PlayerInventory.buildInventoryLayout(this, playerinv, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer par1EntityPlayer) {
/*  42 */     super.func_75134_a(par1EntityPlayer);
/*     */     
/*  44 */     if (!this.world.field_72995_K) {
/*  45 */       this.logpile.func_70305_f();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  54 */     ItemStack origStack = null;
/*  55 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  57 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  59 */       ItemStack slotStack = slot.func_75211_c();
/*  60 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  63 */       if (slotNum < 4) {
/*     */         
/*  65 */         if (!func_75135_a(slotStack, 4, this.field_75151_b.size(), true)) {
/*  66 */           return null;
/*     */         
/*     */         }
/*     */       }
/*  70 */       else if (!func_75135_a(slotStack, 0, 4, false)) {
/*  71 */         return null;
/*     */       } 
/*     */       
/*  74 */       if (slotStack.field_77994_a <= 0) {
/*  75 */         slot.func_75215_d(null);
/*     */       } else {
/*  77 */         slot.func_75218_e();
/*     */       } 
/*  79 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/*  80 */         return null;
/*     */       }
/*  82 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/*  85 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int xSize, int ySize) {
/*  96 */     func_75146_a((Slot)new SlotLogPile(getPlayer(), chestInventory, 0, 71, 25));
/*  97 */     func_75146_a((Slot)new SlotLogPile(getPlayer(), chestInventory, 1, 89, 25));
/*  98 */     func_75146_a((Slot)new SlotLogPile(getPlayer(), chestInventory, 2, 71, 43));
/*  99 */     func_75146_a((Slot)new SlotLogPile(getPlayer(), chestInventory, 3, 89, 43));
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getPlayer() {
/* 104 */     return this.player;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerLogPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */