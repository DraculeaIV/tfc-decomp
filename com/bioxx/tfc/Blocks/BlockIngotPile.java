/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEIngotPile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockIngotPile
/*     */   extends BlockTerraContainer
/*     */ {
/*  31 */   private Random random = new Random();
/*     */ 
/*     */   
/*     */   public BlockIngotPile() {
/*  35 */     super(Material.field_151573_f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  46 */     if (world.field_72995_K) {
/*     */       
/*  48 */       world.func_147438_o(x, y, z).func_145829_t();
/*  49 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  53 */     if ((TEIngotPile)world.func_147438_o(x, y, z) != null) {
/*     */ 
/*     */       
/*  56 */       TEIngotPile tileentityingotpile = (TEIngotPile)world.func_147438_o(x, y, z);
/*     */       
/*  58 */       if (tileentityingotpile.func_70301_a(0) == null) {
/*     */         
/*  60 */         world.func_147468_f(x, y, z);
/*  61 */         return false;
/*     */       } 
/*     */       
/*  64 */       if (!entityplayer.func_70093_af() && tileentityingotpile.func_70301_a(0) != null) {
/*     */         
/*  66 */         if ((tileentityingotpile.func_70301_a(0)).field_77994_a > 0) {
/*  67 */           tileentityingotpile.injectContents(0, -1);
/*     */         }
/*  69 */         world.func_72838_d((Entity)new EntityItem(world, tileentityingotpile.field_145851_c, (tileentityingotpile.field_145848_d + 1), tileentityingotpile.field_145849_e, new ItemStack(tileentityingotpile
/*  70 */                 .func_70301_a(0).func_77973_b(), 1, tileentityingotpile.func_70301_a(0).func_77960_j())));
/*  71 */         world.func_147460_e(x, y + 1, z, (Block)this);
/*     */         
/*  73 */         if ((tileentityingotpile.func_70301_a(0)).field_77994_a < 1) {
/*  74 */           world.func_147468_f(x, y, z);
/*     */         }
/*  76 */         world.func_147471_g(x, y, z);
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void combineIngotsDown(World world, int x, int y, int z) {
/*  86 */     TEIngotPile teip = (TEIngotPile)world.func_147438_o(x, y, z);
/*  87 */     TEIngotPile teipBottom = (TEIngotPile)world.func_147438_o(x, y - 1, z);
/*     */     
/*  89 */     int bottomSize = (teipBottom.func_70301_a(0)).field_77994_a;
/*  90 */     int topSize = (teip.func_70301_a(0)).field_77994_a;
/*     */     
/*  92 */     if (bottomSize < 64) {
/*     */       
/*  94 */       bottomSize += topSize;
/*  95 */       int m2 = 0;
/*  96 */       if (bottomSize > 64) {
/*     */         
/*  98 */         m2 = bottomSize - 64;
/*  99 */         bottomSize = 64;
/*     */       } 
/* 101 */       teipBottom.storage[0] = new ItemStack(teipBottom.storage[0].func_77973_b(), bottomSize, teipBottom.storage[0].func_77960_j());
/*     */       
/* 103 */       if (m2 > 0) {
/*     */         
/* 105 */         teip.injectContents(0, m2 - topSize);
/* 106 */         world.func_147460_e(x, y + 1, z, (Block)this);
/* 107 */         world.func_147471_g(teip.field_145851_c, teip.field_145848_d, teip.field_145849_e);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 112 */         teip.storage[0] = null;
/* 113 */         world.func_147468_f(x, y, z);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void combineIngotsUp(World world, int x, int y, int z) {
/* 120 */     TEIngotPile teip = (TEIngotPile)world.func_147438_o(x, y + 1, z);
/* 121 */     TEIngotPile teipBottom = (TEIngotPile)world.func_147438_o(x, y, z);
/*     */     
/* 123 */     int bottomSize = (teipBottom.func_70301_a(0)).field_77994_a;
/* 124 */     int topSize = (teip.func_70301_a(0)).field_77994_a;
/*     */     
/* 126 */     if (bottomSize < 64) {
/*     */       
/* 128 */       bottomSize += topSize;
/* 129 */       int m2 = 0;
/* 130 */       if (bottomSize > 64) {
/*     */         
/* 132 */         m2 = bottomSize - 64;
/* 133 */         bottomSize = 64;
/*     */       } 
/* 135 */       teipBottom.storage[0] = new ItemStack(teipBottom.storage[0].func_77973_b(), bottomSize, teipBottom.storage[0].func_77960_j());
/*     */       
/* 137 */       if (m2 > 0) {
/*     */         
/* 139 */         teip.injectContents(0, m2 - topSize);
/* 140 */         world.func_147460_e(x, y + 2, z, (Block)this);
/* 141 */         world.func_147471_g(teip.field_145851_c, teip.field_145848_d, teip.field_145849_e);
/*     */       }
/*     */       else {
/*     */         
/* 145 */         world.func_147468_f(x, y + 1, z);
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
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 157 */     TEIngotPile te = (TEIngotPile)world.func_147438_o(x, y, z);
/*     */     
/* 159 */     if (te != null && te.func_70301_a(0) != null) {
/* 160 */       return AxisAlignedBB.func_72330_a(x, y + 0.0D, z + 0.0D, x + 1.0D, y + (((te.func_70301_a(0)).field_77994_a + 7) / 8) * 0.125D, z + 1.0D);
/*     */     }
/*     */     
/* 163 */     return AxisAlignedBB.func_72330_a(x, y + 0.0D, z + 0.0D, x + 1.0D, y + 0.25D, z + 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 171 */     TEIngotPile te = (TEIngotPile)world.func_147438_o(x, y, z);
/*     */     
/* 173 */     if (te.func_70301_a(0) != null) {
/* 174 */       return AxisAlignedBB.func_72330_a(x, y + 0.0D, z + 0.0D, x + 1.0D, y + (((te.func_70301_a(0)).field_77994_a + 7) / 8) * 0.125D, z + 1.0D);
/*     */     }
/* 176 */     return AxisAlignedBB.func_72330_a(x, y + 0.0D, z + 0.0D, x + 1.0D, y + 0.25D, z + 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 184 */     TEIngotPile te = (TEIngotPile)bAccess.func_147438_o(x, y, z);
/*     */     
/* 186 */     if (te.func_70301_a(0) != null) {
/* 187 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, (float)((((te.func_70301_a(0)).field_77994_a + 7) / 8) * 0.125D), 1.0F);
/*     */     } else {
/* 189 */       func_149676_a(0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 218 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 231 */     return 22;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStack(World world, TEIngotPile tt) {
/* 236 */     if (world.func_147438_o(tt.field_145851_c, tt.field_145848_d, tt.field_145849_e) instanceof TEIngotPile) {
/*     */       
/* 238 */       TEIngotPile te = (TEIngotPile)world.func_147438_o(tt.field_145851_c, tt.field_145848_d, tt.field_145849_e);
/*     */       
/* 240 */       return (te.func_70301_a(0) != null) ? (te.func_70301_a(0)).field_77994_a : 0;
/*     */     } 
/*     */     
/* 243 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int side) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 254 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack is) {
/* 260 */     super.func_149689_a(world, x, y, z, entityliving, is);
/* 261 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 263 */     int l = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 264 */     byte byte0 = 0;
/* 265 */     if (l == 0)
/* 266 */       byte0 = 8; 
/* 267 */     if (l == 1)
/* 268 */       byte0 = 0; 
/* 269 */     if (l == 2)
/* 270 */       byte0 = 8; 
/* 271 */     if (l == 3) {
/* 272 */       byte0 = 0;
/*     */     }
/* 274 */     byte0 = (byte)(byte0 + meta);
/* 275 */     world.func_72921_c(x, y, z, byte0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block b, int meta) {
/* 281 */     TEIngotPile te = (TEIngotPile)world.func_147438_o(x, y, z);
/* 282 */     if (te != null) {
/*     */       
/* 284 */       for (int var6 = 0; var6 < te.func_70302_i_(); var6++) {
/*     */         
/* 286 */         ItemStack var7 = te.func_70301_a(var6);
/*     */         
/* 288 */         if (var7 != null) {
/*     */           
/* 290 */           float var8 = this.random.nextFloat() * 0.8F + 0.1F;
/* 291 */           float var9 = this.random.nextFloat() * 0.8F + 0.1F;
/*     */ 
/*     */           
/* 294 */           for (float var10 = this.random.nextFloat() * 0.8F + 0.1F; var7.field_77994_a > 0; world.func_72838_d((Entity)var12)) {
/*     */             
/* 296 */             int var11 = this.random.nextInt(21) + 10;
/*     */             
/* 298 */             if (var11 > var7.field_77994_a) {
/* 299 */               var11 = var7.field_77994_a;
/*     */             }
/* 301 */             var7.field_77994_a -= var11;
/* 302 */             EntityItem var12 = new EntityItem(world, (x + var8), (y + var9), (z + var10), new ItemStack(var7.func_77973_b(), var11, var7.func_77960_j()));
/* 303 */             float var13 = 0.05F;
/* 304 */             var12.field_70159_w = ((float)this.random.nextGaussian() * var13);
/* 305 */             var12.field_70181_x = ((float)this.random.nextGaussian() * var13 + 0.2F);
/* 306 */             var12.field_70179_y = ((float)this.random.nextGaussian() * var13);
/*     */             
/* 308 */             if (var7.func_77942_o())
/* 309 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b()); 
/*     */           } 
/*     */         } 
/*     */       } 
/* 313 */       super.func_149749_a(world, x, y, z, b, meta);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 320 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/* 326 */     if (!world.field_72995_K) {
/*     */       
/* 328 */       TEIngotPile te = (TEIngotPile)world.func_147438_o(i, j, k);
/* 329 */       if (te != null && te.func_70301_a(0) != null) {
/*     */         
/* 331 */         EntityItem ei = new EntityItem(world, i, j, k, te.func_70301_a(0));
/* 332 */         world.func_72838_d((Entity)ei);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 340 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getAnvilTypeFromMeta(int j) {
/* 345 */     int l = 7;
/* 346 */     return j & l;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDirectionFromMetadata(int i) {
/* 351 */     int d = i >> 3;
/*     */     
/* 353 */     if (d == 1) {
/* 354 */       return 1;
/*     */     }
/* 356 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 362 */     return (TileEntity)new TEIngotPile();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 368 */     if (!world.field_72995_K)
/*     */     {
/* 370 */       if (!world.isSideSolid(x, y - 1, z, ForgeDirection.UP) && world.func_147438_o(x, y, z) instanceof TEIngotPile) {
/*     */         
/* 372 */         TEIngotPile ingotPile = (TEIngotPile)world.func_147438_o(x, y, z);
/* 373 */         Item ingot = (ingotPile.storage[0] != null) ? ingotPile.storage[0].func_77973_b() : null;
/*     */         
/* 375 */         if (world.func_147439_a(x, y - 1, z) == this && world.func_147438_o(x, y - 1, z) instanceof TEIngotPile) {
/*     */           
/* 377 */           TEIngotPile lowerPile = (TEIngotPile)world.func_147438_o(x, y - 1, z);
/* 378 */           Item lowerIngot = (lowerPile.storage[0] != null) ? lowerPile.storage[0].func_77973_b() : null;
/*     */           
/* 380 */           if (ingot == lowerIngot) {
/* 381 */             combineIngotsDown(world, x, y, z);
/*     */           }
/* 383 */         } else if (world.func_147439_a(x, y + 1, z) == this && world.func_147438_o(x, y + 1, z) instanceof TEIngotPile) {
/*     */           
/* 385 */           TEIngotPile upperPile = (TEIngotPile)world.func_147438_o(x, y + 1, z);
/* 386 */           Item upperIngot = (upperPile.storage[0] != null) ? upperPile.storage[0].func_77973_b() : null;
/*     */           
/* 388 */           if (ingot == upperIngot) {
/* 389 */             combineIngotsUp(world, x, y, z);
/*     */           }
/*     */         } else {
/*     */           
/* 393 */           ingotPile.ejectContents();
/* 394 */           world.func_147468_f(x, y, z);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 404 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockIngotPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */