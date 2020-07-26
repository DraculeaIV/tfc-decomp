/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
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
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelHorseTFC
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer head;
/*     */   private ModelRenderer mouthTop;
/*     */   private ModelRenderer mouthBottom;
/*     */   private ModelRenderer horseLeftEar;
/*     */   private ModelRenderer horseRightEar;
/*     */   private ModelRenderer muleLeftEar;
/*     */   private ModelRenderer muleRightEar;
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer horseFaceRopes;
/*     */   private ModelRenderer mane;
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer tailBase;
/*     */   private ModelRenderer tailMiddle;
/*     */   private ModelRenderer tailTip;
/*     */   private ModelRenderer backLeftLeg;
/*     */   private ModelRenderer backLeftShin;
/*     */   private ModelRenderer backLeftHoof;
/*     */   private ModelRenderer backRightLeg;
/*     */   private ModelRenderer backRightShin;
/*     */   private ModelRenderer backRightHoof;
/*     */   private ModelRenderer frontLeftLeg;
/*     */   private ModelRenderer frontLeftShin;
/*     */   private ModelRenderer frontLeftHoof;
/*     */   private ModelRenderer frontRightLeg;
/*     */   private ModelRenderer frontRightShin;
/*     */   private ModelRenderer frontRightHoof;
/*     */   private ModelRenderer muleLeftChest;
/*     */   private ModelRenderer muleRightChest;
/*     */   private ModelRenderer horseSaddleBottom;
/*     */   private ModelRenderer horseSaddleFront;
/*     */   private ModelRenderer horseSaddleBack;
/*     */   private ModelRenderer horseLeftSaddleRope;
/*     */   private ModelRenderer horseLeftSaddleMetal;
/*     */   private ModelRenderer horseRightSaddleRope;
/*     */   private ModelRenderer horseRightSaddleMetal;
/*     */   private ModelRenderer horseLeftFaceMetal;
/*     */   private ModelRenderer horseRightFaceMetal;
/*     */   private ModelRenderer horseLeftRein;
/*     */   private ModelRenderer horseRightRein;
/*     */   
/*     */   public ModelHorseTFC() {
/*  72 */     this.field_78090_t = 128;
/*  73 */     this.field_78089_u = 128;
/*  74 */     this.body = new ModelRenderer(this, 0, 34);
/*  75 */     this.body.func_78789_a(-5.0F, -8.0F, -19.0F, 10, 10, 24);
/*  76 */     this.body.func_78793_a(0.0F, 11.0F, 9.0F);
/*  77 */     this.tailBase = new ModelRenderer(this, 44, 0);
/*  78 */     this.tailBase.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 3);
/*  79 */     this.tailBase.func_78793_a(0.0F, 3.0F, 14.0F);
/*  80 */     setBoxRotation(this.tailBase, -1.134464F, 0.0F, 0.0F);
/*  81 */     this.tailMiddle = new ModelRenderer(this, 38, 7);
/*  82 */     this.tailMiddle.func_78789_a(-1.5F, -2.0F, 3.0F, 3, 4, 7);
/*  83 */     this.tailMiddle.func_78793_a(0.0F, 3.0F, 14.0F);
/*  84 */     setBoxRotation(this.tailMiddle, -1.134464F, 0.0F, 0.0F);
/*  85 */     this.tailTip = new ModelRenderer(this, 24, 3);
/*  86 */     this.tailTip.func_78789_a(-1.5F, -4.5F, 9.0F, 3, 4, 7);
/*  87 */     this.tailTip.func_78793_a(0.0F, 3.0F, 14.0F);
/*  88 */     setBoxRotation(this.tailTip, -1.40215F, 0.0F, 0.0F);
/*  89 */     this.backLeftLeg = new ModelRenderer(this, 78, 29);
/*  90 */     this.backLeftLeg.func_78789_a(-2.5F, -2.0F, -2.5F, 4, 9, 5);
/*  91 */     this.backLeftLeg.func_78793_a(4.0F, 9.0F, 11.0F);
/*  92 */     this.backLeftShin = new ModelRenderer(this, 78, 43);
/*  93 */     this.backLeftShin.func_78789_a(-2.0F, 0.0F, -1.5F, 3, 5, 3);
/*  94 */     this.backLeftShin.func_78793_a(4.0F, 16.0F, 11.0F);
/*  95 */     this.backLeftHoof = new ModelRenderer(this, 78, 51);
/*  96 */     this.backLeftHoof.func_78789_a(-2.5F, 5.1F, -2.0F, 4, 3, 4);
/*  97 */     this.backLeftHoof.func_78793_a(4.0F, 16.0F, 11.0F);
/*  98 */     this.backRightLeg = new ModelRenderer(this, 96, 29);
/*  99 */     this.backRightLeg.func_78789_a(-1.5F, -2.0F, -2.5F, 4, 9, 5);
/* 100 */     this.backRightLeg.func_78793_a(-4.0F, 9.0F, 11.0F);
/* 101 */     this.backRightShin = new ModelRenderer(this, 96, 43);
/* 102 */     this.backRightShin.func_78789_a(-1.0F, 0.0F, -1.5F, 3, 5, 3);
/* 103 */     this.backRightShin.func_78793_a(-4.0F, 16.0F, 11.0F);
/* 104 */     this.backRightHoof = new ModelRenderer(this, 96, 51);
/* 105 */     this.backRightHoof.func_78789_a(-1.5F, 5.1F, -2.0F, 4, 3, 4);
/* 106 */     this.backRightHoof.func_78793_a(-4.0F, 16.0F, 11.0F);
/* 107 */     this.frontLeftLeg = new ModelRenderer(this, 44, 29);
/* 108 */     this.frontLeftLeg.func_78789_a(-1.9F, -1.0F, -2.1F, 3, 8, 4);
/* 109 */     this.frontLeftLeg.func_78793_a(4.0F, 9.0F, -8.0F);
/* 110 */     this.frontLeftShin = new ModelRenderer(this, 44, 41);
/* 111 */     this.frontLeftShin.func_78789_a(-1.9F, 0.0F, -1.6F, 3, 5, 3);
/* 112 */     this.frontLeftShin.func_78793_a(4.0F, 16.0F, -8.0F);
/* 113 */     this.frontLeftHoof = new ModelRenderer(this, 44, 51);
/* 114 */     this.frontLeftHoof.func_78789_a(-2.4F, 5.1F, -2.1F, 4, 3, 4);
/* 115 */     this.frontLeftHoof.func_78793_a(4.0F, 16.0F, -8.0F);
/* 116 */     this.frontRightLeg = new ModelRenderer(this, 60, 29);
/* 117 */     this.frontRightLeg.func_78789_a(-1.1F, -1.0F, -2.1F, 3, 8, 4);
/* 118 */     this.frontRightLeg.func_78793_a(-4.0F, 9.0F, -8.0F);
/* 119 */     this.frontRightShin = new ModelRenderer(this, 60, 41);
/* 120 */     this.frontRightShin.func_78789_a(-1.1F, 0.0F, -1.6F, 3, 5, 3);
/* 121 */     this.frontRightShin.func_78793_a(-4.0F, 16.0F, -8.0F);
/* 122 */     this.frontRightHoof = new ModelRenderer(this, 60, 51);
/* 123 */     this.frontRightHoof.func_78789_a(-1.6F, 5.1F, -2.1F, 4, 3, 4);
/* 124 */     this.frontRightHoof.func_78793_a(-4.0F, 16.0F, -8.0F);
/* 125 */     this.head = new ModelRenderer(this, 0, 0);
/* 126 */     this.head.func_78789_a(-2.5F, -10.0F, -1.5F, 5, 5, 7);
/* 127 */     this.head.func_78793_a(0.0F, 4.0F, -10.0F);
/* 128 */     setBoxRotation(this.head, 0.5235988F, 0.0F, 0.0F);
/* 129 */     this.mouthTop = new ModelRenderer(this, 24, 18);
/* 130 */     this.mouthTop.func_78789_a(-2.0F, -10.0F, -7.0F, 4, 3, 6);
/* 131 */     this.mouthTop.func_78793_a(0.0F, 3.95F, -10.0F);
/* 132 */     setBoxRotation(this.mouthTop, 0.5235988F, 0.0F, 0.0F);
/* 133 */     this.mouthBottom = new ModelRenderer(this, 24, 27);
/* 134 */     this.mouthBottom.func_78789_a(-2.0F, -7.0F, -6.5F, 4, 2, 5);
/* 135 */     this.mouthBottom.func_78793_a(0.0F, 4.0F, -10.0F);
/* 136 */     setBoxRotation(this.mouthBottom, 0.5235988F, 0.0F, 0.0F);
/* 137 */     this.head.func_78792_a(this.mouthTop);
/* 138 */     this.head.func_78792_a(this.mouthBottom);
/* 139 */     this.horseLeftEar = new ModelRenderer(this, 0, 0);
/* 140 */     this.horseLeftEar.func_78789_a(0.45F, -12.0F, 4.0F, 2, 3, 1);
/* 141 */     this.horseLeftEar.func_78793_a(0.0F, 4.0F, -10.0F);
/* 142 */     setBoxRotation(this.horseLeftEar, 0.5235988F, 0.0F, 0.0F);
/* 143 */     this.horseRightEar = new ModelRenderer(this, 0, 0);
/* 144 */     this.horseRightEar.func_78789_a(-2.45F, -12.0F, 4.0F, 2, 3, 1);
/* 145 */     this.horseRightEar.func_78793_a(0.0F, 4.0F, -10.0F);
/* 146 */     setBoxRotation(this.horseRightEar, 0.5235988F, 0.0F, 0.0F);
/* 147 */     this.muleLeftEar = new ModelRenderer(this, 0, 12);
/* 148 */     this.muleLeftEar.func_78789_a(-2.0F, -16.0F, 4.0F, 2, 7, 1);
/* 149 */     this.muleLeftEar.func_78793_a(0.0F, 4.0F, -10.0F);
/* 150 */     setBoxRotation(this.muleLeftEar, 0.5235988F, 0.0F, 0.2617994F);
/* 151 */     this.muleRightEar = new ModelRenderer(this, 0, 12);
/* 152 */     this.muleRightEar.func_78789_a(0.0F, -16.0F, 4.0F, 2, 7, 1);
/* 153 */     this.muleRightEar.func_78793_a(0.0F, 4.0F, -10.0F);
/* 154 */     setBoxRotation(this.muleRightEar, 0.5235988F, 0.0F, -0.2617994F);
/* 155 */     this.neck = new ModelRenderer(this, 0, 12);
/* 156 */     this.neck.func_78789_a(-2.05F, -9.8F, -2.0F, 4, 14, 8);
/* 157 */     this.neck.func_78793_a(0.0F, 4.0F, -10.0F);
/* 158 */     setBoxRotation(this.neck, 0.5235988F, 0.0F, 0.0F);
/* 159 */     this.muleLeftChest = new ModelRenderer(this, 0, 34);
/* 160 */     this.muleLeftChest.func_78789_a(-3.0F, 0.0F, 0.0F, 8, 8, 3);
/* 161 */     this.muleLeftChest.func_78793_a(-7.5F, 3.0F, 10.0F);
/* 162 */     setBoxRotation(this.muleLeftChest, 0.0F, 1.5707964F, 0.0F);
/* 163 */     this.muleRightChest = new ModelRenderer(this, 0, 47);
/* 164 */     this.muleRightChest.func_78789_a(-3.0F, 0.0F, 0.0F, 8, 8, 3);
/* 165 */     this.muleRightChest.func_78793_a(4.5F, 3.0F, 10.0F);
/* 166 */     setBoxRotation(this.muleRightChest, 0.0F, 1.5707964F, 0.0F);
/* 167 */     this.horseSaddleBottom = new ModelRenderer(this, 80, 0);
/* 168 */     this.horseSaddleBottom.func_78789_a(-5.0F, 0.0F, -3.0F, 10, 1, 8);
/* 169 */     this.horseSaddleBottom.func_78793_a(0.0F, 2.0F, 2.0F);
/* 170 */     this.horseSaddleFront = new ModelRenderer(this, 106, 9);
/* 171 */     this.horseSaddleFront.func_78789_a(-1.5F, -1.0F, -3.0F, 3, 1, 2);
/* 172 */     this.horseSaddleFront.func_78793_a(0.0F, 2.0F, 2.0F);
/* 173 */     this.horseSaddleBack = new ModelRenderer(this, 80, 9);
/* 174 */     this.horseSaddleBack.func_78789_a(-4.0F, -1.0F, 3.0F, 8, 1, 2);
/* 175 */     this.horseSaddleBack.func_78793_a(0.0F, 2.0F, 2.0F);
/* 176 */     this.horseLeftSaddleMetal = new ModelRenderer(this, 74, 0);
/* 177 */     this.horseLeftSaddleMetal.func_78789_a(-0.5F, 6.0F, -1.0F, 1, 2, 2);
/* 178 */     this.horseLeftSaddleMetal.func_78793_a(5.0F, 3.0F, 2.0F);
/* 179 */     this.horseLeftSaddleRope = new ModelRenderer(this, 70, 0);
/* 180 */     this.horseLeftSaddleRope.func_78789_a(-0.5F, 0.0F, -0.5F, 1, 6, 1);
/* 181 */     this.horseLeftSaddleRope.func_78793_a(5.0F, 3.0F, 2.0F);
/* 182 */     this.horseRightSaddleMetal = new ModelRenderer(this, 74, 4);
/* 183 */     this.horseRightSaddleMetal.func_78789_a(-0.5F, 6.0F, -1.0F, 1, 2, 2);
/* 184 */     this.horseRightSaddleMetal.func_78793_a(-5.0F, 3.0F, 2.0F);
/* 185 */     this.horseRightSaddleRope = new ModelRenderer(this, 80, 0);
/* 186 */     this.horseRightSaddleRope.func_78789_a(-0.5F, 0.0F, -0.5F, 1, 6, 1);
/* 187 */     this.horseRightSaddleRope.func_78793_a(-5.0F, 3.0F, 2.0F);
/* 188 */     this.horseLeftFaceMetal = new ModelRenderer(this, 74, 13);
/* 189 */     this.horseLeftFaceMetal.func_78789_a(1.5F, -8.0F, -4.0F, 1, 2, 2);
/* 190 */     this.horseLeftFaceMetal.func_78793_a(0.0F, 4.0F, -10.0F);
/* 191 */     setBoxRotation(this.horseLeftFaceMetal, 0.5235988F, 0.0F, 0.0F);
/* 192 */     this.horseRightFaceMetal = new ModelRenderer(this, 74, 13);
/* 193 */     this.horseRightFaceMetal.func_78789_a(-2.5F, -8.0F, -4.0F, 1, 2, 2);
/* 194 */     this.horseRightFaceMetal.func_78793_a(0.0F, 4.0F, -10.0F);
/* 195 */     setBoxRotation(this.horseRightFaceMetal, 0.5235988F, 0.0F, 0.0F);
/* 196 */     this.horseLeftRein = new ModelRenderer(this, 44, 10);
/* 197 */     this.horseLeftRein.func_78789_a(2.6F, -6.0F, -6.0F, 0, 3, 16);
/* 198 */     this.horseLeftRein.func_78793_a(0.0F, 4.0F, -10.0F);
/* 199 */     this.horseRightRein = new ModelRenderer(this, 44, 5);
/* 200 */     this.horseRightRein.func_78789_a(-2.6F, -6.0F, -6.0F, 0, 3, 16);
/* 201 */     this.horseRightRein.func_78793_a(0.0F, 4.0F, -10.0F);
/* 202 */     this.mane = new ModelRenderer(this, 58, 0);
/* 203 */     this.mane.func_78789_a(-1.0F, -11.5F, 5.0F, 2, 16, 4);
/* 204 */     this.mane.func_78793_a(0.0F, 4.0F, -10.0F);
/* 205 */     setBoxRotation(this.mane, 0.5235988F, 0.0F, 0.0F);
/* 206 */     this.horseFaceRopes = new ModelRenderer(this, 80, 12);
/* 207 */     this.horseFaceRopes.func_78790_a(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
/* 208 */     this.horseFaceRopes.func_78793_a(0.0F, 4.0F, -10.0F);
/* 209 */     setBoxRotation(this.horseFaceRopes, 0.5235988F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
/* 218 */     EntityHorseTFC entityhorse = (EntityHorseTFC)entity;
/* 219 */     int i = entityhorse.func_110265_bP();
/*     */     
/* 221 */     boolean flag = entityhorse.func_110228_bR();
/* 222 */     boolean flag1 = (flag && entityhorse.func_110257_ck());
/* 223 */     boolean flag2 = (flag && entityhorse.func_110261_ca());
/* 224 */     boolean flag3 = (i == 1 || i == 2);
/* 225 */     float f7 = entityhorse.func_110254_bY();
/* 226 */     boolean flag4 = (entityhorse.field_70153_n != null);
/*     */     
/* 228 */     if (flag1) {
/*     */       
/* 230 */       this.horseFaceRopes.func_78785_a(maxZ);
/* 231 */       this.horseSaddleBottom.func_78785_a(maxZ);
/* 232 */       this.horseSaddleFront.func_78785_a(maxZ);
/* 233 */       this.horseSaddleBack.func_78785_a(maxZ);
/* 234 */       this.horseLeftSaddleRope.func_78785_a(maxZ);
/* 235 */       this.horseLeftSaddleMetal.func_78785_a(maxZ);
/* 236 */       this.horseRightSaddleRope.func_78785_a(maxZ);
/* 237 */       this.horseRightSaddleMetal.func_78785_a(maxZ);
/* 238 */       this.horseLeftFaceMetal.func_78785_a(maxZ);
/* 239 */       this.horseRightFaceMetal.func_78785_a(maxZ);
/*     */       
/* 241 */       if (flag4) {
/*     */         
/* 243 */         this.horseLeftRein.func_78785_a(maxZ);
/* 244 */         this.horseRightRein.func_78785_a(maxZ);
/*     */       } 
/*     */     } 
/*     */     
/* 248 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/* 249 */     float ageScale = 2.0F - percent;
/* 250 */     float ageHeadScale = (float)Math.pow((1.0F / ageScale), 0.66D);
/*     */ 
/*     */     
/* 253 */     GL11.glPushMatrix();
/* 254 */     GL11.glTranslatef(0.0F, 0.3F - 0.3F * percent, 0.0F);
/* 255 */     GL11.glPushMatrix();
/* 256 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale + 0.25F * (1.0F - percent), 1.0F / ageScale);
/* 257 */     GL11.glTranslatef(0.0F, 0.95F * (1.0F - f7) * (1.0F - percent), 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     this.backLeftLeg.func_78785_a(maxZ);
/* 267 */     this.backLeftShin.func_78785_a(maxZ);
/* 268 */     this.backLeftHoof.func_78785_a(maxZ);
/* 269 */     this.backRightLeg.func_78785_a(maxZ);
/* 270 */     this.backRightShin.func_78785_a(maxZ);
/* 271 */     this.backRightHoof.func_78785_a(maxZ);
/* 272 */     this.frontLeftLeg.func_78785_a(maxZ);
/* 273 */     this.frontLeftShin.func_78785_a(maxZ);
/* 274 */     this.frontLeftHoof.func_78785_a(maxZ);
/* 275 */     this.frontRightLeg.func_78785_a(maxZ);
/* 276 */     this.frontRightShin.func_78785_a(maxZ);
/* 277 */     this.frontRightHoof.func_78785_a(maxZ);
/* 278 */     GL11.glPopMatrix();
/* 279 */     GL11.glPushMatrix();
/* 280 */     GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/* 281 */     GL11.glTranslatef(0.0F, 1.35F * (1.0F - f7) * (1.0F - percent), 0.0F);
/*     */ 
/*     */     
/* 284 */     this.body.func_78785_a(maxZ);
/* 285 */     this.tailBase.func_78785_a(maxZ);
/* 286 */     this.tailMiddle.func_78785_a(maxZ);
/* 287 */     this.tailTip.func_78785_a(maxZ);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     this.neck.func_78785_a(maxZ);
/* 296 */     this.mane.func_78785_a(maxZ);
/*     */     
/* 298 */     GL11.glPopMatrix();
/*     */     
/* 300 */     GL11.glPushMatrix();
/*     */ 
/*     */     
/* 303 */     GL11.glScalef(ageHeadScale, ageHeadScale, ageHeadScale);
/* 304 */     GL11.glTranslatef(0.0F, 0.0F, 0.1875F - 0.1875F * percent);
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
/* 323 */     if (flag3) {
/*     */       
/* 325 */       this.muleLeftEar.func_78785_a(maxZ);
/* 326 */       this.muleRightEar.func_78785_a(maxZ);
/*     */     }
/*     */     else {
/*     */       
/* 330 */       this.horseLeftEar.func_78785_a(maxZ);
/* 331 */       this.horseRightEar.func_78785_a(maxZ);
/*     */     } 
/*     */     
/* 334 */     this.head.func_78785_a(maxZ);
/*     */     
/* 336 */     if (flag2) {
/*     */       
/* 338 */       this.muleLeftChest.func_78785_a(maxZ);
/* 339 */       this.muleRightChest.func_78785_a(maxZ);
/*     */     } 
/* 341 */     GL11.glPopMatrix();
/* 342 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setBoxRotation(ModelRenderer renderer, float xAngle, float yAngle, float zAngle) {
/* 350 */     renderer.field_78795_f = xAngle;
/* 351 */     renderer.field_78796_g = yAngle;
/* 352 */     renderer.field_78808_h = zAngle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float updateHorseRotation(float xOffset, float yOffset, float zOffset) {
/*     */     float f3;
/* 362 */     for (f3 = yOffset - xOffset; f3 < -180.0F; f3 += 360.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 367 */     while (f3 >= 180.0F)
/*     */     {
/* 369 */       f3 -= 360.0F;
/*     */     }
/*     */     
/* 372 */     return xOffset + zOffset * f3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase entity, float x, float y, float z) {
/* 382 */     super.func_78086_a(entity, x, y, z);
/* 383 */     float f3 = updateHorseRotation(entity.field_70760_ar, entity.field_70761_aq, z);
/* 384 */     float f4 = updateHorseRotation(entity.field_70758_at, entity.field_70759_as, z);
/* 385 */     float f5 = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * z;
/* 386 */     float f6 = f4 - f3;
/* 387 */     float f7 = f5 / 57.295776F;
/*     */     
/* 389 */     if (f6 > 20.0F)
/*     */     {
/* 391 */       f6 = 20.0F;
/*     */     }
/*     */     
/* 394 */     if (f6 < -20.0F)
/*     */     {
/* 396 */       f6 = -20.0F;
/*     */     }
/*     */     
/* 399 */     if (y > 0.2F)
/*     */     {
/* 401 */       f7 += MathHelper.func_76134_b(x * 0.4F) * 0.15F * y;
/*     */     }
/*     */     
/* 404 */     EntityHorseTFC entityhorse = (EntityHorseTFC)entity;
/* 405 */     float f8 = entityhorse.func_110258_o(z);
/* 406 */     float f9 = entityhorse.func_110223_p(z);
/* 407 */     float f10 = 1.0F - f9;
/* 408 */     float f11 = entityhorse.func_110201_q(z);
/* 409 */     boolean flag = (entityhorse.field_110278_bp != 0);
/* 410 */     boolean flag1 = entityhorse.func_110257_ck();
/* 411 */     boolean flag2 = (entityhorse.field_70153_n != null);
/* 412 */     float f12 = entity.field_70173_aa + z;
/* 413 */     float f13 = MathHelper.func_76134_b(x * 0.6662F + 3.1415927F);
/* 414 */     float f14 = f13 * 0.8F * y;
/* 415 */     this.head.field_78797_d = 4.0F;
/* 416 */     this.head.field_78798_e = -10.0F;
/* 417 */     this.tailBase.field_78797_d = 3.0F;
/* 418 */     this.tailMiddle.field_78798_e = 14.0F;
/* 419 */     this.muleRightChest.field_78797_d = 3.0F;
/* 420 */     this.muleRightChest.field_78798_e = 10.0F;
/* 421 */     this.body.field_78795_f = 0.0F;
/* 422 */     this.head.field_78795_f = 0.5235988F + f7;
/* 423 */     this.head.field_78796_g = f6 / 57.295776F;
/* 424 */     this.head.field_78795_f = f9 * (0.2617994F + f7) + f8 * 2.18166F + (1.0F - Math.max(f9, f8)) * this.head.field_78795_f;
/* 425 */     this.head.field_78796_g = f9 * f6 / 57.295776F + (1.0F - Math.max(f9, f8)) * this.head.field_78796_g;
/* 426 */     this.head.field_78797_d = f9 * -6.0F + f8 * 11.0F + (1.0F - Math.max(f9, f8)) * this.head.field_78797_d;
/* 427 */     this.head.field_78798_e = f9 * -1.0F + f8 * -10.0F + (1.0F - Math.max(f9, f8)) * this.head.field_78798_e;
/* 428 */     this.tailBase.field_78797_d = f9 * 9.0F + f10 * this.tailBase.field_78797_d;
/* 429 */     this.tailMiddle.field_78798_e = f9 * 18.0F + f10 * this.tailMiddle.field_78798_e;
/* 430 */     this.muleRightChest.field_78797_d = f9 * 5.5F + f10 * this.muleRightChest.field_78797_d;
/* 431 */     this.muleRightChest.field_78798_e = f9 * 15.0F + f10 * this.muleRightChest.field_78798_e;
/* 432 */     this.body.field_78795_f = f9 * -0.7853982F + f10 * this.body.field_78795_f;
/* 433 */     this.horseLeftEar.field_78797_d = this.head.field_78797_d;
/* 434 */     this.horseRightEar.field_78797_d = this.head.field_78797_d;
/* 435 */     this.muleLeftEar.field_78797_d = this.head.field_78797_d;
/* 436 */     this.muleRightEar.field_78797_d = this.head.field_78797_d;
/* 437 */     this.neck.field_78797_d = this.head.field_78797_d;
/* 438 */     this.mouthTop.field_78797_d = 0.02F;
/* 439 */     this.mouthBottom.field_78797_d = 0.0F;
/* 440 */     this.mane.field_78797_d = this.head.field_78797_d;
/* 441 */     this.horseLeftEar.field_78798_e = this.head.field_78798_e;
/* 442 */     this.horseRightEar.field_78798_e = this.head.field_78798_e;
/* 443 */     this.muleLeftEar.field_78798_e = this.head.field_78798_e;
/* 444 */     this.muleRightEar.field_78798_e = this.head.field_78798_e;
/* 445 */     this.neck.field_78798_e = this.head.field_78798_e;
/* 446 */     this.mouthTop.field_78798_e = 0.02F - f11 * 1.0F;
/* 447 */     this.mouthBottom.field_78798_e = 0.0F + f11 * 1.0F;
/* 448 */     this.mane.field_78798_e = this.head.field_78798_e;
/* 449 */     this.horseLeftEar.field_78795_f = this.head.field_78795_f;
/* 450 */     this.horseRightEar.field_78795_f = this.head.field_78795_f;
/* 451 */     this.muleLeftEar.field_78795_f = this.head.field_78795_f;
/* 452 */     this.muleRightEar.field_78795_f = this.head.field_78795_f;
/* 453 */     this.neck.field_78795_f = this.head.field_78795_f;
/* 454 */     this.mouthTop.field_78795_f = 0.0F - 0.09424778F * f11;
/* 455 */     this.mouthBottom.field_78795_f = 0.0F + 0.15707964F * f11;
/* 456 */     this.mane.field_78795_f = this.head.field_78795_f;
/* 457 */     this.horseLeftEar.field_78796_g = this.head.field_78796_g;
/* 458 */     this.horseRightEar.field_78796_g = this.head.field_78796_g;
/* 459 */     this.muleLeftEar.field_78796_g = this.head.field_78796_g;
/* 460 */     this.muleRightEar.field_78796_g = this.head.field_78796_g;
/* 461 */     this.neck.field_78796_g = this.head.field_78796_g;
/* 462 */     this.mouthTop.field_78796_g = 0.0F;
/* 463 */     this.mouthBottom.field_78796_g = 0.0F;
/* 464 */     this.mane.field_78796_g = this.head.field_78796_g;
/* 465 */     this.muleLeftChest.field_78795_f = f14 / 5.0F;
/* 466 */     this.muleRightChest.field_78795_f = -f14 / 5.0F;
/* 467 */     float f15 = 1.5707964F;
/*     */ 
/*     */     
/* 470 */     float f18 = 0.2617994F * f9;
/* 471 */     float f19 = MathHelper.func_76134_b(f12 * 0.6F + 3.1415927F);
/* 472 */     this.frontLeftLeg.field_78797_d = -2.0F * f9 + 9.0F * f10;
/* 473 */     this.frontLeftLeg.field_78798_e = -2.0F * f9 + -8.0F * f10;
/* 474 */     this.frontRightLeg.field_78797_d = this.frontLeftLeg.field_78797_d;
/* 475 */     this.frontRightLeg.field_78798_e = this.frontLeftLeg.field_78798_e;
/* 476 */     this.backLeftLeg.field_78797_d += MathHelper.func_76126_a(1.5707964F + f18 + f10 * -f13 * 0.5F * y) * 7.0F;
/* 477 */     this.backLeftLeg.field_78798_e += MathHelper.func_76134_b(4.712389F + f18 + f10 * -f13 * 0.5F * y) * 7.0F;
/* 478 */     this.backRightLeg.field_78797_d += MathHelper.func_76126_a(1.5707964F + f18 + f10 * f13 * 0.5F * y) * 7.0F;
/* 479 */     this.backRightLeg.field_78798_e += MathHelper.func_76134_b(4.712389F + f18 + f10 * f13 * 0.5F * y) * 7.0F;
/* 480 */     float f20 = (-1.0471976F + f19) * f9 + f14 * f10;
/* 481 */     float f21 = (-1.0471976F + -f19) * f9 + -f14 * f10;
/* 482 */     this.frontLeftLeg.field_78797_d += MathHelper.func_76126_a(1.5707964F + f20) * 7.0F;
/* 483 */     this.frontLeftLeg.field_78798_e += MathHelper.func_76134_b(4.712389F + f20) * 7.0F;
/* 484 */     this.frontRightLeg.field_78797_d += MathHelper.func_76126_a(1.5707964F + f21) * 7.0F;
/* 485 */     this.frontRightLeg.field_78798_e += MathHelper.func_76134_b(4.712389F + f21) * 7.0F;
/* 486 */     this.backLeftLeg.field_78795_f = f18 + -f13 * 0.5F * y * f10;
/* 487 */     this.backLeftShin.field_78795_f = -0.08726646F * f9 + (-f13 * 0.5F * y - Math.max(0.0F, f13 * 0.5F * y)) * f10;
/* 488 */     this.backLeftHoof.field_78795_f = this.backLeftShin.field_78795_f;
/* 489 */     this.backRightLeg.field_78795_f = f18 + f13 * 0.5F * y * f10;
/* 490 */     this.backRightShin.field_78795_f = -0.08726646F * f9 + (f13 * 0.5F * y - Math.max(0.0F, -f13 * 0.5F * y)) * f10;
/* 491 */     this.backRightHoof.field_78795_f = this.backRightShin.field_78795_f;
/* 492 */     this.frontLeftLeg.field_78795_f = f20;
/* 493 */     this.frontLeftShin.field_78795_f = (this.frontLeftLeg.field_78795_f + 3.1415927F * Math.max(0.0F, 0.2F + f19 * 0.2F)) * f9 + (f14 + Math.max(0.0F, f13 * 0.5F * y)) * f10;
/* 494 */     this.frontLeftHoof.field_78795_f = this.frontLeftShin.field_78795_f;
/* 495 */     this.frontRightLeg.field_78795_f = f21;
/* 496 */     this.frontRightShin.field_78795_f = (this.frontRightLeg.field_78795_f + 3.1415927F * Math.max(0.0F, 0.2F - f19 * 0.2F)) * f9 + (-f14 + Math.max(0.0F, -f13 * 0.5F * y)) * f10;
/* 497 */     this.frontRightHoof.field_78795_f = this.frontRightShin.field_78795_f;
/* 498 */     this.backLeftHoof.field_78797_d = this.backLeftShin.field_78797_d;
/* 499 */     this.backLeftHoof.field_78798_e = this.backLeftShin.field_78798_e;
/* 500 */     this.backRightHoof.field_78797_d = this.backRightShin.field_78797_d;
/* 501 */     this.backRightHoof.field_78798_e = this.backRightShin.field_78798_e;
/* 502 */     this.frontLeftHoof.field_78797_d = this.frontLeftShin.field_78797_d;
/* 503 */     this.frontLeftHoof.field_78798_e = this.frontLeftShin.field_78798_e;
/* 504 */     this.frontRightHoof.field_78797_d = this.frontRightShin.field_78797_d;
/* 505 */     this.frontRightHoof.field_78798_e = this.frontRightShin.field_78798_e;
/*     */     
/* 507 */     if (flag1) {
/*     */       
/* 509 */       this.horseSaddleBottom.field_78797_d = f9 * 0.5F + f10 * 2.0F;
/* 510 */       this.horseSaddleBottom.field_78798_e = f9 * 11.0F + f10 * 2.0F;
/* 511 */       this.horseSaddleFront.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 512 */       this.horseSaddleBack.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 513 */       this.horseLeftSaddleRope.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 514 */       this.horseRightSaddleRope.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 515 */       this.horseLeftSaddleMetal.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 516 */       this.horseRightSaddleMetal.field_78797_d = this.horseSaddleBottom.field_78797_d;
/* 517 */       this.muleLeftChest.field_78797_d = this.muleRightChest.field_78797_d;
/* 518 */       this.horseSaddleFront.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 519 */       this.horseSaddleBack.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 520 */       this.horseLeftSaddleRope.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 521 */       this.horseRightSaddleRope.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 522 */       this.horseLeftSaddleMetal.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 523 */       this.horseRightSaddleMetal.field_78798_e = this.horseSaddleBottom.field_78798_e;
/* 524 */       this.muleLeftChest.field_78798_e = this.muleRightChest.field_78798_e;
/* 525 */       this.horseSaddleBottom.field_78795_f = this.body.field_78795_f;
/* 526 */       this.horseSaddleFront.field_78795_f = this.body.field_78795_f;
/* 527 */       this.horseSaddleBack.field_78795_f = this.body.field_78795_f;
/* 528 */       this.horseLeftRein.field_78797_d = this.head.field_78797_d;
/* 529 */       this.horseRightRein.field_78797_d = this.head.field_78797_d;
/* 530 */       this.horseFaceRopes.field_78797_d = this.head.field_78797_d;
/* 531 */       this.horseLeftFaceMetal.field_78797_d = this.head.field_78797_d;
/* 532 */       this.horseRightFaceMetal.field_78797_d = this.head.field_78797_d;
/* 533 */       this.horseLeftRein.field_78798_e = this.head.field_78798_e;
/* 534 */       this.horseRightRein.field_78798_e = this.head.field_78798_e;
/* 535 */       this.horseFaceRopes.field_78798_e = this.head.field_78798_e;
/* 536 */       this.horseLeftFaceMetal.field_78798_e = this.head.field_78798_e;
/* 537 */       this.horseRightFaceMetal.field_78798_e = this.head.field_78798_e;
/* 538 */       this.horseLeftRein.field_78795_f = f7;
/* 539 */       this.horseRightRein.field_78795_f = f7;
/* 540 */       this.horseFaceRopes.field_78795_f = this.head.field_78795_f;
/* 541 */       this.horseLeftFaceMetal.field_78795_f = this.head.field_78795_f;
/* 542 */       this.horseRightFaceMetal.field_78795_f = this.head.field_78795_f;
/* 543 */       this.horseFaceRopes.field_78796_g = this.head.field_78796_g;
/* 544 */       this.horseLeftFaceMetal.field_78796_g = this.head.field_78796_g;
/* 545 */       this.horseLeftRein.field_78796_g = this.head.field_78796_g;
/* 546 */       this.horseRightFaceMetal.field_78796_g = this.head.field_78796_g;
/* 547 */       this.horseRightRein.field_78796_g = this.head.field_78796_g;
/*     */       
/* 549 */       if (flag2) {
/*     */         
/* 551 */         this.horseLeftSaddleRope.field_78795_f = -1.0471976F;
/* 552 */         this.horseLeftSaddleMetal.field_78795_f = -1.0471976F;
/* 553 */         this.horseRightSaddleRope.field_78795_f = -1.0471976F;
/* 554 */         this.horseRightSaddleMetal.field_78795_f = -1.0471976F;
/* 555 */         this.horseLeftSaddleRope.field_78808_h = 0.0F;
/* 556 */         this.horseLeftSaddleMetal.field_78808_h = 0.0F;
/* 557 */         this.horseRightSaddleRope.field_78808_h = 0.0F;
/* 558 */         this.horseRightSaddleMetal.field_78808_h = 0.0F;
/*     */       }
/*     */       else {
/*     */         
/* 562 */         this.horseLeftSaddleRope.field_78795_f = f14 / 3.0F;
/* 563 */         this.horseLeftSaddleMetal.field_78795_f = f14 / 3.0F;
/* 564 */         this.horseRightSaddleRope.field_78795_f = f14 / 3.0F;
/* 565 */         this.horseRightSaddleMetal.field_78795_f = f14 / 3.0F;
/* 566 */         this.horseLeftSaddleRope.field_78808_h = f14 / 5.0F;
/* 567 */         this.horseLeftSaddleMetal.field_78808_h = f14 / 5.0F;
/* 568 */         this.horseRightSaddleRope.field_78808_h = -f14 / 5.0F;
/* 569 */         this.horseRightSaddleMetal.field_78808_h = -f14 / 5.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 573 */     f15 = -1.3089F + y * 1.5F;
/*     */     
/* 575 */     if (f15 > 0.0F)
/*     */     {
/* 577 */       f15 = 0.0F;
/*     */     }
/*     */     
/* 580 */     if (flag) {
/*     */       
/* 582 */       this.tailBase.field_78796_g = MathHelper.func_76134_b(f12 * 0.7F);
/* 583 */       f15 = 0.0F;
/*     */     }
/*     */     else {
/*     */       
/* 587 */       this.tailBase.field_78796_g = 0.0F;
/*     */     } 
/*     */     
/* 590 */     this.tailMiddle.field_78796_g = this.tailBase.field_78796_g;
/* 591 */     this.tailTip.field_78796_g = this.tailBase.field_78796_g;
/* 592 */     this.tailMiddle.field_78797_d = this.tailBase.field_78797_d;
/* 593 */     this.tailTip.field_78797_d = this.tailBase.field_78797_d;
/* 594 */     this.tailMiddle.field_78798_e = this.tailBase.field_78798_e;
/* 595 */     this.tailTip.field_78798_e = this.tailBase.field_78798_e;
/* 596 */     this.tailBase.field_78795_f = f15;
/* 597 */     this.tailMiddle.field_78795_f = f15;
/* 598 */     this.tailTip.field_78795_f = -0.2618F + f15;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelHorseTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */