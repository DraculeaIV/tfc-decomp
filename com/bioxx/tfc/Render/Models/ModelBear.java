/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBear
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer bearHead;
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer mainBody;
/*     */   private ModelRenderer leg1;
/*     */   private ModelRenderer leg2;
/*     */   private ModelRenderer leg3;
/*     */   private ModelRenderer leg4;
/*     */   private ModelRenderer tail;
/*     */   private ModelRenderer ear1;
/*     */   private ModelRenderer ear2;
/*     */   private ModelRenderer nose;
/*     */   
/*     */   public ModelBear() {
/*  34 */     this.field_78090_t = 128;
/*  35 */     this.field_78089_u = 64;
/*     */     
/*  37 */     this.neck = new ModelRenderer(this, 0, 29);
/*  38 */     this.neck.func_78789_a(0.0F, 0.0F, 0.0F, 4, 5, 8);
/*  39 */     this.neck.func_78793_a(-3.0F, 12.0F, -10.0F);
/*  40 */     this.neck.func_78787_b(128, 64);
/*  41 */     this.neck.field_78809_i = true;
/*  42 */     setRotation(this.neck, 0.3839724F, 0.0F, 0.0F);
/*  43 */     this.bearHead = new ModelRenderer(this, 0, 0);
/*  44 */     this.bearHead.func_78789_a(-3.0F, -3.0F, -2.0F, 6, 6, 4);
/*  45 */     this.bearHead.func_78793_a(-1.0F, 13.5F, -10.0F);
/*  46 */     this.bearHead.func_78787_b(128, 64);
/*  47 */     this.bearHead.field_78809_i = true;
/*  48 */     setRotation(this.bearHead, 0.0F, 0.0F, 0.0F);
/*  49 */     this.body = new ModelRenderer(this, 24, 18);
/*  50 */     this.body.func_78789_a(-4.0F, -2.0F, -3.0F, 6, 7, 7);
/*  51 */     this.body.func_78793_a(0.0F, 14.0F, 4.0F);
/*  52 */     this.body.func_78787_b(128, 64);
/*  53 */     this.body.field_78809_i = true;
/*  54 */     setRotation(this.body, 1.308997F, 0.0F, 0.0F);
/*  55 */     this.mainBody = new ModelRenderer(this, 24, 0);
/*  56 */     this.mainBody.func_78789_a(-4.0F, -3.0F, -3.0F, 8, 10, 8);
/*  57 */     this.mainBody.func_78793_a(-1.0F, 14.0F, -3.0F);
/*  58 */     this.mainBody.func_78787_b(128, 64);
/*  59 */     this.mainBody.field_78809_i = true;
/*  60 */     setRotation(this.mainBody, 1.570796F, 0.0F, 0.0F);
/*  61 */     this.leg1 = new ModelRenderer(this, 0, 18);
/*  62 */     this.leg1.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 8, 3);
/*  63 */     this.leg1.func_78793_a(-2.966667F, 16.0F, 6.0F);
/*  64 */     this.leg1.func_78787_b(128, 64);
/*  65 */     this.leg1.field_78809_i = true;
/*  66 */     setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
/*  67 */     this.leg2 = new ModelRenderer(this, 0, 18);
/*  68 */     this.leg2.func_78789_a(-0.4666667F, 0.0F, -1.0F, 2, 8, 3);
/*  69 */     this.leg2.func_78793_a(0.5F, 16.0F, 6.0F);
/*  70 */     this.leg2.func_78787_b(128, 64);
/*  71 */     this.leg2.field_78809_i = true;
/*  72 */     setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
/*  73 */     this.leg3 = new ModelRenderer(this, 0, 18);
/*  74 */     this.leg3.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 8, 3);
/*  75 */     this.leg3.func_78793_a(-3.5F, 16.0F, -4.0F);
/*  76 */     this.leg3.func_78787_b(128, 64);
/*  77 */     this.leg3.field_78809_i = true;
/*  78 */     setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
/*  79 */     this.leg4 = new ModelRenderer(this, 0, 18);
/*  80 */     this.leg4.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 8, 3);
/*  81 */     this.leg4.func_78793_a(1.5F, 16.0F, -4.0F);
/*  82 */     this.leg4.func_78787_b(128, 64);
/*  83 */     this.leg4.field_78809_i = true;
/*  84 */     setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
/*  85 */     this.tail = new ModelRenderer(this, 10, 18);
/*  86 */     this.tail.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 2, 2);
/*  87 */     this.tail.func_78793_a(-1.0F, 13.0F, 9.0F);
/*  88 */     this.tail.func_78787_b(128, 64);
/*  89 */     this.tail.field_78809_i = true;
/*  90 */     setRotation(this.tail, 1.130069F, 0.0F, 0.0F);
/*  91 */     this.ear1 = new ModelRenderer(this, 16, 14);
/*  92 */     this.ear1.func_78789_a(-3.0F, -5.0F, 0.0F, 2, 2, 1);
/*  93 */     this.ear1.func_78793_a(-1.0F, 13.5F, -10.0F);
/*  94 */     this.ear1.func_78787_b(128, 64);
/*  95 */     this.ear1.field_78809_i = true;
/*  96 */     setRotation(this.ear1, 0.0F, 0.0F, 0.0F);
/*  97 */     this.ear2 = new ModelRenderer(this, 16, 14);
/*  98 */     this.ear2.func_78789_a(1.0F, -5.0F, 0.0F, 2, 2, 1);
/*  99 */     this.ear2.func_78793_a(-1.0F, 13.5F, -10.0F);
/* 100 */     this.ear2.func_78787_b(128, 64);
/* 101 */     this.ear2.field_78809_i = true;
/* 102 */     setRotation(this.ear2, 0.0F, 0.0F, 0.0F);
/* 103 */     this.nose = new ModelRenderer(this, 0, 10);
/* 104 */     this.nose.func_78789_a(-1.5F, 0.0F, -4.0F, 3, 3, 4);
/* 105 */     this.nose.func_78793_a(-1.0F, 13.5F, -10.0F);
/* 106 */     this.nose.func_78787_b(128, 64);
/* 107 */     this.nose.field_78809_i = true;
/* 108 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 115 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 116 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 118 */     float age = 1.0F;
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
/* 131 */     if (this.field_78091_s) {
/*     */       
/* 133 */       float aa = 2.0F - 1.0F - age;
/* 134 */       GL11.glPushMatrix();
/* 135 */       float ab = (float)Math.sqrt((1.0F / aa));
/* 136 */       GL11.glScalef(ab, ab, ab);
/* 137 */       GL11.glTranslatef(0.0F, 24.0F * f5 * age / aa, 2.0F * f5 * age / ab);
/* 138 */       this.ear1.func_78785_a(f5);
/* 139 */       this.ear2.func_78785_a(f5);
/* 140 */       this.nose.func_78785_a(f5);
/* 141 */       this.bearHead.func_78785_a(f5);
/* 142 */       GL11.glPopMatrix();
/* 143 */       GL11.glPushMatrix();
/* 144 */       GL11.glScalef(1.0F / aa, 1.0F / aa, 1.0F / aa);
/* 145 */       GL11.glTranslatef(0.0F, 24.0F * f5 * age, 0.0F);
/* 146 */       this.body.func_78785_a(f5);
/* 147 */       this.mainBody.func_78785_a(f5);
/* 148 */       this.leg1.func_78785_a(f5);
/* 149 */       this.leg2.func_78785_a(f5);
/* 150 */       this.leg3.func_78785_a(f5);
/* 151 */       this.leg4.func_78785_a(f5);
/* 152 */       this.neck.func_78785_a(f5);
/* 153 */       this.tail.func_78785_a(f5);
/* 154 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 158 */       this.ear1.func_78785_a(f5);
/* 159 */       this.ear2.func_78785_a(f5);
/* 160 */       this.nose.func_78785_a(f5);
/* 161 */       this.bearHead.func_78785_a(f5);
/* 162 */       this.body.func_78785_a(f5);
/* 163 */       this.mainBody.func_78785_a(f5);
/* 164 */       this.leg1.func_78785_a(f5);
/* 165 */       this.leg2.func_78785_a(f5);
/* 166 */       this.leg3.func_78785_a(f5);
/* 167 */       this.leg4.func_78785_a(f5);
/* 168 */       this.neck.func_78785_a(f5);
/* 169 */       this.tail.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 176 */     model.field_78795_f = x;
/* 177 */     model.field_78796_g = y;
/* 178 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 185 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 186 */     this.bearHead.field_78795_f = f4 / 57.295776F;
/* 187 */     this.bearHead.field_78796_g = f3 / 57.295776F;
/*     */     
/* 189 */     this.ear1.field_78795_f = f4 / 57.295776F;
/* 190 */     this.ear1.field_78796_g = f3 / 57.295776F;
/*     */     
/* 192 */     this.ear2.field_78795_f = f4 / 57.295776F;
/* 193 */     this.ear2.field_78796_g = f3 / 57.295776F;
/*     */     
/* 195 */     this.nose.field_78795_f = f4 / 57.295776F;
/* 196 */     this.nose.field_78796_g = f3 / 57.295776F;
/*     */ 
/*     */     
/* 199 */     this.leg1.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.4F * f1;
/* 200 */     this.leg2.field_78795_f = MathHelper.func_76134_b(f * 0.6662F + 3.1415927F) * 1.4F * f1;
/* 201 */     this.leg3.field_78795_f = MathHelper.func_76134_b(f * 0.6662F + 3.1415927F) * 1.4F * f1;
/* 202 */     this.leg4.field_78795_f = MathHelper.func_76134_b(f * 0.6662F) * 1.4F * f1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelBear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */