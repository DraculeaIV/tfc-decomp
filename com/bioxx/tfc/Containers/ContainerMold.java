/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotBlocked;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotMoldTool;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotMoldTool2;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerMold
/*     */   extends ContainerTFC
/*     */ {
/*     */   private World world;
/*     */   private EntityPlayer player;
/*  28 */   public InventoryCrafting containerInv = new InventoryCrafting(this, 2, 1);
/*  29 */   public IInventory craftResult = (IInventory)new InventoryCraftResult();
/*     */ 
/*     */   
/*     */   public ContainerMold(InventoryPlayer playerinv, World world, int x, int y, int z) {
/*  33 */     this.player = playerinv.field_70458_d;
/*  34 */     this.world = world;
/*     */ 
/*     */ 
/*     */     
/*  38 */     layoutContainer((IInventory)playerinv, 0, 0);
/*  39 */     PlayerInventory.buildInventoryLayout(this, playerinv, 8, 90, false, true);
/*  40 */     PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(playerinv.field_70458_d);
/*  41 */     this.containerInv.func_70299_a(0, pi.specialCraftingType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/*  50 */     super.func_75134_a(player);
/*  51 */     if (!this.world.field_72995_K) {
/*     */       
/*  53 */       ItemStack itemstack = this.craftResult.func_70304_b(0);
/*  54 */       ItemStack itemstack2 = this.containerInv.func_70304_b(0);
/*  55 */       ItemStack itemstack3 = this.containerInv.func_70304_b(1);
/*  56 */       if (itemstack != null)
/*  57 */         player.func_70099_a(itemstack, 0.0F); 
/*  58 */       if (itemstack2 != null)
/*  59 */         player.func_70099_a(itemstack2, 0.0F); 
/*  60 */       if (itemstack3 != null) {
/*  61 */         player.func_70099_a(itemstack3, 0.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void layoutContainer(IInventory playerInventory, int xSize, int ySize) {
/*  73 */     func_75146_a((Slot)new SlotMoldTool((IInventory)this.containerInv, 0, 41, 34));
/*  74 */     func_75146_a((Slot)new SlotMoldTool2((IInventory)this.containerInv, 1, 94, 34));
/*  75 */     func_75146_a((Slot)new SlotBlocked(this.craftResult, 0, 116, 34));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int id, int value) {
/*  81 */     if (id == 0) {
/*     */       
/*  83 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(this.player);
/*  84 */       pi.moldTransferTimer = (short)value;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  91 */     super.func_75142_b();
/*  92 */     if (this.craftResult.func_70301_a(0) == null) {
/*     */       
/*  94 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(this.player);
/*  95 */       short oldTransferTimer = pi.moldTransferTimer;
/*  96 */       ItemStack sourceStack = this.containerInv.func_70301_a(0);
/*  97 */       ItemStack inputStack = this.containerInv.func_70301_a(1);
/*     */       
/*  99 */       if (sourceStack != null && inputStack != null) {
/*     */         
/* 101 */         Item sourceItem = sourceStack.func_77973_b();
/* 102 */         Item inputItem = inputStack.func_77973_b();
/* 103 */         int inputDamage = inputStack.func_77960_j();
/*     */         
/* 105 */         if (sourceItem instanceof com.bioxx.tfc.Items.ItemMeltedMetal && inputItem == TFCItems.ceramicMold && inputDamage == 1 && TFC_ItemHeat.getIsLiquid(sourceStack).booleanValue()) {
/*     */           
/* 107 */           ItemStack is = sourceStack.func_77946_l();
/* 108 */           is.func_77964_b(100);
/* 109 */           this.containerInv.func_70299_a(1, is);
/* 110 */           pi.moldTransferTimer = 100;
/*     */         }
/* 112 */         else if (sourceItem instanceof com.bioxx.tfc.Items.ItemMeltedMetal && inputItem instanceof com.bioxx.tfc.Items.ItemMeltedMetal && sourceItem == inputItem && inputDamage != 0) {
/*     */           
/* 114 */           pi.moldTransferTimer = 100;
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       if (inputStack != null && pi.moldTransferTimer < 100 && 
/* 119 */         CraftingManagerTFC.getInstance().findMatchingRecipe(this.containerInv, this.world) != null)
/*     */       {
/* 121 */         pi.moldTransferTimer = (short)(pi.moldTransferTimer + 1);
/*     */       }
/*     */       
/* 124 */       if (sourceStack != null && inputStack != null && pi.moldTransferTimer == 1000)
/*     */       {
/* 126 */         pi.moldTransferTimer = 0;
/*     */       }
/*     */       
/* 129 */       if (sourceStack == null || inputStack == null)
/*     */       {
/* 131 */         pi.moldTransferTimer = 1000;
/*     */       }
/*     */       
/* 134 */       if (sourceStack != null && inputStack != null && pi.moldTransferTimer == 100) {
/*     */         
/* 136 */         Item sourceItem = sourceStack.func_77973_b();
/* 137 */         Item inputItem = inputStack.func_77973_b();
/* 138 */         int newSourceDamage = sourceStack.func_77960_j() + 1;
/* 139 */         int inputDamage = inputStack.func_77960_j();
/* 140 */         ItemStack recipeOutput = CraftingManagerTFC.getInstance().findMatchingRecipe(this.containerInv, this.world);
/*     */         
/* 142 */         if (sourceItem instanceof com.bioxx.tfc.Items.ItemMeltedMetal && inputItem instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */           
/* 144 */           if (sourceItem == inputItem && inputDamage != 0)
/*     */           {
/* 146 */             sourceStack.func_77964_b(newSourceDamage);
/* 147 */             inputStack.func_77964_b(inputDamage - 1);
/* 148 */             if (newSourceDamage >= sourceStack.func_77958_k() - 1)
/*     */             {
/* 150 */               this.containerInv.func_70299_a(0, new ItemStack(TFCItems.ceramicMold, 1, 1));
/*     */             }
/*     */           }
/*     */         
/* 154 */         } else if (recipeOutput != null) {
/*     */           
/* 156 */           recipeOutput.func_77982_d(inputStack.field_77990_d);
/* 157 */           this.craftResult.func_70299_a(0, recipeOutput);
/* 158 */           this.containerInv.func_70299_a(1, null);
/* 159 */           this.containerInv.func_70299_a(1, new ItemStack(TFCItems.ceramicMold, 1, 1));
/* 160 */           this.containerInv.func_70299_a(0, null);
/*     */         } 
/*     */       } 
/*     */       
/* 164 */       for (int i = 0; i < this.field_75149_d.size(); i++) {
/*     */         
/* 166 */         ICrafting player = this.field_75149_d.get(i);
/* 167 */         if (pi.moldTransferTimer != oldTransferTimer) {
/* 168 */           player.func_71112_a(this, 0, pi.moldTransferTimer);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 176 */     ItemStack origStack = null;
/* 177 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/* 179 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 181 */       ItemStack slotStack = slot.func_75211_c();
/* 182 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/* 185 */       if (slotNum < 3) {
/*     */         
/* 187 */         if (!func_75135_a(slotStack, 3, this.field_75151_b.size(), true)) {
/* 188 */           return null;
/*     */         
/*     */         }
/*     */       }
/* 192 */       else if (!func_75135_a(slotStack, 0, 3, false)) {
/* 193 */         return null;
/*     */       } 
/*     */       
/* 196 */       if (slotStack.field_77994_a <= 0) {
/* 197 */         slot.func_75215_d(null);
/*     */       } else {
/* 199 */         slot.func_75218_e();
/*     */       } 
/* 201 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 202 */         return null;
/*     */       }
/* 204 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 207 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */