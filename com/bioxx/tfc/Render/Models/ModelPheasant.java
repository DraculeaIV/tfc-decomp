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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelPheasant
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer tail;
/*     */   private ModelRenderer leftLeg;
/*     */   private ModelRenderer rightLeg;
/*     */   private ModelRenderer tailFeather;
/*     */   private ModelRenderer leftLowerLeg;
/*     */   private ModelRenderer rightLowerLeg;
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer head;
/*     */   private ModelRenderer beak;
/*     */   private ModelRenderer chest;
/*     */   private ModelRenderer leftWing;
/*     */   private ModelRenderer rightWing;
/*     */   private ModelRenderer leftFoot;
/*     */   private ModelRenderer rightFoot;
/*     */   
/*     */   public ModelPheasant() {
/*  39 */     this.field_78090_t = 64;
/*  40 */     this.field_78089_u = 32;
/*     */     
/*  42 */     this.body = new ModelRenderer(this, 0, 7);
/*  43 */     this.body.func_78789_a(-4.0F, 0.0F, -2.5F, 9, 6, 5);
/*  44 */     this.body.func_78793_a(0.0F, 12.0F, 0.0F);
/*  45 */     this.body.field_78809_i = true;
/*  46 */     setRotation(this.body, 0.0F, 0.0F, -0.5235988F);
/*     */     
/*  48 */     this.tail = new ModelRenderer(this, 0, 0);
/*  49 */     this.tail.func_78789_a(-7.0F, 2.0F, -2.0F, 6, 3, 4);
/*  50 */     this.tail.func_78793_a(0.0F, 12.0F, 0.0F);
/*  51 */     this.tail.field_78809_i = true;
/*  52 */     setRotation(this.tail, 0.0F, 0.0F, -0.1745329F);
/*     */     
/*  54 */     this.leftLeg = new ModelRenderer(this, 16, 24);
/*  55 */     this.leftLeg.func_78789_a(1.0F, 4.0F, 1.0F, 3, 4, 2);
/*  56 */     this.leftLeg.func_78793_a(0.0F, 12.0F, 0.0F);
/*  57 */     this.leftLeg.field_78809_i = true;
/*  58 */     setRotation(this.leftLeg, 0.0F, 0.0F, 0.3490659F);
/*     */     
/*  60 */     this.rightLeg = new ModelRenderer(this, 26, 24);
/*  61 */     this.rightLeg.func_78789_a(1.0F, 4.0F, -3.0F, 3, 4, 2);
/*  62 */     this.rightLeg.func_78793_a(0.0F, 12.0F, 0.0F);
/*  63 */     this.rightLeg.field_78809_i = true;
/*  64 */     setRotation(this.rightLeg, 0.0F, 0.0F, 0.3490659F);
/*     */     
/*  66 */     this.tailFeather = new ModelRenderer(this, 20, 0);
/*  67 */     this.tailFeather.func_78789_a(-14.96F, 3.0F, -1.0F, 9, 1, 2);
/*  68 */     this.tailFeather.func_78793_a(0.0F, 12.0F, 0.0F);
/*  69 */     this.tailFeather.field_78809_i = true;
/*  70 */     setRotation(this.tailFeather, 0.0F, 0.0F, -0.0872665F);
/*     */     
/*  72 */     this.leftLowerLeg = new ModelRenderer(this, 34, 19);
/*  73 */     this.leftLowerLeg.func_78789_a(-1.0F, 8.0F, 1.5F, 1, 4, 1);
/*  74 */     this.leftLowerLeg.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.leftLowerLeg.field_78809_i = true;
/*  76 */     setRotation(this.leftLowerLeg, 0.0F, 0.0F, 0.0F);
/*     */     
/*  78 */     this.rightLowerLeg = new ModelRenderer(this, 38, 19);
/*  79 */     this.rightLowerLeg.func_78789_a(-1.0F, 8.0F, -2.5F, 1, 4, 1);
/*  80 */     this.rightLowerLeg.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.rightLowerLeg.field_78809_i = true;
/*  82 */     setRotation(this.rightLowerLeg, 0.0F, 0.0F, 0.0F);
/*     */     
/*  84 */     this.neck = new ModelRenderer(this, 28, 13);
/*  85 */     this.neck.func_78790_a(4.0F, 2.0F, -1.5F, 4, 3, 3, 0.05F);
/*  86 */     this.neck.func_78793_a(-4.0F, 2.0F, 0.0F);
/*  87 */     this.neck.field_78809_i = true;
/*  88 */     setRotation(this.neck, 0.0F, 0.0F, -0.8726646F);
/*     */     
/*  90 */     this.head = new ModelRenderer(this, 16, 18);
/*  91 */     this.head.func_78790_a(2.5F, -3.0F, -1.5F, 3, 3, 3, 0.1F);
/*  92 */     this.head.func_78793_a(4.0F, 10.0F, 0.0F);
/*  93 */     this.head.field_78809_i = true;
/*  94 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*     */     
/*  96 */     this.beak = new ModelRenderer(this, 28, 19);
/*  97 */     this.beak.func_78789_a(5.0F, -2.0F, -0.5F, 2, 1, 1);
/*  98 */     this.beak.func_78793_a(4.0F, 10.0F, 0.0F);
/*  99 */     this.beak.field_78809_i = true;
/* 100 */     setRotation(this.beak, 0.0F, 0.0F, 0.0F);
/*     */     
/* 102 */     this.chest = new ModelRenderer(this, 28, 7);
/* 103 */     this.chest.func_78789_a(-1.0F, 4.5F, -1.5F, 4, 3, 3);
/* 104 */     this.chest.func_78793_a(-4.0F, 2.0F, 0.0F);
/* 105 */     this.chest.field_78809_i = true;
/* 106 */     setRotation(this.chest, 0.0F, 0.0F, -1.396263F);
/*     */     
/* 108 */     this.leftWing = new ModelRenderer(this, 0, 23);
/* 109 */     this.leftWing.func_78789_a(-3.0F, 1.0F, 2.5F, 7, 4, 1);
/* 110 */     this.leftWing.func_78793_a(0.0F, 12.0F, 0.0F);
/* 111 */     this.leftWing.field_78809_i = true;
/* 112 */     setRotation(this.leftWing, 0.0F, 0.0F, -0.5235988F);
/*     */     
/* 114 */     this.rightWing = new ModelRenderer(this, 0, 18);
/* 115 */     this.rightWing.func_78789_a(-3.0F, 1.0F, -3.5F, 7, 4, 1);
/* 116 */     this.rightWing.func_78793_a(0.0F, 12.0F, 0.0F);
/* 117 */     this.rightWing.field_78809_i = true;
/* 118 */     setRotation(this.rightWing, 0.0F, 0.0F, -0.5235988F);
/*     */     
/* 120 */     this.leftFoot = new ModelRenderer(this, 20, 3);
/* 121 */     this.leftFoot.func_78790_a(-2.0F, 11.9F, 0.5F, 4, 0, 3, 0.001F);
/* 122 */     this.leftFoot.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.leftFoot.field_78809_i = true;
/* 124 */     setRotation(this.leftFoot, 0.0F, 0.0F, 0.0F);
/*     */     
/* 126 */     this.rightFoot = new ModelRenderer(this, 20, 3);
/* 127 */     this.rightFoot.func_78790_a(-2.0F, 11.9F, -3.5F, 4, 0, 3, 0.001F);
/* 128 */     this.rightFoot.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.rightFoot.field_78809_i = true;
/* 130 */     setRotation(this.rightFoot, 0.0F, 0.0F, 0.0F);
/*     */     
/* 132 */     this.head.func_78792_a(this.neck);
/* 133 */     this.head.func_78792_a(this.chest);
/*     */     
/* 135 */     this.rightLeg.func_78792_a(this.rightLowerLeg);
/* 136 */     this.rightLowerLeg.func_78792_a(this.rightFoot);
/* 137 */     this.leftLeg.func_78792_a(this.leftLowerLeg);
/* 138 */     this.leftLowerLeg.func_78792_a(this.leftFoot);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 144 */     setRotationAngles(par2, par3, par4, par5, par6, par7);
/* 145 */     float percent = Math.max(TFC_Core.getPercentGrown((IAnimal)entity), 0.0F);
/* 146 */     float ageScale = 2.0F - percent;
/*     */ 
/*     */     
/* 149 */     GL11.glPushMatrix();
/*     */     
/* 151 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 152 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*     */     
/* 154 */     this.head.func_78785_a(par7);
/* 155 */     this.beak.func_78785_a(par7);
/*     */ 
/*     */ 
/*     */     
/* 159 */     GL11.glPopMatrix();
/*     */     
/* 161 */     GL11.glPushMatrix();
/* 162 */     GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/* 163 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/* 164 */     this.body.func_78785_a(par7);
/* 165 */     this.rightLeg.func_78785_a(par7);
/* 166 */     this.leftLeg.func_78785_a(par7);
/*     */ 
/*     */     
/* 169 */     this.rightWing.func_78785_a(par7);
/* 170 */     this.leftWing.func_78785_a(par7);
/*     */ 
/*     */     
/* 173 */     this.tail.func_78785_a(par7);
/* 174 */     this.tailFeather.func_78785_a(par7);
/* 175 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 180 */     model.field_78795_f = x;
/* 181 */     model.field_78796_g = y;
/* 182 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
/* 187 */     this.head.field_78796_g = par4 / 57.295776F;
/*     */     
/* 189 */     this.beak.field_78796_g = this.head.field_78796_g;
/*     */ 
/*     */     
/* 192 */     this.neck.field_78808_h = -0.8726646F;
/* 193 */     this.chest.field_78808_h = -1.3962634F;
/* 194 */     this.body.field_78808_h = -0.5235988F;
/* 195 */     this.rightWing.field_78808_h = -0.5235988F;
/* 196 */     this.leftWing.field_78808_h = -0.5235988F;
/* 197 */     if (par3 != 0.0F) {
/* 198 */       this.rightWing.func_78793_a(4.0F, 12.0F, -2.0F);
/* 199 */       this.leftWing.func_78793_a(4.0F, 12.0F, 2.0F);
/* 200 */       this.rightWing.field_78808_h = -1.5707964F;
/* 201 */       this.leftWing.field_78808_h = -1.5707964F;
/* 202 */       this.rightWing.field_82906_o = -0.1875F;
/* 203 */       this.rightWing.field_82908_p = -0.1875F;
/* 204 */       this.rightWing.field_82907_q = -0.09375F;
/* 205 */       this.leftWing.field_82906_o = -0.1875F;
/* 206 */       this.leftWing.field_82908_p = -0.1875F;
/* 207 */       this.leftWing.field_82907_q = 0.09375F;
/*     */     } else {
/*     */       
/* 210 */       this.rightWing.func_78793_a(0.0F, 12.0F, 0.0F);
/* 211 */       this.leftWing.func_78793_a(0.0F, 12.0F, 0.0F);
/* 212 */       this.rightWing.field_82906_o = 0.0F;
/* 213 */       this.rightWing.field_82908_p = 0.0F;
/* 214 */       this.rightWing.field_82907_q = 0.0F;
/* 215 */       this.leftWing.field_82906_o = 0.0F;
/* 216 */       this.leftWing.field_82908_p = 0.0F;
/* 217 */       this.leftWing.field_82907_q = 0.0F;
/*     */     } 
/* 219 */     this.rightWing.field_78796_g = par3;
/* 220 */     this.leftWing.field_78796_g = -par3;
/*     */ 
/*     */     
/* 223 */     this.tail.field_78808_h = -0.17453292F;
/* 224 */     this.tailFeather.field_78808_h = -0.08726646F;
/* 225 */     this.rightLeg.field_78808_h = 0.34906584F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 226 */     this.leftLeg.field_78808_h = 0.34906584F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 227 */     this.rightLowerLeg.field_78808_h = -0.34906584F;
/* 228 */     this.leftLowerLeg.field_78808_h = -0.34906584F;
/* 229 */     this.rightFoot.field_78808_h = 0.0F;
/* 230 */     this.leftFoot.field_78808_h = 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelPheasant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */