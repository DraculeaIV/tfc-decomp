/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockSluice;
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockOre;
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class TESluice
/*     */   extends TileEntity implements IInventory {
/*     */   public int soilAmount;
/*     */   public long lastUpdateTicks;
/*     */   public int processTimeRemaining;
/*     */   private ItemStack[] sluiceItemStacks;
/*  40 */   private Random random = new Random(); public boolean waterInput; public boolean waterOutput; public byte soilType; private boolean initialized;
/*  41 */   private Set<Integer> coreSampleTypes = new TreeSet<Integer>();
/*  42 */   private List<ItemStack> coreSampleStacks = new ArrayList<ItemStack>();
/*     */ 
/*     */   
/*     */   public TESluice() {
/*  46 */     this.sluiceItemStacks = new ItemStack[9];
/*  47 */     this.soilAmount = 0;
/*  48 */     this.lastUpdateTicks = 0L;
/*  49 */     this.processTimeRemaining = 0;
/*  50 */     this.waterInput = false;
/*  51 */     this.waterOutput = false;
/*  52 */     this.soilType = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToInventory(ItemStack is) {
/*  57 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/*  59 */       ItemStack stackInSlot = func_70301_a(i);
/*  60 */       if (stackInSlot == null) {
/*     */ 
/*     */         
/*  63 */         func_70299_a(i, is);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*  69 */       if (stackInSlot == is && stackInSlot.func_77960_j() == is.func_77960_j())
/*     */       {
/*     */         
/*  72 */         if (stackInSlot.field_77994_a + is.field_77994_a > func_70297_j_()) {
/*     */ 
/*     */           
/*  75 */           int size = func_70297_j_() - stackInSlot.field_77994_a;
/*  76 */           stackInSlot.field_77994_a += size;
/*  77 */           is.field_77994_a -= size;
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/*  83 */           stackInSlot.field_77994_a += is.field_77994_a;
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  94 */     ejectItem(is);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 105 */     if (this.sluiceItemStacks[i] != null) {
/*     */       
/* 107 */       if ((this.sluiceItemStacks[i]).field_77994_a <= j) {
/*     */         
/* 109 */         ItemStack itemstack = this.sluiceItemStacks[i];
/* 110 */         this.sluiceItemStacks[i] = null;
/* 111 */         return itemstack;
/*     */       } 
/* 113 */       ItemStack itemstack1 = this.sluiceItemStacks[i].func_77979_a(j);
/* 114 */       if ((this.sluiceItemStacks[i]).field_77994_a == 0)
/* 115 */         this.sluiceItemStacks[i] = null; 
/* 116 */       return itemstack1;
/*     */     } 
/*     */ 
/*     */     
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void ejectItem(ItemStack is) {
/* 126 */     float f = this.random.nextFloat() * 0.8F + 0.1F;
/* 127 */     float f1 = this.random.nextFloat() * 2.0F + 0.4F;
/* 128 */     float f2 = this.random.nextFloat() * 0.8F + 0.1F;
/* 129 */     EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), new ItemStack(is.func_77973_b(), is.field_77994_a, is.func_77960_j()));
/* 130 */     float f3 = 0.05F;
/* 131 */     entityitem.field_70159_w = ((float)this.random.nextGaussian() * f3);
/* 132 */     entityitem.field_70181_x = ((float)this.random.nextGaussian() * f3 + 0.2F);
/* 133 */     entityitem.field_70179_y = ((float)this.random.nextGaussian() * f3);
/* 134 */     this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFirstFreeSlot() {
/* 139 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 141 */       if (func_70301_a(i) == null)
/* 142 */         return i; 
/*     */     } 
/* 144 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 150 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 156 */     return "Sluice";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessScaled(int i) {
/* 161 */     return this.processTimeRemaining * i / 100;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 167 */     return this.sluiceItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 173 */     return this.sluiceItemStacks[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 185 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this)
/* 186 */       return false; 
/* 187 */     return (entityplayer.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) <= 64.0D);
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
/* 198 */     this.sluiceItemStacks[i] = itemstack;
/* 199 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 200 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 206 */     int meta = func_145832_p();
/* 207 */     boolean isFoot = BlockSluice.isBlockFootOfBed(meta);
/* 208 */     if (isFoot || this.soilAmount == -1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 214 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 216 */       if (!this.initialized) {
/*     */         
/* 218 */         for (int x = -100; x <= 100; x += 2) {
/*     */           
/* 220 */           for (int z = -100; z <= 100; z += 2) {
/*     */             
/* 222 */             for (int y = this.field_145848_d; y > this.field_145848_d - 50; y--) {
/*     */               
/* 224 */               if (this.field_145850_b.func_147439_a(x + this.field_145851_c, y, z + this.field_145849_e) == TFCBlocks.ore) {
/*     */                 
/* 226 */                 int m = this.field_145850_b.func_72805_g(x + this.field_145851_c, y, z + this.field_145849_e);
/* 227 */                 if (m != 14 && m != 15)
/*     */                 {
/* 229 */                   if (!this.coreSampleTypes.contains(Integer.valueOf(m))) {
/*     */                     
/* 231 */                     this.coreSampleTypes.add(Integer.valueOf(m));
/* 232 */                     this.coreSampleStacks.add(new ItemStack(BlockOre.getDroppedItem(m), 1, m));
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 239 */         this.initialized = true;
/*     */       } 
/*     */       
/* 242 */       List list = this.field_145850_b.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1.1F), (this.field_145849_e + 1)));
/*     */ 
/*     */ 
/*     */       
/* 246 */       for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */         
/* 248 */         EntityItem entity = iterator.next();
/* 249 */         Item item = entity.func_92059_d().func_77973_b();
/* 250 */         if (item == Item.func_150898_a(TFCBlocks.gravel) || item == Item.func_150898_a(TFCBlocks.gravel2) || item == 
/* 251 */           Item.func_150898_a(TFCBlocks.sand) || item == Item.func_150898_a(TFCBlocks.sand2)) {
/*     */           
/* 253 */           int stackSize = (entity.func_92059_d()).field_77994_a;
/* 254 */           int accept = (69 - this.soilAmount) / 20;
/* 255 */           if (stackSize <= accept) {
/*     */             
/* 257 */             this.soilAmount += 20 * stackSize;
/* 258 */             entity.func_70106_y();
/* 259 */             if (this.soilAmount > 50)
/* 260 */               this.soilAmount = 50; 
/* 261 */             if (item == Item.func_150898_a(TFCBlocks.gravel) || item == Item.func_150898_a(TFCBlocks.gravel2)) {
/* 262 */               this.soilType = 2; continue;
/*     */             } 
/* 264 */             this.soilType = 1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 270 */       long tickDiff = TFC_Time.getTotalTicks() - this.lastUpdateTicks;
/* 271 */       if (this.lastUpdateTicks == 0L)
/*     */       {
/*     */         
/* 274 */         tickDiff = 0L;
/*     */       }
/* 276 */       this.lastUpdateTicks = TFC_Time.getTotalTicks();
/*     */ 
/*     */       
/* 279 */       if (this.soilAmount > 0 && this.waterInput && this.waterOutput) {
/*     */ 
/*     */ 
/*     */         
/* 283 */         this.processTimeRemaining = (int)(this.processTimeRemaining + tickDiff);
/* 284 */         if (this.processTimeRemaining < 0)
/*     */         {
/*     */           
/* 287 */           this.processTimeRemaining = 0;
/*     */         }
/*     */         
/* 290 */         ChunkData cd = TFC_Core.getCDM(this.field_145850_b).getData(this.field_145851_c >> 4, this.field_145849_e >> 4);
/*     */         
/* 292 */         if (TFCOptions.enableOverworkingChunks && cd.sluicedAmount > TFCOptions.sluiceLimit) {
/*     */           
/* 294 */           this.processTimeRemaining = 0;
/* 295 */           this.soilAmount = -1;
/*     */           
/*     */           return;
/*     */         } 
/* 299 */         while (this.processTimeRemaining > 100 && this.soilAmount > 0) {
/*     */           
/* 301 */           float gemMod = 1.0F;
/* 302 */           float oreMod = 1.0F;
/* 303 */           if (this.soilType == 1) {
/* 304 */             gemMod = 0.65F;
/* 305 */           } else if (this.soilType == 2) {
/* 306 */             oreMod = 0.6F;
/*     */           } 
/* 308 */           ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/* 309 */           if (this.random.nextInt((int)(200.0F * oreMod)) == 0 && !this.coreSampleStacks.isEmpty()) {
/* 310 */             addToInventory(((ItemStack)this.coreSampleStacks.get(this.random.nextInt(this.coreSampleStacks.size()))).func_77946_l());
/* 311 */           } else if (this.random.nextInt((int)(400.0F * gemMod)) == 0) {
/*     */             
/* 313 */             items.add(new ItemStack(TFCItems.gemAgate, 1, 0));
/* 314 */             items.add(new ItemStack(TFCItems.gemAmethyst, 1, 0));
/* 315 */             items.add(new ItemStack(TFCItems.gemBeryl, 1, 0));
/* 316 */             items.add(new ItemStack(TFCItems.gemEmerald, 1, 0));
/* 317 */             items.add(new ItemStack(TFCItems.gemGarnet, 1, 0));
/* 318 */             items.add(new ItemStack(TFCItems.gemJade, 1, 0));
/* 319 */             items.add(new ItemStack(TFCItems.gemJasper, 1, 0));
/* 320 */             items.add(new ItemStack(TFCItems.gemOpal, 1, 0));
/* 321 */             items.add(new ItemStack(TFCItems.gemRuby, 1, 0));
/* 322 */             items.add(new ItemStack(TFCItems.gemSapphire, 1, 0));
/* 323 */             items.add(new ItemStack(TFCItems.gemTourmaline, 1, 0));
/* 324 */             items.add(new ItemStack(TFCItems.gemTopaz, 1, 0));
/* 325 */             addToInventory((ItemStack)items.toArray()[this.random.nextInt((items.toArray()).length)]);
/*     */           }
/* 327 */           else if (this.random.nextInt((int)(800.0F * gemMod)) == 0) {
/*     */             
/* 329 */             items.add(new ItemStack(TFCItems.gemAgate, 1, 1));
/* 330 */             items.add(new ItemStack(TFCItems.gemAmethyst, 1, 1));
/* 331 */             items.add(new ItemStack(TFCItems.gemBeryl, 1, 1));
/* 332 */             items.add(new ItemStack(TFCItems.gemEmerald, 1, 1));
/* 333 */             items.add(new ItemStack(TFCItems.gemGarnet, 1, 1));
/* 334 */             items.add(new ItemStack(TFCItems.gemJade, 1, 1));
/* 335 */             items.add(new ItemStack(TFCItems.gemJasper, 1, 1));
/* 336 */             items.add(new ItemStack(TFCItems.gemOpal, 1, 1));
/* 337 */             items.add(new ItemStack(TFCItems.gemRuby, 1, 1));
/* 338 */             items.add(new ItemStack(TFCItems.gemSapphire, 1, 1));
/* 339 */             items.add(new ItemStack(TFCItems.gemTourmaline, 1, 1));
/* 340 */             items.add(new ItemStack(TFCItems.gemTopaz, 1, 1));
/* 341 */             addToInventory((ItemStack)items.toArray()[this.random.nextInt((items.toArray()).length)]);
/*     */           }
/* 343 */           else if (this.random.nextInt((int)(1600.0F * gemMod)) == 0) {
/*     */             
/* 345 */             items.add(new ItemStack(TFCItems.gemAgate, 1, 2));
/* 346 */             items.add(new ItemStack(TFCItems.gemAmethyst, 1, 2));
/* 347 */             items.add(new ItemStack(TFCItems.gemBeryl, 1, 2));
/* 348 */             items.add(new ItemStack(TFCItems.gemEmerald, 1, 2));
/* 349 */             items.add(new ItemStack(TFCItems.gemGarnet, 1, 2));
/* 350 */             items.add(new ItemStack(TFCItems.gemJade, 1, 2));
/* 351 */             items.add(new ItemStack(TFCItems.gemJasper, 1, 2));
/* 352 */             items.add(new ItemStack(TFCItems.gemOpal, 1, 2));
/* 353 */             items.add(new ItemStack(TFCItems.gemRuby, 1, 2));
/* 354 */             items.add(new ItemStack(TFCItems.gemSapphire, 1, 2));
/* 355 */             items.add(new ItemStack(TFCItems.gemTourmaline, 1, 2));
/* 356 */             items.add(new ItemStack(TFCItems.gemTopaz, 1, 2));
/* 357 */             addToInventory((ItemStack)items.toArray()[this.random.nextInt((items.toArray()).length)]);
/*     */           }
/* 359 */           else if (this.random.nextInt((int)(3200.0F * gemMod)) == 0) {
/*     */             
/* 361 */             items.add(new ItemStack(TFCItems.gemAgate, 1, 3));
/* 362 */             items.add(new ItemStack(TFCItems.gemAmethyst, 1, 3));
/* 363 */             items.add(new ItemStack(TFCItems.gemBeryl, 1, 3));
/* 364 */             items.add(new ItemStack(TFCItems.gemEmerald, 1, 3));
/* 365 */             items.add(new ItemStack(TFCItems.gemGarnet, 1, 3));
/* 366 */             items.add(new ItemStack(TFCItems.gemJade, 1, 3));
/* 367 */             items.add(new ItemStack(TFCItems.gemJasper, 1, 3));
/* 368 */             items.add(new ItemStack(TFCItems.gemOpal, 1, 3));
/* 369 */             items.add(new ItemStack(TFCItems.gemRuby, 1, 3));
/* 370 */             items.add(new ItemStack(TFCItems.gemSapphire, 1, 3));
/* 371 */             items.add(new ItemStack(TFCItems.gemTourmaline, 1, 3));
/* 372 */             items.add(new ItemStack(TFCItems.gemTopaz, 1, 3));
/* 373 */             addToInventory((ItemStack)items.toArray()[this.random.nextInt((items.toArray()).length)]);
/*     */           }
/* 375 */           else if (this.random.nextInt((int)(6400.0F * gemMod)) == 0) {
/*     */             
/* 377 */             items.add(new ItemStack(TFCItems.gemAgate, 1, 4));
/* 378 */             items.add(new ItemStack(TFCItems.gemAmethyst, 1, 4));
/* 379 */             items.add(new ItemStack(TFCItems.gemBeryl, 1, 4));
/* 380 */             items.add(new ItemStack(TFCItems.gemEmerald, 1, 4));
/* 381 */             items.add(new ItemStack(TFCItems.gemGarnet, 1, 4));
/* 382 */             items.add(new ItemStack(TFCItems.gemJade, 1, 4));
/* 383 */             items.add(new ItemStack(TFCItems.gemJasper, 1, 4));
/* 384 */             items.add(new ItemStack(TFCItems.gemOpal, 1, 4));
/* 385 */             items.add(new ItemStack(TFCItems.gemRuby, 1, 4));
/* 386 */             items.add(new ItemStack(TFCItems.gemSapphire, 1, 4));
/* 387 */             items.add(new ItemStack(TFCItems.gemTourmaline, 1, 4));
/* 388 */             items.add(new ItemStack(TFCItems.gemTopaz, 1, 4));
/* 389 */             addToInventory((ItemStack)items.toArray()[this.random.nextInt((items.toArray()).length)]);
/*     */           }
/* 391 */           else if (this.random.nextInt((int)(12800.0F * gemMod)) == 0) {
/*     */             
/* 393 */             int r = this.random.nextInt(50);
/* 394 */             if (r == 0) {
/* 395 */               addToInventory(new ItemStack(TFCItems.gemDiamond, 1, 3));
/* 396 */             } else if (r < 15) {
/* 397 */               addToInventory(new ItemStack(TFCItems.gemDiamond, 1, 2));
/* 398 */             } else if (r < 25) {
/* 399 */               addToInventory(new ItemStack(TFCItems.gemDiamond, 1, 1));
/* 400 */             } else if (r < 50) {
/* 401 */               addToInventory(new ItemStack(TFCItems.gemDiamond, 1, 0));
/*     */             } 
/* 403 */           }  cd.sluicedAmount++;
/* 404 */           this.processTimeRemaining -= 100;
/* 405 */           this.soilAmount--;
/*     */         } 
/*     */       } 
/* 408 */       if (this.soilAmount == 0) {
/* 409 */         this.processTimeRemaining = 0;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 415 */     if ((meta & 0x3) == 0) {
/*     */       
/* 417 */       this.waterInput = TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1));
/* 418 */       this
/* 419 */         .waterOutput = (TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e + 2)) || TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e + 2)));
/*     */     } 
/* 421 */     if ((meta & 0x3) == 1) {
/*     */       
/* 423 */       this.waterInput = TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e));
/* 424 */       this
/* 425 */         .waterOutput = (TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c - 2, this.field_145848_d - 1, this.field_145849_e)) || TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c - 2, this.field_145848_d - 1, this.field_145849_e)));
/*     */     } 
/* 427 */     if ((meta & 0x3) == 2) {
/*     */       
/* 429 */       this.waterInput = TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1));
/* 430 */       this
/* 431 */         .waterOutput = (TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e - 2)) || TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e - 2)));
/*     */     } 
/* 433 */     if ((meta & 0x3) == 3) {
/*     */       
/* 435 */       this.waterInput = TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e));
/* 436 */       this
/* 437 */         .waterOutput = (TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c + 2, this.field_145848_d - 1, this.field_145849_e)) || TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c + 2, this.field_145848_d - 1, this.field_145849_e)));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 443 */     boolean isFlowing = ((meta & 0x4) == 4);
/* 444 */     ForgeDirection dir = getDir(meta & 0x3);
/* 445 */     Block water = this.field_145850_b.func_147439_a(this.field_145851_c + dir.offsetX, this.field_145848_d + 1, this.field_145849_e + dir.offsetZ);
/* 446 */     boolean isInputWater = TFC_Core.isWater(water);
/* 447 */     boolean isOutputAir = this.field_145850_b.func_147437_c(this.field_145851_c + (dir.getOpposite()).offsetX * 2, this.field_145848_d - 1, this.field_145849_e + (dir.getOpposite()).offsetZ * 2);
/* 448 */     boolean isOutputWater = TFC_Core.isWater(this.field_145850_b.func_147439_a(this.field_145851_c + (dir.getOpposite()).offsetX * 2, this.field_145848_d - 1, this.field_145849_e + (dir.getOpposite()).offsetZ * 2));
/* 449 */     boolean isWaterDepth7 = (this.field_145850_b.func_72805_g(this.field_145851_c + dir.offsetX, this.field_145848_d + 1, this.field_145849_e + dir.offsetZ) == 7);
/* 450 */     int meta2 = this.field_145850_b.func_72805_g(this.field_145851_c + (dir.getOpposite()).offsetX, this.field_145848_d, this.field_145849_e + (dir.getOpposite()).offsetZ);
/* 451 */     if (isInputWater && isWaterDepth7 && !isFlowing && (isOutputAir || isOutputWater)) {
/*     */ 
/*     */       
/* 454 */       this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta + 4, 3);
/*     */       
/* 456 */       if ((this.field_145850_b.func_72805_g(this.field_145851_c + (dir.getOpposite()).offsetX, this.field_145848_d, this.field_145849_e + (dir.getOpposite()).offsetZ) & 0x4) == 0)
/*     */       {
/*     */         
/* 459 */         this.field_145850_b.func_72921_c(this.field_145851_c + (dir.getOpposite()).offsetX, this.field_145848_d, this.field_145849_e + (dir.getOpposite()).offsetZ, meta2 + 4, 3);
/*     */       }
/*     */ 
/*     */       
/* 463 */       this.field_145850_b.func_147449_b(this.field_145851_c + (dir.getOpposite()).offsetX * 2, this.field_145848_d - 1, this.field_145849_e + (dir.getOpposite()).offsetZ * 2, water);
/*     */     } 
/* 465 */     if ((!isInputWater || !isWaterDepth7 || (!isOutputAir && !isOutputWater)) && isFlowing) {
/*     */ 
/*     */       
/* 468 */       this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta - 4, 3);
/* 469 */       if ((meta2 & 0x4) != 0)
/*     */       {
/*     */         
/* 472 */         this.field_145850_b.func_72921_c(this.field_145851_c + (dir.getOpposite()).offsetX, this.field_145848_d, this.field_145849_e + (dir.getOpposite()).offsetZ, meta2 - 4, 3);
/*     */       }
/*     */       
/* 475 */       if (!isOutputAir && isOutputWater) {
/* 476 */         this.field_145850_b.func_147468_f(this.field_145851_c + (dir.getOpposite()).offsetX * 2, this.field_145848_d - 1, this.field_145849_e + (dir.getOpposite()).offsetZ * 2);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private ForgeDirection getDir(int r) {
/* 482 */     if (r == 0)
/*     */     {
/* 484 */       return ForgeDirection.NORTH;
/*     */     }
/* 486 */     if (r == 1)
/*     */     {
/* 488 */       return ForgeDirection.EAST;
/*     */     }
/* 490 */     if (r == 2)
/*     */     {
/* 492 */       return ForgeDirection.SOUTH;
/*     */     }
/* 494 */     if (r == 3)
/*     */     {
/* 496 */       return ForgeDirection.WEST;
/*     */     }
/*     */     
/* 499 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 505 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 511 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 517 */     super.func_145839_a(nbttagcompound);
/* 518 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 519 */     this.sluiceItemStacks = new ItemStack[func_70302_i_()];
/* 520 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 522 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 523 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 524 */       if (byte0 >= 0 && byte0 < this.sluiceItemStacks.length)
/* 525 */         this.sluiceItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/* 527 */     this.soilType = nbttagcompound.func_74771_c("soilType");
/* 528 */     this.soilAmount = nbttagcompound.func_74762_e("soilAmount");
/* 529 */     this.processTimeRemaining = nbttagcompound.func_74762_e("processTimeRemaining");
/* 530 */     this.lastUpdateTicks = nbttagcompound.func_74763_f("lastUpdateTicks");
/* 531 */     this.waterInput = nbttagcompound.func_74767_n("waterInput");
/* 532 */     this.waterOutput = nbttagcompound.func_74767_n("waterOutput");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 538 */     super.func_145841_b(nbttagcompound);
/* 539 */     nbttagcompound.func_74774_a("soilType", this.soilType);
/* 540 */     nbttagcompound.func_74768_a("soilAmount", this.soilAmount);
/* 541 */     nbttagcompound.func_74768_a("processTimeRemaining", this.processTimeRemaining);
/* 542 */     nbttagcompound.func_74772_a("lastUpdateTicks", this.lastUpdateTicks);
/* 543 */     nbttagcompound.func_74757_a("waterInput", this.waterInput);
/* 544 */     nbttagcompound.func_74757_a("waterOutput", this.waterOutput);
/* 545 */     NBTTagList nbttaglist = new NBTTagList();
/* 546 */     for (int i = 0; i < this.sluiceItemStacks.length; i++) {
/*     */       
/* 548 */       if (this.sluiceItemStacks[i] != null) {
/*     */         
/* 550 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 551 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 552 */         this.sluiceItemStacks[i].func_77955_b(nbttagcompound1);
/* 553 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 556 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 562 */     NBTTagCompound nbt = new NBTTagCompound();
/* 563 */     func_145841_b(nbt);
/* 564 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 570 */     func_145839_a(pkt.func_148857_g());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TESluice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */