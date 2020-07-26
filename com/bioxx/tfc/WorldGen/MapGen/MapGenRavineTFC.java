/*     */ package com.bioxx.tfc.WorldGen.MapGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ public class MapGenRavineTFC
/*     */   extends MapGenBaseTFC
/*     */ {
/*  17 */   private float[] multipliers = new float[1024];
/*     */   
/*     */   private final int height;
/*     */   
/*     */   private final int variability;
/*     */   
/*     */   public MapGenRavineTFC(int h, int v) {
/*  24 */     this.height = h;
/*  25 */     this.variability = v;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(IChunkProvider par1IChunkProvider, World par2World, int par3, int par4, Block[] idsBig, byte[] metaBig) {
/*  31 */     generate(par1IChunkProvider, par2World, par3, par4, idsBig);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void generateRavine(long seed, int chunkX, int chunkZ, Block[] blockArray, double xCoord, double yCoord, double zCoord, float par12, float par13, float par14, int par15, int par16, double yScale) {
/*  36 */     Random var19 = new Random(seed);
/*  37 */     double chunkMidX = (chunkX * 16 + 8);
/*  38 */     double chunkMidZ = (chunkZ * 16 + 8);
/*  39 */     float var24 = 0.0F;
/*  40 */     float var25 = 0.0F;
/*     */ 
/*     */     
/*  43 */     if (par16 <= 0) {
/*     */       
/*  45 */       int var26 = this.range * 16 - 16;
/*  46 */       par16 = var26 - var19.nextInt(var26 / 4);
/*     */     } 
/*     */     
/*  49 */     boolean var54 = false;
/*  50 */     if (par15 == -1) {
/*     */       
/*  52 */       par15 = par16 / 2;
/*  53 */       var54 = true;
/*     */     } 
/*     */     
/*  56 */     float var27 = 1.0F;
/*  57 */     for (int var28 = 0; var28 < 256; var28++) {
/*     */       
/*  59 */       if (var28 == 0 || var19.nextInt(3) == 0)
/*  60 */         var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F; 
/*  61 */       this.multipliers[var28] = var27 * var27;
/*     */     } 
/*     */     
/*  64 */     for (; par15 < par16; par15++) {
/*     */       
/*  66 */       double var53 = 1.5D + (MathHelper.func_76126_a(par15 * 3.1415927F / par16) * par12 * 1.0F);
/*  67 */       double var30 = var53 * yScale;
/*  68 */       var53 *= var19.nextFloat() * 0.25D + 0.75D;
/*  69 */       var30 *= var19.nextFloat() * 0.25D + 0.75D;
/*  70 */       float var32 = MathHelper.func_76134_b(par14);
/*  71 */       float var33 = MathHelper.func_76126_a(par14);
/*  72 */       xCoord += (MathHelper.func_76134_b(par13) * var32);
/*  73 */       yCoord += var33;
/*  74 */       zCoord += (MathHelper.func_76126_a(par13) * var32);
/*  75 */       par14 *= 0.7F;
/*  76 */       par14 += var25 * 0.05F;
/*  77 */       par13 += var24 * 0.05F;
/*  78 */       var25 *= 0.8F;
/*  79 */       var24 *= 0.5F;
/*  80 */       var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
/*  81 */       var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
/*     */       
/*  83 */       if (var54 || var19.nextInt(4) != 0) {
/*     */         
/*  85 */         double var34 = xCoord - chunkMidX;
/*  86 */         double var36 = zCoord - chunkMidZ;
/*  87 */         double var38 = (par16 - par15);
/*  88 */         double var40 = (par12 + 2.0F + 16.0F);
/*     */         
/*  90 */         if (var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
/*     */           return;
/*     */         }
/*  93 */         if (xCoord >= chunkMidX - 16.0D - var53 * 2.0D && zCoord >= chunkMidZ - 16.0D - var53 * 2.0D && xCoord <= chunkMidX + 16.0D + var53 * 2.0D && zCoord <= chunkMidZ + 16.0D + var53 * 2.0D) {
/*     */           
/*  95 */           int xMin = MathHelper.func_76128_c(xCoord - var53) - chunkX * 16 - 1;
/*  96 */           int xMax = MathHelper.func_76128_c(xCoord + var53) - chunkX * 16 + 1;
/*  97 */           int minY = MathHelper.func_76128_c(yCoord - var30) - 1;
/*  98 */           int maxY = MathHelper.func_76128_c(yCoord + var30) + 1;
/*  99 */           int zMin = MathHelper.func_76128_c(zCoord - var53) - chunkZ * 16 - 1;
/* 100 */           int zMax = MathHelper.func_76128_c(zCoord + var53) - chunkZ * 16 + 1;
/*     */           
/* 102 */           if (xMin < 0) {
/* 103 */             xMin = 0;
/*     */           }
/* 105 */           if (xMax > 16) {
/* 106 */             xMax = 16;
/*     */           }
/* 108 */           if (minY < 1) {
/* 109 */             minY = 1;
/*     */           }
/* 111 */           if (maxY > 250) {
/* 112 */             maxY = 250;
/*     */           }
/* 114 */           if (zMin < 0) {
/* 115 */             zMin = 0;
/*     */           }
/* 117 */           if (zMax > 16) {
/* 118 */             zMax = 16;
/*     */           }
/* 120 */           boolean isBlocked = false;
/*     */           
/*     */           int x;
/*     */           
/* 124 */           for (x = xMin; !isBlocked && x < xMax; x++) {
/*     */             
/* 126 */             for (int z = zMin; !isBlocked && z < zMax; z++) {
/*     */               
/* 128 */               for (int y = maxY + 1; !isBlocked && y >= minY - 1; y--) {
/*     */                 
/* 130 */                 int index = (x * 16 + z) * 256 + y;
/*     */                 
/* 132 */                 if (y >= 0 && y < 256) {
/*     */                   
/* 134 */                   if (blockArray[index] == TFCBlocks.saltWaterStationary || blockArray[index] == TFCBlocks.freshWaterStationary)
/* 135 */                     isBlocked = true; 
/* 136 */                   if (y != minY - 1 && x != xMin && x != xMax - 1 && z != zMin && z != zMax - 1) {
/* 137 */                     y = minY;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 143 */           if (!isBlocked) {
/*     */             
/* 145 */             for (x = xMin; x < xMax; x++) {
/*     */               
/* 147 */               double var59 = ((x + chunkX * 16) + 0.5D - xCoord) / var53;
/*     */               
/* 149 */               for (int index = zMin; index < zMax; index++) {
/*     */                 
/* 151 */                 double var45 = ((index + chunkZ * 16) + 0.5D - zCoord) / var53;
/* 152 */                 int index2 = (x * 16 + index) * 256 + maxY;
/*     */                 
/* 154 */                 if (var59 * var59 + var45 * var45 < 1.0D)
/*     */                 {
/* 156 */                   for (int var49 = maxY - 1; var49 >= minY; var49--) {
/*     */                     
/* 158 */                     double var50 = (var49 + 0.5D - yCoord) / var30;
/* 159 */                     if ((var59 * var59 + var45 * var45) * this.multipliers[var49] + var50 * var50 / 6.0D < 1.0D)
/*     */                     {
/* 161 */                       if (TFC_Core.isGround(blockArray[index2])) {
/*     */                         
/* 163 */                         if (TFC_Core.isSoilOrGravel(blockArray[index2 + 1]))
/*     */                         {
/* 165 */                           for (int upCount = 1; TFC_Core.isSoilOrGravel(blockArray[index2 + upCount]); upCount++) {
/* 166 */                             blockArray[index2 + upCount] = Blocks.field_150350_a;
/*     */                           }
/*     */                         }
/* 169 */                         if (var49 < 10) {
/* 170 */                           blockArray[index2] = Blocks.field_150353_l;
/*     */                         } else {
/* 172 */                           blockArray[index2] = Blocks.field_150350_a;
/*     */                         } 
/*     */                       } 
/*     */                     }
/* 176 */                     index2--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/* 181 */             if (var54) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void recursiveGenerate(World par1World, int chunkX, int chunkZ, int par4, int par5, Block[] par6) {
/* 195 */     if (TFCOptions.ravineRarity > 0 && this.rand.nextInt(TFCOptions.ravineRarity) == 0) {
/*     */       
/* 197 */       double startX = (chunkX * 16 + this.rand.nextInt(16));
/* 198 */       double startY = (this.rand.nextInt(this.variability) + this.height);
/* 199 */       double startZ = (chunkZ * 16 + this.rand.nextInt(16));
/* 200 */       byte var13 = 1;
/* 201 */       for (int var14 = 0; var14 < var13; var14++) {
/*     */         
/* 203 */         float angleY = this.rand.nextFloat() * 3.1415927F * 2.0F;
/* 204 */         float angleZ = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 205 */         float angleX = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
/* 206 */         double scaleY = 1.2D + this.rand.nextFloat() + this.rand.nextFloat();
/* 207 */         generateRavine(this.rand.nextLong(), par4, par5, par6, startX, startY, startZ, angleX, angleY, angleZ, 0, 0, scaleY);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\MapGen\MapGenRavineTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */