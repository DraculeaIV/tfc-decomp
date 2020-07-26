/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TEMetalTrapDoor
/*    */   extends NetworkTileEntity
/*    */ {
/*    */   public ItemStack sheetStack;
/*    */   public byte data;
/*    */   
/*    */   public boolean canUpdate() {
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSide() {
/* 26 */     return this.data & 0x7;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 32 */     super.func_145839_a(nbt);
/* 33 */     this.sheetStack = ItemStack.func_77949_a(nbt.func_74775_l("sheetType"));
/* 34 */     this.data = nbt.func_74771_c("data");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 40 */     super.func_145841_b(nbt);
/* 41 */     nbt.func_74774_a("data", this.data);
/* 42 */     NBTTagCompound st = new NBTTagCompound();
/* 43 */     if (this.sheetStack != null) {
/*    */       
/* 45 */       this.sheetStack.func_77955_b(st);
/* 46 */       nbt.func_74782_a("sheetType", (NBTBase)st);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 52 */     this.data = nbt.func_74771_c("data");
/* 53 */     this.sheetStack = new ItemStack(TFCBlocks.metalTrapDoor, 1, nbt.func_74762_e("metalID"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleDataPacket(NBTTagCompound nbt) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void createDataNBT(NBTTagCompound nbt) {}
/*    */ 
/*    */   
/*    */   public void createInitNBT(NBTTagCompound nbt) {
/* 66 */     nbt.func_74774_a("data", this.data);
/* 67 */     nbt.func_74768_a("metalID", (this.sheetStack != null) ? this.sheetStack.func_77960_j() : 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEMetalTrapDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */