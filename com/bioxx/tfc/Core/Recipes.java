/*      */ package com.bioxx.tfc.Core;
/*      */ 
/*      */ import com.bioxx.tfc.Core.Config.TFC_ConfigFiles;
/*      */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*      */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*      */ import com.bioxx.tfc.TileEntities.TELoom;
/*      */ import com.bioxx.tfc.api.Constant.Global;
/*      */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*      */ import com.bioxx.tfc.api.Crafting.AnvilRecipe;
/*      */ import com.bioxx.tfc.api.Crafting.AnvilReq;
/*      */ import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
/*      */ import com.bioxx.tfc.api.Crafting.KilnCraftingManager;
/*      */ import com.bioxx.tfc.api.Crafting.KilnRecipe;
/*      */ import com.bioxx.tfc.api.Crafting.PlanRecipe;
/*      */ import com.bioxx.tfc.api.Crafting.QuernManager;
/*      */ import com.bioxx.tfc.api.Crafting.QuernRecipe;
/*      */ import com.bioxx.tfc.api.Enums.RuleEnum;
/*      */ import com.bioxx.tfc.api.TFCBlocks;
/*      */ import com.bioxx.tfc.api.TFCItems;
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemBow;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.item.crafting.CraftingManager;
/*      */ import net.minecraft.item.crafting.IRecipe;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.oredict.ShapedOreRecipe;
/*      */ import net.minecraftforge.oredict.ShapelessOreRecipe;
/*      */ 
/*      */ public class Recipes {
/*      */   public static Item[] axes;
/*      */   public static Item[] chisels;
/*      */   public static Item[] saws;
/*      */   public static Item[] scythes;
/*      */   public static Item[] knives;
/*      */   public static Item[] meltedMetal;
/*      */   public static Item[] hammers;
/*      */   public static Item[] picks;
/*      */   public static Item[] proPicks;
/*      */   public static Item[] shovels;
/*      */   public static Item[] hoes;
/*      */   public static Item[] swords;
/*      */   public static Item[] maces;
/*      */   public static Item[] javelins;
/*      */   public static Item[] spindle;
/*      */   public static Item[] gems;
/*      */   public static Item[] seeds;
/*      */   public static Item[] doors;
/*      */   public static final int WILD = 32767;
/*      */   
/*      */   public static void registerRecipes() {
/*   57 */     TEBarrel.registerRecipes();
/*   58 */     TELoom.registerRecipes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   67 */     vanillaRecipes();
/*      */ 
/*      */     
/*   70 */     for (int m = 0; m < Global.WOOD_ALL.length - 2; m++) {
/*      */       
/*   72 */       GameRegistry.addRecipe(new ItemStack(doors[m]), new Object[] { "WW", "WW", "WW", Character.valueOf('W'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*   73 */       GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.chest, 1, m), new Object[] { "###", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) }));
/*   74 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.toolRack, 1, m), new Object[] { "###", "   ", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */       
/*   76 */       int l = m % 16;
/*   77 */       if (m == l) {
/*      */         
/*   79 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, m), new Object[] { new ItemStack(TFCItems.logs, 1, m), "itemSaw" }));
/*   80 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 4, m), new Object[] { new ItemStack(TFCBlocks.planks, 1, m), "itemSaw" }));
/*   81 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.woodSupportV, 8, m), new Object[] { "A2", " 2", Character.valueOf('2'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('A'), "itemSaw" }));
/*      */         
/*   83 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.planks, 1, m), new Object[] { "11", "11", Character.valueOf('1'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*   85 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.barrel, 1, m), new Object[] { "# #", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*   87 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fence, 6, m), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('P'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*   88 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fenceGate, 2, m), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('P'), new ItemStack(TFCBlocks.planks, 1, m) });
/*   89 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.armorStand, 1, m), new Object[] { "###", " # ", "%%%", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('%'), new ItemStack(TFCBlocks.planks, 1, m) });
/*      */         
/*   91 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.loom, 1, m), new Object[] { "LLL", "LSL", "L L", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('S'), "stickWood" }));
/*      */       }
/*   93 */       else if (m / 16 == 1) {
/*      */         
/*   95 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, m), new Object[] { new ItemStack(TFCItems.logs, 1, m), "itemSaw" }));
/*   96 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 4, m), new Object[] { new ItemStack(TFCBlocks.planks2, 1, l), "itemSaw" }));
/*   97 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.woodSupportV2, 8, l), new Object[] { "A2", " 2", Character.valueOf('2'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('A'), "itemSaw" }));
/*      */         
/*   99 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.planks2, 1, l), new Object[] { "11", "11", Character.valueOf('1'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*  101 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fence2, 6, l), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('P'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*  102 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fenceGate2, 2, l), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('P'), new ItemStack(TFCBlocks.planks2, 1, l) });
/*      */         
/*  104 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.armorStand2, 1, l), new Object[] { "###", " # ", "%%%", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('%'), new ItemStack(TFCBlocks.planks2, 1, l) });
/*      */         
/*  106 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.barrel, 1, m), new Object[] { "# #", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*  107 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.loom, 1, m), new Object[] { "LLL", "LSL", "L L", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('S'), "stickWood" }));
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  112 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sluiceItem, 1), new Object[] { "  1", " 12", "122", Character.valueOf('1'), "stickWood", Character.valueOf('2'), "woodLumber" }));
/*  113 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.nestBox, 1), new Object[] { "S S", "PSP", "PPP", Character.valueOf('S'), new ItemStack(TFCItems.straw, 1), Character.valueOf('P'), "woodLumber" }));
/*  114 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.woodenBucketEmpty, 1), new Object[] { "w w", "w w", " w ", Character.valueOf('w'), "woodLumber" }));
/*  115 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150415_aT, 1, 0), new Object[] { "###", "###", Character.valueOf('#'), "woodLumber" }));
/*  116 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151155_ap, 1, 0), new Object[] { "###", "###", " 1 ", Character.valueOf('#'), "woodLumber", Character.valueOf('1'), "stickWood" }));
/*  117 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.buttonWood, 1), new Object[] { "#", Character.valueOf('#'), "plankWood" }));
/*  118 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151104_aV, 1), new Object[] { "PPP", "QQQ", Character.valueOf('P'), "materialCloth", Character.valueOf('Q'), "woodLumber" }));
/*  119 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.workbench, 1), new Object[] { "PP", "PP", Character.valueOf('P'), "plankWood" }));
/*  120 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.bellows, 1, 0), new Object[] { "###", "???", "###", Character.valueOf('#'), "woodLumber", Character.valueOf('?'), "materialLeather" }));
/*      */ 
/*      */     
/*  123 */     for (int k = 0; k < 3; k++) {
/*      */       
/*  125 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.wool, 1 + k, 0), new Object[] { new ItemStack(TFCItems.sheepSkin, 1, k), "itemKnife" }));
/*      */     } 
/*      */ 
/*      */     
/*  129 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 4), new Object[] { new ItemStack(TFCItems.powder, 1, 6) });
/*  130 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 2), new Object[] { new ItemStack(TFCItems.powder, 1, 8) });
/*  131 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 1), new Object[] { new ItemStack(TFCItems.powder, 1, 5) });
/*  132 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 11), new Object[] { new ItemStack(TFCItems.powder, 1, 7) });
/*  133 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.dye, 1, 12), new Object[] { new ItemStack(TFCItems.powder, 1, 8), new ItemStack(TFCItems.powder, 1, 0), "blockSand" }));
/*      */     
/*      */     int i;
/*  136 */     for (i = 0; i < Global.STONE_FLUXINDEX.length; i++) {
/*  137 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.powder, 2, 0), new Object[] { new ItemStack(TFCItems.looseRock, 1, Global.STONE_FLUXINDEX[i]), "itemHammer" }));
/*  138 */     }  GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.powder, 6, 0), new Object[] { new ItemStack(TFCItems.oreChunk, 1, 32), "itemHammer" }));
/*      */ 
/*      */     
/*  141 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 1), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleCopper" }));
/*  142 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 2), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBronze" }));
/*  143 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 3), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleWroughtIron" }));
/*  144 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 4), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleSteel" }));
/*  145 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 5), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlackSteel" }));
/*  146 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 6), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlueSteel" }));
/*  147 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 7), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleRedSteel" }));
/*  148 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 0), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleRoseGold" }));
/*  149 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 1), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBismuthBronze" }));
/*  150 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 2), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlackBronze" }));
/*      */     
/*  152 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.bloomery, 1), new Object[] { "PPP", "P P", "PPP", Character.valueOf('P'), "plateDoubleAnyBronze" }));
/*  153 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.blastFurnace, 1), new Object[] { "PPP", "PCP", "PPP", Character.valueOf('P'), "plateDoubleWroughtIron", Character.valueOf('C'), new ItemStack(TFCBlocks.crucible, 1) }));
/*      */     
/*  155 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.spawnMeter, 1), new Object[] { "PPP", "GKG", "PPP", Character.valueOf('P'), "stoneSmooth", Character.valueOf('K'), "gemChipped", Character.valueOf('G'), new ItemStack(Blocks.field_150359_w, 1) }));
/*      */     
/*  157 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.quern, 1), new Object[] { "PPP", Character.valueOf('P'), "stoneSmooth" }));
/*  158 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.quern, 1), new Object[] { "  W", "PPP", Character.valueOf('P'), "stone", Character.valueOf('W'), "stickWood" }));
/*      */ 
/*      */     
/*  161 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.clayBall, 1, 1), new Object[] { "PXP", "XCX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.powder, 1, 1), Character.valueOf('X'), new ItemStack(TFCItems.powder, 1, 2), Character.valueOf('C'), "lumpClay" }));
/*  162 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.clayBall, 1, 1), new Object[] { "PXP", "XCX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.powder, 1, 2), Character.valueOf('X'), new ItemStack(TFCItems.powder, 1, 1), Character.valueOf('C'), "lumpClay" }));
/*      */     
/*  164 */     GameRegistry.addRecipe(new ItemStack(TFCItems.fireBrick, 2, 0), new Object[] { "PP", "PP", Character.valueOf('P'), new ItemStack(TFCItems.clayBall, 1, 1) });
/*      */     
/*  166 */     GameRegistry.addRecipe(new ItemStack(TFCBlocks.fireBrick, 2, 0), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.fireBrick, 1, 1), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*      */ 
/*      */     
/*  169 */     GameRegistry.addRecipe(new ItemStack(TFCBlocks.thatch, 1), new Object[] { "PP", "PP", Character.valueOf('P'), new ItemStack(TFCItems.straw, 1) });
/*  170 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.straw, 4), new Object[] { new ItemStack(TFCBlocks.thatch, 1) });
/*      */ 
/*      */     
/*  173 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.coal, 9), new Object[] { new ItemStack(Blocks.field_150402_ci) });
/*  174 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150402_ci, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), "gemCoal" }));
/*      */ 
/*      */     
/*  177 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.arrow, 8), new Object[] { "itemRock", "stickWood", new ItemStack(Items.field_151008_G) }));
/*      */     
/*  179 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Items.field_151016_H, 2, 0), new Object[] { "gemCharcoal", "dustSulfur", "dustSaltpeter" }));
/*      */     
/*  181 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151160_bD, 1), new Object[] { "###", "#$#", "###", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialLeather" }));
/*  182 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151159_an, 1), new Object[] { "###", "#$#", "###", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialCloth" }));
/*      */     
/*  184 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150404_cg, 2, 0), new Object[] { "$$", Character.valueOf('$'), "materialCloth" }));
/*      */     
/*  186 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCBlocks.litPumpkin, 1), new Object[] { "blockTorch", "blockPumpkin" }));
/*      */     
/*  188 */     GameRegistry.addRecipe(new ItemStack(TFCItems.glassBottle, 3), new Object[] { "# #", " # ", Character.valueOf('#'), new ItemStack(Blocks.field_150359_w) });
/*      */     
/*  190 */     for (i = 0; i < Global.DYE_NAMES.length; i++) {
/*      */       
/*  192 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Blocks.field_150404_cg, 1, i), new Object[] { Global.DYE_NAMES[i], new ItemStack(Blocks.field_150404_cg, 1, 32767) }));
/*  193 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), new Object[] { new ItemStack(TFCItems.potterySmallVessel, 1, 0), Global.DYE_NAMES[i] }));
/*      */     } 
/*      */     
/*  196 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150448_aq, 64), new Object[] { "PsP", "PsP", Character.valueOf('P'), "ingotIron", Character.valueOf('s'), "stickWood" }));
/*  197 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150318_D, 64), new Object[] { " r ", "PsP", "PsP", Character.valueOf('P'), "ingotGold", Character.valueOf('s'), "stickWood", Character.valueOf('r'), Items.field_151137_ax }));
/*  198 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151143_au, 1), new Object[] { "P P", "PPP", Character.valueOf('P'), "plateWroughtIron" }));
/*      */ 
/*      */     
/*  201 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150442_at, 1), new Object[] { "P", "H", Character.valueOf('P'), "stickWood", Character.valueOf('H'), "itemRock" }));
/*      */     
/*  203 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151121_aF, 3), new Object[] { "###", Character.valueOf('#'), "itemReed" }));
/*  204 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Items.field_151122_aG, 1), new Object[] { new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), "materialLeather" }));
/*      */ 
/*      */     
/*  207 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.woolYarn, 8), new Object[] { "materialWool", new ItemStack(TFCItems.spindle, 1, 32767) }));
/*      */ 
/*      */     
/*  210 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.ink, 16, 0), new Object[] { "2", Character.valueOf('2'), "dyeBlack" }));
/*  211 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueprint, 1), new Object[] { new ItemStack(TFCItems.ink), new ItemStack(Items.field_151121_aF, 1) });
/*  212 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.nametag, 1), new Object[] { new ItemStack(TFCItems.ink), new ItemStack(Items.field_151121_aF, 1), "materialString" }));
/*      */     
/*      */     int j;
/*  215 */     for (j = 0; j < Global.STONE_IGIN.length; j++) {
/*      */ 
/*      */       
/*  218 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgInBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + 0), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  219 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + 0), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + 0), "itemChisel" }));
/*      */ 
/*      */       
/*  222 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgInCobble, 1, j), new Object[] { "PP", "PP", 
/*  223 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + 0) });
/*  224 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + 0), new Object[] { new ItemStack(TFCBlocks.stoneIgInCobble, 1, j) });
/*      */ 
/*      */       
/*  227 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleIgIn, 4, j), new Object[] { "RRR", "RRR", 
/*  228 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + 0) });
/*  229 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawIgIn, 3, j), new Object[] { "RRR", "RRR", 
/*  230 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgIn, 1, j) });
/*  231 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickIgIn, 3, j), new Object[] { "BMB", "MBM", 
/*  232 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + 0), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  233 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothIgIn, 3, j), new Object[] { "RRR", "RRR", 
/*  234 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgInSmooth, 1, j) });
/*      */     } 
/*      */     
/*  237 */     for (j = 0; j < Global.STONE_SED.length; j++) {
/*      */ 
/*      */       
/*  240 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneSedBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  241 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START), "itemChisel" }));
/*      */ 
/*      */       
/*  244 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneSedCobble, 1, j), new Object[] { "PP", "PP", 
/*  245 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START) });
/*  246 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_SED_START), new Object[] { new ItemStack(TFCBlocks.stoneSedCobble, 1, j) });
/*      */ 
/*      */       
/*  249 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleSed, 4, j), new Object[] { "RRR", "RRR", 
/*  250 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START) });
/*  251 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawSed, 3, j), new Object[] { "RRR", "RRR", 
/*  252 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneSed, 1, j) });
/*  253 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickSed, 3, j), new Object[] { "BMB", "MBM", 
/*  254 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  255 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothSed, 3, j), new Object[] { "RRR", "RRR", 
/*  256 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneSedSmooth, 1, j) });
/*      */     } 
/*      */     
/*  259 */     for (j = 0; j < Global.STONE_IGEX.length; j++) {
/*      */ 
/*      */       
/*  262 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgExBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  263 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START), "itemChisel" }));
/*      */ 
/*      */       
/*  266 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgExCobble, 1, j), new Object[] { "PP", "PP", 
/*  267 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START) });
/*  268 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_IGEX_START), new Object[] { new ItemStack(TFCBlocks.stoneIgExCobble, 1, j) });
/*      */ 
/*      */       
/*  271 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleIgEx, 4, j), new Object[] { "RRR", "RRR", 
/*  272 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START) });
/*  273 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawIgEx, 3, j), new Object[] { "RRR", "RRR", 
/*  274 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgEx, 1, j) });
/*  275 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickIgEx, 3, j), new Object[] { "BMB", "MBM", 
/*  276 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  277 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothIgEx, 3, j), new Object[] { "RRR", "RRR", 
/*  278 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgExSmooth, 1, j) });
/*      */     } 
/*      */     
/*  281 */     for (j = 0; j < Global.STONE_MM.length; j++) {
/*      */       
/*  283 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneMMBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  284 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START), "itemChisel" }));
/*      */ 
/*      */       
/*  287 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneMMCobble, 1, j), new Object[] { "PP", "PP", 
/*  288 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START) });
/*  289 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_MM_START), new Object[] { new ItemStack(TFCBlocks.stoneMMCobble, 1, j) });
/*      */ 
/*      */       
/*  292 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleMM, 4, j), new Object[] { "RRR", "RRR", 
/*  293 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START) });
/*  294 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawMM, 3, j), new Object[] { "RRR", "RRR", 
/*  295 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneMM, 1, j) });
/*  296 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickMM, 3, j), new Object[] { "BMB", "MBM", 
/*  297 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  298 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothMM, 3, j), new Object[] { "RRR", "RRR", 
/*  299 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneMMSmooth, 1, j) });
/*      */     } 
/*      */ 
/*      */     
/*  303 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthUnshaped, 1, 0), new Object[] {
/*  304 */           getStackNoTemp(new ItemStack(TFCItems.bismuthIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  305 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 0), new Object[] {
/*  306 */           getStackNoTemp(new ItemStack(TFCItems.bismuthBronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  307 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 0), new Object[] {
/*  308 */           getStackNoTemp(new ItemStack(TFCItems.blackBronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  309 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackSteelUnshaped, 1, 0), new Object[] {
/*  310 */           getStackNoTemp(new ItemStack(TFCItems.blackSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  311 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueSteelUnshaped, 1, 0), new Object[] {
/*  312 */           getStackNoTemp(new ItemStack(TFCItems.blueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  313 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.brassUnshaped, 1, 0), new Object[] {
/*  314 */           getStackNoTemp(new ItemStack(TFCItems.brassIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  315 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeUnshaped, 1, 0), new Object[] {
/*  316 */           getStackNoTemp(new ItemStack(TFCItems.bronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  317 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperUnshaped, 1, 0), new Object[] {
/*  318 */           getStackNoTemp(new ItemStack(TFCItems.copperIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  319 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.goldUnshaped, 1, 0), new Object[] {
/*  320 */           getStackNoTemp(new ItemStack(TFCItems.goldIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  321 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelUnshaped, 1, 0), new Object[] {
/*  322 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  323 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1, 0), new Object[] {
/*  324 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  325 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1, 0), new Object[] {
/*  326 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  327 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1, 0), new Object[] {
/*  328 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonRedSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  329 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.wroughtIronUnshaped, 1, 0), new Object[] {
/*  330 */           getStackNoTemp(new ItemStack(TFCItems.wroughtIronIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  331 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.leadUnshaped, 1, 0), new Object[] {
/*  332 */           getStackNoTemp(new ItemStack(TFCItems.leadIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  333 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.nickelUnshaped, 1, 0), new Object[] {
/*  334 */           getStackNoTemp(new ItemStack(TFCItems.nickelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  335 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.pigIronUnshaped, 1, 0), new Object[] {
/*  336 */           getStackNoTemp(new ItemStack(TFCItems.pigIronIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  337 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.platinumUnshaped, 1, 0), new Object[] {
/*  338 */           getStackNoTemp(new ItemStack(TFCItems.platinumIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  339 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.redSteelUnshaped, 1, 0), new Object[] {
/*  340 */           getStackNoTemp(new ItemStack(TFCItems.redSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  341 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.roseGoldUnshaped, 1, 0), new Object[] {
/*  342 */           getStackNoTemp(new ItemStack(TFCItems.roseGoldIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  343 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.silverUnshaped, 1, 0), new Object[] {
/*  344 */           getStackNoTemp(new ItemStack(TFCItems.silverIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  345 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.steelUnshaped, 1, 0), new Object[] {
/*  346 */           getStackNoTemp(new ItemStack(TFCItems.steelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  347 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverUnshaped, 1, 0), new Object[] {
/*  348 */           getStackNoTemp(new ItemStack(TFCItems.sterlingSilverIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  349 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.tinUnshaped, 1, 0), new Object[] {
/*  350 */           getStackNoTemp(new ItemStack(TFCItems.tinIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  351 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.zincUnshaped, 1, 0), new Object[] {
/*  352 */           getStackNoTemp(new ItemStack(TFCItems.zincIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  353 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakSteelUnshaped, 1, 0), new Object[] {
/*  354 */           getStackNoTemp(new ItemStack(TFCItems.weakSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  355 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelUnshaped, 1, 0), new Object[] {
/*  356 */           getStackNoTemp(new ItemStack(TFCItems.weakBlueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  357 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelUnshaped, 1, 0), new Object[] {
/*  358 */           getStackNoTemp(new ItemStack(TFCItems.weakRedSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  359 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.unknownUnshaped, 1, 0), new Object[] {
/*  360 */           getStackNoTemp(new ItemStack(TFCItems.unknownIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1)
/*      */         });
/*      */     
/*  363 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthIngot, 1, 0), new Object[] {
/*  364 */           getStackNoTemp(new ItemStack(TFCItems.bismuthUnshaped, 1)) });
/*  365 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeIngot, 1, 0), new Object[] {
/*  366 */           getStackNoTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1)) });
/*  367 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeIngot, 1, 0), new Object[] {
/*  368 */           getStackNoTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1)) });
/*  369 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackSteelIngot, 1, 0), new Object[] {
/*  370 */           getStackNoTemp(new ItemStack(TFCItems.blackSteelUnshaped, 1)) });
/*  371 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueSteelIngot, 1, 0), new Object[] {
/*  372 */           getStackNoTemp(new ItemStack(TFCItems.blueSteelUnshaped, 1)) });
/*  373 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.brassIngot, 1, 0), new Object[] {
/*  374 */           getStackNoTemp(new ItemStack(TFCItems.brassUnshaped, 1)) });
/*  375 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeIngot, 1, 0), new Object[] {
/*  376 */           getStackNoTemp(new ItemStack(TFCItems.bronzeUnshaped, 1)) });
/*  377 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperIngot, 1, 0), new Object[] {
/*  378 */           getStackNoTemp(new ItemStack(TFCItems.copperUnshaped, 1)) });
/*  379 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.goldIngot, 1, 0), new Object[] {
/*  380 */           getStackNoTemp(new ItemStack(TFCItems.goldUnshaped, 1)) });
/*  381 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelIngot, 1, 0), new Object[] {
/*  382 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonSteelUnshaped, 1)) });
/*  383 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1, 0), new Object[] {
/*  384 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1)) });
/*  385 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1, 0), new Object[] {
/*  386 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1)) });
/*  387 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonRedSteelIngot, 1, 0), new Object[] {
/*  388 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1)) });
/*  389 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.wroughtIronIngot, 1, 0), new Object[] {
/*  390 */           getStackNoTemp(new ItemStack(TFCItems.wroughtIronUnshaped, 1)) });
/*  391 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.leadIngot, 1, 0), new Object[] {
/*  392 */           getStackNoTemp(new ItemStack(TFCItems.leadUnshaped, 1)) });
/*  393 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.nickelIngot, 1, 0), new Object[] {
/*  394 */           getStackNoTemp(new ItemStack(TFCItems.nickelUnshaped, 1)) });
/*  395 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.pigIronIngot, 1, 0), new Object[] {
/*  396 */           getStackNoTemp(new ItemStack(TFCItems.pigIronUnshaped, 1)) });
/*  397 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.platinumIngot, 1, 0), new Object[] {
/*  398 */           getStackNoTemp(new ItemStack(TFCItems.platinumUnshaped, 1)) });
/*  399 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.redSteelIngot, 1, 0), new Object[] {
/*  400 */           getStackNoTemp(new ItemStack(TFCItems.redSteelUnshaped, 1)) });
/*  401 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.roseGoldIngot, 1, 0), new Object[] {
/*  402 */           getStackNoTemp(new ItemStack(TFCItems.roseGoldUnshaped, 1)) });
/*  403 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.silverIngot, 1, 0), new Object[] {
/*  404 */           getStackNoTemp(new ItemStack(TFCItems.silverUnshaped, 1)) });
/*  405 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.steelIngot, 1, 0), new Object[] {
/*  406 */           getStackNoTemp(new ItemStack(TFCItems.steelUnshaped, 1)) });
/*  407 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverIngot, 1, 0), new Object[] {
/*  408 */           getStackNoTemp(new ItemStack(TFCItems.sterlingSilverUnshaped, 1)) });
/*  409 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.tinIngot, 1, 0), new Object[] {
/*  410 */           getStackNoTemp(new ItemStack(TFCItems.tinUnshaped, 1)) });
/*  411 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.zincIngot, 1, 0), new Object[] {
/*  412 */           getStackNoTemp(new ItemStack(TFCItems.zincUnshaped, 1)) });
/*  413 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakSteelIngot, 1, 0), new Object[] {
/*  414 */           getStackNoTemp(new ItemStack(TFCItems.weakSteelUnshaped, 1)) });
/*  415 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelIngot, 1, 0), new Object[] {
/*  416 */           getStackNoTemp(new ItemStack(TFCItems.weakBlueSteelUnshaped, 1)) });
/*  417 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelIngot, 1, 0), new Object[] {
/*  418 */           getStackNoTemp(new ItemStack(TFCItems.weakRedSteelUnshaped, 1)) });
/*  419 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.unknownIngot, 1, 0), new Object[] {
/*  420 */           getStackNoTemp(new ItemStack(TFCItems.unknownUnshaped, 1))
/*      */         });
/*  422 */     registerToolRecipes();
/*  423 */     registerFoodRecipes();
/*  424 */     registerKilnRecipes();
/*  425 */     registerToolMolds();
/*  426 */     registerQuernRecipes();
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
/*      */   private static void vanillaRecipes() {
/*  441 */     removeRecipe(new ItemStack(Blocks.field_150462_ai));
/*      */     
/*  443 */     removeRecipe(new ItemStack((Item)Items.field_151112_aM));
/*  444 */     removeRecipe(new ItemStack(Blocks.field_150471_bO));
/*  445 */     removeRecipe(new ItemStack(Items.field_151033_d));
/*  446 */     removeRecipe(new ItemStack(Items.field_151044_h, 9));
/*  447 */     removeRecipe(new ItemStack(Items.field_151102_aT));
/*  448 */     removeRecipe(new ItemStack(Items.field_151069_bo, 3));
/*  449 */     removeRecipe(new ItemStack(Items.field_151121_aF, 3));
/*      */ 
/*      */     
/*  452 */     removeRecipe(ItemBow.class);
/*      */ 
/*      */     
/*  455 */     TFC_ConfigFiles.firstLoadCrafting();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerToolRecipes() {
/*  461 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.flintSteel, 1), new Object[] { Items.field_151145_ak, "ingotIron" }));
/*  462 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.flintSteel, 1), new Object[] { Items.field_151145_ak, "ingotSteel" }));
/*      */     
/*  464 */     GameRegistry.addRecipe(new ItemStack(TFCItems.rope, 1), new Object[] { "RR ", "RR ", "  R", Character.valueOf('R'), new ItemStack(TFCItems.juteFiber, 1) });
/*      */     
/*  466 */     GameRegistry.addRecipe(new ItemStack(TFCItems.goldPan, 1, 0), new Object[] { "1", Character.valueOf('1'), new ItemStack(TFCItems.potteryBowl, 1, 1) });
/*      */     
/*  468 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.fireStarter, 1, 0), new Object[] { "2 ", " 2", Character.valueOf('2'), "stickWood" }));
/*      */     
/*  470 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bow, 1), new Object[] { " #$", "# $", " #$", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialString" }));
/*      */     
/*  472 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.fishingRod, 1), new Object[] { "  #", " #$", "# $", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialString" }));
/*      */     
/*  474 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.spindle, 1), new Object[] { "P", "#", Character.valueOf('P'), new ItemStack(TFCItems.spindleHead, 1, 1), Character.valueOf('#'), "stickWood" }));
/*      */     
/*  476 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.spindleHead, 1, 0), new Object[] { "P", "#", Character.valueOf('P'), "lumpClay", Character.valueOf('#'), "stickWood" }));
/*      */ 
/*      */     
/*  479 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  480 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  481 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  482 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*      */ 
/*      */     
/*  485 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  486 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  487 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  488 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*      */     
/*  490 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  491 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  492 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  493 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*      */     
/*  495 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  496 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  497 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  498 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*      */ 
/*      */     
/*  501 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  502 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  503 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  504 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  506 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  507 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  508 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  509 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  511 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  512 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  513 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  514 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  516 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  517 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  518 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  519 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */ 
/*      */     
/*  522 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneHammer, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneHammerHead, Character.valueOf('2'), "stickWood" }));
/*  523 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneHammer, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneHammerHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) }));
/*      */     
/*  525 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneKnife, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneKnifeHead, Character.valueOf('2'), "stickWood" }));
/*  526 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneKnife, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneKnifeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) }));
/*      */ 
/*      */     
/*  529 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzePickaxeHead, 1, 0), 
/*  530 */             Character.valueOf('I'), "stickWood" }));
/*  531 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzePickaxeHead, 1, 0), 
/*  532 */             Character.valueOf('I'), "stickWood" }));
/*  533 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelPickaxeHead, 1, 0), 
/*  534 */             Character.valueOf('I'), "stickWood" }));
/*  535 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelPickaxeHead, 1, 0), 
/*  536 */             Character.valueOf('I'), "stickWood" }));
/*  537 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzePickaxeHead, 1, 0), 
/*  538 */             Character.valueOf('I'), "stickWood" }));
/*  539 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperPickaxeHead, 1, 0), 
/*  540 */             Character.valueOf('I'), "stickWood" }));
/*  541 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronPickaxeHead, 1, 0), 
/*  542 */             Character.valueOf('I'), "stickWood" }));
/*  543 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelPickaxeHead, 1, 0), 
/*  544 */             Character.valueOf('I'), "stickWood" }));
/*  545 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelPickaxeHead, 1, 0), 
/*  546 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  549 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeShovelHead, 1, 0), 
/*  550 */             Character.valueOf('I'), "stickWood" }));
/*  551 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeShovelHead, 1, 0), 
/*  552 */             Character.valueOf('I'), "stickWood" }));
/*  553 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelShovelHead, 1, 0), 
/*  554 */             Character.valueOf('I'), "stickWood" }));
/*  555 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelShovelHead, 1, 0), 
/*  556 */             Character.valueOf('I'), "stickWood" }));
/*  557 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeShovelHead, 1, 0), 
/*  558 */             Character.valueOf('I'), "stickWood" }));
/*  559 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperShovelHead, 1, 0), 
/*  560 */             Character.valueOf('I'), "stickWood" }));
/*  561 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronShovelHead, 1, 0), 
/*  562 */             Character.valueOf('I'), "stickWood" }));
/*  563 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelShovelHead, 1, 0), 
/*  564 */             Character.valueOf('I'), "stickWood" }));
/*  565 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelShovelHead, 1, 0), 
/*  566 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  569 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeHoeHead, 1, 0), 
/*  570 */             Character.valueOf('I'), "stickWood" }));
/*  571 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeHoeHead, 1, 0), 
/*  572 */             Character.valueOf('I'), "stickWood" }));
/*  573 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelHoeHead, 1, 0), 
/*  574 */             Character.valueOf('I'), "stickWood" }));
/*  575 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelHoeHead, 1, 0), 
/*  576 */             Character.valueOf('I'), "stickWood" }));
/*  577 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeHoeHead, 1, 0), 
/*  578 */             Character.valueOf('I'), "stickWood" }));
/*  579 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperHoeHead, 1, 0), 
/*  580 */             Character.valueOf('I'), "stickWood" }));
/*  581 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronHoeHead, 1, 0), 
/*  582 */             Character.valueOf('I'), "stickWood" }));
/*  583 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelHoeHead, 1, 0), 
/*  584 */             Character.valueOf('I'), "stickWood" }));
/*  585 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelHoeHead, 1, 0), 
/*  586 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  589 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeAxeHead, 1, 0), 
/*  590 */             Character.valueOf('I'), "stickWood" }));
/*  591 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeAxeHead, 1, 0), 
/*  592 */             Character.valueOf('I'), "stickWood" }));
/*  593 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelAxeHead, 1, 0), 
/*  594 */             Character.valueOf('I'), "stickWood" }));
/*  595 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelAxeHead, 1, 0), 
/*  596 */             Character.valueOf('I'), "stickWood" }));
/*  597 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeAxeHead, 1, 0), 
/*  598 */             Character.valueOf('I'), "stickWood" }));
/*  599 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperAxeHead, 1, 0), 
/*  600 */             Character.valueOf('I'), "stickWood" }));
/*  601 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronAxeHead, 1, 0), 
/*  602 */             Character.valueOf('I'), "stickWood" }));
/*  603 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelAxeHead, 1, 0), 
/*  604 */             Character.valueOf('I'), "stickWood" }));
/*  605 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelAxeHead, 1, 0), 
/*  606 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  609 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeSwordHead, 1, 0), 
/*  610 */             Character.valueOf('I'), "stickWood" }));
/*  611 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeSwordHead, 1, 0), 
/*  612 */             Character.valueOf('I'), "stickWood" }));
/*  613 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelSwordHead, 1, 0), 
/*  614 */             Character.valueOf('I'), "stickWood" }));
/*  615 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelSwordHead, 1, 0), 
/*  616 */             Character.valueOf('I'), "stickWood" }));
/*  617 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeSwordHead, 1, 0), 
/*  618 */             Character.valueOf('I'), "stickWood" }));
/*  619 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperSwordHead, 1, 0), 
/*  620 */             Character.valueOf('I'), "stickWood" }));
/*  621 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronSwordHead, 1, 0), 
/*  622 */             Character.valueOf('I'), "stickWood" }));
/*  623 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelSwordHead, 1, 0), 
/*  624 */             Character.valueOf('I'), "stickWood" }));
/*  625 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelSwordHead, 1, 0), 
/*  626 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  629 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeMaceHead, 1, 0), 
/*  630 */             Character.valueOf('I'), "stickWood" }));
/*  631 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeMaceHead, 1, 0), 
/*  632 */             Character.valueOf('I'), "stickWood" }));
/*  633 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelMaceHead, 1, 0), 
/*  634 */             Character.valueOf('I'), "stickWood" }));
/*  635 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelMaceHead, 1, 0), 
/*  636 */             Character.valueOf('I'), "stickWood" }));
/*  637 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeMaceHead, 1, 0), 
/*  638 */             Character.valueOf('I'), "stickWood" }));
/*  639 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperMaceHead, 1, 0), 
/*  640 */             Character.valueOf('I'), "stickWood" }));
/*  641 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronMaceHead, 1, 0), 
/*  642 */             Character.valueOf('I'), "stickWood" }));
/*  643 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelMaceHead, 1, 0), 
/*  644 */             Character.valueOf('I'), "stickWood" }));
/*  645 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelMaceHead, 1, 0), 
/*  646 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  649 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeHammerHead, 1, 0), 
/*  650 */             Character.valueOf('I'), "stickWood" }));
/*  651 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeHammerHead, 1, 0), 
/*  652 */             Character.valueOf('I'), "stickWood" }));
/*  653 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelHammerHead, 1, 0), 
/*  654 */             Character.valueOf('I'), "stickWood" }));
/*  655 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelHammerHead, 1, 0), 
/*  656 */             Character.valueOf('I'), "stickWood" }));
/*  657 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeHammerHead, 1, 0), 
/*  658 */             Character.valueOf('I'), "stickWood" }));
/*  659 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperHammerHead, 1, 0), 
/*  660 */             Character.valueOf('I'), "stickWood" }));
/*  661 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronHammerHead, 1, 0), 
/*  662 */             Character.valueOf('I'), "stickWood" }));
/*  663 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelHammerHead, 1, 0), 
/*  664 */             Character.valueOf('I'), "stickWood" }));
/*  665 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelHammerHead, 1, 0), 
/*  666 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  669 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeSawHead, 1, 0), 
/*  670 */             Character.valueOf('I'), "stickWood" }));
/*  671 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeSawHead, 1, 0), 
/*  672 */             Character.valueOf('I'), "stickWood" }));
/*  673 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelSawHead, 1, 0), 
/*  674 */             Character.valueOf('I'), "stickWood" }));
/*  675 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelSawHead, 1, 0), 
/*  676 */             Character.valueOf('I'), "stickWood" }));
/*  677 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeSawHead, 1, 0), 
/*  678 */             Character.valueOf('I'), "stickWood" }));
/*  679 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperSawHead, 1, 0), 
/*  680 */             Character.valueOf('I'), "stickWood" }));
/*  681 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronSawHead, 1, 0), 
/*  682 */             Character.valueOf('I'), "stickWood" }));
/*  683 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelSawHead, 1, 0), 
/*  684 */             Character.valueOf('I'), "stickWood" }));
/*  685 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelSawHead, 1, 0), 
/*  686 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  689 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeChiselHead, 1, 0), 
/*  690 */             Character.valueOf('I'), "stickWood" }));
/*  691 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeChiselHead, 1, 0), 
/*  692 */             Character.valueOf('I'), "stickWood" }));
/*  693 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelChiselHead, 1, 0), 
/*  694 */             Character.valueOf('I'), "stickWood" }));
/*  695 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelChiselHead, 1, 0), 
/*  696 */             Character.valueOf('I'), "stickWood" }));
/*  697 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeChiselHead, 1, 0), 
/*  698 */             Character.valueOf('I'), "stickWood" }));
/*  699 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperChiselHead, 1, 0), 
/*  700 */             Character.valueOf('I'), "stickWood" }));
/*  701 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronChiselHead, 1, 0), 
/*  702 */             Character.valueOf('I'), "stickWood" }));
/*  703 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelChiselHead, 1, 0), 
/*  704 */             Character.valueOf('I'), "stickWood" }));
/*  705 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelChiselHead, 1, 0), 
/*  706 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  709 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBismuthBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeProPickHead, 1, 0), 
/*  710 */             Character.valueOf('I'), "stickWood" }));
/*  711 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlackBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeProPickHead, 1, 0), 
/*  712 */             Character.valueOf('I'), "stickWood" }));
/*  713 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlackSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelProPickHead, 1, 0), 
/*  714 */             Character.valueOf('I'), "stickWood" }));
/*  715 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlueSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelProPickHead, 1, 0), 
/*  716 */             Character.valueOf('I'), "stickWood" }));
/*  717 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeProPickHead, 1, 0), 
/*  718 */             Character.valueOf('I'), "stickWood" }));
/*  719 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickCopper, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperProPickHead, 1, 0), 
/*  720 */             Character.valueOf('I'), "stickWood" }));
/*  721 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickIron, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronProPickHead, 1, 0), 
/*  722 */             Character.valueOf('I'), "stickWood" }));
/*  723 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickRedSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelProPickHead, 1, 0), 
/*  724 */             Character.valueOf('I'), "stickWood" }));
/*  725 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelProPickHead, 1, 0), 
/*  726 */             Character.valueOf('I'), "stickWood" }));
/*      */     
/*  728 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeScytheHead, 1, 0), 
/*  729 */             Character.valueOf('I'), "stickWood" }));
/*  730 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeScytheHead, 1, 0), 
/*  731 */             Character.valueOf('I'), "stickWood" }));
/*  732 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelScytheHead, 1, 0), 
/*  733 */             Character.valueOf('I'), "stickWood" }));
/*  734 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelScytheHead, 1, 0), 
/*  735 */             Character.valueOf('I'), "stickWood" }));
/*  736 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeScytheHead, 1, 0), 
/*  737 */             Character.valueOf('I'), "stickWood" }));
/*  738 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperScytheHead, 1, 0), 
/*  739 */             Character.valueOf('I'), "stickWood" }));
/*  740 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronScytheHead, 1, 0), 
/*  741 */             Character.valueOf('I'), "stickWood" }));
/*  742 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelScytheHead, 1, 0), 
/*  743 */             Character.valueOf('I'), "stickWood" }));
/*  744 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelScytheHead, 1, 0), 
/*  745 */             Character.valueOf('I'), "stickWood" }));
/*      */     
/*  747 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeKnifeHead, 1, 0), 
/*  748 */             Character.valueOf('I'), "stickWood" }));
/*  749 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeKnifeHead, 1, 0), 
/*  750 */             Character.valueOf('I'), "stickWood" }));
/*  751 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelKnifeHead, 1, 0), 
/*  752 */             Character.valueOf('I'), "stickWood" }));
/*  753 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelKnifeHead, 1, 0), 
/*  754 */             Character.valueOf('I'), "stickWood" }));
/*  755 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeKnifeHead, 1, 0), 
/*  756 */             Character.valueOf('I'), "stickWood" }));
/*  757 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperKnifeHead, 1, 0), 
/*  758 */             Character.valueOf('I'), "stickWood" }));
/*  759 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronKnifeHead, 1, 0), 
/*  760 */             Character.valueOf('I'), "stickWood" }));
/*  761 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelKnifeHead, 1, 0), 
/*  762 */             Character.valueOf('I'), "stickWood" }));
/*  763 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelKnifeHead, 1, 0), 
/*  764 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  767 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeJavelinHead, 1, 0), 
/*  768 */             Character.valueOf('I'), "stickWood" }));
/*  769 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeJavelinHead, 1, 0), 
/*  770 */             Character.valueOf('I'), "stickWood" }));
/*  771 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelJavelinHead, 1, 0), 
/*  772 */             Character.valueOf('I'), "stickWood" }));
/*  773 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelJavelinHead, 1, 0), 
/*  774 */             Character.valueOf('I'), "stickWood" }));
/*  775 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeJavelinHead, 1, 0), 
/*  776 */             Character.valueOf('I'), "stickWood" }));
/*  777 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperJavelinHead, 1, 0), 
/*  778 */             Character.valueOf('I'), "stickWood" }));
/*  779 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronJavelinHead, 1, 0), 
/*  780 */             Character.valueOf('I'), "stickWood" }));
/*  781 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelJavelinHead, 1, 0), 
/*  782 */             Character.valueOf('I'), "stickWood" }));
/*  783 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelJavelinHead, 1, 0), 
/*  784 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  787 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1), new Object[] { "     ", " ### ", "#   #", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  788 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  789 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1), new Object[] { "     ", "#####", "   ##", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  790 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  791 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1), new Object[] { "     ", "#####", "#####", "  #  ", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  792 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1), new Object[] { "  #  ", "  #  ", "  #  ", "  #  ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  793 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1), new Object[] { "   ##", "  ###", " ### ", " ##  ", "#    ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  794 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1), new Object[] { "  #  ", " ### ", " ### ", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  795 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1), new Object[] { "##   ", "###  ", " ### ", " ####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  796 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1), new Object[] { "     ", " ####", "#   #", "    #", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  797 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1), new Object[] { "     ", "#### ", " ####", "   ##", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  798 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1), new Object[] { "  # ", " ## ", " ## ", " ## ", " ## ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  799 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*      */     
/*  801 */     registerAlloys();
/*      */     
/*  803 */     registerKnapping();
/*      */ 
/*      */     
/*  806 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherHelmet, 1), new Object[] { "#####", "#   #", "#   #", Character.valueOf('#'), TFCItems.flatLeather });
/*  807 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherChestplate, 1), new Object[] { "#   #", "#####", "#####", "#####", "#####", Character.valueOf('#'), TFCItems.flatLeather });
/*  808 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherLeggings, 1), new Object[] { "#####", "#####", "## ##", "## ##", "## ##", Character.valueOf('#'), TFCItems.flatLeather });
/*  809 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherBoots, 1), new Object[] { "##   ", "##   ", "##   ", "#### ", "#####", Character.valueOf('#'), TFCItems.flatLeather });
/*      */     
/*  811 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.quiver, 1), new Object[] { " ####", "# ###", "# ###", "# ###", " ####", Character.valueOf('#'), TFCItems.flatLeather });
/*  812 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.field_151141_av, 1), new Object[] { "  #  ", "#####", "#####", "#####", "  #  ", Character.valueOf('#'), TFCItems.flatLeather });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerKnapping() {
/*  818 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { " #  #", "## ##", "## ##", "## ##", "## ##", 
/*  819 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  820 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { "#  # ", "## ##", "## ##", "## ##", "## ##", 
/*  821 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  822 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { "#   #", "## ##", "## ##", "## ##", "## ##", 
/*  823 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  824 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { " # # ", "## ##", "## ##", "## ##", "## ##", 
/*  825 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  826 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 1), new Object[] { " #", "##", "##", "##", "##", 
/*  827 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  828 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneHammerHead, 1), new Object[] { "#####", "#####", "  #  ", 
/*  829 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*      */     int i;
/*  831 */     for (i = 0; i < Global.STONE_IGIN.length; i++) {
/*      */       
/*  833 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  834 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  835 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  836 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*      */     } 
/*  838 */     for (i = 0; i < Global.STONE_SED.length; i++) {
/*      */       
/*  840 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  841 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  842 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  843 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*      */     } 
/*  845 */     for (i = 0; i < Global.STONE_IGEX.length; i++) {
/*      */       
/*  847 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  848 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  849 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  850 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*      */     } 
/*  852 */     for (i = 0; i < Global.STONE_MM.length; i++) {
/*      */       
/*  854 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  855 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  856 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  857 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  862 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.ceramicMold, 2, 0), new Object[] { "    ", " ## ", " ## ", " ## ", "    ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  867 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  868 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.potteryJug, 1, 0), new Object[] { "X XXX", "    X", "   X ", "    X", "   XX", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  873 */           Character.valueOf('X'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  874 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), new Object[] { "#   #", "     ", "     ", "     ", "#   #", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  879 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  880 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.flowerPot), new Object[] { "#   #", " ### ", " ### ", " ### ", "#   #", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  885 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  886 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.crucible, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "     ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  891 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 3) });
/*  892 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.vessel, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "     ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  897 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
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
/*      */   private static void registerAlloys() {
/*  912 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.tinUnshaped), new ItemStack(TFCItems.bismuthUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  916 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.zincUnshaped), new ItemStack(TFCItems.bismuthUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  920 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.blackBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.goldUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  924 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.steelUnshaped), new ItemStack(TFCItems.steelUnshaped), new ItemStack(TFCItems.nickelUnshaped), new ItemStack(TFCItems.blackBronzeUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  928 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.blackSteelUnshaped), new ItemStack(TFCItems.bismuthBronzeUnshaped), new ItemStack(TFCItems.sterlingSilverUnshaped), new ItemStack(TFCItems.steelUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  932 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.brassUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.zincUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  936 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.tinUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  940 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.blackSteelUnshaped), new ItemStack(TFCItems.roseGoldUnshaped), new ItemStack(TFCItems.brassUnshaped), new ItemStack(TFCItems.steelUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  944 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.roseGoldUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.goldUnshaped), new ItemStack(TFCItems.goldUnshaped), new ItemStack(TFCItems.goldUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  948 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.pigIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  952 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.silverUnshaped) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerToolMolds() {
/*  962 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 2), new Object[] { "12", 
/*  963 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/*  964 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 3), new Object[] { "12", 
/*  965 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/*  966 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 4), new Object[] { "12", 
/*  967 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/*  968 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 5), new Object[] { "12", 
/*  969 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/*      */     
/*  971 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 2), new Object[] { "12", 
/*  972 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/*  973 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 3), new Object[] { "12", 
/*  974 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/*  975 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 4), new Object[] { "12", 
/*  976 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/*  977 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 5), new Object[] { "12", 
/*  978 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/*      */     
/*  980 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 2), new Object[] { "12", 
/*  981 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/*  982 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 3), new Object[] { "12", 
/*  983 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/*  984 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 4), new Object[] { "12", 
/*  985 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/*  986 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 5), new Object[] { "12", 
/*  987 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/*      */     
/*  989 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 2), new Object[] { "12", 
/*  990 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/*  991 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 3), new Object[] { "12", 
/*  992 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/*  993 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 4), new Object[] { "12", 
/*  994 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/*  995 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 5), new Object[] { "12", 
/*  996 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/*      */     
/*  998 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 2), new Object[] { "12", 
/*  999 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1000 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 3), new Object[] { "12", 
/* 1001 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1002 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 4), new Object[] { "12", 
/* 1003 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1004 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 5), new Object[] { "12", 
/* 1005 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/*      */     
/* 1007 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 2), new Object[] { "12", 
/* 1008 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1009 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 3), new Object[] { "12", 
/* 1010 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1011 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 4), new Object[] { "12", 
/* 1012 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1013 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 5), new Object[] { "12", 
/* 1014 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/*      */     
/* 1016 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 2), new Object[] { "12", 
/* 1017 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1018 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 3), new Object[] { "12", 
/* 1019 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1020 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 4), new Object[] { "12", 
/* 1021 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1022 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 5), new Object[] { "12", 
/* 1023 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/*      */     
/* 1025 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 2), new Object[] { "12", 
/* 1026 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1027 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 3), new Object[] { "12", 
/* 1028 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1029 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 4), new Object[] { "12", 
/* 1030 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1031 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 5), new Object[] { "12", 
/* 1032 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/*      */     
/* 1034 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 2), new Object[] { "12", 
/* 1035 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1036 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 3), new Object[] { "12", 
/* 1037 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1038 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 4), new Object[] { "12", 
/* 1039 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1040 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 5), new Object[] { "12", 
/* 1041 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/*      */     
/* 1043 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 2), new Object[] { "12", 
/* 1044 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1045 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 3), new Object[] { "12", 
/* 1046 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1047 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 4), new Object[] { "12", 
/* 1048 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1049 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 5), new Object[] { "12", 
/* 1050 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/*      */     
/* 1052 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 2), new Object[] { "12", 
/* 1053 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1054 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 3), new Object[] { "12", 
/* 1055 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1056 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 4), new Object[] { "12", 
/* 1057 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1058 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 5), new Object[] { "12", 
/* 1059 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/*      */     
/* 1061 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 2), new Object[] { "12", 
/* 1062 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1063 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 3), new Object[] { "12", 
/* 1064 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1065 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 4), new Object[] { "12", 
/* 1066 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1067 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 5), new Object[] { "12", 
/* 1068 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/*      */     
/* 1070 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 2), new Object[] { "12", 
/* 1071 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1072 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 3), new Object[] { "12", 
/* 1073 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1074 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 4), new Object[] { "12", 
/* 1075 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1076 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 5), new Object[] { "12", 
/* 1077 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/*      */ 
/*      */ 
/*      */     
/* 1081 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperAxeHead), new Object[] {
/* 1082 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 2)) });
/* 1083 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeAxeHead), new Object[] {
/* 1084 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 3)) });
/* 1085 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeAxeHead), new Object[] {
/* 1086 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 4)) });
/* 1087 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeAxeHead), new Object[] {
/* 1088 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 5))
/*      */         });
/* 1090 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperChiselHead), new Object[] {
/* 1091 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 2)) });
/* 1092 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeChiselHead), new Object[] {
/* 1093 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 3)) });
/* 1094 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeChiselHead), new Object[] {
/* 1095 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 4)) });
/* 1096 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeChiselHead), new Object[] {
/* 1097 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 5))
/*      */         });
/* 1099 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperHammerHead), new Object[] {
/* 1100 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 2)) });
/* 1101 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeHammerHead), new Object[] {
/* 1102 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 3)) });
/* 1103 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeHammerHead), new Object[] {
/* 1104 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 4)) });
/* 1105 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeHammerHead), new Object[] {
/* 1106 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 5))
/*      */         });
/* 1108 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperHoeHead), new Object[] {
/* 1109 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 2)) });
/* 1110 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeHoeHead), new Object[] {
/* 1111 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 3)) });
/* 1112 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeHoeHead), new Object[] {
/* 1113 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 4)) });
/* 1114 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeHoeHead), new Object[] {
/* 1115 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 5))
/*      */         });
/* 1117 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperKnifeHead), new Object[] {
/* 1118 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 2)) });
/* 1119 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeKnifeHead), new Object[] {
/* 1120 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 3)) });
/* 1121 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeKnifeHead), new Object[] {
/* 1122 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 4)) });
/* 1123 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeKnifeHead), new Object[] {
/* 1124 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 5))
/*      */         });
/* 1126 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperJavelinHead), new Object[] {
/* 1127 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 2)) });
/* 1128 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeJavelinHead), new Object[] {
/* 1129 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 3)) });
/* 1130 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeJavelinHead), new Object[] {
/* 1131 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 4)) });
/* 1132 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeJavelinHead), new Object[] {
/* 1133 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 5))
/*      */         });
/* 1135 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperMaceHead), new Object[] {
/* 1136 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 2)) });
/* 1137 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeMaceHead), new Object[] {
/* 1138 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 3)) });
/* 1139 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeMaceHead), new Object[] {
/* 1140 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 4)) });
/* 1141 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeMaceHead), new Object[] {
/* 1142 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 5))
/*      */         });
/* 1144 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperPickaxeHead), new Object[] {
/* 1145 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 2)) });
/* 1146 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzePickaxeHead), new Object[] {
/* 1147 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 3)) });
/* 1148 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzePickaxeHead), new Object[] {
/* 1149 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 4)) });
/* 1150 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzePickaxeHead), new Object[] {
/* 1151 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 5))
/*      */         });
/* 1153 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperProPickHead), new Object[] {
/* 1154 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 2)) });
/* 1155 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeProPickHead), new Object[] {
/* 1156 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 3)) });
/* 1157 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeProPickHead), new Object[] {
/* 1158 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 4)) });
/* 1159 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeProPickHead), new Object[] {
/* 1160 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 5))
/*      */         });
/* 1162 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperSawHead), new Object[] {
/* 1163 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 2)) });
/* 1164 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeSawHead), new Object[] {
/* 1165 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 3)) });
/* 1166 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeSawHead), new Object[] {
/* 1167 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 4)) });
/* 1168 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeSawHead), new Object[] {
/* 1169 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 5))
/*      */         });
/* 1171 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperScytheHead), new Object[] {
/* 1172 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 2)) });
/* 1173 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeScytheHead), new Object[] {
/* 1174 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 3)) });
/* 1175 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeScytheHead), new Object[] {
/* 1176 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 4)) });
/* 1177 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeScytheHead), new Object[] {
/* 1178 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 5))
/*      */         });
/* 1180 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperShovelHead), new Object[] {
/* 1181 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 2)) });
/* 1182 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeShovelHead), new Object[] {
/* 1183 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 3)) });
/* 1184 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeShovelHead), new Object[] {
/* 1185 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 4)) });
/* 1186 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeShovelHead), new Object[] {
/* 1187 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 5))
/*      */         });
/* 1189 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperSwordHead), new Object[] {
/* 1190 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 2)) });
/* 1191 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeSwordHead), new Object[] {
/* 1192 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 3)) });
/* 1193 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeSwordHead), new Object[] {
/* 1194 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 4)) });
/* 1195 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeSwordHead), new Object[] {
/* 1196 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 5))
/*      */         });
/*      */   }
/*      */   
/*      */   public static ItemStack getStackTemp(ItemStack is) {
/* 1201 */     NBTTagCompound nbt = new NBTTagCompound();
/* 1202 */     nbt.func_74757_a("temp", true);
/* 1203 */     is.func_77982_d(nbt);
/* 1204 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ItemStack getStackNoTemp(ItemStack is) {
/* 1209 */     NBTTagCompound noTemp = new NBTTagCompound();
/* 1210 */     noTemp.func_74757_a("noTemp", true);
/* 1211 */     is.func_77982_d(noTemp);
/* 1212 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerAnvilRecipes(Random r, World world) {
/* 1217 */     AnvilManager manager = AnvilManager.getInstance();
/*      */     
/* 1219 */     AnvilManager.world = world;
/*      */     
/* 1221 */     manager.addPlan("ingot", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/*      */     
/* 1223 */     manager.addPlan("sheet", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/*      */     
/* 1225 */     manager.addPlan("pickaxe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.BENDNOTLAST, RuleEnum.DRAWNOTLAST }));
/*      */     
/* 1227 */     manager.addPlan("shovel", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITNOTLAST, RuleEnum.ANY }));
/*      */     
/* 1229 */     manager.addPlan("axe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.UPSETTHIRDFROMLAST }));
/* 1230 */     manager.addPlan("hoe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1231 */     manager.addPlan("hammer", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.ANY, RuleEnum.SHRINKNOTLAST }));
/* 1232 */     manager.addPlan("chisel", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITNOTLAST, RuleEnum.DRAWNOTLAST }));
/* 1233 */     manager.addPlan("propick", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.DRAWNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1234 */     manager.addPlan("saw", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.ANY }));
/* 1235 */     manager.addPlan("sword", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1236 */     manager.addPlan("mace", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.SHRINKNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1237 */     manager.addPlan("scythe", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1238 */     manager.addPlan("knife", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1239 */     manager.addPlan("javelin", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1240 */     manager.addPlan("helmplate", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1241 */     manager.addPlan("chestplate", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.UPSETTHIRDFROMLAST }));
/* 1242 */     manager.addPlan("legsplate", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDANY, RuleEnum.DRAWANY, RuleEnum.HITANY }));
/* 1243 */     manager.addPlan("bootsplate", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.SHRINKTHIRDFROMLAST }));
/* 1244 */     manager.addPlan("bucket", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1245 */     manager.addPlan("refinebloom", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/* 1246 */     manager.addPlan("splitbloom", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.ANY, RuleEnum.ANY }));
/* 1247 */     manager.addPlan("tuyere", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.ANY }));
/* 1248 */     manager.addPlan("trapdoor", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.SHRINKNOTLAST, RuleEnum.UPSETNOTLAST }));
/* 1249 */     manager.addPlan("grill", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1250 */     manager.addPlan("shears", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/* 1251 */     manager.addPlan("oillamp", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1252 */     manager.addPlan("hopper", new PlanRecipe(new RuleEnum[] { RuleEnum.UPSETLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/*      */     
/* 1254 */     addWeldRecipes(manager);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1260 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot), null, "ingot", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.highCarbonSteelIngot))).clearRecipeSkills());
/*      */     
/* 1262 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonBlackSteelIngot), null, "ingot", false, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelIngot))).clearRecipeSkills());
/* 1263 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonBlueSteelIngot), null, "ingot", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelIngot))).clearRecipeSkills());
/* 1264 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonRedSteelIngot), null, "ingot", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelIngot))).clearRecipeSkills());
/* 1265 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonSteelIngot), null, "ingot", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelIngot))).clearRecipeSkills());
/*      */     
/* 1267 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.bismuthSheet)));
/* 1268 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "sheet", false, AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSheet)));
/* 1269 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "sheet", false, AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSheet)));
/* 1270 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "sheet", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSheet)));
/* 1271 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "sheet", false, AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSheet)));
/* 1272 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.brassSheet)));
/* 1273 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSheet)));
/* 1274 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.copperSheet)));
/* 1275 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.goldSheet)));
/* 1276 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "sheet", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSheet)));
/* 1277 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.leadSheet)));
/* 1278 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelIngot2x), null, "sheet", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelSheet)));
/* 1279 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronSheet)));
/* 1280 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.platinumSheet)));
/* 1281 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "sheet", false, AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSheet)));
/* 1282 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.roseGoldSheet)));
/* 1283 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.silverSheet)));
/* 1284 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "sheet", false, AnvilReq.STEEL, new ItemStack(TFCItems.steelSheet)));
/* 1285 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverSheet)));
/* 1286 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.tinSheet)));
/* 1287 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.zincSheet)));
/*      */ 
/*      */     
/* 1290 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "pickaxe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1291 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "pickaxe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1292 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "pickaxe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1293 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "pickaxe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1294 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "pickaxe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1295 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "pickaxe", AnvilReq.COPPER, new ItemStack(TFCItems.copperPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1296 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "pickaxe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1297 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "pickaxe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1298 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "pickaxe", AnvilReq.STEEL, new ItemStack(TFCItems.steelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */ 
/*      */     
/* 1302 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "shovel", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1303 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "shovel", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1304 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "shovel", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1305 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "shovel", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1306 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "shovel", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1307 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "shovel", AnvilReq.COPPER, new ItemStack(TFCItems.copperShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1308 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "shovel", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1309 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "shovel", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1310 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "shovel", AnvilReq.STEEL, new ItemStack(TFCItems.steelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1313 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "axe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1314 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "axe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1315 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "axe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1316 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "axe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1317 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "axe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1318 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "axe", AnvilReq.COPPER, new ItemStack(TFCItems.copperAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1319 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "axe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1320 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "axe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1321 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "axe", AnvilReq.STEEL, new ItemStack(TFCItems.steelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1324 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "hoe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1325 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "hoe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1326 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "hoe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1327 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "hoe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1328 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "hoe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1329 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "hoe", AnvilReq.COPPER, new ItemStack(TFCItems.copperHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1330 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "hoe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1331 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "hoe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1332 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "hoe", AnvilReq.STEEL, new ItemStack(TFCItems.steelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1335 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "hammer", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1336 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "hammer", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1337 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "hammer", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1338 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "hammer", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1339 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "hammer", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1340 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "hammer", AnvilReq.COPPER, new ItemStack(TFCItems.copperHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1341 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "hammer", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1342 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "hammer", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1343 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "hammer", AnvilReq.STEEL, new ItemStack(TFCItems.steelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1346 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "chisel", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1347 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "chisel", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1348 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "chisel", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1349 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "chisel", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1350 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "chisel", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1351 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "chisel", AnvilReq.COPPER, new ItemStack(TFCItems.copperChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1352 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "chisel", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1353 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "chisel", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1354 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "chisel", AnvilReq.STEEL, new ItemStack(TFCItems.steelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1357 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "propick", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1358 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "propick", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1359 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "propick", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1360 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "propick", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1361 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "propick", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1362 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "propick", AnvilReq.COPPER, new ItemStack(TFCItems.copperProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1363 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "propick", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1364 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "propick", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1365 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "propick", AnvilReq.STEEL, new ItemStack(TFCItems.steelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1368 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "saw", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1369 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "saw", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1370 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "saw", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1371 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "saw", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1372 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "saw", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1373 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "saw", AnvilReq.COPPER, new ItemStack(TFCItems.copperSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1374 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "saw", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1375 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "saw", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1376 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "saw", AnvilReq.STEEL, new ItemStack(TFCItems.steelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1379 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "sword", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1380 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "sword", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1381 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "sword", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1382 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "sword", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1383 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "sword", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1384 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "sword", AnvilReq.COPPER, new ItemStack(TFCItems.copperSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1385 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "sword", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1386 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "sword", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1387 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "sword", AnvilReq.STEEL, new ItemStack(TFCItems.steelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */ 
/*      */ 
/*      */     
/* 1391 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "mace", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1392 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "mace", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1393 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "mace", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1394 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "mace", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1395 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "mace", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1396 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "mace", AnvilReq.COPPER, new ItemStack(TFCItems.copperMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1397 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "mace", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1398 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "mace", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1399 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "mace", AnvilReq.STEEL, new ItemStack(TFCItems.steelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */ 
/*      */     
/* 1402 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "scythe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1403 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "scythe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1404 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "scythe", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1405 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "scythe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1406 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "scythe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1407 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "scythe", AnvilReq.COPPER, new ItemStack(TFCItems.copperScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1408 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "scythe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1409 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "scythe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1410 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "scythe", AnvilReq.STEEL, new ItemStack(TFCItems.steelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1413 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "knife", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1414 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "knife", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1415 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "knife", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1416 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "knife", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1417 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "knife", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1418 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "knife", AnvilReq.COPPER, new ItemStack(TFCItems.copperKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1419 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "knife", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1420 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "knife", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1421 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "knife", AnvilReq.STEEL, new ItemStack(TFCItems.steelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/*      */ 
/*      */ 
/*      */     
/* 1425 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "javelin", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1426 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "javelin", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1427 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "javelin", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1428 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "javelin", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1429 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "javelin", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1430 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "javelin", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1431 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "javelin", AnvilReq.STEEL, new ItemStack(TFCItems.steelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1432 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "javelin", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1433 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "javelin", AnvilReq.COPPER, new ItemStack(TFCItems.copperJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */     
/* 1435 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), null, "helmPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1436 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), null, "helmPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1437 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), null, "helmPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1438 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "helmPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1439 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), null, "helmPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1440 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet), null, "helmPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1441 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "helmPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1442 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "helmPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1443 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "helmPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1445 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1446 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1447 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1448 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1449 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1450 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1451 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1452 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1453 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/*      */     
/* 1455 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "chestPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1456 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "chestPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1457 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "chestPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1458 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "chestPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1459 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "chestPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1460 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "chestPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1461 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "chestPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1462 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "chestPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1463 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "chestPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1465 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1466 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1467 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1468 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1469 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1470 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1471 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1472 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1473 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/*      */     
/* 1475 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "legsPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1476 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "legsPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1477 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "legsPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1478 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "legsPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1479 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "legsPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1480 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "legsPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1481 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "legsPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1482 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "legsPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1483 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "legsPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1485 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1486 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1487 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1488 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1489 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1490 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1491 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1492 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1493 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/*      */     
/* 1495 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), null, "bootsplate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1496 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), null, "bootsplate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1497 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), null, "bootsplate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1498 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "bootsplate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1499 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), null, "bootsplate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1500 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet), null, "bootsplate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1501 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "bootsplate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1502 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "bootsplate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1503 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "bootsplate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1505 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1506 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1507 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1508 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1509 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1510 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.COPPER, new ItemStack(TFCItems.copperBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1511 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1512 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1513 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.STEEL, new ItemStack(TFCItems.steelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/*      */ 
/*      */ 
/*      */     
/* 1517 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "bucket", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelBucketEmpty, 1)));
/* 1518 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "bucket", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelBucketEmpty, 1)));
/*      */     
/* 1520 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.rawBloom, 1, 32767), null, "refinebloom", AnvilReq.BRONZE, new ItemStack(TFCItems.bloom, 1))).setInheritsDamage().clearRecipeSkills());
/* 1521 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bloom, 1, 100), null, "refinebloom", AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronIngot, 1))).clearRecipeSkills());
/* 1522 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bloom, 1, 32767), null, "splitbloom", AnvilReq.BRONZE, new ItemStack(TFCItems.bloom, 1))).clearRecipeSkills());
/*      */ 
/*      */     
/* 1525 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "tuyere", AnvilReq.COPPER, new ItemStack(TFCItems.tuyereCopper, 1)));
/* 1526 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBronze, 1)));
/* 1527 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBismuthBronze, 1)));
/* 1528 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBlackBronze, 1)));
/* 1529 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "tuyere", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.tuyereWroughtIron, 1)));
/* 1530 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "tuyere", AnvilReq.STEEL, new ItemStack(TFCItems.tuyereSteel, 1)));
/* 1531 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "tuyere", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.tuyereBlackSteel, 1)));
/* 1532 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "tuyere", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.tuyereBlueSteel, 1)));
/* 1533 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "tuyere", AnvilReq.REDSTEEL, new ItemStack(TFCItems.tuyereRedSteel, 1)));
/*      */     
/* 1535 */     addTrapDoor(TFCItems.bismuthSheet, 0); addTrapDoor(TFCItems.bismuthBronzeSheet, 1); addTrapDoor(TFCItems.blackBronzeSheet, 2); addTrapDoor(TFCItems.blackSteelSheet, 3);
/* 1536 */     addTrapDoor(TFCItems.blueSteelSheet, 4); addTrapDoor(TFCItems.brassSheet, 5); addTrapDoor(TFCItems.bronzeSheet, 6); addTrapDoor(TFCItems.copperSheet, 7);
/* 1537 */     addTrapDoor(TFCItems.goldSheet, 8); addTrapDoor(TFCItems.wroughtIronSheet, 9); addTrapDoor(TFCItems.leadSheet, 10); addTrapDoor(TFCItems.nickelSheet, 11);
/* 1538 */     addTrapDoor(TFCItems.nickelSheet, 12); addTrapDoor(TFCItems.platinumSheet, 13); addTrapDoor(TFCItems.redSteelSheet, 14); addTrapDoor(TFCItems.roseGoldSheet, 15);
/* 1539 */     addTrapDoor(TFCItems.silverSheet, 16); addTrapDoor(TFCItems.steelSheet, 17); addTrapDoor(TFCItems.sterlingSilverSheet, 18); addTrapDoor(TFCItems.tinSheet, 19);
/* 1540 */     addTrapDoor(TFCItems.zincSheet, 20);
/*      */     
/* 1542 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), new ItemStack(TFCItems.wroughtIronIngot2x), "grill", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.grill, 1, 0)));
/* 1543 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronKnifeHead), new ItemStack(TFCItems.wroughtIronKnifeHead), "shears", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.shears, 1, 0)));
/*      */     
/* 1545 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 0)));
/* 1546 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 1)));
/* 1547 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 2)));
/* 1548 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 3)));
/* 1549 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 4)));
/* 1550 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "oillamp", AnvilReq.BLUESTEEL, new ItemStack(TFCBlocks.oilLamp, 1, 5)));
/*      */     
/* 1552 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), new ItemStack(TFCItems.wroughtIronSheet2x), "hopper", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.hopper, 1, 0)));
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addTrapDoor(Item sheet, int index) {
/* 1557 */     AnvilManager manager = AnvilManager.getInstance();
/* 1558 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bismuthIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index)));
/* 1559 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bismuthBronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 32)));
/* 1560 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blackBronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 64)));
/* 1561 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blackSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 96)));
/* 1562 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blueSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 128)));
/* 1563 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.brassIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 160)));
/* 1564 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 192)));
/* 1565 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.copperIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 224)));
/* 1566 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.goldIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 256)));
/* 1567 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.wroughtIronIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 288)));
/* 1568 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.leadIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 320)));
/* 1569 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.nickelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 352)));
/* 1570 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.platinumIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 416)));
/* 1571 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.redSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 448)));
/* 1572 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.roseGoldIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 480)));
/* 1573 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.silverIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 512)));
/* 1574 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.steelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 544)));
/* 1575 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.sterlingSilverIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 576)));
/* 1576 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.tinIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 608)));
/* 1577 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.zincIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 640)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addWeldRecipes(AnvilManager manager) {
/* 1588 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthIngot), new ItemStack(TFCItems.bismuthIngot), AnvilReq.STONE, new ItemStack(TFCItems.bismuthIngot2x, 1)));
/* 1589 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), new ItemStack(TFCItems.bismuthBronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeIngot2x, 1)));
/* 1590 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), new ItemStack(TFCItems.blackBronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeIngot2x, 1)));
/* 1591 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelIngot2x, 1)));
/* 1592 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), new ItemStack(TFCItems.blueSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelIngot2x, 1)));
/* 1593 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassIngot), new ItemStack(TFCItems.brassIngot), AnvilReq.COPPER, new ItemStack(TFCItems.brassIngot2x, 1)));
/* 1594 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), new ItemStack(TFCItems.bronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.bronzeIngot2x, 1)));
/* 1595 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot), new ItemStack(TFCItems.copperIngot), AnvilReq.STONE, new ItemStack(TFCItems.copperIngot2x, 1)));
/* 1596 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot), new ItemStack(TFCItems.goldIngot), AnvilReq.COPPER, new ItemStack(TFCItems.goldIngot2x, 1)));
/* 1597 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), new ItemStack(TFCItems.wroughtIronIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronIngot2x, 1)));
/* 1598 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadIngot), new ItemStack(TFCItems.leadIngot), AnvilReq.COPPER, new ItemStack(TFCItems.leadIngot2x, 1)));
/* 1599 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelIngot), new ItemStack(TFCItems.nickelIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelIngot2x, 1)));
/* 1600 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot), new ItemStack(TFCItems.pigIronIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronIngot2x, 1)));
/* 1601 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot), new ItemStack(TFCItems.platinumIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.platinumIngot2x, 1)));
/* 1602 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), new ItemStack(TFCItems.redSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelIngot2x, 1)));
/* 1603 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot), new ItemStack(TFCItems.roseGoldIngot), AnvilReq.COPPER, new ItemStack(TFCItems.roseGoldIngot2x, 1)));
/* 1604 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot), new ItemStack(TFCItems.silverIngot), AnvilReq.COPPER, new ItemStack(TFCItems.silverIngot2x, 1)));
/* 1605 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot), new ItemStack(TFCItems.steelIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelIngot2x, 1)));
/* 1606 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot), new ItemStack(TFCItems.sterlingSilverIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverIngot2x, 1)));
/* 1607 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinIngot), new ItemStack(TFCItems.tinIngot), AnvilReq.STONE, new ItemStack(TFCItems.tinIngot2x, 1)));
/* 1608 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincIngot), new ItemStack(TFCItems.zincIngot), AnvilReq.STONE, new ItemStack(TFCItems.zincIngot2x, 1)));
/* 1609 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakSteelIngot), new ItemStack(TFCItems.pigIronIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1)));
/* 1610 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakBlueSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1)));
/* 1611 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakRedSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.highCarbonRedSteelIngot, 1)));
/*      */     
/* 1613 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthSheet), new ItemStack(TFCItems.bismuthSheet), AnvilReq.STONE, new ItemStack(TFCItems.bismuthSheet2x, 1)));
/* 1614 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), new ItemStack(TFCItems.bismuthBronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeSheet2x, 1)));
/* 1615 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), new ItemStack(TFCItems.blackBronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeSheet2x, 1)));
/* 1616 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), new ItemStack(TFCItems.blackSteelSheet), AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelSheet2x, 1)));
/* 1617 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), new ItemStack(TFCItems.blueSteelSheet), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelSheet2x, 1)));
/* 1618 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassSheet), new ItemStack(TFCItems.brassSheet), AnvilReq.COPPER, new ItemStack(TFCItems.brassSheet2x, 1)));
/* 1619 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), new ItemStack(TFCItems.bronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.bronzeSheet2x, 1)));
/* 1620 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperSheet), new ItemStack(TFCItems.copperSheet), AnvilReq.STONE, new ItemStack(TFCItems.copperSheet2x, 1)));
/* 1621 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldSheet), new ItemStack(TFCItems.goldSheet), AnvilReq.COPPER, new ItemStack(TFCItems.goldSheet2x, 1)));
/* 1622 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), new ItemStack(TFCItems.wroughtIronSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronSheet2x, 1)));
/* 1623 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadSheet), new ItemStack(TFCItems.leadSheet), AnvilReq.COPPER, new ItemStack(TFCItems.leadSheet2x, 1)));
/* 1624 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelSheet), new ItemStack(TFCItems.nickelSheet), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelSheet2x, 1)));
/* 1625 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronSheet), new ItemStack(TFCItems.pigIronSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronSheet2x, 1)));
/* 1626 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumSheet), new ItemStack(TFCItems.platinumSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.platinumSheet2x, 1)));
/* 1627 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), new ItemStack(TFCItems.redSteelSheet), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelSheet2x, 1)));
/* 1628 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldSheet), new ItemStack(TFCItems.roseGoldSheet), AnvilReq.COPPER, new ItemStack(TFCItems.roseGoldSheet2x, 1)));
/* 1629 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverSheet), new ItemStack(TFCItems.silverSheet), AnvilReq.COPPER, new ItemStack(TFCItems.silverSheet2x, 1)));
/* 1630 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet), new ItemStack(TFCItems.steelSheet), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelSheet2x, 1)));
/* 1631 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverSheet), new ItemStack(TFCItems.sterlingSilverSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverSheet2x, 1)));
/* 1632 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinSheet), new ItemStack(TFCItems.tinSheet), AnvilReq.STONE, new ItemStack(TFCItems.tinSheet2x, 1)));
/* 1633 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincSheet), new ItemStack(TFCItems.zincSheet), AnvilReq.STONE, new ItemStack(TFCItems.zincSheet2x, 1)));
/*      */ 
/*      */     
/* 1636 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 1)));
/* 1637 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blackBronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 1)));
/* 1638 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blackSteelSheet2x), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 1)));
/* 1639 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blueSteelSheet2x), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 1)));
/* 1640 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.bronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 1)));
/* 1641 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.copperSheet2x), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 1)));
/* 1642 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.wroughtIronSheet2x), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 1)));
/* 1643 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.redSteelSheet2x), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 1)));
/* 1644 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.steelSheet2x), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 1)));
/*      */ 
/*      */     
/* 1647 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 1)));
/* 1648 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 1)));
/* 1649 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 1)));
/* 1650 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 1)));
/* 1651 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 1)));
/* 1652 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 1)));
/* 1653 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 1)));
/* 1654 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 1)));
/* 1655 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 1)));
/*      */ 
/*      */     
/* 1658 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 1)));
/* 1659 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 1)));
/* 1660 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 1)));
/* 1661 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 1)));
/* 1662 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 1)));
/* 1663 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 1)));
/* 1664 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 1)));
/* 1665 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 1)));
/* 1666 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 1)));
/*      */ 
/*      */     
/* 1669 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 1)));
/* 1670 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 1)));
/* 1671 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 1)));
/* 1672 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 1)));
/* 1673 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 1)));
/* 1674 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedBoots, 1, 1)));
/* 1675 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 1)));
/* 1676 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 1)));
/* 1677 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedBoots, 1, 1)));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerFoodRecipes() {
/* 1682 */     addFoodRefineRecipe(TFCItems.wheatWhole, TFCItems.wheatGrain);
/* 1683 */     addFoodRefineRecipe(TFCItems.ryeWhole, TFCItems.ryeGrain);
/* 1684 */     addFoodRefineRecipe(TFCItems.barleyWhole, TFCItems.barleyGrain);
/* 1685 */     addFoodRefineRecipe(TFCItems.oatWhole, TFCItems.oatGrain);
/* 1686 */     addFoodRefineRecipe(TFCItems.riceWhole, TFCItems.riceGrain);
/*      */     
/* 1688 */     addFoodDoughRecipe(TFCItems.wheatGround, TFCItems.wheatDough, TFCItems.woodenBucketWater);
/* 1689 */     addFoodDoughRecipe(TFCItems.barleyGround, TFCItems.barleyDough, TFCItems.woodenBucketWater);
/* 1690 */     addFoodDoughRecipe(TFCItems.ryeGround, TFCItems.ryeDough, TFCItems.woodenBucketWater);
/* 1691 */     addFoodDoughRecipe(TFCItems.oatGround, TFCItems.oatDough, TFCItems.woodenBucketWater);
/* 1692 */     addFoodDoughRecipe(TFCItems.riceGround, TFCItems.riceDough, TFCItems.woodenBucketWater);
/* 1693 */     addFoodDoughRecipe(TFCItems.cornmealGround, TFCItems.cornmealDough, TFCItems.woodenBucketWater);
/* 1694 */     addFoodDoughRecipe(TFCItems.wheatGround, TFCItems.wheatDough, TFCItems.redSteelBucketWater);
/* 1695 */     addFoodDoughRecipe(TFCItems.barleyGround, TFCItems.barleyDough, TFCItems.redSteelBucketWater);
/* 1696 */     addFoodDoughRecipe(TFCItems.ryeGround, TFCItems.ryeDough, TFCItems.redSteelBucketWater);
/* 1697 */     addFoodDoughRecipe(TFCItems.oatGround, TFCItems.oatDough, TFCItems.redSteelBucketWater);
/* 1698 */     addFoodDoughRecipe(TFCItems.riceGround, TFCItems.riceDough, TFCItems.redSteelBucketWater);
/* 1699 */     addFoodDoughRecipe(TFCItems.cornmealGround, TFCItems.cornmealDough, TFCItems.redSteelBucketWater);
/*      */     
/* 1701 */     addFoodSaltRecipe(TFCItems.venisonRaw);
/* 1702 */     addFoodSaltRecipe(TFCItems.beefRaw);
/* 1703 */     addFoodSaltRecipe(TFCItems.chickenRaw);
/* 1704 */     addFoodSaltRecipe(TFCItems.porkchopRaw);
/* 1705 */     addFoodSaltRecipe(TFCItems.fishRaw);
/* 1706 */     addFoodSaltRecipe(TFCItems.calamariRaw);
/* 1707 */     addFoodSaltRecipe(TFCItems.muttonRaw);
/* 1708 */     addFoodSaltRecipe(TFCItems.horseMeatRaw);
/* 1709 */     for (Item i : TFCItems.foodList) {
/*      */       
/* 1711 */       addFoodMergeRecipe(i);
/* 1712 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(ItemFoodTFC.createTag(new ItemStack(i, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(i, 1)), "itemKnife" }));
/* 1713 */       GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(i, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(i, 1)) });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodSaltRecipe(Item food) {
/* 1719 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), new ItemStack(TFCItems.powder, 1, 9) });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodRefineRecipe(Item foodInput, Item foodOutput) {
/* 1724 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(ItemFoodTFC.createTag(new ItemStack(foodOutput, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(foodInput, 1)), "itemKnife" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodDoughRecipe(Item foodInput, Item foodOutput, Item bucket) {
/* 1729 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(foodOutput, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(foodInput, 1)), bucket });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodMergeRecipe(Item food) {
/* 1734 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1735 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1736 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1737 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1738 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1739 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1740 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1741 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerKilnRecipes() {
/* 1746 */     KilnCraftingManager manager = KilnCraftingManager.getInstance();
/*      */     
/* 1748 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.ceramicMold, 1, 0), 0, new ItemStack(TFCItems.ceramicMold, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1754 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.spindleHead, 1, 0), 0, new ItemStack(TFCItems.spindleHead, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1760 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potteryJug, 1, 0), 0, new ItemStack(TFCItems.potteryJug, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1766 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), 0, new ItemStack(TFCItems.potterySmallVessel, 1, 1)));
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
/* 1778 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCBlocks.vessel, 1, 0), 0, new ItemStack(TFCBlocks.vessel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1784 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 0), 0, new ItemStack(TFCItems.clayMoldAxe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1790 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 0), 0, new ItemStack(TFCItems.clayMoldAxe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1796 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 0), 0, new ItemStack(TFCItems.clayMoldChisel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1802 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 0), 0, new ItemStack(TFCItems.clayMoldHammer, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1808 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 0), 0, new ItemStack(TFCItems.clayMoldHoe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1814 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 0), 0, new ItemStack(TFCItems.clayMoldKnife, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1820 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 0), 0, new ItemStack(TFCItems.clayMoldMace, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1826 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 0), 0, new ItemStack(TFCItems.clayMoldPick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1832 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 0), 0, new ItemStack(TFCItems.clayMoldProPick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1838 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 0), 0, new ItemStack(TFCItems.clayMoldSaw, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1844 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 0), 0, new ItemStack(TFCItems.clayMoldScythe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1850 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 0), 0, new ItemStack(TFCItems.clayMoldShovel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1856 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 0), 0, new ItemStack(TFCItems.clayMoldSword, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1862 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 0), 0, new ItemStack(TFCItems.clayMoldJavelin, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1868 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.fireBrick, 1, 0), 0, new ItemStack(TFCItems.fireBrick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1874 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potteryBowl, 1, 0), 0, new ItemStack(TFCItems.potteryBowl, 1, 1)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerQuernRecipes() {
/* 1883 */     QuernManager manager = QuernManager.getInstance();
/*      */     
/* 1885 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.wheatGrain, 1), new ItemStack(TFCItems.wheatGround, 1)));
/* 1886 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.ryeGrain, 1), new ItemStack(TFCItems.ryeGround, 1)));
/* 1887 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oatGrain, 1), new ItemStack(TFCItems.oatGround, 1)));
/* 1888 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.barleyGrain, 1), new ItemStack(TFCItems.barleyGround, 1)));
/* 1889 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.riceGrain, 1), new ItemStack(TFCItems.riceGround, 1)));
/* 1890 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.maizeEar, 1), new ItemStack(TFCItems.cornmealGround, 1)));
/* 1891 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 16), new ItemStack(TFCItems.powder, 4, 1)));
/* 1892 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 20), new ItemStack(TFCItems.powder, 4, 2)));
/* 1893 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 27), new ItemStack(Items.field_151137_ax, 8)));
/* 1894 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 28), new ItemStack(Items.field_151137_ax, 8)));
/* 1895 */     manager.addRecipe(new QuernRecipe(new ItemStack(Items.field_151103_aS, 1), new ItemStack(TFCItems.dye, 2, 15)));
/* 1896 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 34), new ItemStack(TFCItems.powder, 4, 6)));
/* 1897 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 9), new ItemStack(TFCItems.powder, 1, 8)));
/* 1898 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 58), new ItemStack(TFCItems.powder, 2, 8)));
/* 1899 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 9), new ItemStack(TFCItems.powder, 4, 8)));
/* 1900 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 44), new ItemStack(TFCItems.powder, 6, 8)));
/* 1901 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 3), new ItemStack(TFCItems.powder, 1, 5)));
/* 1902 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 52), new ItemStack(TFCItems.powder, 2, 5)));
/* 1903 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 3), new ItemStack(TFCItems.powder, 4, 5)));
/* 1904 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 38), new ItemStack(TFCItems.powder, 6, 5)));
/* 1905 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 11), new ItemStack(TFCItems.powder, 1, 7)));
/* 1906 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 60), new ItemStack(TFCItems.powder, 2, 7)));
/* 1907 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 11), new ItemStack(TFCItems.powder, 4, 7)));
/* 1908 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 46), new ItemStack(TFCItems.powder, 6, 7)));
/* 1909 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 31), new ItemStack(TFCItems.fertilizer, 4)));
/* 1910 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.looseRock, 1, 5), new ItemStack(TFCItems.powder, 4, 9)));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int valueOfString(String s) {
/* 1915 */     if (s.length() > 0) {
/*      */       
/* 1917 */       byte[] b = s.getBytes();
/* 1918 */       int out = 0;
/* 1919 */       for (int i = 0; i < b.length; i++)
/* 1920 */         out += b[i]; 
/* 1921 */       return out;
/*      */     } 
/* 1923 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void removeRecipe(ItemStack resultItem) {
/* 1928 */     List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
/* 1929 */     for (int i = 0; i < recipes.size(); i++) {
/*      */       
/* 1931 */       if (recipes.get(i) != null) {
/*      */         
/* 1933 */         ItemStack recipeResult = ((IRecipe)recipes.get(i)).func_77571_b();
/*      */         
/* 1935 */         if (ItemStack.func_77989_b(resultItem, recipeResult)) {
/* 1936 */           recipes.remove(i--);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void removeRecipe(Class clazz) {
/* 1943 */     List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
/* 1944 */     for (int i = 0; i < recipes.size(); i++) {
/*      */       
/* 1946 */       IRecipe tmpRecipe = recipes.get(i);
/* 1947 */       if (tmpRecipe != null) {
/*      */         
/* 1949 */         ItemStack recipeResult = tmpRecipe.func_77571_b();
/*      */         
/* 1951 */         if (recipeResult != null && clazz.isInstance(recipeResult.func_77973_b()))
/* 1952 */           recipes.remove(i--); 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Recipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */