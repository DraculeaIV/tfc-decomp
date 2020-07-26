/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIAvoidEntityTFC;
/*     */ import com.bioxx.tfc.Entities.AI.EntityAIFindNest;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.nio.ByteBuffer;
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
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAIPanic;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITempt;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityChicken;
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
/*     */ public class EntityChickenTFC extends EntityChicken implements IAnimal {
/*     */   private static final float DIMORPHISM = 0.0606F;
/*     */   private static final int DEGREE_OF_DIVERSION = 2;
/*  45 */   private final EntityAIEatGrass aiEatGrass = new EntityAIEatGrass((EntityLiving)this); protected static final int FAMILIARITY_CAP = 45; private static final int EGG_TIME = 24000;
/*     */   private int sex;
/*     */   private int hunger;
/*     */   private float sizeMod;
/*     */   private float strengthMod;
/*  50 */   private float aggressionMod = 1.0F;
/*     */   
/*  52 */   private float obedienceMod = 1.0F;
/*     */   
/*     */   private boolean inLove;
/*     */   
/*     */   private long nextEgg;
/*     */   
/*     */   private int familiarity;
/*     */   
/*     */   private long lastFamiliarityUpdate;
/*     */   
/*     */   private boolean familiarizedToday;
/*     */   
/*     */   public EntityChickenTFC(World par1World) {
/*  65 */     super(par1World);
/*  66 */     func_70105_a(0.3F, 0.7F);
/*  67 */     this.field_70887_j = 9999;
/*  68 */     this.nextEgg = TFC_Time.getTotalTicks() + 24000L;
/*  69 */     this.hunger = 168000;
/*  70 */     this.sex = this.field_70146_Z.nextInt(2);
/*     */     
/*  72 */     this.field_70714_bg.field_75782_a.clear();
/*  73 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  74 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4D));
/*  75 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.1D));
/*  76 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  77 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityChickenTFC.class, 6.0F));
/*  78 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntityTFC((EntityCreature)this, EntityWolfTFC.class, 8.0F, 0.5D, 0.699999988079071D));
/*  79 */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  80 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)this.aiEatGrass);
/*  81 */     addAI();
/*     */     
/*  83 */     this.sizeMod = (float)Math.sqrt((((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(30) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F) * (1.0F - 0.0606F * this.sex)));
/*  84 */     this.strengthMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + this.sizeMod));
/*  85 */     this.aggressionMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F));
/*  86 */     this.obedienceMod = (float)Math.sqrt(((this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(20) + 1) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) * 0.01F + 1.0F / this.aggressionMod));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     setAge(TFC_Time.getTotalDays() - getNumberOfDaysToAdult());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityChickenTFC(World world, double posX, double posY, double posZ, NBTTagCompound genes) {
/* 100 */     this(world);
/* 101 */     this.field_70165_t = posX;
/* 102 */     this.field_70163_u = posY;
/* 103 */     this.field_70161_v = posZ;
/* 104 */     float motherSize = genes.func_74760_g("m_size");
/* 105 */     float fatherSize = genes.func_74760_g("f_size");
/* 106 */     this.sizeMod = ((this.field_70146_Z.nextInt(3) * (this.field_70146_Z.nextBoolean() ? 1 : -1)) / 10.0F + 1.0F) * (1.0F - 0.1F * this.sex) * (float)Math.sqrt(((motherSize + fatherSize) / 1.9F));
/*     */ 
/*     */     
/* 109 */     setAge(TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAI() {
/* 114 */     if (this.sex == 0)
/*     */     {
/* 116 */       this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
/*     */     }
/* 118 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.wheatGrain, false));
/* 119 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.ryeGrain, false));
/* 120 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.riceGrain, false));
/* 121 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.barleyGrain, false));
/* 122 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.oatGrain, false));
/* 123 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.2000000476837158D, TFCItems.maizeEar, false));
/* 124 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFindNest((EntityAnimal)this, 1.2000000476837158D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 130 */     super.func_110147_ax();
/* 131 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canFamiliarize() {
/* 137 */     return (!isAdult() || (isAdult() && this.familiarity <= 45));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 143 */     return (animal.getGender() != getGender() && isAdult() && animal.isAdult() && animal
/* 144 */       .getAnimalTypeID() == getAnimalTypeID());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 149 */     boolean flag = false;
/* 150 */     switch (interaction) {
/*     */       case NAME:
/* 152 */         flag = (this.familiarity > 50);
/*     */         break;
/*     */     } 
/*     */     
/* 156 */     if (!flag && player != null && !player.field_70170_p.field_72995_K) {
/* 157 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 159 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityChicken func_90011_a(EntityAgeable entityAgeable) {
/* 165 */     return (EntityChicken)createChildTFC(entityAgeable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable entityageable) {
/* 172 */     if (entityageable instanceof IAnimal) {
/*     */       
/* 174 */       IAnimal animal = (IAnimal)entityageable;
/* 175 */       NBTTagCompound nbt = new NBTTagCompound();
/* 176 */       nbt.func_74776_a("m_size", animal.getSizeMod());
/* 177 */       nbt.func_74776_a("f_size", animal.getSizeMod());
/* 178 */       return (EntityAgeable)new EntityChickenTFC(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, nbt);
/*     */     } 
/*     */     
/* 181 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 190 */     float ageMod = TFC_Core.getPercentGrown(this);
/* 191 */     func_145779_a(Items.field_151008_G, (int)(ageMod * this.sizeMod * (5 + this.field_70146_Z.nextInt(10))));
/*     */     
/* 193 */     if (isAdult()) {
/*     */       
/* 195 */       float foodWeight = ageMod * this.sizeMod * 40.0F;
/* 196 */       TFC_Core.animalDropMeat((Entity)this, TFCItems.chickenRaw, foodWeight);
/* 197 */       func_145779_a(Items.field_151103_aS, this.field_70146_Z.nextInt(2) + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 204 */     super.func_70088_a();
/* 205 */     this.field_70180_af.func_75682_a(13, Integer.valueOf(0));
/* 206 */     this.field_70180_af.func_75682_a(15, Integer.valueOf(0));
/*     */     
/* 208 */     this.field_70180_af.func_75682_a(22, Integer.valueOf(0));
/* 209 */     this.field_70180_af.func_75682_a(23, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void familiarize(EntityPlayer ep) {
/* 214 */     ItemStack stack = ep.func_70694_bm();
/* 215 */     if (stack != null && isFood(stack) && !this.familiarizedToday && canFamiliarize()) {
/*     */       
/* 217 */       if (!ep.field_71075_bZ.field_75098_d) {
/*     */         
/* 219 */         ep.field_71071_by.func_70299_a(ep.field_71071_by.field_70461_c, ((ItemFoodTFC)stack.func_77973_b()).onConsumedByEntity(ep.func_70694_bm(), this.field_70170_p, (EntityLivingBase)this));
/*     */       }
/*     */       else {
/*     */         
/* 223 */         this.field_70170_p.func_72956_a((Entity)this, "random.burp", 0.5F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/* 225 */       this.hunger += 24000;
/* 226 */       this.familiarizedToday = true;
/* 227 */       func_70671_ap().func_75651_a((Entity)ep, 0.0F, 0.0F);
/* 228 */       func_70642_aH();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAggressionMod() {
/* 235 */     return this.aggressionMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 241 */     return Helper.stringToInt("chicken");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getAttackedVec() {
/* 247 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBirthDay() {
/* 253 */     return this.field_70180_af.func_75679_c(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/* 262 */     return Items.field_151008_G;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDueDay() {
/* 268 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getEggs() {
/* 273 */     if (TFC_Time.getTotalTicks() >= this.nextEgg) {
/*     */       
/* 275 */       this.nextEgg = TFC_Time.getTotalTicks() + 24000L;
/* 276 */       return new ItemStack(TFCItems.egg, 1);
/*     */     } 
/* 278 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityLiving getEntity() {
/* 284 */     return (EntityLiving)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFamiliarity() {
/* 289 */     return this.familiarity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFamiliarizedToday() {
/* 295 */     return this.familiarizedToday;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getFearSource() {
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IAnimal.GenderEnum getGender() {
/* 307 */     return IAnimal.GenderEnum.GENDERS[this.field_70180_af.func_75679_c(13)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHunger() {
/* 313 */     return this.hunger;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInLove() {
/* 319 */     return this.inLove;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLastFamiliarityUpdate() {
/* 324 */     return this.lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getNextEgg() {
/* 329 */     return this.nextEgg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfDaysToAdult() {
/* 335 */     return (int)((TFCOptions.animalTimeMultiplier * TFC_Time.daysInMonth) * 4.14D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getObedienceMod() {
/* 341 */     return this.obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSex() {
/* 346 */     return this.sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSizeMod() {
/* 352 */     return this.sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getStrengthMod() {
/* 358 */     return this.strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleFamiliarityUpdate() {
/* 363 */     int totalDays = TFC_Time.getTotalDays();
/* 364 */     if (this.lastFamiliarityUpdate < totalDays) {
/* 365 */       if (this.familiarizedToday && this.familiarity < 100) {
/* 366 */         this.lastFamiliarityUpdate = totalDays;
/* 367 */         this.familiarizedToday = false;
/* 368 */         float familiarityChange = 6.0F * this.obedienceMod / this.aggressionMod;
/* 369 */         if (isAdult() && this.familiarity <= 45) {
/*     */           
/* 371 */           this.familiarity = (int)(this.familiarity + familiarityChange);
/*     */         }
/* 373 */         else if (!isAdult()) {
/* 374 */           float ageMod = 2.0F / (1.0F + TFC_Core.getPercentGrown(this));
/* 375 */           this.familiarity = (int)(this.familiarity + ageMod * familiarityChange);
/* 376 */           if (this.familiarity > 70) {
/* 377 */             this.obedienceMod *= 1.01F;
/*     */           }
/*     */         }
/*     */       
/* 381 */       } else if (this.familiarity < 30) {
/* 382 */         this.familiarity = (int)(this.familiarity - 2L * (TFC_Time.getTotalDays() - this.lastFamiliarityUpdate));
/* 383 */         this.lastFamiliarityUpdate = totalDays;
/*     */       } 
/*     */     }
/* 386 */     if (this.familiarity > 100) this.familiarity = 100; 
/* 387 */     if (this.familiarity < 0) this.familiarity = 0;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer player) {
/* 396 */     ItemStack itemstack = player.func_70694_bm();
/*     */     
/* 398 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/* 400 */       if (isAdult() && player.func_70093_af() && !isFood(itemstack) && func_70097_a(DamageSource.field_76377_j, 5.0F)) {
/*     */         
/* 402 */         player.field_71071_by.func_70441_a(new ItemStack(Items.field_151008_G, 1));
/* 403 */         this.familiarity -= 4;
/* 404 */         return true;
/*     */       } 
/*     */       
/* 407 */       if (player.func_70093_af() && !this.familiarizedToday && canFamiliarize()) {
/*     */         
/* 409 */         familiarize(player);
/* 410 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 414 */     if (itemstack != null && itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemCustomNameTag && itemstack.func_77942_o() && itemstack.field_77990_d.func_74764_b("ItemName")) {
/* 415 */       if (trySetName(itemstack.field_77990_d.func_74779_i("ItemName"), player)) {
/* 416 */         itemstack.field_77994_a--;
/*     */       }
/* 418 */       return true;
/*     */     } 
/* 420 */     return super.func_70085_c(player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAdult() {
/* 426 */     return (getBirthDay() + getNumberOfDaysToAdult() <= TFC_Time.getTotalDays());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/* 435 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70877_b(ItemStack par1ItemStack) {
/* 445 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70631_g_() {
/* 451 */     return !isAdult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFood(ItemStack item) {
/* 456 */     return (item != null && (item.func_77973_b() == TFCItems.wheatGrain || item.func_77973_b() == TFCItems.oatGrain || item.func_77973_b() == TFCItems.riceGrain || item
/* 457 */       .func_77973_b() == TFCItems.barleyGrain || item.func_77973_b() == TFCItems.ryeGrain || item.func_77973_b() == TFCItems.maizeEar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPregnant() {
/* 463 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mate(IAnimal otherAnimal) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 479 */     if (this.hunger > 168000)
/*     */     {
/* 481 */       this.hunger = 168000;
/*     */     }
/* 483 */     if (this.hunger > 0)
/*     */     {
/* 485 */       this.hunger--;
/*     */     }
/*     */     
/* 488 */     syncData();
/* 489 */     if (isAdult()) {
/*     */       
/* 491 */       func_70873_a(0);
/*     */     }
/*     */     else {
/*     */       
/* 495 */       func_70873_a(-1);
/*     */     } 
/*     */     
/* 498 */     roosterCrow();
/* 499 */     handleFamiliarityUpdate();
/*     */ 
/*     */     
/* 502 */     this.field_70887_j = 9999;
/*     */ 
/*     */ 
/*     */     
/* 506 */     TFC_Core.preventEntityDataUpdate = true;
/* 507 */     if (getGender() == IAnimal.GenderEnum.MALE)
/*     */     {
/* 509 */       this.nextEgg = 10000L;
/*     */     }
/*     */     
/* 512 */     super.func_70636_d();
/* 513 */     TFC_Core.preventEntityDataUpdate = false;
/*     */     
/* 515 */     if (this.hunger > 144000 && this.field_70146_Z.nextInt(100) == 0 && func_110143_aJ() < TFC_Core.getEntityMaxHealth((EntityLivingBase)this) && !this.field_70128_L) {
/*     */       
/* 517 */       func_70691_i(1.0F);
/*     */     }
/* 519 */     else if (this.hunger < 144000 && func_70880_s()) {
/* 520 */       setInLove(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 530 */     super.func_70037_a(nbt);
/* 531 */     this.sex = nbt.func_74762_e("Sex");
/* 532 */     this.sizeMod = nbt.func_74760_g("Size Modifier");
/*     */     
/* 534 */     this.familiarity = nbt.func_74762_e("Familiarity");
/* 535 */     this.lastFamiliarityUpdate = nbt.func_74763_f("lastFamUpdate");
/* 536 */     this.familiarizedToday = nbt.func_74767_n("Familiarized Today");
/*     */     
/* 538 */     this.strengthMod = nbt.func_74760_g("Strength Modifier");
/* 539 */     this.aggressionMod = nbt.func_74760_g("Aggression Modifier");
/* 540 */     this.obedienceMod = nbt.func_74760_g("Obedience Modifier");
/*     */     
/* 542 */     this.hunger = nbt.func_74762_e("Hunger");
/* 543 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(nbt.func_74762_e("Age")));
/* 544 */     this.nextEgg = nbt.func_74763_f("nextEgg");
/*     */   }
/*     */ 
/*     */   
/*     */   public void roosterCrow() {
/* 549 */     if ((TFC_Time.getTotalTicks() - 15L) % 24000L == 0L && getGender() == IAnimal.GenderEnum.MALE && isAdult() && this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
/* 550 */       func_85030_a("terrafirmacraft:mob.rooster.cry", 6.0F, this.field_70146_Z.nextFloat() / 2.0F + 0.75F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAge(int par1) {
/* 557 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAggressionMod(float aggressionMod) {
/* 563 */     this.aggressionMod = aggressionMod;
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
/* 574 */     this.field_70180_af.func_75692_b(15, Integer.valueOf(day));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamiliarity(int familiarity) {
/* 580 */     this.familiarity = familiarity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFamiliarizedToday(boolean familiarizedToday) {
/* 585 */     this.familiarizedToday = familiarizedToday;
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
/* 596 */     if (!TFC_Core.preventEntityDataUpdate) {
/* 597 */       this.field_70180_af.func_75692_b(12, Integer.valueOf(par1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHunger(int h) {
/* 603 */     this.hunger = h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInLove(boolean b) {
/* 609 */     this.inLove = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLastFamiliarityUpdate(long lastFamiliarityUpdate) {
/* 614 */     this.lastFamiliarityUpdate = lastFamiliarityUpdate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNextEgg(long nextEgg) {
/* 619 */     this.nextEgg = nextEgg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObedienceMod(float obedienceMod) {
/* 625 */     this.obedienceMod = obedienceMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSex(int sex) {
/* 630 */     this.sex = sex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSizeMod(float sizeMod) {
/* 636 */     this.sizeMod = sizeMod;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrengthMod(float strengthMod) {
/* 642 */     this.strengthMod = strengthMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/* 647 */     if (this.field_70180_af != null)
/*     */     {
/* 649 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 651 */         this.field_70180_af.func_75692_b(13, Integer.valueOf(this.sex));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 657 */         byte[] values = { TFC_Core.getByteFromSmallFloat(this.sizeMod), TFC_Core.getByteFromSmallFloat(this.strengthMod), TFC_Core.getByteFromSmallFloat(this.aggressionMod), TFC_Core.getByteFromSmallFloat(this.obedienceMod), (byte)this.familiarity, (byte)(this.familiarizedToday ? 1 : 0), 0, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 663 */         ByteBuffer buf = ByteBuffer.wrap(values);
/* 664 */         this.field_70180_af.func_75692_b(22, Integer.valueOf(buf.getInt()));
/* 665 */         this.field_70180_af.func_75692_b(23, Integer.valueOf(buf.getInt()));
/*     */       }
/*     */       else {
/*     */         
/* 669 */         this.sex = this.field_70180_af.func_75679_c(13);
/*     */         
/* 671 */         ByteBuffer buf = ByteBuffer.allocate(8);
/* 672 */         buf.putInt(this.field_70180_af.func_75679_c(22));
/* 673 */         buf.putInt(this.field_70180_af.func_75679_c(23));
/* 674 */         byte[] values = buf.array();
/*     */         
/* 676 */         this.sizeMod = TFC_Core.getSmallFloatFromByte(values[0]);
/* 677 */         this.strengthMod = TFC_Core.getSmallFloatFromByte(values[1]);
/* 678 */         this.aggressionMod = TFC_Core.getSmallFloatFromByte(values[2]);
/* 679 */         this.obedienceMod = TFC_Core.getSmallFloatFromByte(values[3]);
/*     */         
/* 681 */         this.familiarity = values[4];
/* 682 */         this.familiarizedToday = (values[5] == 1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 689 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 691 */       func_94058_c(name);
/* 692 */       return true;
/*     */     } 
/* 694 */     func_85030_a(func_70621_aR(), 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 695 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 704 */     super.func_70014_b(nbt);
/* 705 */     nbt.func_74768_a("Sex", this.sex);
/* 706 */     nbt.func_74776_a("Size Modifier", this.sizeMod);
/*     */     
/* 708 */     nbt.func_74768_a("Familiarity", this.familiarity);
/* 709 */     nbt.func_74772_a("lastFamUpdate", this.lastFamiliarityUpdate);
/* 710 */     nbt.func_74757_a("Familiarized Today", this.familiarizedToday);
/*     */     
/* 712 */     nbt.func_74776_a("Strength Modifier", this.strengthMod);
/* 713 */     nbt.func_74776_a("Aggression Modifier", this.aggressionMod);
/* 714 */     nbt.func_74776_a("Obedience Modifier", this.obedienceMod);
/*     */     
/* 716 */     nbt.func_74768_a("Hunger", this.hunger);
/* 717 */     nbt.func_74768_a("Age", getBirthDay());
/* 718 */     nbt.func_74772_a("nextEgg", this.nextEgg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityChickenTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */