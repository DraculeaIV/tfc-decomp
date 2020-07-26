/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import com.bioxx.tfc.Render.Models.ModelLoom;
/*    */ import com.bioxx.tfc.TileEntities.TELoom;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESRLoom
/*    */   extends TESRBase
/*    */ {
/*    */   public void renderTileEntityLoomAt(TELoom te, double d, double d1, double d2, float f) {
/* 19 */     if (te.func_145831_w() != null) {
/*    */       
/* 21 */       int stringCount = te.getStringCount();
/* 22 */       int reqStringCount = te.getRequiredStringCount();
/*    */       
/* 24 */       if (te.getModel() == null)
/*    */       {
/* 26 */         te.setModel(new ModelLoom());
/*    */       }
/* 28 */       TFC_Core.bindTexture(te.getWoodResource());
/* 29 */       GL11.glPushMatrix();
/* 30 */       GL11.glTranslatef((float)d + 0.0F, (float)d1 + 0.0F, (float)d2 + 0.0F);
/* 31 */       if (stringCount < reqStringCount)
/*    */       {
/* 33 */         te.getModel().updateCloth(te.getCloth());
/*    */       }
/* 35 */       if (te.getIsWeaving() || (te.getModel()).stillWeaving) {
/*    */         
/* 37 */         if (TFC_Time.getTotalTicks() > (te.getModel()).tempTime) {
/*    */           
/* 39 */           (te.getModel()).tempNum += (int)(TFC_Time.getTotalTicks() - (te.getModel()).tempTime);
/* 40 */           (te.getModel()).tempTime = TFC_Time.getTotalTicks();
/* 41 */           if ((te.getModel()).tempNum >= (te.getModel()).lastClothIncrease + (te.getModel()).mod / 2) {
/*    */             
/* 43 */             (te.getModel()).clothIncrease = true;
/* 44 */             (te.getModel()).lastClothIncrease = ((te.getModel()).lastClothIncrease + (te.getModel()).mod / 2) % (te.getModel()).mod;
/*    */             
/* 46 */             te.finishWeaveCycle();
/* 47 */             (te.getModel()).stillWeaving = te.getIsWeaving();
/*    */           } 
/* 49 */           (te.getModel()).tempNum %= (te.getModel()).mod;
/*    */         } 
/*    */       } else {
/*    */         
/* 53 */         (te.getModel()).tempTime = TFC_Time.getTotalTicks();
/*    */       } 
/*    */       
/* 56 */       if (te.func_70301_a(1) != null) {
/* 57 */         te.getModel().render(reqStringCount, reqStringCount, (te.getModel()).tempNum, false, (te.getModel()).mod, te.getStringResource(), false, false, te);
/*    */       } else {
/* 59 */         te.getModel().render(stringCount, reqStringCount, (te.getModel()).tempNum, (te.getModel()).clothIncrease, (te.getModel()).mod, te.getStringResource(), te.getIsWeaving(), (te.getModel()).stillWeaving, te);
/*    */       } 
/* 61 */       (te.getModel()).clothIncrease = false;
/* 62 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 69 */     renderTileEntityLoomAt((TELoom)par1TileEntity, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRLoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */