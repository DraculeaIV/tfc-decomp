/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Items.Tools.ItemCustomBucketMilk;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelAlcoholRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelBriningRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelLiquidToLiquidRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelManager;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelMultiItemRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelPreservativeRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelRecipe;
/*     */ import com.bioxx.tfc.api.Crafting.BarrelVinegarRecipe;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import java.util.Stack;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidContainerItem;
/*     */ 
/*     */ public class TEBarrel
/*     */   extends NetworkTileEntity
/*     */   implements IInventory {
/*     */   public FluidStack fluid;
/*     */   public byte rotation;
/*     */   public int barrelType;
/*     */   public int mode;
/*     */   public ItemStack[] storage;
/*     */   private boolean sealed;
/*     */   public int sealtime;
/*     */   
/*     */   public TEBarrel() {
/*  54 */     this.storage = new ItemStack[12];
/*     */   }
/*     */   public int unsealtime; private int processTimer; public static final int MODE_IN = 0; public static final int MODE_OUT = 1; public static final int INPUT_SLOT = 0; public BarrelRecipe recipe; public boolean shouldDropItem = true;
/*     */   
/*     */   public boolean getSealed() {
/*  59 */     return this.sealed;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTechLevel() {
/*  64 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearInventory() {
/*  69 */     this.storage = new ItemStack[12];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  76 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSealed() {
/*  81 */     this.sealed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnsealed(String reason) {
/*  86 */     if ("killing fuse".equals(reason)) {
/*  87 */       this.sealed = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  98 */     if (this.storage[i] != null) {
/*     */       
/* 100 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 102 */         ItemStack is = this.storage[i];
/* 103 */         this.storage[i] = null;
/* 104 */         return is;
/*     */       } 
/* 106 */       ItemStack isSplit = this.storage[i].func_77979_a(j);
/* 107 */       if ((this.storage[i]).field_77994_a == 0)
/* 108 */         this.storage[i] = null; 
/* 109 */       return isSplit;
/*     */     } 
/*     */ 
/*     */     
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 119 */     float f3 = 0.05F;
/*     */     
/* 121 */     Random rand = new Random();
/* 122 */     float f = rand.nextFloat() * 0.3F + 0.1F;
/* 123 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 124 */     float f2 = rand.nextFloat() * 0.3F + 0.1F;
/*     */     
/* 126 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 128 */       if (this.storage[i] != null) {
/*     */         
/* 130 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 131 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 132 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 133 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 134 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 142 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 148 */     return "Barrel";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 154 */     return 12;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 160 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 166 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInvCount() {
/* 171 */     int count = 0;
/* 172 */     for (ItemStack is : this.storage) {
/*     */       
/* 174 */       if (is != null)
/* 175 */         count++; 
/*     */     } 
/* 177 */     if (this.storage[0] != null && count == 1)
/* 178 */       return 0; 
/* 179 */     return count;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getGunPowderCount() {
/* 184 */     int count = 0;
/* 185 */     for (ItemStack is : this.storage) {
/*     */       
/* 187 */       if (is != null && is.func_77973_b() == Items.field_151016_H)
/* 188 */         count += is.field_77994_a; 
/*     */     } 
/* 190 */     return count;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canAcceptLiquids() {
/* 195 */     return (getInvCount() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 201 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack is) {
/* 212 */     if (!ItemStack.func_77989_b(this.storage[i], is)) {
/*     */       
/* 214 */       this.storage[i] = is;
/* 215 */       if (i == 0) {
/*     */         
/* 217 */         processItems();
/* 218 */         if (!getSealed()) {
/* 219 */           this.unsealtime = (int)TFC_Time.getTotalHours();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getFluidLevel() {
/* 226 */     if (this.fluid != null)
/* 227 */       return this.fluid.amount; 
/* 228 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getInputStack() {
/* 233 */     return this.storage[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public FluidStack getFluidStack() {
/* 238 */     return this.fluid;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxLiquid() {
/* 243 */     return 10000;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addLiquid(FluidStack inFS) {
/* 248 */     if (inFS != null) {
/*     */ 
/*     */       
/* 251 */       if (inFS.getFluid() != null && inFS.getFluid().getTemperature(inFS) > 385) {
/* 252 */         return false;
/*     */       }
/* 254 */       if (this.fluid == null) {
/*     */         
/* 256 */         this.fluid = inFS.copy();
/* 257 */         if (this.fluid.amount > getMaxLiquid())
/*     */         {
/* 259 */           this.fluid.amount = getMaxLiquid();
/* 260 */           inFS.amount -= getMaxLiquid();
/*     */         }
/*     */         else
/*     */         {
/* 264 */           inFS.amount = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 269 */         if (this.fluid.amount == getMaxLiquid() || !this.fluid.isFluidEqual(inFS)) {
/* 270 */           return false;
/*     */         }
/* 272 */         int a = this.fluid.amount + inFS.amount - getMaxLiquid();
/* 273 */         this.fluid.amount = Math.min(this.fluid.amount + inFS.amount, getMaxLiquid());
/* 274 */         if (a > 0) {
/* 275 */           inFS.amount = a;
/*     */         } else {
/* 277 */           inFS.amount = 0;
/*     */         } 
/* 279 */       }  this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 280 */       return true;
/*     */     } 
/*     */     
/* 283 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack addLiquid(ItemStack is) {
/* 288 */     if (is == null || is.field_77994_a > 1)
/* 289 */       return is; 
/* 290 */     if (FluidContainerRegistry.isFilledContainer(is)) {
/*     */       
/* 292 */       FluidStack fs = FluidContainerRegistry.getFluidForFilledItem(is);
/* 293 */       if (addLiquid(fs))
/*     */       {
/* 295 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 296 */         return FluidContainerRegistry.drainFluidContainer(is);
/*     */       }
/*     */     
/* 299 */     } else if (is.func_77973_b() instanceof IFluidContainerItem) {
/*     */       
/* 301 */       FluidStack isfs = ((IFluidContainerItem)is.func_77973_b()).getFluid(is);
/* 302 */       if (isfs != null && addLiquid(isfs)) {
/*     */         
/* 304 */         ((IFluidContainerItem)is.func_77973_b()).drain(is, is.func_77958_k(), true);
/* 305 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/* 308 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack removeLiquid(ItemStack is) {
/* 316 */     if (is == null || is.field_77994_a > 1)
/* 317 */       return is; 
/* 318 */     if (FluidContainerRegistry.isEmptyContainer(is)) {
/*     */       
/* 320 */       ItemStack out = FluidContainerRegistry.fillFluidContainer(this.fluid, is);
/* 321 */       if (out != null)
/*     */       {
/* 323 */         FluidStack fs = FluidContainerRegistry.getFluidForFilledItem(out);
/* 324 */         this.fluid.amount -= fs.amount;
/* 325 */         is = null;
/* 326 */         if (this.fluid.amount == 0)
/*     */         {
/* 328 */           this.fluid = null;
/*     */         }
/* 330 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 331 */         return out;
/*     */       }
/*     */     
/* 334 */     } else if (this.fluid != null && is.func_77973_b() instanceof IFluidContainerItem) {
/*     */       
/* 336 */       FluidStack isfs = ((IFluidContainerItem)is.func_77973_b()).getFluid(is);
/* 337 */       if (isfs == null || this.fluid.isFluidEqual(isfs)) {
/*     */         
/* 339 */         this.fluid.amount -= ((IFluidContainerItem)is.func_77973_b()).fill(is, this.fluid, true);
/* 340 */         if (this.fluid.amount == 0)
/* 341 */           this.fluid = null; 
/* 342 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/* 345 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drainLiquid(int amount) {
/* 353 */     if (!getSealed() && getFluidStack() != null) {
/*     */       
/* 355 */       (getFluidStack()).amount -= amount;
/* 356 */       if ((getFluidStack()).amount <= 0) {
/* 357 */         actionEmpty();
/*     */       } else {
/* 359 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getLiquidScaled(int i) {
/* 365 */     if (this.fluid != null)
/* 366 */       return this.fluid.amount * i / getMaxLiquid(); 
/* 367 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean actionSeal(int tab, EntityPlayer player) {
/* 372 */     NBTTagCompound nbt = new NBTTagCompound();
/* 373 */     nbt.func_74757_a("seal", true);
/* 374 */     nbt.func_74774_a("tab", (byte)tab);
/* 375 */     nbt.func_74778_a("player", player.func_70005_c_());
/* 376 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/* 377 */     this.sealed = true;
/* 378 */     this.field_145850_b.func_147479_m(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 379 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean actionUnSeal(int tab, EntityPlayer player) {
/* 384 */     NBTTagCompound nbt = new NBTTagCompound();
/* 385 */     nbt.func_74757_a("seal", false);
/* 386 */     nbt.func_74774_a("tab", (byte)tab);
/* 387 */     nbt.func_74778_a("player", player.func_70005_c_());
/* 388 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/* 389 */     this.sealed = false;
/* 390 */     this.field_145850_b.func_147479_m(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 391 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionEmpty() {
/* 396 */     this.fluid = null;
/* 397 */     NBTTagCompound nbt = new NBTTagCompound();
/* 398 */     nbt.func_74774_a("fluidID", (byte)-1);
/* 399 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionMode() {
/* 404 */     this.mode = (this.mode == 0) ? 1 : 0;
/* 405 */     NBTTagCompound nbt = new NBTTagCompound();
/* 406 */     nbt.func_74774_a("mode", (byte)this.mode);
/* 407 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionSwitchTab(int tab, EntityPlayer player) {
/* 412 */     NBTTagCompound nbt = new NBTTagCompound();
/* 413 */     nbt.func_74774_a("tab", (byte)tab);
/* 414 */     nbt.func_74778_a("player", player.func_70005_c_());
/* 415 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 421 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 427 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 433 */     super.func_145841_b(nbt);
/* 434 */     nbt.func_74757_a("Sealed", this.sealed);
/* 435 */     nbt.func_74768_a("SealTime", this.sealtime);
/* 436 */     nbt.func_74768_a("barrelType", this.barrelType);
/*     */     
/* 438 */     NBTTagCompound fluidNBT = new NBTTagCompound();
/* 439 */     if (this.fluid != null)
/* 440 */       this.fluid.writeToNBT(fluidNBT); 
/* 441 */     nbt.func_74782_a("fluidNBT", (NBTBase)fluidNBT);
/* 442 */     nbt.func_74774_a("rotation", this.rotation);
/* 443 */     NBTTagList nbttaglist = new NBTTagList();
/* 444 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 446 */       if (this.storage[i] != null) {
/*     */         
/* 448 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 449 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 450 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 451 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 454 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 460 */     super.func_145839_a(nbt);
/* 461 */     this.fluid = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("fluidNBT"));
/* 462 */     this.sealed = nbt.func_74767_n("Sealed");
/* 463 */     this.sealtime = nbt.func_74762_e("SealTime");
/* 464 */     this.barrelType = nbt.func_74762_e("barrelType");
/*     */     
/* 466 */     this.rotation = nbt.func_74771_c("rotation");
/* 467 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 468 */     this.storage = new ItemStack[func_70302_i_()];
/* 469 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 471 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 472 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 473 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 474 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromItemNBT(NBTTagCompound nbt) {
/* 481 */     this.barrelType = nbt.func_74762_e("barrelType");
/* 482 */     this.fluid = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("fluidNBT"));
/* 483 */     this.sealed = nbt.func_74767_n("Sealed");
/* 484 */     this.sealtime = nbt.func_74762_e("SealTime");
/* 485 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 486 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 488 */       NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
/* 489 */       byte byte0 = nbt1.func_74771_c("Slot");
/* 490 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 491 */         func_70299_a(byte0, ItemStack.func_77949_a(nbt1));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateGui() {
/* 497 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 504 */     this.rotation = nbt.func_74771_c("rotation");
/* 505 */     this.sealed = nbt.func_74767_n("sealed");
/* 506 */     this.sealtime = nbt.func_74762_e("SealTime");
/* 507 */     this.barrelType = nbt.func_74762_e("barrelType");
/* 508 */     if (nbt.func_74762_e("fluid") != -1) {
/*     */       
/* 510 */       if (this.fluid != null) {
/* 511 */         this.fluid.amount = nbt.func_74762_e("fluidAmount");
/*     */       } else {
/* 513 */         this.fluid = new FluidStack(nbt.func_74762_e("fluid"), nbt.func_74762_e("fluidAmount"));
/*     */       } 
/*     */     } else {
/*     */       
/* 517 */       this.fluid = null;
/*     */     } 
/* 519 */     this.field_145850_b.func_147479_m(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 525 */     nbt.func_74774_a("rotation", this.rotation);
/* 526 */     nbt.func_74757_a("sealed", this.sealed);
/* 527 */     nbt.func_74768_a("SealTime", this.sealtime);
/* 528 */     nbt.func_74768_a("fluid", (this.fluid != null) ? this.fluid.getFluidID() : -1);
/* 529 */     nbt.func_74768_a("fluidAmount", (this.fluid != null) ? this.fluid.amount : 0);
/* 530 */     nbt.func_74768_a("barrelType", this.barrelType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 536 */     if (nbt.func_74764_b("fluidID")) {
/*     */       
/* 538 */       if (nbt.func_74771_c("fluidID") == -1)
/* 539 */         this.fluid = null; 
/* 540 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     } 
/* 542 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 544 */       if (nbt.func_74764_b("mode")) {
/*     */         
/* 546 */         this.mode = nbt.func_74771_c("mode");
/*     */       }
/* 548 */       else if (nbt.func_74764_b("seal")) {
/*     */         
/* 550 */         this.sealed = nbt.func_74767_n("seal");
/* 551 */         if (!this.sealed) {
/*     */           
/* 553 */           this.unsealtime = (int)TFC_Time.getTotalHours();
/* 554 */           this.sealtime = 0;
/*     */         }
/*     */         else {
/*     */           
/* 558 */           this.sealtime = (int)TFC_Time.getTotalHours();
/* 559 */           this.unsealtime = 0;
/*     */         } 
/*     */ 
/*     */         
/* 563 */         NBTTagCompound timeTag = new NBTTagCompound();
/* 564 */         timeTag.func_74768_a("SealTime", this.sealtime);
/* 565 */         broadcastPacketInRange((AbstractPacket)createDataPacket(timeTag));
/*     */         
/* 567 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */       
/* 570 */       if (nbt.func_74764_b("tab"))
/*     */       {
/* 572 */         int tab = nbt.func_74771_c("tab");
/* 573 */         switchTab(this.field_145850_b.func_72924_a(nbt.func_74779_i("player")), tab);
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 579 */     else if (nbt.func_74764_b("SealTime")) {
/* 580 */       this.sealtime = nbt.func_74762_e("SealTime");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void switchTab(EntityPlayer player, int tab) {
/* 586 */     if (player != null) {
/* 587 */       if (tab == 0) {
/* 588 */         player.openGui(TerraFirmaCraft.instance, 35, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 589 */       } else if (tab == 1) {
/* 590 */         player.openGui(TerraFirmaCraft.instance, 36, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_145845_h() {
/* 596 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 598 */       ItemStack itemstack = this.storage[0];
/* 599 */       BarrelPreservativeRecipe preservative = BarrelManager.getInstance().findMatchingPreservativeRepice(this, itemstack, this.fluid, this.sealed);
/* 600 */       if (itemstack != null && this.fluid != null && this.fluid.getFluid() == TFCFluids.FRESHWATER)
/*     */       {
/* 602 */         if (TFC_ItemHeat.hasTemp(itemstack)) {
/*     */           
/* 604 */           float temp = TFC_ItemHeat.getTemp(itemstack);
/* 605 */           if (this.fluid.amount >= 1 && temp > 1.0F) {
/*     */             
/* 607 */             temp -= 50.0F;
/* 608 */             this.fluid.amount--;
/* 609 */             TFC_ItemHeat.setTemp(itemstack, temp);
/* 610 */             TFC_ItemHeat.handleItemHeat(itemstack);
/*     */           } 
/*     */         } 
/*     */       }
/* 614 */       if (this.fluid != null && itemstack != null && itemstack.func_77973_b() instanceof IFood) {
/*     */         
/* 616 */         float w = Food.getWeight(itemstack);
/* 617 */         if (this.fluid.getFluid() == TFCFluids.VINEGAR)
/*     */         {
/*     */           
/* 620 */           if (Food.isBrined(itemstack) && !Food.isPickled(itemstack) && w / this.fluid.amount <= 160.0F / getMaxLiquid() && getSealed() && this.sealtime != 0 && 
/* 621 */             TFC_Time.getTotalHours() - this.sealtime >= 4L) {
/*     */             
/* 623 */             this.fluid.amount = (int)(this.fluid.amount - 1.0F * w);
/* 624 */             Food.setPickled(itemstack, true);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 629 */       if (preservative == null) {
/*     */ 
/*     */         
/* 632 */         TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/*     */       else {
/*     */         
/* 636 */         float env = preservative.getEnvironmentalDecayFactor();
/* 637 */         float base = preservative.getBaseDecayModifier();
/* 638 */         if (Float.isNaN(env) || env < 0.0D) {
/*     */           
/* 640 */           TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         }
/* 642 */         else if (Float.isNaN(base) || base < 0.0D) {
/*     */           
/* 644 */           TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, env);
/*     */         }
/*     */         else {
/*     */           
/* 648 */           TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, env, base);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 653 */       if (!getSealed() && TFC_Core.isExposedToRain(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/*     */         
/* 655 */         int count = getInvCount();
/* 656 */         if (count == 0 || (count == 1 && getInputStack() != null))
/*     */         {
/* 658 */           if (this.fluid == null) {
/* 659 */             this.fluid = new FluidStack(TFCFluids.FRESHWATER, 1);
/* 660 */           } else if (this.fluid != null && this.fluid.getFluid() == TFCFluids.FRESHWATER) {
/* 661 */             this.fluid.amount = Math.min(this.fluid.amount + 1, getMaxLiquid());
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 667 */       this.processTimer++;
/* 668 */       if (this.processTimer > 100) {
/*     */         
/* 670 */         processItems();
/* 671 */         this.processTimer = 0;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 677 */       if (getFluidLevel() > 0 && getInputStack() != null) {
/*     */         
/* 679 */         int count = 1;
/* 680 */         while ((getInputStack()).field_77994_a > getInputStack().func_77976_d())
/*     */         {
/* 682 */           ItemStack is = getInputStack().func_77979_a(getInputStack().func_77976_d());
/* 683 */           if (count < this.storage.length && func_70301_a(count) == null) {
/*     */             
/* 685 */             func_70299_a(count, is);
/*     */           }
/*     */           else {
/*     */             
/* 689 */             this.field_145850_b.func_72838_d((Entity)new EntityItem(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, is));
/*     */           } 
/* 691 */           count++;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 696 */       else if (getFluidLevel() > 0 && getInputStack() == null && getInvCount() > 0) {
/*     */         
/* 698 */         for (int i = 0; i < this.storage.length; i++) {
/*     */           
/* 700 */           if (this.storage[i] != null) {
/*     */             
/* 702 */             this.storage[0] = this.storage[i].func_77946_l();
/* 703 */             this.storage[i] = null;
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 711 */       if (this.fluid != null && this.fluid.amount == 0) {
/* 712 */         this.fluid = null;
/*     */       }
/*     */       
/* 715 */       if (this.mode == 0) {
/*     */         
/* 717 */         ItemStack container = getInputStack();
/* 718 */         FluidStack inLiquid = FluidContainerRegistry.getFluidForFilledItem(container);
/*     */         
/* 720 */         if (container != null && container.func_77973_b() instanceof IFluidContainerItem && !container.func_77942_o())
/*     */         {
/* 722 */           FluidStack isfs = ((IFluidContainerItem)container.func_77973_b()).getFluid(container);
/* 723 */           if (isfs != null && addLiquid(isfs))
/*     */           {
/* 725 */             ((IFluidContainerItem)container.func_77973_b()).drain(container, ((IFluidContainerItem)container.func_77973_b()).getCapacity(container), true);
/*     */           }
/*     */         }
/* 728 */         else if (inLiquid != null && container != null && container.field_77994_a == 1)
/*     */         {
/* 730 */           if (addLiquid(inLiquid))
/*     */           {
/* 732 */             func_70299_a(0, FluidContainerRegistry.drainFluidContainer(container));
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 737 */       else if (this.mode == 1) {
/*     */         
/* 739 */         ItemStack container = getInputStack();
/*     */         
/* 741 */         if (container != null && this.fluid != null && container.func_77973_b() instanceof IFluidContainerItem) {
/*     */           
/* 743 */           FluidStack isfs = ((IFluidContainerItem)container.func_77973_b()).getFluid(container);
/* 744 */           if (isfs == null || this.fluid.isFluidEqual(isfs)) {
/*     */             
/* 746 */             this.fluid.amount -= ((IFluidContainerItem)container.func_77973_b()).fill(container, this.fluid, true);
/* 747 */             if (this.fluid.amount == 0) {
/* 748 */               this.fluid = null;
/*     */             }
/*     */           } 
/* 751 */         } else if (FluidContainerRegistry.isEmptyContainer(container)) {
/*     */           
/* 753 */           ItemStack fullContainer = removeLiquid(getInputStack());
/* 754 */           if (fullContainer.func_77973_b() == TFCItems.woodenBucketMilk)
/*     */           {
/* 756 */             ItemCustomBucketMilk.createTag(fullContainer, 20.0F);
/*     */           }
/* 758 */           func_70299_a(0, fullContainer);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void processItems() {
/* 766 */     if (getInvCount() == 0) {
/*     */ 
/*     */ 
/*     */       
/* 770 */       boolean isCheese = handleCheese();
/*     */       
/* 772 */       if (getFluidStack() != null && !isCheese)
/*     */       
/* 774 */       { this.recipe = BarrelManager.getInstance().findMatchingRecipe(getInputStack(), getFluidStack(), this.sealed, getTechLevel());
/* 775 */         if (this.recipe != null && !this.field_145850_b.field_72995_K) {
/*     */           
/* 777 */           int time = 0;
/* 778 */           if (this.sealtime > 0) {
/* 779 */             time = (int)TFC_Time.getTotalHours() - this.sealtime;
/* 780 */           } else if (this.unsealtime > 0) {
/* 781 */             time = (int)TFC_Time.getTotalHours() - this.unsealtime;
/*     */           } 
/*     */           
/* 784 */           if (this.recipe.isSealedRecipe() && time < this.recipe.sealTime) {
/*     */             return;
/*     */           }
/* 787 */           ItemStack origIS = (getInputStack() != null) ? getInputStack().func_77946_l() : null;
/* 788 */           FluidStack origFS = (getFluidStack() != null) ? getFluidStack().copy() : null;
/* 789 */           if (this.fluid.isFluidEqual(this.recipe.getResultFluid(origIS, origFS, time)) && this.recipe.removesLiquid) {
/*     */             
/* 791 */             if (this.fluid.getFluid() == TFCFluids.BRINE && origIS != null && origIS.func_77973_b() instanceof IFood) {
/* 792 */               this.fluid.amount = (int)(this.fluid.amount - (this.recipe.getResultFluid(origIS, origFS, time)).amount * Food.getWeight(origIS));
/*     */             } else {
/* 794 */               this.fluid.amount -= (this.recipe.getResultFluid(origIS, origFS, time)).amount;
/*     */             } 
/*     */           } else {
/*     */             
/* 798 */             this.fluid = this.recipe.getResultFluid(origIS, origFS, time).copy();
/* 799 */             if (this.fluid != null && !(this.recipe instanceof BarrelLiquidToLiquidRecipe) && origFS != null) {
/* 800 */               this.fluid.amount = origFS.amount;
/*     */             }
/* 802 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */           } 
/*     */           
/* 805 */           if (origFS != null && origFS.getFluid() != TFCFluids.MILKCURDLED && this.fluid.getFluid() == TFCFluids.MILKCURDLED) {
/* 806 */             this.sealtime = (int)TFC_Time.getTotalHours();
/*     */           }
/* 808 */           Stack<ItemStack> resultStacks = this.recipe.getResult(origIS, origFS, time);
/* 809 */           if (!resultStacks.isEmpty())
/*     */           {
/* 811 */             ItemStack result = resultStacks.pop();
/* 812 */             if (this.fluid != null && this.fluid.getFluid() == TFCFluids.BRINE) {
/*     */               
/* 814 */               if (result == null && origIS != null)
/* 815 */                 result = origIS.func_77946_l(); 
/* 816 */               if (result != null && result.func_77973_b() instanceof IFood && (result.func_77973_b() == TFCItems.cheese || ((IFood)result.func_77973_b()).getFoodGroup() != EnumFoodGroup.Grain))
/*     */               {
/* 818 */                 if (!Food.isBrined(result)) {
/* 819 */                   Food.setBrined(result, true);
/*     */                 }
/*     */               }
/*     */             } 
/* 823 */             this.storage[0] = result;
/*     */             
/* 825 */             for (int i = 1; i < this.storage.length; i++) {
/*     */               
/* 827 */               if (this.storage[i] == null && !resultStacks.isEmpty()) {
/* 828 */                 func_70299_a(i, resultStacks.pop());
/*     */               }
/*     */             } 
/* 831 */             while (!resultStacks.isEmpty()) {
/* 832 */               this.field_145850_b.func_72838_d((Entity)new EntityItem(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, resultStacks.pop()));
/*     */             }
/* 834 */             func_70299_a(0, result);
/*     */           }
/*     */         
/*     */         }  }
/* 838 */       else if (getFluidStack() == null && !isCheese) { this.recipe = null; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean handleCheese() {
/* 847 */     ItemStack inIS = getInputStack();
/* 848 */     if (getSealed() && this.fluid != null && this.fluid.getFluid() == TFCFluids.MILKCURDLED && (inIS == null || (inIS
/* 849 */       .func_77973_b() instanceof IFood && ((IFood)inIS.func_77973_b()).getFoodGroup() != EnumFoodGroup.Dairy && ((IFood)inIS
/* 850 */       .func_77973_b()).isEdible(inIS) && Food.getWeight(inIS) <= 20.0F))) {
/*     */       
/* 852 */       this.recipe = (new BarrelRecipe(null, new FluidStack(TFCFluids.MILKCURDLED, 10000), ItemFoodTFC.createTag(new ItemStack(TFCItems.cheese, 1), 160.0F), null)).setMinTechLevel(0);
/* 853 */       if (!this.field_145850_b.field_72995_K) {
/*     */         
/* 855 */         int time = 0;
/* 856 */         if (this.sealtime > 0) {
/* 857 */           time = (int)TFC_Time.getTotalHours() - this.sealtime;
/* 858 */         } else if (this.unsealtime > 0) {
/* 859 */           time = (int)TFC_Time.getTotalHours() - this.unsealtime;
/*     */         } 
/*     */         
/* 862 */         if (time < this.recipe.sealTime)
/* 863 */           return true; 
/* 864 */         float w = this.fluid.amount / 62.5F;
/*     */         
/* 866 */         ItemStack is = ItemFoodTFC.createTag(new ItemStack(TFCItems.cheese), w);
/*     */         
/* 868 */         if (inIS != null && inIS.func_77973_b() instanceof IFood) {
/*     */           
/* 870 */           int[] profile = Food.getFoodTasteProfile(inIS);
/* 871 */           float ratio = Math.min((Food.getWeight(getInputStack()) - Food.getDecay(inIS)) / 20.0F, 1.0F);
/* 872 */           Food.setSweetMod(is, (int)Math.floor((profile[0] * ratio)));
/* 873 */           Food.setSourMod(is, (int)Math.floor((profile[1] * ratio)));
/* 874 */           Food.setSaltyMod(is, (int)Math.floor((profile[2] * ratio)));
/* 875 */           Food.setBitterMod(is, (int)Math.floor((profile[3] * ratio)));
/* 876 */           Food.setSavoryMod(is, (int)Math.floor((profile[4] * ratio)));
/* 877 */           Food.setInfusion(is, inIS.func_77973_b().func_77658_a());
/* 878 */           this.storage[0] = null;
/*     */         } 
/*     */         
/* 881 */         actionEmpty();
/* 882 */         func_70299_a(0, is);
/*     */       } 
/* 884 */       return true;
/*     */     } 
/* 886 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack createFullBarrel(FluidStack f, ItemStack is) {
/* 891 */     if (!is.func_77942_o()) {
/* 892 */       is.func_77982_d(new NBTTagCompound());
/*     */     }
/* 894 */     is.func_77978_p().func_74757_a("Sealed", true);
/*     */     
/* 896 */     NBTTagCompound fluidNBT = new NBTTagCompound();
/* 897 */     if (f != null)
/* 898 */       f.writeToNBT(fluidNBT); 
/* 899 */     is.func_77978_p().func_74782_a("fluidNBT", (NBTBase)fluidNBT);
/*     */     
/* 901 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerRecipes() {
/* 906 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.potato), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.VODKA, 10000)));
/* 907 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.redApple), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.CIDER, 10000)));
/* 908 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.greenApple), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.CIDER, 10000)));
/* 909 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.wheatGround), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.WHISKEY, 10000)));
/* 910 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.ryeGround), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.RYEWHISKEY, 10000)));
/* 911 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.barleyGround), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.BEER, 10000)));
/* 912 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.riceGround), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.SAKE, 10000)));
/* 913 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.sugar), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.RUM, 10000)));
/* 914 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelAlcoholRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.cornmealGround), 160.0F), new FluidStack(TFCFluids.FRESHWATER, 10000), null, new FluidStack(TFCFluids.CORNWHISKEY, 10000)));
/* 915 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(null, new FluidStack(TFCFluids.MILKVINEGAR, 10000), null, new FluidStack(TFCFluids.MILKCURDLED, 10000))).setMinTechLevel(0).setRemovesLiquid(false));
/*     */     
/* 917 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 918 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 2), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 919 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 3), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 920 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 4), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 921 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 5), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 922 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 6), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 923 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.logs, 1, 9), new FluidStack(TFCFluids.FRESHWATER, 1000), null, new FluidStack(TFCFluids.TANNIN, 1000))).setMinTechLevel(0));
/* 924 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCItems.powder, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 500), null, new FluidStack(TFCFluids.LIMEWATER, 500), 0)).setMinTechLevel(0).setSealedRecipe(false).setRemovesLiquid(false).setAllowAnyStack(false));
/* 925 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.scrapedHide, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 300), new ItemStack(TFCItems.prepHide, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 300))).setMinTechLevel(0));
/* 926 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.scrapedHide, 1, 1), new FluidStack(TFCFluids.FRESHWATER, 400), new ItemStack(TFCItems.prepHide, 1, 1), new FluidStack(TFCFluids.FRESHWATER, 400))).setMinTechLevel(0));
/* 927 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.scrapedHide, 1, 2), new FluidStack(TFCFluids.FRESHWATER, 500), new ItemStack(TFCItems.prepHide, 1, 2), new FluidStack(TFCFluids.FRESHWATER, 500))).setMinTechLevel(0));
/* 928 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 0), new FluidStack(TFCFluids.LIMEWATER, 300), new ItemStack(TFCItems.soakedHide, 1, 0), new FluidStack(TFCFluids.LIMEWATER, 300))).setMinTechLevel(0));
/* 929 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 1), new FluidStack(TFCFluids.LIMEWATER, 400), new ItemStack(TFCItems.soakedHide, 1, 1), new FluidStack(TFCFluids.LIMEWATER, 400))).setMinTechLevel(0));
/* 930 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.hide, 1, 2), new FluidStack(TFCFluids.LIMEWATER, 500), new ItemStack(TFCItems.soakedHide, 1, 2), new FluidStack(TFCFluids.LIMEWATER, 500))).setMinTechLevel(0));
/* 931 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.prepHide, 1, 0), new FluidStack(TFCFluids.TANNIN, 300), new ItemStack(TFCItems.leather, 1), new FluidStack(TFCFluids.TANNIN, 300))).setKeepStackSize(false).setMinTechLevel(0));
/* 932 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.prepHide, 1, 1), new FluidStack(TFCFluids.TANNIN, 400), new ItemStack(TFCItems.leather, 2), new FluidStack(TFCFluids.TANNIN, 400))).setKeepStackSize(false).setMinTechLevel(0));
/* 933 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.prepHide, 1, 2), new FluidStack(TFCFluids.TANNIN, 500), new ItemStack(TFCItems.leather, 3), new FluidStack(TFCFluids.TANNIN, 500))).setKeepStackSize(false).setMinTechLevel(0));
/* 934 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCBlocks.sand, 1, 32767), new FluidStack(TFCFluids.LIMEWATER, 100), new ItemStack(TFCItems.mortar, 16), new FluidStack(TFCFluids.LIMEWATER, 100))).setMinTechLevel(0));
/* 935 */     BarrelManager.getInstance().addRecipe((new BarrelRecipe(new ItemStack(TFCBlocks.sand2, 1, 32767), new FluidStack(TFCFluids.LIMEWATER, 100), new ItemStack(TFCItems.mortar, 16), new FluidStack(TFCFluids.LIMEWATER, 100))).setMinTechLevel(0));
/* 936 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.VODKA, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 937 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.CIDER, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 938 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.WHISKEY, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 939 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.RYEWHISKEY, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 940 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.BEER, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 941 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.SAKE, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 942 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.RUM, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 943 */     BarrelManager.getInstance().addRecipe((BarrelRecipe)new BarrelVinegarRecipe(new FluidStack(TFCFluids.CORNWHISKEY, 100), new FluidStack(TFCFluids.VINEGAR, 100)));
/* 944 */     BarrelManager.getInstance().addRecipe((new BarrelLiquidToLiquidRecipe(new FluidStack(TFCFluids.SALTWATER, 9000), new FluidStack(TFCFluids.VINEGAR, 1000), new FluidStack(TFCFluids.BRINE, 10000))).setSealedRecipe(false).setMinTechLevel(0).setRemovesLiquid(false));
/* 945 */     BarrelManager.getInstance().addRecipe((new BarrelBriningRecipe(new FluidStack(TFCFluids.BRINE, 60), new FluidStack(TFCFluids.BRINE, 60))).setMinTechLevel(0));
/* 946 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(ItemFoodTFC.createTag(new ItemStack(TFCItems.sugarcane), 1.0F), new FluidStack(TFCFluids.FRESHWATER, 60), ItemFoodTFC.createTag(new ItemStack(TFCItems.sugar), 0.1F), new FluidStack(TFCFluids.FRESHWATER, 60))).setMinTechLevel(0));
/* 947 */     BarrelManager.getInstance().addRecipe((new BarrelMultiItemRecipe(new ItemStack(TFCItems.jute, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 200), new ItemStack(TFCItems.juteFiber, 1, 0), new FluidStack(TFCFluids.FRESHWATER, 200))).setMinTechLevel(0));
/* 948 */     BarrelManager.getInstance().addRecipe((new BarrelLiquidToLiquidRecipe(new FluidStack(TFCFluids.MILK, 9000), new FluidStack(TFCFluids.VINEGAR, 1000), new FluidStack(TFCFluids.MILKVINEGAR, 10000))).setSealedRecipe(false).setMinTechLevel(0).setRemovesLiquid(false));
/* 949 */     BarrelManager.getInstance().addRecipe((new BarrelLiquidToLiquidRecipe(new FluidStack(TFCFluids.MILKVINEGAR, 9000), new FluidStack(TFCFluids.MILK, 1000), new FluidStack(TFCFluids.MILKVINEGAR, 10000))).setSealedRecipe(false).setMinTechLevel(0).setRemovesLiquid(false));
/*     */ 
/*     */ 
/*     */     
/* 953 */     BarrelPreservativeRecipe picklePreservative = (new BarrelPreservativeRecipe(new FluidStack(TFCFluids.VINEGAR, 31), "gui.barrel.preserving")).setAllowGrains(false).setRequiresPickled(true).setEnvironmentalDecayFactor(0.25F).setBaseDecayModifier(0.1F).setRequiresSealed(true);
/* 954 */     BarrelPreservativeRecipe brineInBrinePreservative = (new BarrelPreservativeRecipe(new FluidStack(TFCFluids.BRINE, 62), "gui.barrel.preserving")).setAllowGrains(false).setRequiresBrined(true).setEnvironmentalDecayFactor(0.75F).setRequiresSealed(true);
/* 955 */     BarrelPreservativeRecipe brineInVinegarPreservative = (new BarrelPreservativeRecipe(new FluidStack(TFCFluids.VINEGAR, 62), "gui.barrel.preserving")).setAllowGrains(false).setRequiresBrined(true).setEnvironmentalDecayFactor(0.75F).setRequiresSealed(true);
/* 956 */     BarrelManager.getInstance().addPreservative(picklePreservative);
/* 957 */     BarrelManager.getInstance().addPreservative(brineInBrinePreservative);
/* 958 */     BarrelManager.getInstance().addPreservative(brineInVinegarPreservative);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */