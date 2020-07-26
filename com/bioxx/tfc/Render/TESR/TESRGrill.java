/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEGrill;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
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
/*     */ public class TESRGrill
/*     */   extends TESRBase
/*     */ {
/*     */   public void renderAt(TEGrill te, double d, double d1, double d2, float f) {
/*  25 */     if (te.func_145831_w() != null) {
/*     */       
/*  27 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/*  28 */       customitem.field_70290_d = 0.0F;
/*  29 */       float blockScale = 0.6F;
/*  30 */       float timeD = (float)(360.0D * (System.currentTimeMillis() & 0x3FFFL) / 16383.0D);
/*     */       
/*  32 */       if (RenderManager.field_78727_a.field_78733_k.field_74347_j) {
/*     */         
/*  34 */         if (te.func_70301_a(0) != null) {
/*     */           
/*  36 */           GL11.glPushMatrix();
/*  37 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.25F);
/*  38 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  39 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  40 */           customitem.func_92058_a(te.func_70301_a(0));
/*  41 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  42 */           GL11.glPopMatrix();
/*     */         } 
/*  44 */         if (te.func_70301_a(1) != null) {
/*     */           
/*  46 */           GL11.glPushMatrix();
/*  47 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.25F);
/*  48 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  49 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  50 */           customitem.func_92058_a(te.func_70301_a(1));
/*  51 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  52 */           GL11.glPopMatrix();
/*     */         } 
/*  54 */         if (te.func_70301_a(2) != null) {
/*     */           
/*  56 */           GL11.glPushMatrix();
/*  57 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.5F);
/*  58 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  59 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  60 */           customitem.func_92058_a(te.func_70301_a(2));
/*  61 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  62 */           GL11.glPopMatrix();
/*     */         } 
/*  64 */         if (te.func_70301_a(3) != null) {
/*     */           
/*  66 */           GL11.glPushMatrix();
/*  67 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.5F);
/*  68 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  69 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  70 */           customitem.func_92058_a(te.func_70301_a(3));
/*  71 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  72 */           GL11.glPopMatrix();
/*     */         } 
/*  74 */         if (te.func_70301_a(4) != null) {
/*     */           
/*  76 */           GL11.glPushMatrix();
/*  77 */           GL11.glTranslatef((float)d + 0.25F, (float)d1 + 0.0F, (float)d2 + 0.75F);
/*  78 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  79 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  80 */           customitem.func_92058_a(te.func_70301_a(4));
/*  81 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  82 */           GL11.glPopMatrix();
/*     */         } 
/*  84 */         if (te.func_70301_a(5) != null)
/*     */         {
/*  86 */           GL11.glPushMatrix();
/*  87 */           GL11.glTranslatef((float)d + 0.75F, (float)d1 + 0.0F, (float)d2 + 0.75F);
/*  88 */           GL11.glRotatef(timeD, 0.0F, 1.0F, 0.0F);
/*  89 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  90 */           customitem.func_92058_a(te.func_70301_a(5));
/*  91 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  92 */           GL11.glPopMatrix();
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/*  98 */         GL11.glPushMatrix();
/*  99 */         GL11.glTranslated(d, d1 + 0.001D, d2);
/* 100 */         drawItem(te, 0, 0.05D, 0.35D, 0.05D, 0.35D);
/* 101 */         drawItem(te, 1, 0.65D, 0.95D, 0.05D, 0.35D);
/* 102 */         drawItem(te, 2, 0.05D, 0.35D, 0.35D, 0.65D);
/* 103 */         drawItem(te, 3, 0.65D, 0.95D, 0.35D, 0.65D);
/* 104 */         drawItem(te, 4, 0.05D, 0.35D, 0.65D, 0.95D);
/* 105 */         drawItem(te, 5, 0.65D, 0.95D, 0.65D, 0.95D);
/* 106 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawItem(TEGrill te, int index, double minX, double maxX, double minZ, double maxZ) {
/* 113 */     if (te.storage[index] != null) {
/*     */       
/* 115 */       float minU = te.storage[index].func_77954_c().func_94209_e();
/* 116 */       float maxU = te.storage[index].func_77954_c().func_94212_f();
/* 117 */       float minV = te.storage[index].func_77954_c().func_94206_g();
/* 118 */       float maxV = te.storage[index].func_77954_c().func_94210_h();
/* 119 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 120 */       tessellator.func_78382_b();
/* 121 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 122 */       tessellator.func_78374_a(minX, 0.0D, maxZ, minU, maxV);
/* 123 */       tessellator.func_78374_a(maxX, 0.0D, maxZ, maxU, maxV);
/* 124 */       tessellator.func_78374_a(maxX, 0.0D, minZ, maxU, minV);
/* 125 */       tessellator.func_78374_a(minX, 0.0D, minZ, minU, minV);
/* 126 */       tessellator.func_78381_a();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 133 */     renderAt((TEGrill)par1TileEntity, par2, par4, par6, par8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */