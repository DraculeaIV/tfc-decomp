/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ public enum EnumFuelMaterial
/*    */ {
/*  5 */   ASH("ASH", 696, 1250, new int[] { -15, 12, 0, 0, 0 }),
/*  6 */   ASPEN("ASPEN", 611, 1000, new int[] { 0, -11, 0, 12, 5 }),
/*  7 */   BIRCH("BIRCH", 652, 1750, new int[] { -4, -4, 0, 3, 0 }),
/*  8 */   CHESTNUT("CHESTNUT", 651, 1500, new int[] { 6, -5, 0, -6, -5 }),
/*  9 */   DOUGLASFIR("DOUGLASFIR", 707, 1500, new int[] { -14, 14, 0, 18, -9 }),
/* 10 */   HICKORY("HICKORY", 762, 2000, new int[] { -5, -6, 0, -8, 13 }),
/* 11 */   MAPLE("MAPLE", 745, 2000, new int[] { 8, -4, 0, -5, 5 }),
/* 12 */   OAK("OAK", 728, 2250, new int[] { 0, -8, 0, -8, 12 }),
/* 13 */   PINE("PINE", 627, 1250, new int[] { -19, 23, 0, 21, -19 }),
/* 14 */   REDWOOD("REDWOOD", 612, 1750, new int[] { -13, 9, 0, 12, 6 }),
/* 15 */   SPRUCE("SPRUCE", 608, 1500, new int[] { -17, 16, 0, -9, -13 }),
/* 16 */   SYCAMORE("SYCAMORE", 653, 1750, new int[] { 8, 15, 0, 17, -6 }),
/* 17 */   WHITECEDAR("WHITECEDAR", 625, 1500, new int[] { -5, 9, 0, 16, -3 }),
/* 18 */   WHITEELM("WHITEELM", 647, 1750, new int[] { 0, 0, 0, 0, 0 }),
/* 19 */   WILLOW("WILLOW", 603, 1000, new int[] { -4, -6, 0, 9, -2 }),
/* 20 */   KAPOK("KAPOK", 645, 1000, new int[] { 7, 0, 0, -7, 0 }),
/* 21 */   PEAT("PEAT", 680, 2500, new int[] { -10, 0, 0, 10, 0 }),
/* 22 */   ACACIA("ACACIA", 650, 1000, new int[] { 6, 6, 0, 9, -6 }),
/* 23 */   CHARCOAL("CHARCOAL", 1350, 1800, new int[] { -10, 8, 0, 4, 15 }),
/* 24 */   COAL("COAL", 1400, 2200, new int[] { -18, 13, 0, 20, 12 });
/*    */   
/*    */   public final int burnTimeMax;
/*    */   
/*    */   public final int burnTempMax;
/*    */   public final int[] tasteProfile;
/*    */   
/*    */   EnumFuelMaterial(String s, int i, int j, int[] taste) {
/* 32 */     this.burnTempMax = i;
/* 33 */     this.burnTimeMax = j;
/* 34 */     this.tasteProfile = (int[])taste.clone();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int[] getFuelProfile(int ordinal) {
/* 39 */     if (ordinal < 0 || ordinal > (values()).length)
/* 40 */       return new int[] { 0, 0, 0, 0, 0 }; 
/* 41 */     return (values()[ordinal]).tasteProfile;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\EnumFuelMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */