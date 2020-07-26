/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerForge;
/*    */ import com.bioxx.tfc.TileEntities.TEForge;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiForge
/*    */   extends GuiContainerTFC
/*    */ {
/* 13 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_forge.png");
/*    */   
/*    */   private TEForge forgeTE;
/*    */ 
/*    */   
/*    */   public GuiForge(InventoryPlayer inventoryplayer, TEForge te, World world, int x, int y, int z) {
/* 19 */     super((Container)new ContainerForge(inventoryplayer, te, world, x, y, z), 176, 85);
/* 20 */     this.forgeTE = te;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 26 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawForeground(int guiLeft, int guiTop) {
/* 32 */     if (this.forgeTE != null) {
/*    */       
/* 34 */       int scale = this.forgeTE.getTemperatureScaled(49);
/* 35 */       func_73729_b(guiLeft + 8, guiTop + 65 - scale, 185, 31, 15, 6);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean func_146983_a(int keycode) {
/* 44 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */