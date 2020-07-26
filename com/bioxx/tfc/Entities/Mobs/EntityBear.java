/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
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
/*  50 */   private final Random rand = new Random();
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
/*  66 */   private float aggressionMod = 1.0F;
/*  67 */   private float obedienceMod = 1.0F;
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
/*  88 */     super(par1World);
/*  89 */     func_70105_a(1.2F, 1.2F);
/*  90 */     this.moveSpeed = 0.4F;
/*  91 */     func_70661_as().func_75491_a(true);
/*  92 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  93 */     this.sizeMod = (float)Math.sqrt((((this.rand.nextInt(this.rand.nextInt(50) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.2182F * this.sex)));
/*     */     
/*  95 */     this.strengthMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  96 */     this.aggressionMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  97 */     this.obedienceMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */     
/*  99 */     this.sex = this.rand.nextInt(2);
/* 100 */     if (getGender() == IAnimal.GenderEnum.MALE)
/* 101 */       this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, this.moveSpeed)); 
/* 102 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityOcelotTFC.class, 32.0F, 1.2D, 1.6D));
/* 103 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.moveSpeed));
/* 104 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/* 105 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/* 106 */     this.attackAI = new EntityAIAttackOnCollide((EntityCreature)this, (this.moveSpeed * 1.5F), true);
/* 107 */     this.leapAI = new EntityAILeapAtTarget((EntityLiving)this, 0.4F);
/*     */ 
/*     */     
/* 110 */     this.targetSheep = new EntityAITargetNonTamedTFC(this, EntitySheepTFC.class, 200, false);
/* 111 */     this.targetDeer = new EntityAITargetNonTamedTFC(this, EntityDeer.class, 200, false);
/* 112 */     this.targetPig = new EntityAITargetNonTamedTFC(this, EntityPigTFC.class, 200, false);
/* 113 */     this.targetHorse = new EntityAITargetNonTamedTFC(this, EntityHorseTFC.class, 200, false);
/* 114 */     this.targetPlayer = new EntityAITargetNonTamedTFC(this, EntityPlayer.class, 20, false);
/* 115 */     this.hurtAI = new EntityAIHurtByTarget((EntityCreature)this, true);
/*     */     
/* 117 */     if (par1World.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */       
/* 119 */       this.isPeacefulAI = false;
/* 120 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 121 */       this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 122 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 123 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 124 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 125 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 126 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 127 */       this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
/*     */     } else {
/*     */       
/* 130 */       this.isPeacefulAI = true;
/*     */     } 
/*     */     
/* 133 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 7.0F * (float)TFC_Time.ticksInMonth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityBear(World par1World, IAnimal mother, List<Float> data) {
/* 145 */     this(par1World);
/* 146 */     float fatherSize = 1.0F;
/* 147 */     float fatherStr = 1.0F;
/* 148 */     float fatherAggro = 1.0F;
/* 149 */     float fatherObed = 1.0F;
/* 150 */     for (int i = 0; i < data.size(); i++) {
/* 151 */       switch (i) { case 0:
/* 152 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 153 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 154 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 155 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 159 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 160 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 161 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 162 */     float invSizeRatio = 0.5612302F;
/* 163 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 164 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 165 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 166 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 168 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 171 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 178 */     super.func_110147_ax();
/* 179 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 185 */     int dam = (int)(175.0F * getStrengthMod() * getAggressionMod() * (getSizeMod() / 2.0F + 0.5F));
/* 186 */     return par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), dam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 195 */     return (!this.wasRoped && this.field_70173_aa > 30000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 202 */     return (!isAdult() || (isAdult() && this.familiarity <= 80));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal par1EntityAnimal) {
/* 208 */     if (par1EntityAnimal == this)
/* 209 */       return false; 
/* 210 */     if (!(par1EntityAnimal instanceof EntityBear))
/* 211 */       return false; 
/* 212 */     EntityBear entitybear = (EntityBear)par1EntityAnimal;
/* 213 */     return (getInLove() && entitybear.getInLove());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 219 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityBear);
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
/* 231 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 237 */     boolean flag = false;
/* 238 */     switch (interaction) { case MOUNT:
/* 239 */         flag = (this.familiarity > 15); break;
/* 240 */       case BREED: flag = (this.familiarity > 20); break;
/* 241 */       case NAME: flag = (this.familiarity > 70); break;
/* 242 */       case TOLERATEPLAYER: flag = (this.familiarity > 75);
/*     */         break; }
/*     */     
/* 245 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 246 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 248 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable func_90011_a(EntityAgeable entityageable) {
/* 254 */     return createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 260 */     ArrayList<Float> data = new ArrayList<Float>();
/* 261 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 262 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 263 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 264 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 265 */     return (EntityAgeable)new EntityBear(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 271 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 273 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/* 274 */     func_145779_a(Items.field_151103_aS, (int)((this.rand.nextInt(6) + 2) * ageMod));
/* 275 */     float foodWeight = ageMod * this.sizeMod * 1000.0F;
/* 276 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.bearRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 282 */     super.func_70088_a();
/* 283 */     this.field_70180_af.func_75682_a(18, Float.valueOf(func_110143_aJ()));
/* 284 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 285 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/* 286 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 287 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 288 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 293 */     ItemStack stack = ep.func_70694_bm();
/* 294 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 296 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 298 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 302 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 304 */       this.hunger += 24000;
/* 305 */       this.familiarizedToday = true;
/* 306 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 307 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 314 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 321 */     return Helper.stringToInt("bear");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 327 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 333 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/* 339 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 345 */     return EnumDamageType.SLASHING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 354 */     if (!func_70631_g_()) {
/* 355 */       return "terrafirmacraft:mob.bear.death";
/*     */     }
/* 357 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 367 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 373 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 379 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 385 */     return this.field_70131_O * 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 390 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 396 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 402 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 408 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 414 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 423 */     if (!func_70631_g_()) {
/* 424 */       return "terrafirmacraft:mob.bear.hurt";
/*     */     }
/* 426 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 432 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 437 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 446 */     if (isAdult() && this.field_70170_p.field_73012_v.nextInt(100) < 5)
/* 447 */       return "terrafirmacraft:mob.bear.cry"; 
/* 448 */     if (func_70631_g_() && this.field_70170_p.field_73012_v.nextInt(100) < 5) {
/* 449 */       return "terrafirmacraft:mob.bear.cub.cry";
/*     */     }
/* 451 */     return func_70631_g_() ? null : "terrafirmacraft:mob.bear.say";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 460 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMoveSpeed() {
/* 465 */     return this.moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 471 */     return TFC_Time.daysInMonth * 60;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 477 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPierceArmor() {
/* 483 */     return -335;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 488 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 493 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 499 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlashArmor() {
/* 505 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 514 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 520 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 525 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 530 */     int totalDays = TFC_Time.getTotalDays();
/* 531 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 532 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 533 */         this.lastFamiliarityUpdate = totalDays;
/* 534 */         this.familiarizedToday = false;
/* 535 */         float familiarityChange = 3.0F * this.obedienceMod / this.aggressionMod;
/* 536 */         if (isAdult() && this.familiarity <= 80) {
/*     */           
/* 538 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 540 */         else if (!isAdult()) {
/* 541 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 542 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 543 */           if (this.familiarity > 70) {
/* 544 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 548 */       } else if (this.familiarity < 30) {
/* 549 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 550 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 553 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 554 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70103_a(byte par1) {
/* 560 */     if (par1 == 8) {
/*     */       
/* 562 */       this.isWet = true;
/*     */     }
/*     */     else {
/*     */       
/* 566 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 573 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 575 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 577 */         familiarize(player);
/* 578 */         return true;
/*     */       } 
/* 580 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/* 581 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 583 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 586 */     ItemStack itemstack = player.func_70694_bm();
/* 587 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*     */       
/* 589 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player))
/*     */       {
/* 591 */         itemstack.field_77994_a--;
/*     */       }
/* 593 */       return true;
/*     */     } 
/* 595 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 601 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 610 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 616 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 621 */     return (item != null && item.func_77973_b().equals(TFCItems.fishRaw));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 627 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWasRoped() {
/* 632 */     return this.wasRoped;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 638 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 640 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 643 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 644 */     this.pregnant = true;
/* 645 */     func_70875_t();
/* 646 */     otherAnimal.setInLove(false);
/* 647 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 648 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/* 649 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 650 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 660 */     TFC_Core.preventEntityDataUpdate = true;
/* 661 */     super.func_70636_d();
/* 662 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 664 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 666 */       if (!this.isWet && !func_70781_l() && this.field_70122_E) {
/*     */         
/* 668 */         this.isWet = true;
/* 669 */         this.field_70170_p.func_72960_a((Entity)this, (byte)8);
/*     */       } 
/*     */       
/* 672 */       if (isPregnant())
/*     */       {
/* 674 */         if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */           
/* 676 */           int i = this.rand.nextInt(3) + 1;
/* 677 */           for (int x = 0; x < i; x++) {
/*     */             
/* 679 */             EntityBear baby = (EntityBear)createChildTFC((EntityAgeable)this);
/* 680 */             this.field_70170_p.func_72838_d((Entity)baby);
/*     */           } 
/* 682 */           this.pregnant = false;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 687 */     if (func_110167_bD() && !this.wasRoped) {
/* 688 */       this.wasRoped = true;
/*     */     }
/* 690 */     handleFamiliarityUpdate();
/* 691 */     syncData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 700 */     super.func_70071_h_();
/* 701 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 703 */       if (!this.isPeacefulAI && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
/*     */         
/* 705 */         this.isPeacefulAI = true;
/* 706 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.attackAI);
/* 707 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.leapAI);
/* 708 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetSheep);
/* 709 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetDeer);
/* 710 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPig);
/* 711 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetHorse);
/* 712 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPlayer);
/* 713 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.hurtAI);
/*     */       }
/* 715 */       else if (this.isPeacefulAI && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */         
/* 717 */         this.isPeacefulAI = false;
/* 718 */         this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 719 */         this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 720 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 721 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 722 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 723 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 724 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 725 */         this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
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
/* 736 */     super.func_70037_a(nbt);
/* 737 */     this.sex = nbt.func_74762_e("Sex");
/* 738 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 740 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 741 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 742 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 744 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 745 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 746 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 748 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */     
/* 750 */     this.hunger = nbt.func_74762_e("Hunger");
/* 751 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 752 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 753 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 754 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 755 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 756 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 757 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 764 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggression) {
/* 770 */     this.aggressionMod = aggression;
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
/* 781 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int f) {
/* 787 */     this.familiarity = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 792 */     this.familiarizedToday = familiarizedToday;
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
/* 803 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 804 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 810 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 816 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 821 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMoveSpeed(float moveSpeed) {
/* 826 */     this.moveSpeed = moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedience) {
/* 832 */     this.obedienceMod = obedience;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 837 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 842 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 847 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float size) {
/* 853 */     this.sizeMod = size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strength) {
/* 859 */     this.strengthMod = strength;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 864 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWasRoped(boolean wasRoped) {
/* 869 */     this.wasRoped = wasRoped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 874 */     if (this.field_70180_af != null)
/*     */     {
/* 876 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 878 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 884 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 890 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 891 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 892 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 893 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 897 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 899 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 900 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 901 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 902 */         byte[] values = buf.array();
/*     */         
/* 904 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 905 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 906 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 907 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 909 */         this.familiarity = values[4];
/* 910 */         this.familiarizedToday = (values[5] == 1);
/* 911 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 915 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 916 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 923 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 925 */       func_94058_c(name);
/* 926 */       return true;
/*     */     } 
/* 928 */     func_85030_a(func_70631_g_() ? "terrafirmacraft:mob.bear.cub.cry" : "terrafirmacraft:mob.bear.cry", 6.0F, this.rand.nextFloat() / 2.0F + 0.75F);
/* 929 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/* 938 */     this.field_70180_af.func_75692_b(18, Float.valueOf(func_110143_aJ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 947 */     super.func_70014_b(nbt);
/* 948 */     nbt.func_74768_a("Sex", this.sex);
/* 949 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 951 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 952 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 953 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 955 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 956 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 957 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 959 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */     
/* 961 */     nbt.func_74768_a("Hunger", this.hunger);
/* 962 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 963 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 964 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 965 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 966 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 967 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 968 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityBear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */