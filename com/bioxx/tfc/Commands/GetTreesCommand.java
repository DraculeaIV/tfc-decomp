/*    */ package com.bioxx.tfc.Commands;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.api.Enums.EnumTree;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ 
/*    */ public class GetTreesCommand
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 15 */     return "gt";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] params) {
/* 23 */     EntityPlayerMP var4 = func_71521_c(sender);
/* 24 */     int posX = (int)Math.floor(var4.field_70165_t);
/* 25 */     int posY = (int)Math.floor(var4.field_70163_u);
/* 26 */     int posZ = (int)Math.floor(var4.field_70161_v);
/*    */     
/* 28 */     int t0ID = TFC_Climate.getTreeLayer(var4.field_70170_p, posX, posY, posZ, 0);
/* 29 */     int t1ID = TFC_Climate.getTreeLayer(var4.field_70170_p, posX, posY, posZ, 1);
/* 30 */     int t2ID = TFC_Climate.getTreeLayer(var4.field_70170_p, posX, posY, posZ, 2);
/*    */     
/* 32 */     String t0 = "None";
/* 33 */     if (t0ID != -1)
/* 34 */       t0 = EnumTree.values()[t0ID].name(); 
/* 35 */     String t1 = "None";
/* 36 */     if (t0ID != -1)
/* 37 */       t1 = EnumTree.values()[t1ID].name(); 
/* 38 */     String t2 = "None";
/* 39 */     if (t0ID != -1) {
/* 40 */       t2 = EnumTree.values()[t2ID].name();
/*    */     }
/* 42 */     throw new PlayerNotFoundException("Tree 0: " + t0 + "   Tree 1: " + t1 + "   Tree 2: " + t2, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender icommandsender) {
/* 48 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Commands\GetTreesCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */