/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityIronGolemTFC
/*     */   extends EntityIronGolem
/*     */ {
/*     */   private int attackTimer;
/*     */   
/*     */   public EntityIronGolemTFC(World par1World) {
/*  27 */     super(par1World);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  33 */     super.func_110147_ax();
/*  34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4500.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  44 */     super.func_70636_d();
/*     */     
/*  46 */     if (this.attackTimer > 0) {
/*  47 */       this.attackTimer--;
/*     */     }
/*  49 */     if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7D && this.field_70146_Z.nextInt(5) == 0) {
/*     */       
/*  51 */       int x = MathHelper.func_76128_c(this.field_70165_t);
/*  52 */       int y = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D - this.field_70129_M);
/*  53 */       int z = MathHelper.func_76128_c(this.field_70161_v);
/*  54 */       Block block = this.field_70170_p.func_147439_a(x, y, z);
/*  55 */       int meta = this.field_70170_p.func_72805_g(x, y, z);
/*     */       
/*  57 */       if (block == TFCBlocks.grass || block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2 || block == TFCBlocks.peatGrass || block == TFCBlocks.dryGrass || block == TFCBlocks.dryGrass2) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  62 */         block = TFCBlocks.dirt;
/*  63 */         meta = 1;
/*     */       } 
/*     */       
/*  66 */       if (block.func_149688_o() != Material.field_151579_a) {
/*  67 */         this.field_70170_p.func_72869_a("tilecrack_" + Block.func_149682_b(block) + "_" + meta, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, 4.0D * (this.field_70146_Z.nextFloat() - 0.5D), 0.5D, (this.field_70146_Z.nextFloat() - 0.5D) * 4.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70652_k(Entity entity) {
/*  74 */     this.attackTimer = 10;
/*  75 */     this.field_70170_p.func_72960_a((Entity)this, (byte)4);
/*  76 */     boolean var2 = entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), (450 + this.field_70146_Z.nextInt(150)));
/*     */     
/*  78 */     if (var2) {
/*  79 */       entity.field_70181_x += 0.4000000059604645D;
/*     */     }
/*  81 */     this.field_70170_p.func_72956_a((Entity)this, "mob.irongolem.throw", 1.0F, 1.0F);
/*  82 */     return var2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte par1) {
/*  89 */     super.func_70103_a(par1);
/*  90 */     if (par1 == 4) {
/*  91 */       this.attackTimer = 10;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70854_o() {
/*  98 */     return this.attackTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 104 */     Random ran = new Random();
/* 105 */     int k = 3 + ran.nextInt(3);
/* 106 */     for (int l = 0; l < k; l++)
/* 107 */       func_145779_a(TFCItems.wroughtIronIngot, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityIronGolemTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */