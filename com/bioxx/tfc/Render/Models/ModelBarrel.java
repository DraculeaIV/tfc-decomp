/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.AxisAlignedBB;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBarrel
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer barrel;
/*     */   public ModelRenderer barrel2;
/*     */   public ModelRenderer barrel3;
/*     */   public ModelRenderer chestBelow;
/*     */   public ModelRenderer chestKnob;
/*     */   
/*     */   public ModelBarrel(int type) {
/*  35 */     this.barrel = (new ModelRenderer(this, 0 + type * 56, 0)).func_78787_b(952, 76);
/*  36 */     this.barrel2 = (new ModelRenderer(this, 0 + type * 56, 44)).func_78787_b(952, 76);
/*  37 */     this.barrel3 = (new ModelRenderer(this, 0 + type * 56, 44)).func_78787_b(952, 76);
/*     */     
/*  39 */     this.barrel.func_78793_a(16.0F, 16.0F, 0.0F);
/*  40 */     this.barrel2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.barrel3.func_78793_a(0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/*  44 */     this.barrel.func_78790_a(1.0F, 0.0F, 1.0F, 14, 16, 14, 0.0F);
/*  45 */     this.barrel.field_78808_h = -3.1415927F;
/*  46 */     this.barrel2.func_78790_a(2.0F, 0.0F, 2.0F, 12, 16, 0, 0.0F);
/*  47 */     this.barrel2.func_78790_a(2.0F, 0.0F, 2.0F, 0, 16, 12, 0.0F);
/*  48 */     this.barrel2.func_78790_a(2.0F, 0.0F, 14.0F, 12, 16, 0, 0.0F);
/*  49 */     this.barrel2.func_78790_a(14.0F, 0.0F, 2.0F, 0, 16, 12, 0.0F);
/*  50 */     this.barrel3.func_78790_a(2.0F, 2.0F, 2.0F, 12, 12, 12, 0.0F);
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
/*     */   public void drawBox(AxisAlignedBB par1AxisAlignedBB) {
/*  73 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */ 
/*     */     
/*  76 */     var2.func_78371_b(7);
/*  77 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/*  78 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/*  79 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/*  80 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/*  81 */     var2.func_78381_a();
/*     */ 
/*     */     
/*  84 */     var2.func_78371_b(7);
/*  85 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/*  86 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/*  87 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/*  88 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/*  89 */     var2.func_78381_a();
/*     */ 
/*     */     
/*  92 */     var2.func_78371_b(7);
/*  93 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/*  94 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/*  95 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/*  96 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/*  97 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 100 */     var2.func_78371_b(7);
/* 101 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 102 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/* 103 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/* 104 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 105 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 108 */     var2.func_78371_b(7);
/* 109 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 110 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/* 111 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c + 0.1D);
/* 112 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 113 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 116 */     var2.func_78371_b(7);
/* 117 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 118 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d - 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/* 119 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a + 0.1D, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f - 0.1D);
/* 120 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 121 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBarrel() {
/* 131 */     this.barrel.func_78785_a(0.0625F);
/* 132 */     this.barrel2.func_78785_a(0.0625F);
/* 133 */     this.barrel3.func_78785_a(0.0625F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */