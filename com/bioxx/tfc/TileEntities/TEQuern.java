/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Crafting.QuernManager;
/*     */ import com.bioxx.tfc.api.Crafting.QuernRecipe;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TEQuern
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*  31 */   public ItemStack[] storage = new ItemStack[3];
/*     */   
/*     */   public int rotation;
/*     */   
/*     */   public boolean shouldRotate;
/*     */   public int rotatetimer;
/*     */   public boolean hasQuern;
/*     */   
/*     */   public void func_145845_h() {
/*  40 */     if (!this.field_145850_b.field_72995_K) {
/*  41 */       TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     }
/*  43 */     this.hasQuern = (this.storage[2] != null);
/*     */     
/*  45 */     if (this.shouldRotate) {
/*     */       
/*  47 */       this.rotatetimer++;
/*  48 */       if (this.rotatetimer == 90) {
/*     */         
/*  50 */         this.rotatetimer = 0;
/*  51 */         this.shouldRotate = false;
/*  52 */         if (!this.field_145850_b.field_72995_K)
/*     */         {
/*  54 */           if (processItem() && this.storage[2] != null) {
/*  55 */             damageStackInSlot(2);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  65 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean processItem() {
/*  70 */     if (this.storage[0] != null) {
/*     */       
/*  72 */       QuernRecipe qr = QuernManager.getInstance().findMatchingRecipe(this.storage[0]);
/*  73 */       if (qr == null) {
/*     */         
/*  75 */         TerraFirmaCraft.LOG.warn("QUERN RECIPE NOT FOUND! This is a BUG! -- " + this.storage[0].func_77973_b().func_77658_a());
/*  76 */         return false;
/*     */       } 
/*     */ 
/*     */       
/*  80 */       if (this.storage[1] != null && (this.storage[1].func_77973_b() != qr.getResult().func_77973_b() || this.storage[1].func_77960_j() != qr.getResult().func_77960_j())) {
/*     */         
/*  82 */         ejectItem(this.storage[1]);
/*  83 */         this.storage[1] = null;
/*     */       } 
/*     */       
/*  86 */       if (qr.getInItem().func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */         
/*  88 */         if (this.storage[1] != null) {
/*     */           
/*  90 */           float slot0Weight = Food.getWeight(this.storage[0]);
/*  91 */           float slot1Weight = Food.getWeight(this.storage[1]);
/*  92 */           float newWeight = slot0Weight + slot1Weight;
/*     */           
/*  94 */           if (newWeight > 160.0F) {
/*     */             
/*  96 */             Food.setWeight(this.storage[1], newWeight - 160.0F);
/*     */             
/*  98 */             ItemStack tossStack = this.storage[1].func_77946_l();
/*  99 */             Food.setWeight(tossStack, 160.0F);
/* 100 */             ejectItem(tossStack);
/*     */           }
/*     */           else {
/*     */             
/* 104 */             Food.setWeight(this.storage[1], newWeight);
/*     */           } 
/* 106 */           this.storage[0] = null;
/* 107 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 108 */           return true;
/*     */         } 
/*     */         
/* 111 */         if (this.storage[1] == null)
/*     */         {
/* 113 */           this.storage[1] = qr.getResult().func_77946_l();
/* 114 */           float flourWeight = Food.getWeight(this.storage[0]);
/* 115 */           float flourDecay = Food.getDecay(this.storage[0]);
/* 116 */           ItemFoodTFC.createTag(this.storage[1], flourWeight, flourDecay);
/* 117 */           this.storage[0] = null;
/* 118 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 119 */           return true;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 124 */         if ((this.storage[0]).field_77994_a == (qr.getInItem()).field_77994_a) {
/*     */           
/* 126 */           this.storage[0] = null;
/* 127 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         } else {
/*     */           
/* 130 */           (this.storage[0]).field_77994_a -= (qr.getInItem()).field_77994_a;
/*     */         } 
/* 132 */         if (this.storage[1] == null) {
/* 133 */           this.storage[1] = qr.getResult().func_77946_l();
/* 134 */         } else if ((this.storage[1]).field_77994_a < this.storage[1].func_77976_d()) {
/*     */           
/* 136 */           if ((qr.getResult()).field_77994_a + (this.storage[1]).field_77994_a > this.storage[1].func_77976_d()) {
/*     */             
/* 138 */             int amountleft = (qr.getResult()).field_77994_a - this.storage[1].func_77976_d() - (this.storage[1]).field_77994_a;
/* 139 */             ItemStack tossStack = qr.getResult().func_77946_l();
/* 140 */             tossStack.field_77994_a = tossStack.func_77976_d();
/* 141 */             ejectItem(tossStack);
/* 142 */             ItemStack remainStack = qr.getResult().func_77946_l();
/* 143 */             remainStack.field_77994_a = amountleft;
/* 144 */             this.storage[1] = remainStack;
/*     */           } else {
/*     */             
/* 147 */             (this.storage[1]).field_77994_a += (qr.getResult()).field_77994_a;
/*     */           } 
/*     */         } else {
/*     */           
/* 151 */           ejectItem(this.storage[1]);
/* 152 */           this.storage[1] = qr.getResult().func_77946_l();
/*     */         } 
/* 154 */         return true;
/*     */       } 
/*     */     } 
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void damageStackInSlot(int slot) {
/* 162 */     if (this.storage[slot] != null) {
/*     */ 
/*     */       
/* 165 */       this.storage[slot].func_77972_a(slot, (EntityLivingBase)new EntityCowTFC(this.field_145850_b));
/* 166 */       if ((this.storage[slot]).field_77994_a == 0 || this.storage[slot].func_77960_j() == this.storage[slot].func_77958_k()) {
/*     */         
/* 168 */         func_70299_a(slot, (ItemStack)null);
/* 169 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount) {
/* 177 */     if (this.storage[slot] != null) {
/*     */       
/* 179 */       if ((this.storage[slot]).field_77994_a <= amount) {
/*     */         
/* 181 */         ItemStack itemstack = this.storage[slot];
/* 182 */         func_70299_a(slot, (ItemStack)null);
/* 183 */         return itemstack;
/*     */       } 
/* 185 */       ItemStack itemstack1 = this.storage[slot].func_77979_a(amount);
/* 186 */       if ((this.storage[slot]).field_77994_a == 0)
/* 187 */         func_70299_a(slot, (ItemStack)null); 
/* 188 */       return itemstack1;
/*     */     } 
/*     */     
/* 191 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 196 */     float f3 = 0.05F;
/*     */     
/* 198 */     Random rand = new Random();
/* 199 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 200 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 201 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 203 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 205 */       if (this.storage[i] != null) {
/*     */         
/* 207 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 208 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 209 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 210 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 211 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectItem(ItemStack is) {
/* 218 */     float f3 = 0.05F;
/*     */     
/* 220 */     Random rand = new Random();
/* 221 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 222 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 223 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 225 */     if (this.storage[1] != null) {
/*     */       
/* 227 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), is);
/* 228 */       entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 229 */       entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.05F);
/* 230 */       entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 231 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 238 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slot) {
/* 244 */     return this.storage[slot];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack is) {
/* 250 */     this.storage[slot] = is;
/* 251 */     if (is != null && is.field_77994_a > func_70297_j_()) {
/* 252 */       is.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 258 */     return "Quern";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 264 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer player) {
/* 270 */     return false;
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
/*     */   public ItemStack func_70304_b(int slot) {
/* 286 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 292 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack is) {
/* 298 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 304 */     super.func_145839_a(nbttagcompound);
/* 305 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 306 */     this.storage = new ItemStack[func_70302_i_()];
/* 307 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 309 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 310 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 311 */       if (byte0 >= 0 && byte0 < this.storage.length)
/* 312 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/* 314 */     this.hasQuern = nbttagcompound.func_74767_n("hasQuern");
/* 315 */     this.shouldRotate = nbttagcompound.func_74767_n("shouldRotate");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 321 */     super.func_145841_b(nbttagcompound);
/* 322 */     NBTTagList nbttaglist = new NBTTagList();
/* 323 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 325 */       if (this.storage[i] != null) {
/*     */         
/* 327 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 328 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 329 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 330 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 333 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/* 334 */     nbttagcompound.func_74757_a("hasQuern", this.hasQuern);
/* 335 */     nbttagcompound.func_74757_a("shouldRotate", this.shouldRotate);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 341 */     NBTTagCompound nbt = new NBTTagCompound();
/* 342 */     func_145841_b(nbt);
/* 343 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 349 */     func_145839_a(pkt.func_148857_g());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 355 */     this.hasQuern = nbt.func_74767_n("hasQuern");
/* 356 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
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
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 374 */     nbt.func_74757_a("hasQuern", this.hasQuern);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */