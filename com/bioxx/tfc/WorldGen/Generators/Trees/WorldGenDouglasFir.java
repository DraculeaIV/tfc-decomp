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
/*     */ 
/*     */ public class WorldGenDouglasFir
/*     */   extends WorldGenerator
/*     */ {
/*     */   private boolean tall;
/*     */   private final int metaID;
/*     */   
/*     */   public WorldGenDouglasFir(boolean par1, int m, boolean t) {
/*  19 */     super(par1);
/*  20 */     this.metaID = m;
/*  21 */     this.tall = t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random rand, int par3, int par4, int par5) {
/*  27 */     int i = rand.nextInt(10) + 10;
/*  28 */     if (rand.nextInt(20) == 0)
/*  29 */       this.tall = true; 
/*  30 */     if (this.tall) {
/*  31 */       i += rand.nextInt(10);
/*     */     }
/*  33 */     if (par4 < 1 || par4 + i + 1 > 256) {
/*  34 */       return false;
/*     */     }
/*  36 */     boolean flag = true;
/*  37 */     for (int j = par4; j <= par4 + 1 + i; j++) {
/*     */       
/*  39 */       byte byte0 = 1;
/*     */       
/*  41 */       if (j == par4) {
/*  42 */         byte0 = 0;
/*     */       }
/*  44 */       if (j >= par4 + 1 + i - 2) {
/*  45 */         byte0 = 2;
/*     */       }
/*  47 */       for (int l = par3 - byte0; l <= par3 + byte0 && flag; l++) {
/*     */         
/*  49 */         for (int j1 = par5 - byte0; j1 <= par5 + byte0 && flag; j1++) {
/*     */           
/*  51 */           if (j >= 0 && j < 256) {
/*     */             
/*  53 */             Block j2 = world.func_147439_a(l, j, j1);
/*  54 */             if (!j2.isAir((IBlockAccess)world, l, j, j1) && !j2.isReplaceable((IBlockAccess)world, l, j, j1))
/*     */             {
/*  56 */               flag = false;
/*     */             }
/*     */           }
/*     */           else {
/*     */             
/*  61 */             flag = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  67 */     if (!flag) {
/*  68 */       return false;
/*     */     }
/*  70 */     if (!TFC_Core.isSoil(world.func_147439_a(par3, par4 - 1, par5)) || par4 >= 256 - i - 1) {
/*  71 */       return false;
/*     */     }
/*  73 */     for (int k1 = par4 + i / 3 - 1; k1 <= par4 + i - 1; k1++) {
/*     */       
/*  75 */       int k2 = k1 - par4 + i;
/*  76 */       int z = i;
/*  77 */       if (i > 20)
/*  78 */         z = 20; 
/*  79 */       int x = z / 10 + 1;
/*  80 */       if (k1 - par4 > i / 2 || k1 - par4 - i / 3 + 2 < 3)
/*  81 */         x--; 
/*  82 */       if (par4 + i - k1 < 4) {
/*  83 */         x = 1;
/*     */       }
/*  85 */       for (int l3 = par3 - x; l3 <= par3 + x; l3++) {
/*     */         
/*  87 */         int j4 = l3 - par3;
/*  88 */         for (int l4 = par5 - x; l4 <= par5 + x; l4++) {
/*     */           
/*  90 */           int i5 = l4 - par5;
/*  91 */           if ((Math.abs(j4) != 0 || (Math.abs(i5) != 0 && k2 != 0)) && (
/*  92 */             Math.abs(j4) + Math.abs(i5) != x * 2 || (k1 - par4 > i / 2 && k1 - par4 < 4 * i / 5) || k1 - par4 - i / 3 + 2 == 2) && rand
/*     */ 
/*     */             
/*  95 */             .nextInt(12) != 0 && world.func_147437_c(l3, k1, l4))
/*     */           {
/*  97 */             func_150516_a(world, l3, k1, l4, TFCBlocks.leaves, this.metaID);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 102 */     func_150516_a(world, par3, par4 + i, par5, TFCBlocks.leaves, this.metaID);
/* 103 */     for (int l1 = 0; l1 < i; l1++)
/*     */     {
/* 105 */       func_150516_a(world, par3, par4 + l1, par5, TFCBlocks.logNatural, this.metaID);
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenDouglasFir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */