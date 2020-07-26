/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Vanilla.BlockTFCFence;
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
/*     */ public class RenderFence
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderblocks) {
/*  24 */     BlockTFCFence par1BlockFence = (BlockTFCFence)block;
/*  25 */     boolean flag = false;
/*  26 */     float f = 0.375F;
/*  27 */     float f1 = 0.625F;
/*  28 */     renderblocks.func_147782_a(f, 0.0D, f, f1, 1.0D, f1);
/*  29 */     renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*  30 */     flag = true;
/*  31 */     boolean flag1 = false;
/*  32 */     boolean flag2 = false;
/*     */     
/*  34 */     if (par1BlockFence.func_149826_e(renderblocks.field_147845_a, x - 1, y, z) || par1BlockFence.func_149826_e(renderblocks.field_147845_a, x + 1, y, z)) {
/*  35 */       flag1 = true;
/*     */     }
/*  37 */     if (par1BlockFence.func_149826_e(renderblocks.field_147845_a, x, y, z - 1) || par1BlockFence.func_149826_e(renderblocks.field_147845_a, x, y, z + 1)) {
/*  38 */       flag2 = true;
/*     */     }
/*  40 */     boolean flag3 = par1BlockFence.func_149826_e(renderblocks.field_147845_a, x - 1, y, z);
/*  41 */     boolean flag4 = par1BlockFence.func_149826_e(renderblocks.field_147845_a, x + 1, y, z);
/*  42 */     boolean flag5 = par1BlockFence.func_149826_e(renderblocks.field_147845_a, x, y, z - 1);
/*  43 */     boolean flag6 = par1BlockFence.func_149826_e(renderblocks.field_147845_a, x, y, z + 1);
/*     */     
/*  45 */     if (!flag1 && !flag2) {
/*  46 */       flag1 = true;
/*     */     }
/*  48 */     f = 0.4375F;
/*  49 */     f1 = 0.5625F;
/*  50 */     float f2 = 0.75F;
/*  51 */     float f3 = 0.9375F;
/*  52 */     float f4 = flag3 ? 0.0F : f;
/*  53 */     float f5 = flag4 ? 1.0F : f1;
/*  54 */     float f6 = flag5 ? 0.0F : f;
/*  55 */     float f7 = flag6 ? 1.0F : f1;
/*     */     
/*  57 */     if (flag1) {
/*     */       
/*  59 */       renderblocks.func_147782_a(f4, f2 + 0.001D, f + 0.001D, f5, f3 + 0.001D, f1 + 0.001D);
/*  60 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  62 */       renderblocks.func_147782_a(f5, f2, f1 - 0.001D, f4, f3, f - 0.001D);
/*  63 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  65 */       flag = true;
/*     */     } 
/*     */     
/*  68 */     if (flag2) {
/*     */       
/*  70 */       renderblocks.func_147782_a(f - 0.001D, f2 + 0.001D, f6, f1 - 0.001D, f3 + 0.001D, f7);
/*  71 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  73 */       renderblocks.func_147782_a(f1 + 0.001D, f2, f7, f + 0.001D, f3, f6);
/*  74 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*  75 */       flag = true;
/*     */     } 
/*     */     
/*  78 */     f2 = 0.375F;
/*  79 */     f3 = 0.5625F;
/*     */     
/*  81 */     if (flag1) {
/*     */       
/*  83 */       renderblocks.func_147782_a(f4, f2 + 0.001D, f + 0.001D, f5, f3 + 0.001D, f1 + 0.001D);
/*  84 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  86 */       renderblocks.func_147782_a(f5, f2, f1 - 0.001D, f4, f3, f - 0.001D);
/*  87 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  89 */       flag = true;
/*     */     } 
/*     */     
/*  92 */     if (flag2) {
/*     */       
/*  94 */       renderblocks.func_147782_a(f - 0.001D, f2 + 0.001D, f6, f1 - 0.001D, f3 + 0.001D, f7);
/*  95 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*     */       
/*  97 */       renderblocks.func_147782_a(f1 + 0.001D, f2, f7, f + 0.001D, f3, f6);
/*  98 */       renderblocks.func_147784_q((Block)par1BlockFence, x, y, z);
/*  99 */       flag = true;
/*     */     } 
/*     */     
/* 102 */     par1BlockFence.func_149719_a(renderblocks.field_147845_a, x, y, z);
/* 103 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 109 */     float f = 0.375F;
/* 110 */     float f1 = 0.625F;
/* 111 */     renderer.func_147782_a(f, 0.0D, f, f1, 1.0D, f1);
/*     */     
/* 113 */     renderInvBlock(block, metadata, renderer);
/*     */     
/* 115 */     renderer.func_147782_a(f, 0.0D, f, f1, 1.0D, f1);
/*     */     
/* 117 */     renderInvBlock2(block, metadata, renderer);
/*     */     
/* 119 */     f = 0.4375F;
/* 120 */     f1 = 0.5625F;
/* 121 */     float f2 = 0.75F;
/* 122 */     float f3 = 0.9375F;
/*     */ 
/*     */     
/* 125 */     float f6 = 0.0F;
/* 126 */     float f7 = 1.0F;
/*     */     
/* 128 */     renderer.func_147782_a(f - 0.001D, f2, f6, f1 - 0.001D, f3, f7 / 2.0D);
/* 129 */     renderInvBlock(block, metadata, renderer);
/*     */     
/* 131 */     renderer.func_147782_a(f1 + 0.001D, f2, f7 / 2.0D, f + 0.001D, f3, f6);
/* 132 */     renderInvBlock(block, metadata, renderer);
/*     */     
/* 134 */     f2 = 0.375F;
/* 135 */     f3 = 0.5625F;
/*     */     
/* 137 */     renderer.func_147782_a(f - 0.001D, f2, f6, f1 - 0.001D, f3, f7 / 2.0D);
/* 138 */     renderInvBlock(block, metadata, renderer);
/*     */     
/* 140 */     renderer.func_147782_a(f1 + 0.001D, f2, f7 / 2.0D, f + 0.001D, f3, f6);
/* 141 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 152 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 157 */     Tessellator var14 = Tessellator.field_78398_a;
/* 158 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 159 */     var14.func_78382_b();
/* 160 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 161 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 162 */     var14.func_78381_a();
/* 163 */     var14.func_78382_b();
/* 164 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 165 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 166 */     var14.func_78381_a();
/* 167 */     var14.func_78382_b();
/* 168 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 169 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 170 */     var14.func_78381_a();
/* 171 */     var14.func_78382_b();
/* 172 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 173 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 174 */     var14.func_78381_a();
/* 175 */     var14.func_78382_b();
/* 176 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 177 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 178 */     var14.func_78381_a();
/* 179 */     var14.func_78382_b();
/* 180 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 181 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 182 */     var14.func_78381_a();
/* 183 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock2(Block block, int m, RenderBlocks renderer) {
/* 188 */     Tessellator var14 = Tessellator.field_78398_a;
/* 189 */     GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
/* 190 */     var14.func_78382_b();
/* 191 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 192 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 193 */     var14.func_78381_a();
/* 194 */     var14.func_78382_b();
/* 195 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 196 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 197 */     var14.func_78381_a();
/* 198 */     var14.func_78382_b();
/* 199 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 200 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 201 */     var14.func_78381_a();
/* 202 */     var14.func_78382_b();
/* 203 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 204 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 205 */     var14.func_78381_a();
/* 206 */     var14.func_78382_b();
/* 207 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 208 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 209 */     var14.func_78381_a();
/* 210 */     var14.func_78382_b();
/* 211 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 212 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 213 */     var14.func_78381_a();
/* 214 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */