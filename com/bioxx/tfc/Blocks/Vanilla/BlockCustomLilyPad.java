/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLilyPad;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomLilyPad
/*     */   extends BlockLilyPad
/*     */ {
/*     */   public BlockCustomLilyPad() {
/*  25 */     float f = 0.5F;
/*  26 */     float f1 = 0.015625F;
/*  27 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
/*  28 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  37 */     return 23;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
/*  47 */     if (!(par7Entity instanceof net.minecraft.entity.item.EntityBoat)) {
/*  48 */       super.func_149743_a(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/*  58 */     return AxisAlignedBB.func_72330_a(par2 + this.field_149759_B, par3 + this.field_149760_C, par4 + this.field_149754_D, par2 + this.field_149755_E, par3 + this.field_149756_F, par4 + this.field_149757_G);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/*  65 */     return 2129968;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int par1) {
/*  75 */     return 2129968;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  86 */     this.field_149761_L = par1IconRegister.func_94245_a(func_149641_N());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  97 */     return 2129968;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_149854_a(Block block) {
/* 103 */     return canThisPlantGrowOnThisBlock(block);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlock(Block par1) {
/* 108 */     return TFC_Core.isFreshWater(par1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canThisPlantGrowOnThisBlock(Block par1, int meta) {
/* 113 */     return (TFC_Core.isFreshWaterIncludeIce(par1, meta) && !TFC_Core.isWaterFlowing(par1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 122 */     Block id = world.func_147439_a(x, y - 1, z);
/* 123 */     int meta = world.func_72805_g(x, y - 1, z);
/* 124 */     return (y > 0 && y < 256) ? TFC_Core.isFreshWaterIncludeIce(id, meta) : false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomLilyPad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */