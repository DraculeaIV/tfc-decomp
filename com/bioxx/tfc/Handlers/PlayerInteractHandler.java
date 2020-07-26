/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerInteractHandler
/*     */ {
/*  34 */   private Map<UUID, Long> lastDrink = new HashMap<UUID, Long>();
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/*  39 */     if (event.entityPlayer.field_70170_p.field_72995_K) {
/*     */       return;
/*     */     }
/*  42 */     ItemStack itemInHand = event.entityPlayer.func_71045_bC();
/*     */     
/*  44 */     boolean validAction = (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK || event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR);
/*     */     
/*  46 */     if (validAction && event.getResult() != Event.Result.DENY && itemInHand == null)
/*     */     {
/*  48 */       handleDrinkingWater(event.entityPlayer);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleDrinkingWater(EntityPlayer entityPlayer) {
/*  54 */     Long lastCheck = this.lastDrink.get(entityPlayer.func_110124_au());
/*  55 */     if (lastCheck != null && lastCheck.longValue() + 20L > TFC_Time.getTotalTicks())
/*     */       return; 
/*  57 */     this.lastDrink.put(entityPlayer.func_110124_au(), Long.valueOf(TFC_Time.getTotalTicks()));
/*  58 */     World world = entityPlayer.field_70170_p;
/*  59 */     MovingObjectPosition mop = Helper.getMovingObjectPositionFromPlayer(world, (EntityLivingBase)entityPlayer, true);
/*  60 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(entityPlayer);
/*  61 */     Boolean canDrink = Boolean.valueOf(((fs.getMaxWater(entityPlayer) - 500) > fs.waterLevel));
/*     */ 
/*     */     
/*  64 */     if (mop != null && canDrink.booleanValue() && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK)
/*     */     {
/*  66 */       if (TFC_Core.isFreshWater(world.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d))) {
/*     */ 
/*     */         
/*  69 */         fs.restoreWater(entityPlayer, 2000);
/*     */ 
/*     */         
/*  72 */         world.func_72956_a((Entity)entityPlayer, "random.drink", 0.2F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onItemPickup(EntityItemPickupEvent event) {
/*  85 */     EntityItem item = event.item;
/*  86 */     ItemStack is = item.func_92059_d();
/*  87 */     EntityPlayer player = event.entityPlayer;
/*     */     
/*  89 */     if (is.func_77973_b() == Items.field_151055_y) {
/*     */       
/*  91 */       int count = is.field_77994_a;
/*  92 */       item.field_145804_b = 100;
/*  93 */       item.func_70106_y();
/*  94 */       item.func_82142_c(true);
/*  95 */       Random rand = player.field_70170_p.field_73012_v;
/*  96 */       player.field_70170_p.func_72956_a((Entity)player, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*  97 */       ItemStack tfcSticks = new ItemStack(TFCItems.stick, count);
/*  98 */       player.field_71071_by.func_70441_a(tfcSticks);
/*     */     }
/* 100 */     else if (is.func_77973_b() == Item.func_150898_a(Blocks.field_150344_f) && is.func_77960_j() == 0) {
/*     */       
/* 102 */       int count = is.field_77994_a;
/* 103 */       item.field_145804_b = 100;
/* 104 */       item.func_70106_y();
/* 105 */       item.func_82142_c(true);
/* 106 */       Random rand = player.field_70170_p.field_73012_v;
/* 107 */       player.field_70170_p.func_72956_a((Entity)player, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 108 */       ItemStack tfcPlanks = new ItemStack(TFCBlocks.planks, count);
/* 109 */       player.field_71071_by.func_70441_a(tfcPlanks);
/*     */     }
/* 111 */     else if (is.func_77973_b() == Item.func_150898_a(Blocks.field_150428_aP)) {
/*     */       
/* 113 */       int count = is.field_77994_a;
/* 114 */       item.field_145804_b = 100;
/* 115 */       item.func_70106_y();
/* 116 */       item.func_82142_c(true);
/* 117 */       Random rand = player.field_70170_p.field_73012_v;
/* 118 */       player.field_70170_p.func_72956_a((Entity)player, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 119 */       ItemStack jackOLanternTFC = new ItemStack(TFCBlocks.litPumpkin, count);
/* 120 */       player.field_71071_by.func_70441_a(jackOLanternTFC);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\PlayerInteractHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */