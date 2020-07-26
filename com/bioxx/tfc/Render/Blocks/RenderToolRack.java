/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEToolRack;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderToolRack
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderblocks) {
/*  18 */     renderblocks.field_147840_d = block.func_149691_a(0, metadata);
/*     */     
/*  20 */     renderblocks.func_147782_a(0.30000001192092896D, 0.3D, 0.949999988079071D, 1.7000000476837158D, 0.44999998807907104D, 1.100000023841858D);
/*  21 */     renderInvBlock(block, metadata, renderblocks);
/*     */     
/*  23 */     renderblocks.func_147782_a(0.30000001192092896D, 0.9D, 0.949999988079071D, 1.7000000476837158D, 1.0499999523162842D, 1.100000023841858D);
/*  24 */     renderInvBlock(block, metadata, renderblocks);
/*     */     
/*  26 */     renderblocks.func_147771_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderblocks) {
/*  32 */     IBlockAccess blockAccess = renderblocks.field_147845_a;
/*  33 */     TEToolRack te = (TEToolRack)blockAccess.func_147438_o(i, j, k);
/*  34 */     int dir = blockAccess.func_72805_g(i, j, k);
/*  35 */     boolean breaking = (renderblocks.field_147840_d != null);
/*  36 */     if (te != null) {
/*     */       
/*  38 */       if (!breaking) {
/*  39 */         renderblocks.field_147840_d = block.func_149691_a(0, te.woodType);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  46 */       if (dir == 0) {
/*     */         
/*  48 */         renderRackDir0(block, i, j, k, renderblocks, 0.7F);
/*  49 */         renderRackDir0(block, i, j, k, renderblocks, 0.3F);
/*     */       }
/*  51 */       else if (dir == 1) {
/*     */         
/*  53 */         renderRackDir1(block, i, j, k, renderblocks, 0.7F);
/*  54 */         renderRackDir1(block, i, j, k, renderblocks, 0.3F);
/*     */       }
/*  56 */       else if (dir == 2) {
/*     */         
/*  58 */         renderRackDir2(block, i, j, k, renderblocks, 0.7F);
/*  59 */         renderRackDir2(block, i, j, k, renderblocks, 0.3F);
/*     */       }
/*  61 */       else if (dir == 3) {
/*     */         
/*  63 */         renderRackDir3(block, i, j, k, renderblocks, 0.7F);
/*  64 */         renderRackDir3(block, i, j, k, renderblocks, 0.3F);
/*     */       } 
/*     */     } 
/*     */     
/*  68 */     if (!breaking) {
/*  69 */       renderblocks.func_147771_a();
/*     */     }
/*  71 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/*  83 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderRackDir0(Block block, int i, int j, int k, RenderBlocks renderblocks, float yOffset) {
/*  88 */     renderblocks.func_147782_a(0.0D, yOffset, 0.949999988079071D, 1.0D, (yOffset + 0.05F), 1.0D);
/*  89 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/*  91 */     renderblocks.func_147782_a(0.20000000298023224D, yOffset, 0.8999999761581421D, 0.2199999988079071D, (yOffset + 0.05F), 0.949999988079071D);
/*  92 */     renderblocks.func_147784_q(block, i, j, k);
/*  93 */     renderblocks.func_147782_a(0.30000001192092896D, yOffset, 0.8999999761581421D, 0.3199999928474426D, (yOffset + 0.05F), 0.949999988079071D);
/*  94 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/*  96 */     renderblocks.func_147782_a(0.6800000071525574D, yOffset, 0.8999999761581421D, 0.699999988079071D, (yOffset + 0.05F), 0.949999988079071D);
/*  97 */     renderblocks.func_147784_q(block, i, j, k);
/*  98 */     renderblocks.func_147782_a(0.7799999713897705D, yOffset, 0.8999999761581421D, 0.800000011920929D, (yOffset + 0.05F), 0.949999988079071D);
/*  99 */     renderblocks.func_147784_q(block, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderRackDir1(Block block, int i, int j, int k, RenderBlocks renderblocks, float yOffset) {
/* 104 */     renderblocks.func_147782_a(0.0D, yOffset, 0.0D, 0.05000000074505806D, (yOffset + 0.05F), 1.0D);
/* 105 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 107 */     renderblocks.func_147782_a(0.05000000074505806D, yOffset, 0.20000000298023224D, 0.10000000149011612D, (yOffset + 0.05F), 0.2199999988079071D);
/* 108 */     renderblocks.func_147784_q(block, i, j, k);
/* 109 */     renderblocks.func_147782_a(0.05000000074505806D, yOffset, 0.30000001192092896D, 0.10000000149011612D, (yOffset + 0.05F), 0.3199999928474426D);
/* 110 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 112 */     renderblocks.func_147782_a(0.05000000074505806D, yOffset, 0.6800000071525574D, 0.10000000149011612D, (yOffset + 0.05F), 0.699999988079071D);
/* 113 */     renderblocks.func_147784_q(block, i, j, k);
/* 114 */     renderblocks.func_147782_a(0.05000000074505806D, yOffset, 0.7799999713897705D, 0.10000000149011612D, (yOffset + 0.05F), 0.800000011920929D);
/* 115 */     renderblocks.func_147784_q(block, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderRackDir2(Block block, int i, int j, int k, RenderBlocks renderblocks, float yOffset) {
/* 120 */     renderblocks.func_147782_a(0.0D, yOffset, 0.0D, 1.0D, (yOffset + 0.05F), 0.05000000074505806D);
/* 121 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 123 */     renderblocks.func_147782_a(0.20000000298023224D, yOffset, 0.05000000074505806D, 0.2199999988079071D, (yOffset + 0.05F), 0.10000000149011612D);
/* 124 */     renderblocks.func_147784_q(block, i, j, k);
/* 125 */     renderblocks.func_147782_a(0.30000001192092896D, yOffset, 0.05000000074505806D, 0.3199999928474426D, (yOffset + 0.05F), 0.10000000149011612D);
/* 126 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 128 */     renderblocks.func_147782_a(0.6800000071525574D, yOffset, 0.05000000074505806D, 0.699999988079071D, (yOffset + 0.05F), 0.10000000149011612D);
/* 129 */     renderblocks.func_147784_q(block, i, j, k);
/* 130 */     renderblocks.func_147782_a(0.7799999713897705D, yOffset, 0.05000000074505806D, 0.800000011920929D, (yOffset + 0.05F), 0.10000000149011612D);
/* 131 */     renderblocks.func_147784_q(block, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void renderRackDir3(Block block, int i, int j, int k, RenderBlocks renderblocks, float yOffset) {
/* 136 */     renderblocks.func_147782_a(0.949999988079071D, yOffset, 0.0D, 1.0D, (yOffset + 0.05F), 1.0D);
/* 137 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 139 */     renderblocks.func_147782_a(0.8999999761581421D, yOffset, 0.20000000298023224D, 0.949999988079071D, (yOffset + 0.05F), 0.2199999988079071D);
/* 140 */     renderblocks.func_147784_q(block, i, j, k);
/* 141 */     renderblocks.func_147782_a(0.8999999761581421D, yOffset, 0.30000001192092896D, 0.949999988079071D, (yOffset + 0.05F), 0.3199999928474426D);
/* 142 */     renderblocks.func_147784_q(block, i, j, k);
/*     */     
/* 144 */     renderblocks.func_147782_a(0.8999999761581421D, yOffset, 0.6800000071525574D, 0.949999988079071D, (yOffset + 0.05F), 0.699999988079071D);
/* 145 */     renderblocks.func_147784_q(block, i, j, k);
/* 146 */     renderblocks.func_147782_a(0.8999999761581421D, yOffset, 0.7799999713897705D, 0.949999988079071D, (yOffset + 0.05F), 0.800000011920929D);
/* 147 */     renderblocks.func_147784_q(block, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int meta, RenderBlocks renderer) {
/* 152 */     Tessellator var14 = Tessellator.field_78398_a;
/* 153 */     var14.func_78382_b();
/* 154 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 155 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 156 */     var14.func_78381_a();
/* 157 */     var14.func_78382_b();
/* 158 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 159 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 160 */     var14.func_78381_a();
/* 161 */     var14.func_78382_b();
/* 162 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 163 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 164 */     var14.func_78381_a();
/* 165 */     var14.func_78382_b();
/* 166 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 167 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 168 */     var14.func_78381_a();
/* 169 */     var14.func_78382_b();
/* 170 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 171 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 172 */     var14.func_78381_a();
/* 173 */     var14.func_78382_b();
/* 174 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 175 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 176 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderToolRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */