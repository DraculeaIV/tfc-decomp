/*     */ package com.bioxx.tfc.Entities.AI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.RandomPositionGenerator;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ public class EntityAIPanicTFC
/*     */   extends EntityAIBase
/*     */ {
/*     */   private final EntityCreature theEntityCreature;
/*     */   private final boolean alertHerd;
/*     */   private final double speed;
/*     */   private double randPosX;
/*     */   private double randPosY;
/*     */   private double randPosZ;
/*     */   
/*     */   public EntityAIPanicTFC(EntityCreature par1EntityCreature, double par2, boolean par3) {
/*  24 */     this.theEntityCreature = par1EntityCreature;
/*  25 */     this.speed = par2;
/*  26 */     this.alertHerd = par3;
/*  27 */     func_75248_a(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  36 */     if (this.theEntityCreature.func_70643_av() == null && !this.theEntityCreature.func_70027_ad() && ((this.theEntityCreature instanceof IAnimal && ((IAnimal)this.theEntityCreature)
/*  37 */       .getAttackedVec() == null) || !(this.theEntityCreature instanceof IAnimal)))
/*     */     {
/*     */       
/*  40 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  44 */     Vec3 attackedVec = (this.theEntityCreature instanceof IAnimal) ? ((IAnimal)this.theEntityCreature).getAttackedVec() : null;
/*     */     
/*  46 */     Vec3 vec3 = RandomPositionGenerator.func_75463_a(this.theEntityCreature, 5, 4);
/*  47 */     if (attackedVec != null) {
/*     */       
/*  49 */       if (this.theEntityCreature instanceof IAnimal)
/*  50 */         attackedVec = updateAttackVec((IAnimal)this.theEntityCreature, attackedVec); 
/*  51 */       vec3 = RandomPositionGenerator.func_75461_b(this.theEntityCreature, 5, 4, attackedVec);
/*     */     } 
/*  53 */     if (vec3 == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  59 */     this.randPosX = vec3.field_72450_a;
/*  60 */     this.randPosY = vec3.field_72448_b;
/*  61 */     this.randPosZ = vec3.field_72449_c;
/*  62 */     if (this.alertHerd && this.theEntityCreature instanceof IAnimal) {
/*     */       
/*  64 */       List list = this.theEntityCreature.field_70170_p.func_72872_a(this.theEntityCreature.getClass(), this.theEntityCreature.field_70121_D
/*  65 */           .func_72314_b(8.0D, 8.0D, 8.0D));
/*  66 */       for (Object entity : list)
/*     */       {
/*     */         
/*  69 */         ((IAnimal)entity).setAttackedVec(attackedVec);
/*     */       }
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 updateAttackVec(IAnimal theCreature, Vec3 attackedVec) {
/*  79 */     if (theCreature.getFearSource() != null && 
/*  80 */       TFC_Core.getEntityPos((Entity)this.theEntityCreature).func_72438_d(attackedVec) > this.theEntityCreature.func_70032_d(theCreature.getFearSource())) {
/*     */       
/*  82 */       Vec3 newVec = Vec3.func_72443_a((theCreature.getFearSource()).field_70165_t, (theCreature.getFearSource()).field_70163_u, (theCreature.getFearSource()).field_70161_v);
/*  83 */       theCreature.setAttackedVec(newVec);
/*  84 */       return newVec;
/*     */     } 
/*  86 */     return attackedVec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  95 */     this.theEntityCreature.func_70661_as().func_75492_a(this.randPosX, this.randPosY, this.randPosZ, this.speed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/* 104 */     return !this.theEntityCreature.func_70661_as().func_75500_f();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIPanicTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */