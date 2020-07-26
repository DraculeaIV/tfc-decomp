/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEOre;
/*    */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderOre
/*    */   implements ISimpleBlockRenderingHandler
/*    */ {
/*    */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
/*    */   
/*    */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 25 */     boolean breaking = (renderer.field_147840_d != null);
/*    */     
/* 27 */     if (breaking) {
/* 28 */       renderer.func_147784_q(block, x, y, z);
/*    */     }
/*    */     else {
/*    */       
/* 32 */       renderer.field_147840_d = getRockTexture((World)(Minecraft.func_71410_x()).field_71441_e, x, y, z);
/* 33 */       renderer.func_147784_q(block, x, y, z);
/* 34 */       renderer.func_147771_a();
/*    */ 
/*    */       
/* 37 */       renderer.func_147784_q(block, x, y, z);
/*    */     } 
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static IIcon getRockTexture(World worldObj, int xCoord, int yCoord, int zCoord) {
/* 45 */     TEOre te = (TEOre)worldObj.func_147438_o(xCoord, yCoord, zCoord);
/* 46 */     if (te != null && te.baseBlockID > 0)
/*    */     {
/* 48 */       return Block.func_149729_e(te.baseBlockID).func_149691_a(5, te.baseBlockMeta);
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldRender3DInInventory(int modelId) {
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRenderId() {
/* 62 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderInvBlock(Block block, int meta, RenderBlocks renderer) {
/* 67 */     Tessellator var14 = Tessellator.field_78398_a;
/* 68 */     var14.func_78382_b();
/* 69 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 70 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 71 */     var14.func_78381_a();
/* 72 */     var14.func_78382_b();
/* 73 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 74 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 75 */     var14.func_78381_a();
/* 76 */     var14.func_78382_b();
/* 77 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 78 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 79 */     var14.func_78381_a();
/* 80 */     var14.func_78382_b();
/* 81 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 82 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 83 */     var14.func_78381_a();
/* 84 */     var14.func_78382_b();
/* 85 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 86 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 87 */     var14.func_78381_a();
/* 88 */     var14.func_78382_b();
/* 89 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 90 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 91 */     var14.func_78381_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */