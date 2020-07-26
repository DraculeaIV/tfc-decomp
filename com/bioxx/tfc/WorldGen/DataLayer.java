/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ 
/*     */ 
/*     */ public class DataLayer
/*     */ {
/*  10 */   public static DataLayer[] layers = new DataLayer[256];
/*     */   
/*  12 */   public static final DataLayer GRANITE = new DataLayer(0, TFCBlocks.stoneIgIn, 0, 0, "Granite");
/*  13 */   public static final DataLayer DIORITE = new DataLayer(1, TFCBlocks.stoneIgIn, 1, 1, "Diorite");
/*  14 */   public static final DataLayer GABBRO = new DataLayer(2, TFCBlocks.stoneIgIn, 2, 2, "Gabbro");
/*  15 */   public static final DataLayer SHALE = new DataLayer(5, TFCBlocks.stoneSed, 0, 3, "Shale");
/*  16 */   public static final DataLayer CLAYSTONE = new DataLayer(6, TFCBlocks.stoneSed, 1, 4, "Claystone");
/*  17 */   public static final DataLayer ROCKSALT = new DataLayer(7, TFCBlocks.stoneSed, 2, 5, "Rock Salt");
/*  18 */   public static final DataLayer LIMESTONE = new DataLayer(8, TFCBlocks.stoneSed, 3, 6, "Limestone");
/*  19 */   public static final DataLayer CONGLOMERATE = new DataLayer(9, TFCBlocks.stoneSed, 4, 7, "Conglomerate");
/*  20 */   public static final DataLayer DOLOMITE = new DataLayer(10, TFCBlocks.stoneSed, 5, 8, "Dolomite");
/*  21 */   public static final DataLayer CHERT = new DataLayer(11, TFCBlocks.stoneSed, 6, 9, "Chert");
/*  22 */   public static final DataLayer CHALK = new DataLayer(12, TFCBlocks.stoneSed, 7, 10, "Chalk");
/*  23 */   public static final DataLayer RHYOLITE = new DataLayer(13, TFCBlocks.stoneIgEx, 0, 11, "Rhyolite");
/*  24 */   public static final DataLayer BASALT = new DataLayer(14, TFCBlocks.stoneIgEx, 1, 12, "Basalt");
/*  25 */   public static final DataLayer ANDESITE = new DataLayer(15, TFCBlocks.stoneIgEx, 2, 13, "Andesite");
/*  26 */   public static final DataLayer DACITE = new DataLayer(16, TFCBlocks.stoneIgEx, 3, 14, "Dacite");
/*  27 */   public static final DataLayer QUARTZITE = new DataLayer(17, TFCBlocks.stoneMM, 0, 15, "Quartzite");
/*  28 */   public static final DataLayer SLATE = new DataLayer(18, TFCBlocks.stoneMM, 1, 16, "Slate");
/*  29 */   public static final DataLayer PHYLLITE = new DataLayer(19, TFCBlocks.stoneMM, 2, 17, "Phyllite");
/*  30 */   public static final DataLayer SCHIST = new DataLayer(20, TFCBlocks.stoneMM, 3, 18, "Schist");
/*  31 */   public static final DataLayer GNEISS = new DataLayer(21, TFCBlocks.stoneMM, 4, 19, "Gneiss");
/*  32 */   public static final DataLayer MARBLE = new DataLayer(22, TFCBlocks.stoneMM, 5, 20, "Marble");
/*     */   
/*  34 */   public static final DataLayer NO_TREE = new DataLayer(29, "No Tree", -1);
/*  35 */   public static final DataLayer ASH = new DataLayer(30, "Ash", 7);
/*  36 */   public static final DataLayer ASPEN = new DataLayer(31, "Aspen", 1);
/*  37 */   public static final DataLayer BIRCH = new DataLayer(32, "Birch", 2);
/*  38 */   public static final DataLayer CHESTNUT = new DataLayer(33, "Chestnut", 3);
/*  39 */   public static final DataLayer DOUGLASFIR = new DataLayer(34, "Douglas Fir", 4);
/*  40 */   public static final DataLayer HICKORY = new DataLayer(35, "Hickory", 5);
/*  41 */   public static final DataLayer KOA = new DataLayer(45, "Acacia Koa", 0);
/*  42 */   public static final DataLayer MAPLE = new DataLayer(36, "Maple", 6);
/*  43 */   public static final DataLayer OAK = new DataLayer(37, "Oak", 0);
/*  44 */   public static final DataLayer PINE = new DataLayer(38, "Pine", 8);
/*  45 */   public static final DataLayer REDWOOD = new DataLayer(39, "Sequoia", 9);
/*  46 */   public static final DataLayer SPRUCE = new DataLayer(40, "Spruce", 10);
/*  47 */   public static final DataLayer SYCAMORE = new DataLayer(41, "Sycamore", 11);
/*  48 */   public static final DataLayer SAVANNAHACACIA = new DataLayer(46, "Acacia Savannah", 0);
/*  49 */   public static final DataLayer WHITECEDAR = new DataLayer(42, "White Cedar", 12);
/*  50 */   public static final DataLayer WHITEELM = new DataLayer(43, "White Elm", 13);
/*  51 */   public static final DataLayer WILLOW = new DataLayer(44, "Willow", 14);
/*     */   
/*  53 */   public static final DataLayer EVT_0_125 = new DataLayer(80, "0.125", 0.125F);
/*  54 */   public static final DataLayer EVT_0_25 = new DataLayer(81, "0.25", 0.25F);
/*  55 */   public static final DataLayer EVT_0_5 = new DataLayer(82, "0.5", 0.5F);
/*  56 */   public static final DataLayer EVT_1 = new DataLayer(83, "1", 1.0F);
/*  57 */   public static final DataLayer EVT_2 = new DataLayer(84, "2", 2.0F);
/*  58 */   public static final DataLayer EVT_4 = new DataLayer(85, "4", 4.0F);
/*  59 */   public static final DataLayer EVT_8 = new DataLayer(86, "8", 8.0F);
/*  60 */   public static final DataLayer EVT_16 = new DataLayer(87, "16", 16.0F);
/*     */   
/*  62 */   public static final DataLayer RAIN_62_5 = new DataLayer(90, "62.5", 62.5F);
/*  63 */   public static final DataLayer RAIN_125 = new DataLayer(91, "125", 125.0F);
/*  64 */   public static final DataLayer RAIN_250 = new DataLayer(92, "250", 250.0F);
/*  65 */   public static final DataLayer RAIN_500 = new DataLayer(93, "500", 500.0F);
/*  66 */   public static final DataLayer RAIN_1000 = new DataLayer(94, "1000", 1000.0F);
/*  67 */   public static final DataLayer RAIN_2000 = new DataLayer(95, "2000", 2000.0F);
/*  68 */   public static final DataLayer RAIN_4000 = new DataLayer(96, "4000", 4000.0F);
/*  69 */   public static final DataLayer RAIN_8000 = new DataLayer(97, "8000", 8000.0F);
/*     */   
/*  71 */   public static final DataLayer SEISMIC_STABLE = new DataLayer(110, 0);
/*  72 */   public static final DataLayer SEISMIC_UNSTABLE = new DataLayer(111, 1);
/*     */   
/*  74 */   public static final DataLayer DRAINAGE_NONE = new DataLayer(120, "None", 0);
/*  75 */   public static final DataLayer DRAINAGE_VERY_POOR = new DataLayer(121, "Very Poor", 1);
/*  76 */   public static final DataLayer DRAINAGE_POOR = new DataLayer(122, "Poor", 2);
/*  77 */   public static final DataLayer DRAINAGE_NORMAL = new DataLayer(123, "Normal", 3);
/*  78 */   public static final DataLayer DRAINAGE_GOOD = new DataLayer(124, "Good", 4);
/*  79 */   public static final DataLayer DRAINAGE_VERY_GOOD = new DataLayer(125, "Very Good", 5);
/*     */   
/*  81 */   public static final DataLayer PH_ACID_HIGH = new DataLayer(130, "High Acidity", 0);
/*  82 */   public static final DataLayer PH_ACID_LOW = new DataLayer(131, "Low acidity", 1);
/*  83 */   public static final DataLayer PH_NEUTRAL = new DataLayer(132, "Neutral", 2);
/*  84 */   public static final DataLayer PH_ALKALINE_LOW = new DataLayer(133, "Low Alkalinity", 3);
/*  85 */   public static final DataLayer PH_ALKALINE_HIGH = new DataLayer(134, "High Alkalinity", 4);
/*     */   
/*     */   public int layerID;
/*  88 */   public Block block = Blocks.field_150350_a;
/*     */   public int data1;
/*     */   public int data2;
/*     */   public float floatdata1;
/*  92 */   private String name = "";
/*     */ 
/*     */   
/*     */   public DataLayer(int index, int i) {
/*  96 */     this.layerID = index;
/*  97 */     this.data1 = i;
/*  98 */     this.data2 = 0;
/*  99 */     this.floatdata1 = 0.0F;
/* 100 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer(int index, Block b, int meta) {
/* 105 */     this.layerID = index;
/* 106 */     this.block = b;
/* 107 */     this.data1 = 0;
/* 108 */     this.data2 = meta;
/* 109 */     this.floatdata1 = 0.0F;
/* 110 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer(int index, Block b, int meta, int altMeta, String n) {
/* 115 */     this.layerID = index;
/* 116 */     this.block = b;
/* 117 */     this.data1 = altMeta;
/* 118 */     this.data2 = meta;
/* 119 */     this.floatdata1 = 0.0F;
/* 120 */     this.name = n;
/* 121 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer(int index, String n, Block b) {
/* 126 */     this.layerID = index;
/* 127 */     this.block = b;
/* 128 */     this.data1 = 0;
/* 129 */     this.data2 = 0;
/* 130 */     this.floatdata1 = 0.0F;
/* 131 */     this.name = n;
/* 132 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer(int index, String n, int i) {
/* 137 */     this.layerID = index;
/* 138 */     this.floatdata1 = 0.0F;
/* 139 */     this.data1 = i;
/* 140 */     this.data2 = 0;
/* 141 */     this.name = n;
/* 142 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataLayer(int index, String n, float f) {
/* 147 */     this.layerID = index;
/* 148 */     this.floatdata1 = f;
/* 149 */     this.data1 = 0;
/* 150 */     this.data2 = 0;
/* 151 */     this.name = n;
/* 152 */     layers[index] = this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 157 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */