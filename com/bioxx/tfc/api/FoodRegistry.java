/*     */ package com.bioxx.tfc.api;
/*     */ 
/*     */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FoodRegistry
/*     */ {
/*  12 */   private static final FoodRegistry INSTANCE = new FoodRegistry();
/*     */   
/*     */   public static final FoodRegistry getInstance() {
/*  15 */     return INSTANCE;
/*     */   }
/*     */   
/*     */   private int proteinCount;
/*     */   private Map<Integer, Item> proteinMap;
/*  20 */   private int vegetableCount = 10000;
/*     */   private Map<Integer, Item> vegetableMap;
/*  22 */   private int fruitCount = 20000;
/*     */   private Map<Integer, Item> fruitMap;
/*  24 */   private int grainCount = 30000;
/*     */   private Map<Integer, Item> grainMap;
/*  26 */   private int dairyCount = 40000;
/*     */   
/*     */   private Map<Integer, Item> dairyMap;
/*     */   
/*     */   private FoodRegistry() {
/*  31 */     this.proteinMap = new HashMap<Integer, Item>();
/*  32 */     this.vegetableMap = new HashMap<Integer, Item>();
/*  33 */     this.fruitMap = new HashMap<Integer, Item>();
/*  34 */     this.grainMap = new HashMap<Integer, Item>();
/*  35 */     this.dairyMap = new HashMap<Integer, Item>();
/*     */   }
/*     */ 
/*     */   
/*     */   public int registerFood(EnumFoodGroup efg, Item i) {
/*  40 */     switch (efg) {
/*     */ 
/*     */       
/*     */       case Protein:
/*  44 */         this.proteinMap.put(Integer.valueOf(this.proteinCount), i);
/*  45 */         return this.proteinCount++;
/*     */ 
/*     */       
/*     */       case Vegetable:
/*  49 */         this.vegetableMap.put(Integer.valueOf(this.vegetableCount), i);
/*  50 */         return this.vegetableCount++;
/*     */ 
/*     */       
/*     */       case Fruit:
/*  54 */         this.fruitMap.put(Integer.valueOf(this.fruitCount), i);
/*  55 */         return this.fruitCount++;
/*     */ 
/*     */       
/*     */       case Grain:
/*  59 */         this.grainMap.put(Integer.valueOf(this.grainCount), i);
/*  60 */         return this.grainCount++;
/*     */ 
/*     */       
/*     */       case Dairy:
/*  64 */         this.dairyMap.put(Integer.valueOf(this.dairyCount), i);
/*  65 */         return this.dairyCount++;
/*     */     } 
/*     */ 
/*     */     
/*  69 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getFood(int id) {
/*  76 */     if (this.proteinMap.containsKey(Integer.valueOf(id)))
/*  77 */       return this.proteinMap.get(Integer.valueOf(id)); 
/*  78 */     if (this.vegetableMap.containsKey(Integer.valueOf(id)))
/*  79 */       return this.vegetableMap.get(Integer.valueOf(id)); 
/*  80 */     if (this.fruitMap.containsKey(Integer.valueOf(id)))
/*  81 */       return this.fruitMap.get(Integer.valueOf(id)); 
/*  82 */     if (this.grainMap.containsKey(Integer.valueOf(id)))
/*  83 */       return this.grainMap.get(Integer.valueOf(id)); 
/*  84 */     if (this.dairyMap.containsKey(Integer.valueOf(id)))
/*  85 */       return this.dairyMap.get(Integer.valueOf(id)); 
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumFoodGroup getFoodGroup(int id) {
/*  91 */     if (this.proteinMap.containsKey(Integer.valueOf(id)))
/*  92 */       return EnumFoodGroup.Protein; 
/*  93 */     if (this.vegetableMap.containsKey(Integer.valueOf(id)))
/*  94 */       return EnumFoodGroup.Vegetable; 
/*  95 */     if (this.fruitMap.containsKey(Integer.valueOf(id)))
/*  96 */       return EnumFoodGroup.Fruit; 
/*  97 */     if (this.grainMap.containsKey(Integer.valueOf(id)))
/*  98 */       return EnumFoodGroup.Grain; 
/*  99 */     if (this.dairyMap.containsKey(Integer.valueOf(id)))
/* 100 */       return EnumFoodGroup.Dairy; 
/* 101 */     return EnumFoodGroup.None;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\FoodRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */