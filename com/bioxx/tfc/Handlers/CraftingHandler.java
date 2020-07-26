/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.Recipes;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.PlayerUpdatePacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatBase;
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
/*     */ public class CraftingHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onCrafting(PlayerEvent.ItemCraftedEvent e) {
/*  44 */     EntityPlayer player = e.player;
/*  45 */     ItemStack itemstack = e.crafting;
/*  46 */     Item item = itemstack.func_77973_b();
/*  47 */     int itemDamage = itemstack.func_77960_j();
/*  48 */     IInventory iinventory = e.craftMatrix;
/*     */ 
/*     */     
/*  51 */     if (iinventory != null) {
/*     */ 
/*     */       
/*  54 */       if (item == TFCItems.stoneBrick) {
/*     */         
/*  56 */         List<ItemStack> chisels = OreDictionary.getOres("itemChisel", false);
/*  57 */         handleItem(player, iinventory, chisels);
/*     */       }
/*  59 */       else if (item == TFCItems.singlePlank || item == 
/*  60 */         Item.func_150898_a(TFCBlocks.woodSupportH) || item == Item.func_150898_a(TFCBlocks.woodSupportH2) || item == 
/*  61 */         Item.func_150898_a(TFCBlocks.woodSupportV) || item == Item.func_150898_a(TFCBlocks.woodSupportV2)) {
/*     */         
/*  63 */         List<ItemStack> axes = OreDictionary.getOres("itemAxe", false);
/*  64 */         List<ItemStack> saws = OreDictionary.getOres("itemSaw", false);
/*  65 */         handleItem(player, iinventory, axes);
/*  66 */         handleItem(player, iinventory, saws);
/*     */       }
/*  68 */       else if (item == TFCItems.wool) {
/*     */         
/*  70 */         List<ItemStack> knives = OreDictionary.getOres("itemKnife", false);
/*  71 */         handleItem(player, iinventory, knives);
/*  72 */         int size = 0;
/*  73 */         for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */           
/*  75 */           if (iinventory.func_70301_a(i) != null)
/*     */           {
/*  77 */             if (iinventory.func_70301_a(i).func_77973_b() == TFCItems.sheepSkin)
/*  78 */               size = iinventory.func_70301_a(i).func_77960_j(); 
/*     */           }
/*     */         } 
/*  81 */         TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.hide, 1, size), player);
/*     */       }
/*  83 */       else if (item == TFCItems.woolYarn) {
/*     */         
/*  85 */         handleItem(player, iinventory, Recipes.spindle);
/*     */       }
/*  87 */       else if (item == TFCItems.powder && itemDamage == 0) {
/*     */         
/*  89 */         List<ItemStack> hammers = OreDictionary.getOres("itemHammer", false);
/*  90 */         handleItem(player, iinventory, hammers);
/*     */       } 
/*     */ 
/*     */       
/*  94 */       triggerAchievements(player, itemstack, item, itemDamage);
/*     */ 
/*     */       
/*  97 */       if (item == Item.func_150898_a(TFCBlocks.workbench)) {
/*     */         
/*  99 */         if (!player.getEntityData().func_74764_b("craftingTable")) {
/* 100 */           player.field_71071_by.func_146027_a(Item.func_150898_a(TFCBlocks.workbench), -1);
/*     */         }
/* 102 */         if (!player.field_70170_p.field_72995_K)
/*     */         {
/* 104 */           if (!player.getEntityData().func_74764_b("craftingTable")) {
/*     */             
/* 106 */             player.getEntityData().func_74757_a("craftingTable", true);
/*     */             
/*     */             try {
/* 109 */               PlayerUpdatePacket playerUpdatePacket = new PlayerUpdatePacket(player, 2);
/* 110 */               TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)playerUpdatePacket, (EntityPlayerMP)player);
/* 111 */             } catch (Exception e1) {
/*     */               
/* 113 */               TerraFirmaCraft.LOG.info("--------------------------------------------------");
/* 114 */               TerraFirmaCraft.LOG.catching(e1);
/* 115 */               TerraFirmaCraft.LOG.info("--------------------------------------------------");
/*     */             } 
/* 117 */             PlayerInventory.upgradePlayerCrafting(player);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 122 */       if (!player.field_70170_p.field_72995_K && item instanceof com.bioxx.tfc.Items.ItemIngot)
/*     */       {
/* 124 */         for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */           
/* 126 */           ItemStack is = iinventory.func_70301_a(i);
/* 127 */           if (is != null)
/*     */           {
/* 129 */             if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */               
/* 131 */               if (player.field_70170_p.field_73012_v.nextInt(20) == 0) {
/* 132 */                 player.field_70170_p.func_72956_a((Entity)player, "terrafirmacraft:item.ceramicbreak", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F); break;
/*     */               } 
/* 134 */               TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.ceramicMold, 1, 1), player);
/*     */               break;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void preCraft(EntityPlayer player, ItemStack itemstack, IInventory iinventory) {
/* 145 */     triggerAchievements(player, itemstack, itemstack.func_77973_b(), itemstack.func_77960_j());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void triggerAchievements(EntityPlayer player, ItemStack itemstack, Item item, int itemDamage) {
/* 150 */     if (item instanceof com.bioxx.tfc.Items.Tools.ItemCustomPickaxe) {
/*     */       
/* 152 */       player.func_71029_a((StatBase)TFC_Achievements.achPickaxe);
/*     */     }
/* 154 */     else if (item instanceof com.bioxx.tfc.Items.Tools.ItemCustomSaw) {
/*     */       
/* 156 */       player.func_71029_a((StatBase)TFC_Achievements.achSaw);
/*     */     }
/* 158 */     else if ((item instanceof com.bioxx.tfc.Items.ItemBlocks.ItemAnvil1 && itemDamage == 2) || (item instanceof com.bioxx.tfc.Items.ItemBlocks.ItemAnvil2 && (itemDamage == 1 || itemDamage == 2))) {
/*     */       
/* 160 */       player.func_71029_a((StatBase)TFC_Achievements.achBronzeAge);
/*     */     }
/* 162 */     else if (item == Item.func_150898_a(TFCBlocks.blastFurnace)) {
/* 163 */       player.func_71029_a((StatBase)TFC_Achievements.achBlastFurnace);
/* 164 */     } else if (item == TFCItems.clayBall && itemDamage == 1) {
/* 165 */       player.func_71029_a((StatBase)TFC_Achievements.achFireClay);
/* 166 */     } else if (item == TFCItems.unknownIngot) {
/* 167 */       player.func_71029_a((StatBase)TFC_Achievements.achUnknown);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void transferNBT(boolean clearContents, EntityPlayer player, ItemStack itemstack, IInventory iinventory) {
/* 175 */     Item item = itemstack.func_77973_b();
/* 176 */     int itemDamage = itemstack.func_77960_j();
/* 177 */     if (item instanceof com.bioxx.tfc.Items.ItemIngot) {
/*     */       
/* 179 */       float temperature = 0.0F;
/* 180 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 182 */         if (iinventory.func_70301_a(j) != null)
/*     */         {
/* 184 */           if (iinventory.func_70301_a(j).func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal)
/*     */           {
/* 186 */             temperature = TFC_ItemHeat.getTemp(iinventory.func_70301_a(j)); } 
/*     */         }
/*     */       } 
/* 189 */       TFC_ItemHeat.setTemp(itemstack, temperature);
/*     */     }
/* 191 */     else if (item instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */       
/* 193 */       float temperature = 0.0F;
/* 194 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 196 */         if (iinventory.func_70301_a(j) != null)
/*     */         {
/* 198 */           if (iinventory.func_70301_a(j).func_77973_b() instanceof com.bioxx.tfc.Items.ItemIngot)
/* 199 */             temperature = TFC_ItemHeat.getTemp(iinventory.func_70301_a(j));  } 
/*     */       } 
/* 201 */       TFC_ItemHeat.setTemp(itemstack, temperature);
/*     */     }
/* 203 */     else if (item == TFCItems.potterySmallVessel && itemDamage == 0) {
/*     */       
/* 205 */       int color = -1;
/* 206 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 208 */         if (iinventory.func_70301_a(j) != null) {
/*     */ 
/*     */           
/* 211 */           int[] ids = OreDictionary.getOreIDs(iinventory.func_70301_a(j));
/* 212 */           float[] c = null;
/* 213 */           for (int id : ids) {
/*     */             
/* 215 */             String name = OreDictionary.getOreName(id);
/* 216 */             for (int k = 0; k < Global.DYE_NAMES.length; k++) {
/*     */               
/* 218 */               if (name.equals(Global.DYE_NAMES[k])) {
/*     */                 
/* 220 */                 c = EntitySheep.field_70898_d[k];
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 226 */           if (c != null) {
/*     */             
/* 228 */             int r = (int)(c[0] * 255.0F);
/* 229 */             int g = (int)(c[1] * 255.0F);
/* 230 */             int b = (int)(c[2] * 255.0F);
/* 231 */             r <<= 16;
/* 232 */             g <<= 8;
/*     */             
/* 234 */             color += r += g += b;
/*     */           } 
/*     */         } 
/*     */       } 
/* 238 */       if (color != -1) {
/*     */         
/* 240 */         NBTTagCompound nbt = null;
/* 241 */         if (itemstack.func_77942_o()) {
/* 242 */           nbt = itemstack.func_77978_p();
/*     */         } else {
/* 244 */           nbt = new NBTTagCompound();
/*     */         } 
/* 246 */         nbt.func_74768_a("color", color);
/* 247 */         itemstack.func_77982_d(nbt);
/*     */       } 
/*     */     } 
/*     */     
/* 251 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 253 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 258 */         if (iinventory.func_70301_a(i).func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemMiscToolHead && iinventory
/* 259 */           .func_70301_a(i).func_77942_o() && iinventory.func_70301_a(i).func_77978_p().func_74764_b("craftingTag"))
/*     */         {
/* 261 */           AnvilManager.setCraftTag(itemstack, AnvilManager.getCraftTag(iinventory.func_70301_a(i)));
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean gridHasItem(IInventory iinventory, Item item) {
/* 268 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 270 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 272 */         if (iinventory.func_70301_a(i).func_77973_b() == item)
/* 273 */           return true;  } 
/*     */     } 
/* 275 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, Item[] items) {
/* 280 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 282 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 284 */         for (int j = 0; j < items.length; j++)
/* 285 */           damageItem(entityplayer, iinventory, i, items[j]); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, List<ItemStack> items) {
/* 291 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 293 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 295 */         for (ItemStack is : items)
/* 296 */           damageItem(entityplayer, iinventory, i, is.func_77973_b()); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void damageItem(EntityPlayer entityplayer, IInventory iinventory, int i, Item shiftedindex) {
/* 302 */     if (iinventory.func_70301_a(i).func_77973_b() == shiftedindex) {
/*     */       
/* 304 */       int index = i;
/* 305 */       ItemStack item = iinventory.func_70301_a(index).func_77946_l();
/* 306 */       if (item != null) {
/*     */         
/* 308 */         item.func_77972_a(1, (EntityLivingBase)entityplayer);
/* 309 */         if (item.func_77960_j() != 0 || entityplayer.field_71075_bZ.field_75098_d) {
/*     */           
/* 311 */           iinventory.func_70299_a(index, item);
/* 312 */           (iinventory.func_70301_a(index)).field_77994_a++;
/* 313 */           if ((iinventory.func_70301_a(index)).field_77994_a > 2)
/* 314 */             (iinventory.func_70301_a(index)).field_77994_a = 2; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\CraftingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */