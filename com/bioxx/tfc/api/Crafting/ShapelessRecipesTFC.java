/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShapelessRecipesTFC
/*     */   implements IRecipe
/*     */ {
/*     */   private final ItemStack recipeOutput;
/*     */   private final List recipeItems;
/*     */   
/*     */   public ShapelessRecipesTFC(ItemStack par1ItemStack, List par2List) {
/*  26 */     this.recipeOutput = par1ItemStack;
/*  27 */     this.recipeItems = par2List;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77572_b(InventoryCrafting par1InventoryCrafting) {
/*  36 */     return this.recipeOutput.func_77946_l();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77571_b() {
/*  42 */     return this.recipeOutput;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77570_a() {
/*  51 */     return this.recipeItems.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77569_a(InventoryCrafting par1InventoryCrafting, World world) {
/*  60 */     ArrayList var2 = new ArrayList(this.recipeItems);
/*     */     
/*  62 */     for (int var3 = 0; var3 < 5; var3++) {
/*     */       
/*  64 */       for (int var4 = 0; var4 < 5; var4++) {
/*     */         
/*  66 */         ItemStack inputIS = par1InventoryCrafting.func_70463_b(var4, var3);
/*     */         
/*  68 */         if (inputIS != null) {
/*     */           
/*  70 */           boolean var6 = false;
/*  71 */           Iterator<ItemStack> var7 = var2.iterator();
/*     */           
/*  73 */           while (var7.hasNext()) {
/*     */             
/*  75 */             ItemStack recipeIS = var7.next();
/*     */             
/*  77 */             if (inputIS.func_77973_b() == recipeIS.func_77973_b() && (recipeIS
/*  78 */               .func_77960_j() == 32767 || inputIS
/*  79 */               .func_77960_j() == recipeIS.func_77960_j()) && 
/*  80 */               tempMatch(recipeIS, inputIS)) {
/*     */               
/*  82 */               var6 = true;
/*  83 */               var2.remove(recipeIS);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*  88 */           if (!var6)
/*     */           {
/*  90 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return var2.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean tempMatch(ItemStack recipeIS, ItemStack inputIS) {
/* 101 */     NBTTagCompound rnbt = recipeIS.func_77978_p();
/* 102 */     NBTTagCompound inbt = inputIS.func_77978_p();
/*     */     
/* 104 */     if (rnbt != null && rnbt.func_74764_b("noTemp"))
/*     */     {
/*     */       
/* 107 */       return (inbt == null || !TFC_ItemHeat.hasTemp(inputIS));
/*     */     }
/*     */     
/* 110 */     if (rnbt != null && TFC_ItemHeat.hasTemp(recipeIS)) {
/*     */       
/* 112 */       if (inbt != null && TFC_ItemHeat.hasTemp(inputIS))
/*     */       {
/* 114 */         return HeatRegistry.getInstance().getIsLiquid(inputIS).booleanValue();
/*     */       }
/*     */ 
/*     */       
/* 118 */       return false;
/*     */     } 
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\ShapelessRecipesTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */