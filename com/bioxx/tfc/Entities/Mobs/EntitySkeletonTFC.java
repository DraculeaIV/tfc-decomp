/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ import com.bioxx.tfc.Entities.EntityJavelin;
/*     */ import com.bioxx.tfc.Entities.EntityProjectileTFC;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIFleeSun;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySkeletonTFC extends EntityMob implements IRangedAttackMob, ICausesDamage, IInnateArmor {
/*  35 */   private final EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 120, 15.0F);
/*  36 */   private final EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide((EntityCreature)this, EntityPlayer.class, 1.2D, false);
/*  37 */   private static final float[] ARMOR_PROBABILITY = new float[] { 0.0F, 0.5F, 0.1F, 0.15F };
/*     */ 
/*     */   
/*     */   public EntitySkeletonTFC(World par1World) {
/*  41 */     super(par1World);
/*  42 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  43 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIRestrictSun((EntityCreature)this));
/*  44 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIFleeSun((EntityCreature)this, 1.0D));
/*  45 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0D));
/*  46 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  47 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  48 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*  49 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
/*     */     
/*  51 */     if (par1World != null && !par1World.field_72995_K) {
/*  52 */       setCombatTask();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCombatTask() {
/*  57 */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiAttackOnCollide);
/*  58 */     this.field_70714_bg.func_85156_a((EntityAIBase)this.aiArrowAttack);
/*  59 */     ItemStack itemstack = func_70694_bm();
/*     */     
/*  61 */     if (itemstack != null && (itemstack.func_77973_b() == TFCItems.bow || itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin)) {
/*     */       
/*  63 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiArrowAttack);
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/*  71 */       this.field_70714_bg.func_75776_a(4, (EntityAIBase)this.aiAttackOnCollide);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70650_aV() {
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  90 */     return "mob.skeleton.say";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  99 */     return "mob.skeleton.hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/* 108 */     return "mob.skeleton.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_145780_a(int par1, int par2, int par3, Block par4) {
/* 117 */     func_85030_a("mob.skeleton.step", 0.15F, 1.0F);
/* 118 */     super.func_145780_a(par1, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 124 */     super.func_70037_a(par1NBTTagCompound);
/* 125 */     if (par1NBTTagCompound.func_74764_b("SkeletonType")) {
/*     */       
/* 127 */       byte b0 = par1NBTTagCompound.func_74771_c("SkeletonType");
/* 128 */       setSkeletonType(b0);
/*     */     } 
/* 130 */     setCombatTask();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 139 */     super.func_70014_b(par1NBTTagCompound);
/* 140 */     par1NBTTagCompound.func_74774_a("SkeletonType", (byte)getSkeletonType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 146 */     super.func_110147_ax();
/* 147 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0D);
/* 148 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/* 154 */     super.func_70088_a();
/* 155 */     this.field_70180_af.func_75682_a(13, Byte.valueOf((byte)this.field_70146_Z.nextInt(2)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70030_z() {
/* 161 */     super.func_70030_z();
/* 162 */     if (func_70027_ad()) {
/* 163 */       func_70097_a(DamageSource.field_76370_b, 50.0F);
/*     */     }
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
/*     */ 
/*     */   
/*     */   public EnumCreatureAttribute func_70668_bt() {
/* 178 */     return EnumCreatureAttribute.UNDEAD;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 184 */     if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
/*     */       
/* 186 */       float f = func_70013_c(1.0F);
/*     */       
/* 188 */       if (f > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) {
/*     */         
/* 190 */         boolean flag = true;
/* 191 */         ItemStack itemstack = func_71124_b(4);
/* 192 */         if (itemstack != null) {
/*     */           
/* 194 */           if (itemstack.func_77984_f()) {
/*     */             
/* 196 */             itemstack.func_77964_b(itemstack.func_77952_i() + this.field_70146_Z.nextInt(2));
/* 197 */             if (itemstack.func_77952_i() >= itemstack.func_77958_k()) {
/*     */               
/* 199 */               func_70669_a(itemstack);
/* 200 */               func_70062_b(4, (ItemStack)null);
/*     */             } 
/*     */           } 
/* 203 */           flag = false;
/*     */         } 
/*     */         
/* 206 */         if (flag) {
/* 207 */           func_70015_d(8);
/*     */         }
/*     */       } 
/*     */     } 
/* 211 */     if (this.field_70170_p.field_72995_K && getSkeletonType() == 1) {
/* 212 */       func_70105_a(0.72F, 2.34F);
/*     */     }
/* 214 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70098_U() {
/* 223 */     super.func_70098_U();
/* 224 */     if (this.field_70154_o instanceof EntityCreature) {
/*     */       
/* 226 */       EntityCreature entitycreature = (EntityCreature)this.field_70154_o;
/* 227 */       this.field_70761_aq = entitycreature.field_70761_aq;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/* 237 */     super.func_70645_a(par1DamageSource);
/* 238 */     if (par1DamageSource.func_76364_f() instanceof net.minecraft.entity.projectile.EntityArrow && par1DamageSource.func_76346_g() instanceof EntityPlayer) {
/*     */       
/* 240 */       EntityPlayer entityplayer = (EntityPlayer)par1DamageSource.func_76346_g();
/* 241 */       double d0 = entityplayer.field_70165_t - this.field_70165_t;
/* 242 */       double d1 = entityplayer.field_70161_v - this.field_70161_v;
/*     */       
/* 244 */       if (d0 * d0 + d1 * d1 >= 2500.0D) {
/* 245 */         entityplayer.func_71029_a((StatBase)AchievementList.field_76020_v);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 258 */     if (getSkeletonType() == 1) {
/*     */       
/* 260 */       if (func_70694_bm() != null && func_70694_bm().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin && this.field_70146_Z.nextFloat() < 0.03F) {
/* 261 */         func_145779_a(func_70694_bm().func_77973_b(), 1);
/*     */       
/*     */       }
/*     */     }
/* 265 */     else if (func_70694_bm() != null && func_70694_bm().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomBow) {
/*     */       
/* 267 */       int i = this.field_70146_Z.nextInt(3 + par2);
/* 268 */       func_145779_a(TFCItems.arrow, i);
/*     */     } 
/*     */ 
/*     */     
/* 272 */     int amnt = this.field_70146_Z.nextInt(3 + par2);
/* 273 */     func_145779_a(Items.field_151103_aS, amnt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70600_l(int par1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82160_b(boolean forceDrop, int dropChance) {
/* 284 */     for (int j = 0; j < (func_70035_c()).length; j++) {
/*     */       
/* 286 */       ItemStack itemstack = func_71124_b(j);
/* 287 */       boolean flag1 = (this.field_82174_bp[j] > 1.0F);
/*     */       
/* 289 */       if (itemstack != null && (forceDrop || flag1) && this.field_70146_Z.nextFloat() - dropChance * 0.01F < this.field_82174_bp[j]) {
/*     */         
/* 291 */         if (!flag1 && itemstack.func_77984_f()) {
/*     */           
/* 293 */           int k = Math.max(itemstack.func_77958_k() - 25, 1);
/* 294 */           int l = itemstack.func_77958_k() - this.field_70146_Z.nextInt(this.field_70146_Z.nextInt(k) + 1);
/*     */           
/* 296 */           if (l > k)
/*     */           {
/* 298 */             l = k;
/*     */           }
/*     */           
/* 301 */           if (l < 1)
/*     */           {
/* 303 */             l = 1;
/*     */           }
/*     */           
/* 306 */           itemstack.func_77964_b(l);
/*     */         } 
/*     */         
/* 309 */         func_70099_a(itemstack, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82164_bB() {
/* 317 */     superAddRandomArmor();
/* 318 */     if (getSkeletonType() == 0) {
/*     */       
/* 320 */       func_70062_b(0, new ItemStack(TFCItems.bow));
/*     */     }
/* 322 */     else if (getSkeletonType() == 1) {
/*     */       
/* 324 */       int i = this.field_70146_Z.nextInt(2);
/* 325 */       if (this.field_70146_Z.nextFloat() < 0.095F)
/* 326 */         i++; 
/* 327 */       if (this.field_70146_Z.nextFloat() < 0.095F)
/* 328 */         i++; 
/* 329 */       if (this.field_70146_Z.nextFloat() < 0.095F) {
/* 330 */         i++;
/*     */       }
/* 332 */       if (i == 0) {
/* 333 */         func_70062_b(0, new ItemStack(TFCItems.sedStoneJavelin));
/* 334 */       } else if (i == 1) {
/* 335 */         func_70062_b(0, new ItemStack(TFCItems.igExStoneJavelin));
/* 336 */       } else if (i == 2) {
/* 337 */         func_70062_b(0, new ItemStack(TFCItems.copperJavelin));
/* 338 */       } else if (i == 3) {
/* 339 */         func_70062_b(0, new ItemStack(TFCItems.bronzeJavelin));
/* 340 */       } else if (i == 4) {
/* 341 */         func_70062_b(0, new ItemStack(TFCItems.wroughtIronJavelin));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82162_bC() {}
/*     */ 
/*     */   
/*     */   public static Item getArmorItemForSlot(int par0, int par1) {
/* 352 */     switch (par0) {
/*     */       
/*     */       case 4:
/* 355 */         if (par1 == 0)
/* 356 */           return TFCItems.leatherHelmet; 
/* 357 */         if (par1 == 1)
/* 358 */           return TFCItems.copperHelmet; 
/* 359 */         if (par1 == 2)
/* 360 */           return TFCItems.bronzeHelmet; 
/* 361 */         if (par1 == 3)
/* 362 */           return TFCItems.wroughtIronHelmet; 
/* 363 */         if (par1 == 4) {
/* 364 */           return TFCItems.steelHelmet;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 406 */         return null;case 3: if (par1 == 0) return TFCItems.leatherChestplate;  if (par1 == 1) return TFCItems.copperChestplate;  if (par1 == 2) return TFCItems.bronzeChestplate;  if (par1 == 3) return TFCItems.wroughtIronChestplate;  if (par1 == 4) return TFCItems.steelChestplate;  return null;case 2: if (par1 == 0) return TFCItems.leatherLeggings;  if (par1 == 1) return TFCItems.copperGreaves;  if (par1 == 2) return TFCItems.bronzeGreaves;  if (par1 == 3) return TFCItems.wroughtIronGreaves;  if (par1 == 4) return TFCItems.steelGreaves;  return null;case 1: if (par1 == 0) return TFCItems.leatherBoots;  if (par1 == 1) return TFCItems.copperBoots;  if (par1 == 2) return TFCItems.bronzeBoots;  if (par1 == 3) return TFCItems.wroughtIronBoots;  if (par1 == 4) return TFCItems.steelBoots;  return null;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   private void superAddRandomArmor() {
/* 411 */     if (this.field_70146_Z.nextFloat() < ARMOR_PROBABILITY[this.field_70170_p.field_73013_u.func_151525_a()]) {
/*     */       
/* 413 */       int i = this.field_70146_Z.nextInt(2);
/* 414 */       float f = (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) ? 0.1F : 0.25F;
/*     */       
/* 416 */       if (this.field_70146_Z.nextFloat() < 0.095F)
/* 417 */         i++; 
/* 418 */       if (this.field_70146_Z.nextFloat() < 0.095F)
/* 419 */         i++; 
/* 420 */       if (this.field_70146_Z.nextFloat() < 0.095F) {
/* 421 */         i++;
/*     */       }
/* 423 */       for (int j = 3; j >= 0; j--) {
/*     */         
/* 425 */         ItemStack itemstack = func_71124_b(j);
/* 426 */         if (j < 3 && this.field_70146_Z.nextFloat() < f) {
/*     */           break;
/*     */         }
/* 429 */         if (itemstack == null) {
/*     */           
/* 431 */           Item item = getArmorItemForSlot(j + 1, i);
/* 432 */           if (item != null) {
/* 433 */             func_70062_b(j + 1, new ItemStack(item));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public IEntityLivingData func_110161_a(IEntityLivingData par1EntityLivingData) {
/* 442 */     par1EntityLivingData = super.func_110161_a(par1EntityLivingData);
/*     */     
/* 444 */     int skelType = this.field_70146_Z.nextInt(2);
/* 445 */     setSkeletonType(skelType);
/* 446 */     func_82164_bB();
/* 447 */     func_82162_bC();
/* 448 */     setCombatTask();
/* 449 */     func_98053_h((this.field_70146_Z.nextFloat() < 0.55F * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)));
/*     */     
/* 451 */     return par1EntityLivingData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82196_d(EntityLivingBase par1EntityLiving, float par2) {
/*     */     EntityJavelin entityJavelin;
/* 457 */     EntityProjectileTFC projectile = null;
/* 458 */     if (getSkeletonType() == 0) {
/*     */       
/* 460 */       projectile = new EntityProjectileTFC(this.field_70170_p, (EntityLivingBase)this, par1EntityLiving, 1.6F, 12.0F);
/* 461 */       projectile.func_70239_b(65.0D);
/*     */     }
/* 463 */     else if (getSkeletonType() == 1) {
/*     */       
/* 465 */       ItemStack is = func_70694_bm();
/* 466 */       if (is != null && is.func_77973_b() instanceof IProjectile) {
/*     */         
/* 468 */         entityJavelin = new EntityJavelin(this.field_70170_p, (EntityLivingBase)this, par1EntityLiving, 1.6F, 12.0F);
/* 469 */         double dam = ((IProjectile)is.func_77973_b()).getRangedDamage(is);
/* 470 */         entityJavelin.func_70239_b(dam);
/*     */       } 
/*     */     } 
/*     */     
/* 474 */     if (entityJavelin != null) {
/*     */       
/* 476 */       int var3 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, func_70694_bm());
/* 477 */       int var4 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, func_70694_bm());
/* 478 */       entityJavelin.func_70239_b(entityJavelin.func_70242_d() * 1.0D + this.field_70146_Z.nextGaussian() * 0.25D + (this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
/*     */       
/* 480 */       if (var3 > 0)
/* 481 */         entityJavelin.func_70239_b(entityJavelin.func_70242_d() + var3 * 0.5D); 
/* 482 */       if (var4 > 0)
/* 483 */         entityJavelin.func_70240_a(var4); 
/* 484 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, func_70694_bm()) > 0) {
/* 485 */         entityJavelin.func_70015_d(100);
/*     */       }
/* 487 */       this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0F, 1.0F / (func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 488 */       this.field_70170_p.func_72838_d((Entity)entityJavelin);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSkeletonType() {
/* 497 */     return this.field_70180_af.func_75683_a(13);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSkeletonType(int par1) {
/* 502 */     this.field_70180_af.func_75692_b(13, Byte.valueOf((byte)par1));
/* 503 */     func_70105_a(0.6F, 1.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 509 */     return EnumDamageType.PIERCING;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/* 514 */     return -335;
/*     */   }
/*     */   
/*     */   public int getSlashArmor() {
/* 518 */     return 1000;
/*     */   }
/*     */   
/*     */   public int getPierceArmor() {
/* 522 */     return 500000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/* 528 */     int x = MathHelper.func_76128_c(this.field_70165_t);
/* 529 */     int y = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/* 530 */     int z = MathHelper.func_76128_c(this.field_70161_v);
/* 531 */     Block b = this.field_70170_p.func_147439_a(x, y, z);
/*     */     
/* 533 */     if (b == TFCBlocks.leaves || b == TFCBlocks.leaves2 || b == TFCBlocks.thatch) {
/* 534 */       return false;
/*     */     }
/* 536 */     return super.func_70601_bi();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntitySkeletonTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */