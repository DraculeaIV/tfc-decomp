/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
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
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
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
/*     */ public class EntityPolarBear extends EntityTameable implements ICausesDamage, IAnimal, IInnateArmor {
/*     */   private static final float GESTATION_PERIOD = 7.0F;
/*     */   private static final float DIMORPHISM = 0.2182F;
/*  54 */   private final Random rand = new Random();
/*     */   private static final int DEGREE_OF_DIVERSION = 3;
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
/*  70 */   private float aggressionMod = 1.0F;
/*  71 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   
/*     */   private float mouthOpenness;
/*     */   
/*     */   private float prevMouthOpenness;
/*     */   
/*     */   protected EntityAIAttackOnCollide attackAI;
/*     */   protected EntityAILeapAtTarget leapAI;
/*     */   protected EntityAITargetNonTamedTFC targetSheep;
/*     */   protected EntityAITargetNonTamedTFC targetDeer;
/*     */   protected EntityAITargetNonTamedTFC targetPig;
/*     */   protected EntityAITargetNonTamedTFC targetHorse;
/*     */   protected EntityAITargetNonTamedTFC targetPlayer;
/*     */   protected EntityAITargetNonTamedTFC targetBear;
/*     */   protected EntityAITargetNonTamedTFC targetWolf;
/*     */   protected EntityAIHurtByTarget hurtAI;
/*     */   protected boolean isPeacefulAI;
/*     */   private boolean wasRoped;
/*     */   private int familiarity;
/*     */   private long lastFamiliarityUpdate;
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityPolarBear(World par1World) {
/*  96 */     super(par1World);
/*  97 */     func_70105_a(1.5F, 1.5F);
/*  98 */     this.moveSpeed = 0.4F;
/*  99 */     func_70661_as().func_75491_a(false);
/* 100 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/* 101 */     this.sizeMod = (float)Math.sqrt((((this.rand.nextInt(this.rand.nextInt(40) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.2182F * this.sex)));
/*     */     
/* 103 */     this.strengthMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(30) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/* 104 */     this.aggressionMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(30) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/* 105 */     this.obedienceMod = (float)Math.sqrt(((this.rand.nextInt(this.rand.nextInt(30) + 1) * (this.rand.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */     
/* 107 */     this.sex = this.rand.nextInt(2);
/* 108 */     if (getGender() == IAnimal.GenderEnum.MALE)
/* 109 */       this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMate((EntityAnimal)this, this.moveSpeed)); 
/* 110 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityOcelotTFC.class, 32.0F, 1.2D, 1.6D));
/* 111 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, this.moveSpeed));
/* 112 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/* 113 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/* 114 */     this.attackAI = new EntityAIAttackOnCollide((EntityCreature)this, (this.moveSpeed * 1.5F), true);
/* 115 */     this.leapAI = new EntityAILeapAtTarget((EntityLiving)this, 0.4F);
/*     */ 
/*     */     
/* 118 */     this.targetBear = new EntityAITargetNonTamedTFC(this, EntityBear.class, 200, false);
/* 119 */     this.targetWolf = new EntityAITargetNonTamedTFC(this, EntityWolfTFC.class, 200, false);
/* 120 */     this.targetSheep = new EntityAITargetNonTamedTFC(this, EntitySheepTFC.class, 200, false);
/* 121 */     this.targetDeer = new EntityAITargetNonTamedTFC(this, EntityDeer.class, 200, false);
/* 122 */     this.targetPig = new EntityAITargetNonTamedTFC(this, EntityPigTFC.class, 200, false);
/* 123 */     this.targetHorse = new EntityAITargetNonTamedTFC(this, EntityHorseTFC.class, 200, false);
/* 124 */     this.targetPlayer = new EntityAITargetNonTamedTFC(this, EntityPlayer.class, 20, true);
/* 125 */     this.hurtAI = new EntityAIHurtByTarget((EntityCreature)this, true);
/*     */     
/* 127 */     if (par1World.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */       
/* 129 */       this.isPeacefulAI = false;
/* 130 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 131 */       this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 132 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetBear);
/* 133 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetWolf);
/* 134 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 135 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 136 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 137 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 138 */       this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 139 */       this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
/*     */     }
/*     */     else {
/*     */       
/* 143 */       this.isPeacefulAI = true;
/*     */     } 
/*     */     
/* 146 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 7.0F * (float)TFC_Time.ticksInMonth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPolarBear(World par1World, IAnimal mother, List<Float> data) {
/* 158 */     this(par1World);
/* 159 */     float fatherSize = 1.0F;
/* 160 */     float fatherStr = 1.0F;
/* 161 */     float fatherAggro = 1.0F;
/* 162 */     float fatherObed = 1.0F;
/* 163 */     for (int i = 0; i < data.size(); i++) {
/* 164 */       switch (i) { case 0:
/* 165 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/* 166 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/* 167 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/* 168 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*     */           break; }
/*     */     
/*     */     } 
/* 172 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/* 173 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/* 174 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/* 175 */     float invSizeRatio = 0.5612302F;
/* 176 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/* 177 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/* 178 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/* 179 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*     */     
/* 181 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*     */ 
/*     */     
/* 184 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 191 */     super.func_110147_ax();
/* 192 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity par1Entity) {
/* 198 */     int dam = (int)(225.0F * getStrengthMod() * getAggressionMod() * (getSizeMod() / 2.0F + 0.5F));
/* 199 */     return par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), dam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 208 */     return (!this.wasRoped && this.field_70173_aa > 30000);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 215 */     return (!isAdult() || (isAdult() && this.familiarity <= 80));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70878_b(EntityAnimal par1EntityAnimal) {
/* 221 */     if (par1EntityAnimal == this)
/* 222 */       return false; 
/* 223 */     if (!(par1EntityAnimal instanceof EntityPolarBear))
/* 224 */       return false; 
/* 225 */     EntityPolarBear entitybear = (EntityPolarBear)par1EntityAnimal;
/* 226 */     return (getInLove() && entitybear.getInLove());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 232 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityPolarBear);
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
/* 244 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 250 */     boolean flag = false;
/* 251 */     switch (interaction) { case MOUNT:
/* 252 */         flag = (this.familiarity > 15); break;
/* 253 */       case BREED: flag = (this.familiarity > 20); break;
/* 254 */       case NAME: flag = (this.familiarity > 70); break;
/* 255 */       case TOLERATEPLAYER: flag = (this.familiarity > 75);
/*     */         break; }
/*     */     
/* 258 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 259 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 261 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable func_90011_a(EntityAgeable entityageable) {
/* 267 */     return createChildTFC(entityageable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/* 273 */     ArrayList<Float> data = new ArrayList<Float>();
/* 274 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/* 275 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/* 276 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/* 277 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/* 278 */     return (EntityAgeable)new EntityPolarBear(this.field_70170_p, this, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 284 */     Item itemCBRecord = GameRegistry.findItem("technodefirmacraft", "record_CigBeer");
/* 285 */     ItemStack cbRecordItemStack = new ItemStack(itemCBRecord, 1);
/* 286 */     float ageMod = TFC_Core.getPercentGrown(this);
/* 287 */     if (this.rand.nextInt(10) == 0) {
/* 288 */       func_70099_a(cbRecordItemStack, 0.0F);
/*     */     }
/* 290 */     func_70099_a(new ItemStack(TFCItems.pbearSkin, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/* 291 */     func_145779_a(Items.field_151103_aS, (int)((this.rand.nextInt(6) + 2) * ageMod));
/* 292 */     float foodWeight = ageMod * this.sizeMod * 1500.0F;
/* 293 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.bearRaw, foodWeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 299 */     super.func_70088_a();
/* 300 */     this.field_70180_af.func_75682_a(18, Float.valueOf(func_110143_aJ()));
/* 301 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 302 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/* 303 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 304 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/* 305 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 310 */     ItemStack stack = ep.func_70694_bm();
/* 311 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 313 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 315 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 319 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 321 */       this.hunger += 24000;
/* 322 */       this.familiarizedToday = true;
/* 323 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 324 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 331 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 338 */     return Helper.stringToInt("pbear");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 344 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 350 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/* 356 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 362 */     return EnumDamageType.SLASHING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 371 */     if (!func_70631_g_()) {
/* 372 */       return "terrafirmacraft:mob.polarbear.death";
/*     */     }
/* 374 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 384 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 390 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 396 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 402 */     return this.field_70131_O * 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 407 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 413 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 419 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 425 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 431 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 440 */     if (!func_70631_g_()) {
/* 441 */       return "terrafirmacraft:mob.polarbear.hurt";
/*     */     }
/* 443 */     return "terrafirmacraft:mob.bear.cub.cry";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 449 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 454 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 463 */     if (isAdult() && this.field_70170_p.field_73012_v.nextInt(100) < 5)
/* 464 */       return "terrafirmacraft:mob.polarbear.cry"; 
/* 465 */     if (func_70631_g_() && this.field_70170_p.field_73012_v.nextInt(100) < 5) {
/* 466 */       return "terrafirmacraft:mob.bear.cub.cry";
/*     */     }
/* 468 */     return func_70631_g_() ? null : "terrafirmacraft:mob.polarbear.say";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70641_bl() {
/* 477 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMoveSpeed() {
/* 482 */     return this.moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 488 */     return TFC_Time.daysInMonth * 60;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 494 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPierceArmor() {
/* 500 */     return -335;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPregnancyRequiredTime() {
/* 505 */     return this.pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 510 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 516 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlashArmor() {
/* 522 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 531 */     return 0.4F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 537 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeOfConception() {
/* 542 */     return this.timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 547 */     int totalDays = TFC_Time.getTotalDays();
/* 548 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 549 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 550 */         this.lastFamiliarityUpdate = totalDays;
/* 551 */         this.familiarizedToday = false;
/* 552 */         float familiarityChange = 3.0F * this.obedienceMod / this.aggressionMod;
/* 553 */         if (isAdult() && this.familiarity <= 80) {
/*     */           
/* 555 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 557 */         else if (!isAdult()) {
/* 558 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 559 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 560 */           if (this.familiarity > 70) {
/* 561 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 565 */       } else if (this.familiarity < 30) {
/* 566 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 567 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 570 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 571 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70103_a(byte par1) {
/* 577 */     if (par1 == 8) {
/*     */       
/* 579 */       this.isWet = true;
/*     */     }
/*     */     else {
/*     */       
/* 583 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 590 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 592 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 594 */         familiarize(player);
/* 595 */         return true;
/*     */       } 
/* 597 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/* 598 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant)
/*     */       {
/* 600 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*     */       }
/*     */     } 
/* 603 */     ItemStack itemstack = player.func_70694_bm();
/* 604 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*     */       
/* 606 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player))
/*     */       {
/* 608 */         itemstack.field_77994_a--;
/*     */       }
/* 610 */       return true;
/*     */     } 
/* 612 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 618 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 627 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 633 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 638 */     return (item != null && item.func_77973_b().equals(TFCItems.fishRaw));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 644 */     return this.pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWasRoped() {
/* 649 */     return this.wasRoped;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {
/* 655 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/* 657 */       otherAnimal.mate(this);
/*     */       return;
/*     */     } 
/* 660 */     this.timeOfConception = TFC_Time.getTotalTicks();
/* 661 */     this.pregnant = true;
/* 662 */     func_70875_t();
/* 663 */     otherAnimal.setInLove(false);
/* 664 */     this.mateSizeMod = otherAnimal.getSizeMod();
/* 665 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/* 666 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/* 667 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 677 */     TFC_Core.preventEntityDataUpdate = true;
/* 678 */     super.func_70636_d();
/* 679 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 681 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 683 */       if (!this.isWet && !func_70781_l() && this.field_70122_E) {
/*     */         
/* 685 */         this.isWet = true;
/* 686 */         this.field_70170_p.func_72960_a((Entity)this, (byte)8);
/*     */       } 
/*     */       
/* 689 */       if (isPregnant())
/*     */       {
/* 691 */         if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*     */           
/* 693 */           int i = this.rand.nextInt(3) + 1;
/* 694 */           for (int x = 0; x < i; x++) {
/*     */             
/* 696 */             EntityPolarBear baby = (EntityPolarBear)createChildTFC((EntityAgeable)this);
/* 697 */             this.field_70170_p.func_72838_d((Entity)baby);
/*     */           } 
/* 699 */           this.pregnant = false;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 704 */     if (func_110167_bD() && !this.wasRoped) {
/* 705 */       this.wasRoped = true;
/*     */     }
/* 707 */     handleFamiliarityUpdate();
/* 708 */     syncData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 717 */     super.func_70071_h_();
/* 718 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 720 */       if (!this.isPeacefulAI && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
/*     */         
/* 722 */         this.isPeacefulAI = true;
/* 723 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.attackAI);
/* 724 */         this.field_70714_bg.func_85156_a((EntityAIBase)this.leapAI);
/* 725 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetSheep);
/* 726 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetDeer);
/* 727 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPig);
/* 728 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetHorse);
/* 729 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPlayer);
/* 730 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.hurtAI);
/*     */       }
/* 732 */       else if (this.isPeacefulAI && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*     */         
/* 734 */         this.isPeacefulAI = false;
/* 735 */         this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.attackAI);
/* 736 */         this.field_70714_bg.func_75776_a(3, (EntityAIBase)this.leapAI);
/* 737 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetSheep);
/* 738 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetDeer);
/* 739 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPig);
/* 740 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetHorse);
/* 741 */         this.field_70715_bh.func_75776_a(4, (EntityAIBase)this.targetPlayer);
/* 742 */         this.field_70715_bh.func_75776_a(3, (EntityAIBase)this.hurtAI);
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
/* 753 */     super.func_70037_a(nbt);
/* 754 */     this.sex = nbt.func_74762_e("Sex");
/* 755 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 757 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 758 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 759 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 761 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 762 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 763 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 765 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */     
/* 767 */     this.hunger = nbt.func_74762_e("Hunger");
/* 768 */     this.pregnant = nbt.func_74767_n("Pregnant");
/* 769 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/* 770 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/* 771 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/* 772 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/* 773 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/* 774 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 781 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggression) {
/* 787 */     this.aggressionMod = aggression;
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
/* 798 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int f) {
/* 804 */     this.familiarity = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 809 */     this.familiarizedToday = familiarizedToday;
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
/* 820 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 821 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 827 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 833 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 838 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMoveSpeed(float moveSpeed) {
/* 843 */     this.moveSpeed = moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedience) {
/* 849 */     this.obedienceMod = obedience;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 854 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPregnant(boolean pregnant) {
/* 859 */     this.pregnant = pregnant;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 864 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float size) {
/* 870 */     this.sizeMod = size;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strength) {
/* 876 */     this.strengthMod = strength;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTimeOfConception(long timeOfConception) {
/* 881 */     this.timeOfConception = timeOfConception;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWasRoped(boolean wasRoped) {
/* 886 */     this.wasRoped = wasRoped;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 891 */     if (this.field_70180_af != null)
/*     */     {
/* 893 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 895 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 901 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 907 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 908 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 909 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/* 910 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*     */       }
/*     */       else {
/*     */         
/* 914 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 916 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 917 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 918 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 919 */         byte[] values = buf.array();
/*     */         
/* 921 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 922 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 923 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 924 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 926 */         this.familiarity = values[4];
/* 927 */         this.familiarizedToday = (values[5] == 1);
/* 928 */         this.pregnant = (values[6] == 1);
/*     */ 
/*     */         
/*     */         try {
/* 932 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/* 933 */         } catch (NumberFormatException numberFormatException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 940 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 942 */       func_94058_c(name);
/* 943 */       return true;
/*     */     } 
/* 945 */     func_85030_a(func_70631_g_() ? "terrafirmacraft:mob.bear.cub.cry" : "terrafirmacraft:mob.bear.cry", 6.0F, this.rand.nextFloat() / 2.0F + 0.75F);
/* 946 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70629_bd() {
/* 955 */     this.field_70180_af.func_75692_b(18, Float.valueOf(func_110143_aJ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 964 */     super.func_70014_b(nbt);
/* 965 */     nbt.func_74768_a("Sex", this.sex);
/* 966 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 968 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 969 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 970 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 972 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 973 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 974 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 976 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */     
/* 978 */     nbt.func_74768_a("Hunger", this.hunger);
/* 979 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 980 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 981 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 982 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 983 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 984 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 985 */     nbt.func_74768_a("Age", getBirthDay());
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRearingAmount(float p_78086_4_) {
/* 990 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float adjustMouth(float p_110201_1_) {
/* 996 */     return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * p_110201_1_;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityPolarBear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */