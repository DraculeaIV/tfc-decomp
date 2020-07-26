/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ 
/*    */ public class GetBodyTemp
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 15 */     return "bodytemp";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 27 */     return func_71530_a(par2ArrayOfStr, MinecraftServer.func_71276_C().func_71213_z());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 33 */     EntityPlayerMP var4 = func_71521_c(sender);
/* 34 */     float temp = var4.getEntityData().func_74764_b("bodyTemp") ? var4.getEntityData().func_74760_g("bodyTemp") : -1.0F;
/* 35 */     throw new PlayerNotFoundException("Body Temperature: " + temp, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_71519_b(ICommandSender sender) {
/* 42 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 48 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GetBodyTemp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */