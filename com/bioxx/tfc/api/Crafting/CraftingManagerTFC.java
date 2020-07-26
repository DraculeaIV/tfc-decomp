/*     */ package com.bioxx.tfc.api.Crafting;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class CraftingManagerTFC
/*     */ {
/*  17 */   private static final CraftingManagerTFC INSTANCE = new CraftingManagerTFC();
/*     */   
/*     */   public static final CraftingManagerTFC getInstance() {
/*  20 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<IRecipe> recipes;
/*     */   
/*     */   private CraftingManagerTFC() {
/*  27 */     this.recipes = new ArrayList<IRecipe>();
/*     */     
/*  29 */     Collections.sort(this.recipes, new RecipeSorterTFC(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ShapedRecipesTFC addRecipe(ItemStack itemstack, Object[] aobj) {
/*  35 */     String s = "";
/*  36 */     int i = 0;
/*  37 */     int j = 0;
/*  38 */     int k = 0;
/*  39 */     if (aobj[i] instanceof String[]) {
/*     */       
/*  41 */       String[] as = (String[])aobj[i++];
/*  42 */       for (int l = 0; l < as.length; l++)
/*     */       {
/*  44 */         String s2 = as[l];
/*  45 */         k++;
/*  46 */         j = s2.length();
/*  47 */         s = s + s2;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  52 */       while (aobj[i] instanceof String) {
/*     */         
/*  54 */         String s1 = (String)aobj[i++];
/*  55 */         k++;
/*  56 */         j = s1.length();
/*  57 */         s = s + s1;
/*     */       } 
/*     */     } 
/*  60 */     HashMap<Character, ItemStack> hashmap = new HashMap<Character, ItemStack>();
/*  61 */     for (; i < aobj.length; i += 2) {
/*     */       
/*  63 */       Character character = (Character)aobj[i];
/*  64 */       ItemStack itemstack1 = null;
/*  65 */       if (aobj[i + 1] instanceof Item) {
/*     */         
/*  67 */         itemstack1 = new ItemStack((Item)aobj[i + 1]);
/*     */       }
/*  69 */       else if (aobj[i + 1] instanceof Block) {
/*     */         
/*  71 */         itemstack1 = new ItemStack((Block)aobj[i + 1], 1, -1);
/*     */       }
/*  73 */       else if (aobj[i + 1] instanceof ItemStack) {
/*     */         
/*  75 */         itemstack1 = (ItemStack)aobj[i + 1];
/*     */       } 
/*  77 */       hashmap.put(character, itemstack1);
/*     */     } 
/*     */     
/*  80 */     ItemStack[] aitemstack = new ItemStack[j * k];
/*  81 */     for (int i1 = 0; i1 < j * k; i1++) {
/*     */       
/*  83 */       char c = s.charAt(i1);
/*  84 */       if (hashmap.containsKey(Character.valueOf(c))) {
/*     */         
/*  86 */         aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c))).func_77946_l();
/*     */       }
/*     */       else {
/*     */         
/*  90 */         aitemstack[i1] = null;
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     ShapedRecipesTFC shapedRecipesTFC = new ShapedRecipesTFC(j, k, aitemstack, itemstack);
/*  95 */     this.recipes.add(shapedRecipesTFC);
/*  96 */     return shapedRecipesTFC;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShapelessRecipesTFC addShapelessRecipe(ItemStack itemstack, Object[] aobj) {
/* 101 */     ArrayList<ItemStack> arraylist = new ArrayList<ItemStack>();
/* 102 */     Object[] aobj1 = aobj;
/* 103 */     int i = aobj1.length;
/* 104 */     for (int j = 0; j < i; j++) {
/*     */       
/* 106 */       Object obj = aobj1[j];
/* 107 */       if (obj instanceof ItemStack) {
/*     */         
/* 109 */         arraylist.add(((ItemStack)obj).func_77946_l());
/*     */       
/*     */       }
/* 112 */       else if (obj instanceof Item) {
/*     */         
/* 114 */         arraylist.add(new ItemStack((Item)obj));
/*     */       
/*     */       }
/* 117 */       else if (obj instanceof Block) {
/*     */         
/* 119 */         arraylist.add(new ItemStack((Block)obj));
/*     */       }
/*     */       else {
/*     */         
/* 123 */         throw new RuntimeException("Invalid shapeless recipy!");
/*     */       } 
/*     */     } 
/* 126 */     ShapelessRecipesTFC recipesTFC = new ShapelessRecipesTFC(itemstack, arraylist);
/* 127 */     this.recipes.add(recipesTFC);
/* 128 */     return recipesTFC;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack findMatchingRecipe(InventoryCrafting inventorycrafting, World world) {
/* 167 */     for (int k = 0; k < this.recipes.size(); k++) {
/*     */       
/* 169 */       IRecipe irecipe = this.recipes.get(k);
/* 170 */       if (irecipe.func_77569_a(inventorycrafting, world))
/*     */       {
/* 172 */         return irecipe.func_77572_b(inventorycrafting);
/*     */       }
/*     */     } 
/*     */     
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<IRecipe> getRecipeList() {
/* 181 */     return this.recipes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\CraftingManagerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */