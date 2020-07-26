/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockWall;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderWall
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean renderBlockWall(BlockWall wallBlock, int x, int y, int z, RenderBlocks renderblocks) {
/*  20 */     boolean flag0 = wallBlock.func_150091_e(renderblocks.field_147845_a, x - 1, y, z);
/*  21 */     boolean flag1 = wallBlock.func_150091_e(renderblocks.field_147845_a, x + 1, y, z);
/*  22 */     boolean flag2 = wallBlock.func_150091_e(renderblocks.field_147845_a, x, y, z - 1);
/*  23 */     boolean flag3 = wallBlock.func_150091_e(renderblocks.field_147845_a, x, y, z + 1);
/*  24 */     boolean flag4 = (flag2 && flag3 && !flag0 && !flag1);
/*  25 */     boolean flag5 = (!flag2 && !flag3 && flag0 && flag1);
/*  26 */     boolean flag6 = renderblocks.field_147845_a.func_147437_c(x, y + 1, z);
/*     */ 
/*     */     
/*  29 */     boolean flagUp = wallBlock.func_150091_e(renderblocks.field_147845_a, x, y + 1, z);
/*     */     
/*  31 */     boolean flag0Up = wallBlock.func_150091_e(renderblocks.field_147845_a, x - 1, y + 1, z);
/*  32 */     boolean flag1Up = wallBlock.func_150091_e(renderblocks.field_147845_a, x + 1, y + 1, z);
/*  33 */     boolean flag2Up = wallBlock.func_150091_e(renderblocks.field_147845_a, x, y + 1, z - 1);
/*  34 */     boolean flag3Up = wallBlock.func_150091_e(renderblocks.field_147845_a, x, y + 1, z + 1);
/*  35 */     boolean flag4Up = (flag2Up && flag3Up);
/*  36 */     boolean flag5Up = (flag0Up && flag1Up);
/*     */     
/*  38 */     if (((flag4 && flag4Up) || (flag5 && flag5Up)) && flagUp) {
/*     */       
/*  40 */       if (flag4)
/*     */       {
/*  42 */         renderblocks.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 1.0D);
/*  43 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       }
/*     */       else
/*     */       {
/*  47 */         renderblocks.func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
/*  48 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       }
/*     */     
/*  51 */     } else if ((flag4 || flag5) && flag6) {
/*     */       
/*  53 */       if (flag4)
/*     */       {
/*  55 */         renderblocks.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
/*  56 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       }
/*     */       else
/*     */       {
/*  60 */         renderblocks.func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
/*  61 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  66 */       renderblocks.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/*  67 */       renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */ 
/*     */ 
/*     */       
/*  71 */       if (flag0) {
/*     */         
/*  73 */         if (flagUp && flag0Up) {
/*  74 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.3125D, 0.25D, 1.0D, 0.6875D);
/*     */         } else {
/*     */           
/*  77 */           renderblocks.func_147782_a(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
/*     */         } 
/*  79 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       } 
/*     */       
/*  82 */       if (flag1) {
/*     */         
/*  84 */         if (flagUp && flag1Up) {
/*  85 */           renderblocks.func_147782_a(0.75D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
/*     */         }
/*     */         else {
/*     */           
/*  89 */           renderblocks.func_147782_a(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
/*     */         } 
/*  91 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       } 
/*     */       
/*  94 */       if (flag2) {
/*     */         
/*  96 */         if (flagUp && flag2Up) {
/*  97 */           renderblocks.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 0.25D);
/*     */         } else {
/*     */           
/* 100 */           renderblocks.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
/*     */         } 
/* 102 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       } 
/*     */       
/* 105 */       if (flag3) {
/*     */         
/* 107 */         if (flagUp && flag3Up) {
/* 108 */           renderblocks.func_147782_a(0.3125D, 0.0D, 0.75D, 0.6875D, 1.0D, 1.0D);
/*     */         } else {
/*     */           
/* 111 */           renderblocks.func_147782_a(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
/*     */         } 
/* 113 */         renderblocks.func_147784_q((Block)wallBlock, x, y, z);
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     wallBlock.func_149719_a(renderblocks.field_147845_a, x, y, z);
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 124 */     float f = 0.3F;
/* 125 */     float f1 = 0.7F;
/*     */     
/* 127 */     renderer.func_147782_a(f, 0.0D, f, f1, 1.0D, f1);
/* 128 */     renderInvBlock(block, metadata, renderer);
/*     */     
/* 130 */     f = 0.325F;
/* 131 */     f1 = 0.675F;
/* 132 */     float f2 = 0.0F;
/* 133 */     float f3 = 0.8F;
/*     */ 
/*     */     
/* 136 */     float f6 = 0.0F;
/* 137 */     float f7 = 1.5F;
/*     */     
/* 139 */     renderer.func_147782_a(f - 0.001D, f2, f6, f1 - 0.001D, f3, 5.0D * f7 / 8.0D);
/* 140 */     renderInvBlock(block, metadata, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 155 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 161 */     if (modelId == TFCBlocks.wallRenderId && block instanceof BlockWall) {
/* 162 */       return renderBlockWall((BlockWall)block, x, y, z, renderer);
/*     */     }
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 169 */     Tessellator var14 = Tessellator.field_78398_a;
/* 170 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 171 */     var14.func_78382_b();
/* 172 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 173 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 174 */     var14.func_78381_a();
/* 175 */     var14.func_78382_b();
/* 176 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 177 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 178 */     var14.func_78381_a();
/* 179 */     var14.func_78382_b();
/* 180 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 181 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 182 */     var14.func_78381_a();
/* 183 */     var14.func_78382_b();
/* 184 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 185 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 186 */     var14.func_78381_a();
/* 187 */     var14.func_78382_b();
/* 188 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 189 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 190 */     var14.func_78381_a();
/* 191 */     var14.func_78382_b();
/* 192 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 193 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 194 */     var14.func_78381_a();
/* 195 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */