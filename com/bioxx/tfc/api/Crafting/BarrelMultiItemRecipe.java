/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import java.util.Stack;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ import net.minecraftforge.oredict.OreDictionary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BarrelMultiItemRecipe
/*    */   extends BarrelRecipe
/*    */ {
/*    */   public boolean keepstacksize = true;
/*    */   
/*    */   public BarrelMultiItemRecipe(ItemStack inputItem, FluidStack inputFluid, ItemStack outIS, FluidStack outputFluid) {
/* 18 */     super(inputItem, inputFluid, outIS, outputFluid);
/*    */   }
/*    */ 
/*    */   
/*    */   public BarrelMultiItemRecipe setKeepStackSize(boolean b) {
/* 23 */     this.keepstacksize = b;
/* 24 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Stack<ItemStack> getResult(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 30 */     ItemStack out = this.recipeOutIS.func_77946_l();
/* 31 */     if (inIS != null && inIS.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*    */       
/* 33 */       int w = (int)Math.floor(Food.getWeight(inIS));
/* 34 */       if (w * this.recipeOutFluid.amount <= inFS.amount)
/*    */       {
/* 36 */         Food.setWeight(out, w * Food.getWeight(this.recipeOutIS));
/*    */       }
/*    */     }
/* 39 */     else if (inIS != null) {
/*    */       
/* 41 */       if (this.keepstacksize) {
/* 42 */         out.field_77994_a = inIS.field_77994_a;
/*    */       } else {
/* 44 */         out.field_77994_a *= inIS.field_77994_a;
/*    */       } 
/*    */     } 
/* 47 */     Stack<ItemStack> result = new Stack<ItemStack>();
/* 48 */     result.push(out);
/*    */     
/* 50 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidStack getResultFluid(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 56 */     FluidStack fs = this.recipeOutFluid.copy();
/*    */     
/* 58 */     if (inIS != null && inIS.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*    */       
/* 60 */       int w = (int)Math.floor(Food.getWeight(inIS));
/* 61 */       if (w * this.recipeOutFluid.amount <= inFS.amount)
/*    */       {
/* 63 */         fs.amount = w * this.recipeOutFluid.amount;
/*    */       }
/*    */     }
/* 66 */     else if (inIS != null) {
/*    */       
/* 68 */       fs.amount *= inIS.field_77994_a;
/*    */     } 
/* 70 */     return fs;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isKeepstacksize() {
/* 75 */     return this.keepstacksize;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean matches(ItemStack inIS, FluidStack inFS) {
/* 81 */     if (inIS != null && inFS != null && inIS.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*    */       
/* 83 */       float w = Food.getWeight(inIS);
/* 84 */       if (inFS.isFluidEqual(this.recipeFluid) && w * this.recipeOutFluid.amount <= inFS.amount)
/*    */       {
/* 86 */         return Boolean.valueOf(OreDictionary.itemMatches(this.recipeIS, inIS, false));
/*    */       }
/*    */       
/* 89 */       return Boolean.valueOf(false);
/*    */     } 
/* 91 */     return super.matches(inIS, inFS);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelMultiItemRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */