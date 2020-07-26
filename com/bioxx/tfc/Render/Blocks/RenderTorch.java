/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderTorch
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 20 */     int meta = world.func_72805_g(x, y, z);
/* 21 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 22 */     tessellator.func_78380_c(block.func_149677_c(world, x, y, z));
/* 23 */     tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
/* 24 */     double d0 = 0.4000000059604645D;
/* 25 */     double d1 = 0.5D - d0;
/* 26 */     double d2 = 0.20000000298023224D;
/*    */     
/* 28 */     if ((meta & 0x7) == 1) {
/*    */       
/* 30 */       renderer.func_147747_a(block, x - d1, y + d2, z, -d0, 0.0D, meta);
/*    */     }
/* 32 */     else if ((meta & 0x7) == 2) {
/*    */       
/* 34 */       renderer.func_147747_a(block, x + d1, y + d2, z, d0, 0.0D, meta);
/*    */     }
/* 36 */     else if ((meta & 0x7) == 3) {
/*    */       
/* 38 */       renderer.func_147747_a(block, x, y + d2, z - d1, 0.0D, -d0, meta);
/*    */     }
/* 40 */     else if ((meta & 0x7) == 4) {
/*    */       
/* 42 */       renderer.func_147747_a(block, x, y + d2, z + d1, 0.0D, d0, meta);
/*    */     }
/*    */     else {
/*    */       
/* 46 */       renderer.func_147747_a(block, x, y, z, 0.0D, 0.0D, meta);
/*    */     } 
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 60 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 66 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */