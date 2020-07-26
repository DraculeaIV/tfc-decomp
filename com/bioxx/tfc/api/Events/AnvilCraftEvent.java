/*    */ package com.bioxx.tfc.api.Events;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class AnvilCraftEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public ItemStack input1;
/*    */   public ItemStack input2;
/*    */   public ItemStack result;
/*    */   public TileEntity anvilTE;
/*    */   
/*    */   public AnvilCraftEvent(EntityPlayer entityplayer, TileEntity te, ItemStack i1, ItemStack i2, ItemStack r) {
/* 37 */     super((Entity)entityplayer);
/* 38 */     this.input1 = i1;
/* 39 */     this.input2 = i2;
/* 40 */     this.result = r;
/* 41 */     this.anvilTE = te;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Events\AnvilCraftEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */