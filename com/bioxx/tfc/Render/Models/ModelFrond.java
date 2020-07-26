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
/*     */ 
/*     */ public class ModelFrond
/*     */   extends ModelBox
/*     */ {
/*     */   private Object[] blades;
/*     */   private float lengthMod;
/*     */   private float length;
/*     */   private TexturedQuad[] quadList;
/*     */   
/*     */   public ModelFrond(ModelRenderer renderer, int textureOffsetX, int textureOffsetY, float originX, float originY, float originZ, int width, int height, int depth, float scale) {
/*  29 */     super(renderer, textureOffsetX, textureOffsetY, originX, originY, originZ, width, height, depth, scale);
/*  30 */     this.lengthMod = 0.75F;
/*  31 */     this.length = 8.0F * this.lengthMod;
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
/*  75 */     this.blades = new Object[30]; int i;
/*  76 */     for (i = 0; i < 6; i++) {
/*  77 */       this.blades[i] = createBlade(originX, originY, originZ, (i / 3.0F - 2.0F) * this.lengthMod, 0.0F, 1.2F * i);
/*     */     }
/*  79 */     for (i = 0; i < 18; i++)
/*     */     {
/*  81 */       this.blades[i + 6] = createBlade(originX, originY, originZ, (3.0F - (float)Math.pow((i - 12), 2.0D) / 60.0F) * this.lengthMod, 0.0F, 1.2F * (i + 6));
/*     */     }
/*  83 */     for (i = 0; i < 6; i++) {
/*  84 */       this.blades[i + 24] = createBlade(originX, originY, originZ, (2.0F - (float)Math.pow(i, 2.0D) / 4.0F) * this.lengthMod, 0.0F, 1.2F * (i + 24));
/*     */     }
/*     */     
/*  87 */     this.quadList = new TexturedQuad[30];
/*  88 */     for (i = 0; i < 30; i++) {
/*  89 */       this.quadList[i] = new TexturedQuad((PositionTextureVertex[])this.blades[i], textureOffsetX + depth + width + depth, textureOffsetY + depth, textureOffsetX + depth + width + depth + width, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private PositionTextureVertex[] createBlade(float originX, float originY, float originZ, float modifierX, float modifierY, float modifierZ) {
/*  95 */     PositionTextureVertex vert0 = new PositionTextureVertex(originX, originY, originZ + modifierZ, 0.0F, 0.0F);
/*  96 */     PositionTextureVertex vert1 = new PositionTextureVertex(originX + this.length + modifierX, originY + modifierY, originZ + modifierZ + modifierZ / 15.0F, 0.0F, 8.0F);
/*  97 */     PositionTextureVertex vert2 = new PositionTextureVertex(originX, originY, originZ + 1.0F + modifierZ, 8.0F, 8.0F);
/*  98 */     PositionTextureVertex vert3 = new PositionTextureVertex(originX + this.length + modifierX, originY + modifierY, originZ + 1.0F + modifierZ + modifierZ / 15.0F, 8.0F, 0.0F);
/*  99 */     return new PositionTextureVertex[] { vert1, vert0, vert2, vert3 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_78245_a(Tessellator par1Tessellator, float par2) {
/* 106 */     for (int var3 = 0; var3 < this.quadList.length; var3++)
/*     */     {
/* 108 */       this.quadList[var3].func_78236_a(par1Tessellator, par2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelFrond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */