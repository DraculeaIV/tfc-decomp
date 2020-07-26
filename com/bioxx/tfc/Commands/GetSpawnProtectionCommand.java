/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ 
/*    */ public class GetSpawnProtectionCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 16 */     return "gsp";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 22 */     if (sender.func_70003_b(0, sender.func_70005_c_())) {
/*    */       int x, z;
/* 24 */       EntityPlayerMP player = func_71521_c(sender);
/*    */ 
/*    */ 
/*    */       
/* 28 */       if (params.length >= 2) {
/*    */         
/*    */         try
/*    */         {
/* 32 */           x = Integer.parseInt(params[0]);
/* 33 */           z = Integer.parseInt(params[1]);
/*    */         }
/* 35 */         catch (NumberFormatException ex)
/*    */         {
/* 37 */           throw new WrongUsageException("invalid chunk coords: %d x %d", new Object[] { params[0], params[1] });
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 42 */         x = (int)player.field_70165_t >> 4;
/* 43 */         z = (int)player.field_70161_v >> 4;
/*    */       } 
/*    */       
/* 46 */       ChunkData d = TFC_Core.getCDM(player.field_70170_p).getData(x, z);
/*    */       
/* 48 */       if (d != null) {
/* 49 */         throw new PlayerNotFoundException("SP (" + x + "," + z + "): " + d.getSpawnProtectionWithUpdate(), new Object[0]);
/*    */       }
/* 51 */       throw new PlayerNotFoundException("Unable to find ChunkData for " + x + "," + z, new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 58 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GetSpawnProtectionCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */