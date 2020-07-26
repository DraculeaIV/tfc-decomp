/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.common.IWorldGenerator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenCaveDecor
/*    */   implements IWorldGenerator
/*    */ {
/*    */   public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/* 23 */     chunkX *= 16;
/* 24 */     chunkZ *= 16;
/* 25 */     for (int xCoord = 0; xCoord < 16; xCoord++) {
/*    */       
/* 27 */       for (int zCoord = 0; zCoord < 16; zCoord++) {
/*    */         
/* 29 */         for (int y = 127; y >= 0; y--) {
/*    */           
/* 31 */           int x = chunkX + xCoord;
/* 32 */           int z = chunkZ + zCoord;
/* 33 */           if (rand.nextInt(35) == 0 && createStalactite(world, rand, x, y, z)) {
/*    */             
/* 35 */             if (!createStalagmite(world, rand, x, y - 5, z)) {
/* 36 */               createStalagmite(world, rand, x, y - 6, z);
/*    */             }
/* 38 */           } else if (rand.nextInt(35) == 0) {
/*    */             
/* 40 */             createStalagmite(world, rand, x, y, z);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean createStalactite(World world, Random rand, int x, int y, int z) {
/* 49 */     if (!world.field_72995_K && y > 8 && world.func_147437_c(x, y, z) && TFC_Core.isRawStone(world, x, y + 1, z))
/*    */     {
/* 51 */       if (world.func_147437_c(x, y - 1, z) && world.func_147437_c(x, y - 2, z) && world.func_147437_c(x, y - 3, z)) {
/*    */         
/* 53 */         world.func_147465_d(x, y, z, TFCBlocks.stoneStalac, 0, 2);
/* 54 */         world.func_147465_d(x, y - 1, z, TFCBlocks.stoneStalac, 0, 2);
/* 55 */         world.func_147465_d(x, y - 2, z, TFCBlocks.stoneStalac, 0, 2);
/* 56 */         return true;
/*    */       } 
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean createStalagmite(World world, Random rand, int x, int y, int z) {
/* 64 */     if (!world.field_72995_K && y < 128 && world.func_147437_c(x, y, z) && TFC_Core.isRawStone(world, x, y - 1, z) && !world.func_72937_j(x, y, z))
/*    */     {
/* 66 */       if (world.func_147437_c(x, y + 1, z) && world.func_147437_c(x, y + 2, z) && world.func_147437_c(x, y + 3, z)) {
/*    */         
/* 68 */         world.func_147465_d(x, y, z, TFCBlocks.stoneStalac, 8, 2);
/* 69 */         world.func_147465_d(x, y + 1, z, TFCBlocks.stoneStalac, 8, 2);
/* 70 */         world.func_147465_d(x, y + 2, z, TFCBlocks.stoneStalac, 8, 2);
/* 71 */         return true;
/*    */       } 
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenCaveDecor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */