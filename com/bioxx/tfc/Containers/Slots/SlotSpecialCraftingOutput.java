/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.Containers.ContainerSpecialCrafting;
/*    */ import com.bioxx.tfc.GUI.GuiKnapping;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class SlotSpecialCraftingOutput
/*    */   extends Slot
/*    */ {
/*    */   private final IInventory craftMatrix;
/*    */   private EntityPlayer thePlayer;
/*    */   private Container container;
/*    */   
/*    */   public SlotSpecialCraftingOutput(Container container, EntityPlayer entityplayer, IInventory iinventory, IInventory iinventory1, int i, int j, int k) {
/* 22 */     super(iinventory1, i, j, k);
/* 23 */     this.container = container;
/* 24 */     this.thePlayer = entityplayer;
/* 25 */     this.craftMatrix = iinventory;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_82870_a(EntityPlayer player, ItemStack itemstack) {
/* 38 */     itemstack.func_77980_a(this.thePlayer.field_70170_p, this.thePlayer, this.field_75222_d);
/* 39 */     TerraFirmaCraft.proxy.takenFromCrafting(this.thePlayer, itemstack, this.craftMatrix);
/*    */     
/* 41 */     for (int i = 0; i < this.craftMatrix.func_70302_i_(); i++) {
/*    */ 
/*    */       
/* 44 */       this.craftMatrix.func_70299_a(i, null);
/* 45 */       if (player.field_70170_p.field_72995_K)
/*    */       {
/* 47 */         ((GuiKnapping)(Minecraft.func_71410_x()).field_71462_r).resetButton(i);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 52 */     ((ContainerSpecialCrafting)this.container).setDecreasedStack(Boolean.valueOf(false));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotSpecialCraftingOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */