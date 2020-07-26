/*    */ package com.bioxx.tfc.WorldGen.Generators.Trees;
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
/*    */ public class WorldGenCustomTallTrees
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int treeId;
/*    */   
/*    */   public WorldGenCustomTallTrees(boolean flag, int id) {
/* 18 */     super(flag);
/* 19 */     this.treeId = id;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int xCoord, int yCoord, int zCoord) {
/* 25 */     int height = random.nextInt(5) + 6;
/* 26 */     if (yCoord < 1 || yCoord + height + 1 > world.func_72800_K())
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     boolean flag = true; int y;
/* 32 */     for (y = yCoord; y <= yCoord + 1 + height; y++) {
/*    */       
/* 34 */       byte byte0 = 1;
/* 35 */       if (y == yCoord)
/*    */       {
/* 37 */         byte0 = 0;
/*    */       }
/* 39 */       if (y >= yCoord + 1 + height - 2)
/*    */       {
/* 41 */         byte0 = 2;
/*    */       }
/* 43 */       for (int x = xCoord - byte0; x <= xCoord + byte0 && flag; x++) {
/*    */         
/* 45 */         for (int z = zCoord - byte0; z <= zCoord + byte0 && flag; z++) {
/*    */           
/* 47 */           if (y >= 0 && y + height < world.func_72800_K()) {
/*    */             
/* 49 */             Block j3 = world.func_147439_a(x, y, z);
/* 50 */             if (!j3.isAir((IBlockAccess)world, x, y, z) && !j3.canBeReplacedByLeaves((IBlockAccess)world, x, y, z)) {
/* 51 */               flag = false;
/*    */             }
/*    */           } else {
/*    */             
/* 55 */             flag = false;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 61 */     if (!flag) {
/* 62 */       return false;
/*    */     }
/* 64 */     if (!TFC_Core.isSoil(world.func_147439_a(xCoord, yCoord - 1, zCoord)) || yCoord >= world.func_72800_K() - height - 1) {
/* 65 */       return false;
/*    */     }
/* 67 */     for (y = yCoord - 3 + height; y <= yCoord + height; y++) {
/*    */       
/* 69 */       int j2 = y - yCoord + height;
/* 70 */       int i3 = 1 - j2 / 2;
/* 71 */       for (int x = xCoord - i3; x <= xCoord + i3; x++) {
/*    */         
/* 73 */         int l3 = x - xCoord;
/* 74 */         for (int z = zCoord - i3; z <= zCoord + i3; z++) {
/*    */           
/* 76 */           int j4 = z - zCoord;
/* 77 */           if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || (random.nextInt(2) != 0 && j2 != 0)) && world.func_147437_c(x, y, z))
/*    */           {
/* 79 */             func_150516_a(world, x, y, z, TFCBlocks.leaves, this.treeId);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 85 */     for (int l1 = 0; l1 < height; l1++)
/*    */     {
/* 87 */       func_150516_a(world, xCoord, yCoord + l1, zCoord, TFCBlocks.logNatural, this.treeId);
/*    */     }
/*    */     
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomTallTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */