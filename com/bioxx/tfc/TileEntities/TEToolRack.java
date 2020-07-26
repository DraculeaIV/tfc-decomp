/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEToolRack
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*  25 */   public ItemStack[] storage = new ItemStack[4];
/*  26 */   public byte woodType = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public void addContents(int index, ItemStack is) {
/*  31 */     if (this.storage[index] == null) {
/*  32 */       this.storage[index] = is;
/*     */     }
/*     */   }
/*     */   
/*     */   public void clearContents() {
/*  37 */     this.storage[0] = null;
/*  38 */     this.storage[1] = null;
/*  39 */     this.storage[2] = null;
/*  40 */     this.storage[3] = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  47 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contentsMatch(int index, ItemStack is) {
/*  52 */     return (this.storage[index] != null && this.storage[index]
/*  53 */       .func_77973_b() == is.func_77973_b() && this.storage[index]
/*  54 */       .func_77960_j() == is.func_77960_j() && (this.storage[index]).field_77994_a < this.storage[index]
/*  55 */       .func_77976_d());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  61 */     if (this.storage[i] != null) {
/*     */       
/*  63 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/*  65 */         ItemStack itemstack = this.storage[i];
/*  66 */         this.storage[i] = null;
/*  67 */         return itemstack;
/*     */       } 
/*  69 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/*  70 */       if ((this.storage[i]).field_77994_a == 0)
/*  71 */         this.storage[i] = null; 
/*  72 */       return itemstack1;
/*     */     } 
/*     */ 
/*     */     
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/*  82 */     float f3 = 0.05F;
/*     */     
/*  84 */     Random rand = new Random();
/*  85 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/*  86 */     float f1 = rand.nextFloat() * 0.8F + 0.4F;
/*  87 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/*  89 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/*  91 */       if (this.storage[i] != null) {
/*     */         
/*  93 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/*  94 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/*  95 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/*  96 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/*  97 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*  98 */         this.storage[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectItem(int index, int dir) {
/* 105 */     float f3 = 0.05F;
/*     */     
/* 107 */     Random rand = new Random();
/* 108 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 109 */     float f1 = rand.nextFloat() * 0.2F + 0.1F;
/* 110 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 112 */     if (this.storage[index] != null) {
/*     */       
/* 114 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[index]);
/* 115 */       entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 116 */       entityitem.field_70181_x = 0.0D;
/* 117 */       entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 118 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/* 119 */       this.storage[index] = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 126 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 132 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 138 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 144 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void injectContents(int index, int count) {
/* 149 */     if (this.storage[index] != null) {
/* 150 */       this.storage[index] = new ItemStack(this.storage[index].func_77973_b(), (this.storage[index]).field_77994_a + count, this.storage[index].func_77960_j());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 162 */     this.storage[i] = itemstack;
/* 163 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 164 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 170 */     TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 182 */     return "Tool Rack";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 204 */     super.func_145839_a(nbttagcompound);
/* 205 */     this.woodType = nbttagcompound.func_74771_c("woodType");
/* 206 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 207 */     this.storage = new ItemStack[func_70302_i_()];
/* 208 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 210 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 211 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 212 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 213 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 220 */     super.func_145841_b(nbt);
/* 221 */     NBTTagList nbttaglist = new NBTTagList();
/* 222 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 224 */       if (this.storage[i] != null) {
/*     */         
/* 226 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 227 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 228 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 229 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 232 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/* 233 */     nbt.func_74774_a("woodType", this.woodType);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 238 */     func_145839_a(nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 244 */     func_145839_a(nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {
/* 249 */     func_145841_b(nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 255 */     func_145841_b(nbt);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEToolRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */