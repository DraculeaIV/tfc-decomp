/*     */ package com.bioxx.tfc.Render.TESR;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEToolRack;
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
/*     */ public class TESRToolrack
/*     */   extends TESRBase
/*     */ {
/*     */   public void renderAt(TEToolRack te, double d, double d1, double d2, float f) {
/*  22 */     if (te.func_145831_w() != null) {
/*     */       
/*  24 */       int dir = te.func_145831_w().func_72805_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*     */       
/*  26 */       EntityItem customitem = new EntityItem(this.field_147501_a.field_147550_f);
/*  27 */       customitem.field_70290_d = 0.0F;
/*  28 */       float blockScale = 1.0F;
/*     */       
/*  30 */       for (int i = 0; i < 4; i++) {
/*     */         
/*  32 */         if (te.func_70301_a(i) != null) {
/*     */           
/*  34 */           float[] loc = getLocation(dir, i);
/*  35 */           GL11.glPushMatrix();
/*  36 */           GL11.glTranslatef((float)d + loc[0], (float)d1 + loc[1], (float)d2 + loc[2]);
/*  37 */           if (RenderManager.field_78727_a.field_78733_k.field_74347_j)
/*     */           {
/*  39 */             GL11.glRotatef(loc[3], 0.0F, 1.0F, 0.0F);
/*     */           }
/*  41 */           GL11.glScalef(blockScale, blockScale, blockScale);
/*  42 */           customitem.func_92058_a(te.func_70301_a(i));
/*  43 */           itemRenderer.func_76986_a(customitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  44 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getLocation(int dir, int slot) {
/*  52 */     float[] out = new float[4];
/*  53 */     if (dir == 0) {
/*     */       
/*  55 */       out[3] = 0.0F;
/*  56 */       if (slot == 0)
/*     */       {
/*  58 */         out[0] = 0.25F;
/*  59 */         out[1] = 0.5F;
/*  60 */         out[2] = 0.94F;
/*     */       }
/*  62 */       else if (slot == 1)
/*     */       {
/*  64 */         out[0] = 0.75F;
/*  65 */         out[1] = 0.5F;
/*  66 */         out[2] = 0.94F;
/*     */       }
/*  68 */       else if (slot == 2)
/*     */       {
/*  70 */         out[0] = 0.25F;
/*  71 */         out[1] = 0.1F;
/*  72 */         out[2] = 0.94F;
/*     */       }
/*  74 */       else if (slot == 3)
/*     */       {
/*  76 */         out[0] = 0.75F;
/*  77 */         out[1] = 0.1F;
/*  78 */         out[2] = 0.94F;
/*     */       }
/*     */     
/*  81 */     } else if (dir == 1) {
/*     */       
/*  83 */       out[3] = 270.0F;
/*  84 */       if (slot == 0)
/*     */       {
/*  86 */         out[0] = 0.06F;
/*  87 */         out[1] = 0.5F;
/*  88 */         out[2] = 0.25F;
/*     */       }
/*  90 */       else if (slot == 1)
/*     */       {
/*  92 */         out[0] = 0.06F;
/*  93 */         out[1] = 0.5F;
/*  94 */         out[2] = 0.75F;
/*     */       }
/*  96 */       else if (slot == 2)
/*     */       {
/*  98 */         out[0] = 0.06F;
/*  99 */         out[1] = 0.1F;
/* 100 */         out[2] = 0.25F;
/*     */       }
/* 102 */       else if (slot == 3)
/*     */       {
/* 104 */         out[0] = 0.06F;
/* 105 */         out[1] = 0.1F;
/* 106 */         out[2] = 0.75F;
/*     */       }
/*     */     
/* 109 */     } else if (dir == 2) {
/*     */       
/* 111 */       out[3] = 180.0F;
/* 112 */       if (slot == 0)
/*     */       {
/* 114 */         out[0] = 0.25F;
/* 115 */         out[1] = 0.5F;
/* 116 */         out[2] = 0.06F;
/*     */       }
/* 118 */       else if (slot == 1)
/*     */       {
/* 120 */         out[0] = 0.75F;
/* 121 */         out[1] = 0.5F;
/* 122 */         out[2] = 0.06F;
/*     */       }
/* 124 */       else if (slot == 2)
/*     */       {
/* 126 */         out[0] = 0.25F;
/* 127 */         out[1] = 0.1F;
/* 128 */         out[2] = 0.06F;
/*     */       }
/* 130 */       else if (slot == 3)
/*     */       {
/* 132 */         out[0] = 0.75F;
/* 133 */         out[1] = 0.1F;
/* 134 */         out[2] = 0.06F;
/*     */       }
/*     */     
/* 137 */     } else if (dir == 3) {
/*     */       
/* 139 */       out[3] = 90.0F;
/* 140 */       if (slot == 0) {
/*     */         
/* 142 */         out[0] = 0.94F;
/* 143 */         out[1] = 0.5F;
/* 144 */         out[2] = 0.25F;
/*     */       }
/* 146 */       else if (slot == 1) {
/*     */         
/* 148 */         out[0] = 0.94F;
/* 149 */         out[1] = 0.5F;
/* 150 */         out[2] = 0.75F;
/*     */       }
/* 152 */       else if (slot == 2) {
/*     */         
/* 154 */         out[0] = 0.94F;
/* 155 */         out[1] = 0.1F;
/* 156 */         out[2] = 0.25F;
/*     */       }
/* 158 */       else if (slot == 3) {
/*     */         
/* 160 */         out[0] = 0.94F;
/* 161 */         out[1] = 0.1F;
/* 162 */         out[2] = 0.75F;
/*     */       } 
/*     */     } 
/* 165 */     return out;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
/* 171 */     renderAt((TEToolRack)par1TileEntity, par2, par4, par6, par8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESR\TESRToolrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */