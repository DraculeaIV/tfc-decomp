/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockEarlyBloomery;
/*     */ import com.bioxx.tfc.TileEntities.TEBloomery;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderBloomery
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean render(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/*  19 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */     
/*  21 */     int meta = blockAccess.func_72805_g(i, j, k);
/*  22 */     int dir = meta & 0x3;
/*  23 */     TEBloomery te = (TEBloomery)blockAccess.func_147438_o(i, j, k);
/*  24 */     if (te != null && 
/*  25 */       te.isFlipped)
/*  26 */       dir = BlockEarlyBloomery.flipDir(dir); 
/*  27 */     float f = 0.125F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     if (!BlockEarlyBloomery.isOpen(meta)) {
/*     */       
/*  34 */       switch (dir) {
/*     */         
/*     */         case 0:
/*  37 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, f); break;
/*     */         case 1:
/*  39 */           renderblocks.func_147782_a((1.0F - f), 0.0D, 0.0D, 1.0D, 1.0D, 1.0D); break;
/*     */         case 2:
/*  41 */           renderblocks.func_147782_a(0.0D, 0.0D, (1.0F - f), 1.0D, 1.0D, 1.0D); break;
/*     */         case 3:
/*  43 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, f, 1.0D, 1.0D); break;
/*     */       } 
/*  45 */       renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */     
/*     */     }
/*  49 */     else if (dir == 0) {
/*     */ 
/*     */       
/*  52 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, f);
/*  53 */       renderblocks.func_147784_q(block, i, j, k);
/*  54 */       renderblocks.func_147782_a(0.0D, 0.9375D, 0.0D, 1.0D, 1.0D, f);
/*  55 */       renderblocks.func_147784_q(block, i, j, k);
/*  56 */       renderblocks.func_147782_a(0.0D, 0.0625D, 0.0D, 0.0625D, 0.9375D, f);
/*  57 */       renderblocks.func_147784_q(block, i, j, k);
/*  58 */       renderblocks.func_147782_a(0.9375D, 0.0625D, 0.0D, 1.0D, 0.9375D, f);
/*  59 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*  61 */       renderblocks.func_147782_a(0.0D, 0.0625D, 0.0625D, f, 0.9375D, 0.5D);
/*  62 */       renderblocks.func_147784_q(block, i, j, k);
/*  63 */       renderblocks.func_147782_a((1.0F - f), 0.0625D, 0.0625D, 1.0D, 0.9375D, 0.5D);
/*  64 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     }
/*  66 */     else if (dir == 1) {
/*     */ 
/*     */       
/*  69 */       renderblocks.func_147782_a((1.0F - f), 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
/*  70 */       renderblocks.func_147784_q(block, i, j, k);
/*  71 */       renderblocks.func_147782_a((1.0F - f), 0.9375D, 0.0D, 1.0D, 1.0D, 1.0D);
/*  72 */       renderblocks.func_147784_q(block, i, j, k);
/*  73 */       renderblocks.func_147782_a((1.0F - f), 0.0625D, 0.0D, 1.0D, 0.9375D, 0.0625D);
/*  74 */       renderblocks.func_147784_q(block, i, j, k);
/*  75 */       renderblocks.func_147782_a((1.0F - f), 0.0625D, 0.9375D, 1.0D, 0.9375D, 1.0D);
/*  76 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*  78 */       renderblocks.func_147782_a(0.5D, 0.0625D, (1.0F - f), 0.9375D, 0.9375D, 1.0D);
/*  79 */       renderblocks.func_147784_q(block, i, j, k);
/*  80 */       renderblocks.func_147782_a(0.5D, 0.0625D, 0.0D, 0.9375D, 0.9375D, f);
/*  81 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     }
/*  83 */     else if (dir == 2) {
/*     */ 
/*     */       
/*  86 */       renderblocks.func_147782_a(0.0D, 0.0D, (1.0F - f), 1.0D, 0.0625D, 1.0D);
/*  87 */       renderblocks.func_147784_q(block, i, j, k);
/*  88 */       renderblocks.func_147782_a(0.0D, 0.9375D, (1.0F - f), 1.0D, 1.0D, 1.0D);
/*  89 */       renderblocks.func_147784_q(block, i, j, k);
/*  90 */       renderblocks.func_147782_a(0.0D, 0.0625D, (1.0F - f), 0.0625D, 0.9375D, 1.0D);
/*  91 */       renderblocks.func_147784_q(block, i, j, k);
/*  92 */       renderblocks.func_147782_a(0.9375D, 0.0625D, (1.0F - f), 1.0D, 0.9375D, 1.0D);
/*  93 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*  95 */       renderblocks.func_147782_a(0.0D, 0.0625D, 0.5D, f, 0.9375D, 0.9375D);
/*  96 */       renderblocks.func_147784_q(block, i, j, k);
/*  97 */       renderblocks.func_147782_a((1.0F - f), 0.0625D, 0.5D, 1.0D, 0.9375D, 0.9375D);
/*  98 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     }
/* 100 */     else if (dir == 3) {
/*     */ 
/*     */       
/* 103 */       renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, f, 0.0625D, 1.0D);
/* 104 */       renderblocks.func_147784_q(block, i, j, k);
/* 105 */       renderblocks.func_147782_a(0.0D, 0.9375D, 0.0D, f, 1.0D, 1.0D);
/* 106 */       renderblocks.func_147784_q(block, i, j, k);
/* 107 */       renderblocks.func_147782_a(0.0D, 0.0625D, 0.0D, f, 0.9375D, 0.0625D);
/* 108 */       renderblocks.func_147784_q(block, i, j, k);
/* 109 */       renderblocks.func_147782_a(0.0D, 0.0625D, 0.9375D, f, 0.9375D, 1.0D);
/* 110 */       renderblocks.func_147784_q(block, i, j, k);
/*     */       
/* 112 */       renderblocks.func_147782_a(0.0625D, 0.0625D, (1.0F - f), 0.5D, 0.9375D, 1.0D);
/* 113 */       renderblocks.func_147784_q(block, i, j, k);
/* 114 */       renderblocks.func_147782_a(0.0625D, 0.0625D, 0.0D, 0.5D, 0.9375D, f);
/* 115 */       renderblocks.func_147784_q(block, i, j, k);
/*     */     } 
/*     */     
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
/* 124 */     if (modelId == TFCBlocks.bloomeryRenderId) {
/*     */       
/* 126 */       renderer.func_147782_a(0.5D, 0.0D, 0.0D, 0.699999988079071D, 1.0D, 1.0D);
/* 127 */       renderInvBlock(block, metadata, renderer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 134 */     if (modelId == TFCBlocks.bloomeryRenderId)
/* 135 */       return render(block, x, y, z, renderer); 
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 148 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 153 */     Tessellator var14 = Tessellator.field_78398_a;
/* 154 */     int meta = m;
/* 155 */     if (meta >= 8)
/* 156 */       meta -= 8; 
/* 157 */     var14.func_78382_b();
/* 158 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 159 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 160 */     var14.func_78381_a();
/* 161 */     var14.func_78382_b();
/* 162 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 163 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 164 */     var14.func_78381_a();
/* 165 */     var14.func_78382_b();
/* 166 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 167 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 168 */     var14.func_78381_a();
/* 169 */     var14.func_78382_b();
/* 170 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 171 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 172 */     var14.func_78381_a();
/* 173 */     var14.func_78382_b();
/* 174 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 175 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 176 */     var14.func_78381_a();
/* 177 */     var14.func_78382_b();
/* 178 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 179 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 180 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderBloomery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */