/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TEWorldItem
/*     */   extends NetworkTileEntity implements IInventory {
/*  16 */   public ItemStack[] storage = new ItemStack[1];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityItem renderItem;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  27 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/*  33 */     super.func_145839_a(nbt);
/*  34 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/*  35 */     this.storage = new ItemStack[1];
/*  36 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/*  38 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  39 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/*  40 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/*  41 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_145833_n() {
/*  49 */     return 1024.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  56 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), this.field_145848_d + 0.1D, (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/*  62 */     super.func_145841_b(nbt);
/*  63 */     NBTTagList nbttaglist = new NBTTagList();
/*  64 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/*  66 */       if (this.storage[i] != null) {
/*     */         
/*  68 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  69 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  70 */         this.storage[i].func_77955_b(nbttagcompound1);
/*  71 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*  74 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  80 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/*  86 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  92 */     (this.storage[i]).field_77994_a -= j;
/*  93 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 105 */     this.storage[i] = itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 111 */     return "worldItem";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 123 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 129 */     return false;
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
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 150 */     if (nbt.func_74764_b("id")) {
/* 151 */       this.storage[0] = ItemStack.func_77949_a(nbt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 168 */     if (this.storage[0] != null)
/* 169 */       this.storage[0].func_77955_b(nbt); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEWorldItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */