/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.Flora.BlockFlower;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenFlowers
/*    */ {
/*    */   public static void generate(World world, Random random, int chunkX, int chunkZ, int flowersPerChunk) {
/* 14 */     int flowerType = (new Random(world.func_72905_C() + (((chunkX >> 7) - (chunkZ >> 7)) * (chunkZ >> 7)))).nextInt(14);
/* 15 */     BlockFlower plantBlock = (BlockFlower)TFCBlocks.flowers;
/* 16 */     if (flowerType > 5) {
/*    */       
/* 18 */       plantBlock = (BlockFlower)TFCBlocks.flowers2;
/* 19 */       flowerType -= 5;
/*    */     } 
/* 21 */     if (random.nextInt(flowersPerChunk) != 0) {
/*    */       return;
/*    */     }
/* 24 */     int xCoord = chunkX + random.nextInt(16);
/* 25 */     int zCoord = chunkZ + random.nextInt(16);
/* 26 */     int yCoord = world.func_72825_h(xCoord, zCoord);
/* 27 */     for (int i = 0; i < flowersPerChunk; i++) {
/*    */       
/* 29 */       int xx = xCoord - 4 + random.nextInt(8);
/* 30 */       int zz = zCoord - 4 + random.nextInt(8);
/* 31 */       int yy = yCoord;
/*    */       
/* 33 */       if (world.func_147437_c(xx, yy, zz) && plantBlock.func_149718_j(world, xx, yy, zz))
/*    */       {
/* 35 */         if (plantBlock.canGrowConditions(world, xx, yy, zz, flowerType))
/* 36 */           world.func_147465_d(xx, yy, zz, (Block)plantBlock, flowerType, 2); 
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenFlowers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */