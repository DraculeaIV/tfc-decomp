/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class TELeatherRack
/*    */   extends NetworkTileEntity
/*    */ {
/*    */   public short workedArea;
/*    */   public ItemStack leatherItem;
/*    */   
/*    */   public void setLeather(ItemStack is) {
/* 15 */     this.leatherItem = is.func_77946_l();
/* 16 */     this.leatherItem.field_77994_a = 1;
/* 17 */     is.field_77994_a--;
/*    */   }
/*    */ 
/*    */   
/*    */   public void workArea(int coord) {
/* 22 */     this.workedArea = (short)(this.workedArea | 1 << coord);
/* 23 */     if (this.workedArea == -1 && this.leatherItem != null) {
/*    */       
/* 25 */       int meta = this.leatherItem.func_77960_j();
/* 26 */       this.leatherItem = new ItemStack(TFCItems.scrapedHide, 1, meta);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 33 */     super.func_145841_b(nbt);
/* 34 */     NBTTagCompound item = new NBTTagCompound();
/* 35 */     if (this.leatherItem != null) {
/*    */       
/* 37 */       this.leatherItem.func_77955_b(item);
/* 38 */       nbt.func_74782_a("leatherItem", (NBTBase)item);
/*    */     } 
/* 40 */     nbt.func_74777_a("workedArea", this.workedArea);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 46 */     super.func_145839_a(nbt);
/* 47 */     if (nbt.func_74764_b("leatherItem"))
/* 48 */       this.leatherItem = ItemStack.func_77949_a((NBTTagCompound)nbt.func_74781_a("leatherItem")); 
/* 49 */     this.workedArea = nbt.func_74765_d("workedArea");
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 54 */     if (nbt.func_74764_b("leatherItem"))
/* 55 */       this.leatherItem = ItemStack.func_77949_a((NBTTagCompound)nbt.func_74781_a("leatherItem")); 
/* 56 */     this.workedArea = nbt.func_74765_d("workedArea");
/*    */   }
/*    */ 
/*    */   
/*    */   public void createInitNBT(NBTTagCompound nbt) {
/* 61 */     NBTTagCompound item = new NBTTagCompound();
/* 62 */     if (this.leatherItem != null) {
/*    */       
/* 64 */       this.leatherItem.func_77955_b(item);
/* 65 */       nbt.func_74782_a("leatherItem", (NBTBase)item);
/*    */     } 
/* 67 */     nbt.func_74777_a("workedArea", this.workedArea);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handleDataPacket(NBTTagCompound nbt) {
/* 72 */     this.workedArea = nbt.func_74765_d("workedArea");
/* 73 */     this.field_145850_b.func_147479_m(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TELeatherRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */