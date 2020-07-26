/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Entities.EntityJavelin;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderTerraJavelin
/*    */   extends Render
/*    */ {
/*    */   public void render(EntityJavelin entity, double x, double y, double z, float par8, float par9) {
/* 19 */     func_110777_b((Entity)entity);
/* 20 */     GL11.glPushMatrix();
/* 21 */     GL11.glTranslatef((float)x, (float)y, (float)z);
/* 22 */     GL11.glRotatef(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
/* 23 */     GL11.glRotatef(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * par9, 0.0F, 0.0F, 1.0F);
/* 24 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 25 */     byte var11 = 0;
/* 26 */     float f2 = 0.0F;
/* 27 */     float f3 = 0.5F;
/* 28 */     float f4 = (0 + var11 * 10) / 32.0F;
/* 29 */     float f5 = (5 + var11 * 10) / 32.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     float f10 = 0.05625F;
/*    */     
/* 36 */     GL11.glEnable(32826);
/* 37 */     float var21 = entity.field_70249_b - par9;
/*    */     
/* 39 */     if (var21 > 0.0F) {
/*    */       
/* 41 */       float var22 = -MathHelper.func_76126_a(var21 * 3.0F) * var21;
/* 42 */       GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
/*    */     } 
/*    */     
/* 45 */     GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
/* 46 */     GL11.glScalef(f10, f10, f10);
/* 47 */     GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
/*    */     
/* 49 */     for (int i = 0; i < 4; i++) {
/*    */       
/* 51 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 52 */       GL11.glNormal3f(0.0F, 0.0F, f10);
/* 53 */       tessellator.func_78382_b();
/* 54 */       tessellator.func_78374_a(-28.0D, -2.0D, 0.0D, f2, f4);
/* 55 */       tessellator.func_78374_a(8.0D, -2.0D, 0.0D, f3, f4);
/* 56 */       tessellator.func_78374_a(8.0D, 2.0D, 0.0D, f3, f5);
/* 57 */       tessellator.func_78374_a(-28.0D, 2.0D, 0.0D, f2, f5);
/* 58 */       tessellator.func_78381_a();
/*    */     } 
/*    */     
/* 61 */     GL11.glDisable(32826);
/* 62 */     GL11.glPopMatrix();
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
/* 74 */     render((EntityJavelin)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 80 */     return new ResourceLocation("terrafirmacraft", "textures/mob/javelin.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderTerraJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */