/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelUngulate
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer body1;
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer haunch;
/*     */   private ModelRenderer underSide;
/*     */   private ModelRenderer throat;
/*     */   private ModelRenderer spine;
/*     */   private ModelRenderer leftThigh;
/*     */   private ModelRenderer rightThigh;
/*     */   private ModelRenderer leftCalf;
/*     */   private ModelRenderer rightCalf;
/*     */   private ModelRenderer leftAnkle;
/*     */   private ModelRenderer rightAnkle;
/*     */   private ModelRenderer leftFoot;
/*     */   private ModelRenderer rightFoot;
/*     */   private ModelRenderer leftHoofBack;
/*     */   private ModelRenderer rightHoofBack;
/*     */   private ModelRenderer leftShoulder;
/*     */   private ModelRenderer rightShoulder;
/*     */   private ModelRenderer leftArm;
/*     */   private ModelRenderer rightArm;
/*     */   private ModelRenderer leftWrist;
/*     */   private ModelRenderer rightWrist;
/*     */   private ModelRenderer rightHoofFront;
/*     */   private ModelRenderer leftHoofFront;
/*     */   
/*     */   public ModelUngulate() {
/*  39 */     this.field_78090_t = 64;
/*  40 */     this.field_78089_u = 32;
/*     */     
/*  42 */     this.body1 = new ModelRenderer(this, 0, 0);
/*  43 */     this.body1.func_78789_a(-3.0F, -3.0F, -6.0F, 6, 8, 16);
/*  44 */     this.body1.func_78793_a(0.0F, 7.0F, 0.0F);
/*  45 */     this.body1.func_78787_b(64, 32);
/*  46 */     this.body1.field_78809_i = true;
/*  47 */     setRotation(this.body1, -0.1047198F, 0.0F, 0.0F);
/*  48 */     this.neck = new ModelRenderer(this, 0, 0);
/*  49 */     this.neck.func_78789_a(-2.0F, -1.0F, -11.0F, 4, 5, 6);
/*  50 */     this.neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.neck.func_78787_b(64, 32);
/*  52 */     this.neck.field_78809_i = true;
/*  53 */     setRotation(this.neck, -0.3490659F, 0.0F, 0.0F);
/*  54 */     this.haunch = new ModelRenderer(this, 0, 0);
/*  55 */     this.haunch.func_78789_a(-3.5F, -3.0F, 0.0F, 7, 8, 9);
/*  56 */     this.haunch.func_78793_a(0.0F, 0.0F, 4.0F);
/*  57 */     this.haunch.func_78787_b(64, 32);
/*  58 */     this.haunch.field_78809_i = true;
/*  59 */     setRotation(this.haunch, 0.0872665F, 0.0F, 0.0F);
/*  60 */     this.underSide = new ModelRenderer(this, 0, 0);
/*  61 */     this.underSide.func_78789_a(-3.0F, 1.5F, 2.0F, 6, 6, 4);
/*  62 */     this.underSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.underSide.func_78787_b(64, 32);
/*  64 */     this.underSide.field_78809_i = true;
/*  65 */     setRotation(this.underSide, 0.5235988F, 0.0F, 0.0F);
/*  66 */     this.throat = new ModelRenderer(this, 0, 0);
/*  67 */     this.throat.func_78789_a(-1.5F, 5.0F, -10.0F, 3, 2, 8);
/*  68 */     this.throat.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.throat.func_78787_b(64, 32);
/*  70 */     this.throat.field_78809_i = true;
/*  71 */     setRotation(this.throat, -0.6108652F, 0.0F, 0.0F);
/*  72 */     this.spine = new ModelRenderer(this, 0, 0);
/*  73 */     this.spine.func_78789_a(-1.5F, -4.0F, -9.0F, 3, 1, 22);
/*  74 */     this.spine.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.spine.func_78787_b(64, 32);
/*  76 */     this.spine.field_78809_i = true;
/*  77 */     setRotation(this.spine, -0.0349066F, 0.0F, 0.0F);
/*  78 */     this.leftThigh = new ModelRenderer(this, 0, 0);
/*  79 */     this.leftThigh.func_78789_a(-1.0F, -2.0F, -4.0F, 2, 7, 4);
/*  80 */     this.leftThigh.func_78793_a(3.0F, 2.0F, 8.0F);
/*  81 */     this.leftThigh.func_78787_b(64, 32);
/*  82 */     this.leftThigh.field_78809_i = true;
/*  83 */     setRotation(this.leftThigh, -0.5235988F, 0.0F, 0.0F);
/*  84 */     this.rightThigh = new ModelRenderer(this, 0, 0);
/*  85 */     this.rightThigh.func_78789_a(-1.0F, -2.0F, -4.0F, 2, 7, 4);
/*  86 */     this.rightThigh.func_78793_a(-3.0F, 2.0F, 8.0F);
/*  87 */     this.rightThigh.func_78787_b(64, 32);
/*  88 */     this.rightThigh.field_78809_i = true;
/*  89 */     setRotation(this.rightThigh, -0.5235988F, 0.0F, 0.0F);
/*  90 */     this.leftCalf = new ModelRenderer(this, 0, 0);
/*  91 */     this.leftCalf.func_78789_a(-0.6F, 0.0F, 0.0F, 2, 4, 3);
/*  92 */     this.leftCalf.func_78793_a(0.0F, 5.0F, -3.0F);
/*  93 */     this.leftCalf.func_78787_b(64, 32);
/*  94 */     this.leftCalf.field_78809_i = true;
/*  95 */     setRotation(this.leftCalf, 1.3089969F, 0.0F, 0.0F);
/*  96 */     this.rightCalf = new ModelRenderer(this, 0, 0);
/*  97 */     this.rightCalf.func_78789_a(-1.3F, 0.0F, 0.0F, 2, 4, 3);
/*  98 */     this.rightCalf.func_78793_a(0.0F, 5.0F, -3.0F);
/*  99 */     this.rightCalf.func_78787_b(64, 32);
/* 100 */     this.rightCalf.field_78809_i = true;
/* 101 */     setRotation(this.rightCalf, 1.3089969F, 0.0F, 0.0F);
/* 102 */     this.leftAnkle = new ModelRenderer(this, 0, 0);
/* 103 */     this.leftAnkle.func_78789_a(-0.6F, 2.0F, 0.2F, 2, 5, 2);
/* 104 */     this.leftAnkle.func_78793_a(0.0F, 0.0F, 0.0F);
/* 105 */     this.leftAnkle.func_78787_b(64, 32);
/* 106 */     this.leftAnkle.field_78809_i = true;
/* 107 */     setRotation(this.leftAnkle, 0.0F, 0.0F, 0.0F);
/* 108 */     this.rightAnkle = new ModelRenderer(this, 0, 0);
/* 109 */     this.rightAnkle.func_78789_a(-1.3F, 2.0F, 0.2F, 2, 5, 2);
/* 110 */     this.rightAnkle.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.rightAnkle.func_78787_b(64, 32);
/* 112 */     this.rightAnkle.field_78809_i = true;
/* 113 */     setRotation(this.rightAnkle, 0.0F, 0.0F, 0.0F);
/* 114 */     this.leftFoot = new ModelRenderer(this, 0, 0);
/* 115 */     this.leftFoot.func_78789_a(-0.6F, 0.8F, -0.3F, 2, 6, 2);
/* 116 */     this.leftFoot.func_78793_a(0.0F, 5.0F, 1.5F);
/* 117 */     this.leftFoot.func_78787_b(64, 32);
/* 118 */     this.leftFoot.field_78809_i = true;
/* 119 */     setRotation(this.leftFoot, -0.7853982F, 0.0F, 0.0F);
/* 120 */     this.rightFoot = new ModelRenderer(this, 0, 0);
/* 121 */     this.rightFoot.func_78789_a(-1.3F, 0.8F, -0.3F, 2, 6, 2);
/* 122 */     this.rightFoot.func_78793_a(0.0F, 5.0F, 1.5F);
/* 123 */     this.rightFoot.func_78787_b(64, 32);
/* 124 */     this.rightFoot.field_78809_i = true;
/* 125 */     setRotation(this.rightFoot, -0.7853982F, 0.0F, 0.0F);
/* 126 */     this.leftHoofBack = new ModelRenderer(this, 0, 0);
/* 127 */     this.leftHoofBack.func_78789_a(-0.6F, 0.5F, -0.5F, 2, 1, 2);
/* 128 */     this.leftHoofBack.func_78793_a(0.0F, 6.0F, -0.5F);
/* 129 */     this.leftHoofBack.func_78787_b(64, 32);
/* 130 */     this.leftHoofBack.field_78809_i = true;
/* 131 */     setRotation(this.leftHoofBack, 0.0F, 0.0F, 0.0F);
/* 132 */     this.rightHoofBack = new ModelRenderer(this, 0, 0);
/* 133 */     this.rightHoofBack.func_78789_a(-1.3F, 0.5F, -0.5F, 2, 1, 2);
/* 134 */     this.rightHoofBack.func_78793_a(0.0F, 6.0F, -0.5F);
/* 135 */     this.rightHoofBack.func_78787_b(64, 32);
/* 136 */     this.rightHoofBack.field_78809_i = true;
/* 137 */     setRotation(this.rightHoofBack, 0.0F, 0.0F, 0.0F);
/* 138 */     this.leftShoulder = new ModelRenderer(this, 0, 0);
/* 139 */     this.leftShoulder.func_78789_a(-1.5F, -1.0F, -2.0F, 2, 5, 3);
/* 140 */     this.leftShoulder.func_78793_a(3.0F, 3.0F, -4.0F);
/* 141 */     this.leftShoulder.func_78787_b(64, 32);
/* 142 */     this.leftShoulder.field_78809_i = true;
/* 143 */     setRotation(this.leftShoulder, 1.1519173F, 0.0F, 0.0F);
/* 144 */     this.rightShoulder = new ModelRenderer(this, 0, 0);
/* 145 */     this.rightShoulder.func_78789_a(-0.5F, -1.0F, -2.0F, 2, 5, 3);
/* 146 */     this.rightShoulder.func_78793_a(-3.0F, 3.0F, -4.0F);
/* 147 */     this.rightShoulder.func_78787_b(64, 32);
/* 148 */     this.rightShoulder.field_78809_i = true;
/* 149 */     setRotation(this.rightShoulder, 1.1519173F, 0.0F, 0.0F);
/* 150 */     this.leftArm = new ModelRenderer(this, 0, 0);
/* 151 */     this.leftArm.func_78789_a(-1.0F, 0.8F, 0.0F, 2, 5, 2);
/* 152 */     this.leftArm.func_78793_a(-0.4F, 2.0F, 0.0F);
/* 153 */     this.leftArm.func_78787_b(64, 32);
/* 154 */     this.leftArm.field_78809_i = true;
/* 155 */     setRotation(this.leftArm, -1.0471976F, 0.0F, 0.0F);
/* 156 */     this.rightArm = new ModelRenderer(this, 0, 0);
/* 157 */     this.rightArm.func_78789_a(-1.0F, 0.8F, 0.0F, 2, 5, 2);
/* 158 */     this.rightArm.func_78793_a(0.4F, 2.0F, 0.0F);
/* 159 */     this.rightArm.func_78787_b(64, 32);
/* 160 */     this.rightArm.field_78809_i = true;
/* 161 */     setRotation(this.rightArm, -1.0471976F, 0.0F, 0.0F);
/* 162 */     this.leftWrist = new ModelRenderer(this, 0, 0);
/* 163 */     this.leftWrist.func_78789_a(-1.0F, 0.5F, 0.0F, 2, 5, 2);
/* 164 */     this.leftWrist.func_78793_a(0.0F, 5.0F, 0.0F);
/* 165 */     this.leftWrist.func_78787_b(64, 32);
/* 166 */     this.leftWrist.field_78809_i = true;
/* 167 */     setRotation(this.leftWrist, 0.0F, 0.0F, 0.0F);
/* 168 */     this.rightWrist = new ModelRenderer(this, 0, 0);
/* 169 */     this.rightWrist.func_78789_a(-1.0F, 0.5F, 0.0F, 2, 5, 2);
/* 170 */     this.rightWrist.func_78793_a(0.0F, 5.0F, 0.0F);
/* 171 */     this.rightWrist.func_78787_b(64, 32);
/* 172 */     this.rightWrist.field_78809_i = true;
/* 173 */     setRotation(this.rightWrist, 0.0F, 0.0F, 0.0F);
/* 174 */     this.leftHoofFront = new ModelRenderer(this, 0, 0);
/* 175 */     this.leftHoofFront.func_78789_a(-1.0F, 0.5F, -0.5F, 2, 1, 2);
/* 176 */     this.leftHoofFront.func_78793_a(0.0F, 5.0F, 0.0F);
/* 177 */     this.leftHoofFront.func_78787_b(64, 32);
/* 178 */     this.leftHoofFront.field_78809_i = true;
/* 179 */     setRotation(this.leftHoofFront, 0.0F, 0.0F, 0.0F);
/* 180 */     this.rightHoofFront = new ModelRenderer(this, 0, 0);
/* 181 */     this.rightHoofFront.func_78789_a(-1.0F, 0.5F, -0.5F, 2, 1, 2);
/* 182 */     this.rightHoofFront.func_78793_a(0.0F, 5.0F, 0.0F);
/* 183 */     this.rightHoofFront.func_78787_b(64, 32);
/* 184 */     this.rightHoofFront.field_78809_i = true;
/* 185 */     setRotation(this.rightHoofFront, 0.0F, 0.0F, 0.0F);
/*     */     
/* 187 */     this.body1.func_78792_a(this.neck);
/* 188 */     this.neck.func_78792_a(this.throat);
/* 189 */     this.body1.func_78792_a(this.haunch);
/*     */     
/* 191 */     this.body1.func_78792_a(this.leftShoulder);
/* 192 */     this.body1.func_78792_a(this.rightShoulder);
/* 193 */     this.leftShoulder.func_78792_a(this.leftArm);
/* 194 */     this.leftArm.func_78792_a(this.leftWrist);
/* 195 */     this.leftWrist.func_78792_a(this.leftHoofFront);
/* 196 */     this.rightShoulder.func_78792_a(this.rightArm);
/* 197 */     this.rightArm.func_78792_a(this.rightWrist);
/* 198 */     this.rightWrist.func_78792_a(this.rightHoofFront);
/* 199 */     this.body1.func_78792_a(this.underSide);
/* 200 */     this.haunch.func_78792_a(this.leftThigh);
/* 201 */     this.haunch.func_78792_a(this.rightThigh);
/* 202 */     this.leftThigh.func_78792_a(this.leftCalf);
/* 203 */     this.rightThigh.func_78792_a(this.rightCalf);
/* 204 */     this.leftCalf.func_78792_a(this.leftAnkle);
/* 205 */     this.rightCalf.func_78792_a(this.rightAnkle);
/* 206 */     this.leftAnkle.func_78792_a(this.leftFoot);
/* 207 */     this.rightAnkle.func_78792_a(this.rightFoot);
/* 208 */     this.leftFoot.func_78792_a(this.leftHoofBack);
/* 209 */     this.rightFoot.func_78792_a(this.rightHoofBack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 215 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 216 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/* 217 */     this.body1.func_78785_a(f5);
/*     */   }
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
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 245 */     model.field_78795_f = x;
/* 246 */     model.field_78796_g = y;
/* 247 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
/* 252 */     float frontRightLeg = par1 + 2.3561945F;
/* 253 */     float frontLeftLeg = par1 + 7.0685835F;
/*     */ 
/*     */     
/* 256 */     float speedMod = Math.min(Math.abs(Math.max(Math.abs(par2), 0.001F)), 1.0F) * ((par2 != 0.0F) ? (par2 / Math.abs(par2)) : 1.0F);
/* 257 */     float rightArmInitAngle = -1.0471976F;
/* 258 */     float leftArmInitAngle = -1.0471976F;
/* 259 */     float leftThighInitAngle = -0.5235988F;
/* 260 */     float rightThighInitAngle = -0.5235988F;
/* 261 */     float rightCalfInitAngle = 1.3089969F;
/* 262 */     float leftCalfInitAngle = 1.3089969F;
/* 263 */     float rightFootInitAngle = -0.7853982F;
/*     */     
/* 265 */     this.rightWrist.field_78795_f = Math.max(0.0F, -MathHelper.func_76134_b(frontRightLeg * 0.6662F) * 1.8F * speedMod);
/*     */     
/* 267 */     this.leftWrist.field_78795_f = Math.max(0.0F, -MathHelper.func_76134_b(frontLeftLeg * 0.6662F) * 1.8F * speedMod);
/*     */ 
/*     */     
/* 270 */     this.rightShoulder.field_78795_f = MathHelper.func_76126_a(frontRightLeg * 0.6662F) * 1.4F * speedMod - rightArmInitAngle;
/* 271 */     this.leftShoulder.field_78795_f = MathHelper.func_76126_a(frontLeftLeg * 0.6662F) * 1.4F * speedMod - leftArmInitAngle;
/* 272 */     if (MathHelper.func_76134_b(frontRightLeg * 0.6662F + 1.5707964F) * 1.4F * speedMod > 0.0F) {
/* 273 */       this.rightArm.field_78795_f = MathHelper.func_76134_b(frontRightLeg * 0.6662F + 1.5707964F) * 1.4F * speedMod + rightArmInitAngle;
/* 274 */       this.leftCalf.field_78795_f = MathHelper.func_76134_b(frontRightLeg * 0.6662F + 1.5707964F) * 0.7F * ((MathHelper.func_76126_a(frontLeftLeg * 0.6662F) * speedMod > 0.0F) ? 1.5F : 1.0F) * speedMod + leftCalfInitAngle;
/*     */     } 
/* 276 */     if (MathHelper.func_76134_b(frontLeftLeg * 0.6662F + 1.5707964F) * 1.4F * speedMod > 0.0F) {
/* 277 */       this.leftArm.field_78795_f = MathHelper.func_76134_b(frontLeftLeg * 0.6662F + 1.5707964F) * 1.4F * speedMod + leftArmInitAngle;
/* 278 */       this.rightCalf.field_78795_f = MathHelper.func_76134_b(frontLeftLeg * 0.6662F + 1.5707964F) * 0.7F * ((MathHelper.func_76126_a(frontRightLeg * 0.6662F) * speedMod > 0.0F) ? 1.5F : 1.0F) * speedMod + rightCalfInitAngle;
/*     */     } 
/*     */     
/* 281 */     this.rightThigh.field_78795_f = MathHelper.func_76126_a(frontLeftLeg * 0.6662F) * 0.7F * speedMod + rightThighInitAngle;
/* 282 */     this.rightFoot.field_78795_f = MathHelper.func_76126_a(frontLeftLeg * 0.6662F) * 0.7F * ((MathHelper.func_76126_a(frontRightLeg * 0.6662F) * speedMod > 0.0F) ? 2 : true) * speedMod + rightFootInitAngle;
/* 283 */     this.leftThigh.field_78795_f = MathHelper.func_76126_a(frontRightLeg * 0.6662F) * 0.7F * speedMod + leftThighInitAngle;
/* 284 */     this.leftFoot.field_78795_f = MathHelper.func_76126_a(frontRightLeg * 0.6662F) * 0.7F * ((MathHelper.func_76126_a(frontLeftLeg * 0.6662F) * speedMod > 0.0F) ? 2 : true) * speedMod + rightFootInitAngle;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelUngulate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */