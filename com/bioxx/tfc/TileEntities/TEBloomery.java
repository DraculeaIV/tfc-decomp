/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockEarlyBloomery;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.ItemOre;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEBloomery
/*     */   extends NetworkTileEntity
/*     */ {
/*     */   public boolean isFlipped;
/*     */   public boolean bloomeryLit;
/*  30 */   private int validationCheck = 60;
/*     */   
/*     */   public int charcoalCount;
/*     */   
/*     */   public long fuelTimeLeft;
/*     */   
/*     */   public int oreCount;
/*     */   public int outCount;
/*     */   
/*     */   public TEBloomery() {
/*  40 */     this.isFlipped = false;
/*  41 */     this.bloomeryLit = false;
/*     */     
/*  43 */     this.charcoalCount = 0;
/*  44 */     this.oreCount = 0;
/*  45 */     this.outCount = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void swapFlipped() {
/*  50 */     if (this.isFlipped) { this.isFlipped = false; }
/*  51 */     else { this.isFlipped = true; }
/*  52 */      if (!this.field_145850_b.field_72995_K) {
/*  53 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isStackValid(int i, int j, int k) {
/*  58 */     Block yNegBlock = this.field_145850_b.func_147439_a(i, j - 1, k);
/*  59 */     if (yNegBlock != TFCBlocks.molten && this.field_145850_b
/*  60 */       .func_147439_a(i, j - 1, k).func_149688_o() != Material.field_151576_e && 
/*  61 */       !this.field_145850_b.func_147439_a(i, j - 1, k).func_149721_r() && yNegBlock != TFCBlocks.charcoal)
/*     */     {
/*     */       
/*  64 */       return false;
/*     */     }
/*  66 */     return ((BlockEarlyBloomery)TFCBlocks.bloomery).checkStack(this.field_145850_b, this.field_145851_c, j, this.field_145849_e, this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) & 0x3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addOreToFire(ItemStack is) {
/*  71 */     if (((ISmeltable)is.func_77973_b()).getMetalType(is) == Global.PIGIRON || ((ISmeltable)is.func_77973_b()).getMetalType(is) == Global.WROUGHTIRON) {
/*     */       
/*  73 */       this.outCount += ((ISmeltable)is.func_77973_b()).getMetalReturnAmount(is);
/*  74 */       return true;
/*     */     } 
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canLight() {
/*  81 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/*  83 */       if (this.charcoalCount < this.oreCount || this.oreCount == 0) {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  88 */       int[] direction = BlockEarlyBloomery.BLOOMERY_TO_STACK_MAP[getCharcoalDir(meta)];
/*  89 */       int x = this.field_145851_c + direction[0];
/*  90 */       int z = this.field_145849_e + direction[1];
/*  91 */       Block bid = this.field_145850_b.func_147439_a(x, this.field_145848_d, z);
/*  92 */       if (bid == TFCBlocks.charcoal && this.field_145850_b
/*  93 */         .func_72805_g(x, this.field_145848_d, z) >= 7 && !this.bloomeryLit) {
/*     */         
/*  95 */         this.bloomeryLit = true;
/*  96 */         this.fuelTimeLeft = (long)((float)TFC_Time.getTotalTicks() + 1000.0F * TFCOptions.bloomeryBurnTime);
/*  97 */         if ((meta & 0x4) == 0)
/*  98 */           this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta + 4, 3); 
/*  99 */         return true;
/*     */       } 
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCharcoalDir(int meta) {
/* 107 */     return meta & 0x3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 113 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 116 */       int count = this.charcoalCount + this.oreCount;
/*     */       
/* 118 */       int moltenCount = (count > 0 && count < 8) ? 1 : (count / 8);
/* 119 */       int validCount = 0;
/* 120 */       int maxCount = 0;
/*     */ 
/*     */       
/* 123 */       int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 124 */       int[] direction = BlockEarlyBloomery.BLOOMERY_TO_STACK_MAP[getCharcoalDir(meta)];
/*     */       
/* 126 */       int x = this.field_145851_c + direction[0];
/* 127 */       int z = this.field_145849_e + direction[1];
/*     */       
/* 129 */       if (this.field_145850_b.func_72899_e(x, this.field_145848_d, z)) {
/*     */         
/* 131 */         if (this.bloomeryLit && TFC_Time.getTotalTicks() > this.fuelTimeLeft) {
/*     */           
/* 133 */           if (this.field_145850_b.func_147439_a(x, this.field_145848_d, z) == TFCBlocks.molten)
/*     */           {
/* 135 */             if (this.field_145850_b.func_147449_b(x, this.field_145848_d, z, TFCBlocks.bloom)) {
/*     */               
/* 137 */               this.bloomeryLit = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 144 */               this.oreCount = 0;
/* 145 */               this.charcoalCount = 0;
/* 146 */               ((TEBloom)this.field_145850_b.func_147438_o(x, this.field_145848_d, z)).setSize(this.outCount);
/* 147 */               this.outCount = 0;
/*     */             } 
/*     */           }
/*     */           
/* 151 */           if ((meta & 0x4) != 0)
/*     */           {
/* 153 */             this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta & 0x3, 3);
/*     */           }
/*     */         } 
/*     */         
/* 157 */         if (this.outCount < 0)
/* 158 */           this.outCount = 0; 
/* 159 */         if (this.oreCount < 0)
/* 160 */           this.oreCount = 0; 
/* 161 */         if (this.charcoalCount < 0) {
/* 162 */           this.charcoalCount = 0;
/*     */         }
/*     */         
/* 165 */         if (isStackValid(x, this.field_145848_d + 1, z)) {
/*     */           
/* 167 */           maxCount = 8;
/*     */           
/* 169 */           if (isStackValid(x, this.field_145848_d + 2, z)) {
/*     */             
/* 171 */             maxCount = 16;
/*     */             
/* 173 */             if (isStackValid(x, this.field_145848_d + 3, z))
/*     */             {
/* 175 */               maxCount = 24;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 180 */         int moltenHeight = Math.max(count / 2 - 1, 0);
/*     */         
/* 182 */         for (int i = this.bloomeryLit ? 0 : 1, j = this.bloomeryLit ? (moltenHeight + 7) : moltenHeight; j > 0; i++, j -= 8) {
/*     */           
/* 184 */           Block bid = this.field_145850_b.func_147439_a(x, this.field_145848_d + i, z);
/*     */           
/* 186 */           if ((bid.isAir((IBlockAccess)this.field_145850_b, x, this.field_145848_d + i, z) || bid == TFCBlocks.molten || bid == TFCBlocks.charcoal) && this.field_145850_b
/* 187 */             .func_147439_a(x, this.field_145848_d - 1, z).func_149688_o() == Material.field_151576_e) {
/*     */ 
/*     */             
/* 190 */             if (isStackValid(x, this.field_145848_d + i, z)) {
/* 191 */               validCount++;
/*     */             }
/* 193 */             if (i <= validCount) {
/*     */               
/* 195 */               int mMeta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d + i, this.field_145849_e);
/* 196 */               int m = (j > 7) ? 7 : j;
/* 197 */               if (this.bloomeryLit) {
/*     */                 
/* 199 */                 if ((bid == TFCBlocks.molten && (mMeta & 0x8) == 0) || bid
/* 200 */                   .isAir((IBlockAccess)this.field_145850_b, x, this.field_145848_d + i, z) || bid == TFCBlocks.charcoal)
/*     */                 {
/*     */                   
/* 203 */                   m += 8;
/* 204 */                   this.field_145850_b.func_147465_d(x, this.field_145848_d + i, z, TFCBlocks.molten, m, 2);
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 209 */               else if (count > 0) {
/* 210 */                 this.field_145850_b.func_147465_d(x, this.field_145848_d + i, z, TFCBlocks.molten, m, 2);
/*     */               } else {
/* 212 */                 this.field_145850_b.func_147468_f(x, this.field_145848_d + i, z);
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 217 */               this.field_145850_b.func_147468_f(x, this.field_145848_d + i, z);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 222 */         if (!this.bloomeryLit && this.field_145850_b.func_147439_a(x, this.field_145848_d, z) == TFCBlocks.bloom) {
/*     */           
/* 224 */           if (isStackValid(x, this.field_145848_d + 3, z) && 
/* 225 */             isStackValid(x, this.field_145848_d + 2, z) && 
/* 226 */             isStackValid(x, this.field_145848_d + 1, z))
/*     */           {
/* 228 */             if (this.field_145850_b.func_147439_a(x, this.field_145848_d + 3, z) == TFCBlocks.molten) {
/* 229 */               this.field_145850_b.func_147468_f(x, this.field_145848_d + 3, z);
/*     */             }
/*     */           }
/* 232 */           if (isStackValid(x, this.field_145848_d + 2, z) && 
/* 233 */             isStackValid(x, this.field_145848_d + 1, z))
/*     */           {
/* 235 */             if (this.field_145850_b.func_147439_a(x, this.field_145848_d + 2, z) == TFCBlocks.molten) {
/* 236 */               this.field_145850_b.func_147468_f(x, this.field_145848_d + 2, z);
/*     */             }
/*     */           }
/* 239 */           if (isStackValid(x, this.field_145848_d + 1, z))
/*     */           {
/* 241 */             if (this.field_145850_b.func_147439_a(x, this.field_145848_d + 1, z) == TFCBlocks.molten) {
/* 242 */               this.field_145850_b.func_147468_f(x, this.field_145848_d + 1, z);
/*     */             }
/*     */           }
/*     */         } 
/* 246 */         if (moltenCount == 0) {
/* 247 */           moltenCount = 1;
/*     */         }
/*     */         
/* 250 */         List list = this.field_145850_b.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(x, this.field_145848_d, z, (x + 1), (this.field_145848_d + maxCount / 8) + 1.1D, (z + 1)));
/*     */ 
/*     */         
/* 253 */         List playerList = this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a(x, this.field_145848_d, z, (x + 1), (this.field_145848_d + maxCount / 8) + 1.1D, (z + 1)));
/*     */ 
/*     */         
/* 256 */         if (list != null && !list.isEmpty() && !this.bloomeryLit && (playerList == null || playerList.isEmpty()))
/*     */         {
/*     */           
/* 259 */           for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */             
/* 261 */             EntityItem entity = iterator.next();
/* 262 */             if (entity.func_92059_d().func_77973_b() == TFCItems.coal && entity
/* 263 */               .func_92059_d().func_77960_j() == 1) {
/*     */               
/* 265 */               for (int c = 0; c < (entity.func_92059_d()).field_77994_a; c++) {
/*     */                 
/* 267 */                 if (this.charcoalCount + this.oreCount < 2 * maxCount && this.charcoalCount < maxCount) {
/*     */                   
/* 269 */                   this.charcoalCount++;
/* 270 */                   (entity.func_92059_d()).field_77994_a--;
/*     */                 } 
/*     */               } 
/* 273 */               if ((entity.func_92059_d()).field_77994_a == 0)
/* 274 */                 entity.func_70106_y(); 
/*     */               continue;
/*     */             } 
/* 277 */             if (entity.func_92059_d().func_77973_b() instanceof ItemOre && ((ItemOre)entity.func_92059_d().func_77973_b()).isSmeltable(entity.func_92059_d())) {
/*     */               
/* 279 */               int c = (entity.func_92059_d()).field_77994_a;
/* 280 */               while (c > 0) {
/*     */                 
/* 282 */                 if (this.charcoalCount + this.oreCount < 2 * maxCount && this.oreCount < maxCount && this.outCount < 1000)
/*     */                 {
/* 284 */                   if (addOreToFire(new ItemStack(entity.func_92059_d().func_77973_b(), 1, entity.func_92059_d().func_77960_j()))) {
/*     */                     
/* 286 */                     this.oreCount++;
/* 287 */                     c--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 295 */               if (c == 0) {
/* 296 */                 entity.func_70106_y(); continue;
/*     */               } 
/* 298 */               (entity.func_92059_d()).field_77994_a = c; continue;
/*     */             } 
/* 300 */             if (entity.func_92059_d().func_77973_b() instanceof ISmeltable && ((ISmeltable)entity
/* 301 */               .func_92059_d().func_77973_b()).isSmeltable(entity.func_92059_d())) {
/*     */               
/* 303 */               int c = (entity.func_92059_d()).field_77994_a;
/* 304 */               while (c > 0) {
/*     */                 
/* 306 */                 if (((ISmeltable)entity.func_92059_d().func_77973_b()).getMetalReturnAmount(entity.func_92059_d()) < 100 && this.oreCount < maxCount && this.outCount < 1000)
/*     */                 {
/* 308 */                   if (addOreToFire(new ItemStack(entity.func_92059_d().func_77973_b(), 1, entity.func_92059_d().func_77960_j()))) {
/*     */                     
/* 310 */                     this.oreCount++;
/* 311 */                     c--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 320 */               if (c == 0) {
/* 321 */                 entity.func_70106_y(); continue;
/*     */               } 
/* 323 */               (entity.func_92059_d()).field_77994_a = c;
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 328 */         if (this.validationCheck <= 0) {
/*     */           
/* 330 */           if (((BlockEarlyBloomery)this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e)).func_149718_j(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/* 331 */             this.validationCheck = 600;
/*     */           } else {
/*     */             
/* 334 */             this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 335 */             this.field_145850_b.func_72838_d((Entity)new EntityItem(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, new ItemStack(TFCBlocks.bloomery, 1)));
/*     */           } 
/*     */         } else {
/*     */           
/* 339 */           this.validationCheck--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 347 */     super.func_145841_b(nbttagcompound);
/* 348 */     nbttagcompound.func_74757_a("isFlipped", this.isFlipped);
/* 349 */     nbttagcompound.func_74772_a("fuelTimeLeft", this.fuelTimeLeft);
/* 350 */     nbttagcompound.func_74768_a("charcoalCount", this.charcoalCount);
/* 351 */     nbttagcompound.func_74768_a("outCount", this.outCount);
/* 352 */     nbttagcompound.func_74768_a("oreCount", this.oreCount);
/* 353 */     nbttagcompound.func_74757_a("isLit", this.bloomeryLit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 359 */     super.func_145839_a(nbttagcompound);
/* 360 */     this.isFlipped = nbttagcompound.func_74767_n("isFlipped");
/* 361 */     this.fuelTimeLeft = nbttagcompound.func_74763_f("fuelTimeLeft");
/* 362 */     this.charcoalCount = nbttagcompound.func_74762_e("charcoalCount");
/* 363 */     this.outCount = nbttagcompound.func_74762_e("outCount");
/* 364 */     this.oreCount = nbttagcompound.func_74762_e("oreCount");
/* 365 */     this.bloomeryLit = nbttagcompound.func_74767_n("isLit");
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 370 */     this.isFlipped = nbt.func_74767_n("isFlipped");
/* 371 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
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
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 388 */     nbt.func_74757_a("isFlipped", this.isFlipped);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBloomery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */