/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenAcaciaKoaTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomShortTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenKapokTrees;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.Enums.EnumTree;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenForests
/*     */   implements IWorldGenerator
/*     */ {
/*     */   private WorldGenerator gen0;
/*     */   private WorldGenerator gen1;
/*     */   private WorldGenerator gen2;
/*     */   private int treeType0;
/*     */   private int treeType1;
/*     */   private int treeType2;
/*     */   private float evt;
/*     */   private float rainfall;
/*  33 */   private float temperature = 20.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  39 */     chunkX *= 16;
/*  40 */     chunkZ *= 16;
/*     */     
/*  42 */     if (world.func_72807_a(chunkX, chunkZ) instanceof TFCBiome) {
/*     */       
/*  44 */       TFCBiome biome = (TFCBiome)world.func_72807_a(chunkX, chunkZ);
/*  45 */       if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN) {
/*     */         return;
/*     */       }
/*  48 */       this.rainfall = TFC_Climate.getRainfall(world, chunkX, 0, chunkZ);
/*  49 */       this.evt = (TFC_Climate.getCacheManager(world).getEVTLayerAt(chunkX + 8, chunkZ + 8)).floatdata1;
/*  50 */       this.treeType0 = TFC_Climate.getTreeLayer(world, chunkX, 144, chunkZ, 0);
/*  51 */       this.treeType1 = TFC_Climate.getTreeLayer(world, chunkX, 144, chunkZ, 1);
/*  52 */       this.treeType2 = TFC_Climate.getTreeLayer(world, chunkX, 144, chunkZ, 2);
/*     */       
/*  54 */       this.gen0 = TFCBiome.getTreeGen(this.treeType0, Boolean.valueOf(random.nextBoolean()));
/*  55 */       this.gen1 = TFCBiome.getTreeGen(this.treeType1, Boolean.valueOf(random.nextBoolean()));
/*  56 */       this.gen2 = TFCBiome.getTreeGen(this.treeType2, Boolean.valueOf(random.nextBoolean()));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  61 */       if (!generateJungle(random, chunkX, chunkZ, world)) {
/*  62 */         generateForest(random, chunkX, chunkZ, world);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void generateForest(Random random, int chunkX, int chunkZ, World world) {
/*  68 */     int xCoord = chunkX;
/*  69 */     int yCoord = 145;
/*  70 */     int zCoord = chunkZ;
/*     */     
/*  72 */     int numTreesBase = 8;
/*  73 */     if (random.nextInt(10) == 0)
/*     */     {
/*  75 */       numTreesBase -= 6;
/*     */     }
/*     */     
/*  78 */     int numTrees = 1;
/*  79 */     for (int var2 = 0; var2 < numTrees; var2++) {
/*     */       
/*  81 */       xCoord = chunkX + random.nextInt(16);
/*  82 */       zCoord = chunkZ + random.nextInt(16);
/*  83 */       yCoord = world.func_72976_f(xCoord, zCoord);
/*     */       
/*  85 */       numTrees = (int)(numTreesBase + this.rainfall / 1000.0F * 2.0F);
/*  86 */       if (numTrees > 30) {
/*  87 */         numTrees = 30;
/*     */       }
/*  89 */       this.temperature = TFC_Climate.getBioTemperatureHeight(world, xCoord, world.func_72976_f(xCoord, zCoord), zCoord);
/*  90 */       int spawnParam0 = canTreeSpawn(this.treeType0);
/*  91 */       int spawnParam1 = canTreeSpawn(this.treeType1);
/*  92 */       int spawnParam2 = canTreeSpawn(this.treeType2);
/*     */       
/*  94 */       if (getNearWater(world, xCoord, yCoord, zCoord)) {
/*     */         
/*  96 */         this.rainfall *= 2.0F;
/*  97 */         this.evt /= 2.0F;
/*     */       } 
/*     */       
/*     */       try {
/* 101 */         if (zCoord > 14500 || zCoord < -14500) {
/* 102 */           this.gen2 = TFCBiome.getTreeGen(8, Boolean.valueOf(random.nextBoolean()));
/*     */         }
/*     */         
/* 105 */         if ((spawnParam0 & 0x1) > 0 || (spawnParam1 & 0x1) > 0 || (spawnParam2 & 0x1) > 0) {
/*     */ 
/*     */           
/* 108 */           if (spawnParam0 > 0 && (spawnParam0 & 0x2) == 0 && spawnParam1 > 0 && (spawnParam1 & 0x2) == 0 && spawnParam2 > 0 && (spawnParam2 & 0x2) == 0)
/*     */           {
/*     */             
/* 111 */             if (random.nextInt(8) == 0) {
/* 112 */               numTrees = 1;
/*     */             } else {
/*     */               return;
/*     */             } 
/*     */           }
/*     */         } else {
/*     */           return;
/*     */         } 
/*     */ 
/*     */         
/* 122 */         int randomNumber = random.nextInt(100);
/* 123 */         if (randomNumber < 50 && this.gen0 != null && (spawnParam0 == 5 || spawnParam0 == 7))
/*     */         {
/* 125 */           this.gen0.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */         }
/* 127 */         else if (randomNumber < 80 && this.gen1 != null && (spawnParam1 == 5 || spawnParam1 == 7))
/*     */         {
/* 129 */           this.gen1.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */         }
/* 131 */         else if (randomNumber < 100 && this.gen2 != null && (spawnParam2 == 5 || spawnParam2 == 7))
/*     */         {
/* 133 */           this.gen2.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */         }
/*     */       
/* 136 */       } catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int canTreeSpawn(int tree) {
/* 144 */     float treeEVTMin = (tree != -1) ? (EnumTree.values()[tree]).minEVT : 0.0F;
/* 145 */     float treeEVTMax = (tree != -1) ? (EnumTree.values()[tree]).maxEVT : 0.0F;
/*     */     
/* 147 */     float treeRainMin = (tree != -1) ? (EnumTree.values()[tree]).minRain : 0.0F;
/* 148 */     float treeRainMax = (tree != -1) ? (EnumTree.values()[tree]).maxRain : 0.0F;
/*     */     
/* 150 */     float treeTempMin = (tree != -1) ? (EnumTree.values()[tree]).minTemp : 0.0F;
/* 151 */     float treeTempMax = (tree != -1) ? (EnumTree.values()[tree]).maxTemp : 0.0F;
/*     */     
/* 153 */     int out = 0;
/*     */     
/* 155 */     if (this.temperature >= treeTempMin && this.temperature <= treeTempMax)
/* 156 */       out++; 
/* 157 */     if (this.evt >= treeEVTMin && this.evt <= treeEVTMax)
/* 158 */       out += 2; 
/* 159 */     if (this.rainfall >= treeRainMin && this.rainfall <= treeRainMax) {
/* 160 */       out += 4;
/*     */     }
/* 162 */     return out;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generateJungle(Random random, int chunkX, int chunkZ, World world) {
/* 167 */     boolean completed = false;
/* 168 */     int xCoord = chunkX;
/* 169 */     int yCoord = 145;
/* 170 */     int zCoord = chunkZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     int numTrees = 50;
/* 177 */     for (int var2 = 0; var2 < numTrees; var2++) {
/*     */       
/* 179 */       xCoord = chunkX + 8 + random.nextInt(16);
/* 180 */       zCoord = chunkZ + 8 + random.nextInt(16);
/* 181 */       yCoord = world.func_72976_f(xCoord, zCoord);
/*     */ 
/*     */       
/* 184 */       float temperatureAvg = TFC_Climate.getBioTemperature(world, xCoord, zCoord);
/*     */ 
/*     */       
/*     */       try {
/* 188 */         if (this.evt <= EnumTree.KAPOK.maxEVT && this.rainfall >= EnumTree.KAPOK.minRain && this.rainfall <= EnumTree.KAPOK.maxRain && temperatureAvg >= EnumTree.KAPOK.minTemp && temperatureAvg <= EnumTree.KAPOK.maxTemp) {
/*     */           WorldGenerator gen0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 195 */           if (random.nextInt(5) == 0) {
/* 196 */             WorldGenKapokTrees worldGenKapokTrees = new WorldGenKapokTrees(false, 15);
/* 197 */           } else if (random.nextInt(2) == 0) {
/* 198 */             WorldGenCustomShortTrees worldGenCustomShortTrees = new WorldGenCustomShortTrees(false, 15);
/*     */           } else {
/* 200 */             gen0 = new WorldGenJungleShrub(15);
/*     */           } 
/*     */           
/* 203 */           gen0.func_76487_a(1.0D, 1.0D, 1.0D);
/* 204 */           gen0.func_76484_a(world, random, xCoord, yCoord, zCoord);
/* 205 */           completed = true;
/*     */         } 
/*     */         
/* 208 */         if (this.evt <= EnumTree.KOA.maxEVT && this.rainfall >= EnumTree.KOA.minRain && this.rainfall <= EnumTree.KOA.maxRain && temperatureAvg >= EnumTree.KOA.minTemp && temperatureAvg <= EnumTree.KOA.maxTemp)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 214 */           WorldGenAcaciaKoaTrees worldGenAcaciaKoaTrees = new WorldGenAcaciaKoaTrees(false, 0);
/*     */           
/* 216 */           worldGenAcaciaKoaTrees.func_76487_a(1.0D, 1.0D, 1.0D);
/* 217 */           worldGenAcaciaKoaTrees.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */         }
/*     */       
/* 220 */       } catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 225 */     if (completed) {
/*     */       
/* 227 */       WorldGenCustomVines vineGen = new WorldGenCustomVines();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       for (int l = 0; l < 50; l++) {
/*     */         
/* 238 */         int i1 = chunkX + random.nextInt(16) + 8;
/* 239 */         short short1 = 256;
/* 240 */         int j1 = chunkZ + random.nextInt(16) + 8;
/* 241 */         vineGen.generate2(world, random, i1, short1, j1);
/*     */       } 
/*     */     } 
/* 244 */     return completed;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getNearWater(World world, int x, int y, int z) {
/* 249 */     for (int x1 = -4; x1 < 5; x1++) {
/*     */       
/* 251 */       for (int z1 = -4; z1 < 5; z1++) {
/*     */         
/* 253 */         for (int y1 = -2; y1 < 1; y1++) {
/*     */           
/* 255 */           if (world.func_72899_e(x + x1, y + y1, z + z1) && TFC_Core.isWater(world.func_147439_a(x + x1, y + y1, z + z1)))
/* 256 */             return true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 260 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenForests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */