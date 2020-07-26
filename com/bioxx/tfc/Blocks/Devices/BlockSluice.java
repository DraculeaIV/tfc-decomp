/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TESluice;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSluice
/*     */   extends BlockContainer
/*     */ {
/*  32 */   public static final int[][] HEAD_FOOT_BLOCKMAP = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
/*     */ 
/*     */   
/*     */   public BlockSluice() {
/*  36 */     super(Material.field_151575_d);
/*  37 */     this.field_149789_z = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess world, int x, int y, int z, int side) {
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  58 */     int meta = world.func_72805_g(i, j, k);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (world.field_72995_K) {
/*  66 */       return true;
/*     */     }
/*     */     
/*  69 */     if (!isBlockFootOfBed(meta) && 
/*  70 */       (TESluice)world.func_147438_o(i, j, k) != null) {
/*     */ 
/*     */       
/*  73 */       TESluice tileentitysluice = (TESluice)world.func_147438_o(i, j, k);
/*  74 */       ItemStack is = entityplayer.func_71045_bC();
/*  75 */       if (is != null && is.func_77973_b() == TFCItems.goldPan && is.func_77960_j() != 0) {
/*     */         
/*  77 */         tileentitysluice.soilAmount += 7;
/*  78 */         tileentitysluice.soilType = (byte)is.func_77960_j();
/*  79 */         if (tileentitysluice.soilAmount > 50)
/*  80 */           tileentitysluice.soilAmount = 50; 
/*  81 */         is.func_77964_b(0);
/*  82 */         entityplayer.field_71071_by.func_70299_a(entityplayer.field_71071_by.field_70461_c, is);
/*     */ 
/*     */ 
/*     */         
/*  86 */         return true;
/*     */       } 
/*  88 */       entityplayer.openGui(TerraFirmaCraft.instance, 25, world, i, j, k);
/*     */     } 
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  98 */     if ((meta & 0x4) != 0 && side == 1) {
/*  99 */       return TFCFluids.SALTWATER.getFlowingIcon();
/*     */     }
/* 101 */     return TFCBlocks.woodSupportH.func_149691_a(side, 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess world, int x, int y, int z) {
/* 112 */     if ((world.func_72805_g(x, y, z) & 0x4) == 0) {
/* 113 */       return 16777215;
/*     */     }
/* 115 */     return 3493173;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDirectionFromMetadata(int i) {
/* 120 */     return i & 0x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBlockFootOfBed(int i) {
/* 125 */     return ((i & 0x8) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getIsRecievingWater(int i) {
/* 130 */     return ((i & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getItemNameIS(ItemStack itemstack) {
/* 135 */     return "Sluice";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 141 */     return TFCBlocks.sluiceRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random random, int j) {
/* 147 */     if (!isBlockFootOfBed(i)) {
/* 148 */       return TFCItems.sluiceItem;
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
/* 156 */     int l = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 157 */     byte byte0 = 0;
/* 158 */     byte byte1 = 0;
/* 159 */     if (l == 0)
/* 160 */       byte1 = 1; 
/* 161 */     if (l == 1)
/* 162 */       byte0 = -1; 
/* 163 */     if (l == 2)
/* 164 */       byte1 = -1; 
/* 165 */     if (l == 3)
/* 166 */       byte0 = 1; 
/* 167 */     world.func_72921_c(i, j, k, l, 3);
/* 168 */     if (world.func_147439_a(i, j, k) == this) {
/* 169 */       world.func_147465_d(i + byte0, j, k + byte1, (Block)this, l + 8, 3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 178 */     int meta = par1IBlockAccess.func_72805_g(i, j, k);
/* 179 */     if (isBlockFootOfBed(meta)) {
/* 180 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } else {
/* 182 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/* 188 */     int meta = world.func_72805_g(i, j, k);
/* 189 */     if (isBlockFootOfBed(meta))
/* 190 */       return AxisAlignedBB.func_72330_a(i, j, k, (i + 1), (j + 0.5F), (k + 1)); 
/* 191 */     return AxisAlignedBB.func_72330_a(i, j, k, (i + 1), (j + 1), (k + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 197 */     Block block = world.func_147439_a(x, y, z);
/*     */     
/* 199 */     int dir = getDirectionFromMetadata(world.func_72805_g(x, y, z));
/* 200 */     int[] offset = HEAD_FOOT_BLOCKMAP[dir];
/*     */ 
/*     */     
/* 203 */     boolean stay = (canStay(world, x, y, z, false, dir) && canStay(world, x + offset[0], y, z + offset[1], true, dir) && (block.isAir((IBlockAccess)world, x, y, z) || block.func_149688_o().func_76222_j()));
/*     */     
/* 205 */     return stay;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlace(World world, int i, int j, int k, int dir) {
/* 210 */     int[] offset = HEAD_FOOT_BLOCKMAP[dir];
/* 211 */     Block topBlock = world.func_147439_a(i, j, k);
/* 212 */     Block footBlock = world.func_147439_a(i + offset[0], j, k + offset[1]);
/*     */ 
/*     */     
/* 215 */     boolean stay = (canStay(world, i, j, k, false, dir) && canStay(world, i + offset[0], j, k + offset[1], true, dir) && (topBlock.isAir((IBlockAccess)world, i, j, k) || topBlock.func_149688_o().func_76222_j()) && (footBlock.isAir((IBlockAccess)world, i + offset[0], j, k + offset[1]) || footBlock.func_149688_o().func_76222_j()));
/*     */     
/* 217 */     return stay;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canStay(World world, int i, int j, int k, boolean foot, int dir) {
/* 222 */     int l = dir;
/* 223 */     if (l == 0) {
/* 224 */       if (!foot && (
/* 225 */         !world.func_147439_a(i + 1, j, k).func_149721_r() || 
/* 226 */         !world.func_147439_a(i - 1, j, k).func_149721_r() || 
/* 227 */         !world.func_147439_a(i, j, k - 1).func_149721_r() || 
/* 228 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 229 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 230 */         return false; 
/* 231 */       if (foot && (
/* 232 */         !world.func_147439_a(i + 1, j, k).func_149721_r() || 
/* 233 */         !world.func_147439_a(i - 1, j, k).func_149721_r() || 
/* 234 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 235 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 236 */         return false; 
/* 237 */     }  if (l == 1) {
/* 238 */       if (!foot && (
/* 239 */         !world.func_147439_a(i, j, k + 1).func_149721_r() || 
/* 240 */         !world.func_147439_a(i, j, k - 1).func_149721_r() || 
/* 241 */         !world.func_147439_a(i + 1, j, k).func_149721_r() || 
/* 242 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 243 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 244 */         return false; 
/* 245 */       if (foot && (
/* 246 */         !world.func_147439_a(i, j, k + 1).func_149721_r() || 
/* 247 */         !world.func_147439_a(i, j, k - 1).func_149721_r() || 
/* 248 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 249 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 250 */         return false; 
/* 251 */     }  if (l == 2) {
/* 252 */       if (!foot && (
/* 253 */         !world.func_147439_a(i + 1, j, k).func_149721_r() || 
/* 254 */         !world.func_147439_a(i - 1, j, k).func_149721_r() || 
/* 255 */         !world.func_147439_a(i, j, k + 1).func_149721_r() || 
/* 256 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 257 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 258 */         return false; 
/* 259 */       if (foot && (
/* 260 */         !world.func_147439_a(i + 1, j, k).func_149721_r() || 
/* 261 */         !world.func_147439_a(i - 1, j, k).func_149721_r() || 
/* 262 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 263 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 264 */         return false; 
/* 265 */     }  if (l == 3) {
/* 266 */       if (!foot && (
/* 267 */         !world.func_147439_a(i, j, k + 1).func_149721_r() || 
/* 268 */         !world.func_147439_a(i, j, k - 1).func_149721_r() || 
/* 269 */         !world.func_147439_a(i - 1, j, k).func_149721_r() || 
/* 270 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 271 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 272 */         return false; 
/* 273 */       if (foot && (
/* 274 */         !world.func_147439_a(i, j, k + 1).func_149721_r() || 
/* 275 */         !world.func_147439_a(i, j, k - 1).func_149721_r() || 
/* 276 */         !world.func_147439_a(i, j - 1, k).func_149721_r() || world
/* 277 */         .func_147439_a(i, j + 2, k).func_149721_r()))
/* 278 */         return false; 
/* 279 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block block) {
/* 295 */     int i1 = world.func_72805_g(i, j, k);
/* 296 */     int j1 = getDirectionFromMetadata(i1);
/*     */     
/* 298 */     if (isBlockFootOfBed(i1)) {
/*     */       
/* 300 */       if (world.func_147439_a(i - HEAD_FOOT_BLOCKMAP[j1][0], j, k - HEAD_FOOT_BLOCKMAP[j1][1]) != this || !canStay(world, i, j, k, true, j1)) {
/* 301 */         world.func_147468_f(i, j, k);
/*     */       }
/* 303 */     } else if (world.func_147439_a(i + HEAD_FOOT_BLOCKMAP[j1][0], j, k + HEAD_FOOT_BLOCKMAP[j1][1]) != this || !canStay(world, i, j, k, false, j1)) {
/*     */       
/* 305 */       world.func_147468_f(i, j, k);
/* 306 */       if (!world.field_72995_K) {
/* 307 */         func_149697_b(world, i, j, k, i1, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/* 313 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 319 */     return (TileEntity)new TESluice();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 330 */     return new ItemStack(TFCItems.sluiceItem);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockSluice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */