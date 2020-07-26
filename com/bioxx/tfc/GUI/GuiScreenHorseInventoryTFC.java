/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerHorseInventoryTFC;
/*    */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.gui.inventory.GuiInventory;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiScreenHorseInventoryTFC
/*    */   extends GuiContainerTFC
/*    */ {
/* 18 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_horse.png");
/*    */   
/*    */   private EntityHorseTFC horse;
/*    */   
/*    */   private float xSize;
/*    */   private float ySize;
/*    */   
/*    */   public GuiScreenHorseInventoryTFC(InventoryPlayer playerInv, IInventory horseInv, EntityHorseTFC entityHorse) {
/* 26 */     super((Container)new ContainerHorseInventoryTFC(playerInv, horseInv, entityHorse), 176, 85);
/*    */     
/* 28 */     this.horse = entityHorse;
/* 29 */     this.field_146291_p = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int par1, int par2) {
/* 38 */     if (this.horse.func_94056_bM()) {
/* 39 */       this.field_146289_q.func_78276_b(this.horse.func_94057_bL(), 8, 6, 4210752);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float par1, int par2, int par3) {
/* 48 */     drawGui(texture);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawForeground(int guiLeft, int guiTop) {
/* 54 */     if (this.horse.func_110261_ca())
/*    */     {
/* 56 */       func_73729_b(guiLeft + 79, guiTop + 17, 0, getShiftedYSize() + 1, 90, 54);
/*    */     }
/*    */     
/* 59 */     if (this.horse.func_110259_cr())
/*    */     {
/* 61 */       func_73729_b(guiLeft + 7, guiTop + 35, 0, getShiftedYSize() + 55, 18, 18);
/*    */     }
/*    */ 
/*    */     
/* 65 */     GuiInventory.func_147046_a(guiLeft + 51, guiTop + 60, 17, (guiLeft + 51) - this.xSize, (guiTop + 75 - 50) - this.ySize, (EntityLivingBase)this.horse);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73863_a(int par1, int par2, float par3) {
/* 74 */     this.xSize = par1;
/* 75 */     this.ySize = par2;
/* 76 */     super.func_73863_a(par1, par2, par3);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiScreenHorseInventoryTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */