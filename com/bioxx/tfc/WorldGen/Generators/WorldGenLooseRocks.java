/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockOre;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.TileEntities.TEWorldItem;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class WorldGenLooseRocks
/*     */   implements IWorldGenerator
/*     */ {
/*     */   private boolean generateRocks(World world, Random random, int i, int j, int k) {
/*  31 */     if ((world.func_147437_c(i, j + 1, k) || world.func_147439_a(i, j + 1, k) == Blocks.field_150433_aE || world.func_147439_a(i, j + 1, k) == TFCBlocks.tallGrass) && (world
/*  32 */       .func_147439_a(i, j, k).func_149688_o() == Material.field_151577_b || world.func_147439_a(i, j, k).func_149688_o() == Material.field_151576_e) && world.func_147439_a(i, j, k).func_149662_c())
/*     */     {
/*  34 */       if (world.func_147465_d(i, j + 1, k, TFCBlocks.worldItem, 0, 2)) {
/*     */         
/*  36 */         TEWorldItem te = (TEWorldItem)world.func_147438_o(i, j + 1, k);
/*  37 */         ItemStack sample = getCoreSample(world, i, j, k);
/*  38 */         if (world.field_73012_v.nextInt(3) == 0 && sample != null) {
/*     */           
/*  40 */           te.storage[0] = sample;
/*     */         }
/*     */         else {
/*     */           
/*  44 */           DataLayer dl = TFC_Climate.getRockLayer(world, i, j, k, 0);
/*     */           
/*  46 */           te.storage[0] = new ItemStack(TFCItems.looseRock, 1, dl.data1);
/*     */         } 
/*     */       } 
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemStack getCoreSample(World world, int xCoord, int yCoord, int zCoord) {
/*  55 */     ArrayList<Item> coreSample = new ArrayList<Item>();
/*  56 */     ArrayList<ItemStack> coreSampleStacks = new ArrayList<ItemStack>();
/*  57 */     for (int x = -15; x < 16; x++) {
/*     */       
/*  59 */       for (int z = -15; z < 16; z++) {
/*     */         
/*  61 */         for (int y = yCoord; y > yCoord - 35; y--) {
/*     */           
/*  63 */           if (world.func_72899_e(xCoord + x, y, zCoord + z) && world.func_147439_a(xCoord + x, y, zCoord + z) == TFCBlocks.ore) {
/*     */             
/*  65 */             int m = world.func_72805_g(xCoord + x, y, zCoord + z);
/*  66 */             if (!coreSample.contains(BlockOre.getDroppedItem(m)))
/*     */             {
/*  68 */               if (m != 14 && m != 15) {
/*     */                 
/*  70 */                 coreSample.add(BlockOre.getDroppedItem(m));
/*  71 */                 coreSampleStacks.add(new ItemStack(BlockOre.getDroppedItem(m), 1, m));
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  78 */     if (!coreSampleStacks.isEmpty())
/*  79 */       return coreSampleStacks.get(world.field_73012_v.nextInt(coreSampleStacks.size())); 
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  87 */     chunkX *= 16;
/*  88 */     chunkZ *= 16;
/*     */     
/*  90 */     if (world.func_72807_a(chunkX, chunkZ) instanceof TFCBiome) {
/*     */       
/*  92 */       TFCBiome biome = (TFCBiome)world.func_72807_a(chunkX, chunkZ);
/*  93 */       if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     for (int itemCount = 0; itemCount < 8; itemCount++) {
/*     */       
/* 100 */       int xCoord = chunkX + random.nextInt(16) + 8;
/* 101 */       int zCoord = chunkZ + random.nextInt(16) + 8;
/* 102 */       generateRocks(world, random, xCoord, world.func_72825_h(xCoord, zCoord) - 1, zCoord);
/*     */     } 
/*     */ 
/*     */     
/* 106 */     for (int stickCount = 0; stickCount < 5; stickCount++) {
/*     */       
/* 108 */       int xCoord = chunkX + random.nextInt(16) + 8;
/* 109 */       int zCoord = chunkZ + random.nextInt(16) + 8;
/* 110 */       generateSticks(world, random, xCoord, world.func_72825_h(xCoord, zCoord) - 1, zCoord);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean generateSticks(World world, Random random, int i, int j, int k) {
/* 116 */     if ((world.func_147437_c(i, j + 1, k) || world.func_147439_a(i, j + 1, k) == Blocks.field_150433_aE || world.func_147439_a(i, j + 1, k) == TFCBlocks.tallGrass) && (world
/* 117 */       .func_147439_a(i, j, k).func_149688_o() == Material.field_151577_b || world.func_147439_a(i, j, k).func_149688_o() == Material.field_151576_e || world
/* 118 */       .func_147439_a(i, j, k).func_149688_o() == Material.field_151595_p || world.func_147439_a(i, j, k).func_149688_o() == Material.field_151578_c) && world.func_147439_a(i, j, k).func_149662_c())
/*     */     {
/* 120 */       if (world.func_72807_a(i, k) instanceof TFCBiome) {
/*     */         
/* 122 */         TFCBiome biome = (TFCBiome)world.func_72807_a(i, k);
/* 123 */         if ((biome == TFCBiome.DEEP_OCEAN || biome == TFCBiome.BEACH || biome == TFCBiome.GRAVEL_BEACH || biome == TFCBiome.OCEAN || biome == TFCBiome.RIVER || isNearTree(world, i, j, k)) && world
/* 124 */           .func_147465_d(i, j + 1, k, TFCBlocks.worldItem, 0, 2)) {
/*     */           
/* 126 */           TEWorldItem te = (TEWorldItem)world.func_147438_o(i, j + 1, k);
/*     */           
/* 128 */           te.storage[0] = new ItemStack(TFCItems.stick, 1);
/*     */         } 
/*     */       } 
/*     */     }
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNearTree(World world, int i, int j, int k) {
/* 137 */     if (world.func_147439_a(i, j + 3, k).func_149688_o() == Material.field_151584_j || world
/* 138 */       .func_147439_a(i + 5, j + 3, k).func_149688_o() == Material.field_151584_j || world
/* 139 */       .func_147439_a(i - 5, j + 3, k).func_149688_o() == Material.field_151584_j || world
/* 140 */       .func_147439_a(i, j + 3, k + 5).func_149688_o() == Material.field_151584_j || world
/* 141 */       .func_147439_a(i, j + 3, k - 5).func_149688_o() == Material.field_151584_j) {
/* 142 */       return true;
/*     */     }
/* 144 */     return (world.func_147439_a(i, j + 6, k).func_149688_o() == Material.field_151584_j || world
/* 145 */       .func_147439_a(i + 5, j + 6, k).func_149688_o() == Material.field_151584_j || world
/* 146 */       .func_147439_a(i - 5, j + 6, k).func_149688_o() == Material.field_151584_j || world
/* 147 */       .func_147439_a(i, j + 6, k + 5).func_149688_o() == Material.field_151584_j || world
/* 148 */       .func_147439_a(i, j + 6, k - 5).func_149688_o() == Material.field_151584_j);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenLooseRocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */