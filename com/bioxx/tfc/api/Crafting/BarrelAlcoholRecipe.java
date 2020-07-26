/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import java.util.Stack;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ import net.minecraftforge.oredict.OreDictionary;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BarrelAlcoholRecipe
/*    */   extends BarrelRecipe
/*    */ {
/*    */   public BarrelAlcoholRecipe(ItemStack inputItem, FluidStack inputFluid, ItemStack outIS, FluidStack outputFluid) {
/* 19 */     super(inputItem, inputFluid, outIS, outputFluid);
/* 20 */     this.sealTime = 72;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Stack<ItemStack> getResult(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 26 */     Stack<ItemStack> result = new Stack<ItemStack>();
/* 27 */     result.push(this.recipeOutIS);
/* 28 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidStack getResultFluid(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 34 */     float amt = inFS.amount / 10000.0F;
/* 35 */     FluidStack out = this.recipeOutFluid.copy();
/* 36 */     if (out.tag == null)
/* 37 */       out.tag = new NBTTagCompound(); 
/* 38 */     float weight = Food.getWeight(inIS);
/* 39 */     out.tag.func_74776_a("potency", weight / Food.getWeight(this.recipeIS) / amt);
/* 40 */     return this.recipeOutFluid;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean matches(ItemStack itemstack, FluidStack inFluid) {
/* 46 */     if (this.recipeIS.func_77942_o()) {
/*    */       
/* 48 */       if (itemstack == null || !itemstack.func_77942_o())
/*    */       {
/* 50 */         return Boolean.valueOf(false);
/*    */       }
/* 52 */       if (this.recipeIS.func_77973_b() instanceof com.bioxx.tfc.Food.ItemFoodTFC) {
/*    */         
/* 54 */         if (!(itemstack.func_77973_b() instanceof com.bioxx.tfc.Food.ItemFoodTFC))
/*    */         {
/* 56 */           return Boolean.valueOf(false);
/*    */         }
/* 58 */         float recipeWeight = Food.getWeight(this.recipeIS);
/* 59 */         float itemstackWeight = Food.getWeight(itemstack);
/* 60 */         float percent = itemstackWeight / recipeWeight * inFluid.amount / this.recipeFluid.amount;
/* 61 */         if (percent < 0.25F || percent > 0.75F)
/* 62 */           return Boolean.valueOf(false); 
/*    */       } 
/*    */     } 
/* 65 */     return Boolean.valueOf((OreDictionary.itemMatches(this.recipeIS, itemstack, false) && inFluid.isFluidEqual(this.recipeFluid)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelAlcoholRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */