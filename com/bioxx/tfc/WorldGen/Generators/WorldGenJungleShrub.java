/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ public class WorldGenJungleShrub
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int meta;
/*    */   
/*    */   public WorldGenJungleShrub(int m) {
/* 18 */     this.meta = m;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/*    */     do {
/* 27 */       Block block = world.func_147439_a(x, y, z);
/* 28 */       if (!block.isLeaves((IBlockAccess)world, x, y, z) && !block.isAir((IBlockAccess)world, x, y, z)) {
/*    */         break;
/*    */       }
/*    */       
/* 32 */       --y;
/* 33 */     } while (y > 0);
/*    */     
/* 35 */     Block block1 = world.func_147439_a(x, y, z);
/*    */     
/* 37 */     if (TFC_Core.isSoil(block1)) {
/*    */       
/* 39 */       y++;
/* 40 */       func_150516_a(world, x, y, z, TFCBlocks.logNatural, this.meta);
/*    */       
/* 42 */       for (int l = y; l <= y + 2; l++) {
/*    */         
/* 44 */         int i1 = l - y;
/* 45 */         int j1 = 2 - i1;
/*    */         
/* 47 */         for (int k1 = x - j1; k1 <= x + j1; k1++) {
/*    */           
/* 49 */           int l1 = k1 - x;
/*    */           
/* 51 */           for (int i2 = z - j1; i2 <= z + j1; i2++) {
/*    */             
/* 53 */             int j2 = i2 - z;
/*    */             
/* 55 */             if ((Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0) && world.func_147439_a(k1, l, i2).canBeReplacedByLeaves((IBlockAccess)world, k1, l, i2))
/*    */             {
/* 57 */               func_150516_a(world, k1, l, i2, TFCBlocks.leaves, this.meta);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenJungleShrub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */