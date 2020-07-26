/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ public enum EnumSize
/*    */ {
/*  5 */   TINY("Tiny", 64),
/*    */   
/*  7 */   VERYSMALL("Very Small", 32),
/*    */   
/*  9 */   SMALL("Small", 16),
/*    */   
/* 11 */   MEDIUM("Medium", 8),
/*    */   
/* 13 */   LARGE("Large", 4),
/*    */   
/* 15 */   VERYLARGE("Very Large", 2),
/*    */   
/* 17 */   HUGE("Huge", 1);
/*    */   public final int stackSize;
/*    */   
/*    */   static {
/* 21 */     SIZES = new EnumSize[] { TINY, VERYSMALL, SMALL, MEDIUM, LARGE, VERYLARGE, HUGE };
/*    */   }
/*    */   private final String name; private static final EnumSize[] SIZES;
/*    */   
/*    */   EnumSize(String s, int i) {
/* 26 */     this.name = s;
/* 27 */     this.stackSize = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 32 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\EnumSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */