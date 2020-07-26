/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ public class ItemCustomWoodH2
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemCustomWoodH2(Block b) {
/* 11 */     super(b);
/* 12 */     this.metaNames = new String[16];
/* 13 */     System.arraycopy(Global.WOOD_ALL, 8, this.metaNames, 0, 8);
/* 14 */     System.arraycopy(Global.WOOD_ALL, 8, this.metaNames, 8, 8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemCustomWoodH2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */