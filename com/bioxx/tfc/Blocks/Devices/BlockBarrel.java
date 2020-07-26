/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Entities.EntityBarrel;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemBarrels;
/*     */ import com.bioxx.tfc.Items.Tools.ItemCustomBucketMilk;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidContainerItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBarrel
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private String[] woodNames;
/*     */   
/*     */   public BlockBarrel() {
/*  56 */     super(Material.field_151575_d);
/*  57 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*  58 */     func_149676_a(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
/*  59 */     this.woodNames = Global.WOOD_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  65 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:wood/BarrelHoop");
/*  66 */     TFC_Textures.guiSolidStorage = iconRegisterer.func_94245_a("terrafirmacraft:button_barrel_solid");
/*  67 */     TFC_Textures.guiLiquidStorage = iconRegisterer.func_94245_a("terrafirmacraft:button_barrel_liquid");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  74 */     if (side >= 10) {
/*     */       
/*  76 */       side -= 10;
/*  77 */       if (side == 0 || side == 1) {
/*  78 */         return TFC_Textures.invisibleTexture;
/*     */       }
/*  80 */       return this.field_149761_L;
/*     */     } 
/*  82 */     if (meta < 16)
/*  83 */       return TFCBlocks.planks.func_149691_a(side, meta); 
/*  84 */     return TFCBlocks.planks2.func_149691_a(side, meta - 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/*  92 */     if (side == 0 || side == 1) {
/*  93 */       return TFC_Textures.invisibleTexture;
/*     */     }
/*  95 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/* 103 */     for (int i = 0; i < this.woodNames.length; i++) {
/* 104 */       par3List.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 110 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 128 */     return TFCBlocks.barrelRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int x, int y, int z, int meta) {
/* 134 */     if (!world.field_72995_K) {
/*     */       
/* 136 */       TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/* 137 */       if (te != null && te.shouldDropItem && world.func_82736_K().func_82766_b("doTileDrops"))
/*     */       {
/* 139 */         if (te.getSealed()) {
/*     */           
/* 141 */           ItemStack is = new ItemStack(Item.func_150898_a((Block)this), 1, te.barrelType);
/* 142 */           NBTTagCompound nbt = writeBarrelToNBT(te);
/* 143 */           is.func_77982_d(nbt);
/* 144 */           EntityItem ei = new EntityItem(world, x, y, z, is);
/* 145 */           world.func_72838_d((Entity)ei);
/*     */           
/* 147 */           te.fluid = null;
/*     */           
/* 149 */           for (int s = 0; s < te.func_70302_i_(); s++) {
/* 150 */             te.func_70299_a(s, null);
/*     */           }
/*     */         } else {
/*     */           
/* 154 */           ItemStack is = new ItemStack(Item.func_150898_a((Block)this), 1, te.barrelType);
/* 155 */           EntityItem ei = new EntityItem(world, x, y, z, is);
/* 156 */           world.func_72838_d((Entity)ei);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
/* 166 */     func_149723_a(world, x, y, z, explosion);
/* 167 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion exp) {
/* 173 */     if (world.func_147438_o(x, y, z) instanceof TEBarrel) {
/*     */       
/* 175 */       TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/*     */       
/* 177 */       if (this == TFCBlocks.barrel && te != null && te.getGunPowderCount() >= 12 && te.getSealed()) {
/*     */         
/* 179 */         spawnPowderKeg(world, x, y, z, te, true);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 184 */     super.func_149723_a(world, x, y, z, exp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase player, ItemStack is) {
/* 193 */     super.func_149689_a(world, i, j, k, player, is);
/* 194 */     TEBarrel teb = null;
/* 195 */     TileEntity te = world.func_147438_o(i, j, k);
/* 196 */     if (te != null && is.func_77942_o() && te instanceof TEBarrel) {
/*     */       
/* 198 */       teb = (TEBarrel)te;
/* 199 */       teb.readFromItemNBT(is.func_77978_p());
/* 200 */       world.func_147471_g(i, j, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion exp) {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int par1) {
/* 223 */     int j = 0;
/* 224 */     String s = func_149739_a();
/* 225 */     for (int i = 0; i < this.woodNames.length; i++)
/* 226 */       j = (s.substring(s.indexOf('l', s.length())) == ((ItemBarrels)TFCItems.barrel).metaNames[i]) ? i : 0; 
/* 227 */     return new ItemStack(TFCItems.barrel, 1, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 233 */     if (world.func_147438_o(x, y, z) instanceof TEBarrel) {
/*     */       
/* 235 */       TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/*     */       
/* 237 */       if (this == TFCBlocks.barrel && te != null && te.getGunPowderCount() >= 12 && te.getSealed()) {
/*     */         
/* 239 */         boolean fireNearby = false;
/* 240 */         if (world.func_147439_a(x - 1, y, z) instanceof net.minecraft.block.BlockFire)
/* 241 */           fireNearby = true; 
/* 242 */         if (world.func_147439_a(x + 1, y, z) instanceof net.minecraft.block.BlockFire)
/* 243 */           fireNearby = true; 
/* 244 */         if (world.func_147439_a(x, y, z - 1) instanceof net.minecraft.block.BlockFire)
/* 245 */           fireNearby = true; 
/* 246 */         if (world.func_147439_a(x, y, z + 1) instanceof net.minecraft.block.BlockFire) {
/* 247 */           fireNearby = true;
/*     */         }
/* 249 */         if (fireNearby || world.func_72864_z(x, y, z)) {
/*     */           
/* 251 */           spawnPowderKeg(world, x, y, z, te, false);
/* 252 */           world.func_147468_f(x, y, z);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_149642_a(World par1World, int par2, int par3, int par4, ItemStack par5ItemStack) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeBarrelToNBT(TEBarrel te) {
/* 265 */     NBTTagCompound nbt = new NBTTagCompound();
/*     */     
/* 267 */     NBTTagCompound fluidNBT = new NBTTagCompound();
/* 268 */     if (te.fluid != null)
/* 269 */       te.fluid.writeToNBT(fluidNBT); 
/* 270 */     nbt.func_74782_a("fluidNBT", (NBTBase)fluidNBT);
/* 271 */     nbt.func_74768_a("barrelType", te.barrelType);
/* 272 */     nbt.func_74768_a("SealTime", te.sealtime);
/* 273 */     nbt.func_74757_a("Sealed", te.getSealed());
/*     */     
/* 275 */     NBTTagList nbttaglist = new NBTTagList();
/* 276 */     for (int i = 0; i < te.storage.length; i++) {
/*     */       
/* 278 */       if (te.storage[i] != null) {
/*     */         
/* 280 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 281 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 282 */         te.storage[i].func_77955_b(nbttagcompound1);
/* 283 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 286 */     if (nbttaglist.func_74745_c() > 0) {
/* 287 */       nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     }
/* 289 */     return nbt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/* 295 */     if (world.field_72995_K) {
/*     */       
/* 297 */       world.func_147471_g(x, y, z);
/* 298 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 303 */     if (player.func_70093_af())
/*     */     {
/* 305 */       return false;
/*     */     }
/*     */     
/* 308 */     if (world.func_147438_o(x, y, z) instanceof TEBarrel) {
/*     */       
/* 310 */       TEBarrel te = (TEBarrel)world.func_147438_o(x, y, z);
/*     */       
/* 312 */       if (this == TFCBlocks.barrel && te.getSealed() && te.getGunPowderCount() >= 12 && player
/* 313 */         .func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemFlintAndSteel) {
/*     */         
/* 315 */         spawnPowderKeg(world, x, y, z, te, false);
/* 316 */         world.func_147468_f(x, y, z);
/* 317 */         return true;
/*     */       } 
/*     */       
/* 320 */       if (!handleInteraction(player, te)) {
/*     */         
/* 322 */         if (te.getFluidLevel() > 0 || te.getInvCount() == 0) {
/* 323 */           player.openGui(TerraFirmaCraft.instance, 35, world, x, y, z);
/*     */         } else {
/* 325 */           player.openGui(TerraFirmaCraft.instance, 36, world, x, y, z);
/* 326 */         }  return true;
/*     */       } 
/* 328 */       return true;
/*     */     } 
/*     */     
/* 331 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean handleInteraction(EntityPlayer player, TEBarrel te) {
/* 336 */     if (!te.getSealed() && te.getInvCount() <= 1 && !(te.func_145831_w()).field_72995_K) {
/*     */       
/* 338 */       ItemStack equippedItem = player.func_71045_bC();
/* 339 */       if (equippedItem == null) {
/* 340 */         return false;
/*     */       }
/* 342 */       if ((FluidContainerRegistry.isFilledContainer(equippedItem) || (equippedItem
/* 343 */         .func_77973_b() instanceof IFluidContainerItem && ((IFluidContainerItem)equippedItem.func_77973_b()).getFluid(equippedItem) != null)) && 
/* 344 */         !te.getSealed()) {
/*     */         
/* 346 */         if (equippedItem.func_77942_o())
/*     */         {
/* 348 */           return false;
/*     */         }
/*     */         
/* 351 */         ItemStack tmp = equippedItem.func_77946_l();
/* 352 */         tmp.field_77994_a = 1;
/* 353 */         ItemStack is = te.addLiquid(tmp);
/*     */ 
/*     */         
/* 356 */         if (ItemStack.func_77989_b(equippedItem, is))
/*     */         {
/* 358 */           return false;
/*     */         }
/*     */         
/* 361 */         equippedItem.field_77994_a--;
/*     */         
/* 363 */         if (equippedItem.field_77994_a == 0) {
/* 364 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null);
/*     */         }
/* 366 */         if (equippedItem.field_77994_a == 0 && (is.func_77976_d() == 1 || !player.field_71071_by.func_70431_c(is))) {
/* 367 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, is);
/*     */         
/*     */         }
/* 370 */         else if (!player.field_71071_by.func_70441_a(is)) {
/* 371 */           player.func_71019_a(is, false);
/*     */         } 
/*     */         
/* 374 */         if (player.field_71069_bz != null)
/*     */         {
/*     */           
/* 377 */           player.field_71069_bz.func_75142_b();
/*     */         }
/*     */         
/* 380 */         return true;
/*     */       } 
/* 382 */       if (FluidContainerRegistry.isEmptyContainer(equippedItem) || equippedItem.func_77973_b() instanceof IFluidContainerItem) {
/*     */         
/* 384 */         if (equippedItem.func_77942_o())
/*     */         {
/* 386 */           return false;
/*     */         }
/*     */         
/* 389 */         ItemStack tmp = equippedItem.func_77946_l();
/* 390 */         tmp.field_77994_a = 1;
/* 391 */         ItemStack is = te.removeLiquid(tmp);
/*     */ 
/*     */         
/* 394 */         if (ItemStack.func_77989_b(equippedItem, is))
/*     */         {
/* 396 */           return false;
/*     */         }
/*     */         
/* 399 */         if (is.func_77973_b() == TFCItems.woodenBucketMilk)
/*     */         {
/* 401 */           ItemCustomBucketMilk.createTag(is, 20.0F);
/*     */         }
/*     */         
/* 404 */         equippedItem.field_77994_a--;
/*     */         
/* 406 */         if (equippedItem.field_77994_a == 0) {
/* 407 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null);
/*     */         }
/* 409 */         if (equippedItem.field_77994_a == 0 && (is.func_77976_d() == 1 || !player.field_71071_by.func_70431_c(is))) {
/* 410 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, is);
/*     */         
/*     */         }
/* 413 */         else if (!player.field_71071_by.func_70441_a(is)) {
/* 414 */           player.func_71019_a(is, false);
/*     */         } 
/*     */         
/* 417 */         if (player.field_71069_bz != null)
/*     */         {
/*     */           
/* 420 */           player.field_71069_bz.func_75142_b();
/*     */         }
/*     */         
/* 423 */         return true;
/*     */       } 
/* 425 */       if (equippedItem.func_77973_b() instanceof ItemBarrels || equippedItem.func_77973_b() instanceof com.bioxx.tfc.Items.ItemBlocks.ItemLargeVessel) {
/*     */         
/* 427 */         ItemStack is = equippedItem.func_77946_l();
/* 428 */         is.field_77994_a = 1;
/* 429 */         if (equippedItem.func_77942_o()) {
/*     */           
/* 431 */           if (equippedItem.func_77978_p().func_74764_b("fluidNBT") && !equippedItem.func_77978_p().func_74764_b("Items") && te.getFluidLevel() < te.getMaxLiquid())
/*     */           {
/* 433 */             FluidStack fs = FluidStack.loadFluidStackFromNBT(equippedItem.func_77978_p().func_74775_l("fluidNBT"));
/* 434 */             if (te.addLiquid(fs))
/*     */             {
/* 436 */               if (fs.amount == 0) {
/*     */                 
/* 438 */                 equippedItem.func_77978_p().func_82580_o("Sealed");
/* 439 */                 equippedItem.func_77978_p().func_82580_o("fluidNBT");
/* 440 */                 if (equippedItem.func_77978_p().func_82582_d()) {
/* 441 */                   equippedItem.func_77982_d(null);
/*     */                 }
/*     */               } else {
/*     */                 
/* 445 */                 fs.writeToNBT(equippedItem.func_77978_p().func_74775_l("fluidNBT"));
/*     */               } 
/* 447 */               return true;
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 453 */         else if (te.getFluidStack() != null) {
/*     */           
/* 455 */           NBTTagCompound nbt = new NBTTagCompound();
/* 456 */           if (is.func_77973_b() instanceof ItemBarrels) {
/*     */             
/* 458 */             nbt.func_74782_a("fluidNBT", (NBTBase)te.getFluidStack().writeToNBT(new NBTTagCompound()));
/* 459 */             nbt.func_74757_a("Sealed", true);
/* 460 */             is.func_77982_d(nbt);
/* 461 */             te.actionEmpty();
/* 462 */             equippedItem.field_77994_a--;
/* 463 */             TFC_Core.giveItemToPlayer(is, player);
/*     */           }
/* 465 */           else if (is.func_77973_b() instanceof com.bioxx.tfc.Items.ItemBlocks.ItemLargeVessel) {
/*     */             
/* 467 */             if (is.func_77960_j() == 0) {
/* 468 */               return false;
/*     */             }
/* 470 */             FluidStack fs = te.getFluidStack().copy();
/* 471 */             if (fs.amount > 5000) {
/*     */               
/* 473 */               fs.amount = 5000;
/* 474 */               te.drainLiquid(5000);
/*     */             }
/*     */             else {
/*     */               
/* 478 */               te.actionEmpty();
/*     */             } 
/* 480 */             nbt.func_74782_a("fluidNBT", (NBTBase)fs.writeToNBT(new NBTTagCompound()));
/* 481 */             nbt.func_74757_a("Sealed", true);
/* 482 */             is.func_77982_d(nbt);
/* 483 */             equippedItem.field_77994_a--;
/* 484 */             TFC_Core.giveItemToPlayer(is, player);
/*     */           } 
/* 486 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 491 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 498 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 504 */     return (TileEntity)new TEBarrel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 511 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 518 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/* 527 */     TileEntity te = world.func_147438_o(x, y, z);
/* 528 */     if (te instanceof TEBarrel)
/* 529 */       return ((TEBarrel)te).barrelType; 
/* 530 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 539 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/* 541 */     int damageValue = func_149643_k(world, x, y, z);
/* 542 */     ret.add(new ItemStack((Block)this, 1, damageValue));
/*     */     
/* 544 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnPowderKeg(World world, int x, int y, int z, TEBarrel te, boolean shortFuse) {
/* 549 */     if (TFCOptions.enablePowderKegs) {
/*     */       
/* 551 */       ItemStack is = new ItemStack((Block)this, 1, te.barrelType);
/* 552 */       NBTTagCompound nbt = writeBarrelToNBT(te);
/* 553 */       is.func_77982_d(nbt);
/* 554 */       EntityBarrel entity = new EntityBarrel(world, x, y, z, is, te.getGunPowderCount());
/* 555 */       te.clearInventory();
/* 556 */       te.shouldDropItem = false;
/* 557 */       if (shortFuse) {
/*     */         
/* 559 */         entity.setFuse(1);
/* 560 */         world.func_72838_d((Entity)entity);
/*     */       }
/*     */       else {
/*     */         
/* 564 */         world.func_72838_d((Entity)entity);
/* 565 */         world.func_72956_a((Entity)entity, "game.tnt.primed", 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */