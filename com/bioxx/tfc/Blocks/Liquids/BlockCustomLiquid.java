/*     */ package com.bioxx.tfc.Blocks.Liquids;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Vanilla.BlockCustomLilyPad;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDynamicLiquid;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BlockCustomLiquid
/*     */   extends BlockDynamicLiquid
/*     */   implements IFluidBlock
/*     */ {
/*     */   protected Fluid fluidType;
/*     */   protected IIcon[] icons;
/*     */   protected int sourceBlockCount;
/*  39 */   protected boolean[] canFlowDirections = new boolean[4];
/*  40 */   protected int[] flowPriorities = new int[4];
/*     */ 
/*     */   
/*     */   public BlockCustomLiquid(Fluid fluid, Material mat) {
/*  44 */     super(mat);
/*  45 */     float f = 0.0F;
/*  46 */     float f1 = 0.0F;
/*  47 */     func_149676_a(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
/*  48 */     func_149675_a(true);
/*  49 */     this.fluidType = fluid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149646_a(IBlockAccess world, int x, int y, int z, int side) {
/*  56 */     Block block = world.func_147439_a(x, y, z);
/*  57 */     if (block.func_149688_o() == func_149688_o())
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     return super.func_149646_a(world, x, y, z, side);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity e) {
/*  68 */     if (this.field_149764_J == Material.field_151587_i)
/*     */     {
/*  70 */       if (e instanceof net.minecraft.entity.item.EntityItem)
/*     */       {
/*  72 */         e.func_70015_d(15);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  85 */     if (this.field_149764_J != Material.field_151586_h) {
/*  86 */       return 16777215;
/*     */     }
/*  88 */     return 3493173;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/*  98 */     if (world.func_147439_a(x, y, z) == this)
/*     */     {
/* 100 */       world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */     }
/* 102 */     checkForHarden(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 113 */     checkForHarden(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkForHarden(World world, int x, int y, int z) {
/* 121 */     if (world.func_147439_a(x, y, z) == this && 
/* 122 */       this.field_149764_J == Material.field_151587_i) {
/*     */       
/* 124 */       boolean flag = false;
/*     */       
/* 126 */       if (flag || world.func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151586_h) {
/* 127 */         flag = true;
/*     */       }
/* 129 */       if (flag || world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151586_h) {
/* 130 */         flag = true;
/*     */       }
/* 132 */       if (flag || world.func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151586_h) {
/* 133 */         flag = true;
/*     */       }
/* 135 */       if (flag || world.func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151586_h) {
/* 136 */         flag = true;
/*     */       }
/* 138 */       if (flag || world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151586_h) {
/* 139 */         flag = true;
/*     */       }
/* 141 */       if (flag) {
/*     */         
/* 143 */         int l = world.func_72805_g(x, y, z);
/*     */         
/* 145 */         if (l == 0) {
/* 146 */           setBlockforLava(world, x, y, z, 0);
/* 147 */         } else if (l <= 4) {
/* 148 */           setBlockforLava(world, x, y, z, 1);
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
/*     */   public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
/*     */     boolean isBeach, hasWater;
/* 177 */     Block plant = plantable.getPlant(world, x, y + 1, z);
/* 178 */     if (plant == TFCBlocks.cactus && this == TFCBlocks.cactus)
/*     */     {
/* 180 */       return true;
/*     */     }
/* 182 */     if (plant == TFCBlocks.reeds && this == TFCBlocks.reeds)
/*     */     {
/* 184 */       return true;
/*     */     }
/*     */     
/* 187 */     int meta = world.func_72805_g(x, y, z);
/* 188 */     if (plant instanceof BlockCustomLilyPad && ((BlockCustomLilyPad)plant).canThisPlantGrowOnThisBlock((Block)this, meta))
/*     */     {
/* 190 */       return true;
/*     */     }
/*     */     
/* 193 */     EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
/* 194 */     switch (plantType) {
/*     */       case Desert:
/* 196 */         return TFC_Core.isSand((Block)this);
/* 197 */       case Nether: return (this == Blocks.field_150425_aM);
/* 198 */       case Crop: return TFC_Core.isFarmland((Block)this);
/* 199 */       case Cave: return isSideSolid(world, x, y, z, ForgeDirection.UP);
/* 200 */       case Plains: return (this == TFCBlocks.grass || this == TFCBlocks.grass2 || this == TFCBlocks.dirt || this == TFCBlocks.dirt2);
/* 201 */       case Water: return (world.func_147439_a(x, y, z).func_149688_o() == Material.field_151586_h && world.func_72805_g(x, y, z) == 0);
/*     */       case Beach:
/* 203 */         isBeach = TFC_Core.isGround((Block)this);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 208 */         hasWater = (world.func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151586_h);
/* 209 */         return (isBeach && hasWater);
/*     */     } 
/*     */     
/* 212 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlockforLava(World world, int x, int y, int z, int typeOfLava) {
/* 217 */     DataLayer rockLayer3 = TFC_Climate.getCacheManager(world).getRockLayerAt(x, y, 2);
/*     */     
/* 219 */     int meta = rockLayer3.data2;
/* 220 */     Random rand = new Random();
/* 221 */     boolean felsicLava = true;
/*     */     
/* 223 */     if (this == TFCBlocks.stoneIgIn && (meta == 2 || meta == 1)) {
/* 224 */       felsicLava = false;
/* 225 */     } else if (this == TFCBlocks.stoneIgEx && (meta == 1 || meta == 2)) {
/* 226 */       felsicLava = false;
/* 227 */     }  if (typeOfLava == 0 || typeOfLava == 2) {
/*     */       
/* 229 */       if (felsicLava) {
/*     */         
/* 231 */         if (rand.nextInt(10) == 0 && typeOfLava == 0) {
/* 232 */           world.func_147449_b(x, y, z, Blocks.field_150343_Z);
/*     */         } else {
/*     */           
/* 235 */           world.func_147449_b(x, y, z, TFCBlocks.stoneIgEx);
/* 236 */           world.func_72921_c(x, y, z, 0, 0);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 241 */         world.func_147449_b(x, y, z, TFCBlocks.stoneIgEx);
/* 242 */         world.func_72921_c(x, y, z, 1, 0);
/*     */       }
/*     */     
/* 245 */     } else if (typeOfLava == 1) {
/*     */       
/* 247 */       world.func_147449_b(x, y, z, TFCBlocks.stoneIgExCobble);
/* 248 */       if (felsicLava) {
/* 249 */         world.func_72921_c(x, y, z, 0, 0);
/*     */       } else {
/* 251 */         world.func_72921_c(x, y, z, 1, 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 258 */     if (func_149688_o() == Material.field_151587_i)
/* 259 */       return 10; 
/* 260 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister register) {
/* 266 */     if (this.field_149764_J == Material.field_151587_i) {
/*     */       
/* 268 */       getFluid().setIcons(register.func_94245_a("lava_still"), register.func_94245_a("lava_flow"));
/*     */     }
/*     */     else {
/*     */       
/* 272 */       getFluid().setIcons(register.func_94245_a("water_still"), register.func_94245_a("water_flow"));
/*     */     } 
/* 274 */     this.icons = new IIcon[] { getFluid().getStillIcon(), getFluid().getFlowingIcon() };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 281 */     return (side != 0 && side != 1) ? this.icons[1] : this.icons[0];
/*     */   }
/*     */   public Fluid getFluid() {
/* 284 */     return this.fluidType;
/*     */   }
/*     */   
/*     */   public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public boolean canDrain(World world, int x, int y, int z) {
/* 292 */     return false;
/*     */   }
/*     */   
/*     */   public float getFilledPercentage(World world, int x, int y, int z) {
/* 296 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canStay(World world, int x, int y, int z) {
/* 301 */     Block block = world.func_147439_a(x, y, z);
/* 302 */     if (block == TFCBlocks.thatch || block == TFCBlocks.barrel || block == TFCBlocks.vessel || block == TFCBlocks.berryBush || block == TFCBlocks.smokeRack || block instanceof com.bioxx.tfc.Blocks.Vanilla.BlockCustomDoor || block == TFCBlocks.ingotPile)
/*     */     {
/* 304 */       return false;
/*     */     }
/* 306 */     return func_149807_p(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getLiquidHeight(World world, int x, int y, int z, int count) {
/* 311 */     int liquidHeight = getMetaData(world, x, y, z);
/*     */ 
/*     */     
/* 314 */     if (liquidHeight < 0)
/*     */     {
/* 316 */       return count;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 321 */     if (liquidHeight == 0) {
/* 322 */       this.sourceBlockCount++;
/* 323 */     } else if (liquidHeight >= 8) {
/* 324 */       liquidHeight = 0;
/*     */     } 
/* 326 */     return (count >= 0 && liquidHeight >= count) ? count : liquidHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 333 */     int meta = getMetaData(world, x, y, z);
/* 334 */     byte b0 = 1;
/*     */     
/* 336 */     if (this.field_149764_J == Material.field_151587_i && !world.field_73011_w.field_76575_d)
/*     */     {
/* 338 */       b0 = 2;
/*     */     }
/*     */     
/* 341 */     boolean flag = true;
/* 342 */     int tickRate = func_149738_a(world);
/*     */ 
/*     */     
/* 345 */     if (meta > 0) {
/*     */       
/* 347 */       this.sourceBlockCount = 0;
/* 348 */       int liquidHeight = getLiquidHeight(world, x - 1, y, z, -100);
/* 349 */       liquidHeight = getLiquidHeight(world, x + 1, y, z, liquidHeight);
/* 350 */       liquidHeight = getLiquidHeight(world, x, y, z - 1, liquidHeight);
/* 351 */       liquidHeight = getLiquidHeight(world, x, y, z + 1, liquidHeight);
/* 352 */       int newHeight = liquidHeight + b0;
/*     */       
/* 354 */       if (newHeight >= 8 || liquidHeight < 0)
/*     */       {
/* 356 */         newHeight = -1;
/*     */       }
/*     */ 
/*     */       
/* 360 */       if (getMetaData(world, x, y + 1, z) >= 0) {
/*     */         
/* 362 */         int metaAbove = getMetaData(world, x, y + 1, z);
/*     */         
/* 364 */         if (metaAbove >= 8) {
/*     */           
/* 366 */           newHeight = metaAbove;
/*     */         }
/*     */         else {
/*     */           
/* 370 */           newHeight = metaAbove + 8;
/*     */         } 
/*     */       } 
/*     */       
/* 374 */       if (this.sourceBlockCount >= 2 && this.field_149764_J == Material.field_151586_h && !TFCOptions.enableFiniteWater)
/*     */       {
/*     */         
/* 377 */         if (world.func_147439_a(x, y - 1, z).func_149688_o().func_76220_a() || (world
/* 378 */           .func_147439_a(x, y - 1, z).func_149688_o() == this.field_149764_J && world.func_72805_g(x, y - 1, z) == 0))
/*     */         {
/* 380 */           newHeight = 0;
/*     */         }
/*     */       }
/*     */       
/* 384 */       if (this.field_149764_J == Material.field_151587_i && meta < 8 && newHeight < 8 && newHeight > meta && rand.nextInt(4) != 0)
/*     */       {
/* 386 */         tickRate *= 4;
/*     */       }
/*     */       
/* 389 */       if (newHeight == meta) {
/*     */         
/* 391 */         if (flag)
/*     */         {
/* 393 */           convertFlowingToSource(world, x, y, z);
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 398 */         meta = newHeight;
/*     */         
/* 400 */         if (newHeight < 0)
/*     */         {
/* 402 */           world.func_147468_f(x, y, z);
/*     */         }
/*     */         else
/*     */         {
/* 406 */           world.func_72921_c(x, y, z, newHeight, 2);
/* 407 */           world.func_147464_a(x, y, z, (Block)this, tickRate);
/* 408 */           world.func_147459_d(x, y, z, (Block)this);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 414 */       convertFlowingToSource(world, x, y, z);
/*     */     } 
/*     */     
/* 417 */     if (canReplace(world, x, y - 1, z)) {
/*     */       
/* 419 */       if (this.field_149764_J == Material.field_151587_i && world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151586_h) {
/*     */         
/* 421 */         setBlockforLava(world, x, y - 1, z, 2);
/* 422 */         func_149799_m(world, x, y - 1, z);
/*     */         
/*     */         return;
/*     */       } 
/* 426 */       if (meta >= 8)
/*     */       {
/* 428 */         flow(world, x, y - 1, z, meta);
/*     */       }
/*     */       else
/*     */       {
/* 432 */         flow(world, x, y - 1, z, meta + 8);
/*     */       }
/*     */     
/* 435 */     } else if (meta >= 0 && (meta == 0 || canStay(world, x, y - 1, z))) {
/*     */       
/* 437 */       int newHeight = meta + b0;
/*     */       
/* 439 */       if (meta >= 8)
/*     */       {
/* 441 */         newHeight = 1;
/*     */       }
/*     */       
/* 444 */       if (newHeight >= 8) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 449 */       boolean[] flowDirections = getFlowDirections(world, x, y, z);
/* 450 */       if (flowDirections[0])
/*     */       {
/* 452 */         flow(world, x - 1, y, z, newHeight);
/*     */       }
/*     */       
/* 455 */       if (flowDirections[1])
/*     */       {
/* 457 */         flow(world, x + 1, y, z, newHeight);
/*     */       }
/*     */       
/* 460 */       if (flowDirections[2])
/*     */       {
/* 462 */         flow(world, x, y, z - 1, newHeight);
/*     */       }
/*     */       
/* 465 */       if (flowDirections[3])
/*     */       {
/* 467 */         flow(world, x, y, z + 1, newHeight);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void flow(World world, int x, int y, int z, int meta) {
/* 474 */     if (canReplace(world, x, y, z)) {
/*     */       
/* 476 */       Block block = world.func_147439_a(x, y, z);
/*     */       
/* 478 */       if (this.field_149764_J == Material.field_151587_i) {
/*     */         
/* 480 */         setBlockforLava(world, x, y, z, 0);
/* 481 */         func_149799_m(world, x, y - 1, z);
/*     */       }
/*     */       else {
/*     */         
/* 485 */         block.func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/*     */       } 
/*     */       
/* 488 */       world.func_147465_d(x, y, z, (Block)this, meta, 3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canReplace(World world, int x, int y, int z) {
/* 494 */     Material material = world.func_147439_a(x, y, z).func_149688_o();
/* 495 */     if (material == this.field_149764_J || material == Material.field_151587_i) {
/* 496 */       return false;
/*     */     }
/* 498 */     return !canStay(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean[] getFlowDirections(World world, int x, int y, int z) {
/*     */     int side;
/* 506 */     for (side = 0; side < 4; side++) {
/*     */       
/* 508 */       this.flowPriorities[side] = 1000;
/* 509 */       int i = x;
/* 510 */       int newZ = z;
/*     */       
/* 512 */       if (side == 0) {
/* 513 */         i = x - 1;
/* 514 */       } else if (side == 1) {
/* 515 */         i++;
/* 516 */       } else if (side == 2) {
/* 517 */         newZ = z - 1;
/* 518 */       } else if (side == 3) {
/* 519 */         newZ++;
/*     */       } 
/* 521 */       if (!canStay(world, i, y, newZ) && (world.func_147439_a(i, y, newZ).func_149688_o() != this.field_149764_J || world.func_72805_g(i, y, newZ) != 0))
/*     */       {
/* 523 */         if (canStay(world, i, y - 1, newZ)) {
/*     */           
/* 525 */           this.flowPriorities[side] = getFlowPriorities(world, i, y, newZ, 1, side);
/*     */         }
/*     */         else {
/*     */           
/* 529 */           this.flowPriorities[side] = 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 534 */     side = this.flowPriorities[0];
/*     */     int newX;
/* 536 */     for (newX = 1; newX < 4; newX++) {
/*     */       
/* 538 */       if (this.flowPriorities[newX] < side)
/*     */       {
/* 540 */         side = this.flowPriorities[newX];
/*     */       }
/*     */     } 
/*     */     
/* 544 */     for (newX = 0; newX < 4; newX++)
/*     */     {
/* 546 */       this.canFlowDirections[newX] = (this.flowPriorities[newX] == side);
/*     */     }
/*     */     
/* 549 */     return this.canFlowDirections;
/*     */   }
/*     */ 
/*     */   
/*     */   private void convertFlowingToSource(World world, int x, int y, int z) {
/* 554 */     int meta = world.func_72805_g(x, y, z);
/* 555 */     world.func_147465_d(x, y, z, Block.func_149729_e(Block.func_149682_b((Block)this) + 1), meta, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   private int getFlowPriorities(World world, int x, int y, int z, int distance, int side) {
/* 560 */     int priority = 1000;
/*     */     
/* 562 */     for (int side2 = 0; side2 < 4; side2++) {
/*     */       
/* 564 */       if ((side2 != 0 || side != 1) && (side2 != 1 || side != 0) && (side2 != 2 || side != 3) && (side2 != 3 || side != 2)) {
/*     */         
/* 566 */         int xCoord = x;
/* 567 */         int zCoord = z;
/*     */         
/* 569 */         if (side2 == 0) {
/* 570 */           xCoord = x - 1;
/* 571 */         } else if (side2 == 1) {
/* 572 */           xCoord++;
/* 573 */         } else if (side2 == 2) {
/* 574 */           zCoord = z - 1;
/* 575 */         } else if (side2 == 3) {
/* 576 */           zCoord++;
/*     */         } 
/* 578 */         if (!canStay(world, xCoord, y, zCoord) && (world.func_147439_a(xCoord, y, zCoord).func_149688_o() != this.field_149764_J || world.func_72805_g(xCoord, y, zCoord) != 0)) {
/*     */           
/* 580 */           if (!canStay(world, xCoord, y - 1, zCoord))
/*     */           {
/* 582 */             return distance;
/*     */           }
/*     */           
/* 585 */           if (distance < 4) {
/*     */             
/* 587 */             int newDistance = getFlowPriorities(world, xCoord, y, zCoord, distance + 1, side2);
/*     */             
/* 589 */             if (newDistance < priority)
/*     */             {
/* 591 */               priority = newDistance;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 598 */     return priority;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getMetaData(World world, int x, int y, int z) {
/* 603 */     return (world.func_147439_a(x, y, z).func_149688_o() == this.field_149764_J) ? world.func_72805_g(x, y, z) : -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Liquids\BlockCustomLiquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */