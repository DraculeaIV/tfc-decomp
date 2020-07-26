/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.FloraIndex;
/*     */ import com.bioxx.tfc.Food.FloraManager;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEBerryBush;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBerryBush
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public static IIcon[] icons;
/*     */   public static IIcon[] iconsBerries;
/*     */   public static String[] metaNames;
/*     */   public static final int WINTERGREEN = 0;
/*     */   public static final int BLUEBERRY = 1;
/*     */   public static final int RASPBERRY = 2;
/*     */   public static final int STRAWBERRY = 3;
/*     */   public static final int BLACKBERRY = 4;
/*     */   public static final int BUNCHBERRY = 5;
/*     */   public static final int CRANBERRY = 6;
/*     */   public static final int SNOWBERRY = 7;
/*     */   public static final int ELDERBERRY = 8;
/*     */   public static final int GOOSEBERRY = 9;
/*     */   public static final int CLOUDBERRY = 10;
/*     */   
/*     */   public BlockBerryBush() {
/*  57 */     super(Material.field_151585_k);
/*  58 */     metaNames = new String[] { "Wintergreen", "Blueberry", "Raspberry", "Strawberry", "Blackberry", "Bunchberry", "Cranberry", "Snowberry", "Elderberry", "Gooseberry", "Cloudberry" };
/*  59 */     icons = new IIcon[metaNames.length];
/*  60 */     iconsBerries = new IIcon[metaNames.length];
/*  61 */     func_149675_a(true);
/*  62 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  72 */     for (int i = 0; i < metaNames.length; i++) {
/*  73 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  79 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/*  85 */     int meta = access.func_72805_g(x, y, z);
/*     */     
/*  87 */     float minX = 0.1F;
/*  88 */     float minZ = 0.1F;
/*  89 */     float maxX = 0.9F;
/*  90 */     float maxZ = 0.9F;
/*  91 */     float maxY = 1.0F;
/*     */     
/*  93 */     if (isSamePlant(access, x - 1, y, z, meta)) minX = 0.0F; 
/*  94 */     if (isSamePlant(access, x + 1, y, z, meta)) maxX = 1.0F; 
/*  95 */     if (isSamePlant(access, x, y, z - 1, meta)) minZ = 0.0F; 
/*  96 */     if (isSamePlant(access, x, y, z + 1, meta)) maxZ = 1.0F; 
/*  97 */     if (isSamePlant(access, x, y + 1, z, meta)) maxY = 1.0F;
/*     */     
/*  99 */     switch (meta) {
/*     */ 
/*     */       
/*     */       case 0:
/* 103 */         maxY = 0.2F;
/* 104 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 1:
/* 109 */         maxY = 0.85F;
/* 110 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 2:
/* 115 */         maxY = 0.85F;
/* 116 */         if (isSamePlant(access, x, y + 1, z, meta))
/* 117 */           maxY = 1.0F; 
/* 118 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 3:
/* 123 */         maxY = 0.2F;
/* 124 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 4:
/* 129 */         maxY = 0.85F;
/* 130 */         if (isSamePlant(access, x, y + 1, z, meta))
/* 131 */           maxY = 1.0F; 
/* 132 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 5:
/* 137 */         maxY = 0.2F;
/* 138 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 6:
/* 143 */         maxY = 0.6F;
/* 144 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 7:
/* 149 */         maxY = 0.2F;
/* 150 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 8:
/* 155 */         maxY = 0.85F;
/* 156 */         if (isSamePlant(access, x, y + 1, z, meta))
/* 157 */           maxY = 1.0F; 
/* 158 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 9:
/* 163 */         maxY = 0.75F;
/* 164 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */ 
/*     */       
/*     */       case 10:
/* 169 */         maxY = 0.35F;
/* 170 */         func_149676_a(minX, 0.0F, minZ, maxX, maxY, maxZ);
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 175 */     func_149676_a(minX, 0.0F, minZ, maxX, 1.0F, maxZ);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isSamePlant(IBlockAccess bAccess, int x, int y, int z, int meta) {
/* 183 */     return (bAccess.func_147439_a(x, y, z) == this && bAccess.func_72805_g(x, y, z) == meta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149699_a(World world, int x, int y, int z, EntityPlayer entityplayer) {
/* 190 */     if (!world.field_72995_K) {
/*     */       
/* 192 */       int meta = world.func_72805_g(x, y, z);
/* 193 */       FloraManager manager = FloraManager.getInstance();
/* 194 */       FloraIndex fi = manager.findMatchingIndex(getType(meta));
/*     */       
/* 196 */       TEBerryBush te = (TEBerryBush)world.func_147438_o(x, y, z);
/* 197 */       if (te != null && te.hasFruit) {
/*     */         
/* 199 */         te.hasFruit = false;
/* 200 */         te.dayHarvested = TFC_Time.getTotalDays();
/* 201 */         world.func_147471_g(x, y, z);
/* 202 */         func_149642_a(world, x, y, z, ItemFoodTFC.createTag(fi.getOutput(), Helper.roundNumber(3.0F + world.field_73012_v.nextFloat() * 5.0F, 10.0F)));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/* 211 */     if (!world.field_72995_K) {
/*     */       
/* 213 */       int meta = world.func_72805_g(x, y, z);
/* 214 */       FloraManager manager = FloraManager.getInstance();
/* 215 */       FloraIndex fi = manager.findMatchingIndex(getType(meta));
/*     */       
/* 217 */       TEBerryBush te = (TEBerryBush)world.func_147438_o(x, y, z);
/* 218 */       if (te != null && te.hasFruit) {
/*     */         
/* 220 */         te.hasFruit = false;
/* 221 */         te.dayHarvested = TFC_Time.getTotalDays();
/* 222 */         world.func_147471_g(x, y, z);
/* 223 */         func_149642_a(world, x, y, z, ItemFoodTFC.createTag(fi.getOutput(), Helper.roundNumber(3.0F + world.field_73012_v.nextFloat() * 5.0F, 10.0F)));
/* 224 */         return true;
/*     */       } 
/*     */     } 
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 233 */     lifeCycle(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void lifeCycle(World world, int x, int y, int z) {
/* 238 */     if (!world.field_72995_K) {
/*     */       
/* 240 */       if (!func_149718_j(world, x, y, z)) {
/*     */         
/* 242 */         func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 243 */         world.func_147468_f(x, y, z);
/*     */         
/*     */         return;
/*     */       } 
/* 247 */       TileEntity te = world.func_147438_o(x, y, z);
/* 248 */       TEBerryBush tebb = null;
/* 249 */       if (te instanceof TEBerryBush)
/* 250 */         tebb = (TEBerryBush)world.func_147438_o(x, y, z); 
/* 251 */       if (tebb != null) {
/*     */         
/* 253 */         FloraIndex floraIndex = FloraManager.getInstance().findMatchingIndex(getType(world.func_72805_g(x, y, z)));
/* 254 */         float temp = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
/*     */         
/* 256 */         if (temp >= floraIndex.minTemp && temp < floraIndex.maxTemp) {
/*     */           
/* 258 */           if (!tebb.hasFruit && floraIndex.inHarvest(TFC_Time.getSeasonAdjustedMonth(z)) && TFC_Time.getMonthsSinceDay(tebb.dayHarvested) > 0)
/*     */           {
/* 260 */             tebb.hasFruit = true;
/* 261 */             tebb.dayFruited = TFC_Time.getTotalDays();
/* 262 */             world.func_147471_g(x, y, z);
/*     */           }
/*     */         
/* 265 */         } else if (temp < floraIndex.minTemp - 5.0F || temp > floraIndex.maxTemp + 5.0F) {
/*     */           
/* 267 */           if (tebb.hasFruit) {
/*     */             
/* 269 */             tebb.hasFruit = false;
/* 270 */             world.func_147471_g(x, y, z);
/*     */           } 
/*     */         } 
/*     */         
/* 274 */         if (tebb.hasFruit && TFC_Time.getMonthsSinceDay(tebb.dayFruited) > floraIndex.fruitHangTime)
/*     */         {
/* 276 */           tebb.hasFruit = false;
/* 277 */           world.func_147471_g(x, y, z);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 283 */       world.func_147438_o(x, y, z).func_145829_t();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getType(int meta) {
/* 289 */     return metaNames[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 295 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 301 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 307 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/* 314 */     for (int i = 0; i < icons.length; i++) {
/*     */       
/* 316 */       icons[i] = register.func_94245_a("terrafirmacraft:plants/" + metaNames[i]);
/* 317 */       iconsBerries[i] = register.func_94245_a("terrafirmacraft:plants/" + metaNames[i] + " Berry");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/* 325 */     int meta = access.func_72805_g(x, y, z);
/*     */     
/* 327 */     TEBerryBush te = (TEBerryBush)access.func_147438_o(x, y, z);
/* 328 */     if (te != null && te.hasFruit) {
/* 329 */       return iconsBerries[meta];
/*     */     }
/* 331 */     return icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int meta) {
/* 337 */     return iconsBerries[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 343 */     int meta = world.func_72805_g(x, y, z);
/* 344 */     return ((world.func_72883_k(x, y, z) >= 8 || world.func_72937_j(x, y, z)) && (
/* 345 */       canThisPlantGrowOnThisBlock(world.func_147439_a(x, y - 1, z)) || (
/* 346 */       isSamePlant((IBlockAccess)world, x, y - 1, z, world.func_72805_g(x, y, z)) && canStack(meta))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack is) {
/* 352 */     super.func_149689_a(world, x, y, z, entityliving, is);
/* 353 */     if (!func_149718_j(world, x, y, z)) {
/*     */       
/* 355 */       func_149695_a(world, x, y, z, world.func_147439_a(x, y, z));
/*     */     }
/*     */     else {
/*     */       
/* 359 */       TEBerryBush te = (TEBerryBush)world.func_147438_o(x, y, z);
/* 360 */       te.dayHarvested = TFC_Time.getTotalDays();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 367 */     super.func_149695_a(world, x, y, z, block);
/* 368 */     lifeCycle(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlock(Block block) {
/* 373 */     return TFC_Core.isGrass(block);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i1, Random rand, int i2) {
/* 379 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/* 385 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World i, int meta) {
/* 391 */     return (TileEntity)new TEBerryBush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/* 397 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/* 403 */     int meta = world.func_72805_g(x, y, z);
/* 404 */     if (meta == 1 || meta == 2 || meta == 4 || meta == 8 || meta == 9) {
/*     */       
/* 406 */       entity.field_70159_w *= 0.7D;
/* 407 */       entity.field_70179_y *= 0.7D;
/*     */     } 
/*     */     
/* 410 */     if (meta == 2 || meta == 4)
/*     */     {
/* 412 */       if (entity instanceof EntityLivingBase)
/* 413 */         entity.func_70097_a(DamageSource.field_76367_g, 5.0F); 
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canStack(int meta) {
/* 418 */     return (meta == 2 || meta == 4 || meta == 8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockBerryBush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */