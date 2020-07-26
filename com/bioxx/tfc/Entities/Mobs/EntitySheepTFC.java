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
/* 106 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityPolarBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/* 107 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*     */     
/* 109 */     this.colorCrafting.func_70299_a(0, new ItemStack(Items.field_151100_aR, 1, 0));
/* 110 */     this.colorCrafting.func_70299_a(1, new ItemStack(Items.field_151100_aR, 1, 0));
/*     */     
/* 112 */     this.hunger = 168000;
/* 113 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/* 114 */     this.pregnant = false;
/* 115 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 5.0F * (float)TFC_Time.ticksInMonth);
/* 116 */     this.timeOfConception = 0L;
/* 117 */     this.mateSizeMod = 0.0F;
/* 118 */     this.sex = this.field_70146_Z.nextInt(2);
/* 119 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.1633F * this.sex)));
/* 120 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/* 121 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/* 122 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntitySheepTFC(World par1World, IAnimal mother, List<Float> data) {
/* 135 */     this(par1World);
/* 136 */     float fatherSize = 1.0F;
/* 137 */     float fatherStr = 1.0F;
/* 138 */     float fatherAggro = 1.0F;
/* 139 */     float fatherObed = 1.0F;
/* 140 */     for (int i = 0; i < data.size(); i++) {
/* 141 */       switch (i) { case 0:
/* 142 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 143 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 144 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 145 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 149 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 150 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 151 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*     */     
/* 153 */     float invSizeRatio = 0.54445475F;
/* 154 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 155 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 156 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 157 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 159 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 162 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 168 */     super.func_110147_ax();
/* 169 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 175 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 181 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntitySheepTFC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 188 */     boolean flag = false;
/* 189 */     switch (interaction) {
/*     */       
/*     */       case BREED:
/* 192 */         flag = (this.familiarity > 20);
/*     */         break;
/*     */       case SHEAR:
/* 195 */         flag = (this.familiarity > 10);
/*     */         break;
/*     */       case NAME:
/* 198 */         flag = (this.familiarity > 40);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 203 */     if (!flag && player != null && !player.field_70170_p.field_72995_K)
/*     */     {
/* 205 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 207 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public int combineColors(EntityAnimal parent, int mateColor) {
/* 212 */     int babyColor, parent1Color = 15 - ((EntitySheep)parent).func_70896_n();
/* 213 */     int parent2Color = 15 - mateColor;
/* 214 */     this.colorCrafting.func_70301_a(0).func_77964_b(parent1Color);
/* 215 */     this.colorCrafting.func_70301_a(1).func_77964_b(parent2Color);
/* 216 */     ItemStack itemstack = CraftingManager.func_77594_a().func_82787_a(this.colorCrafting, ((EntitySheep)parent).field_70170_p);
/*     */ 
/*     */     
/* 219 */     if (itemstack != null && itemstack.func_77973_b() == Items.field_151100_aR) {
/*     */       
/* 221 */       babyColor = itemstack.func_77960_j();
/*     */     }
/*     */     else {
/*     */       
/* 225 */       babyColor = this.field_70170_p.field_73012_v.nextBoolean() ? parent1Color : parent2Color;
/*     */     } 
/*     */     
/* 228 */     return babyColor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntitySheep func_90011_a(EntityAgeable entityageable) {
/* 234 */     return (EntitySheep)createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 240 */     ArrayList<Float> data = new ArrayList<Float>();
/* 241 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 242 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 243 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 244 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 245 */     EntitySheepTFC baby = new EntitySheepTFC(this.field_70170_p, this, data);
/* 246 */     int colorMeta = combineColors((EntityAnimal)this, ((EntitySheepTFC)eAgeable).mateColor);
/* 247 */     baby.func_70891_b(15 - colorMeta);
/* 248 */     return (EntityAgeable)baby;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 257 */     float ageMod = TFC_Core.getPercentGrown(this);
/*     */     
/* 259 */     if (!func_70892_o()) {
/* 260 */       func_70099_a(new ItemStack(TFCItems.sheepSkin, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/*     */     } else {
/* 262 */       func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * this.sizeMod)))), 0.0F);
/*     */     } 
/* 264 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(5) + 2) * ageMod));
/*     */     
/* 266 */     float foodWeight = ageMod * this.sizeMod * 640.0F;
/* 267 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.muttonRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70615_aA() {
/* 273 */     func_70893_e(false);
/* 274 */     this.hunger += 24000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 280 */     super.func_70088_a();
/* 281 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 282 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 284 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 285 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 286 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 291 */     ItemStack stack = ep.func_70694_bm();
/* 292 */     if (stack != null && !this.familiarizedToday && isFood(stack) && canFamiliarize()) {
/*     */       
/* 294 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 296 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 300 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 302 */       this.hunger += 24000;
/* 303 */       this.familiarizedToday = true;
/* 304 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 305 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 312 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAnimalID() {
/* 317 */     return this.animalID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 323 */     return Helper.stringToInt("sheep");
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 334 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 343 */     return TFCItems.wool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 349 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 355 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 361 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 367 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 373 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 379 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 385 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 391 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 396 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 402 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 12.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 408 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 413 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 418 */     return this.sex;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getShearer() {
/* 423 */     return this.shearer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSheepTimer() {
/* 428 */     return this.sheepTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 434 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 440 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 445 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 451 */     int totalDays = TFC_Time.getTotalDays();
/* 452 */     if (this.lastFamiliarityUpdate < totalDays)
/*     */     {
/* 454 */       if (this.familiarizedToday && this.familiarity < 100) {
/*     */         
/* 456 */         this.lastFamiliarityUpdate = totalDays;
/* 457 */         this.familiarizedToday = false;
/* 458 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 459 */         if (isAdult() && this.familiarity <= 35)
/*     */         {
/* 461 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 463 */         else if (!isAdult())
/*     */         {
/* 465 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 466 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 467 */           if (this.familiarity > 70)
/*     */           {
/* 469 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 473 */       } else if (this.familiarity < 30) {
/*     */         
/* 475 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 476 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 479 */     if (this.familiarity > 100)
/* 480 */       this.familiarity = 100; 
/* 481 */     if (this.familiarity < 0) {
/* 482 */       this.familiarity = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 491 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 493 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 495 */         familiarize(player);
/* 496 */         return true;
/*     */       } 
/*     */       
/* 499 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/* 500 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/* 502 */       this.shearer = player;
/*     */ 
/*     */       
/* 505 */       if (player.func_70694_bm() != null && player.func_70694_bm().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemKnife && !func_70892_o() && checkFamiliarity(IAnimal.InteractionEnum.SHEAR, player) && isAdult()) {
/*     */         
/* 507 */         if (!this.familiarizedToday && this.familiarity <= 35) {
/*     */           
/* 509 */           this.familiarizedToday = true;
/* 510 */           func_70671_ap().func_75651_a((Entity)player, 0.0F, 0.0F);
/* 511 */           func_70642_aH();
/*     */         } 
/* 513 */         func_70893_e(true);
/* 514 */         func_70099_a(new ItemStack(TFCItems.wool, 1), 0.0F);
/* 515 */         if (!player.field_71075_bZ.field_75098_d) {
/* 516 */           player.func_70694_bm().func_77972_a(1, (EntityLivingBase)player);
/*     */         }
/*     */       } 
/*     */     } 
/* 520 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*     */     
/* 522 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/* 523 */       !canFamiliarize())) {
/*     */       
/* 525 */       if (!player.field_71075_bZ.field_75098_d)
/*     */       {
/* 527 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       
/* 530 */       this.hunger += 24000;
/* 531 */       func_146082_f(player);
/* 532 */       return true;
/*     */     } 
/* 534 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 535 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 536 */         itemstack.field_77994_a--;
/*     */       }
/* 538 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 542 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 549 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 555 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBreedingItemTFC(ItemStack item) {
/* 560 */     return (!this.pregnant && isFood(item));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 566 */     return !isAdult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 572 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 573 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 579 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 585 */     return (!func_70892_o() && isAdult() && this.shearer != null && checkFamiliarity(IAnimal.InteractionEnum.SHEAR, this.shearer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 591 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 593 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 596 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 597 */     this.pregnant = true;
/* 598 */     func_70875_t();
/* 599 */     otherAnimal.setInLove(false);
/* 600 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 601 */     this.mateObedMod = otherAnimal.getObedienceMod();
/* 602 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 603 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/* 604 */     this.mateColor = ((EntitySheepTFC)otherAnimal).func_70896_n();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 614 */     if (this.field_70170_p.field_72995_K) {
/* 615 */       this.sheepTimer = Math.max(0, this.sheepTimer - 1);
/*     */     }
/*     */     
/* 618 */     if (this.hunger > 168000)
/* 619 */       this.hunger = 168000; 
/* 620 */     if (this.hunger > 0) {
/* 621 */       this.hunger--;
/*     */     }
/* 623 */     if (func_70880_s()) {
/*     */       
/* 625 */       func_70875_t();
/* 626 */       setInLove(true);
/*     */     } 
/*     */     
/* 629 */     handleFamiliarityUpdate();
/*     */     
/* 631 */     syncData();
/* 632 */     if (isAdult()) {
/* 633 */       func_70873_a(0);
/*     */     } else {
/* 635 */       func_70873_a(-1);
/*     */     } 
/* 637 */     if (!this.field_70170_p.field_72995_K && isPregnant() && 
/* 638 */       TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */       
/* 640 */       int i = this.field_70146_Z.nextInt(3) + 1;
/* 641 */       for (int x = 0; x < i; x++) {
/*     */         
/* 643 */         EntitySheepTFC baby = (EntitySheepTFC)createChildTFC((EntityAgeable)this);
/* 644 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 645 */         baby.field_70759_as = baby.field_70177_z;
/* 646 */         baby.field_70761_aq = baby.field_70177_z;
/* 647 */         this.field_70170_p.func_72838_d((Entity)baby);
/* 648 */         baby.setAge(TFC_Time.getTotalDays());
/*     */       } 
/* 650 */       this.pregnant = false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 656 */     TFC_Core.preventEntityDataUpdate = true;
/* 657 */     super.func_70636_d();
/* 658 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 660 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 662 */       func_70691_i(1.0F);
/*     */     }
/* 664 */     else if (this.hunger < 144000 && func_70880_s()) {
/*     */       
/* 666 */       setInLove(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
/* 673 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 674 */     func_70893_e(true);
/* 675 */     ret.add(new ItemStack(TFCItems.wool, 2));
/* 676 */     if (!this.familiarizedToday && this.familiarity <= 35) {
/*     */       
/* 678 */       this.familiarizedToday = true;
/* 679 */       func_70642_aH();
/*     */     } 
/* 681 */     this.field_70170_p.func_72956_a((Entity)this, "mob.sheep.shear", 1.0F, 1.0F);
/* 682 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 691 */     super.func_70037_a(nbt);
/* 692 */     this.animalID = nbt.func_74763_f("Animal ID");
/* 693 */     this.sex = nbt.func_74762_e("Sex");
/* 694 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 696 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 697 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 698 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 700 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 701 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 702 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 704 */     this.hunger = nbt.func_74762_e("Hunger");
/* 705 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 706 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 707 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 708 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 709 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 710 */     this.mateColor = nbt.func_74762_e("MateColor");
/* 711 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 712 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/* 713 */     setAge(nbt.func_74762_e("Age"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 719 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 725 */     this.aggressionMod = aggressionMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimalID(long animalID) {
/* 730 */     this.animalID = animalID;
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
/* 742 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 748 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 753 */     this.familiarizedToday = familiarizedToday;
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
/* 765 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 766 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 772 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 778 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 783 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 789 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 794 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 799 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 804 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShearer(EntityPlayer shearer) {
/* 809 */     this.shearer = shearer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSheepTimer(int sheepTimer) {
/* 814 */     this.sheepTimer = sheepTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 820 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 826 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 831 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 836 */     if (this.field_70180_af != null)
/*     */     {
/* 838 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 840 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */         
/* 842 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */         
/* 845 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 846 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 847 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 848 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 852 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 854 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 855 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 856 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 857 */         byte[] values = buf.array();
/*     */         
/* 859 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 860 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 861 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 862 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 864 */         this.familiarity = values[4];
/* 865 */         this.familiarizedToday = (values[5] == 1);
/* 866 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 870 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 871 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 880 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 882 */       func_94058_c(name);
/* 883 */       return true;
/*     */     } 
/* 885 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 886 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/* 892 */     this.sheepTimer = this.aiEatGrass.getEatGrassTick();
/* 893 */     super.func_70619_bc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 902 */     super.func_70014_b(nbt);
/* 903 */     nbt.func_74768_a("Sex", this.sex);
/* 904 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 905 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 907 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 908 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 909 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 911 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 912 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 913 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 915 */     nbt.func_74768_a("Hunger", this.hunger);
/* 916 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 917 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 918 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 919 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 920 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 921 */     nbt.func_74768_a("MateColor", this.mateColor);
/* 922 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 923 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySheepTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */