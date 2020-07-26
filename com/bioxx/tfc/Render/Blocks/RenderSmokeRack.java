/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TESmokeRack;
/*     */ import com.bioxx.tfc.api.Food;
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
/*     */ public class RenderSmokeRack
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  20 */     TESmokeRack te = (TESmokeRack)world.func_147438_o(x, y, z);
/*  21 */     renderer.field_147837_f = true;
/*  22 */     renderer.func_147784_q(block, x, y, z);
/*  23 */     if ((world.func_72805_g(x, y, z) & 0x1) == 0) {
/*     */       
/*  25 */       if (te.func_70301_a(0) != null) {
/*     */         
/*  27 */         double mid = 0.25D;
/*  28 */         float r = 1.0F, g = 1.0F, b = 1.0F;
/*  29 */         if (Food.isSmoked(te.func_70301_a(0))) {
/*  30 */           r = 0.1F; g = 0.1F; b = 0.1F;
/*  31 */         }  renderer.func_147782_a(0.43D, 0.43D, mid - 0.07D, 0.57D, 0.57D, mid + 0.07D);
/*  32 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*  33 */         renderer.func_147782_a(0.491D, 0.2D, mid - 0.009D, 0.509D, 0.5D, mid + 0.009D);
/*  34 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*     */       } 
/*  36 */       if (te.func_70301_a(1) != null)
/*     */       {
/*  38 */         double mid = 0.75D;
/*  39 */         float r = 1.0F, g = 1.0F, b = 1.0F;
/*  40 */         if (Food.isSmoked(te.func_70301_a(1))) {
/*  41 */           r = 0.1F; g = 0.1F; b = 0.1F;
/*  42 */         }  renderer.func_147782_a(0.43D, 0.43D, mid - 0.07D, 0.57D, 0.57D, mid + 0.07D);
/*  43 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*  44 */         renderer.func_147782_a(0.491D, 0.2D, mid - 0.009D, 0.509D, 0.5D, mid + 0.009D);
/*  45 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  50 */       if (te.func_70301_a(0) != null) {
/*     */         
/*  52 */         double mid = 0.25D;
/*  53 */         float r = 1.0F, g = 1.0F, b = 1.0F;
/*  54 */         if (Food.isSmoked(te.func_70301_a(0))) {
/*  55 */           r = 0.1F; g = 0.1F; b = 0.1F;
/*  56 */         }  renderer.func_147782_a(mid - 0.07D, 0.43D, 0.43D, mid + 0.07D, 0.57D, 0.57D);
/*  57 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*  58 */         renderer.func_147782_a(mid - 0.009D, 0.2D, 0.491D, mid + 0.009D, 0.5D, 0.509D);
/*  59 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*     */       } 
/*  61 */       if (te.func_70301_a(1) != null) {
/*     */         
/*  63 */         double mid = 0.75D;
/*  64 */         float r = 1.0F, g = 1.0F, b = 1.0F;
/*  65 */         if (Food.isSmoked(te.func_70301_a(1))) {
/*  66 */           r = 0.1F; g = 0.1F; b = 0.1F;
/*  67 */         }  renderer.func_147782_a(mid - 0.07D, 0.43D, 0.43D, mid + 0.07D, 0.57D, 0.57D);
/*  68 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*  69 */         renderer.func_147782_a(mid - 0.009D, 0.2D, 0.491D, mid + 0.009D, 0.5D, 0.509D);
/*  70 */         renderer.func_147736_d(block, x, y, z, r, g, b);
/*     */       } 
/*     */     } 
/*  73 */     renderer.field_147837_f = false;
/*     */     
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  80 */     renderer.field_147875_q = i;
/*  81 */     renderer.field_147873_r = i;
/*  82 */     renderer.field_147869_t = i;
/*  83 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 101 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 106 */     Tessellator var14 = Tessellator.field_78398_a;
/* 107 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 108 */     var14.func_78382_b();
/* 109 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 110 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 111 */     var14.func_78381_a();
/* 112 */     var14.func_78382_b();
/* 113 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 114 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 115 */     var14.func_78381_a();
/* 116 */     var14.func_78382_b();
/* 117 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 118 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 119 */     var14.func_78381_a();
/* 120 */     var14.func_78382_b();
/* 121 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 122 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 123 */     var14.func_78381_a();
/* 124 */     var14.func_78382_b();
/* 125 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 126 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 127 */     var14.func_78381_a();
/* 128 */     var14.func_78382_b();
/* 129 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 130 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 131 */     var14.func_78381_a();
/* 132 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderSmokeRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */