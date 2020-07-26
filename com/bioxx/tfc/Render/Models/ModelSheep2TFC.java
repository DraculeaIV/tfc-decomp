/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.model.ModelSheep2;
/*     */ import net.minecraft.entity.Entity;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSheep2TFC
/*     */   extends ModelSheep2
/*     */ {
/*     */   private ModelRenderer horn1;
/*     */   private ModelRenderer horn2;
/*     */   private ModelRenderer horn1b;
/*     */   private ModelRenderer horn2b;
/*     */   
/*     */   public ModelSheep2TFC() {
/*  23 */     this.horn1 = new ModelRenderer((ModelBase)this, 28, 2);
/*  24 */     this.horn1.func_78790_a(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
/*  25 */     this.horn1.func_78793_a(0.0F, -10.0F, 0.0F);
/*  26 */     this.horn1.field_78808_h = -0.5235988F;
/*  27 */     this.horn1.field_78795_f = -0.5235988F;
/*  28 */     this.horn1.field_78796_g = -1.0471976F;
/*  29 */     this.horn1.func_78793_a(-5.0F, -6.0F, -1.0F);
/*     */     
/*  31 */     this.horn1b = new ModelRenderer((ModelBase)this, 38, 4);
/*  32 */     this.horn1b.func_78790_a(0.5F, 1.0F, 0.5F, 1, 3, 1, 0.25F);
/*  33 */     this.horn1b.func_78793_a(0.0F, -2.0F, 4.0F);
/*  34 */     this.horn1b.field_78795_f = -1.0471976F;
/*     */     
/*  36 */     this.horn2 = new ModelRenderer((ModelBase)this, 28, 2);
/*  37 */     this.horn2.func_78790_a(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
/*  38 */     this.horn2.func_78793_a(0.0F, -10.0F, 0.0F);
/*  39 */     this.horn2.field_78808_h = 0.5235988F;
/*  40 */     this.horn2.field_78795_f = -0.5235988F;
/*  41 */     this.horn2.field_78796_g = 1.0471976F;
/*  42 */     this.horn2.func_78793_a(4.0F, -6.5F, 0.75F);
/*     */     
/*  44 */     this.horn2b = new ModelRenderer((ModelBase)this, 38, 4);
/*  45 */     this.horn2b.func_78790_a(0.5F, 1.0F, 0.5F, 1, 3, 1, 0.25F);
/*  46 */     this.horn2b.func_78793_a(0.0F, -2.0F, 4.0F);
/*  47 */     this.horn2b.field_78795_f = -1.0471976F;
/*     */     
/*  49 */     this.horn1.func_78792_a(this.horn1b);
/*  50 */     this.horn2.func_78792_a(this.horn2b);
/*     */     
/*  52 */     this.field_78150_a.func_78792_a(this.horn1);
/*  53 */     this.field_78150_a.func_78792_a(this.horn2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  59 */     func_78087_a(par2, par3, par4, par5, par6, par7, entity);
/*     */     
/*  61 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/*  62 */     float ageScale = 2.0F - percent;
/*  63 */     float ageHeadScale = (float)Math.pow((1.0F / ageScale), 0.66D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     GL11.glPushMatrix();
/*     */     
/*  72 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/*  73 */     GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
/*  74 */     GL11.glTranslatef(0.0F, (ageScale - 1.0F) * -0.125F, 0.1875F - 0.1875F * percent);
/*     */ 
/*     */     
/*  77 */     if (percent < 0.5D) {
/*     */       
/*  79 */       this.horn1.field_78807_k = true;
/*  80 */       this.horn2.field_78807_k = true;
/*  81 */       if (percent < 0.75D) {
/*     */         
/*  83 */         this.horn1b.field_78807_k = true;
/*  84 */         this.horn2b.field_78807_k = true;
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     if (((IAnimal)entity).getGender() == IAnimal.GenderEnum.FEMALE) {
/*     */       
/*  90 */       this.horn1.field_78807_k = true;
/*  91 */       this.horn2.field_78807_k = true;
/*     */     } 
/*  93 */     this.field_78150_a.func_78785_a(par7);
/*     */ 
/*     */ 
/*     */     
/*  97 */     GL11.glPopMatrix();
/*  98 */     GL11.glPushMatrix();
/*  99 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 100 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*     */     
/* 102 */     this.field_78148_b.func_78785_a(par7);
/* 103 */     this.field_78149_c.func_78785_a(par7);
/* 104 */     this.field_78146_d.func_78785_a(par7);
/* 105 */     this.field_78147_e.func_78785_a(par7);
/* 106 */     this.field_78144_f.func_78785_a(par7);
/* 107 */     this.horn1.field_78807_k = false;
/* 108 */     this.horn1b.field_78807_k = false;
/* 109 */     this.horn2.field_78807_k = false;
/* 110 */     this.horn2b.field_78807_k = false;
/* 111 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelSheep2TFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */