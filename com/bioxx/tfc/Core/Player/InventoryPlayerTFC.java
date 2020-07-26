/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class InventoryPlayerTFC extends InventoryPlayer {
/*  15 */   public ItemStack[] extraEquipInventory = new ItemStack[TFC_Core.getExtraEquipInventorySize()];
/*     */   
/*     */   public InventoryPlayerTFC(EntityPlayer par1EntityPlayer) {
/*  18 */     super(par1EntityPlayer);
/*  19 */     this.field_70458_d = par1EntityPlayer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70449_g(float par1) {
/*  25 */     par1 /= 4.0F;
/*  26 */     if (par1 < 1.0F) {
/*  27 */       par1 = 1.0F;
/*     */     }
/*  29 */     for (int i = 0; i < this.field_70460_b.length; i++) {
/*     */       
/*  31 */       if (this.field_70460_b[i] != null && this.field_70460_b[i].func_77973_b() instanceof net.minecraft.item.ItemArmor) {
/*     */         
/*  33 */         this.field_70460_b[i].func_77972_a((int)par1, (EntityLivingBase)this.field_70458_d);
/*  34 */         if ((this.field_70460_b[i]).field_77994_a == 0) {
/*  35 */           this.field_70460_b[i] = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  43 */     return this.field_70462_a.length + this.field_70460_b.length + this.extraEquipInventory.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70443_b(NBTTagList par1NBTTagList) {
/*  49 */     super.func_70443_b(par1NBTTagList);
/*  50 */     this.extraEquipInventory = new ItemStack[TFC_Core.getExtraEquipInventorySize()];
/*     */     
/*  52 */     NBTTagList extraList = this.field_70458_d.getEntityData().func_150295_c("ExtraInventory", 10);
/*     */     
/*  54 */     for (int i = 0; i < extraList.func_74745_c(); i++) {
/*     */       
/*  56 */       NBTTagCompound nbttagcompound = extraList.func_150305_b(i);
/*  57 */       ItemStack itemstack = ItemStack.func_77949_a(nbttagcompound);
/*  58 */       if (itemstack != null)
/*     */       {
/*  60 */         this.extraEquipInventory[i] = itemstack;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int par1) {
/*  71 */     ItemStack[] aitemstack = this.field_70462_a;
/*  72 */     if (par1 >= this.field_70462_a.length + 4) {
/*     */       
/*  74 */       par1 -= this.field_70462_a.length + 4;
/*  75 */       aitemstack = this.extraEquipInventory;
/*     */     }
/*  77 */     else if (par1 >= this.field_70462_a.length) {
/*  78 */       par1 -= this.field_70462_a.length;
/*  79 */       aitemstack = this.field_70460_b;
/*     */     } 
/*  81 */     return aitemstack[par1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int par1) {
/*  87 */     ItemStack[] aitemstack = this.field_70462_a;
/*     */     
/*  89 */     if (par1 >= this.field_70462_a.length + 4) {
/*     */       
/*  91 */       par1 -= this.field_70462_a.length + 4;
/*  92 */       aitemstack = this.extraEquipInventory;
/*     */     }
/*  94 */     else if (par1 >= this.field_70462_a.length) {
/*  95 */       par1 -= this.field_70462_a.length;
/*  96 */       aitemstack = this.field_70460_b;
/*     */     } 
/*  98 */     if (aitemstack[par1] != null) {
/*     */       
/* 100 */       ItemStack itemstack = aitemstack[par1];
/* 101 */       aitemstack[par1] = null;
/* 102 */       return itemstack;
/*     */     } 
/*     */ 
/*     */     
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_146027_a(Item item, int meta) {
/* 113 */     for (int i = 0; i < this.extraEquipInventory.length; i++) {
/*     */       
/* 115 */       if (this.extraEquipInventory[i] != null && (item == null || this.extraEquipInventory[i].func_77973_b() == item) && (meta <= -1 || this.extraEquipInventory[i]
/* 116 */         .func_77960_j() == meta))
/*     */       {
/* 118 */         this.extraEquipInventory[i] = null;
/*     */       }
/*     */     } 
/* 121 */     return super.func_146027_a(item, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70429_k() {
/* 127 */     for (int i = 0; i < this.extraEquipInventory.length; i++) {
/*     */       
/* 129 */       if (this.extraEquipInventory[i] != null)
/*     */       {
/* 131 */         this.extraEquipInventory[i].func_77945_a(this.field_70458_d.field_70170_p, (Entity)this.field_70458_d, i, (this.field_70461_c == i));
/*     */       }
/*     */     } 
/* 134 */     super.func_70429_k();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int par1, int par2) {
/* 140 */     ItemStack[] aitemstack = this.field_70462_a;
/*     */     
/* 142 */     if (par1 >= this.field_70462_a.length + 4) {
/*     */       
/* 144 */       par1 -= this.field_70462_a.length + 4;
/* 145 */       aitemstack = this.extraEquipInventory;
/*     */     }
/* 147 */     else if (par1 >= this.field_70462_a.length) {
/* 148 */       par1 -= this.field_70462_a.length;
/* 149 */       aitemstack = this.field_70460_b;
/*     */     } 
/*     */ 
/*     */     
/* 153 */     if (aitemstack[par1] != null) {
/*     */ 
/*     */ 
/*     */       
/* 157 */       if ((aitemstack[par1]).field_77994_a <= par2) {
/*     */         
/* 159 */         ItemStack itemStack = aitemstack[par1];
/* 160 */         aitemstack[par1] = null;
/* 161 */         return itemStack;
/*     */       } 
/*     */ 
/*     */       
/* 165 */       ItemStack itemstack = aitemstack[par1].func_77979_a(par2);
/*     */       
/* 167 */       if ((aitemstack[par1]).field_77994_a == 0)
/*     */       {
/* 169 */         aitemstack[par1] = null;
/*     */       }
/*     */       
/* 172 */       return itemstack;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70436_m() {
/* 186 */     for (int i = 0; i < this.extraEquipInventory.length; i++) {
/*     */       
/* 188 */       if (this.extraEquipInventory[i] != null) {
/*     */         
/* 190 */         this.field_70458_d.func_146097_a(this.extraEquipInventory[i], true, false);
/* 191 */         this.extraEquipInventory[i] = null;
/*     */       } 
/*     */     } 
/* 194 */     NBTTagList derp = new NBTTagList();
/* 195 */     this.field_70458_d.getEntityData().func_74782_a("ExtraInventory", (NBTBase)derp);
/* 196 */     super.func_70436_m();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70431_c(ItemStack par1ItemStack) {
/* 204 */     for (int i = 0; i < this.extraEquipInventory.length; i++) {
/*     */       
/* 206 */       if (this.extraEquipInventory[i] != null && this.extraEquipInventory[i].func_77969_a(par1ItemStack))
/*     */       {
/* 208 */         return true;
/*     */       }
/*     */     } 
/* 211 */     return super.func_70431_c(par1ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int par1, ItemStack par2ItemStack) {
/* 218 */     ItemStack[] aitemstack = this.field_70462_a;
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
/* 229 */     if (par1 >= this.field_70462_a.length + 4) {
/*     */       
/* 231 */       par1 -= this.field_70462_a.length + 4;
/* 232 */       aitemstack = this.extraEquipInventory;
/*     */     }
/* 234 */     else if (par1 >= this.field_70462_a.length) {
/* 235 */       par1 -= this.field_70462_a.length;
/* 236 */       aitemstack = this.field_70460_b;
/*     */     } 
/*     */     
/* 239 */     aitemstack[par1] = par2ItemStack;
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
/*     */   public void func_70455_b(InventoryPlayer par1InventoryPlayer) {
/* 252 */     if (par1InventoryPlayer instanceof InventoryPlayerTFC) {
/* 253 */       copyInventoryTFC((InventoryPlayerTFC)par1InventoryPlayer);
/*     */     } else {
/*     */       
/* 256 */       super.func_70455_b(par1InventoryPlayer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyInventoryTFC(InventoryPlayerTFC par1InventoryPlayer) {
/* 264 */     for (int i = 0; i < this.extraEquipInventory.length; i++)
/*     */     {
/* 266 */       this.extraEquipInventory[i] = ItemStack.func_77944_b(par1InventoryPlayer.extraEquipInventory[i]);
/*     */     }
/* 268 */     super.func_70455_b(par1InventoryPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagList func_70442_a(NBTTagList par1NBTTagList) {
/* 274 */     super.func_70442_a(par1NBTTagList);
/*     */ 
/*     */ 
/*     */     
/* 278 */     NBTTagList tagList = new NBTTagList();
/* 279 */     for (int i = 0; i < this.extraEquipInventory.length; i++) {
/*     */       
/* 281 */       ItemStack is = this.extraEquipInventory[i];
/* 282 */       if (is != null && is.field_77994_a != 0) {
/*     */         
/* 284 */         NBTTagCompound nbt = new NBTTagCompound();
/* 285 */         nbt.func_74774_a("Slot", (byte)i);
/* 286 */         is.func_77955_b(nbt);
/* 287 */         tagList.func_74742_a((NBTBase)nbt);
/*     */       } 
/*     */     } 
/* 290 */     this.field_70458_d.getEntityData().func_74782_a("ExtraInventory", (NBTBase)tagList);
/* 291 */     return par1NBTTagList;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\InventoryPlayerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */