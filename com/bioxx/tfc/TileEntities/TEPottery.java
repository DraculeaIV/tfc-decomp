/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.Pottery.ItemPotteryBase;
/*     */ import com.bioxx.tfc.api.Crafting.KilnCraftingManager;
/*     */ import com.bioxx.tfc.api.Crafting.KilnRecipe;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEPottery
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*  40 */   public ItemStack[] inventory = new ItemStack[12];
/*     */   
/*     */   public boolean hasRack = false;
/*     */   public long burnStart;
/*     */   
/*     */   public boolean canAddItem(int slot) {
/*  46 */     if (this.inventory[0] != null && this.inventory[0].func_77973_b() instanceof net.minecraft.item.ItemBlock)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     return (this.inventory[slot] == null);
/*     */   }
/*     */   public int straw;
/*     */   public int wood;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  58 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  64 */     TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */ 
/*     */     
/*  67 */     if (!this.field_145850_b.field_72995_K && this.straw > 0 && this.wood < 8)
/*     */     {
/*     */ 
/*     */       
/*  71 */       if (isFireNear().booleanValue()) {
/*     */         
/*  73 */         ejectContents();
/*  74 */         this.field_145850_b.func_147475_p(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  75 */         this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, Blocks.field_150350_a);
/*  76 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     }
/*     */     
/*  80 */     if (!this.field_145850_b.field_72995_K && this.wood == 8) {
/*     */       
/*  82 */       Block blockAbove = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/*     */ 
/*     */       
/*  85 */       if (this.burnStart == 0L && isFireNear().booleanValue()) {
/*  86 */         startPitFire();
/*     */       }
/*     */       
/*  89 */       if (blockAbove != Blocks.field_150480_ab && (float)(TFC_Time.getTotalTicks() - this.burnStart) <= 1000.0F * TFCOptions.pitKilnBurnTime)
/*     */       {
/*  91 */         if ((blockAbove.isAir((IBlockAccess)this.field_145850_b, this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) || this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e).func_149688_o().func_76217_h()) && isValid()) {
/*  92 */           this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e, (Block)Blocks.field_150480_ab);
/*     */         } else {
/*     */           
/*  95 */           this.wood = 0;
/*  96 */           this.inventory[4] = null; this.inventory[5] = null; this.inventory[6] = null; this.inventory[7] = null;
/*  97 */           this.inventory[8] = null; this.inventory[9] = null; this.inventory[10] = null; this.inventory[11] = null;
/*  98 */           this.straw = 0;
/*  99 */           this.burnStart = 0L;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 104 */       if (blockAbove == Blocks.field_150480_ab && (float)TFC_Time.getTotalTicks() >= (float)this.burnStart + TFCOptions.pitKilnBurnTime * 1000.0F) {
/*     */         
/* 106 */         this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 107 */         if (this.inventory[0] != null) {
/*     */           
/* 109 */           this.inventory[0] = KilnCraftingManager.getInstance().findCompleteRecipe(new KilnRecipe(this.inventory[0], 0)).func_77946_l();
/* 110 */           if (this.inventory[0].func_77973_b() instanceof ItemPotteryBase)
/* 111 */             ((ItemPotteryBase)this.inventory[0].func_77973_b()).onDoneCooking(this.field_145850_b, this.inventory[0], Alloy.EnumTier.TierI); 
/*     */         } 
/* 113 */         if (this.inventory[1] != null) {
/*     */           
/* 115 */           this.inventory[1] = KilnCraftingManager.getInstance().findCompleteRecipe(new KilnRecipe(this.inventory[1], 0)).func_77946_l();
/* 116 */           if (this.inventory[1].func_77973_b() instanceof ItemPotteryBase)
/* 117 */             ((ItemPotteryBase)this.inventory[1].func_77973_b()).onDoneCooking(this.field_145850_b, this.inventory[1], Alloy.EnumTier.TierI); 
/*     */         } 
/* 119 */         if (this.inventory[2] != null) {
/*     */           
/* 121 */           this.inventory[2] = KilnCraftingManager.getInstance().findCompleteRecipe(new KilnRecipe(this.inventory[2], 0)).func_77946_l();
/* 122 */           if (this.inventory[2].func_77973_b() instanceof ItemPotteryBase)
/* 123 */             ((ItemPotteryBase)this.inventory[2].func_77973_b()).onDoneCooking(this.field_145850_b, this.inventory[2], Alloy.EnumTier.TierI); 
/*     */         } 
/* 125 */         if (this.inventory[3] != null) {
/*     */           
/* 127 */           this.inventory[3] = KilnCraftingManager.getInstance().findCompleteRecipe(new KilnRecipe(this.inventory[3], 0)).func_77946_l();
/* 128 */           if (this.inventory[3].func_77973_b() instanceof ItemPotteryBase) {
/* 129 */             ((ItemPotteryBase)this.inventory[3].func_77973_b()).onDoneCooking(this.field_145850_b, this.inventory[3], Alloy.EnumTier.TierI);
/*     */           }
/*     */         } 
/* 132 */         this.wood = 0;
/* 133 */         this.inventory[4] = null; this.inventory[5] = null; this.inventory[6] = null; this.inventory[7] = null;
/* 134 */         this.inventory[8] = null; this.inventory[9] = null; this.inventory[10] = null; this.inventory[11] = null;
/* 135 */         this.straw = 0;
/* 136 */         this.burnStart = 0L;
/* 137 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Boolean isFireNear() {
/* 144 */     Boolean foundFire = Boolean.valueOf(false);
/*     */     
/* 146 */     for (int x = -1; x <= 1; x++) {
/*     */       
/* 148 */       for (int z = -1; z <= 1; z++) {
/*     */         
/* 150 */         if (this.field_145850_b.func_72899_e(this.field_145851_c + x, this.field_145848_d + 1, this.field_145849_e + z) && this.field_145850_b.func_147439_a(this.field_145851_c + x, this.field_145848_d + 1, this.field_145849_e + z) == Blocks.field_150480_ab) {
/* 151 */           foundFire = Boolean.valueOf(true);
/*     */         }
/*     */       } 
/*     */     } 
/* 155 */     return foundFire;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startPitFire() {
/* 160 */     if (this.straw == 8 && this.wood == 8) {
/*     */       
/* 162 */       this.field_145850_b.func_147449_b(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e, (Block)Blocks.field_150480_ab);
/* 163 */       this.burnStart = TFC_Time.getTotalTicks();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addLog(ItemStack is, EntityPlayer player) {
/* 169 */     if (this.wood < 8)
/*     */     {
/* 171 */       if (!player.field_71075_bZ.field_75098_d) {
/*     */         
/* 173 */         for (int i = 4; i < 12; i++) {
/*     */           
/* 175 */           if (this.inventory[i] == null)
/*     */           {
/* 177 */             this.wood++;
/* 178 */             ItemStack itemStack = is.func_77946_l();
/* 179 */             is.field_77994_a--;
/* 180 */             itemStack.field_77994_a = 1;
/* 181 */             func_70299_a(i, itemStack);
/* 182 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 183 */             return true;
/*     */           }
/*     */         
/*     */         } 
/*     */       } else {
/*     */         
/* 189 */         for (int i = 4; i < 12; i++) {
/*     */           
/* 191 */           if (this.inventory[i] == null) {
/*     */             
/* 193 */             this.wood++;
/* 194 */             ItemStack itemStack = is.func_77946_l();
/* 195 */             itemStack.field_77994_a = 1;
/* 196 */             func_70299_a(i, itemStack);
/*     */           } 
/*     */         } 
/* 199 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 200 */         return true;
/*     */       } 
/*     */     }
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addStraw(ItemStack is, EntityPlayer player) {
/* 208 */     if (this.straw < 8) {
/*     */       
/* 210 */       if (!player.field_71075_bZ.field_75098_d) {
/*     */         
/* 212 */         this.straw++;
/* 213 */         is.field_77994_a--;
/*     */       }
/*     */       else {
/*     */         
/* 217 */         this.straw = 8;
/*     */       } 
/* 219 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 228 */     boolean surroundSolids = (TFC_Core.isNorthFaceSolid(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) && TFC_Core.isSouthFaceSolid(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) && TFC_Core.isEastFaceSolid(this.field_145850_b, this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) && TFC_Core.isWestFaceSolid(this.field_145850_b, this.field_145851_c + 1, this.field_145848_d, this.field_145849_e));
/* 229 */     return (surroundSolids && this.field_145850_b.isSideSolid(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e, ForgeDirection.UP));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLit() {
/* 234 */     return (TFC_Time.getTotalTicks() > this.burnStart && (float)(TFC_Time.getTotalTicks() - this.burnStart) < 1000.0F * TFCOptions.pitKilnBurnTime);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 240 */     this.inventory[i] = itemstack;
/* 241 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 242 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */   
/*     */   public void ejectContents() {
/* 247 */     float f3 = 0.05F;
/*     */     
/* 249 */     Random rand = new Random();
/* 250 */     float f = rand.nextFloat() * 0.8F;
/* 251 */     float f1 = rand.nextFloat() * 0.4F;
/* 252 */     float f2 = rand.nextFloat() * 0.8F;
/*     */     
/* 254 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 256 */       if (this.inventory[i] != null) {
/*     */         
/* 258 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.inventory[i]);
/* 259 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 260 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 261 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 262 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 263 */         this.inventory[i] = null;
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     if (this.straw > 0) {
/*     */       
/* 269 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), new ItemStack(TFCItems.straw, this.straw));
/* 270 */       entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 271 */       entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 272 */       entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 273 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectItem(int index) {
/* 282 */     if (this.inventory[index] != null) {
/*     */       
/* 284 */       EntityItem entityitem = new EntityItem(this.field_145850_b, this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D, this.inventory[index]);
/* 285 */       entityitem.lifespan = 48000;
/* 286 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/* 287 */       this.inventory[index] = null;
/*     */     } 
/*     */     
/* 290 */     if (this.inventory[0] == null && this.inventory[1] == null && this.inventory[2] == null && this.inventory[3] == null) {
/*     */ 
/*     */       
/* 293 */       int m = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 294 */       if (m > 0) {
/*     */         
/* 296 */         EntityItem entityitem = new EntityItem(this.field_145850_b, this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D, new ItemStack(TFCItems.straw, m));
/* 297 */         entityitem.lifespan = 48000;
/* 298 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/* 300 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 307 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 318 */     return this.inventory.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 324 */     return this.inventory[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 330 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 342 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 348 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 354 */     return "Pottery";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 360 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 371 */     super.func_145841_b(nbttagcompound);
/* 372 */     NBTTagList nbttaglist = new NBTTagList();
/* 373 */     for (int i = 0; i < this.inventory.length; i++) {
/*     */       
/* 375 */       if (this.inventory[i] != null) {
/*     */         
/* 377 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 378 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 379 */         this.inventory[i].func_77955_b(nbttagcompound1);
/* 380 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 383 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/* 384 */     nbttagcompound.func_74772_a("burnStart", this.burnStart);
/* 385 */     nbttagcompound.func_74757_a("hasRack", this.hasRack);
/* 386 */     nbttagcompound.func_74768_a("wood", this.wood);
/* 387 */     nbttagcompound.func_74768_a("straw", this.straw);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 393 */     super.func_145839_a(nbt);
/* 394 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 395 */     this.inventory = new ItemStack[func_70302_i_()];
/* 396 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 398 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 399 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 400 */       if (byte0 >= 0 && byte0 < this.inventory.length)
/* 401 */         this.inventory[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/* 403 */     this.burnStart = nbt.func_74763_f("burnStart");
/* 404 */     this.wood = nbt.func_74762_e("wood");
/* 405 */     this.hasRack = nbt.func_74767_n("hasRack");
/* 406 */     this.straw = nbt.func_74762_e("straw");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 412 */     func_145839_a(nbt);
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
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 432 */     func_145841_b(nbt);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEPottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */