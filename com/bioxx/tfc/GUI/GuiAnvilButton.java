/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*    */ import com.bioxx.tfc.api.Crafting.PlanRecipe;
/*    */ import com.bioxx.tfc.api.Enums.RuleEnum;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.util.IIcon;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiAnvilButton
/*    */   extends GuiButton
/*    */ {
/*    */   public IIcon icon;
/*    */   public int bX;
/*    */   public int bY;
/*    */   public int bW;
/*    */   public int bH;
/*    */   public int ruleIndex;
/*    */   private GuiAnvil screen;
/* 25 */   private byte red = -1;
/* 26 */   private byte blue = -1;
/* 27 */   private byte green = -1;
/*    */ 
/*    */ 
/*    */   
/*    */   public GuiAnvilButton(int index, int xPos, int yPos, int width, int height, IIcon ico, int buttonX, int buttonY, int buttonW, int buttonH, GuiAnvil gui, String s) {
/* 32 */     super(index, xPos, yPos, width, height, s);
/* 33 */     this.icon = ico;
/* 34 */     this.bX = buttonX;
/* 35 */     this.bY = buttonY;
/* 36 */     this.bW = buttonW;
/* 37 */     this.bH = buttonH;
/* 38 */     this.screen = gui;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public GuiAnvilButton(int index, int xPos, int yPos, int width, int height, int buttonX, int buttonY, int buttonW, int buttonH, GuiAnvil gui, int i, byte r, byte g, byte b) {
/* 44 */     super(index, xPos, yPos, width, height, "");
/* 45 */     this.bX = buttonX;
/* 46 */     this.bY = buttonY;
/* 47 */     this.bW = buttonW;
/* 48 */     this.bH = buttonH;
/* 49 */     this.screen = gui;
/* 50 */     this.ruleIndex = i;
/* 51 */     this.red = r;
/* 52 */     this.green = g;
/* 53 */     this.blue = b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 60 */     if (this.field_146125_m) {
/*    */       
/* 62 */       int k = func_146114_a(this.field_146123_n) - 1;
/* 63 */       if (this.icon == null) {
/*    */         
/* 65 */         k = 0;
/* 66 */         if (this.screen.anvilTE != null && this.screen.anvilTE.workRecipe != null) {
/*    */           
/* 68 */           PlanRecipe p = AnvilManager.getInstance().getPlan(this.screen.anvilTE.craftingPlan);
/* 69 */           if (p == null)
/* 70 */             return;  RuleEnum[] rules = p.rules;
/*    */           
/* 72 */           this.field_146126_j = TFC_Core.translate((rules[this.ruleIndex]).Name);
/*    */         } 
/*    */       } 
/*    */       
/* 76 */       TFC_Core.bindTexture(GuiAnvil.texture);
/* 77 */       GL11.glColor4ub(this.red, this.green, this.blue, (byte)-1);
/* 78 */       func_73729_b(this.field_146128_h, this.field_146129_i, this.bX + k * 16, this.bY + this.ruleIndex * 22, this.bW, this.bH);
/*    */       
/* 80 */       this.field_146123_n = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
/*    */       
/* 82 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 83 */       if (this.icon != null) {
/*    */         
/* 85 */         TFC_Core.bindTexture(TextureMap.field_110575_b);
/* 86 */         func_94065_a(this.field_146128_h, this.field_146129_i, this.icon, this.field_146120_f, this.field_146121_g);
/*    */       } 
/*    */       
/* 89 */       func_146119_b(mc, x, y);
/*    */       
/* 91 */       if (this.field_146123_n) {
/*    */         
/* 93 */         this.screen.drawTooltip(x, y, this.field_146126_j);
/* 94 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiAnvilButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */