/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemAnvil2
/*    */   extends ItemAnvil
/*    */ {
/*    */   public ItemAnvil2(Block par1) {
/* 13 */     super(par1);
/* 14 */     this.metaNames = new String[] { "Rose Gold", "Bismuth Bronze", "Black Bronze" };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Metal getMetalType(ItemStack is) {
/* 20 */     int meta = is.func_77960_j();
/* 21 */     switch (meta) {
/*    */       case 0:
/* 23 */         return Global.ROSEGOLD;
/* 24 */       case 1: return Global.BISMUTHBRONZE;
/* 25 */       case 2: return Global.BLACKBRONZE;
/* 26 */     }  return Global.UNKNOWN;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemAnvil2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */