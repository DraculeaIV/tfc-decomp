/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ShapedRecipesTFC
/*     */   implements IRecipe
/*     */ {
/*     */   private int recipeWidth;
/*     */   private int recipeHeight;
/*     */   private ItemStack[] recipeItems;
/*     */   private ItemStack recipeOutput;
/*     */   
/*     */   public ShapedRecipesTFC(int i, int j, ItemStack[] aitemstack, ItemStack itemstack) {
/*  21 */     this.recipeWidth = i;
/*  22 */     this.recipeHeight = j;
/*  23 */     this.recipeItems = (ItemStack[])aitemstack.clone();
/*  24 */     this.recipeOutput = itemstack;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compare(InventoryCrafting inventorycrafting, int i, int j, boolean flag) {
/*  29 */     for (int k = 0; k < 5; k++) {
/*     */       
/*  31 */       for (int l = 0; l < 5; l++) {
/*     */         
/*  33 */         int i1 = k - i;
/*  34 */         int j1 = l - j;
/*  35 */         ItemStack recipeIS = null;
/*  36 */         if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
/*     */         {
/*  38 */           if (flag) {
/*     */             
/*  40 */             recipeIS = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
/*     */           }
/*     */           else {
/*     */             
/*  44 */             recipeIS = this.recipeItems[i1 + j1 * this.recipeWidth];
/*     */           } 
/*     */         }
/*  47 */         ItemStack inputIS = inventorycrafting.func_70463_b(k, l);
/*  48 */         if (inputIS != null || recipeIS != null) {
/*     */ 
/*     */ 
/*     */           
/*  52 */           if (inputIS == null || recipeIS == null)
/*     */           {
/*  54 */             return false;
/*     */           }
/*     */ 
/*     */           
/*  58 */           if (recipeIS.func_77973_b() != inputIS.func_77973_b())
/*     */           {
/*  60 */             return false;
/*     */           }
/*  62 */           if (recipeIS.func_77960_j() != 32767 && recipeIS.func_77960_j() != inputIS.func_77960_j())
/*     */           {
/*  64 */             return false;
/*     */           }
/*     */           
/*  67 */           if (!tempMatch(recipeIS, inputIS))
/*     */           {
/*  69 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77572_b(InventoryCrafting inventorycrafting) {
/*  80 */     return new ItemStack(this.recipeOutput.func_77973_b(), this.recipeOutput.field_77994_a, this.recipeOutput.func_77960_j());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77571_b() {
/*  86 */     return this.recipeOutput;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77570_a() {
/*  92 */     return this.recipeWidth * this.recipeHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecipeWidth() {
/*  97 */     return this.recipeWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecipeHeight() {
/* 102 */     return this.recipeHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack[] getRecipeItems() {
/* 107 */     return (ItemStack[])this.recipeItems.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77569_a(InventoryCrafting inventorycrafting, World world) {
/* 113 */     for (int i = 0; i <= 5 - this.recipeWidth; i++) {
/*     */       
/* 115 */       for (int j = 0; j <= 5 - this.recipeHeight; j++) {
/*     */         
/* 117 */         if (compare(inventorycrafting, i, j, true))
/*     */         {
/* 119 */           return true;
/*     */         }
/* 121 */         if (compare(inventorycrafting, i, j, false))
/*     */         {
/* 123 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean tempMatch(ItemStack recipeIS, ItemStack inputIS) {
/* 133 */     NBTTagCompound rnbt = recipeIS.func_77978_p();
/* 134 */     NBTTagCompound inbt = inputIS.func_77978_p();
/*     */     
/* 136 */     if (rnbt != null && rnbt.func_74764_b("noTemp"))
/*     */     {
/*     */       
/* 139 */       return (inbt == null || !TFC_ItemHeat.hasTemp(inputIS));
/*     */     }
/*     */     
/* 142 */     if (rnbt != null && TFC_ItemHeat.hasTemp(recipeIS)) {
/*     */       
/* 144 */       if (inbt != null && TFC_ItemHeat.hasTemp(inputIS))
/*     */       {
/* 146 */         return HeatRegistry.getInstance().getIsLiquid(inputIS).booleanValue();
/*     */       }
/*     */ 
/*     */       
/* 150 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 154 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\ShapedRecipesTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */