/*    */ package com.bioxx.tfc.Blocks.Terrain;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.material.Material;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockIgIn
/*    */   extends BlockStone
/*    */ {
/*    */   public BlockIgIn(Material material) {
/* 13 */     super(material);
/* 14 */     this.dropBlock = TFCBlocks.stoneIgInCobble;
/* 15 */     this.names = Global.STONE_IGIN;
/* 16 */     this.icons = new net.minecraft.util.IIcon[this.names.length];
/* 17 */     this.looseStart = 0;
/* 18 */     this.gemChance = 2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockIgIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */