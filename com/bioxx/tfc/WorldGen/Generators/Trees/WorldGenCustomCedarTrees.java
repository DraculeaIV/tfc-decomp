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
/*    */ public class WorldGenCustomCedarTrees
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int treeId;
/*    */   
/*    */   public WorldGenCustomCedarTrees(boolean flag, int id) {
/* 18 */     super(flag);
/* 19 */     this.treeId = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int xCoord, int yCoord, int zCoord) {
/* 24 */     int treeHeight = random.nextInt(6) + 3;
/* 25 */     if (yCoord < 1 || yCoord + treeHeight + 1 > world.func_72800_K()) {
/* 26 */       return false;
/*    */     }
/* 28 */     boolean flag = true;
/* 29 */     for (int y = yCoord; y <= yCoord + 1 + treeHeight; y++) {
/*    */       
/* 31 */       byte byte0 = 1;
/* 32 */       if (y == yCoord)
/* 33 */         byte0 = 0; 
/* 34 */       if (y >= yCoord + 1 + treeHeight - 2) {
/* 35 */         byte0 = 2;
/*    */       }
/* 37 */       for (int x = xCoord - byte0; x <= xCoord + byte0 && flag; x++) {
/*    */         
/* 39 */         for (int z = zCoord - byte0; z <= zCoord + byte0 && flag; z++) {
/*    */           
/* 41 */           if (y >= 0 && y < world.func_72800_K()) {
/*    */             
/* 43 */             Block j3 = world.func_147439_a(x, y, z);
/* 44 */             if (!j3.isAir((IBlockAccess)world, x, y, z) && !j3.canBeReplacedByLeaves((IBlockAccess)world, x, y, z)) {
/* 45 */               flag = false;
/*    */             }
/*    */           } else {
/*    */             
/* 49 */             flag = false;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 55 */     if (!flag) {
/* 56 */       return false;
/*    */     }
/* 58 */     Block var3 = world.func_147439_a(xCoord, yCoord - 1, zCoord);
/* 59 */     if (!TFC_Core.isSoil(var3) || yCoord >= world.func_72800_K() - treeHeight - 1) {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     for (int treeHeightOffset = yCoord + 1; treeHeightOffset <= yCoord + treeHeight; treeHeightOffset++) {
/*    */       
/* 65 */       int treeDiameter = treeHeightOffset - yCoord + treeHeight;
/* 66 */       int treeRadius = 1 - treeDiameter / 2;
/* 67 */       for (int xPos = xCoord - 1; xPos <= xCoord + 1; xPos++) {
/*    */         
/* 69 */         int l3 = xPos - xCoord;
/* 70 */         for (int zPos = zCoord - 1; zPos <= zCoord + 1; zPos++) {
/*    */           
/* 72 */           int j4 = zPos - zCoord;
/* 73 */           if ((Math.abs(l3) != treeRadius || Math.abs(j4) != treeRadius || (random.nextInt(2) != 0 && treeDiameter != 0)) && world
/* 74 */             .func_147439_a(xPos, treeHeightOffset, zPos).canBeReplacedByLeaves((IBlockAccess)world, xPos, treeHeightOffset, zPos))
/*    */           {
/* 76 */             func_150516_a(world, xPos, treeHeightOffset, zPos, TFCBlocks.leaves, this.treeId);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 82 */     for (int l1 = 0; l1 < treeHeight; l1++)
/*    */     {
/* 84 */       func_150516_a(world, xCoord, yCoord + l1, zCoord, TFCBlocks.logNatural, this.treeId);
/*    */     }
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomCedarTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */