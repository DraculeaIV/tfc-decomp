/*      */ package com.bioxx.tfc.Entities.Mobs;
/*      */ 
/*      */ import com.bioxx.tfc.Core.TFC_Climate;
/*      */ import com.bioxx.tfc.Core.TFC_Core;
/*      */ import com.bioxx.tfc.Core.TFC_Time;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIMateTFC;
/*      */ import com.bioxx.tfc.Entities.AI.EntityAIOcelotSitTFC;
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
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IEntityLivingData;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAIFollowOwner;
/*      */ import net.minecraft.entity.ai.EntityAIFollowParent;
/*      */ import net.minecraft.entity.ai.EntityAILeapAtTarget;
/*      */ import net.minecraft.entity.ai.EntityAIOcelotAttack;
/*      */ import net.minecraft.entity.ai.EntityAISit;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITargetNonTamed;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWander;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.passive.EntityAnimal;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.pathfinding.PathEntity;
/*      */ import net.minecraft.util.ChatComponentTranslation;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class EntityOcelotTFC
/*      */   extends EntityTameable
/*      */   implements IAnimal, IInnateArmor, ICausesDamage
/*      */ {
/*      */   private static final float GESTATION_PERIOD = 6.0F;
/*      */   private static final float DIMORPHISM = 0.1822F;
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
/*      */   private int mateColor;
/*      */   private float sizeMod;
/*      */   private float strengthMod;
/*   84 */   private float aggressionMod = 1.0F;
/*   85 */   private float obedienceMod = 1.0F;
/*      */   
/*      */   private boolean inLove;
/*      */   
/*      */   private boolean adultTaskSet = false;
/*      */   private int familiarity;
/*      */   private long lastFamiliarityUpdate;
/*      */   private boolean familiarizedToday;
/*      */   private EntityAITempt aiTempt;
/*      */   private Vec3 attackedVec;
/*      */   private Entity fearSource;
/*      */   protected EntityAITargetNonTamedTFC targetChicken;
/*      */   
/*      */   public EntityOcelotTFC(World p_i1688_1_) {
/*   99 */     super(p_i1688_1_);
/*      */ 
/*      */     
/*  102 */     func_70105_a(0.6F, 0.8F);
/*  103 */     func_70661_as().func_75491_a(true);
/*  104 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  105 */     this.field_70911_d = new EntityAISit(this);
/*  106 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*  107 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, TFCItems.fishRaw, false)));
/*  108 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 16.0F, 0.8D, 1.33D));
/*  109 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
/*  110 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.1D));
/*  111 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIOcelotSitTFC(this, 1.33D));
/*  112 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3F));
/*  113 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIOcelotAttack((EntityLiving)this));
/*  114 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  115 */     this.field_70714_bg.func_75776_a(11, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8D));
/*  116 */     this.field_70714_bg.func_75776_a(12, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  117 */     this.targetChicken = new EntityAITargetNonTamedTFC(this, EntityChickenTFC.class, 200, false);
/*      */ 
/*      */     
/*  120 */     this.hunger = 168000;
/*  121 */     this.animalID = TFC_Time.getTotalTicks() + func_145782_y();
/*  122 */     this.pregnant = false;
/*  123 */     this.pregnancyRequiredTime = (int)(TFCOptions.animalTimeMultiplier * 6.0F * (float)TFC_Time.ticksInMonth);
/*  124 */     this.timeOfConception = 0L;
/*  125 */     this.mateSizeMod = 0.0F;
/*  126 */     this.sex = this.field_70146_Z.nextInt(2);
/*  127 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.1822F * this.sex)));
/*  128 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  129 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  130 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(10) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  136 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityOcelotTFC(World par1World, IAnimal mother, List<Float> data) {
/*  141 */     this(par1World);
/*  142 */     float fatherSize = 1.0F;
/*  143 */     float fatherStr = 1.0F;
/*  144 */     float fatherAggro = 1.0F;
/*  145 */     float fatherObed = 1.0F;
/*  146 */     for (int i = 0; i < data.size(); i++) {
/*  147 */       switch (i) { case 0:
/*  148 */           fatherSize = ((Float)data.get(i)).floatValue(); break;
/*  149 */         case 1: fatherStr = ((Float)data.get(i)).floatValue(); break;
/*  150 */         case 2: fatherAggro = ((Float)data.get(i)).floatValue(); break;
/*  151 */         case 3: fatherObed = ((Float)data.get(i)).floatValue();
/*      */           break; }
/*      */     
/*      */     } 
/*  155 */     this.field_70165_t = ((EntityLivingBase)mother).field_70165_t;
/*  156 */     this.field_70163_u = ((EntityLivingBase)mother).field_70163_u;
/*  157 */     this.field_70161_v = ((EntityLivingBase)mother).field_70161_v;
/*      */     
/*  159 */     float invSizeRatio = 0.5501155F;
/*  160 */     this.sizeMod = (float)Math.sqrt((this.sizeMod * this.sizeMod * (float)Math.sqrt(((mother.getSizeMod() + fatherSize) * invSizeRatio))));
/*  161 */     this.strengthMod = (float)Math.sqrt((this.strengthMod * this.strengthMod * (float)Math.sqrt(((mother.getStrengthMod() + fatherStr) * 0.5F))));
/*  162 */     this.aggressionMod = (float)Math.sqrt((this.aggressionMod * this.aggressionMod * (float)Math.sqrt(((mother.getAggressionMod() + fatherAggro) * 0.5F))));
/*  163 */     this.obedienceMod = (float)Math.sqrt((this.obedienceMod * this.obedienceMod * (float)Math.sqrt(((mother.getObedienceMod() + fatherObed) * 0.5F))));
/*      */     
/*  165 */     this.familiarity = (int)((mother.getFamiliarity() < 90) ? (mother.getFamiliarity() / 2) : (mother.getFamiliarity() * 0.9F));
/*      */ 
/*      */     
/*  168 */     setAge(TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_110147_ax() {
/*  174 */     super.func_110147_ax();
/*  175 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70652_k(Entity p_70652_1_) {
/*  181 */     return p_70652_1_.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 3.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70097_a(DamageSource par1DamageSource, float p_70097_2_) {
/*  190 */     if (func_85032_ar())
/*      */     {
/*  192 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  196 */     this.field_70911_d.func_75270_a(false);
/*  197 */     return super.func_70097_a(par1DamageSource, p_70097_2_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean func_70692_ba() {
/*  204 */     if (!isAdult())
/*  205 */       return false; 
/*  206 */     if (func_70902_q() != null)
/*  207 */       return false; 
/*  208 */     if (func_70909_n())
/*  209 */       return false; 
/*  210 */     return (this.field_70173_aa > 40000);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canFamiliarize() {
/*  216 */     return (!isAdult() || (isAdult() && this.familiarity <= 35));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canMateWith(IAnimal animal) {
/*  223 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal instanceof EntityOcelotTFC);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/*  230 */     boolean flag = false;
/*  231 */     switch (interaction) {
/*      */       
/*      */       case BREED:
/*  234 */         flag = (this.familiarity > 20);
/*      */         break;
/*      */       case NAME:
/*  237 */         flag = (this.familiarity > 40);
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  242 */     if (!flag && player != null && !player.field_70170_p.field_72995_K)
/*      */     {
/*  244 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*      */     }
/*  246 */     return flag;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityOcelotTFC createChild(EntityAgeable entityageable) {
/*  252 */     return (EntityOcelotTFC)createChildTFC(entityageable);
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityAgeable createChildTFC(EntityAgeable eAgeable) {
/*  257 */     ArrayList<Float> data = new ArrayList<Float>();
/*  258 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateSize")));
/*  259 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateStrength")));
/*  260 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateAggro")));
/*  261 */     data.add(Float.valueOf(eAgeable.getEntityData().func_74760_g("MateObed")));
/*  262 */     EntityOcelotTFC baby = new EntityOcelotTFC(this.field_70170_p, this, data);
/*      */     
/*  264 */     return (EntityAgeable)baby;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70628_a(boolean par1, int par2) {
/*  270 */     func_70099_a(new ItemStack(TFCItems.hide, 1, 0), 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  277 */     super.func_70088_a();
/*  278 */     this.field_70180_af.func_75682_a(26, Integer.valueOf(0));
/*  279 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/*  280 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*      */     
/*  282 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/*  283 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/*  284 */     this.field_70180_af.func_75682_a(24, String.valueOf("0"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70069_a(float p_70069_1_) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void familiarize(EntityPlayer ep) {
/*  297 */     ItemStack stack = ep.func_70694_bm();
/*  298 */     if (stack != null && !this.familiarizedToday && isFood(stack) && canFamiliarize()) {
/*      */       
/*  300 */       if (!ep.field_71075_bZ.field_75098_d) {
/*      */         
/*  302 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*      */       }
/*      */       else {
/*      */         
/*  306 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*      */       } 
/*  308 */       this.hunger += 24000;
/*  309 */       this.familiarizedToday = true;
/*  310 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/*  311 */       func_70642_aH();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int func_70654_ax() {
/*  317 */     return getBirthDay();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getAggressionMod() {
/*  323 */     return this.aggressionMod;
/*      */   }
/*      */   
/*      */   public long getAnimalID() {
/*  327 */     return this.animalID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAnimalTypeID() {
/*  334 */     return Helper.stringToInt("ocelot");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3 getAttackedVec() {
/*  340 */     return this.attackedVec;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBirthDay() {
/*  346 */     return this.field_70180_af.func_75679_c(15);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70601_bi() {
/*  356 */     if (this.field_70170_p.field_73012_v.nextInt(30) == 0) {
/*      */       
/*  358 */       float temperatureAvg = TFC_Climate.getBioTemperature(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70161_v);
/*  359 */       float rainfall = TFC_Climate.getRainfall(this.field_70170_p, (int)this.field_70165_t, 0, (int)this.field_70161_v);
/*      */       
/*  361 */       if (rainfall >= 1000.0F && temperatureAvg >= 23.0F && temperatureAvg <= 44.0F)
/*      */       {
/*      */ 
/*      */         
/*  365 */         return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*      */       }
/*      */     } 
/*  368 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String func_70005_c_() {
/*  377 */     return func_94056_bM() ? func_94057_bL() : (func_70909_n() ? StatCollector.func_74838_a("entity.Cat.name") : super.func_70005_c_());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String func_70673_aS() {
/*  386 */     return "terrafirmacraft:mob.cat.hitt";
/*      */   }
/*      */   
/*      */   protected Item func_146068_u() {
/*  390 */     return TFCItems.hide;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDueDay() {
/*  396 */     return TFC_Time.getDayFromTotalHours((this.timeOfConception + this.pregnancyRequiredTime) / 1000L);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityLiving getEntity() {
/*  402 */     return (EntityLiving)this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFamiliarity() {
/*  408 */     return this.familiarity;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFamiliarizedToday() {
/*  414 */     return this.familiarizedToday;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Entity getFearSource() {
/*  420 */     return this.fearSource;
/*      */   }
/*      */ 
/*      */   
/*      */   public IAnimal.GenderEnum getGender() {
/*  425 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getHunger() {
/*  431 */     return this.hunger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String func_70621_aR() {
/*  440 */     return "terrafirmacraft:mob.cat.hiss";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getInLove() {
/*  446 */     return this.inLove;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String func_70639_aQ() {
/*  455 */     if (func_70909_n()) {
/*      */       
/*  457 */       if (isAdult()) {
/*  458 */         return func_70880_s() ? "terrafirmacraft:mob.cat.purr" : ((this.field_70146_Z.nextInt(4) == 0) ? "terrafirmacraft:mob.cat.purreow" : "terrafirmacraft:mob.cat.meow");
/*      */       }
/*      */       
/*  461 */       return "terrafirmacraft:mob.kitten.meow";
/*      */     } 
/*      */     
/*  464 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfDaysToAdult() {
/*  471 */     return (int)(TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth * 12.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getObedienceMod() {
/*  477 */     return this.obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getPregnancyRequiredTime() {
/*  482 */     return this.pregnancyRequiredTime;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getSizeMod() {
/*  488 */     return this.sizeMod;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float func_70599_aP() {
/*  497 */     return 0.4F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getStrengthMod() {
/*  502 */     return this.strengthMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTameSkin() {
/*  507 */     return this.field_70180_af.func_75679_c(26);
/*      */   }
/*      */ 
/*      */   
/*      */   public void Hairball() {
/*  512 */     this.field_70170_p.func_72956_a((Entity)this, "terrafirmacraft:mob.cat.cough", 1.0F, 1.0F);
/*  513 */     ItemStack item = new ItemStack(TFCItems.wool, 1);
/*  514 */     func_70099_a(item, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleFamiliarityUpdate() {
/*  520 */     int totalDays = TFC_Time.getTotalDays();
/*  521 */     if (this.lastFamiliarityUpdate < totalDays)
/*      */     {
/*  523 */       if (this.familiarizedToday && this.familiarity < 100) {
/*      */         
/*  525 */         this.lastFamiliarityUpdate = totalDays;
/*  526 */         this.familiarizedToday = false;
/*  527 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/*  528 */         if (isAdult() && this.familiarity <= 35)
/*      */         {
/*  530 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*      */         }
/*  532 */         else if (!isAdult())
/*      */         {
/*  534 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/*  535 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/*  536 */           if (this.familiarity > 70)
/*      */           {
/*  538 */             this.obedienceMod *= 1.01F;
/*      */           }
/*      */         }
/*      */       
/*  542 */       } else if (this.familiarity < 30) {
/*      */         
/*  544 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/*  545 */         this.lastFamiliarityUpdate = totalDays;
/*      */       } 
/*      */     }
/*  548 */     if (this.familiarity > 100)
/*  549 */       this.familiarity = 100; 
/*  550 */     if (this.familiarity < 0) {
/*  551 */       this.familiarity = 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70085_c(EntityPlayer player) {
/*  560 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*      */     
/*  562 */     if (!this.field_70170_p.field_72995_K) {
/*      */       
/*  564 */       if (!this.aiTempt.func_75277_f() && player.func_70093_af() && func_70902_q() == null && canFamiliarize() && player.func_70068_e((Entity)this) < 9.0D) {
/*      */         
/*  566 */         familiarize(player);
/*  567 */         return true;
/*      */       } 
/*      */       
/*  570 */       if (player.func_70694_bm() != null) {
/*      */ 
/*      */         
/*  573 */         if (isFood(itemstack)) {
/*      */           
/*  575 */           Item item = itemstack.func_77973_b();
/*  576 */           if (item instanceof ItemFoodTFC && this.hunger <= 160000)
/*      */           {
/*  578 */             player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)item).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*  579 */             this.hunger += 24000;
/*  580 */             this.familiarity++;
/*  581 */             this.field_70170_p.func_72956_a((Entity)this, "terrafirmacraft:mob.cat.purr", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  582 */             return true;
/*      */           }
/*      */         
/*      */         } 
/*  586 */       } else if (func_70909_n()) {
/*      */         
/*  588 */         if (func_152114_e((EntityLivingBase)player)) {
/*      */           
/*  590 */           this.field_70911_d.func_75270_a(!func_70906_o());
/*      */           
/*  592 */           this.field_70703_bu = false;
/*  593 */           func_70778_a((PathEntity)null);
/*  594 */           func_70784_b((Entity)null);
/*  595 */           func_70624_b((EntityLivingBase)null);
/*  596 */           return true;
/*      */         } 
/*      */       } 
/*  599 */       if (getGender() == IAnimal.GenderEnum.FEMALE && this.pregnant) {
/*  600 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.pregnant", new Object[0]));
/*      */       }
/*  602 */       if (itemstack != null && isBreedingItemTFC(itemstack) && checkFamiliarity(IAnimal.InteractionEnum.BREED, player) && func_70874_b() == 0 && !func_70880_s() && (this.familiarizedToday || 
/*  603 */         !canFamiliarize())) {
/*      */         
/*  605 */         if (!player.field_71075_bZ.field_75098_d)
/*      */         {
/*  607 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, ((ItemFoodTFC)itemstack.func_77973_b()).onConsumedByEntity(player.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*      */         }
/*  609 */         this.hunger += 24000;
/*  610 */         func_146082_f(player);
/*  611 */         return true;
/*      */       } 
/*  613 */       if (this.familiarity > 20 && !func_70909_n()) {
/*      */         
/*  615 */         setFamiliarity(35);
/*  616 */         func_70903_f(true);
/*  617 */         setTameSkin(1 + this.field_70170_p.field_73012_v.nextInt(5));
/*  618 */         func_152115_b(player.func_110124_au().toString());
/*  619 */         func_70908_e(true);
/*  620 */         this.field_70170_p.func_72956_a((Entity)this, "terrafirmacraft:mob.cat.purr", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  621 */         this.field_70911_d.func_75270_a(true);
/*  622 */         this.field_70170_p.func_72960_a((Entity)this, (byte)7);
/*  623 */         return true;
/*      */       } 
/*  625 */       if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/*      */         
/*  627 */         if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player))
/*      */         {
/*  629 */           itemstack.field_77994_a--;
/*      */         }
/*  631 */         return true;
/*      */       } 
/*      */     } 
/*  634 */     return super.func_70085_c(player);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAdult() {
/*  641 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_70650_aV() {
/*  648 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70877_b(ItemStack par1ItemStack) {
/*  653 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isBreedingItemTFC(ItemStack item) {
/*  657 */     return (!this.pregnant && item.func_77973_b() == TFCItems.beefRaw);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isFood(ItemStack item) {
/*  662 */     return (item != null && item.func_77973_b() == TFCItems.fishRaw);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPregnant() {
/*  667 */     return this.pregnant;
/*      */   }
/*      */ 
/*      */   
/*      */   public void mate(IAnimal otherAnimal) {
/*  672 */     if (getGender() == IAnimal.GenderEnum.MALE) {
/*      */       
/*  674 */       otherAnimal.mate(this);
/*      */       return;
/*      */     } 
/*  677 */     this.timeOfConception = TFC_Time.getTotalTicks();
/*  678 */     this.pregnant = true;
/*  679 */     func_70875_t();
/*  680 */     otherAnimal.setInLove(false);
/*  681 */     setInLove(false);
/*  682 */     this.mateAggroMod = otherAnimal.getAggressionMod();
/*  683 */     this.mateObedMod = otherAnimal.getObedienceMod();
/*  684 */     this.mateSizeMod = otherAnimal.getSizeMod();
/*  685 */     this.mateStrengthMod = otherAnimal.getStrengthMod();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70636_d() {
/*  693 */     if (this.hunger > 168000)
/*  694 */       this.hunger = 168000; 
/*  695 */     if (this.hunger > 0) {
/*  696 */       this.hunger--;
/*      */     }
/*  698 */     if (func_70880_s()) {
/*      */       
/*  700 */       func_70875_t();
/*  701 */       setInLove(true);
/*      */     } 
/*      */     
/*  704 */     handleFamiliarityUpdate();
/*      */     
/*  706 */     syncData();
/*      */     
/*  708 */     if (isAdult()) {
/*      */       
/*  710 */       if (!this.adultTaskSet) {
/*  711 */         setAdultTasks();
/*  712 */         this.adultTaskSet = true;
/*      */       } 
/*  714 */       func_70873_a(0);
/*      */     }
/*      */     else {
/*      */       
/*  718 */       func_70873_a(-1);
/*      */     } 
/*      */     
/*  721 */     if (!this.field_70170_p.field_72995_K && (((this.field_70146_Z.nextInt(120000) == 0) ? 1 : 0) & func_70906_o()) != 0 && func_70909_n() && isAdult())
/*      */     {
/*  723 */       Hairball();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     if (!this.field_70170_p.field_72995_K && isPregnant())
/*      */     {
/*      */       
/*  732 */       if (TFC_Time.getTotalTicks() >= this.timeOfConception + this.pregnancyRequiredTime) {
/*      */         
/*  734 */         EntityOcelotTFC baby = (EntityOcelotTFC)createChildTFC((EntityAgeable)this);
/*  735 */         baby.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/*  736 */         this.field_70170_p.func_72838_d((Entity)baby);
/*  737 */         baby.setAge(TFC_Time.getTotalDays());
/*  738 */         baby.func_70903_f(true);
/*  739 */         baby.setTameSkin(getTameSkin());
/*  740 */         setKittenTasks(baby);
/*  741 */         this.pregnant = false;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  748 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*      */       
/*  750 */       func_70691_i(1.0F);
/*      */     }
/*  752 */     else if (this.hunger < 144000 && func_70880_s()) {
/*      */       
/*  754 */       setInLove(false);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  760 */     TFC_Core.preventEntityDataUpdate = true;
/*  761 */     super.func_70636_d();
/*  762 */     TFC_Core.preventEntityDataUpdate = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
/*  767 */     p_110161_1_ = super.func_110161_a(p_110161_1_);
/*      */     
/*  769 */     EntityOcelotTFC entityocelot = new EntityOcelotTFC(this.field_70170_p);
/*  770 */     entityocelot.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
/*  771 */     entityocelot.func_70873_a(-24000);
/*  772 */     this.field_70170_p.func_72838_d((Entity)entityocelot);
/*  773 */     return p_110161_1_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70037_a(NBTTagCompound nbt) {
/*  781 */     super.func_70037_a(nbt);
/*  782 */     this.animalID = nbt.func_74763_f("Animal ID");
/*  783 */     this.sex = nbt.func_74762_e("Sex");
/*  784 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*  785 */     this.adultTaskSet = nbt.func_74767_n("AdultTaskSet");
/*  786 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/*  787 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/*  788 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*  789 */     this.familiarity = nbt.func_74762_e("Familiarity");
/*  790 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/*  791 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*  792 */     this.field_70180_af.func_75692_b(26, Integer.valueOf(nbt.func_74762_e("CatType")));
/*  793 */     this.hunger = nbt.func_74762_e("Hunger");
/*  794 */     this.pregnant = nbt.func_74767_n("Pregnant");
/*  795 */     this.mateSizeMod = nbt.func_74760_g("MateSize");
/*  796 */     this.mateStrengthMod = nbt.func_74760_g("MateStrength");
/*  797 */     this.mateAggroMod = nbt.func_74760_g("MateAggro");
/*  798 */     this.mateObedMod = nbt.func_74760_g("MateObed");
/*  799 */     this.mateColor = nbt.func_74762_e("MateColor");
/*  800 */     this.timeOfConception = nbt.func_74763_f("ConceptionTime");
/*  801 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/*  802 */     setAge(nbt.func_74762_e("Age"));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAdultTasks() {
/*  808 */     func_70661_as().func_75491_a(true);
/*  809 */     this.field_70911_d = (EntityAISit)new EntityAISitTFC(this);
/*  810 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*  811 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)(this.aiTempt = new EntityAITempt((EntityCreature)this, 0.6D, TFCItems.fishRaw, false)));
/*  812 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityPlayer.class, 16.0F, 0.8D, 1.33D));
/*  813 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
/*  814 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.1D));
/*  815 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIOcelotSitTFC(this, 1.33D));
/*  816 */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILeapAtTarget((EntityLiving)this, 0.3F));
/*  817 */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIOcelotAttack((EntityLiving)this));
/*  818 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMateTFC(this, this.field_70170_p, 1.0F));
/*  819 */     this.field_70714_bg.func_75776_a(11, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8D));
/*  820 */     this.field_70714_bg.func_75776_a(12, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  821 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAITargetNonTamed(this, EntityChickenTFC.class, 750, true));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAge(int par1) {
/*  826 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAggressionMod(float aggressionMod) {
/*  832 */     this.aggressionMod = aggressionMod;
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
/*  843 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFamiliarity(int f) {
/*  850 */     this.familiarity = f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFearSource(Entity fearSource) {
/*  858 */     this.fearSource = fearSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70873_a(int par1) {
/*  865 */     if (!TFC_Core.preventEntityDataUpdate) {
/*  866 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*      */     }
/*      */   }
/*      */   
/*      */   public void setHunger(int h) {
/*  871 */     this.hunger = h;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInLove(boolean b) {
/*  877 */     this.inLove = b;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKittenTasks(EntityOcelotTFC entity) {
/*  883 */     entity.func_70661_as().func_75491_a(true);
/*  884 */     this.field_70911_d = (EntityAISit)new EntityAISitTFC(this);
/*  885 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)this.field_70911_d);
/*  886 */     entity.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.1D));
/*  887 */     entity.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 10.0F));
/*  888 */     entity.field_70911_d.func_75270_a(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setObedienceMod(float obedience) {
/*  893 */     this.obedienceMod = this.obedienceMod;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSizeMod(float size) {
/*  898 */     this.sizeMod = size;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrengthMod(float strength) {
/*  904 */     this.strengthMod = strength;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTameSkin(int skin) {
/*  909 */     this.field_70180_af.func_75692_b(26, Integer.valueOf(skin));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void syncData() {
/*  915 */     if (this.field_70180_af != null)
/*      */     {
/*  917 */       if (!this.field_70170_p.field_72995_K) {
/*      */         
/*  919 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*      */         
/*  921 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), (byte)(this.pregnant ? 1 : 0), 0 };
/*      */ 
/*      */         
/*  924 */         ByteBuffer buf = ByteBuffer.wrap(values);
/*  925 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/*  926 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/*  927 */         this.field_70180_af.func_75692_b(24, String.valueOf(this.timeOfConception));
/*  928 */         this.field_70180_af.func_75692_b(26, Integer.valueOf(getTameSkin()));
/*      */       }
/*      */       else {
/*      */         
/*  932 */         this.sex = this.field_70180_af.func_75679_c(13);
/*      */         
/*  934 */         ByteBuffer buf = ByteBuffer.allocate(8);
/*  935 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/*  936 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/*  937 */         byte[] values = buf.array();
/*      */         
/*  939 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/*  940 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/*  941 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/*  942 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*  943 */         setTameSkin(this.field_70180_af.func_75679_c(26));
/*  944 */         this.familiarity = values[4];
/*  945 */         this.familiarizedToday = (values[5] == 1);
/*  946 */         this.pregnant = (values[6] == 1);
/*      */ 
/*      */         
/*      */         try {
/*  950 */           this.timeOfConception = Long.parseLong(this.field_70180_af.func_75681_e(24));
/*  951 */         } catch (NumberFormatException numberFormatException) {}
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean trySetName(String name, EntityPlayer player) {
/*  959 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*      */       
/*  961 */       func_94058_c(name);
/*  962 */       return true;
/*      */     } 
/*  964 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/*  965 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70619_bc() {
/*  971 */     super.func_70619_bc();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70629_bd() {
/*  979 */     if (func_70605_aq().func_75640_a()) {
/*      */       
/*  981 */       double d0 = func_70605_aq().func_75638_b();
/*      */       
/*  983 */       if (d0 == 0.6D)
/*      */       {
/*  985 */         func_70095_a(true);
/*  986 */         func_70031_b(false);
/*      */       }
/*  988 */       else if (d0 == 1.33D)
/*      */       {
/*  990 */         func_70095_a(false);
/*  991 */         func_70031_b(true);
/*      */       }
/*      */       else
/*      */       {
/*  995 */         func_70095_a(false);
/*  996 */         func_70031_b(false);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1001 */       func_70095_a(false);
/* 1002 */       func_70031_b(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70014_b(NBTTagCompound nbt) {
/* 1012 */     super.func_70014_b(nbt);
/* 1013 */     nbt.func_74768_a("Sex", this.sex);
/* 1014 */     nbt.func_74772_a("Animal ID", this.animalID);
/* 1015 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/* 1016 */     nbt.func_74757_a("AdultTaskSet", this.adultTaskSet);
/* 1017 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 1018 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 1019 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/* 1020 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 1021 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 1022 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/* 1023 */     nbt.func_74768_a("CatType", this.field_70180_af.func_75679_c(26));
/* 1024 */     nbt.func_74768_a("Hunger", this.hunger);
/* 1025 */     nbt.func_74757_a("Pregnant", this.pregnant);
/* 1026 */     nbt.func_74776_a("MateSize", this.mateSizeMod);
/* 1027 */     nbt.func_74776_a("MateStrength", this.mateStrengthMod);
/* 1028 */     nbt.func_74776_a("MateAggro", this.mateAggroMod);
/* 1029 */     nbt.func_74776_a("MateObed", this.mateObedMod);
/* 1030 */     nbt.func_74768_a("MateColor", this.mateColor);
/* 1031 */     nbt.func_74772_a("ConceptionTime", this.timeOfConception);
/* 1032 */     nbt.func_74768_a("Age", getBirthDay());
/*      */   }
/*      */   
/*      */   public EnumDamageType getDamageType() {
/* 1036 */     return EnumDamageType.SLASHING;
/*      */   }
/*      */   
/*      */   public int getCrushArmor() {
/* 1040 */     return 250;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSlashArmor() {
/* 1045 */     return 250;
/*      */   }
/*      */   
/*      */   public int getPierceArmor() {
/* 1049 */     return -335;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityOcelotTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */