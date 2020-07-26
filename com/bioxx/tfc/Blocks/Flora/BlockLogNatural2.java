/*    */ package com.bioxx.tfc.Blocks.Flora;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockLogNatural2
/*    */   extends BlockLogNatural
/*    */ {
/*    */   public BlockLogNatural2() {
/* 15 */     this.woodNames = new String[Global.WOOD_ALL.length - 16];
/* 16 */     System.arraycopy(Global.WOOD_ALL, 16, this.woodNames, 0, Global.WOOD_ALL.length - 16);
/* 17 */     this.sideIcons = new IIcon[this.woodNames.length];
/* 18 */     this.innerIcons = new IIcon[this.woodNames.length];
/* 19 */     this.rotatedSideIcons = new IIcon[this.woodNames.length];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int dmg) {
/* 25 */     dmg += 16; return dmg;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int side, int meta) {
/* 32 */     if (meta >= this.woodNames.length)
/* 33 */       meta = 0; 
/* 34 */     if (side == 0 || side == 1)
/* 35 */       return this.innerIcons[meta]; 
/* 36 */     return this.sideIcons[meta];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockLogNatural2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */