/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Render.EntityRendererTFC;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.FoodRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FoodStatsTFC
/*     */ {
/*  27 */   private boolean updateStats = !TFCOptions.enableDebugMode;
/*     */ 
/*     */   
/*  30 */   public float stomachLevel = 24.0F;
/*  31 */   private float stomachMax = 24.0F;
/*  32 */   private float prevFoodLevel = 24.0F;
/*     */   
/*  34 */   private ResourceLocation drunkBlur = new ResourceLocation("shaders/post/blur.json");
/*  35 */   private ResourceLocation wastedBlur = new ResourceLocation("shaders/post/blur.json");
/*     */   
/*  37 */   public float nutrFruit = 1.0F;
/*  38 */   public float nutrVeg = 1.0F;
/*  39 */   public float nutrGrain = 1.0F;
/*  40 */   public float nutrDairy = 1.0F;
/*  41 */   public float nutrProtein = 1.0F;
/*     */ 
/*     */   
/*     */   private boolean sendUpdate = true;
/*     */ 
/*     */   
/*     */   public long soberTime;
/*     */   
/*     */   private float satisfaction;
/*     */   
/*     */   private float foodExhaustionLevel;
/*     */   
/*     */   public long foodTimer;
/*     */   
/*     */   public long foodHealTimer;
/*     */   
/*  57 */   public float waterLevel = 48000.0F;
/*     */   
/*     */   public long waterTimer;
/*     */   public EntityPlayer player;
/*  61 */   private long nameSeed = Long.MIN_VALUE;
/*     */   
/*     */   private boolean satFruit;
/*     */   private boolean satVeg;
/*     */   private boolean satGrain;
/*     */   private boolean satProtein;
/*     */   private boolean satDairy;
/*     */   
/*     */   public FoodStatsTFC(EntityPlayer player) {
/*  70 */     this.player = player;
/*  71 */     this.waterTimer = Math.max(TFC_Time.getTotalTicks(), TFC_Time.startTime);
/*  72 */     this.foodTimer = Math.max(TFC_Time.getTotalTicks(), TFC_Time.startTime);
/*  73 */     this.foodHealTimer = Math.max(TFC_Time.getTotalTicks(), TFC_Time.startTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(EntityPlayer player) {
/*  81 */     if (!player.field_70170_p.field_72995_K) {
/*     */       
/*  83 */       BodyTempStats bodyTemp = TFC_Core.getBodyTempStats(player);
/*  84 */       float temp = TFC_Climate.getHeightAdjustedTemp(player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */       
/*  86 */       float tempWaterMod = temp;
/*  87 */       if (tempWaterMod >= 25.0F) {
/*  88 */         tempWaterMod = (tempWaterMod - 25.0F) * 0.2F;
/*     */       } else {
/*  90 */         tempWaterMod = 0.0F;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  95 */       if (this.foodTimer < TFC_Time.startTime) {
/*     */         
/*  97 */         this.foodTimer = TFC_Time.startTime;
/*  98 */         this.foodHealTimer = TFC_Time.startTime;
/*  99 */         this.waterTimer = TFC_Time.startTime;
/*     */       } 
/*     */       
/* 102 */       if (TFC_Time.getTotalTicks() - this.foodTimer >= 1000L && !player.field_71075_bZ.field_75098_d && this.updateStats) {
/*     */         
/* 104 */         this.foodTimer += 1000L;
/* 105 */         float drainMult = 1.0F;
/* 106 */         if (player.func_70608_bn())
/*     */         {
/* 108 */           drainMult = 0.5F;
/*     */         }
/*     */         
/* 111 */         if (player.func_70051_ag())
/* 112 */           this.waterLevel -= 5.0F + tempWaterMod; 
/* 113 */         if (!player.field_71075_bZ.field_75098_d && this.updateStats) {
/* 114 */           this.waterLevel -= bodyTemp.getExtraWater() * drainMult;
/*     */         }
/*     */         
/* 117 */         float hunger = (1.0F + this.foodExhaustionLevel + bodyTemp.getExtraFood()) * drainMult;
/* 118 */         if (this.satisfaction >= hunger) {
/*     */           
/* 120 */           this.satisfaction -= hunger;
/* 121 */           hunger = 0.0F;
/* 122 */           this.foodExhaustionLevel = 0.0F;
/*     */         }
/*     */         else {
/*     */           
/* 126 */           hunger -= this.satisfaction;
/* 127 */           this.satisfaction = 0.0F;
/* 128 */           this.foodExhaustionLevel = 0.0F;
/*     */         } 
/* 130 */         this.stomachLevel = Math.max(this.stomachLevel - hunger, 0.0F);
/*     */         
/* 132 */         if (this.satisfaction == 0.0F) {
/*     */           
/* 134 */           this.satProtein = false; this.satFruit = false; this.satVeg = false; this.satDairy = false; this.satGrain = false;
/*     */         } 
/*     */         
/* 137 */         if (this.stomachLevel <= 0.0F) {
/*     */           
/* 139 */           reduceNutrition(0.0024F);
/*     */         }
/* 141 */         else if (this.satisfaction <= 0.0F) {
/*     */           
/* 143 */           reduceNutrition(8.0E-4F);
/*     */         }
/*     */         else {
/*     */           
/* 147 */           if (this.satProtein)
/* 148 */             addNutrition(EnumFoodGroup.Protein, this.satisfaction * (1.0F - this.nutrProtein) / 100.0F, false); 
/* 149 */           if (this.satGrain)
/* 150 */             addNutrition(EnumFoodGroup.Grain, this.satisfaction * (1.0F - this.nutrGrain) / 100.0F, false); 
/* 151 */           if (this.satVeg)
/* 152 */             addNutrition(EnumFoodGroup.Vegetable, this.satisfaction * (1.0F - this.nutrVeg) / 100.0F, false); 
/* 153 */           if (this.satFruit)
/* 154 */             addNutrition(EnumFoodGroup.Fruit, this.satisfaction * (1.0F - this.nutrFruit) / 100.0F, false); 
/* 155 */           if (this.satDairy)
/* 156 */             addNutrition(EnumFoodGroup.Dairy, this.satisfaction * (1.0F - this.nutrDairy) / 100.0F, false); 
/*     */         } 
/* 158 */         this.sendUpdate = true;
/*     */       } 
/*     */ 
/*     */       
/* 162 */       if (TFC_Time.getTotalTicks() - this.foodHealTimer >= 500L) {
/*     */         
/* 164 */         this.foodHealTimer += 500L;
/*     */         
/* 166 */         if (this.stomachLevel >= getMaxStomach(player) / 4.0F && player.func_70996_bM())
/*     */         {
/*     */           
/* 169 */           player.func_70691_i((int)(player.func_110138_aP() * 0.01F));
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       if (!player.field_71075_bZ.field_75098_d && this.updateStats)
/*     */       {
/* 181 */         for (; this.waterTimer < TFC_Time.getTotalTicks(); this.waterTimer++) {
/*     */ 
/*     */           
/* 184 */           this.waterLevel -= 1.0F + tempWaterMod / 2.0F;
/* 185 */           if (this.waterLevel < 0.0F)
/* 186 */             this.waterLevel = 0.0F; 
/* 187 */           if (!TFC_Core.isPlayerInDebugMode(player) && this.waterLevel == 0.0F && temp > 35.0F) {
/* 188 */             player.func_70097_a((new DamageSource("heatStroke")).func_76348_h().func_151518_m(), 2.0F);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clientUpdate() {
/* 196 */     if ((Minecraft.func_71410_x()).field_71460_t instanceof EntityRendererTFC) {
/*     */       
/* 198 */       EntityRendererTFC erTFC = (EntityRendererTFC)(Minecraft.func_71410_x()).field_71460_t;
/* 199 */       if ((erTFC.getCurrentShaderLocation() == null || !erTFC.getCurrentShaderLocation().equals(this.wastedBlur)) && this.soberTime > TFC_Time.getTotalTicks() + 8000L) {
/*     */         
/* 201 */         erTFC.setManualShader(this.wastedBlur);
/*     */       }
/* 203 */       else if ((erTFC.getCurrentShaderLocation() == null || !erTFC.getCurrentShaderLocation().equals(this.drunkBlur)) && this.soberTime > TFC_Time.getTotalTicks() + 4000L && this.soberTime <= TFC_Time.getTotalTicks() + 8000L) {
/*     */         
/* 205 */         erTFC.setManualShader(this.drunkBlur);
/*     */       }
/* 207 */       else if (erTFC.getManualShaderBeingUsed() && this.soberTime <= TFC_Time.getTotalTicks() + 4000L) {
/*     */         
/* 209 */         erTFC.deactivateManualShader();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reduceNutrition(float amount) {
/* 216 */     this.nutrFruit = Math.max(this.nutrFruit - amount + this.foodExhaustionLevel, 0.0F);
/* 217 */     this.nutrVeg = Math.max(this.nutrVeg - amount + this.foodExhaustionLevel, 0.0F);
/* 218 */     this.nutrGrain = Math.max(this.nutrGrain - amount + this.foodExhaustionLevel, 0.0F);
/* 219 */     this.nutrProtein = Math.max(this.nutrProtein - amount + this.foodExhaustionLevel, 0.0F);
/* 220 */     this.nutrDairy = Math.max(this.nutrDairy - amount + this.foodExhaustionLevel, 0.0F);
/*     */     
/* 222 */     this.sendUpdate = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxWater(EntityPlayer player) {
/* 227 */     return 48000 + 200 * player.field_71068_ca;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMaxStomach(EntityPlayer player) {
/* 232 */     return this.stomachMax;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFoodLevel() {
/* 240 */     return this.stomachLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float getPrevFoodLevel() {
/* 246 */     return this.prevFoodLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needFood() {
/* 254 */     return (this.stomachLevel < getMaxStomach(this.player) && (getMaxStomach(this.player) - this.stomachLevel) > 0.1D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needDrink() {
/* 259 */     return (this.waterLevel < (getMaxWater(this.player) - 500));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readNBT(NBTTagCompound par1NBTTagCompound) {
/* 267 */     if (par1NBTTagCompound.func_74764_b("foodCompound")) {
/*     */       
/* 269 */       NBTTagCompound foodCompound = par1NBTTagCompound.func_74775_l("foodCompound");
/* 270 */       this.waterLevel = foodCompound.func_74760_g("waterLevel");
/* 271 */       this.stomachLevel = foodCompound.func_74760_g("foodLevel");
/* 272 */       this.foodTimer = foodCompound.func_74763_f("foodTickTimer");
/* 273 */       this.foodHealTimer = foodCompound.func_74763_f("foodHealTimer");
/* 274 */       this.waterTimer = foodCompound.func_74763_f("waterTimer");
/* 275 */       this.soberTime = foodCompound.func_74763_f("soberTime");
/* 276 */       this.satisfaction = foodCompound.func_74760_g("foodSaturationLevel");
/* 277 */       this.foodExhaustionLevel = foodCompound.func_74760_g("foodExhaustionLevel");
/* 278 */       this.nutrFruit = foodCompound.func_74760_g("nutrFruit");
/* 279 */       this.nutrVeg = foodCompound.func_74760_g("nutrVeg");
/* 280 */       this.nutrGrain = foodCompound.func_74760_g("nutrGrain");
/* 281 */       this.nutrProtein = foodCompound.func_74760_g("nutrProtein");
/* 282 */       this.nutrDairy = foodCompound.func_74760_g("nutrDairy");
/* 283 */       this.sendUpdate = foodCompound.func_74767_n("shouldSendUpdate");
/* 284 */       this.satFruit = foodCompound.func_74767_n("satFruit");
/* 285 */       this.satVeg = foodCompound.func_74767_n("satVeg");
/* 286 */       this.satGrain = foodCompound.func_74767_n("satGrain");
/* 287 */       this.satProtein = foodCompound.func_74767_n("satProtein");
/* 288 */       this.satDairy = foodCompound.func_74767_n("satDairy");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeNBT(NBTTagCompound nbt) {
/* 297 */     NBTTagCompound foodNBT = new NBTTagCompound();
/* 298 */     foodNBT.func_74776_a("waterLevel", this.waterLevel);
/* 299 */     foodNBT.func_74776_a("foodLevel", this.stomachLevel);
/* 300 */     foodNBT.func_74772_a("foodTickTimer", this.foodTimer);
/* 301 */     foodNBT.func_74772_a("foodHealTimer", this.foodHealTimer);
/* 302 */     foodNBT.func_74772_a("waterTimer", this.waterTimer);
/* 303 */     foodNBT.func_74772_a("soberTime", this.soberTime);
/* 304 */     foodNBT.func_74776_a("foodSaturationLevel", this.satisfaction);
/* 305 */     foodNBT.func_74776_a("foodExhaustionLevel", this.foodExhaustionLevel);
/* 306 */     foodNBT.func_74776_a("nutrFruit", this.nutrFruit);
/* 307 */     foodNBT.func_74776_a("nutrVeg", this.nutrVeg);
/* 308 */     foodNBT.func_74776_a("nutrGrain", this.nutrGrain);
/* 309 */     foodNBT.func_74776_a("nutrProtein", this.nutrProtein);
/* 310 */     foodNBT.func_74776_a("nutrDairy", this.nutrDairy);
/* 311 */     foodNBT.func_74757_a("shouldSendUpdate", this.sendUpdate);
/* 312 */     foodNBT.func_74757_a("satFruit", this.satFruit);
/* 313 */     foodNBT.func_74757_a("satVeg", this.satVeg);
/* 314 */     foodNBT.func_74757_a("satGrain", this.satGrain);
/* 315 */     foodNBT.func_74757_a("satProtein", this.satProtein);
/* 316 */     foodNBT.func_74757_a("satDairy", this.satDairy);
/* 317 */     nbt.func_74782_a("foodCompound", (NBTBase)foodNBT);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFoodExhaustion(float par1) {
/* 322 */     this.foodExhaustionLevel = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSatisfaction() {
/* 332 */     return this.satisfaction;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFoodLevel(float par1) {
/* 337 */     if (par1 != this.stomachLevel)
/* 338 */       this.sendUpdate = true; 
/* 339 */     this.stomachLevel = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSatisfaction(float par1, int[] fg) {
/* 345 */     this.satisfaction = Math.min(par1, 10.0F);
/* 346 */     for (int i = 0; i < fg.length; i++) {
/*     */       
/* 348 */       if (fg[i] != -1) {
/*     */         
/* 350 */         EnumFoodGroup efg = FoodRegistry.getInstance().getFoodGroup(fg[i]);
/* 351 */         switch (efg) {
/*     */           case Protein:
/* 353 */             this.satProtein = true; break;
/* 354 */           case Grain: this.satGrain = true; break;
/* 355 */           case Fruit: this.satFruit = true; break;
/* 356 */           case Vegetable: this.satVeg = true; break;
/* 357 */           case Dairy: this.satDairy = true;
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPlayerFoodSeed() {
/* 367 */     if (this.nameSeed == Long.MIN_VALUE) {
/*     */       
/* 369 */       long seed = 0L;
/* 370 */       byte[] nameBytes = this.player.func_70005_c_().getBytes();
/* 371 */       for (byte b : nameBytes)
/* 372 */         seed += b; 
/* 373 */       this.nameSeed = seed + this.player.field_70170_p.func_72905_C();
/*     */     } 
/* 375 */     return this.nameSeed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getPrefTaste() {
/* 383 */     Random r = new Random(getPlayerFoodSeed());
/* 384 */     return new int[] { 20 + r
/* 385 */         .nextInt(70), 20 + r.nextInt(70), 20 + r.nextInt(70), 20 + r.nextInt(70), 20 + r.nextInt(70) };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getTasteFactor(ItemStack food) {
/* 391 */     float tasteFactor = 0.85F;
/* 392 */     int[] tastePref = getPrefTaste();
/*     */     
/* 394 */     tasteFactor += getTasteDistanceFactor(tastePref[0], ((IFood)food.func_77973_b()).getTasteSweet(food));
/* 395 */     tasteFactor += getTasteDistanceFactor(tastePref[1], ((IFood)food.func_77973_b()).getTasteSour(food));
/* 396 */     tasteFactor += getTasteDistanceFactor(tastePref[2], ((IFood)food.func_77973_b()).getTasteSalty(food));
/* 397 */     tasteFactor += getTasteDistanceFactor(tastePref[3], ((IFood)food.func_77973_b()).getTasteBitter(food));
/* 398 */     tasteFactor += getTasteDistanceFactor(tastePref[4], ((IFood)food.func_77973_b()).getTasteSavory(food));
/*     */     
/* 400 */     return tasteFactor;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTasteDistanceFactor(int pref, int val) {
/* 405 */     int abs = Math.abs(pref - val);
/* 406 */     if (abs < 11)
/* 407 */       return (10 - abs) * 0.01F; 
/* 408 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getNutritionHealthModifier() {
/* 413 */     float nMod = 0.0F;
/* 414 */     nMod += 0.2F * this.nutrFruit;
/* 415 */     nMod += 0.2F * this.nutrVeg;
/* 416 */     nMod += 0.2F * this.nutrGrain;
/* 417 */     nMod += 0.2F * this.nutrProtein;
/* 418 */     nMod += 0.2F * this.nutrDairy;
/* 419 */     return Math.max(nMod, 0.05F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMaxHealth(EntityPlayer player) {
/* 424 */     return 
/* 425 */       (int)(Math.min(1000 + player.field_71068_ca * TFCOptions.healthGainRate, TFCOptions.healthGainCap) * TFC_Core.getPlayerFoodStats(player).getNutritionHealthModifier());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean reduceFood(ItemStack is, float amount) {
/* 434 */     if (is.func_77942_o()) {
/*     */       
/* 436 */       float weight = Food.getWeight(is);
/* 437 */       float decay = Food.getDecay(is);
/* 438 */       if (decay >= 0.0F && weight - decay - amount <= 0.0F)
/* 439 */         return true; 
/* 440 */       if (decay <= 0.0F && weight - amount <= 0.0F) {
/* 441 */         return true;
/*     */       }
/*     */       
/* 444 */       Food.setWeight(is, weight - amount);
/*     */     } 
/*     */     
/* 447 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addNutrition(EnumFoodGroup fg, float foodAmt) {
/* 452 */     addNutrition(fg, foodAmt, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addNutrition(EnumFoodGroup fg, float foodAmt, boolean shouldDoMath) {
/* 457 */     float amount = foodAmt;
/* 458 */     if (shouldDoMath)
/* 459 */       amount = foodAmt / 5.0F / 50.0F; 
/* 460 */     switch (fg) {
/*     */       
/*     */       case Dairy:
/* 463 */         this.nutrDairy = Math.min(this.nutrDairy + amount, 1.0F);
/*     */         break;
/*     */       case Fruit:
/* 466 */         this.nutrFruit = Math.min(this.nutrFruit + amount, 1.0F);
/*     */         break;
/*     */       case Grain:
/* 469 */         this.nutrGrain = Math.min(this.nutrGrain + amount, 1.0F);
/*     */         break;
/*     */       case Protein:
/* 472 */         this.nutrProtein = Math.min(this.nutrProtein + amount, 1.0F);
/*     */         break;
/*     */       case Vegetable:
/* 475 */         this.nutrVeg = Math.min(this.nutrVeg + amount, 1.0F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldSendUpdate() {
/* 484 */     return this.sendUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void restoreWater(EntityPlayer player, int w) {
/* 489 */     this.waterLevel = Math.min(this.waterLevel + w, getMaxWater(player));
/* 490 */     this.sendUpdate = true;
/* 491 */     writeNBT(player.getEntityData());
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetTimers() {
/* 496 */     this.waterTimer = TFC_Time.getTotalTicks();
/* 497 */     this.foodTimer = TFC_Time.getTotalTicks();
/* 498 */     this.foodHealTimer = TFC_Time.getTotalTicks();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void consumeAlcohol() {
/* 504 */     if (this.soberTime <= TFC_Time.getTotalTicks()) {
/* 505 */       this.soberTime = TFC_Time.getTotalTicks() + this.player.field_70170_p.field_73012_v.nextInt(1000) + 400L;
/*     */     } else {
/* 507 */       this.soberTime += (this.player.field_70170_p.field_73012_v.nextInt(1000) + 400);
/* 508 */     }  this.sendUpdate = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\FoodStatsTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */