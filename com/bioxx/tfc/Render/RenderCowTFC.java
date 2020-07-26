/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderCow;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderCowTFC
/*    */   extends RenderCow
/*    */ {
/* 19 */   private static final ResourceLocation COW_TEXTURE = new ResourceLocation("textures/entity/cow/cow.png");
/* 20 */   private static final ResourceLocation BULL_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/bull.png");
/*    */ 
/*    */   
/*    */   public RenderCowTFC(ModelBase par1ModelBase, float par2) {
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
/* 36 */     this.field_76989_e = 0.35F + TFC_Core.getPercentGrown((IAnimal)par1Entity) * 0.35F;
/* 37 */     super.func_76986_a(par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getTexture(EntityCowTFC entity) {
/* 42 */     if (entity.getGender() == IAnimal.GenderEnum.MALE) {
/* 43 */       return BULL_TEXTURE;
/*    */     }
/* 45 */     return COW_TEXTURE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityLivingBase par1EntityLivingBase, float par2) {
/* 52 */     float scale = ((EntityCowTFC)par1EntityLivingBase).getSizeMod();
/* 53 */     GL11.glScalef(scale, scale, scale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity par1Entity) {
/* 61 */     return getTexture((EntityCowTFC)par1Entity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderCowTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */