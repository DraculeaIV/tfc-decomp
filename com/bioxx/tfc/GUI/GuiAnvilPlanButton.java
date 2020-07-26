/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiAnvilPlanButton
/*    */   extends GuiButton
/*    */ {
/*    */   private GuiAnvil screen;
/* 16 */   protected static final RenderItem ITEM_RENDERER = new RenderItem();
/*    */ 
/*    */   
/*    */   public GuiAnvilPlanButton(int index, int xPos, int yPos, int width, int height, GuiAnvil gui, String s) {
/* 20 */     super(index, xPos, yPos, width, height, s);
/* 21 */     this.screen = gui;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 27 */     if (this.field_146125_m) {
/*    */       
/* 29 */       int k = func_146114_a(this.field_146123_n) - 1;
/*    */       
/* 31 */       TFC_Core.bindTexture(GuiAnvil.texture);
/* 32 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 33 */       this.field_73735_i = 300.0F;
/* 34 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 205 + k * 18, 18, 18);
/* 35 */       this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*    */       
/* 37 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */ 
/*    */       
/* 40 */       if (this.screen.anvilTE != null && !this.screen.anvilTE.craftingPlan.equals("") && this.screen.anvilTE.workRecipe != null) {
/* 41 */         renderInventorySlot(this.screen.anvilTE.workRecipe.getCraftingResult(), this.field_146128_h + 1, this.field_146129_i + 1);
/*    */       } else {
/* 43 */         renderInventorySlot(new ItemStack(TFCItems.blueprint), this.field_146128_h + 1, this.field_146129_i + 1);
/*    */       } 
/* 45 */       this.field_73735_i = 0.0F;
/* 46 */       func_146119_b(mc, x, y);
/*    */       
/* 48 */       if (this.field_146123_n) {
/*    */         
/* 50 */         this.screen.drawTooltip(x, y, this.field_146126_j);
/* 51 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderInventorySlot(ItemStack is, int x, int y) {
/* 58 */     if (is != null)
/*    */     {
/* 60 */       ITEM_RENDERER.func_82406_b((Minecraft.func_71410_x()).field_71466_p, Minecraft.func_71410_x().func_110434_K(), is, x, y);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiAnvilPlanButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */