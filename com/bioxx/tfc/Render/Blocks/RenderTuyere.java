/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderTuyere
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderblocks) {
/* 15 */     if ((world.func_72805_g(i, j, k) & 0x8) > 0) {
/* 16 */       renderblocks.func_147782_a(0.0D, 0.4D, 0.4D, 1.0D, 0.6D, 0.6D);
/*    */     } else {
/* 18 */       renderblocks.func_147782_a(0.4D, 0.4D, 0.0D, 0.6D, 0.6D, 1.0D);
/*    */     } 
/* 20 */     renderblocks.func_147784_q(block, i, j, k);
/*    */     
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 28 */     renderer.func_147782_a(0.0D, 0.4D, 0.4D, 1.0D, 0.6D, 0.6D);
/* 29 */     renderInvBlock(block, renderer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 41 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderInvBlock(Block block, RenderBlocks renderer) {
/* 46 */     Tessellator var14 = Tessellator.field_78398_a;
/* 47 */     var14.func_78382_b();
/* 48 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 49 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 1));
/* 50 */     var14.func_78381_a();
/* 51 */     var14.func_78382_b();
/* 52 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 53 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, 1));
/* 54 */     var14.func_78381_a();
/* 55 */     var14.func_78382_b();
/* 56 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 57 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, 0));
/* 58 */     var14.func_78381_a();
/* 59 */     var14.func_78382_b();
/* 60 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 61 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, 0));
/* 62 */     var14.func_78381_a();
/* 63 */     var14.func_78382_b();
/* 64 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 65 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, 0));
/* 66 */     var14.func_78381_a();
/* 67 */     var14.func_78382_b();
/* 68 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 69 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, 0));
/* 70 */     var14.func_78381_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderTuyere.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */