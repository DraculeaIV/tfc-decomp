/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.passive.EntityWolf;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.event.entity.living.ZombieEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityZombieTFC
/*     */   extends EntityZombie
/*     */   implements ICausesDamage, IInnateArmor
/*     */ {
/*     */   public EntityZombieTFC(World par1World) {
/*  43 */     super(par1World);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  49 */     super.func_110147_ax();
/*  50 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(25.0D);
/*  51 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(450.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  57 */     int x = MathHelper.func_76128_c(this.field_70165_t);
/*  58 */     int y = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/*  59 */     int z = MathHelper.func_76128_c(this.field_70161_v);
/*  60 */     Block b = this.field_70170_p.func_147439_a(x, y, z);
/*     */     
/*  62 */     if (b == TFCBlocks.leaves || b == TFCBlocks.leaves2 || b == TFCBlocks.thatch) {
/*  63 */       return false;
/*     */     }
/*  65 */     return super.func_70601_bi();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70658_aO() {
/*  74 */     int var1 = super.func_70658_aO() + 2;
/*  75 */     if (var1 > 20)
/*  76 */       var1 = 20; 
/*  77 */     return var1; } protected void func_70600_l(int par1) {
/*     */     Random r0;
/*     */     ItemStack is1;
/*     */     Random r1;
/*     */     ItemStack is2;
/*     */     Random r2;
/*  83 */     switch (this.field_70146_Z.nextInt(3)) {
/*     */       
/*     */       case 0:
/*  86 */         r0 = new Random();
/*  87 */         if (r0.nextInt(3) == 0)
/*  88 */           func_145779_a(TFCItems.wroughtIronIngot, 1); 
/*     */         break;
/*     */       case 1:
/*  91 */         is1 = new ItemStack(TFCItems.carrot);
/*  92 */         r1 = new Random();
/*  93 */         if (r1.nextInt(100) < 100) {
/*     */           
/*  95 */           float weight = CropIndex.getWeight(30.0F, r1);
/*  96 */           ItemFoodTFC.createTag(is1, weight, weight / 2.0F);
/*  97 */           func_70099_a(is1, 0.0F);
/*     */         } 
/*     */         break;
/*     */       case 2:
/* 101 */         is2 = new ItemStack(TFCItems.potato);
/* 102 */         r2 = new Random();
/* 103 */         if (r2.nextInt(100) < 100) {
/*     */           
/* 105 */           float weight = CropIndex.getWeight(55.0F, r2);
/* 106 */           ItemFoodTFC.createTag(is2, weight, weight / 2.0F);
/* 107 */           func_70099_a(is2, 0.0F);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82164_bB() {
/* 116 */     func_70062_b(0, null);
/* 117 */     func_70062_b(1, null);
/* 118 */     func_70062_b(2, null);
/* 119 */     func_70062_b(3, null);
/* 120 */     func_70062_b(4, null);
/*     */     
/* 122 */     if (this.field_70146_Z.nextFloat() < ((this.field_70170_p.field_73013_u == EnumDifficulty.HARD) ? 0.05F : 0.01F)) {
/*     */       
/* 124 */       int var1 = this.field_70146_Z.nextInt(3);
/* 125 */       if (var1 == 0) {
/* 126 */         func_70062_b(0, new ItemStack(TFCItems.bronzePick));
/*     */       } else {
/* 128 */         func_70062_b(0, new ItemStack(TFCItems.bronzeShovel));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_82162_bC() {}
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte par1) {
/* 142 */     if (par1 == 16) {
/* 143 */       this.field_70170_p.func_72908_a(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, "mob.zombie.remedy", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F);
/*     */     } else {
/* 145 */       super.func_70103_a(par1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 151 */     return EnumDamageType.SLASHING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float par2) {
/* 157 */     if (ForgeHooks.onLivingAttack((EntityLivingBase)this, ds, par2)) return false; 
/* 158 */     if (func_85032_ar())
/*     */     {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 168 */     this.field_70708_bq = 0;
/*     */     
/* 170 */     if (func_110143_aJ() <= 0.0F)
/*     */     {
/* 172 */       return false;
/*     */     }
/* 174 */     if (ds.func_76347_k() && func_70644_a(Potion.field_76426_n))
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 180 */     if ((ds == DamageSource.field_82728_o || ds == DamageSource.field_82729_p) && func_71124_b(4) != null) {
/*     */       
/* 182 */       func_71124_b(4).func_77972_a((int)(par2 * 4.0F + this.field_70146_Z.nextFloat() * par2 * 2.0F), (EntityLivingBase)this);
/* 183 */       par2 *= 0.75F;
/*     */     } 
/*     */     
/* 186 */     this.field_70721_aZ = 1.5F;
/* 187 */     boolean flag = true;
/*     */     
/* 189 */     if (this.field_70172_ad > this.field_70771_an / 2.0F) {
/*     */       
/* 191 */       if (par2 <= this.field_110153_bc)
/* 192 */         return false; 
/* 193 */       func_70665_d(ds, par2 - this.field_110153_bc);
/* 194 */       this.field_110153_bc = par2;
/* 195 */       flag = false;
/*     */     }
/*     */     else {
/*     */       
/* 199 */       this.field_110153_bc = par2;
/* 200 */       this.field_70735_aL = func_110143_aJ();
/* 201 */       this.field_70172_ad = this.field_70771_an;
/* 202 */       func_70665_d(ds, par2);
/* 203 */       this.field_70737_aN = this.field_70738_aO = 10;
/*     */     } 
/*     */     
/* 206 */     this.field_70739_aP = 0.0F;
/* 207 */     Entity entity = ds.func_76346_g();
/*     */     
/* 209 */     if (entity != null) {
/*     */       
/* 211 */       if (entity instanceof EntityLivingBase) {
/* 212 */         func_70604_c((EntityLivingBase)entity);
/*     */       }
/* 214 */       if (entity instanceof EntityPlayer) {
/*     */         
/* 216 */         this.field_70718_bc = 100;
/* 217 */         this.field_70717_bb = (EntityPlayer)entity;
/*     */       }
/* 219 */       else if (entity instanceof EntityWolf) {
/*     */         
/* 221 */         EntityWolf entitywolf = (EntityWolf)entity;
/*     */         
/* 223 */         if (entitywolf.func_70909_n()) {
/*     */           
/* 225 */           this.field_70718_bc = 100;
/* 226 */           this.field_70717_bb = null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     if (flag) {
/*     */       
/* 233 */       this.field_70170_p.func_72960_a((Entity)this, (byte)2);
/*     */       
/* 235 */       if (ds != DamageSource.field_76369_e) {
/* 236 */         func_70018_K();
/*     */       }
/* 238 */       if (entity != null) {
/*     */         
/* 240 */         double d0 = entity.field_70165_t - this.field_70165_t;
/*     */         
/*     */         double d1;
/* 243 */         for (d1 = entity.field_70161_v - this.field_70161_v; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D)
/*     */         {
/* 245 */           d0 = (Math.random() - Math.random()) * 0.01D;
/*     */         }
/*     */         
/* 248 */         this.field_70739_aP = (float)(Math.atan2(d1, d0) * 180.0D / Math.PI) - this.field_70177_z;
/* 249 */         func_70653_a(entity, par2, d0, d1);
/*     */       }
/*     */       else {
/*     */         
/* 253 */         this.field_70739_aP = ((int)(Math.random() * 2.0D) * 180);
/*     */       } 
/*     */     } 
/*     */     
/* 257 */     if (func_110143_aJ() <= 0.0F) {
/*     */       
/* 259 */       if (flag)
/* 260 */         func_85030_a(func_70673_aS(), func_70599_aP(), func_70647_i()); 
/* 261 */       func_70645_a(ds);
/*     */     }
/* 263 */     else if (flag) {
/*     */       
/* 265 */       func_85030_a(func_70621_aR(), func_70599_aP(), func_70647_i());
/*     */     } 
/*     */     
/* 268 */     summonAid(ds);
/*     */     
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void summonAid(DamageSource ds) {
/* 277 */     EntityLivingBase entitylivingbase = func_70638_az();
/*     */     
/* 279 */     if (entitylivingbase == null && func_70777_m() instanceof EntityLivingBase)
/*     */     {
/* 281 */       entitylivingbase = (EntityLivingBase)func_70777_m();
/*     */     }
/*     */     
/* 284 */     if (entitylivingbase == null && ds.func_76346_g() instanceof EntityLivingBase)
/*     */     {
/* 286 */       entitylivingbase = (EntityLivingBase)ds.func_76346_g();
/*     */     }
/*     */     
/* 289 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 290 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 291 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*     */     
/* 293 */     ZombieEvent.SummonAidEvent summonAid = ForgeEventFactory.fireZombieSummonAid(this, this.field_70170_p, i, j, k, entitylivingbase, func_110148_a(field_110186_bp).func_111126_e());
/*     */     
/* 295 */     if (summonAid.getResult() == Event.Result.DENY) {
/*     */       return;
/*     */     }
/*     */     
/* 299 */     if (summonAid.getResult() == Event.Result.ALLOW || (entitylivingbase != null && this.field_70170_p.field_73013_u == EnumDifficulty.HARD && this.field_70146_Z.nextFloat() < func_110148_a(field_110186_bp).func_111126_e())) {
/*     */       EntityZombie entityzombie;
/*     */       
/* 302 */       if (summonAid.customSummonedAid != null && summonAid.getResult() == Event.Result.ALLOW) {
/*     */         
/* 304 */         entityzombie = summonAid.customSummonedAid;
/*     */       }
/*     */       else {
/*     */         
/* 308 */         entityzombie = new EntityZombieTFC(this.field_70170_p);
/*     */       } 
/*     */       
/* 311 */       for (int l = 0; l < 50; l++) {
/*     */         
/* 313 */         int i1 = i + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
/* 314 */         int j1 = j + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
/* 315 */         int k1 = k + MathHelper.func_76136_a(this.field_70146_Z, 7, 40) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
/*     */         
/* 317 */         if (World.func_147466_a((IBlockAccess)this.field_70170_p, i1, j1 - 1, k1) && this.field_70170_p.func_72957_l(i1, j1, k1) < 10 && TFC_Core.getCDM(this.field_70170_p).getData(i1 >> 4, k1 >> 4).getSpawnProtectionWithUpdate() <= 0) {
/*     */           
/* 319 */           entityzombie.func_70107_b(i1, j1, k1);
/*     */           
/* 321 */           if (this.field_70170_p.func_72855_b(entityzombie.field_70121_D) && this.field_70170_p.func_72945_a((Entity)entityzombie, entityzombie.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entityzombie.field_70121_D)) {
/*     */             
/* 323 */             this.field_70170_p.func_72838_d((Entity)entityzombie);
/* 324 */             if (entitylivingbase != null) entityzombie.func_70624_b(entitylivingbase); 
/* 325 */             entityzombie.func_110161_a((IEntityLivingData)null);
/* 326 */             func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
/* 327 */             entityzombie.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/* 338 */     return 1000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSlashArmor() {
/* 344 */     return -335;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPierceArmor() {
/* 350 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityZombieTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */