/*      */ package com.bioxx.tfc;
/*      */ import com.bioxx.tfc.Core.Metal.Alloy;
/*      */ import com.bioxx.tfc.Core.Metal.AlloyManager;
/*      */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*      */ import com.bioxx.tfc.Core.Recipes;
/*      */ import com.bioxx.tfc.Core.TFCTabs;
/*      */ import com.bioxx.tfc.Food.ItemFoodMeat;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.Handlers.TFCFuelHandler;
/*      */ import com.bioxx.tfc.Items.ItemBlocks.ItemWoodDoor;
/*      */ import com.bioxx.tfc.Items.ItemCustomSeeds;
/*      */ import com.bioxx.tfc.Items.ItemGem;
/*      */ import com.bioxx.tfc.Items.ItemIngot;
/*      */ import com.bioxx.tfc.Items.ItemMeltedMetal;
/*      */ import com.bioxx.tfc.Items.ItemMetalSheet;
/*      */ import com.bioxx.tfc.Items.ItemMetalSheet2x;
/*      */ import com.bioxx.tfc.Items.ItemTFCArmor;
/*      */ import com.bioxx.tfc.Items.ItemTerra;
/*      */ import com.bioxx.tfc.Items.ItemUnfinishedArmor;
/*      */ import com.bioxx.tfc.Items.Pottery.ItemPotteryMold;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomAxe;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomHoe;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomPickaxe;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomShovel;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomSword;
/*      */ import com.bioxx.tfc.Items.Tools.ItemHammer;
/*      */ import com.bioxx.tfc.Items.Tools.ItemJavelin;
/*      */ import com.bioxx.tfc.Items.Tools.ItemKnife;
/*      */ import com.bioxx.tfc.Items.Tools.ItemMiscToolHead;
/*      */ import com.bioxx.tfc.Items.Tools.ItemProPick;
/*      */ import com.bioxx.tfc.api.Armor;
/*      */ import com.bioxx.tfc.api.Constant.Global;
/*      */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*      */ import com.bioxx.tfc.api.Enums.EnumSize;
/*      */ import com.bioxx.tfc.api.Metal;
/*      */ import com.bioxx.tfc.api.TFCBlocks;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraftforge.common.util.EnumHelper;
/*      */ 
/*      */ public class ItemSetup extends TFCItems {
/*      */   public static void setup() {
/*   43 */     igInToolMaterial = EnumHelper.addToolMaterial("IgIn", 1, igInStoneUses, igInStoneEff, 40.0F, 5);
/*   44 */     sedToolMaterial = EnumHelper.addToolMaterial("Sed", 1, sedStoneUses, sedStoneEff, 40.0F, 5);
/*   45 */     igExToolMaterial = EnumHelper.addToolMaterial("IgEx", 1, igExStoneUses, igExStoneEff, 40.0F, 5);
/*   46 */     mMToolMaterial = EnumHelper.addToolMaterial("MM", 1, mMStoneUses, mMStoneEff, 40.0F, 5);
/*      */     
/*   48 */     copperToolMaterial = EnumHelper.addToolMaterial("Copper", 2, copperUses, copperEff, 65.0F, 8);
/*      */     
/*   50 */     bronzeToolMaterial = EnumHelper.addToolMaterial("Bronze", 2, bronzeUses, bronzeEff, 100.0F, 13);
/*   51 */     bismuthBronzeToolMaterial = EnumHelper.addToolMaterial("BismuthBronze", 2, bismuthBronzeUses, bismuthBronzeEff, 90.0F, 10);
/*   52 */     blackBronzeToolMaterial = EnumHelper.addToolMaterial("BlackBronze", 2, blackBronzeUses, blackBronzeEff, 95.0F, 10);
/*      */     
/*   54 */     ironToolMaterial = EnumHelper.addToolMaterial("Iron", 2, wroughtIronUses, wroughtIronEff, 135.0F, 10);
/*      */     
/*   56 */     steelToolMaterial = EnumHelper.addToolMaterial("Steel", 2, steelUses, steelEff, 170.0F, 10);
/*      */     
/*   58 */     blackSteelToolMaterial = EnumHelper.addToolMaterial("BlackSteel", 2, blackSteelUses, blackSteelEff, 205.0F, 12);
/*      */     
/*   60 */     blueSteelToolMaterial = EnumHelper.addToolMaterial("BlueSteel", 3, blueSteelUses, blueSteelEff, 240.0F, 22);
/*   61 */     redSteelToolMaterial = EnumHelper.addToolMaterial("RedSteel", 3, redSteelUses, redSteelEff, 240.0F, 22);
/*      */     
/*   63 */     TerraFirmaCraft.LOG.info("Loading Items");
/*      */     
/*   65 */     fishingRod = (new ItemCustomFishingRod()).func_77655_b("fishingRod").func_111206_d("tools/fishing_rod");
/*   66 */     coal = (new ItemCoal()).func_77655_b("coal");
/*   67 */     stick = (new ItemStick()).func_77664_n().func_77655_b("stick");
/*   68 */     bow = (new ItemCustomBow()).func_77655_b("bow").func_111206_d("tools/bow");
/*   69 */     Items.field_151031_f = (ItemBow)bow;
/*   70 */     arrow = (new ItemArrow()).func_77655_b("arrow").func_77637_a(TFCTabs.TFC_WEAPONS);
/*   71 */     dye = (new ItemDyeCustom()).func_77655_b("dyePowder").func_111206_d("dye_powder").func_77637_a(TFCTabs.TFC_MATERIALS);
/*   72 */     glassBottle = (new ItemGlassBottle()).func_77655_b("Glass Bottle");
/*   73 */     potion = (new ItemCustomPotion()).func_77655_b("potion").func_111206_d("potion");
/*   74 */     rope = (new ItemCustomLeash()).func_77655_b("Rope").func_77637_a(TFCTabs.TFC_TOOLS);
/*   75 */     Items.field_151058_ca = rope;
/*      */     
/*   77 */     minecartCrate = (new ItemCustomMinecart(1)).func_77655_b("minecartChest").func_111206_d("minecart_chest");
/*   78 */     goldPan = (new ItemGoldPan()).func_77655_b("GoldPan");
/*   79 */     sluiceItem = (new ItemSluice()).setFolder("devices/").func_77655_b("SluiceItem").func_77637_a(TFCTabs.TFC_DEVICES);
/*      */     
/*   81 */     shears = (new ItemShears(0.0F, ironToolMaterial)).func_77655_b("shears").func_111206_d("shears");
/*      */     
/*   83 */     proPickBismuthBronze = (new ItemProPick()).func_77655_b("Bismuth Bronze ProPick").func_77656_e(bismuthBronzeUses / 3);
/*   84 */     proPickBlackBronze = (new ItemProPick()).func_77655_b("Black Bronze ProPick").func_77656_e(blackBronzeUses / 3);
/*   85 */     proPickBlackSteel = (new ItemProPick()).func_77655_b("Black Steel ProPick").func_77656_e(blackSteelUses / 3);
/*   86 */     proPickBlueSteel = (new ItemProPick()).func_77655_b("Blue Steel ProPick").func_77656_e(blueSteelUses / 3);
/*   87 */     proPickBronze = (new ItemProPick()).func_77655_b("Bronze ProPick").func_77656_e(bronzeUses / 3);
/*   88 */     proPickCopper = (new ItemProPick()).func_77655_b("Copper ProPick").func_77656_e(copperUses / 3);
/*   89 */     proPickIron = (new ItemProPick()).func_77655_b("Wrought Iron ProPick").func_77656_e(wroughtIronUses / 3);
/*   90 */     proPickRedSteel = (new ItemProPick()).func_77655_b("Red Steel ProPick").func_77656_e(redSteelUses / 3);
/*   91 */     proPickSteel = (new ItemProPick()).func_77655_b("Steel ProPick").func_77656_e(steelUses / 3);
/*      */     
/*   93 */     bismuthIngot = (new ItemIngot()).func_77655_b("Bismuth Ingot");
/*   94 */     bismuthBronzeIngot = (new ItemIngot()).func_77655_b("Bismuth Bronze Ingot");
/*   95 */     blackBronzeIngot = (new ItemIngot()).func_77655_b("Black Bronze Ingot");
/*   96 */     blackSteelIngot = (new ItemIngot()).func_77655_b("Black Steel Ingot");
/*   97 */     blueSteelIngot = (new ItemIngot()).func_77655_b("Blue Steel Ingot");
/*   98 */     brassIngot = (new ItemIngot()).func_77655_b("Brass Ingot");
/*   99 */     bronzeIngot = (new ItemIngot()).func_77655_b("Bronze Ingot");
/*  100 */     copperIngot = (new ItemIngot()).func_77655_b("Copper Ingot");
/*  101 */     goldIngot = (new ItemIngot()).func_77655_b("Gold Ingot");
/*  102 */     wroughtIronIngot = (new ItemIngot()).func_77655_b("Wrought Iron Ingot");
/*  103 */     leadIngot = (new ItemIngot()).func_77655_b("Lead Ingot");
/*  104 */     nickelIngot = (new ItemIngot()).func_77655_b("Nickel Ingot");
/*  105 */     pigIronIngot = (new ItemIngot()).func_77655_b("Pig Iron Ingot");
/*  106 */     platinumIngot = (new ItemIngot()).func_77655_b("Platinum Ingot");
/*  107 */     redSteelIngot = (new ItemIngot()).func_77655_b("Red Steel Ingot");
/*  108 */     roseGoldIngot = (new ItemIngot()).func_77655_b("Rose Gold Ingot");
/*  109 */     silverIngot = (new ItemIngot()).func_77655_b("Silver Ingot");
/*  110 */     steelIngot = (new ItemIngot()).func_77655_b("Steel Ingot");
/*  111 */     sterlingSilverIngot = (new ItemIngot()).func_77655_b("Sterling Silver Ingot");
/*  112 */     tinIngot = (new ItemIngot()).func_77655_b("Tin Ingot");
/*  113 */     zincIngot = (new ItemIngot()).func_77655_b("Zinc Ingot");
/*  114 */     electrumIngot = (new ItemIngot()).func_77655_b("Electrum Ingot");
/*  115 */     cupronickelIngot = (new ItemIngot()).func_77655_b("Cupronickel Ingot");
/*      */     
/*  117 */     bismuthIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bismuth Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bismuth", 200);
/*  118 */     bismuthBronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bismuth Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bismuth Bronze", 200);
/*  119 */     blackBronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Black Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Black Bronze", 200);
/*  120 */     blackSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Black Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Black Steel", 200);
/*  121 */     blueSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Blue Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Blue Steel", 200);
/*  122 */     brassIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Brass Double Ingot")).setSize(EnumSize.LARGE).setMetal("Brass", 200);
/*  123 */     bronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bronze", 200);
/*  124 */     copperIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Copper Double Ingot")).setSize(EnumSize.LARGE).setMetal("Copper", 200);
/*  125 */     goldIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Gold Double Ingot")).setSize(EnumSize.LARGE).setMetal("Gold", 200);
/*  126 */     wroughtIronIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Wrought Iron Double Ingot")).setSize(EnumSize.LARGE).setMetal("Wrought Iron", 200);
/*  127 */     leadIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Lead Double Ingot")).setSize(EnumSize.LARGE).setMetal("Lead", 200);
/*  128 */     nickelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Nickel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Nickel", 200);
/*  129 */     pigIronIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Pig Iron Double Ingot")).setSize(EnumSize.LARGE).setMetal("Pig Iron", 200);
/*  130 */     platinumIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Platinum Double Ingot")).setSize(EnumSize.LARGE).setMetal("Platinum", 200);
/*  131 */     redSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Red Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Red Steel", 200);
/*  132 */     roseGoldIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Rose Gold Double Ingot")).setSize(EnumSize.LARGE).setMetal("Rose Gold", 200);
/*  133 */     silverIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Silver Double Ingot")).setSize(EnumSize.LARGE).setMetal("Silver", 200);
/*  134 */     steelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Steel", 200);
/*  135 */     sterlingSilverIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Sterling Silver Double Ingot")).setSize(EnumSize.LARGE).setMetal("Sterling Silver", 200);
/*  136 */     tinIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Tin Double Ingot")).setSize(EnumSize.LARGE).setMetal("Tin", 200);
/*  137 */     zincIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Zinc Double Ingot")).setSize(EnumSize.LARGE).setMetal("Zinc", 200);
/*  138 */     electrumIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Electrum Double Ingot")).setSize(EnumSize.LARGE).setMetal("Electrum", 200);
/*  139 */     cupronickelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Cupronickel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Cupronickel", 200);
/*      */     
/*  141 */     gemRuby = (new ItemGem()).func_77655_b("Ruby");
/*  142 */     gemSapphire = (new ItemGem()).func_77655_b("Sapphire");
/*  143 */     gemEmerald = (new ItemGem()).func_77655_b("Emerald");
/*  144 */     gemTopaz = (new ItemGem()).func_77655_b("Topaz");
/*  145 */     gemTourmaline = (new ItemGem()).func_77655_b("Tourmaline");
/*  146 */     gemJade = (new ItemGem()).func_77655_b("Jade");
/*  147 */     gemBeryl = (new ItemGem()).func_77655_b("Beryl");
/*  148 */     gemAgate = (new ItemGem()).func_77655_b("Agate");
/*  149 */     gemOpal = (new ItemGem()).func_77655_b("Opal");
/*  150 */     gemGarnet = (new ItemGem()).func_77655_b("Garnet");
/*  151 */     gemJasper = (new ItemGem()).func_77655_b("Jasper");
/*  152 */     gemAmethyst = (new ItemGem()).func_77655_b("Amethyst");
/*  153 */     gemDiamond = (new ItemGem()).func_77655_b("Diamond");
/*      */ 
/*      */     
/*  156 */     igInShovel = (new ItemCustomShovel(igInToolMaterial)).func_77655_b("IgIn Stone Shovel").func_77656_e(igInStoneUses);
/*  157 */     igInAxe = (new ItemCustomAxe(igInToolMaterial, 60.0F)).func_77655_b("IgIn Stone Axe").func_77656_e(igInStoneUses);
/*  158 */     igInHoe = (new ItemCustomHoe(igInToolMaterial)).func_77655_b("IgIn Stone Hoe").func_77656_e(igInStoneUses);
/*      */     
/*  160 */     sedShovel = (new ItemCustomShovel(sedToolMaterial)).func_77655_b("Sed Stone Shovel").func_77656_e(sedStoneUses);
/*  161 */     sedAxe = (new ItemCustomAxe(sedToolMaterial, 60.0F)).func_77655_b("Sed Stone Axe").func_77656_e(sedStoneUses);
/*  162 */     sedHoe = (new ItemCustomHoe(sedToolMaterial)).func_77655_b("Sed Stone Hoe").func_77656_e(sedStoneUses);
/*      */     
/*  164 */     igExShovel = (new ItemCustomShovel(igExToolMaterial)).func_77655_b("IgEx Stone Shovel").func_77656_e(igExStoneUses);
/*  165 */     igExAxe = (new ItemCustomAxe(igExToolMaterial, 60.0F)).func_77655_b("IgEx Stone Axe").func_77656_e(igExStoneUses);
/*  166 */     igExHoe = (new ItemCustomHoe(igExToolMaterial)).func_77655_b("IgEx Stone Hoe").func_77656_e(igExStoneUses);
/*      */     
/*  168 */     mMShovel = (new ItemCustomShovel(mMToolMaterial)).func_77655_b("MM Stone Shovel").func_77656_e(mMStoneUses);
/*  169 */     mMAxe = (new ItemCustomAxe(mMToolMaterial, 60.0F)).func_77655_b("MM Stone Axe").func_77656_e(mMStoneUses);
/*  170 */     mMHoe = (new ItemCustomHoe(mMToolMaterial)).func_77655_b("MM Stone Hoe").func_77656_e(mMStoneUses);
/*      */     
/*  172 */     bismuthBronzePick = (new ItemCustomPickaxe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Pick").func_77656_e(bismuthBronzeUses);
/*  173 */     bismuthBronzeShovel = (new ItemCustomShovel(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Shovel").func_77656_e(bismuthBronzeUses);
/*  174 */     bismuthBronzeAxe = (new ItemCustomAxe(bismuthBronzeToolMaterial, 150.0F)).func_77655_b("Bismuth Bronze Axe").func_77656_e(bismuthBronzeUses);
/*  175 */     bismuthBronzeHoe = (new ItemCustomHoe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Hoe").func_77656_e(bismuthBronzeUses);
/*      */     
/*  177 */     blackBronzePick = (new ItemCustomPickaxe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Pick").func_77656_e(blackBronzeUses);
/*  178 */     blackBronzeShovel = (new ItemCustomShovel(blackBronzeToolMaterial)).func_77655_b("Black Bronze Shovel").func_77656_e(blackBronzeUses);
/*  179 */     blackBronzeAxe = (new ItemCustomAxe(blackBronzeToolMaterial, 170.0F)).func_77655_b("Black Bronze Axe").func_77656_e(blackBronzeUses);
/*  180 */     blackBronzeHoe = (new ItemCustomHoe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Hoe").func_77656_e(blackBronzeUses);
/*      */     
/*  182 */     blackSteelPick = (new ItemCustomPickaxe(blackSteelToolMaterial)).func_77655_b("Black Steel Pick").func_77656_e(blackSteelUses);
/*  183 */     blackSteelShovel = (new ItemCustomShovel(blackSteelToolMaterial)).func_77655_b("Black Steel Shovel").func_77656_e(blackSteelUses);
/*  184 */     blackSteelAxe = (new ItemCustomAxe(blackSteelToolMaterial, 245.0F)).func_77655_b("Black Steel Axe").func_77656_e(blackSteelUses);
/*  185 */     blackSteelHoe = (new ItemCustomHoe(blackSteelToolMaterial)).func_77655_b("Black Steel Hoe").func_77656_e(blackSteelUses);
/*      */     
/*  187 */     blueSteelPick = (new ItemCustomPickaxe(blueSteelToolMaterial)).func_77655_b("Blue Steel Pick").func_77656_e(blueSteelUses);
/*  188 */     blueSteelShovel = (new ItemCustomShovel(blueSteelToolMaterial)).func_77655_b("Blue Steel Shovel").func_77656_e(blueSteelUses);
/*  189 */     blueSteelAxe = (new ItemCustomAxe(blueSteelToolMaterial, 270.0F)).func_77655_b("Blue Steel Axe").func_77656_e(blueSteelUses);
/*  190 */     blueSteelHoe = (new ItemCustomHoe(blueSteelToolMaterial)).func_77655_b("Blue Steel Hoe").func_77656_e(blueSteelUses);
/*      */     
/*  192 */     bronzePick = (new ItemCustomPickaxe(bronzeToolMaterial)).func_77655_b("Bronze Pick").func_77656_e(bronzeUses);
/*  193 */     bronzeShovel = (new ItemCustomShovel(bronzeToolMaterial)).func_77655_b("Bronze Shovel").func_77656_e(bronzeUses);
/*  194 */     bronzeAxe = (new ItemCustomAxe(bronzeToolMaterial, 160.0F)).func_77655_b("Bronze Axe").func_77656_e(bronzeUses);
/*  195 */     bronzeHoe = (new ItemCustomHoe(bronzeToolMaterial)).func_77655_b("Bronze Hoe").func_77656_e(bronzeUses);
/*      */     
/*  197 */     copperPick = (new ItemCustomPickaxe(copperToolMaterial)).func_77655_b("Copper Pick").func_77656_e(copperUses);
/*  198 */     copperShovel = (new ItemCustomShovel(copperToolMaterial)).func_77655_b("Copper Shovel").func_77656_e(copperUses);
/*  199 */     copperAxe = (new ItemCustomAxe(copperToolMaterial, 115.0F)).func_77655_b("Copper Axe").func_77656_e(copperUses);
/*  200 */     copperHoe = (new ItemCustomHoe(copperToolMaterial)).func_77655_b("Copper Hoe").func_77656_e(copperUses);
/*      */     
/*  202 */     wroughtIronPick = (new ItemCustomPickaxe(ironToolMaterial)).func_77655_b("Wrought Iron Pick").func_77656_e(wroughtIronUses);
/*  203 */     wroughtIronShovel = (new ItemCustomShovel(ironToolMaterial)).func_77655_b("Wrought Iron Shovel").func_77656_e(wroughtIronUses);
/*  204 */     wroughtIronAxe = (new ItemCustomAxe(ironToolMaterial, 185.0F)).func_77655_b("Wrought Iron Axe").func_77656_e(wroughtIronUses);
/*  205 */     wroughtIronHoe = (new ItemCustomHoe(ironToolMaterial)).func_77655_b("Wrought Iron Hoe").func_77656_e(wroughtIronUses);
/*      */     
/*  207 */     redSteelPick = (new ItemCustomPickaxe(redSteelToolMaterial)).func_77655_b("Red Steel Pick").func_77656_e(redSteelUses);
/*  208 */     redSteelShovel = (new ItemCustomShovel(redSteelToolMaterial)).func_77655_b("Red Steel Shovel").func_77656_e(redSteelUses);
/*  209 */     redSteelAxe = (new ItemCustomAxe(redSteelToolMaterial, 270.0F)).func_77655_b("Red Steel Axe").func_77656_e(redSteelUses);
/*  210 */     redSteelHoe = (new ItemCustomHoe(redSteelToolMaterial)).func_77655_b("Red Steel Hoe").func_77656_e(redSteelUses);
/*      */     
/*  212 */     steelPick = (new ItemCustomPickaxe(steelToolMaterial)).func_77655_b("Steel Pick").func_77656_e(steelUses);
/*  213 */     steelShovel = (new ItemCustomShovel(steelToolMaterial)).func_77655_b("Steel Shovel").func_77656_e(steelUses);
/*  214 */     steelAxe = (new ItemCustomAxe(steelToolMaterial, 210.0F)).func_77655_b("Steel Axe").func_77656_e(steelUses);
/*  215 */     steelHoe = (new ItemCustomHoe(steelToolMaterial)).func_77655_b("Steel Hoe").func_77656_e(steelUses);
/*      */ 
/*      */     
/*  218 */     bismuthBronzeChisel = (new ItemChisel(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Chisel").func_77656_e(bismuthBronzeUses);
/*  219 */     blackBronzeChisel = (new ItemChisel(blackBronzeToolMaterial)).func_77655_b("Black Bronze Chisel").func_77656_e(blackBronzeUses);
/*  220 */     blackSteelChisel = (new ItemChisel(blackSteelToolMaterial)).func_77655_b("Black Steel Chisel").func_77656_e(blackSteelUses);
/*  221 */     blueSteelChisel = (new ItemChisel(blueSteelToolMaterial)).func_77655_b("Blue Steel Chisel").func_77656_e(blueSteelUses);
/*  222 */     bronzeChisel = (new ItemChisel(bronzeToolMaterial)).func_77655_b("Bronze Chisel").func_77656_e(bronzeUses);
/*  223 */     copperChisel = (new ItemChisel(copperToolMaterial)).func_77655_b("Copper Chisel").func_77656_e(copperUses);
/*  224 */     wroughtIronChisel = (new ItemChisel(ironToolMaterial)).func_77655_b("Wrought Iron Chisel").func_77656_e(wroughtIronUses);
/*  225 */     redSteelChisel = (new ItemChisel(redSteelToolMaterial)).func_77655_b("Red Steel Chisel").func_77656_e(redSteelUses);
/*  226 */     steelChisel = (new ItemChisel(steelToolMaterial)).func_77655_b("Steel Chisel").func_77656_e(steelUses);
/*      */     
/*  228 */     bismuthBronzeSword = (new ItemCustomSword(bismuthBronzeToolMaterial, 210.0F)).func_77655_b("Bismuth Bronze Sword").func_77656_e(bismuthBronzeUses);
/*  229 */     blackBronzeSword = (new ItemCustomSword(blackBronzeToolMaterial, 230.0F)).func_77655_b("Black Bronze Sword").func_77656_e(blackBronzeUses);
/*  230 */     blackSteelSword = (new ItemCustomSword(blackSteelToolMaterial, 270.0F)).func_77655_b("Black Steel Sword").func_77656_e(blackSteelUses);
/*  231 */     blueSteelSword = (new ItemCustomSword(blueSteelToolMaterial, 315.0F)).func_77655_b("Blue Steel Sword").func_77656_e(blueSteelUses);
/*  232 */     bronzeSword = (new ItemCustomSword(bronzeToolMaterial, 220.0F)).func_77655_b("Bronze Sword").func_77656_e(bronzeUses);
/*  233 */     copperSword = (new ItemCustomSword(copperToolMaterial, 165.0F)).func_77655_b("Copper Sword").func_77656_e(copperUses);
/*  234 */     wroughtIronSword = (new ItemCustomSword(ironToolMaterial, 240.0F)).func_77655_b("Wrought Iron Sword").func_77656_e(wroughtIronUses);
/*  235 */     redSteelSword = (new ItemCustomSword(redSteelToolMaterial, 315.0F)).func_77655_b("Red Steel Sword").func_77656_e(redSteelUses);
/*  236 */     steelSword = (new ItemCustomSword(steelToolMaterial, 265.0F)).func_77655_b("Steel Sword").func_77656_e(steelUses);
/*      */     
/*  238 */     bismuthBronzeMace = (new ItemCustomSword(bismuthBronzeToolMaterial, 210.0F, EnumDamageType.CRUSHING)).func_77655_b("Bismuth Bronze Mace").func_77656_e(bismuthBronzeUses);
/*  239 */     blackBronzeMace = (new ItemCustomSword(blackBronzeToolMaterial, 230.0F, EnumDamageType.CRUSHING)).func_77655_b("Black Bronze Mace").func_77656_e(blackBronzeUses);
/*  240 */     blackSteelMace = (new ItemCustomSword(blackSteelToolMaterial, 270.0F, EnumDamageType.CRUSHING)).func_77655_b("Black Steel Mace").func_77656_e(blackSteelUses);
/*  241 */     blueSteelMace = (new ItemCustomSword(blueSteelToolMaterial, 315.0F, EnumDamageType.CRUSHING)).func_77655_b("Blue Steel Mace").func_77656_e(blueSteelUses);
/*  242 */     bronzeMace = (new ItemCustomSword(bronzeToolMaterial, 220.0F, EnumDamageType.CRUSHING)).func_77655_b("Bronze Mace").func_77656_e(bronzeUses);
/*  243 */     copperMace = (new ItemCustomSword(copperToolMaterial, 165.0F, EnumDamageType.CRUSHING)).func_77655_b("Copper Mace").func_77656_e(copperUses);
/*  244 */     wroughtIronMace = (new ItemCustomSword(ironToolMaterial, 240.0F, EnumDamageType.CRUSHING)).func_77655_b("Wrought Iron Mace").func_77656_e(wroughtIronUses);
/*  245 */     redSteelMace = (new ItemCustomSword(redSteelToolMaterial, 315.0F, EnumDamageType.CRUSHING)).func_77655_b("Red Steel Mace").func_77656_e(redSteelUses);
/*  246 */     steelMace = (new ItemCustomSword(steelToolMaterial, 265.0F, EnumDamageType.CRUSHING)).func_77655_b("Steel Mace").func_77656_e(steelUses);
/*      */     
/*  248 */     bismuthBronzeSaw = (new ItemCustomSaw(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Saw").func_77656_e(bismuthBronzeUses);
/*  249 */     blackBronzeSaw = (new ItemCustomSaw(blackBronzeToolMaterial)).func_77655_b("Black Bronze Saw").func_77656_e(blackBronzeUses);
/*  250 */     blackSteelSaw = (new ItemCustomSaw(blackSteelToolMaterial)).func_77655_b("Black Steel Saw").func_77656_e(blackSteelUses);
/*  251 */     blueSteelSaw = (new ItemCustomSaw(blueSteelToolMaterial)).func_77655_b("Blue Steel Saw").func_77656_e(blueSteelUses);
/*  252 */     bronzeSaw = (new ItemCustomSaw(bronzeToolMaterial)).func_77655_b("Bronze Saw").func_77656_e(bronzeUses);
/*  253 */     copperSaw = (new ItemCustomSaw(copperToolMaterial)).func_77655_b("Copper Saw").func_77656_e(copperUses);
/*  254 */     wroughtIronSaw = (new ItemCustomSaw(ironToolMaterial)).func_77655_b("Wrought Iron Saw").func_77656_e(wroughtIronUses);
/*  255 */     redSteelSaw = (new ItemCustomSaw(redSteelToolMaterial)).func_77655_b("Red Steel Saw").func_77656_e(redSteelUses);
/*  256 */     steelSaw = (new ItemCustomSaw(steelToolMaterial)).func_77655_b("Steel Saw").func_77656_e(steelUses);
/*      */     
/*  258 */     highCarbonBlackSteelIngot = (new ItemIngot(false)).func_77655_b("HC Black Steel Ingot");
/*  259 */     weakBlueSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Blue Steel Ingot");
/*  260 */     weakRedSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Red Steel Ingot");
/*  261 */     weakSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Steel Ingot");
/*  262 */     highCarbonBlueSteelIngot = (new ItemIngot(false)).func_77655_b("HC Blue Steel Ingot");
/*  263 */     highCarbonRedSteelIngot = (new ItemIngot(false)).func_77655_b("HC Red Steel Ingot");
/*  264 */     highCarbonSteelIngot = (new ItemIngot(false)).func_77655_b("HC Steel Ingot");
/*      */     
/*  266 */     smallMetalChunk = (new ItemNugget()).func_77655_b("MetalNugget");
/*  267 */     oreChunk = (new ItemOre()).setFolder("ore/").func_77655_b("Ore");
/*  268 */     smallOreChunk = (new ItemOreSmall()).func_77655_b("Small Ore");
/*  269 */     powder = (new ItemTerra()).setMetaNames(Global.POWDER).func_77655_b("Powder").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  270 */     logs = (new ItemLogs()).func_77655_b("Log");
/*      */ 
/*      */ 
/*      */     
/*  274 */     igInStoneJavelin = (new ItemJavelin(igInToolMaterial, 60.0F)).func_77655_b("IgIn Stone Javelin");
/*  275 */     sedStoneJavelin = (new ItemJavelin(sedToolMaterial, 60.0F)).func_77655_b("Sed Stone Javelin");
/*  276 */     igExStoneJavelin = (new ItemJavelin(igExToolMaterial, 60.0F)).func_77655_b("IgEx Stone Javelin");
/*  277 */     mMStoneJavelin = (new ItemJavelin(mMToolMaterial, 60.0F)).func_77655_b("MM Stone Javelin");
/*  278 */     copperJavelin = (new ItemJavelin(copperToolMaterial, 80.0F)).func_77655_b("Copper Javelin");
/*  279 */     bismuthBronzeJavelin = (new ItemJavelin(bismuthBronzeToolMaterial, 90.0F)).func_77655_b("Bismuth Bronze Javelin");
/*  280 */     bronzeJavelin = (new ItemJavelin(bronzeToolMaterial, 100.0F)).func_77655_b("Bronze Javelin");
/*  281 */     blackBronzeJavelin = (new ItemJavelin(blackBronzeToolMaterial, 95.0F)).func_77655_b("Black Bronze Javelin");
/*  282 */     wroughtIronJavelin = (new ItemJavelin(ironToolMaterial, 135.0F)).func_77655_b("Wrought Iron Javelin");
/*  283 */     steelJavelin = (new ItemJavelin(steelToolMaterial, 170.0F)).func_77655_b("Steel Javelin");
/*  284 */     blackSteelJavelin = (new ItemJavelin(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Javelin");
/*  285 */     blueSteelJavelin = (new ItemJavelin(blueSteelToolMaterial, 240.0F)).func_77655_b("Blue Steel Javelin");
/*  286 */     redSteelJavelin = (new ItemJavelin(redSteelToolMaterial, 240.0F)).func_77655_b("Red Steel Javelin");
/*      */ 
/*      */     
/*  289 */     igInStoneJavelinHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Javelin Head");
/*  290 */     sedStoneJavelinHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Javelin Head");
/*  291 */     igExStoneJavelinHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Javelin Head");
/*  292 */     mMStoneJavelinHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Javelin Head");
/*  293 */     copperJavelinHead = (new ItemMiscToolHead()).func_77655_b("Copper Javelin Head");
/*  294 */     bismuthBronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Javelin Head");
/*  295 */     bronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Bronze Javelin Head");
/*  296 */     blackBronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Javelin Head");
/*  297 */     wroughtIronJavelinHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Javelin Head");
/*  298 */     steelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Steel Javelin Head");
/*  299 */     blackSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Javelin Head");
/*  300 */     blueSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Javelin Head");
/*  301 */     redSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Javelin Head");
/*      */     
/*  303 */     bismuthUnshaped = (new ItemMeltedMetal()).func_77655_b("Bismuth Unshaped");
/*  304 */     bismuthBronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Bismuth Bronze Unshaped");
/*  305 */     blackBronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Black Bronze Unshaped");
/*  306 */     blackSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Black Steel Unshaped");
/*  307 */     blueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Blue Steel Unshaped");
/*  308 */     brassUnshaped = (new ItemMeltedMetal()).func_77655_b("Brass Unshaped");
/*  309 */     bronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Bronze Unshaped");
/*  310 */     copperUnshaped = (new ItemMeltedMetal()).func_77655_b("Copper Unshaped");
/*  311 */     goldUnshaped = (new ItemMeltedMetal()).func_77655_b("Gold Unshaped");
/*  312 */     wroughtIronUnshaped = (new ItemMeltedMetal()).func_77655_b("Wrought Iron Unshaped");
/*  313 */     leadUnshaped = (new ItemMeltedMetal()).func_77655_b("Lead Unshaped");
/*  314 */     nickelUnshaped = (new ItemMeltedMetal()).func_77655_b("Nickel Unshaped");
/*  315 */     pigIronUnshaped = (new ItemMeltedMetal()).func_77655_b("Pig Iron Unshaped");
/*  316 */     platinumUnshaped = (new ItemMeltedMetal()).func_77655_b("Platinum Unshaped");
/*  317 */     redSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Red Steel Unshaped");
/*  318 */     roseGoldUnshaped = (new ItemMeltedMetal()).func_77655_b("Rose Gold Unshaped");
/*  319 */     silverUnshaped = (new ItemMeltedMetal()).func_77655_b("Silver Unshaped");
/*  320 */     steelUnshaped = (new ItemMeltedMetal()).func_77655_b("Steel Unshaped");
/*  321 */     sterlingSilverUnshaped = (new ItemMeltedMetal()).func_77655_b("Sterling Silver Unshaped");
/*  322 */     tinUnshaped = (new ItemMeltedMetal()).func_77655_b("Tin Unshaped");
/*  323 */     zincUnshaped = (new ItemMeltedMetal()).func_77655_b("Zinc Unshaped");
/*  324 */     electrumUnshaped = (new ItemMeltedMetal()).func_77655_b("Electrum Unshaped");
/*  325 */     cupronickelUnshaped = (new ItemMeltedMetal()).func_77655_b("Cupronickel Unshaped");
/*      */ 
/*      */     
/*  328 */     stoneHammer = (new ItemHammer(igInToolMaterial, 60.0F)).func_77655_b("Stone Hammer").func_77656_e(igInStoneUses);
/*  329 */     bismuthBronzeHammer = (new ItemHammer(bismuthBronzeToolMaterial, 90.0F)).func_77655_b("Bismuth Bronze Hammer").func_77656_e(bismuthBronzeUses);
/*  330 */     blackBronzeHammer = (new ItemHammer(blackBronzeToolMaterial, 95.0F)).func_77655_b("Black Bronze Hammer").func_77656_e(blackBronzeUses);
/*  331 */     blackSteelHammer = (new ItemHammer(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Hammer").func_77656_e(blackSteelUses);
/*  332 */     blueSteelHammer = (new ItemHammer(blueSteelToolMaterial, 240.0F)).func_77655_b("Blue Steel Hammer").func_77656_e(blueSteelUses);
/*  333 */     bronzeHammer = (new ItemHammer(bronzeToolMaterial, 100.0F)).func_77655_b("Bronze Hammer").func_77656_e(bronzeUses);
/*  334 */     copperHammer = (new ItemHammer(copperToolMaterial, 80.0F)).func_77655_b("Copper Hammer").func_77656_e(copperUses);
/*  335 */     wroughtIronHammer = (new ItemHammer(ironToolMaterial, 135.0F)).func_77655_b("Wrought Iron Hammer").func_77656_e(wroughtIronUses);
/*  336 */     redSteelHammer = (new ItemHammer(redSteelToolMaterial, 240.0F)).func_77655_b("Red Steel Hammer").func_77656_e(redSteelUses);
/*  337 */     steelHammer = (new ItemHammer(steelToolMaterial, 170.0F)).func_77655_b("Steel Hammer").func_77656_e(steelUses);
/*      */     
/*  339 */     ink = (new ItemTerra()).func_77655_b("Ink").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  340 */     fireStarter = (new ItemFirestarter()).setFolder("tools/").func_77655_b("Firestarter");
/*      */ 
/*      */     
/*  343 */     bismuthBronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Pick Head");
/*  344 */     blackBronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Pick Head");
/*  345 */     blackSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Pick Head");
/*  346 */     blueSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Pick Head");
/*  347 */     bronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Pick Head");
/*  348 */     copperPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Copper Pick Head");
/*  349 */     wroughtIronPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Pick Head");
/*  350 */     redSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Pick Head");
/*  351 */     steelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Steel Pick Head");
/*      */     
/*  353 */     bismuthBronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Shovel Head");
/*  354 */     blackBronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Shovel Head");
/*  355 */     blackSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Shovel Head");
/*  356 */     blueSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Shovel Head");
/*  357 */     bronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Bronze Shovel Head");
/*  358 */     copperShovelHead = (new ItemMiscToolHead()).func_77655_b("Copper Shovel Head");
/*  359 */     wroughtIronShovelHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Shovel Head");
/*  360 */     redSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Shovel Head");
/*  361 */     steelShovelHead = (new ItemMiscToolHead()).func_77655_b("Steel Shovel Head");
/*      */     
/*  363 */     bismuthBronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Hoe Head");
/*  364 */     blackBronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Hoe Head");
/*  365 */     blackSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Hoe Head");
/*  366 */     blueSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Hoe Head");
/*  367 */     bronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Hoe Head");
/*  368 */     copperHoeHead = (new ItemMiscToolHead()).func_77655_b("Copper Hoe Head");
/*  369 */     wroughtIronHoeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Hoe Head");
/*  370 */     redSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Hoe Head");
/*  371 */     steelHoeHead = (new ItemMiscToolHead()).func_77655_b("Steel Hoe Head");
/*      */     
/*  373 */     bismuthBronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Axe Head");
/*  374 */     blackBronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Axe Head");
/*  375 */     blackSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Axe Head");
/*  376 */     blueSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Axe Head");
/*  377 */     bronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Axe Head");
/*  378 */     copperAxeHead = (new ItemMiscToolHead()).func_77655_b("Copper Axe Head");
/*  379 */     wroughtIronAxeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Axe Head");
/*  380 */     redSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Axe Head");
/*  381 */     steelAxeHead = (new ItemMiscToolHead()).func_77655_b("Steel Axe Head");
/*      */     
/*  383 */     bismuthBronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Hammer Head");
/*  384 */     blackBronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Hammer Head");
/*  385 */     blackSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Hammer Head");
/*  386 */     blueSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Hammer Head");
/*  387 */     bronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Bronze Hammer Head");
/*  388 */     copperHammerHead = (new ItemMiscToolHead()).func_77655_b("Copper Hammer Head");
/*  389 */     wroughtIronHammerHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Hammer Head");
/*  390 */     redSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Hammer Head");
/*  391 */     steelHammerHead = (new ItemMiscToolHead()).func_77655_b("Steel Hammer Head");
/*      */ 
/*      */     
/*  394 */     bismuthBronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Chisel Head");
/*  395 */     blackBronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Chisel Head");
/*  396 */     blackSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Chisel Head");
/*  397 */     blueSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Chisel Head");
/*  398 */     bronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Bronze Chisel Head");
/*  399 */     copperChiselHead = (new ItemMiscToolHead()).func_77655_b("Copper Chisel Head");
/*  400 */     wroughtIronChiselHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Chisel Head");
/*  401 */     redSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Chisel Head");
/*  402 */     steelChiselHead = (new ItemMiscToolHead()).func_77655_b("Steel Chisel Head");
/*      */     
/*  404 */     bismuthBronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Sword Blade");
/*  405 */     blackBronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Sword Blade");
/*  406 */     blackSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Sword Blade");
/*  407 */     blueSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Sword Blade");
/*  408 */     bronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Bronze Sword Blade");
/*  409 */     copperSwordHead = (new ItemMiscToolHead()).func_77655_b("Copper Sword Blade");
/*  410 */     wroughtIronSwordHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Sword Blade");
/*  411 */     redSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Sword Blade");
/*  412 */     steelSwordHead = (new ItemMiscToolHead()).func_77655_b("Steel Sword Blade");
/*      */     
/*  414 */     bismuthBronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Mace Head");
/*  415 */     blackBronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Mace Head");
/*  416 */     blackSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Mace Head");
/*  417 */     blueSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Mace Head");
/*  418 */     bronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Bronze Mace Head");
/*  419 */     copperMaceHead = (new ItemMiscToolHead()).func_77655_b("Copper Mace Head");
/*  420 */     wroughtIronMaceHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Mace Head");
/*  421 */     redSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Mace Head");
/*  422 */     steelMaceHead = (new ItemMiscToolHead()).func_77655_b("Steel Mace Head");
/*      */     
/*  424 */     bismuthBronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Saw Blade");
/*  425 */     blackBronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Saw Blade");
/*  426 */     blackSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Saw Blade");
/*  427 */     blueSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Saw Blade");
/*  428 */     bronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Bronze Saw Blade");
/*  429 */     copperSawHead = (new ItemMiscToolHead()).func_77655_b("Copper Saw Blade");
/*  430 */     wroughtIronSawHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Saw Blade");
/*  431 */     redSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Saw Blade");
/*  432 */     steelSawHead = (new ItemMiscToolHead()).func_77655_b("Steel Saw Blade");
/*      */     
/*  434 */     highCarbonBlackSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Black Steel Unshaped");
/*  435 */     weakBlueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Blue Steel Unshaped");
/*  436 */     highCarbonBlueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Blue Steel Unshaped");
/*  437 */     weakRedSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Red Steel Unshaped");
/*  438 */     highCarbonRedSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Red Steel Unshaped");
/*  439 */     weakSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Steel Unshaped");
/*  440 */     highCarbonSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Steel Unshaped");
/*      */ 
/*      */     
/*  443 */     bismuthBronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze ProPick Head");
/*  444 */     blackBronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze ProPick Head");
/*  445 */     blackSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Black Steel ProPick Head");
/*  446 */     blueSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel ProPick Head");
/*  447 */     bronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Bronze ProPick Head");
/*  448 */     copperProPickHead = (new ItemMiscToolHead()).func_77655_b("Copper ProPick Head");
/*  449 */     wroughtIronProPickHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron ProPick Head");
/*  450 */     redSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Red Steel ProPick Head");
/*  451 */     steelProPickHead = (new ItemMiscToolHead()).func_77655_b("Steel ProPick Head");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  456 */     bismuthBronzeScythe = (new ItemCustomScythe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Scythe").func_77656_e(bismuthBronzeUses);
/*  457 */     blackBronzeScythe = (new ItemCustomScythe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Scythe").func_77656_e(blackBronzeUses);
/*  458 */     blackSteelScythe = (new ItemCustomScythe(blackSteelToolMaterial)).func_77655_b("Black Steel Scythe").func_77656_e(blackSteelUses);
/*  459 */     blueSteelScythe = (new ItemCustomScythe(blueSteelToolMaterial)).func_77655_b("Blue Steel Scythe").func_77656_e(blueSteelUses);
/*  460 */     bronzeScythe = (new ItemCustomScythe(bronzeToolMaterial)).func_77655_b("Bronze Scythe").func_77656_e(bronzeUses);
/*  461 */     copperScythe = (new ItemCustomScythe(copperToolMaterial)).func_77655_b("Copper Scythe").func_77656_e(copperUses);
/*  462 */     wroughtIronScythe = (new ItemCustomScythe(ironToolMaterial)).func_77655_b("Wrought Iron Scythe").func_77656_e(wroughtIronUses);
/*  463 */     redSteelScythe = (new ItemCustomScythe(redSteelToolMaterial)).func_77655_b("Red Steel Scythe").func_77656_e(redSteelUses);
/*  464 */     steelScythe = (new ItemCustomScythe(steelToolMaterial)).func_77655_b("Steel Scythe").func_77656_e(steelUses);
/*      */     
/*  466 */     bismuthBronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Scythe Blade");
/*  467 */     blackBronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Scythe Blade");
/*  468 */     blackSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Scythe Blade");
/*  469 */     blueSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Scythe Blade");
/*  470 */     bronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Bronze Scythe Blade");
/*  471 */     copperScytheHead = (new ItemMiscToolHead()).func_77655_b("Copper Scythe Blade");
/*  472 */     wroughtIronScytheHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Scythe Blade");
/*  473 */     redSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Scythe Blade");
/*  474 */     steelScytheHead = (new ItemMiscToolHead()).func_77655_b("Steel Scythe Blade");
/*      */     
/*  476 */     woodenBucketEmpty = (new ItemCustomBucket(Blocks.field_150350_a)).func_77655_b("Wooden Bucket Empty");
/*  477 */     woodenBucketWater = (new ItemCustomBucket(TFCBlocks.freshWater, woodenBucketEmpty)).func_77655_b("Wooden Bucket Water");
/*  478 */     woodenBucketSaltWater = (new ItemCustomBucket(TFCBlocks.saltWater, woodenBucketEmpty)).func_77655_b("Wooden Bucket Salt Water");
/*  479 */     woodenBucketMilk = (new ItemCustomBucketMilk()).func_77655_b("Wooden Bucket Milk").func_77642_a(woodenBucketEmpty).func_77637_a(TFCTabs.TFC_FOODS);
/*      */     
/*  481 */     bismuthBronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Knife Blade");
/*  482 */     blackBronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Knife Blade");
/*  483 */     blackSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Knife Blade");
/*  484 */     blueSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Knife Blade");
/*  485 */     bronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Knife Blade");
/*  486 */     copperKnifeHead = (new ItemMiscToolHead()).func_77655_b("Copper Knife Blade");
/*  487 */     wroughtIronKnifeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Knife Blade");
/*  488 */     redSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Knife Blade");
/*  489 */     steelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Steel Knife Blade");
/*      */     
/*  491 */     bismuthBronzeKnife = (new ItemKnife(bismuthBronzeToolMaterial, 155.0F)).func_77655_b("Bismuth Bronze Knife").func_77656_e(bismuthBronzeUses);
/*  492 */     blackBronzeKnife = (new ItemKnife(blackBronzeToolMaterial, 165.0F)).func_77655_b("Black Bronze Knife").func_77656_e(blackBronzeUses);
/*  493 */     blackSteelKnife = (new ItemKnife(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Knife").func_77656_e(blackSteelUses);
/*  494 */     blueSteelKnife = (new ItemKnife(blueSteelToolMaterial, 250.0F)).func_77655_b("Blue Steel Knife").func_77656_e(blueSteelUses);
/*  495 */     bronzeKnife = (new ItemKnife(bronzeToolMaterial, 150.0F)).func_77655_b("Bronze Knife").func_77656_e(bronzeUses);
/*  496 */     copperKnife = (new ItemKnife(copperToolMaterial, 100.0F)).func_77655_b("Copper Knife").func_77656_e(copperUses);
/*  497 */     wroughtIronKnife = (new ItemKnife(ironToolMaterial, 175.0F)).func_77655_b("Wrought Iron Knife").func_77656_e(wroughtIronUses);
/*  498 */     redSteelKnife = (new ItemKnife(redSteelToolMaterial, 250.0F)).func_77655_b("Red Steel Knife").func_77656_e(redSteelUses);
/*  499 */     steelKnife = (new ItemKnife(steelToolMaterial, 200.0F)).func_77655_b("Steel Knife").func_77656_e(steelUses);
/*      */     
/*  501 */     flatRock = (new ItemFlatGeneric()).setFolder("rocks/flatrocks/").setMetaNames(Global.STONE_ALL).func_77655_b("FlatRock");
/*  502 */     looseRock = (new ItemLooseRock()).setSpecialCraftingType(flatRock).setFolder("rocks/").setMetaNames(Global.STONE_ALL).func_77655_b("LooseRock");
/*      */     
/*  504 */     igInStoneShovelHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Shovel Head");
/*  505 */     sedStoneShovelHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Shovel Head");
/*  506 */     igExStoneShovelHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Shovel Head");
/*  507 */     mMStoneShovelHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Shovel Head");
/*      */     
/*  509 */     igInStoneAxeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Axe Head");
/*  510 */     sedStoneAxeHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Axe Head");
/*  511 */     igExStoneAxeHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Axe Head");
/*  512 */     mMStoneAxeHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Axe Head");
/*      */     
/*  514 */     igInStoneHoeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Hoe Head");
/*  515 */     sedStoneHoeHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Hoe Head");
/*  516 */     igExStoneHoeHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Hoe Head");
/*  517 */     mMStoneHoeHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Hoe Head");
/*      */     
/*  519 */     stoneKnifeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("Stone Knife Blade");
/*  520 */     stoneHammerHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("Stone Hammer Head");
/*      */     
/*  522 */     stoneKnife = (new ItemKnife(igExToolMaterial, 40.0F)).func_77655_b("Stone Knife").func_77656_e(igExStoneUses);
/*  523 */     singlePlank = (new ItemPlank()).func_77655_b("SinglePlank");
/*      */     
/*  525 */     redSteelBucketEmpty = (new ItemSteelBucketRed(Blocks.field_150350_a)).func_77655_b("Red Steel Bucket Empty");
/*  526 */     redSteelBucketWater = (new ItemSteelBucketRed(TFCBlocks.freshWater)).func_77655_b("Red Steel Bucket Water").func_77642_a(redSteelBucketEmpty);
/*  527 */     redSteelBucketSaltWater = (new ItemSteelBucketRed(TFCBlocks.saltWater)).func_77655_b("Red Steel Bucket Salt Water").func_77642_a(redSteelBucketEmpty);
/*      */     
/*  529 */     blueSteelBucketEmpty = (new ItemSteelBucketBlue(Blocks.field_150350_a)).func_77655_b("Blue Steel Bucket Empty");
/*  530 */     blueSteelBucketLava = (new ItemSteelBucketBlue(TFCBlocks.lava)).func_77655_b("Blue Steel Bucket Lava").func_77642_a(blueSteelBucketEmpty);
/*      */     
/*  532 */     quern = (Item)((ItemTerra)(new ItemTerra()).func_77655_b("Quern").func_77656_e(250)).setSize(EnumSize.MEDIUM).setWeight(EnumWeight.HEAVY);
/*  533 */     flintSteel = (new ItemFlintSteel()).func_77655_b("flintAndSteel").func_77656_e(200).func_111206_d("flint_and_steel");
/*      */     
/*  535 */     doorOak = (new ItemWoodDoor(0)).func_77655_b("Oak Door");
/*  536 */     doorAspen = (new ItemWoodDoor(1)).func_77655_b("Aspen Door");
/*  537 */     doorBirch = (new ItemWoodDoor(2)).func_77655_b("Birch Door");
/*  538 */     doorChestnut = (new ItemWoodDoor(3)).func_77655_b("Chestnut Door");
/*  539 */     doorDouglasFir = (new ItemWoodDoor(4)).func_77655_b("Douglas Fir Door");
/*  540 */     doorHickory = (new ItemWoodDoor(5)).func_77655_b("Hickory Door");
/*  541 */     doorMaple = (new ItemWoodDoor(6)).func_77655_b("Maple Door");
/*  542 */     doorAsh = (new ItemWoodDoor(7)).func_77655_b("Ash Door");
/*  543 */     doorPine = (new ItemWoodDoor(8)).func_77655_b("Pine Door");
/*  544 */     doorSequoia = (new ItemWoodDoor(9)).func_77655_b("Sequoia Door");
/*  545 */     doorSpruce = (new ItemWoodDoor(10)).func_77655_b("Spruce Door");
/*  546 */     doorSycamore = (new ItemWoodDoor(11)).func_77655_b("Sycamore Door");
/*  547 */     doorWhiteCedar = (new ItemWoodDoor(12)).func_77655_b("White Cedar Door");
/*  548 */     doorWhiteElm = (new ItemWoodDoor(13)).func_77655_b("White Elm Door");
/*  549 */     doorWillow = (new ItemWoodDoor(14)).func_77655_b("Willow Door");
/*  550 */     doorKapok = (new ItemWoodDoor(15)).func_77655_b("Kapok Door");
/*  551 */     doorAcacia = (new ItemWoodDoor(16)).func_77655_b("Acacia Door");
/*      */     
/*  553 */     beer = (new ItemAlcohol()).func_77655_b("Beer").func_77637_a(TFCTabs.TFC_FOODS);
/*  554 */     cider = (new ItemAlcohol()).func_77655_b("Cider").func_77637_a(TFCTabs.TFC_FOODS);
/*  555 */     rum = (new ItemAlcohol()).func_77655_b("Rum").func_77637_a(TFCTabs.TFC_FOODS);
/*  556 */     ryeWhiskey = (new ItemAlcohol()).func_77655_b("RyeWhiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*  557 */     sake = (new ItemAlcohol()).func_77655_b("Sake").func_77637_a(TFCTabs.TFC_FOODS);
/*  558 */     vodka = (new ItemAlcohol()).func_77655_b("Vodka").func_77637_a(TFCTabs.TFC_FOODS);
/*  559 */     whiskey = (new ItemAlcohol()).func_77655_b("Whiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*  560 */     cornWhiskey = (new ItemAlcohol()).func_77655_b("CornWhiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*      */     
/*  562 */     blueprint = (Item)new ItemBlueprint();
/*  563 */     nametag = (Item)new ItemCustomNameTag();
/*      */     
/*  565 */     woolYarn = (new ItemYarn()).func_77655_b("WoolYarn").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  566 */     wool = (new ItemTerra()).func_77655_b("Wool").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  567 */     woolCloth = (new ItemTerra()).func_77655_b("WoolCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  568 */     silkCloth = (new ItemTerra()).func_77655_b("SilkCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  569 */     burlapCloth = (new ItemTerra()).func_77655_b("BurlapCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  570 */     spindle = (new ItemSpindle()).func_77655_b("Spindle").func_77637_a(TFCTabs.TFC_POTTERY);
/*      */ 
/*      */     
/*  573 */     spindleHead = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Spindle", "Spindle Head" }).func_77655_b("Spindle Head").func_77637_a(TFCTabs.TFC_POTTERY);
/*  574 */     stoneBrick = (new ItemStoneBrick()).setFolder("tools/").func_77655_b("ItemStoneBrick");
/*  575 */     mortar = (new ItemTerra()).setFolder("tools/").func_77655_b("Mortar").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  576 */     vinegar = (new ItemCustomBucket(Blocks.field_150350_a)).setFolder("food/").func_77655_b("Vinegar").func_77642_a(woodenBucketEmpty).func_77637_a(TFCTabs.TFC_FOODS);
/*  577 */     hide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  578 */     soakedHide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Soaked Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  579 */     scrapedHide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Scraped Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  580 */     prepHide = (new ItemRawHide()).setFolder("tools/").setFolder("tools/").func_77655_b("Prep Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  582 */     sheepSkin = (new ItemRawHide()).setFolder("tools/").func_77655_b("Sheep Skin").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  583 */     pbearSkin = (new ItemRawHide()).setFolder("tools/").func_77655_b("Polar Bear Skin").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  584 */     flatLeather = (new ItemFlatGeneric()).setFolder("tools/").func_77655_b("Flat Leather");
/*  585 */     leather = (new ItemLeather()).setSpecialCraftingType(flatLeather).setFolder("tools/").func_77655_b("TFC Leather");
/*      */     
/*  587 */     straw = (new ItemTerra()).setFolder("plants/").func_77655_b("Straw").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  589 */     flatClay = (new ItemFlatGeneric()).setFolder("pottery/").setMetaNames(new String[] { "clay flat light", "clay flat dark", "clay flat fire", "clay flat dark fire" }).func_77655_b("Flat Clay");
/*      */     
/*  591 */     potteryJug = (new ItemPotteryJug()).func_77655_b("Jug");
/*  592 */     potterySmallVessel = (new ItemPotterySmallVessel()).func_77655_b("Small Vessel");
/*      */     
/*  594 */     ceramicMold = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Mold", "Ceramic Mold" }).func_77655_b("Mold");
/*  595 */     potteryBowl = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Bowl", "Ceramic Bowl" }).func_77655_b("ClayBowl");
/*  596 */     clayBall = (new ItemClay()).setSpecialCraftingType(flatClay, new ItemStack(flatClay, 1, 1)).setMetaNames(new String[] { "Clay", "Fire Clay" }).func_77655_b("Clay");
/*  597 */     fireBrick = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Fire Brick", "Fire Brick" }).func_77655_b("Fire Brick");
/*      */ 
/*      */     
/*  600 */     clayMoldAxe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Axe", "Ceramic Mold Axe", "Ceramic Mold Axe Copper", "Ceramic Mold Axe Bronze", "Ceramic Mold Axe Bismuth Bronze", "Ceramic Mold Axe Black Bronze" }).func_77655_b("Axe Mold");
/*      */     
/*  602 */     clayMoldChisel = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Chisel", "Ceramic Mold Chisel", "Ceramic Mold Chisel Copper", "Ceramic Mold Chisel Bronze", "Ceramic Mold Chisel Bismuth Bronze", "Ceramic Mold Chisel Black Bronze" }).func_77655_b("Chisel Mold");
/*      */     
/*  604 */     clayMoldHammer = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Hammer", "Ceramic Mold Hammer", "Ceramic Mold Hammer Copper", "Ceramic Mold Hammer Bronze", "Ceramic Mold Hammer Bismuth Bronze", "Ceramic Mold Hammer Black Bronze" }).func_77655_b("Hammer Mold");
/*      */     
/*  606 */     clayMoldHoe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Hoe", "Ceramic Mold Hoe", "Ceramic Mold Hoe Copper", "Ceramic Mold Hoe Bronze", "Ceramic Mold Hoe Bismuth Bronze", "Ceramic Mold Hoe Black Bronze" }).func_77655_b("Hoe Mold");
/*      */     
/*  608 */     clayMoldKnife = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Knife", "Ceramic Mold Knife", "Ceramic Mold Knife Copper", "Ceramic Mold Knife Bronze", "Ceramic Mold Knife Bismuth Bronze", "Ceramic Mold Knife Black Bronze" }).func_77655_b("Knife Mold");
/*      */     
/*  610 */     clayMoldMace = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Mace", "Ceramic Mold Mace", "Ceramic Mold Mace Copper", "Ceramic Mold Mace Bronze", "Ceramic Mold Mace Bismuth Bronze", "Ceramic Mold Mace Black Bronze" }).func_77655_b("Mace Mold");
/*      */     
/*  612 */     clayMoldPick = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Pick", "Ceramic Mold Pick", "Ceramic Mold Pick Copper", "Ceramic Mold Pick Bronze", "Ceramic Mold Pick Bismuth Bronze", "Ceramic Mold Pick Black Bronze" }).func_77655_b("Pick Mold");
/*      */     
/*  614 */     clayMoldProPick = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold ProPick", "Ceramic Mold ProPick", "Ceramic Mold ProPick Copper", "Ceramic Mold ProPick Bronze", "Ceramic Mold ProPick Bismuth Bronze", "Ceramic Mold ProPick Black Bronze" }).func_77655_b("ProPick Mold");
/*      */     
/*  616 */     clayMoldSaw = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Saw", "Ceramic Mold Saw", "Ceramic Mold Saw Copper", "Ceramic Mold Saw Bronze", "Ceramic Mold Saw Bismuth Bronze", "Ceramic Mold Saw Black Bronze" }).func_77655_b("Saw Mold");
/*      */     
/*  618 */     clayMoldScythe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Scythe", "Ceramic Mold Scythe", "Ceramic Mold Scythe Copper", "Ceramic Mold Scythe Bronze", "Ceramic Mold Scythe Bismuth Bronze", "Ceramic Mold Scythe Black Bronze" }).func_77655_b("Scythe Mold");
/*      */     
/*  620 */     clayMoldShovel = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Shovel", "Ceramic Mold Shovel", "Ceramic Mold Shovel Copper", "Ceramic Mold Shovel Bronze", "Ceramic Mold Shovel Bismuth Bronze", "Ceramic Mold Shovel Black Bronze" }).func_77655_b("Shovel Mold");
/*      */     
/*  622 */     clayMoldSword = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Sword", "Ceramic Mold Sword", "Ceramic Mold Sword Copper", "Ceramic Mold Sword Bronze", "Ceramic Mold Sword Bismuth Bronze", "Ceramic Mold Sword Black Bronze" }).func_77655_b("Sword Mold");
/*      */     
/*  624 */     clayMoldJavelin = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Javelin", "Ceramic Mold Javelin", "Ceramic Mold Javelin Copper", "Ceramic Mold Javelin Bronze", "Ceramic Mold Javelin Bismuth Bronze", "Ceramic Mold Javelin Black Bronze" }).func_77655_b("Javelin Mold");
/*      */     
/*  626 */     tuyereCopper = (new ItemTuyere(40, 0)).func_77655_b("Copper Tuyere");
/*  627 */     tuyereBronze = (new ItemTuyere(80, 1)).func_77655_b("Bronze Tuyere");
/*  628 */     tuyereBlackBronze = (new ItemTuyere(80, 1)).func_77655_b("Black Bronze Tuyere");
/*  629 */     tuyereBismuthBronze = (new ItemTuyere(80, 1)).func_77655_b("Bismuth Bronze Tuyere");
/*  630 */     tuyereWroughtIron = (new ItemTuyere(120, 2)).func_77655_b("Wrought Iron Tuyere");
/*  631 */     tuyereSteel = (new ItemTuyere(180, 3)).func_77655_b("Steel Tuyere");
/*  632 */     tuyereBlackSteel = (new ItemTuyere(260, 4)).func_77655_b("Black Steel Tuyere");
/*  633 */     tuyereRedSteel = (new ItemTuyere(400, 5)).func_77655_b("Red Steel Tuyere");
/*  634 */     tuyereBlueSteel = (new ItemTuyere(500, 6)).func_77655_b("Blue Steel Tuyere");
/*      */     
/*  636 */     bloom = (new ItemBloom()).setFolder("ingots/").func_77655_b("Iron Bloom");
/*  637 */     rawBloom = (new ItemBloom()).setFolder("ingots/").func_77655_b("Raw Iron Bloom");
/*      */     
/*  639 */     unknownIngot = (new ItemIngot()).func_77655_b("Unknown Ingot");
/*  640 */     unknownUnshaped = (new ItemMeltedMetal()).func_77655_b("Unknown Unshaped");
/*      */     
/*  642 */     jute = (new ItemTerra()).setFolder("plants/").func_77655_b("Jute").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  643 */     juteFiber = (new ItemTerra()).setFolder("plants/").func_77655_b("Jute Fibre").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  645 */     Items.field_151120_aE.func_77637_a(null);
/*  646 */     reeds = (new ItemReeds()).func_77655_b("Reeds").func_77637_a(TFCTabs.TFC_MATERIALS).func_111206_d("reeds");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  651 */     setupFood();
/*      */     
/*  653 */     fertilizer = (new ItemFertilizer()).func_77655_b("Fertilizer").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */ 
/*      */     
/*  656 */     setupArmor();
/*      */     
/*  658 */     Recipes.doors = new Item[] { doorOak, doorAspen, doorBirch, doorChestnut, doorDouglasFir, doorHickory, doorMaple, doorAsh, doorPine, doorSequoia, doorSpruce, doorSycamore, doorWhiteCedar, doorWhiteElm, doorWillow, doorKapok, doorAcacia };
/*      */ 
/*      */ 
/*      */     
/*  662 */     Recipes.axes = new Item[] { sedAxe, igInAxe, igExAxe, mMAxe, bismuthBronzeAxe, blackBronzeAxe, blackSteelAxe, blueSteelAxe, bronzeAxe, copperAxe, wroughtIronAxe, redSteelAxe, steelAxe };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  667 */     Recipes.chisels = new Item[] { bismuthBronzeChisel, blackBronzeChisel, blackSteelChisel, blueSteelChisel, bronzeChisel, copperChisel, wroughtIronChisel, redSteelChisel, steelChisel };
/*      */ 
/*      */ 
/*      */     
/*  671 */     Recipes.saws = new Item[] { bismuthBronzeSaw, blackBronzeSaw, blackSteelSaw, blueSteelSaw, bronzeSaw, copperSaw, wroughtIronSaw, redSteelSaw, steelSaw };
/*      */ 
/*      */ 
/*      */     
/*  675 */     Recipes.knives = new Item[] { stoneKnife, bismuthBronzeKnife, blackBronzeKnife, blackSteelKnife, blueSteelKnife, bronzeKnife, copperKnife, wroughtIronKnife, redSteelKnife, steelKnife };
/*      */ 
/*      */ 
/*      */     
/*  679 */     Recipes.meltedMetal = new Item[] { bismuthUnshaped, bismuthBronzeUnshaped, blackBronzeUnshaped, blackSteelUnshaped, blueSteelUnshaped, brassUnshaped, bronzeUnshaped, copperUnshaped, goldUnshaped, wroughtIronUnshaped, leadUnshaped, nickelUnshaped, pigIronUnshaped, platinumUnshaped, redSteelUnshaped, roseGoldUnshaped, silverUnshaped, steelUnshaped, sterlingSilverUnshaped, tinUnshaped, zincUnshaped, electrumUnshaped, cupronickelUnshaped, highCarbonSteelUnshaped, weakSteelUnshaped, highCarbonBlackSteelUnshaped, highCarbonBlueSteelUnshaped, highCarbonRedSteelUnshaped, weakBlueSteelUnshaped, weakRedSteelUnshaped };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  687 */     Recipes.hammers = new Item[] { stoneHammer, bismuthBronzeHammer, blackBronzeHammer, blackSteelHammer, blueSteelHammer, bronzeHammer, copperHammer, wroughtIronHammer, redSteelHammer, steelHammer };
/*      */ 
/*      */ 
/*      */     
/*  691 */     Recipes.scythes = new Item[] { bismuthBronzeScythe, blackBronzeScythe, blackSteelScythe, blueSteelScythe, bronzeScythe, copperScythe, wroughtIronScythe, redSteelScythe, steelScythe };
/*      */ 
/*      */ 
/*      */     
/*  695 */     Recipes.picks = new Item[] { bismuthBronzePick, blackBronzePick, blackSteelPick, blueSteelPick, bronzePick, copperPick, wroughtIronPick, redSteelPick, steelPick };
/*      */ 
/*      */ 
/*      */     
/*  699 */     Recipes.proPicks = new Item[] { proPickBismuthBronze, proPickBlackBronze, proPickBlackSteel, proPickBlueSteel, proPickBronze, proPickCopper, proPickIron, proPickRedSteel, proPickSteel };
/*      */ 
/*      */ 
/*      */     
/*  703 */     Recipes.shovels = new Item[] { sedShovel, igInShovel, igExShovel, mMShovel, bismuthBronzeShovel, blackBronzeShovel, blackSteelShovel, blueSteelShovel, bronzeShovel, copperShovel, wroughtIronShovel, redSteelShovel, steelShovel };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  708 */     Recipes.hoes = new Item[] { sedHoe, igInHoe, igExHoe, mMHoe, bismuthBronzeHoe, blackBronzeHoe, blackSteelHoe, blueSteelHoe, bronzeHoe, copperHoe, wroughtIronHoe, redSteelHoe, steelHoe };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  713 */     Recipes.swords = new Item[] { bismuthBronzeSword, blackBronzeSword, blackSteelSword, blueSteelSword, bronzeSword, copperSword, wroughtIronSword, redSteelSword, steelSword };
/*      */ 
/*      */ 
/*      */     
/*  717 */     Recipes.maces = new Item[] { bismuthBronzeMace, blackBronzeMace, blackSteelMace, blueSteelMace, bronzeMace, copperMace, wroughtIronMace, redSteelMace, steelMace };
/*      */ 
/*      */ 
/*      */     
/*  721 */     Recipes.javelins = new Item[] { sedStoneJavelin, igInStoneJavelin, igExStoneJavelin, mMStoneJavelin, bismuthBronzeJavelin, blackBronzeJavelin, blackSteelJavelin, blueSteelJavelin, bronzeJavelin, copperJavelin, wroughtIronJavelin, redSteelJavelin, steelJavelin };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  727 */     Recipes.tuyeres = new Item[] { tuyereBismuthBronze, tuyereBlackBronze, tuyereBlackSteel, tuyereBlueSteel, tuyereBronze, tuyereCopper, tuyereWroughtIron, tuyereRedSteel, tuyereSteel };
/*      */ 
/*      */ 
/*      */     
/*  731 */     Recipes.spindle = new Item[] { spindle };
/*      */     
/*  733 */     Recipes.gems = new Item[] { gemAgate, gemAmethyst, gemBeryl, gemDiamond, gemEmerald, gemGarnet, gemJade, gemJasper, gemOpal, gemRuby, gemSapphire, gemTopaz, gemTourmaline };
/*      */ 
/*      */     
/*  736 */     Recipes.seeds = new Item[] { seedsBarley, seedsCabbage, seedsCarrot, seedsGarlic, seedsGreenbean, seedsJute, seedsMaize, seedsOat, seedsOnion, seedsPotato, seedsRedBellPepper, seedsRice, seedsRye, seedsSoybean, seedsSquash, seedsSugarcane, seedsTomato, seedsWheat, seedsYellowBellPepper };
/*      */ 
/*      */ 
/*      */     
/*  740 */     ((TFCTabs)TFCTabs.TFC_BUILDING).setTabIconItemStack(new ItemStack(TFCBlocks.stoneSedBrick));
/*  741 */     ((TFCTabs)TFCTabs.TFC_DECORATION).setTabIconItemStack(new ItemStack(TFCBlocks.flora));
/*  742 */     ((TFCTabs)TFCTabs.TFC_DEVICES).setTabIconItem(sluiceItem);
/*  743 */     ((TFCTabs)TFCTabs.TFC_POTTERY).setTabIconItemStack(new ItemStack(potteryJug, 1, 1));
/*  744 */     ((TFCTabs)TFCTabs.TFC_MISC).setTabIconItem(blueSteelBucketLava);
/*  745 */     ((TFCTabs)TFCTabs.TFC_FOODS).setTabIconItem(redApple);
/*  746 */     ((TFCTabs)TFCTabs.TFC_TOOLS).setTabIconItem(redSteelAxe);
/*  747 */     ((TFCTabs)TFCTabs.TFC_WEAPONS).setTabIconItem(bismuthBronzeSword);
/*  748 */     ((TFCTabs)TFCTabs.TFC_ARMOR).setTabIconItem(bronzeHelmet);
/*  749 */     ((TFCTabs)TFCTabs.TFC_MATERIALS).setTabIconItem(blueSteelIngot);
/*      */     
/*  751 */     registerItems();
/*  752 */     registerMetals();
/*      */     
/*  754 */     TerraFirmaCraft.LOG.info("Finished Loading Items");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void setupFood() {
/*  762 */     foodList = new ArrayList();
/*      */     
/*  764 */     egg = (new ItemEgg()).setSize(EnumSize.SMALL).func_77655_b("egg").func_111206_d("egg").func_77637_a(TFCTabs.TFC_FOODS);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  769 */     porkchopRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Porkchop");
/*  770 */     fishRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, true)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Fish");
/*  771 */     beefRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 50, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Beef");
/*  772 */     bearRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 50, false, false)).setDecayRate(4.0F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Bear");
/*  773 */     chickenRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Chicken");
/*  774 */     soybean = (new ItemFoodTFC(EnumFoodGroup.Protein, 10, 0, 0, 0, 40, true)).func_77655_b("Soybeans");
/*  775 */     eggCooked = (new ItemFoodTFC(EnumFoodGroup.Protein, 0, 0, 0, 0, 25)).setDecayRate(2.5F).func_77655_b("Egg Cooked");
/*  776 */     calamariRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 20, 0, 35, false, false)).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).setDecayRate(4.0F).func_77655_b("Calamari");
/*  777 */     muttonRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Mutton");
/*  778 */     venisonRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 5, 0, 0, 0, 50, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Venison");
/*  779 */     horseMeatRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("HorseMeat");
/*      */ 
/*      */     
/*  782 */     cheese = (new ItemFoodTFC(EnumFoodGroup.Dairy, 0, 10, 20, 0, 35)).setDecayRate(0.5F).setCanSmoke().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Cheese");
/*      */ 
/*      */     
/*  785 */     wheatGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Wheat Grain");
/*  786 */     barleyGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 10, 20)).setDecayRate(0.5F).func_77655_b("Barley Grain");
/*  787 */     oatGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Oat Grain");
/*  788 */     ryeGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Rye Grain");
/*  789 */     riceGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Rice Grain");
/*  790 */     maizeEar = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 5, 20, true)).func_77655_b("Maize Ear");
/*      */     
/*  792 */     wheatWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Wheat Whole");
/*  793 */     barleyWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 10, 20, false, false)).setFolder("food/").func_77655_b("Barley Whole");
/*  794 */     oatWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Oat Whole");
/*  795 */     ryeWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Rye Whole");
/*  796 */     riceWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Rice Whole");
/*      */     
/*  798 */     wheatGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Wheat Ground");
/*  799 */     barleyGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Barley Ground");
/*  800 */     oatGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Oat Ground");
/*  801 */     ryeGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Rye Ground");
/*  802 */     riceGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Rice Ground");
/*  803 */     cornmealGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Cornmeal Ground");
/*      */     
/*  805 */     wheatDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Wheat Dough");
/*  806 */     barleyDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).func_77655_b("Barley Dough");
/*  807 */     oatDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Oat Dough");
/*  808 */     ryeDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20, false, false)).func_77655_b("Rye Dough");
/*  809 */     riceDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Rice Dough");
/*  810 */     cornmealDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20, false, false)).func_77655_b("Cornmeal Dough");
/*      */     
/*  812 */     wheatBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Wheat Bread");
/*  813 */     barleyBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).func_77655_b("Barley Bread");
/*  814 */     oatBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Oat Bread");
/*  815 */     ryeBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20)).func_77655_b("Rye Bread");
/*  816 */     riceBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Rice Bread");
/*  817 */     cornBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20)).func_77655_b("Corn Bread");
/*      */ 
/*      */     
/*  820 */     tomato = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 30, 5, 0, 0, 50, true)).func_77655_b("Tomato");
/*  821 */     potato = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 10, 15, 20, true)).func_77655_b("Potato");
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
/*  841 */     onion = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 25, 0, 0, 20, true) { public void func_94581_a(IIconRegister registerer) { super.func_94581_a(registerer); this.field_77787_bX = true; this.metaIcons = new IIcon[2]; this.metaIcons[0] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", "")); this.metaIcons[1] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + "Rutabaga"); } public IIcon func_77617_a(int i) { if (i == 1) return this.metaIcons[1];  return super.func_77617_a(i); } }).func_77655_b(TFCOptions.onionsAreGross ? "Rutabaga" : "Onion");
/*  842 */     cabbage = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 0, 0, 0, 30, true)).func_77655_b("Cabbage");
/*  843 */     garlic = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 0, 10, 20, true)).func_77655_b("Garlic");
/*  844 */     carrot = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Carrot");
/*  845 */     greenbeans = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Greenbeans");
/*  846 */     greenBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 0, 0, 0, 20, true)).func_77655_b("Green Bell Pepper");
/*  847 */     yellowBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 15, 0, 0, 0, 20, true)).func_77655_b("Yellow Bell Pepper");
/*  848 */     redBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Red Bell Pepper");
/*  849 */     squash = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Squash");
/*  850 */     seaWeed = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 10, 10, 10, true)).func_77655_b("Sea Weed");
/*  851 */     sugar = (new ItemFoodTFC(EnumFoodGroup.None, 30, 0, 0, 0, 0, true)).setDecayRate(0.01F).func_77655_b("Sugar");
/*      */ 
/*      */     
/*  854 */     redApple = (new ItemFoodTFC(EnumFoodGroup.Fruit, 25, 5, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[0]);
/*  855 */     banana = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[1]);
/*  856 */     orange = (new ItemFoodTFC(EnumFoodGroup.Fruit, 50, 30, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[2]);
/*  857 */     greenApple = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 15, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[3]);
/*  858 */     lemon = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 50, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[4]);
/*  859 */     olive = (new ItemFoodTFC(EnumFoodGroup.Fruit, 10, 0, 3, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[5]);
/*  860 */     cherry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[6]);
/*  861 */     peach = (new ItemFoodTFC(EnumFoodGroup.Fruit, 25, 10, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[7]);
/*  862 */     plum = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 15, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[8]);
/*      */     
/*  864 */     wintergreenBerry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 0, 0, 20, 0)).setDecayRate(2.0F).func_77655_b("Wintergreen Berry");
/*  865 */     blueberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 20, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Blueberry");
/*  866 */     raspberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 35, 15, 0, 5, 0)).setDecayRate(2.0F).func_77655_b("Raspberry");
/*  867 */     strawberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 5, 0)).setDecayRate(2.0F).func_77655_b("Strawberry");
/*  868 */     blackberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 30, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Blackberry");
/*  869 */     bunchberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 5, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Bunchberry");
/*  870 */     cranberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 45, 0)).setDecayRate(2.0F).func_77655_b("Cranberry");
/*  871 */     snowberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 10, 0, 0, 90, 0)).setDecayRate(2.0F).func_77655_b("Snowberry");
/*  872 */     elderberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 40, 0, 10, 0)).setDecayRate(2.0F).func_77655_b("Elderberry");
/*  873 */     gooseberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 40, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Gooseberry");
/*  874 */     cloudberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 40, 40, 0, 30, 0)).setDecayRate(2.0F).func_77655_b("Cloudberry");
/*      */     
/*  876 */     sandwich = (new ItemSandwich()).func_77655_b("Sandwich");
/*  877 */     salad = (new ItemSalad()).func_77655_b("Salad");
/*      */ 
/*      */     
/*  880 */     sugarcane = (new ItemFoodTFC(EnumFoodGroup.None, 30, 0, 0, 0, 0, false, false)).setDecayRate(0.75F).setFolder("plants/").func_77655_b("Sugarcane");
/*      */ 
/*      */     
/*  883 */     seedsWheat = (new ItemCustomSeeds(0)).func_77655_b("Seeds Wheat");
/*  884 */     seedsMaize = (new ItemCustomSeeds(1)).func_77655_b("Seeds Maize");
/*  885 */     seedsTomato = (new ItemCustomSeeds(2)).func_77655_b("Seeds Tomato");
/*  886 */     seedsBarley = (new ItemCustomSeeds(3)).func_77655_b("Seeds Barley");
/*  887 */     seedsRye = (new ItemCustomSeeds(4)).func_77655_b("Seeds Rye");
/*  888 */     seedsOat = (new ItemCustomSeeds(5)).func_77655_b("Seeds Oat");
/*  889 */     seedsRice = (new ItemCustomSeeds(6)).func_77655_b("Seeds Rice");
/*  890 */     seedsPotato = (new ItemCustomSeeds(7)).func_77655_b("Seeds Potato");
/*  891 */     seedsOnion = (new ItemCustomSeeds(8)).func_77655_b(TFCOptions.onionsAreGross ? "Seeds Rutabaga" : "Seeds Onion");
/*  892 */     seedsCabbage = (new ItemCustomSeeds(9)).func_77655_b("Seeds Cabbage");
/*  893 */     seedsGarlic = (new ItemCustomSeeds(10)).func_77655_b("Seeds Garlic");
/*  894 */     seedsCarrot = (new ItemCustomSeeds(11)).func_77655_b("Seeds Carrot");
/*  895 */     seedsYellowBellPepper = (new ItemCustomSeeds(12)).func_77655_b("Seeds Yellow Bell Pepper");
/*  896 */     seedsRedBellPepper = (new ItemCustomSeeds(13)).func_77655_b("Seeds Red Bell Pepper");
/*  897 */     seedsSoybean = (new ItemCustomSeeds(14)).func_77655_b("Seeds Soybean");
/*  898 */     seedsGreenbean = (new ItemCustomSeeds(15)).func_77655_b("Seeds Greenbean");
/*  899 */     seedsSquash = (new ItemCustomSeeds(16)).func_77655_b("Seeds Squash");
/*  900 */     seedsJute = (new ItemCustomSeeds(17)).func_77655_b("Seeds Jute");
/*  901 */     seedsSugarcane = (new ItemCustomSeeds(18)).func_77655_b("Seeds Sugarcane");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  906 */     fruitTreeSapling = (new ItemFruitTreeSapling()).func_77655_b("FruitSapling");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerMetals() {
/*  926 */     Global.BISMUTH = new Metal("Bismuth", TFCItems.bismuthUnshaped, TFCItems.bismuthIngot);
/*  927 */     Global.BISMUTHBRONZE = new Metal("Bismuth Bronze", TFCItems.bismuthBronzeUnshaped, TFCItems.bismuthBronzeIngot);
/*  928 */     Global.BLACKBRONZE = new Metal("Black Bronze", TFCItems.blackBronzeUnshaped, TFCItems.blackBronzeIngot);
/*  929 */     Global.BLACKSTEEL = new Metal("Black Steel", TFCItems.blackSteelUnshaped, TFCItems.blackSteelIngot);
/*  930 */     Global.BLUESTEEL = new Metal("Blue Steel", TFCItems.blueSteelUnshaped, TFCItems.blueSteelIngot);
/*  931 */     Global.BRASS = new Metal("Brass", TFCItems.brassUnshaped, TFCItems.brassIngot);
/*  932 */     Global.BRONZE = new Metal("Bronze", TFCItems.bronzeUnshaped, TFCItems.bronzeIngot);
/*  933 */     Global.COPPER = new Metal("Copper", TFCItems.copperUnshaped, TFCItems.copperIngot);
/*  934 */     Global.GOLD = new Metal("Gold", TFCItems.goldUnshaped, TFCItems.goldIngot);
/*  935 */     Global.WROUGHTIRON = new Metal("Wrought Iron", TFCItems.wroughtIronUnshaped, TFCItems.wroughtIronIngot);
/*  936 */     Global.LEAD = new Metal("Lead", TFCItems.leadUnshaped, TFCItems.leadIngot);
/*  937 */     Global.NICKEL = new Metal("Nickel", TFCItems.nickelUnshaped, TFCItems.nickelIngot);
/*  938 */     Global.PIGIRON = new Metal("Pig Iron", TFCItems.pigIronUnshaped, TFCItems.pigIronIngot);
/*  939 */     Global.PLATINUM = new Metal("Platinum", TFCItems.platinumUnshaped, TFCItems.platinumIngot);
/*  940 */     Global.REDSTEEL = new Metal("Red Steel", TFCItems.redSteelUnshaped, TFCItems.redSteelIngot);
/*  941 */     Global.ROSEGOLD = new Metal("Rose Gold", TFCItems.roseGoldUnshaped, TFCItems.roseGoldIngot);
/*  942 */     Global.SILVER = new Metal("Silver", TFCItems.silverUnshaped, TFCItems.silverIngot);
/*  943 */     Global.STEEL = new Metal("Steel", TFCItems.steelUnshaped, TFCItems.steelIngot);
/*  944 */     Global.STERLINGSILVER = new Metal("Sterling Silver", TFCItems.sterlingSilverUnshaped, TFCItems.sterlingSilverIngot);
/*  945 */     Global.TIN = new Metal("Tin", TFCItems.tinUnshaped, TFCItems.tinIngot);
/*  946 */     Global.ZINC = new Metal("Zinc", TFCItems.zincUnshaped, TFCItems.zincIngot);
/*  947 */     Global.ELECTRUM = new Metal("Electrum", TFCItems.electrumUnshaped, TFCItems.electrumIngot);
/*  948 */     Global.CUPRONICKEL = new Metal("Cupronickel", TFCItems.cupronickelUnshaped, TFCItems.cupronickelIngot);
/*  949 */     Global.WEAKSTEEL = new Metal("Weak Steel", TFCItems.weakSteelUnshaped, TFCItems.weakSteelIngot);
/*  950 */     Global.HCBLACKSTEEL = new Metal("HC Black Steel", TFCItems.highCarbonBlackSteelUnshaped, TFCItems.highCarbonBlackSteelIngot);
/*  951 */     Global.WEAKREDSTEEL = new Metal("Weak Red Steel", TFCItems.weakRedSteelUnshaped, TFCItems.weakRedSteelIngot);
/*  952 */     Global.HCREDSTEEL = new Metal("HC Red Steel", TFCItems.highCarbonRedSteelUnshaped, TFCItems.highCarbonRedSteelIngot);
/*  953 */     Global.WEAKBLUESTEEL = new Metal("Weak Blue Steel", TFCItems.weakBlueSteelUnshaped, TFCItems.weakBlueSteelIngot);
/*  954 */     Global.HCBLUESTEEL = new Metal("HC Blue Steel", TFCItems.highCarbonBlueSteelUnshaped, TFCItems.highCarbonBlueSteelIngot);
/*  955 */     Global.UNKNOWN = new Metal("Unknown", TFCItems.unknownUnshaped, TFCItems.unknownIngot, false);
/*      */     
/*  957 */     MetalRegistry.instance.addMetal(Global.BISMUTH, Alloy.EnumTier.TierI);
/*  958 */     MetalRegistry.instance.addMetal(Global.BISMUTHBRONZE, Alloy.EnumTier.TierI);
/*  959 */     MetalRegistry.instance.addMetal(Global.BLACKBRONZE, Alloy.EnumTier.TierI);
/*  960 */     MetalRegistry.instance.addMetal(Global.BLACKSTEEL, Alloy.EnumTier.TierV);
/*  961 */     MetalRegistry.instance.addMetal(Global.BLUESTEEL, Alloy.EnumTier.TierV);
/*  962 */     MetalRegistry.instance.addMetal(Global.BRASS, Alloy.EnumTier.TierI);
/*  963 */     MetalRegistry.instance.addMetal(Global.BRONZE, Alloy.EnumTier.TierI);
/*  964 */     MetalRegistry.instance.addMetal(Global.COPPER, Alloy.EnumTier.TierI);
/*  965 */     MetalRegistry.instance.addMetal(Global.GOLD, Alloy.EnumTier.TierI);
/*  966 */     MetalRegistry.instance.addMetal(Global.WROUGHTIRON, Alloy.EnumTier.TierIII);
/*  967 */     MetalRegistry.instance.addMetal(Global.LEAD, Alloy.EnumTier.TierI);
/*  968 */     MetalRegistry.instance.addMetal(Global.NICKEL, Alloy.EnumTier.TierI);
/*  969 */     MetalRegistry.instance.addMetal(Global.PIGIRON, Alloy.EnumTier.TierIV);
/*  970 */     MetalRegistry.instance.addMetal(Global.PLATINUM, Alloy.EnumTier.TierV);
/*  971 */     MetalRegistry.instance.addMetal(Global.REDSTEEL, Alloy.EnumTier.TierV);
/*  972 */     MetalRegistry.instance.addMetal(Global.ROSEGOLD, Alloy.EnumTier.TierI);
/*  973 */     MetalRegistry.instance.addMetal(Global.SILVER, Alloy.EnumTier.TierI);
/*  974 */     MetalRegistry.instance.addMetal(Global.STEEL, Alloy.EnumTier.TierIV);
/*  975 */     MetalRegistry.instance.addMetal(Global.STERLINGSILVER, Alloy.EnumTier.TierI);
/*  976 */     MetalRegistry.instance.addMetal(Global.TIN, Alloy.EnumTier.TierI);
/*  977 */     MetalRegistry.instance.addMetal(Global.ZINC, Alloy.EnumTier.TierI);
/*  978 */     MetalRegistry.instance.addMetal(Global.ELECTRUM, Alloy.EnumTier.TierI);
/*  979 */     MetalRegistry.instance.addMetal(Global.CUPRONICKEL, Alloy.EnumTier.TierI);
/*  980 */     MetalRegistry.instance.addMetal(Global.WEAKSTEEL, Alloy.EnumTier.TierV);
/*  981 */     MetalRegistry.instance.addMetal(Global.HCBLACKSTEEL, Alloy.EnumTier.TierV);
/*  982 */     MetalRegistry.instance.addMetal(Global.WEAKREDSTEEL, Alloy.EnumTier.TierV);
/*  983 */     MetalRegistry.instance.addMetal(Global.HCREDSTEEL, Alloy.EnumTier.TierV);
/*  984 */     MetalRegistry.instance.addMetal(Global.WEAKBLUESTEEL, Alloy.EnumTier.TierV);
/*  985 */     MetalRegistry.instance.addMetal(Global.HCBLUESTEEL, Alloy.EnumTier.TierV);
/*  986 */     MetalRegistry.instance.addMetal(Global.UNKNOWN, Alloy.EnumTier.TierI);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  991 */     Alloy bronze = new Alloy(Global.BRONZE, Alloy.EnumTier.TierI);
/*  992 */     bronze.addIngred(Global.COPPER, 87.99F, 92.01F);
/*  993 */     bronze.addIngred(Global.TIN, 7.99F, 12.01F);
/*  994 */     AlloyManager.INSTANCE.addAlloy(bronze);
/*      */     
/*  996 */     Alloy brass = new Alloy(Global.BRASS, Alloy.EnumTier.TierI);
/*  997 */     brass.addIngred(Global.COPPER, 87.99F, 92.01F);
/*  998 */     brass.addIngred(Global.ZINC, 7.99F, 12.01F);
/*  999 */     AlloyManager.INSTANCE.addAlloy(brass);
/*      */     
/* 1001 */     Alloy roseGold = new Alloy(Global.ROSEGOLD, Alloy.EnumTier.TierI);
/* 1002 */     roseGold.addIngred(Global.GOLD, 69.99F, 85.01F);
/* 1003 */     roseGold.addIngred(Global.COPPER, 14.99F, 30.01F);
/* 1004 */     AlloyManager.INSTANCE.addAlloy(roseGold);
/*      */     
/* 1006 */     Alloy blackBronze = new Alloy(Global.BLACKBRONZE, Alloy.EnumTier.TierI);
/* 1007 */     blackBronze.addIngred(Global.GOLD, 9.99F, 25.01F);
/* 1008 */     blackBronze.addIngred(Global.COPPER, 49.99F, 70.01F);
/* 1009 */     blackBronze.addIngred(Global.SILVER, 9.99F, 25.01F);
/* 1010 */     AlloyManager.INSTANCE.addAlloy(blackBronze);
/*      */     
/* 1012 */     Alloy bismuthBronze = new Alloy(Global.BISMUTHBRONZE, Alloy.EnumTier.TierI);
/* 1013 */     bismuthBronze.addIngred(Global.ZINC, 19.99F, 30.01F);
/* 1014 */     bismuthBronze.addIngred(Global.COPPER, 49.99F, 65.01F);
/* 1015 */     bismuthBronze.addIngred(Global.BISMUTH, 9.99F, 20.01F);
/* 1016 */     AlloyManager.INSTANCE.addAlloy(bismuthBronze);
/*      */     
/* 1018 */     Alloy sterlingSilver = new Alloy(Global.STERLINGSILVER, Alloy.EnumTier.TierI);
/* 1019 */     sterlingSilver.addIngred(Global.SILVER, 59.99F, 80.01F);
/* 1020 */     sterlingSilver.addIngred(Global.COPPER, 19.99F, 40.01F);
/* 1021 */     AlloyManager.INSTANCE.addAlloy(sterlingSilver);
/*      */     
/* 1023 */     Alloy weakSteel = new Alloy(Global.WEAKSTEEL, Alloy.EnumTier.TierIII);
/* 1024 */     weakSteel.addIngred(Global.STEEL, 49.99F, 70.01F);
/* 1025 */     weakSteel.addIngred(Global.NICKEL, 14.99F, 25.01F);
/* 1026 */     weakSteel.addIngred(Global.BLACKBRONZE, 14.99F, 25.01F);
/* 1027 */     AlloyManager.INSTANCE.addAlloy(weakSteel);
/*      */     
/* 1029 */     Alloy weakRedSteel = new Alloy(Global.WEAKREDSTEEL, Alloy.EnumTier.TierIII);
/* 1030 */     weakRedSteel.addIngred(Global.BLACKSTEEL, 49.99F, 55.01F);
/* 1031 */     weakRedSteel.addIngred(Global.ROSEGOLD, 9.99F, 15.01F);
/* 1032 */     weakRedSteel.addIngred(Global.BRASS, 9.99F, 15.01F);
/* 1033 */     weakRedSteel.addIngred(Global.STEEL, 19.99F, 25.01F);
/* 1034 */     AlloyManager.INSTANCE.addAlloy(weakRedSteel);
/*      */     
/* 1036 */     Alloy weakBlueSteel = new Alloy(Global.WEAKBLUESTEEL, Alloy.EnumTier.TierIII);
/* 1037 */     weakBlueSteel.addIngred(Global.BLACKSTEEL, 49.99F, 55.01F);
/* 1038 */     weakBlueSteel.addIngred(Global.BISMUTHBRONZE, 9.99F, 15.01F);
/* 1039 */     weakBlueSteel.addIngred(Global.STERLINGSILVER, 9.99F, 15.01F);
/* 1040 */     weakBlueSteel.addIngred(Global.STEEL, 19.99F, 25.01F);
/* 1041 */     AlloyManager.INSTANCE.addAlloy(weakBlueSteel);
/*      */     
/* 1043 */     Alloy electrum = new Alloy(Global.ELECTRUM, Alloy.EnumTier.TierI);
/* 1044 */     electrum.addIngred(Global.GOLD, 44.99F, 55.01F);
/* 1045 */     electrum.addIngred(Global.SILVER, 44.99F, 55.01F);
/* 1046 */     AlloyManager.INSTANCE.addAlloy(electrum);
/*      */     
/* 1048 */     Alloy cupronickel = new Alloy(Global.CUPRONICKEL, Alloy.EnumTier.TierI);
/* 1049 */     cupronickel.addIngred(Global.COPPER, 44.99F, 55.01F);
/* 1050 */     cupronickel.addIngred(Global.NICKEL, 44.99F, 55.01F);
/* 1051 */     AlloyManager.INSTANCE.addAlloy(cupronickel);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setupArmor() {
/* 1057 */     String[] names = { "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Bronze", "Copper", "Wrought Iron", "Red Steel", "Steel" };
/* 1058 */     String[] namesNSO = { "Brass", "Gold", "Lead", "Nickel", "Pig Iron", "Platinum", "Silver", "Sterling Silver" };
/* 1059 */     CommonProxy proxy = TerraFirmaCraft.proxy;
/* 1060 */     int i = 0;
/*      */     
/* 1062 */     bismuthSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(0)).func_77655_b("Bismuth Sheet")).setMetal("Bismuth", 100);
/* 1063 */     bismuthBronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(1)).func_77655_b("Bismuth Bronze Sheet")).setMetal("Bismuth Bronze", 100);
/* 1064 */     blackBronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(2)).func_77655_b("Black Bronze Sheet")).setMetal("Black Bronze", 100);
/* 1065 */     blackSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(3)).func_77655_b("Black Steel Sheet")).setMetal("Black Steel", 100);
/* 1066 */     blueSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(4)).func_77655_b("Blue Steel Sheet")).setMetal("Blue Steel", 100);
/* 1067 */     bronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(6)).func_77655_b("Bronze Sheet")).setMetal("Bronze", 100);
/* 1068 */     copperSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(7)).func_77655_b("Copper Sheet")).setMetal("Copper", 100);
/* 1069 */     wroughtIronSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(9)).func_77655_b("Wrought Iron Sheet")).setMetal("Wrought Iron", 100);
/* 1070 */     redSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(14)).func_77655_b("Red Steel Sheet")).setMetal("Red Steel", 100);
/* 1071 */     roseGoldSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(15)).func_77655_b("Rose Gold Sheet")).setMetal("Rose Gold", 100);
/* 1072 */     steelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(17)).func_77655_b("Steel Sheet")).setMetal("Steel", 100);
/* 1073 */     tinSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(19)).func_77655_b("Tin Sheet")).setMetal("Tin", 100);
/* 1074 */     zincSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(20)).func_77655_b("Zinc Sheet")).setMetal("Zinc", 100);
/* 1075 */     electrumSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(21)).func_77655_b("Electrum Sheet")).setMetal("Electrum", 100);
/* 1076 */     cupronickelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(22)).func_77655_b("Cupronickel Sheet")).setMetal("Cupronickel", 100);
/*      */     
/* 1078 */     bismuthSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(0)).func_77655_b("Bismuth Double Sheet")).setMetal("Bismuth", 200);
/* 1079 */     bismuthBronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(1)).func_77655_b("Bismuth Bronze Double Sheet")).setMetal("Bismuth Bronze", 200);
/* 1080 */     blackBronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(2)).func_77655_b("Black Bronze Double Sheet")).setMetal("Black Bronze", 200);
/* 1081 */     blackSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(3)).func_77655_b("Black Steel Double Sheet")).setMetal("Black Steel", 200);
/* 1082 */     blueSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(4)).func_77655_b("Blue Steel Double Sheet")).setMetal("Blue Steel", 200);
/* 1083 */     bronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(6)).func_77655_b("Bronze Double Sheet")).setMetal("Bronze", 200);
/* 1084 */     copperSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(7)).func_77655_b("Copper Double Sheet")).setMetal("Copper", 200);
/* 1085 */     wroughtIronSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(9)).func_77655_b("Wrought Iron Double Sheet")).setMetal("Wrought Iron", 200);
/* 1086 */     redSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(14)).func_77655_b("Red Steel Double Sheet")).setMetal("Red Steel", 200);
/* 1087 */     roseGoldSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(15)).func_77655_b("Rose Gold Double Sheet")).setMetal("Rose Gold", 200);
/* 1088 */     steelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(17)).func_77655_b("Steel Double Sheet")).setMetal("Steel", 200);
/* 1089 */     tinSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(19)).func_77655_b("Tin Double Sheet")).setMetal("Tin", 200);
/* 1090 */     zincSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(20)).func_77655_b("Zinc Double Sheet")).setMetal("Zinc", 200);
/* 1091 */     electrumSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(21)).func_77655_b("Electrum Double Sheet")).setMetal("Electrum", 200);
/* 1092 */     cupronickelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(22)).func_77655_b("Cupronickel Double Sheet")).setMetal("Cupronickel", 200);
/*      */     
/* 1094 */     i = 0;
/* 1095 */     brassSheet = (new ItemMetalSheet(5)).setMetal("Brass", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1096 */     goldSheet = (new ItemMetalSheet(8)).setMetal("Gold", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1097 */     leadSheet = (new ItemMetalSheet(10)).setMetal("Lead", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1098 */     nickelSheet = (new ItemMetalSheet(11)).setMetal("Nickel", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1099 */     pigIronSheet = (new ItemMetalSheet(12)).setMetal("Pig Iron", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1100 */     platinumSheet = (new ItemMetalSheet(13)).setMetal("Platinum", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1101 */     silverSheet = (new ItemMetalSheet(16)).setMetal("Silver", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1102 */     sterlingSilverSheet = (new ItemMetalSheet(18)).setMetal("Sterling Silver", 100).func_77655_b(namesNSO[i++] + " Sheet");
/*      */     
/* 1104 */     i = 0;
/* 1105 */     brassSheet2x = (new ItemMetalSheet2x(5)).setMetal("Brass", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1106 */     goldSheet2x = (new ItemMetalSheet2x(8)).setMetal("Gold", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1107 */     leadSheet2x = (new ItemMetalSheet2x(10)).setMetal("Lead", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1108 */     nickelSheet2x = (new ItemMetalSheet2x(1)).setMetal("Nickel", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1109 */     pigIronSheet2x = (new ItemMetalSheet2x(12)).setMetal("Pig Iron", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1110 */     platinumSheet2x = (new ItemMetalSheet2x(13)).setMetal("Platinum", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1111 */     silverSheet2x = (new ItemMetalSheet2x(16)).setMetal("Silver", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1112 */     sterlingSilverSheet2x = (new ItemMetalSheet2x(18)).setMetal("Sterling Silver", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/*      */     
/* 1114 */     i = 0;
/* 1115 */     bismuthBronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1116 */     blackBronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1117 */     blackSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Black Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1118 */     blueSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1119 */     bronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1120 */     copperUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Copper", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1121 */     wroughtIronUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1122 */     redSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Red Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1123 */     steelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Steel", 3).func_77655_b(names[i] + " Unfinished Boots");
/*      */     
/* 1125 */     i = 0;
/* 1126 */     bismuthBronzeBoots = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1127 */     blackBronzeBoots = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1128 */     blackSteelBoots = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1129 */     blueSteelBoots = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1130 */     bronzeBoots = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1131 */     copperBoots = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1132 */     wroughtIronBoots = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1133 */     redSteelBoots = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1134 */     steelBoots = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 3, 50, 0)).func_77655_b(names[i] + " Boots");
/*      */     
/* 1136 */     i = 0;
/* 1137 */     bismuthBronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1138 */     blackBronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1139 */     blackSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Black Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1140 */     blueSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1141 */     bronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1142 */     copperUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Copper", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1143 */     wroughtIronUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1144 */     redSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Red Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1145 */     steelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Steel", 2).func_77655_b(names[i] + " Unfinished Greaves");
/*      */     
/* 1147 */     i = 0;
/* 1148 */     bismuthBronzeGreaves = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1149 */     blackBronzeGreaves = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1150 */     blackSteelGreaves = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1151 */     blueSteelGreaves = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1152 */     bronzeGreaves = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1153 */     copperGreaves = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1154 */     wroughtIronGreaves = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1155 */     redSteelGreaves = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1156 */     steelGreaves = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves");
/*      */     
/* 1158 */     i = 0;
/* 1159 */     bismuthBronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1160 */     blackBronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1161 */     blackSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Black Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1162 */     blueSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1163 */     bronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1164 */     copperUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Copper", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1165 */     wroughtIronUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1166 */     redSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Red Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1167 */     steelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate");
/*      */     
/* 1169 */     i = 0;
/* 1170 */     bismuthBronzeChestplate = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1171 */     blackBronzeChestplate = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1172 */     blackSteelChestplate = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1173 */     blueSteelChestplate = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1174 */     bronzeChestplate = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1175 */     copperChestplate = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1176 */     wroughtIronChestplate = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1177 */     redSteelChestplate = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1178 */     steelChestplate = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate");
/*      */     
/* 1180 */     i = 0;
/* 1181 */     bismuthBronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1182 */     blackBronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1183 */     blackSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Black Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1184 */     blueSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1185 */     bronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1186 */     copperUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Copper", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1187 */     wroughtIronUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1188 */     redSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Red Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1189 */     steelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Steel", 0).func_77655_b(names[i] + " Unfinished Helmet");
/*      */     
/* 1191 */     i = 0;
/* 1192 */     bismuthBronzeHelmet = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1193 */     blackBronzeHelmet = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1194 */     blackSteelHelmet = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1195 */     blueSteelHelmet = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1196 */     bronzeHelmet = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1197 */     copperHelmet = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1198 */     wroughtIronHelmet = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1199 */     redSteelHelmet = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1200 */     steelHelmet = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet");
/*      */     
/* 1202 */     leatherHelmet = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 0, ItemArmor.ArmorMaterial.CLOTH, 100, 3)).func_77655_b("helmetCloth").func_111206_d("leather_helmet");
/* 1203 */     leatherChestplate = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 1, ItemArmor.ArmorMaterial.CLOTH, 100, 2)).func_77655_b("chestplateCloth").func_111206_d("leather_chestplate");
/* 1204 */     leatherLeggings = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 2, ItemArmor.ArmorMaterial.CLOTH, 100, 1)).func_77655_b("leggingsCloth").func_111206_d("leather_leggings");
/* 1205 */     leatherBoots = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 3, ItemArmor.ArmorMaterial.CLOTH, 100, 0)).func_77655_b("bootsCloth").func_111206_d("leather_boots");
/*      */     
/* 1207 */     quiver = (new ItemQuiver()).func_77655_b("Quiver");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerFurnaceFuel() {
/* 1213 */     TFCFuelHandler.registerFuel(blueSteelBucketLava, 20000);
/* 1214 */     TFCFuelHandler.registerFuel(singlePlank, 400);
/* 1215 */     TFCFuelHandler.registerFuel(woodenBucketEmpty, 300);
/* 1216 */     TFCFuelHandler.registerFuel(fireStarter, 100);
/* 1217 */     TFCFuelHandler.registerFuel(logs, 800);
/* 1218 */     TFCFuelHandler.registerFuel(sluiceItem, 300);
/* 1219 */     TFCFuelHandler.registerFuel(rope, 50);
/* 1220 */     TFCFuelHandler.registerFuel(arrow, 20);
/* 1221 */     TFCFuelHandler.registerFuel(bow, 100);
/* 1222 */     TFCFuelHandler.registerFuel(fishingRod, 100);
/* 1223 */     TFCFuelHandler.registerFuel(stick, 100);
/* 1224 */     TFCFuelHandler.registerFuel(coal, 1600);
/* 1225 */     TFCFuelHandler.registerFuel(woolCloth, 20);
/* 1226 */     TFCFuelHandler.registerFuel(silkCloth, 20);
/* 1227 */     TFCFuelHandler.registerFuel(burlapCloth, 20);
/* 1228 */     TFCFuelHandler.registerFuel(straw, 20);
/*      */     
/* 1230 */     for (int l = 0; l < Recipes.doors.length; l++) {
/* 1231 */       TFCFuelHandler.registerFuel(Recipes.doors[l], 300);
/*      */     }
/* 1233 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportV), 300);
/* 1234 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportV2), 300);
/* 1235 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportH), 300);
/* 1236 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportH2), 300);
/* 1237 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fence), 300);
/* 1238 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fence2), 300);
/* 1239 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fenceGate), 300);
/* 1240 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fenceGate2), 300);
/* 1241 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.chest), 300);
/* 1242 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.strawHideBed), 200);
/* 1243 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.thatch), 200);
/* 1244 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.planks), 300);
/* 1245 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.planks2), 300);
/* 1246 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.barrel), 300);
/* 1247 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.torch), 100);
/* 1248 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.sapling), 100);
/* 1249 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.sapling2), 100);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ItemSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */