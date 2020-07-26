/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ public enum EnumDamageType
/*    */ {
/*  5 */   GENERIC(-1),
/*  6 */   PIERCING(0),
/*  7 */   SLASHING(1),
/*  8 */   CRUSHING(2);
/*    */   
/*    */   public int damageID;
/*    */ 
/*    */   
/*    */   EnumDamageType(int id) {
/* 14 */     this.damageID = id;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     switch (this) {
/*    */       case PIERCING:
/* 22 */         return "gui.DamageType.Piercing";
/* 23 */       case SLASHING: return "gui.DamageType.Slashing";
/* 24 */       case CRUSHING: return "gui.DamageType.Crushing";
/* 25 */     }  return "gui.DamageType.Error";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\EnumDamageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */