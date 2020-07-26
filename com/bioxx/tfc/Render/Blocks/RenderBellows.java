/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.Devices.BlockBellows;
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderBellows
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 19 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 26 */     renderer.field_147840_d = BlockBellows.bellowsFront;
/* 27 */     renderer.func_147782_a(0.0D, 0.0D, 0.8999999761581421D, 1.0D, 1.0D, 1.0D);
/* 28 */     renderInvBlock(block, renderer);
/*    */     
/* 30 */     renderer.func_147771_a();
/* 31 */     renderer.func_147782_a(0.10000000149011612D, 0.10000000149011612D, 0.05000000074505806D, 0.8999999761581421D, 0.8999999761581421D, 0.949999988079071D);
/* 32 */     renderInvBlock(block, renderer);
/*    */     
/* 34 */     renderer.field_147840_d = BlockBellows.bellowsBack;
/* 35 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.10000000149011612D);
/* 36 */     renderInvBlock(block, renderer);
/*    */     
/* 38 */     renderer.func_147771_a();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 51 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderInvBlock(Block block, RenderBlocks renderer) {
/* 56 */     Tessellator var14 = Tessellator.field_78398_a;
/* 57 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 58 */     var14.func_78382_b();
/* 59 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 60 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 2));
/* 61 */     var14.func_78381_a();
/* 62 */     var14.func_78382_b();
/* 63 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 64 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 2));
/* 65 */     var14.func_78381_a();
/* 66 */     var14.func_78382_b();
/* 67 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 68 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 1));
/* 69 */     var14.func_78381_a();
/* 70 */     var14.func_78382_b();
/* 71 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 72 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 3));
/* 73 */     var14.func_78381_a();
/* 74 */     var14.func_78382_b();
/* 75 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 76 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 0));
/* 77 */     var14.func_78381_a();
/* 78 */     var14.func_78382_b();
/* 79 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 80 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 0));
/* 81 */     var14.func_78381_a();
/* 82 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */