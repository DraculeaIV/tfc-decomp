/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
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
/*     */ public class RenderBarrel
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   private static final float MIN = 0.1F;
/*     */   private static final float MAX = 0.9F;
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*     */     Block planksBlock, lidBlock;
/*  24 */     TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/*     */ 
/*     */     
/*  27 */     if (te.barrelType < 16) {
/*     */       
/*  29 */       planksBlock = TFCBlocks.planks;
/*  30 */       lidBlock = TFCBlocks.woodSupportH;
/*     */     }
/*     */     else {
/*     */       
/*  34 */       planksBlock = TFCBlocks.planks2;
/*  35 */       lidBlock = TFCBlocks.woodSupportH2;
/*     */     } 
/*  37 */     renderer.field_147837_f = true;
/*     */     
/*  39 */     if ((te.rotation & Byte.MIN_VALUE) == 0) {
/*     */       
/*  41 */       if (te.getSealed()) {
/*     */         
/*  43 */         renderer.func_147782_a(0.15000000596046448D, 0.10000000149011612D, 0.15000000596046448D, 0.8499999642372131D, 0.949999988079071D, 0.8499999642372131D);
/*  44 */         renderer.func_147784_q(lidBlock, x, y, z);
/*     */       }
/*     */       else {
/*     */         
/*  48 */         renderer.func_147782_a(0.15000000596046448D, 0.10000000149011612D, 0.15000000596046448D, 0.8499999642372131D, 0.15000000596046448D, 0.8499999642372131D);
/*  49 */         renderer.func_147784_q(lidBlock, x, y, z);
/*     */         
/*  51 */         if (te.fluid != null && renderer.field_147840_d == null) {
/*     */           
/*  53 */           int color = te.fluid.getFluid().getColor(te.fluid);
/*  54 */           float f = (color >> 16 & 0xFF) / 255.0F;
/*  55 */           float f1 = (color >> 8 & 0xFF) / 255.0F;
/*  56 */           float f2 = (color & 0xFF) / 255.0F;
/*  57 */           float h = 0.75F * te.fluid.amount / 10000.0F;
/*  58 */           renderer.func_147782_a(0.15000000596046448D, 0.1500000014901161D, 0.15000000596046448D, 0.8499999642372131D, (0.15F + h), 0.8499999642372131D);
/*  59 */           IIcon still = te.fluid.getFluid().getStillIcon();
/*  60 */           renderer.func_147757_a(still);
/*  61 */           renderer.func_147736_d(lidBlock, x, y, z, f, f1, f2);
/*  62 */           renderer.func_147771_a();
/*     */         } 
/*     */       } 
/*  65 */       renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.15000000596046448D, 0.15000000596046448D, 1.0D, 0.8499999642372131D);
/*  66 */       rotate(renderer, 1);
/*  67 */       renderer.func_147784_q(planksBlock, x, y, z);
/*     */       
/*  69 */       renderer.func_147782_a(0.8499999642372131D, 0.0D, 0.15000000596046448D, 0.8999999761581421D, 1.0D, 0.8499999642372131D);
/*  70 */       rotate(renderer, 1);
/*  71 */       renderer.func_147784_q(planksBlock, x, y, z);
/*     */       
/*  73 */       renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.8999999761581421D, 1.0D, 0.15000000596046448D);
/*  74 */       rotate(renderer, 1);
/*  75 */       renderer.func_147784_q(planksBlock, x, y, z);
/*     */       
/*  77 */       renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.8499999642372131D, 0.8999999761581421D, 1.0D, 0.8999999761581421D);
/*  78 */       rotate(renderer, 1);
/*  79 */       renderer.func_147784_q(planksBlock, x, y, z);
/*     */       
/*  81 */       renderer.func_147782_a(0.09900000149011612D, 0.0D, 0.09900000149011612D, 0.9009999761581421D, 1.0D, 0.9009999761581421D);
/*  82 */       rotate(renderer, 0);
/*  83 */       renderer.func_147784_q(block, x, y, z);
/*     */     }
/*     */     else {
/*     */       
/*  87 */       if ((te.rotation & 0x3) == 0) {
/*     */         
/*  89 */         renderer.func_147782_a(0.10000000149011612D, 0.10000000149011612D, 0.15000000596046448D, 0.949999988079071D, 0.15000000596046448D, 0.8499999642372131D);
/*  90 */         renderer.func_147784_q(lidBlock, x, y, z);
/*     */       } 
/*  92 */       if ((te.rotation & 0x3) == 1) {
/*     */         
/*  94 */         renderer.func_147782_a(0.15000000596046448D, 0.10000000149011612D, 0.10000000149011612D, 0.8499999642372131D, 0.15000000596046448D, 0.949999988079071D);
/*  95 */         renderer.func_147784_q(lidBlock, x, y, z);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 100 */     renderer.field_147837_f = false;
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(RenderBlocks renderer, int i) {
/* 107 */     renderer.field_147875_q = i;
/* 108 */     renderer.field_147873_r = i;
/* 109 */     renderer.field_147869_t = i;
/* 110 */     renderer.field_147871_s = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
/*     */     Block lidBlock;
/* 118 */     if (meta < 16) {
/*     */       
/* 120 */       lidBlock = TFCBlocks.woodSupportH;
/*     */     }
/*     */     else {
/*     */       
/* 124 */       lidBlock = TFCBlocks.woodSupportH2;
/*     */     } 
/*     */     
/* 127 */     renderer.func_147782_a(0.15000000596046448D, 0.10000000149011612D, 0.15000000596046448D, 0.8499999642372131D, 0.949999988079071D, 0.8499999642372131D);
/* 128 */     rotate(renderer, 1);
/* 129 */     renderInvBlock(lidBlock, meta, renderer);
/*     */     
/* 131 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.15000000596046448D, 0.15000000596046448D, 1.0D, 0.8499999642372131D);
/* 132 */     rotate(renderer, 1);
/* 133 */     renderInvBlock(block, meta, renderer);
/* 134 */     rotate(renderer, 0);
/* 135 */     renderInvBlockHoop(block, meta, renderer);
/*     */     
/* 137 */     renderer.func_147782_a(0.8499999642372131D, 0.0D, 0.15000000596046448D, 0.8999999761581421D, 1.0D, 0.8499999642372131D);
/* 138 */     rotate(renderer, 1);
/* 139 */     renderInvBlock(block, meta, renderer);
/* 140 */     rotate(renderer, 0);
/* 141 */     renderInvBlockHoop(block, meta, renderer);
/*     */     
/* 143 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.8999999761581421D, 1.0D, 0.15000000596046448D);
/* 144 */     rotate(renderer, 1);
/* 145 */     renderInvBlock(block, meta, renderer);
/* 146 */     rotate(renderer, 0);
/* 147 */     renderInvBlockHoop(block, meta, renderer);
/*     */     
/* 149 */     renderer.func_147782_a(0.10000000149011612D, 0.0D, 0.8499999642372131D, 0.8999999761581421D, 1.0D, 0.8999999761581421D);
/* 150 */     rotate(renderer, 1);
/* 151 */     renderInvBlock(block, meta, renderer);
/* 152 */     rotate(renderer, 0);
/* 153 */     renderInvBlockHoop(block, meta, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 165 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 170 */     Tessellator var14 = Tessellator.field_78398_a;
/* 171 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 172 */     var14.func_78382_b();
/* 173 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 174 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 175 */     var14.func_78381_a();
/* 176 */     var14.func_78382_b();
/* 177 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 178 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 179 */     var14.func_78381_a();
/* 180 */     var14.func_78382_b();
/* 181 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 182 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 183 */     var14.func_78381_a();
/* 184 */     var14.func_78382_b();
/* 185 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 186 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 187 */     var14.func_78381_a();
/* 188 */     var14.func_78382_b();
/* 189 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 190 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 191 */     var14.func_78381_a();
/* 192 */     var14.func_78382_b();
/* 193 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 194 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 195 */     var14.func_78381_a();
/* 196 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlockHoop(Block block, int m, RenderBlocks renderer) {
/* 201 */     Tessellator var14 = Tessellator.field_78398_a;
/* 202 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 203 */     var14.func_78382_b();
/* 204 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 205 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(10, m));
/* 206 */     var14.func_78381_a();
/* 207 */     var14.func_78382_b();
/* 208 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 209 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(11, m));
/* 210 */     var14.func_78381_a();
/* 211 */     var14.func_78382_b();
/* 212 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 213 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(12, m));
/* 214 */     var14.func_78381_a();
/* 215 */     var14.func_78382_b();
/* 216 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 217 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(13, m));
/* 218 */     var14.func_78381_a();
/* 219 */     var14.func_78382_b();
/* 220 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 221 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(14, m));
/* 222 */     var14.func_78381_a();
/* 223 */     var14.func_78382_b();
/* 224 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 225 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(15, m));
/* 226 */     var14.func_78381_a();
/* 227 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */