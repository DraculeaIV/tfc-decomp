/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.Devices.BlockLeatherRack;
/*    */ import com.bioxx.tfc.TileEntities.TELeatherRack;
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderLeatherRack
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 19 */     TELeatherRack te = (TELeatherRack)world.func_147438_o(x, y, z);
/* 20 */     BlockLeatherRack blk = (BlockLeatherRack)block;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 26 */     boolean breaking = (renderer.field_147840_d != null);
/*    */     
/* 28 */     for (int k = 0; k < 4; k++) {
/*    */       
/* 30 */       for (int i = 0; i < 4; i++) {
/*    */         
/* 32 */         if ((te.workedArea >> k * 4 + i & 0x1) != 0 && !breaking)
/* 33 */           renderer.field_147840_d = blk.scrapedTex; 
/* 34 */         renderer.func_147782_a(0.25D * i, 0.0D, 0.25D * k, 0.25D * i + 0.25D, 0.001D, 0.25D * k + 0.25D);
/* 35 */         renderer.func_147784_q(block, x, y, z);
/* 36 */         if (!breaking)
/* 37 */           renderer.func_147771_a(); 
/*    */       } 
/*    */     } 
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 52 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 58 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderInvBlock(Block block, int meta, RenderBlocks renderer) {
/* 63 */     Tessellator tess = Tessellator.field_78398_a;
/* 64 */     tess.func_78382_b();
/* 65 */     tess.func_78375_b(0.0F, -1.0F, 0.0F);
/* 66 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 67 */     tess.func_78381_a();
/* 68 */     tess.func_78382_b();
/* 69 */     tess.func_78375_b(0.0F, 1.0F, 0.0F);
/* 70 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 71 */     tess.func_78381_a();
/* 72 */     tess.func_78382_b();
/* 73 */     tess.func_78375_b(0.0F, 0.0F, -1.0F);
/* 74 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 75 */     tess.func_78381_a();
/* 76 */     tess.func_78382_b();
/* 77 */     tess.func_78375_b(0.0F, 0.0F, 1.0F);
/* 78 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 79 */     tess.func_78381_a();
/* 80 */     tess.func_78382_b();
/* 81 */     tess.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 82 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 83 */     tess.func_78381_a();
/* 84 */     tess.func_78382_b();
/* 85 */     tess.func_78375_b(1.0F, 0.0F, 0.0F);
/* 86 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 87 */     tess.func_78381_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderLeatherRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */