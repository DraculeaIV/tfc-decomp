/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerLiquidVessel;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiVesselLiquid
/*    */   extends GuiContainerTFC
/*    */ {
/* 17 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_vessel_liquid.png");
/*    */   
/*    */   private EntityPlayer player;
/*    */   
/*    */   private int bagsSlotNum;
/*    */   
/*    */   public GuiVesselLiquid(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
/* 24 */     super((Container)new ContainerLiquidVessel(inventoryplayer, world, i, j, k), 176, 85);
/* 25 */     this.player = inventoryplayer.field_70458_d;
/* 26 */     this.bagsSlotNum = this.player.field_71071_by.field_70461_c;
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
/* 38 */     ItemStack stack = this.player.field_71071_by.field_70462_a[this.bagsSlotNum];
/* 39 */     NBTTagCompound tags = (stack != null && stack.func_77942_o()) ? stack.func_77978_p() : null;
/* 40 */     if (tags != null && tags.func_74764_b("MetalType"))
/*    */     {
/* 42 */       func_73732_a(this.field_146289_q, tags.func_74779_i("MetalType"), guiLeft + 87, guiTop + 13, 0);
/*    */     }
/* 44 */     if (tags != null && tags.func_74764_b("MetalAmount"))
/*    */     {
/* 46 */       func_73732_a(this.field_146289_q, tags.func_74762_e("MetalAmount") + " " + TFC_Core.translate("gui.units"), guiLeft + 87, guiTop + 23, 0);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/* 53 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiVesselLiquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */