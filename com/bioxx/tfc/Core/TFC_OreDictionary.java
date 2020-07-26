/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFC_OreDictionary
/*     */ {
/*     */   public static void registerOreDict() {
/*  17 */     int WILD = 32767;
/*     */ 
/*     */     
/*  20 */     OreDictionary.registerOre("logWood", new ItemStack(TFCItems.logs, 1, 32767));
/*  21 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.logNatural, 1, 32767));
/*  22 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.logNatural2, 1, 32767));
/*  23 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodHoriz, 1, 32767));
/*  24 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodHoriz2, 1, 32767));
/*  25 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodHoriz3, 1, 32767));
/*  26 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodHoriz4, 1, 32767));
/*  27 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodVert, 1, 32767));
/*  28 */     OreDictionary.registerOre("logWood", new ItemStack(TFCBlocks.woodVert2, 1, 32767));
/*     */     
/*  30 */     OreDictionary.registerOre("plankWood", new ItemStack(TFCBlocks.planks, 1, 32767));
/*  31 */     OreDictionary.registerOre("plankWood", new ItemStack(TFCBlocks.planks2, 1, 32767));
/*     */     
/*  33 */     OreDictionary.registerOre("woodLumber", new ItemStack(TFCItems.singlePlank, 1, 32767));
/*     */     
/*  35 */     OreDictionary.registerOre("stickWood", new ItemStack(TFCItems.stick));
/*     */     
/*  37 */     OreDictionary.registerOre("treeSapling", new ItemStack(TFCBlocks.sapling, 1, 32767));
/*  38 */     OreDictionary.registerOre("treeSapling", new ItemStack(TFCBlocks.sapling2, 1, 32767));
/*     */     
/*  40 */     OreDictionary.registerOre("treeLeaves", new ItemStack(TFCBlocks.leaves, 1, 32767));
/*  41 */     OreDictionary.registerOre("treeLeaves", new ItemStack(TFCBlocks.leaves2, 1, 32767));
/*     */ 
/*     */     
/*  44 */     OreDictionary.registerOre("chestWood", new ItemStack(TFCBlocks.chest, 1, 32767));
/*  45 */     OreDictionary.registerOre("barrelWood", new ItemStack(TFCBlocks.barrel, 1, 32767));
/*     */     
/*  47 */     OreDictionary.registerOre("fenceGate", new ItemStack(Blocks.field_150396_be, 1, 32767));
/*  48 */     OreDictionary.registerOre("fenceGate", new ItemStack(TFCBlocks.fenceGate, 1, 32767));
/*  49 */     OreDictionary.registerOre("fenceGate", new ItemStack(TFCBlocks.fenceGate2, 1, 32767));
/*     */     
/*  51 */     OreDictionary.registerOre("fenceWood", new ItemStack(Blocks.field_150422_aJ, 1, 32767));
/*  52 */     OreDictionary.registerOre("fenceWood", new ItemStack(TFCBlocks.fence, 1, 32767));
/*  53 */     OreDictionary.registerOre("fenceWood", new ItemStack(TFCBlocks.fence2, 1, 32767));
/*     */ 
/*     */     
/*  56 */     OreDictionary.registerOre("oreNormalCopper", new ItemStack(TFCItems.oreChunk, 1, 0));
/*  57 */     OreDictionary.registerOre("oreNormalCopper", new ItemStack(TFCItems.oreChunk, 1, 9));
/*  58 */     OreDictionary.registerOre("oreNormalCopper", new ItemStack(TFCItems.oreChunk, 1, 13));
/*  59 */     OreDictionary.registerOre("oreSmallCopper", new ItemStack(TFCItems.smallOreChunk, 1, 0));
/*  60 */     OreDictionary.registerOre("oreSmallCopper", new ItemStack(TFCItems.smallOreChunk, 1, 9));
/*  61 */     OreDictionary.registerOre("oreSmallCopper", new ItemStack(TFCItems.smallOreChunk, 1, 13));
/*  62 */     OreDictionary.registerOre("oreRichCopper", new ItemStack(TFCItems.oreChunk, 1, 35));
/*  63 */     OreDictionary.registerOre("oreRichCopper", new ItemStack(TFCItems.oreChunk, 1, 44));
/*  64 */     OreDictionary.registerOre("oreRichCopper", new ItemStack(TFCItems.oreChunk, 1, 48));
/*  65 */     OreDictionary.registerOre("orePoorCopper", new ItemStack(TFCItems.oreChunk, 1, 49));
/*  66 */     OreDictionary.registerOre("orePoorCopper", new ItemStack(TFCItems.oreChunk, 1, 58));
/*  67 */     OreDictionary.registerOre("orePoorCopper", new ItemStack(TFCItems.oreChunk, 1, 62));
/*     */     
/*  69 */     OreDictionary.registerOre("oreNormalGold", new ItemStack(TFCItems.oreChunk, 1, 1));
/*  70 */     OreDictionary.registerOre("oreSmallGold", new ItemStack(TFCItems.smallOreChunk, 1, 1));
/*  71 */     OreDictionary.registerOre("oreRichGold", new ItemStack(TFCItems.oreChunk, 1, 36));
/*  72 */     OreDictionary.registerOre("orePoorGold", new ItemStack(TFCItems.oreChunk, 1, 50));
/*     */     
/*  74 */     OreDictionary.registerOre("oreNormalPlatinum", new ItemStack(TFCItems.oreChunk, 1, 2));
/*  75 */     OreDictionary.registerOre("oreSmallPlatinum", new ItemStack(TFCItems.smallOreChunk, 1, 2));
/*  76 */     OreDictionary.registerOre("oreRichPlatinum", new ItemStack(TFCItems.oreChunk, 1, 37));
/*  77 */     OreDictionary.registerOre("orePoorPlatinum", new ItemStack(TFCItems.oreChunk, 1, 51));
/*     */     
/*  79 */     OreDictionary.registerOre("oreNormalIron", new ItemStack(TFCItems.oreChunk, 1, 3));
/*  80 */     OreDictionary.registerOre("oreNormalIron", new ItemStack(TFCItems.oreChunk, 1, 10));
/*  81 */     OreDictionary.registerOre("oreNormalIron", new ItemStack(TFCItems.oreChunk, 1, 11));
/*  82 */     OreDictionary.registerOre("oreSmallIron", new ItemStack(TFCItems.smallOreChunk, 1, 3));
/*  83 */     OreDictionary.registerOre("oreSmallIron", new ItemStack(TFCItems.smallOreChunk, 1, 10));
/*  84 */     OreDictionary.registerOre("oreSmallIron", new ItemStack(TFCItems.smallOreChunk, 1, 11));
/*  85 */     OreDictionary.registerOre("oreRichIron", new ItemStack(TFCItems.oreChunk, 1, 38));
/*  86 */     OreDictionary.registerOre("oreRichIron", new ItemStack(TFCItems.oreChunk, 1, 45));
/*  87 */     OreDictionary.registerOre("oreRichIron", new ItemStack(TFCItems.oreChunk, 1, 46));
/*  88 */     OreDictionary.registerOre("orePoorIron", new ItemStack(TFCItems.oreChunk, 1, 52));
/*  89 */     OreDictionary.registerOre("orePoorIron", new ItemStack(TFCItems.oreChunk, 1, 59));
/*  90 */     OreDictionary.registerOre("orePoorIron", new ItemStack(TFCItems.oreChunk, 1, 60));
/*     */     
/*  92 */     OreDictionary.registerOre("oreNormalSilver", new ItemStack(TFCItems.oreChunk, 1, 4));
/*  93 */     OreDictionary.registerOre("oreSmallSilver", new ItemStack(TFCItems.smallOreChunk, 1, 4));
/*  94 */     OreDictionary.registerOre("oreRichSilver", new ItemStack(TFCItems.oreChunk, 1, 39));
/*  95 */     OreDictionary.registerOre("orePoorSilver", new ItemStack(TFCItems.oreChunk, 1, 53));
/*     */     
/*  97 */     OreDictionary.registerOre("oreNormalTin", new ItemStack(TFCItems.oreChunk, 1, 5));
/*  98 */     OreDictionary.registerOre("oreSmallTin", new ItemStack(TFCItems.smallOreChunk, 1, 5));
/*  99 */     OreDictionary.registerOre("oreRichTin", new ItemStack(TFCItems.oreChunk, 1, 40));
/* 100 */     OreDictionary.registerOre("orePoorTin", new ItemStack(TFCItems.oreChunk, 1, 54));
/*     */     
/* 102 */     OreDictionary.registerOre("oreNormalLead", new ItemStack(TFCItems.oreChunk, 1, 6));
/* 103 */     OreDictionary.registerOre("oreSmallLead", new ItemStack(TFCItems.smallOreChunk, 1, 6));
/* 104 */     OreDictionary.registerOre("oreRichLead", new ItemStack(TFCItems.oreChunk, 1, 41));
/* 105 */     OreDictionary.registerOre("orePoorLead", new ItemStack(TFCItems.oreChunk, 1, 55));
/*     */     
/* 107 */     OreDictionary.registerOre("oreNormalBismuth", new ItemStack(TFCItems.oreChunk, 1, 7));
/* 108 */     OreDictionary.registerOre("oreSmallBismuth", new ItemStack(TFCItems.smallOreChunk, 1, 7));
/* 109 */     OreDictionary.registerOre("oreRichBismuth", new ItemStack(TFCItems.oreChunk, 1, 42));
/* 110 */     OreDictionary.registerOre("orePoorBismuth", new ItemStack(TFCItems.oreChunk, 1, 56));
/*     */     
/* 112 */     OreDictionary.registerOre("oreNormalNickel", new ItemStack(TFCItems.oreChunk, 1, 8));
/* 113 */     OreDictionary.registerOre("oreSmallNickel", new ItemStack(TFCItems.smallOreChunk, 1, 8));
/* 114 */     OreDictionary.registerOre("oreRichNickel", new ItemStack(TFCItems.oreChunk, 1, 43));
/* 115 */     OreDictionary.registerOre("orePoorNickel", new ItemStack(TFCItems.oreChunk, 1, 57));
/*     */     
/* 117 */     OreDictionary.registerOre("oreNormalZinc", new ItemStack(TFCItems.oreChunk, 1, 12));
/* 118 */     OreDictionary.registerOre("oreSmallZinc", new ItemStack(TFCItems.smallOreChunk, 1, 12));
/* 119 */     OreDictionary.registerOre("oreRichZinc", new ItemStack(TFCItems.oreChunk, 1, 47));
/* 120 */     OreDictionary.registerOre("orePoorZinc", new ItemStack(TFCItems.oreChunk, 1, 61));
/*     */     
/* 122 */     OreDictionary.registerOre("oreCoal", new ItemStack(TFCItems.oreChunk, 1, 14));
/* 123 */     OreDictionary.registerOre("oreCoal", new ItemStack(TFCItems.oreChunk, 1, 15));
/*     */     
/* 125 */     OreDictionary.registerOre("oreKaolinite", new ItemStack(TFCItems.oreChunk, 1, 16));
/* 126 */     OreDictionary.registerOre("oreGypsum", new ItemStack(TFCItems.oreChunk, 1, 17));
/* 127 */     OreDictionary.registerOre("oreSatinspar", new ItemStack(TFCItems.oreChunk, 1, 18));
/* 128 */     OreDictionary.registerOre("oreSelenite", new ItemStack(TFCItems.oreChunk, 1, 19));
/* 129 */     OreDictionary.registerOre("oreGraphite", new ItemStack(TFCItems.oreChunk, 1, 20));
/* 130 */     OreDictionary.registerOre("oreDiamond", new ItemStack(TFCItems.oreChunk, 1, 21));
/* 131 */     OreDictionary.registerOre("orePetrifiedWood", new ItemStack(TFCItems.oreChunk, 1, 22));
/* 132 */     OreDictionary.registerOre("oreSulfur", new ItemStack(TFCItems.oreChunk, 1, 23));
/* 133 */     OreDictionary.registerOre("oreJet", new ItemStack(TFCItems.oreChunk, 1, 24));
/* 134 */     OreDictionary.registerOre("oreMicrocline", new ItemStack(TFCItems.oreChunk, 1, 25));
/*     */ 
/*     */     
/* 137 */     OreDictionary.registerOre("oreRedstone", new ItemStack(TFCItems.oreChunk, 1, 27));
/* 138 */     OreDictionary.registerOre("oreRedstone", new ItemStack(TFCItems.oreChunk, 1, 28));
/*     */     
/* 140 */     OreDictionary.registerOre("oreSaltpeter", new ItemStack(TFCItems.oreChunk, 1, 29));
/* 141 */     OreDictionary.registerOre("oreSerpentine", new ItemStack(TFCItems.oreChunk, 1, 30));
/* 142 */     OreDictionary.registerOre("oreSylvite", new ItemStack(TFCItems.oreChunk, 1, 31));
/* 143 */     OreDictionary.registerOre("oreBorax", new ItemStack(TFCItems.oreChunk, 1, 32));
/* 144 */     OreDictionary.registerOre("oreOlivine", new ItemStack(TFCItems.oreChunk, 1, 33));
/* 145 */     OreDictionary.registerOre("oreLapis", new ItemStack(TFCItems.oreChunk, 1, 34));
/*     */ 
/*     */     
/* 148 */     OreDictionary.registerOre("dustFlux", new ItemStack(TFCItems.powder, 1, 0));
/* 149 */     OreDictionary.registerOre("dustKaolinite", new ItemStack(TFCItems.powder, 1, 1));
/* 150 */     OreDictionary.registerOre("dustGraphite", new ItemStack(TFCItems.powder, 1, 2));
/* 151 */     OreDictionary.registerOre("dustSulfur", new ItemStack(TFCItems.powder, 1, 3));
/* 152 */     OreDictionary.registerOre("dustSaltpeter", new ItemStack(TFCItems.powder, 1, 4));
/* 153 */     OreDictionary.registerOre("dustLapis", new ItemStack(TFCItems.powder, 1, 6));
/* 154 */     OreDictionary.registerOre("dustSalt", new ItemStack(TFCItems.powder, 1, 9));
/*     */ 
/*     */     
/* 157 */     OreDictionary.registerOre("blockBismuth", new ItemStack(TFCBlocks.metalBlock, 1, 0));
/* 158 */     OreDictionary.registerOre("nuggetAnyBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 1));
/* 159 */     OreDictionary.registerOre("nuggetBismuthBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 1));
/* 160 */     OreDictionary.registerOre("nuggetAnyBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 2));
/* 161 */     OreDictionary.registerOre("nuggetBlackBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 2));
/* 162 */     OreDictionary.registerOre("nuggetBlackSteel", new ItemStack(TFCItems.smallMetalChunk, 1, 3));
/* 163 */     OreDictionary.registerOre("nuggetBlueSteel", new ItemStack(TFCItems.smallMetalChunk, 1, 4));
/* 164 */     OreDictionary.registerOre("nuggetBrass", new ItemStack(TFCItems.smallMetalChunk, 1, 5));
/* 165 */     OreDictionary.registerOre("nuggetAnyBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 6));
/* 166 */     OreDictionary.registerOre("nuggetBronze", new ItemStack(TFCItems.smallMetalChunk, 1, 6));
/* 167 */     OreDictionary.registerOre("nuggetCopper", new ItemStack(TFCItems.smallMetalChunk, 1, 7));
/* 168 */     OreDictionary.registerOre("nuggetGold", new ItemStack(TFCItems.smallMetalChunk, 1, 8));
/* 169 */     OreDictionary.registerOre("nuggetWroughtIron", new ItemStack(TFCItems.smallMetalChunk, 1, 9));
/* 170 */     OreDictionary.registerOre("nuggetIron", new ItemStack(TFCItems.smallMetalChunk, 1, 9));
/* 171 */     OreDictionary.registerOre("nuggetLead", new ItemStack(TFCItems.smallMetalChunk, 1, 10));
/* 172 */     OreDictionary.registerOre("nuggetNickel", new ItemStack(TFCItems.smallMetalChunk, 1, 11));
/* 173 */     OreDictionary.registerOre("nuggetPigIron", new ItemStack(TFCItems.smallMetalChunk, 1, 12));
/* 174 */     OreDictionary.registerOre("nuggetPlatinum", new ItemStack(TFCItems.smallMetalChunk, 1, 13));
/* 175 */     OreDictionary.registerOre("nuggetRedSteel", new ItemStack(TFCItems.smallMetalChunk, 1, 14));
/* 176 */     OreDictionary.registerOre("nuggetRoseGold", new ItemStack(TFCItems.smallMetalChunk, 1, 15));
/* 177 */     OreDictionary.registerOre("nuggetSilver", new ItemStack(TFCItems.smallMetalChunk, 1, 16));
/* 178 */     OreDictionary.registerOre("nuggetSteel", new ItemStack(TFCItems.smallMetalChunk, 1, 17));
/* 179 */     OreDictionary.registerOre("nuggetSterlingSilver", new ItemStack(TFCItems.smallMetalChunk, 1, 18));
/* 180 */     OreDictionary.registerOre("nuggetTin", new ItemStack(TFCItems.smallMetalChunk, 1, 19));
/* 181 */     OreDictionary.registerOre("nuggetZinc", new ItemStack(TFCItems.smallMetalChunk, 1, 20));
/* 182 */     OreDictionary.registerOre("nuggetElectrum", new ItemStack(TFCItems.smallMetalChunk, 1, 21));
/* 183 */     OreDictionary.registerOre("nuggetCupronickel", new ItemStack(TFCItems.smallMetalChunk, 1, 22));
/* 184 */     OreDictionary.registerOre("nuggetConstantan", new ItemStack(TFCItems.smallMetalChunk, 1, 22));
/*     */ 
/*     */     
/* 187 */     OreDictionary.registerOre("ingotBismuth", new ItemStack(TFCItems.bismuthIngot));
/* 188 */     OreDictionary.registerOre("ingotTin", new ItemStack(TFCItems.tinIngot));
/* 189 */     OreDictionary.registerOre("ingotZinc", new ItemStack(TFCItems.zincIngot));
/* 190 */     OreDictionary.registerOre("ingotCopper", new ItemStack(TFCItems.copperIngot));
/* 191 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.bronzeIngot));
/* 192 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.bismuthBronzeIngot));
/* 193 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.blackBronzeIngot));
/* 194 */     OreDictionary.registerOre("ingotBronze", new ItemStack(TFCItems.bronzeIngot));
/* 195 */     OreDictionary.registerOre("ingotBismuthBronze", new ItemStack(TFCItems.bismuthBronzeIngot));
/* 196 */     OreDictionary.registerOre("ingotBlackBronze", new ItemStack(TFCItems.blackBronzeIngot));
/* 197 */     OreDictionary.registerOre("ingotBrass", new ItemStack(TFCItems.brassIngot));
/* 198 */     OreDictionary.registerOre("ingotLead", new ItemStack(TFCItems.leadIngot));
/* 199 */     OreDictionary.registerOre("ingotGold", new ItemStack(TFCItems.goldIngot));
/* 200 */     OreDictionary.registerOre("ingotRoseGold", new ItemStack(TFCItems.roseGoldIngot));
/* 201 */     OreDictionary.registerOre("ingotSilver", new ItemStack(TFCItems.silverIngot));
/* 202 */     OreDictionary.registerOre("ingotSterlingSilver", new ItemStack(TFCItems.sterlingSilverIngot));
/* 203 */     OreDictionary.registerOre("ingotPlatinum", new ItemStack(TFCItems.platinumIngot));
/* 204 */     OreDictionary.registerOre("ingotWroughtIron", new ItemStack(TFCItems.wroughtIronIngot));
/* 205 */     OreDictionary.registerOre("ingotIron", new ItemStack(TFCItems.wroughtIronIngot));
/* 206 */     OreDictionary.registerOre("ingotNickel", new ItemStack(TFCItems.nickelIngot));
/* 207 */     OreDictionary.registerOre("ingotPigIron", new ItemStack(TFCItems.pigIronIngot));
/* 208 */     OreDictionary.registerOre("ingotSteel", new ItemStack(TFCItems.steelIngot));
/* 209 */     OreDictionary.registerOre("ingotBlackSteel", new ItemStack(TFCItems.blackSteelIngot));
/* 210 */     OreDictionary.registerOre("ingotRedSteel", new ItemStack(TFCItems.redSteelIngot));
/* 211 */     OreDictionary.registerOre("ingotBlueSteel", new ItemStack(TFCItems.blueSteelIngot));
/* 212 */     OreDictionary.registerOre("ingotUnknown", new ItemStack(TFCItems.unknownIngot));
/* 213 */     OreDictionary.registerOre("ingotElectrum", new ItemStack(TFCItems.electrumIngot));
/* 214 */     OreDictionary.registerOre("ingotCupronickel", new ItemStack(TFCItems.cupronickelIngot));
/* 215 */     OreDictionary.registerOre("ingotConstantan", new ItemStack(TFCItems.cupronickelIngot));
/*     */ 
/*     */     
/* 218 */     OreDictionary.registerOre("ingotDoubleBismuth", new ItemStack(TFCItems.bismuthIngot2x));
/* 219 */     OreDictionary.registerOre("ingotDoubleTin", new ItemStack(TFCItems.tinIngot2x));
/* 220 */     OreDictionary.registerOre("ingotDoubleZinc", new ItemStack(TFCItems.zincIngot2x));
/* 221 */     OreDictionary.registerOre("ingotDoubleCopper", new ItemStack(TFCItems.copperIngot2x));
/* 222 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.bronzeIngot2x));
/* 223 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.bismuthBronzeIngot2x));
/* 224 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.blackBronzeIngot2x));
/* 225 */     OreDictionary.registerOre("ingotDoubleBronze", new ItemStack(TFCItems.bronzeIngot2x));
/* 226 */     OreDictionary.registerOre("ingotDoubleBismuthBronze", new ItemStack(TFCItems.bismuthBronzeIngot2x));
/* 227 */     OreDictionary.registerOre("ingotDoubleBlackBronze", new ItemStack(TFCItems.blackBronzeIngot2x));
/* 228 */     OreDictionary.registerOre("ingotDoubleBrass", new ItemStack(TFCItems.brassIngot2x));
/* 229 */     OreDictionary.registerOre("ingotDoubleLead", new ItemStack(TFCItems.leadIngot2x));
/* 230 */     OreDictionary.registerOre("ingotDoubleGold", new ItemStack(TFCItems.goldIngot2x));
/* 231 */     OreDictionary.registerOre("ingotDoubleRoseGold", new ItemStack(TFCItems.roseGoldIngot2x));
/* 232 */     OreDictionary.registerOre("ingotDoubleSilver", new ItemStack(TFCItems.silverIngot2x));
/* 233 */     OreDictionary.registerOre("ingotDoubleSterlingSilver", new ItemStack(TFCItems.sterlingSilverIngot2x));
/* 234 */     OreDictionary.registerOre("ingotDoublePlatinum", new ItemStack(TFCItems.platinumIngot2x));
/* 235 */     OreDictionary.registerOre("ingotDoubleWroughtIron", new ItemStack(TFCItems.wroughtIronIngot2x));
/* 236 */     OreDictionary.registerOre("ingotDoubleIron", new ItemStack(TFCItems.wroughtIronIngot2x));
/* 237 */     OreDictionary.registerOre("ingotDoubleNickel", new ItemStack(TFCItems.nickelIngot2x));
/* 238 */     OreDictionary.registerOre("ingotDoublePigIron", new ItemStack(TFCItems.pigIronIngot2x));
/* 239 */     OreDictionary.registerOre("ingotDoubleSteel", new ItemStack(TFCItems.steelIngot2x));
/* 240 */     OreDictionary.registerOre("ingotDoubleBlackSteel", new ItemStack(TFCItems.blackSteelIngot2x));
/* 241 */     OreDictionary.registerOre("ingotDoubleRedSteel", new ItemStack(TFCItems.redSteelIngot2x));
/* 242 */     OreDictionary.registerOre("ingotDoubleBlueSteel", new ItemStack(TFCItems.blueSteelIngot2x));
/* 243 */     OreDictionary.registerOre("ingotDoubleElectrum", new ItemStack(TFCItems.electrumIngot2x));
/* 244 */     OreDictionary.registerOre("ingotDoubleCupronickel", new ItemStack(TFCItems.cupronickelIngot2x));
/* 245 */     OreDictionary.registerOre("ingotDoubleConstantan", new ItemStack(TFCItems.cupronickelIngot2x));
/*     */ 
/*     */     
/* 248 */     OreDictionary.registerOre("plateBismuth", new ItemStack(TFCItems.bismuthSheet));
/* 249 */     OreDictionary.registerOre("plateTin", new ItemStack(TFCItems.tinSheet));
/* 250 */     OreDictionary.registerOre("plateZinc", new ItemStack(TFCItems.zincSheet));
/* 251 */     OreDictionary.registerOre("plateCopper", new ItemStack(TFCItems.copperSheet));
/* 252 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.bronzeSheet));
/* 253 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.bismuthBronzeSheet));
/* 254 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.blackBronzeSheet));
/* 255 */     OreDictionary.registerOre("plateBronze", new ItemStack(TFCItems.bronzeSheet));
/* 256 */     OreDictionary.registerOre("plateBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSheet));
/* 257 */     OreDictionary.registerOre("plateBlackBronze", new ItemStack(TFCItems.blackBronzeSheet));
/* 258 */     OreDictionary.registerOre("plateBrass", new ItemStack(TFCItems.brassSheet));
/* 259 */     OreDictionary.registerOre("plateLead", new ItemStack(TFCItems.leadSheet));
/* 260 */     OreDictionary.registerOre("plateGold", new ItemStack(TFCItems.goldSheet));
/* 261 */     OreDictionary.registerOre("plateRoseGold", new ItemStack(TFCItems.roseGoldSheet));
/* 262 */     OreDictionary.registerOre("plateSilver", new ItemStack(TFCItems.silverSheet));
/* 263 */     OreDictionary.registerOre("plateSterlingSilver", new ItemStack(TFCItems.sterlingSilverSheet));
/* 264 */     OreDictionary.registerOre("platePlatinum", new ItemStack(TFCItems.platinumSheet));
/* 265 */     OreDictionary.registerOre("plateWroughtIron", new ItemStack(TFCItems.wroughtIronSheet));
/* 266 */     OreDictionary.registerOre("plateIron", new ItemStack(TFCItems.wroughtIronSheet));
/* 267 */     OreDictionary.registerOre("plateNickel", new ItemStack(TFCItems.nickelSheet));
/* 268 */     OreDictionary.registerOre("platePigIron", new ItemStack(TFCItems.pigIronSheet));
/* 269 */     OreDictionary.registerOre("plateSteel", new ItemStack(TFCItems.steelSheet));
/* 270 */     OreDictionary.registerOre("plateBlackSteel", new ItemStack(TFCItems.blackSteelSheet));
/* 271 */     OreDictionary.registerOre("plateRedSteel", new ItemStack(TFCItems.redSteelSheet));
/* 272 */     OreDictionary.registerOre("plateBlueSteel", new ItemStack(TFCItems.blueSteelSheet));
/* 273 */     OreDictionary.registerOre("plateElectrum", new ItemStack(TFCItems.electrumSheet));
/* 274 */     OreDictionary.registerOre("plateCupronickel", new ItemStack(TFCItems.cupronickelSheet));
/* 275 */     OreDictionary.registerOre("plateConstantan", new ItemStack(TFCItems.cupronickelSheet));
/*     */ 
/*     */     
/* 278 */     OreDictionary.registerOre("plateDoubleBismuth", new ItemStack(TFCItems.bismuthSheet2x));
/* 279 */     OreDictionary.registerOre("plateDoubleTin", new ItemStack(TFCItems.tinSheet2x));
/* 280 */     OreDictionary.registerOre("plateDoubleZinc", new ItemStack(TFCItems.zincSheet2x));
/* 281 */     OreDictionary.registerOre("plateDoubleCopper", new ItemStack(TFCItems.copperSheet2x));
/* 282 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.bronzeSheet2x));
/* 283 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.bismuthBronzeSheet2x));
/* 284 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.blackBronzeSheet2x));
/* 285 */     OreDictionary.registerOre("plateDoubleBronze", new ItemStack(TFCItems.bronzeSheet2x));
/* 286 */     OreDictionary.registerOre("plateDoubleBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSheet2x));
/* 287 */     OreDictionary.registerOre("plateDoubleBlackBronze", new ItemStack(TFCItems.blackBronzeSheet2x));
/* 288 */     OreDictionary.registerOre("plateDoubleBrass", new ItemStack(TFCItems.brassSheet2x));
/* 289 */     OreDictionary.registerOre("plateDoubleLead", new ItemStack(TFCItems.leadSheet2x));
/* 290 */     OreDictionary.registerOre("plateDoubleGold", new ItemStack(TFCItems.goldSheet2x));
/* 291 */     OreDictionary.registerOre("plateDoubleRoseGold", new ItemStack(TFCItems.roseGoldSheet2x));
/* 292 */     OreDictionary.registerOre("plateDoubleSilver", new ItemStack(TFCItems.silverSheet2x));
/* 293 */     OreDictionary.registerOre("plateDoubleSterlingSilver", new ItemStack(TFCItems.sterlingSilverSheet2x));
/* 294 */     OreDictionary.registerOre("plateDoublePlatinum", new ItemStack(TFCItems.platinumSheet2x));
/* 295 */     OreDictionary.registerOre("plateDoubleWroughtIron", new ItemStack(TFCItems.wroughtIronSheet2x));
/* 296 */     OreDictionary.registerOre("plateDoubleIron", new ItemStack(TFCItems.wroughtIronSheet2x));
/* 297 */     OreDictionary.registerOre("plateDoubleNickel", new ItemStack(TFCItems.nickelSheet2x));
/* 298 */     OreDictionary.registerOre("plateDoublePigIron", new ItemStack(TFCItems.pigIronSheet2x));
/* 299 */     OreDictionary.registerOre("plateDoubleSteel", new ItemStack(TFCItems.steelSheet2x));
/* 300 */     OreDictionary.registerOre("plateDoubleBlackSteel", new ItemStack(TFCItems.blackSteelSheet2x));
/* 301 */     OreDictionary.registerOre("plateDoubleRedSteel", new ItemStack(TFCItems.redSteelSheet2x));
/* 302 */     OreDictionary.registerOre("plateDoubleBlueSteel", new ItemStack(TFCItems.blueSteelSheet2x));
/* 303 */     OreDictionary.registerOre("plateDoubleElectrum", new ItemStack(TFCItems.electrumSheet2x));
/* 304 */     OreDictionary.registerOre("plateDoubleCupronickel", new ItemStack(TFCItems.cupronickelSheet2x));
/* 305 */     OreDictionary.registerOre("plateDoubleConstantan", new ItemStack(TFCItems.cupronickelSheet2x));
/*     */ 
/*     */     
/* 308 */     OreDictionary.registerOre("blockBismuth", new ItemStack(TFCBlocks.metalBlock, 1, 0));
/* 309 */     OreDictionary.registerOre("blockAnyBronze", new ItemStack(TFCBlocks.metalBlock, 1, 1));
/* 310 */     OreDictionary.registerOre("blockBismuthBronze", new ItemStack(TFCBlocks.metalBlock, 1, 1));
/* 311 */     OreDictionary.registerOre("blockAnyBronze", new ItemStack(TFCBlocks.metalBlock, 1, 2));
/* 312 */     OreDictionary.registerOre("blockBlackBronze", new ItemStack(TFCBlocks.metalBlock, 1, 2));
/* 313 */     OreDictionary.registerOre("blockBlackSteel", new ItemStack(TFCBlocks.metalBlock, 1, 3));
/* 314 */     OreDictionary.registerOre("blockBlueSteel", new ItemStack(TFCBlocks.metalBlock, 1, 4));
/* 315 */     OreDictionary.registerOre("blockBrass", new ItemStack(TFCBlocks.metalBlock, 1, 5));
/* 316 */     OreDictionary.registerOre("blockAnyBronze", new ItemStack(TFCBlocks.metalBlock, 1, 6));
/* 317 */     OreDictionary.registerOre("blockBronze", new ItemStack(TFCBlocks.metalBlock, 1, 6));
/* 318 */     OreDictionary.registerOre("blockCopper", new ItemStack(TFCBlocks.metalBlock, 1, 7));
/* 319 */     OreDictionary.registerOre("blockGold", new ItemStack(TFCBlocks.metalBlock, 1, 8));
/* 320 */     OreDictionary.registerOre("blockWroughtIron", new ItemStack(TFCBlocks.metalBlock, 1, 9));
/* 321 */     OreDictionary.registerOre("blockIron", new ItemStack(TFCBlocks.metalBlock, 1, 9));
/* 322 */     OreDictionary.registerOre("blockLead", new ItemStack(TFCBlocks.metalBlock, 1, 10));
/* 323 */     OreDictionary.registerOre("blockNickel", new ItemStack(TFCBlocks.metalBlock, 1, 11));
/* 324 */     OreDictionary.registerOre("blockPigIron", new ItemStack(TFCBlocks.metalBlock, 1, 12));
/* 325 */     OreDictionary.registerOre("blockPlatinum", new ItemStack(TFCBlocks.metalBlock, 1, 13));
/* 326 */     OreDictionary.registerOre("blockRedSteel", new ItemStack(TFCBlocks.metalBlock, 1, 14));
/* 327 */     OreDictionary.registerOre("blockRoseGold", new ItemStack(TFCBlocks.metalBlock, 1, 15));
/* 328 */     OreDictionary.registerOre("blockSilver", new ItemStack(TFCBlocks.metalBlock2, 1, 0));
/* 329 */     OreDictionary.registerOre("blockSteel", new ItemStack(TFCBlocks.metalBlock2, 1, 1));
/* 330 */     OreDictionary.registerOre("blockSterlingSilver", new ItemStack(TFCBlocks.metalBlock2, 1, 2));
/* 331 */     OreDictionary.registerOre("blockTin", new ItemStack(TFCBlocks.metalBlock2, 1, 3));
/* 332 */     OreDictionary.registerOre("blockZinc", new ItemStack(TFCBlocks.metalBlock2, 1, 4));
/* 333 */     OreDictionary.registerOre("blockElectrum", new ItemStack(TFCBlocks.metalBlock2, 1, 5));
/* 334 */     OreDictionary.registerOre("blockCupronickel", new ItemStack(TFCBlocks.metalBlock2, 1, 6));
/* 335 */     OreDictionary.registerOre("blockConstantan", new ItemStack(TFCBlocks.metalBlock2, 1, 6));
/*     */ 
/*     */     
/* 338 */     OreDictionary.registerOre("gemChippedAgate", new ItemStack(TFCItems.gemAgate));
/* 339 */     OreDictionary.registerOre("gemChippedAmethyst", new ItemStack(TFCItems.gemAmethyst));
/* 340 */     OreDictionary.registerOre("gemChippedBeryl", new ItemStack(TFCItems.gemBeryl));
/* 341 */     OreDictionary.registerOre("gemChippedDiamond", new ItemStack(TFCItems.gemDiamond));
/* 342 */     OreDictionary.registerOre("gemChippedEmerald", new ItemStack(TFCItems.gemEmerald));
/* 343 */     OreDictionary.registerOre("gemChippedGarnet", new ItemStack(TFCItems.gemGarnet));
/* 344 */     OreDictionary.registerOre("gemChippedJade", new ItemStack(TFCItems.gemJade));
/* 345 */     OreDictionary.registerOre("gemChippedJasper", new ItemStack(TFCItems.gemJasper));
/* 346 */     OreDictionary.registerOre("gemChippedOpal", new ItemStack(TFCItems.gemOpal));
/* 347 */     OreDictionary.registerOre("gemChippedRuby", new ItemStack(TFCItems.gemRuby));
/* 348 */     OreDictionary.registerOre("gemChippedSapphire", new ItemStack(TFCItems.gemSapphire));
/* 349 */     OreDictionary.registerOre("gemChippedTopaz", new ItemStack(TFCItems.gemTopaz));
/* 350 */     OreDictionary.registerOre("gemChippedTourmaline", new ItemStack(TFCItems.gemTourmaline));
/*     */     
/* 352 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemAgate));
/* 353 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemAmethyst));
/* 354 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemBeryl));
/* 355 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemDiamond));
/* 356 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemEmerald));
/* 357 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemGarnet));
/* 358 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemJade));
/* 359 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemJasper));
/* 360 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemOpal));
/* 361 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemRuby));
/* 362 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemSapphire));
/* 363 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemTopaz));
/* 364 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemTourmaline));
/*     */     
/* 366 */     OreDictionary.registerOre("gemFlawedAgate", new ItemStack(TFCItems.gemAgate, 1, 1));
/* 367 */     OreDictionary.registerOre("gemFlawedAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 1));
/* 368 */     OreDictionary.registerOre("gemFlawedBeryl", new ItemStack(TFCItems.gemBeryl, 1, 1));
/* 369 */     OreDictionary.registerOre("gemFlawedDiamond", new ItemStack(TFCItems.gemDiamond, 1, 1));
/* 370 */     OreDictionary.registerOre("gemFlawedEmerald", new ItemStack(TFCItems.gemEmerald, 1, 1));
/* 371 */     OreDictionary.registerOre("gemFlawedGarnet", new ItemStack(TFCItems.gemGarnet, 1, 1));
/* 372 */     OreDictionary.registerOre("gemFlawedJade", new ItemStack(TFCItems.gemJade, 1, 1));
/* 373 */     OreDictionary.registerOre("gemFlawedJasper", new ItemStack(TFCItems.gemJasper, 1, 1));
/* 374 */     OreDictionary.registerOre("gemFlawedOpal", new ItemStack(TFCItems.gemOpal, 1, 1));
/* 375 */     OreDictionary.registerOre("gemFlawedRuby", new ItemStack(TFCItems.gemRuby, 1, 1));
/* 376 */     OreDictionary.registerOre("gemFlawedSapphire", new ItemStack(TFCItems.gemSapphire, 1, 1));
/* 377 */     OreDictionary.registerOre("gemFlawedTopaz", new ItemStack(TFCItems.gemTopaz, 1, 1));
/* 378 */     OreDictionary.registerOre("gemFlawedTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 1));
/*     */     
/* 380 */     OreDictionary.registerOre("gemAgate", new ItemStack(TFCItems.gemAgate, 1, 2));
/* 381 */     OreDictionary.registerOre("gemAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 2));
/* 382 */     OreDictionary.registerOre("gemBeryl", new ItemStack(TFCItems.gemBeryl, 1, 2));
/* 383 */     OreDictionary.registerOre("gemDiamond", new ItemStack(TFCItems.gemDiamond, 1, 2));
/* 384 */     OreDictionary.registerOre("gemEmerald", new ItemStack(TFCItems.gemEmerald, 1, 2));
/* 385 */     OreDictionary.registerOre("gemGarnet", new ItemStack(TFCItems.gemGarnet, 1, 2));
/* 386 */     OreDictionary.registerOre("gemJade", new ItemStack(TFCItems.gemJade, 1, 2));
/* 387 */     OreDictionary.registerOre("gemJasper", new ItemStack(TFCItems.gemJasper, 1, 2));
/* 388 */     OreDictionary.registerOre("gemOpal", new ItemStack(TFCItems.gemOpal, 1, 2));
/* 389 */     OreDictionary.registerOre("gemRuby", new ItemStack(TFCItems.gemRuby, 1, 2));
/* 390 */     OreDictionary.registerOre("gemSapphire", new ItemStack(TFCItems.gemSapphire, 1, 2));
/* 391 */     OreDictionary.registerOre("gemTopaz", new ItemStack(TFCItems.gemTopaz, 1, 2));
/* 392 */     OreDictionary.registerOre("gemTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 2));
/*     */     
/* 394 */     OreDictionary.registerOre("gemFlawlessAgate", new ItemStack(TFCItems.gemAgate, 1, 3));
/* 395 */     OreDictionary.registerOre("gemFlawlessAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 3));
/* 396 */     OreDictionary.registerOre("gemFlawlessBeryl", new ItemStack(TFCItems.gemBeryl, 1, 3));
/* 397 */     OreDictionary.registerOre("gemFlawlessDiamond", new ItemStack(TFCItems.gemDiamond, 1, 3));
/* 398 */     OreDictionary.registerOre("gemFlawlessEmerald", new ItemStack(TFCItems.gemEmerald, 1, 3));
/* 399 */     OreDictionary.registerOre("gemFlawlessGarnet", new ItemStack(TFCItems.gemGarnet, 1, 3));
/* 400 */     OreDictionary.registerOre("gemFlawlessJade", new ItemStack(TFCItems.gemJade, 1, 3));
/* 401 */     OreDictionary.registerOre("gemFlawlessJasper", new ItemStack(TFCItems.gemJasper, 1, 3));
/* 402 */     OreDictionary.registerOre("gemFlawlessOpal", new ItemStack(TFCItems.gemOpal, 1, 3));
/* 403 */     OreDictionary.registerOre("gemFlawlessRuby", new ItemStack(TFCItems.gemRuby, 1, 3));
/* 404 */     OreDictionary.registerOre("gemFlawlessSapphire", new ItemStack(TFCItems.gemSapphire, 1, 3));
/* 405 */     OreDictionary.registerOre("gemFlawlessTopaz", new ItemStack(TFCItems.gemTopaz, 1, 3));
/* 406 */     OreDictionary.registerOre("gemFlawlessTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 3));
/*     */     
/* 408 */     OreDictionary.registerOre("gemExquisiteAgate", new ItemStack(TFCItems.gemAgate, 1, 4));
/* 409 */     OreDictionary.registerOre("gemExquisiteAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 4));
/* 410 */     OreDictionary.registerOre("gemExquisiteBeryl", new ItemStack(TFCItems.gemBeryl, 1, 4));
/* 411 */     OreDictionary.registerOre("gemExquisiteDiamond", new ItemStack(TFCItems.gemDiamond, 1, 4));
/* 412 */     OreDictionary.registerOre("gemExquisiteEmerald", new ItemStack(TFCItems.gemEmerald, 1, 4));
/* 413 */     OreDictionary.registerOre("gemExquisiteGarnet", new ItemStack(TFCItems.gemGarnet, 1, 4));
/* 414 */     OreDictionary.registerOre("gemExquisiteJade", new ItemStack(TFCItems.gemJade, 1, 4));
/* 415 */     OreDictionary.registerOre("gemExquisiteJasper", new ItemStack(TFCItems.gemJasper, 1, 4));
/* 416 */     OreDictionary.registerOre("gemExquisiteOpal", new ItemStack(TFCItems.gemOpal, 1, 4));
/* 417 */     OreDictionary.registerOre("gemExquisiteRuby", new ItemStack(TFCItems.gemRuby, 1, 4));
/* 418 */     OreDictionary.registerOre("gemExquisiteSapphire", new ItemStack(TFCItems.gemSapphire, 1, 4));
/* 419 */     OreDictionary.registerOre("gemExquisiteTopaz", new ItemStack(TFCItems.gemTopaz, 1, 4));
/* 420 */     OreDictionary.registerOre("gemExquisiteTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 4));
/*     */ 
/*     */     
/* 423 */     OreDictionary.registerOre("gemCoal", new ItemStack(Items.field_151044_h, 1, 0));
/* 424 */     OreDictionary.registerOre("gemCoal", new ItemStack(TFCItems.coal, 1, 0));
/* 425 */     OreDictionary.registerOre("gemCharcoal", new ItemStack(Items.field_151044_h, 1, 1));
/* 426 */     OreDictionary.registerOre("gemCharcoal", new ItemStack(TFCItems.coal, 1, 1));
/*     */ 
/*     */     
/* 429 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneIgEx, 1, 32767));
/* 430 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneIgIn, 1, 32767));
/* 431 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneMM, 1, 32767));
/* 432 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneSed, 1, 32767));
/*     */ 
/*     */     
/* 435 */     OreDictionary.registerOre("cobblestone", new ItemStack(TFCBlocks.stoneIgExCobble, 1, 32767));
/* 436 */     OreDictionary.registerOre("cobblestone", new ItemStack(TFCBlocks.stoneIgInCobble, 1, 32767));
/* 437 */     OreDictionary.registerOre("cobblestone", new ItemStack(TFCBlocks.stoneMMCobble, 1, 32767));
/* 438 */     OreDictionary.registerOre("cobblestone", new ItemStack(TFCBlocks.stoneSedCobble, 1, 32767));
/*     */     
/* 440 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneIgExCobble, 1, 32767));
/* 441 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneIgInCobble, 1, 32767));
/* 442 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneMMCobble, 1, 32767));
/* 443 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneSedCobble, 1, 32767));
/*     */ 
/*     */     
/* 446 */     OreDictionary.registerOre("ingotStoneBrick", new ItemStack(TFCItems.stoneBrick, 1, 32767));
/*     */ 
/*     */     
/* 449 */     OreDictionary.registerOre("stoneBrick", new ItemStack(Blocks.field_150417_aV));
/* 450 */     OreDictionary.registerOre("stoneBrick", new ItemStack(TFCBlocks.stoneIgExBrick, 1, 32767));
/* 451 */     OreDictionary.registerOre("stoneBrick", new ItemStack(TFCBlocks.stoneIgInBrick, 1, 32767));
/* 452 */     OreDictionary.registerOre("stoneBrick", new ItemStack(TFCBlocks.stoneMMBrick, 1, 32767));
/* 453 */     OreDictionary.registerOre("stoneBrick", new ItemStack(TFCBlocks.stoneSedBrick, 1, 32767));
/*     */ 
/*     */     
/* 456 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneIgExSmooth, 1, 32767));
/* 457 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneIgInSmooth, 1, 32767));
/* 458 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneMMSmooth, 1, 32767));
/* 459 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneSedSmooth, 1, 32767));
/*     */ 
/*     */     
/* 462 */     OreDictionary.registerOre("craftingTableWood", new ItemStack(TFCBlocks.workbench));
/* 463 */     OreDictionary.registerOre("craftingTableWood", new ItemStack(Blocks.field_150462_ai));
/*     */ 
/*     */     
/* 466 */     OreDictionary.registerOre("dyeBlack", new ItemStack(TFCItems.dye, 1, 0));
/* 467 */     OreDictionary.registerOre("dyeRed", new ItemStack(TFCItems.powder, 1, 5));
/* 468 */     OreDictionary.registerOre("dyeRed", new ItemStack(TFCItems.dye, 1, 1));
/* 469 */     OreDictionary.registerOre("dyeGreen", new ItemStack(TFCItems.powder, 1, 8));
/* 470 */     OreDictionary.registerOre("dyeGreen", new ItemStack(TFCItems.dye, 1, 2));
/* 471 */     OreDictionary.registerOre("dyeBrown", new ItemStack(TFCItems.dye, 1, 3));
/* 472 */     OreDictionary.registerOre("dyeBlue", new ItemStack(TFCItems.powder, 1, 6));
/* 473 */     OreDictionary.registerOre("dyeBlue", new ItemStack(TFCItems.dye, 1, 4));
/* 474 */     OreDictionary.registerOre("dyePurple", new ItemStack(TFCItems.dye, 1, 5));
/* 475 */     OreDictionary.registerOre("dyeCyan", new ItemStack(TFCItems.dye, 1, 6));
/* 476 */     OreDictionary.registerOre("dyeLightGray", new ItemStack(TFCItems.dye, 1, 7));
/* 477 */     OreDictionary.registerOre("dyeGray", new ItemStack(TFCItems.dye, 1, 8));
/* 478 */     OreDictionary.registerOre("dyePink", new ItemStack(TFCItems.dye, 1, 9));
/* 479 */     OreDictionary.registerOre("dyeLime", new ItemStack(TFCItems.dye, 1, 10));
/* 480 */     OreDictionary.registerOre("dyeYellow", new ItemStack(TFCItems.powder, 1, 7));
/* 481 */     OreDictionary.registerOre("dyeYellow", new ItemStack(TFCItems.dye, 1, 11));
/* 482 */     OreDictionary.registerOre("dyeLightBlue", new ItemStack(TFCItems.dye, 1, 12));
/* 483 */     OreDictionary.registerOre("dyeMagenta", new ItemStack(TFCItems.dye, 1, 13));
/* 484 */     OreDictionary.registerOre("dyeOrange", new ItemStack(TFCItems.dye, 1, 14));
/* 485 */     OreDictionary.registerOre("dyeWhite", new ItemStack(TFCItems.dye, 1, 15));
/*     */ 
/*     */     
/* 488 */     OreDictionary.registerOre("materialLeather", new ItemStack(Items.field_151116_aA));
/* 489 */     OreDictionary.registerOre("materialLeather", new ItemStack(TFCItems.leather));
/*     */     
/* 491 */     OreDictionary.registerOre("materialString", new ItemStack(Items.field_151007_F));
/* 492 */     OreDictionary.registerOre("materialString", new ItemStack(TFCItems.woolYarn));
/*     */     
/* 494 */     OreDictionary.registerOre("materialCloth", new ItemStack(TFCItems.woolCloth));
/* 495 */     OreDictionary.registerOre("materialCloth", new ItemStack(TFCItems.silkCloth));
/* 496 */     OreDictionary.registerOre("materialWool", new ItemStack(TFCItems.wool, 1, 32767));
/*     */ 
/*     */     
/* 499 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.igExStoneAxeHead, 1, 32767));
/* 500 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.igInStoneAxeHead, 1, 32767));
/* 501 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.mMStoneAxeHead, 1, 32767));
/* 502 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.sedStoneAxeHead, 1, 32767));
/*     */     
/* 504 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.igExStoneHoeHead, 1, 32767));
/* 505 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.igInStoneHoeHead, 1, 32767));
/* 506 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.mMStoneHoeHead, 1, 32767));
/* 507 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.sedStoneHoeHead, 1, 32767));
/*     */     
/* 509 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.igExStoneShovelHead, 1, 32767));
/* 510 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.igInStoneShovelHead, 1, 32767));
/* 511 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.mMStoneShovelHead, 1, 32767));
/* 512 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.sedStoneShovelHead, 1, 32767));
/*     */     
/* 514 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.igExStoneJavelinHead, 1, 32767));
/* 515 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.igInStoneJavelinHead, 1, 32767));
/* 516 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.mMStoneJavelinHead, 1, 32767));
/* 517 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.sedStoneJavelinHead, 1, 32767));
/*     */ 
/*     */     
/* 520 */     for (Item axe : Recipes.axes) {
/* 521 */       OreDictionary.registerOre("itemAxe", new ItemStack(axe, 1, 32767));
/*     */     }
/* 523 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.sedAxe, 1, 32767));
/* 524 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.igInAxe, 1, 32767));
/* 525 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.igExAxe, 1, 32767));
/* 526 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.mMAxe, 1, 32767));
/* 527 */     OreDictionary.registerOre("itemAxeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeAxe, 1, 32767));
/* 528 */     OreDictionary.registerOre("itemAxeBlackBronze", new ItemStack(TFCItems.blackBronzeAxe, 1, 32767));
/* 529 */     OreDictionary.registerOre("itemAxeBlackSteel", new ItemStack(TFCItems.blackSteelAxe, 1, 32767));
/* 530 */     OreDictionary.registerOre("itemAxeBlueSteel", new ItemStack(TFCItems.blueSteelAxe, 1, 32767));
/* 531 */     OreDictionary.registerOre("itemAxeBronze", new ItemStack(TFCItems.bronzeAxe, 1, 32767));
/* 532 */     OreDictionary.registerOre("itemAxeCopper", new ItemStack(TFCItems.copperAxe, 1, 32767));
/* 533 */     OreDictionary.registerOre("itemAxeWroughtIron", new ItemStack(TFCItems.wroughtIronAxe, 1, 32767));
/* 534 */     OreDictionary.registerOre("itemAxeRedSteel", new ItemStack(TFCItems.redSteelAxe, 1, 32767));
/* 535 */     OreDictionary.registerOre("itemAxeSteel", new ItemStack(TFCItems.steelAxe, 1, 32767));
/*     */     
/* 537 */     for (Item chisel : Recipes.chisels) {
/* 538 */       OreDictionary.registerOre("itemChisel", new ItemStack(chisel, 1, 32767));
/*     */     }
/* 540 */     OreDictionary.registerOre("itemChiselBismuthBronze", new ItemStack(TFCItems.bismuthBronzeChisel, 1, 32767));
/* 541 */     OreDictionary.registerOre("itemChiselBlackBronze", new ItemStack(TFCItems.blackBronzeChisel, 1, 32767));
/* 542 */     OreDictionary.registerOre("itemChiselBlackSteel", new ItemStack(TFCItems.blackSteelChisel, 1, 32767));
/* 543 */     OreDictionary.registerOre("itemChiselBlueSteel", new ItemStack(TFCItems.blueSteelChisel, 1, 32767));
/* 544 */     OreDictionary.registerOre("itemChiselBronze", new ItemStack(TFCItems.bronzeChisel, 1, 32767));
/* 545 */     OreDictionary.registerOre("itemChiselCopper", new ItemStack(TFCItems.copperChisel, 1, 32767));
/* 546 */     OreDictionary.registerOre("itemChiselWroughtIron", new ItemStack(TFCItems.wroughtIronChisel, 1, 32767));
/* 547 */     OreDictionary.registerOre("itemChiselRedSteel", new ItemStack(TFCItems.redSteelChisel, 1, 32767));
/* 548 */     OreDictionary.registerOre("itemChiselSteel", new ItemStack(TFCItems.steelChisel, 1, 32767));
/*     */     
/* 550 */     for (Item hammer : Recipes.hammers) {
/* 551 */       OreDictionary.registerOre("itemHammer", new ItemStack(hammer, 1, 32767));
/*     */     }
/* 553 */     OreDictionary.registerOre("itemHammerStone", new ItemStack(TFCItems.stoneHammer, 1, 32767));
/* 554 */     OreDictionary.registerOre("itemHammerBismuthBronze", new ItemStack(TFCItems.bismuthBronzeHammer, 1, 32767));
/* 555 */     OreDictionary.registerOre("itemHammerBlackBronze", new ItemStack(TFCItems.blackBronzeHammer, 1, 32767));
/* 556 */     OreDictionary.registerOre("itemHammerBlackSteel", new ItemStack(TFCItems.blackSteelHammer, 1, 32767));
/* 557 */     OreDictionary.registerOre("itemHammerBlueSteel", new ItemStack(TFCItems.blueSteelHammer, 1, 32767));
/* 558 */     OreDictionary.registerOre("itemHammerBronze", new ItemStack(TFCItems.bronzeHammer, 1, 32767));
/* 559 */     OreDictionary.registerOre("itemHammerCopper", new ItemStack(TFCItems.copperHammer, 1, 32767));
/* 560 */     OreDictionary.registerOre("itemHammerWroughtIron", new ItemStack(TFCItems.wroughtIronHammer, 1, 32767));
/* 561 */     OreDictionary.registerOre("itemHammerRedSteel", new ItemStack(TFCItems.redSteelHammer, 1, 32767));
/* 562 */     OreDictionary.registerOre("itemHammerSteel", new ItemStack(TFCItems.steelHammer, 1, 32767));
/*     */     
/* 564 */     for (Item knife : Recipes.knives) {
/* 565 */       OreDictionary.registerOre("itemKnife", new ItemStack(knife, 1, 32767));
/*     */     }
/* 567 */     OreDictionary.registerOre("itemKnifeStone", new ItemStack(TFCItems.stoneKnife, 1, 32767));
/* 568 */     OreDictionary.registerOre("itemKnifeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeKnife, 1, 32767));
/* 569 */     OreDictionary.registerOre("itemKnifeBlackBronze", new ItemStack(TFCItems.blackBronzeKnife, 1, 32767));
/* 570 */     OreDictionary.registerOre("itemKnifeBlackSteel", new ItemStack(TFCItems.blackSteelKnife, 1, 32767));
/* 571 */     OreDictionary.registerOre("itemKnifeBlueSteel", new ItemStack(TFCItems.blueSteelKnife, 1, 32767));
/* 572 */     OreDictionary.registerOre("itemKnifeBronze", new ItemStack(TFCItems.bronzeKnife, 1, 32767));
/* 573 */     OreDictionary.registerOre("itemKnifeCopper", new ItemStack(TFCItems.copperKnife, 1, 32767));
/* 574 */     OreDictionary.registerOre("itemKnifeWroughtIron", new ItemStack(TFCItems.wroughtIronKnife, 1, 32767));
/* 575 */     OreDictionary.registerOre("itemKnifeRedSteel", new ItemStack(TFCItems.redSteelKnife, 1, 32767));
/* 576 */     OreDictionary.registerOre("itemKnifeSteel", new ItemStack(TFCItems.steelKnife, 1, 32767));
/*     */     
/* 578 */     for (Item saw : Recipes.saws) {
/* 579 */       OreDictionary.registerOre("itemSaw", new ItemStack(saw, 1, 32767));
/*     */     }
/* 581 */     OreDictionary.registerOre("itemSawBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSaw, 1, 32767));
/* 582 */     OreDictionary.registerOre("itemSawBlackBronze", new ItemStack(TFCItems.blackBronzeSaw, 1, 32767));
/* 583 */     OreDictionary.registerOre("itemSawBlackSteel", new ItemStack(TFCItems.blackSteelSaw, 1, 32767));
/* 584 */     OreDictionary.registerOre("itemSawBlueSteel", new ItemStack(TFCItems.blueSteelSaw, 1, 32767));
/* 585 */     OreDictionary.registerOre("itemSawBronze", new ItemStack(TFCItems.bronzeSaw, 1, 32767));
/* 586 */     OreDictionary.registerOre("itemSawCopper", new ItemStack(TFCItems.copperSaw, 1, 32767));
/* 587 */     OreDictionary.registerOre("itemSawWroughtIron", new ItemStack(TFCItems.wroughtIronSaw, 1, 32767));
/* 588 */     OreDictionary.registerOre("itemSawRedSteel", new ItemStack(TFCItems.redSteelSaw, 1, 32767));
/* 589 */     OreDictionary.registerOre("itemSawSteel", new ItemStack(TFCItems.steelSaw, 1, 32767));
/*     */     
/* 591 */     for (Item scythe : Recipes.scythes) {
/* 592 */       OreDictionary.registerOre("itemScythe", new ItemStack(scythe, 1, 32767));
/*     */     }
/* 594 */     OreDictionary.registerOre("itemScytheBismuthBronze", new ItemStack(TFCItems.bismuthBronzeScythe, 1, 32767));
/* 595 */     OreDictionary.registerOre("itemScytheBlackBronze", new ItemStack(TFCItems.blackBronzeScythe, 1, 32767));
/* 596 */     OreDictionary.registerOre("itemScytheBlackSteel", new ItemStack(TFCItems.blackSteelScythe, 1, 32767));
/* 597 */     OreDictionary.registerOre("itemScytheBlueSteel", new ItemStack(TFCItems.blueSteelScythe, 1, 32767));
/* 598 */     OreDictionary.registerOre("itemScytheBronze", new ItemStack(TFCItems.bronzeScythe, 1, 32767));
/* 599 */     OreDictionary.registerOre("itemScytheCopper", new ItemStack(TFCItems.copperScythe, 1, 32767));
/* 600 */     OreDictionary.registerOre("itemScytheWroughtIron", new ItemStack(TFCItems.wroughtIronScythe, 1, 32767));
/* 601 */     OreDictionary.registerOre("itemScytheRedSteel", new ItemStack(TFCItems.redSteelScythe, 1, 32767));
/* 602 */     OreDictionary.registerOre("itemScytheSteel", new ItemStack(TFCItems.steelScythe, 1, 32767));
/*     */     
/* 604 */     for (Item pick : Recipes.picks) {
/* 605 */       OreDictionary.registerOre("itemPick", new ItemStack(pick, 1, 32767));
/*     */     }
/* 607 */     OreDictionary.registerOre("itemPickBismuthBronze", new ItemStack(TFCItems.bismuthBronzePick, 1, 32767));
/* 608 */     OreDictionary.registerOre("itemPickBlackBronze", new ItemStack(TFCItems.blackBronzePick, 1, 32767));
/* 609 */     OreDictionary.registerOre("itemPickBlackSteel", new ItemStack(TFCItems.blackSteelPick, 1, 32767));
/* 610 */     OreDictionary.registerOre("itemPickBlueSteel", new ItemStack(TFCItems.blueSteelPick, 1, 32767));
/* 611 */     OreDictionary.registerOre("itemPickBronze", new ItemStack(TFCItems.bronzePick, 1, 32767));
/* 612 */     OreDictionary.registerOre("itemPickCopper", new ItemStack(TFCItems.copperPick, 1, 32767));
/* 613 */     OreDictionary.registerOre("itemPickWroughtIron", new ItemStack(TFCItems.wroughtIronPick, 1, 32767));
/* 614 */     OreDictionary.registerOre("itemPickRedSteel", new ItemStack(TFCItems.redSteelPick, 1, 32767));
/* 615 */     OreDictionary.registerOre("itemPickSteel", new ItemStack(TFCItems.steelPick, 1, 32767));
/*     */     
/* 617 */     for (Item proPick : Recipes.proPicks) {
/* 618 */       OreDictionary.registerOre("itemProPick", new ItemStack(proPick, 1, 32767));
/*     */     }
/* 620 */     OreDictionary.registerOre("itemProPickBismuthBronze", new ItemStack(TFCItems.proPickBismuthBronze, 1, 32767));
/* 621 */     OreDictionary.registerOre("itemProPickBlackBronze", new ItemStack(TFCItems.proPickBlackBronze, 1, 32767));
/* 622 */     OreDictionary.registerOre("itemProPickBlackSteel", new ItemStack(TFCItems.proPickBlackSteel, 1, 32767));
/* 623 */     OreDictionary.registerOre("itemProPickBlueSteel", new ItemStack(TFCItems.proPickBlueSteel, 1, 32767));
/* 624 */     OreDictionary.registerOre("itemProPickBronze", new ItemStack(TFCItems.proPickBronze, 1, 32767));
/* 625 */     OreDictionary.registerOre("itemProPickCopper", new ItemStack(TFCItems.proPickCopper, 1, 32767));
/* 626 */     OreDictionary.registerOre("itemProPickWroughtIron", new ItemStack(TFCItems.proPickIron, 1, 32767));
/* 627 */     OreDictionary.registerOre("itemProPickRedSteel", new ItemStack(TFCItems.proPickRedSteel, 1, 32767));
/* 628 */     OreDictionary.registerOre("itemProPickSteel", new ItemStack(TFCItems.proPickSteel, 1, 32767));
/*     */     
/* 630 */     for (Item shovel : Recipes.shovels) {
/* 631 */       OreDictionary.registerOre("itemShovel", new ItemStack(shovel, 1, 32767));
/*     */     }
/* 633 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.sedShovel, 1, 32767));
/* 634 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.igInShovel, 1, 32767));
/* 635 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.igExShovel, 1, 32767));
/* 636 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.mMShovel, 1, 32767));
/* 637 */     OreDictionary.registerOre("itemShovelBismuthBronze", new ItemStack(TFCItems.bismuthBronzeShovel, 1, 32767));
/* 638 */     OreDictionary.registerOre("itemShovelBlackBronze", new ItemStack(TFCItems.blackBronzeShovel, 1, 32767));
/* 639 */     OreDictionary.registerOre("itemShovelBlackSteel", new ItemStack(TFCItems.blackSteelShovel, 1, 32767));
/* 640 */     OreDictionary.registerOre("itemShovelBlueSteel", new ItemStack(TFCItems.blueSteelShovel, 1, 32767));
/* 641 */     OreDictionary.registerOre("itemShovelBronze", new ItemStack(TFCItems.bronzeShovel, 1, 32767));
/* 642 */     OreDictionary.registerOre("itemShovelCopper", new ItemStack(TFCItems.copperShovel, 1, 32767));
/* 643 */     OreDictionary.registerOre("itemShovelWroughtIron", new ItemStack(TFCItems.wroughtIronShovel, 1, 32767));
/* 644 */     OreDictionary.registerOre("itemShovelRedSteel", new ItemStack(TFCItems.redSteelShovel, 1, 32767));
/* 645 */     OreDictionary.registerOre("itemShovelSteel", new ItemStack(TFCItems.steelShovel, 1, 32767));
/*     */     
/* 647 */     for (Item hoe : Recipes.hoes) {
/* 648 */       OreDictionary.registerOre("itemHoe", new ItemStack(hoe, 1, 32767));
/*     */     }
/* 650 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.sedHoe, 1, 32767));
/* 651 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.igInHoe, 1, 32767));
/* 652 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.igExHoe, 1, 32767));
/* 653 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.mMHoe, 1, 32767));
/* 654 */     OreDictionary.registerOre("itemHoeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeHoe, 1, 32767));
/* 655 */     OreDictionary.registerOre("itemHoeBlackBronze", new ItemStack(TFCItems.blackBronzeHoe, 1, 32767));
/* 656 */     OreDictionary.registerOre("itemHoeBlackSteel", new ItemStack(TFCItems.blackSteelHoe, 1, 32767));
/* 657 */     OreDictionary.registerOre("itemHoeBlueSteel", new ItemStack(TFCItems.blueSteelHoe, 1, 32767));
/* 658 */     OreDictionary.registerOre("itemHoeBronze", new ItemStack(TFCItems.bronzeHoe, 1, 32767));
/* 659 */     OreDictionary.registerOre("itemHoeCopper", new ItemStack(TFCItems.copperHoe, 1, 32767));
/* 660 */     OreDictionary.registerOre("itemHoeWroughtIron", new ItemStack(TFCItems.wroughtIronHoe, 1, 32767));
/* 661 */     OreDictionary.registerOre("itemHoeRedSteel", new ItemStack(TFCItems.redSteelHoe, 1, 32767));
/* 662 */     OreDictionary.registerOre("itemHoeSteel", new ItemStack(TFCItems.steelHoe, 1, 32767));
/*     */ 
/*     */     
/* 665 */     for (Item sword : Recipes.swords) {
/* 666 */       OreDictionary.registerOre("itemSword", new ItemStack(sword, 1, 32767));
/*     */     }
/* 668 */     OreDictionary.registerOre("itemSwordBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSword, 1, 32767));
/* 669 */     OreDictionary.registerOre("itemSwordBlackBronze", new ItemStack(TFCItems.blackBronzeSword, 1, 32767));
/* 670 */     OreDictionary.registerOre("itemSwordBlackSteel", new ItemStack(TFCItems.blackSteelSword, 1, 32767));
/* 671 */     OreDictionary.registerOre("itemSwordBlueSteel", new ItemStack(TFCItems.blueSteelSword, 1, 32767));
/* 672 */     OreDictionary.registerOre("itemSwordBronze", new ItemStack(TFCItems.bronzeSword, 1, 32767));
/* 673 */     OreDictionary.registerOre("itemSwordCopper", new ItemStack(TFCItems.copperSword, 1, 32767));
/* 674 */     OreDictionary.registerOre("itemSwordWroughtIron", new ItemStack(TFCItems.wroughtIronSword, 1, 32767));
/* 675 */     OreDictionary.registerOre("itemSwordRedSteel", new ItemStack(TFCItems.redSteelSword, 1, 32767));
/* 676 */     OreDictionary.registerOre("itemSwordSteel", new ItemStack(TFCItems.steelSword, 1, 32767));
/*     */     
/* 678 */     for (Item mace : Recipes.maces) {
/* 679 */       OreDictionary.registerOre("itemMace", new ItemStack(mace, 1, 32767));
/*     */     }
/* 681 */     OreDictionary.registerOre("itemMaceBismuthBronze", new ItemStack(TFCItems.bismuthBronzeMace, 1, 32767));
/* 682 */     OreDictionary.registerOre("itemMaceBlackBronze", new ItemStack(TFCItems.blackBronzeMace, 1, 32767));
/* 683 */     OreDictionary.registerOre("itemMaceBlackSteel", new ItemStack(TFCItems.blackSteelMace, 1, 32767));
/* 684 */     OreDictionary.registerOre("itemMaceBlueSteel", new ItemStack(TFCItems.blueSteelMace, 1, 32767));
/* 685 */     OreDictionary.registerOre("itemMaceBronze", new ItemStack(TFCItems.bronzeMace, 1, 32767));
/* 686 */     OreDictionary.registerOre("itemMaceCopper", new ItemStack(TFCItems.copperMace, 1, 32767));
/* 687 */     OreDictionary.registerOre("itemMaceWroughtIron", new ItemStack(TFCItems.wroughtIronMace, 1, 32767));
/* 688 */     OreDictionary.registerOre("itemMaceRedSteel", new ItemStack(TFCItems.redSteelMace, 1, 32767));
/* 689 */     OreDictionary.registerOre("itemMaceSteel", new ItemStack(TFCItems.steelMace, 1, 32767));
/*     */     
/* 691 */     for (Item javelin : Recipes.javelins) {
/* 692 */       OreDictionary.registerOre("itemJavelin", new ItemStack(javelin, 1, 32767));
/*     */     }
/* 694 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.sedStoneJavelin, 1, 32767));
/* 695 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.igInStoneJavelin, 1, 32767));
/* 696 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.igExStoneJavelin, 1, 32767));
/* 697 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.mMStoneJavelin, 1, 32767));
/* 698 */     OreDictionary.registerOre("itemJavelinBismuthBronze", new ItemStack(TFCItems.bismuthBronzeJavelin, 1, 32767));
/* 699 */     OreDictionary.registerOre("itemJavelinBlackBronze", new ItemStack(TFCItems.blackBronzeJavelin, 1, 32767));
/* 700 */     OreDictionary.registerOre("itemJavelinBlackSteel", new ItemStack(TFCItems.blackSteelJavelin, 1, 32767));
/* 701 */     OreDictionary.registerOre("itemJavelinBlueSteel", new ItemStack(TFCItems.blueSteelJavelin, 1, 32767));
/* 702 */     OreDictionary.registerOre("itemJavelinBronze", new ItemStack(TFCItems.bronzeJavelin, 1, 32767));
/* 703 */     OreDictionary.registerOre("itemJavelinCopper", new ItemStack(TFCItems.copperJavelin, 1, 32767));
/* 704 */     OreDictionary.registerOre("itemJavelinWroughtIron", new ItemStack(TFCItems.wroughtIronJavelin, 1, 32767));
/* 705 */     OreDictionary.registerOre("itemJavelinRedSteel", new ItemStack(TFCItems.redSteelJavelin, 1, 32767));
/* 706 */     OreDictionary.registerOre("itemJavelinSteel", new ItemStack(TFCItems.steelJavelin, 1, 32767));
/*     */     
/* 708 */     for (Item tuyere : Recipes.tuyeres) {
/* 709 */       OreDictionary.registerOre("itemTuyere", new ItemStack(tuyere, 1, 32767));
/*     */     }
/* 711 */     OreDictionary.registerOre("itemTuyereBismuthBronze", new ItemStack(TFCItems.tuyereBismuthBronze, 1, 32767));
/* 712 */     OreDictionary.registerOre("itemTuyereBlackBronze", new ItemStack(TFCItems.tuyereBlackBronze, 1, 32767));
/* 713 */     OreDictionary.registerOre("itemTuyereBlackSteel", new ItemStack(TFCItems.tuyereBlackSteel, 1, 32767));
/* 714 */     OreDictionary.registerOre("itemTuyereBlueSteel", new ItemStack(TFCItems.tuyereBlueSteel, 1, 32767));
/* 715 */     OreDictionary.registerOre("itemTuyereBronze", new ItemStack(TFCItems.tuyereBronze, 1, 32767));
/* 716 */     OreDictionary.registerOre("itemTuyereCopper", new ItemStack(TFCItems.tuyereCopper, 1, 32767));
/* 717 */     OreDictionary.registerOre("itemTuyereWroughtIron", new ItemStack(TFCItems.tuyereWroughtIron, 1, 32767));
/* 718 */     OreDictionary.registerOre("itemTuyereRedSteel", new ItemStack(TFCItems.tuyereRedSteel, 1, 32767));
/* 719 */     OreDictionary.registerOre("itemTuyereSteel", new ItemStack(TFCItems.tuyereSteel, 1, 32767));
/*     */ 
/*     */     
/* 722 */     OreDictionary.registerOre("lumpClay", new ItemStack(Items.field_151119_aD));
/* 723 */     OreDictionary.registerOre("lumpClay", new ItemStack(TFCItems.clayBall, 1, 0));
/*     */     
/* 725 */     OreDictionary.registerOre("itemArrow", new ItemStack(Items.field_151032_g));
/* 726 */     OreDictionary.registerOre("itemArrow", new ItemStack(TFCItems.arrow));
/*     */     
/* 728 */     OreDictionary.registerOre("itemReed", new ItemStack(Items.field_151120_aE));
/* 729 */     OreDictionary.registerOre("itemReed", new ItemStack(TFCItems.reeds));
/*     */     
/* 731 */     OreDictionary.registerOre("itemRock", new ItemStack(TFCItems.looseRock, 1, 32767));
/*     */     
/* 733 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(Items.field_151133_ar));
/* 734 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.woodenBucketEmpty));
/* 735 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.redSteelBucketEmpty));
/* 736 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.blueSteelBucketEmpty));
/*     */     
/* 738 */     OreDictionary.registerOre("bucketWater", new ItemStack(Items.field_151131_as));
/* 739 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.woodenBucketWater, 1, 32767));
/* 740 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.redSteelBucketWater, 1, 32767));
/* 741 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.woodenBucketSaltWater, 1, 32767));
/* 742 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.redSteelBucketSaltWater, 1, 32767));
/*     */     
/* 744 */     OreDictionary.registerOre("bucketFreshWater", new ItemStack(TFCItems.woodenBucketWater, 1, 32767));
/* 745 */     OreDictionary.registerOre("bucketFreshWater", new ItemStack(TFCItems.redSteelBucketWater, 1, 32767));
/*     */     
/* 747 */     OreDictionary.registerOre("bucketSaltWater", new ItemStack(TFCItems.woodenBucketSaltWater, 1, 32767));
/* 748 */     OreDictionary.registerOre("bucketSaltWater", new ItemStack(TFCItems.redSteelBucketSaltWater, 1, 32767));
/*     */     
/* 750 */     OreDictionary.registerOre("bucketLava", new ItemStack(Items.field_151129_at));
/* 751 */     OreDictionary.registerOre("bucketLava", new ItemStack(TFCItems.blueSteelBucketLava));
/*     */     
/* 753 */     OreDictionary.registerOre("bucketMilk", new ItemStack(Items.field_151117_aB));
/* 754 */     OreDictionary.registerOre("bucketMilk", new ItemStack(TFCItems.woodenBucketMilk));
/*     */     
/* 756 */     OreDictionary.registerOre("toolFlintSteel", new ItemStack(Items.field_151033_d, 1, 32767));
/* 757 */     OreDictionary.registerOre("toolFlintSteel", new ItemStack(TFCItems.flintSteel, 1, 32767));
/*     */ 
/*     */     
/* 760 */     OreDictionary.registerOre("blockSand", new ItemStack((Block)Blocks.field_150354_m));
/* 761 */     OreDictionary.registerOre("blockSand", new ItemStack(TFCBlocks.sand, 1, 32767));
/* 762 */     OreDictionary.registerOre("blockSand", new ItemStack(TFCBlocks.sand2, 1, 32767));
/*     */ 
/*     */     
/* 765 */     OreDictionary.registerOre("blockGravel", new ItemStack(TFCBlocks.gravel, 1, 32767));
/* 766 */     OreDictionary.registerOre("blockGravel", new ItemStack(TFCBlocks.gravel2, 1, 32767));
/*     */     
/* 768 */     OreDictionary.registerOre("blockDirt", new ItemStack(Blocks.field_150346_d));
/* 769 */     OreDictionary.registerOre("blockDirt", new ItemStack(TFCBlocks.dirt, 1, 32767));
/* 770 */     OreDictionary.registerOre("blockDirt", new ItemStack(TFCBlocks.dirt2, 1, 32767));
/*     */     
/* 772 */     OreDictionary.registerOre("blockTorch", new ItemStack(Blocks.field_150478_aa));
/* 773 */     OreDictionary.registerOre("blockTorch", new ItemStack(TFCBlocks.torch));
/*     */     
/* 775 */     OreDictionary.registerOre("blockPumpkin", new ItemStack(Blocks.field_150423_aK));
/* 776 */     OreDictionary.registerOre("blockPumpkin", new ItemStack(TFCBlocks.pumpkin));
/* 777 */     OreDictionary.registerOre("blockLitPumpkin", new ItemStack(Blocks.field_150428_aP));
/* 778 */     OreDictionary.registerOre("blockLitPumpkin", new ItemStack(TFCBlocks.litPumpkin));
/*     */     
/* 780 */     OreDictionary.registerOre("blockIce", new ItemStack(TFCBlocks.ice, 1, 32767));
/*     */ 
/*     */     
/* 783 */     for (Item seed : Recipes.seeds)
/* 784 */       OreDictionary.registerOre("seedBag", new ItemStack(seed, 1, 32767)); 
/* 785 */     OreDictionary.registerOre("seedWheat", new ItemStack(TFCItems.seedsWheat, 1, 32767));
/* 786 */     OreDictionary.registerOre("seedMaize", new ItemStack(TFCItems.seedsMaize, 1, 32767));
/* 787 */     OreDictionary.registerOre("seedTomato", new ItemStack(TFCItems.seedsTomato, 1, 32767));
/* 788 */     OreDictionary.registerOre("seedBarley", new ItemStack(TFCItems.seedsBarley, 1, 32767));
/* 789 */     OreDictionary.registerOre("seedRye", new ItemStack(TFCItems.seedsRye, 1, 32767));
/* 790 */     OreDictionary.registerOre("seedOat", new ItemStack(TFCItems.seedsOat, 1, 32767));
/* 791 */     OreDictionary.registerOre("seedRice", new ItemStack(TFCItems.seedsRice, 1, 32767));
/* 792 */     OreDictionary.registerOre("seedPotato", new ItemStack(TFCItems.seedsPotato, 1, 32767));
/* 793 */     OreDictionary.registerOre("seedOnion", new ItemStack(TFCItems.seedsOnion, 1, 32767));
/* 794 */     OreDictionary.registerOre("seedCabbage", new ItemStack(TFCItems.seedsCabbage, 1, 32767));
/* 795 */     OreDictionary.registerOre("seedGarlic", new ItemStack(TFCItems.seedsGarlic, 1, 32767));
/* 796 */     OreDictionary.registerOre("seedCarrot", new ItemStack(TFCItems.seedsCarrot, 1, 32767));
/* 797 */     OreDictionary.registerOre("seedSugarcane", new ItemStack(TFCItems.seedsSugarcane, 1, 32767));
/* 798 */     OreDictionary.registerOre("seedYelloBellPepper", new ItemStack(TFCItems.seedsYellowBellPepper, 1, 32767));
/* 799 */     OreDictionary.registerOre("seedRedBellPepper", new ItemStack(TFCItems.seedsRedBellPepper, 1, 32767));
/* 800 */     OreDictionary.registerOre("seedSoybean", new ItemStack(TFCItems.seedsSoybean, 1, 32767));
/* 801 */     OreDictionary.registerOre("seedGreenbean", new ItemStack(TFCItems.seedsGreenbean, 1, 32767));
/* 802 */     OreDictionary.registerOre("seedSquash", new ItemStack(TFCItems.seedsSquash, 1, 32767));
/* 803 */     OreDictionary.registerOre("seedJute", new ItemStack(TFCItems.seedsJute, 1, 32767));
/*     */ 
/*     */     
/* 806 */     OreDictionary.registerOre("fruitTreeSapling", new ItemStack(TFCItems.fruitTreeSapling, 1, 32767));
/* 807 */     OreDictionary.registerOre("fruitTreeSaplingRedApple", new ItemStack(TFCItems.fruitTreeSapling, 1, 0));
/* 808 */     OreDictionary.registerOre("fruitTreeSaplingBanana", new ItemStack(TFCItems.fruitTreeSapling, 1, 1));
/* 809 */     OreDictionary.registerOre("fruitTreeSaplingOrange", new ItemStack(TFCItems.fruitTreeSapling, 1, 2));
/* 810 */     OreDictionary.registerOre("fruitTreeSaplingGreenApple", new ItemStack(TFCItems.fruitTreeSapling, 1, 3));
/* 811 */     OreDictionary.registerOre("fruitTreeSaplingLemon", new ItemStack(TFCItems.fruitTreeSapling, 1, 4));
/* 812 */     OreDictionary.registerOre("fruitTreeSaplingOlive", new ItemStack(TFCItems.fruitTreeSapling, 1, 5));
/* 813 */     OreDictionary.registerOre("fruitTreeSaplingCherry", new ItemStack(TFCItems.fruitTreeSapling, 1, 6));
/* 814 */     OreDictionary.registerOre("fruitTreeSaplingPeach", new ItemStack(TFCItems.fruitTreeSapling, 1, 7));
/* 815 */     OreDictionary.registerOre("fruitTreeSaplingPlum", new ItemStack(TFCItems.fruitTreeSapling, 1, 8));
/*     */ 
/*     */     
/* 818 */     OreDictionary.registerOre("bushBerry", new ItemStack(TFCBlocks.berryBush, 1, 32767));
/* 819 */     OreDictionary.registerOre("bushBerryBlueberry", new ItemStack(TFCBlocks.berryBush, 1, 0));
/* 820 */     OreDictionary.registerOre("bushBerryRaspberry", new ItemStack(TFCBlocks.berryBush, 1, 1));
/* 821 */     OreDictionary.registerOre("bushBerryStrawberry", new ItemStack(TFCBlocks.berryBush, 1, 2));
/* 822 */     OreDictionary.registerOre("bushBerryBlackberry", new ItemStack(TFCBlocks.berryBush, 1, 3));
/* 823 */     OreDictionary.registerOre("bushBerryBunchberry", new ItemStack(TFCBlocks.berryBush, 1, 4));
/* 824 */     OreDictionary.registerOre("bushBerryCranberry", new ItemStack(TFCBlocks.berryBush, 1, 5));
/* 825 */     OreDictionary.registerOre("bushBerrySnowberry", new ItemStack(TFCBlocks.berryBush, 1, 6));
/* 826 */     OreDictionary.registerOre("bushBerryElderberry", new ItemStack(TFCBlocks.berryBush, 1, 7));
/* 827 */     OreDictionary.registerOre("bushBerryGooseberry", new ItemStack(TFCBlocks.berryBush, 1, 8));
/* 828 */     OreDictionary.registerOre("bushBerryCloudberry", new ItemStack(TFCBlocks.berryBush, 1, 9));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_OreDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */