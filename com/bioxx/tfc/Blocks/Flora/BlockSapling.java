/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TileEntities.TESapling;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSapling
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   protected IIcon[] icons;
/*     */   protected String[] woodNames;
/*     */   
/*     */   public BlockSapling() {
/*  39 */     super(Material.field_151585_k);
/*  40 */     float f = 0.4F;
/*  41 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/*  42 */     this.woodNames = new String[16];
/*  43 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  44 */     func_149675_a(true);
/*  45 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  46 */     this.icons = new IIcon[this.woodNames.length];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  53 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  54 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/*  60 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  66 */     return this.icons[j];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  72 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  73 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Sapling");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void growTree(World world, int i, int j, int k, Random rand, long timestamp) {
/*  79 */     int meta = world.func_72805_g(i, j, k);
/*  80 */     world.func_147468_f(i, j, k);
/*  81 */     WorldGenerator worldGen = TFCBiome.getTreeGen(meta, Boolean.valueOf(rand.nextBoolean()));
/*     */     
/*  83 */     if (worldGen != null && !worldGen.func_76484_a(world, rand, i, j, k)) {
/*     */       
/*  85 */       world.func_147465_d(i, j, k, (Block)this, meta, 3);
/*  86 */       if (world.func_147438_o(i, j, k) instanceof TESapling) {
/*     */         
/*  88 */         TESapling te = (TESapling)world.func_147438_o(i, j, k);
/*  89 */         te.growTime = timestamp;
/*  90 */         te.enoughSpace = false;
/*  91 */         te.func_70296_d();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block b) {
/*  99 */     Block block = world.func_147439_a(i, j, k);
/* 100 */     if (!TFC_Core.isGrass(block) && !TFC_Core.isDirt(block) && !func_149718_j(world, i, j, k)) {
/*     */       
/* 102 */       int meta = world.func_72805_g(i, j, k);
/* 103 */       func_149642_a(world, i, j, k, new ItemStack((Block)this, 1, meta));
/* 104 */       world.func_147468_f(i, j, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int i, int j, int k) {
/* 113 */     int meta = world.func_72805_g(i, j, k);
/* 114 */     float growSpeed = 1.0F;
/* 115 */     if (meta == 1 || meta == 11) {
/* 116 */       growSpeed = 1.2F;
/* 117 */     } else if (meta == 5 || meta == 0 || meta == 13) {
/* 118 */       growSpeed = 1.4F;
/* 119 */     } else if (meta == 9 || meta == 14 || meta == 15) {
/* 120 */       growSpeed = 1.6F;
/*     */     } 
/* 122 */     if (world.func_147438_o(i, j, k) instanceof TESapling) {
/*     */       
/* 124 */       TESapling te = (TESapling)world.func_147438_o(i, j, k);
/*     */ 
/*     */       
/* 127 */       if (te != null && te.growTime == 0L) {
/* 128 */         te.growTime = (long)((float)TFC_Time.getTotalTicks() + 168000.0F * growSpeed * TFCOptions.saplingTimerMultiplier + world.field_73012_v.nextFloat() * 24000.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random rand) {
/* 135 */     if (!world.field_72995_K) {
/*     */       
/* 137 */       super.func_149674_a(world, i, j, k, rand);
/*     */       
/* 139 */       if (world.func_147438_o(i, j, k) instanceof TESapling) {
/*     */         
/* 141 */         long timestamp = ((TESapling)world.func_147438_o(i, j, k)).growTime;
/*     */         
/* 143 */         if (world.func_72957_l(i, j + 1, k) >= 9 && TFC_Time.getTotalTicks() > timestamp)
/*     */         {
/* 145 */           growTree(world, i, j, k, rand, timestamp);
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
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 157 */     return ((world.func_72883_k(x, y, z) >= 8 || world.func_72937_j(x, y, z)) && canThisPlantGrowOnThisBlockID(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 166 */     return ((world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z).func_149688_o().func_76222_j()) && canThisPlantGrowOnThisBlockID(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess bAccess, int x, int y, int z) {
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlockID(Block b) {
/* 181 */     return TFC_Core.isSoil(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 191 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 200 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 210 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 219 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 225 */     return (TileEntity)new TESapling();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkChange(World world, int x, int y, int z) {
/* 230 */     if (!func_149718_j(world, x, y, z)) {
/*     */       
/* 232 */       func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
/* 233 */       world.func_147468_f(x, y, z);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */