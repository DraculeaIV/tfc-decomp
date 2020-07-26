/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ 
/*    */ 
/*    */ public class ModelCookingPot
/*    */   extends ModelBase
/*    */ {
/*  9 */   public ModelRendererTFC renderer = new ModelRendererTFC(this, 0, 0); public ModelCookingPot() {
/* 10 */     float x = 8.0F;
/* 11 */     float y = 8.0F;
/* 12 */     float z = 8.0F;
/* 13 */     int baseHeight = 4;
/* 14 */     int baseWidth = 7;
/* 15 */     int baseDepth = 15;
/* 16 */     Object[] basicVesselData = { { 0.5F + x, y, z + 0.5F, 8.0F, 0.01F, 8.0F, 8.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 2.0F, 8.0F, 18.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 4.0F, 8.0F, 20.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 7.0F, 8.0F, 20.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 10.0F, 8.0F, 18.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 12.0F, 8.0F, 14.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 14.0F, 8.0F, 14.0F }, { 0.5F + x, y, z + 0.5F, 8.0F, 14.0F, 8.0F, 12.0F } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 26 */     this.renderer.field_78804_l.add(new ModelPotteryBase(this.renderer, this.renderer.field_78803_o, this.renderer.field_78813_p, 5.5F + x, y, z + 5.5F, baseWidth, baseHeight, baseDepth, 0.0F, basicVesselData, false));
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPot() {
/* 31 */     this.renderer.func_78785_a(0.03125F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelCookingPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */