/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ public enum EnumItemReach
/*    */ {
/*  5 */   SHORT("Short", 0.75D),
/*    */   
/*  7 */   MEDIUM("Medium", 1.0D),
/*    */   
/*  9 */   FAR("Far", 1.25D);
/*    */   public final double multiplier;
/*    */   
/*    */   static {
/* 13 */     DISTANCES = new EnumItemReach[] { SHORT, MEDIUM, FAR };
/*    */   }
/*    */   private final String name; private static final EnumItemReach[] DISTANCES;
/*    */   
/*    */   EnumItemReach(String s, double i) {
/* 18 */     this.name = s;
/* 19 */     this.multiplier = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 24 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\EnumItemReach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */