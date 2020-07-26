/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TEBloom
/*    */   extends TileEntity
/*    */ {
/* 12 */   public int size = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSize(int iron) {
/* 17 */     this.size = iron;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 23 */     super.func_145841_b(nbttagcompound);
/* 24 */     nbttagcompound.func_74768_a("size", this.size);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 30 */     super.func_145839_a(nbttagcompound);
/* 31 */     this.size = nbttagcompound.func_74762_e("size");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEBloom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */