/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Enums.EnumTree;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenSaplings
/*     */ {
/*     */   public void generate(World world, Random random, int xCoord, int yCoord, int zCoord) {
/*  16 */     boolean hasSpaceToGrow = true;
/*     */     
/*  18 */     int treeType0 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 0);
/*  19 */     int treeType1 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 1);
/*  20 */     int treeType2 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 2);
/*     */     
/*  22 */     for (int y = -3; y < 6 && hasSpaceToGrow; y++) {
/*     */       
/*  24 */       for (int x = -7; x < 8 && hasSpaceToGrow; x++) {
/*     */         
/*  26 */         for (int z = -7; z < 8 && hasSpaceToGrow; z++) {
/*     */           
/*  28 */           if (world.func_147439_a(xCoord + x, yCoord + y, zCoord + z) == TFCBlocks.logNatural || world
/*  29 */             .func_147439_a(xCoord + x, yCoord + y, zCoord + z) == TFCBlocks.sapling)
/*     */           {
/*  31 */             hasSpaceToGrow = false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  37 */     if (hasSpaceToGrow) {
/*     */       
/*  39 */       float rainfall = TFC_Climate.getRainfall(world, xCoord, yCoord, zCoord);
/*  40 */       float temperature = TFC_Climate.getBioTemperatureHeight(world, xCoord, yCoord, zCoord);
/*  41 */       float evt = (TFC_Climate.getCacheManager(world).getEVTLayerAt(xCoord, zCoord)).floatdata1;
/*     */       
/*  43 */       if (treeType0 < 0 || treeType0 > 15)
/*  44 */         treeType0 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 2); 
/*  45 */       if (treeType1 < 0 || treeType1 > 15)
/*  46 */         treeType1 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 0); 
/*  47 */       if (treeType2 < 0 || treeType2 > 15) {
/*  48 */         treeType2 = TFC_Climate.getTreeLayer(world, xCoord, yCoord, zCoord, 1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  54 */       if (getNearWater(world, xCoord, yCoord, zCoord)) {
/*     */         
/*  56 */         rainfall *= 2.0F;
/*  57 */         evt /= 2.0F;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  63 */       if (zCoord > 14500 || zCoord < -14500) {
/*  64 */         treeType2 = 8;
/*     */       }
/*     */       
/*  67 */       boolean canSpawnTemp0 = false;
/*  68 */       boolean canSpawnTemp1 = false;
/*  69 */       boolean canSpawnTemp2 = false;
/*  70 */       boolean canSpawnRain0 = false;
/*  71 */       boolean canSpawnRain1 = false;
/*  72 */       boolean canSpawnRain2 = false;
/*  73 */       boolean canSpawnEVT0 = false;
/*  74 */       boolean canSpawnEVT1 = false;
/*  75 */       boolean canSpawnEVT2 = false;
/*     */       
/*  77 */       if (treeType0 != -1) {
/*     */         
/*  79 */         float tree0EVTMin = (EnumTree.values()[treeType0]).minEVT;
/*  80 */         float tree0EVTMax = (EnumTree.values()[treeType0]).maxEVT;
/*  81 */         float tree0RainMin = (EnumTree.values()[treeType0]).minRain;
/*  82 */         float tree0RainMax = (EnumTree.values()[treeType0]).maxRain;
/*  83 */         float tree0TempMin = (EnumTree.values()[treeType0]).minTemp;
/*  84 */         float tree0TempMax = (EnumTree.values()[treeType0]).maxTemp;
/*     */         
/*  86 */         canSpawnTemp0 = (temperature >= tree0TempMin && temperature <= tree0TempMax);
/*  87 */         canSpawnRain0 = (rainfall >= tree0RainMin && rainfall <= tree0RainMax);
/*  88 */         canSpawnEVT0 = (evt >= tree0EVTMin && evt <= tree0EVTMax);
/*     */       } 
/*     */       
/*  91 */       if (treeType1 != -1) {
/*     */         
/*  93 */         float tree1EVTMin = (EnumTree.values()[treeType1]).minEVT;
/*  94 */         float tree1EVTMax = (EnumTree.values()[treeType1]).maxEVT;
/*  95 */         float tree1RainMin = (EnumTree.values()[treeType1]).minRain;
/*  96 */         float tree1RainMax = (EnumTree.values()[treeType1]).maxRain;
/*  97 */         float tree1TempMin = (EnumTree.values()[treeType1]).minTemp;
/*  98 */         float tree1TempMax = (EnumTree.values()[treeType1]).maxTemp;
/*     */         
/* 100 */         canSpawnTemp1 = (temperature >= tree1TempMin && temperature <= tree1TempMax);
/* 101 */         canSpawnRain0 = (rainfall >= tree1RainMin && rainfall <= tree1RainMax);
/* 102 */         canSpawnEVT0 = (evt >= tree1EVTMin && evt <= tree1EVTMax);
/*     */       } 
/*     */       
/* 105 */       if (treeType2 != -1) {
/*     */         
/* 107 */         float tree2EVTMin = (EnumTree.values()[treeType2]).minEVT;
/* 108 */         float tree2EVTMax = (EnumTree.values()[treeType2]).maxEVT;
/* 109 */         float tree2RainMin = (EnumTree.values()[treeType2]).minRain;
/* 110 */         float tree2RainMax = (EnumTree.values()[treeType2]).maxRain;
/* 111 */         float tree2TempMin = (EnumTree.values()[treeType2]).minTemp;
/* 112 */         float tree2TempMax = (EnumTree.values()[treeType2]).maxTemp;
/*     */         
/* 114 */         canSpawnTemp2 = (temperature >= tree2TempMin && temperature <= tree2TempMax);
/* 115 */         canSpawnRain0 = (rainfall >= tree2RainMin && rainfall <= tree2RainMax);
/* 116 */         canSpawnEVT0 = (evt >= tree2EVTMin && evt <= tree2EVTMax);
/*     */       } 
/*     */ 
/*     */       
/* 120 */       if (canSpawnTemp0 || canSpawnTemp1 || canSpawnTemp2) {
/*     */ 
/*     */         
/* 123 */         if (!canSpawnEVT0 && !canSpawnEVT1 && !canSpawnEVT2)
/*     */         {
/*     */           
/* 126 */           if (random.nextInt(10) > 0) {
/*     */             return;
/*     */           }
/*     */         }
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/* 135 */       int randomNumber = random.nextInt(100);
/* 136 */       if (randomNumber < 40) {
/*     */         
/* 138 */         if (canSpawnTemp0 && canSpawnRain0) {
/* 139 */           world.func_147465_d(xCoord, yCoord + 1, zCoord, TFCBlocks.sapling, treeType0, 2);
/*     */         }
/* 141 */       } else if (randomNumber < 70) {
/*     */         
/* 143 */         if (canSpawnTemp1 && canSpawnRain1) {
/* 144 */           world.func_147465_d(xCoord, yCoord + 1, zCoord, TFCBlocks.sapling, treeType1, 2);
/*     */         }
/* 146 */       } else if (randomNumber < 100) {
/*     */         
/* 148 */         if (canSpawnTemp2 && canSpawnRain2) {
/* 149 */           world.func_147465_d(xCoord, yCoord + 1, zCoord, TFCBlocks.sapling, treeType2, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getNearWater(World world, int x, int y, int z) {
/* 156 */     for (int x1 = -4; x1 < 5; x1++) {
/*     */       
/* 158 */       for (int z1 = -4; z1 < 5; z1++) {
/*     */         
/* 160 */         for (int y1 = -2; y1 < 1; y1++) {
/*     */           
/* 162 */           if (world.func_72899_e(x + x1, y + y1, z + z1) && TFC_Core.isWater(world.func_147439_a(x + x1, y + y1, z + z1)))
/* 163 */             return true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 167 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenSaplings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */