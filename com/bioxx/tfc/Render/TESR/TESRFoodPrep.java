/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.tileentity.TileEntity;
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
/*     */ public class TESRFoodPrep
/*     */   extends TESRBase
/*     */ {
/*     */   public void renderAt(TEFoodPrep te, double d, double d1, double d2, float f) {
/*  28 */     if (te.func_145831_w() != null) {
/*     */       
/*  30 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/*  31 */       customitem.field_70290_d = 0.0F;
/*  32 */       float blockScale = 0.6F;
/*  33 */       float timeD = (float)(360.0D * (System.currentTimeMillis() & 0x3FFFL) / 16383.0D);
/*     */       
/*  35 */       if (RenderManager.field_78727_a.field_78733_k.field_74347_j) {
/*     */         
/*  37 */         if (te.func_70301_a(0) != null) {
/*     */           
/*  39 */           GL11.glPushMatrix();
/*  40 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.25F);
/*  41 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  42 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  43 */           customitem.func_92058_a(te.func_70301_a(0));
/*  44 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  45 */           GL11.glPopMatrix();
/*     */         } 
/*  47 */         if (te.func_70301_a(1) != null) {
/*     */           
/*  49 */           GL11.glPushMatrix();
/*  50 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.25F);
/*  51 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  52 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  53 */           customitem.func_92058_a(te.func_70301_a(1));
/*  54 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  55 */           GL11.glPopMatrix();
/*     */         } 
/*  57 */         if (te.func_70301_a(2) != null) {
/*     */           
/*  59 */           GL11.glPushMatrix();
/*  60 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.5F);
/*  61 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  62 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  63 */           customitem.func_92058_a(te.func_70301_a(2));
/*  64 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  65 */           GL11.glPopMatrix();
/*     */         } 
/*  67 */         if (te.func_70301_a(3) != null) {
/*     */           
/*  69 */           GL11.glPushMatrix();
/*  70 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.5F);
/*  71 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  72 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  73 */           customitem.func_92058_a(te.func_70301_a(3));
/*  74 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  75 */           GL11.glPopMatrix();
/*     */         } 
/*  77 */         if (te.func_70301_a(4) != null) {
/*     */           
/*  79 */           GL11.glPushMatrix();
/*  80 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.75F);
/*  81 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  82 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  83 */           customitem.func_92058_a(te.func_70301_a(4));
/*  84 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  85 */           GL11.glPopMatrix();
/*     */         } 
/*  87 */         if (te.func_70301_a(6) != null)
/*     */         {
/*  89 */           GL11.glPushMatrix();
/*  90 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.75F);
/*  91 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  92 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  93 */           customitem.func_92058_a(te.func_70301_a(6));
/*  94 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  95 */           GL11.glPopMatrix();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 100 */         GL11.glPushMatrix();
/* 101 */         GL11.glTranslated(d, d1 + 0.001D, d2);
/* 102 */         drawItem(te, 0, 0.05D, 0.35D, 0.05D, 0.35D);
/* 103 */         drawItem(te, 1, 0.65D, 0.95D, 0.05D, 0.35D);
/* 104 */         drawItem(te, 2, 0.05D, 0.35D, 0.35D, 0.65D);
/* 105 */         drawItem(te, 3, 0.65D, 0.95D, 0.35D, 0.65D);
/* 106 */         drawItem(te, 4, 0.05D, 0.35D, 0.65D, 0.95D);
/* 107 */         drawItem(te, 6, 0.65D, 0.95D, 0.65D, 0.95D);
/* 108 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawItem(TEFoodPrep te, int index, double minX, double maxX, double minZ, double maxZ) {
/* 115 */     if (te.storage[index] != null && !(te.storage[index].func_77973_b() instanceof net.minecraft.item.ItemBlock)) {
/*     */       
/* 117 */       TFC_Core.bindTexture(TextureMap.field_110576_c);
/* 118 */       float minU = te.storage[index].func_77954_c().func_94209_e();
/* 119 */       float maxU = te.storage[index].func_77954_c().func_94212_f();
/* 120 */       float minV = te.storage[index].func_77954_c().func_94206_g();
/* 121 */       float maxV = te.storage[index].func_77954_c().func_94210_h();
/* 122 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 123 */       tessellator.func_78382_b();
/* 124 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 125 */       tessellator.func_78374_a(minX, 0.0D, maxZ, minU, maxV);
/* 126 */       tessellator.func_78374_a(maxX, 0.0D, maxZ, maxU, maxV);
/* 127 */       tessellator.func_78374_a(maxX, 0.0D, minZ, maxU, minV);
/* 128 */       tessellator.func_78374_a(minX, 0.0D, minZ, minU, minV);
/* 129 */       tessellator.func_78381_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 136 */     renderAt((TEFoodPrep)par1TileEntity, par2, par4, par6, par8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */