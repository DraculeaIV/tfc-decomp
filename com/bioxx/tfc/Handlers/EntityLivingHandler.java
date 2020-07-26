/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.EntityProjectileTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.PlayerUpdatePacket;
/*     */ import com.bioxx.tfc.Items.ItemQuiver;
/*     */ import com.bioxx.tfc.Items.Tools.ItemCustomBow;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.TFCAttributes;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraftforge.client.event.FOVUpdateEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityLivingHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onEntityLivingUpdate(LivingEvent.LivingUpdateEvent event) {
/*  59 */     if (event.entityLiving instanceof EntityPlayer) {
/*     */       
/*  61 */       EntityPlayer player = (EntityPlayer)event.entityLiving;
/*     */       
/*  63 */       float newMaxHealth = FoodStatsTFC.getMaxHealth(player);
/*  64 */       float oldMaxHealth = (float)player.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*  65 */       if (oldMaxHealth != newMaxHealth)
/*     */       {
/*  67 */         player.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(newMaxHealth);
/*     */       }
/*     */       
/*  70 */       if (!player.field_70170_p.field_72995_K) {
/*     */ 
/*     */         
/*  73 */         TFC_Core.handleItemTicking(player.field_71071_by.field_70462_a, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  82 */         player.func_71024_bL().func_75122_a(20 - player.func_71024_bL().func_75116_a(), 0.0F);
/*     */         
/*  84 */         FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/*  85 */         foodstats.onUpdate(player);
/*  86 */         TFC_Core.setPlayerFoodStats(player, foodstats);
/*     */         
/*  88 */         if (foodstats.shouldSendUpdate()) {
/*     */           
/*  90 */           PlayerUpdatePacket playerUpdatePacket = new PlayerUpdatePacket(player, 0);
/*  91 */           TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)playerUpdatePacket, (EntityPlayerMP)player);
/*     */         } 
/*  93 */         if (foodstats.waterLevel / foodstats.getMaxWater(player) <= 0.25F) {
/*     */           
/*  95 */           setThirsty(player, true);
/*     */         }
/*  97 */         else if (foodstats.waterLevel / foodstats.getMaxWater(player) <= 0.5F) {
/*     */           
/*  99 */           if (player.func_70051_ag()) {
/* 100 */             player.func_70031_b(false);
/*     */           }
/*     */         } else {
/*     */           
/* 104 */           setThirsty(player, false);
/*     */         } 
/* 106 */         if (foodstats.stomachLevel / foodstats.getMaxStomach(player) <= 0.25F) {
/*     */           
/* 108 */           player.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 20, 1));
/* 109 */           player.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 20, 1));
/* 110 */           player.func_70690_d(new PotionEffect(2, 20, 1));
/*     */         } 
/*     */ 
/*     */         
/* 114 */         boolean isOverburdened = false;
/* 115 */         if (!player.field_71075_bZ.field_75098_d)
/*     */         {
/* 117 */           for (int i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
/*     */             
/* 119 */             ItemStack is = player.field_71071_by.func_70301_a(i);
/* 120 */             if (is != null && is.func_77973_b() instanceof IEquipable) {
/*     */               
/* 122 */               isOverburdened = ((IEquipable)is.func_77973_b()).getTooHeavyToCarry(is);
/* 123 */               if (isOverburdened) {
/*     */                 break;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/* 129 */         setOverburdened(player, isOverburdened);
/*     */ 
/*     */         
/* 132 */         NBTTagCompound nbt = player.getEntityData();
/* 133 */         long spawnProtectionTimer = nbt.func_74764_b("spawnProtectionTimer") ? nbt.func_74763_f("spawnProtectionTimer") : (TFC_Time.getTotalTicks() + 1000L);
/* 134 */         if (spawnProtectionTimer < TFC_Time.getTotalTicks())
/*     */         {
/*     */           
/* 137 */           for (int i = -2; i < 3; i++) {
/*     */             
/* 139 */             for (int k = -2; k < 3; k++) {
/*     */               
/* 141 */               int lastChunkX = (int)Math.floor(player.field_70165_t) >> 4;
/* 142 */               int lastChunkZ = (int)Math.floor(player.field_70161_v) >> 4;
/* 143 */               TFC_Core.getCDM(player.field_70170_p).addProtection(lastChunkX + i, lastChunkZ + k, TFCOptions.protectionGain);
/*     */             } 
/*     */           } 
/*     */           
/* 147 */           spawnProtectionTimer += 1000L;
/* 148 */           nbt.func_74772_a("spawnProtectionTimer", spawnProtectionTimer);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 153 */         PlayerInfo pi = PlayerManagerTFC.getInstance().getClientPlayer();
/* 154 */         FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(player);
/* 155 */         foodstats.clientUpdate();
/*     */         
/* 157 */         if (pi != null && pi.playerUUID.equals(player.func_110124_au())) {
/*     */           
/* 159 */           foodstats.onUpdate(player);
/* 160 */           if (player.field_71071_by.func_70448_g() != null) {
/*     */             
/* 162 */             if (player.field_71071_by.func_70448_g().func_77973_b() instanceof com.bioxx.tfc.Food.ItemMeal) {
/*     */               
/* 164 */               pi.guishowFoodRestoreAmount = true;
/* 165 */               pi.guiFoodRestoreAmount = Food.getWeight(player.field_71071_by.func_70448_g());
/*     */             }
/* 167 */             else if (player.field_71071_by.func_70448_g().func_77973_b() instanceof ItemFoodTFC) {
/*     */               
/* 169 */               pi.guishowFoodRestoreAmount = true;
/* 170 */               pi.guiFoodRestoreAmount = Food.getWeight(player.field_71071_by.func_70448_g());
/*     */             } else {
/*     */               
/* 173 */               pi.guishowFoodRestoreAmount = false;
/*     */             } 
/*     */           } else {
/* 176 */             pi.guishowFoodRestoreAmount = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setThirsty(EntityPlayer player, boolean b) {
/* 185 */     IAttributeInstance iattributeinstance = player.func_110148_a(SharedMonsterAttributes.field_111263_d);
/*     */     
/* 187 */     if (iattributeinstance.func_111127_a(TFCAttributes.THIRSTY_UUID) != null)
/*     */     {
/* 189 */       iattributeinstance.func_111124_b(TFCAttributes.THIRSTY);
/*     */     }
/*     */     
/* 192 */     if (b)
/*     */     {
/* 194 */       iattributeinstance.func_111121_a(TFCAttributes.THIRSTY);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOverburdened(EntityPlayer player, boolean b) {
/* 200 */     IAttributeInstance iattributeinstance = player.func_110148_a(SharedMonsterAttributes.field_111263_d);
/*     */     
/* 202 */     if (iattributeinstance.func_111127_a(TFCAttributes.OVERBURDENED_UUID) != null)
/*     */     {
/* 204 */       iattributeinstance.func_111124_b(TFCAttributes.OVERBURDENED);
/*     */     }
/*     */     
/* 207 */     if (b)
/*     */     {
/* 209 */       iattributeinstance.func_111121_a(TFCAttributes.OVERBURDENED);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void handleFOV(FOVUpdateEvent event) {
/* 217 */     EntityPlayerSP entityPlayerSP = event.entity;
/*     */ 
/*     */     
/* 220 */     IAttributeInstance iattributeinstance = entityPlayerSP.func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 221 */     if (iattributeinstance.func_111127_a(TFCAttributes.OVERBURDENED_UUID) != null) {
/*     */       
/* 223 */       event.newfov = 1.0F;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 228 */     if (entityPlayerSP.func_71039_bw() && entityPlayerSP.func_71011_bu().func_77973_b() instanceof ItemCustomBow) {
/*     */       
/* 230 */       float fov = 1.0F;
/* 231 */       int duration = entityPlayerSP.func_71057_bx();
/* 232 */       float speed = ItemCustomBow.getUseSpeed((EntityPlayer)entityPlayerSP);
/* 233 */       float force = duration / speed;
/*     */       
/* 235 */       if (force > 1.0F) {
/*     */         
/* 237 */         force = 1.0F;
/*     */       }
/*     */       else {
/*     */         
/* 241 */         force *= force;
/*     */       } 
/*     */       
/* 244 */       fov *= 1.0F - force * 0.15F;
/* 245 */       event.newfov = fov;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void handleItemPickup(EntityItemPickupEvent event) {
/* 252 */     EntityPlayer player = event.entityPlayer;
/* 253 */     ItemStack item = event.item.func_92059_d();
/* 254 */     if (player.field_71071_by instanceof InventoryPlayerTFC) {
/*     */       
/* 256 */       ItemStack backItem = ((InventoryPlayerTFC)player.field_71071_by).extraEquipInventory[0];
/*     */ 
/*     */       
/* 259 */       if (backItem == null && item.func_77973_b() instanceof IEquipable) {
/*     */         
/* 261 */         IEquipable equipment = (IEquipable)item.func_77973_b();
/* 262 */         if (equipment.getEquipType(item) == IEquipable.EquipType.BACK && (equipment == TFCItems.quiver || equipment.getTooHeavyToCarry(item)))
/*     */         {
/* 264 */           player.field_71071_by.func_70299_a(40, item.func_77946_l());
/* 265 */           item.field_77994_a = 0;
/* 266 */           event.item.func_92058_a(item);
/*     */         }
/*     */       
/*     */       }
/* 270 */       else if (backItem != null && backItem.func_77973_b() instanceof ItemQuiver) {
/*     */         
/* 272 */         ItemQuiver quiver = (ItemQuiver)backItem.func_77973_b();
/*     */ 
/*     */         
/* 275 */         if (item.func_77973_b() instanceof com.bioxx.tfc.Items.ItemArrow) {
/*     */           
/* 277 */           ItemStack is = quiver.addItem(backItem, item);
/* 278 */           if (is != null) {
/* 279 */             event.item.func_92058_a(is);
/*     */           } else {
/*     */             
/* 282 */             is = item;
/* 283 */             is.field_77994_a = 0;
/* 284 */             event.item.func_92058_a(is);
/* 285 */             event.setResult(Event.Result.DENY);
/*     */           }
/*     */         
/* 288 */         } else if (item.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin) {
/*     */ 
/*     */           
/* 291 */           boolean foundJav = false;
/* 292 */           for (int i = 0; i < 9; i++) {
/*     */             
/* 294 */             if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin) {
/* 295 */               foundJav = true;
/*     */             }
/*     */           } 
/*     */           
/* 299 */           if (foundJav) {
/*     */             
/* 301 */             ItemStack is = quiver.addItem(backItem, item);
/* 302 */             if (is == null) {
/*     */               
/* 304 */               is = item;
/* 305 */               is.field_77994_a = 0;
/* 306 */               event.item.func_92058_a(is);
/* 307 */               event.setResult(Event.Result.DENY);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     if (item.func_77973_b() == TFCItems.looseRock) {
/* 315 */       player.func_71029_a((StatBase)TFC_Achievements.achLooseRock);
/* 316 */     } else if (item.func_77973_b() instanceof com.bioxx.tfc.Items.ItemOreSmall) {
/* 317 */       player.func_71029_a((StatBase)TFC_Achievements.achSmallOre);
/* 318 */     } else if (item.func_77973_b() instanceof com.bioxx.tfc.Items.ItemBloom) {
/* 319 */       player.func_71029_a((StatBase)TFC_Achievements.achIronAge);
/* 320 */     } else if (item.func_77973_b().equals(TFCItems.gemDiamond)) {
/* 321 */       player.func_71029_a((StatBase)TFC_Achievements.achDiamond);
/* 322 */     } else if (item.func_77973_b().equals(TFCItems.onion) && TFCOptions.onionsAreGross) {
/* 323 */       player.func_71029_a((StatBase)TFC_Achievements.achRutabaga);
/* 324 */     } else if (item.func_77973_b().equals(TFCItems.oreChunk) && (item.func_77960_j() == 11 || item.func_77960_j() == 46 || item.func_77960_j() == 60)) {
/* 325 */       player.func_71029_a((StatBase)TFC_Achievements.achLimonite);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onEntityDeath(LivingDeathEvent event) {
/* 331 */     EntityLivingBase entity = event.entityLiving;
/*     */     
/* 333 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 335 */       EntityPlayer player = (EntityPlayer)entity;
/* 336 */       SkillStats skills = TFC_Core.getSkillStats(player);
/* 337 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/* 338 */       pi.tempSkills = skills;
/*     */ 
/*     */       
/* 341 */       if (entity.field_70170_p.func_82736_K().func_82766_b("keepInventory") && player.field_71071_by instanceof InventoryPlayerTFC)
/*     */       {
/* 343 */         pi.tempEquipment = (ItemStack[])((InventoryPlayerTFC)player.field_71071_by).extraEquipInventory.clone();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingDrop(LivingDropsEvent event) {
/* 355 */     boolean processed = false;
/* 356 */     if (!event.entity.field_70170_p.field_72995_K && event.recentlyHit && !(event.entity instanceof EntityPlayer) && !(event.entity instanceof net.minecraft.entity.monster.EntityZombie))
/*     */     {
/* 358 */       if (event.source.func_76364_f() instanceof EntityPlayer || event.source.func_76352_a()) {
/*     */         
/* 360 */         boolean foundFood = false;
/* 361 */         processed = true;
/* 362 */         ArrayList<EntityItem> drop = new ArrayList<EntityItem>();
/* 363 */         EntityPlayer p = null;
/* 364 */         if (event.source.func_76364_f() instanceof EntityPlayer) {
/* 365 */           p = (EntityPlayer)event.source.func_76364_f();
/* 366 */         } else if (event.source.func_76364_f() instanceof EntityProjectileTFC) {
/*     */           
/* 368 */           EntityProjectileTFC proj = (EntityProjectileTFC)event.source.func_76364_f();
/* 369 */           if (proj.field_70250_c instanceof EntityPlayer)
/* 370 */             p = (EntityPlayer)proj.field_70250_c; 
/*     */         } 
/* 372 */         for (EntityItem ei : event.drops) {
/*     */           
/* 374 */           ItemStack is = ei.func_92059_d();
/* 375 */           if (is.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */             
/* 377 */             if (p == null)
/*     */               continue; 
/* 379 */             foundFood = true;
/*     */             
/* 381 */             int sweetMod = Food.getSweetMod(is);
/* 382 */             int sourMod = Food.getSourMod(is);
/* 383 */             int saltyMod = Food.getSaltyMod(is);
/* 384 */             int bitterMod = Food.getBitterMod(is);
/* 385 */             int umamiMod = Food.getSavoryMod(is);
/*     */             
/* 387 */             float oldWeight = Food.getWeight(is);
/* 388 */             Food.setWeight(is, 0.0F);
/* 389 */             float newWeight = oldWeight * (TFC_Core.getSkillStats(p).getSkillMultiplier("skill.butchering") + 0.01F);
/* 390 */             while (newWeight >= 0.1F) {
/*     */               
/* 392 */               float fw = Helper.roundNumber(Math.min(160.0F, newWeight), 10.0F);
/* 393 */               if (fw < 160.0F)
/* 394 */                 newWeight = 0.0F; 
/* 395 */               newWeight -= fw;
/*     */               
/* 397 */               ItemStack result = ItemFoodTFC.createTag(new ItemStack(is.func_77973_b(), 1), fw);
/*     */               
/* 399 */               if (sweetMod != 0)
/* 400 */                 Food.setSweetMod(result, sweetMod); 
/* 401 */               if (sourMod != 0)
/* 402 */                 Food.setSourMod(result, sourMod); 
/* 403 */               if (saltyMod != 0)
/* 404 */                 Food.setSaltyMod(result, saltyMod); 
/* 405 */               if (bitterMod != 0)
/* 406 */                 Food.setBitterMod(result, bitterMod); 
/* 407 */               if (umamiMod != 0) {
/* 408 */                 Food.setSavoryMod(result, umamiMod);
/*     */               }
/* 410 */               drop.add(new EntityItem(event.entity.field_70170_p, event.entity.field_70165_t, event.entity.field_70163_u, event.entity.field_70161_v, result));
/*     */             } 
/*     */             
/*     */             continue;
/*     */           } 
/* 415 */           drop.add(ei);
/*     */         } 
/*     */         
/* 418 */         event.drops.clear();
/* 419 */         event.drops.addAll(drop);
/* 420 */         if (foundFood && p != null)
/*     */         {
/* 422 */           TFC_Core.getSkillStats(p).increaseSkill("skill.butchering", 1);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 427 */     if (!processed && !(event.entity instanceof EntityPlayer) && !(event.entity instanceof net.minecraft.entity.monster.EntityZombie)) {
/*     */       
/* 429 */       ArrayList<EntityItem> drop = new ArrayList<EntityItem>();
/* 430 */       for (EntityItem ei : event.drops) {
/*     */         
/* 432 */         if (!(ei.func_92059_d().func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood))
/*     */         {
/* 434 */           drop.add(ei);
/*     */         }
/*     */       } 
/* 437 */       event.drops.clear();
/* 438 */       event.drops.addAll(drop);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\EntityLivingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */