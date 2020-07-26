/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemOilLamp;
/*     */ import com.bioxx.tfc.TileEntities.TEOilLamp;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockOilLamp
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon[] icons;
/*     */   
/*     */   public BlockOilLamp() {
/*  45 */     super(Material.field_151594_q);
/*  46 */     func_149675_a(true);
/*  47 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  48 */     func_149715_a(1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/*  54 */     int meta = world.func_72805_g(x, y, z);
/*  55 */     if (meta >= 8)
/*  56 */       return 0; 
/*  57 */     return func_149750_m();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  64 */     for (int i = 0; i < 6; i++)
/*     */     {
/*  66 */       list.add(ItemOilLamp.getFullLamp(i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  74 */     int m = meta & 0x7;
/*  75 */     if (side == 0 || side == 1) {
/*     */       
/*  77 */       if (m == 0)
/*  78 */         return TFC_Textures.sheetGold; 
/*  79 */       if (m == 1)
/*  80 */         return TFC_Textures.sheetPlatinum; 
/*  81 */       if (m == 2)
/*  82 */         return TFC_Textures.sheetRoseGold; 
/*  83 */       if (m == 3)
/*  84 */         return TFC_Textures.sheetSilver; 
/*  85 */       if (m == 4)
/*  86 */         return TFC_Textures.sheetSterlingSilver; 
/*  87 */       if (m == 5)
/*  88 */         return TFC_Textures.sheetBlueSteel; 
/*  89 */       return TFC_Textures.sheetGold;
/*     */     } 
/*  91 */     return this.icons[m];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int i, int j, int k, int side) {
/*  98 */     return func_149691_a(side, access.func_72805_g(i, j, k));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 105 */     this.icons = new IIcon[6];
/* 106 */     this.icons[0] = registerer.func_94245_a("terrafirmacraft:metal/GoldLamp");
/* 107 */     this.icons[1] = registerer.func_94245_a("terrafirmacraft:metal/PlatinumLamp");
/* 108 */     this.icons[2] = registerer.func_94245_a("terrafirmacraft:metal/RoseGoldLamp");
/* 109 */     this.icons[3] = registerer.func_94245_a("terrafirmacraft:metal/SilverLamp");
/* 110 */     this.icons[4] = registerer.func_94245_a("terrafirmacraft:metal/SterlingSilverLamp");
/* 111 */     this.icons[5] = registerer.func_94245_a("terrafirmacraft:metal/BlueSteelLamp");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/* 117 */     if (!world.field_72995_K) {
/*     */       
/* 119 */       int meta = world.func_72805_g(x, y, z);
/* 120 */       if (!isLampLit(meta)) {
/*     */         
/* 122 */         TEOilLamp te = (TEOilLamp)world.func_147438_o(x, y, z);
/* 123 */         if (te != null) {
/*     */           
/* 125 */           te.updateLampFuel(Boolean.valueOf(false));
/* 126 */           if (te.isFuelValid() && 
/* 127 */             te.getFuelTimeLeft() > 0) {
/* 128 */             world.func_72921_c(x, y, z, meta - 8, 3);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/* 133 */         TEOilLamp te = (TEOilLamp)world.func_147438_o(x, y, z);
/* 134 */         if (te != null)
/*     */         {
/* 136 */           te.updateLampFuel(Boolean.valueOf(true));
/*     */         }
/* 138 */         world.func_72921_c(x, y, z, meta + 8, 3);
/*     */       } 
/*     */     } 
/* 141 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isLampLit(int meta) {
/* 146 */     return ((meta & 0x8) <= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 152 */     return new ArrayList<ItemStack>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 158 */     return (TileEntity)new TEOilLamp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 168 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 196 */     return TFCBlocks.oilLampRenderId;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canSupportTorch(World world, int x, int y, int z) {
/* 201 */     if (World.func_147466_a((IBlockAccess)world, x, y, z))
/*     */     {
/* 203 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 207 */     Block block = world.func_147439_a(x, y, z);
/* 208 */     return block.canPlaceTorchOnTop(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 218 */     return canSupportTorch(world, x, y - 1, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 227 */     super.func_149674_a(world, x, y, z, rand);
/* 228 */     int meta = world.func_72805_g(x, y, z);
/* 229 */     if (meta < 8) {
/*     */       
/* 231 */       TEOilLamp te = (TEOilLamp)world.func_147438_o(x, y, z);
/* 232 */       if (te != null) {
/*     */         
/* 234 */         te.updateLampFuel(Boolean.valueOf(true));
/* 235 */         if (te.getFuelTimeLeft() == 0) {
/* 236 */           world.func_72921_c(x, y, z, meta + 8, 3);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 244 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/* 253 */     tryPlace(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
/* 259 */     TileEntity te = world.func_147438_o(x, y, z);
/* 260 */     if (te instanceof TEOilLamp) {
/*     */       
/* 262 */       ((TEOilLamp)te).create();
/* 263 */       FluidStack fs = FluidStack.loadFluidStackFromNBT(is.func_77978_p());
/* 264 */       if (fs != null)
/*     */       {
/* 266 */         ((TEOilLamp)te).setFuelFromStack(fs);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 272 */       ((TEOilLamp)te).hourPlaced = (int)TFC_Time.getTotalHours();
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
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 284 */     if (!World.func_147466_a((IBlockAccess)world, x, y - 1, z)) {
/* 285 */       TFC_Core.setBlockToAirWithDrops(world, x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
/* 291 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean tryPlace(World world, int x, int y, int z) {
/* 296 */     if (!func_149742_c(world, x, y, z)) {
/*     */       
/* 298 */       if (world.func_147439_a(x, y, z) == this)
/*     */       {
/*     */         
/* 301 */         world.func_147468_f(x, y, z);
/*     */       }
/*     */       
/* 304 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 308 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int x, int y, int z, int meta) {
/* 315 */     if (!world.field_72995_K) {
/*     */       
/* 317 */       TEOilLamp te = (TEOilLamp)world.func_147438_o(x, y, z);
/* 318 */       if ((meta & 0x8) != 0)
/* 319 */         meta -= 8; 
/* 320 */       if (te != null)
/*     */       {
/* 322 */         if (te.getFuel() != null) {
/*     */           
/* 324 */           ItemStack is = new ItemStack((Block)this, 1, meta);
/* 325 */           NBTTagCompound nbt = te.getFuel().writeToNBT(new NBTTagCompound());
/* 326 */           is.func_77982_d(nbt);
/* 327 */           EntityItem ei = new EntityItem(world, x, y, z, is);
/* 328 */           world.func_72838_d((Entity)ei);
/*     */         }
/*     */         else {
/*     */           
/* 332 */           ItemStack is = new ItemStack((Block)this, 1, meta);
/* 333 */           EntityItem ei = new EntityItem(world, x, y, z, is);
/* 334 */           world.func_72838_d((Entity)ei);
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
/*     */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec) {
/* 347 */     func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
/* 348 */     return super.func_149731_a(world, x, y, z, startVec, endVec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World world, int x, int y, int z, Random rand) {
/* 358 */     int meta = world.func_72805_g(x, y, z);
/* 359 */     if (meta >= 8) {
/*     */       return;
/*     */     }
/*     */     
/* 363 */     double centerX = (x + 0.5F);
/* 364 */     double centerY = (y + 0.6F);
/* 365 */     double centerZ = (z + 0.5F);
/*     */ 
/*     */ 
/*     */     
/* 369 */     world.func_72869_a("smoke", centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);
/* 370 */     world.func_72869_a("flame", centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockOilLamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */