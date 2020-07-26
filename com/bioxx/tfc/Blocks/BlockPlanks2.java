/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPlanks2
/*    */   extends BlockPlanks
/*    */ {
/*    */   public BlockPlanks2(Material material) {
/* 13 */     super(Material.field_151575_d);
/* 14 */     func_149647_a(TFCTabs.TFC_BUILDING);
/* 15 */     this.woodNames = new String[Global.WOOD_ALL.length - 16];
/* 16 */     System.arraycopy(Global.WOOD_ALL, 16, this.woodNames, 0, Global.WOOD_ALL.length - 16);
/* 17 */     this.icons = new net.minecraft.util.IIcon[this.woodNames.length];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockPlanks2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */