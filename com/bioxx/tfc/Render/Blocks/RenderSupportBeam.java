/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderSupportBeam
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean renderWoodSupportBeamH(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/*  17 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */     
/*  19 */     Boolean hasVerticalBeam = Boolean.valueOf(false);
/*  20 */     Boolean hasHorizontalBeamX = Boolean.valueOf(false);
/*  21 */     Boolean hasHorizontalBeamZ = Boolean.valueOf(false);
/*     */ 
/*     */     
/*  24 */     if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j - 1, k))) {
/*     */       
/*  26 */       renderblocks.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/*  27 */       renderblocks.func_147784_q(block, i, j, k);
/*  28 */       hasVerticalBeam = Boolean.valueOf(true);
/*     */     } 
/*     */ 
/*     */     
/*  32 */     if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i - 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i - 1, j, k))) {
/*     */       
/*  34 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i + 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i + 1, j, k)))
/*     */       {
/*  36 */         if (hasVerticalBeam.booleanValue()) {
/*     */           
/*  38 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.25D, 1.0D, 0.75D);
/*  39 */           renderblocks.func_147784_q(block, i, j, k);
/*  40 */           renderblocks.func_147782_a(0.75D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/*  41 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*  43 */         else if (!hasVerticalBeam.booleanValue()) {
/*     */           
/*  45 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/*  46 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*  48 */         hasHorizontalBeamX = Boolean.valueOf(true);
/*     */       }
/*     */       else
/*     */       {
/*  52 */         if (hasVerticalBeam.booleanValue()) {
/*     */           
/*  54 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.25D, 1.0D, 0.75D);
/*  55 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */         else {
/*     */           
/*  59 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.75D, 1.0D, 0.75D);
/*  60 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*  62 */         hasHorizontalBeamX = Boolean.valueOf(true);
/*     */       }
/*     */     
/*  65 */     } else if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i + 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i + 1, j, k))) {
/*     */       
/*  67 */       if (hasVerticalBeam.booleanValue()) {
/*     */         
/*  69 */         renderblocks.func_147782_a(0.75D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/*  70 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else {
/*     */         
/*  74 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/*  75 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       } 
/*  77 */       hasHorizontalBeamX = Boolean.valueOf(true);
/*     */     } 
/*     */     
/*  80 */     if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k - 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k - 1))) {
/*     */       
/*  82 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k + 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k + 1)))
/*     */       {
/*  84 */         if (hasVerticalBeam.booleanValue()) {
/*     */           
/*  86 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.25D);
/*  87 */           renderblocks.func_147784_q(block, i, j, k);
/*  88 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.75D, 0.75D, 1.0D, 1.0D);
/*  89 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*  91 */         else if (!hasVerticalBeam.booleanValue()) {
/*     */           
/*  93 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 1.0D);
/*  94 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/*  96 */         hasHorizontalBeamZ = Boolean.valueOf(true);
/*     */       }
/*     */       else
/*     */       {
/* 100 */         if (hasVerticalBeam.booleanValue()) {
/*     */           
/* 102 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.25D);
/* 103 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/*     */         else {
/*     */           
/* 107 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.75D);
/* 108 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         } 
/* 110 */         hasHorizontalBeamZ = Boolean.valueOf(true);
/*     */       }
/*     */     
/* 113 */     } else if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k + 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k + 1))) {
/*     */       
/* 115 */       if (hasVerticalBeam.booleanValue()) {
/*     */         
/* 117 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.75D, 0.75D, 1.0D, 1.0D);
/* 118 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else {
/*     */         
/* 122 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.25D, 0.75D, 1.0D, 1.0D);
/* 123 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       } 
/* 125 */       hasHorizontalBeamZ = Boolean.valueOf(true);
/*     */     } 
/*     */     
/* 128 */     float minX = -1.0F;
/* 129 */     float minY = -1.0F;
/* 130 */     float minZ = -1.0F;
/*     */     
/* 132 */     float maxX = -1.0F;
/* 133 */     float maxY = -1.0F;
/* 134 */     float maxZ = -1.0F;
/*     */     
/* 136 */     if (hasHorizontalBeamX.booleanValue()) {
/*     */       
/* 138 */       minX = 0.0F;
/* 139 */       maxX = 1.0F;
/* 140 */       minZ = 0.25F;
/* 141 */       maxZ = 0.75F;
/*     */     } 
/* 143 */     if (hasHorizontalBeamZ.booleanValue()) {
/*     */       
/* 145 */       if (maxX == -1.0F) {
/*     */         
/* 147 */         minX = 0.25F;
/* 148 */         maxX = 0.75F;
/*     */       } 
/*     */       
/* 151 */       minZ = 0.0F;
/* 152 */       maxZ = 1.0F;
/*     */     } 
/*     */     
/* 155 */     if (hasVerticalBeam.booleanValue()) {
/*     */       
/* 157 */       minY = 0.0F;
/* 158 */       maxY = 1.0F;
/* 159 */       if (maxX == -1.0F) {
/*     */         
/* 161 */         minX = 0.25F;
/* 162 */         maxX = 0.75F;
/*     */       } 
/* 164 */       if (maxZ == -1.0F)
/*     */       {
/* 166 */         minZ = 0.25F;
/* 167 */         maxZ = 0.75F;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 172 */       minY = 0.5F;
/* 173 */       maxY = 1.0F;
/*     */     } 
/*     */     
/* 176 */     renderblocks.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ);
/*     */     
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean renderWoodSupportBeamV(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/* 183 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */     
/* 185 */     Boolean hasVerticalBeam = Boolean.valueOf(false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     if ((blockAccess.func_147439_a(i, j - 1, k).func_149662_c() || TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j - 1, k))) && TFCBlocks.isBlockVSupport(block)) {
/*     */       
/* 206 */       renderblocks.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/* 207 */       renderblocks.func_147784_q(block, i, j, k);
/* 208 */       hasVerticalBeam = Boolean.valueOf(true);
/*     */     } 
/*     */ 
/*     */     
/* 212 */     if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i - 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i - 1, j, k))) {
/*     */       
/* 214 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i + 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i + 1, j, k)))
/*     */       {
/* 216 */         if (hasVerticalBeam.booleanValue())
/*     */         {
/* 218 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.25D, 1.0D, 0.75D);
/* 219 */           renderblocks.func_147784_q(block, i, j, k);
/* 220 */           renderblocks.func_147782_a(0.75D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/* 221 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/* 223 */         else if (!hasVerticalBeam.booleanValue())
/*     */         {
/* 225 */           renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/* 226 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 232 */       else if (hasVerticalBeam.booleanValue())
/*     */       {
/* 234 */         renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.25D, 1.0D, 0.75D);
/* 235 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else
/*     */       {
/* 239 */         renderblocks.func_147782_a(0.0D, 0.5D, 0.25D, 0.75D, 1.0D, 0.75D);
/* 240 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 245 */     else if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i + 1, j, k)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i + 1, j, k))) {
/*     */       
/* 247 */       if (hasVerticalBeam.booleanValue()) {
/*     */         
/* 249 */         renderblocks.func_147782_a(0.75D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/* 250 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else {
/*     */         
/* 254 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.25D, 1.0D, 1.0D, 0.75D);
/* 255 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 260 */     if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k - 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k - 1))) {
/*     */       
/* 262 */       if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k + 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k + 1)))
/*     */       {
/* 264 */         if (hasVerticalBeam.booleanValue())
/*     */         {
/* 266 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.25D);
/* 267 */           renderblocks.func_147784_q(block, i, j, k);
/* 268 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.75D, 0.75D, 1.0D, 1.0D);
/* 269 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         }
/* 271 */         else if (!hasVerticalBeam.booleanValue())
/*     */         {
/* 273 */           renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 1.0D);
/* 274 */           renderblocks.func_147784_q(block, i, j, k);
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 280 */       else if (hasVerticalBeam.booleanValue())
/*     */       {
/* 282 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.25D);
/* 283 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else
/*     */       {
/* 287 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.0D, 0.75D, 1.0D, 0.75D);
/* 288 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 293 */     else if (TFCBlocks.isBlockVSupport(blockAccess.func_147439_a(i, j, k + 1)) || TFCBlocks.isBlockHSupport(blockAccess.func_147439_a(i, j, k + 1))) {
/*     */       
/* 295 */       if (hasVerticalBeam.booleanValue()) {
/*     */         
/* 297 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.75D, 0.75D, 1.0D, 1.0D);
/* 298 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       }
/*     */       else {
/*     */         
/* 302 */         renderblocks.func_147782_a(0.25D, 0.5D, 0.25D, 0.75D, 1.0D, 1.0D);
/* 303 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 308 */     float minX = 0.25F;
/* 309 */     float minY = 0.0F;
/* 310 */     float minZ = 0.25F;
/*     */     
/* 312 */     float maxX = 0.75F;
/* 313 */     float maxY = 1.0F;
/* 314 */     float maxZ = 0.75F;
/*     */ 
/*     */     
/* 317 */     renderblocks.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ);
/*     */     
/* 319 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSurroundedByWater(IBlockAccess access, int i, int j, int k) {
/* 324 */     if (access.func_147439_a(i, j + 1, k).func_149688_o() == Material.field_151586_h) {
/* 325 */       return true;
/*     */     }
/* 327 */     return (access.func_147439_a(i + 1, j, k).func_149688_o() == Material.field_151586_h || access.func_147439_a(i - 1, j, k).func_149688_o() == Material.field_151586_h || access
/* 328 */       .func_147439_a(i, j, k + 1).func_149688_o() == Material.field_151586_h || access.func_147439_a(i, j, k - 1).func_149688_o() == Material.field_151586_h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 335 */     renderer.func_147757_a(block.func_149691_a(0, metadata));
/* 336 */     if (modelID == TFCBlocks.woodSupportRenderIdH) {
/*     */       
/* 338 */       renderer.func_147782_a(0.25D, 0.25D, 0.0D, 0.75D, 0.75D, 1.0D);
/* 339 */       renderInvBlock(block, renderer);
/*     */     }
/* 341 */     else if (modelID == TFCBlocks.woodSupportRenderIdV) {
/*     */       
/* 343 */       renderer.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
/* 344 */       renderInvBlock(block, renderer);
/*     */     } 
/* 346 */     renderer.func_147771_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/* 353 */     if (modelId == TFCBlocks.woodSupportRenderIdH)
/*     */     {
/* 355 */       return renderWoodSupportBeamH(block, i, j, k, renderer);
/*     */     }
/* 357 */     if (modelId == TFCBlocks.woodSupportRenderIdV)
/*     */     {
/* 359 */       return renderWoodSupportBeamV(block, i, j, k, renderer);
/*     */     }
/* 361 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 373 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, RenderBlocks renderer) {
/* 378 */     Tessellator var14 = Tessellator.field_78398_a;
/* 379 */     var14.func_78382_b();
/* 380 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 381 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, 0));
/* 382 */     var14.func_78381_a();
/* 383 */     var14.func_78382_b();
/* 384 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 385 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, 0));
/* 386 */     var14.func_78381_a();
/* 387 */     var14.func_78382_b();
/* 388 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 389 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, 0));
/* 390 */     var14.func_78381_a();
/* 391 */     var14.func_78382_b();
/* 392 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 393 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, 0));
/* 394 */     var14.func_78381_a();
/* 395 */     var14.func_78382_b();
/* 396 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 397 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, 0));
/* 398 */     var14.func_78381_a();
/* 399 */     var14.func_78382_b();
/* 400 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 401 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, 0));
/* 402 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderSupportBeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */