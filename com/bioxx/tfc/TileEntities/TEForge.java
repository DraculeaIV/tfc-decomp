/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.WeatherManager;
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
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
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
/*  37 */   public ItemStack[] fireItemStacks = new ItemStack[14];
/*     */   
/*     */   private int smokeTimer;
/*     */ 
/*     */   
/*     */   private boolean validateSmokeStack() {
/*  43 */     if (directChimney(this.field_145850_b.func_72874_g(this.field_145851_c, this.field_145849_e) - 1))
/*  44 */       return true; 
/*  45 */     if (checkChimney(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e))
/*  46 */       return true; 
/*  47 */     if (checkChimney(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e))
/*  48 */       return true; 
/*  49 */     if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1))
/*  50 */       return true; 
/*  51 */     if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1))
/*  52 */       return true; 
/*  53 */     if (notOpaque(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e))
/*  54 */       return true; 
/*  55 */     if (notOpaque(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e))
/*  56 */       return true; 
/*  57 */     if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/*  58 */       return true;
/*     */     }
/*  60 */     return (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkChimney(int x, int y, int z) {
/*  65 */     return (notOpaque(x, y, z) && this.field_145850_b.func_72937_j(x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean notOpaque(int x, int y, int z) {
/*  70 */     return (this.field_145850_b.func_72899_e(x, y, z) && !this.field_145850_b.func_147439_a(x, y, z).func_149662_c());
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean directChimney(int highestY) {
/*  75 */     boolean isBlocked = false;
/*  76 */     if (this.field_145850_b.func_72937_j(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/*     */ 
/*     */       
/*  79 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, highestY, this.field_145849_e) instanceof net.minecraft.block.BlockGlass || this.field_145850_b
/*  80 */         .func_147439_a(this.field_145851_c, highestY, this.field_145849_e) instanceof net.minecraft.block.BlockStainedGlass || this.field_145850_b
/*  81 */         .isSideSolid(this.field_145851_c, highestY, this.field_145849_e, ForgeDirection.UP) || this.field_145850_b
/*  82 */         .isSideSolid(this.field_145851_c, highestY, this.field_145849_e, ForgeDirection.DOWN)) {
/*  83 */         isBlocked = true;
/*     */       }
/*     */     } else {
/*  86 */       isBlocked = true;
/*     */     } 
/*  88 */     return (!WeatherManager.isRainingOnCoord(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e) && !isBlocked);
/*     */   }
/*     */ 
/*     */   
/*     */   private void genSmokeRoot(int x, int y, int z) {
/*  93 */     if (this.fuelTimeLeft >= 0) {
/*     */       
/*  95 */       if (this.field_145850_b.func_147439_a(x, y, z) != TFCBlocks.smoke) {
/*  96 */         this.field_145850_b.func_147449_b(x, y, z, TFCBlocks.smoke);
/*     */       }
/*     */     } else {
/*     */       
/* 100 */       this.field_145850_b.func_147468_f(x, y, z);
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
/* 120 */     int d1 = 100 - inputItem.func_77960_j();
/* 121 */     int d2 = 100 - destItem.func_77960_j();
/* 122 */     destItem.func_77964_b(100 - d1 + d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cookItem(int i) {
/* 127 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 128 */     Random r = new Random();
/* 129 */     if (this.fireItemStacks[i] != null) {
/*     */       
/* 131 */       HeatIndex index = manager.findMatchingIndex(this.fireItemStacks[i]);
/* 132 */       ItemStack inputCopy = this.fireItemStacks[i].func_77946_l();
/*     */       
/* 134 */       if (index != null && TFC_ItemHeat.getTemp(this.fireItemStacks[i]) > index.meltTemp) {
/*     */         
/* 136 */         float temperature = TFC_ItemHeat.getTemp(this.fireItemStacks[i]);
/*     */ 
/*     */ 
/*     */         
/* 140 */         if (!(this.fireItemStacks[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal)) {
/* 141 */           this.fireItemStacks[i] = index.getMorph();
/*     */         }
/*     */         
/* 144 */         if (this.fireItemStacks[i] != null) {
/*     */           
/* 146 */           HeatIndex morphIndex = manager.findMatchingIndex(this.fireItemStacks[i]);
/* 147 */           if (morphIndex != null)
/*     */           {
/*     */             
/* 150 */             TFC_ItemHeat.setTemp(this.fireItemStacks[i], temperature);
/*     */           }
/*     */         }
/* 153 */         else if (index.hasOutput()) {
/*     */           
/* 155 */           ItemStack output = index.getOutput(inputCopy, r);
/* 156 */           if (inputCopy.func_77973_b() instanceof ISmeltable) {
/*     */             
/* 158 */             ISmeltable smelt = (ISmeltable)inputCopy.func_77973_b();
/* 159 */             ItemStack meltedItem = new ItemStack((smelt.getMetalType(inputCopy)).meltedItem);
/* 160 */             TFC_ItemHeat.setTemp(meltedItem, temperature);
/*     */             
/* 162 */             int units = smelt.getMetalReturnAmount(inputCopy);
/*     */             
/* 164 */             if (inputCopy.func_77973_b() instanceof com.bioxx.tfc.Items.ItemBloom) {
/* 165 */               units = Math.min(100, units);
/*     */             }
/* 167 */             while (units > 0 && getMold() != null) {
/*     */               
/* 169 */               ItemStack moldIS = getMold();
/* 170 */               ItemStack outputCopy = meltedItem.func_77946_l();
/*     */               
/* 172 */               if (units > 100) {
/*     */                 
/* 174 */                 units -= 100;
/* 175 */                 moldIS.field_77994_a--;
/* 176 */                 if (!addToStorage(outputCopy.func_77946_l())) {
/*     */                   
/* 178 */                   EntityItem ei = new EntityItem(this.field_145850_b, this.field_145851_c + 0.5D, this.field_145848_d + 1.5D, this.field_145849_e + 0.5D, outputCopy);
/* 179 */                   ei.field_70159_w = 0.0D; ei.field_70181_x = 0.0D; ei.field_70179_y = 0.0D;
/* 180 */                   this.field_145850_b.func_72838_d((Entity)ei);
/*     */                 }  continue;
/*     */               } 
/* 183 */               if (units > 0)
/*     */               {
/* 185 */                 outputCopy.func_77964_b(100 - units);
/* 186 */                 units = 0;
/* 187 */                 moldIS.field_77994_a--;
/* 188 */                 this.fireItemStacks[i] = outputCopy.func_77946_l();
/*     */               }
/*     */             
/*     */             } 
/*     */           } else {
/*     */             
/* 194 */             this.fireItemStacks[i] = output;
/*     */           } 
/*     */ 
/*     */           
/* 198 */           if (TFC_ItemHeat.isCookable(this.fireItemStacks[i]) > -1.0F)
/*     */           {
/*     */             
/* 201 */             TFC_ItemHeat.setTemp(this.fireItemStacks[i], temperature);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addToStorage(ItemStack is) {
/* 210 */     if (func_70301_a(10) == null) {
/*     */       
/* 212 */       func_70299_a(10, is);
/* 213 */       return true;
/*     */     } 
/* 215 */     if (func_70301_a(11) == null) {
/*     */       
/* 217 */       func_70299_a(11, is);
/* 218 */       return true;
/*     */     } 
/* 220 */     if (func_70301_a(12) == null) {
/*     */       
/* 222 */       func_70299_a(12, is);
/* 223 */       return true;
/*     */     } 
/* 225 */     if (func_70301_a(13) == null) {
/*     */       
/* 227 */       func_70299_a(13, is);
/* 228 */       return true;
/*     */     } 
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack getMold() {
/* 235 */     if (this.fireItemStacks[10] != null && this.fireItemStacks[10].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[10]).field_77994_a > 0)
/*     */     {
/* 237 */       return this.fireItemStacks[10];
/*     */     }
/* 239 */     if (this.fireItemStacks[11] != null && this.fireItemStacks[11].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[11]).field_77994_a > 0)
/*     */     {
/* 241 */       return this.fireItemStacks[11];
/*     */     }
/* 243 */     if (this.fireItemStacks[12] != null && this.fireItemStacks[12].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[12]).field_77994_a > 0)
/*     */     {
/* 245 */       return this.fireItemStacks[12];
/*     */     }
/* 247 */     if (this.fireItemStacks[13] != null && this.fireItemStacks[13].func_77973_b() == TFCItems.ceramicMold && (this.fireItemStacks[13]).field_77994_a > 0)
/*     */     {
/* 249 */       return this.fireItemStacks[13];
/*     */     }
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 257 */     if (this.fireItemStacks[i] != null) {
/*     */       
/* 259 */       if ((this.fireItemStacks[i]).field_77994_a <= j) {
/*     */         
/* 261 */         ItemStack is = this.fireItemStacks[i];
/* 262 */         this.fireItemStacks[i] = null;
/* 263 */         return is;
/*     */       } 
/*     */       
/* 266 */       ItemStack isSplit = this.fireItemStacks[i].func_77979_a(j);
/* 267 */       if ((this.fireItemStacks[i]).field_77994_a == 0)
/* 268 */         this.fireItemStacks[i] = null; 
/* 269 */       return isSplit;
/*     */     } 
/*     */     
/* 272 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 277 */     float f3 = 0.05F;
/*     */     
/* 279 */     Random rand = new Random();
/* 280 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 281 */     float f1 = rand.nextFloat() * 0.8F + 0.4F;
/* 282 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 284 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 286 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 288 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.fireItemStacks[i]);
/* 289 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 290 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 291 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 292 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 293 */         this.fireItemStacks[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 301 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 307 */     return "Forge";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMoldIndex() {
/* 312 */     if (this.fireItemStacks[10] != null && this.fireItemStacks[10].func_77973_b() == TFCItems.ceramicMold)
/* 313 */       return 10; 
/* 314 */     if (this.fireItemStacks[11] != null && this.fireItemStacks[11].func_77973_b() == TFCItems.ceramicMold)
/* 315 */       return 11; 
/* 316 */     if (this.fireItemStacks[12] != null && this.fireItemStacks[12].func_77973_b() == TFCItems.ceramicMold)
/* 317 */       return 12; 
/* 318 */     if (this.fireItemStacks[13] != null && this.fireItemStacks[13].func_77973_b() == TFCItems.ceramicMold)
/* 319 */       return 13; 
/* 320 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 326 */     return this.fireItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 332 */     return this.fireItemStacks[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 338 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFuelStack() {
/* 343 */     Random random = new Random();
/* 344 */     if (this.fireItemStacks[7] == null)
/*     */     {
/* 346 */       if (random.nextBoolean() && this.fireItemStacks[6] != null) {
/*     */         
/* 348 */         this.fireItemStacks[7] = this.fireItemStacks[6];
/* 349 */         this.fireItemStacks[6] = null;
/*     */       }
/*     */       else {
/*     */         
/* 353 */         this.fireItemStacks[7] = this.fireItemStacks[8];
/* 354 */         this.fireItemStacks[8] = null;
/*     */       } 
/*     */     }
/*     */     
/* 358 */     if (this.fireItemStacks[6] == null)
/*     */     {
/* 360 */       if (this.fireItemStacks[5] != null) {
/*     */         
/* 362 */         this.fireItemStacks[6] = this.fireItemStacks[5];
/* 363 */         this.fireItemStacks[5] = null;
/*     */       } 
/*     */     }
/*     */     
/* 367 */     if (this.fireItemStacks[8] == null)
/*     */     {
/* 369 */       if (this.fireItemStacks[9] != null) {
/*     */         
/* 371 */         this.fireItemStacks[8] = this.fireItemStacks[9];
/* 372 */         this.fireItemStacks[9] = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 380 */     return false;
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
/* 391 */     super.func_145839_a(nbt);
/* 392 */     this.isSmokeStackValid = nbt.func_74767_n("isValid");
/*     */     
/* 394 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 395 */     this.fireItemStacks = new ItemStack[func_70302_i_()];
/* 396 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 398 */       NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
/* 399 */       byte byte0 = nbt1.func_74771_c("Slot");
/* 400 */       if (byte0 >= 0 && byte0 < this.fireItemStacks.length) {
/* 401 */         this.fireItemStacks[byte0] = ItemStack.func_77949_a(nbt1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 408 */     this.fireItemStacks[i] = itemstack;
/* 409 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 410 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 417 */     this.isSmokeStackValid = validateSmokeStack();
/*     */     
/* 419 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 422 */       careForInventorySlot(this.fireItemStacks[0]);
/* 423 */       careForInventorySlot(this.fireItemStacks[1]);
/* 424 */       careForInventorySlot(this.fireItemStacks[2]);
/* 425 */       careForInventorySlot(this.fireItemStacks[3]);
/* 426 */       careForInventorySlot(this.fireItemStacks[4]);
/*     */       
/* 428 */       ItemStack[] fuelStack = new ItemStack[9];
/* 429 */       fuelStack[0] = this.fireItemStacks[5];
/* 430 */       fuelStack[1] = this.fireItemStacks[6];
/* 431 */       fuelStack[2] = this.fireItemStacks[7];
/* 432 */       fuelStack[3] = this.fireItemStacks[8];
/* 433 */       fuelStack[4] = this.fireItemStacks[9];
/* 434 */       fuelStack[5] = this.fireItemStacks[10];
/* 435 */       fuelStack[6] = this.fireItemStacks[11];
/* 436 */       fuelStack[7] = this.fireItemStacks[12];
/* 437 */       fuelStack[8] = this.fireItemStacks[13];
/*     */ 
/*     */       
/* 440 */       cookItem(0);
/* 441 */       cookItem(1);
/* 442 */       cookItem(2);
/* 443 */       cookItem(3);
/* 444 */       cookItem(4);
/*     */ 
/*     */       
/* 447 */       handleFuelStack();
/*     */ 
/*     */       
/* 450 */       Random r = new Random();
/* 451 */       if (r.nextInt(10) == 0 && this.fireTemp > 20.0F) {
/* 452 */         this.field_145850_b.func_72908_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, "fire.fire", 0.4F + r.nextFloat() / 2.0F, 0.7F + r.nextFloat());
/*     */       }
/* 454 */       if (this.fireTemp >= 20.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 1) {
/* 455 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, 3);
/* 456 */       } else if (this.fireTemp < 20.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 0) {
/* 457 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 0, 3);
/*     */       } 
/*     */       
/* 460 */       if (this.fuelTimeLeft > 0 && this.fireTemp >= 1.0F && !WeatherManager.isRainingOnCoord(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/*     */         
/* 462 */         float desiredTemp = handleTemp();
/* 463 */         handleTempFlux(desiredTemp);
/* 464 */         this.smokeTimer++;
/* 465 */         if (this.smokeTimer > 60) {
/*     */           
/* 467 */           this.smokeTimer = 0;
/* 468 */           createSmoke();
/*     */         } 
/* 470 */         if (TFCOptions.enableDebugMode) {
/*     */           
/* 472 */           this.fireTemp = 2000.0F;
/* 473 */           this.fuelTimeLeft = 9999;
/*     */         } 
/*     */         
/* 476 */         TFC_Core.handleItemTicking(fuelStack, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 478 */       else if (this.fuelTimeLeft <= 0 && this.fireTemp >= 1.0F && this.fireItemStacks[7] != null && this.isSmokeStackValid) {
/*     */ 
/*     */         
/* 481 */         EnumFuelMaterial m = TFC_Core.getFuelMaterial(this.fireItemStacks[7]);
/* 482 */         this.fuelTimeLeft = m.burnTimeMax;
/* 483 */         this.fuelBurnTemp = m.burnTempMax;
/* 484 */         this.fuelTasteProfile = m.ordinal();
/* 485 */         this.fireItemStacks[7] = null;
/*     */       }
/*     */       else {
/*     */         
/* 489 */         removeSmoke();
/*     */         
/* 491 */         handleTempFlux(0.0F);
/* 492 */         TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */ 
/*     */       
/* 496 */       handleAirReduction();
/*     */ 
/*     */       
/* 499 */       for (int c = 0; c < 5; c++) {
/*     */         
/* 501 */         if (this.fireItemStacks[c] != null)
/*     */         {
/* 503 */           if ((this.fireItemStacks[c]).field_77994_a <= 0) {
/* 504 */             (this.fireItemStacks[c]).field_77994_a = 1;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void createSmoke() {
/* 512 */     if (!TFCOptions.generateSmoke) {
/*     */       return;
/*     */     }
/* 515 */     if (checkChimney(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 516 */       genSmokeRoot(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 517 */     } else if (checkChimney(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 518 */       genSmokeRoot(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 519 */     } else if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1)) {
/* 520 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 521 */     } else if (checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1)) {
/* 522 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 523 */     } else if (notOpaque(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 524 */       genSmokeRoot(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e);
/* 525 */     } else if (notOpaque(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e) && checkChimney(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 526 */       genSmokeRoot(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e);
/* 527 */     } else if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/* 528 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2);
/* 529 */     } else if (notOpaque(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1) && checkChimney(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2)) {
/* 530 */       genSmokeRoot(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2);
/*     */     } 
/*     */   }
/*     */   public void removeSmoke() {
/* 534 */     if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/* 535 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 536 */     } else if (isSmoke(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 537 */       this.field_145850_b.func_147468_f(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 538 */     } else if (isSmoke(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e)) {
/* 539 */       this.field_145850_b.func_147468_f(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 540 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1)) {
/* 541 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 542 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1)) {
/* 543 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 544 */     } else if (isSmoke(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 545 */       this.field_145850_b.func_147468_f(this.field_145851_c + 2, this.field_145848_d + 1, this.field_145849_e);
/* 546 */     } else if (isSmoke(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e)) {
/* 547 */       this.field_145850_b.func_147468_f(this.field_145851_c - 2, this.field_145848_d + 1, this.field_145849_e);
/* 548 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2)) {
/* 549 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 2);
/* 550 */     } else if (isSmoke(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2)) {
/* 551 */       this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isSmoke(int x, int y, int z) {
/* 556 */     return (this.field_145850_b.func_72899_e(x, y, z) && this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.smoke);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 562 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 568 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 574 */     super.func_145841_b(nbt);
/* 575 */     nbt.func_74757_a("isValid", this.isSmokeStackValid);
/*     */     
/* 577 */     NBTTagList nbttaglist = new NBTTagList();
/* 578 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 580 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 582 */         NBTTagCompound nbt1 = new NBTTagCompound();
/* 583 */         nbt1.func_74774_a("Slot", (byte)i);
/* 584 */         this.fireItemStacks[i].func_77955_b(nbt1);
/* 585 */         nbttaglist.func_74742_a((NBTBase)nbt1);
/*     */       } 
/*     */     } 
/* 588 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */