/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.FloraIndex;
/*     */ import com.bioxx.tfc.Food.FloraManager;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitLeaves;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFruitLeaves
/*     */   extends BlockTerraContainer
/*     */ {
/*  33 */   private String[] woodNames = Global.FRUIT_META_NAMES;
/*  34 */   private IIcon[] icons = new IIcon[16];
/*     */   
/*  36 */   public static IIcon[] iconsFruit = new IIcon[16];
/*  37 */   private IIcon[] iconsOpaque = new IIcon[16];
/*     */   
/*  39 */   public static IIcon[] iconsFlowers = new IIcon[16];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockFruitLeaves(int offset) {
/*  45 */     super(Material.field_151584_j);
/*  46 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/*  53 */     return TerraFirmaCraft.proxy.foliageColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  59 */     return TFCBlocks.leavesFruitRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  77 */     if (TerraFirmaCraft.proxy.getGraphicsLevel()) {
/*  78 */       return this.icons[meta & 0x7];
/*     */     }
/*  80 */     return this.iconsOpaque[meta & 0x7];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  86 */     for (int i = 0; i < 9; i++) {
/*     */       
/*  88 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/fruit trees/" + this.woodNames[i] + " Leaves");
/*  89 */       this.iconsOpaque[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/fruit trees/" + this.woodNames[i] + " Leaves Opaque");
/*     */ 
/*     */       
/*  92 */       iconsFruit[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/fruit trees/" + this.woodNames[i] + " Fruit");
/*  93 */       iconsFlowers[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/fruit trees/" + this.woodNames[i] + " Flowers");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149646_a(IBlockAccess bAccess, int x, int y, int z, int side) {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 112 */     lifeCycle(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void lifeCycle(World world, int x, int y, int z) {
/* 117 */     if (!world.field_72995_K) {
/*     */       
/* 119 */       if (!canStay(world, x, y, z)) {
/*     */         
/* 121 */         destroyLeaves(world, x, y, z);
/*     */         
/*     */         return;
/*     */       } 
/* 125 */       Random rand = new Random();
/* 126 */       int meta = world.func_72805_g(x, y, z);
/* 127 */       int m = meta - 8;
/*     */       
/* 129 */       FloraManager manager = FloraManager.getInstance();
/* 130 */       FloraIndex fi = manager.findMatchingIndex(getType((Block)this, m));
/* 131 */       FloraIndex fi2 = manager.findMatchingIndex(getType((Block)this, meta));
/*     */       
/* 133 */       float temp = TFC_Climate.getHeightAdjustedTemp(world, x, y, z);
/* 134 */       TEFruitLeaves te = (TEFruitLeaves)world.func_147438_o(x, y, z);
/* 135 */       if (te != null) {
/*     */         
/* 137 */         if (fi2 != null)
/*     */         {
/* 139 */           if (temp >= fi2.minTemp && temp < fi2.maxTemp) {
/*     */             
/* 141 */             if (fi2.inHarvest(TFC_Time.getSeasonAdjustedMonth(z)) && !te.hasFruit && TFC_Time.getMonthsSinceDay(te.dayHarvested) > 1)
/*     */             {
/* 143 */               if (meta < 8) {
/*     */                 
/* 145 */                 meta += 8;
/* 146 */                 te.hasFruit = true;
/* 147 */                 te.dayFruited = TFC_Time.getTotalDays();
/*     */               } 
/* 149 */               world.func_72921_c(x, y, z, meta, 2);
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 154 */           else if (meta >= 8 && rand.nextInt(10) == 0) {
/*     */             
/* 156 */             if (te.hasFruit) {
/*     */               
/* 158 */               te.hasFruit = false;
/* 159 */               world.func_72921_c(x, y, z, meta - 8, 2);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 165 */         if (fi != null)
/*     */         {
/* 167 */           if (!fi.inHarvest(TFC_Time.getSeasonAdjustedMonth(z)))
/*     */           {
/* 169 */             if (world.func_72805_g(x, y, z) >= 8)
/*     */             {
/* 171 */               if (te.hasFruit) {
/*     */                 
/* 173 */                 te.hasFruit = false;
/* 174 */                 world.func_72921_c(x, y, z, meta - 8, 2);
/*     */               } 
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 180 */         if (rand.nextInt(100) > 50) {
/* 181 */           world.func_147471_g(x, y, z);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canStay(World world, int x, int y, int z) {
/* 189 */     for (int i = 1; i >= -1; i--) {
/*     */       
/* 191 */       for (int j = 0; j >= -1; j--) {
/*     */         
/* 193 */         for (int k = 1; k >= -1; k--) {
/*     */           
/* 195 */           if (world.func_147439_a(i + x, j + y, k + z) == TFCBlocks.fruitTreeWood && world
/* 196 */             .func_147439_a(i + x, j + y + 1, k + z) != TFCBlocks.fruitTreeWood) {
/* 197 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getType(Block block, int meta) {
/* 207 */     if (block == TFCBlocks.fruitTreeLeaves) {
/*     */       
/* 209 */       switch (meta) {
/*     */         case 0:
/* 211 */           return Global.FRUIT_META_NAMES[0];
/* 212 */         case 1: return Global.FRUIT_META_NAMES[1];
/* 213 */         case 2: return Global.FRUIT_META_NAMES[2];
/* 214 */         case 3: return Global.FRUIT_META_NAMES[3];
/* 215 */         case 4: return Global.FRUIT_META_NAMES[4];
/* 216 */         case 5: return Global.FRUIT_META_NAMES[5];
/* 217 */         case 6: return Global.FRUIT_META_NAMES[6];
/* 218 */         case 7: return Global.FRUIT_META_NAMES[7];
/*     */       } 
/*     */ 
/*     */     
/*     */     } else {
/* 223 */       switch (meta) {
/*     */         case 0:
/* 225 */           return Global.FRUIT_META_NAMES[8];
/*     */       } 
/*     */     } 
/* 228 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 234 */     super.func_149695_a(world, x, y, z, b);
/* 235 */     lifeCycle(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void destroyLeaves(World world, int x, int y, int z) {
/* 240 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World world, int x, int y, int z, int meta, float dropChance, int fortune) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149699_a(World world, int x, int y, int z, EntityPlayer entityplayer) {
/* 253 */     if (!world.field_72995_K) {
/*     */       
/* 255 */       int meta = world.func_72805_g(x, y, z);
/* 256 */       FloraManager manager = FloraManager.getInstance();
/* 257 */       FloraIndex fi = manager.findMatchingIndex(getType((Block)this, world.func_72805_g(x, y, z) & 0x7));
/*     */       
/* 259 */       if (fi != null && (fi.inHarvest(TFC_Time.getSeasonAdjustedMonth(z)) || (fi.inHarvest((TFC_Time.getSeasonAdjustedMonth(z) + 11) % 12) && (meta & 0x8) == 8))) {
/*     */         
/* 261 */         TEFruitLeaves te = (TEFruitLeaves)world.func_147438_o(x, y, z);
/* 262 */         if (te != null && te.hasFruit) {
/*     */           
/* 264 */           te.hasFruit = false;
/* 265 */           te.dayHarvested = TFC_Time.getTotalDays();
/* 266 */           world.func_72921_c(x, y, z, meta - 8, 3);
/* 267 */           func_149642_a(world, x, y, z, ItemFoodTFC.createTag(fi.getOutput(), Helper.roundNumber(4.0F + world.field_73012_v.nextFloat() * 12.0F, 10.0F)));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/* 277 */     if (!world.field_72995_K) {
/*     */       
/* 279 */       int meta = world.func_72805_g(x, y, z);
/* 280 */       FloraManager manager = FloraManager.getInstance();
/* 281 */       FloraIndex fi = manager.findMatchingIndex(getType((Block)this, world.func_72805_g(x, y, z) & 0x7));
/*     */       
/* 283 */       if (fi != null && (fi.inHarvest(TFC_Time.getSeasonAdjustedMonth(z)) || (fi.inHarvest((TFC_Time.getSeasonAdjustedMonth(z) + 11) % 12) && (meta & 0x8) == 8))) {
/*     */         
/* 285 */         TEFruitLeaves te = (TEFruitLeaves)world.func_147438_o(x, y, z);
/* 286 */         if (te != null && te.hasFruit) {
/*     */           
/* 288 */           te.hasFruit = false;
/* 289 */           te.dayHarvested = TFC_Time.getTotalDays();
/* 290 */           world.func_72921_c(x, y, z, meta - 8, 3);
/* 291 */           func_149642_a(world, x, y, z, ItemFoodTFC.createTag(fi.getOutput(), Helper.roundNumber(4.0F + world.field_73012_v.nextFloat() * 12.0F, 10.0F)));
/* 292 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 302 */     return (TileEntity)new TEFruitLeaves();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 308 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockFruitLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */