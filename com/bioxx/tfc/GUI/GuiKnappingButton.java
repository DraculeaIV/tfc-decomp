/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*    */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.util.IIcon;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiKnappingButton
/*    */   extends GuiButton
/*    */ {
/*    */   public GuiKnappingButton(int index, int xPos, int yPos, int width, int height) {
/* 18 */     super(index, xPos, yPos, width, height, "");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft par1Minecraft, int xPos, int yPos) {
/* 24 */     if (this.field_146125_m) {
/*    */       
/* 26 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getClientPlayer();
/* 27 */       IIcon icon = null;
/*    */       
/* 29 */       if (pi.specialCraftingType != null)
/* 30 */         icon = pi.specialCraftingType.func_77954_c(); 
/* 31 */       if (!this.field_146124_l && pi.specialCraftingTypeAlternate != null) {
/* 32 */         icon = pi.specialCraftingTypeAlternate.func_77954_c();
/*    */       }
/* 34 */       TFC_Core.bindTexture(TextureMap.field_110576_c);
/* 35 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 36 */       this.field_146123_n = (xPos >= this.field_146128_h && yPos >= this.field_146129_i && xPos < this.field_146128_h + this.field_146120_f && yPos < this.field_146129_i + this.field_146121_g);
/*    */       
/* 38 */       if (icon != null) {
/* 39 */         func_94065_a(this.field_146128_h, this.field_146129_i, icon, this.field_146120_f, this.field_146121_g);
/*    */       }
/* 41 */       func_146119_b(par1Minecraft, xPos, yPos);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiKnappingButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */