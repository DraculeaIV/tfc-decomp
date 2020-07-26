/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rain;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerFuzzyZoomTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerSmoothTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerVoronoiZoomTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerZoomTFC;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ public abstract class GenRainLayerTFC extends GenLayerTFC {
/*  18 */   public static final int WET = DataLayer.RAIN_4000.layerID;
/*  19 */   public static final int DRY = DataLayer.RAIN_125.layerID; private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC initialize(long seed, WorldType worldType) {
/*     */     GenLayerZoomTFC genLayerZoomTFC;
/*  23 */     GenLayerTFC continent = genContinent(0L);
/*  24 */     drawImage(512, continent, "Rain 0");
/*  25 */     continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
/*  26 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)continent);
/*  27 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Rain 1");
/*  28 */     for (int zoomLevel = 0; zoomLevel < 4; zoomLevel++) {
/*     */       GenLayerRainMix genLayerRainMix;
/*  30 */       if ((zoomLevel & 0x1) == 1) {
/*     */         
/*  32 */         genLayerRainMix = new GenLayerRainMix((1000 + zoomLevel), (GenLayer)genLayerSmoothTFC1);
/*  33 */         drawImage(512, genLayerRainMix, "Rain 2-" + zoomLevel + " Mix");
/*     */       } 
/*  35 */       genLayerZoomTFC = new GenLayerZoomTFC((1000 + zoomLevel), genLayerRainMix);
/*  36 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC, "Rain 2-" + zoomLevel + " Smoothed");
/*     */     } 
/*     */     
/*  39 */     GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC);
/*  40 */     GenLayerVoronoiZoomTFC voronoiZoom = new GenLayerVoronoiZoomTFC(10L, (GenLayer)finalCont);
/*  41 */     drawImage(512, (GenLayerTFC)finalCont, "Rain 4 Voronoi Rain");
/*  42 */     voronoiZoom.func_75905_a(seed);
/*  43 */     return (GenLayerTFC)voronoiZoom;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed) {
/*  48 */     GenLayerTFC continent = new GenLayerRainInit(1L + seed);
/*  49 */     drawImage(512, continent, "Rain Init 0");
/*  50 */     continent = new GenLayerAddRain(1L, (GenLayer)continent);
/*  51 */     drawImage(512, continent, "Rain Init 0b Add Rain");
/*  52 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)continent);
/*  53 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Rain Init 1");
/*     */ 
/*     */     
/*  56 */     GenLayerZoomTFC genLayerZoomTFC3 = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerFuzzyZoomTFC);
/*  57 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC3, "Rain Init 3 Zoom");
/*     */ 
/*     */     
/*  60 */     GenLayerRainMix genLayerRainMix2 = new GenLayerRainMix(88L, (GenLayer)genLayerZoomTFC3);
/*  61 */     drawImage(512, genLayerRainMix2, "Rain Init 4b Mix");
/*  62 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, genLayerRainMix2);
/*  63 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rain Init 5 Zoom");
/*  64 */     GenLayerRainMix genLayerRainMix1 = new GenLayerRainMix(88L, (GenLayer)genLayerZoomTFC2);
/*  65 */     drawImage(512, genLayerRainMix1, "Rain Init 5b Mix");
/*     */ 
/*     */     
/*  68 */     GenLayerZoomTFC genLayerZoomTFC1 = new GenLayerZoomTFC(2003L, genLayerRainMix1);
/*  69 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Rain Init 7 Zoom");
/*  70 */     return (GenLayerTFC)genLayerZoomTFC1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  76 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  80 */       File outFile = new File(name + ".bmp");
/*  81 */       if (outFile.exists())
/*     */         return; 
/*  83 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  84 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  85 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  86 */       graphics.clearRect(0, 0, size, size);
/*  87 */       TerraFirmaCraft.LOG.info("Starting " + name + ".bmp");
/*  88 */       for (int x = 0; x < size; x++) {
/*     */         
/*  90 */         for (int z = 0; z < size; z++) {
/*     */           
/*  92 */           int value = ints[x * size + z];
/*  93 */           if (value - 100 >= 0) {
/*  94 */             graphics.setColor(Color.getColor("", (value - 100) * 32));
/*     */           } else {
/*  96 */             graphics.setColor(Color.getColor("", 16777215));
/*  97 */           }  graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/* 100 */       TerraFirmaCraft.LOG.info("Finished " + name + ".bmp");
/* 101 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 103 */     catch (Exception e) {
/*     */       
/* 105 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenRainLayerTFC(long par1) {
/* 111 */     super(par1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Rain\GenRainLayerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */