/*     */ package com.bioxx.tfc.Items.Pottery;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.Metal.AlloyManager;
/*     */ import com.bioxx.tfc.Core.Metal.AlloyMetal;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IBag;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPotterySmallVessel
/*     */   extends ItemPotteryBase
/*     */   implements IBag
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon overlayIcon;
/*     */   
/*     */   public ItemPotterySmallVessel() {
/*  48 */     this.metaNames = new String[] { "Clay Vessel", "Ceramic Vessel", "Ceramic Vessel" };
/*  49 */     func_77625_d(1);
/*  50 */     setWeight(EnumWeight.MEDIUM);
/*  51 */     setSize(EnumSize.SMALL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  58 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  64 */     if (pass == 1 && stack.func_77978_p() != null && stack.func_77978_p().func_74764_b("color")) {
/*  65 */       return this.overlayIcon;
/*     */     }
/*  67 */     return super.getIcon(stack, pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  73 */     super.func_94581_a(registerer);
/*  74 */     this.overlayIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + "Ceramic Vessel Overlay");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  80 */     list.add(new ItemStack((Item)this, 1, 0));
/*  81 */     list.add(new ItemStack((Item)this, 1, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDoneCooking(World world, ItemStack is, Alloy.EnumTier furnaceTier) {
/*  93 */     ItemStack[] bag = loadBagInventory(is);
/*  94 */     boolean canCookAlloy = true;
/*  95 */     for (int i = 0; bag != null && i < 4; i++) {
/*     */       
/*  97 */       if (bag[i] != null)
/*     */       {
/*  99 */         if (!(bag[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemOreSmall) && !(bag[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemOre) && !(bag[i].func_77973_b() instanceof com.bioxx.tfc.Items.ItemNugget)) {
/* 100 */           canCookAlloy = false;
/*     */         }
/*     */       }
/*     */     } 
/* 104 */     if (is.func_77960_j() == 2) {
/*     */       
/* 106 */       NBTTagCompound tag = is.field_77990_d;
/* 107 */       long totalH = TFC_Time.getTotalHours();
/* 108 */       tag.func_74772_a("TempTimer", totalH);
/*     */     } 
/*     */     
/* 111 */     if (canCookAlloy && bag != null) {
/*     */       
/* 113 */       Metal[] types = new Metal[4];
/* 114 */       int[] metalAmounts = new int[4];
/*     */       
/* 116 */       if (bag[0] != null) {
/*     */         
/* 118 */         types[0] = ((ISmeltable)bag[0].func_77973_b()).getMetalType(bag[0]);
/* 119 */         metalAmounts[0] = ((ISmeltable)bag[0].func_77973_b()).getMetalReturnAmount(bag[0]) * (bag[0]).field_77994_a;
/*     */       } 
/*     */       
/* 122 */       if (bag[1] != null) {
/*     */         
/* 124 */         types[1] = ((ISmeltable)bag[1].func_77973_b()).getMetalType(bag[1]);
/* 125 */         metalAmounts[1] = ((ISmeltable)bag[1].func_77973_b()).getMetalReturnAmount(bag[1]) * (bag[1]).field_77994_a;
/*     */         
/* 127 */         if (mergeMetals(types[0], types[1], metalAmounts[0], metalAmounts[1]) != metalAmounts[0]) {
/*     */           
/* 129 */           metalAmounts[0] = mergeMetals(types[0], types[1], metalAmounts[0], metalAmounts[1]);
/* 130 */           types[1] = null;
/* 131 */           metalAmounts[1] = 0;
/*     */         } 
/*     */       } 
/*     */       
/* 135 */       if (bag[2] != null) {
/*     */         
/* 137 */         types[2] = ((ISmeltable)bag[2].func_77973_b()).getMetalType(bag[2]);
/* 138 */         metalAmounts[2] = ((ISmeltable)bag[2].func_77973_b()).getMetalReturnAmount(bag[2]) * (bag[2]).field_77994_a;
/*     */         
/* 140 */         if (mergeMetals(types[0], types[2], metalAmounts[0], metalAmounts[2]) != metalAmounts[0]) {
/*     */           
/* 142 */           metalAmounts[0] = mergeMetals(types[0], types[2], metalAmounts[0], metalAmounts[2]);
/* 143 */           types[2] = null;
/* 144 */           metalAmounts[2] = 0;
/*     */         } 
/* 146 */         if (mergeMetals(types[1], types[2], metalAmounts[1], metalAmounts[2]) != metalAmounts[1]) {
/*     */           
/* 148 */           metalAmounts[1] = mergeMetals(types[1], types[2], metalAmounts[1], metalAmounts[2]);
/* 149 */           types[2] = null;
/* 150 */           metalAmounts[2] = 0;
/*     */         } 
/*     */       } 
/* 153 */       if (bag[3] != null) {
/*     */         
/* 155 */         types[3] = ((ISmeltable)bag[3].func_77973_b()).getMetalType(bag[3]);
/* 156 */         metalAmounts[3] = ((ISmeltable)bag[3].func_77973_b()).getMetalReturnAmount(bag[3]) * (bag[3]).field_77994_a;
/*     */         
/* 158 */         if (mergeMetals(types[0], types[3], metalAmounts[0], metalAmounts[3]) != metalAmounts[0]) {
/*     */           
/* 160 */           metalAmounts[0] = mergeMetals(types[0], types[3], metalAmounts[0], metalAmounts[3]);
/* 161 */           types[3] = null;
/* 162 */           metalAmounts[3] = 0;
/*     */         } 
/* 164 */         if (mergeMetals(types[1], types[3], metalAmounts[1], metalAmounts[3]) != metalAmounts[1]) {
/*     */           
/* 166 */           metalAmounts[1] = mergeMetals(types[1], types[3], metalAmounts[1], metalAmounts[3]);
/* 167 */           types[3] = null;
/* 168 */           metalAmounts[3] = 0;
/*     */         } 
/* 170 */         if (mergeMetals(types[2], types[3], metalAmounts[2], metalAmounts[3]) != metalAmounts[2]) {
/*     */           
/* 172 */           metalAmounts[2] = mergeMetals(types[2], types[3], metalAmounts[2], metalAmounts[3]);
/* 173 */           types[3] = null;
/* 174 */           metalAmounts[3] = 0;
/*     */         } 
/*     */       } 
/*     */       
/* 178 */       int total = metalAmounts[0] + metalAmounts[1] + metalAmounts[2] + metalAmounts[3];
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
/* 189 */       if (total > 0) {
/*     */         
/* 191 */         float[] metalPercent = new float[4];
/* 192 */         metalPercent[0] = metalAmounts[0] / total * 100.0F;
/* 193 */         metalPercent[1] = metalAmounts[1] / total * 100.0F;
/* 194 */         metalPercent[2] = metalAmounts[2] / total * 100.0F;
/* 195 */         metalPercent[3] = metalAmounts[3] / total * 100.0F;
/*     */         
/* 197 */         List<AlloyMetal> a = new ArrayList<AlloyMetal>();
/* 198 */         if (types[0] != null)
/* 199 */           a.add(new AlloyMetal(types[0], metalPercent[0])); 
/* 200 */         if (types[1] != null)
/* 201 */           a.add(new AlloyMetal(types[1], metalPercent[1])); 
/* 202 */         if (types[2] != null)
/* 203 */           a.add(new AlloyMetal(types[2], metalPercent[2])); 
/* 204 */         if (types[3] != null) {
/* 205 */           a.add(new AlloyMetal(types[3], metalPercent[3]));
/*     */         }
/* 207 */         Metal match = AlloyManager.INSTANCE.matchesAlloy(a, furnaceTier);
/* 208 */         if (match != null) {
/*     */           
/* 210 */           Alloy output = new Alloy(match, total);
/* 211 */           NBTTagCompound tag = is.field_77990_d;
/* 212 */           tag.func_74778_a("MetalType", output.outputType.name);
/* 213 */           tag.func_74768_a("MetalAmount", (int)output.outputAmount);
/* 214 */           long totalH = TFC_Time.getTotalHours();
/* 215 */           tag.func_74772_a("TempTimer", totalH);
/* 216 */           is.func_77978_p().func_82580_o("Items");
/* 217 */           is.func_77964_b(2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int mergeMetals(Metal mt0, Metal mt1, int m0, int m1) {
/* 225 */     if (mt0 != null && mt1 != null && m0 > 0)
/*     */     {
/* 227 */       if (mt0.name.equals(mt1.name))
/* 228 */         return m0 + m1; 
/*     */     }
/* 230 */     return m0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack is, int pass) {
/* 237 */     if (pass != 1)
/*     */     {
/* 239 */       return 16777215;
/*     */     }
/*     */ 
/*     */     
/* 243 */     int j = getColor(is);
/*     */     
/* 245 */     if (j < 0)
/*     */     {
/* 247 */       return 16777215;
/*     */     }
/*     */     
/* 250 */     if (is.func_77960_j() == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 257 */       int r = Math.min((j >> 16) + 96, 255);
/* 258 */       int b = Math.min((j >> 8 & 0xFF) + 96, 255);
/* 259 */       int g = Math.min((j & 0xFF) + 96, 255);
/* 260 */       return r << 16 | b << 8 | g;
/*     */     } 
/*     */     
/* 263 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor(ItemStack is) {
/* 269 */     if (!is.func_77942_o() || !is.func_77978_p().func_74764_b("color")) {
/* 270 */       return -1;
/*     */     }
/* 272 */     return is.func_77978_p().func_74762_e("color");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack[] loadBagInventory(ItemStack is) {
/* 278 */     ItemStack[] bag = new ItemStack[4];
/* 279 */     if (is != null && is.func_77942_o() && is.func_77978_p().func_74764_b("Items")) {
/*     */       
/* 281 */       NBTTagList nbttaglist = is.func_77978_p().func_150295_c("Items", 10);
/* 282 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/* 284 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 285 */         byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 286 */         if (byte0 >= 0 && byte0 < 4) {
/* 287 */           bag[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */         }
/*     */       } 
/*     */     } else {
/* 291 */       return null;
/*     */     } 
/* 293 */     return bag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUpdate(ItemStack is, World world, int x, int y, int z) {
/* 299 */     ItemStack[] bag = loadBagInventory(is);
/* 300 */     if (bag != null) {
/*     */       
/* 302 */       TFC_Core.handleItemTicking(bag, world, x, y, z, 0.5F);
/* 303 */       for (ItemStack i : bag) {
/*     */         
/* 305 */         if (i != null && i.field_77994_a == 0)
/* 306 */           i = null; 
/*     */       } 
/* 308 */       saveContents(is, bag);
/*     */     } 
/* 310 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveContents(ItemStack vessel, ItemStack[] bag) {
/* 315 */     NBTTagList nbttaglist = new NBTTagList();
/* 316 */     for (int i = 0; i < 4; i++) {
/*     */       
/* 318 */       if (bag[i] != null) {
/*     */         
/* 320 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 321 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 322 */         bag[i].func_77955_b(nbttagcompound1);
/* 323 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 326 */     if (vessel != null) {
/*     */       
/* 328 */       if (!vessel.func_77942_o())
/* 329 */         vessel.func_77982_d(new NBTTagCompound()); 
/* 330 */       vessel.func_77978_p().func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
/* 337 */     if (!entityplayer.func_70093_af())
/*     */     {
/* 339 */       if (itemstack.func_77960_j() == 2) {
/*     */         
/* 341 */         NBTTagCompound nbt = itemstack.func_77978_p();
/* 342 */         if (nbt == null) {
/*     */           
/* 344 */           itemstack.func_77964_b(1);
/* 345 */           if (!world.field_72995_K)
/*     */           {
/*     */             
/* 348 */             String error = TFC_Core.translate("error.error") + " " + itemstack.func_77977_a() + " " + TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact");
/* 349 */             TerraFirmaCraft.LOG.error(error);
/* 350 */             TFC_Core.sendInfoMessage(entityplayer, (IChatComponent)new ChatComponentText(error));
/*     */           }
/*     */         
/* 353 */         } else if (nbt.func_74764_b("TempTimer")) {
/*     */           
/* 355 */           long temp = nbt.func_74763_f("TempTimer");
/* 356 */           if (TFC_Time.getTotalHours() - temp < 11L) {
/* 357 */             entityplayer.openGui(TerraFirmaCraft.instance, 19, entityplayer.field_70170_p, (int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v);
/*     */           }
/*     */         } 
/* 360 */       } else if (itemstack.func_77960_j() == 1) {
/*     */         
/* 362 */         entityplayer.openGui(TerraFirmaCraft.instance, 39, entityplayer.field_70170_p, (int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v);
/*     */       } 
/*     */     }
/* 365 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 371 */     NBTTagCompound tag = is.field_77990_d;
/* 372 */     if (tag != null) {
/*     */       
/* 374 */       if (tag.func_74764_b("MetalType")) {
/*     */         
/* 376 */         String name = tag.func_74779_i("MetalType");
/* 377 */         name = name.replace(" ", "");
/* 378 */         name = TFC_Core.translate("gui.metal." + name);
/*     */ 
/*     */         
/* 381 */         if (tag.func_74764_b("MetalAmount"))
/*     */         {
/*     */           
/* 384 */           name = name + " (" + tag.func_74762_e("MetalAmount") + " " + TFC_Core.translate("gui.units") + ")";
/*     */         }
/*     */         
/* 387 */         arraylist.add(EnumChatFormatting.DARK_GREEN + name);
/*     */       } 
/*     */       
/* 390 */       if (tag.func_74764_b("TempTimer")) {
/*     */         
/* 392 */         long total = TFC_Time.getTotalHours();
/* 393 */         long temp = tag.func_74763_f("TempTimer");
/* 394 */         if (total - temp < 11L) {
/* 395 */           arraylist.add(EnumChatFormatting.WHITE + TFC_Core.translate("gui.ItemHeat.Liquid"));
/*     */         } else {
/* 397 */           arraylist.add(EnumChatFormatting.WHITE + TFC_Core.translate("gui.ItemHeat.Solidified"));
/*     */         } 
/*     */       } 
/* 400 */       if (tag.func_74764_b("Items")) {
/*     */         
/* 402 */         NBTTagList nbttaglist = tag.func_150295_c("Items", 10);
/* 403 */         for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */           
/* 405 */           NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 406 */           byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 407 */           if (byte0 >= 0 && byte0 < 4) {
/*     */             
/* 409 */             ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound1);
/* 410 */             if (itemstack.field_77994_a > 0)
/*     */             {
/* 412 */               if (itemstack.func_77973_b() instanceof com.bioxx.tfc.Food.ItemFoodTFC) {
/*     */                 
/* 414 */                 float decay = Food.getDecay(itemstack);
/* 415 */                 float weight = Helper.roundNumber(Food.getWeight(itemstack), 100.0F);
/*     */                 
/* 417 */                 String ds = " " + EnumChatFormatting.DARK_GRAY + Helper.roundNumber(decay / weight * 100.0F, 10.0F) + "%";
/* 418 */                 if (decay <= 0.0F) {
/* 419 */                   ds = "";
/*     */                 }
/* 421 */                 arraylist.add(EnumChatFormatting.GOLD.toString() + itemstack.func_77973_b().func_77653_i(itemstack) + " " + EnumChatFormatting.WHITE + weight + "oz" + ds);
/*     */               } else {
/*     */                 
/* 424 */                 arraylist.add(EnumChatFormatting.GOLD.toString() + itemstack.field_77994_a + "x " + itemstack.func_77973_b().func_77653_i(itemstack));
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 435 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 437 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 438 */       arraylist.add(TFC_Core.translate("gui.PotteryBase.Inst0"));
/*     */       
/* 440 */       NBTTagCompound tag = is.field_77990_d;
/* 441 */       if (tag != null && tag.func_74764_b("TempTimer")) {
/*     */         
/* 443 */         long total = TFC_Time.getTotalHours();
/* 444 */         long temp = tag.func_74763_f("TempTimer");
/* 445 */         if (total - temp < 11L) {
/* 446 */           arraylist.add(TFC_Core.translate("gui.PotteryVesselSmall.Inst0"));
/*     */         }
/*     */       } else {
/* 449 */         arraylist.add(TFC_Core.translate("gui.PotteryVesselSmall.Inst0"));
/*     */       } 
/*     */     } else {
/*     */       
/* 453 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Pottery\ItemPotterySmallVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */