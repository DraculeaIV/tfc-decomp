/*    */ package com.bioxx.tfc.Entities.AI;
/*    */ 
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityAIAttackTFC
/*    */   extends EntityAINearestAttackableTarget
/*    */ {
/*    */   public EntityAIAttackTFC(IAnimal par1EntityTameable, Class par2Class, int par3, boolean par4) {
/* 13 */     super((EntityCreature)par1EntityTameable, par2Class, par3, par4);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\AI\EntityAIAttackTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */