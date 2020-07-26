/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ public class TEFarmland
/*     */   extends NetworkTileEntity
/*     */ {
/*  17 */   public long nutrientTimer = -1L;
/*  18 */   public int[] nutrients = new int[] {
/*  19 */       getSoilMax(), getSoilMax(), getSoilMax(), 0
/*     */     };
/*     */ 
/*     */   
/*     */   public boolean isInfested;
/*     */   
/*     */   public long timeSinceUpdate;
/*     */ 
/*     */   
/*     */   public TEFarmland() {
/*  29 */     this.shouldSendInitData = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  35 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/*  37 */       if (this.nutrientTimer <= 0L) {
/*  38 */         this.nutrientTimer = TFC_Time.getTotalHours();
/*     */       }
/*  40 */       if (this.nutrientTimer < TFC_Time.getTotalHours()) {
/*     */         
/*  42 */         CropIndex crop = null;
/*  43 */         int soilMax = getSoilMax();
/*  44 */         int restoreAmount = 139;
/*     */         
/*  46 */         if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e) == TFCBlocks.crops) {
/*     */           
/*  48 */           crop = CropManager.getInstance().getCropFromId(((TECrop)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)).cropId);
/*     */           
/*  50 */           if (crop.cycleType != 0)
/*     */           {
/*  52 */             if (this.nutrients[0] < soilMax) {
/*  53 */               this.nutrients[0] = this.nutrients[0] + restoreAmount + crop.nutrientExtraRestore[0];
/*     */             }
/*     */           }
/*  56 */           if (crop.cycleType != 1)
/*     */           {
/*  58 */             if (this.nutrients[1] < soilMax) {
/*  59 */               this.nutrients[1] = this.nutrients[1] + restoreAmount + crop.nutrientExtraRestore[1];
/*     */             }
/*     */           }
/*  62 */           if (crop.cycleType != 2)
/*     */           {
/*  64 */             if (this.nutrients[2] < soilMax) {
/*  65 */               this.nutrients[2] = this.nutrients[2] + restoreAmount + crop.nutrientExtraRestore[2];
/*     */             }
/*     */           }
/*     */         } else {
/*     */           
/*  70 */           if (this.nutrients[0] < soilMax)
/*  71 */             this.nutrients[0] = this.nutrients[0] + restoreAmount; 
/*  72 */           if (this.nutrients[1] < soilMax)
/*  73 */             this.nutrients[1] = this.nutrients[1] + restoreAmount; 
/*  74 */           if (this.nutrients[2] < soilMax) {
/*  75 */             this.nutrients[2] = this.nutrients[2] + restoreAmount;
/*     */           }
/*     */         } 
/*  78 */         if (this.nutrients[0] > soilMax)
/*  79 */           this.nutrients[0] = soilMax; 
/*  80 */         if (this.nutrients[1] > soilMax)
/*  81 */           this.nutrients[1] = soilMax; 
/*  82 */         if (this.nutrients[2] > soilMax) {
/*  83 */           this.nutrients[2] = soilMax;
/*     */         }
/*  85 */         this.nutrientTimer += 24L;
/*     */         
/*  87 */         if (this.isInfested) {
/*     */           
/*  89 */           float temp = TFC_Climate.getHeightAdjustedTempSpecificDay(this.field_145850_b, TFC_Time.getDayFromTotalHours(this.nutrientTimer), this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  90 */           if (temp > 10.0F && this.field_145850_b.field_73012_v.nextInt(10) == 0) {
/*     */             
/*  92 */             TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  93 */             if (te instanceof TEFarmland)
/*     */             {
/*  95 */               ((TEFarmland)te).infest();
/*     */             }
/*     */           }
/*  98 */           else if (temp <= 10.0F) {
/*     */             
/* 100 */             if (this.field_145850_b.field_73012_v.nextInt(5) == 0) {
/* 101 */               uninfest();
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void infest() {
/* 128 */     this.isInfested = true;
/* 129 */     ChunkData cd = TFC_Core.getCDM(this.field_145850_b).getData(this.field_145851_c >> 4, this.field_145849_e >> 4);
/* 130 */     if (cd != null && cd.cropInfestation == 0) {
/* 131 */       cd.infest();
/*     */     }
/*     */   }
/*     */   
/*     */   public void uninfest() {
/* 136 */     this.isInfested = false;
/* 137 */     ChunkData cd = TFC_Core.getCDM(this.field_145850_b).getData(this.field_145851_c >> 4, this.field_145849_e >> 4);
/* 138 */     if (cd != null && cd.cropInfestation > 0) {
/* 139 */       cd.uninfest();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getSoilMax() {
/* 144 */     float timeMultiplier = TFC_Time.daysInYear / 360.0F;
/* 145 */     return (int)(25000.0F * timeMultiplier);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drainNutrients(int type, float multiplier) {
/* 150 */     float timeMultiplier = 360.0F / TFC_Time.daysInYear;
/* 151 */     this.nutrients[type] = (int)(this.nutrients[type] - 100.0F * multiplier * timeMultiplier);
/*     */     
/* 153 */     if (this.nutrients[type] < 0) {
/* 154 */       this.nutrients[type] = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean fertilize(ItemStack is, boolean isOrganic) {
/* 159 */     this.nutrients[3] = getSoilMax();
/* 160 */     is.field_77994_a--;
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 170 */     super.func_145839_a(nbt);
/* 171 */     this.nutrients = nbt.func_74759_k("nutrients");
/* 172 */     this.nutrientTimer = nbt.func_74763_f("nutrientTimer");
/* 173 */     this.isInfested = nbt.func_74767_n("isInfested");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 182 */     super.func_145841_b(nbt);
/* 183 */     nbt.func_74783_a("nutrients", this.nutrients);
/* 184 */     nbt.func_74772_a("nutrientTimer", this.nutrientTimer);
/* 185 */     nbt.func_74757_a("isInfested", this.isInfested);
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestNutrientData() {
/* 190 */     if (TFC_Time.getTotalTicks() > this.timeSinceUpdate + 1000L) {
/*     */       
/* 192 */       this.timeSinceUpdate = TFC_Time.getTotalTicks();
/* 193 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 194 */       broadcastPacketInRange();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 200 */     this.nutrients = nbt.func_74759_k("nutrients");
/* 201 */     this.isInfested = nbt.func_74767_n("isInfested");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 207 */     if (this.field_145850_b.field_72995_K) {
/* 208 */       this.nutrients = nbt.func_74759_k("nutrients");
/*     */     } else {
/* 210 */       broadcastPacketInRange();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {
/* 216 */     if (!this.field_145850_b.field_72995_K)
/*     */     {
/* 218 */       nbt.func_74783_a("nutrients", this.nutrients);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 224 */     nbt.func_74783_a("nutrients", this.nutrients);
/* 225 */     nbt.func_74757_a("isInfested", this.isInfested);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFarmland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */