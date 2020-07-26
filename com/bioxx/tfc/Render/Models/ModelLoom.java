/*     */ package com.bioxx.tfc.Render.Models;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TELoom;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.model.PositionTextureVertex;
/*     */ import net.minecraft.client.model.TexturedQuad;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ public class ModelLoom
/*     */   extends ModelBase
/*     */ {
/*     */   private ModelRenderer loomPole1;
/*     */   private ModelRenderer loomPole2;
/*     */   private TexturedQuad[] initialString;
/*     */   private TexturedQuad[] finalString;
/*     */   private TexturedQuad clothRender;
/*     */   private PositionTextureVertex vert0;
/*     */   private PositionTextureVertex vert1;
/*     */   private PositionTextureVertex vert2;
/*     */   private PositionTextureVertex vert3;
/*     */   public int cloth;
/*  34 */   private float pole1StringY = 14.5F;
/*  35 */   private float pole2StringY = 14.5F;
/*     */   
/*     */   public int tempNum;
/*     */   
/*     */   public long tempTime;
/*     */   
/*     */   public boolean clothIncrease;
/*     */   
/*  43 */   public int mod = 40;
/*     */   
/*     */   public int lastClothIncrease;
/*     */   public boolean stillWeaving;
/*     */   
/*     */   public ModelLoom() {
/*  49 */     this.loomPole2 = new ModelRenderer(this, 38, 0);
/*  50 */     this.loomPole2.func_78789_a(0.0F, 0.0F, 0.0F, 14, 1, 1);
/*  51 */     this.loomPole2.func_78793_a(1.0F, 1.65F, 10.0F);
/*     */     
/*  53 */     this.loomPole1 = new ModelRenderer(this, 38, 0);
/*  54 */     this.loomPole1.func_78789_a(0.0F, 0.0F, 0.0F, 14, 1, 1);
/*  55 */     this.loomPole1.func_78793_a(1.0F, 4.85F, 10.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setRotationRadians(ModelRenderer model, float x, float y, float z) {
/*  67 */     model.field_78795_f = x;
/*  68 */     model.field_78796_g = y;
/*  69 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setRotationDegrees(ModelRenderer model, float x, float y, float z) {
/*  80 */     setRotationRadians(model, (float)Math.toRadians(x), (float)Math.toRadians(y), (float)Math.toRadians(z));
/*     */   }
/*     */   
/*     */   public void render(int numStrings, int numMaxStrings, int tick, boolean shouldClothIncrease, int tickMod, ResourceLocation stringTex, boolean isWeaving, boolean stillWeaving, TELoom te) {
/*  84 */     float renderOffsetPole2 = 9.0F;
/*  85 */     float renderOffsetPole1 = 9.0F;
/*     */     
/*  87 */     this.initialString = new TexturedQuad[numMaxStrings];
/*  88 */     this.finalString = new TexturedQuad[numMaxStrings];
/*     */ 
/*     */ 
/*     */     
/*  92 */     float stringStartZ = 11.9F;
/*     */     
/*  94 */     float stringWidth = 9.5F / numMaxStrings;
/*  95 */     float stringStartX = 3.25F;
/*     */     
/*  97 */     float pole2Height = 2.15F;
/*  98 */     float pole1Height = 5.35F;
/*     */     
/* 100 */     if (this.cloth == 0) {
/* 101 */       this.pole1StringY = 14.5F;
/* 102 */       this.pole2StringY = 14.5F;
/*     */     } 
/*     */     
/* 105 */     if (shouldClothIncrease) {
/* 106 */       this.cloth++;
/*     */     }
/*     */     
/* 109 */     if (shouldClothIncrease && tick >= tickMod / 4 - 1 && tick < 3 * tickMod / 4 - 1) {
/*     */       
/* 111 */       this.pole1StringY = this.pole2StringY - stringWidth;
/*     */     }
/* 113 */     else if (shouldClothIncrease && (tick >= 3 * tickMod / 4 - 1 || tick < tickMod / 4 - 1)) {
/*     */       
/* 115 */       this.pole2StringY = this.pole1StringY - stringWidth;
/*     */     } 
/*     */     
/* 118 */     if (tick >= tickMod / 2 && (isWeaving || (stillWeaving && renderOffsetPole1 != 9.0F))) {
/*     */       
/* 120 */       renderOffsetPole1 = 7.0F + (float)(2.0D * Math.cos((tick / (tickMod / 4)) * Math.PI));
/*     */     }
/* 122 */     else if (isWeaving || (stillWeaving && renderOffsetPole2 != 9.0F)) {
/*     */       
/* 124 */       renderOffsetPole2 = 7.0F + (float)(2.0D * Math.cos((tick / (tickMod / 4)) * Math.PI));
/*     */     } 
/*     */     
/* 127 */     if (this.cloth >= numMaxStrings && shouldClothIncrease) {
/* 128 */       resetCloth(te);
/*     */     }
/*     */     
/* 131 */     this.loomPole2.func_78793_a(1.0F, 1.65F, renderOffsetPole2);
/* 132 */     this.loomPole1.func_78793_a(1.0F, 4.85F, renderOffsetPole1);
/*     */     
/* 134 */     GL11.glPushMatrix();
/* 135 */     GL11.glRotatef(te.rotation * -90.0F, 0.0F, 1.0F, 0.0F);
/* 136 */     switch (te.rotation) {
/*     */       case 1:
/* 138 */         GL11.glTranslatef(0.0F, 0.0F, -1.0F); break;
/* 139 */       case 2: GL11.glTranslatef(-1.0F, 0.0F, -1.0F); break;
/* 140 */       case 3: GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
/*     */         break;
/*     */     } 
/* 143 */     this.loomPole2.func_78785_a(0.0625F);
/* 144 */     this.loomPole1.func_78785_a(0.0625F);
/*     */     
/* 146 */     TFC_Core.bindTexture(stringTex);
/*     */     
/* 148 */     float string1Z = Math.min(renderOffsetPole1 + 4.25F, 12.0F);
/* 149 */     float string2Z = Math.min(renderOffsetPole2 + 4.25F, 12.0F);
/*     */     
/* 151 */     float string1Length = (float)Math.sqrt(Math.pow((stringStartZ - string1Z), 2.0D) + Math.pow((this.pole1StringY - pole1Height), 1.0D));
/* 152 */     float string2Length = (float)Math.sqrt(Math.pow((stringStartZ - string2Z), 2.0D) + Math.pow((this.pole2StringY - pole2Height), 1.0D));
/*     */     
/* 154 */     float string1FinalLength = (float)Math.sqrt(Math.pow((stringStartZ - string1Z), 2.0D) + Math.pow(pole1Height, 1.0D));
/* 155 */     float string2FinalLength = (float)Math.sqrt(Math.pow((stringStartZ - string2Z), 2.0D) + Math.pow(pole2Height, 1.0D));
/*     */     int i;
/* 157 */     for (i = 0; i < numStrings; i += 2) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       this.vert0 = new PositionTextureVertex(stringStartX + i * stringWidth, this.pole2StringY, stringStartZ, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       this.vert1 = new PositionTextureVertex(stringStartX + stringWidth + i * stringWidth, this.pole2StringY, stringStartZ, 0.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       this.vert2 = new PositionTextureVertex(stringStartX + i * stringWidth, pole2Height, string2Z, 8.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       this.vert3 = new PositionTextureVertex(stringStartX + stringWidth + i * stringWidth, pole2Height, string2Z, 8.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       this.initialString[i] = new TexturedQuad(new PositionTextureVertex[] { this.vert2, this.vert3, this.vert1, this.vert0 }, 0, 0, 1, (int)string2Length, 16.0F, 16.0F);
/*     */ 
/*     */ 
/*     */       
/* 187 */       this.vert0 = new PositionTextureVertex(stringStartX + i * stringWidth, pole2Height, string2Z, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       this.vert1 = new PositionTextureVertex(stringStartX + stringWidth + i * stringWidth, pole2Height, string2Z, 0.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       this.vert2 = new PositionTextureVertex(stringStartX + i * stringWidth, 0.0F, stringStartZ, 8.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 202 */       this.vert3 = new PositionTextureVertex(stringStartX + stringWidth + i * stringWidth, 0.0F, stringStartZ, 8.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 208 */       this.finalString[i] = new TexturedQuad(new PositionTextureVertex[] { this.vert2, this.vert3, this.vert1, this.vert0 }, 0, 0, 1, (int)string2FinalLength, 16.0F, 16.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 215 */       this.vert0 = new PositionTextureVertex(stringStartX + (i + 1) * stringWidth, this.pole1StringY, stringStartZ, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       this.vert1 = new PositionTextureVertex(stringStartX + stringWidth + (i + 1) * stringWidth, this.pole1StringY, stringStartZ, 0.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       this.vert2 = new PositionTextureVertex(stringStartX + (i + 1) * stringWidth, pole1Height, string1Z, 8.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 230 */       this.vert3 = new PositionTextureVertex(stringStartX + stringWidth + (i + 1) * stringWidth, pole1Height, string1Z, 8.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       if (i + 1 < numStrings) {
/* 236 */         this.initialString[i + 1] = new TexturedQuad(new PositionTextureVertex[] { this.vert2, this.vert3, this.vert1, this.vert0 }, 0, 0, 1, (int)string1Length, 16.0F, 16.0F);
/*     */ 
/*     */         
/* 239 */         this.vert0 = new PositionTextureVertex(stringStartX + (i + 1) * stringWidth, pole1Height, string1Z, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 244 */         this.vert1 = new PositionTextureVertex(stringStartX + stringWidth + (i + 1) * stringWidth, pole1Height, string1Z, 0.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 249 */         this.vert2 = new PositionTextureVertex(stringStartX + (i + 1) * stringWidth, 0.0F, stringStartZ, 8.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 254 */         this.vert3 = new PositionTextureVertex(stringStartX + stringWidth + (i + 1) * stringWidth, 0.0F, stringStartZ, 8.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 260 */         this.finalString[i + 1] = new TexturedQuad(new PositionTextureVertex[] { this.vert2, this.vert3, this.vert1, this.vert0 }, 0, 0, 1, (int)string1FinalLength, 16.0F, 16.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     this.vert0 = new PositionTextureVertex(stringStartX, 14.5F, stringStartZ, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 269 */     this.vert1 = new PositionTextureVertex(stringStartX + numStrings * stringWidth, 14.5F, stringStartZ, 0.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     this.vert2 = new PositionTextureVertex(stringStartX, 14.5F - this.cloth * stringWidth, stringStartZ, 8.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     this.vert3 = new PositionTextureVertex(stringStartX + numStrings * stringWidth, 14.5F - this.cloth * stringWidth, stringStartZ, 8.0F, 8.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     this.clothRender = new TexturedQuad(new PositionTextureVertex[] { this.vert0, this.vert1, this.vert3, this.vert2 }, 0, 0, 16, this.cloth, 16.0F, 16.0F);
/*     */     
/* 287 */     GL11.glPushMatrix();
/* 288 */     GL11.glDisable(2884);
/* 289 */     for (i = 0; i < numStrings; i++) {
/* 290 */       this.initialString[i].func_78236_a(Tessellator.field_78398_a, 0.0625F);
/* 291 */       this.finalString[i].func_78236_a(Tessellator.field_78398_a, 0.0625F);
/*     */     } 
/* 293 */     this.clothRender.func_78236_a(Tessellator.field_78398_a, 0.0625F);
/* 294 */     GL11.glEnable(2884);
/* 295 */     GL11.glPopMatrix();
/* 296 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void updateCloth(int newCloth) {
/* 300 */     this.cloth = newCloth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetCloth(TELoom te) {
/* 305 */     te.finishCloth();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Models\ModelLoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */