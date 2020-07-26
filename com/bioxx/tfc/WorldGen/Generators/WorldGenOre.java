/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.Util.CaseInsensitiveHashMap;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenOre
/*     */   implements IWorldGenerator
/*     */ {
/*     */   private int chunkX;
/*     */   private int chunkZ;
/*     */   private World worldObj;
/*     */   private Random random;
/*  28 */   public static Map<String, OreSpawnData> oreList = (Map<String, OreSpawnData>)new CaseInsensitiveHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  37 */     chunkX *= 16;
/*  38 */     chunkZ *= 16;
/*  39 */     this.chunkX = chunkX;
/*  40 */     this.chunkZ = chunkZ;
/*  41 */     this.worldObj = world;
/*  42 */     this.random = rand;
/*     */     
/*  44 */     Iterator<OreSpawnData> iter = oreList.values().iterator();
/*  45 */     while (iter.hasNext()) {
/*     */       
/*  47 */       OreSpawnData osd = iter.next();
/*  48 */       if (osd.type == 0) {
/*     */         
/*  50 */         if (osd.size == 0) {
/*  51 */           oreSmall(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity); continue;
/*  52 */         }  if (osd.size == 1) {
/*  53 */           oreMedium(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity); continue;
/*  54 */         }  if (osd.size == 2)
/*  55 */           oreLarge(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity);  continue;
/*     */       } 
/*  57 */       if (osd.type == 1) {
/*     */         
/*  59 */         if (osd.size == 0) {
/*  60 */           oreSmallVein(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity); continue;
/*  61 */         }  if (osd.size == 1) {
/*  62 */           oreMediumVein(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity); continue;
/*  63 */         }  if (osd.size == 2) {
/*  64 */           oreLargeVein(osd.block, osd.meta, osd.base, osd.rarity, osd.min, osd.max, osd.vDensity, osd.hDensity);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void oreSmallVein(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/*  71 */     createOreVein(block, meta, baseRocks, rarity, 20, 30, 5, 40, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void oreMediumVein(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/*  78 */     createOreVein(block, meta, baseRocks, rarity, 30, 40, 10, 60, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void oreLargeVein(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/*  85 */     createOreVein(block, meta, baseRocks, rarity, 60, 45, 20, 80, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void oreSmall(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/*  92 */     createOre(block, meta, baseRocks, rarity, 20, 30, 5, 80, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void oreMedium(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/*  99 */     createOre(block, meta, baseRocks, rarity, 30, 40, 10, 120, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void oreLarge(Block block, int meta, Map<Block, List<Integer>> baseRocks, int rarity, int min, int max, int vDensity, int hDensity) {
/* 106 */     createOre(block, meta, baseRocks, rarity, 60, 40, 5, 120, vDensity, hDensity, this.worldObj, this.random, this.chunkX, this.chunkZ, min, max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void createOre(Block block, int j, Map<Block, List<Integer>> layers, int rarity, int veinSize, int veinAmount, int height, int diameter, int vDensity, int hDensity, World world, Random rand, int chunkX, int chunkZ, int min, int max) {
/* 114 */     if (world.func_72959_q() instanceof com.bioxx.tfc.WorldGen.TFCWorldChunkManager)
/*     */     {
/* 116 */       for (Block b : layers.keySet()) {
/*     */         
/* 118 */         for (Iterator<Integer> iterator = ((List)layers.get(b)).iterator(); iterator.hasNext(); ) { int metadata = ((Integer)iterator.next()).intValue();
/*     */           
/* 120 */           DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 0);
/* 121 */           DataLayer rockLayer2 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 1);
/* 122 */           DataLayer rockLayer3 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 2);
/* 123 */           if ((rockLayer1.block == b && (rockLayer1.data2 == metadata || metadata == -1)) || (rockLayer2.block == b && (rockLayer2.data2 == metadata || metadata == -1)) || (rockLayer3.block == b && (rockLayer3.data2 == metadata || metadata == -1))) {
/*     */ 
/*     */ 
/*     */             
/* 127 */             int grade = rand.nextInt(100);
/* 128 */             if (grade < 20) {
/* 129 */               grade = 1;
/* 130 */             } else if (grade < 50) {
/* 131 */               grade = 2;
/*     */             } else {
/* 133 */               grade = 0;
/*     */             } 
/* 135 */             (new WorldGenMinable(block, j, b, metadata, rarity, veinSize, veinAmount, height, diameter, vDensity, hDensity, false, grade))
/* 136 */               .generate(world, rand, chunkX, chunkZ, min, max);
/*     */           }  }
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void createOreVein(Block block, int j, Map<Block, List<Integer>> layers, int rarity, int veinSize, int veinAmount, int height, int diameter, int vDensity, int hDensity, World world, Random rand, int chunkX, int chunkZ, int min, int max) {
/* 147 */     if (world.func_72959_q() instanceof com.bioxx.tfc.WorldGen.TFCWorldChunkManager)
/*     */     {
/* 149 */       for (Block b : layers.keySet()) {
/*     */         
/* 151 */         for (Iterator<Integer> iterator = ((List)layers.get(b)).iterator(); iterator.hasNext(); ) { int metadata = ((Integer)iterator.next()).intValue();
/*     */           
/* 153 */           DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 0);
/* 154 */           DataLayer rockLayer2 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 1);
/* 155 */           DataLayer rockLayer3 = TFC_Climate.getCacheManager(world).getRockLayerAt(chunkX, chunkZ, 2);
/* 156 */           if ((rockLayer1.block == b && (rockLayer1.data2 == metadata || metadata == -1)) || (rockLayer2.block == b && (rockLayer2.data2 == metadata || metadata == -1)) || (rockLayer3.block == b && (rockLayer3.data2 == metadata || metadata == -1))) {
/*     */ 
/*     */ 
/*     */             
/* 160 */             int grade = rand.nextInt(100);
/* 161 */             if (grade < 20) {
/* 162 */               grade = 1;
/* 163 */             } else if (grade < 50) {
/* 164 */               grade = 2;
/*     */             } else {
/* 166 */               grade = 0;
/*     */             } 
/* 168 */             (new WorldGenMinable(block, j, b, metadata, rarity, veinSize, veinAmount, height, diameter, vDensity, hDensity, true, grade))
/* 169 */               .generate(world, rand, chunkX, chunkZ, min, max);
/*     */           }  }
/*     */       
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */