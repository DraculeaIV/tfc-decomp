/*     */ package com.bioxx.tfc.api.Util;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimplexNoise_Octave
/*     */ {
/*     */   public static long RANDOMSEED;
/*  10 */   private static int NUMBEROFSWAPS = 400;
/*     */   
/*  12 */   private static Grad[] grad3 = new Grad[] { new Grad(1.0D, 1.0D, 0.0D), new Grad(-1.0D, 1.0D, 0.0D), new Grad(1.0D, -1.0D, 0.0D), new Grad(-1.0D, -1.0D, 0.0D), new Grad(1.0D, 0.0D, 1.0D), new Grad(-1.0D, 0.0D, 1.0D), new Grad(1.0D, 0.0D, -1.0D), new Grad(-1.0D, 0.0D, -1.0D), new Grad(0.0D, 1.0D, 1.0D), new Grad(0.0D, -1.0D, 1.0D), new Grad(0.0D, 1.0D, -1.0D), new Grad(0.0D, -1.0D, -1.0D) };
/*     */ 
/*     */ 
/*     */   
/*  16 */   private static Grad[] grad4 = new Grad[] { new Grad(0.0D, 1.0D, 1.0D, 1.0D), new Grad(0.0D, 1.0D, 1.0D, -1.0D), new Grad(0.0D, 1.0D, -1.0D, 1.0D), new Grad(0.0D, 1.0D, -1.0D, -1.0D), new Grad(0.0D, -1.0D, 1.0D, 1.0D), new Grad(0.0D, -1.0D, 1.0D, -1.0D), new Grad(0.0D, -1.0D, -1.0D, 1.0D), new Grad(0.0D, -1.0D, -1.0D, -1.0D), new Grad(1.0D, 0.0D, 1.0D, 1.0D), new Grad(1.0D, 0.0D, 1.0D, -1.0D), new Grad(1.0D, 0.0D, -1.0D, 1.0D), new Grad(1.0D, 0.0D, -1.0D, -1.0D), new Grad(-1.0D, 0.0D, 1.0D, 1.0D), new Grad(-1.0D, 0.0D, 1.0D, -1.0D), new Grad(-1.0D, 0.0D, -1.0D, 1.0D), new Grad(-1.0D, 0.0D, -1.0D, -1.0D), new Grad(1.0D, 1.0D, 0.0D, 1.0D), new Grad(1.0D, 1.0D, 0.0D, -1.0D), new Grad(1.0D, -1.0D, 0.0D, 1.0D), new Grad(1.0D, -1.0D, 0.0D, -1.0D), new Grad(-1.0D, 1.0D, 0.0D, 1.0D), new Grad(-1.0D, 1.0D, 0.0D, -1.0D), new Grad(-1.0D, -1.0D, 0.0D, 1.0D), new Grad(-1.0D, -1.0D, 0.0D, -1.0D), new Grad(1.0D, 1.0D, 1.0D, 0.0D), new Grad(1.0D, 1.0D, -1.0D, 0.0D), new Grad(1.0D, -1.0D, 1.0D, 0.0D), new Grad(1.0D, -1.0D, -1.0D, 0.0D), new Grad(-1.0D, 1.0D, 1.0D, 0.0D), new Grad(-1.0D, 1.0D, -1.0D, 0.0D), new Grad(-1.0D, -1.0D, 1.0D, 0.0D), new Grad(-1.0D, -1.0D, -1.0D, 0.0D) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  25 */   private static short[] p_supply = new short[] { 151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180 };
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
/*  41 */   private short[] perm = new short[512];
/*  42 */   private short[] permMod12 = new short[512];
/*     */ 
/*     */   
/*     */   public SimplexNoise_Octave(int seed) {
/*  46 */     short[] p = new short[p_supply.length];
/*  47 */     p = (short[])p_supply.clone();
/*     */     
/*  49 */     if (seed == RANDOMSEED) {
/*     */       
/*  51 */       Random random = new Random();
/*  52 */       seed = random.nextInt();
/*     */     } 
/*     */ 
/*     */     
/*  56 */     Random rand = new Random(seed);
/*     */     
/*     */     int i;
/*  59 */     for (i = 0; i < NUMBEROFSWAPS; i++) {
/*  60 */       int swapFrom = rand.nextInt(p.length);
/*  61 */       int swapTo = rand.nextInt(p.length);
/*     */       
/*  63 */       short temp = p[swapFrom];
/*  64 */       p[swapFrom] = p[swapTo];
/*  65 */       p[swapTo] = temp;
/*     */     } 
/*     */ 
/*     */     
/*  69 */     for (i = 0; i < 512; i++) {
/*     */       
/*  71 */       this.perm[i] = p[i & 0xFF];
/*  72 */       this.permMod12[i] = (short)(this.perm[i] % 12);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  77 */   private static final double F2 = 0.5D * (Math.sqrt(3.0D) - 1.0D);
/*  78 */   private static final double G2 = (3.0D - Math.sqrt(3.0D)) / 6.0D;
/*     */   private static final double F3 = 0.3333333333333333D;
/*     */   private static final double G3 = 0.16666666666666666D;
/*  81 */   private static final double F4 = (Math.sqrt(5.0D) - 1.0D) / 4.0D;
/*  82 */   private static final double G4 = (5.0D - Math.sqrt(5.0D)) / 20.0D;
/*     */ 
/*     */   
/*     */   private static int fastfloor(double x) {
/*  86 */     int xi = (int)x;
/*  87 */     return (x < xi) ? (xi - 1) : xi;
/*     */   }
/*     */   
/*     */   private static double dot(Grad g, double x, double y) {
/*  91 */     return g.x * x + g.y * y;
/*     */   }
/*     */   private static double dot(Grad g, double x, double y, double z) {
/*  94 */     return g.x * x + g.y * y + g.z * z;
/*     */   }
/*     */   private static double dot(Grad g, double x, double y, double z, double w) {
/*  97 */     return g.x * x + g.y * y + g.z * z + g.w * w;
/*     */   }
/*     */ 
/*     */   
/*     */   public double noise(double xin, double yin) {
/*     */     double n0, n1, n2;
/*     */     int i1, j1;
/* 104 */     double s = (xin + yin) * F2;
/* 105 */     int i = fastfloor(xin + s);
/* 106 */     int j = fastfloor(yin + s);
/* 107 */     double t = (i + j) * G2;
/* 108 */     double X0 = i - t;
/* 109 */     double Y0 = j - t;
/* 110 */     double x0 = xin - X0;
/* 111 */     double y0 = yin - Y0;
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (x0 > y0) { i1 = 1; j1 = 0; }
/* 116 */     else { i1 = 0; j1 = 1; }
/*     */ 
/*     */ 
/*     */     
/* 120 */     double x1 = x0 - i1 + G2;
/* 121 */     double y1 = y0 - j1 + G2;
/* 122 */     double x2 = x0 - 1.0D + 2.0D * G2;
/* 123 */     double y2 = y0 - 1.0D + 2.0D * G2;
/*     */     
/* 125 */     int ii = i & 0xFF;
/* 126 */     int jj = j & 0xFF;
/* 127 */     int gi0 = this.permMod12[ii + this.perm[jj]];
/* 128 */     int gi1 = this.permMod12[ii + i1 + this.perm[jj + j1]];
/* 129 */     int gi2 = this.permMod12[ii + 1 + this.perm[jj + 1]];
/*     */     
/* 131 */     double t0 = 0.5D - x0 * x0 - y0 * y0;
/* 132 */     if (t0 < 0.0D) { n0 = 0.0D; }
/*     */     else
/* 134 */     { t0 *= t0;
/* 135 */       n0 = t0 * t0 * dot(grad3[gi0], x0, y0); }
/*     */     
/* 137 */     double t1 = 0.5D - x1 * x1 - y1 * y1;
/* 138 */     if (t1 < 0.0D) { n1 = 0.0D; }
/*     */     else
/* 140 */     { t1 *= t1;
/* 141 */       n1 = t1 * t1 * dot(grad3[gi1], x1, y1); }
/*     */     
/* 143 */     double t2 = 0.5D - x2 * x2 - y2 * y2;
/* 144 */     if (t2 < 0.0D) { n2 = 0.0D; }
/*     */     else
/* 146 */     { t2 *= t2;
/* 147 */       n2 = t2 * t2 * dot(grad3[gi2], x2, y2); }
/*     */ 
/*     */ 
/*     */     
/* 151 */     return 70.0D * (n0 + n1 + n2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double noise(double xin, double yin, double zin) {
/*     */     double n0, n1, n2, n3;
/*     */     int i1, j1, k1, i2, j2, k2;
/* 159 */     double s = (xin + yin + zin) * 0.3333333333333333D;
/* 160 */     int i = fastfloor(xin + s);
/* 161 */     int j = fastfloor(yin + s);
/* 162 */     int k = fastfloor(zin + s);
/* 163 */     double t = (i + j + k) * 0.16666666666666666D;
/* 164 */     double X0 = i - t;
/* 165 */     double Y0 = j - t;
/* 166 */     double Z0 = k - t;
/* 167 */     double x0 = xin - X0;
/* 168 */     double y0 = yin - Y0;
/* 169 */     double z0 = zin - Z0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     if (x0 >= y0)
/* 175 */     { if (y0 >= z0)
/* 176 */       { i1 = 1; j1 = 0; k1 = 0; i2 = 1; j2 = 1; k2 = 0; }
/* 177 */       else if (x0 >= z0) { i1 = 1; j1 = 0; k1 = 0; i2 = 1; j2 = 0; k2 = 1; }
/* 178 */       else { i1 = 0; j1 = 0; k1 = 1; i2 = 1; j2 = 0; k2 = 1; }
/*     */       
/*     */        }
/* 181 */     else if (y0 < z0) { i1 = 0; j1 = 0; k1 = 1; i2 = 0; j2 = 1; k2 = 1; }
/* 182 */     else if (x0 < z0) { i1 = 0; j1 = 1; k1 = 0; i2 = 0; j2 = 1; k2 = 1; }
/* 183 */     else { i1 = 0; j1 = 1; k1 = 0; i2 = 1; j2 = 1; k2 = 0; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     double x1 = x0 - i1 + 0.16666666666666666D;
/* 190 */     double y1 = y0 - j1 + 0.16666666666666666D;
/* 191 */     double z1 = z0 - k1 + 0.16666666666666666D;
/* 192 */     double x2 = x0 - i2 + 0.3333333333333333D;
/* 193 */     double y2 = y0 - j2 + 0.3333333333333333D;
/* 194 */     double z2 = z0 - k2 + 0.3333333333333333D;
/* 195 */     double x3 = x0 - 1.0D + 0.5D;
/* 196 */     double y3 = y0 - 1.0D + 0.5D;
/* 197 */     double z3 = z0 - 1.0D + 0.5D;
/*     */     
/* 199 */     int ii = i & 0xFF;
/* 200 */     int jj = j & 0xFF;
/* 201 */     int kk = k & 0xFF;
/* 202 */     int gi0 = this.permMod12[ii + this.perm[jj + this.perm[kk]]];
/* 203 */     int gi1 = this.permMod12[ii + i1 + this.perm[jj + j1 + this.perm[kk + k1]]];
/* 204 */     int gi2 = this.permMod12[ii + i2 + this.perm[jj + j2 + this.perm[kk + k2]]];
/* 205 */     int gi3 = this.permMod12[ii + 1 + this.perm[jj + 1 + this.perm[kk + 1]]];
/*     */     
/* 207 */     double t0 = 0.6D - x0 * x0 - y0 * y0 - z0 * z0;
/* 208 */     if (t0 < 0.0D) { n0 = 0.0D; }
/*     */     else
/* 210 */     { t0 *= t0;
/* 211 */       n0 = t0 * t0 * dot(grad3[gi0], x0, y0, z0); }
/*     */     
/* 213 */     double t1 = 0.6D - x1 * x1 - y1 * y1 - z1 * z1;
/* 214 */     if (t1 < 0.0D) { n1 = 0.0D; }
/*     */     else
/* 216 */     { t1 *= t1;
/* 217 */       n1 = t1 * t1 * dot(grad3[gi1], x1, y1, z1); }
/*     */     
/* 219 */     double t2 = 0.6D - x2 * x2 - y2 * y2 - z2 * z2;
/* 220 */     if (t2 < 0.0D) { n2 = 0.0D; }
/*     */     else
/* 222 */     { t2 *= t2;
/* 223 */       n2 = t2 * t2 * dot(grad3[gi2], x2, y2, z2); }
/*     */     
/* 225 */     double t3 = 0.6D - x3 * x3 - y3 * y3 - z3 * z3;
/* 226 */     if (t3 < 0.0D) { n3 = 0.0D; }
/*     */     else
/* 228 */     { t3 *= t3;
/* 229 */       n3 = t3 * t3 * dot(grad3[gi3], x3, y3, z3); }
/*     */ 
/*     */ 
/*     */     
/* 233 */     return 32.0D * (n0 + n1 + n2 + n3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double noise(double x, double y, double z, double w) {
/* 242 */     double n0, n1, n2, n3, n4, s = (x + y + z + w) * F4;
/* 243 */     int i = fastfloor(x + s);
/* 244 */     int j = fastfloor(y + s);
/* 245 */     int k = fastfloor(z + s);
/* 246 */     int l = fastfloor(w + s);
/* 247 */     double t = (i + j + k + l) * G4;
/* 248 */     double X0 = i - t;
/* 249 */     double Y0 = j - t;
/* 250 */     double Z0 = k - t;
/* 251 */     double W0 = l - t;
/* 252 */     double x0 = x - X0;
/* 253 */     double y0 = y - Y0;
/* 254 */     double z0 = z - Z0;
/* 255 */     double w0 = w - W0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     int rankx = 0;
/* 262 */     int ranky = 0;
/* 263 */     int rankz = 0;
/* 264 */     int rankw = 0;
/* 265 */     if (x0 > y0) { rankx++; } else { ranky++; }
/* 266 */      if (x0 > z0) { rankx++; } else { rankz++; }
/* 267 */      if (x0 > w0) { rankx++; } else { rankw++; }
/* 268 */      if (y0 > z0) { ranky++; } else { rankz++; }
/* 269 */      if (y0 > w0) { ranky++; } else { rankw++; }
/* 270 */      if (z0 > w0) { rankz++; } else { rankw++; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     int i1 = (rankx >= 3) ? 1 : 0;
/* 280 */     int j1 = (ranky >= 3) ? 1 : 0;
/* 281 */     int k1 = (rankz >= 3) ? 1 : 0;
/* 282 */     int l1 = (rankw >= 3) ? 1 : 0;
/*     */     
/* 284 */     int i2 = (rankx >= 2) ? 1 : 0;
/* 285 */     int j2 = (ranky >= 2) ? 1 : 0;
/* 286 */     int k2 = (rankz >= 2) ? 1 : 0;
/* 287 */     int l2 = (rankw >= 2) ? 1 : 0;
/*     */     
/* 289 */     int i3 = (rankx >= 1) ? 1 : 0;
/* 290 */     int j3 = (ranky >= 1) ? 1 : 0;
/* 291 */     int k3 = (rankz >= 1) ? 1 : 0;
/* 292 */     int l3 = (rankw >= 1) ? 1 : 0;
/*     */     
/* 294 */     double x1 = x0 - i1 + G4;
/* 295 */     double y1 = y0 - j1 + G4;
/* 296 */     double z1 = z0 - k1 + G4;
/* 297 */     double w1 = w0 - l1 + G4;
/* 298 */     double x2 = x0 - i2 + 2.0D * G4;
/* 299 */     double y2 = y0 - j2 + 2.0D * G4;
/* 300 */     double z2 = z0 - k2 + 2.0D * G4;
/* 301 */     double w2 = w0 - l2 + 2.0D * G4;
/* 302 */     double x3 = x0 - i3 + 3.0D * G4;
/* 303 */     double y3 = y0 - j3 + 3.0D * G4;
/* 304 */     double z3 = z0 - k3 + 3.0D * G4;
/* 305 */     double w3 = w0 - l3 + 3.0D * G4;
/* 306 */     double x4 = x0 - 1.0D + 4.0D * G4;
/* 307 */     double y4 = y0 - 1.0D + 4.0D * G4;
/* 308 */     double z4 = z0 - 1.0D + 4.0D * G4;
/* 309 */     double w4 = w0 - 1.0D + 4.0D * G4;
/*     */     
/* 311 */     int ii = i & 0xFF;
/* 312 */     int jj = j & 0xFF;
/* 313 */     int kk = k & 0xFF;
/* 314 */     int ll = l & 0xFF;
/* 315 */     int gi0 = this.perm[ii + this.perm[jj + this.perm[kk + this.perm[ll]]]] % 32;
/* 316 */     int gi1 = this.perm[ii + i1 + this.perm[jj + j1 + this.perm[kk + k1 + this.perm[ll + l1]]]] % 32;
/* 317 */     int gi2 = this.perm[ii + i2 + this.perm[jj + j2 + this.perm[kk + k2 + this.perm[ll + l2]]]] % 32;
/* 318 */     int gi3 = this.perm[ii + i3 + this.perm[jj + j3 + this.perm[kk + k3 + this.perm[ll + l3]]]] % 32;
/* 319 */     int gi4 = this.perm[ii + 1 + this.perm[jj + 1 + this.perm[kk + 1 + this.perm[ll + 1]]]] % 32;
/*     */     
/* 321 */     double t0 = 0.6D - x0 * x0 - y0 * y0 - z0 * z0 - w0 * w0;
/* 322 */     if (t0 < 0.0D) { n0 = 0.0D; }
/*     */     else
/* 324 */     { t0 *= t0;
/* 325 */       n0 = t0 * t0 * dot(grad4[gi0], x0, y0, z0, w0); }
/*     */     
/* 327 */     double t1 = 0.6D - x1 * x1 - y1 * y1 - z1 * z1 - w1 * w1;
/* 328 */     if (t1 < 0.0D) { n1 = 0.0D; }
/*     */     else
/* 330 */     { t1 *= t1;
/* 331 */       n1 = t1 * t1 * dot(grad4[gi1], x1, y1, z1, w1); }
/*     */     
/* 333 */     double t2 = 0.6D - x2 * x2 - y2 * y2 - z2 * z2 - w2 * w2;
/* 334 */     if (t2 < 0.0D) { n2 = 0.0D; }
/*     */     else
/* 336 */     { t2 *= t2;
/* 337 */       n2 = t2 * t2 * dot(grad4[gi2], x2, y2, z2, w2); }
/*     */     
/* 339 */     double t3 = 0.6D - x3 * x3 - y3 * y3 - z3 * z3 - w3 * w3;
/* 340 */     if (t3 < 0.0D) { n3 = 0.0D; }
/*     */     else
/* 342 */     { t3 *= t3;
/* 343 */       n3 = t3 * t3 * dot(grad4[gi3], x3, y3, z3, w3); }
/*     */     
/* 345 */     double t4 = 0.6D - x4 * x4 - y4 * y4 - z4 * z4 - w4 * w4;
/* 346 */     if (t4 < 0.0D) { n4 = 0.0D; }
/*     */     else
/* 348 */     { t4 *= t4;
/* 349 */       n4 = t4 * t4 * dot(grad4[gi4], x4, y4, z4, w4); }
/*     */ 
/*     */     
/* 352 */     return 27.0D * (n0 + n1 + n2 + n3 + n4);
/*     */   }
/*     */   
/*     */   private static class Grad
/*     */   {
/*     */     private double x;
/*     */     private double y;
/*     */     private double z;
/*     */     private double w;
/*     */     
/*     */     Grad(double x, double y, double z) {
/* 363 */       this.x = x;
/* 364 */       this.y = y;
/* 365 */       this.z = z;
/*     */     }
/*     */ 
/*     */     
/*     */     Grad(double x, double y, double z, double w) {
/* 370 */       this.x = x;
/* 371 */       this.y = y;
/* 372 */       this.z = z;
/* 373 */       this.w = w;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Util\SimplexNoise_Octave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */