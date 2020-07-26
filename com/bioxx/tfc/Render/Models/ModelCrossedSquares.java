/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelCrossedSquares
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRendererTFC renderer;
/*    */   
/*    */   public ModelCrossedSquares(int texOffx, int texOffy, int texWidth, int texHeight, int sqWidth, int sqHeight, int sqDepth) {
/* 15 */     this.renderer = new ModelRendererTFC(this, 0, 0);
/* 16 */     this.renderer.field_78799_b = texHeight;
/* 17 */     this.renderer.field_78801_a = texWidth;
/* 18 */     float x = 0.0F;
/* 19 */     float y = 0.0F;
/* 20 */     float z = 0.0F;
/*    */     
/* 22 */     int squareHeight = sqWidth;
/* 23 */     int squareWidth = sqWidth;
/* 24 */     int squareDepth = sqDepth;
/* 25 */     this.renderer.field_78804_l.add(new ModelCrossedSquare(this.renderer, this.renderer.field_78803_o, this.renderer.field_78813_p, x - ((sqWidth - 16) / 2), y, z - ((sqDepth - 16) / 2), squareWidth, squareHeight, squareDepth, 0.0F));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderSquares() {
/* 32 */     this.renderer.func_78785_a(0.0625F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelCrossedSquares.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */