/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAITargetNonTamedTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIMate;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityBear extends EntityTameable implements ICausesDamage, IAnimal, IInnateArmor {
/*     */   private static final float GESTATION_PERIOD = 7.0F;
/*     */   private static final float DIMORPHISM = 0.2182F;
/*  49 */   private final Random rand = new Random();
/*     */   private static final int DEGREE_OF_DIVERSION = 4;
/*     */   private static final int FAMILIARITY_CAP = 80;
/*     */   private float moveSpeed;
/*     */   private boolean isWet;
/*     */   private int sex;
/*     */   private int hunger;
/*     */   private boolean pregnant;
/*     */   private int pregnancyRequiredTime;
/*     */   private long timeOfConception;
/*     */   private float mateSizeMod;
/*     */   private float mateStrengthMod;
/*     */   private float mateAggroMod;
/*     */   private float mateObedMod;
/*     */   private float sizeMod;
/*     */   private float strengthMod;
/*  65 */   private float aggressionMod = 1.0F;
/*  66 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   
/*     */   protected EntityAIAttackOnCollide attackAI;
/*     */   
/*     */   protected EntityAILeapAtTarget leapAI;
/*     */   
/*     */   protected EntityAITargetNonTamedTFC targetSheep;
/*     */   protected EntityAITargetNonTamedTFC targetDeer;
/*     */   protected EntityAITargetNonTamedTFC targetPig;
/*     */   protected EntityAITargetNonTamedTFC targetHorse;
/*     */   protected EntityAITargetNonTamedTFC targetPlayer;
/*     */   protected EntityAIHurtByTarget hurtAI;
/*     */   protected boolean isPeacefulAI;
/*     */   private boolean wasRoped;
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityBear(World par1World) {
/*  87 */     super(par1World);
/*  88 */     func_70105_a(1.2F, 1.2F);
/*  89 */     this.moveSpeed = 0.4F;
/*  90 */     func_70661_as().func_75491_a(true);
/*  91 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  92 */     this.sizeMod = (float)Math.sqrt((((this.rand.nextInt(this.rand.nextInt(50) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.2182F * this.sex)));
/*     */     
/*  94 */     this.strengthMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  95 */     this.aggressionMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  96 */     this.obedienceMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */     
/*  98 */     this.sex = this.rand.nextInt(2);
/*  99 */     if (getGender() == IAnimal.GenderEnum.MALE)
/* 100 */       this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, this.moveSpeed)); 
/* 101 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.moveSpeed));
/* 102 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/* 103 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/* 104 */     this.attackAI = new EntityAIAttackOnCollide((EntityCreature)this, (this.moveSpeed * 1.5F), true);
/* 105 */     this.leapAI = new EntityAILeapAtTarget((EntityLiving)this, 0.4F);
/*     */ 
/*     */     
/* 108 */     this.targetSheep = new EntityAITargetNonTamedTFC(this, EntitySheepTFC.class, 200, false);
/* 109 */     this.targetDeer = new EntityAITargetNonTamedTFC(this, EntityDeer.class, 200, false);
/* 110 */     this.targetPig = new EntityAITargetNonTamedTFC(this, EntityPigTFC.class, 200, false);
/* 111 */     this.targetHorse = new EntityAITargetNonTamedTFC(this, EntityHorseTFC.class, 200, false);
/* 112 */     this.targetPlayer = new EntityAITargetNonTamedTFC(this, EntityPlayer.class, 20, false);
/* 113 */     this.hurtAI = new EntityAIHurtByTarget((EntityCreature)this, true);
/*     */     
/* 115 */     if (par1World.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */       
/* 117 */       this.isPeacefulAI = false;
/* 118 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 119 */       this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 120 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 121 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 122 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 123 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 124 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 125 */       this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
/*     */     } else {
/*     */       
/* 128 */       this.isPeacefulAI = true;
/*     */     } 
/*     */     
/* 131 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 7.0F * (float)TFC_Time.ticksInMonth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBear(World par1World, IAnimal mother, List<Float> data) {
/* 143 */     this(par1World);
/* 144 */     float fatherSize = 1.0F;
/* 145 */     float fatherStr = 1.0F;
/* 146 */     float fatherAggro = 1.0F;
/* 147 */     float fatherObed = 1.0F;
/* 148 */     for (int i = 0; i < data.size(); i++) {
/* 149 */       switch (i) { case 0:
/* 150 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 151 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 152 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 153 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 157 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 158 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 159 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 160 */     float invSizeRatio = 0.5612302F;
/* 161 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 162 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 163 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 164 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 166 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 169 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 176 */     super.func_110147_ax();
/* 177 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 183 */     int dam = (int)(175.0F * getStrengthMod() * getAggressionMod() * (getSizeMod() / 2.0F + 0.5F));
/* 184 */     return par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), dam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 193 */     return (!this.wasRoped && this.field_70173_aa > 30000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 200 */     return (!isAdult() || (isAdult() && this.familiarity <= 80));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal par1EntityAnimal) {
/* 206 */     if (par1EntityAnimal == this)
/* 207 */       return false; 
/* 208 */     if (!(par1EntityAnimal instanceof EntityBear))
/* 209 */       return false; 
/* 210 */     EntityBear entitybear = (EntityBear)par1EntityAnimal;
/* 211 */     return (getInLove() && entitybear.getInLove());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 217 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityBear);
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
/*     */   protected boolean func_70041_e_() {
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 235 */     boolean flag = false;
/* 236 */     switch (interaction) { case MOUNT:
/* 237 */         flag = (this.familiarity > 15); break;
/* 238 */       case BREED: flag = (this.familiarity > 20); break;
/* 239 */       case NAME: flag = (this.familiarity > 70); break;
/* 240 */       case TOLERATEPLAYER: flag = (this.familiarity > 75);
/*     */         break; }
/*     */     
/* 243 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 244 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 246 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable func_90011_a(EntityAgeable entityageable) {
/* 252 */     return createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 258 */     ArrayList<Float> data = new ArrayList<Float>();
/* 259 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 260 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 261 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 262 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 263 */     return (EntityAgeable)new EntityBear(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 269 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 271 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/* 272 */     func_145779_a(Items.field_151103_aS, (int)((this.rand.nextInt(6) + 2) * ageMod));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 278 */     super.func_70088_a();
/* 279 */     this.field_70180_af.func_75682_a(18, Float.valueOf(func_110143_aJ()));
/* 280 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 281 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/* 282 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 283 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 284 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 289 */     ItemStack stack = ep.func_70694_bm();
/* 290 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 292 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 294 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 298 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 300 */       this.hunger += 24000;
/* 301 */       this.familiarizedToday = true;
/* 302 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 303 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 310 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 317 */     return Helper.stringToInt("bear");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 323 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 329 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/* 335 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 341 */     return EnumDamageType.SLASHING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 350 */     if (!func_70631_g_()) {
/* 351 */       return "terrafirmacraft:mob.bear.death";
/*     */     }
/* 353 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 363 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 369 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 375 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 381 */     return this.field_70131_O * 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 386 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 392 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 398 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 404 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 410 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 419 */     if (!func_70631_g_()) {
/* 420 */       return "terrafirmacraft:mob.bear.hurt";
/*     */     }
/* 422 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 428 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 433 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 442 */     if (isAdult() && this.field_70170_p.field_73012_v.nextInt(100) < 5)
/* 443 */       return "terrafirmacraft:mob.bear.cry"; 
/* 444 */     if (func_70631_g_() && this.field_70170_p.field_73012_v.nextInt(100) < 5) {
/* 445 */       return "terrafirmacraft:mob.bear.cub.cry";
/*     */     }
/* 447 */     return func_70631_g_() ? null : "terrafirmacraft:mob.bear.say";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 456 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMoveSpeed() {
/* 461 */     return this.moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 467 */     return TFC_Time.daysInMonth * 60;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 473 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPierceArmor() {
/* 479 */     return -335;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 484 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 489 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 495 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlashArmor() {
/* 501 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 510 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 516 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 521 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 526 */     int totalDays = TFC_Time.getTotalDays();
/* 527 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 528 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 529 */         this.lastFamiliarityUpdate = totalDays;
/* 530 */         this.familiarizedToday = false;
/* 531 */         float familiarityChange = 3.0F * this.obedienceMod / this.aggressionMod;
/* 532 */         if (isAdult() && this.familiarity <= 80) {
/*     */           
/* 534 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 536 */         else if (!isAdult()) {
/* 537 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 538 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 539 */           if (this.familiarity > 70) {
/* 540 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 544 */       } else if (this.familiarity < 30) {
/* 545 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 546 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 549 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 550 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70103_a(byte par1) {
/* 556 */     if (par1 == 8) {
/*     */       
/* 558 */       this.isWet = true;
/*     */     }
/*     */     else {
/*     */       
/* 562 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 569 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 571 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 573 */         familiarize(player);
/* 574 */         return true;
/*     */       } 
/* 576 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/* 577 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 579 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 582 */     ItemStack itemstack = player.func_70694_bm();
/* 583 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*     */       
/* 585 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player))
/*     */       {
/* 587 */         itemstack.field_77994_a--;
/*     */       }
/* 589 */       return true;
/*     */     } 
/* 591 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 597 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 606 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 612 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 617 */     return (item != null && item.func_77973_b().equals(TFCItems.fishRaw));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 623 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWasRoped() {
/* 628 */     return this.wasRoped;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 634 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 636 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 639 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 640 */     this.pregnant = true;
/* 641 */     func_70875_t();
/* 642 */     otherAnimal.setInLove(false);
/* 643 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 644 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/* 645 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 646 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 656 */     TFC_Core.preventEntityDataUpdate = true;
/* 657 */     super.func_70636_d();
/* 658 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 660 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 662 */       if (!this.isWet && !func_70781_l() && this.field_70122_E) {
/*     */         
/* 664 */         this.isWet = true;
/* 665 */         this.field_70170_p.func_72960_a((Entity)this, (byte)8);
/*     */       } 
/*     */       
/* 668 */       if (isPregnant())
/*     */       {
/* 670 */         if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */           
/* 672 */           int i = this.rand.nextInt(3) + 1;
/* 673 */           for (int x = 0; x < i; x++) {
/*     */             
/* 675 */             EntityBear baby = (EntityBear)createChildTFC((EntityAgeable)this);
/* 676 */             this.field_70170_p.func_72838_d((Entity)baby);
/*     */           } 
/* 678 */           this.pregnant = false;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 683 */     if (func_110167_bD() && !this.wasRoped) {
/* 684 */       this.wasRoped = true;
/*     */     }
/* 686 */     handleFamiliarityUpdate();
/* 687 */     syncData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 696 */     super.func_70071_h_();
/* 697 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 699 */       if (!this.isPeacefulAI && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
/*     */         
/* 701 */         this.isPeacefulAI = true;
/* 702 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.attackAI);
/* 703 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.leapAI);
/* 704 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetSheep);
/* 705 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetDeer);
/* 706 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPig);
/* 707 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetHorse);
/* 708 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPlayer);
/* 709 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.hurtAI);
/*     */       }
/* 711 */       else if (this.isPeacefulAI && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */         
/* 713 */         this.isPeacefulAI = false;
/* 714 */         this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 715 */         this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 716 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 717 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 718 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 719 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 720 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 721 */         this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 732 */     super.func_70037_a(nbt);
/* 733 */     this.sex = nbt.func_74762_e("Sex");
/* 734 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 736 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 737 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 738 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 740 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 741 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 742 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 744 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */     
/* 746 */     this.hunger = nbt.func_74762_e("Hunger");
/* 747 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 748 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 749 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 750 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 751 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 752 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 753 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 760 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggression) {
/* 766 */     this.aggressionMod = aggression;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttackedVec(Vec3 attackedVec) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBirthDay(int day) {
/* 777 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int f) {
/* 783 */     this.familiarity = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 788 */     this.familiarizedToday = familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFearSource(Entity fearSource) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70873_a(int par1) {
/* 799 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 800 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 806 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 812 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 817 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMoveSpeed(float moveSpeed) {
/* 822 */     this.moveSpeed = moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedience) {
/* 828 */     this.obedienceMod = obedience;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 833 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 838 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 843 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float size) {
/* 849 */     this.sizeMod = size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strength) {
/* 855 */     this.strengthMod = strength;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 860 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWasRoped(boolean wasRoped) {
/* 865 */     this.wasRoped = wasRoped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 870 */     if (this.field_70180_af != null)
/*     */     {
/* 872 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 874 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 880 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 886 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 887 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 888 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 889 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 893 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 895 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 896 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 897 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 898 */         byte[] values = buf.array();
/*     */         
/* 900 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 901 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 902 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 903 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 905 */         this.familiarity = values[4];
/* 906 */         this.familiarizedToday = (values[5] == 1);
/* 907 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 911 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 912 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 919 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 921 */       func_94058_c(name);
/* 922 */       return true;
/*     */     } 
/* 924 */     func_85030_a(func_70631_g_() ? "terrafirmacraft:mob.bear.cub.cry" : "terrafirmacraft:mob.bear.cry", 6.0F, this.rand.nextFloat() / 2.0F + 0.75F);
/* 925 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/* 934 */     this.field_70180_af.func_75692_b(18, Float.valueOf(func_110143_aJ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 943 */     super.func_70014_b(nbt);
/* 944 */     nbt.func_74768_a("Sex", this.sex);
/* 945 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 947 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 948 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 949 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 951 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 952 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 953 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 955 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */     
/* 957 */     nbt.func_74768_a("Hunger", this.hunger);
/* 958 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 959 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 960 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 961 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 962 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 963 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 964 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityBear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */