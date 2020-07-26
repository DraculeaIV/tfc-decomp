/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockMushroom;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenBigMushroom;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFungi
/*     */   extends BlockMushroom
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] icons;
/*     */   
/*     */   public BlockFungi() {
/*  33 */     float var3 = 0.2F;
/*  34 */     func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
/*  35 */     func_149675_a(true);
/*  36 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/*  46 */     if (par2 >= this.icons.length) par2 = 0; 
/*  47 */     return this.icons[par2];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/*  54 */     this.icons = new IIcon[Global.FUNGI_META_NAMES.length];
/*  55 */     for (int i = 0; i < this.icons.length; i++)
/*     */     {
/*     */       
/*  58 */       this.icons[i] = register.func_94245_a(((this.icons.length > 2) ? "terrafirmacraft:plants/" : "") + Global.FUNGI_META_NAMES[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int par1) {
/*  68 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> list) {
/*  78 */     for (int i = 0; i < this.icons.length; i++)
/*     */     {
/*  80 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/*  90 */     if (y >= 0 && y < 256) {
/*     */       
/*  92 */       Block var5 = world.func_147439_a(x, y - 1, z);
/*  93 */       return (var5 == Blocks.field_150391_bh || (world.func_72883_k(x, y, z) < 13 && canThisPlantGrowOnThisBlock(var5)));
/*     */     } 
/*     */ 
/*     */     
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlock(Block block) {
/* 103 */     return (TFC_Core.isSoil(block) || TFC_Core.isFarmland(block));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int x, int y, int z) {
/* 112 */     Block var5 = world.func_147439_a(x, y, z);
/* 113 */     return ((world.func_147437_c(x, y, z) || var5.func_149688_o().func_76222_j()) && 
/* 114 */       canThisPlantGrowOnThisBlock(var5) && 
/* 115 */       func_149718_j(world, x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149884_c(World world, int x, int y, int z, Random rnd) {
/* 124 */     Block block = world.func_147439_a(x, y, z);
/* 125 */     int meta = world.func_72805_g(x, y, z);
/* 126 */     WorldGenBigMushroom bigGen = null;
/*     */     
/* 128 */     world.func_147468_f(x, y, z);
/*     */     
/* 130 */     if (this == block && meta == 0) {
/* 131 */       bigGen = new WorldGenBigMushroom(0);
/* 132 */     } else if (this == block && meta == 1) {
/* 133 */       bigGen = new WorldGenBigMushroom(1);
/*     */     } 
/* 135 */     if (bigGen != null && bigGen.func_76484_a(world, rnd, x, y, z))
/*     */     {
/* 137 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 141 */     world.func_147465_d(x, y, z, (Block)this, meta, 3);
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rnd) {
/* 152 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 154 */     if (rnd.nextInt(25) == 0) {
/*     */       
/* 156 */       byte var6 = 4;
/* 157 */       int var7 = 5;
/*     */ 
/*     */       
/*     */       int i;
/*     */ 
/*     */       
/* 163 */       for (i = x - var6; i <= x + var6; i++) {
/*     */         
/* 165 */         for (int m = z - var6; m <= z + var6; m++) {
/*     */           
/* 167 */           for (int n = y - 1; n <= y + 1; n++) {
/*     */             
/* 169 */             if (world.func_72899_e(i, n, m) && world.func_147439_a(i, n, m) == this) {
/*     */               
/* 171 */               var7--;
/* 172 */               if (var7 <= 0) {
/*     */                 return;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 179 */       i = x + rnd.nextInt(3) - 1;
/* 180 */       int j = y + rnd.nextInt(2) - rnd.nextInt(2);
/* 181 */       int k = z + rnd.nextInt(3) - 1;
/*     */       
/* 183 */       for (int var11 = 0; var11 < 4; var11++) {
/*     */         
/* 185 */         if (world.func_72899_e(i, j, k) && world.func_147437_c(i, j, k) && func_149718_j(world, i, j, k)) {
/*     */           
/* 187 */           x = i;
/* 188 */           y = j;
/* 189 */           z = k;
/*     */         } 
/*     */         
/* 192 */         i = x + rnd.nextInt(3) - 1;
/* 193 */         j = y + rnd.nextInt(2) - rnd.nextInt(2);
/* 194 */         k = z + rnd.nextInt(3) - 1;
/*     */       } 
/*     */       
/* 197 */       if (world.func_72899_e(i, j, k) && world.func_147437_c(i, j, k) && func_149718_j(world, i, j, k))
/* 198 */         world.func_147465_d(i, j, k, (Block)this, meta, 2); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockFungi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */