/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderSmoke
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  22 */     renderer.field_147863_w = false;
/*  23 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  24 */     boolean flag = false;
/*  25 */     float f3 = 0.5F;
/*  26 */     float f4 = 1.0F;
/*  27 */     float f5 = 0.8F;
/*  28 */     float f6 = 0.6F;
/*  29 */     float f7 = f4 * 1.0F;
/*  30 */     float f8 = f4 * 1.0F;
/*  31 */     float f9 = f4 * 1.0F;
/*  32 */     float f10 = f3;
/*  33 */     float f11 = f5;
/*  34 */     float f12 = f6;
/*  35 */     float f13 = f3;
/*  36 */     float f14 = f5;
/*  37 */     float f15 = f6;
/*  38 */     float f16 = f3;
/*  39 */     float f17 = f5;
/*  40 */     float f18 = f6;
/*  41 */     float alpha = 0.8F;
/*     */ 
/*     */ 
/*     */     
/*  45 */     int l = block.func_149677_c(world, x, y, z);
/*     */     
/*  47 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y - 1, z, 0)) {
/*     */       
/*  49 */       tessellator.func_78380_c((renderer.field_147855_j > 0.0D) ? l : block.func_149677_c(renderer.field_147845_a, x, y - 1, z));
/*  50 */       tessellator.func_78369_a(f10, f13, f16, alpha);
/*  51 */       renderer.func_147768_a(block, x, y, z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 0));
/*  52 */       flag = true;
/*     */     } 
/*     */     
/*  55 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y + 1, z, 1)) {
/*     */       
/*  57 */       tessellator.func_78380_c((renderer.field_147857_k < 1.0D) ? l : block.func_149677_c(renderer.field_147845_a, x, y + 1, z));
/*  58 */       tessellator.func_78369_a(f7, f8, f9, alpha);
/*  59 */       renderer.func_147806_b(block, x, y, z, renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 1));
/*  60 */       flag = true;
/*     */     } 
/*     */ 
/*     */     
/*  64 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y, z - 1, 2)) {
/*     */       
/*  66 */       tessellator.func_78380_c((renderer.field_147851_l > 0.0D) ? l : block.func_149677_c(renderer.field_147845_a, x, y, z - 1));
/*  67 */       tessellator.func_78369_a(f11, f14, f17, alpha);
/*  68 */       IIcon iicon = renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 2);
/*  69 */       renderer.func_147761_c(block, x, y, z, iicon);
/*  70 */       flag = true;
/*     */     } 
/*     */     
/*  73 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x, y, z + 1, 3)) {
/*     */       
/*  75 */       tessellator.func_78380_c((renderer.field_147853_m < 1.0D) ? l : block.func_149677_c(renderer.field_147845_a, x, y, z + 1));
/*  76 */       tessellator.func_78369_a(f11, f14, f17, alpha);
/*  77 */       IIcon iicon = renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 3);
/*  78 */       renderer.func_147734_d(block, x, y, z, iicon);
/*  79 */       flag = true;
/*     */     } 
/*     */     
/*  82 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x - 1, y, z, 4)) {
/*     */       
/*  84 */       tessellator.func_78380_c((renderer.field_147859_h > 0.0D) ? l : block.func_149677_c(renderer.field_147845_a, x - 1, y, z));
/*  85 */       tessellator.func_78369_a(f12, f15, f18, alpha);
/*  86 */       IIcon iicon = renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 4);
/*  87 */       renderer.func_147798_e(block, x, y, z, iicon);
/*  88 */       flag = true;
/*     */     } 
/*     */     
/*  91 */     if (renderer.field_147837_f || block.func_149646_a(renderer.field_147845_a, x + 1, y, z, 5)) {
/*     */       
/*  93 */       tessellator.func_78380_c((renderer.field_147861_i < 1.0D) ? l : block.func_149677_c(renderer.field_147845_a, x + 1, y, z));
/*  94 */       tessellator.func_78369_a(f12, f15, f18, alpha);
/*  95 */       IIcon iicon = renderer.func_147793_a(block, renderer.field_147845_a, x, y, z, 5);
/*  96 */       renderer.func_147764_f(block, x, y, z, iicon);
/*  97 */       flag = true;
/*     */     } 
/*  99 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 117 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderSmoke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */