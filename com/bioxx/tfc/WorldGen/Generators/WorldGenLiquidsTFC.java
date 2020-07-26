/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenLiquidsTFC
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final Block liquidBlock;
/*    */   
/*    */   public WorldGenLiquidsTFC(Block block) {
/* 17 */     this.liquidBlock = block;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 23 */     if (world.func_147439_a(i, j + 1, k) != TFCBlocks.stoneIgIn && world.func_147439_a(i, j + 1, k) != TFCBlocks.stoneSed && world
/* 24 */       .func_147439_a(i, j + 1, k) != TFCBlocks.stoneIgEx && world.func_147439_a(i, j + 1, k) != TFCBlocks.stoneMM)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     if (world.func_147439_a(i, j - 1, k) != TFCBlocks.stoneIgIn && world.func_147439_a(i, j - 1, k) != TFCBlocks.stoneSed && world
/* 29 */       .func_147439_a(i, j - 1, k) != TFCBlocks.stoneIgEx && world.func_147439_a(i, j - 1, k) != TFCBlocks.stoneMM)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!world.func_147437_c(i, j, k) && world.func_147439_a(i, j, k) != TFCBlocks.stoneIgIn && world.func_147439_a(i, j, k) != TFCBlocks.stoneSed && world
/* 34 */       .func_147439_a(i, j, k) != TFCBlocks.stoneIgEx && world.func_147439_a(i, j, k) != TFCBlocks.stoneMM)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     int l = 0;
/* 40 */     if (world.func_147439_a(i - 1, j, k) == TFCBlocks.stoneIgIn && world.func_147439_a(i - 1, j, k) == TFCBlocks.stoneSed && world
/* 41 */       .func_147439_a(i - 1, j, k) == TFCBlocks.stoneIgEx && world.func_147439_a(i - 1, j, k) == TFCBlocks.stoneMM)
/*    */     {
/* 43 */       l++;
/*    */     }
/* 45 */     if (world.func_147439_a(i + 1, j, k) == TFCBlocks.stoneIgIn && world.func_147439_a(i + 1, j, k) == TFCBlocks.stoneSed && world
/* 46 */       .func_147439_a(i + 1, j, k) == TFCBlocks.stoneIgEx && world.func_147439_a(i + 1, j, k) == TFCBlocks.stoneMM)
/*    */     {
/* 48 */       l++;
/*    */     }
/* 50 */     if (world.func_147439_a(i, j, k - 1) == TFCBlocks.stoneIgIn && world.func_147439_a(i, j, k - 1) == TFCBlocks.stoneSed && world
/* 51 */       .func_147439_a(i, j, k - 1) == TFCBlocks.stoneIgEx && world.func_147439_a(i, j, k - 1) == TFCBlocks.stoneMM)
/*    */     {
/* 53 */       l++;
/*    */     }
/* 55 */     if (world.func_147439_a(i, j, k + 1) == TFCBlocks.stoneIgIn && world.func_147439_a(i, j, k + 1) == TFCBlocks.stoneSed && world
/* 56 */       .func_147439_a(i, j, k + 1) == TFCBlocks.stoneIgEx && world.func_147439_a(i, j, k + 1) == TFCBlocks.stoneMM)
/*    */     {
/* 58 */       l++;
/*    */     }
/*    */     
/* 61 */     int i1 = 0;
/* 62 */     if (world.func_147437_c(i - 1, j, k))
/* 63 */       i1++; 
/* 64 */     if (world.func_147437_c(i + 1, j, k))
/* 65 */       i1++; 
/* 66 */     if (world.func_147437_c(i, j, k - 1))
/* 67 */       i1++; 
/* 68 */     if (world.func_147437_c(i, j, k + 1)) {
/* 69 */       i1++;
/*    */     }
/* 71 */     if (l == 3 && i1 == 1) {
/*    */       
/* 73 */       world.func_147465_d(i, j, k, this.liquidBlock, 0, 2);
/* 74 */       world.field_72999_e = true;
/* 75 */       this.liquidBlock.func_149674_a(world, i, j, k, random);
/* 76 */       world.field_72999_e = false;
/*    */     } 
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenLiquidsTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */