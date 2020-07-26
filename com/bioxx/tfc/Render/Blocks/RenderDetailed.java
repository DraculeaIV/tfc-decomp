/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Render.RenderBlocksLightCache;
/*     */ import com.bioxx.tfc.TileEntities.TEDetailed;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderDetailed
/*     */ {
/*     */   private static RenderBlocksLightCache renderer;
/*     */   
/*     */   public static boolean renderBlockDetailed(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/*  16 */     TEDetailed te = (TEDetailed)renderblocks.field_147845_a.func_147438_o(i, j, k);
/*     */     
/*  18 */     if (renderer == null) {
/*  19 */       renderer = new RenderBlocksLightCache(renderblocks);
/*     */     } else {
/*  21 */       renderer.update(renderblocks);
/*     */     } 
/*     */     
/*  24 */     renderer.disableRender();
/*  25 */     renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*  26 */     renderer.func_147784_q(block, i, j, k);
/*  27 */     renderer.enableRender();
/*     */     
/*  29 */     if (te.typeID <= 0) {
/*  30 */       return false;
/*     */     }
/*  32 */     int type = te.typeID;
/*  33 */     int meta = te.metaID;
/*     */     
/*  35 */     IIcon myTexture = (renderblocks.field_147840_d == null) ? Block.func_149729_e(te.typeID).func_149691_a(0, te.metaID) : renderblocks.field_147840_d;
/*     */     
/*  37 */     for (int subX = 0; subX < 2; subX++) {
/*     */       
/*  39 */       for (int subZ = 0; subZ < 2; subZ++) {
/*     */         
/*  41 */         for (int subY = 0; subY < 2; subY++) {
/*     */           
/*  43 */           if (!te.isQuadSolid(subX, subY, subZ)) {
/*     */             
/*  45 */             renderMiniBlock(block, i, j, k, subX, subY, subZ, te, type, meta, myTexture);
/*     */           }
/*     */           else {
/*     */             
/*  49 */             float minX = 0.5F * subX;
/*  50 */             float maxX = minX + 0.5F;
/*  51 */             float minY = 0.5F * subY;
/*  52 */             float maxY = minY + 0.5F;
/*  53 */             float minZ = 0.5F * subZ;
/*  54 */             float maxZ = minZ + 0.5F;
/*     */             
/*  56 */             renderer.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ);
/*  57 */             renderer.renderCachedBlock(block, i, j, k, myTexture);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  62 */     renderer.func_147771_a();
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderMiniBlock(Block block, int i, int j, int k, int x, int y, int z, TEDetailed te, int type, int meta, IIcon myTexture) {
/*  68 */     for (int subX = x * 4; subX < 4 + x * 4; subX++) {
/*     */       
/*  70 */       for (int subZ = z * 4; subZ < 4 + z * 4; subZ++) {
/*     */         
/*  72 */         for (int subY = y * 4; subY < 4 + y * 4; subY++) {
/*     */           
/*  74 */           boolean subExists = isOpaque(te, subX, subY, subZ);
/*  75 */           if (subExists) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  82 */             boolean isVisible = (isTransparent(te, subX - 1, subY, subZ) || isTransparent(te, subX + 1, subY, subZ) || isTransparent(te, subX, subY - 1, subZ) || isTransparent(te, subX, subY + 1, subZ) || isTransparent(te, subX, subY, subZ - 1) || isTransparent(te, subX, subY, subZ + 1));
/*     */             
/*  84 */             if (isVisible) {
/*     */               
/*  86 */               float minX = 0.125F * subX;
/*  87 */               float maxX = minX + 0.125F;
/*  88 */               float minY = 0.125F * subY;
/*  89 */               float maxY = minY + 0.125F;
/*  90 */               float minZ = 0.125F * subZ;
/*  91 */               float maxZ = minZ + 0.125F;
/*     */               
/*  93 */               renderer.func_147782_a(minX, minY, minZ, maxX, maxY, maxZ);
/*  94 */               renderer.renderCachedBlock(block, i, j, k, myTexture);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isOpaque(TEDetailed te, int x, int y, int z) {
/* 104 */     return te.data.get((x * 8 + z) * 8 + y);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isTransparent(TEDetailed te, int x, int y, int z) {
/* 109 */     if (x < 0 || x >= 8 || y < 0 || y >= 8 || z < 0 || z >= 8) {
/* 110 */       return true;
/*     */     }
/* 112 */     return !te.data.get((x * 8 + z) * 8 + y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderDetailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */