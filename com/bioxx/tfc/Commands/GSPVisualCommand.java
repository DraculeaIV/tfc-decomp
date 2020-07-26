/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ 
/*    */ public class GSPVisualCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 19 */     return "vgsp";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 25 */     if (!TFCOptions.enableDebugMode)
/*    */       return; 
/* 27 */     MinecraftServer server = MinecraftServer.func_71276_C();
/*    */ 
/*    */     
/* 30 */     EntityPlayerMP player = func_71521_c(sender);
/* 31 */     WorldServer world = server.func_71218_a((player.func_130014_f_()).field_73011_w.field_76574_g);
/*    */     
/* 33 */     int px = (int)player.field_70165_t >> 4;
/* 34 */     int pz = (int)player.field_70161_v >> 4;
/*    */     
/* 36 */     ChunkData d = TFC_Core.getCDM((World)world).getData(px, pz);
/*    */     
/* 38 */     if (params.length == 0) {
/*    */       
/* 40 */       Chunk chunk = world.func_72938_d((int)player.field_70165_t, (int)player.field_70161_v);
/* 41 */       for (int x = 0; x < 16; x++) {
/*    */         
/* 43 */         for (int z = 0; z < 16; z++) {
/* 44 */           world.func_147465_d(x + chunk.field_76635_g * 16, (int)player.field_70163_u - 1, z + chunk.field_76647_h * 16, Blocks.field_150325_L, getColor(d.getSpawnProtectionWithUpdate()), 2);
/*    */         }
/*    */       } 
/* 47 */     } else if (params.length == 1) {
/*    */       
/* 49 */       int radius = Integer.parseInt(params[0]);
/* 50 */       for (int i = -radius; i <= radius; i++) {
/*    */         
/* 52 */         for (int k = -radius; k <= radius; k++) {
/*    */           
/* 54 */           Chunk chunk = world.func_72938_d((int)player.field_70165_t + i * 16, (int)player.field_70161_v + k * 16);
/* 55 */           for (int x = 0; x < 16; x++) {
/*    */             
/* 57 */             for (int z = 0; z < 16; z++) {
/* 58 */               world.func_147465_d(x + chunk.field_76635_g * 16, (int)player.field_70163_u - 1, z + chunk.field_76647_h * 16, Blocks.field_150325_L, getColor(d.getSpawnProtectionWithUpdate()), 2);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private int getColor(int val) {
/* 67 */     return val / 270;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 73 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GSPVisualCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */