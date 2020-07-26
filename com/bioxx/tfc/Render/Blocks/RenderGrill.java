/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockGrill;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderGrill
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  56 */     BlockGrill grill = (BlockGrill)block;
/*  57 */     int meta = world.func_72805_g(i, j, k);
/*     */     
/*  59 */     if (!grill.isGrillOpen(meta)) {
/*  60 */       renderer.func_147782_a(0.0D, -0.05000000074505806D, 0.0D, 1.0D, 0.0D, 1.0D);
/*     */     }
/*  62 */     renderer.func_147784_q(block, i, j, k);
/*     */     
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  69 */     renderer.field_147875_q = i;
/*  70 */     renderer.field_147873_r = i;
/*  71 */     renderer.field_147869_t = i;
/*  72 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 107 */     renderer.func_147782_a(0.0D, 0.5D, 0.0D, 1.0D, 0.550000011920929D, 1.0D);
/* 108 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 121 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 126 */     Tessellator var14 = Tessellator.field_78398_a;
/* 127 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 128 */     var14.func_78382_b();
/* 129 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 130 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 131 */     var14.func_78381_a();
/* 132 */     var14.func_78382_b();
/* 133 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 134 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 135 */     var14.func_78381_a();
/* 136 */     var14.func_78382_b();
/* 137 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 138 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 139 */     var14.func_78381_a();
/* 140 */     var14.func_78382_b();
/* 141 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 142 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 143 */     var14.func_78381_a();
/* 144 */     var14.func_78382_b();
/* 145 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 146 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 147 */     var14.func_78381_a();
/* 148 */     var14.func_78382_b();
/* 149 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 150 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 151 */     var14.func_78381_a();
/* 152 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */