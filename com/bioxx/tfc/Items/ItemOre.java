/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemOre
/*     */   extends ItemTerra
/*     */   implements ISmeltable
/*     */ {
/*     */   public ItemOre() {
/*  25 */     func_77656_e(0);
/*  26 */     func_77627_a(true);
/*  27 */     this.metaNames = new String[] { "Native Copper", "Native Gold", "Native Platinum", "Hematite", "Native Silver", "Cassiterite", "Galena", "Bismuthinite", "Garnierite", "Malachite", "Magnetite", "Limonite", "Sphalerite", "Tetrahedrite", "Bituminous Coal", "Lignite", "Kaolinite", "Gypsum", "Satinspar", "Selenite", "Graphite", "Kimberlite", "Petrified Wood", "Sulfur", "Jet", "Microcline", "Pitchblende", "Cinnabar", "Cryolite", "Saltpeter", "Serpentine", "Sylvite", "Borax", "Olivine", "Lapis Lazuli", "Rich Native Copper", "Rich Native Gold", "Rich Native Platinum", "Rich Hematite", "Rich Native Silver", "Rich Cassiterite", "Rich Galena", "Rich Bismuthinite", "Rich Garnierite", "Rich Malachite", "Rich Magnetite", "Rich Limonite", "Rich Sphalerite", "Rich Tetrahedrite", "Poor Native Copper", "Poor Native Gold", "Poor Native Platinum", "Poor Hematite", "Poor Native Silver", "Poor Cassiterite", "Poor Galena", "Poor Bismuthinite", "Poor Garnierite", "Poor Malachite", "Poor Magnetite", "Poor Limonite", "Poor Sphalerite", "Poor Tetrahedrite" };
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
/*  38 */     setFolder("ore/");
/*  39 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  45 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  51 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  57 */     this.metaIcons = new net.minecraft.util.IIcon[this.metaNames.length];
/*  58 */     for (int i = 0; i < this.metaNames.length; i++)
/*     */     {
/*  60 */       this.metaIcons[i] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[i] + " Ore");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  67 */     if (getMetalType(is) != null)
/*     */     {
/*  69 */       if (TFC_Core.showShiftInformation()) {
/*     */         
/*  71 */         arraylist.add(TFC_Core.translate("gui.units") + ": " + getMetalReturnAmount(is));
/*     */       }
/*     */       else {
/*     */         
/*  75 */         arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/*  83 */     int dam = is.func_77960_j();
/*  84 */     switch (dam) {
/*     */       case 0:
/*  86 */         return Global.COPPER;
/*  87 */       case 1: return Global.GOLD;
/*  88 */       case 2: return Global.PLATINUM;
/*  89 */       case 3: return Global.PIGIRON;
/*  90 */       case 4: return Global.SILVER;
/*  91 */       case 5: return Global.TIN;
/*  92 */       case 6: return Global.LEAD;
/*  93 */       case 7: return Global.BISMUTH;
/*  94 */       case 8: return Global.NICKEL;
/*  95 */       case 9: return Global.COPPER;
/*  96 */       case 10: return Global.PIGIRON;
/*  97 */       case 11: return Global.PIGIRON;
/*  98 */       case 12: return Global.ZINC;
/*  99 */       case 13: return Global.COPPER;
/*     */       case 35:
/* 101 */         return Global.COPPER;
/* 102 */       case 36: return Global.GOLD;
/* 103 */       case 37: return Global.PLATINUM;
/* 104 */       case 38: return Global.PIGIRON;
/* 105 */       case 39: return Global.SILVER;
/* 106 */       case 40: return Global.TIN;
/* 107 */       case 41: return Global.LEAD;
/* 108 */       case 42: return Global.BISMUTH;
/* 109 */       case 43: return Global.NICKEL;
/* 110 */       case 44: return Global.COPPER;
/* 111 */       case 45: return Global.PIGIRON;
/* 112 */       case 46: return Global.PIGIRON;
/* 113 */       case 47: return Global.ZINC;
/* 114 */       case 48: return Global.COPPER;
/*     */       case 49:
/* 116 */         return Global.COPPER;
/* 117 */       case 50: return Global.GOLD;
/* 118 */       case 51: return Global.PLATINUM;
/* 119 */       case 52: return Global.PIGIRON;
/* 120 */       case 53: return Global.SILVER;
/* 121 */       case 54: return Global.TIN;
/* 122 */       case 55: return Global.LEAD;
/* 123 */       case 56: return Global.BISMUTH;
/* 124 */       case 57: return Global.NICKEL;
/* 125 */       case 58: return Global.COPPER;
/* 126 */       case 59: return Global.PIGIRON;
/* 127 */       case 60: return Global.PIGIRON;
/* 128 */       case 61: return Global.ZINC;
/* 129 */       case 62: return Global.COPPER;
/*     */     } 
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/* 137 */     int dam = is.func_77960_j();
/* 138 */     switch (dam) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*     */       case 10:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/* 153 */         return (short)TFCOptions.normalOreUnits;
/*     */       case 35: case 36:
/*     */       case 37:
/*     */       case 38:
/*     */       case 39:
/*     */       case 40:
/*     */       case 41:
/*     */       case 42:
/*     */       case 43:
/*     */       case 44:
/*     */       case 45:
/*     */       case 46:
/*     */       case 47:
/*     */       case 48:
/* 167 */         return (short)TFCOptions.richOreUnits;
/*     */       case 49: case 50:
/*     */       case 51:
/*     */       case 52:
/*     */       case 53:
/*     */       case 54:
/*     */       case 55:
/*     */       case 56:
/*     */       case 57:
/*     */       case 58:
/*     */       case 59:
/*     */       case 60:
/*     */       case 61:
/*     */       case 62:
/* 181 */         return (short)TFCOptions.poorOreUnits;
/*     */     } 
/* 183 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/* 189 */     switch (is.func_77960_j()) {
/*     */       
/*     */       case 0:
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/*     */       case 9:
/*     */       case 10:
/*     */       case 11:
/*     */       case 12:
/*     */       case 13:
/*     */       case 35:
/*     */       case 36:
/*     */       case 37:
/*     */       case 38:
/*     */       case 39:
/*     */       case 40:
/*     */       case 41:
/*     */       case 42:
/*     */       case 43:
/*     */       case 44:
/*     */       case 45:
/*     */       case 46:
/*     */       case 47:
/*     */       case 48:
/*     */       case 49:
/*     */       case 50:
/*     */       case 51:
/*     */       case 52:
/*     */       case 53:
/*     */       case 54:
/*     */       case 55:
/*     */       case 56:
/*     */       case 57:
/*     */       case 58:
/*     */       case 59:
/*     */       case 60:
/*     */       case 61:
/*     */       case 62:
/* 233 */         return true;
/*     */     } 
/* 235 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 242 */     int dam = is.func_77960_j();
/* 243 */     switch (dam) {
/*     */       case 0:
/* 245 */         return ISmeltable.EnumTier.TierI;
/* 246 */       case 1: return ISmeltable.EnumTier.TierI;
/* 247 */       case 2: return ISmeltable.EnumTier.TierIV;
/* 248 */       case 3: return ISmeltable.EnumTier.TierIII;
/* 249 */       case 4: return ISmeltable.EnumTier.TierI;
/* 250 */       case 5: return ISmeltable.EnumTier.TierI;
/* 251 */       case 6: return ISmeltable.EnumTier.TierI;
/* 252 */       case 7: return ISmeltable.EnumTier.TierI;
/* 253 */       case 8: return ISmeltable.EnumTier.TierIII;
/* 254 */       case 9: return ISmeltable.EnumTier.TierI;
/* 255 */       case 10: return ISmeltable.EnumTier.TierIII;
/* 256 */       case 11: return ISmeltable.EnumTier.TierIII;
/* 257 */       case 12: return ISmeltable.EnumTier.TierI;
/* 258 */       case 13: return ISmeltable.EnumTier.TierI;
/*     */       case 35:
/* 260 */         return ISmeltable.EnumTier.TierI;
/* 261 */       case 36: return ISmeltable.EnumTier.TierI;
/* 262 */       case 37: return ISmeltable.EnumTier.TierIV;
/* 263 */       case 38: return ISmeltable.EnumTier.TierIII;
/* 264 */       case 39: return ISmeltable.EnumTier.TierI;
/* 265 */       case 40: return ISmeltable.EnumTier.TierI;
/* 266 */       case 41: return ISmeltable.EnumTier.TierI;
/* 267 */       case 42: return ISmeltable.EnumTier.TierI;
/* 268 */       case 43: return ISmeltable.EnumTier.TierIII;
/* 269 */       case 44: return ISmeltable.EnumTier.TierI;
/* 270 */       case 45: return ISmeltable.EnumTier.TierIII;
/* 271 */       case 46: return ISmeltable.EnumTier.TierIII;
/* 272 */       case 47: return ISmeltable.EnumTier.TierI;
/* 273 */       case 48: return ISmeltable.EnumTier.TierI;
/*     */       case 49:
/* 275 */         return ISmeltable.EnumTier.TierI;
/* 276 */       case 50: return ISmeltable.EnumTier.TierI;
/* 277 */       case 51: return ISmeltable.EnumTier.TierIV;
/* 278 */       case 52: return ISmeltable.EnumTier.TierIII;
/* 279 */       case 53: return ISmeltable.EnumTier.TierI;
/* 280 */       case 54: return ISmeltable.EnumTier.TierI;
/* 281 */       case 55: return ISmeltable.EnumTier.TierI;
/* 282 */       case 56: return ISmeltable.EnumTier.TierI;
/* 283 */       case 57: return ISmeltable.EnumTier.TierIII;
/* 284 */       case 58: return ISmeltable.EnumTier.TierI;
/* 285 */       case 59: return ISmeltable.EnumTier.TierIII;
/* 286 */       case 60: return ISmeltable.EnumTier.TierIII;
/* 287 */       case 61: return ISmeltable.EnumTier.TierI;
/* 288 */       case 62: return ISmeltable.EnumTier.TierI;
/*     */     } 
/* 290 */     return ISmeltable.EnumTier.TierX;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */