/*    */ package com.bioxx.tfc.Items.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*    */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemCustomSword
/*    */   extends ItemWeapon
/*    */ {
/*    */   public ItemCustomSword(Item.ToolMaterial par2EnumToolMaterial, float damage, EnumDamageType dt) {
/* 12 */     super(par2EnumToolMaterial, damage);
/*    */     
/* 14 */     this.damageType = dt;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemCustomSword(Item.ToolMaterial par2EnumToolMaterial, float damage) {
/* 19 */     super(par2EnumToolMaterial, damage);
/*    */     
/* 21 */     this.damageType = EnumDamageType.SLASHING;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumItemReach getReach(ItemStack is) {
/* 27 */     return EnumItemReach.MEDIUM;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */