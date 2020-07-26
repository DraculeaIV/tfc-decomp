/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelBox;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ public class ModelRendererTFC
/*    */   extends ModelRenderer {
/*    */   public ModelBase modelBase;
/*    */   public int field_78803_o;
/*    */   public int field_78813_p;
/*    */   
/*    */   public ModelRendererTFC(ModelBase par1) {
/* 14 */     super(par1);
/* 15 */     this.modelBase = par1;
/*    */   }
/*    */ 
/*    */   
/*    */   public ModelRendererTFC(ModelBase par1ModelBase, int par2, int par3) {
/* 20 */     this(par1ModelBase);
/* 21 */     setTextureOffset(par2, par3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ModelRendererTFC setTextureOffset(int par1, int par2) {
/* 27 */     this.field_78803_o = par1;
/* 28 */     this.field_78813_p = par2;
/* 29 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78790_a(float par1, float par2, float par3, int par4, int par5, int par6, float par7) {
/* 38 */     this.field_78804_l.add(new ModelBox(this, this.field_78803_o, this.field_78813_p, par1, par2, par3, par4, par5, par6, par7));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBox(ModelBox box) {
/* 46 */     this.field_78804_l.add(box);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelRendererTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */