/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemNugget
/*     */   extends ItemTerra
/*     */   implements ISmeltable
/*     */ {
/*     */   private short metalAmount;
/*     */   
/*     */   public ItemNugget() {
/*  25 */     func_77656_e(0);
/*  26 */     func_77627_a(true);
/*  27 */     this.metaNames = new String[] { "Bismuth", "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Brass", "Bronze", "Copper", "Gold", "Wrought Iron", "Lead", "Nickel", "Pig Iron", "Platinum", "Red Steel", "Rose Gold", "Silver", "Steel", "Sterling Silver", "Tin", "Zinc", "Electrum", "Cupronickel" };
/*     */ 
/*     */ 
/*     */     
/*  31 */     setFolder("ingots/");
/*  32 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*  33 */     setWeight(EnumWeight.MEDIUM);
/*  34 */     setSize(EnumSize.TINY);
/*  35 */     this.metalAmount = 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  42 */     this.metaIcons = new net.minecraft.util.IIcon[this.metaNames.length];
/*  43 */     for (int i = 0; i < this.metaNames.length; i++)
/*     */     {
/*  45 */       this.metaIcons[i] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[i] + " Nugget");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  52 */     if (getMetalType(is) != null)
/*     */     {
/*  54 */       if (TFC_Core.showShiftInformation()) {
/*     */         
/*  56 */         arraylist.add(TFC_Core.translate("gui.units") + ": " + getMetalReturnAmount(is));
/*     */       }
/*     */       else {
/*     */         
/*  60 */         arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/*  68 */     int dam = is.func_77960_j();
/*  69 */     switch (dam) {
/*     */       case 0:
/*  71 */         return Global.BISMUTH;
/*  72 */       case 1: return Global.BISMUTHBRONZE;
/*  73 */       case 2: return Global.BLACKBRONZE;
/*  74 */       case 3: return Global.BLACKSTEEL;
/*  75 */       case 4: return Global.BLUESTEEL;
/*  76 */       case 5: return Global.BRASS;
/*  77 */       case 6: return Global.BRONZE;
/*  78 */       case 7: return Global.COPPER;
/*  79 */       case 8: return Global.GOLD;
/*  80 */       case 9: return Global.WROUGHTIRON;
/*  81 */       case 10: return Global.LEAD;
/*  82 */       case 11: return Global.NICKEL;
/*  83 */       case 12: return Global.PIGIRON;
/*  84 */       case 13: return Global.PLATINUM;
/*  85 */       case 14: return Global.REDSTEEL;
/*  86 */       case 15: return Global.ROSEGOLD;
/*  87 */       case 16: return Global.SILVER;
/*  88 */       case 17: return Global.STEEL;
/*  89 */       case 18: return Global.STERLINGSILVER;
/*  90 */       case 19: return Global.TIN;
/*  91 */       case 20: return Global.ZINC;
/*  92 */       case 21: return Global.ELECTRUM;
/*  93 */       case 22: return Global.CUPRONICKEL;
/*     */     } 
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/* 100 */     return this.metalAmount;
/*     */   }
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 108 */     return ISmeltable.EnumTier.TierI;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemNugget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */