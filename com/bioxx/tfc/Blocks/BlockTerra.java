/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public abstract class BlockTerra
/*     */   extends Block
/*     */ {
/*     */   protected BlockTerra() {
/*  27 */     super(Material.field_151576_e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected BlockTerra(Material material) {
/*  32 */     super(material);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack is) {
/*  39 */     if (TFCOptions.enableDebugMode && world.field_72995_K) {
/*     */       
/*  41 */       int metadata = world.func_72805_g(x, y, z);
/*  42 */       TerraFirmaCraft.LOG.info("Meta=" + func_149739_a() + ":" + metadata);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  55 */     if (TFCOptions.enableDebugMode && world.field_72995_K) {
/*     */       
/*  57 */       int metadata = world.func_72805_g(x, y, z);
/*  58 */       TerraFirmaCraft.LOG.info("Meta = " + func_149739_a() + ":" + metadata);
/*     */     } 
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving) {
/*  65 */     func_149689_a(world, x, y, z, (EntityLivingBase)entityliving, (ItemStack)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer player, int x, int y, int z, int meta) {
/*  71 */     super.func_149636_a(world, player, x, y, z, meta);
/*  72 */     TFC_Core.addPlayerExhaustion(player, 0.001F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
/*     */     boolean isBeach, hasWater;
/*  78 */     Block plant = plantable.getPlant(world, x, y + 1, z);
/*  79 */     if (plant == Blocks.field_150434_aF && this == Blocks.field_150434_aF)
/*     */     {
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     if (plant == Blocks.field_150436_aH && this == Blocks.field_150436_aH)
/*     */     {
/*  86 */       return true;
/*     */     }
/*     */     
/*  89 */     EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
/*  90 */     switch (plantType) {
/*     */       case Cave:
/*  92 */         return isSideSolid(world, x, y, z, ForgeDirection.UP);
/*  93 */       case Plains: return (TFC_Core.isSoil(this) || TFC_Core.isFarmland(this));
/*  94 */       case Water: return (world.func_147439_a(x, y, z).func_149688_o() == Material.field_151586_h && world.func_72805_g(x, y, z) == 0);
/*     */       case Beach:
/*  96 */         isBeach = (TFC_Core.isSand(this) || TFC_Core.isGravel(this));
/*     */ 
/*     */ 
/*     */         
/* 100 */         hasWater = (world.func_147439_a(x - 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x + 1, y, z).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z - 1).func_149688_o() == Material.field_151586_h || world.func_147439_a(x, y, z + 1).func_149688_o() == Material.field_151586_h);
/* 101 */         return (isBeach && hasWater);
/* 102 */     }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockTerra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */