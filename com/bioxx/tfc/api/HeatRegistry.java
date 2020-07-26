/*     */ package com.bioxx.tfc.api;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeatRegistry
/*     */ {
/*  11 */   private static final HeatRegistry INSTANCE = new HeatRegistry();
/*     */   
/*     */   public static final HeatRegistry getInstance() {
/*  14 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<HeatIndex> heatList;
/*     */   
/*     */   private HeatRegistry() {
/*  21 */     this.heatList = new ArrayList<HeatIndex>();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addIndex(HeatIndex index) {
/*  26 */     this.heatList.add(index);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HeatIndex> getHeatList() {
/*  31 */     return this.heatList;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex findMatchingIndex(ItemStack input) {
/*  36 */     for (int k = 0; k < this.heatList.size(); k++) {
/*     */       
/*  38 */       HeatIndex tempIndex = this.heatList.get(k);
/*  39 */       if (tempIndex.matches(input))
/*     */       {
/*  41 */         return tempIndex;
/*     */       }
/*     */     } 
/*     */     
/*  45 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getIsLiquid(ItemStack is) {
/*  50 */     HeatIndex hi = INSTANCE.findMatchingIndex(is);
/*  51 */     if (hi != null && is.func_77942_o()) {
/*     */       
/*  53 */       float temp = 0.0F;
/*  54 */       if (is.func_77978_p().func_74764_b("temperature")) {
/*  55 */         temp = is.func_77978_p().func_74760_g("temperature");
/*     */       }
/*  57 */       return Boolean.valueOf((temp >= hi.meltTemp));
/*     */     } 
/*  59 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMeltingPoint(ItemStack is) {
/*  65 */     HeatIndex hi = findMatchingIndex(is);
/*  66 */     if (hi != null)
/*     */     {
/*  68 */       return hi.meltTemp;
/*     */     }
/*  70 */     return -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean isTemperatureWeldable(ItemStack is) {
/*  77 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/*  79 */       HeatIndex index = INSTANCE.findMatchingIndex(is);
/*  80 */       if (index != null) {
/*     */         
/*  82 */         float temp = TFC_ItemHeat.getTemp(is);
/*  83 */         return Boolean.valueOf((temp < index.meltTemp && temp > index.meltTemp * 0.8D));
/*     */       } 
/*     */     } 
/*  86 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isTemperatureWorkable(ItemStack is) {
/*  91 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/*  93 */       HeatIndex index = INSTANCE.findMatchingIndex(is);
/*  94 */       if (index != null) {
/*     */         
/*  96 */         float temp = TFC_ItemHeat.getTemp(is);
/*  97 */         return Boolean.valueOf((temp < index.meltTemp && temp > index.meltTemp * 0.6D));
/*     */       } 
/*     */     } 
/* 100 */     return Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean isTemperatureDanger(ItemStack is) {
/* 105 */     if (TFC_ItemHeat.hasTemp(is)) {
/*     */       
/* 107 */       HeatIndex index = INSTANCE.findMatchingIndex(is);
/* 108 */       if (index != null) {
/*     */         
/* 110 */         float temp = TFC_ItemHeat.getTemp(is);
/* 111 */         return Boolean.valueOf((temp < index.meltTemp && temp > index.meltTemp * 0.9D));
/*     */       } 
/*     */     } 
/* 114 */     return Boolean.valueOf(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\HeatRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */