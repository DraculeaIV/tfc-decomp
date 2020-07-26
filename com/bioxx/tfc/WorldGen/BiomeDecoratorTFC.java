/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenCustomCactus;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenCustomPumpkin;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenCustomReed;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenCustomSand;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenGrowCrops;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenWaterPlants;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeDecorator;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
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
/*     */ public class BiomeDecoratorTFC
/*     */   extends BiomeDecorator
/*     */ {
/*     */   public int field_76803_B;
/*     */   public TFCBiome biome;
/*     */   public int field_76798_D;
/*     */   public int field_76832_z;
/*     */   public int field_76804_C;
/*     */   public int field_76806_I;
/*     */   public int field_76800_F;
/*     */   public int waterPlantsPerChunk;
/*     */   public int field_76799_E;
/*     */   public int lilyPadPerChunk;
/*     */   
/*     */   public BiomeDecoratorTFC(TFCBiome par1) {
/*  55 */     this.field_76803_B = 1;
/*  56 */     this.field_76798_D = 0;
/*  57 */     this.field_76832_z = 30;
/*  58 */     this.field_76800_F = 2;
/*  59 */     this.waterPlantsPerChunk = 30;
/*  60 */     this.field_76825_v = (WorldGenerator)new WorldGenCustomReed();
/*  61 */     this.field_76810_g = (WorldGenerator)new WorldGenCustomSand(7, (Block)Blocks.field_150354_m);
/*  62 */     this.biome = par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_150513_a(BiomeGenBase bgb) {
/*  71 */     func_76797_b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     Random rand = new Random(this.field_76815_a.func_72905_C() + (((this.field_76814_c >> 7) - (this.field_76811_d >> 7)) * (this.field_76811_d >> 7)));
/*  78 */     int cropid = rand.nextInt(CropManager.getInstance().getTotalCrops());
/*  79 */     CropIndex crop = CropManager.getInstance().getCropFromId(cropid);
/*  80 */     WorldGenGrowCrops cropGen = new WorldGenGrowCrops(cropid);
/*     */     
/*  82 */     if (this.field_76813_b.nextInt(20) == 0 && crop != null) {
/*     */       
/*  84 */       int num = 2 + this.field_76813_b.nextInt(8);
/*  85 */       int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  86 */       int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  87 */       int yCoord = this.field_76815_a.func_72976_f(xCoord, zCoord) + 1;
/*  88 */       for (int count = 0; count < num; count++)
/*     */       {
/*  90 */         cropGen.generate(this.field_76815_a, this.field_76813_b, xCoord, zCoord, 1); } 
/*     */     } 
/*     */     int var2;
/*  93 */     for (var2 = 0; var2 < this.lilyPadPerChunk; var2++) {
/*     */       
/*  95 */       int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  96 */       int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  97 */       int yCoord = this.field_76815_a.func_72976_f(xCoord, zCoord);
/*     */       
/*  99 */       generateLilyPads(this.field_76815_a, this.field_76813_b, xCoord, yCoord, zCoord);
/*     */     } 
/*     */     
/* 102 */     for (var2 = 0; var2 < 10; var2++) {
/*     */       
/* 104 */       if (this.field_76813_b.nextInt(100) < 10) {
/*     */         
/* 106 */         int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 107 */         int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 108 */         int yCoord = this.field_76815_a.func_72976_f(xCoord, zCoord);
/* 109 */         if (TFC_Climate.getBioTemperatureHeight(this.field_76815_a, xCoord, yCoord, zCoord) >= 25.0F) {
/* 110 */           this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, xCoord, yCoord, zCoord);
/*     */         }
/*     */       } 
/*     */     } 
/* 114 */     if (this.field_76813_b.nextInt(300) == 0) {
/*     */       
/* 116 */       int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 117 */       int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 118 */       int yCoord = this.field_76815_a.func_72976_f(xCoord, zCoord);
/* 119 */       (new WorldGenCustomPumpkin()).func_76484_a(this.field_76815_a, this.field_76813_b, xCoord, yCoord, zCoord);
/*     */     } 
/*     */     
/* 122 */     for (var2 = 0; var2 < this.field_76800_F; var2++) {
/*     */       
/* 124 */       int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 125 */       int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 126 */       int yCoord = this.field_76815_a.func_72976_f(xCoord, zCoord);
/* 127 */       float temperature = TFC_Climate.getBioTemperatureHeight(this.field_76815_a, xCoord, this.field_76815_a.func_72976_f(xCoord, zCoord), zCoord);
/* 128 */       float rainfall = TFC_Climate.getRainfall(this.field_76815_a, xCoord, yCoord, zCoord);
/* 129 */       if (temperature > 20.0F && rainfall < 125.0F) {
/* 130 */         (new WorldGenCustomCactus()).func_76484_a(this.field_76815_a, this.field_76813_b, xCoord, yCoord, zCoord);
/*     */       }
/*     */     } 
/* 133 */     for (var2 = 0; var2 < this.waterPlantsPerChunk; var2++) {
/*     */       
/* 135 */       int xCoord = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 136 */       int zCoord = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 137 */       int yCoord = this.field_76815_a.func_72874_g(xCoord, zCoord) - 1;
/* 138 */       if (TFC_Climate.getBioTemperatureHeight(this.field_76815_a, xCoord, yCoord, zCoord) >= 7.0F) {
/* 139 */         (new WorldGenWaterPlants(TFCBlocks.waterPlant)).func_76484_a(this.field_76815_a, this.field_76813_b, xCoord, yCoord, zCoord);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean generateLilyPads(World world, Random random, int x, int y, int z) {
/* 145 */     for (int l = 0; l < 10; l++) {
/*     */       
/* 147 */       int i1 = x + random.nextInt(8) - random.nextInt(8);
/* 148 */       int j1 = y + random.nextInt(4) - random.nextInt(4);
/* 149 */       int k1 = z + random.nextInt(8) - random.nextInt(8);
/*     */       
/* 151 */       if (world.func_147437_c(i1, j1, k1) && TFCBlocks.lilyPad.func_149742_c(world, i1, j1, k1) && 
/* 152 */         TFC_Core.isFreshWater(world.func_147439_a(i1, j1 - 1, k1)) && !TFC_Core.isFreshWater(world.func_147439_a(i1, j1 - 2, k1)))
/*     */       {
/* 154 */         world.func_147465_d(i1, j1, k1, TFCBlocks.lilyPad, 0, 2);
/*     */       }
/*     */     } 
/*     */     
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150512_a(World par1World, Random par2Random, BiomeGenBase bgb, int par3, int par4) {
/* 168 */     if (this.field_76815_a == null) {
/*     */       
/* 170 */       this.field_76815_a = par1World;
/* 171 */       this.field_76813_b = par2Random;
/* 172 */       this.field_76814_c = par3;
/* 173 */       this.field_76811_d = par4;
/* 174 */       func_150513_a(bgb);
/* 175 */       this.field_76815_a = null;
/* 176 */       this.field_76813_b = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\BiomeDecoratorTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */