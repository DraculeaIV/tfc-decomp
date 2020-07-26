/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockBlastFurnace;
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.GUI.GuiBlastFurnace;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.ArrayBlockingQueue;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.gui.GuiScreen;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEBlastFurnace
/*     */   extends TEFireEntity
/*     */   implements IInventory
/*     */ {
/*     */   public boolean isValid = false;
/*  72 */   public ItemStack[] fireItemStacks = new ItemStack[20];
/*  73 */   public ItemStack[] outputItemStacks = new ItemStack[20];
/*  74 */   public ItemStack[] storage = new ItemStack[2];
/*     */ 
/*     */   
/*  77 */   public int charcoalCount = 0;
/*  78 */   public int oreCount = 0;
/*     */   public static final int ORE_SLOT1 = 0;
/*     */   public String oreType;
/*     */   public int slowCounter;
/*     */   
/*     */   public boolean canLight() {
/*  84 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/*  86 */       if (this.charcoalCount < this.oreCount) {
/*  87 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  91 */       int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  92 */       if (this.charcoalCount >= 4 && this.fireTemp == 0.0F) {
/*     */         
/*  94 */         this.fireTemp = 1.0F;
/*  95 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta + 4, 2);
/*  96 */         return true;
/*     */       } 
/*     */     } 
/*  99 */     return false;
/*     */   }
/*     */   private int outMetal1Count; private int cookDelay; private int maxValidStackSize; private int moltenCount;
/*     */   
/*     */   private Boolean checkValidity() {
/* 104 */     int y = this.field_145848_d + 1;
/* 105 */     if (isStackValid(this.field_145851_c, y, this.field_145849_e))
/* 106 */       return Boolean.valueOf(true); 
/* 107 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void cookItem(int i) {
/* 117 */     ItemStack cookingItemStack = this.fireItemStacks[i];
/*     */     
/* 119 */     TECrucible crucibleTE = (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) instanceof TECrucible) ? (TECrucible)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     if (cookingItemStack != null && crucibleTE != null && crucibleTE.getTotalMetal() < 3000.0F && this.storage[1] != null && this.cookDelay == 0) {
/*     */ 
/*     */       
/* 128 */       Random r = new Random();
/* 129 */       HeatRegistry manager = HeatRegistry.getInstance();
/* 130 */       HeatIndex index = manager.findMatchingIndex(cookingItemStack);
/*     */       
/* 132 */       if (index != null && TFC_ItemHeat.getTemp(cookingItemStack) >= index.meltTemp) {
/*     */         
/* 134 */         int output = 0;
/* 135 */         Item cookingItem = cookingItemStack.func_77973_b();
/*     */         
/* 137 */         if (cookingItem instanceof ISmeltable) {
/*     */           
/* 139 */           output = ((ISmeltable)cookingItem).getMetalReturnAmount(cookingItemStack);
/*     */           
/* 141 */           if (!crucibleTE.addMetal(((ISmeltable)cookingItem).getMetalType(cookingItemStack), output)) {
/*     */             return;
/*     */           }
/*     */         } else {
/*     */           
/* 146 */           Metal m = MetalRegistry.instance.getMetalFromItem(cookingItem);
/* 147 */           output = index.getOutput(cookingItemStack, r).func_77960_j();
/* 148 */           if (m != null)
/*     */           {
/*     */             
/* 151 */             if (!crucibleTE.addMetal(m, (short)(100 - output))) {
/*     */               return;
/*     */             }
/*     */           }
/*     */         } 
/* 156 */         this.oreCount--;
/* 157 */         this.charcoalCount--;
/* 158 */         this.cookDelay = 100;
/* 159 */         this.fireItemStacks[i] = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 165 */         Queue<ItemStack> buffer = new ArrayBlockingQueue<ItemStack>(this.fireItemStacks.length);
/* 166 */         for (ItemStack is : this.fireItemStacks) {
/*     */           
/* 168 */           if (is != null)
/*     */           {
/* 170 */             buffer.offer(is);
/*     */           }
/*     */         } 
/*     */         
/* 174 */         this.fireItemStacks = (ItemStack[])buffer.toArray((Object[])new ItemStack[this.fireItemStacks.length]);
/*     */ 
/*     */         
/* 177 */         this.storage[1].func_77964_b(this.storage[1].func_77960_j() + 1);
/* 178 */         if (this.storage[1] != null && this.storage[1].func_77960_j() == this.storage[1].func_77958_k())
/*     */         {
/* 180 */           func_70299_a(1, (ItemStack)null);
/*     */         }
/*     */ 
/*     */         
/* 184 */         crucibleTE.temperature = (int)this.fireTemp;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 192 */     if (this.storage[i] != null) {
/*     */       
/* 194 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 196 */         ItemStack itemstack = this.storage[i];
/* 197 */         this.storage[i] = null;
/* 198 */         return itemstack;
/*     */       } 
/* 200 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/* 201 */       if ((this.storage[i]).field_77994_a == 0)
/*     */       {
/* 203 */         this.storage[i] = null;
/*     */       }
/* 205 */       return itemstack1;
/*     */     } 
/*     */ 
/*     */     
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 215 */     float f3 = 0.05F;
/*     */     
/* 217 */     Random rand = new Random();
/* 218 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 219 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 220 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 222 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 224 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 226 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.fireItemStacks[i]);
/* 227 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 228 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 229 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 230 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 235 */     if (this.charcoalCount > 0) {
/*     */       
/* 237 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), new ItemStack(TFCItems.coal, this.charcoalCount, 1));
/* 238 */       entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 239 */       entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 240 */       entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 241 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 249 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 255 */     return "BlastFurnace";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 261 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 267 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 273 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleTemperature() {
/* 278 */     int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (this.fuelTimeLeft > 0) {
/*     */       
/* 284 */       float desiredTemp = handleTemp();
/* 285 */       handleTempFlux(desiredTemp);
/*     */     }
/* 287 */     else if (this.fuelTimeLeft <= 0 && this.charcoalCount > 0 && (meta & 0x4) > 0) {
/*     */       
/* 289 */       this.charcoalCount--;
/*     */       
/* 291 */       this.fuelTimeLeft = 1875;
/* 292 */       this.fuelBurnTemp = 1400;
/*     */     }
/*     */     else {
/*     */       
/* 296 */       if ((meta & 0x4) > 0) {
/* 297 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta & 0x3, 3);
/*     */       }
/* 299 */       this.fuelBurnTemp = 0;
/* 300 */       float desiredTemp = handleTemp();
/* 301 */       handleTempFlux(desiredTemp);
/*     */     } 
/*     */ 
/*     */     
/* 305 */     handleAirReduction();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveAirFromBellows() {
/* 311 */     if (this.storage[1] != null) {
/* 312 */       super.receiveAirFromBellows();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isStackValid(int i, int j, int k) {
/* 317 */     Block yNegBlock = this.field_145850_b.func_147439_a(i, j - 1, k);
/* 318 */     if (yNegBlock != TFCBlocks.molten && this.field_145850_b
/* 319 */       .func_147439_a(i, j - 1, k).func_149688_o() != Material.field_151576_e && 
/* 320 */       !this.field_145850_b.func_147439_a(i, j - 1, k).func_149721_r() && yNegBlock != TFCBlocks.blastFurnace && 
/* 321 */       TFC_Core.isTopFaceSolid(this.field_145850_b, i, j - 1, k))
/*     */     {
/* 323 */       return false;
/*     */     }
/*     */     
/* 326 */     this.maxValidStackSize = 0;
/* 327 */     for (int num = 0; num < 5; num++) {
/*     */       
/* 329 */       if (!((BlockBlastFurnace)TFCBlocks.blastFurnace).checkStackAt(this.field_145850_b, i, j + num, k))
/*     */         break; 
/* 331 */       this.maxValidStackSize++;
/*     */     } 
/* 333 */     return (this.maxValidStackSize != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 339 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addOreToFire(ItemStack is) {
/* 349 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 351 */       if (this.fireItemStacks[i] == null) {
/*     */         
/* 353 */         this.fireItemStacks[i] = is;
/* 354 */         return true;
/*     */       } 
/*     */     } 
/* 357 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 363 */     this.storage[i] = itemstack;
/* 364 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 365 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createTuyereBlock() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalCount() {
/* 421 */     return this.charcoalCount + this.oreCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 429 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 431 */       createTuyereBlock();
/*     */       
/* 433 */       if (this.oreCount < 0)
/* 434 */         this.oreCount = 0; 
/* 435 */       if (this.charcoalCount < 0) {
/* 436 */         this.charcoalCount = 0;
/*     */       }
/*     */       
/* 439 */       List list = this.field_145850_b.func_72872_a(EntityItem.class, 
/* 440 */           AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + this.moltenCount) + 1.1D, (this.field_145849_e + 1)));
/*     */ 
/*     */       
/* 443 */       List playerList = this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + this.moltenCount) + 1.1D, (this.field_145849_e + 1)));
/*     */       
/* 445 */       if (this.moltenCount == 0) {
/* 446 */         this.moltenCount = 1;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 451 */       if (list != null && !list.isEmpty() && ((BlockBlastFurnace)TFCBlocks.blastFurnace).checkStackAt(this.field_145850_b, this.field_145851_c, this.field_145848_d + this.moltenCount, this.field_145849_e) && (playerList == null || playerList.isEmpty()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 457 */         for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */           
/* 459 */           EntityItem entity = iterator.next();
/* 460 */           ItemStack itemstack = entity.func_92059_d();
/* 461 */           Item item = itemstack.func_77973_b();
/* 462 */           boolean isOre = TFC_Core.isOreIron(itemstack);
/* 463 */           HeatRegistry manager = HeatRegistry.getInstance();
/* 464 */           HeatIndex index = manager.findMatchingIndex(itemstack);
/*     */           
/* 466 */           if (item == TFCItems.coal && itemstack
/* 467 */             .func_77960_j() == 1) {
/*     */ 
/*     */             
/* 470 */             for (int c = 0; c < itemstack.field_77994_a; c++) {
/*     */               
/* 472 */               if (getTotalCount() < 40 && this.charcoalCount < this.maxValidStackSize * 4) {
/*     */                 
/* 474 */                 this.charcoalCount++;
/* 475 */                 itemstack.field_77994_a--;
/*     */               } 
/*     */             } 
/*     */             
/* 479 */             if (itemstack.field_77994_a == 0) {
/* 480 */               entity.func_70106_y();
/*     */             }
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 487 */           if ((TFC_ItemHeat.isCookable(itemstack) != -1.0F && isOre) || (!isOre && item instanceof ISmeltable && ((ISmeltable)item)
/* 488 */             .getMetalType(itemstack) == Global.PIGIRON && index != null)) {
/*     */ 
/*     */             
/* 491 */             int c = itemstack.field_77994_a;
/* 492 */             int nonConsumedOre = 0;
/* 493 */             for (; c > 0; c--) {
/*     */               
/* 495 */               if (getTotalCount() < 40 && this.oreCount < this.maxValidStackSize * 4) {
/*     */                 
/* 497 */                 if (foundFlux(this.moltenCount) && addOreToFire(new ItemStack(item, 1, itemstack.func_77960_j()))) {
/* 498 */                   this.oreCount++;
/*     */                 } else {
/* 500 */                   nonConsumedOre++;
/*     */                 } 
/*     */               } else {
/*     */                 
/* 504 */                 nonConsumedOre++;
/*     */               } 
/*     */             } 
/*     */             
/* 508 */             if (c + nonConsumedOre == 0) {
/* 509 */               entity.func_70106_y();
/*     */               continue;
/*     */             } 
/* 512 */             itemstack.field_77994_a = c + nonConsumedOre;
/* 513 */             entity.func_92058_a(itemstack);
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 520 */       handleTemperature();
/*     */       
/* 522 */       if (this.cookDelay > 0) {
/* 523 */         this.cookDelay--;
/*     */       }
/* 525 */       for (int i = 0; i < this.fireItemStacks.length && this.isValid; i++) {
/*     */ 
/*     */         
/* 528 */         careForInventorySlot(this.fireItemStacks[i]);
/*     */         
/* 530 */         if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) == TFCBlocks.crucible)
/*     */         {
/* 532 */           cookItem(i);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 538 */       if (this.slowCounter > 100) {
/*     */ 
/*     */         
/* 541 */         this.isValid = checkValidity().booleanValue();
/* 542 */         this.moltenCount = updateMoltenBlocks();
/*     */       } 
/* 544 */       this.slowCounter++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int updateMoltenBlocks() {
/* 553 */     int count = this.charcoalCount + this.oreCount;
/*     */     
/* 555 */     int moltenCount = 0;
/* 556 */     if (count > 0 && count <= 8) { moltenCount = 1; }
/* 557 */     else if (count > 8 && count <= 16) { moltenCount = 2; }
/* 558 */     else if (count > 16 && count <= 24) { moltenCount = 3; }
/* 559 */     else if (count > 24 && count <= 32) { moltenCount = 4; }
/* 560 */     else if (count > 32 && count <= 40) { moltenCount = 5; }
/*     */ 
/*     */     
/* 563 */     for (int i = 1; i <= 5; i++) {
/*     */ 
/*     */       
/* 566 */       if (this.field_145850_b.func_147437_c(this.field_145851_c, this.field_145848_d + i, this.field_145849_e) || this.field_145850_b
/* 567 */         .func_147439_a(this.field_145851_c, this.field_145848_d + i, this.field_145849_e) == TFCBlocks.molten)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 574 */         if (i <= moltenCount && i <= this.maxValidStackSize) {
/*     */           
/* 576 */           if (this.fireTemp > 100.0F)
/*     */           {
/* 578 */             int m = (count > 7) ? 7 : count;
/* 579 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d + i, this.field_145849_e, TFCBlocks.molten, m + 8, 2);
/* 580 */             count -= 8;
/*     */           }
/*     */           else
/*     */           {
/* 584 */             int m = (count > 7) ? 7 : count;
/* 585 */             this.field_145850_b.func_147465_d(this.field_145851_c, this.field_145848_d + i, this.field_145849_e, TFCBlocks.molten, m, 2);
/* 586 */             count -= 8;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 591 */           this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + i, this.field_145849_e);
/*     */         } 
/*     */       }
/*     */     } 
/* 595 */     return moltenCount;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean foundFlux(int moltenCount) {
/* 600 */     List list = this.field_145850_b.func_72872_a(EntityItem.class, 
/* 601 */         AxisAlignedBB.func_72330_a(this.field_145851_c, (this.field_145848_d + moltenCount), this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + moltenCount) + 1.1D, (this.field_145849_e + 1)));
/* 602 */     boolean found = false;
/* 603 */     for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext() && !found; ) {
/*     */       
/* 605 */       EntityItem entity = iterator.next();
/* 606 */       ItemStack is = entity.func_92059_d();
/* 607 */       if (!entity.field_70128_L && is.func_77960_j() == 0 && is.func_77973_b() == TFCItems.powder) {
/*     */         
/* 609 */         is.field_77994_a--;
/* 610 */         if (is.field_77994_a == 0) {
/* 611 */           entity.func_70106_y();
/*     */         } else {
/* 613 */           entity.func_92058_a(is);
/* 614 */         }  found = true;
/*     */       } 
/*     */     } 
/* 617 */     return found;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOreCountScaled(int l) {
/* 622 */     return this.oreCount * l / 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCharcoalCountScaled(int l) {
/* 627 */     return this.charcoalCount * l / 20;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 633 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 639 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 645 */     super.func_145841_b(nbt);
/* 646 */     nbt.func_74768_a("charcoalCount", this.charcoalCount);
/* 647 */     nbt.func_74768_a("outMetal1Count", this.outMetal1Count);
/* 648 */     nbt.func_74774_a("oreCount", (byte)this.oreCount);
/* 649 */     nbt.func_74768_a("maxValidStackSize", this.maxValidStackSize);
/*     */ 
/*     */     
/* 652 */     NBTTagList nbttaglist = new NBTTagList();
/* 653 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 655 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 657 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 658 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 659 */         this.fireItemStacks[i].func_77955_b(nbttagcompound1);
/* 660 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 663 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     
/* 665 */     NBTTagList nbttaglist2 = new NBTTagList();
/* 666 */     for (int j = 0; j < this.storage.length; j++) {
/*     */       
/* 668 */       if (this.storage[j] != null) {
/*     */         
/* 670 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 671 */         nbttagcompound1.func_74774_a("Slot", (byte)j);
/* 672 */         this.storage[j].func_77955_b(nbttagcompound1);
/* 673 */         nbttaglist2.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 676 */     nbt.func_74782_a("Input", (NBTBase)nbttaglist2);
/*     */     
/* 678 */     NBTTagList nbttaglist3 = new NBTTagList();
/* 679 */     for (int k = 0; k < this.outputItemStacks.length; k++) {
/*     */       
/* 681 */       if (this.outputItemStacks[k] != null) {
/*     */         
/* 683 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 684 */         nbttagcompound1.func_74774_a("Slot", (byte)k);
/* 685 */         this.outputItemStacks[k].func_77955_b(nbttagcompound1);
/* 686 */         nbttaglist3.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 689 */     nbt.func_74782_a("Output", (NBTBase)nbttaglist3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 695 */     super.func_145839_a(nbt);
/* 696 */     this.charcoalCount = nbt.func_74762_e("charcoalCount");
/* 697 */     this.outMetal1Count = nbt.func_74762_e("outMetal1Count");
/* 698 */     this.oreCount = nbt.func_74771_c("oreCount");
/* 699 */     this.maxValidStackSize = nbt.func_74762_e("maxValidStackSize");
/*     */     
/* 701 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 702 */     this.fireItemStacks = new ItemStack[20];
/* 703 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 705 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 706 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 707 */       if (byte0 >= 0 && byte0 < this.fireItemStacks.length) {
/* 708 */         this.fireItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/* 711 */     NBTTagList nbttaglist2 = nbt.func_150295_c("Input", 10);
/* 712 */     this.storage = new ItemStack[2];
/* 713 */     for (int j = 0; j < nbttaglist2.func_74745_c(); j++) {
/*     */       
/* 715 */       NBTTagCompound nbttagcompound1 = nbttaglist2.func_150305_b(j);
/* 716 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 717 */       if (byte0 >= 0 && byte0 < this.storage.length)
/*     */       {
/* 719 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */     
/* 723 */     NBTTagList nbttaglist3 = nbt.func_150295_c("Output", 10);
/* 724 */     this.outputItemStacks = new ItemStack[20];
/* 725 */     for (int k = 0; k < nbttaglist3.func_74745_c(); k++) {
/*     */       
/* 727 */       NBTTagCompound nbttagcompound1 = nbttaglist3.func_150305_b(k);
/* 728 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 729 */       if (byte0 >= 0 && byte0 < this.outputItemStacks.length) {
/* 730 */         this.outputItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/* 737 */     NBTTagCompound nbt = new NBTTagCompound();
/* 738 */     func_145841_b(nbt);
/* 739 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 745 */     func_145839_a(pkt.func_148857_g());
/*     */     
/* 747 */     GuiScreen gui = (FMLClientHandler.instance().getClient()).field_71462_r;
/* 748 */     if (gui instanceof GuiBlastFurnace) {
/* 749 */       ((GuiBlastFurnace)gui).func_73876_c();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateGui() {
/* 754 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */