/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEMetalSheet;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderMetalSheet
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean render(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/*  16 */     IBlockAccess access = renderblocks.field_147845_a;
/*  17 */     TEMetalSheet te = (TEMetalSheet)access.func_147438_o(i, j, k);
/*     */     
/*  19 */     double yMax = 1.0D;
/*  20 */     double yMin = 0.0D;
/*  21 */     double f0 = 0.0625D;
/*  22 */     double f1 = 0.9375D;
/*     */     
/*  24 */     if (te.bottomExists()) {
/*     */       
/*  26 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, f0, 1.0D);
/*  27 */       renderblocks.func_147784_q(block, i, j, k);
/*  28 */       yMin = 0.0625D;
/*     */     } 
/*  30 */     if (te.topExists()) {
/*     */       
/*  32 */       renderblocks.func_147782_a(0.0D, f1, 0.0D, 1.0D, 1.0D, 1.0D);
/*  33 */       renderblocks.func_147784_q(block, i, j, k);
/*  34 */       yMax = 0.9375D;
/*     */     } 
/*  36 */     if (te.northExists()) {
/*     */       
/*  38 */       renderblocks.func_147782_a(0.0D, yMin, 0.0D, 1.0D, yMax, f0);
/*  39 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*  41 */     if (te.southExists()) {
/*     */       
/*  43 */       renderblocks.func_147782_a(0.0D, yMin, f1, 1.0D, yMax, 1.0D);
/*  44 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*  46 */     if (te.eastExists()) {
/*     */       
/*  48 */       renderblocks.func_147782_a(0.0D, yMin, 0.0D, f0, yMax, 1.0D);
/*  49 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*  51 */     if (te.westExists()) {
/*     */       
/*  53 */       renderblocks.func_147782_a(f1, yMin, 0.0D, 1.0D, yMax, 1.0D);
/*  54 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*     */     
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
/*  63 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.20000000298023224D, 1.0D);
/*  64 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  70 */     return render(block, x, y, z, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/*  82 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/*  87 */     Tessellator var14 = Tessellator.field_78398_a;
/*  88 */     int meta = m;
/*  89 */     if (meta >= 8)
/*  90 */       meta -= 8; 
/*  91 */     var14.func_78382_b();
/*  92 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/*  93 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/*  94 */     var14.func_78381_a();
/*  95 */     var14.func_78382_b();
/*  96 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/*  97 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/*  98 */     var14.func_78381_a();
/*  99 */     var14.func_78382_b();
/* 100 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 101 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 102 */     var14.func_78381_a();
/* 103 */     var14.func_78382_b();
/* 104 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 105 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 106 */     var14.func_78381_a();
/* 107 */     var14.func_78382_b();
/* 108 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 109 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 110 */     var14.func_78381_a();
/* 111 */     var14.func_78382_b();
/* 112 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 113 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 114 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderMetalSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */