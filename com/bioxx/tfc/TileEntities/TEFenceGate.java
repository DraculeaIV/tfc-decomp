/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ public class TEFenceGate
/*    */   extends NetworkTileEntity
/*    */ {
/*    */   private boolean open;
/*    */   private byte direction;
/*    */   
/*    */   public boolean canUpdate() {
/* 13 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOpen(boolean value) {
/* 18 */     this.open = value;
/* 19 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDirection(byte value) {
/* 24 */     this.direction = value;
/* 25 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getOpen() {
/* 30 */     return this.open;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getDirection() {
/* 35 */     return this.direction;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 41 */     super.func_145839_a(nbt);
/* 42 */     this.open = nbt.func_74767_n("open");
/* 43 */     this.direction = nbt.func_74771_c("dir");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 49 */     super.func_145841_b(nbt);
/* 50 */     nbt.func_74757_a("open", this.open);
/* 51 */     nbt.func_74774_a("dir", this.direction);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 56 */     this.open = nbt.func_74767_n("open");
/* 57 */     this.direction = nbt.func_74771_c("dir");
/*    */   }
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
/* 74 */     nbt.func_74757_a("open", this.open);
/* 75 */     nbt.func_74774_a("dir", this.direction);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFenceGate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */