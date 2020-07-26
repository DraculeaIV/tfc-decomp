/*    */ package com.bioxx.tfc.Handlers.Client;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Entities.IAnimal;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.client.event.RenderLivingEvent;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FamiliarityHighlightHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void renderLivingEvent(RenderLivingEvent.Specials.Post evt) {
/* 23 */     if (RenderManager.field_78727_a.field_78734_h instanceof EntityPlayer) {
/* 24 */       EntityLivingBase entity = evt.entity;
/* 25 */       EntityPlayer player = (EntityPlayer)RenderManager.field_78727_a.field_78734_h;
/*    */       
/* 27 */       double x = evt.x;
/* 28 */       double y = evt.y;
/* 29 */       double z = evt.z;
/* 30 */       if (entity instanceof IAnimal && entity == (Minecraft.func_71410_x()).field_147125_j) {
/*    */         
/* 32 */         IAnimal animal = (IAnimal)entity;
/* 33 */         float f = 1.6F;
/* 34 */         float f1 = 0.016666668F * f;
/* 35 */         double d3 = entity.func_70068_e((Entity)RenderManager.field_78727_a.field_78734_h);
/* 36 */         float f2 = 8.0F;
/*    */         
/* 38 */         if (d3 < (f2 * f2))
/*    */         {
/*    */           
/* 41 */           if (player.func_70093_af()) {
/*    */             
/* 43 */             GL11.glPushMatrix();
/* 44 */             GL11.glTranslatef((float)x + 0.0F, (float)y + entity.field_70131_O + 0.75F, (float)z);
/* 45 */             GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 46 */             GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 47 */             GL11.glScalef(-f1, -f1, f1);
/* 48 */             GL11.glDisable(2896);
/* 49 */             GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/* 50 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 51 */             TFC_Core.bindTexture(RenderOverlayHandler.tfcicons);
/* 52 */             float maxFam = 100.0F;
/* 53 */             float percentFam = Math.min(animal.getFamiliarity() / maxFam, 1.0F);
/* 54 */             GL11.glScalef(0.33F, 0.33F, 0.33F);
/* 55 */             if (percentFam >= 0.3D) {
/* 56 */               drawTexturedModalRect(-8, 0, 112, 40, 16, 16);
/*    */             }
/*    */             else {
/*    */               
/* 60 */               drawTexturedModalRect(-8, 0, 92, 40, 16, 16);
/*    */             } 
/* 62 */             GL11.glTranslatef(0.0F, 0.0F, -0.001F);
/* 63 */             if (percentFam == 1.0F || !animal.canFamiliarize()) {
/*    */               
/* 65 */               drawTexturedModalRect(-6, 14 - (int)(12.0F * percentFam), 114, 74 - (int)(12.0F * percentFam), 12, (int)(12.0F * percentFam));
/*    */             }
/*    */             else {
/*    */               
/* 69 */               drawTexturedModalRect(-6, 14 - (int)(12.0F * percentFam), 94, 74 - (int)(12.0F * percentFam), 12, (int)(12.0F * percentFam));
/*    */             } 
/*    */             
/* 72 */             GL11.glDepthMask(true);
/* 73 */             GL11.glEnable(2896);
/* 74 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 75 */             GL11.glPopMatrix();
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
/* 84 */     float f = 0.00390625F;
/* 85 */     float f1 = 0.00390625F;
/* 86 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 87 */     tessellator.func_78382_b();
/* 88 */     tessellator.func_78374_a((par1 + 0), (par2 + par6), 0.0D, ((par3 + 0) * f), ((par4 + par6) * f1));
/* 89 */     tessellator.func_78374_a((par1 + par5), (par2 + par6), 0.0D, ((par3 + par5) * f), ((par4 + par6) * f1));
/* 90 */     tessellator.func_78374_a((par1 + par5), (par2 + 0), 0.0D, ((par3 + par5) * f), ((par4 + 0) * f1));
/* 91 */     tessellator.func_78374_a((par1 + 0), (par2 + 0), 0.0D, ((par3 + 0) * f), ((par4 + 0) * f1));
/* 92 */     tessellator.func_78381_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\FamiliarityHighlightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */