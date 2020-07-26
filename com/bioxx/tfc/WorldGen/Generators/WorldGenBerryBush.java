/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.Flora.BlockBerryBush;
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import com.bioxx.tfc.Food.FloraIndex;
/*    */ import com.bioxx.tfc.Food.FloraManager;
/*    */ import com.bioxx.tfc.TileEntities.TEBerryBush;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ public class WorldGenBerryBush
/*    */   extends WorldGenerator
/*    */ {
/*    */   private int meta;
/*    */   private int clusterSize;
/*    */   private int bushHeight;
/*    */   private int spawnRadius;
/* 26 */   private Block underBlock = Blocks.field_150350_a;
/*    */ 
/*    */   
/*    */   public WorldGenBerryBush(boolean flag, int m, int cluster, int height, int radius) {
/* 30 */     super(flag);
/* 31 */     this.meta = m;
/* 32 */     this.clusterSize = cluster;
/* 33 */     this.bushHeight = height;
/* 34 */     this.spawnRadius = radius;
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenBerryBush(boolean flag, int m, int cluster, int height, int radius, Block under) {
/* 39 */     this(flag, m, cluster, height, radius);
/* 40 */     this.underBlock = under;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 46 */     float temp = TFC_Climate.getBioTemperatureHeight(world, i, j, k);
/* 47 */     float rain = TFC_Climate.getRainfall(world, i, j, k);
/* 48 */     float evt = (TFC_Climate.getCacheManager(world).getEVTLayerAt(i, k)).floatdata1;
/*    */     
/* 50 */     FloraIndex index = FloraManager.getInstance().findMatchingIndex(((BlockBerryBush)TFCBlocks.berryBush).getType(this.meta));
/* 51 */     if (world.func_147437_c(i, j, k) && j < 250 && temp > index.minBioTemp && temp < index.maxBioTemp && rain >= index.minRain && rain <= index.maxRain && evt >= index.minEVT && evt <= index.maxEVT) {
/*    */ 
/*    */       
/* 54 */       int cluster = this.clusterSize + random.nextInt(this.clusterSize) - this.clusterSize / 2;
/* 55 */       short count = 0; short realCount;
/* 56 */       for (realCount = 0; count < cluster && realCount < this.spawnRadius * this.spawnRadius; realCount = (short)(realCount + 1)) {
/*    */         
/* 58 */         int x = random.nextInt(this.spawnRadius * 2);
/* 59 */         int z = random.nextInt(this.spawnRadius * 2);
/* 60 */         if (createBush(world, random, i - this.spawnRadius + x, world.func_72976_f(i - this.spawnRadius + x, k - this.spawnRadius + z), k - this.spawnRadius + z, index)) {
/* 61 */           count = (short)(count + 1);
/*    */         }
/*    */       } 
/*    */     } 
/* 65 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean createBush(World world, Random random, int i, int j, int k, FloraIndex fi) {
/* 70 */     Block id = world.func_147439_a(i, j - 1, k);
/* 71 */     if ((world.func_72937_j(i, j, k) || world.func_72957_l(i, j, k) > 8) && ((TFC_Core.isSoil(id) && this.underBlock == Blocks.field_150350_a) || id == this.underBlock || (TFC_Core.isGrass(this.underBlock) && id == TFC_Core.getTypeForSoil(this.underBlock)))) {
/*    */       
/* 73 */       for (int h = 0; h < this.bushHeight && random.nextBoolean(); h++) {
/*    */         
/* 75 */         world.func_147465_d(i, j + h, k, TFCBlocks.berryBush, this.meta, 2);
/* 76 */         if (TFC_Time.getSeasonAdjustedMonth(k) > fi.harvestStart && TFC_Time.getSeasonAdjustedMonth(k) < fi.harvestFinish + fi.fruitHangTime) {
/*    */           
/* 78 */           TileEntity te = world.func_147438_o(i, j + h, k);
/* 79 */           if (te instanceof TEBerryBush)
/*    */           {
/* 81 */             ((TEBerryBush)te).hasFruit = true;
/*    */           }
/*    */         } 
/*    */       } 
/* 85 */       return true;
/*    */     } 
/* 87 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenBerryBush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */