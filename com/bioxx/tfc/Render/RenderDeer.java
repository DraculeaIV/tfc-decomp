/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Entities.Mobs.EntityDeer;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderDeer
/*    */   extends RenderLiving
/*    */ {
/* 17 */   private static final ResourceLocation DEER_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/deer.png");
/* 18 */   private static final ResourceLocation FAWN_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/deer_fawn.png");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderDeer(ModelBase par1ModelBase, float par2) {
/* 25 */     super(par1ModelBase, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDeer(EntityDeer par1EntityDeer, double par2, double par4, double par6, float par8, float par9) {
/* 31 */     super.func_76986_a((EntityLiving)par1EntityDeer, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityLivingBase par1EntityLiving, float par2) {
/* 46 */     preRenderScale((EntityDeer)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void preRenderScale(EntityDeer par1EntityDeer, float par2) {
/* 52 */     GL11.glScalef(par1EntityDeer.getSizeMod() - 0.3F, par1EntityDeer.getSizeMod() - 0.3F, par1EntityDeer.getSizeMod() - 0.3F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected float func_77044_a(EntityLivingBase par1EntityLiving, float par2) {
/* 61 */     return 1.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/* 67 */     renderDeer((EntityDeer)par1EntityLiving, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 79 */     renderDeer((EntityDeer)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getTexture(IAnimal entity) {
/* 84 */     if (!entity.isAdult())
/*    */     {
/* 86 */       return FAWN_TEXTURE;
/*    */     }
/*    */ 
/*    */     
/* 90 */     return DEER_TEXTURE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 97 */     return getTexture((IAnimal)entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderDeer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */