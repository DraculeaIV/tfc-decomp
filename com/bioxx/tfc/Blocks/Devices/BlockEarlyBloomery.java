/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.CollisionRayTraceStandard;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEBloomery;
/*     */ import com.bioxx.tfc.api.Interfaces.ICustomCollision;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockEarlyBloomery
/*     */   extends BlockTerraContainer implements ICustomCollision {
/*     */   private IIcon textureOn;
/*     */   private IIcon textureOff;
/*  35 */   public static final int[][] BLOOMERY_TO_STACK_MAP = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
/*  36 */   public static final int[][] SIDES_MAP = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 0 }, { 0, 1 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockEarlyBloomery() {
/*  44 */     super(Material.field_151576_e);
/*  45 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*  46 */     func_149676_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/*  52 */     int meta = world.func_72805_g(x, y, z) & 0x4;
/*  53 */     if (meta == 0) {
/*  54 */       return 0;
/*     */     }
/*  56 */     return 15;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  62 */     if (!func_149718_j(world, x, y, z)) {
/*     */       
/*  64 */       world.func_147468_f(x, y, z);
/*  65 */       world.func_72838_d((Entity)new EntityItem(world, x, y, z, new ItemStack((Block)this, 1)));
/*     */     }
/*  67 */     else if ((TEBloomery)world.func_147438_o(x, y, z) != null) {
/*     */       
/*  69 */       TEBloomery te = (TEBloomery)world.func_147438_o(x, y, z);
/*  70 */       ItemStack is = entityplayer.func_71045_bC();
/*     */       
/*  72 */       if (is != null && (is.func_77973_b() == TFCItems.fireStarter || is.func_77973_b() == TFCItems.flintSteel)) {
/*     */         
/*  74 */         if (te.canLight()) {
/*  75 */           entityplayer.func_71045_bC().func_77972_a(1, (EntityLivingBase)entityplayer);
/*     */         }
/*     */       } else {
/*     */         
/*  79 */         world.func_72889_a(entityplayer, 1003, x, y, z, 0);
/*  80 */         if (isOpen(world.func_72805_g(x, y, z))) {
/*  81 */           world.func_72921_c(x, y, z, world.func_72805_g(x, y, z) - 8, 3);
/*     */         } else {
/*  83 */           world.func_72921_c(x, y, z, world.func_72805_g(x, y, z) + 8, 3);
/*     */         } 
/*     */       } 
/*  86 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/*  92 */     if (world.func_147437_c(x, y, z)) {
/*  93 */       return true;
/*     */     }
/*  95 */     if (world.func_147438_o(x, y, z) instanceof TEBloomery) {
/*     */       
/*  97 */       boolean flipped = false;
/*  98 */       int dir = world.func_72805_g(x, y, z) & 0x3;
/*  99 */       TEBloomery te = (TEBloomery)world.func_147438_o(x, y, z);
/*     */       
/* 101 */       if (te != null) {
/* 102 */         flipped = te.isFlipped;
/*     */       }
/* 104 */       if (checkStack(world, x, y, z, dir))
/*     */       {
/* 106 */         if (checkVertical(world, x, y, z, flipped)) {
/*     */           
/* 108 */           if (checkHorizontal(world, x, y, z, flipped)) {
/* 109 */             return true;
/*     */           }
/* 111 */         } else if (te != null && !flipped) {
/*     */           
/* 113 */           tryFlip(world, x, y, z);
/* 114 */           flipped = te.isFlipped;
/* 115 */           if (checkVertical(world, x, y, z, flipped))
/*     */           {
/* 117 */             if (checkHorizontal(world, x, y, z, flipped))
/* 118 */               return true; 
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkStack(World world, int x, int y, int z, int dir) {
/* 128 */     int[] map = BLOOMERY_TO_STACK_MAP[dir];
/* 129 */     int centerX = x + map[0];
/* 130 */     int centerZ = z + map[1];
/* 131 */     if (isNorthStackValid(world, centerX, y, centerZ - 1) || (centerX == x && centerZ - 1 == z))
/*     */     {
/* 133 */       if (isSouthStackValid(world, centerX, y, centerZ + 1) || (centerX == x && centerZ + 1 == z))
/*     */       {
/* 135 */         if (isEastStackValid(world, centerX - 1, y, centerZ) || (centerX - 1 == x && centerZ == z))
/*     */         {
/* 137 */           if (isWestStackValid(world, centerX + 1, y, centerZ) || (centerX + 1 == x && centerZ == z))
/*     */           {
/* 139 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isNorthStackValid(World world, int x, int y, int z) {
/* 149 */     return (((world.func_147439_a(x, y, z).func_149688_o() == Material.field_151576_e || world
/* 150 */       .func_147439_a(x, y, z).func_149688_o() == Material.field_151573_f) && world
/* 151 */       .func_147439_a(x, y, z).func_149721_r()) || 
/* 152 */       TFC_Core.isSouthFaceSolid(world, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSouthStackValid(World world, int x, int y, int z) {
/* 157 */     return (((world.func_147439_a(x, y, z).func_149688_o() == Material.field_151576_e || world
/* 158 */       .func_147439_a(x, y, z).func_149688_o() == Material.field_151573_f) && world
/* 159 */       .func_147439_a(x, y, z).func_149721_r()) || 
/* 160 */       TFC_Core.isNorthFaceSolid(world, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isEastStackValid(World world, int x, int y, int z) {
/* 165 */     return (((world.func_147439_a(x, y, z).func_149688_o() == Material.field_151576_e || world
/* 166 */       .func_147439_a(x, y, z).func_149688_o() == Material.field_151573_f) && world
/* 167 */       .func_147439_a(x, y, z).func_149721_r()) || 
/* 168 */       TFC_Core.isWestFaceSolid(world, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isWestStackValid(World world, int x, int y, int z) {
/* 173 */     return (((world.func_147439_a(x, y, z).func_149688_o() == Material.field_151576_e || world
/* 174 */       .func_147439_a(x, y, z).func_149688_o() == Material.field_151573_f) && world
/* 175 */       .func_147439_a(x, y, z).func_149721_r()) || 
/* 176 */       TFC_Core.isEastFaceSolid(world, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkHorizontal(World world, int x, int y, int z, boolean flip) {
/* 181 */     int dir = world.func_72805_g(x, y, z) & 0x3;
/*     */     
/* 183 */     if (flip) {
/* 184 */       dir = flipDir(dir);
/*     */     }
/* 186 */     int[] map = SIDES_MAP[dir];
/*     */     
/* 188 */     boolean l = false;
/* 189 */     boolean r = false;
/* 190 */     if ((world.func_147439_a(x - map[0], y, z - map[1]).func_149688_o() == Material.field_151576_e || world.func_147439_a(x - map[0], y, z - map[1]).func_149688_o() == Material.field_151573_f) && world.func_147439_a(x - map[0], y, z - map[1]).func_149662_c()) {
/* 191 */       l = true;
/*     */     }
/* 193 */     if ((!l && world.func_147439_a(x - map[0], y, z - map[1]) == TFCBlocks.detailed) || world.func_147439_a(x - map[0], y, z - map[1]) == TFCBlocks.stoneSlabs) {
/*     */       
/* 195 */       switch (dir) {
/*     */         
/*     */         case 0:
/* 198 */           if (TFC_Core.isNorthFaceSolid(world, x - map[0], y, z - map[1]) && TFC_Core.isEastFaceSolid(world, x - map[0], y, z - map[1]))
/* 199 */             l = true; 
/*     */           break;
/*     */         case 1:
/* 202 */           if (TFC_Core.isEastFaceSolid(world, x - map[0], y, z - map[1]) && TFC_Core.isSouthFaceSolid(world, x - map[0], y, z - map[1]))
/* 203 */             l = true; 
/*     */           break;
/*     */         case 2:
/* 206 */           if (TFC_Core.isSouthFaceSolid(world, x - map[0], y, z - map[1]) && TFC_Core.isEastFaceSolid(world, x - map[0], y, z - map[1]))
/* 207 */             l = true; 
/*     */           break;
/*     */         case 3:
/* 210 */           if (TFC_Core.isWestFaceSolid(world, x - map[0], y, z - map[1]) && TFC_Core.isSouthFaceSolid(world, x - map[0], y, z - map[1])) {
/* 211 */             l = true;
/*     */           }
/*     */           break;
/*     */       } 
/* 215 */       if (!TFC_Core.isBottomFaceSolid(world, x - map[0], y, z - map[1]))
/* 216 */         l = false; 
/* 217 */       if (!TFC_Core.isTopFaceSolid(world, x - map[0], y, z - map[1])) {
/* 218 */         l = false;
/*     */       }
/*     */     } 
/* 221 */     if ((world.func_147439_a(x + map[0], y, z + map[1]).func_149688_o() == Material.field_151576_e || world.func_147439_a(x + map[0], y, z + map[1]).func_149688_o() == Material.field_151573_f) && world.func_147439_a(x + map[0], y, z + map[1]).func_149662_c()) {
/* 222 */       r = true;
/*     */     }
/* 224 */     if ((!r && world.func_147439_a(x + map[0], y, z + map[1]) == TFCBlocks.detailed) || world.func_147439_a(x + map[0], y, z + map[1]) == TFCBlocks.stoneSlabs)
/*     */     {
/* 226 */       switch (dir) {
/*     */         
/*     */         case 0:
/* 229 */           if (TFC_Core.isNorthFaceSolid(world, x + map[0], y, z + map[1]) && TFC_Core.isWestFaceSolid(world, x + map[0], y, z + map[1]))
/* 230 */             r = true; 
/*     */           break;
/*     */         case 1:
/* 233 */           if (TFC_Core.isEastFaceSolid(world, x + map[0], y, z + map[1]) && TFC_Core.isNorthFaceSolid(world, x + map[0], y, z + map[1]))
/* 234 */             r = true; 
/*     */           break;
/*     */         case 2:
/* 237 */           if (TFC_Core.isSouthFaceSolid(world, x + map[0], y, z + map[1]) && TFC_Core.isWestFaceSolid(world, x + map[0], y, z + map[1]))
/* 238 */             r = true; 
/*     */           break;
/*     */         case 3:
/* 241 */           if (TFC_Core.isWestFaceSolid(world, x + map[0], y, z + map[1]) && TFC_Core.isNorthFaceSolid(world, x + map[0], y, z + map[1])) {
/* 242 */             r = true;
/*     */           }
/*     */           break;
/*     */       } 
/*     */     }
/* 247 */     if (!TFC_Core.isBottomFaceSolid(world, x + map[0], y, z + map[1]))
/* 248 */       r = false; 
/* 249 */     if (!TFC_Core.isTopFaceSolid(world, x + map[0], y, z + map[1])) {
/* 250 */       r = false;
/*     */     }
/* 252 */     return (l && r);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkVertical(World world, int x, int y, int z, boolean flip) {
/* 258 */     int dir = world.func_72805_g(x, y, z) & 0x3;
/*     */     
/* 260 */     if (flip) {
/* 261 */       dir = flipDir(dir);
/*     */     }
/* 263 */     boolean b = false;
/* 264 */     boolean t = false;
/* 265 */     if ((world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151576_e || world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151573_f) && world.func_147439_a(x, y - 1, z).func_149662_c()) {
/* 266 */       b = true;
/*     */     }
/* 268 */     if ((!b && world.func_147439_a(x, y - 1, z) == TFCBlocks.detailed) || world.func_147439_a(x, y - 1, z) == TFCBlocks.stoneSlabs) {
/*     */       
/* 270 */       switch (dir) {
/*     */         
/*     */         case 0:
/* 273 */           if (TFC_Core.isNorthFaceSolid(world, x, y - 1, z) && TFC_Core.isEastFaceSolid(world, x, y - 1, z) && TFC_Core.isWestFaceSolid(world, x, y - 1, z))
/* 274 */             b = true; 
/*     */           break;
/*     */         case 1:
/* 277 */           if (TFC_Core.isEastFaceSolid(world, x, y - 1, z) && TFC_Core.isNorthFaceSolid(world, x, y - 1, z) && TFC_Core.isSouthFaceSolid(world, x, y - 1, z))
/* 278 */             b = true; 
/*     */           break;
/*     */         case 2:
/* 281 */           if (TFC_Core.isSouthFaceSolid(world, x, y - 1, z) && TFC_Core.isEastFaceSolid(world, x, y - 1, z) && TFC_Core.isWestFaceSolid(world, x, y - 1, z))
/* 282 */             b = true; 
/*     */           break;
/*     */         case 3:
/* 285 */           if (TFC_Core.isWestFaceSolid(world, x, y - 1, z) && TFC_Core.isNorthFaceSolid(world, x, y - 1, z) && TFC_Core.isSouthFaceSolid(world, x, y - 1, z)) {
/* 286 */             b = true;
/*     */           }
/*     */           break;
/*     */       } 
/* 290 */       if (!TFC_Core.isTopFaceSolid(world, x, y - 1, z)) {
/* 291 */         b = false;
/*     */       }
/*     */     } 
/* 294 */     if ((world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151576_e || world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151573_f) && world.func_147439_a(x, y + 1, z).func_149662_c()) {
/* 295 */       t = true;
/*     */     }
/* 297 */     if ((!t && world.func_147439_a(x, y + 1, z) == TFCBlocks.detailed) || world.func_147439_a(x, y + 1, z) == TFCBlocks.stoneSlabs) {
/*     */       
/* 299 */       switch (dir) {
/*     */         
/*     */         case 0:
/* 302 */           if (TFC_Core.isNorthFaceSolid(world, x, y + 1, z) && TFC_Core.isEastFaceSolid(world, x, y + 1, z) && TFC_Core.isWestFaceSolid(world, x, y + 1, z))
/* 303 */             t = true; 
/*     */           break;
/*     */         case 1:
/* 306 */           if (TFC_Core.isEastFaceSolid(world, x, y + 1, z) && TFC_Core.isNorthFaceSolid(world, x, y + 1, z) && TFC_Core.isSouthFaceSolid(world, x, y + 1, z))
/* 307 */             t = true; 
/*     */           break;
/*     */         case 2:
/* 310 */           if (TFC_Core.isSouthFaceSolid(world, x, y + 1, z) && TFC_Core.isEastFaceSolid(world, x, y + 1, z) && TFC_Core.isWestFaceSolid(world, x, y + 1, z))
/* 311 */             t = true; 
/*     */           break;
/*     */         case 3:
/* 314 */           if (TFC_Core.isWestFaceSolid(world, x, y + 1, z) && TFC_Core.isNorthFaceSolid(world, x, y + 1, z) && TFC_Core.isSouthFaceSolid(world, x, y + 1, z)) {
/* 315 */             t = true;
/*     */           }
/*     */           break;
/*     */       } 
/* 319 */       if (!TFC_Core.isBottomFaceSolid(world, x, y + 1, z) || !TFC_Core.isTopFaceSolid(world, x, y + 1, z)) {
/* 320 */         t = false;
/*     */       }
/*     */     } 
/* 323 */     return (b && t);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 329 */     return func_149718_j(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 335 */     int lit = ((j & 0x4) == 4) ? 1 : 0;
/* 336 */     if (!isOpen(j))
/*     */     {
/* 338 */       if (lit == 1)
/* 339 */         return this.textureOn; 
/*     */     }
/* 341 */     return this.textureOff;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 347 */     this.textureOn = iconRegisterer.func_94245_a("terrafirmacraft:devices/Bloomery On");
/* 348 */     this.textureOff = iconRegisterer.func_94245_a("terrafirmacraft:devices/Bloomery Off");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack is) {
/* 354 */     if (!world.field_72995_K) {
/*     */       
/* 356 */       int dir = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */       
/* 358 */       world.func_72921_c(x, y, z, dir, 2);
/* 359 */       if (!func_149718_j(world, x, y, z))
/*     */       {
/* 361 */         func_149642_a(world, x, y, z, new ItemStack((Block)this, 1));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 369 */     clearStack(world, x, y, z);
/* 370 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearStack(World world, int x, int y, int z) {
/* 375 */     if (!world.field_72995_K) {
/*     */       
/* 377 */       world.func_147468_f(x, y, z);
/* 378 */       int meta = world.func_72805_g(x, y, z);
/* 379 */       int[] dir = BLOOMERY_TO_STACK_MAP[meta & 0x3];
/* 380 */       if (world.func_147439_a(x + dir[0], y, z + dir[1]) == TFCBlocks.molten)
/* 381 */         world.func_147468_f(x + dir[0], y, z + dir[1]); 
/* 382 */       if (world.func_147439_a(x + dir[0], y + 1, z + dir[1]) == TFCBlocks.molten)
/* 383 */         world.func_147468_f(x + dir[0], y + 1, z + dir[1]); 
/* 384 */       if (world.func_147439_a(x + dir[0], y + 2, z + dir[1]) == TFCBlocks.molten)
/* 385 */         world.func_147468_f(x + dir[0], y + 2, z + dir[1]); 
/* 386 */       if (world.func_147439_a(x + dir[0], y + 3, z + dir[1]) == TFCBlocks.molten) {
/* 387 */         world.func_147468_f(x + dir[0], y + 3, z + dir[1]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 394 */     if (!func_149718_j(world, x, y, z))
/*     */     {
/* 396 */       if (!tryFlip(world, x, y, z)) {
/*     */         
/* 398 */         world.func_147468_f(x, y, z);
/* 399 */         func_149642_a(world, x, y, z, new ItemStack((Block)this, 1));
/*     */       }
/* 401 */       else if (!func_149718_j(world, x, y, z)) {
/*     */         
/* 403 */         world.func_147468_f(x, y, z);
/* 404 */         func_149642_a(world, x, y, z, new ItemStack((Block)this, 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static int flipDir(int dir) {
/* 410 */     int out = 0;
/* 411 */     if (dir - 2 >= 0) {
/* 412 */       out = dir - 2;
/* 413 */     } else if (dir + 2 < 4) {
/* 414 */       out = dir + 2;
/* 415 */     }  return out;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean tryFlip(World world, int x, int y, int z) {
/* 420 */     TEBloomery te = (TEBloomery)world.func_147438_o(x, y, z);
/* 421 */     te.swapFlipped();
/* 422 */     return func_149718_j(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 428 */     return (TileEntity)new TEBloomery();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 465 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isOpen(int par0) {
/* 470 */     return ((par0 & 0x8) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 476 */     return TFCBlocks.bloomeryRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 482 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 488 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCollisionBoxesToList(World world, int x, int y, int z, List<Object[]> list) {
/* 494 */     int meta = world.func_72805_g(x, y, z);
/* 495 */     int dir = meta & 0x3;
/* 496 */     if (world.func_147438_o(x, y, z) instanceof TEBloomery) {
/*     */       
/* 498 */       TEBloomery te = (TEBloomery)world.func_147438_o(x, y, z);
/* 499 */       if (te.isFlipped)
/* 500 */         dir = flipDir(dir); 
/*     */     } 
/* 502 */     float f = 0.125F;
/*     */     
/* 504 */     if (!isOpen(meta)) {
/*     */       
/* 506 */       if (dir == 0) {
/* 507 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, f) });
/* 508 */       } else if (dir == 1) {
/* 509 */         list.add(new Object[] { AxisAlignedBB.func_72330_a((1.0F - f), 0.0D, 0.0D, 1.0D, 1.0D, 1.0D) });
/* 510 */       } else if (dir == 2) {
/* 511 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, (1.0F - f), 1.0D, 1.0D, 1.0D) });
/* 512 */       } else if (dir == 3) {
/* 513 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, f, 1.0D, 1.0D) });
/*     */       }
/*     */     
/*     */     }
/* 517 */     else if (dir == 0) {
/*     */       
/* 519 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, f, 1.0D, 0.5D) });
/* 520 */       list.add(new Object[] { AxisAlignedBB.func_72330_a((1.0F - f), 0.0D, 0.0D, 1.0D, 1.0D, 0.5D) });
/*     */     }
/* 522 */     else if (dir == 1) {
/*     */       
/* 524 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.5D, 0.0D, 0.0D, 1.0D, 1.0D, f) });
/* 525 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.5D, 0.0D, (1.0F - f), 1.0D, 1.0D, 1.0D) });
/*     */     }
/* 527 */     else if (dir == 2) {
/*     */       
/* 529 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.5D, f, 1.0D, 1.0D) });
/* 530 */       list.add(new Object[] { AxisAlignedBB.func_72330_a((1.0F - f), 0.0D, 0.5D, 1.0D, 1.0D, 1.0D) });
/*     */     }
/* 532 */     else if (dir == 3) {
/*     */       
/* 534 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 0.5D, 1.0D, f) });
/* 535 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, (1.0F - f), 0.5D, 1.0D, 1.0D) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 player, Vec3 view) {
/* 543 */     return CollisionRayTraceStandard.collisionRayTrace(this, world, x, y, z, player, view);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess bAccess, int x, int y, int z, int side) {
/* 550 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_149642_a(World world, int x, int y, int z, ItemStack is) {
/* 556 */     if (!world.field_72995_K && world.func_82736_K().func_82766_b("doTileDrops")) {
/*     */       
/* 558 */       clearStack(world, x, y, z);
/* 559 */       EntityItem ei = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, is);
/* 560 */       ei.field_70159_w = 0.0D;
/* 561 */       ei.field_70181_x = 0.0D;
/* 562 */       ei.field_70179_y = 0.0D;
/* 563 */       ei.field_145804_b = 10;
/* 564 */       world.func_72838_d((Entity)ei);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockEarlyBloomery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */