/*     */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ public class WorldGenCustomWillowTrees
/*     */   extends WorldGenerator
/*     */ {
/*     */   private final int treeId;
/*     */   
/*     */   public WorldGenCustomWillowTrees(boolean flag, int id) {
/*  19 */     super(flag);
/*  20 */     this.treeId = id;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addBranch(int x, int y, int z, int x1, int z1, Random random, World world) {
/*  25 */     if (random.nextInt(3) == 0) {
/*     */       
/*  27 */       int xCoord = (random.nextInt(8) - 4) * z1;
/*  28 */       xCoord += (random.nextInt(2) + 3) * x1;
/*  29 */       int zCoord = (random.nextInt(8) - 4) * x1;
/*  30 */       zCoord += (random.nextInt(2) + 3) * z1;
/*  31 */       int yCoord = random.nextInt(3) + random.nextInt(1);
/*  32 */       int length = (int)Math.sqrt(Math.pow(xCoord, 2.0D) + Math.pow(yCoord, 2.0D) + Math.pow(zCoord, 2.0D));
/*  33 */       for (int a = 0; a < length; a++) {
/*     */         
/*  35 */         if (world.func_147437_c(xCoord * a / length + x, yCoord * a / length + y, zCoord * a / length + z))
/*  36 */           world.func_147465_d(xCoord * a / length + x, yCoord * a / length + y, zCoord * a / length + z, TFCBlocks.logNatural, this.treeId, 2); 
/*     */       } 
/*  38 */       createLeafGroup(xCoord + x, yCoord + y, zCoord + z, random, world);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void createLeafGroup(int x, int y, int z, Random random, World world) {
/*  44 */     for (int y1 = 0; y1 < 2; y1++) {
/*     */       
/*  46 */       for (int x1 = x - 2 + y1; x1 < x + 2 - y1; x1++) {
/*     */         
/*  48 */         for (int z1 = z - 2 + y1; z1 < z + 2 - y1; z1++) {
/*     */           
/*  50 */           if (world.func_147439_a(x1, y1 + y, z1).canBeReplacedByLeaves((IBlockAccess)world, x1, y1 + y, z1)) {
/*     */             
/*  52 */             world.func_147465_d(x1, y1 + y, z1, TFCBlocks.leaves, this.treeId, 2);
/*  53 */             for (int a = 0; a < random.nextInt(2) + 2; a++) {
/*     */               
/*  55 */               Block b = world.func_147439_a(x1, y1 - 1 - a + y, z1);
/*  56 */               if (b.canBeReplacedByLeaves((IBlockAccess)world, x1, y1 - 1 - a + y, z1)) {
/*  57 */                 world.func_147465_d(x1, y1 - 1 - a + y, z1, TFCBlocks.leaves, this.treeId, 2);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random random, int xCoord, int yCoord, int zCoord) {
/*  68 */     int height = random.nextInt(2) + 3;
/*  69 */     while (world.func_147439_a(xCoord, yCoord - 1, zCoord).func_149688_o() == Material.field_151586_h)
/*     */     {
/*  71 */       yCoord--;
/*     */     }
/*  73 */     if (yCoord < 1 || yCoord + height + 5 > world.func_72800_K()) {
/*  74 */       return false;
/*     */     }
/*  76 */     boolean flag = true;
/*  77 */     for (int i1 = yCoord; i1 <= yCoord + 1 + height; i1++) {
/*     */       
/*  79 */       byte byte0 = 1;
/*  80 */       if (i1 == yCoord)
/*  81 */         byte0 = 0; 
/*  82 */       if (i1 >= yCoord + 1 + height - 2) {
/*  83 */         byte0 = 3;
/*     */       }
/*  85 */       for (int j2 = xCoord - byte0; j2 <= xCoord + byte0 && flag; j2++) {
/*     */         
/*  87 */         for (int j3 = zCoord - byte0; j3 <= zCoord + byte0 && flag; j3++) {
/*     */           
/*  89 */           if (i1 >= 0 && i1 < world.func_72800_K()) {
/*     */             
/*  91 */             Block i4 = world.func_147439_a(j2, i1, j3);
/*  92 */             if (!i4.isAir((IBlockAccess)world, j2, i1, j3) && i4 != TFCBlocks.leaves && i4 != TFCBlocks.leaves2)
/*     */             {
/*  94 */               if (i4 == TFCBlocks.freshWaterStationary) {
/*     */                 
/*  96 */                 if (i1 > yCoord) {
/*  97 */                   flag = false;
/*     */                 }
/*     */               } else {
/*     */                 
/* 101 */                 flag = false;
/*     */               } 
/*     */             }
/*     */           } else {
/*     */             
/* 106 */             flag = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     if (!flag) {
/* 113 */       return false;
/*     */     }
/* 115 */     if (!TFC_Core.isSoil(world.func_147439_a(xCoord, yCoord - 1, zCoord)) || yCoord >= world.func_72800_K() - height - 1) {
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     int y = height + yCoord;
/* 120 */     int x = xCoord;
/* 121 */     int z = zCoord;
/*     */     
/* 123 */     for (int n = 0; n < 2; n++) {
/*     */       
/* 125 */       int x1 = 1 - n * (random.nextInt(1) - random.nextInt(1));
/* 126 */       int z1 = 0 - n * (random.nextInt(1) - random.nextInt(1));
/* 127 */       int x2 = (random.nextInt(6) - 3) * z1;
/* 128 */       x2 += (random.nextInt(1) + 2) * x1;
/* 129 */       int z2 = (random.nextInt(6) - 3) * x1;
/* 130 */       z2 += (random.nextInt(1) + 2) * z1;
/* 131 */       int y2 = random.nextInt(2) + 3;
/* 132 */       int length = (int)Math.sqrt(Math.pow(x2, 2.0D) + Math.pow(y2, 2.0D) + Math.pow(z2, 2.0D));
/* 133 */       for (int a = 0; a < length; a++) {
/*     */         
/* 135 */         if (world.func_147437_c(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z))
/* 136 */           world.func_147465_d(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z, TFCBlocks.logNatural, this.treeId, 2); 
/* 137 */         addBranch(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z, -1, 0, random, world);
/* 138 */         addBranch(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z, 0, -1, random, world);
/* 139 */         addBranch(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z, 1, 0, random, world);
/* 140 */         addBranch(x2 * a / length + x, y2 * a / length + y, z2 * a / length + z, 0, 1, random, world);
/*     */       } 
/* 142 */       createLeafGroup(x2 + x, y2 + y, z2 + z, random, world);
/*     */     } 
/* 144 */     createLeafGroup(xCoord, yCoord + height + 1, zCoord, random, world);
/* 145 */     for (int l1 = 0; l1 < height; l1++)
/*     */     {
/* 147 */       world.func_147465_d(xCoord, yCoord + l1, zCoord, TFCBlocks.logNatural, this.treeId, 2);
/*     */     }
/*     */     
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenCustomWillowTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */