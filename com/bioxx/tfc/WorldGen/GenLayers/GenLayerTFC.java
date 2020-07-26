/*     */ package com.bioxx.tfc.WorldGen.GenLayers;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerAddIslandTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerBiomeEdge;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerBiomeTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerDeepOcean;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerIslandTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerLakes;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.Biome.GenLayerShoreTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.River.GenLayerRiverInitTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.River.GenLayerRiverMixTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.River.GenLayerRiverTFC;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.WorldGen.TFCWorldType;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ public abstract class GenLayerTFC extends GenLayer {
/*     */   protected long field_75907_b;
/*     */   protected GenLayerTFC field_75909_a;
/*     */   
/*     */   public static GenLayerTFC[] initialize(long par0, TFCWorldType par2) {
/*     */     GenLayerShoreTFC genLayerShoreTFC;
/*  29 */     GenLayerTFC continent = genContinent(0L, false);
/*  30 */     GenLayerDeepOcean genLayerDeepOcean = new GenLayerDeepOcean(4L, continent);
/*  31 */     drawImage(512, (GenLayerTFC)genLayerDeepOcean, "8b Continents Done Deep Ocean");
/*  32 */     byte var4 = 4;
/*     */ 
/*     */     
/*  35 */     GenLayerTFC continentCopy2 = GenLayerZoomTFC.magnify(1000L, (GenLayerTFC)genLayerDeepOcean, 0);
/*  36 */     drawImage(512, continentCopy2, "14 ContinentsZoom");
/*  37 */     GenLayerBiomeTFC genLayerBiomeTFC = new GenLayerBiomeTFC(200L, continentCopy2, par2);
/*  38 */     drawImage(512, (GenLayerTFC)genLayerBiomeTFC, "15 Biome");
/*  39 */     GenLayerLakes lakes = new GenLayerLakes(200L, (GenLayer)genLayerBiomeTFC);
/*  40 */     drawImage(512, (GenLayerTFC)genLayerBiomeTFC, "15b Lakes");
/*  41 */     continentCopy2 = GenLayerZoomTFC.magnify(1000L, (GenLayerTFC)lakes, 2);
/*  42 */     drawImage(512, continentCopy2, "16 ZoomBiome");
/*  43 */     GenLayerBiomeEdge genLayerBiomeEdge = new GenLayerBiomeEdge(1000L, continentCopy2);
/*  44 */     drawImage(512, (GenLayerTFC)genLayerBiomeEdge, "17 BiomeEdge");
/*  45 */     for (int var7 = 0; var7 < var4; var7++) {
/*     */       GenLayerAddIslandTFC genLayerAddIslandTFC;
/*  47 */       GenLayerZoomTFC genLayerZoomTFC = new GenLayerZoomTFC((1000 + var7), (GenLayerTFC)genLayerBiomeEdge);
/*  48 */       drawImage(512, genLayerZoomTFC, "18-" + var7 + " Zoom");
/*  49 */       if (var7 == 0)
/*  50 */         genLayerAddIslandTFC = new GenLayerAddIslandTFC(3L, genLayerZoomTFC); 
/*  51 */       if (var7 == 1) {
/*     */         
/*  53 */         genLayerShoreTFC = new GenLayerShoreTFC(1000L, (GenLayer)genLayerAddIslandTFC);
/*  54 */         drawImage(512, (GenLayerTFC)genLayerShoreTFC, "18z Shore");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  59 */     GenLayerTFC riverCont = GenLayerZoomTFC.magnify(1000L, (GenLayerTFC)genLayerDeepOcean, 2);
/*  60 */     drawImage(512, riverCont, "9 ContinentsZoom");
/*  61 */     GenLayerRiverInitTFC genLayerRiverInitTFC = new GenLayerRiverInitTFC(100L, riverCont);
/*  62 */     drawImage(512, (GenLayerTFC)genLayerRiverInitTFC, "10 RiverInit");
/*  63 */     GenLayerTFC genLayerTFC1 = GenLayerZoomTFC.magnify(1000L, (GenLayerTFC)genLayerRiverInitTFC, 6);
/*  64 */     drawImage(512, genLayerTFC1, "11 RiverInitZoom");
/*  65 */     GenLayerRiverTFC genLayerRiverTFC = new GenLayerRiverTFC(1L, genLayerTFC1);
/*  66 */     drawImage(512, (GenLayerTFC)genLayerRiverTFC, "12 River");
/*  67 */     GenLayerSmoothTFC genLayerSmoothTFC = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerRiverTFC);
/*  68 */     drawImage(512, genLayerSmoothTFC, "13 SmoothRiver");
/*     */     
/*  70 */     GenLayerSmoothBiomeTFC smoothContinent = new GenLayerSmoothBiomeTFC(1000L, (GenLayer)genLayerShoreTFC);
/*  71 */     drawImage(512, smoothContinent, "Biome 19");
/*  72 */     GenLayerRiverMixTFC riverMix = new GenLayerRiverMixTFC(100L, smoothContinent, genLayerSmoothTFC);
/*  73 */     drawImage(512, (GenLayerTFC)riverMix, "Biome 20");
/*  74 */     GenLayerTFC finalCont = GenLayerZoomTFC.magnify(1000L, (GenLayerTFC)riverMix, 2);
/*  75 */     drawImage(512, finalCont, "Biome 20-zoom");
/*  76 */     finalCont = new GenLayerSmoothBiomeTFC(1001L, finalCont);
/*  77 */     drawImage(512, finalCont, "Biome 21");
/*  78 */     riverMix.func_75905_a(par0);
/*  79 */     finalCont.func_75905_a(par0);
/*  80 */     return new GenLayerTFC[] { (GenLayerTFC)riverMix, finalCont };
/*     */   }
/*     */   protected long field_75908_c; protected long field_75906_d; private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed, boolean oceanReduction) {
/*  85 */     GenLayerIslandTFC genLayerIslandTFC = new GenLayerIslandTFC(1L + seed);
/*  86 */     drawImage(512, (GenLayerTFC)genLayerIslandTFC, "0 ContinentsStart");
/*  87 */     GenLayerFuzzyZoomTFC continentFuzzyZoom = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)genLayerIslandTFC);
/*  88 */     drawImage(512, continentFuzzyZoom, "1 ContinentsFuzzyZoom");
/*  89 */     GenLayerAddIslandTFC genLayerAddIslandTFC1 = new GenLayerAddIslandTFC(1L, continentFuzzyZoom);
/*  90 */     drawImage(512, (GenLayerTFC)genLayerAddIslandTFC1, "2 ContinentsAddIsland");
/*  91 */     GenLayerTFC var11 = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerAddIslandTFC1);
/*  92 */     drawImage(512, var11, "3 ContinentsAddIslandZoom");
/*  93 */     genLayerAddIslandTFC1 = new GenLayerAddIslandTFC(2L, var11);
/*  94 */     drawImage(512, (GenLayerTFC)genLayerAddIslandTFC1, "4 ContinentsAddIsland2");
/*  95 */     var11 = new GenLayerZoomTFC(2002L, (GenLayerTFC)genLayerAddIslandTFC1);
/*  96 */     drawImage(512, var11, "5 ContinentsAddIslandZoom2");
/*  97 */     genLayerAddIslandTFC1 = new GenLayerAddIslandTFC(3L, var11);
/*  98 */     drawImage(512, (GenLayerTFC)genLayerAddIslandTFC1, "6 ContinentsAddIsland3");
/*  99 */     var11 = new GenLayerZoomTFC(2003L, (GenLayerTFC)genLayerAddIslandTFC1);
/* 100 */     drawImage(512, var11, "7 ContinentsAddIslandZoom3");
/* 101 */     GenLayerAddIslandTFC genLayerAddIslandTFC2 = new GenLayerAddIslandTFC(4L, var11);
/* 102 */     drawImage(512, (GenLayerTFC)genLayerAddIslandTFC2, "8 ContinentsDone");
/* 103 */     return (GenLayerTFC)genLayerAddIslandTFC2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/* 109 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/* 113 */       File outFile = new File(name + ".bmp");
/* 114 */       if (outFile.exists())
/*     */         return; 
/* 116 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/* 117 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/* 118 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/* 119 */       graphics.clearRect(0, 0, size, size);
/* 120 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/* 121 */       for (int x = 0; x < size; x++) {
/*     */         
/* 123 */         for (int z = 0; z < size; z++) {
/*     */           
/* 125 */           if (ints[x * size + z] != -1 && TFCBiome.getBiomeGenArray()[ints[x * size + z]] != null) {
/*     */             
/* 127 */             graphics.setColor(Color.getColor("", TFCBiome.getBiome(ints[x * size + z]).getBiomeColor()));
/* 128 */             graphics.drawRect(x, z, 1, 1);
/*     */           } 
/*     */         } 
/*     */       } 
/* 132 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/* 133 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 135 */     catch (Exception e) {
/*     */       
/* 137 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenLayerTFC(long par1) {
/* 143 */     super(par1);
/* 144 */     this.field_75906_d = par1;
/* 145 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 146 */     this.field_75906_d += par1;
/* 147 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 148 */     this.field_75906_d += par1;
/* 149 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 150 */     this.field_75906_d += par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/* 161 */     this.field_75907_b = par1;
/* 162 */     if (this.field_75909_a != null) {
/* 163 */       this.field_75909_a.func_75905_a(par1);
/*     */     }
/* 165 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 166 */     this.field_75907_b += this.field_75906_d;
/* 167 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 168 */     this.field_75907_b += this.field_75906_d;
/* 169 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 170 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75903_a(long par1, long par3) {
/* 179 */     this.field_75908_c = this.field_75907_b;
/* 180 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 181 */     this.field_75908_c += par1;
/* 182 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 183 */     this.field_75908_c += par3;
/* 184 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 185 */     this.field_75908_c += par1;
/* 186 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 187 */     this.field_75908_c += par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_75902_a(int par1) {
/* 196 */     int var2 = (int)((this.field_75908_c >> 24L) % par1);
/* 197 */     if (var2 < 0)
/* 198 */       var2 += par1; 
/* 199 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 200 */     this.field_75908_c += this.field_75907_b;
/* 201 */     return var2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int validateInt(int[] array, int index) {
/* 215 */     return array[index];
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateIntArray(int[] array, int xSize, int zSize) {
/* 220 */     for (int z = 0; z < zSize; z++) {
/*     */       
/* 222 */       for (int x = 0; x < xSize; x++) {
/*     */         
/* 224 */         if (TFCBiome.biomeList[array[x + z * xSize]] == null) {
/*     */           
/* 226 */           TerraFirmaCraft.LOG.error("Error Array garbage data: " + array[x + z * xSize]);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\GenLayerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */