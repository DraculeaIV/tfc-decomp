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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     OreDictionary.registerOre("oreCoal", new ItemStack(TFCItems.oreChunk, 1, 14));
/* 115 */     OreDictionary.registerOre("oreCoal", new ItemStack(TFCItems.oreChunk, 1, 15));
/*     */     
/* 117 */     OreDictionary.registerOre("oreKaolinite", new ItemStack(TFCItems.oreChunk, 1, 16));
/* 118 */     OreDictionary.registerOre("oreGypsum", new ItemStack(TFCItems.oreChunk, 1, 17));
/* 119 */     OreDictionary.registerOre("oreSatinspar", new ItemStack(TFCItems.oreChunk, 1, 18));
/* 120 */     OreDictionary.registerOre("oreSelenite", new ItemStack(TFCItems.oreChunk, 1, 19));
/* 121 */     OreDictionary.registerOre("oreGraphite", new ItemStack(TFCItems.oreChunk, 1, 20));
/* 122 */     OreDictionary.registerOre("oreDiamond", new ItemStack(TFCItems.oreChunk, 1, 21));
/* 123 */     OreDictionary.registerOre("orePetrifiedWood", new ItemStack(TFCItems.oreChunk, 1, 22));
/* 124 */     OreDictionary.registerOre("oreSulfur", new ItemStack(TFCItems.oreChunk, 1, 23));
/* 125 */     OreDictionary.registerOre("oreJet", new ItemStack(TFCItems.oreChunk, 1, 24));
/* 126 */     OreDictionary.registerOre("oreMicrocline", new ItemStack(TFCItems.oreChunk, 1, 25));
/*     */ 
/*     */     
/* 129 */     OreDictionary.registerOre("oreRedstone", new ItemStack(TFCItems.oreChunk, 1, 27));
/*     */ 
/*     */     
/* 132 */     OreDictionary.registerOre("oreSaltpeter", new ItemStack(TFCItems.oreChunk, 1, 29));
/* 133 */     OreDictionary.registerOre("oreSerpentine", new ItemStack(TFCItems.oreChunk, 1, 30));
/* 134 */     OreDictionary.registerOre("oreSylvite", new ItemStack(TFCItems.oreChunk, 1, 31));
/* 135 */     OreDictionary.registerOre("oreBorax", new ItemStack(TFCItems.oreChunk, 1, 32));
/* 136 */     OreDictionary.registerOre("oreOlivine", new ItemStack(TFCItems.oreChunk, 1, 33));
/* 137 */     OreDictionary.registerOre("oreLapis", new ItemStack(TFCItems.oreChunk, 1, 34));
/*     */ 
/*     */     
/* 140 */     OreDictionary.registerOre("dustFlux", new ItemStack(TFCItems.powder, 1, 0));
/* 141 */     OreDictionary.registerOre("dustKaolinite", new ItemStack(TFCItems.powder, 1, 1));
/* 142 */     OreDictionary.registerOre("dustGraphite", new ItemStack(TFCItems.powder, 1, 2));
/* 143 */     OreDictionary.registerOre("dustSulfur", new ItemStack(TFCItems.powder, 1, 3));
/* 144 */     OreDictionary.registerOre("dustSaltpeter", new ItemStack(TFCItems.powder, 1, 4));
/* 145 */     OreDictionary.registerOre("dustLapis", new ItemStack(TFCItems.powder, 1, 6));
/* 146 */     OreDictionary.registerOre("dustSalt", new ItemStack(TFCItems.powder, 1, 9));
/*     */ 
/*     */     
/* 149 */     OreDictionary.registerOre("ingotBismuth", new ItemStack(TFCItems.bismuthIngot));
/* 150 */     OreDictionary.registerOre("ingotTin", new ItemStack(TFCItems.tinIngot));
/* 151 */     OreDictionary.registerOre("ingotZinc", new ItemStack(TFCItems.zincIngot));
/* 152 */     OreDictionary.registerOre("ingotCopper", new ItemStack(TFCItems.copperIngot));
/* 153 */     OreDictionary.registerOre("ingotBronze", new ItemStack(TFCItems.bronzeIngot));
/* 154 */     OreDictionary.registerOre("ingotBismuthBronze", new ItemStack(TFCItems.bismuthBronzeIngot));
/* 155 */     OreDictionary.registerOre("ingotBlackBronze", new ItemStack(TFCItems.blackBronzeIngot));
/* 156 */     OreDictionary.registerOre("ingotBrass", new ItemStack(TFCItems.brassIngot));
/* 157 */     OreDictionary.registerOre("ingotLead", new ItemStack(TFCItems.leadIngot));
/* 158 */     OreDictionary.registerOre("ingotGold", new ItemStack(TFCItems.goldIngot));
/* 159 */     OreDictionary.registerOre("ingotRoseGold", new ItemStack(TFCItems.roseGoldIngot));
/* 160 */     OreDictionary.registerOre("ingotSilver", new ItemStack(TFCItems.silverIngot));
/* 161 */     OreDictionary.registerOre("ingotSterlingSilver", new ItemStack(TFCItems.sterlingSilverIngot));
/* 162 */     OreDictionary.registerOre("ingotPlatinum", new ItemStack(TFCItems.platinumIngot));
/* 163 */     OreDictionary.registerOre("ingotWroughtIron", new ItemStack(TFCItems.wroughtIronIngot));
/* 164 */     OreDictionary.registerOre("ingotIron", new ItemStack(TFCItems.wroughtIronIngot));
/* 165 */     OreDictionary.registerOre("ingotNickel", new ItemStack(TFCItems.nickelIngot));
/* 166 */     OreDictionary.registerOre("ingotPigIron", new ItemStack(TFCItems.pigIronIngot));
/* 167 */     OreDictionary.registerOre("ingotSteel", new ItemStack(TFCItems.steelIngot));
/* 168 */     OreDictionary.registerOre("ingotBlackSteel", new ItemStack(TFCItems.blackSteelIngot));
/* 169 */     OreDictionary.registerOre("ingotRedSteel", new ItemStack(TFCItems.redSteelIngot));
/* 170 */     OreDictionary.registerOre("ingotBlueSteel", new ItemStack(TFCItems.blueSteelIngot));
/* 171 */     OreDictionary.registerOre("ingotUnknown", new ItemStack(TFCItems.unknownIngot));
/*     */     
/* 173 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.bronzeIngot));
/* 174 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.bismuthBronzeIngot));
/* 175 */     OreDictionary.registerOre("ingotAnyBronze", new ItemStack(TFCItems.blackBronzeIngot));
/*     */ 
/*     */     
/* 178 */     OreDictionary.registerOre("ingotDoubleBismuth", new ItemStack(TFCItems.bismuthIngot2x));
/* 179 */     OreDictionary.registerOre("ingotDoubleTin", new ItemStack(TFCItems.tinIngot2x));
/* 180 */     OreDictionary.registerOre("ingotDoubleZinc", new ItemStack(TFCItems.zincIngot2x));
/* 181 */     OreDictionary.registerOre("ingotDoubleCopper", new ItemStack(TFCItems.copperIngot2x));
/* 182 */     OreDictionary.registerOre("ingotDoubleBronze", new ItemStack(TFCItems.bronzeIngot2x));
/* 183 */     OreDictionary.registerOre("ingotDoubleBismuthBronze", new ItemStack(TFCItems.bismuthBronzeIngot2x));
/* 184 */     OreDictionary.registerOre("ingotDoubleBlackBronze", new ItemStack(TFCItems.blackBronzeIngot2x));
/* 185 */     OreDictionary.registerOre("ingotDoubleBrass", new ItemStack(TFCItems.brassIngot2x));
/* 186 */     OreDictionary.registerOre("ingotDoubleLead", new ItemStack(TFCItems.leadIngot2x));
/* 187 */     OreDictionary.registerOre("ingotDoubleGold", new ItemStack(TFCItems.goldIngot2x));
/* 188 */     OreDictionary.registerOre("ingotDoubleRoseGold", new ItemStack(TFCItems.roseGoldIngot2x));
/* 189 */     OreDictionary.registerOre("ingotDoubleSilver", new ItemStack(TFCItems.silverIngot2x));
/* 190 */     OreDictionary.registerOre("ingotDoubleSterlingSilver", new ItemStack(TFCItems.sterlingSilverIngot2x));
/* 191 */     OreDictionary.registerOre("ingotDoublePlatinum", new ItemStack(TFCItems.platinumIngot2x));
/* 192 */     OreDictionary.registerOre("ingotDoubleWroughtIron", new ItemStack(TFCItems.wroughtIronIngot2x));
/* 193 */     OreDictionary.registerOre("ingotDoubleNickel", new ItemStack(TFCItems.nickelIngot2x));
/* 194 */     OreDictionary.registerOre("ingotDoublePigIron", new ItemStack(TFCItems.pigIronIngot2x));
/* 195 */     OreDictionary.registerOre("ingotDoubleSteel", new ItemStack(TFCItems.steelIngot2x));
/* 196 */     OreDictionary.registerOre("ingotDoubleBlackSteel", new ItemStack(TFCItems.blackSteelIngot2x));
/* 197 */     OreDictionary.registerOre("ingotDoubleRedSteel", new ItemStack(TFCItems.redSteelIngot2x));
/* 198 */     OreDictionary.registerOre("ingotDoubleBlueSteel", new ItemStack(TFCItems.blueSteelIngot2x));
/*     */     
/* 200 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.bronzeIngot2x));
/* 201 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.bismuthBronzeIngot2x));
/* 202 */     OreDictionary.registerOre("ingotDoubleAnyBronze", new ItemStack(TFCItems.blackBronzeIngot2x));
/*     */ 
/*     */     
/* 205 */     OreDictionary.registerOre("plateBismuth", new ItemStack(TFCItems.bismuthSheet));
/* 206 */     OreDictionary.registerOre("plateTin", new ItemStack(TFCItems.tinSheet));
/* 207 */     OreDictionary.registerOre("plateZinc", new ItemStack(TFCItems.zincSheet));
/* 208 */     OreDictionary.registerOre("plateCopper", new ItemStack(TFCItems.copperSheet));
/* 209 */     OreDictionary.registerOre("plateBronze", new ItemStack(TFCItems.bronzeSheet));
/* 210 */     OreDictionary.registerOre("plateBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSheet));
/* 211 */     OreDictionary.registerOre("plateBlackBronze", new ItemStack(TFCItems.blackBronzeSheet));
/* 212 */     OreDictionary.registerOre("plateBrass", new ItemStack(TFCItems.brassSheet));
/* 213 */     OreDictionary.registerOre("plateLead", new ItemStack(TFCItems.leadSheet));
/* 214 */     OreDictionary.registerOre("plateGold", new ItemStack(TFCItems.goldSheet));
/* 215 */     OreDictionary.registerOre("plateRoseGold", new ItemStack(TFCItems.roseGoldSheet));
/* 216 */     OreDictionary.registerOre("plateSilver", new ItemStack(TFCItems.silverSheet));
/* 217 */     OreDictionary.registerOre("plateSterlingSilver", new ItemStack(TFCItems.sterlingSilverSheet));
/* 218 */     OreDictionary.registerOre("platePlatinum", new ItemStack(TFCItems.platinumSheet));
/* 219 */     OreDictionary.registerOre("plateWroughtIron", new ItemStack(TFCItems.wroughtIronSheet));
/* 220 */     OreDictionary.registerOre("plateIron", new ItemStack(TFCItems.wroughtIronSheet));
/* 221 */     OreDictionary.registerOre("plateNickel", new ItemStack(TFCItems.nickelSheet));
/* 222 */     OreDictionary.registerOre("platePigIron", new ItemStack(TFCItems.pigIronSheet));
/* 223 */     OreDictionary.registerOre("plateSteel", new ItemStack(TFCItems.steelSheet));
/* 224 */     OreDictionary.registerOre("plateBlackSteel", new ItemStack(TFCItems.blackSteelSheet));
/* 225 */     OreDictionary.registerOre("plateRedSteel", new ItemStack(TFCItems.redSteelSheet));
/* 226 */     OreDictionary.registerOre("plateBlueSteel", new ItemStack(TFCItems.blueSteelSheet));
/*     */     
/* 228 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.bronzeSheet));
/* 229 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.bismuthBronzeSheet));
/* 230 */     OreDictionary.registerOre("plateAnyBronze", new ItemStack(TFCItems.blackBronzeSheet));
/*     */ 
/*     */     
/* 233 */     OreDictionary.registerOre("plateDoubleBismuth", new ItemStack(TFCItems.bismuthSheet2x));
/* 234 */     OreDictionary.registerOre("plateDoubleTin", new ItemStack(TFCItems.tinSheet2x));
/* 235 */     OreDictionary.registerOre("plateDoubleZinc", new ItemStack(TFCItems.zincSheet2x));
/* 236 */     OreDictionary.registerOre("plateDoubleCopper", new ItemStack(TFCItems.copperSheet2x));
/* 237 */     OreDictionary.registerOre("plateDoubleBronze", new ItemStack(TFCItems.bronzeSheet2x));
/* 238 */     OreDictionary.registerOre("plateDoubleBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSheet2x));
/* 239 */     OreDictionary.registerOre("plateDoubleBlackBronze", new ItemStack(TFCItems.blackBronzeSheet2x));
/* 240 */     OreDictionary.registerOre("plateDoubleBrass", new ItemStack(TFCItems.brassSheet2x));
/* 241 */     OreDictionary.registerOre("plateDoubleLead", new ItemStack(TFCItems.leadSheet2x));
/* 242 */     OreDictionary.registerOre("plateDoubleGold", new ItemStack(TFCItems.goldSheet2x));
/* 243 */     OreDictionary.registerOre("plateDoubleRoseGold", new ItemStack(TFCItems.roseGoldSheet2x));
/* 244 */     OreDictionary.registerOre("plateDoubleSilver", new ItemStack(TFCItems.silverSheet2x));
/* 245 */     OreDictionary.registerOre("plateDoubleSterlingSilver", new ItemStack(TFCItems.sterlingSilverSheet2x));
/* 246 */     OreDictionary.registerOre("plateDoublePlatinum", new ItemStack(TFCItems.platinumSheet2x));
/* 247 */     OreDictionary.registerOre("plateDoubleWroughtIron", new ItemStack(TFCItems.wroughtIronSheet2x));
/* 248 */     OreDictionary.registerOre("plateDoubleNickel", new ItemStack(TFCItems.nickelSheet2x));
/* 249 */     OreDictionary.registerOre("plateDoublePigIron", new ItemStack(TFCItems.pigIronSheet2x));
/* 250 */     OreDictionary.registerOre("plateDoubleSteel", new ItemStack(TFCItems.steelSheet2x));
/* 251 */     OreDictionary.registerOre("plateDoubleBlackSteel", new ItemStack(TFCItems.blackSteelSheet2x));
/* 252 */     OreDictionary.registerOre("plateDoubleRedSteel", new ItemStack(TFCItems.redSteelSheet2x));
/* 253 */     OreDictionary.registerOre("plateDoubleBlueSteel", new ItemStack(TFCItems.blueSteelSheet2x));
/*     */     
/* 255 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.bronzeSheet2x));
/* 256 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.bismuthBronzeSheet2x));
/* 257 */     OreDictionary.registerOre("plateDoubleAnyBronze", new ItemStack(TFCItems.blackBronzeSheet2x));
/*     */ 
/*     */     
/* 260 */     OreDictionary.registerOre("gemChippedAgate", new ItemStack(TFCItems.gemAgate));
/* 261 */     OreDictionary.registerOre("gemChippedAmethyst", new ItemStack(TFCItems.gemAmethyst));
/* 262 */     OreDictionary.registerOre("gemChippedBeryl", new ItemStack(TFCItems.gemBeryl));
/* 263 */     OreDictionary.registerOre("gemChippedDiamond", new ItemStack(TFCItems.gemDiamond));
/* 264 */     OreDictionary.registerOre("gemChippedEmerald", new ItemStack(TFCItems.gemEmerald));
/* 265 */     OreDictionary.registerOre("gemChippedGarnet", new ItemStack(TFCItems.gemGarnet));
/* 266 */     OreDictionary.registerOre("gemChippedJade", new ItemStack(TFCItems.gemJade));
/* 267 */     OreDictionary.registerOre("gemChippedJasper", new ItemStack(TFCItems.gemJasper));
/* 268 */     OreDictionary.registerOre("gemChippedOpal", new ItemStack(TFCItems.gemOpal));
/* 269 */     OreDictionary.registerOre("gemChippedRuby", new ItemStack(TFCItems.gemRuby));
/* 270 */     OreDictionary.registerOre("gemChippedSapphire", new ItemStack(TFCItems.gemSapphire));
/* 271 */     OreDictionary.registerOre("gemChippedTopaz", new ItemStack(TFCItems.gemTopaz));
/* 272 */     OreDictionary.registerOre("gemChippedTourmaline", new ItemStack(TFCItems.gemTourmaline));
/*     */     
/* 274 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemAgate));
/* 275 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemAmethyst));
/* 276 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemBeryl));
/* 277 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemDiamond));
/* 278 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemEmerald));
/* 279 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemGarnet));
/* 280 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemJade));
/* 281 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemJasper));
/* 282 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemOpal));
/* 283 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemRuby));
/* 284 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemSapphire));
/* 285 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemTopaz));
/* 286 */     OreDictionary.registerOre("gemChipped", new ItemStack(TFCItems.gemTourmaline));
/*     */     
/* 288 */     OreDictionary.registerOre("gemFlawedAgate", new ItemStack(TFCItems.gemAgate, 1, 1));
/* 289 */     OreDictionary.registerOre("gemFlawedAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 1));
/* 290 */     OreDictionary.registerOre("gemFlawedBeryl", new ItemStack(TFCItems.gemBeryl, 1, 1));
/* 291 */     OreDictionary.registerOre("gemFlawedDiamond", new ItemStack(TFCItems.gemDiamond, 1, 1));
/* 292 */     OreDictionary.registerOre("gemFlawedEmerald", new ItemStack(TFCItems.gemEmerald, 1, 1));
/* 293 */     OreDictionary.registerOre("gemFlawedGarnet", new ItemStack(TFCItems.gemGarnet, 1, 1));
/* 294 */     OreDictionary.registerOre("gemFlawedJade", new ItemStack(TFCItems.gemJade, 1, 1));
/* 295 */     OreDictionary.registerOre("gemFlawedJasper", new ItemStack(TFCItems.gemJasper, 1, 1));
/* 296 */     OreDictionary.registerOre("gemFlawedOpal", new ItemStack(TFCItems.gemOpal, 1, 1));
/* 297 */     OreDictionary.registerOre("gemFlawedRuby", new ItemStack(TFCItems.gemRuby, 1, 1));
/* 298 */     OreDictionary.registerOre("gemFlawedSapphire", new ItemStack(TFCItems.gemSapphire, 1, 1));
/* 299 */     OreDictionary.registerOre("gemFlawedTopaz", new ItemStack(TFCItems.gemTopaz, 1, 1));
/* 300 */     OreDictionary.registerOre("gemFlawedTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 1));
/*     */     
/* 302 */     OreDictionary.registerOre("gemAgate", new ItemStack(TFCItems.gemAgate, 1, 2));
/* 303 */     OreDictionary.registerOre("gemAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 2));
/* 304 */     OreDictionary.registerOre("gemBeryl", new ItemStack(TFCItems.gemBeryl, 1, 2));
/* 305 */     OreDictionary.registerOre("gemDiamond", new ItemStack(TFCItems.gemDiamond, 1, 2));
/* 306 */     OreDictionary.registerOre("gemEmerald", new ItemStack(TFCItems.gemEmerald, 1, 2));
/* 307 */     OreDictionary.registerOre("gemGarnet", new ItemStack(TFCItems.gemGarnet, 1, 2));
/* 308 */     OreDictionary.registerOre("gemJade", new ItemStack(TFCItems.gemJade, 1, 2));
/* 309 */     OreDictionary.registerOre("gemJasper", new ItemStack(TFCItems.gemJasper, 1, 2));
/* 310 */     OreDictionary.registerOre("gemOpal", new ItemStack(TFCItems.gemOpal, 1, 2));
/* 311 */     OreDictionary.registerOre("gemRuby", new ItemStack(TFCItems.gemRuby, 1, 2));
/* 312 */     OreDictionary.registerOre("gemSapphire", new ItemStack(TFCItems.gemSapphire, 1, 2));
/* 313 */     OreDictionary.registerOre("gemTopaz", new ItemStack(TFCItems.gemTopaz, 1, 2));
/* 314 */     OreDictionary.registerOre("gemTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 2));
/*     */     
/* 316 */     OreDictionary.registerOre("gemFlawlessAgate", new ItemStack(TFCItems.gemAgate, 1, 3));
/* 317 */     OreDictionary.registerOre("gemFlawlessAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 3));
/* 318 */     OreDictionary.registerOre("gemFlawlessBeryl", new ItemStack(TFCItems.gemBeryl, 1, 3));
/* 319 */     OreDictionary.registerOre("gemFlawlessDiamond", new ItemStack(TFCItems.gemDiamond, 1, 3));
/* 320 */     OreDictionary.registerOre("gemFlawlessEmerald", new ItemStack(TFCItems.gemEmerald, 1, 3));
/* 321 */     OreDictionary.registerOre("gemFlawlessGarnet", new ItemStack(TFCItems.gemGarnet, 1, 3));
/* 322 */     OreDictionary.registerOre("gemFlawlessJade", new ItemStack(TFCItems.gemJade, 1, 3));
/* 323 */     OreDictionary.registerOre("gemFlawlessJasper", new ItemStack(TFCItems.gemJasper, 1, 3));
/* 324 */     OreDictionary.registerOre("gemFlawlessOpal", new ItemStack(TFCItems.gemOpal, 1, 3));
/* 325 */     OreDictionary.registerOre("gemFlawlessRuby", new ItemStack(TFCItems.gemRuby, 1, 3));
/* 326 */     OreDictionary.registerOre("gemFlawlessSapphire", new ItemStack(TFCItems.gemSapphire, 1, 3));
/* 327 */     OreDictionary.registerOre("gemFlawlessTopaz", new ItemStack(TFCItems.gemTopaz, 1, 3));
/* 328 */     OreDictionary.registerOre("gemFlawlessTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 3));
/*     */     
/* 330 */     OreDictionary.registerOre("gemExquisiteAgate", new ItemStack(TFCItems.gemAgate, 1, 4));
/* 331 */     OreDictionary.registerOre("gemExquisiteAmethyst", new ItemStack(TFCItems.gemAmethyst, 1, 4));
/* 332 */     OreDictionary.registerOre("gemExquisiteBeryl", new ItemStack(TFCItems.gemBeryl, 1, 4));
/* 333 */     OreDictionary.registerOre("gemExquisiteDiamond", new ItemStack(TFCItems.gemDiamond, 1, 4));
/* 334 */     OreDictionary.registerOre("gemExquisiteEmerald", new ItemStack(TFCItems.gemEmerald, 1, 4));
/* 335 */     OreDictionary.registerOre("gemExquisiteGarnet", new ItemStack(TFCItems.gemGarnet, 1, 4));
/* 336 */     OreDictionary.registerOre("gemExquisiteJade", new ItemStack(TFCItems.gemJade, 1, 4));
/* 337 */     OreDictionary.registerOre("gemExquisiteJasper", new ItemStack(TFCItems.gemJasper, 1, 4));
/* 338 */     OreDictionary.registerOre("gemExquisiteOpal", new ItemStack(TFCItems.gemOpal, 1, 4));
/* 339 */     OreDictionary.registerOre("gemExquisiteRuby", new ItemStack(TFCItems.gemRuby, 1, 4));
/* 340 */     OreDictionary.registerOre("gemExquisiteSapphire", new ItemStack(TFCItems.gemSapphire, 1, 4));
/* 341 */     OreDictionary.registerOre("gemExquisiteTopaz", new ItemStack(TFCItems.gemTopaz, 1, 4));
/* 342 */     OreDictionary.registerOre("gemExquisiteTourmaline", new ItemStack(TFCItems.gemTourmaline, 1, 4));
/*     */ 
/*     */     
/* 345 */     OreDictionary.registerOre("gemCoal", new ItemStack(Items.field_151044_h, 1, 0));
/* 346 */     OreDictionary.registerOre("gemCoal", new ItemStack(TFCItems.coal, 1, 0));
/* 347 */     OreDictionary.registerOre("gemCharcoal", new ItemStack(Items.field_151044_h, 1, 1));
/* 348 */     OreDictionary.registerOre("gemCharcoal", new ItemStack(TFCItems.coal, 1, 1));
/*     */ 
/*     */     
/* 351 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneIgEx, 1, 32767));
/* 352 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneIgIn, 1, 32767));
/* 353 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneMM, 1, 32767));
/* 354 */     OreDictionary.registerOre("stone", new ItemStack(TFCBlocks.stoneSed, 1, 32767));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 362 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneIgExCobble, 1, 32767));
/* 363 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneIgInCobble, 1, 32767));
/* 364 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneMMCobble, 1, 32767));
/* 365 */     OreDictionary.registerOre("stoneCobble", new ItemStack(TFCBlocks.stoneSedCobble, 1, 32767));
/*     */ 
/*     */     
/* 368 */     OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.field_150417_aV));
/* 369 */     OreDictionary.registerOre("stoneBricks", new ItemStack(TFCBlocks.stoneIgExBrick, 1, 32767));
/* 370 */     OreDictionary.registerOre("stoneBricks", new ItemStack(TFCBlocks.stoneIgInBrick, 1, 32767));
/* 371 */     OreDictionary.registerOre("stoneBricks", new ItemStack(TFCBlocks.stoneMMBrick, 1, 32767));
/* 372 */     OreDictionary.registerOre("stoneBricks", new ItemStack(TFCBlocks.stoneSedBrick, 1, 32767));
/*     */ 
/*     */     
/* 375 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneIgExSmooth, 1, 32767));
/* 376 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneIgInSmooth, 1, 32767));
/* 377 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneMMSmooth, 1, 32767));
/* 378 */     OreDictionary.registerOre("stoneSmooth", new ItemStack(TFCBlocks.stoneSedSmooth, 1, 32767));
/*     */ 
/*     */     
/* 381 */     OreDictionary.registerOre("craftingTableWood", new ItemStack(TFCBlocks.workbench));
/* 382 */     OreDictionary.registerOre("craftingTableWood", new ItemStack(Blocks.field_150462_ai));
/*     */ 
/*     */     
/* 385 */     OreDictionary.registerOre("dyeBlack", new ItemStack(TFCItems.dye, 1, 0));
/* 386 */     OreDictionary.registerOre("dyeRed", new ItemStack(TFCItems.powder, 1, 5));
/* 387 */     OreDictionary.registerOre("dyeRed", new ItemStack(TFCItems.dye, 1, 1));
/* 388 */     OreDictionary.registerOre("dyeGreen", new ItemStack(TFCItems.powder, 1, 8));
/* 389 */     OreDictionary.registerOre("dyeGreen", new ItemStack(TFCItems.dye, 1, 2));
/* 390 */     OreDictionary.registerOre("dyeBrown", new ItemStack(TFCItems.dye, 1, 3));
/* 391 */     OreDictionary.registerOre("dyeBlue", new ItemStack(TFCItems.powder, 1, 6));
/* 392 */     OreDictionary.registerOre("dyeBlue", new ItemStack(TFCItems.dye, 1, 4));
/* 393 */     OreDictionary.registerOre("dyePurple", new ItemStack(TFCItems.dye, 1, 5));
/* 394 */     OreDictionary.registerOre("dyeCyan", new ItemStack(TFCItems.dye, 1, 6));
/* 395 */     OreDictionary.registerOre("dyeLightGray", new ItemStack(TFCItems.dye, 1, 7));
/* 396 */     OreDictionary.registerOre("dyeGray", new ItemStack(TFCItems.dye, 1, 8));
/* 397 */     OreDictionary.registerOre("dyePink", new ItemStack(TFCItems.dye, 1, 9));
/* 398 */     OreDictionary.registerOre("dyeLime", new ItemStack(TFCItems.dye, 1, 10));
/* 399 */     OreDictionary.registerOre("dyeYellow", new ItemStack(TFCItems.powder, 1, 7));
/* 400 */     OreDictionary.registerOre("dyeYellow", new ItemStack(TFCItems.dye, 1, 11));
/* 401 */     OreDictionary.registerOre("dyeLightBlue", new ItemStack(TFCItems.dye, 1, 12));
/* 402 */     OreDictionary.registerOre("dyeMagenta", new ItemStack(TFCItems.dye, 1, 13));
/* 403 */     OreDictionary.registerOre("dyeOrange", new ItemStack(TFCItems.dye, 1, 14));
/* 404 */     OreDictionary.registerOre("dyeWhite", new ItemStack(TFCItems.dye, 1, 15));
/*     */ 
/*     */     
/* 407 */     OreDictionary.registerOre("materialLeather", new ItemStack(Items.field_151116_aA));
/* 408 */     OreDictionary.registerOre("materialLeather", new ItemStack(TFCItems.leather));
/*     */     
/* 410 */     OreDictionary.registerOre("materialString", new ItemStack(Items.field_151007_F));
/* 411 */     OreDictionary.registerOre("materialString", new ItemStack(TFCItems.woolYarn));
/*     */     
/* 413 */     OreDictionary.registerOre("materialCloth", new ItemStack(TFCItems.woolCloth));
/* 414 */     OreDictionary.registerOre("materialCloth", new ItemStack(TFCItems.silkCloth));
/* 415 */     OreDictionary.registerOre("materialWool", new ItemStack(TFCItems.wool, 1, 32767));
/*     */ 
/*     */     
/* 418 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.igExStoneAxeHead, 1, 32767));
/* 419 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.igInStoneAxeHead, 1, 32767));
/* 420 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.mMStoneAxeHead, 1, 32767));
/* 421 */     OreDictionary.registerOre("itemAxeStoneHead", new ItemStack(TFCItems.sedStoneAxeHead, 1, 32767));
/*     */     
/* 423 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.igExStoneHoeHead, 1, 32767));
/* 424 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.igInStoneHoeHead, 1, 32767));
/* 425 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.mMStoneHoeHead, 1, 32767));
/* 426 */     OreDictionary.registerOre("itemHoeStoneHead", new ItemStack(TFCItems.sedStoneHoeHead, 1, 32767));
/*     */     
/* 428 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.igExStoneShovelHead, 1, 32767));
/* 429 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.igInStoneShovelHead, 1, 32767));
/* 430 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.mMStoneShovelHead, 1, 32767));
/* 431 */     OreDictionary.registerOre("itemShovelStoneHead", new ItemStack(TFCItems.sedStoneShovelHead, 1, 32767));
/*     */     
/* 433 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.igExStoneJavelinHead, 1, 32767));
/* 434 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.igInStoneJavelinHead, 1, 32767));
/* 435 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.mMStoneJavelinHead, 1, 32767));
/* 436 */     OreDictionary.registerOre("itemJavelinStoneHead", new ItemStack(TFCItems.sedStoneJavelinHead, 1, 32767));
/*     */ 
/*     */     
/* 439 */     for (Item axe : Recipes.axes) {
/* 440 */       OreDictionary.registerOre("itemAxe", new ItemStack(axe, 1, 32767));
/*     */     }
/* 442 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.sedAxe, 1, 32767));
/* 443 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.igInAxe, 1, 32767));
/* 444 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.igExAxe, 1, 32767));
/* 445 */     OreDictionary.registerOre("itemAxeStone", new ItemStack(TFCItems.mMAxe, 1, 32767));
/* 446 */     OreDictionary.registerOre("itemAxeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeAxe, 1, 32767));
/* 447 */     OreDictionary.registerOre("itemAxeBlackBronze", new ItemStack(TFCItems.blackBronzeAxe, 1, 32767));
/* 448 */     OreDictionary.registerOre("itemAxeBlackSteel", new ItemStack(TFCItems.blackSteelAxe, 1, 32767));
/* 449 */     OreDictionary.registerOre("itemAxeBlueSteel", new ItemStack(TFCItems.blueSteelAxe, 1, 32767));
/* 450 */     OreDictionary.registerOre("itemAxeBronze", new ItemStack(TFCItems.bronzeAxe, 1, 32767));
/* 451 */     OreDictionary.registerOre("itemAxeCopper", new ItemStack(TFCItems.copperAxe, 1, 32767));
/* 452 */     OreDictionary.registerOre("itemAxeWroughtIron", new ItemStack(TFCItems.wroughtIronAxe, 1, 32767));
/* 453 */     OreDictionary.registerOre("itemAxeRedSteel", new ItemStack(TFCItems.redSteelAxe, 1, 32767));
/* 454 */     OreDictionary.registerOre("itemAxeSteel", new ItemStack(TFCItems.steelAxe, 1, 32767));
/*     */     
/* 456 */     for (Item chisel : Recipes.chisels) {
/* 457 */       OreDictionary.registerOre("itemChisel", new ItemStack(chisel, 1, 32767));
/*     */     }
/* 459 */     OreDictionary.registerOre("itemChiselBismuthBronze", new ItemStack(TFCItems.bismuthBronzeChisel, 1, 32767));
/* 460 */     OreDictionary.registerOre("itemChiselBlackBronze", new ItemStack(TFCItems.blackBronzeChisel, 1, 32767));
/* 461 */     OreDictionary.registerOre("itemChiselBlackSteel", new ItemStack(TFCItems.blackSteelChisel, 1, 32767));
/* 462 */     OreDictionary.registerOre("itemChiselBlueSteel", new ItemStack(TFCItems.blueSteelChisel, 1, 32767));
/* 463 */     OreDictionary.registerOre("itemChiselBronze", new ItemStack(TFCItems.bronzeChisel, 1, 32767));
/* 464 */     OreDictionary.registerOre("itemChiselCopper", new ItemStack(TFCItems.copperChisel, 1, 32767));
/* 465 */     OreDictionary.registerOre("itemChiselWroughtIron", new ItemStack(TFCItems.wroughtIronChisel, 1, 32767));
/* 466 */     OreDictionary.registerOre("itemChiselRedSteel", new ItemStack(TFCItems.redSteelChisel, 1, 32767));
/* 467 */     OreDictionary.registerOre("itemChiselSteel", new ItemStack(TFCItems.steelChisel, 1, 32767));
/*     */     
/* 469 */     for (Item hammer : Recipes.hammers) {
/* 470 */       OreDictionary.registerOre("itemHammer", new ItemStack(hammer, 1, 32767));
/*     */     }
/* 472 */     OreDictionary.registerOre("itemHammerStone", new ItemStack(TFCItems.stoneHammer, 1, 32767));
/* 473 */     OreDictionary.registerOre("itemHammerBismuthBronze", new ItemStack(TFCItems.bismuthBronzeHammer, 1, 32767));
/* 474 */     OreDictionary.registerOre("itemHammerBlackBronze", new ItemStack(TFCItems.blackBronzeHammer, 1, 32767));
/* 475 */     OreDictionary.registerOre("itemHammerBlackSteel", new ItemStack(TFCItems.blackSteelHammer, 1, 32767));
/* 476 */     OreDictionary.registerOre("itemHammerBlueSteel", new ItemStack(TFCItems.blueSteelHammer, 1, 32767));
/* 477 */     OreDictionary.registerOre("itemHammerBronze", new ItemStack(TFCItems.bronzeHammer, 1, 32767));
/* 478 */     OreDictionary.registerOre("itemHammerCopper", new ItemStack(TFCItems.copperHammer, 1, 32767));
/* 479 */     OreDictionary.registerOre("itemHammerWroughtIron", new ItemStack(TFCItems.wroughtIronHammer, 1, 32767));
/* 480 */     OreDictionary.registerOre("itemHammerRedSteel", new ItemStack(TFCItems.redSteelHammer, 1, 32767));
/* 481 */     OreDictionary.registerOre("itemHammerSteel", new ItemStack(TFCItems.steelHammer, 1, 32767));
/*     */     
/* 483 */     for (Item knife : Recipes.knives) {
/* 484 */       OreDictionary.registerOre("itemKnife", new ItemStack(knife, 1, 32767));
/*     */     }
/* 486 */     OreDictionary.registerOre("itemKnifeStone", new ItemStack(TFCItems.stoneKnife, 1, 32767));
/* 487 */     OreDictionary.registerOre("itemKnifeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeKnife, 1, 32767));
/* 488 */     OreDictionary.registerOre("itemKnifeBlackBronze", new ItemStack(TFCItems.blackBronzeKnife, 1, 32767));
/* 489 */     OreDictionary.registerOre("itemKnifeBlackSteel", new ItemStack(TFCItems.blackSteelKnife, 1, 32767));
/* 490 */     OreDictionary.registerOre("itemKnifeBlueSteel", new ItemStack(TFCItems.blueSteelKnife, 1, 32767));
/* 491 */     OreDictionary.registerOre("itemKnifeBronze", new ItemStack(TFCItems.bronzeKnife, 1, 32767));
/* 492 */     OreDictionary.registerOre("itemKnifeCopper", new ItemStack(TFCItems.copperKnife, 1, 32767));
/* 493 */     OreDictionary.registerOre("itemKnifeWroughtIron", new ItemStack(TFCItems.wroughtIronKnife, 1, 32767));
/* 494 */     OreDictionary.registerOre("itemKnifeRedSteel", new ItemStack(TFCItems.redSteelKnife, 1, 32767));
/* 495 */     OreDictionary.registerOre("itemKnifeSteel", new ItemStack(TFCItems.steelKnife, 1, 32767));
/*     */     
/* 497 */     for (Item saw : Recipes.saws) {
/* 498 */       OreDictionary.registerOre("itemSaw", new ItemStack(saw, 1, 32767));
/*     */     }
/* 500 */     OreDictionary.registerOre("itemSawBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSaw, 1, 32767));
/* 501 */     OreDictionary.registerOre("itemSawBlackBronze", new ItemStack(TFCItems.blackBronzeSaw, 1, 32767));
/* 502 */     OreDictionary.registerOre("itemSawBlackSteel", new ItemStack(TFCItems.blackSteelSaw, 1, 32767));
/* 503 */     OreDictionary.registerOre("itemSawBlueSteel", new ItemStack(TFCItems.blueSteelSaw, 1, 32767));
/* 504 */     OreDictionary.registerOre("itemSawBronze", new ItemStack(TFCItems.bronzeSaw, 1, 32767));
/* 505 */     OreDictionary.registerOre("itemSawCopper", new ItemStack(TFCItems.copperSaw, 1, 32767));
/* 506 */     OreDictionary.registerOre("itemSawWroughtIron", new ItemStack(TFCItems.wroughtIronSaw, 1, 32767));
/* 507 */     OreDictionary.registerOre("itemSawRedSteel", new ItemStack(TFCItems.redSteelSaw, 1, 32767));
/* 508 */     OreDictionary.registerOre("itemSawSteel", new ItemStack(TFCItems.steelSaw, 1, 32767));
/*     */     
/* 510 */     for (Item scythe : Recipes.scythes) {
/* 511 */       OreDictionary.registerOre("itemScythe", new ItemStack(scythe, 1, 32767));
/*     */     }
/* 513 */     OreDictionary.registerOre("itemScytheBismuthBronze", new ItemStack(TFCItems.bismuthBronzeScythe, 1, 32767));
/* 514 */     OreDictionary.registerOre("itemScytheBlackBronze", new ItemStack(TFCItems.blackBronzeScythe, 1, 32767));
/* 515 */     OreDictionary.registerOre("itemScytheBlackSteel", new ItemStack(TFCItems.blackSteelScythe, 1, 32767));
/* 516 */     OreDictionary.registerOre("itemScytheBlueSteel", new ItemStack(TFCItems.blueSteelScythe, 1, 32767));
/* 517 */     OreDictionary.registerOre("itemScytheBronze", new ItemStack(TFCItems.bronzeScythe, 1, 32767));
/* 518 */     OreDictionary.registerOre("itemScytheCopper", new ItemStack(TFCItems.copperScythe, 1, 32767));
/* 519 */     OreDictionary.registerOre("itemScytheWroughtIron", new ItemStack(TFCItems.wroughtIronScythe, 1, 32767));
/* 520 */     OreDictionary.registerOre("itemScytheRedSteel", new ItemStack(TFCItems.redSteelScythe, 1, 32767));
/* 521 */     OreDictionary.registerOre("itemScytheSteel", new ItemStack(TFCItems.steelScythe, 1, 32767));
/*     */     
/* 523 */     for (Item pick : Recipes.picks) {
/* 524 */       OreDictionary.registerOre("itemPick", new ItemStack(pick, 1, 32767));
/*     */     }
/* 526 */     OreDictionary.registerOre("itemPickBismuthBronze", new ItemStack(TFCItems.bismuthBronzePick, 1, 32767));
/* 527 */     OreDictionary.registerOre("itemPickBlackBronze", new ItemStack(TFCItems.blackBronzePick, 1, 32767));
/* 528 */     OreDictionary.registerOre("itemPickBlackSteel", new ItemStack(TFCItems.blackSteelPick, 1, 32767));
/* 529 */     OreDictionary.registerOre("itemPickBlueSteel", new ItemStack(TFCItems.blueSteelPick, 1, 32767));
/* 530 */     OreDictionary.registerOre("itemPickBronze", new ItemStack(TFCItems.bronzePick, 1, 32767));
/* 531 */     OreDictionary.registerOre("itemPickCopper", new ItemStack(TFCItems.copperPick, 1, 32767));
/* 532 */     OreDictionary.registerOre("itemPickWroughtIron", new ItemStack(TFCItems.wroughtIronPick, 1, 32767));
/* 533 */     OreDictionary.registerOre("itemPickRedSteel", new ItemStack(TFCItems.redSteelPick, 1, 32767));
/* 534 */     OreDictionary.registerOre("itemPickSteel", new ItemStack(TFCItems.steelPick, 1, 32767));
/*     */     
/* 536 */     for (Item proPick : Recipes.proPicks) {
/* 537 */       OreDictionary.registerOre("itemProPick", new ItemStack(proPick, 1, 32767));
/*     */     }
/* 539 */     OreDictionary.registerOre("itemProPickBismuthBronze", new ItemStack(TFCItems.proPickBismuthBronze, 1, 32767));
/* 540 */     OreDictionary.registerOre("itemProPickBlackBronze", new ItemStack(TFCItems.proPickBlackBronze, 1, 32767));
/* 541 */     OreDictionary.registerOre("itemProPickBlackSteel", new ItemStack(TFCItems.proPickBlackSteel, 1, 32767));
/* 542 */     OreDictionary.registerOre("itemProPickBlueSteel", new ItemStack(TFCItems.proPickBlueSteel, 1, 32767));
/* 543 */     OreDictionary.registerOre("itemProPickBronze", new ItemStack(TFCItems.proPickBronze, 1, 32767));
/* 544 */     OreDictionary.registerOre("itemProPickCopper", new ItemStack(TFCItems.proPickCopper, 1, 32767));
/* 545 */     OreDictionary.registerOre("itemProPickWroughtIron", new ItemStack(TFCItems.proPickIron, 1, 32767));
/* 546 */     OreDictionary.registerOre("itemProPickRedSteel", new ItemStack(TFCItems.proPickRedSteel, 1, 32767));
/* 547 */     OreDictionary.registerOre("itemProPickSteel", new ItemStack(TFCItems.proPickSteel, 1, 32767));
/*     */     
/* 549 */     for (Item shovel : Recipes.shovels) {
/* 550 */       OreDictionary.registerOre("itemShovel", new ItemStack(shovel, 1, 32767));
/*     */     }
/* 552 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.sedShovel, 1, 32767));
/* 553 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.igInShovel, 1, 32767));
/* 554 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.igExShovel, 1, 32767));
/* 555 */     OreDictionary.registerOre("itemShovelStone", new ItemStack(TFCItems.mMShovel, 1, 32767));
/* 556 */     OreDictionary.registerOre("itemShovelBismuthBronze", new ItemStack(TFCItems.bismuthBronzeShovel, 1, 32767));
/* 557 */     OreDictionary.registerOre("itemShovelBlackBronze", new ItemStack(TFCItems.blackBronzeShovel, 1, 32767));
/* 558 */     OreDictionary.registerOre("itemShovelBlackSteel", new ItemStack(TFCItems.blackSteelShovel, 1, 32767));
/* 559 */     OreDictionary.registerOre("itemShovelBlueSteel", new ItemStack(TFCItems.blueSteelShovel, 1, 32767));
/* 560 */     OreDictionary.registerOre("itemShovelBronze", new ItemStack(TFCItems.bronzeShovel, 1, 32767));
/* 561 */     OreDictionary.registerOre("itemShovelCopper", new ItemStack(TFCItems.copperShovel, 1, 32767));
/* 562 */     OreDictionary.registerOre("itemShovelWroughtIron", new ItemStack(TFCItems.wroughtIronShovel, 1, 32767));
/* 563 */     OreDictionary.registerOre("itemShovelRedSteel", new ItemStack(TFCItems.redSteelShovel, 1, 32767));
/* 564 */     OreDictionary.registerOre("itemShovelSteel", new ItemStack(TFCItems.steelShovel, 1, 32767));
/*     */     
/* 566 */     for (Item hoe : Recipes.hoes) {
/* 567 */       OreDictionary.registerOre("itemHoe", new ItemStack(hoe, 1, 32767));
/*     */     }
/* 569 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.sedHoe, 1, 32767));
/* 570 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.igInHoe, 1, 32767));
/* 571 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.igExHoe, 1, 32767));
/* 572 */     OreDictionary.registerOre("itemHoeStone", new ItemStack(TFCItems.mMHoe, 1, 32767));
/* 573 */     OreDictionary.registerOre("itemHoeBismuthBronze", new ItemStack(TFCItems.bismuthBronzeHoe, 1, 32767));
/* 574 */     OreDictionary.registerOre("itemHoeBlackBronze", new ItemStack(TFCItems.blackBronzeHoe, 1, 32767));
/* 575 */     OreDictionary.registerOre("itemHoeBlackSteel", new ItemStack(TFCItems.blackSteelHoe, 1, 32767));
/* 576 */     OreDictionary.registerOre("itemHoeBlueSteel", new ItemStack(TFCItems.blueSteelHoe, 1, 32767));
/* 577 */     OreDictionary.registerOre("itemHoeBronze", new ItemStack(TFCItems.bronzeHoe, 1, 32767));
/* 578 */     OreDictionary.registerOre("itemHoeCopper", new ItemStack(TFCItems.copperHoe, 1, 32767));
/* 579 */     OreDictionary.registerOre("itemHoeWroughtIron", new ItemStack(TFCItems.wroughtIronHoe, 1, 32767));
/* 580 */     OreDictionary.registerOre("itemHoeRedSteel", new ItemStack(TFCItems.redSteelHoe, 1, 32767));
/* 581 */     OreDictionary.registerOre("itemHoeSteel", new ItemStack(TFCItems.steelHoe, 1, 32767));
/*     */ 
/*     */     
/* 584 */     for (Item sword : Recipes.swords) {
/* 585 */       OreDictionary.registerOre("itemSword", new ItemStack(sword, 1, 32767));
/*     */     }
/* 587 */     OreDictionary.registerOre("itemSwordBismuthBronze", new ItemStack(TFCItems.bismuthBronzeSword, 1, 32767));
/* 588 */     OreDictionary.registerOre("itemSwordBlackBronze", new ItemStack(TFCItems.blackBronzeSword, 1, 32767));
/* 589 */     OreDictionary.registerOre("itemSwordBlackSteel", new ItemStack(TFCItems.blackSteelSword, 1, 32767));
/* 590 */     OreDictionary.registerOre("itemSwordBlueSteel", new ItemStack(TFCItems.blueSteelSword, 1, 32767));
/* 591 */     OreDictionary.registerOre("itemSwordBronze", new ItemStack(TFCItems.bronzeSword, 1, 32767));
/* 592 */     OreDictionary.registerOre("itemSwordCopper", new ItemStack(TFCItems.copperSword, 1, 32767));
/* 593 */     OreDictionary.registerOre("itemSwordWroughtIron", new ItemStack(TFCItems.wroughtIronSword, 1, 32767));
/* 594 */     OreDictionary.registerOre("itemSwordRedSteel", new ItemStack(TFCItems.redSteelSword, 1, 32767));
/* 595 */     OreDictionary.registerOre("itemSwordSteel", new ItemStack(TFCItems.steelSword, 1, 32767));
/*     */     
/* 597 */     for (Item mace : Recipes.maces) {
/* 598 */       OreDictionary.registerOre("itemMace", new ItemStack(mace, 1, 32767));
/*     */     }
/* 600 */     OreDictionary.registerOre("itemMaceBismuthBronze", new ItemStack(TFCItems.bismuthBronzeMace, 1, 32767));
/* 601 */     OreDictionary.registerOre("itemMaceBlackBronze", new ItemStack(TFCItems.blackBronzeMace, 1, 32767));
/* 602 */     OreDictionary.registerOre("itemMaceBlackSteel", new ItemStack(TFCItems.blackSteelMace, 1, 32767));
/* 603 */     OreDictionary.registerOre("itemMaceBlueSteel", new ItemStack(TFCItems.blueSteelMace, 1, 32767));
/* 604 */     OreDictionary.registerOre("itemMaceBronze", new ItemStack(TFCItems.bronzeMace, 1, 32767));
/* 605 */     OreDictionary.registerOre("itemMaceCopper", new ItemStack(TFCItems.copperMace, 1, 32767));
/* 606 */     OreDictionary.registerOre("itemMaceWroughtIron", new ItemStack(TFCItems.wroughtIronMace, 1, 32767));
/* 607 */     OreDictionary.registerOre("itemMaceRedSteel", new ItemStack(TFCItems.redSteelMace, 1, 32767));
/* 608 */     OreDictionary.registerOre("itemMaceSteel", new ItemStack(TFCItems.steelMace, 1, 32767));
/*     */     
/* 610 */     for (Item javelin : Recipes.javelins) {
/* 611 */       OreDictionary.registerOre("itemJavelin", new ItemStack(javelin, 1, 32767));
/*     */     }
/* 613 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.sedStoneJavelin, 1, 32767));
/* 614 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.igInStoneJavelin, 1, 32767));
/* 615 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.igExStoneJavelin, 1, 32767));
/* 616 */     OreDictionary.registerOre("itemJavelinStone", new ItemStack(TFCItems.mMStoneJavelin, 1, 32767));
/* 617 */     OreDictionary.registerOre("itemJavelinBismuthBronze", new ItemStack(TFCItems.bismuthBronzeJavelin, 1, 32767));
/* 618 */     OreDictionary.registerOre("itemJavelinBlackBronze", new ItemStack(TFCItems.blackBronzeJavelin, 1, 32767));
/* 619 */     OreDictionary.registerOre("itemJavelinBlackSteel", new ItemStack(TFCItems.blackSteelJavelin, 1, 32767));
/* 620 */     OreDictionary.registerOre("itemJavelinBlueSteel", new ItemStack(TFCItems.blueSteelJavelin, 1, 32767));
/* 621 */     OreDictionary.registerOre("itemJavelinBronze", new ItemStack(TFCItems.bronzeJavelin, 1, 32767));
/* 622 */     OreDictionary.registerOre("itemJavelinCopper", new ItemStack(TFCItems.copperJavelin, 1, 32767));
/* 623 */     OreDictionary.registerOre("itemJavelinWroughtIron", new ItemStack(TFCItems.wroughtIronJavelin, 1, 32767));
/* 624 */     OreDictionary.registerOre("itemJavelinRedSteel", new ItemStack(TFCItems.redSteelJavelin, 1, 32767));
/* 625 */     OreDictionary.registerOre("itemJavelinSteel", new ItemStack(TFCItems.steelJavelin, 1, 32767));
/*     */ 
/*     */     
/* 628 */     OreDictionary.registerOre("lumpClay", new ItemStack(Items.field_151119_aD));
/* 629 */     OreDictionary.registerOre("lumpClay", new ItemStack(TFCItems.clayBall, 1, 0));
/*     */     
/* 631 */     OreDictionary.registerOre("itemArrow", new ItemStack(Items.field_151032_g));
/* 632 */     OreDictionary.registerOre("itemArrow", new ItemStack(TFCItems.arrow));
/*     */     
/* 634 */     OreDictionary.registerOre("itemReed", new ItemStack(Items.field_151120_aE));
/* 635 */     OreDictionary.registerOre("itemReed", new ItemStack(TFCItems.reeds));
/*     */     
/* 637 */     OreDictionary.registerOre("itemRock", new ItemStack(TFCItems.looseRock, 1, 32767));
/*     */     
/* 639 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(Items.field_151133_ar));
/* 640 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.woodenBucketEmpty));
/* 641 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.redSteelBucketEmpty));
/* 642 */     OreDictionary.registerOre("bucketEmpty", new ItemStack(TFCItems.blueSteelBucketEmpty));
/*     */     
/* 644 */     OreDictionary.registerOre("bucketWater", new ItemStack(Items.field_151131_as));
/* 645 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.woodenBucketWater, 1, 32767));
/* 646 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.redSteelBucketWater, 1, 32767));
/* 647 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.woodenBucketSaltWater, 1, 32767));
/* 648 */     OreDictionary.registerOre("bucketWater", new ItemStack(TFCItems.redSteelBucketSaltWater, 1, 32767));
/*     */     
/* 650 */     OreDictionary.registerOre("bucketFreshWater", new ItemStack(TFCItems.woodenBucketWater, 1, 32767));
/* 651 */     OreDictionary.registerOre("bucketFreshWater", new ItemStack(TFCItems.redSteelBucketWater, 1, 32767));
/*     */     
/* 653 */     OreDictionary.registerOre("bucketSaltWater", new ItemStack(TFCItems.woodenBucketSaltWater, 1, 32767));
/* 654 */     OreDictionary.registerOre("bucketSaltWater", new ItemStack(TFCItems.redSteelBucketSaltWater, 1, 32767));
/*     */     
/* 656 */     OreDictionary.registerOre("bucketLava", new ItemStack(Items.field_151129_at));
/* 657 */     OreDictionary.registerOre("bucketLava", new ItemStack(TFCItems.blueSteelBucketLava));
/*     */     
/* 659 */     OreDictionary.registerOre("bucketMilk", new ItemStack(Items.field_151117_aB));
/* 660 */     OreDictionary.registerOre("bucketMilk", new ItemStack(TFCItems.woodenBucketMilk));
/*     */     
/* 662 */     OreDictionary.registerOre("toolFlintSteel", new ItemStack(Items.field_151033_d, 1, 32767));
/* 663 */     OreDictionary.registerOre("toolFlintSteel", new ItemStack(TFCItems.flintSteel, 1, 32767));
/*     */ 
/*     */     
/* 666 */     OreDictionary.registerOre("blockSand", new ItemStack((Block)Blocks.field_150354_m));
/* 667 */     OreDictionary.registerOre("blockSand", new ItemStack(TFCBlocks.sand, 1, 32767));
/* 668 */     OreDictionary.registerOre("blockSand", new ItemStack(TFCBlocks.sand2, 1, 32767));
/*     */     
/* 670 */     OreDictionary.registerOre("blockGravel", new ItemStack(Blocks.field_150351_n));
/* 671 */     OreDictionary.registerOre("blockGravel", new ItemStack(TFCBlocks.gravel, 1, 32767));
/* 672 */     OreDictionary.registerOre("blockGravel", new ItemStack(TFCBlocks.gravel2, 1, 32767));
/*     */     
/* 674 */     OreDictionary.registerOre("blockDirt", new ItemStack(Blocks.field_150346_d));
/* 675 */     OreDictionary.registerOre("blockDirt", new ItemStack(TFCBlocks.dirt, 1, 32767));
/* 676 */     OreDictionary.registerOre("blockDirt", new ItemStack(TFCBlocks.dirt2, 1, 32767));
/*     */     
/* 678 */     OreDictionary.registerOre("blockTorch", new ItemStack(Blocks.field_150478_aa));
/* 679 */     OreDictionary.registerOre("blockTorch", new ItemStack(TFCBlocks.torch));
/*     */     
/* 681 */     OreDictionary.registerOre("blockPumpkin", new ItemStack(Blocks.field_150423_aK));
/* 682 */     OreDictionary.registerOre("blockPumpkin", new ItemStack(TFCBlocks.pumpkin));
/* 683 */     OreDictionary.registerOre("blockLitPumpkin", new ItemStack(Blocks.field_150428_aP));
/* 684 */     OreDictionary.registerOre("blockLitPumpkin", new ItemStack(TFCBlocks.litPumpkin));
/*     */ 
/*     */     
/* 687 */     for (Item seed : Recipes.seeds)
/* 688 */       OreDictionary.registerOre("seedBag", new ItemStack(seed, 1, 32767)); 
/* 689 */     OreDictionary.registerOre("seedWheat", new ItemStack(TFCItems.seedsWheat, 1, 32767));
/* 690 */     OreDictionary.registerOre("seedMaize", new ItemStack(TFCItems.seedsMaize, 1, 32767));
/* 691 */     OreDictionary.registerOre("seedTomato", new ItemStack(TFCItems.seedsTomato, 1, 32767));
/* 692 */     OreDictionary.registerOre("seedBarley", new ItemStack(TFCItems.seedsBarley, 1, 32767));
/* 693 */     OreDictionary.registerOre("seedRye", new ItemStack(TFCItems.seedsRye, 1, 32767));
/* 694 */     OreDictionary.registerOre("seedOat", new ItemStack(TFCItems.seedsOat, 1, 32767));
/* 695 */     OreDictionary.registerOre("seedRice", new ItemStack(TFCItems.seedsRice, 1, 32767));
/* 696 */     OreDictionary.registerOre("seedPotato", new ItemStack(TFCItems.seedsPotato, 1, 32767));
/* 697 */     OreDictionary.registerOre("seedOnion", new ItemStack(TFCItems.seedsOnion, 1, 32767));
/* 698 */     OreDictionary.registerOre("seedCabbage", new ItemStack(TFCItems.seedsCabbage, 1, 32767));
/* 699 */     OreDictionary.registerOre("seedGarlic", new ItemStack(TFCItems.seedsGarlic, 1, 32767));
/* 700 */     OreDictionary.registerOre("seedCarrot", new ItemStack(TFCItems.seedsCarrot, 1, 32767));
/* 701 */     OreDictionary.registerOre("seedSugarcane", new ItemStack(TFCItems.seedsSugarcane, 1, 32767));
/* 702 */     OreDictionary.registerOre("seedYelloBellPepper", new ItemStack(TFCItems.seedsYellowBellPepper, 1, 32767));
/* 703 */     OreDictionary.registerOre("seedRedBellPepper", new ItemStack(TFCItems.seedsRedBellPepper, 1, 32767));
/* 704 */     OreDictionary.registerOre("seedSoybean", new ItemStack(TFCItems.seedsSoybean, 1, 32767));
/* 705 */     OreDictionary.registerOre("seedGreenbean", new ItemStack(TFCItems.seedsGreenbean, 1, 32767));
/* 706 */     OreDictionary.registerOre("seedSquash", new ItemStack(TFCItems.seedsSquash, 1, 32767));
/* 707 */     OreDictionary.registerOre("seedJute", new ItemStack(TFCItems.seedsJute, 1, 32767));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFC_OreDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */