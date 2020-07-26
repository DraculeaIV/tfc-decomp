/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerWorkbench;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEWorkbench;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiWorkbench
/*    */   extends GuiContainer
/*    */ {
/*    */   public GuiWorkbench(InventoryPlayer inventoryplayer, TEWorkbench wb, World world, int i, int j, int k) {
/* 18 */     super((Container)new ContainerWorkbench(inventoryplayer, wb, world, i, j, k));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer() {
/* 29 */     this.field_146289_q.func_78276_b(TFC_Core.translate("gui.Workbench.Crafting"), 28, 6, 4210752);
/* 30 */     this.field_146289_q.func_78276_b(TFC_Core.translate("gui.Inventory"), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 36 */     TFC_Core.bindTexture(new ResourceLocation("textures/gui/container/crafting_table.png"));
/*    */     
/* 38 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 39 */     int l = (this.field_146294_l - this.field_146999_f) / 2;
/* 40 */     int i1 = (this.field_146295_m - this.field_147000_g) / 2;
/* 41 */     func_73729_b(l, i1, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiWorkbench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */