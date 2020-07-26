/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Enums.EnumFuelMaterial;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEForge
/*     */   extends TEFireEntity
/*     */   implements IInventory
/*     */ {
/*     */   public boolean isSmokeStackValid = false;
/*  33 */   public ItemStack[] fireItemStacks = new ItemStack[14];
/*     */   
/*     */   private int smokeTimer;
/*     */ 
/*     */   
/*     */   private boolean validateSmokeStack() {
/*  39 */     if (!TFC_Core.isExposedToRain(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e))
/*  40 */       return true; 
/*  41 */     if (checkChimney(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e))
/*  42 */       return true; 
/*  43 */     if (checkChimney(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e))
/*  44 */       return true; 
/*  45 */     if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1))
/*  46 */       return true; 
/*  47 */     if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1))
/*  48 */       return true; 
/*  49 */     if (notOpaque(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e))
/*  50 */       return true; 
/*  51 */     if (notOpaque(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e))
/*  52 */       return true; 
/*  53 */     if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/*  54 */       return true;
/*     */     }
/*  56 */     return (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkChimney(int x, int y, int z) {
/*  61 */     return (notOpaque(x, y, z) && this.field_145850_b.func_72937_j(x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean notOpaque(int x, int y, int z) {
/*  66 */     return (this.field_145850_b.func_72899_e(x, y, z) && !this.field_145850_b.func_147439_a(x, y, z).func_149662_c());
/*     */   }
/*     */ 
/*     */   
/*     */   private void genSmokeRoot(int x, int y, int z) {
/*  71 */     if (this.fuelTimeLeft >= 0) {
/*     */       
/*  73 */       if (this.field_145850_b.func_147439_a(x, y, z) != TFCBlocks.smoke) {
/*  74 */         this.field_145850_b.func_147449_b(x, y, z, TFCBlocks.smoke);
/*     */       }
/*     */     } else {
/*     */       
/*  78 */       this.field_145850_b.func_147468_f(x, y, z);
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
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void combineMetals(ItemStack inputItem, ItemStack destItem) {
/*  98 */     int d1 = 100 - inputItem.func_77960_j();
/*  99 */     int d2 = 100 - destItem.func_77960_j();
/* 100 */     destItem.func_77964_b(100 - d1 + d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cookItem(int i) {
/* 105 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 106 */     Random r = new Random();
/* 107 */     if (this.fireItemStacks[i] != null) {
/*     */       
/* 109 */       HeatIndex index = manager.findMatchingIndex(this.fireItemStacks[i]);
/* 110 */       ItemStack inputCopy = this.fireItemStacks[i].func_77946_l();
/*     */       
/* 112 */       if (index != null && TFC_ItemHeat.getTemp(this.fireItemStacks[i]) > index.meltTemp) {
/*     */         
/* 114 */         float temperature = TFC_ItemHeat.getTemp(this.fireItemStacks[i]);
/*     */ 
/*     */ 
/*     */         
/* 118 */         if (!(this.fireItemStacks[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal)) {
/* 119 */           this.fireItemStacks[i] = index.getMorph();
/*     */         }
/*     */         
/* 122 */         if (this.fireItemStacks[i] != null) {
/*     */           
/* 124 */           HeatIndex morphIndex = manager.findMatchingIndex(this.fireItemStacks[i]);
/* 125 */           if (morphIndex != null)
/*     */           {
/*     */             
/* 128 */             TFC_ItemHeat.setTemp(this.fireItemStacks[i], temperature);
/*     */           }
/*     */         }
/* 131 */         else if (index.hasOutput()) {
/*     */           
/* 133 */           ItemStack output = index.getOutput(inputCopy, r);
/* 134 */           if (inputCopy.func_77973_b() instanceof ISmeltable) {
/*     */             
/* 136 */             ISmeltable smelt = (ISmeltable)inputCopy.func_77973_b();
/* 137 */             ItemStack meltedItem = new ItemStack((smelt.getMetalType(inputCopy)).meltedItem);
/* 138 */             TFC_ItemHeat.setTemp(meltedItem, temperature);
/*     */             
/* 140 */             int units = smelt.getMetalReturnAmount(inputCopy);
/*     */             
/* 142 */             if (inputCopy.func_77973_b() instanceof com.bioxx.tfc.Items.ItemBloom) {
/* 143 */               units = Math.min(100, units);
/*     */             }
/* 145 */             while (units > 0 && getMold() != null) {
/*     */               
/* 147 */               ItemStack moldIS = getMold();
/* 148 */               ItemStack outputCopy = meltedItem.func_77946_l();
/*     */               
/* 150 */               if (units > 100) {
/*     */                 
/* 152 */                 units -= 100;
/* 153 */                 moldIS.field_77994_a--;
/* 154 */                 if (!addToStorage(outputCopy.func_77946_l())) {
/*     */                   
/* 156 */                   EntityItem ei = new EntityItem(this.field_145850_b, this.field_145851_c + 0.5D, this.field_145848_d + 1.5D, this.field_145849_e + 0.5D, outputCopy);
/* 157 */                   ei.field_70159_w = 0.0D; ei.field_70181_x = 0.0D; ei.field_70179_y = 0.0D;
/* 158 */                   this.field_145850_b.func_72838_d((Entity)ei);
/*     */                 }  continue;
/*     */               } 
/* 161 */               if (units > 0)
/*     */               {
/* 163 */                 outputCopy.func_77964_b(100 - units);
/* 164 */                 units = 0;
/* 165 */                 moldIS.field_77994_a--;
/* 166 */                 this.fireItemStacks[i] = outputCopy.func_77946_l();
/*     */               }
/*     */             
/*     */             } 
/*     */           } else {
/*     */             
/* 172 */             this.fireItemStacks[i] = output;
/*     */           } 
/*     */ 
/*     */           
/* 176 */           if (TFC_ItemHeat.isCookable(this.fireItemStacks[i]) > -1.0F)
/*     */           {
/*     */             
/* 179 */             TFC_ItemHeat.setTemp(this.fireItemStacks[i], temperature);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addToStorage(ItemStack is) {
/* 188 */     if (func_70301_a(10) == null) {
/*     */       
/* 190 */       func_70299_a(10, is);
/* 191 */       return true;
/*     */     } 
/* 193 */     if (func_70301_a(11) == null) {
/*     */       
/* 195 */       func_70299_a(11, is);
/* 196 */       return true;
/*     */     } 
/* 198 */     if (func_70301_a(12) == null) {
/*     */       
/* 200 */       func_70299_a(12, is);
/* 201 */       return true;
/*     */     } 
/* 203 */     if (func_70301_a(13) == null) {
/*     */       
/* 205 */       func_70299_a(13, is);
/* 206 */       return true;
/*     */     } 
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack getMold() {
/* 213 */     if (this.fireItemStacks[10] != null && this.fireItemStacks[10].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[10]).field_77994_a > 0)
/*     */     {
/* 215 */       return this.fireItemStacks[10];
/*     */     }
/* 217 */     if (this.fireItemStacks[11] != null && this.fireItemStacks[11].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[11]).field_77994_a > 0)
/*     */     {
/* 219 */       return this.fireItemStacks[11];
/*     */     }
/* 221 */     if (this.fireItemStacks[12] != null && this.fireItemStacks[12].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[12]).field_77994_a > 0)
/*     */     {
/* 223 */       return this.fireItemStacks[12];
/*     */     }
/* 225 */     if (this.fireItemStacks[13] != null && this.fireItemStacks[13].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[13]).field_77994_a > 0)
/*     */     {
/* 227 */       return this.fireItemStacks[13];
/*     */     }
/* 229 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 235 */     if (this.fireItemStacks[i] != null) {
/*     */       
/* 237 */       if ((this.fireItemStacks[i]).field_77994_a <= j) {
/*     */         
/* 239 */         ItemStack is = this.fireItemStacks[i];
/* 240 */         this.fireItemStacks[i] = null;
/* 241 */         return is;
/*     */       } 
/*     */       
/* 244 */       ItemStack isSplit = this.fireItemStacks[i].func_77979_a(j);
/* 245 */       if ((this.fireItemStacks[i]).field_77994_a == 0)
/* 246 */         this.fireItemStacks[i] = null; 
/* 247 */       return isSplit;
/*     */     } 
/*     */     
/* 250 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 255 */     float f3 = 0.05F;
/*     */     
/* 257 */     Random rand = new Random();
/* 258 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 259 */     float f1 = rand.nextFloat() * 0.8F + 0.4F;
/* 260 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 262 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 264 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 266 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.fireItemStacks[i]);
/* 267 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 268 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 269 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 270 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 271 */         this.fireItemStacks[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 279 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 285 */     return "Forge";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMoldIndex() {
/* 290 */     if (this.fireItemStacks[10] != null && this.fireItemStacks[10].func_77973_b() == TFCItems.ceramicMold)
/* 291 */       return 10; 
/* 292 */     if (this.fireItemStacks[11] != null && this.fireItemStacks[11].func_77973_b() == TFCItems.ceramicMold)
/* 293 */       return 11; 
/* 294 */     if (this.fireItemStacks[12] != null && this.fireItemStacks[12].func_77973_b() == TFCItems.ceramicMold)
/* 295 */       return 12; 
/* 296 */     if (this.fireItemStacks[13] != null && this.fireItemStacks[13].func_77973_b() == TFCItems.ceramicMold)
/* 297 */       return 13; 
/* 298 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 304 */     return this.fireItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 310 */     return this.fireItemStacks[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFuelStack() {
/* 321 */     Random random = new Random();
/* 322 */     if (this.fireItemStacks[7] == null)
/*     */     {
/* 324 */       if (random.nextBoolean() && this.fireItemStacks[6] != null) {
/*     */         
/* 326 */         this.fireItemStacks[7] = this.fireItemStacks[6];
/* 327 */         this.fireItemStacks[6] = null;
/*     */       }
/*     */       else {
/*     */         
/* 331 */         this.fireItemStacks[7] = this.fireItemStacks[8];
/* 332 */         this.fireItemStacks[8] = null;
/*     */       } 
/*     */     }
/*     */     
/* 336 */     if (this.fireItemStacks[6] == null)
/*     */     {
/* 338 */       if (this.fireItemStacks[5] != null) {
/*     */         
/* 340 */         this.fireItemStacks[6] = this.fireItemStacks[5];
/* 341 */         this.fireItemStacks[5] = null;
/*     */       } 
/*     */     }
/*     */     
/* 345 */     if (this.fireItemStacks[8] == null)
/*     */     {
/* 347 */       if (this.fireItemStacks[9] != null) {
/*     */         
/* 349 */         this.fireItemStacks[8] = this.fireItemStacks[9];
/* 350 */         this.fireItemStacks[9] = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 358 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 369 */     super.func_145839_a(nbt);
/* 370 */     this.isSmokeStackValid = nbt.func_74767_n("isValid");
/*     */     
/* 372 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 373 */     this.fireItemStacks = new ItemStack[func_70302_i_()];
/* 374 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 376 */       NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
/* 377 */       byte byte0 = nbt1.func_74771_c("Slot");
/* 378 */       if (byte0 >= 0 && byte0 < this.fireItemStacks.length) {
/* 379 */         this.fireItemStacks[byte0] = ItemStack.func_77949_a(nbt1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 386 */     this.fireItemStacks[i] = itemstack;
/* 387 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 388 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 395 */     this.isSmokeStackValid = validateSmokeStack();
/*     */     
/* 397 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 400 */       careForInventorySlot(this.fireItemStacks[0]);
/* 401 */       careForInventorySlot(this.fireItemStacks[1]);
/* 402 */       careForInventorySlot(this.fireItemStacks[2]);
/* 403 */       careForInventorySlot(this.fireItemStacks[3]);
/* 404 */       careForInventorySlot(this.fireItemStacks[4]);
/*     */       
/* 406 */       ItemStack[] fuelStack = new ItemStack[9];
/* 407 */       fuelStack[0] = this.fireItemStacks[5];
/* 408 */       fuelStack[1] = this.fireItemStacks[6];
/* 409 */       fuelStack[2] = this.fireItemStacks[7];
/* 410 */       fuelStack[3] = this.fireItemStacks[8];
/* 411 */       fuelStack[4] = this.fireItemStacks[9];
/* 412 */       fuelStack[5] = this.fireItemStacks[10];
/* 413 */       fuelStack[6] = this.fireItemStacks[11];
/* 414 */       fuelStack[7] = this.fireItemStacks[12];
/* 415 */       fuelStack[8] = this.fireItemStacks[13];
/*     */ 
/*     */       
/* 418 */       cookItem(0);
/* 419 */       cookItem(1);
/* 420 */       cookItem(2);
/* 421 */       cookItem(3);
/* 422 */       cookItem(4);
/*     */ 
/*     */       
/* 425 */       handleFuelStack();
/*     */ 
/*     */       
/* 428 */       Random r = new Random();
/* 429 */       if (r.nextInt(10) == 0 && this.fireTemp > 20.0F) {
/* 430 */         this.field_145850_b.func_72908_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, "fire.fire", 0.4F + r.nextFloat() / 2.0F, 0.7F + r.nextFloat());
/*     */       }
/* 432 */       if (this.fireTemp >= 20.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 1) {
/* 433 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, 3);
/* 434 */       } else if (this.fireTemp < 20.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 0) {
/* 435 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 0, 3);
/*     */       } 
/*     */       
/* 438 */       if (this.fuelTimeLeft > 0 && this.fireTemp >= 1.0F && !TFC_Core.isExposedToRain(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/*     */         
/* 440 */         float desiredTemp = handleTemp();
/* 441 */         handleTempFlux(desiredTemp);
/* 442 */         this.smokeTimer++;
/* 443 */         if (this.smokeTimer > 60) {
/*     */           
/* 445 */           this.smokeTimer = 0;
/* 446 */           createSmoke();
/*     */         } 
/* 448 */         if (TFCOptions.enableDebugMode) {
/*     */           
/* 450 */           this.fireTemp = 2000.0F;
/* 451 */           this.fuelTimeLeft = 9999;
/*     */         } 
/*     */         
/* 454 */         TFC_Core.handleItemTicking(fuelStack, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 456 */       else if (this.fuelTimeLeft <= 0 && this.fireTemp >= 1.0F && this.fireItemStacks[7] != null && this.isSmokeStackValid) {
/*     */ 
/*     */         
/* 459 */         EnumFuelMaterial m = TFC_Core.getFuelMaterial(this.fireItemStacks[7]);
/* 460 */         this.fuelTimeLeft = m.burnTimeMax;
/* 461 */         this.fuelBurnTemp = m.burnTempMax;
/* 462 */         this.fuelTasteProfile = m.ordinal();
/* 463 */         this.fireItemStacks[7] = null;
/*     */       }
/*     */       else {
/*     */         
/* 467 */         removeSmoke();
/*     */         
/* 469 */         handleTempFlux(0.0F);
/* 470 */         TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */ 
/*     */       
/* 474 */       handleAirReduction();
/*     */ 
/*     */       
/* 477 */       for (int c = 0; c < 5; c++) {
/*     */         
/* 479 */         if (this.fireItemStacks[c] != null)
/*     */         {
/* 481 */           if ((this.fireItemStacks[c]).field_77994_a <= 0) {
/* 482 */             (this.fireItemStacks[c]).field_77994_a = 1;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void createSmoke() {
/* 490 */     if (!TFCOptions.generateSmoke) {
/*     */       return;
/*     */     }
/* 493 */     if (checkChimney(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 494 */       genSmokeRoot(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 495 */     } else if (checkChimney(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 496 */       genSmokeRoot(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 497 */     } else if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1)) {
/* 498 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 499 */     } else if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1)) {
/* 500 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 501 */     } else if (notOpaque(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 502 */       genSmokeRoot(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e);
/* 503 */     } else if (notOpaque(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 504 */       genSmokeRoot(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e);
/* 505 */     } else if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/* 506 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2);
/* 507 */     } else if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2)) {
/* 508 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2);
/*     */     } 
/*     */   }
/*     */   public void removeSmoke() {
/* 512 */     if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/* 513 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 514 */     } else if (isSmoke(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 515 */       this.field_145850_b.func_147468_f(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 516 */     } else if (isSmoke(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 517 */       this.field_145850_b.func_147468_f(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 518 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1)) {
/* 519 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 520 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1)) {
/* 521 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 522 */     } else if (isSmoke(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 523 */       this.field_145850_b.func_147468_f(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e);
/* 524 */     } else if (isSmoke(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 525 */       this.field_145850_b.func_147468_f(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e);
/* 526 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/* 527 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2);
/* 528 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2)) {
/* 529 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isSmoke(int x, int y, int z) {
/* 534 */     return (this.field_145850_b.func_72899_e(x, y, z) && this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.smoke);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 540 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 546 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 552 */     super.func_145841_b(nbt);
/* 553 */     nbt.func_74757_a("isValid", this.isSmokeStackValid);
/*     */     
/* 555 */     NBTTagList nbttaglist = new NBTTagList();
/* 556 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 558 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 560 */         NBTTagCompound nbt1 = new NBTTagCompound();
/* 561 */         nbt1.func_74774_a("Slot", (byte)i);
/* 562 */         this.fireItemStacks[i].func_77955_b(nbt1);
/* 563 */         nbttaglist.func_74742_a((NBTBase)nbt1);
/*     */       } 
/*     */     } 
/* 566 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */