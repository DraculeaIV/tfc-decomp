/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityOcelotTFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
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
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelOcelotTFC
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer ocelotBackLeftLeg;
/*     */   ModelRenderer ocelotBackRightLeg;
/*     */   ModelRenderer ocelotFrontLeftLeg;
/*     */   ModelRenderer ocelotFrontRightLeg;
/*     */   ModelRenderer ocelotTail;
/*     */   ModelRenderer ocelotTail2;
/*     */   ModelRenderer ocelotHead;
/*     */   ModelRenderer ocelotBody;
/*  35 */   int field_78163_i = 1;
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelOcelotTFC() {
/*  40 */     func_78085_a("head.main", 0, 0);
/*  41 */     func_78085_a("head.nose", 0, 24);
/*  42 */     func_78085_a("head.ear1", 0, 10);
/*  43 */     func_78085_a("head.ear2", 6, 10);
/*  44 */     this.ocelotHead = new ModelRenderer(this, "head");
/*  45 */     this.ocelotHead.func_78786_a("main", -2.5F, -2.0F, -3.0F, 5, 4, 5);
/*  46 */     this.ocelotHead.func_78786_a("nose", -1.5F, 0.0F, -4.0F, 3, 2, 2);
/*  47 */     this.ocelotHead.func_78786_a("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2);
/*  48 */     this.ocelotHead.func_78786_a("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2);
/*  49 */     this.ocelotHead.func_78793_a(0.0F, 15.0F, -9.0F);
/*  50 */     this.ocelotBody = new ModelRenderer(this, 20, 0);
/*  51 */     this.ocelotBody.func_78790_a(-2.0F, 3.0F, -8.0F, 4, 16, 6, 0.0F);
/*  52 */     this.ocelotBody.func_78793_a(0.0F, 12.0F, -10.0F);
/*  53 */     this.ocelotTail = new ModelRenderer(this, 0, 15);
/*  54 */     this.ocelotTail.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
/*  55 */     this.ocelotTail.field_78795_f = 0.9F;
/*  56 */     this.ocelotTail.func_78793_a(0.0F, 15.0F, 8.0F);
/*  57 */     this.ocelotTail2 = new ModelRenderer(this, 4, 15);
/*  58 */     this.ocelotTail2.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
/*  59 */     this.ocelotTail2.func_78793_a(0.0F, 20.0F, 14.0F);
/*  60 */     this.ocelotBackLeftLeg = new ModelRenderer(this, 8, 13);
/*  61 */     this.ocelotBackLeftLeg.func_78789_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
/*  62 */     this.ocelotBackLeftLeg.func_78793_a(1.1F, 18.0F, 5.0F);
/*  63 */     this.ocelotBackRightLeg = new ModelRenderer(this, 8, 13);
/*  64 */     this.ocelotBackRightLeg.func_78789_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
/*  65 */     this.ocelotBackRightLeg.func_78793_a(-1.1F, 18.0F, 5.0F);
/*  66 */     this.ocelotFrontLeftLeg = new ModelRenderer(this, 40, 0);
/*  67 */     this.ocelotFrontLeftLeg.func_78789_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
/*  68 */     this.ocelotFrontLeftLeg.func_78793_a(1.2F, 13.8F, -5.0F);
/*  69 */     this.ocelotFrontRightLeg = new ModelRenderer(this, 40, 0);
/*  70 */     this.ocelotFrontRightLeg.func_78789_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
/*  71 */     this.ocelotFrontRightLeg.func_78793_a(-1.2F, 13.8F, -5.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
/*  79 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
/*     */     
/*  81 */     if (this.field_78091_s) {
/*     */       
/*  83 */       float f6 = 2.0F;
/*  84 */       GL11.glPushMatrix();
/*  85 */       GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
/*  86 */       GL11.glTranslatef(0.0F, 10.0F * p_78088_7_, 4.0F * p_78088_7_);
/*  87 */       this.ocelotHead.func_78785_a(p_78088_7_);
/*  88 */       GL11.glPopMatrix();
/*  89 */       GL11.glPushMatrix();
/*  90 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/*  91 */       GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
/*  92 */       this.ocelotBody.func_78785_a(p_78088_7_);
/*  93 */       this.ocelotBackLeftLeg.func_78785_a(p_78088_7_);
/*  94 */       this.ocelotBackRightLeg.func_78785_a(p_78088_7_);
/*  95 */       this.ocelotFrontLeftLeg.func_78785_a(p_78088_7_);
/*  96 */       this.ocelotFrontRightLeg.func_78785_a(p_78088_7_);
/*  97 */       this.ocelotTail.func_78785_a(p_78088_7_);
/*  98 */       this.ocelotTail2.func_78785_a(p_78088_7_);
/*  99 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 103 */       this.ocelotHead.func_78785_a(p_78088_7_);
/* 104 */       this.ocelotBody.func_78785_a(p_78088_7_);
/* 105 */       this.ocelotTail.func_78785_a(p_78088_7_);
/* 106 */       this.ocelotTail2.func_78785_a(p_78088_7_);
/* 107 */       this.ocelotBackLeftLeg.func_78785_a(p_78088_7_);
/* 108 */       this.ocelotBackRightLeg.func_78785_a(p_78088_7_);
/* 109 */       this.ocelotFrontLeftLeg.func_78785_a(p_78088_7_);
/* 110 */       this.ocelotFrontRightLeg.func_78785_a(p_78088_7_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
/* 121 */     this.ocelotHead.field_78795_f = p_78087_5_ / 57.295776F;
/* 122 */     this.ocelotHead.field_78796_g = p_78087_4_ / 57.295776F;
/*     */     
/* 124 */     if (this.field_78163_i != 3) {
/*     */       
/* 126 */       this.ocelotBody.field_78795_f = 1.5707964F;
/*     */       
/* 128 */       if (this.field_78163_i == 2) {
/*     */         
/* 130 */         this.ocelotBackLeftLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/* 131 */         this.ocelotBackRightLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 0.3F) * 1.0F * p_78087_2_;
/* 132 */         this.ocelotFrontLeftLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F + 0.3F) * 1.0F * p_78087_2_;
/* 133 */         this.ocelotFrontRightLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 134 */         this.ocelotTail2.field_78795_f = 1.7278761F + 0.31415927F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
/*     */       }
/*     */       else {
/*     */         
/* 138 */         this.ocelotBackLeftLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/* 139 */         this.ocelotBackRightLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 140 */         this.ocelotFrontLeftLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.0F * p_78087_2_;
/* 141 */         this.ocelotFrontRightLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
/*     */         
/* 143 */         if (this.field_78163_i == 1) {
/*     */           
/* 145 */           this.ocelotTail2.field_78795_f = 1.7278761F + 0.7853982F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
/*     */         }
/*     */         else {
/*     */           
/* 149 */           this.ocelotTail2.field_78795_f = 1.7278761F + 0.47123894F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
/* 161 */     EntityOcelotTFC entityocelot = (EntityOcelotTFC)p_78086_1_;
/* 162 */     this.ocelotBody.field_78797_d = 12.0F;
/* 163 */     this.ocelotBody.field_78798_e = -10.0F;
/* 164 */     this.ocelotHead.field_78797_d = 15.0F;
/* 165 */     this.ocelotHead.field_78798_e = -9.0F;
/* 166 */     this.ocelotTail.field_78797_d = 15.0F;
/* 167 */     this.ocelotTail.field_78798_e = 8.0F;
/* 168 */     this.ocelotTail2.field_78797_d = 20.0F;
/* 169 */     this.ocelotTail2.field_78798_e = 14.0F;
/* 170 */     this.ocelotFrontRightLeg.field_78797_d = 13.8F;
/* 171 */     this.ocelotFrontRightLeg.field_78798_e = -5.0F;
/* 172 */     this.ocelotBackRightLeg.field_78797_d = 18.0F;
/* 173 */     this.ocelotBackRightLeg.field_78798_e = 5.0F;
/* 174 */     this.ocelotTail.field_78795_f = 0.9F;
/*     */     
/* 176 */     if (entityocelot.func_70093_af()) {
/*     */       
/* 178 */       this.ocelotBody.field_78797_d++;
/* 179 */       this.ocelotHead.field_78797_d += 2.0F;
/* 180 */       this.ocelotTail.field_78797_d++;
/* 181 */       this.ocelotTail2.field_78797_d += -4.0F;
/* 182 */       this.ocelotTail2.field_78798_e += 2.0F;
/* 183 */       this.ocelotTail.field_78795_f = 1.5707964F;
/* 184 */       this.ocelotTail2.field_78795_f = 1.5707964F;
/* 185 */       this.field_78163_i = 0;
/*     */     }
/* 187 */     else if (entityocelot.func_70051_ag()) {
/*     */       
/* 189 */       this.ocelotTail2.field_78797_d = this.ocelotTail.field_78797_d;
/* 190 */       this.ocelotTail2.field_78798_e += 2.0F;
/* 191 */       this.ocelotTail.field_78795_f = 1.5707964F;
/* 192 */       this.ocelotTail2.field_78795_f = 1.5707964F;
/* 193 */       this.field_78163_i = 2;
/*     */     }
/* 195 */     else if (entityocelot.func_70906_o()) {
/*     */       
/* 197 */       this.ocelotBody.field_78795_f = 0.7853982F;
/* 198 */       this.ocelotBody.field_78797_d += -4.0F;
/* 199 */       this.ocelotBody.field_78798_e += 5.0F;
/* 200 */       this.ocelotHead.field_78797_d += -3.3F;
/* 201 */       this.ocelotHead.field_78798_e++;
/* 202 */       this.ocelotTail.field_78797_d += 8.0F;
/* 203 */       this.ocelotTail.field_78798_e += -2.0F;
/* 204 */       this.ocelotTail2.field_78797_d += 2.0F;
/* 205 */       this.ocelotTail2.field_78798_e += -0.8F;
/* 206 */       this.ocelotTail.field_78795_f = 1.7278761F;
/* 207 */       this.ocelotTail2.field_78795_f = 2.670354F;
/* 208 */       this.ocelotFrontRightLeg.field_78795_f = -0.15707964F;
/* 209 */       this.ocelotFrontRightLeg.field_78797_d = 15.8F;
/* 210 */       this.ocelotFrontRightLeg.field_78798_e = -7.0F;
/* 211 */       this.ocelotBackRightLeg.field_78795_f = -1.5707964F;
/* 212 */       this.ocelotBackRightLeg.field_78797_d = 21.0F;
/* 213 */       this.ocelotBackRightLeg.field_78798_e = 1.0F;
/* 214 */       this.field_78163_i = 3;
/*     */     }
/*     */     else {
/*     */       
/* 218 */       this.field_78163_i = 1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelOcelotTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */