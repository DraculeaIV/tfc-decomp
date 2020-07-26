/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEFenceGate;
/*     */ import com.bioxx.tfc.api.Interfaces.IMultipleBlock;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDirectional;
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
/*     */ public class RenderFenceGate
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int par2, int par3, int par4, Block block, int modelId, RenderBlocks renderer) {
/*  26 */     Block par1BlockFenceGate = ((IMultipleBlock)block).getBlockTypeForRender();
/*  27 */     boolean flag = true;
/*  28 */     int l = ((TEFenceGate)renderer.field_147845_a.func_147438_o(par2, par3, par4)).getDirection();
/*  29 */     boolean flag1 = ((TEFenceGate)renderer.field_147845_a.func_147438_o(par2, par3, par4)).getOpen();
/*  30 */     int i1 = BlockDirectional.func_149895_l(l);
/*  31 */     float f = 0.375F;
/*  32 */     float f1 = 0.5625F;
/*  33 */     float f2 = 0.75F;
/*  34 */     float f3 = 0.9375F;
/*  35 */     float f4 = 0.3125F;
/*  36 */     float f5 = 1.0F;
/*     */     
/*  38 */     if (((i1 == 2 || i1 == 0) && renderer.field_147845_a
/*  39 */       .func_147439_a(par2 - 1, par3, par4) instanceof com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall && renderer.field_147845_a
/*  40 */       .func_147439_a(par2 + 1, par3, par4) instanceof com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall) || ((i1 == 3 || i1 == 1) && renderer.field_147845_a
/*     */       
/*  42 */       .func_147439_a(par2, par3, par4 - 1) instanceof com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall && renderer.field_147845_a
/*  43 */       .func_147439_a(par2, par3, par4 + 1) instanceof com.bioxx.tfc.Blocks.Vanilla.BlockCustomWall)) {
/*     */       
/*  45 */       f -= 0.1875F;
/*  46 */       f1 -= 0.1875F;
/*  47 */       f2 -= 0.1875F;
/*  48 */       f3 -= 0.1875F;
/*  49 */       f4 -= 0.1875F;
/*  50 */       f5 -= 0.1875F;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (i1 != 3 && i1 != 1) {
/*     */       
/*  60 */       float f6 = 0.0F;
/*  61 */       float f8 = 0.125F;
/*  62 */       float f7 = 0.4375F;
/*  63 */       float f9 = 0.5625F;
/*  64 */       renderer.func_147782_a(f6, f4, f7, f8, f5, f9);
/*  65 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*  66 */       f6 = 0.875F;
/*  67 */       f8 = 1.0F;
/*  68 */       renderer.func_147782_a(f6, f4, f7, f8, f5, f9);
/*  69 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */     }
/*     */     else {
/*     */       
/*  73 */       renderer.field_147867_u = 1;
/*  74 */       float f6 = 0.4375F;
/*  75 */       float f8 = 0.5625F;
/*  76 */       float f7 = 0.0F;
/*  77 */       float f9 = 0.125F;
/*  78 */       renderer.func_147782_a(f6, f4, f7, f8, f5, f9);
/*  79 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*  80 */       f7 = 0.875F;
/*  81 */       f9 = 1.0F;
/*  82 */       renderer.func_147782_a(f6, f4, f7, f8, f5, f9);
/*  83 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*  84 */       renderer.field_147867_u = 0;
/*     */     } 
/*     */     
/*  87 */     if (flag1) {
/*     */       
/*  89 */       if (i1 == 2 || i1 == 0) {
/*  90 */         renderer.field_147867_u = 1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       if (i1 == 3)
/*     */       {
/*  98 */         float f6 = 0.0F;
/*  99 */         float f8 = 0.125F;
/* 100 */         float f7 = 0.875F;
/* 101 */         float f9 = 1.0F;
/*     */ 
/*     */ 
/*     */         
/* 105 */         renderer.func_147782_a(0.8125D, f, 0.0D, 0.9375D, f3, 0.125D);
/* 106 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 107 */         renderer.func_147782_a(0.8125D, f, 0.875D, 0.9375D, f3, 1.0D);
/* 108 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 109 */         renderer.func_147782_a(0.5625D, f, 0.0D, 0.8125D, f1, 0.125D);
/* 110 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 111 */         renderer.func_147782_a(0.5625D, f, 0.875D, 0.8125D, f1, 1.0D);
/* 112 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 113 */         renderer.func_147782_a(0.5625D, f2, 0.0D, 0.8125D, f3, 0.125D);
/* 114 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 115 */         renderer.func_147782_a(0.5625D, f2, 0.875D, 0.8125D, f3, 1.0D);
/* 116 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */       }
/* 118 */       else if (i1 == 1)
/*     */       {
/* 120 */         float f6 = 0.0F;
/* 121 */         float f8 = 0.125F;
/* 122 */         float f7 = 0.875F;
/* 123 */         float f9 = 1.0F;
/*     */ 
/*     */ 
/*     */         
/* 127 */         renderer.func_147782_a(0.0625D, f, 0.0D, 0.1875D, f3, 0.125D);
/* 128 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 129 */         renderer.func_147782_a(0.0625D, f, 0.875D, 0.1875D, f3, 1.0D);
/* 130 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 131 */         renderer.func_147782_a(0.1875D, f, 0.0D, 0.4375D, f1, 0.125D);
/* 132 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 133 */         renderer.func_147782_a(0.1875D, f, 0.875D, 0.4375D, f1, 1.0D);
/* 134 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 135 */         renderer.func_147782_a(0.1875D, f2, 0.0D, 0.4375D, f3, 0.125D);
/* 136 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 137 */         renderer.func_147782_a(0.1875D, f2, 0.875D, 0.4375D, f3, 1.0D);
/* 138 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */       }
/* 140 */       else if (i1 == 0)
/*     */       {
/* 142 */         float f6 = 0.0F;
/* 143 */         float f8 = 0.125F;
/* 144 */         float f7 = 0.875F;
/* 145 */         float f9 = 1.0F;
/*     */ 
/*     */ 
/*     */         
/* 149 */         renderer.func_147782_a(0.0D, f, 0.8125D, 0.125D, f3, 0.9375D);
/* 150 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 151 */         renderer.func_147782_a(0.875D, f, 0.8125D, 1.0D, f3, 0.9375D);
/* 152 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 153 */         renderer.func_147782_a(0.0D, f, 0.5625D, 0.125D, f1, 0.8125D);
/* 154 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 155 */         renderer.func_147782_a(0.875D, f, 0.5625D, 1.0D, f1, 0.8125D);
/* 156 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 157 */         renderer.func_147782_a(0.0D, f2, 0.5625D, 0.125D, f3, 0.8125D);
/* 158 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 159 */         renderer.func_147782_a(0.875D, f2, 0.5625D, 1.0D, f3, 0.8125D);
/* 160 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */       }
/* 162 */       else if (i1 == 2)
/*     */       {
/* 164 */         float f6 = 0.0F;
/* 165 */         float f8 = 0.125F;
/* 166 */         float f7 = 0.875F;
/* 167 */         float f9 = 1.0F;
/*     */ 
/*     */ 
/*     */         
/* 171 */         renderer.func_147782_a(0.0D, f, 0.0625D, 0.125D, f3, 0.1875D);
/* 172 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 173 */         renderer.func_147782_a(0.875D, f, 0.0625D, 1.0D, f3, 0.1875D);
/* 174 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 175 */         renderer.func_147782_a(0.0D, f, 0.1875D, 0.125D, f1, 0.4375D);
/* 176 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 177 */         renderer.func_147782_a(0.875D, f, 0.1875D, 1.0D, f1, 0.4375D);
/* 178 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 179 */         renderer.func_147782_a(0.0D, f2, 0.1875D, 0.125D, f3, 0.4375D);
/* 180 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 181 */         renderer.func_147782_a(0.875D, f2, 0.1875D, 1.0D, f3, 0.4375D);
/* 182 */         renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */       }
/*     */     
/* 185 */     } else if (i1 != 3 && i1 != 1) {
/*     */       
/* 187 */       float f6 = 0.375F;
/* 188 */       float f8 = 0.5F;
/* 189 */       float f7 = 0.4375F;
/* 190 */       float f9 = 0.5625F;
/* 191 */       renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 192 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 193 */       f6 = 0.5F;
/* 194 */       f8 = 0.625F;
/* 195 */       renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 196 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 197 */       f6 = 0.625F;
/* 198 */       f8 = 0.875F;
/* 199 */       renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 200 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 201 */       renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 202 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 203 */       f6 = 0.125F;
/* 204 */       f8 = 0.375F;
/* 205 */       renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 206 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 207 */       renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 208 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */     }
/*     */     else {
/*     */       
/* 212 */       renderer.field_147867_u = 1;
/* 213 */       float f6 = 0.4375F;
/* 214 */       float f8 = 0.5625F;
/* 215 */       float f7 = 0.375F;
/* 216 */       float f9 = 0.5F;
/* 217 */       renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 218 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 219 */       f7 = 0.5F;
/* 220 */       f9 = 0.625F;
/* 221 */       renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 222 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 223 */       f7 = 0.625F;
/* 224 */       f9 = 0.875F;
/* 225 */       renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 226 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 227 */       renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 228 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 229 */       f7 = 0.125F;
/* 230 */       f9 = 0.375F;
/* 231 */       renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 232 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/* 233 */       renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 234 */       renderer.func_147784_q(par1BlockFenceGate, par2, par3, par4);
/*     */     } 
/*     */     
/* 237 */     renderer.field_147867_u = 0;
/* 238 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 239 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 245 */     int l = 1;
/*     */     
/* 247 */     int i1 = BlockDirectional.func_149895_l(l);
/*     */     
/* 249 */     float f = 0.375F;
/* 250 */     float f1 = 0.5625F;
/* 251 */     float f2 = 0.75F;
/* 252 */     float f3 = 0.9375F;
/* 253 */     float f4 = 0.3125F;
/* 254 */     float f5 = 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     if (i1 != 3 && i1 != 1) {
/*     */       
/* 262 */       float f10 = 0.0F;
/* 263 */       float f12 = 0.125F;
/* 264 */       float f11 = 0.4375F;
/* 265 */       float f13 = 0.5625F;
/* 266 */       renderer.func_147782_a(f10, f4, f11, f12, f5, f13);
/* 267 */       renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 268 */       f10 = 0.875F;
/* 269 */       f12 = 1.0F;
/* 270 */       renderer.func_147782_a(f10, f4, f11, f12, f5, f13);
/* 271 */       renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/*     */     }
/*     */     else {
/*     */       
/* 275 */       renderer.field_147867_u = 1;
/* 276 */       float f10 = 0.4375F;
/* 277 */       float f12 = 0.5625F;
/* 278 */       float f11 = 0.0F;
/* 279 */       float f13 = 0.125F;
/* 280 */       renderer.func_147782_a(f10, f4, f11, f12, f5, f13);
/* 281 */       renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 282 */       f11 = 0.875F;
/* 283 */       f13 = 1.0F;
/* 284 */       renderer.func_147782_a(f10, f4, f11, f12, f5, f13);
/* 285 */       renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 286 */       renderer.field_147867_u = 0;
/*     */     } 
/*     */     
/* 289 */     renderer.field_147867_u = 1;
/* 290 */     float f6 = 0.4375F;
/* 291 */     float f8 = 0.5625F;
/* 292 */     float f7 = 0.375F;
/* 293 */     float f9 = 0.5F;
/* 294 */     renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 295 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 296 */     f7 = 0.5F;
/* 297 */     f9 = 0.625F;
/* 298 */     renderer.func_147782_a(f6, f, f7, f8, f3, f9);
/* 299 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 300 */     f7 = 0.625F;
/* 301 */     f9 = 0.875F;
/* 302 */     renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 303 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 304 */     renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 305 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 306 */     f7 = 0.125F;
/* 307 */     f9 = 0.375F;
/* 308 */     renderer.func_147782_a(f6, f, f7, f8, f1, f9);
/* 309 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/* 310 */     renderer.func_147782_a(f6, f2, f7, f8, f3, f9);
/* 311 */     renderInvBlock2(((IMultipleBlock)block).getBlockTypeForRender(), metadata, renderer);
/*     */     
/* 313 */     renderer.field_147867_u = 0;
/* 314 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 320 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 326 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 331 */     Tessellator var14 = Tessellator.field_78398_a;
/* 332 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 333 */     var14.func_78382_b();
/* 334 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 335 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 336 */     var14.func_78381_a();
/* 337 */     var14.func_78382_b();
/* 338 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 339 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 340 */     var14.func_78381_a();
/* 341 */     var14.func_78382_b();
/* 342 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 343 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 344 */     var14.func_78381_a();
/* 345 */     var14.func_78382_b();
/* 346 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 347 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 348 */     var14.func_78381_a();
/* 349 */     var14.func_78382_b();
/* 350 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 351 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 352 */     var14.func_78381_a();
/* 353 */     var14.func_78382_b();
/* 354 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 355 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 356 */     var14.func_78381_a();
/* 357 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock2(Block block, int m, RenderBlocks renderer) {
/* 362 */     Tessellator var14 = Tessellator.field_78398_a;
/* 363 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 364 */     var14.func_78382_b();
/* 365 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 366 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, m));
/* 367 */     var14.func_78381_a();
/* 368 */     var14.func_78382_b();
/* 369 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 370 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, m));
/* 371 */     var14.func_78381_a();
/* 372 */     var14.func_78382_b();
/* 373 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 374 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, m));
/* 375 */     var14.func_78381_a();
/* 376 */     var14.func_78382_b();
/* 377 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 378 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, m));
/* 379 */     var14.func_78381_a();
/* 380 */     var14.func_78382_b();
/* 381 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 382 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, m));
/* 383 */     var14.func_78381_a();
/* 384 */     var14.func_78382_b();
/* 385 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 386 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, m));
/* 387 */     var14.func_78381_a();
/* 388 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderFenceGate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */