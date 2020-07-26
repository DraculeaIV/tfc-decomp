/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraftforge.fluids.FluidStack;
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
/*     */ public class TEOilLamp
/*     */   extends TELightEmitter
/*     */ {
/*     */   private FluidStack fuel;
/*     */   
/*     */   public FluidStack getFuel() {
/*  27 */     if (this.fuel == null)
/*  28 */       return null; 
/*  29 */     FluidStack f = this.fuel.copy();
/*  30 */     f.amount /= TFCOptions.oilLampFuelMult;
/*  31 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateLampFuel(Boolean burn) {
/*  40 */     if ((int)TFC_Time.getTotalHours() - TFCOptions.oilLampFuelMult >= this.hourPlaced) {
/*     */       
/*  42 */       int diff = burn.booleanValue() ? ((int)TFC_Time.getTotalHours() - this.hourPlaced) : 0;
/*  43 */       this.hourPlaced = (int)TFC_Time.getTotalHours();
/*     */       
/*  45 */       if (this.fuel != null && getFuel().getFluid() != TFCFluids.LAVA && getFuelAmount() > 0) {
/*     */         
/*  47 */         this.fuel.amount -= diff;
/*  48 */         if (this.fuel.amount <= 0) {
/*  49 */           this.fuel = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFuelFromStack(FluidStack fs) {
/*  56 */     this.fuel = fs;
/*  57 */     this.fuel.amount *= TFCOptions.oilLampFuelMult;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFuelValid() {
/*  62 */     int meta = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*  63 */     if (getFuel() != null && getFuel().getFluid() == TFCFluids.OLIVEOIL)
/*     */     {
/*  65 */       return true;
/*     */     }
/*  67 */     if ((meta & 0x7) == 5 && getFuel() != null && getFuel().getFluid() == TFCFluids.LAVA)
/*     */     {
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/*  83 */     super.func_145839_a(nbt);
/*  84 */     if (nbt.func_74764_b("Fuel")) {
/*  85 */       this.fuel = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("Fuel"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/*  91 */     super.func_145841_b(nbt);
/*  92 */     if (this.fuel != null) {
/*  93 */       nbt.func_74782_a("Fuel", (NBTBase)this.fuel.writeToNBT(new NBTTagCompound()));
/*     */     }
/*     */   }
/*     */   
/*     */   public int getFuelAmount() {
/*  98 */     if (this.fuel == null)
/*  99 */       return 0; 
/* 100 */     return this.fuel.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFuelTimeLeft() {
/* 105 */     int f = getFuelAmount();
/* 106 */     float perc = f / 250.0F;
/* 107 */     return (int)((TFC_Time.daysInYear * 24) * perc);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEOilLamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */