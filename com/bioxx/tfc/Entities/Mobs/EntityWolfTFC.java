/*      */ package com.bioxx.tfc.Entities.Mobs;
/*      */ 
/*      */ import com.bioxx.tfc.Core.TFC_Core;
/*      */ import com.bioxx.tfc.Core.TFC_Time;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAISitTFC;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAITargetNonTamedTFC;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.api.Entities.IAnimal;
/*      */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*      */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*      */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import com.bioxx.tfc.api.TFCOptions;
/*      */ import com.bioxx.tfc.api.Util.Helper;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import net.minecraft.block.BlockColored;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAISit;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.passive.EntityWolf;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.pathfinding.PathEntity;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class EntityWolfTFC
/*      */   extends EntityWolf
/*      */   implements IAnimal, IInnateArmor, ICausesDamage
/*      */ {
/*      */   private static final float GESTATION_PERIOD = 2.25F;
/*      */   private static final float DIMORPHISM = 0.0786F;
/*      */   private static final int DEGREE_OF_DIVERSION = 1;
/*      */   private static final int FAMILIARITY_CAP = 35;
/*      */   private long animalID;
/*      */   private int sex;
/*      */   private int hunger;
/*      */   private boolean pregnant;
/*      */   private int pregnancyRequiredTime;
/*      */   private long timeOfConception;
/*      */   private float mateSizeMod;
/*      */   private float mateStrengthMod;
/*      */   private float mateAggroMod;
/*      */   private float mateObedMod;
/*      */   private float sizeMod;
/*      */   private float strengthMod;
/*   64 */   private float aggressionMod = 1.0F;
/*   65 */   private float obedienceMod = 1.0F;
/*      */   
/*      */   private boolean inLove;
/*      */   
/*      */   private int familiarity;
/*      */   private long lastFamiliarityUpdate;
/*      */   private boolean familiarizedToday;
/*      */   private int happyTicks;
/*      */   private boolean wasRoped;
/*      */   protected EntityAITargetNonTamedTFC targetChicken;
/*      */   protected EntityAITargetNonTamedTFC targetPheasant;
/*      */   protected EntityAITargetNonTamedTFC targetPig;
/*      */   protected EntityAITargetNonTamedTFC targetCow;
/*      */   protected EntityAITargetNonTamedTFC targetDeer;
/*      */   protected EntityAITargetNonTamedTFC targetHorse;
/*      */   private boolean peacefulAI;
/*      */   
/*      */   public EntityWolfTFC(World par1World) {
/*   83 */     super(par1World);
/*   84 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*   85 */     this.field_70715_bh.func_85156_a((EntityAIBase)this.field_70911_d);
/*   86 */     this.field_70911_d = (EntityAISit)new EntityAISitTFC((EntityTameable)this);
/*   87 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*      */ 
/*      */     
/*   90 */     this.targetChicken = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityChickenTFC.class, 200, false);
/*   91 */     this.targetPheasant = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityPheasantTFC.class, 200, false);
/*   92 */     this.targetPig = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityPigTFC.class, 200, false);
/*   93 */     this.targetCow = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityCowTFC.class, 200, false);
/*   94 */     this.targetDeer = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityDeer.class, 200, false);
/*   95 */     this.targetHorse = new EntityAITargetNonTamedTFC((EntityTameable)this, EntityHorseTFC.class, 200, false);
/*   96 */     if (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*      */       
/*   98 */       this.peacefulAI = false;
/*   99 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetChicken);
/*  100 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetPheasant);
/*  101 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetPig);
/*  102 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetCow);
/*  103 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetDeer);
/*  104 */       this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetHorse);
/*      */     } else {
/*      */       
/*  107 */       this.peacefulAI = true;
/*      */     } 
/*  109 */     this.hunger = 168000;
/*  110 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  111 */     this.pregnant = false;
/*  112 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 2.25F * (float)TFC_Time.ticksInMonth);
/*  113 */     this.timeOfConception = 0L;
/*  114 */     this.mateSizeMod = 1.0F;
/*  115 */     this.sex = this.field_70146_Z.nextInt(2);
/*  116 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.0786F * this.sex)));
/*  117 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  118 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  119 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  125 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityWolfTFC(World par1World, IAnimal mother, List<Float> data) {
/*  130 */     this(par1World);
/*  131 */     float fatherSize = 1.0F;
/*  132 */     float fatherStr = 1.0F;
/*  133 */     float fatherAggro = 1.0F;
/*  134 */     float fatherObed = 1.0F;
/*  135 */     for (int i = 0; i < data.size(); i++) {
/*  136 */       switch (i) { case 0:
/*  137 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/*  138 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/*  139 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/*  140 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*      */           break; }
/*      */     
/*      */     } 
/*  144 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/*  145 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/*  146 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*  147 */     float invSizeRatio = 0.5204539F;
/*  148 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/*  149 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/*  150 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/*  151 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*      */     
/*  153 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*      */ 
/*      */     
/*  156 */     setAge(TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_110147_ax() {
/*  161 */     super.func_110147_ax();
/*  162 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70652_k(Entity par1Entity) {
/*  167 */     int damage = (int)(80.0F * getStrengthMod() * getAggressionMod() * (getSizeMod() / 2.0F + 0.5F));
/*      */     
/*  169 */     return par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), damage);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70692_ba() {
/*  174 */     if (!isAdult())
/*  175 */       return false; 
/*  176 */     if (func_70902_q() != null)
/*  177 */       return false; 
/*  178 */     if (this.wasRoped) {
/*  179 */       return false;
/*      */     }
/*  181 */     return (this.field_70173_aa > 20000);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canFamiliarize() {
/*  186 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canMateWith(IAnimal animal) {
/*  191 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityWolfTFC);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/*  198 */     boolean flag = false;
/*  199 */     switch (interaction) {
/*      */       
/*      */       case BREED:
/*  202 */         flag = (this.familiarity > 20);
/*      */         break;
/*      */       case NAME:
/*  205 */         flag = (this.familiarity > 40);
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  210 */     if (!flag && player != null && !player.field_70170_p.field_72995_K)
/*      */     {
/*  212 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*      */     }
/*  214 */     return flag;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityWolf func_90011_a(EntityAgeable entityageable) {
/*  220 */     return (EntityWolf)createChildTFC(entityageable);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/*  226 */     ArrayList<Float> data = new ArrayList<Float>();
/*  227 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/*  228 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/*  229 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/*  230 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/*  231 */     return (EntityAgeable)new EntityWolfTFC(this.field_70170_p, this, data);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70628_a(boolean par1, int par2) {
/*  237 */     float ageMod = TFC_Core.getPercentGrown(this);
/*  238 */     func_70099_a(new ItemStack(TFCItems.hide, 1, Math.max(0, Math.min(2, (int)((this.sizeMod * ageMod) * 0.9D)))), 0.0F);
/*  239 */     func_145779_a(Items.field_151103_aS, (int)((this.field_70146_Z.nextInt(3) + 1) * ageMod));
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  244 */     super.func_70088_a();
/*  245 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/*  246 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*      */     
/*  248 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/*  249 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/*  250 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void familiarize(EntityPlayer ep) {
/*  256 */     if (this.happyTicks == 0 && this.familiarity >= 5 && !this.familiarizedToday && canFamiliarize()) {
/*      */       
/*  258 */       this.familiarizedToday = true;
/*  259 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  260 */       func_70642_aH();
/*  261 */       this.happyTicks = 40;
/*      */     } 
/*  263 */     if (this.familiarity > 80 && func_70902_q() != null)
/*      */     {
/*  265 */       func_70903_f(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public float getAggressionMod() {
/*  271 */     return this.aggressionMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getAnimalID() {
/*  276 */     return this.animalID;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAnimalTypeID() {
/*  282 */     return Helper.stringToInt("wolf");
/*      */   }
/*      */ 
/*      */   
/*      */   public Vec3 getAttackedVec() {
/*  287 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getBirthDay() {
/*  292 */     return this.field_70180_af.func_75679_c(15);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getCrushArmor() {
/*  297 */     return 250;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EnumDamageType getDamageType() {
/*  303 */     return EnumDamageType.SLASHING;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getDueDay() {
/*  308 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityLiving getEntity() {
/*  313 */     return (EntityLiving)this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFamiliarity() {
/*  319 */     return this.familiarity;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFamiliarizedToday() {
/*  325 */     return this.familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Entity getFearSource() {
/*  332 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IAnimal.GenderEnum getGender() {
/*  338 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHappyTicks() {
/*  344 */     return this.happyTicks;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHunger() {
/*  350 */     return this.hunger;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getInLove() {
/*  356 */     return this.inLove;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getLastFamiliarityUpdate() {
/*  361 */     return this.lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfDaysToAdult() {
/*  367 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 9.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getObedienceMod() {
/*  373 */     return this.obedienceMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPierceArmor() {
/*  379 */     return -335;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPregnancyRequiredTime() {
/*  384 */     return this.pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSex() {
/*  389 */     return this.sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSizeMod() {
/*  395 */     return this.sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSlashArmor() {
/*  401 */     return 250;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getStrengthMod() {
/*  407 */     return this.strengthMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float func_70920_v() {
/*  414 */     float scale = func_110138_aP() / 20.0F;
/*  415 */     if (func_70919_bu())
/*  416 */       return 1.5393804F; 
/*  417 */     if (func_70902_q() != null) {
/*  418 */       return (0.55F - (func_110138_aP() - this.field_70180_af.func_111145_d(18)) / scale * 0.02F) * 3.1415927F;
/*      */     }
/*  420 */     return 0.62831855F;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getTimeOfConception() {
/*  425 */     return this.timeOfConception;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleFamiliarityUpdate() {
/*  431 */     int totalDays = TFC_Time.getTotalDays();
/*  432 */     if (this.lastFamiliarityUpdate < totalDays)
/*      */     {
/*  434 */       if (this.familiarizedToday && this.familiarity < 100) {
/*      */         
/*  436 */         this.lastFamiliarityUpdate = totalDays;
/*  437 */         this.familiarizedToday = false;
/*  438 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/*  439 */         if (isAdult() && this.familiarity >= 5 && this.familiarity <= 35)
/*      */         {
/*  441 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*      */         }
/*  443 */         else if (!isAdult())
/*      */         {
/*  445 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/*  446 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/*  447 */           if (this.familiarity > 70)
/*      */           {
/*  449 */             this.obedienceMod *= 1.01F;
/*      */           }
/*      */         }
/*      */       
/*  453 */       } else if (this.familiarity < 30) {
/*      */         
/*  455 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/*  456 */         this.lastFamiliarityUpdate = totalDays;
/*      */       } 
/*      */     }
/*  459 */     if (this.familiarity > 100)
/*  460 */       this.familiarity = 100; 
/*  461 */     if (this.familiarity < ((func_70902_q() != null) ? 5 : 0)) {
/*  462 */       this.familiarity = (func_70902_q() != null) ? 5 : 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70085_c(EntityPlayer player) {
/*  471 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/*  473 */       if (player.func_70093_af() && func_70902_q() != null && canFamiliarize()) {
/*      */         
/*  475 */         familiarize(player);
/*  476 */         return true;
/*      */       } 
/*  478 */       if (player.func_70694_bm() != null) {
/*      */         
/*  480 */         ItemStack is = player.func_70694_bm();
/*  481 */         if (isFood(is)) {
/*      */           
/*  483 */           Item item = is.func_77973_b();
/*  484 */           if (item instanceof ItemFoodTFC && this.hunger <= 160000) {
/*      */             
/*  486 */             player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)item).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*  487 */             this.hunger += 24000;
/*  488 */             return true;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  493 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation((getGender() == IAnimal.GenderEnum.FEMALE) ? "entity.female" : "entity.male", new Object[0]));
/*  494 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/*  495 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*      */       }
/*      */     } 
/*  498 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*      */     
/*  500 */     if (itemstack != null) {
/*      */       
/*  502 */       if (isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s()) {
/*      */         
/*  504 */         if (!player.field_71075_bZ.field_75098_d)
/*      */         {
/*  506 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*      */         }
/*      */         
/*  509 */         func_146082_f(player);
/*  510 */         return true;
/*      */       } 
/*  512 */       if (itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*      */         
/*  514 */         if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player))
/*      */         {
/*  516 */           itemstack.field_77994_a--;
/*      */         }
/*  518 */         return true;
/*      */       } 
/*  520 */       if (itemstack.func_77973_b() == Items.field_151103_aS && !func_70919_bu()) {
/*      */         
/*  522 */         if (func_70902_q() == null) {
/*      */           
/*  524 */           if (!player.field_71075_bZ.field_75098_d)
/*      */           {
/*  526 */             itemstack.field_77994_a--;
/*      */           }
/*      */           
/*  529 */           if (itemstack.field_77994_a <= 0)
/*      */           {
/*  531 */             player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */           }
/*      */           
/*  534 */           if (!this.field_70170_p.field_72995_K)
/*      */           {
/*  536 */             if (this.field_70146_Z.nextInt(3) == 0) {
/*      */               
/*  538 */               func_70903_f(true);
/*  539 */               func_70778_a((PathEntity)null);
/*  540 */               func_70624_b((EntityLivingBase)null);
/*  541 */               func_152115_b(player.func_110124_au().toString());
/*  542 */               func_70908_e(true);
/*  543 */               this.field_70170_p.func_72960_a((Entity)this, (byte)7);
/*      */             }
/*      */             else {
/*      */               
/*  547 */               func_70908_e(false);
/*  548 */               this.field_70170_p.func_72960_a((Entity)this, (byte)6);
/*      */             } 
/*      */           }
/*      */         } 
/*      */         
/*  553 */         return true;
/*      */       } 
/*      */       
/*  556 */       if (func_70909_n() && (itemstack.func_77973_b() == Items.field_151100_aR || itemstack.func_77973_b() == TFCItems.dye)) {
/*      */         
/*  558 */         int i = BlockColored.func_150032_b(itemstack.func_77960_j());
/*      */         
/*  560 */         if (i != func_82186_bH()) {
/*      */           
/*  562 */           func_82185_r(i);
/*      */           
/*  564 */           if (!player.field_71075_bZ.field_75098_d && --itemstack.field_77994_a <= 0)
/*      */           {
/*  566 */             player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */           }
/*      */         } 
/*      */         
/*  570 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/*  574 */     return super.func_70085_c(player);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAdult() {
/*  580 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70877_b(ItemStack is) {
/*  586 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBreedingItemTFC(ItemStack item) {
/*  591 */     return (!this.pregnant && isFood(item));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70631_g_() {
/*  597 */     return !isAdult();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFood(ItemStack item) {
/*  603 */     return (item != null && (item
/*  604 */       .func_77973_b() == TFCItems.beefRaw || item.func_77973_b() == TFCItems.chickenRaw || item.func_77973_b() == TFCItems.fishRaw || item
/*  605 */       .func_77973_b() == TFCItems.horseMeatRaw || item.func_77973_b() == TFCItems.muttonRaw || item.func_77973_b() == TFCItems.porkchopRaw || item
/*  606 */       .func_77973_b() == TFCItems.venisonRaw));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPeacefulAI() {
/*  611 */     return this.peacefulAI;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPregnant() {
/*  617 */     return this.pregnant;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasBeenRoped() {
/*  622 */     return this.wasRoped;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void mate(IAnimal otherAnimal) {
/*  628 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*      */       
/*  630 */       otherAnimal.mate(this);
/*  631 */       setInLove(false);
/*  632 */       func_70875_t();
/*      */       return;
/*      */     } 
/*  635 */     this.timeOfConception = TFC_Time.getTotalTicks();
/*  636 */     this.pregnant = true;
/*  637 */     func_70875_t();
/*  638 */     setInLove(false);
/*  639 */     otherAnimal.setInLove(false);
/*  640 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/*  641 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*  642 */     this.mateSizeMod = otherAnimal.getSizeMod();
/*  643 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  654 */     if (this.hunger > 168000)
/*  655 */       this.hunger = 168000; 
/*  656 */     if (this.hunger > 0) {
/*  657 */       this.hunger--;
/*      */     }
/*  659 */     if (func_110167_bD()) {
/*      */       
/*  661 */       Entity leashedTo = func_110166_bE();
/*      */       
/*  663 */       if (leashedTo instanceof net.minecraft.entity.EntityLeashKnot && this.familiarity >= 5 && !func_70919_bu()) {
/*      */         
/*  665 */         this.field_70911_d.func_75270_a(true);
/*  666 */         func_70904_g(true);
/*  667 */         this.field_70703_bu = false;
/*      */         
/*  669 */         func_70778_a((PathEntity)null);
/*  670 */         func_70784_b((Entity)null);
/*  671 */         func_70624_b((EntityLivingBase)null);
/*      */       
/*      */       }
/*  674 */       else if (leashedTo instanceof EntityPlayer || (leashedTo instanceof net.minecraft.entity.EntityLeashKnot && func_70919_bu())) {
/*      */         
/*  676 */         this.field_70911_d.func_75270_a(false);
/*  677 */         func_70904_g(false);
/*      */       } 
/*      */       
/*  680 */       if (!this.wasRoped) {
/*  681 */         this.wasRoped = true;
/*      */       }
/*      */     }
/*  684 */     else if (func_70919_bu() && func_70906_o()) {
/*      */       
/*  686 */       this.field_70911_d.func_75270_a(false);
/*  687 */       func_70904_g(false);
/*      */     } 
/*      */     
/*  690 */     if (func_70880_s()) {
/*  691 */       setInLove(true);
/*      */     }
/*  693 */     if (isAdult()) {
/*  694 */       func_70873_a(0);
/*      */     } else {
/*  696 */       func_70873_a(-1);
/*      */     } 
/*  698 */     handleFamiliarityUpdate();
/*      */     
/*  700 */     if (this.happyTicks > 0) {
/*  701 */       this.happyTicks--;
/*      */     }
/*  703 */     syncData();
/*      */     
/*  705 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*      */     {
/*  707 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*      */         
/*  709 */         int i = this.field_70146_Z.nextInt(2) + 1;
/*  710 */         for (int x = 0; x < i; x++) {
/*      */           
/*  712 */           ArrayList<Float> data = new ArrayList<Float>();
/*  713 */           data.add(Float.valueOf(this.mateSizeMod));
/*  714 */           EntityWolfTFC baby = (EntityWolfTFC)createChildTFC((EntityAgeable)this);
/*  715 */           baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*  716 */           baby.field_70759_as = baby.field_70177_z;
/*  717 */           baby.field_70761_aq = baby.field_70177_z;
/*  718 */           baby.setAge(TFC_Time.getTotalDays());
/*  719 */           this.field_70170_p.func_72838_d((Entity)baby);
/*      */         } 
/*  721 */         this.pregnant = false;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  728 */     TFC_Core.preventEntityDataUpdate = true;
/*  729 */     super.func_70636_d();
/*  730 */     TFC_Core.preventEntityDataUpdate = false;
/*      */     
/*  732 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*      */       
/*  734 */       func_70691_i(1.0F);
/*      */     }
/*  736 */     else if (this.hunger < 144000 && func_70880_s()) {
/*      */       
/*  738 */       setInLove(false);
/*      */     } 
/*      */ 
/*      */     
/*  742 */     if (func_110167_bD() && func_70919_bu() && func_110166_bE() == func_70902_q()) {
/*      */       
/*  744 */       func_70916_h(false);
/*  745 */       func_70778_a((PathEntity)null);
/*  746 */       func_70784_b((Entity)null);
/*  747 */       func_70624_b((EntityLivingBase)null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/*  754 */     super.func_70071_h_();
/*  755 */     if (!this.field_70170_p.field_72995_K)
/*      */     {
/*  757 */       if (!this.peacefulAI && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
/*      */         
/*  759 */         this.peacefulAI = true;
/*  760 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetChicken);
/*  761 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPheasant);
/*  762 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetPig);
/*  763 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetCow);
/*  764 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetDeer);
/*  765 */         this.field_70715_bh.func_85156_a((EntityAIBase)this.targetHorse);
/*      */       }
/*  767 */       else if (this.peacefulAI && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
/*      */         
/*  769 */         this.peacefulAI = false;
/*  770 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetChicken);
/*  771 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetPheasant);
/*  772 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetPig);
/*  773 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetCow);
/*  774 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetDeer);
/*  775 */         this.field_70715_bh.func_75776_a(7, (EntityAIBase)this.targetHorse);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbt) {
/*  786 */     super.func_70037_a(nbt);
/*  787 */     func_70916_h(nbt.func_74767_n("Angry"));
/*  788 */     this.animalID = nbt.func_74763_f("Animal ID");
/*  789 */     this.sex = nbt.func_74762_e("Sex");
/*  790 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*      */     
/*  792 */     this.familiarity = nbt.func_74762_e("Familiarity");
/*  793 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/*  794 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*      */     
/*  796 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/*  797 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/*  798 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*      */     
/*  800 */     this.field_70180_af.func_75692_b(16, Byte.valueOf(nbt.func_74771_c("tamed")));
/*  801 */     this.happyTicks = nbt.func_74762_e("happy");
/*      */     
/*  803 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*      */     
/*  805 */     this.hunger = nbt.func_74762_e("Hunger");
/*  806 */     this.pregnant = nbt.func_74767_n("Pregnant");
/*  807 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/*  808 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/*  809 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/*  810 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/*  811 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/*  812 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAge(int par1) {
/*  818 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAggressionMod(float aggressionMod) {
/*  824 */     this.aggressionMod = aggressionMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAnimalID(long animalID) {
/*  829 */     this.animalID = animalID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttackedVec(Vec3 attackedVec) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBirthDay(int day) {
/*  840 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFamiliarity(int familiarity) {
/*  846 */     this.familiarity = familiarity;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFamiliarizedToday(boolean familiarizedToday) {
/*  851 */     this.familiarizedToday = familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFearSource(Entity fearSource) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70873_a(int par1) {
/*  862 */     if (!TFC_Core.preventEntityDataUpdate) {
/*  863 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*      */     }
/*      */   }
/*      */   
/*      */   public void setHappyTicks(int happyTicks) {
/*  868 */     this.happyTicks = happyTicks;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHunger(int h) {
/*  874 */     this.hunger = h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInLove(boolean b) {
/*  880 */     this.inLove = b;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/*  885 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setObedienceMod(float obedienceMod) {
/*  891 */     this.obedienceMod = obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPeacefulAI(boolean isPeacefulAI) {
/*  896 */     this.peacefulAI = isPeacefulAI;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnancyRequiredTime(int pregnancyRequiredTime) {
/*  901 */     this.pregnancyRequiredTime = pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPregnant(boolean pregnant) {
/*  906 */     this.pregnant = pregnant;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSex(int sex) {
/*  911 */     this.sex = sex;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSizeMod(float sizeMod) {
/*  917 */     this.sizeMod = sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrengthMod(float strengthMod) {
/*  923 */     this.strengthMod = strengthMod;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70903_f(boolean par1) {
/*  929 */     if (this.familiarity > 80 && !func_70909_n()) {
/*      */       
/*  931 */       super.func_70903_f(par1);
/*      */       
/*  933 */       double healthRatio = func_110143_aJ() / func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
/*      */       
/*  935 */       func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0D);
/*  936 */       float h = (float)(healthRatio * func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
/*  937 */       func_70606_j(h);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTimeOfConception(long timeOfConception) {
/*  943 */     this.timeOfConception = timeOfConception;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWasRoped(boolean wasRoped) {
/*  948 */     this.wasRoped = wasRoped;
/*      */   }
/*      */ 
/*      */   
/*      */   public void syncData() {
/*  953 */     if (this.field_70180_af != null)
/*      */     {
/*  955 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/*  957 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*      */         
/*  959 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), (byte)this.happyTicks };
/*      */ 
/*      */         
/*  962 */         ByteBuffer buf = ByteBuffer.wrap(values);
/*  963 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/*  964 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/*  965 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*      */       }
/*      */       else {
/*      */         
/*  969 */         this.sex = this.field_70180_af.func_75679_c(13);
/*      */         
/*  971 */         ByteBuffer buf = ByteBuffer.allocate(8);
/*  972 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/*  973 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/*  974 */         byte[] values = buf.array();
/*      */         
/*  976 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/*  977 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/*  978 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/*  979 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*      */         
/*  981 */         this.familiarity = values[4];
/*  982 */         this.familiarizedToday = (values[5] == 1);
/*  983 */         this.pregnant = (values[6] == 1);
/*  984 */         this.happyTicks = values[7];
/*      */ 
/*      */         
/*      */         try {
/*  988 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/*  989 */         } catch (NumberFormatException numberFormatException) {}
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean trySetName(String name, EntityPlayer player) {
/*  998 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*      */       
/* 1000 */       func_94058_c(name);
/* 1001 */       return true;
/*      */     } 
/* 1003 */     func_85030_a("mob.wolf.growl", 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 1004 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbt) {
/* 1013 */     super.func_70014_b(nbt);
/* 1014 */     nbt.func_74757_a("Angry", func_70919_bu());
/* 1015 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 1016 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 1017 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/* 1018 */     nbt.func_74768_a("Sex", this.sex);
/* 1019 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 1020 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*      */     
/* 1022 */     nbt.func_74774_a("tamed", this.field_70180_af.func_75683_a(16));
/* 1023 */     nbt.func_74768_a("happy", this.happyTicks);
/*      */     
/* 1025 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*      */     
/* 1027 */     nbt.func_74776_a("Strength Modifier", getStrengthMod());
/* 1028 */     nbt.func_74776_a("Aggression Modifier", getAggressionMod());
/* 1029 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*      */     
/* 1031 */     nbt.func_74768_a("Hunger", this.hunger);
/* 1032 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 1033 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 1034 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 1035 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 1036 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 1037 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 1038 */     nbt.func_74768_a("Age", getBirthDay());
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityWolfTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */