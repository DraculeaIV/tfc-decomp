/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenSoilPits
/*     */   implements IWorldGenerator
/*     */ {
/*  19 */   private static WorldGenBerryBush cranberryGen = new WorldGenBerryBush(false, 6, 15, 1, 6, TFCBlocks.peatGrass);
/*  20 */   private static WorldGenBerryBush cloudberryGen = new WorldGenBerryBush(false, 10, 12, 1, 6, TFCBlocks.peatGrass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  30 */     chunkX *= 16;
/*  31 */     chunkZ *= 16;
/*     */     
/*  33 */     int x = chunkX + random.nextInt(16) + 8;
/*  34 */     int z = chunkZ + random.nextInt(16) + 8;
/*  35 */     generateClay(world, random, x, world.func_72825_h(x, z), z);
/*     */     
/*  37 */     x = chunkX + random.nextInt(16) + 8;
/*  38 */     z = chunkZ + random.nextInt(16) + 8;
/*  39 */     if (generatePeat(world, random, x, world.func_72825_h(x, z), z))
/*     */     {
/*  41 */       if (random.nextInt(5) == 0)
/*     */       {
/*  43 */         if (!cloudberryGen.func_76484_a(world, random, x, world.func_72825_h(x, z) + 1, z)) {
/*  44 */           cranberryGen.func_76484_a(world, random, x, world.func_72825_h(x, z) + 1, z);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean generatePeat(World world, Random random, int xCoord, int yCoord, int zCoord) {
/*  51 */     int var6 = random.nextInt(16) + 8;
/*  52 */     byte var7 = 2;
/*  53 */     boolean flag = false;
/*     */     
/*  55 */     if (random.nextInt(50) == 0 && yCoord <= 144)
/*     */     {
/*  57 */       for (int x = xCoord - var6; x <= xCoord + var6; x++) {
/*     */         
/*  59 */         for (int z = zCoord - var6; z <= zCoord + var6; z++) {
/*     */           
/*  61 */           int var10 = x - xCoord;
/*  62 */           int var11 = z - zCoord;
/*  63 */           if (var10 * var10 + var11 * var11 <= var6 * var6)
/*     */           {
/*  65 */             for (int y = yCoord - var7; y <= yCoord + var7; y++) {
/*     */               
/*  67 */               Block block = world.func_147439_a(x, y, z);
/*  68 */               if (TFC_Climate.isSwamp(world, x, y, z))
/*     */               {
/*  70 */                 if (TFC_Core.isDirt(block) || TFC_Core.isClay(block) || TFC_Core.isPeat(block)) {
/*     */                   
/*  72 */                   world.func_147465_d(x, y, z, TFCBlocks.peat, 0, 2);
/*  73 */                   flag = true;
/*     */                 }
/*  75 */                 else if (TFC_Core.isGrass(block)) {
/*     */                   
/*  77 */                   world.func_147465_d(x, y, z, TFCBlocks.peatGrass, 0, 2);
/*  78 */                   flag = true;
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*  86 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generateClay(World world, Random rand, int i, int j, int k) {
/*  91 */     int radius = rand.nextInt(14) + 2;
/*  92 */     byte depth = (byte)(rand.nextInt(3) + 1);
/*  93 */     boolean flag = false;
/*  94 */     if (rand.nextInt(30) == 0 && j <= 150)
/*     */     {
/*  96 */       for (int xCoord = i - radius; xCoord <= i + radius; xCoord++) {
/*     */         
/*  98 */         for (int zCoord = k - radius; zCoord <= k + radius; zCoord++) {
/*     */           
/* 100 */           int x = xCoord - i;
/* 101 */           int z = zCoord - k;
/* 102 */           if (x * x + z * z <= radius * radius && TFC_Climate.getRainfall(world, xCoord, 144, zCoord) >= 500.0F) {
/*     */             
/* 104 */             flag = false;
/* 105 */             for (int yCoord = j - depth; yCoord <= j + depth; yCoord++) {
/*     */               
/* 107 */               Block block = world.func_147439_a(xCoord, yCoord, zCoord);
/* 108 */               DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(xCoord, zCoord, 0);
/* 109 */               if (block == TFCBlocks.dirt || block == TFCBlocks.dirt2) {
/*     */                 
/* 111 */                 world.func_147465_d(xCoord, yCoord, zCoord, TFC_Core.getTypeForClay(block), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 112 */                 flag = true;
/*     */               }
/* 114 */               else if (block == TFCBlocks.grass || block == TFCBlocks.grass2) {
/*     */                 
/* 116 */                 world.func_147465_d(xCoord, yCoord, zCoord, TFC_Core.getTypeForClayGrass(block), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 117 */                 flag = true;
/*     */               } 
/*     */             } 
/* 120 */             if (flag && rand.nextInt(15) == 0) {
/*     */               
/* 122 */               int y = world.func_72825_h(xCoord, zCoord);
/* 123 */               if (world.func_147437_c(xCoord, y, zCoord) && TFC_Core.isSoil(world.func_147439_a(xCoord, y - 1, zCoord)))
/* 124 */                 world.func_147465_d(xCoord, y, zCoord, TFCBlocks.flora, 0, 2); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 130 */     return flag;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenSoilPits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */