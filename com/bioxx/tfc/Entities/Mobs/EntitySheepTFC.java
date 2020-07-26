/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.AIEatGrass;
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
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ public class EntitySheepTFC
/*     */   extends EntitySheep
/*     */   implements IShearable, IAnimal {
/*  44 */   public static final float[][] FLEECE_COLOR_TABLE = new float[][] { { 1.0F, 1.0F, 1.0F }, { 0.95F, 0.7F, 0.2F }, { 0.9F, 0.5F, 0.85F }, { 0.6F, 0.7F, 0.95F }, { 0.9F, 0.9F, 0.2F }, { 0.5F, 0.8F, 0.1F }, { 0.95F, 0.7F, 0.8F }, { 0.3F, 0.3F, 0.3F }, { 0.6F, 0.6F, 0.6F }, { 0.3F, 0.6F, 0.7F }, { 0.7F, 0.4F, 0.9F }, { 0.2F, 0.4F, 0.8F }, { 0.5F, 0.4F, 0.3F }, { 0.4F, 0.5F, 0.2F }, { 0.8F, 0.3F, 0.3F }, { 0.1F, 0.1F, 0.1F } };
/*     */   
/*     */   private static final float GESTATION_PERIOD = 5.0F;
/*     */   
/*     */   private static final float DIMORPHISM = 0.1633F;
/*     */   
/*     */   private static final int DEGREE_OF_DIVERSION = 2;
/*     */   
/*     */   private static final int FAMILIARITY_CAP = 35;
/*     */ 
/*     */   
/*  55 */   private final InventoryCrafting colorCrafting = new InventoryCrafting(new Container()
/*     */       {
/*     */         
/*     */         public boolean func_75145_c(EntityPlayer p_75145_1_)
/*     */         {
/*  60 */           return false;
/*     */         }
/*     */       },  2, 1);
/*     */ 
/*     */ 
/*     */   
/*     */   private int sheepTimer;
/*     */ 
/*     */   
/*  69 */   protected final AIEatGrass aiEatGrass = new AIEatGrass(this);
/*     */   
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
/*     */   private int mateColor;
/*     */   private float sizeMod;
/*     */   private float strengthMod;
/*  84 */   private float aggressionMod = 1.0F;
/*  85 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   private EntityPlayer shearer;
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntitySheepTFC(World par1World) {
/*  94 */     super(par1World);
/*  95 */     func_70105_a(0.9F, 1.3F);
/*  96 */     func_70661_as().func_75491_a(true);
/*  97 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  98 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/*  99 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/* 100 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/* 101 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/* 102 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/* 103 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/* 104 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/* 105 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/* 106 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*     */     
/* 108 */     this.colorCrafting.func_70299_a(0, new ItemStack(Items.field_151100_aR, 1, 0));
/* 109 */     this.colorCrafting.func_70299_a(1, new ItemStack(Items.field_151100_aR, 1, 0));
/*     */     
/* 111 */     this.hunger = 168000;
/* 112 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/* 113 */     this.pregnant = false;
/* 114 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 5.0F * (float)TFC_Time.ticksInMonth);
/* 115 */     this.timeOfConception = 0L;
/* 116 */     this.mateSizeMod = 0.0F;
/* 117 */     this.sex = this.field_70146_Z.nextInt(2);
/* 118 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.1633F * this.sex)));
/* 119 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/* 120 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/* 121 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntitySheepTFC(World par1World, IAnimal mother, List<Float> data) {
/* 134 */     this(par1World);
/* 135 */     float fatherSize = 1.0F;
/* 136 */     float fatherStr = 1.0F;
/* 137 */     float fatherAggro = 1.0F;
/* 138 */     float fatherObed = 1.0F;
/* 139 */     for (int i = 0; i < data.size(); i++) {
/* 140 */       switch (i) { case 0:
/* 141 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 142 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 143 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 144 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 148 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 149 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 150 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*     */     
/* 152 */     float invSizeRatio = 0.54445475F;
/* 153 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 154 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 155 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 156 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 158 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 161 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 167 */     super.func_110147_ax();
/* 168 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 174 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 180 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntitySheepTFC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 187 */     boolean flag = false;
/* 188 */     switch (interaction) {
/*     */       
/*     */       case BREED:
/* 191 */         flag = (this.familiarity > 20);
/*     */         break;
/*     */       case SHEAR:
/* 194 */         flag = (this.familiarity > 10);
/*     */         break;
/*     */       case NAME:
/* 197 */         flag = (this.familiarity > 40);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 202 */     if (!flag && player != null && !player.field_70170_p.field_72995_K)
/*     */     {
/* 204 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 206 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public int combineColors(EntityAnimal parent, int mateColor) {
/* 211 */     int babyColor, parent1Color = 15 - ((EntitySheep)parent).func_70896_n();
/* 212 */     int parent2Color = 15 - mateColor;
/* 213 */     this.colorCrafting.func_70301_a(0).func_77964_b(parent1Color);
/* 214 */     this.colorCrafting.func_70301_a(1).func_77964_b(parent2Color);
/* 215 */     ItemStack itemstack = CraftingManager.func_77594_a().func_82787_a(this.colorCrafting, ((EntitySheep)parent).field_70170_p);
/*     */ 
/*     */     
/* 218 */     if (itemstack != null && itemstack.func_77973_b() == Items.field_151100_aR) {
/*     */       
/* 220 */       babyColor = itemstack.func_77960_j();
/*     */     }
/*     */     else {
/*     */       
/* 224 */       babyColor = this.field_70170_p.field_73012_v.nextBoolean() ? parent1Color : parent2Color;
/*     */     } 
/*     */     
/* 227 */     return babyColor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntitySheep func_90011_a(EntityAgeable entityageable) {
/* 233 */     return (EntitySheep)createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 239 */     ArrayList<Float> data = new ArrayList<Float>();
/* 240 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 241 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 242 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 243 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 244 */     EntitySheepTFC baby = new EntitySheepTFC(this.field_70170_p, this, data);
/* 245 */     int colorMeta = combineColors((EntityAnimal)this, ((EntitySheepTFC)eAgeable).mateColor);
/* 246 */     baby.func_70891_b(15 - colorMeta);
/* 247 */     return (EntityAgeable)baby;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 256 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 258 */     if (!func_70892_o()) {
/* 259 */       func_70099_a(new ItemStack(TFCItems.sheepSkin, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/*     */     } else {
/* 261 */       func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/*     */     } 
/* 263 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(5) + 2) * ageMod));
/*     */     
/* 265 */     float foodWeight = ageMod * this.sizeMod * 640.0F;
/* 266 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.muttonRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 272 */     func_70893_e(false);
/* 273 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 279 */     super.func_70088_a();
/* 280 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 281 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 283 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 284 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 285 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 290 */     ItemStack stack = ep.func_70694_bm();
/* 291 */     if (stack != null && !this.familiarizedToday && isFood(stack) && canFamiliarize()) {
/*     */       
/* 293 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 295 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 299 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 301 */       this.hunger += 24000;
/* 302 */       this.familiarizedToday = true;
/* 303 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 304 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 311 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAnimalID() {
/* 316 */     return this.animalID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 322 */     return Helper.stringToInt("sheep");
/*     */   }
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 342 */     return TFCItems.wool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 348 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 354 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 360 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 366 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 372 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 378 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 384 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 390 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 395 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 401 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 12.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 407 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 412 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 417 */     return this.sex;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getShearer() {
/* 422 */     return this.shearer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSheepTimer() {
/* 427 */     return this.sheepTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 433 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 439 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 444 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 450 */     int totalDays = TFC_Time.getTotalDays();
/* 451 */     if (this.lastFamiliarityUpdate < totalDays)
/*     */     {
/* 453 */       if (this.familiarizedToday && this.familiarity < 100) {
/*     */         
/* 455 */         this.lastFamiliarityUpdate = totalDays;
/* 456 */         this.familiarizedToday = false;
/* 457 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 458 */         if (isAdult() && this.familiarity <= 35)
/*     */         {
/* 460 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 462 */         else if (!isAdult())
/*     */         {
/* 464 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 465 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 466 */           if (this.familiarity > 70)
/*     */           {
/* 468 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 472 */       } else if (this.familiarity < 30) {
/*     */         
/* 474 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 475 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 478 */     if (this.familiarity > 100)
/* 479 */       this.familiarity = 100; 
/* 480 */     if (this.familiarity < 0) {
/* 481 */       this.familiarity = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 490 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 492 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 494 */         familiarize(player);
/* 495 */         return true;
/*     */       } 
/*     */       
/* 498 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/* 499 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/* 501 */       this.shearer = player;
/*     */ 
/*     */       
/* 504 */       if (player.func_70694_bm() != null && player.func_70694_bm().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife && !func_70892_o() && checkFamiliarity(IAnimal.InteractionEnum.SHEAR, player) && isAdult()) {
/*     */         
/* 506 */         if (!this.familiarizedToday && this.familiarity <= 35) {
/*     */           
/* 508 */           this.familiarizedToday = true;
/* 509 */           func_70671_ap().func_75651_a((Entity)player, 0.0F, 0.0F);
/* 510 */           func_70642_aH();
/*     */         } 
/* 512 */         func_70893_e(true);
/* 513 */         func_70099_a(new ItemStack(TFCItems.wool, 1), 0.0F);
/* 514 */         if (!player.field_71075_bZ.field_75098_d) {
/* 515 */           player.func_70694_bm().func_77972_a(1, (EntityLivingBase)player);
/*     */         }
/*     */       } 
/*     */     } 
/* 519 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*     */     
/* 521 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/* 522 */       !canFamiliarize())) {
/*     */       
/* 524 */       if (!player.field_71075_bZ.field_75098_d)
/*     */       {
/* 526 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       
/* 529 */       this.hunger += 24000;
/* 530 */       func_146082_f(player);
/* 531 */       return true;
/*     */     } 
/* 533 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 534 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 535 */         itemstack.field_77994_a--;
/*     */       }
/* 537 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 541 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 548 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 554 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItemTFC(ItemStack item) {
/* 559 */     return (!this.pregnant && isFood(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 565 */     return !isAdult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 571 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 572 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 578 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 584 */     return (!func_70892_o() && isAdult() && this.shearer != null && checkFamiliarity(IAnimal.InteractionEnum.SHEAR, this.shearer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 590 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 592 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 595 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 596 */     this.pregnant = true;
/* 597 */     func_70875_t();
/* 598 */     otherAnimal.setInLove(false);
/* 599 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 600 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 601 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 602 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/* 603 */     this.mateColor = ((EntitySheepTFC)otherAnimal).func_70896_n();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 613 */     if (this.field_70170_p.field_72995_K) {
/* 614 */       this.sheepTimer = Math.max(0, this.sheepTimer - 1);
/*     */     }
/*     */     
/* 617 */     if (this.hunger > 168000)
/* 618 */       this.hunger = 168000; 
/* 619 */     if (this.hunger > 0) {
/* 620 */       this.hunger--;
/*     */     }
/* 622 */     if (func_70880_s()) {
/*     */       
/* 624 */       func_70875_t();
/* 625 */       setInLove(true);
/*     */     } 
/*     */     
/* 628 */     handleFamiliarityUpdate();
/*     */     
/* 630 */     syncData();
/* 631 */     if (isAdult()) {
/* 632 */       func_70873_a(0);
/*     */     } else {
/* 634 */       func_70873_a(-1);
/*     */     } 
/* 636 */     if (!this.field_70170_p.field_72995_K && isPregnant() && 
/* 637 */       TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */       
/* 639 */       int i = this.field_70146_Z.nextInt(3) + 1;
/* 640 */       for (int x = 0; x < i; x++) {
/*     */         
/* 642 */         EntitySheepTFC baby = (EntitySheepTFC)createChildTFC((EntityAgeable)this);
/* 643 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 644 */         baby.field_70759_as = baby.field_70177_z;
/* 645 */         baby.field_70761_aq = baby.field_70177_z;
/* 646 */         this.field_70170_p.func_72838_d((Entity)baby);
/* 647 */         baby.setAge(TFC_Time.getTotalDays());
/*     */       } 
/* 649 */       this.pregnant = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 655 */     TFC_Core.preventEntityDataUpdate = true;
/* 656 */     super.func_70636_d();
/* 657 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 659 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 661 */       func_70691_i(1.0F);
/*     */     }
/* 663 */     else if (this.hunger < 144000 && func_70880_s()) {
/*     */       
/* 665 */       setInLove(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
/* 672 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 673 */     func_70893_e(true);
/* 674 */     ret.add(new ItemStack(TFCItems.wool, 2));
/* 675 */     if (!this.familiarizedToday && this.familiarity <= 35) {
/*     */       
/* 677 */       this.familiarizedToday = true;
/* 678 */       func_70642_aH();
/*     */     } 
/* 680 */     this.field_70170_p.func_72956_a((Entity)this, "mob.sheep.shear", 1.0F, 1.0F);
/* 681 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 690 */     super.func_70037_a(nbt);
/* 691 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 692 */     this.sex = nbt.func_74762_e("Sex");
/* 693 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 695 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 696 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 697 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 699 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 700 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 701 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 703 */     this.hunger = nbt.func_74762_e("Hunger");
/* 704 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 705 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 706 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 707 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 708 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 709 */     this.mateColor = nbt.func_74762_e("MateColor");
/* 710 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 711 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/* 712 */     setAge(nbt.func_74762_e("Age"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 718 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 724 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimalID(long animalID) {
/* 729 */     this.animalID = animalID;
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
/* 741 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 747 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 752 */     this.familiarizedToday = familiarizedToday;
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
/* 764 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 765 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 771 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 777 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 782 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 788 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 793 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 798 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 803 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShearer(EntityPlayer shearer) {
/* 808 */     this.shearer = shearer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSheepTimer(int sheepTimer) {
/* 813 */     this.sheepTimer = sheepTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 819 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 825 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 830 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 835 */     if (this.field_70180_af != null)
/*     */     {
/* 837 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 839 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */         
/* 841 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */         
/* 844 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 845 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 846 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 847 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 851 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 853 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 854 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 855 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 856 */         byte[] values = buf.array();
/*     */         
/* 858 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 859 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 860 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 861 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 863 */         this.familiarity = values[4];
/* 864 */         this.familiarizedToday = (values[5] == 1);
/* 865 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 869 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 870 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 879 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 881 */       func_94058_c(name);
/* 882 */       return true;
/*     */     } 
/* 884 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 885 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/* 891 */     this.sheepTimer = this.aiEatGrass.getEatGrassTick();
/* 892 */     super.func_70619_bc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 901 */     super.func_70014_b(nbt);
/* 902 */     nbt.func_74768_a("Sex", this.sex);
/* 903 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 904 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 906 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 907 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 908 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 910 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 911 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 912 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 914 */     nbt.func_74768_a("Hunger", this.hunger);
/* 915 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 916 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 917 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 918 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 919 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 920 */     nbt.func_74768_a("MateColor", this.mateColor);
/* 921 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 922 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySheepTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */