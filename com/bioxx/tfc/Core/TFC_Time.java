/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFC_Time
/*     */ {
/*  11 */   public static final String[] SEASONS = new String[] { 
/*  12 */       TFC_Core.translate("gui.Calendar.EarlySpring"), 
/*  13 */       TFC_Core.translate("gui.Calendar.Spring"), TFC_Core.translate("gui.Calendar.LateSpring"), 
/*  14 */       TFC_Core.translate("gui.Calendar.EarlySummer"), TFC_Core.translate("gui.Calendar.Summer"), 
/*  15 */       TFC_Core.translate("gui.Calendar.LateSummer"), TFC_Core.translate("gui.Calendar.EarlyAutumn"), 
/*  16 */       TFC_Core.translate("gui.Calendar.Autumn"), TFC_Core.translate("gui.Calendar.LateAutumn"), 
/*  17 */       TFC_Core.translate("gui.Calendar.EarlyWinter"), TFC_Core.translate("gui.Calendar.Winter"), 
/*  18 */       TFC_Core.translate("gui.Calendar.LateWinter") };
/*  19 */   public static final String[] MONTHS = new String[] { 
/*  20 */       TFC_Core.translate("gui.Calendar.March"), 
/*  21 */       TFC_Core.translate("gui.Calendar.April"), TFC_Core.translate("gui.Calendar.May"), 
/*  22 */       TFC_Core.translate("gui.Calendar.June"), TFC_Core.translate("gui.Calendar.July"), 
/*  23 */       TFC_Core.translate("gui.Calendar.August"), TFC_Core.translate("gui.Calendar.September"), 
/*  24 */       TFC_Core.translate("gui.Calendar.October"), TFC_Core.translate("gui.Calendar.November"), 
/*  25 */       TFC_Core.translate("gui.Calendar.December"), TFC_Core.translate("gui.Calendar.January"), 
/*  26 */       TFC_Core.translate("gui.Calendar.February") };
/*  27 */   public static final String[] DAYS = new String[] {
/*  28 */       TFC_Core.translate("gui.Calendar.Sunday"), 
/*  29 */       TFC_Core.translate("gui.Calendar.Monday"), TFC_Core.translate("gui.Calendar.Tuesday"), 
/*  30 */       TFC_Core.translate("gui.Calendar.Wednesday"), TFC_Core.translate("gui.Calendar.Thursday"), 
/*  31 */       TFC_Core.translate("gui.Calendar.Friday"), TFC_Core.translate("gui.Calendar.Saturday")
/*     */     };
/*     */   public static int currentDay;
/*  34 */   public static int lastMonth = 11;
/*     */   
/*     */   public static int currentMonth;
/*     */   
/*     */   public static int currentYear;
/*     */   
/*     */   private static long time;
/*     */   
/*     */   private static long MainWorldTime;
/*     */   
/*     */   public static final int JANUARY = 10;
/*     */   
/*     */   public static final int FEBRUARY = 11;
/*     */   
/*     */   public static final int MARCH = 0;
/*     */   public static final int APRIL = 1;
/*     */   public static final int MAY = 2;
/*     */   public static final int JUNE = 3;
/*     */   public static final int JULY = 4;
/*     */   public static final int AUGUST = 5;
/*     */   public static final int SEPTEMBER = 6;
/*     */   public static final int OCTOBER = 7;
/*     */   public static final int NOVEMBER = 8;
/*     */   public static final int DECEMBER = 9;
/*     */   public static final long HOUR_LENGTH = 1000L;
/*     */   public static final int DAY_LENGTH = 24000;
/*     */   public static final int HOURS_IN_DAY = 24;
/*  61 */   public static float timeRatio360 = TFCOptions.yearLength / 360.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static float timeRatio96 = TFCOptions.yearLength / 96.0F;
/*     */   
/*  68 */   public static int daysInYear = TFCOptions.yearLength;
/*  69 */   public static int daysInMonth = daysInYear / 12;
/*  70 */   public static long ticksInYear = (daysInYear * 24000);
/*  71 */   public static long ticksInMonth = (daysInMonth * 24000);
/*  72 */   public static long startTime = ticksInMonth * 3L;
/*     */ 
/*     */   
/*     */   public static void setYearLength(int length) {
/*  76 */     daysInYear = length;
/*  77 */     daysInMonth = daysInYear / 12;
/*  78 */     ticksInYear = (daysInYear * 24000);
/*  79 */     ticksInMonth = (daysInMonth * 24000);
/*  80 */     startTime = ticksInMonth * 3L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateTime(World world) {
/*  85 */     time = world.func_72912_H().func_76073_f();
/*     */     
/*  87 */     if (time < startTime) {
/*     */       
/*  89 */       world.func_72912_H().func_76068_b(startTime);
/*  90 */       world.func_72912_H().func_82572_b(startTime);
/*     */     } 
/*  92 */     if (!world.field_72995_K) {
/*     */       
/*  94 */       MainWorldTime = DimensionManager.getWorld(0).func_72912_H().func_76073_f();
/*  95 */       if (time != MainWorldTime) {
/*     */         
/*  97 */         world.func_72912_H().func_76068_b(MainWorldTime);
/*  98 */         world.func_72912_H().func_82572_b(MainWorldTime);
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     int m = getMonth();
/* 103 */     int m1 = m - 1;
/*     */     
/* 105 */     if (m1 < 0) {
/* 106 */       m1 = 11;
/*     */     }
/* 108 */     lastMonth = m1;
/* 109 */     currentDay = getDayOfYear();
/* 110 */     currentMonth = m;
/* 111 */     currentYear = getYear();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDateStringFromHours(int tHours) {
/* 116 */     int tDays = tHours / 24;
/*     */     
/* 118 */     int day = tDays % daysInMonth;
/* 119 */     int tMonths = tDays / daysInMonth;
/*     */     
/* 121 */     int month = tMonths % 12;
/* 122 */     int year = tMonths / 12;
/*     */ 
/*     */     
/* 125 */     if (tHours < 0) {
/* 126 */       day += daysInMonth - 1;
/* 127 */       month += 11;
/* 128 */       year--;
/*     */     } 
/*     */ 
/*     */     
/* 132 */     if (month >= 10) {
/* 133 */       year++;
/*     */     }
/*     */     
/* 136 */     int d = day + 1;
/* 137 */     String m = MONTHS[month];
/* 138 */     int y = 1000 + year;
/*     */     
/* 140 */     String date = d + " " + m + ", " + y;
/*     */     
/* 142 */     return date;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getHoursInMonth() {
/* 147 */     return 24 * daysInMonth;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getSeason() {
/* 152 */     return SEASONS[getMonth()];
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getTotalTicks() {
/* 157 */     return time;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfWeek() {
/* 162 */     long day = (getTotalDays() + 1);
/* 163 */     long days = day / 7L;
/* 164 */     return (int)(day - days * 7L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfWeek(int tDays) {
/* 169 */     long day = (tDays + 1);
/* 170 */     long days = day / 7L;
/* 171 */     return (int)(day - days * 7L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfMonth() {
/* 176 */     long month = getTotalMonths();
/* 177 */     long days = daysInMonth * month;
/* 178 */     long days2 = getTotalDays() - days;
/* 179 */     return 1 + (int)days2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfMonth(int tDays) {
/* 184 */     int months = tDays / daysInMonth;
/* 185 */     int rem = tDays - months * daysInMonth;
/* 186 */     return 1 + rem;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfYear() {
/* 191 */     long year = getYear();
/* 192 */     long years = ticksInYear * year;
/* 193 */     long years2 = time - years;
/* 194 */     return (int)(years2 / 24000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfYearFromTick(long tick) {
/* 199 */     long years = tick / ticksInYear;
/* 200 */     long years2 = tick - ticksInYear * years;
/* 201 */     return (int)(years2 / 24000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfYearFromDays(long days) {
/* 206 */     long years = days / daysInYear;
/* 207 */     return (int)(days - daysInYear * years);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMonth() {
/* 216 */     long totalmonths = getTotalMonths();
/* 217 */     long totalmonths2 = totalmonths / 12L;
/* 218 */     return (int)(totalmonths - totalmonths2 * 12L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSeasonAdjustedMonth(int z) {
/* 227 */     if (z > 0)
/* 228 */       return (getMonth() + 6) % 12; 
/* 229 */     return getMonth();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getYear() {
/* 234 */     long totalmonths = getTotalMonths();
/* 235 */     return (int)(totalmonths / 12L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTotalDays() {
/* 240 */     return (int)Math.floor(((float)time / 24000.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getTotalHours() {
/* 245 */     return time / 1000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getTotalMonths() {
/* 250 */     return (getTotalDays() / daysInMonth);
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getTotalYears() {
/* 255 */     return getTotalMonths() / 12L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getHour() {
/* 260 */     int th = (int)getTotalHours();
/* 261 */     return getHourOfDayFromTotalHours(th);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getHourOfDayFromTotalHours(int th) {
/* 266 */     return (th + 6) % 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayFromTotalHours(int th) {
/* 271 */     return th / 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayFromTotalHours(long th) {
/* 276 */     return (int)(th / 24L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSpring(int z) {
/* 281 */     int day = (getDayOfYear() + ((z > 0) ? (daysInYear / 2) : 0)) % daysInYear;
/* 282 */     return (day >= 20 && day <= 111);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSummer(int z) {
/* 287 */     int day = (getDayOfYear() + ((z > 0) ? (daysInYear / 2) : 0)) % daysInYear;
/* 288 */     return (day >= 112 && day <= 202);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFall(int z) {
/* 293 */     int day = (getDayOfYear() + ((z > 0) ? (daysInYear / 2) : 0)) % daysInYear;
/* 294 */     return (day >= 203 && day <= 293);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isWinter(int z) {
/* 299 */     int day = (getDayOfYear() + ((z > 0) ? (daysInYear / 2) : 0)) % daysInYear;
/* 300 */     return (day >= 294 || day < 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMonthFromDayOfYear(int day) {
/* 305 */     if (day < 0)
/* 306 */       day = daysInYear + day; 
/* 307 */     return day / daysInMonth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSeasonFromDayOfYear(int day, int z) {
/* 318 */     if (day < 0)
/* 319 */       day = daysInYear + day; 
/* 320 */     return (day / daysInMonth + ((z > 0) ? 6 : 0)) % 12;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDayOfMonthFromDayOfYear(int day) {
/* 325 */     if (day < 0)
/* 326 */       day = daysInYear + day; 
/* 327 */     return day - (int)Math.floor((day / daysInMonth)) * daysInMonth;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getPrevMonth() {
/* 332 */     return lastMonth;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getPrevMonth(int month) {
/* 337 */     if (month == 0)
/* 338 */       return 11; 
/* 339 */     return month - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getYearRatio(float expectedDays) {
/* 344 */     return expectedDays / daysInYear;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMonthsSinceDay(int totalDay) {
/* 349 */     int days = getTotalDays() - totalDay;
/* 350 */     return days / daysInMonth;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_Time.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */