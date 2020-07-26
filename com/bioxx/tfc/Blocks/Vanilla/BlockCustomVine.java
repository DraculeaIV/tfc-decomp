/*    */ package com.bioxx.tfc.Blocks.Vanilla;
/*    */ 
/*    */ import com.bioxx.tfc.Core.ColorizerFoliageTFC;
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.BlockVine;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.common.IShearable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockCustomVine
/*    */   extends BlockVine
/*    */   implements IShearable
/*    */ {
/*    */   public BlockCustomVine() {
/* 20 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149635_D() {
/* 26 */     return ColorizerFoliageTFC.getFoliageColorBasic();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149741_i(int par1) {
/* 32 */     return (par1 == 0) ? 16777215 : ColorizerFoliageTFC.getFoliageColorBasic();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/* 39 */     return TerraFirmaCraft.proxy.foliageColorMultiplier(bAccess, x, y, z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomVine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */