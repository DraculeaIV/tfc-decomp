/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotChest;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ 
/*     */ 
/*     */ public class ContainerBarrel
/*     */   extends ContainerTFC
/*     */ {
/*     */   public TEBarrel barrel;
/*     */   public float liquidLevel;
/*     */   public int liquidID;
/*  28 */   public int sealedTime = -1;
/*     */   
/*     */   public int guiTab;
/*     */   
/*     */   public ContainerBarrel(InventoryPlayer inventoryplayer, TEBarrel tileentitybarrel, World world, int x, int y, int z, int tab) {
/*  33 */     this.barrel = tileentitybarrel;
/*  34 */     this.liquidLevel = 0.0F;
/*  35 */     this.liquidID = -1;
/*  36 */     this.guiTab = tab;
/*     */     
/*  38 */     buildLayout();
/*     */     
/*  40 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Item> getExceptions() {
/*  46 */     List<Item> exceptions = new ArrayList<Item>();
/*  47 */     exceptions.add(Item.func_150898_a(TFCBlocks.barrel));
/*  48 */     exceptions.add(Item.func_150898_a(TFCBlocks.vessel));
/*  49 */     return exceptions;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void buildLayout() {
/*  54 */     if (this.guiTab == 0) {
/*     */ 
/*     */       
/*  57 */       if (!this.barrel.getSealed()) {
/*  58 */         func_75146_a((Slot)(new SlotChest((IInventory)this.barrel, 0, 80, 29)).setSize(EnumSize.LARGE).addItemException(getExceptions()));
/*     */       } else {
/*  60 */         func_75146_a((Slot)new SlotForShowOnly((IInventory)this.barrel, 0, 80, 29));
/*     */       } 
/*  62 */     } else if (this.guiTab == 1) {
/*     */       
/*  64 */       for (int i = 0; i < 4; i++) {
/*     */         
/*  66 */         for (int k = 0; k < 3; k++) {
/*     */           
/*  68 */           if (!this.barrel.getSealed()) {
/*  69 */             func_75146_a((Slot)(new SlotChest((IInventory)this.barrel, k + i * 3, 53 + i * 18, 17 + k * 18)).setSize(EnumSize.LARGE).addItemException(ContainerChestTFC.getExceptions()));
/*     */           } else {
/*  71 */             func_75146_a((Slot)new SlotForShowOnly((IInventory)this.barrel, k + i * 3, 53 + i * 18, 17 + k * 18));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  86 */     ItemStack origStack = null;
/*  87 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  89 */     if (!this.barrel.getSealed() && slot != null && slot.func_75216_d()) {
/*     */       
/*  91 */       ItemStack slotStack = slot.func_75211_c();
/*  92 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  95 */       if (slotNum < 1 && this.guiTab == 0) {
/*     */         
/*  97 */         if (!func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
/*  98 */           return null;
/*     */         }
/*     */       }
/* 101 */       else if (slotNum < 12 && this.guiTab == 1) {
/*     */         
/* 103 */         if (!func_75135_a(slotStack, 12, this.field_75151_b.size(), true)) {
/* 104 */           return null;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 109 */       else if (this.guiTab == 1) {
/*     */         
/* 111 */         if (!func_75135_a(slotStack, 0, 12, false)) {
/* 112 */           return null;
/*     */         }
/*     */       }
/* 115 */       else if (this.guiTab == 0) {
/*     */         
/* 117 */         if (!func_75135_a(slotStack, 0, 1, false)) {
/* 118 */           return null;
/*     */         }
/*     */       } 
/*     */       
/* 122 */       if (slotStack.field_77994_a <= 0) {
/* 123 */         slot.func_75215_d(null);
/*     */       } else {
/* 125 */         slot.func_75218_e();
/*     */       } 
/* 127 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 128 */         return null;
/*     */       }
/* 130 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 133 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/* 140 */     super.func_75142_b();
/*     */     
/* 142 */     for (int var1 = 0; var1 < this.field_75149_d.size() && this.guiTab == 0; var1++) {
/*     */       
/* 144 */       ICrafting var2 = this.field_75149_d.get(var1);
/*     */       
/* 146 */       if (this.barrel.getFluidStack() != null && this.liquidID != this.barrel.getFluidStack().getFluidID()) {
/*     */         
/* 148 */         this.liquidID = this.barrel.getFluidStack().getFluidID();
/* 149 */         var2.func_71112_a(this, 0, this.barrel.getFluidStack().getFluidID());
/*     */       } 
/* 151 */       if (this.liquidLevel != this.barrel.getFluidLevel()) {
/*     */         
/* 153 */         this.liquidLevel = this.barrel.getFluidLevel();
/* 154 */         var2.func_71112_a(this, 1, this.barrel.getFluidLevel());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int id, int val) {
/* 162 */     if (id == 0) {
/*     */       
/* 164 */       if (this.barrel.fluid != null) {
/*     */         
/* 166 */         this.barrel.fluid = new FluidStack(val, this.barrel.fluid.amount);
/*     */       }
/*     */       else {
/*     */         
/* 170 */         this.barrel.fluid = new FluidStack(val, 1000);
/*     */       } 
/* 172 */       this.barrel.processItems();
/*     */     }
/* 174 */     else if (id == 1) {
/*     */       
/* 176 */       if (this.barrel.fluid != null)
/* 177 */         this.barrel.fluid.amount = val; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */