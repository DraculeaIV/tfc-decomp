/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.EntityJavelin;
/*     */ import com.bioxx.tfc.Items.ItemTFCArmor;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Events.EntityArmorCalcEvent;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import java.util.Random;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityMultiPart;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.boss.EntityDragonPart;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.common.ISpecialArmor;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.AttackEntityEvent;
/*     */ 
/*     */ public class EntityDamageHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onEntityHurt(LivingHurtEvent event) {
/*  41 */     EntityLivingBase entity = event.entityLiving;
/*  42 */     if (entity instanceof EntityPlayer) {
/*     */       
/*  44 */       float curMaxHealth = (float)((EntityPlayer)entity).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*  45 */       float newMaxHealth = FoodStatsTFC.getMaxHealth((EntityPlayer)entity);
/*  46 */       float h = ((EntityPlayer)entity).func_110143_aJ();
/*  47 */       if (newMaxHealth != curMaxHealth)
/*  48 */         ((EntityPlayer)entity).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(newMaxHealth); 
/*  49 */       if (newMaxHealth < h) {
/*  50 */         ((EntityPlayer)entity).func_70606_j(newMaxHealth);
/*     */       }
/*     */     } 
/*  53 */     if (event.source == DamageSource.field_76370_b) {
/*     */       
/*  55 */       event.ammount = 50.0F;
/*     */     }
/*  57 */     else if (event.source == DamageSource.field_76379_h) {
/*     */       
/*  59 */       float healthMod = TFC_Core.getEntityMaxHealth(entity) / 1000.0F;
/*  60 */       event.ammount *= 80.0F * healthMod;
/*     */     }
/*  62 */     else if (event.source == DamageSource.field_76369_e) {
/*     */       
/*  64 */       event.ammount = 50.0F;
/*     */     }
/*  66 */     else if (event.source == DamageSource.field_76371_c) {
/*     */       
/*  68 */       event.ammount = 100.0F;
/*     */     }
/*  70 */     else if (event.source == DamageSource.field_76368_d) {
/*     */       
/*  72 */       event.ammount = 100.0F;
/*     */     }
/*  74 */     else if (event.source == DamageSource.field_82729_p) {
/*     */       
/*  76 */       event.ammount = 100.0F;
/*     */     }
/*  78 */     else if (event.source.func_94541_c()) {
/*     */       
/*  80 */       event.ammount *= 30.0F;
/*     */     }
/*  82 */     else if (event.source == DamageSource.field_76376_m && entity.func_110143_aJ() > 25.0F) {
/*     */       
/*  84 */       event.ammount = 25.0F;
/*     */     }
/*  86 */     else if ("player".equals(event.source.field_76373_n) || "mob".equals(event.source.field_76373_n) || "arrow".equals(event.source.field_76373_n)) {
/*     */       
/*  88 */       event.ammount = applyArmorCalculations(entity, event.source, event.ammount);
/*  89 */       if ("arrow".equals(event.source.field_76373_n)) {
/*     */         
/*  91 */         Entity e = ((EntityDamageSourceIndirect)event.source).func_76364_f();
/*  92 */         if (e instanceof EntityJavelin) {
/*     */           
/*  94 */           ((EntityJavelin)e).setDamageTaken((short)(((EntityJavelin)e).damageTaken + 10));
/*  95 */           if (((EntityJavelin)e).damageTaken >= ((EntityJavelin)e).pickupItem.func_77612_l())
/*     */           {
/*  97 */             e.func_70106_y();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int applyArmorCalculations(EntityLivingBase entity, DamageSource source, float originalDamage) {
/* 106 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 108 */       EntityPlayer player = (EntityPlayer)entity;
/* 109 */       originalDamage = ISpecialArmor.ArmorProperties.ApplyArmor((EntityLivingBase)player, player.field_71071_by.field_70460_b, source, (originalDamage * 0.048F)) / 0.048F;
/*     */     } 
/* 111 */     ItemStack[] armor = entity.func_70035_c();
/* 112 */     int pierceRating = 0;
/* 113 */     int slashRating = 0;
/* 114 */     int crushRating = 0;
/*     */     
/* 116 */     EntityArmorCalcEvent eventPre = new EntityArmorCalcEvent(entity, originalDamage, EntityArmorCalcEvent.EventType.PRE);
/* 117 */     MinecraftForge.EVENT_BUS.post((Event)eventPre);
/* 118 */     float damage = eventPre.incomingDamage;
/*     */     
/* 120 */     if (!source.func_76363_c() && armor != null) {
/*     */ 
/*     */       
/* 123 */       int location = getRandomSlot(entity.func_70681_au());
/*     */ 
/*     */       
/* 126 */       if (armor[location] != null && armor[location].func_77973_b() instanceof ItemTFCArmor) {
/*     */         
/* 128 */         pierceRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getPiercingAR();
/* 129 */         slashRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getSlashingAR();
/* 130 */         crushRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getCrushingAR();
/* 131 */         if (entity instanceof IInnateArmor) {
/*     */           
/* 133 */           pierceRating += ((IInnateArmor)entity).getPierceArmor();
/* 134 */           slashRating += ((IInnateArmor)entity).getSlashArmor();
/* 135 */           crushRating += ((IInnateArmor)entity).getCrushArmor();
/*     */         } 
/*     */ 
/*     */         
/* 139 */         float pierceMult = getDamageReduction(pierceRating);
/* 140 */         float slashMult = getDamageReduction(slashRating);
/* 141 */         float crushMult = getDamageReduction(crushRating);
/*     */ 
/*     */         
/* 144 */         damage = processDamageSource(source, damage, pierceMult, slashMult, crushMult);
/*     */ 
/*     */ 
/*     */         
/* 148 */         armor[location].func_77972_a((int)processArmorDamage(armor[location], damage), entity);
/*     */       }
/* 150 */       else if (armor[location] == null || (armor[location] != null && !(armor[location].func_77973_b() instanceof ItemTFCArmor))) {
/*     */         
/* 152 */         if (entity instanceof IInnateArmor) {
/*     */           
/* 154 */           pierceRating += ((IInnateArmor)entity).getPierceArmor();
/* 155 */           slashRating += ((IInnateArmor)entity).getSlashArmor();
/* 156 */           crushRating += ((IInnateArmor)entity).getCrushArmor();
/*     */         } 
/*     */         
/* 159 */         float pierceMult = getDamageReduction(pierceRating);
/* 160 */         float slashMult = getDamageReduction(slashRating);
/* 161 */         float crushMult = getDamageReduction(crushRating);
/*     */         
/* 163 */         damage = processDamageSource(source, damage, pierceMult, slashMult, crushMult);
/*     */ 
/*     */ 
/*     */         
/* 167 */         if (location == 3) {
/* 168 */           damage *= 1.75F;
/* 169 */         } else if (location == 0) {
/* 170 */           entity.func_70690_d(new PotionEffect(Potion.field_76421_d.func_76396_c(), 100, 1));
/*     */         } 
/*     */       } 
/* 173 */       EntityArmorCalcEvent eventPost = new EntityArmorCalcEvent(entity, damage, EntityArmorCalcEvent.EventType.POST);
/* 174 */       MinecraftForge.EVENT_BUS.post((Event)eventPost);
/*     */       
/* 176 */       float hasHealth = entity.func_110143_aJ();
/* 177 */       entity.func_70606_j(entity.func_110143_aJ() - eventPost.incomingDamage);
/* 178 */       entity.func_110142_aN().func_94547_a(source, hasHealth, eventPost.incomingDamage);
/*     */     } 
/* 180 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float processDamageSource(DamageSource source, float damage, float pierceMult, float slashMult, float crushMult) {
/* 186 */     EnumDamageType damageType = getDamageType(source);
/*     */     
/* 188 */     if (damageType == EnumDamageType.PIERCING) {
/*     */       
/* 190 */       damage *= pierceMult;
/*     */     }
/* 192 */     else if (damageType == EnumDamageType.SLASHING) {
/*     */       
/* 194 */       damage *= slashMult;
/*     */     }
/* 196 */     else if (damageType == EnumDamageType.CRUSHING) {
/*     */       
/* 198 */       damage *= crushMult;
/*     */     }
/* 200 */     else if (damageType == EnumDamageType.GENERIC) {
/*     */       
/* 202 */       damage = (float)(damage * (((crushMult + slashMult + pierceMult) / 3.0F) - 0.25D));
/*     */     } 
/* 204 */     return Math.max(0.0F, damage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumDamageType getDamageType(DamageSource source) {
/* 210 */     if (source.func_76364_f() instanceof EntityPlayer) {
/*     */       
/* 212 */       EntityPlayer player = (EntityPlayer)source.func_76364_f();
/* 213 */       if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ICausesDamage)
/*     */       {
/* 215 */         return ((ICausesDamage)player.func_71045_bC().func_77973_b()).getDamageType();
/*     */       }
/*     */     } 
/*     */     
/* 219 */     if (source.func_76364_f() instanceof EntityLiving) {
/*     */       
/* 221 */       EntityLiving el = (EntityLiving)source.func_76364_f();
/* 222 */       if (el.func_70694_bm() != null && el.func_70694_bm().func_77973_b() instanceof ICausesDamage)
/*     */       {
/* 224 */         return ((ICausesDamage)el.func_70694_bm().func_77973_b()).getDamageType();
/*     */       }
/*     */     } 
/*     */     
/* 228 */     if (source.func_76364_f() instanceof ICausesDamage)
/*     */     {
/* 230 */       return ((ICausesDamage)source.func_76364_f()).getDamageType();
/*     */     }
/*     */     
/* 233 */     return EnumDamageType.GENERIC;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getRandomSlot(Random rand) {
/* 238 */     int chance = rand.nextInt(100);
/* 239 */     if (chance < 10)
/* 240 */       return 3; 
/* 241 */     if (chance < 20)
/* 242 */       return 0; 
/* 243 */     if (chance < 80) {
/* 244 */       return 2;
/*     */     }
/* 246 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private float processArmorDamage(ItemStack armor, float baseDamage) {
/* 251 */     if (armor.func_77942_o()) {
/*     */       
/* 253 */       NBTTagCompound nbt = armor.func_77978_p();
/* 254 */       if (nbt.func_74764_b("armorReductionBuff")) {
/*     */         
/* 256 */         float reductBuff = nbt.func_74771_c("armorReductionBuff") / 100.0F;
/* 257 */         return baseDamage - baseDamage * reductBuff;
/*     */       } 
/*     */     } 
/* 260 */     return baseDamage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getDamageReduction(int armorRating) {
/* 269 */     if (armorRating == -1000)
/* 270 */       armorRating = -999; 
/* 271 */     return 1000.0F / (1000.0F + armorRating);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onAttackEntity(AttackEntityEvent event) {
/* 277 */     if (event.entityLiving.field_70170_p.field_72995_K) {
/*     */       return;
/*     */     }
/* 280 */     EntityLivingBase attacker = event.entityLiving;
/* 281 */     EntityPlayer player = event.entityPlayer;
/* 282 */     Entity target = event.target;
/* 283 */     ItemStack stack = attacker.func_71124_b(0);
/* 284 */     if (stack != null && stack.func_77973_b().onLeftClickEntity(stack, player, target)) {
/*     */       return;
/*     */     }
/* 287 */     if (target.func_70075_an())
/*     */     {
/* 289 */       if (!target.func_85031_j(target)) {
/*     */         
/* 291 */         float damageAmount = 10.0F;
/* 292 */         if (stack != null) {
/*     */           
/* 294 */           damageAmount = (float)player.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*     */           
/* 296 */           if (damageAmount == 1.0F)
/*     */           {
/* 298 */             damageAmount = 10.0F;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 303 */         if (player.func_70644_a(Potion.field_76420_g)) {
/* 304 */           damageAmount += (3 << player.func_70660_b(Potion.field_76420_g).func_76458_c());
/*     */         }
/* 306 */         if (player.func_70644_a(Potion.field_76437_t)) {
/* 307 */           damageAmount -= (2 << player.func_70660_b(Potion.field_76437_t).func_76458_c());
/*     */         }
/* 309 */         int knockback = 0;
/* 310 */         float enchantmentDamage = 0.0F;
/*     */         
/* 312 */         if (target instanceof EntityLiving) {
/*     */           
/* 314 */           enchantmentDamage = EnchantmentHelper.func_77512_a((EntityLivingBase)player, (EntityLivingBase)target);
/* 315 */           knockback += EnchantmentHelper.func_77507_b((EntityLivingBase)player, (EntityLivingBase)target);
/*     */         } 
/*     */         
/* 318 */         if (player.func_70051_ag()) {
/* 319 */           knockback++;
/*     */         }
/* 321 */         if (damageAmount > 0.0F || enchantmentDamage > 0.0F) {
/*     */ 
/*     */ 
/*     */           
/* 325 */           boolean criticalHit = (player.field_70143_R > 0.0F && !player.field_70122_E && !player.func_70617_f_() && !player.func_70090_H() && !player.func_70644_a(Potion.field_76440_q) && player.field_70154_o == null && target instanceof EntityLiving);
/*     */ 
/*     */           
/* 328 */           if (criticalHit && damageAmount > 0.0F) {
/* 329 */             damageAmount += event.entity.field_70170_p.field_73012_v.nextInt((int)(damageAmount / 2.0F + 2.0F));
/*     */           }
/* 331 */           damageAmount += enchantmentDamage;
/* 332 */           boolean onFire = false;
/* 333 */           int fireAspect = EnchantmentHelper.func_90036_a((EntityLivingBase)player);
/*     */           
/* 335 */           if (target instanceof EntityLiving && fireAspect > 0 && !target.func_70027_ad()) {
/*     */             
/* 337 */             onFire = true;
/* 338 */             target.func_70015_d(1);
/*     */           } 
/*     */           
/* 341 */           boolean entityAttacked = target.func_70097_a(DamageSource.func_76365_a(player), damageAmount);
/*     */           
/* 343 */           if (entityAttacked) {
/*     */             
/* 345 */             if (knockback > 0) {
/*     */               
/* 347 */               target.func_70024_g((-MathHelper.func_76126_a(player.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F), 0.1D, (
/* 348 */                   MathHelper.func_76134_b(player.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F));
/* 349 */               player.field_70159_w *= 0.6D;
/* 350 */               player.field_70179_y *= 0.6D;
/* 351 */               player.func_70031_b(false);
/*     */             } 
/*     */             
/* 354 */             if (criticalHit) {
/* 355 */               player.func_71009_b(target);
/*     */             }
/* 357 */             if (enchantmentDamage > 0.0F) {
/* 358 */               player.func_71047_c(target);
/*     */             }
/* 360 */             if (damageAmount >= 18.0F) {
/* 361 */               player.func_71029_a((StatBase)AchievementList.field_75999_E);
/*     */             }
/* 363 */             player.func_130011_c(target);
/*     */             
/* 365 */             if (target instanceof EntityLiving) {
/* 366 */               target.func_70097_a(DamageSource.func_92087_a((Entity)attacker), damageAmount);
/*     */             }
/*     */           } 
/* 369 */           ItemStack itemstack = player.func_71045_bC();
/* 370 */           Object object = target;
/*     */           
/* 372 */           if (target instanceof EntityDragonPart) {
/*     */             
/* 374 */             IEntityMultiPart ientitymultipart = ((EntityDragonPart)target).field_70259_a;
/* 375 */             if (ientitymultipart instanceof EntityLiving) {
/* 376 */               object = ientitymultipart;
/*     */             }
/*     */           } 
/* 379 */           if (itemstack != null && object instanceof EntityLiving) {
/*     */             
/* 381 */             itemstack.func_77961_a((EntityLivingBase)object, player);
/* 382 */             if (itemstack.field_77994_a <= 0) {
/* 383 */               player.func_71028_bD();
/*     */             }
/*     */           } 
/* 386 */           if (target instanceof EntityLivingBase) {
/*     */             
/* 388 */             player.func_71064_a(StatList.field_75951_w, Math.round(damageAmount * 10.0F));
/* 389 */             if (fireAspect > 0 && entityAttacked) {
/* 390 */               target.func_70015_d(fireAspect * 4);
/* 391 */             } else if (onFire) {
/* 392 */               target.func_70066_B();
/*     */             } 
/*     */           } 
/* 395 */           player.func_71020_j(0.3F);
/*     */         } 
/*     */       } 
/*     */     }
/* 399 */     event.setCanceled(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\EntityDamageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */