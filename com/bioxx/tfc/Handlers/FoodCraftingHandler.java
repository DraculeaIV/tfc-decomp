/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Events.ItemCookEvent;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class FoodCraftingHandler
/*     */ {
/*     */   public static boolean preCrafted;
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onFoodCook(ItemCookEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onFoodCrafting(PlayerEvent.ItemCraftedEvent e) {
/*  40 */     if (preCrafted) {
/*     */       
/*  42 */       preCrafted = false;
/*     */       
/*     */       return;
/*     */     } 
/*  46 */     ItemStack craftResult = e.crafting;
/*  47 */     IInventory craftingInv = e.craftMatrix;
/*     */     
/*  49 */     if (craftingInv != null)
/*     */     {
/*  51 */       if (refiningGrain(craftResult, craftingInv)) {
/*     */         
/*  53 */         for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */           
/*  55 */           ItemStack inputStack = craftingInv.func_70301_a(i);
/*  56 */           if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */             
/*  59 */             float foodWeight = Food.getWeight(inputStack);
/*  60 */             int strawCount = 0;
/*     */             
/*  62 */             for (int j = 0; j < foodWeight; j += 4) {
/*  63 */               strawCount++;
/*     */             }
/*  65 */             TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.straw, strawCount), e.player);
/*     */           } 
/*     */         } 
/*  68 */       } else if (makingDough(craftResult, craftingInv)) {
/*     */         
/*  70 */         for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */           
/*  72 */           ItemStack inputStack = craftingInv.func_70301_a(i);
/*  73 */           if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */             
/*  76 */             float grainWeight = Food.getWeight(inputStack);
/*  77 */             float grainDecay = Food.getDecay(inputStack);
/*  78 */             if (grainDecay >= 0.0F)
/*  79 */               grainWeight -= grainDecay; 
/*  80 */             grainWeight -= Math.min(grainWeight, 80.0F);
/*     */             
/*  82 */             inputStack = ItemFoodTFC.createTag(inputStack, grainWeight, 0.0F);
/*     */             
/*  84 */             if (grainWeight > 0.0F) {
/*     */               
/*  86 */               inputStack.field_77994_a++;
/*  87 */               if (inputStack.field_77994_a > 2)
/*  88 */                 inputStack.field_77994_a = 2; 
/*     */             } 
/*     */           } 
/*     */         } 
/*  92 */       } else if (craftResult.func_77942_o() && craftResult.func_77978_p().func_74764_b("foodWeight")) {
/*     */         
/*  94 */         craftResult = processFoodInput(e.player, craftResult, craftingInv);
/*     */       } 
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
/*     */   private static ItemStack processFoodInput(EntityPlayer player, ItemStack craftResult, IInventory craftingInv) {
/* 107 */     float finalWeight = 0.0F;
/* 108 */     float finalDecay = 0.0F;
/* 109 */     int[] fuelTasteProfile = { 0, 0, 0, 0, 0 };
/* 110 */     int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/* 111 */     float cookedTime = 0.0F;
/* 112 */     int foodCount = 0;
/* 113 */     int itemCount = 0;
/* 114 */     int foodSlot = 0; int i;
/* 115 */     for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */       
/* 117 */       ItemStack is = craftingInv.func_70301_a(i);
/* 118 */       if (is != null) {
/*     */         
/* 120 */         itemCount++;
/* 121 */         if (is.func_77973_b() instanceof ItemFoodTFC && is.func_77942_o() && is.func_77978_p().func_74764_b("foodWeight")) {
/*     */           
/* 123 */           foodSlot = i;
/* 124 */           if (foodCount == 0) {
/*     */             
/* 126 */             fuelTasteProfile = Food.getFuelProfile(is);
/* 127 */             cookedTasteProfile = Food.getCookedProfile(is);
/* 128 */             cookedTime = Food.getCooked(is);
/*     */           } 
/*     */           
/* 131 */           float inputWeight = Food.getWeight(is);
/* 132 */           float oldInputWeight = inputWeight;
/* 133 */           float inputDecayPercent = Food.getDecay(is) / oldInputWeight;
/* 134 */           float inputDecay = Food.getDecay(is);
/* 135 */           float weightChange = 0.0F;
/*     */ 
/*     */ 
/*     */           
/* 139 */           if (finalWeight < 160.0F && 
/* 140 */             Food.isSameSmoked(cookedTasteProfile, Food.getCookedProfile(is)) && 
/* 141 */             Food.isSameSmoked(fuelTasteProfile, Food.getFuelProfile(is)) && (
/* 142 */             (int)Food.getCooked(is) - 600) / 120 == ((int)cookedTime - 600) / 120) {
/*     */             
/* 144 */             weightChange = Math.min(160.0F - finalWeight, inputWeight);
/* 145 */             inputWeight -= weightChange;
/* 146 */             finalWeight += weightChange;
/*     */           } 
/*     */ 
/*     */           
/* 150 */           if (inputWeight != oldInputWeight) {
/*     */             
/* 152 */             if (inputWeight == 0.0F) {
/*     */               
/* 154 */               if (finalDecay < 0.0F) {
/*     */                 
/* 156 */                 if (inputDecay > finalDecay) {
/* 157 */                   finalDecay = inputDecay;
/*     */                 }
/*     */               } else {
/* 160 */                 finalDecay += inputDecay;
/*     */               } 
/*     */             } else {
/*     */               
/* 164 */               float decayChange = weightChange * inputDecayPercent;
/* 165 */               inputDecay -= decayChange;
/* 166 */               if (finalDecay < 0.0F) {
/*     */                 
/* 168 */                 if (decayChange > finalDecay) {
/* 169 */                   finalDecay = decayChange;
/*     */                 }
/*     */               } else {
/* 172 */                 finalDecay += decayChange;
/*     */               } 
/* 174 */             }  foodCount++;
/*     */           } 
/*     */           
/* 177 */           if (inputWeight > 0.0F) {
/*     */             
/* 179 */             Food.setWeight(is, inputWeight);
/* 180 */             Food.setDecay(is, inputDecay);
/* 181 */             is.field_77994_a++;
/* 182 */             if (is.field_77994_a > 2)
/* 183 */               is.field_77994_a = 2; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 188 */     if (craftResult.field_77994_a == 0) {
/* 189 */       craftResult.field_77994_a = 1;
/*     */     }
/* 191 */     if (itemCount == 1) {
/*     */       
/* 193 */       if (finalDecay > 0.0F)
/*     */       {
/* 195 */         for (i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/*     */           
/* 197 */           ItemStack stack = player.field_71071_by.func_70301_a(i);
/*     */           
/* 199 */           if (stack != null && stack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */ 
/*     */             
/* 202 */             stack.func_77972_a(1, (EntityLivingBase)player);
/* 203 */             if (stack.func_77960_j() >= stack.func_77958_k()) {
/* 204 */               player.field_71071_by.func_70299_a(i, null);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/* 214 */       for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/* 215 */         ItemStack itemstack = craftingInv.func_70301_a(i);
/* 216 */         if (itemstack != null) {
/*     */           
/* 218 */           boolean fullInv = isInvFull(player);
/*     */           
/* 220 */           if (itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife && (!fullInv || !preCrafted) && 
/* 221 */             finalDecay <= 0.0F && finalWeight / 2.0F >= 1.0F) {
/*     */             
/* 223 */             Food.setWeight(craftingInv.func_70301_a(foodSlot), Helper.roundNumber(finalWeight / 2.0F, 100.0F));
/*     */             
/* 225 */             (craftingInv.func_70301_a(foodSlot)).field_77994_a++;
/* 226 */             if ((craftingInv.func_70301_a(foodSlot)).field_77994_a > 2)
/* 227 */               (craftingInv.func_70301_a(foodSlot)).field_77994_a = 2; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 232 */     return craftResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateOutput(EntityPlayer player, ItemStack craftResult, IInventory craftingInv) {
/* 241 */     float finalWeight = 0.0F;
/* 242 */     float finalDecay = 0.0F;
/* 243 */     int sweetMod = -1;
/* 244 */     int sourMod = -1;
/* 245 */     int saltyMod = -1;
/* 246 */     int bitterMod = -1;
/* 247 */     int umamiMod = -1;
/* 248 */     int[] fuelTasteProfile = { 0, 0, 0, 0, 0 };
/* 249 */     int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/* 250 */     float cookedTime = 0.0F;
/* 251 */     String infusion = null;
/* 252 */     boolean salted = true;
/* 253 */     boolean pickled = true;
/* 254 */     boolean brined = true;
/* 255 */     boolean dried = true;
/* 256 */     int driedAmt = 0;
/* 257 */     int foodCount = 0;
/* 258 */     int itemCount = 0; int i;
/* 259 */     for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */       
/* 261 */       if (craftingInv.func_70301_a(i) != null) {
/*     */         
/* 263 */         itemCount++;
/* 264 */         ItemStack is = craftingInv.func_70301_a(i);
/* 265 */         if (is.func_77973_b() instanceof ItemFoodTFC && is.func_77942_o() && is.func_77978_p().func_74764_b("foodWeight")) {
/*     */           
/* 267 */           if (foodCount == 0) {
/*     */             
/* 269 */             fuelTasteProfile = Food.getFuelProfile(is);
/* 270 */             cookedTasteProfile = Food.getCookedProfile(is);
/* 271 */             cookedTime = Food.getCooked(is);
/* 272 */             infusion = Food.getInfusion(is);
/* 273 */             driedAmt = Food.getDried(is);
/*     */           } 
/* 275 */           if (sweetMod == -1) {
/* 276 */             sweetMod = Food.getSweetMod(is);
/* 277 */           } else if (sweetMod != Food.getSweetMod(is)) {
/* 278 */             sweetMod = 0;
/*     */           } 
/* 280 */           if (sourMod == -1) {
/* 281 */             sourMod = Food.getSourMod(is);
/* 282 */           } else if (sourMod != Food.getSourMod(is)) {
/* 283 */             sourMod = 0;
/*     */           } 
/* 285 */           if (saltyMod == -1) {
/* 286 */             saltyMod = Food.getSaltyMod(is);
/* 287 */           } else if (saltyMod != Food.getSaltyMod(is)) {
/* 288 */             saltyMod = 0;
/*     */           } 
/* 290 */           if (bitterMod == -1) {
/* 291 */             bitterMod = Food.getBitterMod(is);
/* 292 */           } else if (bitterMod != Food.getBitterMod(is)) {
/* 293 */             bitterMod = 0;
/*     */           } 
/* 295 */           if (umamiMod == -1) {
/* 296 */             umamiMod = Food.getSavoryMod(is);
/* 297 */           } else if (umamiMod != Food.getSavoryMod(is)) {
/* 298 */             umamiMod = 0;
/*     */           } 
/* 300 */           float inputWeight = Food.getWeight(is);
/* 301 */           float oldInputWeight = inputWeight;
/* 302 */           float inputDecayPercent = Food.getDecay(is) / oldInputWeight;
/* 303 */           float inputDecay = Food.getDecay(is);
/* 304 */           float weightChange = 0.0F;
/*     */           
/* 306 */           salted = (salted && Food.isSalted(is));
/* 307 */           pickled = (pickled && Food.isPickled(is));
/* 308 */           brined = (brined && Food.isBrined(is));
/* 309 */           dried = (dried && Food.isDried(is));
/*     */ 
/*     */ 
/*     */           
/* 313 */           if (finalWeight < 160.0F && 
/* 314 */             Food.isSameSmoked(cookedTasteProfile, Food.getCookedProfile(is)) && 
/* 315 */             Food.isSameSmoked(fuelTasteProfile, Food.getFuelProfile(is)) && (
/* 316 */             (int)Food.getCooked(is) - 600) / 120 == ((int)cookedTime - 600) / 120) {
/*     */             
/* 318 */             weightChange = Math.min(160.0F - finalWeight, inputWeight);
/* 319 */             inputWeight -= weightChange;
/* 320 */             finalWeight += weightChange;
/*     */           } 
/*     */ 
/*     */           
/* 324 */           if (inputWeight != oldInputWeight) {
/*     */             
/* 326 */             if (inputWeight == 0.0F) {
/*     */               
/* 328 */               if (finalDecay < 0.0F) {
/*     */                 
/* 330 */                 if (inputDecay > finalDecay) {
/* 331 */                   finalDecay = inputDecay;
/*     */                 }
/*     */               } else {
/* 334 */                 finalDecay += inputDecay;
/*     */               } 
/*     */             } else {
/*     */               
/* 338 */               float decayChange = weightChange * inputDecayPercent;
/* 339 */               inputDecay -= decayChange;
/* 340 */               if (finalDecay < 0.0F) {
/*     */                 
/* 342 */                 if (decayChange > finalDecay) {
/* 343 */                   finalDecay = decayChange;
/*     */                 }
/*     */               } else {
/* 346 */                 finalDecay += decayChange;
/*     */               } 
/* 348 */             }  foodCount++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 353 */     if (itemCount == 1) {
/*     */       
/* 355 */       if (finalDecay > 0.0F)
/*     */       {
/* 357 */         for (i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/*     */           
/* 359 */           if (player.field_71071_by.func_70301_a(i) != null)
/*     */           {
/* 361 */             if (player.field_71071_by.func_70301_a(i).func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */               
/* 363 */               finalWeight -= finalDecay;
/* 364 */               finalDecay = 0.0F;
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     } else {
/* 373 */       for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 375 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 376 */         if (inputStack != null)
/*     */         {
/*     */ 
/*     */           
/* 380 */           if (inputStack.func_77973_b() == TFCItems.powder && inputStack.func_77960_j() == 9) {
/*     */             
/* 382 */             salted = true;
/*     */           }
/* 384 */           else if (inputStack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */             
/* 386 */             if (finalDecay > 0.0F)
/*     */             {
/* 388 */               finalWeight -= finalDecay;
/* 389 */               finalDecay = 0.0F;
/*     */             }
/* 391 */             else if (finalDecay <= 0.0F)
/*     */             {
/* 393 */               if (!refiningGrain(craftResult, craftingInv) && finalWeight / 2.0F >= 1.0F)
/*     */               {
/* 395 */                 finalWeight /= 2.0F;
/*     */               }
/*     */             }
/*     */           
/* 399 */           } else if (makingDough(craftResult, craftingInv) && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */             
/* 401 */             float grainWeight = Food.getWeight(inputStack);
/* 402 */             float grainDecay = Food.getDecay(inputStack);
/* 403 */             if (grainDecay >= 0.0F)
/* 404 */               grainWeight -= grainDecay; 
/* 405 */             float doughWeight = Math.min(grainWeight, 80.0F) * 2.0F;
/* 406 */             finalWeight = doughWeight;
/* 407 */             finalDecay = 0.0F;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 412 */     craftResult = ItemFoodTFC.createTag(craftResult, Helper.roundNumber(finalWeight, 100.0F), Helper.roundNumber(finalDecay, 100.0F));
/* 413 */     if (sweetMod != 0)
/* 414 */       Food.setSweetMod(craftResult, sweetMod); 
/* 415 */     if (sourMod != 0)
/* 416 */       Food.setSourMod(craftResult, sourMod); 
/* 417 */     if (saltyMod != 0)
/* 418 */       Food.setSaltyMod(craftResult, saltyMod); 
/* 419 */     if (bitterMod != 0)
/* 420 */       Food.setBitterMod(craftResult, bitterMod); 
/* 421 */     if (umamiMod != 0) {
/* 422 */       Food.setSavoryMod(craftResult, umamiMod);
/*     */     }
/* 424 */     if (cookedTime > 0.0F) {
/* 425 */       Food.setCooked(craftResult, cookedTime);
/*     */     }
/* 427 */     for (int fuelTaste : fuelTasteProfile) {
/*     */       
/* 429 */       if (fuelTaste > 0) {
/*     */         
/* 431 */         Food.setFuelProfile(craftResult, fuelTasteProfile);
/*     */         break;
/*     */       } 
/*     */     } 
/* 435 */     for (int cookedTaste : cookedTasteProfile) {
/*     */       
/* 437 */       if (cookedTaste > 0) {
/*     */         
/* 439 */         Food.setCookedProfile(craftResult, cookedTasteProfile);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 444 */     if (salted)
/* 445 */       Food.setSalted(craftResult, salted); 
/* 446 */     if (pickled)
/* 447 */       Food.setPickled(craftResult, pickled); 
/* 448 */     if (brined) {
/* 449 */       Food.setBrined(craftResult, brined);
/*     */     }
/* 451 */     if (dried) {
/* 452 */       Food.setDried(craftResult, 4);
/* 453 */     } else if (driedAmt > 0) {
/* 454 */       Food.setDried(craftResult, driedAmt);
/*     */     } 
/* 456 */     if (infusion != null) {
/* 457 */       Food.setInfusion(craftResult, infusion);
/*     */     }
/* 459 */     if (craftResult.field_77994_a == 0) {
/* 460 */       craftResult.field_77994_a = 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean refiningGrain(ItemStack craftResult, IInventory iinventory) {
/* 465 */     return ((craftResult.func_77973_b() == TFCItems.wheatGrain && gridHasItem(iinventory, TFCItems.wheatWhole)) || (craftResult
/* 466 */       .func_77973_b() == TFCItems.ryeGrain && gridHasItem(iinventory, TFCItems.ryeWhole)) || (craftResult
/* 467 */       .func_77973_b() == TFCItems.oatGrain && gridHasItem(iinventory, TFCItems.oatWhole)) || (craftResult
/* 468 */       .func_77973_b() == TFCItems.barleyGrain && gridHasItem(iinventory, TFCItems.barleyWhole)) || (craftResult
/* 469 */       .func_77973_b() == TFCItems.riceGrain && gridHasItem(iinventory, TFCItems.riceWhole)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean makingDough(ItemStack craftResult, IInventory iinventory) {
/* 474 */     return ((craftResult.func_77973_b() == TFCItems.wheatDough || craftResult.func_77973_b() == TFCItems.ryeDough || craftResult.func_77973_b() == TFCItems.oatDough || craftResult
/* 475 */       .func_77973_b() == TFCItems.barleyDough || craftResult.func_77973_b() == TFCItems.cornmealDough || craftResult
/* 476 */       .func_77973_b() == TFCItems.riceDough) && (
/* 477 */       gridHasItem(iinventory, TFCItems.woodenBucketWater) || gridHasItem(iinventory, TFCItems.redSteelBucketWater)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInvFull(EntityPlayer player) {
/* 482 */     for (int i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
/*     */       
/* 484 */       if (player.field_71071_by.field_70462_a[i] == null)
/* 485 */         return false; 
/*     */     } 
/* 487 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void preCraft(EntityPlayer player, ItemStack craftResult, IInventory craftingInv) {
/* 496 */     preCrafted = true;
/* 497 */     if (refiningGrain(craftResult, craftingInv)) {
/*     */       
/* 499 */       for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 501 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 502 */         if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */           
/* 505 */           float foodWeight = Food.getWeight(inputStack);
/* 506 */           int strawCount = 0;
/*     */           
/* 508 */           for (int j = 0; j < foodWeight; j += 4) {
/* 509 */             strawCount++;
/*     */           }
/* 511 */           TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.straw, strawCount), player);
/*     */         } 
/*     */       } 
/* 514 */     } else if (makingDough(craftResult, craftingInv)) {
/*     */       
/* 516 */       for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 518 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 519 */         if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */           
/* 522 */           float grainWeight = Food.getWeight(inputStack);
/* 523 */           float grainDecay = Food.getDecay(inputStack);
/* 524 */           if (grainDecay >= 0.0F)
/* 525 */             grainWeight -= grainDecay; 
/* 526 */           float doughWeight = Math.min(grainWeight, 80.0F);
/* 527 */           grainWeight -= doughWeight;
/*     */           
/* 529 */           inputStack = ItemFoodTFC.createTag(inputStack, Helper.roundNumber(grainWeight, 100.0F), 0.0F);
/*     */           
/* 531 */           if (grainWeight > 0.0F)
/* 532 */             inputStack.field_77994_a++; 
/*     */         } 
/*     */       } 
/* 535 */     } else if (craftResult.func_77942_o() && craftResult.func_77978_p().func_74764_b("foodWeight")) {
/*     */       
/* 537 */       craftResult = processFoodInput(player, craftResult, craftingInv);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean gridHasItem(IInventory iinventory, Item id) {
/* 543 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 545 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 547 */         if (iinventory.func_70301_a(i).func_77973_b() == id)
/* 548 */           return true;  } 
/*     */     } 
/* 550 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\FoodCraftingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */