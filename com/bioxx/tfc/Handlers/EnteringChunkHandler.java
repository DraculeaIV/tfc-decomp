/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnteringChunkHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onEnterChunk(EntityEvent.EnteringChunk event) {
/* 18 */     if (event.entity instanceof EntityPlayer) {
/*    */       
/* 20 */       EntityPlayer player = (EntityPlayer)event.entity;
/* 21 */       if (!player.field_70170_p.field_72995_K) {
/*    */         
/* 23 */         NBTTagCompound nbt = player.getEntityData();
/* 24 */         long spawnProtectionTimer = nbt.func_74764_b("spawnProtectionTimer") ? nbt.func_74763_f("spawnProtectionTimer") : (TFC_Time.getTotalTicks() + 1000L);
/*    */ 
/*    */         
/* 27 */         if (TFC_Core.getCDM(event.entity.field_70170_p) != null && (event.newChunkX != event.oldChunkX || event.newChunkZ != event.oldChunkZ)) {
/*    */           
/* 29 */           TFC_Core.getCDM(event.entity.field_70170_p).setLastVisted(event.oldChunkX, event.oldChunkZ);
/*    */           
/* 31 */           spawnProtectionTimer = TFC_Time.getTotalTicks() + 1000L;
/* 32 */           writeProtectionToNBT(nbt, spawnProtectionTimer);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeProtectionToNBT(NBTTagCompound nbt, long spawnProtectionTimer) {
/* 40 */     nbt.func_74772_a("spawnProtectionTimer", spawnProtectionTimer);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\EnteringChunkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */