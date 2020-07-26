/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.Metal.AlloyMetal;
/*     */ import com.bioxx.tfc.Core.Metal.MetalPair;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ public class ItemCrucible extends ItemTerraBlock implements ISize {
/*  23 */   public Map<String, MetalPair> metals = new HashMap<String, MetalPair>();
/*     */   private Alloy currentAlloy;
/*     */   
/*     */   public ItemCrucible(Block par1) {
/*  27 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  33 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */     
/*  35 */     readFromItemNBT(is.func_77978_p(), arraylist);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromItemNBT(NBTTagCompound nbt, List<String> arraylist) {
/*  40 */     this.currentAlloy = null;
/*  41 */     this.metals = new HashMap<String, MetalPair>();
/*  42 */     if (nbt != null && nbt.func_74764_b("Metals")) {
/*     */       
/*  44 */       NBTTagList nbttaglist = nbt.func_150295_c("Metals", 9);
/*     */       
/*  46 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/*  48 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  49 */         int id = nbttagcompound1.func_74762_e("ID");
/*  50 */         float amount = nbttagcompound1.func_74760_g("AmountF");
/*     */         
/*  52 */         Metal m = MetalRegistry.instance.getMetalFromItem(Item.func_150899_d(id));
/*  53 */         addMetal(m, amount);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  58 */     if (this.currentAlloy != null)
/*     */     {
/*  60 */       for (int c = 0; c < this.currentAlloy.alloyIngred.size(); c++) {
/*     */         
/*  62 */         double m = ((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metal;
/*  63 */         m = Math.round(m * 100.0D) / 100.0D;
/*  64 */         if (((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metalType != null)
/*     */         {
/*  66 */           arraylist.add(EnumChatFormatting.DARK_GRAY + ((AlloyMetal)this.currentAlloy.alloyIngred.get(c)).metalType.name + " " + EnumChatFormatting.DARK_GREEN + m + "%");
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addMetal(Metal m, float amt) {
/*  74 */     if (getTotalMetal() + amt <= 3000.0F && !"Unknown".equals(m.name)) {
/*     */       
/*  76 */       if (this.metals.containsKey(m.name)) {
/*     */         
/*  78 */         ((MetalPair)this.metals.get(m.name)).amount += amt;
/*     */       }
/*     */       else {
/*     */         
/*  82 */         this.metals.put(m.name, new MetalPair(m, amt));
/*     */       } 
/*     */       
/*  85 */       updateCurrentAlloy();
/*     */       
/*  87 */       return true;
/*     */     } 
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTotalMetal() {
/*  94 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/*  95 */     float totalAmount = 0.0F;
/*  96 */     while (iter.hasNext()) {
/*     */       
/*  98 */       MetalPair m = iter.next();
/*  99 */       if (m != null)
/*     */       {
/* 101 */         totalAmount += m.amount;
/*     */       }
/*     */     } 
/* 104 */     return totalAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateCurrentAlloy() {
/* 109 */     List<AlloyMetal> a = new ArrayList<AlloyMetal>();
/*     */     
/* 111 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/* 112 */     float totalAmount = getTotalMetal();
/*     */     
/* 114 */     iter = this.metals.values().iterator();
/* 115 */     while (iter.hasNext()) {
/*     */       
/* 117 */       MetalPair m = iter.next();
/* 118 */       if (m != null)
/*     */       {
/* 120 */         a.add(new AlloyMetal(m.type, m.amount / totalAmount * 100.0F));
/*     */       }
/*     */     } 
/*     */     
/* 124 */     Metal match = AlloyManager.INSTANCE.matchesAlloy(a, Alloy.EnumTier.TierV);
/* 125 */     if (match != null) {
/*     */       
/* 127 */       this.currentAlloy = new Alloy(match, totalAmount);
/* 128 */       this.currentAlloy.alloyIngred = a;
/*     */     }
/*     */     else {
/*     */       
/* 132 */       this.currentAlloy = new Alloy(Global.UNKNOWN, totalAmount);
/* 133 */       this.currentAlloy.alloyIngred = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 141 */     return EnumSize.HUGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 153 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */