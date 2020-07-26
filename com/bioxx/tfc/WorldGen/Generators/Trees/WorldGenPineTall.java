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
/*     */ public class WorldGenPineTall extends WorldGenerator {
/*     */   private final Block blockLeaf;
/*     */   private final Block blockWood;
/*     */   private final int metaLeaf;
/*     */   private final int metaWood;
/*     */   
/*     */   public WorldGenPineTall(int id) {
/*  18 */     this.metaLeaf = id;
/*  19 */     this.blockLeaf = TFCBlocks.leaves;
/*  20 */     this.metaWood = id;
/*  21 */     this.blockWood = TFCBlocks.logNatural;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random par2Random, int xCoord, int yCoord, int zCoord) {
/*  27 */     int treeHeight = par2Random.nextInt(5) + 7;
/*  28 */     int var7 = treeHeight - par2Random.nextInt(2) - 3;
/*  29 */     int var8 = treeHeight - var7;
/*  30 */     int var9 = 1 + par2Random.nextInt(var8 + 1);
/*  31 */     boolean isValid = true;
/*     */     
/*  33 */     if (yCoord >= 1 && yCoord + treeHeight + 1 <= 256) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  42 */       for (int y = yCoord; y <= yCoord + 1 + treeHeight && isValid; y++) {
/*     */         int var18;
/*  44 */         if (y - yCoord < var7) {
/*  45 */           var18 = 0;
/*     */         } else {
/*  47 */           var18 = var9;
/*     */         } 
/*  49 */         for (int x = xCoord - var18; x <= xCoord + var18 && isValid; x++) {
/*     */           
/*  51 */           for (int z = zCoord - var18; z <= zCoord + var18 && isValid; z++) {
/*     */             
/*  53 */             if (y >= 0 && y < 256) {
/*     */               
/*  55 */               Block block1 = world.func_147439_a(x, y, z);
/*  56 */               if (!block1.isAir((IBlockAccess)world, x, y, z) && !block1.isLeaves((IBlockAccess)world, x, y, z) && !block1.isReplaceable((IBlockAccess)world, x, y, z)) {
/*  57 */                 isValid = false;
/*     */               }
/*     */             } else {
/*     */               
/*  61 */               isValid = false;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  67 */       if (!isValid)
/*     */       {
/*  69 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  73 */       Block block = world.func_147439_a(xCoord, yCoord - 1, zCoord);
/*     */       
/*  75 */       if (TFC_Core.isSoil(block) && yCoord < world.func_72940_L() - treeHeight - 1) {
/*     */         
/*  77 */         Block soil = TFC_Core.getTypeForSoil(block);
/*  78 */         int soilMeta = world.func_72805_g(xCoord, yCoord - 1, zCoord);
/*     */         
/*  80 */         func_150516_a(world, xCoord, yCoord - 1, zCoord, soil, soilMeta);
/*  81 */         int var18 = 0;
/*     */         int x;
/*  83 */         for (x = yCoord + treeHeight; x >= yCoord + var7; x--) {
/*     */           
/*  85 */           for (int z = xCoord - var18; z <= xCoord + var18; z++) {
/*     */             
/*  87 */             int var15 = z - xCoord;
/*     */             
/*  89 */             for (int var16 = zCoord - var18; var16 <= zCoord + var18; var16++) {
/*     */               
/*  91 */               int var17 = var16 - zCoord;
/*  92 */               block = world.func_147439_a(z, x, var16);
/*  93 */               if ((Math.abs(var15) != var18 || Math.abs(var17) != var18 || var18 <= 0) && (block == null || block
/*  94 */                 .canBeReplacedByLeaves((IBlockAccess)world, z, x, var16)))
/*     */               {
/*  96 */                 func_150516_a(world, z, x, var16, this.blockLeaf, this.metaLeaf);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 101 */           if (var18 >= 1 && x == yCoord + var7 + 1) {
/* 102 */             var18--;
/* 103 */           } else if (var18 < var9) {
/* 104 */             var18++;
/*     */           } 
/*     */         } 
/* 107 */         for (x = 0; x < treeHeight - 1; x++)
/*     */         {
/* 109 */           func_150516_a(world, xCoord, yCoord + x, zCoord, this.blockWood, this.metaWood);
/*     */         }
/* 111 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 115 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenPineTall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */