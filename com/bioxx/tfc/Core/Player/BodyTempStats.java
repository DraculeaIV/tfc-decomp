/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.Interfaces.IClothing;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BodyTempStats
/*     */ {
/*     */   private int temperatureLevel;
/*     */   private int prevTemperatureLevel;
/*     */   private int extraFoodConsumed;
/*     */   private int extraWaterConsumed;
/*     */   private int heatStorage;
/*     */   private long tempTimer;
/*  27 */   private Random rand = new Random();
/*     */   private ItemStack itemHead;
/*     */   private ItemStack itemChest;
/*     */   
/*     */   public void onUpdate(EntityPlayer player) {
/*  32 */     if (TFC_Time.getTotalTicks() - this.tempTimer >= 20L) {
/*     */       
/*  34 */       this.tempTimer += 20L;
/*  35 */       if (this.heatStorage > this.temperatureLevel) {
/*  36 */         this.heatStorage--;
/*     */       }
/*  38 */       if (!player.field_71075_bZ.field_75098_d)
/*  39 */         applyTemperature(player); 
/*     */     } 
/*     */   }
/*     */   private ItemStack itemLegs; private ItemStack itemFeet;
/*     */   
/*     */   private void applyTemperature(EntityPlayer player) {
/*  45 */     FoodStatsTFC food = TFC_Core.getPlayerFoodStats(player);
/*     */ 
/*     */     
/*  48 */     this.prevTemperatureLevel = this.temperatureLevel;
/*  49 */     if (this.rand.nextInt(2000 - getBaseBodyTempMod(player)) < 100 && food.stomachLevel >= 500.0F)
/*  50 */       this.temperatureLevel++; 
/*  51 */     if ((player.func_70051_ag() || player.field_70733_aJ != 0.0F) && this.rand.nextInt(1000 - getBaseBodyTempMod(player) / 2) < 100) {
/*  52 */       this.temperatureLevel++;
/*     */     }
/*     */ 
/*     */     
/*  56 */     this.temperatureLevel += applyTemperatureFromEnvironment(player);
/*     */ 
/*     */     
/*  59 */     this.heatStorage = Math.max(Math.min(this.temperatureLevel + this.heatStorage, 14), 0);
/*     */     
/*  61 */     this.extraFoodConsumed = 0;
/*  62 */     this.extraWaterConsumed = 0;
/*     */     
/*  64 */     if (this.temperatureLevel != this.prevTemperatureLevel && (this.prevTemperatureLevel < -10 || this.prevTemperatureLevel > 10 || this.temperatureLevel < -10 || this.temperatureLevel > 10))
/*     */     {
/*     */ 
/*     */       
/*  68 */       tellPlayerMessage(player);
/*     */     }
/*  70 */     this.prevTemperatureLevel = this.temperatureLevel;
/*  71 */     if (this.temperatureLevel >= -10 && this.temperatureLevel <= 10) {
/*     */       
/*  73 */       this.extraFoodConsumed = 0;
/*  74 */       this.extraWaterConsumed = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int applyTemperatureFromEnvironment(EntityPlayer player) {
/*  80 */     int x = (int)player.field_70165_t;
/*  81 */     int y = (int)player.field_70163_u;
/*  82 */     int z = (int)player.field_70161_v;
/*  83 */     float temperature = TFC_Climate.getHeightAdjustedTemp(player.field_70170_p, x, y, z);
/*  84 */     temperature += applyTemperatureFromHeatSources(player);
/*     */ 
/*     */     
/*  87 */     if (temperature <= 10.0F) {
/*     */       
/*  89 */       int modifier = (int)((temperature - 10.0F) * 15.0F);
/*  90 */       if (this.rand.nextInt(1200 + modifier) < 10) {
/*  91 */         return -1;
/*     */       }
/*     */     }
/*  94 */     else if (temperature >= 30.0F) {
/*     */       
/*  96 */       int modifier = Math.min(1199, (int)((temperature - 30.0F) * 15.0F));
/*  97 */       if (this.rand.nextInt(1200 - modifier) < 10) {
/*  98 */         return 1;
/*     */       }
/* 100 */     } else if (temperature < 20.0F) {
/*     */       
/* 102 */       if (this.temperatureLevel <= -1) {
/*     */         
/* 104 */         if (this.rand.nextInt(1200 - Math.min(1199, (int)(temperature - 10.0F) * 15)) < 100) {
/* 105 */           return 1;
/*     */         }
/* 107 */       } else if (temperature >= 1.0F) {
/*     */         
/* 109 */         if (this.rand.nextInt(1200 - Math.min(1199, (int)(temperature - 10.0F) * 15)) < 100) {
/* 110 */           return -1;
/*     */         }
/*     */       } 
/* 113 */     } else if (temperature > 20.0F) {
/*     */       
/* 115 */       if (this.temperatureLevel <= 1) {
/*     */         
/* 117 */         if (this.rand.nextInt(1200 - Math.min(1199, (int)(temperature - 20.0F) * 10)) < 100) {
/* 118 */           return 1;
/*     */         }
/* 120 */       } else if (temperature > 1.0F) {
/*     */         
/* 122 */         if (this.rand.nextInt(1200 - Math.min(1199, (int)(temperature - 20.0F) * 10)) < 100)
/* 123 */           return -1; 
/*     */       } 
/*     */     } 
/* 126 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float applyTemperatureFromHeatSources(EntityPlayer player) {
/* 131 */     int x = (int)player.field_70165_t;
/* 132 */     int y = (int)player.field_70163_u;
/* 133 */     int z = (int)player.field_70161_v;
/* 134 */     float temperatureMod = 0.0F;
/*     */     
/* 136 */     for (int i = x - 7; i < x + 7; i++) {
/*     */       
/* 138 */       for (int j = y - 3; j < y + 3; j++) {
/*     */         
/* 140 */         for (int k = z - 7; k < z + 7; k++) {
/*     */           
/* 142 */           if (player.field_70170_p.func_72899_e(i, j, k)) {
/*     */             
/* 144 */             TileEntity te = player.field_70170_p.func_147438_o(i, j, k);
/* 145 */             if (player.field_70170_p.func_147439_a(i, j, k) == Blocks.field_150353_l || player.field_70170_p.func_147439_a(i, j, k) == TFCBlocks.lava || te instanceof TEFireEntity) {
/*     */ 
/*     */ 
/*     */               
/* 149 */               double tempValue = 950.0D;
/*     */ 
/*     */               
/* 152 */               if (te instanceof TEFireEntity) {
/* 153 */                 tempValue = ((TEFireEntity)te).fireTemp;
/*     */               }
/*     */               
/* 156 */               double distanceSq = player.func_70092_e(i, j, k) + 0.05D;
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 161 */               tempValue *= 0.05D / distanceSq;
/* 162 */               temperatureMod = (float)(temperatureMod + tempValue);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 168 */     return temperatureMod;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBaseBodyTempMod(EntityPlayer player) {
/* 173 */     this.itemHead = player.field_71071_by.func_70440_f(3);
/* 174 */     this.itemChest = player.field_71071_by.func_70440_f(2);
/* 175 */     this.itemLegs = player.field_71071_by.func_70440_f(1);
/* 176 */     this.itemFeet = player.field_71071_by.func_70440_f(0);
/* 177 */     int returnAmount = 0;
/* 178 */     if (this.itemHead != null && this.itemHead.func_77973_b() instanceof IClothing)
/* 179 */       returnAmount += ((IClothing)this.itemHead.func_77973_b()).getThermal(); 
/* 180 */     if (this.itemChest != null && this.itemChest.func_77973_b() instanceof IClothing)
/* 181 */       returnAmount += ((IClothing)this.itemChest.func_77973_b()).getThermal(); 
/* 182 */     if (this.itemLegs != null && this.itemLegs.func_77973_b() instanceof IClothing)
/* 183 */       returnAmount += ((IClothing)this.itemLegs.func_77973_b()).getThermal(); 
/* 184 */     if (this.itemFeet != null && this.itemFeet.func_77973_b() instanceof IClothing)
/* 185 */       returnAmount += ((IClothing)this.itemFeet.func_77973_b()).getThermal(); 
/* 186 */     return returnAmount;
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
/*     */   private void tellPlayerMessage(EntityPlayer player) {}
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
/*     */   public void readNBT(NBTTagCompound nbt) {
/* 214 */     if (nbt.func_74764_b("tempCompound")) {
/*     */       
/* 216 */       NBTTagCompound tempCompound = nbt.func_74775_l("tempCompound");
/* 217 */       this.temperatureLevel = tempCompound.func_74762_e("tempLev");
/* 218 */       this.extraWaterConsumed = tempCompound.func_74762_e("waterExtra");
/* 219 */       this.extraFoodConsumed = tempCompound.func_74762_e("foodExtra");
/* 220 */       this.heatStorage = tempCompound.func_74762_e("heatStorage");
/* 221 */       this.tempTimer = tempCompound.func_74763_f("tempTimer");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeNBT(NBTTagCompound nbt) {
/* 230 */     NBTTagCompound tempCompound = new NBTTagCompound();
/* 231 */     tempCompound.func_74768_a("tempLev", this.temperatureLevel);
/* 232 */     tempCompound.func_74768_a("waterExtra", this.extraWaterConsumed);
/* 233 */     tempCompound.func_74768_a("foodExtra", this.extraFoodConsumed);
/* 234 */     tempCompound.func_74768_a("heatStorage", this.heatStorage);
/* 235 */     tempCompound.func_74772_a("tempTimer", this.tempTimer);
/* 236 */     nbt.func_74782_a("tempCompound", (NBTBase)tempCompound);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getExtraFood() {
/* 241 */     return this.extraFoodConsumed;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getExtraWater() {
/* 246 */     return this.extraWaterConsumed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\BodyTempStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */