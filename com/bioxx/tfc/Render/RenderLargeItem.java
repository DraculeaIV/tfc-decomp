/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
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
/*    */ public class RenderLargeItem
/*    */ {
/*    */   public void render(EntityLivingBase entity, ItemStack item) {
/* 26 */     doRender(entity, item);
/*    */   }
/*    */   
/*    */   public void render(Entity entity, ItemStack item) {
/* 30 */     doRender(entity, item);
/*    */   }
/*    */   
/*    */   public void doRender(EntityLivingBase entity, ItemStack item) {
/* 34 */     float entityTranslateY = (entity instanceof net.minecraft.entity.player.EntityPlayer) ? 0.0F : -1.5F;
/* 35 */     GL11.glPushMatrix();
/*    */     
/* 37 */     if (!entity.func_70093_af()) { GL11.glTranslatef(0.0F, 0.2F + entityTranslateY + 0.0F, 0.5F); }
/*    */     else
/* 39 */     { GL11.glTranslatef(0.0F, 0.2F + entityTranslateY - 0.1F, 0.6F);
/* 40 */       GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F); }
/* 41 */      GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 42 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 44 */     if (item != null) {
/* 45 */       if (item.func_77973_b() instanceof IEquipable) {
/* 46 */         ((IEquipable)item.func_77973_b()).onEquippedRender();
/*    */       }
/* 48 */       else if (Block.func_149634_a(item.func_77973_b()) instanceof IEquipable) {
/* 49 */         ((IEquipable)Block.func_149634_a(item.func_77973_b())).onEquippedRender();
/*    */       } 
/* 51 */       Block block = Block.func_149634_a(item.func_77973_b());
/* 52 */       TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 53 */       RenderBlocks.getInstance().func_147800_a(block, item.func_77960_j(), 1.0F);
/*    */     } 
/* 55 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public void doRender(Entity entity, ItemStack item) {
/* 59 */     float entityTranslateY = (entity instanceof net.minecraft.entity.player.EntityPlayer) ? 0.0F : -1.5F;
/* 60 */     GL11.glPushMatrix();
/*    */     
/* 62 */     if (!entity.func_70093_af()) { GL11.glTranslatef(0.0F, 0.2F + entityTranslateY + 0.0F, 0.5F); }
/*    */     else
/* 64 */     { GL11.glTranslatef(0.0F, 0.2F + entityTranslateY - 0.1F, 0.6F);
/* 65 */       GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F); }
/* 66 */      GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 67 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 69 */     if (item != null) {
/* 70 */       if (item.func_77973_b() instanceof IEquipable) {
/* 71 */         ((IEquipable)item.func_77973_b()).onEquippedRender();
/*    */       }
/* 73 */       else if (Block.func_149634_a(item.func_77973_b()) instanceof IEquipable) {
/* 74 */         ((IEquipable)Block.func_149634_a(item.func_77973_b())).onEquippedRender();
/*    */       } 
/* 76 */       Block block = Block.func_149634_a(item.func_77973_b());
/* 77 */       TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 78 */       RenderBlocks.getInstance().func_147800_a(block, item.func_77960_j(), 1.0F);
/*    */     } 
/* 80 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderLargeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */