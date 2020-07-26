/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Drainage;
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
/*     */ public abstract class GenDrainageLayer
/*     */   extends GenLayerTFC
/*     */ {
/*  21 */   public static final int MIN = DataLayer.DRAINAGE_NONE.layerID;
/*  22 */   public static final int MAX = DataLayer.DRAINAGE_VERY_GOOD.layerID;
/*     */   public static GenLayerTFC initialize(long seed, WorldType worldType) {
/*     */     GenLayerZoomTFC genLayerZoomTFC;
/*  25 */     GenLayerTFC continent = genContinent(0L);
/*  26 */     drawImage(512, continent, "Drainage 0");
/*  27 */     continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
/*  28 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)continent);
/*  29 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Drainage 1");
/*  30 */     for (int zoomLevel = 0; zoomLevel < 2; zoomLevel++) {
/*     */       GenLayerDrainageMix genLayerDrainageMix;
/*  32 */       if (zoomLevel == 0) {
/*     */         
/*  34 */         genLayerDrainageMix = new GenLayerDrainageMix((1000 + zoomLevel), (GenLayer)genLayerSmoothTFC1);
/*  35 */         drawImage(512, genLayerDrainageMix, "Drainage 2-" + zoomLevel + " Mix");
/*     */       } 
/*  37 */       genLayerZoomTFC = new GenLayerZoomTFC((1000 + zoomLevel), genLayerDrainageMix);
/*  38 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC, "Drainage 2-" + zoomLevel + " Smoothed");
/*     */     } 
/*     */     
/*  41 */     GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC);
/*     */     
/*  43 */     drawImage(512, (GenLayerTFC)finalCont, "Drainage Final");
/*  44 */     finalCont.func_75905_a(seed);
/*  45 */     return (GenLayerTFC)finalCont;
/*     */   }
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed) {
/*  50 */     GenLayerTFC continent = new GenLayerDrainageInit(1L + seed);
/*  51 */     drawImage(512, continent, "Drainage Init 0");
/*  52 */     continent = new GenLayerAddDrainage(1L, (GenLayer)continent);
/*  53 */     drawImage(512, continent, "Drainage Init 0b Add Drainage");
/*  54 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)continent);
/*  55 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Drainage Init 1");
/*  56 */     GenLayerAddDrainage genLayerAddDrainage4 = new GenLayerAddDrainage(1L, (GenLayer)genLayerFuzzyZoomTFC);
/*  57 */     drawImage(512, genLayerAddDrainage4, "Drainage Init 2 Add Drainage");
/*  58 */     GenLayerZoomTFC genLayerZoomTFC3 = new GenLayerZoomTFC(2001L, genLayerAddDrainage4);
/*  59 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC3, "Drainage Init 3 Zoom");
/*  60 */     GenLayerAddDrainage genLayerAddDrainage3 = new GenLayerAddDrainage(2L, (GenLayer)genLayerZoomTFC3);
/*  61 */     drawImage(512, genLayerAddDrainage3, "Drainage Init 4 Add Drainage");
/*  62 */     GenLayerDrainageMix genLayerDrainageMix = new GenLayerDrainageMix(88L, (GenLayer)genLayerAddDrainage3);
/*  63 */     drawImage(512, genLayerDrainageMix, "Drainage Init 4b Mix");
/*  64 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, genLayerDrainageMix);
/*  65 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Drainage Init 5 Zoom");
/*  66 */     GenLayerAddDrainage genLayerAddDrainage2 = new GenLayerAddDrainage(3L, (GenLayer)genLayerZoomTFC2);
/*  67 */     drawImage(512, genLayerAddDrainage2, "Drainage Init 6 Add Drainage");
/*  68 */     GenLayerZoomTFC genLayerZoomTFC1 = new GenLayerZoomTFC(2003L, genLayerAddDrainage2);
/*  69 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Drainage Init 7 Zoom");
/*  70 */     GenLayerAddDrainage genLayerAddDrainage1 = new GenLayerAddDrainage(4L, (GenLayer)genLayerZoomTFC1);
/*  71 */     drawImage(512, genLayerAddDrainage1, "Drainage Init 8 Add Drainage");
/*  72 */     return genLayerAddDrainage1;
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
/*  87 */       Graphics2D graDrainageics = (Graphics2D)outBitmap.getGraphics();
/*  88 */       graDrainageics.clearRect(0, 0, size, size);
/*  89 */       TerraFirmaCraft.LOG.info("Starting " + name + ".bmp");
/*  90 */       for (int x = 0; x < size; x++) {
/*     */         
/*  92 */         for (int z = 0; z < size; z++) {
/*     */           
/*  94 */           int value = ints[x * size + z];
/*  95 */           int r = (value - 120) * 42 / 2 << 16;
/*  96 */           int g = (value - 120) * 42 / 4 << 8;
/*  97 */           if (value - 120 >= 0 && value - 120 <= 5) {
/*  98 */             graDrainageics.setColor(Color.getColor("", r + g));
/*     */           } else {
/* 100 */             graDrainageics.setColor(Color.getColor("", 16777215));
/* 101 */           }  graDrainageics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/* 104 */       TerraFirmaCraft.LOG.info("Finished " + name + ".bmp");
/* 105 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/* 107 */     catch (Exception e) {
/*     */       
/* 109 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenDrainageLayer(long par1) {
/* 115 */     super(par1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Drainage\GenDrainageLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */