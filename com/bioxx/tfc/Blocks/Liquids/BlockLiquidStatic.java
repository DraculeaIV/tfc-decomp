/*     */ package com.bioxx.tfc.Blocks.Liquids;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLiquid;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLiquidStatic
/*     */   extends BlockLiquid
/*     */   implements IFluidBlock
/*     */ {
/*     */   private Block flowing;
/*     */   protected Fluid fluidType;
/*     */   protected IIcon[] icons;
/*     */   
/*     */   public BlockLiquidStatic(Fluid fluid, Material material, Block f) {
/*  37 */     super(material);
/*  38 */     this.flowing = f;
/*  39 */     this.fluidType = fluid;
/*  40 */     func_149675_a(true);
/*  41 */     fluid.setBlock((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Fluid getFluid() {
/*  47 */     return this.fluidType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
/*  53 */     if (!isDrainableSourceBlock((IBlockAccess)world, x, y, z))
/*     */     {
/*  55 */       return null;
/*     */     }
/*     */     
/*  58 */     if (doDrain)
/*     */     {
/*  60 */       world.func_147449_b(x, y, z, Blocks.field_150350_a);
/*     */     }
/*     */     
/*  63 */     return new FluidStack(this.fluidType, 1000);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrain(World world, int x, int y, int z) {
/*  69 */     return isDrainableSourceBlock((IBlockAccess)world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFilledPercentage(World world, int x, int y, int z) {
/*  75 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  82 */     if (this.field_149764_J != Material.field_151586_h) {
/*  83 */       return 16777215;
/*     */     }
/*  85 */     return 3493173;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity e) {
/*  91 */     if (this.field_149764_J == Material.field_151587_i)
/*     */     {
/*  93 */       if (e instanceof net.minecraft.entity.item.EntityItem)
/*     */       {
/*  95 */         e.func_70015_d(15);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 107 */     super.func_149695_a(world, x, y, z, b);
/*     */     
/* 109 */     if (world.func_147439_a(x, y, z) == this)
/*     */     {
/* 111 */       setNotStationary(world, x, y, z);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 118 */     if (!world.field_72995_K) {
/*     */       
/* 120 */       if (world.func_147437_c(x, y + 1, z))
/*     */       {
/* 122 */         world.field_73011_w.canBlockFreeze(x, y, z, false);
/*     */       }
/*     */ 
/*     */       
/* 126 */       if (world.func_147439_a(x, y, z) == TFCBlocks.freshWaterStationary && world
/* 127 */         .func_147437_c(x, y + 1, z) && 
/* 128 */         TFC_Climate.getHeightAdjustedTemp(world, x, y + 1, z) > 2.0F)
/*     */       {
/* 130 */         if (rand.nextInt(100) < 25 && world.func_72957_l(x, y, z) < 7)
/*     */         {
/*     */           
/* 133 */           for (int x1 = x - 3; x1 < x + 3; x1++) {
/*     */             
/* 135 */             for (int z1 = z - 3; z1 < z + 3; z1++) {
/*     */               
/* 137 */               if (TFC_Core.isGrass(world.func_147439_a(x1, y, z1)) || world.func_147439_a(x1, y - 1, z1) == TFCBlocks.waterPlant) {
/*     */                 
/* 139 */                 float mod = rand.nextFloat();
/* 140 */                 world.func_72908_a(x, y, z, "terrafirmacraft:mob.frog", (mod < 0.55F) ? mod : 0.55F, (mod < 0.41F) ? (mod + 0.8F) : 0.8F);
/*     */                 
/*     */                 // Byte code: goto -> 228
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/* 148 */       if (func_149688_o() == Material.field_151587_i)
/*     */       {
/* 150 */         if (world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151579_a) {
/*     */           
/* 152 */           int i = x - 2 + rand.nextInt(5);
/* 153 */           int j = y + 1 + rand.nextInt(4);
/* 154 */           int k = z - 2 + rand.nextInt(5);
/*     */           
/* 156 */           if (world.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a)
/*     */           {
/* 158 */             if (isFlammable(world, i - 1, j, k) || isFlammable(world, i + 1, j, k) || 
/* 159 */               isFlammable(world, i, j, k - 1) || isFlammable(world, i, j, k + 1) || 
/* 160 */               isFlammable(world, i, j - 1, k) || isFlammable(world, i, j + 1, k)) {
/*     */               
/* 162 */               world.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*     */             }
/* 164 */             else if (world.isSideSolid(i, j + 1, k, ForgeDirection.DOWN) || world.isSideSolid(i, j - 1, k, ForgeDirection.UP) || world
/* 165 */               .isSideSolid(i - 1, j, k, ForgeDirection.EAST) || world.isSideSolid(i + 1, j, k, ForgeDirection.WEST) || world
/* 166 */               .isSideSolid(i, j, k + 1, ForgeDirection.NORTH) || world.isSideSolid(i, j, k - 1, ForgeDirection.SOUTH)) {
/*     */               
/* 168 */               world.func_147465_d(i, j, k, TFCBlocks.sulfur, world.field_73012_v.nextInt(4), 3);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 173 */           int distance = rand.nextInt(3);
/*     */           
/*     */           int xCoord;
/* 176 */           for (xCoord = 0; xCoord < distance; xCoord++) {
/*     */             
/* 178 */             x += rand.nextInt(3) - 1;
/* 179 */             y++;
/* 180 */             z += rand.nextInt(3) - 1;
/* 181 */             Block block = world.func_147439_a(x, y, z);
/*     */             
/* 183 */             if (block.func_149688_o() == Material.field_151579_a) {
/*     */               
/* 185 */               if (isFlammable(world, x - 1, y, z) || isFlammable(world, x + 1, y, z) || 
/* 186 */                 isFlammable(world, x, y, z - 1) || isFlammable(world, x, y, z + 1) || 
/* 187 */                 isFlammable(world, x, y - 1, z) || isFlammable(world, x, y + 1, z)) {
/*     */                 
/* 189 */                 world.func_147449_b(x, y, z, (Block)Blocks.field_150480_ab);
/*     */                 
/*     */                 return;
/*     */               } 
/* 193 */             } else if (block.func_149688_o().func_76230_c()) {
/*     */               return;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 199 */           if (distance == 0) {
/*     */             
/* 201 */             xCoord = x;
/* 202 */             int zCoord = z;
/*     */             
/* 204 */             for (int c = 0; c < 3; c++) {
/*     */               
/* 206 */               x = xCoord + rand.nextInt(3) - 1;
/* 207 */               z = zCoord + rand.nextInt(3) - 1;
/*     */               
/* 209 */               if (world.func_147437_c(x, y + 1, z) && isFlammable(world, x, y, z))
/*     */               {
/* 211 */                 world.func_147449_b(x, y + 1, z, (Block)Blocks.field_150480_ab);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 219 */     super.func_149674_a(world, x, y, z, rand);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isFlammable(World world, int x, int y, int z) {
/* 228 */     return (Blocks.field_150480_ab.getFlammability(world.func_147439_a(x, y, z)) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setNotStationary(World world, int x, int y, int z) {
/* 236 */     int l = world.func_72805_g(x, y, z);
/* 237 */     world.func_147465_d(x, y, z, this.flowing, l, 2);
/* 238 */     world.func_147464_a(x, y, z, this.flowing, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 245 */     if (func_149688_o() == Material.field_151587_i) {
/* 246 */       this.icons = new IIcon[] { registerer.func_94245_a("lava_still"), registerer.func_94245_a("lava_flow") };
/*     */     } else {
/* 248 */       this.icons = new IIcon[] { registerer.func_94245_a("water_still"), registerer.func_94245_a("water_flow") };
/* 249 */     }  getFluid().setIcons(this.icons[0], this.icons[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 256 */     return (side != 0 && side != 1) ? this.icons[1] : this.icons[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDrainableSourceBlock(IBlockAccess world, int x, int y, int z) {
/* 261 */     Block block = world.func_147439_a(x, y, z);
/* 262 */     return (!TFC_Core.isHotWater(block) && block == this && world.func_72805_g(x, y, z) == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Liquids\BlockLiquidStatic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */