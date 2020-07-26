/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAIAvoidEntity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAICreeperSwell;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityCreeperTFC
/*     */   extends EntityCreeper implements IInnateArmor {
/*     */   public EntityCreeperTFC(World par1World) {
/*  34 */     super(par1World);
/*  35 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  36 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAICreeperSwell(this));
/*  37 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, EntityOcelotTFC.class, 6.0F, 1.0D, 1.2D));
/*  38 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 1.0D, false));
/*  39 */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 0.8D));
/*  40 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
/*  41 */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  42 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, EntityPlayer.class, 0, true));
/*  43 */     this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  49 */     super.func_110147_ax();
/*  50 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  56 */     Entity entity = par1DamageSource.func_76346_g();
/*  57 */     if (entity != null && entity instanceof EntityPlayer && ((EntityPlayer)entity)
/*  58 */       .func_70694_bm() != null && ((EntityPlayer)entity).func_70694_bm().func_77973_b().equals(TFCItems.stick)) {
/*  59 */       ((EntityPlayer)entity).func_71029_a((StatBase)TFC_Achievements.achPokeCreeper);
/*     */     }
/*  61 */     return super.func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCrushArmor() {
/*  66 */     return 1000;
/*     */   }
/*     */   
/*     */   public int getSlashArmor() {
/*  70 */     return 0;
/*     */   }
/*     */   
/*     */   public int getPierceArmor() {
/*  74 */     return -335;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  80 */     int x = MathHelper.func_76128_c(this.field_70165_t);
/*  81 */     int y = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
/*  82 */     int z = MathHelper.func_76128_c(this.field_70161_v);
/*  83 */     Block b = this.field_70170_p.func_147439_a(x, y, z);
/*     */     
/*  85 */     if (b == TFCBlocks.leaves || b == TFCBlocks.leaves2 || b == TFCBlocks.thatch) {
/*  86 */       return false;
/*     */     }
/*  88 */     return super.func_70601_bi();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70645_a(DamageSource p_70645_1_) {
/*  96 */     super.func_70645_a(p_70645_1_);
/*     */     
/*  98 */     if (p_70645_1_.func_76346_g() instanceof EntitySkeletonTFC) {
/*     */       
/* 100 */       int i = Item.func_150891_b(Items.field_151096_cd);
/* 101 */       int j = Item.func_150891_b(Items.field_151084_co);
/* 102 */       int k = i + this.field_70146_Z.nextInt(j - i + 1);
/* 103 */       func_145779_a(Item.func_150899_d(k), 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityCreeperTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */