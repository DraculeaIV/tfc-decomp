/*     */ package com.bioxx.tfc.api.Util;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ public class SimplexNoise
/*     */ {
/*     */   public SimplexNoise_Octave[] octaves;
/*     */   public double[] frequencys;
/*     */   public double[] amplitudes;
/*     */   public int largestFeature;
/*     */   public double persistence;
/*     */   public long seed;
/*     */   
/*     */   public SimplexNoise(int largestFeature, double persistence, long seed) {
/*  34 */     this.largestFeature = largestFeature;
/*  35 */     this.persistence = persistence;
/*  36 */     this.seed = seed;
/*     */ 
/*     */     
/*  39 */     int numberOfOctaves = (int)Math.ceil(Math.log10(largestFeature) / Math.log10(2.0D));
/*     */     
/*  41 */     this.octaves = new SimplexNoise_Octave[numberOfOctaves];
/*  42 */     this.frequencys = new double[numberOfOctaves];
/*  43 */     this.amplitudes = new double[numberOfOctaves];
/*     */     
/*  45 */     Random rnd = new Random(seed);
/*     */     
/*  47 */     for (int i = 0; i < numberOfOctaves; i++) {
/*  48 */       this.octaves[i] = new SimplexNoise_Octave(rnd.nextInt());
/*     */       
/*  50 */       this.frequencys[i] = Math.pow(2.0D, i);
/*  51 */       this.amplitudes[i] = Math.pow(persistence, (this.octaves.length - i));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getNoise(int x, int y) {
/*  60 */     double result = 0.0D;
/*     */     
/*  62 */     for (int i = 0; i < this.octaves.length; i++)
/*     */     {
/*     */ 
/*     */       
/*  66 */       result += this.octaves[i].noise(x / this.frequencys[i], y / this.frequencys[i]) * this.amplitudes[i];
/*     */     }
/*     */ 
/*     */     
/*  70 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getNoise(int x, int y, int z) {
/*  76 */     double result = 0.0D;
/*     */     
/*  78 */     for (int i = 0; i < this.octaves.length; i++) {
/*  79 */       double frequency = Math.pow(2.0D, i);
/*  80 */       double amplitude = Math.pow(this.persistence, (this.octaves.length - i));
/*     */       
/*  82 */       result += this.octaves[i].noise(x / frequency, y / frequency, z / frequency) * amplitude;
/*     */     } 
/*     */ 
/*     */     
/*  86 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getNoiseArray(int xSize, int zSize) {
/*  92 */     double[] outNoise = new double[xSize * zSize];
/*  93 */     for (int x = 0; x < 16; x++) {
/*     */       
/*  95 */       for (int z = 0; z < 16; z++)
/*     */       {
/*  97 */         outNoise[x + z * 16] = getNoise(x, z);
/*     */       }
/*     */     } 
/* 100 */     return outNoise;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Util\SimplexNoise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */