/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderOilLamp
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 21 */     renderer.field_147837_f = true;
/*    */     
/* 23 */     renderer.func_147782_a(0.275D, 0.0D, 0.275D, 0.725D, 0.0625D, 0.725D);
/* 24 */     renderer.func_147784_q(block, x, y, z);
/* 25 */     renderer.func_147782_a(0.25D, 0.0625D, 0.25D, 0.75D, 0.375D, 0.75D);
/* 26 */     renderer.func_147784_q(block, x, y, z);
/* 27 */     renderer.func_147782_a(0.3125D, 0.375D, 0.3125D, 0.6875D, 0.4375D, 0.6875D);
/* 28 */     renderer.func_147784_q(block, x, y, z);
/* 29 */     renderer.func_147782_a(0.375D, 0.4375D, 0.375D, 0.625D, 0.5D, 0.625D);
/* 30 */     renderer.func_147784_q(block, x, y, z);
/* 31 */     renderer.func_147782_a(0.46875D, 0.5D, 0.46875D, 0.53125D, 0.5625D, 0.53125D);
/* 32 */     renderer.func_147784_q(Blocks.field_150433_aE, x, y, z);
/* 33 */     renderer.field_147837_f = false;
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
/* 40 */     renderer.func_147782_a(0.275D, 0.0D, 0.275D, 0.725D, 0.0625D, 0.725D);
/* 41 */     renderInvBlock(block, meta, renderer);
/* 42 */     renderer.func_147782_a(0.25D, 0.0625D, 0.25D, 0.75D, 0.375D, 0.75D);
/* 43 */     renderInvBlock(block, meta, renderer);
/* 44 */     renderer.func_147782_a(0.3125D, 0.375D, 0.3125D, 0.6875D, 0.4375D, 0.6875D);
/* 45 */     renderInvBlock(block, meta, renderer);
/* 46 */     renderer.func_147782_a(0.375D, 0.4375D, 0.375D, 0.625D, 0.5D, 0.625D);
/* 47 */     renderInvBlock(block, meta, renderer);
/* 48 */     renderer.func_147782_a(0.46875D, 0.5D, 0.46875D, 0.53125D, 0.5625D, 0.53125D);
/* 49 */     renderInvBlock(Blocks.field_150433_aE, meta, renderer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 61 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 66 */     Tessellator var14 = Tessellator.field_78398_a;
/* 67 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 68 */     var14.func_78382_b();
/* 69 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 70 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 71 */     var14.func_78381_a();
/* 72 */     var14.func_78382_b();
/* 73 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 74 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 75 */     var14.func_78381_a();
/* 76 */     var14.func_78382_b();
/* 77 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 78 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 79 */     var14.func_78381_a();
/* 80 */     var14.func_78382_b();
/* 81 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 82 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 83 */     var14.func_78381_a();
/* 84 */     var14.func_78382_b();
/* 85 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 86 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 87 */     var14.func_78381_a();
/* 88 */     var14.func_78382_b();
/* 89 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 90 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 91 */     var14.func_78381_a();
/* 92 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderOilLamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */