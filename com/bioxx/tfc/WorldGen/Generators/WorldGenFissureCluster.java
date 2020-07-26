/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.common.IWorldGenerator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenFissureCluster
/*    */   implements IWorldGenerator
/*    */ {
/*    */   private Random rand;
/* 15 */   private int waterRarity = 225;
/*    */   
/* 17 */   private WorldGenFissure fissureGenWater = new WorldGenFissure(TFCBlocks.freshWater);
/* 18 */   private WorldGenFissure fissureGenLava = new WorldGenFissure(TFCBlocks.lava);
/* 19 */   private WorldGenFissure fissureGenAir = new WorldGenFissure(null);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
/* 25 */     this.rand = random;
/* 26 */     chunkX *= 16;
/* 27 */     chunkZ *= 16;
/*    */     
/* 29 */     int startX = chunkX + random.nextInt(16) + 8;
/* 30 */     int startZ = chunkZ + random.nextInt(16) + 8;
/*    */     
/* 32 */     if (this.rand.nextInt(this.waterRarity) == 0) {
/*    */       
/* 34 */       int num = 3 + this.rand.nextInt(10);
/* 35 */       for (int i = 0; i < num; i++) {
/*    */         
/* 37 */         int x = startX - 30 + random.nextInt(60);
/* 38 */         int z = startZ - 30 + random.nextInt(60);
/* 39 */         int y = world.func_72825_h(x, z) - 1;
/* 40 */         if (this.rand.nextInt(10) == 0) {
/* 41 */           this.fissureGenAir.generate(world, this.rand, x, y, z);
/*    */         } else {
/* 43 */           this.fissureGenWater.generate(world, this.rand, x, y, z);
/*    */         } 
/*    */       } 
/* 46 */     } else if (this.rand.nextInt(400) == 0) {
/*    */       
/* 48 */       int num = 3 + this.rand.nextInt(10);
/* 49 */       for (int i = 0; i < num; i++) {
/*    */         
/* 51 */         int x = startX - 30 + random.nextInt(60);
/* 52 */         int z = startZ - 30 + random.nextInt(60);
/* 53 */         int y = world.func_72825_h(x, z) - 1;
/*    */         
/* 55 */         if (this.rand.nextInt(10) == 0) {
/* 56 */           this.fissureGenAir.generate(world, this.rand, x, y, z);
/*    */         } else {
/* 58 */           this.fissureGenLava.generate(world, this.rand, x, y, z);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenFissureCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */