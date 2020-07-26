/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class TEFruitLeaves
/*    */   extends NetworkTileEntity {
/*  7 */   public int dayHarvested = -1000;
/*  8 */   public int dayFruited = -1000;
/*    */   
/*    */   public boolean hasFruit;
/*    */   
/*    */   public TEFruitLeaves() {
/* 13 */     this.shouldSendInitData = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canUpdate() {
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 25 */     super.func_145839_a(nbt);
/* 26 */     this.dayHarvested = nbt.func_74762_e("dayHarvested");
/* 27 */     this.dayFruited = nbt.func_74762_e("dayFruited");
/* 28 */     this.hasFruit = nbt.func_74767_n("hasFruit");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 34 */     super.func_145841_b(nbt);
/* 35 */     nbt.func_74768_a("dayHarvested", this.dayHarvested);
/* 36 */     nbt.func_74768_a("dayFruited", this.dayFruited);
/* 37 */     nbt.func_74757_a("hasFruit", this.hasFruit);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 42 */     this.hasFruit = nbt.func_74767_n("hasFruit");
/* 43 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleDataPacket(NBTTagCompound nbt) {
/* 48 */     this.hasFruit = nbt.func_74767_n("hasFruit");
/* 49 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void createDataNBT(NBTTagCompound nbt) {
/* 54 */     nbt.func_74757_a("hasFruit", this.hasFruit);
/*    */   }
/*    */ 
/*    */   
/*    */   public void createInitNBT(NBTTagCompound nbt) {
/* 59 */     nbt.func_74757_a("hasFruit", this.hasFruit);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFruitLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */