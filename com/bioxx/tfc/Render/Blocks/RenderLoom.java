/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TELoom;
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
/*     */ public class RenderLoom
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   private static final float MIN_X = 0.0F;
/*     */   private static final float MAX_X = 1.0F;
/*     */   private static final float MIN_Y = 0.0F;
/*     */   private static final float MAX_Y = 1.0F;
/*     */   private static final float MIN_Z = 0.0F;
/*     */   private static final float MAX_Z = 1.0F;
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*     */     Block materialBlock;
/*  27 */     TELoom te = (TELoom)world.func_147438_o(x, y, z);
/*     */     
/*  29 */     if (te.loomType < 16) {
/*     */       
/*  31 */       materialBlock = TFCBlocks.woodSupportH;
/*     */     }
/*     */     else {
/*     */       
/*  35 */       materialBlock = TFCBlocks.woodSupportH2;
/*     */     } 
/*  37 */     renderer.field_147837_f = true;
/*  38 */     GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  43 */     setRotatedRenderBounds(renderer, te.rotation, 0.1F, 0.0F, 0.75F, 0.19999999F, 1.0F, 0.85F);
/*  44 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */     
/*  46 */     setRotatedRenderBounds(renderer, te.rotation, 0.8F, 0.0F, 0.75F, 0.9F, 1.0F, 0.85F);
/*  47 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */ 
/*     */ 
/*     */     
/*  51 */     setRotatedRenderBounds(renderer, te.rotation, 0.1F, 0.25F, 0.5F, 0.19999999F, 0.3F, 0.75F);
/*  52 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */     
/*  54 */     setRotatedRenderBounds(renderer, te.rotation, 0.1F, 0.05F, 0.5F, 0.19999999F, 0.100000024F, 0.75F);
/*  55 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */ 
/*     */     
/*  58 */     setRotatedRenderBounds(renderer, te.rotation, 0.8F, 0.25F, 0.5F, 0.9F, 0.3F, 0.75F);
/*  59 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */     
/*  61 */     setRotatedRenderBounds(renderer, te.rotation, 0.8F, 0.05F, 0.5F, 0.9F, 0.100000024F, 0.75F);
/*  62 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */ 
/*     */     
/*  65 */     setRotatedRenderBounds(renderer, te.rotation, 0.19999999F, 0.8F, 0.75F, 0.8F, 0.9F, 0.85F);
/*  66 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */     
/*  68 */     setRotatedRenderBounds(renderer, te.rotation, 0.19999999F, 0.0F, 0.75F, 0.8F, 0.1F, 0.85F);
/*  69 */     renderer.func_147784_q(materialBlock, x, y, z);
/*     */     
/*  71 */     rotate(renderer, 0);
/*  72 */     renderer.field_147837_f = false;
/*  73 */     GL11.glPopMatrix();
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/*  79 */     renderer.field_147875_q = i;
/*  80 */     renderer.field_147873_r = i;
/*  81 */     renderer.field_147869_t = i;
/*  82 */     renderer.field_147871_s = i;
/*     */   }
/*     */   
/*     */   private void setRotatedRenderBounds(RenderBlocks renderer, byte rotation, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
/*  86 */     switch (rotation) { case 0:
/*  87 */         renderer.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ); break;
/*  88 */       case 1: renderer.func_147782_a((1.0F - maxZ), minY, minX, (1.0F - minZ), maxY, maxX); break;
/*  89 */       case 2: renderer.func_147782_a(minX, minY, (1.0F - maxZ), maxX, maxY, (1.0F - minZ)); break;
/*  90 */       case 3: renderer.func_147782_a(minZ, minY, minX, maxZ, maxY, maxX);
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
/*     */     Block materialBlock;
/* 100 */     if (meta < 16) {
/*     */       
/* 102 */       materialBlock = TFCBlocks.woodSupportH;
/*     */     }
/*     */     else {
/*     */       
/* 106 */       materialBlock = TFCBlocks.woodSupportH2;
/*     */     } 
/*     */     
/* 109 */     GL11.glPushMatrix();
/* 110 */     GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/* 112 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.75D, 0.19999998807907104D, 1.0D, 0.8500000238418579D);
/* 113 */     rotate(renderer, 1);
/* 114 */     renderInvBlock(materialBlock, meta, renderer);
/*     */     
/* 116 */     renderer.func_147782_a(0.800000011920929D, 0.0D, 0.75D, 0.8999999761581421D, 1.0D, 0.8500000238418579D);
/* 117 */     rotate(renderer, 1);
/* 118 */     renderInvBlock(materialBlock, meta, renderer);
/*     */ 
/*     */ 
/*     */     
/* 122 */     renderer.func_147782_a(0.10000000149011612D, 0.3499999940395355D, 0.6000000238418579D, 0.19999998807907104D, 0.3999999761581421D, 0.75D);
/* 123 */     rotate(renderer, 1);
/* 124 */     renderInvBlock(materialBlock, meta, renderer);
/*     */     
/* 126 */     renderer.func_147782_a(0.10000000149011612D, 0.15000000596046448D, 0.6000000238418579D, 0.19999998807907104D, 0.19999998807907104D, 0.75D);
/* 127 */     rotate(renderer, 1);
/* 128 */     renderInvBlock(materialBlock, meta, renderer);
/*     */ 
/*     */     
/* 131 */     renderer.func_147782_a(0.800000011920929D, 0.3499999940395355D, 0.6000000238418579D, 0.8999999761581421D, 0.3999999761581421D, 0.75D);
/* 132 */     rotate(renderer, 1);
/* 133 */     renderInvBlock(materialBlock, meta, renderer);
/*     */     
/* 135 */     renderer.func_147782_a(0.800000011920929D, 0.15000000596046448D, 0.6000000238418579D, 0.8999999761581421D, 0.19999998807907104D, 0.75D);
/* 136 */     rotate(renderer, 1);
/* 137 */     renderInvBlock(materialBlock, meta, renderer);
/*     */ 
/*     */     
/* 140 */     renderer.func_147782_a(0.19999998807907104D, 0.800000011920929D, 0.75D, 0.800000011920929D, 0.8999999761581421D, 0.8500000238418579D);
/* 141 */     rotate(renderer, 1);
/* 142 */     renderInvBlock(materialBlock, meta, renderer);
/*     */     
/* 144 */     renderer.func_147782_a(0.19999998807907104D, 0.0D, 0.75D, 0.800000011920929D, 0.10000000149011612D, 0.8500000238418579D);
/* 145 */     rotate(renderer, 1);
/* 146 */     renderInvBlock(materialBlock, meta, renderer);
/*     */     
/* 148 */     rotate(renderer, 0);
/* 149 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 161 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 166 */     Tessellator var14 = Tessellator.field_78398_a;
/* 167 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 168 */     var14.func_78382_b();
/* 169 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 170 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 171 */     var14.func_78381_a();
/* 172 */     var14.func_78382_b();
/* 173 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 174 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 175 */     var14.func_78381_a();
/* 176 */     var14.func_78382_b();
/* 177 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 178 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 179 */     var14.func_78381_a();
/* 180 */     var14.func_78382_b();
/* 181 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 182 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 183 */     var14.func_78381_a();
/* 184 */     var14.func_78382_b();
/* 185 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 186 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 187 */     var14.func_78381_a();
/* 188 */     var14.func_78382_b();
/* 189 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 190 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 191 */     var14.func_78381_a();
/* 192 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlockHoop(Block block, int m, RenderBlocks renderer) {
/* 197 */     Tessellator var14 = Tessellator.field_78398_a;
/* 198 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 199 */     var14.func_78382_b();
/* 200 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 201 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(10, m));
/* 202 */     var14.func_78381_a();
/* 203 */     var14.func_78382_b();
/* 204 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 205 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(11, m));
/* 206 */     var14.func_78381_a();
/* 207 */     var14.func_78382_b();
/* 208 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 209 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(12, m));
/* 210 */     var14.func_78381_a();
/* 211 */     var14.func_78382_b();
/* 212 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 213 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(13, m));
/* 214 */     var14.func_78381_a();
/* 215 */     var14.func_78382_b();
/* 216 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 217 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(14, m));
/* 218 */     var14.func_78381_a();
/* 219 */     var14.func_78382_b();
/* 220 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 221 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(15, m));
/* 222 */     var14.func_78381_a();
/* 223 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderLoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */