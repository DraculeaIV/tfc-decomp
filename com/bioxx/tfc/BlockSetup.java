/*     */ package com.bioxx.tfc;
/*     */ import com.bioxx.tfc.Blocks.BlockFarmland;
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockAnvil;
/*     */ import com.bioxx.tfc.Blocks.Flora.BlockFruitLeaves;
/*     */ import com.bioxx.tfc.Blocks.Liquids.BlockLiquidStatic;
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockDryGrass;
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockGravel;
/*     */ import com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWood;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemCustomWood2;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemSoil;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemStone;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemWoodSupport2;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ 
/*     */ public class BlockSetup extends TFCBlocks {
/*     */   public static void registerBlocks() {
/*  25 */     GameRegistry.registerBlock(ore, "Ore1");
/*  26 */     GameRegistry.registerBlock(ore2, "Ore2");
/*  27 */     GameRegistry.registerBlock(ore3, "Ore3");
/*  28 */     GameRegistry.registerBlock(stoneIgIn, ItemStone.class, "StoneIgIn");
/*  29 */     GameRegistry.registerBlock(stoneIgEx, ItemStone.class, "StoneIgEx");
/*  30 */     GameRegistry.registerBlock(stoneSed, ItemStone.class, "StoneSed");
/*  31 */     GameRegistry.registerBlock(stoneMM, ItemStone.class, "StoneMM");
/*     */     
/*  33 */     GameRegistry.registerBlock(stoneIgInCobble, ItemStone.class, "StoneIgInCobble");
/*  34 */     GameRegistry.registerBlock(stoneIgExCobble, ItemStone.class, "StoneIgExCobble");
/*  35 */     GameRegistry.registerBlock(stoneSedCobble, ItemStone.class, "StoneSedCobble");
/*  36 */     GameRegistry.registerBlock(stoneMMCobble, ItemStone.class, "StoneMMCobble");
/*  37 */     GameRegistry.registerBlock(stoneIgInSmooth, ItemStone.class, "StoneIgInSmooth");
/*  38 */     GameRegistry.registerBlock(stoneIgExSmooth, ItemStone.class, "StoneIgExSmooth");
/*  39 */     GameRegistry.registerBlock(stoneSedSmooth, ItemStone.class, "StoneSedSmooth");
/*  40 */     GameRegistry.registerBlock(stoneMMSmooth, ItemStone.class, "StoneMMSmooth");
/*  41 */     GameRegistry.registerBlock(stoneIgInBrick, ItemStone.class, "StoneIgInBrick");
/*  42 */     GameRegistry.registerBlock(stoneIgExBrick, ItemStone.class, "StoneIgExBrick");
/*  43 */     GameRegistry.registerBlock(stoneSedBrick, ItemStone.class, "StoneSedBrick");
/*  44 */     GameRegistry.registerBlock(stoneMMBrick, ItemStone.class, "StoneMMBrick");
/*     */     
/*  46 */     GameRegistry.registerBlock(dirt, ItemSoil.class, "Dirt");
/*  47 */     GameRegistry.registerBlock(dirt2, ItemSoil.class, "Dirt2");
/*  48 */     GameRegistry.registerBlock(sand, ItemSoil.class, "Sand");
/*  49 */     GameRegistry.registerBlock(sand2, ItemSoil.class, "Sand2");
/*  50 */     GameRegistry.registerBlock(clay, ItemSoil.class, "Clay");
/*  51 */     GameRegistry.registerBlock(clay2, ItemSoil.class, "Clay2");
/*  52 */     GameRegistry.registerBlock(grass, ItemSoil.class, "Grass");
/*  53 */     GameRegistry.registerBlock(grass2, ItemSoil.class, "Grass2");
/*  54 */     GameRegistry.registerBlock(clayGrass, ItemSoil.class, "ClayGrass");
/*  55 */     GameRegistry.registerBlock(clayGrass2, ItemSoil.class, "ClayGrass2");
/*  56 */     GameRegistry.registerBlock(peatGrass, ItemSoil.class, "PeatGrass");
/*  57 */     GameRegistry.registerBlock(peat, ItemSoil.class, "Peat");
/*  58 */     GameRegistry.registerBlock(dryGrass, ItemSoil.class, "DryGrass");
/*  59 */     GameRegistry.registerBlock(dryGrass2, ItemSoil.class, "DryGrass2");
/*  60 */     GameRegistry.registerBlock(tallGrass, ItemCustomTallGrass.class, "TallGrass");
/*  61 */     GameRegistry.registerBlock(worldItem, "LooseRock");
/*  62 */     GameRegistry.registerBlock(logPile, "LogPile");
/*  63 */     GameRegistry.registerBlock(charcoal, "Charcoal");
/*  64 */     GameRegistry.registerBlock(detailed, "Detailed");
/*     */     
/*  66 */     GameRegistry.registerBlock(tilledSoil, ItemSoil.class, "tilledSoil");
/*  67 */     GameRegistry.registerBlock(tilledSoil2, ItemSoil.class, "tilledSoil2");
/*     */     
/*  69 */     GameRegistry.registerBlock(woodSupportV, ItemWoodSupport.class, "WoodSupportV");
/*  70 */     GameRegistry.registerBlock(woodSupportH, ItemWoodSupport.class, "WoodSupportH");
/*  71 */     GameRegistry.registerBlock(woodSupportV2, ItemWoodSupport2.class, "WoodSupportV2");
/*  72 */     GameRegistry.registerBlock(woodSupportH2, ItemWoodSupport2.class, "WoodSupportH2");
/*  73 */     GameRegistry.registerBlock(sulfur, "Sulfur");
/*  74 */     GameRegistry.registerBlock(logNatural, ItemCustomWood.class, "log");
/*  75 */     GameRegistry.registerBlock(logNatural2, ItemCustomWood2.class, "log2");
/*  76 */     GameRegistry.registerBlock(leaves, ItemCustomWood.class, "leaves");
/*  77 */     GameRegistry.registerBlock(leaves2, ItemCustomWood2.class, "leaves2");
/*  78 */     GameRegistry.registerBlock(sapling, ItemSapling.class, "sapling");
/*  79 */     GameRegistry.registerBlock(sapling2, ItemSapling2.class, "sapling2");
/*  80 */     GameRegistry.registerBlock(planks, ItemCustomWood.class, "planks");
/*  81 */     GameRegistry.registerBlock(planks2, ItemCustomWood2.class, "planks2");
/*     */     
/*  83 */     GameRegistry.registerBlock(firepit, "Firepit");
/*  84 */     GameRegistry.registerBlock(bellows, ItemBellows.class, "Bellows");
/*  85 */     GameRegistry.registerBlock(anvil, ItemAnvil1.class, "Anvil");
/*  86 */     GameRegistry.registerBlock(anvil2, ItemAnvil2.class, "Anvil2");
/*  87 */     GameRegistry.registerBlock(forge, "Forge");
/*     */     
/*  89 */     GameRegistry.registerBlock(molten, "Molten");
/*  90 */     GameRegistry.registerBlock(blastFurnace, ItemTerraBlock.class, "Bloomery");
/*  91 */     GameRegistry.registerBlock(bloomery, ItemTerraBlock.class, "EarlyBloomery");
/*  92 */     GameRegistry.registerBlock(sluice, "Sluice");
/*  93 */     GameRegistry.registerBlock(bloom, "Bloom");
/*     */     
/*  95 */     GameRegistry.registerBlock(fruitTreeWood, "fruitTreeWood");
/*  96 */     GameRegistry.registerBlock(fruitTreeLeaves, "fruitTreeLeaves");
/*  97 */     GameRegistry.registerBlock(fruitTreeLeaves2, "fruitTreeLeaves2");
/*     */     
/*  99 */     GameRegistry.registerBlock(stoneStairs, "stoneStairs");
/* 100 */     GameRegistry.registerBlock(stoneSlabs, "stoneSlabs");
/* 101 */     GameRegistry.registerBlock(stoneStalac, "stoneStalac");
/*     */     
/* 103 */     GameRegistry.registerBlock(woodConstruct, "WoodConstruct");
/* 104 */     GameRegistry.registerBlock(woodVert, ItemCustomWood.class, "WoodVert");
/* 105 */     GameRegistry.registerBlock(woodVert2, ItemCustomWood2.class, "WoodVert2");
/* 106 */     GameRegistry.registerBlock(woodHoriz, ItemCustomWoodH.class, "WoodHoriz");
/* 107 */     GameRegistry.registerBlock(woodHoriz2, ItemCustomWoodH2.class, "WoodHoriz2");
/* 108 */     GameRegistry.registerBlock(woodHoriz3, ItemCustomWoodH3.class, "WoodHoriz3");
/* 109 */     GameRegistry.registerBlock(woodHoriz4, "WoodHoriz4");
/*     */     
/* 111 */     GameRegistry.registerBlock(toolRack, ItemToolRack.class, "ToolRack");
/* 112 */     GameRegistry.registerBlock(spawnMeter, ItemTerraBlock.class, "SpawnMeter");
/* 113 */     GameRegistry.registerBlock(foodPrep, "FoodPrep");
/* 114 */     GameRegistry.registerBlock(quern, ItemTerraBlock.class, "Quern");
/* 115 */     GameRegistry.registerBlock(wallCobbleIgIn, ItemStone.class, "WallCobbleIgIn");
/* 116 */     GameRegistry.registerBlock(wallCobbleIgEx, ItemStone.class, "WallCobbleIgEx");
/* 117 */     GameRegistry.registerBlock(wallCobbleSed, ItemStone.class, "WallCobbleSed");
/* 118 */     GameRegistry.registerBlock(wallCobbleMM, ItemStone.class, "WallCobbleMM");
/* 119 */     GameRegistry.registerBlock(wallRawIgIn, ItemStone.class, "WallRawIgIn");
/* 120 */     GameRegistry.registerBlock(wallRawIgEx, ItemStone.class, "WallRawIgEx");
/* 121 */     GameRegistry.registerBlock(wallRawSed, ItemStone.class, "WallRawSed");
/* 122 */     GameRegistry.registerBlock(wallRawMM, ItemStone.class, "WallRawMM");
/* 123 */     GameRegistry.registerBlock(wallBrickIgIn, ItemStone.class, "WallBrickIgIn");
/* 124 */     GameRegistry.registerBlock(wallBrickIgEx, ItemStone.class, "WallBrickIgEx");
/* 125 */     GameRegistry.registerBlock(wallBrickSed, ItemStone.class, "WallBrickSed");
/* 126 */     GameRegistry.registerBlock(wallBrickMM, ItemStone.class, "WallBrickMM");
/* 127 */     GameRegistry.registerBlock(wallSmoothIgIn, ItemStone.class, "WallSmoothIgIn");
/* 128 */     GameRegistry.registerBlock(wallSmoothIgEx, ItemStone.class, "WallSmoothIgEx");
/* 129 */     GameRegistry.registerBlock(wallSmoothSed, ItemStone.class, "WallSmoothSed");
/* 130 */     GameRegistry.registerBlock(wallSmoothMM, ItemStone.class, "WallSmoothMM");
/*     */     
/* 132 */     GameRegistry.registerBlock(saltWater, "SaltWater");
/* 133 */     GameRegistry.registerBlock(saltWaterStationary, "SaltWaterStationary");
/* 134 */     GameRegistry.registerBlock(freshWater, "FreshWater");
/* 135 */     GameRegistry.registerBlock(freshWaterStationary, "FreshWaterStationary");
/* 136 */     GameRegistry.registerBlock(hotWater, "HotWater");
/* 137 */     GameRegistry.registerBlock(hotWaterStationary, "HotWaterStationary");
/* 138 */     GameRegistry.registerBlock(lava, "Lava");
/* 139 */     GameRegistry.registerBlock(lavaStationary, "LavaStationary");
/* 140 */     GameRegistry.registerBlock(ice, "Ice");
/*     */     
/* 142 */     GameRegistry.registerBlock(waterPlant, "SeaGrassStill");
/*     */     
/* 144 */     GameRegistry.registerBlock(fireBrick, "FireBrick");
/* 145 */     GameRegistry.registerBlock(metalSheet, "MetalSheet");
/* 146 */     GameRegistry.registerBlock(metalBlock, ItemMetalBlock1.class, "MetalBlock");
/* 147 */     GameRegistry.registerBlock(metalBlock2, ItemMetalBlock2.class, "MetalBlock2");
/*     */ 
/*     */ 
/*     */     
/* 151 */     for (int i = 0; i < Global.WOOD_ALL.length; i++) {
/* 152 */       GameRegistry.registerBlock(doors[i], "Door" + Global.WOOD_ALL[i].replaceAll(" ", ""));
/*     */     }
/* 154 */     GameRegistry.registerBlock(ingotPile, "IngotPile");
/* 155 */     GameRegistry.registerBlock(barrel, ItemBarrels.class, "Barrel");
/* 156 */     GameRegistry.registerBlock(loom, ItemLooms.class, "Loom");
/* 157 */     GameRegistry.registerBlock(moss, "Moss");
/*     */     
/* 159 */     GameRegistry.registerBlock(flora, ItemFlora.class, "Flora");
/* 160 */     GameRegistry.registerBlock(pottery, "ClayPottery");
/* 161 */     GameRegistry.registerBlock(thatch, ItemTerraBlock.class, "Thatch");
/* 162 */     GameRegistry.registerBlock(crucible, ItemCrucible.class, "Crucible");
/* 163 */     GameRegistry.registerBlock(nestBox, ItemTerraBlock.class, "NestBox");
/* 164 */     GameRegistry.registerBlock(fence, ItemFence.class, "Fence");
/* 165 */     GameRegistry.registerBlock(fence2, ItemFence2.class, "Fence2");
/* 166 */     GameRegistry.registerBlock(fenceGate, ItemFenceGate.class, "FenceGate");
/* 167 */     GameRegistry.registerBlock(fenceGate2, ItemFenceGate2.class, "FenceGate2");
/* 168 */     GameRegistry.registerBlock(strawHideBed, "StrawHideBed");
/* 169 */     GameRegistry.registerBlock(armorStand, ItemArmourStand.class, "ArmourStand");
/* 170 */     GameRegistry.registerBlock(armorStand2, ItemArmourStand2.class, "ArmourStand2");
/* 171 */     GameRegistry.registerBlock(berryBush, ItemBerryBush.class, "BerryBush");
/* 172 */     GameRegistry.registerBlock(crops, "Crops");
/* 173 */     GameRegistry.registerBlock(lilyPad, ItemCustomLilyPad.class, "LilyPad");
/* 174 */     GameRegistry.registerBlock(flowers, ItemFlowers.class, "Flowers");
/* 175 */     GameRegistry.registerBlock(flowers2, ItemFlowers2.class, "Flowers2");
/* 176 */     GameRegistry.registerBlock(fungi, ItemFungi.class, "Fungi");
/* 177 */     GameRegistry.registerBlock(bookshelf, ItemTerraBlock.class, "Bookshelf");
/* 178 */     GameRegistry.registerBlock(torch, ItemTorch.class, "Torch");
/* 179 */     GameRegistry.registerBlock(torchOff, "TorchOff");
/* 180 */     GameRegistry.registerBlock(chest, ItemChest.class, "Chest TFC");
/* 181 */     GameRegistry.registerBlock(workbench, ItemTerraBlock.class, "Workbench");
/* 182 */     GameRegistry.registerBlock(cactus, ItemTerraBlock.class, "Cactus");
/* 183 */     GameRegistry.registerBlock(reeds, "Reeds");
/* 184 */     GameRegistry.registerBlock(pumpkin, ItemTerraBlock.class, "Pumpkin");
/* 185 */     GameRegistry.registerBlock(litPumpkin, ItemTerraBlock.class, "LitPumpkin");
/* 186 */     GameRegistry.registerBlock(buttonWood, "ButtonWood");
/* 187 */     GameRegistry.registerBlock(vine, ItemVine.class, "Vine");
/* 188 */     GameRegistry.registerBlock(leatherRack, "LeatherRack");
/* 189 */     GameRegistry.registerBlock(gravel, ItemSoil.class, "Gravel");
/* 190 */     GameRegistry.registerBlock(gravel2, ItemSoil.class, "Gravel2");
/*     */     
/* 192 */     GameRegistry.registerBlock(grill, ItemGrill.class, "Grill");
/* 193 */     GameRegistry.registerBlock(metalTrapDoor, ItemMetalTrapDoor.class, "MetalTrapDoor");
/* 194 */     GameRegistry.registerBlock(vessel, ItemLargeVessel.class, "Vessel");
/* 195 */     GameRegistry.registerBlock(smoke, "Smoke");
/* 196 */     GameRegistry.registerBlock(smokeRack, "SmokeRack");
/* 197 */     GameRegistry.registerBlock(snow, "Snow");
/* 198 */     GameRegistry.registerBlock(oilLamp, ItemOilLamp.class, "OilLamp");
/* 199 */     GameRegistry.registerBlock(hopper, "Hopper");
/* 200 */     GameRegistry.registerBlock(flowerPot, "FlowerPot");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadBlocks() {
/* 205 */     TerraFirmaCraft.LOG.info("Loading Blocks");
/*     */ 
/*     */     
/* 208 */     Blocks.field_150373_bw.func_149647_a(null);
/* 209 */     Blocks.field_150376_bx.func_149647_a(null);
/* 210 */     Blocks.field_150485_bF.func_149647_a(null);
/* 211 */     Blocks.field_150487_bG.func_149647_a(null);
/* 212 */     Blocks.field_150481_bH.func_149647_a(null);
/* 213 */     Blocks.field_150392_bi.func_149647_a(null);
/* 214 */     Blocks.field_150329_H.func_149647_a(null);
/* 215 */     Blocks.field_150327_N.func_149647_a(null);
/* 216 */     Blocks.field_150328_O.func_149647_a(null);
/* 217 */     Blocks.field_150338_P.func_149647_a(null);
/* 218 */     Blocks.field_150337_Q.func_149647_a(null);
/* 219 */     Blocks.field_150342_X.func_149647_a(null);
/* 220 */     Blocks.field_150478_aa.func_149647_a(null);
/* 221 */     Blocks.field_150486_ae.func_149647_a(null);
/* 222 */     Blocks.field_150344_f.func_149647_a(null);
/* 223 */     Blocks.field_150462_ai.func_149647_a(null);
/* 224 */     Blocks.field_150434_aF.func_149647_a(null);
/* 225 */     Blocks.field_150436_aH.func_149647_a(null);
/* 226 */     Blocks.field_150423_aK.func_149647_a(null);
/* 227 */     Blocks.field_150428_aP.func_149647_a(null);
/* 228 */     Blocks.field_150471_bO.func_149647_a(null);
/* 229 */     Blocks.field_150432_aD.func_149647_a(null);
/* 230 */     Blocks.field_150395_bd.func_149647_a(null);
/* 231 */     Blocks.field_150457_bL.func_149647_a(null);
/*     */     
/* 233 */     bookshelf = (new BlockCustomBookshelf()).func_149711_c(1.5F).func_149672_a(Block.field_149766_f).func_149663_c("Bookshelf").func_149658_d("bookshelf");
/* 234 */     torch = (new BlockTorch()).func_149711_c(0.0F).func_149672_a(Block.field_149766_f).func_149663_c("Torch").func_149658_d("torch_on");
/* 235 */     torchOff = (new BlockTorchOff()).func_149711_c(0.0F).func_149672_a(Block.field_149766_f).func_149663_c("TorchOff").func_149658_d("torch_on");
/* 236 */     chest = (new BlockChestTFC()).func_149711_c(2.5F).func_149672_a(Block.field_149766_f).func_149663_c("Chest");
/* 237 */     workbench = (new BlockWorkbench()).func_149711_c(2.5F).func_149672_a(Block.field_149766_f).func_149663_c("Workbench").func_149658_d("crafting_table");
/* 238 */     cactus = (new BlockCustomCactus()).func_149711_c(0.4F).func_149672_a(Block.field_149775_l).func_149663_c("Cactus").func_149658_d("cactus");
/* 239 */     reeds = (new BlockCustomReed()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("Reeds").func_149658_d("reeds");
/* 240 */     pumpkin = (new BlockCustomPumpkin(false)).func_149711_c(1.0F).func_149672_a(Block.field_149766_f).func_149663_c("Pumpkin").func_149658_d("pumpkin");
/* 241 */     litPumpkin = (new BlockCustomPumpkin(true)).func_149711_c(1.0F).func_149672_a(Block.field_149766_f).func_149715_a(1.0F).func_149663_c("LitPumpkin").func_149658_d("pumpkin");
/* 242 */     buttonWood = (new BlockCustomButtonWood()).func_149711_c(0.5F).func_149672_a(Block.field_149766_f).func_149663_c("ButtonWood");
/* 243 */     vine = (new BlockCustomVine()).func_149711_c(0.2F).func_149672_a(Block.field_149779_h).func_149663_c("Vine").func_149658_d("vine");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 251 */     snow = (new BlockCustomSnow()).func_149711_c(0.1F).func_149672_a(Block.field_149773_n).func_149663_c("snow").func_149713_g(0).func_149658_d("snow");
/* 252 */     Blocks.field_150431_aC = snow;
/* 253 */     stoneIgInCobble = (new BlockIgInCobble(Material.field_151576_e)).func_149711_c(16.0F).func_149663_c("IgInRockCobble");
/* 254 */     stoneIgIn = (new BlockIgIn(Material.field_151576_e)).func_149711_c(8.0F).func_149663_c("IgInRock");
/* 255 */     stoneIgInSmooth = (new BlockIgInSmooth()).func_149711_c(16.0F).func_149663_c("IgInRockSmooth");
/* 256 */     stoneIgInBrick = (new BlockIgInBrick()).func_149711_c(16.0F).func_149663_c("IgInRockBrick");
/*     */     
/* 258 */     stoneSedCobble = (new BlockSedCobble(Material.field_151576_e)).func_149711_c(14.0F).func_149663_c("SedRockCobble");
/* 259 */     stoneSed = (new BlockSed(Material.field_151576_e)).func_149711_c(7.0F).func_149663_c("SedRock");
/* 260 */     stoneSedSmooth = (new BlockSedSmooth()).func_149711_c(14.0F).func_149663_c("SedRockSmooth");
/* 261 */     stoneSedBrick = (new BlockSedBrick()).func_149711_c(14.0F).func_149663_c("SedRockBrick");
/*     */     
/* 263 */     stoneIgExCobble = (new BlockIgExCobble(Material.field_151576_e)).func_149711_c(16.0F).func_149663_c("IgExRockCobble");
/* 264 */     stoneIgEx = (new BlockIgEx(Material.field_151576_e)).func_149711_c(8.0F).func_149663_c("IgExRock");
/* 265 */     stoneIgExSmooth = (new BlockIgExSmooth()).func_149711_c(16.0F).func_149663_c("IgExRockSmooth");
/* 266 */     stoneIgExBrick = (new BlockIgExBrick()).func_149711_c(16.0F).func_149663_c("IgExRockBrick");
/*     */     
/* 268 */     stoneMMCobble = (new BlockMMCobble(Material.field_151576_e)).func_149711_c(15.0F).func_149663_c("MMRockCobble");
/* 269 */     stoneMM = (new BlockMM(Material.field_151576_e)).func_149711_c(8.0F).func_149663_c("MMRock");
/* 270 */     stoneMMSmooth = (new BlockMMSmooth()).func_149711_c(15.0F).func_149663_c("MMRockSmooth");
/* 271 */     stoneMMBrick = (new BlockMMBrick()).func_149711_c(15.0F).func_149663_c("MMRockBrick");
/*     */     
/* 273 */     dirt = (new BlockDirt(0)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("dirt");
/*     */     
/* 275 */     dirt2 = (new BlockDirt(16)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("dirt");
/* 276 */     clay = (new BlockClay(0)).func_149711_c(3.0F).func_149672_a(Block.field_149767_g).func_149663_c("clay");
/* 277 */     clay2 = (new BlockClay(16)).func_149711_c(3.0F).func_149672_a(Block.field_149767_g).func_149663_c("clay");
/* 278 */     clayGrass = (new BlockClayGrass(0)).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("ClayGrass");
/* 279 */     clayGrass2 = (new BlockClayGrass(16)).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("ClayGrass");
/* 280 */     grass = (new BlockGrass()).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("Grass");
/* 281 */     grass2 = (new BlockGrass(16)).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("Grass");
/* 282 */     peat = (new BlockPeat()).func_149711_c(3.0F).func_149672_a(Block.field_149767_g).func_149663_c("Peat");
/* 283 */     peatGrass = (new BlockPeatGrass()).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("PeatGrass");
/* 284 */     dryGrass = (new BlockDryGrass(0)).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("DryGrass");
/* 285 */     dryGrass2 = (new BlockDryGrass(16)).func_149711_c(3.0F).func_149672_a(Block.field_149779_h).func_149663_c("DryGrass");
/* 286 */     tallGrass = (new BlockCustomTallGrass()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("TallGrass");
/* 287 */     sand = (new BlockSand(0)).func_149711_c(0.5F).func_149672_a(Block.field_149776_m).func_149663_c("sand");
/* 288 */     sand2 = (new BlockSand(16)).func_149711_c(0.5F).func_149672_a(Block.field_149776_m).func_149663_c("sand");
/*     */     
/* 290 */     ore = (new BlockOre(Material.field_151576_e)).func_149711_c(10.0F).func_149752_b(10.0F).func_149663_c("Ore");
/* 291 */     ore2 = (new BlockOre2(Material.field_151576_e)).func_149711_c(10.0F).func_149752_b(10.0F).func_149663_c("Ore");
/* 292 */     ore3 = (new BlockOre3(Material.field_151576_e)).func_149711_c(10.0F).func_149752_b(10.0F).func_149663_c("Ore");
/* 293 */     worldItem = (new BlockWorldItem()).func_149711_c(0.05F).func_149752_b(1.0F).func_149663_c("LooseRock");
/* 294 */     sulfur = (new BlockSulfur(Material.field_151576_e)).func_149663_c("Sulfur").func_149711_c(0.5F).func_149752_b(1.0F);
/*     */     
/* 296 */     logPile = (new BlockLogPile()).func_149711_c(10.0F).func_149752_b(1.0F).func_149663_c("LogPile");
/* 297 */     woodSupportV = (new BlockWoodSupport(Material.field_151575_d)).func_149663_c("WoodSupportV").func_149711_c(0.5F).func_149752_b(1.0F);
/* 298 */     woodSupportH = (new BlockWoodSupport(Material.field_151575_d)).func_149663_c("WoodSupportH").func_149711_c(0.5F).func_149752_b(1.0F);
/* 299 */     woodSupportV2 = (new BlockWoodSupport2(Material.field_151575_d)).func_149663_c("WoodSupportV2").func_149711_c(0.5F).func_149752_b(1.0F);
/* 300 */     woodSupportH2 = (new BlockWoodSupport2(Material.field_151575_d)).func_149663_c("WoodSupportH2").func_149711_c(0.5F).func_149752_b(1.0F);
/*     */     
/* 302 */     tilledSoil = (new BlockFarmland(TFCBlocks.dirt, 0)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("tilledSoil");
/* 303 */     tilledSoil2 = (new BlockFarmland(TFCBlocks.dirt2, 16)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("tilledSoil");
/*     */     
/* 305 */     fruitTreeWood = (new BlockFruitWood()).func_149663_c("fruitTreeWood").func_149711_c(5.5F).func_149752_b(2.0F);
/* 306 */     fruitTreeLeaves = (new BlockFruitLeaves(0)).func_149663_c("fruitTreeLeaves").func_149711_c(0.5F).func_149752_b(1.0F).func_149672_a(Block.field_149779_h);
/* 307 */     fruitTreeLeaves2 = (new BlockFruitLeaves(8)).func_149663_c("fruitTreeLeaves2").func_149711_c(0.5F).func_149752_b(1.0F).func_149672_a(Block.field_149779_h);
/*     */     
/* 309 */     woodConstruct = (new BlockWoodConstruct()).func_149711_c(4.0F).func_149672_a(Block.field_149766_f).func_149663_c("WoodConstruct");
/*     */     
/* 311 */     firepit = (new BlockFirepit()).func_149663_c("Firepit").func_149711_c(1.0F).func_149715_a(0.0F);
/* 312 */     bellows = (new BlockBellows(Material.field_151575_d)).func_149663_c("Bellows").func_149711_c(2.0F);
/* 313 */     forge = (new BlockForge()).func_149663_c("Forge").func_149711_c(20.0F).func_149715_a(0.0F);
/* 314 */     anvil = (new BlockAnvil()).func_149663_c("Anvil").func_149711_c(3.0F).func_149752_b(100.0F);
/* 315 */     anvil2 = (new BlockAnvil(8)).func_149663_c("Anvil2").func_149711_c(3.0F).func_149752_b(100.0F);
/*     */     
/* 317 */     molten = (new BlockMolten()).func_149663_c("Molten").func_149711_c(20.0F);
/* 318 */     blastFurnace = (new BlockBlastFurnace()).func_149663_c("BlastFurnace").func_149711_c(20.0F).func_149715_a(0.0F);
/* 319 */     bloomery = (new BlockEarlyBloomery()).func_149663_c("EarlyBloomery").func_149711_c(20.0F).func_149715_a(0.0F);
/* 320 */     bloom = (new BlockBloom()).func_149663_c("Bloom").func_149711_c(20.0F).func_149715_a(0.0F);
/* 321 */     sluice = (new BlockSluice()).func_149663_c("Sluice").func_149711_c(2.0F).func_149752_b(20.0F);
/*     */     
/* 323 */     stoneStairs = (new BlockStair(Material.field_151576_e)).func_149663_c("stoneStairs").func_149711_c(10.0F);
/* 324 */     stoneSlabs = (new BlockSlab()).func_149663_c("stoneSlabs").func_149711_c(10.0F);
/* 325 */     stoneStalac = (new BlockStalactite()).func_149663_c("stoneStalac").func_149711_c(5.0F);
/*     */     
/* 327 */     charcoal = (new BlockCharcoal()).func_149711_c(3.0F).func_149752_b(10.0F).func_149663_c("Charcoal");
/*     */     
/* 329 */     detailed = (new BlockDetailed()).func_149663_c("StoneDetailed").func_149711_c(10.0F);
/*     */     
/* 331 */     planks = (new BlockPlanks(Material.field_151575_d)).func_149711_c(4.0F).func_149752_b(5.0F).func_149672_a(Block.field_149766_f).func_149663_c("wood");
/* 332 */     planks2 = (new BlockPlanks2(Material.field_151575_d)).func_149711_c(4.0F).func_149752_b(5.0F).func_149672_a(Block.field_149766_f).func_149663_c("wood2");
/* 333 */     leaves = (new BlockCustomLeaves()).func_149711_c(0.2F).func_149713_g(1).func_149672_a(Block.field_149779_h).func_149663_c("leaves").func_149647_a(TFCTabs.TFC_DECORATION);
/* 334 */     leaves2 = (new BlockCustomLeaves2()).func_149711_c(0.2F).func_149713_g(1).func_149672_a(Block.field_149779_h).func_149663_c("leaves2");
/* 335 */     sapling = (new BlockSapling()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("sapling");
/* 336 */     sapling2 = (new BlockSapling2()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("sapling2");
/*     */     
/* 338 */     logNatural = (new BlockLogNatural()).func_149711_c(50.0F).func_149672_a(Block.field_149766_f).func_149663_c("log");
/* 339 */     logNatural2 = (new BlockLogNatural2()).func_149711_c(50.0F).func_149672_a(Block.field_149766_f).func_149663_c("log2");
/* 340 */     woodVert = (new BlockLogVert()).func_149663_c("WoodVert").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/* 341 */     woodVert2 = (new BlockLogVert2()).func_149663_c("WoodVert2").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/* 342 */     woodHoriz = (new BlockLogHoriz(0)).func_149663_c("WoodHoriz").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/* 343 */     woodHoriz2 = (new BlockLogHoriz(8)).func_149663_c("WoodHoriz2").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/* 344 */     woodHoriz3 = (new BlockLogHoriz2(0)).func_149663_c("WoodHoriz3").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/*     */     
/* 346 */     woodHoriz4 = (new BlockLogHoriz2(0)).func_149663_c("WoodHoriz4").func_149711_c(20.0F).func_149752_b(15.0F).func_149672_a(Block.field_149766_f);
/*     */     
/* 348 */     toolRack = (new BlockToolRack()).func_149711_c(3.0F).func_149663_c("Toolrack");
/* 349 */     spawnMeter = (new BlockSpawnMeter()).func_149711_c(3.0F).func_149663_c("SpawnMeter");
/* 350 */     foodPrep = (new BlockFoodPrep()).func_149711_c(1.0F).func_149663_c("FoodPrep");
/* 351 */     quern = (new BlockQuern()).func_149711_c(3.0F).func_149663_c("Quern");
/*     */     
/* 353 */     wallCobbleIgIn = (new BlockCustomWall(stoneIgInCobble, 3)).func_149663_c("WallCobble");
/* 354 */     wallCobbleIgEx = (new BlockCustomWall(stoneIgExCobble, 4)).func_149663_c("WallCobble");
/* 355 */     wallCobbleSed = (new BlockCustomWall(stoneSedCobble, 8)).func_149663_c("WallCobble");
/* 356 */     wallCobbleMM = (new BlockCustomWall(stoneMMCobble, 6)).func_149663_c("WallCobble");
/* 357 */     wallRawIgIn = (new BlockCustomWall(stoneIgIn, 3)).func_149663_c("WallRaw");
/* 358 */     wallRawIgEx = (new BlockCustomWall(stoneIgEx, 4)).func_149663_c("WallRaw");
/* 359 */     wallRawSed = (new BlockCustomWall(stoneSed, 8)).func_149663_c("WallRaw");
/* 360 */     wallRawMM = (new BlockCustomWall(stoneMM, 6)).func_149663_c("WallRaw");
/* 361 */     wallBrickIgIn = (new BlockCustomWall(stoneIgInBrick, 3)).func_149663_c("WallBrick");
/* 362 */     wallBrickIgEx = (new BlockCustomWall(stoneIgExBrick, 4)).func_149663_c("WallBrick");
/* 363 */     wallBrickSed = (new BlockCustomWall(stoneSedBrick, 8)).func_149663_c("WallBrick");
/* 364 */     wallBrickMM = (new BlockCustomWall(stoneMMBrick, 6)).func_149663_c("WallBrick");
/* 365 */     wallSmoothIgIn = (new BlockCustomWall(stoneIgInSmooth, 3)).func_149663_c("WallSmooth");
/* 366 */     wallSmoothIgEx = (new BlockCustomWall(stoneIgExSmooth, 4)).func_149663_c("WallSmooth");
/* 367 */     wallSmoothSed = (new BlockCustomWall(stoneSedSmooth, 8)).func_149663_c("WallSmooth");
/* 368 */     wallSmoothMM = (new BlockCustomWall(stoneMMSmooth, 6)).func_149663_c("WallSmooth");
/*     */ 
/*     */     
/* 371 */     for (int i = 0; i < Global.WOOD_ALL.length; i++) {
/* 372 */       doors[i] = (new BlockCustomDoor(i * 2)).func_149663_c("Door " + Global.WOOD_ALL[i]);
/*     */     }
/* 374 */     ingotPile = (new BlockIngotPile()).func_149663_c("ingotpile").func_149711_c(3.0F);
/*     */     
/* 376 */     barrel = (new BlockBarrel()).func_149663_c("Barrel").func_149711_c(2.0F);
/* 377 */     loom = (new BlockLoom()).func_149663_c("Loom").func_149711_c(2.0F);
/* 378 */     thatch = (new BlockThatch()).func_149663_c("Thatch").func_149711_c(1.0F).func_149672_a(Block.field_149779_h).func_149647_a(TFCTabs.TFC_BUILDING);
/* 379 */     moss = (new BlockMoss()).func_149663_c("Moss").func_149711_c(1.0F).func_149672_a(Block.field_149779_h);
/*     */     
/* 381 */     flora = (new BlockFlora()).func_149663_c("Flora").func_149711_c(0.1F).func_149672_a(Block.field_149779_h);
/* 382 */     pottery = (new BlockPottery()).func_149663_c("Pottery").func_149711_c(1.0F);
/*     */     
/* 384 */     crucible = (new BlockCrucible()).func_149663_c("Crucible").func_149711_c(4.0F);
/*     */     
/* 386 */     nestBox = (new BlockNestBox()).func_149663_c("NestBox").func_149711_c(1.0F);
/*     */     
/* 388 */     fence = (new BlockTFCFence("Fence", Material.field_151575_d)).func_149663_c("FenceTFC").func_149711_c(2.0F);
/* 389 */     fenceGate = (new BlockCustomFenceGate()).func_149663_c("FenceGateTFC").func_149711_c(2.0F);
/* 390 */     fence2 = (new BlockTFCFence2("Fence2", Material.field_151575_d)).func_149663_c("FenceTFC").func_149711_c(2.0F);
/* 391 */     fenceGate2 = (new BlockCustomFenceGate2()).func_149663_c("FenceGateTFC").func_149711_c(2.0F);
/* 392 */     strawHideBed = (new BlockBed()).func_149663_c("StrawHideBed").func_149711_c(1.0F).func_149647_a(null);
/* 393 */     armorStand = (new BlockStand()).func_149663_c("ArmourStand").func_149711_c(2.0F);
/* 394 */     armorStand2 = (new BlockStand2()).func_149663_c("ArmourStand").func_149711_c(2.0F);
/*     */     
/* 396 */     berryBush = (new BlockBerryBush()).func_149663_c("BerryBush").func_149711_c(0.3F).func_149672_a(Block.field_149779_h);
/* 397 */     crops = (new BlockCrop()).func_149663_c("crops").func_149711_c(0.3F).func_149672_a(Block.field_149779_h);
/* 398 */     lilyPad = (new BlockCustomLilyPad()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("LilyPad").func_149658_d("waterlily");
/* 399 */     flowers = (new BlockFlower()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("Flowers");
/* 400 */     flowers2 = (new BlockFlower2()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("Flowers2");
/* 401 */     fungi = (new BlockFungi()).func_149711_c(0.0F).func_149672_a(Block.field_149779_h).func_149663_c("Fungi");
/*     */     
/* 403 */     saltWater = (new BlockSaltWater(TFCFluids.SALTWATER)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("SaltWater");
/* 404 */     saltWaterStationary = (new BlockLiquidStatic(TFCFluids.SALTWATER, Material.field_151586_h, saltWater)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("SaltWaterStationary");
/*     */     
/* 406 */     freshWater = (new BlockFreshWater(TFCFluids.FRESHWATER)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("FreshWater");
/* 407 */     freshWaterStationary = (new BlockLiquidStatic(TFCFluids.FRESHWATER, Material.field_151586_h, freshWater)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("FreshWaterStationary");
/*     */     
/* 409 */     hotWater = (new BlockHotWater(TFCFluids.HOTWATER)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("HotWater");
/* 410 */     hotWaterStationary = (new BlockHotWaterStatic(TFCFluids.HOTWATER, Material.field_151586_h, hotWater)).func_149711_c(100.0F).func_149713_g(3).func_149663_c("HotWaterStationary");
/*     */     
/* 412 */     lava = (new BlockLava()).func_149711_c(0.0F).func_149715_a(1.0F).func_149713_g(255).func_149663_c("Lava");
/* 413 */     lavaStationary = (new BlockLiquidStatic(TFCFluids.LAVA, Material.field_151587_i, lava)).func_149711_c(0.0F).func_149715_a(1.0F).func_149713_g(255).func_149663_c("LavaStationary");
/* 414 */     ice = (new BlockCustomIce()).func_149711_c(0.5F).func_149713_g(3).func_149672_a(Block.field_149778_k).func_149663_c("Ice").func_149658_d("ice");
/*     */     
/* 416 */     waterPlant = (new BlockWaterPlant(0)).func_149663_c("SeaGrassStill").func_149711_c(0.5F).func_149672_a(Block.field_149767_g);
/*     */     
/* 418 */     fireBrick = (new BlockFireBrick()).func_149663_c("FireBrick").func_149711_c(8.0F);
/* 419 */     metalSheet = (new BlockMetalSheet()).func_149663_c("MetalSheet").func_149711_c(80.0F);
/* 420 */     leatherRack = (new BlockLeatherRack()).func_149663_c("LeatherRack").func_149711_c(1.0F);
/* 421 */     metalBlock = (new BlockMetal(Material.field_151573_f) {  }).func_149711_c(16.0F).func_149752_b(10.0F).func_149672_a(Block.field_149777_j).func_149663_c("MetalBlock");
/* 422 */     metalBlock2 = (new BlockMetal2(Material.field_151573_f) {  }).func_149711_c(16.0F).func_149752_b(10.0F).func_149672_a(Block.field_149777_j).func_149663_c("MetalBlock");
/*     */     
/* 424 */     gravel = (new BlockGravel(0)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("gravels");
/* 425 */     gravel2 = (new BlockGravel(16)).func_149711_c(2.0F).func_149672_a(Block.field_149767_g).func_149663_c("gravels");
/*     */     
/* 427 */     grill = (new BlockGrill()).func_149711_c(2.0F).func_149663_c("Grill");
/* 428 */     metalTrapDoor = (new BlockMetalTrapDoor()).func_149711_c(2.0F).func_149663_c("MetalTrapDoor");
/* 429 */     vessel = (new BlockLargeVessel()).func_149711_c(1.0F).func_149663_c("Vessel");
/* 430 */     smoke = (new BlockSmoke()).func_149711_c(0.0F).func_149663_c("Smoke");
/* 431 */     smokeRack = (new BlockSmokeRack()).func_149711_c(0.0F).func_149663_c("SmokeRack");
/*     */     
/* 433 */     oilLamp = (new BlockOilLamp()).func_149711_c(1.0F).func_149663_c("OilLamp");
/* 434 */     hopper = (new BlockHopper()).func_149711_c(2.0F).func_149663_c("Hopper");
/* 435 */     flowerPot = (new BlockCustomFlowerPot()).func_149711_c(0.0F).func_149672_a(Block.field_149769_e).func_149663_c("FlowerPot").func_149658_d("flower_pot");
/*     */     
/* 437 */     stoneIgIn.setHarvestLevel("pickaxe", 0);
/* 438 */     stoneIgEx.setHarvestLevel("pickaxe", 0);
/* 439 */     stoneSed.setHarvestLevel("pickaxe", 0);
/* 440 */     stoneMM.setHarvestLevel("pickaxe", 0);
/* 441 */     stoneStalac.setHarvestLevel("pickaxe", 0);
/* 442 */     detailed.setHarvestLevel("pickaxe", 0);
/* 443 */     ore.setHarvestLevel("pickaxe", 1);
/* 444 */     ore2.setHarvestLevel("pickaxe", 1);
/* 445 */     ore3.setHarvestLevel("pickaxe", 1);
/* 446 */     metalBlock.setHarvestLevel("pickaxe", 1);
/* 447 */     metalBlock2.setHarvestLevel("pickaxe", 1);
/*     */     
/* 449 */     dirt.setHarvestLevel("shovel", 0);
/* 450 */     dirt2.setHarvestLevel("shovel", 0);
/* 451 */     grass.setHarvestLevel("shovel", 0);
/* 452 */     grass2.setHarvestLevel("shovel", 0);
/* 453 */     dryGrass.setHarvestLevel("shovel", 0);
/* 454 */     dryGrass2.setHarvestLevel("shovel", 0);
/* 455 */     clay.setHarvestLevel("shovel", 0);
/* 456 */     clay2.setHarvestLevel("shovel", 0);
/* 457 */     clayGrass.setHarvestLevel("shovel", 0);
/* 458 */     clayGrass2.setHarvestLevel("shovel", 0);
/* 459 */     peat.setHarvestLevel("shovel", 0);
/* 460 */     peatGrass.setHarvestLevel("shovel", 0);
/* 461 */     sand.setHarvestLevel("shovel", 0);
/* 462 */     sand2.setHarvestLevel("shovel", 0);
/* 463 */     charcoal.setHarvestLevel("shovel", 0);
/* 464 */     gravel.setHarvestLevel("shovel", 0);
/* 465 */     gravel2.setHarvestLevel("shovel", 0);
/* 466 */     waterPlant.setHarvestLevel("shovel", 0);
/* 467 */     tilledSoil.setHarvestLevel("shovel", 0);
/* 468 */     tilledSoil2.setHarvestLevel("shovel", 0);
/*     */     
/* 470 */     detailed.setHarvestLevel("axe", 0);
/* 471 */     Blocks.field_150476_ad.setHarvestLevel("axe", 0);
/* 472 */     woodConstruct.setHarvestLevel("axe", 0);
/* 473 */     logNatural.setHarvestLevel("axe", 1);
/* 474 */     logNatural2.setHarvestLevel("axe", 1);
/* 475 */     woodHoriz.setHarvestLevel("axe", 1);
/* 476 */     woodHoriz2.setHarvestLevel("axe", 1);
/* 477 */     woodHoriz3.setHarvestLevel("axe", 1);
/* 478 */     woodHoriz4.setHarvestLevel("axe", 1);
/* 479 */     woodVert.setHarvestLevel("axe", 1);
/* 480 */     woodVert2.setHarvestLevel("axe", 1);
/*     */     
/* 482 */     logNatural.setHarvestLevel("hammer", 1);
/* 483 */     logNatural2.setHarvestLevel("hammer", 1);
/* 484 */     woodHoriz.setHarvestLevel("hammer", 1);
/* 485 */     woodHoriz2.setHarvestLevel("hammer", 1);
/* 486 */     woodHoriz3.setHarvestLevel("hammer", 1);
/* 487 */     woodHoriz4.setHarvestLevel("hammer", 1);
/* 488 */     woodVert.setHarvestLevel("hammer", 1);
/* 489 */     woodVert2.setHarvestLevel("hammer", 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setupFire() {
/* 494 */     Blocks.field_150480_ab.setFireInfo(logNatural, 5, 5);
/* 495 */     Blocks.field_150480_ab.setFireInfo(logNatural2, 5, 5);
/* 496 */     Blocks.field_150480_ab.setFireInfo(woodSupportV, 5, 20);
/* 497 */     Blocks.field_150480_ab.setFireInfo(woodSupportV2, 5, 20);
/* 498 */     Blocks.field_150480_ab.setFireInfo(woodSupportH, 5, 20);
/* 499 */     Blocks.field_150480_ab.setFireInfo(woodSupportH2, 5, 20);
/* 500 */     Blocks.field_150480_ab.setFireInfo(leaves, 20, 20);
/* 501 */     Blocks.field_150480_ab.setFireInfo(leaves2, 20, 20);
/* 502 */     Blocks.field_150480_ab.setFireInfo(fruitTreeWood, 5, 20);
/* 503 */     Blocks.field_150480_ab.setFireInfo(fruitTreeLeaves, 20, 20);
/* 504 */     Blocks.field_150480_ab.setFireInfo(fruitTreeLeaves2, 20, 20);
/* 505 */     Blocks.field_150480_ab.setFireInfo(fence, 5, 20);
/* 506 */     Blocks.field_150480_ab.setFireInfo(fence2, 5, 20);
/* 507 */     Blocks.field_150480_ab.setFireInfo(fenceGate, 5, 20);
/* 508 */     Blocks.field_150480_ab.setFireInfo(fenceGate2, 5, 20);
/* 509 */     Blocks.field_150480_ab.setFireInfo(chest, 5, 20);
/* 510 */     Blocks.field_150480_ab.setFireInfo(strawHideBed, 20, 20);
/* 511 */     Blocks.field_150480_ab.setFireInfo(thatch, 20, 20);
/* 512 */     Blocks.field_150480_ab.setFireInfo(woodVert, 5, 5);
/* 513 */     Blocks.field_150480_ab.setFireInfo(woodVert2, 5, 5);
/* 514 */     Blocks.field_150480_ab.setFireInfo(woodHoriz, 5, 5);
/* 515 */     Blocks.field_150480_ab.setFireInfo(woodHoriz2, 5, 5);
/* 516 */     Blocks.field_150480_ab.setFireInfo(woodHoriz3, 5, 5);
/* 517 */     Blocks.field_150480_ab.setFireInfo(woodHoriz4, 5, 5);
/* 518 */     Blocks.field_150480_ab.setFireInfo(planks, 5, 20);
/* 519 */     Blocks.field_150480_ab.setFireInfo(planks2, 5, 20);
/* 520 */     Blocks.field_150480_ab.setFireInfo(woodConstruct, 5, 20);
/* 521 */     Blocks.field_150480_ab.setFireInfo(berryBush, 20, 20);
/* 522 */     Blocks.field_150480_ab.setFireInfo(barrel, 5, 20);
/* 523 */     Blocks.field_150480_ab.setFireInfo(crops, 20, 20);
/* 524 */     Blocks.field_150480_ab.setFireInfo(logPile, 10, 10);
/*     */     
/* 526 */     for (int i = 0; i < Global.WOOD_ALL.length; i++)
/* 527 */       Blocks.field_150480_ab.setFireInfo(doors[i], 5, 20); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\BlockSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */