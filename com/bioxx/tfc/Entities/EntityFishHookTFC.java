/*     */ package com.bioxx.tfc.Entities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityFishTFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityFishHook;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityFishHookTFC
/*     */   extends EntityFishHook
/*     */ {
/*     */   private int xTile;
/*     */   private int yTile;
/*     */   private int zTile;
/*     */   private Block inTile;
/*     */   private boolean inGround;
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*     */   private int ticksCatchable;
/*     */   private int fishPosRotationIncrements;
/*     */   private double fishX;
/*     */   private double fishY;
/*     */   private double fishZ;
/*     */   private double fishYaw;
/*     */   private double fishPitch;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityX;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityY;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityZ;
/*  58 */   private double maxDistance = -1.0D;
/*     */   
/*     */   private boolean canCatchFish;
/*     */   
/*     */   public double pullX;
/*     */   
/*     */   public double pullY;
/*     */   
/*     */   public double pullZ;
/*     */   private int lineTension;
/*     */   private static final int MAX_LINE_TENSION = 800;
/*     */   private int reelCounter;
/*     */   private int lastCheckTick;
/*     */   private boolean lineTensionSnap;
/*     */   
/*     */   public EntityFishHookTFC(World par1World) {
/*  74 */     super(par1World);
/*  75 */     this.xTile = -1;
/*  76 */     this.yTile = -1;
/*  77 */     this.zTile = -1;
/*  78 */     func_70105_a(0.25F, 0.25F);
/*  79 */     this.field_70158_ak = true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityFishHookTFC(World par1World, double par2, double par4, double par6, EntityPlayer par8EntityPlayer) {
/*  85 */     this(par1World);
/*  86 */     func_70107_b(par2, par4, par6);
/*  87 */     this.field_70158_ak = true;
/*  88 */     this.field_146042_b = par8EntityPlayer;
/*  89 */     par8EntityPlayer.field_71104_cf = this;
/*     */   }
/*     */   
/*     */   public double getMaxDistance() {
/*  93 */     return this.maxDistance;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityFishHookTFC(World par1World, EntityPlayer par2EntityPlayer) {
/*  98 */     super(par1World);
/*  99 */     this.xTile = -1;
/* 100 */     this.yTile = -1;
/* 101 */     this.zTile = -1;
/* 102 */     this.field_70158_ak = true;
/* 103 */     this.field_146042_b = par2EntityPlayer;
/* 104 */     this.field_146042_b.field_71104_cf = this;
/* 105 */     func_70105_a(0.25F, 0.25F);
/* 106 */     func_70012_b(par2EntityPlayer.field_70165_t, par2EntityPlayer.field_70163_u + 1.62D - par2EntityPlayer.field_70129_M, par2EntityPlayer.field_70161_v, par2EntityPlayer.field_70177_z, par2EntityPlayer.field_70125_A);
/* 107 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 108 */     this.field_70163_u -= 0.10000000149011612D;
/* 109 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 110 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 111 */     this.field_70129_M = 0.0F;
/* 112 */     float f = 0.4F;
/* 113 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 114 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 115 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 116 */     func_146035_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityFishHookTFC(World par1World, EntityPlayer par2EntityPlayer, int ticks) {
/* 121 */     super(par1World);
/* 122 */     this.xTile = -1;
/* 123 */     this.yTile = -1;
/* 124 */     this.zTile = -1;
/* 125 */     this.field_70158_ak = true;
/* 126 */     this.field_146042_b = par2EntityPlayer;
/* 127 */     this.field_146042_b.field_71104_cf = this;
/* 128 */     func_70105_a(0.25F, 0.25F);
/* 129 */     func_70012_b(par2EntityPlayer.field_70165_t, par2EntityPlayer.field_70163_u + 1.62D - par2EntityPlayer.field_70129_M, par2EntityPlayer.field_70161_v, par2EntityPlayer.field_70177_z, par2EntityPlayer.field_70125_A);
/* 130 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 131 */     this.field_70163_u -= 0.10000000149011612D;
/* 132 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/* 133 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 134 */     this.field_70129_M = 0.0F;
/* 135 */     float f = 0.4F;
/* 136 */     float tickRatio = Math.min(ticks, 60) / 20.0F;
/* 137 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 138 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 139 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * f);
/* 140 */     func_146035_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, tickRatio, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double par1) {
/* 155 */     double d1 = this.field_70121_D.func_72320_b() * 4.0D;
/* 156 */     d1 *= 64.0D;
/* 157 */     return (par1 < d1 * d1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146035_c(double par1, double par3, double par5, float par7, float par8) {
/* 163 */     float f2 = MathHelper.func_76133_a(par1 * par1 + par3 * par3 + par5 * par5);
/* 164 */     par1 /= f2;
/* 165 */     par3 /= f2;
/* 166 */     par5 /= f2;
/* 167 */     par1 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 168 */     par3 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 169 */     par5 += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * par8;
/* 170 */     par1 *= par7;
/* 171 */     par3 *= par7;
/* 172 */     par5 *= par7;
/* 173 */     this.field_70159_w = par1;
/* 174 */     this.field_70181_x = par3;
/* 175 */     this.field_70179_y = par5;
/* 176 */     float f3 = MathHelper.func_76133_a(par1 * par1 + par5 * par5);
/* 177 */     this.field_70126_B = this.field_70177_z = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
/* 178 */     this.field_70127_C = this.field_70125_A = (float)(Math.atan2(par3, f3) * 180.0D / Math.PI);
/* 179 */     this.ticksInGround = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 191 */     this.fishX = par1;
/* 192 */     this.fishY = par3;
/* 193 */     this.fishZ = par5;
/* 194 */     this.fishYaw = par7;
/* 195 */     this.fishPitch = par8;
/* 196 */     this.fishPosRotationIncrements = par9;
/* 197 */     this.field_70159_w = this.velocityX;
/* 198 */     this.field_70181_x = this.velocityY;
/* 199 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 210 */     this.velocityX = this.field_70159_w = par1;
/* 211 */     this.velocityY = this.field_70181_x = par3;
/* 212 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 221 */     func_70030_z();
/*     */     
/* 223 */     if (func_70032_d((Entity)this.field_146042_b) < 1.0F) {
/* 224 */       func_70106_y();
/* 225 */       if (this.field_146042_b.func_70694_bm() != null) {
/* 226 */         ItemStack itemstack = this.field_146042_b.func_70694_bm();
/* 227 */         if (itemstack.field_77990_d == null) {
/* 228 */           itemstack.field_77990_d = new NBTTagCompound();
/*     */         }
/* 230 */         itemstack.field_77990_d.func_74772_a("tickReeledIn", TFC_Time.getTotalTicks());
/*     */       } 
/*     */     } 
/*     */     
/* 234 */     if (this.fishPosRotationIncrements > 0) {
/*     */       
/* 236 */       double d0 = this.field_70165_t + (this.fishX - this.field_70165_t) / this.fishPosRotationIncrements;
/* 237 */       double d1 = this.field_70163_u + (this.fishY - this.field_70163_u) / this.fishPosRotationIncrements;
/* 238 */       double d2 = this.field_70161_v + (this.fishZ - this.field_70161_v) / this.fishPosRotationIncrements;
/* 239 */       double d3 = MathHelper.func_76138_g(this.fishYaw - this.field_70177_z);
/* 240 */       this.field_70177_z = (float)(this.field_70177_z + d3 / this.fishPosRotationIncrements);
/* 241 */       this.field_70125_A = (float)(this.field_70125_A + (this.fishPitch - this.field_70125_A) / this.fishPosRotationIncrements);
/* 242 */       this.fishPosRotationIncrements--;
/* 243 */       func_70107_b(d0, d1, d2);
/* 244 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     }
/*     */     else {
/*     */       
/* 248 */       if (!this.field_70170_p.field_72995_K) {
/*     */         
/* 250 */         ItemStack itemstack = this.field_146042_b.func_71045_bC();
/*     */         
/* 252 */         if (this.field_146042_b.field_70128_L || !this.field_146042_b.func_70089_S() || itemstack == null || !(itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomFishingRod) || func_70068_e((Entity)this.field_146042_b) > 2500.0D) {
/*     */           
/* 254 */           func_70106_y();
/* 255 */           this.field_146042_b.field_71104_cf = null;
/*     */           
/*     */           return;
/*     */         } 
/* 259 */         if (this.field_146043_c != null) {
/*     */           
/* 261 */           if (!this.field_146043_c.field_70128_L) {
/*     */             
/* 263 */             this.field_70165_t = this.field_146043_c.field_70165_t;
/* 264 */             this.field_70163_u = this.field_146043_c.field_70121_D.field_72338_b + this.field_146043_c.field_70131_O * 0.8D;
/* 265 */             this.field_70161_v = this.field_146043_c.field_70161_v;
/*     */             return;
/*     */           } 
/* 268 */           this.field_146043_c = null;
/*     */         } 
/*     */       } 
/*     */       
/* 272 */       if (this.field_146044_a > 0)
/*     */       {
/* 274 */         this.field_146044_a--;
/*     */       }
/*     */       
/* 277 */       if (this.inGround) {
/*     */         
/* 279 */         if (this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile) == this.inTile) {
/*     */           
/* 281 */           this.ticksInGround++;
/* 282 */           if (this.ticksInGround == 1200) {
/* 283 */             func_70106_y();
/*     */           }
/*     */           return;
/*     */         } 
/* 287 */         this.inGround = false;
/* 288 */         this.field_70159_w *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 289 */         this.field_70181_x *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 290 */         this.field_70179_y *= (this.field_70146_Z.nextFloat() * 0.2F);
/* 291 */         this.ticksInGround = 0;
/* 292 */         this.ticksInAir = 0;
/*     */       }
/*     */       else {
/*     */         
/* 296 */         this.ticksInAir++;
/*     */       } 
/*     */       
/* 299 */       Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 300 */       Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 301 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
/* 302 */       vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 303 */       vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 305 */       if (movingobjectposition != null) {
/* 306 */         vec31 = Vec3.func_72443_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/* 308 */       Entity entity = null;
/* 309 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 310 */       double d4 = 0.0D;
/*     */ 
/*     */       
/* 313 */       for (int j = 0; j < list.size(); j++) {
/*     */         
/* 315 */         Entity entity1 = list.get(j);
/* 316 */         if (entity1.func_70067_L() && (entity1 != this.field_146042_b || this.ticksInAir >= 5)) {
/*     */           
/* 318 */           float f = 0.3F;
/* 319 */           AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f, f, f);
/* 320 */           MovingObjectPosition movingobjectposition1 = axisalignedbb.func_72327_a(vec3, vec31);
/* 321 */           if (movingobjectposition1 != null) {
/*     */             
/* 323 */             double d5 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/* 324 */             if (d5 < d4 || d4 == 0.0D) {
/*     */               
/* 326 */               entity = entity1;
/* 327 */               d4 = d5;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 333 */       if (entity != null) {
/* 334 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/* 336 */       if (movingobjectposition != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 343 */         if (movingobjectposition.field_72308_g == null)
/*     */         {
/* 345 */           this.inGround = true;
/*     */         }
/*     */       }
/*     */       
/* 349 */       if (!this.inGround) {
/*     */         
/* 351 */         func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 352 */         float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 353 */         this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / Math.PI);
/*     */         
/* 355 */         for (this.field_70125_A = (float)(Math.atan2(this.field_70181_x, f1) * 180.0D / Math.PI); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F);
/*     */ 
/*     */         
/* 358 */         while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 359 */           this.field_70127_C += 360.0F;
/*     */         }
/* 361 */         while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 362 */           this.field_70126_B -= 360.0F;
/*     */         }
/* 364 */         while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 365 */           this.field_70126_B += 360.0F;
/*     */         }
/* 367 */         this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
/* 368 */         this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
/* 369 */         float f2 = 0.92F;
/*     */         
/* 371 */         if (this.field_70122_E || this.field_70123_F) {
/* 372 */           f2 = 0.5F;
/*     */         }
/* 374 */         byte b0 = 5;
/* 375 */         double d6 = 0.0D;
/*     */         
/* 377 */         for (int k = 0; k < b0; k++) {
/*     */           
/* 379 */           double d7 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (k + 0) / b0 - 0.125D + 0.125D;
/* 380 */           double d8 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (k + 1) / b0 - 0.125D + 0.125D;
/* 381 */           AxisAlignedBB axisalignedbb1 = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d7, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d8, this.field_70121_D.field_72334_f);
/*     */           
/* 383 */           if (this.field_70170_p.func_72830_b(axisalignedbb1, Material.field_151586_h)) {
/* 384 */             d6 += 1.0D / b0;
/*     */           }
/*     */         } 
/* 387 */         if (this.ticksCatchable > 0) {
/* 388 */           this.field_70181_x -= (this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat()) * 0.2D;
/*     */         }
/* 390 */         double d5 = d6 * 2.0D - 1.0D;
/* 391 */         this.field_70181_x += 0.03999999910593033D * d5;
/*     */         
/* 393 */         if (d6 > 0.0D) {
/*     */           
/* 395 */           if (this.maxDistance == -1.0D) {
/* 396 */             this.maxDistance = func_70032_d((Entity)this.field_146042_b);
/* 397 */             this.canCatchFish = true;
/*     */           } 
/* 399 */           if (this.canCatchFish && !this.field_70170_p.field_72995_K) {
/* 400 */             attemptToCatch();
/*     */           }
/* 402 */           f2 = (float)(f2 * 0.9D);
/* 403 */           this.field_70181_x *= 0.8D;
/*     */         } 
/*     */         
/* 406 */         this.field_70159_w *= f2;
/* 407 */         this.field_70181_x *= f2;
/* 408 */         this.field_70179_y *= f2;
/*     */         
/* 410 */         double distance = func_70032_d((Entity)this.field_146042_b);
/* 411 */         if (distance > this.maxDistance && this.maxDistance != -1.0D) {
/* 412 */           Vec3 distVec = Vec3.func_72443_a(this.field_70165_t - this.field_146042_b.field_70165_t, this.field_70163_u - this.field_146042_b.field_70163_u, this.field_70161_v - this.field_146042_b.field_70161_v);
/* 413 */           double distRatio = this.maxDistance / distance;
/* 414 */           this.field_70165_t = this.field_146042_b.field_70165_t + distVec.field_72450_a * distRatio;
/* 415 */           this.field_70163_u = this.field_146042_b.field_70163_u + distVec.field_72448_b * distRatio;
/* 416 */           this.field_70161_v = this.field_146042_b.field_70161_v + distVec.field_72449_c * distRatio;
/*     */         } 
/* 418 */         func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 437 */     par1NBTTagCompound.func_74777_a("xTile", (short)this.xTile);
/* 438 */     par1NBTTagCompound.func_74777_a("yTile", (short)this.yTile);
/* 439 */     par1NBTTagCompound.func_74777_a("zTile", (short)this.zTile);
/* 440 */     par1NBTTagCompound.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
/* 441 */     par1NBTTagCompound.func_74774_a("shake", (byte)this.field_146044_a);
/* 442 */     par1NBTTagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 451 */     this.xTile = par1NBTTagCompound.func_74765_d("xTile");
/* 452 */     this.yTile = par1NBTTagCompound.func_74765_d("yTile");
/* 453 */     this.zTile = par1NBTTagCompound.func_74765_d("zTile");
/* 454 */     this.inTile = Block.func_149729_e(par1NBTTagCompound.func_74771_c("inTile") & 0xFF);
/* 455 */     this.field_146044_a = par1NBTTagCompound.func_74771_c("shake") & 0xFF;
/* 456 */     this.inGround = (par1NBTTagCompound.func_74771_c("inGround") == 1);
/*     */   }
/*     */   
/*     */   public Vec3 applyEntityForce(Vec3 entityForce, double x, double y, double z) {
/* 460 */     Vec3 pullVec = Vec3.func_72443_a(this.pullX, this.pullY, this.pullZ);
/*     */     
/* 462 */     double force = pullVec.func_72438_d(entityForce);
/* 463 */     Vec3 netForceVec = entityForce.func_72441_c(this.pullX, this.pullY, this.pullZ);
/* 464 */     double forceRatio = force * 30.0D / netForceVec.func_72433_c();
/*     */     
/* 466 */     if (TFC_Time.getTotalTicks() % 40L == 0L) {
/* 467 */       force += 0.0D;
/*     */     }
/* 469 */     this.lineTension = (int)(this.lineTension + ((forceRatio - 31.0D > 1.0D) ? Math.sqrt(forceRatio - 31.0D) : (forceRatio - 31.0D)));
/*     */     
/* 471 */     this.lineTension = Math.max(this.lineTension, 0);
/*     */     
/* 473 */     ItemStack is = this.field_146042_b.func_70694_bm();
/* 474 */     if (is != null && is.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomFishingRod) {
/* 475 */       if (!is.func_77942_o()) {
/* 476 */         is.func_77982_d(new NBTTagCompound());
/*     */       }
/* 478 */       if (this.reelCounter > 2) {
/* 479 */         is.field_77990_d.func_74768_a("tension", (int)(forceRatio - 29.0D + Math.pow(entityForce.func_72433_c() / 0.2D, 3.0D) * 2.0D) * 100);
/*     */       } else {
/*     */         
/* 482 */         this.reelCounter++;
/*     */       } 
/*     */     } 
/* 485 */     if (forceRatio != 30.0D) {
/* 486 */       this.reelCounter = 0;
/*     */     }
/* 488 */     if (this.lineTension >= 400)
/*     */     {
/* 490 */       this.maxDistance += pullVec.func_72433_c() * 0.3D;
/*     */     }
/* 492 */     if (this.lineTension > 640.0D && !this.lineTensionSnap) {
/* 493 */       this.lineTensionSnap = true;
/* 494 */       TFC_Core.sendInfoMessage(this.field_146042_b, (IChatComponent)new ChatComponentTranslation("fishingRod.lineTension", new Object[0]));
/*     */     }
/* 496 */     else if (this.lineTension < 640.0D) {
/* 497 */       this.lineTensionSnap = false;
/*     */     } 
/* 499 */     if (this.lineTension >= 800) {
/* 500 */       this.field_146042_b.func_71045_bC().func_77972_a(20, (EntityLivingBase)this.field_146042_b);
/* 501 */       this.field_70154_o.field_70153_n = null;
/* 502 */       this.field_70154_o = null;
/*     */       
/* 504 */       TFC_Core.sendInfoMessage(this.field_146042_b, (IChatComponent)new ChatComponentTranslation("fishingRod.lineSnap", new Object[0]));
/* 505 */       func_70106_y();
/*     */     } 
/* 507 */     this.pullX = 0.0D;
/* 508 */     this.pullY = 0.0D;
/* 509 */     this.pullZ = 0.0D;
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
/* 521 */     return Vec3.func_72443_a(netForceVec.field_72450_a, (this.field_70170_p.func_147437_c((int)x, (int)y + 1, (int)z) && netForceVec.field_72448_b > 0.0D) ? 0.0D : netForceVec.field_72448_b, netForceVec.field_72449_c);
/*     */   }
/*     */   
/*     */   public Vec3 getNormalDirectionOfPlayer(double x, double y, double z) {
/* 525 */     Vec3 dirVec = Vec3.func_72443_a(this.field_146042_b.field_70165_t - x, this.field_146042_b.field_70163_u - y, this.field_146042_b.field_70161_v - z);
/* 526 */     return dirVec.func_72432_b();
/*     */   }
/*     */   
/*     */   public Vec3 getTooFarAdjustedVec(Vec3 motionVec, double x, double y, double z) {
/* 530 */     Vec3 playerMotion = Vec3.func_72443_a(this.field_146042_b.field_70159_w, this.field_146042_b.field_70181_x, this.field_146042_b.field_70179_y);
/* 531 */     double subractedRatio = Math.max(1.0D - this.maxDistance / this.field_146042_b.func_70011_f(x + playerMotion.field_72450_a, y + playerMotion.field_72448_b, z + playerMotion.field_72449_c), 0.0D);
/* 532 */     return Vec3.func_72443_a((this.field_146042_b.field_70165_t + playerMotion.field_72450_a - motionVec.field_72450_a + x) * subractedRatio, (this.field_146042_b.field_70163_u + playerMotion.field_72448_b - motionVec.field_72448_b + y) * subractedRatio, (this.field_146042_b.field_70161_v + playerMotion.field_72449_c - motionVec.field_72449_c + z) * subractedRatio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void attemptToCatch() {
/* 539 */     int fishPopulation = getAverageFishPopFromChunks();
/* 540 */     if (this.lastCheckTick == 0) {
/* 541 */       int maxValue = 72;
/* 542 */       int minValue = 0;
/* 543 */       int hour = TFC_Time.getHour();
/* 544 */       if ((hour >= 3 && hour <= 9) || (hour >= 17 && hour < 22))
/*     */       {
/* 546 */         minValue = 1;
/*     */       }
/* 548 */       if (this.field_70146_Z.nextInt(maxValue - fishPopulation) <= minValue) {
/* 549 */         func_146034_e();
/*     */       }
/* 551 */       this.lastCheckTick = 20;
/*     */     } else {
/*     */       
/* 554 */       this.lastCheckTick--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isTooFarFromPlayer(double x, double y, double z) {
/* 559 */     return (this.field_146042_b.func_70011_f(x, y, z) > this.maxDistance);
/*     */   }
/*     */   
/*     */   public void reelInBobber(Entity entity, ItemStack itemstack) {
/* 563 */     double distance = func_70032_d(entity);
/* 564 */     if (distance < this.maxDistance) {
/* 565 */       this.maxDistance -= 0.2D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 570 */     if (distance > 1.5D) {
/*     */       
/* 572 */       this.pullX = (entity.field_70165_t - this.field_70165_t) / distance;
/* 573 */       this.pullY = (entity.field_70163_u - this.field_70163_u) / distance;
/* 574 */       this.pullZ = (entity.field_70161_v - this.field_70161_v) / distance;
/*     */       
/* 576 */       if (this.field_70154_o == null) {
/* 577 */         this.field_70159_w += this.pullX * 0.2D;
/* 578 */         this.field_70181_x += this.pullY * 0.2D;
/* 579 */         this.field_70179_y += this.pullZ * 0.2D;
/*     */       } 
/*     */     } else {
/*     */       
/* 583 */       setDeadKill();
/* 584 */       if (itemstack.field_77990_d == null) {
/* 585 */         itemstack.field_77990_d = new NBTTagCompound();
/*     */       }
/* 587 */       itemstack.field_77990_d.func_74772_a("tickReeledIn", TFC_Time.getTotalTicks());
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getAverageFishPopFromChunks() {
/* 592 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 594 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 598 */     EntityPlayer player = this.field_146042_b;
/* 599 */     int lastChunkX = (int)Math.floor(player.field_70165_t) >> 4;
/* 600 */     int lastChunkZ = (int)Math.floor(player.field_70161_v) >> 4;
/*     */     
/* 602 */     int chunksVisited = 0;
/* 603 */     int totalFish = TFC_Core.getCDM(this.field_70170_p).getFishPop(lastChunkX, lastChunkZ);
/* 604 */     if (totalFish > 0) {
/* 605 */       chunksVisited++;
/*     */     } else {
/*     */       
/* 608 */       return 0;
/*     */     } 
/*     */     
/* 611 */     int maxChunksVisitable = 20;
/* 612 */     for (int radius = 1; radius < 5 && chunksVisited < maxChunksVisitable; radius++) {
/* 613 */       for (int i = -radius; i <= radius; i++) {
/*     */         int k;
/* 615 */         for (k = -radius; k <= radius; k += (Math.abs(i) == radius) ? 1 : (radius * 2)) {
/*     */           
/* 617 */           int tempFish = TFC_Core.getCDM(this.field_70170_p).getFishPop(lastChunkX + i, lastChunkZ + k);
/* 618 */           if (tempFish > 0) {
/* 619 */             chunksVisited++;
/* 620 */             totalFish += tempFish;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 625 */     return totalFish / chunksVisited;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_146034_e() {
/* 632 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 634 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 638 */     EntityPlayer player = this.field_146042_b;
/* 639 */     EntityFishTFC fish = new EntityFishTFC(this.field_70170_p);
/* 640 */     fish.func_70107_b(this.field_70165_t, this.field_70163_u - 0.3D, this.field_70161_v);
/* 641 */     this.field_70170_p.func_72838_d((Entity)fish);
/* 642 */     TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("fishingRod.bite", new Object[0]));
/* 643 */     func_70078_a((Entity)fish);
/*     */     
/* 645 */     this.canCatchFish = false;
/*     */     
/* 647 */     int lastChunkX = (int)Math.floor(player.field_70165_t) >> 4;
/* 648 */     int lastChunkZ = (int)Math.floor(player.field_70161_v) >> 4;
/* 649 */     int maxChunksVisitable = 20;
/* 650 */     TFC_Core.getCDM(this.field_70170_p).catchFish(lastChunkX, lastChunkZ);
/* 651 */     int chunksVisited = 1;
/* 652 */     for (int radius = 1; radius < 5 && chunksVisited < maxChunksVisitable; radius++) {
/* 653 */       for (int i = -radius; i <= radius; i++) {
/*     */         int k;
/* 655 */         for (k = -radius; k <= radius; k += (Math.abs(i) == radius) ? 1 : (radius * 2)) {
/*     */           
/* 657 */           if (TFC_Core.getCDM(this.field_70170_p).catchFish(lastChunkX + i, lastChunkZ + k)) {
/* 658 */             chunksVisited++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 663 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeadKill() {
/* 668 */     if (this.field_70154_o != null && this.field_70154_o instanceof EntityLiving) {
/* 669 */       ((EntityLiving)this.field_70154_o).func_70606_j(1.0F);
/* 670 */       ((EntityLiving)this.field_70154_o).func_70097_a((DamageSource)new EntityDamageSource("fishing", (Entity)this.field_146042_b), 1.0F);
/* 671 */       this.field_146042_b.func_71064_a(StatList.field_75933_B, 1);
/*     */     } 
/* 673 */     this.field_70154_o = null;
/* 674 */     func_70106_y();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 683 */     if (this.field_70154_o != null) {
/* 684 */       EntityLiving e = (EntityLiving)this.field_70154_o;
/* 685 */       e.func_70106_y();
/*     */     } 
/* 687 */     super.func_70106_y();
/* 688 */     this.lineTension = 0;
/* 689 */     this.maxDistance = -1.0D;
/* 690 */     if (this.field_146042_b != null)
/* 691 */       this.field_146042_b.field_71104_cf = null; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityFishHookTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */