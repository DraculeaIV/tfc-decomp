/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerFuzzyZoomTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerSmoothTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerVoronoiZoomTFC;
/*     */ import com.bioxx.tfc.WorldGen.GenLayers.GenLayerZoomTFC;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ public abstract class GenRockLayer extends GenLayerTFC {
/*     */   public static GenLayerTFC initialize(long par0, DataLayer[] rocks) {
/*     */     GenLayerZoomTFC genLayerZoomTFC1;
/*     */     int maxzoom;
/*  21 */     GenLayerTFC layer = new GenLayerRockInit(1L, rocks);
/*  22 */     drawImage(512, layer, "Rock 0");
/*  23 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)layer);
/*  24 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Rock 1");
/*     */     
/*  26 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Rock 2");
/*  27 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerFuzzyZoomTFC);
/*     */     
/*  29 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 3");
/*  30 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  32 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 4");
/*  33 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2003L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  35 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 5");
/*  36 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC2);
/*  37 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Rock 6");
/*     */ 
/*     */     
/*  40 */     if (TFCOptions.enableSmallerBiome) {
/*  41 */       maxzoom = 4;
/*     */     } else {
/*  43 */       maxzoom = 5;
/*     */     } 
/*     */     
/*  46 */     for (int zoomLevel = 0; zoomLevel < maxzoom; zoomLevel++) {
/*     */       
/*  48 */       genLayerZoomTFC1 = new GenLayerZoomTFC((1000 + zoomLevel), (GenLayerTFC)genLayerSmoothTFC1);
/*  49 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Rock " + (7 + zoomLevel));
/*     */     } 
/*     */     
/*  52 */     GenLayerSmoothTFC smoothedLayer = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC1);
/*  53 */     GenLayerVoronoiZoomTFC voronoiLayer = new GenLayerVoronoiZoomTFC(10L, (GenLayer)smoothedLayer);
/*  54 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Rock Final");
/*  55 */     smoothedLayer.func_75905_a(par0);
/*  56 */     voronoiLayer.func_75905_a(par0);
/*  57 */     return (GenLayerTFC)voronoiLayer;
/*     */   }
/*     */   
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  63 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  67 */       File outFile = new File(name + ".bmp");
/*  68 */       if (outFile.exists())
/*     */         return; 
/*  70 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  71 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  72 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  73 */       graphics.clearRect(0, 0, size, size);
/*  74 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  75 */       for (int x = 0; x < size; x++) {
/*     */         
/*  77 */         for (int z = 0; z < size; z++) {
/*     */           
/*  79 */           int id = ints[x * size + z];
/*  80 */           int color = (id * 8 << 16) + (id * 8 << 8) + id * 8;
/*  81 */           graphics.setColor(Color.getColor("", color));
/*  82 */           graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/*  85 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  86 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/*  88 */     catch (Exception e) {
/*     */       
/*  90 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenRockLayer(long par1) {
/*  96 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/* 106 */     this.field_75907_b = par1;
/* 107 */     if (this.field_75909_a != null) {
/* 108 */       this.field_75909_a.func_75905_a(par1);
/*     */     }
/* 110 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 111 */     this.field_75907_b += this.field_75906_d;
/* 112 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 113 */     this.field_75907_b += this.field_75906_d;
/* 114 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 115 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75903_a(long par1, long par3) {
/* 124 */     this.field_75908_c = this.field_75907_b;
/* 125 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 126 */     this.field_75908_c += par1;
/* 127 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 128 */     this.field_75908_c += par3;
/* 129 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 130 */     this.field_75908_c += par1;
/* 131 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 132 */     this.field_75908_c += par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_75902_a(int par1) {
/* 141 */     int var2 = (int)((this.field_75908_c >> 24L) % par1);
/* 142 */     if (var2 < 0) {
/* 143 */       var2 += par1;
/*     */     }
/* 145 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 146 */     this.field_75908_c += this.field_75907_b;
/* 147 */     return var2;
/*     */   }
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Rock\GenRockLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */