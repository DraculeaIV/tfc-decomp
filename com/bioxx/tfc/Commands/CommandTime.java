/*     */ package com.bioxx.tfc.Commands;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ public class CommandTime
/*     */   extends CommandBase
/*     */ {
/*     */   public String func_71517_b() {
/*  20 */     return "time";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  35 */     return "commands.time.usage";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  41 */     if (!TFCOptions.enableDebugMode) {
/*  42 */       if (par2ArrayOfStr.length > 1) {
/*     */ 
/*     */         
/*  45 */         long currentTime = TFC_Time.getTotalTicks();
/*     */         
/*  47 */         if (par2ArrayOfStr[0].equals("set")) {
/*     */           int i;
/*  49 */           if (par2ArrayOfStr[1].equals("day")) {
/*     */             
/*  51 */             i = (int)(currentTime + 24000L - currentTime % 24000L);
/*     */           }
/*  53 */           else if (par2ArrayOfStr[1].equals("night")) {
/*     */             
/*  55 */             i = 12500 + (int)(currentTime + 24000L - currentTime % 24000L);
/*     */           }
/*     */           else {
/*     */             
/*  59 */             i = func_71528_a(par1ICommandSender, par2ArrayOfStr[1], 0);
/*     */           } 
/*  61 */           if (i < currentTime) {
/*     */             
/*  63 */             par1ICommandSender.func_145747_a((IChatComponent)new ChatComponentText("Cannot set time to before current time."));
/*     */           }
/*     */           else {
/*     */             
/*  67 */             setTime(par1ICommandSender, i);
/*  68 */             func_152373_a(par1ICommandSender, (ICommand)this, "commands.time.set", new Object[] { Integer.valueOf(i) });
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*  73 */         if (par2ArrayOfStr[0].equals("add")) {
/*     */           
/*  75 */           int i = func_71528_a(par1ICommandSender, par2ArrayOfStr[1], 0);
/*  76 */           if (i + currentTime < currentTime) {
/*     */             
/*  78 */             par1ICommandSender.func_145747_a((IChatComponent)new ChatComponentText("Cannot set time to before current time."));
/*     */           }
/*     */           else {
/*     */             
/*  82 */             addTime(par1ICommandSender, i);
/*  83 */             func_152373_a(par1ICommandSender, (ICommand)this, "commands.time.added", new Object[] { Integer.valueOf(i) });
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } else {
/*  90 */       (new net.minecraft.command.CommandTime()).func_71515_b(par1ICommandSender, par2ArrayOfStr);
/*     */       return;
/*     */     } 
/*  93 */     throw new WrongUsageException("commands.time.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/* 102 */     return (par2ArrayOfStr.length == 1) ? func_71530_a(par2ArrayOfStr, new String[] { "set", "add" }) : ((par2ArrayOfStr.length == 2 && par2ArrayOfStr[0].equals("set")) ? func_71530_a(par2ArrayOfStr, new String[] { "day", "night" }) : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setTime(ICommandSender par1ICommandSender, int par2) {
/* 110 */     for (int j = 0; j < (MinecraftServer.func_71276_C()).field_71305_c.length; j++)
/*     */     {
/* 112 */       (MinecraftServer.func_71276_C()).field_71305_c[j].func_72877_b(par2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addTime(ICommandSender par1ICommandSender, int par2) {
/* 121 */     for (int j = 0; j < (MinecraftServer.func_71276_C()).field_71305_c.length; j++) {
/*     */       
/* 123 */       WorldServer worldserver = (MinecraftServer.func_71276_C()).field_71305_c[j];
/* 124 */       worldserver.func_72877_b(worldserver.func_72820_D() + par2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\CommandTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */