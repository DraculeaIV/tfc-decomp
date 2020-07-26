/*    */ package com.bioxx.tfc.Handlers.Network;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.TileEntities.NetworkTileEntity;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataBlockPacket
/*    */   extends AbstractPacket
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int z;
/*    */   private NBTTagCompound nbtData;
/*    */   
/*    */   public DataBlockPacket() {}
/*    */   
/*    */   public DataBlockPacket(int x, int y, int z, NBTTagCompound data) {
/* 24 */     this.x = x;
/* 25 */     this.y = y;
/* 26 */     this.z = z;
/* 27 */     this.nbtData = data;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 33 */     PacketBuffer pb = new PacketBuffer(buffer);
/* 34 */     pb.writeInt(this.x);
/* 35 */     pb.writeShort(this.y);
/* 36 */     pb.writeInt(this.z);
/*    */     
/*    */     try {
/* 39 */       pb.func_150786_a(this.nbtData);
/*    */     }
/* 41 */     catch (Exception e) {
/*    */       
/* 43 */       TerraFirmaCraft.LOG.catching(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
/* 50 */     PacketBuffer pb = new PacketBuffer(buffer);
/* 51 */     this.x = pb.readInt();
/* 52 */     this.y = pb.readShort();
/* 53 */     this.z = pb.readInt();
/*    */     
/*    */     try {
/* 56 */       this.nbtData = pb.func_150793_b();
/*    */     }
/* 58 */     catch (Exception e) {
/*    */       
/* 60 */       TerraFirmaCraft.LOG.catching(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleClientSide(EntityPlayer player) {
/* 68 */     if (player.field_70170_p.func_147438_o(this.x, this.y, this.z) instanceof NetworkTileEntity) {
/*    */       
/* 70 */       NetworkTileEntity te = (NetworkTileEntity)player.field_70170_p.func_147438_o(this.x, this.y, this.z);
/* 71 */       if (te != null) {
/*    */         
/* 73 */         te.entityplayer = player;
/* 74 */         te.handleDataPacket(this.nbtData);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleServerSide(EntityPlayer player) {
/* 82 */     NetworkTileEntity te = (NetworkTileEntity)player.field_70170_p.func_147438_o(this.x, this.y, this.z);
/* 83 */     if (te != null) {
/*    */       
/* 85 */       te.entityplayer = player;
/* 86 */       te.handleDataPacket(this.nbtData);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\DataBlockPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */