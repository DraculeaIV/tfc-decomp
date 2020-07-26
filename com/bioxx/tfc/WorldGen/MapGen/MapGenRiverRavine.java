/*     */ package com.bioxx.tfc.WorldGen.MapGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ public class MapGenRiverRavine
/*     */   extends MapGenBaseTFC
/*     */ {
/*  16 */   private float[] multipliers = new float[1024];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(IChunkProvider par1IChunkProvider, World par2World, int par3, int par4, Block[] idsBig, byte[] metaBig) {
/*  22 */     this.range = 12;
/*     */     
/*  24 */     recursiveGenerate(par2World, par3, par4, par3, par4, idsBig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateRavine(long seed, int chunkX, int chunkZ, Block[] blockArray, double par6, double startY, double par10, float par12, float par13, float par14, int par15, int par16, double par17, double waterHeight) {
/*  30 */     Random rand = new Random(seed);
/*  31 */     double worldX = (chunkX * 16 + 8);
/*  32 */     double worldZ = (chunkZ * 16 + 8);
/*  33 */     float var24 = 0.0F;
/*  34 */     float var25 = 0.0F;
/*     */ 
/*     */     
/*  37 */     if (par16 <= 0) {
/*     */       
/*  39 */       int var26 = this.range * 16 - 16;
/*  40 */       par16 = var26 - rand.nextInt(var26 / 4);
/*     */     } 
/*     */     
/*  43 */     boolean var54 = false;
/*  44 */     if (par15 == -1) {
/*     */       
/*  46 */       par15 = par16 / 2;
/*  47 */       var54 = true;
/*     */     } 
/*     */     
/*  50 */     float var27 = 1.0F;
/*  51 */     for (int var28 = 0; var28 < 256; var28++) {
/*     */       
/*  53 */       if (var28 == 0 || rand.nextInt(3) == 0)
/*  54 */         var27 = 1.0F + rand.nextFloat() * rand.nextFloat() * 1.0F; 
/*  55 */       this.multipliers[var28] = var27 * var27;
/*     */     } 
/*     */     
/*  58 */     for (; par15 < par16; par15++) {
/*     */       
/*  60 */       double var53 = 3.5D + (MathHelper.func_76126_a(par15 * 3.1415927F / par16) * par12 * 1.0F);
/*  61 */       double var30 = var53 * par17;
/*  62 */       var53 *= rand.nextFloat() * 0.25D + 0.75D;
/*  63 */       var30 *= rand.nextFloat() * 0.25D + 0.75D;
/*  64 */       float var32 = MathHelper.func_76134_b(par14);
/*  65 */       float var33 = MathHelper.func_76126_a(par14);
/*  66 */       par6 += (MathHelper.func_76134_b(par13) * var32);
/*  67 */       startY += var33;
/*  68 */       par10 += (MathHelper.func_76126_a(par13) * var32);
/*  69 */       par14 *= 0.7F;
/*  70 */       par14 += var25 * 0.05F;
/*  71 */       par13 += var24 * 0.05F;
/*  72 */       var25 *= 0.8F;
/*  73 */       var24 *= 0.5F;
/*  74 */       var25 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 2.0F;
/*  75 */       var24 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 4.0F;
/*     */       
/*  77 */       if (var54 || rand.nextInt(4) != 0) {
/*     */         
/*  79 */         double var34 = par6 - worldX;
/*  80 */         double var36 = par10 - worldZ;
/*  81 */         double var38 = (par16 - par15);
/*  82 */         double var40 = (par12 + 2.0F + 16.0F);
/*     */         
/*  84 */         if (var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
/*     */           return;
/*     */         }
/*  87 */         if (par6 >= worldX - 16.0D - var53 * 2.0D && par10 >= worldZ - 16.0D - var53 * 2.0D && par6 <= worldX + 16.0D + var53 * 2.0D && par10 <= worldZ + 16.0D + var53 * 2.0D) {
/*     */           
/*  89 */           int var56 = MathHelper.func_76128_c(par6 - var53) - chunkX * 16 - 1;
/*  90 */           int var35 = MathHelper.func_76128_c(par6 + var53) - chunkX * 16 + 1;
/*  91 */           int var55 = MathHelper.func_76128_c(startY - var30) - 1;
/*  92 */           int var37 = MathHelper.func_76128_c(startY + var30) + 1;
/*  93 */           int var57 = MathHelper.func_76128_c(par10 - var53) - chunkZ * 16 - 1;
/*  94 */           int var39 = MathHelper.func_76128_c(par10 + var53) - chunkZ * 16 + 1;
/*     */           
/*  96 */           if (var56 < 0) {
/*  97 */             var56 = 0;
/*     */           }
/*  99 */           if (var35 > 16) {
/* 100 */             var35 = 16;
/*     */           }
/* 102 */           if (var55 < 1) {
/* 103 */             var55 = 1;
/*     */           }
/* 105 */           if (var37 > 250) {
/* 106 */             var37 = 250;
/*     */           }
/* 108 */           if (var57 < 0) {
/* 109 */             var57 = 0;
/*     */           }
/* 111 */           if (var39 > 16) {
/* 112 */             var39 = 16;
/*     */           }
/* 114 */           boolean var58 = false;
/*     */           
/*     */           int x;
/*     */           
/* 118 */           for (x = var56; !var58 && x < var35; x++) {
/*     */             
/* 120 */             for (int var42 = var57; !var58 && var42 < var39; var42++) {
/*     */               
/* 122 */               for (int var43 = var37 + 1; !var58 && var43 >= var55 - 1; var43--) {
/*     */                 
/* 124 */                 int z = (x * 16 + var42) * 256 + var43;
/* 125 */                 if (var43 >= 0 && var43 < 256)
/*     */                 {
/* 127 */                   if (var43 != var55 - 1 && x != var56 && x != var35 - 1 && var42 != var57 && var42 != var39 - 1) {
/* 128 */                     var43 = var55;
/*     */                   }
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/* 134 */           if (!var58) {
/*     */             
/* 136 */             for (x = var56; x < var35; x++) {
/*     */               
/* 138 */               double var59 = ((x + chunkX * 16) + 0.5D - par6) / var53;
/* 139 */               for (int z = var57; z < var39; z++) {
/*     */                 
/* 141 */                 double var45 = ((z + chunkZ * 16) + 0.5D - par10) / var53;
/* 142 */                 int var47 = (x * 16 + z) * 256 + var37;
/*     */                 
/* 144 */                 if (var59 * var59 + var45 * var45 < 1.0D)
/*     */                 {
/* 146 */                   for (int var49 = var37 - 1; var49 >= var55; var49--) {
/*     */                     
/* 148 */                     double var50 = (var49 + 0.5D - startY) / var30;
/* 149 */                     if ((var59 * var59 + var45 * var45) * this.multipliers[var49] + var50 * var50 / 6.0D < 1.0D) {
/*     */                       
/* 151 */                       Block block = blockArray[var47];
/*     */ 
/*     */                       
/* 154 */                       if (TFC_Core.isRawStone(block) || TFC_Core.isSoil(block))
/*     */                       {
/* 156 */                         if (var49 < 10) {
/*     */                           
/* 158 */                           blockArray[var47] = TFCBlocks.lava;
/*     */ 
/*     */                         
/*     */                         }
/* 162 */                         else if (var49 < waterHeight) {
/*     */                           
/* 164 */                           blockArray[var47] = TFCBlocks.freshWater;
/*     */                         
/*     */                         }
/*     */                         else {
/*     */                           
/* 169 */                           blockArray[var47] = Blocks.field_150350_a;
/*     */                         } 
/*     */                       }
/*     */                     } 
/*     */ 
/*     */                     
/* 175 */                     var47--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/* 180 */             if (var54) {
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
/*     */   protected void recursiveGenerate(World world, int chunkX, int chunkZ, int par4, int par5, Block[] blocks) {
/* 194 */     if (this.rand.nextInt(400) == 0) {
/*     */       
/* 196 */       this.range = 32;
/* 197 */       double x = (chunkX * 16 + this.rand.nextInt(16));
/*     */       
/* 199 */       double y = 80.0D;
/* 200 */       double z = (chunkZ * 16 + this.rand.nextInt(16));
/*     */       
/* 202 */       float var15 = this.rand.nextFloat() * 3.1415927F * 2.0F;
/* 203 */       float var16 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 204 */       float var17 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
/* 205 */       generateRavine(this.rand.nextLong(), chunkX, chunkZ, blocks, x, y, z, var17, var15, var16, 0, 0, 0.8D, y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\MapGen\MapGenRiverRavine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */