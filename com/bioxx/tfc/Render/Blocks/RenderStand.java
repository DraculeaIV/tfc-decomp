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
/*     */ public class RenderStand
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  24 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  29 */     renderer.field_147875_q = i;
/*  30 */     renderer.field_147873_r = i;
/*  31 */     renderer.field_147869_t = i;
/*  32 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/*  38 */     Block blockToRender = (block == TFCBlocks.armorStand) ? TFCBlocks.planks : TFCBlocks.planks2;
/*  39 */     Block woodblock = (block == TFCBlocks.armorStand) ? TFCBlocks.woodSupportH : TFCBlocks.woodSupportH2;
/*     */     
/*  41 */     float yScale = 0.7F;
/*  42 */     float blockScale = 0.5F;
/*     */ 
/*     */     
/*  45 */     renderer.func_147782_a((0.44F * blockScale), (1.45F * yScale * blockScale), (0.2F * blockScale), (0.56F * blockScale), (1.55F * yScale * blockScale), (0.8F * blockScale));
/*  46 */     renderInvBlock(woodblock, metadata, renderer);
/*     */     
/*  48 */     renderer.func_147782_a((0.45F * blockScale), (0.201F * yScale * blockScale), (0.35F * blockScale), (0.55F * blockScale), (1.45F * yScale * blockScale), (0.45F * blockScale));
/*  49 */     renderInvBlock(woodblock, metadata, renderer);
/*     */     
/*  51 */     renderer.func_147782_a((0.45F * blockScale), (0.201F * yScale * blockScale), (0.55F * blockScale), (0.55F * blockScale), (1.45F * yScale * blockScale), (0.65F * blockScale));
/*  52 */     renderInvBlock(woodblock, metadata, renderer);
/*     */ 
/*     */     
/*  55 */     renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.20000000298023224D, 0.800000011920929D, 0.2D * yScale, 0.800000011920929D);
/*  56 */     renderInvBlock(blockToRender, metadata, renderer, false);
/*     */ 
/*     */     
/*  59 */     renderer.func_147782_a((0.45F * blockScale), (1.45F * yScale * blockScale), (0.45F * blockScale), (0.55F * blockScale), (1.9F * yScale * blockScale), (0.55F * blockScale));
/*  60 */     renderInvBlock(woodblock, metadata, renderer);
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
/*  77 */     renderInvBlock(block, m, renderer, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer, boolean b) {
/*  82 */     Tessellator var14 = Tessellator.field_78398_a;
/*  83 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/*  84 */     if (b) GL11.glScalef(2.0F, 2.0F, 2.0F); 
/*  85 */     var14.func_78382_b();
/*  86 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/*  87 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/*  88 */     var14.func_78381_a();
/*  89 */     var14.func_78382_b();
/*  90 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/*  91 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/*  92 */     var14.func_78381_a();
/*  93 */     var14.func_78382_b();
/*  94 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/*  95 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/*  96 */     var14.func_78381_a();
/*  97 */     var14.func_78382_b();
/*  98 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/*  99 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 100 */     var14.func_78381_a();
/* 101 */     var14.func_78382_b();
/* 102 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 103 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 104 */     var14.func_78381_a();
/* 105 */     var14.func_78382_b();
/* 106 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 107 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 108 */     var14.func_78381_a();
/* 109 */     if (b) GL11.glScalef(0.5F, 0.5F, 0.5F); 
/* 110 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */