/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerSkills;
/*    */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Textures;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class GuiHealth
/*    */   extends GuiContainerTFC {
/* 17 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_health.png");
/*    */   
/*    */   protected EntityPlayer player;
/*    */   
/*    */   public GuiHealth(EntityPlayer player) {
/* 22 */     super((Container)new ContainerSkills(player), 176, 104);
/* 23 */     setDrawInventory(false);
/* 24 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int par1, int par2) {
/* 30 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.food.fruit"), 5, 13, 0, false);
/* 31 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.food.vegetable"), 5, 23, 0, false);
/* 32 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.food.grain"), 5, 33, 0, false);
/* 33 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.food.protein"), 5, 43, 0, false);
/* 34 */     this.field_146289_q.func_85187_a(TFC_Core.translate("gui.food.dairy"), 5, 53, 0, false);
/* 35 */     if (TFCOptions.enableDebugMode) {
/*    */       
/* 37 */       FoodStatsTFC food = TFC_Core.getPlayerFoodStats(this.player);
/* 38 */       this.field_146289_q.func_85187_a(Float.toString(food.nutrFruit), 85, 13, 0, false);
/* 39 */       this.field_146289_q.func_85187_a(Float.toString(food.nutrVeg), 85, 23, 0, false);
/* 40 */       this.field_146289_q.func_85187_a(Float.toString(food.nutrGrain), 85, 33, 0, false);
/* 41 */       this.field_146289_q.func_85187_a(Float.toString(food.nutrProtein), 85, 43, 0, false);
/* 42 */       this.field_146289_q.func_85187_a(Float.toString(food.nutrDairy), 85, 53, 0, false);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 49 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGui(ResourceLocation rl) {
/* 55 */     bindTexture(rl);
/* 56 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/* 57 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2 - 34;
/* 58 */     func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
/* 59 */     drawForeground(this.field_147003_i, this.field_147009_r);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawForeground(int guiLeft, int guiTop) {
/* 65 */     FoodStatsTFC food = TFC_Core.getPlayerFoodStats(this.player);
/*    */     
/* 67 */     func_73729_b(guiLeft + 55, guiTop + 14, 0, 106, (int)(food.nutrFruit * 24.0F), 6);
/* 68 */     func_73729_b(guiLeft + 55, guiTop + 24, 0, 106, (int)(food.nutrVeg * 24.0F), 6);
/* 69 */     func_73729_b(guiLeft + 55, guiTop + 34, 0, 106, (int)(food.nutrGrain * 24.0F), 6);
/* 70 */     func_73729_b(guiLeft + 55, guiTop + 44, 0, 106, (int)(food.nutrProtein * 24.0F), 6);
/* 71 */     func_73729_b(guiLeft + 55, guiTop + 54, 0, 106, (int)(food.nutrDairy * 24.0F), 6);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 77 */     super.func_73866_w_();
/* 78 */     this.field_147003_i = (this.field_146294_l - this.field_146999_f) / 2;
/* 79 */     this.field_147009_r = (this.field_146295_m - this.field_147000_g) / 2;
/* 80 */     this.field_146292_n.clear();
/* 81 */     this.field_146292_n.add(new GuiInventoryButton(0, this.field_147003_i + 176, this.field_147009_r - 31, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Inventory"), TFC_Textures.guiInventory));
/* 82 */     this.field_146292_n.add(new GuiInventoryButton(1, this.field_147003_i + 176, this.field_147009_r - 12, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Skills"), TFC_Textures.guiSkills));
/* 83 */     this.field_146292_n.add(new GuiInventoryButton(2, this.field_147003_i + 176, this.field_147009_r + 7, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Calendar.Calendar"), TFC_Textures.guiCalendar));
/* 84 */     this.field_146292_n.add(new GuiInventoryButton(3, this.field_147003_i + 176, this.field_147009_r + 26, 25, 20, 0, 86, 25, 20, TFC_Core.translate("gui.Inventory.Health"), TFC_Textures.guiHealth));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton guibutton) {
/* 90 */     if (guibutton.field_146127_k == 0) {
/* 91 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiInventoryTFC((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/* 92 */     } else if (guibutton.field_146127_k == 1) {
/* 93 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiSkills((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/* 94 */     } else if (guibutton.field_146127_k == 2) {
/* 95 */       Minecraft.func_71410_x().func_147108_a(new GuiCalendar((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiHealth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */