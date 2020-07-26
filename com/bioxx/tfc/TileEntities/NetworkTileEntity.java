/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.DataBlockPacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ public abstract class NetworkTileEntity
/*     */   extends TileEntity
/*     */ {
/*     */   public boolean shouldSendInitData = true;
/*     */   public EntityPlayer entityplayer;
/*  23 */   protected int broadcastRange = 256;
/*     */ 
/*     */   
/*     */   public abstract void handleInitPacket(NBTTagCompound paramNBTTagCompound);
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {}
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */   
/*     */   public abstract void createInitNBT(NBTTagCompound paramNBTTagCompound);
/*     */   
/*     */   public DataBlockPacket createDataPacket() {
/*  35 */     return createDataPacket(createDataNBT());
/*     */   }
/*     */ 
/*     */   
/*     */   public DataBlockPacket createDataPacket(NBTTagCompound nbt) {
/*  40 */     return new DataBlockPacket(this.field_145851_c, this.field_145848_d, this.field_145849_e, nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   private NBTTagCompound createDataNBT() {
/*  45 */     NBTTagCompound nbt = new NBTTagCompound();
/*  46 */     createDataNBT(nbt);
/*  47 */     return nbt;
/*     */   }
/*     */ 
/*     */   
/*     */   private NBTTagCompound createInitNBT() {
/*  52 */     NBTTagCompound nbt = new NBTTagCompound();
/*  53 */     createInitNBT(nbt);
/*  54 */     return nbt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_145833_n() {
/*  61 */     return 1024.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  68 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/*  74 */     if (this.shouldSendInitData)
/*  75 */       return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, createInitNBT()); 
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/*  82 */     handleInitPacket(pkt.func_148857_g());
/*  83 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void broadcastPacketInRange() {
/*  88 */     int dim = this.field_145850_b.field_73011_w.field_76574_g;
/*  89 */     if (this.field_145850_b.field_72995_K) {
/*  90 */       TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)createDataPacket());
/*     */     } else {
/*  92 */       TerraFirmaCraft.PACKET_PIPELINE.sendToAllAround((AbstractPacket)createDataPacket(), new NetworkRegistry.TargetPoint(dim, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.broadcastRange));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void broadcastPacketInRange(AbstractPacket packet) {
/*  98 */     if (this.field_145850_b.field_72995_K) {
/*  99 */       TerraFirmaCraft.PACKET_PIPELINE.sendToServer(packet);
/*     */     } else {
/* 101 */       TerraFirmaCraft.PACKET_PIPELINE.sendToAllAround(packet, new NetworkRegistry.TargetPoint(this.field_145850_b.field_73011_w.field_76574_g, this.field_145851_c, this.field_145848_d, this.field_145849_e, this.broadcastRange));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\NetworkTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */