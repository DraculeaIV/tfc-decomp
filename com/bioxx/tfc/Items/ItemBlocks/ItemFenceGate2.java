/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ 
/*    */ public class ItemFenceGate2
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemFenceGate2(Block par1) {
/* 12 */     super(par1);
/* 13 */     this.metaNames = new String[Global.WOOD_ALL.length - 16];
/* 14 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, 0, Global.WOOD_ALL.length - 16);
/*    */   }
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemFenceGate2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */