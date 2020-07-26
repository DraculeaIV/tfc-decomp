/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.Recipes;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.IconFlipped;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomDoor
/*     */   extends BlockTerra
/*     */ {
/*     */   private int woodType;
/*  33 */   private String[] woodNames = new String[] { "Oak Door Lower", "Oak Door Upper", "Aspen Door Lower", "Aspen Door Upper", "Birch Door Lower", "Birch Door Upper", "Chestnut Door Lower", "Chestnut Door Upper", "Douglas Fir Door Lower", "Douglas Fir Door Upper", "Hickory Door Lower", "Hickory Door Upper", "Maple Door Lower", "Maple Door Upper", "Ash Door Lower", "Ash Door Upper", "Pine Door Lower", "Pine Door Upper", "Sequoia Door Lower", "Sequoia Door Upper", "Spruce Door Lower", "Spruce Door Upper", "Sycamore Door Lower", "Sycamore Door Upper", "White Cedar Door Lower", "White Cedar Door Upper", "White Elm Door Lower", "White Elm Door Upper", "Willow Door Lower", "Willow Door Upper", "Kapok Door Lower", "Kapok Door Upper", "Acacia Door Lower", "Acacia Door Upper" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private IIcon[] icons = new IIcon[Global.WOOD_ALL.length * 2];
/*     */   
/*     */   public BlockCustomDoor(int woodId) {
/*  44 */     super(Material.field_151575_d);
/*  45 */     func_149711_c(3.0F);
/*     */     
/*  47 */     float var3 = 0.5F;
/*  48 */     float var4 = 1.0F;
/*  49 */     func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
/*  50 */     setWoodType(woodId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  57 */     return this.icons[getWoodType()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/*  64 */     if (par5 != 1 && par5 != 0) {
/*     */       
/*  66 */       int meta = getFullMetadata(par1IBlockAccess, par2, par3, par4);
/*  67 */       int rotation = meta & 0x3;
/*  68 */       boolean flag = ((meta & 0x4) != 0);
/*  69 */       boolean flag1 = false;
/*  70 */       boolean flag2 = ((meta & 0x8) != 0);
/*     */       
/*  72 */       if (flag) {
/*     */         
/*  74 */         if (rotation == 0 && par5 == 2) {
/*  75 */           flag1 = !flag1;
/*  76 */         } else if (rotation == 1 && par5 == 5) {
/*  77 */           flag1 = !flag1;
/*  78 */         } else if (rotation == 2 && par5 == 3) {
/*  79 */           flag1 = !flag1;
/*  80 */         } else if (rotation == 3 && par5 == 4) {
/*  81 */           flag1 = !flag1;
/*     */         } 
/*     */       } else {
/*     */         
/*  85 */         if (rotation == 0 && par5 == 5) {
/*  86 */           flag1 = !flag1;
/*  87 */         } else if (rotation == 1 && par5 == 3) {
/*  88 */           flag1 = !flag1;
/*  89 */         } else if (rotation == 2 && par5 == 4) {
/*  90 */           flag1 = !flag1;
/*  91 */         } else if (rotation == 3 && par5 == 2) {
/*  92 */           flag1 = !flag1;
/*     */         } 
/*  94 */         if ((meta & 0x10) != 0) {
/*  95 */           flag1 = !flag1;
/*     */         }
/*     */       } 
/*  98 */       return this.icons[getWoodType() + (flag1 ? this.woodNames.length : 0) + (flag2 ? 1 : 0)];
/*     */     } 
/*     */ 
/*     */     
/* 102 */     return this.icons[getWoodType()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 109 */     this.icons = new IIcon[this.woodNames.length * 2];
/* 110 */     for (int i = 0; i < this.woodNames.length; i++) {
/*     */       
/* 112 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/doors/" + this.woodNames[i]);
/* 113 */       this.icons[i + this.woodNames.length] = (IIcon)new IconFlipped(this.icons[i], true, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 126 */     int var5 = getFullMetadata(par1IBlockAccess, par2, par3, par4);
/* 127 */     return ((var5 & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 139 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
/* 146 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/* 147 */     return super.func_149633_g(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 153 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/* 154 */     return super.func_149668_a(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 160 */     setDoorRotation(getFullMetadata(par1IBlockAccess, par2, par3, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDoorOrientation(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 168 */     return getFullMetadata(par1IBlockAccess, par2, par3, par4) & 0x3;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDoorOpen(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 173 */     return ((getFullMetadata(par1IBlockAccess, par2, par3, par4) & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setDoorRotation(int par1) {
/* 178 */     float var2 = 0.1875F;
/* 179 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
/* 180 */     int var3 = par1 & 0x3;
/* 181 */     boolean var4 = ((par1 & 0x4) != 0);
/* 182 */     boolean var5 = ((par1 & 0x10) != 0);
/*     */     
/* 184 */     if (var3 == 0) {
/*     */       
/* 186 */       if (var4) {
/*     */         
/* 188 */         if (!var5) {
/* 189 */           func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */         } else {
/* 191 */           func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } else {
/*     */         
/* 195 */         func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */       }
/*     */     
/* 198 */     } else if (var3 == 1) {
/*     */       
/* 200 */       if (var4) {
/*     */         
/* 202 */         if (!var5) {
/* 203 */           func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         } else {
/* 205 */           func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */         } 
/*     */       } else {
/*     */         
/* 209 */         func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */       }
/*     */     
/* 212 */     } else if (var3 == 2) {
/*     */       
/* 214 */       if (var4) {
/*     */         
/* 216 */         if (!var5) {
/* 217 */           func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */         } else {
/* 219 */           func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */         } 
/*     */       } else {
/*     */         
/* 223 */         func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */       }
/*     */     
/* 226 */     } else if (var3 == 3) {
/*     */       
/* 228 */       if (var4) {
/*     */         
/* 230 */         if (!var5) {
/* 231 */           func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */         } else {
/* 233 */           func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } else {
/*     */         
/* 237 */         func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149699_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 248 */     if (this.field_149764_J == Material.field_151573_f)
/*     */     {
/* 250 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 254 */     int var10 = getFullMetadata((IBlockAccess)par1World, par2, par3, par4);
/* 255 */     int var11 = var10 & 0x7;
/* 256 */     var11 ^= 0x4;
/*     */     
/* 258 */     if ((var10 & 0x8) == 0) {
/*     */       
/* 260 */       par1World.func_72921_c(par2, par3, par4, var11, 3);
/* 261 */       par1World.func_147458_c(par2, par3, par4, par2, par3, par4);
/*     */     }
/*     */     else {
/*     */       
/* 265 */       par1World.func_72921_c(par2, par3 - 1, par4, var11, 3);
/* 266 */       par1World.func_147458_c(par2, par3 - 1, par4, par2, par3, par4);
/*     */     } 
/*     */     
/* 269 */     par1World.func_72889_a(par5EntityPlayer, 1003, par2, par3, par4, 0);
/* 270 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5) {
/* 276 */     int var6 = getFullMetadata((IBlockAccess)par1World, par2, par3, par4);
/* 277 */     boolean var7 = ((var6 & 0x4) != 0);
/*     */     
/* 279 */     if (var7 != par5) {
/*     */       
/* 281 */       int var8 = var6 & 0x7;
/* 282 */       var8 ^= 0x4;
/*     */       
/* 284 */       if ((var6 & 0x8) == 0) {
/*     */         
/* 286 */         par1World.func_72921_c(par2, par3, par4, var8, 3);
/* 287 */         par1World.func_147458_c(par2, par3, par4, par2, par3, par4);
/*     */       }
/*     */       else {
/*     */         
/* 291 */         par1World.func_72921_c(par2, par3 - 1, par4, var8, 3);
/* 292 */         par1World.func_147458_c(par2, par3 - 1, par4, par2, par3, par4);
/*     */       } 
/*     */       
/* 295 */       par1World.func_72889_a((EntityPlayer)null, 1003, par2, par3, par4, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World par1World, int par2, int par3, int par4, Block par5) {
/* 306 */     int var6 = par1World.func_72805_g(par2, par3, par4);
/*     */     
/* 308 */     if ((var6 & 0x8) == 0) {
/*     */       
/* 310 */       boolean var7 = false;
/*     */       
/* 312 */       if (par1World.func_147439_a(par2, par3 + 1, par4) != this) {
/*     */         
/* 314 */         par1World.func_147468_f(par2, par3, par4);
/* 315 */         var7 = true;
/*     */       } 
/*     */       
/* 318 */       if (!World.func_147466_a((IBlockAccess)par1World, par2, par3 - 1, par4)) {
/*     */         
/* 320 */         par1World.func_147468_f(par2, par3, par4);
/* 321 */         var7 = true;
/*     */         
/* 323 */         if (par1World.func_147439_a(par2, par3 + 1, par4) == this) {
/* 324 */           par1World.func_147468_f(par2, par3 + 1, par4);
/*     */         }
/*     */       } 
/* 327 */       if (var7) {
/*     */         
/* 329 */         if (!par1World.field_72995_K) {
/* 330 */           func_149697_b(par1World, par2, par3, par4, var6, 0);
/*     */         }
/*     */       } else {
/*     */         
/* 334 */         boolean var8 = (par1World.func_72864_z(par2, par3, par4) || par1World.func_72864_z(par2, par3 + 1, par4));
/* 335 */         if ((var8 || par5.func_149744_f()) && par5 != this) {
/* 336 */           onPoweredBlockChange(par1World, par2, par3, par4, var8);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 341 */       if (par1World.func_147439_a(par2, par3 - 1, par4) != this) {
/* 342 */         par1World.func_147468_f(par2, par3, par4);
/*     */       }
/* 344 */       if (par5 != this) {
/* 345 */         func_149695_a(par1World, par2, par3 - 1, par4, par5);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
/* 356 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/* 357 */     return super.func_149731_a(par1World, par2, par3, par4, par5Vec3, par6Vec3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
/* 366 */     return (par3 >= 255) ? false : ((World.func_147466_a((IBlockAccess)par1World, par2, par3 - 1, par4) && super.func_149742_c(par1World, par2, par3, par4) && super.func_149742_c(par1World, par2, par3 + 1, par4)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 376 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 384 */     int var7, var8, var5 = par1IBlockAccess.func_72805_g(par2, par3, par4);
/* 385 */     boolean var6 = ((var5 & 0x8) != 0);
/*     */ 
/*     */ 
/*     */     
/* 389 */     if (var6) {
/*     */       
/* 391 */       var7 = par1IBlockAccess.func_72805_g(par2, par3 - 1, par4);
/* 392 */       var8 = var5;
/*     */     }
/*     */     else {
/*     */       
/* 396 */       var7 = var5;
/* 397 */       var8 = par1IBlockAccess.func_72805_g(par2, par3 + 1, par4);
/*     */     } 
/*     */     
/* 400 */     boolean var9 = ((var8 & 0x1) != 0);
/* 401 */     return var7 & 0x7 | (var6 ? 8 : 0) | (var9 ? 16 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World par1World, int par2, int par3, int par4) {
/* 408 */     return (this.field_149764_J == Material.field_151573_f) ? Items.field_151139_aw : Items.field_151135_aq;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 415 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 422 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/* 431 */     return getWoodType() / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 440 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */ 
/*     */     
/* 443 */     if ((metadata & 0x8) == 0) {
/*     */ 
/*     */ 
/*     */       
/* 447 */       Block block = world.func_147439_a(x, y + 1, z);
/* 448 */       if (block != null && (block instanceof BlockCustomDoor || block == Blocks.field_150350_a))
/*     */       {
/*     */ 
/*     */         
/* 452 */         int damageValue = func_149643_k(world, x, y, z);
/* 453 */         ret.add(new ItemStack(Recipes.doors[damageValue], 1, 0));
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 460 */       Block block = world.func_147439_a(x, y - 1, z);
/* 461 */       if (block instanceof BlockCustomDoor) {
/*     */ 
/*     */ 
/*     */         
/* 465 */         int damageValue = func_149643_k(world, x, y, z);
/* 466 */         ret.add(new ItemStack(Recipes.doors[damageValue], 1, 0));
/*     */       } 
/*     */     } 
/*     */     
/* 470 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 476 */     int damageValue = func_149643_k(world, x, y, z);
/* 477 */     return new ItemStack(Recipes.doors[damageValue], 1, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWoodType() {
/* 482 */     return this.woodType;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setWoodType(int woodType) {
/* 487 */     this.woodType = woodType;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */