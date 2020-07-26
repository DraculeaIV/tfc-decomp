/*    */ package com.bioxx.tfc.Render.Models;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelPig;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class ModelPigTFC extends ModelPig {
/*    */   private ModelRenderer tusk1;
/*    */   private ModelRenderer tusk2;
/*    */   private ModelRenderer snout;
/*    */   
/*    */   public ModelPigTFC() {
/* 18 */     this(0.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ModelPigTFC(float par1) {
/* 27 */     super(par1);
/* 28 */     this.tusk1 = new ModelRenderer((ModelBase)this, 32, 0);
/* 29 */     this.tusk1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/* 30 */     this.tusk1.func_78793_a(-3.0F, 0.5F, -9.0F);
/* 31 */     this.tusk1.field_78795_f = 0.2617994F;
/*    */     
/* 33 */     this.tusk2 = new ModelRenderer((ModelBase)this, 32, 0);
/* 34 */     this.tusk2.func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/* 35 */     this.tusk2.func_78793_a(2.0F, 0.5F, -9.0F);
/* 36 */     this.tusk2.field_78795_f = 0.2617994F;
/*    */     
/* 38 */     this.snout = new ModelRenderer((ModelBase)this, 0, 26);
/* 39 */     this.snout.func_78790_a(-2.0F, 0.0F, -10.0F, 4, 3, 3, par1);
/* 40 */     this.snout.func_78792_a(this.tusk1);
/* 41 */     this.snout.func_78792_a(this.tusk2);
/* 42 */     this.field_78150_a.func_78792_a(this.snout);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 47 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/* 48 */     float ageScale = 2.0F - percent;
/* 49 */     float ageHeadScale = (float)Math.pow((1.0F / ageScale), 0.66D);
/*    */ 
/*    */     
/* 52 */     func_78087_a(par2, par3, par4, par5, par6, par7, entity);
/* 53 */     if (entity instanceof IAnimal) {
/*    */       
/* 55 */       if (((IAnimal)entity).getGender() == IAnimal.GenderEnum.MALE)
/*    */       {
/* 57 */         if (((IAnimal)entity).isAdult()) {
/* 58 */           this.tusk1.field_78807_k = false;
/* 59 */           this.tusk2.field_78807_k = false;
/*    */         } 
/*    */       }
/*    */       
/* 63 */       GL11.glPushMatrix();
/*    */       
/* 65 */       GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 66 */       GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
/* 67 */       GL11.glTranslatef(0.0F, (ageScale - 1.0F) * -0.125F, 0.1875F - 0.1875F * percent);
/* 68 */       this.field_78150_a.func_78785_a(par7);
/* 69 */       GL11.glPopMatrix();
/*    */       
/* 71 */       GL11.glPushMatrix();
/* 72 */       GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 73 */       GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*    */       
/* 75 */       this.field_78148_b.func_78785_a(par7);
/* 76 */       this.field_78149_c.func_78785_a(par7);
/* 77 */       this.field_78146_d.func_78785_a(par7);
/* 78 */       this.field_78147_e.func_78785_a(par7);
/* 79 */       this.field_78144_f.func_78785_a(par7);
/* 80 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 88 */     this.tusk1.field_78807_k = true;
/* 89 */     this.tusk2.field_78807_k = true;
/* 90 */     this.field_78150_a.field_78795_f = par5 / 57.295776F;
/* 91 */     this.field_78150_a.field_78796_g = par4 / 57.295776F;
/* 92 */     this.field_78148_b.field_78795_f = 1.5707964F;
/* 93 */     this.field_78149_c.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 94 */     this.field_78146_d.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 95 */     this.field_78147_e.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 96 */     this.field_78144_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelPigTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */