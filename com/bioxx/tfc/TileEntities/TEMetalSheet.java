/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEMetalSheet
/*     */   extends NetworkTileEntity
/*     */ {
/*     */   public ItemStack sheetStack;
/*     */   private byte sides;
/*     */   public int metalID;
/*     */   
/*     */   public void clearSides() {
/*  19 */     this.sides = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean topExists() {
/*  24 */     return ((this.sides & 0x1) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean bottomExists() {
/*  29 */     return ((this.sides & 0x2) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean northExists() {
/*  34 */     return ((this.sides & 0x4) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean southExists() {
/*  39 */     return ((this.sides & 0x8) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean eastExists() {
/*  44 */     return ((this.sides & 0x10) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean westExists() {
/*  49 */     return ((this.sides & 0x20) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toggleBySide(int side, boolean setOn) {
/*  54 */     switch (side) {
/*     */       case 0:
/*  56 */         toggleBottom(setOn); break;
/*  57 */       case 1: toggleTop(setOn); break;
/*  58 */       case 2: toggleNorth(setOn); break;
/*  59 */       case 3: toggleSouth(setOn); break;
/*  60 */       case 4: toggleEast(setOn); break;
/*  61 */       case 5: toggleWest(setOn); break;
/*     */     } 
/*  63 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toggleTop(boolean setOn) {
/*  68 */     if (topExists() && !setOn) {
/*  69 */       this.sides = (byte)(this.sides - 1);
/*     */     } else {
/*  71 */       this.sides = (byte)(this.sides + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggleBottom(boolean setOn) {
/*  76 */     if (bottomExists() && !setOn) {
/*  77 */       this.sides = (byte)(this.sides - 2);
/*     */     } else {
/*  79 */       this.sides = (byte)(this.sides + 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggleNorth(boolean setOn) {
/*  84 */     if (northExists() && !setOn) {
/*  85 */       this.sides = (byte)(this.sides - 4);
/*     */     } else {
/*  87 */       this.sides = (byte)(this.sides + 4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggleSouth(boolean setOn) {
/*  92 */     if (southExists() && !setOn) {
/*  93 */       this.sides = (byte)(this.sides - 8);
/*     */     } else {
/*  95 */       this.sides = (byte)(this.sides + 8);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggleEast(boolean setOn) {
/* 100 */     if (eastExists() && !setOn) {
/* 101 */       this.sides = (byte)(this.sides - 16);
/*     */     } else {
/* 103 */       this.sides = (byte)(this.sides + 16);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggleWest(boolean setOn) {
/* 108 */     if (westExists() && !setOn) {
/* 109 */       this.sides = (byte)(this.sides - 32);
/*     */     } else {
/* 111 */       this.sides = (byte)(this.sides + 32);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 116 */     return (!topExists() && !bottomExists() && !northExists() && !southExists() && !eastExists() && !westExists());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 128 */     super.func_145839_a(nbt);
/* 129 */     this.sheetStack = ItemStack.func_77949_a(nbt.func_74775_l("sheetType"));
/* 130 */     this.sides = nbt.func_74771_c("sides");
/* 131 */     this.metalID = nbt.func_74762_e("metalID");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 137 */     super.func_145841_b(nbt);
/* 138 */     nbt.func_74774_a("sides", this.sides);
/* 139 */     NBTTagCompound st = new NBTTagCompound();
/* 140 */     if (this.sheetStack != null)
/* 141 */       this.sheetStack.func_77955_b(st); 
/* 142 */     nbt.func_74782_a("sheetType", (NBTBase)st);
/* 143 */     nbt.func_74768_a("metalID", this.metalID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 148 */     this.sides = nbt.func_74771_c("sides");
/* 149 */     this.metalID = nbt.func_74762_e("metalID");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 162 */     nbt.func_74774_a("sides", this.sides);
/* 163 */     nbt.func_74768_a("metalID", this.metalID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEMetalSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */