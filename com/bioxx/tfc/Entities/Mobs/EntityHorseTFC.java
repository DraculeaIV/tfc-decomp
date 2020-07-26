/*      */ package com.bioxx.tfc.Entities.Mobs;
/*      */ import com.bioxx.tfc.Core.TFC_Core;
/*      */ import com.bioxx.tfc.Core.TFC_Time;
/*      */ import com.bioxx.tfc.Entities.AI.AIEatGrass;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIPanicTFC;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.api.Entities.IAnimal;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import com.bioxx.tfc.api.TFCOptions;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IEntityLivingData;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.attributes.IAttribute;
/*      */ import net.minecraft.entity.ai.attributes.RangedAttribute;
/*      */ import net.minecraft.entity.passive.EntityAnimal;
/*      */ import net.minecraft.entity.passive.EntityHorse;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.inventory.AnimalChest;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.server.S1BPacketEntityAttach;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class EntityHorseTFC extends EntityHorse implements IInvBasic, IAnimal {
/*   47 */   private static final IEntitySelector HORSE_BREEDING_SELECTOR = new EntityHorseBredSelector();
/*   48 */   private static final IAttribute HORSE_JUMP_STRENGTH = (IAttribute)(new RangedAttribute("horse.jumpStrengthTFC", 0.7D, 0.0D, 2.0D)).func_111117_a("Jump StrengthTFC").func_111112_a(true);
/*      */   
/*      */   private static final float GESTATION_PERIOD = 11.17F;
/*      */   
/*      */   private static final float DIMORPHISM = 0.0813F;
/*      */   
/*      */   private static final int DEGREE_OF_DIVERSION = 2;
/*      */   
/*      */   private static final int FAMILIARITY_CAP = 35;
/*      */   
/*   58 */   protected final AIEatGrass aiEatGrass = new AIEatGrass(this);
/*      */   
/*      */   private long animalID;
/*      */   private int sex;
/*      */   private int hunger;
/*      */   private boolean pregnant;
/*      */   private int pregnancyRequiredTime;
/*      */   private long timeOfConception;
/*      */   private float sizeMod;
/*      */   private float strengthMod;
/*   68 */   private float aggressionMod = 1.0F;
/*   69 */   private float obedienceMod = 1.0F;
/*      */   
/*      */   private float mateSizeMod;
/*      */   private float mateStrengthMod;
/*      */   private float mateAggroMod;
/*      */   private float mateObedMod;
/*      */   private int mateType;
/*      */   private int mateVariant;
/*   77 */   private double mateMaxHealth = calcMaxHealth();
/*   78 */   private double mateJumpStrength = calcJumpStrength();
/*   79 */   private double mateMoveSpeed = calcMoveSpeed();
/*      */   
/*      */   private boolean inLove;
/*      */   
/*      */   private Vec3 attackedVec;
/*      */   private Entity fearSource;
/*      */   private int familiarity;
/*      */   private long lastFamiliarityUpdate;
/*      */   private boolean familiarizedToday;
/*      */   
/*      */   public EntityHorseTFC(World par1World) {
/*   90 */     super(par1World);
/*   91 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*   92 */     this.hunger = 168000;
/*   93 */     this.pregnant = false;
/*   94 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 11.17F * (float)TFC_Time.ticksInMonth);
/*   95 */     this.timeOfConception = 0L;
/*   96 */     this.sex = this.field_70146_Z.nextInt(2);
/*   97 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.0813F * this.sex)));
/*   98 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*   99 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  100 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*  101 */     func_70105_a(1.4F, 1.6F);
/*  102 */     func_70661_as().func_75491_a(true);
/*  103 */     this.field_70714_bg.field_75782_a.clear();
/*  104 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  105 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIRunAroundLikeCrazy(this, 1.2D));
/*  106 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.0D));
/*  107 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.7D));
/*  108 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  109 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  110 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  111 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/*  112 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  113 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityPolarBear.class, 16.0F, 0.25D, 0.30000001192092896D));
/*  114 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/*  115 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/*  116 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/*  117 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/*  118 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/*  119 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/*  120 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*  121 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanicTFC((EntityCreature)this, 1.2D, true));
/*  122 */     updateChestSaddle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  128 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityHorseTFC(World par1World, IAnimal mother, List<Float> data, int type, int variant) {
/*  135 */     this(par1World);
/*  136 */     float fatherSize = 1.0F;
/*  137 */     float fatherStr = 1.0F;
/*  138 */     float fatherAggro = 1.0F;
/*  139 */     float fatherObed = 1.0F;
/*  140 */     for (int i = 0; i < data.size(); i++) {
/*  141 */       switch (i) { case 0:
/*  142 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/*  143 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/*  144 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/*  145 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*      */           break; }
/*      */     
/*      */     } 
/*  149 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/*  150 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/*  151 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*  152 */     float invSizeRatio = 0.52118623F;
/*  153 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/*  154 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/*  155 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/*  156 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*      */     
/*  158 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*      */ 
/*      */     
/*  161 */     setAge(TFC_Time.getTotalDays());
/*  162 */     func_110214_p(type);
/*  163 */     func_110235_q(variant);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_110147_ax() {
/*  169 */     super.func_110147_ax();
/*  170 */     func_110140_aT().func_111150_b(HORSE_JUMP_STRENGTH);
/*  171 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((1250.0F * this.sizeMod * this.strengthMod));
/*  172 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22499999403953552D * this.strengthMod * this.obedienceMod / (this.sizeMod * this.sizeMod));
/*  173 */     func_70606_j(func_110138_aP());
/*      */   }
/*      */ 
/*      */   
/*      */   private double calcJumpStrength() {
/*  178 */     return 0.4000000059604645D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D;
/*      */   }
/*      */ 
/*      */   
/*      */   private float calcMaxHealth() {
/*  183 */     return 1000.0F + this.field_70146_Z.nextInt(101) + this.field_70146_Z.nextInt(151);
/*      */   }
/*      */ 
/*      */   
/*      */   private double calcMoveSpeed() {
/*  188 */     return (0.44999998807907104D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D) * 0.25D;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canFamiliarize() {
/*  194 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70878_b(EntityAnimal animal) {
/*  203 */     if (animal == this)
/*      */     {
/*  205 */       return false;
/*      */     }
/*  207 */     if (animal.getClass() != getClass())
/*      */     {
/*  209 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  213 */     EntityHorseTFC entityhorse = (EntityHorseTFC)animal;
/*      */     
/*  215 */     if (getBreedable() && entityhorse.getBreedable()) {
/*      */       
/*  217 */       int i = func_110265_bP();
/*  218 */       int j = entityhorse.func_110265_bP();
/*  219 */       return (i == j || (i == 0 && j == 1) || (i == 1 && j == 0));
/*      */     } 
/*      */ 
/*      */     
/*  223 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canMateWith(IAnimal animal) {
/*  231 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityHorseTFC);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/*  237 */     boolean flag = false;
/*  238 */     switch (interaction) { case MOUNT:
/*  239 */         flag = (this.familiarity > 15); break;
/*  240 */       case BREED: flag = (this.familiarity > 20); break;
/*  241 */       case NAME: flag = (this.familiarity > 40);
/*      */         break; }
/*      */     
/*  244 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/*  245 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*      */     }
/*  247 */     return flag;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110160_i(boolean par1, boolean par2) {
/*  253 */     Entity entity = func_110166_bE();
/*  254 */     if (entity instanceof EntityPlayer) {
/*      */ 
/*      */       
/*  257 */       if (entity.func_70093_af()) {
/*  258 */         super.func_110160_i(par1, true);
/*      */       }
/*      */     } else {
/*      */       
/*  262 */       super.func_110160_i(par1, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable func_90011_a(EntityAgeable eAgeable) {
/*  269 */     return createChildTFC(eAgeable);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/*  275 */     ArrayList<Float> data = new ArrayList<Float>();
/*  276 */     data.add(Float.valueOf(this.mateSizeMod));
/*  277 */     data.add(Float.valueOf(this.mateStrengthMod));
/*  278 */     data.add(Float.valueOf(this.mateAggroMod));
/*  279 */     data.add(Float.valueOf(this.mateObedMod));
/*      */     
/*  281 */     int momType = func_110265_bP();
/*  282 */     int dadType = this.mateType;
/*  283 */     int babyType = 0;
/*  284 */     int babyVariant = 0;
/*      */     
/*  286 */     if (momType == dadType) {
/*      */       
/*  288 */       babyType = momType;
/*      */     }
/*  290 */     else if ((momType == 0 && dadType == 1) || (momType == 1 && dadType == 0)) {
/*      */       
/*  292 */       babyType = 2;
/*      */     } 
/*      */     
/*  295 */     if (babyType == 0) {
/*      */       
/*  297 */       int l = this.field_70146_Z.nextInt(9);
/*      */       
/*  299 */       if (l < 4) {
/*      */         
/*  301 */         babyVariant = func_110202_bQ() & 0xFF;
/*      */       }
/*  303 */       else if (l < 8) {
/*      */         
/*  305 */         babyVariant = this.mateVariant & 0xFF;
/*      */       }
/*      */       else {
/*      */         
/*  309 */         babyVariant = this.field_70146_Z.nextInt(7);
/*      */       } 
/*      */       
/*  312 */       int j1 = this.field_70146_Z.nextInt(5);
/*      */       
/*  314 */       if (j1 < 4) {
/*      */         
/*  316 */         babyVariant |= func_110202_bQ() & 0xFF00;
/*      */       }
/*  318 */       else if (j1 < 8) {
/*      */         
/*  320 */         babyVariant |= this.mateVariant & 0xFF00;
/*      */       }
/*      */       else {
/*      */         
/*  324 */         babyVariant |= this.field_70146_Z.nextInt(5) << 8 & 0xFF00;
/*      */       } 
/*      */     } 
/*      */     
/*  328 */     EntityHorseTFC baby = new EntityHorseTFC(this.field_70170_p, this, data, babyType, babyVariant);
/*      */ 
/*      */     
/*  331 */     double healthSum = func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + this.mateMaxHealth + calcMaxHealth();
/*  332 */     baby.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(healthSum / 3.0D);
/*      */ 
/*      */     
/*  335 */     double jumpSum = func_110148_a(HORSE_JUMP_STRENGTH).func_111125_b() + this.mateJumpStrength + calcJumpStrength();
/*  336 */     baby.func_110148_a(HORSE_JUMP_STRENGTH).func_111128_a(jumpSum / 3.0D);
/*      */ 
/*      */     
/*  339 */     double speedSum = func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + this.mateMoveSpeed + calcMoveSpeed();
/*  340 */     baby.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(speedSum / 3.0D);
/*      */     
/*  342 */     baby.func_70606_j((float)baby.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
/*  343 */     return (EntityAgeable)baby;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110224_ci() {
/*  349 */     if (!this.field_70170_p.field_72995_K && func_110261_ca())
/*      */     {
/*  351 */       func_110207_m(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70628_a(boolean par1, int par2) {
/*  358 */     float ageMod = TFC_Core.getPercentGrown(this);
/*      */     
/*  360 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/*  361 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(8) + 3) * ageMod));
/*  362 */     if (func_110167_bD()) {
/*  363 */       func_70099_a(new ItemStack(TFCItems.rope), 0.0F);
/*      */     }
/*      */     
/*  366 */     float foodWeight = ageMod * this.sizeMod * 4000.0F;
/*      */     
/*  368 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.horseMeatRaw, foodWeight);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  374 */     super.func_70088_a();
/*  375 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/*  376 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*      */     
/*  378 */     this.field_70180_af.func_75682_a(26, Integer.valueOf(0));
/*  379 */     this.field_70180_af.func_75682_a(24, Integer.valueOf(0));
/*  380 */     this.field_70180_af.func_75682_a(25, String.valueOf("0"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void familiarize(EntityPlayer ep) {
/*  386 */     ItemStack stack = ep.func_70694_bm();
/*  387 */     if ((this.field_70153_n == null || !this.field_70153_n.equals(ep)) && !this.familiarizedToday && stack != null && isFood(stack) && canFamiliarize()) {
/*      */       
/*  389 */       if (!ep.field_71075_bZ.field_75098_d) {
/*      */         
/*  391 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*      */       }
/*      */       else {
/*      */         
/*  395 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */       } 
/*  397 */       this.hunger += 24000;
/*  398 */       this.familiarizedToday = true;
/*  399 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  400 */       func_70642_aH();
/*      */     } 
/*  402 */     if (this.field_70153_n != null && this.field_70153_n.equals(ep) && isAdult()) {
/*      */       
/*  404 */       this.familiarizedToday = true;
/*  405 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  406 */       func_70642_aH();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getAggressionMod() {
/*  413 */     return this.aggressionMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAnimalTypeID() {
/*  419 */     return Helper.stringToInt("horse");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3 getAttackedVec() {
/*  425 */     return this.attackedVec;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBirthDay() {
/*  431 */     return this.field_70180_af.func_75679_c(15);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean getBreedable() {
/*  436 */     return (this.field_70153_n == null && this.field_70154_o == null && func_110248_bS() && func_110228_bR() && 
/*  437 */       !func_110222_cv() && func_110143_aJ() >= func_110138_aP());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected EntityHorseTFC getClosestHorse(Entity entity, double range) {
/*  443 */     double maxDistance = Double.MAX_VALUE;
/*  444 */     EntityHorseTFC closestHorse = null;
/*  445 */     List<EntityHorseTFC> list = this.field_70170_p.func_94576_a(entity, entity.field_70121_D.func_72321_a(range, range, range), HORSE_BREEDING_SELECTOR);
/*  446 */     Iterator<EntityHorseTFC> iterator = list.iterator();
/*      */     
/*  448 */     while (iterator.hasNext()) {
/*      */       
/*  450 */       EntityHorseTFC nearbyHorse = iterator.next();
/*  451 */       double distance = nearbyHorse.func_70092_e(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/*  452 */       if (distance < maxDistance) {
/*      */         
/*  454 */         closestHorse = nearbyHorse;
/*  455 */         maxDistance = distance;
/*      */       } 
/*      */     } 
/*      */     
/*  459 */     return closestHorse;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDueDay() {
/*  465 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityLiving getEntity() {
/*  471 */     return (EntityLiving)this;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getFamiliarity() {
/*  476 */     return this.familiarity;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFamiliarizedToday() {
/*  482 */     return this.familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Entity getFearSource() {
/*  488 */     return this.fearSource;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IAnimal.GenderEnum getGender() {
/*  494 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*      */   }
/*      */ 
/*      */   
/*      */   public AnimalChest getHorseChest() {
/*  499 */     return this.field_110296_bG;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHunger() {
/*  505 */     return this.hunger;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getInLove() {
/*  511 */     return this.inLove;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getLastFamiliarityUpdate() {
/*  516 */     return this.lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_110167_bD() {
/*  523 */     if (super.func_110167_bD() && func_110166_bE() instanceof EntityPlayer && ((EntityPlayer)
/*  524 */       func_110166_bE()).field_71071_by.func_70448_g() == null && func_110174_bM() != -1.0F)
/*      */     {
/*  526 */       return false;
/*      */     }
/*  528 */     return super.func_110167_bD();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_110218_cm() {
/*  534 */     return (int)(500.0F * this.aggressionMod);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double func_70042_X() {
/*  543 */     float offset = this.sizeMod * this.field_70131_O * 0.75F;
/*  544 */     int type = func_110265_bP();
/*      */     
/*  546 */     if (type == 1) {
/*  547 */       offset *= 0.87F;
/*  548 */     } else if (type == 2) {
/*  549 */       offset *= 0.92F;
/*      */     } 
/*  551 */     return offset;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfDaysToAdult() {
/*  557 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 30.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   private int getNumChestSlots() {
/*  562 */     int i = func_110265_bP();
/*  563 */     return (func_110261_ca() && (i == 1 || i == 2)) ? 17 : 2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getObedienceMod() {
/*  569 */     return this.obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPregnancyRequiredTime() {
/*  574 */     return this.pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSex() {
/*  579 */     return this.sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSizeMod() {
/*  585 */     return this.sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getStrengthMod() {
/*  591 */     return this.strengthMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getTimeOfConception() {
/*  596 */     return this.timeOfConception;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleFamiliarityUpdate() {
/*  602 */     int totalDays = TFC_Time.getTotalDays();
/*  603 */     if (this.lastFamiliarityUpdate < totalDays) {
/*  604 */       if (this.familiarizedToday && this.familiarity < 100) {
/*  605 */         this.lastFamiliarityUpdate = totalDays;
/*  606 */         this.familiarizedToday = false;
/*  607 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/*  608 */         if (isAdult() && this.familiarity <= 35) {
/*      */           
/*  610 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*      */         }
/*  612 */         else if (!isAdult()) {
/*  613 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/*  614 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/*  615 */           if (this.familiarity > 70) {
/*  616 */             this.obedienceMod *= 1.01F;
/*      */           }
/*      */         }
/*      */       
/*  620 */       } else if (this.familiarity < 30) {
/*  621 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/*  622 */         this.lastFamiliarityUpdate = totalDays;
/*      */       } 
/*      */     }
/*  625 */     if (this.familiarity > 100) this.familiarity = 100; 
/*  626 */     if (this.familiarity < 0) this.familiarity = 0;
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_110198_t(int temper) {
/*  632 */     temper *= 5;
/*  633 */     int j = MathHelper.func_76125_a(func_110252_cg() + (int)(temper * this.obedienceMod * 1.0F / this.aggressionMod), 0, func_110218_cm());
/*  634 */     func_110238_s(j);
/*  635 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70085_c(EntityPlayer player) {
/*  644 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*  645 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/*  647 */       if (player.func_70093_af() && !this.familiarizedToday && itemstack != null && canFamiliarize()) {
/*      */         
/*  649 */         familiarize(player);
/*  650 */         return true;
/*      */       } 
/*  652 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/*  653 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/*  654 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*      */       }
/*      */     } 
/*      */     
/*  658 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/*  659 */       !canFamiliarize())) {
/*      */       
/*  661 */       if (!player.field_71075_bZ.field_75098_d)
/*  662 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this)); 
/*  663 */       this.hunger += 24000;
/*  664 */       setInLove(true);
/*  665 */       return true;
/*      */     } 
/*  667 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*  668 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/*  669 */         itemstack.field_77994_a--;
/*      */       }
/*  671 */       return true;
/*      */     } 
/*  673 */     if (itemstack != null && itemstack.func_77973_b() == Items.field_151063_bx)
/*      */     {
/*  675 */       return super.func_70085_c(player);
/*      */     }
/*  677 */     if (func_110248_bS() && func_110228_bR() && player.func_70093_af() && !func_110167_bD()) {
/*      */       
/*  679 */       func_110199_f(player);
/*  680 */       return true;
/*      */     } 
/*  682 */     if (func_110248_bS() && func_110228_bR() && player.func_70093_af() && func_110167_bD()) {
/*      */       
/*  684 */       func_110160_i(true, true);
/*  685 */       return true;
/*      */     } 
/*  687 */     if (func_110228_bR() && this.field_70153_n != null)
/*      */     {
/*  689 */       return super.func_70085_c(player);
/*      */     }
/*      */ 
/*      */     
/*  693 */     if (itemstack != null) {
/*      */       
/*  695 */       if (!func_110248_bS()) {
/*      */         
/*  697 */         if (itemstack.func_111282_a(player, (EntityLivingBase)this))
/*      */         {
/*  699 */           return true;
/*      */         }
/*      */         
/*  702 */         func_110231_cz();
/*      */       } 
/*      */       
/*  705 */       boolean flag = false;
/*      */       
/*  707 */       if (func_110229_cs() && !func_110261_ca() && itemstack.func_77973_b() == Item.func_150898_a(TFCBlocks.chest)) {
/*      */         
/*  709 */         func_110207_m(true);
/*  710 */         func_85030_a("mob.chickenplop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  711 */         flag = true;
/*  712 */         updateChestSaddle();
/*      */       } 
/*      */       
/*  715 */       if (flag) {
/*      */         
/*  717 */         if (!player.field_71075_bZ.field_75098_d && --itemstack.field_77994_a == 0)
/*      */         {
/*  719 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */         }
/*      */         
/*  722 */         return true;
/*      */       } 
/*      */     } 
/*  725 */     if (func_110228_bR() && this.field_70153_n == null) {
/*      */       
/*  727 */       if (itemstack != null && itemstack.func_111282_a(player, (EntityLivingBase)this))
/*      */       {
/*  729 */         return true;
/*      */       }
/*      */ 
/*      */       
/*  733 */       if (func_110166_bE() instanceof EntityPlayer && func_110166_bE() == player)
/*      */       {
/*  735 */         mountHorse(player);
/*      */       }
/*  737 */       return true;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  742 */     return super.func_70085_c(player);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAdult() {
/*  748 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70877_b(ItemStack par1ItemStack) {
/*  754 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBreedingItemTFC(ItemStack item) {
/*  759 */     return (!this.pregnant && isFood(item));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70631_g_() {
/*  765 */     return !isAdult();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isFood(ItemStack item) {
/*  770 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/*  771 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPregnant() {
/*  777 */     return this.pregnant;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void mate(IAnimal otherAnimal) {
/*  783 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*      */       
/*  785 */       otherAnimal.mate(this);
/*  786 */       setInLove(false);
/*  787 */       func_70875_t();
/*      */       return;
/*      */     } 
/*  790 */     this.timeOfConception = TFC_Time.getTotalTicks();
/*  791 */     this.pregnant = true;
/*  792 */     func_70875_t();
/*  793 */     setInLove(false);
/*  794 */     otherAnimal.setInLove(false);
/*  795 */     this.mateSizeMod = otherAnimal.getSizeMod();
/*  796 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*  797 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/*  798 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*  799 */     this.mateType = ((EntityHorse)otherAnimal).func_110265_bP();
/*  800 */     this.mateVariant = ((EntityHorse)otherAnimal).func_110202_bQ();
/*  801 */     this.mateMaxHealth = ((EntityLivingBase)otherAnimal).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
/*  802 */     this.mateJumpStrength = ((EntityLivingBase)otherAnimal).func_110148_a(HORSE_JUMP_STRENGTH).func_111125_b();
/*  803 */     this.mateMoveSpeed = ((EntityLivingBase)otherAnimal).func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b();
/*      */   }
/*      */ 
/*      */   
/*      */   private void mountHorse(EntityPlayer player) {
/*  808 */     player.field_70177_z = this.field_70177_z;
/*  809 */     player.field_70125_A = this.field_70125_A;
/*  810 */     func_110227_p(false);
/*  811 */     func_110219_q(false);
/*      */     
/*  813 */     if (!this.field_70170_p.field_72995_K && checkFamiliarity(IAnimal.InteractionEnum.MOUNT, player)) {
/*  814 */       player.func_70078_a((Entity)this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  821 */     if (this.hunger > 168000)
/*  822 */       this.hunger = 168000; 
/*  823 */     if (this.hunger > 0) {
/*  824 */       this.hunger--;
/*      */     }
/*  826 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70146_Z.nextInt(600) == 0 && !this.familiarizedToday && canFamiliarize())
/*      */     {
/*  828 */       familiarize((EntityPlayer)this.field_70153_n);
/*      */     }
/*      */     
/*  831 */     syncData();
/*  832 */     if (isAdult()) {
/*  833 */       func_70873_a(0);
/*      */     } else {
/*  835 */       func_70873_a(-1);
/*      */     } 
/*  837 */     handleFamiliarityUpdate();
/*  838 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*      */     {
/*  840 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*      */         
/*  842 */         EntityHorseTFC baby = (EntityHorseTFC)createChildTFC((EntityAgeable)this);
/*  843 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*  844 */         baby.field_70759_as = baby.field_70177_z;
/*  845 */         baby.field_70761_aq = baby.field_70177_z;
/*  846 */         this.field_70170_p.func_72838_d((Entity)baby);
/*  847 */         baby.setAge(TFC_Time.getTotalDays());
/*  848 */         this.pregnant = false;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  855 */     TFC_Core.preventEntityDataUpdate = true;
/*  856 */     super.func_70636_d();
/*  857 */     TFC_Core.preventEntityDataUpdate = false;
/*      */     
/*  859 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*      */       
/*  861 */       func_70691_i(1.0F);
/*      */     }
/*  863 */     else if (this.hunger < 144000 && func_70880_s()) {
/*  864 */       setInLove(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IEntityLivingData func_110161_a(IEntityLivingData livingData) {
/*  871 */     IEntityLivingData data = super.func_110161_a(livingData);
/*  872 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1250.0D);
/*  873 */     func_70691_i(1250.0F);
/*  874 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110199_f(EntityPlayer player) {
/*  880 */     Entity temp = player.field_70154_o;
/*      */     
/*  882 */     if (temp == null) {
/*      */       
/*  884 */       player.field_70154_o = (Entity)this;
/*  885 */       if (player instanceof EntityPlayerMP) {
/*      */         
/*  887 */         EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*  888 */         playerMP.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, (Entity)playerMP, (Entity)this));
/*  889 */         openHorseContainer(player);
/*  890 */         playerMP.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, (Entity)playerMP, temp));
/*      */       }
/*      */       else {
/*      */         
/*  894 */         openHorseContainer(player);
/*      */       } 
/*  896 */       player.field_70154_o = null;
/*      */     } 
/*      */     
/*  899 */     if (temp != null && temp == this)
/*      */     {
/*  901 */       openHorseContainer(player);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void openHorseContainer(EntityPlayer player) {
/*  907 */     if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == player) && func_110248_bS())
/*      */     {
/*  909 */       player.openGui(TerraFirmaCraft.instance, 42, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbttc) {
/*  919 */     super.func_70037_a(nbttc);
/*  920 */     NBTTagCompound nbt = nbttc;
/*  921 */     this.animalID = nbt.func_74763_f("Animal ID");
/*  922 */     this.sex = nbt.func_74762_e("Sex");
/*  923 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*      */     
/*  925 */     this.familiarity = nbt.func_74762_e("Familiarity");
/*  926 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/*  927 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*      */     
/*  929 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/*  930 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/*  931 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*      */     
/*  933 */     this.hunger = nbt.func_74762_e("Hunger");
/*  934 */     this.pregnant = nbt.func_74767_n("Pregnant");
/*  935 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/*  936 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/*  937 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/*  938 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/*  939 */     this.mateType = nbt.func_74762_e("MateType");
/*  940 */     this.mateVariant = nbt.func_74762_e("MateVariant");
/*  941 */     this.mateMaxHealth = nbt.func_74769_h("MateHealth");
/*  942 */     this.mateJumpStrength = nbt.func_74769_h("MateJump");
/*  943 */     this.mateMoveSpeed = nbt.func_74769_h("MateSpeed");
/*  944 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/*  945 */     setAge(nbt.func_74762_e("Age"));
/*      */     
/*  947 */     if (func_110261_ca()) {
/*      */       
/*  949 */       NBTTagList nbttaglist = nbttc.func_150295_c("Items", 10);
/*  950 */       updateChestSaddle();
/*      */       
/*  952 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*      */         
/*  954 */         NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
/*  955 */         int j = nbt1.func_74771_c("Slot") & 0xFF;
/*      */         
/*  957 */         if (j >= 2 && j < this.field_110296_bG.func_70302_i_())
/*      */         {
/*  959 */           this.field_110296_bG.func_70299_a(j, ItemStack.func_77949_a(nbt1));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  966 */     if (nbttc.func_150297_b("ArmorItem", 10)) {
/*      */       
/*  968 */       ItemStack itemstack = ItemStack.func_77949_a(nbttc.func_74775_l("ArmorItem"));
/*      */       
/*  970 */       if (itemstack != null && EntityHorse.func_146085_a(itemstack.func_77973_b()))
/*      */       {
/*  972 */         this.field_110296_bG.func_70299_a(1, itemstack);
/*      */       }
/*      */     } 
/*      */     
/*  976 */     if (nbttc.func_150297_b("SaddleItem", 10)) {
/*      */       
/*  978 */       ItemStack itemstack = ItemStack.func_77949_a(nbttc.func_74775_l("SaddleItem"));
/*  979 */       if (itemstack != null && itemstack.func_77973_b() == Items.field_151141_av)
/*      */       {
/*  981 */         this.field_110296_bG.func_70299_a(0, itemstack);
/*      */       }
/*      */     }
/*  984 */     else if (nbttc.func_74767_n("Saddle")) {
/*      */       
/*  986 */       this.field_110296_bG.func_70299_a(0, new ItemStack(Items.field_151141_av));
/*      */     } 
/*      */     
/*  989 */     updateSaddle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAge(int par1) {
/*  996 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAggressionMod(float aggressionMod) {
/* 1003 */     this.aggressionMod = aggressionMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttackedVec(Vec3 attackedVec) {
/* 1009 */     this.attackedVec = attackedVec;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBirthDay(int day) {
/* 1015 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFamiliarity(int familiarity) {
/* 1021 */     this.familiarity = familiarity;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 1026 */     this.familiarizedToday = familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFearSource(Entity fearSource) {
/* 1032 */     this.fearSource = fearSource;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70873_a(int par1) {
/* 1038 */     if (!TFC_Core.preventEntityDataUpdate)
/*      */     {
/* 1040 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHunger(int h) {
/* 1047 */     this.hunger = h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInLove(boolean b) {
/* 1053 */     this.inLove = b;
/* 1054 */     if (b) {
/*      */       
/* 1056 */       this.field_70789_a = null;
/* 1057 */       this.field_70170_p.func_72960_a((Entity)this, (byte)18);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 1063 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setObedienceMod(float obedienceMod) {
/* 1069 */     this.obedienceMod = obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 1074 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnant(boolean pregnant) {
/* 1079 */     this.pregnant = pregnant;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSex(int sex) {
/* 1084 */     this.sex = sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSizeMod(float sizeMod) {
/* 1090 */     this.sizeMod = sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrengthMod(float strengthMod) {
/* 1096 */     this.strengthMod = strengthMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTimeOfConception(long timeOfConception) {
/* 1101 */     this.timeOfConception = timeOfConception;
/*      */   }
/*      */ 
/*      */   
/*      */   public void syncData() {
/* 1106 */     if (this.field_70180_af != null)
/*      */     {
/* 1108 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/* 1110 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1116 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1122 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 1123 */         this.field_70180_af.func_75692_b(26, Integer.valueOf(buf.getInt()));
/* 1124 */         this.field_70180_af.func_75692_b(24, Integer.valueOf(buf.getInt()));
/* 1125 */         this.field_70180_af.func_75692_b(25, String.valueOf(this.timeOfConception));
/*      */       }
/*      */       else {
/*      */         
/* 1129 */         this.sex = this.field_70180_af.func_75679_c(13);
/*      */         
/* 1131 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 1132 */         buf.putInt(this.field_70180_af.func_75679_c(26));
/* 1133 */         buf.putInt(this.field_70180_af.func_75679_c(24));
/* 1134 */         byte[] values = buf.array();
/*      */         
/* 1136 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 1137 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 1138 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 1139 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*      */         
/* 1141 */         this.familiarity = values[4];
/* 1142 */         this.familiarizedToday = (values[5] == 1);
/* 1143 */         this.pregnant = (values[6] == 1);
/*      */ 
/*      */         
/*      */         try {
/* 1147 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(25));
/* 1148 */         } catch (NumberFormatException numberFormatException) {}
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean trySetName(String name, EntityPlayer player) {
/* 1155 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*      */       
/* 1157 */       func_94058_c(name);
/* 1158 */       return true;
/*      */     } 
/* 1160 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 1161 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateChestSaddle() {
/* 1166 */     AnimalChest animalchest = this.field_110296_bG;
/* 1167 */     this.field_110296_bG = new AnimalChest("HorseChest", getNumChestSlots());
/*      */     
/* 1169 */     if (animalchest != null) {
/*      */       
/* 1171 */       animalchest.func_110132_b(this);
/* 1172 */       int i = Math.min(animalchest.func_70302_i_(), this.field_110296_bG.func_70302_i_());
/* 1173 */       for (int j = 0; j < i; j++) {
/*      */         
/* 1175 */         ItemStack itemstack = animalchest.func_70301_a(j);
/* 1176 */         if (itemstack != null)
/* 1177 */           this.field_110296_bG.func_70299_a(j, itemstack.func_77946_l()); 
/*      */       } 
/* 1179 */       animalchest = null;
/*      */     } 
/*      */     
/* 1182 */     this.field_110296_bG.func_110134_a(this);
/* 1183 */     updateSaddle();
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateSaddle() {
/* 1188 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/* 1190 */       func_110251_o((this.field_110296_bG.func_70301_a(0) != null));
/* 1191 */       if (func_110265_bP() == 0) {
/* 1192 */         func_146086_d(this.field_110296_bG.func_70301_a(1));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbttc) {
/* 1202 */     super.func_70014_b(nbttc);
/* 1203 */     nbttc.func_74768_a("Sex", this.sex);
/* 1204 */     nbttc.func_74772_a("Animal ID", this.animalID);
/* 1205 */     nbttc.func_74776_a("Size Modifier", this.sizeMod);
/*      */     
/* 1207 */     nbttc.func_74768_a("Familiarity", this.familiarity);
/* 1208 */     nbttc.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 1209 */     nbttc.func_74757_a("Familiarized Today", this.familiarizedToday);
/*      */     
/* 1211 */     NBTTagCompound nbt = nbttc;
/* 1212 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 1213 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 1214 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*      */     
/* 1216 */     nbttc.func_74768_a("Hunger", this.hunger);
/* 1217 */     nbttc.func_74757_a("Pregnant", this.pregnant);
/* 1218 */     nbttc.func_74776_a("MateSize", this.mateSizeMod);
/* 1219 */     nbttc.func_74776_a("MateStrength", this.mateStrengthMod);
/* 1220 */     nbttc.func_74776_a("MateAggro", this.mateAggroMod);
/* 1221 */     nbttc.func_74776_a("MateObed", this.mateObedMod);
/* 1222 */     nbttc.func_74768_a("MateType", this.mateType);
/* 1223 */     nbttc.func_74768_a("MateVariant", this.mateVariant);
/* 1224 */     nbttc.func_74780_a("MateHealth", this.mateMaxHealth);
/* 1225 */     nbttc.func_74780_a("MateJump", this.mateJumpStrength);
/* 1226 */     nbttc.func_74780_a("MateSpeed", this.mateMoveSpeed);
/* 1227 */     nbttc.func_74772_a("ConceptionTime", this.timeOfConception);
/* 1228 */     nbttc.func_74768_a("Age", getBirthDay());
/*      */     
/* 1230 */     if (func_110261_ca()) {
/*      */       
/* 1232 */       NBTTagList nbttaglist = new NBTTagList();
/*      */       
/* 1234 */       for (int i = 2; i < this.field_110296_bG.func_70302_i_(); i++) {
/*      */         
/* 1236 */         ItemStack itemstack = this.field_110296_bG.func_70301_a(i);
/*      */         
/* 1238 */         if (itemstack != null) {
/*      */           
/* 1240 */           NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 1241 */           nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 1242 */           itemstack.func_77955_b(nbttagcompound1);
/* 1243 */           nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*      */         } 
/*      */       } 
/*      */       
/* 1247 */       nbttc.func_74782_a("Items", (NBTBase)nbttaglist);
/*      */     } 
/*      */     
/* 1250 */     if (this.field_110296_bG.func_70301_a(1) != null)
/*      */     {
/* 1252 */       nbttc.func_74782_a("ArmorItem", (NBTBase)this.field_110296_bG.func_70301_a(1).func_77955_b(new NBTTagCompound()));
/*      */     }
/*      */     
/* 1255 */     if (this.field_110296_bG.func_70301_a(0) != null)
/*      */     {
/* 1257 */       nbttc.func_74782_a("SaddleItem", (NBTBase)this.field_110296_bG.func_70301_a(0).func_77955_b(new NBTTagCompound()));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityHorseTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */