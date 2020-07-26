/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderGrass
/*    */ {
/*    */   public static boolean render(Block block, int x, int y, int z, RenderBlocks renderer) {
/* 12 */     float red = 1.0F;
/* 13 */     float green = 1.0F;
/* 14 */     float blue = 1.0F;
/*    */     
/* 16 */     if (block == TFCBlocks.grass || block == TFCBlocks.dryGrass) {
/* 17 */       renderer.func_147751_a(TFCBlocks.dirt, x, y, z, red, blue, green);
/* 18 */     } else if (block == TFCBlocks.grass2 || block == TFCBlocks.dryGrass2) {
/* 19 */       renderer.func_147751_a(TFCBlocks.dirt2, x, y, z, red, blue, green);
/*    */     } 
/* 21 */     renderer.func_147784_q(block, x, y, z);
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean renderClay(Block block, int x, int y, int z, RenderBlocks renderer) {
/* 28 */     float red = 1.0F;
/* 29 */     float green = 1.0F;
/* 30 */     float blue = 1.0F;
/*    */     
/* 32 */     if (block == TFCBlocks.clayGrass) {
/* 33 */       renderer.func_147751_a(TFCBlocks.clay, x, y, z, red, blue, green);
/* 34 */     } else if (block == TFCBlocks.clayGrass2) {
/* 35 */       renderer.func_147751_a(TFCBlocks.clay2, x, y, z, red, blue, green);
/*    */     } 
/* 37 */     renderer.func_147784_q(block, x, y, z);
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean renderPeat(Block block, int x, int y, int z, RenderBlocks renderer) {
/* 44 */     float red = 1.0F;
/* 45 */     float green = 1.0F;
/* 46 */     float blue = 1.0F;
/*    */     
/* 48 */     renderer.func_147751_a(TFCBlocks.peat, x, y, z, red, blue, green);
/*    */     
/* 50 */     renderer.func_147784_q(block, x, y, z);
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */