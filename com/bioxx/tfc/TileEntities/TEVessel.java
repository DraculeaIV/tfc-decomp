/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TEVessel
/*    */   extends TEBarrel
/*    */   implements IInventory
/*    */ {
/*    */   public int getTechLevel() {
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMaxLiquid() {
/* 29 */     return 5000;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_70302_i_() {
/* 35 */     return 9;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public AxisAlignedBB getRenderBoundingBox() {
/* 42 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void switchTab(EntityPlayer player, int tab) {
/* 48 */     if (player != null)
/* 49 */       if (tab == 0) {
/* 50 */         player.openGui(TerraFirmaCraft.instance, 46, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 51 */       } else if (tab == 1) {
/* 52 */         player.openGui(TerraFirmaCraft.instance, 47, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */