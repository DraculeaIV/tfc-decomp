/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
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
/*     */ public class RenderNestBox
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  25 */     renderer.field_147837_f = true;
/*  26 */     renderer.func_147782_a(0.15000000596046448D, 0.10000000149011612D, 0.15000000596046448D, 0.8500000238418579D, 0.10000000149011612D, 0.8500000238418579D);
/*  27 */     renderer.func_147784_q(TFCBlocks.planks, i, j, k);
/*     */     
/*  29 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.15000000596046448D, 0.15000000596046448D, 0.4000000059604645D, 0.8500000238418579D);
/*  30 */     rotate(renderer, 1);
/*  31 */     renderer.func_147784_q(TFCBlocks.planks, i, j, k);
/*  32 */     rotate(renderer, 0);
/*  33 */     renderer.func_147784_q(block, i, j, k);
/*     */     
/*  35 */     renderer.func_147782_a(0.8500000238418579D, 0.0D, 0.15000000596046448D, 0.8999999761581421D, 0.4000000059604645D, 0.8500000238418579D);
/*  36 */     rotate(renderer, 1);
/*  37 */     renderer.func_147784_q(TFCBlocks.planks, i, j, k);
/*  38 */     rotate(renderer, 0);
/*  39 */     renderer.func_147784_q(block, i, j, k);
/*     */     
/*  41 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.8999999761581421D, 0.4000000059604645D, 0.15000000596046448D);
/*  42 */     rotate(renderer, 1);
/*  43 */     renderer.func_147784_q(TFCBlocks.planks, i, j, k);
/*  44 */     rotate(renderer, 0);
/*  45 */     renderer.func_147784_q(block, i, j, k);
/*     */     
/*  47 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.8500000238418579D, 0.8999999761581421D, 0.4000000059604645D, 0.8999999761581421D);
/*  48 */     rotate(renderer, 1);
/*  49 */     renderer.func_147784_q(TFCBlocks.planks, i, j, k);
/*  50 */     rotate(renderer, 0);
/*  51 */     renderer.func_147784_q(block, i, j, k);
/*  52 */     renderer.field_147837_f = false;
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  58 */     renderer.field_147875_q = i;
/*  59 */     renderer.field_147873_r = i;
/*  60 */     renderer.field_147869_t = i;
/*  61 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/*  67 */     renderer.func_147782_a(0.15000000596046448D, 0.20000000298023224D, 0.15000000596046448D, 0.8500000238418579D, 0.10000000149011612D, 0.8500000238418579D);
/*  68 */     rotate(renderer, 1);
/*  69 */     renderInvBlock(TFCBlocks.planks, metadata, renderer);
/*     */     
/*  71 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.15000000596046448D, 0.15000000596046448D, 0.4000000059604645D, 0.8500000238418579D);
/*  72 */     rotate(renderer, 1);
/*  73 */     renderInvBlock(TFCBlocks.planks, metadata, renderer);
/*  74 */     rotate(renderer, 0);
/*  75 */     renderInvBlock(block, metadata, renderer);
/*     */     
/*  77 */     renderer.func_147782_a(0.8500000238418579D, 0.0D, 0.15000000596046448D, 0.8999999761581421D, 0.4000000059604645D, 0.8500000238418579D);
/*  78 */     rotate(renderer, 1);
/*  79 */     renderInvBlock(TFCBlocks.planks, metadata, renderer);
/*  80 */     rotate(renderer, 0);
/*  81 */     renderInvBlock(block, metadata, renderer);
/*     */     
/*  83 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.8999999761581421D, 0.4000000059604645D, 0.15000000596046448D);
/*  84 */     rotate(renderer, 1);
/*  85 */     renderInvBlock(TFCBlocks.planks, metadata, renderer);
/*  86 */     rotate(renderer, 0);
/*  87 */     renderInvBlock(block, metadata, renderer);
/*     */     
/*  89 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.8500000238418579D, 0.8999999761581421D, 0.4000000059604645D, 0.8999999761581421D);
/*  90 */     rotate(renderer, 1);
/*  91 */     renderInvBlock(TFCBlocks.planks, metadata, renderer);
/*  92 */     rotate(renderer, 0);
/*  93 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 105 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 110 */     Tessellator var14 = Tessellator.field_78398_a;
/* 111 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 112 */     var14.func_78382_b();
/* 113 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 114 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 115 */     var14.func_78381_a();
/* 116 */     var14.func_78382_b();
/* 117 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 118 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 119 */     var14.func_78381_a();
/* 120 */     var14.func_78382_b();
/* 121 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 122 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 123 */     var14.func_78381_a();
/* 124 */     var14.func_78382_b();
/* 125 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 126 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 127 */     var14.func_78381_a();
/* 128 */     var14.func_78382_b();
/* 129 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 130 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 131 */     var14.func_78381_a();
/* 132 */     var14.func_78382_b();
/* 133 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 134 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 135 */     var14.func_78381_a();
/* 136 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderNestBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */