/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockAnvil;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.init.Blocks;
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
/*     */ public class TESRAnvil
/*     */   extends TESRBase
/*     */ {
/*     */   public void renderAt(TEAnvil te, double d, double d1, double d2, float f) {
/*  26 */     if (te.func_145831_w() != null) {
/*     */       
/*  28 */       int dir = BlockAnvil.getDirectionFromMetadata(te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d, te.field_145849_e));
/*     */       
/*  30 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/*  31 */       customitem.field_70290_d = 0.0F;
/*  32 */       float blockScale = 1.0F;
/*     */       
/*  34 */       drawItem(te, d, d1, d2, dir, customitem, blockScale, 0);
/*  35 */       drawItem(te, d, d1, d2, dir, customitem, blockScale, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawItem(TEAnvil te, double d, double d1, double d2, int dir, EntityItem customitem, float blockScale, int i) {
/*  42 */     if (te.func_70301_a(i) != null) {
/*     */       
/*  44 */       float[] pos = getLocation(dir, i, (Block.func_149729_e(te.stonePair[0]) != null));
/*  45 */       if (Block.func_149729_e(te.stonePair[0]) != Blocks.field_150350_a)
/*  46 */         pos[1] = pos[1] + 0.3F; 
/*  47 */       GL11.glPushMatrix();
/*     */       
/*  49 */       GL11.glTranslatef((float)d + pos[0], (float)d1 + pos[1], (float)d2 + pos[2]);
/*  50 */       if (RenderManager.field_78727_a.field_78733_k.field_74347_j)
/*  51 */         GL11.glRotatef(pos[3], pos[4], pos[5], pos[6]); 
/*  52 */       GL11.glScalef(pos[7], pos[8], pos[9]);
/*  53 */       customitem.func_92058_a(te.func_70301_a(i));
/*  54 */       itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*     */       
/*  56 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getLocation(int dir, int slot, boolean isStone) {
/*  62 */     float[] out = new float[10];
/*  63 */     out[7] = 1.0F;
/*  64 */     out[8] = 1.0F;
/*  65 */     out[9] = 1.0F;
/*     */     
/*  67 */     if (dir == 0) {
/*     */       
/*  69 */       out[3] = 90.0F;
/*  70 */       out[4] = 1.0F;
/*  71 */       out[5] = 0.0F;
/*  72 */       out[6] = 0.0F;
/*  73 */       if (slot == 0)
/*     */       {
/*  75 */         out[0] = 0.55F;
/*  76 */         out[1] = 0.61F;
/*  77 */         out[2] = 0.45F;
/*     */       }
/*  79 */       else if (slot == 1)
/*     */       {
/*  81 */         out[0] = 0.55F;
/*  82 */         out[1] = 0.61F;
/*  83 */         out[2] = 0.05F;
/*     */         
/*  85 */         out[7] = 0.8F;
/*  86 */         out[8] = 0.8F;
/*  87 */         out[9] = 0.8F;
/*     */       }
/*     */     
/*  90 */     } else if (dir == 1) {
/*     */       
/*  92 */       out[3] = 90.0F;
/*  93 */       out[4] = 1.0F;
/*  94 */       out[5] = 0.0F;
/*  95 */       out[6] = 0.0F;
/*  96 */       if (slot == 0) {
/*     */         
/*  98 */         out[0] = 0.25F;
/*  99 */         out[1] = 0.61F;
/* 100 */         out[2] = 0.25F;
/*     */       }
/* 102 */       else if (slot == 1) {
/*     */         
/* 104 */         out[0] = 0.75F;
/* 105 */         out[1] = 0.61F;
/* 106 */         out[2] = 0.25F;
/*     */         
/* 108 */         out[7] = 0.8F;
/* 109 */         out[8] = 0.8F;
/* 110 */         out[9] = 0.8F;
/*     */       } 
/*     */     } 
/* 113 */     return out;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity te, double xDis, double yDis, double zDis, float f) {
/* 119 */     renderAt((TEAnvil)te, xDis, yDis, zDis, f);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */