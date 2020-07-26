/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockDirt
/*     */   extends BlockTerra
/*     */ {
/*     */   protected IIcon[] icons;
/*     */   protected int textureOffset;
/*     */   
/*     */   public BlockDirt(int texOff) {
/*  32 */     super(Material.field_151578_c);
/*  33 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  34 */     this.textureOffset = texOff;
/*  35 */     func_149675_a(true);
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
/*  46 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  48 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  51 */       if (this.textureOffset == 0) { count = 16; }
/*  52 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  54 */       for (int i = 0; i < count; i++) {
/*  55 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  62 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/*  68 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/*  74 */     int meta = bAccess.func_72805_g(x, y, z);
/*  75 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  76 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  82 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  83 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  89 */     int count = (this.textureOffset == 0) ? 16 : (Global.STONE_ALL.length - 16);
/*  90 */     this.icons = new IIcon[count];
/*  91 */     for (int i = 0; i < count; i++) {
/*  92 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:soil/Dirt " + Global.STONE_ALL[i + this.textureOffset]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/*  98 */     world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 104 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random random) {
/* 110 */     if (!world.field_72995_K && world.func_72873_a(i, j, k, 1) && !BlockCollapsible.isNearSupport(world, i, j, k, 4, 0.0F).booleanValue()) {
/*     */       
/* 112 */       int meta = world.func_72805_g(i, j, k);
/*     */       
/* 114 */       boolean canFallOneBelow = BlockCollapsible.canFallBelow(world, i, j - 1, k);
/* 115 */       byte count = 0;
/* 116 */       List<Integer> sides = new ArrayList<Integer>();
/*     */       
/* 118 */       if (world.func_147437_c(i + 1, j, k)) {
/*     */         
/* 120 */         count = (byte)(count + 1);
/* 121 */         if (BlockCollapsible.canFallBelow(world, i + 1, j - 1, k))
/* 122 */           sides.add(Integer.valueOf(0)); 
/*     */       } 
/* 124 */       if (world.func_147437_c(i, j, k + 1)) {
/*     */         
/* 126 */         count = (byte)(count + 1);
/* 127 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k + 1))
/* 128 */           sides.add(Integer.valueOf(1)); 
/*     */       } 
/* 130 */       if (world.func_147437_c(i - 1, j, k)) {
/*     */         
/* 132 */         count = (byte)(count + 1);
/* 133 */         if (BlockCollapsible.canFallBelow(world, i - 1, j - 1, k))
/* 134 */           sides.add(Integer.valueOf(2)); 
/*     */       } 
/* 136 */       if (world.func_147437_c(i, j, k - 1)) {
/*     */         
/* 138 */         count = (byte)(count + 1);
/* 139 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k - 1)) {
/* 140 */           sides.add(Integer.valueOf(3));
/*     */         }
/*     */       } 
/* 143 */       if (!canFallOneBelow && count > 2 && !sides.isEmpty()) {
/*     */         
/* 145 */         switch (((Integer)sides.get(random.nextInt(sides.size()))).intValue()) {
/*     */ 
/*     */           
/*     */           case 0:
/* 149 */             world.func_147468_f(i, j, k);
/* 150 */             world.func_147465_d(i + 1, j, k, (Block)this, meta, 2);
/* 151 */             BlockCollapsible.tryToFall(world, i + 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 156 */             world.func_147468_f(i, j, k);
/* 157 */             world.func_147465_d(i, j, k + 1, (Block)this, meta, 2);
/* 158 */             BlockCollapsible.tryToFall(world, i, j, k + 1, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 163 */             world.func_147468_f(i, j, k);
/* 164 */             world.func_147465_d(i - 1, j, k, (Block)this, meta, 2);
/* 165 */             BlockCollapsible.tryToFall(world, i - 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 170 */             world.func_147468_f(i, j, k);
/* 171 */             world.func_147465_d(i, j, k - 1, (Block)this, meta, 2);
/* 172 */             BlockCollapsible.tryToFall(world, i, j, k - 1, (Block)this);
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/* 177 */       } else if (canFallOneBelow) {
/*     */         
/* 179 */         BlockCollapsible.tryToFall(world, i, j, k, (Block)this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 187 */     if (!world.field_72995_K) {
/*     */       
/* 189 */       BlockCollapsible.tryToFall(world, x, y, z, (Block)this);
/* 190 */       world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockDirt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */