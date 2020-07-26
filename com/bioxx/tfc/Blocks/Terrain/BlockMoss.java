/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockMoss
/*     */   extends BlockTerra
/*     */ {
/*     */   public BlockMoss() {
/*  25 */     super(Material.field_151582_l);
/*  26 */     func_149675_a(true);
/*  27 */     func_149647_a(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  36 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  45 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  55 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  70 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:plants/Moss");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  76 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  85 */     int l = par1IBlockAccess.func_72805_g(par2, par3, par4);
/*  86 */     float f = 1.0F;
/*  87 */     float f1 = 1.0F;
/*  88 */     float f2 = 1.0F;
/*  89 */     float f3 = 0.0F;
/*  90 */     float f4 = 0.0F;
/*  91 */     float f5 = 0.0F;
/*  92 */     boolean flag = (l > 0);
/*     */     
/*  94 */     if ((l & 0x2) != 0) {
/*     */       
/*  96 */       f3 = Math.max(f3, 0.0625F);
/*  97 */       f = 0.0F;
/*  98 */       f1 = 0.0F;
/*  99 */       f4 = 1.0F;
/* 100 */       f2 = 0.0F;
/* 101 */       f5 = 1.0F;
/* 102 */       flag = true;
/*     */     } 
/*     */     
/* 105 */     if ((l & 0x8) != 0) {
/*     */       
/* 107 */       f = Math.min(f, 0.9375F);
/* 108 */       f3 = 1.0F;
/* 109 */       f1 = 0.0F;
/* 110 */       f4 = 1.0F;
/* 111 */       f2 = 0.0F;
/* 112 */       f5 = 1.0F;
/* 113 */       flag = true;
/*     */     } 
/*     */     
/* 116 */     if ((l & 0x4) != 0) {
/*     */       
/* 118 */       f5 = Math.max(f5, 0.0625F);
/* 119 */       f2 = 0.0F;
/* 120 */       f = 0.0F;
/* 121 */       f3 = 1.0F;
/* 122 */       f1 = 0.0F;
/* 123 */       f4 = 1.0F;
/* 124 */       flag = true;
/*     */     } 
/*     */     
/* 127 */     if ((l & 0x1) != 0) {
/*     */       
/* 129 */       f2 = Math.min(f2, 0.9375F);
/* 130 */       f5 = 1.0F;
/* 131 */       f = 0.0F;
/* 132 */       f3 = 1.0F;
/* 133 */       f1 = 0.0F;
/* 134 */       f4 = 1.0F;
/* 135 */       flag = true;
/*     */     } 
/*     */     
/* 138 */     if (!flag && canBePlacedOn(par1IBlockAccess.func_147439_a(par2, par3 + 1, par4))) {
/*     */       
/* 140 */       f1 = Math.min(f1, 0.9375F);
/* 141 */       f4 = 1.0F;
/* 142 */       f = 0.0F;
/* 143 */       f3 = 1.0F;
/* 144 */       f2 = 0.0F;
/* 145 */       f5 = 1.0F;
/*     */     } 
/*     */     
/* 148 */     func_149676_a(f, f1, f2, f3, f4, f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World par1World, int par2, int par3, int par4, int par5) {
/* 167 */     switch (par5) {
/*     */       
/*     */       case 1:
/* 170 */         return canBePlacedOn(par1World.func_147439_a(par2, par3 + 1, par4));
/*     */       case 2:
/* 172 */         return canBePlacedOn(par1World.func_147439_a(par2, par3, par4 + 1));
/*     */       case 3:
/* 174 */         return canBePlacedOn(par1World.func_147439_a(par2, par3, par4 - 1));
/*     */       case 4:
/* 176 */         return canBePlacedOn(par1World.func_147439_a(par2 + 1, par3, par4));
/*     */       case 5:
/* 178 */         return canBePlacedOn(par1World.func_147439_a(par2 - 1, par3, par4));
/*     */     } 
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canBePlacedOn(Block block) {
/* 189 */     if (block == Blocks.field_150350_a) {
/* 190 */       return false;
/*     */     }
/* 192 */     return (block.func_149686_d() && block.func_149688_o().func_76230_c());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canVineStay(World par1World, int par2, int par3, int par4) {
/* 200 */     int l = par1World.func_72805_g(par2, par3, par4);
/* 201 */     int i1 = l;
/*     */     
/* 203 */     if (l > 0)
/*     */     {
/* 205 */       for (int j1 = 0; j1 <= 3; j1++) {
/*     */         
/* 207 */         int k1 = 1 << j1;
/* 208 */         if ((l & k1) != 0 && !canBePlacedOn(par1World.func_147439_a(par2 + Direction.field_71583_a[j1], par3, par4 + Direction.field_71581_b[j1])) && (par1World.func_147439_a(par2, par3 + 1, par4) != this || (par1World.func_72805_g(par2, par3 + 1, par4) & k1) == 0)) {
/* 209 */           i1 &= k1 ^ 0xFFFFFFFF;
/*     */         }
/*     */       } 
/*     */     }
/* 213 */     if (i1 == 0 && !canBePlacedOn(par1World.func_147439_a(par2, par3 + 1, par4)))
/*     */     {
/* 215 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 219 */     if (i1 != l) {
/* 220 */       par1World.func_72921_c(par2, par3, par4, i1, 2);
/*     */     }
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World par1World, int par2, int par3, int par4, Block par5) {
/* 233 */     if (!par1World.field_72995_K && !canVineStay(par1World, par2, par3, par4)) {
/*     */       
/* 235 */       func_149697_b(par1World, par2, par3, par4, par1World.func_72805_g(par2, par3, par4), 0);
/* 236 */       par1World.func_147468_f(par2, par3, par4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 246 */     if (!world.field_72995_K && world.field_73012_v.nextInt(4) == 0) {
/*     */       
/* 248 */       byte b0 = 4;
/* 249 */       int l = 5;
/* 250 */       boolean flag = false;
/*     */ 
/*     */       
/*     */       int i1;
/*     */ 
/*     */       
/* 256 */       label85: for (i1 = x - b0; i1 <= x + b0; i1++) {
/*     */         
/* 258 */         for (int i = z - b0; i <= z + b0; i++) {
/*     */           
/* 260 */           for (int j = y - 1; j <= y + 1; j++) {
/*     */             
/* 262 */             if (world.func_147439_a(i1, j, i) == this) {
/*     */               
/* 264 */               l--;
/* 265 */               if (l <= 0) {
/*     */                 
/* 267 */                 flag = true;
/*     */                 
/*     */                 break label85;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 275 */       i1 = world.func_72805_g(x, y, z);
/* 276 */       int j1 = world.field_73012_v.nextInt(6);
/* 277 */       int k1 = Direction.field_71579_d[j1];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 282 */       if (j1 == 1 && y < 255 && world.func_147437_c(x, y + 1, z)) {
/*     */         
/* 284 */         if (flag) {
/*     */           return;
/*     */         }
/* 287 */         int l1 = world.field_73012_v.nextInt(16) & i1;
/* 288 */         if (l1 > 0)
/*     */         {
/* 290 */           for (int i2 = 0; i2 <= 3; i2++) {
/*     */             
/* 292 */             if (!canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[i2], y + 1, z + Direction.field_71581_b[i2]))) {
/* 293 */               l1 &= 1 << i2 ^ 0xFFFFFFFF;
/*     */             }
/*     */           } 
/* 296 */           if (l1 > 0) {
/* 297 */             world.func_147465_d(x, y + 1, z, (Block)this, l1, 2);
/*     */           
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 303 */       else if (j1 >= 2 && j1 <= 5 && (i1 & 1 << k1) == 0) {
/*     */         
/* 305 */         if (flag) {
/*     */           return;
/*     */         }
/* 308 */         Block block = world.func_147439_a(x + Direction.field_71583_a[k1], y, z + Direction.field_71581_b[k1]);
/* 309 */         if (!block.isAir((IBlockAccess)world, x + Direction.field_71583_a[k1], y, z + Direction.field_71581_b[k1])) {
/*     */           
/* 311 */           if (block.func_149688_o().func_76218_k() && block.func_149686_d()) {
/* 312 */             world.func_72921_c(x, y, z, i1 | 1 << k1, 2);
/*     */           }
/*     */         } else {
/*     */           
/* 316 */           int i2 = k1 + 1 & 0x3;
/* 317 */           int j2 = k1 + 3 & 0x3;
/*     */           
/* 319 */           if ((i1 & 1 << i2) != 0 && canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[k1] + Direction.field_71583_a[i2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[i2]))) {
/* 320 */             world.func_147465_d(x + Direction.field_71583_a[k1], y, z + Direction.field_71581_b[k1], (Block)this, 1 << i2, 2);
/* 321 */           } else if ((i1 & 1 << j2) != 0 && canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[k1] + Direction.field_71583_a[j2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[j2]))) {
/* 322 */             world.func_147465_d(x + Direction.field_71583_a[k1], y, z + Direction.field_71581_b[k1], (Block)this, 1 << j2, 2);
/* 323 */           } else if ((i1 & 1 << i2) != 0 && world.func_147437_c(x + Direction.field_71583_a[k1] + Direction.field_71583_a[i2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[i2]) && canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[i2], y, z + Direction.field_71581_b[i2]))) {
/* 324 */             world.func_147465_d(x + Direction.field_71583_a[k1] + Direction.field_71583_a[i2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[i2], (Block)this, 1 << (k1 + 2 & 0x3), 2);
/* 325 */           } else if ((i1 & 1 << j2) != 0 && world.func_147437_c(x + Direction.field_71583_a[k1] + Direction.field_71583_a[j2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[j2]) && canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[j2], y, z + Direction.field_71581_b[j2]))) {
/* 326 */             world.func_147465_d(x + Direction.field_71583_a[k1] + Direction.field_71583_a[j2], y, z + Direction.field_71581_b[k1] + Direction.field_71581_b[j2], (Block)this, 1 << (k1 + 2 & 0x3), 2);
/* 327 */           } else if (canBePlacedOn(world.func_147439_a(x + Direction.field_71583_a[k1], y + 1, z + Direction.field_71581_b[k1]))) {
/* 328 */             world.func_147465_d(x + Direction.field_71583_a[k1], y, z + Direction.field_71581_b[k1], (Block)this, 0, 2);
/*     */           } 
/*     */         } 
/* 331 */       } else if (y > 1) {
/*     */         
/* 333 */         Block block = world.func_147439_a(x, y - 1, z);
/*     */         
/* 335 */         if (block.isAir((IBlockAccess)world, x, y - 1, z)) {
/*     */           
/* 337 */           int i2 = world.field_73012_v.nextInt(16) & i1;
/* 338 */           if (i2 > 0) {
/* 339 */             world.func_147465_d(x, y - 1, z, (Block)this, i2, 2);
/*     */           }
/* 341 */         } else if (block == this) {
/*     */           
/* 343 */           int i2 = world.field_73012_v.nextInt(16) & i1;
/* 344 */           int j2 = world.func_72805_g(x, y - 1, z);
/* 345 */           if (j2 != (j2 | i2)) {
/* 346 */             world.func_72921_c(x, y - 1, z, j2 | i2, 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
/* 359 */     byte b0 = 0;
/*     */     
/* 361 */     switch (par5) {
/*     */       
/*     */       case 2:
/* 364 */         b0 = 1;
/*     */         break;
/*     */       case 3:
/* 367 */         b0 = 4;
/*     */         break;
/*     */       case 4:
/* 370 */         b0 = 8;
/*     */         break;
/*     */       case 5:
/* 373 */         b0 = 2;
/*     */         break;
/*     */     } 
/*     */     
/* 377 */     return (b0 != 0) ? b0 : par9;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par1, Random par2Random, int par3) {
/* 386 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 395 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
/* 405 */     super.func_149636_a(par1World, par2EntityPlayer, par3, par4, par5, par6);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
/* 411 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockMoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */