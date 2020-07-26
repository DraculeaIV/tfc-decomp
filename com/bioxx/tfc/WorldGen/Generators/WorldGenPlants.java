/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomFruitTree;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenPlants
/*     */   implements IWorldGenerator
/*     */ {
/*  18 */   private static WorldGenFungi plantFungiGen = new WorldGenFungi();
/*     */   
/*  20 */   private static WorldGenCustomFruitTree appleTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 0);
/*  21 */   private static WorldGenCustomFruitTree bananaTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 1);
/*  22 */   private static WorldGenCustomFruitTree orangeTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 2);
/*  23 */   private static WorldGenCustomFruitTree grappleTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 3);
/*  24 */   private static WorldGenCustomFruitTree lemonTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 4);
/*  25 */   private static WorldGenCustomFruitTree oliveTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 5);
/*  26 */   private static WorldGenCustomFruitTree cherryTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 6);
/*  27 */   private static WorldGenCustomFruitTree peachTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves, 7);
/*     */   
/*  29 */   private static WorldGenCustomFruitTree plumTree = new WorldGenCustomFruitTree(false, TFCBlocks.fruitTreeLeaves2, 8);
/*     */ 
/*     */   
/*  32 */   private static WorldGenBerryBush wintergreenGen = new WorldGenBerryBush(false, 0, 12, 1, 5);
/*  33 */   private static WorldGenBerryBush blueberryGen = new WorldGenBerryBush(false, 1, 6, 1, 4);
/*  34 */   private static WorldGenBerryBush raspberryGen = new WorldGenBerryBush(false, 2, 5, 2, 4);
/*  35 */   private static WorldGenBerryBush strawberryGen = new WorldGenBerryBush(false, 3, 8, 1, 4);
/*  36 */   private static WorldGenBerryBush blackberryGen = new WorldGenBerryBush(false, 4, 5, 2, 4);
/*  37 */   private static WorldGenBerryBush bunchberryGen = new WorldGenBerryBush(false, 5, 8, 1, 4);
/*  38 */   private static WorldGenBerryBush cranberryGen = new WorldGenBerryBush(false, 6, 15, 1, 6);
/*  39 */   private static WorldGenBerryBush snowberryGen = new WorldGenBerryBush(false, 7, 6, 1, 4);
/*  40 */   private static WorldGenBerryBush elderberryGen = new WorldGenBerryBush(false, 8, 5, 2, 4);
/*  41 */   private static WorldGenBerryBush gooseberryGen = new WorldGenBerryBush(false, 9, 8, 1, 4);
/*  42 */   private static WorldGenBerryBush cloudberryGen = new WorldGenBerryBush(false, 10, 12, 1, 6, TFCBlocks.peatGrass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  52 */     chunkX *= 16;
/*  53 */     chunkZ *= 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     int grassPerChunk = 0;
/*  60 */     int flowerChunkRarity = 30;
/*  61 */     int mushroomsPerChunk = 0;
/*     */ 
/*     */     
/*  64 */     float rain = TFC_Climate.getRainfall(world, chunkX, 144, chunkZ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     if (rain >= 125.0F) {
/*     */       
/*  72 */       grassPerChunk += 12;
/*  73 */       mushroomsPerChunk++;
/*     */     } 
/*  75 */     if (rain >= 250.0F) {
/*     */       
/*  77 */       grassPerChunk += 18;
/*  78 */       flowerChunkRarity -= 2;
/*  79 */       mushroomsPerChunk++;
/*     */     } 
/*  81 */     if (rain >= 500.0F) {
/*     */       
/*  83 */       grassPerChunk += 24;
/*  84 */       flowerChunkRarity -= 3;
/*  85 */       mushroomsPerChunk++;
/*     */     } 
/*  87 */     if (rain >= 1000.0F) {
/*     */       
/*  89 */       flowerChunkRarity -= 5;
/*  90 */       mushroomsPerChunk++;
/*     */     } 
/*  92 */     if (rain >= 2000.0F) {
/*     */       
/*  94 */       flowerChunkRarity -= 5;
/*  95 */       mushroomsPerChunk++;
/*     */     } 
/*  97 */     float bioTemperature = TFC_Climate.getBioTemperatureHeight(world, chunkX, 144, chunkZ);
/*  98 */     if (bioTemperature < 10.0F)
/*     */     {
/* 100 */       grassPerChunk /= 2;
/*     */     }
/* 102 */     if (bioTemperature < 5.0F)
/*     */     {
/* 104 */       grassPerChunk /= 2;
/*     */     }
/* 106 */     if (bioTemperature < 0.0F)
/*     */     {
/* 108 */       grassPerChunk = 0;
/*     */     }
/*     */     
/* 111 */     WorldGenFlowers.generate(world, random, chunkX, chunkZ, flowerChunkRarity);
/*     */     
/* 113 */     genBushes(random, chunkX, chunkZ, world); int i;
/* 114 */     for (i = 0; i < grassPerChunk; i++) {
/*     */       
/* 116 */       int xCoord = chunkX + random.nextInt(16) + 8;
/* 117 */       int zCoord = chunkZ + random.nextInt(16) + 8;
/* 118 */       int yCoord = world.func_72825_h(xCoord, zCoord);
/* 119 */       bioTemperature = TFC_Climate.getBioTemperatureHeight(world, xCoord, yCoord, zCoord);
/* 120 */       if (world.func_147437_c(xCoord, yCoord, zCoord) && TFCBlocks.tallGrass
/* 121 */         .func_149718_j(world, xCoord, yCoord, zCoord) && 
/* 122 */         !TFC_Core.isDryGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord)))
/*     */       {
/* 124 */         world.func_147465_d(xCoord, yCoord, zCoord, TFCBlocks.tallGrass, (world.field_73012_v.nextInt(20) == 0) ? 1 : 0, 2);
/*     */       }
/*     */       
/* 127 */       if (bioTemperature >= 0.0F)
/*     */       {
/* 129 */         if (world.func_147437_c(xCoord, yCoord, zCoord) && TFCBlocks.tallGrass
/* 130 */           .func_149718_j(world, xCoord, yCoord, zCoord) && 
/* 131 */           TFC_Core.isDryGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord)))
/*     */         {
/* 133 */           world.func_147465_d(xCoord, yCoord, zCoord, TFCBlocks.tallGrass, (world.field_73012_v.nextInt(60) == 0) ? 1 : 2, 2);
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 138 */     for (i = 0; i < mushroomsPerChunk; i++) {
/*     */       
/* 140 */       if (random.nextInt(4) == 0) {
/*     */         
/* 142 */         int xCoord = chunkX + random.nextInt(16) + 8;
/* 143 */         int zCoord = chunkZ + random.nextInt(16) + 8;
/* 144 */         int yCoord = world.func_72825_h(xCoord, zCoord);
/* 145 */         plantFungiGen.genWithMeta(world, random, xCoord, yCoord, zCoord, 0);
/*     */       } 
/*     */       
/* 148 */       if (random.nextInt(8) == 0) {
/*     */         
/* 150 */         int xCoord = chunkX + random.nextInt(16) + 8;
/* 151 */         int zCoord = chunkZ + random.nextInt(16) + 8;
/* 152 */         int yCoord = world.func_72825_h(xCoord, zCoord);
/* 153 */         plantFungiGen.genWithMeta(world, random, xCoord, yCoord, zCoord, 1);
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     if (random.nextInt(70) == 0 && rain >= 500.0F) {
/*     */       
/* 159 */       int xCoord = chunkX + random.nextInt(16) + 8;
/* 160 */       int zCoord = chunkZ + random.nextInt(16) + 8;
/* 161 */       int yCoord = world.func_72825_h(xCoord, zCoord);
/* 162 */       bioTemperature = TFC_Climate.getBioTemperatureHeight(world, xCoord, yCoord, zCoord);
/* 163 */       switch ((new Random(world.func_72905_C() + (((chunkX >> 4) - (chunkZ >> 4)) * (chunkZ >> 4)))).nextInt(9)) {
/*     */ 
/*     */         
/*     */         default:
/* 167 */           if (bioTemperature > 8.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 168 */             appleTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 1:
/* 173 */           if (bioTemperature > 15.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 174 */             bananaTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 2:
/* 179 */           if (bioTemperature > 12.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 180 */             orangeTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 3:
/* 185 */           if (bioTemperature > 8.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 186 */             grappleTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 4:
/* 191 */           if (bioTemperature > 10.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 192 */             lemonTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 5:
/* 197 */           if (bioTemperature > 10.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 198 */             oliveTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 6:
/* 203 */           if (bioTemperature > 8.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 204 */             cherryTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           }
/*     */           return;
/*     */         
/*     */         case 7:
/* 209 */           if (bioTemperature > 10.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord)))
/* 210 */             peachTree.func_76484_a(world, random, xCoord, yCoord, zCoord); 
/*     */           return;
/*     */         case 8:
/*     */           break;
/*     */       } 
/* 215 */       if (bioTemperature > 10.0F && world.func_147437_c(xCoord, yCoord, zCoord) && TFC_Core.isGrass(world.func_147439_a(xCoord, yCoord - 1, zCoord))) {
/* 216 */         plumTree.func_76484_a(world, random, xCoord, yCoord, zCoord);
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
/*     */   private void genBushes(Random random, int chunkX, int chunkZ, World world) {
/* 235 */     if (random.nextInt(12) == 0) {
/*     */       
/* 237 */       int xCoord = chunkX + random.nextInt(16) + 8;
/* 238 */       int zCoord = chunkZ + random.nextInt(16) + 8;
/* 239 */       int yCoord = world.func_72825_h(xCoord, zCoord);
/* 240 */       switch (random.nextInt(11)) {
/*     */         
/*     */         default:
/* 243 */           wintergreenGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 1:
/* 246 */           blueberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 2:
/* 249 */           raspberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 3:
/* 252 */           strawberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 4:
/* 255 */           blackberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 5:
/* 258 */           bunchberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 6:
/* 261 */           cranberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 7:
/* 264 */           snowberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 8:
/* 267 */           elderberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */           return;
/*     */         case 9:
/* 270 */           gooseberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord); return;
/*     */         case 10:
/*     */           break;
/* 273 */       }  cloudberryGen.func_76484_a(world, random, xCoord, yCoord, zCoord);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenPlants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */