/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockWall;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomWall
/*     */   extends BlockWall
/*     */ {
/*     */   private int totalsubTypes;
/*     */   private Block block;
/*     */   
/*     */   public BlockCustomWall(Block blk, int t) {
/*  33 */     super(blk);
/*  34 */     this.block = blk;
/*  35 */     this.totalsubTypes = t;
/*  36 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  45 */     return this.block.func_149691_a(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
/*  51 */     if (TFCOptions.enableDebugMode && world.field_72995_K) {
/*     */       
/*  53 */       int metadata = world.func_72805_g(i, j, k);
/*  54 */       TerraFirmaCraft.LOG.info("Meta=" + func_149739_a() + ":" + metadata);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  61 */     if (TFCOptions.enableDebugMode && world.field_72995_K) {
/*     */       
/*  63 */       int metadata = world.func_72805_g(x, y, z);
/*  64 */       TerraFirmaCraft.LOG.info("Meta = " + func_149739_a() + ":" + metadata);
/*     */     } 
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  75 */     return TFCBlocks.wallRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  82 */     for (int i = 0; i < this.totalsubTypes; i++) {
/*  83 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/*  93 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess world, int x, int y, int z) {
/*  99 */     boolean flag0 = func_150091_e(world, x, y, z - 1);
/* 100 */     boolean flag1 = func_150091_e(world, x, y, z + 1);
/* 101 */     boolean flag2 = func_150091_e(world, x - 1, y, z);
/* 102 */     boolean flag3 = func_150091_e(world, x + 1, y, z);
/*     */     
/* 104 */     boolean flag0Up = func_150091_e(world, x, y, z - 1);
/* 105 */     boolean flag1Up = func_150091_e(world, x, y, z + 1);
/* 106 */     boolean flag2Up = func_150091_e(world, x - 1, y, z);
/* 107 */     boolean flag3Up = func_150091_e(world, x + 1, y, z);
/* 108 */     float f = 0.25F;
/* 109 */     float f1 = 0.75F;
/* 110 */     float f2 = 0.25F;
/* 111 */     float f3 = 0.75F;
/* 112 */     float f4 = 1.0F;
/*     */     
/* 114 */     if (flag0)
/*     */     {
/* 116 */       f2 = 0.0F;
/*     */     }
/*     */     
/* 119 */     if (flag1)
/*     */     {
/* 121 */       f3 = 1.0F;
/*     */     }
/*     */     
/* 124 */     if (flag2)
/*     */     {
/* 126 */       f = 0.0F;
/*     */     }
/*     */     
/* 129 */     if (flag3)
/*     */     {
/* 131 */       f1 = 1.0F;
/*     */     }
/*     */     
/* 134 */     if (flag0 && flag1 && !flag2 && !flag3) {
/*     */       
/* 136 */       if (!flag0Up || !flag1Up) {
/* 137 */         f4 = 0.8125F;
/*     */       }
/* 139 */       f = 0.3125F;
/* 140 */       f1 = 0.6875F;
/*     */     }
/* 142 */     else if (!flag0 && !flag1 && flag2 && flag3) {
/*     */       
/* 144 */       if (!flag2Up || !flag3Up) {
/* 145 */         f4 = 0.8125F;
/*     */       }
/* 147 */       f2 = 0.3125F;
/* 148 */       f3 = 0.6875F;
/*     */     } 
/*     */     
/* 151 */     func_149676_a(f, 0.0F, f2, f1, f4, f3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150091_e(IBlockAccess access, int i, int j, int k) {
/* 157 */     Block block = access.func_147439_a(i, j, k);
/* 158 */     if (block != this && block != Blocks.field_150396_be && block != TFCBlocks.fenceGate && block != TFCBlocks.fenceGate2 && !(block instanceof BlockCustomWall)) {
/* 159 */       return (block != null && block.func_149688_o().func_76218_k() && block.func_149686_d()) ? ((block.func_149688_o() != Material.field_151572_C)) : false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/* 172 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */