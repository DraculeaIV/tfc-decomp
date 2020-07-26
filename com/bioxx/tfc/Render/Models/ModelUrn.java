/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBox;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.model.PositionTextureVertex;
/*     */ import net.minecraft.client.model.TexturedQuad;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelUrn
/*     */   extends ModelBox
/*     */ {
/*     */   private final TexturedQuad[] quadList;
/*     */   
/*     */   public ModelUrn(ModelRenderer renderer, int textureOffsetX, int textureOffsetY, float originX, float originY, float originZ, int width, int height, int depth, float scale) {
/*  25 */     super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
/*     */ 
/*     */     
/*  28 */     this.quadList = new TexturedQuad[17];
/*  29 */     float maxX = originX + width;
/*  30 */     float maxY = originY + height;
/*  31 */     float maxZ = originZ + depth;
/*     */     
/*  33 */     float height2 = height * 1.5F;
/*  34 */     originY += 0.01F;
/*  35 */     originX -= width;
/*  36 */     originZ -= depth;
/*     */     
/*  38 */     originX -= scale;
/*  39 */     originY -= scale;
/*  40 */     originZ -= scale;
/*     */     
/*  42 */     maxY = originY + height2 + height2;
/*     */     
/*  44 */     maxX += scale;
/*  45 */     maxY += scale;
/*  46 */     maxZ += scale;
/*     */     
/*  48 */     float innerXO = originX + height / 4.0F;
/*  49 */     float innerZO = originZ + height / 4.0F;
/*  50 */     float innerXM = maxX - height / 4.0F;
/*  51 */     float innerZM = maxZ - height / 4.0F;
/*  52 */     float midY1 = originY + height2;
/*  53 */     float midY2 = midY1 + height2 / 2.0F;
/*  54 */     float midY3 = maxY - height2 / 4.0F;
/*     */     
/*  56 */     PositionTextureVertex vert0 = new PositionTextureVertex(innerXO, originY, innerZO, 0.0F, 0.0F);
/*  57 */     PositionTextureVertex vert1 = new PositionTextureVertex(innerXM, originY, innerZO, 0.0F, 8.0F);
/*  58 */     PositionTextureVertex vert2 = new PositionTextureVertex(innerXO, originY, innerZM, 8.0F, 0.0F);
/*  59 */     PositionTextureVertex vert3 = new PositionTextureVertex(innerXM, originY, innerZM, 8.0F, 8.0F);
/*     */     
/*  61 */     PositionTextureVertex vert4 = new PositionTextureVertex(originX, midY1, originZ, 0.0F, 0.0F);
/*  62 */     PositionTextureVertex vert5 = new PositionTextureVertex(maxX, midY1, originZ, 0.0F, 8.0F);
/*  63 */     PositionTextureVertex vert6 = new PositionTextureVertex(originX, midY1, maxZ, 8.0F, 0.0F);
/*  64 */     PositionTextureVertex vert7 = new PositionTextureVertex(maxX, midY1, maxZ, 8.0F, 8.0F);
/*     */     
/*  66 */     PositionTextureVertex vert8 = new PositionTextureVertex(originX, midY2, originZ, 0.0F, 0.0F);
/*  67 */     PositionTextureVertex vert9 = new PositionTextureVertex(maxX, midY2, originZ, 0.0F, 8.0F);
/*  68 */     PositionTextureVertex vert10 = new PositionTextureVertex(originX, midY2, maxZ, 8.0F, 0.0F);
/*  69 */     PositionTextureVertex vert11 = new PositionTextureVertex(maxX, midY2, maxZ, 8.0F, 8.0F);
/*     */     
/*  71 */     PositionTextureVertex vert12 = new PositionTextureVertex(innerXO, midY3, innerZO, 0.0F, 0.0F);
/*  72 */     PositionTextureVertex vert13 = new PositionTextureVertex(innerXM, midY3, innerZO, 0.0F, 8.0F);
/*  73 */     PositionTextureVertex vert14 = new PositionTextureVertex(innerXO, midY3, innerZM, 8.0F, 0.0F);
/*  74 */     PositionTextureVertex vert15 = new PositionTextureVertex(innerXM, midY3, innerZM, 8.0F, 8.0F);
/*     */     
/*  76 */     PositionTextureVertex vert16 = new PositionTextureVertex(innerXO, maxY, innerZO, 0.0F, 0.0F);
/*  77 */     PositionTextureVertex vert17 = new PositionTextureVertex(innerXM, maxY, innerZO, 0.0F, 8.0F);
/*  78 */     PositionTextureVertex vert18 = new PositionTextureVertex(innerXO, maxY, innerZM, 8.0F, 0.0F);
/*  79 */     PositionTextureVertex vert19 = new PositionTextureVertex(innerXM, maxY, innerZM, 8.0F, 8.0F);
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { vert7, vert6, vert2, vert3 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 104 */     this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { vert5, vert7, vert3, vert1 }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 106 */     this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { vert4, vert5, vert1, vert0 }, textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 108 */     this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { vert6, vert4, vert0, vert2 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 110 */     this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { vert1, vert0, vert2, vert3 }, textureOffsetX + depth, textureOffsetY + depth, textureOffsetX + depth + width, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */ 
/*     */     
/* 113 */     this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { vert11, vert10, vert6, vert7 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 115 */     this.quadList[6] = new TexturedQuad(new PositionTextureVertex[] { vert9, vert11, vert7, vert5 }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 117 */     this.quadList[7] = new TexturedQuad(new PositionTextureVertex[] { vert8, vert9, vert5, vert4 }, textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 119 */     this.quadList[8] = new TexturedQuad(new PositionTextureVertex[] { vert10, vert8, vert4, vert6 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, renderer.field_78801_a, renderer.field_78799_b);
/*     */ 
/*     */     
/* 122 */     this.quadList[9] = new TexturedQuad(new PositionTextureVertex[] { vert15, vert14, vert10, vert11 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 124 */     this.quadList[10] = new TexturedQuad(new PositionTextureVertex[] { vert13, vert15, vert11, vert9 }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 126 */     this.quadList[11] = new TexturedQuad(new PositionTextureVertex[] { vert12, vert13, vert9, vert8 }, textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 128 */     this.quadList[12] = new TexturedQuad(new PositionTextureVertex[] { vert14, vert12, vert8, vert10 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, renderer.field_78801_a, renderer.field_78799_b);
/*     */ 
/*     */     
/* 131 */     this.quadList[13] = new TexturedQuad(new PositionTextureVertex[] { vert19, vert18, vert14, vert15 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 133 */     this.quadList[14] = new TexturedQuad(new PositionTextureVertex[] { vert17, vert19, vert15, vert13 }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 135 */     this.quadList[15] = new TexturedQuad(new PositionTextureVertex[] { vert16, vert17, vert13, vert12 }, textureOffsetX + depth, textureOffsetY, textureOffsetX + depth + width, textureOffsetY + depth, renderer.field_78801_a, renderer.field_78799_b);
/*     */     
/* 137 */     this.quadList[16] = new TexturedQuad(new PositionTextureVertex[] { vert18, vert16, vert12, vert14 }, textureOffsetX + depth + width, textureOffsetY + depth, textureOffsetX + depth + width + width, textureOffsetY, renderer.field_78801_a, renderer.field_78799_b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_78245_a(Tessellator par1Tessellator, float par2) {
/* 147 */     for (int var3 = 0; var3 < this.quadList.length; var3++)
/*     */     {
/* 149 */       this.quadList[var3].func_78236_a(par1Tessellator, par2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelUrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */