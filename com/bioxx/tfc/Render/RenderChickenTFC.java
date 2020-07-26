/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Entities.Mobs.EntityChickenTFC;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderChicken;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderChickenTFC
/*    */   extends RenderChicken
/*    */ {
/* 18 */   private static final ResourceLocation CHICKEN_TEXTURE = new ResourceLocation("textures/entity/chicken.png");
/* 19 */   private static final ResourceLocation ROOSTER_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/rooster.png");
/* 20 */   private static final ResourceLocation CHICK_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/chick.png");
/*    */ 
/*    */   
/*    */   public RenderChickenTFC(ModelBase par1ModelBase, float par2) {
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
/*    */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 36 */     this.field_76989_e = 0.15F + TFC_Core.getPercentGrown((IAnimal)par1Entity) * 0.15F;
/* 37 */     super.func_76986_a(par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getTexture(IAnimal entity) {
/* 42 */     float percent = TFC_Core.getPercentGrown(entity);
/*    */     
/* 44 */     if (percent < 0.65F) {
/* 45 */       return CHICK_TEXTURE;
/*    */     }
/* 47 */     if (entity.getGender() == IAnimal.GenderEnum.MALE) {
/* 48 */       return ROOSTER_TEXTURE;
/*    */     }
/*    */     
/* 51 */     return CHICKEN_TEXTURE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityLivingBase par1EntityLivingBase, float par2) {
/* 58 */     float scale = ((EntityChickenTFC)par1EntityLivingBase).getSizeMod() / 3.0F + 0.5F;
/* 59 */     GL11.glScalef(scale, scale, scale);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 65 */     return getTexture((IAnimal)entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderChickenTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */