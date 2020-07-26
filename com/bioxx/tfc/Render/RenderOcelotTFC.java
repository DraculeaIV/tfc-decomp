/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityOcelotTFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.entity.RenderLiving;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderOcelotTFC
/*     */   extends RenderLiving
/*     */ {
/*  22 */   private static final ResourceLocation ocelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/ocelot.png");
/*  23 */   private static final ResourceLocation blackOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/black.png");
/*  24 */   private static final ResourceLocation redOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/red.png");
/*  25 */   private static final ResourceLocation siameseOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/siamese.png");
/*  26 */   private static final ResourceLocation herosiamOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/hero_siam.png");
/*  27 */   private static final ResourceLocation red_cat_tigerOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/red_cat_tiger.png");
/*  28 */   private static final ResourceLocation cute_catOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/cute_cat.png");
/*  29 */   private static final ResourceLocation calicoOcelotTextures = new ResourceLocation("terrafirmacraft", "textures/mob/cat/calico.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RenderOcelotTFC(ModelBase p_i1264_1_, float p_i1264_2_) {
/*  37 */     super(p_i1264_1_, p_i1264_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doRender(EntityOcelotTFC p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  48 */     super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation getEntityTexture(EntityOcelotTFC p_110775_1_) {
/*  56 */     switch (p_110775_1_.getTameSkin())
/*     */     
/*     */     { 
/*     */       default:
/*  60 */         return ocelotTextures;
/*     */       case 1:
/*  62 */         return blackOcelotTextures;
/*     */       case 2:
/*  64 */         return redOcelotTextures;
/*     */       case 3:
/*  66 */         return siameseOcelotTextures;
/*     */       case 4:
/*  68 */         return herosiamOcelotTextures;
/*     */       case 5:
/*  70 */         return red_cat_tigerOcelotTextures;
/*     */       case 6:
/*  72 */         break; }  return calicoOcelotTextures;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preRenderCallback(EntityOcelotTFC p_77041_1_, float p_77041_2_) {
/*  83 */     super.func_77041_b((EntityLivingBase)p_77041_1_, p_77041_2_);
/*     */     
/*  85 */     if (p_77041_1_.func_70909_n())
/*     */     {
/*  87 */       GL11.glScalef(0.8F, 0.8F, 0.8F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  99 */     doRender((EntityOcelotTFC)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
/* 108 */     preRenderCallback((EntityOcelotTFC)p_77041_1_, p_77041_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 119 */     doRender((EntityOcelotTFC)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
/* 127 */     return getEntityTexture((EntityOcelotTFC)p_110775_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 138 */     doRender((EntityOcelotTFC)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderOcelotTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */