/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ 
/*     */ public class RenderBlocksFixUV
/*     */   extends RenderBlocks
/*     */ {
/*     */   public RenderBlocksFixUV(RenderBlocks old) {
/*  13 */     this.field_147845_a = old.field_147845_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(RenderBlocks old) {
/*  18 */     this.field_147845_a = old.field_147845_a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147761_c(Block par1Block, double par2, double par4, double par6, IIcon par8Icon) {
/*  24 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/*  26 */     if (func_147744_b())
/*     */     {
/*  28 */       par8Icon = this.field_147840_d;
/*     */     }
/*     */     
/*  31 */     double d3 = par8Icon.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/*  32 */     double d4 = par8Icon.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/*  33 */     double d5 = par8Icon.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/*  34 */     double d6 = par8Icon.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*     */ 
/*     */     
/*  37 */     if (this.field_147842_e) {
/*     */       
/*  39 */       double d = d3;
/*  40 */       d3 = d4;
/*  41 */       d4 = d;
/*     */     } 
/*     */     
/*  44 */     if (this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
/*     */       
/*  46 */       d3 = par8Icon.func_94209_e();
/*  47 */       d4 = par8Icon.func_94212_f();
/*     */     } 
/*     */     
/*  50 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/*     */       
/*  52 */       d5 = par8Icon.func_94206_g();
/*  53 */       d6 = par8Icon.func_94210_h();
/*     */     } 
/*     */     
/*  56 */     double d7 = d4;
/*  57 */     double d8 = d3;
/*  58 */     double d9 = d5;
/*  59 */     double d10 = d6;
/*     */     
/*  61 */     if (this.field_147875_q == 2) {
/*     */       
/*  63 */       d3 = par8Icon.func_94214_a(this.field_147855_j * 16.0D);
/*  64 */       d5 = par8Icon.func_94207_b(16.0D - this.field_147859_h * 16.0D);
/*  65 */       d4 = par8Icon.func_94214_a(this.field_147857_k * 16.0D);
/*  66 */       d6 = par8Icon.func_94207_b(16.0D - this.field_147861_i * 16.0D);
/*  67 */       d9 = d5;
/*  68 */       d10 = d6;
/*  69 */       d7 = d3;
/*  70 */       d8 = d4;
/*  71 */       d5 = d6;
/*  72 */       d6 = d9;
/*     */     }
/*  74 */     else if (this.field_147875_q == 1) {
/*     */       
/*  76 */       d3 = par8Icon.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/*  77 */       d5 = par8Icon.func_94207_b(this.field_147861_i * 16.0D);
/*  78 */       d4 = par8Icon.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/*  79 */       d6 = par8Icon.func_94207_b(this.field_147859_h * 16.0D);
/*  80 */       d7 = d4;
/*  81 */       d8 = d3;
/*  82 */       d3 = d4;
/*  83 */       d4 = d8;
/*  84 */       d9 = d6;
/*  85 */       d10 = d5;
/*     */     }
/*  87 */     else if (this.field_147875_q == 3) {
/*     */       
/*  89 */       d3 = par8Icon.func_94214_a(16.0D - this.field_147859_h * 16.0D);
/*  90 */       d4 = par8Icon.func_94214_a(16.0D - this.field_147861_i * 16.0D);
/*  91 */       d5 = par8Icon.func_94207_b(this.field_147857_k * 16.0D);
/*  92 */       d6 = par8Icon.func_94207_b(this.field_147855_j * 16.0D);
/*  93 */       d7 = d4;
/*  94 */       d8 = d3;
/*  95 */       d9 = d5;
/*  96 */       d10 = d6;
/*     */     } 
/*     */     
/*  99 */     double d11 = par2 + this.field_147859_h;
/* 100 */     double d12 = par2 + this.field_147861_i;
/* 101 */     double d13 = par4 + this.field_147855_j;
/* 102 */     double d14 = par4 + this.field_147857_k;
/* 103 */     double d15 = par6 + this.field_147851_l;
/*     */     
/* 105 */     if (this.field_147863_w) {
/*     */       
/* 107 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 108 */       tessellator.func_78380_c(this.field_147864_al);
/* 109 */       tessellator.func_78374_a(d11, d14, d15, d3, d5);
/* 110 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 111 */       tessellator.func_78380_c(this.field_147870_ao);
/* 112 */       tessellator.func_78374_a(d12, d14, d15, d7, d9);
/* 113 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 114 */       tessellator.func_78380_c(this.field_147876_an);
/* 115 */       tessellator.func_78374_a(d12, d13, d15, d4, d6);
/* 116 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 117 */       tessellator.func_78380_c(this.field_147874_am);
/* 118 */       tessellator.func_78374_a(d11, d13, d15, d8, d10);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */       
/* 127 */       tessellator.func_78374_a(d11, d14, d15, d3, d5);
/* 128 */       tessellator.func_78374_a(d12, d14, d15, d7, d9);
/* 129 */       tessellator.func_78374_a(d12, d13, d15, d4, d6);
/* 130 */       tessellator.func_78374_a(d11, d13, d15, d8, d10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147764_f(Block par1Block, double par2, double par4, double par6, IIcon par8Icon) {
/* 137 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 139 */     if (func_147744_b())
/*     */     {
/* 141 */       par8Icon = this.field_147840_d;
/*     */     }
/*     */     
/* 144 */     double d3 = par8Icon.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 145 */     double d4 = par8Icon.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 146 */     double d5 = par8Icon.func_94207_b(16.0D - this.field_147857_k * 16.0D);
/* 147 */     double d6 = par8Icon.func_94207_b(16.0D - this.field_147855_j * 16.0D);
/*     */ 
/*     */     
/* 150 */     if (this.field_147842_e) {
/*     */       
/* 152 */       double d = d3;
/* 153 */       d3 = d4;
/* 154 */       d4 = d;
/*     */     } 
/*     */     
/* 157 */     if (this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
/*     */       
/* 159 */       d3 = par8Icon.func_94209_e();
/* 160 */       d4 = par8Icon.func_94212_f();
/*     */     } 
/*     */     
/* 163 */     if (this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
/*     */       
/* 165 */       d5 = par8Icon.func_94206_g();
/* 166 */       d6 = par8Icon.func_94210_h();
/*     */     } 
/*     */     
/* 169 */     double d7 = d4;
/* 170 */     double d8 = d3;
/* 171 */     double d9 = d5;
/* 172 */     double d10 = d6;
/*     */     
/* 174 */     if (this.field_147871_s == 2) {
/*     */       
/* 176 */       d3 = par8Icon.func_94214_a(this.field_147855_j * 16.0D);
/* 177 */       d5 = par8Icon.func_94207_b(16.0D - this.field_147851_l * 16.0D);
/* 178 */       d4 = par8Icon.func_94214_a(this.field_147857_k * 16.0D);
/* 179 */       d6 = par8Icon.func_94207_b(16.0D - this.field_147853_m * 16.0D);
/* 180 */       d9 = d5;
/* 181 */       d10 = d6;
/* 182 */       d7 = d3;
/* 183 */       d8 = d4;
/* 184 */       d5 = d6;
/* 185 */       d6 = d9;
/*     */     }
/* 187 */     else if (this.field_147871_s == 1) {
/*     */       
/* 189 */       d3 = par8Icon.func_94214_a(16.0D - this.field_147857_k * 16.0D);
/* 190 */       d5 = par8Icon.func_94207_b(this.field_147853_m * 16.0D);
/* 191 */       d4 = par8Icon.func_94214_a(16.0D - this.field_147855_j * 16.0D);
/* 192 */       d6 = par8Icon.func_94207_b(this.field_147851_l * 16.0D);
/* 193 */       d7 = d4;
/* 194 */       d8 = d3;
/* 195 */       d3 = d4;
/* 196 */       d4 = d8;
/* 197 */       d9 = d6;
/* 198 */       d10 = d5;
/*     */     }
/* 200 */     else if (this.field_147871_s == 3) {
/*     */       
/* 202 */       d3 = par8Icon.func_94214_a(16.0D - this.field_147851_l * 16.0D);
/* 203 */       d4 = par8Icon.func_94214_a(16.0D - this.field_147853_m * 16.0D);
/* 204 */       d5 = par8Icon.func_94207_b(this.field_147857_k * 16.0D);
/* 205 */       d6 = par8Icon.func_94207_b(this.field_147855_j * 16.0D);
/* 206 */       d7 = d4;
/* 207 */       d8 = d3;
/* 208 */       d9 = d5;
/* 209 */       d10 = d6;
/*     */     } 
/*     */     
/* 212 */     double d11 = par2 + this.field_147861_i;
/* 213 */     double d12 = par4 + this.field_147855_j;
/* 214 */     double d13 = par4 + this.field_147857_k;
/* 215 */     double d14 = par6 + this.field_147851_l;
/* 216 */     double d15 = par6 + this.field_147853_m;
/*     */     
/* 218 */     if (this.field_147863_w) {
/*     */       
/* 220 */       tessellator.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
/* 221 */       tessellator.func_78380_c(this.field_147864_al);
/* 222 */       tessellator.func_78374_a(d11, d13, d15, d7, d9);
/* 223 */       tessellator.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
/* 224 */       tessellator.func_78380_c(this.field_147870_ao);
/* 225 */       tessellator.func_78374_a(d11, d12, d15, d4, d6);
/* 226 */       tessellator.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
/* 227 */       tessellator.func_78380_c(this.field_147876_an);
/* 228 */       tessellator.func_78374_a(d11, d12, d14, d8, d10);
/* 229 */       tessellator.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
/* 230 */       tessellator.func_78380_c(this.field_147874_am);
/* 231 */       tessellator.func_78374_a(d11, d13, d14, d3, d5);
/*     */     }
/*     */     else {
/*     */       
/* 235 */       tessellator.func_78374_a(d11, d13, d15, d7, d9);
/* 236 */       tessellator.func_78374_a(d11, d12, d15, d4, d6);
/* 237 */       tessellator.func_78374_a(d11, d12, d14, d8, d10);
/* 238 */       tessellator.func_78374_a(d11, d13, d14, d3, d5);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderBlocksFixUV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */