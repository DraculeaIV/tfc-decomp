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
/*  113 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/*  114 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/*  115 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/*  116 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/*  117 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/*  118 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/*  119 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*  120 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanicTFC((EntityCreature)this, 1.2D, true));
/*  121 */     updateChestSaddle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  127 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityHorseTFC(World par1World, IAnimal mother, List<Float> data, int type, int variant) {
/*  134 */     this(par1World);
/*  135 */     float fatherSize = 1.0F;
/*  136 */     float fatherStr = 1.0F;
/*  137 */     float fatherAggro = 1.0F;
/*  138 */     float fatherObed = 1.0F;
/*  139 */     for (int i = 0; i < data.size(); i++) {
/*  140 */       switch (i) { case 0:
/*  141 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/*  142 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/*  143 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/*  144 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*      */           break; }
/*      */     
/*      */     } 
/*  148 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/*  149 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/*  150 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*  151 */     float invSizeRatio = 0.52118623F;
/*  152 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/*  153 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/*  154 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/*  155 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*      */     
/*  157 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*      */ 
/*      */     
/*  160 */     setAge(TFC_Time.getTotalDays());
/*  161 */     func_110214_p(type);
/*  162 */     func_110235_q(variant);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_110147_ax() {
/*  168 */     super.func_110147_ax();
/*  169 */     func_110140_aT().func_111150_b(HORSE_JUMP_STRENGTH);
/*  170 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((1250.0F * this.sizeMod * this.strengthMod));
/*  171 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.22499999403953552D * this.strengthMod * this.obedienceMod / (this.sizeMod * this.sizeMod));
/*  172 */     func_70606_j(func_110138_aP());
/*      */   }
/*      */ 
/*      */   
/*      */   private double calcJumpStrength() {
/*  177 */     return 0.4000000059604645D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D + this.field_70146_Z.nextDouble() * 0.2D;
/*      */   }
/*      */ 
/*      */   
/*      */   private float calcMaxHealth() {
/*  182 */     return 1000.0F + this.field_70146_Z.nextInt(101) + this.field_70146_Z.nextInt(151);
/*      */   }
/*      */ 
/*      */   
/*      */   private double calcMoveSpeed() {
/*  187 */     return (0.44999998807907104D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D + this.field_70146_Z.nextDouble() * 0.3D) * 0.25D;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canFamiliarize() {
/*  193 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70878_b(EntityAnimal animal) {
/*  202 */     if (animal == this)
/*      */     {
/*  204 */       return false;
/*      */     }
/*  206 */     if (animal.getClass() != getClass())
/*      */     {
/*  208 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  212 */     EntityHorseTFC entityhorse = (EntityHorseTFC)animal;
/*      */     
/*  214 */     if (getBreedable() && entityhorse.getBreedable()) {
/*      */       
/*  216 */       int i = func_110265_bP();
/*  217 */       int j = entityhorse.func_110265_bP();
/*  218 */       return (i == j || (i == 0 && j == 1) || (i == 1 && j == 0));
/*      */     } 
/*      */ 
/*      */     
/*  222 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canMateWith(IAnimal animal) {
/*  230 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityHorseTFC);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/*  236 */     boolean flag = false;
/*  237 */     switch (interaction) { case MOUNT:
/*  238 */         flag = (this.familiarity > 15); break;
/*  239 */       case BREED: flag = (this.familiarity > 20); break;
/*  240 */       case NAME: flag = (this.familiarity > 40);
/*      */         break; }
/*      */     
/*  243 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/*  244 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*      */     }
/*  246 */     return flag;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110160_i(boolean par1, boolean par2) {
/*  252 */     Entity entity = func_110166_bE();
/*  253 */     if (entity instanceof EntityPlayer) {
/*      */ 
/*      */       
/*  256 */       if (entity.func_70093_af()) {
/*  257 */         super.func_110160_i(par1, true);
/*      */       }
/*      */     } else {
/*      */       
/*  261 */       super.func_110160_i(par1, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable func_90011_a(EntityAgeable eAgeable) {
/*  268 */     return createChildTFC(eAgeable);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/*  274 */     ArrayList<Float> data = new ArrayList<Float>();
/*  275 */     data.add(Float.valueOf(this.mateSizeMod));
/*  276 */     data.add(Float.valueOf(this.mateStrengthMod));
/*  277 */     data.add(Float.valueOf(this.mateAggroMod));
/*  278 */     data.add(Float.valueOf(this.mateObedMod));
/*      */     
/*  280 */     int momType = func_110265_bP();
/*  281 */     int dadType = this.mateType;
/*  282 */     int babyType = 0;
/*  283 */     int babyVariant = 0;
/*      */     
/*  285 */     if (momType == dadType) {
/*      */       
/*  287 */       babyType = momType;
/*      */     }
/*  289 */     else if ((momType == 0 && dadType == 1) || (momType == 1 && dadType == 0)) {
/*      */       
/*  291 */       babyType = 2;
/*      */     } 
/*      */     
/*  294 */     if (babyType == 0) {
/*      */       
/*  296 */       int l = this.field_70146_Z.nextInt(9);
/*      */       
/*  298 */       if (l < 4) {
/*      */         
/*  300 */         babyVariant = func_110202_bQ() & 0xFF;
/*      */       }
/*  302 */       else if (l < 8) {
/*      */         
/*  304 */         babyVariant = this.mateVariant & 0xFF;
/*      */       }
/*      */       else {
/*      */         
/*  308 */         babyVariant = this.field_70146_Z.nextInt(7);
/*      */       } 
/*      */       
/*  311 */       int j1 = this.field_70146_Z.nextInt(5);
/*      */       
/*  313 */       if (j1 < 4) {
/*      */         
/*  315 */         babyVariant |= func_110202_bQ() & 0xFF00;
/*      */       }
/*  317 */       else if (j1 < 8) {
/*      */         
/*  319 */         babyVariant |= this.mateVariant & 0xFF00;
/*      */       }
/*      */       else {
/*      */         
/*  323 */         babyVariant |= this.field_70146_Z.nextInt(5) << 8 & 0xFF00;
/*      */       } 
/*      */     } 
/*      */     
/*  327 */     EntityHorseTFC baby = new EntityHorseTFC(this.field_70170_p, this, data, babyType, babyVariant);
/*      */ 
/*      */     
/*  330 */     double healthSum = func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + this.mateMaxHealth + calcMaxHealth();
/*  331 */     baby.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(healthSum / 3.0D);
/*      */ 
/*      */     
/*  334 */     double jumpSum = func_110148_a(HORSE_JUMP_STRENGTH).func_111125_b() + this.mateJumpStrength + calcJumpStrength();
/*  335 */     baby.func_110148_a(HORSE_JUMP_STRENGTH).func_111128_a(jumpSum / 3.0D);
/*      */ 
/*      */     
/*  338 */     double speedSum = func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b() + this.mateMoveSpeed + calcMoveSpeed();
/*  339 */     baby.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(speedSum / 3.0D);
/*      */     
/*  341 */     baby.func_70606_j((float)baby.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
/*  342 */     return (EntityAgeable)baby;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110224_ci() {
/*  348 */     if (!this.field_70170_p.field_72995_K && func_110261_ca())
/*      */     {
/*  350 */       func_110207_m(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70628_a(boolean par1, int par2) {
/*  357 */     float ageMod = TFC_Core.getPercentGrown(this);
/*      */     
/*  359 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)(ageMod * 3.0F - 1.0F)))), 0.0F);
/*  360 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(8) + 3) * ageMod));
/*  361 */     if (func_110167_bD()) {
/*  362 */       func_70099_a(new ItemStack(TFCItems.rope), 0.0F);
/*      */     }
/*      */     
/*  365 */     float foodWeight = ageMod * this.sizeMod * 4000.0F;
/*      */     
/*  367 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.horseMeatRaw, foodWeight);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  373 */     super.func_70088_a();
/*  374 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/*  375 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*      */     
/*  377 */     this.field_70180_af.func_75682_a(26, Integer.valueOf(0));
/*  378 */     this.field_70180_af.func_75682_a(24, Integer.valueOf(0));
/*  379 */     this.field_70180_af.func_75682_a(25, String.valueOf("0"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void familiarize(EntityPlayer ep) {
/*  385 */     ItemStack stack = ep.func_70694_bm();
/*  386 */     if ((this.field_70153_n == null || !this.field_70153_n.equals(ep)) && !this.familiarizedToday && stack != null && isFood(stack) && canFamiliarize()) {
/*      */       
/*  388 */       if (!ep.field_71075_bZ.field_75098_d) {
/*      */         
/*  390 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*      */       }
/*      */       else {
/*      */         
/*  394 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */       } 
/*  396 */       this.hunger += 24000;
/*  397 */       this.familiarizedToday = true;
/*  398 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  399 */       func_70642_aH();
/*      */     } 
/*  401 */     if (this.field_70153_n != null && this.field_70153_n.equals(ep) && isAdult()) {
/*      */       
/*  403 */       this.familiarizedToday = true;
/*  404 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  405 */       func_70642_aH();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getAggressionMod() {
/*  412 */     return this.aggressionMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAnimalTypeID() {
/*  418 */     return Helper.stringToInt("horse");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3 getAttackedVec() {
/*  424 */     return this.attackedVec;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBirthDay() {
/*  430 */     return this.field_70180_af.func_75679_c(15);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean getBreedable() {
/*  435 */     return (this.field_70153_n == null && this.field_70154_o == null && func_110248_bS() && func_110228_bR() && 
/*  436 */       !func_110222_cv() && func_110143_aJ() >= func_110138_aP());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected EntityHorseTFC getClosestHorse(Entity entity, double range) {
/*  442 */     double maxDistance = Double.MAX_VALUE;
/*  443 */     EntityHorseTFC closestHorse = null;
/*  444 */     List<EntityHorseTFC> list = this.field_70170_p.func_94576_a(entity, entity.field_70121_D.func_72321_a(range, range, range), HORSE_BREEDING_SELECTOR);
/*  445 */     Iterator<EntityHorseTFC> iterator = list.iterator();
/*      */     
/*  447 */     while (iterator.hasNext()) {
/*      */       
/*  449 */       EntityHorseTFC nearbyHorse = iterator.next();
/*  450 */       double distance = nearbyHorse.func_70092_e(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/*  451 */       if (distance < maxDistance) {
/*      */         
/*  453 */         closestHorse = nearbyHorse;
/*  454 */         maxDistance = distance;
/*      */       } 
/*      */     } 
/*      */     
/*  458 */     return closestHorse;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDueDay() {
/*  464 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityLiving getEntity() {
/*  470 */     return (EntityLiving)this;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getFamiliarity() {
/*  475 */     return this.familiarity;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFamiliarizedToday() {
/*  481 */     return this.familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Entity getFearSource() {
/*  487 */     return this.fearSource;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IAnimal.GenderEnum getGender() {
/*  493 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*      */   }
/*      */ 
/*      */   
/*      */   public AnimalChest getHorseChest() {
/*  498 */     return this.field_110296_bG;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHunger() {
/*  504 */     return this.hunger;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getInLove() {
/*  510 */     return this.inLove;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getLastFamiliarityUpdate() {
/*  515 */     return this.lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_110167_bD() {
/*  522 */     if (super.func_110167_bD() && func_110166_bE() instanceof EntityPlayer && ((EntityPlayer)
/*  523 */       func_110166_bE()).field_71071_by.func_70448_g() == null && func_110174_bM() != -1.0F)
/*      */     {
/*  525 */       return false;
/*      */     }
/*  527 */     return super.func_110167_bD();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_110218_cm() {
/*  533 */     return (int)(500.0F * this.aggressionMod);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double func_70042_X() {
/*  542 */     float offset = this.sizeMod * this.field_70131_O * 0.75F;
/*  543 */     int type = func_110265_bP();
/*      */     
/*  545 */     if (type == 1) {
/*  546 */       offset *= 0.87F;
/*  547 */     } else if (type == 2) {
/*  548 */       offset *= 0.92F;
/*      */     } 
/*  550 */     return offset;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfDaysToAdult() {
/*  556 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 30.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   private int getNumChestSlots() {
/*  561 */     int i = func_110265_bP();
/*  562 */     return (func_110261_ca() && (i == 1 || i == 2)) ? 17 : 2;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getObedienceMod() {
/*  568 */     return this.obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPregnancyRequiredTime() {
/*  573 */     return this.pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSex() {
/*  578 */     return this.sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSizeMod() {
/*  584 */     return this.sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getStrengthMod() {
/*  590 */     return this.strengthMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getTimeOfConception() {
/*  595 */     return this.timeOfConception;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleFamiliarityUpdate() {
/*  601 */     int totalDays = TFC_Time.getTotalDays();
/*  602 */     if (this.lastFamiliarityUpdate < totalDays) {
/*  603 */       if (this.familiarizedToday && this.familiarity < 100) {
/*  604 */         this.lastFamiliarityUpdate = totalDays;
/*  605 */         this.familiarizedToday = false;
/*  606 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/*  607 */         if (isAdult() && this.familiarity <= 35) {
/*      */           
/*  609 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*      */         }
/*  611 */         else if (!isAdult()) {
/*  612 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/*  613 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/*  614 */           if (this.familiarity > 70) {
/*  615 */             this.obedienceMod *= 1.01F;
/*      */           }
/*      */         }
/*      */       
/*  619 */       } else if (this.familiarity < 30) {
/*  620 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/*  621 */         this.lastFamiliarityUpdate = totalDays;
/*      */       } 
/*      */     }
/*  624 */     if (this.familiarity > 100) this.familiarity = 100; 
/*  625 */     if (this.familiarity < 0) this.familiarity = 0;
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_110198_t(int temper) {
/*  631 */     temper *= 5;
/*  632 */     int j = MathHelper.func_76125_a(func_110252_cg() + (int)(temper * this.obedienceMod * 1.0F / this.aggressionMod), 0, func_110218_cm());
/*  633 */     func_110238_s(j);
/*  634 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70085_c(EntityPlayer player) {
/*  643 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*  644 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/*  646 */       if (player.func_70093_af() && !this.familiarizedToday && itemstack != null && canFamiliarize()) {
/*      */         
/*  648 */         familiarize(player);
/*  649 */         return true;
/*      */       } 
/*  651 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/*  652 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/*  653 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*      */       }
/*      */     } 
/*      */     
/*  657 */     if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/*  658 */       !canFamiliarize())) {
/*      */       
/*  660 */       if (!player.field_71075_bZ.field_75098_d)
/*  661 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this)); 
/*  662 */       this.hunger += 24000;
/*  663 */       setInLove(true);
/*  664 */       return true;
/*      */     } 
/*  666 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*  667 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/*  668 */         itemstack.field_77994_a--;
/*      */       }
/*  670 */       return true;
/*      */     } 
/*  672 */     if (itemstack != null && itemstack.func_77973_b() == Items.field_151063_bx)
/*      */     {
/*  674 */       return super.func_70085_c(player);
/*      */     }
/*  676 */     if (func_110248_bS() && func_110228_bR() && player.func_70093_af() && !func_110167_bD()) {
/*      */       
/*  678 */       func_110199_f(player);
/*  679 */       return true;
/*      */     } 
/*  681 */     if (func_110248_bS() && func_110228_bR() && player.func_70093_af() && func_110167_bD()) {
/*      */       
/*  683 */       func_110160_i(true, true);
/*  684 */       return true;
/*      */     } 
/*  686 */     if (func_110228_bR() && this.field_70153_n != null)
/*      */     {
/*  688 */       return super.func_70085_c(player);
/*      */     }
/*      */ 
/*      */     
/*  692 */     if (itemstack != null) {
/*      */       
/*  694 */       if (!func_110248_bS()) {
/*      */         
/*  696 */         if (itemstack.func_111282_a(player, (EntityLivingBase)this))
/*      */         {
/*  698 */           return true;
/*      */         }
/*      */         
/*  701 */         func_110231_cz();
/*      */       } 
/*      */       
/*  704 */       boolean flag = false;
/*      */       
/*  706 */       if (func_110229_cs() && !func_110261_ca() && itemstack.func_77973_b() == Item.func_150898_a(TFCBlocks.chest)) {
/*      */         
/*  708 */         func_110207_m(true);
/*  709 */         func_85030_a("mob.chickenplop", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*  710 */         flag = true;
/*  711 */         updateChestSaddle();
/*      */       } 
/*      */       
/*  714 */       if (flag) {
/*      */         
/*  716 */         if (!player.field_71075_bZ.field_75098_d && --itemstack.field_77994_a == 0)
/*      */         {
/*  718 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */         }
/*      */         
/*  721 */         return true;
/*      */       } 
/*      */     } 
/*  724 */     if (func_110228_bR() && this.field_70153_n == null) {
/*      */       
/*  726 */       if (itemstack != null && itemstack.func_111282_a(player, (EntityLivingBase)this))
/*      */       {
/*  728 */         return true;
/*      */       }
/*      */ 
/*      */       
/*  732 */       if (func_110166_bE() instanceof EntityPlayer && func_110166_bE() == player)
/*      */       {
/*  734 */         mountHorse(player);
/*      */       }
/*  736 */       return true;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  741 */     return super.func_70085_c(player);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAdult() {
/*  747 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70877_b(ItemStack par1ItemStack) {
/*  753 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBreedingItemTFC(ItemStack item) {
/*  758 */     return (!this.pregnant && isFood(item));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70631_g_() {
/*  764 */     return !isAdult();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isFood(ItemStack item) {
/*  769 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/*  770 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPregnant() {
/*  776 */     return this.pregnant;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void mate(IAnimal otherAnimal) {
/*  782 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*      */       
/*  784 */       otherAnimal.mate(this);
/*  785 */       setInLove(false);
/*  786 */       func_70875_t();
/*      */       return;
/*      */     } 
/*  789 */     this.timeOfConception = TFC_Time.getTotalTicks();
/*  790 */     this.pregnant = true;
/*  791 */     func_70875_t();
/*  792 */     setInLove(false);
/*  793 */     otherAnimal.setInLove(false);
/*  794 */     this.mateSizeMod = otherAnimal.getSizeMod();
/*  795 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*  796 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/*  797 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*  798 */     this.mateType = ((EntityHorse)otherAnimal).func_110265_bP();
/*  799 */     this.mateVariant = ((EntityHorse)otherAnimal).func_110202_bQ();
/*  800 */     this.mateMaxHealth = ((EntityLivingBase)otherAnimal).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
/*  801 */     this.mateJumpStrength = ((EntityLivingBase)otherAnimal).func_110148_a(HORSE_JUMP_STRENGTH).func_111125_b();
/*  802 */     this.mateMoveSpeed = ((EntityLivingBase)otherAnimal).func_110148_a(SharedMonsterAttributes.field_111263_d).func_111125_b();
/*      */   }
/*      */ 
/*      */   
/*      */   private void mountHorse(EntityPlayer player) {
/*  807 */     player.field_70177_z = this.field_70177_z;
/*  808 */     player.field_70125_A = this.field_70125_A;
/*  809 */     func_110227_p(false);
/*  810 */     func_110219_q(false);
/*      */     
/*  812 */     if (!this.field_70170_p.field_72995_K && checkFamiliarity(IAnimal.InteractionEnum.MOUNT, player)) {
/*  813 */       player.func_70078_a((Entity)this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  820 */     if (this.hunger > 168000)
/*  821 */       this.hunger = 168000; 
/*  822 */     if (this.hunger > 0) {
/*  823 */       this.hunger--;
/*      */     }
/*  825 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70146_Z.nextInt(600) == 0 && !this.familiarizedToday && canFamiliarize())
/*      */     {
/*  827 */       familiarize((EntityPlayer)this.field_70153_n);
/*      */     }
/*      */     
/*  830 */     syncData();
/*  831 */     if (isAdult()) {
/*  832 */       func_70873_a(0);
/*      */     } else {
/*  834 */       func_70873_a(-1);
/*      */     } 
/*  836 */     handleFamiliarityUpdate();
/*  837 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*      */     {
/*  839 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*      */         
/*  841 */         EntityHorseTFC baby = (EntityHorseTFC)createChildTFC((EntityAgeable)this);
/*  842 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*  843 */         baby.field_70759_as = baby.field_70177_z;
/*  844 */         baby.field_70761_aq = baby.field_70177_z;
/*  845 */         this.field_70170_p.func_72838_d((Entity)baby);
/*  846 */         baby.setAge(TFC_Time.getTotalDays());
/*  847 */         this.pregnant = false;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  854 */     TFC_Core.preventEntityDataUpdate = true;
/*  855 */     super.func_70636_d();
/*  856 */     TFC_Core.preventEntityDataUpdate = false;
/*      */     
/*  858 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*      */       
/*  860 */       func_70691_i(1.0F);
/*      */     }
/*  862 */     else if (this.hunger < 144000 && func_70880_s()) {
/*  863 */       setInLove(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IEntityLivingData func_110161_a(IEntityLivingData livingData) {
/*  870 */     IEntityLivingData data = super.func_110161_a(livingData);
/*  871 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1250.0D);
/*  872 */     func_70691_i(1250.0F);
/*  873 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_110199_f(EntityPlayer player) {
/*  879 */     Entity temp = player.field_70154_o;
/*      */     
/*  881 */     if (temp == null) {
/*      */       
/*  883 */       player.field_70154_o = (Entity)this;
/*  884 */       if (player instanceof EntityPlayerMP) {
/*      */         
/*  886 */         EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*  887 */         playerMP.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, (Entity)playerMP, (Entity)this));
/*  888 */         openHorseContainer(player);
/*  889 */         playerMP.field_71135_a.func_147359_a((Packet)new S1BPacketEntityAttach(0, (Entity)playerMP, temp));
/*      */       }
/*      */       else {
/*      */         
/*  893 */         openHorseContainer(player);
/*      */       } 
/*  895 */       player.field_70154_o = null;
/*      */     } 
/*      */     
/*  898 */     if (temp != null && temp == this)
/*      */     {
/*  900 */       openHorseContainer(player);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void openHorseContainer(EntityPlayer player) {
/*  906 */     if (!this.field_70170_p.field_72995_K && (this.field_70153_n == null || this.field_70153_n == player) && func_110248_bS())
/*      */     {
/*  908 */       player.openGui(TerraFirmaCraft.instance, 42, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbttc) {
/*  918 */     super.func_70037_a(nbttc);
/*  919 */     NBTTagCompound nbt = nbttc;
/*  920 */     this.animalID = nbt.func_74763_f("Animal ID");
/*  921 */     this.sex = nbt.func_74762_e("Sex");
/*  922 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*      */     
/*  924 */     this.familiarity = nbt.func_74762_e("Familiarity");
/*  925 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/*  926 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*      */     
/*  928 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/*  929 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/*  930 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*      */     
/*  932 */     this.hunger = nbt.func_74762_e("Hunger");
/*  933 */     this.pregnant = nbt.func_74767_n("Pregnant");
/*  934 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/*  935 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/*  936 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/*  937 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/*  938 */     this.mateType = nbt.func_74762_e("MateType");
/*  939 */     this.mateVariant = nbt.func_74762_e("MateVariant");
/*  940 */     this.mateMaxHealth = nbt.func_74769_h("MateHealth");
/*  941 */     this.mateJumpStrength = nbt.func_74769_h("MateJump");
/*  942 */     this.mateMoveSpeed = nbt.func_74769_h("MateSpeed");
/*  943 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/*  944 */     setAge(nbt.func_74762_e("Age"));
/*      */     
/*  946 */     if (func_110261_ca()) {
/*      */       
/*  948 */       NBTTagList nbttaglist = nbttc.func_150295_c("Items", 10);
/*  949 */       updateChestSaddle();
/*      */       
/*  951 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*      */         
/*  953 */         NBTTagCompound nbt1 = nbttaglist.func_150305_b(i);
/*  954 */         int j = nbt1.func_74771_c("Slot") & 0xFF;
/*      */         
/*  956 */         if (j >= 2 && j < this.field_110296_bG.func_70302_i_())
/*      */         {
/*  958 */           this.field_110296_bG.func_70299_a(j, ItemStack.func_77949_a(nbt1));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  965 */     if (nbttc.func_150297_b("ArmorItem", 10)) {
/*      */       
/*  967 */       ItemStack itemstack = ItemStack.func_77949_a(nbttc.func_74775_l("ArmorItem"));
/*      */       
/*  969 */       if (itemstack != null && EntityHorse.func_146085_a(itemstack.func_77973_b()))
/*      */       {
/*  971 */         this.field_110296_bG.func_70299_a(1, itemstack);
/*      */       }
/*      */     } 
/*      */     
/*  975 */     if (nbttc.func_150297_b("SaddleItem", 10)) {
/*      */       
/*  977 */       ItemStack itemstack = ItemStack.func_77949_a(nbttc.func_74775_l("SaddleItem"));
/*  978 */       if (itemstack != null && itemstack.func_77973_b() == Items.field_151141_av)
/*      */       {
/*  980 */         this.field_110296_bG.func_70299_a(0, itemstack);
/*      */       }
/*      */     }
/*  983 */     else if (nbttc.func_74767_n("Saddle")) {
/*      */       
/*  985 */       this.field_110296_bG.func_70299_a(0, new ItemStack(Items.field_151141_av));
/*      */     } 
/*      */     
/*  988 */     updateSaddle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAge(int par1) {
/*  995 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAggressionMod(float aggressionMod) {
/* 1002 */     this.aggressionMod = aggressionMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttackedVec(Vec3 attackedVec) {
/* 1008 */     this.attackedVec = attackedVec;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBirthDay(int day) {
/* 1014 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFamiliarity(int familiarity) {
/* 1020 */     this.familiarity = familiarity;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 1025 */     this.familiarizedToday = familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFearSource(Entity fearSource) {
/* 1031 */     this.fearSource = fearSource;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70873_a(int par1) {
/* 1037 */     if (!TFC_Core.preventEntityDataUpdate)
/*      */     {
/* 1039 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHunger(int h) {
/* 1046 */     this.hunger = h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInLove(boolean b) {
/* 1052 */     this.inLove = b;
/* 1053 */     if (b) {
/*      */       
/* 1055 */       this.field_70789_a = null;
/* 1056 */       this.field_70170_p.func_72960_a((Entity)this, (byte)18);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 1062 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setObedienceMod(float obedienceMod) {
/* 1068 */     this.obedienceMod = obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/* 1073 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnant(boolean pregnant) {
/* 1078 */     this.pregnant = pregnant;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSex(int sex) {
/* 1083 */     this.sex = sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSizeMod(float sizeMod) {
/* 1089 */     this.sizeMod = sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrengthMod(float strengthMod) {
/* 1095 */     this.strengthMod = strengthMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTimeOfConception(long timeOfConception) {
/* 1100 */     this.timeOfConception = timeOfConception;
/*      */   }
/*      */ 
/*      */   
/*      */   public void syncData() {
/* 1105 */     if (this.field_70180_af != null)
/*      */     {
/* 1107 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/* 1109 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1115 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1121 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 1122 */         this.field_70180_af.func_75692_b(26, Integer.valueOf(buf.getInt()));
/* 1123 */         this.field_70180_af.func_75692_b(24, Integer.valueOf(buf.getInt()));
/* 1124 */         this.field_70180_af.func_75692_b(25, String.valueOf(this.timeOfConception));
/*      */       }
/*      */       else {
/*      */         
/* 1128 */         this.sex = this.field_70180_af.func_75679_c(13);
/*      */         
/* 1130 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 1131 */         buf.putInt(this.field_70180_af.func_75679_c(26));
/* 1132 */         buf.putInt(this.field_70180_af.func_75679_c(24));
/* 1133 */         byte[] values = buf.array();
/*      */         
/* 1135 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 1136 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 1137 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 1138 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*      */         
/* 1140 */         this.familiarity = values[4];
/* 1141 */         this.familiarizedToday = (values[5] == 1);
/* 1142 */         this.pregnant = (values[6] == 1);
/*      */ 
/*      */         
/*      */         try {
/* 1146 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(25));
/* 1147 */         } catch (NumberFormatException numberFormatException) {}
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean trySetName(String name, EntityPlayer player) {
/* 1154 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*      */       
/* 1156 */       func_94058_c(name);
/* 1157 */       return true;
/*      */     } 
/* 1159 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 1160 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateChestSaddle() {
/* 1165 */     AnimalChest animalchest = this.field_110296_bG;
/* 1166 */     this.field_110296_bG = new AnimalChest("HorseChest", getNumChestSlots());
/*      */     
/* 1168 */     if (animalchest != null) {
/*      */       
/* 1170 */       animalchest.func_110132_b(this);
/* 1171 */       int i = Math.min(animalchest.func_70302_i_(), this.field_110296_bG.func_70302_i_());
/* 1172 */       for (int j = 0; j < i; j++) {
/*      */         
/* 1174 */         ItemStack itemstack = animalchest.func_70301_a(j);
/* 1175 */         if (itemstack != null)
/* 1176 */           this.field_110296_bG.func_70299_a(j, itemstack.func_77946_l()); 
/*      */       } 
/* 1178 */       animalchest = null;
/*      */     } 
/*      */     
/* 1181 */     this.field_110296_bG.func_110134_a(this);
/* 1182 */     updateSaddle();
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateSaddle() {
/* 1187 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/* 1189 */       func_110251_o((this.field_110296_bG.func_70301_a(0) != null));
/* 1190 */       if (func_110265_bP() == 0) {
/* 1191 */         func_146086_d(this.field_110296_bG.func_70301_a(1));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbttc) {
/* 1201 */     super.func_70014_b(nbttc);
/* 1202 */     nbttc.func_74768_a("Sex", this.sex);
/* 1203 */     nbttc.func_74772_a("Animal ID", this.animalID);
/* 1204 */     nbttc.func_74776_a("Size Modifier", this.sizeMod);
/*      */     
/* 1206 */     nbttc.func_74768_a("Familiarity", this.familiarity);
/* 1207 */     nbttc.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 1208 */     nbttc.func_74757_a("Familiarized Today", this.familiarizedToday);
/*      */     
/* 1210 */     NBTTagCompound nbt = nbttc;
/* 1211 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 1212 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 1213 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*      */     
/* 1215 */     nbttc.func_74768_a("Hunger", this.hunger);
/* 1216 */     nbttc.func_74757_a("Pregnant", this.pregnant);
/* 1217 */     nbttc.func_74776_a("MateSize", this.mateSizeMod);
/* 1218 */     nbttc.func_74776_a("MateStrength", this.mateStrengthMod);
/* 1219 */     nbttc.func_74776_a("MateAggro", this.mateAggroMod);
/* 1220 */     nbttc.func_74776_a("MateObed", this.mateObedMod);
/* 1221 */     nbttc.func_74768_a("MateType", this.mateType);
/* 1222 */     nbttc.func_74768_a("MateVariant", this.mateVariant);
/* 1223 */     nbttc.func_74780_a("MateHealth", this.mateMaxHealth);
/* 1224 */     nbttc.func_74780_a("MateJump", this.mateJumpStrength);
/* 1225 */     nbttc.func_74780_a("MateSpeed", this.mateMoveSpeed);
/* 1226 */     nbttc.func_74772_a("ConceptionTime", this.timeOfConception);
/* 1227 */     nbttc.func_74768_a("Age", getBirthDay());
/*      */     
/* 1229 */     if (func_110261_ca()) {
/*      */       
/* 1231 */       NBTTagList nbttaglist = new NBTTagList();
/*      */       
/* 1233 */       for (int i = 2; i < this.field_110296_bG.func_70302_i_(); i++) {
/*      */         
/* 1235 */         ItemStack itemstack = this.field_110296_bG.func_70301_a(i);
/*      */         
/* 1237 */         if (itemstack != null) {
/*      */           
/* 1239 */           NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 1240 */           nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 1241 */           itemstack.func_77955_b(nbttagcompound1);
/* 1242 */           nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*      */         } 
/*      */       } 
/*      */       
/* 1246 */       nbttc.func_74782_a("Items", (NBTBase)nbttaglist);
/*      */     } 
/*      */     
/* 1249 */     if (this.field_110296_bG.func_70301_a(1) != null)
/*      */     {
/* 1251 */       nbttc.func_74782_a("ArmorItem", (NBTBase)this.field_110296_bG.func_70301_a(1).func_77955_b(new NBTTagCompound()));
/*      */     }
/*      */     
/* 1254 */     if (this.field_110296_bG.func_70301_a(0) != null)
/*      */     {
/* 1256 */       nbttc.func_74782_a("SaddleItem", (NBTBase)this.field_110296_bG.func_70301_a(0).func_77955_b(new NBTTagCompound()));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityHorseTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */