/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemUnfinishedArmor
/*     */   extends ItemTerra
/*     */   implements ISmeltable
/*     */ {
/*     */   public int metalID;
/*     */   private String metal;
/*     */   private short metalAmount;
/*     */   private short metalAmount2;
/*     */   private boolean smeltable = true;
/*     */   
/*     */   public ItemUnfinishedArmor() {
/*  27 */     this.field_77787_bX = true;
/*  28 */     func_77656_e(0);
/*  29 */     func_77637_a(TFCTabs.TFC_MISC);
/*  30 */     setFolder("armor/");
/*  31 */     setSize(EnumSize.LARGE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemUnfinishedArmor(String tex) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  42 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", "").replace("Unfinished ", "").replace("Stage2 ", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  48 */     if (is.func_77960_j() == 0) {
/*  49 */       arraylist.add(TFC_Core.translate("gui.stage1"));
/*     */     } else {
/*  51 */       arraylist.add(TFC_Core.translate("gui.stage2"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack itemstack) {
/*  57 */     return super.func_77653_i(itemstack);
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
/*     */   public int func_77639_j() {
/*  69 */     if (canStack()) {
/*  70 */       return (getSize((ItemStack)null)).stackSize;
/*     */     }
/*  72 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/*  85 */     if (this.metal == null)
/*     */     {
/*  87 */       return MetalRegistry.instance.getMetalFromItem(this);
/*     */     }
/*     */ 
/*     */     
/*  91 */     return MetalRegistry.instance.getMetalFromString(this.metal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/*  98 */     if (is.func_77960_j() == 1)
/*  99 */       return this.metalAmount2; 
/* 100 */     return this.metalAmount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/* 106 */     return this.smeltable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 112 */     return ISmeltable.EnumTier.TierI;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setMetal(String m, int slot) {
/* 117 */     this.metal = m;
/* 118 */     if (slot == 0) {
/*     */       
/* 120 */       this.metalAmount = 200;
/* 121 */       this.metalAmount2 = 400;
/*     */     }
/* 123 */     else if (slot == 1) {
/*     */       
/* 125 */       this.metalAmount = 400;
/* 126 */       this.metalAmount2 = 800;
/*     */     }
/* 128 */     else if (slot == 2) {
/*     */       
/* 130 */       this.metalAmount = 400;
/* 131 */       this.metalAmount2 = 600;
/*     */     }
/* 133 */     else if (slot == 3) {
/*     */       
/* 135 */       this.metalAmount = 200;
/* 136 */       this.metalAmount2 = 200;
/*     */     } 
/* 138 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemUnfinishedArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */