/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockSluice;
/*     */ import com.bioxx.tfc.Blocks.Flora.BlockFruitLeaves;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.FloraIndex;
/*     */ import com.bioxx.tfc.Food.FloraManager;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderFlora;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.TileEntities.TEWaterPlant;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ public class TFC_CoreRender
/*     */ {
/*     */   private static RenderBlocksLightCache renderer;
/*     */   
/*     */   public static boolean renderBlockSlab(Block block, int x, int y, int z, RenderBlocks renderblocks) {
/*  35 */     TEPartial te = (TEPartial)renderblocks.field_147845_a.func_147438_o(x, y, z);
/*     */ 
/*     */ 
/*     */     
/*  39 */     if (te.typeID <= 0) {
/*  40 */       return false;
/*     */     }
/*  42 */     int type = te.typeID;
/*  43 */     int meta = te.metaID;
/*  44 */     Block b = Block.func_149729_e(type);
/*  45 */     IIcon tex = b.func_149691_a(0, meta);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     long extraX = te.extraData & 0xFL;
/*  51 */     long extraY = te.extraData >> 4L & 0xFL;
/*  52 */     long extraZ = te.extraData >> 8L & 0xFL;
/*  53 */     long extraX2 = te.extraData >> 12L & 0xFL;
/*  54 */     long extraY2 = te.extraData >> 16L & 0xFL;
/*  55 */     long extraZ2 = te.extraData >> 20L & 0xFL;
/*     */     
/*  57 */     float div = 0.125F;
/*     */     
/*  59 */     renderblocks.func_147782_a((0.0F + div * (float)extraX), (0.0F + div * (float)extraY), (0.0F + div * (float)extraZ), (1.0F - div * (float)extraX2), (1.0F - div * (float)extraY2), (1.0F - div * (float)extraZ2));
/*     */ 
/*     */     
/*  62 */     boolean breaking = (renderblocks.field_147840_d != null);
/*  63 */     IIcon over = renderblocks.field_147840_d;
/*  64 */     if (!breaking && (b == TFCBlocks.ore || b == TFCBlocks.ore2 || b == TFCBlocks.ore3)) {
/*     */ 
/*     */       
/*  67 */       renderblocks.field_147840_d = getRockTexture((World)(Minecraft.func_71410_x()).field_71441_e, x, y, z);
/*  68 */       renderblocks.func_147784_q(block, x, y, z);
/*  69 */       renderblocks.field_147840_d = over;
/*     */     } 
/*     */     
/*  72 */     if (!breaking) {
/*  73 */       renderblocks.field_147840_d = tex;
/*     */     }
/*  75 */     renderblocks.func_147784_q(block, x, y, z);
/*  76 */     renderblocks.field_147840_d = over;
/*     */     
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean renderBlockStairs(Block block, int x, int y, int z, RenderBlocks renderblocks) {
/*  84 */     if (renderer == null) {
/*  85 */       renderer = new RenderBlocksLightCache(renderblocks);
/*     */     } else {
/*  87 */       renderer.update(renderblocks);
/*     */     } 
/*     */     
/*  90 */     renderer.disableRender();
/*  91 */     renderer.func_147753_b(true);
/*  92 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*  93 */     renderer.func_147784_q(block, x, y, z);
/*  94 */     renderer.func_147753_b(false);
/*  95 */     renderer.enableRender();
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
/* 112 */     TEPartial te = (TEPartial)renderblocks.field_147845_a.func_147438_o(x, y, z);
/* 113 */     if (te.typeID <= 0) {
/* 114 */       return false;
/*     */     }
/* 116 */     long rvmeta = te.extraData;
/* 117 */     int type = te.typeID;
/* 118 */     int temeta = te.metaID;
/* 119 */     IIcon myTexture = (renderblocks.field_147840_d == null) ? Block.func_149729_e(type).func_149691_a(0, temeta) : renderblocks.field_147840_d;
/*     */     
/* 121 */     if ((rvmeta & 0x1L) == 0L) {
/*     */       
/* 123 */       renderer.func_147782_a(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
/* 124 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 126 */     if ((rvmeta & 0x2L) == 0L) {
/*     */       
/* 128 */       renderer.func_147782_a(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
/* 129 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 131 */     if ((rvmeta & 0x4L) == 0L) {
/*     */       
/* 133 */       renderer.func_147782_a(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);
/* 134 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 136 */     if ((rvmeta & 0x8L) == 0L) {
/*     */       
/* 138 */       renderer.func_147782_a(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
/* 139 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/*     */     
/* 142 */     if ((rvmeta & 0x10L) == 0L) {
/*     */       
/* 144 */       renderer.func_147782_a(0.0D, 0.0D, 0.5D, 0.5D, 0.5D, 1.0D);
/* 145 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 147 */     if ((rvmeta & 0x20L) == 0L) {
/*     */       
/* 149 */       renderer.func_147782_a(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
/* 150 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 152 */     if ((rvmeta & 0x40L) == 0L) {
/*     */       
/* 154 */       renderer.func_147782_a(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
/* 155 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/* 157 */     if ((rvmeta & 0x80L) == 0L) {
/*     */       
/* 159 */       renderer.func_147782_a(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
/* 160 */       renderer.renderCachedBlock(block, x, y, z, myTexture);
/*     */     } 
/*     */     
/* 163 */     renderer.func_147771_a();
/* 164 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderSulfur(Block block, int x, int y, int z, RenderBlocks renderblocks) {
/* 170 */     IBlockAccess world = renderblocks.field_147845_a;
/* 171 */     if (world.func_147439_a(x, y, z + 1).isSideSolid(world, x, y, z + 1, ForgeDirection.NORTH)) {
/*     */       
/* 173 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.9900000095367432D, 1.0D, 1.0D, 1.0D);
/* 174 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/* 176 */     if (world.func_147439_a(x, y, z - 1).isSideSolid(world, x, y, z - 1, ForgeDirection.SOUTH)) {
/*     */       
/* 178 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.009999999776482582D);
/* 179 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/* 181 */     if (world.func_147439_a(x + 1, y, z).isSideSolid(world, x + 1, y, z, ForgeDirection.EAST)) {
/*     */       
/* 183 */       renderblocks.func_147782_a(0.9900000095367432D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 184 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/* 186 */     if (world.func_147439_a(x - 1, y, z).isSideSolid(world, x - 1, y, z, ForgeDirection.WEST)) {
/*     */       
/* 188 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 0.009999999776482582D, 1.0D, 1.0D);
/* 189 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/* 191 */     if (world.func_147439_a(x, y + 1, z).isSideSolid(world, x, y + 1, z, ForgeDirection.DOWN)) {
/*     */       
/* 193 */       renderblocks.func_147782_a(0.0D, 0.9900000095367432D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 194 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/* 196 */     if (world.func_147439_a(x, y - 1, z).isSideSolid(world, x, y - 1, z, ForgeDirection.UP)) {
/*     */       
/* 198 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.009999999776482582D, 1.0D);
/* 199 */       renderblocks.func_147784_q(block, x, y, z);
/*     */     } 
/*     */     
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderSnow(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 207 */     int meta = renderblocks.field_147845_a.func_72805_g(i, j, k);
/* 208 */     float drift = 0.04F + meta * 0.06F;
/* 209 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, drift, 1.0D);
/* 210 */     renderblocks.func_147784_q(block, i, j, k);
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderWoodTrunk(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 216 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */ 
/*     */ 
/*     */     
/* 220 */     if (blockAccess.func_147438_o(i, j, k) != null && (blockAccess.func_147439_a(i, j - 1, k) == TFCBlocks.fruitTreeWood || blockAccess.func_147439_a(i, j - 1, k).func_149662_c())) {
/*     */       
/* 222 */       renderblocks.func_147782_a(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 1.0D, 0.699999988079071D);
/* 223 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/* 225 */     if (blockAccess.func_147439_a(i - 1, j, k).func_149688_o() == Material.field_151584_j || blockAccess.func_147439_a(i - 1, j, k) == TFCBlocks.fruitTreeWood) {
/*     */       
/* 227 */       renderblocks.func_147782_a(0.0D, 0.4000000059604645D, 0.4000000059604645D, 0.5D, 0.6000000238418579D, 0.6000000238418579D);
/* 228 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/* 230 */     if (blockAccess.func_147439_a(i + 1, j, k).func_149688_o() == Material.field_151584_j || blockAccess.func_147439_a(i + 1, j, k) == TFCBlocks.fruitTreeWood) {
/*     */       
/* 232 */       renderblocks.func_147782_a(0.5D, 0.4000000059604645D, 0.4000000059604645D, 1.0D, 0.6000000238418579D, 0.6000000238418579D);
/* 233 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/* 235 */     if (blockAccess.func_147439_a(i, j, k - 1).func_149688_o() == Material.field_151584_j || blockAccess.func_147439_a(i, j, k - 1) == TFCBlocks.fruitTreeWood) {
/*     */       
/* 237 */       renderblocks.func_147782_a(0.4000000059604645D, 0.4000000059604645D, 0.0D, 0.6000000238418579D, 0.6000000238418579D, 0.5D);
/* 238 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/* 240 */     if (blockAccess.func_147439_a(i, j, k + 1).func_149688_o() == Material.field_151584_j || blockAccess.func_147439_a(i, j, k + 1) == TFCBlocks.fruitTreeWood) {
/*     */       
/* 242 */       renderblocks.func_147782_a(0.4000000059604645D, 0.4000000059604645D, 0.5D, 0.6000000238418579D, 0.6000000238418579D, 1.0D);
/* 243 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*     */     
/* 246 */     if (!((TEFruitTreeWood)blockAccess.func_147438_o(i, j, k)).isTrunk && blockAccess.func_147439_a(i, j - 1, k) != TFCBlocks.fruitTreeWood && !blockAccess.func_147439_a(i, j - 1, k).func_149662_c()) {
/*     */       
/* 248 */       renderblocks.func_147782_a(0.0D, 0.4000000059604645D, 0.4000000059604645D, 0.5D, 0.6000000238418579D, 0.6000000238418579D);
/* 249 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/* 251 */       renderblocks.func_147782_a(0.5D, 0.4000000059604645D, 0.4000000059604645D, 1.0D, 0.6000000238418579D, 0.6000000238418579D);
/* 252 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/* 254 */       renderblocks.func_147782_a(0.4000000059604645D, 0.4000000059604645D, 0.0D, 0.6000000238418579D, 0.6000000238418579D, 0.5D);
/* 255 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/* 257 */       renderblocks.func_147782_a(0.4000000059604645D, 0.4000000059604645D, 0.5D, 0.6000000238418579D, 0.6000000238418579D, 1.0D);
/* 258 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*     */ 
/*     */     
/* 262 */     return true;
/*     */   }
/*     */   
/* 265 */   public static Random renderRandom = new Random();
/*     */ 
/*     */   
/*     */   public static boolean renderLooseRock(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 269 */     boolean breaking = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 276 */     WorldClient worldClient = (Minecraft.func_71410_x()).field_71441_e;
/*     */     
/* 278 */     renderblocks.field_147837_f = true;
/*     */     
/* 280 */     DataLayer rockLayer1 = TFC_Climate.getCacheManager((World)worldClient).getRockLayerAt(i, k, 0);
/* 281 */     if (rockLayer1 != null && rockLayer1.block != null && !breaking) {
/* 282 */       renderblocks.field_147840_d = rockLayer1.block.func_149691_a(0, rockLayer1.data2);
/*     */     }
/* 284 */     int seed = i * k + j;
/* 285 */     renderRandom.setSeed(seed);
/*     */     
/* 287 */     float xOffset = (renderRandom.nextInt(5) - 2) * 0.05F;
/* 288 */     float zOffset = (renderRandom.nextInt(5) - 2) * 0.05F;
/*     */     
/* 290 */     float xOffset2 = (renderRandom.nextInt(5) - 2) * 0.05F;
/* 291 */     float yOffset2 = (renderRandom.nextInt(5) - 2) * 0.05F;
/* 292 */     float zOffset2 = (renderRandom.nextInt(5) - 2) * 0.05F;
/*     */     
/* 294 */     renderblocks.func_147782_a((0.35F + xOffset), 0.0D, (0.35F + zOffset), (0.65F + xOffset2), (0.15F + yOffset2), (0.65F + zOffset2));
/* 295 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 297 */     renderblocks.func_147771_a();
/*     */     
/* 299 */     return true;
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
/*     */   public static boolean renderOre(Block block, int xCoord, int yCoord, int zCoord, float par5, float par6, float par7, RenderBlocks renderblocks, IBlockAccess iblockaccess) {
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static IIcon getRockTexture(World world, int xCoord, int yCoord, int zCoord) {
/*     */     IIcon var27;
/* 329 */     DataLayer rockLayer1 = TFC_Climate.getCacheManager(world).getRockLayerAt(xCoord, zCoord, 0);
/* 330 */     DataLayer rockLayer2 = TFC_Climate.getCacheManager(world).getRockLayerAt(xCoord, zCoord, 1);
/* 331 */     DataLayer rockLayer3 = TFC_Climate.getCacheManager(world).getRockLayerAt(xCoord, zCoord, 2);
/*     */     
/* 333 */     if (yCoord <= TFCOptions.rockLayer3Height) {
/* 334 */       var27 = rockLayer3.block.func_149691_a(5, rockLayer3.data2);
/* 335 */     } else if (yCoord <= TFCOptions.rockLayer2Height) {
/* 336 */       var27 = rockLayer2.block.func_149691_a(5, rockLayer2.data2);
/*     */     } else {
/* 338 */       var27 = rockLayer1.block.func_149691_a(5, rockLayer1.data2);
/* 339 */     }  return var27;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderMolten(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 344 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 345 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 347 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean renderFirepit(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 353 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.019999999552965164D, 1.0D);
/* 354 */     renderblocks.func_147784_q(block, i, j, k);
/* 355 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.019999999552965164D, 1.0D);
/* 356 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean renderForge(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 362 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8999999761581421D, 1.0D);
/* 363 */     renderblocks.func_147784_q(block, i, j, k);
/* 364 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8999999761581421D, 1.0D);
/* 365 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderSluice(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 370 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */     
/* 372 */     int meta = blockAccess.func_72805_g(i, j, k);
/* 373 */     int dir = BlockSluice.getDirectionFromMetadata(meta);
/*     */ 
/*     */     
/* 376 */     if (!BlockSluice.isBlockFootOfBed(meta)) {
/*     */       
/* 378 */       if (dir == 0) {
/*     */         
/* 380 */         for (int count = 0; count < 4; count++)
/*     */         {
/*     */           
/* 383 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.0D + 0.25D * count, 1.0D, 1.0D - 0.125D * count, 0.05000000074505806D + 0.25D * count);
/* 384 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 386 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.05000000074505806D + 0.25D * count, 1.0D, 0.8125D - 0.125D * count, 0.25D + 0.25D * count);
/* 387 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */       
/* 390 */       } else if (dir == 1) {
/*     */         
/* 392 */         if ((meta & 0x4) != 0)
/* 393 */           renderblocks.field_147867_u = 1; 
/* 394 */         for (int count = 0; count < 4; count++)
/*     */         {
/*     */           
/* 397 */           renderblocks.func_147782_a(0.949999988079071D - 0.25D * count, 0.0D, 0.0D, 1.0D - 0.25D * count, 1.0D - 0.125D * count, 1.0D);
/* 398 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 400 */           renderblocks.func_147782_a(0.75D - 0.25D * count, 0.0D, 0.0D, 0.949999988079071D - 0.25D * count, 0.8125D - 0.125D * count, 1.0D);
/* 401 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */       
/* 404 */       } else if (dir == 2) {
/*     */         
/* 406 */         if ((meta & 0x4) != 0)
/* 407 */           renderblocks.field_147867_u = 3; 
/* 408 */         for (int count = 0; count < 4; count++)
/*     */         {
/*     */           
/* 411 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.949999988079071D - 0.25D * count, 1.0D, 1.0D - 0.125D * count, 1.0D - 0.25D * count);
/* 412 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 414 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.75D - 0.25D * count, 1.0D, 0.8125D - 0.125D * count, 0.949999988079071D - 0.25D * count);
/* 415 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */       
/* 418 */       } else if (dir == 3) {
/*     */         
/* 420 */         if ((meta & 0x4) != 0)
/* 421 */           renderblocks.field_147867_u = 2; 
/* 422 */         for (int count = 0; count < 4; count++)
/*     */         {
/*     */           
/* 425 */           renderblocks.func_147782_a(0.0D + 0.25D * count, 0.0D, 0.0D, 0.05000000074505806D + 0.25D * count, 1.0D - 0.125D * count, 1.0D);
/* 426 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 428 */           renderblocks.func_147782_a(0.05000000074505806D + 0.25D * count, 0.0D, 0.0D, 0.25D + 0.25D * count, 0.8125D - 0.125D * count, 1.0D);
/* 429 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 435 */       if (dir == 0)
/*     */       {
/* 437 */         for (int count = 0; count < 4; count++) {
/*     */ 
/*     */           
/* 440 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.0D + 0.25D * count, 1.0D, 0.5D - 0.125D * count, 0.05000000074505806D + 0.25D * count);
/* 441 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 443 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.05000000074505806D + 0.25D * count, 1.0D, Math.max(0.3125D - 0.125D * count, 0.01D), 0.25D + 0.25D * count);
/* 444 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*     */       }
/* 447 */       if (dir == 1) {
/*     */         
/* 449 */         if ((meta & 0x4) != 0)
/* 450 */           renderblocks.field_147867_u = 1; 
/* 451 */         for (int count = 0; count < 4; count++) {
/*     */ 
/*     */           
/* 454 */           renderblocks.func_147782_a(0.949999988079071D - 0.25D * count, 0.0D, 0.0D, 1.0D - 0.25D * count, 0.5D - 0.125D * count, 1.0D);
/* 455 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 457 */           renderblocks.func_147782_a(0.75D - 0.25D * count, 0.0D, 0.0D, 0.949999988079071D - 0.25D * count, Math.max(0.3125D - 0.125D * count, 0.01D), 1.0D);
/* 458 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*     */       } 
/* 461 */       if (dir == 2) {
/*     */         
/* 463 */         if ((meta & 0x4) != 0)
/* 464 */           renderblocks.field_147867_u = 3; 
/* 465 */         for (int count = 0; count < 4; count++) {
/*     */ 
/*     */           
/* 468 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.949999988079071D - 0.25D * count, 1.0D, 0.5D - 0.125D * count, 1.0D - 0.25D * count);
/* 469 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 471 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.75D - 0.25D * count, 1.0D, Math.max(0.3125D - 0.125D * count, 0.01D), 0.949999988079071D - 0.25D * count);
/* 472 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*     */       } 
/*     */       
/* 476 */       if (dir == 3) {
/*     */         
/* 478 */         if ((meta & 0x4) != 0)
/* 479 */           renderblocks.field_147867_u = 2; 
/* 480 */         for (int count = 0; count < 4; count++) {
/*     */ 
/*     */           
/* 483 */           renderblocks.func_147782_a(0.0D + 0.25D * count, 0.0D, 0.0D, 0.05000000074505806D + 0.25D * count, 0.5D - 0.125D * count, 1.0D);
/* 484 */           renderblocks.func_147784_q(block, i, j, k);
/*     */           
/* 486 */           renderblocks.func_147782_a(0.05000000074505806D + 0.25D * count, 0.0D, 0.0D, 0.25D + 0.25D * count, Math.max(0.3125D - 0.125D * count, 0.01D), 1.0D);
/* 487 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*     */       } 
/*     */     } 
/* 491 */     renderblocks.field_147867_u = 0;
/*     */     
/* 493 */     renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*     */     
/* 495 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderBlockWithCustomColorMultiplier(Block block, RenderBlocks renderBlocks, int xCoord, int yCoord, int zCoord, int colorMultiplier) {
/* 500 */     int l = colorMultiplier;
/* 501 */     float f = (l >> 16 & 0xFF) / 255.0F;
/* 502 */     float f1 = (l >> 8 & 0xFF) / 255.0F;
/* 503 */     float f2 = (l & 0xFF) / 255.0F;
/*     */     
/* 505 */     if (EntityRenderer.field_78517_a) {
/*     */       
/* 507 */       float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
/* 508 */       float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
/* 509 */       float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
/* 510 */       f = f3;
/* 511 */       f1 = f4;
/* 512 */       f2 = f5;
/*     */     } 
/*     */     
/* 515 */     return (Minecraft.func_71379_u() && block.func_149750_m() == 0) ? (renderBlocks.field_147849_o ? renderBlocks
/*     */       
/* 517 */       .func_147751_a(block, xCoord, yCoord, zCoord, f, f1, f2) : renderBlocks
/* 518 */       .func_147751_a(block, xCoord, yCoord, zCoord, f, f1, f2)) : renderBlocks
/* 519 */       .func_147736_d(block, xCoord, yCoord, zCoord, f, f1, f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderFruitLeaves(Block block, int xCoord, int yCoord, int zCoord, RenderBlocks renderblocks) {
/* 524 */     int meta = renderblocks.field_147845_a.func_72805_g(xCoord, yCoord, zCoord);
/* 525 */     if (meta >= 8) {
/* 526 */       meta -= 8;
/*     */     }
/* 528 */     FloraManager manager = FloraManager.getInstance();
/* 529 */     FloraIndex index = manager.findMatchingIndex(BlockFruitLeaves.getType(block, meta));
/*     */     
/* 531 */     renderblocks.func_147784_q(block, xCoord, yCoord, zCoord);
/* 532 */     if (index != null && (index.inBloom(TFC_Time.getSeasonAdjustedMonth(zCoord)) || index.inHarvest(TFC_Time.getSeasonAdjustedMonth(zCoord)))) {
/*     */       
/* 534 */       renderblocks.field_147840_d = getFruitTreeOverlay(renderblocks.field_147845_a, xCoord, yCoord, zCoord);
/* 535 */       if (renderblocks.field_147840_d != null)
/* 536 */         renderBlockWithCustomColorMultiplier(block, renderblocks, xCoord, yCoord, zCoord, 16777215); 
/* 537 */       renderblocks.func_147771_a();
/*     */     } 
/* 539 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderSeaPlant(Block par1Block, int par2, int par3, int par4, RenderBlocks renderblocks) {
/* 544 */     boolean substrateRender = false;
/* 545 */     boolean plantRender = false;
/* 546 */     TileEntity te = renderblocks.field_147845_a.func_147438_o(par2, par3, par4);
/* 547 */     if (te instanceof TEWaterPlant) {
/* 548 */       TEWaterPlant wp = (TEWaterPlant)te;
/* 549 */       if (wp.getBlockFromType() != null) {
/* 550 */         substrateRender = renderblocks.func_147736_d(wp.getBlockFromType(), par2, par3, par4, 1.0F, 1.0F, 1.0F);
/* 551 */         plantRender = RenderFlora.render(par1Block, par2, par3, par4, renderblocks);
/*     */       } 
/*     */     } 
/* 554 */     return (substrateRender && plantRender);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IIcon getFruitTreeOverlay(IBlockAccess world, int x, int y, int z) {
/* 559 */     IIcon out = null;
/* 560 */     int meta = world.func_72805_g(x, y, z);
/* 561 */     Block id = world.func_147439_a(x, y, z);
/* 562 */     int offset = (id == TFCBlocks.fruitTreeLeaves) ? 0 : 8;
/*     */     
/* 564 */     FloraManager manager = FloraManager.getInstance();
/* 565 */     FloraIndex index = manager.findMatchingIndex(BlockFruitLeaves.getType(id, meta & 0x7));
/* 566 */     if (index != null)
/*     */     {
/* 568 */       if (index.inBloom(TFC_Time.getSeasonAdjustedMonth(z))) {
/* 569 */         out = BlockFruitLeaves.iconsFlowers[(meta & 0x7) + offset];
/* 570 */       } else if (meta >= 8) {
/* 571 */         out = BlockFruitLeaves.iconsFruit[(meta & 0x7) + offset];
/*     */       }  } 
/* 573 */     return out;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TFC_CoreRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */