/*    */ package com.bioxx.tfc.Handlers.Network;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DebugModePacket
/*    */   extends AbstractPacket
/*    */ {
/*    */   private boolean debugMode;
/*    */   
/*    */   public DebugModePacket() {}
/*    */   
/*    */   public DebugModePacket(EntityPlayer p) {
/* 18 */     this.debugMode = TFCOptions.enableDebugMode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 24 */     buffer.writeBoolean(this.debugMode);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 30 */     this.debugMode = buffer.readBoolean();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClientSide(EntityPlayer player) {
/* 36 */     TFCOptions.enableDebugMode = this.debugMode;
/*    */   }
/*    */   
/*    */   public void handleServerSide(EntityPlayer player) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\DebugModePacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */