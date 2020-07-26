/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class TEBerryBush
/*    */   extends NetworkTileEntity {
/*  7 */   public int dayHarvested = -1000;
/*  8 */   public int dayFruited = -1000;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasFruit;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canUpdate() {
/* 18 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 24 */     super.func_145839_a(nbt);
/* 25 */     this.dayHarvested = nbt.func_74762_e("dayHarvested");
/* 26 */     this.dayFruited = nbt.func_74762_e("dayFruited");
/* 27 */     this.hasFruit = nbt.func_74767_n("hasFruit");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 33 */     super.func_145841_b(nbt);
/* 34 */     nbt.func_74768_a("dayHarvested", this.dayHarvested);
/* 35 */     nbt.func_74768_a("dayFruited", this.dayFruited);
/* 36 */     nbt.func_74757_a("hasFruit", this.hasFruit);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 41 */     this.hasFruit = nbt.func_74767_n("hasFruit");
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
/* 58 */     nbt.func_74757_a("hasFruit", this.hasFruit);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBerryBush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */