/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.WorldGen.WorldCacheManager;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFC_Climate
/*     */ {
/*  20 */   public static Map<World, WorldCacheManager> worldPair = new HashMap<World, WorldCacheManager>();
/*     */   
/*  22 */   private static final float[] Y_FACTOR_CACHE = new float[441];
/*  23 */   private static final float[] Z_FACTOR_CACHE = new float[30001];
/*  24 */   private static final float[][] MONTH_TEMP_CACHE = new float[12][30001];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initCache() {
/*  44 */     for (int y = 0; y < Y_FACTOR_CACHE.length; y++) {
/*     */       float factor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  55 */       if (y < 110) {
/*     */         
/*  57 */         factor = (y * y) / 677.966F;
/*     */       } else {
/*     */         
/*  60 */         factor = 0.16225F * y;
/*     */       } 
/*  62 */       Y_FACTOR_CACHE[y] = factor;
/*     */     } 
/*     */     
/*  65 */     for (int zCoord = 0; zCoord < getMaxZPos() + 1; zCoord++) {
/*     */       
/*  67 */       float factor = 0.0F;
/*  68 */       float z = zCoord;
/*     */       
/*  70 */       factor = (getMaxZPos() - z) / getMaxZPos();
/*     */       
/*  72 */       Z_FACTOR_CACHE[zCoord] = factor;
/*     */       
/*  74 */       for (int month = 0; month < 12; month++) {
/*     */         
/*  76 */         float MAXTEMP = 35.0F;
/*     */         
/*  78 */         double angle = factor * 1.5707963267948966D;
/*  79 */         double latitudeFactor = Math.cos(angle);
/*     */         
/*  81 */         switch (month) {
/*     */ 
/*     */           
/*     */           case 10:
/*  85 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 13.5D * latitudeFactor - latitudeFactor * 55.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 9:
/*     */           case 11:
/*  91 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 12.5D * latitudeFactor - latitudeFactor * 53.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 0:
/*     */           case 8:
/*  97 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 10.0D * latitudeFactor - latitudeFactor * 46.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/*     */           case 7:
/* 103 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 7.5D * latitudeFactor - latitudeFactor * 40.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/*     */           case 6:
/* 109 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 5.0D * latitudeFactor - latitudeFactor * 33.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/*     */           case 5:
/* 115 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 2.5D * latitudeFactor - latitudeFactor * 27.0D);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/* 120 */             MONTH_TEMP_CACHE[month][zCoord] = (float)(35.0D - 1.5D * latitudeFactor - latitudeFactor * 27.0D);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static float getZFactor(int zCoord) {
/* 130 */     if (zCoord < 0) {
/* 131 */       zCoord = -zCoord;
/*     */     }
/* 133 */     if (zCoord > getMaxZPos()) {
/* 134 */       zCoord = getMaxZPos();
/*     */     }
/* 136 */     return Z_FACTOR_CACHE[zCoord];
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float getTemp(World world, int x, int z) {
/* 141 */     return getTemp0(world, TFC_Time.currentDay, TFC_Time.getHour(), x, z, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float getTemp(World world, int day, int hour, int x, int z) {
/* 146 */     return getTemp0(world, day, hour, x, z, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float getBioTemp(World world, int day, int x, int z) {
/* 151 */     return getTemp0(world, day, 0, x, z, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static float getTemp0(World world, int day, int hour, int x, int z, boolean bio) {
/* 156 */     if (getCacheManager(world) != null) {
/*     */       
/* 158 */       float hourMod, dailyTemp, zMod = getZFactor(z);
/* 159 */       float zTemp = zMod * getMaxTemperature() - 20.0F + (zMod - 0.5F) * 10.0F;
/*     */       
/* 161 */       float rain = getRainfall(world, x, 144, z);
/* 162 */       float rainMod = (1.0F - rain / 4000.0F) * zMod;
/*     */       
/* 164 */       int month = TFC_Time.getSeasonFromDayOfYear(day, z);
/* 165 */       int lastMonth = TFC_Time.getSeasonFromDayOfYear(day - TFC_Time.daysInMonth, z);
/*     */       
/* 167 */       float monthTemp = getMonthTemp(month, z);
/* 168 */       float lastMonthTemp = getMonthTemp(lastMonth, z);
/*     */       
/* 170 */       int dayOfMonth = TFC_Time.getDayOfMonthFromDayOfYear(day);
/*     */ 
/*     */ 
/*     */       
/* 174 */       if (bio) {
/* 175 */         hourMod = 0.2F;
/* 176 */         dailyTemp = 0.0F;
/*     */       } else {
/* 178 */         int h = (hour - 6) % 24;
/* 179 */         if (h < 0) {
/* 180 */           h += 24;
/*     */         }
/*     */         
/* 183 */         if (h < 12) {
/* 184 */           hourMod = h / 11.0F * 0.3F;
/*     */         } else {
/* 186 */           hourMod = 0.3F - (h - 12.0F) / 11.0F * 0.3F;
/*     */         } 
/* 188 */         dailyTemp = WeatherManager.getInstance().getDailyTemp(day);
/*     */       } 
/*     */       
/* 191 */       float monthDelta = (monthTemp - lastMonthTemp) * dayOfMonth / TFC_Time.daysInMonth;
/* 192 */       float temp = lastMonthTemp + monthDelta;
/*     */       
/* 194 */       temp += dailyTemp + hourMod * (zTemp + dailyTemp);
/*     */       
/* 196 */       if (temp >= 12.0F) {
/* 197 */         temp += 8.0F * rainMod * zMod;
/*     */       } else {
/* 199 */         temp -= 8.0F * rainMod * zMod;
/*     */       } 
/* 201 */       return temp;
/*     */     } 
/* 203 */     return -10.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float getMonthTemp(int season, int z) {
/* 208 */     if (z < 0)
/* 209 */       z = -z; 
/* 210 */     if (z > getMaxZPos())
/* 211 */       z = getMaxZPos(); 
/* 212 */     return MONTH_TEMP_CACHE[season][z];
/*     */   }
/*     */ 
/*     */   
/*     */   protected static float getTempSpecificDay(World world, int day, int x, int z) {
/* 217 */     return getTemp(world, day, 12, x, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getHeightAdjustedTemp(World world, int x, int y, int z) {
/* 222 */     float temp = getTemp(world, x, z);
/* 223 */     temp += getTemp(world, x + 1, z);
/* 224 */     temp += getTemp(world, x - 1, z);
/* 225 */     temp += getTemp(world, x, z + 1);
/* 226 */     temp += getTemp(world, x, z - 1);
/* 227 */     temp /= 5.0F;
/* 228 */     temp = adjustHeightToTemp(y, temp);
/* 229 */     float light = 1.0F;
/*     */     
/* 231 */     if (world.func_72863_F() != null)
/*     */     {
/*     */ 
/*     */       
/* 235 */       if (world.func_72937_j(x, y, z)) {
/*     */         
/* 237 */         light = 0.0F;
/*     */       }
/*     */       else {
/*     */         
/* 241 */         float bl = world.func_72957_l(x, y, z);
/* 242 */         light = 0.25F * (1.0F - bl / 15.0F);
/*     */       } 
/*     */     }
/*     */     
/* 246 */     if (temp > 0.0F) {
/* 247 */       return temp - temp * light;
/*     */     }
/* 249 */     return temp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float adjustHeightToTemp(int y, float temp) {
/* 263 */     if (y > 144) {
/*     */       
/* 265 */       int i = y - 144;
/* 266 */       if (i >= Y_FACTOR_CACHE.length) {
/* 267 */         i = Y_FACTOR_CACHE.length - 1;
/*     */       }
/* 269 */       temp -= Y_FACTOR_CACHE[i];
/*     */     } 
/* 271 */     return temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getHeightAdjustedTempSpecificDay(World world, int day, int x, int y, int z) {
/* 276 */     float temp = getTempSpecificDay(world, day, x, z);
/* 277 */     temp = adjustHeightToTemp(y, temp);
/* 278 */     return temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getHeightAdjustedTempSpecificDay(World world, int day, int hour, int x, int y, int z) {
/* 283 */     float temp = getTemp(world, day, hour, x, z);
/* 284 */     temp = adjustHeightToTemp(y, temp);
/* 285 */     return temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getHeightAdjustedBioTemp(World world, int day, int x, int y, int z) {
/* 290 */     float temp = getBioTemp(world, day, x, z);
/* 291 */     temp = adjustHeightToTemp(y, temp);
/* 292 */     return temp;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getMaxTemperature() {
/* 297 */     return 52.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getBioTemperatureHeight(World world, int x, int y, int z) {
/* 302 */     float temp = 0.0F;
/* 303 */     for (int i = 0; i < 12; i++) {
/*     */       
/* 305 */       float t = getHeightAdjustedBioTemp(world, i * TFC_Time.daysInMonth, x, y, z);
/*     */ 
/*     */       
/* 308 */       temp += t;
/*     */     } 
/* 310 */     return temp / 12.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getBioTemperature(World world, int x, int z) {
/* 315 */     float temp = 0.0F;
/* 316 */     for (int i = 0; i < 24; i++) {
/*     */       
/* 318 */       float t = getBioTemp(world, i * TFC_Time.daysInMonth / 2, x, z);
/*     */ 
/*     */       
/* 321 */       temp += t;
/*     */     } 
/* 323 */     return temp / 24.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int getGrassColor(World world, int x, int y, int z) {
/* 332 */     float temp = (getTemp(world, x, z) + getMaxTemperature()) / getMaxTemperature() * 2.0F;
/*     */     
/* 334 */     float rain = getRainfall(world, x, y, z) / 8000.0F;
/*     */     
/* 336 */     double var1 = Helper.clampFloat(temp, 0.0F, 1.0F);
/* 337 */     double var3 = Helper.clampFloat(rain, 0.0F, 1.0F);
/*     */     
/* 339 */     return ColorizerGrassTFC.getGrassColor(var1, var3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int getFoliageColor(World world, int x, int y, int z) {
/* 348 */     float temperature = getHeightAdjustedTempSpecificDay(world, TFC_Time.getDayOfYear(), x, y, z);
/* 349 */     float rainfall = getRainfall(world, x, y, z);
/* 350 */     if (temperature > 5.0F && rainfall > 100.0F) {
/*     */       
/* 352 */       float temp = (temperature + 35.0F) / (getMaxTemperature() + 35.0F);
/* 353 */       float rain = rainfall / 8000.0F;
/*     */       
/* 355 */       double var1 = Helper.clampFloat(temp, 0.0F, 1.0F);
/* 356 */       double var3 = Helper.clampFloat(rain, 0.0F, 1.0F);
/* 357 */       return ColorizerFoliageTFC.getFoliageColor(var1, var3);
/*     */     } 
/*     */ 
/*     */     
/* 361 */     return ColorizerFoliageTFC.getFoliageDead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int getFoliageColorEvergreen(World world, int x, int y, int z) {
/* 372 */     float rainfall = getRainfall(world, x, y, z);
/* 373 */     if (rainfall > 100.0F) {
/*     */       
/* 375 */       float temp = (getTemp(world, x, z) + 35.0F) / (getMaxTemperature() + 35.0F);
/* 376 */       float rain = rainfall / 8000.0F;
/*     */       
/* 378 */       double var1 = Helper.clampFloat(temp, 0.0F, 1.0F);
/* 379 */       double var3 = Helper.clampFloat(rain, 0.0F, 1.0F);
/* 380 */       return ColorizerFoliageTFC.getFoliageColor(var1, var3);
/*     */     } 
/*     */ 
/*     */     
/* 384 */     return ColorizerFoliageTFC.getFoliageDead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getRainfall(World world, int x, int y, int z) {
/* 394 */     if (world.field_72995_K && TFC_Core.getCDM(world) != null) {
/*     */       
/* 396 */       ChunkData cd = TFC_Core.getCDM(world).getData(x >> 4, z >> 4);
/* 397 */       if (cd != null) {
/* 398 */         return cd.getRainfall(x & 0xF, z & 0xF);
/*     */       }
/*     */     } 
/* 401 */     if (getCacheManager(world) != null) {
/*     */       
/* 403 */       DataLayer dl = getCacheManager(world).getRainfallLayerAt(x, z);
/* 404 */       return (dl != null) ? dl.floatdata1 : DataLayer.RAIN_500.floatdata1;
/*     */     } 
/*     */     
/* 407 */     return DataLayer.RAIN_500.floatdata1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTreeLayer(World world, int x, int y, int z, int index) {
/* 412 */     return (getCacheManager(world).getTreeLayerAt(x, z, index)).data1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static DataLayer getRockLayer(World world, int x, int y, int z, int index) {
/* 417 */     return getCacheManager(world).getRockLayerAt(x, z, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMaxZPos() {
/* 422 */     return 30000;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSwamp(World world, int x, int y, int z) {
/* 427 */     BiomeGenBase biome = world.func_72807_a(x, z);
/* 428 */     if (biome == TFCBiome.SWAMPLAND) {
/* 429 */       return true;
/*     */     }
/* 431 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getStability(World world, int x, int z) {
/* 439 */     if (getCacheManager(world) != null) {
/* 440 */       return (getCacheManager(world).getStabilityLayerAt(x, z)).data1;
/*     */     }
/* 442 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldCacheManager getCacheManager(World world) {
/* 447 */     return worldPair.get(world);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeCacheManager(World world) {
/* 452 */     if (worldPair.containsKey(world))
/* 453 */       worldPair.remove(world); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_Climate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */