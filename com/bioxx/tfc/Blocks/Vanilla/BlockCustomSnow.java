/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.WeatherManager;
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
/*  29 */     super(Material.field_151597_y);
/*  30 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
/*  31 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int i, int j, int k) {
/*  37 */     Block block = world.func_147439_a(i, j - 1, k);
/*     */     
/*  39 */     if (block == TFCBlocks.ice || block == TFCBlocks.pottery)
/*  40 */       return false; 
/*  41 */     if (block == TFCBlocks.leaves || block == TFCBlocks.leaves2 || block == TFCBlocks.thatch)
/*  42 */       return true; 
/*  43 */     return World.func_147466_a((IBlockAccess)world, i, j - 1, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  49 */     float f = 0.125F;
/*  50 */     return AxisAlignedBB.func_72330_a(x + this.field_149759_B, y + this.field_149760_C, z + this.field_149754_D, x + this.field_149755_E, (y + f), z + this.field_149757_G);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  56 */     return TFCBlocks.snowRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer player, int x, int y, int z, int meta) {
/*  62 */     func_149697_b(world, x, y, z, meta, 0);
/*  63 */     player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random r, int j) {
/*  69 */     return Items.field_151126_ay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/*  91 */     int meta = world.func_72805_g(x, y, z) & 0x7;
/*  92 */     double speed = 0.98D - 0.125D * meta;
/*  93 */     entity.field_70159_w *= speed;
/*  94 */     entity.field_70179_y *= speed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 100 */     if (!func_149742_c(world, x, y, z))
/*     */     {
/* 102 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random r) {
/* 109 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 121 */     int meta = bAccess.func_72805_g(x, y, z) & 0x7;
/* 122 */     float top = (meta + 1) / 8.0F;
/* 123 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, top, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 129 */     return 50;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random r) {
/* 135 */     if (!func_149742_c(world, x, y, z)) {
/*     */       
/* 137 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */       
/*     */       return;
/*     */     } 
/* 141 */     int meta = world.func_72805_g(x, y, z) & 0x7;
/*     */     
/* 143 */     if (world.func_72972_b(EnumSkyBlock.Block, x, y, z) > 11)
/*     */     {
/* 145 */       if (r.nextInt(5) == 0)
/*     */       {
/* 147 */         if (meta > 0) {
/* 148 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 150 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/*     */     }
/* 154 */     float temp = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
/*     */     
/* 156 */     if (temp <= 0.0F && WeatherManager.isRainingOnCoord(world, x, y, z)) {
/*     */       
/* 158 */       if (r.nextInt(20) == 0)
/*     */       {
/* 160 */         int max = (world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151584_j) ? 3 : 7;
/* 161 */         if (meta < max && canAddSnow(world, x, y, z, meta))
/*     */         {
/* 163 */           world.func_72921_c(x, y, z, meta + 1, 2);
/*     */         }
/*     */       }
/*     */     
/* 167 */     } else if (temp > 10.0F) {
/*     */       
/* 169 */       world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */     }
/* 171 */     else if (temp > 0.0F && WeatherManager.isRainingOnCoord(world, x, y, z)) {
/*     */       
/* 173 */       if (r.nextInt(5) == 0)
/*     */       {
/* 175 */         if (meta > 0) {
/* 176 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 178 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/* 181 */     } else if (temp > 0.0F) {
/*     */       
/* 183 */       if (r.nextInt(20) == 0)
/*     */       {
/* 185 */         if (meta > 0) {
/* 186 */           world.func_72921_c(x, y, z, meta - 1, 2);
/*     */         } else {
/* 188 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 196 */     this.field_149761_L = registerer.func_94245_a("terrafirmacraft:snow");
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canAddSnowCheckNeighbors(World world, int x, int y, int z, int meta) {
/* 201 */     Block block = world.func_147439_a(x, y, z);
/*     */     
/* 203 */     if (block.func_149688_o() == Material.field_151597_y)
/* 204 */       return (meta <= (world.func_72805_g(x, y, z) & 0x7)); 
/* 205 */     if (block == TFCBlocks.leaves || block == TFCBlocks.leaves2)
/* 206 */       return (meta < 3); 
/* 207 */     if (block.func_149721_r()) {
/* 208 */       return (meta < 6);
/*     */     }
/* 210 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canAddSnow(World world, int x, int y, int z, int meta) {
/* 215 */     if (!canAddSnowCheckNeighbors(world, x + 1, y, z, meta))
/* 216 */       return false; 
/* 217 */     if (!canAddSnowCheckNeighbors(world, x - 1, y, z, meta))
/* 218 */       return false; 
/* 219 */     if (!canAddSnowCheckNeighbors(world, x, y, z + 1, meta))
/* 220 */       return false; 
/* 221 */     return canAddSnowCheckNeighbors(world, x, y, z - 1, meta);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */