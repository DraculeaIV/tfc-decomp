/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESapling
/*    */   extends TileEntity
/*    */ {
/*    */   public long growTime;
/*    */   public boolean enoughSpace = true;
/*    */   
/*    */   public boolean canUpdate() {
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 27 */     super.func_145839_a(nbt);
/* 28 */     this.growTime = nbt.func_74763_f("growTime");
/* 29 */     this.enoughSpace = nbt.func_74767_n("enoughSpace");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 35 */     super.func_145841_b(nbt);
/* 36 */     nbt.func_74772_a("growTime", this.growTime);
/* 37 */     nbt.func_74757_a("enoughSpace", this.enoughSpace);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Packet func_145844_m() {
/* 43 */     NBTTagCompound nbt = new NBTTagCompound();
/* 44 */     func_145841_b(nbt);
/* 45 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
/* 51 */     func_145839_a(pkt.func_148857_g());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TESapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */