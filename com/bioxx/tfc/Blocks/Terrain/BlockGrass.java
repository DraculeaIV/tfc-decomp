/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.ColorizerGrassTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenLooseRocks;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenSaplings;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class BlockGrass
/*     */   extends BlockTerra
/*     */ {
/*     */   protected int textureOffset;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon grassTopTexture;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon iconSnowSide;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon iconGrassSideOverlay;
/*     */   
/*     */   public BlockGrass() {
/*  45 */     super(Material.field_151577_b);
/*  46 */     func_149675_a(true);
/*  47 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockGrass(int texOff) {
/*  52 */     this();
/*  53 */     this.textureOffset = texOff;
/*  54 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  61 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  63 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  66 */       if (this.textureOffset == 0) { count = 16; }
/*  67 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  69 */       for (int i = 0; i < count; i++) {
/*  70 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static IIcon getIconSideOverlay() {
/*  76 */     return ((BlockGrass)TFCBlocks.grass).iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  82 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  88 */     this.grassTopTexture = registerer.func_94245_a("terrafirmacraft:GrassTop");
/*     */     
/*  90 */     this.iconSnowSide = registerer.func_94245_a("terrafirmacraft:snow");
/*  91 */     this.iconGrassSideOverlay = registerer.func_94245_a("terrafirmacraft:GrassSide");
/*     */     
/*  93 */     TFC_Textures.invisibleTexture = registerer.func_94245_a("terrafirmacraft:Invisible");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 102 */     if (side == 1)
/* 103 */       return this.grassTopTexture; 
/* 104 */     if (side == 0) {
/* 105 */       return TFC_Textures.invisibleTexture;
/*     */     }
/* 107 */     return this.iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/* 116 */     if (side == 1)
/* 117 */       return this.grassTopTexture; 
/* 118 */     if (side == 0)
/* 119 */       return TFC_Textures.invisibleTexture; 
/* 120 */     if (side == 2) {
/*     */       
/* 122 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x, y - 1, z - 1))) {
/* 123 */         return isSnow(access, x, y - 1, z - 1) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 125 */     } else if (side == 3) {
/*     */       
/* 127 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x, y - 1, z + 1))) {
/* 128 */         return isSnow(access, x, y - 1, z + 1) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 130 */     } else if (side == 4) {
/*     */       
/* 132 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x - 1, y - 1, z))) {
/* 133 */         return isSnow(access, x - 1, y - 1, z) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 135 */     } else if (side == 5) {
/*     */       
/* 137 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x + 1, y - 1, z))) {
/* 138 */         return isSnow(access, x + 1, y - 1, z) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/*     */     } 
/* 141 */     return this.iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess access, int x, int y, int z, int side) {
/* 148 */     if (side == 0) {
/* 149 */       return false;
/*     */     }
/* 151 */     return super.func_149646_a(access, x, y, z, side);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSnow(IBlockAccess access, int x, int y, int z) {
/* 156 */     Material material = access.func_147439_a(x, y, z).func_149688_o();
/* 157 */     return (material == Material.field_151597_y || material == Material.field_151596_z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/* 168 */     return TerraFirmaCraft.proxy.grassColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 174 */     return TFCBlocks.grassRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149635_D() {
/* 180 */     double d0 = 0.5D;
/* 181 */     double d1 = 1.0D;
/* 182 */     return ColorizerGrassTFC.getGrassColor(d0, d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149741_i(int par1) {
/* 191 */     return func_149635_D();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random rand) {
/* 200 */     if (!world.field_72995_K) {
/*     */       
/* 202 */       int meta = world.func_72805_g(i, j, k);
/* 203 */       if (world.func_147439_a(i, j + 1, k) == Blocks.field_150433_aE && !TFC_Core.isDryGrass((Block)this)) {
/*     */         
/* 205 */         world.func_147465_d(i, j, k, TFC_Core.getTypeForDryGrassFromSoil((Block)this), meta, 2);
/*     */       }
/* 207 */       else if (world.func_147439_a(i, j + 1, k).isSideSolid((IBlockAccess)world, i, j + 1, k, ForgeDirection.DOWN)) {
/*     */         
/* 209 */         world.func_147465_d(i, j, k, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
/*     */       }
/* 211 */       else if (world.func_72937_j(i, j + 1, k)) {
/*     */         
/* 213 */         spreadGrass(world, i, j, k, rand);
/*     */         
/* 215 */         float rain = TFC_Climate.getRainfall(world, i, j + 1, k);
/* 216 */         float temp = TFC_Climate.getHeightAdjustedTemp(world, i, j + 1, k);
/*     */         
/* 218 */         if (TFC_Core.isGrass((Block)this) && world.func_147439_a(i, j + 1, k).func_149688_o() != Material.field_151586_h) {
/*     */           
/* 220 */           int chunkX = (int)Math.floor(i) >> 4;
/* 221 */           int chunkZ = (int)Math.floor(k) >> 4;
/*     */           
/* 223 */           if (TFC_Core.getCDM(world) != null) {
/*     */             
/* 225 */             ChunkData data = TFC_Core.getCDM(world).getData(chunkX, chunkZ);
/* 226 */             if (data == null || data.getSpawnProtectionWithUpdate() <= 234)
/*     */             {
/* 228 */               if (temp > 20.0F && !TFC_Core.isDryGrass((Block)this) && world.func_147437_c(i, j + 1, k)) {
/*     */                 
/* 230 */                 if (rand.nextInt((int)((16800.0F - rain) / 4.0F)) == 0) {
/* 231 */                   world.func_147465_d(i, j + 1, k, TFCBlocks.tallGrass, (world.field_73012_v.nextInt(30) == 0) ? 1 : 0, 2);
/* 232 */                 } else if (rand.nextInt(15000) == 0) {
/* 233 */                   (new WorldGenSaplings()).generate(world, rand, i, j, k);
/*     */                 } 
/* 235 */               } else if (rand.nextInt(20000) == 0 && !WorldGenLooseRocks.rocksNearby(world, i, j, k) && temp < 15.0F) {
/* 236 */                 (new WorldGenLooseRocks()).generateRocks(world, rand, i, j, k);
/* 237 */               } else if (rand.nextInt(20000) == 0 && temp < 15.0F) {
/* 238 */                 (new WorldGenLooseRocks()).generateSticks(world, rand, i, j, k);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 246 */         boolean nearWater = false;
/*     */         
/* 248 */         for (int y = 0; y < 2 && !nearWater; y++) {
/*     */           
/* 250 */           for (int x = -4; x < 5 && !nearWater; x++) {
/*     */             
/* 252 */             for (int z = -4; z < 5 && !nearWater; z++) {
/*     */               
/* 254 */               if (j < 250 && j > 144 && world.func_72899_e(i + x, j - y, k + z) && world.func_147439_a(i + x, j - y, k + z).func_149688_o() == Material.field_151586_h) {
/* 255 */                 nearWater = true;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 260 */         if (TFC_Core.isGrass((Block)this) && !TFC_Core.isDryGrass((Block)this) && !nearWater && rain < 500.0F) {
/*     */           
/* 262 */           world.func_147465_d(i, j, k, TFC_Core.getTypeForDryGrassFromSoil((Block)this), meta, 2);
/*     */         }
/* 264 */         else if (TFC_Core.isGrass((Block)this) && TFC_Core.isDryGrass((Block)this) && (nearWater || rain >= 500.0F) && world.func_147439_a(i, j + 1, k) != Blocks.field_150433_aE) {
/*     */           
/* 266 */           world.func_147465_d(i, j, k, TFC_Core.getTypeForGrassFromSoil((Block)this), meta, 2);
/*     */         } 
/*     */       } 
/*     */       
/* 270 */       world.func_147471_g(i, j, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spreadGrass(World world, int i, int j, int k, Random rand) {
/* 276 */     for (int var6 = 0; var6 < 4; var6++) {
/*     */       
/* 278 */       int x = i + rand.nextInt(3) - 1;
/* 279 */       int z = k + rand.nextInt(3) - 1;
/* 280 */       int y = world.func_72825_h(x, z) - 1;
/*     */       
/* 282 */       if (world.func_72899_e(x, y, z) && world.func_147439_a(x, y + 1, z).func_149688_o() != Material.field_151586_h) {
/*     */         
/* 284 */         float rain = TFC_Climate.getRainfall(world, x, y, z);
/*     */         
/* 286 */         Block id = world.func_147439_a(x, y, z);
/* 287 */         int meta = world.func_72805_g(x, y, z);
/*     */ 
/*     */         
/* 290 */         if (TFC_Core.isDirt(id) && rand.nextInt(10) == 0) {
/* 291 */           world.func_147465_d(x, y, z, TFC_Core.getTypeForGrassWithRainByBlock(id, rain), meta, 2);
/* 292 */         } else if (TFC_Core.isClay(id) && rand.nextInt(10) == 0) {
/* 293 */           world.func_147465_d(x, y, z, TFC_Core.getTypeForClayGrass(meta), meta, 2);
/* 294 */         } else if (TFC_Core.isPeat(id) && rand.nextInt(10) == 0) {
/* 295 */           world.func_147465_d(x, y, z, TFCBlocks.peatGrass, 0, 2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149724_b(World world, int x, int y, int z, Entity entity) {
/* 303 */     if (!world.field_72995_K && this != TFCBlocks.clayGrass2 && this != TFCBlocks.clayGrass && this != TFCBlocks.peatGrass) {
/*     */       
/* 305 */       Random r = new Random();
/* 306 */       if (BlockCollapsible.canFallBelow(world, x, y - 1, z) && r.nextInt(10) == 0 && !BlockCollapsible.isNearSupport(world, x, y, z, 4, 0.0F).booleanValue()) {
/*     */         
/* 308 */         int meta = world.func_72805_g(x, y, z);
/* 309 */         world.func_147465_d(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 320 */     return TFC_Core.getTypeForDirtFromGrass((Block)this).func_149650_a(metadata, rand, fortune);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 326 */     if (world.func_147437_c(x, y - 1, z)) {
/*     */       
/* 328 */       int meta = world.func_72805_g(x, y, z);
/* 329 */       world.func_147465_d(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
/* 330 */       world.func_147464_a(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), 5);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */