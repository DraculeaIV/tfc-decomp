/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.AIEatGrass;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.Items.Tools.ItemCustomBucketMilk;
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
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.passive.EntityCow;
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
/*     */ public class EntityCowTFC
/*     */   extends EntityCow implements IAnimal {
/*     */   private static final float GESTATION_PERIOD = 9.0F;
/*     */   private static final float DIMORPHISM = 0.1822F;
/*     */   private static final int DEGREE_OF_DIVERSION = 1;
/*     */   private static final int FAMILIARITY_CAP = 35;
/*  42 */   protected final AIEatGrass aiEatGrass = new AIEatGrass(this);
/*     */   
/*     */   private long animalID;
/*     */   private int sex;
/*     */   private int hunger;
/*     */   private long hasMilkTime;
/*     */   private boolean canMilk;
/*     */   private boolean pregnant;
/*     */   private int pregnancyRequiredTime;
/*     */   private long timeOfConception;
/*     */   private float mateSizeMod;
/*     */   private float mateStrengthMod;
/*     */   private float mateAggroMod;
/*     */   private float mateObedMod;
/*     */   private float sizeMod;
/*     */   private float strengthMod;
/*  58 */   private float aggressionMod = 1.0F;
/*  59 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityCowTFC(World par1World) {
/*  68 */     super(par1World);
/*  69 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  70 */     this.hunger = 168000;
/*  71 */     this.pregnant = false;
/*  72 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 9.0F * (float)TFC_Time.ticksInMonth);
/*  73 */     this.timeOfConception = 0L;
/*  74 */     this.mateSizeMod = 0.0F;
/*  75 */     this.sex = this.field_70146_Z.nextInt(2);
/*     */     
/*  77 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.1822F * this.sex)));
/*  78 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  79 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  80 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*  81 */     func_70105_a(0.9F, 1.3F);
/*  82 */     func_70661_as().func_75491_a(true);
/*  83 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  84 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/*  85 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/*  86 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/*  87 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/*  88 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/*  89 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/*  90 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/*  91 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCowTFC(World par1World, IAnimal mother, List<Float> data) {
/* 104 */     this(par1World);
/* 105 */     float fatherSize = 1.0F;
/* 106 */     float fatherStr = 1.0F;
/* 107 */     float fatherAggro = 1.0F;
/* 108 */     float fatherObed = 1.0F;
/* 109 */     for (int i = 0; i < data.size(); i++) {
/* 110 */       switch (i) { case 0:
/* 111 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 112 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 113 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 114 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 118 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 119 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 120 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 121 */     float invSizeRatio = 0.5501155F;
/* 122 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 123 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 124 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 125 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 127 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 130 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 136 */     super.func_110147_ax();
/* 137 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 143 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 149 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityCowTFC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 156 */     boolean flag = false;
/* 157 */     switch (interaction) {
/*     */       
/*     */       case BREED:
/* 160 */         flag = (this.familiarity > 20);
/*     */         break;
/*     */       case MILK:
/* 163 */         flag = (this.familiarity > 15);
/*     */         break;
/*     */       case NAME:
/* 166 */         flag = (this.familiarity > 40);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 171 */     if (!flag && player != null && !player.field_70170_p.field_72995_K)
/*     */     {
/* 173 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 175 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityCow func_90011_a(EntityAgeable entityageable) {
/* 181 */     return (EntityCow)createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 187 */     ArrayList<Float> data = new ArrayList<Float>();
/* 188 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 189 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 190 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 191 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 192 */     return (EntityAgeable)new EntityCowTFC(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 201 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 203 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/* 204 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(6) + 3) * ageMod));
/*     */     
/* 206 */     float foodWeight = ageMod * this.sizeMod * 4000.0F;
/*     */     
/* 208 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.beefRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 214 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 220 */     super.func_70088_a();
/* 221 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 222 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 224 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 225 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 226 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
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
/* 264 */     return Helper.stringToInt("cow");
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
/* 285 */     return Items.field_151116_aA;
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
/*     */   
/*     */   public EntityLiving getEntity() {
/* 298 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 304 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 310 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 316 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 322 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */   
/*     */   public long getHasMilkTime() {
/* 327 */     return this.hasMilkTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 333 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 339 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 344 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 350 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 36.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 356 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 361 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 366 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 372 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 378 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 383 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 389 */     int totalDays = TFC_Time.getTotalDays();
/* 390 */     if (this.lastFamiliarityUpdate < totalDays)
/*     */     {
/* 392 */       if (this.familiarizedToday && this.familiarity < 100) {
/*     */         
/* 394 */         this.lastFamiliarityUpdate = totalDays;
/* 395 */         this.familiarizedToday = false;
/* 396 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 397 */         if (isAdult() && this.familiarity <= 35)
/*     */         {
/* 399 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 401 */         else if (!isAdult())
/*     */         {
/* 403 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 404 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 405 */           if (this.familiarity > 70)
/*     */           {
/* 407 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 411 */       } else if (this.familiarity < 30) {
/*     */         
/* 413 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 414 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 417 */     if (this.familiarity > 100)
/* 418 */       this.familiarity = 100; 
/* 419 */     if (this.familiarity < 0) {
/* 420 */       this.familiarity = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 429 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 431 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 433 */         familiarize(player);
/* 434 */         return true;
/*     */       } 
/*     */       
/* 437 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 439 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */       
/* 442 */       if (getGender() == IAnimal.GenderEnum.FEMALE && isAdult() && this.hasMilkTime < TFC_Time.getTotalTicks() && checkFamiliarity(IAnimal.InteractionEnum.MILK, player)) {
/*     */         
/* 444 */         ItemStack heldItem = player.field_71071_by.func_70448_g();
/* 445 */         if (heldItem != null && heldItem.func_77973_b() == TFCItems.woodenBucketEmpty) {
/*     */           
/* 447 */           if (!this.familiarizedToday && this.familiarity <= 35) {
/*     */             
/* 449 */             this.familiarizedToday = true;
/* 450 */             func_70671_ap().func_75651_a((Entity)player, 0.0F, 0.0F);
/* 451 */             func_70642_aH();
/*     */           } 
/*     */           
/* 454 */           ItemStack milkBucket = new ItemStack(TFCItems.woodenBucketMilk);
/* 455 */           ItemCustomBucketMilk.createTag(milkBucket, 20.0F);
/* 456 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, milkBucket);
/* 457 */           this.hasMilkTime = TFC_Time.getTotalTicks() + 24000L;
/* 458 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 463 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/* 464 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/* 465 */       !canFamiliarize())) {
/*     */       
/* 467 */       if (!player.field_71075_bZ.field_75098_d)
/*     */       {
/* 469 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/* 471 */       this.hunger += 24000;
/* 472 */       func_146082_f(player);
/* 473 */       return true;
/*     */     } 
/* 475 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 476 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 477 */         itemstack.field_77994_a--;
/*     */       }
/* 479 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 483 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 490 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 496 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItemTFC(ItemStack item) {
/* 501 */     return (!this.pregnant && isFood(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 507 */     return !isAdult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 513 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 514 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMilkable() {
/* 519 */     return this.canMilk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 525 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 531 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 533 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 536 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 537 */     this.pregnant = true;
/* 538 */     func_70875_t();
/* 539 */     otherAnimal.setInLove(false);
/* 540 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 541 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 542 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 543 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 550 */     if (this.hunger > 168000)
/*     */     {
/* 552 */       this.hunger = 168000;
/*     */     }
/* 554 */     if (this.hunger > 0)
/*     */     {
/* 556 */       this.hunger--;
/*     */     }
/*     */     
/* 559 */     if (func_70880_s()) {
/*     */       
/* 561 */       func_70875_t();
/* 562 */       setInLove(true);
/*     */     } 
/*     */     
/* 565 */     handleFamiliarityUpdate();
/*     */     
/* 567 */     if (getGender() == IAnimal.GenderEnum.FEMALE && isAdult() && this.hasMilkTime < TFC_Time.getTotalTicks() && checkFamiliarity(IAnimal.InteractionEnum.MILK, (EntityPlayer)null)) {
/* 568 */       this.canMilk = true;
/*     */     } else {
/* 570 */       this.canMilk = false;
/*     */     } 
/* 572 */     syncData();
/* 573 */     if (isAdult()) {
/*     */       
/* 575 */       func_70873_a(0);
/*     */     }
/*     */     else {
/*     */       
/* 579 */       func_70873_a(-1);
/*     */     } 
/* 581 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*     */     {
/* 583 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */         
/* 585 */         EntityCowTFC baby = (EntityCowTFC)createChildTFC((EntityAgeable)this);
/* 586 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 587 */         baby.field_70759_as = baby.field_70177_z;
/* 588 */         baby.field_70761_aq = baby.field_70177_z;
/* 589 */         this.field_70170_p.func_72838_d((Entity)baby);
/* 590 */         baby.setAge(TFC_Time.getTotalDays());
/* 591 */         this.pregnant = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 598 */     TFC_Core.preventEntityDataUpdate = true;
/* 599 */     super.func_70636_d();
/* 600 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 602 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 604 */       func_70691_i(1.0F);
/*     */     }
/* 606 */     else if (this.hunger < 144000 && func_70880_s()) {
/*     */       
/* 608 */       setInLove(false);
/*     */     } 
/*     */   }
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
/* 628 */     this.hunger = nbt.func_74762_e("Hunger");
/* 629 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 630 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 631 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 632 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 633 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 634 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 635 */     this.hasMilkTime = nbt.func_74763_f("HasMilkTime");
/* 636 */     this.canMilk = nbt.func_74767_n("CanMilk");
/* 637 */     setAge(nbt.func_74762_e("Age"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 644 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 651 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimalID(long animalID) {
/* 656 */     this.animalID = animalID;
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
/* 668 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCanMilk(boolean canMilk) {
/* 673 */     this.canMilk = canMilk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 679 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 684 */     this.familiarizedToday = familiarizedToday;
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
/* 696 */     if (!TFC_Core.preventEntityDataUpdate)
/*     */     {
/* 698 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHasMilkTime(long hasMilkTime) {
/* 704 */     this.hasMilkTime = hasMilkTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 710 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 716 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 721 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 727 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 732 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 737 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 742 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 748 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 754 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 759 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 764 */     if (this.field_70180_af != null)
/*     */     {
/* 766 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 768 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */         
/* 770 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), (byte)(this.canMilk ? 1 : 0) };
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
/* 795 */         this.canMilk = (values[7] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 799 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 800 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 809 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 811 */       func_94058_c(name);
/* 812 */       func_94061_f(true);
/* 813 */       return true;
/*     */     } 
/* 815 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 816 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 822 */     super.func_70014_b(nbt);
/* 823 */     nbt.func_74768_a("Sex", this.sex);
/* 824 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 825 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 827 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 828 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 829 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 831 */     NBTTagCompound nbt2 = nbt;
/* 832 */     nbt2.func_74776_a("Strength Modifier", this.strengthMod);
/* 833 */     nbt2.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 834 */     nbt2.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 836 */     nbt.func_74768_a("Hunger", this.hunger);
/* 837 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 838 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 839 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 840 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 841 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 842 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 843 */     nbt.func_74768_a("Age", getBirthDay());
/* 844 */     nbt.func_74772_a("HasMilkTime", this.hasMilkTime);
/* 845 */     nbt.func_74757_a("CanMilk", this.canMilk);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityCowTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */