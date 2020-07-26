/*    */ package com.bioxx.tfc.Entities.AI;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAISit;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ 
/*    */ public class EntityAISitTFC
/*    */   extends EntityAISit {
/*    */   private EntityTameable theEntity;
/*    */   private boolean isSitting;
/*    */   
/*    */   public EntityAISitTFC(EntityTameable theEntity) {
/* 14 */     super(theEntity);
/* 15 */     this.theEntity = theEntity;
/* 16 */     func_75248_a(5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 26 */     if (!this.theEntity.func_70909_n() && !this.theEntity.func_70906_o())
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (this.theEntity.func_70090_H())
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (!this.theEntity.field_70122_E)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 40 */     EntityLivingBase entitylivingbase = this.theEntity.func_70902_q();
/* 41 */     return (entitylivingbase == null) ? true : ((this.theEntity.func_70068_e((Entity)entitylivingbase) < 144.0D && entitylivingbase.func_70643_av() != null) ? ((this.isSitting && !this.theEntity.func_70909_n())) : this.isSitting);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 51 */     super.func_75249_e();
/* 52 */     this.theEntity.func_70661_as().func_75499_g();
/* 53 */     this.theEntity.func_70904_g(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 62 */     super.func_75251_c();
/* 63 */     this.theEntity.func_70904_g(false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75270_a(boolean sitting) {
/* 72 */     super.func_75270_a(sitting);
/* 73 */     this.isSitting = sitting;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAISitTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */