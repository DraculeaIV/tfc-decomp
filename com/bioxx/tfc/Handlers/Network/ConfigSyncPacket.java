/*    */ package com.bioxx.tfc.Handlers.Network;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Config.SyncingOption;
/*    */ import com.bioxx.tfc.Core.Config.TFC_ConfigFiles;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigSyncPacket
/*    */   extends AbstractPacket
/*    */ {
/*    */   private Map<String, Boolean> map;
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 33 */     buffer.writeInt(TFC_ConfigFiles.SYNCING_OPTION_MAP.size());
/* 34 */     for (SyncingOption option : TFC_ConfigFiles.SYNCING_OPTION_MAP.values()) {
/*    */       
/* 36 */       ByteBufUtils.writeUTF8String(buffer, option.name);
/* 37 */       buffer.writeBoolean(option.inConfig());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 44 */     int size = buffer.readInt();
/* 45 */     this.map = new HashMap<String, Boolean>(size);
/* 46 */     for (int i = 0; i < size; i++)
/*    */     {
/* 48 */       this.map.put(ByteBufUtils.readUTF8String(buffer), Boolean.valueOf(buffer.readBoolean()));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClientSide(EntityPlayer player) {
/* 55 */     if (this.map == null) throw new IllegalStateException("Packet was not decoded"); 
/* 56 */     TerraFirmaCraft.LOG.info("Applying server TFCCrafting settings");
/*    */     
/*    */     try {
/* 59 */       for (Map.Entry<String, Boolean> entry : this.map.entrySet())
/*    */       {
/* 61 */         ((SyncingOption)TFC_ConfigFiles.SYNCING_OPTION_MAP.get(entry.getKey())).apply(((Boolean)entry.getValue()).booleanValue());
/*    */       }
/*    */     }
/* 64 */     catch (IllegalAccessException e) {
/*    */       
/* 66 */       TerraFirmaCraft.LOG.fatal("Error loading TFCCrafting settings from server!", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void handleServerSide(EntityPlayer player) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\ConfigSyncPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */