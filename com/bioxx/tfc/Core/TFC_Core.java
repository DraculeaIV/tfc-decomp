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
/*   64 */   private static Map<Integer, ChunkDataManager> cdmMap = new HashMap<Integer, ChunkDataManager>();
/*      */   
/*      */   public static boolean preventEntityDataUpdate;
/*      */   
/*      */   public static ChunkDataManager getCDM(World world) {
/*   69 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   70 */     return cdmMap.get(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ChunkDataManager addCDM(World world) {
/*   75 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   76 */     if (!cdmMap.containsKey(Integer.valueOf(key)))
/*   77 */       return cdmMap.put(Integer.valueOf(key), new ChunkDataManager(world)); 
/*   78 */     return cdmMap.get(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ChunkDataManager removeCDM(World world) {
/*   83 */     int key = world.field_72995_K ? (0x80 | world.field_73011_w.field_76574_g) : world.field_73011_w.field_76574_g;
/*   84 */     return cdmMap.remove(Integer.valueOf(key));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static int getMouseX() {
/*   91 */     ScaledResolution scaledresolution = new ScaledResolution(Minecraft.func_71410_x(), (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*   92 */     int i = scaledresolution.func_78326_a();
/*   93 */     int k = Mouse.getX() * i / (Minecraft.func_71410_x()).field_71443_c;
/*      */     
/*   95 */     return k;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public static int getMouseY() {
/*  102 */     ScaledResolution scaledresolution = new ScaledResolution(Minecraft.func_71410_x(), (Minecraft.func_71410_x()).field_71443_c, (Minecraft.func_71410_x()).field_71440_d);
/*  103 */     int j = scaledresolution.func_78328_b();
/*  104 */     int l = j - Mouse.getY() * j / (Minecraft.func_71410_x()).field_71440_d - 1;
/*      */     
/*  106 */     return l;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Boolean isBlockAboveSolid(IBlockAccess blockAccess, int i, int j, int k) {
/*  111 */     if (TerraFirmaCraft.proxy.getCurrentWorld().func_147439_a(i, j + 1, k).func_149662_c())
/*  112 */       return Boolean.valueOf(true); 
/*  113 */     return Boolean.valueOf(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getExtraEquipInventorySize() {
/*  118 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public static InventoryPlayer getNewInventory(EntityPlayer player) {
/*  123 */     InventoryPlayer ip = player.field_71071_by;
/*  124 */     NBTTagList nbt = new NBTTagList();
/*  125 */     nbt = player.field_71071_by.func_70442_a(nbt);
/*  126 */     InventoryPlayerTFC inventoryPlayerTFC = new InventoryPlayerTFC(player);
/*  127 */     inventoryPlayerTFC.func_70443_b(nbt);
/*  128 */     return (InventoryPlayer)inventoryPlayerTFC;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ItemStack randomGem(Random random, int rockType) {
/*  133 */     ItemStack is = null;
/*  134 */     if (random.nextInt(500) == 0) {
/*      */       
/*  136 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  137 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 0));
/*  138 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 0));
/*  139 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 0));
/*  140 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 0));
/*  141 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 0));
/*  142 */       items.add(new ItemStack(TFCItems.gemJade, 1, 0));
/*  143 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 0));
/*  144 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 0));
/*  145 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 0));
/*  146 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 0));
/*  147 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 0));
/*  148 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 0));
/*      */       
/*  150 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  152 */     else if (random.nextInt(1000) == 0) {
/*      */       
/*  154 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  155 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 1));
/*  156 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 1));
/*  157 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 1));
/*  158 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 1));
/*  159 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 1));
/*  160 */       items.add(new ItemStack(TFCItems.gemJade, 1, 1));
/*  161 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 1));
/*  162 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 1));
/*  163 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 1));
/*  164 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 1));
/*  165 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 1));
/*  166 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 1));
/*      */       
/*  168 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  170 */     else if (random.nextInt(2000) == 0) {
/*      */       
/*  172 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  173 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 2));
/*  174 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 2));
/*  175 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 2));
/*  176 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 2));
/*  177 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 2));
/*  178 */       items.add(new ItemStack(TFCItems.gemJade, 1, 2));
/*  179 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 2));
/*  180 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 2));
/*  181 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 2));
/*  182 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 2));
/*  183 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 2));
/*  184 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 2));
/*      */       
/*  186 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  188 */     else if (random.nextInt(4000) == 0) {
/*      */       
/*  190 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  191 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 3));
/*  192 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 3));
/*  193 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 3));
/*  194 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 3));
/*  195 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 3));
/*  196 */       items.add(new ItemStack(TFCItems.gemJade, 1, 3));
/*  197 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 3));
/*  198 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 3));
/*  199 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 3));
/*  200 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 3));
/*  201 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 3));
/*  202 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 3));
/*      */       
/*  204 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     }
/*  206 */     else if (random.nextInt(8000) == 0) {
/*      */       
/*  208 */       ArrayList<ItemStack> items = new ArrayList<ItemStack>();
/*  209 */       items.add(new ItemStack(TFCItems.gemAgate, 1, 4));
/*  210 */       items.add(new ItemStack(TFCItems.gemAmethyst, 1, 4));
/*  211 */       items.add(new ItemStack(TFCItems.gemBeryl, 1, 4));
/*  212 */       items.add(new ItemStack(TFCItems.gemEmerald, 1, 4));
/*  213 */       items.add(new ItemStack(TFCItems.gemGarnet, 1, 4));
/*  214 */       items.add(new ItemStack(TFCItems.gemJade, 1, 4));
/*  215 */       items.add(new ItemStack(TFCItems.gemJasper, 1, 4));
/*  216 */       items.add(new ItemStack(TFCItems.gemOpal, 1, 4));
/*  217 */       items.add(new ItemStack(TFCItems.gemRuby, 1, 4));
/*  218 */       items.add(new ItemStack(TFCItems.gemSapphire, 1, 4));
/*  219 */       items.add(new ItemStack(TFCItems.gemTourmaline, 1, 4));
/*  220 */       items.add(new ItemStack(TFCItems.gemTopaz, 1, 4));
/*      */       
/*  222 */       is = (ItemStack)items.toArray()[random.nextInt((items.toArray()).length)];
/*      */     } 
/*  224 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void surroundWithLeaves(World world, int i, int j, int k, int meta, Random r) {
/*  229 */     for (int y = 2; y >= -2; y--) {
/*      */       
/*  231 */       for (int x = 2; x >= -2; x--) {
/*      */         
/*  233 */         for (int z = 2; z >= -2; z--) {
/*      */           
/*  235 */           if (world.func_147437_c(i + x, j + y, k + z)) {
/*  236 */             world.func_147465_d(i + x, j + y, k + z, TFCBlocks.leaves, meta, 2);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void setupWorld(World world) {
/*  244 */     long seed = world.func_72905_C();
/*  245 */     Random r = new Random(seed);
/*  246 */     world.field_73011_w.func_76558_a(world);
/*  247 */     Recipes.registerAnvilRecipes(r, world);
/*  248 */     TFC_Time.updateTime(world);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setupWorld(World w, long seed) {
/*      */     try {
/*  258 */       ReflectionHelper.setPrivateValue(WorldInfo.class, w.func_72912_H(), Long.valueOf(seed), 0);
/*  259 */       setupWorld(w);
/*      */     }
/*  261 */     catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isRawStone(World world, int x, int y, int z) {
/*  268 */     Block block = world.func_147439_a(x, y, z);
/*  269 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneSed || block == TFCBlocks.stoneMM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSmoothStone(World world, int x, int y, int z) {
/*  277 */     Block block = world.func_147439_a(x, y, z);
/*  278 */     return (block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneMMSmooth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSmoothStone(Block block) {
/*  286 */     return (block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneMMSmooth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isBrickStone(Block block) {
/*  294 */     return (block == TFCBlocks.stoneIgExBrick || block == TFCBlocks.stoneIgInBrick || block == TFCBlocks.stoneSedBrick || block == TFCBlocks.stoneMMBrick);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isRawStone(Block block) {
/*  302 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneSed || block == TFCBlocks.stoneMM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isOreStone(Block block) {
/*  310 */     return (block == TFCBlocks.ore || block == TFCBlocks.ore2 || block == TFCBlocks.ore3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNaturalStone(Block block) {
/*  317 */     return (isRawStone(block) || isOreStone(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isCobbleStone(Block block) {
/*  322 */     return (block == TFCBlocks.stoneIgExCobble || block == TFCBlocks.stoneIgInCobble || block == TFCBlocks.stoneSedCobble || block == TFCBlocks.stoneMMCobble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isStoneIgEx(Block block) {
/*  330 */     return (block == TFCBlocks.stoneIgEx || block == TFCBlocks.stoneIgExCobble || block == TFCBlocks.stoneIgExSmooth || block == TFCBlocks.stoneIgExBrick || block == TFCBlocks.wallRawIgEx || block == TFCBlocks.wallCobbleIgEx || block == TFCBlocks.wallBrickIgEx || block == TFCBlocks.wallSmoothIgEx);
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
/*  342 */     return (block == TFCBlocks.stoneIgIn || block == TFCBlocks.stoneIgInCobble || block == TFCBlocks.stoneIgInSmooth || block == TFCBlocks.stoneIgInBrick || block == TFCBlocks.wallRawIgIn || block == TFCBlocks.wallCobbleIgIn || block == TFCBlocks.wallBrickIgIn || block == TFCBlocks.wallSmoothIgIn);
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
/*  354 */     return (block == TFCBlocks.stoneSed || block == TFCBlocks.stoneSedCobble || block == TFCBlocks.stoneSedSmooth || block == TFCBlocks.stoneSedBrick || block == TFCBlocks.wallRawSed || block == TFCBlocks.wallCobbleSed || block == TFCBlocks.wallBrickSed || block == TFCBlocks.wallSmoothSed);
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
/*  366 */     return (block == TFCBlocks.stoneMM || block == TFCBlocks.stoneMMCobble || block == TFCBlocks.stoneMMSmooth || block == TFCBlocks.stoneMMBrick || block == TFCBlocks.wallRawMM || block == TFCBlocks.wallCobbleMM || block == TFCBlocks.wallBrickMM || block == TFCBlocks.wallSmoothMM);
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
/*  378 */     return (block == TFCBlocks.dirt || block == TFCBlocks.dirt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFarmland(Block block) {
/*  384 */     return (block == TFCBlocks.tilledSoil || block == TFCBlocks.tilledSoil2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrass(Block block) {
/*  390 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2 || block == TFCBlocks.peatGrass || block == TFCBlocks.dryGrass || block == TFCBlocks.dryGrass2);
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
/*  401 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isLushGrass(Block block) {
/*  408 */     return (block == TFCBlocks.grass || block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2 || block == TFCBlocks.peatGrass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isClayGrass(Block block) {
/*  417 */     return (block == TFCBlocks.clayGrass || block == TFCBlocks.clayGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPeatGrass(Block block) {
/*  423 */     return (block == TFCBlocks.peatGrass);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isDryGrass(Block block) {
/*  428 */     return (block == TFCBlocks.dryGrass || block == TFCBlocks.dryGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrassType1(Block block) {
/*  434 */     return (block == TFCBlocks.grass || block == TFCBlocks.clayGrass || block == TFCBlocks.dryGrass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isGrassType2(Block block) {
/*  441 */     return (block == TFCBlocks.grass2 || block == TFCBlocks.clayGrass2 || block == TFCBlocks.dryGrass2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isClay(Block block) {
/*  448 */     return (block == TFCBlocks.clay || block == TFCBlocks.clay2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSand(Block block) {
/*  453 */     return (block == TFCBlocks.sand || block == TFCBlocks.sand2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isPeat(Block block) {
/*  459 */     return (block == TFCBlocks.peat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isHotWater(Block block) {
/*  464 */     return (block == TFCBlocks.hotWater || block == TFCBlocks.hotWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWater(Block block) {
/*  469 */     return (isSaltWater(block) || 
/*  470 */       isFreshWater(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWaterFlowing(Block block) {
/*  475 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.freshWater);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSaltWater(Block block) {
/*  480 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.saltWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSaltWaterIncludeIce(Block block, int meta, Material mat) {
/*  485 */     return (block == TFCBlocks.saltWater || block == TFCBlocks.saltWaterStationary || (mat == Material.field_151588_w && meta == 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFreshWater(Block block) {
/*  491 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFreshWaterIncludeIce(Block block, int meta) {
/*  496 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary || (block == TFCBlocks.ice && meta != 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFreshWaterIncludeIce(Block block, int meta, Material mat) {
/*  502 */     return (block == TFCBlocks.freshWater || block == TFCBlocks.freshWaterStationary || (mat == Material.field_151588_w && meta != 0));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSoil(Block block) {
/*  508 */     return (isGrass(block) || 
/*  509 */       isDirt(block) || 
/*  510 */       isClay(block) || 
/*  511 */       isPeat(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSoilOrGravel(Block block) {
/*  516 */     return (isGrass(block) || 
/*  517 */       isDirt(block) || 
/*  518 */       isClay(block) || 
/*  519 */       isPeat(block) || 
/*  520 */       isGravel(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGravel(Block block) {
/*  525 */     return (block == TFCBlocks.gravel || block == TFCBlocks.gravel2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGround(Block block) {
/*  530 */     return (isSoilOrGravel(block) || 
/*  531 */       isRawStone(block) || 
/*  532 */       isSand(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isGroundType1(Block block) {
/*  537 */     return (isGrassType1(block) || block == TFCBlocks.dirt || block == TFCBlocks.gravel || block == TFCBlocks.sand);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSoilWAILA(Block block) {
/*  542 */     return (isDirt(block) || isGravel(block) || isSand(block) || isGrassNormal(block) || isDryGrass(block));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getSoilMetaFromStone(Block inBlock, int inMeta) {
/*  547 */     if (inBlock == TFCBlocks.stoneIgIn)
/*  548 */       return inMeta; 
/*  549 */     if (inBlock == TFCBlocks.stoneSed)
/*  550 */       return inMeta + 3; 
/*  551 */     if (inBlock == TFCBlocks.stoneIgEx) {
/*  552 */       return inMeta + 11;
/*      */     }
/*      */     
/*  555 */     if (inMeta == 0)
/*  556 */       return inMeta + 15; 
/*  557 */     return inMeta - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getSoilMeta(int inMeta) {
/*  563 */     return inMeta & 0xF;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getItemMetaFromStone(Block inBlock, int inMeta) {
/*  568 */     if (inBlock == TFCBlocks.stoneIgIn)
/*  569 */       return inMeta; 
/*  570 */     if (inBlock == TFCBlocks.stoneSed)
/*  571 */       return inMeta + 3; 
/*  572 */     if (inBlock == TFCBlocks.stoneIgEx)
/*  573 */       return inMeta + 11; 
/*  574 */     if (inBlock == TFCBlocks.stoneMM) {
/*  575 */       return inMeta + 15;
/*      */     }
/*  577 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassWithRain(int inMeta, float rain) {
/*  582 */     if (rain >= 500.0F)
/*  583 */       return getTypeForGrass(inMeta); 
/*  584 */     return getTypeForDryGrass(inMeta);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassWithRainByBlock(Block block, float rain) {
/*  589 */     if (rain >= 500.0F)
/*  590 */       return getTypeForGrassFromSoil(block); 
/*  591 */     return getTypeForDryGrassFromSoil(block);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrass(int inMeta) {
/*  596 */     if (inMeta < 16)
/*  597 */       return TFCBlocks.grass; 
/*  598 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassFromDirt(Block block) {
/*  603 */     if (block == TFCBlocks.dirt)
/*  604 */       return TFCBlocks.grass; 
/*  605 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDryGrass(int inMeta) {
/*  610 */     if (inMeta < 16)
/*  611 */       return TFCBlocks.dryGrass; 
/*  612 */     return TFCBlocks.dryGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDryGrassFromSoil(Block block) {
/*  617 */     if (block == TFCBlocks.grass)
/*  618 */       return TFCBlocks.dryGrass; 
/*  619 */     if (block == TFCBlocks.dirt)
/*  620 */       return TFCBlocks.dryGrass; 
/*  621 */     return TFCBlocks.dryGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGrassFromSoil(Block block) {
/*  626 */     if (block == TFCBlocks.dryGrass)
/*  627 */       return TFCBlocks.grass; 
/*  628 */     if (block == TFCBlocks.dryGrass2)
/*  629 */       return TFCBlocks.grass2; 
/*  630 */     if (block == TFCBlocks.dirt)
/*  631 */       return TFCBlocks.grass; 
/*  632 */     return TFCBlocks.grass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClayGrass(int inMeta) {
/*  637 */     if (inMeta < 16)
/*  638 */       return TFCBlocks.clayGrass; 
/*  639 */     return TFCBlocks.clayGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClayGrass(Block block) {
/*  644 */     if (isGroundType1(block))
/*  645 */       return TFCBlocks.clayGrass; 
/*  646 */     return TFCBlocks.clayGrass2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDirt(int inMeta) {
/*  651 */     if (inMeta < 16)
/*  652 */       return TFCBlocks.dirt; 
/*  653 */     return TFCBlocks.dirt2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForDirtFromGrass(Block block) {
/*  658 */     if (isDirt(block))
/*  659 */       return block; 
/*  660 */     if (block == TFCBlocks.grass || block == TFCBlocks.dryGrass)
/*  661 */       return TFCBlocks.dirt; 
/*  662 */     return TFCBlocks.dirt2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForSoil(Block block) {
/*  667 */     if (isGrass(block)) {
/*      */       
/*  669 */       if (isGrassType1(block))
/*  670 */         return TFCBlocks.dirt; 
/*  671 */       if (isGrassType2(block))
/*  672 */         return TFCBlocks.dirt2; 
/*  673 */       if (isPeatGrass(block)) {
/*  674 */         return TFCBlocks.peat;
/*      */       }
/*      */     } 
/*  677 */     return block;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClay(int inMeta) {
/*  682 */     if (inMeta < 16)
/*  683 */       return TFCBlocks.clay; 
/*  684 */     return TFCBlocks.clay2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForClay(Block block) {
/*  689 */     if (isGroundType1(block))
/*  690 */       return TFCBlocks.clay; 
/*  691 */     return TFCBlocks.clay2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForSand(int inMeta) {
/*  696 */     if (inMeta < 16)
/*  697 */       return TFCBlocks.sand; 
/*  698 */     return TFCBlocks.sand2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Block getTypeForGravel(int inMeta) {
/*  703 */     if (inMeta < 16)
/*  704 */       return TFCBlocks.gravel; 
/*  705 */     return TFCBlocks.gravel2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getRockLayerFromHeight(World world, int x, int y, int z) {
/*  710 */     ChunkData cd = getCDM(world).getData(x >> 4, z >> 4);
/*  711 */     if (cd != null) {
/*      */       
/*  713 */       int[] hm = cd.heightmap;
/*  714 */       int localX = x & 0xF;
/*  715 */       int localZ = z & 0xF;
/*  716 */       int localY = localX + localZ * 16;
/*  717 */       if (y <= TFCOptions.rockLayer3Height + hm[localY])
/*  718 */         return 2; 
/*  719 */       if (y <= TFCOptions.rockLayer2Height + hm[localY]) {
/*  720 */         return 1;
/*      */       }
/*  722 */       return 0;
/*      */     } 
/*  724 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean convertGrassToDirt(World world, int i, int j, int k) {
/*  729 */     Block block = world.func_147439_a(i, j, k);
/*  730 */     int meta = world.func_72805_g(i, j, k);
/*  731 */     if (isGrass(block)) {
/*      */       
/*  733 */       if (isGrassType1(block)) {
/*      */         
/*  735 */         world.func_147465_d(i, j, k, TFCBlocks.dirt, meta, 2);
/*  736 */         return true;
/*      */       } 
/*  738 */       if (isGrassType2(block)) {
/*      */         
/*  740 */         world.func_147465_d(i, j, k, TFCBlocks.dirt2, meta, 2);
/*  741 */         return true;
/*      */       } 
/*      */     } 
/*  744 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static EnumFuelMaterial getFuelMaterial(ItemStack is) {
/*  749 */     if (is.func_77973_b() == Item.func_150898_a(TFCBlocks.peat))
/*  750 */       return EnumFuelMaterial.PEAT; 
/*  751 */     if (is.func_77973_b() == TFCItems.coal && is.func_77960_j() == 0)
/*  752 */       return EnumFuelMaterial.COAL; 
/*  753 */     if (is.func_77973_b() == TFCItems.coal && is.func_77960_j() == 1)
/*  754 */       return EnumFuelMaterial.CHARCOAL; 
/*  755 */     if (is.func_77960_j() == 0)
/*  756 */       return EnumFuelMaterial.ASH; 
/*  757 */     if (is.func_77960_j() == 1)
/*  758 */       return EnumFuelMaterial.ASPEN; 
/*  759 */     if (is.func_77960_j() == 2)
/*  760 */       return EnumFuelMaterial.BIRCH; 
/*  761 */     if (is.func_77960_j() == 3)
/*  762 */       return EnumFuelMaterial.CHESTNUT; 
/*  763 */     if (is.func_77960_j() == 4)
/*  764 */       return EnumFuelMaterial.DOUGLASFIR; 
/*  765 */     if (is.func_77960_j() == 5)
/*  766 */       return EnumFuelMaterial.HICKORY; 
/*  767 */     if (is.func_77960_j() == 6)
/*  768 */       return EnumFuelMaterial.MAPLE; 
/*  769 */     if (is.func_77960_j() == 7)
/*  770 */       return EnumFuelMaterial.OAK; 
/*  771 */     if (is.func_77960_j() == 8)
/*  772 */       return EnumFuelMaterial.PINE; 
/*  773 */     if (is.func_77960_j() == 9)
/*  774 */       return EnumFuelMaterial.REDWOOD; 
/*  775 */     if (is.func_77960_j() == 10)
/*  776 */       return EnumFuelMaterial.SPRUCE; 
/*  777 */     if (is.func_77960_j() == 11)
/*  778 */       return EnumFuelMaterial.SYCAMORE; 
/*  779 */     if (is.func_77960_j() == 12)
/*  780 */       return EnumFuelMaterial.WHITECEDAR; 
/*  781 */     if (is.func_77960_j() == 13)
/*  782 */       return EnumFuelMaterial.WHITEELM; 
/*  783 */     if (is.func_77960_j() == 14)
/*  784 */       return EnumFuelMaterial.WILLOW; 
/*  785 */     if (is.func_77960_j() == 15)
/*  786 */       return EnumFuelMaterial.KAPOK; 
/*  787 */     if (is.func_77960_j() == 16)
/*  788 */       return EnumFuelMaterial.ACACIA; 
/*  789 */     return EnumFuelMaterial.ASPEN;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showShiftInformation() {
/*  794 */     return (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && Keyboard.isKeyDown(42));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean showCtrlInformation() {
/*  799 */     return (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && Keyboard.isKeyDown(29));
/*      */   }
/*      */ 
/*      */   
/*      */   public static FoodStatsTFC getPlayerFoodStats(EntityPlayer player) {
/*  804 */     FoodStatsTFC foodstats = new FoodStatsTFC(player);
/*  805 */     foodstats.readNBT(player.getEntityData());
/*  806 */     return foodstats;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setPlayerFoodStats(EntityPlayer player, FoodStatsTFC foodstats) {
/*  811 */     foodstats.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static BodyTempStats getBodyTempStats(EntityPlayer player) {
/*  816 */     BodyTempStats body = new BodyTempStats();
/*  817 */     body.readNBT(player.getEntityData());
/*  818 */     return body;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setBodyTempStats(EntityPlayer player, BodyTempStats tempStats) {
/*  823 */     tempStats.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static SkillStats getSkillStats(EntityPlayer player) {
/*  828 */     SkillStats skills = new SkillStats(player);
/*  829 */     skills.readNBT(player.getEntityData());
/*  830 */     return skills;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setSkillStats(EntityPlayer player, SkillStats skills) {
/*  835 */     skills.writeNBT(player.getEntityData());
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isTopFaceSolid(World world, int x, int y, int z) {
/*  840 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  841 */       return true; 
/*  842 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  844 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  845 */       if (te.topExists())
/*  846 */         return true; 
/*      */     } 
/*  848 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.UP);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBottomFaceSolid(World world, int x, int y, int z) {
/*  853 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  854 */       return true; 
/*  855 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  857 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  858 */       if (te.bottomExists())
/*  859 */         return true; 
/*      */     } 
/*  861 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.DOWN);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isNorthFaceSolid(World world, int x, int y, int z) {
/*  866 */     Block bid = world.func_147439_a(x, y, z);
/*  867 */     if (bid.func_149721_r())
/*  868 */       return true; 
/*  869 */     if (bid == TFCBlocks.metalSheet) {
/*      */       
/*  871 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  872 */       if (te.northExists())
/*  873 */         return true; 
/*      */     } 
/*  875 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.NORTH);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSouthFaceSolid(World world, int x, int y, int z) {
/*  880 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  881 */       return true; 
/*  882 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  884 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  885 */       if (te.southExists())
/*  886 */         return true; 
/*      */     } 
/*  888 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.SOUTH);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isEastFaceSolid(World world, int x, int y, int z) {
/*  893 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  894 */       return true; 
/*  895 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  897 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  898 */       if (te.eastExists())
/*  899 */         return true; 
/*      */     } 
/*  901 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.EAST);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWestFaceSolid(World world, int x, int y, int z) {
/*  906 */     if (world.func_147439_a(x, y, z).func_149721_r())
/*  907 */       return true; 
/*  908 */     if (world.func_147439_a(x, y, z) == TFCBlocks.metalSheet) {
/*      */       
/*  910 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/*  911 */       if (te.westExists())
/*  912 */         return true; 
/*      */     } 
/*  914 */     return world.func_147439_a(x, y, z).isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.WEST);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSurroundedSolid(World world, int x, int y, int z) {
/*  919 */     return (isNorthFaceSolid(world, x, y, z + 1) && 
/*  920 */       isSouthFaceSolid(world, x, y, z - 1) && 
/*  921 */       isEastFaceSolid(world, x - 1, y, z) && 
/*  922 */       isWestFaceSolid(world, x + 1, y, z) && 
/*  923 */       isTopFaceSolid(world, x, y - 1, z));
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isSurroundedStone(World world, int x, int y, int z) {
/*  928 */     return (world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151576_e && world
/*  929 */       .func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151576_e && world
/*  930 */       .func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151576_e && world
/*  931 */       .func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151576_e && world
/*  932 */       .func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151576_e);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isOreIron(ItemStack is) {
/*  937 */     return (is.func_77973_b() instanceof ItemOre && ((ItemOre)is.func_77973_b()).getMetalType(is) == Global.PIGIRON);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getEntityMaxHealth(EntityLivingBase entity) {
/*  942 */     return (float)entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getPercentGrown(IAnimal animal) {
/*  947 */     float birth = animal.getBirthDay();
/*  948 */     float time = TFC_Time.getTotalDays();
/*  949 */     float percent = (time - birth) / animal.getNumberOfDaysToAdult();
/*  950 */     return Math.min(percent, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void bindTexture(ResourceLocation texture) {
/*  955 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isPlayerInDebugMode(EntityPlayer player) {
/*  960 */     return TFCOptions.enableDebugMode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addPlayerExhaustion(EntityPlayer player, float exhaustion) {
/*  968 */     FoodStatsTFC foodstats = getPlayerFoodStats(player);
/*  969 */     foodstats.addFoodExhaustion(exhaustion);
/*      */     
/*  971 */     setPlayerFoodStats(player, foodstats);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getEnvironmentalDecay(float temp) {
/*  976 */     if (temp > 0.0F) {
/*      */       
/*  978 */       float tempFactor = 1.0F - 15.0F / (15.0F + temp);
/*  979 */       return tempFactor * 2.0F;
/*      */     } 
/*      */     
/*  982 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z) {
/*  991 */     handleItemTicking(iinv, world, x, y, z, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(ItemStack[] iinv, World world, int x, int y, int z) {
/* 1000 */     handleItemTicking(iinv, world, x, y, z, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z, float environmentalDecayFactor) {
/* 1009 */     for (int i = 0; !world.field_72995_K && i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1011 */       ItemStack is = iinv.func_70301_a(i);
/* 1012 */       if (is != null && (iinv.func_70301_a(i)).field_77994_a <= 0) {
/* 1013 */         iinv.func_70299_a(i, null);
/*      */       }
/* 1015 */       if (is != null)
/*      */       {
/* 1017 */         if (is.field_77994_a == 0) {
/*      */           
/* 1019 */           iinv.func_70299_a(i, null);
/*      */         
/*      */         }
/* 1022 */         else if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */           
/* 1024 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1026 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, 1.0F);
/* 1027 */             if (is != null)
/* 1028 */               TFC_ItemHeat.handleItemHeat(is); 
/* 1029 */             iinv.func_70299_a(i, is);
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static byte getByteFromSmallFloat(float f) {
/* 1038 */     MathHelper.func_76131_a(f, 0.5F, 1.5F);
/* 1039 */     return (byte)(Float.floatToIntBits(f) >> 16 & 0xFF);
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getSmallFloatFromByte(byte b) {
/* 1044 */     return ByteBuffer.wrap(new byte[] { 63, b, 0, 0 }).getFloat();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void handleItemTicking(IInventory iinv, World world, int x, int y, int z, float environmentalDecayFactor, float baseDecayMod) {
/* 1053 */     for (int i = 0; !world.field_72995_K && i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1055 */       ItemStack is = iinv.func_70301_a(i);
/* 1056 */       if (is != null && (iinv.func_70301_a(i)).field_77994_a <= 0) {
/* 1057 */         iinv.func_70299_a(i, null);
/*      */       }
/* 1059 */       if (is != null)
/*      */       {
/* 1061 */         if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z))
/*      */         {
/* 1063 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1065 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, baseDecayMod);
/* 1066 */             if (is != null)
/* 1067 */               TFC_ItemHeat.handleItemHeat(is); 
/* 1068 */             iinv.func_70299_a(i, is);
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
/* 1079 */     for (int i = 0; !world.field_72995_K && i < iinv.length; i++) {
/*      */       
/* 1081 */       ItemStack is = iinv[i];
/* 1082 */       if (is != null && (iinv[i]).field_77994_a <= 0) {
/* 1083 */         iinv[i] = null;
/*      */       }
/* 1085 */       if (is != null)
/*      */       {
/* 1087 */         if (!(is.func_77973_b() instanceof ItemTerra) || !((ItemTerra)is.func_77973_b()).onUpdate(is, world, x, y, z))
/*      */         {
/* 1089 */           if (!(is.func_77973_b() instanceof ItemTerraBlock) || !((ItemTerraBlock)is.func_77973_b()).onUpdate(is, world, x, y, z)) {
/*      */             
/* 1091 */             is = tickDecay(is, world, x, y, z, environmentalDecayFactor, 1.0F);
/* 1092 */             if (is != null)
/* 1093 */               TFC_ItemHeat.handleItemHeat(is); 
/* 1094 */             iinv[i] = is;
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
/* 1107 */     NBTTagCompound nbt = is.func_77978_p();
/* 1108 */     if (nbt == null || !nbt.func_74764_b("foodWeight") || !nbt.func_74764_b("foodDecay")) {
/* 1109 */       return is;
/*      */     }
/* 1111 */     int decayTimer = Food.getDecayTimer(is);
/*      */     
/* 1113 */     if (decayTimer < TFC_Time.getTotalHours()) {
/*      */       
/* 1115 */       int timeDiff = (int)(TFC_Time.getTotalHours() - decayTimer);
/* 1116 */       float protMult = 1.0F;
/*      */       
/* 1118 */       if (TFCOptions.useDecayProtection)
/*      */       {
/* 1120 */         if (timeDiff > TFCOptions.decayProtectionDays * 24) {
/*      */           
/* 1122 */           decayTimer = (int)TFC_Time.getTotalHours() - 24;
/*      */         }
/* 1124 */         else if (timeDiff > 24) {
/*      */           
/* 1126 */           protMult = (1 - timeDiff / TFCOptions.decayProtectionDays * 24);
/*      */         } 
/*      */       }
/*      */       
/* 1130 */       float decay = Food.getDecay(is);
/* 1131 */       float thisDecayRate = 1.0F;
/*      */       
/* 1133 */       if (is.func_77973_b() instanceof IFood) {
/* 1134 */         thisDecayRate = ((IFood)is.func_77973_b()).getDecayRate(is);
/*      */       } else {
/*      */         
/* 1137 */         thisDecayRate = Food.getDecayRate(is);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1146 */       float temp = getCachedTemp(world, x, y, z, decayTimer);
/* 1147 */       float environmentalDecay = getEnvironmentalDecay(temp) * environmentalDecayFactor;
/*      */       
/* 1149 */       if (decay < 0.0F) {
/*      */         
/* 1151 */         float d = 1.0F * thisDecayRate * baseDecayMod * environmentalDecay;
/* 1152 */         if (decay + d < 0.0F) {
/* 1153 */           decay += d;
/*      */         } else {
/* 1155 */           decay = 0.0F;
/*      */         } 
/* 1157 */       } else if (decay == 0.0F) {
/*      */         
/* 1159 */         decay = Food.getWeight(is) * world.field_73012_v.nextFloat() * 0.005F * TFCOptions.decayMultiplier;
/*      */       }
/*      */       else {
/*      */         
/* 1163 */         double fdr = (TFCOptions.foodDecayRate - 1.0F);
/* 1164 */         fdr *= (thisDecayRate * baseDecayMod * environmentalDecay * protMult * TFCOptions.decayMultiplier);
/* 1165 */         decay = (float)(decay * (1.0D + fdr));
/*      */       } 
/* 1167 */       Food.setDecayTimer(is, decayTimer + 1);
/* 1168 */       Food.setDecay(is, decay);
/*      */     } 
/*      */     
/* 1171 */     if (Food.getDecay(is) / Food.getWeight(is) > 0.9F)
/*      */     {
/* 1173 */       if (is.func_77973_b() instanceof IFood) {
/* 1174 */         is = ((IFood)is.func_77973_b()).onDecayed(is, world, x, y, z);
/*      */       } else {
/* 1176 */         is.field_77994_a = 0;
/*      */       } 
/*      */     }
/* 1179 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static float getCachedTemp(World world, int x, int y, int z, int th) {
/* 1184 */     float cacheTemp = TFC_Climate.getCacheManager(world).getTemp(x, z, th);
/* 1185 */     if (cacheTemp != Float.MIN_VALUE)
/*      */     {
/* 1187 */       return cacheTemp;
/*      */     }
/* 1189 */     float temp = TFC_Climate.getHeightAdjustedTempSpecificDay(world, TFC_Time.getDayFromTotalHours(th), TFC_Time.getHourOfDayFromTotalHours(th), x, y, z);
/* 1190 */     addCachedTemp(world, x, z, th, temp);
/* 1191 */     return temp;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addCachedTemp(World world, int x, int z, int th, float temp) {
/* 1196 */     TFC_Climate.getCacheManager(world).addTemp(x, z, th, temp);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void animalDropMeat(Entity e, Item i, float foodWeight) {
/* 1202 */     ItemStack is = ItemFoodTFC.createTag(new ItemStack(i, 1), foodWeight);
/* 1203 */     Random r = new Random(e.func_110124_au().getLeastSignificantBits() + e.func_110124_au().getMostSignificantBits());
/* 1204 */     Food.adjustFlavor(is, r);
/* 1205 */     e.capturedDrops.add(new EntityItem(e.field_70170_p, e.field_70165_t, e.field_70163_u, e.field_70161_v, is));
/*      */   }
/*      */ 
/*      */   
/*      */   public static Vec3 getEntityPos(Entity e) {
/* 1210 */     return Vec3.func_72443_a(e.field_70165_t, e.field_70163_u, e.field_70161_v);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void giveItemToPlayer(ItemStack is, EntityPlayer player) {
/* 1215 */     if (player.field_70170_p.field_72995_K)
/*      */       return; 
/* 1217 */     EntityItem ei = player.func_70099_a(is, 1.0F);
/* 1218 */     ei.field_145804_b = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isFence(Block b) {
/* 1223 */     return (b == TFCBlocks.fence || b == TFCBlocks.fence2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isVertSupport(Block b) {
/* 1228 */     return (b == TFCBlocks.woodSupportV || b == TFCBlocks.woodSupportV2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isHorizSupport(Block b) {
/* 1233 */     return (b == TFCBlocks.woodSupportH || b == TFCBlocks.woodSupportH2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isOceanicBiome(int id) {
/* 1238 */     return (id == TFCBiome.OCEAN.field_76756_M || id == TFCBiome.DEEP_OCEAN.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isMountainBiome(int id) {
/* 1243 */     return (id == TFCBiome.MOUNTAINS.field_76756_M || id == TFCBiome.MOUNTAINS_EDGE.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isBeachBiome(int id) {
/* 1248 */     return (id == TFCBiome.BEACH.field_76756_M || id == TFCBiome.GRAVEL_BEACH.field_76756_M);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isValidCharcoalPitCover(Block block) {
/* 1253 */     if (Blocks.field_150480_ab.getFlammability(block) > 0 && block != TFCBlocks.logPile) return false;
/*      */     
/* 1255 */     return (block == TFCBlocks.logPile || 
/* 1256 */       isCobbleStone(block) || 
/* 1257 */       isBrickStone(block) || 
/* 1258 */       isSmoothStone(block) || 
/* 1259 */       isGround(block) || block == Blocks.field_150359_w || block == Blocks.field_150399_cn || block == TFCBlocks.metalTrapDoor || block == Blocks.field_150454_av || block
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1264 */       .func_149662_c());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void writeInventoryToNBT(NBTTagCompound nbt, ItemStack[] storage) {
/* 1269 */     writeInventoryToNBT(nbt, storage, "Items");
/*      */   }
/*      */ 
/*      */   
/*      */   public static void writeInventoryToNBT(NBTTagCompound nbt, ItemStack[] storage, String name) {
/* 1274 */     NBTTagList nbttaglist = new NBTTagList();
/* 1275 */     for (int i = 0; i < storage.length; i++) {
/*      */       
/* 1277 */       if (storage[i] != null) {
/*      */         
/* 1279 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 1280 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 1281 */         storage[i].func_77955_b(nbttagcompound1);
/* 1282 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*      */       } 
/*      */     } 
/* 1285 */     nbt.func_74782_a(name, (NBTBase)nbttaglist);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void readInventoryFromNBT(NBTTagCompound nbt, ItemStack[] storage) {
/* 1290 */     readInventoryFromNBT(nbt, storage, "Items");
/*      */   }
/*      */ 
/*      */   
/*      */   public static void readInventoryFromNBT(NBTTagCompound nbt, ItemStack[] storage, String name) {
/* 1295 */     NBTTagList nbttaglist = nbt.func_150295_c(name, 10);
/* 1296 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*      */       
/* 1298 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 1299 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 1300 */       if (byte0 >= 0 && byte0 < storage.length) {
/* 1301 */         storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public static ItemStack getItemInInventory(Item item, IInventory iinv) {
/* 1307 */     for (int i = 0; i < iinv.func_70302_i_(); i++) {
/*      */       
/* 1309 */       iinv.func_70301_a(i);
/* 1310 */       if (iinv.func_70301_a(i) != null && iinv.func_70301_a(i).func_77973_b() == item)
/*      */       {
/* 1312 */         return iinv.func_70301_a(i);
/*      */       }
/*      */     } 
/* 1315 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void destroyBlock(World world, int x, int y, int z) {
/* 1320 */     if (world.func_147439_a(x, y, z) != Blocks.field_150350_a) {
/*      */       
/* 1322 */       world.func_147439_a(x, y, z).func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 1323 */       world.func_147468_f(x, y, z);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean areItemsEqual(ItemStack is1, ItemStack is2) {
/* 1329 */     Item i1 = null; int d1 = 0;
/* 1330 */     Item i2 = null; int d2 = 0;
/* 1331 */     if (is1 != null) {
/*      */       
/* 1333 */       i1 = is1.func_77973_b(); d1 = is1.func_77960_j();
/*      */     } 
/* 1335 */     if (is2 != null) {
/*      */       
/* 1337 */       i2 = is2.func_77973_b(); d2 = is2.func_77960_j();
/*      */     } 
/* 1339 */     return (i1 == i2 && d1 == d2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean setBlockWithDrops(World world, int x, int y, int z, Block b, int meta) {
/* 1344 */     Block block = world.func_147439_a(x, y, z);
/*      */     
/* 1346 */     if (block.func_149688_o() != Material.field_151579_a) {
/*      */       
/* 1348 */       int l = world.func_72805_g(x, y, z);
/* 1349 */       world.func_72926_e(2001, x, y, z, Block.func_149682_b(block) + (l << 12));
/* 1350 */       block.func_149697_b(world, x, y, z, l, 0);
/*      */     } 
/* 1352 */     return world.func_147465_d(x, y, z, b, meta, 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean setBlockToAirWithDrops(World world, int x, int y, int z) {
/* 1360 */     return world.func_147480_a(x, y, z, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWaterBiome(BiomeGenBase b) {
/* 1365 */     return (isBeachBiome(b.field_76756_M) || isOceanicBiome(b.field_76756_M) || b == TFCBiome.LAKE || b == TFCBiome.RIVER);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String translate(String s) {
/* 1370 */     return StatCollector.func_74838_a(s);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void sendInfoMessage(EntityPlayer player, IChatComponent text) {
/* 1375 */     text.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
/* 1376 */     player.func_146105_b(text);
/*      */   }
/*      */ 
/*      */   
/*      */   public static long getSuperSeed(World w) {
/* 1381 */     return w.func_72905_C() + w.func_72912_H().func_76066_a().func_74763_f("superseed");
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isExposedToRain(World world, int x, int y, int z) {
/* 1386 */     int highestY = world.func_72874_g(x, z) - 1;
/* 1387 */     boolean isExposed = true;
/* 1388 */     if (world.func_72937_j(x, y + 1, z)) {
/*      */ 
/*      */       
/* 1391 */       if (world.func_147439_a(x, highestY, z) instanceof net.minecraft.block.BlockGlass || world
/* 1392 */         .func_147439_a(x, highestY, z) instanceof net.minecraft.block.BlockStainedGlass || world
/* 1393 */         .isSideSolid(x, highestY, z, ForgeDirection.UP) || world
/* 1394 */         .isSideSolid(x, highestY, z, ForgeDirection.DOWN)) {
/* 1395 */         isExposed = false;
/*      */       }
/*      */     } else {
/* 1398 */       isExposed = false;
/*      */     } 
/* 1400 */     return (world.func_72896_J() && isExposed);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_Core.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */