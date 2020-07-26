/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class EntityHorseBredSelector
/*    */   implements IEntitySelector
/*    */ {
/*    */   public boolean func_82704_a(Entity par1Entity) {
/* 14 */     return (par1Entity instanceof EntityHorseTFC && ((EntityHorseTFC)par1Entity).func_110205_ce());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityHorseBredSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */