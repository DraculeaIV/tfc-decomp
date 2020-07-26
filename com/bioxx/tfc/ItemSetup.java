/*      */ package com.bioxx.tfc;
/*      */ import com.bioxx.tfc.Core.Metal.Alloy;
/*      */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*      */ import com.bioxx.tfc.Core.Recipes;
/*      */ import com.bioxx.tfc.Core.TFCTabs;
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
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomSaw;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomShovel;
/*      */ import com.bioxx.tfc.Items.Tools.ItemCustomSword;
/*      */ import com.bioxx.tfc.Items.Tools.ItemHammer;
/*      */ import com.bioxx.tfc.Items.Tools.ItemJavelin;
/*      */ import com.bioxx.tfc.Items.Tools.ItemKnife;
/*      */ import com.bioxx.tfc.Items.Tools.ItemMiscToolHead;
/*      */ import com.bioxx.tfc.Items.Tools.ItemProPick;
/*      */ import com.bioxx.tfc.api.Armor;
/*      */ import com.bioxx.tfc.api.Constant.Global;
/*      */ import com.bioxx.tfc.api.Enums.EnumDamageType;
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
/*      */     
/*  115 */     bismuthIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bismuth Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bismuth", 200);
/*  116 */     bismuthBronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bismuth Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bismuth Bronze", 200);
/*  117 */     blackBronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Black Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Black Bronze", 200);
/*  118 */     blackSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Black Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Black Steel", 200);
/*  119 */     blueSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Blue Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Blue Steel", 200);
/*  120 */     brassIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Brass Double Ingot")).setSize(EnumSize.LARGE).setMetal("Brass", 200);
/*  121 */     bronzeIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Bronze Double Ingot")).setSize(EnumSize.LARGE).setMetal("Bronze", 200);
/*  122 */     copperIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Copper Double Ingot")).setSize(EnumSize.LARGE).setMetal("Copper", 200);
/*  123 */     goldIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Gold Double Ingot")).setSize(EnumSize.LARGE).setMetal("Gold", 200);
/*  124 */     wroughtIronIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Wrought Iron Double Ingot")).setSize(EnumSize.LARGE).setMetal("Wrought Iron", 200);
/*  125 */     leadIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Lead Double Ingot")).setSize(EnumSize.LARGE).setMetal("Lead", 200);
/*  126 */     nickelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Nickel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Nickel", 200);
/*  127 */     pigIronIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Pig Iron Double Ingot")).setSize(EnumSize.LARGE).setMetal("Pig Iron", 200);
/*  128 */     platinumIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Platinum Double Ingot")).setSize(EnumSize.LARGE).setMetal("Platinum", 200);
/*  129 */     redSteelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Red Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Red Steel", 200);
/*  130 */     roseGoldIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Rose Gold Double Ingot")).setSize(EnumSize.LARGE).setMetal("Rose Gold", 200);
/*  131 */     silverIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Silver Double Ingot")).setSize(EnumSize.LARGE).setMetal("Silver", 200);
/*  132 */     steelIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Steel Double Ingot")).setSize(EnumSize.LARGE).setMetal("Steel", 200);
/*  133 */     sterlingSilverIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Sterling Silver Double Ingot")).setSize(EnumSize.LARGE).setMetal("Sterling Silver", 200);
/*  134 */     tinIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Tin Double Ingot")).setSize(EnumSize.LARGE).setMetal("Tin", 200);
/*  135 */     zincIngot2x = (Item)((ItemIngot)(new ItemIngot()).func_77655_b("Zinc Double Ingot")).setSize(EnumSize.LARGE).setMetal("Zinc", 200);
/*      */     
/*  137 */     gemRuby = (new ItemGem()).func_77655_b("Ruby");
/*  138 */     gemSapphire = (new ItemGem()).func_77655_b("Sapphire");
/*  139 */     gemEmerald = (new ItemGem()).func_77655_b("Emerald");
/*  140 */     gemTopaz = (new ItemGem()).func_77655_b("Topaz");
/*  141 */     gemTourmaline = (new ItemGem()).func_77655_b("Tourmaline");
/*  142 */     gemJade = (new ItemGem()).func_77655_b("Jade");
/*  143 */     gemBeryl = (new ItemGem()).func_77655_b("Beryl");
/*  144 */     gemAgate = (new ItemGem()).func_77655_b("Agate");
/*  145 */     gemOpal = (new ItemGem()).func_77655_b("Opal");
/*  146 */     gemGarnet = (new ItemGem()).func_77655_b("Garnet");
/*  147 */     gemJasper = (new ItemGem()).func_77655_b("Jasper");
/*  148 */     gemAmethyst = (new ItemGem()).func_77655_b("Amethyst");
/*  149 */     gemDiamond = (new ItemGem()).func_77655_b("Diamond");
/*      */ 
/*      */     
/*  152 */     igInShovel = (new ItemCustomShovel(igInToolMaterial)).func_77655_b("IgIn Stone Shovel").func_77656_e(igInStoneUses);
/*  153 */     igInAxe = (new ItemCustomAxe(igInToolMaterial, 60.0F)).func_77655_b("IgIn Stone Axe").func_77656_e(igInStoneUses);
/*  154 */     igInHoe = (new ItemCustomHoe(igInToolMaterial)).func_77655_b("IgIn Stone Hoe").func_77656_e(igInStoneUses);
/*      */     
/*  156 */     sedShovel = (new ItemCustomShovel(sedToolMaterial)).func_77655_b("Sed Stone Shovel").func_77656_e(sedStoneUses);
/*  157 */     sedAxe = (new ItemCustomAxe(sedToolMaterial, 60.0F)).func_77655_b("Sed Stone Axe").func_77656_e(sedStoneUses);
/*  158 */     sedHoe = (new ItemCustomHoe(sedToolMaterial)).func_77655_b("Sed Stone Hoe").func_77656_e(sedStoneUses);
/*      */     
/*  160 */     igExShovel = (new ItemCustomShovel(igExToolMaterial)).func_77655_b("IgEx Stone Shovel").func_77656_e(igExStoneUses);
/*  161 */     igExAxe = (new ItemCustomAxe(igExToolMaterial, 60.0F)).func_77655_b("IgEx Stone Axe").func_77656_e(igExStoneUses);
/*  162 */     igExHoe = (new ItemCustomHoe(igExToolMaterial)).func_77655_b("IgEx Stone Hoe").func_77656_e(igExStoneUses);
/*      */     
/*  164 */     mMShovel = (new ItemCustomShovel(mMToolMaterial)).func_77655_b("MM Stone Shovel").func_77656_e(mMStoneUses);
/*  165 */     mMAxe = (new ItemCustomAxe(mMToolMaterial, 60.0F)).func_77655_b("MM Stone Axe").func_77656_e(mMStoneUses);
/*  166 */     mMHoe = (new ItemCustomHoe(mMToolMaterial)).func_77655_b("MM Stone Hoe").func_77656_e(mMStoneUses);
/*      */     
/*  168 */     bismuthBronzePick = (new ItemCustomPickaxe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Pick").func_77656_e(bismuthBronzeUses);
/*  169 */     bismuthBronzeShovel = (new ItemCustomShovel(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Shovel").func_77656_e(bismuthBronzeUses);
/*  170 */     bismuthBronzeAxe = (new ItemCustomAxe(bismuthBronzeToolMaterial, 150.0F)).func_77655_b("Bismuth Bronze Axe").func_77656_e(bismuthBronzeUses);
/*  171 */     bismuthBronzeHoe = (new ItemCustomHoe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Hoe").func_77656_e(bismuthBronzeUses);
/*      */     
/*  173 */     blackBronzePick = (new ItemCustomPickaxe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Pick").func_77656_e(blackBronzeUses);
/*  174 */     blackBronzeShovel = (new ItemCustomShovel(blackBronzeToolMaterial)).func_77655_b("Black Bronze Shovel").func_77656_e(blackBronzeUses);
/*  175 */     blackBronzeAxe = (new ItemCustomAxe(blackBronzeToolMaterial, 170.0F)).func_77655_b("Black Bronze Axe").func_77656_e(blackBronzeUses);
/*  176 */     blackBronzeHoe = (new ItemCustomHoe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Hoe").func_77656_e(blackBronzeUses);
/*      */     
/*  178 */     blackSteelPick = (new ItemCustomPickaxe(blackSteelToolMaterial)).func_77655_b("Black Steel Pick").func_77656_e(blackSteelUses);
/*  179 */     blackSteelShovel = (new ItemCustomShovel(blackSteelToolMaterial)).func_77655_b("Black Steel Shovel").func_77656_e(blackSteelUses);
/*  180 */     blackSteelAxe = (new ItemCustomAxe(blackSteelToolMaterial, 245.0F)).func_77655_b("Black Steel Axe").func_77656_e(blackSteelUses);
/*  181 */     blackSteelHoe = (new ItemCustomHoe(blackSteelToolMaterial)).func_77655_b("Black Steel Hoe").func_77656_e(blackSteelUses);
/*      */     
/*  183 */     blueSteelPick = (new ItemCustomPickaxe(blueSteelToolMaterial)).func_77655_b("Blue Steel Pick").func_77656_e(blueSteelUses);
/*  184 */     blueSteelShovel = (new ItemCustomShovel(blueSteelToolMaterial)).func_77655_b("Blue Steel Shovel").func_77656_e(blueSteelUses);
/*  185 */     blueSteelAxe = (new ItemCustomAxe(blueSteelToolMaterial, 270.0F)).func_77655_b("Blue Steel Axe").func_77656_e(blueSteelUses);
/*  186 */     blueSteelHoe = (new ItemCustomHoe(blueSteelToolMaterial)).func_77655_b("Blue Steel Hoe").func_77656_e(blueSteelUses);
/*      */     
/*  188 */     bronzePick = (new ItemCustomPickaxe(bronzeToolMaterial)).func_77655_b("Bronze Pick").func_77656_e(bronzeUses);
/*  189 */     bronzeShovel = (new ItemCustomShovel(bronzeToolMaterial)).func_77655_b("Bronze Shovel").func_77656_e(bronzeUses);
/*  190 */     bronzeAxe = (new ItemCustomAxe(bronzeToolMaterial, 160.0F)).func_77655_b("Bronze Axe").func_77656_e(bronzeUses);
/*  191 */     bronzeHoe = (new ItemCustomHoe(bronzeToolMaterial)).func_77655_b("Bronze Hoe").func_77656_e(bronzeUses);
/*      */     
/*  193 */     copperPick = (new ItemCustomPickaxe(copperToolMaterial)).func_77655_b("Copper Pick").func_77656_e(copperUses);
/*  194 */     copperShovel = (new ItemCustomShovel(copperToolMaterial)).func_77655_b("Copper Shovel").func_77656_e(copperUses);
/*  195 */     copperAxe = (new ItemCustomAxe(copperToolMaterial, 115.0F)).func_77655_b("Copper Axe").func_77656_e(copperUses);
/*  196 */     copperHoe = (new ItemCustomHoe(copperToolMaterial)).func_77655_b("Copper Hoe").func_77656_e(copperUses);
/*      */     
/*  198 */     wroughtIronPick = (new ItemCustomPickaxe(ironToolMaterial)).func_77655_b("Wrought Iron Pick").func_77656_e(wroughtIronUses);
/*  199 */     wroughtIronShovel = (new ItemCustomShovel(ironToolMaterial)).func_77655_b("Wrought Iron Shovel").func_77656_e(wroughtIronUses);
/*  200 */     wroughtIronAxe = (new ItemCustomAxe(ironToolMaterial, 185.0F)).func_77655_b("Wrought Iron Axe").func_77656_e(wroughtIronUses);
/*  201 */     wroughtIronHoe = (new ItemCustomHoe(ironToolMaterial)).func_77655_b("Wrought Iron Hoe").func_77656_e(wroughtIronUses);
/*      */     
/*  203 */     redSteelPick = (new ItemCustomPickaxe(redSteelToolMaterial)).func_77655_b("Red Steel Pick").func_77656_e(redSteelUses);
/*  204 */     redSteelShovel = (new ItemCustomShovel(redSteelToolMaterial)).func_77655_b("Red Steel Shovel").func_77656_e(redSteelUses);
/*  205 */     redSteelAxe = (new ItemCustomAxe(redSteelToolMaterial, 270.0F)).func_77655_b("Red Steel Axe").func_77656_e(redSteelUses);
/*  206 */     redSteelHoe = (new ItemCustomHoe(redSteelToolMaterial)).func_77655_b("Red Steel Hoe").func_77656_e(redSteelUses);
/*      */     
/*  208 */     steelPick = (new ItemCustomPickaxe(steelToolMaterial)).func_77655_b("Steel Pick").func_77656_e(steelUses);
/*  209 */     steelShovel = (new ItemCustomShovel(steelToolMaterial)).func_77655_b("Steel Shovel").func_77656_e(steelUses);
/*  210 */     steelAxe = (new ItemCustomAxe(steelToolMaterial, 210.0F)).func_77655_b("Steel Axe").func_77656_e(steelUses);
/*  211 */     steelHoe = (new ItemCustomHoe(steelToolMaterial)).func_77655_b("Steel Hoe").func_77656_e(steelUses);
/*      */ 
/*      */     
/*  214 */     bismuthBronzeChisel = (new ItemChisel(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Chisel").func_77656_e(bismuthBronzeUses);
/*  215 */     blackBronzeChisel = (new ItemChisel(blackBronzeToolMaterial)).func_77655_b("Black Bronze Chisel").func_77656_e(blackBronzeUses);
/*  216 */     blackSteelChisel = (new ItemChisel(blackSteelToolMaterial)).func_77655_b("Black Steel Chisel").func_77656_e(blackSteelUses);
/*  217 */     blueSteelChisel = (new ItemChisel(blueSteelToolMaterial)).func_77655_b("Blue Steel Chisel").func_77656_e(blueSteelUses);
/*  218 */     bronzeChisel = (new ItemChisel(bronzeToolMaterial)).func_77655_b("Bronze Chisel").func_77656_e(bronzeUses);
/*  219 */     copperChisel = (new ItemChisel(copperToolMaterial)).func_77655_b("Copper Chisel").func_77656_e(copperUses);
/*  220 */     wroughtIronChisel = (new ItemChisel(ironToolMaterial)).func_77655_b("Wrought Iron Chisel").func_77656_e(wroughtIronUses);
/*  221 */     redSteelChisel = (new ItemChisel(redSteelToolMaterial)).func_77655_b("Red Steel Chisel").func_77656_e(redSteelUses);
/*  222 */     steelChisel = (new ItemChisel(steelToolMaterial)).func_77655_b("Steel Chisel").func_77656_e(steelUses);
/*      */     
/*  224 */     bismuthBronzeSword = (new ItemCustomSword(bismuthBronzeToolMaterial, 210.0F)).func_77655_b("Bismuth Bronze Sword").func_77656_e(bismuthBronzeUses);
/*  225 */     blackBronzeSword = (new ItemCustomSword(blackBronzeToolMaterial, 230.0F)).func_77655_b("Black Bronze Sword").func_77656_e(blackBronzeUses);
/*  226 */     blackSteelSword = (new ItemCustomSword(blackSteelToolMaterial, 270.0F)).func_77655_b("Black Steel Sword").func_77656_e(blackSteelUses);
/*  227 */     blueSteelSword = (new ItemCustomSword(blueSteelToolMaterial, 315.0F)).func_77655_b("Blue Steel Sword").func_77656_e(blueSteelUses);
/*  228 */     bronzeSword = (new ItemCustomSword(bronzeToolMaterial, 220.0F)).func_77655_b("Bronze Sword").func_77656_e(bronzeUses);
/*  229 */     copperSword = (new ItemCustomSword(copperToolMaterial, 165.0F)).func_77655_b("Copper Sword").func_77656_e(copperUses);
/*  230 */     wroughtIronSword = (new ItemCustomSword(ironToolMaterial, 240.0F)).func_77655_b("Wrought Iron Sword").func_77656_e(wroughtIronUses);
/*  231 */     redSteelSword = (new ItemCustomSword(redSteelToolMaterial, 315.0F)).func_77655_b("Red Steel Sword").func_77656_e(redSteelUses);
/*  232 */     steelSword = (new ItemCustomSword(steelToolMaterial, 265.0F)).func_77655_b("Steel Sword").func_77656_e(steelUses);
/*      */     
/*  234 */     bismuthBronzeMace = (new ItemCustomSword(bismuthBronzeToolMaterial, 210.0F, EnumDamageType.CRUSHING)).func_77655_b("Bismuth Bronze Mace").func_77656_e(bismuthBronzeUses);
/*  235 */     blackBronzeMace = (new ItemCustomSword(blackBronzeToolMaterial, 230.0F, EnumDamageType.CRUSHING)).func_77655_b("Black Bronze Mace").func_77656_e(blackBronzeUses);
/*  236 */     blackSteelMace = (new ItemCustomSword(blackSteelToolMaterial, 270.0F, EnumDamageType.CRUSHING)).func_77655_b("Black Steel Mace").func_77656_e(blackSteelUses);
/*  237 */     blueSteelMace = (new ItemCustomSword(blueSteelToolMaterial, 315.0F, EnumDamageType.CRUSHING)).func_77655_b("Blue Steel Mace").func_77656_e(blueSteelUses);
/*  238 */     bronzeMace = (new ItemCustomSword(bronzeToolMaterial, 220.0F, EnumDamageType.CRUSHING)).func_77655_b("Bronze Mace").func_77656_e(bronzeUses);
/*  239 */     copperMace = (new ItemCustomSword(copperToolMaterial, 165.0F, EnumDamageType.CRUSHING)).func_77655_b("Copper Mace").func_77656_e(copperUses);
/*  240 */     wroughtIronMace = (new ItemCustomSword(ironToolMaterial, 240.0F, EnumDamageType.CRUSHING)).func_77655_b("Wrought Iron Mace").func_77656_e(wroughtIronUses);
/*  241 */     redSteelMace = (new ItemCustomSword(redSteelToolMaterial, 315.0F, EnumDamageType.CRUSHING)).func_77655_b("Red Steel Mace").func_77656_e(redSteelUses);
/*  242 */     steelMace = (new ItemCustomSword(steelToolMaterial, 265.0F, EnumDamageType.CRUSHING)).func_77655_b("Steel Mace").func_77656_e(steelUses);
/*      */     
/*  244 */     bismuthBronzeSaw = (new ItemCustomSaw(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Saw").func_77656_e(bismuthBronzeUses);
/*  245 */     blackBronzeSaw = (new ItemCustomSaw(blackBronzeToolMaterial)).func_77655_b("Black Bronze Saw").func_77656_e(blackBronzeUses);
/*  246 */     blackSteelSaw = (new ItemCustomSaw(blackSteelToolMaterial)).func_77655_b("Black Steel Saw").func_77656_e(blackSteelUses);
/*  247 */     blueSteelSaw = (new ItemCustomSaw(blueSteelToolMaterial)).func_77655_b("Blue Steel Saw").func_77656_e(blueSteelUses);
/*  248 */     bronzeSaw = (new ItemCustomSaw(bronzeToolMaterial)).func_77655_b("Bronze Saw").func_77656_e(bronzeUses);
/*  249 */     copperSaw = (new ItemCustomSaw(copperToolMaterial)).func_77655_b("Copper Saw").func_77656_e(copperUses);
/*  250 */     wroughtIronSaw = (new ItemCustomSaw(ironToolMaterial)).func_77655_b("Wrought Iron Saw").func_77656_e(wroughtIronUses);
/*  251 */     redSteelSaw = (new ItemCustomSaw(redSteelToolMaterial)).func_77655_b("Red Steel Saw").func_77656_e(redSteelUses);
/*  252 */     steelSaw = (new ItemCustomSaw(steelToolMaterial)).func_77655_b("Steel Saw").func_77656_e(steelUses);
/*      */     
/*  254 */     highCarbonBlackSteelIngot = (new ItemIngot(false)).func_77655_b("HC Black Steel Ingot");
/*  255 */     weakBlueSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Blue Steel Ingot");
/*  256 */     weakRedSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Red Steel Ingot");
/*  257 */     weakSteelIngot = (new ItemIngot(false)).func_77655_b("Weak Steel Ingot");
/*  258 */     highCarbonBlueSteelIngot = (new ItemIngot(false)).func_77655_b("HC Blue Steel Ingot");
/*  259 */     highCarbonRedSteelIngot = (new ItemIngot(false)).func_77655_b("HC Red Steel Ingot");
/*  260 */     highCarbonSteelIngot = (new ItemIngot(false)).func_77655_b("HC Steel Ingot");
/*      */     
/*  262 */     oreChunk = (new ItemOre()).setFolder("ore/").func_77655_b("Ore");
/*  263 */     smallOreChunk = (new ItemOreSmall()).func_77655_b("Small Ore");
/*  264 */     powder = (new ItemTerra()).setMetaNames(Global.POWDER).func_77655_b("Powder").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  265 */     logs = (new ItemLogs()).func_77655_b("Log");
/*      */ 
/*      */ 
/*      */     
/*  269 */     igInStoneJavelin = (new ItemJavelin(igInToolMaterial, 60.0F)).func_77655_b("IgIn Stone Javelin");
/*  270 */     sedStoneJavelin = (new ItemJavelin(sedToolMaterial, 60.0F)).func_77655_b("Sed Stone Javelin");
/*  271 */     igExStoneJavelin = (new ItemJavelin(igExToolMaterial, 60.0F)).func_77655_b("IgEx Stone Javelin");
/*  272 */     mMStoneJavelin = (new ItemJavelin(mMToolMaterial, 60.0F)).func_77655_b("MM Stone Javelin");
/*  273 */     copperJavelin = (new ItemJavelin(copperToolMaterial, 80.0F)).func_77655_b("Copper Javelin");
/*  274 */     bismuthBronzeJavelin = (new ItemJavelin(bismuthBronzeToolMaterial, 90.0F)).func_77655_b("Bismuth Bronze Javelin");
/*  275 */     bronzeJavelin = (new ItemJavelin(bronzeToolMaterial, 100.0F)).func_77655_b("Bronze Javelin");
/*  276 */     blackBronzeJavelin = (new ItemJavelin(blackBronzeToolMaterial, 95.0F)).func_77655_b("Black Bronze Javelin");
/*  277 */     wroughtIronJavelin = (new ItemJavelin(ironToolMaterial, 135.0F)).func_77655_b("Wrought Iron Javelin");
/*  278 */     steelJavelin = (new ItemJavelin(steelToolMaterial, 170.0F)).func_77655_b("Steel Javelin");
/*  279 */     blackSteelJavelin = (new ItemJavelin(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Javelin");
/*  280 */     blueSteelJavelin = (new ItemJavelin(blueSteelToolMaterial, 240.0F)).func_77655_b("Blue Steel Javelin");
/*  281 */     redSteelJavelin = (new ItemJavelin(redSteelToolMaterial, 240.0F)).func_77655_b("Red Steel Javelin");
/*      */ 
/*      */     
/*  284 */     igInStoneJavelinHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Javelin Head");
/*  285 */     sedStoneJavelinHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Javelin Head");
/*  286 */     igExStoneJavelinHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Javelin Head");
/*  287 */     mMStoneJavelinHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Javelin Head");
/*  288 */     copperJavelinHead = (new ItemMiscToolHead()).func_77655_b("Copper Javelin Head");
/*  289 */     bismuthBronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Javelin Head");
/*  290 */     bronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Bronze Javelin Head");
/*  291 */     blackBronzeJavelinHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Javelin Head");
/*  292 */     wroughtIronJavelinHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Javelin Head");
/*  293 */     steelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Steel Javelin Head");
/*  294 */     blackSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Javelin Head");
/*  295 */     blueSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Javelin Head");
/*  296 */     redSteelJavelinHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Javelin Head");
/*      */     
/*  298 */     bismuthUnshaped = (new ItemMeltedMetal()).func_77655_b("Bismuth Unshaped");
/*  299 */     bismuthBronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Bismuth Bronze Unshaped");
/*  300 */     blackBronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Black Bronze Unshaped");
/*  301 */     blackSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Black Steel Unshaped");
/*  302 */     blueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Blue Steel Unshaped");
/*  303 */     brassUnshaped = (new ItemMeltedMetal()).func_77655_b("Brass Unshaped");
/*  304 */     bronzeUnshaped = (new ItemMeltedMetal()).func_77655_b("Bronze Unshaped");
/*  305 */     copperUnshaped = (new ItemMeltedMetal()).func_77655_b("Copper Unshaped");
/*  306 */     goldUnshaped = (new ItemMeltedMetal()).func_77655_b("Gold Unshaped");
/*  307 */     wroughtIronUnshaped = (new ItemMeltedMetal()).func_77655_b("Wrought Iron Unshaped");
/*  308 */     leadUnshaped = (new ItemMeltedMetal()).func_77655_b("Lead Unshaped");
/*  309 */     nickelUnshaped = (new ItemMeltedMetal()).func_77655_b("Nickel Unshaped");
/*  310 */     pigIronUnshaped = (new ItemMeltedMetal()).func_77655_b("Pig Iron Unshaped");
/*  311 */     platinumUnshaped = (new ItemMeltedMetal()).func_77655_b("Platinum Unshaped");
/*  312 */     redSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Red Steel Unshaped");
/*  313 */     roseGoldUnshaped = (new ItemMeltedMetal()).func_77655_b("Rose Gold Unshaped");
/*  314 */     silverUnshaped = (new ItemMeltedMetal()).func_77655_b("Silver Unshaped");
/*  315 */     steelUnshaped = (new ItemMeltedMetal()).func_77655_b("Steel Unshaped");
/*  316 */     sterlingSilverUnshaped = (new ItemMeltedMetal()).func_77655_b("Sterling Silver Unshaped");
/*  317 */     tinUnshaped = (new ItemMeltedMetal()).func_77655_b("Tin Unshaped");
/*  318 */     zincUnshaped = (new ItemMeltedMetal()).func_77655_b("Zinc Unshaped");
/*      */ 
/*      */     
/*  321 */     stoneHammer = (new ItemHammer(igInToolMaterial, 60.0F)).func_77655_b("Stone Hammer").func_77656_e(igInStoneUses);
/*  322 */     bismuthBronzeHammer = (new ItemHammer(bismuthBronzeToolMaterial, 90.0F)).func_77655_b("Bismuth Bronze Hammer").func_77656_e(bismuthBronzeUses);
/*  323 */     blackBronzeHammer = (new ItemHammer(blackBronzeToolMaterial, 95.0F)).func_77655_b("Black Bronze Hammer").func_77656_e(blackBronzeUses);
/*  324 */     blackSteelHammer = (new ItemHammer(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Hammer").func_77656_e(blackSteelUses);
/*  325 */     blueSteelHammer = (new ItemHammer(blueSteelToolMaterial, 240.0F)).func_77655_b("Blue Steel Hammer").func_77656_e(blueSteelUses);
/*  326 */     bronzeHammer = (new ItemHammer(bronzeToolMaterial, 100.0F)).func_77655_b("Bronze Hammer").func_77656_e(bronzeUses);
/*  327 */     copperHammer = (new ItemHammer(copperToolMaterial, 80.0F)).func_77655_b("Copper Hammer").func_77656_e(copperUses);
/*  328 */     wroughtIronHammer = (new ItemHammer(ironToolMaterial, 135.0F)).func_77655_b("Wrought Iron Hammer").func_77656_e(wroughtIronUses);
/*  329 */     redSteelHammer = (new ItemHammer(redSteelToolMaterial, 240.0F)).func_77655_b("Red Steel Hammer").func_77656_e(redSteelUses);
/*  330 */     steelHammer = (new ItemHammer(steelToolMaterial, 170.0F)).func_77655_b("Steel Hammer").func_77656_e(steelUses);
/*      */     
/*  332 */     ink = (new ItemTerra()).func_77655_b("Ink").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  333 */     fireStarter = (new ItemFirestarter()).setFolder("tools/").func_77655_b("Firestarter");
/*      */ 
/*      */     
/*  336 */     bismuthBronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Pick Head");
/*  337 */     blackBronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Pick Head");
/*  338 */     blackSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Pick Head");
/*  339 */     blueSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Pick Head");
/*  340 */     bronzePickaxeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Pick Head");
/*  341 */     copperPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Copper Pick Head");
/*  342 */     wroughtIronPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Pick Head");
/*  343 */     redSteelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Pick Head");
/*  344 */     steelPickaxeHead = (new ItemMiscToolHead()).func_77655_b("Steel Pick Head");
/*      */     
/*  346 */     bismuthBronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Shovel Head");
/*  347 */     blackBronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Shovel Head");
/*  348 */     blackSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Shovel Head");
/*  349 */     blueSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Shovel Head");
/*  350 */     bronzeShovelHead = (new ItemMiscToolHead()).func_77655_b("Bronze Shovel Head");
/*  351 */     copperShovelHead = (new ItemMiscToolHead()).func_77655_b("Copper Shovel Head");
/*  352 */     wroughtIronShovelHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Shovel Head");
/*  353 */     redSteelShovelHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Shovel Head");
/*  354 */     steelShovelHead = (new ItemMiscToolHead()).func_77655_b("Steel Shovel Head");
/*      */     
/*  356 */     bismuthBronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Hoe Head");
/*  357 */     blackBronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Hoe Head");
/*  358 */     blackSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Hoe Head");
/*  359 */     blueSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Hoe Head");
/*  360 */     bronzeHoeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Hoe Head");
/*  361 */     copperHoeHead = (new ItemMiscToolHead()).func_77655_b("Copper Hoe Head");
/*  362 */     wroughtIronHoeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Hoe Head");
/*  363 */     redSteelHoeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Hoe Head");
/*  364 */     steelHoeHead = (new ItemMiscToolHead()).func_77655_b("Steel Hoe Head");
/*      */     
/*  366 */     bismuthBronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Axe Head");
/*  367 */     blackBronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Axe Head");
/*  368 */     blackSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Axe Head");
/*  369 */     blueSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Axe Head");
/*  370 */     bronzeAxeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Axe Head");
/*  371 */     copperAxeHead = (new ItemMiscToolHead()).func_77655_b("Copper Axe Head");
/*  372 */     wroughtIronAxeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Axe Head");
/*  373 */     redSteelAxeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Axe Head");
/*  374 */     steelAxeHead = (new ItemMiscToolHead()).func_77655_b("Steel Axe Head");
/*      */     
/*  376 */     bismuthBronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Hammer Head");
/*  377 */     blackBronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Hammer Head");
/*  378 */     blackSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Hammer Head");
/*  379 */     blueSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Hammer Head");
/*  380 */     bronzeHammerHead = (new ItemMiscToolHead()).func_77655_b("Bronze Hammer Head");
/*  381 */     copperHammerHead = (new ItemMiscToolHead()).func_77655_b("Copper Hammer Head");
/*  382 */     wroughtIronHammerHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Hammer Head");
/*  383 */     redSteelHammerHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Hammer Head");
/*  384 */     steelHammerHead = (new ItemMiscToolHead()).func_77655_b("Steel Hammer Head");
/*      */ 
/*      */     
/*  387 */     bismuthBronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Chisel Head");
/*  388 */     blackBronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Chisel Head");
/*  389 */     blackSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Chisel Head");
/*  390 */     blueSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Chisel Head");
/*  391 */     bronzeChiselHead = (new ItemMiscToolHead()).func_77655_b("Bronze Chisel Head");
/*  392 */     copperChiselHead = (new ItemMiscToolHead()).func_77655_b("Copper Chisel Head");
/*  393 */     wroughtIronChiselHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Chisel Head");
/*  394 */     redSteelChiselHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Chisel Head");
/*  395 */     steelChiselHead = (new ItemMiscToolHead()).func_77655_b("Steel Chisel Head");
/*      */     
/*  397 */     bismuthBronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Sword Blade");
/*  398 */     blackBronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Sword Blade");
/*  399 */     blackSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Sword Blade");
/*  400 */     blueSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Sword Blade");
/*  401 */     bronzeSwordHead = (new ItemMiscToolHead()).func_77655_b("Bronze Sword Blade");
/*  402 */     copperSwordHead = (new ItemMiscToolHead()).func_77655_b("Copper Sword Blade");
/*  403 */     wroughtIronSwordHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Sword Blade");
/*  404 */     redSteelSwordHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Sword Blade");
/*  405 */     steelSwordHead = (new ItemMiscToolHead()).func_77655_b("Steel Sword Blade");
/*      */     
/*  407 */     bismuthBronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Mace Head");
/*  408 */     blackBronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Mace Head");
/*  409 */     blackSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Mace Head");
/*  410 */     blueSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Mace Head");
/*  411 */     bronzeMaceHead = (new ItemMiscToolHead()).func_77655_b("Bronze Mace Head");
/*  412 */     copperMaceHead = (new ItemMiscToolHead()).func_77655_b("Copper Mace Head");
/*  413 */     wroughtIronMaceHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Mace Head");
/*  414 */     redSteelMaceHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Mace Head");
/*  415 */     steelMaceHead = (new ItemMiscToolHead()).func_77655_b("Steel Mace Head");
/*      */     
/*  417 */     bismuthBronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Saw Blade");
/*  418 */     blackBronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Saw Blade");
/*  419 */     blackSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Saw Blade");
/*  420 */     blueSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Saw Blade");
/*  421 */     bronzeSawHead = (new ItemMiscToolHead()).func_77655_b("Bronze Saw Blade");
/*  422 */     copperSawHead = (new ItemMiscToolHead()).func_77655_b("Copper Saw Blade");
/*  423 */     wroughtIronSawHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Saw Blade");
/*  424 */     redSteelSawHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Saw Blade");
/*  425 */     steelSawHead = (new ItemMiscToolHead()).func_77655_b("Steel Saw Blade");
/*      */     
/*  427 */     highCarbonBlackSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Black Steel Unshaped");
/*  428 */     weakBlueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Blue Steel Unshaped");
/*  429 */     highCarbonBlueSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Blue Steel Unshaped");
/*  430 */     weakRedSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Red Steel Unshaped");
/*  431 */     highCarbonRedSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Red Steel Unshaped");
/*  432 */     weakSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("Weak Steel Unshaped");
/*  433 */     highCarbonSteelUnshaped = (new ItemMeltedMetal()).func_77655_b("HC Steel Unshaped");
/*      */ 
/*      */     
/*  436 */     bismuthBronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze ProPick Head");
/*  437 */     blackBronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze ProPick Head");
/*  438 */     blackSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Black Steel ProPick Head");
/*  439 */     blueSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel ProPick Head");
/*  440 */     bronzeProPickHead = (new ItemMiscToolHead()).func_77655_b("Bronze ProPick Head");
/*  441 */     copperProPickHead = (new ItemMiscToolHead()).func_77655_b("Copper ProPick Head");
/*  442 */     wroughtIronProPickHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron ProPick Head");
/*  443 */     redSteelProPickHead = (new ItemMiscToolHead()).func_77655_b("Red Steel ProPick Head");
/*  444 */     steelProPickHead = (new ItemMiscToolHead()).func_77655_b("Steel ProPick Head");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  449 */     bismuthBronzeScythe = (new ItemCustomScythe(bismuthBronzeToolMaterial)).func_77655_b("Bismuth Bronze Scythe").func_77656_e(bismuthBronzeUses);
/*  450 */     blackBronzeScythe = (new ItemCustomScythe(blackBronzeToolMaterial)).func_77655_b("Black Bronze Scythe").func_77656_e(blackBronzeUses);
/*  451 */     blackSteelScythe = (new ItemCustomScythe(blackSteelToolMaterial)).func_77655_b("Black Steel Scythe").func_77656_e(blackSteelUses);
/*  452 */     blueSteelScythe = (new ItemCustomScythe(blueSteelToolMaterial)).func_77655_b("Blue Steel Scythe").func_77656_e(blueSteelUses);
/*  453 */     bronzeScythe = (new ItemCustomScythe(bronzeToolMaterial)).func_77655_b("Bronze Scythe").func_77656_e(bronzeUses);
/*  454 */     copperScythe = (new ItemCustomScythe(copperToolMaterial)).func_77655_b("Copper Scythe").func_77656_e(copperUses);
/*  455 */     wroughtIronScythe = (new ItemCustomScythe(ironToolMaterial)).func_77655_b("Wrought Iron Scythe").func_77656_e(wroughtIronUses);
/*  456 */     redSteelScythe = (new ItemCustomScythe(redSteelToolMaterial)).func_77655_b("Red Steel Scythe").func_77656_e(redSteelUses);
/*  457 */     steelScythe = (new ItemCustomScythe(steelToolMaterial)).func_77655_b("Steel Scythe").func_77656_e(steelUses);
/*      */     
/*  459 */     bismuthBronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Scythe Blade");
/*  460 */     blackBronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Scythe Blade");
/*  461 */     blackSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Scythe Blade");
/*  462 */     blueSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Scythe Blade");
/*  463 */     bronzeScytheHead = (new ItemMiscToolHead()).func_77655_b("Bronze Scythe Blade");
/*  464 */     copperScytheHead = (new ItemMiscToolHead()).func_77655_b("Copper Scythe Blade");
/*  465 */     wroughtIronScytheHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Scythe Blade");
/*  466 */     redSteelScytheHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Scythe Blade");
/*  467 */     steelScytheHead = (new ItemMiscToolHead()).func_77655_b("Steel Scythe Blade");
/*      */     
/*  469 */     woodenBucketEmpty = (new ItemCustomBucket(Blocks.field_150350_a)).func_77655_b("Wooden Bucket Empty");
/*  470 */     woodenBucketWater = (new ItemCustomBucket(TFCBlocks.freshWater, woodenBucketEmpty)).func_77655_b("Wooden Bucket Water");
/*  471 */     woodenBucketSaltWater = (new ItemCustomBucket(TFCBlocks.saltWater, woodenBucketEmpty)).func_77655_b("Wooden Bucket Salt Water");
/*  472 */     woodenBucketMilk = (new ItemCustomBucketMilk()).func_77655_b("Wooden Bucket Milk").func_77642_a(woodenBucketEmpty).func_77637_a(TFCTabs.TFC_FOODS);
/*      */     
/*  474 */     bismuthBronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Bismuth Bronze Knife Blade");
/*  475 */     blackBronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Black Bronze Knife Blade");
/*  476 */     blackSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Black Steel Knife Blade");
/*  477 */     blueSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Blue Steel Knife Blade");
/*  478 */     bronzeKnifeHead = (new ItemMiscToolHead()).func_77655_b("Bronze Knife Blade");
/*  479 */     copperKnifeHead = (new ItemMiscToolHead()).func_77655_b("Copper Knife Blade");
/*  480 */     wroughtIronKnifeHead = (new ItemMiscToolHead()).func_77655_b("Wrought Iron Knife Blade");
/*  481 */     redSteelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Red Steel Knife Blade");
/*  482 */     steelKnifeHead = (new ItemMiscToolHead()).func_77655_b("Steel Knife Blade");
/*      */     
/*  484 */     bismuthBronzeKnife = (new ItemKnife(bismuthBronzeToolMaterial, 155.0F)).func_77655_b("Bismuth Bronze Knife").func_77656_e(bismuthBronzeUses);
/*  485 */     blackBronzeKnife = (new ItemKnife(blackBronzeToolMaterial, 165.0F)).func_77655_b("Black Bronze Knife").func_77656_e(blackBronzeUses);
/*  486 */     blackSteelKnife = (new ItemKnife(blackSteelToolMaterial, 205.0F)).func_77655_b("Black Steel Knife").func_77656_e(blackSteelUses);
/*  487 */     blueSteelKnife = (new ItemKnife(blueSteelToolMaterial, 250.0F)).func_77655_b("Blue Steel Knife").func_77656_e(blueSteelUses);
/*  488 */     bronzeKnife = (new ItemKnife(bronzeToolMaterial, 150.0F)).func_77655_b("Bronze Knife").func_77656_e(bronzeUses);
/*  489 */     copperKnife = (new ItemKnife(copperToolMaterial, 100.0F)).func_77655_b("Copper Knife").func_77656_e(copperUses);
/*  490 */     wroughtIronKnife = (new ItemKnife(ironToolMaterial, 175.0F)).func_77655_b("Wrought Iron Knife").func_77656_e(wroughtIronUses);
/*  491 */     redSteelKnife = (new ItemKnife(redSteelToolMaterial, 250.0F)).func_77655_b("Red Steel Knife").func_77656_e(redSteelUses);
/*  492 */     steelKnife = (new ItemKnife(steelToolMaterial, 200.0F)).func_77655_b("Steel Knife").func_77656_e(steelUses);
/*      */     
/*  494 */     flatRock = (new ItemFlatGeneric()).setFolder("rocks/flatrocks/").setMetaNames(Global.STONE_ALL).func_77655_b("FlatRock");
/*  495 */     looseRock = (new ItemLooseRock()).setSpecialCraftingType(flatRock).setFolder("rocks/").setMetaNames(Global.STONE_ALL).func_77655_b("LooseRock");
/*      */     
/*  497 */     igInStoneShovelHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Shovel Head");
/*  498 */     sedStoneShovelHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Shovel Head");
/*  499 */     igExStoneShovelHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Shovel Head");
/*  500 */     mMStoneShovelHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Shovel Head");
/*      */     
/*  502 */     igInStoneAxeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Axe Head");
/*  503 */     sedStoneAxeHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Axe Head");
/*  504 */     igExStoneAxeHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Axe Head");
/*  505 */     mMStoneAxeHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Axe Head");
/*      */     
/*  507 */     igInStoneHoeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("IgIn Stone Hoe Head");
/*  508 */     sedStoneHoeHead = (new ItemMiscToolHead(sedToolMaterial)).func_77655_b("Sed Stone Hoe Head");
/*  509 */     igExStoneHoeHead = (new ItemMiscToolHead(igExToolMaterial)).func_77655_b("IgEx Stone Hoe Head");
/*  510 */     mMStoneHoeHead = (new ItemMiscToolHead(mMToolMaterial)).func_77655_b("MM Stone Hoe Head");
/*      */     
/*  512 */     stoneKnifeHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("Stone Knife Blade");
/*  513 */     stoneHammerHead = (new ItemMiscToolHead(igInToolMaterial)).func_77655_b("Stone Hammer Head");
/*      */     
/*  515 */     stoneKnife = (new ItemKnife(igExToolMaterial, 40.0F)).func_77655_b("Stone Knife").func_77656_e(igExStoneUses);
/*  516 */     singlePlank = (new ItemPlank()).func_77655_b("SinglePlank");
/*      */     
/*  518 */     redSteelBucketEmpty = (new ItemSteelBucketRed(Blocks.field_150350_a)).func_77655_b("Red Steel Bucket Empty");
/*  519 */     redSteelBucketWater = (new ItemSteelBucketRed(TFCBlocks.freshWater)).func_77655_b("Red Steel Bucket Water").func_77642_a(redSteelBucketEmpty);
/*  520 */     redSteelBucketSaltWater = (new ItemSteelBucketRed(TFCBlocks.saltWater)).func_77655_b("Red Steel Bucket Salt Water").func_77642_a(redSteelBucketEmpty);
/*      */     
/*  522 */     blueSteelBucketEmpty = (new ItemSteelBucketBlue(Blocks.field_150350_a)).func_77655_b("Blue Steel Bucket Empty");
/*  523 */     blueSteelBucketLava = (new ItemSteelBucketBlue(TFCBlocks.lava)).func_77655_b("Blue Steel Bucket Lava").func_77642_a(blueSteelBucketEmpty);
/*      */     
/*  525 */     quern = (Item)((ItemTerra)(new ItemTerra()).func_77655_b("Quern").func_77656_e(250)).setSize(EnumSize.MEDIUM).setWeight(EnumWeight.HEAVY);
/*  526 */     flintSteel = (new ItemFlintSteel()).func_77655_b("flintAndSteel").func_77656_e(200).func_111206_d("flint_and_steel");
/*      */     
/*  528 */     doorOak = (new ItemWoodDoor(0)).func_77655_b("Oak Door");
/*  529 */     doorAspen = (new ItemWoodDoor(1)).func_77655_b("Aspen Door");
/*  530 */     doorBirch = (new ItemWoodDoor(2)).func_77655_b("Birch Door");
/*  531 */     doorChestnut = (new ItemWoodDoor(3)).func_77655_b("Chestnut Door");
/*  532 */     doorDouglasFir = (new ItemWoodDoor(4)).func_77655_b("Douglas Fir Door");
/*  533 */     doorHickory = (new ItemWoodDoor(5)).func_77655_b("Hickory Door");
/*  534 */     doorMaple = (new ItemWoodDoor(6)).func_77655_b("Maple Door");
/*  535 */     doorAsh = (new ItemWoodDoor(7)).func_77655_b("Ash Door");
/*  536 */     doorPine = (new ItemWoodDoor(8)).func_77655_b("Pine Door");
/*  537 */     doorSequoia = (new ItemWoodDoor(9)).func_77655_b("Sequoia Door");
/*  538 */     doorSpruce = (new ItemWoodDoor(10)).func_77655_b("Spruce Door");
/*  539 */     doorSycamore = (new ItemWoodDoor(11)).func_77655_b("Sycamore Door");
/*  540 */     doorWhiteCedar = (new ItemWoodDoor(12)).func_77655_b("White Cedar Door");
/*  541 */     doorWhiteElm = (new ItemWoodDoor(13)).func_77655_b("White Elm Door");
/*  542 */     doorWillow = (new ItemWoodDoor(14)).func_77655_b("Willow Door");
/*  543 */     doorKapok = (new ItemWoodDoor(15)).func_77655_b("Kapok Door");
/*  544 */     doorAcacia = (new ItemWoodDoor(16)).func_77655_b("Acacia Door");
/*      */     
/*  546 */     beer = (new ItemAlcohol()).func_77655_b("Beer").func_77637_a(TFCTabs.TFC_FOODS);
/*  547 */     cider = (new ItemAlcohol()).func_77655_b("Cider").func_77637_a(TFCTabs.TFC_FOODS);
/*  548 */     rum = (new ItemAlcohol()).func_77655_b("Rum").func_77637_a(TFCTabs.TFC_FOODS);
/*  549 */     ryeWhiskey = (new ItemAlcohol()).func_77655_b("RyeWhiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*  550 */     sake = (new ItemAlcohol()).func_77655_b("Sake").func_77637_a(TFCTabs.TFC_FOODS);
/*  551 */     vodka = (new ItemAlcohol()).func_77655_b("Vodka").func_77637_a(TFCTabs.TFC_FOODS);
/*  552 */     whiskey = (new ItemAlcohol()).func_77655_b("Whiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*  553 */     cornWhiskey = (new ItemAlcohol()).func_77655_b("CornWhiskey").func_77637_a(TFCTabs.TFC_FOODS);
/*      */     
/*  555 */     blueprint = (Item)new ItemBlueprint();
/*  556 */     nametag = (Item)new ItemCustomNameTag();
/*      */     
/*  558 */     woolYarn = (new ItemYarn()).func_77655_b("WoolYarn").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  559 */     wool = (new ItemTerra()).func_77655_b("Wool").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  560 */     woolCloth = (new ItemTerra()).func_77655_b("WoolCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  561 */     silkCloth = (new ItemTerra()).func_77655_b("SilkCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  562 */     burlapCloth = (new ItemTerra()).func_77655_b("BurlapCloth").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  563 */     spindle = (new ItemSpindle()).func_77655_b("Spindle").func_77637_a(TFCTabs.TFC_POTTERY);
/*      */ 
/*      */     
/*  566 */     spindleHead = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Spindle", "Spindle Head" }).func_77655_b("Spindle Head").func_77637_a(TFCTabs.TFC_POTTERY);
/*  567 */     stoneBrick = (new ItemStoneBrick()).setFolder("tools/").func_77655_b("ItemStoneBrick");
/*  568 */     mortar = (new ItemTerra()).setFolder("tools/").func_77655_b("Mortar").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  569 */     vinegar = (new ItemCustomBucket(Blocks.field_150350_a)).setFolder("food/").func_77655_b("Vinegar").func_77642_a(woodenBucketEmpty).func_77637_a(TFCTabs.TFC_FOODS);
/*  570 */     hide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  571 */     soakedHide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Soaked Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  572 */     scrapedHide = (new ItemRawHide()).setFolder("tools/").func_77655_b("Scraped Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  573 */     prepHide = (new ItemRawHide()).setFolder("tools/").setFolder("tools/").func_77655_b("Prep Hide").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  575 */     sheepSkin = (new ItemRawHide()).setFolder("tools/").func_77655_b("Sheep Skin").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  576 */     flatLeather = (new ItemFlatGeneric()).setFolder("tools/").func_77655_b("Flat Leather");
/*  577 */     leather = (new ItemLeather()).setSpecialCraftingType(flatLeather).setFolder("tools/").func_77655_b("TFC Leather");
/*      */     
/*  579 */     straw = (new ItemTerra()).setFolder("plants/").func_77655_b("Straw").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  581 */     flatClay = (new ItemFlatGeneric()).setFolder("pottery/").setMetaNames(new String[] { "clay flat light", "clay flat dark", "clay flat fire", "clay flat dark fire" }).func_77655_b("Flat Clay");
/*      */     
/*  583 */     potteryJug = (new ItemPotteryJug()).func_77655_b("Jug");
/*  584 */     potterySmallVessel = (new ItemPotterySmallVessel()).func_77655_b("Small Vessel");
/*      */     
/*  586 */     ceramicMold = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Mold", "Ceramic Mold" }).func_77655_b("Mold");
/*  587 */     potteryBowl = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Bowl", "Ceramic Bowl" }).func_77655_b("ClayBowl");
/*  588 */     clayBall = (new ItemClay()).setSpecialCraftingType(flatClay, new ItemStack(flatClay, 1, 1)).setMetaNames(new String[] { "Clay", "Fire Clay" }).func_77655_b("Clay");
/*  589 */     fireBrick = (new ItemPotteryBase()).setMetaNames(new String[] { "Clay Fire Brick", "Fire Brick" }).func_77655_b("Fire Brick");
/*      */ 
/*      */     
/*  592 */     clayMoldAxe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Axe", "Ceramic Mold Axe", "Ceramic Mold Axe Copper", "Ceramic Mold Axe Bronze", "Ceramic Mold Axe Bismuth Bronze", "Ceramic Mold Axe Black Bronze" }).func_77655_b("Axe Mold");
/*      */     
/*  594 */     clayMoldChisel = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Chisel", "Ceramic Mold Chisel", "Ceramic Mold Chisel Copper", "Ceramic Mold Chisel Bronze", "Ceramic Mold Chisel Bismuth Bronze", "Ceramic Mold Chisel Black Bronze" }).func_77655_b("Chisel Mold");
/*      */     
/*  596 */     clayMoldHammer = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Hammer", "Ceramic Mold Hammer", "Ceramic Mold Hammer Copper", "Ceramic Mold Hammer Bronze", "Ceramic Mold Hammer Bismuth Bronze", "Ceramic Mold Hammer Black Bronze" }).func_77655_b("Hammer Mold");
/*      */     
/*  598 */     clayMoldHoe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Hoe", "Ceramic Mold Hoe", "Ceramic Mold Hoe Copper", "Ceramic Mold Hoe Bronze", "Ceramic Mold Hoe Bismuth Bronze", "Ceramic Mold Hoe Black Bronze" }).func_77655_b("Hoe Mold");
/*      */     
/*  600 */     clayMoldKnife = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Knife", "Ceramic Mold Knife", "Ceramic Mold Knife Copper", "Ceramic Mold Knife Bronze", "Ceramic Mold Knife Bismuth Bronze", "Ceramic Mold Knife Black Bronze" }).func_77655_b("Knife Mold");
/*      */     
/*  602 */     clayMoldMace = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Mace", "Ceramic Mold Mace", "Ceramic Mold Mace Copper", "Ceramic Mold Mace Bronze", "Ceramic Mold Mace Bismuth Bronze", "Ceramic Mold Mace Black Bronze" }).func_77655_b("Mace Mold");
/*      */     
/*  604 */     clayMoldPick = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Pick", "Ceramic Mold Pick", "Ceramic Mold Pick Copper", "Ceramic Mold Pick Bronze", "Ceramic Mold Pick Bismuth Bronze", "Ceramic Mold Pick Black Bronze" }).func_77655_b("Pick Mold");
/*      */     
/*  606 */     clayMoldProPick = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold ProPick", "Ceramic Mold ProPick", "Ceramic Mold ProPick Copper", "Ceramic Mold ProPick Bronze", "Ceramic Mold ProPick Bismuth Bronze", "Ceramic Mold ProPick Black Bronze" }).func_77655_b("ProPick Mold");
/*      */     
/*  608 */     clayMoldSaw = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Saw", "Ceramic Mold Saw", "Ceramic Mold Saw Copper", "Ceramic Mold Saw Bronze", "Ceramic Mold Saw Bismuth Bronze", "Ceramic Mold Saw Black Bronze" }).func_77655_b("Saw Mold");
/*      */     
/*  610 */     clayMoldScythe = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Scythe", "Ceramic Mold Scythe", "Ceramic Mold Scythe Copper", "Ceramic Mold Scythe Bronze", "Ceramic Mold Scythe Bismuth Bronze", "Ceramic Mold Scythe Black Bronze" }).func_77655_b("Scythe Mold");
/*      */     
/*  612 */     clayMoldShovel = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Shovel", "Ceramic Mold Shovel", "Ceramic Mold Shovel Copper", "Ceramic Mold Shovel Bronze", "Ceramic Mold Shovel Bismuth Bronze", "Ceramic Mold Shovel Black Bronze" }).func_77655_b("Shovel Mold");
/*      */     
/*  614 */     clayMoldSword = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Sword", "Ceramic Mold Sword", "Ceramic Mold Sword Copper", "Ceramic Mold Sword Bronze", "Ceramic Mold Sword Bismuth Bronze", "Ceramic Mold Sword Black Bronze" }).func_77655_b("Sword Mold");
/*      */     
/*  616 */     clayMoldJavelin = (new ItemPotteryMold()).setMetaNames(new String[] { "Clay Mold Javelin", "Ceramic Mold Javelin", "Ceramic Mold Javelin Copper", "Ceramic Mold Javelin Bronze", "Ceramic Mold Javelin Bismuth Bronze", "Ceramic Mold Javelin Black Bronze" }).func_77655_b("Javelin Mold");
/*      */     
/*  618 */     tuyereCopper = (new ItemTuyere(40, 0)).func_77655_b("Copper Tuyere");
/*  619 */     tuyereBronze = (new ItemTuyere(80, 1)).func_77655_b("Bronze Tuyere");
/*  620 */     tuyereBlackBronze = (new ItemTuyere(80, 1)).func_77655_b("Black Bronze Tuyere");
/*  621 */     tuyereBismuthBronze = (new ItemTuyere(80, 1)).func_77655_b("Bismuth Bronze Tuyere");
/*  622 */     tuyereWroughtIron = (new ItemTuyere(120, 2)).func_77655_b("Wrought Iron Tuyere");
/*  623 */     tuyereSteel = (new ItemTuyere(180, 3)).func_77655_b("Steel Tuyere");
/*  624 */     tuyereBlackSteel = (new ItemTuyere(260, 4)).func_77655_b("Black Steel Tuyere");
/*  625 */     tuyereRedSteel = (new ItemTuyere(400, 5)).func_77655_b("Red Steel Tuyere");
/*  626 */     tuyereBlueSteel = (new ItemTuyere(500, 6)).func_77655_b("Blue Steel Tuyere");
/*      */     
/*  628 */     bloom = (new ItemBloom()).setFolder("ingots/").func_77655_b("Iron Bloom");
/*  629 */     rawBloom = (new ItemBloom()).setFolder("ingots/").func_77655_b("Raw Iron Bloom");
/*      */     
/*  631 */     unknownIngot = (new ItemIngot()).func_77655_b("Unknown Ingot");
/*  632 */     unknownUnshaped = (new ItemMeltedMetal()).func_77655_b("Unknown Unshaped");
/*      */     
/*  634 */     jute = (new ItemTerra()).setFolder("plants/").func_77655_b("Jute").func_77637_a(TFCTabs.TFC_MATERIALS);
/*  635 */     juteFiber = (new ItemTerra()).setFolder("plants/").func_77655_b("Jute Fibre").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */     
/*  637 */     Items.field_151120_aE.func_77637_a(null);
/*  638 */     reeds = (new ItemReeds()).func_77655_b("Reeds").func_77637_a(TFCTabs.TFC_MATERIALS).func_111206_d("reeds");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  643 */     setupFood();
/*      */     
/*  645 */     fertilizer = (new ItemFertilizer()).func_77655_b("Fertilizer").func_77637_a(TFCTabs.TFC_MATERIALS);
/*      */ 
/*      */     
/*  648 */     setupArmor();
/*      */     
/*  650 */     Recipes.doors = new Item[] { doorOak, doorAspen, doorBirch, doorChestnut, doorDouglasFir, doorHickory, doorMaple, doorAsh, doorPine, doorSequoia, doorSpruce, doorSycamore, doorWhiteCedar, doorWhiteElm, doorWillow, doorKapok, doorAcacia };
/*      */ 
/*      */ 
/*      */     
/*  654 */     Recipes.axes = new Item[] { sedAxe, igInAxe, igExAxe, mMAxe, bismuthBronzeAxe, blackBronzeAxe, blackSteelAxe, blueSteelAxe, bronzeAxe, copperAxe, wroughtIronAxe, redSteelAxe, steelAxe };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  659 */     Recipes.chisels = new Item[] { bismuthBronzeChisel, blackBronzeChisel, blackSteelChisel, blueSteelChisel, bronzeChisel, copperChisel, wroughtIronChisel, redSteelChisel, steelChisel };
/*      */ 
/*      */ 
/*      */     
/*  663 */     Recipes.saws = new Item[] { bismuthBronzeSaw, blackBronzeSaw, blackSteelSaw, blueSteelSaw, bronzeSaw, copperSaw, wroughtIronSaw, redSteelSaw, steelSaw };
/*      */ 
/*      */ 
/*      */     
/*  667 */     Recipes.knives = new Item[] { stoneKnife, bismuthBronzeKnife, blackBronzeKnife, blackSteelKnife, blueSteelKnife, bronzeKnife, copperKnife, wroughtIronKnife, redSteelKnife, steelKnife };
/*      */ 
/*      */ 
/*      */     
/*  671 */     Recipes.meltedMetal = new Item[] { bismuthUnshaped, bismuthBronzeUnshaped, blackBronzeUnshaped, blackSteelUnshaped, blueSteelUnshaped, brassUnshaped, bronzeUnshaped, copperUnshaped, goldUnshaped, wroughtIronUnshaped, leadUnshaped, nickelUnshaped, pigIronUnshaped, platinumUnshaped, redSteelUnshaped, roseGoldUnshaped, silverUnshaped, steelUnshaped, sterlingSilverUnshaped, tinUnshaped, zincUnshaped, highCarbonSteelUnshaped, weakSteelUnshaped, highCarbonBlackSteelUnshaped, highCarbonBlueSteelUnshaped, highCarbonRedSteelUnshaped, weakBlueSteelUnshaped, weakRedSteelUnshaped };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  679 */     Recipes.hammers = new Item[] { stoneHammer, bismuthBronzeHammer, blackBronzeHammer, blackSteelHammer, blueSteelHammer, bronzeHammer, copperHammer, wroughtIronHammer, redSteelHammer, steelHammer };
/*      */ 
/*      */ 
/*      */     
/*  683 */     Recipes.scythes = new Item[] { bismuthBronzeScythe, blackBronzeScythe, blackSteelScythe, blueSteelScythe, bronzeScythe, copperScythe, wroughtIronScythe, redSteelScythe, steelScythe };
/*      */ 
/*      */ 
/*      */     
/*  687 */     Recipes.picks = new Item[] { bismuthBronzePick, blackBronzePick, blackSteelPick, blueSteelPick, bronzePick, copperPick, wroughtIronPick, redSteelPick, steelPick };
/*      */ 
/*      */ 
/*      */     
/*  691 */     Recipes.proPicks = new Item[] { proPickBismuthBronze, proPickBlackBronze, proPickBlackSteel, proPickBlueSteel, proPickBronze, proPickCopper, proPickIron, proPickRedSteel, proPickSteel };
/*      */ 
/*      */ 
/*      */     
/*  695 */     Recipes.shovels = new Item[] { sedShovel, igInShovel, igExShovel, mMShovel, bismuthBronzeShovel, blackBronzeShovel, blackSteelShovel, blueSteelShovel, bronzeShovel, copperShovel, wroughtIronShovel, redSteelShovel, steelShovel };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  700 */     Recipes.hoes = new Item[] { sedHoe, igInHoe, igExHoe, mMHoe, bismuthBronzeHoe, blackBronzeHoe, blackSteelHoe, blueSteelHoe, bronzeHoe, copperHoe, wroughtIronHoe, redSteelHoe, steelHoe };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  705 */     Recipes.swords = new Item[] { bismuthBronzeSword, blackBronzeSword, blackSteelSword, blueSteelSword, bronzeSword, copperSword, wroughtIronSword, redSteelSword, steelSword };
/*      */ 
/*      */ 
/*      */     
/*  709 */     Recipes.maces = new Item[] { bismuthBronzeMace, blackBronzeMace, blackSteelMace, blueSteelMace, bronzeMace, copperMace, wroughtIronMace, redSteelMace, steelMace };
/*      */ 
/*      */ 
/*      */     
/*  713 */     Recipes.javelins = new Item[] { sedStoneJavelin, igInStoneJavelin, igExStoneJavelin, mMStoneJavelin, bismuthBronzeJavelin, blackBronzeJavelin, blackSteelJavelin, blueSteelJavelin, bronzeJavelin, copperJavelin, wroughtIronJavelin, redSteelJavelin, steelJavelin };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  719 */     Recipes.spindle = new Item[] { spindle };
/*      */     
/*  721 */     Recipes.gems = new Item[] { gemAgate, gemAmethyst, gemBeryl, gemDiamond, gemEmerald, gemGarnet, gemJade, gemJasper, gemOpal, gemRuby, gemSapphire, gemTopaz, gemTourmaline };
/*      */ 
/*      */     
/*  724 */     Recipes.seeds = new Item[] { seedsBarley, seedsCabbage, seedsCarrot, seedsGarlic, seedsGreenbean, seedsJute, seedsMaize, seedsOat, seedsOnion, seedsPotato, seedsRedBellPepper, seedsRice, seedsRye, seedsSoybean, seedsSquash, seedsSugarcane, seedsTomato, seedsWheat, seedsYellowBellPepper };
/*      */ 
/*      */ 
/*      */     
/*  728 */     ((TFCTabs)TFCTabs.TFC_BUILDING).setTabIconItemStack(new ItemStack(TFCBlocks.stoneSedBrick));
/*  729 */     ((TFCTabs)TFCTabs.TFC_DECORATION).setTabIconItemStack(new ItemStack(TFCBlocks.flora));
/*  730 */     ((TFCTabs)TFCTabs.TFC_DEVICES).setTabIconItem(sluiceItem);
/*  731 */     ((TFCTabs)TFCTabs.TFC_POTTERY).setTabIconItemStack(new ItemStack(potteryJug, 1, 1));
/*  732 */     ((TFCTabs)TFCTabs.TFC_MISC).setTabIconItem(blueSteelBucketLava);
/*  733 */     ((TFCTabs)TFCTabs.TFC_FOODS).setTabIconItem(redApple);
/*  734 */     ((TFCTabs)TFCTabs.TFC_TOOLS).setTabIconItem(redSteelAxe);
/*  735 */     ((TFCTabs)TFCTabs.TFC_WEAPONS).setTabIconItem(bismuthBronzeSword);
/*  736 */     ((TFCTabs)TFCTabs.TFC_ARMOR).setTabIconItem(bronzeHelmet);
/*  737 */     ((TFCTabs)TFCTabs.TFC_MATERIALS).setTabIconItem(blueSteelIngot);
/*      */     
/*  739 */     registerItems();
/*  740 */     registerMetals();
/*      */     
/*  742 */     TerraFirmaCraft.LOG.info("Finished Loading Items");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void setupFood() {
/*  750 */     foodList = new ArrayList();
/*      */     
/*  752 */     egg = (new ItemEgg()).setSize(EnumSize.SMALL).func_77655_b("egg").func_111206_d("egg").func_77637_a(TFCTabs.TFC_FOODS);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  757 */     porkchopRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Porkchop");
/*  758 */     fishRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, true)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Fish");
/*  759 */     beefRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 50, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Beef");
/*  760 */     chickenRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Chicken");
/*  761 */     soybean = (new ItemFoodTFC(EnumFoodGroup.Protein, 10, 0, 0, 0, 40, true)).func_77655_b("Soybeans");
/*  762 */     eggCooked = (new ItemFoodTFC(EnumFoodGroup.Protein, 0, 0, 0, 0, 25)).setDecayRate(2.5F).func_77655_b("Egg Cooked");
/*  763 */     calamariRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 20, 0, 35, false, false)).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).setDecayRate(4.0F).func_77655_b("Calamari");
/*  764 */     muttonRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Mutton");
/*  765 */     venisonRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 5, 0, 0, 0, 50, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Venison");
/*  766 */     horseMeatRaw = (new ItemFoodMeat(EnumFoodGroup.Protein, 0, 0, 0, 0, 40, false, false)).setDecayRate(2.5F).setCanSmoke().setHasCookedIcon().setSmokeAbsorbMultiplier(1.0F).func_77655_b("HorseMeat");
/*      */ 
/*      */     
/*  769 */     cheese = (new ItemFoodTFC(EnumFoodGroup.Dairy, 0, 10, 20, 0, 35)).setDecayRate(0.5F).setCanSmoke().setSmokeAbsorbMultiplier(1.0F).func_77655_b("Cheese");
/*      */ 
/*      */     
/*  772 */     wheatGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Wheat Grain");
/*  773 */     barleyGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 10, 20)).setDecayRate(0.5F).func_77655_b("Barley Grain");
/*  774 */     oatGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Oat Grain");
/*  775 */     ryeGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Rye Grain");
/*  776 */     riceGrain = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).setDecayRate(0.5F).func_77655_b("Rice Grain");
/*  777 */     maizeEar = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 5, 20, true)).func_77655_b("Maize Ear");
/*      */     
/*  779 */     wheatWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Wheat Whole");
/*  780 */     barleyWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 10, 20, false, false)).setFolder("food/").func_77655_b("Barley Whole");
/*  781 */     oatWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Oat Whole");
/*  782 */     ryeWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Rye Whole");
/*  783 */     riceWhole = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Rice Whole");
/*      */     
/*  785 */     wheatGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Wheat Ground");
/*  786 */     barleyGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).setFolder("food/").func_77655_b("Barley Ground");
/*  787 */     oatGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Oat Ground");
/*  788 */     ryeGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Rye Ground");
/*  789 */     riceGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Rice Ground");
/*  790 */     cornmealGround = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20, false, false)).setFolder("food/").func_77655_b("Cornmeal Ground");
/*      */     
/*  792 */     wheatDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Wheat Dough");
/*  793 */     barleyDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20, false, false)).func_77655_b("Barley Dough");
/*  794 */     oatDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Oat Dough");
/*  795 */     ryeDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20, false, false)).func_77655_b("Rye Dough");
/*  796 */     riceDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20, false, false)).func_77655_b("Rice Dough");
/*  797 */     cornmealDough = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20, false, false)).func_77655_b("Cornmeal Dough");
/*      */     
/*  799 */     wheatBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Wheat Bread");
/*  800 */     barleyBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 5, 20)).func_77655_b("Barley Bread");
/*  801 */     oatBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Oat Bread");
/*  802 */     ryeBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 15, 0, 0, 20)).func_77655_b("Rye Bread");
/*  803 */     riceBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 10, 0, 0, 0, 20)).func_77655_b("Rice Bread");
/*  804 */     cornBread = (new ItemFoodTFC(EnumFoodGroup.Grain, 25, 0, 0, 0, 20)).func_77655_b("Corn Bread");
/*      */ 
/*      */     
/*  807 */     tomato = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 30, 5, 0, 0, 50, true)).func_77655_b("Tomato");
/*  808 */     potato = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 10, 15, 20, true)).func_77655_b("Potato");
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
/*  828 */     onion = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 25, 0, 0, 20, true) { public void func_94581_a(IIconRegister registerer) { super.func_94581_a(registerer); this.field_77787_bX = true; this.metaIcons = new IIcon[2]; this.metaIcons[0] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", "")); this.metaIcons[1] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + "Rutabaga"); } public IIcon func_77617_a(int i) { if (i == 1) return this.metaIcons[1];  return super.func_77617_a(i); } }).func_77655_b(TFCOptions.onionsAreGross ? "Rutabaga" : "Onion");
/*  829 */     cabbage = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 0, 0, 0, 30, true)).func_77655_b("Cabbage");
/*  830 */     garlic = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 0, 10, 20, true)).func_77655_b("Garlic");
/*  831 */     carrot = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Carrot");
/*  832 */     greenbeans = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Greenbeans");
/*  833 */     greenBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 10, 0, 0, 0, 20, true)).func_77655_b("Green Bell Pepper");
/*  834 */     yellowBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 15, 0, 0, 0, 20, true)).func_77655_b("Yellow Bell Pepper");
/*  835 */     redBellPepper = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Red Bell Pepper");
/*  836 */     squash = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 20, 0, 0, 0, 20, true)).func_77655_b("Squash");
/*  837 */     seaWeed = (new ItemFoodTFC(EnumFoodGroup.Vegetable, 0, 0, 10, 10, 10, true)).func_77655_b("Sea Weed");
/*  838 */     sugar = (new ItemFoodTFC(EnumFoodGroup.None, 30, 0, 0, 0, 0, true)).setDecayRate(0.01F).func_77655_b("Sugar");
/*      */ 
/*      */     
/*  841 */     redApple = (new ItemFoodTFC(EnumFoodGroup.Fruit, 25, 5, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[0]);
/*  842 */     banana = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[1]);
/*  843 */     orange = (new ItemFoodTFC(EnumFoodGroup.Fruit, 50, 30, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[2]);
/*  844 */     greenApple = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 15, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[3]);
/*  845 */     lemon = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 50, 0, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[4]);
/*  846 */     olive = (new ItemFoodTFC(EnumFoodGroup.Fruit, 10, 0, 3, 10, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[5]);
/*  847 */     cherry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[6]);
/*  848 */     peach = (new ItemFoodTFC(EnumFoodGroup.Fruit, 25, 10, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[7]);
/*  849 */     plum = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 15, 0, 0, 0, true)).setDecayRate(2.0F).func_77655_b(Global.FRUIT_META_NAMES[8]);
/*      */     
/*  851 */     wintergreenBerry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 0, 0, 20, 0)).setDecayRate(2.0F).func_77655_b("Wintergreen Berry");
/*  852 */     blueberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 20, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Blueberry");
/*  853 */     raspberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 35, 15, 0, 5, 0)).setDecayRate(2.0F).func_77655_b("Raspberry");
/*  854 */     strawberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 5, 0)).setDecayRate(2.0F).func_77655_b("Strawberry");
/*  855 */     blackberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 30, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Blackberry");
/*  856 */     bunchberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 5, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Bunchberry");
/*  857 */     cranberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 30, 5, 0, 45, 0)).setDecayRate(2.0F).func_77655_b("Cranberry");
/*  858 */     snowberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 10, 0, 0, 90, 0)).setDecayRate(2.0F).func_77655_b("Snowberry");
/*  859 */     elderberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 40, 0, 10, 0)).setDecayRate(2.0F).func_77655_b("Elderberry");
/*  860 */     gooseberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 20, 40, 0, 0, 0)).setDecayRate(2.0F).func_77655_b("Gooseberry");
/*  861 */     cloudberry = (new ItemFoodTFC(EnumFoodGroup.Fruit, 40, 40, 0, 30, 0)).setDecayRate(2.0F).func_77655_b("Cloudberry");
/*      */     
/*  863 */     sandwich = (new ItemSandwich()).func_77655_b("Sandwich");
/*  864 */     salad = (new ItemSalad()).func_77655_b("Salad");
/*      */ 
/*      */     
/*  867 */     sugarcane = (new ItemFoodTFC(EnumFoodGroup.None, 30, 0, 0, 0, 0, false, false)).setDecayRate(0.75F).setFolder("plants/").func_77655_b("Sugarcane");
/*      */ 
/*      */     
/*  870 */     seedsWheat = (new ItemCustomSeeds(0)).func_77655_b("Seeds Wheat");
/*  871 */     seedsMaize = (new ItemCustomSeeds(1)).func_77655_b("Seeds Maize");
/*  872 */     seedsTomato = (new ItemCustomSeeds(2)).func_77655_b("Seeds Tomato");
/*  873 */     seedsBarley = (new ItemCustomSeeds(3)).func_77655_b("Seeds Barley");
/*  874 */     seedsRye = (new ItemCustomSeeds(4)).func_77655_b("Seeds Rye");
/*  875 */     seedsOat = (new ItemCustomSeeds(5)).func_77655_b("Seeds Oat");
/*  876 */     seedsRice = (new ItemCustomSeeds(6)).func_77655_b("Seeds Rice");
/*  877 */     seedsPotato = (new ItemCustomSeeds(7)).func_77655_b("Seeds Potato");
/*  878 */     seedsOnion = (new ItemCustomSeeds(8)).func_77655_b(TFCOptions.onionsAreGross ? "Seeds Rutabaga" : "Seeds Onion");
/*  879 */     seedsCabbage = (new ItemCustomSeeds(9)).func_77655_b("Seeds Cabbage");
/*  880 */     seedsGarlic = (new ItemCustomSeeds(10)).func_77655_b("Seeds Garlic");
/*  881 */     seedsCarrot = (new ItemCustomSeeds(11)).func_77655_b("Seeds Carrot");
/*  882 */     seedsYellowBellPepper = (new ItemCustomSeeds(12)).func_77655_b("Seeds Yellow Bell Pepper");
/*  883 */     seedsRedBellPepper = (new ItemCustomSeeds(13)).func_77655_b("Seeds Red Bell Pepper");
/*  884 */     seedsSoybean = (new ItemCustomSeeds(14)).func_77655_b("Seeds Soybean");
/*  885 */     seedsGreenbean = (new ItemCustomSeeds(15)).func_77655_b("Seeds Greenbean");
/*  886 */     seedsSquash = (new ItemCustomSeeds(16)).func_77655_b("Seeds Squash");
/*  887 */     seedsJute = (new ItemCustomSeeds(17)).func_77655_b("Seeds Jute");
/*  888 */     seedsSugarcane = (new ItemCustomSeeds(18)).func_77655_b("Seeds Sugarcane");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  893 */     fruitTreeSapling = (new ItemFruitTreeSapling()).func_77655_b("FruitSapling");
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
/*  913 */     Global.BISMUTH = new Metal("Bismuth", TFCItems.bismuthUnshaped, TFCItems.bismuthIngot);
/*  914 */     Global.BISMUTHBRONZE = new Metal("Bismuth Bronze", TFCItems.bismuthBronzeUnshaped, TFCItems.bismuthBronzeIngot);
/*  915 */     Global.BLACKBRONZE = new Metal("Black Bronze", TFCItems.blackBronzeUnshaped, TFCItems.blackBronzeIngot);
/*  916 */     Global.BLACKSTEEL = new Metal("Black Steel", TFCItems.blackSteelUnshaped, TFCItems.blackSteelIngot);
/*  917 */     Global.BLUESTEEL = new Metal("Blue Steel", TFCItems.blueSteelUnshaped, TFCItems.blueSteelIngot);
/*  918 */     Global.BRASS = new Metal("Brass", TFCItems.brassUnshaped, TFCItems.brassIngot);
/*  919 */     Global.BRONZE = new Metal("Bronze", TFCItems.bronzeUnshaped, TFCItems.bronzeIngot);
/*  920 */     Global.COPPER = new Metal("Copper", TFCItems.copperUnshaped, TFCItems.copperIngot);
/*  921 */     Global.GOLD = new Metal("Gold", TFCItems.goldUnshaped, TFCItems.goldIngot);
/*  922 */     Global.WROUGHTIRON = new Metal("Wrought Iron", TFCItems.wroughtIronUnshaped, TFCItems.wroughtIronIngot);
/*  923 */     Global.LEAD = new Metal("Lead", TFCItems.leadUnshaped, TFCItems.leadIngot);
/*  924 */     Global.NICKEL = new Metal("Nickel", TFCItems.nickelUnshaped, TFCItems.nickelIngot);
/*  925 */     Global.PIGIRON = new Metal("Pig Iron", TFCItems.pigIronUnshaped, TFCItems.pigIronIngot);
/*  926 */     Global.PLATINUM = new Metal("Platinum", TFCItems.platinumUnshaped, TFCItems.platinumIngot);
/*  927 */     Global.REDSTEEL = new Metal("Red Steel", TFCItems.redSteelUnshaped, TFCItems.redSteelIngot);
/*  928 */     Global.ROSEGOLD = new Metal("Rose Gold", TFCItems.roseGoldUnshaped, TFCItems.roseGoldIngot);
/*  929 */     Global.SILVER = new Metal("Silver", TFCItems.silverUnshaped, TFCItems.silverIngot);
/*  930 */     Global.STEEL = new Metal("Steel", TFCItems.steelUnshaped, TFCItems.steelIngot);
/*  931 */     Global.STERLINGSILVER = new Metal("Sterling Silver", TFCItems.sterlingSilverUnshaped, TFCItems.sterlingSilverIngot);
/*  932 */     Global.TIN = new Metal("Tin", TFCItems.tinUnshaped, TFCItems.tinIngot);
/*  933 */     Global.ZINC = new Metal("Zinc", TFCItems.zincUnshaped, TFCItems.zincIngot);
/*  934 */     Global.WEAKSTEEL = new Metal("Weak Steel", TFCItems.weakSteelUnshaped, TFCItems.weakSteelIngot);
/*  935 */     Global.HCBLACKSTEEL = new Metal("HC Black Steel", TFCItems.highCarbonBlackSteelUnshaped, TFCItems.highCarbonBlackSteelIngot);
/*  936 */     Global.WEAKREDSTEEL = new Metal("Weak Red Steel", TFCItems.weakRedSteelUnshaped, TFCItems.weakRedSteelIngot);
/*  937 */     Global.HCREDSTEEL = new Metal("HC Red Steel", TFCItems.highCarbonRedSteelUnshaped, TFCItems.highCarbonRedSteelIngot);
/*  938 */     Global.WEAKBLUESTEEL = new Metal("Weak Blue Steel", TFCItems.weakBlueSteelUnshaped, TFCItems.weakBlueSteelIngot);
/*  939 */     Global.HCBLUESTEEL = new Metal("HC Blue Steel", TFCItems.highCarbonBlueSteelUnshaped, TFCItems.highCarbonBlueSteelIngot);
/*  940 */     Global.UNKNOWN = new Metal("Unknown", TFCItems.unknownUnshaped, TFCItems.unknownIngot, false);
/*      */     
/*  942 */     MetalRegistry.instance.addMetal(Global.BISMUTH, Alloy.EnumTier.TierI);
/*  943 */     MetalRegistry.instance.addMetal(Global.BISMUTHBRONZE, Alloy.EnumTier.TierI);
/*  944 */     MetalRegistry.instance.addMetal(Global.BLACKBRONZE, Alloy.EnumTier.TierI);
/*  945 */     MetalRegistry.instance.addMetal(Global.BLACKSTEEL, Alloy.EnumTier.TierV);
/*  946 */     MetalRegistry.instance.addMetal(Global.BLUESTEEL, Alloy.EnumTier.TierV);
/*  947 */     MetalRegistry.instance.addMetal(Global.BRASS, Alloy.EnumTier.TierI);
/*  948 */     MetalRegistry.instance.addMetal(Global.BRONZE, Alloy.EnumTier.TierI);
/*  949 */     MetalRegistry.instance.addMetal(Global.COPPER, Alloy.EnumTier.TierI);
/*  950 */     MetalRegistry.instance.addMetal(Global.GOLD, Alloy.EnumTier.TierI);
/*  951 */     MetalRegistry.instance.addMetal(Global.WROUGHTIRON, Alloy.EnumTier.TierIII);
/*  952 */     MetalRegistry.instance.addMetal(Global.LEAD, Alloy.EnumTier.TierI);
/*  953 */     MetalRegistry.instance.addMetal(Global.NICKEL, Alloy.EnumTier.TierI);
/*  954 */     MetalRegistry.instance.addMetal(Global.PIGIRON, Alloy.EnumTier.TierIV);
/*  955 */     MetalRegistry.instance.addMetal(Global.PLATINUM, Alloy.EnumTier.TierV);
/*  956 */     MetalRegistry.instance.addMetal(Global.REDSTEEL, Alloy.EnumTier.TierV);
/*  957 */     MetalRegistry.instance.addMetal(Global.ROSEGOLD, Alloy.EnumTier.TierI);
/*  958 */     MetalRegistry.instance.addMetal(Global.SILVER, Alloy.EnumTier.TierI);
/*  959 */     MetalRegistry.instance.addMetal(Global.STEEL, Alloy.EnumTier.TierIV);
/*  960 */     MetalRegistry.instance.addMetal(Global.STERLINGSILVER, Alloy.EnumTier.TierI);
/*  961 */     MetalRegistry.instance.addMetal(Global.TIN, Alloy.EnumTier.TierI);
/*  962 */     MetalRegistry.instance.addMetal(Global.ZINC, Alloy.EnumTier.TierI);
/*  963 */     MetalRegistry.instance.addMetal(Global.WEAKSTEEL, Alloy.EnumTier.TierV);
/*  964 */     MetalRegistry.instance.addMetal(Global.HCBLACKSTEEL, Alloy.EnumTier.TierV);
/*  965 */     MetalRegistry.instance.addMetal(Global.WEAKREDSTEEL, Alloy.EnumTier.TierV);
/*  966 */     MetalRegistry.instance.addMetal(Global.HCREDSTEEL, Alloy.EnumTier.TierV);
/*  967 */     MetalRegistry.instance.addMetal(Global.WEAKBLUESTEEL, Alloy.EnumTier.TierV);
/*  968 */     MetalRegistry.instance.addMetal(Global.HCBLUESTEEL, Alloy.EnumTier.TierV);
/*  969 */     MetalRegistry.instance.addMetal(Global.UNKNOWN, Alloy.EnumTier.TierI);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  974 */     Alloy bronze = new Alloy(Global.BRONZE, Alloy.EnumTier.TierI);
/*  975 */     bronze.addIngred(Global.COPPER, 87.99F, 92.01F);
/*  976 */     bronze.addIngred(Global.TIN, 7.99F, 12.01F);
/*  977 */     AlloyManager.INSTANCE.addAlloy(bronze);
/*      */     
/*  979 */     Alloy brass = new Alloy(Global.BRASS, Alloy.EnumTier.TierI);
/*  980 */     brass.addIngred(Global.COPPER, 87.99F, 92.01F);
/*  981 */     brass.addIngred(Global.ZINC, 7.99F, 12.01F);
/*  982 */     AlloyManager.INSTANCE.addAlloy(brass);
/*      */     
/*  984 */     Alloy roseGold = new Alloy(Global.ROSEGOLD, Alloy.EnumTier.TierI);
/*  985 */     roseGold.addIngred(Global.GOLD, 69.99F, 85.01F);
/*  986 */     roseGold.addIngred(Global.COPPER, 14.99F, 30.01F);
/*  987 */     AlloyManager.INSTANCE.addAlloy(roseGold);
/*      */     
/*  989 */     Alloy blackBronze = new Alloy(Global.BLACKBRONZE, Alloy.EnumTier.TierI);
/*  990 */     blackBronze.addIngred(Global.GOLD, 9.99F, 25.01F);
/*  991 */     blackBronze.addIngred(Global.COPPER, 49.99F, 70.01F);
/*  992 */     blackBronze.addIngred(Global.SILVER, 9.99F, 25.01F);
/*  993 */     AlloyManager.INSTANCE.addAlloy(blackBronze);
/*      */     
/*  995 */     Alloy bismuthBronze = new Alloy(Global.BISMUTHBRONZE, Alloy.EnumTier.TierI);
/*  996 */     bismuthBronze.addIngred(Global.ZINC, 19.99F, 30.01F);
/*  997 */     bismuthBronze.addIngred(Global.COPPER, 49.99F, 65.01F);
/*  998 */     bismuthBronze.addIngred(Global.BISMUTH, 9.99F, 20.01F);
/*  999 */     AlloyManager.INSTANCE.addAlloy(bismuthBronze);
/*      */     
/* 1001 */     Alloy sterlingSilver = new Alloy(Global.STERLINGSILVER, Alloy.EnumTier.TierI);
/* 1002 */     sterlingSilver.addIngred(Global.SILVER, 59.99F, 80.01F);
/* 1003 */     sterlingSilver.addIngred(Global.COPPER, 19.99F, 40.01F);
/* 1004 */     AlloyManager.INSTANCE.addAlloy(sterlingSilver);
/*      */     
/* 1006 */     Alloy weakSteel = new Alloy(Global.WEAKSTEEL, Alloy.EnumTier.TierIII);
/* 1007 */     weakSteel.addIngred(Global.STEEL, 49.99F, 70.01F);
/* 1008 */     weakSteel.addIngred(Global.NICKEL, 14.99F, 25.01F);
/* 1009 */     weakSteel.addIngred(Global.BLACKBRONZE, 14.99F, 25.01F);
/* 1010 */     AlloyManager.INSTANCE.addAlloy(weakSteel);
/*      */     
/* 1012 */     Alloy weakRedSteel = new Alloy(Global.WEAKREDSTEEL, Alloy.EnumTier.TierIII);
/* 1013 */     weakRedSteel.addIngred(Global.BLACKSTEEL, 49.99F, 55.01F);
/* 1014 */     weakRedSteel.addIngred(Global.ROSEGOLD, 9.99F, 15.01F);
/* 1015 */     weakRedSteel.addIngred(Global.BRASS, 9.99F, 15.01F);
/* 1016 */     weakRedSteel.addIngred(Global.STEEL, 19.99F, 25.01F);
/* 1017 */     AlloyManager.INSTANCE.addAlloy(weakRedSteel);
/*      */     
/* 1019 */     Alloy weakBlueSteel = new Alloy(Global.WEAKBLUESTEEL, Alloy.EnumTier.TierIII);
/* 1020 */     weakBlueSteel.addIngred(Global.BLACKSTEEL, 49.99F, 55.01F);
/* 1021 */     weakBlueSteel.addIngred(Global.BISMUTHBRONZE, 9.99F, 15.01F);
/* 1022 */     weakBlueSteel.addIngred(Global.STERLINGSILVER, 9.99F, 15.01F);
/* 1023 */     weakBlueSteel.addIngred(Global.STEEL, 19.99F, 25.01F);
/* 1024 */     AlloyManager.INSTANCE.addAlloy(weakBlueSteel);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void setupArmor() {
/* 1029 */     String[] names = { "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Bronze", "Copper", "Wrought Iron", "Red Steel", "Steel" };
/* 1030 */     String[] namesNSO = { "Brass", "Gold", "Lead", "Nickel", "Pig Iron", "Platinum", "Silver", "Sterling Silver" };
/* 1031 */     CommonProxy proxy = TerraFirmaCraft.proxy;
/* 1032 */     int i = 0;
/*      */     
/* 1034 */     bismuthSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(0)).func_77655_b("Bismuth Sheet")).setMetal("Bismuth", 100);
/* 1035 */     bismuthBronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(1)).func_77655_b("Bismuth Bronze Sheet")).setMetal("Bismuth Bronze", 100);
/* 1036 */     blackBronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(2)).func_77655_b("Black Bronze Sheet")).setMetal("Black Bronze", 100);
/* 1037 */     blackSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(3)).func_77655_b("Black Steel Sheet")).setMetal("Black Steel", 100);
/* 1038 */     blueSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(4)).func_77655_b("Blue Steel Sheet")).setMetal("Blue Steel", 100);
/* 1039 */     bronzeSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(6)).func_77655_b("Bronze Sheet")).setMetal("Bronze", 100);
/* 1040 */     copperSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(7)).func_77655_b("Copper Sheet")).setMetal("Copper", 100);
/* 1041 */     wroughtIronSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(9)).func_77655_b("Wrought Iron Sheet")).setMetal("Wrought Iron", 100);
/* 1042 */     redSteelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(14)).func_77655_b("Red Steel Sheet")).setMetal("Red Steel", 100);
/* 1043 */     roseGoldSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(15)).func_77655_b("Rose Gold Sheet")).setMetal("Rose Gold", 100);
/* 1044 */     steelSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(17)).func_77655_b("Steel Sheet")).setMetal("Steel", 100);
/* 1045 */     tinSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(19)).func_77655_b("Tin Sheet")).setMetal("Tin", 100);
/* 1046 */     zincSheet = (Item)((ItemMetalSheet)(new ItemMetalSheet(20)).func_77655_b("Zinc Sheet")).setMetal("Zinc", 100);
/*      */     
/* 1048 */     bismuthSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(0)).func_77655_b("Bismuth Double Sheet")).setMetal("Bismuth", 200);
/* 1049 */     bismuthBronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(1)).func_77655_b("Bismuth Bronze Double Sheet")).setMetal("Bismuth Bronze", 200);
/* 1050 */     blackBronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(2)).func_77655_b("Black Bronze Double Sheet")).setMetal("Black Bronze", 200);
/* 1051 */     blackSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(3)).func_77655_b("Black Steel Double Sheet")).setMetal("Black Steel", 200);
/* 1052 */     blueSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(4)).func_77655_b("Blue Steel Double Sheet")).setMetal("Blue Steel", 200);
/* 1053 */     bronzeSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(6)).func_77655_b("Bronze Double Sheet")).setMetal("Bronze", 200);
/* 1054 */     copperSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(7)).func_77655_b("Copper Double Sheet")).setMetal("Copper", 200);
/* 1055 */     wroughtIronSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(9)).func_77655_b("Wrought Iron Double Sheet")).setMetal("Wrought Iron", 200);
/* 1056 */     redSteelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(14)).func_77655_b("Red Steel Double Sheet")).setMetal("Red Steel", 200);
/* 1057 */     roseGoldSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(15)).func_77655_b("Rose Gold Double Sheet")).setMetal("Rose Gold", 200);
/* 1058 */     steelSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(17)).func_77655_b("Steel Double Sheet")).setMetal("Steel", 200);
/* 1059 */     tinSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(19)).func_77655_b("Tin Double Sheet")).setMetal("Tin", 200);
/* 1060 */     zincSheet2x = (Item)((ItemMetalSheet2x)(new ItemMetalSheet2x(20)).func_77655_b("Zinc Double Sheet")).setMetal("Zinc", 200);
/*      */     
/* 1062 */     i = 0;
/* 1063 */     brassSheet = (new ItemMetalSheet(5)).setMetal("Brass", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1064 */     goldSheet = (new ItemMetalSheet(8)).setMetal("Gold", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1065 */     leadSheet = (new ItemMetalSheet(10)).setMetal("Lead", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1066 */     nickelSheet = (new ItemMetalSheet(11)).setMetal("Nickel", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1067 */     pigIronSheet = (new ItemMetalSheet(12)).setMetal("Pig Iron", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1068 */     platinumSheet = (new ItemMetalSheet(13)).setMetal("Platinum", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1069 */     silverSheet = (new ItemMetalSheet(16)).setMetal("Silver", 100).func_77655_b(namesNSO[i++] + " Sheet");
/* 1070 */     sterlingSilverSheet = (new ItemMetalSheet(18)).setMetal("Sterling Silver", 100).func_77655_b(namesNSO[i++] + " Sheet");
/*      */     
/* 1072 */     i = 0;
/* 1073 */     brassSheet2x = (new ItemMetalSheet2x(5)).setMetal("Brass", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1074 */     goldSheet2x = (new ItemMetalSheet2x(8)).setMetal("Gold", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1075 */     leadSheet2x = (new ItemMetalSheet2x(10)).setMetal("Lead", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1076 */     nickelSheet2x = (new ItemMetalSheet2x(1)).setMetal("Nickel", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1077 */     pigIronSheet2x = (new ItemMetalSheet2x(12)).setMetal("Pig Iron", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1078 */     platinumSheet2x = (new ItemMetalSheet2x(13)).setMetal("Platinum", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1079 */     silverSheet2x = (new ItemMetalSheet2x(16)).setMetal("Silver", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/* 1080 */     sterlingSilverSheet2x = (new ItemMetalSheet2x(18)).setMetal("Sterling Silver", 200).func_77655_b(namesNSO[i++] + " Double Sheet");
/*      */     
/* 1082 */     i = 0;
/* 1083 */     bismuthBronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1084 */     blackBronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1085 */     blackSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Black Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1086 */     blueSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1087 */     bronzeUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Bronze", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1088 */     copperUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Copper", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1089 */     wroughtIronUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1090 */     redSteelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Red Steel", 3).func_77655_b(names[i] + " Unfinished Boots"); i++;
/* 1091 */     steelUnfinishedBoots = (new ItemUnfinishedArmor()).setMetal("Steel", 3).func_77655_b(names[i] + " Unfinished Boots");
/*      */     
/* 1093 */     i = 0;
/* 1094 */     bismuthBronzeBoots = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1095 */     blackBronzeBoots = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1096 */     blackSteelBoots = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1097 */     blueSteelBoots = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1098 */     bronzeBoots = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1099 */     copperBoots = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1100 */     wroughtIronBoots = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1101 */     redSteelBoots = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 3, 50, 0)).func_77655_b(names[i] + " Boots"); i++;
/* 1102 */     steelBoots = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 3, 50, 0)).func_77655_b(names[i] + " Boots");
/*      */     
/* 1104 */     i = 0;
/* 1105 */     bismuthBronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1106 */     blackBronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1107 */     blackSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Black Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1108 */     blueSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1109 */     bronzeUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Bronze", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1110 */     copperUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Copper", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1111 */     wroughtIronUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1112 */     redSteelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Red Steel", 2).func_77655_b(names[i] + " Unfinished Greaves"); i++;
/* 1113 */     steelUnfinishedGreaves = (new ItemUnfinishedArmor()).setMetal("Steel", 2).func_77655_b(names[i] + " Unfinished Greaves");
/*      */     
/* 1115 */     i = 0;
/* 1116 */     bismuthBronzeGreaves = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1117 */     blackBronzeGreaves = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1118 */     blackSteelGreaves = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1119 */     blueSteelGreaves = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1120 */     bronzeGreaves = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1121 */     copperGreaves = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1122 */     wroughtIronGreaves = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1123 */     redSteelGreaves = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves"); i++;
/* 1124 */     steelGreaves = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 2, 50, 1)).func_77655_b(names[i] + " Greaves");
/*      */     
/* 1126 */     i = 0;
/* 1127 */     bismuthBronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1128 */     blackBronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1129 */     blackSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Black Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1130 */     blueSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1131 */     bronzeUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Bronze", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1132 */     copperUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Copper", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1133 */     wroughtIronUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1134 */     redSteelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Red Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate"); i++;
/* 1135 */     steelUnfinishedChestplate = (new ItemUnfinishedArmor()).setMetal("Steel", 1).func_77655_b(names[i] + " Unfinished Chestplate");
/*      */     
/* 1137 */     i = 0;
/* 1138 */     bismuthBronzeChestplate = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1139 */     blackBronzeChestplate = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1140 */     blackSteelChestplate = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1141 */     blueSteelChestplate = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1142 */     bronzeChestplate = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1143 */     copperChestplate = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1144 */     wroughtIronChestplate = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1145 */     redSteelChestplate = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate"); i++;
/* 1146 */     steelChestplate = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 1, 50, 2)).func_77655_b(names[i] + " Chestplate");
/*      */     
/* 1148 */     i = 0;
/* 1149 */     bismuthBronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Bismuth Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1150 */     blackBronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Black Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1151 */     blackSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Black Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1152 */     blueSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Blue Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1153 */     bronzeUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Bronze", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1154 */     copperUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Copper", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1155 */     wroughtIronUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Wrought Iron", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1156 */     redSteelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Red Steel", 0).func_77655_b(names[i] + " Unfinished Helmet"); i++;
/* 1157 */     steelUnfinishedHelmet = (new ItemUnfinishedArmor()).setMetal("Steel", 0).func_77655_b(names[i] + " Unfinished Helmet");
/*      */     
/* 1159 */     i = 0;
/* 1160 */     bismuthBronzeHelmet = (new ItemTFCArmor(Armor.bismuthBronzePlate, proxy.getArmorRenderID("bismuthbronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1161 */     blackBronzeHelmet = (new ItemTFCArmor(Armor.blackBronzePlate, proxy.getArmorRenderID("blackbronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1162 */     blackSteelHelmet = (new ItemTFCArmor(Armor.blackSteelPlate, proxy.getArmorRenderID("blacksteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1163 */     blueSteelHelmet = (new ItemTFCArmor(Armor.blueSteelPlate, proxy.getArmorRenderID("bluesteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1164 */     bronzeHelmet = (new ItemTFCArmor(Armor.bronzePlate, proxy.getArmorRenderID("bronze"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1165 */     copperHelmet = (new ItemTFCArmor(Armor.copperPlate, proxy.getArmorRenderID("copper"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1166 */     wroughtIronHelmet = (new ItemTFCArmor(Armor.wroughtIronPlate, proxy.getArmorRenderID("wroughtiron"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1167 */     redSteelHelmet = (new ItemTFCArmor(Armor.redSteelPlate, proxy.getArmorRenderID("redsteel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet"); i++;
/* 1168 */     steelHelmet = (new ItemTFCArmor(Armor.steelPlate, proxy.getArmorRenderID("steel"), 0, 50, 3)).func_77655_b(names[i] + " Helmet");
/*      */     
/* 1170 */     leatherHelmet = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 0, ItemArmor.ArmorMaterial.CLOTH, 100, 3)).func_77655_b("helmetCloth").func_111206_d("leather_helmet");
/* 1171 */     leatherChestplate = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 1, ItemArmor.ArmorMaterial.CLOTH, 100, 2)).func_77655_b("chestplateCloth").func_111206_d("leather_chestplate");
/* 1172 */     leatherLeggings = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 2, ItemArmor.ArmorMaterial.CLOTH, 100, 1)).func_77655_b("leggingsCloth").func_111206_d("leather_leggings");
/* 1173 */     leatherBoots = (new ItemTFCArmor(Armor.leather, proxy.getArmorRenderID("leather"), 3, ItemArmor.ArmorMaterial.CLOTH, 100, 0)).func_77655_b("bootsCloth").func_111206_d("leather_boots");
/*      */     
/* 1175 */     quiver = (new ItemQuiver()).func_77655_b("Quiver");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registerFurnaceFuel() {
/* 1181 */     TFCFuelHandler.registerFuel(blueSteelBucketLava, 20000);
/* 1182 */     TFCFuelHandler.registerFuel(singlePlank, 400);
/* 1183 */     TFCFuelHandler.registerFuel(woodenBucketEmpty, 300);
/* 1184 */     TFCFuelHandler.registerFuel(fireStarter, 100);
/* 1185 */     TFCFuelHandler.registerFuel(logs, 800);
/* 1186 */     TFCFuelHandler.registerFuel(sluiceItem, 300);
/* 1187 */     TFCFuelHandler.registerFuel(rope, 50);
/* 1188 */     TFCFuelHandler.registerFuel(arrow, 20);
/* 1189 */     TFCFuelHandler.registerFuel(bow, 100);
/* 1190 */     TFCFuelHandler.registerFuel(fishingRod, 100);
/* 1191 */     TFCFuelHandler.registerFuel(stick, 100);
/* 1192 */     TFCFuelHandler.registerFuel(coal, 1600);
/* 1193 */     TFCFuelHandler.registerFuel(woolCloth, 20);
/* 1194 */     TFCFuelHandler.registerFuel(silkCloth, 20);
/* 1195 */     TFCFuelHandler.registerFuel(burlapCloth, 20);
/* 1196 */     TFCFuelHandler.registerFuel(straw, 20);
/*      */     
/* 1198 */     for (int l = 0; l < Recipes.doors.length; l++) {
/* 1199 */       TFCFuelHandler.registerFuel(Recipes.doors[l], 300);
/*      */     }
/* 1201 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportV), 300);
/* 1202 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportV2), 300);
/* 1203 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportH), 300);
/* 1204 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.woodSupportH2), 300);
/* 1205 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fence), 300);
/* 1206 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fence2), 300);
/* 1207 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fenceGate), 300);
/* 1208 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.fenceGate2), 300);
/* 1209 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.chest), 300);
/* 1210 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.strawHideBed), 200);
/* 1211 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.thatch), 200);
/* 1212 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.planks), 300);
/* 1213 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.planks2), 300);
/* 1214 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.barrel), 300);
/* 1215 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.torch), 100);
/* 1216 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.sapling), 100);
/* 1217 */     TFCFuelHandler.registerFuel(Item.func_150898_a(TFCBlocks.sapling2), 100);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ItemSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */