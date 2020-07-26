/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityDeer;
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
/*     */ public class ModelDeer
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer antler24;
/*     */   private ModelRenderer antler23;
/*     */   private ModelRenderer antler22;
/*     */   private ModelRenderer antler21;
/*     */   private ModelRenderer antler14;
/*     */   private ModelRenderer antler13;
/*     */   private ModelRenderer antler12;
/*     */   private ModelRenderer antler11;
/*     */   private ModelRenderer hoof2;
/*     */   private ModelRenderer toes3;
/*     */   private ModelRenderer thigh1;
/*     */   private ModelRenderer ear2;
/*     */   private ModelRenderer ear1;
/*     */   private ModelRenderer calf2;
/*     */   private ModelRenderer tail;
/*     */   private ModelRenderer collar;
/*     */   private ModelRenderer upperLeg4;
/*     */   private ModelRenderer neck;
/*     */   private ModelRenderer rump;
/*     */   private ModelRenderer head;
/*     */   private ModelRenderer body;
/*     */   private ModelRenderer leg1;
/*     */   private ModelRenderer leg2;
/*     */   private ModelRenderer leg3;
/*     */   private ModelRenderer leg4;
/*     */   private ModelRenderer snout;
/*     */   private ModelRenderer torso;
/*     */   private ModelRenderer upperLeg3;
/*     */   private ModelRenderer calf1;
/*     */   private ModelRenderer lowerleg3;
/*     */   private ModelRenderer lowerleg4;
/*     */   private ModelRenderer thigh2;
/*     */   private ModelRenderer toes4;
/*     */   private ModelRenderer toes2;
/*     */   private ModelRenderer toes1;
/*     */   private ModelRenderer hoof1;
/*     */   private ModelRenderer hoof3;
/*     */   private ModelRenderer hoof4;
/*     */   private boolean running;
/*     */   
/*     */   public ModelDeer() {
/*  64 */     this.field_78090_t = 128;
/*  65 */     this.field_78089_u = 64;
/*     */     
/*  67 */     this.antler24 = new ModelRenderer(this, 44, 0);
/*  68 */     this.antler24.func_78789_a(-6.8F, -15.4F, -1.8F, 1, 2, 1);
/*  69 */     this.antler24.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.antler24.func_78787_b(128, 64);
/*  71 */     this.antler24.field_78809_i = true;
/*  72 */     setRotation(this.antler24, 0.0F, 0.0F, 0.2792527F);
/*  73 */     this.antler23 = new ModelRenderer(this, 44, 0);
/*  74 */     this.antler23.func_78789_a(-2.8F, -11.0F, 8.0F, 1, 2, 1);
/*     */     
/*  76 */     this.antler23.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.antler23.func_78787_b(128, 64);
/*  78 */     this.antler23.field_78809_i = true;
/*  79 */     setRotation(this.antler23, 0.8726646F, -0.4363323F, 0.0F);
/*  80 */     this.antler22 = new ModelRenderer(this, 44, 0);
/*  81 */     this.antler22.func_78789_a(2.3F, -14.3F, -5.1F, 1, 3, 1);
/*  82 */     this.antler22.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.antler22.func_78787_b(128, 64);
/*  84 */     this.antler22.field_78809_i = true;
/*  85 */     setRotation(this.antler22, -0.2268928F, 0.0F, -0.3490659F);
/*  86 */     this.antler21 = new ModelRenderer(this, 44, 0);
/*  87 */     this.antler21.func_78789_a(-2.0F, -13.0F, -2.5F, 1, 3, 1);
/*  88 */     this.antler21.func_78793_a(0.0F, -1.0F, -8.0F);
/*  89 */     this.antler21.func_78787_b(128, 64);
/*  90 */     this.antler21.field_78809_i = true;
/*  91 */     setRotation(this.antler21, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.antler14 = new ModelRenderer(this, 44, 0);
/*  96 */     this.antler14.func_78789_a(5.8F, -15.4F, -1.8F, 1, 2, 1);
/*  97 */     this.antler14.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.antler14.func_78787_b(128, 64);
/*  99 */     this.antler14.field_78809_i = true;
/* 100 */     setRotation(this.antler14, 0.0F, 0.0F, -0.2792527F);
/* 101 */     this.antler13 = new ModelRenderer(this, 44, 0);
/* 102 */     this.antler13.func_78789_a(1.8F, -11.0F, 8.0F, 1, 2, 1);
/* 103 */     this.antler13.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.antler13.func_78787_b(128, 64);
/* 105 */     this.antler13.field_78809_i = true;
/* 106 */     setRotation(this.antler13, 0.8726646F, 0.4363323F, 0.0F);
/* 107 */     this.antler12 = new ModelRenderer(this, 44, 0);
/* 108 */     this.antler12.func_78789_a(-3.3F, -14.3F, -5.1F, 1, 3, 1);
/* 109 */     this.antler12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.antler12.func_78787_b(128, 64);
/* 111 */     this.antler12.field_78809_i = true;
/* 112 */     setRotation(this.antler12, -0.2268928F, 0.0F, 0.3490659F);
/* 113 */     this.antler11 = new ModelRenderer(this, 44, 0);
/* 114 */     this.antler11.func_78789_a(1.0F, -13.0F, -2.5F, 1, 3, 1);
/* 115 */     this.antler11.func_78793_a(0.0F, -1.0F, -8.0F);
/* 116 */     this.antler11.func_78787_b(128, 64);
/* 117 */     this.antler11.field_78809_i = true;
/* 118 */     setRotation(this.antler11, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     this.toes3 = new ModelRenderer(this, 18, 22);
/* 124 */     this.toes3.func_78789_a(-0.5F, 0.4F, -3.0F, 2, 1, 4);
/* 125 */     this.toes3.func_78793_a(0.0F, 5.0F, 0.0F);
/* 126 */     this.toes3.func_78787_b(128, 64);
/* 127 */     setRotation(this.toes3, 1.134464F, 0.0F, 0.0F);
/* 128 */     this.thigh1 = new ModelRenderer(this, 40, 22);
/* 129 */     this.thigh1.func_78789_a(-1.0F, -2.3F, -2.0F, 2, 9, 5);
/* 130 */     this.thigh1.func_78793_a(-3.0F, 2.0F, 7.0F);
/* 131 */     this.thigh1.func_78787_b(128, 64);
/* 132 */     setRotation(this.thigh1, -0.1745329F, 0.0F, 0.1745329F);
/*     */     
/* 134 */     this.ear2 = new ModelRenderer(this, 54, 16);
/* 135 */     this.ear2.field_78809_i = true;
/* 136 */     this.ear2.func_78789_a(-9.0F, -10.0F, -2.0F, 5, 3, 0);
/* 137 */     this.ear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 138 */     this.ear2.func_78787_b(128, 64);
/* 139 */     setRotation(this.ear2, 0.0F, 0.3490659F, 0.34906584F);
/* 140 */     this.ear1 = new ModelRenderer(this, 54, 16);
/* 141 */     this.ear1.func_78789_a(4.0F, -10.0F, -2.0F, 5, 3, 0);
/* 142 */     this.ear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 143 */     this.ear1.func_78787_b(128, 64);
/* 144 */     setRotation(this.ear1, 0.0F, -0.3490659F, -0.34906584F);
/*     */     
/* 146 */     this.calf2 = new ModelRenderer(this, 54, 7);
/* 147 */     this.calf2.field_78809_i = true;
/* 148 */     this.calf2.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 6, 3);
/* 149 */     this.calf2.func_78793_a(0.0F, 6.0F, 0.0F);
/* 150 */     this.calf2.func_78787_b(128, 64);
/* 151 */     setRotation(this.calf2, 0.5585054F, 0.0F, 0.0F);
/* 152 */     this.tail = new ModelRenderer(this, 24, 52);
/* 153 */     this.tail.func_78789_a(-1.5F, -0.5F, 0.0F, 3, 2, 9);
/* 154 */     this.tail.func_78793_a(0.0F, -1.5F, 10.0F);
/* 155 */     this.tail.func_78787_b(128, 64);
/* 156 */     this.tail.field_78809_i = true;
/* 157 */     setRotation(this.tail, -1.308997F, 0.0F, 0.0F);
/* 158 */     this.collar = new ModelRenderer(this, 30, 38);
/* 159 */     this.collar.func_78789_a(0.0F, -2.0F, -4.0F, 4, 6, 7);
/* 160 */     this.collar.func_78793_a(-2.0F, -1.0F, -8.0F);
/* 161 */     this.collar.func_78787_b(128, 64);
/* 162 */     this.collar.field_78809_i = true;
/* 163 */     setRotation(this.collar, 1.151917F, 0.0F, 0.0F);
/*     */     
/* 165 */     this.upperLeg4 = new ModelRenderer(this, 30, 22);
/* 166 */     this.upperLeg4.field_78809_i = true;
/* 167 */     this.upperLeg4.func_78789_a(-1.25F, -1.0F, -1.5F, 2, 5, 3);
/* 168 */     this.upperLeg4.func_78793_a(4.0F, 5.0F, -7.0F);
/* 169 */     this.upperLeg4.func_78787_b(128, 64);
/*     */     
/* 171 */     setRotation(this.upperLeg4, 0.3490659F, 0.0F, 0.0349066F);
/* 172 */     this.neck = new ModelRenderer(this, 57, 22);
/* 173 */     this.neck.func_78789_a(-2.0F, -4.0F, -2.0F, 4, 5, 8);
/* 174 */     this.neck.func_78793_a(0.0F, -1.0F, -8.0F);
/* 175 */     this.neck.func_78787_b(128, 64);
/* 176 */     this.neck.field_78809_i = true;
/* 177 */     setRotation(this.neck, 1.815142F, 0.0F, 0.0F);
/* 178 */     this.rump = new ModelRenderer(this, 0, 47);
/* 179 */     this.rump.func_78789_a(-3.0F, -4.0F, 3.0F, 6, 10, 6);
/* 180 */     this.rump.func_78793_a(0.0F, 1.5F, 1.0F);
/* 181 */     this.rump.func_78787_b(128, 64);
/* 182 */     this.rump.field_78809_i = true;
/* 183 */     setRotation(this.rump, -0.0872665F, 0.0F, 0.0F);
/* 184 */     this.head = new ModelRenderer(this, 54, 35);
/* 185 */     this.head.func_78789_a(-2.5F, -11.0F, -5.0F, 5, 6, 6);
/* 186 */     this.head.func_78793_a(0.0F, -1.0F, -8.0F);
/* 187 */     this.head.func_78787_b(128, 64);
/* 188 */     this.head.field_78809_i = true;
/* 189 */     setRotation(this.head, 0.1570796F, 0.0F, 0.0F);
/* 190 */     this.head.func_78792_a(this.ear1);
/* 191 */     this.head.func_78792_a(this.ear2);
/* 192 */     this.body = new ModelRenderer(this, 18, 4);
/* 193 */     this.body.func_78789_a(-4.0F, -11.0F, -8.0F, 8, 8, 10);
/* 194 */     this.body.func_78793_a(0.0F, 1.0F, 2.0F);
/* 195 */     this.body.func_78787_b(128, 64);
/* 196 */     this.body.field_78809_i = true;
/* 197 */     setRotation(this.body, 1.43117F, 0.0F, 0.0F);
/* 198 */     this.leg1 = new ModelRenderer(this, 0, 16);
/* 199 */     this.leg1.func_78789_a(-0.0F, -1.0F, 0.0F, 2, 9, 2);
/* 200 */     this.leg1.func_78793_a(0.0F, 5.0F, 0.0F);
/* 201 */     this.leg1.func_78787_b(128, 64);
/* 202 */     setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
/*     */     
/* 204 */     this.leg2 = new ModelRenderer(this, 0, 16);
/* 205 */     this.leg2.field_78809_i = true;
/* 206 */     this.leg2.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 9, 2);
/* 207 */     this.leg2.func_78793_a(0.0F, 5.0F, 0.0F);
/* 208 */     this.leg2.func_78787_b(128, 64);
/*     */     
/* 210 */     setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
/* 211 */     this.leg3 = new ModelRenderer(this, 8, 16);
/* 212 */     this.leg3.func_78789_a(-0.5F, 0.0F, 0.0F, 2, 7, 2);
/* 213 */     this.leg3.func_78793_a(0.0F, 3.0F, -1.0F);
/* 214 */     this.leg3.func_78787_b(128, 64);
/* 215 */     setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
/*     */     
/* 217 */     this.leg4 = new ModelRenderer(this, 8, 16);
/* 218 */     this.leg4.field_78809_i = true;
/* 219 */     this.leg4.func_78789_a(-1.5F, 0.0F, 0.0F, 2, 7, 2);
/* 220 */     this.leg4.func_78793_a(0.0F, 3.0F, -1.0F);
/* 221 */     this.leg4.func_78787_b(128, 64);
/*     */     
/* 223 */     setRotation(this.leg4, -0.3490659F, 0.0F, -0.0349066F);
/* 224 */     this.snout = new ModelRenderer(this, 54, 0);
/* 225 */     this.snout.func_78789_a(-1.5F, -9.3F, -9.0F, 3, 3, 4);
/* 226 */     this.snout.func_78793_a(0.0F, 0.0F, 0.0F);
/* 227 */     this.snout.func_78787_b(128, 64);
/* 228 */     this.snout.field_78809_i = true;
/*     */     
/* 230 */     this.head.func_78792_a(this.snout);
/* 231 */     this.torso = new ModelRenderer(this, 0, 29);
/* 232 */     this.torso.func_78789_a(-3.5F, -3.0F, -5.0F, 7, 10, 8);
/* 233 */     this.torso.func_78793_a(0.0F, 1.0F, 2.0F);
/* 234 */     this.torso.func_78787_b(128, 64);
/* 235 */     this.torso.field_78809_i = true;
/* 236 */     setRotation(this.torso, 0.122173F, 0.0F, 0.0F);
/* 237 */     this.upperLeg3 = new ModelRenderer(this, 30, 22);
/* 238 */     this.upperLeg3.func_78789_a(-0.7F, -1.0F, -1.5F, 2, 5, 3);
/* 239 */     this.upperLeg3.func_78793_a(-4.0F, 5.0F, -7.0F);
/* 240 */     this.upperLeg3.func_78787_b(128, 64);
/* 241 */     setRotation(this.upperLeg3, 0.3490659F, 0.0F, -0.0349066F);
/* 242 */     this.calf1 = new ModelRenderer(this, 54, 7);
/* 243 */     this.calf1.func_78789_a(0.0F, -1.0F, 0.0F, 2, 6, 3);
/* 244 */     this.calf1.func_78793_a(0.0F, 7.0F, 0.0F);
/* 245 */     this.calf1.func_78787_b(128, 64);
/* 246 */     setRotation(this.calf1, 0.5585054F, 0.0F, 0.0F);
/* 247 */     this.lowerleg3 = new ModelRenderer(this, 30, 30);
/* 248 */     this.lowerleg3.func_78789_a(-0.5F, 0.0F, 0.0F, 2, 6, 2);
/* 249 */     this.lowerleg3.func_78793_a(0.0F, 7.0F, 0.0F);
/* 250 */     this.lowerleg3.func_78787_b(128, 64);
/* 251 */     setRotation(this.lowerleg3, 0.0F, 0.0F, 0.0F);
/*     */     
/* 253 */     this.lowerleg4 = new ModelRenderer(this, 30, 30);
/* 254 */     this.lowerleg4.field_78809_i = true;
/* 255 */     this.lowerleg4.func_78789_a(-1.5F, 0.0F, 0.0F, 2, 6, 2);
/* 256 */     this.lowerleg4.func_78793_a(0.0F, 7.0F, 0.0F);
/* 257 */     this.lowerleg4.func_78787_b(128, 64);
/*     */     
/* 259 */     setRotation(this.lowerleg4, 0.0F, 0.0F, 0.0F);
/*     */     
/* 261 */     this.thigh2 = new ModelRenderer(this, 40, 22);
/* 262 */     this.thigh2.field_78809_i = true;
/* 263 */     this.thigh2.func_78789_a(-1.0F, -2.3F, -2.0F, 2, 9, 5);
/* 264 */     this.thigh2.func_78793_a(3.0F, 2.0F, 7.0F);
/* 265 */     this.thigh2.func_78787_b(128, 64);
/*     */     
/* 267 */     setRotation(this.thigh2, -0.1745329F, 0.0F, -0.1745329F);
/*     */     
/* 269 */     this.toes4 = new ModelRenderer(this, 18, 22);
/* 270 */     this.toes4.field_78809_i = true;
/* 271 */     this.toes4.func_78789_a(-1.5F, 0.4F, -3.0F, 2, 1, 4);
/* 272 */     this.toes4.func_78793_a(0.0F, 5.0F, 0.0F);
/* 273 */     this.toes4.func_78787_b(128, 64);
/*     */     
/* 275 */     setRotation(this.toes4, 1.134464F, 0.0F, 0.0F);
/*     */     
/* 277 */     this.toes2 = new ModelRenderer(this, 18, 22);
/* 278 */     this.toes2.field_78809_i = true;
/* 279 */     this.toes2.func_78789_a(-1.0F, 0.4F, -3.0F, 2, 1, 4);
/* 280 */     this.toes2.func_78793_a(0.0F, 8.0F, 0.0F);
/* 281 */     this.toes2.func_78787_b(128, 64);
/*     */     
/* 283 */     setRotation(this.toes2, 1.134464F, 0.0F, 0.0F);
/* 284 */     this.toes1 = new ModelRenderer(this, 18, 22);
/* 285 */     this.toes1.func_78789_a(-0.0F, 0.4F, -3.0F, 2, 1, 4);
/* 286 */     this.toes1.func_78793_a(0.0F, 8.0F, 0.0F);
/* 287 */     this.toes1.func_78787_b(128, 64);
/* 288 */     setRotation(this.toes1, 1.134464F, 0.0F, 0.0F);
/* 289 */     this.hoof1 = new ModelRenderer(this, 30, 0);
/* 290 */     this.hoof1.func_78789_a(-0.0F, 0.0F, -6.3F, 2, 1, 2);
/* 291 */     this.hoof1.func_78793_a(0.0F, 5.0F, 0.5F);
/* 292 */     this.hoof1.func_78787_b(128, 64);
/* 293 */     setRotation(this.hoof1, 0.0F, 0.0F, 0.0F);
/* 294 */     this.hoof2 = new ModelRenderer(this, 30, 0);
/* 295 */     this.hoof2.field_78809_i = true;
/* 296 */     this.hoof2.func_78789_a(-0.5F, 0.0F, -6.3F, 2, 1, 2);
/* 297 */     this.hoof2.func_78793_a(0.0F, 5.0F, -0.5F);
/* 298 */     this.hoof2.func_78787_b(128, 64);
/*     */     
/* 300 */     setRotation(this.hoof2, 0.0F, 0.0F, 0.0F);
/* 301 */     this.hoof3 = new ModelRenderer(this, 30, 0);
/* 302 */     this.hoof3.func_78789_a(-0.5F, 0.0F, -6.3F, 2, 1, 2);
/* 303 */     this.hoof3.func_78793_a(0.0F, 5.0F, -0.5F);
/* 304 */     this.hoof3.func_78787_b(128, 64);
/* 305 */     setRotation(this.hoof3, 0.0F, 0.0F, 0.0F);
/*     */     
/* 307 */     this.hoof4 = new ModelRenderer(this, 30, 0);
/* 308 */     this.hoof4.field_78809_i = true;
/* 309 */     this.hoof4.func_78789_a(-1.5F, 0.0F, -6.3F, 2, 1, 2);
/* 310 */     this.hoof4.func_78793_a(0.0F, 5.0F, -0.5F);
/* 311 */     this.hoof4.func_78787_b(128, 64);
/*     */     
/* 313 */     setRotation(this.hoof4, 0.0F, 0.0F, 0.0F);
/*     */     
/* 315 */     this.upperLeg4.func_78792_a(this.leg4);
/* 316 */     this.leg4.func_78792_a(this.lowerleg4);
/* 317 */     this.lowerleg4.func_78792_a(this.toes4);
/* 318 */     this.toes4.func_78792_a(this.hoof4);
/*     */     
/* 320 */     this.upperLeg3.func_78792_a(this.leg3);
/* 321 */     this.leg3.func_78792_a(this.lowerleg3);
/* 322 */     this.lowerleg3.func_78792_a(this.toes3);
/* 323 */     this.toes3.func_78792_a(this.hoof3);
/*     */     
/* 325 */     this.thigh1.func_78792_a(this.calf1);
/* 326 */     this.calf1.func_78792_a(this.leg1);
/* 327 */     this.leg1.func_78792_a(this.toes1);
/* 328 */     this.toes1.func_78792_a(this.hoof1);
/*     */     
/* 330 */     this.thigh2.func_78792_a(this.calf2);
/* 331 */     this.calf2.func_78792_a(this.leg2);
/* 332 */     this.leg2.func_78792_a(this.toes2);
/* 333 */     this.toes2.func_78792_a(this.hoof2);
/*     */     
/* 335 */     this.antler11.func_78792_a(this.antler12);
/* 336 */     this.antler21.func_78792_a(this.antler22);
/* 337 */     this.antler11.func_78792_a(this.antler13);
/* 338 */     this.antler21.func_78792_a(this.antler23);
/* 339 */     this.antler11.func_78792_a(this.antler14);
/* 340 */     this.antler21.func_78792_a(this.antler24);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 346 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 347 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 348 */     this.running = false;
/* 349 */     this.running = ((EntityDeer)entity).getRunning();
/*     */ 
/*     */     
/* 352 */     float age = 1.0F - TFC_Core.getPercentGrown((IAnimal)entity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 361 */     float aa = 2.0F - 1.0F - age;
/* 362 */     GL11.glTranslatef(0.0F, -6.0F * f5 * age / (float)Math.pow(aa, 0.4D), 0.0F);
/* 363 */     GL11.glPushMatrix();
/* 364 */     float ab = (float)Math.sqrt((1.0F / aa));
/* 365 */     GL11.glScalef(ab, ab, ab);
/* 366 */     GL11.glTranslatef(0.0F, 22.0F * f5 * age / (float)Math.pow(aa, 0.4D), 2.0F * f5 * age / ab);
/* 367 */     if (((IAnimal)entity).getGender() == IAnimal.GenderEnum.MALE && 
/* 368 */       aa <= 1.75D) {
/* 369 */       this.antler11.field_78807_k = false;
/* 370 */       this.antler21.field_78807_k = false;
/* 371 */       if (aa <= 1.5D) {
/* 372 */         this.antler12.field_78807_k = false;
/* 373 */         this.antler22.field_78807_k = false;
/* 374 */         if (aa <= 1.3D) {
/* 375 */           this.antler13.field_78807_k = false;
/* 376 */           this.antler23.field_78807_k = false;
/* 377 */           if (aa <= 1.1D) {
/* 378 */             this.antler14.field_78807_k = false;
/* 379 */             this.antler24.field_78807_k = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 385 */     this.antler11.func_78785_a(f5);
/* 386 */     this.antler21.func_78785_a(f5);
/* 387 */     this.head.func_78785_a(f5);
/* 388 */     GL11.glPopMatrix();
/* 389 */     GL11.glPushMatrix();
/* 390 */     GL11.glScalef(1.0F / aa, ab, 1.0F / aa);
/* 391 */     GL11.glTranslatef(0.0F, 22.0F * f5 * age / (float)Math.pow(aa, 0.4D), 0.0F);
/* 392 */     this.thigh1.func_78785_a(f5);
/* 393 */     this.upperLeg4.func_78785_a(f5);
/* 394 */     this.upperLeg3.func_78785_a(f5);
/* 395 */     this.thigh2.func_78785_a(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 400 */     GL11.glPopMatrix();
/* 401 */     GL11.glPushMatrix();
/* 402 */     GL11.glScalef(1.0F / aa, 1.0F / aa, 1.0F / aa);
/* 403 */     GL11.glTranslatef(0.0F, 22.0F * f5 * age, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 408 */     this.tail.func_78785_a(f5);
/* 409 */     this.collar.func_78785_a(f5);
/*     */     
/* 411 */     this.neck.func_78785_a(f5);
/* 412 */     this.rump.func_78785_a(f5);
/* 413 */     this.body.func_78785_a(f5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 418 */     this.torso.func_78785_a(f5);
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
/* 430 */     GL11.glPopMatrix();
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
/* 480 */     model.field_78795_f = x;
/* 481 */     model.field_78796_g = y;
/* 482 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 488 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 491 */     f1 = Math.min(f1 * 7.5F, 0.75F);
/* 492 */     f *= 0.95F;
/*     */     
/* 494 */     this.antler11.field_78807_k = true;
/* 495 */     this.antler12.field_78807_k = true;
/* 496 */     this.antler13.field_78807_k = true;
/* 497 */     this.antler14.field_78807_k = true;
/* 498 */     this.antler21.field_78807_k = true;
/* 499 */     this.antler22.field_78807_k = true;
/* 500 */     this.antler23.field_78807_k = true;
/* 501 */     this.antler24.field_78807_k = true;
/* 502 */     setRotation(this.antler21, f4 / 57.295776F, f3 / 57.295776F, 0.0F);
/* 503 */     setRotation(this.head, f4 / 57.295776F + 0.1570796F, f3 / 57.295776F, 0.0F);
/* 504 */     setRotation(this.antler11, f4 / 57.295776F, f3 / 57.295776F, 0.0F);
/* 505 */     setRotation(this.torso, 0.122173F, 0.0F, 0.0F);
/* 506 */     setRotation(this.collar, f4 / 171.88733F + 1.151917F, f3 / 171.88733F, 0.0F);
/* 507 */     setRotation(this.neck, f4 / 85.943665F + 1.815142F, f3 / 85.943665F, 0.0F);
/* 508 */     setRotation(this.rump, -0.0872665F, 0.0F, 0.0F);
/* 509 */     setRotation(this.body, 1.43117F, 0.0F, 0.0F);
/* 510 */     setRotation(this.calf1, 0.5585054F, 0.0F, -0.1745329F);
/* 511 */     setRotation(this.calf2, 0.5585054F, 0.0F, 0.1745329F);
/* 512 */     setRotation(this.toes3, 1.134464F, 0.0F, 0.0F);
/* 513 */     setRotation(this.hoof1, -1.134464F, 0.0F, 0.0F);
/* 514 */     setRotation(this.hoof2, -1.134464F, 0.0F, 0.0F);
/* 515 */     setRotation(this.hoof3, -1.134464F, 0.0F, 0.0F);
/* 516 */     setRotation(this.hoof4, -1.134464F, 0.0F, 0.0F);
/*     */     
/* 518 */     setRotation(this.tail, -1.308997F, 0.0F, 0.0F);
/*     */     
/* 520 */     setRotation(this.leg1, -0.38397244F, 0.0F, 0.0F);
/* 521 */     setRotation(this.leg2, -0.38397244F, 0.0F, 0.0F);
/* 522 */     setRotation(this.leg3, -0.3490659F, 0.0F, 0.0349066F);
/* 523 */     setRotation(this.leg4, -0.3490659F, 0.0F, -0.0349066F);
/*     */     
/* 525 */     setRotation(this.upperLeg4, 0.3490659F, 0.0F, 0.0349066F);
/* 526 */     setRotation(this.upperLeg3, 0.3490659F, 0.0F, -0.0349066F);
/* 527 */     setRotation(this.thigh1, -0.1745329F, 0.0F, 0.1745329F);
/* 528 */     setRotation(this.thigh2, -0.1745329F, 0.0F, -0.1745329F);
/*     */     
/* 530 */     if (!this.running) {
/* 531 */       setRotation(this.upperLeg4, MathHelper.func_76134_b(f / 1.5F + 4.712389F) * 0.7F * f1 + 0.3490659F, 0.0F, 0.0349066F);
/* 532 */       setRotation(this.upperLeg3, MathHelper.func_76134_b(f / 1.5F + 1.5707964F) * 0.7F * f1 + 0.3490659F, 0.0F, -0.0349066F);
/* 533 */       setRotation(this.thigh1, MathHelper.func_76134_b(f / 1.5F + 5.4977875F) * 0.7F * f1 - 0.1745329F, 0.0F, 0.1745329F);
/* 534 */       setRotation(this.thigh2, MathHelper.func_76134_b(f / 1.5F + 2.3561945F) * 0.7F * f1 - 0.1745329F, 0.0F, -0.1745329F);
/* 535 */       if (MathHelper.func_76126_a(f / 1.5F + 1.5707964F) * 0.7F * f1 > 0.0F) {
/* 536 */         setRotation(this.lowerleg3, MathHelper.func_76126_a(f / 1.5F + 1.5707964F) * 1.4F * f1, 0.0F, 0.0F);
/* 537 */         setRotation(this.leg3, -MathHelper.func_76126_a(f / 1.5F + 1.5707964F) * 0.7F * f1 - 0.3490659F, 0.0F, 0.0349066F);
/* 538 */         setRotation(this.toes3, MathHelper.func_76126_a(f / 1.5F + 1.5707964F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       } 
/* 540 */       if (MathHelper.func_76126_a(f / 1.5F + 1.5707964F) * 0.7F * f1 < 0.0F) {
/* 541 */         setRotation(this.lowerleg4, MathHelper.func_76126_a(f / 1.5F + 4.712389F) * 1.4F * f1, 0.0F, 0.0F);
/* 542 */         setRotation(this.leg4, -MathHelper.func_76126_a(f / 1.5F + 4.712389F) * 0.7F * f1 - 0.3490659F, 0.0F, -0.0349066F);
/* 543 */         setRotation(this.toes4, MathHelper.func_76126_a(f / 1.5F + 4.712389F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       } 
/* 545 */       if (MathHelper.func_76126_a(f / 1.5F + 5.4977875F) * 0.7F * f1 > 0.0F) {
/* 546 */         setRotation(this.calf1, MathHelper.func_76126_a(f / 1.5F + 5.4977875F) * 1.4F * f1 + 0.5585054F, 0.0F, -0.1745329F);
/* 547 */         setRotation(this.leg1, -MathHelper.func_76126_a(f / 1.5F + 5.4977875F) * 1.4F * f1 - 0.38397244F, 0.0F, 0.0F);
/* 548 */         setRotation(this.toes1, MathHelper.func_76126_a(f / 1.5F + 5.4977875F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       } 
/* 550 */       if (MathHelper.func_76126_a(f / 1.5F + 2.3561945F) * 0.7F * f1 > 0.0F) {
/* 551 */         setRotation(this.calf2, MathHelper.func_76126_a(f / 1.5F + 2.3561945F) * 1.4F * f1 + 0.5585054F, 0.0F, 0.1745329F);
/* 552 */         setRotation(this.leg2, -MathHelper.func_76126_a(f / 1.5F + 2.3561945F) * 1.4F * f1 - 0.38397244F, 0.0F, 0.0F);
/* 553 */         setRotation(this.toes2, MathHelper.func_76126_a(f / 1.5F + 2.3561945F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 558 */       if (MathHelper.func_76134_b(f / 1.5F + 3.926991F) > -Math.sqrt(0.5D) && MathHelper.func_76134_b(f / 1.5F + 3.926991F) < Math.sqrt(0.5D)) {
/* 559 */         setRotation(this.upperLeg4, MathHelper.func_76134_b(f / 1.5F + 3.926991F) * 2.8F * f1 + 0.3490659F, 0.0F, 0.0349066F);
/*     */       }
/* 561 */       if (MathHelper.func_76126_a(f / 1.5F + 3.926991F - 1.1780972F) > 0.0F) {
/* 562 */         setRotation(this.lowerleg4, MathHelper.func_76126_a(f / 1.5F + 3.926991F - 1.1780972F) * 3.5F * f1, 0.0F, 0.0F);
/* 563 */         setRotation(this.leg4, -MathHelper.func_76126_a(f / 1.5F + 3.926991F - 1.1780972F) * 3.5F * f1 - 0.3490659F, 0.0F, -0.0349066F);
/* 564 */         setRotation(this.toes4, MathHelper.func_76126_a(f / 1.5F + 3.926991F - 1.1780972F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       } 
/*     */ 
/*     */       
/* 568 */       if (MathHelper.func_76134_b(f / 1.5F + 1.5707964F) > -Math.sqrt(0.5D) && MathHelper.func_76134_b(f / 1.5F + 1.5707964F) < Math.sqrt(0.5D)) {
/* 569 */         setRotation(this.upperLeg3, MathHelper.func_76134_b(f / 1.5F + 1.5707964F) * 2.8F * f1 + 0.3490659F, 0.0F, -0.0349066F);
/*     */       }
/* 571 */       if (MathHelper.func_76126_a(f / 1.5F + 1.5707964F - 1.1780972F) > 0.0F) {
/* 572 */         setRotation(this.lowerleg3, MathHelper.func_76126_a(f / 1.5F + 1.5707964F - 1.1780972F) * 3.5F * f1, 0.0F, 0.0F);
/* 573 */         setRotation(this.leg3, -MathHelper.func_76126_a(f / 1.5F + 1.5707964F - 1.1780972F) * 3.5F * f1 - 0.3490659F, 0.0F, 0.0349066F);
/* 574 */         setRotation(this.toes3, MathHelper.func_76126_a(f / 1.5F + 1.5707964F - 1.1780972F) * 2.1F * f1 + 1.134464F, 0.0F, 0.0F);
/*     */       } 
/*     */       
/* 577 */       setRotation(this.thigh1, MathHelper.func_76134_b(f / 1.5F + 5.4977875F) * 2.8F * f1 - 0.1745329F, 0.0F, 0.1745329F);
/* 578 */       setRotation(this.thigh2, MathHelper.func_76134_b(f / 1.5F + 2.3561945F) * 2.8F * f1 - 0.1745329F, 0.0F, -0.1745329F);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelDeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */