/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ public class ItemArmourStand2
/*    */   extends ItemArmourStand
/*    */ {
/*    */   public ItemArmourStand2(Block par1) {
/* 11 */     super(par1);
/* 12 */     this.metaNames = new String[Global.WOOD_ALL.length - 16];
/* 13 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, 0, Global.WOOD_ALL.length - 16);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int getOffset() {
/* 19 */     return 16;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemArmourStand2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */