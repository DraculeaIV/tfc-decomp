/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderVessel
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   private static final float MIN = 0.2F;
/*     */   private static final float MAX = 0.8F;
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  23 */     TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/*  24 */     renderer.field_147837_f = true;
/*     */     
/*  26 */     if ((te.rotation & Byte.MIN_VALUE) == 0) {
/*     */       
/*  28 */       if (te.getSealed()) {
/*     */         
/*  30 */         renderer.func_147782_a(0.17499999701976776D, 0.550000011920929D, 0.17499999701976776D, 0.824999988079071D, 0.6499999761581421D, 0.824999988079071D);
/*  31 */         renderer.func_147784_q(block, x, y, z);
/*  32 */         renderer.func_147782_a(0.4375D, 0.6499999761581421D, 0.4375D, 0.5625D, 0.699999988079071D, 0.5625D);
/*  33 */         renderer.func_147784_q(block, x, y, z);
/*  34 */         renderer.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 0.05000000074505806D, 0.75D);
/*  35 */         renderer.func_147784_q(block, x, y, z);
/*     */       }
/*     */       else {
/*     */         
/*  39 */         renderer.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 0.05000000074505806D, 0.75D);
/*  40 */         renderer.func_147784_q(block, x, y, z);
/*     */         
/*  42 */         if (te.fluid != null && renderer.field_147840_d == null) {
/*     */           
/*  44 */           int color = te.fluid.getFluid().getColor(te.fluid);
/*  45 */           float f = (color >> 16 & 0xFF) / 255.0F;
/*  46 */           float f1 = (color >> 8 & 0xFF) / 255.0F;
/*  47 */           float f2 = (color & 0xFF) / 255.0F;
/*  48 */           float h = 0.5F * te.fluid.amount / te.getMaxLiquid();
/*  49 */           renderer.func_147782_a(0.25D, 0.05D, 0.25D, 0.75D, (0.05F + h), 0.75D);
/*  50 */           IIcon still = te.fluid.getFluid().getStillIcon();
/*  51 */           renderer.func_147757_a(still);
/*  52 */           renderer.func_147736_d(block, x, y, z, f, f1, f2);
/*  53 */           renderer.func_147771_a();
/*     */         } 
/*     */       } 
/*  56 */       renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.25D, 0.25D, 0.6000000238418579D, 0.75D);
/*  57 */       renderer.func_147784_q(block, x, y, z);
/*     */       
/*  59 */       renderer.func_147782_a(0.75D, 0.0D, 0.25D, 0.800000011920929D, 0.6000000238418579D, 0.75D);
/*  60 */       renderer.func_147784_q(block, x, y, z);
/*     */       
/*  62 */       renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.20000000298023224D, 0.800000011920929D, 0.6000000238418579D, 0.25D);
/*  63 */       renderer.func_147784_q(block, x, y, z);
/*     */       
/*  65 */       renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.75D, 0.800000011920929D, 0.6000000238418579D, 0.800000011920929D);
/*  66 */       renderer.func_147784_q(block, x, y, z);
/*     */       
/*  68 */       renderer.func_147782_a(0.25D, 0.05D, 0.25D, 0.75D, 0.10000000149011612D, 0.75D);
/*  69 */       renderer.func_147784_q(block, x, y, z);
/*     */     }
/*     */     else {
/*     */       
/*  73 */       if ((te.rotation & 0x3) == 0) {
/*     */         
/*  75 */         renderer.func_147782_a(0.20000000298023224D, 0.20000000298023224D, 0.25D, 0.949999988079071D, 0.25D, 0.75D);
/*  76 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*  78 */       if ((te.rotation & 0x3) == 1) {
/*     */         
/*  80 */         renderer.func_147782_a(0.25D, 0.20000000298023224D, 0.20000000298023224D, 0.75D, 0.25D, 0.949999988079071D);
/*  81 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  86 */     renderer.field_147837_f = false;
/*     */     
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  93 */     renderer.field_147875_q = i;
/*  94 */     renderer.field_147873_r = i;
/*  95 */     renderer.field_147869_t = i;
/*  96 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
/* 102 */     renderer.func_147782_a(0.17499999701976776D, 0.550000011920929D, 0.17499999701976776D, 0.824999988079071D, 0.6499999761581421D, 0.824999988079071D);
/* 103 */     renderInvBlock(block, meta, renderer);
/* 104 */     renderer.func_147782_a(0.4375D, 0.6499999761581421D, 0.4375D, 0.5625D, 0.699999988079071D, 0.5625D);
/* 105 */     renderInvBlock(block, meta, renderer);
/* 106 */     renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.20000000298023224D, 0.800000011920929D, 0.6000000238418579D, 0.800000011920929D);
/* 107 */     renderInvBlock(block, meta, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 120 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 125 */     Tessellator var14 = Tessellator.field_78398_a;
/* 126 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 127 */     var14.func_78382_b();
/* 128 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 129 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 130 */     var14.func_78381_a();
/* 131 */     var14.func_78382_b();
/* 132 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 133 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 134 */     var14.func_78381_a();
/* 135 */     var14.func_78382_b();
/* 136 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 137 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 138 */     var14.func_78381_a();
/* 139 */     var14.func_78382_b();
/* 140 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 141 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 142 */     var14.func_78381_a();
/* 143 */     var14.func_78382_b();
/* 144 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 145 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 146 */     var14.func_78381_a();
/* 147 */     var14.func_78382_b();
/* 148 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 149 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 150 */     var14.func_78381_a();
/* 151 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */