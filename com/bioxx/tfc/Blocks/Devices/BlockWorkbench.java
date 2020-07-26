/*    */ package com.bioxx.tfc.Blocks.Devices;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.BlockTerra;
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockWorkbench
/*    */   extends BlockTerra
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon topIcon;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon frontIcon;
/*    */   
/*    */   public BlockWorkbench() {
/* 23 */     super(Material.field_151575_d);
/* 24 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int par1, int par2) {
/* 31 */     if (par1 == 1)
/* 32 */       return this.topIcon; 
/* 33 */     if (par1 == 0)
/* 34 */       return TFCBlocks.planks.func_149733_h(par1); 
/* 35 */     if (par1 != 2 && par1 != 4) {
/* 36 */       return this.field_149761_L;
/*    */     }
/* 38 */     return this.frontIcon;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 45 */     this.field_149761_L = par1IconRegister.func_94245_a("crafting_table_side");
/* 46 */     this.topIcon = par1IconRegister.func_94245_a("crafting_table_top");
/* 47 */     this.frontIcon = par1IconRegister.func_94245_a("crafting_table_front");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockWorkbench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */