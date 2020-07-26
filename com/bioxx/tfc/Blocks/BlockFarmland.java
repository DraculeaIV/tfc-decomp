/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
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
/*     */ public class BlockFarmland
/*     */   extends BlockContainer
/*     */ {
/*     */   private Block dirtBlock;
/*     */   private IIcon[] dirtTexture;
/*     */   private int textureOffset;
/*     */   
/*     */   public BlockFarmland(Block block, int tex) {
/*  41 */     super(Material.field_151578_c);
/*  42 */     func_149675_a(true);
/*  43 */     this.dirtBlock = block;
/*  44 */     this.textureOffset = tex;
/*  45 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  52 */     int count = (this.textureOffset == 0) ? 16 : (Global.STONE_ALL.length - 16);
/*  53 */     this.dirtTexture = new IIcon[count];
/*  54 */     for (int i = 0; i < count; i++) {
/*  55 */       this.dirtTexture[i] = registerer.func_94245_a("terrafirmacraft:farmland/Farmland " + Global.STONE_ALL[i + this.textureOffset]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  67 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  69 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  72 */       if (this.textureOffset == 0) { count = 16; }
/*  73 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  75 */       for (int i = 0; i < count; i++) {
/*  76 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/*  84 */     int meta = access.func_72805_g(x, y, z);
/*  85 */     if (meta < 0 || meta >= this.dirtTexture.length)
/*  86 */       meta = 0; 
/*  87 */     if (side == 1) {
/*  88 */       return this.dirtTexture[meta];
/*     */     }
/*  90 */     return this.dirtBlock.func_149691_a(side, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  97 */     if (meta < 0 || meta >= this.dirtTexture.length)
/*  98 */       meta = 0; 
/*  99 */     if (side == ForgeDirection.UP.ordinal()) {
/* 100 */       return this.dirtTexture[meta];
/*     */     }
/* 102 */     return this.dirtBlock.func_149691_a(0, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 108 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 114 */     return AxisAlignedBB.func_72330_a((x + 0), (y + 0), (z + 0), (x + 1), (y + 1), (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 120 */     return Item.func_150899_d(0);
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
/*     */ 
/*     */   
/*     */   public static boolean isFreshWaterNearby(World world, int i, int j, int k) {
/* 146 */     for (int x = i - 4; x <= i + 4; x++) {
/*     */       
/* 148 */       for (int y = j; y <= j + 1; y++) {
/*     */         
/* 150 */         for (int z = k - 4; z <= k + 4; z++) {
/*     */           
/* 152 */           if (world.func_72899_e(x, y, z)) {
/*     */             
/* 154 */             Block b = world.func_147439_a(x, y, z);
/* 155 */             if (TFC_Core.isFreshWater(b))
/* 156 */               return true; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSaltWaterNearby(World world, int i, int j, int k) {
/* 166 */     for (int x = i - 4; x <= i + 4; x++) {
/*     */       
/* 168 */       for (int y = j; y <= j + 1; y++) {
/*     */         
/* 170 */         for (int z = k - 4; z <= k + 4; z++) {
/*     */           
/* 172 */           Block b = world.func_147439_a(x, y, z);
/* 173 */           if (TFC_Core.isSaltWater(b))
/* 174 */             return true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 184 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 190 */     return (TileEntity)new TEFarmland();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
/* 196 */     Block plant = plantable.getPlant(world, x, y + 1, z);
/* 197 */     if (plant == Blocks.field_150393_bb || plant == Blocks.field_150394_bc) {
/* 198 */       return false;
/*     */     }
/* 200 */     EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
/* 201 */     if (plantType == EnumPlantType.Crop) {
/* 202 */       return true;
/*     */     }
/* 204 */     return super.canSustainPlant(world, x, y, z, direction, plantable);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockFarmland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */