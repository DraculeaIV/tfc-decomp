/*     */ package com.bioxx.tfc.WorldGen.Generators.Trees;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenRedwoodXL
/*     */   extends WorldGenerator
/*     */ {
/*     */   private final Block blockLeaf;
/*     */   private final Block blockWood;
/*     */   private final int metaLeaf;
/*     */   private final int metaWood;
/*     */   
/*     */   public WorldGenRedwoodXL(boolean doNotify) {
/*  22 */     super(doNotify);
/*  23 */     this.blockLeaf = TFCBlocks.leaves;
/*  24 */     this.metaLeaf = 9;
/*  25 */     this.blockWood = TFCBlocks.logNatural;
/*  26 */     this.metaWood = 9;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/*  32 */     int height = rand.nextInt(20) + 22;
/*     */     
/*  34 */     if (y < 1 || y + height + 1 > 256) {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!TFC_Core.isSoil(world.func_147439_a(x, y - 1, z)) || 
/*  38 */       !TFC_Core.isSoil(world.func_147439_a(x - 1, y - 1, z)) || 
/*  39 */       !TFC_Core.isSoil(world.func_147439_a(x, y - 1, z - 1)) || 
/*  40 */       !TFC_Core.isSoil(world.func_147439_a(x - 1, y - 1, z - 1)) || y >= 180)
/*     */     {
/*     */       
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     int l = 4 + rand.nextInt(6);
/*  47 */     int j = 5 + rand.nextInt(12);
/*  48 */     for (int y1 = y; y1 <= y + 1 + height; y1++) {
/*     */       
/*  50 */       int k1 = 1;
/*     */       
/*  52 */       if (y1 - y < j) {
/*  53 */         k1 = 0;
/*     */       } else {
/*  55 */         k1 = l;
/*     */       } 
/*  57 */       for (int x1 = x - k1; x1 <= x + k1; x1++) {
/*     */         
/*  59 */         for (int z1 = z - k1; z1 <= z + k1; z1++) {
/*     */           
/*  61 */           if (y1 >= 0 && y1 < 256) {
/*     */             
/*  63 */             Block id1 = world.func_147439_a(x1, y1, z1);
/*  64 */             if (id1 != null && id1.isLeaves((IBlockAccess)world, x1, y1, z1)) {
/*  65 */               return false;
/*     */             }
/*     */           } else {
/*     */             
/*  69 */             return false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     Block block = world.func_147439_a(x, y - 1, z);
/*  76 */     Block soil = null;
/*  77 */     int soilMeta = 0;
/*     */     
/*  79 */     if (TFC_Core.isGrass(block)) {
/*     */       
/*  81 */       soil = TFC_Core.getTypeForSoil(block);
/*  82 */       soilMeta = world.func_72805_g(x, y - 1, z);
/*  83 */       world.func_147465_d(x, y - 1, z, soil, soilMeta, 2);
/*     */     } 
/*     */     
/*  86 */     block = world.func_147439_a(x - 1, y - 1, z);
/*  87 */     if (TFC_Core.isGrass(block)) {
/*     */       
/*  89 */       soil = TFC_Core.getTypeForSoil(block);
/*  90 */       soilMeta = world.func_72805_g(x - 1, y - 1, z);
/*  91 */       world.func_147465_d(x - 1, y - 1, z, soil, soilMeta, 2);
/*     */     } 
/*     */     
/*  94 */     block = world.func_147439_a(x, y - 1, z - 1);
/*  95 */     if (TFC_Core.isGrass(block)) {
/*     */       
/*  97 */       soil = TFC_Core.getTypeForSoil(block);
/*  98 */       soilMeta = world.func_72805_g(x, y - 1, z - 1);
/*  99 */       world.func_147465_d(x, y - 1, z - 1, soil, soilMeta, 2);
/*     */     } 
/*     */     
/* 102 */     block = world.func_147439_a(x - 1, y - 1, z - 1);
/* 103 */     if (TFC_Core.isGrass(block)) {
/*     */       
/* 105 */       soil = TFC_Core.getTypeForSoil(block);
/* 106 */       soilMeta = world.func_72805_g(x - 1, y - 1, z - 1);
/* 107 */       world.func_147465_d(x - 1, y - 1, z - 1, soil, soilMeta, 2);
/*     */     } 
/*     */     
/* 110 */     int l1 = rand.nextInt(2);
/* 111 */     int j2 = 1;
/* 112 */     boolean flag1 = false;
/*     */     
/* 114 */     for (int i = 0; i < height - 3; i++) {
/*     */       
/* 116 */       func_150516_a(world, x, y + i, z, this.blockWood, this.metaWood);
/* 117 */       func_150516_a(world, x - 1, y + i, z, this.blockWood, this.metaWood);
/* 118 */       func_150516_a(world, x, y + i, z - 1, this.blockWood, this.metaWood);
/* 119 */       func_150516_a(world, x - 1, y + i, z - 1, this.blockWood, this.metaWood);
/*     */     } 
/*     */     
/* 122 */     int k = height - j;
/* 123 */     for (int i3 = 0; i3 <= k; i3++) {
/*     */       
/* 125 */       int m = y + height - i3;
/* 126 */       for (int x1 = x - l1; x1 <= x + l1; x1++) {
/*     */         
/* 128 */         int k4 = x1 - x;
/* 129 */         for (int z1 = z - l1; z1 <= z + l1; z1++) {
/*     */           
/* 131 */           int i5 = z1 - z;
/* 132 */           if (Math.abs(k4) != l1 || Math.abs(i5) != l1 || l1 <= 0) {
/*     */ 
/*     */             
/* 135 */             setLeaf(world, x1, m, z1);
/* 136 */             setLeaf(world, x1 - 1, m, z1);
/* 137 */             setLeaf(world, x1, m, z1 - 1);
/* 138 */             setLeaf(world, x1 - 1, m, z1 - 1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 143 */       if (l1 >= j2) {
/*     */         
/* 145 */         l1 = flag1 ? 1 : 0;
/* 146 */         flag1 = true;
/* 147 */         if (++j2 > l) {
/* 148 */           j2 = l;
/*     */         }
/*     */       } else {
/*     */         
/* 152 */         l1++;
/*     */       } 
/*     */     } 
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setLeaf(World world, int x, int y, int z) {
/* 160 */     Block b = world.func_147439_a(x, y, z);
/* 161 */     if (b.canBeReplacedByLeaves((IBlockAccess)world, x, y, z))
/* 162 */       func_150516_a(world, x, y, z, this.blockLeaf, this.metaLeaf); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\Trees\WorldGenRedwoodXL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */