/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Core.WeatherManager;
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
/*     */ public class TEFirepit
/*     */   extends TEFireEntity
/*     */   implements IInventory
/*     */ {
/*  41 */   public ItemStack[] fireItemStacks = new ItemStack[11];
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
/*  52 */     int d1 = 100 - inputItem.func_77960_j();
/*  53 */     int d2 = 100 - destItem.func_77960_j();
/*     */     
/*  55 */     destItem.func_77964_b(100 - d1 + d2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cookItem() {
/*  60 */     HeatRegistry manager = HeatRegistry.getInstance();
/*  61 */     Random r = new Random();
/*  62 */     if (this.fireItemStacks[1] != null) {
/*     */       
/*  64 */       HeatIndex index = manager.findMatchingIndex(this.fireItemStacks[1]);
/*  65 */       if (index != null && TFC_ItemHeat.getTemp(this.fireItemStacks[1]) > index.meltTemp) {
/*     */         
/*  67 */         ItemStack output = index.getOutput(this.fireItemStacks[1], r);
/*  68 */         ItemCookEvent eventMelt = new ItemCookEvent(this.fireItemStacks[1], output, (TileEntity)this);
/*  69 */         MinecraftForge.EVENT_BUS.post((Event)eventMelt);
/*  70 */         output = eventMelt.result;
/*  71 */         int damage = 0;
/*  72 */         ItemStack mold = null;
/*  73 */         if (output != null) {
/*     */           
/*  75 */           damage = output.func_77960_j();
/*  76 */           if (output.func_77973_b() == this.fireItemStacks[1].func_77973_b()) {
/*  77 */             damage = this.fireItemStacks[1].func_77960_j();
/*     */           }
/*     */           
/*  80 */           if (this.fireItemStacks[1].func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */ 
/*     */             
/*  83 */             if (this.fireItemStacks[7] == null && this.fireItemStacks[8] == null) {
/*     */               
/*  85 */               this.fireItemStacks[7] = this.fireItemStacks[1].func_77946_l();
/*  86 */               this.fireItemStacks[1] = null;
/*     */               
/*     */               return;
/*     */             } 
/*  90 */             if (this.fireItemStacks[7] != null && this.fireItemStacks[7].func_77973_b() != TFCItems.ceramicMold && (this.fireItemStacks[7]
/*  91 */               .func_77973_b() != this.fireItemStacks[1].func_77973_b() || this.fireItemStacks[7].func_77960_j() == 0))
/*     */             {
/*  93 */               if (this.fireItemStacks[8] == null) {
/*     */                 
/*  95 */                 this.fireItemStacks[8] = this.fireItemStacks[1].func_77946_l();
/*  96 */                 this.fireItemStacks[1] = null;
/*     */                 return;
/*     */               } 
/*     */             }
/* 100 */             mold = new ItemStack(TFCItems.ceramicMold, 1);
/* 101 */             mold.field_77994_a = 1;
/* 102 */             mold.func_77964_b(1);
/*     */           } 
/*     */         } 
/*     */         
/* 106 */         float temp = TFC_ItemHeat.getTemp(this.fireItemStacks[1]);
/* 107 */         this.fireItemStacks[1] = index.getMorph();
/* 108 */         if (this.fireItemStacks[1] != null && manager.findMatchingIndex(this.fireItemStacks[1]) != null)
/*     */         {
/*     */           
/* 111 */           TFC_ItemHeat.setTemp(this.fireItemStacks[1], temp);
/*     */         }
/*     */ 
/*     */         
/* 115 */         if (output != null && output.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */           
/* 117 */           int leftover = 0;
/* 118 */           boolean addLeftover = false;
/* 119 */           int fromSide = 0;
/* 120 */           if (this.fireItemStacks[7] != null && output.func_77973_b() == this.fireItemStacks[7].func_77973_b() && this.fireItemStacks[7].func_77960_j() > 0) {
/*     */             
/* 122 */             int amt1 = 100 - damage;
/* 123 */             int amt2 = 100 - this.fireItemStacks[7].func_77960_j();
/* 124 */             int amt3 = amt1 + amt2;
/* 125 */             leftover = amt3 - 100;
/* 126 */             if (leftover > 0)
/* 127 */               addLeftover = true; 
/* 128 */             int amt4 = 100 - amt3;
/* 129 */             if (amt4 < 0)
/* 130 */               amt4 = 0; 
/* 131 */             this.fireItemStacks[7] = output.func_77946_l();
/* 132 */             this.fireItemStacks[7].func_77964_b(amt4);
/*     */             
/* 134 */             TFC_ItemHeat.setTemp(this.fireItemStacks[7], temp);
/*     */             
/* 136 */             if (this.fireItemStacks[1] == null && mold != null) {
/* 137 */               this.fireItemStacks[1] = mold;
/*     */             }
/* 139 */           } else if (this.fireItemStacks[8] != null && output.func_77973_b() == this.fireItemStacks[8].func_77973_b() && this.fireItemStacks[8].func_77960_j() > 0) {
/*     */             
/* 141 */             int amt1 = 100 - damage;
/* 142 */             int amt2 = 100 - this.fireItemStacks[8].func_77960_j();
/* 143 */             int amt3 = amt1 + amt2;
/* 144 */             leftover = amt3 - 100;
/* 145 */             if (leftover > 0)
/* 146 */               addLeftover = true; 
/* 147 */             fromSide = 1;
/* 148 */             int amt4 = 100 - amt3;
/* 149 */             if (amt4 < 0)
/* 150 */               amt4 = 0; 
/* 151 */             this.fireItemStacks[8] = output.func_77946_l();
/* 152 */             this.fireItemStacks[8].func_77964_b(amt4);
/*     */             
/* 154 */             TFC_ItemHeat.setTemp(this.fireItemStacks[8], temp);
/*     */             
/* 156 */             if (this.fireItemStacks[1] == null && mold != null) {
/* 157 */               this.fireItemStacks[1] = mold;
/*     */             }
/* 159 */           } else if (this.fireItemStacks[7] != null && this.fireItemStacks[7].func_77973_b() == TFCItems.ceramicMold) {
/*     */             
/* 161 */             this.fireItemStacks[7] = output.func_77946_l();
/* 162 */             this.fireItemStacks[7].func_77964_b(damage);
/*     */             
/* 164 */             TFC_ItemHeat.setTemp(this.fireItemStacks[7], temp);
/*     */           }
/* 166 */           else if (this.fireItemStacks[8] != null && this.fireItemStacks[8].func_77973_b() == TFCItems.ceramicMold) {
/*     */             
/* 168 */             this.fireItemStacks[8] = output.func_77946_l();
/* 169 */             this.fireItemStacks[8].func_77964_b(damage);
/*     */             
/* 171 */             TFC_ItemHeat.setTemp(this.fireItemStacks[8], temp);
/*     */           } 
/*     */           
/* 174 */           if (addLeftover) {
/*     */             
/* 176 */             int dest = (fromSide == 1) ? 7 : 8;
/* 177 */             if (this.fireItemStacks[dest] != null && output.func_77973_b() == this.fireItemStacks[dest].func_77973_b() && this.fireItemStacks[dest].func_77960_j() > 0)
/*     */             {
/* 179 */               int amt1 = 100 - leftover;
/* 180 */               int amt2 = 100 - this.fireItemStacks[dest].func_77960_j();
/* 181 */               int amt3 = amt1 + amt2;
/* 182 */               int amt4 = 100 - amt3;
/* 183 */               if (amt4 < 0)
/* 184 */                 amt4 = 0; 
/* 185 */               this.fireItemStacks[dest] = output.func_77946_l();
/* 186 */               this.fireItemStacks[dest].func_77964_b(amt4);
/*     */               
/* 188 */               TFC_ItemHeat.setTemp(this.fireItemStacks[dest], temp);
/*     */             }
/* 190 */             else if (this.fireItemStacks[dest] != null && this.fireItemStacks[dest].func_77973_b() == TFCItems.ceramicMold)
/*     */             {
/* 192 */               this.fireItemStacks[dest] = output.func_77946_l();
/* 193 */               this.fireItemStacks[dest].func_77964_b(100 - leftover);
/* 194 */               TFC_ItemHeat.setTemp(this.fireItemStacks[dest], temp);
/*     */             }
/*     */           
/*     */           } 
/* 198 */         } else if (output != null) {
/*     */           
/* 200 */           if (this.fireItemStacks[7] != null && this.fireItemStacks[7]
/* 201 */             .func_77973_b() == output.func_77973_b() && (this.fireItemStacks[7]).field_77994_a + output.field_77994_a <= this.fireItemStacks[7]
/* 202 */             .func_77976_d()) {
/*     */             
/* 204 */             (this.fireItemStacks[7]).field_77994_a += output.field_77994_a;
/*     */           }
/* 206 */           else if (this.fireItemStacks[8] != null && this.fireItemStacks[8]
/* 207 */             .func_77973_b() == output.func_77973_b() && (this.fireItemStacks[8]).field_77994_a + output.field_77994_a <= this.fireItemStacks[8]
/* 208 */             .func_77976_d()) {
/*     */             
/* 210 */             (this.fireItemStacks[8]).field_77994_a += output.field_77994_a;
/*     */           }
/* 212 */           else if (this.fireItemStacks[7] == null) {
/*     */             
/* 214 */             this.fireItemStacks[7] = output.func_77946_l();
/*     */           }
/* 216 */           else if (this.fireItemStacks[8] == null) {
/*     */             
/* 218 */             this.fireItemStacks[8] = output.func_77946_l();
/*     */           }
/* 220 */           else if (((this.fireItemStacks[7]).field_77994_a == this.fireItemStacks[7].func_77976_d() && (this.fireItemStacks[8]).field_77994_a == this.fireItemStacks[8]
/* 221 */             .func_77976_d()) || (this.fireItemStacks[7]
/* 222 */             .func_77973_b() != output.func_77973_b() && this.fireItemStacks[8].func_77973_b() != output.func_77973_b()) || ((this.fireItemStacks[7]).field_77994_a == this.fireItemStacks[7]
/* 223 */             .func_77976_d() && this.fireItemStacks[8].func_77973_b() != output.func_77973_b()) || (this.fireItemStacks[7]
/* 224 */             .func_77973_b() != output.func_77973_b() && (this.fireItemStacks[8]).field_77994_a == this.fireItemStacks[8].func_77976_d())) {
/*     */             
/* 226 */             this.fireItemStacks[1] = output.func_77946_l();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int slot, int amount) {
/* 236 */     if (this.fireItemStacks[slot] != null) {
/*     */       
/* 238 */       if ((this.fireItemStacks[slot]).field_77994_a <= amount) {
/*     */         
/* 240 */         ItemStack itemstack = this.fireItemStacks[slot];
/* 241 */         this.fireItemStacks[slot] = null;
/* 242 */         return itemstack;
/*     */       } 
/* 244 */       ItemStack itemstack1 = this.fireItemStacks[slot].func_77979_a(amount);
/* 245 */       if ((this.fireItemStacks[slot]).field_77994_a == 0)
/* 246 */         this.fireItemStacks[slot] = null; 
/* 247 */       return itemstack1;
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
/* 259 */     float f1 = rand.nextFloat() * 0.8F + 0.3F;
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
/* 285 */     return "Firepit";
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOutput1Temp() {
/* 290 */     return TFC_ItemHeat.getTemp(this.fireItemStacks[7]);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOutput2Temp() {
/* 295 */     return TFC_ItemHeat.getTemp(this.fireItemStacks[8]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 301 */     return this.fireItemStacks.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int slot) {
/* 307 */     return this.fireItemStacks[slot];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int slot) {
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFuelStack() {
/* 318 */     if (this.fireItemStacks[3] == null && this.fireItemStacks[0] != null) {
/*     */       
/* 320 */       this.fireItemStacks[3] = this.fireItemStacks[0];
/* 321 */       this.fireItemStacks[0] = null;
/*     */     } 
/* 323 */     if (this.fireItemStacks[4] == null && this.fireItemStacks[3] != null) {
/*     */       
/* 325 */       this.fireItemStacks[4] = this.fireItemStacks[3];
/* 326 */       this.fireItemStacks[3] = null;
/*     */     } 
/* 328 */     if (this.fireItemStacks[5] == null && this.fireItemStacks[4] != null) {
/*     */       
/* 330 */       this.fireItemStacks[5] = this.fireItemStacks[4];
/* 331 */       this.fireItemStacks[4] = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 338 */     return false;
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
/* 349 */     this.fireItemStacks[slot] = is;
/* 350 */     if (is != null && is.field_77994_a > func_70297_j_()) {
/* 351 */       is.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void careForInventorySlot(ItemStack is) {
/* 357 */     if (is != null) {
/*     */       
/* 359 */       HeatRegistry manager = HeatRegistry.getInstance();
/* 360 */       HeatIndex index = manager.findMatchingIndex(is);
/*     */       
/* 362 */       if (index != null) {
/*     */         
/* 364 */         float temp = TFC_ItemHeat.getTemp(is);
/* 365 */         if (this.fuelTimeLeft > 0 && is.func_77973_b() instanceof ICookableFood) {
/*     */           
/* 367 */           float inc = Food.getCooked(is) + Math.min(this.fireTemp / 700.0F, 2.0F);
/* 368 */           Food.setCooked(is, inc);
/* 369 */           temp = inc;
/* 370 */           if (Food.isCooked(is))
/*     */           {
/* 372 */             int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/*     */             
/* 374 */             Random r = new Random((((ICookableFood)is.func_77973_b()).getFoodID() + ((int)Food.getCooked(is) - 600) / 120));
/* 375 */             cookedTasteProfile[0] = r.nextInt(31) - 15;
/* 376 */             cookedTasteProfile[1] = r.nextInt(31) - 15;
/* 377 */             cookedTasteProfile[2] = r.nextInt(31) - 15;
/* 378 */             cookedTasteProfile[3] = r.nextInt(31) - 15;
/* 379 */             cookedTasteProfile[4] = r.nextInt(31) - 15;
/* 380 */             Food.setCookedProfile(is, cookedTasteProfile);
/* 381 */             Food.setFuelProfile(is, EnumFuelMaterial.getFuelProfile(this.fuelTasteProfile));
/*     */           }
/*     */         
/* 384 */         } else if (this.fireTemp > temp && index.hasOutput()) {
/*     */           
/* 386 */           temp += TFC_ItemHeat.getTempIncrease(is);
/*     */         } else {
/*     */           
/* 389 */           temp -= TFC_ItemHeat.getTempDecrease(is);
/* 390 */         }  TFC_ItemHeat.setTemp(is, temp);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 398 */     if (!this.field_145850_b.field_72995_K) {
/*     */ 
/*     */       
/* 401 */       List list = this.field_145850_b.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), this.field_145848_d + 1.1D, (this.field_145849_e + 1)));
/*     */       
/* 403 */       if (list != null && !list.isEmpty() && this.fireItemStacks[0] == null)
/*     */       {
/*     */         
/* 406 */         for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */           
/* 408 */           EntityItem entity = iterator.next();
/* 409 */           ItemStack is = entity.func_92059_d();
/* 410 */           Item item = is.func_77973_b();
/*     */           
/* 412 */           if (item == TFCItems.logs || item == Item.func_150898_a(TFCBlocks.peat)) {
/*     */             
/* 414 */             for (int c = 0; c < is.field_77994_a; c++) {
/*     */               
/* 416 */               if (this.fireItemStacks[0] == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 422 */                 func_70299_a(0, new ItemStack(item, 1, is.func_77960_j()));
/* 423 */                 is.field_77994_a--;
/* 424 */                 handleFuelStack();
/*     */               } 
/*     */             } 
/*     */             
/* 428 */             if (is.field_77994_a == 0) {
/* 429 */               entity.func_70106_y();
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 435 */       careForInventorySlot(this.fireItemStacks[1]);
/* 436 */       careForInventorySlot(this.fireItemStacks[7]);
/* 437 */       careForInventorySlot(this.fireItemStacks[8]);
/*     */       
/* 439 */       smokeFoods();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 445 */       cookItem();
/*     */ 
/*     */       
/* 448 */       handleFuelStack();
/*     */       
/* 450 */       if (this.fireTemp < 1.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 0) {
/*     */         
/* 452 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 0, 3);
/* 453 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/* 455 */       else if (this.fireTemp >= 1.0F && this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 1) {
/*     */         
/* 457 */         this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, 3);
/* 458 */         this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       } 
/*     */ 
/*     */       
/* 462 */       if (this.fuelTimeLeft > 0 && this.fireTemp >= 1.0F) {
/*     */         
/* 464 */         if (this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e) != 2)
/*     */         {
/* 466 */           this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, 2, 3);
/* 467 */           this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         }
/*     */       
/* 470 */       } else if (this.fuelTimeLeft <= 0 && this.fireTemp >= 1.0F && this.fireItemStacks[5] != null && 
/* 471 */         !WeatherManager.isRainingOnCoord(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/*     */         
/* 473 */         if (this.fireItemStacks[5] != null) {
/*     */           
/* 475 */           EnumFuelMaterial m = TFC_Core.getFuelMaterial(this.fireItemStacks[5]);
/* 476 */           this.fuelTasteProfile = m.ordinal();
/* 477 */           this.fireItemStacks[5] = null;
/* 478 */           this.fuelTimeLeft = m.burnTimeMax;
/* 479 */           this.fuelBurnTemp = m.burnTempMax;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 484 */       float desiredTemp = handleTemp();
/*     */       
/* 486 */       handleTempFlux(desiredTemp);
/*     */ 
/*     */       
/* 489 */       handleAirReduction();
/*     */ 
/*     */       
/* 492 */       if (this.fireItemStacks[7] != null)
/*     */       {
/* 494 */         if ((this.fireItemStacks[7]).field_77994_a <= 0) {
/* 495 */           (this.fireItemStacks[7]).field_77994_a = 1;
/*     */         }
/*     */       }
/* 498 */       if (this.fireItemStacks[8] != null)
/*     */       {
/* 500 */         if ((this.fireItemStacks[8]).field_77994_a <= 0) {
/* 501 */           (this.fireItemStacks[8]).field_77994_a = 1;
/*     */         }
/*     */       }
/* 504 */       if (this.fuelTimeLeft <= 0) {
/* 505 */         TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smokeFoods() {
/* 511 */     if (this.fuelTimeLeft > 0) {
/*     */       
/* 513 */       this.smokeTimer++;
/* 514 */       if (this.smokeTimer > 1000) {
/*     */         
/* 516 */         this.smokeTimer = 0;
/* 517 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 518 */         smokeBlock(this.field_145851_c + 1, this.field_145848_d + 1, this.field_145849_e);
/* 519 */         smokeBlock(this.field_145851_c - 1, this.field_145848_d + 1, this.field_145849_e);
/* 520 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e + 1);
/* 521 */         smokeBlock(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e - 1);
/* 522 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e);
/* 523 */         smokeBlock(this.field_145851_c + 1, this.field_145848_d + 2, this.field_145849_e);
/* 524 */         smokeBlock(this.field_145851_c - 1, this.field_145848_d + 2, this.field_145849_e);
/* 525 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e + 1);
/* 526 */         smokeBlock(this.field_145851_c, this.field_145848_d + 2, this.field_145849_e - 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void smokeBlock(int x, int y, int z) {
/* 532 */     if (this.field_145850_b.func_72899_e(x, y, z) && this.field_145850_b.func_147439_a(x, y, z) == TFCBlocks.smokeRack && this.field_145850_b
/* 533 */       .func_147438_o(x, y, z) instanceof TESmokeRack) {
/*     */       
/* 535 */       boolean broadcast = false;
/* 536 */       TESmokeRack te = (TESmokeRack)this.field_145850_b.func_147438_o(x, y, z);
/* 537 */       te.lastSmokedTime = (int)TFC_Time.getTotalHours();
/*     */       
/* 539 */       for (int i = 0; i < te.storage.length; i++) {
/*     */         
/* 541 */         ItemStack is = te.func_70301_a(i);
/* 542 */         if (is != null)
/*     */         {
/* 544 */           if (Food.getSmokeCounter(is) < 12) {
/*     */ 
/*     */             
/* 547 */             Food.setSmokeCounter(is, Food.getSmokeCounter(is) + 1);
/*     */           }
/*     */           else {
/*     */             
/* 551 */             Food.setFuelProfile(is, EnumFuelMaterial.getFuelProfile(this.fuelTasteProfile));
/* 552 */             broadcast = true;
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 557 */       if (broadcast) {
/* 558 */         te.broadcastPacketInRange();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 565 */     super.func_145839_a(nbttagcompound);
/* 566 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 567 */     this.fireItemStacks = new ItemStack[func_70302_i_()];
/* 568 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 570 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 571 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 572 */       if (byte0 >= 0 && byte0 < this.fireItemStacks.length) {
/* 573 */         this.fireItemStacks[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 580 */     super.func_145841_b(nbttagcompound);
/* 581 */     NBTTagList nbttaglist = new NBTTagList();
/* 582 */     for (int i = 0; i < this.fireItemStacks.length; i++) {
/*     */       
/* 584 */       if (this.fireItemStacks[i] != null) {
/*     */         
/* 586 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 587 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 588 */         this.fireItemStacks[i].func_77955_b(nbttagcompound1);
/* 589 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 592 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 598 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int slot, ItemStack is) {
/* 604 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void generateSmoke() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */