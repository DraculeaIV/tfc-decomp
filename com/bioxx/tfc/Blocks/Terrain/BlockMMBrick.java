/*    */ package com.bioxx.tfc.Blocks.Terrain;
/*    */ 
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockMMBrick
/*    */   extends BlockMMSmooth
/*    */ {
/*    */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 17 */     for (int i = 0; i < this.names.length; i++)
/* 18 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:rocks/" + this.names[i] + " Brick"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockMMBrick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */