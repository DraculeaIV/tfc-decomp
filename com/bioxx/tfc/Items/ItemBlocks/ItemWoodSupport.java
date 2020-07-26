/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockWoodSupport;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class ItemWoodSupport
/*     */   extends ItemTerraBlock {
/*     */   public ItemWoodSupport(Block par1) {
/*  20 */     super(par1);
/*  21 */     this.field_77787_bX = true;
/*  22 */     func_77656_e(0);
/*  23 */     this.metaNames = new String[16];
/*  24 */     System.arraycopy(Global.WOOD_ALL, 0, this.metaNames, 0, 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  29 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  35 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block getBlock() {
/*  40 */     return this.field_150939_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValidUnder(World world, int x, int y, int z, int side) {
/*  45 */     if (side == 0) {
/*  46 */       y--;
/*  47 */     } else if (side == 1) {
/*  48 */       y++;
/*  49 */     } else if (side == 2) {
/*  50 */       z--;
/*  51 */     } else if (side == 3) {
/*  52 */       z++;
/*  53 */     } else if (side == 4) {
/*  54 */       x--;
/*  55 */     } else if (side == 5) {
/*  56 */       x++;
/*     */     } 
/*  58 */     Block b = world.func_147439_a(x, y - 1, z);
/*  59 */     return (b == TFCBlocks.woodSupportV || b == TFCBlocks.woodSupportV2 || b.isSideSolid((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  65 */     if (y < 250 && y > 0 && side == 1 && isValidUnder(world, x, y, z, side)) {
/*     */       
/*  67 */       if (!player.func_70093_af() && world.func_147437_c(x, y + 1, z) && world.func_147437_c(x, y + 2, z) && world.func_147437_c(x, y + 3, z) && itemstack.field_77994_a >= 3 && world
/*  68 */         .func_147439_a(x, y, z) != TFCBlocks.woodSupportV && world.func_147439_a(x, y, z) != TFCBlocks.woodSupportV2) {
/*     */         
/*  70 */         placeBlockAt(getBlock(), itemstack, player, world, x, y + 1, z, itemstack.func_77960_j(), 2);
/*  71 */         placeBlockAt(getBlock(), itemstack, player, world, x, y + 2, z, itemstack.func_77960_j(), 2);
/*  72 */         placeBlockAt(getBlock(), itemstack, player, world, x, y + 3, z, itemstack.func_77960_j(), 2);
/*  73 */         itemstack.field_77994_a -= 3;
/*  74 */         return true;
/*     */       } 
/*     */ 
/*     */       
/*  78 */       placeBlockAt(getBlock(), itemstack, player, world, x, y + 1, z, itemstack.func_77960_j(), 3);
/*  79 */       itemstack.field_77994_a--;
/*  80 */       return true;
/*     */     } 
/*     */     
/*  83 */     if (y < 255 && y > 0 && side == 0) {
/*     */       
/*  85 */       boolean shouldGen = false;
/*  86 */       int dist = 0;
/*  87 */       for (dist = 1; dist <= 20 && !shouldGen; dist++) {
/*     */         
/*  89 */         if (!world.func_147439_a(x, y - dist, z).isReplaceable((IBlockAccess)world, x, y - dist, z)) {
/*     */ 
/*     */ 
/*     */           
/*  93 */           if (world.func_147439_a(x, y - dist, z).isSideSolid((IBlockAccess)world, x, y - dist, z, ForgeDirection.UP))
/*     */           {
/*  95 */             shouldGen = true;
/*     */           }
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 104 */       if (itemstack.field_77994_a >= dist - 1) {
/* 105 */         for (int j = dist - 1; j >= 1 && shouldGen;) {
/*     */           
/* 107 */           if (world.func_147439_a(x, y - j, z).isReplaceable((IBlockAccess)world, x, y - j, z)) {
/*     */             
/* 109 */             placeBlockAt(getBlock(), itemstack, player, world, x, y - j, z, itemstack.func_77960_j(), 3);
/* 110 */             itemstack.field_77994_a--;
/* 111 */             world.func_147471_g(x, y - j, z);
/*     */             
/*     */             j--;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/* 118 */       Block b = TFCBlocks.woodSupportH;
/* 119 */       if (getBlock() == TFCBlocks.woodSupportV2) {
/* 120 */         b = TFCBlocks.woodSupportH2;
/*     */       }
/* 122 */       if (side == 0) {
/* 123 */         y--;
/* 124 */       } else if (side == 1) {
/* 125 */         y++;
/* 126 */       } else if (side == 2) {
/* 127 */         z--;
/* 128 */       } else if (side == 3) {
/* 129 */         z++;
/* 130 */       } else if (side == 4) {
/* 131 */         x--;
/* 132 */       } else if (side == 5) {
/* 133 */         x++;
/*     */       } 
/* 135 */       if (y == 255 && b.func_149688_o().func_76220_a())
/*     */       {
/* 137 */         return false;
/*     */       }
/* 139 */       if (world.func_147472_a(b, x, y, z, false, side, (Entity)player, itemstack)) {
/*     */         
/* 141 */         ForgeDirection dir = BlockWoodSupport.getSupportDirection(world, x, y, z);
/*     */         
/* 143 */         int[] dist = BlockWoodSupport.getSupportsInRangeDir(world, x, y, z, 5, false);
/* 144 */         int total = BlockWoodSupport.getDistanceFromDirection(dir, dist);
/* 145 */         if (total == Integer.MAX_VALUE) {
/*     */           
/* 147 */           total = 1;
/* 148 */           dir = ForgeDirection.getOrientation(side);
/*     */         } 
/* 150 */         if (itemstack.field_77994_a < total)
/* 151 */           return false; 
/* 152 */         int i1 = func_77647_b(itemstack.func_77960_j());
/* 153 */         int count = 0;
/*     */         
/*     */         do {
/* 156 */           int j1 = b.func_149660_a(world, x + dir.offsetX * count, y, z + dir.offsetZ * count, side, hitX, hitY, hitZ, i1);
/* 157 */           if (!placeBlockAt(b, itemstack, player, world, x + dir.offsetX * count, y, z + dir.offsetZ * count, j1, 2))
/*     */             continue; 
/* 159 */           world.func_72908_a((x + (dir.offsetX * count) + 0.5F), (y + 0.5F), (z + (dir.offsetZ * count) + 0.5F), b.field_149762_H.func_150496_b(), (b.field_149762_H.func_150497_c() + 1.0F) / 2.0F, b.field_149762_H.func_150494_d() * 0.8F);
/* 160 */           itemstack.field_77994_a--;
/*     */           
/* 162 */           ++count;
/* 163 */         } while (count < total);
/*     */ 
/*     */ 
/*     */         
/* 167 */         return true;
/*     */       } 
/*     */     } 
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean placeBlockAt(Block b, ItemStack is, EntityPlayer player, World world, int x, int y, int z, int metadata, int flag) {
/* 175 */     if (!world.func_147465_d(x, y, z, b, metadata, flag))
/*     */     {
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     if (world.func_147439_a(x, y, z) == b) {
/*     */       
/* 182 */       b.func_149689_a(world, x, y, z, (EntityLivingBase)player, is);
/* 183 */       b.func_149714_e(world, x, y, z, metadata);
/*     */     } 
/*     */     
/* 186 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemWoodSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */