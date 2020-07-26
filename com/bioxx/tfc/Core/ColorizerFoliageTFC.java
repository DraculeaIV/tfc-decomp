/*    */ package com.bioxx.tfc.Core;
/*    */ 
/*    */ 
/*    */ public class ColorizerFoliageTFC
/*    */ {
/*  6 */   private static int[] foliageBuffer = new int[65536];
/*    */ 
/*    */   
/*    */   public static void setFoliageBiomeColorizer(int[] par0ArrayOfInteger) {
/* 10 */     foliageBuffer = (int[])par0ArrayOfInteger.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getFoliageColor(double par0, double par2) {
/* 18 */     par2 *= par0;
/* 19 */     int var4 = (int)((1.0D - par0) * 255.0D);
/* 20 */     int var5 = (int)((1.0D - par2) * 255.0D);
/* 21 */     return foliageBuffer[var5 << 8 | var4];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getFoliageColorPine() {
/* 29 */     return 6396257;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getFoliageColorBirch() {
/* 37 */     return 8431445;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getFoliageColorBasic() {
/* 42 */     return 4764952;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getFoliageDead() {
/* 47 */     return 9004839;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getFoliageOrange() {
/* 52 */     return 15765504;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getFoliageYellow() {
/* 57 */     return 16763904;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getFoliageRed() {
/* 62 */     return 9312280;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\ColorizerFoliageTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */