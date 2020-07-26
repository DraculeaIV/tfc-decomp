/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*    */ import com.bioxx.tfc.api.Interfaces.IFood;
/*    */ import com.bioxx.tfc.api.Interfaces.ISize;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class SlotFoodOnly
/*    */   extends SlotSize
/*    */ {
/* 16 */   private List<EnumFoodGroup> excpetionsFG = new ArrayList<EnumFoodGroup>();
/* 17 */   private List<EnumFoodGroup> inclusionsFG = new ArrayList<EnumFoodGroup>();
/*    */   
/*    */   public SlotFoodOnly(IInventory iinventory, int i, int j, int k) {
/* 20 */     super(iinventory, i, j, k);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemstack) {
/* 26 */     Item item = itemstack.func_77973_b();
/* 27 */     if (item instanceof IFood && ((IFood)item).isUsable(itemstack)) {
/*    */       
/* 29 */       EnumFoodGroup efg = ((IFood)item).getFoodGroup();
/* 30 */       if (efg == null)
/* 31 */         return false; 
/* 32 */       boolean except = this.excpetionsFG.contains(efg);
/* 33 */       boolean include = (this.inclusionsFG.contains(efg) || this.inclusionsFG.isEmpty());
/* 34 */       if (except || !include)
/* 35 */         return false; 
/* 36 */       if (item instanceof ISize && (((ISize)item).getSize(itemstack)).stackSize >= this.size.stackSize)
/* 37 */         return super.func_75214_a(itemstack); 
/*    */     } 
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotFoodOnly addFGException(EnumFoodGroup... ex) {
/* 44 */     for (int i = 0; i < ex.length; i++)
/* 45 */       this.excpetionsFG.add(ex[i]); 
/* 46 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public SlotFoodOnly addFGInclusion(EnumFoodGroup... ex) {
/* 51 */     for (int i = 0; i < ex.length; i++)
/* 52 */       this.inclusionsFG.add(ex[i]); 
/* 53 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotFoodOnly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */