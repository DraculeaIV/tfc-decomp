/*     */ package com.bioxx.tfc.Food;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
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
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
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
/*     */ public class ItemMeal
/*     */   extends ItemTerra
/*     */   implements IFood
/*     */ {
/*     */   public ItemMeal() {
/*  45 */     this.field_77787_bX = true;
/*  46 */     this.metaNames = new String[] { "Meal0", "Meal1", "Meal2", "Meal3", "Meal4", "Meal5", "Meal6", "Meal7", "Meal8", "Meal9", "Meal10" };
/*  47 */     this.metaIcons = new net.minecraft.util.IIcon[11];
/*  48 */     setFolder("food/");
/*  49 */     this.stackable = false;
/*  50 */     func_77637_a(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  56 */     super.func_94581_a(registerer);
/*  57 */     MinecraftForgeClient.registerItemRenderer((Item)this, (IItemRenderer)new FoodItemRenderer());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  63 */     list.add(createTag(new ItemStack((Item)this, 1)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack createTag(ItemStack is) {
/*  69 */     if (!is.func_77942_o()) {
/*  70 */       is.func_77982_d(new NBTTagCompound());
/*     */     }
/*  72 */     Food.setWeight(is, 0.0F);
/*  73 */     Food.setDecay(is, 0.0F);
/*  74 */     Food.setDecayTimer(is, (int)TFC_Time.getTotalHours() + 1);
/*  75 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack itemstack) {
/*  81 */     return func_77658_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  87 */     ItemTerra.addSizeInformation(is, arraylist);
/*  88 */     if (!TFC_Core.showShiftInformation())
/*     */     {
/*  90 */       arraylist.add("");
/*     */     }
/*     */     
/*  93 */     if (is.func_77942_o()) {
/*     */ 
/*     */       
/*  96 */       ItemFoodTFC.addFoodHeatInformation(is, arraylist);
/*  97 */       addFoodInformation(is, player, arraylist);
/*     */       
/*  99 */       if (TFC_Core.showShiftInformation())
/*     */       {
/* 101 */         addFGInformation(is, arraylist);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 106 */       arraylist.add(TFC_Core.translate("gui.badnbt"));
/* 107 */       TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + 
/* 108 */           TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addFoodInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 114 */     float ounces = Helper.roundNumber(Food.getWeight(is), 100.0F);
/* 115 */     if (ounces > 0.0F)
/* 116 */       arraylist.add(TFC_Core.translate("gui.food.amount") + " " + ounces + " oz / " + 160.0F + " oz"); 
/* 117 */     float decay = Food.getDecay(is);
/* 118 */     if (decay > 0.0F)
/* 119 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.food.decay") + " " + Helper.roundNumber(decay / ounces * 100.0F, 10.0F) + "%"); 
/* 120 */     if (TFCOptions.enableDebugMode) {
/*     */       
/* 122 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.food.decay") + ": " + decay);
/* 123 */       arraylist.add(EnumChatFormatting.DARK_GRAY + "Decay Rate: " + getDecayRate(is));
/*     */     } 
/*     */     
/* 126 */     if (TFC_Core.showCtrlInformation()) {
/* 127 */       ItemFoodTFC.addTasteInformation(is, player, arraylist);
/*     */     } else {
/* 129 */       arraylist.add(TFC_Core.translate("gui.showtaste"));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void addFGInformation(ItemStack is, List<String> arraylist) {
/* 134 */     int[] fg = Food.getFoodGroups(is);
/* 135 */     for (int i = 0; i < fg.length; i++) {
/*     */       
/* 137 */       if (fg[i] != -1) {
/* 138 */         arraylist.add(localize(fg[i]));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String localize(int id) {
/* 144 */     return ItemFoodTFC.getFoodGroupColor(FoodRegistry.getInstance().getFoodGroup(id)) + 
/* 145 */       TFC_Core.translate(FoodRegistry.getInstance().getFood(id).func_77658_a() + ".name");
/*     */   }
/*     */ 
/*     */   
/*     */   protected float[] getNutritionalWeights(int[] foodGroups) {
/* 150 */     float[] nw = new float[foodGroups.length];
/* 151 */     float[] fw = getFoodWeights();
/* 152 */     float totalWeight = 0.0F; int i;
/* 153 */     for (i = 0; i < foodGroups.length; i++) {
/*     */       
/* 155 */       if (foodGroups[i] != -1)
/*     */       {
/* 157 */         totalWeight += fw[i];
/*     */       }
/*     */     } 
/*     */     
/* 161 */     for (i = 0; i < foodGroups.length; i++)
/*     */     {
/* 163 */       nw[i] = fw[i] / totalWeight;
/*     */     }
/* 165 */     return nw;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float[] getFoodWeights() {
/* 170 */     return new float[] { 10.0F, 4.0F, 4.0F, 2.0F };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getEatAmount(FoodStatsTFC fs, float amount) {
/* 180 */     float eatAmount = Math.min(amount, 5.0F);
/* 181 */     float stomachDiff = fs.stomachLevel + eatAmount - fs.getMaxStomach(fs.player);
/* 182 */     if (stomachDiff > 0.0F)
/* 183 */       eatAmount -= stomachDiff; 
/* 184 */     return eatAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getFillingBoost() {
/* 189 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/* 195 */     world.func_72956_a((Entity)player, "random.burp", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */     
/* 197 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/* 198 */     if (!world.field_72995_K)
/*     */     {
/*     */       
/* 201 */       if (is.func_77942_o()) {
/*     */         
/* 203 */         float weight = Food.getWeight(is);
/* 204 */         float decay = Math.max(Food.getDecay(is), 0.0F);
/* 205 */         float eatAmount = getEatAmount(foodstats, weight - decay);
/* 206 */         float tasteFactor = foodstats.getTasteFactor(is);
/*     */         
/* 208 */         int[] fg = Food.getFoodGroups(is);
/* 209 */         float[] nWeights = getNutritionalWeights(fg);
/* 210 */         for (int i = 0; i < fg.length; i++) {
/*     */           
/* 212 */           if (fg[i] != -1) {
/* 213 */             foodstats.addNutrition(FoodRegistry.getInstance().getFoodGroup(fg[i]), eatAmount * nWeights[i] * 2.5F);
/*     */           }
/*     */         } 
/*     */         
/* 217 */         foodstats.stomachLevel += eatAmount * getFillingBoost();
/* 218 */         foodstats.setSatisfaction(foodstats.getSatisfaction() + eatAmount / 3.0F * tasteFactor, fg);
/*     */ 
/*     */         
/* 221 */         if (FoodStatsTFC.reduceFood(is, eatAmount))
/*     */         {
/* 223 */           is.field_77994_a = 0;
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 229 */         String error = TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact");
/* 230 */         TerraFirmaCraft.LOG.error(error);
/* 231 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentText(error));
/*     */       } 
/*     */     }
/* 234 */     TFC_Core.setPlayerFoodStats(player, foodstats);
/* 235 */     return is;
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
/*     */   public static boolean isWarm(ItemStack is) {
/* 252 */     return (TFC_ItemHeat.getTemp(is) > TFC_ItemHeat.isCookable(is) * 0.1D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/* 261 */     return 32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 270 */     return EnumAction.eat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/* 279 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/*     */ 
/*     */     
/* 282 */     if (foodstats.needFood()) {
/* 283 */       player.func_71008_a(is, func_77626_a(is));
/*     */     }
/* 285 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 291 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 297 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumFoodGroup getFoodGroup() {
/* 303 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFoodID() {
/* 309 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDecayRate(ItemStack is) {
/* 315 */     return Food.getDecayRate(is);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onDecayed(ItemStack is, World world, int i, int j, int k) {
/* 321 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEdible(ItemStack is) {
/* 327 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsable(ItemStack is) {
/* 333 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSweet(ItemStack is) {
/* 338 */     int base = 0;
/* 339 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("tasteSweet"))
/* 340 */       base = is.func_77978_p().func_74762_e("tasteSweet"); 
/* 341 */     return base + Food.getSweetMod(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSour(ItemStack is) {
/* 346 */     int base = 0;
/* 347 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("tasteSour"))
/* 348 */       base = is.func_77978_p().func_74762_e("tasteSour"); 
/* 349 */     return base + Food.getSourMod(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSalty(ItemStack is) {
/* 354 */     int base = 0;
/* 355 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("tasteSalty"))
/* 356 */       base = is.func_77978_p().func_74762_e("tasteSalty"); 
/* 357 */     return base + Food.getSaltyMod(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteBitter(ItemStack is) {
/* 362 */     int base = 0;
/* 363 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("tasteBitter"))
/* 364 */       base = is.func_77978_p().func_74762_e("tasteBitter"); 
/* 365 */     return base + Food.getBitterMod(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSavory(ItemStack is) {
/* 370 */     int base = 0;
/* 371 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("tasteUmami"))
/* 372 */       base = is.func_77978_p().func_74762_e("tasteUmami"); 
/* 373 */     return base + Food.getSavoryMod(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFoodMaxWeight(ItemStack is) {
/* 378 */     return 20.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderDecay() {
/* 383 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderWeight() {
/* 388 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemMeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */