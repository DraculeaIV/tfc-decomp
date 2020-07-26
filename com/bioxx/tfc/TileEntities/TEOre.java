/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ 
/*    */ public class TEOre
/*    */   extends NetworkTileEntity {
/*  9 */   public int baseBlockID = -1000;
/* 10 */   public int baseBlockMeta = -1000;
/*    */   
/*    */   public byte extraData;
/*    */   
/*    */   public TEOre() {
/* 15 */     this.shouldSendInitData = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canUpdate() {
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setVisible() {
/* 26 */     if ((this.extraData & 0x8) == 0) {
/* 27 */       this.extraData = (byte)(this.extraData + 8);
/*    */     }
/* 29 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 35 */     super.func_145839_a(nbt);
/* 36 */     this.baseBlockID = nbt.func_74762_e("baseBlockID");
/* 37 */     this.baseBlockMeta = nbt.func_74762_e("baseBlockMeta");
/* 38 */     this.extraData = nbt.func_74771_c("extraData");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 44 */     super.func_145841_b(nbt);
/* 45 */     nbt.func_74768_a("baseBlockID", this.baseBlockID);
/* 46 */     nbt.func_74768_a("baseBlockMeta", this.baseBlockMeta);
/* 47 */     nbt.func_74774_a("extraData", this.extraData);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Packet func_145844_m() {
/* 53 */     if ((this.extraData & 0x8) != 0 || this.field_145848_d > 100) {
/*    */       
/* 55 */       NBTTagCompound nbt = new NBTTagCompound();
/* 56 */       createInitNBT(nbt);
/* 57 */       return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nbt);
/*    */     } 
/* 59 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 65 */     this.baseBlockID = nbt.func_74762_e("id");
/* 66 */     this.baseBlockMeta = nbt.func_74762_e("meta");
/* 67 */     this.extraData = nbt.func_74771_c("extraData");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleDataPacket(NBTTagCompound nbt) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void createDataNBT(NBTTagCompound nbt) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void createInitNBT(NBTTagCompound nbt) {
/* 85 */     nbt.func_74768_a("id", this.baseBlockID);
/* 86 */     nbt.func_74768_a("meta", this.baseBlockMeta);
/* 87 */     nbt.func_74774_a("extraData", this.extraData);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */