/*     */ package com.bioxx.tfc.api;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.Random;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Food
/*     */ {
/*     */   public static final String DECAY_TAG = "foodDecay";
/*     */   public static final String DECAY_TIMER_TAG = "decayTimer";
/*     */   public static final String DECAY_RATE_TAG = "decayRate";
/*     */   public static final String WEIGHT_TAG = "foodWeight";
/*     */   public static final String PROCESSING_TAG = "Processing Tag";
/*     */   public static final String BRINED_TAG = "Brined";
/*     */   public static final String PICKLED_TAG = "Pickled";
/*     */   public static final String SALTED_TAG = "Salted";
/*     */   public static final String COOKED_TAG = "Cooked";
/*     */   public static final String COOKED_PROFILE_TAG = "CookedProfile";
/*     */   public static final String FUEL_PROFILE_TAG = "FuelProfile";
/*     */   public static final String DRIED_TAG = "Dried";
/*     */   public static final String SMOKE_COUNTER_TAG = "SmokeCounter";
/*     */   public static final String SWEET_MOD_TAG = "tasteSweetMod";
/*     */   public static final String SOUR_MOD_TAG = "tasteSourMod";
/*     */   public static final String SALTY_MOD_TAG = "tasteSaltyMod";
/*     */   public static final String BITTER_MOD_TAG = "tasteBitterMod";
/*     */   public static final String UMAMI_MOD_TAG = "tasteUmamiMod";
/*     */   public static final String MEAL_SKILL_TAG = "mealSkill";
/*     */   public static final String INFUSION_TAG = "Infusion";
/*     */   public static final String FOOD_GROUP_TAG = "FG";
/*     */   public static final int DRYHOURS = 4;
/*     */   public static final int SMOKEHOURS = 12;
/*     */   
/*     */   private static NBTTagCompound getProcTag(ItemStack is) {
/*  42 */     if (is.func_77942_o() && is.func_77978_p().func_74764_b("Processing Tag"))
/*     */     {
/*  44 */       return (NBTTagCompound)is.func_77978_p().func_74781_a("Processing Tag");
/*     */     }
/*     */     
/*  47 */     return new NBTTagCompound();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setProcTag(ItemStack is, NBTTagCompound nbt) {
/*  52 */     if (!is.func_77942_o())
/*  53 */       is.func_77982_d(new NBTTagCompound()); 
/*  54 */     is.func_77978_p().func_74782_a("Processing Tag", (NBTBase)nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static NBTTagCompound getNBT(ItemStack is) {
/*  59 */     if (is.func_77942_o())
/*     */     {
/*  61 */       return is.func_77978_p();
/*     */     }
/*     */ 
/*     */     
/*  65 */     TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + 
/*  66 */         TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/*  67 */     return new NBTTagCompound();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean areEqual(ItemStack is1, ItemStack is2) {
/*  73 */     return (isBrined(is1) == isBrined(is2) && 
/*  74 */       isPickled(is1) == isPickled(is2) && 
/*  75 */       isCooked(is1) == isCooked(is2) && 
/*  76 */       isDried(is1) == isDried(is2) && 
/*  77 */       isSalted(is1) == isSalted(is2) && ((
/*  78 */       isInfused(is1) && isInfused(is2) && getInfusion(is1).equals(getInfusion(is2))) || (
/*  79 */       !isInfused(is1) && !isInfused(is2))) && ((
/*  80 */       isSmoked(is1) && isSmoked(is2) && isSameSmoked(is1, is2)) || (
/*  81 */       !isSmoked(is1) && !isSmoked(is2))));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBrined(ItemStack is) {
/*  86 */     NBTTagCompound nbt = getProcTag(is);
/*  87 */     return (nbt.func_74764_b("Brined") && nbt.func_74767_n("Brined"));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setBrined(ItemStack is, boolean value) {
/*  92 */     NBTTagCompound nbt = getProcTag(is);
/*  93 */     nbt.func_74757_a("Brined", value);
/*  94 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPickled(ItemStack is) {
/*  99 */     NBTTagCompound nbt = getProcTag(is);
/* 100 */     return (nbt.func_74764_b("Pickled") && nbt.func_74767_n("Pickled"));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setPickled(ItemStack is, boolean value) {
/* 105 */     NBTTagCompound nbt = getProcTag(is);
/* 106 */     nbt.func_74757_a("Pickled", value);
/* 107 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSalted(ItemStack is) {
/* 112 */     NBTTagCompound nbt = getProcTag(is);
/* 113 */     return (nbt.func_74764_b("Salted") && nbt.func_74767_n("Salted"));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSalted(ItemStack is, boolean value) {
/* 118 */     NBTTagCompound nbt = getProcTag(is);
/* 119 */     nbt.func_74757_a("Salted", value);
/* 120 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isCooked(ItemStack is) {
/* 125 */     NBTTagCompound nbt = getProcTag(is);
/* 126 */     return (nbt.func_74764_b("Cooked") && nbt.func_74760_g("Cooked") > 600.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getCooked(ItemStack is) {
/* 131 */     NBTTagCompound nbt = getProcTag(is);
/* 132 */     if (nbt.func_74764_b("Cooked")) {
/* 133 */       return nbt.func_74760_g("Cooked");
/*     */     }
/* 135 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCooked(ItemStack is, float value) {
/* 140 */     NBTTagCompound nbt = getProcTag(is);
/* 141 */     nbt.func_74776_a("Cooked", value);
/* 142 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getCookedProfile(ItemStack is) {
/* 147 */     NBTTagCompound nbt = getProcTag(is);
/* 148 */     if (nbt.func_74764_b("CookedProfile")) {
/* 149 */       return nbt.func_74759_k("CookedProfile");
/*     */     }
/* 151 */     return new int[] { 0, 0, 0, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCookedProfile(ItemStack is, int[] value) {
/* 156 */     NBTTagCompound nbt = getProcTag(is);
/* 157 */     nbt.func_74783_a("CookedProfile", value);
/* 158 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getFuelProfile(ItemStack is) {
/* 163 */     NBTTagCompound nbt = getProcTag(is);
/* 164 */     if (nbt.func_74764_b("FuelProfile")) {
/* 165 */       return nbt.func_74759_k("FuelProfile");
/*     */     }
/* 167 */     return new int[] { 0, 0, 0, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setFuelProfile(ItemStack is, int[] value) {
/* 172 */     NBTTagCompound nbt = getProcTag(is);
/* 173 */     nbt.func_74783_a("FuelProfile", value);
/* 174 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSmoked(ItemStack is) {
/* 179 */     NBTTagCompound nbt = getProcTag(is);
/* 180 */     return (nbt.func_74764_b("FuelProfile") && !isSameSmoked(getFuelProfile(is), new int[] { 0, 0, 0, 0, 0 }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSameSmoked(ItemStack is1, ItemStack is2) {
/* 186 */     int[] f1 = getFuelProfile(is1);
/* 187 */     int[] f2 = getFuelProfile(is2);
/* 188 */     return (f1[0] == f2[0] && f1[1] == f2[1] && f1[2] == f2[2] && f1[3] == f2[3] && f1[4] == f2[4]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSameSmoked(int[] f1, int[] f2) {
/* 193 */     return (f1[0] == f2[0] && f1[1] == f2[1] && f1[2] == f2[2] && f1[3] == f2[3] && f1[4] == f2[4]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDecay(ItemStack is, float value) {
/* 198 */     NBTTagCompound nbt = getNBT(is);
/* 199 */     nbt.func_74776_a("foodDecay", Helper.roundNumber(value, 10000.0F));
/* 200 */     if (value > getWeight(is)) {
/* 201 */       is.field_77994_a = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static float getDecay(ItemStack is) {
/* 206 */     NBTTagCompound nbt = getNBT(is);
/* 207 */     if (nbt.func_74764_b("foodDecay")) {
/* 208 */       return nbt.func_74760_g("foodDecay");
/*     */     }
/* 210 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDecayTimer(ItemStack is, int value) {
/* 215 */     NBTTagCompound nbt = getNBT(is);
/* 216 */     nbt.func_74768_a("decayTimer", value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDecayTimer(ItemStack is) {
/* 221 */     NBTTagCompound nbt = getNBT(is);
/* 222 */     if (nbt.func_74764_b("decayTimer")) {
/* 223 */       return nbt.func_74762_e("decayTimer");
/*     */     }
/* 225 */     return (int)TFC_Time.getTotalHours();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setWeight(ItemStack is, float value) {
/* 230 */     NBTTagCompound nbt = getNBT(is);
/* 231 */     nbt.func_74776_a("foodWeight", Helper.roundNumber(value, 100.0F));
/* 232 */     if (getDecay(is) > value || value <= 0.0F) {
/* 233 */       is.field_77994_a = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static float getWeight(ItemStack is) {
/* 238 */     NBTTagCompound nbt = getNBT(is);
/* 239 */     if (nbt.func_74764_b("foodWeight")) {
/* 240 */       return nbt.func_74760_g("foodWeight");
/*     */     }
/* 242 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isDried(ItemStack is) {
/* 247 */     NBTTagCompound nbt = getProcTag(is);
/* 248 */     return (nbt.func_74764_b("Dried") && nbt.func_74765_d("Dried") >= 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static short getDried(ItemStack is) {
/* 253 */     NBTTagCompound nbt = getProcTag(is);
/* 254 */     if (nbt.func_74764_b("Dried")) {
/* 255 */       return nbt.func_74765_d("Dried");
/*     */     }
/* 257 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDried(ItemStack is, int value) {
/* 262 */     NBTTagCompound nbt = getProcTag(is);
/* 263 */     nbt.func_74777_a("Dried", (short)value);
/* 264 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static short getSmokeCounter(ItemStack is) {
/* 269 */     NBTTagCompound nbt = getProcTag(is);
/* 270 */     if (nbt.func_74764_b("SmokeCounter")) {
/* 271 */       return nbt.func_74765_d("SmokeCounter");
/*     */     }
/* 273 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSmokeCounter(ItemStack is, int value) {
/* 278 */     NBTTagCompound nbt = getProcTag(is);
/* 279 */     nbt.func_74777_a("SmokeCounter", (short)value);
/* 280 */     setProcTag(is, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getCookedColorMultiplier(ItemStack is) {
/* 285 */     float cookedLevel = getCooked(is);
/* 286 */     int r = 255 - (int)(160.0F * Math.max(cookedLevel - 600.0F, 0.0F) / 600.0F);
/* 287 */     int b = 255 - (int)(160.0F * Math.max(cookedLevel - 600.0F, 0.0F) / 600.0F);
/* 288 */     int g = 255 - (int)(160.0F * Math.max(cookedLevel - 600.0F, 0.0F) / 600.0F);
/* 289 */     return (r << 16) + (b << 8) + g;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSweetMod(ItemStack is, int val) {
/* 294 */     NBTTagCompound nbt = getNBT(is);
/* 295 */     nbt.func_74768_a("tasteSweetMod", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSweetMod(ItemStack is) {
/* 300 */     NBTTagCompound nbt = getNBT(is);
/* 301 */     if (nbt.func_74764_b("tasteSweetMod")) {
/* 302 */       return nbt.func_74762_e("tasteSweetMod");
/*     */     }
/* 304 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSourMod(ItemStack is, int val) {
/* 309 */     NBTTagCompound nbt = getNBT(is);
/* 310 */     nbt.func_74768_a("tasteSourMod", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSourMod(ItemStack is) {
/* 315 */     NBTTagCompound nbt = getNBT(is);
/* 316 */     if (nbt.func_74764_b("tasteSourMod")) {
/* 317 */       return nbt.func_74762_e("tasteSourMod");
/*     */     }
/* 319 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSaltyMod(ItemStack is, int val) {
/* 324 */     NBTTagCompound nbt = getNBT(is);
/* 325 */     nbt.func_74768_a("tasteSaltyMod", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSaltyMod(ItemStack is) {
/* 330 */     NBTTagCompound nbt = getNBT(is);
/* 331 */     if (nbt.func_74764_b("tasteSaltyMod")) {
/* 332 */       return nbt.func_74762_e("tasteSaltyMod");
/*     */     }
/* 334 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setBitterMod(ItemStack is, int val) {
/* 339 */     NBTTagCompound nbt = getNBT(is);
/* 340 */     nbt.func_74768_a("tasteBitterMod", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBitterMod(ItemStack is) {
/* 345 */     NBTTagCompound nbt = getNBT(is);
/* 346 */     if (nbt.func_74764_b("tasteBitterMod")) {
/* 347 */       return nbt.func_74762_e("tasteBitterMod");
/*     */     }
/* 349 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSavoryMod(ItemStack is, int val) {
/* 354 */     NBTTagCompound nbt = getNBT(is);
/* 355 */     nbt.func_74768_a("tasteUmamiMod", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSavoryMod(ItemStack is) {
/* 360 */     NBTTagCompound nbt = getNBT(is);
/* 361 */     if (nbt.func_74764_b("tasteUmamiMod")) {
/* 362 */       return nbt.func_74762_e("tasteUmamiMod");
/*     */     }
/* 364 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void adjustFlavor(ItemStack is, Random r) {
/* 369 */     setSweetMod(is, r.nextInt(17) - 8);
/* 370 */     setSourMod(is, r.nextInt(17) - 8);
/* 371 */     setSaltyMod(is, r.nextInt(17) - 8);
/* 372 */     setBitterMod(is, r.nextInt(17) - 8);
/* 373 */     setSavoryMod(is, r.nextInt(17) - 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setMealSkill(ItemStack is, int val) {
/* 378 */     NBTTagCompound nbt = getNBT(is);
/* 379 */     nbt.func_74768_a("mealSkill", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMealSkill(ItemStack is) {
/* 384 */     NBTTagCompound nbt = getNBT(is);
/* 385 */     if (nbt.func_74764_b("mealSkill")) {
/* 386 */       return nbt.func_74762_e("mealSkill");
/*     */     }
/* 388 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasMealSkill(ItemStack is) {
/* 393 */     NBTTagCompound nbt = getNBT(is);
/* 394 */     return nbt.func_74764_b("mealSkill");
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getFoodTasteProfile(ItemStack is) {
/* 399 */     int[] profile = new int[5];
/* 400 */     if (is != null && is.func_77973_b() instanceof IFood) {
/*     */       
/* 402 */       profile[0] = ((IFood)is.func_77973_b()).getTasteSweet(is);
/* 403 */       profile[1] = ((IFood)is.func_77973_b()).getTasteSour(is);
/* 404 */       profile[2] = ((IFood)is.func_77973_b()).getTasteSalty(is);
/* 405 */       profile[3] = ((IFood)is.func_77973_b()).getTasteBitter(is);
/* 406 */       profile[4] = ((IFood)is.func_77973_b()).getTasteSavory(is);
/*     */     } 
/* 408 */     return profile;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isInfused(ItemStack is) {
/* 413 */     NBTTagCompound nbt = getNBT(is);
/* 414 */     return nbt.func_74764_b("Infusion");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getInfusion(ItemStack is) {
/* 419 */     NBTTagCompound nbt = getNBT(is);
/* 420 */     if (nbt.func_74764_b("Infusion")) {
/* 421 */       return nbt.func_74779_i("Infusion");
/*     */     }
/* 423 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setInfusion(ItemStack is, String val) {
/* 428 */     NBTTagCompound nbt = getNBT(is);
/* 429 */     nbt.func_74778_a("Infusion", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setFoodGroups(ItemStack is, int[] val) {
/* 434 */     NBTTagCompound nbt = getNBT(is);
/* 435 */     nbt.func_74783_a("FG", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getFoodGroups(ItemStack is) {
/* 440 */     NBTTagCompound nbt = getNBT(is);
/* 441 */     if (nbt.func_74764_b("FG")) {
/* 442 */       return nbt.func_74759_k("FG");
/*     */     }
/* 444 */     return new int[] { -1, -1, -1, -1 };
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setDecayRate(ItemStack is, float val) {
/* 449 */     NBTTagCompound nbt = getNBT(is);
/* 450 */     nbt.func_74776_a("decayRate", val);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getDecayRate(ItemStack is) {
/* 455 */     NBTTagCompound nbt = getNBT(is);
/* 456 */     if (nbt.func_74764_b("decayRate")) {
/* 457 */       return nbt.func_74760_g("decayRate");
/*     */     }
/* 459 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Food.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */