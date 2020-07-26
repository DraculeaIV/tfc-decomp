/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEWorldItem;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESRWorldItem
/*    */   extends TESRBase
/*    */ {
/* 17 */   public static Random rand = new Random();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAt(TEWorldItem te, double d, double d1, double d2, float f) {
/* 27 */     if (te.func_145831_w() != null) {
/*    */ 
/*    */       
/* 30 */       if (te.renderItem == null) {
/*    */         
/* 32 */         rand.setSeed(((te.field_145851_c + te.field_145849_e) * te.field_145851_c));
/* 33 */         te.renderItem = new EntityItem(this.field_147501_a.field_147550_f);
/* 34 */         te.renderItem.func_70082_c(rand.nextFloat() * 360.0F, 90.0F);
/* 35 */         te.renderItem.field_70290_d = 0.0F;
/* 36 */         te.renderItem.func_92058_a(te.storage[0]);
/*    */       } 
/*    */       
/* 39 */       if (te.storage[0] != null) {
/*    */         
/* 41 */         float minU = te.storage[0].func_77954_c().func_94209_e();
/* 42 */         float maxU = te.storage[0].func_77954_c().func_94212_f();
/* 43 */         float minV = te.storage[0].func_77954_c().func_94206_g();
/* 44 */         float maxV = te.storage[0].func_77954_c().func_94210_h();
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 49 */         if (te.storage[0].func_94608_d() == 0) {
/*    */           
/* 51 */           func_147499_a(TextureMap.field_110575_b);
/*    */         }
/*    */         else {
/*    */           
/* 55 */           func_147499_a(TextureMap.field_110576_c);
/*    */         } 
/*    */         
/* 58 */         boolean fancy = RenderManager.field_78727_a.field_78733_k.field_74347_j;
/*    */         
/* 60 */         GL11.glPushMatrix();
/*    */         
/* 62 */         if (RenderManager.field_78727_a.field_78733_k.field_74347_j) {
/*    */           
/* 64 */           GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.021F, (float)d2 + 0.5F);
/* 65 */           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*    */ 
/*    */           
/* 68 */           itemRenderer.func_76986_a(te.renderItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*    */         }
/*    */         else {
/*    */           
/* 72 */           GL11.glTranslated(d, d1 + 0.001D, d2);
/* 73 */           Tessellator tessellator = Tessellator.field_78398_a;
/* 74 */           tessellator.func_78382_b();
/* 75 */           tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 76 */           tessellator.func_78374_a(0.2D, 0.0D, 0.8D, minU, maxV);
/* 77 */           tessellator.func_78374_a(0.8D, 0.0D, 0.8D, maxU, maxV);
/* 78 */           tessellator.func_78374_a(0.8D, 0.0D, 0.2D, maxU, minV);
/* 79 */           tessellator.func_78374_a(0.2D, 0.0D, 0.2D, minU, minV);
/* 80 */           tessellator.func_78381_a();
/*    */         } 
/* 82 */         GL11.glPopMatrix();
/* 83 */         RenderManager.field_78727_a.field_78733_k.field_74347_j = fancy;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 91 */     renderAt((TEWorldItem)par1TileEntity, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRWorldItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */