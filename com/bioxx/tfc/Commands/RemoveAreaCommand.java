/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class RemoveAreaCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 20 */     return "removearea";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 26 */     EntityPlayerMP player = func_71521_c(sender);
/*    */     
/* 28 */     if (!TFCOptions.enableDebugMode) {
/*    */       
/* 30 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Required"));
/*    */       
/*    */       return;
/*    */     } 
/* 34 */     MinecraftServer server = MinecraftServer.func_71276_C();
/* 35 */     WorldServer world = server.func_71218_a((player.func_130014_f_()).field_73011_w.field_76574_g);
/* 36 */     if (params.length == 0) {
/*    */       
/* 38 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing 16 blocks up and +/- x, z"));
/* 39 */       for (int x = -15; x < 16; x++) {
/*    */         
/* 41 */         for (int z = -15; z < 16; z++) {
/*    */           
/* 43 */           for (int y = 0; y < 16; y++) {
/*    */             
/* 45 */             Block id = world.func_147439_a(x + (int)player.field_70165_t, y + (int)player.field_70163_u, z + (int)player.field_70161_v);
/* 46 */             if (id != Blocks.field_150357_h) {
/* 47 */               world.func_147465_d(x + (int)player.field_70165_t, y + (int)player.field_70163_u, z + (int)player.field_70161_v, Blocks.field_150350_a, 0, 2);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/* 52 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Area Complete"));
/*    */     }
/* 54 */     else if (params.length == 3) {
/*    */       
/* 56 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Area"));
/* 57 */       int radius = Integer.parseInt(params[0]);
/* 58 */       for (int x = -radius; x <= Integer.parseInt(params[0]); x++) {
/*    */         
/* 60 */         for (int z = -Integer.parseInt(params[2]); z <= Integer.parseInt(params[2]); z++) {
/*    */           
/* 62 */           for (int y = 0; y <= Integer.parseInt(params[1]); y++) {
/*    */             
/* 64 */             Block id = world.func_147439_a(x + (int)player.field_70165_t, y + (int)player.field_70163_u, z + (int)player.field_70161_v);
/* 65 */             if (id != Blocks.field_150357_h) {
/* 66 */               world.func_147465_d(x + (int)player.field_70165_t, y + (int)player.field_70163_u, z + (int)player.field_70161_v, Blocks.field_150350_a, 0, 2);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/* 71 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Area Complete"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 78 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\RemoveAreaCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */