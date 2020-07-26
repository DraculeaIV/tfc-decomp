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
/*    */ public class SlotSize
/*    */   extends Slot
/*    */ {
/* 16 */   protected EnumSize size = EnumSize.MEDIUM;
/* 17 */   private List<Item> excpetions = new ArrayList<Item>();
/* 18 */   private List<Item> inclusions = new ArrayList<Item>();
/*    */ 
/*    */   
/*    */   public SlotSize(IInventory iinventory, int i, int j, int k) {
/* 22 */     super(iinventory, i, j, k);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 28 */     boolean except = this.excpetions.contains(itemstack.func_77973_b());
/* 29 */     boolean include = (this.inclusions.contains(itemstack.func_77973_b()) || this.inclusions.isEmpty());
/* 30 */     if (itemstack.func_77973_b() instanceof ISize && (((ISize)itemstack.func_77973_b()).getSize(itemstack)).stackSize >= this.size.stackSize && !except && include)
/* 31 */       return true; 
/* 32 */     if (!(itemstack.func_77973_b() instanceof ISize) && !except && include)
/* 33 */       return true; 
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotSize setSize(EnumSize s) {
/* 39 */     this.size = s;
/* 40 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotSize addItemException(Item... ex) {
/* 45 */     for (int i = 0; i < ex.length; i++)
/* 46 */       this.excpetions.add(ex[i]); 
/* 47 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotSize addItemInclusion(Item... ex) {
/* 52 */     for (int i = 0; i < ex.length; i++)
/* 53 */       this.inclusions.add(ex[i]); 
/* 54 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */