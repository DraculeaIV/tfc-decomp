/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotFirepit;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotFirepitFuel;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotFirepitIn;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotFirepitOut;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerFirepit extends ContainerTFC {
/*     */   private TEFirepit firepit;
/*     */   
/*     */   public ContainerFirepit(InventoryPlayer inventoryplayer, TEFirepit tileentityfirepit, World world, int x, int y, int z) {
/*  26 */     this.firepit = tileentityfirepit;
/*  27 */     this.firetemp = -1111.0F;
/*     */ 
/*     */     
/*  30 */     func_75146_a((Slot)new SlotFirepitIn(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 1, 80, 20));
/*     */     
/*  32 */     func_75146_a((Slot)new SlotFirepitFuel(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 0, 8, 8));
/*  33 */     func_75146_a((Slot)new SlotFirepit(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 3, 8, 26));
/*  34 */     func_75146_a((Slot)new SlotFirepit(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 4, 8, 44));
/*  35 */     func_75146_a((Slot)new SlotFirepit(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 5, 8, 62));
/*     */ 
/*     */     
/*  38 */     func_75146_a((Slot)new SlotFirepitOut(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 7, 71, 48));
/*  39 */     func_75146_a((Slot)new SlotFirepitOut(inventoryplayer.field_70458_d, (IInventory)tileentityfirepit, 8, 89, 48));
/*     */ 
/*     */     
/*  42 */     func_75146_a((Slot)new SlotForShowOnly((IInventory)tileentityfirepit, 2, -50000, 0));
/*  43 */     func_75146_a((Slot)new SlotForShowOnly((IInventory)tileentityfirepit, 6, -50000, 0));
/*  44 */     func_75146_a((Slot)new SlotForShowOnly((IInventory)tileentityfirepit, 9, -50000, 0));
/*  45 */     func_75146_a((Slot)new SlotForShowOnly((IInventory)tileentityfirepit, 10, -50000, 0));
/*     */     
/*  47 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 90, false, true);
/*     */   }
/*     */   
/*     */   private float firetemp;
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  59 */     ItemStack origStack = null;
/*  60 */     Slot slot = this.field_75151_b.get(slotNum);
/*  61 */     Slot slotinput = this.field_75151_b.get(0);
/*  62 */     Slot[] slotfuel = { this.field_75151_b.get(1), this.field_75151_b.get(3), this.field_75151_b.get(4), this.field_75151_b.get(5) };
/*     */     
/*  64 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  66 */       ItemStack slotStack = slot.func_75211_c();
/*  67 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  70 */       if (slotNum < 11) {
/*     */         
/*  72 */         if (!func_75135_a(slotStack, 11, this.field_75151_b.size(), true)) {
/*  73 */           return null;
/*     */         }
/*     */       } else {
/*     */         
/*  77 */         HeatRegistry manager = HeatRegistry.getInstance();
/*     */ 
/*     */         
/*  80 */         if (slotStack.func_77973_b() == TFCItems.logs || slotStack.func_77973_b() == Item.func_150898_a(TFCBlocks.peat)) {
/*     */           
/*  82 */           if (slotfuel[0].func_75216_d())
/*  83 */             return null; 
/*  84 */           ItemStack stack = slotStack.func_77946_l();
/*  85 */           stack.field_77994_a = 1;
/*  86 */           slotfuel[0].func_75215_d(stack);
/*  87 */           slotStack.field_77994_a--;
/*     */         
/*     */         }
/*  90 */         else if (!(slotStack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemOre) && manager.findMatchingIndex(slotStack) != null) {
/*     */           
/*  92 */           if (slotinput.func_75216_d())
/*  93 */             return null; 
/*  94 */           ItemStack stack = slotStack.func_77946_l();
/*  95 */           stack.field_77994_a = 1;
/*  96 */           slotinput.func_75215_d(stack);
/*  97 */           slotStack.field_77994_a--;
/*     */         } 
/*     */       } 
/*     */       
/* 101 */       if (slotStack.field_77994_a <= 0) {
/* 102 */         slot.func_75215_d(null);
/*     */       } else {
/* 104 */         slot.func_75218_e();
/*     */       } 
/* 106 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 107 */         return null;
/*     */       }
/* 109 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 112 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/* 118 */     super.func_75142_b(); int var1;
/* 119 */     for (var1 = 0; var1 < this.field_75151_b.size(); var1++) {
/*     */       
/* 121 */       ItemStack var2 = ((Slot)this.field_75151_b.get(var1)).func_75211_c();
/* 122 */       ItemStack var3 = this.field_75153_a.get(var1);
/*     */       
/* 124 */       if (!ItemStack.func_77989_b(var3, var2)) {
/*     */         
/* 126 */         var3 = (var2 == null) ? null : var2.func_77946_l();
/* 127 */         this.field_75153_a.set(var1, var3);
/*     */         
/* 129 */         for (int var4 = 0; var4 < this.field_75149_d.size(); var4++) {
/* 130 */           ((ICrafting)this.field_75149_d.get(var4)).func_71111_a(this, var1, var3);
/*     */         }
/*     */       } 
/*     */     } 
/* 134 */     for (var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/* 136 */       ICrafting var2 = this.field_75149_d.get(var1);
/* 137 */       if (this.firetemp != this.firepit.fireTemp) {
/* 138 */         var2.func_71112_a(this, 0, (int)this.firepit.fireTemp);
/*     */       }
/*     */     } 
/* 141 */     this.firetemp = this.firepit.fireTemp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int par1, int par2) {
/* 147 */     if (par1 == 0)
/* 148 */       this.firepit.fireTemp = par2; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */