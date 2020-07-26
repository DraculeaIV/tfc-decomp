/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityWolfTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelWolfTFC
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer wolfHeadMain;
/*     */   public ModelRenderer wolfBody;
/*     */   public ModelRenderer wolfLeg1;
/*     */   public ModelRenderer wolfLeg2;
/*     */   public ModelRenderer wolfLeg3;
/*     */   public ModelRenderer wolfLeg4;
/*     */   private ModelRenderer wolfTail;
/*     */   private ModelRenderer wolfMane;
/*     */   
/*     */   public ModelWolfTFC() {
/*  43 */     float f = 0.0F;
/*  44 */     float f1 = 13.5F;
/*  45 */     this.wolfHeadMain = new ModelRenderer(this, 0, 0);
/*  46 */     this.wolfHeadMain.func_78790_a(-3.0F, -3.0F, -2.0F, 6, 6, 4, f);
/*  47 */     this.wolfHeadMain.func_78793_a(-1.0F, f1, -7.0F);
/*  48 */     this.wolfBody = new ModelRenderer(this, 18, 14);
/*  49 */     this.wolfBody.func_78790_a(-4.0F, -2.0F, -3.0F, 6, 9, 6, f);
/*  50 */     this.wolfBody.func_78793_a(0.0F, 14.0F, 2.0F);
/*  51 */     this.wolfMane = new ModelRenderer(this, 21, 0);
/*  52 */     this.wolfMane.func_78790_a(-4.0F, -3.0F, -3.0F, 8, 6, 7, f);
/*  53 */     this.wolfMane.func_78793_a(-1.0F, 14.0F, 2.0F);
/*  54 */     this.wolfLeg1 = new ModelRenderer(this, 0, 18);
/*  55 */     this.wolfLeg1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
/*  56 */     this.wolfLeg1.func_78793_a(-2.5F, 16.0F, 7.0F);
/*  57 */     this.wolfLeg2 = new ModelRenderer(this, 0, 18);
/*  58 */     this.wolfLeg2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
/*  59 */     this.wolfLeg2.func_78793_a(0.5F, 16.0F, 7.0F);
/*  60 */     this.wolfLeg3 = new ModelRenderer(this, 0, 18);
/*  61 */     this.wolfLeg3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
/*  62 */     this.wolfLeg3.func_78793_a(-2.5F, 16.0F, -4.0F);
/*  63 */     this.wolfLeg4 = new ModelRenderer(this, 0, 18);
/*  64 */     this.wolfLeg4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
/*  65 */     this.wolfLeg4.func_78793_a(0.5F, 16.0F, -4.0F);
/*  66 */     this.wolfTail = new ModelRenderer(this, 9, 18);
/*  67 */     this.wolfTail.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
/*  68 */     this.wolfTail.func_78793_a(-1.0F, 12.0F, 8.0F);
/*  69 */     this.wolfHeadMain.func_78784_a(16, 14).func_78790_a(-3.0F, -5.0F, 0.0F, 2, 2, 1, f);
/*  70 */     this.wolfHeadMain.func_78784_a(16, 14).func_78790_a(1.0F, -5.0F, 0.0F, 2, 2, 1, f);
/*  71 */     this.wolfHeadMain.func_78784_a(0, 10).func_78790_a(-1.5F, 0.0F, -5.0F, 3, 3, 4, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  80 */     super.func_78088_a(entity, par2, par3, par4, par5, par6, par7);
/*  81 */     func_78087_a(par2, par3, par4, par5, par6, par7, entity);
/*     */     
/*  83 */     float percent = TFC_Core.getPercentGrown((IAnimal)entity);
/*  84 */     float ageScale = 2.0F - percent;
/*     */ 
/*     */     
/*  87 */     if (entity instanceof IAnimal) {
/*     */       
/*  89 */       GL11.glPushMatrix();
/*  90 */       GL11.glTranslatef(0.0F, 0.75F - 0.75F * percent, 0.0F);
/*  91 */       GL11.glScalef(1.0F / ageScale, 1.0F / ageScale, 1.0F / ageScale);
/*  92 */       this.wolfHeadMain.func_78791_b(par7);
/*  93 */       this.wolfBody.func_78785_a(par7);
/*  94 */       this.wolfLeg1.func_78785_a(par7);
/*  95 */       this.wolfLeg2.func_78785_a(par7);
/*  96 */       this.wolfLeg3.func_78785_a(par7);
/*  97 */       this.wolfLeg4.func_78785_a(par7);
/*  98 */       this.wolfTail.func_78791_b(par7);
/*  99 */       this.wolfMane.func_78785_a(par7);
/* 100 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78086_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
/* 107 */     EntityWolfTFC entitywolf = (EntityWolfTFC)par1EntityLivingBase;
/*     */     
/* 109 */     if (entitywolf.func_70919_bu()) {
/*     */       
/* 111 */       this.wolfTail.field_78796_g = 0.0F;
/*     */     }
/*     */     else {
/*     */       
/* 115 */       this.wolfTail.field_78796_g = MathHelper.func_76134_b(par2 * 0.6662F) * 1.4F * par3;
/*     */     } 
/* 117 */     if (entitywolf.func_70906_o()) {
/*     */       
/* 119 */       this.wolfMane.func_78793_a(-1.0F, 16.0F, -3.0F);
/* 120 */       this.wolfMane.field_78795_f = 1.2566371F;
/* 121 */       this.wolfMane.field_78796_g = 0.0F;
/* 122 */       this.wolfBody.func_78793_a(0.0F, 18.0F, 0.0F);
/* 123 */       this.wolfBody.field_78795_f = 0.7853982F;
/* 124 */       this.wolfTail.func_78793_a(-1.0F, 21.0F, 6.0F);
/* 125 */       this.wolfLeg1.func_78793_a(-2.5F, 22.0F, 2.0F);
/* 126 */       this.wolfLeg1.field_78795_f = 4.712389F;
/* 127 */       this.wolfLeg2.func_78793_a(0.5F, 22.0F, 2.0F);
/* 128 */       this.wolfLeg2.field_78795_f = 4.712389F;
/* 129 */       this.wolfLeg3.field_78795_f = 5.811947F;
/* 130 */       this.wolfLeg3.func_78793_a(-2.49F, 17.0F, -4.0F);
/* 131 */       this.wolfLeg4.field_78795_f = 5.811947F;
/* 132 */       this.wolfLeg4.func_78793_a(0.51F, 17.0F, -4.0F);
/*     */     }
/*     */     else {
/*     */       
/* 136 */       this.wolfBody.func_78793_a(0.0F, 14.0F, 2.0F);
/* 137 */       this.wolfBody.field_78795_f = 1.5707964F;
/* 138 */       this.wolfMane.func_78793_a(-1.0F, 14.0F, -3.0F);
/* 139 */       this.wolfMane.field_78795_f = this.wolfBody.field_78795_f;
/* 140 */       this.wolfTail.func_78793_a(-1.0F, 12.0F, 8.0F);
/* 141 */       this.wolfLeg1.func_78793_a(-2.5F, 16.0F, 7.0F);
/* 142 */       this.wolfLeg2.func_78793_a(0.5F, 16.0F, 7.0F);
/* 143 */       this.wolfLeg3.func_78793_a(-2.5F, 16.0F, -4.0F);
/* 144 */       this.wolfLeg4.func_78793_a(0.5F, 16.0F, -4.0F);
/* 145 */       this.wolfLeg1.field_78795_f = MathHelper.func_76134_b(par2 * 0.6662F) * 1.4F * par3;
/* 146 */       this.wolfLeg2.field_78795_f = MathHelper.func_76134_b(par2 * 0.6662F + 3.1415927F) * 1.4F * par3;
/* 147 */       this.wolfLeg3.field_78795_f = MathHelper.func_76134_b(par2 * 0.6662F + 3.1415927F) * 1.4F * par3;
/* 148 */       this.wolfLeg4.field_78795_f = MathHelper.func_76134_b(par2 * 0.6662F) * 1.4F * par3;
/*     */     } 
/*     */     
/* 151 */     this.wolfHeadMain.field_78808_h = entitywolf.func_70917_k(par4) + entitywolf.func_70923_f(par4, 0.0F);
/* 152 */     this.wolfMane.field_78808_h = entitywolf.func_70923_f(par4, -0.08F);
/* 153 */     this.wolfBody.field_78808_h = entitywolf.func_70923_f(par4, -0.16F);
/* 154 */     this.wolfTail.field_78808_h = entitywolf.func_70923_f(par4, -0.2F);
/* 155 */     this.wolfTail.field_78796_g = 0.5F * (1.0F - 1.0F / (entitywolf.getHappyTicks() + 1.0F)) * MathHelper.func_76126_a((float)(Math.PI * entitywolf.getHappyTicks() / 5.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 161 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/* 162 */     this.wolfHeadMain.field_78795_f = par5 / 57.295776F;
/* 163 */     this.wolfHeadMain.field_78796_g = par4 / 57.295776F;
/* 164 */     if (par7Entity instanceof EntityWolfTFC && ((EntityWolfTFC)par7Entity).getHappyTicks() > 0) {
/* 165 */       this.wolfTail.field_78795_f = 1.9634955F;
/*     */     } else {
/* 167 */       this.wolfTail.field_78795_f = par3;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelWolfTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */