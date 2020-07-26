/*    */ package com.bioxx.tfc.api.Interfaces;
/*    */ 
/*    */ public interface IEquipable {
/*    */   EquipType getEquipType(ItemStack paramItemStack);
/*    */   
/*    */   void onEquippedRender();
/*    */   
/*    */   boolean getTooHeavyToCarry(ItemStack paramItemStack);
/*    */   
/*    */   public enum EquipType {
/* 11 */     BACK, NULL;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Interfaces\IEquipable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */