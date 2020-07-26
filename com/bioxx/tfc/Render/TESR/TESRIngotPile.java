/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.BlockIngotPile;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Render.Models.ModelIngotPile;
/*    */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESRIngotPile
/*    */   extends TESRBase
/*    */ {
/* 19 */   private final ModelIngotPile ingotModel = new ModelIngotPile();
/*    */ 
/*    */   
/*    */   public void renderTileEntityIngotPileAt(TEIngotPile tep, double d, double d1, double d2, float f) {
/* 23 */     Block block = tep.func_145838_q();
/* 24 */     if (tep.func_145831_w() != null && tep.func_70301_a(0) != null && block == TFCBlocks.ingotPile) {
/*    */       
/* 26 */       int i = ((BlockIngotPile)block).getStack(tep.func_145831_w(), tep);
/* 27 */       TFC_Core.bindTexture(new ResourceLocation("terrafirmacraft", "textures/blocks/metal/" + tep.type + ".png"));
/*    */       
/* 29 */       GL11.glPushMatrix();
/* 30 */       GL11.glTranslatef((float)d + 0.0F, (float)d1 + 0.0F, (float)d2 + 0.0F);
/* 31 */       this.ingotModel.renderIngots(i);
/* 32 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_147500_a(TileEntity te, double par2, double par4, double par6, float par8) {
/* 39 */     renderTileEntityIngotPileAt((TEIngotPile)te, par2, par4, par6, par8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRIngotPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */