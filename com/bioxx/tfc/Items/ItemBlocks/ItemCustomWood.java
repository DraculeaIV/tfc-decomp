/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ public class ItemCustomWood
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemCustomWood(Block b) {
/* 11 */     super(b);
/* 12 */     this.metaNames = new String[16];
/* 13 */     System.arraycopy(Global.WOOD_ALL, 0, this.metaNames, 0, 16);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemCustomWood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */