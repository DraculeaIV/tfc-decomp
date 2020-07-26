/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Items.ItemTerra;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public abstract class ItemMetalBlock
/*    */   extends ItemTerraBlock
/*    */   implements ISmeltable
/*    */ {
/*    */   private boolean smeltable = true;
/*    */   protected short metalAmount;
/*    */   
/*    */   public ItemMetalBlock(Block b) {
/* 22 */     super(b);
/* 23 */     this.metalAmount = 800;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumSize getSize(ItemStack is) {
/* 28 */     return EnumSize.LARGE;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getMetalReturnAmount(ItemStack is) {
/* 34 */     return this.metalAmount;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 40 */     ItemTerra.addSizeInformation(is, arraylist);
/* 41 */     addExtraInformation(is, player, arraylist);
/*    */     
/* 43 */     if (is.func_77942_o())
/*    */     {
/* 45 */       if (TFC_ItemHeat.hasTemp(is)) {
/*    */         
/* 47 */         float temp = TFC_ItemHeat.getTemp(is);
/* 48 */         float meltTemp = TFC_ItemHeat.isCookable(is);
/*    */         
/* 50 */         if (meltTemp != -1.0F)
/*    */         {
/* 52 */           if (is.func_77973_b() == TFCItems.stick) {
/* 53 */             arraylist.add(TFC_ItemHeat.getHeatColorTorch(temp, meltTemp));
/*    */           } else {
/* 55 */             arraylist.add(TFC_ItemHeat.getHeatColor(temp, meltTemp));
/*    */           } 
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 63 */     if (getMetalType(is) != null)
/*    */     {
/* 65 */       if (TFC_Core.showShiftInformation()) {
/*    */         
/* 67 */         arraylist.add(TFC_Core.translate("gui.units") + ": " + getMetalReturnAmount(is));
/*    */       }
/*    */       else {
/*    */         
/* 71 */         arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSmeltable(ItemStack is) {
/* 79 */     return this.smeltable;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/* 85 */     return ISmeltable.EnumTier.TierI;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemMetalBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */