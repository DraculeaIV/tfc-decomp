/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockStalactite
/*     */   extends BlockTerra
/*     */ {
/*     */   private Random r;
/*     */   
/*     */   public BlockStalactite() {
/*  31 */     func_149672_a(field_149769_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149734_b(World world, int i, int j, int k, Random random) {
/*  37 */     if (isStalactite(world.func_72805_g(i, j, k)) && random.nextInt(80) == 0) {
/*     */       
/*  39 */       AxisAlignedBB aabb = func_149668_a(world, i, j, k);
/*     */       
/*  41 */       double xRand = random.nextFloat() * (aabb.field_72336_d - aabb.field_72340_a) + aabb.field_72340_a;
/*  42 */       double zRand = random.nextFloat() * (aabb.field_72334_f - aabb.field_72339_c) + aabb.field_72339_c;
/*     */       
/*  44 */       world.func_72869_a("dripWater", xRand + 0.2D, aabb.field_72338_b + 0.9D, zRand + 0.2D, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int i, int j, int k) {
/*  51 */     boolean isStalac = isStalactite(access.func_72805_g(i, j, k));
/*  52 */     boolean isStalag = isStalagmite(access.func_72805_g(i, j, k));
/*     */     
/*  54 */     float f = 0.125F;
/*  55 */     this.r = new Random((i + i * k));
/*  56 */     if (isStalac) {
/*     */       
/*  58 */       float height = TFC_Core.isRawStone(access.func_147439_a(i, j + 1, k)) ? 1.0F : (TFC_Core.isRawStone(access.func_147439_a(i, j + 2, k)) ? 2.0F : 3.0F);
/*  59 */       f = 0.1F + this.r.nextFloat() * 0.025F;
/*  60 */       float width = height * f;
/*  61 */       if (height == 3.0F)
/*  62 */       { height = 0.5F + this.r.nextFloat() * 0.5F; }
/*  63 */       else { height = 1.0F; }
/*  64 */        func_149676_a(width, 1.0F - height, width, 1.0F - width, 1.0F, 1.0F - width);
/*     */     }
/*  66 */     else if (isStalag) {
/*     */       
/*  68 */       float height = TFC_Core.isRawStone(access.func_147439_a(i, j - 1, k)) ? 1.0F : (TFC_Core.isRawStone(access.func_147439_a(i, j - 2, k)) ? 2.0F : 3.0F);
/*  69 */       f = 0.1F + this.r.nextFloat() * 0.025F;
/*  70 */       float width = height * f;
/*  71 */       if (height == 3.0F)
/*  72 */       { height = 0.5F + this.r.nextFloat() * 0.5F; }
/*  73 */       else { height = 1.0F; }
/*  74 */        func_149676_a(width, 0.0F, width, 1.0F - width, height, 1.0F - width);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/*  81 */     boolean isStalac = isStalactite(world.func_72805_g(i, j, k));
/*  82 */     boolean isStalag = isStalagmite(world.func_72805_g(i, j, k));
/*     */     
/*  84 */     float f = 0.125F;
/*  85 */     this.r = new Random((i + i * k));
/*  86 */     if (isStalac) {
/*     */       
/*  88 */       float height = TFC_Core.isRawStone(world.func_147439_a(i, j + 1, k)) ? 1.0F : (TFC_Core.isRawStone(world.func_147439_a(i, j + 2, k)) ? 2.0F : 3.0F);
/*  89 */       f = 0.1F + this.r.nextFloat() * 0.025F;
/*  90 */       float width = height * f;
/*  91 */       if (height == 3.0F)
/*  92 */       { height = 0.5F + this.r.nextFloat() * 0.5F; }
/*  93 */       else { height = 1.0F; }
/*     */       
/*  95 */       return AxisAlignedBB.func_72330_a((i + width), (j - height), (k + width), ((i + 1) - width), (j + 1), ((k + 1) - width));
/*     */     } 
/*  97 */     if (isStalag) {
/*     */       
/*  99 */       float height = TFC_Core.isRawStone(world.func_147439_a(i, j - 1, k)) ? 1.0F : (TFC_Core.isRawStone(world.func_147439_a(i, j - 2, k)) ? 2.0F : 3.0F);
/* 100 */       f = 0.1F + this.r.nextFloat() * 0.025F;
/* 101 */       float width = height * f;
/* 102 */       if (height == 3.0F)
/* 103 */       { height = 0.5F + this.r.nextFloat() * 0.5F; }
/* 104 */       else { height = 1.0F; }
/* 105 */        return AxisAlignedBB.func_72330_a((i + width), j, (k + width), ((i + 1) - width), (j + height), ((k + 1) - width));
/*     */     } 
/*     */     
/* 108 */     return AxisAlignedBB.func_72330_a(i + this.field_149759_B, j + this.field_149760_C, k + this.field_149754_D, i + this.field_149755_E, j + this.field_149756_F, k + this.field_149757_G);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int i, int j, int k, int meta) {
/* 115 */     boolean isStalac = isStalactite(access.func_72805_g(i, j, k));
/* 116 */     boolean isStalag = isStalagmite(access.func_72805_g(i, j, k));
/* 117 */     if (isStalac) {
/*     */       
/* 119 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j + 1, k)))
/* 120 */         return access.func_147439_a(i, j + 1, k).func_149691_a(0, access.func_72805_g(i, j + 1, k)); 
/* 121 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j + 2, k)))
/* 122 */         return access.func_147439_a(i, j + 2, k).func_149691_a(0, access.func_72805_g(i, j + 2, k)); 
/* 123 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j + 3, k))) {
/* 124 */         return access.func_147439_a(i, j + 3, k).func_149691_a(0, access.func_72805_g(i, j + 3, k));
/*     */       }
/* 126 */     } else if (isStalag) {
/*     */       
/* 128 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j - 1, k)))
/* 129 */         return access.func_147439_a(i, j - 1, k).func_149691_a(0, access.func_72805_g(i, j - 1, k)); 
/* 130 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j - 2, k)))
/* 131 */         return access.func_147439_a(i, j - 2, k).func_149691_a(0, access.func_72805_g(i, j - 2, k)); 
/* 132 */       if (TFC_Core.isRawStone(access.func_147439_a(i, j - 3, k)))
/* 133 */         return access.func_147439_a(i, j - 3, k).func_149691_a(0, access.func_72805_g(i, j - 3, k)); 
/*     */     } 
/* 135 */     return TFC_Textures.invisibleTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/* 142 */     return TFC_Textures.invisibleTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block b) {
/* 148 */     if (!world.field_72995_K)
/*     */     {
/* 150 */       if (!func_149718_j(world, i, j, k)) {
/*     */         
/* 152 */         world.func_147468_f(i, j, k);
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int i, int j, int k) {
/* 161 */     boolean isStalac = isStalactite(world.func_72805_g(i, j, k));
/* 162 */     boolean isStalag = isStalagmite(world.func_72805_g(i, j, k));
/* 163 */     int h = 0;
/* 164 */     if (isStalac) {
/*     */       
/* 166 */       if (TFC_Core.isRawStone(world.func_147439_a(i, j + 1, k))) {
/* 167 */         h = 1;
/* 168 */       } else if (TFC_Core.isRawStone(world.func_147439_a(i, j + 2, k))) {
/* 169 */         h = 2;
/* 170 */       } else if (TFC_Core.isRawStone(world.func_147439_a(i, j + 3, k))) {
/* 171 */         h = 3;
/* 172 */       }  for (int y = h; y > 0; y--)
/*     */       {
/* 174 */         if (world.func_147437_c(i, j + y, k))
/*     */         {
/* 176 */           return false;
/*     */         }
/*     */       }
/*     */     
/* 180 */     } else if (isStalag) {
/*     */       
/* 182 */       if (TFC_Core.isRawStone(world.func_147439_a(i, j - 1, k))) {
/* 183 */         h = 1;
/* 184 */       } else if (TFC_Core.isRawStone(world.func_147439_a(i, j - 2, k))) {
/* 185 */         h = 2;
/* 186 */       } else if (TFC_Core.isRawStone(world.func_147439_a(i, j - 3, k))) {
/* 187 */         h = 3;
/* 188 */       }  for (int y = h; y > 0; y--) {
/*     */         
/* 190 */         if (world.func_147437_c(i, j - y, k))
/*     */         {
/* 192 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149705_a(World world, int x, int y, int z, int i, ItemStack is) {
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAir(IBlockAccess world, int x, int y, int z) {
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStalagmite(int meta) {
/* 222 */     return ((meta & 0x8) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStalactite(int meta) {
/* 230 */     return ((meta & 0x8) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion ex) {
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 248 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 254 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 265 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockStalactite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */