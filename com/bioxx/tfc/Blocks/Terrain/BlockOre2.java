/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockOre2
/*     */   extends BlockOre
/*     */ {
/*     */   public BlockOre2(Material mat) {
/*  20 */     super(mat);
/*  21 */     this.blockNames = Global.ORE_MINERAL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  27 */     return dmg + Global.ORE_METAL.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(int meta, int fortune, Random random) {
/*  33 */     if (meta == 13)
/*  34 */       return 1 + random.nextInt(3); 
/*  35 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  41 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/*  43 */     int count = quantityDropped(metadata, fortune, world.field_73012_v);
/*  44 */     for (int i = 0; i < count; i++) {
/*     */       
/*  46 */       ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(metadata));
/*     */       
/*  48 */       if (metadata == 5) {
/*  49 */         itemstack = kimberliteGemSpawn();
/*  50 */       } else if (metadata == 13) {
/*  51 */         itemstack = new ItemStack(TFCItems.powder, 1, 4);
/*     */       } 
/*  53 */       if (itemstack != null)
/*     */       {
/*  55 */         ret.add(itemstack);
/*     */       }
/*     */     } 
/*  58 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/*  64 */     if (!world.field_72995_K) {
/*     */       
/*  66 */       boolean dropOres = false;
/*  67 */       if (player != null) {
/*     */         
/*  69 */         player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/*  70 */         player.func_71020_j(0.075F);
/*  71 */         dropOres = player.func_146099_a((Block)this);
/*     */       } 
/*  73 */       if (player == null || dropOres) {
/*     */         
/*  75 */         int meta = world.func_72805_g(x, y, z);
/*  76 */         Random random = new Random();
/*     */         
/*  78 */         ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(meta));
/*     */         
/*  80 */         if (meta == 5) {
/*  81 */           itemstack = kimberliteGemSpawn();
/*  82 */         } else if (meta == 13) {
/*  83 */           itemstack = new ItemStack(TFCItems.powder, 1 + random.nextInt(3), 4);
/*     */         } 
/*  85 */         if (itemstack != null) {
/*  86 */           func_149642_a(world, x, y, z, itemstack);
/*     */         }
/*     */       } 
/*     */     } 
/*  90 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack kimberliteGemSpawn() {
/*  95 */     int quality = 0;
/*  96 */     Random random = new Random();
/*  97 */     if (random.nextInt(50) == 0) {
/*  98 */       quality = 1;
/*  99 */     } else if (random.nextInt(75) == 0) {
/* 100 */       quality = 2;
/* 101 */     } else if (random.nextInt(150) == 0) {
/* 102 */       quality = 3;
/* 103 */     } else if (random.nextInt(300) == 0) {
/* 104 */       quality = 4;
/*     */     } 
/* 106 */     return new ItemStack(TFCItems.gemDiamond, 1, quality);
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
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion exp) {
/* 157 */     Random random = new Random();
/*     */     
/* 159 */     int meta = world.func_72805_g(x, y, z);
/* 160 */     ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + 16);
/*     */     
/* 162 */     if (meta == 5) {
/* 163 */       itemstack = kimberliteGemSpawn();
/* 164 */     } else if (meta == 13) {
/* 165 */       itemstack = new ItemStack(TFCItems.powder, 1 + random.nextInt(3), 4);
/*     */     } 
/* 167 */     if (itemstack != null) {
/* 168 */       func_149642_a(world, x, y, z, itemstack);
/*     */     }
/* 170 */     func_149723_a(world, x, y, z, exp);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockOre2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */