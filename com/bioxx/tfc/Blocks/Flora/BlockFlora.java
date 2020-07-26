/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFlora
/*     */   extends BlockTerra
/*     */ {
/*     */   private IIcon[] icons;
/*     */   private String[] metaNames;
/*     */   
/*     */   public BlockFlora() {
/*  28 */     super(Material.field_151585_k);
/*  29 */     this.metaNames = new String[] { "Golden Rod", "Cat Tails" };
/*  30 */     this.icons = new IIcon[this.metaNames.length];
/*  31 */     func_149676_a(0.3F, 0.0F, 0.3F, 0.7F, 0.7F, 0.7F);
/*  32 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/*  38 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  56 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  63 */     for (int i = 0; i < this.icons.length; i++) {
/*  64 */       this.icons[i] = par1IconRegister.func_94245_a("terrafirmacraft:plants/" + this.metaNames[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  71 */     if (par2 >= this.icons.length)
/*  72 */       par2 = 0; 
/*  73 */     return this.icons[par2];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/*  79 */     return ((world.func_72883_k(x, y, z) >= 8 || world
/*  80 */       .func_72937_j(x, y, z)) && 
/*  81 */       canThisPlantGrowOnThisBlock(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block par5) {
/*  87 */     super.func_149695_a(world, i, j, k, par5);
/*  88 */     if (!func_149718_j(world, i, j, k)) {
/*  89 */       world.func_147468_f(i, j, k);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/*  95 */     Block block = world.func_147439_a(x, y, z);
/*  96 */     return ((world.func_147437_c(x, y, z) || block.func_149688_o().func_76222_j()) && canThisPlantGrowOnThisBlock(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlock(Block block) {
/* 101 */     return (TFC_Core.isSoil(block) || TFC_Core.isFarmland(block));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par1, Random par2Random, int par3) {
/* 107 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockFlora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */