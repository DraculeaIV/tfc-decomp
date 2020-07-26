/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerChestTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ public class TEChest
/*     */   extends TileEntityChest
/*     */   implements IInventory
/*     */ {
/*  29 */   private ItemStack[] chestContents = new ItemStack[18];
/*     */   
/*     */   public int type;
/*     */   private int ticksSinceSync;
/*  33 */   public int cooldown = 5;
/*     */   
/*     */   private boolean typeSynced;
/*     */   
/*     */   public boolean isDoubleChest;
/*     */ 
/*     */   
/*     */   public TEChest() {}
/*     */ 
/*     */   
/*     */   public TEChest(int i, boolean isDouble) {
/*  44 */     this.type = i;
/*  45 */     this.isDoubleChest = isDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  51 */     return 18;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int par1) {
/*  57 */     return this.chestContents[par1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int par1, int par2) {
/*  63 */     if (this.chestContents[par1] != null) {
/*     */ 
/*     */       
/*  66 */       if ((this.chestContents[par1]).field_77994_a <= par2) {
/*     */         
/*  68 */         ItemStack itemStack = this.chestContents[par1];
/*  69 */         this.chestContents[par1] = null;
/*  70 */         func_70296_d();
/*  71 */         return itemStack;
/*     */       } 
/*     */ 
/*     */       
/*  75 */       ItemStack var3 = this.chestContents[par1].func_77979_a(par2);
/*  76 */       if ((this.chestContents[par1]).field_77994_a == 0)
/*  77 */         this.chestContents[par1] = null; 
/*  78 */       func_70296_d();
/*  79 */       return var3;
/*     */     } 
/*     */ 
/*     */     
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int par1) {
/*  89 */     if (this.chestContents[par1] != null) {
/*     */       
/*  91 */       ItemStack var2 = this.chestContents[par1];
/*  92 */       this.chestContents[par1] = null;
/*  93 */       return var2;
/*     */     } 
/*     */     
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int par1, ItemStack par2ItemStack) {
/* 102 */     this.chestContents[par1] = par2ItemStack;
/* 103 */     if (par2ItemStack != null && par2ItemStack.field_77994_a > func_70297_j_())
/* 104 */       par2ItemStack.field_77994_a = func_70297_j_(); 
/* 105 */     func_70296_d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 111 */     return "container.chest";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 117 */     super.func_145839_a(nbt);
/* 118 */     NBTTagList var2 = nbt.func_150295_c("Items", 10);
/* 119 */     this.chestContents = new ItemStack[func_70302_i_()];
/* 120 */     this.type = nbt.func_74762_e("woodtype");
/* 121 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/*     */       
/* 123 */       NBTTagCompound var4 = var2.func_150305_b(var3);
/* 124 */       int var5 = var4.func_74771_c("Slot") & 0xFF;
/* 125 */       if (var5 >= 0 && var5 < this.chestContents.length) {
/* 126 */         this.chestContents[var5] = ItemStack.func_77949_a(var4);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 133 */     super.func_145841_b(nbt);
/* 134 */     NBTTagList var2 = new NBTTagList();
/*     */     
/* 136 */     for (int var3 = 0; var3 < this.chestContents.length; var3++) {
/*     */       
/* 138 */       if (this.chestContents[var3] != null) {
/*     */         
/* 140 */         NBTTagCompound var4 = new NBTTagCompound();
/* 141 */         var4.func_74774_a("Slot", (byte)var3);
/* 142 */         this.chestContents[var3].func_77955_b(var4);
/* 143 */         var2.func_74742_a((NBTBase)var4);
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     nbt.func_74782_a("Items", (NBTBase)var2);
/* 148 */     nbt.func_74768_a("woodtype", this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 154 */     NBTTagCompound nbt = new NBTTagCompound();
/* 155 */     nbt.func_74768_a("woodtype", this.type);
/* 156 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 162 */     this.type = pkt.func_148857_g().func_74762_e("woodtype");
/*     */     
/* 164 */     this.field_145984_a = false;
/* 165 */     this.typeSynced = true;
/* 166 */     this.cooldown = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 172 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
/* 178 */     return (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) ? false : ((par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkType(IBlockAccess access, int x, int y, int z) {
/* 183 */     TileEntity te = access.func_147438_o(x, y, z);
/* 184 */     if (te instanceof TEChest) {
/*     */       
/* 186 */       TEChest chest = (TEChest)access.func_147438_o(x, y, z);
/* 187 */       if (chest.type == this.type && this.cooldown == 0 && chest.cooldown == 0)
/* 188 */         return true; 
/*     */     } 
/* 190 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145979_i() {
/* 196 */     if (!this.field_145984_a) {
/*     */       
/* 198 */       this.field_145984_a = true;
/* 199 */       this.field_145992_i = null;
/* 200 */       this.field_145990_j = null;
/* 201 */       this.field_145991_k = null;
/* 202 */       this.field_145988_l = null;
/*     */       
/* 204 */       if (isChest(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e)) {
/* 205 */         this.field_145991_k = (TEChest)this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 207 */       if (isChest(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e)) {
/* 208 */         this.field_145990_j = (TEChest)this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 210 */       if (isChest(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1)) {
/* 211 */         this.field_145992_i = (TEChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*     */       }
/* 213 */       if (isChest(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1)) {
/* 214 */         this.field_145988_l = (TEChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       if (this.field_145992_i != null)
/*     */       {
/* 222 */         ((TEChest)this.field_145992_i).updateSide(this, 0);
/*     */       }
/*     */       
/* 225 */       if (this.field_145988_l != null)
/*     */       {
/* 227 */         ((TEChest)this.field_145988_l).updateSide(this, 2);
/*     */       }
/*     */       
/* 230 */       if (this.field_145990_j != null)
/*     */       {
/* 232 */         ((TEChest)this.field_145990_j).updateSide(this, 1);
/*     */       }
/*     */       
/* 235 */       if (this.field_145991_k != null)
/*     */       {
/* 237 */         ((TEChest)this.field_145991_k).updateSide(this, 3);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isChest(int x, int y, int z) {
/* 244 */     return (this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.chest && checkType((IBlockAccess)this.field_145850_b, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateSide(TileEntityChest teChest, int side) {
/* 249 */     if (teChest.func_145837_r()) {
/*     */       
/* 251 */       this.field_145984_a = false;
/*     */     }
/* 253 */     else if (this.field_145984_a) {
/*     */       
/* 255 */       switch (side) {
/*     */         
/*     */         case 0:
/* 258 */           if (this.field_145988_l != teChest)
/*     */           {
/* 260 */             this.field_145984_a = false;
/*     */           }
/*     */           break;
/*     */         
/*     */         case 1:
/* 265 */           if (this.field_145991_k != teChest)
/*     */           {
/* 267 */             this.field_145984_a = false;
/*     */           }
/*     */           break;
/*     */         
/*     */         case 2:
/* 272 */           if (this.field_145992_i != teChest)
/*     */           {
/* 274 */             this.field_145984_a = false;
/*     */           }
/*     */           break;
/*     */         
/*     */         case 3:
/* 279 */           if (this.field_145990_j != teChest)
/*     */           {
/* 281 */             this.field_145984_a = false;
/*     */           }
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 293 */     TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     
/* 295 */     if (this.type == 0 && !this.typeSynced) {
/*     */       
/* 297 */       if (this.cooldown == 0)
/*     */       {
/* 299 */         this.field_145984_a = false;
/* 300 */         this.isDoubleChest = false;
/* 301 */         this.typeSynced = true;
/*     */       }
/* 303 */       else if (this.cooldown > 0)
/*     */       {
/* 305 */         this.cooldown--;
/*     */       }
/*     */     
/* 308 */     } else if (this.cooldown != 0) {
/*     */       
/* 310 */       this.cooldown = 0;
/*     */     } 
/*     */     
/* 313 */     func_145979_i();
/* 314 */     this.ticksSinceSync++;
/*     */     
/* 316 */     if (!this.field_145850_b.field_72995_K && this.field_145987_o != 0 && (this.ticksSinceSync + this.field_145851_c + this.field_145848_d + this.field_145849_e) % 200 == 0) {
/*     */       
/* 318 */       this.field_145987_o = 0;
/* 319 */       float f = 5.0F;
/* 320 */       List list = this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a((this.field_145851_c - f), (this.field_145848_d - f), (this.field_145849_e - f), ((this.field_145851_c + 1) + f), ((this.field_145848_d + 1) + f), ((this.field_145849_e + 1) + f)));
/* 321 */       Iterator<EntityPlayer> iterator = list.iterator();
/*     */       
/* 323 */       while (iterator.hasNext()) {
/*     */         
/* 325 */         EntityPlayer entityplayer = iterator.next();
/*     */         
/* 327 */         if (entityplayer.field_71070_bA instanceof ContainerChestTFC) {
/*     */           
/* 329 */           IInventory iinventory = ((ContainerChestTFC)entityplayer.field_71070_bA).getLowerChestInventory();
/*     */           
/* 331 */           if (iinventory == this || (iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).func_90010_a(this)))
/*     */           {
/* 333 */             this.field_145987_o++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 339 */     this.field_145986_n = this.field_145989_m;
/* 340 */     float var1 = 0.1F;
/*     */ 
/*     */     
/* 343 */     if (this.field_145987_o > 0 && this.field_145989_m == 0.0F && this.field_145992_i == null && this.field_145991_k == null) {
/*     */       
/* 345 */       double var2 = this.field_145851_c + 0.5D;
/* 346 */       double var4 = this.field_145849_e + 0.5D;
/* 347 */       if (this.field_145988_l != null)
/* 348 */         var4 += 0.5D; 
/* 349 */       if (this.field_145990_j != null)
/* 350 */         var2 += 0.5D; 
/* 351 */       this.field_145850_b.func_72908_a(var2, this.field_145848_d + 0.5D, var4, "random.chestopen", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */     } 
/*     */     
/* 354 */     if ((this.field_145987_o == 0 && this.field_145989_m > 0.0F) || (this.field_145987_o > 0 && this.field_145989_m < 1.0F)) {
/*     */       
/* 356 */       if (this.field_145987_o > 0) {
/* 357 */         this.field_145989_m += var1;
/*     */       } else {
/* 359 */         this.field_145989_m -= var1;
/*     */       } 
/* 361 */       if (this.field_145989_m > 1.0F) {
/* 362 */         this.field_145989_m = 1.0F;
/*     */       }
/* 364 */       float var8 = this.field_145989_m;
/* 365 */       float var3 = 0.5F;
/* 366 */       if (this.field_145989_m < var3 && var8 >= var3 && this.field_145992_i == null && this.field_145991_k == null) {
/*     */         
/* 368 */         double var4 = this.field_145851_c + 0.5D;
/* 369 */         double var6 = this.field_145849_e + 0.5D;
/* 370 */         if (this.field_145988_l != null)
/* 371 */           var6 += 0.5D; 
/* 372 */         if (this.field_145990_j != null)
/* 373 */           var4 += 0.5D; 
/* 374 */         this.field_145850_b.func_72908_a(var4, this.field_145848_d + 0.5D, var6, "random.chestclosed", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/*     */       
/* 377 */       if (this.field_145989_m < 0.0F) {
/* 378 */         this.field_145989_m = 0.0F;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/* 386 */     return AxisAlignedBB.func_72330_a((this.field_145851_c - 1), this.field_145848_d, (this.field_145849_e - 1), (this.field_145851_c + 2), (this.field_145848_d + 2), (this.field_145849_e + 2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {
/* 392 */     this.field_145987_o++;
/* 393 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, TFCBlocks.chest, 1, this.field_145987_o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {
/* 399 */     this.field_145987_o--;
/* 400 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, TFCBlocks.chest, 1, this.field_145987_o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 406 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 412 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */