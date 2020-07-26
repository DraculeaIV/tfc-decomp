/*     */ package com.bioxx.tfc.Commands;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.PlayerNotFoundException;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ public class CommandTransferTamed
/*     */   extends CommandBase
/*     */ {
/*     */   public List func_71514_a() {
/*  23 */     return Arrays.asList(new String[] { "transfer" });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  29 */     return "transferTamed";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  38 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_71519_b(ICommandSender sender) {
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender sender) {
/*  50 */     return "commands.transferTamed.usage";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] chars) {
/*  56 */     if (sender instanceof EntityPlayer) {
/*  57 */       EntityPlayerMP entityplayermp = null;
/*  58 */       if (chars.length > 0) {
/*  59 */         entityplayermp = func_82359_c(sender, chars[0]);
/*     */       }
/*     */       
/*  62 */       EntityTameable tamedEntity = null;
/*  63 */       List<EntityTameable> entitiesInRange = ((EntityPlayer)sender).field_70170_p.func_72872_a(EntityTameable.class, ((EntityPlayer)sender).field_70121_D.func_72314_b(3.0D, 1.0D, 3.0D));
/*     */       
/*  65 */       if (entitiesInRange.isEmpty())
/*     */       {
/*  67 */         throw new WrongUsageException("commands.transferTamed.noTamed", new Object[0]);
/*     */       }
/*  69 */       if (entitiesInRange.size() > 1) {
/*  70 */         throw new WrongUsageException("commands.transferTamed.tooMany", new Object[0]);
/*     */       }
/*  72 */       if (entitiesInRange.size() == 1) {
/*  73 */         tamedEntity = entitiesInRange.get(0);
/*  74 */         if (tamedEntity.func_70902_q() == null || !tamedEntity.func_70902_q().equals(sender)) {
/*  75 */           throw new WrongUsageException("commands.transferTamed.wrongOwner", new Object[0]);
/*     */         }
/*     */       } 
/*     */       
/*  79 */       if (entityplayermp == null) {
/*     */         
/*  81 */         if (tamedEntity != null && chars.length == 0) {
/*  82 */           tamedEntity.func_70903_f(false);
/*  83 */           tamedEntity.func_152115_b("");
/*     */         } else {
/*     */           
/*  86 */           throw new PlayerNotFoundException();
/*     */         } 
/*     */       } else {
/*  89 */         if (entityplayermp == sender)
/*     */         {
/*  91 */           throw new PlayerNotFoundException("commands.transferTamed.sameTarget", new Object[0]);
/*     */         }
/*  93 */         if (tamedEntity != null) {
/*     */           
/*  95 */           tamedEntity.func_152115_b(entityplayermp.func_110124_au().toString());
/*     */           
/*  97 */           ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("commands.transferTamed.display.incoming", new Object[] { sender.func_145748_c_() });
/*  98 */           ChatComponentTranslation chatcomponenttranslation1 = new ChatComponentTranslation("commands.transferTamed.display.outgoing", new Object[] { entityplayermp.func_145748_c_() });
/*  99 */           chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.TRUE);
/* 100 */           chatcomponenttranslation1.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.TRUE);
/* 101 */           TFC_Core.sendInfoMessage((EntityPlayer)entityplayermp, (IChatComponent)chatcomponenttranslation);
/* 102 */           sender.func_145747_a((IChatComponent)chatcomponenttranslation1);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 106 */       throw new WrongUsageException("commands.transferTamed.wrongSender", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender sender, String[] string) {
/* 120 */     return func_71530_a(string, MinecraftServer.func_71276_C().func_71213_z());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_82358_a(String[] string, int index) {
/* 129 */     return (index == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\CommandTransferTamed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */