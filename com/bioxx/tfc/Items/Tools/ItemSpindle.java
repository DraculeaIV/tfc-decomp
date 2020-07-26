/*    */ package com.bioxx.tfc.Items.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.Items.ItemTerra;
/*    */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.google.common.collect.HashMultimap;
/*    */ import com.google.common.collect.Multimap;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSpindle
/*    */   extends ItemTerra
/*    */ {
/*    */   public ItemSpindle() {
/* 16 */     func_77656_e(40);
/* 17 */     setFolder("tools/");
/* 18 */     setNoRepair();
/*    */     
/* 20 */     setSize(EnumSize.VERYSMALL);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Multimap func_111205_h() {
/* 26 */     return (Multimap)HashMultimap.create();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77630_h(ItemStack itemStack) {
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77651_p() {
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack getContainerItem(ItemStack itemStack) {
/* 44 */     ItemStack container = itemStack.func_77946_l();
/* 45 */     container.func_77964_b(container.func_77960_j() + 1);
/* 46 */     container.field_77994_a = 1;
/* 47 */     return container;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasContainerItem(ItemStack stack) {
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isRepairable() {
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumItemReach getReach(ItemStack is) {
/* 65 */     return EnumItemReach.SHORT;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_77639_j() {
/* 71 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canStack() {
/* 77 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemSpindle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */