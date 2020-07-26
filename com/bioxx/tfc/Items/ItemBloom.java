/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemBloom
/*    */   extends ItemTerra
/*    */   implements ISmeltable
/*    */ {
/*    */   public ItemBloom() {
/* 24 */     func_77627_a(true);
/* 25 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/* 26 */     setWeight(EnumWeight.HEAVY);
/* 27 */     setSize(EnumSize.LARGE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canStack() {
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 40 */     arraylist.add(TFC_Core.translate("gui.units") + ": " + is.func_77960_j());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 46 */     list.add(new ItemStack(this, 1, 100));
/* 47 */     list.add(new ItemStack(this, 1, 200));
/* 48 */     list.add(new ItemStack(this, 1, 300));
/* 49 */     list.add(new ItemStack(this, 1, 400));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Metal getMetalType(ItemStack is) {
/* 55 */     if (this == TFCItems.rawBloom) {
/* 56 */       return Global.UNKNOWN;
/*    */     }
/* 58 */     return Global.WROUGHTIRON;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getMetalReturnAmount(ItemStack is) {
/* 64 */     return (short)is.func_77960_j();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSmeltable(ItemStack is) {
/* 70 */     return (this == TFCItems.bloom);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 76 */     return ISmeltable.EnumTier.TierIII;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBloom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */