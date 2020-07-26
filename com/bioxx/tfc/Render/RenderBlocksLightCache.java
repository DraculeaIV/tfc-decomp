/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import java.util.EnumSet;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ public class RenderBlocksLightCache
/*     */   extends RenderBlocksFixUV
/*     */ {
/*  14 */   private EnumSet<ForgeDirection> facesToDraw = EnumSet.allOf(ForgeDirection.class);
/*     */   
/*  16 */   private RenderFaceData[] sides = new RenderFaceData[6];
/*     */ 
/*     */   
/*     */   private static class RenderPointData
/*     */   {
/*     */     private int brightness;
/*     */     private float r;
/*     */     private float g;
/*     */     private float b;
/*     */     
/*     */     private RenderPointData() {}
/*     */   }
/*     */   
/*     */   private static class RenderFaceData
/*     */   {
/*     */     private int cacheBrightnessTopLeft;
/*     */     private int cacheBrightnessBottomLeft;
/*     */     private int cacheBrightnessBottomRight;
/*     */     private int cacheBrightnessTopRight;
/*     */     private float cacheColorRedTopLeft;
/*     */     private float cacheColorRedBottomLeft;
/*     */     private float cacheColorRedBottomRight;
/*     */     private float cacheColorRedTopRight;
/*     */     private float cacheColorGreenTopLeft;
/*     */     private float cacheColorGreenBottomLeft;
/*     */     private float cacheColorGreenBottomRight;
/*     */     private float cacheColorGreenTopRight;
/*     */     private float cacheColorBlueTopLeft;
/*     */     private float cacheColorBlueBottomLeft;
/*     */     private float cacheColorBlueBottomRight;
/*     */     private float cacheColorBlueTopRight;
/*     */     
/*     */     public RenderFaceData(RenderBlocks rb) {
/*  49 */       this.cacheBrightnessTopLeft = rb.field_147864_al;
/*  50 */       this.cacheBrightnessBottomLeft = rb.field_147874_am;
/*  51 */       this.cacheBrightnessBottomRight = rb.field_147876_an;
/*  52 */       this.cacheBrightnessTopRight = rb.field_147870_ao;
/*     */       
/*  54 */       this.cacheColorRedTopLeft = rb.field_147872_ap;
/*  55 */       this.cacheColorRedBottomLeft = rb.field_147852_aq;
/*  56 */       this.cacheColorRedBottomRight = rb.field_147850_ar;
/*  57 */       this.cacheColorRedTopRight = rb.field_147848_as;
/*     */       
/*  59 */       this.cacheColorGreenTopLeft = rb.field_147846_at;
/*  60 */       this.cacheColorGreenBottomLeft = rb.field_147860_au;
/*  61 */       this.cacheColorGreenBottomRight = rb.field_147858_av;
/*  62 */       this.cacheColorGreenTopRight = rb.field_147856_aw;
/*     */       
/*  64 */       this.cacheColorBlueTopLeft = rb.field_147854_ax;
/*  65 */       this.cacheColorBlueBottomLeft = rb.field_147841_ay;
/*  66 */       this.cacheColorBlueBottomRight = rb.field_147839_az;
/*  67 */       this.cacheColorBlueTopRight = rb.field_147833_aA;
/*     */     }
/*     */ 
/*     */     
/*     */     public RenderBlocksLightCache.RenderPointData getCachedValue(double leftRight, double topBottom) {
/*  72 */       RenderBlocksLightCache.RenderPointData o = new RenderBlocksLightCache.RenderPointData();
/*     */ 
/*     */       
/*  75 */       double rTop = this.cacheColorRedTopLeft * leftRight + (1.0D - leftRight) * this.cacheColorRedTopRight;
/*  76 */       double rBottom = this.cacheColorRedBottomLeft * leftRight + (1.0D - leftRight) * this.cacheColorRedBottomRight;
/*  77 */       o.r = (float)(rTop * topBottom + rBottom * (1.0D - topBottom));
/*     */       
/*  79 */       double gTop = this.cacheColorGreenTopLeft * leftRight + (1.0D - leftRight) * this.cacheColorGreenTopRight;
/*  80 */       double gBottom = this.cacheColorGreenBottomLeft * leftRight + (1.0D - leftRight) * this.cacheColorGreenBottomRight;
/*  81 */       o.g = (float)(gTop * topBottom + gBottom * (1.0D - topBottom));
/*     */       
/*  83 */       double bTop = this.cacheColorBlueTopLeft * leftRight + (1.0D - leftRight) * this.cacheColorBlueTopRight;
/*  84 */       double bBottom = this.cacheColorBlueBottomLeft * leftRight + (1.0D - leftRight) * this.cacheColorBlueBottomRight;
/*  85 */       o.b = (float)(bTop * topBottom + bBottom * (1.0D - topBottom));
/*     */ 
/*     */       
/*  88 */       double highTop = (this.cacheBrightnessTopLeft >> 16 & 0xFF) * leftRight + (1.0D - leftRight) * (this.cacheBrightnessTopRight >> 16 & 0xFF);
/*  89 */       double highBottom = (this.cacheBrightnessBottomLeft >> 16 & 0xFF) * leftRight + (1.0D - leftRight) * (this.cacheBrightnessBottomRight >> 16 & 0xFF);
/*  90 */       int high = (int)(highTop * topBottom + highBottom * (1.0D - topBottom)) & 0xFF;
/*     */       
/*  92 */       double lowTop = (this.cacheBrightnessTopLeft & 0xFF) * leftRight + (1.0D - leftRight) * (this.cacheBrightnessTopRight & 0xFF);
/*  93 */       double lowBottom = (this.cacheBrightnessBottomLeft & 0xFF) * leftRight + (1.0D - leftRight) * (this.cacheBrightnessBottomRight & 0xFF);
/*  94 */       int low = (int)(lowTop * topBottom + lowBottom * (1.0D - topBottom)) & 0xFF;
/*     */ 
/*     */       
/*  97 */       o.brightness = high << 16 | low;
/*     */       
/*  99 */       return o;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderBlocksLightCache(RenderBlocks old) {
/* 106 */     super(old);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disableRender() {
/* 114 */     this.facesToDraw = EnumSet.noneOf(ForgeDirection.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void enableRender() {
/* 119 */     this.facesToDraw = EnumSet.allOf(ForgeDirection.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147761_c(Block a, double b, double c, double d, IIcon e) {
/* 129 */     if (!this.facesToDraw.contains(ForgeDirection.NORTH)) {
/*     */       
/* 131 */       saveData(ForgeDirection.NORTH);
/*     */       
/*     */       return;
/*     */     } 
/* 135 */     super.func_147761_c(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147764_f(Block a, double b, double c, double d, IIcon e) {
/* 141 */     if (!this.facesToDraw.contains(ForgeDirection.EAST)) {
/*     */       
/* 143 */       saveData(ForgeDirection.EAST);
/*     */       
/*     */       return;
/*     */     } 
/* 147 */     super.func_147764_f(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147798_e(Block a, double b, double c, double d, IIcon e) {
/* 154 */     if (!this.facesToDraw.contains(ForgeDirection.WEST)) {
/*     */       
/* 156 */       saveData(ForgeDirection.WEST);
/*     */       
/*     */       return;
/*     */     } 
/* 160 */     super.func_147798_e(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147768_a(Block a, double b, double c, double d, IIcon e) {
/* 166 */     if (!this.facesToDraw.contains(ForgeDirection.DOWN)) {
/*     */       
/* 168 */       saveData(ForgeDirection.DOWN);
/*     */       
/*     */       return;
/*     */     } 
/* 172 */     super.func_147768_a(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147806_b(Block a, double b, double c, double d, IIcon e) {
/* 178 */     if (!this.facesToDraw.contains(ForgeDirection.UP)) {
/*     */       
/* 180 */       saveData(ForgeDirection.UP);
/*     */       
/*     */       return;
/*     */     } 
/* 184 */     super.func_147806_b(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147734_d(Block a, double b, double c, double d, IIcon e) {
/* 190 */     if (!this.facesToDraw.contains(ForgeDirection.SOUTH)) {
/*     */       
/* 192 */       saveData(ForgeDirection.SOUTH);
/*     */       
/*     */       return;
/*     */     } 
/* 196 */     super.func_147734_d(a, b, c, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   private void saveData(ForgeDirection side) {
/* 201 */     this.sides[side.ordinal()] = new RenderFaceData(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderCachedBlock(Block block, int i, int j, int k, IIcon myTexture) {
/* 206 */     this.field_147863_w = Minecraft.func_71379_u();
/*     */ 
/*     */ 
/*     */     
/* 210 */     RenderPointData rpd = this.sides[ForgeDirection.EAST.ordinal()].getCachedValue(1.0D - this.field_147857_k, this.field_147853_m);
/* 211 */     this.field_147872_ap = rpd.r;
/* 212 */     this.field_147846_at = rpd.g;
/* 213 */     this.field_147854_ax = rpd.b;
/* 214 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 216 */     rpd = this.sides[ForgeDirection.EAST.ordinal()].getCachedValue(1.0D - this.field_147855_j, this.field_147853_m);
/* 217 */     this.field_147848_as = rpd.r;
/* 218 */     this.field_147856_aw = rpd.g;
/* 219 */     this.field_147833_aA = rpd.b;
/* 220 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 222 */     rpd = this.sides[ForgeDirection.EAST.ordinal()].getCachedValue(1.0D - this.field_147855_j, this.field_147851_l);
/* 223 */     this.field_147850_ar = rpd.r;
/* 224 */     this.field_147858_av = rpd.g;
/* 225 */     this.field_147839_az = rpd.b;
/* 226 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 228 */     rpd = this.sides[ForgeDirection.EAST.ordinal()].getCachedValue(1.0D - this.field_147857_k, this.field_147851_l);
/* 229 */     this.field_147852_aq = rpd.r;
/* 230 */     this.field_147860_au = rpd.g;
/* 231 */     this.field_147841_ay = rpd.b;
/* 232 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 234 */     func_147764_f(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 237 */     rpd = this.sides[ForgeDirection.WEST.ordinal()].getCachedValue(this.field_147857_k, this.field_147853_m);
/* 238 */     this.field_147872_ap = rpd.r;
/* 239 */     this.field_147846_at = rpd.g;
/* 240 */     this.field_147854_ax = rpd.b;
/* 241 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 243 */     rpd = this.sides[ForgeDirection.WEST.ordinal()].getCachedValue(this.field_147857_k, this.field_147851_l);
/* 244 */     this.field_147852_aq = rpd.r;
/* 245 */     this.field_147860_au = rpd.g;
/* 246 */     this.field_147841_ay = rpd.b;
/* 247 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 249 */     rpd = this.sides[ForgeDirection.WEST.ordinal()].getCachedValue(this.field_147855_j, this.field_147851_l);
/* 250 */     this.field_147850_ar = rpd.r;
/* 251 */     this.field_147858_av = rpd.g;
/* 252 */     this.field_147839_az = rpd.b;
/* 253 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 255 */     rpd = this.sides[ForgeDirection.WEST.ordinal()].getCachedValue(this.field_147855_j, this.field_147853_m);
/* 256 */     this.field_147848_as = rpd.r;
/* 257 */     this.field_147856_aw = rpd.g;
/* 258 */     this.field_147833_aA = rpd.b;
/* 259 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 261 */     func_147798_e(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 264 */     rpd = this.sides[ForgeDirection.SOUTH.ordinal()].getCachedValue(1.0D - this.field_147859_h, this.field_147857_k);
/* 265 */     this.field_147872_ap = rpd.r;
/* 266 */     this.field_147846_at = rpd.g;
/* 267 */     this.field_147854_ax = rpd.b;
/* 268 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 270 */     rpd = this.sides[ForgeDirection.SOUTH.ordinal()].getCachedValue(1.0D - this.field_147859_h, this.field_147855_j);
/* 271 */     this.field_147852_aq = rpd.r;
/* 272 */     this.field_147860_au = rpd.g;
/* 273 */     this.field_147841_ay = rpd.b;
/* 274 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 276 */     rpd = this.sides[ForgeDirection.SOUTH.ordinal()].getCachedValue(1.0D - this.field_147861_i, this.field_147855_j);
/* 277 */     this.field_147850_ar = rpd.r;
/* 278 */     this.field_147858_av = rpd.g;
/* 279 */     this.field_147839_az = rpd.b;
/* 280 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 282 */     rpd = this.sides[ForgeDirection.SOUTH.ordinal()].getCachedValue(1.0D - this.field_147861_i, this.field_147857_k);
/* 283 */     this.field_147848_as = rpd.r;
/* 284 */     this.field_147856_aw = rpd.g;
/* 285 */     this.field_147833_aA = rpd.b;
/* 286 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 288 */     func_147734_d(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 291 */     rpd = this.sides[ForgeDirection.NORTH.ordinal()].getCachedValue(this.field_147857_k, 1.0D - this.field_147859_h);
/* 292 */     this.field_147872_ap = rpd.r;
/* 293 */     this.field_147846_at = rpd.g;
/* 294 */     this.field_147854_ax = rpd.b;
/* 295 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 297 */     rpd = this.sides[ForgeDirection.NORTH.ordinal()].getCachedValue(this.field_147857_k, 1.0D - this.field_147861_i);
/* 298 */     this.field_147848_as = rpd.r;
/* 299 */     this.field_147856_aw = rpd.g;
/* 300 */     this.field_147833_aA = rpd.b;
/* 301 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 303 */     rpd = this.sides[ForgeDirection.NORTH.ordinal()].getCachedValue(this.field_147855_j, 1.0D - this.field_147861_i);
/* 304 */     this.field_147850_ar = rpd.r;
/* 305 */     this.field_147858_av = rpd.g;
/* 306 */     this.field_147839_az = rpd.b;
/* 307 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 309 */     rpd = this.sides[ForgeDirection.NORTH.ordinal()].getCachedValue(this.field_147855_j, 1.0D - this.field_147859_h);
/* 310 */     this.field_147852_aq = rpd.r;
/* 311 */     this.field_147860_au = rpd.g;
/* 312 */     this.field_147841_ay = rpd.b;
/* 313 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 315 */     func_147761_c(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 318 */     rpd = this.sides[ForgeDirection.UP.ordinal()].getCachedValue(this.field_147861_i, this.field_147853_m);
/* 319 */     this.field_147872_ap = rpd.r;
/* 320 */     this.field_147846_at = rpd.g;
/* 321 */     this.field_147854_ax = rpd.b;
/* 322 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 324 */     rpd = this.sides[ForgeDirection.UP.ordinal()].getCachedValue(this.field_147861_i, this.field_147851_l);
/* 325 */     this.field_147852_aq = rpd.r;
/* 326 */     this.field_147860_au = rpd.g;
/* 327 */     this.field_147841_ay = rpd.b;
/* 328 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 330 */     rpd = this.sides[ForgeDirection.UP.ordinal()].getCachedValue(this.field_147859_h, this.field_147851_l);
/* 331 */     this.field_147850_ar = rpd.r;
/* 332 */     this.field_147858_av = rpd.g;
/* 333 */     this.field_147839_az = rpd.b;
/* 334 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 336 */     rpd = this.sides[ForgeDirection.UP.ordinal()].getCachedValue(this.field_147859_h, this.field_147853_m);
/* 337 */     this.field_147848_as = rpd.r;
/* 338 */     this.field_147856_aw = rpd.g;
/* 339 */     this.field_147833_aA = rpd.b;
/* 340 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 342 */     func_147806_b(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 345 */     rpd = this.sides[ForgeDirection.DOWN.ordinal()].getCachedValue(1.0D - this.field_147859_h, this.field_147853_m);
/* 346 */     this.field_147872_ap = rpd.r;
/* 347 */     this.field_147846_at = rpd.g;
/* 348 */     this.field_147854_ax = rpd.b;
/* 349 */     this.field_147864_al = rpd.brightness;
/*     */     
/* 351 */     rpd = this.sides[ForgeDirection.DOWN.ordinal()].getCachedValue(1.0D - this.field_147859_h, this.field_147851_l);
/* 352 */     this.field_147852_aq = rpd.r;
/* 353 */     this.field_147860_au = rpd.g;
/* 354 */     this.field_147841_ay = rpd.b;
/* 355 */     this.field_147874_am = rpd.brightness;
/*     */     
/* 357 */     rpd = this.sides[ForgeDirection.DOWN.ordinal()].getCachedValue(1.0D - this.field_147861_i, this.field_147851_l);
/* 358 */     this.field_147850_ar = rpd.r;
/* 359 */     this.field_147858_av = rpd.g;
/* 360 */     this.field_147839_az = rpd.b;
/* 361 */     this.field_147876_an = rpd.brightness;
/*     */     
/* 363 */     rpd = this.sides[ForgeDirection.DOWN.ordinal()].getCachedValue(1.0D - this.field_147861_i, this.field_147853_m);
/* 364 */     this.field_147848_as = rpd.r;
/* 365 */     this.field_147856_aw = rpd.g;
/* 366 */     this.field_147833_aA = rpd.b;
/* 367 */     this.field_147870_ao = rpd.brightness;
/*     */     
/* 369 */     func_147768_a(block, i, j, k, myTexture);
/*     */ 
/*     */     
/* 372 */     this.field_147863_w = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderBlocksLightCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */