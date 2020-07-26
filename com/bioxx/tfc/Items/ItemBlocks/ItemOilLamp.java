/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidContainerItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemOilLamp
/*     */   extends ItemTerraBlock
/*     */   implements ISmeltable, IFluidContainerItem
/*     */ {
/*     */   public ItemOilLamp(Block par1) {
/*  30 */     super(par1);
/*  31 */     this.metaNames = new String[] { "Gold", "Platinum", "RoseGold", "Silver", "SterlingSilver", "BlueSteel" };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDisplayDamage(ItemStack is) {
/*  37 */     FluidStack fuel = FluidStack.loadFluidStackFromNBT(is.func_77978_p());
/*  38 */     int amt = (fuel != null) ? fuel.amount : 0;
/*  39 */     return getMaxDamage(is) - amt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDamaged(ItemStack is) {
/*  45 */     return is.func_77942_o();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/*  51 */     return 250;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  56 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  61 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/*  67 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMetalReturnAmount(ItemStack is) {
/*  73 */     return 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSmeltable(ItemStack is) {
/*  78 */     FluidStack fuel = FluidStack.loadFluidStackFromNBT(is.func_77978_p());
/*  79 */     return (fuel == null || fuel.amount == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISmeltable.EnumTier getSmeltTier(ItemStack is) {
/*  85 */     return ISmeltable.EnumTier.TierI;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Metal getMetalType(ItemStack is) {
/*  91 */     int meta = is.func_77960_j();
/*  92 */     switch (meta) {
/*     */       case 0:
/*  94 */         return Global.GOLD;
/*  95 */       case 1: return Global.PLATINUM;
/*  96 */       case 2: return Global.ROSEGOLD;
/*  97 */       case 3: return Global.SILVER;
/*  98 */       case 4: return Global.STERLINGSILVER;
/*  99 */       case 5: return Global.BLUESTEEL;
/* 100 */     }  return Global.UNKNOWN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 107 */     MovingObjectPosition mop = func_77621_a(world, player, !is.func_77942_o());
/* 108 */     if (mop != null && is.func_77960_j() == 5 && world.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d) == TFCBlocks.lavaStationary) {
/*     */       
/* 110 */       if (!is.func_77942_o()) {
/*     */         
/* 112 */         FluidStack fs = new FluidStack(TFCFluids.LAVA, 250);
/* 113 */         is.func_77982_d(fs.writeToNBT(new NBTTagCompound()));
/*     */       } 
/* 115 */       return false;
/*     */     } 
/*     */     
/* 118 */     int yCoord = y;
/* 119 */     if (side == 0) {
/* 120 */       yCoord--;
/* 121 */     } else if (side == 1) {
/* 122 */       yCoord++;
/*     */     } else {
/* 124 */       return false;
/*     */     } 
/* 126 */     int xCoord = x;
/* 127 */     int zCoord = z;
/*     */     
/* 129 */     if (world.func_147437_c(xCoord, yCoord, zCoord))
/*     */     {
/* 131 */       return super.func_77648_a(is, player, world, xCoord, yCoord, zCoord, side, hitX, hitY, hitZ);
/*     */     }
/*     */     
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
/* 140 */     FluidStack fs = FluidStack.loadFluidStackFromNBT(stack.func_77978_p());
/* 141 */     if (fs == null || (fs.getFluid() != TFCFluids.OLIVEOIL && fs.getFluid() != TFCFluids.LAVA))
/*     */     {
/* 143 */       metadata += 8;
/*     */     }
/*     */     
/* 146 */     return super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 152 */     super.func_77624_a(is, player, arraylist, flag);
/* 153 */     if (is.func_77942_o()) {
/*     */       
/* 155 */       FluidStack fs = FluidStack.loadFluidStackFromNBT(is.func_77978_p());
/* 156 */       if (fs != null && fs.getFluid() == TFCFluids.OLIVEOIL)
/* 157 */         arraylist.add((fs.amount * TFCOptions.oilLampFuelMult) + " " + TFC_Core.translate("gui.hoursRemaining") + " (" + Helper.roundNumber(fs.amount / 250.0F * 100.0F, 10.0F) + "%)"); 
/* 158 */       if (fs != null && fs.getFluid() == TFCFluids.LAVA) {
/* 159 */         arraylist.add(TFC_Core.translate("gui.infinite") + " " + TFC_Core.translate("gui.hoursRemaining"));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static ItemStack getFullLamp(int meta) {
/* 165 */     ItemStack is = new ItemStack(TFCBlocks.oilLamp, 1, meta);
/* 166 */     FluidStack fs = new FluidStack(TFCFluids.OLIVEOIL, 250);
/* 167 */     is.func_77982_d(fs.writeToNBT(new NBTTagCompound()));
/* 168 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack getFluid(ItemStack container) {
/* 174 */     return FluidStack.loadFluidStackFromNBT(container.func_77978_p());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCapacity(ItemStack container) {
/* 180 */     return 250;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int fill(ItemStack container, FluidStack resource, boolean doSim) {
/* 186 */     FluidStack fs = getFluid(container);
/* 187 */     int inAmt = 0;
/* 188 */     if (fs != null) {
/*     */       
/* 190 */       int max = getCapacity(container) - fs.amount;
/* 191 */       if (max > 0 && fs.isFluidEqual(resource)) {
/*     */         
/* 193 */         inAmt = Math.min(max, resource.amount);
/* 194 */         if (doSim)
/*     */         {
/* 196 */           fs.amount += inAmt;
/* 197 */           if (container.func_77978_p() == null)
/* 198 */             container.func_77982_d(new NBTTagCompound()); 
/* 199 */           fs.writeToNBT(container.func_77978_p());
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 205 */       inAmt = Math.min(getCapacity(container), resource.amount);
/* 206 */       if (doSim) {
/*     */         
/* 208 */         fs = resource.copy();
/* 209 */         fs.amount = inAmt;
/* 210 */         if (container.func_77978_p() == null)
/* 211 */           container.func_77982_d(new NBTTagCompound()); 
/* 212 */         fs.writeToNBT(container.func_77978_p());
/*     */       } 
/*     */     } 
/* 215 */     return inAmt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(ItemStack container, int maxDrain, boolean doSim) {
/* 221 */     FluidStack fs = getFluid(container);
/* 222 */     FluidStack fsOut = fs.copy();
/* 223 */     fsOut.amount = Math.min(maxDrain, fs.amount);
/*     */     
/* 225 */     if (doSim)
/*     */     {
/* 227 */       if (fs.amount - fsOut.amount <= 0) {
/*     */         
/* 229 */         container.field_77990_d = null;
/*     */       }
/*     */       else {
/*     */         
/* 233 */         fs.amount -= fsOut.amount;
/* 234 */         if (container.func_77978_p() == null)
/* 235 */           container.func_77982_d(new NBTTagCompound()); 
/* 236 */         fs.writeToNBT(container.func_77978_p());
/*     */       } 
/*     */     }
/* 239 */     return fsOut;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemOilLamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */