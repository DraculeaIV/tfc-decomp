/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.Util.BlockMeta;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.Enums.TFCDirection;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Util.ByteCoord;
/*     */ import com.bioxx.tfc.api.Util.CollapseData;
/*     */ import com.bioxx.tfc.api.Util.CollapseList;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenFissure
/*     */   implements IWorldGenerator
/*     */ {
/*     */   private Random rand;
/*     */   private int poolDepth;
/*  31 */   private int creviceDepth = 1;
/*     */   private Block fillBlock;
/*  33 */   private int depth = 20;
/*  34 */   private int minTunnel = 1;
/*     */   
/*     */   public boolean checkStability = true;
/*     */   private boolean underground;
/*  38 */   private int rarity = 30;
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenFissure(Block b) {
/*  43 */     this.fillBlock = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldGenFissure(Block b, int minTunnel, boolean s, int rare) {
/*  48 */     this(b);
/*  49 */     this.minTunnel = minTunnel;
/*  50 */     this.checkStability = s;
/*  51 */     this.rarity = rare;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenFissure setSeed(int i) {
/*  57 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldGenFissure setUnderground(boolean i, int d) {
/*  62 */     this.underground = i;
/*  63 */     this.depth = d;
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/*  71 */     this.rand = random;
/*  72 */     chunkX *= 16;
/*  73 */     chunkZ *= 16;
/*     */     
/*  75 */     int startX = chunkX + random.nextInt(16) + 8;
/*  76 */     int startZ = chunkZ + random.nextInt(16) + 8;
/*  77 */     BiomeGenBase biome = world.func_72807_a(startX, startZ);
/*     */     
/*  79 */     if (this.rarity <= 0 || this.rand.nextInt(this.rarity) != 0 || biome == TFCBiome.BEACH || biome == TFCBiome.OCEAN || biome == TFCBiome.GRAVEL_BEACH || biome == TFCBiome.LAKE || biome == TFCBiome.RIVER || biome == TFCBiome.DEEP_OCEAN) {
/*     */       return;
/*     */     }
/*     */     
/*  83 */     int startY = world.func_72825_h(startX, startZ) - 1;
/*  84 */     if (this.underground) {
/*  85 */       startY = this.depth + this.rand.nextInt(60);
/*     */     }
/*  87 */     generate(world, this.rand, startX, startY, startZ);
/*     */   }
/*     */ 
/*     */   
/*     */   public void generate(World world, Random rand, int x, int y, int z) {
/*  92 */     this.creviceDepth = 1;
/*  93 */     if (rand.nextInt(100) < 50)
/*  94 */       this.creviceDepth += 2 + rand.nextInt(8); 
/*  95 */     this.poolDepth = 1 + rand.nextInt(Math.max(this.creviceDepth - 1, 1));
/*     */     
/*  97 */     for (int d = 1; d <= this.poolDepth; d++) {
/*     */       
/*  99 */       if (!world.func_147439_a(x, y - d, z).func_149721_r()) {
/*     */         return;
/*     */       }
/*     */     } 
/* 103 */     Block block = world.func_147439_a(x, y, z);
/*     */     
/* 105 */     if (block != null && block.func_149688_o() == Material.field_151586_h)
/*     */       return; 
/* 107 */     if (this.underground) {
/* 108 */       y -= 20 + rand.nextInt(this.depth);
/*     */     }
/* 110 */     int stability = TFC_Climate.getStability(world, x, z);
/* 111 */     if (this.checkStability && stability == 0)
/*     */       return; 
/* 113 */     if (stability == 1 && this.fillBlock != null && this.fillBlock.func_149688_o() == Material.field_151586_h)
/* 114 */       this.fillBlock = TFCBlocks.hotWater; 
/* 115 */     if (!TFC_Core.isGround(block)) {
/*     */       return;
/*     */     }
/* 118 */     DataLayer dl = TFC_Climate.getRockLayer(world, x, y, z, 2);
/* 119 */     BlockMeta rockLayer = (this.fillBlock != null) ? new BlockMeta(dl.block, dl.data2) : new BlockMeta(Blocks.field_150350_a, -1);
/* 120 */     if (rockLayer.block == null)
/*     */       return; 
/* 122 */     List<ByteCoord> map = getCollapseMap(world, x, y - this.creviceDepth, z);
/* 123 */     for (ByteCoord b : map) {
/*     */       
/* 125 */       world.func_147468_f(x + b.x, y + b.y, z + b.z);
/* 126 */       for (int i = 1; i <= this.poolDepth; i++) {
/* 127 */         fill(world, x + b.x, y + b.y - i, z + b.z, rockLayer.block, rockLayer.meta, (this.fillBlock != null) ? this.fillBlock : Blocks.field_150350_a);
/*     */       }
/* 129 */       int rx = 0;
/* 130 */       int rz = 0;
/* 131 */       for (int j = 0; j <= this.creviceDepth; j++) {
/*     */         
/* 133 */         carve(world, x + b.x, y + b.y + j, z + b.z, rockLayer.block, rockLayer.meta);
/* 134 */         if (rand.nextInt(3) == 0) {
/*     */           
/* 136 */           rx = -1 + rand.nextInt(3);
/* 137 */           rz = -1 + rand.nextInt(3);
/* 138 */           carve(world, x + b.x + rx, y + b.y + j, z + b.z + rz, rockLayer.block, rockLayer.meta);
/*     */         } 
/*     */       } 
/* 141 */       if (this.fillBlock != null && this.fillBlock.func_149688_o() == Material.field_151587_i) {
/* 142 */         world.func_147465_d(x + b.x, y + b.y - this.poolDepth - 1, z + b.z, rockLayer.block, rockLayer.meta, 2);
/*     */       }
/*     */     } 
/* 145 */     boolean makeTunnel = (map.size() > 10);
/* 146 */     if (makeTunnel) {
/* 147 */       makeTunnel(rand, world, x, z, y, rockLayer);
/*     */     }
/*     */   }
/*     */   
/*     */   private void carve(World world, int x, int y, int z, Block block, int meta) {
/* 152 */     if (world.func_147439_a(x, y, z).func_149688_o() != Material.field_151579_a && TFC_Core.isGround(world.func_147439_a(x, y, z)))
/* 153 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 3); 
/* 154 */     if (world.func_147439_a(x - 1, y, z).func_149688_o() != Material.field_151579_a && TFC_Core.isRawStone(world.func_147439_a(x - 1, y, z)))
/* 155 */       world.func_147465_d(x - 1, y, z, block, meta, 3); 
/* 156 */     if (world.func_147439_a(x + 1, y, z).func_149688_o() != Material.field_151579_a && TFC_Core.isRawStone(world.func_147439_a(x + 1, y, z)))
/* 157 */       world.func_147465_d(x + 1, y, z, block, meta, 3); 
/* 158 */     if (world.func_147439_a(x, y, z - 1).func_149688_o() != Material.field_151579_a && TFC_Core.isRawStone(world.func_147439_a(x, y, z - 1)))
/* 159 */       world.func_147465_d(x, y, z - 1, block, meta, 3); 
/* 160 */     if (world.func_147439_a(x, y, z + 1).func_149688_o() != Material.field_151579_a && TFC_Core.isRawStone(world.func_147439_a(x, y, z + 1))) {
/* 161 */       world.func_147465_d(x, y, z + 1, block, meta, 3);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fill(World world, int x, int y, int z, Block block, int meta, Block fill) {
/* 166 */     world.func_147465_d(x, y, z, fill, 0, 2);
/* 167 */     if (world.func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151579_a)
/* 168 */       world.func_147465_d(x - 1, y, z, block, meta, 2); 
/* 169 */     if (world.func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151579_a)
/* 170 */       world.func_147465_d(x + 1, y, z, block, meta, 2); 
/* 171 */     if (world.func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151579_a)
/* 172 */       world.func_147465_d(x, y, z - 1, block, meta, 2); 
/* 173 */     if (world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151579_a)
/* 174 */       world.func_147465_d(x, y, z + 1, block, meta, 2); 
/* 175 */     if (world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151579_a) {
/* 176 */       world.func_147465_d(x, y - 1, z, block, meta, 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private void makeTunnel(Random random, World world, int x, int z, int y, BlockMeta rockLayer) {
/* 181 */     int xCoord = x, yCoord = y - this.poolDepth - 1, zCoord = z;
/* 182 */     float downChance = 75.0F;
/* 183 */     while (yCoord > this.minTunnel) {
/*     */       
/* 185 */       if (world.func_147439_a(xCoord, yCoord, zCoord) == Blocks.field_150357_h)
/*     */         break; 
/* 187 */       if (random.nextFloat() < downChance / 100.0F) {
/*     */         
/* 189 */         yCoord--;
/*     */       }
/*     */       else {
/*     */         
/* 193 */         int dir = random.nextInt(3);
/* 194 */         switch (dir) {
/*     */           case 0:
/* 196 */             xCoord++; break;
/* 197 */           case 1: xCoord--; break;
/* 198 */           case 2: zCoord++; break;
/* 199 */           case 3: zCoord--;
/*     */             break;
/*     */         } 
/*     */       } 
/* 203 */       world.func_147465_d(xCoord, yCoord, zCoord, (this.fillBlock != null) ? this.fillBlock : Blocks.field_150350_a, 0, 2);
/*     */       
/* 205 */       if (this.fillBlock != null && world.func_147439_a(xCoord + 1, yCoord, zCoord).func_149688_o() != this.fillBlock.func_149688_o())
/* 206 */         world.func_147465_d(xCoord + 1, yCoord, zCoord, rockLayer.block, rockLayer.meta, 2); 
/* 207 */       if (this.fillBlock != null && world.func_147439_a(xCoord - 1, yCoord, zCoord).func_149688_o() != this.fillBlock.func_149688_o())
/* 208 */         world.func_147465_d(xCoord - 1, yCoord, zCoord, rockLayer.block, rockLayer.meta, 2); 
/* 209 */       if (this.fillBlock != null && world.func_147439_a(xCoord, yCoord, zCoord + 1).func_149688_o() != this.fillBlock.func_149688_o())
/* 210 */         world.func_147465_d(xCoord, yCoord, zCoord + 1, rockLayer.block, rockLayer.meta, 2); 
/* 211 */       if (this.fillBlock != null && world.func_147439_a(xCoord, yCoord, zCoord - 1).func_149688_o() != this.fillBlock.func_149688_o()) {
/* 212 */         world.func_147465_d(xCoord, yCoord, zCoord - 1, rockLayer.block, rockLayer.meta, 2);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ByteCoord> getCollapseMap(World world, int i, int j, int k) {
/* 219 */     ArrayList<ByteCoord> map = new ArrayList<ByteCoord>();
/* 220 */     ArrayList<ByteCoord> checkedmap = new ArrayList<ByteCoord>();
/* 221 */     CollapseList<CollapseData> checkQueue = new CollapseList();
/* 222 */     float baseCollapse = 55.0F;
/* 223 */     float incrementChance = 5.0F;
/* 224 */     float incrementChanceDiag = 2.5F;
/*     */     
/* 226 */     DataLayer dl = TFC_Climate.getRockLayer(world, i, j, k, TFC_Core.getRockLayerFromHeight(world, i, j, k));
/* 227 */     DataLayer dl2 = TFC_Climate.getRockLayer(world, i, j, k, 2);
/* 228 */     BlockMeta rockLayer = (this.fillBlock != null && this.fillBlock.func_149688_o() == Material.field_151587_i) ? new BlockMeta(dl2.block, dl2.data2) : new BlockMeta(dl.block, dl.data2);
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
/* 239 */     checkQueue.add(new CollapseData(new ByteCoord(0, -1, 0), 100.0F, TFCDirection.NULL));
/*     */     
/* 241 */     while (checkQueue.peek() != null) {
/*     */       
/* 243 */       CollapseData block = (CollapseData)checkQueue.peek();
/* 244 */       int worldX = block.coords.x + i;
/* 245 */       int worldY = block.coords.y + j;
/* 246 */       int worldZ = block.coords.z + k;
/* 247 */       int localX = block.coords.x;
/* 248 */       int localY = block.coords.y;
/* 249 */       int localZ = block.coords.z;
/* 250 */       Block id = world.func_147439_a(worldX, worldY, worldZ);
/*     */       
/* 252 */       if (!checkedmap.contains(block) && TFC_Core.isGround(id) && world.field_73012_v
/* 253 */         .nextFloat() < block.collapseChance / 100.0F) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 258 */         map.add(block.coords);
/*     */         
/* 260 */         if (checkQueue.size() < 500) {
/* 261 */           switch (block.direction) {
/*     */ 
/*     */             
/*     */             case NORTH:
/* 265 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 5.0F, TFCDirection.NORTH));
/* 266 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.EAST));
/* 267 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTH:
/* 272 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 5.0F, TFCDirection.SOUTH));
/* 273 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.EAST));
/* 274 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case EAST:
/* 279 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 5.0F, TFCDirection.SOUTH));
/* 280 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.EAST));
/* 281 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 5.0F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case WEST:
/* 286 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 5.0F, TFCDirection.SOUTH));
/* 287 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.WEST));
/* 288 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 5.0F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHEAST:
/* 293 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.SOUTHEAST));
/* 294 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 5.0F, TFCDirection.SOUTH));
/* 295 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.EAST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHWEST:
/* 300 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.SOUTHWEST));
/* 301 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 5.0F, TFCDirection.SOUTH));
/* 302 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHEAST:
/* 307 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.NORTHEAST));
/* 308 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.EAST));
/* 309 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 5.0F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHWEST:
/* 314 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.NORTHWEST));
/* 315 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 5.0F, TFCDirection.NORTH));
/* 316 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 5.0F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             default:
/* 321 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), 50.0F, TFCDirection.EAST));
/* 322 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), 50.0F, TFCDirection.WEST));
/* 323 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), 52.5F, TFCDirection.NORTHEAST));
/* 324 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), 52.5F, TFCDirection.SOUTHEAST));
/* 325 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), 52.5F, TFCDirection.NORTHWEST));
/* 326 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), 52.5F, TFCDirection.SOUTHWEST));
/* 327 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), 50.0F, TFCDirection.SOUTH));
/* 328 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), 50.0F, TFCDirection.NORTH));
/*     */               break;
/*     */           } 
/*     */         
/*     */         }
/* 333 */       } else if (block.collapseChance < 100.0F) {
/*     */         
/* 335 */         for (int d = 0; d <= this.poolDepth; d++) {
/*     */           
/* 337 */           if (TFC_Core.isGround(world.func_147439_a(worldX, worldY - d, worldZ)))
/* 338 */             world.func_147465_d(worldX, worldY - d, worldZ, rockLayer.block, rockLayer.meta, 2); 
/*     */         } 
/*     */       } 
/* 341 */       checkedmap.add(block.coords);
/* 342 */       checkQueue.removeFirst();
/*     */     } 
/* 344 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenFissure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */