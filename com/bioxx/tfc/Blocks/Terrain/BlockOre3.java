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
/*     */ public class BlockOre3
/*     */   extends BlockOre
/*     */ {
/*     */   public BlockOre3(Material material) {
/*  20 */     super(material);
/*  21 */     this.blockNames = Global.ORE_MINERAL2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  27 */     return dmg + Global.ORE_METAL.length + Global.ORE_MINERAL.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int quantityDropped(int meta, int fortune, Random random) {
/*  33 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  39 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/*  41 */     int count = quantityDropped(metadata, fortune, world.field_73012_v);
/*  42 */     for (int i = 0; i < count; i++) {
/*     */       
/*  44 */       ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(metadata));
/*  45 */       ret.add(itemstack);
/*     */     } 
/*  47 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/*  53 */     if (!world.field_72995_K) {
/*     */       
/*  55 */       boolean dropOres = false;
/*  56 */       if (player != null) {
/*     */         
/*  58 */         player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/*  59 */         player.func_71020_j(0.075F);
/*  60 */         dropOres = player.func_146099_a((Block)this);
/*     */       } 
/*     */       
/*  63 */       if (player == null || dropOres) {
/*     */         
/*  65 */         int meta = world.func_72805_g(x, y, z);
/*  66 */         ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(meta));
/*  67 */         func_149642_a(world, x, y, z, itemstack);
/*     */       } 
/*     */     } 
/*  70 */     return world.func_147468_f(x, y, z);
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
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion exp) {
/* 122 */     int meta = world.func_72805_g(x, y, z);
/* 123 */     ItemStack itemstack = new ItemStack(TFCItems.oreChunk, 1, meta + 32);
/* 124 */     func_149642_a(world, x, y, z, itemstack);
/* 125 */     func_149723_a(world, x, y, z, exp);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockOre3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */