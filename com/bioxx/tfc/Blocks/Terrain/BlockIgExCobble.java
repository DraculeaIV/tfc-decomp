/*    */ package com.bioxx.tfc.Blocks.Terrain;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockIgExCobble
/*    */   extends BlockCobble
/*    */ {
/*    */   public BlockIgExCobble(Material material) {
/* 13 */     super(material);
/* 14 */     this.names = Global.STONE_IGEX;
/* 15 */     this.icons = new net.minecraft.util.IIcon[this.names.length];
/* 16 */     this.looseStart = Global.STONE_IGEX_START;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149738_a(World world) {
/* 23 */     return 20;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockIgExCobble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */