/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.ModSupport.Weather2;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class WeatherManager
/*     */ {
/*  11 */   protected static final WeatherManager INSTANCE = new WeatherManager();
/*  12 */   private Random rand = new Random();
/*  13 */   private Random clientRand = new Random();
/*     */   
/*     */   public static final WeatherManager getInstance() {
/*  16 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long seed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDailyTemp() {
/*  34 */     this.rand.setSeed(this.seed + TFC_Time.getTotalDays());
/*  35 */     return ((this.rand.nextInt(200) - 100) / 10);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDailyTemp(int day) {
/*  40 */     this.rand.setSeed(this.seed + day);
/*  41 */     return ((this.rand.nextInt(200) - 100) / 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWeeklyTemp(int week) {
/*  46 */     this.rand.setSeed(this.seed + week);
/*  47 */     return ((this.rand.nextInt(200) - 100) / 10);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfWeek(long day) {
/*  52 */     long days = day / 6L;
/*  53 */     return (int)(day - days * 6L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canSnow(World world, int x, int y, int z) {
/*  58 */     return (TFC_Climate.getHeightAdjustedTemp(world, x, y, z) <= 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLocalFog(World world, int x, int y, int z) {
/*  63 */     if (world.field_72995_K) {
/*     */       
/*  65 */       int hour = TFC_Time.getHour();
/*  66 */       if (hour >= 4 && hour < 9) {
/*     */         
/*  68 */         this.clientRand.setSeed(TFC_Time.getTotalDays());
/*  69 */         float rain = TFC_Climate.getRainfall(world, x, y, z);
/*  70 */         float strength = this.clientRand.nextFloat();
/*  71 */         if (rain >= 500.0F && this.clientRand.nextInt(3) == 0) {
/*     */           
/*  73 */           float mult = 1.0F;
/*  74 */           if (9 - hour < 2)
/*  75 */             mult = 0.5F; 
/*  76 */           return strength * mult;
/*     */         } 
/*     */       } 
/*     */     } 
/*  80 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getSnowStrength() {
/*  85 */     int hour = TFC_Time.getHour();
/*  86 */     this.clientRand.setSeed((TFC_Time.getTotalDays() + hour));
/*  87 */     return this.clientRand.nextFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isRainingOnCoord(World worldObj, int xCoord, int yCoord, int zCoord) {
/*  92 */     if (worldObj.func_147439_a(xCoord, yCoord, zCoord) != null && worldObj.func_72937_j(xCoord, yCoord, zCoord)) {
/*     */       
/*  94 */       if (Loader.isModLoaded("weather2") && !worldObj.field_72995_K) {
/*     */         
/*  96 */         Weather2 weather2 = new Weather2();
/*  97 */         return weather2.isRainingOnCoord(worldObj, xCoord, yCoord, zCoord);
/*     */       } 
/*  99 */       return TFC_Core.isExposedToRain(worldObj, xCoord, yCoord, zCoord);
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\WeatherManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */