/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIMateTFC
/*     */   extends EntityAIBase
/*     */ {
/*     */   private IAnimal theAnimal;
/*     */   private World theWorld;
/*     */   private IAnimal targetMate;
/*     */   private int matingCounter;
/*     */   private float speed;
/*     */   
/*     */   public EntityAIMateTFC(IAnimal par1EntityAnimal, World world, float par2) {
/*  23 */     this.matingCounter = 0;
/*  24 */     this.theAnimal = par1EntityAnimal;
/*  25 */     this.theWorld = world;
/*  26 */     this.speed = par2;
/*  27 */     func_75248_a(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  37 */     if (!this.theAnimal.getInLove() || !this.theAnimal.isAdult())
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  43 */     this.targetMate = getLocalMate();
/*  44 */     if (this.targetMate != null)
/*     */     {
/*  46 */       if (this.targetMate.getGender() == this.theAnimal.getGender() || this.theAnimal
/*  47 */         .isPregnant() || this.targetMate.isPregnant())
/*     */       {
/*  49 */         return false;
/*     */       }
/*     */     }
/*  52 */     return (this.targetMate != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  63 */     return (this.targetMate.getEntity().func_70089_S() && this.targetMate.getInLove() && this.matingCounter < 60 && this.theAnimal.getInLove() && ((this.targetMate
/*  64 */       .getGender() == IAnimal.GenderEnum.FEMALE && this.theAnimal.getGender() == IAnimal.GenderEnum.MALE) || (this.targetMate
/*  65 */       .getGender() == IAnimal.GenderEnum.MALE && this.theAnimal.getGender() == IAnimal.GenderEnum.FEMALE)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  75 */     this.targetMate = null;
/*  76 */     this.matingCounter = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  86 */     this.theAnimal.getEntity().func_70671_ap().func_75651_a((Entity)this.targetMate.getEntity(), 10.0F, this.theAnimal.getEntity().func_70646_bf());
/*  87 */     this.theAnimal.getEntity().func_70661_as().func_75497_a((Entity)this.targetMate.getEntity(), this.speed);
/*  88 */     this.matingCounter++;
/*     */     
/*  90 */     if (this.matingCounter >= 60 && this.theAnimal.getEntity().func_70068_e((Entity)this.targetMate.getEntity()) < 9.0D) {
/*  91 */       this.theAnimal.mate(this.targetMate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private IAnimal getLocalMate() {
/*  97 */     float f = 8.0F;
/*  98 */     List list = this.theWorld.func_72872_a(this.theAnimal.getClass(), (this.theAnimal.getEntity()).field_70121_D.func_72314_b(f, f, f));
/*     */     
/* 100 */     for (Iterator<Entity> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */       
/* 102 */       Entity entity = iterator.next();
/* 103 */       if (entity instanceof IAnimal) {
/*     */         
/* 105 */         IAnimal entityanimal = (IAnimal)entity;
/* 106 */         if (this.theAnimal.canMateWith(entityanimal)) {
/* 107 */           return entityanimal;
/*     */         }
/*     */       } 
/*     */     } 
/* 111 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIMateTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */