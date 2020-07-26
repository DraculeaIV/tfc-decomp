/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Config.TFC_ConfigFiles;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.ConfigSyncPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.InitClientWorldPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.PlayerUpdatePacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import cpw.mods.fml.common.network.FMLNetworkEvent;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.event.entity.item.ItemTossEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerTracker
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/*  33 */     (PlayerManagerTFC.getInstance()).players.add(new PlayerInfo(event.player
/*  34 */           .func_70005_c_(), event.player
/*  35 */           .func_110124_au()));
/*  36 */     TFC_ConfigFiles.reloadAll();
/*  37 */     InitClientWorldPacket initClientWorldPacket = new InitClientWorldPacket(event.player);
/*  38 */     TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)initClientWorldPacket, (EntityPlayerMP)event.player);
/*  39 */     TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)new ConfigSyncPacket(), (EntityPlayerMP)event.player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onClientConnect(FMLNetworkEvent.ClientConnectedToServerEvent event) {
/*  53 */     TerraFirmaCraft.proxy.onClientLogin();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onClientDisconnect(FMLNetworkEvent.ServerDisconnectionFromClientEvent event) {}
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
/*  64 */     float foodLevel = event.player.field_70170_p.field_73012_v.nextFloat() * 12.0F + 12.0F;
/*  65 */     FoodStatsTFC foodstats = TFC_Core.getPlayerFoodStats(event.player);
/*  66 */     foodstats.setFoodLevel(foodLevel);
/*  67 */     TFC_Core.setPlayerFoodStats(event.player, foodstats);
/*  68 */     event.player.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/*  69 */     event.player.func_70606_j(1000.0F * (0.25F + event.player.field_70170_p.field_73012_v.nextFloat() * 0.25F));
/*     */     
/*  71 */     PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(event.player);
/*  72 */     if (pi.tempSkills != null) {
/*  73 */       TFC_Core.setSkillStats(event.player, pi.tempSkills);
/*     */     }
/*     */     
/*  76 */     if (pi.tempEquipment != null && event.player.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
/*     */       
/*  78 */       InventoryPlayerTFC invPlayer = (InventoryPlayerTFC)event.player.field_71071_by;
/*  79 */       invPlayer.extraEquipInventory = (ItemStack[])pi.tempEquipment.clone();
/*  80 */       pi.tempEquipment = null;
/*     */     } 
/*     */ 
/*     */     
/*  84 */     PlayerUpdatePacket playerUpdatePacket = new PlayerUpdatePacket(event.player, 3);
/*  85 */     TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)playerUpdatePacket, (EntityPlayerMP)event.player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void notifyPickup(PlayerEvent.ItemPickupEvent event) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerTossEvent(ItemTossEvent event) {
/* 113 */     if (event.entityItem == null) {
/* 114 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
/*     */     try {
/* 121 */       event.player.field_71069_bz.func_75132_a((ICrafting)event.player);
/*     */     }
/* 123 */     catch (IllegalArgumentException illegalArgumentException) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\PlayerTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */