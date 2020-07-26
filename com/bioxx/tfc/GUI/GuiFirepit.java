/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerFirepit;
/*    */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiFirepit
/*    */   extends GuiContainerTFC
/*    */ {
/* 13 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_firepit.png");
/*    */   
/*    */   private TEFirepit firepitTE;
/*    */ 
/*    */   
/*    */   public GuiFirepit(InventoryPlayer inventoryplayer, TEFirepit te, World world, int x, int y, int z) {
/* 19 */     super((Container)new ContainerFirepit(inventoryplayer, te, world, x, y, z), 176, 85);
/* 20 */     this.firepitTE = te;
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
/* 32 */     if (this.firepitTE != null) {
/*    */       
/* 34 */       int scale = this.firepitTE.getTemperatureScaled(49);
/* 35 */       func_73729_b(guiLeft + 30, guiTop + 65 - scale, 185, 31, 15, 6);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */