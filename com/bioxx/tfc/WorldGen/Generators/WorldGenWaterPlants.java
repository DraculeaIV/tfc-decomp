/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEWaterPlant;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenWaterPlants
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final Block plantBlock;
/*    */   
/*    */   public WorldGenWaterPlants(Block par1) {
/* 20 */     this.plantBlock = par1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/* 26 */     if (TFC_Core.isWater(world.func_147439_a(x, y, z)) && world.func_147437_c(x, y + 1, z)) {
/*    */ 
/*    */       
/* 29 */       int depthCounter = 1;
/*    */       
/* 31 */       boolean isTooDeep = false;
/* 32 */       boolean isFreshWater = TFC_Core.isFreshWater(world.func_147439_a(x, y, z));
/* 33 */       int maxDepth = !isFreshWater ? 10 : 4;
/*    */ 
/*    */       
/* 36 */       while (y > 0 && TFC_Core.isWater(world.func_147439_a(x, --y, z)) && !isTooDeep) {
/*    */         
/* 38 */         depthCounter++;
/* 39 */         if (depthCounter > maxDepth)
/*    */         {
/*    */           
/* 42 */           isTooDeep = true;
/*    */         }
/*    */       } 
/* 45 */       if (!isTooDeep && depthCounter > 0) {
/*    */         
/* 47 */         int meta = world.func_72805_g(x, y, z);
/* 48 */         Block oldBlock = world.func_147439_a(x, y, z);
/* 49 */         if (TFC_Core.isSoilOrGravel(oldBlock) || TFC_Core.isSand(oldBlock)) {
/*    */           
/* 51 */           world.func_147465_d(x, y, z, this.plantBlock, meta, 2);
/* 52 */           TileEntity te = world.func_147438_o(x, y, z);
/* 53 */           if (te instanceof TEWaterPlant) {
/* 54 */             ((TEWaterPlant)te).setBlock(oldBlock);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenWaterPlants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */