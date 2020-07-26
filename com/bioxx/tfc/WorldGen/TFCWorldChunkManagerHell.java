/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFCWorldChunkManagerHell
/*     */   extends TFCWorldChunkManager
/*     */ {
/*     */   private TFCBiome biomeGenerator;
/*     */   private float rainfall;
/*     */   
/*     */   public TFCWorldChunkManagerHell(TFCBiome par1, float par2, float par3, World world) {
/*  23 */     this.biomeGenerator = par1;
/*     */     
/*  25 */     this.rainfall = par3;
/*  26 */     this.worldObj = world;
/*  27 */     this.field_76943_g = new ArrayList<BiomeGenBase>();
/*  28 */     this.field_76943_g.add(TFCBiome.HELL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BiomeGenBase> func_76932_a() {
/*  37 */     return this.field_76943_g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome getBiomeGenAt(int par1, int par2) {
/*  46 */     return this.biomeGenerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome[] getBiomesForGeneration(BiomeGenBase[] par1, int par2, int par3, int par4, int par5) {
/*     */     TFCBiome[] arrayOfTFCBiome;
/*  55 */     if (par1 == null || par1.length < par4 * par5)
/*  56 */       arrayOfTFCBiome = new TFCBiome[par4 * par5]; 
/*  57 */     Arrays.fill((Object[])arrayOfTFCBiome, 0, par4 * par5, this.biomeGenerator);
/*  58 */     return arrayOfTFCBiome;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] func_76936_a(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
/*  67 */     if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
/*  68 */       par1ArrayOfFloat = new float[par4 * par5]; 
/*  69 */     Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, this.rainfall);
/*  70 */     return par1ArrayOfFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome[] loadBlockGeneratorData(BiomeGenBase[] par1, int par2, int par3, int par4, int par5) {
/*     */     TFCBiome[] arrayOfTFCBiome;
/*  80 */     if (par1 == null || par1.length < par4 * par5)
/*  81 */       arrayOfTFCBiome = new TFCBiome[par4 * par5]; 
/*  82 */     Arrays.fill((Object[])arrayOfTFCBiome, 0, par4 * par5, this.biomeGenerator);
/*  83 */     return arrayOfTFCBiome;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFCBiome[] getBiomeGenAt(BiomeGenBase[] par1, int par2, int par3, int par4, int par5, boolean par6) {
/*  93 */     return loadBlockGeneratorData(par1, par2, par3, par4, par5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkPosition func_150795_a(int par1, int par2, int par3, List par4List, Random par5Random) {
/* 103 */     return par4List.contains(this.biomeGenerator) ? new ChunkPosition(par1 - par3 + par5Random.nextInt(par3 * 2 + 1), 0, par2 - par3 + par5Random.nextInt(par3 * 2 + 1)) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76940_a(int par1, int par2, int par3, List par4List) {
/* 112 */     return par4List.contains(this.biomeGenerator);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCWorldChunkManagerHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */