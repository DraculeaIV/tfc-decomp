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
/*     */ public class WorldGenAcaciaKoaTrees
/*     */   extends WorldGenerator
/*     */ {
/*  19 */   private static final byte[] OTHER_COORD_PAIRS = new byte[] { 2, 0, 0, 1, 2, 1 };
/*     */   
/*  21 */   private final Random rand = new Random();
/*     */   
/*     */   private World worldObj;
/*     */   
/*  25 */   private int[] basePos = new int[] { 0, 0, 0 };
/*     */   
/*     */   private int heightLimit;
/*     */   
/*     */   private int height;
/*     */   private static final double HEIGHT_ATTENUATION = 0.618D;
/*     */   private static final double BRANCH_SLOPE = 0.681D;
/*  32 */   private double scaleWidth = 3.0D;
/*  33 */   private double leafDensity = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private int heightLimitLimit = 24;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   private int leafDistanceLimit = 4;
/*     */ 
/*     */   
/*     */   private int[][] leafNodes;
/*     */   
/*     */   private final int treeId;
/*     */ 
/*     */   
/*     */   public WorldGenAcaciaKoaTrees(boolean par1, int id) {
/*  57 */     super(par1);
/*  58 */     this.treeId = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int checkBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger) {
/*     */     byte var8;
/*  67 */     int[] var3 = { 0, 0, 0 };
/*  68 */     byte var4 = 0;
/*     */     
/*     */     byte var5;
/*  71 */     for (var5 = 0; var4 < 3; var4 = (byte)(var4 + 1)) {
/*     */       
/*  73 */       var3[var4] = par2ArrayOfInteger[var4] - par1ArrayOfInteger[var4];
/*  74 */       if (Math.abs(var3[var4]) > Math.abs(var3[var5])) {
/*  75 */         var5 = var4;
/*     */       }
/*     */     } 
/*  78 */     if (var3[var5] == 0)
/*     */     {
/*  80 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*  84 */     byte var6 = OTHER_COORD_PAIRS[var5];
/*  85 */     byte var7 = OTHER_COORD_PAIRS[var5 + 3];
/*     */ 
/*     */     
/*  88 */     if (var3[var5] > 0) {
/*  89 */       var8 = 1;
/*     */     } else {
/*  91 */       var8 = -1;
/*     */     } 
/*  93 */     double var9 = var3[var6] / var3[var5];
/*  94 */     double var11 = var3[var7] / var3[var5];
/*  95 */     int[] var13 = { 0, 0, 0 };
/*  96 */     int var14 = 0;
/*     */     
/*     */     int var15;
/*  99 */     for (var15 = var3[var5] + var8; var14 != var15; var14 += var8) {
/*     */       
/* 101 */       var13[var5] = par1ArrayOfInteger[var5] + var14;
/* 102 */       var13[var6] = MathHelper.func_76128_c(par1ArrayOfInteger[var6] + var14 * var9);
/* 103 */       var13[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var14 * var11);
/* 104 */       Block var16 = this.worldObj.func_147439_a(var13[0], var13[1], var13[2]);
/* 105 */       if (!var16.isAir((IBlockAccess)this.worldObj, var13[0], var13[1], var13[2]) && var16 != TFCBlocks.vine && (var16 != TFCBlocks.leaves || var16 != TFCBlocks.leaves2)) {
/*     */         break;
/*     */       }
/*     */     } 
/* 109 */     return (var14 == var15) ? -1 : Math.abs(var14);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 116 */     this.worldObj = par1World;
/* 117 */     long var6 = par2Random.nextLong();
/* 118 */     this.rand.setSeed(var6);
/* 119 */     this.basePos[0] = par3;
/* 120 */     this.basePos[1] = par4;
/* 121 */     this.basePos[2] = par5;
/*     */     
/* 123 */     this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit / 2) + this.heightLimitLimit / 2;
/*     */     
/* 125 */     if (!validTreeLocation())
/*     */     {
/* 127 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 131 */     generateLeafNodeList();
/* 132 */     generateLeaves();
/* 133 */     generateTrunk();
/* 134 */     generateLeafNodeBases();
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNode(int par1, int par2, int par3) {
/* 144 */     int var4 = par2;
/* 145 */     for (int var5 = par2 + this.leafDistanceLimit; var4 < var5; var4++) {
/*     */       
/* 147 */       float var6 = leafSize(var4 - par2);
/* 148 */       genTreeLayer(par1, var4, par3, var6, (byte)1, TFCBlocks.leaves2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNodeBases() {
/* 157 */     int var1 = 0;
/* 158 */     int var2 = this.leafNodes.length;
/*     */     
/* 160 */     for (int[] var3 = { this.basePos[0], this.basePos[1], this.basePos[2] }; var1 < var2; var1++) {
/*     */       
/* 162 */       int[] var4 = this.leafNodes[var1];
/* 163 */       int[] var5 = { var4[0], var4[1], var4[2] };
/* 164 */       var3[1] = var4[3];
/* 165 */       int var6 = var3[1] - this.basePos[1];
/* 166 */       if (leafNodeNeedsBase(var6)) {
/* 167 */         placeBlockLine(var3, var5, TFCBlocks.logNatural2);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNodeList() {
/* 176 */     this.height = (int)(this.heightLimit * 0.618D);
/* 177 */     if (this.height >= this.heightLimit) {
/* 178 */       this.height = this.heightLimit - 1;
/*     */     }
/* 180 */     int var1 = (int)(1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));
/* 181 */     if (var1 < 1) {
/* 182 */       var1 = 1;
/*     */     }
/* 184 */     int[][] var2 = new int[var1 * this.heightLimit][4];
/* 185 */     int var3 = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
/* 186 */     int var4 = 1;
/* 187 */     int var5 = this.basePos[1] + this.height;
/* 188 */     int var6 = var3 - this.basePos[1];
/* 189 */     var2[0][0] = this.basePos[0];
/* 190 */     var2[0][1] = var3;
/* 191 */     var2[0][2] = this.basePos[2];
/* 192 */     var2[0][3] = var5;
/* 193 */     var3--;
/*     */     
/* 195 */     while (var6 >= 0) {
/*     */       
/* 197 */       int var7 = 0;
/* 198 */       float var8 = layerSize(var6);
/*     */       
/* 200 */       if (var8 < 0.0F) {
/*     */         
/* 202 */         var3--;
/* 203 */         var6--;
/*     */         
/*     */         continue;
/*     */       } 
/* 207 */       for (double var9 = 0.5D; var7 < var1; var7++) {
/*     */         
/* 209 */         double var11 = this.scaleWidth * var8 * (this.rand.nextFloat() + 0.328D);
/* 210 */         double var13 = this.rand.nextFloat() * 2.0D * Math.PI;
/* 211 */         int var15 = MathHelper.func_76128_c(var11 * Math.sin(var13) + this.basePos[0] + var9);
/* 212 */         int var16 = MathHelper.func_76128_c(var11 * Math.cos(var13) + this.basePos[2] + var9);
/* 213 */         int[] var17 = { var15, var3, var16 };
/* 214 */         int[] var18 = { var15, var3 + this.leafDistanceLimit, var16 };
/*     */         
/* 216 */         if (checkBlockLine(var17, var18) == -1) {
/*     */           
/* 218 */           int[] var19 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 219 */           double var20 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - var17[0]), 2.0D) + Math.pow(Math.abs(this.basePos[2] - var17[2]), 2.0D));
/* 220 */           double var22 = var20 * 0.681D;
/*     */           
/* 222 */           if (var17[1] - var22 > var5) {
/* 223 */             var19[1] = var5;
/*     */           } else {
/* 225 */             var19[1] = (int)(var17[1] - var22);
/*     */           } 
/* 227 */           if (checkBlockLine(var19, var17) == -1) {
/*     */             
/* 229 */             var2[var4][0] = var15;
/* 230 */             var2[var4][1] = var3;
/* 231 */             var2[var4][2] = var16;
/* 232 */             var2[var4][3] = var19[1];
/* 233 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } 
/* 237 */       var3--;
/* 238 */       var6--;
/*     */     } 
/*     */     
/* 241 */     this.leafNodes = new int[var4][4];
/* 242 */     System.arraycopy(var2, 0, this.leafNodes, 0, var4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeaves() {
/* 250 */     int var1 = 0;
/*     */     int var2;
/* 252 */     for (var2 = this.leafNodes.length; var1 < var2; var1++) {
/*     */       
/* 254 */       int var3 = this.leafNodes[var1][0];
/* 255 */       int var4 = this.leafNodes[var1][1];
/* 256 */       int var5 = this.leafNodes[var1][2];
/* 257 */       generateLeafNode(var3, var4, var5);
/*     */     } 
/*     */     
/* 260 */     var1 = 0;
/* 261 */     for (var2 = this.leafNodes.length; var1 < var2; var1++) {
/*     */       
/* 263 */       int[] trunkBottom = { this.basePos[0], this.basePos[1] + this.height, this.basePos[2] };
/* 264 */       int[] node = { this.leafNodes[var1][0], this.leafNodes[var1][1] + 2, this.leafNodes[var1][2] };
/* 265 */       placeBlockLine(trunkBottom, node, TFCBlocks.logNatural2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateTrunk() {
/* 275 */     int var1 = this.basePos[0];
/* 276 */     int var2 = this.basePos[1];
/* 277 */     int var3 = this.basePos[1] + this.height;
/* 278 */     int var4 = this.basePos[2];
/* 279 */     int[] var5 = { var1, var2, var4 };
/* 280 */     int[] var6 = { var1, var3, var4 };
/* 281 */     placeBlockLine(var5, var6, TFCBlocks.logNatural2);
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
/*     */   private void genTreeLayer(int par1, int par2, int par3, float par4, byte par5, Block par6) {
/* 299 */     int var7 = (int)(par4 + 0.618D);
/* 300 */     byte var8 = OTHER_COORD_PAIRS[par5];
/* 301 */     byte var9 = OTHER_COORD_PAIRS[par5 + 3];
/* 302 */     int[] var10 = { par1, par2, par3 };
/* 303 */     int[] var11 = { 0, 0, 0 };
/* 304 */     int var12 = -var7;
/* 305 */     int var13 = -var7;
/*     */     
/* 307 */     for (var11[par5] = var10[par5]; var12 <= var7; var12++) {
/*     */       
/* 309 */       var11[var8] = var10[var8] + var12;
/* 310 */       var13 = -var7;
/*     */       
/* 312 */       while (var13 <= var7) {
/*     */         
/* 314 */         double var15 = Math.sqrt(Math.pow(Math.abs(var12) + 0.5D, 2.0D) + Math.pow(Math.abs(var13) + 0.5D, 2.0D));
/*     */         
/* 316 */         if (var15 > par4) {
/*     */           
/* 318 */           var13++;
/*     */           
/*     */           continue;
/*     */         } 
/* 322 */         var11[var9] = var10[var9] + var13;
/* 323 */         Block var14 = this.worldObj.func_147439_a(var11[0], var11[1], var11[2]);
/*     */         
/* 325 */         if (!var14.isAir((IBlockAccess)this.worldObj, var11[0], var11[1], var11[2]) && (var14 != TFCBlocks.leaves || var14 != TFCBlocks.leaves2)) {
/*     */           
/* 327 */           var13++;
/*     */           
/*     */           continue;
/*     */         } 
/* 331 */         func_150516_a(this.worldObj, var11[0], var11[1], var11[2], par6, this.treeId);
/* 332 */         var13++;
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
/* 344 */     if (par1 < this.heightLimit * 0.3D)
/*     */     {
/* 346 */       return -1.618F;
/*     */     }
/*     */ 
/*     */     
/* 350 */     float var2 = this.heightLimit / 2.0F;
/* 351 */     float var3 = this.heightLimit / 2.0F - par1;
/*     */ 
/*     */     
/* 354 */     if (var3 == 0.0F) {
/* 355 */       var4 = var2;
/* 356 */     } else if (Math.abs(var3) >= var2) {
/* 357 */       var4 = 0.0F;
/*     */     } else {
/* 359 */       var4 = (float)Math.sqrt(Math.pow(Math.abs(var2), 2.0D) - Math.pow(Math.abs(var3), 2.0D));
/*     */     } 
/* 361 */     var4 *= 0.5F;
/* 362 */     return var4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean leafNodeNeedsBase(int par1) {
/* 371 */     return (par1 >= this.leafDistanceLimit);
/*     */   }
/*     */ 
/*     */   
/*     */   private float leafSize(int par1) {
/* 376 */     return (par1 >= 0 && par1 < this.leafDistanceLimit) ? ((par1 != 0 && par1 != this.leafDistanceLimit - 1) ? 3.0F : 2.0F) : -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void placeBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger, Block par3) {
/* 384 */     int[] var4 = { 0, 0, 0 };
/* 385 */     byte var5 = 0;
/*     */     
/*     */     byte var6;
/* 388 */     for (var6 = 0; var5 < 3; var5 = (byte)(var5 + 1)) {
/*     */       
/* 390 */       var4[var5] = par2ArrayOfInteger[var5] - par1ArrayOfInteger[var5];
/* 391 */       if (Math.abs(var4[var5]) > Math.abs(var4[var6])) {
/* 392 */         var6 = var5;
/*     */       }
/*     */     } 
/* 395 */     if (var4[var6] != 0) {
/*     */       
/* 397 */       byte var9, var7 = OTHER_COORD_PAIRS[var6];
/* 398 */       byte var8 = OTHER_COORD_PAIRS[var6 + 3];
/*     */ 
/*     */       
/* 401 */       if (var4[var6] > 0) {
/* 402 */         var9 = 1;
/*     */       } else {
/* 404 */         var9 = -1;
/*     */       } 
/* 406 */       double var10 = var4[var7] / var4[var6];
/* 407 */       double var12 = var4[var8] / var4[var6];
/* 408 */       int[] var14 = { 0, 0, 0 };
/* 409 */       int var15 = 0;
/*     */       
/* 411 */       for (int var16 = var4[var6] + var9; var15 != var16; var15 += var9) {
/*     */         
/* 413 */         var14[var6] = MathHelper.func_76128_c((par1ArrayOfInteger[var6] + var15) + 0.5D);
/* 414 */         var14[var7] = MathHelper.func_76128_c(par1ArrayOfInteger[var7] + var15 * var10 + 0.5D);
/* 415 */         var14[var8] = MathHelper.func_76128_c(par1ArrayOfInteger[var8] + var15 * var12 + 0.5D);
/* 416 */         if (this.worldObj.func_147437_c(var14[0], var14[1], var14[2]) || this.worldObj
/* 417 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves || this.worldObj
/* 418 */           .func_147439_a(var14[0], var14[1], var14[2]) == TFCBlocks.leaves2)
/*     */         {
/* 420 */           func_150516_a(this.worldObj, var14[0], var14[1], var14[2], par3, this.treeId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76487_a(double par1, double par3, double par5) {
/* 432 */     this.heightLimitLimit = (int)(par1 * 12.0D);
/* 433 */     if (par1 > 0.5D)
/* 434 */       this.leafDistanceLimit = 5; 
/* 435 */     this.scaleWidth = par3;
/* 436 */     this.leafDensity = par5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validTreeLocation() {
/* 445 */     int[] var1 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 446 */     int[] var2 = { this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2] };
/* 447 */     Block var3 = this.worldObj.func_147439_a(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
/*     */     
/* 449 */     if (!TFC_Core.isSoil(var3))
/*     */     {
/* 451 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 455 */     int var4 = checkBlockLine(var1, var2);
/* 456 */     if (var4 == -1)
/*     */     {
/* 458 */       return true;
/*     */     }
/* 460 */     if (var4 < 6)
/*     */     {
/* 462 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 466 */     this.heightLimit = var4;
/* 467 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenAcaciaKoaTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */