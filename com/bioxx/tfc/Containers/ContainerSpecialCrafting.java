/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotSpecialCraftingOutput;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Items.Tools.ItemMiscToolHead;
/*     */ import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ContainerSpecialCrafting
/*     */   extends ContainerTFC
/*     */ {
/*  27 */   public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 5);
/*     */   
/*     */   private SlotSpecialCraftingOutput outputSlot;
/*     */   
/*     */   private boolean decreasedStack;
/*     */   
/*  33 */   public IInventory craftResult = (IInventory)new InventoryCraftResult();
/*     */   private World worldObj;
/*     */   private InventoryPlayer invPlayer;
/*     */   private boolean isConstructing;
/*     */   
/*     */   public ContainerSpecialCrafting(InventoryPlayer inventoryplayer, ItemStack is, World world, int x, int y, int z) {
/*  39 */     this.invPlayer = inventoryplayer;
/*  40 */     this.worldObj = world;
/*  41 */     this.decreasedStack = false;
/*  42 */     this.isConstructing = true;
/*  43 */     this.bagsSlotNum = inventoryplayer.field_70461_c;
/*  44 */     for (int j1 = 0; j1 < 25; j1++) {
/*     */       
/*  46 */       if (is != null) {
/*  47 */         this.craftMatrix.func_70299_a(j1, is.func_77946_l());
/*     */       }
/*     */     } 
/*  50 */     this.outputSlot = new SlotSpecialCraftingOutput(this, inventoryplayer.field_70458_d, (IInventory)this.craftMatrix, this.craftResult, 0, 128, 44);
/*  51 */     func_75146_a((Slot)this.outputSlot);
/*     */     
/*  53 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 108, true, true);
/*     */     
/*  55 */     func_75130_a((IInventory)this.craftMatrix);
/*  56 */     this.isConstructing = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/*  62 */     super.func_75134_a(player);
/*  63 */     if (!this.worldObj.field_72995_K) {
/*     */       
/*  65 */       ItemStack is = this.craftResult.func_70304_b(0);
/*  66 */       if (is != null) {
/*  67 */         player.func_70099_a(is, 0.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75130_a(IInventory ii) {
/*  77 */     ItemStack result = CraftingManagerTFC.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
/*     */ 
/*     */     
/*  80 */     if (!this.decreasedStack && !this.isConstructing) {
/*     */       
/*  82 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(this.invPlayer.field_70458_d);
/*     */ 
/*     */       
/*  85 */       if (pi.specialCraftingType.func_77973_b() == TFCItems.flatClay) {
/*     */         
/*  87 */         if (result != null) {
/*     */           
/*  89 */           setDecreasedStack(Boolean.valueOf(true));
/*  90 */           if (!this.worldObj.field_72995_K && (this.invPlayer.func_70448_g()).field_77994_a >= 5) {
/*  91 */             this.invPlayer.func_70298_a(this.invPlayer.field_70461_c, 5);
/*     */           } else {
/*     */             
/*  94 */             setDecreasedStack(Boolean.valueOf(false));
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/* 100 */       } else if (hasPieceBeenRemoved(pi)) {
/*     */         
/* 102 */         setDecreasedStack(Boolean.valueOf(true));
/* 103 */         if (!this.worldObj.field_72995_K) {
/* 104 */           this.invPlayer.func_146026_a(this.invPlayer.func_70448_g().func_77973_b());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     if (this.decreasedStack) {
/*     */       
/* 111 */       this.craftResult.func_70299_a(0, result);
/*     */ 
/*     */       
/* 114 */       if (result != null && this.invPlayer.field_70458_d != null) {
/*     */         
/* 116 */         Item item = result.func_77973_b();
/* 117 */         if (item instanceof ItemMiscToolHead && ((ItemMiscToolHead)item).getMaterial() != null && (((ItemMiscToolHead)item)
/* 118 */           .getMaterial() == TFCItems.igInToolMaterial || ((ItemMiscToolHead)item)
/* 119 */           .getMaterial() == TFCItems.sedToolMaterial || ((ItemMiscToolHead)item)
/* 120 */           .getMaterial() == TFCItems.igExToolMaterial || ((ItemMiscToolHead)item)
/* 121 */           .getMaterial() == TFCItems.mMToolMaterial)) {
/*     */           
/* 123 */           this.invPlayer.field_70458_d.func_71029_a((StatBase)TFC_Achievements.achStoneAge);
/* 124 */           if (item == TFCItems.stoneKnifeHead && result.field_77994_a == 2) {
/* 125 */             this.invPlayer.field_70458_d.func_71029_a((StatBase)TFC_Achievements.achTwoKnives);
/*     */           }
/* 127 */         } else if (item == Item.func_150898_a(TFCBlocks.crucible)) {
/* 128 */           this.invPlayer.field_70458_d.func_71029_a((StatBase)TFC_Achievements.achCrucible);
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
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 140 */     ItemStack origStack = null;
/* 141 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/* 143 */     if (slot != null && slot instanceof SlotSpecialCraftingOutput && slot.func_75216_d()) {
/*     */       
/* 145 */       ItemStack slotStack = slot.func_75211_c();
/* 146 */       origStack = slotStack.func_77946_l();
/*     */       
/* 148 */       if (slotNum < 1 && !func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
/* 149 */         return null;
/*     */       }
/* 151 */       if (slotStack.field_77994_a <= 0) {
/* 152 */         slot.func_75215_d(null);
/*     */       } else {
/* 154 */         slot.func_75218_e();
/*     */       } 
/* 156 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 157 */         return null;
/*     */       }
/* 159 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 162 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPieceBeenRemoved(PlayerInfo pi) {
/* 174 */     for (int i = 0; i < this.craftMatrix.func_70302_i_(); i++) {
/*     */       
/* 176 */       if (this.craftMatrix.func_70301_a(i) == null) {
/* 177 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 181 */     setDecreasedStack(Boolean.valueOf(false));
/* 182 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDecreasedStack(Boolean b) {
/* 187 */     this.decreasedStack = b.booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerSpecialCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */