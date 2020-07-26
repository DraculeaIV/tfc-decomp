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
/*     */ public class WorldGenCustomBigTree
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
/*     */   private int height;
/*     */   private static final double HEIGHT_ATTENUATION = 0.618D;
/*     */   private static final double BRANCH_SLOPE = 0.381D;
/*  30 */   private double scaleWidth = 1.0D;
/*  31 */   private double leafDensity = 1.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private int heightLimitLimit = 12;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private int leafDistanceLimit = 4;
/*     */ 
/*     */   
/*     */   private int[][] leafNodes;
/*     */   
/*     */   private final int treeId;
/*     */ 
/*     */   
/*     */   public WorldGenCustomBigTree(boolean par1, int id) {
/*  55 */     super(par1);
/*  56 */     this.treeId = id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int checkBlockLine(int[] startCoords, int[] endCoords) {
/*     */     byte direction;
/*  65 */     int[] distance = { 0, 0, 0 };
/*  66 */     byte axis = 0;
/*     */     
/*     */     byte newAxis;
/*  69 */     for (newAxis = 0; axis < 3; axis = (byte)(axis + 1)) {
/*     */       
/*  71 */       distance[axis] = endCoords[axis] - startCoords[axis];
/*  72 */       if (Math.abs(distance[axis]) > Math.abs(distance[newAxis])) {
/*  73 */         newAxis = axis;
/*     */       }
/*     */     } 
/*  76 */     if (distance[newAxis] == 0)
/*     */     {
/*  78 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*  82 */     byte newAxisInverse = OTHER_COORD_PAIRS[newAxis];
/*  83 */     byte newAxisInversePerp = OTHER_COORD_PAIRS[newAxis + 3];
/*     */ 
/*     */     
/*  86 */     if (distance[newAxis] > 0) {
/*  87 */       direction = 1;
/*     */     } else {
/*  89 */       direction = -1;
/*     */     } 
/*  91 */     double var9 = distance[newAxisInverse] / distance[newAxis];
/*  92 */     double var11 = distance[newAxisInversePerp] / distance[newAxis];
/*  93 */     int[] coords = { 0, 0, 0 };
/*  94 */     int result = 0;
/*     */     
/*     */     int endPoint;
/*  97 */     for (endPoint = distance[newAxis] + direction; result != endPoint; result += direction) {
/*     */       
/*  99 */       coords[newAxis] = startCoords[newAxis] + result;
/* 100 */       coords[newAxisInverse] = MathHelper.func_76128_c(startCoords[newAxisInverse] + result * var9);
/* 101 */       coords[newAxisInversePerp] = MathHelper.func_76128_c(startCoords[newAxisInversePerp] + result * var11);
/* 102 */       Block block = this.worldObj.func_147439_a(coords[0], coords[1], coords[2]);
/* 103 */       if (!block.isAir((IBlockAccess)this.worldObj, coords[0], coords[1], coords[2]) && block != TFCBlocks.leaves && block != TFCBlocks.leaves2) {
/*     */         break;
/*     */       }
/*     */     } 
/* 107 */     return (result == endPoint) ? -1 : Math.abs(result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/* 114 */     this.worldObj = world;
/* 115 */     long seed = rand.nextLong();
/* 116 */     this.rand.setSeed(seed);
/* 117 */     this.basePos[0] = x;
/* 118 */     this.basePos[1] = y;
/* 119 */     this.basePos[2] = z;
/*     */     
/* 121 */     if (this.heightLimit == 0) {
/* 122 */       this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
/*     */     }
/* 124 */     if (!validTreeLocation())
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 130 */     generateLeafNodeList();
/* 131 */     generateLeaves();
/* 132 */     generateTrunk();
/* 133 */     generateLeafNodeBases();
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNode(int x, int y, int z) {
/* 143 */     int yCoord = y;
/* 144 */     for (int range = y + this.leafDistanceLimit; yCoord < range; yCoord++) {
/*     */       
/* 146 */       float leafSizeAtHeight = leafSize(yCoord - y);
/* 147 */       genTreeLayer(x, yCoord, z, leafSizeAtHeight, (byte)1, TFCBlocks.leaves);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNodeBases() {
/* 156 */     int i = 0;
/*     */     
/* 158 */     for (int[] location = { this.basePos[0], this.basePos[1], this.basePos[2] }; i < this.leafNodes.length; i++) {
/*     */       
/* 160 */       int[] leafPoints = this.leafNodes[i];
/* 161 */       int[] newLocation = { leafPoints[0], leafPoints[1], leafPoints[2] };
/* 162 */       location[1] = leafPoints[3];
/* 163 */       int baseHeight = location[1] - this.basePos[1];
/* 164 */       if (leafNodeNeedsBase(baseHeight)) {
/* 165 */         placeBlockLine(location, newLocation, TFCBlocks.logNatural);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeafNodeList() {
/* 174 */     this.height = (int)(this.heightLimit * 0.618D);
/* 175 */     if (this.height >= this.heightLimit) {
/* 176 */       this.height = this.heightLimit - 1;
/*     */     }
/* 178 */     int var1 = (int)(1.382D + Math.pow(this.leafDensity * this.heightLimit / 13.0D, 2.0D));
/* 179 */     if (var1 < 1) {
/* 180 */       var1 = 1;
/*     */     }
/* 182 */     int[][] var2 = new int[var1 * this.heightLimit][4];
/* 183 */     int trunkTop = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
/* 184 */     int var4 = 1;
/* 185 */     int treeTop = this.basePos[1] + this.height;
/* 186 */     int height = trunkTop - this.basePos[1];
/* 187 */     var2[0][0] = this.basePos[0];
/* 188 */     var2[0][1] = trunkTop;
/* 189 */     var2[0][2] = this.basePos[2];
/* 190 */     var2[0][3] = treeTop;
/* 191 */     trunkTop--;
/*     */     
/* 193 */     while (height >= 0) {
/*     */       
/* 195 */       int var7 = 0;
/* 196 */       float var8 = layerSize(height);
/*     */       
/* 198 */       if (var8 < 0.0F) {
/*     */         
/* 200 */         trunkTop--;
/* 201 */         height--;
/*     */         
/*     */         continue;
/*     */       } 
/* 205 */       for (double var9 = 0.5D; var7 < var1; var7++) {
/*     */         
/* 207 */         double var11 = this.scaleWidth * var8 * (this.rand.nextFloat() + 0.328D);
/* 208 */         double var13 = this.rand.nextFloat() * 2.0D * Math.PI;
/* 209 */         int var15 = MathHelper.func_76128_c(var11 * Math.sin(var13) + this.basePos[0] + var9);
/* 210 */         int var16 = MathHelper.func_76128_c(var11 * Math.cos(var13) + this.basePos[2] + var9);
/* 211 */         int[] var17 = { var15, trunkTop, var16 };
/* 212 */         int[] var18 = { var15, trunkTop + this.leafDistanceLimit, var16 };
/*     */         
/* 214 */         if (checkBlockLine(var17, var18) == -1) {
/*     */           
/* 216 */           int[] var19 = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 217 */           double var20 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - var17[0]), 2.0D) + Math.pow(Math.abs(this.basePos[2] - var17[2]), 2.0D));
/* 218 */           double var22 = var20 * 0.381D;
/*     */           
/* 220 */           if (var17[1] - var22 > treeTop) {
/* 221 */             var19[1] = treeTop;
/*     */           } else {
/* 223 */             var19[1] = (int)(var17[1] - var22);
/*     */           } 
/* 225 */           if (checkBlockLine(var19, var17) == -1) {
/*     */             
/* 227 */             var2[var4][0] = var15;
/* 228 */             var2[var4][1] = trunkTop;
/* 229 */             var2[var4][2] = var16;
/* 230 */             var2[var4][3] = var19[1];
/* 231 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } 
/* 235 */       trunkTop--;
/* 236 */       height--;
/*     */     } 
/*     */     
/* 239 */     this.leafNodes = new int[var4][4];
/* 240 */     System.arraycopy(var2, 0, this.leafNodes, 0, var4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateLeaves() {
/* 248 */     for (int i = 0; i < this.leafNodes.length; i++) {
/*     */       
/* 250 */       int x = this.leafNodes[i][0];
/* 251 */       int y = this.leafNodes[i][1];
/* 252 */       int z = this.leafNodes[i][2];
/* 253 */       generateLeafNode(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateTrunk() {
/* 263 */     int x = this.basePos[0];
/* 264 */     int y = this.basePos[1];
/* 265 */     int maxY = this.basePos[1] + this.height;
/* 266 */     int z = this.basePos[2];
/* 267 */     int[] bottom = { x, y, z };
/* 268 */     int[] top = { x, maxY, z };
/* 269 */     placeBlockLine(bottom, top, TFCBlocks.logNatural);
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
/*     */   private void genTreeLayer(int x, int y, int z, float leafSizeAtHeight, byte axis, Block b) {
/* 287 */     int range = (int)(leafSizeAtHeight + 0.618D);
/* 288 */     byte axisInverse = OTHER_COORD_PAIRS[axis];
/* 289 */     byte axisInversePerp = OTHER_COORD_PAIRS[axis + 3];
/* 290 */     int[] startCoords = { x, y, z };
/* 291 */     int[] coords = { 0, 0, 0 };
/* 292 */     int width1 = -range;
/* 293 */     int width2 = -range;
/*     */     
/* 295 */     for (coords[axis] = startCoords[axis]; width1 <= range; width1++) {
/*     */       
/* 297 */       coords[axisInverse] = startCoords[axisInverse] + width1;
/* 298 */       width2 = -range;
/*     */       
/* 300 */       while (width2 <= range) {
/*     */         
/* 302 */         double distance = Math.sqrt(Math.pow(Math.abs(width1) + 0.5D, 2.0D) + Math.pow(Math.abs(width2) + 0.5D, 2.0D));
/*     */         
/* 304 */         if (distance > leafSizeAtHeight) {
/*     */           
/* 306 */           width2++;
/*     */           
/*     */           continue;
/*     */         } 
/* 310 */         coords[axisInversePerp] = startCoords[axisInversePerp] + width2;
/* 311 */         Block block = this.worldObj.func_147439_a(coords[0], coords[1], coords[2]);
/* 312 */         if (this.worldObj.func_147437_c(coords[0], coords[1], coords[2]) || block == TFCBlocks.leaves || block == TFCBlocks.leaves2)
/* 313 */           func_150516_a(this.worldObj, coords[0], coords[1], coords[2], b, this.treeId); 
/* 314 */         width2++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float layerSize(int height) {
/*     */     float size;
/* 325 */     if (height < this.heightLimit * 0.3D)
/*     */     {
/* 327 */       return -1.618F;
/*     */     }
/*     */ 
/*     */     
/* 331 */     float halfLimit = this.heightLimit / 2.0F;
/* 332 */     float leafBase = this.heightLimit / 2.0F - height;
/*     */ 
/*     */     
/* 335 */     if (leafBase == 0.0F) {
/* 336 */       size = halfLimit;
/* 337 */     } else if (Math.abs(leafBase) >= halfLimit) {
/* 338 */       size = 0.0F;
/*     */     } else {
/* 340 */       size = (float)Math.sqrt(Math.pow(Math.abs(halfLimit), 2.0D) - Math.pow(Math.abs(leafBase), 2.0D));
/*     */     } 
/* 342 */     size *= 0.5F;
/* 343 */     return size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean leafNodeNeedsBase(int par1) {
/* 352 */     return (par1 >= this.heightLimit * 0.2D);
/*     */   }
/*     */ 
/*     */   
/*     */   private float leafSize(int height) {
/* 357 */     return (height >= 0 && height < this.leafDistanceLimit) ? ((height != 0 && height != this.leafDistanceLimit - 1) ? 3.0F : 2.0F) : -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void placeBlockLine(int[] bottom, int[] top, Block b) {
/* 365 */     int[] location = { 0, 0, 0 };
/* 366 */     byte axis = 0;
/*     */     
/*     */     byte newAxis;
/* 369 */     for (newAxis = 0; axis < 3; axis = (byte)(axis + 1)) {
/*     */       
/* 371 */       location[axis] = top[axis] - bottom[axis];
/* 372 */       if (Math.abs(location[axis]) > Math.abs(location[newAxis])) {
/* 373 */         newAxis = axis;
/*     */       }
/*     */     } 
/* 376 */     if (location[newAxis] != 0) {
/*     */       
/* 378 */       byte direction, newAxisInverse = OTHER_COORD_PAIRS[newAxis];
/* 379 */       byte newAxisInversePerp = OTHER_COORD_PAIRS[newAxis + 3];
/*     */ 
/*     */       
/* 382 */       if (location[newAxis] > 0) {
/* 383 */         direction = 1;
/*     */       } else {
/* 385 */         direction = -1;
/*     */       } 
/* 387 */       double var10 = location[newAxisInverse] / location[newAxis];
/* 388 */       double var12 = location[newAxisInversePerp] / location[newAxis];
/* 389 */       int[] coords = { 0, 0, 0 };
/*     */       int loc;
/* 391 */       for (loc = 0; loc != location[newAxis] + direction; loc += direction) {
/*     */         
/* 393 */         coords[newAxis] = MathHelper.func_76128_c((bottom[newAxis] + loc) + 0.5D);
/* 394 */         coords[newAxisInverse] = MathHelper.func_76128_c(bottom[newAxisInverse] + loc * var10 + 0.5D);
/* 395 */         coords[newAxisInversePerp] = MathHelper.func_76128_c(bottom[newAxisInversePerp] + loc * var12 + 0.5D);
/* 396 */         Block block = this.worldObj.func_147439_a(coords[0], coords[1], coords[2]);
/* 397 */         if (this.worldObj.func_147437_c(coords[0], coords[1], coords[2]) || block == TFCBlocks.leaves || block == TFCBlocks.leaves2) {
/* 398 */           func_150516_a(this.worldObj, coords[0], coords[1], coords[2], b, this.treeId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76487_a(double heightScale, double widthScale, double densityScale) {
/* 409 */     this.heightLimitLimit = (int)(heightScale * 12.0D);
/* 410 */     if (heightScale > 0.5D)
/* 411 */       this.leafDistanceLimit = 5; 
/* 412 */     this.scaleWidth = widthScale;
/* 413 */     this.leafDensity = densityScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validTreeLocation() {
/* 422 */     int[] coords = { this.basePos[0], this.basePos[1], this.basePos[2] };
/* 423 */     int[] topCoords = { this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2] };
/* 424 */     Block block = this.worldObj.func_147439_a(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
/*     */     
/* 426 */     if (!TFC_Core.isSoil(block))
/*     */     {
/* 428 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 432 */     int distance = checkBlockLine(coords, topCoords);
/* 433 */     if (distance == -1)
/*     */     {
/* 435 */       return true;
/*     */     }
/* 437 */     if (distance < 6)
/*     */     {
/* 439 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 443 */     this.heightLimit = distance;
/* 444 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomBigTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */