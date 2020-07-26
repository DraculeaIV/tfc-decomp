/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockHopper;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
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
/*     */ public class RenderHopper
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  21 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/*  29 */     renderer.func_147771_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  35 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  36 */     tessellator.func_78380_c(block.func_149677_c(renderer.field_147845_a, x, y, z));
/*  37 */     int l = block.func_149720_d(renderer.field_147845_a, x, y, z);
/*  38 */     float f = (l >> 16 & 0xFF) / 255.0F;
/*  39 */     float f1 = (l >> 8 & 0xFF) / 255.0F;
/*  40 */     float f2 = (l & 0xFF) / 255.0F;
/*     */     
/*  42 */     if (EntityRenderer.field_78517_a) {
/*     */       
/*  44 */       float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
/*  45 */       float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
/*  46 */       float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
/*  47 */       f = f3;
/*  48 */       f1 = f4;
/*  49 */       f2 = f5;
/*     */     } 
/*     */     
/*  52 */     tessellator.func_78386_a(f, f1, f2);
/*  53 */     return renderBlockHopperMetadata(block, x, y, z, renderer.field_147845_a.func_72805_g(x, y, z), false, renderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderBlockHopperMetadata(Block block, int x, int y, int z, int meta, boolean unknownBool, RenderBlocks renderer) {
/*  58 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  59 */     int i1 = BlockHopper.getDirectionFromMetadata(meta);
/*  60 */     double d0 = 0.625D;
/*  61 */     renderer.func_147782_a(0.0D, d0, 0.0D, 1.0D, 1.0D, 1.0D);
/*     */     
/*  63 */     if (unknownBool) {
/*     */       
/*  65 */       tessellator.func_78382_b();
/*  66 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/*  67 */       renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 0, meta));
/*  68 */       tessellator.func_78381_a();
/*  69 */       tessellator.func_78382_b();
/*  70 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/*  71 */       renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 1, meta));
/*  72 */       tessellator.func_78381_a();
/*  73 */       tessellator.func_78382_b();
/*  74 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/*  75 */       renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 2, meta));
/*  76 */       tessellator.func_78381_a();
/*  77 */       tessellator.func_78382_b();
/*  78 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/*  79 */       renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 3, meta));
/*  80 */       tessellator.func_78381_a();
/*  81 */       tessellator.func_78382_b();
/*  82 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/*  83 */       renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 4, meta));
/*  84 */       tessellator.func_78381_a();
/*  85 */       tessellator.func_78382_b();
/*  86 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/*  87 */       renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, renderer.func_147787_a(block, 5, meta));
/*  88 */       tessellator.func_78381_a();
/*     */     }
/*     */     else {
/*     */       
/*  92 */       renderer.func_147784_q(block, x, y, z);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (!unknownBool) {
/*     */       
/*  99 */       tessellator.func_78380_c(block.func_149677_c(renderer.field_147845_a, x, y, z));
/* 100 */       int j1 = block.func_149720_d(renderer.field_147845_a, x, y, z);
/* 101 */       float f = (j1 >> 16 & 0xFF) / 255.0F;
/* 102 */       float f3 = (j1 >> 8 & 0xFF) / 255.0F;
/* 103 */       float f2 = (j1 & 0xFF) / 255.0F;
/*     */       
/* 105 */       if (EntityRenderer.field_78517_a) {
/*     */         
/* 107 */         float f6 = (f * 30.0F + f3 * 59.0F + f2 * 11.0F) / 100.0F;
/* 108 */         float f4 = (f * 30.0F + f3 * 70.0F) / 100.0F;
/* 109 */         float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
/* 110 */         f = f6;
/* 111 */         f3 = f4;
/* 112 */         f2 = f5;
/*     */       } 
/*     */       
/* 115 */       tessellator.func_78386_a(f, f3, f2);
/*     */     } 
/*     */     
/* 118 */     IIcon iicon = BlockHopper.getHopperIcon("hopper_outside");
/* 119 */     IIcon iicon1 = BlockHopper.getHopperIcon("hopper_inside");
/* 120 */     float f1 = 0.125F;
/*     */     
/* 122 */     if (unknownBool) {
/*     */       
/* 124 */       tessellator.func_78382_b();
/* 125 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 126 */       renderer.func_147764_f(block, (-1.0F + f1), 0.0D, 0.0D, iicon);
/* 127 */       tessellator.func_78381_a();
/* 128 */       tessellator.func_78382_b();
/* 129 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 130 */       renderer.func_147798_e(block, (1.0F - f1), 0.0D, 0.0D, iicon);
/* 131 */       tessellator.func_78381_a();
/* 132 */       tessellator.func_78382_b();
/* 133 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 134 */       renderer.func_147734_d(block, 0.0D, 0.0D, (-1.0F + f1), iicon);
/* 135 */       tessellator.func_78381_a();
/* 136 */       tessellator.func_78382_b();
/* 137 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 138 */       renderer.func_147761_c(block, 0.0D, 0.0D, (1.0F - f1), iicon);
/* 139 */       tessellator.func_78381_a();
/* 140 */       tessellator.func_78382_b();
/* 141 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 142 */       renderer.func_147806_b(block, 0.0D, -1.0D + d0, 0.0D, iicon1);
/* 143 */       tessellator.func_78381_a();
/*     */     }
/*     */     else {
/*     */       
/* 147 */       renderer.func_147764_f(block, (x - 1.0F + f1), y, z, iicon);
/* 148 */       renderer.func_147798_e(block, (x + 1.0F - f1), y, z, iicon);
/* 149 */       renderer.func_147734_d(block, x, y, (z - 1.0F + f1), iicon);
/* 150 */       renderer.func_147761_c(block, x, y, (z + 1.0F - f1), iicon);
/* 151 */       renderer.func_147806_b(block, x, (y - 1.0F) + d0, z, iicon1);
/*     */     } 
/*     */     
/* 154 */     renderer.func_147757_a(iicon);
/* 155 */     double d3 = 0.25D;
/* 156 */     double d4 = 0.25D;
/* 157 */     renderer.func_147782_a(d3, d4, d3, 1.0D - d3, d0 - 0.002D, 1.0D - d3);
/*     */     
/* 159 */     if (unknownBool) {
/*     */       
/* 161 */       tessellator.func_78382_b();
/* 162 */       tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 163 */       renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, iicon);
/* 164 */       tessellator.func_78381_a();
/* 165 */       tessellator.func_78382_b();
/* 166 */       tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 167 */       renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, iicon);
/* 168 */       tessellator.func_78381_a();
/* 169 */       tessellator.func_78382_b();
/* 170 */       tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 171 */       renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, iicon);
/* 172 */       tessellator.func_78381_a();
/* 173 */       tessellator.func_78382_b();
/* 174 */       tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 175 */       renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, iicon);
/* 176 */       tessellator.func_78381_a();
/* 177 */       tessellator.func_78382_b();
/* 178 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 179 */       renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, iicon);
/* 180 */       tessellator.func_78381_a();
/* 181 */       tessellator.func_78382_b();
/* 182 */       tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 183 */       renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, iicon);
/* 184 */       tessellator.func_78381_a();
/*     */     }
/*     */     else {
/*     */       
/* 188 */       renderer.func_147784_q(block, x, y, z);
/*     */     } 
/*     */     
/* 191 */     if (!unknownBool) {
/*     */       
/* 193 */       double d1 = 0.375D;
/* 194 */       double d2 = 0.25D;
/* 195 */       renderer.func_147757_a(iicon);
/*     */       
/* 197 */       if (i1 == 0) {
/*     */         
/* 199 */         renderer.func_147782_a(d1, 0.0D, d1, 1.0D - d1, 0.25D, 1.0D - d1);
/* 200 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */       
/* 203 */       if (i1 == 2) {
/*     */         
/* 205 */         renderer.func_147782_a(d1, d4, 0.0D, 1.0D - d1, d4 + d2, d3);
/* 206 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */       
/* 209 */       if (i1 == 3) {
/*     */         
/* 211 */         renderer.func_147782_a(d1, d4, 1.0D - d3, 1.0D - d1, d4 + d2, 1.0D);
/* 212 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */       
/* 215 */       if (i1 == 4) {
/*     */         
/* 217 */         renderer.func_147782_a(0.0D, d4, d1, d3, d4 + d2, 1.0D - d1);
/* 218 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */       
/* 221 */       if (i1 == 5) {
/*     */         
/* 223 */         renderer.func_147782_a(1.0D - d3, d4, d1, 1.0D, d4 + d2, 1.0D - d1);
/* 224 */         renderer.func_147784_q(block, x, y, z);
/*     */       } 
/*     */     } 
/*     */     
/* 228 */     renderer.func_147771_a();
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 235 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, RenderBlocks renderer) {
/* 240 */     Tessellator tess = Tessellator.field_78398_a;
/* 241 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 242 */     tess.func_78382_b();
/* 243 */     tess.func_78375_b(0.0F, -1.0F, 0.0F);
/* 244 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 2));
/* 245 */     tess.func_78381_a();
/* 246 */     tess.func_78382_b();
/* 247 */     tess.func_78375_b(0.0F, 1.0F, 0.0F);
/* 248 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 2));
/* 249 */     tess.func_78381_a();
/* 250 */     tess.func_78382_b();
/* 251 */     tess.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 252 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 1));
/* 253 */     tess.func_78381_a();
/* 254 */     tess.func_78382_b();
/* 255 */     tess.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 256 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 3));
/* 257 */     tess.func_78381_a();
/* 258 */     tess.func_78382_b();
/* 259 */     tess.func_78375_b(0.0F, 0.0F, -1.0F);
/* 260 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 0));
/* 261 */     tess.func_78381_a();
/* 262 */     tess.func_78382_b();
/* 263 */     tess.func_78375_b(0.0F, 0.0F, 1.0F);
/* 264 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 0));
/* 265 */     tess.func_78381_a();
/* 266 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */