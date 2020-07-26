/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockCollapsible;
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityBear;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityChickenTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityDeer;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPheasantTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityPigTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntitySheepTFC;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityWolfTFC;
/*     */ import com.bioxx.tfc.WorldGen.MapGen.MapGenCavesTFC;
/*     */ import com.bioxx.tfc.WorldGen.MapGen.MapGenRavineTFC;
/*     */ import com.bioxx.tfc.WorldGen.MapGen.MapGenRiverRavine;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.ChunkProviderGenerate;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.terraingen.PopulateChunkEvent;
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
/*     */ public class TFCChunkProviderGenerate
/*     */   extends ChunkProviderGenerate
/*     */ {
/*     */   private Random rand;
/*     */   private NoiseGeneratorOctaves noiseGen1;
/*     */   private NoiseGeneratorOctaves noiseGen2;
/*     */   private NoiseGeneratorOctaves noiseGen3;
/*     */   private NoiseGeneratorOctaves noiseGen4;
/*     */   public NoiseGeneratorOctaves field_73212_b;
/*     */   public NoiseGeneratorOctaves field_73213_c;
/*     */   private World worldObj;
/*     */   private double[] noiseArray;
/*  62 */   private double[] stoneNoise = new double[256];
/*     */ 
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */ 
/*     */   
/*     */   private DataLayer[] rockLayer1;
/*     */ 
/*     */   
/*     */   private DataLayer[] rockLayer2;
/*     */ 
/*     */   
/*     */   private DataLayer[] rockLayer3;
/*     */   
/*     */   private DataLayer[] evtLayer;
/*     */   
/*     */   private DataLayer[] rainfallLayer;
/*     */   
/*     */   private DataLayer[] stabilityLayer;
/*     */   
/*     */   private DataLayer[] drainageLayer;
/*     */   
/*     */   private Block[] idsTop;
/*     */   
/*     */   private Block[] idsBig;
/*     */   
/*     */   private byte[] metaBig;
/*     */   
/*     */   private double[] noise3;
/*     */   
/*     */   private double[] noise1;
/*     */   
/*     */   private double[] noise2;
/*     */   
/*     */   private double[] noise6;
/*     */   
/*     */   private float[] parabolicField;
/*     */   
/* 100 */   private int[] seaLevelOffsetMap = new int[256];
/* 101 */   private int[] chunkHeightMap = new int[256];
/*     */   
/* 103 */   private MapGenCavesTFC caveGen = new MapGenCavesTFC();
/* 104 */   private MapGenRavineTFC surfaceRavineGen = new MapGenRavineTFC(125, 30);
/* 105 */   private MapGenRavineTFC ravineGen = new MapGenRavineTFC(20, 50);
/* 106 */   private MapGenRiverRavine riverRavineGen = new MapGenRiverRavine();
/*     */ 
/*     */   
/*     */   public TFCChunkProviderGenerate(World par1World, long par2, boolean par4) {
/* 110 */     super(par1World, par2, par4);
/*     */     
/* 112 */     this.worldObj = par1World;
/* 113 */     this.rand = new Random(par2);
/* 114 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 4);
/* 115 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/* 116 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/* 117 */     this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
/* 118 */     this.field_73214_a = new NoiseGeneratorOctaves(this.rand, 2);
/* 119 */     this.field_73212_b = new NoiseGeneratorOctaves(this.rand, 1);
/* 120 */     this.field_73213_c = new NoiseGeneratorOctaves(this.rand, 8);
/*     */     
/* 122 */     this.idsTop = new Block[32768];
/* 123 */     this.idsBig = new Block[65536];
/* 124 */     this.metaBig = new byte[65536];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int chunkX, int chunkZ) {
/* 130 */     this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     Arrays.fill((Object[])this.idsTop, (Object)null);
/* 137 */     Arrays.fill((Object[])this.idsBig, (Object)null);
/* 138 */     Arrays.fill(this.metaBig, (byte)0);
/*     */     
/* 140 */     generateTerrainHigh(chunkX, chunkZ, this.idsTop);
/*     */     
/* 142 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, chunkX * 16 - 1, chunkZ * 16 - 1, 18, 18);
/* 143 */     if (TFC_Climate.getCacheManager(this.worldObj) != null) {
/*     */       
/* 145 */       this.rockLayer1 = TFC_Climate.getCacheManager(this.worldObj).loadRockLayerGeneratorData(this.rockLayer1, chunkX * 16, chunkZ * 16, 16, 16, 0);
/* 146 */       this.rockLayer2 = TFC_Climate.getCacheManager(this.worldObj).loadRockLayerGeneratorData(this.rockLayer2, chunkX * 16, chunkZ * 16, 16, 16, 1);
/* 147 */       this.rockLayer3 = TFC_Climate.getCacheManager(this.worldObj).loadRockLayerGeneratorData(this.rockLayer3, chunkX * 16, chunkZ * 16, 16, 16, 2);
/* 148 */       this.evtLayer = TFC_Climate.getCacheManager(this.worldObj).loadEVTLayerGeneratorData(this.evtLayer, chunkX * 16, chunkZ * 16, 16, 16);
/* 149 */       this.rainfallLayer = TFC_Climate.getCacheManager(this.worldObj).loadRainfallLayerGeneratorData(this.rainfallLayer, chunkX * 16, chunkZ * 16, 16, 16);
/* 150 */       this.stabilityLayer = TFC_Climate.getCacheManager(this.worldObj).loadStabilityLayerGeneratorData(this.stabilityLayer, chunkX * 16, chunkZ * 16, 16, 16);
/* 151 */       this.drainageLayer = TFC_Climate.getCacheManager(this.worldObj).loadDrainageLayerGeneratorData(this.drainageLayer, chunkX * 16, chunkZ * 16, 16, 16);
/*     */     } 
/*     */     
/* 154 */     this.seaLevelOffsetMap = new int[256];
/*     */     
/* 156 */     replaceBlocksForBiomeHigh(chunkX, chunkZ, this.idsTop, this.rand, this.idsBig, this.metaBig);
/* 157 */     replaceBlocksForBiomeLow(chunkX, chunkZ, this.rand, this.idsBig, this.metaBig);
/*     */     
/* 159 */     this.caveGen.generate((IChunkProvider)this, this.worldObj, chunkX, chunkZ, this.idsBig, this.metaBig);
/* 160 */     this.surfaceRavineGen.generate((IChunkProvider)this, this.worldObj, chunkX, chunkZ, this.idsBig, this.metaBig);
/* 161 */     this.ravineGen.generate((IChunkProvider)this, this.worldObj, chunkX, chunkZ, this.idsBig, this.metaBig);
/* 162 */     this.riverRavineGen.generate((IChunkProvider)this, this.worldObj, chunkX, chunkZ, this.idsBig, this.metaBig);
/*     */     
/* 164 */     Chunk chunk = new Chunk(this.worldObj, this.idsBig, this.metaBig, chunkX, chunkZ);
/* 165 */     byte[] abyte1 = chunk.func_76605_m();
/*     */     
/* 167 */     for (int x = 0; x < 16; x++) {
/*     */       
/* 169 */       for (int z = 0; z < 16; z++)
/*     */       {
/* 171 */         abyte1[x * z] = (byte)(getBiome(x, z)).field_76756_M;
/*     */       }
/*     */     } 
/* 174 */     chunk.func_76616_a(abyte1);
/*     */     
/* 176 */     ChunkData data = (new ChunkData(chunk)).createNew(this.worldObj, chunkX, chunkZ);
/* 177 */     data.heightmap = this.seaLevelOffsetMap;
/* 178 */     data.rainfallMap = this.rainfallLayer;
/* 179 */     TFC_Core.getCDM(this.worldObj).addData(chunk, data);
/*     */     
/* 181 */     chunk.func_76603_b();
/* 182 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   private BiomeGenBase getBiome(int x, int z) {
/* 187 */     return this.biomesForGeneration[z + 1 + (x + 1) * 18];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider chunkProvider, int chunkX, int chunkZ) {
/* 193 */     BlockCollapsible.fallInstantly = true;
/* 194 */     int xCoord = chunkX * 16;
/* 195 */     int zCoord = chunkZ * 16;
/* 196 */     TFCBiome biome = null;
/*     */     
/* 198 */     if (this.worldObj.func_72807_a(xCoord + 16, zCoord + 16) instanceof TFCBiome)
/*     */     {
/* 200 */       biome = (TFCBiome)this.worldObj.func_72807_a(xCoord + 16, zCoord + 16);
/*     */     }
/*     */     
/* 203 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 204 */     long var7 = this.rand.nextLong() / 2L * 2L + 1L;
/* 205 */     long var9 = this.rand.nextLong() / 2L * 2L + 1L;
/* 206 */     this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.func_72905_C());
/* 207 */     boolean var11 = false;
/*     */     
/* 209 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(chunkProvider, this.worldObj, this.rand, chunkX, chunkZ, var11));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     TFC_Core.getCDM(this.worldObj).setFishPop(chunkX, chunkZ, 60.0F);
/*     */     
/* 217 */     int waterRand = 4;
/* 218 */     if (TFC_Climate.getStability(this.worldObj, xCoord, zCoord) == 1) {
/* 219 */       waterRand = 6;
/*     */     }
/* 221 */     if (!var11 && this.rand.nextInt(waterRand) == 0) {
/*     */       
/* 223 */       int i = xCoord + this.rand.nextInt(16) + 8;
/* 224 */       int z = zCoord + this.rand.nextInt(16) + 8;
/* 225 */       int j = 144 - this.rand.nextInt(45);
/*     */     } 
/*     */ 
/*     */     
/* 229 */     if (biome != null) {
/*     */       
/* 231 */       biome.func_76728_a(this.worldObj, this.rand, xCoord, zCoord);
/* 232 */       SpawnerAnimalsTFC.performWorldGenSpawning(this.worldObj, biome, xCoord + 8, zCoord + 8, 16, 16, this.rand);
/*     */     } 
/*     */     
/* 235 */     for (int x = 0; x < 16; x++) {
/*     */       
/* 237 */       for (int z = 0; z < 16; z++) {
/*     */         
/* 239 */         int y = this.worldObj.func_72874_g(xCoord + x, zCoord + z);
/*     */         
/* 241 */         this.worldObj.func_72884_u(x + xCoord, y - 1, z + zCoord);
/* 242 */         if (canSnowAt(this.worldObj, x + xCoord, y, z + zCoord)) {
/* 243 */           this.worldObj.func_147465_d(x + xCoord, y, z + zCoord, TFCBlocks.snow, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/* 247 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(chunkProvider, this.worldObj, this.rand, chunkX, chunkZ, var11));
/* 248 */     BlockCollapsible.fallInstantly = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<BiomeGenBase.SpawnListEntry> getCreatureSpawnsByChunk(World world, TFCBiome biome, int x, int z) {
/* 253 */     List<BiomeGenBase.SpawnListEntry> spawnableCreatureList = new ArrayList<BiomeGenBase.SpawnListEntry>();
/* 254 */     spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChickenTFC.class, 24, 0, 0));
/* 255 */     float temp = TFC_Climate.getBioTemperatureHeight(world, x, world.func_72825_h(x, z), z);
/* 256 */     float rain = TFC_Climate.getRainfall(world, x, 150, z);
/* 257 */     float evt = 0.0F;
/* 258 */     if (TFC_Climate.getCacheManager(world) != null && TFC_Climate.getCacheManager(world).getEVTLayerAt(x, z) != null)
/* 259 */       evt = (TFC_Climate.getCacheManager(world).getEVTLayerAt(x, z)).floatdata1; 
/* 260 */     boolean isMountainous = (biome == TFCBiome.MOUNTAINS || biome == TFCBiome.HIGH_HILLS);
/*     */     
/* 262 */     int mountainousAreaModifier = isMountainous ? -1 : 0;
/* 263 */     if (isMountainous) {
/*     */       
/* 265 */       if (temp < 25.0F && temp > -10.0F)
/*     */       {
/* 267 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheepTFC.class, 2, 2, 4));
/* 268 */         if (rain > 250.0F && evt < 0.75D)
/*     */         {
/* 270 */           spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolfTFC.class, 2, 1, 3));
/* 271 */           spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBear.class, 1, 1, 1));
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 276 */     } else if (temp > 0.0F && rain > 100.0F && rain <= 500.0F) {
/*     */       
/* 278 */       if (temp > 20.0F)
/*     */       {
/*     */         
/* 281 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigTFC.class, 1, 1, 2));
/*     */       }
/* 283 */       if (temp < 30.0F) {
/*     */         
/* 285 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCowTFC.class, 2, 2, 4));
/* 286 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHorseTFC.class, 2, 2, 3));
/*     */       } 
/*     */     } 
/*     */     
/* 290 */     if (temp > 0.0F && temp < 21.0F && rain > 250.0F) {
/*     */       
/* 292 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigTFC.class, 2 + mountainousAreaModifier, 2 + mountainousAreaModifier, 3 + mountainousAreaModifier));
/* 293 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolfTFC.class, 1, 1, 2 + mountainousAreaModifier));
/* 294 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBear.class, 1, 1, 1));
/* 295 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityDeer.class, 2 + mountainousAreaModifier, 1, 3 + mountainousAreaModifier));
/* 296 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 3 + mountainousAreaModifier, 1, 3));
/*     */     } 
/*     */ 
/*     */     
/* 300 */     if (temp > -20.0F && temp <= 0.0F)
/*     */     {
/*     */       
/* 303 */       if (rain > 250.0F) {
/*     */         
/* 305 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigTFC.class, 1 + mountainousAreaModifier, 1, 2));
/* 306 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolfTFC.class, 2 + mountainousAreaModifier, 1, 2 + mountainousAreaModifier));
/* 307 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBear.class, 2 + mountainousAreaModifier, 1, 1));
/* 308 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityDeer.class, 1 + mountainousAreaModifier, 2, 3));
/* 309 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 1 + mountainousAreaModifier, 1, 2));
/* 310 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheepTFC.class, 2, 2, 4));
/*     */       
/*     */       }
/* 313 */       else if (rain > 100.0F) {
/*     */         
/* 315 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolfTFC.class, 1 + mountainousAreaModifier, 1, 1));
/* 316 */         spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityDeer.class, 1 + mountainousAreaModifier, 1, 1));
/*     */       } 
/*     */     }
/*     */     
/* 320 */     if (temp >= 23.0F && temp < 44.0F && rain > 1500.0F) {
/*     */       
/* 322 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigTFC.class, 2 + mountainousAreaModifier, 2 + mountainousAreaModifier, 4 + mountainousAreaModifier));
/* 323 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChickenTFC.class, 3 + mountainousAreaModifier, 1, 4 + mountainousAreaModifier));
/*     */     } 
/*     */     
/* 326 */     if (TFC_Climate.isSwamp(world, x, 150, z)) {
/*     */       
/* 328 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigTFC.class, 1, 1, 2));
/* 329 */       spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 1 + mountainousAreaModifier, 1, 1));
/*     */     } 
/* 331 */     return spawnableCreatureList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSnowAt(World world, int x, int y, int z) {
/* 336 */     float var5 = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
/* 337 */     if (var5 >= 0.0F)
/*     */     {
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 343 */     if (y >= 0 && y < 256 && world.func_72972_b(EnumSkyBlock.Block, x, y, z) < 10 && TFC_Time.getTotalMonths() > 1L) {
/*     */       
/* 345 */       Block var6 = world.func_147439_a(x, y - 1, z);
/* 346 */       Block var7 = world.func_147439_a(x, y, z);
/* 347 */       if (var7.isAir((IBlockAccess)world, x, y, z) && TFCBlocks.snow.func_149742_c(world, x, y, z) && !var6.isAir((IBlockAccess)world, x, y - 1, z) && var6.func_149688_o().func_76230_c())
/* 348 */         return true; 
/*     */     } 
/* 350 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateTerrainHigh(int chunkX, int chunkZ, Block[] idsTop) {
/* 356 */     byte subDivXZ = 4;
/* 357 */     byte subDivY = 16;
/* 358 */     int seaLevel = 16;
/* 359 */     int xSize = subDivXZ + 1;
/* 360 */     byte ySize = 17;
/* 361 */     int zSize = subDivXZ + 1;
/* 362 */     short arrayYHeight = 128;
/* 363 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, xSize + 5, zSize + 5);
/* 364 */     this.noiseArray = initializeNoiseFieldHigh(this.noiseArray, chunkX * subDivXZ, 0, chunkZ * subDivXZ, xSize, ySize, zSize);
/*     */     
/* 366 */     for (int x = 0; x < subDivXZ; x++) {
/*     */       
/* 368 */       for (int z = 0; z < subDivXZ; z++) {
/*     */         
/* 370 */         for (int y = 0; y < subDivY; y++) {
/*     */           
/* 372 */           double yLerp = 0.125D;
/* 373 */           double noiseDL = this.noiseArray[((x + 0) * zSize + z + 0) * ySize + y + 0];
/* 374 */           double noiseUL = this.noiseArray[((x + 0) * zSize + z + 1) * ySize + y + 0];
/* 375 */           double noiseDR = this.noiseArray[((x + 1) * zSize + z + 0) * ySize + y + 0];
/* 376 */           double noiseUR = this.noiseArray[((x + 1) * zSize + z + 1) * ySize + y + 0];
/* 377 */           double noiseDLA = (this.noiseArray[((x + 0) * zSize + z + 0) * ySize + y + 1] - noiseDL) * yLerp;
/* 378 */           double noiseULA = (this.noiseArray[((x + 0) * zSize + z + 1) * ySize + y + 1] - noiseUL) * yLerp;
/* 379 */           double noiseDRA = (this.noiseArray[((x + 1) * zSize + z + 0) * ySize + y + 1] - noiseDR) * yLerp;
/* 380 */           double noiseURA = (this.noiseArray[((x + 1) * zSize + z + 1) * ySize + y + 1] - noiseUR) * yLerp;
/*     */           
/* 382 */           for (int var31 = 0; var31 < 8; var31++) {
/*     */             
/* 384 */             double xLerp = 0.25D;
/* 385 */             double var34 = noiseDL;
/* 386 */             double var36 = noiseUL;
/* 387 */             double var38 = (noiseDR - noiseDL) * xLerp;
/* 388 */             double var40 = (noiseUR - noiseUL) * xLerp;
/*     */             
/* 390 */             for (int var42 = 0; var42 < 4; var42++) {
/*     */               
/* 392 */               int index = var42 + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + var31;
/*     */               
/* 394 */               index -= arrayYHeight;
/* 395 */               double zLerp = 0.25D;
/* 396 */               double var49 = (var36 - var34) * zLerp;
/* 397 */               double var47 = var34 - var49;
/*     */               
/* 399 */               for (int var51 = 0; var51 < 4; var51++) {
/*     */                 
/* 401 */                 if ((var47 += var49) > 0.0D) {
/* 402 */                   idsTop[index += arrayYHeight] = Blocks.field_150348_b;
/* 403 */                 } else if (y * 8 + var31 < seaLevel) {
/* 404 */                   idsTop[index += arrayYHeight] = TFCBlocks.saltWaterStationary;
/*     */                 } else {
/* 406 */                   idsTop[index += arrayYHeight] = Blocks.field_150350_a;
/*     */                 } 
/* 408 */               }  var34 += var38;
/* 409 */               var36 += var40;
/*     */             } 
/* 411 */             noiseDL += noiseDLA;
/* 412 */             noiseUL += noiseULA;
/* 413 */             noiseDR += noiseDRA;
/* 414 */             noiseUR += noiseURA;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double[] initializeNoiseFieldHigh(double[] outArray, int xPos, int yPos, int zPos, int xSize, int ySize, int zSize) {
/* 427 */     if (outArray == null) {
/* 428 */       outArray = new double[xSize * ySize * zSize];
/*     */     }
/* 430 */     if (this.parabolicField == null) {
/*     */       
/* 432 */       this.parabolicField = new float[25];
/* 433 */       for (int counter1 = -2; counter1 <= 2; counter1++) {
/*     */         
/* 435 */         for (int counter2 = -2; counter2 <= 2; counter2++) {
/*     */           
/* 437 */           float parabolaHeight = 10.0F / MathHelper.func_76129_c((counter1 * counter1 + counter2 * counter2) + 0.2F);
/* 438 */           this.parabolicField[counter1 + 2 + (counter2 + 2) * 5] = parabolaHeight;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     double double1 = 1000.0D;
/* 452 */     double double2 = 1000.0D;
/*     */ 
/*     */ 
/*     */     
/* 456 */     this.noise6 = this.field_73212_b.func_76305_a(this.noise6, xPos, zPos, xSize, zSize, 200.0D, 200.0D, 0.5D);
/* 457 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, xPos, yPos, zPos, xSize, ySize, zSize, double1 / 80.0D, double2 / 160.0D, double1 / 80.0D);
/*     */     
/* 459 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, xPos, yPos, zPos, xSize, ySize, zSize, double1, double2, double1);
/* 460 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, xPos, yPos, zPos, xSize, ySize, zSize, double1, double2, double1);
/*     */     
/* 462 */     int index1 = 0;
/* 463 */     int index2 = 0;
/*     */     
/* 465 */     for (int x = 0; x < xSize; x++) {
/*     */       
/* 467 */       for (int z = 0; z < zSize; z++) {
/*     */         
/* 469 */         float variationBlended = 0.0F;
/* 470 */         float rootBlended = 0.0F;
/* 471 */         float totalBlendedHeight = 0.0F;
/* 472 */         byte radius = 2;
/* 473 */         BiomeGenBase baseBiome = this.biomesForGeneration[x + 2 + (z + 2) * (xSize + 5)];
/*     */         
/* 475 */         for (int xR = -radius; xR <= radius; xR++) {
/*     */           
/* 477 */           for (int zR = -radius; zR <= radius; zR++) {
/*     */             
/* 479 */             BiomeGenBase blendBiome = this.biomesForGeneration[x + xR + 2 + (z + zR + 2) * (xSize + 5)];
/* 480 */             float blendedHeight = this.parabolicField[xR + 2 + (zR + 2) * 5] / 2.0F;
/* 481 */             if (blendBiome.field_76748_D > baseBiome.field_76748_D) {
/* 482 */               blendedHeight *= 0.5F;
/*     */             }
/* 484 */             variationBlended += blendBiome.field_76749_E * blendedHeight;
/* 485 */             rootBlended += blendBiome.field_76748_D * blendedHeight;
/* 486 */             totalBlendedHeight += blendedHeight;
/*     */           } 
/*     */         } 
/*     */         
/* 490 */         variationBlended /= totalBlendedHeight;
/* 491 */         rootBlended /= totalBlendedHeight;
/* 492 */         variationBlended = variationBlended * 0.9F + 0.1F;
/* 493 */         rootBlended = (rootBlended * 4.0F - 1.0F) / 8.0F;
/*     */         
/* 495 */         double scaledNoise6Value = this.noise6[index2] / 8000.0D;
/*     */         
/* 497 */         if (scaledNoise6Value < 0.0D) {
/* 498 */           scaledNoise6Value = -scaledNoise6Value * 0.3D;
/*     */         }
/* 500 */         scaledNoise6Value = scaledNoise6Value * 3.0D - 2.0D;
/*     */         
/* 502 */         if (scaledNoise6Value < 0.0D) {
/*     */           
/* 504 */           scaledNoise6Value /= 2.0D;
/* 505 */           if (scaledNoise6Value < -1.0D)
/* 506 */             scaledNoise6Value = -1.0D; 
/* 507 */           scaledNoise6Value /= 2.8D;
/*     */         }
/*     */         else {
/*     */           
/* 511 */           if (scaledNoise6Value > 1.0D)
/* 512 */             scaledNoise6Value = 1.0D; 
/* 513 */           scaledNoise6Value /= 8.0D;
/*     */         } 
/*     */         
/* 516 */         index2++;
/*     */         
/* 518 */         for (int y = 0; y < ySize; y++) {
/*     */           
/* 520 */           double rootBlendedCopy = rootBlended;
/* 521 */           rootBlendedCopy += scaledNoise6Value * 0.2D;
/* 522 */           rootBlendedCopy = rootBlendedCopy * ySize / 16.0D;
/* 523 */           double var28 = ySize / 2.0D + rootBlendedCopy * 4.0D;
/* 524 */           double output = 0.0D;
/* 525 */           double var32 = (y - var28) * 12.0D * 256.0D / 256.0D / (2.7D + variationBlended);
/*     */           
/* 527 */           if (var32 < 0.0D) {
/* 528 */             var32 *= 4.0D;
/*     */           }
/* 530 */           double var34 = this.noise1[index1] / 512.0D;
/* 531 */           double var36 = this.noise2[index1] / 512.0D;
/* 532 */           double var38 = (this.noise3[index1] / 10.0D + 1.0D) / 2.0D;
/*     */           
/* 534 */           if (var38 < 0.0D) {
/* 535 */             output = var34;
/* 536 */           } else if (var38 > 1.0D) {
/* 537 */             output = var36;
/*     */           } else {
/* 539 */             output = var34 + (var36 - var34) * var38;
/*     */           } 
/* 541 */           output -= var32;
/* 542 */           if (y > ySize - 4) {
/*     */             
/* 544 */             double var40 = ((y - ySize - 4) / 3.0F);
/* 545 */             output = output * (1.0D - var40) + -10.0D * var40;
/*     */           } 
/*     */           
/* 548 */           outArray[index1] = output;
/* 549 */           index1++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 553 */     return outArray;
/*     */   }
/*     */ 
/*     */   
/*     */   private void replaceBlocksForBiomeHigh(int chunkX, int chunkZ, Block[] idsTop, Random rand, Block[] idsBig, byte[] metaBig) {
/* 558 */     int seaLevel = 16;
/* 559 */     int worldHeight = 256;
/* 560 */     int indexOffset = 128;
/* 561 */     double var6 = 0.03125D;
/* 562 */     this.stoneNoise = this.noiseGen4.func_76304_a(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, var6 * 4.0D, var6 * 1.0D, var6 * 4.0D);
/* 563 */     boolean[] cliffMap = new boolean[256];
/* 564 */     for (int xCoord = 0; xCoord < 16; xCoord++) {
/*     */       
/* 566 */       for (int zCoord = 0; zCoord < 16; zCoord++) {
/*     */         
/* 568 */         int arrayIndex = xCoord + zCoord * 16;
/* 569 */         int arrayIndexDL = zCoord + xCoord * 16;
/* 570 */         int arrayIndex2 = xCoord + 1 + zCoord + 16;
/* 571 */         TFCBiome biome = (TFCBiome)getBiome(xCoord, zCoord);
/* 572 */         DataLayer rock1 = (this.rockLayer1[arrayIndexDL] == null) ? DataLayer.GRANITE : this.rockLayer1[arrayIndexDL];
/* 573 */         DataLayer rock2 = (this.rockLayer2[arrayIndexDL] == null) ? DataLayer.GRANITE : this.rockLayer2[arrayIndexDL];
/* 574 */         DataLayer rock3 = (this.rockLayer3[arrayIndexDL] == null) ? DataLayer.GRANITE : this.rockLayer3[arrayIndexDL];
/*     */         
/* 576 */         float rain = (this.rainfallLayer[arrayIndexDL] == null) ? DataLayer.RAIN_125.floatdata1 : (this.rainfallLayer[arrayIndexDL]).floatdata1;
/* 577 */         DataLayer drainage = (this.drainageLayer[arrayIndexDL] == null) ? DataLayer.DRAINAGE_NORMAL : this.drainageLayer[arrayIndexDL];
/* 578 */         int var12 = (int)(this.stoneNoise[arrayIndex2] / 3.0D + 6.0D);
/* 579 */         int var13 = -1;
/*     */         
/* 581 */         Block surfaceBlock = TFC_Core.getTypeForGrassWithRain(rock1.data1, rain);
/* 582 */         Block subSurfaceBlock = TFC_Core.getTypeForDirtFromGrass(surfaceBlock);
/*     */         
/* 584 */         float bioTemp = TFC_Climate.getBioTemperature(this.worldObj, chunkX * 16 + xCoord, chunkZ * 16 + zCoord);
/* 585 */         int h = 0;
/* 586 */         if (TFC_Core.isBeachBiome((getBiome(xCoord - 1, zCoord)).field_76756_M) || TFC_Core.isBeachBiome((getBiome(xCoord + 1, zCoord)).field_76756_M) || 
/* 587 */           TFC_Core.isBeachBiome((getBiome(xCoord, zCoord + 1)).field_76756_M) || TFC_Core.isBeachBiome((getBiome(xCoord, zCoord - 1)).field_76756_M))
/*     */         {
/* 589 */           if (!TFC_Core.isBeachBiome((getBiome(xCoord, zCoord)).field_76756_M))
/* 590 */             cliffMap[arrayIndex] = true; 
/*     */         }
/* 592 */         for (int height = 127; height >= 0; height--) {
/*     */           
/* 594 */           int indexBig = arrayIndex * worldHeight + height + indexOffset;
/* 595 */           int index = arrayIndex * 128 + height;
/*     */           
/* 597 */           float temp = TFC_Climate.adjustHeightToTemp(height, bioTemp);
/* 598 */           if (TFC_Core.isBeachBiome(biome.field_76756_M) && height > seaLevel + h && idsTop[index] == Blocks.field_150348_b) {
/*     */             
/* 600 */             idsTop[index] = Blocks.field_150350_a;
/* 601 */             if (h == 0)
/* 602 */               h = (height - 16) / 4; 
/*     */           } 
/* 604 */           if (idsBig[indexBig] == null) {
/*     */             
/* 606 */             idsBig[indexBig] = idsTop[index];
/* 607 */             if (indexBig + 1 < idsBig.length && TFC_Core.isSoilOrGravel(idsBig[indexBig + 1]) && idsBig[indexBig] == Blocks.field_150350_a)
/*     */             {
/* 609 */               for (int upCount = 1; TFC_Core.isSoilOrGravel(idsBig[indexBig + upCount]); upCount++) {
/* 610 */                 idsBig[indexBig + upCount] = Blocks.field_150350_a;
/*     */               }
/*     */             }
/*     */           } 
/* 614 */           if (idsBig[indexBig] == Blocks.field_150348_b) {
/*     */             
/* 616 */             if (this.seaLevelOffsetMap[arrayIndex] == 0 && height - 16 >= 0) {
/* 617 */               this.seaLevelOffsetMap[arrayIndex] = height - 16;
/*     */             }
/* 619 */             if (this.chunkHeightMap[arrayIndex] == 0) {
/* 620 */               this.chunkHeightMap[arrayIndex] = height + indexOffset;
/*     */             }
/* 622 */             convertStone(indexOffset + height, arrayIndex, indexBig, idsBig, metaBig, rock1, rock2, rock3);
/*     */ 
/*     */             
/* 625 */             if (rain < 125.0F && temp < 1.5F) {
/*     */               
/* 627 */               surfaceBlock = TFC_Core.getTypeForSand(rock1.data1);
/* 628 */               subSurfaceBlock = TFC_Core.getTypeForSand(rock1.data1);
/*     */             
/*     */             }
/* 631 */             else if (rain < 125.0F && biome.field_76749_E < 0.5F && temp > 20.0F) {
/*     */               
/* 633 */               surfaceBlock = TFC_Core.getTypeForSand(rock1.data1);
/* 634 */               subSurfaceBlock = TFC_Core.getTypeForSand(rock1.data1);
/*     */             } 
/*     */             
/* 637 */             if (biome == TFCBiome.BEACH || biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN) {
/*     */               
/* 639 */               subSurfaceBlock = surfaceBlock = TFC_Core.getTypeForSand(rock1.data1);
/*     */             }
/* 641 */             else if (biome == TFCBiome.GRAVEL_BEACH) {
/*     */               
/* 643 */               subSurfaceBlock = surfaceBlock = TFC_Core.getTypeForGravel(rock1.data1);
/*     */             } 
/*     */             
/* 646 */             if (var13 == -1) {
/*     */ 
/*     */               
/* 649 */               int arrayIndexx = (xCoord > 0) ? (xCoord - 1 + zCoord * 16) : -1;
/* 650 */               int arrayIndexX = (xCoord < 15) ? (xCoord + 1 + zCoord * 16) : -1;
/* 651 */               int arrayIndexz = (zCoord > 0) ? (xCoord + (zCoord - 1) * 16) : -1;
/* 652 */               int arrayIndexZ = (zCoord < 15) ? (xCoord + (zCoord + 1) * 16) : -1;
/* 653 */               int var12Temp = var12;
/* 654 */               for (int counter = 1; counter < var12Temp / 3; counter++) {
/*     */                 
/* 656 */                 if (arrayIndexx >= 0 && this.seaLevelOffsetMap[arrayIndex] - 3 * counter > this.seaLevelOffsetMap[arrayIndexx]) {
/*     */                   
/* 658 */                   this.seaLevelOffsetMap[arrayIndex] = this.seaLevelOffsetMap[arrayIndex] - 1;
/* 659 */                   var12--;
/* 660 */                   height--;
/* 661 */                   indexBig = arrayIndex * worldHeight + height + indexOffset;
/* 662 */                   index = arrayIndex * 128 + height;
/*     */                 }
/* 664 */                 else if (arrayIndexX >= 0 && this.seaLevelOffsetMap[arrayIndex] - 3 * counter > this.seaLevelOffsetMap[arrayIndexX]) {
/*     */                   
/* 666 */                   this.seaLevelOffsetMap[arrayIndex] = this.seaLevelOffsetMap[arrayIndex] - 1;
/* 667 */                   var12--;
/* 668 */                   height--;
/* 669 */                   indexBig = arrayIndex * worldHeight + height + indexOffset;
/* 670 */                   index = arrayIndex * 128 + height;
/*     */                 }
/* 672 */                 else if (arrayIndexz >= 0 && this.seaLevelOffsetMap[arrayIndex] - 3 * counter > this.seaLevelOffsetMap[arrayIndexz]) {
/*     */                   
/* 674 */                   this.seaLevelOffsetMap[arrayIndex] = this.seaLevelOffsetMap[arrayIndex] - 1;
/* 675 */                   var12--;
/* 676 */                   height--;
/* 677 */                   indexBig = arrayIndex * worldHeight + height + indexOffset;
/* 678 */                   index = arrayIndex * 128 + height;
/*     */                 }
/* 680 */                 else if (arrayIndexZ >= 0 && this.seaLevelOffsetMap[arrayIndex] - 3 * counter > this.seaLevelOffsetMap[arrayIndexZ]) {
/*     */                   
/* 682 */                   this.seaLevelOffsetMap[arrayIndex] = this.seaLevelOffsetMap[arrayIndex] - 1;
/* 683 */                   var12--;
/* 684 */                   height--;
/* 685 */                   indexBig = arrayIndex * worldHeight + height + indexOffset;
/* 686 */                   index = arrayIndex * 128 + height;
/*     */                 } 
/*     */               } 
/* 689 */               var13 = (int)(var12 * (1.0D - Math.max(Math.min((height - 16) / 80.0D, 1.0D), 0.0D)));
/*     */ 
/*     */               
/* 692 */               for (int c = 1; c < 3; c++) {
/*     */                 
/* 694 */                 if (indexBig + c < idsBig.length && idsBig[indexBig + c] != surfaceBlock && idsBig[indexBig + c] != subSurfaceBlock && idsBig[indexBig + c] != TFCBlocks.saltWaterStationary && idsBig[indexBig + c] != TFCBlocks.freshWaterStationary && idsBig[indexBig + c] != TFCBlocks.hotWater) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 701 */                   idsBig[indexBig + c] = Blocks.field_150350_a;
/*     */                   
/* 703 */                   if (indexBig + c + 1 < idsBig.length && idsBig[indexBig + c + 1] == TFCBlocks.saltWaterStationary) {
/*     */                     
/* 705 */                     idsBig[indexBig + c] = subSurfaceBlock;
/* 706 */                     metaBig[indexBig + c] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 712 */               int dirtH = Math.max(8 - (height + 96 - 144) / 16, 0);
/*     */               
/* 714 */               if (var13 > 0)
/*     */               {
/* 716 */                 if (height >= seaLevel - 1 && index + 1 < idsTop.length && idsTop[index + 1] != TFCBlocks.saltWaterStationary && dirtH > 0) {
/*     */                   
/* 718 */                   idsBig[indexBig] = surfaceBlock;
/* 719 */                   metaBig[indexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */ 
/*     */                   
/* 722 */                   int i = 1;
/* 723 */                   for (; i < dirtH && !TFC_Core.isMountainBiome(biome.field_76756_M) && biome != TFCBiome.HIGH_HILLS && biome != TFCBiome.HIGH_HILLS_EDGE && !cliffMap[arrayIndex]; i++) {
/*     */                     
/* 725 */                     int offsetHeight = height - i;
/* 726 */                     int newIndexBig = arrayIndex * worldHeight + offsetHeight + indexOffset;
/* 727 */                     idsBig[newIndexBig] = subSurfaceBlock;
/* 728 */                     metaBig[newIndexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */                     
/* 730 */                     if (i > 1 + 5 - drainage.data1) {
/*     */                       
/* 732 */                       idsBig[newIndexBig] = TFC_Core.getTypeForGravel(rock1.data1);
/* 733 */                       metaBig[newIndexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */             
/* 740 */             if ((height > seaLevel - 2 && height < seaLevel && idsTop[index + 1] == TFCBlocks.saltWaterStationary) || (height < seaLevel && idsTop[index + 1] == TFCBlocks.saltWaterStationary))
/*     */             {
/*     */               
/* 743 */               if (biome != TFCBiome.SWAMPLAND)
/*     */               {
/* 745 */                 if (idsBig[indexBig] != TFC_Core.getTypeForSand(rock1.data1) && rand.nextInt(5) != 0)
/*     */                 {
/* 747 */                   idsBig[indexBig] = TFC_Core.getTypeForGravel(rock1.data1);
/* 748 */                   metaBig[indexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 753 */               else if (idsBig[indexBig] != TFC_Core.getTypeForGravel(rock1.data1))
/*     */               {
/* 755 */                 idsBig[indexBig] = TFC_Core.getTypeForDirt(rock1.data1);
/* 756 */                 metaBig[indexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */               }
/*     */             
/*     */             }
/*     */           }
/* 761 */           else if (idsTop[index] == TFCBlocks.saltWaterStationary && biome != TFCBiome.OCEAN && biome != TFCBiome.DEEP_OCEAN && biome != TFCBiome.BEACH && biome != TFCBiome.GRAVEL_BEACH) {
/*     */             
/* 763 */             idsBig[indexBig] = TFCBlocks.freshWaterStationary;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void replaceBlocksForBiomeLow(int par1, int par2, Random rand, Block[] idsBig, byte[] metaBig) {
/* 787 */     for (int xCoord = 0; xCoord < 16; xCoord++) {
/*     */       
/* 789 */       for (int zCoord = 0; zCoord < 16; zCoord++) {
/*     */         
/* 791 */         int arrayIndex = xCoord + zCoord * 16;
/* 792 */         int arrayIndexDL = zCoord + xCoord * 16;
/* 793 */         DataLayer rock1 = this.rockLayer1[arrayIndexDL];
/* 794 */         DataLayer rock2 = this.rockLayer2[arrayIndexDL];
/* 795 */         DataLayer rock3 = this.rockLayer3[arrayIndexDL];
/* 796 */         DataLayer stability = this.stabilityLayer[arrayIndexDL];
/* 797 */         TFCBiome biome = (TFCBiome)getBiome(xCoord, zCoord);
/*     */         
/* 799 */         for (int height = 127; height >= 0; height--) {
/*     */ 
/*     */           
/* 802 */           int indexBig = arrayIndex * 256 + height;
/* 803 */           metaBig[indexBig] = 0;
/*     */           
/* 805 */           if (height <= 1 + this.seaLevelOffsetMap[arrayIndex] / 3 + this.rand.nextInt(3)) {
/*     */             
/* 807 */             idsBig[indexBig] = Blocks.field_150357_h;
/*     */           }
/* 809 */           else if (idsBig[indexBig] == null) {
/*     */             
/* 811 */             convertStone(height, arrayIndex, indexBig, idsBig, metaBig, rock1, rock2, rock3);
/* 812 */             if (TFC_Core.isBeachBiome(biome.field_76756_M) || TFC_Core.isOceanicBiome(biome.field_76756_M))
/*     */             {
/* 814 */               if (idsBig[indexBig + 1] == TFCBlocks.saltWaterStationary) {
/*     */                 
/* 816 */                 idsBig[indexBig] = TFC_Core.getTypeForSand(rock1.data1);
/* 817 */                 metaBig[indexBig] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/* 818 */                 idsBig[indexBig - 1] = TFC_Core.getTypeForSand(rock1.data1);
/* 819 */                 metaBig[indexBig - 1] = (byte)TFC_Core.getSoilMeta(rock1.data1);
/*     */               } 
/*     */             }
/*     */           } 
/*     */           
/* 824 */           if (height <= 6 && stability.data1 == 1 && idsBig[indexBig] == Blocks.field_150350_a) {
/*     */             
/* 826 */             idsBig[indexBig] = TFCBlocks.lava;
/* 827 */             metaBig[indexBig] = 0;
/* 828 */             if (idsBig[indexBig + 1] != TFCBlocks.lava && rand.nextBoolean()) {
/*     */               
/* 830 */               idsBig[indexBig + 1] = TFCBlocks.lava;
/* 831 */               metaBig[indexBig + 1] = 0;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void convertStone(int height, int indexArray, int indexBig, Block[] idsBig, byte[] metaBig, DataLayer rock1, DataLayer rock2, DataLayer rock3) {
/* 841 */     if (idsBig[indexBig] != null && idsBig[indexBig] != Blocks.field_150348_b)
/*     */       return; 
/* 843 */     if (height <= TFCOptions.rockLayer3Height + this.seaLevelOffsetMap[indexArray]) {
/*     */       
/* 845 */       idsBig[indexBig] = rock3.block;
/* 846 */       metaBig[indexBig] = (byte)rock3.data2;
/*     */     }
/* 848 */     else if (height <= TFCOptions.rockLayer2Height + this.seaLevelOffsetMap[indexArray] && height > 55 + this.seaLevelOffsetMap[indexArray] && rock2 != null) {
/*     */       
/* 850 */       idsBig[indexBig] = rock2.block;
/* 851 */       metaBig[indexBig] = (byte)rock2.data2;
/*     */     }
/*     */     else {
/*     */       
/* 855 */       idsBig[indexBig] = rock1.block;
/* 856 */       metaBig[indexBig] = (byte)rock1.data2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 863 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCChunkProviderGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */