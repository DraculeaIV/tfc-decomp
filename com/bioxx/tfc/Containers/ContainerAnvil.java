/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotAnvilFlux;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotAnvilHammer;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotAnvilIn;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotAnvilWeldOut;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerAnvil
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TEAnvil anvil;
/*     */   private int greenIndicator;
/*     */   private int redIndicator;
/*  24 */   private int tier = -1;
/*     */ 
/*     */   
/*     */   public ContainerAnvil(InventoryPlayer inventoryplayer, TEAnvil anvil, World world, int x, int y, int z) {
/*  28 */     this.anvil = anvil;
/*     */     
/*  30 */     this.redIndicator = -1000;
/*  31 */     this.greenIndicator = -1000;
/*     */ 
/*     */     
/*  34 */     func_75146_a((Slot)new SlotAnvilHammer(inventoryplayer.field_70458_d, (IInventory)anvil, 0, 7, 95));
/*     */     
/*  36 */     func_75146_a((Slot)new SlotAnvilIn((IInventory)anvil, 1, 87, 46));
/*     */ 
/*     */     
/*  39 */     func_75146_a((Slot)new SlotAnvilIn((IInventory)anvil, 2, 14, 12));
/*  40 */     func_75146_a((Slot)new SlotAnvilIn((IInventory)anvil, 3, 32, 12));
/*  41 */     func_75146_a((Slot)new SlotAnvilWeldOut((IInventory)anvil, 4, 23, 34));
/*     */     
/*  43 */     func_75146_a((Slot)new SlotAnvilIn((IInventory)anvil, 5, 105, 46));
/*     */     
/*  45 */     func_75146_a((Slot)new SlotAnvilFlux((IInventory)anvil, 6, 185, 95));
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
/*     */     
/*  61 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 24, 122, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  68 */     ItemStack origStack = null;
/*  69 */     Slot slot = this.field_75151_b.get(slotNum);
/*  70 */     Slot slothammer = this.field_75151_b.get(0);
/*  71 */     Slot[] slotinput = { this.field_75151_b.get(1), this.field_75151_b.get(2), this.field_75151_b.get(3), this.field_75151_b.get(5) };
/*     */     
/*  73 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  75 */       ItemStack slotStack = slot.func_75211_c();
/*  76 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  79 */       if (slotNum < 7) {
/*     */         
/*  81 */         if (!func_75135_a(slotStack, 7, this.field_75151_b.size(), true)) {
/*  82 */           return null;
/*     */         }
/*     */       }
/*  85 */       else if (slotStack.func_77973_b() == TFCItems.powder && slotStack.func_77960_j() == 0) {
/*     */         
/*  87 */         if (!func_75135_a(slotStack, 6, 7, false)) {
/*  88 */           return null;
/*     */         }
/*     */       }
/*  91 */       else if (slotStack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer) {
/*     */         
/*  93 */         if (slothammer.func_75216_d())
/*  94 */           return null; 
/*  95 */         ItemStack stack = slotStack.func_77946_l();
/*  96 */         stack.field_77994_a = 1;
/*  97 */         slothammer.func_75215_d(stack);
/*  98 */         slotStack.field_77994_a--;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 103 */         int j = 0;
/* 104 */         while (j < slotinput.length) {
/*     */           
/* 106 */           if (slotinput[j].func_75216_d()) {
/* 107 */             j++;
/*     */             continue;
/*     */           } 
/* 110 */           ItemStack stack = slotStack.func_77946_l();
/* 111 */           stack.field_77994_a = 1;
/* 112 */           slotinput[j].func_75215_d(stack);
/* 113 */           slotStack.field_77994_a--;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 119 */       if (slotStack.field_77994_a <= 0) {
/* 120 */         slot.func_75215_d(null);
/*     */       } else {
/* 122 */         slot.func_75218_e();
/*     */       } 
/* 124 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 125 */         return null;
/*     */       }
/* 127 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 130 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/* 136 */     super.func_75142_b();
/*     */     
/* 138 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/* 140 */       ICrafting var2 = this.field_75149_d.get(var1);
/* 141 */       int cv = this.anvil.getCraftingValue();
/* 142 */       int icv = this.anvil.getItemCraftingValueNoSet(1);
/* 143 */       int t = this.anvil.anvilTier;
/*     */       
/* 145 */       if (this.redIndicator != cv)
/* 146 */         var2.func_71112_a(this, 0, cv); 
/* 147 */       if (this.greenIndicator != icv)
/* 148 */         var2.func_71112_a(this, 1, icv); 
/* 149 */       if (this.tier != t) {
/* 150 */         var2.func_71112_a(this, 2, t);
/*     */       }
/*     */     } 
/* 153 */     this.redIndicator = this.anvil.craftingValue;
/* 154 */     this.greenIndicator = this.anvil.itemCraftingValue;
/* 155 */     this.tier = this.anvil.anvilTier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int par1, int par2) {
/* 165 */     if (this.anvil != null)
/*     */     {
/* 167 */       if (par1 == 0) {
/* 168 */         this.anvil.craftingValue = par2;
/* 169 */       } else if (par1 == 1) {
/* 170 */         this.anvil.itemCraftingValue = par2;
/* 171 */       } else if (par1 == 2) {
/* 172 */         this.anvil.anvilTier = par2;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer par1EntityPlayer) {
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */