/*     */ package com.bioxx.tfc.Commands;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.Generators.OreSpawnData;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenOre;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ 
/*     */ public class StripChunkCommand
/*     */   extends CommandBase
/*     */ {
/*     */   public String func_71517_b() {
/*  26 */     return "stripchunk";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] params) {
/*  32 */     EntityPlayerMP player = func_71521_c(sender);
/*     */     
/*  34 */     if (!TFCOptions.enableDebugMode) {
/*     */       
/*  36 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Debug Mode Required"));
/*     */       
/*     */       return;
/*     */     } 
/*  40 */     MinecraftServer server = MinecraftServer.func_71276_C();
/*  41 */     WorldServer world = server.func_71218_a((player.func_130014_f_()).field_73011_w.field_76574_g);
/*  42 */     if (params.length == 0) {
/*     */       
/*  44 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Stripping Chunk"));
/*  45 */       Chunk chunk = world.func_72938_d((int)player.field_70165_t, (int)player.field_70161_v);
/*  46 */       for (int x = 0; x < 16; x++) {
/*     */         
/*  48 */         for (int z = 0; z < 16; z++) {
/*     */           
/*  50 */           for (int y = 0; y < 256; y++) {
/*     */             
/*  52 */             Block id = chunk.func_150810_a(x, y, z);
/*  53 */             if (id != Blocks.field_150350_a && id != TFCBlocks.ore && id != TFCBlocks.ore2 && id != TFCBlocks.ore3 && id != Blocks.field_150357_h)
/*     */             {
/*  55 */               if (TFC_Core.isGround(id)) {
/*     */                 
/*  57 */                 world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*     */               }
/*     */               else {
/*     */                 
/*  61 */                 Boolean isOre = Boolean.valueOf(false);
/*  62 */                 Iterator<OreSpawnData> iter = WorldGenOre.oreList.values().iterator();
/*  63 */                 while (iter.hasNext()) {
/*     */                   
/*  65 */                   OreSpawnData osd = iter.next();
/*  66 */                   if (osd != null && id == osd.block) {
/*     */                     
/*  68 */                     isOre = Boolean.valueOf(true);
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*  73 */                 if (!isOre.booleanValue())
/*     */                 {
/*  75 */                   world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  83 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Stripping Chunk Complete"));
/*     */     }
/*  85 */     else if (params.length == 1) {
/*     */       
/*  87 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Stripping Chunks Within a Radius of " + Integer.parseInt(params[0])));
/*  88 */       int radius = Integer.parseInt(params[0]);
/*  89 */       for (int i = -radius; i <= radius; i++) {
/*     */         
/*  91 */         for (int k = -radius; k <= radius; k++) {
/*     */           
/*  93 */           Chunk chunk = world.func_72938_d((int)player.field_70165_t + i * 16, (int)player.field_70161_v + k * 16);
/*  94 */           for (int x = 0; x < 16; x++) {
/*     */             
/*  96 */             for (int z = 0; z < 16; z++) {
/*     */               
/*  98 */               for (int y = 0; y < 256; y++) {
/*     */                 
/* 100 */                 Block id = chunk.func_150810_a(x, y, z);
/* 101 */                 if (id != Blocks.field_150350_a && id != TFCBlocks.ore && id != TFCBlocks.ore2 && id != TFCBlocks.ore3 && id != Blocks.field_150357_h)
/*     */                 {
/* 103 */                   if (TFC_Core.isGround(id)) {
/*     */                     
/* 105 */                     world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*     */                   }
/*     */                   else {
/*     */                     
/* 109 */                     Boolean isOre = Boolean.valueOf(false);
/* 110 */                     Iterator<OreSpawnData> iter = WorldGenOre.oreList.values().iterator();
/* 111 */                     while (iter.hasNext()) {
/*     */                       
/* 113 */                       OreSpawnData osd = iter.next();
/* 114 */                       if (osd != null && id == osd.block) {
/*     */                         
/* 116 */                         isOre = Boolean.valueOf(true);
/*     */                         
/*     */                         break;
/*     */                       } 
/*     */                     } 
/* 121 */                     if (!isOre.booleanValue())
/*     */                     {
/* 123 */                       world.func_147465_d(x + chunk.field_76635_g * 16, y, z + chunk.field_76647_h * 16, Blocks.field_150350_a, 0, 2);
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 133 */       TFC_Core.sendInfoMessage((EntityPlayer)player, (IChatComponent)new ChatComponentText("Stripping Chunk Complete"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 140 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\StripChunkCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */