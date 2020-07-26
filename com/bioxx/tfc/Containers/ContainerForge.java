/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForge;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForgeFuel;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEForge;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerForge
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TEForge forge;
/*     */   private float firetemp;
/*     */   
/*     */   public ContainerForge(InventoryPlayer inventoryplayer, TEForge tileentityforge, World world, int x, int y, int z) {
/*  26 */     this.forge = tileentityforge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     func_75146_a((Slot)new SlotForge(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 0, 44, 8));
/*  33 */     func_75146_a((Slot)new SlotForge(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 1, 62, 26));
/*  34 */     func_75146_a((Slot)new SlotForge(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 2, 80, 44));
/*  35 */     func_75146_a((Slot)new SlotForge(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 3, 98, 26));
/*  36 */     func_75146_a((Slot)new SlotForge(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 4, 116, 8));
/*     */     
/*  38 */     func_75146_a((Slot)new SlotForgeFuel(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 5, 44, 26));
/*  39 */     func_75146_a((Slot)new SlotForgeFuel(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 6, 62, 44));
/*  40 */     func_75146_a((Slot)new SlotForgeFuel(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 7, 80, 62));
/*  41 */     func_75146_a((Slot)new SlotForgeFuel(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 8, 98, 44));
/*  42 */     func_75146_a((Slot)new SlotForgeFuel(inventoryplayer.field_70458_d, (IInventory)tileentityforge, 9, 116, 26));
/*     */     
/*  44 */     func_75146_a(new Slot((IInventory)tileentityforge, 10, 152, 8));
/*  45 */     func_75146_a(new Slot((IInventory)tileentityforge, 11, 152, 26));
/*  46 */     func_75146_a(new Slot((IInventory)tileentityforge, 12, 152, 44));
/*  47 */     func_75146_a(new Slot((IInventory)tileentityforge, 13, 152, 62));
/*     */     
/*  49 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  61 */     ItemStack origStack = null;
/*  62 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  64 */     Slot[] slotfuel = { this.field_75151_b.get(7), this.field_75151_b.get(6), this.field_75151_b.get(8), this.field_75151_b.get(5), this.field_75151_b.get(9) };
/*     */     
/*  66 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  68 */       ItemStack slotStack = slot.func_75211_c();
/*  69 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  72 */       if (slotNum < 14) {
/*     */         
/*  74 */         if (!func_75135_a(slotStack, 14, this.field_75151_b.size(), true)) {
/*  75 */           return null;
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*  81 */       else if (slotStack.func_77973_b() == TFCItems.coal) {
/*     */         
/*  83 */         int j = 0;
/*  84 */         while (j < 5) {
/*     */           
/*  86 */           if (slotfuel[j].func_75216_d()) {
/*     */             
/*  88 */             j++;
/*     */             
/*     */             continue;
/*     */           } 
/*  92 */           ItemStack stack = slotStack.func_77946_l();
/*  93 */           stack.field_77994_a = 1;
/*  94 */           slotfuel[j].func_75215_d(stack);
/*  95 */           slotStack.field_77994_a--;
/*  96 */           j = -1;
/*     */         } 
/*     */ 
/*     */         
/* 100 */         if (j > 0 && !func_75135_a(slotStack, 10, 14, false)) {
/* 101 */           return null;
/*     */         }
/*     */       }
/* 104 */       else if (!func_75135_a(slotStack, 0, 5, false) && !func_75135_a(slotStack, 10, 14, false)) {
/* 105 */         return null;
/*     */       } 
/*     */       
/* 108 */       if (slotStack.field_77994_a <= 0) {
/* 109 */         slot.func_75215_d(null);
/*     */       } else {
/* 111 */         slot.func_75218_e();
/*     */       } 
/* 113 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 114 */         return null;
/*     */       }
/* 116 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 119 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/* 125 */     super.func_75142_b();
/*     */     
/* 127 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/* 129 */       ICrafting var2 = this.field_75149_d.get(var1);
/* 130 */       if (this.firetemp != this.forge.fireTemp) {
/* 131 */         var2.func_71112_a(this, 0, (int)this.forge.fireTemp);
/*     */       }
/*     */     } 
/* 134 */     this.firetemp = this.forge.fireTemp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int par1, int par2) {
/* 140 */     if (par1 == 0)
/* 141 */       this.forge.fireTemp = par2; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */