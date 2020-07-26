/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockMetal2
/*    */   extends BlockMetal
/*    */ {
/*    */   public BlockMetal2(Material material) {
/* 26 */     super(Material.field_151573_f);
/* 27 */     func_149647_a(TFCTabs.TFC_MATERIALS);
/* 28 */     this.metalNames = new String[Global.METAL_ALL.length - 16];
/* 29 */     System.arraycopy(Global.METAL_ALL, 16, this.metalNames, 0, Global.METAL_ALL.length - 16);
/* 30 */     this.icons = new net.minecraft.util.IIcon[this.metalNames.length];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockMetal2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */