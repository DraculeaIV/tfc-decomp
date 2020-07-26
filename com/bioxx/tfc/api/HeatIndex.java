/*     */ package com.bioxx.tfc.api;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeatIndex
/*     */ {
/*     */   public float specificHeat;
/*     */   public float meltTemp;
/*     */   public boolean keepNBT;
/*     */   private ItemStack output;
/*     */   private int outputMin;
/*     */   private int outputMax;
/*     */   private ItemStack morph;
/*     */   public ItemStack input;
/*     */   
/*     */   public HeatIndex(ItemStack in, double sh, double melt, ItemStack out) {
/*  25 */     this.input = in;
/*  26 */     this.specificHeat = (float)sh;
/*  27 */     this.meltTemp = (float)melt;
/*  28 */     this.output = out;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex(ItemStack in, HeatRaw raw) {
/*  33 */     this.input = in;
/*  34 */     this.specificHeat = raw.specificHeat;
/*  35 */     this.meltTemp = raw.meltTemp;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex(ItemStack in, HeatRaw raw, ItemStack out) {
/*  40 */     this(in, raw);
/*  41 */     this.output = out;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex setKeepNBT(boolean k) {
/*  46 */     this.keepNBT = k;
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public boolean hasOutput() {
/*  51 */     return (this.output != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getOutputItem() {
/*  56 */     if (this.output != null)
/*  57 */       return this.output.func_77973_b(); 
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOutputDamage() {
/*  63 */     if (this.output != null)
/*  64 */       return this.output.func_77960_j(); 
/*  65 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex setMinMax(int min, int max) {
/*  70 */     this.outputMin = min;
/*  71 */     this.outputMax = max;
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex setMinMax(int amt) {
/*  77 */     this.outputMin = amt;
/*  78 */     this.outputMax = amt;
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public HeatIndex setMorph(ItemStack is) {
/*  84 */     this.morph = is;
/*  85 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getMorph() {
/*  90 */     return this.morph;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getOutput(Random r) {
/*  95 */     if (getOutputItem() == null)
/*  96 */       return null; 
/*  97 */     int rand = 0;
/*  98 */     if (this.outputMax - this.outputMin > 0) {
/*     */       
/* 100 */       rand = this.outputMin + r.nextInt(this.outputMax - this.outputMin);
/* 101 */       return new ItemStack(getOutputItem(), this.output.field_77994_a, 100 - rand);
/*     */     } 
/*     */ 
/*     */     
/* 105 */     return new ItemStack(getOutputItem(), this.output.field_77994_a, this.outputMin);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getOutput(ItemStack in, Random r) {
/* 111 */     ItemStack is = getOutput(r);
/* 112 */     if (is != null && this.keepNBT)
/*     */     {
/* 114 */       if (is.func_77942_o()) {
/*     */         
/* 116 */         NBTTagCompound nbt = is.func_77978_p();
/* 117 */         for (Object o : in.func_77978_p().func_150296_c())
/*     */         {
/* 119 */           NBTBase n = (NBTBase)o;
/* 120 */           if (nbt.func_74764_b(n.toString()))
/* 121 */             nbt.func_82580_o(n.toString()); 
/* 122 */           nbt.func_150296_c().add(o);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 127 */         is.func_77982_d(in.field_77990_d);
/* 128 */         if (TFC_ItemHeat.hasTemp(is))
/* 129 */           TFC_ItemHeat.setTemp(is, TFC_ItemHeat.getTemp(is) * 0.9F); 
/*     */       } 
/*     */     }
/* 132 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean matches(ItemStack is) {
/* 137 */     if (is != null) {
/*     */       
/* 139 */       boolean b = is.func_77973_b().func_77614_k();
/* 140 */       if (is.func_77973_b() != this.input.func_77973_b())
/* 141 */         return false; 
/* 142 */       if (b && this.input.func_77960_j() != 32767 && is
/* 143 */         .func_77960_j() != this.input.func_77960_j())
/* 144 */         return false; 
/*     */     } else {
/* 146 */       return false;
/* 147 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\HeatIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */