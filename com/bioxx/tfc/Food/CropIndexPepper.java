/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TECrop;
/*    */ import java.util.Random;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CropIndexPepper
/*    */   extends CropIndex
/*    */ {
/*    */   public CropIndexPepper(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, Item seed) {
/* 14 */     super(id, name, type, growth, stages, minGTemp, minATemp, seed);
/*    */   }
/*    */   
/*    */   public CropIndexPepper(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, float nutrientUsageMultiplier, Item seed) {
/* 18 */     super(id, name, type, growth, stages, minGTemp, minATemp, seed);
/* 19 */     this.nutrientUsageMult = nutrientUsageMultiplier;
/*    */   }
/*    */   
/*    */   public CropIndexPepper(int id, String name, int type, int growth, int stages, float minGTemp, float minATemp, float nutrientUsageMultiplier, Item seed, int[] nutriRestore) {
/* 23 */     super(id, name, type, growth, stages, minGTemp, minATemp, seed);
/* 24 */     this.nutrientExtraRestore = (int[])nutriRestore.clone();
/* 25 */     this.nutrientUsageMult = nutrientUsageMultiplier;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack getOutput1(TECrop crop) {
/* 31 */     if (this.output1 != null && crop.growth >= 5.0F && crop.growth < 6.0F) {
/*    */       
/* 33 */       ItemStack is = new ItemStack(this.output1);
/* 34 */       Random r = new Random();
/* 35 */       if (r.nextInt(100) < this.chanceForOutput1) {
/*    */         
/* 37 */         ItemFoodTFC.createTag(is, getWeight(this.output1Avg, r));
/* 38 */         return is;
/*    */       } 
/*    */     } 
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getOutput2(TECrop crop) {
/* 46 */     if (this.output2 != null && crop.growth >= 6.0F) {
/*    */       
/* 48 */       ItemStack is = new ItemStack(this.output2);
/* 49 */       Random r = new Random();
/* 50 */       if (r.nextInt(100) < this.chanceForOutput2) {
/*    */         
/* 52 */         ItemFoodTFC.createTag(is, getWeight(this.output2Avg, r));
/* 53 */         return is;
/*    */       } 
/*    */     } 
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\CropIndexPepper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */