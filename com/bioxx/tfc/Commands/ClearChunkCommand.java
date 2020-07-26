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
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ public class ClearChunkCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 21 */     return "clearchunk";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 27 */     EntityPlayerMP player = func_71521_c(sender);
/*    */     
/* 29 */     if (!TFCOptions.enableDebugMode) {
/*    */       
/* 31 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Required"));
/*    */       
/*    */       return;
/*    */     } 
/* 35 */     MinecraftServer server = MinecraftServer.func_71276_C();
/* 36 */     WorldServer world = server.func_71218_a((player.func_130014_f_()).field_73011_w.field_76574_g);
/* 37 */     if (params.length == 0) {
/*    */       
/* 39 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Clearing Chunk"));
/* 40 */       Chunk chunk = world.func_72938_d((int)player.field_70165_t, (int)player.field_70161_v);
/* 41 */       for (int x = 0; x < 16; x++) {
/*    */         
/* 43 */         for (int z = 0; z < 16; z++) {
/*    */           
/* 45 */           for (int y = 256; y > 0; ) {
/*    */             
/* 47 */             Block id = chunk.func_150810_a(x, y, z);
/* 48 */             if (!TFC_Core.isRawStone(id)) {
/*    */               
/* 50 */               if (id != Blocks.field_150350_a) {
/* 51 */                 world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*    */               }
/*    */               
/*    */               y--;
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/* 59 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Clearing Chunk Complete"));
/*    */     }
/* 61 */     else if (params.length == 1) {
/*    */       
/* 63 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Clearing Chunks Within a Radius of " + Integer.parseInt(params[0])));
/* 64 */       int radius = Integer.parseInt(params[0]);
/* 65 */       for (int i = -radius; i <= radius; i++) {
/*    */         
/* 67 */         for (int k = -radius; k <= radius; k++) {
/*    */           
/* 69 */           Chunk chunk = world.func_72938_d((int)player.field_70165_t + i * 16, (int)player.field_70161_v + k * 16);
/* 70 */           for (int x = 0; x < 16; x++) {
/*    */             
/* 72 */             for (int z = 0; z < 16; z++) {
/*    */               
/* 74 */               for (int y = 256; y > 0; ) {
/*    */                 
/* 76 */                 Block id = chunk.func_150810_a(x, y, z);
/* 77 */                 if (!TFC_Core.isRawStone(id)) {
/*    */                   
/* 79 */                   if (id != Blocks.field_150350_a) {
/* 80 */                     world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*    */                   }
/*    */                   
/*    */                   y--;
/*    */                 } 
/*    */               } 
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/* 90 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Clearing Chunks Complete"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 97 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\ClearChunkCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */