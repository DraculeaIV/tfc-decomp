/*    */ package com.bioxx.tfc.Entities.AI;
/*    */ 
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.entity.ai.EntityAITargetNonTamed;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAITargetNonTamedTFC
/*    */   extends EntityAITargetNonTamed
/*    */ {
/*    */   private EntityTameable entityTameable;
/*    */   private Class targetClass;
/*    */   
/*    */   public EntityAITargetNonTamedTFC(EntityTameable entity, Class targetClass, int targetChance, boolean shouldCheckSight) {
/* 18 */     super(entity, targetClass, targetChance, shouldCheckSight);
/* 19 */     this.targetClass = targetClass;
/* 20 */     this.entityTameable = entity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 29 */     if (this.entityTameable instanceof IAnimal) {
/*    */       
/* 31 */       IAnimal animal = (IAnimal)this.entityTameable;
/* 32 */       int familiarity = animal.getFamiliarity();
/* 33 */       if (this.targetClass == EntityPlayer.class && animal.checkFamiliarity(IAnimal.InteractionEnum.TOLERATEPLAYER, null))
/*    */       {
/* 35 */         return false;
/*    */       }
/* 37 */       if (familiarity > 0 && this.field_75299_d.func_70681_au().nextInt(familiarity) != 0) {
/* 38 */         return false;
/*    */       }
/*    */     } 
/* 41 */     return super.func_75250_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAITargetNonTamedTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */