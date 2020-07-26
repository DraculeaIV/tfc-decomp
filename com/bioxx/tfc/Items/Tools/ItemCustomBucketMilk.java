/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.List;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemCustomBucketMilk
/*     */   extends ItemTerra
/*     */   implements IFood
/*     */ {
/*     */   public ItemCustomBucketMilk() {
/*  32 */     func_77625_d(1);
/*  33 */     func_77637_a(TFCTabs.TFC_FOODS);
/*  34 */     setFolder("tools/");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  40 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  46 */     list.add(createTag(new ItemStack((Item)this, 1), 20.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  52 */     float ounces = Food.getWeight(is);
/*  53 */     if (ounces > 0.0F)
/*  54 */       arraylist.add(ounces + " oz"); 
/*  55 */     float decay = Food.getDecay(is);
/*  56 */     if (decay > 0.0F) {
/*     */       
/*  58 */       float perc = decay / ounces;
/*  59 */       String s = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.milk.fresh");
/*  60 */       if (perc > 50.0F)
/*  61 */         s = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.milk.old"); 
/*  62 */       if (perc > 70.0F) {
/*  63 */         s = EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.milk.sour");
/*     */       }
/*  65 */       arraylist.add(s);
/*     */     } 
/*  67 */     if (TFCOptions.enableDebugMode) {
/*  68 */       arraylist.add(EnumChatFormatting.DARK_GRAY + "Decay: " + decay);
/*     */     }
/*     */   }
/*     */   
/*     */   public static ItemStack createTag(ItemStack is, float weight) {
/*  73 */     if (!is.func_77942_o()) {
/*  74 */       is.func_77982_d(new NBTTagCompound());
/*     */     }
/*  76 */     Food.setWeight(is, weight);
/*  77 */     Food.setDecay(is, 0.0F);
/*  78 */     Food.setDecayTimer(is, (int)TFC_Time.getTotalHours() + 1);
/*  79 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/*  85 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/*  86 */     if (!world.field_72995_K && foodstats.needFood()) {
/*     */       
/*  88 */       world.func_72956_a((Entity)player, "random.burp", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       
/*  90 */       if (is.func_77942_o()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         float tasteFactor = foodstats.getTasteFactor(is);
/*  97 */         foodstats.addNutrition(((IFood)is.func_77973_b()).getFoodGroup(), 20.0F * tasteFactor);
/*     */       } 
/*     */       
/* 100 */       foodstats.restoreWater(player, 16000);
/*     */       
/* 102 */       TFC_Core.setPlayerFoodStats(player, foodstats);
/*     */       
/* 104 */       is = new ItemStack(TFCItems.woodenBucketEmpty);
/* 105 */       is.field_77990_d = null;
/*     */     } 
/* 107 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/* 116 */     return 32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 125 */     return EnumAction.drink;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer entity) {
/* 134 */     MovingObjectPosition mop = func_77621_a(world, entity, true);
/* 135 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(entity);
/*     */     
/* 137 */     if (mop == null)
/*     */     {
/* 139 */       if (fs.needDrink() && fs.needFood())
/* 140 */         entity.func_71008_a(is, func_77626_a(is)); 
/*     */     }
/* 142 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumFoodGroup getFoodGroup() {
/* 148 */     return EnumFoodGroup.Dairy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFoodID() {
/* 154 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onDecayed(ItemStack is, World world, int i, int j, int k) {
/* 160 */     return new ItemStack(TFCItems.woodenBucketEmpty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDecayRate(ItemStack is) {
/* 166 */     return 6.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 172 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEdible(ItemStack is) {
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsable(ItemStack is) {
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSweet(ItemStack is) {
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSour(ItemStack is) {
/* 194 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSalty(ItemStack is) {
/* 199 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteBitter(ItemStack is) {
/* 204 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTasteSavory(ItemStack is) {
/* 209 */     return 10;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFoodMaxWeight(ItemStack is) {
/* 215 */     return 80.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderDecay() {
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWeight() {
/* 227 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomBucketMilk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */