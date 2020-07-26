/*    */ package com.bioxx.tfc.Handlers.Client;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.BlockDetailed;
/*    */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*    */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*    */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*    */ import com.bioxx.tfc.Handlers.Network.KeyPressPacket;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.InputEvent;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyBindingHandler
/*    */ {
/* 25 */   public static KeyBinding keyToolMode = new KeyBinding("key.ToolMode", 50, "TerraFirmaCraft");
/* 26 */   public static KeyBinding keyLockTool = new KeyBinding("key.LockTool", 38, "TerraFirmaCraft");
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onKeyInput(InputEvent.KeyInputEvent event) {
/* 31 */     PlayerInfo pi = PlayerManagerTFC.getInstance().getClientPlayer();
/* 32 */     EntityClientPlayerMP player = (FMLClientHandler.instance().getClient()).field_71439_g;
/*    */     
/* 34 */     if ((FMLClientHandler.instance().getClient()).field_71415_G && 
/* 35 */       (FMLClientHandler.instance().getClient()).field_71439_g.func_71045_bC() != null && 
/* 36 */       (FMLClientHandler.instance().getClient()).field_71462_r == null)
/*    */     {
/* 38 */       if (keyToolMode.func_151468_f()) {
/*    */         
/* 40 */         if (player.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel)
/*    */         {
/* 42 */           pi.switchChiselMode();
/*    */ 
/*    */           
/* 45 */           KeyPressPacket keyPressPacket = new KeyPressPacket(pi.chiselMode);
/* 46 */           TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)keyPressPacket);
/*    */         }
/* 48 */         else if (player.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomHoe)
/*    */         {
/* 50 */           pi.switchHoeMode((EntityPlayer)player);
/*    */         }
/*    */       
/* 53 */       } else if (keyLockTool.func_151468_f() && pi != null) {
/*    */         
/* 55 */         if (pi.lockX == -9999999) {
/*    */           
/* 57 */           pi.lockX = BlockDetailed.lockX;
/* 58 */           pi.lockY = BlockDetailed.lockY;
/* 59 */           pi.lockZ = BlockDetailed.lockZ;
/*    */         }
/*    */         else {
/*    */           
/* 63 */           pi.lockX = -9999999;
/* 64 */           pi.lockY = -9999999;
/* 65 */           pi.lockZ = -9999999;
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\KeyBindingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */