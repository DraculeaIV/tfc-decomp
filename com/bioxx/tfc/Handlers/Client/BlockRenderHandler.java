/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Render.Blocks.RenderAnvil;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderCrop;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderDetailed;
/*     */ import com.bioxx.tfc.Render.Blocks.RenderGrass;
/*     */ import com.bioxx.tfc.Render.TFC_CoreRender;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockRenderHandler
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer) {
/*  25 */     if (modelId == TFCBlocks.sulfurRenderId)
/*     */     {
/*  27 */       return TFC_CoreRender.renderSulfur(block, i, j, k, renderer);
/*     */     }
/*  29 */     if (modelId == TFCBlocks.moltenRenderId)
/*     */     {
/*  31 */       return TFC_CoreRender.renderMolten(block, i, j, k, renderer);
/*     */     }
/*  33 */     if (modelId == TFCBlocks.grassRenderId)
/*     */     {
/*  35 */       return RenderGrass.render(block, i, j, k, renderer);
/*     */     }
/*  37 */     if (modelId == TFCBlocks.clayGrassRenderId)
/*     */     {
/*  39 */       return RenderGrass.renderClay(block, i, j, k, renderer);
/*     */     }
/*  41 */     if (modelId == TFCBlocks.peatGrassRenderId)
/*     */     {
/*  43 */       return RenderGrass.renderPeat(block, i, j, k, renderer);
/*     */     }
/*  45 */     if (modelId == TFCBlocks.looseRockRenderId)
/*     */     {
/*  47 */       return TFC_CoreRender.renderLooseRock(block, i, j, k, renderer);
/*     */     }
/*  49 */     if (modelId == TFCBlocks.snowRenderId)
/*     */     {
/*  51 */       return TFC_CoreRender.renderSnow(block, i, j, k, renderer);
/*     */     }
/*  53 */     if (modelId == TFCBlocks.firepitRenderId)
/*     */     {
/*  55 */       return TFC_CoreRender.renderFirepit(block, i, j, k, renderer);
/*     */     }
/*  57 */     if (modelId == TFCBlocks.forgeRenderId)
/*     */     {
/*  59 */       return TFC_CoreRender.renderForge(block, i, j, k, renderer);
/*     */     }
/*  61 */     if (modelId == TFCBlocks.anvilRenderId)
/*     */     {
/*  63 */       return RenderAnvil.renderAnvil(block, i, j, k, renderer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     if (modelId == TFCBlocks.sluiceRenderId)
/*     */     {
/*  75 */       return TFC_CoreRender.renderSluice(block, i, j, k, renderer);
/*     */     }
/*  77 */     if (modelId == TFCBlocks.woodFruitRenderId)
/*     */     {
/*  79 */       return TFC_CoreRender.renderWoodTrunk(block, i, j, k, renderer);
/*     */     }
/*  81 */     if (modelId == TFCBlocks.leavesFruitRenderId)
/*     */     {
/*  83 */       return TFC_CoreRender.renderFruitLeaves(block, i, j, k, renderer);
/*     */     }
/*  85 */     if (modelId == TFCBlocks.stairRenderId)
/*     */     {
/*  87 */       return TFC_CoreRender.renderBlockStairs(block, i, j, k, renderer);
/*     */     }
/*  89 */     if (modelId == TFCBlocks.slabRenderId)
/*     */     {
/*  91 */       return TFC_CoreRender.renderBlockSlab(block, i, j, k, renderer);
/*     */     }
/*  93 */     if (modelId == TFCBlocks.cropRenderId)
/*     */     {
/*  95 */       return RenderCrop.render(block, i, j, k, renderer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (modelId == TFCBlocks.detailedRenderId)
/*     */     {
/* 107 */       return RenderDetailed.renderBlockDetailed(block, i, j, k, renderer);
/*     */     }
/* 109 */     if (modelId == TFCBlocks.waterPlantRenderId)
/*     */     {
/* 111 */       return TFC_CoreRender.renderSeaPlant(block, i, j, k, renderer);
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int i) {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 125 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
/* 131 */     IIcon[] icons = new IIcon[6];
/*     */     
/* 133 */     if (modelID == TFCBlocks.peatGrassRenderId) {
/*     */       
/* 135 */       for (int i = 0; i < 6; i++)
/* 136 */         icons[i] = TFCBlocks.peat.func_149733_h(i); 
/* 137 */       renderInvBlock(block, renderer, icons);
/*     */     }
/* 139 */     else if (modelID == TFCBlocks.grassRenderId) {
/*     */       
/* 141 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 143 */         if (block == TFCBlocks.dirt) {
/* 144 */           icons[i] = TFCBlocks.dirt.func_149733_h(i);
/*     */         } else {
/* 146 */           icons[i] = TFCBlocks.dirt2.func_149733_h(i);
/*     */         } 
/* 148 */       }  renderInvBlock(block, renderer, icons);
/*     */     }
/* 150 */     else if (modelID == TFCBlocks.clayGrassRenderId) {
/*     */       
/* 152 */       for (int i = 0; i < 6; i++) {
/*     */         
/* 154 */         if (block == TFCBlocks.clay) {
/* 155 */           icons[i] = TFCBlocks.clay.func_149733_h(i);
/*     */         } else {
/* 157 */           icons[i] = TFCBlocks.clay2.func_149733_h(i);
/*     */         } 
/* 159 */       }  renderInvBlock(block, renderer, icons);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderInvBlock(Block block, RenderBlocks renderer, IIcon[] icons) {
/* 165 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 166 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 167 */     tessellator.func_78382_b();
/* 168 */     tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 169 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, icons[0]);
/* 170 */     tessellator.func_78381_a();
/* 171 */     tessellator.func_78382_b();
/* 172 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 173 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, icons[1]);
/* 174 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149733_h(1));
/* 175 */     tessellator.func_78381_a();
/* 176 */     tessellator.func_78382_b();
/* 177 */     tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 178 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, icons[2]);
/* 179 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149733_h(2));
/* 180 */     tessellator.func_78381_a();
/* 181 */     tessellator.func_78382_b();
/* 182 */     tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 183 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, icons[3]);
/* 184 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149733_h(3));
/* 185 */     tessellator.func_78381_a();
/* 186 */     tessellator.func_78382_b();
/* 187 */     tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 188 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, icons[4]);
/* 189 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149733_h(4));
/* 190 */     tessellator.func_78381_a();
/* 191 */     tessellator.func_78382_b();
/* 192 */     tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 193 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, icons[5]);
/* 194 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149733_h(5));
/* 195 */     tessellator.func_78381_a();
/* 196 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\BlockRenderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */