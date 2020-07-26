/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class ModelQuiver
/*    */   extends ModelBase
/*    */ {
/*    */   private ModelRenderer quiver;
/* 12 */   private ModelRenderer[] arrows = new ModelRenderer[16];
/*    */ 
/*    */ 
/*    */   
/*    */   public ModelQuiver() {
/* 17 */     this.quiver = new ModelRenderer(this, 38, 0);
/* 18 */     this.quiver.func_78789_a(-2.5F, -6.0F, -1.5F, 5, 12, 3);
/* 19 */     this.quiver.func_78793_a(0.0F, 4.0F, 4.0F);
/* 20 */     this.quiver.field_78808_h = 3.926991F;
/* 21 */     this.quiver.func_78787_b(64, 32);
/*    */     
/* 23 */     for (int i = 0; i < this.arrows.length; i++) {
/*    */       
/* 25 */       this.arrows[i] = new ModelRenderer(this, 59, 0);
/* 26 */       this.arrows[i].func_78789_a(-1.0F, -8.0F, 0.0F, 2, 14, 0);
/* 27 */       this.arrows[i].func_78793_a(0.0F, 0.0F, 0.0F);
/* 28 */       this.arrows[i].func_78787_b(64, 32);
/* 29 */       (this.arrows[i]).field_78808_h = 3.1415927F + 0.08726646F * (i % 3) * ((i % 2 == 0) ? 1.0F : -1.0F);
/* 30 */       (this.arrows[i]).field_78795_f = 0.08726646F * (i % 3) * ((i % 2 == i % 3) ? 1.0F : -1.0F);
/* 31 */       this.quiver.func_78792_a(this.arrows[i]);
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
/*    */ 
/*    */   
/*    */   protected void setRotationRadians(ModelRenderer model, float x, float y, float z) {
/* 45 */     model.field_78795_f = x;
/* 46 */     model.field_78796_g = y;
/* 47 */     model.field_78808_h = z;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void setRotationDegrees(ModelRenderer model, float x, float y, float z) {
/* 58 */     setRotationRadians(model, (float)Math.toRadians(x), (float)Math.toRadians(y), (float)Math.toRadians(z));
/*    */   }
/*    */   public void render(EntityLivingBase theEntity, int numArrows) {
/*    */     int i;
/* 62 */     for (i = 0; i < numArrows; i++) {
/* 63 */       (this.arrows[i]).field_78807_k = false;
/*    */     }
/* 65 */     this.quiver.func_78785_a(0.0625F);
/* 66 */     for (i = 0; i < this.arrows.length; i++) {
/* 67 */       (this.arrows[i]).field_78807_k = true;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 73 */     if (entity instanceof net.minecraft.entity.player.EntityPlayer) this.quiver.func_78785_a(0.0625F); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelQuiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */