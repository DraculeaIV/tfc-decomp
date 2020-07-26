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
/*     */ 
/*     */     
/* 130 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityPheasantTFC.class, 6, 1, 4));
/* 131 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityDeer.class, 4, 1, 4));
/* 132 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityOcelotTFC.class, 4, 1, 1));
/* 133 */     this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityBear.class, 1, 1, 1));
/*     */     
/* 135 */     this.field_76755_L.clear();
/* 136 */     switch (par1) { case 0:
/* 137 */         this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntitySquidTFC.class, 8, 1, 1)); break;
/* 138 */       case 2: this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntityFishTFC.class, 7, 1, 2));
/* 139 */         this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntityFishTFC.class, 12, 0, 0));
/*     */         break; }
/*     */ 
/*     */     
/* 143 */     this.field_76761_J.clear();
/* 144 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySpiderTFC.class, 5, 1, 1));
/* 145 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityZombieTFC.class, 10, 2, 4));
/* 146 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySkeletonTFC.class, 8, 1, 1));
/* 147 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityCreeperTFC.class, 3, 1, 2));
/* 148 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlimeTFC.class, 8, 1, 2));
/* 149 */     this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityEndermanTFC.class, 1, 1, 2));
/*     */ 
/*     */     
/* 152 */     biomeList[par1] = this;
/* 153 */     this.field_76760_I = createBiomeDecorator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBiomeColor() {
/* 158 */     return this.biomeColor;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setBiomeColor(int c) {
/* 163 */     this.biomeColor = c;
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeDecoratorTFC createBiomeDecorator() {
/* 173 */     return new BiomeDecoratorTFC(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76728_a(World par1World, Random par2Random, int par3, int par4) {
/* 179 */     this.field_76760_I.func_150512_a(par1World, par2Random, this, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setMinMaxHeight(float par1, float par2) {
/* 188 */     this.field_76748_D = par1 - 2.7F;
/* 189 */     this.field_76749_E = par2 - 2.7F;
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setTemperatureRainfall(float par1, float par2) {
/* 196 */     this.temperatureTFC = par1;
/* 197 */     this.field_76751_G = par2;
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setBiomeName(String par1Str) {
/* 204 */     this.field_76791_y = par1Str;
/* 205 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setWaterMult(int par1) {
/* 210 */     this.field_76759_H = par1;
/* 211 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setColor(int par1) {
/* 217 */     this.field_76790_z = par1;
/* 218 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome setDisableRain() {
/* 227 */     this.field_76765_S = false;
/* 228 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldGenerator getTreeGen(int i, Boolean j) {
/* 233 */     Random r = new Random();
/* 234 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 7:
/* 238 */         if (j.booleanValue()) {
/* 239 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 7) : (WorldGenerator)worldGenAshTallTrees;
/*     */         }
/* 241 */         return (WorldGenerator)worldGenAshShortTrees;
/*     */ 
/*     */       
/*     */       case 1:
/* 245 */         if (j.booleanValue()) {
/* 246 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 1) : (WorldGenerator)worldGenAspenTallTrees;
/*     */         }
/* 248 */         return (WorldGenerator)worldGenAspenShortTrees;
/*     */ 
/*     */       
/*     */       case 2:
/* 252 */         if (j.booleanValue()) {
/* 253 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 2) : (WorldGenerator)worldGenBirchTallTrees;
/*     */         }
/* 255 */         return (WorldGenerator)worldGenBirchShortTrees;
/*     */ 
/*     */       
/*     */       case 3:
/* 259 */         if (j.booleanValue()) {
/* 260 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 3) : (WorldGenerator)worldGenChestnutTallTrees;
/*     */         }
/* 262 */         return (WorldGenerator)worldGenChestnutShortTrees;
/*     */ 
/*     */       
/*     */       case 4:
/* 266 */         if (j.booleanValue()) {
/* 267 */           return (WorldGenerator)worldGenDouglasFirTallTrees;
/*     */         }
/* 269 */         return (WorldGenerator)worldGenDouglasFirShortTrees;
/*     */ 
/*     */       
/*     */       case 5:
/* 273 */         if (j.booleanValue()) {
/* 274 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 5) : (WorldGenerator)worldGenHickoryTallTrees;
/*     */         }
/* 276 */         return (WorldGenerator)worldGenHickoryShortTrees;
/*     */ 
/*     */       
/*     */       case 6:
/* 280 */         if (j.booleanValue()) {
/* 281 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 6) : (WorldGenerator)worldGenMapleTallTrees;
/*     */         }
/* 283 */         return (WorldGenerator)worldGenMapleShortTrees;
/*     */ 
/*     */       
/*     */       case 0:
/* 287 */         if (j.booleanValue()) {
/* 288 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 0) : (WorldGenerator)worldGenOakTallTrees;
/*     */         }
/* 290 */         return (WorldGenerator)worldGenOakShortTrees;
/*     */ 
/*     */       
/*     */       case 8:
/* 294 */         if (j.booleanValue()) {
/* 295 */           return (WorldGenerator)worldGenPineTallTrees;
/*     */         }
/* 297 */         return (WorldGenerator)worldGenPineShortTrees;
/*     */ 
/*     */       
/*     */       case 9:
/* 301 */         if (j.booleanValue()) {
/* 302 */           return (WorldGenerator)worldGenRedwoodTallTrees;
/*     */         }
/* 304 */         return (WorldGenerator)worldGenRedwoodShortTrees;
/*     */ 
/*     */       
/*     */       case 10:
/* 308 */         if (j.booleanValue()) {
/* 309 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 10) : (WorldGenerator)worldGenSpruceTallTrees;
/*     */         }
/* 311 */         return (WorldGenerator)worldGenSpruceShortTrees;
/*     */ 
/*     */       
/*     */       case 11:
/* 315 */         if (j.booleanValue()) {
/* 316 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 11) : (WorldGenerator)worldGenSycamoreTallTrees;
/*     */         }
/* 318 */         return (WorldGenerator)worldGenSycamoreShortTrees;
/*     */ 
/*     */       
/*     */       case 12:
/* 322 */         return (WorldGenerator)worldGenWhiteCedarTallTrees;
/*     */ 
/*     */       
/*     */       case 13:
/* 326 */         if (j.booleanValue()) {
/* 327 */           return (r.nextInt(20) == 0) ? (WorldGenerator)new WorldGenCustomBigTree(false, 13) : (WorldGenerator)worldGenWhiteElmTallTrees;
/*     */         }
/* 329 */         return (WorldGenerator)worldGenWhiteElmShortTrees;
/*     */ 
/*     */       
/*     */       case 14:
/* 333 */         return (WorldGenerator)worldGenWillowShortTrees;
/*     */ 
/*     */       
/*     */       case 15:
/* 337 */         return (WorldGenerator)new WorldGenCustomShortTrees(false, 15);
/*     */ 
/*     */       
/*     */       case 16:
/* 341 */         return (WorldGenerator)worldGenAcaciaKoaTrees;
/*     */     } 
/*     */     
/* 344 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TFCBiome getBiome(int id) {
/* 352 */     if (biomeList[id] == null)
/*     */     {
/* 354 */       TerraFirmaCraft.LOG.warn("Biome ID is null: " + id);
/*     */     }
/* 356 */     if (id >= 0 && id <= biomeList.length && biomeList[id] != null)
/*     */     {
/* 358 */       return biomeList[id];
/*     */     }
/*     */ 
/*     */     
/* 362 */     TerraFirmaCraft.LOG.warn("Biome ID is out of bounds: " + id + ", defaulting to 0 (Ocean)");
/* 363 */     return OCEAN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static TFCBiome getBiomeByName(String name) {
/* 369 */     for (int i = 0; i < (getBiomeGenArray()).length; i++) {
/*     */       
/* 371 */       if (getBiomeGenArray()[i] != null) {
/*     */         
/* 373 */         String n = (getBiomeGenArray()[i]).field_76791_y.toLowerCase();
/* 374 */         if (n.equalsIgnoreCase(name))
/* 375 */           return getBiomeGenArray()[i]; 
/*     */       } 
/*     */     } 
/* 378 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static TFCBiome[] getBiomeGenArray() {
/* 383 */     return (TFCBiome[])biomeList.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setLilyPads(int i) {
/* 388 */     this.field_76760_I.lilyPadPerChunk = i;
/* 389 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TFCBiome setWaterPlants(int i) {
/* 394 */     this.field_76760_I.waterPlantsPerChunk = i;
/* 395 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCBiome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */