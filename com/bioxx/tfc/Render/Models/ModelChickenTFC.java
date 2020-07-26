/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelChickenTFC
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer head;
/*     */   public ModelRenderer body;
/*     */   public ModelRenderer rightLeg;
/*     */   public ModelRenderer leftLeg;
/*     */   public ModelRenderer rightWing;
/*     */   public ModelRenderer leftWing;
/*     */   public ModelRenderer bill;
/*     */   public ModelRenderer chin;
/*     */   public ModelRenderer[] tails;
/*     */   public ModelRenderer crown;
/*     */   
/*     */   public ModelChickenTFC() {
/*  29 */     byte var1 = 16;
/*  30 */     this.head = new ModelRenderer(this, 0, 0);
/*  31 */     this.head.func_78790_a(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
/*  32 */     this.head.func_78793_a(0.0F, (-1 + var1), -4.0F);
/*  33 */     this.bill = new ModelRenderer(this, 14, 0);
/*  34 */     this.bill.func_78790_a(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
/*  35 */     this.bill.func_78793_a(0.0F, (-1 + var1), -4.0F);
/*  36 */     this.chin = new ModelRenderer(this, 14, 4);
/*  37 */     this.chin.func_78790_a(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
/*  38 */     this.chin.func_78793_a(0.0F, (-1 + var1), -4.0F);
/*  39 */     this.body = new ModelRenderer(this, 0, 9);
/*  40 */     this.body.func_78790_a(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
/*  41 */     this.body.func_78793_a(0.0F, var1, 0.0F);
/*  42 */     this.rightLeg = new ModelRenderer(this, 26, 0);
/*  43 */     this.rightLeg.func_78789_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
/*  44 */     this.rightLeg.func_78793_a(-2.0F, (3 + var1), 1.0F);
/*  45 */     this.leftLeg = new ModelRenderer(this, 26, 0);
/*  46 */     this.leftLeg.func_78789_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
/*  47 */     this.leftLeg.func_78793_a(1.0F, (3 + var1), 1.0F);
/*  48 */     this.rightWing = new ModelRenderer(this, 24, 13);
/*  49 */     this.rightWing.func_78789_a(0.0F, 0.0F, -3.0F, 1, 4, 6);
/*  50 */     this.rightWing.func_78793_a(-4.0F, (-3 + var1), 0.0F);
/*  51 */     this.leftWing = new ModelRenderer(this, 24, 13);
/*  52 */     this.leftWing.func_78789_a(-1.0F, 0.0F, -3.0F, 1, 4, 6);
/*  53 */     this.leftWing.func_78793_a(4.0F, (-3 + var1), 0.0F);
/*     */     
/*  55 */     this.crown = new ModelRenderer(this, 0, 23);
/*  56 */     this.crown.func_78789_a(0.0F, -7.0F, -3.0F, 0, 4, 5);
/*  57 */     this.crown.func_78793_a(0.0F, (-3 + var1), -1.0F);
/*     */ 
/*     */     
/*  60 */     this.tails = new ModelRenderer[32];
/*  61 */     for (int i = 0; i < 32; i++) {
/*  62 */       this.tails[i] = new ModelRenderer(this, 45, 0);
/*  63 */       this.tails[i].func_78790_a(0.0F, 16.0F, 0.0F, 3, 21, 0, 0.0F);
/*  64 */       this.tails[i].func_78793_a(0.0F, 32.0F, 2.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  74 */     setRotationAngles(par2, par3, par4, par5, par6, par7);
/*  75 */     float percent = Math.max(TFC_Core.getPercentGrown((IAnimal)entity), 0.0F);
/*  76 */     float ageScale = 2.0F - percent;
/*     */ 
/*     */     
/*  79 */     GL11.glPushMatrix();
/*     */     
/*  81 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/*  82 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*     */     
/*  84 */     if (percent >= 0.75D && ((IAnimal)entity).getGender() == IAnimal.GenderEnum.MALE) {
/*  85 */       this.crown.field_78807_k = false;
/*  86 */       this.body.field_78795_f = 0.7853982F;
/*  87 */       this.rightWing.field_78795_f = 0.7853982F;
/*  88 */       this.rightWing.func_78793_a(-4.0F, 13.5F, -2.5F);
/*  89 */       this.leftWing.field_78795_f = 0.7853982F;
/*  90 */       this.leftWing.func_78793_a(4.0F, 13.5F, -2.5F);
/*  91 */       this.head.func_78793_a(0.0F, 13.0F, -1.0F);
/*  92 */       this.bill.func_78793_a(0.0F, 13.0F, -1.0F);
/*  93 */       this.chin.func_78793_a(0.0F, 13.0F, -1.0F);
/*     */     } 
/*  95 */     this.head.func_78785_a(par7);
/*  96 */     this.bill.func_78785_a(par7);
/*  97 */     this.chin.func_78785_a(par7);
/*     */     
/*  99 */     GL11.glPushMatrix();
/* 100 */     GL11.glScalef(0.75F, 0.75F, 0.75F);
/* 101 */     this.crown.func_78785_a(par7);
/* 102 */     GL11.glPopMatrix();
/* 103 */     GL11.glPopMatrix();
/*     */     
/* 105 */     GL11.glPushMatrix();
/* 106 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 107 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/* 108 */     this.body.func_78785_a(par7);
/* 109 */     this.rightLeg.func_78785_a(par7);
/* 110 */     this.leftLeg.func_78785_a(par7);
/* 111 */     this.rightWing.func_78785_a(par7);
/* 112 */     this.leftWing.func_78785_a(par7);
/* 113 */     GL11.glPopMatrix();
/* 114 */     GL11.glPushMatrix();
/* 115 */     GL11.glScalef(0.25F / percent, 0.5F / percent, 0.25F / percent);
/* 116 */     for (int i = 0; i < 32; i++) {
/* 117 */       this.tails[i].func_78785_a(par7);
/*     */     }
/* 119 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
/* 127 */     this.head.field_78795_f = -(par5 / 57.295776F);
/* 128 */     this.head.field_78796_g = par4 / 57.295776F;
/* 129 */     this.crown.field_78795_f = -(par5 / 57.295776F);
/* 130 */     this.crown.field_78796_g = par4 / 57.295776F;
/* 131 */     this.bill.field_78795_f = this.head.field_78795_f;
/* 132 */     this.bill.field_78796_g = this.head.field_78796_g;
/* 133 */     this.chin.field_78795_f = this.head.field_78795_f;
/* 134 */     this.chin.field_78796_g = this.head.field_78796_g;
/* 135 */     this.body.field_78795_f = 1.5707964F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     this.crown.field_78807_k = true;
/*     */     
/* 146 */     for (int i = 0; i < 32; i++) {
/* 147 */       (this.tails[i]).field_78795_f = 1.8849556F + (float)((i % 3) * Math.PI / 32.0D) * ((i % 2 != 0) ? true : -1);
/* 148 */       (this.tails[i]).field_78808_h = -1.5707964F + 3.1415927F * i / 31.0F;
/*     */     } 
/* 150 */     this.rightLeg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 151 */     this.leftLeg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 152 */     this.rightWing.field_78808_h = par3;
/* 153 */     this.leftWing.field_78808_h = -par3;
/* 154 */     this.rightWing.field_78795_f = 0.0F;
/* 155 */     this.leftWing.field_78795_f = 0.0F;
/* 156 */     this.rightWing.func_78793_a(-4.0F, 13.0F, 0.0F);
/* 157 */     this.leftWing.func_78793_a(4.0F, 13.0F, 0.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelChickenTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */