/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Entities.Mobs.EntityBear;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class RenderBear
/*    */   extends RenderLiving
/*    */ {
/* 17 */   private static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/Bear.png");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RenderBear(ModelBase par1ModelBase, float par2) {
/* 24 */     super(par1ModelBase, par2);
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
/*    */   protected void func_77041_b(EntityLivingBase par1EntityLiving, float par2) {
/* 36 */     preRenderScale((EntityBear)par1EntityLiving, par2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void preRenderScale(EntityBear par1EntityBear, float par2) {
/* 41 */     GL11.glScalef(0.3F + par1EntityBear.getSizeMod(), 0.3F + par1EntityBear.getSizeMod(), 0.3F + par1EntityBear.getSizeMod());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected float func_77044_a(EntityLivingBase par1EntityLiving, float par2) {
/* 51 */     return 1.0F;
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
/* 63 */     this.field_76989_e = 0.35F + TFC_Core.getPercentGrown((IAnimal)par1Entity) * 0.35F;
/* 64 */     super.func_76986_a(par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 71 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderBear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */