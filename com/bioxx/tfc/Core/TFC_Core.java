/*      */ package com.bioxx.tfc.Core;
/*      */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*      */ import com.bioxx.tfc.Chunkdata.ChunkDataManager;
/*      */ import com.bioxx.tfc.Core.Player.BodyTempStats;
/*      */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*      */ import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
/*      */ import com.bioxx.tfc.Core.Player.SkillStats;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
/*      */ import com.bioxx.tfc.Items.ItemOre;
/*      */ import com.bioxx.tfc.Items.ItemTerra;
/*      */ import com.bioxx.tfc.TerraFirmaCraft;
/*      */ import com.bioxx.tfc.TileEntities.TEMetalSheet;
/*      */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*      */ import com.bioxx.tfc.api.Constant.Global;
/*      */ import com.bioxx.tfc.api.Entities.IAnimal;
/*      */ import com.bioxx.tfc.api.Enums.EnumFuelMaterial;
/*      */ import com.bioxx.tfc.api.Food;
/*      */ import com.bioxx.tfc.api.Interfaces.IFood;
/*      */ import com.bioxx.tfc.api.TFCBlocks;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import com.bioxx.tfc.api.TFCOptions;
/*      */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.InventoryPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StatCollector;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.IBlockAccess;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.storage.WorldInfo;
/*      */ import net.minecraftforge.common.util.ForgeDirection;
/*      */ import org.lwjgl.input.Keyboard;
/*      */ import org.lwjgl.input.Mouse;
/*      */ 
/*      */ public class TFC_Core {
/*   65 */   private static Map<Integer, ChunkDataManager> cdmMap = new HashMap<Integer, ChunkDataManager>();
/*      */   
/*      */   public static boolean preventEntityDataUpdate;
/*      */   
/*      */   public static ChunkDataManager getCDM(World world) {
/*   70 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   71 */     return cdmMap.get(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ChunkDataManager addCDM(World world) {
/*   76 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   77 */     if (!cdmMap.containsKey(Integer.valueOf(key)))
/*   78 */       return cdmMap.put(Integer.valueOf(key), new ChunkDataManager(world)); 
/*   79 */     return cdmMap.get(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ChunkDataManager removeCDM(World world) {
/*   84 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   85 */     return cdmMap.remove(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static int getMouseX() {
/*   92 */     ScaledResolution scaledresolution = new ScaledResolution(Minecraft.func_71410_x(), (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*   93 */     int i = scaledresolution.func_78326_a();
/*   94 */     int k = Mouse.getX() * i / (Minecraft.func_71410_x()).field_71443_c;
/*      */     
/*   96 */     return k;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static int getMouseY() {
/*  103 */     ScaledResolution scaledresolution = new ScaledResolution(Minecraft.func_71410_x(), (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*  104 */     int j = scaledresolution.func_78328_b();
/*  105 */     int l = j - Mouse.getY() * j / (Minecraft.func_71410_x()).field_71440_d - 1;
/*      */     
/*  107 */     return l;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean isBlockAboveSolid(IBlockAccess blockAccess, int i, int j, int k) {
/*  112 */     if (TerraFirmaCraft.proxy.getCurrentWorld().func_147439_a(i, j + 1, k).func_149662_c())
/*  113 */       return Boolean.valueOf(true); 
/*  114 */     return Boolean.valueOf(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getExtraEquipInventorySize() {
/*  119 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static InventoryPlayer getNewInventory(EntityPlayer player) {
/*  124 */     InventoryPlayer ip = player.field_71071_by;
/*  125 */     NBTTagList nbt = new NBTTagList();
/*  126 */     nbt = player.field_71071_by.func_70442_a(nbt);
/*  127 */     InventoryPlayerTFC inventoryPlayerTFC = new InventoryPlayerTFC(player);
/*  128 */     inventoryPlayerTFC.func_70443_b(nbt);
/*  129 */     return (InventoryPlayer)inventoryPlayerTFC;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ItemStack randomGem(Random random, int rockType) {
/*  134 */     ItemStack is = null;
/*  135 */     if (random.nextInt(500) == 0) {
/*      */       
/*  137 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  138 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 0));
/*  139 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 0));
/*  140 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 0));
/*  141 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 0));
/*  142 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 0));
/*  143 */       items.add(new ItemStack(TFCItems.gemJade, 1, 0));
/*  144 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 0));
/*  145 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 0));
/*  146 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 0));
/*  147 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 0));
/*  148 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 0));
/*  149 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 0));
/*      */       
/*  151 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  153 */     else if (random.nextInt(1000) == 0) {
/*      */       
/*  155 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  156 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 1));
/*  157 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 1));
/*  158 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 1));
/*  159 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 1));
/*  160 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 1));
/*  161 */       items.add(new ItemStack(TFCItems.gemJade, 1, 1));
/*  162 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 1));
/*  163 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 1));
/*  164 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 1));
/*  165 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 1));
/*  166 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 1));
/*  167 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 1));
/*      */       
/*  169 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  171 */     else if (random.nextInt(2000) == 0) {
/*      */       
/*  173 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  174 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 2));
/*  175 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 2));
/*  176 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 2));
/*  177 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 2));
/*  178 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 2));
/*  179 */       items.add(new ItemStack(TFCItems.gemJade, 1, 2));
/*  180 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 2));
/*  181 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 2));
/*  182 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 2));
/*  183 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 2));
/*  184 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 2));
/*  185 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 2));
/*      */       
/*  187 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  189 */     else if (random.nextInt(4000) == 0) {
/*      */       
/*  191 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  192 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 3));
/*  193 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 3));
/*  194 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 3));
/*  195 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 3));
/*  196 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 3));
/*  197 */       items.add(new ItemStack(TFCItems.gemJade, 1, 3));
/*  198 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 3));
/*  199 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 3));
/*  200 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 3));
/*  201 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 3));
/*  202 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 3));
/*  203 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 3));
/*      */       
/*  205 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  207 */     else if (random.nextInt(8000) == 0) {
/*      */       
/*  209 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  210 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 4));
/*  211 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 4));
/*  212 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 4));
/*  213 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 4));
/*  214 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 4));
/*  215 */       items.add(new ItemStack(TFCItems.gemJade, 1, 4));
/*  216 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 4));
/*  217 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 4));
/*  218 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 4));
/*  219 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 4));
/*  220 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 4));
/*  221 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 4));
/*      */       
/*  223 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     } 
/*  225 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void surroundWithLeaves(World world, int i, int j, int k, int meta, Random r) {
/*  230 */     for (int y = 2; y >= -2; y--) {
/*      */       
/*  232 */       for (int x = 2; x >= -2; x--) {
/*      */         
/*  234 */         for (int z = 2; z >= -2; z--) {
/*      */           
/*  236 */           if (world.func_147437_c(i + x, j + y, k + z)) {
/*  237 */             world.func_147465_d(i + x, j + y, k + z, TFCBlocks.leaves, meta, 2);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void setupWorld(World world) {
/*  245 */     long seed = world.func_72905_C();
/*  246 */     Random r = new Random(seed);
/*  247 */     world.field_73011_w.func_76558_a(world);
/*  248 */     Recipes.registerAnvilRecipes(r, world);
/*  249 */     TFC_Time.updateTime(world);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setupWorld(World w, long seed) {
/*      */     try {
/*  259 */       ReflectionHelper.setPrivateValue(WorldInfo.class, w.func_72912_H(), Long.valueOf(seed), 0);
/*  260 */       setupWorld(w);
/*      */     }
/*  262 */     catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isRawStone(World world, int x, int y, int z) {
/*  269 */     Block block = world.func_147439_a(x, y, z);
/*  270 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneSed || block == TFCBlocks.stoneMM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSmoothStone(World world, int x, int y, int z) {
/*  278 */     Block block = world.func_147439_a(x, y, z);
/*  279 */     return (block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneMMSmooth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSmoothStone(Block block) {
/*  287 */     return (block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneMMSmooth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isBrickStone(Block block) {
/*  295 */     return (block == TFCBlocks.stoneIgExBrick || block == TFCBlocks.stoneIgInBrick || block == TFCBlocks.stoneSedBrick || block == TFCBlocks.stoneMMBrick);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isRawStone(Block block) {
/*  303 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneSed || block == TFCBlocks.stoneMM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOreStone(Block block) {
/*  311 */     return (block == TFCBlocks.ore || block == TFCBlocks.ore2 || block == TFCBlocks.ore3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNaturalStone(Block block) {
/*  318 */     return (isRawStone(block) || isOreStone(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isCobbleStone(Block block) {
/*  323 */     return (block == TFCBlocks.stoneIgExCobble || block == TFCBlocks.stoneIgInCobble || block == TFCBlocks.stoneSedCobble || block == TFCBlocks.stoneMMCobble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStoneIgEx(Block block) {
/*  331 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgExCobble || block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgExBrick || block == TFCBlocks.wallRawIgEx || block == TFCBlocks.wallCobbleIgEx || block == TFCBlocks.wallBrickIgEx || block == TFCBlocks.wallSmoothIgEx);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStoneIgIn(Block block) {
/*  343 */     return (block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneIgInCobble || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneIgInBrick || block == TFCBlocks.wallRawIgIn || block == TFCBlocks.wallCobbleIgIn || block == TFCBlocks.wallBrickIgIn || block == TFCBlocks.wallSmoothIgIn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStoneSed(Block block) {
/*  355 */     return (block == TFCBlocks.stoneSed || block == TFCBlocks.stoneSedCobble || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneSedBrick || block == TFCBlocks.wallRawSed || block == TFCBlocks.wallCobbleSed || block == TFCBlocks.wallBrickSed || block == TFCBlocks.wallSmoothSed);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStoneMM(Block block) {
/*  367 */     return (block == TFCBlocks.stoneMM || block == TFCBlocks.stoneMMCobble || block == TFCBlocks.stoneMMSmooth || block == TFCBlocks.stoneMMBrick || block == TFCBlocks.wallRawMM || block == TFCBlocks.wallCobbleMM || block == TFCBlocks.wallBrickMM || block == TFCBlocks.wallSmoothMM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isDirt(Block block) {
/*  379 */     return (block == TFCBlocks.dirt || block == TFCBlocks.dirt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFarmland(Block block) {
/*  385 */     return (block == TFCBlocks.tilledSoil || block == TFCBlocks.tilledSoil2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrass(Block block) {
/*  391 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2 || block == TFCBlocks.peatGrass || block == TFCBlocks.dryGrass || block == TFCBlocks.dryGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrassNormal(Block block) {
/*  402 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isLushGrass(Block block) {
/*  409 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2 || block == TFCBlocks.peatGrass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isClayGrass(Block block) {
/*  418 */     return (block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPeatGrass(Block block) {
/*  424 */     return (block == TFCBlocks.peatGrass);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isDryGrass(Block block) {
/*  429 */     return (block == TFCBlocks.dryGrass || block == TFCBlocks.dryGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrassType1(Block block) {
/*  435 */     return (block == TFCBlocks.grass || block == TFCBlocks.clayGrass || block == TFCBlocks.dryGrass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrassType2(Block block) {
/*  442 */     return (block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass2 || block == TFCBlocks.dryGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isClay(Block block) {
/*  449 */     return (block == TFCBlocks.clay || block == TFCBlocks.clay2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSand(Block block) {
/*  454 */     return (block == TFCBlocks.sand || block == TFCBlocks.sand2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPeat(Block block) {
/*  460 */     return (block == TFCBlocks.peat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isHotWater(Block block) {
/*  465 */     return (block == TFCBlocks.hotWater || block == TFCBlocks.hotWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWater(Block block) {
/*  470 */     return (isSaltWater(block) || 
/*  471 */       isFreshWater(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWaterFlowing(Block block) {
/*  476 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.freshWater);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSaltWater(Block block) {
/*  481 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.saltWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSaltWaterIncludeIce(Block block, int meta, Material mat) {
/*  486 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.saltWaterStationary || (mat == Material.field_151588_w && meta == 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFreshWater(Block block) {
/*  492 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFreshWaterIncludeIce(Block block, int meta) {
/*  497 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary || (block == TFCBlocks.ice && meta != 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFreshWaterIncludeIce(Block block, int meta, Material mat) {
/*  503 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary || (mat == Material.field_151588_w && meta != 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSoil(Block block) {
/*  509 */     return (isGrass(block) || 
/*  510 */       isDirt(block) || 
/*  511 */       isClay(block) || 
/*  512 */       isPeat(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSoilOrGravel(Block block) {
/*  517 */     return (isGrass(block) || 
/*  518 */       isDirt(block) || 
/*  519 */       isClay(block) || 
/*  520 */       isPeat(block) || 
/*  521 */       isGravel(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGravel(Block block) {
/*  526 */     return (block == TFCBlocks.gravel || block == TFCBlocks.gravel2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGround(Block block) {
/*  531 */     return (isSoilOrGravel(block) || 
/*  532 */       isRawStone(block) || 
/*  533 */       isSand(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGroundType1(Block block) {
/*  538 */     return (isGrassType1(block) || block == TFCBlocks.dirt || block == TFCBlocks.gravel || block == TFCBlocks.sand);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSoilWAILA(Block block) {
/*  543 */     return (isDirt(block) || isGravel(block) || isSand(block) || isGrassNormal(block) || isDryGrass(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getSoilMetaFromStone(Block inBlock, int inMeta) {
/*  548 */     if (inBlock == TFCBlocks.stoneIgIn)
/*  549 */       return inMeta; 
/*  550 */     if (inBlock == TFCBlocks.stoneSed)
/*  551 */       return inMeta + 3; 
/*  552 */     if (inBlock == TFCBlocks.stoneIgEx) {
/*  553 */       return inMeta + 11;
/*      */     }
/*      */     
/*  556 */     if (inMeta == 0)
/*  557 */       return inMeta + 15; 
/*  558 */     return inMeta - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSoilMeta(int inMeta) {
/*  564 */     return inMeta & 0xF;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getItemMetaFromStone(Block inBlock, int inMeta) {
/*  569 */     if (inBlock == TFCBlocks.stoneIgIn)
/*  570 */       return inMeta; 
/*  571 */     if (inBlock == TFCBlocks.stoneSed)
/*  572 */       return inMeta + 3; 
/*  573 */     if (inBlock == TFCBlocks.stoneIgEx)
/*  574 */       return inMeta + 11; 
/*  575 */     if (inBlock == TFCBlocks.stoneMM) {
/*  576 */       return inMeta + 15;
/*      */     }
/*  578 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassWithRain(int inMeta, float rain) {
/*  583 */     if (rain >= 500.0F)
/*  584 */       return getTypeForGrass(inMeta); 
/*  585 */     return getTypeForDryGrass(inMeta);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassWithRainByBlock(Block block, float rain) {
/*  590 */     if (rain >= 500.0F)
/*  591 */       return getTypeForGrassFromSoil(block); 
/*  592 */     return getTypeForDryGrassFromSoil(block);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrass(int inMeta) {
/*  597 */     if (inMeta < 16)
/*  598 */       return TFCBlocks.grass; 
/*  599 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassFromDirt(Block block) {
/*  604 */     if (block == TFCBlocks.dirt)
/*  605 */       return TFCBlocks.grass; 
/*  606 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDryGrass(int inMeta) {
/*  611 */     if (inMeta < 16)
/*  612 */       return TFCBlocks.dryGrass; 
/*  613 */     return TFCBlocks.dryGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDryGrassFromSoil(Block block) {
/*  618 */     if (block == TFCBlocks.grass)
/*  619 */       return TFCBlocks.dryGrass; 
/*  620 */     if (block == TFCBlocks.dirt)
/*  621 */       return TFCBlocks.dryGrass; 
/*  622 */     return TFCBlocks.dryGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassFromSoil(Block block) {
/*  627 */     if (block == TFCBlocks.dryGrass)
/*  628 */       return TFCBlocks.grass; 
/*  629 */     if (block == TFCBlocks.dryGrass2)
/*  630 */       return TFCBlocks.grass2; 
/*  631 */     if (block == TFCBlocks.dirt)
/*  632 */       return TFCBlocks.grass; 
/*  633 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClayGrass(int inMeta) {
/*  638 */     if (inMeta < 16)
/*  639 */       return TFCBlocks.clayGrass; 
/*  640 */     return TFCBlocks.clayGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClayGrass(Block block) {
/*  645 */     if (isGroundType1(block))
/*  646 */       return TFCBlocks.clayGrass; 
/*  647 */     return TFCBlocks.clayGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDirt(int inMeta) {
/*  652 */     if (inMeta < 16)
/*  653 */       return TFCBlocks.dirt; 
/*  654 */     return TFCBlocks.dirt2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDirtFromGrass(Block block) {
/*  659 */     if (isDirt(block))
/*  660 */       return block; 
/*  661 */     if (block == TFCBlocks.grass || block == TFCBlocks.dryGrass)
/*  662 */       return TFCBlocks.dirt; 
/*  663 */     return TFCBlocks.dirt2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForSoil(Block block) {
/*  668 */     if (isGrass(block)) {
/*      */       
/*  670 */       if (isGrassType1(block))
/*  671 */         return TFCBlocks.dirt; 
/*  672 */       if (isGrassType2(block))
/*  673 */         return TFCBlocks.dirt2; 
/*  674 */       if (isPeatGrass(block)) {
/*  675 */         return TFCBlocks.peat;
/*      */       }
/*      */     } 
/*  678 */     return block;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClay(int inMeta) {
/*  683 */     if (inMeta < 16)
/*  684 */       return TFCBlocks.clay; 
/*  685 */     return TFCBlocks.clay2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClay(Block block) {
/*  690 */     if (isGroundType1(block))
/*  691 */       return TFCBlocks.clay; 
/*  692 */     return TFCBlocks.clay2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForSand(int inMeta) {
/*  697 */     if (inMeta < 16)
/*  698 */       return TFCBlocks.sand; 
/*  699 */     return TFCBlocks.sand2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGravel(int inMeta) {
/*  704 */     if (inMeta < 16)
/*  705 */       return TFCBlocks.gravel; 
/*  706 */     return TFCBlocks.gravel2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getRockLayerFromHeight(World world, int x, int y, int z) {
/*  711 */     ChunkData cd = getCDM(world).getData(x >> 4, z >> 4);
/*  712 */     if (cd != null) {
/*      */       
/*  714 */       int[] hm = cd.heightmap;
/*  715 */       int localX = x & 0xF;
/*  716 */       int localZ = z & 0xF;
/*  717 */       int localY = localX + localZ * 16;
/*  718 */       if (y <= TFCOptions.rockLayer3Height + hm[localY])
/*  719 */         return 2; 
/*  720 */       if (y <= TFCOptions.rockLayer2Height + hm[localY]) {
/*  721 */         return 1;
/*      */       }
/*  723 */       return 0;
/*      */     } 
/*  725 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean convertGrassToDirt(World world, int i, int j, int k) {
/*  730 */     Block block = world.func_147439_a(i, j, k);
/*  731 */     int meta = world.func_72805_g(i, j, k);
/*  732 */     if (isGrass(block)) {
/*      */       
/*  734 */       if (isGrassType1(block)) {
/*      */         
/*  736 */         world.func_147465_d(i, j, k, TFCBlocks.dirt, meta, 2);
/*  737 */         return true;
/*      */       } 
/*  739 */       if (isGrassType2(block)) {
/*      */         
/*  741 */         world.func_147465_d(i, j, k, TFCBlocks.dirt2, meta, 2);
/*  742 */         return true;
/*      */       } 
/*      */     } 
/*  745 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static EnumFuelMaterial getFuelMaterial(ItemStack is) {
/*  750 */     if (is.func_77973_b() == Item.func_150898_a(TFCBlocks.peat))
/*  751 */       return EnumFuelMaterial.PEAT; 
/*  752 */     if (is.func_77973_b() == TFCItems.coal && is.func_77960_j() == 0)
/*  753 */       return EnumFuelMaterial.COAL; 
/*  754 */     if (is.func_77973_b() == TFCItems.coal && is.func_77960_j() == 1)
/*  755 */       return EnumFuelMaterial.CHARCOAL; 
/*  756 */     if (is.func_77960_j() == 0)
/*  757 */       return EnumFuelMaterial.ASH; 
/*  758 */     if (is.func_77960_j() == 1)
/*  759 */       return EnumFuelMaterial.ASPEN; 
/*  760 */     if (is.func_77960_j() == 2)
/*  761 */       return EnumFuelMaterial.BIRCH; 
/*  762 */     if (is.func_77960_j() == 3)
/*  763 */       return EnumFuelMaterial.CHESTNUT; 
/*  764 */     if (is.func_77960_j() == 4)
/*  765 */       return EnumFuelMaterial.DOUGLASFIR; 
/*  766 */     if (is.func_77960_j() == 5)
/*  767 */       return EnumFuelMaterial.HICKORY; 
/*  768 */     if (is.func_77960_j() == 6)
/*  769 */       return EnumFuelMaterial.MAPLE; 
/*  770 */     if (is.func_77960_j() == 7)
/*  771 */       return EnumFuelMaterial.OAK; 
/*  772 */     if (is.func_77960_j() == 8)
/*  773 */       return EnumFuelMaterial.PINE; 
/*  774 */     if (is.func_77960_j() == 9)
/*  775 */       return EnumFuelMaterial.REDWOOD; 
/*  776 */     if (is.func_77960_j() == 10)
/*  777 */       return EnumFuelMaterial.SPRUCE; 
/*  778 */     if (is.func_77960_j() == 11)
/*  779 */       return EnumFuelMaterial.SYCAMORE; 
/*  780 */     if (is.func_77960_j() == 12)
/*  781 */       return EnumFuelMaterial.WHITECEDAR; 
/*  782 */     if (is.func_77960_j() == 13)
/*  783 */       return EnumFuelMaterial.WHITEELM; 
/*  784 */     if (is.func_77960_j() == 14)
/*  785 */       return EnumFuelMaterial.WILLOW; 
/*  786 */     if (is.func_77960_j() == 15)
/*  787 */       return EnumFuelMaterial.KAPOK; 
/*  788 */     if (is.func_77960_j() == 16)
/*  789 */       return EnumFuelMaterial.ACACIA; 
/*  790 */     return EnumFuelMaterial.ASPEN;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showShiftInformation() {
/*  795 */     return (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && Keyboard.isKeyDown(42));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showCtrlInformation() {
/*  800 */     return (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && Keyboard.isKeyDown(29));
/*      */   }
/*      */ 
/*      */   
/*      */   public static FoodStatsTFC getPlayerFoodStats(EntityPlayer player) {
/*  805 */     FoodStatsTFC foodstats = new FoodStatsTFC(player);
/*  806 */     foodstats.readNBT(player.getEntityData());
/*  807 */     return foodstats;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setPlayerFoodStats(EntityPlayer player, FoodStatsTFC foodstats) {
/*  812 */     foodstats.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static BodyTempStats getBodyTempStats(EntityPlayer player) {
/*  817 */     BodyTempStats body = new BodyTempStats();
/*  818 */     body.readNBT(player.getEntityData());
/*  819 */     return body;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setBodyTempStats(EntityPlayer player, BodyTempStats tempStats) {
/*  824 */     tempStats.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static SkillStats getSkillStats(EntityPlayer player) {
/*  829 */     SkillStats skills = new SkillStats(player);
/*  830 */     skills.readNBT(player.getEntityData());
/*  831 */     return skills;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setSkillStats(EntityPlayer player, SkillStats skills) {
/*  836 */     skills.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isTopFaceSolid(World world, int x, int y, int z) {
/*  841 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  842 */       return true; 
/*  843 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  845 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  846 */       if (te.topExists())
/*  847 */         return true; 
/*      */     } 
/*  849 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.UP);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBottomFaceSolid(World world, int x, int y, int z) {
/*  854 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  855 */       return true; 
/*  856 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  858 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  859 */       if (te.bottomExists())
/*  860 */         return true; 
/*      */     } 
/*  862 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.DOWN);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isNorthFaceSolid(World world, int x, int y, int z) {
/*  867 */     Block bid = world.func_147439_a(x, y, z);
/*  868 */     if (bid.func_149721_r())
/*  869 */       return true; 
/*  870 */     if (bid == TFCBlocks.metalSheet) {
/*      */       
/*  872 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  873 */       if (te.northExists())
/*  874 */         return true; 
/*      */     } 
/*  876 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.NORTH);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSouthFaceSolid(World world, int x, int y, int z) {
/*  881 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  882 */       return true; 
/*  883 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  885 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  886 */       if (te.southExists())
/*  887 */         return true; 
/*      */     } 
/*  889 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.SOUTH);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isEastFaceSolid(World world, int x, int y, int z) {
/*  894 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  895 */       return true; 
/*  896 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  898 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  899 */       if (te.eastExists())
/*  900 */         return true; 
/*      */     } 
/*  902 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.EAST);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWestFaceSolid(World world, int x, int y, int z) {
/*  907 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  908 */       return true; 
/*  909 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  911 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  912 */       if (te.westExists())
/*  913 */         return true; 
/*      */     } 
/*  915 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.WEST);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSurroundedSolid(World world, int x, int y, int z) {
/*  920 */     return (isNorthFaceSolid(world, x, y, z + 1) && 
/*  921 */       isSouthFaceSolid(world, x, y, z - 1) && 
/*  922 */       isEastFaceSolid(world, x - 1, y, z) && 
/*  923 */       isWestFaceSolid(world, x + 1, y, z) && 
/*  924 */       isTopFaceSolid(world, x, y - 1, z));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSurroundedStone(World world, int x, int y, int z) {
/*  929 */     return (world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151576_e && world
/*  930 */       .func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151576_e && world
/*  931 */       .func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151576_e && world
/*  932 */       .func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151576_e && world
/*  933 */       .func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151576_e);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isOreIron(ItemStack is) {
/*  938 */     return (is.func_77973_b() instanceof ItemOre && ((ItemOre)is.func_77973_b()).getMetalType(is) == Global.PIGIRON);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getEntityMaxHealth(EntityLivingBase entity) {
/*  943 */     return (float)entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getPercentGrown(IAnimal animal) {
/*  948 */     float birth = animal.getBirthDay();
/*  949 */     float time = TFC_Time.getTotalDays();
/*  950 */     float percent = (time - birth) / animal.getNumberOfDaysToAdult();
/*  951 */     return Math.min(percent, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void bindTexture(ResourceLocation texture) {
/*  956 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isPlayerInDebugMode(EntityPlayer player) {
/*  961 */     return TFCOptions.enableDebugMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addPlayerExhaustion(EntityPlayer player, float exhaustion) {
/*  969 */     FoodStatsTFC foodstats = getPlayerFoodStats(player);
/*  970 */     foodstats.addFoodExhaustion(exhaustion);
/*      */     
/*  972 */     setPlayerFoodStats(player, foodstats);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getEnvironmentalDecay(float temp) {
/*  977 */     if (temp > 0.0F) {
/*      */       
/*  979 */       float tempFactor = 1.0F - 15.0F / (15.0F + temp);
/*  980 */       return tempFactor * 2.0F;
/*      */     } 
/*      */     
/*  983 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z) {
/*  992 */     handleItemTicking(iinv, world, x, y, z, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(ItemStack[] iinv, World world, int x, int y, int z) {
/* 1001 */     handleItemTicking(iinv, world, x, y, z, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z, float environmentalDecayFactor) {
/* 1010 */     for (int i = 0; !world.field_72995_K && i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1012 */       ItemStack is = iinv.func_70301_a(i);
/* 1013 */       if (is != null && (iinv.func_70301_a(i)).field_77994_a <= 0) {
/* 1014 */         iinv.func_70299_a(i, null);
/*      */       }
/* 1016 */       if (is != null)
/*      */       {
/* 1018 */         if (is.field_77994_a == 0) {
/*      */           
/* 1020 */           iinv.func_70299_a(i, null);
/*      */         
/*      */         }
/* 1023 */         else if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */           
/* 1025 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1027 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, 1.0F);
/* 1028 */             if (is != null && (iinv instanceof InventoryPlayer || iinv instanceof com.bioxx.tfc.TileEntities.TEBarrel || iinv instanceof com.bioxx.tfc.TileEntities.TEAnvil || iinv instanceof com.bioxx.tfc.TileEntities.TEForge || iinv instanceof com.bioxx.tfc.TileEntities.TEFirepit || iinv instanceof com.bioxx.tfc.TileEntities.TEVessel || iinv instanceof com.bioxx.tfc.TileEntities.TEFoodPrep)) {
/*      */               
/* 1030 */               TFC_ItemHeat.handleItemHeat(is);
/*      */             } else {
/* 1032 */               TFC_ItemHeat.handleItemHeatStorage(is);
/* 1033 */             }  iinv.func_70299_a(i, is);
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static byte getByteFromSmallFloat(float f) {
/* 1042 */     MathHelper.func_76131_a(f, 0.5F, 1.5F);
/* 1043 */     return (byte)(Float.floatToIntBits(f) >> 16 & 0xFF);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getSmallFloatFromByte(byte b) {
/* 1048 */     return ByteBuffer.wrap(new byte[] { 63, b, 0, 0 }).getFloat();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z, float environmentalDecayFactor, float baseDecayMod) {
/* 1057 */     for (int i = 0; !world.field_72995_K && i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1059 */       ItemStack is = iinv.func_70301_a(i);
/* 1060 */       if (is != null && (iinv.func_70301_a(i)).field_77994_a <= 0) {
/* 1061 */         iinv.func_70299_a(i, null);
/*      */       }
/* 1063 */       if (is != null)
/*      */       {
/* 1065 */         if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z))
/*      */         {
/* 1067 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1069 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, baseDecayMod);
/* 1070 */             if (is != null && (iinv instanceof InventoryPlayer || iinv instanceof com.bioxx.tfc.TileEntities.TEBarrel)) {
/* 1071 */               TFC_ItemHeat.handleItemHeat(is);
/*      */             } else {
/* 1073 */               TFC_ItemHeat.handleItemHeatStorage(is);
/* 1074 */             }  iinv.func_70299_a(i, is);
/*      */           } 
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(ItemStack[] iinv, World world, int x, int y, int z, float environmentalDecayFactor) {
/* 1085 */     for (int i = 0; !world.field_72995_K && i < iinv.length; i++) {
/*      */       
/* 1087 */       ItemStack is = iinv[i];
/* 1088 */       if (is != null && (iinv[i]).field_77994_a <= 0) {
/* 1089 */         iinv[i] = null;
/*      */       }
/* 1091 */       if (is != null)
/*      */       {
/* 1093 */         if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z))
/*      */         {
/* 1095 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1097 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, 1.0F);
/* 1098 */             if (is != null)
/* 1099 */               TFC_ItemHeat.handleItemHeat(is); 
/* 1100 */             iinv[i] = is;
/*      */           } 
/*      */         }
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ItemStack tickDecay(ItemStack is, World world, int x, int y, int z, float environmentalDecayFactor, float baseDecayMod) {
/* 1113 */     NBTTagCompound nbt = is.func_77978_p();
/* 1114 */     if (nbt == null || !nbt.func_74764_b("foodWeight") || !nbt.func_74764_b("foodDecay")) {
/* 1115 */       return is;
/*      */     }
/* 1117 */     int decayTimer = Food.getDecayTimer(is);
/*      */     
/* 1119 */     if (decayTimer < TFC_Time.getTotalHours()) {
/*      */       
/* 1121 */       int timeDiff = (int)(TFC_Time.getTotalHours() - decayTimer);
/* 1122 */       float protMult = 1.0F;
/*      */       
/* 1124 */       if (TFCOptions.useDecayProtection)
/*      */       {
/* 1126 */         if (timeDiff > TFCOptions.decayProtectionDays * 24) {
/*      */           
/* 1128 */           decayTimer = (int)(TFC_Time.getTotalHours() - (TFCOptions.decayProtectionDays * 24) - 1L);
/* 1129 */           protMult = (1 - timeDiff / TFCOptions.decayProtectionDays * 24);
/*      */         }
/* 1131 */         else if (timeDiff > 24) {
/*      */           
/* 1133 */           protMult = (1 - timeDiff / TFCOptions.decayProtectionDays * 24);
/*      */         } 
/*      */       }
/*      */       
/* 1137 */       float decay = Food.getDecay(is);
/* 1138 */       float thisDecayRate = 1.0F;
/* 1139 */       if (is.func_77973_b() instanceof IFood && Food.getWeight(is) > 160.0F) {
/* 1140 */         thisDecayRate = 100.0F;
/*      */       }
/* 1142 */       else if (is.func_77973_b() instanceof IFood) {
/* 1143 */         thisDecayRate = ((IFood)is.func_77973_b()).getDecayRate(is);
/*      */       } else {
/*      */         
/* 1146 */         thisDecayRate = Food.getDecayRate(is);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1155 */       float temp = getCachedTemp(world, x, y, z, decayTimer);
/* 1156 */       float environmentalDecay = getEnvironmentalDecay(temp) * environmentalDecayFactor;
/*      */       
/* 1158 */       if (decay < 0.0F) {
/*      */         
/* 1160 */         float d = 1.0F * thisDecayRate * baseDecayMod * environmentalDecay;
/* 1161 */         if (decay + d < 0.0F) {
/* 1162 */           decay += d;
/*      */         } else {
/* 1164 */           decay = 0.0F;
/*      */         } 
/* 1166 */       } else if (decay == 0.0F) {
/*      */         
/* 1168 */         decay = Food.getWeight(is) * world.field_73012_v.nextFloat() * 0.005F * TFCOptions.decayMultiplier;
/*      */       }
/*      */       else {
/*      */         
/* 1172 */         double fdr = (TFCOptions.foodDecayRate - 1.0F);
/* 1173 */         fdr *= (thisDecayRate * baseDecayMod * environmentalDecay * protMult * TFCOptions.decayMultiplier);
/* 1174 */         decay = (float)(decay * (1.0D + fdr));
/*      */       } 
/* 1176 */       Food.setDecayTimer(is, decayTimer + 1);
/* 1177 */       Food.setDecay(is, decay);
/*      */     } 
/*      */     
/* 1180 */     if (Food.getDecay(is) / Food.getWeight(is) > 0.9F)
/*      */     {
/* 1182 */       if (is.func_77973_b() instanceof IFood) {
/* 1183 */         is = ((IFood)is.func_77973_b()).onDecayed(is, world, x, y, z);
/*      */       } else {
/* 1185 */         is.field_77994_a = 0;
/*      */       } 
/*      */     }
/* 1188 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getCachedTemp(World world, int x, int y, int z, int th) {
/* 1193 */     float cacheTemp = TFC_Climate.getCacheManager(world).getTemp(x, z, th);
/* 1194 */     if (cacheTemp != Float.MIN_VALUE)
/*      */     {
/* 1196 */       return cacheTemp;
/*      */     }
/* 1198 */     float temp = TFC_Climate.getHeightAdjustedTempSpecificDay(world, TFC_Time.getDayFromTotalHours(th), TFC_Time.getHourOfDayFromTotalHours(th), x, y, z);
/* 1199 */     addCachedTemp(world, x, z, th, temp);
/* 1200 */     return temp;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addCachedTemp(World world, int x, int z, int th, float temp) {
/* 1205 */     TFC_Climate.getCacheManager(world).addTemp(x, z, th, temp);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void animalDropMeat(Entity e, Item i, float foodWeight) {
/* 1211 */     ItemStack is = ItemFoodTFC.createTag(new ItemStack(i, 1), foodWeight);
/* 1212 */     Random r = new Random(e.func_110124_au().getLeastSignificantBits() + e.func_110124_au().getMostSignificantBits());
/* 1213 */     Food.adjustFlavor(is, r);
/* 1214 */     e.capturedDrops.add(new EntityItem(e.field_70170_p, e.field_70165_t, e.field_70163_u, e.field_70161_v, is));
/*      */   }
/*      */ 
/*      */   
/*      */   public static Vec3 getEntityPos(Entity e) {
/* 1219 */     return Vec3.func_72443_a(e.field_70165_t, e.field_70163_u, e.field_70161_v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void giveItemToPlayer(ItemStack is, EntityPlayer player) {
/* 1224 */     if (player.field_70170_p.field_72995_K)
/*      */       return; 
/* 1226 */     EntityItem ei = player.func_70099_a(is, 1.0F);
/* 1227 */     ei.field_145804_b = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFence(Block b) {
/* 1232 */     return (b == TFCBlocks.fence || b == TFCBlocks.fence2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isVertSupport(Block b) {
/* 1237 */     return (b == TFCBlocks.woodSupportV || b == TFCBlocks.woodSupportV2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isHorizSupport(Block b) {
/* 1242 */     return (b == TFCBlocks.woodSupportH || b == TFCBlocks.woodSupportH2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isOceanicBiome(int id) {
/* 1247 */     return (id == TFCBiome.OCEAN.field_76756_M || id == TFCBiome.DEEP_OCEAN.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isMountainBiome(int id) {
/* 1252 */     return (id == TFCBiome.MOUNTAINS.field_76756_M || id == TFCBiome.MOUNTAINS_EDGE.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBeachBiome(int id) {
/* 1257 */     return (id == TFCBiome.BEACH.field_76756_M || id == TFCBiome.GRAVEL_BEACH.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isValidCharcoalPitCover(Block block) {
/* 1262 */     if (Blocks.field_150480_ab.getFlammability(block) > 0 && block != TFCBlocks.logPile) return false;
/*      */     
/* 1264 */     return (block == TFCBlocks.logPile || 
/* 1265 */       isCobbleStone(block) || 
/* 1266 */       isBrickStone(block) || 
/* 1267 */       isSmoothStone(block) || 
/* 1268 */       isGround(block) || block == Blocks.field_150359_w || block == Blocks.field_150399_cn || block == TFCBlocks.metalTrapDoor || block == Blocks.field_150454_av || block
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1273 */       .func_149662_c());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void writeInventoryToNBT(NBTTagCompound nbt, ItemStack[] storage) {
/* 1278 */     writeInventoryToNBT(nbt, storage, "Items");
/*      */   }
/*      */ 
/*      */   
/*      */   public static void writeInventoryToNBT(NBTTagCompound nbt, ItemStack[] storage, String name) {
/* 1283 */     NBTTagList nbttaglist = new NBTTagList();
/* 1284 */     for (int i = 0; i < storage.length; i++) {
/*      */       
/* 1286 */       if (storage[i] != null) {
/*      */         
/* 1288 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 1289 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 1290 */         storage[i].func_77955_b(nbttagcompound1);
/* 1291 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*      */       } 
/*      */     } 
/* 1294 */     nbt.func_74782_a(name, (NBTBase)nbttaglist);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void readInventoryFromNBT(NBTTagCompound nbt, ItemStack[] storage) {
/* 1299 */     readInventoryFromNBT(nbt, storage, "Items");
/*      */   }
/*      */ 
/*      */   
/*      */   public static void readInventoryFromNBT(NBTTagCompound nbt, ItemStack[] storage, String name) {
/* 1304 */     NBTTagList nbttaglist = nbt.func_150295_c(name, 10);
/* 1305 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*      */       
/* 1307 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 1308 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 1309 */       if (byte0 >= 0 && byte0 < storage.length) {
/* 1310 */         storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public static ItemStack getItemInInventory(Item item, IInventory iinv) {
/* 1316 */     for (int i = 0; i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1318 */       iinv.func_70301_a(i);
/* 1319 */       if (iinv.func_70301_a(i) != null && iinv.func_70301_a(i).func_77973_b() == item)
/*      */       {
/* 1321 */         return iinv.func_70301_a(i);
/*      */       }
/*      */     } 
/* 1324 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void destroyBlock(World world, int x, int y, int z) {
/* 1329 */     if (world.func_147439_a(x, y, z) != Blocks.field_150350_a) {
/*      */       
/* 1331 */       world.func_147439_a(x, y, z).func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 1332 */       world.func_147468_f(x, y, z);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean areItemsEqual(ItemStack is1, ItemStack is2) {
/* 1338 */     Item i1 = null; int d1 = 0;
/* 1339 */     Item i2 = null; int d2 = 0;
/* 1340 */     if (is1 != null) {
/*      */       
/* 1342 */       i1 = is1.func_77973_b(); d1 = is1.func_77960_j();
/*      */     } 
/* 1344 */     if (is2 != null) {
/*      */       
/* 1346 */       i2 = is2.func_77973_b(); d2 = is2.func_77960_j();
/*      */     } 
/* 1348 */     return (i1 == i2 && d1 == d2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean setBlockWithDrops(World world, int x, int y, int z, Block b, int meta) {
/* 1353 */     Block block = world.func_147439_a(x, y, z);
/*      */     
/* 1355 */     if (block.func_149688_o() != Material.field_151579_a) {
/*      */       
/* 1357 */       int l = world.func_72805_g(x, y, z);
/* 1358 */       world.func_72926_e(2001, x, y, z, Block.func_149682_b(block) + (l << 12));
/* 1359 */       block.func_149697_b(world, x, y, z, l, 0);
/*      */     } 
/* 1361 */     return world.func_147465_d(x, y, z, b, meta, 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockToAirWithDrops(World world, int x, int y, int z) {
/* 1369 */     return world.func_147480_a(x, y, z, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWaterBiome(BiomeGenBase b) {
/* 1374 */     return (isBeachBiome(b.field_76756_M) || isOceanicBiome(b.field_76756_M) || b == TFCBiome.LAKE || b == TFCBiome.RIVER);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String translate(String s) {
/* 1379 */     return StatCollector.func_74838_a(s);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void sendInfoMessage(EntityPlayer player, IChatComponent text) {
/* 1384 */     text.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
/* 1385 */     player.func_146105_b(text);
/*      */   }
/*      */ 
/*      */   
/*      */   public static long getSuperSeed(World w) {
/* 1390 */     return w.func_72905_C() + w.func_72912_H().func_76066_a().func_74763_f("superseed");
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isExposedToRain(World world, int x, int y, int z) {
/* 1395 */     int highestY = world.func_72874_g(x, z) - 1;
/* 1396 */     boolean isExposed = true;
/* 1397 */     if (world.func_72937_j(x, y + 1, z)) {
/*      */ 
/*      */       
/* 1400 */       if (world.func_147439_a(x, highestY, z) instanceof net.minecraft.block.BlockGlass || world
/* 1401 */         .func_147439_a(x, highestY, z) instanceof net.minecraft.block.BlockStainedGlass || world
/* 1402 */         .isSideSolid(x, highestY, z, ForgeDirection.UP) || world
/* 1403 */         .isSideSolid(x, highestY, z, ForgeDirection.DOWN)) {
/* 1404 */         isExposed = false;
/*      */       }
/*      */     } else {
/* 1407 */       isExposed = false;
/*      */     } 
/* 1409 */     return (world.func_72896_J() && isExposed);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_Core.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */