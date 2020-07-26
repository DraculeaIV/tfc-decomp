/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TEIngotPile
/*     */   extends NetworkTileEntity
/*     */   implements IInventory {
/*     */   public ItemStack[] storage;
/*     */   public String type;
/*  24 */   public static final Item[] INGOTS = new Item[] { TFCItems.bismuthIngot, TFCItems.bismuthBronzeIngot, TFCItems.blackBronzeIngot, TFCItems.blackSteelIngot, TFCItems.blueSteelIngot, TFCItems.brassIngot, TFCItems.bronzeIngot, TFCItems.copperIngot, TFCItems.goldIngot, TFCItems.wroughtIronIngot, TFCItems.leadIngot, TFCItems.nickelIngot, TFCItems.pigIronIngot, TFCItems.platinumIngot, TFCItems.redSteelIngot, TFCItems.roseGoldIngot, TFCItems.silverIngot, TFCItems.steelIngot, TFCItems.sterlingSilverIngot, TFCItems.tinIngot, TFCItems.zincIngot, TFCItems.unknownIngot };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  34 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public TEIngotPile() {
/*  39 */     this.storage = new ItemStack[1];
/*  40 */     this.type = "Copper";
/*     */   }
/*     */   
/*     */   public static Item[] getIngots() {
/*  44 */     return (Item[])INGOTS.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setType(String i) {
/*  49 */     this.type = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  56 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStack() {
/*  61 */     return (this.storage[0]).field_77994_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType() {
/*  66 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addContents(int index, ItemStack is) {
/*  71 */     if (this.storage[index] == null)
/*  72 */       this.storage[index] = is; 
/*  73 */     updateNeighbours();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearContents() {
/*  78 */     this.storage[0] = null;
/*  79 */     updateNeighbours();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contentsMatch(int index, ItemStack is) {
/*  89 */     if (this.storage[index] != null)
/*     */     {
/*  91 */       if ((this.storage[index]).field_77994_a == 0) {
/*  92 */         return true;
/*     */       }
/*     */     }
/*  95 */     return (this.storage[index].func_77973_b() == is.func_77973_b() && this.storage[index].func_77973_b() == is.func_77973_b() && (this.storage[index]).field_77994_a + 1 <= 
/*  96 */       func_70297_j_());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 102 */     if (this.storage[i] != null) {
/*     */       
/* 104 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 106 */         ItemStack itemstack = this.storage[i];
/* 107 */         this.storage[i] = null;
/* 108 */         updateNeighbours();
/* 109 */         return itemstack;
/*     */       } 
/* 111 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/* 112 */       if ((this.storage[i]).field_77994_a == 0)
/* 113 */         this.storage[i] = null; 
/* 114 */       updateNeighbours();
/* 115 */       return itemstack1;
/*     */     } 
/*     */     
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 123 */     float f3 = 0.05F;
/*     */     
/* 125 */     Random rand = new Random();
/* 126 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 127 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 128 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 130 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 132 */       if (this.storage[i] != null) {
/*     */         
/* 134 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 135 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 136 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 137 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 138 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 139 */         this.storage[i] = null;
/*     */       } 
/*     */     } 
/* 142 */     updateNeighbours();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 148 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 154 */     return "Ingot Pile";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 160 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 166 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void injectContents(int index, int count) {
/* 177 */     if (this.storage[index] != null)
/*     */     {
/* 179 */       if ((this.storage[index]).field_77994_a > 0) {
/*     */         
/* 181 */         this.storage[index] = new ItemStack(this.storage[index].func_77973_b(), (this.storage[index]).field_77994_a + count, this.storage[index].func_77960_j());
/* 182 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     }
/* 185 */     updateNeighbours();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 191 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 202 */     this.storage[i] = itemstack;
/* 203 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 204 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateNeighbours() {
/* 209 */     if (this.field_145850_b.func_72899_e(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) && !this.field_145850_b.func_147437_c(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/* 210 */       this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e).func_149695_a(this.field_145850_b, this.field_145851_c, this.field_145848_d + 1, this.field_145849_e, TFCBlocks.ingotPile);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 228 */     super.func_145839_a(nbttagcompound);
/*     */     
/* 230 */     this.type = nbttagcompound.func_74779_i("type");
/* 231 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 232 */     this.storage = new ItemStack[func_70302_i_()];
/* 233 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 235 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 236 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 237 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 238 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 245 */     super.func_145841_b(nbttagcompound);
/* 246 */     nbttagcompound.func_74778_a("type", this.type);
/* 247 */     NBTTagList nbttaglist = new NBTTagList();
/* 248 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 250 */       if (this.storage[i] != null) {
/*     */         
/* 252 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 253 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 254 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 255 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 258 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 264 */     this.type = nbt.func_74779_i("type");
/* 265 */     this.storage[0] = ItemStack.func_77949_a(nbt);
/* 266 */     updateNeighbours();
/* 267 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
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
/* 280 */     if (this.type != null)
/* 281 */       nbt.func_74778_a("type", this.type); 
/* 282 */     if (this.storage[0] != null) {
/*     */       
/* 284 */       ItemStack is = this.storage[0].func_77946_l();
/* 285 */       is.field_77990_d = null;
/* 286 */       is.func_77955_b(nbt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEIngotPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */