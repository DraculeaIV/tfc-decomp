/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.EntityFishHookTFC;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.passive.EntitySquid;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityFishTFC
/*     */   extends EntitySquid
/*     */ {
/*     */   private float randomMotionVecX;
/*     */   private float randomMotionVecY;
/*     */   private float randomMotionVecZ;
/*     */   private float randomMotionSpeed;
/*     */   private float rotationVelocity;
/*     */   private float yawMult;
/*     */   private List<EntityPlayer> nearbyPlayers;
/*     */   private boolean hooked;
/*  35 */   private int energy = 200;
/*     */   
/*     */   private int tiredTicks;
/*     */   
/*     */   private int numRecoveries;
/*     */   
/*     */   private int inGroundTimer;
/*     */   
/*     */   public float currentRenderRoll;
/*     */   public float currentRenderYaw;
/*     */   public float currentRenderPitch;
/*     */   private float currentDestX;
/*     */   private float currentDestY;
/*     */   private float currentDestZ;
/*     */   private double renderMotionY;
/*     */   private double renderMotionX;
/*     */   private double renderMotionZ;
/*     */   private final double fishStrength;
/*  53 */   private double minPlayerDistance = 16.0D;
/*     */   private double pullX;
/*     */   private double pullY;
/*     */   private double pullZ;
/*     */   
/*     */   public EntityFishTFC(World par1World) {
/*  59 */     super(par1World);
/*  60 */     func_70105_a(0.4F, 0.4F);
/*  61 */     this.fishStrength = this.field_70146_Z.nextInt(40) / 100.0D + 1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  70 */     return (this.field_70163_u > 128.0D && this.field_70163_u <= 144.0D && this.field_70170_p.func_72855_b(this.field_70121_D));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  75 */     super.func_70088_a();
/*  76 */     this.field_70180_af.func_75682_a(21, new Float(1.0F));
/*  77 */     this.field_70180_af.func_75682_a(22, new Float(1.0F));
/*  78 */     this.field_70180_af.func_75682_a(23, new Float(1.0F));
/*     */     
/*  80 */     this.field_70180_af.func_75682_a(26, new Float(1.0F));
/*  81 */     this.field_70180_af.func_75682_a(27, new Float(1.0F));
/*  82 */     this.field_70180_af.func_75682_a(28, new Float(1.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70090_H() {
/*  88 */     return this.field_70170_p.func_72918_a(this.field_70121_D.func_72314_b(0.0D, -0.0200000238418579D, 0.0D), Material.field_151586_h, (Entity)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  98 */     super.func_70636_d();
/*  99 */     if (!this.field_70170_p.field_72995_K) {
/* 100 */       this.field_70862_e = this.field_70861_d;
/* 101 */       this.field_70860_g = this.field_70859_f;
/* 102 */       this.field_70868_i = this.field_70867_h;
/* 103 */       this.field_70865_by = this.field_70866_j;
/* 104 */       this.field_70867_h += this.rotationVelocity;
/*     */       
/* 106 */       if (this.field_70153_n != null) {
/* 107 */         if (!this.hooked) {
/* 108 */           this.energy = 1000;
/* 109 */           this.hooked = true;
/*     */         } 
/*     */       } else {
/*     */         
/* 113 */         this.hooked = false;
/*     */       } 
/*     */       
/* 116 */       if (this.hooked && this.field_70153_n instanceof EntityFishHookTFC && !this.field_70170_p.field_72995_K && func_70090_H()) {
/* 117 */         double randX, randY, randZ; EntityFishHookTFC fh = (EntityFishHookTFC)this.field_70153_n;
/* 118 */         if (Vec3.func_72443_a(fh.pullX, fh.pullY, fh.pullZ).func_72433_c() != 0.0D) {
/* 119 */           Vec3 dirVec = Vec3.func_72443_a(fh.pullX, fh.pullY, fh.pullZ).func_72432_b();
/* 120 */           this.pullX = dirVec.field_72450_a * 0.2D;
/* 121 */           this.pullY = dirVec.field_72448_b * 0.2D;
/* 122 */           this.pullZ = dirVec.field_72449_c * 0.2D;
/*     */         } 
/*     */         
/* 125 */         if (this.pullX == this.pullY && this.pullY == this.pullZ && this.pullZ == 0.0D) {
/* 126 */           Vec3 temp = fh.getNormalDirectionOfPlayer(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 127 */           this.pullX = temp.field_72450_a * 0.2D;
/* 128 */           this.pullY = temp.field_72448_b * 0.2D;
/* 129 */           this.pullZ = temp.field_72449_c * 0.2D;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         if (this.pullX != 0.0D && TFC_Core.isWater(this.field_70170_p.func_147439_a((int)(this.field_70165_t - this.pullX / Math.abs(this.pullX)), (int)this.field_70163_u, (int)this.field_70161_v))) {
/* 138 */           randX = this.field_70146_Z.nextDouble() * 0.5D + 0.16D;
/*     */         } else {
/*     */           
/* 141 */           randX = 0.0D;
/*     */         } 
/*     */         
/* 144 */         if (this.pullZ != 0.0D && TFC_Core.isWater(this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)(this.field_70161_v - this.pullZ / Math.abs(this.pullZ))))) {
/* 145 */           randZ = this.field_70146_Z.nextDouble() * (1.0D - randX - 0.09D) + 0.16D;
/*     */         } else {
/*     */           
/* 148 */           randZ = 0.0D;
/*     */         } 
/* 150 */         if (this.pullX != 0.0D && TFC_Core.isWater(this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)(this.field_70163_u - this.pullY / Math.abs(this.pullY)), (int)this.field_70161_v))) {
/* 151 */           randY = 1.0D - randX + randZ;
/*     */         } else {
/*     */           
/* 154 */           randY = 0.0D;
/*     */         } 
/* 156 */         randX *= 0.33D;
/* 157 */         randY *= 0.33D;
/* 158 */         randZ *= 0.33D;
/* 159 */         if (randY == randX && randX == randZ && randZ == 0.0D) {
/* 160 */           int choice = this.field_70146_Z.nextInt(3);
/* 161 */           switch (choice) { case 0:
/* 162 */               randX = -1.0D; break;
/* 163 */             case 1: randY = -1.0D; break;
/* 164 */             case 2: randZ = -1.0D; break;
/* 165 */             default: randY = -1.0D; break; }
/*     */         
/*     */         } 
/* 168 */         randX += (randX != 0.0D) ? 0.7D : 0.0D;
/* 169 */         randY += (randY != 0.0D) ? 0.7D : 0.0D;
/* 170 */         randZ += (randZ != 0.0D) ? 0.7D : 0.0D;
/* 171 */         double energyStrength = 0.05D;
/*     */         
/* 173 */         if (this.energy > 0) {
/* 174 */           energyStrength = 1.0D;
/* 175 */           this.tiredTicks = 0;
/*     */         }
/* 177 */         else if (this.tiredTicks > 80 && this.numRecoveries < 5) {
/* 178 */           this.numRecoveries++;
/* 179 */           this.energy = (int)(1000.0D * Math.pow(0.9D, this.numRecoveries));
/*     */         } else {
/*     */           
/* 182 */           this.tiredTicks++;
/*     */         } 
/* 184 */         Vec3 fishVec = Vec3.func_72443_a(-(this.pullX * randX) * this.fishStrength * energyStrength, -(this.pullY * randY) * this.fishStrength * energyStrength, -(this.pullZ * randZ) * this.fishStrength * energyStrength);
/* 185 */         this.renderMotionX = fishVec.field_72450_a;
/* 186 */         this.renderMotionY = fishVec.field_72448_b;
/* 187 */         this.renderMotionZ = fishVec.field_72449_c;
/* 188 */         if (this.energy > 0) {
/* 189 */           this.energy = (int)(this.energy - fishVec.func_72433_c());
/*     */         }
/* 191 */         Vec3 calcVec = ((EntityFishHookTFC)this.field_70153_n).applyEntityForce(fishVec, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */         
/* 193 */         this.randomMotionVecX += (float)calcVec.field_72450_a;
/* 194 */         this.randomMotionVecY += (float)calcVec.field_72448_b - 0.008F;
/* 195 */         this.randomMotionVecY = (float)(this.randomMotionVecY * 0.9800000190734863D);
/* 196 */         this.randomMotionVecZ += (float)calcVec.field_72449_c;
/*     */       } 
/* 198 */       if (this.field_70867_h > 6.2831855F) {
/*     */         
/* 200 */         this.field_70867_h -= 6.2831855F;
/*     */         
/* 202 */         if (this.field_70146_Z.nextInt(10) == 0)
/*     */         {
/* 204 */           this.rotationVelocity = 1.0F / (this.field_70146_Z.nextFloat() + 1.0F) * 0.2F;
/*     */         }
/*     */       } 
/*     */       
/* 208 */       if (func_70090_H()) {
/*     */ 
/*     */ 
/*     */         
/* 212 */         if (this.field_70867_h < 3.1415927F) {
/*     */           
/* 214 */           float f1 = this.field_70867_h / 3.1415927F;
/* 215 */           this.field_70866_j = MathHelper.func_76126_a(f1 * f1 * 3.1415927F) * 3.1415927F * 0.25F;
/*     */           
/* 217 */           if (f1 > 0.75D)
/*     */           {
/* 219 */             this.randomMotionSpeed = 1.0F;
/* 220 */             this.yawMult = 1.0F;
/*     */           }
/*     */           else
/*     */           {
/* 224 */             this.yawMult *= 0.8F;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 229 */           this.field_70866_j = 0.0F;
/* 230 */           this.randomMotionSpeed *= 0.9F;
/* 231 */           this.yawMult *= 0.99F;
/*     */         } 
/*     */         
/* 234 */         if (!this.field_70170_p.field_72995_K) {
/*     */           
/* 236 */           this.field_70159_w = (this.randomMotionVecX * (this.hooked ? 1.0F : this.randomMotionSpeed));
/* 237 */           this.field_70181_x = (this.randomMotionVecY * (this.hooked ? 1.0F : this.randomMotionSpeed));
/* 238 */           this.field_70179_y = (this.randomMotionVecZ * (this.hooked ? 1.0F : this.randomMotionSpeed));
/* 239 */           this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
/*     */         } 
/*     */         
/* 242 */         float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 243 */         this.field_70761_aq += (-((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / 3.1415927F - this.field_70761_aq) * 0.1F;
/* 244 */         this.field_70177_z = this.field_70761_aq;
/* 245 */         this.field_70859_f += 3.1415927F * this.yawMult * 1.5F;
/* 246 */         this.field_70861_d += (-((float)Math.atan2(f, this.field_70181_x)) * 180.0F / 3.1415927F - this.field_70861_d) * 0.1F;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 251 */         this.field_70159_w *= 0.8D;
/* 252 */         this.field_70181_x -= 0.08D;
/* 253 */         this.field_70181_x *= 0.9800000190734863D;
/* 254 */         this.field_70179_y *= 0.8D;
/*     */         
/* 256 */         this.field_70866_j = MathHelper.func_76135_e(MathHelper.func_76126_a(this.field_70867_h)) * 3.1415927F * 0.25F;
/*     */         
/* 258 */         if (!this.field_70170_p.field_72995_K)
/*     */         {
/* 260 */           if (this.inGroundTimer > 100 + this.field_70146_Z.nextInt(20) && this.field_70122_E) {
/* 261 */             this.inGroundTimer = 0;
/* 262 */             this.field_70181_x = 0.65D;
/* 263 */             this.field_70159_w = this.field_70146_Z.nextDouble() * 0.65D * (this.field_70146_Z.nextBoolean() ? true : -1);
/* 264 */             this.field_70179_y = this.field_70146_Z.nextDouble() * 0.65D * (this.field_70146_Z.nextBoolean() ? true : -1);
/*     */           }
/* 266 */           else if (this.field_70122_E) {
/* 267 */             if (this.field_70153_n != null) {
/* 268 */               func_110145_l(this.field_70153_n);
/*     */             }
/* 270 */             this.inGroundTimer++;
/* 271 */             this.field_70159_w *= 0.01D;
/* 272 */             this.field_70179_y *= 0.01D;
/*     */           } 
/*     */         }
/*     */         
/* 276 */         this.field_70861_d = (float)(this.field_70861_d + (-90.0F - this.field_70861_d) * 0.02D);
/*     */       } 
/* 278 */       if (!this.hooked || !func_70090_H()) {
/* 279 */         this.renderMotionX = this.field_70159_w;
/* 280 */         this.renderMotionY = this.field_70181_x;
/* 281 */         this.renderMotionZ = this.field_70179_y;
/*     */       } 
/* 283 */       if (this.hooked && this.field_70153_n instanceof EntityFishHookTFC) {
/* 284 */         EntityFishHookTFC fh = (EntityFishHookTFC)this.field_70153_n;
/* 285 */         for (int i = 0; i < 1; i++) {
/* 286 */           if (fh.isTooFarFromPlayer(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
/* 287 */             Vec3 dirVec = fh.getTooFarAdjustedVec(Vec3.func_72443_a(this.field_70159_w, this.field_70181_x, this.field_70179_y), this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 288 */             func_70091_d(dirVec.field_72450_a, dirVec.field_72448_b, dirVec.field_72449_c);
/* 289 */             this.field_70159_w *= 0.7D;
/* 290 */             this.field_70181_x *= 0.7D;
/* 291 */             this.field_70179_y *= 0.7D;
/*     */           } 
/*     */         } 
/*     */       } 
/* 295 */       double xzMotion = Math.sqrt(this.renderMotionX * this.renderMotionX + this.renderMotionZ * this.renderMotionZ);
/* 296 */       this.currentRenderPitch = (xzMotion != 0.0D) ? (float)(Math.atan2(this.renderMotionY, xzMotion) * 180.0D / Math.PI) : this.currentRenderPitch;
/* 297 */       this.currentRenderYaw = (xzMotion != 0.0D) ? (float)(Math.atan2(-this.renderMotionX, -this.renderMotionZ) * 180.0D / Math.PI) : this.currentRenderYaw;
/* 298 */       if (this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v)) {
/* 299 */         this.currentRenderRoll = 90.0F;
/*     */       } else {
/*     */         
/* 302 */         this.currentRenderRoll = 0.0F;
/*     */       } 
/* 304 */       this.field_70180_af.func_75692_b(26, Float.valueOf(this.currentRenderPitch));
/* 305 */       this.field_70180_af.func_75692_b(27, Float.valueOf(this.currentRenderYaw));
/* 306 */       this.field_70180_af.func_75692_b(28, Float.valueOf(this.currentRenderRoll));
/*     */       
/* 308 */       this.field_70180_af.func_75692_b(21, Float.valueOf((float)this.field_70159_w));
/* 309 */       this.field_70180_af.func_75692_b(22, Float.valueOf((float)this.field_70181_x));
/* 310 */       this.field_70180_af.func_75692_b(23, Float.valueOf((float)this.field_70179_y));
/*     */     } else {
/*     */       
/* 313 */       if (!this.field_70122_E) {
/* 314 */         this.currentRenderPitch = this.field_70180_af.func_111145_d(26);
/*     */       } else {
/*     */         
/* 317 */         this.currentRenderPitch = 0.0F;
/*     */       } 
/* 319 */       this.currentRenderYaw = this.field_70180_af.func_111145_d(27);
/* 320 */       this.currentRenderRoll = this.field_70180_af.func_111145_d(28);
/*     */ 
/*     */       
/* 323 */       this.field_70159_w = this.field_70180_af.func_111145_d(21);
/* 324 */       this.field_70181_x = this.field_70180_af.func_111145_d(22);
/* 325 */       this.field_70179_y = this.field_70180_af.func_111145_d(23);
/*     */     } 
/* 327 */     this.field_70177_z = this.currentRenderYaw;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70612_e(float par1, float par2) {
/* 337 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/* 343 */     this.field_70708_bq++;
/*     */     
/* 345 */     int[] destination = getRandomDestination(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     
/* 347 */     if (this.field_70708_bq > 100) {
/*     */       
/* 349 */       this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
/*     */     }
/* 351 */     else if (this.field_70146_Z.nextInt(50) == 0 || !this.field_70171_ac || (this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F && !this.hooked)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 358 */       float speedCoef = 1.0F;
/* 359 */       if (this.minPlayerDistance < 8.0D) {
/* 360 */         this.minPlayerDistance = Math.max(0.1D, this.minPlayerDistance);
/* 361 */         speedCoef = (float)(speedCoef * 1.0D / this.minPlayerDistance);
/* 362 */         speedCoef = MathHelper.func_76131_a(speedCoef, 1.0F, 8.0F);
/*     */       } 
/* 364 */       double distance = func_70011_f(destination[0], destination[1], destination[2]);
/* 365 */       if (distance != 0.0D) {
/* 366 */         this.randomMotionVecX = (float)((destination[0] - this.field_70165_t) / distance) * 0.2F * speedCoef;
/* 367 */         this.randomMotionVecY = (float)((destination[1] - this.field_70163_u) / distance) * 0.2F * speedCoef;
/* 368 */         this.randomMotionVecZ = (float)((destination[2] - this.field_70161_v) / distance) * 0.2F * speedCoef;
/*     */       } else {
/*     */         
/* 371 */         this.randomMotionVecX = 0.0F;
/* 372 */         this.randomMotionVecY = 0.0F;
/* 373 */         this.randomMotionVecZ = 0.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 377 */     func_70623_bb();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] getRandomDestination(double x, double y, double z) {
/* 384 */     int destX = (int)this.currentDestX, destY = (int)this.currentDestY, destZ = (int)this.currentDestZ;
/* 385 */     int numAttempts = 0;
/* 386 */     this.nearbyPlayers = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(16.0D, 8.0D, 16.0D));
/* 387 */     boolean tooCloseToPlayer = false;
/* 388 */     for (EntityPlayer p : this.nearbyPlayers) {
/* 389 */       if (p.func_70011_f(destX, destY, destZ) < 8.0D)
/*     */       {
/* 391 */         tooCloseToPlayer = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 400 */     boolean[] validDirs = { TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x + 1, (int)y, (int)z)), TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x - 1, (int)y, (int)z)), TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x, (int)y + 1, (int)z)), TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x, (int)y - 1, (int)z)), TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x, (int)y, (int)z + 1)), TFC_Core.isWater(this.field_70170_p.func_147439_a((int)x, (int)y, (int)z - 1)) };
/*     */     
/* 402 */     boolean needsNewLocation = (this.field_70146_Z.nextInt(25) < 3 || tooCloseToPlayer);
/* 403 */     while (needsNewLocation && numAttempts < 255) {
/* 404 */       numAttempts++;
/* 405 */       double currentPlayerDistance = 16.0D;
/* 406 */       int tempX = 0;
/*     */       
/* 408 */       int tempZ = 0;
/* 409 */       for (EntityPlayer p : this.nearbyPlayers) {
/* 410 */         if (p.func_70011_f(destX, destY, destZ) < 8.0D) {
/*     */           
/* 412 */           tempX = (int)(tempX + p.field_70165_t);
/*     */           
/* 414 */           tempZ = (int)(tempZ + p.field_70161_v);
/*     */         } 
/*     */       } 
/* 417 */       destX = (int)x + this.field_70146_Z.nextInt(10) * (this.field_70146_Z.nextBoolean() ? (validDirs[1] ? -1 : (validDirs[0] ? 1 : 0)) : (validDirs[0] ? 1 : (validDirs[1] ? -1 : 0)));
/* 418 */       destY = (int)y + this.field_70146_Z.nextInt(3) * (this.field_70146_Z.nextBoolean() ? (validDirs[3] ? -1 : (validDirs[2] ? 1 : 0)) : (validDirs[2] ? 1 : (validDirs[3] ? -1 : 0)));
/* 419 */       destZ = (int)z + this.field_70146_Z.nextInt(10) * (this.field_70146_Z.nextBoolean() ? (validDirs[5] ? -1 : (validDirs[4] ? 1 : 0)) : (validDirs[4] ? 1 : (validDirs[5] ? -1 : 0)));
/* 420 */       if (!this.nearbyPlayers.isEmpty()) {
/*     */         
/* 422 */         tempX /= this.nearbyPlayers.size();
/*     */         
/* 424 */         tempZ /= this.nearbyPlayers.size();
/*     */         
/* 426 */         destX -= tempX * 3;
/*     */         
/* 428 */         destZ -= tempZ * 3;
/*     */       } 
/*     */       
/* 431 */       while (TFC_Core.isWater(this.field_70170_p.func_147439_a(destX, destY + 1, destZ)))
/*     */       {
/* 433 */         destY++;
/*     */       }
/*     */       
/* 436 */       for (EntityPlayer p : this.nearbyPlayers) {
/* 437 */         double playerDist = p.func_70011_f(destX, destY, destZ);
/* 438 */         if (playerDist < currentPlayerDistance || (playerDist < 8.0D && currentPlayerDistance == 16.0D)) {
/*     */           
/* 440 */           currentPlayerDistance = playerDist;
/* 441 */           tooCloseToPlayer = true;
/*     */         } 
/*     */       } 
/*     */       
/* 445 */       needsNewLocation = (!TFC_Core.isWater(this.field_70170_p.func_147439_a(destX, destY, destZ)) || tooCloseToPlayer);
/* 446 */       this.minPlayerDistance = currentPlayerDistance;
/*     */     } 
/* 448 */     this.currentDestX = destX;
/* 449 */     this.currentDestY = destY;
/* 450 */     this.currentDestZ = destZ;
/* 451 */     return new int[] { destX, destY, destZ };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 457 */     super.func_110147_ax();
/* 458 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 468 */     TFC_Core.animalDropMeat((Entity)this, TFCItems.fishRaw, (0.1F + this.field_70170_p.field_73012_v.nextFloat()) * 32.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityFishTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */