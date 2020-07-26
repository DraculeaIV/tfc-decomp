/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
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
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIEatGrass;
/*     */ import net.minecraft.entity.ai.EntityAIFollowParent;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPigTFC extends EntityPig implements IAnimal {
/*     */   private static final float GESTATION_PERIOD = 3.7F;
/*  42 */   protected final EntityAIEatGrass aiEatGrass = new EntityAIEatGrass((EntityLiving)this); private static final float DIMORPHISM = 0.271F; private static final int DEGREE_OF_DIVERSION = 2;
/*     */   private static final int FAMILIARITY_CAP = 35;
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
/*  56 */   private float aggressionMod = 1.0F;
/*  57 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityPigTFC(World par1World) {
/*  65 */     super(par1World);
/*  66 */     func_70105_a(0.9F, 0.9F);
/*  67 */     func_70661_as().func_75491_a(true);
/*  68 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  69 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 0.3799999952316284D));
/*  70 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  71 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/*  72 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/*  73 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/*  74 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/*  75 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/*  76 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/*  77 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 0.2800000011920929D));
/*  78 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.75D));
/*  79 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*  80 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPigTFC.class, 6.0F));
/*  81 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/*  82 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  83 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityPolarBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  84 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  86 */     this.hunger = 168000;
/*  87 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  88 */     this.pregnant = false;
/*  89 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 3.7F * (float)TFC_Time.ticksInMonth);
/*  90 */     this.timeOfConception = 0L;
/*  91 */     this.mateSizeMod = 0.0F;
/*  92 */     this.sex = this.field_70146_Z.nextInt(2);
/*  93 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.271F * this.sex)));
/*  94 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  95 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  96 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPigTFC(World par1World, IAnimal mother, List<Float> data) {
/* 108 */     this(par1World);
/* 109 */     float fatherSize = 1.0F;
/* 110 */     float fatherStr = 1.0F;
/* 111 */     float fatherAggro = 1.0F;
/* 112 */     float fatherObed = 1.0F;
/* 113 */     for (int i = 0; i < data.size(); i++) {
/* 114 */       switch (i) { case 0:
/* 115 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 116 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 117 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 118 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 122 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 123 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 124 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 125 */     float invSizeRatio = 0.578369F;
/* 126 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 127 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 128 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 129 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 131 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 134 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 140 */     super.func_110147_ax();
/* 141 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 147 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 153 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityPigTFC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 159 */     boolean flag = false;
/* 160 */     switch (interaction) { case MOUNT:
/* 161 */         flag = (this.familiarity > 15); break;
/* 162 */       case BREED: flag = (this.familiarity > 10); break;
/* 163 */       case NAME: flag = (this.familiarity > 40);
/*     */         break; }
/*     */     
/* 166 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 167 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 169 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPig func_90011_a(EntityAgeable entityageable) {
/* 175 */     return (EntityPig)createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 181 */     ArrayList<Float> data = new ArrayList<Float>();
/* 182 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 183 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 184 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 185 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 186 */     return (EntityAgeable)new EntityPigTFC(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 192 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 194 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/* 195 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(4) + 2) * ageMod));
/*     */     
/* 197 */     float foodWeight = ageMod * this.sizeMod * 2400.0F;
/* 198 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.porkchopRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 204 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 210 */     super.func_70088_a();
/* 211 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 212 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/* 213 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 214 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 215 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float par1) {
/* 224 */     super.func_70069_a(par1);
/*     */     
/* 226 */     if (par1 > 5.0F && this.field_70153_n instanceof EntityPlayer) {
/* 227 */       ((EntityPlayer)this.field_70153_n).func_71029_a((StatBase)AchievementList.field_76021_u);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 233 */     ItemStack stack = ep.func_70694_bm();
/* 234 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 236 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 238 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 242 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 244 */       this.hunger += 24000;
/* 245 */       this.familiarizedToday = true;
/* 246 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 247 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 254 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAnimalID() {
/* 259 */     return this.animalID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 265 */     return Helper.stringToInt("pig");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 271 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 277 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 286 */     return func_70027_ad() ? Items.field_151157_am : Items.field_151147_al;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 292 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 298 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 303 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 309 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 315 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 321 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 327 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 333 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 338 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 344 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 15.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 350 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 355 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70901_n() {
/* 364 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 369 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 375 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 381 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 386 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 391 */     int totalDays = TFC_Time.getTotalDays();
/* 392 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 393 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 394 */         this.lastFamiliarityUpdate = totalDays;
/* 395 */         this.familiarizedToday = false;
/* 396 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 397 */         if (isAdult() && this.familiarity <= 35) {
/*     */           
/* 399 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 401 */         else if (!isAdult()) {
/* 402 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 403 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 404 */           if (this.familiarity > 70) {
/* 405 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 409 */       } else if (this.familiarity < 30) {
/* 410 */         this.familiarity = (int)(this.familiarity - 2L * (totalDays - this.lastFamiliarityUpdate));
/* 411 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 414 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 415 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 424 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 426 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 428 */         familiarize(player);
/* 429 */         return true;
/*     */       } 
/* 431 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/* 432 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 435 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*     */     
/* 437 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/* 438 */       !canFamiliarize())) {
/*     */       
/* 440 */       if (!player.field_71075_bZ.field_75098_d)
/*     */       {
/* 442 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/* 444 */       this.hunger += 24000;
/* 445 */       func_146082_f(player);
/* 446 */       return true;
/*     */     } 
/* 448 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 449 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 450 */         itemstack.field_77994_a--;
/*     */       }
/* 452 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 456 */     if (super.func_70085_c(player))
/*     */     {
/* 458 */       return true;
/*     */     }
/* 460 */     if (func_70901_n() && !this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == player)) {
/*     */       
/* 462 */       player.func_70078_a((Entity)this);
/* 463 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 467 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 475 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 484 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 490 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItemTFC(ItemStack item) {
/* 495 */     return (!this.pregnant && isFood(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 501 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 506 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 507 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 513 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 519 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 521 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 524 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 525 */     this.pregnant = true;
/* 526 */     func_70875_t();
/* 527 */     otherAnimal.setInLove(false);
/* 528 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 529 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 530 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 531 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 538 */     if (this.hunger > 168000)
/* 539 */       this.hunger = 168000; 
/* 540 */     if (this.hunger > 0) {
/* 541 */       this.hunger--;
/*     */     }
/* 543 */     if (func_70880_s()) {
/*     */       
/* 545 */       func_70875_t();
/* 546 */       setInLove(true);
/*     */     } 
/*     */     
/* 549 */     handleFamiliarityUpdate();
/*     */     
/* 551 */     syncData();
/* 552 */     if (isAdult()) {
/* 553 */       func_70873_a(0);
/*     */     } else {
/* 555 */       func_70873_a(-1);
/*     */     } 
/* 557 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*     */     {
/* 559 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */         
/* 561 */         for (int i = 0; i < 8 + this.field_70146_Z.nextInt(5); i++) {
/*     */           
/* 563 */           EntityPigTFC baby = (EntityPigTFC)createChildTFC((EntityAgeable)this);
/* 564 */           baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 565 */           baby.field_70759_as = baby.field_70177_z;
/* 566 */           baby.field_70761_aq = baby.field_70177_z;
/* 567 */           this.field_70170_p.func_72838_d((Entity)baby);
/* 568 */           baby.setAge(TFC_Time.getTotalDays());
/*     */         } 
/* 570 */         this.pregnant = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 577 */     TFC_Core.preventEntityDataUpdate = true;
/* 578 */     super.func_70636_d();
/* 579 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 581 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/* 582 */       func_70691_i(1.0F);
/*     */     }
/* 584 */     else if (this.hunger < 144000 && func_70880_s()) {
/* 585 */       setInLove(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70077_a(EntityLightningBolt par1EntityLightningBolt) {
/* 596 */     func_70081_e(5);
/* 597 */     func_70015_d(8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 603 */     super.func_70037_a(nbt);
/* 604 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 605 */     this.sex = nbt.func_74762_e("Sex");
/* 606 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 608 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 609 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 610 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 612 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 613 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 614 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 616 */     this.hunger = nbt.func_74762_e("Hunger");
/* 617 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 618 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 619 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 620 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 621 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 622 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 623 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/* 624 */     func_70900_e(nbt.func_74767_n("Saddle"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 631 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 638 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimalID(long animalID) {
/* 643 */     this.animalID = animalID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttackedVec(Vec3 attackedVec) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBirthDay(int day) {
/* 655 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 661 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 666 */     this.familiarizedToday = familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFearSource(Entity fearSource) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70873_a(int par1) {
/* 678 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 679 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 685 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 691 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 696 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 702 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 707 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 712 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70900_e(boolean par1) {
/* 721 */     if (par1) {
/* 722 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)1));
/*     */     } else {
/* 724 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)0));
/*     */     } 
/*     */   }
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
/*     */   public void syncData() {
/* 751 */     if (this.field_70180_af != null)
/*     */     {
/* 753 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 755 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 761 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 767 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 768 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 769 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 770 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 774 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 776 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 777 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 778 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 779 */         byte[] values = buf.array();
/*     */         
/* 781 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 782 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 783 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 784 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 786 */         this.familiarity = values[4];
/* 787 */         this.familiarizedToday = (values[5] == 1);
/* 788 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 792 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 793 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 800 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 802 */       func_94058_c(name);
/* 803 */       return true;
/*     */     } 
/* 805 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 806 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 812 */     super.func_70014_b(nbt);
/* 813 */     nbt.func_74768_a("Sex", this.sex);
/* 814 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 815 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 817 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 818 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 819 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 821 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 822 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 823 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 825 */     nbt.func_74768_a("Hunger", this.hunger);
/* 826 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 827 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 828 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 829 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 830 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 831 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 832 */     nbt.func_74768_a("Age", getBirthDay());
/* 833 */     nbt.func_74757_a("Saddle", func_70901_n());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityPigTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */