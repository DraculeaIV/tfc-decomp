/*     */ package com.bioxx.tfc.api.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.NetworkTileEntity;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class TEFireEntity
/*     */   extends NetworkTileEntity
/*     */ {
/*     */   public int airFromBellows;
/*     */   public float fireTemp;
/*  15 */   public int maxFireTempScale = 2000;
/*     */ 
/*     */   
/*     */   public int fuelTimeLeft;
/*     */   
/*     */   public int fuelBurnTemp;
/*     */   
/*     */   public int fuelTasteProfile;
/*     */   
/*     */   public static final int AIRTOADD = 200;
/*     */ 
/*     */   
/*     */   public void careForInventorySlot(ItemStack is) {
/*  28 */     if (is != null) {
/*     */       
/*  30 */       HeatRegistry manager = HeatRegistry.getInstance();
/*  31 */       HeatIndex index = manager.findMatchingIndex(is);
/*     */       
/*  33 */       if (index != null && index.hasOutput()) {
/*     */         
/*  35 */         float temp = TFC_ItemHeat.getTemp(is);
/*  36 */         if (this.fireTemp > temp) {
/*     */           
/*  38 */           temp += TFC_ItemHeat.getTempIncrease(is);
/*     */         } else {
/*     */           
/*  41 */           temp -= TFC_ItemHeat.getTempDecrease(is);
/*  42 */         }  TFC_ItemHeat.setTemp(is, temp);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void receiveAirFromBellows() {
/*  49 */     if (this.airFromBellows < 600)
/*  50 */       this.airFromBellows += 200; 
/*  51 */     if (this.airFromBellows > 600) {
/*  52 */       this.airFromBellows = 600;
/*     */     }
/*     */   }
/*     */   
/*     */   public void keepTempToRange() {
/*  57 */     if (this.fireTemp > getMaxTemp()) {
/*  58 */       this.fireTemp = getMaxTemp();
/*  59 */     } else if (this.fireTemp < 0.0F) {
/*  60 */       this.fireTemp = 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getMaxTemp() {
/*  65 */     return this.fuelBurnTemp + this.airFromBellows;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTemperatureScaled(int s) {
/*  70 */     return (int)(this.fireTemp * s / this.maxFireTempScale);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float handleTemp() {
/*  75 */     if (this.fuelTimeLeft > 0) {
/*     */       
/*  77 */       this.fuelTimeLeft--;
/*  78 */       if (this.airFromBellows > 0) {
/*  79 */         this.fuelTimeLeft--;
/*     */       }
/*  81 */     } else if (this.fuelTimeLeft < 0) {
/*  82 */       this.fuelTimeLeft = 0;
/*     */     } 
/*  84 */     if (this.fuelTimeLeft > 0) {
/*  85 */       return (this.fuelBurnTemp + this.airFromBellows);
/*     */     }
/*  87 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleAirReduction() {
/*  92 */     if (this.airFromBellows > 0) {
/*  93 */       this.airFromBellows--;
/*     */     }
/*     */   }
/*     */   
/*     */   public void handleTempFlux(float desiredTemp) {
/*  98 */     if (this.fireTemp < desiredTemp) {
/*     */       
/* 100 */       if (this.airFromBellows == 0) {
/* 101 */         this.fireTemp++;
/*     */       } else {
/* 103 */         this.fireTemp += 2.0F;
/*     */       } 
/* 105 */     } else if (this.fireTemp > desiredTemp) {
/*     */       
/* 107 */       if (desiredTemp == 0.0F)
/*     */       {
/* 109 */         if (this.airFromBellows == 0) {
/* 110 */           this.fireTemp--;
/*     */         } else {
/* 112 */           this.fireTemp = (float)(this.fireTemp - 0.5D);
/*     */         }  } 
/*     */     } 
/* 115 */     keepTempToRange();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 121 */     super.func_145841_b(nbt);
/* 122 */     nbt.func_74776_a("temperature", this.fireTemp);
/* 123 */     nbt.func_74768_a("fuelTime", this.fuelTimeLeft);
/* 124 */     nbt.func_74768_a("fuelTemp", this.fuelBurnTemp);
/* 125 */     nbt.func_74768_a("bellowsAir", this.airFromBellows);
/* 126 */     nbt.func_74768_a("fuelTasteProfile", this.fuelTasteProfile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 132 */     super.func_145839_a(nbt);
/* 133 */     this.fireTemp = nbt.func_74760_g("temperature");
/* 134 */     this.fuelTimeLeft = nbt.func_74762_e("fuelTime");
/* 135 */     this.fuelBurnTemp = nbt.func_74762_e("fuelTemp");
/* 136 */     this.airFromBellows = nbt.func_74762_e("airBellows");
/* 137 */     this.fuelTasteProfile = nbt.func_74762_e("fuelTasteProfile");
/*     */   }
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {}
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {}
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {}
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\TileEntities\TEFireEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */