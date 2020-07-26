/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.EntityFallingBlockTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.api.Enums.TFCDirection;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.ByteCoord;
/*     */ import com.bioxx.tfc.api.Util.CollapseData;
/*     */ import com.bioxx.tfc.api.Util.CollapseList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCollapsible
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public Block dropBlock;
/*     */   public static boolean fallInstantly;
/*     */   
/*     */   protected BlockCollapsible(Material material, Block block) {
/*  39 */     super(material);
/*  40 */     this.dropBlock = block;
/*  41 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockCollapsible(Material material) {
/*  46 */     super(material);
/*  47 */     this.dropBlock = Blocks.field_150350_a;
/*  48 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] getDropBlock(World world, int x, int y, int z) {
/*  53 */     int[] data = new int[2];
/*  54 */     data[0] = Block.func_149682_b(this.dropBlock);
/*  55 */     data[1] = world.func_72805_g(x, y, z);
/*  56 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canFallBelow(World world, int x, int y, int z) {
/*  62 */     if (world.func_147437_c(x, y, z))
/*  63 */       return true; 
/*  64 */     Block block = world.func_147439_a(x, y, z);
/*  65 */     if (block == Blocks.field_150480_ab)
/*  66 */       return true; 
/*  67 */     if (block == TFCBlocks.tallGrass)
/*  68 */       return true; 
/*  69 */     if (block == TFCBlocks.torch)
/*  70 */       return true; 
/*  71 */     if (block == TFCBlocks.smokeRack)
/*  72 */       return true; 
/*  73 */     if (block == TFCBlocks.toolRack) {
/*  74 */       return true;
/*     */     }
/*  76 */     if (block == Blocks.field_150357_h)
/*  77 */       return false; 
/*  78 */     if (block == TFCBlocks.charcoal)
/*  79 */       return false; 
/*  80 */     if (block == TFCBlocks.molten) {
/*  81 */       return false;
/*     */     }
/*  83 */     if (!block.func_149662_c() && !block.func_149686_d() && !world.isSideSolid(x, y, z, ForgeDirection.UP)) {
/*  84 */       return true;
/*     */     }
/*  86 */     Material material = block.func_149688_o();
/*  87 */     return (material == Material.field_151586_h || material == Material.field_151587_i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropCarvedStone(World world, int x, int y, int z) {
/*  92 */     if (world.func_147439_a(x + 1, y, z).func_149662_c())
/*     */       return; 
/*  94 */     if (world.func_147439_a(x - 1, y, z).func_149662_c())
/*     */       return; 
/*  96 */     if (world.func_147439_a(x, y, z + 1).func_149662_c())
/*     */       return; 
/*  98 */     if (world.func_147439_a(x, y, z - 1).func_149662_c())
/*     */       return; 
/* 100 */     if (world.func_147439_a(x, y + 1, z).func_149662_c())
/*     */       return; 
/* 102 */     if (world.func_147439_a(x, y - 1, z).func_149662_c()) {
/*     */       return;
/*     */     }
/* 105 */     func_149642_a(world, x, y, z, new ItemStack((Block)this, 1, world.func_72805_g(x, y, z)));
/* 106 */     world.func_147468_f(x, y, z);
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
/*     */   public static Boolean isNearSupport(World world, int i, int j, int k, int range, float collapseChance) {
/* 169 */     for (int y = -1; y <= 1; y++) {
/*     */       
/* 171 */       for (int x = -range; x <= range; x++) {
/*     */         
/* 173 */         for (int z = -range; z <= range; z++) {
/*     */ 
/*     */           
/* 176 */           if (x == 0 && z == 0 && world != null && TFC_Core.isVertSupport(world.func_147439_a(i + x, j + y, k + z)))
/*     */           {
/* 178 */             return Boolean.valueOf(true);
/*     */           }
/* 180 */           if (world != null && TFC_Core.isHorizSupport(world.func_147439_a(i + x, j + y, k + z)))
/*     */           {
/* 182 */             if (world.field_73012_v.nextFloat() < collapseChance / 100.0F)
/* 183 */             { world.func_147468_f(i + x, j + y, k + z); }
/* 184 */             else { return Boolean.valueOf(true); }
/*     */              } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 189 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isUnderLoad(World world, int i, int j, int k) {
/* 194 */     for (int x = 1; x <= TFCOptions.minimumRockLoad; x++) {
/*     */       
/* 196 */       if (!world.func_147439_a(i, j + x, k).func_149662_c())
/* 197 */         return Boolean.valueOf(false); 
/*     */     } 
/* 199 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean tryToCollapse(World world, int x, int y, int z, float collapseChance) {
/* 204 */     int[] drop = getDropBlock(world, x, y, z);
/* 205 */     Block fallingBlock = Block.func_149729_e(drop[0]);
/*     */     
/* 207 */     if (world.func_147439_a(x, y, z) == Blocks.field_150357_h || world.func_147439_a(x, y, z) == fallingBlock) {
/* 208 */       return Boolean.valueOf(false);
/*     */     }
/* 210 */     int fallingBlockMeta = drop[1];
/* 211 */     if (canFallBelow(world, x, y - 1, z) && !isNearSupport(world, x, y, z, 4, collapseChance).booleanValue() && isUnderLoad(world, x, y, z).booleanValue())
/*     */     {
/* 213 */       if (!world.field_72995_K && fallingBlock != Blocks.field_150350_a) {
/*     */         
/* 215 */         if (fallingBlock != null) {
/*     */           
/* 217 */           EntityFallingBlockTFC ent = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), fallingBlock, fallingBlockMeta);
/*     */ 
/*     */           
/* 220 */           if (this instanceof BlockStone) {
/* 221 */             ent = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), fallingBlock, fallingBlockMeta + 8);
/*     */           }
/* 223 */           ent.aliveTimer = -5000;
/* 224 */           world.func_72838_d((Entity)ent);
/* 225 */           Random r = new Random((x * y + z));
/* 226 */           if (r.nextInt(100) > 90) {
/* 227 */             world.func_72956_a((Entity)ent, "terrafirmacraft:rock.slide.long", 1.0F, 0.8F + r.nextFloat() / 2.0F);
/*     */           }
/*     */         } 
/* 230 */         if (world.func_147439_a(x, y, z) instanceof BlockOre && !TFCOptions.enableCaveInsDestroyOre) {
/*     */           
/* 232 */           TFC_Core.setBlockToAirWithDrops(world, x, y, z);
/*     */         } else {
/*     */           
/* 235 */           world.func_147468_f(x, y, z);
/*     */         } 
/* 237 */         if (world.func_147439_a(x, y - 1, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 1, z)).field_145854_h == this && ((TEPartial)world
/* 238 */           .func_147438_o(x, y - 1, z)).metaID == fallingBlockMeta) {
/*     */           
/* 240 */           world.func_147468_f(x, y - 1, z);
/*     */           
/* 242 */           if (world.func_147439_a(x, y - 2, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 2, z)).field_145854_h == this && ((TEPartial)world
/* 243 */             .func_147438_o(x, y - 2, z)).metaID == fallingBlockMeta) {
/*     */             
/* 245 */             world.func_147468_f(x, y - 2, z);
/*     */             
/* 247 */             if (world.func_147439_a(x, y - 3, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 3, z)).field_145854_h == this && ((TEPartial)world
/* 248 */               .func_147438_o(x, y - 3, z)).metaID == fallingBlockMeta) {
/* 249 */               world.func_147468_f(x, y - 3, z);
/*     */             }
/*     */           } 
/*     */         } 
/* 253 */         return Boolean.valueOf(true);
/*     */       } 
/*     */     }
/* 256 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void tryToFall(World world, int x, int y, int z, Block block) {
/* 261 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/* 264 */       int meta = world.func_72805_g(x, y, z);
/* 265 */       if (canFallBelow(world, x, y - 1, z) && y >= 0 && (!isNearSupport(world, x, y, z, 4, 0.0F).booleanValue() || block instanceof BlockSand)) {
/*     */         
/* 267 */         byte byte0 = 32;
/*     */         
/* 269 */         if (!fallInstantly && world.func_72904_c(x - byte0, y - byte0, z - byte0, x + byte0, y + byte0, z + byte0)) {
/*     */           
/* 271 */           if (!world.field_72995_K) {
/*     */             
/* 273 */             EntityFallingBlockTFC entityfallingblock = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), block, meta);
/* 274 */             world.func_72838_d((Entity)entityfallingblock);
/* 275 */             if (block instanceof BlockCobble) {
/* 276 */               world.func_72956_a((Entity)entityfallingblock, "terrafirmacraft:rock.slide.short", 1.0F, 0.8F + world.field_73012_v.nextFloat() / 2.0F);
/*     */             } else {
/* 278 */               world.func_72956_a((Entity)entityfallingblock, "terrafirmacraft:dirt.slide.short", 1.0F, 0.8F + world.field_73012_v.nextFloat() / 2.0F);
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 283 */           world.func_147468_f(x, y, z);
/*     */           
/* 285 */           while (canFallBelow(world, x, y - 1, z) && y > 0)
/*     */           {
/* 287 */             y--;
/*     */           }
/*     */           
/* 290 */           if (y > 0)
/*     */           {
/* 292 */             world.func_147465_d(x, y, z, block, meta, 2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
/* 303 */     float softModifier = 0.1F;
/*     */     
/* 305 */     int finalCollapseRatio = (TFCOptions.initialCollapseRatio > 0) ? TFCOptions.initialCollapseRatio : 10;
/*     */ 
/*     */     
/* 308 */     if (entityplayer != null) {
/*     */       
/* 310 */       entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 311 */       entityplayer.func_71020_j(0.075F);
/*     */     } 
/*     */ 
/*     */     
/* 315 */     if (this == TFCBlocks.stoneSed) {
/* 316 */       finalCollapseRatio = (int)(finalCollapseRatio - finalCollapseRatio * softModifier);
/*     */     }
/*     */     
/* 319 */     if (TFCOptions.enableCaveIns && world.field_73012_v.nextInt(finalCollapseRatio) == 0) {
/*     */ 
/*     */       
/* 322 */       int counter = 0;
/* 323 */       while (counter < 100) {
/*     */         
/* 325 */         int scanX = -4 + world.field_73012_v.nextInt(9);
/* 326 */         int scanY = -2 + world.field_73012_v.nextInt(5);
/* 327 */         int scanZ = -4 + world.field_73012_v.nextInt(9);
/* 328 */         if (world.func_147439_a(x + scanX, y + scanY, z + scanZ) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 329 */           .func_147439_a(x + scanX, y + scanY, z + scanZ)).tryToCollapse(world, x + scanX, y + scanY, z + scanZ, 0.0F).booleanValue()) {
/*     */           
/* 331 */           triggerCollapse(world, entityplayer, x + scanX, y + scanY, z + scanZ, meta);
/*     */           return;
/*     */         } 
/* 334 */         counter++;
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
/*     */   public void triggerCollapse(World world, EntityPlayer entityplayer, int i, int j, int k, int meta) {
/* 351 */     int height = 4;
/* 352 */     int range = 5 + world.field_73012_v.nextInt(31);
/* 353 */     for (int y = -4; y <= 1; y++) {
/*     */       
/* 355 */       for (int x = -range; x <= range; x++) {
/*     */         
/* 357 */         for (int z = -range; z <= range; z++) {
/*     */           
/* 359 */           double distSqrd = Math.pow((i - i + x), 2.0D) + Math.pow((j - j + y), 2.0D) + Math.pow((k - k + z), 2.0D);
/*     */           
/* 361 */           if (world.field_73012_v.nextInt(100) < TFCOptions.propogateCollapseChance && distSqrd < 1225.0D)
/*     */           {
/* 363 */             if (world.func_147439_a(i + x, j + y, k + z) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 364 */               .func_147439_a(i + x, j + y, k + z)).tryToCollapse(world, i + x, j + y, k + z, 1.0F).booleanValue()) {
/*     */               
/* 366 */               int done = 0;
/* 367 */               while (done < height) {
/*     */                 
/* 369 */                 done++;
/* 370 */                 if (world.func_147439_a(i + x, j + y, k + z) instanceof BlockCollapsible && world.field_73012_v.nextInt(100) < TFCOptions.propogateCollapseChance) {
/* 371 */                   ((BlockCollapsible)world.func_147439_a(i + x, j + y, k + z)).tryToCollapse(world, i + x, j + y + done, k + z, 1.0F); continue;
/*     */                 } 
/* 373 */                 done = height;
/*     */               } 
/*     */             } 
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
/*     */ 
/*     */   
/*     */   public List<ByteCoord> getCollapseMap(World world, int i, int j, int k) {
/* 390 */     ArrayList<ByteCoord> map = new ArrayList<ByteCoord>();
/* 391 */     ArrayList<ByteCoord> checkedmap = new ArrayList<ByteCoord>();
/* 392 */     CollapseList<CollapseData> checkQueue = new CollapseList();
/* 393 */     float incrementChance = 2.5F;
/* 394 */     float incrementChanceDiag = 3.5F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 403 */     map.add(new ByteCoord(0, 0, 0));
/*     */     
/* 405 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.EAST));
/* 406 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.WEST));
/* 407 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHEAST));
/* 408 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHEAST));
/* 409 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHWEST));
/* 410 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHWEST));
/* 411 */     checkQueue.add(new CollapseData(new ByteCoord(0, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTH));
/* 412 */     checkQueue.add(new CollapseData(new ByteCoord(0, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.NORTH));
/*     */     
/* 414 */     while (checkQueue.peek() != null) {
/*     */       
/* 416 */       CollapseData block = (CollapseData)checkQueue.peek();
/* 417 */       if (!checkedmap.contains(block) && world.field_73012_v.nextFloat() < block.collapseChance / 100.0F) {
/*     */ 
/*     */ 
/*     */         
/* 421 */         int worldX = block.coords.x + i;
/* 422 */         int worldY = block.coords.y + j;
/* 423 */         int worldZ = block.coords.z + k;
/* 424 */         int localX = block.coords.x;
/* 425 */         int localY = block.coords.y;
/* 426 */         int localZ = block.coords.z;
/* 427 */         if (world.func_147437_c(worldX, worldY, worldZ)) {
/* 428 */           checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 1, localZ + 0), block.collapseChance - 10.0F, TFCDirection.UP));
/* 429 */         } else if (world.func_147439_a(worldX, worldY, worldZ) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 430 */           .func_147439_a(worldX, worldY, worldZ)).tryToCollapse(world, worldX, worldY, worldZ, block.collapseChance).booleanValue()) {
/*     */           
/* 432 */           map.add(block.coords);
/*     */           
/* 434 */           switch (block.direction) {
/*     */ 
/*     */             
/*     */             case NORTH:
/* 438 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/* 439 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 440 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTH:
/* 445 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 446 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 447 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case EAST:
/* 452 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 453 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 454 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case WEST:
/* 459 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 460 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/* 461 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHEAST:
/* 466 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHEAST));
/* 467 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 468 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHWEST:
/* 473 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHWEST));
/* 474 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 475 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHEAST:
/* 480 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHEAST));
/* 481 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 482 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHWEST:
/* 487 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHWEST));
/* 488 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/* 489 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             default:
/* 494 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 495 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/* 496 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHEAST));
/* 497 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHEAST));
/* 498 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHWEST));
/* 499 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHWEST));
/* 500 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 501 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */           } 
/*     */         
/*     */         } 
/*     */       } 
/* 507 */       checkedmap.add(block.coords);
/* 508 */       checkQueue.removeFirst();
/*     */     } 
/* 510 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion ex) {
/* 516 */     func_149636_a(world, (EntityPlayer)null, x, y, z, world.func_72805_g(x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
/* 522 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockCollapsible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */