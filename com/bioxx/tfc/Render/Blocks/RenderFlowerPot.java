/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFlowerPot;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderFlowerPot
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*  23 */     renderer.func_147784_q(block, x, y, z);
/*  24 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  25 */     tessellator.func_78380_c(block.func_149677_c(world, x, y, z));
/*  26 */     int colorMult = block.func_149720_d(world, x, y, z);
/*  27 */     IIcon iicon = renderer.func_147777_a(block, 0);
/*  28 */     float r = (colorMult >> 16 & 0xFF) / 255.0F;
/*  29 */     float g = (colorMult >> 8 & 0xFF) / 255.0F;
/*  30 */     float b = (colorMult & 0xFF) / 255.0F;
/*     */ 
/*     */     
/*  33 */     if (EntityRenderer.field_78517_a) {
/*     */       
/*  35 */       float f1 = (r * 30.0F + g * 59.0F + b * 11.0F) / 100.0F;
/*  36 */       float g2 = (r * 30.0F + g * 70.0F) / 100.0F;
/*  37 */       float b2 = (r * 30.0F + b * 70.0F) / 100.0F;
/*  38 */       r = f1;
/*  39 */       g = g2;
/*  40 */       b = b2;
/*     */     } 
/*     */     
/*  43 */     tessellator.func_78386_a(r, g, b);
/*  44 */     float r2 = 0.1865F;
/*  45 */     renderer.func_147764_f(block, (x - 0.5F + r2), y, z, iicon);
/*  46 */     renderer.func_147798_e(block, (x + 0.5F - r2), y, z, iicon);
/*  47 */     renderer.func_147734_d(block, x, y, (z - 0.5F + r2), iicon);
/*  48 */     renderer.func_147761_c(block, x, y, (z + 0.5F - r2), iicon);
/*  49 */     renderer.func_147806_b(block, x, (y - 0.5F + r2 + 0.1875F), z, renderer.func_147745_b(Blocks.field_150346_d));
/*  50 */     TileEntity tileentity = world.func_147438_o(x, y, z);
/*     */     
/*  52 */     if (tileentity instanceof TileEntityFlowerPot) {
/*     */       
/*  54 */       Item item = ((TileEntityFlowerPot)tileentity).func_145965_a();
/*  55 */       int meta = ((TileEntityFlowerPot)tileentity).func_145966_b();
/*     */       
/*  57 */       if (item instanceof net.minecraft.item.ItemBlock) {
/*     */         
/*  59 */         Block plantedBlock = Block.func_149634_a(item);
/*  60 */         int renderType = plantedBlock.func_149645_b();
/*  61 */         float transX = 0.0F;
/*  62 */         float transY = 4.0F;
/*  63 */         float transZ = 0.0F;
/*  64 */         tessellator.func_78372_c(transX / 16.0F, transY / 16.0F, transZ / 16.0F);
/*  65 */         colorMult = plantedBlock.func_149720_d(world, x, y, z);
/*     */         
/*  67 */         if (colorMult != 16777215) {
/*     */           
/*  69 */           r = (colorMult >> 16 & 0xFF) / 255.0F;
/*  70 */           g = (colorMult >> 8 & 0xFF) / 255.0F;
/*  71 */           b = (colorMult & 0xFF) / 255.0F;
/*  72 */           tessellator.func_78386_a(r, g, b);
/*     */         } 
/*     */         
/*  75 */         if (renderType == 1) {
/*     */           
/*  77 */           renderer.func_147765_a(renderer.func_147787_a(plantedBlock, 0, meta), x, y, z, 0.75F);
/*     */         }
/*  79 */         else if (renderType == 13) {
/*     */           
/*  81 */           renderer.field_147837_f = true;
/*  82 */           float f9 = 0.125F;
/*  83 */           renderer.func_147782_a((0.5F - f9), 0.0D, (0.5F - f9), (0.5F + f9), 0.25D, (0.5F + f9));
/*  84 */           renderer.func_147784_q(plantedBlock, x, y, z);
/*  85 */           renderer.func_147782_a((0.5F - f9), 0.25D, (0.5F - f9), (0.5F + f9), 0.5D, (0.5F + f9));
/*  86 */           renderer.func_147784_q(plantedBlock, x, y, z);
/*  87 */           renderer.func_147782_a((0.5F - f9), 0.5D, (0.5F - f9), (0.5F + f9), 0.75D, (0.5F + f9));
/*  88 */           renderer.func_147784_q(plantedBlock, x, y, z);
/*  89 */           renderer.field_147837_f = false;
/*  90 */           renderer.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*     */         } 
/*     */         
/*  93 */         tessellator.func_78372_c(-transX / 16.0F, -transY / 16.0F, -transZ / 16.0F);
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 114 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderFlowerPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */