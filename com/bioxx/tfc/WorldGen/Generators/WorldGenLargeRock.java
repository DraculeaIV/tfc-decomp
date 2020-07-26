/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenLargeRock
/*     */   implements IWorldGenerator
/*     */ {
/*     */   private int xWidth;
/*     */   private int xWidth2;
/*     */   private int zWidth;
/*     */   private int zWidth2;
/*     */   private static final int HEIGHT = 3;
/*     */   
/*     */   public boolean generate(World world, Random rand, int i, int j, int k) {
/*  29 */     int yOffset = 0;
/*  30 */     boolean isFlatEnough = false;
/*     */     
/*  32 */     for (; yOffset > -2 && !isFlatEnough; yOffset--) {
/*     */       
/*  34 */       if (world.func_147439_a(i, j + yOffset, k).func_149721_r())
/*     */       {
/*  36 */         if (world.func_147439_a(i + 1, j + yOffset, k).func_149721_r() && world.func_147439_a(i - 1, j + yOffset, k).func_149721_r() && world
/*  37 */           .func_147439_a(i - 1, j + yOffset, k).func_149721_r() && world.func_147439_a(i, j + yOffset, k + 1).func_149721_r()) {
/*  38 */           isFlatEnough = true;
/*     */         }
/*     */       }
/*     */     } 
/*  42 */     if (j <= 155) {
/*     */ 
/*     */       
/*  45 */       int i2 = i + (rand.nextInt(2) + 1) * (rand.nextBoolean() ? 1 : -1);
/*  46 */       int j2 = j + (rand.nextInt(2) + 1) * (rand.nextBoolean() ? 1 : -1);
/*  47 */       int k2 = k + (rand.nextInt(2) + 1) * (rand.nextBoolean() ? 1 : -1);
/*  48 */       genFromPoint(world, rand, i, j, k, yOffset);
/*  49 */       genFromPoint(world, rand, i2, j2, k2, yOffset);
/*     */     } 
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void genFromPoint(World world, Random rand, int i, int j, int k, int yOffset) {
/*  56 */     DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(i, k, 0);
/*  57 */     Vec3 center = Vec3.func_72443_a(i, (j + yOffset), k);
/*  58 */     this.xWidth = 3;
/*  59 */     this.xWidth2 = 3;
/*  60 */     this.zWidth = 3;
/*  61 */     this.zWidth2 = 3;
/*     */     
/*  63 */     for (int xCoord = i - this.xWidth; xCoord <= i + this.xWidth2; xCoord++) {
/*     */       
/*  65 */       for (int zCoord = k - this.zWidth; zCoord <= k + this.zWidth2; zCoord++) {
/*     */         
/*  67 */         for (int yCoord = j + yOffset - 3; yCoord <= j + yOffset + 3; yCoord++) {
/*     */           
/*  69 */           Vec3 point = Vec3.func_72443_a(xCoord, yCoord, zCoord);
/*  70 */           double distance = center.func_72436_e(point);
/*  71 */           boolean canPlaceX = true;
/*  72 */           boolean canPlaceZ = true;
/*  73 */           if (xCoord < i && distance > (this.xWidth * 4))
/*  74 */             canPlaceX = false; 
/*  75 */           if (xCoord > i && distance > (this.xWidth2 * 4))
/*  76 */             canPlaceX = false; 
/*  77 */           if (zCoord < i && distance > (this.zWidth * 4))
/*  78 */             canPlaceZ = false; 
/*  79 */           if (zCoord > i && distance > (this.zWidth2 * 4))
/*  80 */             canPlaceZ = false; 
/*  81 */           if (rand.nextInt(10) + 1 != 0 && canPlaceX && canPlaceZ) {
/*  82 */             world.func_147465_d(xCoord, yCoord, zCoord, rockLayer1.block, rockLayer1.data2, 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  92 */     chunkX *= 16;
/*  93 */     chunkZ *= 16;
/*  94 */     int xCoord = 0;
/*  95 */     int zCoord = 0;
/*     */     
/*  97 */     for (int count = 0; count < 1; count++) {
/*     */       
/*  99 */       xCoord = chunkX + random.nextInt(16) + 8;
/* 100 */       zCoord = chunkZ + random.nextInt(16) + 8;
/* 101 */       int yCoord = world.func_72976_f(xCoord, zCoord) - 1;
/* 102 */       this.xWidth = 2 + random.nextInt(6);
/* 103 */       this.xWidth2 = 2 + random.nextInt(6);
/* 104 */       this.zWidth = 2 + random.nextInt(6);
/* 105 */       this.zWidth2 = 2 + random.nextInt(6);
/* 106 */       if (random.nextInt(20) == 0 && TFC_Core.isSoil(world.func_147439_a(xCoord, yCoord, zCoord)))
/* 107 */         generate(world, random, xCoord, world.func_72825_h(xCoord, zCoord) - 1, zCoord); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenLargeRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */