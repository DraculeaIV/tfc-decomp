/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockAnvil;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilReq;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderAnvil
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean renderAnvil(Block block, int i, int j, int k, RenderBlocks renderblocks) {
/*  19 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*     */     
/*  21 */     int meta = blockAccess.func_72805_g(i, j, k);
/*  22 */     int direction = BlockAnvil.getDirectionFromMetadata(meta);
/*  23 */     boolean breaking = false;
/*  24 */     if (renderblocks.field_147840_d != null) {
/*  25 */       breaking = true;
/*     */     }
/*  27 */     TEAnvil te = (TEAnvil)blockAccess.func_147438_o(i, j, k);
/*  28 */     if (te.anvilTier != AnvilReq.STONE.Tier) {
/*     */       
/*  30 */       if (direction == 0)
/*     */       {
/*     */         
/*  33 */         renderblocks.func_147782_a(0.30000001192092896D, 0.4000000059604645D, 0.10000000149011612D, 0.699999988079071D, 0.6000000238418579D, 0.8999999761581421D);
/*  34 */         renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */         
/*  37 */         renderblocks.func_147782_a(0.3499999940395355D, 0.0D, 0.15000000596046448D, 0.6499999761581421D, 0.4000000059604645D, 0.8500000238418579D);
/*  38 */         renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */         
/*  41 */         renderblocks.func_147782_a(0.25D, 0.0D, 0.10000000149011612D, 0.75D, 0.20000000298023224D, 0.8999999761581421D);
/*  42 */         renderblocks.func_147784_q(block, i, j, k);
/*  43 */         renderblocks.func_147782_a(0.20000000298023224D, 0.0D, 0.0D, 0.800000011920929D, 0.10000000149011612D, 1.0D);
/*  44 */         renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */       
/*     */       }
/*  48 */       else if (direction == 1)
/*     */       {
/*     */         
/*  51 */         renderblocks.func_147782_a(0.10000000149011612D, 0.4000000059604645D, 0.30000001192092896D, 0.8999999761581421D, 0.6000000238418579D, 0.699999988079071D);
/*  52 */         renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */         
/*  55 */         renderblocks.func_147782_a(0.15000000596046448D, 0.0D, 0.3499999940395355D, 0.8500000238418579D, 0.4000000059604645D, 0.6499999761581421D);
/*  56 */         renderblocks.func_147784_q(block, i, j, k);
/*     */ 
/*     */         
/*  59 */         renderblocks.func_147782_a(0.10000000149011612D, 0.0D, 0.25D, 0.8999999761581421D, 0.20000000298023224D, 0.75D);
/*  60 */         renderblocks.func_147784_q(block, i, j, k);
/*  61 */         renderblocks.func_147782_a(0.0D, 0.0D, 0.20000000298023224D, 1.0D, 0.10000000149011612D, 0.800000011920929D);
/*  62 */         renderblocks.func_147784_q(block, i, j, k);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  69 */       Block b = Block.func_149729_e(te.stonePair[0]);
/*  70 */       if (b != null) {
/*     */         
/*  72 */         if (!breaking)
/*     */         {
/*  74 */           renderblocks.field_147840_d = b.func_149691_a(0, te.stonePair[1]);
/*     */         }
/*  76 */         renderblocks.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8999999761581421D, 1.0D);
/*  77 */         renderblocks.func_147784_q(block, i, j, k);
/*  78 */         renderblocks.func_147771_a();
/*     */       } 
/*     */     } 
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
/*  87 */     if (modelId == TFCBlocks.anvilRenderId) {
/*     */       
/*  89 */       renderer.func_147782_a(0.30000001192092896D, 0.4000000059604645D, 0.10000000149011612D, 0.699999988079071D, 0.6000000238418579D, 0.8999999761581421D);
/*  90 */       renderInvBlock(block, metadata, renderer);
/*     */ 
/*     */       
/*  93 */       renderer.func_147782_a(0.3499999940395355D, 0.0D, 0.15000000596046448D, 0.6499999761581421D, 0.4000000059604645D, 0.8500000238418579D);
/*  94 */       renderInvBlock(block, metadata, renderer);
/*     */ 
/*     */       
/*  97 */       renderer.func_147782_a(0.25D, 0.0D, 0.10000000149011612D, 0.75D, 0.20000000298023224D, 0.8999999761581421D);
/*  98 */       renderInvBlock(block, metadata, renderer);
/*  99 */       renderer.func_147782_a(0.20000000298023224D, 0.0D, 0.0D, 0.800000011920929D, 0.10000000149011612D, 1.0D);
/* 100 */       renderInvBlock(block, metadata, renderer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 107 */     if (modelId == TFCBlocks.anvilRenderId)
/* 108 */       return renderAnvil(block, x, y, z, renderer); 
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 121 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int m, RenderBlocks renderer) {
/* 126 */     Tessellator var14 = Tessellator.field_78398_a;
/* 127 */     int meta = m;
/* 128 */     if (meta >= 8) {
/* 129 */       meta -= 8;
/*     */     }
/* 131 */     var14.func_78382_b();
/* 132 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 133 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 134 */     var14.func_78381_a();
/* 135 */     var14.func_78382_b();
/* 136 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 137 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 138 */     var14.func_78381_a();
/* 139 */     var14.func_78382_b();
/* 140 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 141 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 142 */     var14.func_78381_a();
/* 143 */     var14.func_78382_b();
/* 144 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 145 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 146 */     var14.func_78381_a();
/* 147 */     var14.func_78382_b();
/* 148 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 149 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 150 */     var14.func_78381_a();
/* 151 */     var14.func_78382_b();
/* 152 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 153 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 154 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */