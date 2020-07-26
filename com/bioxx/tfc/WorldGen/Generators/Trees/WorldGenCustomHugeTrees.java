/*     */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
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
/*     */ 
/*     */ public class WorldGenCustomHugeTrees
/*     */   extends WorldGenerator
/*     */ {
/*     */   private final int field_48195_a;
/*     */   private final int woodMetadata;
/*     */   private final int leavesMetadata;
/*     */   
/*     */   public WorldGenCustomHugeTrees(boolean par1, int par2, int par3, int par4) {
/*  27 */     super(par1);
/*  28 */     this.field_48195_a = par2;
/*  29 */     this.woodMetadata = par3;
/*  30 */     this.leavesMetadata = par4;
/*     */   }
/*     */ 
/*     */   
/*     */   private void genLeaves(World par1World, int par2, int par3, int par4, int par5, Random par6Random) {
/*  35 */     byte var7 = 2;
/*  36 */     for (int var8 = par4 - var7; var8 <= par4; var8++) {
/*     */       
/*  38 */       int var9 = var8 - par4;
/*  39 */       int var10 = par5 + 1 - var9;
/*  40 */       for (int var11 = par2 - var10; var11 <= par2 + var10 + 1; var11++) {
/*     */         
/*  42 */         int var12 = var11 - par2;
/*  43 */         for (int var13 = par3 - var10; var13 <= par3 + var10 + 1; var13++) {
/*     */           
/*  45 */           int var14 = var13 - par3;
/*  46 */           if ((var12 >= 0 || var14 >= 0 || var12 * var12 + var14 * var14 <= var10 * var10) && ((var12 <= 0 && var14 <= 0) || var12 * var12 + var14 * var14 <= (var10 + 1) * (var10 + 1)) && (par6Random
/*     */             
/*  48 */             .nextInt(4) != 0 || var12 * var12 + var14 * var14 <= (var10 - 1) * (var10 - 1)) && 
/*  49 */             !par1World.func_147439_a(var11, var8, var13).func_149662_c())
/*     */           {
/*  51 */             func_150516_a(par1World, var11, var8, var13, TFCBlocks.leaves, this.leavesMetadata);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random rand, int xCoord, int yCoord, int zCoord) {
/*  61 */     int var6 = rand.nextInt(3) + this.field_48195_a;
/*  62 */     boolean canGenHere = true;
/*     */     
/*  64 */     if (yCoord >= 1 && yCoord + var6 + 1 <= 256) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  70 */       for (int blockUnder = yCoord; blockUnder <= yCoord + 1 + var6; blockUnder++) {
/*     */         
/*  72 */         byte var9 = 2;
/*  73 */         if (blockUnder == yCoord)
/*  74 */           var9 = 1; 
/*  75 */         if (blockUnder >= yCoord + 1 + var6 - 2) {
/*  76 */           var9 = 2;
/*     */         }
/*  78 */         for (int tempX = xCoord - var9; tempX <= xCoord + var9 && canGenHere; tempX++) {
/*     */           
/*  80 */           for (int tempZ = zCoord - var9; tempZ <= zCoord + var9 && canGenHere; tempZ++) {
/*     */             
/*  82 */             if (blockUnder >= 0 && blockUnder < 256) {
/*     */               
/*  84 */               Block block = world.func_147439_a(tempX, blockUnder, tempZ);
/*  85 */               if (!block.isAir((IBlockAccess)world, tempX, blockUnder, tempZ) && (block != TFCBlocks.leaves || block != TFCBlocks.leaves2) && (block != TFCBlocks.grass || block != TFCBlocks.grass2) && (block != TFCBlocks.dirt || block != TFCBlocks.dirt2) && (block != TFCBlocks.logNatural || block != TFCBlocks.logNatural2) && (block != TFCBlocks.sapling || block != TFCBlocks.sapling2) && 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*  91 */                 !TFC_Core.isSoil(block))
/*     */               {
/*  93 */                 canGenHere = false;
/*     */               }
/*     */             }
/*     */             else {
/*     */               
/*  98 */               canGenHere = false;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 104 */       if (!canGenHere)
/*     */       {
/* 106 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 110 */       if (TFC_Core.isSoil(world.func_147439_a(xCoord, yCoord - 1, zCoord)) && yCoord < 256 - var6 - 1) {
/*     */         
/* 112 */         DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(xCoord, zCoord, 0);
/* 113 */         world.func_147465_d(xCoord, yCoord - 1, zCoord, TFC_Core.getTypeForDirt(rockLayer1.data2), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 114 */         world.func_147465_d(xCoord + 1, yCoord - 1, zCoord, TFC_Core.getTypeForDirt(rockLayer1.data2), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 115 */         world.func_147465_d(xCoord, yCoord - 1, zCoord + 1, TFC_Core.getTypeForDirt(rockLayer1.data2), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 116 */         world.func_147465_d(xCoord + 1, yCoord - 1, zCoord + 1, TFC_Core.getTypeForDirt(rockLayer1.data2), TFC_Core.getSoilMetaFromStone(rockLayer1.block, rockLayer1.data2), 2);
/* 117 */         genLeaves(world, xCoord, zCoord, yCoord + var6, 2, rand);
/*     */         int var14;
/* 119 */         for (var14 = yCoord + var6 - 2 - rand.nextInt(4); var14 > yCoord + var6 / 2; var14 -= 2 + rand.nextInt(4)) {
/*     */           
/* 121 */           float var15 = rand.nextFloat() * 3.1415927F * 2.0F;
/* 122 */           int tempZ = xCoord + (int)(0.5F + MathHelper.func_76134_b(var15) * 4.0F);
/* 123 */           int var12 = zCoord + (int)(0.5F + MathHelper.func_76126_a(var15) * 4.0F);
/* 124 */           genLeaves(world, tempZ, var12, var14, 0, rand);
/*     */           
/* 126 */           for (int var13 = 0; var13 < 5; var13++) {
/*     */             
/* 128 */             tempZ = xCoord + (int)(1.5F + MathHelper.func_76134_b(var15) * var13);
/* 129 */             var12 = zCoord + (int)(1.5F + MathHelper.func_76126_a(var15) * var13);
/* 130 */             func_150516_a(world, tempZ, var14 - 3 + var13 / 2, var12, TFCBlocks.logNatural, this.woodMetadata);
/*     */           } 
/*     */         } 
/*     */         
/* 134 */         for (int tempX = 0; tempX < var6; tempX++) {
/*     */           
/* 136 */           Block id = world.func_147439_a(xCoord, yCoord + tempX, zCoord);
/* 137 */           if (id.isAir((IBlockAccess)world, xCoord, yCoord + tempX, zCoord) || id == TFCBlocks.leaves || id == TFCBlocks.leaves2) {
/*     */             
/* 139 */             func_150516_a(world, xCoord, yCoord + tempX, zCoord, TFCBlocks.logNatural, this.woodMetadata);
/* 140 */             if (tempX > 0) {
/*     */               
/* 142 */               if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord - 1, yCoord + tempX, zCoord))
/* 143 */                 func_150516_a(world, xCoord - 1, yCoord + tempX, zCoord, TFCBlocks.vine, 8); 
/* 144 */               if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord, yCoord + tempX, zCoord - 1)) {
/* 145 */                 func_150516_a(world, xCoord, yCoord + tempX, zCoord - 1, TFCBlocks.vine, 1);
/*     */               }
/*     */             } 
/*     */           } 
/* 149 */           if (tempX < var6 - 1) {
/*     */             
/* 151 */             id = world.func_147439_a(xCoord + 1, yCoord + tempX, zCoord);
/* 152 */             if (id.isAir((IBlockAccess)world, xCoord, yCoord + tempX, zCoord) || id == TFCBlocks.leaves || id == TFCBlocks.leaves2) {
/*     */               
/* 154 */               func_150516_a(world, xCoord + 1, yCoord + tempX, zCoord, TFCBlocks.logNatural, this.woodMetadata);
/* 155 */               if (tempX > 0) {
/*     */                 
/* 157 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord + 2, yCoord + tempX, zCoord))
/* 158 */                   func_150516_a(world, xCoord + 2, yCoord + tempX, zCoord, TFCBlocks.vine, 2); 
/* 159 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord + 1, yCoord + tempX, zCoord - 1)) {
/* 160 */                   func_150516_a(world, xCoord + 1, yCoord + tempX, zCoord - 1, TFCBlocks.vine, 1);
/*     */                 }
/*     */               } 
/*     */             } 
/* 164 */             id = world.func_147439_a(xCoord + 1, yCoord + tempX, zCoord + 1);
/* 165 */             if (id.isAir((IBlockAccess)world, xCoord, yCoord + tempX, zCoord) || id == TFCBlocks.leaves || id == TFCBlocks.leaves2) {
/*     */               
/* 167 */               func_150516_a(world, xCoord + 1, yCoord + tempX, zCoord + 1, TFCBlocks.logNatural, this.woodMetadata);
/* 168 */               if (tempX > 0) {
/*     */                 
/* 170 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord + 2, yCoord + tempX, zCoord + 1))
/* 171 */                   func_150516_a(world, xCoord + 2, yCoord + tempX, zCoord + 1, TFCBlocks.vine, 2); 
/* 172 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord + 1, yCoord + tempX, zCoord + 2)) {
/* 173 */                   func_150516_a(world, xCoord + 1, yCoord + tempX, zCoord + 2, TFCBlocks.vine, 4);
/*     */                 }
/*     */               } 
/*     */             } 
/* 177 */             id = world.func_147439_a(xCoord, yCoord + tempX, zCoord + 1);
/* 178 */             if (id.isAir((IBlockAccess)world, xCoord, yCoord + tempX, zCoord) || id == TFCBlocks.leaves || id == TFCBlocks.leaves2) {
/*     */               
/* 180 */               func_150516_a(world, xCoord, yCoord + tempX, zCoord + 1, TFCBlocks.logNatural, this.woodMetadata);
/* 181 */               if (tempX > 0) {
/*     */                 
/* 183 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord - 1, yCoord + tempX, zCoord + 1))
/* 184 */                   func_150516_a(world, xCoord - 1, yCoord + tempX, zCoord + 1, TFCBlocks.vine, 8); 
/* 185 */                 if (rand.nextInt(3) > 0 && world.func_147437_c(xCoord, yCoord + tempX, zCoord + 2))
/* 186 */                   func_150516_a(world, xCoord, yCoord + tempX, zCoord + 2, TFCBlocks.vine, 4); 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 191 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 195 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomHugeTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */