/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomSnow
/*     */   extends BlockTerra
/*     */ {
/*     */   public BlockCustomSnow() {
/*  28 */     super(Material.field_151597_y);
/*  29 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*  30 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int i, int j, int k) {
/*  36 */     Block block = world.func_147439_a(i, j - 1, k);
/*     */     
/*  38 */     if (block == TFCBlocks.ice || block == TFCBlocks.pottery)
/*  39 */       return false; 
/*  40 */     if (block == TFCBlocks.leaves || block == TFCBlocks.leaves2 || block == TFCBlocks.thatch)
/*  41 */       return true; 
/*  42 */     return World.func_147466_a((IBlockAccess)world, i, j - 1, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  48 */     float f = 0.125F;
/*  49 */     return AxisAlignedBB.func_72330_a(x + this.field_149759_B, y + this.field_149760_C, z + this.field_149754_D, x + this.field_149755_E, (y + f), z + this.field_149757_G);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  55 */     return TFCBlocks.snowRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer player, int x, int y, int z, int meta) {
/*  61 */     func_149697_b(world, x, y, z, meta, 0);
/*  62 */     player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random r, int j) {
/*  68 */     return Items.field_151126_ay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/*  90 */     int meta = world.func_72805_g(x, y, z) & 0x7;
/*  91 */     double speed = 0.98D - 0.125D * meta;
/*  92 */     entity.field_70159_w *= speed;
/*  93 */     entity.field_70179_y *= speed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/*  99 */     if (!func_149742_c(world, x, y, z))
/*     */     {
/* 101 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random r) {
/* 108 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 114 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 120 */     int meta = bAccess.func_72805_g(x, y, z) & 0x7;
/* 121 */     float top = (meta + 1) / 8.0F;
/* 122 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, top, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 128 */     return 50;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random r) {
/* 134 */     if (!func_149742_c(world, x, y, z)) {
/*     */       
/* 136 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     int meta = world.func_72805_g(x, y, z) & 0x7;
/*     */     
/* 142 */     if (world.func_72972_b(EnumSkyBlock.Block, x, y, z) > 11)
/*     */     {
/* 144 */       if (r.nextInt(5) == 0)
/*     */       {
/* 146 */         if (meta > 0) {
/* 147 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 149 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/*     */     }
/* 153 */     float temp = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
/*     */     
/* 155 */     if (temp <= 0.0F && world.func_72896_J()) {
/*     */       
/* 157 */       if (r.nextInt(20) == 0)
/*     */       {
/* 159 */         int max = (world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151584_j) ? 3 : 7;
/* 160 */         if (meta < max && canAddSnow(world, x, y, z, meta))
/*     */         {
/* 162 */           world.func_72921_c(x, y, z, meta + 1, 2);
/*     */         }
/*     */       }
/*     */     
/* 166 */     } else if (temp > 10.0F) {
/*     */       
/* 168 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */     }
/* 170 */     else if (temp > 0.0F && world.func_72896_J()) {
/*     */       
/* 172 */       if (r.nextInt(5) == 0)
/*     */       {
/* 174 */         if (meta > 0) {
/* 175 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 177 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/* 180 */     } else if (temp > 0.0F) {
/*     */       
/* 182 */       if (r.nextInt(20) == 0)
/*     */       {
/* 184 */         if (meta > 0) {
/* 185 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 187 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 195 */     this.field_149761_L = registerer.func_94245_a("terrafirmacraft:snow");
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canAddSnowCheckNeighbors(World world, int x, int y, int z, int meta) {
/* 200 */     Block block = world.func_147439_a(x, y, z);
/*     */     
/* 202 */     if (block.func_149688_o() == Material.field_151597_y)
/* 203 */       return (meta <= (world.func_72805_g(x, y, z) & 0x7)); 
/* 204 */     if (block == TFCBlocks.leaves || block == TFCBlocks.leaves2)
/* 205 */       return (meta < 3); 
/* 206 */     if (block.func_149721_r()) {
/* 207 */       return (meta < 6);
/*     */     }
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canAddSnow(World world, int x, int y, int z, int meta) {
/* 214 */     if (!canAddSnowCheckNeighbors(world, x + 1, y, z, meta))
/* 215 */       return false; 
/* 216 */     if (!canAddSnowCheckNeighbors(world, x - 1, y, z, meta))
/* 217 */       return false; 
/* 218 */     if (!canAddSnowCheckNeighbors(world, x, y, z + 1, meta))
/* 219 */       return false; 
/* 220 */     return canAddSnowCheckNeighbors(world, x, y, z - 1, meta);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */