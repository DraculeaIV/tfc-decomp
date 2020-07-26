/*     */ package com.bioxx.tfc.Food;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.Render.Item.FoodItemRenderer;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.FoodRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.ICookableFood;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.Interfaces.IMergeableFood;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.MinecraftForgeClient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemFoodTFC
/*     */   extends ItemTerra
/*     */   implements ISize, ICookableFood, IMergeableFood
/*     */ {
/*     */   private EnumFoodGroup foodgroup;
/*     */   public int foodID;
/*  57 */   public float decayRate = 1.0F;
/*     */   
/*     */   public boolean edible = true;
/*     */   
/*     */   public boolean canBeUsedRaw = true;
/*     */   
/*     */   protected int tasteSweet;
/*     */   protected int tasteSour;
/*     */   protected int tasteSalty;
/*     */   protected int tasteBitter;
/*     */   protected int tasteUmami;
/*     */   protected boolean canBeSmoked;
/*     */   protected float smokeAbsorb;
/*     */   public IIcon cookedIcon;
/*     */   protected boolean hasCookedIcon;
/*     */   
/*     */   public ItemFoodTFC(EnumFoodGroup fg, int sw, int so, int sa, int bi, int um) {
/*  74 */     func_77637_a(TFCTabs.TFC_FOODS);
/*  75 */     setFolder("food/");
/*  76 */     this.foodgroup = fg;
/*  77 */     TFCItems.foodList.add(this);
/*  78 */     func_77656_e(100);
/*  79 */     this.field_77787_bX = false;
/*  80 */     this.smokeAbsorb = 0.5F;
/*  81 */     this.tasteSweet = sw;
/*  82 */     this.tasteSour = so;
/*  83 */     this.tasteSalty = sa;
/*  84 */     this.tasteBitter = bi;
/*  85 */     this.tasteUmami = um;
/*  86 */     this.foodID = FoodRegistry.getInstance().registerFood(fg, (Item)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFoodTFC(EnumFoodGroup fg, int sw, int so, int sa, int bi, int um, boolean edible) {
/*  91 */     this(fg, sw, so, sa, bi, um);
/*  92 */     this.edible = edible;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFoodTFC(EnumFoodGroup fg, int sw, int so, int sa, int bi, int um, boolean edible, boolean usable) {
/*  97 */     this(fg, sw, so, sa, bi, um, edible);
/*  98 */     this.canBeUsedRaw = usable;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFoodTFC setDecayRate(float f) {
/* 103 */     this.decayRate = f;
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFoodTFC setCanSmoke() {
/* 109 */     this.canBeSmoked = true;
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemFoodTFC setHasCookedIcon() {
/* 115 */     this.hasCookedIcon = true;
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/* 122 */     super.func_94581_a(registerer);
/* 123 */     if (this.hasCookedIcon) {
/*     */       
/* 125 */       String name = func_77658_a();
/* 126 */       this.cookedIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + name.replace("item.", "") + " Cooked");
/*     */     } 
/* 128 */     MinecraftForgeClient.registerItemRenderer((Item)this, (IItemRenderer)new FoodItemRenderer());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/* 134 */     if (Food.isCooked(stack) && this.cookedIcon != null)
/* 135 */       return this.cookedIcon; 
/* 136 */     return this.field_77791_bV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderPasses(int metadata) {
/* 153 */     return 1;
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
/*     */   public float getDecayRate(ItemStack is) {
/* 171 */     float mult = 1.0F;
/* 172 */     if (Food.isCooked(is)) {
/*     */       
/* 174 */       mult *= 0.75F;
/* 175 */       if (Food.isPickled(is) || Food.isSalted(is))
/* 176 */         mult *= 0.75F; 
/* 177 */       if (Food.isSmoked(is)) {
/* 178 */         mult *= 1.0F - 0.25F * getSmokeAbsorbMultiplier();
/*     */       }
/*     */     } else {
/*     */       
/* 182 */       if (Food.isPickled(is) || Food.isSalted(is))
/* 183 */         mult *= 0.5F; 
/* 184 */       if (Food.isSmoked(is))
/* 185 */         mult *= 1.0F - 0.25F * getSmokeAbsorbMultiplier(); 
/* 186 */       if (Food.isDried(is))
/* 187 */         mult *= 0.25F; 
/*     */     } 
/* 189 */     return this.decayRate * TFC_Time.getYearRatio(96.0F) * mult;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 195 */     list.add(createTag(new ItemStack((Item)this, 1), 160.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack is) {
/* 201 */     StringBuilder name = new StringBuilder();
/* 202 */     if (is.func_77942_o()) {
/*     */       
/* 204 */       if (Food.isPickled(is)) {
/* 205 */         name.append(TFC_Core.translate("word.pickled")).append(' ');
/* 206 */       } else if (Food.isBrined(is) && !Food.isDried(is)) {
/* 207 */         name.append(TFC_Core.translate("word.brined")).append(' ');
/*     */       } 
/* 209 */       if (Food.isSalted(is))
/* 210 */         name.append(TFC_Core.translate("word.salted")).append(' '); 
/* 211 */       if (Food.isCooked(is)) {
/* 212 */         name.append(TFC_Core.translate("word.cooked")).append(' ');
/* 213 */       } else if (Food.isSmoked(is)) {
/* 214 */         name.append(TFC_Core.translate("word.smoked")).append(' ');
/*     */       } 
/* 216 */       if (Food.isDried(is) && !Food.isCooked(is))
/* 217 */         name.append(TFC_Core.translate("word.dried")).append(' '); 
/* 218 */       if (Food.isInfused(is)) {
/* 219 */         name.append(TFC_Core.translate(Food.getInfusion(is) + ".name")).append(' ');
/*     */       }
/*     */     } 
/* 222 */     return name.append(TFC_Core.translate(func_77667_c(is) + ".name")).append(getCookedLevelString(is)).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getCookedLevelString(ItemStack is) {
/* 227 */     String s = "";
/* 228 */     if (Food.isCooked(is)) {
/*     */       
/* 230 */       s = s + " (";
/* 231 */       int cookedLevel = ((int)Food.getCooked(is) - 600) / 120;
/* 232 */       switch (cookedLevel) {
/*     */         case 0:
/* 234 */           s = s + TFC_Core.translate("food.cooked.0"); break;
/* 235 */         case 1: s = s + TFC_Core.translate("food.cooked.1"); break;
/* 236 */         case 2: s = s + TFC_Core.translate("food.cooked.2"); break;
/* 237 */         case 3: s = s + TFC_Core.translate("food.cooked.3"); break;
/* 238 */         default: s = s + TFC_Core.translate("food.cooked.4"); break;
/*     */       } 
/* 240 */       s = s + ")";
/*     */     } 
/* 242 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addFoodHeatInformation(ItemStack is, List<String> arraylist) {
/* 247 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/* 249 */       float meltTemp = TFC_ItemHeat.isCookable(is);
/* 250 */       if (meltTemp != -1.0F) {
/* 251 */         arraylist.add(TFC_ItemHeat.getHeatColorFood(TFC_ItemHeat.getTemp(is), meltTemp));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 258 */     ItemTerra.addSizeInformation(is, arraylist);
/* 259 */     arraylist.add(getFoodGroupName(getFoodGroup()));
/*     */     
/* 261 */     if (is.func_77942_o()) {
/*     */       
/* 263 */       addFoodHeatInformation(is, arraylist);
/* 264 */       addFoodInformation(is, player, arraylist);
/*     */     }
/*     */     else {
/*     */       
/* 268 */       arraylist.add(TFC_Core.translate("gui.badnbt"));
/* 269 */       TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + 
/* 270 */           TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFoodInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 276 */     float ounces = Helper.roundNumber(Food.getWeight(is), 100.0F);
/* 277 */     if (ounces > 0.0F && ounces <= 160.0F) {
/* 278 */       arraylist.add(TFC_Core.translate("gui.food.amount") + " " + ounces + " oz / " + 160.0F + " oz");
/*     */     }
/* 280 */     float decay = Food.getDecay(is);
/* 281 */     if (decay > 0.0F)
/* 282 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.food.decay") + " " + Helper.roundNumber(decay / ounces * 100.0F, 10.0F) + "%"); 
/* 283 */     if (TFCOptions.enableDebugMode) {
/*     */       
/* 285 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.food.decay") + ": " + decay);
/* 286 */       arraylist.add(EnumChatFormatting.DARK_GRAY + "Decay Rate: " + Helper.roundNumber(getDecayRate(is), 100.0F));
/*     */     } 
/*     */     
/* 289 */     if (TFC_Core.showCtrlInformation()) {
/* 290 */       addTasteInformation(is, player, arraylist);
/*     */     } else {
/* 292 */       arraylist.add(TFC_Core.translate("gui.showtaste"));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void addTasteInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 297 */     IFood food = (IFood)is.func_77973_b();
/* 298 */     int sweet = food.getTasteSweet(is);
/* 299 */     int sour = food.getTasteSour(is);
/* 300 */     int salty = food.getTasteSalty(is);
/* 301 */     int bitter = food.getTasteBitter(is);
/* 302 */     int savory = food.getTasteSavory(is);
/* 303 */     SkillStats.SkillRank rank = TFC_Core.getSkillStats(player).getSkillRank("skill.cooking");
/* 304 */     if (Food.hasMealSkill(is)) {
/* 305 */       rank = SkillStats.SkillRank.values()[Food.getMealSkill(is)];
/*     */     }
/* 307 */     int[] prefs = TFC_Core.getPlayerFoodStats(player).getPrefTaste();
/*     */     
/* 309 */     String sSweet = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.taste.sweet") + ": " + EnumChatFormatting.WHITE;
/* 310 */     String sSour = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.taste.sour") + ": " + EnumChatFormatting.WHITE;
/* 311 */     String sSalty = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.taste.salty") + ": " + EnumChatFormatting.WHITE;
/* 312 */     String sBitter = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.taste.bitter") + ": " + EnumChatFormatting.WHITE;
/* 313 */     String sSavory = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.taste.savory") + ": " + EnumChatFormatting.WHITE;
/*     */     
/* 315 */     if (rank == SkillStats.SkillRank.Novice) {
/*     */       
/* 317 */       sSweet = sSweet + ((sweet > prefs[0]) ? TFC_Core.translate("gui.taste.novice.sweet1") : TFC_Core.translate("gui.taste.novice.sweet0"));
/* 318 */       sSour = sSour + ((sour > prefs[1]) ? TFC_Core.translate("gui.taste.novice.sour1") : TFC_Core.translate("gui.taste.novice.sour0"));
/* 319 */       sSalty = sSalty + ((salty > prefs[2]) ? TFC_Core.translate("gui.taste.novice.salty1") : TFC_Core.translate("gui.taste.novice.salty0"));
/* 320 */       sBitter = sBitter + ((bitter > prefs[3]) ? TFC_Core.translate("gui.taste.novice.bitter1") : TFC_Core.translate("gui.taste.novice.bitter0"));
/* 321 */       sSavory = sSavory + ((savory > prefs[4]) ? TFC_Core.translate("gui.taste.novice.savory1") : TFC_Core.translate("gui.taste.novice.savory0"));
/*     */     }
/* 323 */     else if (rank == SkillStats.SkillRank.Adept) {
/*     */       
/* 325 */       sSweet = sSweet + createBasicString(sweet, prefs[0], "sweet");
/* 326 */       sSour = sSour + createBasicString(sour, prefs[1], "sour");
/* 327 */       sSalty = sSalty + createBasicString(salty, prefs[2], "salty");
/* 328 */       sBitter = sBitter + createBasicString(bitter, prefs[3], "bitter");
/* 329 */       sSavory = sSavory + createBasicString(savory, prefs[4], "savory");
/*     */     }
/* 331 */     else if (rank == SkillStats.SkillRank.Expert) {
/*     */       
/* 333 */       sSweet = sSweet + createExpertString(sweet, prefs[0], "sweet");
/* 334 */       sSour = sSour + createExpertString(sour, prefs[1], "sour");
/* 335 */       sSalty = sSalty + createExpertString(salty, prefs[2], "salty");
/* 336 */       sBitter = sBitter + createExpertString(bitter, prefs[3], "bitter");
/* 337 */       sSavory = sSavory + createExpertString(savory, prefs[4], "savory");
/*     */     }
/* 339 */     else if (rank == SkillStats.SkillRank.Master) {
/*     */       
/* 341 */       sSweet = sSweet + createBasicString(sweet, prefs[0], "sweet") + " (" + (sweet - prefs[0]) + ")";
/* 342 */       sSour = sSour + createBasicString(sour, prefs[1], "sour") + " (" + (sour - prefs[1]) + ")";
/* 343 */       sSalty = sSalty + createBasicString(salty, prefs[2], "salty") + " (" + (salty - prefs[2]) + ")";
/* 344 */       sBitter = sBitter + createBasicString(bitter, prefs[3], "bitter") + " (" + (bitter - prefs[3]) + ")";
/* 345 */       sSavory = sSavory + createBasicString(savory, prefs[4], "savory") + " (" + (savory - prefs[4]) + ")";
/*     */     } 
/*     */     
/* 348 */     arraylist.add(sSweet);
/* 349 */     arraylist.add(sSour);
/* 350 */     arraylist.add(sSalty);
/* 351 */     arraylist.add(sBitter);
/* 352 */     arraylist.add(sSavory);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String createExpertString(int val, int pref, String name) {
/* 357 */     int abs = Math.abs(val - pref);
/*     */     
/* 359 */     String out = createBasicString(val, pref, name);
/*     */     
/* 361 */     if (abs <= 5) {
/* 362 */       out = out + " (+-5)";
/* 363 */     } else if (abs <= 10) {
/* 364 */       out = out + " (+-10)";
/* 365 */     } else if (abs <= 15) {
/* 366 */       out = out + " (+-15)";
/* 367 */     } else if (abs <= 20) {
/* 368 */       out = out + " (+-20)";
/*     */     } 
/* 370 */     return out;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String createBasicString(int val, int pref, String name) {
/* 375 */     int dif = val - pref;
/*     */     
/* 377 */     if (dif >= -5 && dif <= 5)
/* 378 */       return TFC_Core.translate("gui.taste.4") + " " + TFC_Core.translate("gui.taste." + name); 
/* 379 */     if (dif >= -10 && dif < -5)
/* 380 */       return TFC_Core.translate("gui.taste.3") + " " + TFC_Core.translate("gui.taste." + name); 
/* 381 */     if (dif >= -15 && dif < -10)
/* 382 */       return TFC_Core.translate("gui.taste.2") + " " + TFC_Core.translate("gui.taste." + name); 
/* 383 */     if (dif >= -20 && dif < -15)
/* 384 */       return TFC_Core.translate("gui.taste.1") + " " + TFC_Core.translate("gui.taste." + name); 
/* 385 */     if (dif < -20)
/* 386 */       return TFC_Core.translate("gui.taste.0") + " " + TFC_Core.translate("gui.taste." + name); 
/* 387 */     if (dif > 5 && dif <= 10)
/* 388 */       return TFC_Core.translate("gui.taste.5") + " " + TFC_Core.translate("gui.taste." + name); 
/* 389 */     if (dif > 10 && dif <= 15)
/* 390 */       return TFC_Core.translate("gui.taste.6") + " " + TFC_Core.translate("gui.taste." + name); 
/* 391 */     if (dif > 15 && dif <= 20)
/* 392 */       return TFC_Core.translate("gui.taste.7") + " " + TFC_Core.translate("gui.taste." + name); 
/* 393 */     if (dif > 20) {
/* 394 */       return TFC_Core.translate("gui.taste.8") + " " + TFC_Core.translate("gui.taste." + name);
/*     */     }
/* 396 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getFoodGroupName(EnumFoodGroup fg) {
/* 401 */     if (fg == EnumFoodGroup.Dairy)
/* 402 */       return EnumChatFormatting.WHITE + TFC_Core.translate("gui.food.dairy"); 
/* 403 */     if (fg == EnumFoodGroup.Fruit)
/* 404 */       return EnumChatFormatting.DARK_PURPLE + TFC_Core.translate("gui.food.fruit"); 
/* 405 */     if (fg == EnumFoodGroup.Vegetable)
/* 406 */       return EnumChatFormatting.DARK_GREEN + TFC_Core.translate("gui.food.vegetable"); 
/* 407 */     if (fg == EnumFoodGroup.Protein)
/* 408 */       return EnumChatFormatting.DARK_RED + TFC_Core.translate("gui.food.protein"); 
/* 409 */     if (fg == EnumFoodGroup.Grain) {
/* 410 */       return EnumChatFormatting.YELLOW + TFC_Core.translate("gui.food.grain");
/*     */     }
/* 412 */     return "N/A";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getFoodGroupColor(EnumFoodGroup fg) {
/* 417 */     if (fg == EnumFoodGroup.Dairy)
/* 418 */       return EnumChatFormatting.WHITE.toString(); 
/* 419 */     if (fg == EnumFoodGroup.Fruit)
/* 420 */       return EnumChatFormatting.DARK_PURPLE.toString(); 
/* 421 */     if (fg == EnumFoodGroup.Vegetable)
/* 422 */       return EnumChatFormatting.DARK_GREEN.toString(); 
/* 423 */     if (fg == EnumFoodGroup.Protein)
/* 424 */       return EnumChatFormatting.DARK_RED.toString(); 
/* 425 */     if (fg == EnumFoodGroup.Grain) {
/* 426 */       return EnumChatFormatting.YELLOW.toString();
/*     */     }
/* 428 */     return "N/A";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/* 434 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/* 435 */     if (foodstats.needFood() && isEdible(is)) {
/* 436 */       player.func_71008_a(is, 32);
/*     */     }
/* 438 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/* 444 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/* 445 */     if (!world.field_72995_K && isEdible(is))
/*     */     {
/* 447 */       if (is.func_77942_o()) {
/*     */ 
/*     */         
/* 450 */         float weight = Food.getWeight(is);
/* 451 */         float decay = Math.max(Food.getDecay(is), 0.0F);
/*     */         
/* 453 */         float eatAmount = Math.min(weight - decay, 5.0F);
/* 454 */         float stomachDiff = foodstats.stomachLevel + eatAmount - foodstats.getMaxStomach(foodstats.player);
/* 455 */         if (stomachDiff > 0.0F) {
/* 456 */           eatAmount -= stomachDiff;
/*     */         }
/* 458 */         float tasteFactor = foodstats.getTasteFactor(is);
/* 459 */         foodstats.addNutrition(((IFood)is.func_77973_b()).getFoodGroup(), eatAmount * tasteFactor);
/* 460 */         foodstats.stomachLevel += eatAmount * tasteFactor;
/* 461 */         if (FoodStatsTFC.reduceFood(is, eatAmount)) {
/* 462 */           is.field_77994_a = 0;
/*     */         }
/*     */       } else {
/*     */         
/* 466 */         foodstats.addNutrition(((IFood)is.func_77973_b()).getFoodGroup(), 1.0F);
/*     */ 
/*     */         
/* 469 */         String error = TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact");
/* 470 */         TerraFirmaCraft.LOG.error(error);
/* 471 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentText(error));
/*     */       } 
/*     */     }
/*     */     
/* 475 */     world.func_72956_a((Entity)player, "random.burp", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 476 */     TFC_Core.setPlayerFoodStats(player, foodstats);
/* 477 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack onConsumedByEntity(ItemStack is, World world, EntityLivingBase entity) {
/* 482 */     if (entity instanceof com.bioxx.tfc.api.Entities.IAnimal) {
/*     */       
/* 484 */       if (!world.field_72995_K) {
/*     */         
/* 486 */         float weight = Food.getWeight(is);
/* 487 */         float decay = Math.max(Food.getDecay(is), 0.0F);
/* 488 */         float eatAmount = Math.min(weight - decay, 5.0F);
/* 489 */         if (FoodStatsTFC.reduceFood(is, eatAmount))
/* 490 */           is.field_77994_a = 0; 
/*     */       } 
/* 492 */       world.func_72956_a((Entity)entity, "random.burp", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */     } 
/* 494 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHot(ItemStack is) {
/* 499 */     return (TFC_ItemHeat.getTemp(is) > TFC_ItemHeat.isCookable(is) * 0.8D);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack createTag(ItemStack is) {
/* 504 */     return createTag(is, 999.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack createTag(ItemStack is, float weight) {
/* 509 */     if (!is.func_77942_o()) {
/* 510 */       is.func_77982_d(new NBTTagCompound());
/*     */     }
/* 512 */     Food.setWeight(is, weight);
/* 513 */     Food.setDecay(is, -24.0F);
/* 514 */     Food.setDecayTimer(is, (int)TFC_Time.getTotalHours() + 1);
/*     */     
/* 516 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack createTag(ItemStack is, float weight, float decay) {
/* 521 */     is = createTag(is, weight);
/* 522 */     Food.setDecay(is, decay);
/* 523 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack is) {
/* 529 */     return 32;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack is) {
/* 535 */     return EnumAction.eat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayDamage(ItemStack is) {
/* 541 */     float decay = Food.getDecay(is);
/* 542 */     float weight = Food.getWeight(is);
/* 543 */     int percent = (int)(decay / weight * 100.0F);
/* 544 */     percent = (percent > 0) ? ((percent < 100) ? percent : 100) : 0;
/* 545 */     return percent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDamaged(ItemStack is) {
/* 554 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/* 560 */     return 100;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 566 */     float weight = Food.getWeight(is);
/* 567 */     if (weight <= 20.0F)
/* 568 */       return EnumSize.TINY; 
/* 569 */     if (weight <= 40.0F)
/* 570 */       return EnumSize.VERYSMALL; 
/* 571 */     if (weight <= 80.0F) {
/* 572 */       return EnumSize.SMALL;
/*     */     }
/* 574 */     return EnumSize.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 580 */     float weight = Food.getWeight(is);
/* 581 */     if (weight < 80.0F)
/* 582 */       return EnumWeight.LIGHT; 
/* 583 */     if (weight < 160.0F) {
/* 584 */       return EnumWeight.MEDIUM;
/*     */     }
/* 586 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 591 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumFoodGroup getFoodGroup() {
/* 597 */     return this.foodgroup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFoodID() {
/* 603 */     return this.foodID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onDecayed(ItemStack is, World world, int x, int y, int z) {
/* 609 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEdible(ItemStack is) {
/* 615 */     return (this.edible || Food.isCooked(is));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsable(ItemStack is) {
/* 621 */     return (this.canBeUsedRaw || Food.isCooked(is));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSweet(ItemStack is) {
/* 626 */     int base = this.tasteSweet;
/* 627 */     if (is != null) {
/*     */       
/* 629 */       if (is.func_77978_p().func_74764_b("tasteSweet"))
/* 630 */         base = is.func_77978_p().func_74762_e("tasteSweet"); 
/* 631 */       base += Food.getCookedProfile(is)[0];
/* 632 */       base = (int)(base + Food.getFuelProfile(is)[0] * getSmokeAbsorbMultiplier());
/*     */     } 
/* 634 */     return Math.max(base + Food.getSweetMod(is), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSour(ItemStack is) {
/* 639 */     int base = this.tasteSour;
/* 640 */     if (is != null) {
/*     */       
/* 642 */       if (is.func_77978_p().func_74764_b("tasteSour"))
/* 643 */         base = is.func_77978_p().func_74762_e("tasteSour"); 
/* 644 */       base += Food.getCookedProfile(is)[1];
/* 645 */       base = (int)(base + Food.getFuelProfile(is)[1] * getSmokeAbsorbMultiplier());
/*     */     } 
/* 647 */     if (Food.isBrined(is))
/* 648 */       base += 5; 
/* 649 */     if (Food.isPickled(is))
/* 650 */       base += 30; 
/* 651 */     return Math.max(base + Food.getSourMod(is), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSalty(ItemStack is) {
/* 656 */     int base = this.tasteSalty;
/* 657 */     if (is != null) {
/*     */       
/* 659 */       if (is.func_77978_p().func_74764_b("tasteSalty"))
/* 660 */         base = is.func_77978_p().func_74762_e("tasteSalty"); 
/* 661 */       base += Food.getCookedProfile(is)[2];
/* 662 */       base = (int)(base + Food.getFuelProfile(is)[2] * getSmokeAbsorbMultiplier());
/*     */     } 
/* 664 */     if (Food.isSalted(is))
/* 665 */       base += 40; 
/* 666 */     if (Food.isBrined(is)) {
/* 667 */       base += 10;
/*     */     }
/* 669 */     return Math.max(base + Food.getSaltyMod(is), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteBitter(ItemStack is) {
/* 674 */     int base = this.tasteBitter;
/* 675 */     if (is != null) {
/*     */       
/* 677 */       if (is.func_77978_p().func_74764_b("tasteBitter"))
/* 678 */         base = is.func_77978_p().func_74762_e("tasteBitter"); 
/* 679 */       base += Food.getCookedProfile(is)[3];
/* 680 */       base = (int)(base + Food.getFuelProfile(is)[3] * getSmokeAbsorbMultiplier());
/*     */     } 
/* 682 */     return Math.max(base + Food.getBitterMod(is), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSavory(ItemStack is) {
/* 687 */     int base = this.tasteUmami;
/* 688 */     if (is != null) {
/*     */       
/* 690 */       if (is.func_77978_p().func_74764_b("tasteUmami"))
/* 691 */         base = is.func_77978_p().func_74762_e("tasteUmami"); 
/* 692 */       base += Food.getCookedProfile(is)[4];
/* 693 */       base = (int)(base + Food.getFuelProfile(is)[4] * getSmokeAbsorbMultiplier());
/*     */     } 
/* 695 */     return Math.max(base + Food.getSavoryMod(is), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFoodMaxWeight(ItemStack is) {
/* 700 */     return 160.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderDecay() {
/* 705 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderWeight() {
/* 710 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSmoke() {
/* 715 */     return this.canBeSmoked;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSmokeAbsorbMultiplier() {
/* 721 */     return this.smokeAbsorb;
/*     */   }
/*     */   
/*     */   public ItemFoodTFC setSmokeAbsorbMultiplier(float s) {
/* 725 */     this.smokeAbsorb = s;
/* 726 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemFoodTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */