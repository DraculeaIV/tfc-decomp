/*     */ package com.bioxx.tfc.WorldGen.GenLayers;
/*     */ 
/*     */ 
/*     */ public class GenLayerZoomTFC
/*     */   extends GenLayerTFC
/*     */ {
/*     */   public GenLayerZoomTFC(long seed, GenLayerTFC par3GenLayer) {
/*   8 */     super(seed);
/*   9 */     this.field_75909_a = par3GenLayer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] func_75904_a(int xPos, int zPos, int xSize, int zSize) {
/*  19 */     int xCoord = xPos >> 1;
/*  20 */     int zCoord = zPos >> 1;
/*  21 */     int newXSize = (xSize >> 1) + 2;
/*  22 */     int newZSize = (zSize >> 1) + 2;
/*  23 */     int[] parentCache = this.field_75909_a.func_75904_a(xCoord, zCoord, newXSize, newZSize);
/*  24 */     int i2 = newXSize - 1 << 1;
/*  25 */     int j2 = newZSize - 1 << 1;
/*  26 */     int[] out = new int[i2 * j2];
/*     */ 
/*     */     
/*  29 */     for (int z = 0; z < newZSize - 1; z++) {
/*     */       
/*  31 */       int l2 = (z << 1) * i2;
/*  32 */       int i3 = 0;
/*  33 */       int thisID = parentCache[i3 + 0 + (z + 0) * newXSize];
/*     */       
/*  35 */       for (int x = parentCache[i3 + 0 + (z + 1) * newXSize]; i3 < newXSize - 1; i3++) {
/*     */         
/*  37 */         func_75903_a((i3 + xCoord << 1), (z + zCoord << 1));
/*  38 */         int rightID = parentCache[i3 + 1 + (z + 0) * newXSize];
/*  39 */         int upRightID = parentCache[i3 + 1 + (z + 1) * newXSize];
/*  40 */         out[l2] = thisID;
/*  41 */         out[l2++ + i2] = func_151619_a(new int[] { thisID, x });
/*  42 */         out[l2] = func_151619_a(new int[] { thisID, rightID });
/*  43 */         out[l2++ + i2] = func_151617_b(thisID, rightID, x, upRightID);
/*  44 */         thisID = rightID;
/*  45 */         x = upRightID;
/*     */       } 
/*     */     } 
/*     */     
/*  49 */     int[] outCache = new int[xSize * zSize];
/*     */     
/*  51 */     for (int zoom = 0; zoom < zSize; zoom++) {
/*     */       
/*  53 */       int srcPos = (zoom + (zPos & 0x1)) * i2 + (xPos & 0x1);
/*  54 */       System.arraycopy(out, srcPos, outCache, zoom * xSize, xSize);
/*     */     } 
/*     */     
/*  57 */     return outCache;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int choose(int par1, int par2) {
/*  65 */     return (func_75902_a(2) == 0) ? par1 : par2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int choose4(int id0, int id1, int id2, int id3) {
/*  70 */     if (id1 == id2 && id2 == id3)
/*  71 */       return id1; 
/*  72 */     if (id0 == id1 && id0 == id2)
/*  73 */       return id0; 
/*  74 */     if (id0 == id1 && id0 == id3)
/*  75 */       return id0; 
/*  76 */     if (id0 == id2 && id0 == id3)
/*  77 */       return id0; 
/*  78 */     if (id0 == id1 && id2 != id3)
/*  79 */       return id0; 
/*  80 */     if (id0 == id2 && id1 != id3)
/*  81 */       return id0; 
/*  82 */     if (id0 == id3 && id1 != id2)
/*  83 */       return id0; 
/*  84 */     if (id1 == id0 && id2 != id3)
/*  85 */       return id1; 
/*  86 */     if (id1 == id2 && id0 != id3)
/*  87 */       return id1; 
/*  88 */     if (id1 == id3 && id0 != id2)
/*  89 */       return id1; 
/*  90 */     if (id2 == id0 && id1 != id3)
/*  91 */       return id2; 
/*  92 */     if (id2 == id1 && id0 != id3)
/*  93 */       return id2; 
/*  94 */     if (id2 == id3 && id0 != id1)
/*  95 */       return id2; 
/*  96 */     if (id3 == id0 && id1 != id2)
/*  97 */       return id2; 
/*  98 */     if (id3 == id1 && id0 != id2)
/*  99 */       return id2; 
/* 100 */     if (id3 == id2 && id0 != id1) {
/* 101 */       return id2;
/*     */     }
/*     */     
/* 104 */     int rand = func_75902_a(4);
/* 105 */     return (rand == 0) ? id0 : ((rand == 1) ? id1 : ((rand == 2) ? id2 : id3));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GenLayerTFC magnify(long par0, GenLayerTFC par2GenLayer, int par3) {
/* 111 */     Object var4 = par2GenLayer;
/* 112 */     for (int var5 = 0; var5 < par3; var5++)
/* 113 */       var4 = new GenLayerZoomTFC(par0 + var5, (GenLayerTFC)var4); 
/* 114 */     return (GenLayerTFC)var4;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\GenLayers\GenLayerZoomTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */