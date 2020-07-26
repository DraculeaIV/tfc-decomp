/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemTerra
/*     */   extends Item
/*     */   implements ISize
/*     */ {
/*     */   protected boolean stackable = true;
/*  34 */   protected EnumSize size = EnumSize.TINY;
/*  35 */   protected EnumWeight weight = EnumWeight.LIGHT;
/*     */   
/*     */   public String[] metaNames;
/*     */   
/*     */   public IIcon[] metaIcons;
/*     */   public String textureFolder;
/*  41 */   private int craftingXP = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemTerra() {
/*  46 */     func_77637_a(TFCTabs.TFC_MISC);
/*  47 */     this.textureFolder = "";
/*  48 */     setNoRepair();
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setMetaNames(String[] metanames) {
/*  53 */     this.metaNames = (String[])metanames.clone();
/*  54 */     this.field_77787_bX = true;
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setCraftingXP(int m) {
/*  60 */     this.craftingXP = m;
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCraftingXP() {
/*  66 */     return this.craftingXP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  73 */     if (this.metaNames != null) {
/*     */       
/*  75 */       for (int i = 0; i < this.metaNames.length; i++)
/*     */       {
/*  77 */         list.add(new ItemStack(this, 1, i));
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  82 */       list.add(new ItemStack(this, 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/*  89 */     if (canStack()) {
/*  90 */       return ((getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier <= 64) ? ((getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier) : 64;
/*     */     }
/*  92 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setFolder(String s) {
/*  97 */     this.textureFolder = s;
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/* 104 */     if (this.metaNames == null) {
/*     */       
/* 106 */       if (this.field_111218_cA != null) {
/* 107 */         this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_111208_A());
/*     */       } else {
/* 109 */         this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", ""));
/*     */       } 
/*     */     } else {
/*     */       
/* 113 */       this.metaIcons = new IIcon[this.metaNames.length];
/* 114 */       for (int i = 0; i < this.metaNames.length; i++)
/*     */       {
/* 116 */         this.metaIcons[i] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[i]);
/*     */       }
/*     */ 
/*     */       
/* 120 */       this.field_77791_bV = this.metaIcons[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int i) {
/* 127 */     if (this.metaNames != null && i < this.metaNames.length) {
/* 128 */       return this.metaIcons[i];
/*     */     }
/* 130 */     return this.field_77791_bV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack itemstack) {
/* 136 */     if (this.metaNames != null && itemstack.func_77960_j() < this.metaNames.length)
/* 137 */       return func_77658_a().concat("." + this.metaNames[itemstack.func_77960_j()]); 
/* 138 */     return super.func_77667_c(itemstack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUpdate(ItemStack is, World world, int x, int y, int z) {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSizeInformation(ItemStack object, List<String> arraylist) {
/* 158 */     if (((ISize)object.func_77973_b()).getSize(object) != null && ((ISize)object.func_77973_b()).getWeight(object) != null && ((ISize)object.func_77973_b()).getReach(object) != null)
/* 159 */       arraylist.add("⚖" + TFC_Core.translate("gui.Weight." + ((ISize)object.func_77973_b()).getWeight(object).getName()) + " ⇲" + 
/* 160 */           TFC_Core.translate("gui.Size." + ((ISize)object.func_77973_b()).getSize(object).getName().replace(" ", ""))); 
/* 161 */     if (object.func_77973_b() instanceof IEquipable)
/*     */     {
/* 163 */       if (((IEquipable)object.func_77973_b()).getEquipType(object) == IEquipable.EquipType.BACK)
/*     */       {
/* 165 */         arraylist.add(EnumChatFormatting.LIGHT_PURPLE.toString() + TFC_Core.translate("gui.slot") + EnumChatFormatting.GRAY
/* 166 */             .toString() + ": " + EnumChatFormatting.WHITE
/* 167 */             .toString() + TFC_Core.translate("gui.slot.back"));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 177 */     addSizeInformation(is, arraylist);
/*     */     
/* 179 */     addHeatInformation(is, arraylist);
/*     */     
/* 181 */     if (is.func_77942_o()) {
/*     */       
/* 183 */       NBTTagCompound tag = is.func_77978_p();
/*     */       
/* 185 */       if (tag.func_74764_b("itemCraftingValue") || tag.func_74764_b("itemCraftingRule1")) {
/* 186 */         arraylist.add(TFC_Core.translate("gui.ItemWorked"));
/*     */       }
/*     */     } 
/* 189 */     addItemInformation(is, player, arraylist);
/* 190 */     addExtraInformation(is, player, arraylist);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 195 */     if (is.func_77973_b() instanceof ItemIngot || is
/* 196 */       .func_77973_b() instanceof ItemMetalSheet || is
/* 197 */       .func_77973_b() instanceof ItemUnfinishedArmor || is
/* 198 */       .func_77973_b() instanceof ItemBloom || is
/* 199 */       .func_77973_b() == TFCItems.wroughtIronKnifeHead)
/*     */     {
/* 201 */       if (TFC_ItemHeat.hasTemp(is)) {
/*     */         
/* 203 */         String s = "";
/* 204 */         if (HeatRegistry.getInstance().isTemperatureDanger(is).booleanValue())
/*     */         {
/* 206 */           s = s + EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.danger") + " | ";
/*     */         }
/*     */         
/* 209 */         if (HeatRegistry.getInstance().isTemperatureWeldable(is).booleanValue())
/*     */         {
/* 211 */           s = s + EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.weldable") + " | ";
/*     */         }
/*     */         
/* 214 */         if (HeatRegistry.getInstance().isTemperatureWorkable(is).booleanValue())
/*     */         {
/* 216 */           s = s + EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.workable");
/*     */         }
/*     */         
/* 219 */         if (!"".equals(s)) {
/* 220 */           arraylist.add(s);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addHeatInformation(ItemStack is, List<String> arraylist) {
/* 227 */     if (is.func_77942_o())
/*     */     {
/* 229 */       if (TFC_ItemHeat.hasTemp(is)) {
/*     */         
/* 231 */         float temp = TFC_ItemHeat.getTemp(is);
/* 232 */         float meltTemp = -1.0F;
/* 233 */         HeatIndex hi = HeatRegistry.getInstance().findMatchingIndex(is);
/* 234 */         if (hi != null) {
/* 235 */           meltTemp = hi.meltTemp;
/*     */         }
/* 237 */         if (meltTemp != -1.0F)
/*     */         {
/* 239 */           if (is.func_77973_b() == TFCItems.stick) {
/* 240 */             arraylist.add(TFC_ItemHeat.getHeatColorTorch(temp, meltTemp));
/*     */           } else {
/* 242 */             arraylist.add(TFC_ItemHeat.getHeatColor(temp, meltTemp));
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap func_111205_h() {
/* 256 */     return (Multimap)HashMultimap.create();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 262 */     return this.stackable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 268 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 273 */     return this.weight;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setSize(EnumSize e) {
/* 278 */     this.size = e;
/* 279 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setWeight(EnumWeight e) {
/* 284 */     this.weight = e;
/* 285 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 291 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemTerra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */