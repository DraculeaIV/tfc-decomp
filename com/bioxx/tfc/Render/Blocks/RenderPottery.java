/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEPottery;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderPottery
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
/*    */   
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 23 */     TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 24 */     boolean breaking = (renderer.field_147840_d != null);
/*    */     
/* 26 */     if (te.straw > 0) {
/*    */       
/* 28 */       if (!breaking) {
/* 29 */         renderer.field_147840_d = TFCBlocks.thatch.func_149673_e(world, x, y, z, 0);
/*    */       }
/* 31 */       renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D * te.straw, 1.0D);
/* 32 */       renderer.func_147784_q(block, x, y, z);
/*    */     } 
/*    */     
/* 35 */     if (te.wood > 0) {
/*    */       
/* 37 */       if (!breaking) {
/* 38 */         renderer.field_147840_d = TFCBlocks.logPile.func_149691_a(0, 0);
/*    */       }
/* 40 */       int w = te.wood;
/* 41 */       if (te.wood > 4) {
/*    */         
/* 43 */         w = te.wood - 4;
/* 44 */         renderer.func_147782_a(0.0D, 0.75D, 0.0D, 0.25D * w, 1.0D, 1.0D);
/* 45 */         renderer.func_147784_q(block, x, y, z);
/* 46 */         w = 4;
/*    */       } 
/* 48 */       renderer.func_147782_a(0.0D, 0.5D, 0.0D, 0.25D * w, 0.75D, 1.0D);
/* 49 */       renderer.func_147784_q(block, x, y, z);
/*    */     } 
/*    */     
/* 52 */     if (!breaking) {
/* 53 */       renderer.func_147771_a();
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 67 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderPottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */