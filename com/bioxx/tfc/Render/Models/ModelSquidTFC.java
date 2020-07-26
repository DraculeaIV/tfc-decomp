/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelSquidTFC
/*    */   extends ModelBase
/*    */ {
/*    */   private ModelRenderer squidBody;
/* 17 */   private ModelRenderer[] squidTentacles = new ModelRenderer[8];
/*    */ 
/*    */   
/*    */   public ModelSquidTFC() {
/* 21 */     byte b0 = -16;
/* 22 */     this.squidBody = new ModelRenderer(this, 0, 0);
/* 23 */     this.squidBody.func_78789_a(-6.0F, -8.0F, -6.0F, 12, 16, 12);
/* 24 */     this.squidBody.field_78797_d += (24 + b0);
/*    */     
/* 26 */     for (int i = 0; i < this.squidTentacles.length; i++) {
/*    */       
/* 28 */       this.squidTentacles[i] = new ModelRenderer(this, 48, 0);
/* 29 */       double d0 = i * Math.PI * 2.0D / this.squidTentacles.length;
/* 30 */       float f = (float)Math.cos(d0) * 5.0F;
/* 31 */       float f1 = (float)Math.sin(d0) * 5.0F;
/* 32 */       this.squidTentacles[i].func_78789_a(-1.0F, 0.0F, -1.0F, 2, 18, 2);
/* 33 */       (this.squidTentacles[i]).field_78800_c = f;
/* 34 */       (this.squidTentacles[i]).field_78798_e = f1;
/* 35 */       (this.squidTentacles[i]).field_78797_d = (31 + b0);
/* 36 */       d0 = i * Math.PI * -2.0D / this.squidTentacles.length + 1.5707963267948966D;
/* 37 */       (this.squidTentacles[i]).field_78796_g = (float)d0;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 49 */     ModelRenderer[] amodelrenderer = this.squidTentacles;
/* 50 */     int i = amodelrenderer.length;
/*    */     
/* 52 */     for (int j = 0; j < i; j++) {
/*    */       
/* 54 */       ModelRenderer modelrenderer = amodelrenderer[j];
/* 55 */       modelrenderer.field_78795_f = par3;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 65 */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/* 66 */     this.squidBody.func_78785_a(par7);
/*    */     
/* 68 */     for (int i = 0; i < this.squidTentacles.length; i++)
/*    */     {
/* 70 */       this.squidTentacles[i].func_78785_a(par7);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelSquidTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */