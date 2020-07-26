/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*    */ import com.bioxx.tfc.Handlers.Network.DebugModePacket;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class DebugModeCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 19 */     return "debugmode";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 25 */     EntityPlayerMP player = func_71521_c(sender);
/*    */     
/* 27 */     if (params.length == 0) {
/*    */       
/* 29 */       if (TFCOptions.enableDebugMode) {
/*    */         
/* 31 */         TFCOptions.enableDebugMode = false;
/* 32 */         TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Disabled"));
/*    */       }
/*    */       else {
/*    */         
/* 36 */         TFCOptions.enableDebugMode = true;
/* 37 */         TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Enabled"));
/*    */       } 
/*    */       
/* 40 */       DebugModePacket debugModePacket = new DebugModePacket((EntityPlayer)player);
/* 41 */       TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)debugModePacket, player);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 48 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\DebugModeCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */