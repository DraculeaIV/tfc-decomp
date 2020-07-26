/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TELightEmitter;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockTorch
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   protected IIcon offIcon;
/*     */   
/*     */   public BlockTorch() {
/*  41 */     super(Material.field_151594_q);
/*  42 */     func_149675_a(true);
/*  43 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  44 */     func_149715_a(0.9375F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/*  50 */     int meta = world.func_72805_g(x, y, z);
/*  51 */     if (meta >= 8)
/*  52 */       return 0; 
/*  53 */     return func_149750_m();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  60 */     if (meta >= 8)
/*  61 */       return this.offIcon; 
/*  62 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/*  69 */     super.func_149651_a(register);
/*  70 */     this.offIcon = register.func_94245_a("terrafirmacraft:torch_off");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/*  76 */     if (!world.field_72995_K) {
/*     */       
/*  78 */       int meta = world.func_72805_g(x, y, z);
/*  79 */       ItemStack is = player.field_71071_by.func_70448_g();
/*  80 */       Item item = (is != null) ? is.func_77973_b() : null;
/*     */ 
/*     */       
/*  83 */       if (meta < 8 && item == TFCItems.stick)
/*     */       {
/*  85 */         player.field_71071_by.func_146026_a(TFCItems.stick);
/*  86 */         TFC_Core.giveItemToPlayer(new ItemStack(TFCBlocks.torch), player);
/*     */       
/*     */       }
/*  89 */       else if (item == Item.func_150898_a(TFCBlocks.torch))
/*     */       {
/*  91 */         TELightEmitter te = (TELightEmitter)world.func_147438_o(x, y, z);
/*  92 */         te.hourPlaced = (int)TFC_Time.getTotalHours();
/*  93 */         if (meta >= 8)
/*     */         {
/*  95 */           world.func_72921_c(x, y, z, meta - 8, 3);
/*     */         
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 101 */         world.func_147465_d(x, y, z, TFCBlocks.torchOff, meta, 3);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 106 */     else if (TFCOptions.enableDebugMode) {
/*     */       
/* 108 */       int metadata = world.func_72805_g(x, y, z);
/* 109 */       TerraFirmaCraft.LOG.info("Meta = " + func_149739_a() + ":" + metadata);
/*     */     } 
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 118 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */ 
/*     */     
/* 121 */     if (metadata >= 8) {
/* 122 */       return ret;
/*     */     }
/* 124 */     Item item = func_149650_a(metadata, world.field_73012_v, fortune);
/* 125 */     if (item != null)
/*     */     {
/* 127 */       ret.add(new ItemStack(item, 1, func_149692_a(metadata)));
/*     */     }
/* 129 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 135 */     return (TileEntity)new TELightEmitter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 173 */     return TFCBlocks.torchRenderId;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canSupportTorch(World world, int x, int y, int z) {
/* 178 */     if (World.func_147466_a((IBlockAccess)world, x, y, z))
/*     */     {
/* 180 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 184 */     Block block = world.func_147439_a(x, y, z);
/* 185 */     return block.canPlaceTorchOnTop(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 195 */     return (world.isSideSolid(x - 1, y, z, ForgeDirection.EAST, true) || world
/* 196 */       .isSideSolid(x + 1, y, z, ForgeDirection.WEST, true) || world
/* 197 */       .isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, true) || world
/* 198 */       .isSideSolid(x, y, z + 1, ForgeDirection.NORTH, true) || 
/* 199 */       canSupportTorch(world, x, y - 1, z));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
/* 208 */     int j1 = meta;
/*     */     
/* 210 */     if (side == 1 && canSupportTorch(world, x, y - 1, z))
/*     */     {
/* 212 */       j1 = 5;
/*     */     }
/*     */     
/* 215 */     if (side == 2 && world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH, true))
/*     */     {
/* 217 */       j1 = 4;
/*     */     }
/*     */     
/* 220 */     if (side == 3 && world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, true))
/*     */     {
/* 222 */       j1 = 3;
/*     */     }
/*     */     
/* 225 */     if (side == 4 && world.isSideSolid(x + 1, y, z, ForgeDirection.WEST, true))
/*     */     {
/* 227 */       j1 = 2;
/*     */     }
/*     */     
/* 230 */     if (side == 5 && world.isSideSolid(x - 1, y, z, ForgeDirection.EAST, true))
/*     */     {
/* 232 */       j1 = 1;
/*     */     }
/*     */     
/* 235 */     return j1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 244 */     super.func_149674_a(world, x, y, z, rand);
/* 245 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 247 */     if (meta == 0)
/*     */     {
/* 249 */       func_149726_b(world, x, y, z);
/*     */     }
/* 251 */     if (!world.field_72995_K)
/*     */     {
/* 253 */       if (TFCOptions.torchBurnTime != 0 && world.func_147438_o(x, y, z) instanceof TELightEmitter) {
/*     */         
/* 255 */         TELightEmitter te = (TELightEmitter)world.func_147438_o(x, y, z);
/* 256 */         if (TFC_Time.getTotalHours() > (te.hourPlaced + TFCOptions.torchBurnTime) || 
/* 257 */           TFC_Core.isExposedToRain(world, x, y, z))
/*     */         {
/* 259 */           world.func_147465_d(x, y, z, TFCBlocks.torchOff, meta, 3);
/*     */         }
/*     */       }
/* 262 */       else if (meta >= 8) {
/*     */         
/* 264 */         world.func_147465_d(x, y, z, TFCBlocks.torchOff, meta - 8, 3);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/* 275 */     if (world.func_72805_g(x, y, z) == 0)
/*     */     {
/* 277 */       if (world.isSideSolid(x - 1, y, z, ForgeDirection.EAST, true)) {
/*     */         
/* 279 */         world.func_72921_c(x, y, z, 1, 3);
/*     */       }
/* 281 */       else if (world.isSideSolid(x + 1, y, z, ForgeDirection.WEST, true)) {
/*     */         
/* 283 */         world.func_72921_c(x, y, z, 2, 3);
/*     */       }
/* 285 */       else if (world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, true)) {
/*     */         
/* 287 */         world.func_72921_c(x, y, z, 3, 3);
/*     */       }
/* 289 */       else if (world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH, true)) {
/*     */         
/* 291 */         world.func_72921_c(x, y, z, 4, 3);
/*     */       }
/* 293 */       else if (canSupportTorch(world, x, y - 1, z)) {
/*     */         
/* 295 */         world.func_72921_c(x, y, z, 5, 3);
/*     */       } 
/*     */     }
/*     */     
/* 299 */     ((TELightEmitter)world.func_147438_o(x, y, z)).create();
/*     */     
/* 301 */     tryPlace(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 311 */     checkValidity(world, x, y, z, b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
/* 317 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean checkValidity(World world, int x, int y, int z, Block b) {
/* 322 */     if (tryPlace(world, x, y, z)) {
/*     */       
/* 324 */       int l = world.func_72805_g(x, y, z);
/* 325 */       boolean flag = false;
/*     */       
/* 327 */       if (!world.isSideSolid(x - 1, y, z, ForgeDirection.EAST, true) && l == 1)
/*     */       {
/* 329 */         flag = true;
/*     */       }
/*     */       
/* 332 */       if (!world.isSideSolid(x + 1, y, z, ForgeDirection.WEST, true) && l == 2)
/*     */       {
/* 334 */         flag = true;
/*     */       }
/*     */       
/* 337 */       if (!world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, true) && l == 3)
/*     */       {
/* 339 */         flag = true;
/*     */       }
/*     */       
/* 342 */       if (!world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH, true) && l == 4)
/*     */       {
/* 344 */         flag = true;
/*     */       }
/*     */       
/* 347 */       if (!canSupportTorch(world, x, y - 1, z) && l == 5)
/*     */       {
/* 349 */         flag = true;
/*     */       }
/*     */       
/* 352 */       if (flag) {
/*     */         
/* 354 */         func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 355 */         world.func_147468_f(x, y, z);
/* 356 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 360 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 365 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean tryPlace(World world, int x, int y, int z) {
/* 371 */     if (!func_149742_c(world, x, y, z)) {
/*     */       
/* 373 */       if (world.func_147439_a(x, y, z) == this) {
/*     */         
/* 375 */         func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 376 */         world.func_147468_f(x, y, z);
/*     */       } 
/*     */       
/* 379 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 383 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 startVec, Vec3 endVec) {
/* 394 */     int l = world.func_72805_g(x, y, z) & 0x7;
/* 395 */     float f = 0.15F;
/*     */     
/* 397 */     if (l == 1) {
/*     */       
/* 399 */       func_149676_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
/*     */     }
/* 401 */     else if (l == 2) {
/*     */       
/* 403 */       func_149676_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
/*     */     }
/* 405 */     else if (l == 3) {
/*     */       
/* 407 */       func_149676_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
/*     */     }
/* 409 */     else if (l == 4) {
/*     */       
/* 411 */       func_149676_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/* 415 */       f = 0.1F;
/* 416 */       func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
/*     */     } 
/*     */     
/* 419 */     return super.func_149731_a(world, x, y, z, startVec, endVec);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World world, int x, int y, int z, Random rand) {
/* 429 */     int meta = world.func_72805_g(x, y, z);
/* 430 */     if (meta >= 8) {
/*     */       return;
/*     */     }
/*     */     
/* 434 */     double centerX = (x + 0.5F);
/* 435 */     double centerY = (y + 0.7F);
/* 436 */     double centerZ = (z + 0.5F);
/* 437 */     double d3 = 0.22D;
/* 438 */     double d4 = 0.27D;
/*     */     
/* 440 */     if ((meta & 0x7) == 1) {
/*     */       
/* 442 */       world.func_72869_a("smoke", centerX - d4, centerY + d3, centerZ, 0.0D, 0.0D, 0.0D);
/* 443 */       world.func_72869_a("flame", centerX - d4, centerY + d3, centerZ, 0.0D, 0.0D, 0.0D);
/*     */     }
/* 445 */     else if ((meta & 0x7) == 2) {
/*     */       
/* 447 */       world.func_72869_a("smoke", centerX + d4, centerY + d3, centerZ, 0.0D, 0.0D, 0.0D);
/* 448 */       world.func_72869_a("flame", centerX + d4, centerY + d3, centerZ, 0.0D, 0.0D, 0.0D);
/*     */     }
/* 450 */     else if ((meta & 0x7) == 3) {
/*     */       
/* 452 */       world.func_72869_a("smoke", centerX, centerY + d3, centerZ - d4, 0.0D, 0.0D, 0.0D);
/* 453 */       world.func_72869_a("flame", centerX, centerY + d3, centerZ - d4, 0.0D, 0.0D, 0.0D);
/*     */     }
/* 455 */     else if ((meta & 0x7) == 4) {
/*     */       
/* 457 */       world.func_72869_a("smoke", centerX, centerY + d3, centerZ + d4, 0.0D, 0.0D, 0.0D);
/* 458 */       world.func_72869_a("flame", centerX, centerY + d3, centerZ + d4, 0.0D, 0.0D, 0.0D);
/*     */     }
/*     */     else {
/*     */       
/* 462 */       world.func_72869_a("smoke", centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);
/* 463 */       world.func_72869_a("flame", centerX, centerY, centerZ, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */