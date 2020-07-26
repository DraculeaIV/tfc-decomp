/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiContainerTFC
/*     */   extends GuiContainer
/*     */ {
/*     */   protected boolean drawInventory = true;
/*     */   protected Slot activeSlot;
/*     */   
/*     */   public GuiContainerTFC(Container container, int xsize, int ysize) {
/*  27 */     super(container);
/*  28 */     this.field_146999_f = xsize;
/*  29 */     this.field_147000_g = ysize + PlayerInventory.invYSize;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setDrawInventory(boolean b) {
/*  34 */     if (!this.drawInventory && b) {
/*  35 */       this.field_147000_g += PlayerInventory.invYSize;
/*  36 */     } else if (this.drawInventory && !b) {
/*  37 */       this.field_147000_g -= PlayerInventory.invYSize;
/*  38 */     }  this.drawInventory = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float par3) {
/*  44 */     super.func_73863_a(par1, par2, par3);
/*  45 */     for (int j1 = 0; j1 < this.field_147002_h.field_75151_b.size(); j1++) {
/*     */       
/*  47 */       Slot slot = this.field_147002_h.field_75151_b.get(j1);
/*  48 */       if (func_146981_a(slot, par1, par2) && slot.func_111238_b()) {
/*  49 */         this.activeSlot = slot;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean func_146981_a(Slot par1Slot, int par2, int par3) {
/*  55 */     return func_146978_c(par1Slot.field_75223_e, par1Slot.field_75221_f, 16, 16, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int i, int j) {
/*  61 */     drawGui((ResourceLocation)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawGui(ResourceLocation rl) {
/*  66 */     if (rl != null) {
/*     */       
/*  68 */       bindTexture(rl);
/*  69 */       this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/*  70 */       this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/*  71 */       int height = this.drawInventory ? getShiftedYSize() : this.field_147000_g;
/*     */       
/*  73 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, height);
/*     */       
/*  75 */       drawForeground(this.field_147003_i, this.field_147009_r);
/*     */     } 
/*  77 */     if (this.drawInventory) {
/*  78 */       PlayerInventory.drawInventory(this, this.field_146294_l, this.field_146295_m, getShiftedYSize());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawForeground(int guiLeft, int guiTop) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean mouseInRegion(int x, int y, int width, int height, int mouseX, int mouseY) {
/*  92 */     mouseX -= this.field_147003_i;
/*  93 */     mouseY -= this.field_147009_r;
/*  94 */     return (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bindTexture(ResourceLocation rl) {
/*  99 */     TFC_Core.bindTexture(rl);
/* 100 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTooltip(int mx, int my, String text) {
/* 105 */     List<String> list = new ArrayList<String>();
/* 106 */     list.add(text);
/* 107 */     drawHoveringText(list, mx, my + 15, this.field_146289_q);
/* 108 */     RenderHelper.func_74518_a();
/* 109 */     GL11.glDisable(2896);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawHoveringTextZLevel(List<String> par1List, int par2, int par3, FontRenderer font, float z) {
/* 115 */     if (!par1List.isEmpty()) {
/*     */       
/* 117 */       GL11.glDisable(32826);
/* 118 */       RenderHelper.func_74518_a();
/* 119 */       GL11.glDisable(2896);
/*     */       
/* 121 */       int k = 0;
/* 122 */       Iterator<String> iterator = par1List.iterator();
/*     */       
/* 124 */       while (iterator.hasNext()) {
/*     */         
/* 126 */         String s = iterator.next();
/* 127 */         int l = font.func_78256_a(s);
/* 128 */         if (l > k) {
/* 129 */           k = l;
/*     */         }
/*     */       } 
/* 132 */       int i1 = par2 + 12;
/* 133 */       int j1 = par3 - 12;
/* 134 */       int k1 = 8;
/*     */       
/* 136 */       if (par1List.size() > 1) {
/* 137 */         k1 += 2 + (par1List.size() - 1) * 10;
/*     */       }
/* 139 */       if (i1 + k > this.field_146294_l) {
/* 140 */         i1 -= 28 + k;
/*     */       }
/* 142 */       if (j1 + k1 + 6 > this.field_146295_m) {
/* 143 */         j1 = this.field_146295_m - k1 - 6;
/*     */       }
/* 145 */       this.field_73735_i = z;
/* 146 */       field_146296_j.field_77023_b = 300.0F;
/* 147 */       int l1 = -267386864;
/* 148 */       func_73733_a(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
/* 149 */       func_73733_a(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
/* 150 */       func_73733_a(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
/* 151 */       func_73733_a(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
/* 152 */       func_73733_a(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
/* 153 */       int i2 = 1347420415;
/* 154 */       int j2 = (i2 & 0xFEFEFE) >> 1 | i2 & 0xFF000000;
/* 155 */       func_73733_a(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
/* 156 */       func_73733_a(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
/* 157 */       func_73733_a(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
/* 158 */       func_73733_a(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
/*     */       
/* 160 */       for (int k2 = 0; k2 < par1List.size(); k2++) {
/*     */         
/* 162 */         String s1 = par1List.get(k2);
/* 163 */         font.func_78261_a(s1, i1, j1, -1);
/*     */         
/* 165 */         if (k2 == 0)
/* 166 */           j1 += 2; 
/* 167 */         j1 += 10;
/*     */       } 
/*     */       
/* 170 */       this.field_73735_i = 0.0F;
/* 171 */       field_146296_j.field_77023_b = 0.0F;
/* 172 */       GL11.glEnable(2896);
/* 173 */       RenderHelper.func_74519_b();
/* 174 */       GL11.glEnable(32826);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getShiftedYSize() {
/* 180 */     return this.field_147000_g - PlayerInventory.invYSize;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiContainerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */