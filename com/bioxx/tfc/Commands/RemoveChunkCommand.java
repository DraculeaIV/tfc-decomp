/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ 
/*    */ public class RemoveChunkCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 20 */     return "removechunk";
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
/* 38 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Chunk"));
/* 39 */       Chunk chunk = world.func_72938_d((int)player.field_70165_t, (int)player.field_70161_v);
/* 40 */       chunk.func_76602_a(new net.minecraft.world.chunk.storage.ExtendedBlockStorage[16]);
/* 41 */       chunk.func_76630_e();
/* 42 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Chunk Complete"));
/*    */     }
/* 44 */     else if (params.length == 1) {
/*    */       
/* 46 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Chunks Within a Radius of " + Integer.parseInt(params[0])));
/* 47 */       int radius = Integer.parseInt(params[0]);
/* 48 */       for (int i = -radius; i <= radius; i++) {
/*    */         
/* 50 */         for (int k = -radius; k <= radius; k++) {
/*    */           
/* 52 */           Chunk chunk = world.func_72938_d((int)player.field_70165_t + i * 16, (int)player.field_70161_v + k * 16);
/* 53 */           chunk.func_76602_a(new net.minecraft.world.chunk.storage.ExtendedBlockStorage[16]);
/* 54 */           chunk.func_76630_e();
/*    */         } 
/*    */       } 
/*    */       
/* 58 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Removing Chunk Complete"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 65 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\RemoveChunkCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */