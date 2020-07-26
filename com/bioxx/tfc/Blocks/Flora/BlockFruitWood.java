/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFruitWood
/*     */   extends BlockTerraContainer
/*     */ {
/*  30 */   private IIcon[] icons = new IIcon[Global.FRUIT_META_NAMES.length];
/*     */ 
/*     */   
/*     */   public BlockFruitWood() {
/*  34 */     super(Material.field_151575_d);
/*  35 */     func_149676_a(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkOut(World world, int i, int j, int k, int l) {
/*  40 */     return (world.func_147439_a(i, j, k) == this && world.func_72805_g(i, j, k) == l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int j) {
/*  46 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  52 */     return this.icons[j];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  58 */     for (int i = 0; i < 9; i++) {
/*  59 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/fruit trees/" + Global.FRUIT_META_NAMES[i] + " Wood");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/*  66 */     boolean isAxeorSaw = false;
/*  67 */     ItemStack equip = entityplayer.func_71045_bC();
/*  68 */     if (equip != null) {
/*     */       
/*  70 */       int[] equipIDs = OreDictionary.getOreIDs(equip);
/*  71 */       for (int id : equipIDs) {
/*     */         
/*  73 */         String name = OreDictionary.getOreName(id);
/*  74 */         if (name.startsWith("itemAxe") || name.startsWith("itemSaw")) {
/*     */           
/*  76 */           isAxeorSaw = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  81 */     if (isAxeorSaw) {
/*     */       
/*  83 */       int x = i;
/*  84 */       int y = 0;
/*  85 */       int z = k;
/*     */ 
/*     */       
/*  88 */       if (world.func_147439_a(i, j + 1, k) == this || world.func_147439_a(i, j - 1, k) == this) {
/*     */ 
/*     */         
/*  91 */         boolean[][][] checkArray = new boolean[11][50][11];
/*     */         
/*  93 */         if (TFC_Core.isGrass(world.func_147439_a(i, j + y - 1, k)) || TFC_Core.isDirt(world.func_147439_a(i, j + y - 1, k))) {
/*     */           
/*  95 */           boolean reachedTop = false;
/*  96 */           while (!reachedTop)
/*     */           {
/*  98 */             if (world.func_147437_c(x, j + y + 1, z))
/*     */             {
/* 100 */               reachedTop = true;
/*     */             }
/* 102 */             scanLogs(world, i, j + y, k, l, checkArray, 6, y, 6);
/* 103 */             y++;
/*     */           }
/*     */         
/*     */         } 
/* 107 */       } else if (world.func_147439_a(i + 1, j, k) == this || world
/* 108 */         .func_147439_a(i - 1, j, k) == this || world
/* 109 */         .func_147439_a(i, j, k + 1) == this || world
/* 110 */         .func_147439_a(i, j, k - 1) == this) {
/*     */         
/* 112 */         Random r = new Random();
/* 113 */         if (r.nextInt(100) > 50 && isAxeorSaw) {
/*     */           
/* 115 */           if (l < 8 && (world
/* 116 */             .func_147439_a(i + 1, j, k) == TFCBlocks.fruitTreeLeaves2 || world
/* 117 */             .func_147439_a(i - 1, j, k) == TFCBlocks.fruitTreeLeaves2 || world
/* 118 */             .func_147439_a(i, j, k + 1) == TFCBlocks.fruitTreeLeaves2 || world
/* 119 */             .func_147439_a(i, j, k - 1) == TFCBlocks.fruitTreeLeaves2 || world
/* 120 */             .func_147439_a(i, j + 1, k) == TFCBlocks.fruitTreeLeaves2 || world
/* 121 */             .func_147439_a(i, j - 1, k) == TFCBlocks.fruitTreeLeaves2))
/*     */           {
/* 123 */             l += 8;
/*     */           }
/* 125 */           func_149642_a(world, i, j, k, new ItemStack(TFCItems.fruitTreeSapling, 1, l));
/*     */         } 
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
/*     */   public Item func_149650_a(int i, Random random, int j) {
/* 138 */     return TFCItems.logs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block block) {
/* 144 */     boolean check = false;
/* 145 */     for (int h = -1; h <= 1; h++) {
/*     */       
/* 147 */       for (int g = -1; g <= 1; g++) {
/*     */         
/* 149 */         for (int f = -1; f <= 1; f++) {
/*     */           
/* 151 */           if (world.func_147439_a(i + h, j + g, k + f) == this && world.func_72805_g(i + h, j + g, k + f) == world.func_72805_g(i, j, k))
/* 152 */             check = true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 156 */     if (!check) {
/* 157 */       world.func_147468_f(i, j, k);
/*     */     }
/*     */   }
/*     */   
/*     */   private void scanLogs(World world, int i, int j, int k, int l, boolean[][][] checkArray, int x, int y, int z) {
/* 162 */     if (y >= 0) {
/*     */       
/* 164 */       checkArray[x][y][z] = true;
/* 165 */       int offsetX = 0;
/* 166 */       int offsetY = 0;
/* 167 */       int offsetZ = 0;
/*     */       
/* 169 */       for (offsetY = 0; offsetY <= 1; offsetY++) {
/*     */         
/* 171 */         for (offsetX = -1; offsetX <= 1; offsetX++) {
/*     */           
/* 173 */           for (offsetZ = -1; offsetZ <= 1; offsetZ++) {
/*     */             
/* 175 */             if (x + offsetX < 11 && x + offsetX >= 0 && z + offsetZ < 11 && z + offsetZ >= 0 && y + offsetY < 50 && y + offsetY >= 0)
/*     */             {
/* 177 */               if (checkOut(world, i + offsetX, j + offsetY, k + offsetZ, l) && !checkArray[x + offsetX][y + offsetY][z + offsetZ])
/* 178 */                 scanLogs(world, i + offsetX, j + offsetY, k + offsetZ, l, checkArray, x + offsetX, y + offsetY, z + offsetZ); 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 183 */       world.func_147468_f(i, j, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 190 */     return TFCBlocks.woodFruitRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 208 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/* 214 */     if (world.func_147439_a(i, j - 1, k) == this || world.func_147439_a(i, j - 1, k).func_149662_c())
/* 215 */       return AxisAlignedBB.func_72330_a(i + 0.3D, j, k + 0.3D, i + 0.7D, (j + 1), k + 0.7D); 
/* 216 */     return AxisAlignedBB.func_72330_a(i, j + 0.4D, k, (i + 1), j + 0.6D, (k + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int i, int j, int k) {
/* 222 */     if (world.func_147439_a(i, j - 1, k) == this || world.func_147439_a(i, j - 1, k).func_149662_c())
/* 223 */       return AxisAlignedBB.func_72330_a(i + 0.3D, j, k + 0.3D, i + 0.7D, (j + 1), k + 0.7D); 
/* 224 */     return AxisAlignedBB.func_72330_a(i, j + 0.4D, k, (i + 1), j + 0.6D, (k + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess world, int i, int j, int k) {
/* 233 */     if (world.func_147439_a(i, j - 1, k) == this || world.func_147439_a(i, j - 1, k).func_149662_c()) {
/* 234 */       func_149676_a(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
/*     */     } else {
/* 236 */       func_149676_a(0.0F, 0.4F, 0.0F, 1.0F, 0.6F, 1.0F);
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
/*     */   public void func_149674_a(World world, int i, int j, int k, Random rand) {}
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
/*     */   public static String getType(int meta) {
/* 377 */     switch (meta) {
/*     */       case 0:
/* 379 */         return Global.FRUIT_META_NAMES[0];
/* 380 */       case 1: return Global.FRUIT_META_NAMES[1];
/* 381 */       case 2: return Global.FRUIT_META_NAMES[2];
/* 382 */       case 3: return Global.FRUIT_META_NAMES[3];
/* 383 */       case 4: return Global.FRUIT_META_NAMES[4];
/* 384 */       case 5: return Global.FRUIT_META_NAMES[5];
/* 385 */       case 6: return Global.FRUIT_META_NAMES[6];
/* 386 */       case 7: return Global.FRUIT_META_NAMES[7];
/* 387 */       case 8: return Global.FRUIT_META_NAMES[8];
/*     */     } 
/* 389 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 395 */     return (TileEntity)new TEFruitTreeWood();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block block, int metadata) {
/* 401 */     if (!world.field_72995_K && checkOut(world, x, y - 1, z, metadata) && world.func_147438_o(x, y - 1, z) != null)
/* 402 */       ((TEFruitTreeWood)world.func_147438_o(x, y - 1, z)).initBirth(); 
/* 403 */     super.func_149749_a(world, x, y, z, block, metadata);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 409 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockFruitWood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */