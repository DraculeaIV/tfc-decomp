/*     */ package com.bioxx.tfc.WorldGen.Generators;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ 
/*     */ public class OreSpawnData
/*     */ {
/*     */   public int type;
/*     */   public int size;
/*  17 */   public int min = 5; public int meta; public int rarity; public int max = 128; public int vDensity;
/*     */   public int hDensity;
/*     */   public Block block;
/*     */   public Map<Block, List<Integer>> base;
/*     */   
/*     */   public OreSpawnData(String t, String s, String blockName, int m, int r, String[] baseRocks) {
/*  23 */     this.block = Block.func_149684_b(blockName);
/*     */     
/*  25 */     if (this.block == null) {
/*     */       
/*  27 */       TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + TFC_Core.translate("error.OreCFG") + " " + blockName);
/*  28 */       throw new NullPointerException(TFC_Core.translate("error.OreCFG") + " " + blockName);
/*     */     } 
/*     */     
/*  31 */     this.meta = m;
/*  32 */     this.rarity = r;
/*  33 */     if ("default".equals(t)) {
/*  34 */       this.type = 0;
/*     */     } else {
/*  36 */       this.type = 1;
/*     */     } 
/*  38 */     if ("small".equals(s)) {
/*  39 */       this.size = 0;
/*  40 */     } else if ("medium".equals(s)) {
/*  41 */       this.size = 1;
/*     */     } else {
/*  43 */       this.size = 2;
/*     */     } 
/*  45 */     this.base = new HashMap<Block, List<Integer>>();
/*  46 */     for (String name : baseRocks)
/*     */     {
/*  48 */       getOre(name);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public OreSpawnData(String t, String s, String blockName, int m, int r, String[] baseRocks, int minHeight, int maxHeight, int v, int h) {
/*  54 */     this(t, s, blockName, m, r, baseRocks);
/*  55 */     this.min = minHeight;
/*  56 */     this.max = maxHeight;
/*  57 */     this.vDensity = v;
/*  58 */     this.hDensity = h;
/*     */   }
/*     */   
/*     */   private void getOre(String name) {
/*     */     int i;
/*  63 */     for (i = 0; i < Global.STONE_IGIN.length; i++) {
/*  64 */       if (name.equalsIgnoreCase(Global.STONE_IGIN[i])) {
/*     */         
/*  66 */         List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneIgIn) ? this.base.get(TFCBlocks.stoneIgIn) : new ArrayList<Integer>();
/*  67 */         metadata.add(Integer.valueOf(i));
/*  68 */         this.base.put(TFCBlocks.stoneIgIn, metadata);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  73 */     for (i = 0; i < Global.STONE_IGEX.length; i++) {
/*     */       
/*  75 */       if (name.equalsIgnoreCase(Global.STONE_IGEX[i])) {
/*     */         
/*  77 */         List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneIgEx) ? this.base.get(TFCBlocks.stoneIgEx) : new ArrayList<Integer>();
/*  78 */         metadata.add(Integer.valueOf(i));
/*  79 */         this.base.put(TFCBlocks.stoneIgEx, metadata);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  84 */     for (i = 0; i < Global.STONE_SED.length; i++) {
/*     */       
/*  86 */       if (name.equalsIgnoreCase(Global.STONE_SED[i])) {
/*     */         
/*  88 */         List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneSed) ? this.base.get(TFCBlocks.stoneSed) : new ArrayList<Integer>();
/*  89 */         metadata.add(Integer.valueOf(i));
/*  90 */         this.base.put(TFCBlocks.stoneSed, metadata);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  95 */     for (i = 0; i < Global.STONE_MM.length; i++) {
/*     */       
/*  97 */       if (name.equalsIgnoreCase(Global.STONE_MM[i])) {
/*     */         
/*  99 */         List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneMM) ? this.base.get(TFCBlocks.stoneMM) : new ArrayList<Integer>();
/* 100 */         metadata.add(Integer.valueOf(i));
/* 101 */         this.base.put(TFCBlocks.stoneMM, metadata);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 106 */     if ("igneous intrusive".equalsIgnoreCase(name)) {
/*     */       
/* 108 */       List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneIgIn) ? this.base.get(TFCBlocks.stoneIgIn) : new ArrayList<Integer>();
/* 109 */       metadata.add(Integer.valueOf(-1));
/* 110 */       this.base.put(TFCBlocks.stoneIgIn, metadata);
/*     */       return;
/*     */     } 
/* 113 */     if ("igneous extrusive".equalsIgnoreCase(name)) {
/*     */       
/* 115 */       List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneIgEx) ? this.base.get(TFCBlocks.stoneIgEx) : new ArrayList<Integer>();
/* 116 */       metadata.add(Integer.valueOf(-1));
/* 117 */       this.base.put(TFCBlocks.stoneIgEx, metadata);
/*     */       return;
/*     */     } 
/* 120 */     if ("sedimentary".equalsIgnoreCase(name)) {
/*     */       
/* 122 */       List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneSed) ? this.base.get(TFCBlocks.stoneSed) : new ArrayList<Integer>();
/* 123 */       metadata.add(Integer.valueOf(-1));
/* 124 */       this.base.put(TFCBlocks.stoneSed, metadata);
/*     */       return;
/*     */     } 
/* 127 */     if ("metamorphic".equalsIgnoreCase(name)) {
/*     */       
/* 129 */       List<Integer> metadata = this.base.containsKey(TFCBlocks.stoneMM) ? this.base.get(TFCBlocks.stoneMM) : new ArrayList<Integer>();
/* 130 */       metadata.add(Integer.valueOf(-1));
/* 131 */       this.base.put(TFCBlocks.stoneMM, metadata);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\OreSpawnData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */