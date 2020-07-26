/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerCrucible;
/*    */ import com.bioxx.tfc.Core.Metal.AlloyMetal;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TECrucible;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiCrucible
/*    */   extends GuiContainerTFC
/*    */ {
/* 19 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_crucible.png");
/*    */   
/*    */   private TECrucible crucibleTE;
/*    */ 
/*    */   
/*    */   public GuiCrucible(InventoryPlayer inventoryplayer, TECrucible te, World world, int x, int y, int z) {
/* 25 */     super((Container)new ContainerCrucible(inventoryplayer, te, world, x, y, z), 176, 113);
/* 26 */     this.crucibleTE = te;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 32 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawForeground(int guiLeft, int guiTop) {
/* 38 */     int scale = 0;
/*    */     
/* 40 */     scale = this.crucibleTE.getTemperatureScaled(49);
/* 41 */     func_73729_b(guiLeft + 153, guiTop + 80 - scale, 185, 0, 15, 6);
/*    */     
/* 43 */     scale = this.crucibleTE.getOutCountScaled(100);
/* 44 */     func_73729_b(guiLeft + 129, guiTop + 106 - scale, 177, 6, 8, scale);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int i, int j) {
/* 50 */     if (TFCOptions.enableDebugMode)
/*    */     {
/* 52 */       this.field_146289_q.func_78276_b("Temp: " + this.crucibleTE.temperature, 178, 8, 16777215);
/*    */     }
/*    */     
/* 55 */     if (this.crucibleTE.currentAlloy != null) {
/*    */       
/* 57 */       if (this.crucibleTE.currentAlloy.outputAmount == 0.0F) {
/*    */         
/* 59 */         this.field_146289_q.func_78276_b(EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.empty"), 7, 7, 0);
/*    */         return;
/*    */       } 
/* 62 */       if (this.crucibleTE.currentAlloy.outputType != null) {
/*    */         
/* 64 */         this.field_146289_q.func_78276_b(EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal." + this.crucibleTE.currentAlloy.outputType.name.replace(" ", "")), 7, 7, 0);
/*    */       }
/*    */       else {
/*    */         
/* 68 */         this.field_146289_q.func_78276_b(EnumChatFormatting.UNDERLINE + TFC_Core.translate("gui.metal.Unknown"), 7, 7, 0);
/*    */       } 
/*    */       
/* 71 */       for (int c = 0; c < this.crucibleTE.currentAlloy.alloyIngred.size(); c++) {
/*    */         
/* 73 */         double m = ((AlloyMetal)this.crucibleTE.currentAlloy.alloyIngred.get(c)).metal;
/* 74 */         m = Math.round(m * 100.0D) / 100.0D;
/* 75 */         if (((AlloyMetal)this.crucibleTE.currentAlloy.alloyIngred.get(c)).metalType != null)
/*    */         {
/* 77 */           this.field_146289_q.func_78276_b(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.metal." + ((AlloyMetal)this.crucibleTE.currentAlloy.alloyIngred.get(c)).metalType.name.replace(" ", "")) + ": " + EnumChatFormatting.DARK_GREEN + m + "%", 7, 18 + 10 * c, 0);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73863_a(int par1, int par2, float par3) {
/* 86 */     super.func_73863_a(par1, par2, par3);
/* 87 */     if (this.crucibleTE.currentAlloy != null) {
/*    */       
/* 89 */       int w = (this.field_146294_l - this.field_146999_f) / 2;
/* 90 */       int h = (this.field_146295_m - this.field_147000_g) / 2;
/* 91 */       if (par1 >= 129 + w && par2 >= 6 + h && par1 <= 137 + w && par2 <= 106 + h) {
/*    */ 
/*    */         
/* 94 */         String[] text = { String.format("%2.0f", new Object[] { Float.valueOf(this.crucibleTE.currentAlloy.outputAmount) }) };
/* 95 */         List<String> temp = Arrays.asList(text);
/* 96 */         drawHoveringText(temp, par1, par2, this.field_146289_q);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */