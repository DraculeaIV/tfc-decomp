/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenHugeTrees;
/*     */ 
/*     */ public class WorldGenMegaJungle
/*     */   extends WorldGenHugeTrees
/*     */ {
/*     */   public WorldGenMegaJungle(boolean doBlockNotify, int baseHeight, int extraHeight, int woodMeta, int leafMeta) {
/*  15 */     super(doBlockNotify, baseHeight, extraHeight, woodMeta, leafMeta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World world, Random rand, int x, int y, int z) {
/*  21 */     int l = func_150533_a(rand);
/*     */     
/*  23 */     if (!func_150537_a(world, rand, x, y, z, l))
/*     */     {
/*  25 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  29 */     callGenLeaves(world, x, z, y + l, 2, rand);
/*     */     int i1;
/*  31 */     for (i1 = y + l - 2 - rand.nextInt(4); i1 > y + l / 2; i1 -= 2 + rand.nextInt(4)) {
/*     */       
/*  33 */       float f = rand.nextFloat() * 3.1415927F * 2.0F;
/*  34 */       int j1 = x + (int)(0.5F + MathHelper.func_76134_b(f) * 4.0F);
/*  35 */       int k1 = z + (int)(0.5F + MathHelper.func_76126_a(f) * 4.0F);
/*     */       
/*     */       int l1;
/*  38 */       for (l1 = 0; l1 < 5; l1++) {
/*     */         
/*  40 */         j1 = x + (int)(1.5F + MathHelper.func_76134_b(f) * l1);
/*  41 */         k1 = z + (int)(1.5F + MathHelper.func_76126_a(f) * l1);
/*  42 */         func_150516_a(world, j1, i1 - 3 + l1 / 2, k1, Blocks.field_150364_r, this.field_76520_b);
/*     */       } 
/*     */       
/*  45 */       l1 = 1 + rand.nextInt(2);
/*  46 */       int i2 = i1;
/*     */       
/*  48 */       for (int j2 = i1 - l1; j2 <= i2; j2++) {
/*     */         
/*  50 */         int k2 = j2 - i2;
/*  51 */         func_150534_b(world, j1, j2, k1, 1 - k2, rand);
/*     */       } 
/*     */     } 
/*     */     
/*  55 */     for (int l2 = 0; l2 < l; l2++) {
/*     */       
/*  57 */       Block block = world.func_147439_a(x, y + l2, z);
/*     */       
/*  59 */       if (block.isAir((IBlockAccess)world, x, y + l2, z) || block.isLeaves((IBlockAccess)world, x, y + l2, z)) {
/*     */         
/*  61 */         func_150516_a(world, x, y + l2, z, Blocks.field_150364_r, this.field_76520_b);
/*     */         
/*  63 */         if (l2 > 0) {
/*     */           
/*  65 */           if (rand.nextInt(3) > 0 && world.func_147437_c(x - 1, y + l2, z))
/*     */           {
/*  67 */             func_150516_a(world, x - 1, y + l2, z, Blocks.field_150395_bd, 8);
/*     */           }
/*     */           
/*  70 */           if (rand.nextInt(3) > 0 && world.func_147437_c(x, y + l2, z - 1))
/*     */           {
/*  72 */             func_150516_a(world, x, y + l2, z - 1, Blocks.field_150395_bd, 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  77 */       if (l2 < l - 1) {
/*     */         
/*  79 */         block = world.func_147439_a(x + 1, y + l2, z);
/*     */         
/*  81 */         if (block.isAir((IBlockAccess)world, x + 1, y + l2, z) || block.isLeaves((IBlockAccess)world, x + 1, y + l2, z)) {
/*     */           
/*  83 */           func_150516_a(world, x + 1, y + l2, z, Blocks.field_150364_r, this.field_76520_b);
/*     */           
/*  85 */           if (l2 > 0) {
/*     */             
/*  87 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x + 2, y + l2, z))
/*     */             {
/*  89 */               func_150516_a(world, x + 2, y + l2, z, Blocks.field_150395_bd, 2);
/*     */             }
/*     */             
/*  92 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x + 1, y + l2, z - 1))
/*     */             {
/*  94 */               func_150516_a(world, x + 1, y + l2, z - 1, Blocks.field_150395_bd, 1);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/*  99 */         block = world.func_147439_a(x + 1, y + l2, z + 1);
/*     */         
/* 101 */         if (block.isAir((IBlockAccess)world, x + 1, y + l2, z + 1) || block.isLeaves((IBlockAccess)world, x + 1, y + l2, z + 1)) {
/*     */           
/* 103 */           func_150516_a(world, x + 1, y + l2, z + 1, Blocks.field_150364_r, this.field_76520_b);
/*     */           
/* 105 */           if (l2 > 0) {
/*     */             
/* 107 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x + 2, y + l2, z + 1))
/*     */             {
/* 109 */               func_150516_a(world, x + 2, y + l2, z + 1, Blocks.field_150395_bd, 2);
/*     */             }
/*     */             
/* 112 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x + 1, y + l2, z + 2))
/*     */             {
/* 114 */               func_150516_a(world, x + 1, y + l2, z + 2, Blocks.field_150395_bd, 4);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 119 */         block = world.func_147439_a(x, y + l2, z + 1);
/*     */         
/* 121 */         if (block.isAir((IBlockAccess)world, x, y + l2, z + 1) || block.isLeaves((IBlockAccess)world, x, y + l2, z + 1)) {
/*     */           
/* 123 */           func_150516_a(world, x, y + l2, z + 1, Blocks.field_150364_r, this.field_76520_b);
/*     */           
/* 125 */           if (l2 > 0) {
/*     */             
/* 127 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x - 1, y + l2, z + 1))
/*     */             {
/* 129 */               func_150516_a(world, x - 1, y + l2, z + 1, Blocks.field_150395_bd, 8);
/*     */             }
/*     */             
/* 132 */             if (rand.nextInt(3) > 0 && world.func_147437_c(x, y + l2, z + 2))
/*     */             {
/* 134 */               func_150516_a(world, x, y + l2, z + 2, Blocks.field_150395_bd, 4);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void callGenLeaves(World world, int x, int y, int z, int offset, Random rand) {
/* 147 */     byte b = 2;
/*     */     
/* 149 */     for (int i = z - b; i <= z; i++) {
/*     */       
/* 151 */       int j = i - z;
/* 152 */       func_150535_a(world, x, i, y, offset + 1 - j, rand);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenMegaJungle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */