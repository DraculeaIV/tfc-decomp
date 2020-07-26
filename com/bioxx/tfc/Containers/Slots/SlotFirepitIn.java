/*    */ package com.bioxx.tfc.Containers.Slots;
/*    */ 
/*    */ import com.bioxx.tfc.api.HeatRegistry;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotFirepitIn
/*    */   extends Slot
/*    */ {
/*    */   public SlotFirepitIn(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k) {
/* 16 */     super(iinventory, i, j, k);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_75219_a() {
/* 22 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75214_a(ItemStack is) {
/* 28 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 29 */     return (is.func_77973_b() == TFCItems.fireStarter || is
/* 30 */       .func_77973_b() == TFCItems.flintSteel || (manager
/* 31 */       .findMatchingIndex(is) != null && 
/* 32 */       !(is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemOre)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75215_d(ItemStack is) {
/* 38 */     if (is != null)
/* 39 */       is.field_77994_a = 1; 
/* 40 */     if (this.field_75224_c != null)
/* 41 */       super.func_75215_d(is); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\Slots\SlotFirepitIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */