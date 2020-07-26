/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock;
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
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ 
/*     */ public abstract class GenRockLayer extends GenLayerTFC {
/*     */   public static GenLayerTFC initialize(long par0, DataLayer[] rocks) {
/*     */     GenLayerZoomTFC genLayerZoomTFC1;
/*  19 */     GenLayerTFC layer = new GenLayerRockInit(1L, rocks);
/*  20 */     drawImage(512, layer, "Rock 0");
/*  21 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)layer);
/*  22 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Rock 1");
/*     */     
/*  24 */     drawImage(512, (GenLayerTFC)genLayerFuzzyZoomTFC, "Rock 2");
/*  25 */     GenLayerZoomTFC genLayerZoomTFC2 = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerFuzzyZoomTFC);
/*     */     
/*  27 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 3");
/*  28 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2002L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  30 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 4");
/*  31 */     genLayerZoomTFC2 = new GenLayerZoomTFC(2003L, (GenLayerTFC)genLayerZoomTFC2);
/*     */     
/*  33 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC2, "Rock 5");
/*  34 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC2);
/*  35 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Rock 6");
/*  36 */     for (int zoomLevel = 0; zoomLevel < 5; zoomLevel++) {
/*     */       
/*  38 */       genLayerZoomTFC1 = new GenLayerZoomTFC((1000 + zoomLevel), (GenLayerTFC)genLayerSmoothTFC1);
/*  39 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Rock " + (7 + zoomLevel));
/*     */     } 
/*     */     
/*  42 */     GenLayerSmoothTFC smoothedLayer = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC1);
/*  43 */     GenLayerVoronoiZoomTFC voronoiLayer = new GenLayerVoronoiZoomTFC(10L, (GenLayer)smoothedLayer);
/*  44 */     drawImage(512, (GenLayerTFC)genLayerZoomTFC1, "Rock Final");
/*  45 */     smoothedLayer.func_75905_a(par0);
/*  46 */     voronoiLayer.func_75905_a(par0);
/*  47 */     return (GenLayerTFC)voronoiLayer;
/*     */   }
/*     */   
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  53 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  57 */       File outFile = new File(name + ".bmp");
/*  58 */       if (outFile.exists())
/*     */         return; 
/*  60 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  61 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  62 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  63 */       graphics.clearRect(0, 0, size, size);
/*  64 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  65 */       for (int x = 0; x < size; x++) {
/*     */         
/*  67 */         for (int z = 0; z < size; z++) {
/*     */           
/*  69 */           int id = ints[x * size + z];
/*  70 */           int color = (id * 8 << 16) + (id * 8 << 8) + id * 8;
/*  71 */           graphics.setColor(Color.getColor("", color));
/*  72 */           graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/*  75 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  76 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/*  78 */     catch (Exception e) {
/*     */       
/*  80 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenRockLayer(long par1) {
/*  86 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/*  96 */     this.field_75907_b = par1;
/*  97 */     if (this.field_75909_a != null) {
/*  98 */       this.field_75909_a.func_75905_a(par1);
/*     */     }
/* 100 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 101 */     this.field_75907_b += this.field_75906_d;
/* 102 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 103 */     this.field_75907_b += this.field_75906_d;
/* 104 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 105 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75903_a(long par1, long par3) {
/* 114 */     this.field_75908_c = this.field_75907_b;
/* 115 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 116 */     this.field_75908_c += par1;
/* 117 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 118 */     this.field_75908_c += par3;
/* 119 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 120 */     this.field_75908_c += par1;
/* 121 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 122 */     this.field_75908_c += par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_75902_a(int par1) {
/* 131 */     int var2 = (int)((this.field_75908_c >> 24L) % par1);
/* 132 */     if (var2 < 0) {
/* 133 */       var2 += par1;
/*     */     }
/* 135 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 136 */     this.field_75908_c += this.field_75907_b;
/* 137 */     return var2;
/*     */   }
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Rock\GenRockLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */