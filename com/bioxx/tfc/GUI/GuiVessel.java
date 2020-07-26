/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerVessel;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiVessel
/*    */   extends GuiContainerTFC
/*    */ {
/* 12 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_vessel.png");
/*    */ 
/*    */   
/*    */   public GuiVessel(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
/* 16 */     super((Container)new ContainerVessel(inventoryplayer, world, i, j, k), 176, 85);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 22 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean func_146983_a(int par1) {
/* 32 */     if (this.field_146297_k.field_71439_g.field_71071_by.field_70461_c != par1 - 2) {
/*    */       
/* 34 */       super.func_146983_a(par1);
/* 35 */       return true;
/*    */     } 
/*    */     
/* 38 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */