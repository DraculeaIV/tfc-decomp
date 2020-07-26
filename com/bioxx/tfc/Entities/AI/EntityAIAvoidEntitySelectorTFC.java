/*    */ package com.bioxx.tfc.Entities.AI;
/*    */ 
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ class EntityAIAvoidEntitySelectorTFC
/*    */   implements IEntitySelector
/*    */ {
/*    */   private final EntityAIAvoidEntityTFC entityAvoiderAI;
/*    */   
/*    */   EntityAIAvoidEntitySelectorTFC(EntityAIAvoidEntityTFC par1EntityAIAvoidEntity) {
/* 14 */     this.entityAvoiderAI = par1EntityAIAvoidEntity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_82704_a(Entity par1Entity) {
/* 23 */     EntityCreature creature = EntityAIAvoidEntityTFC.getEntity(this.entityAvoiderAI);
/*    */     
/* 25 */     Vec3 distanceVec = Vec3.func_72443_a(creature.field_70165_t - par1Entity.field_70165_t, creature.field_70163_u - par1Entity.field_70163_u, creature.field_70161_v - par1Entity.field_70161_v);
/* 26 */     double cosAngleAbs = Math.abs(distanceVec.func_72430_b(creature.func_70040_Z()) / distanceVec.func_72433_c() * creature.func_70040_Z().func_72433_c());
/* 27 */     boolean fovSight = (cosAngleAbs < 0.985D);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 33 */     Vec3 movement = Vec3.func_72443_a(par1Entity.field_70159_w, par1Entity.field_70181_x, par1Entity.field_70179_y);
/* 34 */     double inverseMotion = (movement.func_72433_c() > 0.0D) ? (1.0D / movement.func_72433_c() * 2.0D) : 1.0D;
/* 35 */     inverseMotion = (inverseMotion > 1.0D) ? 1.0D : inverseMotion;
/* 36 */     int n = (int)Math.ceil(8.0D * inverseMotion * inverseMotion) + (int)(cosAngleAbs * 1.015D * 30.0D * inverseMotion);
/* 37 */     boolean motionSight = (fovSight && creature.func_70681_au().nextInt(n) == 0);
/*    */     
/* 39 */     boolean sight = (par1Entity.func_70089_S() && creature.func_70635_at().func_75522_a(par1Entity));
/* 40 */     return (sight && motionSight);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIAvoidEntitySelectorTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */