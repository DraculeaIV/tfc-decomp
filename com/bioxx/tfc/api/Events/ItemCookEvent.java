/*    */ package com.bioxx.tfc.api.Events;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class ItemCookEvent
/*    */   extends Event
/*    */ {
/*    */   public ItemStack input1;
/*    */   public ItemStack result;
/*    */   public TileEntity te;
/*    */   
/*    */   public ItemCookEvent(ItemStack i1, ItemStack r, TileEntity t) {
/* 31 */     this.input1 = i1;
/* 32 */     this.result = r;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Events\ItemCookEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */