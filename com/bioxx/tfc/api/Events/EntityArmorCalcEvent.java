/*    */ package com.bioxx.tfc.api.Events;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class EntityArmorCalcEvent extends EntityEvent {
/*    */   public float incomingDamage;
/*    */   public final EventType eventType;
/*    */   
/*    */   public enum EventType {
/*  9 */     PRE, POST;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityArmorCalcEvent(EntityLivingBase p, float damage, EventType eType) {
/* 19 */     super((Entity)p);
/* 20 */     this.incomingDamage = damage;
/* 21 */     this.eventType = eType;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Events\EntityArmorCalcEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */