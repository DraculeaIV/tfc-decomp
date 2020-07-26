/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.WorldGen.Data.DataCache;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Drainage.GenDrainageLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.EVT.GenEVTLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.PH.GenPHLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rain.GenRainLayerTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock.GenRockLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Stability.GenStabilityLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Tree.GenTreeLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.gen.layer.IntCache;
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
/*     */ 
/*     */ 
/*     */ public class WorldCacheManager
/*     */ {
/*     */   protected GenLayerTFC[] rocksIndexLayer;
/*     */   protected DataCache[] rockCache;
/*     */   protected GenLayerTFC[] treesIndexLayer;
/*     */   protected DataCache[] treeCache;
/*     */   protected GenLayerTFC evtIndexLayer;
/*     */   protected DataCache evtCache;
/*     */   protected GenLayerTFC rainfallIndexLayer;
/*     */   protected DataCache rainfallCache;
/*     */   protected GenLayerTFC stabilityIndexLayer;
/*     */   protected DataCache stabilityCache;
/*     */   protected GenLayerTFC phIndexLayer;
/*     */   protected DataCache phCache;
/*     */   protected GenLayerTFC drainageIndexLayer;
/*     */   protected DataCache drainageCache;
/*     */   protected Map<String, Float> worldTempCache;
/*     */   public long seed;
/*  56 */   public static final DataLayer[] ROCK_LAYER_1 = new DataLayer[] { DataLayer.SHALE, DataLayer.CLAYSTONE, DataLayer.ROCKSALT, DataLayer.LIMESTONE, DataLayer.CONGLOMERATE, DataLayer.DOLOMITE, DataLayer.CHERT, DataLayer.CHALK, DataLayer.RHYOLITE, DataLayer.BASALT, DataLayer.ANDESITE, DataLayer.DACITE, DataLayer.QUARTZITE, DataLayer.SLATE, DataLayer.PHYLLITE, DataLayer.SCHIST, DataLayer.GNEISS, DataLayer.MARBLE, DataLayer.GRANITE, DataLayer.DIORITE, DataLayer.GABBRO };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final DataLayer[] ROCK_LAYER_2 = new DataLayer[] { DataLayer.RHYOLITE, DataLayer.BASALT, DataLayer.ANDESITE, DataLayer.DACITE, DataLayer.QUARTZITE, DataLayer.SLATE, DataLayer.PHYLLITE, DataLayer.SCHIST, DataLayer.GNEISS, DataLayer.MARBLE, DataLayer.GRANITE, DataLayer.DIORITE, DataLayer.GABBRO };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final DataLayer[] ROCK_LAYER_3 = new DataLayer[] { DataLayer.RHYOLITE, DataLayer.BASALT, DataLayer.ANDESITE, DataLayer.DACITE, DataLayer.GRANITE, DataLayer.DIORITE, DataLayer.GABBRO };
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final DataLayer[] TREE_ARRAY = new DataLayer[] { DataLayer.ASH, DataLayer.ASPEN, DataLayer.BIRCH, DataLayer.CHESTNUT, DataLayer.DOUGLASFIR, DataLayer.HICKORY, DataLayer.MAPLE, DataLayer.OAK, DataLayer.PINE, DataLayer.REDWOOD, DataLayer.PINE, DataLayer.SPRUCE, DataLayer.SYCAMORE, DataLayer.WHITECEDAR, DataLayer.WHITEELM, DataLayer.WILLOW, DataLayer.NO_TREE };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WorldCacheManager() {
/*  77 */     this.rockCache = new DataCache[3];
/*  78 */     this.treeCache = new DataCache[3];
/*  79 */     this.evtCache = new DataCache(this, 0);
/*  80 */     this.rainfallCache = new DataCache(this, 0);
/*  81 */     this.rockCache[0] = new DataCache(this, 0);
/*  82 */     this.rockCache[1] = new DataCache(this, 1);
/*  83 */     this.rockCache[2] = new DataCache(this, 2);
/*  84 */     this.treeCache[0] = new DataCache(this, 0);
/*  85 */     this.treeCache[1] = new DataCache(this, 1);
/*  86 */     this.treeCache[2] = new DataCache(this, 2);
/*  87 */     this.stabilityCache = new DataCache(this, 0);
/*  88 */     this.phCache = new DataCache(this, 0);
/*  89 */     this.drainageCache = new DataCache(this, 0);
/*  90 */     this.worldTempCache = new LinkedHashMap<String, Float>();
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldCacheManager(World world) {
/*  95 */     this(world.func_72905_C(), world.func_72912_H().func_76067_t());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private WorldCacheManager(long genSeed, WorldType worldtype) {
/* 101 */     this();
/* 102 */     this.seed = genSeed;
/*     */ 
/*     */     
/* 105 */     this.rocksIndexLayer = new GenLayerTFC[3];
/* 106 */     this.rocksIndexLayer[0] = GenRockLayer.initialize(genSeed + 1L, ROCK_LAYER_1);
/* 107 */     this.rocksIndexLayer[1] = GenRockLayer.initialize(genSeed + 2L, ROCK_LAYER_2);
/* 108 */     this.rocksIndexLayer[2] = GenRockLayer.initialize(genSeed + 3L, ROCK_LAYER_3);
/*     */ 
/*     */ 
/*     */     
/* 112 */     this.treesIndexLayer = new GenLayerTFC[3];
/*     */     
/* 114 */     this.treesIndexLayer[0] = GenTreeLayer.initialize(genSeed + 4L, TREE_ARRAY);
/* 115 */     this.treesIndexLayer[1] = GenTreeLayer.initialize(genSeed + 5L, TREE_ARRAY);
/* 116 */     this.treesIndexLayer[2] = GenTreeLayer.initialize(genSeed + 6L, TREE_ARRAY);
/*     */ 
/*     */     
/* 119 */     this.evtIndexLayer = GenEVTLayer.initialize(genSeed + 7L, worldtype);
/*     */ 
/*     */     
/* 122 */     this.rainfallIndexLayer = GenRainLayerTFC.initialize(genSeed + 8L, worldtype);
/*     */ 
/*     */     
/* 125 */     this.stabilityIndexLayer = GenStabilityLayer.initialize(genSeed + 9L, worldtype);
/*     */ 
/*     */     
/* 128 */     this.phIndexLayer = GenPHLayer.initialize(genSeed + 10L, worldtype);
/*     */ 
/*     */     
/* 131 */     this.drainageIndexLayer = GenDrainageLayer.initialize(genSeed + 11L, worldtype);
/*     */     
/* 133 */     this.worldTempCache = new LinkedHashMap<String, Float>();
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
/* 138 */     IntCache.func_76446_a();
/*     */     
/* 140 */     if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
/* 141 */       par1ArrayOfFloat = new float[par4 * par5];
/*     */     }
/* 143 */     int[] var6 = this.rainfallIndexLayer.func_75904_a(par2, par3, par4, par5);
/*     */     
/* 145 */     for (int var7 = 0; var7 < par4 * par5; var7++) {
/*     */       
/* 147 */       float var8 = var6[var7];
/* 148 */       var8 = 1.0F - (8000.0F - var8) / 8000.0F;
/* 149 */       if (var8 > 1.0F)
/* 150 */         var8 = 1.0F; 
/* 151 */       par1ArrayOfFloat[var7] = var8;
/*     */     } 
/*     */     
/* 154 */     return par1ArrayOfFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void cleanupCache() {
/* 159 */     this.rockCache[0].cleanupCache();
/* 160 */     this.rockCache[1].cleanupCache();
/* 161 */     this.rockCache[2].cleanupCache();
/* 162 */     this.treeCache[0].cleanupCache();
/* 163 */     this.treeCache[1].cleanupCache();
/* 164 */     this.treeCache[2].cleanupCache();
/* 165 */     this.evtCache.cleanupCache();
/* 166 */     this.rainfallCache.cleanupCache();
/* 167 */     this.stabilityCache.cleanupCache();
/* 168 */     this.phCache.cleanupCache();
/* 169 */     this.drainageCache.cleanupCache();
/* 170 */     while (this.worldTempCache.size() > 51000)
/*     */     {
/* 172 */       trimTempCache();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTemp(int x, int z, int totalHours) {
/* 178 */     String key = x + "," + z + "," + totalHours;
/* 179 */     if (this.worldTempCache != null && this.worldTempCache.containsKey(key))
/*     */     {
/* 181 */       return ((Float)this.worldTempCache.get(key)).floatValue();
/*     */     }
/* 183 */     return Float.MIN_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addTemp(int x, int z, int totalHours, float temp) {
/* 188 */     String key = x + "," + z + "," + totalHours;
/* 189 */     if (this.worldTempCache != null)
/* 190 */       this.worldTempCache.put(key, Float.valueOf(temp)); 
/* 191 */     trimTempCache();
/*     */   }
/*     */ 
/*     */   
/*     */   private void trimTempCache() {
/* 196 */     if (this.worldTempCache.size() > 50000) {
/*     */       
/* 198 */       Iterator iter = this.worldTempCache.keySet().iterator();
/* 199 */       if (iter.hasNext()) {
/* 200 */         this.worldTempCache.remove(iter.next());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public DataLayer getDataLayerAt(DataCache cache, GenLayerTFC indexLayers, int par1, int par2, int index) {
/* 206 */     return cache.getDataLayerAt(indexLayers, par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] getDataLayerAt(DataCache[] cache, DataLayer[] layers, GenLayerTFC[] indexLayers, int x, int y, int width, int height, boolean par6, int layer) {
/* 216 */     if (layers == null || layers.length < width * height) {
/* 217 */       layers = new DataLayer[width * height];
/*     */     }
/* 219 */     if (par6 && width == 16 && height == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
/*     */       
/* 221 */       DataLayer[] var9 = cache[layer].getCachedData(indexLayers[layer], x, y);
/* 222 */       System.arraycopy(var9, 0, layers, 0, width * height);
/* 223 */       return layers;
/*     */     } 
/*     */ 
/*     */     
/* 227 */     IntCache.func_76446_a();
/* 228 */     int[] var7 = indexLayers[layer].func_75904_a(x, y, width, height);
/* 229 */     for (int var8 = 0; var8 < width * height; var8++)
/*     */     {
/* 231 */       layers[var8] = DataLayer.layers[var7[var8]];
/*     */     }
/* 233 */     return layers;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] getDataLayerAt(DataCache cache, DataLayer[] layers, GenLayerTFC indexLayers, int x, int y, int width, int height, boolean par6, int layer) {
/* 239 */     if (layers == null || layers.length < width * height) {
/* 240 */       layers = new DataLayer[width * height];
/*     */     }
/* 242 */     if (par6 && width == 16 && height == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
/*     */       
/* 244 */       DataLayer[] var9 = cache.getCachedData(indexLayers, x, y);
/* 245 */       System.arraycopy(var9, 0, layers, 0, width * height);
/* 246 */       return layers;
/*     */     } 
/*     */ 
/*     */     
/* 250 */     IntCache.func_76446_a();
/* 251 */     int[] var7 = indexLayers.func_75904_a(x, y, width, height);
/* 252 */     for (int var8 = 0; var8 < width * height; var8++)
/*     */     {
/* 254 */       layers[var8] = DataLayer.layers[var7[var8]];
/*     */     }
/* 256 */     return layers;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer getRockLayerAt(int x, int y, int index) {
/* 262 */     return this.rockCache[index].getDataLayerAt(this.rocksIndexLayer[index], x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] loadRockLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height, int layer) {
/* 271 */     return getDataLayerAt((DataCache[])this.rockCache.clone(), layers, this.rocksIndexLayer, x, y, width, height, true, layer);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getTreeLayerAt(int x, int z, int index) {
/* 276 */     return this.treeCache[index].getDataLayerAt(this.treesIndexLayer[index], x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] loadTreeLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height, int layer) {
/* 285 */     return getDataLayerAt((DataCache[])this.treeCache.clone(), layers, this.treesIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getEVTLayerAt(int x, int z) {
/* 290 */     return this.evtCache.getDataLayerAt(this.evtIndexLayer, x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] loadEVTLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height) {
/* 299 */     return getDataLayerAt(this.evtCache, layers, this.evtIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getRainfallLayerAt(int x, int z) {
/* 304 */     return this.rainfallCache.getDataLayerAt(this.rainfallIndexLayer, x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLayer[] loadRainfallLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height) {
/* 312 */     return getDataLayerAt(this.rainfallCache, layers, this.rainfallIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getStabilityLayerAt(int x, int z) {
/* 317 */     return this.stabilityCache.getDataLayerAt(this.stabilityIndexLayer, x, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer[] loadStabilityLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height) {
/* 322 */     return getDataLayerAt(this.stabilityCache, layers, this.stabilityIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getPHLayerAt(int x, int z) {
/* 327 */     DataLayer dl = this.phCache.getDataLayerAt(this.phIndexLayer, x, z);
/* 328 */     return (dl != null) ? dl : DataLayer.PH_NEUTRAL;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer[] loadPHLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height) {
/* 333 */     return getDataLayerAt(this.phCache, layers, this.phIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer getDrainageLayerAt(int x, int z) {
/* 338 */     return this.drainageCache.getDataLayerAt(this.drainageIndexLayer, x, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer[] loadDrainageLayerGeneratorData(DataLayer[] layers, int x, int y, int width, int height) {
/* 343 */     return getDataLayerAt(this.drainageCache, layers, this.drainageIndexLayer, x, y, width, height, true, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\WorldCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */