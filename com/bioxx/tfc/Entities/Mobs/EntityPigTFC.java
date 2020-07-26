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
/*  83 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */     
/*  85 */     this.hunger = 168000;
/*  86 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  87 */     this.pregnant = false;
/*  88 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 3.7F * (float)TFC_Time.ticksInMonth);
/*  89 */     this.timeOfConception = 0L;
/*  90 */     this.mateSizeMod = 0.0F;
/*  91 */     this.sex = this.field_70146_Z.nextInt(2);
/*  92 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.271F * this.sex)));
/*  93 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  94 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  95 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPigTFC(World par1World, IAnimal mother, List<Float> data) {
/* 107 */     this(par1World);
/* 108 */     float fatherSize = 1.0F;
/* 109 */     float fatherStr = 1.0F;
/* 110 */     float fatherAggro = 1.0F;
/* 111 */     float fatherObed = 1.0F;
/* 112 */     for (int i = 0; i < data.size(); i++) {
/* 113 */       switch (i) { case 0:
/* 114 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 115 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 116 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 117 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 121 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 122 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 123 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 124 */     float invSizeRatio = 0.578369F;
/* 125 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 126 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 127 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 128 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 130 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 133 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 139 */     super.func_110147_ax();
/* 140 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 146 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 152 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityPigTFC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 158 */     boolean flag = false;
/* 159 */     switch (interaction) { case MOUNT:
/* 160 */         flag = (this.familiarity > 15); break;
/* 161 */       case BREED: flag = (this.familiarity > 10); break;
/* 162 */       case NAME: flag = (this.familiarity > 40);
/*     */         break; }
/*     */     
/* 165 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 166 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 168 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPig func_90011_a(EntityAgeable entityageable) {
/* 174 */     return (EntityPig)createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 180 */     ArrayList<Float> data = new ArrayList<Float>();
/* 181 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 182 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 183 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 184 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 185 */     return (EntityAgeable)new EntityPigTFC(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 191 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 193 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/* 194 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(4) + 2) * ageMod));
/*     */     
/* 196 */     float foodWeight = ageMod * this.sizeMod * 2400.0F;
/* 197 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.porkchopRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 203 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 209 */     super.func_70088_a();
/* 210 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 211 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/* 212 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 213 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 214 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float par1) {
/* 223 */     super.func_70069_a(par1);
/*     */     
/* 225 */     if (par1 > 5.0F && this.field_70153_n instanceof EntityPlayer) {
/* 226 */       ((EntityPlayer)this.field_70153_n).func_71029_a((StatBase)AchievementList.field_76021_u);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 232 */     ItemStack stack = ep.func_70694_bm();
/* 233 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 235 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 237 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 241 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 243 */       this.hunger += 24000;
/* 244 */       this.familiarizedToday = true;
/* 245 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 246 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 253 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAnimalID() {
/* 258 */     return this.animalID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 264 */     return Helper.stringToInt("pig");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 276 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 285 */     return func_70027_ad() ? Items.field_151157_am : Items.field_151147_al;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 291 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 297 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 302 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 308 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 314 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 320 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 326 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 332 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 337 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 343 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 15.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 349 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 354 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70901_n() {
/* 363 */     return ((this.field_70180_af.func_75683_a(16) & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 368 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 374 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 380 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 385 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 390 */     int totalDays = TFC_Time.getTotalDays();
/* 391 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 392 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 393 */         this.lastFamiliarityUpdate = totalDays;
/* 394 */         this.familiarizedToday = false;
/* 395 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 396 */         if (isAdult() && this.familiarity <= 35) {
/*     */           
/* 398 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 400 */         else if (!isAdult()) {
/* 401 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 402 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 403 */           if (this.familiarity > 70) {
/* 404 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 408 */       } else if (this.familiarity < 30) {
/* 409 */         this.familiarity = (int)(this.familiarity - 2L * (totalDays - this.lastFamiliarityUpdate));
/* 410 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 413 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 414 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 423 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 425 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 427 */         familiarize(player);
/* 428 */         return true;
/*     */       } 
/* 430 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/* 431 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 434 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*     */     
/* 436 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/* 437 */       !canFamiliarize())) {
/*     */       
/* 439 */       if (!player.field_71075_bZ.field_75098_d)
/*     */       {
/* 441 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/* 443 */       this.hunger += 24000;
/* 444 */       func_146082_f(player);
/* 445 */       return true;
/*     */     } 
/* 447 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 448 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 449 */         itemstack.field_77994_a--;
/*     */       }
/* 451 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 455 */     if (super.func_70085_c(player))
/*     */     {
/* 457 */       return true;
/*     */     }
/* 459 */     if (func_70901_n() && !this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == player)) {
/*     */       
/* 461 */       player.func_70078_a((Entity)this);
/* 462 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 466 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 474 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 483 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 489 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItemTFC(ItemStack item) {
/* 494 */     return (!this.pregnant && isFood(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 500 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 505 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 506 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 512 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 518 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 520 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 523 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 524 */     this.pregnant = true;
/* 525 */     func_70875_t();
/* 526 */     otherAnimal.setInLove(false);
/* 527 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 528 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 529 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 530 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 537 */     if (this.hunger > 168000)
/* 538 */       this.hunger = 168000; 
/* 539 */     if (this.hunger > 0) {
/* 540 */       this.hunger--;
/*     */     }
/* 542 */     if (func_70880_s()) {
/*     */       
/* 544 */       func_70875_t();
/* 545 */       setInLove(true);
/*     */     } 
/*     */     
/* 548 */     handleFamiliarityUpdate();
/*     */     
/* 550 */     syncData();
/* 551 */     if (isAdult()) {
/* 552 */       func_70873_a(0);
/*     */     } else {
/* 554 */       func_70873_a(-1);
/*     */     } 
/* 556 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*     */     {
/* 558 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */         
/* 560 */         for (int i = 0; i < 8 + this.field_70146_Z.nextInt(5); i++) {
/*     */           
/* 562 */           EntityPigTFC baby = (EntityPigTFC)createChildTFC((EntityAgeable)this);
/* 563 */           baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 564 */           baby.field_70759_as = baby.field_70177_z;
/* 565 */           baby.field_70761_aq = baby.field_70177_z;
/* 566 */           this.field_70170_p.func_72838_d((Entity)baby);
/* 567 */           baby.setAge(TFC_Time.getTotalDays());
/*     */         } 
/* 569 */         this.pregnant = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 576 */     TFC_Core.preventEntityDataUpdate = true;
/* 577 */     super.func_70636_d();
/* 578 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 580 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/* 581 */       func_70691_i(1.0F);
/*     */     }
/* 583 */     else if (this.hunger < 144000 && func_70880_s()) {
/* 584 */       setInLove(false);
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
/* 595 */     func_70081_e(5);
/* 596 */     func_70015_d(8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 602 */     super.func_70037_a(nbt);
/* 603 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 604 */     this.sex = nbt.func_74762_e("Sex");
/* 605 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 607 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 608 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 609 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 611 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 612 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 613 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 615 */     this.hunger = nbt.func_74762_e("Hunger");
/* 616 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 617 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 618 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 619 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 620 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 621 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 622 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/* 623 */     func_70900_e(nbt.func_74767_n("Saddle"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 630 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 637 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimalID(long animalID) {
/* 642 */     this.animalID = animalID;
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
/* 654 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 660 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 665 */     this.familiarizedToday = familiarizedToday;
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
/* 677 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 678 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 684 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 690 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 695 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 701 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 706 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 711 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70900_e(boolean par1) {
/* 720 */     if (par1) {
/* 721 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)1));
/*     */     } else {
/* 723 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)0));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSex(int sex) {
/* 728 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 734 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 740 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 745 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 750 */     if (this.field_70180_af != null)
/*     */     {
/* 752 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 754 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 760 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 766 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 767 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 768 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 769 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 773 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 775 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 776 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 777 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 778 */         byte[] values = buf.array();
/*     */         
/* 780 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 781 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 782 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 783 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 785 */         this.familiarity = values[4];
/* 786 */         this.familiarizedToday = (values[5] == 1);
/* 787 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 791 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 792 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 799 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 801 */       func_94058_c(name);
/* 802 */       return true;
/*     */     } 
/* 804 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 805 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 811 */     super.func_70014_b(nbt);
/* 812 */     nbt.func_74768_a("Sex", this.sex);
/* 813 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 814 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 816 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 817 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 818 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 820 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 821 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 822 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 824 */     nbt.func_74768_a("Hunger", this.hunger);
/* 825 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 826 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 827 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 828 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 829 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 830 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 831 */     nbt.func_74768_a("Age", getBirthDay());
/* 832 */     nbt.func_74757_a("Saddle", func_70901_n());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityPigTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */