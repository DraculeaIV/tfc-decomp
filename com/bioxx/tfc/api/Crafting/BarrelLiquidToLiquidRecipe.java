/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import java.util.Stack;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ 
/*    */ 
/*    */ public class BarrelLiquidToLiquidRecipe
/*    */   extends BarrelRecipe
/*    */ {
/*    */   public FluidStack inputfluid;
/*    */   
/*    */   public BarrelLiquidToLiquidRecipe(FluidStack fluidInBarrel, FluidStack inputfluid, FluidStack outputFluid) {
/* 15 */     super(null, fluidInBarrel, null, outputFluid);
/* 16 */     this.inputfluid = inputfluid;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean matches(ItemStack item, FluidStack fluid) {
/* 22 */     FluidStack itemLiquid = FluidContainerRegistry.getFluidForFilledItem(item);
/* 23 */     if (this.recipeFluid != null && this.recipeFluid.isFluidEqual(fluid) && itemLiquid != null && itemLiquid.isFluidEqual(this.inputfluid)) {
/*    */ 
/*    */       
/* 26 */       if (10000 - fluid.amount < itemLiquid.amount) {
/* 27 */         return Boolean.valueOf(false);
/*    */       }
/* 29 */       return Boolean.valueOf(true);
/*    */     } 
/* 31 */     return Boolean.valueOf(false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Stack<ItemStack> getResult(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 37 */     Stack<ItemStack> result = new Stack<ItemStack>();
/* 38 */     if (inIS != null) {
/* 39 */       result.push(inIS.func_77973_b().getContainerItem(inIS));
/*    */     } else {
/* 41 */       result.push(null);
/*    */     } 
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FluidStack getResultFluid(ItemStack inIS, FluidStack inFS, int sealedTime) {
/* 49 */     if (this.recipeOutFluid != null) {
/*    */       
/* 51 */       FluidStack fs = this.recipeOutFluid.copy();
/* 52 */       FluidStack itemLiquid = FluidContainerRegistry.getFluidForFilledItem(inIS);
/* 53 */       if (!this.removesLiquid) {
/*    */         
/* 55 */         inFS.amount += itemLiquid.amount;
/*    */       }
/*    */       else {
/*    */         
/* 59 */         fs.amount = fs.amount * inFS.amount / this.recipeFluid.amount;
/*    */       } 
/* 61 */       return fs;
/*    */     } 
/* 63 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FluidStack getInputfluid() {
/* 68 */     return this.inputfluid;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\BarrelLiquidToLiquidRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */