/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Items.ItemQuiver;
/*    */ import com.bioxx.tfc.Render.Models.ModelQuiver;
/*    */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderQuiver
/*    */ {
/* 19 */   private ModelQuiver quiver = new ModelQuiver();
/* 20 */   private static final ResourceLocation QUIVER_TEXTURE = new ResourceLocation("terrafirmacraft", "textures/models/armor/leatherquiver_1.png");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(EntityLivingBase entity, ItemStack item) {
/* 27 */     doRender(entity, item);
/*    */   }
/*    */   
/*    */   public void doRender(EntityLivingBase entity, ItemStack item) {
/* 31 */     float entityTranslateY = (entity instanceof net.minecraft.entity.player.EntityPlayer) ? 0.0F : -1.5F;
/* 32 */     GL11.glPushMatrix();
/* 33 */     (Minecraft.func_71410_x()).field_71446_o.func_110577_a(QUIVER_TEXTURE);
/* 34 */     if (!entity.func_70093_af()) { GL11.glTranslatef(0.0F, entityTranslateY + 0.0F, 0.1F); }
/*    */     else
/* 36 */     { GL11.glTranslatef(0.0F, entityTranslateY + 0.1F, 0.1F);
/* 37 */       GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F); }
/* 38 */      if (item != null) {
/* 39 */       if (item.func_77973_b() instanceof IEquipable) {
/* 40 */         ((IEquipable)item.func_77973_b()).onEquippedRender();
/*    */       }
/* 42 */       if (entity instanceof com.bioxx.tfc.Entities.Mobs.EntitySkeletonTFC) {
/* 43 */         this.quiver.render(entity, 16);
/*    */       } else {
/* 45 */         this.quiver.render(entity, ((ItemQuiver)item.func_77973_b()).getQuiverArrows(item) / 8);
/*    */       } 
/* 47 */     }  GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderQuiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */