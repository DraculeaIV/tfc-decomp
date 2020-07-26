/*     */ package com.bioxx.tfc.Handlers.Network;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.FMLEmbeddedChannel;
/*     */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandler.Sharable;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.handler.codec.MessageToMessageCodec;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Sharable
/*     */ public class PacketPipeline
/*     */   extends MessageToMessageCodec<FMLProxyPacket, AbstractPacket>
/*     */ {
/*     */   private EnumMap<Side, FMLEmbeddedChannel> channels;
/*  39 */   private List<Class<? extends AbstractPacket>> packets = new LinkedList<Class<? extends AbstractPacket>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isPostInitialised;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerPacket(Class<? extends AbstractPacket> clazz) {
/*  55 */     if (this.packets.size() > 256) {
/*     */       
/*  57 */       TerraFirmaCraft.LOG.error("Error Registering Packet, Too Big: " + clazz.getName());
/*  58 */       return false;
/*     */     } 
/*     */     
/*  61 */     if (this.packets.contains(clazz)) {
/*     */       
/*  63 */       TerraFirmaCraft.LOG.error("Error Registering Packet, Already Exists: " + clazz.getName());
/*  64 */       return false;
/*     */     } 
/*     */     
/*  67 */     if (this.isPostInitialised) {
/*     */       
/*  69 */       TerraFirmaCraft.LOG.error("Error Registering Packet, Initialization Already Completed: " + clazz.getName());
/*  70 */       return false;
/*     */     } 
/*     */     
/*  73 */     this.packets.add(clazz);
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, List<Object> out) throws Exception {
/*  81 */     if (!this.packets.contains(msg.getClass()))
/*     */     {
/*  83 */       throw new NullPointerException("No Packet Registered for: " + msg.getClass().getCanonicalName());
/*     */     }
/*     */     
/*  86 */     Class<? extends AbstractPacket> clazz = (Class)msg.getClass();
/*  87 */     ByteBuf buffer = Unpooled.buffer();
/*  88 */     byte discriminator = (byte)this.packets.indexOf(clazz);
/*  89 */     buffer.writeByte(discriminator);
/*  90 */     msg.encodeInto(ctx, buffer);
/*  91 */     FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
/*  92 */     out.add(proxyPacket);
/*     */   }
/*     */   
/*     */   protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
/*     */     EntityPlayer player;
/*     */     EntityPlayerMP entityPlayerMP;
/*     */     INetHandler netHandler;
/*  99 */     ByteBuf payload = msg.payload();
/* 100 */     byte discriminator = payload.readByte();
/* 101 */     Class<? extends AbstractPacket> clazz = this.packets.get(discriminator);
/* 102 */     if (clazz == null)
/*     */     {
/* 104 */       throw new NullPointerException("No packet registered for discriminator: " + discriminator);
/*     */     }
/*     */     
/* 107 */     AbstractPacket pkt = clazz.newInstance();
/* 108 */     pkt.decodeInto(ctx, payload.slice());
/*     */ 
/*     */     
/* 111 */     switch (FMLCommonHandler.instance().getEffectiveSide()) {
/*     */       
/*     */       case CLIENT:
/* 114 */         player = getClientPlayer();
/* 115 */         pkt.handleClientSide(player);
/*     */         break;
/*     */       
/*     */       case SERVER:
/* 119 */         netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
/* 120 */         entityPlayerMP = ((NetHandlerPlayServer)netHandler).field_147369_b;
/* 121 */         pkt.handleServerSide((EntityPlayer)entityPlayerMP);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initalise() {
/* 131 */     this.channels = NetworkRegistry.INSTANCE.newChannel("TerraFirmaCraft", new ChannelHandler[] { (ChannelHandler)this });
/* 132 */     registerPackets();
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerPackets() {
/* 137 */     registerPacket((Class)KeyPressPacket.class);
/* 138 */     registerPacket((Class)InitClientWorldPacket.class);
/* 139 */     registerPacket((Class)DataBlockPacket.class);
/* 140 */     registerPacket((Class)ItemRenamePacket.class);
/* 141 */     registerPacket((Class)KnappingUpdatePacket.class);
/* 142 */     registerPacket((Class)PlayerUpdatePacket.class);
/* 143 */     registerPacket((Class)CreateMealPacket.class);
/* 144 */     registerPacket((Class)TestPacket.class);
/* 145 */     registerPacket((Class)ItemNBTPacket.class);
/* 146 */     registerPacket((Class)DebugModePacket.class);
/* 147 */     registerPacket((Class)ConfigSyncPacket.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void postInitialise() {
/* 155 */     if (this.isPostInitialised) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 160 */     this.isPostInitialised = true;
/* 161 */     Collections.sort(this.packets, new Comparator<Class<? extends AbstractPacket>>()
/*     */         {
/*     */ 
/*     */           
/*     */           public int compare(Class<? extends AbstractPacket> clazz1, Class<? extends AbstractPacket> clazz2)
/*     */           {
/* 167 */             int com = String.CASE_INSENSITIVE_ORDER.compare(clazz1.getCanonicalName(), clazz2.getCanonicalName());
/* 168 */             if (com == 0)
/*     */             {
/* 170 */               com = clazz1.getCanonicalName().compareTo(clazz2.getCanonicalName());
/*     */             }
/*     */             
/* 173 */             return com;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private EntityPlayer getClientPlayer() {
/* 181 */     return (EntityPlayer)(Minecraft.func_71410_x()).field_71439_g;
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
/*     */   
/*     */   public void sendToAll(AbstractPacket message) {
/* 195 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
/* 196 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendTo(AbstractPacket message, EntityPlayerMP player) {
/* 212 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
/* 213 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
/* 214 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAllAround(AbstractPacket message, NetworkRegistry.TargetPoint point) {
/* 232 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
/* 233 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
/* 234 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToDimension(AbstractPacket message, int dimensionId) {
/* 250 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
/* 251 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
/* 252 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message);
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
/*     */   
/*     */   public void sendToServer(AbstractPacket message) {
/* 266 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
/* 267 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).writeAndFlush(message);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Network\PacketPipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */