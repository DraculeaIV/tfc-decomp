/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Tree;
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
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ public abstract class GenTreeLayer extends GenLayerTFC {
/*     */   public static GenLayerTFC initialize(long par0, DataLayer[] trees) {
/*     */     GenLayerZoomTFC genLayerZoomTFC1;
/*  18 */     GenLayerTFC layer = new GenLayerTreeInit(1L, trees);
/*  19 */     drawImage(512, layer, "Tree 0");
/*  20 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)layer);
/*  21 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Tree 1");
/*     */     
/*  23 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Tree 2");
/*  24 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerFuzzyZoomTFC);
/*     */     
/*  26 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Tree 3");
/*  27 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  29 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Tree 4");
/*  30 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2003L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  32 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Tree 5");
/*  33 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC2);
/*  34 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Tree 6");
/*  35 */     for (int zoomLevel = 0; zoomLevel < 5; zoomLevel++) {
/*     */       
/*  37 */       genLayerZoomTFC1 = new GenLayerZoomTFC((1000 + zoomLevel), (GenLayerTFC)genLayerSmoothTFC1);
/*  38 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Tree " + (7 + zoomLevel));
/*     */     } 
/*     */     
/*  41 */     GenLayerSmoothTFC smoothedLayer = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC1);
/*  42 */     GenLayerVoronoiZoomTFC voronoiLayer = new GenLayerVoronoiZoomTFC(10L, (GenLayer)smoothedLayer);
/*  43 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Tree Final");
/*     */     
/*  45 */     voronoiLayer.func_75905_a(par0);
/*  46 */     return (GenLayerTFC)voronoiLayer;
/*     */   }
/*     */   
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  52 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  56 */       File outFile = new File(name + ".bmp");
/*  57 */       if (outFile.exists())
/*     */         return; 
/*  59 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  60 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  61 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  62 */       graphics.clearRect(0, 0, size, size);
/*  63 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  64 */       for (int x = 0; x < size; x++) {
/*     */         
/*  66 */         for (int z = 0; z < size; z++) {
/*     */           
/*  68 */           int id = ints[x * size + z];
/*  69 */           int color = (id * 8 << 16) + (id * 8 << 8) + id * 8;
/*  70 */           graphics.setColor(Color.getColor("", color));
/*  71 */           graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/*  74 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  75 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/*  77 */     catch (Exception e) {
/*     */       
/*  79 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenTreeLayer(long par1) {
/*  85 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/*  95 */     this.field_75907_b = par1;
/*  96 */     if (this.field_75909_a != null) {
/*  97 */       this.field_75909_a.func_75905_a(par1);
/*     */     }
/*  99 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 100 */     this.field_75907_b += this.field_75906_d;
/* 101 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 102 */     this.field_75907_b += this.field_75906_d;
/* 103 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 104 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75903_a(long par1, long par3) {
/* 113 */     this.field_75908_c = this.field_75907_b;
/* 114 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 115 */     this.field_75908_c += par1;
/* 116 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 117 */     this.field_75908_c += par3;
/* 118 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 119 */     this.field_75908_c += par1;
/* 120 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 121 */     this.field_75908_c += par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_75902_a(int par1) {
/* 130 */     int var2 = (int)((this.field_75908_c >> 24L) % par1);
/* 131 */     if (var2 < 0) {
/* 132 */       var2 += par1;
/*     */     }
/* 134 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 135 */     this.field_75908_c += this.field_75907_b;
/* 136 */     return var2;
/*     */   }
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Tree\GenTreeLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */