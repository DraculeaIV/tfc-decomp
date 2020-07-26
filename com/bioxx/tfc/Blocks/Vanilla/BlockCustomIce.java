/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.TFCProvider;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockIce;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCustomIce
/*     */   extends BlockIce
/*     */ {
/*     */   private IIcon seaIce;
/*     */   
/*     */   public BlockCustomIce() {
/*  35 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/*  55 */     return world.func_147465_d(x, y, z, getBlockMelt(world, x, y, z, true), 0, 2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int i, int j, int k, Block id, int l) {
/*  76 */     super.func_149749_a(world, i, j, k, id, l);
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
/*     */   public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
/*     */     boolean isBeach, hasWater;
/* 101 */     Block plant = plantable.getPlant(world, x, y + 1, z);
/*     */     
/* 103 */     if (plant == TFCBlocks.cactus && this == TFCBlocks.cactus) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (plant == TFCBlocks.reeds && this == TFCBlocks.reeds) {
/* 107 */       return true;
/*     */     }
/* 109 */     int meta = world.func_72805_g(x, y, z);
/* 110 */     if (plantable instanceof BlockCustomLilyPad && ((BlockCustomLilyPad)plant).canThisPlantGrowOnThisBlock((Block)this, meta)) {
/* 111 */       return true;
/*     */     }
/* 113 */     EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
/* 114 */     switch (plantType) {
/*     */       case Desert:
/* 116 */         return TFC_Core.isSand((Block)this);
/* 117 */       case Nether: return (this == Blocks.field_150425_aM);
/* 118 */       case Crop: return TFC_Core.isFarmland((Block)this);
/* 119 */       case Cave: return isSideSolid(world, x, y, z, ForgeDirection.UP);
/* 120 */       case Plains: return (this == TFCBlocks.grass || this == TFCBlocks.grass2 || this == TFCBlocks.dirt || this == TFCBlocks.dirt2);
/* 121 */       case Water: return (world.func_147439_a(x, y, z).func_149688_o() == Material.field_151586_h && world.func_72805_g(x, y, z) == 0);
/*     */       case Beach:
/* 123 */         isBeach = (TFC_Core.isDirt((Block)this) || TFC_Core.isSand((Block)this));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 128 */         hasWater = (world.func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151586_h);
/* 129 */         return (isBeach && hasWater);
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightOpacity(IBlockAccess world, int x, int y, int z) {
/* 137 */     int meta = world.func_72805_g(x, y, z);
/* 138 */     if (meta == 0)
/* 139 */       return 9; 
/* 140 */     return func_149717_k();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Block getBlockMelt(World world, int i, int j, int k, boolean moving) {
/* 145 */     Block block = world.func_147439_a(i, j, k);
/*     */     
/* 147 */     if (block != this) {
/* 148 */       return block;
/*     */     }
/* 150 */     int meta = world.func_72805_g(i, j, k);
/* 151 */     switch (meta) { case 0:
/* 152 */         return TFCBlocks.saltWater;
/* 153 */       case 1: return TFCBlocks.freshWater; }
/* 154 */      return TFCBlocks.saltWater;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 162 */     this.seaIce = registerer.func_94245_a("terrafirmacraft:seaIce");
/* 163 */     super.func_149651_a(registerer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/* 170 */     if (par2 == 0) {
/* 171 */       return this.seaIce;
/*     */     }
/* 173 */     return super.func_149691_a(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random rand) {
/* 182 */     if (world.field_73011_w instanceof TFCProvider && !world.field_72995_K && world.func_147439_a(i, j, k) == this)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       ((TFCProvider)world.field_73011_w).canBlockFreeze(i, j, k, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomIce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */