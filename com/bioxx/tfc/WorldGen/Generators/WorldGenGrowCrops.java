/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import com.bioxx.tfc.Food.CropIndex;
/*    */ import com.bioxx.tfc.Food.CropManager;
/*    */ import com.bioxx.tfc.TileEntities.TECrop;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.common.IWorldGenerator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenGrowCrops
/*    */   implements IWorldGenerator
/*    */ {
/*    */   private final int cropBlockId;
/*    */   
/*    */   public WorldGenGrowCrops(int par1) {
/* 25 */     this.cropBlockId = par1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void generate(World world, Random rand, int x, int z, int numToGen) {
/* 30 */     int i = x, j = 150, k = z;
/*    */ 
/*    */ 
/*    */     
/* 34 */     for (int c = 0; c < numToGen; c++) {
/*    */       
/* 36 */       i = x - 8 + rand.nextInt(16);
/* 37 */       k = z - 8 + rand.nextInt(16);
/* 38 */       j = world.func_72825_h(i, k);
/* 39 */       CropIndex crop = CropManager.getInstance().getCropFromId(this.cropBlockId);
/*    */       
/* 41 */       if (crop != null) {
/*    */         
/* 43 */         float temp = TFC_Climate.getHeightAdjustedTempSpecificDay(world, TFC_Time.getTotalDays(), i, j, k);
/* 44 */         int month = TFC_Time.getSeasonAdjustedMonth(k);
/*    */         
/* 46 */         if (temp > crop.minAliveTemp && month > 0 && month <= 6) {
/*    */           
/* 48 */           Block b = world.func_147439_a(i, j, k);
/* 49 */           if (TFCBlocks.crops.func_149718_j(world, i, j, k) && (b.isAir((IBlockAccess)world, i, j, k) || b == TFCBlocks.tallGrass))
/*    */           {
/* 51 */             if (world.func_147465_d(i, j, k, TFCBlocks.crops, 0, 2)) {
/*    */               
/* 53 */               TECrop te = (TECrop)world.func_147438_o(i, j, k);
/* 54 */               if (te != null) {
/*    */                 
/* 56 */                 te.cropId = this.cropBlockId;
/* 57 */                 float gt = Math.max((crop.growthTime / TFC_Time.daysInMonth), 0.01F);
/* 58 */                 float mg = Math.min(month / gt, 1.0F) * (0.75F + rand.nextFloat() * 0.25F);
/* 59 */                 float growth = Math.min(crop.numGrowthStages * mg, crop.numGrowthStages);
/* 60 */                 te.growth = growth;
/*    */               } 
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void generate(Random par2Random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenGrowCrops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */