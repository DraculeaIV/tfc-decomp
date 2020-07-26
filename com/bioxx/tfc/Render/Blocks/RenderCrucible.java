/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
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
/*     */ public class RenderCrucible
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  18 */     float s0 = 0.0F;
/*  19 */     float s1 = 0.0625F;
/*     */     
/*  21 */     float s3 = 0.1875F;
/*     */     
/*  23 */     float s13 = 0.8125F;
/*     */     
/*  25 */     float s15 = 0.9375F;
/*     */     
/*  27 */     renderer.func_147782_a(s1, s0, s1, s15, s1, s15);
/*  28 */     renderer.func_147784_q(block, i, j, k);
/*  29 */     renderer.func_147782_a(s1, s1, s3, s3, s15, s13);
/*  30 */     renderer.func_147784_q(block, i, j, k);
/*  31 */     renderer.func_147782_a(s13, s1, s3, s15, s15, s13);
/*  32 */     renderer.func_147784_q(block, i, j, k);
/*  33 */     renderer.func_147782_a(s1, s1, s1, s15, s15, s3);
/*  34 */     renderer.func_147784_q(block, i, j, k);
/*  35 */     renderer.func_147782_a(s1, s1, s13, s15, s15, s15);
/*  36 */     renderer.func_147784_q(block, i, j, k);
/*  37 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/*  43 */     float s0 = 0.0F;
/*  44 */     float s1 = 0.0625F;
/*     */     
/*  46 */     float s3 = 0.1875F;
/*  47 */     float s13 = 0.8125F;
/*     */     
/*  49 */     float s15 = 0.9375F;
/*     */     
/*  51 */     renderer.func_147782_a(s1, s0, s1, s15, s1, s15);
/*  52 */     renderInvBlock(block, metadata, renderer);
/*  53 */     renderer.func_147782_a(s1, s1, s3, s3, s15, s13);
/*  54 */     renderInvBlock(block, metadata, renderer);
/*  55 */     renderer.func_147782_a(s13, s1, s3, s15, s15, s13);
/*  56 */     renderInvBlock(block, metadata, renderer);
/*  57 */     renderer.func_147782_a(s1, s1, s1, s15, s15, s3);
/*  58 */     renderInvBlock(block, metadata, renderer);
/*  59 */     renderer.func_147782_a(s1, s1, s13, s15, s15, s15);
/*  60 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/*  72 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/*  77 */     Tessellator var14 = Tessellator.field_78398_a;
/*  78 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/*  79 */     var14.func_78382_b();
/*  80 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/*  81 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/*  82 */     var14.func_78381_a();
/*  83 */     var14.func_78382_b();
/*  84 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/*  85 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/*  86 */     var14.func_78381_a();
/*  87 */     var14.func_78382_b();
/*  88 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/*  89 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/*  90 */     var14.func_78381_a();
/*  91 */     var14.func_78382_b();
/*  92 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/*  93 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/*  94 */     var14.func_78381_a();
/*  95 */     var14.func_78382_b();
/*  96 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/*  97 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/*  98 */     var14.func_78381_a();
/*  99 */     var14.func_78382_b();
/* 100 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 101 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 102 */     var14.func_78381_a();
/* 103 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */