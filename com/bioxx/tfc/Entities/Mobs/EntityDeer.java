/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIPanicTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIEatGrass;
/*     */ import net.minecraft.entity.ai.EntityAIFollowParent;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDeer extends EntityAnimal implements IAnimal {
/*     */   private static final float GESTATION_PERIOD = 7.0F;
/*     */   private static final float DIMORPHISM = 0.1728F;
/*     */   private static final int DEGREE_OF_DIVERSION = 1;
/*     */   private static final int FAMILIARITY_CAP = 70;
/*  44 */   protected final EntityAIEatGrass aiEatGrass = new EntityAIEatGrass((EntityLiving)this);
/*     */   
/*     */   private boolean running;
/*     */   private long animalID;
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
/*  59 */   private float aggressionMod = 1.0F;
/*  60 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   
/*     */   private Vec3 attackedVec;
/*     */   
/*     */   private Entity fearSource;
/*     */   private boolean wasRoped;
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityDeer(World par1World) {
/*  73 */     super(par1World);
/*  74 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  75 */     this.hunger = 168000;
/*  76 */     this.pregnant = false;
/*  77 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 7.0F * (float)TFC_Time.ticksInMonth);
/*  78 */     this.timeOfConception = 0L;
/*  79 */     this.mateSizeMod = 0.0F;
/*  80 */     this.sex = this.field_70146_Z.nextInt(2);
/*  81 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.1728F * this.sex)));
/*  82 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  83 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  84 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*  85 */     this.running = false;
/*     */     
/*  87 */     func_70105_a(0.9F, 1.3F);
/*  88 */     func_70661_as().func_75491_a(true);
/*  89 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  90 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanicTFC((EntityCreature)this, 0.6800000071525574D, true));
/*  91 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  92 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityPlayer.class, 12.0F, 0.5D, 0.699999988079071D));
/*  93 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/*  94 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  95 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 0.25D));
/*  96 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)this.aiEatGrass);
/*  97 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.5D));
/*  98 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  99 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityDeer(World par1World, IAnimal mother, List<Float> data) {
/* 110 */     this(par1World);
/* 111 */     float fatherSize = 1.0F;
/* 112 */     float fatherStr = 1.0F;
/* 113 */     float fatherAggro = 1.0F;
/* 114 */     float fatherObed = 1.0F;
/* 115 */     for (int i = 0; i < data.size(); i++) {
/* 116 */       switch (i) { case 0:
/* 117 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 118 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 119 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 120 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 124 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 125 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 126 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 127 */     float invSizeRatio = 0.5472855F;
/* 128 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 129 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 130 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 131 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 133 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 136 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 143 */     super.func_110147_ax();
/* 144 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 150 */     Entity entity = par1DamageSource.func_76346_g();
/* 151 */     if (entity != null) {
/*     */       
/* 153 */       setAttackedVec(Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v));
/* 154 */       setFearSource(entity);
/*     */     } 
/* 156 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 162 */     return (this.field_70173_aa > 10000 && !this.wasRoped);
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
/*     */   public boolean canFamiliarize() {
/* 174 */     return (!isAdult() || (isAdult() && this.familiarity <= 70));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 180 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityDeer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 186 */     boolean flag = false;
/* 187 */     switch (interaction) { case BREED:
/* 188 */         flag = (this.familiarity > 20); break;
/* 189 */       case NAME: flag = (this.familiarity > 60); break;
/* 190 */       case TOLERATEPLAYER: flag = (this.familiarity > 40);
/*     */         break; }
/*     */     
/* 193 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 194 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 196 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable func_90011_a(EntityAgeable entityageable) {
/* 202 */     return createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 208 */     ArrayList<Float> data = new ArrayList<Float>();
/* 209 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 210 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 211 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 212 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 213 */     return (EntityAgeable)new EntityDeer(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 222 */     float ageMod = TFC_Core.getPercentGrown(this);
/* 223 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)((ageMod * this.sizeMod) * 1.84D)))), 0.0F);
/* 224 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(4) + 2) * ageMod));
/* 225 */     float foodWeight = ageMod * this.sizeMod * 2400.0F;
/*     */     
/* 227 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.venisonRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 233 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 239 */     super.func_70088_a();
/* 240 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 241 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 243 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 244 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 245 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 250 */     ItemStack stack = ep.func_70694_bm();
/* 251 */     if (stack != null && stack.func_77973_b() != null && stack.func_77973_b().equals(TFCItems.powder) && stack.func_77960_j() == 9 && !this.familiarizedToday && 
/* 252 */       canFamiliarize()) {
/*     */       
/* 254 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 256 */         stack.field_77994_a--;
/* 257 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, stack);
/*     */       } 
/* 259 */       this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 260 */       this.hunger += 24000;
/* 261 */       this.familiarizedToday = true;
/* 262 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 263 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 270 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 276 */     return Helper.stringToInt("deer");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 282 */     return this.attackedVec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 288 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 297 */     return "terrafirmacraft:mob.deer.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 306 */     return Items.field_151116_aA;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 312 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 317 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 322 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 328 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 334 */     return this.fearSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 340 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 346 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 355 */     return "terrafirmacraft:mob.deer.hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 361 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 366 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 375 */     if (getGender() == IAnimal.GenderEnum.MALE && isAdult() && this.field_70170_p.field_73012_v.nextInt(100) < 5)
/* 376 */       return "terrafirmacraft:mob.deer.cry"; 
/* 377 */     return "terrafirmacraft:mob.deer.say";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 383 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 24.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 389 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 394 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getRunning() {
/* 399 */     return this.running;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 404 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 410 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 416 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 421 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 426 */     int totalDays = TFC_Time.getTotalDays();
/* 427 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 428 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 429 */         this.lastFamiliarityUpdate = totalDays;
/* 430 */         this.familiarizedToday = false;
/* 431 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 432 */         if (isAdult() && this.familiarity <= 70) {
/*     */           
/* 434 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 436 */         else if (!isAdult()) {
/* 437 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 438 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 439 */           if (this.familiarity > 70) {
/* 440 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 444 */       } else if (this.familiarity < 30) {
/* 445 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 446 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 449 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 450 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */   
/*     */   public boolean hasBeenRoped() {
/* 455 */     return this.wasRoped;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 464 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 466 */       if (player.func_70093_af() && canFamiliarize()) {
/*     */         
/* 468 */         familiarize(player);
/* 469 */         return true;
/*     */       } 
/* 471 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 473 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 476 */     ItemStack itemstack = player.func_70694_bm();
/* 477 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 478 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 479 */         itemstack.field_77994_a--;
/*     */       }
/* 481 */       return true;
/*     */     } 
/* 483 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 489 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/* 498 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 504 */     return !isAdult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 510 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 516 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 522 */     if (this.sex == 0) {
/*     */       
/* 524 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 527 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 528 */     this.pregnant = true;
/* 529 */     func_70875_t();
/* 530 */     otherAnimal.setInLove(false);
/* 531 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 532 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 533 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 534 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 544 */     if (func_70880_s()) {
/*     */       
/* 546 */       func_70875_t();
/* 547 */       setInLove(true);
/*     */     } 
/*     */     
/* 550 */     if (func_110167_bD() && !this.wasRoped) this.wasRoped = true;
/*     */     
/* 552 */     syncData();
/* 553 */     if (isAdult()) {
/*     */       
/* 555 */       func_70873_a(0);
/*     */     }
/*     */     else {
/*     */       
/* 559 */       func_70873_a(-1);
/*     */     } 
/*     */     
/* 562 */     handleFamiliarityUpdate();
/*     */     
/* 564 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*     */     {
/* 566 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */         
/* 568 */         EntityDeer baby = (EntityDeer)createChildTFC((EntityAgeable)this);
/* 569 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 570 */         baby.field_70759_as = baby.field_70177_z;
/* 571 */         baby.field_70761_aq = baby.field_70177_z;
/* 572 */         this.field_70170_p.func_72838_d((Entity)baby);
/* 573 */         baby.setAge(TFC_Time.getTotalDays());
/* 574 */         this.pregnant = false;
/*     */       } 
/*     */     }
/*     */     
/* 578 */     if (this.attackedVec != null) {
/*     */ 
/*     */       
/* 581 */       Vec3 positionVec = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 582 */       if (getFearSource() != null && func_70068_e(getFearSource()) > 144.0D) {
/*     */         
/* 584 */         setFearSource((Entity)null);
/*     */       }
/* 586 */       else if (positionVec.func_72438_d(getAttackedVec()) > 16.0D) {
/*     */         
/* 588 */         setAttackedVec((Vec3)null);
/*     */       } 
/*     */     } 
/*     */     
/* 592 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 594 */       func_70691_i(1.0F);
/*     */     }
/* 596 */     else if (this.hunger < 144000 && func_70880_s()) {
/* 597 */       setInLove(false);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 603 */     TFC_Core.preventEntityDataUpdate = true;
/* 604 */     super.func_70636_d();
/* 605 */     TFC_Core.preventEntityDataUpdate = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 614 */     super.func_70037_a(nbt);
/* 615 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 616 */     this.sex = nbt.func_74762_e("Sex");
/* 617 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 619 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 620 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 621 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 623 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 624 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 625 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 627 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */     
/* 629 */     this.hunger = nbt.func_74762_e("Hunger");
/* 630 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 631 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 632 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 633 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 634 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 635 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 636 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 642 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 648 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttackedVec(Vec3 attackedVec) {
/* 654 */     this.attackedVec = attackedVec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBirthDay(int day) {
/* 660 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 666 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 671 */     this.familiarizedToday = familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFearSource(Entity fearSource) {
/* 677 */     this.fearSource = fearSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70873_a(int par1) {
/* 683 */     if (!TFC_Core.preventEntityDataUpdate)
/*     */     {
/* 685 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 692 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 698 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 703 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 709 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 714 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 719 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRunning(boolean r) {
/* 724 */     this.running = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 729 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 735 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 741 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 746 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWasRoped(boolean wasRoped) {
/* 751 */     this.wasRoped = wasRoped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 756 */     if (this.field_70180_af != null)
/*     */     {
/* 758 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 760 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 766 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 772 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 773 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 774 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 775 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 779 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 781 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 782 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 783 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 784 */         byte[] values = buf.array();
/*     */         
/* 786 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 787 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 788 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 789 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 791 */         this.familiarity = values[4];
/* 792 */         this.familiarizedToday = (values[5] == 1);
/* 793 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 797 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 798 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 805 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 807 */       func_94058_c(name);
/* 808 */       return true;
/*     */     } 
/* 810 */     func_85030_a("terrafirmacraft:mob.deer.cry", 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 811 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 820 */     super.func_70014_b(nbt);
/* 821 */     nbt.func_74768_a("Sex", this.sex);
/* 822 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 823 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 825 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 826 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 827 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 829 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 830 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 831 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 833 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */     
/* 835 */     nbt.func_74768_a("Hunger", this.hunger);
/* 836 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 837 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 838 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 839 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 840 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 841 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 842 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityDeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */