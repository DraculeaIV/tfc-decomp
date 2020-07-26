/*      */ package com.bioxx.tfc.api;
/*      */ 
/*      */ import com.bioxx.tfc.TerraFirmaCraft;
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import java.util.List;
/*      */ import net.minecraft.item.Item;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TFCItems
/*      */ {
/*      */   public static Item gemRuby;
/*      */   public static Item gemSapphire;
/*      */   public static Item gemEmerald;
/*      */   public static Item gemTopaz;
/*      */   public static Item gemGarnet;
/*      */   public static Item gemOpal;
/*      */   public static Item gemAmethyst;
/*      */   public static Item gemJasper;
/*      */   public static Item gemBeryl;
/*      */   public static Item gemTourmaline;
/*      */   public static Item gemJade;
/*      */   public static Item gemAgate;
/*      */   public static Item gemDiamond;
/*      */   public static Item smallMetalChunk;
/*      */   public static Item bismuthIngot;
/*      */   public static Item bismuthBronzeIngot;
/*      */   public static Item blackBronzeIngot;
/*      */   public static Item blackSteelIngot;
/*      */   public static Item highCarbonBlackSteelIngot;
/*      */   public static Item blueSteelIngot;
/*      */   public static Item weakBlueSteelIngot;
/*      */   public static Item highCarbonBlueSteelIngot;
/*      */   public static Item brassIngot;
/*      */   public static Item bronzeIngot;
/*      */   public static Item copperIngot;
/*      */   public static Item goldIngot;
/*      */   public static Item wroughtIronIngot;
/*      */   public static Item leadIngot;
/*      */   public static Item nickelIngot;
/*      */   public static Item pigIronIngot;
/*      */   public static Item platinumIngot;
/*      */   public static Item redSteelIngot;
/*      */   public static Item weakRedSteelIngot;
/*      */   public static Item highCarbonRedSteelIngot;
/*      */   public static Item roseGoldIngot;
/*      */   public static Item silverIngot;
/*      */   public static Item steelIngot;
/*      */   public static Item weakSteelIngot;
/*      */   public static Item highCarbonSteelIngot;
/*      */   public static Item sterlingSilverIngot;
/*      */   public static Item tinIngot;
/*      */   public static Item zincIngot;
/*      */   public static Item electrumIngot;
/*      */   public static Item cupronickelIngot;
/*      */   public static Item bismuthIngot2x;
/*      */   public static Item bismuthBronzeIngot2x;
/*      */   public static Item blackBronzeIngot2x;
/*      */   public static Item blackSteelIngot2x;
/*      */   public static Item blueSteelIngot2x;
/*      */   public static Item brassIngot2x;
/*      */   public static Item bronzeIngot2x;
/*      */   public static Item copperIngot2x;
/*      */   public static Item goldIngot2x;
/*      */   public static Item wroughtIronIngot2x;
/*      */   public static Item leadIngot2x;
/*      */   public static Item nickelIngot2x;
/*      */   public static Item pigIronIngot2x;
/*      */   public static Item platinumIngot2x;
/*      */   public static Item redSteelIngot2x;
/*      */   public static Item roseGoldIngot2x;
/*      */   public static Item silverIngot2x;
/*      */   public static Item steelIngot2x;
/*      */   public static Item sterlingSilverIngot2x;
/*      */   public static Item tinIngot2x;
/*      */   public static Item zincIngot2x;
/*      */   public static Item electrumIngot2x;
/*      */   public static Item cupronickelIngot2x;
/*      */   public static Item igInShovel;
/*      */   public static Item igInAxe;
/*      */   public static Item igInHoe;
/*      */   public static Item sedShovel;
/*      */   public static Item sedAxe;
/*      */   public static Item sedHoe;
/*      */   public static Item igExShovel;
/*      */   public static Item igExAxe;
/*      */   public static Item igExHoe;
/*      */   public static Item mMShovel;
/*      */   public static Item mMAxe;
/*      */   public static Item mMHoe;
/*      */   public static Item bismuthBronzePick;
/*      */   public static Item bismuthBronzeShovel;
/*      */   public static Item bismuthBronzeAxe;
/*      */   public static Item bismuthBronzeHoe;
/*      */   public static Item blackBronzePick;
/*      */   public static Item blackBronzeShovel;
/*      */   public static Item blackBronzeAxe;
/*      */   public static Item blackBronzeHoe;
/*      */   public static Item blackSteelPick;
/*      */   public static Item blackSteelShovel;
/*      */   public static Item blackSteelAxe;
/*      */   public static Item blackSteelHoe;
/*      */   public static Item blueSteelPick;
/*      */   public static Item blueSteelShovel;
/*      */   public static Item blueSteelAxe;
/*      */   public static Item blueSteelHoe;
/*      */   public static Item bronzePick;
/*      */   public static Item bronzeShovel;
/*      */   public static Item bronzeAxe;
/*      */   public static Item bronzeHoe;
/*      */   public static Item copperPick;
/*      */   public static Item copperShovel;
/*      */   public static Item copperAxe;
/*      */   public static Item copperHoe;
/*      */   public static Item wroughtIronPick;
/*      */   public static Item wroughtIronShovel;
/*      */   public static Item wroughtIronAxe;
/*      */   public static Item wroughtIronHoe;
/*      */   public static Item redSteelPick;
/*      */   public static Item redSteelShovel;
/*      */   public static Item redSteelAxe;
/*      */   public static Item redSteelHoe;
/*      */   public static Item steelPick;
/*      */   public static Item steelShovel;
/*      */   public static Item steelAxe;
/*      */   public static Item steelHoe;
/*      */   public static Item bismuthBronzeChisel;
/*      */   public static Item blackBronzeChisel;
/*      */   public static Item blackSteelChisel;
/*      */   public static Item blueSteelChisel;
/*      */   public static Item bronzeChisel;
/*      */   public static Item copperChisel;
/*      */   public static Item wroughtIronChisel;
/*      */   public static Item redSteelChisel;
/*      */   public static Item steelChisel;
/*      */   public static Item bismuthBronzeSword;
/*      */   public static Item blackBronzeSword;
/*      */   public static Item blackSteelSword;
/*      */   public static Item blueSteelSword;
/*      */   public static Item bronzeSword;
/*      */   public static Item copperSword;
/*      */   public static Item wroughtIronSword;
/*      */   public static Item redSteelSword;
/*      */   public static Item steelSword;
/*      */   public static Item bismuthBronzeMace;
/*      */   public static Item blackBronzeMace;
/*      */   public static Item blackSteelMace;
/*      */   public static Item blueSteelMace;
/*      */   public static Item bronzeMace;
/*      */   public static Item copperMace;
/*      */   public static Item wroughtIronMace;
/*      */   public static Item redSteelMace;
/*      */   public static Item steelMace;
/*      */   public static Item bismuthBronzeSaw;
/*      */   public static Item blackBronzeSaw;
/*      */   public static Item blackSteelSaw;
/*      */   public static Item blueSteelSaw;
/*      */   public static Item bronzeSaw;
/*      */   public static Item copperSaw;
/*      */   public static Item wroughtIronSaw;
/*      */   public static Item redSteelSaw;
/*      */   public static Item steelSaw;
/*      */   public static Item coal;
/*      */   public static Item oreChunk;
/*      */   public static Item smallOreChunk;
/*      */   public static Item logs;
/*      */   public static Item barrel;
/*      */   public static Item loom;
/*      */   public static Item igInStoneJavelin;
/*      */   public static Item sedStoneJavelin;
/*      */   public static Item igExStoneJavelin;
/*      */   public static Item mMStoneJavelin;
/*      */   public static Item copperJavelin;
/*      */   public static Item bismuthBronzeJavelin;
/*      */   public static Item bronzeJavelin;
/*      */   public static Item blackBronzeJavelin;
/*      */   public static Item wroughtIronJavelin;
/*      */   public static Item steelJavelin;
/*      */   public static Item blackSteelJavelin;
/*      */   public static Item blueSteelJavelin;
/*      */   public static Item redSteelJavelin;
/*      */   public static Item igInStoneJavelinHead;
/*      */   public static Item sedStoneJavelinHead;
/*      */   public static Item igExStoneJavelinHead;
/*      */   public static Item mMStoneJavelinHead;
/*      */   public static Item copperJavelinHead;
/*      */   public static Item bismuthBronzeJavelinHead;
/*      */   public static Item bronzeJavelinHead;
/*      */   public static Item blackBronzeJavelinHead;
/*      */   public static Item wroughtIronJavelinHead;
/*      */   public static Item steelJavelinHead;
/*      */   public static Item blackSteelJavelinHead;
/*      */   public static Item blueSteelJavelinHead;
/*      */   public static Item redSteelJavelinHead;
/*      */   public static Item bismuthBronzeScythe;
/*      */   public static Item blackBronzeScythe;
/*      */   public static Item blackSteelScythe;
/*      */   public static Item blueSteelScythe;
/*      */   public static Item bronzeScythe;
/*      */   public static Item copperScythe;
/*      */   public static Item wroughtIronScythe;
/*      */   public static Item redSteelScythe;
/*      */   public static Item steelScythe;
/*      */   public static Item bismuthBronzeKnife;
/*      */   public static Item blackBronzeKnife;
/*      */   public static Item blackSteelKnife;
/*      */   public static Item blueSteelKnife;
/*      */   public static Item bronzeKnife;
/*      */   public static Item copperKnife;
/*      */   public static Item wroughtIronKnife;
/*      */   public static Item redSteelKnife;
/*      */   public static Item steelKnife;
/*      */   public static Item fireStarter;
/*      */   public static Item fishingRod;
/*      */   public static Item bow;
/*      */   public static Item stoneHammer;
/*      */   public static Item bismuthBronzeHammer;
/*      */   public static Item blackBronzeHammer;
/*      */   public static Item blackSteelHammer;
/*      */   public static Item blueSteelHammer;
/*      */   public static Item bronzeHammer;
/*      */   public static Item copperHammer;
/*      */   public static Item wroughtIronHammer;
/*      */   public static Item redSteelHammer;
/*      */   public static Item steelHammer;
/*      */   public static Item bismuthUnshaped;
/*      */   public static Item bismuthBronzeUnshaped;
/*      */   public static Item blackBronzeUnshaped;
/*      */   public static Item blackSteelUnshaped;
/*      */   public static Item highCarbonBlackSteelUnshaped;
/*      */   public static Item blueSteelUnshaped;
/*      */   public static Item weakBlueSteelUnshaped;
/*      */   public static Item highCarbonBlueSteelUnshaped;
/*      */   public static Item brassUnshaped;
/*      */   public static Item bronzeUnshaped;
/*      */   public static Item copperUnshaped;
/*      */   public static Item goldUnshaped;
/*      */   public static Item wroughtIronUnshaped;
/*      */   public static Item leadUnshaped;
/*      */   public static Item nickelUnshaped;
/*      */   public static Item pigIronUnshaped;
/*      */   public static Item platinumUnshaped;
/*      */   public static Item redSteelUnshaped;
/*      */   public static Item weakRedSteelUnshaped;
/*      */   public static Item highCarbonRedSteelUnshaped;
/*      */   public static Item roseGoldUnshaped;
/*      */   public static Item silverUnshaped;
/*      */   public static Item steelUnshaped;
/*      */   public static Item weakSteelUnshaped;
/*      */   public static Item highCarbonSteelUnshaped;
/*      */   public static Item sterlingSilverUnshaped;
/*      */   public static Item tinUnshaped;
/*      */   public static Item zincUnshaped;
/*      */   public static Item electrumUnshaped;
/*      */   public static Item cupronickelUnshaped;
/*      */   public static Item ceramicMold;
/*      */   public static Item ink;
/*      */   public static Item bismuthBronzePickaxeHead;
/*      */   public static Item blackBronzePickaxeHead;
/*      */   public static Item blackSteelPickaxeHead;
/*      */   public static Item blueSteelPickaxeHead;
/*      */   public static Item bronzePickaxeHead;
/*      */   public static Item copperPickaxeHead;
/*      */   public static Item wroughtIronPickaxeHead;
/*      */   public static Item redSteelPickaxeHead;
/*      */   public static Item steelPickaxeHead;
/*      */   public static Item bismuthBronzeShovelHead;
/*      */   public static Item blackBronzeShovelHead;
/*      */   public static Item blackSteelShovelHead;
/*      */   public static Item blueSteelShovelHead;
/*      */   public static Item bronzeShovelHead;
/*      */   public static Item copperShovelHead;
/*      */   public static Item wroughtIronShovelHead;
/*      */   public static Item redSteelShovelHead;
/*      */   public static Item silverShovelHead;
/*      */   public static Item steelShovelHead;
/*      */   public static Item bismuthBronzeHoeHead;
/*      */   public static Item blackBronzeHoeHead;
/*      */   public static Item blackSteelHoeHead;
/*      */   public static Item blueSteelHoeHead;
/*      */   public static Item bronzeHoeHead;
/*      */   public static Item copperHoeHead;
/*      */   public static Item wroughtIronHoeHead;
/*      */   public static Item redSteelHoeHead;
/*      */   public static Item steelHoeHead;
/*      */   public static Item bismuthBronzeAxeHead;
/*      */   public static Item blackBronzeAxeHead;
/*      */   public static Item blackSteelAxeHead;
/*      */   public static Item blueSteelAxeHead;
/*      */   public static Item bronzeAxeHead;
/*      */   public static Item copperAxeHead;
/*      */   public static Item wroughtIronAxeHead;
/*      */   public static Item redSteelAxeHead;
/*      */   public static Item steelAxeHead;
/*      */   public static Item bismuthBronzeHammerHead;
/*      */   public static Item blackBronzeHammerHead;
/*      */   public static Item blackSteelHammerHead;
/*      */   public static Item blueSteelHammerHead;
/*      */   public static Item bronzeHammerHead;
/*      */   public static Item copperHammerHead;
/*      */   public static Item wroughtIronHammerHead;
/*      */   public static Item redSteelHammerHead;
/*      */   public static Item steelHammerHead;
/*      */   public static Item bismuthBronzeChiselHead;
/*      */   public static Item blackBronzeChiselHead;
/*      */   public static Item blackSteelChiselHead;
/*      */   public static Item blueSteelChiselHead;
/*      */   public static Item bronzeChiselHead;
/*      */   public static Item copperChiselHead;
/*      */   public static Item wroughtIronChiselHead;
/*      */   public static Item redSteelChiselHead;
/*      */   public static Item steelChiselHead;
/*      */   public static Item bismuthBronzeSwordHead;
/*      */   public static Item blackBronzeSwordHead;
/*      */   public static Item blackSteelSwordHead;
/*      */   public static Item blueSteelSwordHead;
/*      */   public static Item bronzeSwordHead;
/*      */   public static Item copperSwordHead;
/*      */   public static Item wroughtIronSwordHead;
/*      */   public static Item redSteelSwordHead;
/*      */   public static Item steelSwordHead;
/*      */   public static Item bismuthBronzeMaceHead;
/*      */   public static Item blackBronzeMaceHead;
/*      */   public static Item blackSteelMaceHead;
/*      */   public static Item blueSteelMaceHead;
/*      */   public static Item bronzeMaceHead;
/*      */   public static Item copperMaceHead;
/*      */   public static Item wroughtIronMaceHead;
/*      */   public static Item redSteelMaceHead;
/*      */   public static Item steelMaceHead;
/*      */   public static Item bismuthBronzeSawHead;
/*      */   public static Item blackBronzeSawHead;
/*      */   public static Item blackSteelSawHead;
/*      */   public static Item blueSteelSawHead;
/*      */   public static Item bronzeSawHead;
/*      */   public static Item copperSawHead;
/*      */   public static Item wroughtIronSawHead;
/*      */   public static Item redSteelSawHead;
/*      */   public static Item steelSawHead;
/*      */   public static Item bismuthBronzeProPickHead;
/*      */   public static Item blackBronzeProPickHead;
/*      */   public static Item blackSteelProPickHead;
/*      */   public static Item blueSteelProPickHead;
/*      */   public static Item bronzeProPickHead;
/*      */   public static Item copperProPickHead;
/*      */   public static Item wroughtIronProPickHead;
/*      */   public static Item redSteelProPickHead;
/*      */   public static Item steelProPickHead;
/*      */   public static Item bismuthBronzeScytheHead;
/*      */   public static Item blackBronzeScytheHead;
/*      */   public static Item blackSteelScytheHead;
/*      */   public static Item blueSteelScytheHead;
/*      */   public static Item bronzeScytheHead;
/*      */   public static Item copperScytheHead;
/*      */   public static Item wroughtIronScytheHead;
/*      */   public static Item redSteelScytheHead;
/*      */   public static Item steelScytheHead;
/*      */   public static Item bismuthBronzeKnifeHead;
/*      */   public static Item blackBronzeKnifeHead;
/*      */   public static Item blackSteelKnifeHead;
/*      */   public static Item blueSteelKnifeHead;
/*      */   public static Item bronzeKnifeHead;
/*      */   public static Item copperKnifeHead;
/*      */   public static Item wroughtIronKnifeHead;
/*      */   public static Item redSteelKnifeHead;
/*      */   public static Item steelKnifeHead;
/*      */   public static Item powder;
/*      */   public static Item dye;
/*      */   public static Item goldPan;
/*      */   public static Item sluiceItem;
/*      */   public static Item proPickBismuthBronze;
/*      */   public static Item proPickBlackBronze;
/*      */   public static Item proPickBlackSteel;
/*      */   public static Item proPickBlueSteel;
/*      */   public static Item proPickBronze;
/*      */   public static Item proPickCopper;
/*      */   public static Item proPickIron;
/*      */   public static Item proPickRedSteel;
/*      */   public static Item proPickSteel;
/*      */   public static Item bismuthSheet;
/*      */   public static Item bismuthBronzeSheet;
/*      */   public static Item blackBronzeSheet;
/*      */   public static Item blackSteelSheet;
/*      */   public static Item blueSteelSheet;
/*      */   public static Item bronzeSheet;
/*      */   public static Item copperSheet;
/*      */   public static Item wroughtIronSheet;
/*      */   public static Item redSteelSheet;
/*      */   public static Item roseGoldSheet;
/*      */   public static Item steelSheet;
/*      */   public static Item tinSheet;
/*      */   public static Item zincSheet;
/*      */   public static Item electrumSheet;
/*      */   public static Item cupronickelSheet;
/*      */   public static Item brassSheet;
/*      */   public static Item goldSheet;
/*      */   public static Item leadSheet;
/*      */   public static Item nickelSheet;
/*      */   public static Item pigIronSheet;
/*      */   public static Item platinumSheet;
/*      */   public static Item silverSheet;
/*      */   public static Item sterlingSilverSheet;
/*      */   public static Item bismuthSheet2x;
/*      */   public static Item bismuthBronzeSheet2x;
/*      */   public static Item blackBronzeSheet2x;
/*      */   public static Item blackSteelSheet2x;
/*      */   public static Item blueSteelSheet2x;
/*      */   public static Item bronzeSheet2x;
/*      */   public static Item copperSheet2x;
/*      */   public static Item wroughtIronSheet2x;
/*      */   public static Item redSteelSheet2x;
/*      */   public static Item roseGoldSheet2x;
/*      */   public static Item steelSheet2x;
/*      */   public static Item tinSheet2x;
/*      */   public static Item zincSheet2x;
/*      */   public static Item electrumSheet2x;
/*      */   public static Item cupronickelSheet2x;
/*      */   public static Item brassSheet2x;
/*      */   public static Item goldSheet2x;
/*      */   public static Item leadSheet2x;
/*      */   public static Item nickelSheet2x;
/*      */   public static Item pigIronSheet2x;
/*      */   public static Item platinumSheet2x;
/*      */   public static Item silverSheet2x;
/*      */   public static Item sterlingSilverSheet2x;
/*      */   public static Item bismuthBronzeUnfinishedChestplate;
/*      */   public static Item blackBronzeUnfinishedChestplate;
/*      */   public static Item blackSteelUnfinishedChestplate;
/*      */   public static Item blueSteelUnfinishedChestplate;
/*      */   public static Item bronzeUnfinishedChestplate;
/*      */   public static Item copperUnfinishedChestplate;
/*      */   public static Item wroughtIronUnfinishedChestplate;
/*      */   public static Item redSteelUnfinishedChestplate;
/*      */   public static Item steelUnfinishedChestplate;
/*      */   public static Item bismuthBronzeUnfinishedGreaves;
/*      */   public static Item blackBronzeUnfinishedGreaves;
/*      */   public static Item blackSteelUnfinishedGreaves;
/*      */   public static Item blueSteelUnfinishedGreaves;
/*      */   public static Item bronzeUnfinishedGreaves;
/*      */   public static Item copperUnfinishedGreaves;
/*      */   public static Item wroughtIronUnfinishedGreaves;
/*      */   public static Item redSteelUnfinishedGreaves;
/*      */   public static Item steelUnfinishedGreaves;
/*      */   public static Item bismuthBronzeUnfinishedBoots;
/*      */   public static Item blackBronzeUnfinishedBoots;
/*      */   public static Item blackSteelUnfinishedBoots;
/*      */   public static Item blueSteelUnfinishedBoots;
/*      */   public static Item bronzeUnfinishedBoots;
/*      */   public static Item copperUnfinishedBoots;
/*      */   public static Item wroughtIronUnfinishedBoots;
/*      */   public static Item redSteelUnfinishedBoots;
/*      */   public static Item steelUnfinishedBoots;
/*      */   public static Item bismuthBronzeUnfinishedHelmet;
/*      */   public static Item blackBronzeUnfinishedHelmet;
/*      */   public static Item blackSteelUnfinishedHelmet;
/*      */   public static Item blueSteelUnfinishedHelmet;
/*      */   public static Item bronzeUnfinishedHelmet;
/*      */   public static Item copperUnfinishedHelmet;
/*      */   public static Item wroughtIronUnfinishedHelmet;
/*      */   public static Item redSteelUnfinishedHelmet;
/*      */   public static Item steelUnfinishedHelmet;
/*      */   public static Item leatherChestplate;
/*      */   public static Item bismuthBronzeChestplate;
/*      */   public static Item blackBronzeChestplate;
/*      */   public static Item blackSteelChestplate;
/*      */   public static Item blueSteelChestplate;
/*      */   public static Item bronzeChestplate;
/*      */   public static Item copperChestplate;
/*      */   public static Item wroughtIronChestplate;
/*      */   public static Item redSteelChestplate;
/*      */   public static Item steelChestplate;
/*      */   public static Item leatherLeggings;
/*      */   public static Item bismuthBronzeGreaves;
/*      */   public static Item blackBronzeGreaves;
/*      */   public static Item blackSteelGreaves;
/*      */   public static Item blueSteelGreaves;
/*      */   public static Item bronzeGreaves;
/*      */   public static Item copperGreaves;
/*      */   public static Item wroughtIronGreaves;
/*      */   public static Item redSteelGreaves;
/*      */   public static Item steelGreaves;
/*      */   public static Item leatherBoots;
/*      */   public static Item bismuthBronzeBoots;
/*      */   public static Item blackBronzeBoots;
/*      */   public static Item blackSteelBoots;
/*      */   public static Item blueSteelBoots;
/*      */   public static Item bronzeBoots;
/*      */   public static Item copperBoots;
/*      */   public static Item wroughtIronBoots;
/*      */   public static Item redSteelBoots;
/*      */   public static Item steelBoots;
/*      */   public static Item leatherHelmet;
/*      */   public static Item bismuthBronzeHelmet;
/*      */   public static Item blackBronzeHelmet;
/*      */   public static Item blackSteelHelmet;
/*      */   public static Item blueSteelHelmet;
/*      */   public static Item bronzeHelmet;
/*      */   public static Item copperHelmet;
/*      */   public static Item wroughtIronHelmet;
/*      */   public static Item redSteelHelmet;
/*      */   public static Item steelHelmet;
/*      */   public static Item woodenBucketEmpty;
/*      */   public static Item woodenBucketWater;
/*      */   public static Item woodenBucketSaltWater;
/*      */   public static Item woodenBucketMilk;
/*      */   public static Item seedsWheat;
/*      */   public static Item seedsMaize;
/*      */   public static Item seedsTomato;
/*      */   public static Item seedsBarley;
/*      */   public static Item seedsRye;
/*      */   public static Item seedsOat;
/*      */   public static Item seedsRice;
/*      */   public static Item seedsPotato;
/*      */   public static Item seedsOnion;
/*      */   public static Item seedsCabbage;
/*      */   public static Item seedsGarlic;
/*      */   public static Item seedsCarrot;
/*      */   public static Item seedsSugarcane;
/*      */   public static Item seedsYellowBellPepper;
/*      */   public static Item seedsRedBellPepper;
/*      */   public static Item seedsSoybean;
/*      */   public static Item seedsGreenbean;
/*      */   public static Item seedsSquash;
/*      */   public static Item seedsJute;
/*      */   public static Item fruitTreeSapling;
/*      */   public static Item redApple;
/*      */   public static Item greenApple;
/*      */   public static Item banana;
/*      */   public static Item orange;
/*      */   public static Item lemon;
/*      */   public static Item olive;
/*      */   public static Item cherry;
/*      */   public static Item peach;
/*      */   public static Item plum;
/*      */   public static Item egg;
/*      */   public static Item eggCooked;
/*      */   public static Item cheese;
/*      */   public static Item wheatGrain;
/*      */   public static Item barleyGrain;
/*      */   public static Item oatGrain;
/*      */   public static Item ryeGrain;
/*      */   public static Item riceGrain;
/*      */   public static Item maizeEar;
/*      */   public static Item tomato;
/*      */   public static Item potato;
/*      */   public static Item onion;
/*      */   public static Item cabbage;
/*      */   public static Item garlic;
/*      */   public static Item carrot;
/*      */   public static Item sugarcane;
/*      */   public static Item soybean;
/*      */   public static Item greenbeans;
/*      */   public static Item greenBellPepper;
/*      */   public static Item yellowBellPepper;
/*      */   public static Item redBellPepper;
/*      */   public static Item squash;
/*      */   public static Item seaWeed;
/*      */   public static Item sugar;
/*      */   public static Item wheatGround;
/*      */   public static Item barleyGround;
/*      */   public static Item oatGround;
/*      */   public static Item ryeGround;
/*      */   public static Item riceGround;
/*      */   public static Item cornmealGround;
/*      */   public static Item wheatDough;
/*      */   public static Item barleyDough;
/*      */   public static Item oatDough;
/*      */   public static Item ryeDough;
/*      */   public static Item riceDough;
/*      */   public static Item cornmealDough;
/*      */   public static Item wheatBread;
/*      */   public static Item barleyBread;
/*      */   public static Item oatBread;
/*      */   public static Item ryeBread;
/*      */   public static Item riceBread;
/*      */   public static Item cornBread;
/*      */   public static Item wheatWhole;
/*      */   public static Item barleyWhole;
/*      */   public static Item oatWhole;
/*      */   public static Item ryeWhole;
/*      */   public static Item riceWhole;
/*      */   public static Item muttonRaw;
/*      */   public static Item calamariRaw;
/*      */   public static Item venisonRaw;
/*      */   public static Item horseMeatRaw;
/*      */   public static Item porkchopRaw;
/*      */   public static Item fishRaw;
/*      */   public static Item beefRaw;
/*      */   public static Item bearRaw;
/*      */   public static Item chickenRaw;
/*      */   public static Item looseRock;
/*      */   public static Item flatRock;
/*      */   public static Item igInStoneShovelHead;
/*      */   public static Item sedStoneShovelHead;
/*      */   public static Item igExStoneShovelHead;
/*      */   public static Item mMStoneShovelHead;
/*      */   public static Item igInStoneAxeHead;
/*      */   public static Item sedStoneAxeHead;
/*      */   public static Item igExStoneAxeHead;
/*      */   public static Item mMStoneAxeHead;
/*      */   public static Item igInStoneHoeHead;
/*      */   public static Item sedStoneHoeHead;
/*      */   public static Item igExStoneHoeHead;
/*      */   public static Item mMStoneHoeHead;
/*      */   public static Item stoneKnife;
/*      */   public static Item stoneKnifeHead;
/*      */   public static Item stoneHammerHead;
/*      */   public static Item singlePlank;
/*      */   public static Item minecartEmpty;
/*      */   public static Item minecartCrate;
/*      */   public static Item redSteelBucketEmpty;
/*      */   public static Item redSteelBucketWater;
/*      */   public static Item redSteelBucketSaltWater;
/*      */   public static Item blueSteelBucketEmpty;
/*      */   public static Item blueSteelBucketLava;
/*      */   public static Item quern;
/*      */   public static Item flintSteel;
/*      */   public static Item doorOak;
/*      */   public static Item doorAspen;
/*      */   public static Item doorBirch;
/*      */   public static Item doorChestnut;
/*      */   public static Item doorDouglasFir;
/*      */   public static Item doorHickory;
/*      */   public static Item doorMaple;
/*      */   public static Item doorAsh;
/*      */   public static Item doorPine;
/*      */   public static Item doorSequoia;
/*      */   public static Item doorSpruce;
/*      */   public static Item doorSycamore;
/*      */   public static Item doorWhiteCedar;
/*      */   public static Item doorWhiteElm;
/*      */   public static Item doorWillow;
/*      */   public static Item doorKapok;
/*      */   public static Item doorAcacia;
/*      */   public static Item blueprint;
/*      */   public static Item nametag;
/*      */   public static Item woolYarn;
/*      */   public static Item wool;
/*      */   public static Item woolCloth;
/*      */   public static Item silkCloth;
/*      */   public static Item burlapCloth;
/*      */   public static Item spindle;
/*      */   public static Item spindleHead;
/*      */   public static Item stoneBrick;
/*      */   public static Item mortar;
/*      */   public static Item vinegar;
/*      */   public static Item hide;
/*      */   public static Item soakedHide;
/*      */   public static Item scrapedHide;
/*      */   public static Item prepHide;
/*      */   public static Item sheepSkin;
/*      */   public static Item pbearSkin;
/*      */   public static Item leather;
/*      */   public static Item flatLeather;
/*      */   public static Item beer;
/*      */   public static Item cider;
/*      */   public static Item rum;
/*      */   public static Item ryeWhiskey;
/*      */   public static Item sake;
/*      */   public static Item vodka;
/*      */   public static Item whiskey;
/*      */   public static Item cornWhiskey;
/*      */   public static Item glassBottle;
/*      */   public static Item potion;
/*      */   public static Item clayBall;
/*      */   public static Item potteryJug;
/*      */   public static Item potterySmallVessel;
/*      */   public static Item potteryBowl;
/*      */   public static Item straw;
/*      */   public static Item flatClay;
/*      */   public static Item fireBrick;
/*      */   public static Item stick;
/*      */   public static Item arrow;
/*      */   public static Item rope;
/*      */   public static Item clayMoldAxe;
/*      */   public static Item clayMoldChisel;
/*      */   public static Item clayMoldHammer;
/*      */   public static Item clayMoldHoe;
/*      */   public static Item clayMoldKnife;
/*      */   public static Item clayMoldMace;
/*      */   public static Item clayMoldPick;
/*      */   public static Item clayMoldProPick;
/*      */   public static Item clayMoldSaw;
/*      */   public static Item clayMoldScythe;
/*      */   public static Item clayMoldShovel;
/*      */   public static Item clayMoldSword;
/*      */   public static Item clayMoldJavelin;
/*      */   public static Item tuyereCopper;
/*      */   public static Item tuyereBronze;
/*      */   public static Item tuyereBlackBronze;
/*      */   public static Item tuyereBismuthBronze;
/*      */   public static Item tuyereWroughtIron;
/*      */   public static Item tuyereSteel;
/*      */   public static Item tuyereBlackSteel;
/*      */   public static Item tuyereBlueSteel;
/*      */   public static Item tuyereRedSteel;
/*      */   public static Item bloom;
/*      */   public static Item rawBloom;
/*      */   public static Item unknownIngot;
/*      */   public static Item unknownUnshaped;
/*      */   public static Item quiver;
/*      */   public static Item jute;
/*      */   public static Item juteFiber;
/*      */   public static Item reeds;
/*      */   public static Item wintergreenBerry;
/*      */   public static Item blueberry;
/*      */   public static Item raspberry;
/*      */   public static Item strawberry;
/*      */   public static Item blackberry;
/*      */   public static Item bunchberry;
/*      */   public static Item cranberry;
/*      */   public static Item snowberry;
/*      */   public static Item elderberry;
/*      */   public static Item gooseberry;
/*      */   public static Item cloudberry;
/*      */   public static Item fertilizer;
/*      */   public static Item sandwich;
/*      */   public static Item salad;
/*      */   public static Item shears;
/*  830 */   public static int igInStoneUses = 60;
/*  831 */   public static int igExStoneUses = 70;
/*  832 */   public static int sedStoneUses = 50;
/*  833 */   public static int mMStoneUses = 55;
/*      */   
/*  835 */   public static int copperUses = 600;
/*      */   
/*  837 */   public static int bronzeUses = 1300;
/*  838 */   public static int bismuthBronzeUses = 1200;
/*  839 */   public static int blackBronzeUses = 1460;
/*      */   
/*  841 */   public static int wroughtIronUses = 2200;
/*      */   
/*  843 */   public static int steelUses = 3300;
/*      */   
/*  845 */   public static int blackSteelUses = 4200;
/*      */   
/*  847 */   public static int blueSteelUses = 6500;
/*  848 */   public static int redSteelUses = 6500;
/*      */ 
/*      */   
/*  851 */   public static float igInStoneEff = 7.0F;
/*  852 */   public static float igExStoneEff = 7.0F;
/*  853 */   public static float sedStoneEff = 6.0F;
/*  854 */   public static float mMStoneEff = 6.5F;
/*      */   
/*  856 */   public static float copperEff = 8.0F;
/*      */   
/*  858 */   public static float bronzeEff = 11.0F;
/*  859 */   public static float bismuthBronzeEff = 10.0F;
/*  860 */   public static float blackBronzeEff = 9.0F;
/*      */   
/*  862 */   public static float wroughtIronEff = 12.0F;
/*      */   
/*  864 */   public static float steelEff = 14.0F;
/*      */   
/*  866 */   public static float blackSteelEff = 16.0F;
/*      */   
/*  868 */   public static float blueSteelEff = 18.0F;
/*  869 */   public static float redSteelEff = 18.0F;
/*      */   
/*      */   public static Item.ToolMaterial igInToolMaterial;
/*      */   
/*      */   public static Item.ToolMaterial sedToolMaterial;
/*      */   
/*      */   public static Item.ToolMaterial igExToolMaterial;
/*      */   
/*      */   public static Item.ToolMaterial mMToolMaterial;
/*      */   public static Item.ToolMaterial bismuthBronzeToolMaterial;
/*      */   public static Item.ToolMaterial blackBronzeToolMaterial;
/*      */   public static Item.ToolMaterial blackSteelToolMaterial;
/*      */   public static Item.ToolMaterial blueSteelToolMaterial;
/*      */   public static Item.ToolMaterial bronzeToolMaterial;
/*      */   public static Item.ToolMaterial copperToolMaterial;
/*      */   public static Item.ToolMaterial ironToolMaterial;
/*      */   public static Item.ToolMaterial redSteelToolMaterial;
/*      */   public static Item.ToolMaterial steelToolMaterial;
/*      */   public static List<Item> foodList;
/*      */   
/*      */   public static void registerItems() {
/*  890 */     TerraFirmaCraft.LOG.info("Registering Items");
/*      */     
/*  892 */     GameRegistry.registerItem(goldPan, goldPan.func_77658_a());
/*  893 */     GameRegistry.registerItem(sluiceItem, sluiceItem.func_77658_a());
/*      */     
/*  895 */     GameRegistry.registerItem(proPickBismuthBronze, proPickBismuthBronze.func_77658_a());
/*  896 */     GameRegistry.registerItem(proPickBlackBronze, proPickBlackBronze.func_77658_a());
/*  897 */     GameRegistry.registerItem(proPickBlackSteel, proPickBlackSteel.func_77658_a());
/*  898 */     GameRegistry.registerItem(proPickBlueSteel, proPickBlueSteel.func_77658_a());
/*  899 */     GameRegistry.registerItem(proPickBronze, proPickBronze.func_77658_a());
/*  900 */     GameRegistry.registerItem(proPickCopper, proPickCopper.func_77658_a());
/*  901 */     GameRegistry.registerItem(proPickIron, proPickIron.func_77658_a());
/*  902 */     GameRegistry.registerItem(proPickRedSteel, proPickRedSteel.func_77658_a());
/*  903 */     GameRegistry.registerItem(proPickSteel, proPickSteel.func_77658_a());
/*      */     
/*  905 */     GameRegistry.registerItem(bismuthIngot, bismuthIngot.func_77658_a());
/*  906 */     GameRegistry.registerItem(bismuthBronzeIngot, bismuthBronzeIngot.func_77658_a());
/*  907 */     GameRegistry.registerItem(blackBronzeIngot, blackBronzeIngot.func_77658_a());
/*  908 */     GameRegistry.registerItem(blackSteelIngot, blackSteelIngot.func_77658_a());
/*  909 */     GameRegistry.registerItem(blueSteelIngot, blueSteelIngot.func_77658_a());
/*  910 */     GameRegistry.registerItem(brassIngot, brassIngot.func_77658_a());
/*  911 */     GameRegistry.registerItem(bronzeIngot, bronzeIngot.func_77658_a());
/*  912 */     GameRegistry.registerItem(copperIngot, copperIngot.func_77658_a());
/*  913 */     GameRegistry.registerItem(goldIngot, goldIngot.func_77658_a());
/*  914 */     GameRegistry.registerItem(wroughtIronIngot, wroughtIronIngot.func_77658_a());
/*  915 */     GameRegistry.registerItem(leadIngot, leadIngot.func_77658_a());
/*  916 */     GameRegistry.registerItem(nickelIngot, nickelIngot.func_77658_a());
/*  917 */     GameRegistry.registerItem(pigIronIngot, pigIronIngot.func_77658_a());
/*  918 */     GameRegistry.registerItem(platinumIngot, platinumIngot.func_77658_a());
/*  919 */     GameRegistry.registerItem(redSteelIngot, redSteelIngot.func_77658_a());
/*  920 */     GameRegistry.registerItem(roseGoldIngot, roseGoldIngot.func_77658_a());
/*  921 */     GameRegistry.registerItem(silverIngot, silverIngot.func_77658_a());
/*  922 */     GameRegistry.registerItem(steelIngot, steelIngot.func_77658_a());
/*  923 */     GameRegistry.registerItem(sterlingSilverIngot, sterlingSilverIngot.func_77658_a());
/*  924 */     GameRegistry.registerItem(tinIngot, tinIngot.func_77658_a());
/*  925 */     GameRegistry.registerItem(zincIngot, zincIngot.func_77658_a());
/*  926 */     GameRegistry.registerItem(electrumIngot, electrumIngot.func_77658_a());
/*  927 */     GameRegistry.registerItem(cupronickelIngot, cupronickelIngot.func_77658_a());
/*      */     
/*  929 */     GameRegistry.registerItem(bismuthIngot2x, bismuthIngot2x.func_77658_a());
/*  930 */     GameRegistry.registerItem(bismuthBronzeIngot2x, bismuthBronzeIngot2x.func_77658_a());
/*  931 */     GameRegistry.registerItem(blackBronzeIngot2x, blackBronzeIngot2x.func_77658_a());
/*  932 */     GameRegistry.registerItem(blackSteelIngot2x, blackSteelIngot2x.func_77658_a());
/*  933 */     GameRegistry.registerItem(blueSteelIngot2x, blueSteelIngot2x.func_77658_a());
/*  934 */     GameRegistry.registerItem(brassIngot2x, brassIngot2x.func_77658_a());
/*  935 */     GameRegistry.registerItem(bronzeIngot2x, bronzeIngot2x.func_77658_a());
/*  936 */     GameRegistry.registerItem(copperIngot2x, copperIngot2x.func_77658_a());
/*  937 */     GameRegistry.registerItem(goldIngot2x, goldIngot2x.func_77658_a());
/*  938 */     GameRegistry.registerItem(wroughtIronIngot2x, wroughtIronIngot2x.func_77658_a());
/*  939 */     GameRegistry.registerItem(leadIngot2x, leadIngot2x.func_77658_a());
/*  940 */     GameRegistry.registerItem(nickelIngot2x, nickelIngot2x.func_77658_a());
/*  941 */     GameRegistry.registerItem(pigIronIngot2x, pigIronIngot2x.func_77658_a());
/*  942 */     GameRegistry.registerItem(platinumIngot2x, platinumIngot2x.func_77658_a());
/*  943 */     GameRegistry.registerItem(redSteelIngot2x, redSteelIngot2x.func_77658_a());
/*  944 */     GameRegistry.registerItem(roseGoldIngot2x, roseGoldIngot2x.func_77658_a());
/*  945 */     GameRegistry.registerItem(silverIngot2x, silverIngot2x.func_77658_a());
/*  946 */     GameRegistry.registerItem(steelIngot2x, steelIngot2x.func_77658_a());
/*  947 */     GameRegistry.registerItem(sterlingSilverIngot2x, sterlingSilverIngot2x.func_77658_a());
/*  948 */     GameRegistry.registerItem(tinIngot2x, tinIngot2x.func_77658_a());
/*  949 */     GameRegistry.registerItem(zincIngot2x, zincIngot2x.func_77658_a());
/*  950 */     GameRegistry.registerItem(electrumIngot2x, electrumIngot2x.func_77658_a());
/*  951 */     GameRegistry.registerItem(cupronickelIngot2x, cupronickelIngot2x.func_77658_a());
/*      */     
/*  953 */     GameRegistry.registerItem(gemRuby, gemRuby.func_77658_a());
/*  954 */     GameRegistry.registerItem(gemSapphire, gemSapphire.func_77658_a());
/*  955 */     GameRegistry.registerItem(gemEmerald, gemEmerald.func_77658_a());
/*  956 */     GameRegistry.registerItem(gemTopaz, gemTopaz.func_77658_a());
/*  957 */     GameRegistry.registerItem(gemTourmaline, gemTourmaline.func_77658_a());
/*  958 */     GameRegistry.registerItem(gemJade, gemJade.func_77658_a());
/*  959 */     GameRegistry.registerItem(gemBeryl, gemBeryl.func_77658_a());
/*  960 */     GameRegistry.registerItem(gemAgate, gemAgate.func_77658_a());
/*  961 */     GameRegistry.registerItem(gemOpal, gemOpal.func_77658_a());
/*  962 */     GameRegistry.registerItem(gemGarnet, gemGarnet.func_77658_a());
/*  963 */     GameRegistry.registerItem(gemJasper, gemJasper.func_77658_a());
/*  964 */     GameRegistry.registerItem(gemAmethyst, gemAmethyst.func_77658_a());
/*  965 */     GameRegistry.registerItem(gemDiamond, gemDiamond.func_77658_a());
/*      */     
/*  967 */     GameRegistry.registerItem(igInShovel, igInShovel.func_77658_a());
/*  968 */     GameRegistry.registerItem(igInAxe, igInAxe.func_77658_a());
/*  969 */     GameRegistry.registerItem(igInHoe, igInHoe.func_77658_a());
/*  970 */     GameRegistry.registerItem(sedShovel, sedShovel.func_77658_a());
/*  971 */     GameRegistry.registerItem(sedAxe, sedAxe.func_77658_a());
/*  972 */     GameRegistry.registerItem(sedHoe, sedHoe.func_77658_a());
/*  973 */     GameRegistry.registerItem(igExShovel, igExShovel.func_77658_a());
/*  974 */     GameRegistry.registerItem(igExAxe, igExAxe.func_77658_a());
/*  975 */     GameRegistry.registerItem(igExHoe, igExHoe.func_77658_a());
/*  976 */     GameRegistry.registerItem(mMShovel, mMShovel.func_77658_a());
/*  977 */     GameRegistry.registerItem(mMAxe, mMAxe.func_77658_a());
/*  978 */     GameRegistry.registerItem(mMHoe, mMHoe.func_77658_a());
/*      */     
/*  980 */     GameRegistry.registerItem(bismuthBronzePick, bismuthBronzePick.func_77658_a());
/*  981 */     GameRegistry.registerItem(bismuthBronzeShovel, bismuthBronzeShovel.func_77658_a());
/*  982 */     GameRegistry.registerItem(bismuthBronzeAxe, bismuthBronzeAxe.func_77658_a());
/*  983 */     GameRegistry.registerItem(bismuthBronzeHoe, bismuthBronzeHoe.func_77658_a());
/*      */     
/*  985 */     GameRegistry.registerItem(blackBronzePick, blackBronzePick.func_77658_a());
/*  986 */     GameRegistry.registerItem(blackBronzeShovel, blackBronzeShovel.func_77658_a());
/*  987 */     GameRegistry.registerItem(blackBronzeAxe, blackBronzeAxe.func_77658_a());
/*  988 */     GameRegistry.registerItem(blackBronzeHoe, blackBronzeHoe.func_77658_a());
/*      */     
/*  990 */     GameRegistry.registerItem(blackSteelPick, blackSteelPick.func_77658_a());
/*  991 */     GameRegistry.registerItem(blackSteelShovel, blackSteelShovel.func_77658_a());
/*  992 */     GameRegistry.registerItem(blackSteelAxe, blackSteelAxe.func_77658_a());
/*  993 */     GameRegistry.registerItem(blackSteelHoe, blackSteelHoe.func_77658_a());
/*      */     
/*  995 */     GameRegistry.registerItem(blueSteelPick, blueSteelPick.func_77658_a());
/*  996 */     GameRegistry.registerItem(blueSteelShovel, blueSteelShovel.func_77658_a());
/*  997 */     GameRegistry.registerItem(blueSteelAxe, blueSteelAxe.func_77658_a());
/*  998 */     GameRegistry.registerItem(blueSteelHoe, blueSteelHoe.func_77658_a());
/*      */     
/* 1000 */     GameRegistry.registerItem(bronzePick, bronzePick.func_77658_a());
/* 1001 */     GameRegistry.registerItem(bronzeShovel, bronzeShovel.func_77658_a());
/* 1002 */     GameRegistry.registerItem(bronzeAxe, bronzeAxe.func_77658_a());
/* 1003 */     GameRegistry.registerItem(bronzeHoe, bronzeHoe.func_77658_a());
/*      */     
/* 1005 */     GameRegistry.registerItem(copperPick, copperPick.func_77658_a());
/* 1006 */     GameRegistry.registerItem(copperShovel, copperShovel.func_77658_a());
/* 1007 */     GameRegistry.registerItem(copperAxe, copperAxe.func_77658_a());
/* 1008 */     GameRegistry.registerItem(copperHoe, copperHoe.func_77658_a());
/*      */     
/* 1010 */     GameRegistry.registerItem(wroughtIronPick, wroughtIronPick.func_77658_a());
/* 1011 */     GameRegistry.registerItem(wroughtIronShovel, wroughtIronShovel.func_77658_a());
/* 1012 */     GameRegistry.registerItem(wroughtIronAxe, wroughtIronAxe.func_77658_a());
/* 1013 */     GameRegistry.registerItem(wroughtIronHoe, wroughtIronHoe.func_77658_a());
/*      */     
/* 1015 */     GameRegistry.registerItem(redSteelPick, redSteelPick.func_77658_a());
/* 1016 */     GameRegistry.registerItem(redSteelShovel, redSteelShovel.func_77658_a());
/* 1017 */     GameRegistry.registerItem(redSteelAxe, redSteelAxe.func_77658_a());
/* 1018 */     GameRegistry.registerItem(redSteelHoe, redSteelHoe.func_77658_a());
/*      */     
/* 1020 */     GameRegistry.registerItem(steelPick, steelPick.func_77658_a());
/* 1021 */     GameRegistry.registerItem(steelShovel, steelShovel.func_77658_a());
/* 1022 */     GameRegistry.registerItem(steelAxe, steelAxe.func_77658_a());
/* 1023 */     GameRegistry.registerItem(steelHoe, steelHoe.func_77658_a());
/*      */     
/* 1025 */     GameRegistry.registerItem(bismuthBronzeChisel, bismuthBronzeChisel.func_77658_a());
/* 1026 */     GameRegistry.registerItem(blackBronzeChisel, blackBronzeChisel.func_77658_a());
/* 1027 */     GameRegistry.registerItem(blackSteelChisel, blackSteelChisel.func_77658_a());
/* 1028 */     GameRegistry.registerItem(blueSteelChisel, blueSteelChisel.func_77658_a());
/* 1029 */     GameRegistry.registerItem(bronzeChisel, bronzeChisel.func_77658_a());
/* 1030 */     GameRegistry.registerItem(copperChisel, copperChisel.func_77658_a());
/* 1031 */     GameRegistry.registerItem(wroughtIronChisel, wroughtIronChisel.func_77658_a());
/* 1032 */     GameRegistry.registerItem(redSteelChisel, redSteelChisel.func_77658_a());
/* 1033 */     GameRegistry.registerItem(steelChisel, steelChisel.func_77658_a());
/*      */     
/* 1035 */     GameRegistry.registerItem(bismuthBronzeSword, bismuthBronzeSword.func_77658_a());
/* 1036 */     GameRegistry.registerItem(blackBronzeSword, blackBronzeSword.func_77658_a());
/* 1037 */     GameRegistry.registerItem(blackSteelSword, blackSteelSword.func_77658_a());
/* 1038 */     GameRegistry.registerItem(blueSteelSword, blueSteelSword.func_77658_a());
/* 1039 */     GameRegistry.registerItem(bronzeSword, bronzeSword.func_77658_a());
/* 1040 */     GameRegistry.registerItem(copperSword, copperSword.func_77658_a());
/* 1041 */     GameRegistry.registerItem(wroughtIronSword, wroughtIronSword.func_77658_a());
/* 1042 */     GameRegistry.registerItem(redSteelSword, redSteelSword.func_77658_a());
/* 1043 */     GameRegistry.registerItem(steelSword, steelSword.func_77658_a());
/*      */     
/* 1045 */     GameRegistry.registerItem(bismuthBronzeMace, bismuthBronzeMace.func_77658_a());
/* 1046 */     GameRegistry.registerItem(blackBronzeMace, blackBronzeMace.func_77658_a());
/* 1047 */     GameRegistry.registerItem(blackSteelMace, blackSteelMace.func_77658_a());
/* 1048 */     GameRegistry.registerItem(blueSteelMace, blueSteelMace.func_77658_a());
/* 1049 */     GameRegistry.registerItem(bronzeMace, bronzeMace.func_77658_a());
/* 1050 */     GameRegistry.registerItem(copperMace, copperMace.func_77658_a());
/* 1051 */     GameRegistry.registerItem(wroughtIronMace, wroughtIronMace.func_77658_a());
/* 1052 */     GameRegistry.registerItem(redSteelMace, redSteelMace.func_77658_a());
/* 1053 */     GameRegistry.registerItem(steelMace, steelMace.func_77658_a());
/*      */     
/* 1055 */     GameRegistry.registerItem(bismuthBronzeSaw, bismuthBronzeSaw.func_77658_a());
/* 1056 */     GameRegistry.registerItem(blackBronzeSaw, blackBronzeSaw.func_77658_a());
/* 1057 */     GameRegistry.registerItem(blackSteelSaw, blackSteelSaw.func_77658_a());
/* 1058 */     GameRegistry.registerItem(blueSteelSaw, blueSteelSaw.func_77658_a());
/* 1059 */     GameRegistry.registerItem(bronzeSaw, bronzeSaw.func_77658_a());
/* 1060 */     GameRegistry.registerItem(copperSaw, copperSaw.func_77658_a());
/* 1061 */     GameRegistry.registerItem(wroughtIronSaw, wroughtIronSaw.func_77658_a());
/* 1062 */     GameRegistry.registerItem(redSteelSaw, redSteelSaw.func_77658_a());
/* 1063 */     GameRegistry.registerItem(steelSaw, steelSaw.func_77658_a());
/*      */     
/* 1065 */     GameRegistry.registerItem(highCarbonBlackSteelIngot, highCarbonBlackSteelIngot.func_77658_a());
/* 1066 */     GameRegistry.registerItem(weakBlueSteelIngot, weakBlueSteelIngot.func_77658_a());
/* 1067 */     GameRegistry.registerItem(weakRedSteelIngot, weakRedSteelIngot.func_77658_a());
/* 1068 */     GameRegistry.registerItem(weakSteelIngot, weakSteelIngot.func_77658_a());
/* 1069 */     GameRegistry.registerItem(highCarbonBlueSteelIngot, highCarbonBlueSteelIngot.func_77658_a());
/* 1070 */     GameRegistry.registerItem(highCarbonRedSteelIngot, highCarbonRedSteelIngot.func_77658_a());
/* 1071 */     GameRegistry.registerItem(highCarbonSteelIngot, highCarbonSteelIngot.func_77658_a());
/*      */     
/* 1073 */     GameRegistry.registerItem(smallMetalChunk, smallMetalChunk.func_77658_a());
/*      */     
/* 1075 */     GameRegistry.registerItem(oreChunk, oreChunk.func_77658_a());
/* 1076 */     GameRegistry.registerItem(smallOreChunk, smallOreChunk.func_77658_a());
/* 1077 */     GameRegistry.registerItem(logs, logs.func_77658_a());
/*      */     
/* 1079 */     GameRegistry.registerItem(igInStoneJavelin, igInStoneJavelin.func_77658_a());
/* 1080 */     GameRegistry.registerItem(sedStoneJavelin, sedStoneJavelin.func_77658_a());
/* 1081 */     GameRegistry.registerItem(igExStoneJavelin, igExStoneJavelin.func_77658_a());
/* 1082 */     GameRegistry.registerItem(mMStoneJavelin, mMStoneJavelin.func_77658_a());
/* 1083 */     GameRegistry.registerItem(copperJavelin, copperJavelin.func_77658_a());
/* 1084 */     GameRegistry.registerItem(bismuthBronzeJavelin, bismuthBronzeJavelin.func_77658_a());
/* 1085 */     GameRegistry.registerItem(bronzeJavelin, bronzeJavelin.func_77658_a());
/* 1086 */     GameRegistry.registerItem(blackBronzeJavelin, blackBronzeJavelin.func_77658_a());
/* 1087 */     GameRegistry.registerItem(wroughtIronJavelin, wroughtIronJavelin.func_77658_a());
/* 1088 */     GameRegistry.registerItem(steelJavelin, steelJavelin.func_77658_a());
/* 1089 */     GameRegistry.registerItem(blackSteelJavelin, blackSteelJavelin.func_77658_a());
/* 1090 */     GameRegistry.registerItem(blueSteelJavelin, blueSteelJavelin.func_77658_a());
/* 1091 */     GameRegistry.registerItem(redSteelJavelin, redSteelJavelin.func_77658_a());
/*      */     
/* 1093 */     GameRegistry.registerItem(igInStoneJavelinHead, igInStoneJavelinHead.func_77658_a());
/* 1094 */     GameRegistry.registerItem(sedStoneJavelinHead, sedStoneJavelinHead.func_77658_a());
/* 1095 */     GameRegistry.registerItem(igExStoneJavelinHead, igExStoneJavelinHead.func_77658_a());
/* 1096 */     GameRegistry.registerItem(mMStoneJavelinHead, mMStoneJavelinHead.func_77658_a());
/* 1097 */     GameRegistry.registerItem(copperJavelinHead, copperJavelinHead.func_77658_a());
/* 1098 */     GameRegistry.registerItem(bismuthBronzeJavelinHead, bismuthBronzeJavelinHead.func_77658_a());
/* 1099 */     GameRegistry.registerItem(bronzeJavelinHead, bronzeJavelinHead.func_77658_a());
/* 1100 */     GameRegistry.registerItem(blackBronzeJavelinHead, blackBronzeJavelinHead.func_77658_a());
/* 1101 */     GameRegistry.registerItem(wroughtIronJavelinHead, wroughtIronJavelinHead.func_77658_a());
/* 1102 */     GameRegistry.registerItem(steelJavelinHead, steelJavelinHead.func_77658_a());
/* 1103 */     GameRegistry.registerItem(blackSteelJavelinHead, blackSteelJavelinHead.func_77658_a());
/* 1104 */     GameRegistry.registerItem(blueSteelJavelinHead, blueSteelJavelinHead.func_77658_a());
/* 1105 */     GameRegistry.registerItem(redSteelJavelinHead, redSteelJavelinHead.func_77658_a());
/*      */     
/* 1107 */     GameRegistry.registerItem(bismuthUnshaped, bismuthUnshaped.func_77658_a());
/* 1108 */     GameRegistry.registerItem(bismuthBronzeUnshaped, bismuthBronzeUnshaped.func_77658_a());
/* 1109 */     GameRegistry.registerItem(blackBronzeUnshaped, blackBronzeUnshaped.func_77658_a());
/* 1110 */     GameRegistry.registerItem(blackSteelUnshaped, blackSteelUnshaped.func_77658_a());
/* 1111 */     GameRegistry.registerItem(blueSteelUnshaped, blueSteelUnshaped.func_77658_a());
/* 1112 */     GameRegistry.registerItem(brassUnshaped, brassUnshaped.func_77658_a());
/* 1113 */     GameRegistry.registerItem(bronzeUnshaped, bronzeUnshaped.func_77658_a());
/* 1114 */     GameRegistry.registerItem(copperUnshaped, copperUnshaped.func_77658_a());
/* 1115 */     GameRegistry.registerItem(goldUnshaped, goldUnshaped.func_77658_a());
/* 1116 */     GameRegistry.registerItem(wroughtIronUnshaped, wroughtIronUnshaped.func_77658_a());
/* 1117 */     GameRegistry.registerItem(leadUnshaped, leadUnshaped.func_77658_a());
/* 1118 */     GameRegistry.registerItem(nickelUnshaped, nickelUnshaped.func_77658_a());
/* 1119 */     GameRegistry.registerItem(pigIronUnshaped, pigIronUnshaped.func_77658_a());
/* 1120 */     GameRegistry.registerItem(platinumUnshaped, platinumUnshaped.func_77658_a());
/* 1121 */     GameRegistry.registerItem(redSteelUnshaped, redSteelUnshaped.func_77658_a());
/* 1122 */     GameRegistry.registerItem(roseGoldUnshaped, roseGoldUnshaped.func_77658_a());
/* 1123 */     GameRegistry.registerItem(silverUnshaped, silverUnshaped.func_77658_a());
/* 1124 */     GameRegistry.registerItem(steelUnshaped, steelUnshaped.func_77658_a());
/* 1125 */     GameRegistry.registerItem(sterlingSilverUnshaped, sterlingSilverUnshaped.func_77658_a());
/* 1126 */     GameRegistry.registerItem(tinUnshaped, tinUnshaped.func_77658_a());
/* 1127 */     GameRegistry.registerItem(zincUnshaped, zincUnshaped.func_77658_a());
/* 1128 */     GameRegistry.registerItem(electrumUnshaped, electrumUnshaped.func_77658_a());
/* 1129 */     GameRegistry.registerItem(cupronickelUnshaped, cupronickelUnshaped.func_77658_a());
/*      */     
/* 1131 */     GameRegistry.registerItem(stoneHammer, stoneHammer.func_77658_a());
/* 1132 */     GameRegistry.registerItem(bismuthBronzeHammer, bismuthBronzeHammer.func_77658_a());
/* 1133 */     GameRegistry.registerItem(blackBronzeHammer, blackBronzeHammer.func_77658_a());
/* 1134 */     GameRegistry.registerItem(blackSteelHammer, blackSteelHammer.func_77658_a());
/* 1135 */     GameRegistry.registerItem(blueSteelHammer, blueSteelHammer.func_77658_a());
/* 1136 */     GameRegistry.registerItem(bronzeHammer, bronzeHammer.func_77658_a());
/* 1137 */     GameRegistry.registerItem(copperHammer, copperHammer.func_77658_a());
/* 1138 */     GameRegistry.registerItem(wroughtIronHammer, wroughtIronHammer.func_77658_a());
/* 1139 */     GameRegistry.registerItem(redSteelHammer, redSteelHammer.func_77658_a());
/* 1140 */     GameRegistry.registerItem(steelHammer, steelHammer.func_77658_a());
/*      */     
/* 1142 */     GameRegistry.registerItem(ink, ink.func_77658_a());
/* 1143 */     GameRegistry.registerItem(fireStarter, fireStarter.func_77658_a());
/*      */     
/* 1145 */     GameRegistry.registerItem(bismuthBronzePickaxeHead, bismuthBronzePickaxeHead.func_77658_a());
/* 1146 */     GameRegistry.registerItem(blackBronzePickaxeHead, blackBronzePickaxeHead.func_77658_a());
/* 1147 */     GameRegistry.registerItem(blackSteelPickaxeHead, blackSteelPickaxeHead.func_77658_a());
/* 1148 */     GameRegistry.registerItem(blueSteelPickaxeHead, blueSteelPickaxeHead.func_77658_a());
/* 1149 */     GameRegistry.registerItem(bronzePickaxeHead, bronzePickaxeHead.func_77658_a());
/* 1150 */     GameRegistry.registerItem(copperPickaxeHead, copperPickaxeHead.func_77658_a());
/* 1151 */     GameRegistry.registerItem(wroughtIronPickaxeHead, wroughtIronPickaxeHead.func_77658_a());
/* 1152 */     GameRegistry.registerItem(redSteelPickaxeHead, redSteelPickaxeHead.func_77658_a());
/* 1153 */     GameRegistry.registerItem(steelPickaxeHead, steelPickaxeHead.func_77658_a());
/*      */     
/* 1155 */     GameRegistry.registerItem(bismuthBronzeShovelHead, bismuthBronzeShovelHead.func_77658_a());
/* 1156 */     GameRegistry.registerItem(blackBronzeShovelHead, blackBronzeShovelHead.func_77658_a());
/* 1157 */     GameRegistry.registerItem(blackSteelShovelHead, blackSteelShovelHead.func_77658_a());
/* 1158 */     GameRegistry.registerItem(blueSteelShovelHead, blueSteelShovelHead.func_77658_a());
/* 1159 */     GameRegistry.registerItem(bronzeShovelHead, bronzeShovelHead.func_77658_a());
/* 1160 */     GameRegistry.registerItem(copperShovelHead, copperShovelHead.func_77658_a());
/* 1161 */     GameRegistry.registerItem(wroughtIronShovelHead, wroughtIronShovelHead.func_77658_a());
/* 1162 */     GameRegistry.registerItem(redSteelShovelHead, redSteelShovelHead.func_77658_a());
/* 1163 */     GameRegistry.registerItem(steelShovelHead, steelShovelHead.func_77658_a());
/*      */     
/* 1165 */     GameRegistry.registerItem(bismuthBronzeHoeHead, bismuthBronzeHoeHead.func_77658_a());
/* 1166 */     GameRegistry.registerItem(blackBronzeHoeHead, blackBronzeHoeHead.func_77658_a());
/* 1167 */     GameRegistry.registerItem(blackSteelHoeHead, blackSteelHoeHead.func_77658_a());
/* 1168 */     GameRegistry.registerItem(blueSteelHoeHead, blueSteelHoeHead.func_77658_a());
/* 1169 */     GameRegistry.registerItem(bronzeHoeHead, bronzeHoeHead.func_77658_a());
/* 1170 */     GameRegistry.registerItem(copperHoeHead, copperHoeHead.func_77658_a());
/* 1171 */     GameRegistry.registerItem(wroughtIronHoeHead, wroughtIronHoeHead.func_77658_a());
/* 1172 */     GameRegistry.registerItem(redSteelHoeHead, redSteelHoeHead.func_77658_a());
/* 1173 */     GameRegistry.registerItem(steelHoeHead, steelHoeHead.func_77658_a());
/*      */     
/* 1175 */     GameRegistry.registerItem(bismuthBronzeAxeHead, bismuthBronzeAxeHead.func_77658_a());
/* 1176 */     GameRegistry.registerItem(blackBronzeAxeHead, blackBronzeAxeHead.func_77658_a());
/* 1177 */     GameRegistry.registerItem(blackSteelAxeHead, blackSteelAxeHead.func_77658_a());
/* 1178 */     GameRegistry.registerItem(blueSteelAxeHead, blueSteelAxeHead.func_77658_a());
/* 1179 */     GameRegistry.registerItem(bronzeAxeHead, bronzeAxeHead.func_77658_a());
/* 1180 */     GameRegistry.registerItem(copperAxeHead, copperAxeHead.func_77658_a());
/* 1181 */     GameRegistry.registerItem(wroughtIronAxeHead, wroughtIronAxeHead.func_77658_a());
/* 1182 */     GameRegistry.registerItem(redSteelAxeHead, redSteelAxeHead.func_77658_a());
/* 1183 */     GameRegistry.registerItem(steelAxeHead, steelAxeHead.func_77658_a());
/*      */     
/* 1185 */     GameRegistry.registerItem(bismuthBronzeHammerHead, bismuthBronzeHammerHead.func_77658_a());
/* 1186 */     GameRegistry.registerItem(blackBronzeHammerHead, blackBronzeHammerHead.func_77658_a());
/* 1187 */     GameRegistry.registerItem(blackSteelHammerHead, blackSteelHammerHead.func_77658_a());
/* 1188 */     GameRegistry.registerItem(blueSteelHammerHead, blueSteelHammerHead.func_77658_a());
/* 1189 */     GameRegistry.registerItem(bronzeHammerHead, bronzeHammerHead.func_77658_a());
/* 1190 */     GameRegistry.registerItem(copperHammerHead, copperHammerHead.func_77658_a());
/* 1191 */     GameRegistry.registerItem(wroughtIronHammerHead, wroughtIronHammerHead.func_77658_a());
/* 1192 */     GameRegistry.registerItem(redSteelHammerHead, redSteelHammerHead.func_77658_a());
/* 1193 */     GameRegistry.registerItem(steelHammerHead, steelHammerHead.func_77658_a());
/*      */     
/* 1195 */     GameRegistry.registerItem(bismuthBronzeChiselHead, bismuthBronzeChiselHead.func_77658_a());
/* 1196 */     GameRegistry.registerItem(blackBronzeChiselHead, blackBronzeChiselHead.func_77658_a());
/* 1197 */     GameRegistry.registerItem(blackSteelChiselHead, blackSteelChiselHead.func_77658_a());
/* 1198 */     GameRegistry.registerItem(blueSteelChiselHead, blueSteelChiselHead.func_77658_a());
/* 1199 */     GameRegistry.registerItem(bronzeChiselHead, bronzeChiselHead.func_77658_a());
/* 1200 */     GameRegistry.registerItem(copperChiselHead, copperChiselHead.func_77658_a());
/* 1201 */     GameRegistry.registerItem(wroughtIronChiselHead, wroughtIronChiselHead.func_77658_a());
/* 1202 */     GameRegistry.registerItem(redSteelChiselHead, redSteelChiselHead.func_77658_a());
/* 1203 */     GameRegistry.registerItem(steelChiselHead, steelChiselHead.func_77658_a());
/*      */     
/* 1205 */     GameRegistry.registerItem(bismuthBronzeSwordHead, bismuthBronzeSwordHead.func_77658_a());
/* 1206 */     GameRegistry.registerItem(blackBronzeSwordHead, blackBronzeSwordHead.func_77658_a());
/* 1207 */     GameRegistry.registerItem(blackSteelSwordHead, blackSteelSwordHead.func_77658_a());
/* 1208 */     GameRegistry.registerItem(blueSteelSwordHead, blueSteelSwordHead.func_77658_a());
/* 1209 */     GameRegistry.registerItem(bronzeSwordHead, bronzeSwordHead.func_77658_a());
/* 1210 */     GameRegistry.registerItem(copperSwordHead, copperSwordHead.func_77658_a());
/* 1211 */     GameRegistry.registerItem(wroughtIronSwordHead, wroughtIronSwordHead.func_77658_a());
/* 1212 */     GameRegistry.registerItem(redSteelSwordHead, redSteelSwordHead.func_77658_a());
/* 1213 */     GameRegistry.registerItem(steelSwordHead, steelSwordHead.func_77658_a());
/*      */     
/* 1215 */     GameRegistry.registerItem(bismuthBronzeMaceHead, bismuthBronzeMaceHead.func_77658_a());
/* 1216 */     GameRegistry.registerItem(blackBronzeMaceHead, blackBronzeMaceHead.func_77658_a());
/* 1217 */     GameRegistry.registerItem(blackSteelMaceHead, blackSteelMaceHead.func_77658_a());
/* 1218 */     GameRegistry.registerItem(blueSteelMaceHead, blueSteelMaceHead.func_77658_a());
/* 1219 */     GameRegistry.registerItem(bronzeMaceHead, bronzeMaceHead.func_77658_a());
/* 1220 */     GameRegistry.registerItem(copperMaceHead, copperMaceHead.func_77658_a());
/* 1221 */     GameRegistry.registerItem(wroughtIronMaceHead, wroughtIronMaceHead.func_77658_a());
/* 1222 */     GameRegistry.registerItem(redSteelMaceHead, redSteelMaceHead.func_77658_a());
/* 1223 */     GameRegistry.registerItem(steelMaceHead, steelMaceHead.func_77658_a());
/*      */     
/* 1225 */     GameRegistry.registerItem(bismuthBronzeSawHead, bismuthBronzeSawHead.func_77658_a());
/* 1226 */     GameRegistry.registerItem(blackBronzeSawHead, blackBronzeSawHead.func_77658_a());
/* 1227 */     GameRegistry.registerItem(blackSteelSawHead, blackSteelSawHead.func_77658_a());
/* 1228 */     GameRegistry.registerItem(blueSteelSawHead, blueSteelSawHead.func_77658_a());
/* 1229 */     GameRegistry.registerItem(bronzeSawHead, bronzeSawHead.func_77658_a());
/* 1230 */     GameRegistry.registerItem(copperSawHead, copperSawHead.func_77658_a());
/* 1231 */     GameRegistry.registerItem(wroughtIronSawHead, wroughtIronSawHead.func_77658_a());
/* 1232 */     GameRegistry.registerItem(redSteelSawHead, redSteelSawHead.func_77658_a());
/* 1233 */     GameRegistry.registerItem(steelSawHead, steelSawHead.func_77658_a());
/*      */     
/* 1235 */     GameRegistry.registerItem(highCarbonBlackSteelUnshaped, highCarbonBlackSteelUnshaped.func_77658_a());
/* 1236 */     GameRegistry.registerItem(weakBlueSteelUnshaped, weakBlueSteelUnshaped.func_77658_a());
/* 1237 */     GameRegistry.registerItem(highCarbonBlueSteelUnshaped, highCarbonBlueSteelUnshaped.func_77658_a());
/* 1238 */     GameRegistry.registerItem(weakRedSteelUnshaped, weakRedSteelUnshaped.func_77658_a());
/* 1239 */     GameRegistry.registerItem(highCarbonRedSteelUnshaped, highCarbonRedSteelUnshaped.func_77658_a());
/* 1240 */     GameRegistry.registerItem(weakSteelUnshaped, weakSteelUnshaped.func_77658_a());
/* 1241 */     GameRegistry.registerItem(highCarbonSteelUnshaped, highCarbonSteelUnshaped.func_77658_a());
/*      */ 
/*      */ 
/*      */     
/* 1245 */     GameRegistry.registerItem(bismuthBronzeProPickHead, bismuthBronzeProPickHead.func_77658_a());
/* 1246 */     GameRegistry.registerItem(blackBronzeProPickHead, blackBronzeProPickHead.func_77658_a());
/* 1247 */     GameRegistry.registerItem(blackSteelProPickHead, blackSteelProPickHead.func_77658_a());
/* 1248 */     GameRegistry.registerItem(blueSteelProPickHead, blueSteelProPickHead.func_77658_a());
/* 1249 */     GameRegistry.registerItem(bronzeProPickHead, bronzeProPickHead.func_77658_a());
/* 1250 */     GameRegistry.registerItem(copperProPickHead, copperProPickHead.func_77658_a());
/* 1251 */     GameRegistry.registerItem(wroughtIronProPickHead, wroughtIronProPickHead.func_77658_a());
/* 1252 */     GameRegistry.registerItem(redSteelProPickHead, redSteelProPickHead.func_77658_a());
/* 1253 */     GameRegistry.registerItem(steelProPickHead, steelProPickHead.func_77658_a());
/*      */     
/* 1255 */     GameRegistry.registerItem(bismuthBronzeScythe, bismuthBronzeScythe.func_77658_a());
/* 1256 */     GameRegistry.registerItem(blackBronzeScythe, blackBronzeScythe.func_77658_a());
/* 1257 */     GameRegistry.registerItem(blackSteelScythe, blackSteelScythe.func_77658_a());
/* 1258 */     GameRegistry.registerItem(blueSteelScythe, blueSteelScythe.func_77658_a());
/* 1259 */     GameRegistry.registerItem(bronzeScythe, bronzeScythe.func_77658_a());
/* 1260 */     GameRegistry.registerItem(copperScythe, copperScythe.func_77658_a());
/* 1261 */     GameRegistry.registerItem(wroughtIronScythe, wroughtIronScythe.func_77658_a());
/* 1262 */     GameRegistry.registerItem(redSteelScythe, redSteelScythe.func_77658_a());
/* 1263 */     GameRegistry.registerItem(steelScythe, steelScythe.func_77658_a());
/*      */     
/* 1265 */     GameRegistry.registerItem(bismuthBronzeScytheHead, bismuthBronzeScytheHead.func_77658_a());
/* 1266 */     GameRegistry.registerItem(blackBronzeScytheHead, blackBronzeScytheHead.func_77658_a());
/* 1267 */     GameRegistry.registerItem(blackSteelScytheHead, blackSteelScytheHead.func_77658_a());
/* 1268 */     GameRegistry.registerItem(blueSteelScytheHead, blueSteelScytheHead.func_77658_a());
/* 1269 */     GameRegistry.registerItem(bronzeScytheHead, bronzeScytheHead.func_77658_a());
/* 1270 */     GameRegistry.registerItem(copperScytheHead, copperScytheHead.func_77658_a());
/* 1271 */     GameRegistry.registerItem(wroughtIronScytheHead, wroughtIronScytheHead.func_77658_a());
/* 1272 */     GameRegistry.registerItem(redSteelScytheHead, redSteelScytheHead.func_77658_a());
/* 1273 */     GameRegistry.registerItem(steelScytheHead, steelScytheHead.func_77658_a());
/*      */     
/* 1275 */     GameRegistry.registerItem(woodenBucketEmpty, woodenBucketEmpty.func_77658_a());
/* 1276 */     GameRegistry.registerItem(woodenBucketWater, woodenBucketWater.func_77658_a());
/* 1277 */     GameRegistry.registerItem(woodenBucketSaltWater, woodenBucketSaltWater.func_77658_a());
/* 1278 */     GameRegistry.registerItem(woodenBucketMilk, woodenBucketMilk.func_77658_a());
/*      */     
/* 1280 */     GameRegistry.registerItem(bismuthBronzeKnifeHead, bismuthBronzeKnifeHead.func_77658_a());
/* 1281 */     GameRegistry.registerItem(blackBronzeKnifeHead, blackBronzeKnifeHead.func_77658_a());
/* 1282 */     GameRegistry.registerItem(blackSteelKnifeHead, blackSteelKnifeHead.func_77658_a());
/* 1283 */     GameRegistry.registerItem(blueSteelKnifeHead, blueSteelKnifeHead.func_77658_a());
/* 1284 */     GameRegistry.registerItem(bronzeKnifeHead, bronzeKnifeHead.func_77658_a());
/* 1285 */     GameRegistry.registerItem(copperKnifeHead, copperKnifeHead.func_77658_a());
/* 1286 */     GameRegistry.registerItem(wroughtIronKnifeHead, wroughtIronKnifeHead.func_77658_a());
/* 1287 */     GameRegistry.registerItem(redSteelKnifeHead, redSteelKnifeHead.func_77658_a());
/* 1288 */     GameRegistry.registerItem(steelKnifeHead, steelKnifeHead.func_77658_a());
/*      */     
/* 1290 */     GameRegistry.registerItem(bismuthBronzeKnife, bismuthBronzeKnife.func_77658_a());
/* 1291 */     GameRegistry.registerItem(blackBronzeKnife, blackBronzeKnife.func_77658_a());
/* 1292 */     GameRegistry.registerItem(blackSteelKnife, blackSteelKnife.func_77658_a());
/* 1293 */     GameRegistry.registerItem(blueSteelKnife, blueSteelKnife.func_77658_a());
/* 1294 */     GameRegistry.registerItem(bronzeKnife, bronzeKnife.func_77658_a());
/* 1295 */     GameRegistry.registerItem(copperKnife, copperKnife.func_77658_a());
/* 1296 */     GameRegistry.registerItem(wroughtIronKnife, wroughtIronKnife.func_77658_a());
/* 1297 */     GameRegistry.registerItem(redSteelKnife, redSteelKnife.func_77658_a());
/* 1298 */     GameRegistry.registerItem(steelKnife, steelKnife.func_77658_a());
/*      */     
/* 1300 */     GameRegistry.registerItem(flatRock, flatRock.func_77658_a());
/* 1301 */     GameRegistry.registerItem(looseRock, looseRock.func_77658_a());
/*      */     
/* 1303 */     GameRegistry.registerItem(igInStoneShovelHead, igInStoneShovelHead.func_77658_a());
/* 1304 */     GameRegistry.registerItem(sedStoneShovelHead, sedStoneShovelHead.func_77658_a());
/* 1305 */     GameRegistry.registerItem(igExStoneShovelHead, igExStoneShovelHead.func_77658_a());
/* 1306 */     GameRegistry.registerItem(mMStoneShovelHead, mMStoneShovelHead.func_77658_a());
/*      */     
/* 1308 */     GameRegistry.registerItem(igInStoneAxeHead, igInStoneAxeHead.func_77658_a());
/* 1309 */     GameRegistry.registerItem(sedStoneAxeHead, sedStoneAxeHead.func_77658_a());
/* 1310 */     GameRegistry.registerItem(igExStoneAxeHead, igExStoneAxeHead.func_77658_a());
/* 1311 */     GameRegistry.registerItem(mMStoneAxeHead, mMStoneAxeHead.func_77658_a());
/*      */     
/* 1313 */     GameRegistry.registerItem(igInStoneHoeHead, igInStoneHoeHead.func_77658_a());
/* 1314 */     GameRegistry.registerItem(sedStoneHoeHead, sedStoneHoeHead.func_77658_a());
/* 1315 */     GameRegistry.registerItem(igExStoneHoeHead, igExStoneHoeHead.func_77658_a());
/* 1316 */     GameRegistry.registerItem(mMStoneHoeHead, mMStoneHoeHead.func_77658_a());
/*      */     
/* 1318 */     GameRegistry.registerItem(stoneKnifeHead, stoneKnifeHead.func_77658_a());
/* 1319 */     GameRegistry.registerItem(stoneHammerHead, stoneHammerHead.func_77658_a());
/* 1320 */     GameRegistry.registerItem(stoneKnife, stoneKnife.func_77658_a());
/*      */     
/* 1322 */     GameRegistry.registerItem(singlePlank, singlePlank.func_77658_a());
/*      */     
/* 1324 */     GameRegistry.registerItem(redSteelBucketEmpty, redSteelBucketEmpty.func_77658_a());
/* 1325 */     GameRegistry.registerItem(redSteelBucketWater, redSteelBucketWater.func_77658_a());
/* 1326 */     GameRegistry.registerItem(redSteelBucketSaltWater, redSteelBucketSaltWater.func_77658_a());
/* 1327 */     GameRegistry.registerItem(blueSteelBucketEmpty, blueSteelBucketEmpty.func_77658_a());
/* 1328 */     GameRegistry.registerItem(blueSteelBucketLava, blueSteelBucketLava.func_77658_a());
/*      */     
/* 1330 */     GameRegistry.registerItem(quern, quern.func_77658_a());
/* 1331 */     GameRegistry.registerItem(flintSteel, flintSteel.func_77658_a());
/*      */     
/* 1333 */     GameRegistry.registerItem(doorOak, doorOak.func_77658_a());
/* 1334 */     GameRegistry.registerItem(doorAspen, doorAspen.func_77658_a());
/* 1335 */     GameRegistry.registerItem(doorBirch, doorBirch.func_77658_a());
/* 1336 */     GameRegistry.registerItem(doorChestnut, doorChestnut.func_77658_a());
/* 1337 */     GameRegistry.registerItem(doorDouglasFir, doorDouglasFir.func_77658_a());
/* 1338 */     GameRegistry.registerItem(doorHickory, doorHickory.func_77658_a());
/* 1339 */     GameRegistry.registerItem(doorMaple, doorMaple.func_77658_a());
/* 1340 */     GameRegistry.registerItem(doorAsh, doorAsh.func_77658_a());
/* 1341 */     GameRegistry.registerItem(doorPine, doorPine.func_77658_a());
/* 1342 */     GameRegistry.registerItem(doorSequoia, doorSequoia.func_77658_a());
/* 1343 */     GameRegistry.registerItem(doorSpruce, doorSpruce.func_77658_a());
/* 1344 */     GameRegistry.registerItem(doorSycamore, doorSycamore.func_77658_a());
/* 1345 */     GameRegistry.registerItem(doorWhiteCedar, doorWhiteCedar.func_77658_a());
/* 1346 */     GameRegistry.registerItem(doorWhiteElm, doorWhiteElm.func_77658_a());
/* 1347 */     GameRegistry.registerItem(doorWillow, doorWillow.func_77658_a());
/* 1348 */     GameRegistry.registerItem(doorKapok, doorKapok.func_77658_a());
/* 1349 */     GameRegistry.registerItem(doorAcacia, doorAcacia.func_77658_a());
/*      */     
/* 1351 */     GameRegistry.registerItem(glassBottle, glassBottle.func_77658_a());
/* 1352 */     GameRegistry.registerItem(beer, beer.func_77658_a());
/* 1353 */     GameRegistry.registerItem(cider, cider.func_77658_a());
/* 1354 */     GameRegistry.registerItem(rum, rum.func_77658_a());
/* 1355 */     GameRegistry.registerItem(ryeWhiskey, ryeWhiskey.func_77658_a());
/* 1356 */     GameRegistry.registerItem(sake, sake.func_77658_a());
/* 1357 */     GameRegistry.registerItem(vodka, vodka.func_77658_a());
/* 1358 */     GameRegistry.registerItem(whiskey, whiskey.func_77658_a());
/* 1359 */     GameRegistry.registerItem(cornWhiskey, cornWhiskey.func_77658_a());
/*      */     
/* 1361 */     GameRegistry.registerItem(blueprint, blueprint.func_77658_a());
/* 1362 */     GameRegistry.registerItem(nametag, nametag.func_77658_a());
/*      */     
/* 1364 */     GameRegistry.registerItem(woolYarn, woolYarn.func_77658_a());
/* 1365 */     GameRegistry.registerItem(wool, wool.func_77658_a());
/* 1366 */     GameRegistry.registerItem(woolCloth, woolCloth.func_77658_a());
/* 1367 */     GameRegistry.registerItem(silkCloth, silkCloth.func_77658_a());
/* 1368 */     GameRegistry.registerItem(burlapCloth, burlapCloth.func_77658_a());
/* 1369 */     GameRegistry.registerItem(spindle, spindle.func_77658_a());
/* 1370 */     GameRegistry.registerItem(spindleHead, spindleHead.func_77658_a());
/* 1371 */     GameRegistry.registerItem(stoneBrick, stoneBrick.func_77658_a());
/*      */     
/* 1373 */     GameRegistry.registerItem(mortar, mortar.func_77658_a());
/* 1374 */     GameRegistry.registerItem(vinegar, vinegar.func_77658_a());
/*      */     
/* 1376 */     GameRegistry.registerItem(hide, hide.func_77658_a());
/* 1377 */     GameRegistry.registerItem(soakedHide, soakedHide.func_77658_a());
/* 1378 */     GameRegistry.registerItem(scrapedHide, scrapedHide.func_77658_a());
/* 1379 */     GameRegistry.registerItem(prepHide, prepHide.func_77658_a());
/* 1380 */     GameRegistry.registerItem(sheepSkin, sheepSkin.func_77658_a());
/* 1381 */     GameRegistry.registerItem(pbearSkin, pbearSkin.func_77658_a());
/* 1382 */     GameRegistry.registerItem(flatLeather, flatLeather.func_77658_a());
/* 1383 */     GameRegistry.registerItem(leather, leather.func_77658_a());
/* 1384 */     GameRegistry.registerItem(straw, straw.func_77658_a());
/* 1385 */     GameRegistry.registerItem(flatClay, flatClay.func_77658_a());
/*      */     
/* 1387 */     GameRegistry.registerItem(potteryJug, potteryJug.func_77658_a());
/* 1388 */     GameRegistry.registerItem(potterySmallVessel, potterySmallVessel.func_77658_a());
/* 1389 */     GameRegistry.registerItem(potteryBowl, potteryBowl.func_77658_a());
/*      */ 
/*      */     
/* 1392 */     GameRegistry.registerItem(ceramicMold, ceramicMold.func_77658_a());
/* 1393 */     GameRegistry.registerItem(fireBrick, fireBrick.func_77658_a());
/*      */     
/* 1395 */     GameRegistry.registerItem(clayMoldAxe, clayMoldAxe.func_77658_a());
/* 1396 */     GameRegistry.registerItem(clayMoldChisel, clayMoldChisel.func_77658_a());
/* 1397 */     GameRegistry.registerItem(clayMoldHammer, clayMoldHammer.func_77658_a());
/* 1398 */     GameRegistry.registerItem(clayMoldHoe, clayMoldHoe.func_77658_a());
/* 1399 */     GameRegistry.registerItem(clayMoldKnife, clayMoldKnife.func_77658_a());
/* 1400 */     GameRegistry.registerItem(clayMoldMace, clayMoldMace.func_77658_a());
/* 1401 */     GameRegistry.registerItem(clayMoldPick, clayMoldPick.func_77658_a());
/* 1402 */     GameRegistry.registerItem(clayMoldProPick, clayMoldProPick.func_77658_a());
/* 1403 */     GameRegistry.registerItem(clayMoldSaw, clayMoldSaw.func_77658_a());
/* 1404 */     GameRegistry.registerItem(clayMoldScythe, clayMoldScythe.func_77658_a());
/* 1405 */     GameRegistry.registerItem(clayMoldShovel, clayMoldShovel.func_77658_a());
/* 1406 */     GameRegistry.registerItem(clayMoldSword, clayMoldSword.func_77658_a());
/* 1407 */     GameRegistry.registerItem(clayMoldJavelin, clayMoldJavelin.func_77658_a());
/*      */     
/* 1409 */     GameRegistry.registerItem(tuyereCopper, tuyereCopper.func_77658_a());
/* 1410 */     GameRegistry.registerItem(tuyereBronze, tuyereBronze.func_77658_a());
/* 1411 */     GameRegistry.registerItem(tuyereBlackBronze, tuyereBlackBronze.func_77658_a());
/* 1412 */     GameRegistry.registerItem(tuyereBismuthBronze, tuyereBismuthBronze.func_77658_a());
/* 1413 */     GameRegistry.registerItem(tuyereWroughtIron, tuyereWroughtIron.func_77658_a());
/* 1414 */     GameRegistry.registerItem(tuyereSteel, tuyereSteel.func_77658_a());
/* 1415 */     GameRegistry.registerItem(tuyereBlackSteel, tuyereBlackSteel.func_77658_a());
/* 1416 */     GameRegistry.registerItem(tuyereRedSteel, tuyereRedSteel.func_77658_a());
/* 1417 */     GameRegistry.registerItem(tuyereBlueSteel, tuyereBlueSteel.func_77658_a());
/*      */     
/* 1419 */     GameRegistry.registerItem(bloom, bloom.func_77658_a());
/* 1420 */     GameRegistry.registerItem(rawBloom, rawBloom.func_77658_a());
/*      */     
/* 1422 */     GameRegistry.registerItem(unknownIngot, unknownIngot.func_77658_a());
/* 1423 */     GameRegistry.registerItem(unknownUnshaped, unknownUnshaped.func_77658_a());
/*      */     
/* 1425 */     GameRegistry.registerItem(jute, jute.func_77658_a());
/* 1426 */     GameRegistry.registerItem(juteFiber, juteFiber.func_77658_a());
/* 1427 */     GameRegistry.registerItem(reeds, reeds.func_77658_a());
/*      */     
/* 1429 */     GameRegistry.registerItem(fishingRod, fishingRod.func_77658_a());
/* 1430 */     GameRegistry.registerItem(coal, coal.func_77658_a());
/* 1431 */     GameRegistry.registerItem(stick, stick.func_77658_a());
/* 1432 */     GameRegistry.registerItem(bow, bow.func_77658_a());
/* 1433 */     GameRegistry.registerItem(arrow, arrow.func_77658_a());
/* 1434 */     GameRegistry.registerItem(dye, dye.func_77658_a());
/* 1435 */     GameRegistry.registerItem(rope, rope.func_77658_a());
/* 1436 */     GameRegistry.registerItem(clayBall, clayBall.func_77658_a());
/* 1437 */     GameRegistry.registerItem(powder, powder.func_77658_a());
/* 1438 */     GameRegistry.registerItem(fertilizer, fertilizer.func_77658_a());
/*      */ 
/*      */     
/* 1441 */     TerraFirmaCraft.LOG.info("Registering Food");
/* 1442 */     GameRegistry.registerItem(fruitTreeSapling, fruitTreeSapling.func_77658_a());
/* 1443 */     GameRegistry.registerItem(redApple, redApple.func_77658_a());
/* 1444 */     GameRegistry.registerItem(banana, banana.func_77658_a());
/* 1445 */     GameRegistry.registerItem(orange, orange.func_77658_a());
/* 1446 */     GameRegistry.registerItem(greenApple, greenApple.func_77658_a());
/* 1447 */     GameRegistry.registerItem(lemon, lemon.func_77658_a());
/* 1448 */     GameRegistry.registerItem(olive, olive.func_77658_a());
/* 1449 */     GameRegistry.registerItem(cherry, cherry.func_77658_a());
/* 1450 */     GameRegistry.registerItem(peach, peach.func_77658_a());
/* 1451 */     GameRegistry.registerItem(plum, plum.func_77658_a());
/* 1452 */     GameRegistry.registerItem(egg, egg.func_77658_a());
/* 1453 */     GameRegistry.registerItem(eggCooked, eggCooked.func_77658_a());
/* 1454 */     GameRegistry.registerItem(wheatGrain, wheatGrain.func_77658_a());
/* 1455 */     GameRegistry.registerItem(barleyGrain, barleyGrain.func_77658_a());
/* 1456 */     GameRegistry.registerItem(oatGrain, oatGrain.func_77658_a());
/* 1457 */     GameRegistry.registerItem(ryeGrain, ryeGrain.func_77658_a());
/* 1458 */     GameRegistry.registerItem(riceGrain, riceGrain.func_77658_a());
/* 1459 */     GameRegistry.registerItem(maizeEar, maizeEar.func_77658_a());
/* 1460 */     GameRegistry.registerItem(tomato, tomato.func_77658_a());
/* 1461 */     GameRegistry.registerItem(potato, potato.func_77658_a());
/* 1462 */     GameRegistry.registerItem(onion, onion.func_77658_a());
/* 1463 */     GameRegistry.registerItem(cabbage, cabbage.func_77658_a());
/* 1464 */     GameRegistry.registerItem(garlic, garlic.func_77658_a());
/* 1465 */     GameRegistry.registerItem(carrot, carrot.func_77658_a());
/* 1466 */     GameRegistry.registerItem(sugarcane, sugarcane.func_77658_a());
/*      */     
/* 1468 */     GameRegistry.registerItem(soybean, soybean.func_77658_a());
/* 1469 */     GameRegistry.registerItem(greenbeans, greenbeans.func_77658_a());
/* 1470 */     GameRegistry.registerItem(greenBellPepper, greenBellPepper.func_77658_a());
/* 1471 */     GameRegistry.registerItem(yellowBellPepper, yellowBellPepper.func_77658_a());
/* 1472 */     GameRegistry.registerItem(redBellPepper, redBellPepper.func_77658_a());
/* 1473 */     GameRegistry.registerItem(squash, squash.func_77658_a());
/* 1474 */     GameRegistry.registerItem(cheese, cheese.func_77658_a());
/* 1475 */     GameRegistry.registerItem(wheatWhole, wheatWhole.func_77658_a());
/* 1476 */     GameRegistry.registerItem(barleyWhole, barleyWhole.func_77658_a());
/* 1477 */     GameRegistry.registerItem(oatWhole, oatWhole.func_77658_a());
/* 1478 */     GameRegistry.registerItem(ryeWhole, ryeWhole.func_77658_a());
/* 1479 */     GameRegistry.registerItem(riceWhole, riceWhole.func_77658_a());
/* 1480 */     GameRegistry.registerItem(wheatGround, wheatGround.func_77658_a());
/* 1481 */     GameRegistry.registerItem(barleyGround, barleyGround.func_77658_a());
/* 1482 */     GameRegistry.registerItem(oatGround, oatGround.func_77658_a());
/* 1483 */     GameRegistry.registerItem(ryeGround, ryeGround.func_77658_a());
/* 1484 */     GameRegistry.registerItem(riceGround, riceGround.func_77658_a());
/* 1485 */     GameRegistry.registerItem(cornmealGround, cornmealGround.func_77658_a());
/* 1486 */     GameRegistry.registerItem(wheatDough, wheatDough.func_77658_a());
/* 1487 */     GameRegistry.registerItem(barleyDough, barleyDough.func_77658_a());
/* 1488 */     GameRegistry.registerItem(oatDough, oatDough.func_77658_a());
/* 1489 */     GameRegistry.registerItem(ryeDough, ryeDough.func_77658_a());
/* 1490 */     GameRegistry.registerItem(riceDough, riceDough.func_77658_a());
/* 1491 */     GameRegistry.registerItem(cornmealDough, cornmealDough.func_77658_a());
/* 1492 */     GameRegistry.registerItem(wheatBread, wheatBread.func_77658_a());
/* 1493 */     GameRegistry.registerItem(barleyBread, barleyBread.func_77658_a());
/* 1494 */     GameRegistry.registerItem(oatBread, oatBread.func_77658_a());
/* 1495 */     GameRegistry.registerItem(ryeBread, ryeBread.func_77658_a());
/* 1496 */     GameRegistry.registerItem(riceBread, riceBread.func_77658_a());
/* 1497 */     GameRegistry.registerItem(cornBread, cornBread.func_77658_a());
/* 1498 */     GameRegistry.registerItem(calamariRaw, calamariRaw.func_77658_a());
/* 1499 */     GameRegistry.registerItem(seedsWheat, seedsWheat.func_77658_a());
/* 1500 */     GameRegistry.registerItem(seedsBarley, seedsBarley.func_77658_a());
/* 1501 */     GameRegistry.registerItem(seedsRye, seedsRye.func_77658_a());
/* 1502 */     GameRegistry.registerItem(seedsOat, seedsOat.func_77658_a());
/* 1503 */     GameRegistry.registerItem(seedsRice, seedsRice.func_77658_a());
/* 1504 */     GameRegistry.registerItem(seedsMaize, seedsMaize.func_77658_a());
/* 1505 */     GameRegistry.registerItem(seedsPotato, seedsPotato.func_77658_a());
/* 1506 */     GameRegistry.registerItem(seedsOnion, seedsOnion.func_77658_a());
/* 1507 */     GameRegistry.registerItem(seedsCabbage, seedsCabbage.func_77658_a());
/* 1508 */     GameRegistry.registerItem(seedsGarlic, seedsGarlic.func_77658_a());
/* 1509 */     GameRegistry.registerItem(seedsCarrot, seedsCarrot.func_77658_a());
/* 1510 */     GameRegistry.registerItem(seedsSugarcane, seedsSugarcane.func_77658_a());
/*      */     
/* 1512 */     GameRegistry.registerItem(seedsTomato, seedsTomato.func_77658_a());
/* 1513 */     GameRegistry.registerItem(seedsYellowBellPepper, seedsYellowBellPepper.func_77658_a());
/* 1514 */     GameRegistry.registerItem(seedsRedBellPepper, seedsRedBellPepper.func_77658_a());
/* 1515 */     GameRegistry.registerItem(seedsSoybean, seedsSoybean.func_77658_a());
/* 1516 */     GameRegistry.registerItem(seedsGreenbean, seedsGreenbean.func_77658_a());
/* 1517 */     GameRegistry.registerItem(seedsSquash, seedsSquash.func_77658_a());
/* 1518 */     GameRegistry.registerItem(seedsJute, seedsJute.func_77658_a());
/* 1519 */     GameRegistry.registerItem(muttonRaw, muttonRaw.func_77658_a());
/* 1520 */     GameRegistry.registerItem(venisonRaw, venisonRaw.func_77658_a());
/* 1521 */     GameRegistry.registerItem(horseMeatRaw, horseMeatRaw.func_77658_a());
/* 1522 */     GameRegistry.registerItem(porkchopRaw, porkchopRaw.func_77658_a());
/* 1523 */     GameRegistry.registerItem(fishRaw, fishRaw.func_77658_a());
/* 1524 */     GameRegistry.registerItem(beefRaw, beefRaw.func_77658_a());
/* 1525 */     GameRegistry.registerItem(bearRaw, bearRaw.func_77658_a());
/* 1526 */     GameRegistry.registerItem(chickenRaw, chickenRaw.func_77658_a());
/* 1527 */     GameRegistry.registerItem(seaWeed, seaWeed.func_77658_a());
/*      */     
/* 1529 */     GameRegistry.registerItem(wintergreenBerry, wintergreenBerry.func_77658_a());
/* 1530 */     GameRegistry.registerItem(blueberry, blueberry.func_77658_a());
/* 1531 */     GameRegistry.registerItem(raspberry, raspberry.func_77658_a());
/* 1532 */     GameRegistry.registerItem(strawberry, strawberry.func_77658_a());
/* 1533 */     GameRegistry.registerItem(blackberry, blackberry.func_77658_a());
/* 1534 */     GameRegistry.registerItem(bunchberry, bunchberry.func_77658_a());
/* 1535 */     GameRegistry.registerItem(cranberry, cranberry.func_77658_a());
/* 1536 */     GameRegistry.registerItem(snowberry, snowberry.func_77658_a());
/* 1537 */     GameRegistry.registerItem(elderberry, elderberry.func_77658_a());
/* 1538 */     GameRegistry.registerItem(gooseberry, gooseberry.func_77658_a());
/* 1539 */     GameRegistry.registerItem(cloudberry, cloudberry.func_77658_a());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1552 */     TerraFirmaCraft.LOG.info("Registering Armor");
/* 1553 */     GameRegistry.registerItem(bismuthSheet, bismuthSheet.func_77658_a());
/* 1554 */     GameRegistry.registerItem(bismuthBronzeSheet, bismuthBronzeSheet.func_77658_a());
/* 1555 */     GameRegistry.registerItem(blackBronzeSheet, blackBronzeSheet.func_77658_a());
/* 1556 */     GameRegistry.registerItem(blackSteelSheet, blackSteelSheet.func_77658_a());
/* 1557 */     GameRegistry.registerItem(blueSteelSheet, blueSteelSheet.func_77658_a());
/* 1558 */     GameRegistry.registerItem(bronzeSheet, bronzeSheet.func_77658_a());
/* 1559 */     GameRegistry.registerItem(copperSheet, copperSheet.func_77658_a());
/* 1560 */     GameRegistry.registerItem(wroughtIronSheet, wroughtIronSheet.func_77658_a());
/* 1561 */     GameRegistry.registerItem(redSteelSheet, redSteelSheet.func_77658_a());
/* 1562 */     GameRegistry.registerItem(roseGoldSheet, roseGoldSheet.func_77658_a());
/* 1563 */     GameRegistry.registerItem(steelSheet, steelSheet.func_77658_a());
/* 1564 */     GameRegistry.registerItem(tinSheet, tinSheet.func_77658_a());
/* 1565 */     GameRegistry.registerItem(zincSheet, zincSheet.func_77658_a());
/* 1566 */     GameRegistry.registerItem(electrumSheet, electrumSheet.func_77658_a());
/* 1567 */     GameRegistry.registerItem(cupronickelSheet, cupronickelSheet.func_77658_a());
/* 1568 */     GameRegistry.registerItem(bismuthSheet2x, bismuthSheet2x.func_77658_a());
/* 1569 */     GameRegistry.registerItem(bismuthBronzeSheet2x, bismuthBronzeSheet2x.func_77658_a());
/* 1570 */     GameRegistry.registerItem(blackBronzeSheet2x, blackBronzeSheet2x.func_77658_a());
/* 1571 */     GameRegistry.registerItem(blackSteelSheet2x, blackSteelSheet2x.func_77658_a());
/* 1572 */     GameRegistry.registerItem(blueSteelSheet2x, blueSteelSheet2x.func_77658_a());
/* 1573 */     GameRegistry.registerItem(bronzeSheet2x, bronzeSheet2x.func_77658_a());
/* 1574 */     GameRegistry.registerItem(copperSheet2x, copperSheet2x.func_77658_a());
/* 1575 */     GameRegistry.registerItem(wroughtIronSheet2x, wroughtIronSheet2x.func_77658_a());
/* 1576 */     GameRegistry.registerItem(redSteelSheet2x, redSteelSheet2x.func_77658_a());
/* 1577 */     GameRegistry.registerItem(roseGoldSheet2x, roseGoldSheet2x.func_77658_a());
/* 1578 */     GameRegistry.registerItem(steelSheet2x, steelSheet2x.func_77658_a());
/* 1579 */     GameRegistry.registerItem(tinSheet2x, tinSheet2x.func_77658_a());
/* 1580 */     GameRegistry.registerItem(zincSheet2x, zincSheet2x.func_77658_a());
/* 1581 */     GameRegistry.registerItem(electrumSheet2x, electrumSheet2x.func_77658_a());
/* 1582 */     GameRegistry.registerItem(cupronickelSheet2x, cupronickelSheet2x.func_77658_a());
/* 1583 */     GameRegistry.registerItem(brassSheet, brassSheet.func_77658_a());
/* 1584 */     GameRegistry.registerItem(goldSheet, goldSheet.func_77658_a());
/* 1585 */     GameRegistry.registerItem(leadSheet, leadSheet.func_77658_a());
/* 1586 */     GameRegistry.registerItem(nickelSheet, nickelSheet.func_77658_a());
/* 1587 */     GameRegistry.registerItem(pigIronSheet, pigIronSheet.func_77658_a());
/* 1588 */     GameRegistry.registerItem(platinumSheet, platinumSheet.func_77658_a());
/* 1589 */     GameRegistry.registerItem(silverSheet, silverSheet.func_77658_a());
/* 1590 */     GameRegistry.registerItem(sterlingSilverSheet, sterlingSilverSheet.func_77658_a());
/* 1591 */     GameRegistry.registerItem(brassSheet2x, brassSheet2x.func_77658_a());
/* 1592 */     GameRegistry.registerItem(goldSheet2x, goldSheet2x.func_77658_a());
/* 1593 */     GameRegistry.registerItem(leadSheet2x, leadSheet2x.func_77658_a());
/* 1594 */     GameRegistry.registerItem(nickelSheet2x, nickelSheet2x.func_77658_a());
/* 1595 */     GameRegistry.registerItem(pigIronSheet2x, pigIronSheet2x.func_77658_a());
/* 1596 */     GameRegistry.registerItem(platinumSheet2x, platinumSheet2x.func_77658_a());
/* 1597 */     GameRegistry.registerItem(silverSheet2x, silverSheet2x.func_77658_a());
/* 1598 */     GameRegistry.registerItem(sterlingSilverSheet2x, sterlingSilverSheet2x.func_77658_a());
/* 1599 */     GameRegistry.registerItem(bismuthBronzeUnfinishedBoots, bismuthBronzeUnfinishedBoots.func_77658_a());
/* 1600 */     GameRegistry.registerItem(blackBronzeUnfinishedBoots, blackBronzeUnfinishedBoots.func_77658_a());
/* 1601 */     GameRegistry.registerItem(blackSteelUnfinishedBoots, blackSteelUnfinishedBoots.func_77658_a());
/* 1602 */     GameRegistry.registerItem(blueSteelUnfinishedBoots, blueSteelUnfinishedBoots.func_77658_a());
/* 1603 */     GameRegistry.registerItem(bronzeUnfinishedBoots, bronzeUnfinishedBoots.func_77658_a());
/* 1604 */     GameRegistry.registerItem(copperUnfinishedBoots, copperUnfinishedBoots.func_77658_a());
/* 1605 */     GameRegistry.registerItem(wroughtIronUnfinishedBoots, wroughtIronUnfinishedBoots.func_77658_a());
/* 1606 */     GameRegistry.registerItem(redSteelUnfinishedBoots, redSteelUnfinishedBoots.func_77658_a());
/* 1607 */     GameRegistry.registerItem(steelUnfinishedBoots, steelUnfinishedBoots.func_77658_a());
/* 1608 */     GameRegistry.registerItem(bismuthBronzeBoots, bismuthBronzeBoots.func_77658_a());
/* 1609 */     GameRegistry.registerItem(blackBronzeBoots, blackBronzeBoots.func_77658_a());
/* 1610 */     GameRegistry.registerItem(blackSteelBoots, blackSteelBoots.func_77658_a());
/* 1611 */     GameRegistry.registerItem(blueSteelBoots, blueSteelBoots.func_77658_a());
/* 1612 */     GameRegistry.registerItem(bronzeBoots, bronzeBoots.func_77658_a());
/* 1613 */     GameRegistry.registerItem(copperBoots, copperBoots.func_77658_a());
/* 1614 */     GameRegistry.registerItem(wroughtIronBoots, wroughtIronBoots.func_77658_a());
/* 1615 */     GameRegistry.registerItem(redSteelBoots, redSteelBoots.func_77658_a());
/* 1616 */     GameRegistry.registerItem(steelBoots, steelBoots.func_77658_a());
/* 1617 */     GameRegistry.registerItem(bismuthBronzeUnfinishedGreaves, bismuthBronzeUnfinishedGreaves.func_77658_a());
/* 1618 */     GameRegistry.registerItem(blackBronzeUnfinishedGreaves, blackBronzeUnfinishedGreaves.func_77658_a());
/* 1619 */     GameRegistry.registerItem(blackSteelUnfinishedGreaves, blackSteelUnfinishedGreaves.func_77658_a());
/* 1620 */     GameRegistry.registerItem(blueSteelUnfinishedGreaves, blueSteelUnfinishedGreaves.func_77658_a());
/* 1621 */     GameRegistry.registerItem(bronzeUnfinishedGreaves, bronzeUnfinishedGreaves.func_77658_a());
/* 1622 */     GameRegistry.registerItem(copperUnfinishedGreaves, copperUnfinishedGreaves.func_77658_a());
/* 1623 */     GameRegistry.registerItem(wroughtIronUnfinishedGreaves, wroughtIronUnfinishedGreaves.func_77658_a());
/* 1624 */     GameRegistry.registerItem(redSteelUnfinishedGreaves, redSteelUnfinishedGreaves.func_77658_a());
/* 1625 */     GameRegistry.registerItem(steelUnfinishedGreaves, steelUnfinishedGreaves.func_77658_a());
/* 1626 */     GameRegistry.registerItem(bismuthBronzeGreaves, bismuthBronzeGreaves.func_77658_a());
/* 1627 */     GameRegistry.registerItem(blackBronzeGreaves, blackBronzeGreaves.func_77658_a());
/* 1628 */     GameRegistry.registerItem(blackSteelGreaves, blackSteelGreaves.func_77658_a());
/* 1629 */     GameRegistry.registerItem(blueSteelGreaves, blueSteelGreaves.func_77658_a());
/* 1630 */     GameRegistry.registerItem(bronzeGreaves, bronzeGreaves.func_77658_a());
/* 1631 */     GameRegistry.registerItem(copperGreaves, copperGreaves.func_77658_a());
/* 1632 */     GameRegistry.registerItem(wroughtIronGreaves, wroughtIronGreaves.func_77658_a());
/* 1633 */     GameRegistry.registerItem(redSteelGreaves, redSteelGreaves.func_77658_a());
/* 1634 */     GameRegistry.registerItem(steelGreaves, steelGreaves.func_77658_a());
/* 1635 */     GameRegistry.registerItem(bismuthBronzeUnfinishedChestplate, bismuthBronzeUnfinishedChestplate.func_77658_a());
/* 1636 */     GameRegistry.registerItem(blackBronzeUnfinishedChestplate, blackBronzeUnfinishedChestplate.func_77658_a());
/* 1637 */     GameRegistry.registerItem(blackSteelUnfinishedChestplate, blackSteelUnfinishedChestplate.func_77658_a());
/* 1638 */     GameRegistry.registerItem(blueSteelUnfinishedChestplate, blueSteelUnfinishedChestplate.func_77658_a());
/* 1639 */     GameRegistry.registerItem(bronzeUnfinishedChestplate, bronzeUnfinishedChestplate.func_77658_a());
/* 1640 */     GameRegistry.registerItem(copperUnfinishedChestplate, copperUnfinishedChestplate.func_77658_a());
/* 1641 */     GameRegistry.registerItem(wroughtIronUnfinishedChestplate, wroughtIronUnfinishedChestplate.func_77658_a());
/* 1642 */     GameRegistry.registerItem(redSteelUnfinishedChestplate, redSteelUnfinishedChestplate.func_77658_a());
/* 1643 */     GameRegistry.registerItem(steelUnfinishedChestplate, steelUnfinishedChestplate.func_77658_a());
/* 1644 */     GameRegistry.registerItem(bismuthBronzeChestplate, bismuthBronzeChestplate.func_77658_a());
/* 1645 */     GameRegistry.registerItem(blackBronzeChestplate, blackBronzeChestplate.func_77658_a());
/* 1646 */     GameRegistry.registerItem(blackSteelChestplate, blackSteelChestplate.func_77658_a());
/* 1647 */     GameRegistry.registerItem(blueSteelChestplate, blueSteelChestplate.func_77658_a());
/* 1648 */     GameRegistry.registerItem(bronzeChestplate, bronzeChestplate.func_77658_a());
/* 1649 */     GameRegistry.registerItem(copperChestplate, copperChestplate.func_77658_a());
/* 1650 */     GameRegistry.registerItem(wroughtIronChestplate, wroughtIronChestplate.func_77658_a());
/* 1651 */     GameRegistry.registerItem(redSteelChestplate, redSteelChestplate.func_77658_a());
/* 1652 */     GameRegistry.registerItem(steelChestplate, steelChestplate.func_77658_a());
/* 1653 */     GameRegistry.registerItem(bismuthBronzeUnfinishedHelmet, bismuthBronzeUnfinishedHelmet.func_77658_a());
/* 1654 */     GameRegistry.registerItem(blackBronzeUnfinishedHelmet, blackBronzeUnfinishedHelmet.func_77658_a());
/* 1655 */     GameRegistry.registerItem(blackSteelUnfinishedHelmet, blackSteelUnfinishedHelmet.func_77658_a());
/* 1656 */     GameRegistry.registerItem(blueSteelUnfinishedHelmet, blueSteelUnfinishedHelmet.func_77658_a());
/* 1657 */     GameRegistry.registerItem(bronzeUnfinishedHelmet, bronzeUnfinishedHelmet.func_77658_a());
/* 1658 */     GameRegistry.registerItem(copperUnfinishedHelmet, copperUnfinishedHelmet.func_77658_a());
/* 1659 */     GameRegistry.registerItem(wroughtIronUnfinishedHelmet, wroughtIronUnfinishedHelmet.func_77658_a());
/* 1660 */     GameRegistry.registerItem(redSteelUnfinishedHelmet, redSteelUnfinishedHelmet.func_77658_a());
/* 1661 */     GameRegistry.registerItem(steelUnfinishedHelmet, steelUnfinishedHelmet.func_77658_a());
/* 1662 */     GameRegistry.registerItem(bismuthBronzeHelmet, bismuthBronzeHelmet.func_77658_a());
/* 1663 */     GameRegistry.registerItem(blackBronzeHelmet, blackBronzeHelmet.func_77658_a());
/* 1664 */     GameRegistry.registerItem(blackSteelHelmet, blackSteelHelmet.func_77658_a());
/* 1665 */     GameRegistry.registerItem(blueSteelHelmet, blueSteelHelmet.func_77658_a());
/* 1666 */     GameRegistry.registerItem(bronzeHelmet, bronzeHelmet.func_77658_a());
/* 1667 */     GameRegistry.registerItem(copperHelmet, copperHelmet.func_77658_a());
/* 1668 */     GameRegistry.registerItem(wroughtIronHelmet, wroughtIronHelmet.func_77658_a());
/* 1669 */     GameRegistry.registerItem(redSteelHelmet, redSteelHelmet.func_77658_a());
/* 1670 */     GameRegistry.registerItem(steelHelmet, steelHelmet.func_77658_a());
/*      */     
/* 1672 */     GameRegistry.registerItem(leatherHelmet, leatherHelmet.func_77658_a());
/* 1673 */     GameRegistry.registerItem(leatherChestplate, leatherChestplate.func_77658_a());
/* 1674 */     GameRegistry.registerItem(leatherLeggings, leatherLeggings.func_77658_a());
/* 1675 */     GameRegistry.registerItem(leatherBoots, leatherBoots.func_77658_a());
/*      */     
/* 1677 */     GameRegistry.registerItem(quiver, quiver.func_77658_a());
/*      */     
/* 1679 */     GameRegistry.registerItem(sandwich, sandwich.func_77658_a());
/* 1680 */     GameRegistry.registerItem(salad, salad.func_77658_a());
/*      */ 
/*      */     
/* 1683 */     GameRegistry.registerItem(sugar, sugar.func_77658_a());
/*      */     
/* 1685 */     GameRegistry.registerItem(shears, shears.func_77658_a());
/*      */     
/* 1687 */     TerraFirmaCraft.LOG.info("All Items Registered");
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\TFCItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */