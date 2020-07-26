/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSapling2
/*    */   extends ItemSapling
/*    */ {
/*    */   public ItemSapling2(Block b) {
/* 12 */     super(b);
/* 13 */     this.metaNames = new String[Global.WOOD_ALL.length - 16];
/* 14 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, 0, Global.WOOD_ALL.length - 16);
/* 15 */     this.icons = new net.minecraft.util.IIcon[this.metaNames.length];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemSapling2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */