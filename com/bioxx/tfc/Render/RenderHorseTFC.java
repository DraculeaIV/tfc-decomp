/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.entity.RenderHorse;
/*     */ import net.minecraft.client.renderer.texture.ITextureObject;
/*     */ import net.minecraft.client.renderer.texture.LayeredTexture;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderHorseTFC
/*     */   extends RenderHorse
/*     */ {
/*  25 */   private static final Map TEXTURE_MAP = Maps.newHashMap();
/*  26 */   private static final ResourceLocation WHITE_TEXTURE = new ResourceLocation("textures/entity/horse/horse_white.png");
/*  27 */   private static final ResourceLocation MULE_TEXTURE = new ResourceLocation("textures/entity/horse/mule.png");
/*  28 */   private static final ResourceLocation DONKEY_TEXTURE = new ResourceLocation("textures/entity/horse/donkey.png");
/*  29 */   private static final ResourceLocation ZOMBIE_TEXTURE = new ResourceLocation("textures/entity/horse/horse_zombie.png");
/*  30 */   private static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation("textures/entity/horse/horse_skeleton.png");
/*     */ 
/*     */   
/*     */   public RenderHorseTFC(ModelBase par1ModelBase, float par2) {
/*  34 */     super(par1ModelBase, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderHorse(EntityHorse par1EntityHorse, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  39 */     if (par1EntityHorse.func_82150_aj()) {
/*     */       
/*  41 */       this.field_77045_g.func_78087_a(par2, par3, par4, par5, par6, par7, (Entity)par1EntityHorse);
/*     */     }
/*     */     else {
/*     */       
/*  45 */       func_110777_b((Entity)par1EntityHorse);
/*  46 */       this.field_77045_g.func_78088_a((Entity)par1EntityHorse, par2, par3, par4, par5, par6, par7);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation getTextureLocation(EntityHorse par1EntityHorse) {
/*  52 */     if (!par1EntityHorse.func_110239_cn()) {
/*     */       
/*  54 */       switch (par1EntityHorse.func_110265_bP())
/*     */       
/*     */       { 
/*     */         default:
/*  58 */           return WHITE_TEXTURE;
/*     */         case 1:
/*  60 */           return DONKEY_TEXTURE;
/*     */         case 2:
/*  62 */           return MULE_TEXTURE;
/*     */         case 3:
/*  64 */           return ZOMBIE_TEXTURE;
/*     */         case 4:
/*  66 */           break; }  return SKELETON_TEXTURE;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  71 */     return getTexture(par1EntityHorse);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ResourceLocation getTexture(EntityHorse par1EntityHorse) {
/*  77 */     String s = par1EntityHorse.func_110264_co();
/*  78 */     ResourceLocation resourcelocation = (ResourceLocation)TEXTURE_MAP.get(s);
/*     */     
/*  80 */     if (resourcelocation == null) {
/*     */       
/*  82 */       resourcelocation = new ResourceLocation(s);
/*  83 */       Minecraft.func_71410_x().func_110434_K().func_110579_a(resourcelocation, (ITextureObject)new LayeredTexture(par1EntityHorse.func_110212_cp()));
/*  84 */       TEXTURE_MAP.put(s, resourcelocation);
/*     */     } 
/*     */     
/*  87 */     return resourcelocation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase par1EntityLivingBase, float par2) {
/*  97 */     float scale = ((EntityHorseTFC)par1EntityLivingBase).getSizeMod();
/*  98 */     GL11.glScalef(scale, scale, scale);
/*  99 */     func_77041_b((EntityHorse)par1EntityLivingBase, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77036_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 108 */     renderHorse((EntityHorse)par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity par1Entity) {
/* 117 */     return getTextureLocation((EntityHorse)par1Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderHorseTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */