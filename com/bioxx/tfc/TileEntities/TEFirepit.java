/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.Enums.EnumFuelMaterial;
/*     */ import com.bioxx.tfc.api.Events.ItemCookEvent;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.ICookableFood;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEFirepit
/*     */   extends TEFireEntity
/*     */   implements IInventory
/*     */ {
/*  42 */   public ItemStack[] fireItemStacks = new ItemStack[11];
/*     */   
/*     */   public boolean hasCookingPot = true;
/*     */   
/*     */   public int smokeTimer;
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */   
/*     */   public void combineMetals(ItemStack inputItem, ItemStack destItem) {
/*  53 */     int d1 = 100 - inputItem.func_77960_j();
/*  54 */     int d2 = 100 - destItem.func_77960_j();
/*     */     
/*  56 */     destItem.func_77964_b(100 - d1 + d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cookItem() {
/*  61 */     HeatRegistry manager = HeatRegistry.getInstance();
/*  62 */     Random r = new Random();
/*  63 */     if (this.fireItemStacks[1] != null) {
/*     */       
/*  65 */       HeatIndex index = manager.findMatchingIndex(this.fireItemStacks[1]);
/*  66 */       if (index != null && TFC_ItemHeat.getTemp(this.fireItemStacks[1]) > index.meltTemp) {
/*     */         
/*  68 */         ItemStack output = index.getOutput(this.fireItemStacks[1], r);
/*  69 */         ItemCookEvent eventMelt = new ItemCookEvent(this.fireItemStacks[1], output, (TileEntity)this);
/*  70 */         MinecraftForge.EVENT_BUS.post((Event)eventMelt);
/*  71 */         output = eventMelt.result;
/*  72 */         int damage = 0;
/*  73 */         ItemStack mold = null;
/*  74 */         if (output != null) {
/*     */           
/*  76 */           damage = output.func_77960_j();
/*  77 */           if (output.func_77973_b() == this.fireItemStacks[1].func_77973_b()) {
/*  78 */             damage = this.fireItemStacks[1].func_77960_j();
/*     */           }
/*     */           
/*  81 */           if (this.fireItemStacks[1].func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */ 
/*     */             
/*  84 */             if (this.fireItemStacks[7] == null && this.fireItemStacks[8] == null) {
/*     */               
/*  86 */               this.fireItemStacks[7] = this.fireItemStacks[1].func_77946_l();
/*  87 */               this.fireItemStacks[1] = null;
/*     */               
/*     */               return;
/*     */             } 
/*  91 */             if (this.fireItemStacks[7] != null && this.fireItemStacks[7].func_77973_b() != TFCItems.ceramicMold && (this.fireItemStacks[7]
/*  92 */               .func_77973_b() != this.fireItemStacks[1].func_77973_b() || this.fireItemStacks[7].func_77960_j() == 0))
/*     */             {
/*  94 */               if (this.fireItemStacks[8] == null) {
/*     */                 
/*  96 */                 this.fireItemStacks[8] = this.fireItemStacks[1].func_77946_l();
/*  97 */                 this.fireItemStacks[1] = null;
/*     */                 return;
/*     */               } 
/*     */             }
/* 101 */             mold = new ItemStack(TFCItems.ceramicMold, 1);
/* 102 */             mold.field_77994_a = 1;
/* 103 */             mold.func_77964_b(1);
/*     */           } 
/*     */         } 
/*     */         
/* 107 */         float temp = TFC_ItemHeat.getTemp(this.fireItemStacks[1]);
/* 108 */         this.fireItemStacks[1] = index.getMorph();
/* 109 */         if (this.fireItemStacks[1] != null && manager.findMatchingIndex(this.fireItemStacks[1]) != null)
/*     */         {
/*     */           
/* 112 */           TFC_ItemHeat.setTemp(this.fireItemStacks[1], temp);
/*     */         }
/*     */ 
/*     */         
/* 116 */         if (output != null && output.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */           
/* 118 */           int leftover = 0;
/* 119 */           boolean addLeftover = false;
/* 120 */           int fromSide = 0;
/* 121 */           if (this.fireItemStacks[7] != null && output.func_77973_b() == this.fireItemStacks[7].func_77973_b() && this.fireItemStacks[7].func_77960_j() > 0) {
/*     */             
/* 123 */             int amt1 = 100 - damage;
/* 124 */             int amt2 = 100 - this.fireItemStacks[7].func_77960_j();
/* 125 */             int amt3 = amt1 + amt2;
/* 126 */             leftover = amt3 - 100;
/* 127 */             if (leftover > 0)
/* 128 */               addLeftover = true; 
/* 129 */             int amt4 = 100 - amt3;
/* 130 */             if (amt4 < 0)
/* 131 */               amt4 = 0; 
/* 132 */             this.fireItemStacks[7] = output.func_77946_l();
/* 133 */             this.fireItemStacks[7].func_77964_b(amt4);
/*     */             
/* 135 */             TFC_ItemHeat.setTemp(this.fireItemStacks[7], temp);
/*     */             
/* 137 */             if (this.fireItemStacks[1] == null && mold != null) {
/* 138 */               this.fireItemStacks[1] = mold;
/*     */             }
/* 140 */           } else if (this.fireItemStacks[8] != null && output.func_77973_b() == this.fireItemStacks[8].func_77973_b() && this.fireItemStacks[8].func_77960_j() > 0) {
/*     */             
/* 142 */             int amt1 = 100 - damage;
/* 143 */             int amt2 = 100 - this.fireItemStacks[8].func_77960_j();
/* 144 */             int amt3 = amt1 + amt2;
/* 145 */             leftover = amt3 - 100;
/* 146 */             if (leftover > 0)
/* 147 */               addLeftover = true; 
/* 148 */             fromSide = 1;
/* 149 */             int amt4 = 100 - amt3;
/* 150 */             if (amt4 < 0)
/* 151 */               amt4 = 0; 
/* 152 */             this.fireItemStacks[8] = output.func_77946_l();
/* 153 */             this.fireItemStacks[8].func_77964_b(amt4);
/*     */             
/* 155 */             TFC_ItemHeat.setTemp(this.fireItemStacks[8], temp);
/*     */             
/* 157 */             if (this.fireItemStacks[1] == null && mold != null) {
/* 158 */               this.fireItemStacks[1] = mold;
/*     */             }
/* 160 */           } else if (this.fireItemStacks[7] != null && this.fireItemStacks[7].func_77973_b() == TFCItems.ceramicMold) {
/*     */             
/* 162 */             this.fireItemStacks[7] = output.func_77946_l();
/* 163 */             this.fireItemStacks[7].func_77964_b(damage);
/*     */             
/* 165 */             TFC_ItemHeat.setTemp(this.fireItemStacks[7], temp);
/*     */           }
/* 167 */           else if (this.fireItemStacks[8] != null && this.fireItemStacks[8].func_77973_b() == TFCItems.ceramicMold) {
/*     */             
/* 169 */             this.fireItemStacks[8] = output.func_77946_l();
/* 170 */             this.fireItemStacks[8].func_77964_b(damage);
/*     */             
/* 172 */             TFC_ItemHeat.setTemp(this.fireItemStacks[8], temp);
/*     */           } 
/*     */           
/* 175 */           if (addLeftover) {
/*     */             
/* 177 */             int dest = (fromSide == 1) ? 7 : 8;
/* 178 */             if (this.fireItemStacks[dest] != null && output.func_77973_b() == this.fireItemStacks[dest].func_77973_b() && this.fireItemStacks[dest].func_77960_j() > 0)
/*     */             {
/* 180 */               int amt1 = 100 - leftover;
/* 181 */               int amt2 = 100 - this.fireItemStacks[dest].func_77960_j();
/* 182 */               int amt3 = amt1 + amt2;
/* 183 */               int amt4 = 100 - amt3;
/* 184 */               if (amt4 < 0)
/* 185 */                 amt4 = 0; 
/* 186 */               this.fireItemStacks[dest] = output.func_77946_l();
/* 187 */               this.fireItemStacks[dest].func_77964_b(amt4);
/*     */               
/* 189 */               TFC_ItemHeat.setTemp(this.fireItemStacks[dest], temp);
/*     */             }
/* 191 */             else if (this.fireItemStacks[dest] != null && this.fireItemStacks[dest].func_77973_b() == TFCItems.ceramicMold)
/*     */             {
/* 193 */               this.fireItemStacks[dest] = output.func_77946_l();
/* 194 */               this.fireItemStacks[dest].func_77964_b(100 - leftover);
/* 195 */               TFC_ItemHeat.setTemp(this.fireItemStacks[dest], temp);
/*     */             }
/*     */           
/*     */           } 
/* 199 */         } else if (output != null) {
/*     */           
/* 201 */           if (this.fireItemStacks[7] != null && this.fireItemStacks[7]
/* 202 */             .func_77973_b() == output.func_77973_b() && (this.fireItemStacks[7]).field_77994_a + output.field_77994_a <= this.fireItemStacks[7]
/* 203 */             .func_77976_d()) {
/*     */             
/* 205 */             (this.fireItemStacks[7]).field_77994_a += output.field_77994_a;
/*     */           }
/* 207 */           else if (this.fireItemStacks[8] != null && this.fireItemStacks[8]
/* 208 */             .func_77973_b() == output.func_77973_b() && (this.fireItemStacks[8]).field_77994_a + output.field_77994_a <= this.fireItemStacks[8]
/* 209 */             .func_77976_d()) {
/*     */             
/* 211 */             (this.fireItemStacks[8]).field_77994_a += output.field_77994_a;
/*     */           }
/* 213 */           else if (this.fireItemStacks[7] == null) {
/*     */             
/* 215 */             this.fireItemStacks[7] = output.func_77946_l();
/*     */           }
/* 217 */           else if (this.fireItemStacks[8] == null) {
/*     */             
/* 219 */             this.fireItemStacks[8] = output.func_77946_l();
/*     */           }
/* 221 */           else if (((this.fireItemStacks[7]).field_77994_a == this.fireItemStacks[7].func_77976_d() && (this.fireItemStacks[8]).field_77994_a == this.fireItemStacks[8]
/* 222 */             .func_77976_d()) || (this.fireItemStacks[7]
/* 223 */             .func_77973_b() != output.func_77973_b() && this.fireItemStacks[8].func_77973_b() != output.func_77973_b()) || ((this.fireItemStacks[7]).field_77994_a == this.fireItemStacks[7]
/* 224 */             .func_77976_d() && this.fireItemStacks[8].func_77973_b() != output.func_77973_b()) || (this.fireItemStacks[7]
/* 225 */             .func_77973_b() != output.func_77973_b() && (this.fireItemStacks[8]).field_77994_a == this.fireItemStacks[8].func_77976_d())) {
/*     */             
/* 227 */             this.fireItemStacks[1] = output.func_77946_l();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount) {
/* 237 */     if (this.fireItemStacks[slot] != null) {
/*     */       
/* 239 */       if ((this.fireItemStacks[slot]).field_77994_a <= amount) {
/*     */         
/* 241 */         ItemStack itemstack = this.fireItemStacks[slot];
/* 242 */         this.fireItemStacks[slot] = null;
/* 243 */         return itemstack;
/*     */       } 
/* 245 */       ItemStack itemstack1 = this.fireItemStacks[slot].func_77979_a(amount);
/* 246 */       if ((this.fireItemStacks[slot]).field_77994_a == 0)
/* 247 */         this.fireItemStacks[slot] = null; 
/* 248 */       return itemstack1;
/*     */     } 
/*     */     
/* 251 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 256 */     float f3 = 0.05F;
/*     */     
/* 258 */     Random rand = new Random();
/* 259 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 260 */     float f1 = rand.nextFloat() * 0.8F + 0.3F;
/* 261 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 263 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 265 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 267 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.fireItemStacks[i]);
/* 268 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 269 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 270 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 271 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 272 */         this.fireItemStacks[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 280 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 286 */     return "Firepit";
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOutput1Temp() {
/* 291 */     return TFC_ItemHeat.getTemp(this.fireItemStacks[7]);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOutput2Temp() {
/* 296 */     return TFC_ItemHeat.getTemp(this.fireItemStacks[8]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 302 */     return this.fireItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slot) {
/* 308 */     return this.fireItemStacks[slot];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int slot) {
/* 314 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFuelStack() {
/* 319 */     if (this.fireItemStacks[3] == null && this.fireItemStacks[0] != null) {
/*     */       
/* 321 */       this.fireItemStacks[3] = this.fireItemStacks[0];
/* 322 */       this.fireItemStacks[0] = null;
/*     */     } 
/* 324 */     if (this.fireItemStacks[4] == null && this.fireItemStacks[3] != null) {
/*     */       
/* 326 */       this.fireItemStacks[4] = this.fireItemStacks[3];
/* 327 */       this.fireItemStacks[3] = null;
/*     */     } 
/* 329 */     if (this.fireItemStacks[5] == null && this.fireItemStacks[4] != null) {
/*     */       
/* 331 */       this.fireItemStacks[5] = this.fireItemStacks[4];
/* 332 */       this.fireItemStacks[4] = null;
/*     */     } 
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
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int slot, ItemStack is) {
/* 350 */     this.fireItemStacks[slot] = is;
/* 351 */     if (is != null && is.field_77994_a > func_70297_j_()) {
/* 352 */       is.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void careForInventorySlot(ItemStack is) {
/* 358 */     if (is != null) {
/*     */       
/* 360 */       HeatRegistry manager = HeatRegistry.getInstance();
/* 361 */       HeatIndex index = manager.findMatchingIndex(is);
/*     */       
/* 363 */       if (index != null) {
/*     */         
/* 365 */         float temp = TFC_ItemHeat.getTemp(is);
/* 366 */         if (this.fuelTimeLeft > 0 && is.func_77973_b() instanceof ICookableFood) {
/*     */           
/* 368 */           float inc = Food.getCooked(is) + Math.min(this.fireTemp / 700.0F, 2.0F);
/* 369 */           Food.setCooked(is, inc);
/* 370 */           temp = inc;
/* 371 */           if (Food.isCooked(is))
/*     */           {
/* 373 */             int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/*     */             
/* 375 */             Random r = new Random((((ICookableFood)is.func_77973_b()).getFoodID() + ((int)Food.getCooked(is) - 600) / 120));
/* 376 */             cookedTasteProfile[0] = r.nextInt(31) - 15;
/* 377 */             cookedTasteProfile[1] = r.nextInt(31) - 15;
/* 378 */             cookedTasteProfile[2] = r.nextInt(31) - 15;
/* 379 */             cookedTasteProfile[3] = r.nextInt(31) - 15;
/* 380 */             cookedTasteProfile[4] = r.nextInt(31) - 15;
/* 381 */             Food.setCookedProfile(is, cookedTasteProfile);
/* 382 */             Food.setFuelProfile(is, EnumFuelMaterial.getFuelProfile(this.fuelTasteProfile));
/*     */           }
/*     */         
/* 385 */         } else if (this.fireTemp > temp && index.hasOutput()) {
/*     */           
/* 387 */           temp += TFC_ItemHeat.getTempIncrease(is);
/*     */         } else {
/*     */           
/* 390 */           temp -= TFC_ItemHeat.getTempDecrease(is);
/* 391 */         }  TFC_ItemHeat.setTemp(is, temp);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 399 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 402 */       List list = this.field_145850_b.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), this.field_145848_d + 1.1D, (this.field_145849_e + 1)));
/*     */       
/* 404 */       if (list != null && !list.isEmpty() && this.fireItemStacks[0] == null)
/*     */       {
/*     */         
/* 407 */         for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */           
/* 409 */           EntityItem entity = iterator.next();
/* 410 */           ItemStack is = entity.func_92059_d();
/* 411 */           Item item = is.func_77973_b();
/*     */           
/* 413 */           if (item == TFCItems.logs || item == Item.func_150898_a(TFCBlocks.peat)) {
/*     */             
/* 415 */             for (int c = 0; c < is.field_77994_a; c++) {
/*     */               
/* 417 */               if (this.fireItemStacks[0] == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 423 */                 func_70299_a(0, new ItemStack(item, 1, is.func_77960_j()));
/* 424 */                 is.field_77994_a--;
/* 425 */                 handleFuelStack();
/*     */               } 
/*     */             } 
/*     */             
/* 429 */             if (is.field_77994_a == 0) {
/* 430 */               entity.func_70106_y();
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 436 */       careForInventorySlot(this.fireItemStacks[1]);
/* 437 */       careForInventorySlot(this.fireItemStacks[7]);
/* 438 */       careForInventorySlot(this.fireItemStacks[8]);
/*     */       
/* 440 */       smokeFoods();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 446 */       cookItem();
/*     */ 
/*     */       
/* 449 */       handleFuelStack();
/*     */       
/* 451 */       if (this.fireTemp < 1.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 0) {
/*     */         
/* 453 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 0, 3);
/* 454 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 456 */       else if (this.fireTemp >= 1.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 1) {
/*     */         
/* 458 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, 3);
/* 459 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */ 
/*     */       
/* 463 */       if (this.fuelTimeLeft > 0 && this.fireTemp >= 1.0F) {
/*     */         
/* 465 */         if (this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 2)
/*     */         {
/* 467 */           this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 2, 3);
/* 468 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         }
/*     */       
/* 471 */       } else if (this.fuelTimeLeft <= 0 && this.fireTemp >= 1.0F && this.fireItemStacks[5] != null && 
/* 472 */         !TFC_Core.isExposedToRain(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/*     */         
/* 474 */         if (this.fireItemStacks[5] != null) {
/*     */           
/* 476 */           EnumFuelMaterial m = TFC_Core.getFuelMaterial(this.fireItemStacks[5]);
/* 477 */           this.fuelTasteProfile = m.ordinal();
/* 478 */           this.fireItemStacks[5] = null;
/* 479 */           this.fuelTimeLeft = m.burnTimeMax;
/* 480 */           this.fuelBurnTemp = m.burnTempMax;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 485 */       float desiredTemp = handleTemp();
/*     */       
/* 487 */       handleTempFlux(desiredTemp);
/*     */ 
/*     */       
/* 490 */       handleAirReduction();
/*     */ 
/*     */       
/* 493 */       if (this.fireItemStacks[7] != null)
/*     */       {
/* 495 */         if ((this.fireItemStacks[7]).field_77994_a <= 0) {
/* 496 */           (this.fireItemStacks[7]).field_77994_a = 1;
/*     */         }
/*     */       }
/* 499 */       if (this.fireItemStacks[8] != null)
/*     */       {
/* 501 */         if ((this.fireItemStacks[8]).field_77994_a <= 0) {
/* 502 */           (this.fireItemStacks[8]).field_77994_a = 1;
/*     */         }
/*     */       }
/* 505 */       if (this.fuelTimeLeft <= 0) {
/* 506 */         TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smokeFoods() {
/* 512 */     if (this.fuelTimeLeft > 0) {
/*     */       
/* 514 */       this.smokeTimer++;
/* 515 */       if (this.smokeTimer > 1000) {
/*     */         
/* 517 */         this.smokeTimer = 0;
/* 518 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 519 */         smokeBlock(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 520 */         smokeBlock(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 521 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 522 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 523 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e);
/* 524 */         smokeBlock(this.field_145851_c + 1, this.field_145848_d + 2, this.field_145849_e);
/* 525 */         smokeBlock(this.field_145851_c - 1, this.field_145848_d + 2, this.field_145849_e);
/* 526 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e + 1);
/* 527 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e - 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smokeBlock(int x, int y, int z) {
/* 533 */     if (this.field_145850_b.func_72899_e(x, y, z) && this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.smokeRack && this.field_145850_b
/* 534 */       .func_147438_o(x, y, z) instanceof TESmokeRack) {
/*     */       
/* 536 */       boolean broadcast = false;
/* 537 */       TESmokeRack te = (TESmokeRack)this.field_145850_b.func_147438_o(x, y, z);
/* 538 */       te.lastSmokedTime = (int)TFC_Time.getTotalHours();
/*     */       
/* 540 */       for (int i = 0; i < te.storage.length; i++) {
/*     */         
/* 542 */         ItemStack is = te.func_70301_a(i);
/* 543 */         if (is != null)
/*     */         {
/* 545 */           if (Food.getSmokeCounter(is) < 12) {
/*     */ 
/*     */             
/* 548 */             Food.setSmokeCounter(is, Food.getSmokeCounter(is) + 1);
/*     */           }
/*     */           else {
/*     */             
/* 552 */             Food.setFuelProfile(is, EnumFuelMaterial.getFuelProfile(this.fuelTasteProfile));
/* 553 */             broadcast = true;
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 558 */       if (broadcast) {
/* 559 */         te.broadcastPacketInRange();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 566 */     super.func_145839_a(nbttagcompound);
/* 567 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 568 */     this.fireItemStacks = new ItemStack[func_70302_i_()];
/* 569 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 571 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 572 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 573 */       if (byte0 >= 0 && byte0 < this.fireItemStacks.length) {
/* 574 */         this.fireItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 581 */     super.func_145841_b(nbttagcompound);
/* 582 */     NBTTagList nbttaglist = new NBTTagList();
/* 583 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 585 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 587 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 588 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 589 */         this.fireItemStacks[i].func_77955_b(nbttagcompound1);
/* 590 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 593 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 599 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack is) {
/* 605 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void generateSmoke() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */