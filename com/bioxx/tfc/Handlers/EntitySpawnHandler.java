/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*    */ import com.bioxx.tfc.Containers.ContainerPlayerTFC;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingSpawnEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntitySpawnHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
/* 24 */     EntityLivingBase entity = event.entityLiving;
/*    */     
/* 26 */     int chunkX = (int)Math.floor(entity.field_70165_t) >> 4;
/* 27 */     int chunkZ = (int)Math.floor(entity.field_70161_v) >> 4;
/*    */     
/* 29 */     if (event.world.func_147439_a((int)Math.floor(entity.field_70165_t), (int)Math.floor(entity.field_70163_u), (int)Math.floor(entity.field_70161_v)) == TFCBlocks.thatch)
/*    */     {
/* 31 */       event.setResult(Event.Result.DENY);
/*    */     }
/*    */     
/* 34 */     if (TFC_Core.getCDM(event.world) != null) {
/*    */       
/* 36 */       ChunkData data = TFC_Core.getCDM(event.world).getData(chunkX, chunkZ);
/* 37 */       if (data != null && data.getSpawnProtectionWithUpdate() > 0) {
/* 38 */         event.setResult(Event.Result.DENY);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onJoinWorld(EntityJoinWorldEvent event) {
/* 45 */     if (event.entity instanceof EntityPlayer && !event.entity.getEntityData().func_74764_b("hasSpawned")) {
/*    */       
/* 47 */       if (!(((EntityPlayer)event.entity).field_71071_by instanceof com.bioxx.tfc.Core.Player.InventoryPlayerTFC)) {
/* 48 */         ((EntityPlayer)event.entity).field_71071_by = TFC_Core.getNewInventory((EntityPlayer)event.entity);
/*    */       }
/* 50 */       ((EntityPlayer)event.entity).func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/* 51 */       ((EntityPlayer)event.entity).func_70606_j(1000.0F);
/* 52 */       event.entity.getEntityData().func_74757_a("hasSpawned", true);
/*    */     } 
/*    */     
/* 55 */     if (event.entity instanceof EntityPlayer) {
/*    */       
/* 57 */       if (!(((EntityPlayer)event.entity).field_71071_by instanceof com.bioxx.tfc.Core.Player.InventoryPlayerTFC)) {
/* 58 */         ((EntityPlayer)event.entity).field_71071_by = TFC_Core.getNewInventory((EntityPlayer)event.entity);
/*    */       }
/* 60 */       ((EntityPlayer)event.entity).field_71069_bz = (Container)new ContainerPlayerTFC(((EntityPlayer)event.entity).field_71071_by, !event.world.field_72995_K, (EntityPlayer)event.entity);
/* 61 */       ((EntityPlayer)event.entity).field_71070_bA = ((EntityPlayer)event.entity).field_71069_bz;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\EntitySpawnHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */