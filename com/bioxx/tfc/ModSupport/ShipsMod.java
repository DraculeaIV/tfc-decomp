/*    */ package com.bioxx.tfc.ModSupport;
/*    */ 
/*    */ import cpw.mods.fml.common.Optional.Method;
/*    */ import cuchaz.ships.core.ShipIntermediary;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShipsMod
/*    */   implements IShipsMod
/*    */ {
/*    */   @Method(modid = "cuchaz.ships")
/*    */   public World getShipsWorld(World world, InventoryPlayer inventory) {
/* 16 */     return ShipIntermediary.translateWorld(world, inventory);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ModSupport\ShipsMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */