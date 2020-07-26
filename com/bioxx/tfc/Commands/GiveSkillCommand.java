/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class GiveSkillCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 16 */     return "giveskill";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 22 */     return func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 28 */     EntityPlayerMP var4 = func_71521_c(sender);
/*    */ 
/*    */     
/* 31 */     if (params.length == 2) {
/*    */       
/* 33 */       TFC_Core.getSkillStats((EntityPlayer)var4).increaseSkill(params[0], Integer.parseInt(params[1]));
/*    */     }
/* 35 */     else if (params.length == 3) {
/*    */       
/* 37 */       EntityPlayerMP player = func_82359_c(sender, params[0]);
/* 38 */       TFC_Core.getSkillStats((EntityPlayer)player).increaseSkill(params[1], Integer.parseInt(params[2]));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 44 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GiveSkillCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */