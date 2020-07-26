/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEOre;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenMinable
/*     */   extends WorldGenerator
/*     */ {
/*  25 */   private static List oreList = new ArrayList();
/*     */   
/*     */   public static int mPChunkX;
/*     */   
/*     */   public static int mPChunkZ;
/*     */   
/*     */   private int xChunk;
/*     */   
/*     */   private int zChunk;
/*     */   
/*     */   public Block mPBlock;
/*     */   
/*     */   private final int minableBlockMeta;
/*     */   
/*     */   public static int mPPrevX;
/*     */   
/*     */   public static int mPPrevZ;
/*     */   
/*     */   public static Block mPPrevBlock;
/*     */   
/*     */   public static int mPPrevMeta;
/*     */   private static boolean genBeforeCheck;
/*     */   public static int mineCount;
/*     */   public static int mineCountM;
/*     */   private static Random rand;
/*     */   private static World worldObj;
/*     */   private final int rarity;
/*     */   private final int veinSi;
/*     */   private final int veinAm;
/*     */   private final int height;
/*  55 */   private int mineHeight = 2;
/*     */   
/*     */   private final int diameter;
/*     */   
/*     */   private final int vDens;
/*     */   
/*     */   private final int hDens;
/*     */   
/*     */   private final Block genInBlock;
/*     */   
/*     */   private final int genInBlockMeta;
/*     */   
/*     */   private final boolean useMarcoVeins;
/*     */   
/*     */   private final int grade;
/*     */   private final Block minableBlock;
/*     */   private int numberOfBlocks;
/*     */   
/*     */   public WorldGenMinable(Block block, int j, Block layerBlock, int layerMeta, int rarity, int veinSize, int veinAmount, int height, int diameter, int vDensity, int hDensity, boolean vein, int oreGrade) {
/*  74 */     this.minableBlock = block;
/*  75 */     this.minableBlockMeta = j;
/*  76 */     this.genInBlock = layerBlock;
/*  77 */     this.genInBlockMeta = layerMeta;
/*  78 */     this.rarity = rarity;
/*  79 */     this.veinSi = veinSize;
/*  80 */     this.veinAm = veinAmount;
/*  81 */     this.height = height;
/*  82 */     this.diameter = diameter;
/*  83 */     this.vDens = vDensity;
/*  84 */     this.hDens = hDensity;
/*  85 */     this.useMarcoVeins = vein;
/*  86 */     this.grade = oreGrade;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generateBeforeCheck() {
/*  91 */     genBeforeCheck = false;
/*  92 */     genBeforeCheck = oreList.contains(Arrays.asList(new Object[] { this.mPBlock, Integer.valueOf(this.minableBlockMeta) }));
/*  93 */     if (!genBeforeCheck)
/*  94 */       oreList.add(Arrays.asList(new Object[] { this.mPBlock, Integer.valueOf(this.minableBlockMeta) })); 
/*  95 */     return genBeforeCheck;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createMine(World worldObj, Random rand, int x, int z) {
/* 100 */     for (int loopCount = 0; loopCount < this.veinAm; loopCount++) {
/*     */       
/* 102 */       int temp1 = mPCalculateDensity(this.diameter, this.hDens);
/* 103 */       int temp2 = this.mineHeight + mPCalculateDensity(this.height, this.vDens);
/* 104 */       int temp3 = mPCalculateDensity(this.diameter, this.hDens);
/* 105 */       int posX = x + temp1;
/* 106 */       int posY = temp2;
/* 107 */       int posZ = z + temp3;
/* 108 */       if (!this.useMarcoVeins) {
/* 109 */         bODgenerate(worldObj, rand, posX, posY, posZ, this.veinSi);
/*     */       } else {
/* 111 */         bODgenerateVein(worldObj, rand, posX, posY, posZ, this.veinSi);
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
/*     */   public boolean generate(World world, Random random, int x, int z, int min, int max) {
/* 123 */     mPChunkX = x;
/* 124 */     mPChunkZ = z;
/* 125 */     rand = random;
/* 126 */     worldObj = world;
/* 127 */     mineCount = 0;
/* 128 */     oreList.clear();
/* 129 */     this.mPBlock = this.minableBlock;
/*     */     
/* 131 */     if (mPChunkX != mPPrevX || mPChunkZ != mPPrevZ || mPPrevBlock != this.mPBlock || this.minableBlockMeta != mPPrevMeta)
/*     */     {
/* 133 */       if (!generateBeforeCheck()) {
/*     */         
/* 135 */         mPPrevX = mPChunkX;
/* 136 */         mPPrevZ = mPChunkZ;
/* 137 */         this.xChunk = mPChunkX;
/* 138 */         this.zChunk = mPChunkZ;
/* 139 */         mPPrevBlock = this.mPBlock;
/* 140 */         mPPrevMeta = this.minableBlockMeta;
/* 141 */         this.mineHeight = min + rand.nextInt(max - min);
/* 142 */         if (this.rarity == 1 || (this.rarity > 0 && rand.nextInt(this.rarity) == 0))
/* 143 */           createMine(worldObj, rand, this.xChunk, this.zChunk); 
/*     */       } 
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mPCalculateDensity(int oreDistance, float oreDensity) {
/* 151 */     int loopCount = 0;
/* 152 */     int densityValuePassInner = 0;
/* 153 */     int densityValuePass = 0;
/* 154 */     oreDensity *= 0.01F;
/* 155 */     oreDensity = oreDensity * (oreDistance >> 1) + 1.0F;
/* 156 */     loopCount = (int)oreDensity;
/* 157 */     densityValuePassInner = oreDistance / loopCount;
/* 158 */     densityValuePassInner += (oreDistance - densityValuePassInner * loopCount) / loopCount;
/* 159 */     densityValuePass = 0;
/* 160 */     while (loopCount > 0) {
/*     */       
/* 162 */       densityValuePass += rand.nextInt(densityValuePassInner);
/* 163 */       loopCount--;
/*     */     } 
/* 165 */     return densityValuePass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bODgenerateVein(World world, Random rand, int parX, int parY, int parZ, int xyz) {
/* 171 */     int posX = parX;
/* 172 */     int posY = parY;
/* 173 */     int posZ = parZ;
/*     */ 
/*     */ 
/*     */     
/* 177 */     int posX2 = 0;
/* 178 */     int posY2 = 0;
/* 179 */     int posZ2 = 0;
/* 180 */     int directionX = 0;
/* 181 */     int directionY = 0;
/* 182 */     int directionZ = 0;
/* 183 */     int directionX2 = 0;
/* 184 */     int directionY2 = 0;
/* 185 */     int directionZ2 = 0;
/*     */ 
/*     */ 
/*     */     
/* 189 */     int directionChange = 0;
/* 190 */     int directionChange2 = 0;
/* 191 */     int blocksToUse = xyz;
/* 192 */     int blocksToUse2 = 0;
/*     */     
/* 194 */     for (int blocksMade = 0; blocksMade <= blocksToUse; ) {
/*     */       
/* 196 */       blocksToUse2 = 1 + blocksToUse / 30;
/* 197 */       directionChange = rand.nextInt(6);
/* 198 */       directionX = rand.nextInt(2);
/* 199 */       directionY = rand.nextInt(2);
/* 200 */       directionZ = rand.nextInt(2);
/*     */       
/* 202 */       for (int blocksMade1 = 0; blocksMade1 <= blocksToUse2; ) {
/*     */         
/* 204 */         if (directionX == 0 && directionChange != 1)
/* 205 */           posX += rand.nextInt(2); 
/* 206 */         if (directionX == 1 && directionChange != 1)
/* 207 */           posX -= rand.nextInt(2); 
/* 208 */         if (directionY == 0 && directionChange != 2)
/* 209 */           posY += rand.nextInt(2); 
/* 210 */         if (directionY == 1 && directionChange != 2)
/* 211 */           posY -= rand.nextInt(2); 
/* 212 */         if (directionZ == 0 && directionChange != 3)
/* 213 */           posZ += rand.nextInt(2); 
/* 214 */         if (directionZ == 1 && directionChange != 3)
/* 215 */           posZ -= rand.nextInt(2); 
/* 216 */         if (rand.nextInt(4) == 0) {
/*     */           
/* 218 */           posX2 += rand.nextInt(2);
/* 219 */           posY2 += rand.nextInt(2);
/* 220 */           posZ2 += rand.nextInt(2);
/* 221 */           posX2 -= rand.nextInt(2);
/* 222 */           posY2 -= rand.nextInt(2);
/* 223 */           posZ2 -= rand.nextInt(2);
/*     */         } 
/* 225 */         if (rand.nextInt(3) == 0) {
/*     */           
/* 227 */           posX2 = posX;
/* 228 */           posY2 = posY;
/* 229 */           posZ2 = posZ;
/* 230 */           directionX2 = rand.nextInt(2);
/* 231 */           directionY2 = rand.nextInt(2);
/* 232 */           directionZ2 = rand.nextInt(2);
/* 233 */           directionChange2 = rand.nextInt(6);
/* 234 */           if (directionX2 == 0 && directionChange2 != 0)
/* 235 */             posX2 += rand.nextInt(2); 
/* 236 */           if (directionY2 == 0 && directionChange2 != 1)
/* 237 */             posY2 += rand.nextInt(2); 
/* 238 */           if (directionZ2 == 0 && directionChange2 != 2)
/* 239 */             posZ2 += rand.nextInt(2); 
/* 240 */           if (directionX2 == 1 && directionChange2 != 0)
/* 241 */             posX2 -= rand.nextInt(2); 
/* 242 */           if (directionY2 == 1 && directionChange2 != 1)
/* 243 */             posY2 -= rand.nextInt(2); 
/* 244 */           if (directionZ2 == 1 && directionChange2 != 2) {
/* 245 */             posZ2 -= rand.nextInt(2);
/*     */           }
/* 247 */           for (int blocksMade2 = 0; blocksMade2 <= 1 + blocksToUse2 / 5; ) {
/*     */             
/* 249 */             if (directionX2 == 0 && directionChange2 != 0)
/* 250 */               posX2 += rand.nextInt(2); 
/* 251 */             if (directionY2 == 0 && directionChange2 != 1)
/* 252 */               posY2 += rand.nextInt(2); 
/* 253 */             if (directionZ2 == 0 && directionChange2 != 2)
/* 254 */               posZ2 += rand.nextInt(2); 
/* 255 */             if (directionX2 == 1 && directionChange2 != 0)
/* 256 */               posX2 -= rand.nextInt(2); 
/* 257 */             if (directionY2 == 1 && directionChange2 != 1)
/* 258 */               posY2 -= rand.nextInt(2); 
/* 259 */             if (directionZ2 == 1 && directionChange2 != 2) {
/* 260 */               posZ2 -= rand.nextInt(2);
/*     */             }
/* 262 */             boolean bool1 = false;
/* 263 */             boolean bool2 = false;
/* 264 */             int i = posX & 0xF;
/* 265 */             int j = posZ & 0xF;
/*     */             
/* 267 */             ChunkData chunkData = TFC_Core.getCDM(world).getData(posX >> 4, posZ >> 4);
/* 268 */             int k = (chunkData != null) ? chunkData.heightmap[i + j * 16] : 0;
/* 269 */             posY = Math.min(255, posY + k);
/*     */             
/* 271 */             int n = world.func_72805_g(posX, posY, posZ);
/* 272 */             Block block = world.func_147439_a(posX, posY, posZ);
/* 273 */             bool1 = (block == this.genInBlock);
/* 274 */             bool2 = (n == this.genInBlockMeta || this.genInBlockMeta == -1);
/*     */             
/* 276 */             if (bool1 && bool2)
/*     */             {
/* 278 */               if (this.mPBlock != null && world.func_147465_d(posX, posY, posZ, this.mPBlock, this.minableBlockMeta, 2)) {
/*     */                 
/* 280 */                 TEOre te = (TEOre)world.func_147438_o(posX, posY, posZ);
/* 281 */                 if (te != null) {
/*     */                   
/* 283 */                   te.baseBlockID = Block.func_149682_b(block);
/* 284 */                   te.baseBlockMeta = n;
/* 285 */                   te.extraData = (byte)(this.grade + 8);
/*     */                 } 
/*     */               } 
/*     */             }
/* 289 */             blocksMade++;
/* 290 */             blocksMade1++;
/* 291 */             blocksMade2++;
/*     */           } 
/*     */         } 
/*     */         
/* 295 */         int localX = posX & 0xF;
/* 296 */         int localZ = posZ & 0xF;
/* 297 */         ChunkData data = TFC_Core.getCDM(world).getData(posX >> 4, posZ >> 4);
/* 298 */         int hm = (data != null) ? data.heightmap[localX + localZ * 16] : 0;
/* 299 */         posY = Math.min(255, posY + hm);
/*     */         
/* 301 */         int m = world.func_72805_g(posX, posY, posZ);
/* 302 */         Block b = world.func_147439_a(posX, posY, posZ);
/* 303 */         boolean isCorrectRockType = (b == this.genInBlock);
/* 304 */         boolean isCorrectMeta = (m == this.genInBlockMeta || this.genInBlockMeta == -1);
/*     */         
/* 306 */         if (isCorrectRockType && isCorrectMeta)
/*     */         {
/* 308 */           if (this.mPBlock != null && world.func_147465_d(posX, posY, posZ, this.mPBlock, this.minableBlockMeta, 2)) {
/*     */             
/* 310 */             TEOre te = (TEOre)world.func_147438_o(posX, posY, posZ);
/* 311 */             if (te != null) {
/*     */               
/* 313 */               te.baseBlockID = Block.func_149682_b(b);
/* 314 */               te.baseBlockMeta = m;
/* 315 */               te.extraData = (byte)this.grade;
/*     */             } 
/*     */           } 
/*     */         }
/* 319 */         blocksMade++;
/* 320 */         blocksMade1++;
/*     */       } 
/*     */       
/* 323 */       parX += rand.nextInt(3) - 1;
/* 324 */       parY += rand.nextInt(3) - 1;
/* 325 */       parZ += rand.nextInt(3) - 1;
/* 326 */       posX = parX;
/* 327 */       posY = parY;
/* 328 */       posZ = parZ;
/*     */     } 
/* 330 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bODgenerate(World world, Random rand, int par3, int par4, int par5, int xyz) {
/* 336 */     this.numberOfBlocks = xyz;
/*     */ 
/*     */     
/* 339 */     float var6 = rand.nextFloat() * 3.1415927F;
/* 340 */     double var7 = ((par3 + 8) + MathHelper.func_76126_a(var6) * this.numberOfBlocks / 8.0F);
/* 341 */     double var9 = ((par3 + 8) - MathHelper.func_76126_a(var6) * this.numberOfBlocks / 8.0F);
/* 342 */     double var11 = ((par5 + 8) + MathHelper.func_76134_b(var6) * this.numberOfBlocks / 8.0F);
/* 343 */     double var13 = ((par5 + 8) - MathHelper.func_76134_b(var6) * this.numberOfBlocks / 8.0F);
/* 344 */     double var15 = (par4 + rand.nextInt(3) - 2);
/* 345 */     double var17 = (par4 + rand.nextInt(3) - 2);
/*     */     
/* 347 */     for (int var19 = 0; var19 <= this.numberOfBlocks; var19++) {
/*     */       
/* 349 */       double var20 = var7 + (var9 - var7) * var19 / this.numberOfBlocks;
/* 350 */       double var22 = var15 + (var17 - var15) * var19 / this.numberOfBlocks;
/* 351 */       double var24 = var11 + (var13 - var11) * var19 / this.numberOfBlocks;
/* 352 */       double var26 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
/* 353 */       double var28 = (MathHelper.func_76126_a(var19 * 3.1415927F / this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
/* 354 */       double var30 = (MathHelper.func_76126_a(var19 * 3.1415927F / this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
/* 355 */       int var32 = MathHelper.func_76128_c(var20 - var28 / 2.0D);
/* 356 */       int var33 = MathHelper.func_76128_c(var22 - var30 / 2.0D);
/* 357 */       int var34 = MathHelper.func_76128_c(var24 - var28 / 2.0D);
/* 358 */       int var35 = MathHelper.func_76128_c(var20 + var28 / 2.0D);
/* 359 */       int var36 = MathHelper.func_76128_c(var22 + var30 / 2.0D);
/* 360 */       int var37 = MathHelper.func_76128_c(var24 + var28 / 2.0D);
/*     */       
/* 362 */       for (int posX = var32; posX <= var35; posX++) {
/*     */         
/* 364 */         double var39 = (posX + 0.5D - var20) / var28 / 2.0D;
/* 365 */         if (var39 * var39 < 1.0D)
/*     */         {
/* 367 */           for (int posY = var33; posY <= var36; posY++) {
/*     */             
/* 369 */             double var42 = (posY + 0.5D - var22) / var30 / 2.0D;
/* 370 */             if (var39 * var39 + var42 * var42 < 1.0D)
/*     */             {
/* 372 */               for (int posZ = var34; posZ <= var37; posZ++) {
/*     */                 
/* 374 */                 double var45 = (posZ + 0.5D - var24) / var28 / 2.0D;
/* 375 */                 int localX = posX & 0xF;
/* 376 */                 int localZ = posZ & 0xF;
/* 377 */                 ChunkData data = TFC_Core.getCDM(world).getData(posX >> 4, posZ >> 4);
/* 378 */                 int hm = (data != null) ? data.heightmap[localX + localZ * 16] : 0;
/* 379 */                 posY = Math.min(255, posY + hm);
/*     */                 
/* 381 */                 int m = world.func_72805_g(posX, posY, posZ);
/* 382 */                 Block b = world.func_147439_a(posX, posY, posZ);
/* 383 */                 boolean isCorrectRockType = (b == this.genInBlock);
/* 384 */                 boolean isCorrectMeta = (m == this.genInBlockMeta || this.genInBlockMeta == -1);
/*     */                 
/* 386 */                 if (isCorrectRockType && isCorrectMeta)
/*     */                 {
/* 388 */                   if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D)
/*     */                   {
/* 390 */                     if (this.mPBlock != null && world.func_147465_d(posX, posY, posZ, this.mPBlock, this.minableBlockMeta, 2)) {
/*     */                       
/* 392 */                       TEOre te = (TEOre)world.func_147438_o(posX, posY, posZ);
/* 393 */                       if (te != null) {
/*     */                         
/* 395 */                         te.baseBlockID = Block.func_149682_b(b);
/* 396 */                         te.baseBlockMeta = m;
/* 397 */                         te.extraData = (byte)this.grade;
/*     */                       } 
/*     */                     } 
/*     */                   }
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 409 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 415 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenMinable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */