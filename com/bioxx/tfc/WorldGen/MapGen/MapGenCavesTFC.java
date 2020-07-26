/*     */ package com.bioxx.tfc.WorldGen.MapGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapGenCavesTFC
/*     */   extends MapGenBaseTFC
/*     */ {
/*     */   public void generate(IChunkProvider par1IChunkProvider, World par2World, int par3, int par4, Block[] idsBig, byte[] metaBig) {
/*  23 */     generate(par1IChunkProvider, par2World, par3, par4, idsBig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateLargeCaveNode(long par1, int par3, int par4, Block[] par5, double par6, double par8, double par10) {
/*  30 */     generateCaveNode(par1, par3, par4, par5, par6, par8, par10, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D, 2.5D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generateCaveNode(long seed, int chunkX, int chunkZ, Block[] idArray, double i, double j, double k, float par12, float par13, float par14, int par15, int par16, double par17, double width) {
/*  38 */     double worldX = (chunkX * 16 + 8);
/*  39 */     double worldZ = (chunkZ * 16 + 8);
/*  40 */     float var23 = 0.0F;
/*  41 */     float var24 = 0.0F;
/*  42 */     Random var25 = new Random(seed);
/*     */     
/*  44 */     if (par16 <= 0) {
/*     */       
/*  46 */       int var26 = this.range * 16 - 16;
/*  47 */       par16 = var26 - var25.nextInt(var26 / 4);
/*     */     } 
/*     */     
/*  50 */     boolean var54 = false;
/*  51 */     if (par15 == -1) {
/*     */       
/*  53 */       par15 = par16 / 2;
/*  54 */       var54 = true;
/*     */     } 
/*     */     
/*  57 */     int var27 = var25.nextInt(par16 / 2) + par16 / 4;
/*  58 */     for (boolean var28 = (var25.nextInt(6) == 0); par15 < par16; par15++) {
/*     */       
/*  60 */       float var33 = MathHelper.func_76134_b(par14);
/*  61 */       float var34 = MathHelper.func_76126_a(par14);
/*  62 */       i += (MathHelper.func_76134_b(par13) * var33);
/*  63 */       j += var34;
/*  64 */       k += (MathHelper.func_76126_a(par13) * var33);
/*     */       
/*  66 */       if (var28) {
/*  67 */         par14 *= 0.92F;
/*     */       } else {
/*  69 */         par14 *= 0.7F;
/*     */       } 
/*  71 */       par14 += var24 * 0.1F;
/*  72 */       par13 += var23 * 0.1F;
/*  73 */       var24 *= 0.9F;
/*  74 */       var23 *= 0.75F;
/*  75 */       var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
/*  76 */       var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
/*     */       
/*  78 */       if (!var54 && par15 == var27 && par12 > 1.0F && par16 > 0) {
/*     */         
/*  80 */         generateCaveNode(var25.nextLong(), chunkX, chunkZ, idArray, i, j, k, var25.nextFloat() * 0.5F + 0.5F, par13 - 1.5707964F, par14 / 3.0F, par15, par16, 1.0D, width);
/*  81 */         generateCaveNode(var25.nextLong(), chunkX, chunkZ, idArray, i, j, k, var25.nextFloat() * 0.5F + 0.5F, par13 + 1.5707964F, par14 / 3.0F, par15, par16, 1.0D, width);
/*     */         
/*     */         return;
/*     */       } 
/*  85 */       double var29 = width + (MathHelper.func_76126_a(par15 * 3.1415927F / par16) * par12 * 1.0F);
/*  86 */       double var31 = var29 * par17;
/*  87 */       if (var54 || var25.nextInt(4) != 0) {
/*     */         
/*  89 */         double var35 = i - worldX;
/*  90 */         double var37 = k - worldZ;
/*  91 */         double var39 = (par16 - par15);
/*  92 */         double var41 = (par12 + 2.0F + 16.0F);
/*     */         
/*  94 */         if (var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
/*     */           return;
/*     */         }
/*  97 */         if (i >= worldX - 16.0D - var29 * 2.0D && k >= worldZ - 16.0D - var29 * 2.0D && i <= worldX + 16.0D + var29 * 2.0D && k <= worldZ + 16.0D + var29 * 2.0D) {
/*     */           
/*  99 */           int var55 = MathHelper.func_76128_c(i - var29) - chunkX * 16 - 1;
/* 100 */           int var36 = MathHelper.func_76128_c(i + var29) - chunkX * 16 + 1;
/* 101 */           int var57 = MathHelper.func_76128_c(j - var31) - 1;
/* 102 */           int yCoord = MathHelper.func_76128_c(j + var31) + 1;
/* 103 */           int var56 = MathHelper.func_76128_c(k - var29) - chunkZ * 16 - 1;
/* 104 */           int var40 = MathHelper.func_76128_c(k + var29) - chunkZ * 16 + 1;
/*     */           
/* 106 */           if (var55 < 0) {
/* 107 */             var55 = 0;
/*     */           }
/* 109 */           if (var36 > 16) {
/* 110 */             var36 = 16;
/*     */           }
/* 112 */           if (var57 < 1) {
/* 113 */             var57 = 1;
/*     */           }
/* 115 */           if (yCoord > 250) {
/* 116 */             yCoord = 250;
/*     */           }
/* 118 */           if (var56 < 0) {
/* 119 */             var56 = 0;
/*     */           }
/* 121 */           if (var40 > 16) {
/* 122 */             var40 = 16;
/*     */           }
/* 124 */           boolean var58 = false;
/*     */           
/*     */           int xCoord;
/*     */           
/* 128 */           for (xCoord = var55; !var58 && xCoord < var36; xCoord++) {
/*     */             
/* 130 */             for (int zCoord = var56; !var58 && zCoord < var40; zCoord++) {
/*     */               
/* 132 */               for (int y = yCoord + 1; !var58 && y >= var57 - 1; y--) {
/*     */                 
/* 134 */                 int index = (xCoord * 16 + zCoord) * 256 + y;
/* 135 */                 if (y >= 0 && y < 256) {
/*     */                   
/* 137 */                   if (idArray[index] == TFCBlocks.saltWaterStationary || idArray[index] == TFCBlocks.freshWaterStationary)
/* 138 */                     var58 = true; 
/* 139 */                   if (y != var57 - 1 && xCoord != var55 && xCoord != var36 - 1 && zCoord != var56 && zCoord != var40 - 1) {
/* 140 */                     y = var57;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 146 */           if (!var58) {
/*     */             
/* 148 */             for (xCoord = var55; xCoord < var36; xCoord++) {
/*     */               
/* 150 */               double var59 = ((xCoord + chunkX * 16) + 0.5D - i) / var29;
/* 151 */               for (int zCoord = var56; zCoord < var40; zCoord++) {
/*     */                 
/* 153 */                 double var46 = ((zCoord + chunkZ * 16) + 0.5D - k) / var29;
/* 154 */                 int index = (xCoord * 16 + zCoord) * 256 + yCoord;
/* 155 */                 boolean isGrass = false;
/* 156 */                 Block grassBlock = Blocks.field_150350_a;
/* 157 */                 if (var59 * var59 + var46 * var46 < 1.0D)
/*     */                 {
/* 159 */                   for (int var50 = yCoord - 1; var50 >= var57; var50--) {
/*     */                     
/* 161 */                     double var51 = (var50 + 0.5D - j) / var31;
/* 162 */                     if (var51 > -0.7D && var59 * var59 + var51 * var51 + var46 * var46 < 1.0D) {
/*     */                       
/* 164 */                       if (TFC_Core.isGrass(idArray[index])) {
/*     */                         
/* 166 */                         grassBlock = idArray[index];
/* 167 */                         isGrass = true;
/*     */                       } 
/* 169 */                       if (TFC_Core.isSoil(idArray[index]) || TFC_Core.isRawStone(idArray[index])) {
/*     */                         
/* 171 */                         if (TFC_Core.isSoilOrGravel(idArray[index + 1]))
/*     */                         {
/* 173 */                           for (int upCount = 1; TFC_Core.isSoilOrGravel(idArray[index + upCount]); upCount++) {
/* 174 */                             idArray[index + upCount] = Blocks.field_150350_a;
/*     */                           }
/*     */                         }
/* 177 */                         if (var50 < 10 && TFC_Climate.getStability(this.worldObj, (int)worldX, (int)worldZ) == 1) {
/*     */                           
/* 179 */                           idArray[index] = TFCBlocks.lava;
/*     */                         
/*     */                         }
/*     */                         else {
/*     */                           
/* 184 */                           idArray[index] = Blocks.field_150350_a;
/*     */                           
/* 186 */                           if (isGrass && TFC_Core.isDirt(idArray[index - 1]))
/*     */                           {
/*     */                             
/* 189 */                             idArray[index - 1] = grassBlock;
/*     */                           }
/*     */                         } 
/*     */                       } 
/*     */                     } 
/* 194 */                     index--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/* 199 */             if (var54) {
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
/*     */   protected void recursiveGenerate(World world, int par2, int par3, int par4, int par5, Block[] ids) {
/* 213 */     int var7 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(40) + 1) + 1);
/* 214 */     double xCoord = (par2 * 16 + this.rand.nextInt(16));
/* 215 */     double yCoord = (this.rand.nextInt(1 + this.rand.nextInt(140)) + 60);
/* 216 */     double zCoord = (par3 * 16 + this.rand.nextInt(16));
/* 217 */     float rain = TFC_Climate.getRainfall(world, (int)xCoord, 144, (int)zCoord);
/* 218 */     double width = 2.0D;
/* 219 */     int caveChance = 35;
/*     */     
/* 221 */     if (rain > 1000.0F) {
/*     */       
/* 223 */       width += 0.5D;
/* 224 */       caveChance -= 5;
/*     */     }
/* 226 */     else if (rain > 2000.0F) {
/*     */       
/* 228 */       width++;
/* 229 */       caveChance -= 10;
/*     */     }
/* 231 */     else if (rain < 1000.0F) {
/*     */       
/* 233 */       width -= 0.5D;
/* 234 */       caveChance += 5;
/*     */     }
/* 236 */     else if (rain < 500.0F) {
/*     */       
/* 238 */       width--;
/* 239 */       caveChance += 10;
/*     */     }
/* 241 */     else if (rain < 250.0F) {
/*     */       
/* 243 */       width -= 1.25D;
/* 244 */       caveChance += 15;
/*     */     } 
/*     */     
/* 247 */     if (TFC_Climate.getCacheManager(world) != null) {
/*     */       
/* 249 */       DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt((int)xCoord, (int)zCoord, 0);
/* 250 */       Block layerID = rockLayer1.block;
/* 251 */       if (layerID == TFCBlocks.stoneIgEx) {
/*     */         
/* 253 */         width -= 0.4D;
/*     */       }
/* 255 */       else if (layerID == TFCBlocks.stoneIgIn) {
/*     */         
/* 257 */         width -= 0.5D;
/*     */       }
/* 259 */       else if (layerID == TFCBlocks.stoneSed) {
/*     */         
/* 261 */         width += 0.2D;
/* 262 */         var7 += 5;
/*     */       }
/* 264 */       else if (layerID == TFCBlocks.stoneMM) {
/*     */         
/* 266 */         width += 0.3D;
/*     */       } 
/*     */     } 
/*     */     
/* 270 */     if (yCoord < 32.0D) {
/* 271 */       width *= 0.5D;
/* 272 */     } else if (yCoord < 64.0D) {
/* 273 */       width *= 0.65D;
/* 274 */     } else if (yCoord < 96.0D) {
/* 275 */       width *= 0.8D;
/* 276 */     } else if (yCoord < 120.0D) {
/* 277 */       width *= 0.9D;
/*     */     } else {
/* 279 */       width *= 0.5D;
/*     */     } 
/* 281 */     if (this.rand.nextInt(8) == 0) {
/* 282 */       width++;
/*     */     }
/* 284 */     if (this.rand.nextInt(caveChance) != 0) {
/* 285 */       var7 = 0;
/*     */     }
/* 287 */     for (int var8 = 0; var8 < var7; var8++) {
/*     */       
/* 289 */       int var15 = 1;
/* 290 */       if (this.rand.nextInt(4) == 0) {
/*     */         
/* 292 */         generateLargeCaveNode(this.rand.nextLong(), par4, par5, ids, xCoord, yCoord, zCoord);
/* 293 */         var15 += this.rand.nextInt(4);
/*     */       } 
/*     */       
/* 296 */       for (int var16 = 0; var16 < var15; var16++) {
/*     */         
/* 298 */         float var17 = this.rand.nextFloat() * 3.1415927F * 2.0F;
/* 299 */         float var18 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 300 */         float var19 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
/* 301 */         if (this.rand.nextInt(10) == 0)
/* 302 */           var19 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F; 
/* 303 */         generateCaveNode(this.rand.nextLong(), par4, par5, ids, xCoord, yCoord, zCoord, var19, var17, var18, 0, 0, 1.0D, width);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\MapGen\MapGenCavesTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */