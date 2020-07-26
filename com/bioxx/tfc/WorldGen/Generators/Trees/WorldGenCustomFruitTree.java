/*    */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenCustomFruitTree
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final Block leavesBlock;
/*    */   private final int metaId;
/*    */   
/*    */   public WorldGenCustomFruitTree(boolean flag, Block block, int meta) {
/* 20 */     super(flag);
/* 21 */     this.leavesBlock = block;
/* 22 */     this.metaId = meta;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int i, int j, int k) {
/* 28 */     float temp = TFC_Climate.getBioTemperatureHeight(world, i, j, k);
/* 29 */     float rain = TFC_Climate.getRainfall(world, i, j, k);
/* 30 */     if (world.func_147437_c(i, j, k) && j < 250 && temp > 10.0F && temp < 25.0F && rain >= 500.0F)
/* 31 */       gen(world, random, i, j, k); 
/* 32 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void gen(World world, Random random, int i, int j, int k) {
/* 37 */     world.func_147465_d(i, j, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/* 38 */     ((TEFruitTreeWood)world.func_147438_o(i, j, k)).setTrunk(true);
/* 39 */     ((TEFruitTreeWood)world.func_147438_o(i, j, k)).setHeight(0);
/* 40 */     ((TEFruitTreeWood)world.func_147438_o(i, j, k)).initBirth();
/*    */     
/* 42 */     if (world.func_147437_c(i, j + 1, k)) {
/*    */       
/* 44 */       world.func_147465_d(i, j + 1, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/* 45 */       ((TEFruitTreeWood)world.func_147438_o(i, j + 1, k)).setTrunk(true);
/* 46 */       ((TEFruitTreeWood)world.func_147438_o(i, j + 1, k)).setHeight(1);
/* 47 */       ((TEFruitTreeWood)world.func_147438_o(i, j + 1, k)).initBirth();
/*    */       
/* 49 */       if (world.func_147437_c(i, j + 2, k)) {
/*    */         
/* 51 */         world.func_147465_d(i, j + 2, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/* 52 */         ((TEFruitTreeWood)world.func_147438_o(i, j + 2, k)).setTrunk(true);
/* 53 */         ((TEFruitTreeWood)world.func_147438_o(i, j + 2, k)).setHeight(2);
/* 54 */         ((TEFruitTreeWood)world.func_147438_o(i, j + 2, k)).initBirth();
/* 55 */         surroundWithLeaves(world, i, j + 2, k);
/*    */         
/* 57 */         if (world.func_147437_c(i + 1, j + 2, k) || world.func_147439_a(i + 1, j + 2, k) == this.leavesBlock)
/*    */         {
/* 59 */           world.func_147465_d(i + 1, j + 2, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/*    */         }
/* 61 */         if (world.func_147437_c(i - 1, j + 2, k) || world.func_147439_a(i - 1, j + 2, k - 1) == this.leavesBlock)
/*    */         {
/* 63 */           world.func_147465_d(i - 1, j + 2, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/*    */         }
/* 65 */         if (world.func_147437_c(i, j + 2, k + 1) || world.func_147439_a(i, j + 2, k + 1) == this.leavesBlock)
/*    */         {
/* 67 */           world.func_147465_d(i, j + 2, k + 1, TFCBlocks.fruitTreeWood, this.metaId, 2);
/*    */         }
/* 69 */         if (world.func_147437_c(i, j + 2, k - 1) || world.func_147439_a(i, j + 2, k - 1) == this.leavesBlock)
/*    */         {
/* 71 */           world.func_147465_d(i, j + 2, k - 1, TFCBlocks.fruitTreeWood, this.metaId, 2);
/*    */         }
/*    */         
/* 74 */         if (world.func_147437_c(i, j + 3, k) || world.func_147439_a(i, j + 3, k) == this.leavesBlock) {
/*    */           
/* 76 */           world.func_147465_d(i, j + 3, k, TFCBlocks.fruitTreeWood, this.metaId, 2);
/* 77 */           ((TEFruitTreeWood)world.func_147438_o(i, j + 3, k)).setTrunk(true);
/* 78 */           ((TEFruitTreeWood)world.func_147438_o(i, j + 3, k)).setHeight(3);
/* 79 */           ((TEFruitTreeWood)world.func_147438_o(i, j + 3, k)).initBirth();
/* 80 */           if (world.func_147437_c(i, j + 4, k)) {
/* 81 */             world.func_147465_d(i, j + 4, k, this.leavesBlock, this.metaId & 0x7, 2);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void surroundWithLeaves(World world, int i, int j, int k) {
/* 89 */     for (int y = 1; y >= 0; y--) {
/*    */       
/* 91 */       for (int x = 1; x >= -1; x--) {
/*    */         
/* 93 */         for (int z = 1; z >= -1; z--) {
/*    */           
/* 95 */           if (world.func_147437_c(i + x, j + y, k + z))
/* 96 */             world.func_147465_d(i + x, j + y, k + z, this.leavesBlock, this.metaId & 0x7, 2); 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomFruitTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */