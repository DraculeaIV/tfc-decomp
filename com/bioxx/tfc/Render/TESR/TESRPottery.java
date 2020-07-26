/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEPottery;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.tileentity.TileEntity;
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
/*    */ 
/*    */ 
/*    */ public class TESRPottery
/*    */   extends TESRBase
/*    */ {
/*    */   public void renderAt(TEPottery te, double d, double d1, double d2, float f) {
/* 25 */     if (te.func_145831_w() != null) {
/*    */       
/* 27 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/* 28 */       customitem.field_70290_d = 0.0F;
/* 29 */       float blockScale = 1.0F;
/* 30 */       float timeD = (float)(360.0D * (System.currentTimeMillis() & 0x3FFFL) / 16383.0D);
/* 31 */       for (int i = 0; i < 4; i++) {
/*    */         
/* 33 */         float offsetX = 0.25F;
/* 34 */         float offsetY = 0.1F;
/* 35 */         float offsetZ = 0.25F;
/* 36 */         if (i == 1) {
/*    */           
/* 38 */           offsetX = 0.75F;
/* 39 */           offsetZ = 0.25F;
/*    */         }
/* 41 */         else if (i == 2) {
/*    */           
/* 43 */           offsetX = 0.25F;
/* 44 */           offsetZ = 0.75F;
/*    */         }
/* 46 */         else if (i == 3) {
/*    */           
/* 48 */           offsetX = 0.75F;
/* 49 */           offsetZ = 0.75F;
/*    */         } 
/*    */         
/* 52 */         if (te.func_70301_a(i) != null) {
/*    */           
/* 54 */           if (te.func_70301_a(i).func_77973_b() instanceof net.minecraft.item.ItemBlock) {
/*    */             
/* 56 */             blockScale = 2.0F; offsetX = 0.5F; offsetZ = 0.5F;
/*    */           } 
/* 58 */           GL11.glPushMatrix();
/* 59 */           GL11.glTranslatef((float)d + offsetX, (float)d1 + offsetY, (float)d2 + offsetZ);
/* 60 */           if (RenderManager.field_78727_a.field_78733_k.field_74347_j)
/*    */           {
/* 62 */             GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*    */           }
/* 64 */           GL11.glScalef(blockScale, blockScale, blockScale);
/* 65 */           customitem.func_92058_a(te.func_70301_a(i));
/* 66 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/* 67 */           GL11.glPopMatrix();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 78 */     renderAt((TEPottery)par1TileEntity, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRPottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */