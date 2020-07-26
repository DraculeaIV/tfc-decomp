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
/*     */ public class BlockCustomLeaves
/*     */   extends BlockLeaves
/*     */   implements IShearable
/*     */ {
/*     */   protected int[][][] adjacentTreeBlocks;
/*     */   protected String[] woodNames;
/*     */   protected IIcon[] icons;
/*     */   protected IIcon[] iconsOpaque;
/*     */   public int recursionCount;
/*  41 */   public int recursionLimit = TFCOptions.recursionLimit;
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockCustomLeaves() {
/*  46 */     func_149675_a(false);
/*  47 */     this.woodNames = new String[16];
/*  48 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  49 */     this.icons = new IIcon[16];
/*  50 */     this.iconsOpaque = new IIcon[16];
/*  51 */     func_149675_a(false);
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
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/*  69 */     return TerraFirmaCraft.proxy.foliageColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/*  81 */     entity.field_70159_w *= 0.1D;
/*  82 */     entity.field_70179_y *= 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess world, int x, int y, int z, int side) {
/*  89 */     Block block = world.func_147439_a(x, y, z);
/*     */ 
/*     */     
/*  92 */     if (side == 0 && this.field_149760_C > 0.0D)
/*  93 */       return true; 
/*  94 */     if (side == 1 && this.field_149756_F < 1.0D)
/*  95 */       return true; 
/*  96 */     if (side == 2 && this.field_149754_D > 0.0D)
/*  97 */       return true; 
/*  98 */     if (side == 3 && this.field_149757_G < 1.0D)
/*  99 */       return true; 
/* 100 */     if (side == 4 && this.field_149759_B > 0.0D)
/* 101 */       return true; 
/* 102 */     if (side == 5 && this.field_149755_E < 1.0D) {
/* 103 */       return true;
/*     */     }
/* 105 */     return !block.func_149662_c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 111 */     func_149695_a(world, x, y, z, (Block)null);
/* 112 */     Block block = world.func_147439_a(x, y, z);
/* 113 */     if (block instanceof BlockCustomLeaves2)
/*     */     {
/* 115 */       destroyLeaves(world, x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void beginLeavesDecay(World world, int x, int y, int z) {
/* 124 */     if (this.recursionCount > this.recursionLimit) {
/*     */       
/* 126 */       Block destroyBlock = TFCBlocks.leaves2;
/* 127 */       world.func_147465_d(x, y, z, destroyBlock, 1, 4);
/* 128 */       world.func_147464_a(x, y, z, destroyBlock, world.field_73012_v.nextInt(30));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 135 */     byte b0 = 1;
/* 136 */     int i1 = b0 + 1;
/*     */     
/* 138 */     if (p_149749_1_.func_72904_c(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1))
/*     */     {
/* 140 */       for (int j1 = -b0; j1 <= b0; j1++) {
/*     */         
/* 142 */         for (int k1 = -b0; k1 <= b0; k1++) {
/*     */           
/* 144 */           for (int l1 = -b0; l1 <= b0; l1++) {
/*     */             
/* 146 */             Block block = p_149749_1_.func_147439_a(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
/* 147 */             if (block.isLeaves((IBlockAccess)p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1));
/*     */           } 
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
/*     */   public void func_149695_a(World world, int xOrig, int yOrig, int zOrig, Block b) {
/* 160 */     if (!world.field_72995_K) {
/*     */       
/* 162 */       int var6 = world.func_72805_g(xOrig, yOrig, zOrig);
/*     */       
/* 164 */       byte searchRadius = 4;
/* 165 */       int maxDist = searchRadius + 1;
/* 166 */       byte searchDistance = 11;
/* 167 */       int center = searchDistance / 2;
/* 168 */       this.adjacentTreeBlocks = (int[][][])null;
/* 169 */       if (this.adjacentTreeBlocks == null) {
/* 170 */         this.adjacentTreeBlocks = new int[searchDistance][searchDistance][searchDistance];
/*     */       }
/* 172 */       if (world.func_72904_c(xOrig - maxDist, yOrig - maxDist, zOrig - maxDist, xOrig + maxDist, yOrig + maxDist, zOrig + maxDist)) {
/*     */         
/* 174 */         for (int xd = -searchRadius; xd <= searchRadius; xd++) {
/*     */           
/* 176 */           int searchY = searchRadius - Math.abs(xd);
/* 177 */           for (int yd = -searchY; yd <= searchY; yd++) {
/*     */             
/* 179 */             int searchZ = searchY - Math.abs(yd);
/* 180 */             for (int zd = -searchZ; zd <= searchZ; zd++) {
/*     */               
/* 182 */               Block block = world.func_147439_a(xOrig + xd, yOrig + yd, zOrig + zd);
/*     */               
/* 184 */               if (block == TFCBlocks.logNatural || block == TFCBlocks.logNatural2) {
/* 185 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = 0;
/* 186 */               } else if (block == this && var6 == world.func_72805_g(xOrig + xd, yOrig + yd, zOrig + zd)) {
/* 187 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -2;
/*     */               } else {
/* 189 */                 this.adjacentTreeBlocks[xd + center][yd + center][zd + center] = -1;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 194 */         for (int pass = 1; pass <= 4; pass++) {
/*     */           
/* 196 */           for (int i = -searchRadius; i <= searchRadius; i++) {
/*     */             
/* 198 */             int searchY = searchRadius - Math.abs(i);
/* 199 */             for (int yd = -searchY; yd <= searchY; yd++) {
/*     */               
/* 201 */               int searchZ = searchY - Math.abs(yd);
/* 202 */               for (int zd = -searchZ; zd <= searchZ; zd++) {
/*     */                 
/* 204 */                 if (this.adjacentTreeBlocks[i + center][yd + center][zd + center] == pass - 1) {
/*     */                   
/* 206 */                   if (this.adjacentTreeBlocks[i + center - 1][yd + center][zd + center] == -2) {
/* 207 */                     this.adjacentTreeBlocks[i + center - 1][yd + center][zd + center] = pass;
/*     */                   }
/* 209 */                   if (this.adjacentTreeBlocks[i + center + 1][yd + center][zd + center] == -2) {
/* 210 */                     this.adjacentTreeBlocks[i + center + 1][yd + center][zd + center] = pass;
/*     */                   }
/* 212 */                   if (this.adjacentTreeBlocks[i + center][yd + center - 1][zd + center] == -2) {
/* 213 */                     this.adjacentTreeBlocks[i + center][yd + center - 1][zd + center] = pass;
/*     */                   }
/* 215 */                   if (this.adjacentTreeBlocks[i + center][yd + center + 1][zd + center] == -2) {
/* 216 */                     this.adjacentTreeBlocks[i + center][yd + center + 1][zd + center] = pass;
/*     */                   }
/* 218 */                   if (this.adjacentTreeBlocks[i + center][yd + center][zd + center - 1] == -2) {
/* 219 */                     this.adjacentTreeBlocks[i + center][yd + center][zd + center - 1] = pass;
/*     */                   }
/* 221 */                   if (this.adjacentTreeBlocks[i + center][yd + center][zd + center + 1] == -2) {
/* 222 */                     this.adjacentTreeBlocks[i + center][yd + center][zd + center + 1] = pass;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 230 */       int res = this.adjacentTreeBlocks[center][center][center];
/*     */       
/* 232 */       if (res < 0) {
/*     */         
/* 234 */         if (world.func_72938_d(xOrig, zOrig) != null)
/* 235 */           this.recursionCount++; 
/* 236 */         if (this.recursionCount <= this.recursionLimit) {
/* 237 */           destroyLeaves(world, xOrig, yOrig, zOrig);
/*     */         } else {
/*     */           
/* 240 */           TerraFirmaCraft.LOG.warn("*** Recursion Limit " + this.recursionLimit + " REACHED***");
/* 241 */           beginLeavesDecay(world, xOrig, yOrig, zOrig);
/*     */         } 
/* 243 */         this.recursionCount--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void destroyLeaves(World world, int x, int y, int z) {
/* 250 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeLeaves(World world, int x, int y, int z) {
/* 255 */     func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 256 */     if (world.field_73012_v.nextInt(100) < 30)
/* 257 */       func_149642_a(world, x, y, z, new ItemStack(TFCItems.stick, 1)); 
/* 258 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/* 264 */     return (rand.nextInt(20) != 0) ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random rand, int j) {
/* 270 */     return Item.func_150898_a(TFCBlocks.sapling);
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
/* 282 */     if (!world.field_72995_K) {
/*     */       
/* 284 */       ItemStack itemstack = entityplayer.field_71071_by.func_70448_g();
/* 285 */       int[] equipIDs = OreDictionary.getOreIDs(itemstack);
/* 286 */       for (int id : equipIDs) {
/*     */         
/* 288 */         String name = OreDictionary.getOreName(id);
/* 289 */         if (name.startsWith("itemScythe")) {
/*     */           
/* 291 */           for (int x = -1; x < 2; x++) {
/*     */             
/* 293 */             for (int z = -1; z < 2; z++) {
/*     */               
/* 295 */               for (int y = -1; y < 2; y++) {
/*     */                 
/* 297 */                 if (world.func_147439_a(i + x, j + y, k + z).func_149688_o() == Material.field_151584_j && entityplayer.field_71071_by
/* 298 */                   .func_70301_a(entityplayer.field_71071_by.field_70461_c) != null) {
/*     */                   
/* 300 */                   entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 301 */                   entityplayer.func_71020_j(0.045F);
/* 302 */                   if (world.field_73012_v.nextInt(100) < 11) {
/* 303 */                     func_149642_a(world, i + x, j + y, k + z, new ItemStack(TFCItems.stick, 1));
/* 304 */                   } else if (world.field_73012_v.nextInt(100) < 4 && TFCOptions.enableSaplingDrops) {
/* 305 */                     dropSapling(world, i + x, j + y, k + z, meta);
/* 306 */                   }  removeLeaves(world, i + x, j + y, k + z);
/* 307 */                   super.func_149636_a(world, entityplayer, i + x, j + y, k + z, meta);
/*     */                   
/* 309 */                   itemstack.func_77972_a(1, (EntityLivingBase)entityplayer);
/* 310 */                   if (itemstack.field_77994_a == 0) {
/* 311 */                     entityplayer.field_71071_by.func_70299_a(entityplayer.field_71071_by.field_70461_c, null);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 321 */       entityplayer.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 322 */       entityplayer.func_71020_j(0.025F);
/* 323 */       if (world.field_73012_v.nextInt(100) < 28) {
/* 324 */         func_149642_a(world, i, j, k, new ItemStack(TFCItems.stick, 1));
/* 325 */       } else if (world.field_73012_v.nextInt(100) < 6 && TFCOptions.enableSaplingDrops) {
/* 326 */         dropSapling(world, i, j, k, meta);
/*     */       } 
/* 328 */       super.func_149636_a(world, entityplayer, i, j, k, meta);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dropSapling(World world, int x, int y, int z, int meta) {
/* 335 */     if (meta != 9 && meta != 15) {
/* 336 */       func_149642_a(world, x, y, z, new ItemStack(func_149650_a(0, (Random)null, 0), 1, meta));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 342 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 348 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 354 */     if (meta > this.woodNames.length - 1)
/* 355 */       meta = 0; 
/* 356 */     if (TerraFirmaCraft.proxy.getGraphicsLevel()) {
/* 357 */       return this.icons[meta];
/*     */     }
/* 359 */     return this.iconsOpaque[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 365 */     for (int i = 0; i < this.woodNames.length; i++) {
/*     */       
/* 367 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Leaves Fancy");
/* 368 */       this.iconsOpaque[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Leaves");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] func_150125_e() {
/* 375 */     return (String[])this.woodNames.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 381 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomLeaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */