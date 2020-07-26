/*     */ package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Stability;
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
/*     */ public abstract class GenStabilityLayer extends GenLayerTFC {
/*     */   public static GenLayerTFC initialize(long par0, WorldType par2WorldType) {
/*     */     GenLayerZoomTFC genLayerZoomTFC;
/*  20 */     GenLayerTFC continent = genContinent(par0);
/*  21 */     drawImage(512, continent, "Stability 0");
/*  22 */     continent = GenLayerZoomTFC.magnify(1000L, continent, 2);
/*  23 */     GenLayerSmoothTFC genLayerSmoothTFC1 = new GenLayerSmoothTFC(1000L, (GenLayer)continent);
/*  24 */     drawImage(512, (GenLayerTFC)genLayerSmoothTFC1, "Stability 1");
/*  25 */     for (int zoomLevel = 0; zoomLevel < 4; zoomLevel++) {
/*     */       
/*  27 */       genLayerZoomTFC = new GenLayerZoomTFC((1000 + zoomLevel), (GenLayerTFC)genLayerSmoothTFC1);
/*  28 */       drawImage(512, (GenLayerTFC)genLayerZoomTFC, "Stability 2-" + zoomLevel);
/*     */     } 
/*     */     
/*  31 */     GenLayerSmoothTFC finalCont = new GenLayerSmoothTFC(1000L, (GenLayer)genLayerZoomTFC);
/*  32 */     drawImage(512, (GenLayerTFC)finalCont, "Stability 3");
/*  33 */     GenLayerVoronoiZoomTFC voronoiZoom = new GenLayerVoronoiZoomTFC(10L, (GenLayer)finalCont);
/*  34 */     voronoiZoom.func_75905_a(par0);
/*  35 */     return (GenLayerTFC)voronoiZoom;
/*     */   }
/*     */   private static boolean shouldDraw;
/*     */   
/*     */   public static GenLayerTFC genContinent(long seed) {
/*  40 */     GenLayerTFC continent = new GenLayerStabilityInit(1L + seed);
/*  41 */     GenLayerFuzzyZoomTFC genLayerFuzzyZoomTFC = new GenLayerFuzzyZoomTFC(2000L, (GenLayer)continent);
/*     */     
/*  43 */     GenLayerZoomTFC genLayerZoomTFC = new GenLayerZoomTFC(2001L, (GenLayerTFC)genLayerFuzzyZoomTFC);
/*     */     
/*  45 */     genLayerZoomTFC = new GenLayerZoomTFC(2002L, (GenLayerTFC)genLayerZoomTFC);
/*     */     
/*  47 */     genLayerZoomTFC = new GenLayerZoomTFC(2003L, (GenLayerTFC)genLayerZoomTFC);
/*     */     
/*  49 */     return (GenLayerTFC)genLayerZoomTFC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawImage(int size, GenLayerTFC genlayer, String name) {
/*  55 */     if (!shouldDraw) {
/*     */       return;
/*     */     }
/*     */     try {
/*  59 */       File outFile = new File(name + ".bmp");
/*  60 */       if (outFile.exists())
/*     */         return; 
/*  62 */       int[] ints = genlayer.func_75904_a(0, 0, size, size);
/*  63 */       BufferedImage outBitmap = new BufferedImage(size, size, 1);
/*  64 */       Graphics2D graphics = (Graphics2D)outBitmap.getGraphics();
/*  65 */       graphics.clearRect(0, 0, size, size);
/*  66 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  67 */       for (int x = 0; x < size; x++) {
/*     */         
/*  69 */         for (int z = 0; z < size; z++) {
/*     */           
/*  71 */           int id = (DataLayer.layers[ints[x * size + z]]).data1;
/*  72 */           graphics.setColor(Color.getColor("", (id * 255 << 16) + (id * 255 << 8) + id * 255));
/*  73 */           graphics.drawRect(x, z, 1, 1);
/*     */         } 
/*     */       } 
/*  76 */       TerraFirmaCraft.LOG.info(name + ".bmp");
/*  77 */       ImageIO.write(outBitmap, "BMP", outFile);
/*     */     }
/*  79 */     catch (Exception e) {
/*     */       
/*  81 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GenStabilityLayer(long par1) {
/*  87 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75905_a(long par1) {
/*  97 */     this.field_75907_b = par1;
/*  98 */     if (this.field_75909_a != null) {
/*  99 */       this.field_75909_a.func_75905_a(par1);
/*     */     }
/* 101 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 102 */     this.field_75907_b += this.field_75906_d;
/* 103 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 104 */     this.field_75907_b += this.field_75906_d;
/* 105 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 106 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75903_a(long par1, long par3) {
/* 115 */     this.field_75908_c = this.field_75907_b;
/* 116 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 117 */     this.field_75908_c += par1;
/* 118 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 119 */     this.field_75908_c += par3;
/* 120 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 121 */     this.field_75908_c += par1;
/* 122 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 123 */     this.field_75908_c += par3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_75902_a(int par1) {
/* 132 */     int var2 = (int)((this.field_75908_c >> 24L) % par1);
/* 133 */     if (var2 < 0)
/* 134 */       var2 += par1; 
/* 135 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 136 */     this.field_75908_c += this.field_75907_b;
/* 137 */     return var2;
/*     */   }
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\DataLayers\Stability\GenStabilityLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */