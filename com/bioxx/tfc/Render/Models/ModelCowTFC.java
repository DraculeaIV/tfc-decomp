/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelQuadruped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelCowTFC
/*     */   extends ModelQuadruped
/*     */ {
/*     */   public ModelRenderer udders;
/*     */   private ModelRenderer horn1;
/*     */   private ModelRenderer horn2;
/*     */   private ModelRenderer horn1b;
/*     */   private ModelRenderer horn2b;
/*     */   
/*     */   public ModelCowTFC() {
/*  22 */     super(12, 0.0F);
/*  23 */     this.field_78150_a = new ModelRenderer((ModelBase)this, 0, 0);
/*  24 */     this.field_78150_a.func_78790_a(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
/*  25 */     this.field_78150_a.func_78793_a(0.0F, 4.0F, -8.0F);
/*     */     
/*  27 */     this.horn1 = new ModelRenderer((ModelBase)this, 22, 0);
/*  28 */     this.horn1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.15F);
/*  29 */     this.horn1.func_78793_a(-5.5F, -2.5F, -2.0F);
/*  30 */     this.horn1.field_78808_h = -1.5707964F;
/*     */     
/*  32 */     this.horn1b = new ModelRenderer((ModelBase)this, 22, 0);
/*  33 */     this.horn1b.func_78790_a(0.0F, -2.1F, -0.5F, 1, 3, 1, 0.0F);
/*  34 */     this.horn1b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.horn1b.field_78795_f = 1.0471976F;
/*  36 */     this.horn1b.field_78796_g = -0.2617994F;
/*  37 */     this.horn1.func_78792_a(this.horn1b);
/*     */     
/*  39 */     this.field_78150_a.func_78792_a(this.horn1);
/*  40 */     this.horn2 = new ModelRenderer((ModelBase)this, 22, 0);
/*  41 */     this.horn2.func_78790_a(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.15F);
/*  42 */     this.horn2.func_78793_a(5.5F, -2.5F, -2.0F);
/*  43 */     this.horn2.field_78808_h = -1.5707964F;
/*     */     
/*  45 */     this.horn2b = new ModelRenderer((ModelBase)this, 22, 0);
/*  46 */     this.horn2b.func_78790_a(0.0F, -0.8F, -0.5F, 1, 3, 1, 0.0F);
/*  47 */     this.horn2b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.horn2b.field_78795_f = -1.0471976F;
/*  49 */     this.horn2b.field_78796_g = -0.2617994F;
/*  50 */     this.horn2.func_78792_a(this.horn2b);
/*     */     
/*  52 */     this.field_78150_a.func_78792_a(this.horn2);
/*  53 */     this.field_78148_b = new ModelRenderer((ModelBase)this, 18, 4);
/*  54 */     this.field_78148_b.func_78790_a(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
/*  55 */     this.field_78148_b.func_78793_a(0.0F, 5.0F, 2.0F);
/*  56 */     this.udders = new ModelRenderer((ModelBase)this, 18, 4);
/*  57 */     this.udders.func_78793_a(0.0F, 5.0F, 2.0F);
/*  58 */     this.udders.func_78784_a(52, 0).func_78789_a(-2.0F, 2.0F, -8.0F, 4, 6, 1);
/*     */     
/*  60 */     this.field_78149_c.field_78800_c--;
/*  61 */     this.field_78146_d.field_78800_c++;
/*  62 */     this.field_78149_c.field_78798_e += 0.0F;
/*  63 */     this.field_78146_d.field_78798_e += 0.0F;
/*  64 */     this.field_78147_e.field_78800_c--;
/*  65 */     this.field_78144_f.field_78800_c++;
/*  66 */     this.field_78147_e.field_78798_e--;
/*  67 */     this.field_78144_f.field_78798_e--;
/*  68 */     this.field_78151_h += 2.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  74 */     setRotationAngles(par2, par3, par4, par5, par6, par7);
/*     */     
/*  76 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/*     */     
/*  78 */     float ageScale = 2.0F - percent;
/*  79 */     float ageHeadScale = (float)Math.pow((1.0F / ageScale), 0.66D);
/*     */     
/*  81 */     GL11.glPushMatrix();
/*     */     
/*  83 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/*  84 */     GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
/*  85 */     GL11.glTranslatef(0.0F, 0.0F, 0.1875F - 0.1875F * percent);
/*  86 */     if (percent < 0.5D) {
/*     */       
/*  88 */       this.horn1.field_78807_k = true;
/*  89 */       this.horn2.field_78807_k = true;
/*  90 */       if (percent < 0.75D) {
/*     */         
/*  92 */         this.horn1b.field_78807_k = true;
/*  93 */         this.horn2b.field_78807_k = true;
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     if (((IAnimal)entity).getGender() == IAnimal.GenderEnum.MALE) {
/*     */       
/*  99 */       this.udders.field_78807_k = true;
/*     */     }
/*     */     else {
/*     */       
/* 103 */       this.horn1b.field_78807_k = true;
/* 104 */       this.horn2b.field_78807_k = true;
/*     */     } 
/* 106 */     this.field_78150_a.func_78785_a(par7);
/* 107 */     GL11.glPopMatrix();
/* 108 */     GL11.glPushMatrix();
/* 109 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 110 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*     */     
/* 112 */     this.field_78148_b.func_78785_a(par7);
/* 113 */     this.udders.func_78785_a(par7);
/* 114 */     this.field_78149_c.func_78785_a(par7);
/* 115 */     this.field_78146_d.func_78785_a(par7);
/* 116 */     this.field_78147_e.func_78785_a(par7);
/* 117 */     this.field_78144_f.func_78785_a(par7);
/* 118 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
/* 126 */     this.field_78150_a.field_78795_f = par5 / 57.295776F;
/* 127 */     this.field_78150_a.field_78796_g = par4 / 57.295776F;
/* 128 */     this.field_78148_b.field_78795_f = 1.5707964F;
/* 129 */     this.udders.field_78795_f = 1.5707964F;
/* 130 */     this.field_78149_c.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 131 */     this.field_78146_d.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 132 */     this.field_78147_e.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 133 */     this.field_78144_f.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 134 */     this.horn1.field_78795_f = 0.0F;
/* 135 */     this.horn2.field_78795_f = 0.0F;
/* 136 */     this.horn1.field_78807_k = false;
/* 137 */     this.horn1b.field_78807_k = false;
/* 138 */     this.horn2.field_78807_k = false;
/* 139 */     this.horn2b.field_78807_k = false;
/* 140 */     this.udders.field_78807_k = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelCowTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */