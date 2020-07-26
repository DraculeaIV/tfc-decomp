/*    */ package com.bioxx.tfc.api.Interfaces;
/*    */ 
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ISmeltable
/*    */ {
/*    */   Metal getMetalType(ItemStack paramItemStack);
/*    */   
/*    */   short getMetalReturnAmount(ItemStack paramItemStack);
/*    */   
/*    */   boolean isSmeltable(ItemStack paramItemStack);
/*    */   
/*    */   EnumTier getSmeltTier(ItemStack paramItemStack);
/*    */   
/*    */   public enum EnumTier
/*    */   {
/* 22 */     TierI(1), TierII(2), TierIII(3), TierIV(4), TierV(5), TierVI(6), TierVII(7), TierVIII(8), TierIX(9), TierX(10);
/*    */     
/*    */     public int tier;
/*    */ 
/*    */     
/*    */     EnumTier(int t) {
/* 28 */       this.tier = t;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Interfaces\ISmeltable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */