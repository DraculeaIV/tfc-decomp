/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockWoodSupport
/*     */   extends BlockTerra
/*     */ {
/*     */   protected String[] woodNames;
/*     */   protected IIcon[] icons;
/*     */   
/*     */   public BlockWoodSupport(Material material) {
/*  36 */     super(Material.field_151575_d);
/*  37 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  38 */     this.woodNames = new String[16];
/*  39 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  40 */     this.icons = new IIcon[this.woodNames.length];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  47 */     if (TFCBlocks.isBlockVSupport(this))
/*     */     {
/*  49 */       for (int i = 0; i < this.woodNames.length; i++) {
/*  50 */         list.add(new ItemStack(this, 1, i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean hasSupportsInRange(World world, int x, int y, int z, int range) {
/*  56 */     return (getSupportsInRangeDir(world, x, y, z, range, false) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSupportConnected(World world, int x, int y, int z) {
/*  61 */     return (getSupportsInRangeDir(world, x, y, z, 5, true) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ForgeDirection getSupportDirection(World world, int x, int y, int z) {
/*  66 */     int[] r = getSupportsInRangeDir(world, x, y, z, 5, false);
/*  67 */     if (r != null) {
/*     */       
/*  69 */       if (r[2] > r[3])
/*  70 */         return ForgeDirection.NORTH; 
/*  71 */       if (r[3] > r[2])
/*  72 */         return ForgeDirection.SOUTH; 
/*  73 */       if (r[5] > r[4])
/*  74 */         return ForgeDirection.EAST; 
/*  75 */       if (r[4] > r[5]) {
/*  76 */         return ForgeDirection.WEST;
/*     */       }
/*     */     } 
/*  79 */     return ForgeDirection.UNKNOWN;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDistanceFromDirection(ForgeDirection dir, int[] dist) {
/*  84 */     switch (dir) {
/*     */       case NORTH:
/*  86 */         return dist[2];
/*  87 */       case SOUTH: return dist[3];
/*  88 */       case WEST: return dist[4];
/*  89 */       case EAST: return dist[5];
/*  90 */     }  return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] getSupportsInRangeDir(World world, int x, int y, int z, int range, boolean checkConnection) {
/*  97 */     int n = 0; boolean foundNV = false, foundNH = true;
/*  98 */     int s = 0; boolean foundSV = false, foundSH = true;
/*  99 */     int e = 0; boolean foundEV = false, foundEH = true;
/* 100 */     int w = 0; boolean foundWV = false, foundWH = true;
/* 101 */     boolean clearNorthPath = true;
/* 102 */     boolean clearSouthPath = true;
/* 103 */     boolean clearEastPath = true;
/* 104 */     boolean clearWestPath = true;
/*     */     
/* 106 */     for (int i = 1; i <= range; i++) {
/*     */       
/* 108 */       if (!foundEV) {
/*     */         
/* 110 */         if (!checkConnection) {
/*     */           
/* 112 */           if (world.func_147437_c(x + i, y, z) || TFCBlocks.isBlockVSupport(world.func_147439_a(x + i, y, z))) {
/* 113 */             e++;
/*     */           } else {
/* 115 */             clearEastPath = false;
/*     */           } 
/* 117 */         } else if (checkConnection && !TFCBlocks.isBlockHSupport(world.func_147439_a(x + i, y, z)) && !TFCBlocks.isBlockVSupport(world.func_147439_a(x + i, y, z))) {
/* 118 */           foundEH = false;
/*     */         } else {
/* 120 */           e++;
/* 121 */         }  if (clearEastPath && TFCBlocks.isBlockVSupport(world.func_147439_a(x + i, y, z)) && (e >= 0 || i == 1))
/*     */         {
/* 123 */           if (scanVert(world, x + i, y, z)) {
/* 124 */             foundEV = true;
/*     */           } else {
/* 126 */             e -= 50;
/*     */           }  } 
/*     */       } 
/* 129 */       if (!foundWV) {
/*     */         
/* 131 */         if (!checkConnection) {
/*     */           
/* 133 */           if (world.func_147437_c(x - i, y, z) || TFCBlocks.isBlockVSupport(world.func_147439_a(x - i, y, z))) {
/* 134 */             w++;
/*     */           } else {
/* 136 */             clearWestPath = false;
/*     */           } 
/* 138 */         } else if (checkConnection && !TFCBlocks.isBlockHSupport(world.func_147439_a(x - i, y, z)) && !TFCBlocks.isBlockVSupport(world.func_147439_a(x - i, y, z))) {
/* 139 */           foundWH = false;
/*     */         } else {
/* 141 */           w++;
/* 142 */         }  if (clearWestPath && TFCBlocks.isBlockVSupport(world.func_147439_a(x - i, y, z)) && (w >= 0 || i == 1))
/*     */         {
/* 144 */           if (scanVert(world, x - i, y, z)) {
/* 145 */             foundWV = true;
/*     */           } else {
/* 147 */             w -= 50;
/*     */           }  } 
/*     */       } 
/* 150 */       if (!foundSV) {
/*     */         
/* 152 */         if (!checkConnection) {
/*     */           
/* 154 */           if (world.func_147437_c(x, y, z + i) || TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + i))) {
/* 155 */             s++;
/*     */           } else {
/* 157 */             clearSouthPath = false;
/*     */           }
/*     */         
/* 160 */         } else if (checkConnection && !TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z + i)) && !TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + i))) {
/* 161 */           foundSH = false;
/*     */         } else {
/* 163 */           s++;
/* 164 */         }  if (clearSouthPath && TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + i)) && (s >= 0 || i == 1))
/*     */         {
/* 166 */           if (scanVert(world, x, y, z + i))
/* 167 */             foundSV = true; 
/*     */         }
/*     */       } 
/* 170 */       if (!foundNV) {
/*     */         
/* 172 */         if (!checkConnection) {
/*     */           
/* 174 */           if (world.func_147437_c(x, y, z - i) || TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - i))) {
/* 175 */             n++;
/*     */           } else {
/* 177 */             clearNorthPath = false;
/*     */           } 
/* 179 */         } else if (checkConnection && !TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z - i)) && !TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - i))) {
/* 180 */           foundNH = false;
/*     */         } else {
/* 182 */           n++;
/* 183 */         }  if (clearNorthPath && TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - i)) && (n >= 0 || i == 1))
/*     */         {
/* 185 */           if (scanVert(world, x, y, z - i)) {
/* 186 */             foundNV = true;
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/* 191 */     if (foundEV && foundEH && foundWV && foundWH)
/* 192 */       return new int[] { 0, 0, 0, 0, w, e }; 
/* 193 */     if (foundSV && foundSH && foundNV && foundNH)
/* 194 */       return new int[] { 0, 0, n, s, 0, 0 }; 
/* 195 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean scanVert(World world, int x, int y, int z) {
/* 200 */     int out = 1;
/* 201 */     while (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y - out, z))) {
/* 202 */       out++;
/*     */     }
/* 204 */     return (out > 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int isNextToSupport(World world, int x, int y, int z) {
/* 215 */     if (TFCBlocks.isBlockVSupport(world.func_147439_a(x + 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x + 1, y, z)))
/* 216 */       return 5; 
/* 217 */     if (TFCBlocks.isBlockVSupport(world.func_147439_a(x - 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x - 1, y, z)))
/* 218 */       return 4; 
/* 219 */     if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z + 1)))
/* 220 */       return 3; 
/* 221 */     if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z - 1)))
/* 222 */       return 2; 
/* 223 */     return 0;
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
/*     */   public int func_149692_a(int j) {
/* 245 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 251 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 252 */     Block b = world.func_147439_a(x, y, z);
/* 253 */     if (b == TFCBlocks.woodSupportH || b == TFCBlocks.woodSupportV) {
/* 254 */       ret.add(new ItemStack(TFCBlocks.woodSupportV, 1, metadata));
/* 255 */     } else if (b == TFCBlocks.woodSupportH2 || b == TFCBlocks.woodSupportV2) {
/* 256 */       ret.add(new ItemStack(TFCBlocks.woodSupportV2, 1, metadata));
/* 257 */     }  return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 263 */     if (meta < 0)
/* 264 */       return this.icons[0]; 
/* 265 */     if (meta < this.icons.length)
/* 266 */       return this.icons[meta]; 
/* 267 */     return TFCBlocks.woodSupportH2.func_149691_a(side, meta - 16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 273 */     for (int i = 0; i < this.woodNames.length; i++) {
/* 274 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/WoodSheet/" + this.woodNames[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 280 */     return getCollisionBoundingBoxFromPoolIBlockAccess((IBlockAccess)world, x, y, z).func_72325_c(x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private AxisAlignedBB getCollisionBoundingBoxFromPoolIBlockAccess(IBlockAccess blockAccess, int x, int y, int z) {
/* 285 */     Boolean isHorizontal = Boolean.valueOf(TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(x, y, z)));
/*     */ 
/*     */     
/* 288 */     double minX = 0.25D, minY = 0.0D, minZ = 0.25D;
/* 289 */     double maxX = 0.75D, maxY = 0.75D, maxZ = 0.75D;
/*     */     
/* 291 */     if (isHorizontal.booleanValue()) {
/*     */       
/* 293 */       minY = 0.5D;
/* 294 */       maxY = 1.0D;
/* 295 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(x + 1, y, z)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(x + 1, y, z)))
/* 296 */         maxX = 1.0D; 
/* 297 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(x - 1, y, z)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(x - 1, y, z)))
/* 298 */         minX = 0.0D; 
/* 299 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(x, y, z + 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(x, y, z + 1)))
/* 300 */         maxZ = 1.0D; 
/* 301 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(x, y, z - 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(x, y, z - 1))) {
/* 302 */         minZ = 0.0D;
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 308 */       minY = 0.0D;
/* 309 */       maxY = 1.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 320 */     return AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess blockAccess, int x, int y, int z) {
/* 326 */     AxisAlignedBB aabb = getCollisionBoundingBoxFromPoolIBlockAccess(blockAccess, x, y, z);
/* 327 */     func_149676_a((float)aabb.field_72340_a, (float)aabb.field_72338_b, (float)aabb.field_72339_c, (float)aabb.field_72336_d, (float)aabb.field_72337_e, (float)aabb.field_72334_f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 333 */     if (TFCBlocks.isBlockVSupport(this)) {
/* 334 */       return TFCBlocks.woodSupportRenderIdV;
/*     */     }
/* 336 */     return TFCBlocks.woodSupportRenderIdH;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 342 */     Boolean isHorizontal = Boolean.valueOf(TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z)));
/*     */ 
/*     */     
/* 345 */     double minX = 0.25D, minY = 0.0D, minZ = 0.25D;
/* 346 */     double maxX = 0.75D, maxY = 0.75D, maxZ = 0.75D;
/*     */ 
/*     */     
/* 349 */     if (isHorizontal.booleanValue()) {
/*     */       
/* 351 */       minY = 0.5D;
/* 352 */       maxY = 1.0D;
/* 353 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x + 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x + 1, y, z)))
/* 354 */         maxX = 1.0D; 
/* 355 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x - 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x - 1, y, z)))
/* 356 */         minX = 0.0D; 
/* 357 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z + 1)))
/* 358 */         maxZ = 1.0D; 
/* 359 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z - 1)))
/* 360 */         minZ = 0.0D; 
/* 361 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y - 1, z))) {
/* 362 */         minY = 0.0D;
/*     */       }
/*     */     } else {
/*     */       
/* 366 */       minY = 0.0D;
/* 367 */       maxY = 1.0D;
/* 368 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x + 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x + 1, y, z)))
/* 369 */         maxX = 1.0D; 
/* 370 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x - 1, y, z)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x - 1, y, z)))
/* 371 */         minX = 0.0D; 
/* 372 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z + 1)))
/* 373 */         maxZ = 1.0D; 
/* 374 */       if (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - 1)) || TFCBlocks.isBlockHSupport(world.func_147439_a(x, y, z - 1))) {
/* 375 */         minZ = 0.0D;
/*     */       }
/*     */     } 
/* 378 */     return AxisAlignedBB.func_72330_a(x + minX, y + minY, z + minZ, x + maxX, y + maxY, z + maxZ);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/* 384 */     if (this == TFCBlocks.woodSupportH) {
/* 385 */       func_149642_a(world, i, j, k, new ItemStack(TFCBlocks.woodSupportV, 1, l));
/* 386 */     } else if (this == TFCBlocks.woodSupportH2) {
/* 387 */       func_149642_a(world, i, j, k, new ItemStack(TFCBlocks.woodSupportV2, 1, l));
/*     */     } else {
/* 389 */       func_149642_a(world, i, j, k, new ItemStack(this, 1, l));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149637_q() {
/* 395 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 401 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 407 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 414 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entity, ItemStack is) {
/* 420 */     super.func_149689_a(world, i, j, k, entity, is);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block l) {
/* 428 */     boolean isOtherHorizontal = TFCBlocks.isBlockHSupport(l);
/*     */     
/* 430 */     boolean isHorizontal = TFCBlocks.isBlockHSupport(world.func_147439_a(i, j, k));
/* 431 */     boolean isVertical = TFCBlocks.isBlockVSupport(world.func_147439_a(i, j, k));
/*     */     
/* 433 */     int meta = world.func_72805_g(i, j, k);
/*     */     
/* 435 */     if (isVertical && !isOtherHorizontal) {
/*     */ 
/*     */       
/* 438 */       if (!world.func_147439_a(i, j - 1, k).func_149662_c() && !TFCBlocks.isBlockVSupport(world.func_147439_a(i, j - 1, k)))
/*     */       {
/* 440 */         func_149636_a(world, (EntityPlayer)null, i, j, k, meta);
/* 441 */         world.func_147468_f(i, j, k);
/*     */       }
/*     */     
/* 444 */     } else if (isHorizontal) {
/*     */       
/* 446 */       boolean b1 = !isSupportConnected(world, i, j, k);
/* 447 */       if (b1) {
/*     */         
/* 449 */         func_149636_a(world, (EntityPlayer)null, i, j, k, meta);
/* 450 */         world.func_147468_f(i, j, k);
/*     */       }
/* 452 */       else if (TFCBlocks.isBlockVSupport(world.func_147439_a(i, j - 1, k))) {
/*     */         
/* 454 */         if (this == TFCBlocks.woodSupportH) {
/* 455 */           world.func_147465_d(i, j, k, TFCBlocks.woodSupportV, meta, 2);
/* 456 */         } else if (this == TFCBlocks.woodSupportH2) {
/* 457 */           world.func_147465_d(i, j, k, TFCBlocks.woodSupportV2, meta, 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149707_d(World world, int x, int y, int z, int side) {
/* 465 */     Block downBlock = world.func_147439_a(x, y - 1, z);
/*     */ 
/*     */     
/* 468 */     if (!TFCBlocks.isBlockVSupport(downBlock)) {
/*     */       
/* 470 */       if (side == 0 && world.func_147437_c(x, y - 1, z))
/*     */       {
/* 472 */         return true;
/*     */       }
/* 474 */       if (side == 1 && downBlock.func_149662_c())
/*     */       {
/* 476 */         return true;
/*     */       }
/* 478 */       if (side == 2) {
/*     */         
/* 480 */         if (isNextToSupport(world, x, y, z) != 0 && hasSupportsInRange(world, x, y, z, 5)) {
/* 481 */           return true;
/*     */         }
/* 483 */       } else if (side == 3) {
/*     */         
/* 485 */         if (isNextToSupport(world, x, y, z) != 0 && hasSupportsInRange(world, x, y, z, 5)) {
/* 486 */           return true;
/*     */         }
/* 488 */       } else if (side == 4) {
/*     */         
/* 490 */         if (isNextToSupport(world, x, y, z) != 0 && hasSupportsInRange(world, x, y, z, 5)) {
/* 491 */           return true;
/*     */         }
/* 493 */       } else if (side == 5) {
/*     */         
/* 495 */         if (isNextToSupport(world, x, y, z) != 0 && hasSupportsInRange(world, x, y, z, 5)) {
/* 496 */           return true;
/*     */         }
/*     */       } 
/* 499 */     } else if (TFCBlocks.isBlockVSupport(downBlock) || downBlock.func_149662_c()) {
/*     */       
/* 501 */       if (side == 1 && world.func_147437_c(x, y, z))
/* 502 */         return true; 
/* 503 */       if (side == 2 && (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z - 1)) || world.func_147439_a(x, y, z - 1).func_149662_c()) && world.func_147437_c(x, y, z - 1))
/* 504 */         return true; 
/* 505 */       if (side == 3 && (TFCBlocks.isBlockVSupport(world.func_147439_a(x, y, z + 1)) || world.func_147439_a(x, y, z + 1).func_149662_c()) && world.func_147437_c(x, y, z + 1))
/* 506 */         return true; 
/* 507 */       if (side == 4 && (TFCBlocks.isBlockVSupport(world.func_147439_a(x - 1, y, z)) || world.func_147439_a(x - 1, y, z).func_149662_c()) && world.func_147437_c(x - 1, y, z))
/* 508 */         return true; 
/* 509 */       if (side == 5 && (TFCBlocks.isBlockVSupport(world.func_147439_a(x + 1, y, z)) || world.func_147439_a(x + 1, y, z).func_149662_c()) && world.func_147437_c(x + 1, y, z)) {
/* 510 */         return true;
/*     */       }
/*     */     } 
/* 513 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockWoodSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */