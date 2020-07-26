/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Interfaces.ISize;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotSizeSmallVessel
/*    */   extends Slot
/*    */ {
/* 22 */   private EnumSize size = EnumSize.SMALL;
/*    */   
/*    */   private List<Item> exceptions;
/*    */   
/*    */   public SlotSizeSmallVessel(IInventory iinventory, int i, int j, int k) {
/* 27 */     super(iinventory, i, j, k);
/* 28 */     this.exceptions = new ArrayList<Item>();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 34 */     if (itemstack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IBag || itemstack
/* 35 */       .func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal || itemstack
/* 36 */       .func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryBase)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (itemstack.func_77973_b() instanceof ISize && (((ISize)itemstack.func_77973_b()).getSize(itemstack)).stackSize >= this.size.stackSize && (itemstack
/* 42 */       .func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood || itemstack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IItemFoodBlock) && (
/* 43 */       !itemstack.func_77942_o() || !itemstack.func_77978_p().func_74764_b("foodWeight") || !itemstack.func_77978_p().func_74764_b("foodDecay"))) {
/* 44 */       return false;
/*    */     }
/* 46 */     boolean except = this.exceptions.contains(itemstack.func_77973_b());
/* 47 */     if (itemstack.func_77973_b() instanceof ISize && (((ISize)itemstack.func_77973_b()).getSize(itemstack)).stackSize >= this.size.stackSize && !except)
/* 48 */       return true; 
/* 49 */     if (!(itemstack.func_77973_b() instanceof ISize) && !except)
/* 50 */       return true; 
/* 51 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotSizeSmallVessel addItemException(List<Item> ex) {
/* 56 */     this.exceptions = ex;
/* 57 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotSizeSmallVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */