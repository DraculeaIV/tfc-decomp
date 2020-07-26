/*    */ package com.bioxx.tfc.GUI;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerChestTFC;
/*    */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEChest;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.InventoryLargeChest;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiChestTFC
/*    */   extends GuiContainer
/*    */ {
/*    */   private IInventory upperChestInventory;
/*    */   private IInventory lowerChestInventory;
/*    */   private int inventoryRows;
/*    */   
/*    */   public GuiChestTFC(IInventory par1IInventory, IInventory chestInv, World world, int x, int y, int z) {
/* 29 */     super((Container)new ContainerChestTFC(par1IInventory, chestInv, world, x, y, z));
/*    */     
/* 31 */     TEChest chest = (TEChest)chestInv;
/*    */     
/* 33 */     this.upperChestInventory = par1IInventory;
/* 34 */     this.lowerChestInventory = chestInv;
/*    */     
/* 36 */     if (chest.field_145991_k != null)
/*    */     {
/* 38 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", (IInventory)chest.field_145991_k, chestInv);
/*    */     }
/*    */     
/* 41 */     if (chest.field_145990_j != null)
/*    */     {
/* 43 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", chestInv, (IInventory)chest.field_145990_j);
/*    */     }
/*    */     
/* 46 */     if (chest.field_145992_i != null)
/*    */     {
/* 48 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", (IInventory)chest.field_145992_i, chestInv);
/*    */     }
/*    */     
/* 51 */     if (chest.field_145988_l != null)
/*    */     {
/* 53 */       this.lowerChestInventory = (IInventory)new InventoryLargeChest("Large chest", chestInv, (IInventory)chest.field_145988_l);
/*    */     }
/*    */     
/* 56 */     this.field_146291_p = false;
/* 57 */     short var3 = 222;
/* 58 */     int var4 = var3 - 108;
/* 59 */     this.inventoryRows = this.lowerChestInventory.func_70302_i_() / 9;
/* 60 */     this.field_147000_g = var4 + this.inventoryRows * 18;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer() {
/* 68 */     this.field_146289_q.func_78276_b(TFC_Core.translate(this.lowerChestInventory.func_145825_b()), 8, 6, 4210752);
/* 69 */     this.field_146289_q.func_78276_b(TFC_Core.translate(this.upperChestInventory.func_145825_b()), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float par1, int par2, int par3) {
/* 78 */     TFC_Core.bindTexture(new ResourceLocation("terrafirmacraft", "textures/gui/gui_chest.png"));
/* 79 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 80 */     int var5 = (this.field_146294_l - this.field_146999_f) / 2;
/* 81 */     int var6 = (this.field_146295_m - this.field_147000_g) / 2;
/* 82 */     func_73729_b(var5, var6, 0, 0, this.field_146999_f, this.inventoryRows * 18 + 17);
/* 83 */     func_73729_b(var5, var6 + this.inventoryRows * 18 + 17, 0, 126, this.field_146999_f, 96);
/*    */     
/* 85 */     PlayerInventory.drawInventory(this, this.field_146294_l, this.field_146295_m, this.field_147000_g - PlayerInventory.invYSize + 10);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiChestTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */