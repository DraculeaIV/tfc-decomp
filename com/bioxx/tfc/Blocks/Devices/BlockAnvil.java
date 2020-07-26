/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilReq;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
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
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockAnvil
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon[] textureMapTop;
/*     */   private IIcon[] textureMapSide;
/*     */   private IIcon stoneAnvilIcon;
/*     */   private int anvilId;
/*     */   
/*     */   public BlockAnvil() {
/*  45 */     super(Material.field_151573_f);
/*  46 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockAnvil(int offset) {
/*  51 */     this();
/*  52 */     this.anvilId = offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  60 */     if (this == TFCBlocks.anvil)
/*     */     {
/*  62 */       for (int i = 1; i < 8; i++) {
/*  63 */         par3List.add(new ItemStack((Block)this, 1, i));
/*     */       }
/*     */     }
/*  66 */     if (this == TFCBlocks.anvil2)
/*     */     {
/*  68 */       for (int i = 0; i < 3; i++) {
/*  69 */         par3List.add(new ItemStack((Block)this, 1, i));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  76 */     return dmg & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  82 */     if (world.field_72995_K)
/*     */     {
/*  84 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  88 */     if ((TEAnvil)world.func_147438_o(i, j, k) != null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  93 */       entityplayer.openGui(TerraFirmaCraft.instance, 21, world, i, j, k);
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/* 102 */     int meta = par1World.func_72805_g(par2, par3, par4);
/* 103 */     int direction = getDirectionFromMetadata(meta);
/* 104 */     TileEntity te = par1World.func_147438_o(par2, par3, par4);
/*     */     
/* 106 */     if (te instanceof TEAnvil) {
/*     */       
/* 108 */       TEAnvil teAnvil = (TEAnvil)te;
/* 109 */       if (teAnvil.anvilTier != AnvilReq.STONE.Tier || this == TFCBlocks.anvil2) {
/*     */         
/* 111 */         if (direction == 0) {
/* 112 */           return AxisAlignedBB.func_72330_a(par2 + 0.2D, par3 + 0.0D, par4 + 0.0D, par2 + 0.8D, par3 + 0.6D, par4 + 1.0D);
/*     */         }
/* 114 */         return AxisAlignedBB.func_72330_a(par2 + 0.0D, par3 + 0.0D, par4 + 0.2D, par2 + 1.0D, par3 + 0.6D, par4 + 0.8D);
/*     */       } 
/*     */ 
/*     */       
/* 118 */       return AxisAlignedBB.func_72330_a(par2 + 0.0D, par3 + 0.0D, par4 + 0.0D, par2 + 1.0D, par3 + 1.0D, par4 + 1.0D);
/*     */     } 
/*     */     
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 127 */     int meta = world.func_72805_g(x, y, z);
/* 128 */     int direction = getDirectionFromMetadata(meta);
/* 129 */     TEAnvil te = (TEAnvil)world.func_147438_o(x, y, z);
/*     */     
/* 131 */     if (te.anvilTier != AnvilReq.STONE.Tier) {
/*     */       
/* 133 */       if (direction == 0) {
/*     */         
/* 135 */         func_149676_a(0.2F, 0.0F, 0.0F, 0.8F, 0.6F, 1.0F);
/* 136 */         return AxisAlignedBB.func_72330_a(x + 0.2D, y + 0.0D, z + 0.0D, x + 0.8D, y + 0.6D, z + 1.0D);
/*     */       } 
/*     */ 
/*     */       
/* 140 */       func_149676_a(0.0F, 0.0F, 0.2F, 1.0F, 0.6F, 0.8F);
/* 141 */       return AxisAlignedBB.func_72330_a(x + 0.0D, y + 0.0D, z + 0.2D, x + 1.0D, y + 0.6D, z + 0.8D);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 146 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9F, 1.0F);
/* 147 */     return AxisAlignedBB.func_72330_a(x + 0.0D, y + 0.0D, z + 0.0D, x + 1.0D, y + 0.8999999761581421D, z + 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 157 */     int meta = bAccess.func_72805_g(x, y, z);
/* 158 */     int direction = getDirectionFromMetadata(meta);
/* 159 */     TEAnvil te = (TEAnvil)bAccess.func_147438_o(x, y, z);
/*     */     
/* 161 */     if (te.anvilTier != AnvilReq.STONE.Tier) {
/*     */       
/* 163 */       if (direction == 0) {
/* 164 */         func_149676_a(0.2F, 0.0F, 0.0F, 0.8F, 0.6F, 1.0F);
/*     */       } else {
/* 166 */         func_149676_a(0.0F, 0.0F, 0.2F, 1.0F, 0.6F, 0.8F);
/*     */       } 
/*     */     } else {
/*     */       
/* 170 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 177 */     int meta = getAnvilTypeFromMeta(j);
/*     */     
/* 179 */     if (j == 0 && this == TFCBlocks.anvil)
/*     */     {
/* 181 */       return this.stoneAnvilIcon;
/*     */     }
/*     */ 
/*     */     
/* 185 */     if (i == 0 || i == 1) {
/* 186 */       return this.textureMapTop[meta];
/*     */     }
/* 188 */     return this.textureMapSide[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 195 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 201 */     return TFCBlocks.anvilRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/* 207 */     int type = getAnvilTypeFromMeta(l);
/* 208 */     if (this == TFCBlocks.anvil)
/*     */     {
/* 210 */       if (type == 0)
/*     */         return; 
/*     */     }
/* 213 */     super.func_149636_a(world, entityplayer, i, j, k, type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World par1World, int x, int y, int z, int meta, float par6, int par7) {
/* 219 */     if (!par1World.field_72995_K) {
/* 220 */       func_149642_a(par1World, x, y, z, new ItemStack((Block)this, 1, meta));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_149642_a(World par1World, int par2, int par3, int par4, ItemStack is) {
/* 226 */     if (!par1World.field_72995_K && par1World.func_82736_K().func_82766_b("doTileDrops")) {
/*     */       
/* 228 */       if (is.func_77960_j() == 0 && this == TFCBlocks.anvil)
/*     */         return; 
/* 230 */       float f = 0.7F;
/* 231 */       double d0 = (par1World.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 232 */       double d1 = (par1World.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 233 */       double d2 = (par1World.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 234 */       EntityItem entityitem = new EntityItem(par1World, par2 + d0, par3 + d1, par4 + d2, is);
/* 235 */       entityitem.field_145804_b = 10;
/* 236 */       par1World.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 243 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
/* 249 */     int meta = world.func_72805_g(i, j, k);
/* 250 */     int l = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 251 */     byte byte0 = 0;
/* 252 */     if (l == 0)
/* 253 */       byte0 = 8; 
/* 254 */     if (l == 1)
/* 255 */       byte0 = 0; 
/* 256 */     if (l == 2)
/* 257 */       byte0 = 8; 
/* 258 */     if (l == 3)
/* 259 */       byte0 = 0; 
/* 260 */     byte0 = (byte)(byte0 + meta);
/*     */     
/* 262 */     world.func_72921_c(i, j, k, byte0, 3);
/*     */     
/* 264 */     TEAnvil te = (TEAnvil)world.func_147438_o(i, j, k);
/* 265 */     if (this == TFCBlocks.anvil) {
/* 266 */       te.anvilTier = (AnvilReq.getReqFromInt(meta)).Tier;
/* 267 */     } else if (this == TFCBlocks.anvil2) {
/* 268 */       te.anvilTier = (AnvilReq.getReqFromInt2(meta)).Tier;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block block, int metadata) {
/* 274 */     TEAnvil var5 = (TEAnvil)world.func_147438_o(x, y, z);
/*     */     
/* 276 */     if (var5 != null)
/*     */     {
/* 278 */       for (int var6 = 0; var6 < var5.func_70302_i_(); var6++) {
/*     */         
/* 280 */         ItemStack var7 = var5.func_70301_a(var6);
/*     */         
/* 282 */         if (var7 != null) {
/*     */           
/* 284 */           float var8 = world.field_73012_v.nextFloat() * 0.8F + 0.1F;
/* 285 */           float var9 = world.field_73012_v.nextFloat() * 0.8F + 0.1F;
/*     */ 
/*     */           
/* 288 */           for (float var10 = world.field_73012_v.nextFloat() * 0.8F + 0.1F; var7.field_77994_a > 0; world.func_72838_d((Entity)var12)) {
/*     */             
/* 290 */             int var11 = world.field_73012_v.nextInt(21) + 10;
/*     */             
/* 292 */             if (var11 > var7.field_77994_a)
/* 293 */               var11 = var7.field_77994_a; 
/* 294 */             var7.field_77994_a -= var11;
/* 295 */             EntityItem var12 = new EntityItem(world, (x + var8), (y + var9), (z + var10), new ItemStack(var7.func_77973_b(), var11, var7.func_77960_j()));
/* 296 */             float var13 = 0.05F;
/* 297 */             var12.field_70159_w = ((float)world.field_73012_v.nextGaussian() * var13);
/* 298 */             var12.field_70181_x = ((float)world.field_73012_v.nextGaussian() * var13 + 0.2F);
/* 299 */             var12.field_70179_y = ((float)world.field_73012_v.nextGaussian() * var13);
/* 300 */             if (var7.func_77942_o())
/* 301 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b()); 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 306 */     super.func_149749_a(world, x, y, z, block, metadata);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 312 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getAnvilTypeFromMeta(int j) {
/* 317 */     int l = 7;
/* 318 */     return j & l;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDirectionFromMetadata(int i) {
/* 323 */     int d = i >> 3;
/* 324 */     if (d == 1) {
/* 325 */       return 1;
/*     */     }
/* 327 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 333 */     return (TileEntity)new TEAnvil();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 339 */     this.textureMapTop = new IIcon[(this.anvilId == 0) ? 8 : 3];
/* 340 */     this.textureMapSide = new IIcon[(this.anvilId == 0) ? 8 : 3];
/* 341 */     for (int i = (this.anvilId == 0) ? 1 : 0; i < ((this.anvilId == 0) ? 8 : 3); i++) {
/*     */       
/* 343 */       this.textureMapTop[i] = registerer.func_94245_a("terrafirmacraft:devices/Anvil_" + (i + this.anvilId) + "_Top");
/* 344 */       this.textureMapSide[i] = registerer.func_94245_a("terrafirmacraft:devices/Anvil_" + (i + this.anvilId) + "_Side");
/*     */     } 
/*     */     
/* 347 */     this.stoneAnvilIcon = registerer.func_94245_a("terrafirmacraft:rocks/Gabbro Raw");
/*     */     
/* 349 */     TFC_Textures.anvilHit = registerer.func_94245_a("terrafirmacraft:Anvil Hit");
/* 350 */     TFC_Textures.anvilHitHeavy = registerer.func_94245_a("terrafirmacraft:Anvil Hit Heavy");
/* 351 */     TFC_Textures.anvilHitMedium = registerer.func_94245_a("terrafirmacraft:Anvil Hit Medium");
/* 352 */     TFC_Textures.anvilHitLight = registerer.func_94245_a("terrafirmacraft:Anvil Hit Light");
/* 353 */     TFC_Textures.anvilDraw = registerer.func_94245_a("terrafirmacraft:Anvil Draw");
/* 354 */     TFC_Textures.anvilPunch = registerer.func_94245_a("terrafirmacraft:Anvil Punch");
/* 355 */     TFC_Textures.anvilBend = registerer.func_94245_a("terrafirmacraft:Anvil Bend");
/* 356 */     TFC_Textures.anvilUpset = registerer.func_94245_a("terrafirmacraft:Anvil Upset");
/* 357 */     TFC_Textures.anvilShrink = registerer.func_94245_a("terrafirmacraft:Anvil Shrink");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 363 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 370 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 377 */     return (world.func_147439_a(x, y, z) == this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */