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
/*    */ public class WorldGenCustomShortTrees
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int treeId;
/*    */   
/*    */   public WorldGenCustomShortTrees(boolean flag, int id) {
/* 18 */     super(flag);
/* 19 */     this.treeId = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random random, int xCoord, int yCoord, int zCoord) {
/* 24 */     int l = random.nextInt(3) + 4;
/* 25 */     if (yCoord < 1 || yCoord + l + 1 > world.func_72800_K()) {
/* 26 */       return false;
/*    */     }
/* 28 */     boolean flag = true;
/* 29 */     for (int i1 = yCoord; i1 <= yCoord + 1 + l; i1++) {
/*    */       
/* 31 */       byte byte0 = 1;
/* 32 */       if (i1 == yCoord)
/* 33 */         byte0 = 0; 
/* 34 */       if (i1 >= yCoord + 1 + l - 2) {
/* 35 */         byte0 = 2;
/*    */       }
/* 37 */       for (int i2 = xCoord - byte0; i2 <= xCoord + byte0 && flag; i2++) {
/*    */         
/* 39 */         for (int l2 = zCoord - byte0; l2 <= zCoord + byte0 && flag; l2++) {
/*    */           
/* 41 */           if (i1 >= 0 && i1 < world.func_72800_K()) {
/*    */             
/* 43 */             Block j3 = world.func_147439_a(i2, i1, l2);
/* 44 */             if (!j3.isAir((IBlockAccess)world, i2, i1, l2) && !j3.canBeReplacedByLeaves((IBlockAccess)world, i2, i1, l2)) {
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
/* 58 */     if (!TFC_Core.isSoil(world.func_147439_a(xCoord, yCoord - 1, zCoord)) || yCoord >= world.func_72800_K() - l - 1) {
/* 59 */       return false;
/*    */     }
/* 61 */     for (int k1 = yCoord - 3 + l; k1 <= yCoord + l; k1++) {
/*    */       
/* 63 */       int j2 = k1 - yCoord + l;
/* 64 */       int i3 = 1 - j2 / 2;
/* 65 */       for (int k3 = xCoord - i3; k3 <= xCoord + i3; k3++) {
/*    */         
/* 67 */         int l3 = k3 - xCoord;
/* 68 */         for (int i4 = zCoord - i3; i4 <= zCoord + i3; i4++) {
/*    */           
/* 70 */           int j4 = i4 - zCoord;
/* 71 */           if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || (random.nextInt(2) != 0 && j2 != 0)) && world.func_147437_c(k3, k1, i4)) {
/* 72 */             func_150516_a(world, k3, k1, i4, TFCBlocks.leaves, this.treeId);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/* 77 */     for (int l1 = 0; l1 < l; l1++)
/*    */     {
/* 79 */       func_150516_a(world, xCoord, yCoord + l1, zCoord, TFCBlocks.logNatural, this.treeId);
/*    */     }
/*    */     
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomShortTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */