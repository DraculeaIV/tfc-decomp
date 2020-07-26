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
/*    */ public class SlotChest
/*    */   extends Slot
/*    */ {
/* 20 */   private EnumSize size = EnumSize.LARGE;
/*    */   
/*    */   private List<Item> exceptions;
/*    */ 
/*    */   
/*    */   public SlotChest(IInventory iinventory, int i, int j, int k) {
/* 26 */     super(iinventory, i, j, k);
/* 27 */     this.exceptions = new ArrayList<Item>();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 32 */     if ((itemstack.func_77973_b() instanceof net.minecraft.item.ItemTool || itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemTerraTool || itemstack.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemWeapon || itemstack
/* 33 */       .func_77973_b() instanceof net.minecraft.item.ItemHoe) && itemstack.func_77973_b() instanceof ISize && 
/* 34 */       (((ISize)itemstack.func_77973_b()).getSize(itemstack)).stackSize < EnumSize.SMALL.stackSize) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     boolean except = this.exceptions.contains(itemstack.func_77973_b());
/* 39 */     if (itemstack.func_77973_b() instanceof ISize && (((ISize)itemstack.func_77973_b()).getSize(itemstack)).stackSize >= this.size.stackSize && !except)
/*    */     {
/* 41 */       return true;
/*    */     }
/* 43 */     if (!(itemstack.func_77973_b() instanceof ISize) && !except) {
/* 44 */       return true;
/*    */     }
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotChest setSize(EnumSize s) {
/* 52 */     this.size = s;
/* 53 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotChest addItemException(List<Item> ex) {
/* 58 */     this.exceptions.addAll(ex);
/* 59 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */