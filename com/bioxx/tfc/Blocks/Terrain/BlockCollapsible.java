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
/*  62 */     Block block = world.func_147439_a(x, y, z);
/*  63 */     if (block.isAir((IBlockAccess)world, x, y, z))
/*  64 */       return true; 
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
/*     */   public static void updateTickCollapsible(World world, int i, int j, int k, Random random, Block us, boolean checkForSupport) {
/* 169 */     if (world.field_72995_K)
/*     */       return; 
/* 171 */     if (canFallBelow(world, i, j - 1, k)) {
/*     */       
/* 173 */       if (checkForSupport && isNearSupport(world, i, j, k, 4, 0.0F).booleanValue())
/* 174 */         return;  tryToFall(world, i, j, k, us);
/*     */       
/*     */       return;
/*     */     } 
/* 178 */     int airSides = 0;
/* 179 */     boolean[] sides = new boolean[4];
/*     */     
/* 181 */     if (world.func_147437_c(i + 1, j, k)) {
/*     */       
/* 183 */       airSides++;
/* 184 */       if (canFallBelow(world, i + 1, j - 1, k))
/* 185 */         sides[0] = true; 
/*     */     } 
/* 187 */     if (world.func_147437_c(i, j, k + 1)) {
/*     */       
/* 189 */       airSides++;
/* 190 */       if (canFallBelow(world, i, j - 1, k + 1))
/* 191 */         sides[1] = true; 
/*     */     } 
/* 193 */     if (world.func_147437_c(i - 1, j, k)) {
/*     */       
/* 195 */       airSides++;
/* 196 */       if (canFallBelow(world, i - 1, j - 1, k))
/* 197 */         sides[2] = true; 
/*     */     } 
/* 199 */     if (world.func_147437_c(i, j, k - 1)) {
/*     */       
/* 201 */       airSides++;
/* 202 */       if (canFallBelow(world, i, j - 1, k - 1)) {
/* 203 */         sides[3] = true;
/*     */       }
/*     */     } 
/* 206 */     if (airSides > 2 && (sides[0] || sides[1] || sides[2] || sides[3])) {
/*     */       
/* 208 */       if (checkForSupport && isNearSupport(world, i, j, k, 4, 0.0F).booleanValue())
/* 209 */         return;  int meta = world.func_72805_g(i, j, k);
/* 210 */       world.func_147468_f(i, j, k);
/* 211 */       int rng = random.nextInt(4);
/* 212 */       while (!sides[rng])
/*     */       {
/* 214 */         rng = (rng + 1) % 4;
/*     */       }
/* 216 */       switch (rng) {
/*     */ 
/*     */         
/*     */         case 0:
/* 220 */           world.func_147465_d(i + 1, j, k, us, meta, 2);
/* 221 */           tryToFall(world, i + 1, j, k, us);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 226 */           world.func_147465_d(i, j, k + 1, us, meta, 2);
/* 227 */           tryToFall(world, i, j, k + 1, us);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 232 */           world.func_147465_d(i - 1, j, k, us, meta, 2);
/* 233 */           tryToFall(world, i - 1, j, k, us);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 238 */           world.func_147465_d(i, j, k - 1, us, meta, 2);
/* 239 */           tryToFall(world, i, j, k - 1, us);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Boolean isNearSupport(World world, int i, int j, int k, int range, float collapseChance) {
/* 248 */     if (world == null) return Boolean.valueOf(false); 
/* 249 */     if (!world.func_72873_a(i, j, k, range + 1)) return Boolean.valueOf(true); 
/* 250 */     for (int y = -1; y <= 1; y++) {
/*     */       
/* 252 */       if (TFC_Core.isVertSupport(world.func_147439_a(i, j + y, k)))
/*     */       {
/* 254 */         return Boolean.valueOf(true);
/*     */       }
/*     */     } 
/* 257 */     for (int x = -range; x <= range; x++) {
/*     */       
/* 259 */       for (int z = -range; z <= range; z++) {
/*     */         
/* 261 */         for (int m = -1; m <= 1; m++) {
/*     */           
/* 263 */           if (TFC_Core.isHorizSupport(world.func_147439_a(i + x, j + m, k + z)))
/*     */           {
/*     */             
/* 266 */             if (world.field_73012_v.nextFloat() < collapseChance / 100.0F) {
/*     */               
/* 268 */               world.func_147468_f(i + x, j + m, k + z);
/*     */             }
/*     */             else {
/*     */               
/* 272 */               return Boolean.valueOf(true);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 278 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isUnderLoad(World world, int i, int j, int k) {
/* 283 */     for (int x = 1; x <= TFCOptions.minimumRockLoad; x++) {
/*     */       
/* 285 */       if (!world.func_147439_a(i, j + x, k).func_149662_c())
/* 286 */         return Boolean.valueOf(false); 
/*     */     } 
/* 288 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean tryToCollapse(World world, int x, int y, int z, float collapseChance) {
/* 293 */     if (world.field_72995_K) {
/* 294 */       return Boolean.valueOf(false);
/*     */     }
/* 296 */     int[] drop = getDropBlock(world, x, y, z);
/* 297 */     Block fallingBlock = Block.func_149729_e(drop[0]);
/*     */     
/* 299 */     if (fallingBlock == Blocks.field_150350_a) {
/* 300 */       return Boolean.valueOf(false);
/*     */     }
/* 302 */     if (world.func_147439_a(x, y, z) == Blocks.field_150357_h || world.func_147439_a(x, y, z) == fallingBlock) {
/* 303 */       return Boolean.valueOf(false);
/*     */     }
/* 305 */     int fallingBlockMeta = drop[1];
/* 306 */     if (canFallBelow(world, x, y - 1, z) && isUnderLoad(world, x, y, z).booleanValue() && !isNearSupport(world, x, y, z, 4, collapseChance).booleanValue()) {
/*     */       
/* 308 */       if (fallingBlock != null) {
/*     */         
/* 310 */         EntityFallingBlockTFC ent = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), fallingBlock, fallingBlockMeta);
/*     */ 
/*     */         
/* 313 */         if (this instanceof BlockStone) {
/* 314 */           ent = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), fallingBlock, fallingBlockMeta + 8);
/*     */         }
/* 316 */         ent.aliveTimer = -5000;
/* 317 */         world.func_72838_d((Entity)ent);
/* 318 */         Random r = new Random((x * y + z));
/* 319 */         if (r.nextInt(100) > 90)
/*     */         {
/* 321 */           world.func_72956_a((Entity)ent, "terrafirmacraft:rock.slide.long", 1.0F, 0.8F + r.nextFloat() / 2.0F);
/*     */         }
/*     */       } 
/*     */       
/* 325 */       if (world.func_147439_a(x, y, z) instanceof BlockOre && !TFCOptions.enableCaveInsDestroyOre) {
/*     */         
/* 327 */         TFC_Core.setBlockToAirWithDrops(world, x, y, z);
/*     */       }
/*     */       else {
/*     */         
/* 331 */         world.func_147468_f(x, y, z);
/*     */       } 
/*     */       
/* 334 */       if (world.func_147439_a(x, y - 1, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 1, z)).field_145854_h == this && ((TEPartial)world
/* 335 */         .func_147438_o(x, y - 1, z)).metaID == fallingBlockMeta) {
/*     */         
/* 337 */         world.func_147468_f(x, y - 1, z);
/*     */         
/* 339 */         if (world.func_147439_a(x, y - 2, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 2, z)).field_145854_h == this && ((TEPartial)world
/* 340 */           .func_147438_o(x, y - 2, z)).metaID == fallingBlockMeta) {
/*     */           
/* 342 */           world.func_147468_f(x, y - 2, z);
/*     */           
/* 344 */           if (world.func_147439_a(x, y - 3, z) == TFCBlocks.stoneSlabs && ((TEPartial)world.func_147438_o(x, y - 3, z)).field_145854_h == this && ((TEPartial)world
/* 345 */             .func_147438_o(x, y - 3, z)).metaID == fallingBlockMeta) {
/* 346 */             world.func_147468_f(x, y - 3, z);
/*     */           }
/*     */         } 
/*     */       } 
/* 350 */       return Boolean.valueOf(true);
/*     */     } 
/* 352 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void tryToFall(World world, int x, int y, int z, Block block) {
/* 357 */     if (world.field_72995_K)
/*     */       return; 
/* 359 */     int meta = world.func_72805_g(x, y, z);
/* 360 */     if (canFallBelow(world, x, y - 1, z) && y >= 0 && (block instanceof BlockSand || !isNearSupport(world, x, y, z, 4, 0.0F).booleanValue()))
/*     */     {
/* 362 */       if (!fallInstantly && world.func_72904_c(x - 32, y - 32, z - 32, x + 32, y + 32, z + 32)) {
/*     */         
/* 364 */         if (!world.field_72995_K) {
/*     */           
/* 366 */           EntityFallingBlockTFC entityfallingblock = new EntityFallingBlockTFC(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), block, meta);
/* 367 */           world.func_72838_d((Entity)entityfallingblock);
/* 368 */           if (block instanceof BlockCobble) {
/* 369 */             world.func_72956_a((Entity)entityfallingblock, "terrafirmacraft:rock.slide.short", 1.0F, 0.8F + world.field_73012_v.nextFloat() / 2.0F);
/*     */           } else {
/* 371 */             world.func_72956_a((Entity)entityfallingblock, "terrafirmacraft:dirt.slide.short", 1.0F, 0.8F + world.field_73012_v.nextFloat() / 2.0F);
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 376 */         world.func_147468_f(x, y, z);
/*     */         
/* 378 */         while (canFallBelow(world, x, y - 1, z) && y > 0)
/*     */         {
/* 380 */           y--;
/*     */         }
/*     */         
/* 383 */         if (y > 0)
/*     */         {
/* 385 */           world.func_147465_d(x, y, z, block, meta, 2);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
/* 395 */     float softModifier = 0.1F;
/*     */     
/* 397 */     int finalCollapseRatio = (TFCOptions.initialCollapseRatio > 0) ? TFCOptions.initialCollapseRatio : 10;
/*     */ 
/*     */     
/* 400 */     if (entityplayer != null) {
/*     */       
/* 402 */       entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 403 */       entityplayer.func_71020_j(0.075F);
/*     */     } 
/*     */ 
/*     */     
/* 407 */     if (this == TFCBlocks.stoneSed) {
/* 408 */       finalCollapseRatio = (int)(finalCollapseRatio - finalCollapseRatio * softModifier);
/*     */     }
/*     */     
/* 411 */     if (TFCOptions.enableCaveIns && world.field_73012_v.nextInt(finalCollapseRatio) == 0) {
/*     */ 
/*     */       
/* 414 */       int counter = 0;
/* 415 */       while (counter < 100) {
/*     */         
/* 417 */         int scanX = -4 + world.field_73012_v.nextInt(9);
/* 418 */         int scanY = -2 + world.field_73012_v.nextInt(5);
/* 419 */         int scanZ = -4 + world.field_73012_v.nextInt(9);
/* 420 */         if (world.func_147439_a(x + scanX, y + scanY, z + scanZ) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 421 */           .func_147439_a(x + scanX, y + scanY, z + scanZ)).tryToCollapse(world, x + scanX, y + scanY, z + scanZ, 0.0F).booleanValue()) {
/*     */           
/* 423 */           triggerCollapse(world, entityplayer, x + scanX, y + scanY, z + scanZ, meta);
/*     */           return;
/*     */         } 
/* 426 */         counter++;
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
/* 443 */     int height = 4;
/* 444 */     int range = 5 + world.field_73012_v.nextInt(31);
/* 445 */     for (int y = -4; y <= 1; y++) {
/*     */       
/* 447 */       for (int x = -range; x <= range; x++) {
/*     */         
/* 449 */         for (int z = -range; z <= range; z++) {
/*     */           
/* 451 */           double distSqrd = Math.pow((i - i + x), 2.0D) + Math.pow((j - j + y), 2.0D) + Math.pow((k - k + z), 2.0D);
/*     */           
/* 453 */           if (world.field_73012_v.nextInt(100) < TFCOptions.propogateCollapseChance && distSqrd < 1225.0D)
/*     */           {
/* 455 */             if (world.func_147439_a(i + x, j + y, k + z) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 456 */               .func_147439_a(i + x, j + y, k + z)).tryToCollapse(world, i + x, j + y, k + z, 1.0F).booleanValue()) {
/*     */               
/* 458 */               int done = 0;
/* 459 */               while (done < height) {
/*     */                 
/* 461 */                 done++;
/* 462 */                 if (world.func_147439_a(i + x, j + y, k + z) instanceof BlockCollapsible && world.field_73012_v.nextInt(100) < TFCOptions.propogateCollapseChance) {
/* 463 */                   ((BlockCollapsible)world.func_147439_a(i + x, j + y, k + z)).tryToCollapse(world, i + x, j + y + done, k + z, 1.0F); continue;
/*     */                 } 
/* 465 */                 done = height;
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
/* 482 */     ArrayList<ByteCoord> map = new ArrayList<ByteCoord>();
/* 483 */     ArrayList<ByteCoord> checkedmap = new ArrayList<ByteCoord>();
/* 484 */     CollapseList<CollapseData> checkQueue = new CollapseList();
/* 485 */     float incrementChance = 2.5F;
/* 486 */     float incrementChanceDiag = 3.5F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 495 */     map.add(new ByteCoord(0, 0, 0));
/*     */     
/* 497 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.EAST));
/* 498 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, 0), TFCOptions.propogateCollapseChance, TFCDirection.WEST));
/* 499 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHEAST));
/* 500 */     checkQueue.add(new CollapseData(new ByteCoord(1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHEAST));
/* 501 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.NORTHWEST));
/* 502 */     checkQueue.add(new CollapseData(new ByteCoord(-1, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTHWEST));
/* 503 */     checkQueue.add(new CollapseData(new ByteCoord(0, 0, 1), TFCOptions.propogateCollapseChance, TFCDirection.SOUTH));
/* 504 */     checkQueue.add(new CollapseData(new ByteCoord(0, 0, -1), TFCOptions.propogateCollapseChance, TFCDirection.NORTH));
/*     */     
/* 506 */     while (checkQueue.peek() != null) {
/*     */       
/* 508 */       CollapseData block = (CollapseData)checkQueue.peek();
/* 509 */       if (!checkedmap.contains(block) && world.field_73012_v.nextFloat() < block.collapseChance / 100.0F) {
/*     */ 
/*     */ 
/*     */         
/* 513 */         int worldX = block.coords.x + i;
/* 514 */         int worldY = block.coords.y + j;
/* 515 */         int worldZ = block.coords.z + k;
/* 516 */         int localX = block.coords.x;
/* 517 */         int localY = block.coords.y;
/* 518 */         int localZ = block.coords.z;
/* 519 */         if (world.func_147437_c(worldX, worldY, worldZ)) {
/* 520 */           checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 1, localZ + 0), block.collapseChance - 10.0F, TFCDirection.UP));
/* 521 */         } else if (world.func_147439_a(worldX, worldY, worldZ) instanceof BlockCollapsible && ((BlockCollapsible)world
/* 522 */           .func_147439_a(worldX, worldY, worldZ)).tryToCollapse(world, worldX, worldY, worldZ, block.collapseChance).booleanValue()) {
/*     */           
/* 524 */           map.add(block.coords);
/*     */           
/* 526 */           switch (block.direction) {
/*     */ 
/*     */             
/*     */             case NORTH:
/* 530 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/* 531 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 532 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTH:
/* 537 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 538 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 539 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case EAST:
/* 544 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 545 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 546 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case WEST:
/* 551 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 552 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/* 553 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHEAST:
/* 558 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHEAST));
/* 559 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 560 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case SOUTHWEST:
/* 565 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHWEST));
/* 566 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 567 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHEAST:
/* 572 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHEAST));
/* 573 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 574 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */ 
/*     */             
/*     */             case NORTHWEST:
/* 579 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHWEST));
/* 580 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/* 581 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/*     */               break;
/*     */ 
/*     */             
/*     */             default:
/* 586 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.EAST));
/* 587 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 0), block.collapseChance - 2.5F, TFCDirection.WEST));
/* 588 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHEAST));
/* 589 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHEAST));
/* 590 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ + 1), block.collapseChance - 3.5F, TFCDirection.NORTHWEST));
/* 591 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX - 1, localY + 0, localZ - 1), block.collapseChance - 3.5F, TFCDirection.SOUTHWEST));
/* 592 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ + 1), block.collapseChance - 2.5F, TFCDirection.SOUTH));
/* 593 */               checkQueue.add(checkedmap, new CollapseData(new ByteCoord(localX + 0, localY + 0, localZ - 1), block.collapseChance - 2.5F, TFCDirection.NORTH));
/*     */               break;
/*     */           } 
/*     */         
/*     */         } 
/*     */       } 
/* 599 */       checkedmap.add(block.coords);
/* 600 */       checkQueue.removeFirst();
/*     */     } 
/* 602 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion ex) {
/* 608 */     func_149636_a(world, (EntityPlayer)null, x, y, z, world.func_72805_g(x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
/* 614 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockCollapsible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */