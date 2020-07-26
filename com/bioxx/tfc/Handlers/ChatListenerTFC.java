/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ChatComponentTranslation;
/*    */ import net.minecraftforge.event.ServerChatEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatListenerTFC
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onServerChatEvent(ServerChatEvent event) {
/* 19 */     String msg = event.message;
/* 20 */     long soberTime = (TFC_Core.getPlayerFoodStats((EntityPlayer)event.player)).soberTime;
/* 21 */     if (soberTime > TFC_Time.getTotalTicks()) {
/*    */       
/* 23 */       String s = "aeiouywrsflzvbnmAEIOUYWRSFLZVBNM";
/* 24 */       Random rand = new Random();
/* 25 */       soberTime -= TFC_Time.getTotalTicks();
/* 26 */       for (int i = 0; i < event.message.length() - 1; i++) {
/*    */         
/* 28 */         String start = event.message.substring(0, i);
/* 29 */         String s2 = event.message.substring(i, i + 1);
/* 30 */         String end = event.message.substring(i + 1);
/*    */         
/* 32 */         if (event.message.charAt(0) != '/') {
/*    */           
/* 34 */           int chance = Math.max(1, 11 - (int)(soberTime / 1000L));
/* 35 */           if (s.indexOf(s2) != -1 && rand.nextInt(chance) == 0) {
/*    */             
/* 37 */             int n = rand.nextInt(2);
/* 38 */             int m = 0;
/* 39 */             msg = start + s2;
/* 40 */             for (int j = 0; j < n; j++)
/*    */             {
/* 42 */               msg = msg + (end.substring(0, 1).toUpperCase().equals(end.substring(0, 1)) ? s2 : s2.toLowerCase());
/*    */             }
/* 44 */             if (("S".equals(s2) || "s".equals(s2)) && !"S".equals(end.substring(0, 1)) && !"s".equals(end.substring(0, 1))) {
/*    */               
/* 46 */               msg = msg + (s2.toUpperCase().equals(s2) ? (end.substring(0, 1).toUpperCase().equals(end.substring(0, 1)) ? "H" : "h".toLowerCase()) : "h");
/* 47 */               m++;
/*    */             } 
/* 49 */             msg = msg + end;
/* 50 */             i += m;
/*    */           } 
/*    */         } 
/*    */       } 
/* 54 */       event.component = new ChatComponentTranslation("<" + event.username + "> " + msg, new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\ChatListenerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */