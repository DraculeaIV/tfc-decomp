/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidBlock;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemBarrels
/*     */   extends ItemTerraBlock
/*     */   implements IEquipable
/*     */ {
/*     */   private static final int MAX_LIQUID = 10000;
/*     */   
/*     */   public ItemBarrels(Block par1) {
/*  41 */     super(par1);
/*  42 */     func_77656_e(0);
/*  43 */     func_77627_a(true);
/*  44 */     func_77637_a(TFCTabs.TFC_DEVICES);
/*  45 */     this.metaNames = Global.WOOD_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  51 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  57 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/*  63 */     if (is.func_77942_o())
/*  64 */       return 1; 
/*  65 */     return super.getItemStackLimit(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromItemNBT(NBTTagCompound nbt, List<String> arraylist) {
/*  70 */     if (nbt != null) {
/*     */       
/*  72 */       boolean addFluid = false;
/*  73 */       if (nbt.func_74764_b("fluidNBT")) {
/*     */         
/*  75 */         FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("fluidNBT"));
/*  76 */         if (fluid != null) {
/*     */           
/*  78 */           addFluid = true;
/*  79 */           arraylist.add(EnumChatFormatting.BLUE + fluid.getFluid().getLocalizedName(fluid));
/*     */         } 
/*     */       } 
/*     */       
/*  83 */       if (!addFluid && nbt.func_74764_b("Items")) {
/*     */         
/*  85 */         NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/*  86 */         if (nbttaglist != null) {
/*     */           
/*  88 */           int numItems = nbttaglist.func_74745_c();
/*  89 */           boolean showMoreText = false;
/*  90 */           if (numItems > 4 && !TFC_Core.showShiftInformation()) {
/*     */             
/*  92 */             numItems = 3;
/*  93 */             showMoreText = true;
/*     */           } 
/*  95 */           for (int i = 0; i < numItems; i++) {
/*     */             
/*  97 */             NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  98 */             if (nbttagcompound1 != null) {
/*     */               
/* 100 */               ItemStack onlyItem = ItemStack.func_77949_a(nbttagcompound1);
/* 101 */               if (onlyItem != null)
/*     */               {
/* 103 */                 arraylist.add(EnumChatFormatting.GOLD + Integer.toString(onlyItem.field_77994_a) + "x " + onlyItem.func_82833_r());
/*     */               }
/*     */             } 
/*     */           } 
/* 107 */           if (showMoreText)
/*     */           {
/* 109 */             arraylist.add(TFC_Core.translate("gui.Barrel.MoreItems"));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 119 */     ItemTerra.addSizeInformation(is, arraylist);
/* 120 */     readFromItemNBT(is.func_77978_p(), arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 126 */     MovingObjectPosition mop = Helper.getMovingObjectPositionFromPlayer(world, (EntityLivingBase)player, true);
/*     */     
/* 128 */     if (mop == null)
/*     */     {
/* 130 */       return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */     }
/*     */ 
/*     */     
/* 134 */     if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 136 */       int i = mop.field_72311_b;
/* 137 */       int j = mop.field_72312_c;
/* 138 */       int k = mop.field_72309_d;
/*     */       
/* 140 */       if (!player.func_82247_a(i, j, k, mop.field_72310_e, is) || !(world.func_147439_a(i, j, k) instanceof IFluidBlock) || is.func_77942_o())
/*     */       {
/* 142 */         return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */       }
/*     */       
/* 145 */       Fluid fluid = ((IFluidBlock)world.func_147439_a(i, j, k)).getFluid();
/* 146 */       int temp = fluid.getTemperature();
/* 147 */       int volume = 0;
/* 148 */       if (temp < 550 && fluid != TFCFluids.HOTWATER) {
/*     */         
/* 150 */         world.func_147468_f(i, j, k);
/*     */         
/* 152 */         if (fluid == TFCFluids.FRESHWATER || fluid == TFCFluids.SALTWATER) {
/*     */           
/* 154 */           volume = 10000;
/*     */         }
/*     */         else {
/*     */           
/* 158 */           volume = 1000;
/*     */         } 
/*     */         
/* 161 */         if (is.field_77994_a == 1) {
/*     */           
/* 163 */           fillItemBarrel(is, new FluidStack(fluid, volume), 10000);
/*     */         }
/*     */         else {
/*     */           
/* 167 */           is.field_77994_a--;
/* 168 */           ItemStack outIS = is.func_77946_l();
/* 169 */           outIS.field_77994_a = 1;
/* 170 */           fillItemBarrel(outIS, new FluidStack(fluid, volume), 10000);
/* 171 */           if (!player.field_71071_by.func_70441_a(outIS))
/*     */           {
/* 173 */             player.func_70099_a(outIS, 0.0F);
/*     */           }
/*     */         } 
/*     */       } 
/* 177 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 181 */     return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
/* 188 */     if (!world.func_147465_d(x, y, z, this.field_150939_a, metadata & 0xF, 3))
/*     */     {
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     if (world.func_147439_a(x, y, z) == this.field_150939_a) {
/*     */       
/* 195 */       this.field_150939_a.func_149689_a(world, x, y, z, (EntityLivingBase)player, stack);
/* 196 */       this.field_150939_a.func_149714_e(world, x, y, z, 0);
/*     */       
/* 198 */       TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/* 199 */       te.barrelType = metadata;
/*     */     } 
/*     */     
/* 202 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 208 */     for (int i = 0; i < this.metaNames.length; i++) {
/* 209 */       list.add(new ItemStack((Item)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEquipable.EquipType getEquipType(ItemStack is) {
/* 216 */     return IEquipable.EquipType.BACK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEquippedRender() {
/* 222 */     GL11.glTranslatef(0.0F, -0.3F, -0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTooHeavyToCarry(ItemStack is) {
/* 228 */     return (is.func_77942_o() && is.func_77978_p().func_74764_b("Sealed"));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack fillItemBarrel(ItemStack is, FluidStack fs, int maxFluid) {
/* 233 */     NBTTagCompound nbt = new NBTTagCompound();
/* 234 */     if (is.func_77942_o())
/*     */     {
/* 236 */       nbt = is.func_77978_p();
/*     */     }
/*     */     
/* 239 */     if (nbt.func_74764_b("Sealed")) {
/* 240 */       return is;
/*     */     }
/*     */     
/* 243 */     if (nbt.func_74764_b("fluidNBT")) {
/*     */       
/* 245 */       FluidStack ifs = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("fluidNBT"));
/* 246 */       if (ifs.isFluidEqual(fs) && ifs.amount < maxFluid) {
/*     */         
/* 248 */         ifs.amount += fs.amount;
/* 249 */         ifs.amount %= maxFluid;
/* 250 */         ifs.amount = Math.min(ifs.amount, maxFluid);
/* 251 */         nbt.func_74782_a("fluidNBT", (NBTBase)ifs.writeToNBT(new NBTTagCompound()));
/* 252 */         nbt.func_74757_a("Sealed", true);
/* 253 */         nbt.func_74768_a("SealTime", (int)TFC_Time.getTotalHours());
/*     */       } else {
/* 255 */         return is;
/*     */       } 
/*     */     } else {
/*     */       
/* 259 */       nbt.func_74782_a("fluidNBT", (NBTBase)fs.writeToNBT(new NBTTagCompound()));
/* 260 */       nbt.func_74757_a("Sealed", true);
/* 261 */       nbt.func_74768_a("SealTime", (int)TFC_Time.getTotalHours());
/*     */     } 
/*     */     
/* 264 */     is.func_77982_d(nbt);
/* 265 */     return is;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemBarrels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */