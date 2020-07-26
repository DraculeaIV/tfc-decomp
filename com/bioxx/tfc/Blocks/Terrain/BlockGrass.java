/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.ColorizerGrassTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
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
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
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
/*  46 */     super(Material.field_151577_b);
/*  47 */     func_149675_a(true);
/*  48 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockGrass(int texOff) {
/*  53 */     this();
/*  54 */     this.textureOffset = texOff;
/*  55 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  62 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  64 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  67 */       if (this.textureOffset == 0) { count = 16; }
/*  68 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  70 */       for (int i = 0; i < count; i++) {
/*  71 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static IIcon getIconSideOverlay() {
/*  77 */     return ((BlockGrass)TFCBlocks.grass).iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  83 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  89 */     this.grassTopTexture = registerer.func_94245_a("terrafirmacraft:GrassTop");
/*     */     
/*  91 */     this.iconSnowSide = registerer.func_94245_a("terrafirmacraft:snow");
/*  92 */     this.iconGrassSideOverlay = registerer.func_94245_a("terrafirmacraft:GrassSide");
/*     */     
/*  94 */     TFC_Textures.invisibleTexture = registerer.func_94245_a("terrafirmacraft:Invisible");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 103 */     if (side == 1)
/* 104 */       return this.grassTopTexture; 
/* 105 */     if (side == 0) {
/* 106 */       return TFC_Textures.invisibleTexture;
/*     */     }
/* 108 */     return this.iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/* 117 */     if (side == 1)
/* 118 */       return this.grassTopTexture; 
/* 119 */     if (side == 0)
/* 120 */       return TFC_Textures.invisibleTexture; 
/* 121 */     if (side == 2) {
/*     */       
/* 123 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x, y - 1, z - 1))) {
/* 124 */         return isSnow(access, x, y - 1, z - 1) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 126 */     } else if (side == 3) {
/*     */       
/* 128 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x, y - 1, z + 1))) {
/* 129 */         return isSnow(access, x, y - 1, z + 1) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 131 */     } else if (side == 4) {
/*     */       
/* 133 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x - 1, y - 1, z))) {
/* 134 */         return isSnow(access, x - 1, y - 1, z) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/* 136 */     } else if (side == 5) {
/*     */       
/* 138 */       if (TFCOptions.enableBetterGrass && TFC_Core.isGrass(access.func_147439_a(x + 1, y - 1, z))) {
/* 139 */         return isSnow(access, x + 1, y - 1, z) ? Blocks.field_150433_aE.func_149733_h(0) : this.grassTopTexture;
/*     */       }
/*     */     } 
/* 142 */     return this.iconGrassSideOverlay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess access, int x, int y, int z, int side) {
/* 149 */     if (side == 0) {
/* 150 */       return false;
/*     */     }
/* 152 */     return super.func_149646_a(access, x, y, z, side);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSnow(IBlockAccess access, int x, int y, int z) {
/* 157 */     Material material = access.func_147439_a(x, y, z).func_149688_o();
/* 158 */     return (material == Material.field_151597_y || material == Material.field_151596_z);
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
/* 169 */     return TerraFirmaCraft.proxy.grassColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 175 */     return TFCBlocks.grassRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149635_D() {
/* 181 */     double d0 = 0.5D;
/* 182 */     double d1 = 1.0D;
/* 183 */     return ColorizerGrassTFC.getGrassColor(d0, d1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149741_i(int par1) {
/* 192 */     return func_149635_D();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random rand) {
/* 201 */     if (!world.field_72995_K) {
/*     */       
/* 203 */       int meta = world.func_72805_g(i, j, k);
/* 204 */       if (world.func_147439_a(i, j + 1, k) == Blocks.field_150433_aE && !TFC_Core.isDryGrass((Block)this)) {
/*     */         
/* 206 */         world.func_147465_d(i, j, k, TFC_Core.getTypeForDryGrassFromSoil((Block)this), meta, 2);
/*     */       }
/* 208 */       else if (world.func_147439_a(i, j + 1, k).isSideSolid((IBlockAccess)world, i, j + 1, k, ForgeDirection.DOWN)) {
/*     */         
/* 210 */         world.func_147465_d(i, j, k, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
/*     */       }
/* 212 */       else if (world.func_72937_j(i, j + 1, k)) {
/*     */         
/* 214 */         spreadGrass(world, i, j, k, rand);
/*     */         
/* 216 */         float rain = TFC_Climate.getRainfall(world, i, j + 1, k);
/* 217 */         float temp = TFC_Climate.getHeightAdjustedTemp(world, i, j + 1, k);
/*     */         
/* 219 */         if (TFC_Core.isGrass((Block)this) && !TFC_Core.isDryGrass((Block)this) && world.func_147439_a(i, j + 1, k).func_149688_o() != Material.field_151586_h && world.func_147437_c(i, j + 1, k))
/*     */         {
/* 221 */           if (rand.nextInt((int)((16800.0F - rain) / 4.0F)) == 0 && temp > 20.0F) {
/* 222 */             world.func_147465_d(i, j + 1, k, TFCBlocks.tallGrass, (world.field_73012_v.nextInt(30) == 0) ? 1 : 0, 2);
/* 223 */           } else if (rand.nextInt(15000) == 0 && temp > 20.0F) {
/* 224 */             (new WorldGenSaplings()).generate(world, rand, i, j, k);
/*     */           } 
/*     */         }
/* 227 */         boolean nearWater = false;
/*     */         
/* 229 */         for (int y = 0; y < 2 && !nearWater; y++) {
/*     */           
/* 231 */           for (int x = -4; x < 5 && !nearWater; x++) {
/*     */             
/* 233 */             for (int z = -4; z < 5 && !nearWater; z++) {
/*     */               
/* 235 */               if (j < 250 && j > 144 && world.func_72899_e(i + x, j - y, k + z) && world.func_147439_a(i + x, j - y, k + z).func_149688_o() == Material.field_151586_h) {
/* 236 */                 nearWater = true;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 241 */         if (TFC_Core.isGrass((Block)this) && !TFC_Core.isDryGrass((Block)this) && !nearWater && rain < 500.0F) {
/*     */           
/* 243 */           world.func_147465_d(i, j, k, TFC_Core.getTypeForDryGrassFromSoil((Block)this), meta, 2);
/*     */         }
/* 245 */         else if (TFC_Core.isGrass((Block)this) && TFC_Core.isDryGrass((Block)this) && (nearWater || rain >= 500.0F) && world.func_147439_a(i, j + 1, k) != Blocks.field_150433_aE) {
/*     */           
/* 247 */           world.func_147465_d(i, j, k, TFC_Core.getTypeForGrassFromSoil((Block)this), meta, 2);
/*     */         } 
/*     */       } 
/*     */       
/* 251 */       world.func_147471_g(i, j, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spreadGrass(World world, int i, int j, int k, Random rand) {
/* 257 */     for (int var6 = 0; var6 < 4; var6++) {
/*     */       
/* 259 */       int x = i + rand.nextInt(3) - 1;
/* 260 */       int z = k + rand.nextInt(3) - 1;
/* 261 */       if (world.func_72899_e(x, 144, z)) {
/*     */         
/* 263 */         int y = getTopSolidBlock(world, x, z);
/*     */         
/* 265 */         if (y > 0) {
/*     */           
/* 267 */           Block id = world.func_147439_a(x, y, z);
/* 268 */           int meta = world.func_72805_g(x, y, z);
/*     */ 
/*     */           
/* 271 */           if (TFC_Core.isDirt(id) && rand.nextInt(10) == 0) {
/* 272 */             world.func_147465_d(x, y, z, TFC_Core.getTypeForGrassWithRainByBlock(id, TFC_Climate.getRainfall(world, x, y, z)), meta, 2);
/* 273 */           } else if (TFC_Core.isClay(id) && rand.nextInt(10) == 0) {
/* 274 */             world.func_147465_d(x, y, z, TFC_Core.getTypeForClayGrass(meta), meta, 2);
/* 275 */           } else if (TFC_Core.isPeat(id) && rand.nextInt(10) == 0) {
/* 276 */             world.func_147465_d(x, y, z, TFCBlocks.peatGrass, 0, 2);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTopSolidBlock(World world, int xCoord, int zCoord) {
/* 287 */     Chunk chunk = world.func_72938_d(xCoord, zCoord);
/* 288 */     int x = xCoord;
/* 289 */     int z = zCoord;
/* 290 */     int y = chunk.func_76625_h() + 15;
/* 291 */     xCoord &= 0xF;
/*     */     
/* 293 */     for (zCoord &= 0xF; y > 0; y--) {
/*     */       
/* 295 */       Block block = chunk.func_150810_a(xCoord, y, zCoord);
/* 296 */       Material material = block.func_149688_o();
/*     */       
/* 298 */       if (block.func_149662_c() && material
/* 299 */         .func_76218_k() && block
/* 300 */         .func_149686_d() && material != Material.field_151584_j && material != Material.field_151586_h && material
/*     */         
/* 302 */         .func_76230_c() && 
/* 303 */         !block.isFoliage((IBlockAccess)world, x, y, z) && (block
/* 304 */         .isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.UP) || block.isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.DOWN)))
/*     */       {
/* 306 */         return y;
/*     */       }
/*     */     } 
/*     */     
/* 310 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149724_b(World world, int x, int y, int z, Entity entity) {
/* 316 */     if (!world.field_72995_K && this != TFCBlocks.clayGrass2 && this != TFCBlocks.clayGrass && this != TFCBlocks.peatGrass) {
/*     */       
/* 318 */       Random r = new Random();
/* 319 */       if (BlockCollapsible.canFallBelow(world, x, y - 1, z) && r.nextInt(10) == 0 && !BlockCollapsible.isNearSupport(world, x, y, z, 4, 0.0F).booleanValue()) {
/*     */         
/* 321 */         int meta = world.func_72805_g(x, y, z);
/* 322 */         world.func_147465_d(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
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
/* 333 */     return TFC_Core.getTypeForDirtFromGrass((Block)this).func_149650_a(metadata, rand, fortune);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 339 */     if (world.func_147437_c(x, y - 1, z) && !BlockCollapsible.isNearSupport(world, x, y, z, 4, 0.0F).booleanValue()) {
/*     */       
/* 341 */       int meta = world.func_72805_g(x, y, z);
/* 342 */       world.func_147465_d(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), meta, 2);
/* 343 */       world.func_147464_a(x, y, z, TFC_Core.getTypeForDirtFromGrass((Block)this), 5);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */