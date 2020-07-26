/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEPottery;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidBlock;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemLargeVessel
/*     */   extends ItemTerraBlock
/*     */   implements IEquipable
/*     */ {
/*     */   private static final int MAX_LIQUID = 5000;
/*     */   
/*     */   public ItemLargeVessel(Block block) {
/*  41 */     super(block);
/*  42 */     func_77656_e(0);
/*  43 */     func_77627_a(true);
/*  44 */     func_77637_a(TFCTabs.TFC_POTTERY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  50 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  56 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/*  62 */     if (is.func_77942_o())
/*  63 */       return 1; 
/*  64 */     return super.getItemStackLimit(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public void createTooltip(NBTTagCompound nbt, List<String> arraylist) {
/*  69 */     if (nbt != null) {
/*     */       
/*  71 */       boolean addFluid = false;
/*  72 */       if (nbt.func_74764_b("fluidNBT")) {
/*     */         
/*  74 */         FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt.func_74775_l("fluidNBT"));
/*  75 */         if (fluid != null) {
/*     */           
/*  77 */           addFluid = true;
/*  78 */           arraylist.add(EnumChatFormatting.BLUE + fluid.getFluid().getLocalizedName(fluid));
/*     */         } 
/*     */       } 
/*     */       
/*  82 */       if (!addFluid && nbt.func_74764_b("Items")) {
/*     */         
/*  84 */         NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/*  85 */         if (nbttaglist != null) {
/*     */           
/*  87 */           int numItems = nbttaglist.func_74745_c();
/*  88 */           boolean showMoreText = false;
/*  89 */           if (numItems > 4 && !TFC_Core.showShiftInformation()) {
/*     */             
/*  91 */             numItems = 3;
/*  92 */             showMoreText = true;
/*     */           } 
/*  94 */           for (int i = 0; i < numItems; i++) {
/*     */             
/*  96 */             NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  97 */             if (nbttagcompound1 != null) {
/*     */               
/*  99 */               ItemStack onlyItem = ItemStack.func_77949_a(nbttagcompound1);
/* 100 */               if (onlyItem != null)
/*     */               {
/* 102 */                 arraylist.add(EnumChatFormatting.GOLD + Integer.toString(onlyItem.field_77994_a) + "x " + onlyItem.func_82833_r());
/*     */               }
/*     */             } 
/*     */           } 
/* 106 */           if (showMoreText)
/*     */           {
/* 108 */             arraylist.add(TFC_Core.translate("gui.Barrel.MoreItems"));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 119 */     ItemTerra.addSizeInformation(is, arraylist);
/* 120 */     createTooltip(is.func_77978_p(), arraylist);
/* 121 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 123 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 124 */       arraylist.add(TFC_Core.translate("gui.PotteryBase.Inst0"));
/*     */     } else {
/*     */       
/* 127 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 133 */     MovingObjectPosition mop = Helper.getMovingObjectPositionFromPlayer(world, (EntityLivingBase)player, true);
/*     */     
/* 135 */     if (mop == null)
/*     */     {
/* 137 */       return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */     }
/*     */ 
/*     */     
/* 141 */     if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 143 */       int i = mop.field_72311_b;
/* 144 */       int j = mop.field_72312_c;
/* 145 */       int k = mop.field_72309_d;
/*     */       
/* 147 */       if (!player.func_82247_a(i, j, k, mop.field_72310_e, is) || !(world.func_147439_a(i, j, k) instanceof IFluidBlock) || is.func_77942_o() || is.func_77960_j() == 0)
/*     */       {
/* 149 */         return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */       }
/*     */       
/* 152 */       Fluid fluid = ((IFluidBlock)world.func_147439_a(i, j, k)).getFluid();
/* 153 */       int temp = fluid.getTemperature();
/* 154 */       int volume = 0;
/*     */       
/* 156 */       if (temp < 550 && fluid != TFCFluids.HOTWATER) {
/*     */         
/* 158 */         world.func_147468_f(i, j, k);
/* 159 */         if (fluid == TFCFluids.FRESHWATER || fluid == TFCFluids.SALTWATER) {
/*     */           
/* 161 */           volume = 5000;
/*     */         }
/*     */         else {
/*     */           
/* 165 */           volume = 1000;
/*     */         } 
/*     */         
/* 168 */         if (is.field_77994_a == 1) {
/*     */           
/* 170 */           ItemBarrels.fillItemBarrel(is, new FluidStack(fluid, volume), 5000);
/*     */         }
/*     */         else {
/*     */           
/* 174 */           is.field_77994_a--;
/* 175 */           ItemStack outIS = is.func_77946_l();
/* 176 */           outIS.field_77994_a = 1;
/* 177 */           ItemBarrels.fillItemBarrel(outIS, new FluidStack(fluid, volume), 5000);
/* 178 */           if (!player.field_71071_by.func_70441_a(outIS))
/*     */           {
/* 180 */             player.func_70099_a(outIS, 0.0F);
/*     */           }
/*     */         } 
/*     */       } 
/* 184 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 188 */     return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
/* 194 */     if (metadata > 0) {
/*     */       
/* 196 */       if (!world.func_147465_d(x, y, z, this.field_150939_a, metadata & 0xF, 3))
/*     */       {
/* 198 */         return false;
/*     */       }
/*     */       
/* 201 */       if (world.func_147439_a(x, y, z) == this.field_150939_a)
/*     */       {
/* 203 */         this.field_150939_a.func_149689_a(world, x, y, z, (EntityLivingBase)player, stack);
/* 204 */         this.field_150939_a.func_149714_e(world, x, y, z, 0);
/*     */         
/* 206 */         TEVessel te = (TEVessel)world.func_147438_o(x, y, z);
/* 207 */         te.barrelType = metadata;
/* 208 */         return true;
/*     */       }
/*     */     
/* 211 */     } else if (metadata == 0 && side == 1 && player.func_70093_af()) {
/*     */       
/* 213 */       Block base = world.func_147439_a(x, y - 1, z);
/* 214 */       if (base != TFCBlocks.pottery && world.func_147437_c(x, y, z)) {
/*     */ 
/*     */         
/* 217 */         if (!world.isSideSolid(x, y - 1, z, ForgeDirection.UP))
/* 218 */           return false; 
/* 219 */         world.func_147449_b(x, y, z, TFCBlocks.pottery);
/*     */       }
/*     */       else {
/*     */         
/* 223 */         return false;
/*     */       } 
/*     */       
/* 226 */       if (world.func_147438_o(x, y, z) instanceof TEPottery) {
/*     */         
/* 228 */         TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 229 */         if (te.canAddItem(0)) {
/*     */           
/* 231 */           te.inventory[0] = stack.func_77946_l();
/* 232 */           (te.inventory[0]).field_77994_a = 1;
/* 233 */           world.func_147471_g(x, y, z);
/* 234 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEquipable.EquipType getEquipType(ItemStack is) {
/* 245 */     return IEquipable.EquipType.BACK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEquippedRender() {
/* 251 */     GL11.glTranslatef(0.0F, 0.0F, -0.2F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTooHeavyToCarry(ItemStack is) {
/* 257 */     return is.func_77942_o();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemLargeVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */