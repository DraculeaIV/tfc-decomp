/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Flora.BlockFruitLeaves;
/*     */ import com.bioxx.tfc.Blocks.Flora.BlockFruitWood;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.FloraIndex;
/*     */ import com.bioxx.tfc.Food.FloraManager;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEFruitTreeWood
/*     */   extends TileEntity
/*     */   implements IInventory
/*     */ {
/*  28 */   private static final long TRUNK_GROW_TIME = (long)(1.5F * TFC_Time.daysInMonth);
/*  29 */   private static final long BRANCH_GROW_TIME = TFC_Time.daysInMonth;
/*     */ 
/*     */ 
/*     */   
/*  33 */   public int height = 0;
/*     */   public boolean isTrunk = false;
/*  35 */   public long birthTimeWood = 0L;
/*  36 */   public long birthTimeLeaves = 0L;
/*     */   
/*     */   private static final long LEAF_GROWTH_RATE = 20L;
/*     */   
/*     */   public void initBirth() {
/*  41 */     this.birthTimeWood = TFC_Time.getTotalDays();
/*  42 */     this.birthTimeLeaves = TFC_Time.getTotalDays();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBirthWood(long t) {
/*  47 */     this.birthTimeWood = t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void increaseBirthWood(long t) {
/*  52 */     this.birthTimeWood += t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBirthLeaves(long t) {
/*  57 */     this.birthTimeLeaves = t;
/*     */   }
/*     */   
/*     */   public void increaseBirthLeaves(long t) {
/*  61 */     this.birthTimeLeaves += t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTrunk(boolean b) {
/*  66 */     this.isTrunk = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHeight(int h) {
/*  71 */     this.height = h;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setupBirth(boolean isTrunk, int h, long woodBirth, long leafBirth) {
/*  76 */     setTrunk(isTrunk);
/*  77 */     setHeight(h);
/*  78 */     initBirth();
/*  79 */     setBirthWood(woodBirth);
/*  80 */     setBirthLeaves(leafBirth);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  86 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/*  88 */       FloraManager manager = FloraManager.getInstance();
/*  89 */       FloraIndex fi = manager.findMatchingIndex(BlockFruitWood.getType(this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e)));
/*     */       
/*  91 */       int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  92 */       float temp = TFC_Climate.getHeightAdjustedTemp(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       
/*  94 */       int month = TFC_Time.getSeasonAdjustedMonth(this.field_145849_e);
/*  95 */       if (month < 9 && fi != null && temp >= fi.minTemp && temp < fi.maxTemp) {
/*     */         
/*  97 */         int t = 1;
/*  98 */         if (month < 3) {
/*  99 */           t = 2;
/*     */         }
/*     */         
/* 102 */         if (this.birthTimeWood + TRUNK_GROW_TIME < TFC_Time.getTotalDays() && this.height < 3 && this.isTrunk && this.field_145850_b.field_73012_v.nextInt(16 / t) == 0 && (this.field_145850_b
/* 103 */           .func_147437_c(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) || this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) == TFCBlocks.fruitTreeLeaves || this.field_145850_b
/* 104 */           .func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) == TFCBlocks.fruitTreeLeaves2)) {
/*     */           
/* 106 */           this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e, TFCBlocks.fruitTreeWood, meta, 2);
/* 107 */           if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) instanceof TEFruitTreeWood)
/*     */           {
/* 109 */             TEFruitTreeWood trunkTE = (TEFruitTreeWood)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 110 */             trunkTE.setupBirth(true, this.height + 1, this.birthTimeWood + TRUNK_GROW_TIME, this.birthTimeLeaves);
/*     */             
/* 112 */             increaseBirthWood(TRUNK_GROW_TIME);
/* 113 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */           }
/*     */         
/*     */         }
/* 117 */         else if (this.birthTimeWood + BRANCH_GROW_TIME < TFC_Time.getTotalDays() && this.height == 2 && this.isTrunk && this.field_145850_b.field_73012_v.nextInt(16 / t) == 0 && this.field_145850_b
/* 118 */           .func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) == TFCBlocks.fruitTreeWood) {
/*     */           
/* 120 */           int r = this.field_145850_b.field_73012_v.nextInt(4);
/* 121 */           if (r == 0 && this.field_145850_b.func_72899_e(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) && (this.field_145850_b.func_147437_c(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) || this.field_145850_b
/* 122 */             .func_147439_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.fruitTreeLeaves || this.field_145850_b.func_147439_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.fruitTreeLeaves2)) {
/*     */             
/* 124 */             this.field_145850_b.func_147465_d(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e, TFCBlocks.fruitTreeWood, meta, 2);
/* 125 */             if (this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) instanceof TEFruitTreeWood)
/*     */             {
/* 127 */               TEFruitTreeWood branchTE = (TEFruitTreeWood)this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/* 128 */               branchTE.setupBirth(false, this.height, this.birthTimeWood + BRANCH_GROW_TIME, this.birthTimeLeaves);
/*     */             }
/*     */           
/* 131 */           } else if (r == 1 && this.field_145850_b.func_72899_e(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) && (this.field_145850_b.func_147437_c(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) || this.field_145850_b
/* 132 */             .func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) == TFCBlocks.fruitTreeLeaves || this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) == TFCBlocks.fruitTreeLeaves2)) {
/*     */             
/* 134 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1, TFCBlocks.fruitTreeWood, meta, 2);
/* 135 */             if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) instanceof TEFruitTreeWood)
/*     */             {
/* 137 */               TEFruitTreeWood branchTE = (TEFruitTreeWood)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/* 138 */               branchTE.setupBirth(false, this.height, this.birthTimeWood + BRANCH_GROW_TIME, this.birthTimeLeaves);
/*     */             }
/*     */           
/* 141 */           } else if (r == 2 && this.field_145850_b.func_72899_e(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) && (this.field_145850_b.func_147437_c(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) || this.field_145850_b
/* 142 */             .func_147439_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.fruitTreeLeaves || this.field_145850_b.func_147439_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.fruitTreeLeaves2)) {
/*     */             
/* 144 */             this.field_145850_b.func_147465_d(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e, TFCBlocks.fruitTreeWood, meta, 2);
/* 145 */             if (this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) instanceof TEFruitTreeWood)
/*     */             {
/* 147 */               TEFruitTreeWood branchTE = (TEFruitTreeWood)this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/* 148 */               branchTE.setupBirth(false, this.height, this.birthTimeWood + BRANCH_GROW_TIME, this.birthTimeLeaves);
/*     */             }
/*     */           
/* 151 */           } else if (r == 3 && this.field_145850_b.func_72899_e(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) && (this.field_145850_b.func_147437_c(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) || this.field_145850_b
/* 152 */             .func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) == TFCBlocks.fruitTreeLeaves || this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) == TFCBlocks.fruitTreeLeaves2)) {
/*     */             
/* 154 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1, TFCBlocks.fruitTreeWood, meta, 2);
/* 155 */             if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) instanceof TEFruitTreeWood) {
/*     */               
/* 157 */               TEFruitTreeWood branchTE = (TEFruitTreeWood)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/* 158 */               branchTE.setupBirth(false, this.height, this.birthTimeWood + BRANCH_GROW_TIME, this.birthTimeLeaves);
/*     */             } 
/*     */           } 
/*     */           
/* 162 */           increaseBirthWood(BRANCH_GROW_TIME);
/* 163 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         } 
/*     */         
/* 166 */         if (this.birthTimeLeaves + 2L < TFC_Time.getTotalDays() && this.field_145850_b.field_73012_v.nextInt(20) == 0 && this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e) != TFCBlocks.fruitTreeWood) {
/*     */           
/* 168 */           int m = meta & 0x7;
/* 169 */           Block bid = (meta < 8) ? TFCBlocks.fruitTreeLeaves : TFCBlocks.fruitTreeLeaves2;
/*     */           
/* 171 */           if (checkLeaves(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/*     */             
/* 173 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e, bid, m, 2);
/* 174 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/*     */           }
/* 176 */           else if (checkLeaves(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e)) {
/*     */             
/* 178 */             this.field_145850_b.func_147465_d(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e, bid, m, 2);
/* 179 */             this.field_145850_b.func_147471_g(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*     */           }
/* 181 */           else if (checkLeaves(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e)) {
/*     */             
/* 183 */             this.field_145850_b.func_147465_d(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e, bid, m, 2);
/* 184 */             this.field_145850_b.func_147471_g(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/*     */           }
/* 186 */           else if (checkLeaves(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1)) {
/*     */             
/* 188 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1, bid, m, 2);
/* 189 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/*     */           }
/* 191 */           else if (checkLeaves(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1)) {
/*     */             
/* 193 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1, bid, m, 2);
/* 194 */             this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*     */           }
/* 196 */           else if (checkLeaves(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e - 1)) {
/*     */             
/* 198 */             this.field_145850_b.func_147465_d(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e - 1, bid, m, 2);
/* 199 */             this.field_145850_b.func_147471_g(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e - 1);
/*     */           }
/* 201 */           else if (checkLeaves(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e + 1)) {
/*     */             
/* 203 */             this.field_145850_b.func_147465_d(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e + 1, bid, m, 2);
/* 204 */             this.field_145850_b.func_147471_g(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e + 1);
/*     */           }
/* 206 */           else if (checkLeaves(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e - 1)) {
/*     */             
/* 208 */             this.field_145850_b.func_147465_d(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e - 1, bid, m, 2);
/* 209 */             this.field_145850_b.func_147471_g(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e - 1);
/*     */           }
/* 211 */           else if (checkLeaves(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e + 1)) {
/*     */             
/* 213 */             this.field_145850_b.func_147465_d(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e + 1, bid, m, 2);
/* 214 */             this.field_145850_b.func_147471_g(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e + 1);
/*     */           } 
/*     */           
/* 217 */           increaseBirthLeaves(2L);
/* 218 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkLeaves(int xCoord, int yCoord, int zCoord) {
/* 226 */     return (this.field_145850_b.func_72899_e(xCoord, yCoord, zCoord) && this.field_145850_b.func_147437_c(xCoord, yCoord, zCoord) && this.field_145850_b
/* 227 */       .func_147437_c(xCoord, yCoord + 1, zCoord) && BlockFruitLeaves.canStay(this.field_145850_b, xCoord, yCoord, zCoord));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 238 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 244 */     return "Fruit Tree Wood";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 250 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 256 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 267 */     super.func_145839_a(nbttagcompound);
/* 268 */     this.birthTimeWood = nbttagcompound.func_74763_f("birthTime");
/* 269 */     this.birthTimeLeaves = nbttagcompound.func_74763_f("birthTimeLeaves");
/* 270 */     this.isTrunk = nbttagcompound.func_74767_n("isTrunk");
/* 271 */     this.height = nbttagcompound.func_74762_e("height");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 277 */     super.func_145841_b(nbttagcompound);
/* 278 */     nbttagcompound.func_74772_a("birthTime", this.birthTimeWood);
/* 279 */     nbttagcompound.func_74772_a("birthTimeLeaves", this.birthTimeLeaves);
/* 280 */     nbttagcompound.func_74757_a("isTrunk", this.isTrunk);
/* 281 */     nbttagcompound.func_74768_a("height", this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 287 */     NBTTagCompound nbt = new NBTTagCompound();
/* 288 */     func_145841_b(nbt);
/* 289 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 295 */     func_145839_a(pkt.func_148857_g());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 302 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int var1) {
/* 308 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int var1, int var2) {
/* 314 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int var1, ItemStack var2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 325 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 331 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFruitTreeWood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */