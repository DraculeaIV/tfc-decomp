/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomLeaves
/*     */   extends BlockLeaves
/*     */   implements IShearable
/*     */ {
/*     */   protected int[][][] adjacentTreeBlocks;
/*     */   protected String[] woodNames;
/*     */   protected IIcon[] icons;
/*     */   protected IIcon[] iconsOpaque;
/*     */   
/*     */   public BlockCustomLeaves() {
/*  44 */     func_149675_a(false);
/*  45 */     this.woodNames = new String[16];
/*  46 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  47 */     this.icons = new IIcon[16];
/*  48 */     this.iconsOpaque = new IIcon[16];
/*  49 */     func_149675_a(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List list) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/*  67 */     return TerraFirmaCraft.proxy.foliageColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  73 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/*  79 */     entity.field_70159_w *= 0.1D;
/*  80 */     entity.field_70179_y *= 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess world, int x, int y, int z, int side) {
/*  87 */     Block block = world.func_147439_a(x, y, z);
/*     */ 
/*     */     
/*  90 */     if (side == 0 && this.field_149760_C > 0.0D)
/*  91 */       return true; 
/*  92 */     if (side == 1 && this.field_149756_F < 1.0D)
/*  93 */       return true; 
/*  94 */     if (side == 2 && this.field_149754_D > 0.0D)
/*  95 */       return true; 
/*  96 */     if (side == 3 && this.field_149757_G < 1.0D)
/*  97 */       return true; 
/*  98 */     if (side == 4 && this.field_149759_B > 0.0D)
/*  99 */       return true; 
/* 100 */     if (side == 5 && this.field_149755_E < 1.0D) {
/* 101 */       return true;
/*     */     }
/* 103 */     return !block.func_149662_c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 109 */     func_149695_a(world, x, y, z, (Block)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void beginLeavesDecay(World world, int x, int y, int z) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int xOrig, int yOrig, int zOrig, Block b) {
/* 121 */     if (!world.field_72995_K) {
/*     */       
/* 123 */       int var6 = world.func_72805_g(xOrig, yOrig, zOrig);
/*     */       
/* 125 */       byte searchRadius = 4;
/* 126 */       int maxDist = searchRadius + 1;
/* 127 */       byte searchDistance = 11;
/* 128 */       int center = searchDistance / 2;
/* 129 */       this.adjacentTreeBlocks = (int[][][])null;
/* 130 */       if (this.adjacentTreeBlocks == null) {
/* 131 */         this.adjacentTreeBlocks = new int[searchDistance][searchDistance][searchDistance];
/*     */       }
/* 133 */       if (world.func_72904_c(xOrig - maxDist, yOrig - maxDist, zOrig - maxDist, xOrig + maxDist, yOrig + maxDist, zOrig + maxDist)) {
/*     */         
/* 135 */         for (int xd = -searchRadius; xd <= searchRadius; xd++) {
/*     */           
/* 137 */           int searchY = searchRadius - Math.abs(xd);
/* 138 */           for (int yd = -searchY; yd <= searchY; yd++) {
/*     */             
/* 140 */             int searchZ = searchY - Math.abs(yd);
/* 141 */             for (int zd = -searchZ; zd <= searchZ; zd++) {
/*     */               
/* 143 */               Block block = world.func_147439_a(xOrig + xd, yOrig + yd, zOrig + zd);
/*     */               
/* 145 */               if (block == TFCBlocks.logNatural || block == TFCBlocks.logNatural2) {
/* 146 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = 0;
/* 147 */               } else if (block == this && var6 == world.func_72805_g(xOrig + xd, yOrig + yd, zOrig + zd)) {
/* 148 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -2;
/*     */               } else {
/* 150 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -1;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 155 */         for (int pass = 1; pass <= 4; pass++) {
/*     */           
/* 157 */           for (int i = -searchRadius; i <= searchRadius; i++) {
/*     */             
/* 159 */             int searchY = searchRadius - Math.abs(i);
/* 160 */             for (int yd = -searchY; yd <= searchY; yd++) {
/*     */               
/* 162 */               int searchZ = searchY - Math.abs(yd);
/* 163 */               for (int zd = -searchZ; zd <= searchZ; zd++) {
/*     */                 
/* 165 */                 if (this.adjacentTreeBlocks[i + center][yd + center][zd + center] == pass - 1) {
/*     */                   
/* 167 */                   if (this.adjacentTreeBlocks[i + center - 1][yd + center][zd + center] == -2) {
/* 168 */                     this.adjacentTreeBlocks[i + center - 1][yd + center][zd + center] = pass;
/*     */                   }
/* 170 */                   if (this.adjacentTreeBlocks[i + center + 1][yd + center][zd + center] == -2) {
/* 171 */                     this.adjacentTreeBlocks[i + center + 1][yd + center][zd + center] = pass;
/*     */                   }
/* 173 */                   if (this.adjacentTreeBlocks[i + center][yd + center - 1][zd + center] == -2) {
/* 174 */                     this.adjacentTreeBlocks[i + center][yd + center - 1][zd + center] = pass;
/*     */                   }
/* 176 */                   if (this.adjacentTreeBlocks[i + center][yd + center + 1][zd + center] == -2) {
/* 177 */                     this.adjacentTreeBlocks[i + center][yd + center + 1][zd + center] = pass;
/*     */                   }
/* 179 */                   if (this.adjacentTreeBlocks[i + center][yd + center][zd + center - 1] == -2) {
/* 180 */                     this.adjacentTreeBlocks[i + center][yd + center][zd + center - 1] = pass;
/*     */                   }
/* 182 */                   if (this.adjacentTreeBlocks[i + center][yd + center][zd + center + 1] == -2) {
/* 183 */                     this.adjacentTreeBlocks[i + center][yd + center][zd + center + 1] = pass;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 191 */       int res = this.adjacentTreeBlocks[center][center][center];
/*     */       
/* 193 */       if (res < 0)
/*     */       {
/* 195 */         if (world.func_72938_d(xOrig, zOrig) != null) {
/* 196 */           destroyLeaves(world, xOrig, yOrig, zOrig);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void destroyLeaves(World world, int x, int y, int z) {
/* 203 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeLeaves(World world, int x, int y, int z) {
/* 208 */     func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 209 */     if (world.field_73012_v.nextInt(100) < 30)
/* 210 */       func_149642_a(world, x, y, z, new ItemStack(TFCItems.stick, 1)); 
/* 211 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/* 217 */     return (rand.nextInt(20) != 0) ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random rand, int j) {
/* 223 */     return Item.func_150898_a(TFCBlocks.sapling);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World world, int x, int y, int z, int meta, float f, int i1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int meta) {
/* 235 */     if (!world.field_72995_K) {
/*     */       
/* 237 */       ItemStack itemstack = entityplayer.field_71071_by.func_70448_g();
/* 238 */       int[] equipIDs = OreDictionary.getOreIDs(itemstack);
/* 239 */       for (int id : equipIDs) {
/*     */         
/* 241 */         String name = OreDictionary.getOreName(id);
/* 242 */         if (name.startsWith("itemScythe")) {
/*     */           
/* 244 */           for (int x = -1; x < 2; x++) {
/*     */             
/* 246 */             for (int z = -1; z < 2; z++) {
/*     */               
/* 248 */               for (int y = -1; y < 2; y++) {
/*     */                 
/* 250 */                 if (world.func_147439_a(i + x, j + y, k + z).func_149688_o() == Material.field_151584_j && entityplayer.field_71071_by
/* 251 */                   .func_70301_a(entityplayer.field_71071_by.field_70461_c) != null) {
/*     */                   
/* 253 */                   entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 254 */                   entityplayer.func_71020_j(0.045F);
/* 255 */                   if (world.field_73012_v.nextInt(100) < 11) {
/* 256 */                     func_149642_a(world, i + x, j + y, k + z, new ItemStack(TFCItems.stick, 1));
/* 257 */                   } else if (world.field_73012_v.nextInt(100) < 4 && TFCOptions.enableSaplingDrops) {
/* 258 */                     dropSapling(world, i + x, j + y, k + z, meta);
/* 259 */                   }  removeLeaves(world, i + x, j + y, k + z);
/* 260 */                   super.func_149636_a(world, entityplayer, i + x, j + y, k + z, meta);
/*     */                   
/* 262 */                   itemstack.func_77972_a(1, (EntityLivingBase)entityplayer);
/* 263 */                   if (itemstack.field_77994_a == 0) {
/* 264 */                     entityplayer.field_71071_by.func_70299_a(entityplayer.field_71071_by.field_70461_c, null);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 274 */       entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 275 */       entityplayer.func_71020_j(0.025F);
/* 276 */       if (world.field_73012_v.nextInt(100) < 28) {
/* 277 */         func_149642_a(world, i, j, k, new ItemStack(TFCItems.stick, 1));
/* 278 */       } else if (world.field_73012_v.nextInt(100) < 6 && TFCOptions.enableSaplingDrops) {
/* 279 */         dropSapling(world, i, j, k, meta);
/*     */       } 
/* 281 */       super.func_149636_a(world, entityplayer, i, j, k, meta);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropSapling(World world, int x, int y, int z, int meta) {
/* 288 */     if (meta != 9 && meta != 15) {
/* 289 */       func_149642_a(world, x, y, z, new ItemStack(func_149650_a(0, (Random)null, 0), 1, meta));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 295 */     return dmg;
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
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 307 */     if (meta > this.woodNames.length - 1)
/* 308 */       meta = 0; 
/* 309 */     if (TerraFirmaCraft.proxy.getGraphicsLevel()) {
/* 310 */       return this.icons[meta];
/*     */     }
/* 312 */     return this.iconsOpaque[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 318 */     for (int i = 0; i < this.woodNames.length; i++) {
/*     */       
/* 320 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Leaves Fancy");
/* 321 */       this.iconsOpaque[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Leaves");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 328 */     return (String[])this.woodNames.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 334 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */