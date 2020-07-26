/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.EVT;
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
/*     */ public abstract class GenEVTLayer extends GenLayerTFC {
/*  18 */   public static final int LOW = DataLayer.EVT_0_25.layerID;
/*  19 */   public static final int HIGH = DataLayer.EVT_8.layerID; private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC initialize(long seed, WorldType worldType) {
/*     */     GenLayerZoomTFC genLayerZoomTFC;
/*  23 */     GenLayerTFC continent = genContinent(0L);
/*  24 */     drawImage(512, continent, "EVT 0");
/*  25 */     continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
/*  26 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)continent);
/*  27 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "EVT 1");
/*  28 */     for (int zoomLevel = 0; zoomLevel < 4; zoomLevel++) {
/*     */       GenLayerEVTMix genLayerEVTMix;
/*  30 */       if (zoomLevel == 0) {
/*     */         
/*  32 */         genLayerEVTMix = new GenLayerEVTMix((1000 + zoomLevel), (GenLayer)genLayerSmoothTFC1);
/*  33 */         drawImage(512, genLayerEVTMix, "EVT 2-" + zoomLevel + " Mix");
/*     */       } 
/*  35 */       genLayerZoomTFC = new GenLayerZoomTFC((1000 + zoomLevel), genLayerEVTMix);
/*  36 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC, "EVT 2-" + zoomLevel + " Smoothed");
/*     */     } 
/*     */     
/*  39 */     GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC);
/*  40 */     GenLayerVoronoiZoomTFC genLayerVoronoiZoomTFC = new GenLayerVoronoiZoomTFC(10L, (GenLayer)finalCont);
/*  41 */     drawImage(512, (GenLayerTFC)genLayerVoronoiZoomTFC, "EVT 4 Voronoi EVT");
/*  42 */     genLayerVoronoiZoomTFC.func_75905_a(seed);
/*  43 */     return (GenLayerTFC)genLayerVoronoiZoomTFC;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed) {
/*  48 */     GenLayerTFC continent = new GenLayerEVTInit(1L + seed);
/*  49 */     drawImage(512, continent, "EVT Init 0");
/*  50 */     continent = new GenLayerAddEVT(1L, (GenLayer)continent);
/*  51 */     drawImage(512, continent, "EVT Init 0b Add EVT");
/*  52 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)continent);
/*  53 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "EVT Init 1");
/*  54 */     GenLayerAddEVT genLayerAddEVT4 = new GenLayerAddEVT(1L, (GenLayer)genLayerFuzzyZoomTFC);
/*  55 */     drawImage(512, genLayerAddEVT4, "EVT Init 2 Add EVT");
/*  56 */     GenLayerZoomTFC genLayerZoomTFC3 = new GenLayerZoomTFC(2001L, genLayerAddEVT4);
/*  57 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC3, "EVT Init 3 Zoom");
/*  58 */     GenLayerAddEVT genLayerAddEVT3 = new GenLayerAddEVT(2L, (GenLayer)genLayerZoomTFC3);
/*  59 */     drawImage(512, genLayerAddEVT3, "EVT Init 4 Add EVT");
/*  60 */     GenLayerEVTMix genLayerEVTMix = new GenLayerEVTMix(88L, (GenLayer)genLayerAddEVT3);
/*  61 */     drawImage(512, genLayerEVTMix, "EVT Init 4b Mix");
/*  62 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, genLayerEVTMix);
/*  63 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "EVT Init 5 Zoom");
/*  64 */     GenLayerAddEVT genLayerAddEVT2 = new GenLayerAddEVT(3L, (GenLayer)genLayerZoomTFC2);
/*  65 */     drawImage(512, genLayerAddEVT2, "EVT Init 6 Add EVT");
/*  66 */     GenLayerZoomTFC genLayerZoomTFC1 = new GenLayerZoomTFC(2003L, genLayerAddEVT2);
/*  67 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "EVT Init 7 Zoom");
/*  68 */     GenLayerAddEVT genLayerAddEVT1 = new GenLayerAddEVT(4L, (GenLayer)genLayerZoomTFC1);
/*  69 */     drawImage(512, genLayerAddEVT1, "EVT Init 8 Add EVT");
/*  70 */     return genLayerAddEVT1;
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
/*  93 */           if (value - 80 >= 0 && value - 80 <= 7) {
/*  94 */             graphics.setColor(Color.getColor("", (value - 80) * 32 << 16));
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
/*     */   public GenEVTLayer(long par1) {
/* 111 */     super(par1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\EVT\GenEVTLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */