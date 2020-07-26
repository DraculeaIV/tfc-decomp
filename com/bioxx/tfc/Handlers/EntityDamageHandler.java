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
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.AttackEntityEvent;
/*     */ 
/*     */ public class EntityDamageHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onEntityHurt(LivingHurtEvent event) {
/*  40 */     EntityLivingBase entity = event.entityLiving;
/*  41 */     if (entity instanceof EntityPlayer) {
/*     */       
/*  43 */       float curMaxHealth = (float)((EntityPlayer)entity).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*  44 */       float newMaxHealth = FoodStatsTFC.getMaxHealth((EntityPlayer)entity);
/*  45 */       float h = ((EntityPlayer)entity).func_110143_aJ();
/*  46 */       if (newMaxHealth != curMaxHealth)
/*  47 */         ((EntityPlayer)entity).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(newMaxHealth); 
/*  48 */       if (newMaxHealth < h) {
/*  49 */         ((EntityPlayer)entity).func_70606_j(newMaxHealth);
/*     */       }
/*     */     } 
/*  52 */     if (event.source == DamageSource.field_76370_b) {
/*     */       
/*  54 */       event.ammount = 50.0F;
/*     */     }
/*  56 */     else if (event.source == DamageSource.field_76379_h) {
/*     */ 
/*     */       
/*  59 */       event.ammount *= 80.0F;
/*     */     }
/*  61 */     else if (event.source == DamageSource.field_76369_e) {
/*     */       
/*  63 */       event.ammount = 50.0F;
/*     */     }
/*  65 */     else if (event.source == DamageSource.field_76371_c) {
/*     */       
/*  67 */       event.ammount = 100.0F;
/*     */     }
/*  69 */     else if (event.source == DamageSource.field_76368_d) {
/*     */       
/*  71 */       event.ammount = 100.0F;
/*     */     }
/*  73 */     else if (event.source == DamageSource.field_82729_p) {
/*     */       
/*  75 */       event.ammount = 100.0F;
/*     */     }
/*  77 */     else if (event.source.func_94541_c()) {
/*     */       
/*  79 */       event.ammount *= 30.0F;
/*     */     }
/*  81 */     else if (event.source == DamageSource.field_76376_m || event.source == DamageSource.field_82727_n) {
/*     */       
/*  83 */       if (entity.func_110143_aJ() - 25.0F > TFC_Core.getEntityMaxHealth(entity) / 10.0F) {
/*     */         
/*  85 */         event.ammount = 25.0F;
/*     */       } else {
/*     */         
/*  88 */         event.ammount = entity.func_110143_aJ() - TFC_Core.getEntityMaxHealth(entity) / 10.0F;
/*     */       } 
/*  90 */     } else if ("player".equals(event.source.field_76373_n) || "mob".equals(event.source.field_76373_n) || "arrow".equals(event.source.field_76373_n)) {
/*     */       
/*  92 */       event.ammount = applyArmorCalculations(entity, event.source, event.ammount);
/*  93 */       if ("arrow".equals(event.source.field_76373_n)) {
/*     */         
/*  95 */         Entity e = ((EntityDamageSourceIndirect)event.source).func_76364_f();
/*  96 */         if (e instanceof EntityJavelin) {
/*     */           
/*  98 */           ((EntityJavelin)e).setDamageTaken((short)(((EntityJavelin)e).damageTaken + 10));
/*  99 */           if (((EntityJavelin)e).damageTaken >= ((EntityJavelin)e).pickupItem.func_77612_l())
/*     */           {
/* 101 */             e.func_70106_y();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int applyArmorCalculations(EntityLivingBase entity, DamageSource source, float originalDamage) {
/* 110 */     ItemStack[] armor = entity.func_70035_c();
/* 111 */     int pierceRating = 0;
/* 112 */     int slashRating = 0;
/* 113 */     int crushRating = 0;
/*     */     
/* 115 */     EntityArmorCalcEvent eventPre = new EntityArmorCalcEvent(entity, originalDamage, EntityArmorCalcEvent.EventType.PRE);
/* 116 */     MinecraftForge.EVENT_BUS.post((Event)eventPre);
/* 117 */     float damage = eventPre.incomingDamage;
/*     */     
/* 119 */     if (!source.func_76363_c() && armor != null) {
/*     */ 
/*     */       
/* 122 */       int location = getRandomSlot(entity.func_70681_au());
/*     */ 
/*     */       
/* 125 */       if (armor[location] != null && armor[location].func_77973_b() instanceof ItemTFCArmor) {
/*     */         
/* 127 */         pierceRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getPiercingAR();
/* 128 */         slashRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getSlashingAR();
/* 129 */         crushRating = ((ItemTFCArmor)armor[location].func_77973_b()).armorTypeTFC.getCrushingAR();
/* 130 */         if (entity instanceof IInnateArmor) {
/*     */           
/* 132 */           pierceRating += ((IInnateArmor)entity).getPierceArmor();
/* 133 */           slashRating += ((IInnateArmor)entity).getSlashArmor();
/* 134 */           crushRating += ((IInnateArmor)entity).getCrushArmor();
/*     */         } 
/*     */ 
/*     */         
/* 138 */         float pierceMult = getDamageReduction(pierceRating);
/* 139 */         float slashMult = getDamageReduction(slashRating);
/* 140 */         float crushMult = getDamageReduction(crushRating);
/*     */ 
/*     */         
/* 143 */         damage = processDamageSource(source, damage, pierceMult, slashMult, crushMult);
/*     */ 
/*     */ 
/*     */         
/* 147 */         armor[location].func_77972_a((int)processArmorDamage(armor[location], damage), entity);
/*     */       }
/* 149 */       else if (armor[location] == null || (armor[location] != null && !(armor[location].func_77973_b() instanceof ItemTFCArmor))) {
/*     */         
/* 151 */         if (entity instanceof IInnateArmor) {
/*     */           
/* 153 */           pierceRating += ((IInnateArmor)entity).getPierceArmor();
/* 154 */           slashRating += ((IInnateArmor)entity).getSlashArmor();
/* 155 */           crushRating += ((IInnateArmor)entity).getCrushArmor();
/*     */         } 
/*     */         
/* 158 */         float pierceMult = getDamageReduction(pierceRating);
/* 159 */         float slashMult = getDamageReduction(slashRating);
/* 160 */         float crushMult = getDamageReduction(crushRating);
/*     */         
/* 162 */         damage = processDamageSource(source, damage, pierceMult, slashMult, crushMult);
/*     */ 
/*     */ 
/*     */         
/* 166 */         if (location == 3) {
/* 167 */           damage *= 1.75F;
/* 168 */         } else if (location == 0) {
/* 169 */           entity.func_70690_d(new PotionEffect(Potion.field_76421_d.func_76396_c(), 100, 1));
/*     */         } 
/*     */       } 
/* 172 */       EntityArmorCalcEvent eventPost = new EntityArmorCalcEvent(entity, damage, EntityArmorCalcEvent.EventType.POST);
/* 173 */       MinecraftForge.EVENT_BUS.post((Event)eventPost);
/*     */       
/* 175 */       float hasHealth = entity.func_110143_aJ();
/* 176 */       entity.func_70606_j(entity.func_110143_aJ() - eventPost.incomingDamage);
/* 177 */       entity.func_110142_aN().func_94547_a(source, hasHealth, eventPost.incomingDamage);
/*     */     } 
/* 179 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float processDamageSource(DamageSource source, float damage, float pierceMult, float slashMult, float crushMult) {
/* 185 */     EnumDamageType damageType = getDamageType(source);
/*     */     
/* 187 */     if (damageType == EnumDamageType.PIERCING) {
/*     */       
/* 189 */       damage *= pierceMult;
/*     */     }
/* 191 */     else if (damageType == EnumDamageType.SLASHING) {
/*     */       
/* 193 */       damage *= slashMult;
/*     */     }
/* 195 */     else if (damageType == EnumDamageType.CRUSHING) {
/*     */       
/* 197 */       damage *= crushMult;
/*     */     }
/* 199 */     else if (damageType == EnumDamageType.GENERIC) {
/*     */       
/* 201 */       damage = (float)(damage * (((crushMult + slashMult + pierceMult) / 3.0F) - 0.25D));
/*     */     } 
/* 203 */     return Math.max(0.0F, damage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumDamageType getDamageType(DamageSource source) {
/* 209 */     if (source.func_76364_f() instanceof EntityPlayer) {
/*     */       
/* 211 */       EntityPlayer player = (EntityPlayer)source.func_76364_f();
/* 212 */       if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ICausesDamage)
/*     */       {
/* 214 */         return ((ICausesDamage)player.func_71045_bC().func_77973_b()).getDamageType();
/*     */       }
/*     */     } 
/*     */     
/* 218 */     if (source.func_76364_f() instanceof EntityLiving) {
/*     */       
/* 220 */       EntityLiving el = (EntityLiving)source.func_76364_f();
/* 221 */       if (el.func_70694_bm() != null && el.func_70694_bm().func_77973_b() instanceof ICausesDamage)
/*     */       {
/* 223 */         return ((ICausesDamage)el.func_70694_bm().func_77973_b()).getDamageType();
/*     */       }
/*     */     } 
/*     */     
/* 227 */     if (source.func_76364_f() instanceof ICausesDamage)
/*     */     {
/* 229 */       return ((ICausesDamage)source.func_76364_f()).getDamageType();
/*     */     }
/*     */     
/* 232 */     return EnumDamageType.GENERIC;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getRandomSlot(Random rand) {
/* 237 */     int chance = rand.nextInt(100);
/* 238 */     if (chance < 10)
/* 239 */       return 3; 
/* 240 */     if (chance < 20)
/* 241 */       return 0; 
/* 242 */     if (chance < 80) {
/* 243 */       return 2;
/*     */     }
/* 245 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private float processArmorDamage(ItemStack armor, float baseDamage) {
/* 250 */     if (armor.func_77942_o()) {
/*     */       
/* 252 */       NBTTagCompound nbt = armor.func_77978_p();
/* 253 */       if (nbt.func_74764_b("armorReductionBuff")) {
/*     */         
/* 255 */         float reductBuff = nbt.func_74771_c("armorReductionBuff") / 100.0F;
/* 256 */         return baseDamage - baseDamage * reductBuff;
/*     */       } 
/*     */     } 
/* 259 */     return baseDamage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getDamageReduction(int armorRating) {
/* 268 */     if (armorRating == -1000)
/* 269 */       armorRating = -999; 
/* 270 */     return 1000.0F / (1000.0F + armorRating);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onAttackEntity(AttackEntityEvent event) {
/* 276 */     if (event.entityLiving.field_70170_p.field_72995_K) {
/*     */       return;
/*     */     }
/* 279 */     EntityLivingBase attacker = event.entityLiving;
/* 280 */     EntityPlayer player = event.entityPlayer;
/* 281 */     Entity target = event.target;
/* 282 */     ItemStack stack = attacker.func_71124_b(0);
/* 283 */     if (stack != null && stack.func_77973_b().onLeftClickEntity(stack, player, target)) {
/*     */       return;
/*     */     }
/* 286 */     if (target.func_70075_an())
/*     */     {
/* 288 */       if (!target.func_85031_j(target)) {
/*     */         
/* 290 */         float damageAmount = 10.0F;
/* 291 */         if (stack != null) {
/*     */           
/* 293 */           damageAmount = (float)player.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/*     */           
/* 295 */           if (damageAmount == 1.0F)
/*     */           {
/* 297 */             damageAmount = 10.0F;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 302 */         if (player.func_70644_a(Potion.field_76420_g)) {
/* 303 */           damageAmount += (3 << player.func_70660_b(Potion.field_76420_g).func_76458_c());
/*     */         }
/* 305 */         if (player.func_70644_a(Potion.field_76437_t)) {
/* 306 */           damageAmount -= (2 << player.func_70660_b(Potion.field_76437_t).func_76458_c());
/*     */         }
/* 308 */         int knockback = 0;
/* 309 */         float enchantmentDamage = 0.0F;
/*     */         
/* 311 */         if (target instanceof EntityLiving) {
/*     */           
/* 313 */           enchantmentDamage = EnchantmentHelper.func_77512_a((EntityLivingBase)player, (EntityLivingBase)target);
/* 314 */           knockback += EnchantmentHelper.func_77507_b((EntityLivingBase)player, (EntityLivingBase)target);
/*     */         } 
/*     */         
/* 317 */         if (player.func_70051_ag()) {
/* 318 */           knockback++;
/*     */         }
/* 320 */         if (damageAmount > 0.0F || enchantmentDamage > 0.0F) {
/*     */ 
/*     */ 
/*     */           
/* 324 */           boolean criticalHit = (player.field_70143_R > 0.0F && !player.field_70122_E && !player.func_70617_f_() && !player.func_70090_H() && !player.func_70644_a(Potion.field_76440_q) && player.field_70154_o == null && target instanceof EntityLiving);
/*     */ 
/*     */           
/* 327 */           if (criticalHit && damageAmount > 0.0F) {
/* 328 */             damageAmount += event.entity.field_70170_p.field_73012_v.nextInt((int)(damageAmount / 2.0F + 2.0F));
/*     */           }
/* 330 */           damageAmount += enchantmentDamage;
/* 331 */           boolean onFire = false;
/* 332 */           int fireAspect = EnchantmentHelper.func_90036_a((EntityLivingBase)player);
/*     */           
/* 334 */           if (target instanceof EntityLiving && fireAspect > 0 && !target.func_70027_ad()) {
/*     */             
/* 336 */             onFire = true;
/* 337 */             target.func_70015_d(1);
/*     */           } 
/*     */           
/* 340 */           boolean entityAttacked = target.func_70097_a(DamageSource.func_76365_a(player), damageAmount);
/*     */           
/* 342 */           if (entityAttacked) {
/*     */             
/* 344 */             if (knockback > 0) {
/*     */               
/* 346 */               target.func_70024_g((-MathHelper.func_76126_a(player.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F), 0.1D, (
/* 347 */                   MathHelper.func_76134_b(player.field_70177_z * 3.1415927F / 180.0F) * knockback * 0.5F));
/* 348 */               player.field_70159_w *= 0.6D;
/* 349 */               player.field_70179_y *= 0.6D;
/* 350 */               player.func_70031_b(false);
/*     */             } 
/*     */             
/* 353 */             if (criticalHit) {
/* 354 */               player.func_71009_b(target);
/*     */             }
/* 356 */             if (enchantmentDamage > 0.0F) {
/* 357 */               player.func_71047_c(target);
/*     */             }
/* 359 */             if (damageAmount >= 18.0F) {
/* 360 */               player.func_71029_a((StatBase)AchievementList.field_75999_E);
/*     */             }
/* 362 */             player.func_130011_c(target);
/*     */             
/* 364 */             if (target instanceof EntityLiving) {
/* 365 */               target.func_70097_a(DamageSource.func_92087_a((Entity)attacker), damageAmount);
/*     */             }
/*     */           } 
/* 368 */           ItemStack itemstack = player.func_71045_bC();
/* 369 */           Object object = target;
/*     */           
/* 371 */           if (target instanceof EntityDragonPart) {
/*     */             
/* 373 */             IEntityMultiPart ientitymultipart = ((EntityDragonPart)target).field_70259_a;
/* 374 */             if (ientitymultipart instanceof EntityLiving) {
/* 375 */               object = ientitymultipart;
/*     */             }
/*     */           } 
/* 378 */           if (itemstack != null && object instanceof EntityLiving) {
/*     */             
/* 380 */             itemstack.func_77961_a((EntityLivingBase)object, player);
/* 381 */             if (itemstack.field_77994_a <= 0) {
/* 382 */               player.func_71028_bD();
/*     */             }
/*     */           } 
/* 385 */           if (target instanceof EntityLivingBase) {
/*     */             
/* 387 */             player.func_71064_a(StatList.field_75951_w, Math.round(damageAmount * 10.0F));
/* 388 */             if (fireAspect > 0 && entityAttacked) {
/* 389 */               target.func_70015_d(fireAspect * 4);
/* 390 */             } else if (onFire) {
/* 391 */               target.func_70066_B();
/*     */             } 
/*     */           } 
/* 394 */           player.func_71020_j(0.3F);
/*     */         } 
/*     */       } 
/*     */     }
/* 398 */     event.setCanceled(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\EntityDamageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */