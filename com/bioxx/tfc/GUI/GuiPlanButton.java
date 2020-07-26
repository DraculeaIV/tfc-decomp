/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiPlanButton
/*    */   extends GuiButton
/*    */ {
/*    */   public ItemStack item;
/*    */   private GuiPlanSelection screen;
/* 16 */   protected static final RenderItem ITEM_RENDERER = new RenderItem();
/*    */ 
/*    */   
/*    */   public GuiPlanButton(int index, int xPos, int yPos, int width, int height, ItemStack ico, GuiPlanSelection gui, String s) {
/* 20 */     super(index, xPos, yPos, width, height, s);
/* 21 */     this.item = ico;
/* 22 */     this.screen = gui;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 29 */     if (this.field_146125_m) {
/*    */       
/* 31 */       int k = func_146114_a(this.field_146123_n) - 1;
/*    */       
/* 33 */       TFC_Core.bindTexture(GuiPlanSelection.texture);
/* 34 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */       func_73729_b(this.field_146128_h, this.field_146129_i, 176, k * 18, 18, 18);
/* 36 */       this.field_146123_n = isPointInRegion(x, y);
/*    */       
/* 38 */       if (this.item != null)
/*    */       {
/* 40 */         renderInventorySlot(this.item, this.field_146128_h + 1, this.field_146129_i + 1);
/*    */       }
/*    */       
/* 43 */       func_146119_b(mc, x, y);
/*    */       
/* 45 */       if (this.field_146123_n) {
/*    */ 
/*    */         
/* 48 */         this.screen.drawTooltip(x, y, this.field_146126_j);
/* 49 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderInventorySlot(ItemStack is, int x, int y) {
/* 56 */     if (is != null) {
/*    */       
/* 58 */       ITEM_RENDERER.func_82406_b((Minecraft.func_71410_x()).field_71466_p, Minecraft.func_71410_x().func_110434_K(), is, x, y);
/* 59 */       GL11.glDisable(2896);
/* 60 */       GL11.glEnable(3008);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean isPointInRegion(int mouseX, int mouseY) {
/* 66 */     int k1 = 0;
/* 67 */     int l1 = 0;
/* 68 */     mouseX -= k1;
/* 69 */     mouseY -= l1;
/* 70 */     return (mouseX >= this.field_146128_h - 1 && mouseX < this.field_146128_h + this.field_146120_f + 1 && mouseY >= this.field_146129_i - 1 && mouseY < this.field_146129_i + this.field_146121_g + 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiPlanButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */