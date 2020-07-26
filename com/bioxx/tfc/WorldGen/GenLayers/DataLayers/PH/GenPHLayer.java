/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.PH;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerFuzzyZoomTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerSmoothTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerZoomTFC;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ 
/*     */ public abstract class GenPHLayer
/*     */   extends GenLayerTFC
/*     */ {
/*  21 */   public static final int MIN = DataLayer.PH_ACID_HIGH.layerID;
/*  22 */   public static final int MAX = DataLayer.PH_ALKALINE_HIGH.layerID;
/*     */   public static GenLayerTFC initialize(long seed, WorldType worldType) {
/*     */     GenLayerZoomTFC genLayerZoomTFC;
/*  25 */     GenLayerTFC continent = genContinent(0L);
/*  26 */     drawImage(512, continent, "PH 0");
/*  27 */     continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
/*  28 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)continent);
/*  29 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "PH 1");
/*  30 */     for (int zoomLevel = 0; zoomLevel < 2; zoomLevel++) {
/*     */       GenLayerPHMix genLayerPHMix;
/*  32 */       if (zoomLevel == 0) {
/*     */         
/*  34 */         genLayerPHMix = new GenLayerPHMix((1000 + zoomLevel), (GenLayer)genLayerSmoothTFC1);
/*  35 */         drawImage(512, genLayerPHMix, "PH 2-" + zoomLevel + " Mix");
/*     */       } 
/*  37 */       genLayerZoomTFC = new GenLayerZoomTFC((1000 + zoomLevel), genLayerPHMix);
/*  38 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC, "PH 2-" + zoomLevel + " Smoothed");
/*     */     } 
/*     */     
/*  41 */     GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC);
/*     */     
/*  43 */     drawImage(512, (GenLayerTFC)finalCont, "PH Final");
/*  44 */     finalCont.func_75905_a(seed);
/*  45 */     return (GenLayerTFC)finalCont;
/*     */   }
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed) {
/*  50 */     GenLayerTFC continent = new GenLayerPHInit(1L + seed);
/*  51 */     drawImage(512, continent, "PH Init 0");
/*  52 */     continent = new GenLayerAddPH(1L, (GenLayer)continent);
/*  53 */     drawImage(512, continent, "PH Init 0b Add PH");
/*  54 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)continent);
/*  55 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "PH Init 1");
/*  56 */     GenLayerAddPH genLayerAddPH4 = new GenLayerAddPH(1L, (GenLayer)genLayerFuzzyZoomTFC);
/*  57 */     drawImage(512, genLayerAddPH4, "PH Init 2 Add PH");
/*  58 */     GenLayerZoomTFC genLayerZoomTFC3 = new GenLayerZoomTFC(2001L, genLayerAddPH4);
/*  59 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC3, "PH Init 3 Zoom");
/*  60 */     GenLayerAddPH genLayerAddPH3 = new GenLayerAddPH(2L, (GenLayer)genLayerZoomTFC3);
/*  61 */     drawImage(512, genLayerAddPH3, "PH Init 4 Add PH");
/*  62 */     GenLayerPHMix genLayerPHMix = new GenLayerPHMix(88L, (GenLayer)genLayerAddPH3);
/*  63 */     drawImage(512, genLayerPHMix, "PH Init 4b Mix");
/*  64 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, genLayerPHMix);
/*  65 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "PH Init 5 Zoom");
/*  66 */     GenLayerAddPH genLayerAddPH2 = new GenLayerAddPH(3L, (GenLayer)genLayerZoomTFC2);
/*  67 */     drawImage(512, genLayerAddPH2, "PH Init 6 Add PH");
/*  68 */     GenLayerZoomTFC genLayerZoomTFC1 = new GenLayerZoomTFC(2003L, genLayerAddPH2);
/*  69 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "PH Init 7 Zoom");
/*  70 */     GenLayerAddPH genLayerAddPH1 = new GenLayerAddPH(4L, (GenLayer)genLayerZoomTFC1);
/*  71 */     drawImage(512, genLayerAddPH1, "PH Init 8 Add PH");
/*  72 */     return genLayerAddPH1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  78 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  82 */       File outFile = new File(name + ".bmp");
/*  83 */       if (outFile.exists())
/*     */         return; 
/*  85 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  86 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  87 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  88 */       graphics.clearRect(0, 0, size, size);
/*  89 */       TerraFirmaCraft.LOG.info("Starting " + name + ".bmp");
/*  90 */       for (int x = 0; x < size; x++) {
/*     */         
/*  92 */         for (int z = 0; z < size; z++) {
/*     */           
/*  94 */           int value = ints[x * size + z];
/*  95 */           if (value - 130 >= 0 && value - 130 <= 4) {
/*  96 */             graphics.setColor(Color.getColor("", (value - 130) * 32 << 8));
/*     */           } else {
/*  98 */             graphics.setColor(Color.getColor("", 16777215));
/*  99 */           }  graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/* 102 */       TerraFirmaCraft.LOG.info("Finished " + name + ".bmp");
/* 103 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 105 */     catch (Exception e) {
/*     */       
/* 107 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenPHLayer(long par1) {
/* 113 */     super(par1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\PH\GenPHLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */