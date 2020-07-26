/*    */ package com.bioxx.tfc.Core;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class TFCTabs
/*    */   extends CreativeTabs
/*    */ {
/* 12 */   public static final CreativeTabs TFC_BUILDING = new TFCTabs("TFCBuilding");
/* 13 */   public static final CreativeTabs TFC_DECORATION = new TFCTabs("TFCDecoration");
/* 14 */   public static final CreativeTabs TFC_DEVICES = new TFCTabs("TFCDevices");
/* 15 */   public static final CreativeTabs TFC_POTTERY = new TFCTabs("TFCPottery");
/* 16 */   public static final CreativeTabs TFC_MISC = new TFCTabs("TFCMisc");
/* 17 */   public static final CreativeTabs TFC_FOODS = new TFCTabs("TFCFoods");
/* 18 */   public static final CreativeTabs TFC_TOOLS = new TFCTabs("TFCTools");
/* 19 */   public static final CreativeTabs TFC_WEAPONS = new TFCTabs("TFCWeapons");
/* 20 */   public static final CreativeTabs TFC_ARMOR = new TFCTabs("TFCArmor");
/* 21 */   public static final CreativeTabs TFC_MATERIALS = new TFCTabs("TFCMaterials");
/*    */ 
/*    */   
/*    */   private ItemStack is;
/*    */ 
/*    */   
/*    */   public TFCTabs(String par2Str) {
/* 28 */     super(par2Str);
/*    */   }
/*    */ 
/*    */   
/*    */   public TFCTabs(String par2Str, int icon) {
/* 33 */     super(par2Str);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_78016_d() {
/* 41 */     return this.is.func_77973_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTabIconItem(Item i) {
/* 46 */     this.is = new ItemStack(i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_151244_d() {
/* 52 */     return this.is;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTabIconItemStack(ItemStack stack) {
/* 57 */     this.is = stack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_78024_c() {
/* 64 */     return TFC_Core.translate("itemGroup." + func_78013_b());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\TFCTabs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */