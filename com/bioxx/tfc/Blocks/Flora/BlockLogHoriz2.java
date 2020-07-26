/*    */ package com.bioxx.tfc.Blocks.Flora;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockLogHoriz2
/*    */   extends BlockLogHoriz
/*    */ {
/*    */   public BlockLogHoriz2(int off) {
/* 15 */     super(off);
/* 16 */     int size = Global.WOOD_ALL.length - 16 - off;
/* 17 */     if (size < 0) size = 0; 
/* 18 */     this.woodNames = new String[size * 2];
/* 19 */     if (off < Global.WOOD_ALL.length - 16) {
/*    */       
/* 21 */       System.arraycopy(Global.WOOD_ALL, 16 + off, this.woodNames, 0, size);
/* 22 */       System.arraycopy(Global.WOOD_ALL, 16 + off, this.woodNames, size, size);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int side, int meta) {
/* 30 */     int dir = meta >> 3;
/* 31 */     meta = (meta & 0x7) + this.offset;
/* 32 */     if (meta >= ((BlockLogNatural2)TFCBlocks.logNatural2).sideIcons.length) {
/* 33 */       meta = 0;
/*    */     }
/* 35 */     if (dir == 0) {
/*    */       
/* 37 */       if (side == 0 || side == 1)
/* 38 */         return ((BlockLogNatural2)TFCBlocks.logNatural2).sideIcons[meta]; 
/* 39 */       if (side == 2 || side == 3) {
/* 40 */         return ((BlockLogNatural2)TFCBlocks.logNatural2).innerIcons[meta];
/*    */       }
/* 42 */       return ((BlockLogNatural2)TFCBlocks.logNatural2).rotatedSideIcons[meta];
/*    */     } 
/*    */ 
/*    */     
/* 46 */     if (side == 0 || side == 1 || side == 2 || side == 3) {
/* 47 */       return ((BlockLogNatural2)TFCBlocks.logNatural2).rotatedSideIcons[meta];
/*    */     }
/* 49 */     return ((BlockLogNatural2)TFCBlocks.logNatural2).innerIcons[meta];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int dmg) {
/* 56 */     return (dmg & 0x7) + this.offset + 16;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockLogHoriz2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */