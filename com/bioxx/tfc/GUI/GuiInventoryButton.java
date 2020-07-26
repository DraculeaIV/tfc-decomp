/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiInventoryButton
/*    */   extends GuiButton
/*    */ {
/* 16 */   private static ResourceLocation texture = new ResourceLocation("terrafirmacraft:textures/gui/inventory.png");
/*    */   
/*    */   public IIcon icon;
/*    */   
/*    */   public int bX;
/*    */   public int bY;
/*    */   public int bW;
/*    */   public int bH;
/*    */   
/*    */   public GuiInventoryButton(int index, int xPos, int yPos, int width, int height, int buttonX, int buttonY, int buttonW, int buttonH, String s, IIcon ico) {
/* 26 */     super(index, xPos, yPos, width, height, s);
/* 27 */     this.bX = buttonX;
/* 28 */     this.bY = buttonY;
/* 29 */     this.bW = buttonW;
/* 30 */     this.bH = buttonH;
/* 31 */     this.icon = ico;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 38 */     if (this.field_146125_m) {
/*    */       
/* 40 */       TFC_Core.bindTexture(texture);
/* 41 */       func_73729_b(this.field_146128_h, this.field_146129_i, this.bX, this.bY, this.bW, this.bH);
/*    */       
/* 43 */       this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*    */       
/* 45 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 46 */       if (this.icon != null) {
/*    */         
/* 48 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 49 */         func_94065_a(this.field_146128_h + 4, this.field_146129_i + 2, this.icon, 16, 16);
/*    */       } 
/*    */       
/* 52 */       func_146119_b(mc, x, y);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiInventoryButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */