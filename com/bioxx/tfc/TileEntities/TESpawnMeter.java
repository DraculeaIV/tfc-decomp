/*    */ package com.bioxx.tfc.TileEntities;
/*    */ 
/*    */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Core.TFC_Time;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TESpawnMeter
/*    */   extends NetworkTileEntity
/*    */ {
/* 15 */   private long timer = TFC_Time.getTotalTicks();
/*    */   
/*    */   private int protection;
/*    */ 
/*    */   
/*    */   public void func_145845_h() {
/* 21 */     if (!this.field_145850_b.field_72995_K)
/*    */     {
/* 23 */       if (this.timer < TFC_Time.getTotalTicks()) {
/*    */         
/* 25 */         this.timer += 1000L;
/* 26 */         if (TFC_Core.getCDM(this.field_145850_b) != null) {
/*    */           
/* 28 */           ChunkData cd = TFC_Core.getCDM(this.field_145850_b).getData(this.field_145851_c >> 4, this.field_145849_e >> 4);
/* 29 */           if (cd != null) {
/*    */             
/* 31 */             this.protection = cd.spawnProtection;
/* 32 */             int meta = 0;
/* 33 */             if (this.protection > 0)
/*    */             {
/*    */               
/* 36 */               meta = (this.protection > 384) ? 8 : (this.protection / 48);
/*    */             }
/*    */             
/* 39 */             if (meta != this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e))
/*    */             {
/* 41 */               this.field_145850_b.func_72921_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, meta, 3);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 52 */     super.func_145839_a(nbt);
/* 53 */     this.protection = nbt.func_74762_e("protectionHours");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound nbt) {
/* 59 */     super.func_145841_b(nbt);
/* 60 */     nbt.func_74768_a("protectionHours", this.protection);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleInitPacket(NBTTagCompound nbt) {
/* 66 */     this.protection = nbt.func_74762_e("protectionHours");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleDataPacket(NBTTagCompound nbt) {
/* 72 */     this.protection = nbt.func_74762_e("protectionHours");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void createDataNBT(NBTTagCompound nbt) {
/* 78 */     nbt.func_74768_a("protectionHours", this.protection);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void createInitNBT(NBTTagCompound nbt) {
/* 84 */     nbt.func_74768_a("protectionHours", this.protection);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TESpawnMeter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */