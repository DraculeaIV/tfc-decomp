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
/*  95 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityPolarBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  96 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent(this, 0.25D));
/*  97 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)this.aiEatGrass);
/*  98 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.5D));
/*  99 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/* 100 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityDeer(World par1World, IAnimal mother, List<Float> data) {
/* 111 */     this(par1World);
/* 112 */     float fatherSize = 1.0F;
/* 113 */     float fatherStr = 1.0F;
/* 114 */     float fatherAggro = 1.0F;
/* 115 */     float fatherObed = 1.0F;
/* 116 */     for (int i = 0; i < data.size(); i++) {
/* 117 */       switch (i) { case 0:
/* 118 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 119 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 120 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 121 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 125 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 126 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 127 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 128 */     float invSizeRatio = 0.5472855F;
/* 129 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 130 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 131 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 132 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 134 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 137 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 144 */     super.func_110147_ax();
/* 145 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 151 */     Entity entity = par1DamageSource.func_76346_g();
/* 152 */     if (entity != null) {
/*     */       
/* 154 */       setAttackedVec(Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v));
/* 155 */       setFearSource(entity);
/*     */     } 
/* 157 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 163 */     return (this.field_70173_aa > 10000 && !this.wasRoped);
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
/* 175 */     return (!isAdult() || (isAdult() && this.familiarity <= 70));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 181 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityDeer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 187 */     boolean flag = false;
/* 188 */     switch (interaction) { case BREED:
/* 189 */         flag = (this.familiarity > 20); break;
/* 190 */       case NAME: flag = (this.familiarity > 60); break;
/* 191 */       case TOLERATEPLAYER: flag = (this.familiarity > 40);
/*     */         break; }
/*     */     
/* 194 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 195 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 197 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable func_90011_a(EntityAgeable entityageable) {
/* 203 */     return createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 209 */     ArrayList<Float> data = new ArrayList<Float>();
/* 210 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 211 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 212 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 213 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 214 */     return (EntityAgeable)new EntityDeer(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 223 */     float ageMod = TFC_Core.getPercentGrown(this);
/* 224 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)((ageMod * this.sizeMod) * 1.84D)))), 0.0F);
/* 225 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(4) + 2) * ageMod));
/* 226 */     float foodWeight = ageMod * this.sizeMod * 2400.0F;
/*     */     
/* 228 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.venisonRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 234 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 240 */     super.func_70088_a();
/* 241 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 242 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 244 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 245 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 246 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 251 */     ItemStack stack = ep.func_70694_bm();
/* 252 */     if (stack != null && stack.func_77973_b() != null && stack.func_77973_b().equals(TFCItems.powder) && stack.func_77960_j() == 9 && !this.familiarizedToday && 
/* 253 */       canFamiliarize()) {
/*     */       
/* 255 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 257 */         stack.field_77994_a--;
/* 258 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, stack);
/*     */       } 
/* 260 */       this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 261 */       this.hunger += 24000;
/* 262 */       this.familiarizedToday = true;
/* 263 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 264 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 271 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 277 */     return Helper.stringToInt("deer");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 283 */     return this.attackedVec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 289 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 298 */     return "terrafirmacraft:mob.deer.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 307 */     return Items.field_151116_aA;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 313 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 318 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 323 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 329 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 335 */     return this.fearSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 341 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 347 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 356 */     return "terrafirmacraft:mob.deer.hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 362 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 367 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 376 */     if (getGender() == IAnimal.GenderEnum.MALE && isAdult() && this.field_70170_p.field_73012_v.nextInt(100) < 5)
/* 377 */       return "terrafirmacraft:mob.deer.cry"; 
/* 378 */     return "terrafirmacraft:mob.deer.say";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 384 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 24.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 390 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 395 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getRunning() {
/* 400 */     return this.running;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 405 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 411 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 417 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 422 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 427 */     int totalDays = TFC_Time.getTotalDays();
/* 428 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 429 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 430 */         this.lastFamiliarityUpdate = totalDays;
/* 431 */         this.familiarizedToday = false;
/* 432 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 433 */         if (isAdult() && this.familiarity <= 70) {
/*     */           
/* 435 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 437 */         else if (!isAdult()) {
/* 438 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 439 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 440 */           if (this.familiarity > 70) {
/* 441 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 445 */       } else if (this.familiarity < 30) {
/* 446 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 447 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 450 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 451 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */   
/*     */   public boolean hasBeenRoped() {
/* 456 */     return this.wasRoped;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 465 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 467 */       if (player.func_70093_af() && canFamiliarize()) {
/*     */         
/* 469 */         familiarize(player);
/* 470 */         return true;
/*     */       } 
/* 472 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 474 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 477 */     ItemStack itemstack = player.func_70694_bm();
/* 478 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 479 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 480 */         itemstack.field_77994_a--;
/*     */       }
/* 482 */       return true;
/*     */     } 
/* 484 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 490 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70650_aV() {
/* 499 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 505 */     return !isAdult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 511 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 517 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 523 */     if (this.sex == 0) {
/*     */       
/* 525 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 528 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 529 */     this.pregnant = true;
/* 530 */     func_70875_t();
/* 531 */     otherAnimal.setInLove(false);
/* 532 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 533 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 534 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 535 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 545 */     if (func_70880_s()) {
/*     */       
/* 547 */       func_70875_t();
/* 548 */       setInLove(true);
/*     */     } 
/*     */     
/* 551 */     if (func_110167_bD() && !this.wasRoped) this.wasRoped = true;
/*     */     
/* 553 */     syncData();
/* 554 */     if (isAdult()) {
/*     */       
/* 556 */       func_70873_a(0);
/*     */     }
/*     */     else {
/*     */       
/* 560 */       func_70873_a(-1);
/*     */     } 
/*     */     
/* 563 */     handleFamiliarityUpdate();
/*     */     
/* 565 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*     */     {
/* 567 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */         
/* 569 */         EntityDeer baby = (EntityDeer)createChildTFC((EntityAgeable)this);
/* 570 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 571 */         baby.field_70759_as = baby.field_70177_z;
/* 572 */         baby.field_70761_aq = baby.field_70177_z;
/* 573 */         this.field_70170_p.func_72838_d((Entity)baby);
/* 574 */         baby.setAge(TFC_Time.getTotalDays());
/* 575 */         this.pregnant = false;
/*     */       } 
/*     */     }
/*     */     
/* 579 */     if (this.attackedVec != null) {
/*     */ 
/*     */       
/* 582 */       Vec3 positionVec = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 583 */       if (getFearSource() != null && func_70068_e(getFearSource()) > 144.0D) {
/*     */         
/* 585 */         setFearSource((Entity)null);
/*     */       }
/* 587 */       else if (positionVec.func_72438_d(getAttackedVec()) > 16.0D) {
/*     */         
/* 589 */         setAttackedVec((Vec3)null);
/*     */       } 
/*     */     } 
/*     */     
/* 593 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 595 */       func_70691_i(1.0F);
/*     */     }
/* 597 */     else if (this.hunger < 144000 && func_70880_s()) {
/* 598 */       setInLove(false);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 604 */     TFC_Core.preventEntityDataUpdate = true;
/* 605 */     super.func_70636_d();
/* 606 */     TFC_Core.preventEntityDataUpdate = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 615 */     super.func_70037_a(nbt);
/* 616 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 617 */     this.sex = nbt.func_74762_e("Sex");
/* 618 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 620 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 621 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 622 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 624 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 625 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 626 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 628 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */     
/* 630 */     this.hunger = nbt.func_74762_e("Hunger");
/* 631 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 632 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 633 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 634 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 635 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 636 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 637 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 643 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 649 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttackedVec(Vec3 attackedVec) {
/* 655 */     this.attackedVec = attackedVec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBirthDay(int day) {
/* 661 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 667 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 672 */     this.familiarizedToday = familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFearSource(Entity fearSource) {
/* 678 */     this.fearSource = fearSource;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70873_a(int par1) {
/* 684 */     if (!TFC_Core.preventEntityDataUpdate)
/*     */     {
/* 686 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 693 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 699 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 704 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 710 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 715 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 720 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRunning(boolean r) {
/* 725 */     this.running = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 730 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 736 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 742 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 747 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWasRoped(boolean wasRoped) {
/* 752 */     this.wasRoped = wasRoped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 757 */     if (this.field_70180_af != null)
/*     */     {
/* 759 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 761 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 767 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 773 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 774 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 775 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 776 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 780 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 782 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 783 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 784 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 785 */         byte[] values = buf.array();
/*     */         
/* 787 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 788 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 789 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 790 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 792 */         this.familiarity = values[4];
/* 793 */         this.familiarizedToday = (values[5] == 1);
/* 794 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 798 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 799 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 806 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 808 */       func_94058_c(name);
/* 809 */       return true;
/*     */     } 
/* 811 */     func_85030_a("terrafirmacraft:mob.deer.cry", 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 812 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 821 */     super.func_70014_b(nbt);
/* 822 */     nbt.func_74768_a("Sex", this.sex);
/* 823 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 824 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 826 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 827 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 828 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 830 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 831 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 832 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 834 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */     
/* 836 */     nbt.func_74768_a("Hunger", this.hunger);
/* 837 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 838 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 839 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 840 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 841 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 842 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 843 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityDeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */