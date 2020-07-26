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
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.oredict.OreDictionary;
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
/*  53 */         List<ItemStack> knives = OreDictionary.getOres("itemKnife", false);
/*  54 */         handleItem(e.player, craftingInv, knives);
/*     */         
/*  56 */         for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */           
/*  58 */           ItemStack inputStack = craftingInv.func_70301_a(i);
/*  59 */           if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */             
/*  62 */             float foodWeight = Food.getWeight(inputStack);
/*  63 */             int strawCount = 0;
/*     */             
/*  65 */             for (int j = 0; j < foodWeight; j += 4) {
/*  66 */               strawCount++;
/*     */             }
/*  68 */             TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.straw, strawCount), e.player);
/*     */           } 
/*     */         } 
/*  71 */       } else if (makingDough(craftResult, craftingInv)) {
/*     */         
/*  73 */         for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */           
/*  75 */           ItemStack inputStack = craftingInv.func_70301_a(i);
/*  76 */           if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */             
/*  79 */             float grainWeight = Food.getWeight(inputStack);
/*  80 */             float grainDecay = Food.getDecay(inputStack);
/*  81 */             if (grainDecay >= 0.0F)
/*  82 */               grainWeight -= grainDecay; 
/*  83 */             grainWeight -= Math.min(grainWeight, 80.0F);
/*     */             
/*  85 */             inputStack = ItemFoodTFC.createTag(inputStack, grainWeight, 0.0F);
/*     */             
/*  87 */             if (grainWeight > 0.0F) {
/*     */               
/*  89 */               inputStack.field_77994_a++;
/*  90 */               if (inputStack.field_77994_a > 2)
/*  91 */                 inputStack.field_77994_a = 2; 
/*     */             } 
/*     */           } 
/*     */         } 
/*  95 */       } else if (craftResult.func_77942_o() && craftResult.func_77978_p().func_74764_b("foodWeight")) {
/*     */         
/*  97 */         craftResult = processFoodInput(e.player, craftResult, craftingInv);
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
/* 110 */     float finalWeight = 0.0F;
/* 111 */     float finalDecay = 0.0F;
/* 112 */     int[] fuelTasteProfile = { 0, 0, 0, 0, 0 };
/* 113 */     int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/* 114 */     float cookedTime = 0.0F;
/* 115 */     int foodCount = 0;
/* 116 */     int itemCount = 0;
/* 117 */     int foodSlot = 0; int i;
/* 118 */     for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */       
/* 120 */       ItemStack is = craftingInv.func_70301_a(i);
/* 121 */       if (is != null) {
/*     */         
/* 123 */         itemCount++;
/* 124 */         if (is.func_77973_b() instanceof ItemFoodTFC && is.func_77942_o() && is.func_77978_p().func_74764_b("foodWeight")) {
/*     */           
/* 126 */           foodSlot = i;
/* 127 */           if (foodCount == 0) {
/*     */             
/* 129 */             fuelTasteProfile = Food.getFuelProfile(is);
/* 130 */             cookedTasteProfile = Food.getCookedProfile(is);
/* 131 */             cookedTime = Food.getCooked(is);
/*     */           } 
/*     */           
/* 134 */           float inputWeight = Food.getWeight(is);
/* 135 */           float oldInputWeight = inputWeight;
/* 136 */           float inputDecayPercent = Food.getDecay(is) / oldInputWeight;
/* 137 */           float inputDecay = Food.getDecay(is);
/* 138 */           float weightChange = 0.0F;
/*     */ 
/*     */ 
/*     */           
/* 142 */           if (finalWeight < 160.0F && 
/* 143 */             Food.isSameSmoked(cookedTasteProfile, Food.getCookedProfile(is)) && 
/* 144 */             Food.isSameSmoked(fuelTasteProfile, Food.getFuelProfile(is)) && (
/* 145 */             (int)Food.getCooked(is) - 600) / 120 == ((int)cookedTime - 600) / 120) {
/*     */             
/* 147 */             weightChange = Math.min(160.0F - finalWeight, inputWeight);
/* 148 */             inputWeight -= weightChange;
/* 149 */             finalWeight += weightChange;
/*     */           } 
/*     */ 
/*     */           
/* 153 */           if (inputWeight != oldInputWeight) {
/*     */             
/* 155 */             if (inputWeight == 0.0F) {
/*     */               
/* 157 */               if (finalDecay < 0.0F) {
/*     */                 
/* 159 */                 if (inputDecay > finalDecay) {
/* 160 */                   finalDecay = inputDecay;
/*     */                 }
/*     */               } else {
/* 163 */                 finalDecay += inputDecay;
/*     */               } 
/*     */             } else {
/*     */               
/* 167 */               float decayChange = weightChange * inputDecayPercent;
/* 168 */               inputDecay -= decayChange;
/* 169 */               if (finalDecay < 0.0F) {
/*     */                 
/* 171 */                 if (decayChange > finalDecay) {
/* 172 */                   finalDecay = decayChange;
/*     */                 }
/*     */               } else {
/* 175 */                 finalDecay += decayChange;
/*     */               } 
/* 177 */             }  foodCount++;
/*     */           } 
/*     */           
/* 180 */           if (inputWeight > 0.0F) {
/*     */             
/* 182 */             Food.setWeight(is, inputWeight);
/* 183 */             Food.setDecay(is, inputDecay);
/* 184 */             is.field_77994_a++;
/* 185 */             if (is.field_77994_a > 2)
/* 186 */               is.field_77994_a = 2; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 191 */     if (craftResult.field_77994_a == 0) {
/* 192 */       craftResult.field_77994_a = 1;
/*     */     }
/* 194 */     if (itemCount == 1) {
/*     */       
/* 196 */       if (finalDecay > 0.0F)
/*     */       {
/* 198 */         for (i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/*     */           
/* 200 */           ItemStack stack = player.field_71071_by.func_70301_a(i);
/*     */           
/* 202 */           if (stack != null && stack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */ 
/*     */             
/* 205 */             stack.func_77972_a(1, (EntityLivingBase)player);
/* 206 */             if (stack.func_77960_j() >= stack.func_77958_k()) {
/* 207 */               player.field_71071_by.func_70299_a(i, null);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/* 217 */       for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 219 */         ItemStack itemstack = craftingInv.func_70301_a(i);
/* 220 */         if (itemstack != null) {
/*     */           
/* 222 */           boolean fullInv = isInvFull(player);
/*     */           
/* 224 */           if (itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife && fullInv)
/*     */           {
/* 226 */             if (!preCrafted) {
/*     */ 
/*     */               
/* 229 */               itemstack.field_77994_a++;
/* 230 */               if (itemstack.field_77994_a > 2) {
/* 231 */                 itemstack.field_77994_a = 2;
/*     */               }
/*     */             } 
/*     */           }
/* 235 */           if (itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife && (!fullInv || !preCrafted))
/*     */           {
/* 237 */             if (finalDecay > 0.0F) {
/*     */               
/* 239 */               damageItem(player, craftingInv, i, itemstack.func_77973_b());
/*     */             }
/* 241 */             else if (finalDecay <= 0.0F) {
/*     */               
/* 243 */               if (finalWeight / 2.0F < 1.0F) {
/*     */ 
/*     */                 
/* 246 */                 itemstack.field_77994_a++;
/* 247 */                 if (itemstack.field_77994_a > 2) {
/* 248 */                   itemstack.field_77994_a = 2;
/*     */                 }
/*     */               } else {
/*     */                 
/* 252 */                 damageItem(player, craftingInv, i, itemstack.func_77973_b());
/* 253 */                 Food.setWeight(craftingInv.func_70301_a(foodSlot), Helper.roundNumber(finalWeight / 2.0F, 100.0F));
/*     */                 
/* 255 */                 (craftingInv.func_70301_a(foodSlot)).field_77994_a++;
/* 256 */                 if ((craftingInv.func_70301_a(foodSlot)).field_77994_a > 2)
/* 257 */                   (craftingInv.func_70301_a(foodSlot)).field_77994_a = 2; 
/*     */               } 
/*     */             }  } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 263 */     return craftResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateOutput(EntityPlayer player, ItemStack craftResult, IInventory craftingInv) {
/* 272 */     float finalWeight = 0.0F;
/* 273 */     float finalDecay = 0.0F;
/* 274 */     int sweetMod = -1;
/* 275 */     int sourMod = -1;
/* 276 */     int saltyMod = -1;
/* 277 */     int bitterMod = -1;
/* 278 */     int umamiMod = -1;
/* 279 */     int[] fuelTasteProfile = { 0, 0, 0, 0, 0 };
/* 280 */     int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/* 281 */     float cookedTime = 0.0F;
/* 282 */     String infusion = null;
/* 283 */     boolean salted = true;
/* 284 */     boolean pickled = true;
/* 285 */     boolean brined = true;
/* 286 */     boolean dried = true;
/* 287 */     int driedAmt = 0;
/* 288 */     int foodCount = 0;
/* 289 */     int itemCount = 0; int i;
/* 290 */     for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */       
/* 292 */       if (craftingInv.func_70301_a(i) != null) {
/*     */         
/* 294 */         itemCount++;
/* 295 */         ItemStack is = craftingInv.func_70301_a(i);
/* 296 */         if (is.func_77973_b() instanceof ItemFoodTFC && is.func_77942_o() && is.func_77978_p().func_74764_b("foodWeight")) {
/*     */           
/* 298 */           if (foodCount == 0) {
/*     */             
/* 300 */             fuelTasteProfile = Food.getFuelProfile(is);
/* 301 */             cookedTasteProfile = Food.getCookedProfile(is);
/* 302 */             cookedTime = Food.getCooked(is);
/* 303 */             infusion = Food.getInfusion(is);
/* 304 */             driedAmt = Food.getDried(is);
/*     */           } 
/* 306 */           if (sweetMod == -1) {
/* 307 */             sweetMod = Food.getSweetMod(is);
/* 308 */           } else if (sweetMod != Food.getSweetMod(is)) {
/* 309 */             sweetMod = 0;
/*     */           } 
/* 311 */           if (sourMod == -1) {
/* 312 */             sourMod = Food.getSourMod(is);
/* 313 */           } else if (sourMod != Food.getSourMod(is)) {
/* 314 */             sourMod = 0;
/*     */           } 
/* 316 */           if (saltyMod == -1) {
/* 317 */             saltyMod = Food.getSaltyMod(is);
/* 318 */           } else if (saltyMod != Food.getSaltyMod(is)) {
/* 319 */             saltyMod = 0;
/*     */           } 
/* 321 */           if (bitterMod == -1) {
/* 322 */             bitterMod = Food.getBitterMod(is);
/* 323 */           } else if (bitterMod != Food.getBitterMod(is)) {
/* 324 */             bitterMod = 0;
/*     */           } 
/* 326 */           if (umamiMod == -1) {
/* 327 */             umamiMod = Food.getSavoryMod(is);
/* 328 */           } else if (umamiMod != Food.getSavoryMod(is)) {
/* 329 */             umamiMod = 0;
/*     */           } 
/* 331 */           float inputWeight = Food.getWeight(is);
/* 332 */           float oldInputWeight = inputWeight;
/* 333 */           float inputDecayPercent = Food.getDecay(is) / oldInputWeight;
/* 334 */           float inputDecay = Food.getDecay(is);
/* 335 */           float weightChange = 0.0F;
/*     */           
/* 337 */           salted = (salted && Food.isSalted(is));
/* 338 */           pickled = (pickled && Food.isPickled(is));
/* 339 */           brined = (brined && Food.isBrined(is));
/* 340 */           dried = (dried && Food.isDried(is));
/*     */ 
/*     */ 
/*     */           
/* 344 */           if (finalWeight < 160.0F && 
/* 345 */             Food.isSameSmoked(cookedTasteProfile, Food.getCookedProfile(is)) && 
/* 346 */             Food.isSameSmoked(fuelTasteProfile, Food.getFuelProfile(is)) && (
/* 347 */             (int)Food.getCooked(is) - 600) / 120 == ((int)cookedTime - 600) / 120) {
/*     */             
/* 349 */             weightChange = Math.min(160.0F - finalWeight, inputWeight);
/* 350 */             inputWeight -= weightChange;
/* 351 */             finalWeight += weightChange;
/*     */           } 
/*     */ 
/*     */           
/* 355 */           if (inputWeight != oldInputWeight) {
/*     */             
/* 357 */             if (inputWeight == 0.0F) {
/*     */               
/* 359 */               if (finalDecay < 0.0F) {
/*     */                 
/* 361 */                 if (inputDecay > finalDecay) {
/* 362 */                   finalDecay = inputDecay;
/*     */                 }
/*     */               } else {
/* 365 */                 finalDecay += inputDecay;
/*     */               } 
/*     */             } else {
/*     */               
/* 369 */               float decayChange = weightChange * inputDecayPercent;
/* 370 */               inputDecay -= decayChange;
/* 371 */               if (finalDecay < 0.0F) {
/*     */                 
/* 373 */                 if (decayChange > finalDecay) {
/* 374 */                   finalDecay = decayChange;
/*     */                 }
/*     */               } else {
/* 377 */                 finalDecay += decayChange;
/*     */               } 
/* 379 */             }  foodCount++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 384 */     if (itemCount == 1) {
/*     */       
/* 386 */       if (finalDecay > 0.0F)
/*     */       {
/* 388 */         for (i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/*     */           
/* 390 */           if (player.field_71071_by.func_70301_a(i) != null)
/*     */           {
/* 392 */             if (player.field_71071_by.func_70301_a(i).func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */               
/* 394 */               finalWeight -= finalDecay;
/* 395 */               finalDecay = 0.0F;
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     } else {
/* 404 */       for (i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 406 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 407 */         if (inputStack != null)
/*     */         {
/*     */ 
/*     */           
/* 411 */           if (inputStack.func_77973_b() == TFCItems.powder && inputStack.func_77960_j() == 9) {
/*     */             
/* 413 */             salted = true;
/*     */           }
/* 415 */           else if (inputStack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife) {
/*     */             
/* 417 */             if (finalDecay > 0.0F)
/*     */             {
/* 419 */               finalWeight -= finalDecay;
/* 420 */               finalDecay = 0.0F;
/*     */             }
/* 422 */             else if (finalDecay <= 0.0F)
/*     */             {
/* 424 */               if (!refiningGrain(craftResult, craftingInv) && finalWeight / 2.0F >= 1.0F)
/*     */               {
/* 426 */                 finalWeight /= 2.0F;
/*     */               }
/*     */             }
/*     */           
/* 430 */           } else if (makingDough(craftResult, craftingInv) && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */             
/* 432 */             float grainWeight = Food.getWeight(inputStack);
/* 433 */             float grainDecay = Food.getDecay(inputStack);
/* 434 */             if (grainDecay >= 0.0F)
/* 435 */               grainWeight -= grainDecay; 
/* 436 */             float doughWeight = Math.min(grainWeight, 80.0F) * 2.0F;
/* 437 */             finalWeight = doughWeight;
/* 438 */             finalDecay = 0.0F;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 443 */     craftResult = ItemFoodTFC.createTag(craftResult, Helper.roundNumber(finalWeight, 100.0F), Helper.roundNumber(finalDecay, 100.0F));
/* 444 */     if (sweetMod != 0)
/* 445 */       Food.setSweetMod(craftResult, sweetMod); 
/* 446 */     if (sourMod != 0)
/* 447 */       Food.setSourMod(craftResult, sourMod); 
/* 448 */     if (saltyMod != 0)
/* 449 */       Food.setSaltyMod(craftResult, saltyMod); 
/* 450 */     if (bitterMod != 0)
/* 451 */       Food.setBitterMod(craftResult, bitterMod); 
/* 452 */     if (umamiMod != 0) {
/* 453 */       Food.setSavoryMod(craftResult, umamiMod);
/*     */     }
/* 455 */     if (cookedTime > 0.0F) {
/* 456 */       Food.setCooked(craftResult, cookedTime);
/*     */     }
/* 458 */     for (int fuelTaste : fuelTasteProfile) {
/*     */       
/* 460 */       if (fuelTaste > 0) {
/*     */         
/* 462 */         Food.setFuelProfile(craftResult, fuelTasteProfile);
/*     */         break;
/*     */       } 
/*     */     } 
/* 466 */     for (int cookedTaste : cookedTasteProfile) {
/*     */       
/* 468 */       if (cookedTaste > 0) {
/*     */         
/* 470 */         Food.setCookedProfile(craftResult, cookedTasteProfile);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 475 */     if (salted)
/* 476 */       Food.setSalted(craftResult, salted); 
/* 477 */     if (pickled)
/* 478 */       Food.setPickled(craftResult, pickled); 
/* 479 */     if (brined) {
/* 480 */       Food.setBrined(craftResult, brined);
/*     */     }
/* 482 */     if (dried) {
/* 483 */       Food.setDried(craftResult, 4);
/* 484 */     } else if (driedAmt > 0) {
/* 485 */       Food.setDried(craftResult, driedAmt);
/*     */     } 
/* 487 */     if (infusion != null) {
/* 488 */       Food.setInfusion(craftResult, infusion);
/*     */     }
/* 490 */     if (craftResult.field_77994_a == 0) {
/* 491 */       craftResult.field_77994_a = 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean refiningGrain(ItemStack craftResult, IInventory iinventory) {
/* 496 */     return ((craftResult.func_77973_b() == TFCItems.wheatGrain && gridHasItem(iinventory, TFCItems.wheatWhole)) || (craftResult
/* 497 */       .func_77973_b() == TFCItems.ryeGrain && gridHasItem(iinventory, TFCItems.ryeWhole)) || (craftResult
/* 498 */       .func_77973_b() == TFCItems.oatGrain && gridHasItem(iinventory, TFCItems.oatWhole)) || (craftResult
/* 499 */       .func_77973_b() == TFCItems.barleyGrain && gridHasItem(iinventory, TFCItems.barleyWhole)) || (craftResult
/* 500 */       .func_77973_b() == TFCItems.riceGrain && gridHasItem(iinventory, TFCItems.riceWhole)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean makingDough(ItemStack craftResult, IInventory iinventory) {
/* 505 */     return ((craftResult.func_77973_b() == TFCItems.wheatDough || craftResult.func_77973_b() == TFCItems.ryeDough || craftResult.func_77973_b() == TFCItems.oatDough || craftResult
/* 506 */       .func_77973_b() == TFCItems.barleyDough || craftResult.func_77973_b() == TFCItems.cornmealDough || craftResult
/* 507 */       .func_77973_b() == TFCItems.riceDough) && (
/* 508 */       gridHasItem(iinventory, TFCItems.woodenBucketWater) || gridHasItem(iinventory, TFCItems.redSteelBucketWater)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInvFull(EntityPlayer player) {
/* 513 */     for (int i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
/*     */       
/* 515 */       if (player.field_71071_by.field_70462_a[i] == null)
/* 516 */         return false; 
/*     */     } 
/* 518 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void preCraft(EntityPlayer player, ItemStack craftResult, IInventory craftingInv) {
/* 527 */     preCrafted = true;
/* 528 */     if (refiningGrain(craftResult, craftingInv)) {
/*     */       
/* 530 */       List<ItemStack> knives = OreDictionary.getOres("itemKnife", false);
/* 531 */       handleItem(player, craftingInv, knives);
/* 532 */       for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 534 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 535 */         if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */           
/* 538 */           float foodWeight = Food.getWeight(inputStack);
/* 539 */           int strawCount = 0;
/*     */           
/* 541 */           for (int j = 0; j < foodWeight; j += 4) {
/* 542 */             strawCount++;
/*     */           }
/* 544 */           TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.straw, strawCount), player);
/*     */         } 
/*     */       } 
/* 547 */     } else if (makingDough(craftResult, craftingInv)) {
/*     */       
/* 549 */       for (int i = 0; i < craftingInv.func_70302_i_(); i++) {
/*     */         
/* 551 */         ItemStack inputStack = craftingInv.func_70301_a(i);
/* 552 */         if (inputStack != null && inputStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */ 
/*     */           
/* 555 */           float grainWeight = Food.getWeight(inputStack);
/* 556 */           float grainDecay = Food.getDecay(inputStack);
/* 557 */           if (grainDecay >= 0.0F)
/* 558 */             grainWeight -= grainDecay; 
/* 559 */           float doughWeight = Math.min(grainWeight, 80.0F);
/* 560 */           grainWeight -= doughWeight;
/*     */           
/* 562 */           inputStack = ItemFoodTFC.createTag(inputStack, Helper.roundNumber(grainWeight, 100.0F), 0.0F);
/*     */           
/* 564 */           if (grainWeight > 0.0F)
/* 565 */             inputStack.field_77994_a++; 
/*     */         } 
/*     */       } 
/* 568 */     } else if (craftResult.func_77942_o() && craftResult.func_77978_p().func_74764_b("foodWeight")) {
/*     */       
/* 570 */       craftResult = processFoodInput(player, craftResult, craftingInv);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean gridHasItem(IInventory iinventory, Item id) {
/* 576 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 578 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 580 */         if (iinventory.func_70301_a(i).func_77973_b() == id)
/* 581 */           return true;  } 
/*     */     } 
/* 583 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, Item[] items) {
/* 588 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 590 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 592 */         for (int j = 0; j < items.length; j++)
/* 593 */           damageItem(entityplayer, iinventory, i, items[j]); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, List<ItemStack> items) {
/* 599 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 601 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 603 */         for (ItemStack is : items)
/* 604 */           damageItem(entityplayer, iinventory, i, is.func_77973_b()); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void damageItem(EntityPlayer entityplayer, IInventory iinventory, int i, Item item) {
/* 610 */     if (iinventory.func_70301_a(i).func_77973_b() == item) {
/*     */       
/* 612 */       int index = i;
/* 613 */       ItemStack is = iinventory.func_70301_a(index).func_77946_l();
/* 614 */       if (is != null) {
/*     */         
/* 616 */         is.func_77972_a(1, (EntityLivingBase)entityplayer);
/* 617 */         if (is.func_77960_j() != 0 || entityplayer.field_71075_bZ.field_75098_d) {
/*     */           
/* 619 */           iinventory.func_70299_a(index, is);
/* 620 */           (iinventory.func_70301_a(index)).field_77994_a++;
/* 621 */           if ((iinventory.func_70301_a(index)).field_77994_a > 2)
/* 622 */             (iinventory.func_70301_a(index)).field_77994_a = 2; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\FoodCraftingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */