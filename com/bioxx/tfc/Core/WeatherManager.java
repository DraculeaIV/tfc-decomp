/*    */ package com.bioxx.tfc.Core;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class WeatherManager
/*    */ {
/*  9 */   protected static final WeatherManager INSTANCE = new WeatherManager();
/* 10 */   private Random rand = new Random();
/* 11 */   private Random clientRand = new Random();
/*    */   
/*    */   public static final WeatherManager getInstance() {
/* 14 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long seed;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float getDailyTemp() {
/* 32 */     this.rand.setSeed(this.seed + TFC_Time.getTotalDays());
/* 33 */     return ((this.rand.nextInt(200) - 100) / 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public float getDailyTemp(int day) {
/* 38 */     this.rand.setSeed(this.seed + day);
/* 39 */     return ((this.rand.nextInt(200) - 100) / 20);
/*    */   }
/*    */ 
/*    */   
/*    */   public float getWeeklyTemp(int week) {
/* 44 */     this.rand.setSeed(this.seed + week);
/* 45 */     return ((this.rand.nextInt(200) - 100) / 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getDayOfWeek(long day) {
/* 50 */     long days = day / 6L;
/* 51 */     return (int)(day - days * 6L);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canSnow(World world, int x, int y, int z) {
/* 56 */     return (TFC_Climate.getHeightAdjustedTemp(world, x, y, z) <= 0.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public float getLocalFog(World world, int x, int y, int z) {
/* 61 */     if (world.field_72995_K) {
/*    */       
/* 63 */       int hour = TFC_Time.getHour();
/* 64 */       if (hour >= 4 && hour < 9) {
/*    */         
/* 66 */         this.clientRand.setSeed(TFC_Time.getTotalDays());
/* 67 */         float rain = TFC_Climate.getRainfall(world, x, y, z);
/* 68 */         float strength = this.clientRand.nextFloat();
/* 69 */         if (rain >= 500.0F && this.clientRand.nextInt(3) == 0) {
/*    */           
/* 71 */           float mult = 1.0F;
/* 72 */           if (9 - hour < 2)
/* 73 */             mult = 0.5F; 
/* 74 */           return strength * mult;
/*    */         } 
/*    */       } 
/*    */     } 
/* 78 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getSnowStrength() {
/* 83 */     int hour = TFC_Time.getHour();
/* 84 */     this.clientRand.setSeed((TFC_Time.getTotalDays() + hour));
/* 85 */     return this.clientRand.nextFloat();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\WeatherManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */