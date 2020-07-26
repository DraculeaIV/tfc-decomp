/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFence;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemLead;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockTFCFence
/*     */   extends BlockFence
/*     */ {
/*     */   protected String[] woodNames;
/*     */   protected IIcon[] iconsPost;
/*     */   protected IIcon[] iconsPostTop;
/*     */   
/*     */   public BlockTFCFence(String str, Material mat) {
/*  36 */     super(str, mat);
/*  37 */     this.woodNames = new String[16];
/*  38 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  39 */     this.iconsPost = new IIcon[this.woodNames.length];
/*  40 */     this.iconsPostTop = new IIcon[this.woodNames.length];
/*  41 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World world, int x, int y, int z, AxisAlignedBB aaBB, List list, Entity entity) {
/*  51 */     boolean flag = func_149826_e((IBlockAccess)world, x, y, z - 1);
/*  52 */     boolean flag1 = func_149826_e((IBlockAccess)world, x, y, z + 1);
/*  53 */     boolean flag2 = func_149826_e((IBlockAccess)world, x - 1, y, z);
/*  54 */     boolean flag3 = func_149826_e((IBlockAccess)world, x + 1, y, z);
/*  55 */     float f = 0.375F;
/*  56 */     float f1 = 0.625F;
/*  57 */     float f2 = 0.375F;
/*  58 */     float f3 = 0.625F;
/*     */     
/*  60 */     if (flag) f2 = 0.0F; 
/*  61 */     if (flag1) f3 = 1.0F;
/*     */     
/*  63 */     if (flag || flag1) {
/*     */       
/*  65 */       func_149676_a(f, 0.0F, f2, f1, 1.5F, f3);
/*  66 */       super.func_149743_a(world, x, y, z, aaBB, list, entity);
/*     */     } 
/*     */     
/*  69 */     f2 = 0.375F;
/*  70 */     f3 = 0.625F;
/*     */     
/*  72 */     if (flag2) f = 0.0F; 
/*  73 */     if (flag3) f1 = 1.0F;
/*     */     
/*  75 */     if (flag2 || flag3 || (!flag && !flag1)) {
/*     */       
/*  77 */       func_149676_a(f, 0.0F, f2, f1, 1.5F, f3);
/*  78 */       super.func_149743_a(world, x, y, z, aaBB, list, entity);
/*     */     } 
/*     */     
/*  81 */     if (flag) f2 = 0.0F; 
/*  82 */     if (flag1) f3 = 1.0F;
/*     */     
/*  84 */     func_149676_a(f, 0.0F, f2, f1, 1.0F, f3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  91 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  92 */       list.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 107 */     for (int i = 0; i < this.woodNames.length; i++) {
/*     */       
/* 109 */       this.iconsPost[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/" + this.woodNames[i] + " Fence");
/* 110 */       this.iconsPostTop[i] = iconRegisterer.func_94245_a("terrafirmacraft:wood/" + this.woodNames[i] + " Fence Top");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 120 */     boolean flag = func_149826_e(bAccess, x, y, z - 1);
/* 121 */     boolean flag1 = func_149826_e(bAccess, x, y, z + 1);
/* 122 */     boolean flag2 = func_149826_e(bAccess, x - 1, y, z);
/* 123 */     boolean flag3 = func_149826_e(bAccess, x + 1, y, z);
/* 124 */     float f = 0.375F;
/* 125 */     float f1 = 0.625F;
/* 126 */     float f2 = 0.375F;
/* 127 */     float f3 = 0.625F;
/*     */     
/* 129 */     if (flag) f2 = 0.0F; 
/* 130 */     if (flag1) f3 = 1.0F; 
/* 131 */     if (flag2) f = 0.0F; 
/* 132 */     if (flag3) f1 = 1.0F;
/*     */     
/* 134 */     func_149676_a(f, 0.0F, f2, f1, 1.0F, f3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int par1, int par2) {
/* 150 */     if (par1 == 1) {
/* 151 */       return this.iconsPostTop[par2];
/*     */     }
/* 153 */     return this.iconsPost[par2];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/* 159 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/* 174 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 183 */     return TFCBlocks.fenceRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149826_e(IBlockAccess bAccess, int x, int y, int z) {
/* 192 */     Block block = bAccess.func_147439_a(x, y, z);
/*     */     
/* 194 */     if (TFCBlocks.canFenceConnectTo(block)) {
/* 195 */       return true;
/*     */     }
/* 197 */     return (block != this && block.func_149688_o().func_76218_k() && block.func_149686_d()) ? ((block.func_149688_o() != Material.field_151572_C)) : false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isBlockAFence(Block block) {
/* 202 */     return TFCBlocks.isBlockAFence(block);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess bAccess, int x, int y, int z, int side) {
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
/* 220 */     if (!world.field_72995_K)
/*     */     {
/* 222 */       return ItemLead.func_150909_a(player, world, x, y, z);
/*     */     }
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/* 236 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockTFCFence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */