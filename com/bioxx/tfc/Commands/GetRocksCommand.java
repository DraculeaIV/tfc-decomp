/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.Items.ItemLooseRock;
/*    */ import com.bioxx.tfc.WorldGen.DataLayer;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetRocksCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 20 */     return "gr";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 27 */     EntityPlayerMP var4 = func_71521_c(sender);
/*    */     
/* 29 */     DataLayer t0 = TFC_Climate.getRockLayer(var4.field_70170_p, (int)var4.field_70165_t, (int)var4.field_70163_u, (int)var4.field_70161_v, 0);
/* 30 */     DataLayer t1 = TFC_Climate.getRockLayer(var4.field_70170_p, (int)var4.field_70165_t, (int)var4.field_70163_u, (int)var4.field_70161_v, 1);
/* 31 */     DataLayer t2 = TFC_Climate.getRockLayer(var4.field_70170_p, (int)var4.field_70165_t, (int)var4.field_70163_u, (int)var4.field_70161_v, 2);
/*    */     
/* 33 */     String t0s = ((ItemLooseRock)TFCItems.looseRock).metaNames[t0.data1];
/* 34 */     String t1s = ((ItemLooseRock)TFCItems.looseRock).metaNames[t1.data1];
/* 35 */     String t2s = ((ItemLooseRock)TFCItems.looseRock).metaNames[t2.data1];
/*    */     
/* 37 */     throw new PlayerNotFoundException("Rock Layer 1: " + t0s + "   Rock Layer 2: " + t1s + "   Rock Layer 3: " + t2s, new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getSoilMetaFromStone(Block inType, int inMeta) {
/* 42 */     if (inType == TFCBlocks.stoneIgIn)
/* 43 */       return inMeta; 
/* 44 */     if (inType == TFCBlocks.stoneSed)
/* 45 */       return inMeta + 3; 
/* 46 */     if (inType == TFCBlocks.stoneIgEx) {
/* 47 */       return inMeta + 11;
/*    */     }
/* 49 */     return inMeta + 15;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 55 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GetRocksCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */