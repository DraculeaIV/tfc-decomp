/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class SetPlayerStatsCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 18 */     return "sps";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 24 */     return func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 29 */     double[] values = new double[3];
/*    */     
/* 31 */     if (params.length == 4 || params.length == 3) {
/* 32 */       for (int i = 0; i < 3; i++) {
/*    */         try {
/* 34 */           values[i] = Double.parseDouble(params[i + params.length - 3]);
/* 35 */         } catch (NumberFormatException e) {
/* 36 */           throw new PlayerNotFoundException("Invalid", new Object[0]);
/*    */         } 
/* 38 */         if (values[i] < 0.0D || values[i] > 100.0D) {
/* 39 */           throw new PlayerNotFoundException("Invalid", new Object[0]);
/*    */         }
/*    */       } 
/*    */     }
/* 43 */     EntityPlayerMP player = func_71521_c(sender);
/* 44 */     if (params.length == 4) {
/*    */       try {
/* 46 */         player = func_82359_c(sender, params[0]);
/* 47 */       } catch (PlayerNotFoundException e) {
/* 48 */         throw new PlayerNotFoundException("Unknown Player", new Object[0]);
/*    */       } 
/*    */     }
/* 51 */     if (player == null) {
/* 52 */       throw new PlayerNotFoundException("Invalid", new Object[0]);
/*    */     }
/* 54 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats((EntityPlayer)player);
/* 55 */     player.func_70606_j((int)(values[0] / 100.0D * player.func_110138_aP()));
/* 56 */     fs.setFoodLevel((int)values[1]);
/* 57 */     fs.waterLevel = (int)(values[2] / 100.0D * fs.getMaxWater((EntityPlayer)player));
/* 58 */     throw new PlayerNotFoundException(values[0] + " " + values[1] + " " + values[2], new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 64 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\SetPlayerStatsCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */