/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ public enum EnumWeight
/*    */ {
/*  5 */   LIGHT("Light", 4),
/*    */   
/*  7 */   MEDIUM("Medium", 2),
/*    */   
/*  9 */   HEAVY("Heavy", 1);
/*    */   public final int multiplier;
/*    */   
/*    */   static {
/* 13 */     WEIGHTS = new EnumWeight[] { LIGHT, MEDIUM, HEAVY };
/*    */   }
/*    */   private final String name; private static final EnumWeight[] WEIGHTS;
/*    */   
/*    */   EnumWeight(String s, int i) {
/* 18 */     this.name = s;
/* 19 */     this.multiplier = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 24 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\EnumWeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */