/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ public class TESRFirepit
/*    */   extends TESRBase
/*    */ {
/*    */   public void renderTileEntityFirepitAt(TEFirepit par1TileEntityPit, double d, double d1, double d2, float f) {
/* 23 */     if (par1TileEntityPit.func_145831_w() != null)
/*    */     {
/* 25 */       if (par1TileEntityPit.hasCookingPot) {
/*    */ 
/*    */ 
/*    */         
/* 29 */         TFC_Core.bindTexture(new ResourceLocation("terrafirmacraft", "textures/blocks/clay/Ceramic.png"));
/* 30 */         GL11.glPushMatrix();
/* 31 */         GL11.glTranslatef((float)d + 0.0F, (float)d1 + 0.0F, (float)d2 + 0.0F);
/*    */ 
/*    */         
/* 34 */         GL11.glPopMatrix();
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 42 */     renderTileEntityFirepitAt((TEFirepit)par1TileEntity, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */