/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
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
/*  51 */     if (iinventory != null && 
/*  52 */       item == TFCItems.wool) {
/*     */       
/*  54 */       int size = 0;
/*  55 */       for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */         
/*  57 */         if (iinventory.func_70301_a(i) != null) {
/*     */           
/*  59 */           if (iinventory.func_70301_a(i).func_77973_b() == TFCItems.sheepSkin)
/*  60 */             size = iinventory.func_70301_a(i).func_77960_j(); 
/*  61 */           if (iinventory.func_70301_a(i).func_77973_b() == TFCItems.pbearSkin)
/*  62 */             size = iinventory.func_70301_a(i).func_77960_j(); 
/*     */         } 
/*     */       } 
/*  65 */       TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.hide, 1, size), player);
/*     */     } 
/*     */ 
/*     */     
/*  69 */     triggerAchievements(player, itemstack, item, itemDamage);
/*     */ 
/*     */     
/*  72 */     if (item == Item.func_150898_a(TFCBlocks.workbench)) {
/*     */       
/*  74 */       if (!player.getEntityData().func_74764_b("craftingTable")) {
/*  75 */         player.field_71071_by.func_146027_a(Item.func_150898_a(TFCBlocks.workbench), -1);
/*     */       }
/*  77 */       if (!player.field_70170_p.field_72995_K)
/*     */       {
/*  79 */         if (!player.getEntityData().func_74764_b("craftingTable")) {
/*     */           
/*  81 */           player.getEntityData().func_74757_a("craftingTable", true);
/*     */           
/*     */           try {
/*  84 */             PlayerUpdatePacket playerUpdatePacket = new PlayerUpdatePacket(player, 2);
/*  85 */             TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)playerUpdatePacket, (EntityPlayerMP)player);
/*  86 */           } catch (Exception e1) {
/*     */             
/*  88 */             TerraFirmaCraft.LOG.info("--------------------------------------------------");
/*  89 */             TerraFirmaCraft.LOG.catching(e1);
/*  90 */             TerraFirmaCraft.LOG.info("--------------------------------------------------");
/*     */           } 
/*  92 */           PlayerInventory.upgradePlayerCrafting(player);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  97 */     if (!player.field_70170_p.field_72995_K && item instanceof com.bioxx.tfc.Items.ItemIngot)
/*     */     {
/*  99 */       for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */         
/* 101 */         ItemStack is = iinventory.func_70301_a(i);
/* 102 */         if (is != null)
/*     */         {
/* 104 */           if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */             
/* 106 */             if (player.field_70170_p.field_73012_v.nextInt(20) == 0) {
/* 107 */               player.field_70170_p.func_72956_a((Entity)player, "terrafirmacraft:item.ceramicbreak", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F); break;
/*     */             } 
/* 109 */             TFC_Core.giveItemToPlayer(new ItemStack(TFCItems.ceramicMold, 1, 1), player);
/*     */             break;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void preCraft(EntityPlayer player, ItemStack itemstack, IInventory iinventory) {
/* 119 */     triggerAchievements(player, itemstack, itemstack.func_77973_b(), itemstack.func_77960_j());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void triggerAchievements(EntityPlayer player, ItemStack itemstack, Item item, int itemDamage) {
/* 124 */     if (item instanceof com.bioxx.tfc.Items.Tools.ItemCustomPickaxe) {
/*     */       
/* 126 */       player.func_71029_a((StatBase)TFC_Achievements.achPickaxe);
/*     */     }
/* 128 */     else if (item instanceof com.bioxx.tfc.Items.Tools.ItemCustomSaw) {
/*     */       
/* 130 */       player.func_71029_a((StatBase)TFC_Achievements.achSaw);
/*     */     }
/* 132 */     else if ((item instanceof com.bioxx.tfc.Items.ItemBlocks.ItemAnvil1 && itemDamage == 2) || (item instanceof com.bioxx.tfc.Items.ItemBlocks.ItemAnvil2 && (itemDamage == 1 || itemDamage == 2))) {
/*     */       
/* 134 */       player.func_71029_a((StatBase)TFC_Achievements.achBronzeAge);
/*     */     }
/* 136 */     else if (item == Item.func_150898_a(TFCBlocks.blastFurnace)) {
/* 137 */       player.func_71029_a((StatBase)TFC_Achievements.achBlastFurnace);
/* 138 */     } else if (item == TFCItems.clayBall && itemDamage == 1) {
/* 139 */       player.func_71029_a((StatBase)TFC_Achievements.achFireClay);
/* 140 */     } else if (item == TFCItems.unknownIngot) {
/* 141 */       player.func_71029_a((StatBase)TFC_Achievements.achUnknown);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void transferNBT(boolean clearContents, EntityPlayer player, ItemStack itemstack, IInventory iinventory) {
/* 149 */     Item item = itemstack.func_77973_b();
/* 150 */     int itemDamage = itemstack.func_77960_j();
/* 151 */     if (item instanceof com.bioxx.tfc.Items.ItemIngot) {
/*     */       
/* 153 */       float temperature = 0.0F;
/* 154 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 156 */         if (iinventory.func_70301_a(j) != null)
/*     */         {
/* 158 */           if (iinventory.func_70301_a(j).func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal)
/*     */           {
/* 160 */             temperature = TFC_ItemHeat.getTemp(iinventory.func_70301_a(j)); } 
/*     */         }
/*     */       } 
/* 163 */       TFC_ItemHeat.setTemp(itemstack, temperature);
/*     */     }
/* 165 */     else if (item instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */       
/* 167 */       float temperature = 0.0F;
/* 168 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 170 */         if (iinventory.func_70301_a(j) != null)
/*     */         {
/* 172 */           if (iinventory.func_70301_a(j).func_77973_b() instanceof com.bioxx.tfc.Items.ItemIngot)
/* 173 */             temperature = TFC_ItemHeat.getTemp(iinventory.func_70301_a(j));  } 
/*     */       } 
/* 175 */       TFC_ItemHeat.setTemp(itemstack, temperature);
/*     */     }
/* 177 */     else if (item == TFCItems.potterySmallVessel && itemDamage == 0) {
/*     */       
/* 179 */       int color = -1;
/* 180 */       for (int j = 0; j < iinventory.func_70302_i_(); j++) {
/*     */         
/* 182 */         if (iinventory.func_70301_a(j) != null) {
/*     */ 
/*     */           
/* 185 */           int[] ids = OreDictionary.getOreIDs(iinventory.func_70301_a(j));
/* 186 */           float[] c = null;
/* 187 */           for (int id : ids) {
/*     */             
/* 189 */             String name = OreDictionary.getOreName(id);
/* 190 */             for (int k = 0; k < Global.DYE_NAMES.length; k++) {
/*     */               
/* 192 */               if (name.equals(Global.DYE_NAMES[k])) {
/*     */                 
/* 194 */                 c = EntitySheep.field_70898_d[k];
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/* 200 */           if (c != null) {
/*     */             
/* 202 */             int r = (int)(c[0] * 255.0F);
/* 203 */             int g = (int)(c[1] * 255.0F);
/* 204 */             int b = (int)(c[2] * 255.0F);
/* 205 */             r <<= 16;
/* 206 */             g <<= 8;
/*     */             
/* 208 */             color += r += g += b;
/*     */           } 
/*     */         } 
/*     */       } 
/* 212 */       if (color != -1) {
/*     */         
/* 214 */         NBTTagCompound nbt = null;
/* 215 */         if (itemstack.func_77942_o()) {
/* 216 */           nbt = itemstack.func_77978_p();
/*     */         } else {
/* 218 */           nbt = new NBTTagCompound();
/*     */         } 
/* 220 */         nbt.func_74768_a("color", color);
/* 221 */         itemstack.func_77982_d(nbt);
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 227 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 232 */         if (iinventory.func_70301_a(i).func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemMiscToolHead && iinventory
/* 233 */           .func_70301_a(i).func_77942_o() && iinventory.func_70301_a(i).func_77978_p().func_74764_b("craftingTag"))
/*     */         {
/* 235 */           AnvilManager.setCraftTag(itemstack, AnvilManager.getCraftTag(iinventory.func_70301_a(i)));
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean gridHasItem(IInventory iinventory, Item item) {
/* 242 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 244 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 246 */         if (iinventory.func_70301_a(i).func_77973_b() == item)
/* 247 */           return true;  } 
/*     */     } 
/* 249 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, Item[] items) {
/* 254 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 256 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 258 */         for (int j = 0; j < items.length; j++)
/* 259 */           damageItem(entityplayer, iinventory, i, items[j]); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void handleItem(EntityPlayer entityplayer, IInventory iinventory, List<ItemStack> items) {
/* 265 */     for (int i = 0; i < iinventory.func_70302_i_(); i++) {
/*     */       
/* 267 */       if (iinventory.func_70301_a(i) != null)
/*     */       {
/* 269 */         for (ItemStack is : items)
/* 270 */           damageItem(entityplayer, iinventory, i, is.func_77973_b()); 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void damageItem(EntityPlayer entityplayer, IInventory iinventory, int i, Item shiftedindex) {
/* 276 */     if (iinventory.func_70301_a(i).func_77973_b() == shiftedindex) {
/*     */       
/* 278 */       int index = i;
/* 279 */       ItemStack item = iinventory.func_70301_a(index).func_77946_l();
/* 280 */       if (item != null) {
/*     */         
/* 282 */         item.func_77972_a(1, (EntityLivingBase)entityplayer);
/* 283 */         if (item.func_77960_j() != 0 || entityplayer.field_71075_bZ.field_75098_d) {
/*     */           
/* 285 */           iinventory.func_70299_a(index, item);
/* 286 */           (iinventory.func_70301_a(index)).field_77994_a++;
/* 287 */           if ((iinventory.func_70301_a(index)).field_77994_a > 2)
/* 288 */             (iinventory.func_70301_a(index)).field_77994_a = 2; 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\CraftingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */