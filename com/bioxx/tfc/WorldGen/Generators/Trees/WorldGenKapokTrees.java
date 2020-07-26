/*     */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenKapokTrees
/*     */   extends WorldGenerator
/*     */ {
/*  19 */   private static final byte[] OTHER_COORD_PAIRS = new byte[] { 2, 0, 0, 1, 2, 1 };
/*  20 */   private final Random rand = new Random();
/*     */   
/*     */   private World worldObj;
/*     */   
/*  24 */   private int[] basePos = new int[] { 0, 0, 0 };
/*     */   
/*     */   private int heightLimit;
/*     */   
/*     */   private int height;
/*     */   private static final double HEIGHT_ATTENUATION = 0.718D;
/*     */   private static final double BRANCH_SLOPE = 0.681D;
/*  31 */   private double scaleWidth = 3.0D;
/*  32 */   private double leafDensity = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private int trunkSize = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   private int heightLimitLimit = 35;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private int leafDistanceLimit = 4;
/*     */ 
/*     */   
/*     */   private int[][] leafNodes;
/*     */   
/*     */   private final int treeId;
/*     */ 
/*     */   
/*     */   public WorldGenKapokTrees(boolean par1, int id) {
/*  56 */     super(par1);
/*  57 */     this.treeId = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int checkBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger) {
/*     */     byte var8;
/*  66 */     int[] var3 = { 0, 0, 0 };
/*  67 */     byte var4 = 0;
/*     */     
/*     */     byte var5;
/*  70 */     for (var5 = 0; var4 < 3; var4 = (byte)(var4 + 1)) {
/*     */       
/*  72 */       var3[var4] = par2ArrayOfInteger[var4] - par1ArrayOfInteger[var4];
/*  73 */       if (Math.abs(var3[var4]) > Math.abs(var3[var5])) {
/*  74 */         var5 = var4;
/*     */       }
/*     */     } 
/*  77 */     if (var3[var5] == 0)
/*     */     {
/*  79 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*  83 */     byte var6 = OTHER_COORD_PAIRS[var5];
/*  84 */     byte var7 = OTHER_COORD_PAIRS[var5 + 3];
/*     */ 
/*     */     
/*  87 */     if (var3[var5] > 0) {
/*  88 */       var8 = 1;
/*     */     } else {
/*  90 */       var8 = -1;
/*     */     } 
/*  92 */     double var9 = var3[var6] / var3[var5];
/*  93 */     double var11 = var3[var7] / var3[var5];
/*  94 */     int[] var13 = { 0, 0, 0 };
/*  95 */     int var14 = 0;
/*     */     
/*     */     int var15;
/*  98 */     for (var15 = var3[var5] + var8; var14 != var15; var14 += var8) {
/*     */       
/* 100 */       var13[var5] = par1ArrayOfInteger[var5] + var14;
/* 101 */       var13[var6] = MathHelper.func_76128_c(par1ArrayOfInteger[var6] + var14 * var9);
/* 102 */       var13[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var14 * var11);
/* 103 */       Block var16 = this.worldObj.func_147439_a(var13[0], var13[1], var13[2]);
/* 104 */       if (!var16.isAir((IBlockAccess)this.worldObj, var13[0], var13[1], var13[2]) && (var16 != TFCBlocks.leaves || var16 != TFCBlocks.leaves2) && var16 != TFCBlocks.vine)
/*     */         break; 
/*     */     } 
/* 107 */     return (var14 == var15) ? -1 : Math.abs(var14);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 114 */     this.worldObj = par1World;
/* 115 */     long var6 = par2Random.nextLong();
/* 116 */     this.rand.setSeed(var6);
/* 117 */     this.basePos[0] = par3;
/* 118 */     this.basePos[1] = par4;
/* 119 */     this.basePos[2] = par5;
/*     */     
/* 121 */     if (this.heightLimit == 0) {
/* 122 */       this.heightLimit = 15 + this.rand.nextInt(this.heightLimitLimit / 2);
/*     */     }
/* 124 */     this.trunkSize = (this.heightLimit > 25) ? 2 : 1;
/*     */     
/* 126 */     if (!validTreeLocation())
/*     */     {
/* 128 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 132 */     generateLeafNodeList();
/* 133 */     generateBranchPoints();
/*     */     
/* 135 */     generateTrunk();
/* 136 */     generateLeafNodeBases();
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNode(int par1, int par2, int par3) {
/* 146 */     int var4 = par2;
/* 147 */     for (int var5 = par2 + this.leafDistanceLimit; var4 < var5; var4++) {
/*     */       
/* 149 */       float var6 = leafSize(var4 - par2);
/* 150 */       genTreeLayer(par1, var4, par3, var6, (byte)1, TFCBlocks.leaves);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateBranchPoints() {
/* 156 */     double branchSlope = 0.0D;
/* 157 */     int branchRange = this.height / 3;
/* 158 */     int branchLength = 0;
/*     */     
/* 160 */     for (int j1 = this.basePos[1] + this.height - branchRange; j1 < this.basePos[1] + this.height; j1++) {
/*     */       
/* 162 */       branchSlope = 0.5D;
/* 163 */       double x = this.rand.nextFloat();
/* 164 */       double z = 1.0D - x;
/* 165 */       x *= this.rand.nextBoolean() ? 1.0D : -1.0D;
/* 166 */       z *= this.rand.nextBoolean() ? 1.0D : -1.0D;
/* 167 */       branchLength = (int)((1.5D - branchSlope) * 5.0D) + this.rand.nextInt(4) + 3;
/* 168 */       if (this.trunkSize == 1) branchLength = (int)(branchLength * 0.66D); 
/* 169 */       x *= branchLength;
/* 170 */       z *= branchLength;
/* 171 */       double y = branchLength * branchSlope;
/* 172 */       int[] branchDestination = { (int)(this.basePos[0] + x), (int)(j1 + y), (int)(this.basePos[2] + z) };
/* 173 */       int[] branchOrigin = { this.basePos[0], j1, this.basePos[2] };
/* 174 */       placeBlockLineCurved(branchOrigin, branchDestination, TFCBlocks.logNatural);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNodeBases() {
/* 183 */     int var1 = 0;
/* 184 */     int var2 = this.leafNodes.length;
/*     */     
/* 186 */     for (int[] var3 = { this.basePos[0], this.basePos[1], this.basePos[2] }; var1 < var2; var1++) {
/*     */       
/* 188 */       int[] var4 = this.leafNodes[var1];
/*     */       
/* 190 */       var3[1] = var4[3];
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
/*     */   private void generateLeafNodeList() {
/* 204 */     this.height = (int)(this.heightLimit * 0.718D);
/*     */     
/* 206 */     if (this.height >= this.heightLimit) {
/* 207 */       this.height = this.heightLimit - 1;
/*     */     }
/* 209 */     int var1 = (int)(1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));
/* 210 */     if (var1 < 1) {
/* 211 */       var1 = 1;
/*     */     }
/* 213 */     int[][] var2 = new int[var1 * this.heightLimit][4];
/* 214 */     int var3 = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
/* 215 */     int var4 = 1;
/* 216 */     int var5 = this.basePos[1] + this.height;
/* 217 */     int var6 = var3 - this.basePos[1];
/* 218 */     var2[0][0] = this.basePos[0];
/* 219 */     var2[0][1] = var3;
/* 220 */     var2[0][2] = this.basePos[2];
/* 221 */     var2[0][3] = var5;
/* 222 */     var3--;
/*     */     
/* 224 */     while (var6 >= 0) {
/*     */       
/* 226 */       int var7 = 0;
/* 227 */       float var8 = layerSize(var6);
/*     */       
/* 229 */       if (var8 < 0.0F) {
/*     */         
/* 231 */         var3--;
/* 232 */         var6--;
/*     */         
/*     */         continue;
/*     */       } 
/* 236 */       for (double var9 = 0.5D; var7 < var1; var7++) {
/*     */         
/* 238 */         double var11 = this.scaleWidth * var8 * (this.rand.nextFloat() + 0.328D);
/* 239 */         double var13 = this.rand.nextFloat() * 2.0D * Math.PI;
/* 240 */         int var15 = MathHelper.func_76128_c(var11 * Math.sin(var13) + this.basePos[0] + var9);
/* 241 */         int var16 = MathHelper.func_76128_c(var11 * Math.cos(var13) + this.basePos[2] + var9);
/* 242 */         int[] var17 = { var15, var3, var16 };
/* 243 */         int[] var18 = { var15, var3 + this.leafDistanceLimit, var16 };
/*     */         
/* 245 */         if (checkBlockLine(var17, var18) == -1) {
/*     */           
/* 247 */           int[] var19 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 248 */           double var20 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - var17[0]), 2.0D) + Math.pow(Math.abs(this.basePos[2] - var17[2]), 2.0D));
/* 249 */           double var22 = var20 * 0.681D;
/*     */           
/* 251 */           if (var17[1] - var22 > var5) {
/* 252 */             var19[1] = var5;
/*     */           } else {
/* 254 */             var19[1] = (int)(var17[1] - var22);
/*     */           } 
/* 256 */           if (checkBlockLine(var19, var17) == -1) {
/*     */             
/* 258 */             var2[var4][0] = var15;
/* 259 */             var2[var4][1] = var3;
/* 260 */             var2[var4][2] = var16;
/* 261 */             var2[var4][3] = var19[1];
/* 262 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } 
/* 266 */       var3--;
/* 267 */       var6--;
/*     */     } 
/*     */     
/* 270 */     this.leafNodes = new int[var4][4];
/* 271 */     System.arraycopy(var2, 0, this.leafNodes, 0, var4);
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
/*     */   private void generateTrunk() {
/* 303 */     int var1 = this.basePos[0];
/* 304 */     int var2 = this.basePos[1];
/* 305 */     int var3 = this.basePos[1] + this.height;
/* 306 */     int var4 = this.basePos[2];
/* 307 */     int[] var5 = { var1, var2, var4 };
/* 308 */     int[] var6 = { var1, var3, var4 };
/* 309 */     placeBlockLine(var5, var6, TFCBlocks.logNatural);
/*     */     
/* 311 */     if (this.trunkSize == 2) {
/*     */       
/* 313 */       var5[0] = var5[0] + 1;
/* 314 */       var6[0] = var6[0] + 1;
/* 315 */       placeBlockLine(var5, var6, TFCBlocks.logNatural);
/* 316 */       var5[2] = var5[2] + 1;
/* 317 */       var6[2] = var6[2] + 1;
/* 318 */       placeBlockLine(var5, var6, TFCBlocks.logNatural);
/* 319 */       var5[0] = var5[0] + -1;
/* 320 */       var6[0] = var6[0] + -1;
/* 321 */       placeBlockLine(var5, var6, TFCBlocks.logNatural);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void genTreeLayer(int par1, int par2, int par3, float par4, byte par5, Block b) {
/* 327 */     int var7 = (int)(par4 + 0.618D);
/* 328 */     byte var8 = OTHER_COORD_PAIRS[par5];
/* 329 */     byte var9 = OTHER_COORD_PAIRS[par5 + 3];
/* 330 */     int[] var10 = { par1, par2, par3 };
/* 331 */     int[] var11 = { 0, 0, 0 };
/* 332 */     int var12 = -var7;
/* 333 */     int var13 = -var7;
/*     */     
/* 335 */     for (var11[par5] = var10[par5]; var12 <= var7; var12++) {
/*     */       
/* 337 */       var11[var8] = var10[var8] + var12;
/* 338 */       var13 = -var7;
/*     */       
/* 340 */       while (var13 <= var7) {
/*     */         
/* 342 */         double var15 = Math.sqrt(Math.pow(Math.abs(var12) + 0.5D, 2.0D) + Math.pow(Math.abs(var13) + 0.5D, 2.0D));
/*     */         
/* 344 */         if (var15 > par4) {
/*     */           
/* 346 */           var13++;
/*     */           
/*     */           continue;
/*     */         } 
/* 350 */         var11[var9] = var10[var9] + var13;
/* 351 */         Block var14 = this.worldObj.func_147439_a(var11[0], var11[1], var11[2]);
/*     */         
/* 353 */         if (!var14.isAir((IBlockAccess)this.worldObj, var11[0], var11[1], var11[2]) && (var14 != TFCBlocks.leaves || var14 != TFCBlocks.leaves2) && var14 != TFCBlocks.vine) {
/*     */           
/* 355 */           var13++;
/*     */           
/*     */           continue;
/*     */         } 
/* 359 */         func_150516_a(this.worldObj, var11[0], var11[1], var11[2], b, this.treeId);
/* 360 */         if (this.rand.nextInt(8) > 0) {
/*     */           
/* 362 */           int side = this.rand.nextInt(4);
/* 363 */           if (side == 0 && this.worldObj.func_147437_c(var11[0] - 1, var11[1], var11[2])) {
/*     */             
/* 365 */             func_150516_a(this.worldObj, var11[0] - 1, var11[1], var11[2], TFCBlocks.vine, 8);
/*     */           }
/* 367 */           else if (side == 1 && this.worldObj.func_147437_c(var11[0], var11[1], var11[2] - 1)) {
/*     */             
/* 369 */             func_150516_a(this.worldObj, var11[0], var11[1], var11[2] - 1, TFCBlocks.vine, 1);
/*     */           }
/* 371 */           else if (side == 2 && this.worldObj.func_147437_c(var11[0] + 1, var11[1], var11[2])) {
/*     */             
/* 373 */             func_150516_a(this.worldObj, var11[0] + 1, var11[1], var11[2], TFCBlocks.vine, 2);
/*     */           }
/* 375 */           else if (side == 3 && this.worldObj.func_147437_c(var11[0], var11[1], var11[2] + 1)) {
/*     */             
/* 377 */             func_150516_a(this.worldObj, var11[0], var11[1], var11[2] + 1, TFCBlocks.vine, 4);
/*     */           } 
/*     */         } 
/* 380 */         var13++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float layerSize(int par1) {
/*     */     float var4;
/* 392 */     if (par1 < this.heightLimit * 0.3D)
/*     */     {
/* 394 */       return -1.618F;
/*     */     }
/*     */ 
/*     */     
/* 398 */     float var2 = this.heightLimit / 2.0F;
/* 399 */     float var3 = this.heightLimit / 2.0F - par1;
/*     */ 
/*     */     
/* 402 */     if (var3 == 0.0F) {
/* 403 */       var4 = var2;
/* 404 */     } else if (Math.abs(var3) >= var2) {
/* 405 */       var4 = 0.0F;
/*     */     } else {
/* 407 */       var4 = (float)Math.sqrt(Math.pow(Math.abs(var2), 2.0D) - Math.pow(Math.abs(var3), 2.0D));
/*     */     } 
/* 409 */     var4 *= 0.5F;
/* 410 */     return var4;
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
/*     */   private float leafSize(int par1) {
/* 424 */     return (par1 >= 0 && par1 < this.leafDistanceLimit) ? ((par1 != 0 && par1 != this.leafDistanceLimit - 1) ? 4.0F : 3.0F) : -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void placeBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, Block par3) {
/* 432 */     int[] var4 = { 0, 0, 0 };
/* 433 */     byte var5 = 0;
/*     */     
/*     */     byte var6;
/* 436 */     for (var6 = 0; var5 < 3; var5 = (byte)(var5 + 1)) {
/*     */       
/* 438 */       var4[var5] = par2ArrayOfInteger[var5] - par1ArrayOfInteger[var5];
/* 439 */       if (Math.abs(var4[var5]) > Math.abs(var4[var6])) {
/* 440 */         var6 = var5;
/*     */       }
/*     */     } 
/* 443 */     if (var4[var6] != 0) {
/*     */       
/* 445 */       byte var9, var7 = OTHER_COORD_PAIRS[var6];
/* 446 */       byte var8 = OTHER_COORD_PAIRS[var6 + 3];
/*     */ 
/*     */       
/* 449 */       if (var4[var6] > 0) {
/* 450 */         var9 = 1;
/*     */       } else {
/* 452 */         var9 = -1;
/*     */       } 
/* 454 */       double var10 = var4[var7] / var4[var6];
/* 455 */       double var12 = var4[var8] / var4[var6];
/* 456 */       int[] var14 = { 0, 0, 0 };
/* 457 */       int var15 = 0;
/*     */       
/* 459 */       for (int var16 = var4[var6] + var9; var15 != var16; var15 += var9) {
/*     */         
/* 461 */         var14[var6] = MathHelper.func_76128_c((par1ArrayOfInteger[var6] + var15) + 0.5D);
/* 462 */         var14[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var15 * var10 + 0.5D);
/* 463 */         var14[var8] = MathHelper.func_76128_c(par1ArrayOfInteger[var8] + var15 * var12 + 0.5D);
/* 464 */         if (this.worldObj.func_147437_c(var14[0], var14[1], var14[2]) || this.worldObj.func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves || this.worldObj
/* 465 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves2)
/*     */         {
/* 467 */           func_150516_a(this.worldObj, var14[0], var14[1], var14[2], par3, this.treeId);
/*     */         }
/*     */       } 
/* 470 */       if (par1ArrayOfInteger[0] == par2ArrayOfInteger[0] && par1ArrayOfInteger[2] == par2ArrayOfInteger[2] && par1ArrayOfInteger[1] < par2ArrayOfInteger[1])
/*     */       {
/* 472 */         for (int i = -1; i < 2; i++) {
/*     */           
/* 474 */           for (int k = -1; k < 2; k++) {
/*     */             
/* 476 */             if (this.rand.nextBoolean() && par1ArrayOfInteger[1] > 1 && 
/* 477 */               Math.abs(i) != Math.abs(k) && 
/* 478 */               !this.worldObj.func_147437_c(i + par1ArrayOfInteger[0], par1ArrayOfInteger[1] - 1, par1ArrayOfInteger[2] + k))
/*     */             {
/* 480 */               func_150516_a(this.worldObj, i + par1ArrayOfInteger[0], par1ArrayOfInteger[1], par1ArrayOfInteger[2] + k, par3, this.treeId);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void placeBlockLinePrimary(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, Block par3) {
/* 490 */     int[] var4 = { 0, 0, 0 };
/* 491 */     byte var5 = 0;
/*     */     
/*     */     byte var6;
/* 494 */     for (var6 = 0; var5 < 3; var5 = (byte)(var5 + 1)) {
/*     */       
/* 496 */       var4[var5] = par2ArrayOfInteger[var5] - par1ArrayOfInteger[var5];
/* 497 */       if (Math.abs(var4[var5]) > Math.abs(var4[var6])) {
/* 498 */         var6 = var5;
/*     */       }
/*     */     } 
/* 501 */     if (var4[var6] != 0) {
/*     */       
/* 503 */       byte var9, var7 = OTHER_COORD_PAIRS[var6];
/* 504 */       byte var8 = OTHER_COORD_PAIRS[var6 + 3];
/*     */ 
/*     */       
/* 507 */       if (var4[var6] > 0) {
/* 508 */         var9 = 1;
/*     */       } else {
/* 510 */         var9 = -1;
/*     */       } 
/* 512 */       double var10 = var4[var7] / var4[var6];
/* 513 */       double var12 = var4[var8] / var4[var6];
/* 514 */       int[] var14 = { 0, 0, 0 };
/* 515 */       int var15 = 0;
/*     */       
/* 517 */       for (int var16 = var4[var6] + var9; var15 != var16; var15 += var9) {
/*     */         
/* 519 */         var14[var6] = MathHelper.func_76128_c((par1ArrayOfInteger[var6] + var15) + 0.5D);
/* 520 */         var14[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var15 * var10 + 0.5D);
/* 521 */         var14[var8] = MathHelper.func_76128_c(par1ArrayOfInteger[var8] + var15 * var12 + 0.5D);
/* 522 */         if (this.worldObj.func_147437_c(var14[0], var14[1], var14[2]) || this.worldObj
/* 523 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves || this.worldObj
/* 524 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves2) {
/*     */           
/* 526 */           if (this.rand.nextInt(3) == 0 && Math.abs(var15) > 2) {
/*     */             
/* 528 */             int[] currentBlock = { var14[0], var14[1], var14[2] };
/* 529 */             int distance = 5;
/* 530 */             float x = this.rand.nextFloat();
/* 531 */             float y = Math.min(this.rand.nextFloat(), 1.0F - x);
/* 532 */             float z = 1.0F - x - y;
/*     */ 
/*     */ 
/*     */             
/* 536 */             int[] destinationBlock = { var14[0] + (int)(distance * x * (this.rand.nextBoolean() ? true : -1)), var14[1] + (int)(distance * y * (this.rand.nextBoolean() ? true : -1)), var14[2] + (int)(distance * z * (this.rand.nextBoolean() ? true : -1)) };
/* 537 */             placeBlockLineSecondary(currentBlock, destinationBlock, par3);
/*     */           } 
/* 539 */           func_150516_a(this.worldObj, var14[0], var14[1], var14[2], par3, this.treeId);
/*     */         } 
/*     */       } 
/* 542 */       generateLeafNode(par2ArrayOfInteger[0], par2ArrayOfInteger[1], par2ArrayOfInteger[2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void placeBlockLineCurved(int[] startingPos, int[] endingPos, Block par3) {
/* 548 */     int[] midPointRaised = { (endingPos[0] - startingPos[0]) / 2, (int)((endingPos[1] - startingPos[1]) / 1.5D), (endingPos[1] - startingPos[1]) / 2 };
/* 549 */     int[] newDest = { startingPos[0] + midPointRaised[0], startingPos[1] + midPointRaised[1], startingPos[2] + midPointRaised[2] };
/* 550 */     placeBlockLinePrimary(startingPos, newDest, par3);
/* 551 */     placeBlockLinePrimary(newDest, endingPos, par3);
/*     */   }
/*     */ 
/*     */   
/*     */   private void placeBlockLineSecondary(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, Block par3) {
/* 556 */     int[] var4 = { 0, 0, 0 };
/* 557 */     byte var5 = 0;
/*     */     
/*     */     byte var6;
/* 560 */     for (var6 = 0; var5 < 3; var5 = (byte)(var5 + 1)) {
/*     */       
/* 562 */       var4[var5] = par2ArrayOfInteger[var5] - par1ArrayOfInteger[var5];
/* 563 */       if (Math.abs(var4[var5]) > Math.abs(var4[var6])) {
/* 564 */         var6 = var5;
/*     */       }
/*     */     } 
/* 567 */     if (var4[var6] != 0) {
/*     */       
/* 569 */       byte var9, var7 = OTHER_COORD_PAIRS[var6];
/* 570 */       byte var8 = OTHER_COORD_PAIRS[var6 + 3];
/*     */ 
/*     */       
/* 573 */       if (var4[var6] > 0) {
/* 574 */         var9 = 1;
/*     */       } else {
/* 576 */         var9 = -1;
/*     */       } 
/* 578 */       double var10 = var4[var7] / var4[var6];
/* 579 */       double var12 = var4[var8] / var4[var6];
/* 580 */       int[] var14 = { 0, 0, 0 };
/* 581 */       int var15 = 0;
/*     */       
/* 583 */       for (int var16 = var4[var6] + var9; var15 != var16; var15 += var9) {
/*     */         
/* 585 */         var14[var6] = MathHelper.func_76128_c((par1ArrayOfInteger[var6] + var15) + 0.5D);
/* 586 */         var14[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var15 * var10 + 0.5D);
/* 587 */         var14[var8] = MathHelper.func_76128_c(par1ArrayOfInteger[var8] + var15 * var12 + 0.5D);
/* 588 */         if (this.worldObj.func_147437_c(var14[0], var14[1], var14[2]) || this.worldObj
/* 589 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves || this.worldObj
/* 590 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves2)
/*     */         {
/* 592 */           func_150516_a(this.worldObj, var14[0], var14[1], var14[2], par3, this.treeId);
/*     */         }
/*     */       } 
/* 595 */       generateLeafNode(par2ArrayOfInteger[0], par2ArrayOfInteger[1] - 1, par2ArrayOfInteger[2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76487_a(double par1, double par3, double par5) {
/* 605 */     this.heightLimitLimit = (int)(par1 * 35.0D);
/*     */     
/* 607 */     if (par1 > 0.5D) {
/* 608 */       this.leafDistanceLimit = 5;
/*     */     }
/* 610 */     this.scaleWidth = par3;
/* 611 */     this.leafDensity = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validTreeLocation() {
/* 620 */     int[] var1 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 621 */     int[] var2 = { this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2] };
/* 622 */     Block var3 = this.worldObj.func_147439_a(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
/*     */     
/* 624 */     if (!TFC_Core.isSoil(var3))
/*     */     {
/* 626 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 630 */     int var4 = checkBlockLine(var1, var2);
/*     */     
/* 632 */     if (var4 == -1)
/*     */     {
/* 634 */       return true;
/*     */     }
/* 636 */     if (var4 < 6)
/*     */     {
/* 638 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 642 */     this.heightLimit = var4;
/* 643 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenKapokTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */