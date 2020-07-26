/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotExtraEquipable;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerInventory
/*     */ {
/*  24 */   public static int invXSize = 176;
/*  25 */   public static int invYSize = 87;
/*  26 */   private static ResourceLocation invTexture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_inventory_lower.png");
/*     */   
/*     */   public static InventoryCrafting containerInv;
/*     */   private static int index;
/*     */   
/*     */   public static void buildInventoryLayout(Container container, InventoryPlayer inventory, int x, int y, boolean freezeSlot, boolean toolBarAfterMainInv) {
/*  32 */     index = 0;
/*  33 */     if (!toolBarAfterMainInv) {
/*  34 */       addToolbarSlots(container, inventory, x, y, freezeSlot);
/*     */     }
/*  36 */     for (int i = 0; i < 3; i++) {
/*     */       
/*  38 */       for (int k = 0; k < 9; k++) {
/*     */         
/*  40 */         index = k + (i + 1) * 9;
/*  41 */         addSlotToContainer(container, new Slot((IInventory)inventory, index, x + k * 18, y + i * 18));
/*     */       } 
/*     */     } 
/*     */     
/*  45 */     if (toolBarAfterMainInv) {
/*  46 */       addToolbarSlots(container, inventory, x, y, freezeSlot);
/*     */     }
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadBagInventory(ItemStack is, Container c) {
/*  68 */     if (is != null && is.func_77942_o()) {
/*     */       
/*  70 */       NBTTagList nbttaglist = is.func_77978_p().func_150295_c("Items", 10);
/*  71 */       containerInv = new InventoryCrafting(c, 4, 2);
/*  72 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/*  74 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  75 */         byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  76 */         if (byte0 >= 0 && byte0 < 8)
/*  77 */           containerInv.func_70299_a(byte0, ItemStack.func_77949_a(nbttagcompound1)); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void addExtraEquipables(Container container, InventoryPlayer inventory, int x, int y, boolean freezeSlot) {
/*  83 */     int index = 40;
/*  84 */     addSlotToContainer(container, (Slot)new SlotExtraEquipable((IInventory)inventory, index, 26, 26, IEquipable.EquipType.BACK));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addToolbarSlots(Container container, InventoryPlayer inventory, int x, int y, boolean freezeSlot) {
/*  89 */     for (int j = 0; j < 9; j++) {
/*     */       
/*  91 */       if (freezeSlot && j == inventory.field_70461_c) {
/*  92 */         addSlotToContainer(container, (Slot)new SlotForShowOnly((IInventory)inventory, j, x + j * 18, y + 58));
/*     */       } else {
/*  94 */         addSlotToContainer(container, new Slot((IInventory)inventory, j, x + j * 18, y + 58));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void buildInventoryLayout(Container container, InventoryPlayer inventory, int x, int y, boolean freezeSlot) {
/* 100 */     buildInventoryLayout(container, inventory, x, y, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void buildInventoryLayout(Container container, InventoryPlayer inventory, int x, int y) {
/* 105 */     buildInventoryLayout(container, inventory, x, y, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static Slot addSlotToContainer(Container container, Slot par1Slot) {
/* 110 */     par1Slot.field_75222_d = container.field_75151_b.size();
/* 111 */     container.field_75151_b.add(par1Slot);
/* 112 */     container.field_75153_a.add(null);
/* 113 */     return par1Slot;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawInventory(GuiContainer container, int screenWidth, int screenHeight, int upperGuiHeight) {
/* 118 */     TFC_Core.bindTexture(invTexture);
/* 119 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 120 */     int l = (screenWidth - invXSize) / 2;
/* 121 */     int i1 = (screenHeight - upperGuiHeight + invYSize) / 2 + upperGuiHeight;
/* 122 */     container.func_73729_b(l, i1, 0, 0, invXSize, invYSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InventoryPlayerTFC getInventory(EntityPlayer p) {
/* 134 */     return (InventoryPlayerTFC)p.field_71071_by;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void upgradePlayerCrafting(EntityPlayer player) {
/* 139 */     if (player.getEntityData().func_74764_b("craftingTable")) {
/*     */       
/* 141 */       (player.field_71069_bz.func_75139_a(45)).field_75223_e += 50000;
/* 142 */       (player.field_71069_bz.func_75139_a(46)).field_75223_e += 50000;
/* 143 */       (player.field_71069_bz.func_75139_a(47)).field_75223_e += 50000;
/* 144 */       (player.field_71069_bz.func_75139_a(48)).field_75223_e += 50000;
/* 145 */       (player.field_71069_bz.func_75139_a(49)).field_75223_e += 50000;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack transferStackInSlot(EntityPlayer player, ItemStack stackToXfer) {
/* 152 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\PlayerInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */