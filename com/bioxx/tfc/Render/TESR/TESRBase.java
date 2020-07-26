/*    */ package com.bioxx.tfc.Render.TESR;
/*    */ 
/*    */ import com.google.common.primitives.SignedBytes;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESRBase
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/*    */   public TESRBase() {
/* 18 */     itemRenderer = new RenderItem()
/*    */       {
/*    */         
/*    */         public byte getMiniBlockCount(ItemStack stack, byte original)
/*    */         {
/* 23 */           return SignedBytes.saturatedCast((Math.min(stack.field_77994_a / 32, 15) + 1));
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public byte getMiniItemCount(ItemStack stack, byte original) {
/* 29 */           return SignedBytes.saturatedCast((Math.min(stack.field_77994_a / 32, 7) + 1));
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean shouldBob() {
/* 35 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean shouldSpreadItems() {
/* 41 */           return false;
/*    */         }
/*    */       };
/* 44 */     itemRenderer.func_76976_a(RenderManager.field_78727_a);
/*    */   }
/*    */   
/*    */   protected static RenderBlocks renderBlocks = new RenderBlocks();
/*    */   protected static RenderItem itemRenderer;
/*    */   
/*    */   public void func_147500_a(TileEntity tileentity, double d0, double d1, double d2, float f) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */