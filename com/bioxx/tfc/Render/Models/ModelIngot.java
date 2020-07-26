/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBox;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.model.PositionTextureVertex;
/*    */ import net.minecraft.client.model.TexturedQuad;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelIngot
/*    */   extends ModelBox
/*    */ {
/*    */   private TexturedQuad[] quadList;
/*    */   
/*    */   public ModelIngot(ModelRenderer renderer, int textureOffsetX, int textureOffsetY) {
/* 23 */     super(renderer, textureOffsetX, textureOffsetY, 0.5F, 0.0F, 0.5F, 15, 4, 7, 0.0F);
/*    */     
/* 25 */     float originX = 0.5F;
/* 26 */     float originY = 0.0F;
/* 27 */     float originZ = 0.5F;
/*    */ 
/*    */     
/* 30 */     this.quadList = new TexturedQuad[6];
/* 31 */     float maxX = originX + 15.0F;
/* 32 */     float maxY = originY + 4.0F;
/* 33 */     float maxZ = originZ + 7.0F;
/*    */     
/* 35 */     PositionTextureVertex vert0 = new PositionTextureVertex(originX, originY, originZ, 0.0F, 0.0F);
/* 36 */     PositionTextureVertex vert1 = new PositionTextureVertex(maxX, originY, originZ, 0.0F, 8.0F);
/* 37 */     PositionTextureVertex vert2 = new PositionTextureVertex(maxX - 1.0F, maxY, originZ + 1.0F, 8.0F, 8.0F);
/* 38 */     PositionTextureVertex vert3 = new PositionTextureVertex(originX + 1.0F, maxY, originZ + 1.0F, 8.0F, 0.0F);
/* 39 */     PositionTextureVertex vert4 = new PositionTextureVertex(originX, originY, maxZ, 0.0F, 0.0F);
/* 40 */     PositionTextureVertex vert5 = new PositionTextureVertex(maxX, originY, maxZ, 0.0F, 8.0F);
/* 41 */     PositionTextureVertex vert6 = new PositionTextureVertex(maxX - 1.0F, maxY, maxZ - 1.0F, 8.0F, 8.0F);
/* 42 */     PositionTextureVertex vert7 = new PositionTextureVertex(originX + 1.0F, maxY, maxZ - 1.0F, 8.0F, 0.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     int x1 = textureOffsetX + 4;
/* 53 */     int x2 = textureOffsetX + 20;
/* 54 */     int x3 = textureOffsetX + 44;
/* 55 */     int x4 = textureOffsetX + 60;
/*    */     
/* 57 */     int y1 = textureOffsetY + 4;
/* 58 */     int y2 = textureOffsetY + 8;
/* 59 */     int y3 = textureOffsetY + 16;
/* 60 */     int y4 = textureOffsetY + 20;
/* 61 */     int y5 = textureOffsetY + 28;
/*    */     
/* 63 */     this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { vert5, vert1, vert2, vert6 }, x3, y1, x4, y2, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/* 65 */     this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { vert0, vert4, vert7, vert3 }, x1, y1, x2, y2, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/* 67 */     this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { vert5, vert4, vert0, vert1 }, x2, y4, x3, y5, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/* 69 */     this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { vert2, vert3, vert7, vert6 }, x2, y2, x3, y3, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/* 71 */     this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { vert1, vert0, vert3, vert2 }, x2, y1, x3, y2, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/* 73 */     this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { vert4, vert5, vert6, vert7 }, x3, y4, x2, y3, renderer.field_78801_a, renderer.field_78799_b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_78245_a(Tessellator par1Tessellator, float par2) {
/* 81 */     for (int var3 = 0; var3 < this.quadList.length; var3++)
/*    */     {
/* 83 */       this.quadList[var3].func_78236_a(par1Tessellator, par2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelIngot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */