/*     */ package com.bioxx.tfc.WorldGen;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenAcaciaKoaTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomBigTree;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomCedarTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomShortTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomTallTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenCustomWillowTrees;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenDouglasFir;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenPineTall;
/*     */ import com.bioxx.tfc.WorldGen.Generators.Trees.WorldGenRedwoodXL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class TFCBiome extends BiomeGenBase {
/*  17 */   public static float riverDepthMin = -0.5F;
/*  18 */   public static float riverDepthMax = -0.3F;
/*     */   
/*     */   public float temperatureTFC;
/*     */   
/*     */   public BiomeDecoratorTFC field_76760_I;
/*  23 */   public static TFCBiome[] biomeList = new TFCBiome[256];
/*     */ 
/*     */   
/*  26 */   public static final TFCBiome OCEAN = (new TFCBiome(0)).setBiomeName("Ocean").setMinMaxHeight(-0.9F, 1.0E-5F).setBiomeColor(255);
/*  27 */   public static final TFCBiome RIVER = (new TFCBiome(7)).setBiomeName("River").setMinMaxHeight(riverDepthMin, riverDepthMax).setBiomeColor(16777215);
/*  28 */   public static final TFCBiome HELL = (new TFCBiome(8)).setColor(16711680).setBiomeName("Hell").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
/*  29 */   public static final TFCBiome BEACH = (new TFCBiome(16)).setColor(16440917).setBiomeName("Beach").setMinMaxHeight(0.01F, 0.02F).setBiomeColor(16758899);
/*  30 */   public static final TFCBiome GRAVEL_BEACH = (new TFCBiome(17)).setColor(16440917).setBiomeName("Gravel Beach").setMinMaxHeight(0.01F, 0.02F).setBiomeColor(9402723);
/*  31 */   public static final TFCBiome HIGH_HILLS = (new TFCBiome(3)).setBiomeName("High Hills").setMinMaxHeight(0.8F, 1.6F).setBiomeColor(282407);
/*  32 */   public static final TFCBiome PLAINS = (new TFCBiome(1)).setBiomeName("Plains").setMinMaxHeight(0.1F, 0.16F).setBiomeColor(6938528);
/*  33 */   public static final TFCBiome SWAMPLAND = (new TFCBiome(6)).setBiomeName("Swamp").setMinMaxHeight(-0.1F, 0.1F).setBiomeColor(2046251).setLilyPads(8).setWaterPlants(45);
/*  34 */   public static final TFCBiome HIGH_HILLS_EDGE = (new TFCBiome(20)).setBiomeName("High Hills Edge").setMinMaxHeight(0.2F, 0.4F).setBiomeColor(3188583);
/*  35 */   public static final TFCBiome ROLLING_HILLS = (new TFCBiome(30)).setBiomeName("Rolling Hills").setMinMaxHeight(0.1F, 0.4F).setBiomeColor(8893492);
/*  36 */   public static final TFCBiome MOUNTAINS = (new TFCBiome(31)).setBiomeName("Mountains").setMinMaxHeight(0.8F, 1.6F).setBiomeColor(7371104);
/*  37 */   public static final TFCBiome MOUNTAINS_EDGE = (new TFCBiome(32)).setBiomeName("Mountains Edge").setMinMaxHeight(0.4F, 0.8F).setBiomeColor(11713695);
/*  38 */   public static final TFCBiome HIGH_PLAINS = (new TFCBiome(35)).setBiomeName("High Plains").setMinMaxHeight(0.4F, 0.43F).setBiomeColor(10920988);
/*  39 */   public static final TFCBiome DEEP_OCEAN = (new TFCBiome(36)).setBiomeName("Deep Ocean").setMinMaxHeight(-1.5F, 1.0E-5F).setBiomeColor(918874);
/*  40 */   public static final TFCBiome LAKE = (new TFCBiome(2)).setBiomeName("Lake").setMinMaxHeight(-0.5F, 0.001F).setBiomeColor(4886174).setLilyPads(2);
/*     */   
/*     */   protected static WorldGenAcaciaKoaTrees worldGenAcaciaKoaTrees;
/*     */   
/*     */   protected static WorldGenCustomTallTrees worldGenAshTallTrees;
/*     */   
/*     */   protected static WorldGenCustomTallTrees worldGenAspenTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenBirchTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenChestnutTallTrees;
/*     */   protected static WorldGenDouglasFir worldGenDouglasFirTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenHickoryTallTrees;
/*     */   protected static WorldGenCustomMapleTallTrees worldGenMapleTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenOakTallTrees;
/*     */   protected static WorldGenPineTall worldGenPineTallTrees;
/*     */   protected static WorldGenRedwoodXL worldGenRedwoodTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenSpruceTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenSycamoreTallTrees;
/*     */   protected static WorldGenCustomCedarTrees worldGenWhiteCedarTallTrees;
/*     */   protected static WorldGenCustomTallTrees worldGenWhiteElmTallTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenAshShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenAspenShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenBirchShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenChestnutShortTrees;
/*     */   protected static WorldGenDouglasFir worldGenDouglasFirShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenHickoryShortTrees;
/*     */   protected static WorldGenCustomMapleShortTrees worldGenMapleShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenOakShortTrees;
/*     */   protected static WorldGenPineShort worldGenPineShortTrees;
/*     */   protected static WorldGenRedwoodXL worldGenRedwoodShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenSpruceShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenSycamoreShortTrees;
/*     */   protected static WorldGenCustomShortTrees worldGenWhiteElmShortTrees;
/*     */   protected static WorldGenCustomWillowTrees worldGenWillowShortTrees;
/*     */   protected int biomeColor;
/*     */   
/*     */   public TFCBiome(int par1) {
/*  76 */     super(par1);
/*     */     
/*  78 */     this.field_76752_A = (Block)Blocks.field_150349_c;
/*  79 */     this.field_76753_B = Blocks.field_150346_d;
/*  80 */     this.field_76748_D = 0.1F;
/*  81 */     this.field_76749_E = 0.3F;
/*  82 */     this.temperatureTFC = 0.5F;
/*  83 */     this.field_76751_G = 0.5F;
/*  84 */     this.field_76761_J = new ArrayList();
/*  85 */     this.field_76762_K = new ArrayList();
/*  86 */     this.field_76755_L = new ArrayList();
/*     */     
/*  88 */     worldGenAcaciaKoaTrees = new WorldGenAcaciaKoaTrees(false, 0);
/*  89 */     worldGenAshTallTrees = new WorldGenCustomTallTrees(false, 7);
/*  90 */     worldGenAspenTallTrees = new WorldGenCustomTallTrees(false, 1);
/*  91 */     worldGenBirchTallTrees = new WorldGenCustomTallTrees(false, 2);
/*  92 */     worldGenChestnutTallTrees = new WorldGenCustomTallTrees(false, 3);
/*  93 */     worldGenDouglasFirTallTrees = new WorldGenDouglasFir(false, 4, true);
/*  94 */     worldGenHickoryTallTrees = new WorldGenCustomTallTrees(false, 5);
/*  95 */     worldGenMapleTallTrees = new WorldGenCustomMapleTallTrees(false, 6);
/*  96 */     worldGenOakTallTrees = new WorldGenCustomTallTrees(false, 0);
/*  97 */     worldGenPineTallTrees = new WorldGenPineTall(8);
/*  98 */     worldGenRedwoodTallTrees = new WorldGenRedwoodXL(false);
/*  99 */     worldGenSpruceTallTrees = new WorldGenCustomTallTrees(false, 10);
/* 100 */     worldGenSycamoreTallTrees = new WorldGenCustomTallTrees(false, 11);
/* 101 */     worldGenWhiteCedarTallTrees = new WorldGenCustomCedarTrees(false, 12);
/* 102 */     worldGenWhiteElmTallTrees = new WorldGenCustomTallTrees(false, 13);
/*     */     
/* 104 */     worldGenAshShortTrees = new WorldGenCustomShortTrees(false, 7);
/* 105 */     worldGenAspenShortTrees = new WorldGenCustomShortTrees(false, 1);
/* 106 */     worldGenBirchShortTrees = new WorldGenCustomShortTrees(false, 2);
/* 107 */     worldGenChestnutShortTrees = new WorldGenCustomShortTrees(false, 3);
/* 108 */     worldGenDouglasFirShortTrees = new WorldGenDouglasFir(false, 4, false);
/* 109 */     worldGenHickoryShortTrees = new WorldGenCustomShortTrees(false, 5);
/* 110 */     worldGenMapleShortTrees = new WorldGenCustomMapleShortTrees(false, 6);
/* 111 */     worldGenOakShortTrees = new WorldGenCustomShortTrees(false, 0);
/* 112 */     worldGenPineShortTrees = new WorldGenPineShort(false, 8);
/* 113 */     worldGenRedwoodShortTrees = new WorldGenRedwoodXL(false);
/* 114 */     worldGenSpruceShortTrees = new WorldGenCustomShortTrees(false, 10);
/* 115 */     worldGenSycamoreShortTrees = new WorldGenCustomShortTrees(false, 11);
/* 116 */     worldGenWhiteElmShortTrees = new WorldGenCustomShortTrees(false, 13);
/* 117 */     worldGenWillowShortTrees = new WorldGenCustomWillowTrees(false, 14);
/*     */ 
/*     */     
/* 120 */     this.field_76762_K.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 16, 0, 0));
/*     */     
/* 130 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 2, 1, 4));
/* 131 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityDeer.class, 1, 1, 4));
/*     */     
/* 133 */     this.field_76755_L.clear();
/* 134 */     switch (par1) { case 0:
/* 135 */         this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntitySquidTFC.class, 8, 1, 1)); break;
/* 136 */       case 2: this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntityFishTFC.class, 7, 1, 2));
/* 137 */         this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntityFishTFC.class, 12, 0, 0));
/*     */         break; }
/*     */ 
/*     */     
/* 141 */     this.field_76761_J.clear();
/* 142 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySpiderTFC.class, 5, 1, 1));
/* 143 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityZombieTFC.class, 10, 2, 4));
/* 144 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySkeletonTFC.class, 8, 1, 1));
/* 145 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityCreeperTFC.class, 3, 1, 2));
/* 146 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlimeTFC.class, 8, 1, 2));
/* 147 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityEndermanTFC.class, 1, 1, 2));
/*     */ 
/*     */     
/* 150 */     biomeList[par1] = this;
/* 151 */     this.field_76760_I = createBiomeDecorator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBiomeColor() {
/* 156 */     return this.biomeColor;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setBiomeColor(int c) {
/* 161 */     this.biomeColor = c;
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeDecoratorTFC createBiomeDecorator() {
/* 171 */     return new BiomeDecoratorTFC(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76728_a(World par1World, Random par2Random, int par3, int par4) {
/* 177 */     this.field_76760_I.func_150512_a(par1World, par2Random, this, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setMinMaxHeight(float par1, float par2) {
/* 186 */     this.field_76748_D = par1 - 2.7F;
/* 187 */     this.field_76749_E = par2 - 2.7F;
/* 188 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setTemperatureRainfall(float par1, float par2) {
/* 194 */     this.temperatureTFC = par1;
/* 195 */     this.field_76751_G = par2;
/* 196 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setBiomeName(String par1Str) {
/* 202 */     this.field_76791_y = par1Str;
/* 203 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setWaterMult(int par1) {
/* 208 */     this.field_76759_H = par1;
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setColor(int par1) {
/* 215 */     this.field_76790_z = par1;
/* 216 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setDisableRain() {
/* 225 */     this.field_76765_S = false;
/* 226 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldGenerator getTreeGen(int i, Boolean j) {
/* 231 */     Random r = new Random();
/* 232 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 7:
/* 236 */         if (j.booleanValue()) {
/* 237 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 7) : (WorldGenerator)worldGenAshTallTrees;
/*     */         }
/* 239 */         return (WorldGenerator)worldGenAshShortTrees;
/*     */ 
/*     */       
/*     */       case 1:
/* 243 */         if (j.booleanValue()) {
/* 244 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 1) : (WorldGenerator)worldGenAspenTallTrees;
/*     */         }
/* 246 */         return (WorldGenerator)worldGenAspenShortTrees;
/*     */ 
/*     */       
/*     */       case 2:
/* 250 */         if (j.booleanValue()) {
/* 251 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 2) : (WorldGenerator)worldGenBirchTallTrees;
/*     */         }
/* 253 */         return (WorldGenerator)worldGenBirchShortTrees;
/*     */ 
/*     */       
/*     */       case 3:
/* 257 */         if (j.booleanValue()) {
/* 258 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 3) : (WorldGenerator)worldGenChestnutTallTrees;
/*     */         }
/* 260 */         return (WorldGenerator)worldGenChestnutShortTrees;
/*     */ 
/*     */       
/*     */       case 4:
/* 264 */         if (j.booleanValue()) {
/* 265 */           return (WorldGenerator)worldGenDouglasFirTallTrees;
/*     */         }
/* 267 */         return (WorldGenerator)worldGenDouglasFirShortTrees;
/*     */ 
/*     */       
/*     */       case 5:
/* 271 */         if (j.booleanValue()) {
/* 272 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 5) : (WorldGenerator)worldGenHickoryTallTrees;
/*     */         }
/* 274 */         return (WorldGenerator)worldGenHickoryShortTrees;
/*     */ 
/*     */       
/*     */       case 6:
/* 278 */         if (j.booleanValue()) {
/* 279 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 6) : (WorldGenerator)worldGenMapleTallTrees;
/*     */         }
/* 281 */         return (WorldGenerator)worldGenMapleShortTrees;
/*     */ 
/*     */       
/*     */       case 0:
/* 285 */         if (j.booleanValue()) {
/* 286 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 0) : (WorldGenerator)worldGenOakTallTrees;
/*     */         }
/* 288 */         return (WorldGenerator)worldGenOakShortTrees;
/*     */ 
/*     */       
/*     */       case 8:
/* 292 */         if (j.booleanValue()) {
/* 293 */           return (WorldGenerator)worldGenPineTallTrees;
/*     */         }
/* 295 */         return (WorldGenerator)worldGenPineShortTrees;
/*     */ 
/*     */       
/*     */       case 9:
/* 299 */         if (j.booleanValue()) {
/* 300 */           return (WorldGenerator)worldGenRedwoodTallTrees;
/*     */         }
/* 302 */         return (WorldGenerator)worldGenRedwoodShortTrees;
/*     */ 
/*     */       
/*     */       case 10:
/* 306 */         if (j.booleanValue()) {
/* 307 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 10) : (WorldGenerator)worldGenSpruceTallTrees;
/*     */         }
/* 309 */         return (WorldGenerator)worldGenSpruceShortTrees;
/*     */ 
/*     */       
/*     */       case 11:
/* 313 */         if (j.booleanValue()) {
/* 314 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 11) : (WorldGenerator)worldGenSycamoreTallTrees;
/*     */         }
/* 316 */         return (WorldGenerator)worldGenSycamoreShortTrees;
/*     */ 
/*     */       
/*     */       case 12:
/* 320 */         return (WorldGenerator)worldGenWhiteCedarTallTrees;
/*     */ 
/*     */       
/*     */       case 13:
/* 324 */         if (j.booleanValue()) {
/* 325 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 13) : (WorldGenerator)worldGenWhiteElmTallTrees;
/*     */         }
/* 327 */         return (WorldGenerator)worldGenWhiteElmShortTrees;
/*     */ 
/*     */       
/*     */       case 14:
/* 331 */         return (WorldGenerator)worldGenWillowShortTrees;
/*     */ 
/*     */       
/*     */       case 15:
/* 335 */         return (WorldGenerator)new WorldGenCustomShortTrees(false, 15);
/*     */ 
/*     */       
/*     */       case 16:
/* 339 */         return (WorldGenerator)worldGenAcaciaKoaTrees;
/*     */     } 
/*     */     
/* 342 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TFCBiome getBiome(int id) {
/* 350 */     if (biomeList[id] == null)
/*     */     {
/* 352 */       TerraFirmaCraft.LOG.warn("Biome ID is null: " + id);
/*     */     }
/* 354 */     if (id >= 0 && id <= biomeList.length && biomeList[id] != null)
/*     */     {
/* 356 */       return biomeList[id];
/*     */     }
/*     */ 
/*     */     
/* 360 */     TerraFirmaCraft.LOG.warn("Biome ID is out of bounds: " + id + ", defaulting to 0 (Ocean)");
/* 361 */     return OCEAN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static TFCBiome getBiomeByName(String name) {
/* 367 */     for (int i = 0; i < (getBiomeGenArray()).length; i++) {
/*     */       
/* 369 */       if (getBiomeGenArray()[i] != null) {
/*     */         
/* 371 */         String n = (getBiomeGenArray()[i]).field_76791_y.toLowerCase();
/* 372 */         if (n.equalsIgnoreCase(name))
/* 373 */           return getBiomeGenArray()[i]; 
/*     */       } 
/*     */     } 
/* 376 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static TFCBiome[] getBiomeGenArray() {
/* 381 */     return (TFCBiome[])biomeList.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setLilyPads(int i) {
/* 386 */     this.field_76760_I.lilyPadPerChunk = i;
/* 387 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setWaterPlants(int i) {
/* 392 */     this.field_76760_I.waterPlantsPerChunk = i;
/* 393 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCBiome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */