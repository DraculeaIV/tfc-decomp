/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerGrill;
/*    */ import com.bioxx.tfc.TileEntities.TEGrill;
/*    */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiGrill
/*    */   extends GuiContainerTFC
/*    */ {
/* 14 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_grill.png");
/*    */ 
/*    */   
/*    */   private TEFireEntity fireTE;
/*    */ 
/*    */   
/*    */   public GuiGrill(InventoryPlayer inventoryplayer, TEGrill te, World world, int x, int y, int z) {
/* 21 */     super((Container)new ContainerGrill(inventoryplayer, te, world, x, y, z), 176, 85);
/*    */     
/* 23 */     if (world.func_147438_o(x, y - 1, z) instanceof TEFireEntity) {
/* 24 */       this.fireTE = (TEFireEntity)world.func_147438_o(x, y - 1, z);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 30 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawForeground(int guiLeft, int guiTop) {
/* 36 */     int scale = 0;
/* 37 */     if (this.fireTE != null) {
/* 38 */       scale = this.fireTE.getTemperatureScaled(49);
/*    */     }
/* 40 */     func_73729_b(guiLeft + 7, guiTop + 65 - scale, 0, 86, 15, 6);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */