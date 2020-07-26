/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumAmmo;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import com.bioxx.tfc.api.Interfaces.IQuiverAmmo;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ 
/*    */ public class ItemArrow
/*    */   extends ItemTerra
/*    */   implements IQuiverAmmo
/*    */ {
/*    */   public ItemArrow() {
/* 15 */     setSize(EnumSize.LARGE);
/* 16 */     setWeight(EnumWeight.LIGHT);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 22 */     this.field_77791_bV = registerer.func_94245_a("minecraft:arrow");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumAmmo getAmmoType() {
/* 28 */     return EnumAmmo.ARROW;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */