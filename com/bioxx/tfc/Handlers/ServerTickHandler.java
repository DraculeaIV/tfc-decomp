/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServerTickHandler
/*    */ {
/* 16 */   private long wSeed = Long.MIN_VALUE;
/*    */   public int ticks;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onServerWorldTick(TickEvent.WorldTickEvent event) {
/* 21 */     World world = event.world;
/* 22 */     if (event.phase == TickEvent.Phase.START) {
/*    */       
/* 24 */       if (world.field_73011_w.field_76574_g == 0 && world.func_72912_H().func_76063_b() != this.wSeed) {
/*    */         
/* 26 */         TFC_Core.setupWorld(world);
/* 27 */         this.wSeed = world.func_72912_H().func_76063_b();
/*    */       } 
/* 29 */       TFC_Time.updateTime(world);
/*    */ 
/*    */ 
/*    */       
/* 33 */       if (MinecraftServer.func_71276_C().func_71233_x() == 0 && TFCOptions.simSpeedNoPlayers > 0) {
/*    */         
/* 35 */         this.ticks++;
/* 36 */         long t = world.func_72912_H().func_82573_f();
/* 37 */         long w = world.func_72912_H().func_76073_f();
/* 38 */         if (this.ticks < TFCOptions.simSpeedNoPlayers) {
/*    */           
/* 40 */           world.func_72912_H().func_82572_b(t - 1L);
/* 41 */           world.func_72912_H().func_76068_b(w - 1L);
/*    */         }
/*    */         else {
/*    */           
/* 45 */           this.ticks = 0;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\ServerTickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */