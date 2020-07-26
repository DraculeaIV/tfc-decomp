/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenMinableTFC
/*     */   extends WorldGenerator
/*     */ {
/*     */   private final Block minableBlock;
/*     */   private final int minableBlockMeta;
/*     */   private int numberOfBlocks;
/*     */   private Block layerBlock;
/*     */   private int layerMeta;
/*     */   private int mPChunkX;
/*     */   private int mPChunkZ;
/*     */   public static Block mPBlock;
/*     */   public static int mPBlockMeta;
/*     */   public static Block mPlayerBlock;
/*     */   public static int mPlayerMeta;
/*     */   public static int mPPrevX;
/*     */   public static int mPPrevZ;
/*     */   public static Block mPPrevBlock;
/*     */   public static int mPPrevMeta;
/*     */   public static Block mPPrevLayerBlock;
/*     */   public static int mPPrevLayerMeta;
/*     */   private World worldObj;
/*  33 */   private int rarity = 2;
/*  34 */   private int veinSi = 2;
/*  35 */   private int veinAm = 2;
/*  36 */   private int height = 2;
/*  37 */   private int diameter = 2;
/*  38 */   private int vDens = 2;
/*  39 */   private int hDens = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenMinableTFC(Block block, int j) {
/*  46 */     this.minableBlock = block;
/*  47 */     this.minableBlockMeta = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WorldGenMinableTFC(Block block, int j, Block layerB, int layerMeta, int rarity, int veinSize, int veinAmount, int height, int diameter, int vDensity, int hDensity) {
/*  58 */     this.minableBlock = block;
/*  59 */     this.minableBlockMeta = j;
/*  60 */     this.layerBlock = layerB;
/*  61 */     this.layerMeta = layerMeta;
/*  62 */     this.rarity = rarity;
/*  63 */     this.veinSi = veinSize;
/*  64 */     this.veinAm = veinAmount;
/*  65 */     this.height = height;
/*  66 */     this.diameter = diameter;
/*  67 */     this.vDens = vDensity;
/*  68 */     this.hDens = hDensity;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean betterOreDistribution(int xChunk, int zChunk, Block mPMinableBlock, int mPMinableBlockMeta, int min, int max, Random rand) {
/*  73 */     if (rand.nextInt(this.rarity) == 0)
/*     */     {
/*  75 */       for (int loopCount = 0; loopCount < this.veinAm; loopCount++) {
/*     */         
/*  77 */         int temp1 = mPCalculateDensity(rand, this.diameter, this.hDens);
/*  78 */         int temp2 = mPCalculateDensityVert(rand, this.height, this.vDens, min, max);
/*  79 */         int temp3 = mPCalculateDensity(rand, this.diameter, this.hDens);
/*  80 */         int l5 = xChunk * 16 + temp1;
/*  81 */         int i9 = temp2;
/*  82 */         int k13 = zChunk * 16 + temp3;
/*  83 */         bODgenerate(this.worldObj, rand, l5, i9, k13, this.veinSi);
/*     */       } 
/*     */     }
/*  86 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean betterOreDistributionVein(int xChunk, int zChunk, Block mPMinableBlock, int mPMinableBlockMeta, int min, int max, Random rand) {
/*  91 */     if (rand.nextInt(this.rarity) == 0)
/*     */     {
/*  93 */       for (int loopCount = 0; loopCount < this.veinAm; loopCount++) {
/*     */         
/*  95 */         int temp1 = mPCalculateDensity(rand, this.diameter, this.hDens);
/*  96 */         int temp2 = mPCalculateDensityVert(rand, this.height, this.vDens, min, max);
/*  97 */         int temp3 = mPCalculateDensity(rand, this.diameter, this.hDens);
/*  98 */         int l5 = xChunk * 16 + temp1;
/*  99 */         int i9 = temp2;
/* 100 */         int k13 = zChunk * 16 + temp3;
/* 101 */         bODgenerateVein(this.worldObj, rand, l5, i9, k13, this.veinSi);
/*     */       } 
/*     */     }
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bODgenerateVein(World world, Random rand, int parX, int parY, int parZ, int xyz) {
/* 112 */     int posX = parX;
/* 113 */     int posY = parY;
/* 114 */     int posZ = parZ;
/*     */ 
/*     */ 
/*     */     
/* 118 */     int posX2 = 0;
/* 119 */     int posY2 = 0;
/* 120 */     int posZ2 = 0;
/* 121 */     int directionX = 0;
/* 122 */     int directionY = 0;
/* 123 */     int directionZ = 0;
/* 124 */     int directionX2 = 0;
/* 125 */     int directionY2 = 0;
/* 126 */     int directionZ2 = 0;
/*     */ 
/*     */ 
/*     */     
/* 130 */     int directionChange = 0;
/* 131 */     int directionChange2 = 0;
/* 132 */     int blocksToUse = xyz;
/* 133 */     int blocksToUse2 = 0;
/*     */     
/* 135 */     for (int blocksMade = 0; blocksMade <= blocksToUse; ) {
/*     */       
/* 137 */       blocksToUse2 = 1 + blocksToUse / 30;
/* 138 */       directionChange = rand.nextInt(6);
/* 139 */       directionX = rand.nextInt(2);
/* 140 */       directionY = rand.nextInt(2);
/* 141 */       directionZ = rand.nextInt(2);
/*     */       
/* 143 */       for (int blocksMade1 = 0; blocksMade1 <= blocksToUse2; ) {
/*     */         
/* 145 */         if (directionX == 0 && directionChange != 1) posX += rand.nextInt(2); 
/* 146 */         if (directionX == 1 && directionChange != 1) posX -= rand.nextInt(2); 
/* 147 */         if (directionY == 0 && directionChange != 2) posY += rand.nextInt(2); 
/* 148 */         if (directionY == 1 && directionChange != 2) posY -= rand.nextInt(2); 
/* 149 */         if (directionZ == 0 && directionChange != 3) posZ += rand.nextInt(2); 
/* 150 */         if (directionZ == 1 && directionChange != 3) posZ -= rand.nextInt(2); 
/* 151 */         if (rand.nextInt(4) == 0) {
/*     */           
/* 153 */           posX2 += rand.nextInt(2);
/* 154 */           posY2 += rand.nextInt(2);
/* 155 */           posZ2 += rand.nextInt(2);
/* 156 */           posX2 -= rand.nextInt(2);
/* 157 */           posY2 -= rand.nextInt(2);
/* 158 */           posZ2 -= rand.nextInt(2);
/*     */         } 
/* 160 */         if (rand.nextInt(3) == 0) {
/*     */           
/* 162 */           posX2 = posX;
/* 163 */           posY2 = posY;
/* 164 */           posZ2 = posZ;
/* 165 */           directionX2 = rand.nextInt(2);
/* 166 */           directionY2 = rand.nextInt(2);
/* 167 */           directionZ2 = rand.nextInt(2);
/* 168 */           directionChange2 = rand.nextInt(6);
/* 169 */           if (directionX2 == 0 && directionChange2 != 0) posX2 += rand.nextInt(2); 
/* 170 */           if (directionY2 == 0 && directionChange2 != 1) posY2 += rand.nextInt(2); 
/* 171 */           if (directionZ2 == 0 && directionChange2 != 2) posZ2 += rand.nextInt(2); 
/* 172 */           if (directionX2 == 1 && directionChange2 != 0) posX2 -= rand.nextInt(2); 
/* 173 */           if (directionY2 == 1 && directionChange2 != 1) posY2 -= rand.nextInt(2); 
/* 174 */           if (directionZ2 == 1 && directionChange2 != 2) posZ2 -= rand.nextInt(2);
/*     */           
/* 176 */           for (int blocksMade2 = 0; blocksMade2 <= 1 + blocksToUse2 / 5; ) {
/*     */             
/* 178 */             if (directionX2 == 0 && directionChange2 != 0) posX2 += rand.nextInt(2); 
/* 179 */             if (directionY2 == 0 && directionChange2 != 1) posY2 += rand.nextInt(2); 
/* 180 */             if (directionZ2 == 0 && directionChange2 != 2) posZ2 += rand.nextInt(2); 
/* 181 */             if (directionX2 == 1 && directionChange2 != 0) posX2 -= rand.nextInt(2); 
/* 182 */             if (directionY2 == 1 && directionChange2 != 1) posY2 -= rand.nextInt(2); 
/* 183 */             if (directionZ2 == 1 && directionChange2 != 2) posZ2 -= rand.nextInt(2); 
/* 184 */             int i = world.func_72805_g(posX, posY, posZ);
/* 185 */             boolean bool1 = (world.func_147439_a(posX, posY, posZ) == this.layerBlock);
/* 186 */             boolean bool2 = (i == this.layerMeta || this.layerMeta == -1);
/* 187 */             if (bool1 && bool2)
/* 188 */               world.func_147465_d(posX, posY, posZ, mPBlock, mPBlockMeta, 2); 
/* 189 */             blocksMade++;
/* 190 */             blocksMade1++;
/* 191 */             blocksMade2++;
/*     */           } 
/*     */         } 
/*     */         
/* 195 */         int m = world.func_72805_g(posX, posY, posZ);
/* 196 */         boolean isCorrectRockType = (world.func_147439_a(posX, posY, posZ) == this.layerBlock);
/* 197 */         boolean isCorrectMeta = (m == this.layerMeta || this.layerMeta == -1);
/* 198 */         if (isCorrectRockType && isCorrectMeta)
/* 199 */           world.func_147465_d(posX, posY, posZ, mPBlock, mPBlockMeta, 2); 
/* 200 */         blocksMade++;
/* 201 */         blocksMade1++;
/*     */       } 
/*     */       
/* 204 */       parX += rand.nextInt(3) - 1;
/* 205 */       parY += rand.nextInt(3) - 1;
/* 206 */       parZ += rand.nextInt(3) - 1;
/* 207 */       posX = parX;
/* 208 */       posY = parY;
/* 209 */       posZ = parZ;
/*     */     } 
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bODgenerate(World world, Random rand, int x, int y, int z, int xyz) {
/* 217 */     this.numberOfBlocks = xyz;
/* 218 */     float f = rand.nextFloat() * 3.1415927F;
/* 219 */     double d = ((x + 8) + MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F);
/* 220 */     double d1 = ((x + 8) - MathHelper.func_76126_a(f) * this.numberOfBlocks / 8.0F);
/* 221 */     double d2 = ((z + 8) + MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F);
/* 222 */     double d3 = ((z + 8) - MathHelper.func_76134_b(f) * this.numberOfBlocks / 8.0F);
/* 223 */     double d4 = (y + rand.nextInt(3) - 2);
/* 224 */     double d5 = (y + rand.nextInt(3) - 2);
/*     */     
/* 226 */     for (int l = 0; l <= this.numberOfBlocks; l++) {
/*     */       
/* 228 */       double d6 = d + (d1 - d) * l / this.numberOfBlocks;
/* 229 */       double d7 = d4 + (d5 - d4) * l / this.numberOfBlocks;
/* 230 */       double d8 = d2 + (d3 - d2) * l / this.numberOfBlocks;
/* 231 */       double d9 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
/* 232 */       double d10 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 233 */       double d11 = (MathHelper.func_76126_a(l * 3.1415927F / this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
/* 234 */       int i1 = MathHelper.func_76128_c(d6 - d10 / 2.0D);
/* 235 */       int j1 = MathHelper.func_76128_c(d7 - d11 / 2.0D);
/* 236 */       int k1 = MathHelper.func_76128_c(d8 - d10 / 2.0D);
/* 237 */       int l1 = MathHelper.func_76128_c(d6 + d10 / 2.0D);
/* 238 */       int i2 = MathHelper.func_76128_c(d7 + d11 / 2.0D);
/* 239 */       int j2 = MathHelper.func_76128_c(d8 + d10 / 2.0D);
/*     */       
/* 241 */       for (int xCoord = i1; xCoord <= l1; xCoord++) {
/*     */         
/* 243 */         double d12 = (xCoord + 0.5D - d6) / d10 / 2.0D;
/* 244 */         if (d12 * d12 < 1.0D)
/*     */         {
/* 246 */           for (int yCoord = j1; yCoord <= i2; yCoord++) {
/*     */             
/* 248 */             double d13 = (yCoord + 0.5D - d7) / d11 / 2.0D;
/* 249 */             if (d12 * d12 + d13 * d13 < 1.0D)
/*     */             {
/* 251 */               for (int zCoord = k1; zCoord <= j2; zCoord++) {
/*     */                 
/* 253 */                 double d14 = (zCoord + 0.5D - d8) / d10 / 2.0D;
/* 254 */                 int m = world.func_72805_g(xCoord, yCoord, zCoord);
/* 255 */                 boolean isCorrectRockType = (world.func_147439_a(xCoord, yCoord, zCoord) == this.layerBlock);
/* 256 */                 boolean isCorrectMeta = (m == this.layerMeta || this.layerMeta == -1);
/* 257 */                 if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && isCorrectRockType && isCorrectMeta)
/* 258 */                   world.func_147465_d(xCoord, yCoord, zCoord, mPBlock, mPBlockMeta, 2); 
/*     */               }  } 
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generate(World world, Random random, int x, int z, int min, int max, String n) {
/* 268 */     this.mPChunkX = x >> 4;
/* 269 */     this.mPChunkZ = z >> 4;
/* 270 */     mPBlock = this.minableBlock;
/* 271 */     mPBlockMeta = this.minableBlockMeta;
/* 272 */     this.worldObj = world;
/*     */     
/* 274 */     if (this.mPChunkX != mPPrevX || this.mPChunkZ != mPPrevZ || mPBlock != mPPrevBlock || (mPBlock == mPPrevBlock && mPBlockMeta != mPPrevMeta) || mPlayerBlock != mPPrevLayerBlock || mPlayerMeta != mPPrevLayerMeta) {
/*     */ 
/*     */ 
/*     */       
/* 278 */       mPPrevX = this.mPChunkX;
/* 279 */       mPPrevZ = this.mPChunkZ;
/* 280 */       mPPrevBlock = mPBlock;
/* 281 */       mPPrevMeta = mPBlockMeta;
/*     */       
/* 283 */       betterOreDistribution(this.mPChunkX, this.mPChunkZ, mPBlock, mPBlockMeta, min, max, random);
/*     */     } 
/* 285 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generateVein(World world, Random random, int x, int z, int min, int max, String n) {
/* 290 */     this.mPChunkX = x >> 4;
/* 291 */     this.mPChunkZ = z >> 4;
/* 292 */     mPBlock = this.minableBlock;
/* 293 */     mPBlockMeta = this.minableBlockMeta;
/* 294 */     this.worldObj = world;
/*     */     
/* 296 */     if (this.mPChunkX != mPPrevX || this.mPChunkZ != mPPrevZ || mPBlock != mPPrevBlock || (mPBlock == mPPrevBlock && mPBlockMeta != mPPrevMeta) || mPlayerBlock != mPPrevLayerBlock || mPlayerMeta != mPPrevLayerMeta) {
/*     */ 
/*     */ 
/*     */       
/* 300 */       mPPrevX = this.mPChunkX;
/* 301 */       mPPrevZ = this.mPChunkZ;
/* 302 */       mPPrevBlock = mPBlock;
/* 303 */       mPPrevMeta = mPBlockMeta;
/*     */       
/* 305 */       betterOreDistributionVein(this.mPChunkX, this.mPChunkZ, mPBlock, mPBlockMeta, min, max, random);
/*     */     } 
/* 307 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 313 */     return true;
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
/*     */   public int mPCalculateDensity(Random rand, int oreDist, float oreDens) {
/* 331 */     int lpCnt = 0;
/* 332 */     int dValPassInr = 0;
/* 333 */     int dValPass = 0;
/* 334 */     oreDens *= 0.01F;
/* 335 */     oreDens = oreDens * (oreDist / 2) + 1.0F;
/* 336 */     lpCnt = (int)oreDens;
/* 337 */     dValPassInr = (int)(oreDist / oreDens + 0.5F);
/* 338 */     dValPass = 0;
/* 339 */     while (lpCnt > 0) {
/*     */       
/* 341 */       dValPass += rand.nextInt(dValPassInr);
/* 342 */       lpCnt--;
/*     */     } 
/* 344 */     if (dValPass < 5) dValPass = 5; 
/* 345 */     if (dValPass > 128) dValPass = 128; 
/* 346 */     return dValPass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int mPCalculateDensityVert(Random rand, int oreDist, float oreDens, int min, int max) {
/* 352 */     int lpCnt = 0;
/* 353 */     int dValPassInr = 0;
/* 354 */     int dValPass = 0;
/* 355 */     oreDens *= 0.01F;
/* 356 */     oreDens = oreDens * (oreDist / 2) + 1.0F;
/* 357 */     lpCnt = (int)oreDens;
/* 358 */     dValPassInr = (int)(oreDist / oreDens + 0.5F);
/* 359 */     dValPass = min;
/* 360 */     while (lpCnt > 0) {
/*     */       
/* 362 */       dValPass += rand.nextInt(dValPassInr);
/* 363 */       lpCnt--;
/*     */     } 
/* 365 */     if (dValPass < min) dValPass = min; 
/* 366 */     if (dValPass > max) dValPass = max; 
/* 367 */     return dValPass;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenMinableTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */