/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRaw;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ public class ItemHeat
/*     */ {
/*     */   public static void setupItemHeat() {
/*  15 */     HeatRegistry manager = HeatRegistry.getInstance();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  21 */     int WILDCARD_VALUE = 32767;
/*     */     
/*  23 */     HeatRaw bismuthRaw = new HeatRaw(0.14D, 270.0D);
/*  24 */     HeatRaw bismuthBronzeRaw = new HeatRaw(0.35D, 985.0D);
/*  25 */     HeatRaw blackBronzeRaw = new HeatRaw(0.35D, 1070.0D);
/*  26 */     HeatRaw blackSteelRaw = new HeatRaw(0.35D, 1485.0D);
/*  27 */     HeatRaw blueSteelRaw = new HeatRaw(0.35D, 1540.0D);
/*  28 */     HeatRaw brassRaw = new HeatRaw(0.35D, 930.0D);
/*  29 */     HeatRaw bronzeRaw = new HeatRaw(0.35D, 950.0D);
/*  30 */     HeatRaw copperRaw = new HeatRaw(0.35D, 1080.0D);
/*  31 */     HeatRaw goldRaw = new HeatRaw(0.6D, 1060.0D);
/*  32 */     HeatRaw ironRaw = new HeatRaw(0.35D, 1535.0D);
/*  33 */     HeatRaw leadRaw = new HeatRaw(0.22D, 328.0D);
/*  34 */     HeatRaw nickelRaw = new HeatRaw(0.48D, 1453.0D);
/*  35 */     HeatRaw pigIronRaw = new HeatRaw(0.35D, 1500.0D);
/*  36 */     HeatRaw platinumRaw = new HeatRaw(0.35D, 1730.0D);
/*  37 */     HeatRaw redSteelRaw = new HeatRaw(0.35D, 1540.0D);
/*  38 */     HeatRaw roseGoldRaw = new HeatRaw(0.35D, 960.0D);
/*  39 */     HeatRaw silverRaw = new HeatRaw(0.48D, 961.0D);
/*  40 */     HeatRaw steelRaw = new HeatRaw(0.35D, 1540.0D);
/*  41 */     HeatRaw sterlingSilverRaw = new HeatRaw(0.35D, 900.0D);
/*  42 */     HeatRaw tinRaw = new HeatRaw(0.14D, 230.0D);
/*  43 */     HeatRaw zincRaw = new HeatRaw(0.21D, 420.0D);
/*     */     
/*  45 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  46 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/*  47 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 2), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/*  48 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 3), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  49 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 4), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/*  50 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 5), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/*  51 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 6), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/*  52 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 7), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/*  53 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 8), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/*  54 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 9), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  55 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 10), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  56 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 11), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  57 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 12), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/*  58 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 13), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  59 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 35), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  60 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 36), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/*  61 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 37), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/*  62 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 38), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  63 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 39), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/*  64 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 40), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/*  65 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 41), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/*  66 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 42), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/*  67 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 43), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/*  68 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 44), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  69 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 45), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  70 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 46), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  71 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 47), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/*  72 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 48), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  73 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 49), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  74 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 50), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/*  75 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 51), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/*  76 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 52), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  77 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 53), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/*  78 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 54), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/*  79 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 55), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/*  80 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 56), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/*  81 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 57), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/*  82 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 58), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  83 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 59), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  84 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 60), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  85 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 61), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/*  86 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oreChunk, 1, 62), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*     */     
/*  88 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  89 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/*  90 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 2), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/*  91 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 3), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  92 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 4), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/*  93 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 5), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/*  94 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 6), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/*  95 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 7), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/*  96 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 8), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/*  97 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 9), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*  98 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 10), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/*  99 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 11), ironRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/* 100 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 12), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/* 101 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.smallOreChunk, 1, 13), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakSteelUnshaped, 1), steelRaw, new ItemStack(TFCItems.weakSteelUnshaped, 1)));
/* 108 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakRedSteelUnshaped, 1), redSteelRaw, new ItemStack(TFCItems.weakRedSteelUnshaped, 1)));
/* 109 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakBlueSteelUnshaped, 1), blueSteelRaw, new ItemStack(TFCItems.weakBlueSteelUnshaped, 1)));
/* 110 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1), blackSteelRaw, new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1)));
/* 111 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1), blueSteelRaw, new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1)));
/* 112 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1), redSteelRaw, new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1)));
/* 113 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonSteelUnshaped, 1), steelRaw, new ItemStack(TFCItems.highCarbonSteelUnshaped, 1)));
/*     */     
/* 115 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakSteelIngot, 1), steelRaw, new ItemStack(TFCItems.weakSteelUnshaped, 1)));
/* 116 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakRedSteelIngot, 1), redSteelRaw, new ItemStack(TFCItems.weakRedSteelUnshaped, 1)));
/* 117 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.weakBlueSteelIngot, 1), blueSteelRaw, new ItemStack(TFCItems.weakBlueSteelUnshaped, 1)));
/* 118 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonBlackSteelIngot, 1), blackSteelRaw, new ItemStack(TFCItems.highCarbonBlackSteelUnshaped, 1)));
/* 119 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonBlueSteelIngot, 1), blueSteelRaw, new ItemStack(TFCItems.highCarbonBlueSteelUnshaped, 1)));
/* 120 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonRedSteelIngot, 1), redSteelRaw, new ItemStack(TFCItems.highCarbonRedSteelUnshaped, 1)));
/* 121 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.highCarbonSteelIngot, 1), steelRaw, new ItemStack(TFCItems.highCarbonSteelUnshaped, 1)));
/*     */     
/* 123 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.unknownIngot, 1), copperRaw, new ItemStack(TFCItems.unknownUnshaped, 1)));
/* 124 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.unknownUnshaped, 1), copperRaw, new ItemStack(TFCItems.unknownUnshaped, 1)));
/*     */ 
/*     */     
/* 127 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthIngot, 1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/* 128 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthIngot2x, 1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 2, 0)));
/* 129 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthUnshaped, 1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 1)));
/* 130 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthSheet, 1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 2, 0)));
/* 131 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthSheet2x, 1), bismuthRaw, new ItemStack(TFCItems.bismuthUnshaped, 4, 0)));
/*     */     
/* 133 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeIngot, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 1)));
/* 134 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeIngot2x, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 135 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 1)));
/* 136 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeSheet, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 137 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeSheet2x, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 4, 0)));
/* 138 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 0), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 139 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedHelmet, 1, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 140 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 0), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 4, 0)));
/* 141 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedChestplate, 1, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 4, 0)));
/* 142 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 0), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 143 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedGreaves, 1, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 144 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 0), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 145 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bismuthBronzeUnfinishedBoots, 1, 1), bismuthBronzeRaw, new ItemStack(TFCItems.bismuthBronzeUnshaped, 2, 0)));
/* 146 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil2, 1, 1), bismuthBronzeRaw, null));
/*     */     
/* 148 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeIngot, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 1)));
/* 149 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeIngot2x, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 150 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnshaped, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 1)));
/* 151 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeSheet, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 152 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeSheet2x, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 4, 0)));
/* 153 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 0), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 154 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedHelmet, 1, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 155 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 0), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 4, 0)));
/* 156 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedChestplate, 1, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 4, 0)));
/* 157 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 0), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 158 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedGreaves, 1, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 159 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 0), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 160 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackBronzeUnfinishedBoots, 1, 1), blackBronzeRaw, new ItemStack(TFCItems.blackBronzeUnshaped, 2, 0)));
/* 161 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil2, 1, 2), blackBronzeRaw, null));
/*     */     
/* 163 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelIngot, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 1)));
/* 164 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelIngot2x, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 165 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnshaped, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 1)));
/* 166 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelSheet, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 167 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelSheet2x, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 4, 0)));
/* 168 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 0), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 169 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedHelmet, 1, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 170 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 0), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 4, 0)));
/* 171 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedChestplate, 1, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 4, 0)));
/* 172 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 0), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 173 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedGreaves, 1, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 174 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 0), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 175 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackSteelUnfinishedBoots, 1, 1), blackSteelRaw, new ItemStack(TFCItems.blackSteelUnshaped, 2, 0)));
/* 176 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 5), blackSteelRaw, null));
/*     */     
/* 178 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelIngot, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 1)));
/* 179 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelIngot2x, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 180 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnshaped, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 1)));
/* 181 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelSheet, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 182 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelSheet2x, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 4, 0)));
/* 183 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 0), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 184 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedHelmet, 1, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 185 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 0), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 4, 0)));
/* 186 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedChestplate, 1, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 4, 0)));
/* 187 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 0), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 188 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedGreaves, 1, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 189 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 0), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 190 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueSteelUnfinishedBoots, 1, 1), blueSteelRaw, new ItemStack(TFCItems.blueSteelUnshaped, 2, 0)));
/* 191 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 6), blueSteelRaw, null));
/* 192 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 5), blueSteelRaw, null));
/*     */     
/* 194 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.brassIngot, 1), brassRaw, new ItemStack(TFCItems.brassUnshaped, 1)));
/* 195 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.brassIngot2x, 1), brassRaw, new ItemStack(TFCItems.brassUnshaped, 2, 0)));
/* 196 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.brassUnshaped, 1), brassRaw, new ItemStack(TFCItems.brassUnshaped, 1)));
/* 197 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.brassSheet, 1), brassRaw, new ItemStack(TFCItems.brassUnshaped, 2, 0)));
/* 198 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.brassSheet2x, 1), brassRaw, new ItemStack(TFCItems.brassUnshaped, 4, 0)));
/*     */     
/* 200 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeIngot, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 1)));
/* 201 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeIngot2x, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 202 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnshaped, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 1)));
/* 203 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeSheet, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 204 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeSheet2x, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 4, 0)));
/* 205 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 0), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 206 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedHelmet, 1, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 207 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 0), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 4, 0)));
/* 208 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedChestplate, 1, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 4, 0)));
/* 209 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 0), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 210 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedGreaves, 1, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 211 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 0), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 212 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bronzeUnfinishedBoots, 1, 1), bronzeRaw, new ItemStack(TFCItems.bronzeUnshaped, 2, 0)));
/* 213 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 2), bronzeRaw, null));
/*     */     
/* 215 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperIngot, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/* 216 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperIngot2x, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 217 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnshaped, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 1)));
/* 218 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperSheet, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 219 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperSheet2x, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 4, 0)));
/* 220 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 221 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedHelmet, 1, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 222 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 4, 0)));
/* 223 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedChestplate, 1, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 4, 0)));
/* 224 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 225 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedGreaves, 1, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 226 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 0), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 227 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.copperUnfinishedBoots, 1, 1), copperRaw, new ItemStack(TFCItems.copperUnshaped, 2, 0)));
/* 228 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 1), copperRaw, null));
/*     */     
/* 230 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.goldIngot, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/* 231 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.goldIngot2x, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 2, 0)));
/* 232 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.goldUnshaped, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 1)));
/* 233 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.goldSheet, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 2, 0)));
/* 234 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.goldSheet2x, 1), goldRaw, new ItemStack(TFCItems.goldUnshaped, 4, 0)));
/* 235 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 0), goldRaw, null));
/*     */     
/* 237 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronIngot, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 1)));
/*     */     
/* 239 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bloom, 1, 32767), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 1)));
/* 240 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.rawBloom, 1, 32767), ironRaw, new ItemStack(TFCItems.unknownUnshaped, 1)));
/*     */     
/* 242 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronIngot2x, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 243 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnshaped, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 1)));
/* 244 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronSheet, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 245 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronSheet2x, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 4, 0)));
/* 246 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 0), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 247 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedHelmet, 1, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 248 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 0), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 4, 0)));
/* 249 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedChestplate, 1, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 4, 0)));
/* 250 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 0), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 251 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedGreaves, 1, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 252 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 0), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 253 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronUnfinishedBoots, 1, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 2, 0)));
/* 254 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wroughtIronKnifeHead, 1), ironRaw, new ItemStack(TFCItems.wroughtIronUnshaped, 1)));
/* 255 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 3), ironRaw, null));
/*     */     
/* 257 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.leadIngot, 1), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/* 258 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.leadIngot2x, 1), leadRaw, new ItemStack(TFCItems.leadUnshaped, 2, 0)));
/* 259 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.leadUnshaped, 1), leadRaw, new ItemStack(TFCItems.leadUnshaped, 1)));
/* 260 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.leadSheet, 1), leadRaw, new ItemStack(TFCItems.leadUnshaped, 2, 0)));
/* 261 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.leadSheet2x, 1), leadRaw, new ItemStack(TFCItems.leadUnshaped, 4, 0)));
/*     */     
/* 263 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.nickelIngot, 1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/* 264 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.nickelIngot2x, 1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 2, 0)));
/* 265 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.nickelUnshaped, 1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 1)));
/* 266 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.nickelSheet, 1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 2, 0)));
/* 267 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.nickelSheet2x, 1), nickelRaw, new ItemStack(TFCItems.nickelUnshaped, 4, 0)));
/*     */     
/* 269 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.pigIronIngot, 1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/* 270 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.pigIronIngot2x, 1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped, 2, 0)));
/* 271 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.pigIronUnshaped, 1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped, 1)));
/* 272 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.pigIronSheet, 1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped, 2, 0)));
/* 273 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.pigIronSheet2x, 1), pigIronRaw, new ItemStack(TFCItems.pigIronUnshaped, 4, 0)));
/*     */     
/* 275 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.platinumIngot, 1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/* 276 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.platinumIngot2x, 1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 2, 0)));
/* 277 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.platinumUnshaped, 1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 1)));
/* 278 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.platinumSheet, 1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 2, 0)));
/* 279 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.platinumSheet2x, 1), platinumRaw, new ItemStack(TFCItems.platinumUnshaped, 4, 0)));
/* 280 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 1), platinumRaw, null));
/*     */     
/* 282 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelIngot, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 1)));
/* 283 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelIngot2x, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 284 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnshaped, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 1)));
/* 285 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelSheet, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 286 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelSheet2x, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 4, 0)));
/* 287 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 0), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 288 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedHelmet, 1, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 289 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 0), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 4, 0)));
/* 290 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedChestplate, 1, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 4, 0)));
/* 291 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 0), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 292 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedGreaves, 1, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 293 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 0), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 294 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redSteelUnfinishedBoots, 1, 1), redSteelRaw, new ItemStack(TFCItems.redSteelUnshaped, 2, 0)));
/* 295 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 7), redSteelRaw, null));
/*     */     
/* 297 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.roseGoldIngot, 1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped, 1)));
/* 298 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.roseGoldIngot2x, 1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped, 2, 0)));
/* 299 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.roseGoldUnshaped, 1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped, 1)));
/* 300 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.roseGoldSheet, 1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped, 2, 0)));
/* 301 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.roseGoldSheet2x, 1), roseGoldRaw, new ItemStack(TFCItems.roseGoldUnshaped, 4, 0)));
/* 302 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 2), roseGoldRaw, null));
/*     */     
/* 304 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.silverIngot, 1), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/* 305 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.silverIngot2x, 1), silverRaw, new ItemStack(TFCItems.silverUnshaped, 2, 0)));
/* 306 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.silverUnshaped, 1), silverRaw, new ItemStack(TFCItems.silverUnshaped, 1)));
/* 307 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.silverSheet, 1), silverRaw, new ItemStack(TFCItems.silverUnshaped, 2, 0)));
/* 308 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.silverSheet2x, 1), silverRaw, new ItemStack(TFCItems.silverUnshaped, 4, 0)));
/* 309 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 3), silverRaw, null));
/*     */     
/* 311 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelIngot, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 1)));
/* 312 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelIngot2x, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 313 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnshaped, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 1)));
/* 314 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelSheet, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 315 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelSheet2x, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 4, 0)));
/* 316 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 0), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 317 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedHelmet, 1, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 318 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 0), steelRaw, new ItemStack(TFCItems.steelUnshaped, 4, 0)));
/* 319 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedChestplate, 1, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 4, 0)));
/* 320 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 0), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 321 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedGreaves, 1, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 322 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 0), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 323 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.steelUnfinishedBoots, 1, 1), steelRaw, new ItemStack(TFCItems.steelUnshaped, 2, 0)));
/* 324 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.anvil, 1, 4), steelRaw, null));
/*     */     
/* 326 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.sterlingSilverIngot, 1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped, 1)));
/* 327 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.sterlingSilverIngot2x, 1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped, 2, 0)));
/* 328 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.sterlingSilverUnshaped, 1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped, 1)));
/* 329 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.sterlingSilverSheet, 1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped, 2, 0)));
/* 330 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.sterlingSilverSheet2x, 1), sterlingSilverRaw, new ItemStack(TFCItems.sterlingSilverUnshaped, 4, 0)));
/* 331 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.oilLamp, 1, 4), sterlingSilverRaw, null));
/*     */     
/* 333 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tinIngot, 1), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/* 334 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tinIngot2x, 1), tinRaw, new ItemStack(TFCItems.tinUnshaped, 2, 0)));
/* 335 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tinUnshaped, 1), tinRaw, new ItemStack(TFCItems.tinUnshaped, 1)));
/* 336 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tinSheet, 1), tinRaw, new ItemStack(TFCItems.tinUnshaped, 2, 0)));
/* 337 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tinSheet2x, 1), tinRaw, new ItemStack(TFCItems.tinUnshaped, 4, 0)));
/*     */     
/* 339 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.zincIngot, 1), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/* 340 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.zincIngot2x, 1), zincRaw, new ItemStack(TFCItems.zincUnshaped, 2, 0)));
/* 341 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.zincUnshaped, 1), zincRaw, new ItemStack(TFCItems.zincUnshaped, 1)));
/* 342 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.zincSheet, 1), zincRaw, new ItemStack(TFCItems.zincUnshaped, 2, 0)));
/* 343 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.zincSheet2x, 1), zincRaw, new ItemStack(TFCItems.zincUnshaped, 4, 0)));
/*     */     
/* 345 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.sand, 1, 32767), 1.0D, 600.0D, new ItemStack(Blocks.field_150359_w, 1)));
/* 346 */     manager.addIndex(new HeatIndex(new ItemStack(TFCBlocks.sand2, 1, 32767), 1.0D, 600.0D, new ItemStack(Blocks.field_150359_w, 1)));
/*     */ 
/*     */ 
/*     */     
/* 350 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.egg, 1), 1.0D, 600.0D, new ItemStack(TFCItems.eggCooked, 1))).setKeepNBT(true));
/*     */     
/* 352 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.porkchopRaw, 1), 1.0D, 1200.0D, null));
/* 353 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.fishRaw, 1), 1.0D, 1200.0D, null));
/* 354 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.beefRaw, 1), 1.0D, 1200.0D, null));
/* 355 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.chickenRaw, 1), 1.0D, 1200.0D, null));
/* 356 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.soybean, 1), 1.0D, 1200.0D, null));
/* 357 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.eggCooked, 1), 1.0D, 1200.0D, null));
/* 358 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.calamariRaw, 1), 1.0D, 1200.0D, null));
/* 359 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.muttonRaw, 1), 1.0D, 1200.0D, null));
/* 360 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.venisonRaw, 1), 1.0D, 1200.0D, null));
/* 361 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.horseMeatRaw, 1), 1.0D, 1200.0D, null));
/*     */ 
/*     */     
/* 364 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cheese, 1), 1.0D, 1200.0D, null));
/*     */ 
/*     */     
/* 367 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.maizeEar, 1), 1.0D, 1200.0D, null));
/*     */     
/* 369 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.wheatDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.wheatBread, 1))).setKeepNBT(true));
/* 370 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.barleyDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.barleyBread, 1))).setKeepNBT(true));
/* 371 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.oatDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.oatBread, 1))).setKeepNBT(true));
/* 372 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.ryeDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.ryeBread, 1))).setKeepNBT(true));
/* 373 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.riceDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.riceBread, 1))).setKeepNBT(true));
/* 374 */     manager.addIndex((new HeatIndex(new ItemStack(TFCItems.cornmealDough, 1), 1.0D, 600.0D, new ItemStack(TFCItems.cornBread, 1))).setKeepNBT(true));
/*     */     
/* 376 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wheatBread, 1), 1.0D, 1200.0D, null));
/* 377 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.barleyBread, 1), 1.0D, 1200.0D, null));
/* 378 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.oatBread, 1), 1.0D, 1200.0D, null));
/* 379 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.ryeBread, 1), 1.0D, 1200.0D, null));
/* 380 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.riceBread, 1), 1.0D, 1200.0D, null));
/* 381 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cornBread, 1), 1.0D, 1200.0D, null));
/*     */ 
/*     */     
/* 384 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.tomato, 1), 1.0D, 1200.0D, null));
/* 385 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.potato, 1), 1.0D, 1200.0D, null));
/* 386 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.onion, 1), 1.0D, 1200.0D, null));
/* 387 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cabbage, 1), 1.0D, 1200.0D, null));
/* 388 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.garlic, 1), 1.0D, 1200.0D, null));
/* 389 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.carrot, 1), 1.0D, 1200.0D, null));
/* 390 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.greenbeans, 1), 1.0D, 1200.0D, null));
/* 391 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.greenBellPepper, 1), 1.0D, 1200.0D, null));
/* 392 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.yellowBellPepper, 1), 1.0D, 1200.0D, null));
/* 393 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redBellPepper, 1), 1.0D, 1200.0D, null));
/* 394 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.squash, 1), 1.0D, 1200.0D, null));
/* 395 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.seaWeed, 1), 1.0D, 1200.0D, null));
/*     */ 
/*     */     
/* 398 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.redApple, 1), 1.0D, 1200.0D, null));
/* 399 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.banana, 1), 1.0D, 1200.0D, null));
/* 400 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.orange, 1), 1.0D, 1200.0D, null));
/* 401 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.greenApple, 1), 1.0D, 1200.0D, null));
/* 402 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.lemon, 1), 1.0D, 1200.0D, null));
/* 403 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.olive, 1), 1.0D, 1200.0D, null));
/* 404 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cherry, 1), 1.0D, 1200.0D, null));
/* 405 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.peach, 1), 1.0D, 1200.0D, null));
/* 406 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.plum, 1), 1.0D, 1200.0D, null));
/*     */     
/* 408 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.wintergreenBerry, 1), 1.0D, 1200.0D, null));
/* 409 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blueberry, 1), 1.0D, 1200.0D, null));
/* 410 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.raspberry, 1), 1.0D, 1200.0D, null));
/* 411 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.strawberry, 1), 1.0D, 1200.0D, null));
/* 412 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.blackberry, 1), 1.0D, 1200.0D, null));
/* 413 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.bunchberry, 1), 1.0D, 1200.0D, null));
/* 414 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cranberry, 1), 1.0D, 1200.0D, null));
/* 415 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.snowberry, 1), 1.0D, 1200.0D, null));
/* 416 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.elderberry, 1), 1.0D, 1200.0D, null));
/* 417 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.gooseberry, 1), 1.0D, 1200.0D, null));
/* 418 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.cloudberry, 1), 1.0D, 1200.0D, null));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     manager.addIndex(new HeatIndex(new ItemStack(TFCItems.stick, 1, 32767), 1.0D, 40.0D, new ItemStack(TFCBlocks.torch, 2)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\ItemHeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */