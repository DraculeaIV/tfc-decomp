/*    */ package com.bioxx.tfc.Core;
/*    */ 
/*    */ 
/*    */ public class ColorizerGrassTFC
/*    */ {
/*  6 */   private static int[] grassBuffer = new int[65536];
/*    */ 
/*    */   
/*    */   public static void setGrassBiomeColorizer(int[] par0ArrayOfInteger) {
/* 10 */     grassBuffer = (int[])par0ArrayOfInteger.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getGrassColor(double par0, double par2) {
/* 41 */     par2 *= par0;
/* 42 */     int var4 = (int)((1.0D - par0) * 255.0D);
/* 43 */     int var5 = (int)((1.0D - par2) * 255.0D);
/* 44 */     return grassBuffer[var5 << 8 | var4];
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getGrassDead() {
/* 49 */     return 5198608;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\ColorizerGrassTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */