/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEBellows;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TESRBellows
/*     */   extends TESRBase
/*     */ {
/*  14 */   private static final ResourceLocation FRONT_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows Front.png");
/*  15 */   private static final ResourceLocation BACK_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows Back.png");
/*  16 */   private static final ResourceLocation SIDE1_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows82.png");
/*  17 */   private static final ResourceLocation SIDE2_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows83.png");
/*  18 */   private static final ResourceLocation SIDE3_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows84.png");
/*  19 */   private static final ResourceLocation SIDE4_TEXTURE = new ResourceLocation("terrafirmacraft:textures/blocks/devices/Bellows85.png");
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity tileentity, double x, double y, double z, float f) {
/*  24 */     TEBellows bellows = (TEBellows)tileentity;
/*  25 */     if (bellows != null) {
/*     */       
/*  27 */       int meta = bellows.func_145831_w().func_72805_g(bellows.field_145851_c, bellows.field_145848_d, bellows.field_145849_e);
/*  28 */       float pos = bellows.blowTimer * 0.1F;
/*  29 */       if (pos < 0.0F) pos = 0.0F;
/*     */       
/*  31 */       Tessellator t = Tessellator.field_78398_a;
/*  32 */       GL11.glPushMatrix();
/*  33 */       GL11.glTranslatef((float)x, (float)y, (float)z);
/*     */       
/*  35 */       renderBack(t, meta, pos);
/*  36 */       renderBody(t, meta, pos);
/*  37 */       renderFront(t, meta);
/*     */       
/*  39 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderBack(Tessellator t, int meta, float pos) {
/*  47 */     float l = 0.125F;
/*  48 */     float m = 1.0F - l;
/*     */     
/*  50 */     if (meta == 0) {
/*     */       
/*  52 */       float i = pos;
/*  53 */       float j = 0.1F + pos;
/*     */       
/*  55 */       func_147499_a(BACK_TEXTURE);
/*  56 */       t.func_78382_b();
/*     */       
/*  58 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/*  59 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, 1.0D);
/*  60 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, 1.0D);
/*  61 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, 0.0D);
/*     */       
/*  63 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, 0.0D);
/*  64 */       t.func_78374_a(1.0D, 0.0D, j, 0.0D, 1.0D);
/*  65 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, 1.0D);
/*  66 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, 0.0D);
/*     */ 
/*     */       
/*  69 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, 0.0D);
/*  70 */       t.func_78374_a(0.0D, 1.0D, j, 0.0D, l);
/*  71 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, l);
/*  72 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, 0.0D);
/*     */       
/*  74 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/*  75 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, l);
/*  76 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, l);
/*  77 */       t.func_78374_a(0.0D, 1.0D, i, 1.0D, 0.0D);
/*     */       
/*  79 */       t.func_78374_a(1.0D, 1.0D, i, 0.0D, 0.0D);
/*  80 */       t.func_78374_a(1.0D, 1.0D, j, 0.0D, l);
/*  81 */       t.func_78374_a(1.0D, 0.0D, j, 1.0D, l);
/*  82 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, 0.0D);
/*     */       
/*  84 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/*  85 */       t.func_78374_a(1.0D, 0.0D, i, 0.0D, 1.0D);
/*  86 */       t.func_78374_a(1.0D, 0.0D, j, l, 1.0D);
/*  87 */       t.func_78374_a(0.0D, 0.0D, j, l, 0.0D);
/*  88 */       t.func_78381_a();
/*     */     }
/*  90 */     else if (meta == 1) {
/*     */       
/*  92 */       float i = 0.9F - pos;
/*  93 */       float j = 1.0F - pos;
/*     */       
/*  95 */       func_147499_a(BACK_TEXTURE);
/*  96 */       t.func_78382_b();
/*     */       
/*  98 */       t.func_78374_a(i, 0.0D, 0.0D, 0.0D, 0.0D);
/*  99 */       t.func_78374_a(i, 0.0D, 1.0D, 0.0D, 1.0D);
/* 100 */       t.func_78374_a(i, 1.0D, 1.0D, 1.0D, 1.0D);
/* 101 */       t.func_78374_a(i, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 103 */       t.func_78374_a(j, 0.0D, 0.0D, 0.0D, 0.0D);
/* 104 */       t.func_78374_a(j, 1.0D, 0.0D, 0.0D, 1.0D);
/* 105 */       t.func_78374_a(j, 1.0D, 1.0D, 1.0D, 1.0D);
/* 106 */       t.func_78374_a(j, 0.0D, 1.0D, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 109 */       t.func_78374_a(i, 1.0D, 0.0D, m, 0.0D);
/* 110 */       t.func_78374_a(i, 1.0D, 1.0D, m, 1.0D);
/* 111 */       t.func_78374_a(j, 1.0D, 1.0D, 1.0D, 1.0D);
/* 112 */       t.func_78374_a(j, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 114 */       t.func_78374_a(i, 0.0D, 0.0D, m, 0.0D);
/* 115 */       t.func_78374_a(i, 1.0D, 0.0D, m, 1.0D);
/* 116 */       t.func_78374_a(j, 1.0D, 0.0D, 1.0D, 1.0D);
/* 117 */       t.func_78374_a(j, 0.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 119 */       t.func_78374_a(i, 0.0D, 1.0D, m, 0.0D);
/* 120 */       t.func_78374_a(i, 0.0D, 0.0D, m, 1.0D);
/* 121 */       t.func_78374_a(j, 0.0D, 0.0D, 1.0D, 1.0D);
/* 122 */       t.func_78374_a(j, 0.0D, 1.0D, 1.0D, 0.0D);
/*     */       
/* 124 */       t.func_78374_a(i, 1.0D, 1.0D, m, 0.0D);
/* 125 */       t.func_78374_a(i, 0.0D, 1.0D, m, 1.0D);
/* 126 */       t.func_78374_a(j, 0.0D, 1.0D, 1.0D, 1.0D);
/* 127 */       t.func_78374_a(j, 1.0D, 1.0D, 1.0D, 0.0D);
/* 128 */       t.func_78381_a();
/*     */     }
/* 130 */     else if (meta == 2) {
/*     */       
/* 132 */       float i = 0.9F - pos;
/* 133 */       float j = 1.0F - pos;
/*     */       
/* 135 */       func_147499_a(BACK_TEXTURE);
/* 136 */       t.func_78382_b();
/*     */       
/* 138 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/* 139 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, 1.0D);
/* 140 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, 1.0D);
/* 141 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, 0.0D);
/*     */       
/* 143 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, 0.0D);
/* 144 */       t.func_78374_a(1.0D, 0.0D, j, 0.0D, 1.0D);
/* 145 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, 1.0D);
/* 146 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 149 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, m);
/* 150 */       t.func_78374_a(0.0D, 1.0D, j, 0.0D, 1.0D);
/* 151 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, 1.0D);
/* 152 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, m);
/*     */       
/* 154 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/* 155 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, l);
/* 156 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, l);
/* 157 */       t.func_78374_a(0.0D, 1.0D, i, 1.0D, 0.0D);
/*     */       
/* 159 */       t.func_78374_a(1.0D, 1.0D, i, 0.0D, 0.0D);
/* 160 */       t.func_78374_a(1.0D, 1.0D, j, 0.0D, l);
/* 161 */       t.func_78374_a(1.0D, 0.0D, j, 1.0D, l);
/* 162 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, 0.0D);
/*     */       
/* 164 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/* 165 */       t.func_78374_a(1.0D, 0.0D, i, 0.0D, 1.0D);
/* 166 */       t.func_78374_a(1.0D, 0.0D, j, l, 1.0D);
/* 167 */       t.func_78374_a(0.0D, 0.0D, j, l, 0.0D);
/* 168 */       t.func_78381_a();
/*     */     }
/* 170 */     else if (meta == 3) {
/*     */       
/* 172 */       float i = pos;
/* 173 */       float j = 0.1F + pos;
/*     */       
/* 175 */       func_147499_a(BACK_TEXTURE);
/* 176 */       t.func_78382_b();
/*     */       
/* 178 */       t.func_78374_a(i, 0.0D, 0.0D, 0.0D, 0.0D);
/* 179 */       t.func_78374_a(i, 0.0D, 1.0D, 0.0D, 1.0D);
/* 180 */       t.func_78374_a(i, 1.0D, 1.0D, 1.0D, 1.0D);
/* 181 */       t.func_78374_a(i, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 183 */       t.func_78374_a(j, 0.0D, 0.0D, 0.0D, 0.0D);
/* 184 */       t.func_78374_a(j, 1.0D, 0.0D, 0.0D, 1.0D);
/* 185 */       t.func_78374_a(j, 1.0D, 1.0D, 1.0D, 1.0D);
/* 186 */       t.func_78374_a(j, 0.0D, 1.0D, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 189 */       t.func_78374_a(i, 1.0D, 0.0D, 0.0D, 0.0D);
/* 190 */       t.func_78374_a(i, 1.0D, 1.0D, 0.0D, 1.0D);
/* 191 */       t.func_78374_a(j, 1.0D, 1.0D, l, 1.0D);
/* 192 */       t.func_78374_a(j, 1.0D, 0.0D, l, 0.0D);
/*     */       
/* 194 */       t.func_78374_a(i, 0.0D, 0.0D, 0.0D, 0.0D);
/* 195 */       t.func_78374_a(i, 1.0D, 0.0D, 0.0D, 1.0D);
/* 196 */       t.func_78374_a(j, 1.0D, 0.0D, l, 1.0D);
/* 197 */       t.func_78374_a(j, 0.0D, 0.0D, l, 0.0D);
/*     */       
/* 199 */       t.func_78374_a(i, 0.0D, 1.0D, 0.0D, 0.0D);
/* 200 */       t.func_78374_a(i, 0.0D, 0.0D, 0.0D, 1.0D);
/* 201 */       t.func_78374_a(j, 0.0D, 0.0D, l, 1.0D);
/* 202 */       t.func_78374_a(j, 0.0D, 1.0D, l, 0.0D);
/*     */       
/* 204 */       t.func_78374_a(i, 1.0D, 1.0D, 0.0D, 0.0D);
/* 205 */       t.func_78374_a(i, 0.0D, 1.0D, 0.0D, 1.0D);
/* 206 */       t.func_78374_a(j, 0.0D, 1.0D, l, 1.0D);
/* 207 */       t.func_78374_a(j, 1.0D, 1.0D, l, 0.0D);
/* 208 */       t.func_78381_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderBody(Tessellator t, int meta, float pos) {
/* 216 */     float k = 0.9F;
/* 217 */     float l = 0.1F;
/*     */     
/* 219 */     if (meta == 0 || meta == 2) {
/*     */       float i, j;
/* 221 */       if (meta == 0) {
/*     */         
/* 223 */         func_147499_a(SIDE1_TEXTURE);
/* 224 */         i = 0.05F + pos;
/* 225 */         j = 0.95F;
/*     */       }
/*     */       else {
/*     */         
/* 229 */         func_147499_a(SIDE4_TEXTURE);
/* 230 */         i = 0.05F;
/* 231 */         j = 0.95F - pos;
/*     */       } 
/* 233 */       t.func_78382_b();
/* 234 */       t.func_78374_a(k, k, i, 0.0D, 0.0D);
/* 235 */       t.func_78374_a(k, k, j, 0.0D, 1.0D);
/* 236 */       t.func_78374_a(k, l, j, 1.0D, 1.0D);
/* 237 */       t.func_78374_a(k, l, i, 1.0D, 0.0D);
/* 238 */       t.func_78381_a();
/*     */       
/* 240 */       t.func_78382_b();
/* 241 */       t.func_78374_a(l, k, i, 0.0D, 0.0D);
/* 242 */       t.func_78374_a(l, k, j, 0.0D, 1.0D);
/* 243 */       t.func_78374_a(k, k, j, 1.0D, 1.0D);
/* 244 */       t.func_78374_a(k, k, i, 1.0D, 0.0D);
/* 245 */       t.func_78381_a();
/*     */       
/* 247 */       t.func_78382_b();
/* 248 */       t.func_78374_a(l, l, i, 0.0D, 0.0D);
/* 249 */       t.func_78374_a(l, l, j, 0.0D, 1.0D);
/* 250 */       t.func_78374_a(l, k, j, 1.0D, 1.0D);
/* 251 */       t.func_78374_a(l, k, i, 1.0D, 0.0D);
/* 252 */       t.func_78381_a();
/*     */       
/* 254 */       t.func_78382_b();
/* 255 */       t.func_78374_a(k, l, i, 0.0D, 0.0D);
/* 256 */       t.func_78374_a(k, l, j, 0.0D, 1.0D);
/* 257 */       t.func_78374_a(l, l, j, 1.0D, 1.0D);
/* 258 */       t.func_78374_a(l, l, i, 1.0D, 0.0D);
/* 259 */       t.func_78381_a();
/*     */     }
/* 261 */     else if (meta == 1 || meta == 3) {
/*     */       float i, j;
/* 263 */       if (meta == 3) {
/*     */         
/* 265 */         func_147499_a(SIDE3_TEXTURE);
/* 266 */         i = 0.05F + pos;
/* 267 */         j = 0.95F;
/*     */       }
/*     */       else {
/*     */         
/* 271 */         func_147499_a(SIDE2_TEXTURE);
/* 272 */         i = 0.05F;
/* 273 */         j = 0.95F - pos;
/*     */       } 
/* 275 */       t.func_78382_b();
/* 276 */       t.func_78374_a(i, l, l, 0.0D, 0.0D);
/* 277 */       t.func_78374_a(i, k, l, 0.0D, 1.0D);
/* 278 */       t.func_78374_a(j, k, l, 1.0D, 1.0D);
/* 279 */       t.func_78374_a(j, l, l, 1.0D, 0.0D);
/* 280 */       t.func_78381_a();
/*     */       
/* 282 */       t.func_78382_b();
/* 283 */       t.func_78374_a(i, l, k, 0.0D, 0.0D);
/* 284 */       t.func_78374_a(i, l, l, 0.0D, 1.0D);
/* 285 */       t.func_78374_a(j, l, l, 1.0D, 1.0D);
/* 286 */       t.func_78374_a(j, l, k, 1.0D, 0.0D);
/* 287 */       t.func_78381_a();
/*     */       
/* 289 */       t.func_78382_b();
/* 290 */       t.func_78374_a(i, k, k, 0.0D, 0.0D);
/* 291 */       t.func_78374_a(i, l, k, 0.0D, 1.0D);
/* 292 */       t.func_78374_a(j, l, k, 1.0D, 1.0D);
/* 293 */       t.func_78374_a(j, k, k, 1.0D, 0.0D);
/* 294 */       t.func_78381_a();
/*     */       
/* 296 */       t.func_78382_b();
/* 297 */       t.func_78374_a(i, k, l, 0.0D, 0.0D);
/* 298 */       t.func_78374_a(i, k, k, 0.0D, 1.0D);
/* 299 */       t.func_78374_a(j, k, k, 1.0D, 1.0D);
/* 300 */       t.func_78374_a(j, k, l, 1.0D, 0.0D);
/* 301 */       t.func_78381_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderFront(Tessellator t, int meta) {
/* 307 */     float i = 0.9F;
/* 308 */     float j = 0.1F;
/* 309 */     float l = 0.125F;
/* 310 */     float m = 1.0F - l;
/*     */     
/* 312 */     if (meta == 0) {
/*     */       
/* 314 */       func_147499_a(FRONT_TEXTURE);
/* 315 */       t.func_78382_b();
/*     */       
/* 317 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
/* 318 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 319 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 320 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 1.0D, 0.0D);
/* 321 */       t.func_78381_a();
/*     */       
/* 323 */       func_147499_a(BACK_TEXTURE);
/* 324 */       t.func_78382_b();
/*     */       
/* 326 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, 0.0D);
/* 327 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, 1.0D);
/* 328 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, 1.0D);
/* 329 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 332 */       t.func_78374_a(0.0D, 1.0D, i, 0.0D, m);
/* 333 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
/* 334 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 335 */       t.func_78374_a(1.0D, 1.0D, i, 1.0D, m);
/*     */       
/* 337 */       t.func_78374_a(0.0D, 0.0D, i, 0.0D, m);
/* 338 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 339 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 340 */       t.func_78374_a(0.0D, 1.0D, i, 1.0D, m);
/*     */       
/* 342 */       t.func_78374_a(1.0D, 1.0D, i, 0.0D, m);
/* 343 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 0.0D, 1.0D);
/* 344 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 345 */       t.func_78374_a(1.0D, 0.0D, i, 1.0D, m);
/*     */       
/* 347 */       t.func_78374_a(0.0D, 0.0D, i, m, 0.0D);
/* 348 */       t.func_78374_a(1.0D, 0.0D, i, m, 1.0D);
/* 349 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 350 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 1.0D, 0.0D);
/* 351 */       t.func_78381_a();
/*     */     }
/* 353 */     else if (meta == 1) {
/*     */       
/* 355 */       func_147499_a(FRONT_TEXTURE);
/* 356 */       t.func_78382_b();
/*     */       
/* 358 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 359 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 360 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 361 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 1.0D, 0.0D);
/* 362 */       t.func_78381_a();
/*     */       
/* 364 */       func_147499_a(BACK_TEXTURE);
/* 365 */       t.func_78382_b();
/*     */       
/* 367 */       t.func_78374_a(j, 0.0D, 0.0D, 0.0D, 0.0D);
/* 368 */       t.func_78374_a(j, 1.0D, 0.0D, 0.0D, 1.0D);
/* 369 */       t.func_78374_a(j, 1.0D, 1.0D, 1.0D, 1.0D);
/* 370 */       t.func_78374_a(j, 0.0D, 1.0D, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 373 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
/* 374 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
/* 375 */       t.func_78374_a(j, 1.0D, 1.0D, l, 1.0D);
/* 376 */       t.func_78374_a(j, 1.0D, 0.0D, l, 0.0D);
/*     */       
/* 378 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 379 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 0.0D, 1.0D);
/* 380 */       t.func_78374_a(j, 1.0D, 0.0D, l, 1.0D);
/* 381 */       t.func_78374_a(j, 0.0D, 0.0D, l, 0.0D);
/*     */       
/* 383 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
/* 384 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 1.0D);
/* 385 */       t.func_78374_a(j, 0.0D, 0.0D, l, 1.0D);
/* 386 */       t.func_78374_a(j, 0.0D, 1.0D, l, 0.0D);
/*     */       
/* 388 */       t.func_78374_a(0.0D, 1.0D, 1.0D, 0.0D, 0.0D);
/* 389 */       t.func_78374_a(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
/* 390 */       t.func_78374_a(j, 0.0D, 1.0D, l, 1.0D);
/* 391 */       t.func_78374_a(j, 1.0D, 1.0D, l, 0.0D);
/* 392 */       t.func_78381_a();
/*     */     }
/* 394 */     else if (meta == 2) {
/*     */       
/* 396 */       func_147499_a(FRONT_TEXTURE);
/* 397 */       t.func_78382_b();
/*     */       
/* 399 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 400 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 0.0D, 1.0D);
/* 401 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 1.0D, 1.0D);
/* 402 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
/* 403 */       t.func_78381_a();
/*     */       
/* 405 */       func_147499_a(BACK_TEXTURE);
/* 406 */       t.func_78382_b();
/*     */       
/* 408 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, 0.0D);
/* 409 */       t.func_78374_a(1.0D, 0.0D, j, 0.0D, 1.0D);
/* 410 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, 1.0D);
/* 411 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 414 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
/* 415 */       t.func_78374_a(0.0D, 1.0D, j, 0.0D, l);
/* 416 */       t.func_78374_a(1.0D, 1.0D, j, 1.0D, l);
/* 417 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 419 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 420 */       t.func_78374_a(0.0D, 0.0D, j, 0.0D, l);
/* 421 */       t.func_78374_a(0.0D, 1.0D, j, 1.0D, l);
/* 422 */       t.func_78374_a(0.0D, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 424 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 0.0D, 0.0D);
/* 425 */       t.func_78374_a(1.0D, 1.0D, j, 0.0D, l);
/* 426 */       t.func_78374_a(1.0D, 0.0D, j, 1.0D, l);
/* 427 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 429 */       t.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 430 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
/* 431 */       t.func_78374_a(1.0D, 0.0D, j, l, 1.0D);
/* 432 */       t.func_78374_a(0.0D, 0.0D, j, l, 0.0D);
/* 433 */       t.func_78381_a();
/*     */     }
/* 435 */     else if (meta == 3) {
/*     */       
/* 437 */       func_147499_a(FRONT_TEXTURE);
/* 438 */       t.func_78382_b();
/*     */       
/* 440 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 441 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 0.0D, 1.0D);
/* 442 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 443 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 0.0D);
/* 444 */       t.func_78381_a();
/*     */       
/* 446 */       func_147499_a(BACK_TEXTURE);
/* 447 */       t.func_78382_b();
/*     */       
/* 449 */       t.func_78374_a(i, 0.0D, 0.0D, 0.0D, 0.0D);
/* 450 */       t.func_78374_a(i, 0.0D, 1.0D, 0.0D, 1.0D);
/* 451 */       t.func_78374_a(i, 1.0D, 1.0D, 1.0D, 1.0D);
/* 452 */       t.func_78374_a(i, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */ 
/*     */       
/* 455 */       t.func_78374_a(i, 1.0D, 0.0D, m, 0.0D);
/* 456 */       t.func_78374_a(i, 1.0D, 1.0D, m, 1.0D);
/* 457 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
/* 458 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 460 */       t.func_78374_a(i, 0.0D, 0.0D, m, 0.0D);
/* 461 */       t.func_78374_a(i, 1.0D, 0.0D, m, 1.0D);
/* 462 */       t.func_78374_a(1.0D, 1.0D, 0.0D, 1.0D, 1.0D);
/* 463 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
/*     */       
/* 465 */       t.func_78374_a(i, 0.0D, 1.0D, m, 0.0D);
/* 466 */       t.func_78374_a(i, 0.0D, 0.0D, m, 1.0D);
/* 467 */       t.func_78374_a(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
/* 468 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 0.0D);
/*     */       
/* 470 */       t.func_78374_a(i, 1.0D, 1.0D, m, 0.0D);
/* 471 */       t.func_78374_a(i, 0.0D, 1.0D, m, 1.0D);
/* 472 */       t.func_78374_a(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/* 473 */       t.func_78374_a(1.0D, 1.0D, 1.0D, 1.0D, 0.0D);
/* 474 */       t.func_78381_a();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */