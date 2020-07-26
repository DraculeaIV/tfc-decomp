/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AIEatGrass
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityLiving theEntity;
/*     */   private World theWorld;
/*     */   private int eatGrassTick;
/*     */   
/*     */   public AIEatGrass(IAnimal animal) {
/*  24 */     this.theEntity = (EntityLiving)animal;
/*  25 */     this.theWorld = this.theEntity.field_70170_p;
/*  26 */     func_75248_a(7);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  32 */     IAnimal animal = (IAnimal)this.theEntity;
/*  33 */     if (animal.getHunger() < 144000 && this.theWorld.field_73012_v.nextInt(10) == 0) {
/*     */       
/*  35 */       int i = MathHelper.func_76128_c(this.theEntity.field_70165_t);
/*  36 */       int j = MathHelper.func_76128_c(this.theEntity.field_70163_u);
/*  37 */       int k = MathHelper.func_76128_c(this.theEntity.field_70161_v);
/*  38 */       boolean isGrass = TFC_Core.isLushGrass(this.theWorld.func_147439_a(i, j - 1, k));
/*  39 */       boolean isTallGrass = (this.theWorld.func_147439_a(i, j, k) == TFCBlocks.tallGrass && this.theWorld.func_72805_g(i, j, k) == 1);
/*  40 */       return (isGrass || isTallGrass);
/*     */     } 
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  51 */     this.eatGrassTick = 40;
/*  52 */     this.theWorld.func_72960_a((Entity)this.theEntity, (byte)10);
/*  53 */     this.theEntity.func_70661_as().func_75499_g();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  62 */     this.eatGrassTick = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  71 */     return (this.eatGrassTick > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEatGrassTick() {
/*  76 */     return this.eatGrassTick;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  85 */     this.eatGrassTick = Math.max(0, this.eatGrassTick - 1);
/*     */     
/*  87 */     if (this.eatGrassTick == 1) {
/*     */       
/*  89 */       int i = MathHelper.func_76128_c(this.theEntity.field_70165_t);
/*  90 */       int j = MathHelper.func_76128_c(this.theEntity.field_70163_u);
/*  91 */       int k = MathHelper.func_76128_c(this.theEntity.field_70161_v);
/*     */       
/*  93 */       Block grass = this.theWorld.func_147439_a(i, j - 1, k);
/*     */       
/*  95 */       if (this.theWorld.func_147439_a(i, j, k) == TFCBlocks.tallGrass) {
/*     */         
/*  97 */         this.theWorld.func_147480_a(i, j, k, false);
/*  98 */         this.theEntity.func_70615_aA();
/*     */       }
/* 100 */       else if (TFC_Core.isLushGrass(grass)) {
/*     */         
/* 102 */         this.theWorld.func_72926_e(2001, i, j - 1, k, Block.func_149682_b((Block)Blocks.field_150349_c));
/* 103 */         TFC_Core.convertGrassToDirt(this.theWorld, i, j - 1, k);
/* 104 */         this.theEntity.func_70615_aA();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\AIEatGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */