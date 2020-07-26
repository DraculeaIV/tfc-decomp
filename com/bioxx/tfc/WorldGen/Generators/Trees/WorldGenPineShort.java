/*     */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class WorldGenPineShort
/*     */   extends WorldGenerator {
/*     */   private final Block blockLeaf;
/*     */   private final Block blockWood;
/*     */   private final int metaLeaf;
/*     */   private final int metaWood;
/*     */   
/*     */   public WorldGenPineShort(boolean par1, int id) {
/*  19 */     super(par1);
/*  20 */     this.metaLeaf = id;
/*  21 */     this.blockLeaf = TFCBlocks.leaves;
/*  22 */     this.metaWood = id;
/*  23 */     this.blockWood = TFCBlocks.logNatural;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random par2Random, int xCoord, int yCoord, int zCoord) {
/*  29 */     int treeHeight = par2Random.nextInt(4) + 6;
/*  30 */     int var7 = 1 + par2Random.nextInt(2);
/*  31 */     int var8 = treeHeight - var7;
/*  32 */     int var9 = 2 + par2Random.nextInt(2);
/*  33 */     boolean isValid = true;
/*     */     
/*  35 */     if (yCoord >= 1 && yCoord + treeHeight + 1 <= 256) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  41 */       for (int y = yCoord; y <= yCoord + 1 + treeHeight && isValid; y++) {
/*     */         int var21;
/*  43 */         if (y - yCoord < var7) {
/*  44 */           var21 = 0;
/*     */         } else {
/*  46 */           var21 = var9;
/*     */         } 
/*  48 */         for (int x = xCoord - var21; x <= xCoord + var21 && isValid; x++) {
/*     */           
/*  50 */           for (int z = zCoord - var21; z <= zCoord + var21 && isValid; z++) {
/*     */             
/*  52 */             if (y >= 0 && y < 256) {
/*     */               
/*  54 */               Block block1 = world.func_147439_a(x, y, z);
/*  55 */               if (!block1.isAir((IBlockAccess)world, x, y, z) && !block1.isLeaves((IBlockAccess)world, x, y, z) && !block1.isReplaceable((IBlockAccess)world, x, y, z)) {
/*  56 */                 isValid = false;
/*     */               }
/*     */             } else {
/*     */               
/*  60 */               isValid = false;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  66 */       if (!isValid)
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  72 */       Block block = world.func_147439_a(xCoord, yCoord - 1, zCoord);
/*     */       
/*  74 */       if (TFC_Core.isSoil(block) && yCoord < world.func_72940_L() - treeHeight - 1) {
/*     */         
/*  76 */         Block soil = TFC_Core.getTypeForSoil(block);
/*  77 */         int soilMeta = world.func_72805_g(xCoord, yCoord - 1, zCoord);
/*     */         
/*  79 */         func_150516_a(world, xCoord, yCoord - 1, zCoord, soil, soilMeta);
/*  80 */         int var21 = par2Random.nextInt(2);
/*  81 */         int i = 1;
/*  82 */         byte var22 = 0;
/*     */ 
/*     */ 
/*     */         
/*  86 */         for (int var15 = 0; var15 <= var8; var15++) {
/*     */           
/*  88 */           int k = yCoord + treeHeight - var15;
/*  89 */           for (int x = xCoord - var21; x <= xCoord + var21; x++) {
/*     */             
/*  91 */             int var18 = x - xCoord;
/*  92 */             for (int z = zCoord - var21; z <= zCoord + var21; z++) {
/*     */               
/*  94 */               int var20 = z - zCoord;
/*  95 */               block = world.func_147439_a(x, k, z);
/*  96 */               if ((Math.abs(var18) != var21 || Math.abs(var20) != var21 || var21 <= 0) && (block == null || block
/*  97 */                 .canBeReplacedByLeaves((IBlockAccess)world, x, k, z)))
/*     */               {
/*  99 */                 func_150516_a(world, x, k, z, this.blockLeaf, this.metaLeaf);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 104 */           if (var21 >= i) {
/*     */             
/* 106 */             var21 = var22;
/* 107 */             var22 = 1;
/* 108 */             i++;
/* 109 */             if (i > var9) {
/* 110 */               i = var9;
/*     */             }
/*     */           } else {
/*     */             
/* 114 */             var21++;
/*     */           } 
/*     */         } 
/*     */         
/* 118 */         for (int j = 0; j < treeHeight - 1; j++)
/*     */         {
/* 120 */           func_150516_a(world, xCoord, yCoord + j, zCoord, this.blockWood, this.metaWood);
/*     */         }
/* 122 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 126 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenPineShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */