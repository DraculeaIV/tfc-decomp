/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEHopper;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBox;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TESRHopper
/*     */   extends TESRBase
/*     */ {
/*     */   public void renderAt(TEHopper te, double d, double d1, double d2, float f) {
/*  34 */     if (te.func_145831_w() != null)
/*     */     {
/*  36 */       if (te.pressBlock != null) {
/*     */         
/*  38 */         float sink = -0.34F + (te.pressCooldown / 20) / 800.0F * 0.25F;
/*  39 */         GL11.glPushMatrix();
/*  40 */         GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.33F, (float)d2 + 0.5F);
/*  41 */         GL11.glScalef(0.75F, 0.75F, 0.75F);
/*  42 */         GL11.glTranslatef(0.0F, sink, 0.0F);
/*  43 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/*  44 */         GL11.glDisable(2896);
/*  45 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  46 */         TESRBase.renderBlocks.func_147775_a(TFCBlocks.stoneIgInSmooth);
/*  47 */         renderPress(Block.func_149634_a(te.pressBlock.func_77973_b()), te.func_145831_w(), (int)d, (int)d1, (int)d2, te.pressBlock.func_77960_j());
/*  48 */         GL11.glEnable(2896);
/*  49 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPress(Block block, World world, int x, int y, int z, int meta) {
/*  56 */     float f = 0.5F;
/*  57 */     float f1 = 1.0F;
/*  58 */     float f2 = 0.8F;
/*  59 */     float f3 = 0.6F;
/*  60 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  61 */     tessellator.func_78382_b();
/*  62 */     tessellator.func_78386_a(f, f, f);
/*  63 */     renderBlocks.func_147768_a(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 0, meta));
/*  64 */     tessellator.func_78386_a(f1, f1, f1);
/*  65 */     renderBlocks.func_147806_b(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 1, meta));
/*  66 */     tessellator.func_78386_a(f2, f2, f2);
/*  67 */     renderBlocks.func_147761_c(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 2, meta));
/*  68 */     tessellator.func_78386_a(f2, f2, f2);
/*  69 */     renderBlocks.func_147734_d(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 3, meta));
/*  70 */     tessellator.func_78386_a(f3, f3, f3);
/*  71 */     renderBlocks.func_147798_e(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 4, meta));
/*  72 */     tessellator.func_78386_a(f3, f3, f3);
/*  73 */     renderBlocks.func_147764_f(block, -0.5D, -0.5D, -0.5D, renderBlocks.func_147787_a(block, 5, meta));
/*  74 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity te, double xDis, double yDis, double zDis, float f) {
/*  82 */     renderAt((TEHopper)te, xDis, yDis, zDis, f);
/*     */   }
/*     */   
/*     */   private class ModelPress
/*     */     extends ModelBase
/*     */   {
/*     */     private ModelBox pressModel;
/*     */     private ModelRenderer renderer;
/*     */     
/*     */     public ModelPress() {
/*  92 */       this.renderer = new ModelRenderer(this);
/*     */       
/*  94 */       this.pressModel = new ModelBox(this.renderer, 0, 0, 0.5F, 0.0F, 0.5F, 15, 4, 7, 1.0F);
/*  95 */       this.renderer.field_78804_l.add(this.pressModel);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_78088_a(Entity entity, float x, float y, float z, float maxX, float maxY, float maxZ) {
/* 101 */       this.renderer = new ModelRenderer(this);
/*     */       
/* 103 */       this.pressModel = new ModelBox(this.renderer, 0, 0, 2.0F, 16.0F, 2.0F, 12, 12, 12, 0.0F);
/* 104 */       this.renderer.field_78804_l.add(this.pressModel);
/*     */ 
/*     */       
/* 107 */       this.renderer.func_78785_a(0.0625F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */