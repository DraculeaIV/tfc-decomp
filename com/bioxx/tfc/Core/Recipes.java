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
/*      */   public static Item[] tuyeres;
/*      */   public static final int WILD = 32767;
/*      */   
/*      */   public static void registerRecipes() {
/*   58 */     TEBarrel.registerRecipes();
/*   59 */     TELoom.registerRecipes();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   68 */     vanillaRecipes();
/*      */ 
/*      */     
/*   71 */     for (int m = 0; m < Global.WOOD_ALL.length; m++) {
/*      */       
/*   73 */       GameRegistry.addRecipe(new ItemStack(doors[m]), new Object[] { "WW", "WW", "WW", Character.valueOf('W'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*   74 */       GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.chest, 1, m), new Object[] { "###", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) }));
/*   75 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.toolRack, 1, m), new Object[] { "###", "   ", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */       
/*   77 */       int l = m % 16;
/*   78 */       if (m == l) {
/*      */         
/*   80 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, m), new Object[] { new ItemStack(TFCItems.logs, 1, m), "itemSaw" }));
/*   81 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 4, m), new Object[] { new ItemStack(TFCBlocks.planks, 1, m), "itemSaw" }));
/*   82 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.woodSupportV, 8, m), new Object[] { "A2", " 2", Character.valueOf('2'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('A'), "itemSaw" }));
/*      */         
/*   84 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.planks, 1, m), new Object[] { "11", "11", Character.valueOf('1'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*   86 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.barrel, 1, m), new Object[] { "# #", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*   88 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fence, 6, m), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('P'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*   89 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fenceGate, 2, m), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('P'), new ItemStack(TFCBlocks.planks, 1, m) });
/*   90 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.armorStand, 1, m), new Object[] { "###", " # ", "%%%", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('%'), new ItemStack(TFCBlocks.planks, 1, m) });
/*      */         
/*   92 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.loom, 1, m), new Object[] { "LLL", "LSL", "L L", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('S'), "stickWood" }));
/*      */       }
/*   94 */       else if (m / 16 == 1) {
/*      */         
/*   96 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 8, m), new Object[] { new ItemStack(TFCItems.logs, 1, m), "itemSaw" }));
/*   97 */         GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.singlePlank, 4, m), new Object[] { new ItemStack(TFCBlocks.planks2, 1, l), "itemSaw" }));
/*   98 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.woodSupportV2, 8, l), new Object[] { "A2", " 2", Character.valueOf('2'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('A'), "itemSaw" }));
/*      */         
/*  100 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.planks2, 1, l), new Object[] { "11", "11", Character.valueOf('1'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*      */         
/*  102 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fence2, 6, l), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.logs, 1, m), Character.valueOf('P'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*  103 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.fenceGate2, 2, l), new Object[] { "LPL", "LPL", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('P'), new ItemStack(TFCBlocks.planks2, 1, l) });
/*      */         
/*  105 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.armorStand2, 1, l), new Object[] { "###", " # ", "%%%", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('%'), new ItemStack(TFCBlocks.planks2, 1, l) });
/*      */         
/*  107 */         GameRegistry.addRecipe(new ItemStack(TFCBlocks.barrel, 1, m), new Object[] { "# #", "# #", "###", Character.valueOf('#'), new ItemStack(TFCItems.singlePlank, 1, m) });
/*  108 */         GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.loom, 1, m), new Object[] { "LLL", "LSL", "L L", Character.valueOf('L'), new ItemStack(TFCItems.singlePlank, 1, m), Character.valueOf('S'), "stickWood" }));
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  113 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sluiceItem, 1), new Object[] { "  1", " 12", "122", Character.valueOf('1'), "stickWood", Character.valueOf('2'), "woodLumber" }));
/*  114 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.nestBox, 1), new Object[] { "S S", "PSP", "PPP", Character.valueOf('S'), new ItemStack(TFCItems.straw, 1), Character.valueOf('P'), "woodLumber" }));
/*  115 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.woodenBucketEmpty, 1), new Object[] { "w w", "w w", " w ", Character.valueOf('w'), "woodLumber" }));
/*  116 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150415_aT, 1, 0), new Object[] { "###", "###", Character.valueOf('#'), "woodLumber" }));
/*  117 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151155_ap, 1, 0), new Object[] { "###", "###", " 1 ", Character.valueOf('#'), "woodLumber", Character.valueOf('1'), "stickWood" }));
/*  118 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.buttonWood, 1), new Object[] { "#", Character.valueOf('#'), "plankWood" }));
/*  119 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151104_aV, 1), new Object[] { "PPP", "QQQ", Character.valueOf('P'), "materialCloth", Character.valueOf('Q'), "woodLumber" }));
/*  120 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.workbench, 1), new Object[] { "PP", "PP", Character.valueOf('P'), "plankWood" }));
/*  121 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.bellows, 1, 0), new Object[] { "###", "???", "###", Character.valueOf('#'), "woodLumber", Character.valueOf('?'), "materialLeather" }));
/*      */ 
/*      */     
/*  124 */     for (int k = 0; k < 3; k++) {
/*      */       
/*  126 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.wool, 1 + k, 0), new Object[] { new ItemStack(TFCItems.sheepSkin, 1, k), "itemKnife" }));
/*  127 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.wool, 1 + k, 0), new Object[] { new ItemStack(TFCItems.pbearSkin, 1, k), "itemKnife" }));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  133 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 4), new Object[] { new ItemStack(TFCItems.powder, 1, 6) });
/*  134 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 2), new Object[] { new ItemStack(TFCItems.powder, 1, 8) });
/*  135 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 1), new Object[] { new ItemStack(TFCItems.powder, 1, 5) });
/*  136 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.dye, 1, 11), new Object[] { new ItemStack(TFCItems.powder, 1, 7) });
/*  137 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.dye, 1, 12), new Object[] { new ItemStack(TFCItems.powder, 1, 8), new ItemStack(TFCItems.powder, 1, 0), "blockSand" }));
/*      */     
/*      */     int i;
/*  140 */     for (i = 0; i < Global.STONE_FLUXINDEX.length; i++) {
/*  141 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.powder, 2, 0), new Object[] { new ItemStack(TFCItems.looseRock, 1, Global.STONE_FLUXINDEX[i]), "itemHammer" }));
/*  142 */     }  GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.powder, 6, 0), new Object[] { new ItemStack(TFCItems.oreChunk, 1, 32), "itemHammer" }));
/*      */ 
/*      */     
/*  145 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 1), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleCopper" }));
/*  146 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 2), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBronze" }));
/*  147 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 3), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleWroughtIron" }));
/*  148 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 4), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleSteel" }));
/*  149 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 5), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlackSteel" }));
/*  150 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 6), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlueSteel" }));
/*  151 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil, 1, 7), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleRedSteel" }));
/*  152 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 0), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleRoseGold" }));
/*  153 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 1), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBismuthBronze" }));
/*  154 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.anvil2, 1, 2), new Object[] { "###", " # ", "###", Character.valueOf('#'), "ingotDoubleBlackBronze" }));
/*      */     
/*  156 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.bloomery, 1), new Object[] { "PPP", "P P", "PPP", Character.valueOf('P'), "plateDoubleAnyBronze" }));
/*  157 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.blastFurnace, 1), new Object[] { "PPP", "PCP", "PPP", Character.valueOf('P'), "plateDoubleWroughtIron", Character.valueOf('C'), new ItemStack(TFCBlocks.crucible, 1) }));
/*      */     
/*  159 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.spawnMeter, 1), new Object[] { "PPP", "GKG", "PPP", Character.valueOf('P'), "stoneSmooth", Character.valueOf('K'), "gemChipped", Character.valueOf('G'), new ItemStack(Blocks.field_150359_w, 1) }));
/*      */     
/*  161 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCBlocks.quern, 1), new Object[] { "PPP", Character.valueOf('P'), "stoneSmooth" }));
/*  162 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.quern, 1), new Object[] { "  W", "PPP", Character.valueOf('P'), "stone", Character.valueOf('W'), "stickWood" }));
/*      */ 
/*      */     
/*  165 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.clayBall, 1, 1), new Object[] { "PXP", "XCX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.powder, 1, 1), Character.valueOf('X'), new ItemStack(TFCItems.powder, 1, 2), Character.valueOf('C'), "lumpClay" }));
/*  166 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.clayBall, 1, 1), new Object[] { "PXP", "XCX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.powder, 1, 2), Character.valueOf('X'), new ItemStack(TFCItems.powder, 1, 1), Character.valueOf('C'), "lumpClay" }));
/*      */     
/*  168 */     GameRegistry.addRecipe(new ItemStack(TFCItems.fireBrick, 2, 0), new Object[] { "PP", "PP", Character.valueOf('P'), new ItemStack(TFCItems.clayBall, 1, 1) });
/*      */     
/*  170 */     GameRegistry.addRecipe(new ItemStack(TFCBlocks.fireBrick, 2, 0), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.fireBrick, 1, 1), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*      */ 
/*      */     
/*  173 */     GameRegistry.addRecipe(new ItemStack(TFCBlocks.thatch, 1), new Object[] { "PP", "PP", Character.valueOf('P'), new ItemStack(TFCItems.straw, 1) });
/*  174 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.straw, 4), new Object[] { new ItemStack(TFCBlocks.thatch, 1) });
/*      */ 
/*      */     
/*  177 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.coal, 9), new Object[] { new ItemStack(Blocks.field_150402_ci) });
/*  178 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150402_ci, 1), new Object[] { "###", "###", "###", Character.valueOf('#'), "gemCoal" }));
/*      */ 
/*      */     
/*  181 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.arrow, 8), new Object[] { "itemRock", "stickWood", new ItemStack(Items.field_151008_G) }));
/*      */     
/*  183 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Items.field_151016_H, 2, 0), new Object[] { "gemCharcoal", "dustSulfur", "dustSaltpeter" }));
/*      */     
/*  185 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151160_bD, 1), new Object[] { "###", "#$#", "###", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialLeather" }));
/*  186 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151159_an, 1), new Object[] { "###", "#$#", "###", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialCloth" }));
/*      */     
/*  188 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150404_cg, 2, 0), new Object[] { "$$", Character.valueOf('$'), "materialCloth" }));
/*      */     
/*  190 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCBlocks.litPumpkin, 1), new Object[] { "blockTorch", "blockPumpkin" }));
/*      */     
/*  192 */     GameRegistry.addRecipe(new ItemStack(TFCItems.glassBottle, 3), new Object[] { "# #", " # ", Character.valueOf('#'), new ItemStack(Blocks.field_150359_w) });
/*      */     
/*  194 */     for (i = 0; i < Global.DYE_NAMES.length; i++) {
/*      */       
/*  196 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Blocks.field_150404_cg, 1, i), new Object[] { Global.DYE_NAMES[i], new ItemStack(Blocks.field_150404_cg, 1, 32767) }));
/*  197 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), new Object[] { new ItemStack(TFCItems.potterySmallVessel, 1, 0), Global.DYE_NAMES[i] }));
/*      */     } 
/*      */     
/*  200 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150448_aq, 64), new Object[] { "PsP", "PsP", Character.valueOf('P'), "ingotIron", Character.valueOf('s'), "stickWood" }));
/*  201 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150318_D, 64), new Object[] { " r ", "PsP", "PsP", Character.valueOf('P'), "ingotGold", Character.valueOf('s'), "stickWood", Character.valueOf('r'), Items.field_151137_ax }));
/*  202 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151143_au, 1), new Object[] { "P P", "PPP", Character.valueOf('P'), "plateWroughtIron" }));
/*      */ 
/*      */     
/*  205 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Blocks.field_150442_at, 1), new Object[] { "P", "H", Character.valueOf('P'), "stickWood", Character.valueOf('H'), "itemRock" }));
/*      */     
/*  207 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(Items.field_151121_aF, 3), new Object[] { "###", Character.valueOf('#'), "itemReed" }));
/*  208 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(Items.field_151122_aG, 1), new Object[] { new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), new ItemStack(Items.field_151121_aF), "materialLeather" }));
/*      */ 
/*      */     
/*  211 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.woolYarn, 8), new Object[] { "materialWool", new ItemStack(TFCItems.spindle, 1, 32767) }));
/*      */ 
/*      */     
/*  214 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.ink, 16, 0), new Object[] { "2", Character.valueOf('2'), "dyeBlack" }));
/*  215 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueprint, 1), new Object[] { new ItemStack(TFCItems.ink), new ItemStack(Items.field_151121_aF, 1) });
/*  216 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.nametag, 1), new Object[] { new ItemStack(TFCItems.ink), new ItemStack(Items.field_151121_aF, 1), "materialString" }));
/*      */     
/*      */     int j;
/*  219 */     for (j = 0; j < Global.STONE_IGIN.length; j++) {
/*      */ 
/*      */       
/*  222 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgInBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + 0), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  223 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + 0), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + 0), "itemChisel" }));
/*      */ 
/*      */       
/*  226 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgInCobble, 1, j), new Object[] { "PP", "PP", 
/*  227 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + 0) });
/*  228 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + 0), new Object[] { new ItemStack(TFCBlocks.stoneIgInCobble, 1, j) });
/*      */ 
/*      */       
/*  231 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleIgIn, 4, j), new Object[] { "RRR", "RRR", 
/*  232 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + 0) });
/*  233 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawIgIn, 3, j), new Object[] { "RRR", "RRR", 
/*  234 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgIn, 1, j) });
/*  235 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickIgIn, 3, j), new Object[] { "BMB", "MBM", 
/*  236 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + 0), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  237 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothIgIn, 3, j), new Object[] { "RRR", "RRR", 
/*  238 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgInSmooth, 1, j) });
/*      */     } 
/*      */     
/*  241 */     for (j = 0; j < Global.STONE_SED.length; j++) {
/*      */ 
/*      */       
/*  244 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneSedBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  245 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START), "itemChisel" }));
/*      */ 
/*      */       
/*  248 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneSedCobble, 1, j), new Object[] { "PP", "PP", 
/*  249 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START) });
/*  250 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_SED_START), new Object[] { new ItemStack(TFCBlocks.stoneSedCobble, 1, j) });
/*      */ 
/*      */       
/*  253 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleSed, 4, j), new Object[] { "RRR", "RRR", 
/*  254 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_SED_START) });
/*  255 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawSed, 3, j), new Object[] { "RRR", "RRR", 
/*  256 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneSed, 1, j) });
/*  257 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickSed, 3, j), new Object[] { "BMB", "MBM", 
/*  258 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_SED_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  259 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothSed, 3, j), new Object[] { "RRR", "RRR", 
/*  260 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneSedSmooth, 1, j) });
/*      */     } 
/*      */     
/*  263 */     for (j = 0; j < Global.STONE_IGEX.length; j++) {
/*      */ 
/*      */       
/*  266 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgExBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  267 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START), "itemChisel" }));
/*      */ 
/*      */       
/*  270 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneIgExCobble, 1, j), new Object[] { "PP", "PP", 
/*  271 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START) });
/*  272 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_IGEX_START), new Object[] { new ItemStack(TFCBlocks.stoneIgExCobble, 1, j) });
/*      */ 
/*      */       
/*  275 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleIgEx, 4, j), new Object[] { "RRR", "RRR", 
/*  276 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_IGEX_START) });
/*  277 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawIgEx, 3, j), new Object[] { "RRR", "RRR", 
/*  278 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgEx, 1, j) });
/*  279 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickIgEx, 3, j), new Object[] { "BMB", "MBM", 
/*  280 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_IGEX_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  281 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothIgEx, 3, j), new Object[] { "RRR", "RRR", 
/*  282 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneIgExSmooth, 1, j) });
/*      */     } 
/*      */     
/*  285 */     for (j = 0; j < Global.STONE_MM.length; j++) {
/*      */       
/*  287 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneMMBrick, 4, j), new Object[] { "PXP", "XPX", "PXP", Character.valueOf('P'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), Character.valueOf('X'), new ItemStack(TFCItems.mortar, 1) });
/*  288 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), new Object[] { new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START), "itemChisel" }));
/*      */ 
/*      */       
/*  291 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.stoneMMCobble, 1, j), new Object[] { "PP", "PP", 
/*  292 */             Character.valueOf('P'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START) });
/*  293 */       GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.looseRock, 4, j + Global.STONE_MM_START), new Object[] { new ItemStack(TFCBlocks.stoneMMCobble, 1, j) });
/*      */ 
/*      */       
/*  296 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallCobbleMM, 4, j), new Object[] { "RRR", "RRR", 
/*  297 */             Character.valueOf('R'), new ItemStack(TFCItems.looseRock, 1, j + Global.STONE_MM_START) });
/*  298 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallRawMM, 3, j), new Object[] { "RRR", "RRR", 
/*  299 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneMM, 1, j) });
/*  300 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallBrickMM, 3, j), new Object[] { "BMB", "MBM", 
/*  301 */             Character.valueOf('B'), new ItemStack(TFCItems.stoneBrick, 1, j + Global.STONE_MM_START), Character.valueOf('M'), new ItemStack(TFCItems.mortar, 1) });
/*  302 */       GameRegistry.addRecipe(new ItemStack(TFCBlocks.wallSmoothMM, 3, j), new Object[] { "RRR", "RRR", 
/*  303 */             Character.valueOf('R'), new ItemStack(TFCBlocks.stoneMMSmooth, 1, j) });
/*      */     } 
/*      */ 
/*      */     
/*  307 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 0), new Object[] { new ItemStack(TFCItems.bismuthIngot), "itemChisel" }));
/*  308 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 1), new Object[] { new ItemStack(TFCItems.bismuthBronzeIngot), "itemChisel" }));
/*  309 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 2), new Object[] { new ItemStack(TFCItems.blackBronzeIngot), "itemChisel" }));
/*  310 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 3), new Object[] { new ItemStack(TFCItems.blackSteelIngot), "itemChisel" }));
/*  311 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 4), new Object[] { new ItemStack(TFCItems.blueSteelIngot), "itemChisel" }));
/*  312 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 5), new Object[] { new ItemStack(TFCItems.brassIngot), "itemChisel" }));
/*  313 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 6), new Object[] { new ItemStack(TFCItems.bronzeIngot), "itemChisel" }));
/*  314 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 7), new Object[] { new ItemStack(TFCItems.copperIngot), "itemChisel" }));
/*  315 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 8), new Object[] { new ItemStack(TFCItems.goldIngot), "itemChisel" }));
/*  316 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 9), new Object[] { new ItemStack(TFCItems.wroughtIronIngot), "itemChisel" }));
/*  317 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 10), new Object[] { new ItemStack(TFCItems.leadIngot), "itemChisel" }));
/*  318 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 11), new Object[] { new ItemStack(TFCItems.nickelIngot), "itemChisel" }));
/*  319 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 12), new Object[] { new ItemStack(TFCItems.pigIronIngot), "itemChisel" }));
/*  320 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 13), new Object[] { new ItemStack(TFCItems.platinumIngot), "itemChisel" }));
/*  321 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 14), new Object[] { new ItemStack(TFCItems.redSteelIngot), "itemChisel" }));
/*  322 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 15), new Object[] { new ItemStack(TFCItems.roseGoldIngot), "itemChisel" }));
/*  323 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 16), new Object[] { new ItemStack(TFCItems.silverIngot), "itemChisel" }));
/*  324 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 17), new Object[] { new ItemStack(TFCItems.steelIngot), "itemChisel" }));
/*  325 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 18), new Object[] { new ItemStack(TFCItems.sterlingSilverIngot), "itemChisel" }));
/*  326 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 19), new Object[] { new ItemStack(TFCItems.tinIngot), "itemChisel" }));
/*  327 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 20), new Object[] { new ItemStack(TFCItems.zincIngot), "itemChisel" }));
/*  328 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 21), new Object[] { new ItemStack(TFCItems.electrumIngot), "itemChisel" }));
/*  329 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.smallMetalChunk, 10, 22), new Object[] { new ItemStack(TFCItems.cupronickelIngot), "itemChisel" }));
/*      */ 
/*      */     
/*  332 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthUnshaped, 1, 0), new Object[] {
/*  333 */           getStackNoTemp(new ItemStack(TFCItems.bismuthIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  334 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 0), new Object[] {
/*  335 */           getStackNoTemp(new ItemStack(TFCItems.bismuthBronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  336 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 0), new Object[] {
/*  337 */           getStackNoTemp(new ItemStack(TFCItems.blackBronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  338 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackSteelUnshaped, 1, 0), new Object[] {
/*  339 */           getStackNoTemp(new ItemStack(TFCItems.blackSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  340 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueSteelUnshaped, 1, 0), new Object[] {
/*  341 */           getStackNoTemp(new ItemStack(TFCItems.blueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  342 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.brassUnshaped, 1, 0), new Object[] {
/*  343 */           getStackNoTemp(new ItemStack(TFCItems.brassIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  344 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeUnshaped, 1, 0), new Object[] {
/*  345 */           getStackNoTemp(new ItemStack(TFCItems.bronzeIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  346 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperUnshaped, 1, 0), new Object[] {
/*  347 */           getStackNoTemp(new ItemStack(TFCItems.copperIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  348 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.goldUnshaped, 1, 0), new Object[] {
/*  349 */           getStackNoTemp(new ItemStack(TFCItems.goldIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  350 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelUnshaped, 1, 0), new Object[] {
/*  351 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  352 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1, 0), new Object[] {
/*  353 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  354 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1, 0), new Object[] {
/*  355 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  356 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1, 0), new Object[] {
/*  357 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonRedSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  358 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.wroughtIronUnshaped, 1, 0), new Object[] {
/*  359 */           getStackNoTemp(new ItemStack(TFCItems.wroughtIronIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  360 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.leadUnshaped, 1, 0), new Object[] {
/*  361 */           getStackNoTemp(new ItemStack(TFCItems.leadIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  362 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.nickelUnshaped, 1, 0), new Object[] {
/*  363 */           getStackNoTemp(new ItemStack(TFCItems.nickelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  364 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.pigIronUnshaped, 1, 0), new Object[] {
/*  365 */           getStackNoTemp(new ItemStack(TFCItems.pigIronIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  366 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.platinumUnshaped, 1, 0), new Object[] {
/*  367 */           getStackNoTemp(new ItemStack(TFCItems.platinumIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  368 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.redSteelUnshaped, 1, 0), new Object[] {
/*  369 */           getStackNoTemp(new ItemStack(TFCItems.redSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  370 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.roseGoldUnshaped, 1, 0), new Object[] {
/*  371 */           getStackNoTemp(new ItemStack(TFCItems.roseGoldIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  372 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.silverUnshaped, 1, 0), new Object[] {
/*  373 */           getStackNoTemp(new ItemStack(TFCItems.silverIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  374 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.steelUnshaped, 1, 0), new Object[] {
/*  375 */           getStackNoTemp(new ItemStack(TFCItems.steelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  376 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverUnshaped, 1, 0), new Object[] {
/*  377 */           getStackNoTemp(new ItemStack(TFCItems.sterlingSilverIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  378 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.tinUnshaped, 1, 0), new Object[] {
/*  379 */           getStackNoTemp(new ItemStack(TFCItems.tinIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  380 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.zincUnshaped, 1, 0), new Object[] {
/*  381 */           getStackNoTemp(new ItemStack(TFCItems.zincIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  382 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.electrumUnshaped, 1, 0), new Object[] {
/*  383 */           getStackNoTemp(new ItemStack(TFCItems.electrumIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  384 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.cupronickelUnshaped, 1, 0), new Object[] {
/*  385 */           getStackNoTemp(new ItemStack(TFCItems.cupronickelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  386 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakSteelUnshaped, 1, 0), new Object[] {
/*  387 */           getStackNoTemp(new ItemStack(TFCItems.weakSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  388 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelUnshaped, 1, 0), new Object[] {
/*  389 */           getStackNoTemp(new ItemStack(TFCItems.weakBlueSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  390 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelUnshaped, 1, 0), new Object[] {
/*  391 */           getStackNoTemp(new ItemStack(TFCItems.weakRedSteelIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1) });
/*  392 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.unknownUnshaped, 1, 0), new Object[] {
/*  393 */           getStackNoTemp(new ItemStack(TFCItems.unknownIngot, 1)), new ItemStack(TFCItems.ceramicMold, 1, 1)
/*      */         });
/*      */     
/*  396 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthIngot, 1, 0), new Object[] {
/*  397 */           getStackNoTemp(new ItemStack(TFCItems.bismuthUnshaped, 1)) });
/*  398 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeIngot, 1, 0), new Object[] {
/*  399 */           getStackNoTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1)) });
/*  400 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeIngot, 1, 0), new Object[] {
/*  401 */           getStackNoTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1)) });
/*  402 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackSteelIngot, 1, 0), new Object[] {
/*  403 */           getStackNoTemp(new ItemStack(TFCItems.blackSteelUnshaped, 1)) });
/*  404 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blueSteelIngot, 1, 0), new Object[] {
/*  405 */           getStackNoTemp(new ItemStack(TFCItems.blueSteelUnshaped, 1)) });
/*  406 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.brassIngot, 1, 0), new Object[] {
/*  407 */           getStackNoTemp(new ItemStack(TFCItems.brassUnshaped, 1)) });
/*  408 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeIngot, 1, 0), new Object[] {
/*  409 */           getStackNoTemp(new ItemStack(TFCItems.bronzeUnshaped, 1)) });
/*  410 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperIngot, 1, 0), new Object[] {
/*  411 */           getStackNoTemp(new ItemStack(TFCItems.copperUnshaped, 1)) });
/*  412 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.goldIngot, 1, 0), new Object[] {
/*  413 */           getStackNoTemp(new ItemStack(TFCItems.goldUnshaped, 1)) });
/*  414 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelIngot, 1, 0), new Object[] {
/*  415 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonSteelUnshaped, 1)) });
/*  416 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1, 0), new Object[] {
/*  417 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1)) });
/*  418 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1, 0), new Object[] {
/*  419 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1)) });
/*  420 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.highCarbonRedSteelIngot, 1, 0), new Object[] {
/*  421 */           getStackNoTemp(new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1)) });
/*  422 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.wroughtIronIngot, 1, 0), new Object[] {
/*  423 */           getStackNoTemp(new ItemStack(TFCItems.wroughtIronUnshaped, 1)) });
/*  424 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.leadIngot, 1, 0), new Object[] {
/*  425 */           getStackNoTemp(new ItemStack(TFCItems.leadUnshaped, 1)) });
/*  426 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.nickelIngot, 1, 0), new Object[] {
/*  427 */           getStackNoTemp(new ItemStack(TFCItems.nickelUnshaped, 1)) });
/*  428 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.pigIronIngot, 1, 0), new Object[] {
/*  429 */           getStackNoTemp(new ItemStack(TFCItems.pigIronUnshaped, 1)) });
/*  430 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.platinumIngot, 1, 0), new Object[] {
/*  431 */           getStackNoTemp(new ItemStack(TFCItems.platinumUnshaped, 1)) });
/*  432 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.redSteelIngot, 1, 0), new Object[] {
/*  433 */           getStackNoTemp(new ItemStack(TFCItems.redSteelUnshaped, 1)) });
/*  434 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.roseGoldIngot, 1, 0), new Object[] {
/*  435 */           getStackNoTemp(new ItemStack(TFCItems.roseGoldUnshaped, 1)) });
/*  436 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.silverIngot, 1, 0), new Object[] {
/*  437 */           getStackNoTemp(new ItemStack(TFCItems.silverUnshaped, 1)) });
/*  438 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.steelIngot, 1, 0), new Object[] {
/*  439 */           getStackNoTemp(new ItemStack(TFCItems.steelUnshaped, 1)) });
/*  440 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverIngot, 1, 0), new Object[] {
/*  441 */           getStackNoTemp(new ItemStack(TFCItems.sterlingSilverUnshaped, 1)) });
/*  442 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.tinIngot, 1, 0), new Object[] {
/*  443 */           getStackNoTemp(new ItemStack(TFCItems.tinUnshaped, 1)) });
/*  444 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.zincIngot, 1, 0), new Object[] {
/*  445 */           getStackNoTemp(new ItemStack(TFCItems.zincUnshaped, 1)) });
/*  446 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.electrumIngot, 1, 0), new Object[] {
/*  447 */           getStackNoTemp(new ItemStack(TFCItems.electrumUnshaped, 1)) });
/*  448 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.cupronickelIngot, 1, 0), new Object[] {
/*  449 */           getStackNoTemp(new ItemStack(TFCItems.cupronickelUnshaped, 1)) });
/*  450 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakSteelIngot, 1, 0), new Object[] {
/*  451 */           getStackNoTemp(new ItemStack(TFCItems.weakSteelUnshaped, 1)) });
/*  452 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelIngot, 1, 0), new Object[] {
/*  453 */           getStackNoTemp(new ItemStack(TFCItems.weakBlueSteelUnshaped, 1)) });
/*  454 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelIngot, 1, 0), new Object[] {
/*  455 */           getStackNoTemp(new ItemStack(TFCItems.weakRedSteelUnshaped, 1)) });
/*  456 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.unknownIngot, 1, 0), new Object[] {
/*  457 */           getStackNoTemp(new ItemStack(TFCItems.unknownUnshaped, 1))
/*      */         });
/*  459 */     registerToolRecipes();
/*  460 */     registerFoodRecipes();
/*  461 */     registerKilnRecipes();
/*  462 */     registerToolMolds();
/*  463 */     registerQuernRecipes();
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
/*  478 */     removeRecipe(new ItemStack(Blocks.field_150462_ai));
/*      */     
/*  480 */     removeRecipe(new ItemStack((Item)Items.field_151112_aM));
/*  481 */     removeRecipe(new ItemStack(Blocks.field_150471_bO));
/*  482 */     removeRecipe(new ItemStack(Items.field_151033_d));
/*  483 */     removeRecipe(new ItemStack(Items.field_151044_h, 9));
/*  484 */     removeRecipe(new ItemStack(Items.field_151102_aT));
/*  485 */     removeRecipe(new ItemStack(Items.field_151069_bo, 3));
/*  486 */     removeRecipe(new ItemStack(Items.field_151121_aF, 3));
/*      */ 
/*      */     
/*  489 */     removeRecipe(ItemBow.class);
/*      */ 
/*      */     
/*  492 */     TFC_ConfigFiles.firstLoadCrafting();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerToolRecipes() {
/*  498 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.flintSteel, 1), new Object[] { Items.field_151145_ak, "ingotIron" }));
/*  499 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(new ItemStack(TFCItems.flintSteel, 1), new Object[] { Items.field_151145_ak, "ingotSteel" }));
/*      */     
/*  501 */     GameRegistry.addRecipe(new ItemStack(TFCItems.rope, 1), new Object[] { "RR ", "RR ", "  R", Character.valueOf('R'), new ItemStack(TFCItems.juteFiber, 1) });
/*      */     
/*  503 */     GameRegistry.addRecipe(new ItemStack(TFCItems.goldPan, 1, 0), new Object[] { "1", Character.valueOf('1'), new ItemStack(TFCItems.potteryBowl, 1, 1) });
/*      */     
/*  505 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.fireStarter, 1, 0), new Object[] { "2 ", " 2", Character.valueOf('2'), "stickWood" }));
/*      */     
/*  507 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bow, 1), new Object[] { " #$", "# $", " #$", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialString" }));
/*      */     
/*  509 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.fishingRod, 1), new Object[] { "  #", " #$", "# $", Character.valueOf('#'), "stickWood", Character.valueOf('$'), "materialString" }));
/*      */     
/*  511 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.spindle, 1), new Object[] { "P", "#", Character.valueOf('P'), new ItemStack(TFCItems.spindleHead, 1, 1), Character.valueOf('#'), "stickWood" }));
/*      */     
/*  513 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.spindleHead, 1, 0), new Object[] { "P", "#", Character.valueOf('P'), "lumpClay", Character.valueOf('#'), "stickWood" }));
/*      */ 
/*      */     
/*  516 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  517 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  518 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*  519 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneJavelinHead, Character.valueOf('2'), "stickWood" }));
/*      */ 
/*      */     
/*  522 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  523 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  524 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*  525 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneShovelHead, Character.valueOf('2'), "stickWood" }));
/*      */     
/*  527 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  528 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  529 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*  530 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneAxeHead, Character.valueOf('2'), "stickWood" }));
/*      */     
/*  532 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igInHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  533 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.sedHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  534 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.igExHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*  535 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.mMHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneHoeHead, Character.valueOf('2'), "stickWood" }));
/*      */ 
/*      */     
/*  538 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  539 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  540 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  541 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMShovel, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneShovelHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  543 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  544 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  545 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  546 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMAxe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneAxeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  548 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  549 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  550 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  551 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMHoe, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneHoeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */     
/*  553 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igInStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igInStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  554 */     GameRegistry.addRecipe(new ItemStack(TFCItems.sedStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.sedStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  555 */     GameRegistry.addRecipe(new ItemStack(TFCItems.igExStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.igExStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*  556 */     GameRegistry.addRecipe(new ItemStack(TFCItems.mMStoneJavelin, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.mMStoneJavelinHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) });
/*      */ 
/*      */     
/*  559 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneHammer, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneHammerHead, Character.valueOf('2'), "stickWood" }));
/*  560 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneHammer, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneHammerHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) }));
/*      */     
/*  562 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneKnife, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneKnifeHead, Character.valueOf('2'), "stickWood" }));
/*  563 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.stoneKnife, 1, 0), new Object[] { "1", "2", Character.valueOf('1'), TFCItems.stoneKnifeHead, Character.valueOf('2'), new ItemStack(Items.field_151103_aS) }));
/*      */ 
/*      */     
/*  566 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzePickaxeHead, 1, 0), 
/*  567 */             Character.valueOf('I'), "stickWood" }));
/*  568 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzePickaxeHead, 1, 0), 
/*  569 */             Character.valueOf('I'), "stickWood" }));
/*  570 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelPickaxeHead, 1, 0), 
/*  571 */             Character.valueOf('I'), "stickWood" }));
/*  572 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelPickaxeHead, 1, 0), 
/*  573 */             Character.valueOf('I'), "stickWood" }));
/*  574 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzePick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzePickaxeHead, 1, 0), 
/*  575 */             Character.valueOf('I'), "stickWood" }));
/*  576 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperPickaxeHead, 1, 0), 
/*  577 */             Character.valueOf('I'), "stickWood" }));
/*  578 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronPickaxeHead, 1, 0), 
/*  579 */             Character.valueOf('I'), "stickWood" }));
/*  580 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelPickaxeHead, 1, 0), 
/*  581 */             Character.valueOf('I'), "stickWood" }));
/*  582 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelPick, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelPickaxeHead, 1, 0), 
/*  583 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  586 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeShovelHead, 1, 0), 
/*  587 */             Character.valueOf('I'), "stickWood" }));
/*  588 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeShovelHead, 1, 0), 
/*  589 */             Character.valueOf('I'), "stickWood" }));
/*  590 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelShovelHead, 1, 0), 
/*  591 */             Character.valueOf('I'), "stickWood" }));
/*  592 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelShovelHead, 1, 0), 
/*  593 */             Character.valueOf('I'), "stickWood" }));
/*  594 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeShovelHead, 1, 0), 
/*  595 */             Character.valueOf('I'), "stickWood" }));
/*  596 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperShovelHead, 1, 0), 
/*  597 */             Character.valueOf('I'), "stickWood" }));
/*  598 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronShovelHead, 1, 0), 
/*  599 */             Character.valueOf('I'), "stickWood" }));
/*  600 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelShovelHead, 1, 0), 
/*  601 */             Character.valueOf('I'), "stickWood" }));
/*  602 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelShovel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelShovelHead, 1, 0), 
/*  603 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  606 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeHoeHead, 1, 0), 
/*  607 */             Character.valueOf('I'), "stickWood" }));
/*  608 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeHoeHead, 1, 0), 
/*  609 */             Character.valueOf('I'), "stickWood" }));
/*  610 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelHoeHead, 1, 0), 
/*  611 */             Character.valueOf('I'), "stickWood" }));
/*  612 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelHoeHead, 1, 0), 
/*  613 */             Character.valueOf('I'), "stickWood" }));
/*  614 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeHoeHead, 1, 0), 
/*  615 */             Character.valueOf('I'), "stickWood" }));
/*  616 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperHoeHead, 1, 0), 
/*  617 */             Character.valueOf('I'), "stickWood" }));
/*  618 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronHoeHead, 1, 0), 
/*  619 */             Character.valueOf('I'), "stickWood" }));
/*  620 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelHoeHead, 1, 0), 
/*  621 */             Character.valueOf('I'), "stickWood" }));
/*  622 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelHoe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelHoeHead, 1, 0), 
/*  623 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  626 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeAxeHead, 1, 0), 
/*  627 */             Character.valueOf('I'), "stickWood" }));
/*  628 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeAxeHead, 1, 0), 
/*  629 */             Character.valueOf('I'), "stickWood" }));
/*  630 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelAxeHead, 1, 0), 
/*  631 */             Character.valueOf('I'), "stickWood" }));
/*  632 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelAxeHead, 1, 0), 
/*  633 */             Character.valueOf('I'), "stickWood" }));
/*  634 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeAxeHead, 1, 0), 
/*  635 */             Character.valueOf('I'), "stickWood" }));
/*  636 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperAxeHead, 1, 0), 
/*  637 */             Character.valueOf('I'), "stickWood" }));
/*  638 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronAxeHead, 1, 0), 
/*  639 */             Character.valueOf('I'), "stickWood" }));
/*  640 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelAxeHead, 1, 0), 
/*  641 */             Character.valueOf('I'), "stickWood" }));
/*  642 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelAxe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelAxeHead, 1, 0), 
/*  643 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  646 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeSwordHead, 1, 0), 
/*  647 */             Character.valueOf('I'), "stickWood" }));
/*  648 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeSwordHead, 1, 0), 
/*  649 */             Character.valueOf('I'), "stickWood" }));
/*  650 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelSwordHead, 1, 0), 
/*  651 */             Character.valueOf('I'), "stickWood" }));
/*  652 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelSwordHead, 1, 0), 
/*  653 */             Character.valueOf('I'), "stickWood" }));
/*  654 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeSwordHead, 1, 0), 
/*  655 */             Character.valueOf('I'), "stickWood" }));
/*  656 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperSwordHead, 1, 0), 
/*  657 */             Character.valueOf('I'), "stickWood" }));
/*  658 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronSwordHead, 1, 0), 
/*  659 */             Character.valueOf('I'), "stickWood" }));
/*  660 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelSwordHead, 1, 0), 
/*  661 */             Character.valueOf('I'), "stickWood" }));
/*  662 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelSword, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelSwordHead, 1, 0), 
/*  663 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  666 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeMaceHead, 1, 0), 
/*  667 */             Character.valueOf('I'), "stickWood" }));
/*  668 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeMaceHead, 1, 0), 
/*  669 */             Character.valueOf('I'), "stickWood" }));
/*  670 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelMaceHead, 1, 0), 
/*  671 */             Character.valueOf('I'), "stickWood" }));
/*  672 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelMaceHead, 1, 0), 
/*  673 */             Character.valueOf('I'), "stickWood" }));
/*  674 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeMaceHead, 1, 0), 
/*  675 */             Character.valueOf('I'), "stickWood" }));
/*  676 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperMaceHead, 1, 0), 
/*  677 */             Character.valueOf('I'), "stickWood" }));
/*  678 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronMaceHead, 1, 0), 
/*  679 */             Character.valueOf('I'), "stickWood" }));
/*  680 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelMaceHead, 1, 0), 
/*  681 */             Character.valueOf('I'), "stickWood" }));
/*  682 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelMace, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelMaceHead, 1, 0), 
/*  683 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  686 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeHammerHead, 1, 0), 
/*  687 */             Character.valueOf('I'), "stickWood" }));
/*  688 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeHammerHead, 1, 0), 
/*  689 */             Character.valueOf('I'), "stickWood" }));
/*  690 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelHammerHead, 1, 0), 
/*  691 */             Character.valueOf('I'), "stickWood" }));
/*  692 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelHammerHead, 1, 0), 
/*  693 */             Character.valueOf('I'), "stickWood" }));
/*  694 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeHammerHead, 1, 0), 
/*  695 */             Character.valueOf('I'), "stickWood" }));
/*  696 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperHammerHead, 1, 0), 
/*  697 */             Character.valueOf('I'), "stickWood" }));
/*  698 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronHammerHead, 1, 0), 
/*  699 */             Character.valueOf('I'), "stickWood" }));
/*  700 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelHammerHead, 1, 0), 
/*  701 */             Character.valueOf('I'), "stickWood" }));
/*  702 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelHammer, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelHammerHead, 1, 0), 
/*  703 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  706 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeSawHead, 1, 0), 
/*  707 */             Character.valueOf('I'), "stickWood" }));
/*  708 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeSawHead, 1, 0), 
/*  709 */             Character.valueOf('I'), "stickWood" }));
/*  710 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelSawHead, 1, 0), 
/*  711 */             Character.valueOf('I'), "stickWood" }));
/*  712 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelSawHead, 1, 0), 
/*  713 */             Character.valueOf('I'), "stickWood" }));
/*  714 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeSawHead, 1, 0), 
/*  715 */             Character.valueOf('I'), "stickWood" }));
/*  716 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperSawHead, 1, 0), 
/*  717 */             Character.valueOf('I'), "stickWood" }));
/*  718 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronSawHead, 1, 0), 
/*  719 */             Character.valueOf('I'), "stickWood" }));
/*  720 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelSawHead, 1, 0), 
/*  721 */             Character.valueOf('I'), "stickWood" }));
/*  722 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelSaw, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelSawHead, 1, 0), 
/*  723 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  726 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeChiselHead, 1, 0), 
/*  727 */             Character.valueOf('I'), "stickWood" }));
/*  728 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeChiselHead, 1, 0), 
/*  729 */             Character.valueOf('I'), "stickWood" }));
/*  730 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelChiselHead, 1, 0), 
/*  731 */             Character.valueOf('I'), "stickWood" }));
/*  732 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelChiselHead, 1, 0), 
/*  733 */             Character.valueOf('I'), "stickWood" }));
/*  734 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeChiselHead, 1, 0), 
/*  735 */             Character.valueOf('I'), "stickWood" }));
/*  736 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperChiselHead, 1, 0), 
/*  737 */             Character.valueOf('I'), "stickWood" }));
/*  738 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronChiselHead, 1, 0), 
/*  739 */             Character.valueOf('I'), "stickWood" }));
/*  740 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelChiselHead, 1, 0), 
/*  741 */             Character.valueOf('I'), "stickWood" }));
/*  742 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelChisel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelChiselHead, 1, 0), 
/*  743 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  746 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBismuthBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeProPickHead, 1, 0), 
/*  747 */             Character.valueOf('I'), "stickWood" }));
/*  748 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlackBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeProPickHead, 1, 0), 
/*  749 */             Character.valueOf('I'), "stickWood" }));
/*  750 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlackSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelProPickHead, 1, 0), 
/*  751 */             Character.valueOf('I'), "stickWood" }));
/*  752 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBlueSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelProPickHead, 1, 0), 
/*  753 */             Character.valueOf('I'), "stickWood" }));
/*  754 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickBronze, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeProPickHead, 1, 0), 
/*  755 */             Character.valueOf('I'), "stickWood" }));
/*  756 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickCopper, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperProPickHead, 1, 0), 
/*  757 */             Character.valueOf('I'), "stickWood" }));
/*  758 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickIron, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronProPickHead, 1, 0), 
/*  759 */             Character.valueOf('I'), "stickWood" }));
/*  760 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickRedSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelProPickHead, 1, 0), 
/*  761 */             Character.valueOf('I'), "stickWood" }));
/*  762 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.proPickSteel, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelProPickHead, 1, 0), 
/*  763 */             Character.valueOf('I'), "stickWood" }));
/*      */     
/*  765 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeScytheHead, 1, 0), 
/*  766 */             Character.valueOf('I'), "stickWood" }));
/*  767 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeScytheHead, 1, 0), 
/*  768 */             Character.valueOf('I'), "stickWood" }));
/*  769 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelScytheHead, 1, 0), 
/*  770 */             Character.valueOf('I'), "stickWood" }));
/*  771 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelScytheHead, 1, 0), 
/*  772 */             Character.valueOf('I'), "stickWood" }));
/*  773 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeScytheHead, 1, 0), 
/*  774 */             Character.valueOf('I'), "stickWood" }));
/*  775 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperScytheHead, 1, 0), 
/*  776 */             Character.valueOf('I'), "stickWood" }));
/*  777 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronScytheHead, 1, 0), 
/*  778 */             Character.valueOf('I'), "stickWood" }));
/*  779 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelScytheHead, 1, 0), 
/*  780 */             Character.valueOf('I'), "stickWood" }));
/*  781 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelScythe, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelScytheHead, 1, 0), 
/*  782 */             Character.valueOf('I'), "stickWood" }));
/*      */     
/*  784 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeKnifeHead, 1, 0), 
/*  785 */             Character.valueOf('I'), "stickWood" }));
/*  786 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeKnifeHead, 1, 0), 
/*  787 */             Character.valueOf('I'), "stickWood" }));
/*  788 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelKnifeHead, 1, 0), 
/*  789 */             Character.valueOf('I'), "stickWood" }));
/*  790 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelKnifeHead, 1, 0), 
/*  791 */             Character.valueOf('I'), "stickWood" }));
/*  792 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeKnifeHead, 1, 0), 
/*  793 */             Character.valueOf('I'), "stickWood" }));
/*  794 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperKnifeHead, 1, 0), 
/*  795 */             Character.valueOf('I'), "stickWood" }));
/*  796 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronKnifeHead, 1, 0), 
/*  797 */             Character.valueOf('I'), "stickWood" }));
/*  798 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelKnifeHead, 1, 0), 
/*  799 */             Character.valueOf('I'), "stickWood" }));
/*  800 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelKnife, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelKnifeHead, 1, 0), 
/*  801 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  804 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bismuthBronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bismuthBronzeJavelinHead, 1, 0), 
/*  805 */             Character.valueOf('I'), "stickWood" }));
/*  806 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackBronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackBronzeJavelinHead, 1, 0), 
/*  807 */             Character.valueOf('I'), "stickWood" }));
/*  808 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blackSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blackSteelJavelinHead, 1, 0), 
/*  809 */             Character.valueOf('I'), "stickWood" }));
/*  810 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.blueSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.blueSteelJavelinHead, 1, 0), 
/*  811 */             Character.valueOf('I'), "stickWood" }));
/*  812 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.bronzeJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.bronzeJavelinHead, 1, 0), 
/*  813 */             Character.valueOf('I'), "stickWood" }));
/*  814 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.copperJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.copperJavelinHead, 1, 0), 
/*  815 */             Character.valueOf('I'), "stickWood" }));
/*  816 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.wroughtIronJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.wroughtIronJavelinHead, 1, 0), 
/*  817 */             Character.valueOf('I'), "stickWood" }));
/*  818 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.redSteelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.redSteelJavelinHead, 1, 0), 
/*  819 */             Character.valueOf('I'), "stickWood" }));
/*  820 */     GameRegistry.addRecipe((IRecipe)new ShapedOreRecipe(new ItemStack(TFCItems.steelJavelin, 1), new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(TFCItems.steelJavelinHead, 1, 0), 
/*  821 */             Character.valueOf('I'), "stickWood" }));
/*      */ 
/*      */     
/*  824 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1), new Object[] { "     ", " ### ", "#   #", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  825 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  826 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1), new Object[] { "     ", "#####", "   ##", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  827 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  828 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1), new Object[] { "     ", "#####", "#####", "  #  ", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  829 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1), new Object[] { "  #  ", "  #  ", "  #  ", "  #  ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  830 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1), new Object[] { "   ##", "  ###", " ### ", " ##  ", "#    ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  831 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1), new Object[] { "  #  ", " ### ", " ### ", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  832 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1), new Object[] { "##   ", "###  ", " ### ", " ####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  833 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1), new Object[] { "     ", " ####", "#   #", "    #", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  834 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1), new Object[] { "     ", "#### ", " ####", "   ##", "     ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  835 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1), new Object[] { "  # ", " ## ", " ## ", " ## ", " ## ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  836 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*      */     
/*  838 */     registerAlloys();
/*      */     
/*  840 */     registerKnapping();
/*      */ 
/*      */     
/*  843 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherHelmet, 1), new Object[] { "#####", "#   #", "#   #", Character.valueOf('#'), TFCItems.flatLeather });
/*  844 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherChestplate, 1), new Object[] { "#   #", "#####", "#####", "#####", "#####", Character.valueOf('#'), TFCItems.flatLeather });
/*  845 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherLeggings, 1), new Object[] { "#####", "#####", "## ##", "## ##", "## ##", Character.valueOf('#'), TFCItems.flatLeather });
/*  846 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.leatherBoots, 1), new Object[] { "##   ", "##   ", "##   ", "#### ", "#####", Character.valueOf('#'), TFCItems.flatLeather });
/*      */     
/*  848 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.quiver, 1), new Object[] { " ####", "# ###", "# ###", "# ###", " ####", Character.valueOf('#'), TFCItems.flatLeather });
/*  849 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.field_151141_av, 1), new Object[] { "  #  ", "#####", "#####", "#####", "  #  ", Character.valueOf('#'), TFCItems.flatLeather });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerKnapping() {
/*  855 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { " #  #", "## ##", "## ##", "## ##", "## ##", 
/*  856 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  857 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { "#  # ", "## ##", "## ##", "## ##", "## ##", 
/*  858 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  859 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { "#   #", "## ##", "## ##", "## ##", "## ##", 
/*  860 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  861 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 2), new Object[] { " # # ", "## ##", "## ##", "## ##", "## ##", 
/*  862 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  863 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneKnifeHead, 1), new Object[] { " #", "##", "##", "##", "##", 
/*  864 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*  865 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.stoneHammerHead, 1), new Object[] { "#####", "#####", "  #  ", 
/*  866 */           Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, 32767) });
/*      */     int i;
/*  868 */     for (i = 0; i < Global.STONE_IGIN.length; i++) {
/*      */       
/*  870 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  871 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  872 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*  873 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igInStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + 0) });
/*      */     } 
/*  875 */     for (i = 0; i < Global.STONE_SED.length; i++) {
/*      */       
/*  877 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  878 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  879 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*  880 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.sedStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_SED_START) });
/*      */     } 
/*  882 */     for (i = 0; i < Global.STONE_IGEX.length; i++) {
/*      */       
/*  884 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  885 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  886 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*  887 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.igExStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_IGEX_START) });
/*      */     } 
/*  889 */     for (i = 0; i < Global.STONE_MM.length; i++) {
/*      */       
/*  891 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneShovelHead, 1), new Object[] { "###", "###", "###", "###", " # ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  892 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneAxeHead, 1), new Object[] { " #   ", "#### ", "#####", "#### ", " #   ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  893 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneHoeHead, 1), new Object[] { "#####", "   ##", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*  894 */       CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.mMStoneJavelinHead, 1), new Object[] { "###  ", "#### ", "#####", " ### ", "  #  ", Character.valueOf('#'), new ItemStack(TFCItems.flatRock, 1, i + Global.STONE_MM_START) });
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  899 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.ceramicMold, 2, 0), new Object[] { "    ", " ## ", " ## ", " ## ", "    ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  904 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  905 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.potteryJug, 1, 0), new Object[] { "X XXX", "    X", "   X ", "    X", "   XX", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  910 */           Character.valueOf('X'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  911 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), new Object[] { "#   #", "     ", "     ", "     ", "#   #", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  916 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  917 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.flowerPot), new Object[] { "#   #", " ### ", " ### ", " ### ", "#   #", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  922 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
/*  923 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.crucible, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "     ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  928 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 3) });
/*  929 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCBlocks.vessel, 1), new Object[] { " ### ", " ### ", " ### ", " ### ", "     ", 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  934 */           Character.valueOf('#'), new ItemStack(TFCItems.flatClay, 1, 1) });
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
/*  949 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.tinUnshaped), new ItemStack(TFCItems.bismuthUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  953 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.zincUnshaped), new ItemStack(TFCItems.bismuthUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  957 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.blackBronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.goldUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  961 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.steelUnshaped), new ItemStack(TFCItems.steelUnshaped), new ItemStack(TFCItems.nickelUnshaped), new ItemStack(TFCItems.blackBronzeUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  965 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakBlueSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.blackSteelUnshaped), new ItemStack(TFCItems.bismuthBronzeUnshaped), new ItemStack(TFCItems.sterlingSilverUnshaped), new ItemStack(TFCItems.steelUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  969 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.brassUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.zincUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  973 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.bronzeUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.tinUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  977 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.weakRedSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.blackSteelUnshaped), new ItemStack(TFCItems.roseGoldUnshaped), new ItemStack(TFCItems.brassUnshaped), new ItemStack(TFCItems.steelUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  981 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.roseGoldUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.goldUnshaped), new ItemStack(TFCItems.goldUnshaped), new ItemStack(TFCItems.goldUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  985 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.highCarbonSteelUnshaped, 4), new Object[] { new ItemStack(TFCItems.pigIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped), new ItemStack(TFCItems.wroughtIronUnshaped) });
/*      */ 
/*      */ 
/*      */     
/*  989 */     CraftingManagerTFC.getInstance().addShapelessRecipe(new ItemStack(TFCItems.sterlingSilverUnshaped, 4), new Object[] { new ItemStack(TFCItems.copperUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.silverUnshaped), new ItemStack(TFCItems.silverUnshaped) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerToolMolds() {
/*  999 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 2), new Object[] { "12", 
/* 1000 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/* 1001 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 3), new Object[] { "12", 
/* 1002 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/* 1003 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 4), new Object[] { "12", 
/* 1004 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/* 1005 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 5), new Object[] { "12", 
/* 1006 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
/*      */     
/* 1008 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 2), new Object[] { "12", 
/* 1009 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/* 1010 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 3), new Object[] { "12", 
/* 1011 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/* 1012 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 4), new Object[] { "12", 
/* 1013 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/* 1014 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 5), new Object[] { "12", 
/* 1015 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldChisel, 1, 1) });
/*      */     
/* 1017 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 2), new Object[] { "12", 
/* 1018 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/* 1019 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 3), new Object[] { "12", 
/* 1020 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/* 1021 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 4), new Object[] { "12", 
/* 1022 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/* 1023 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 5), new Object[] { "12", 
/* 1024 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHammer, 1, 1) });
/*      */     
/* 1026 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 2), new Object[] { "12", 
/* 1027 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/* 1028 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 3), new Object[] { "12", 
/* 1029 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/* 1030 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 4), new Object[] { "12", 
/* 1031 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/* 1032 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 5), new Object[] { "12", 
/* 1033 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldHoe, 1, 1) });
/*      */     
/* 1035 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 2), new Object[] { "12", 
/* 1036 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1037 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 3), new Object[] { "12", 
/* 1038 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1039 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 4), new Object[] { "12", 
/* 1040 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/* 1041 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 5), new Object[] { "12", 
/* 1042 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldKnife, 1, 1) });
/*      */     
/* 1044 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 2), new Object[] { "12", 
/* 1045 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1046 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 3), new Object[] { "12", 
/* 1047 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1048 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 4), new Object[] { "12", 
/* 1049 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/* 1050 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 5), new Object[] { "12", 
/* 1051 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldJavelin, 1, 1) });
/*      */     
/* 1053 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 2), new Object[] { "12", 
/* 1054 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1055 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 3), new Object[] { "12", 
/* 1056 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1057 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 4), new Object[] { "12", 
/* 1058 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/* 1059 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 5), new Object[] { "12", 
/* 1060 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldMace, 1, 1) });
/*      */     
/* 1062 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 2), new Object[] { "12", 
/* 1063 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1064 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 3), new Object[] { "12", 
/* 1065 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1066 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 4), new Object[] { "12", 
/* 1067 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/* 1068 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 5), new Object[] { "12", 
/* 1069 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldPick, 1, 1) });
/*      */     
/* 1071 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 2), new Object[] { "12", 
/* 1072 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1073 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 3), new Object[] { "12", 
/* 1074 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1075 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 4), new Object[] { "12", 
/* 1076 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/* 1077 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 5), new Object[] { "12", 
/* 1078 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldProPick, 1, 1) });
/*      */     
/* 1080 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 2), new Object[] { "12", 
/* 1081 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1082 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 3), new Object[] { "12", 
/* 1083 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1084 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 4), new Object[] { "12", 
/* 1085 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/* 1086 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 5), new Object[] { "12", 
/* 1087 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSaw, 1, 1) });
/*      */     
/* 1089 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 2), new Object[] { "12", 
/* 1090 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1091 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 3), new Object[] { "12", 
/* 1092 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1093 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 4), new Object[] { "12", 
/* 1094 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/* 1095 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 5), new Object[] { "12", 
/* 1096 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldScythe, 1, 1) });
/*      */     
/* 1098 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 2), new Object[] { "12", 
/* 1099 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1100 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 3), new Object[] { "12", 
/* 1101 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1102 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 4), new Object[] { "12", 
/* 1103 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/* 1104 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 5), new Object[] { "12", 
/* 1105 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldShovel, 1, 1) });
/*      */     
/* 1107 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 2), new Object[] { "12", 
/* 1108 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1109 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 3), new Object[] { "12", 
/* 1110 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1111 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 4), new Object[] { "12", 
/* 1112 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/* 1113 */     CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 5), new Object[] { "12", 
/* 1114 */           Character.valueOf('1'), getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), Character.valueOf('2'), new ItemStack(TFCItems.clayMoldSword, 1, 1) });
/*      */ 
/*      */ 
/*      */     
/* 1118 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperAxeHead), new Object[] {
/* 1119 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 2)) });
/* 1120 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeAxeHead), new Object[] {
/* 1121 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 3)) });
/* 1122 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeAxeHead), new Object[] {
/* 1123 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 4)) });
/* 1124 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeAxeHead), new Object[] {
/* 1125 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldAxe, 1, 5))
/*      */         });
/* 1127 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperChiselHead), new Object[] {
/* 1128 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 2)) });
/* 1129 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeChiselHead), new Object[] {
/* 1130 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 3)) });
/* 1131 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeChiselHead), new Object[] {
/* 1132 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 4)) });
/* 1133 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeChiselHead), new Object[] {
/* 1134 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldChisel, 1, 5))
/*      */         });
/* 1136 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperHammerHead), new Object[] {
/* 1137 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 2)) });
/* 1138 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeHammerHead), new Object[] {
/* 1139 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 3)) });
/* 1140 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeHammerHead), new Object[] {
/* 1141 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 4)) });
/* 1142 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeHammerHead), new Object[] {
/* 1143 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHammer, 1, 5))
/*      */         });
/* 1145 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperHoeHead), new Object[] {
/* 1146 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 2)) });
/* 1147 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeHoeHead), new Object[] {
/* 1148 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 3)) });
/* 1149 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeHoeHead), new Object[] {
/* 1150 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 4)) });
/* 1151 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeHoeHead), new Object[] {
/* 1152 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldHoe, 1, 5))
/*      */         });
/* 1154 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperKnifeHead), new Object[] {
/* 1155 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 2)) });
/* 1156 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeKnifeHead), new Object[] {
/* 1157 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 3)) });
/* 1158 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeKnifeHead), new Object[] {
/* 1159 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 4)) });
/* 1160 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeKnifeHead), new Object[] {
/* 1161 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldKnife, 1, 5))
/*      */         });
/* 1163 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperJavelinHead), new Object[] {
/* 1164 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 2)) });
/* 1165 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeJavelinHead), new Object[] {
/* 1166 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 3)) });
/* 1167 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeJavelinHead), new Object[] {
/* 1168 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 4)) });
/* 1169 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeJavelinHead), new Object[] {
/* 1170 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldJavelin, 1, 5))
/*      */         });
/* 1172 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperMaceHead), new Object[] {
/* 1173 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 2)) });
/* 1174 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeMaceHead), new Object[] {
/* 1175 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 3)) });
/* 1176 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeMaceHead), new Object[] {
/* 1177 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 4)) });
/* 1178 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeMaceHead), new Object[] {
/* 1179 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldMace, 1, 5))
/*      */         });
/* 1181 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperPickaxeHead), new Object[] {
/* 1182 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 2)) });
/* 1183 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzePickaxeHead), new Object[] {
/* 1184 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 3)) });
/* 1185 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzePickaxeHead), new Object[] {
/* 1186 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 4)) });
/* 1187 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzePickaxeHead), new Object[] {
/* 1188 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldPick, 1, 5))
/*      */         });
/* 1190 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperProPickHead), new Object[] {
/* 1191 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 2)) });
/* 1192 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeProPickHead), new Object[] {
/* 1193 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 3)) });
/* 1194 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeProPickHead), new Object[] {
/* 1195 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 4)) });
/* 1196 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeProPickHead), new Object[] {
/* 1197 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldProPick, 1, 5))
/*      */         });
/* 1199 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperSawHead), new Object[] {
/* 1200 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 2)) });
/* 1201 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeSawHead), new Object[] {
/* 1202 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 3)) });
/* 1203 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeSawHead), new Object[] {
/* 1204 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 4)) });
/* 1205 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeSawHead), new Object[] {
/* 1206 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSaw, 1, 5))
/*      */         });
/* 1208 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperScytheHead), new Object[] {
/* 1209 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 2)) });
/* 1210 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeScytheHead), new Object[] {
/* 1211 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 3)) });
/* 1212 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeScytheHead), new Object[] {
/* 1213 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 4)) });
/* 1214 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeScytheHead), new Object[] {
/* 1215 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldScythe, 1, 5))
/*      */         });
/* 1217 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperShovelHead), new Object[] {
/* 1218 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 2)) });
/* 1219 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeShovelHead), new Object[] {
/* 1220 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 3)) });
/* 1221 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeShovelHead), new Object[] {
/* 1222 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 4)) });
/* 1223 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeShovelHead), new Object[] {
/* 1224 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldShovel, 1, 5))
/*      */         });
/* 1226 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperSwordHead), new Object[] {
/* 1227 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 2)) });
/* 1228 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeSwordHead), new Object[] {
/* 1229 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 3)) });
/* 1230 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeSwordHead), new Object[] {
/* 1231 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 4)) });
/* 1232 */     GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeSwordHead), new Object[] {
/* 1233 */           getStackNoTemp(new ItemStack(TFCItems.clayMoldSword, 1, 5))
/*      */         });
/*      */   }
/*      */   
/*      */   public static ItemStack getStackTemp(ItemStack is) {
/* 1238 */     NBTTagCompound nbt = new NBTTagCompound();
/* 1239 */     nbt.func_74757_a("temp", true);
/* 1240 */     is.func_77982_d(nbt);
/* 1241 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ItemStack getStackNoTemp(ItemStack is) {
/* 1246 */     NBTTagCompound noTemp = new NBTTagCompound();
/* 1247 */     noTemp.func_74757_a("noTemp", true);
/* 1248 */     is.func_77982_d(noTemp);
/* 1249 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerAnvilRecipes(Random r, World world) {
/* 1254 */     AnvilManager manager = AnvilManager.getInstance();
/*      */     
/* 1256 */     AnvilManager.world = world;
/*      */     
/* 1258 */     manager.addPlan("ingot", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/*      */     
/* 1260 */     manager.addPlan("sheet", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/*      */     
/* 1262 */     manager.addPlan("block", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/*      */     
/* 1264 */     manager.addPlan("pickaxe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.BENDNOTLAST, RuleEnum.DRAWNOTLAST }));
/*      */     
/* 1266 */     manager.addPlan("shovel", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITNOTLAST, RuleEnum.ANY }));
/*      */     
/* 1268 */     manager.addPlan("axe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.UPSETTHIRDFROMLAST }));
/* 1269 */     manager.addPlan("hoe", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.HITNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1270 */     manager.addPlan("hammer", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.ANY, RuleEnum.SHRINKNOTLAST }));
/* 1271 */     manager.addPlan("chisel", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITNOTLAST, RuleEnum.DRAWNOTLAST }));
/* 1272 */     manager.addPlan("propick", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.DRAWNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1273 */     manager.addPlan("saw", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.ANY }));
/* 1274 */     manager.addPlan("sword", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1275 */     manager.addPlan("mace", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.SHRINKNOTLAST, RuleEnum.BENDNOTLAST }));
/* 1276 */     manager.addPlan("scythe", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1277 */     manager.addPlan("knife", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1278 */     manager.addPlan("javelin", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1279 */     manager.addPlan("helmplate", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1280 */     manager.addPlan("chestplate", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.UPSETTHIRDFROMLAST }));
/* 1281 */     manager.addPlan("legsplate", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDANY, RuleEnum.DRAWANY, RuleEnum.HITANY }));
/* 1282 */     manager.addPlan("bootsplate", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.SHRINKTHIRDFROMLAST }));
/* 1283 */     manager.addPlan("bucket", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/* 1284 */     manager.addPlan("refinebloom", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/* 1285 */     manager.addPlan("splitbloom", new PlanRecipe(new RuleEnum[] { RuleEnum.PUNCHLAST, RuleEnum.ANY, RuleEnum.ANY }));
/* 1286 */     manager.addPlan("tuyere", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.ANY }));
/* 1287 */     manager.addPlan("trapdoor", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.SHRINKNOTLAST, RuleEnum.UPSETNOTLAST }));
/* 1288 */     manager.addPlan("grill", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1289 */     manager.addPlan("shears", new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.HITTHIRDFROMLAST }));
/* 1290 */     manager.addPlan("oillamp", new PlanRecipe(new RuleEnum[] { RuleEnum.BENDLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.DRAWTHIRDFROMLAST }));
/* 1291 */     manager.addPlan("hopper", new PlanRecipe(new RuleEnum[] { RuleEnum.UPSETLAST, RuleEnum.HITSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST }));
/*      */     
/* 1293 */     addWeldRecipes(manager);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1299 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot), null, "ingot", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.highCarbonSteelIngot))).clearRecipeSkills());
/*      */     
/* 1301 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonBlackSteelIngot), null, "ingot", false, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelIngot))).clearRecipeSkills());
/* 1302 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonBlueSteelIngot), null, "ingot", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelIngot))).clearRecipeSkills());
/* 1303 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonRedSteelIngot), null, "ingot", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelIngot))).clearRecipeSkills());
/* 1304 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.highCarbonSteelIngot), null, "ingot", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelIngot))).clearRecipeSkills());
/*      */     
/* 1306 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.bismuthSheet)));
/* 1307 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "sheet", false, AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSheet)));
/* 1308 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "sheet", false, AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSheet)));
/* 1309 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "sheet", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSheet)));
/* 1310 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "sheet", false, AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSheet)));
/* 1311 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.brassSheet)));
/* 1312 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSheet)));
/* 1313 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.copperSheet)));
/* 1314 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.goldSheet)));
/* 1315 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "sheet", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSheet)));
/* 1316 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.leadSheet)));
/* 1317 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelIngot2x), null, "sheet", false, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelSheet)));
/* 1318 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronSheet)));
/* 1319 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.platinumSheet)));
/* 1320 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "sheet", false, AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSheet)));
/* 1321 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.roseGoldSheet)));
/* 1322 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.silverSheet)));
/* 1323 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "sheet", false, AnvilReq.STEEL, new ItemStack(TFCItems.steelSheet)));
/* 1324 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot2x), null, "sheet", false, AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverSheet)));
/* 1325 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.tinSheet)));
/* 1326 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincIngot2x), null, "sheet", false, AnvilReq.STONE, new ItemStack(TFCItems.zincSheet)));
/* 1327 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.electrumIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.electrumSheet)));
/* 1328 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.cupronickelIngot2x), null, "sheet", false, AnvilReq.COPPER, new ItemStack(TFCItems.cupronickelSheet)));
/*      */ 
/*      */ 
/*      */     
/* 1332 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthSheet2x), new ItemStack(TFCItems.bismuthSheet2x), "block", AnvilReq.STONE, new ItemStack(TFCBlocks.metalBlock, 1, 0))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1333 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), new ItemStack(TFCItems.bismuthBronzeSheet2x), "block", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 1))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1334 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), new ItemStack(TFCItems.blackBronzeSheet2x), "block", AnvilReq.BLACKBRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 2))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1335 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), new ItemStack(TFCItems.blackSteelSheet2x), "block", AnvilReq.BLACKSTEEL, new ItemStack(TFCBlocks.metalBlock, 1, 3))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1336 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), new ItemStack(TFCItems.blueSteelSheet2x), "block", AnvilReq.BLUESTEEL, new ItemStack(TFCBlocks.metalBlock, 1, 4))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1337 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.brassSheet2x), new ItemStack(TFCItems.brassSheet2x), "block", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalBlock, 1, 5))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1338 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), new ItemStack(TFCItems.bronzeSheet2x), "block", AnvilReq.BRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 6))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1339 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), new ItemStack(TFCItems.copperSheet2x), "block", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalBlock, 1, 7))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1340 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.goldSheet2x), new ItemStack(TFCItems.goldSheet2x), "block", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalBlock, 1, 8))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1341 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), new ItemStack(TFCItems.wroughtIronSheet2x), "block", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.metalBlock, 1, 9))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1342 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.leadSheet2x), new ItemStack(TFCItems.leadSheet2x), "block", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalBlock, 1, 10))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1343 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.nickelSheet2x), new ItemStack(TFCItems.nickelSheet2x), "block", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.metalBlock, 1, 11))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1344 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.pigIronSheet2x), new ItemStack(TFCItems.pigIronSheet2x), "block", AnvilReq.BRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 12))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1345 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.platinumSheet2x), new ItemStack(TFCItems.platinumSheet2x), "block", AnvilReq.BRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 13))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1346 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), new ItemStack(TFCItems.redSteelSheet2x), "block", AnvilReq.REDSTEEL, new ItemStack(TFCBlocks.metalBlock, 1, 14))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1347 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.roseGoldSheet2x), new ItemStack(TFCItems.roseGoldSheet2x), "block", AnvilReq.BRONZE, new ItemStack(TFCBlocks.metalBlock, 1, 15))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1348 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.silverSheet2x), new ItemStack(TFCItems.silverSheet2x), "block", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalBlock2, 1, 0))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1349 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), new ItemStack(TFCItems.steelSheet2x), "block", AnvilReq.STEEL, new ItemStack(TFCBlocks.metalBlock2, 1, 1))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1350 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverSheet2x), new ItemStack(TFCItems.sterlingSilverSheet2x), "block", AnvilReq.BRONZE, new ItemStack(TFCBlocks.metalBlock2, 1, 2))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1351 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.tinSheet2x), new ItemStack(TFCItems.tinSheet2x), "block", AnvilReq.STONE, new ItemStack(TFCBlocks.metalBlock2, 1, 3))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1352 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.zincSheet2x), new ItemStack(TFCItems.zincSheet2x), "block", AnvilReq.STONE, new ItemStack(TFCBlocks.metalBlock2, 1, 4))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1353 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.electrumSheet2x), new ItemStack(TFCItems.electrumSheet2x), "block", AnvilReq.STONE, new ItemStack(TFCBlocks.metalBlock2, 1, 5))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/* 1354 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.cupronickelSheet2x), new ItemStack(TFCItems.cupronickelSheet2x), "block", AnvilReq.STONE, new ItemStack(TFCBlocks.metalBlock2, 1, 6))).addRecipeSkill("skill.gensmith").setCraftingXP(1));
/*      */ 
/*      */     
/* 1357 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "pickaxe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1358 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "pickaxe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1359 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "pickaxe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1360 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "pickaxe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1361 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "pickaxe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzePickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1362 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "pickaxe", AnvilReq.COPPER, new ItemStack(TFCItems.copperPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1363 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "pickaxe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1364 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "pickaxe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1365 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "pickaxe", AnvilReq.STEEL, new ItemStack(TFCItems.steelPickaxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */ 
/*      */     
/* 1369 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "shovel", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1370 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "shovel", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1371 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "shovel", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1372 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "shovel", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1373 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "shovel", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1374 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "shovel", AnvilReq.COPPER, new ItemStack(TFCItems.copperShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1375 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "shovel", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1376 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "shovel", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1377 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "shovel", AnvilReq.STEEL, new ItemStack(TFCItems.steelShovelHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1380 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "axe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1381 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "axe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1382 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "axe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1383 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "axe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1384 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "axe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1385 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "axe", AnvilReq.COPPER, new ItemStack(TFCItems.copperAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1386 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "axe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1387 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "axe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1388 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "axe", AnvilReq.STEEL, new ItemStack(TFCItems.steelAxeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1391 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "hoe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1392 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "hoe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1393 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "hoe", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1394 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "hoe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1395 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "hoe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1396 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "hoe", AnvilReq.COPPER, new ItemStack(TFCItems.copperHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1397 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "hoe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1398 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "hoe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1399 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "hoe", AnvilReq.STEEL, new ItemStack(TFCItems.steelHoeHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1402 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "hammer", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1403 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "hammer", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1404 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "hammer", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1405 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "hammer", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1406 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "hammer", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1407 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "hammer", AnvilReq.COPPER, new ItemStack(TFCItems.copperHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1408 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "hammer", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1409 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "hammer", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1410 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "hammer", AnvilReq.STEEL, new ItemStack(TFCItems.steelHammerHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1413 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "chisel", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1414 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "chisel", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1415 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "chisel", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1416 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "chisel", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1417 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "chisel", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1418 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "chisel", AnvilReq.COPPER, new ItemStack(TFCItems.copperChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1419 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "chisel", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1420 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "chisel", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1421 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "chisel", AnvilReq.STEEL, new ItemStack(TFCItems.steelChiselHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1424 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "propick", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1425 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "propick", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1426 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "propick", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1427 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "propick", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1428 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "propick", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1429 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "propick", AnvilReq.COPPER, new ItemStack(TFCItems.copperProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1430 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "propick", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1431 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "propick", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1432 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "propick", AnvilReq.STEEL, new ItemStack(TFCItems.steelProPickHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1435 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "saw", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1436 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "saw", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1437 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "saw", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1438 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "saw", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1439 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "saw", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1440 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "saw", AnvilReq.COPPER, new ItemStack(TFCItems.copperSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1441 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "saw", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1442 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "saw", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1443 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "saw", AnvilReq.STEEL, new ItemStack(TFCItems.steelSawHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1446 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "sword", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1447 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "sword", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1448 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "sword", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1449 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "sword", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1450 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "sword", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1451 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "sword", AnvilReq.COPPER, new ItemStack(TFCItems.copperSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1452 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "sword", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1453 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "sword", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1454 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "sword", AnvilReq.STEEL, new ItemStack(TFCItems.steelSwordHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */ 
/*      */ 
/*      */     
/* 1458 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot2x), null, "mace", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1459 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot2x), null, "mace", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1460 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot2x), null, "mace", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1461 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot2x), null, "mace", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1462 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot2x), null, "mace", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1463 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot2x), null, "mace", AnvilReq.COPPER, new ItemStack(TFCItems.copperMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1464 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), null, "mace", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1465 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot2x), null, "mace", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1466 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot2x), null, "mace", AnvilReq.STEEL, new ItemStack(TFCItems.steelMaceHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */ 
/*      */     
/* 1469 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "scythe", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1470 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "scythe", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1471 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "scythe", false, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1472 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "scythe", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1473 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "scythe", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1474 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "scythe", AnvilReq.COPPER, new ItemStack(TFCItems.copperScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1475 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "scythe", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1476 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "scythe", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/* 1477 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "scythe", AnvilReq.STEEL, new ItemStack(TFCItems.steelScytheHead, 1))).addRecipeSkill("skill.toolsmith"));
/*      */ 
/*      */     
/* 1480 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "knife", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1481 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "knife", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1482 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "knife", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1483 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "knife", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1484 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "knife", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1485 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "knife", AnvilReq.COPPER, new ItemStack(TFCItems.copperKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1486 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "knife", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronKnifeHead, 1))).setCraftingBound(40));
/* 1487 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "knife", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/* 1488 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "knife", AnvilReq.STEEL, new ItemStack(TFCItems.steelKnifeHead, 1))).addRecipeSkill("skill.weaponsmith").setCraftingBound(40));
/*      */ 
/*      */ 
/*      */     
/* 1492 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), null, "javelin", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1493 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), null, "javelin", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1494 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), null, "javelin", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1495 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), null, "javelin", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1496 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "javelin", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1497 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), null, "javelin", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1498 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelIngot), null, "javelin", AnvilReq.STEEL, new ItemStack(TFCItems.steelJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1499 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), null, "javelin", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/* 1500 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperIngot), null, "javelin", AnvilReq.COPPER, new ItemStack(TFCItems.copperJavelinHead, 1))).addRecipeSkill("skill.weaponsmith"));
/*      */     
/* 1502 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), null, "helmPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1503 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), null, "helmPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1504 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), null, "helmPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1505 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "helmPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1506 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), null, "helmPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1507 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet), null, "helmPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1508 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "helmPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1509 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "helmPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1510 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "helmPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1512 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1513 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1514 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1515 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1516 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1517 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1518 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1519 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1520 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 1), null, "helmPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelHelmet, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/*      */     
/* 1522 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "chestPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1523 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "chestPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1524 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "chestPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1525 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "chestPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1526 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "chestPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1527 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "chestPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1528 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "chestPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1529 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "chestPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1530 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "chestPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1532 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1533 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1534 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1535 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1536 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1537 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1538 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1539 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1540 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 1), null, "chestPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelChestplate, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/*      */     
/* 1542 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "legsPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1543 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "legsPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1544 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "legsPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1545 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "legsPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1546 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "legsPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1547 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "legsPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1548 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "legsPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1549 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "legsPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1550 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "legsPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1552 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1553 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1554 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1555 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1556 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1557 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.COPPER, new ItemStack(TFCItems.copperGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1558 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1559 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/* 1560 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 1), null, "legsPlate", AnvilReq.STEEL, new ItemStack(TFCItems.steelGreaves, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(3));
/*      */     
/* 1562 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), null, "bootsplate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1563 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), null, "bootsplate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1564 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), null, "bootsplate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1565 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "bootsplate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1566 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), null, "bootsplate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1567 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperSheet), null, "bootsplate", AnvilReq.COPPER, new ItemStack(TFCItems.copperUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1568 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), null, "bootsplate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1569 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "bootsplate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/* 1570 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelSheet), null, "bootsplate", AnvilReq.STEEL, new ItemStack(TFCItems.steelUnfinishedBoots, 1, 0))).addRecipeSkill("skill.armorsmith"));
/*      */     
/* 1572 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BISMUTHBRONZE, new ItemStack(TFCItems.bismuthBronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1573 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLACKBRONZE, new ItemStack(TFCItems.blackBronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1574 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blackSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1575 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1576 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.BRONZE, new ItemStack(TFCItems.bronzeBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1577 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.COPPER, new ItemStack(TFCItems.copperBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1578 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.wroughtIronBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1579 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/* 1580 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 1), null, "bootsplate", AnvilReq.STEEL, new ItemStack(TFCItems.steelBoots, 1))).addRecipeSkill("skill.armorsmith").setCraftingXP(2));
/*      */ 
/*      */ 
/*      */     
/* 1584 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), null, "bucket", AnvilReq.REDSTEEL, new ItemStack(TFCItems.redSteelBucketEmpty, 1)));
/* 1585 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), null, "bucket", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.blueSteelBucketEmpty, 1)));
/*      */     
/* 1587 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.rawBloom, 1, 32767), null, "refinebloom", AnvilReq.BRONZE, new ItemStack(TFCItems.bloom, 1))).setInheritsDamage().clearRecipeSkills());
/* 1588 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bloom, 1, 100), null, "refinebloom", AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronIngot, 1))).clearRecipeSkills());
/* 1589 */     manager.addRecipe((new AnvilRecipe(new ItemStack(TFCItems.bloom, 1, 32767), null, "splitbloom", AnvilReq.BRONZE, new ItemStack(TFCItems.bloom, 1))).clearRecipeSkills());
/*      */ 
/*      */     
/* 1592 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperSheet2x), null, "tuyere", AnvilReq.COPPER, new ItemStack(TFCItems.tuyereCopper, 1)));
/* 1593 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBronze, 1)));
/* 1594 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBismuthBronze, 1)));
/* 1595 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet2x), null, "tuyere", AnvilReq.BRONZE, new ItemStack(TFCItems.tuyereBlackBronze, 1)));
/* 1596 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), null, "tuyere", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.tuyereWroughtIron, 1)));
/* 1597 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet2x), null, "tuyere", AnvilReq.STEEL, new ItemStack(TFCItems.tuyereSteel, 1)));
/* 1598 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet2x), null, "tuyere", AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.tuyereBlackSteel, 1)));
/* 1599 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet2x), null, "tuyere", AnvilReq.BLUESTEEL, new ItemStack(TFCItems.tuyereBlueSteel, 1)));
/* 1600 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet2x), null, "tuyere", AnvilReq.REDSTEEL, new ItemStack(TFCItems.tuyereRedSteel, 1)));
/*      */     
/* 1602 */     addTrapDoor(TFCItems.bismuthSheet, 0); addTrapDoor(TFCItems.bismuthBronzeSheet, 1); addTrapDoor(TFCItems.blackBronzeSheet, 2); addTrapDoor(TFCItems.blackSteelSheet, 3);
/* 1603 */     addTrapDoor(TFCItems.blueSteelSheet, 4); addTrapDoor(TFCItems.brassSheet, 5); addTrapDoor(TFCItems.bronzeSheet, 6); addTrapDoor(TFCItems.copperSheet, 7);
/* 1604 */     addTrapDoor(TFCItems.goldSheet, 8); addTrapDoor(TFCItems.wroughtIronSheet, 9); addTrapDoor(TFCItems.leadSheet, 10); addTrapDoor(TFCItems.nickelSheet, 11);
/* 1605 */     addTrapDoor(TFCItems.nickelSheet, 12); addTrapDoor(TFCItems.platinumSheet, 13); addTrapDoor(TFCItems.redSteelSheet, 14); addTrapDoor(TFCItems.roseGoldSheet, 15);
/* 1606 */     addTrapDoor(TFCItems.silverSheet, 16); addTrapDoor(TFCItems.steelSheet, 17); addTrapDoor(TFCItems.sterlingSilverSheet, 18); addTrapDoor(TFCItems.tinSheet, 19);
/* 1607 */     addTrapDoor(TFCItems.zincSheet, 20); addTrapDoor(TFCItems.electrumSheet, 21); addTrapDoor(TFCItems.cupronickelSheet, 22);
/*      */     
/* 1609 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot2x), new ItemStack(TFCItems.wroughtIronIngot2x), "grill", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.grill, 1, 0)));
/* 1610 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronKnifeHead), new ItemStack(TFCItems.wroughtIronKnifeHead), "shears", AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.shears, 1, 0)));
/*      */     
/* 1612 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 0)));
/* 1613 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 1)));
/* 1614 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 2)));
/* 1615 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 3)));
/* 1616 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot), null, "oillamp", AnvilReq.COPPER, new ItemStack(TFCBlocks.oilLamp, 1, 4)));
/* 1617 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), null, "oillamp", AnvilReq.BLUESTEEL, new ItemStack(TFCBlocks.oilLamp, 1, 5)));
/*      */     
/* 1619 */     manager.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet2x), new ItemStack(TFCItems.wroughtIronSheet2x), "hopper", AnvilReq.WROUGHTIRON, new ItemStack(TFCBlocks.hopper, 1, 0)));
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addTrapDoor(Item sheet, int index) {
/* 1624 */     AnvilManager manager = AnvilManager.getInstance();
/* 1625 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bismuthIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index)));
/* 1626 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bismuthBronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 32)));
/* 1627 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blackBronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 64)));
/* 1628 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blackSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 96)));
/* 1629 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.blueSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 128)));
/* 1630 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.brassIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 160)));
/* 1631 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.bronzeIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 192)));
/* 1632 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.copperIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 224)));
/* 1633 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.goldIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 256)));
/* 1634 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.wroughtIronIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 288)));
/* 1635 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.leadIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 320)));
/* 1636 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.nickelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 352)));
/* 1637 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.platinumIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 416)));
/* 1638 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.redSteelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 448)));
/* 1639 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.roseGoldIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 480)));
/* 1640 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.silverIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 512)));
/* 1641 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.steelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 544)));
/* 1642 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.sterlingSilverIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 576)));
/* 1643 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.tinIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 608)));
/* 1644 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.zincIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 640)));
/* 1645 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.electrumIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 672)));
/* 1646 */     manager.addRecipe(new AnvilRecipe(new ItemStack(sheet), new ItemStack(TFCItems.cupronickelIngot), "trapdoor", AnvilReq.COPPER, new ItemStack(TFCBlocks.metalTrapDoor, 1, index + 704)));
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
/* 1657 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthIngot), new ItemStack(TFCItems.bismuthIngot), AnvilReq.STONE, new ItemStack(TFCItems.bismuthIngot2x, 1)));
/* 1658 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeIngot), new ItemStack(TFCItems.bismuthBronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeIngot2x, 1)));
/* 1659 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeIngot), new ItemStack(TFCItems.blackBronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeIngot2x, 1)));
/* 1660 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelIngot2x, 1)));
/* 1661 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelIngot), new ItemStack(TFCItems.blueSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelIngot2x, 1)));
/* 1662 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassIngot), new ItemStack(TFCItems.brassIngot), AnvilReq.COPPER, new ItemStack(TFCItems.brassIngot2x, 1)));
/* 1663 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeIngot), new ItemStack(TFCItems.bronzeIngot), AnvilReq.COPPER, new ItemStack(TFCItems.bronzeIngot2x, 1)));
/* 1664 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperIngot), new ItemStack(TFCItems.copperIngot), AnvilReq.STONE, new ItemStack(TFCItems.copperIngot2x, 1)));
/* 1665 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldIngot), new ItemStack(TFCItems.goldIngot), AnvilReq.COPPER, new ItemStack(TFCItems.goldIngot2x, 1)));
/* 1666 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronIngot), new ItemStack(TFCItems.wroughtIronIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronIngot2x, 1)));
/* 1667 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadIngot), new ItemStack(TFCItems.leadIngot), AnvilReq.COPPER, new ItemStack(TFCItems.leadIngot2x, 1)));
/* 1668 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelIngot), new ItemStack(TFCItems.nickelIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelIngot2x, 1)));
/* 1669 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronIngot), new ItemStack(TFCItems.pigIronIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronIngot2x, 1)));
/* 1670 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumIngot), new ItemStack(TFCItems.platinumIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.platinumIngot2x, 1)));
/* 1671 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelIngot), new ItemStack(TFCItems.redSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelIngot2x, 1)));
/* 1672 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldIngot), new ItemStack(TFCItems.roseGoldIngot), AnvilReq.COPPER, new ItemStack(TFCItems.roseGoldIngot2x, 1)));
/* 1673 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverIngot), new ItemStack(TFCItems.silverIngot), AnvilReq.COPPER, new ItemStack(TFCItems.silverIngot2x, 1)));
/* 1674 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelIngot), new ItemStack(TFCItems.steelIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelIngot2x, 1)));
/* 1675 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverIngot), new ItemStack(TFCItems.sterlingSilverIngot), AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverIngot2x, 1)));
/* 1676 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinIngot), new ItemStack(TFCItems.tinIngot), AnvilReq.STONE, new ItemStack(TFCItems.tinIngot2x, 1)));
/* 1677 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincIngot), new ItemStack(TFCItems.zincIngot), AnvilReq.STONE, new ItemStack(TFCItems.zincIngot2x, 1)));
/* 1678 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.electrumIngot), new ItemStack(TFCItems.electrumIngot), AnvilReq.COPPER, new ItemStack(TFCItems.electrumIngot2x, 1)));
/* 1679 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.cupronickelIngot), new ItemStack(TFCItems.cupronickelIngot), AnvilReq.COPPER, new ItemStack(TFCItems.cupronickelIngot2x, 1)));
/* 1680 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakSteelIngot), new ItemStack(TFCItems.pigIronIngot), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1)));
/* 1681 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakBlueSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1)));
/* 1682 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.weakRedSteelIngot), new ItemStack(TFCItems.blackSteelIngot), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.highCarbonRedSteelIngot, 1)));
/*      */     
/* 1684 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthSheet), new ItemStack(TFCItems.bismuthSheet), AnvilReq.STONE, new ItemStack(TFCItems.bismuthSheet2x, 1)));
/* 1685 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeSheet), new ItemStack(TFCItems.bismuthBronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeSheet2x, 1)));
/* 1686 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeSheet), new ItemStack(TFCItems.blackBronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeSheet2x, 1)));
/* 1687 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelSheet), new ItemStack(TFCItems.blackSteelSheet), AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelSheet2x, 1)));
/* 1688 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelSheet), new ItemStack(TFCItems.blueSteelSheet), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelSheet2x, 1)));
/* 1689 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.brassSheet), new ItemStack(TFCItems.brassSheet), AnvilReq.COPPER, new ItemStack(TFCItems.brassSheet2x, 1)));
/* 1690 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeSheet), new ItemStack(TFCItems.bronzeSheet), AnvilReq.COPPER, new ItemStack(TFCItems.bronzeSheet2x, 1)));
/* 1691 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperSheet), new ItemStack(TFCItems.copperSheet), AnvilReq.STONE, new ItemStack(TFCItems.copperSheet2x, 1)));
/* 1692 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.goldSheet), new ItemStack(TFCItems.goldSheet), AnvilReq.COPPER, new ItemStack(TFCItems.goldSheet2x, 1)));
/* 1693 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronSheet), new ItemStack(TFCItems.wroughtIronSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronSheet2x, 1)));
/* 1694 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.leadSheet), new ItemStack(TFCItems.leadSheet), AnvilReq.COPPER, new ItemStack(TFCItems.leadSheet2x, 1)));
/* 1695 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.nickelSheet), new ItemStack(TFCItems.nickelSheet), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.nickelSheet2x, 1)));
/* 1696 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.pigIronSheet), new ItemStack(TFCItems.pigIronSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.pigIronSheet2x, 1)));
/* 1697 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.platinumSheet), new ItemStack(TFCItems.platinumSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.platinumSheet2x, 1)));
/* 1698 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelSheet), new ItemStack(TFCItems.redSteelSheet), AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelSheet2x, 1)));
/* 1699 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.roseGoldSheet), new ItemStack(TFCItems.roseGoldSheet), AnvilReq.COPPER, new ItemStack(TFCItems.roseGoldSheet2x, 1)));
/* 1700 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.silverSheet), new ItemStack(TFCItems.silverSheet), AnvilReq.COPPER, new ItemStack(TFCItems.silverSheet2x, 1)));
/* 1701 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelSheet), new ItemStack(TFCItems.steelSheet), AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelSheet2x, 1)));
/* 1702 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.sterlingSilverSheet), new ItemStack(TFCItems.sterlingSilverSheet), AnvilReq.BRONZE, new ItemStack(TFCItems.sterlingSilverSheet2x, 1)));
/* 1703 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.tinSheet), new ItemStack(TFCItems.tinSheet), AnvilReq.STONE, new ItemStack(TFCItems.tinSheet2x, 1)));
/* 1704 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.zincSheet), new ItemStack(TFCItems.zincSheet), AnvilReq.STONE, new ItemStack(TFCItems.zincSheet2x, 1)));
/* 1705 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.electrumSheet), new ItemStack(TFCItems.electrumSheet), AnvilReq.COPPER, new ItemStack(TFCItems.electrumSheet2x, 1)));
/* 1706 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.cupronickelSheet), new ItemStack(TFCItems.cupronickelSheet), AnvilReq.COPPER, new ItemStack(TFCItems.cupronickelSheet2x, 1)));
/*      */ 
/*      */     
/* 1709 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 1)));
/* 1710 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blackBronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 1)));
/* 1711 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blackSteelSheet2x), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 1)));
/* 1712 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.blueSteelSheet2x), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 1)));
/* 1713 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.bronzeSheet2x), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 1)));
/* 1714 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.copperSheet2x), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 1)));
/* 1715 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.wroughtIronSheet2x), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 1)));
/* 1716 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.redSteelSheet2x), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 1)));
/* 1717 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 0), new ItemStack(TFCItems.steelSheet2x), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 1)));
/*      */ 
/*      */     
/* 1720 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 1)));
/* 1721 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 1)));
/* 1722 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 1)));
/* 1723 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 1)));
/* 1724 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 1)));
/* 1725 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 1)));
/* 1726 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 1)));
/* 1727 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 1)));
/* 1728 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 1)));
/*      */ 
/*      */     
/* 1731 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 1)));
/* 1732 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 1)));
/* 1733 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 1)));
/* 1734 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 1)));
/* 1735 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 1)));
/* 1736 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 1)));
/* 1737 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 1)));
/* 1738 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 1)));
/* 1739 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 1)));
/*      */ 
/*      */     
/* 1742 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.bismuthBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 1)));
/* 1743 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blackBronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 1)));
/* 1744 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blackSteelSheet), true, AnvilReq.STEEL, new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 1)));
/* 1745 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.blueSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 1)));
/* 1746 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 0), new ItemStack(TFCItems.bronzeSheet), true, AnvilReq.COPPER, new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 1)));
/* 1747 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 0), new ItemStack(TFCItems.copperSheet), true, AnvilReq.STONE, new ItemStack(TFCItems.copperUnfinishedBoots, 1, 1)));
/* 1748 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 0), new ItemStack(TFCItems.wroughtIronSheet), true, AnvilReq.BRONZE, new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 1)));
/* 1749 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.redSteelSheet), true, AnvilReq.BLACKSTEEL, new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 1)));
/* 1750 */     manager.addWeldRecipe(new AnvilRecipe(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 0), new ItemStack(TFCItems.steelSheet), true, AnvilReq.WROUGHTIRON, new ItemStack(TFCItems.steelUnfinishedBoots, 1, 1)));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerFoodRecipes() {
/* 1755 */     addFoodRefineRecipe(TFCItems.wheatWhole, TFCItems.wheatGrain);
/* 1756 */     addFoodRefineRecipe(TFCItems.ryeWhole, TFCItems.ryeGrain);
/* 1757 */     addFoodRefineRecipe(TFCItems.barleyWhole, TFCItems.barleyGrain);
/* 1758 */     addFoodRefineRecipe(TFCItems.oatWhole, TFCItems.oatGrain);
/* 1759 */     addFoodRefineRecipe(TFCItems.riceWhole, TFCItems.riceGrain);
/*      */     
/* 1761 */     addFoodDoughRecipe(TFCItems.wheatGround, TFCItems.wheatDough, TFCItems.woodenBucketWater);
/* 1762 */     addFoodDoughRecipe(TFCItems.barleyGround, TFCItems.barleyDough, TFCItems.woodenBucketWater);
/* 1763 */     addFoodDoughRecipe(TFCItems.ryeGround, TFCItems.ryeDough, TFCItems.woodenBucketWater);
/* 1764 */     addFoodDoughRecipe(TFCItems.oatGround, TFCItems.oatDough, TFCItems.woodenBucketWater);
/* 1765 */     addFoodDoughRecipe(TFCItems.riceGround, TFCItems.riceDough, TFCItems.woodenBucketWater);
/* 1766 */     addFoodDoughRecipe(TFCItems.cornmealGround, TFCItems.cornmealDough, TFCItems.woodenBucketWater);
/* 1767 */     addFoodDoughRecipe(TFCItems.wheatGround, TFCItems.wheatDough, TFCItems.redSteelBucketWater);
/* 1768 */     addFoodDoughRecipe(TFCItems.barleyGround, TFCItems.barleyDough, TFCItems.redSteelBucketWater);
/* 1769 */     addFoodDoughRecipe(TFCItems.ryeGround, TFCItems.ryeDough, TFCItems.redSteelBucketWater);
/* 1770 */     addFoodDoughRecipe(TFCItems.oatGround, TFCItems.oatDough, TFCItems.redSteelBucketWater);
/* 1771 */     addFoodDoughRecipe(TFCItems.riceGround, TFCItems.riceDough, TFCItems.redSteelBucketWater);
/* 1772 */     addFoodDoughRecipe(TFCItems.cornmealGround, TFCItems.cornmealDough, TFCItems.redSteelBucketWater);
/*      */     
/* 1774 */     addFoodSaltRecipe(TFCItems.venisonRaw);
/* 1775 */     addFoodSaltRecipe(TFCItems.beefRaw);
/* 1776 */     addFoodSaltRecipe(TFCItems.bearRaw);
/* 1777 */     addFoodSaltRecipe(TFCItems.chickenRaw);
/* 1778 */     addFoodSaltRecipe(TFCItems.porkchopRaw);
/* 1779 */     addFoodSaltRecipe(TFCItems.fishRaw);
/* 1780 */     addFoodSaltRecipe(TFCItems.calamariRaw);
/* 1781 */     addFoodSaltRecipe(TFCItems.muttonRaw);
/* 1782 */     addFoodSaltRecipe(TFCItems.horseMeatRaw);
/* 1783 */     for (Item i : TFCItems.foodList) {
/*      */       
/* 1785 */       addFoodMergeRecipe(i);
/* 1786 */       GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(ItemFoodTFC.createTag(new ItemStack(i, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(i, 1)), "itemKnife" }));
/* 1787 */       GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(i, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(i, 1)) });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodSaltRecipe(Item food) {
/* 1793 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), new ItemStack(TFCItems.powder, 1, 9) });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodRefineRecipe(Item foodInput, Item foodOutput) {
/* 1798 */     GameRegistry.addRecipe((IRecipe)new ShapelessOreRecipe(ItemFoodTFC.createTag(new ItemStack(foodOutput, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(foodInput, 1)), "itemKnife" }));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodDoughRecipe(Item foodInput, Item foodOutput, Item bucket) {
/* 1803 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(foodOutput, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(foodInput, 1)), bucket });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addFoodMergeRecipe(Item food) {
/* 1808 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1809 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1810 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1811 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1812 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1813 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1814 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/* 1815 */     GameRegistry.addShapelessRecipe(ItemFoodTFC.createTag(new ItemStack(food, 1)), new Object[] { ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)), ItemFoodTFC.createTag(new ItemStack(food, 1)) });
/*      */   }
/*      */ 
/*      */   
/*      */   public static void registerKilnRecipes() {
/* 1820 */     KilnCraftingManager manager = KilnCraftingManager.getInstance();
/*      */     
/* 1822 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.ceramicMold, 1, 0), 0, new ItemStack(TFCItems.ceramicMold, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1828 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.spindleHead, 1, 0), 0, new ItemStack(TFCItems.spindleHead, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1834 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potteryJug, 1, 0), 0, new ItemStack(TFCItems.potteryJug, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1840 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potterySmallVessel, 1, 0), 0, new ItemStack(TFCItems.potterySmallVessel, 1, 1)));
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
/* 1852 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCBlocks.vessel, 1, 0), 0, new ItemStack(TFCBlocks.vessel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1858 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 0), 0, new ItemStack(TFCItems.clayMoldAxe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1864 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 0), 0, new ItemStack(TFCItems.clayMoldAxe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1870 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldChisel, 1, 0), 0, new ItemStack(TFCItems.clayMoldChisel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1876 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldHammer, 1, 0), 0, new ItemStack(TFCItems.clayMoldHammer, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1882 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldHoe, 1, 0), 0, new ItemStack(TFCItems.clayMoldHoe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1888 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldKnife, 1, 0), 0, new ItemStack(TFCItems.clayMoldKnife, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1894 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldMace, 1, 0), 0, new ItemStack(TFCItems.clayMoldMace, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1900 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldPick, 1, 0), 0, new ItemStack(TFCItems.clayMoldPick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1906 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldProPick, 1, 0), 0, new ItemStack(TFCItems.clayMoldProPick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1912 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldSaw, 1, 0), 0, new ItemStack(TFCItems.clayMoldSaw, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1918 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldScythe, 1, 0), 0, new ItemStack(TFCItems.clayMoldScythe, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1924 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldShovel, 1, 0), 0, new ItemStack(TFCItems.clayMoldShovel, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1930 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldSword, 1, 0), 0, new ItemStack(TFCItems.clayMoldSword, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1936 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.clayMoldJavelin, 1, 0), 0, new ItemStack(TFCItems.clayMoldJavelin, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1942 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.fireBrick, 1, 0), 0, new ItemStack(TFCItems.fireBrick, 1, 1)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1948 */     manager.addRecipe(new KilnRecipe(new ItemStack(TFCItems.potteryBowl, 1, 0), 0, new ItemStack(TFCItems.potteryBowl, 1, 1)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void registerQuernRecipes() {
/* 1957 */     QuernManager manager = QuernManager.getInstance();
/*      */     
/* 1959 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.wheatGrain, 1), new ItemStack(TFCItems.wheatGround, 1)));
/* 1960 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.ryeGrain, 1), new ItemStack(TFCItems.ryeGround, 1)));
/* 1961 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oatGrain, 1), new ItemStack(TFCItems.oatGround, 1)));
/* 1962 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.barleyGrain, 1), new ItemStack(TFCItems.barleyGround, 1)));
/* 1963 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.riceGrain, 1), new ItemStack(TFCItems.riceGround, 1)));
/* 1964 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.maizeEar, 1), new ItemStack(TFCItems.cornmealGround, 1)));
/* 1965 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 16), new ItemStack(TFCItems.powder, 4, 1)));
/* 1966 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 20), new ItemStack(TFCItems.powder, 4, 2)));
/* 1967 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 27), new ItemStack(Items.field_151137_ax, 8)));
/* 1968 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 28), new ItemStack(Items.field_151137_ax, 8)));
/* 1969 */     manager.addRecipe(new QuernRecipe(new ItemStack(Items.field_151103_aS, 1), new ItemStack(TFCItems.dye, 2, 15)));
/* 1970 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 34), new ItemStack(TFCItems.powder, 4, 6)));
/* 1971 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 9), new ItemStack(TFCItems.powder, 1, 8)));
/* 1972 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 58), new ItemStack(TFCItems.powder, 2, 8)));
/* 1973 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 9), new ItemStack(TFCItems.powder, 4, 8)));
/* 1974 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 44), new ItemStack(TFCItems.powder, 6, 8)));
/* 1975 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 3), new ItemStack(TFCItems.powder, 1, 5)));
/* 1976 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 52), new ItemStack(TFCItems.powder, 2, 5)));
/* 1977 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 3), new ItemStack(TFCItems.powder, 4, 5)));
/* 1978 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 38), new ItemStack(TFCItems.powder, 6, 5)));
/* 1979 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.smallOreChunk, 1, 11), new ItemStack(TFCItems.powder, 1, 7)));
/* 1980 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 60), new ItemStack(TFCItems.powder, 2, 7)));
/* 1981 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 11), new ItemStack(TFCItems.powder, 4, 7)));
/* 1982 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 46), new ItemStack(TFCItems.powder, 6, 7)));
/* 1983 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.oreChunk, 1, 31), new ItemStack(TFCItems.fertilizer, 4)));
/* 1984 */     manager.addRecipe(new QuernRecipe(new ItemStack(TFCItems.looseRock, 1, 5), new ItemStack(TFCItems.powder, 4, 9)));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int valueOfString(String s) {
/* 1989 */     if (s.length() > 0) {
/*      */       
/* 1991 */       byte[] b = s.getBytes();
/* 1992 */       int out = 0;
/* 1993 */       for (int i = 0; i < b.length; i++)
/* 1994 */         out += b[i]; 
/* 1995 */       return out;
/*      */     } 
/* 1997 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void removeRecipe(ItemStack resultItem) {
/* 2002 */     List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
/* 2003 */     for (int i = 0; i < recipes.size(); i++) {
/*      */       
/* 2005 */       if (recipes.get(i) != null) {
/*      */         
/* 2007 */         ItemStack recipeResult = ((IRecipe)recipes.get(i)).func_77571_b();
/*      */         
/* 2009 */         if (ItemStack.func_77989_b(resultItem, recipeResult)) {
/* 2010 */           recipes.remove(i--);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void removeRecipe(Class clazz) {
/* 2017 */     List<IRecipe> recipes = CraftingManager.func_77594_a().func_77592_b();
/* 2018 */     for (int i = 0; i < recipes.size(); i++) {
/*      */       
/* 2020 */       IRecipe tmpRecipe = recipes.get(i);
/* 2021 */       if (tmpRecipe != null) {
/*      */         
/* 2023 */         ItemStack recipeResult = tmpRecipe.func_77571_b();
/*      */         
/* 2025 */         if (recipeResult != null && clazz.isInstance(recipeResult.func_77973_b()))
/* 2026 */           recipes.remove(i--); 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Recipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */