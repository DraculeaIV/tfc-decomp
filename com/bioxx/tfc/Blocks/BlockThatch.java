/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockThatch
/*     */   extends BlockTerra
/*     */ {
/*     */   public BlockThatch() {
/*  26 */     super(Material.field_151577_b);
/*  27 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  28 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  29 */     this.field_149786_r = 255;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  35 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:plants/Thatch");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/*  45 */     func_149642_a(world, i, j, k, new ItemStack(this, 1, l));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/*  51 */     if (!world.field_72995_K) {
/*     */       
/*  53 */       Block b = world.func_147439_a(x, y + 1, z);
/*  54 */       if (TFC_Core.isSoilOrGravel(b) || b instanceof com.bioxx.tfc.Blocks.Terrain.BlockCobble || b instanceof com.bioxx.tfc.Blocks.Terrain.BlockSand)
/*     */       {
/*  56 */         TFC_Core.setBlockToAirWithDrops(world, x, y, z);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/*  70 */     entity.field_70159_w *= 0.1D;
/*  71 */     entity.field_70179_y *= 0.1D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess world, int x, int y, int z, int side) {
/*  84 */     Block block = world.func_147439_a(x, y, z);
/*  85 */     if (side == 0 && this.field_149760_C > 0.0D)
/*  86 */       return true; 
/*  87 */     if (side == 1 && this.field_149756_F < 1.0D)
/*  88 */       return true; 
/*  89 */     if (side == 2 && this.field_149754_D > 0.0D)
/*  90 */       return true; 
/*  91 */     if (side == 3 && this.field_149757_G < 1.0D)
/*  92 */       return true; 
/*  93 */     if (side == 4 && this.field_149759_B > 0.0D)
/*  94 */       return true; 
/*  95 */     if (side == 5 && this.field_149755_E < 1.0D) {
/*  96 */       return true;
/*     */     }
/*  98 */     return !block.func_149662_c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 104 */     return (func_149718_j(world, x, y, z) && super.func_149742_c(world, x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 116 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockThatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */