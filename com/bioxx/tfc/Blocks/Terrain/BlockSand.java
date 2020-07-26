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
/*     */ public class BlockSand
/*     */   extends BlockTerra
/*     */ {
/*  27 */   protected IIcon[] icons = new IIcon[Global.STONE_ALL.length];
/*     */   
/*     */   protected int textureOffset;
/*     */   
/*     */   public BlockSand(int texOff) {
/*  32 */     super(Material.field_151595_p);
/*  33 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  34 */     this.textureOffset = texOff;
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
/*  45 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  47 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  50 */       if (this.textureOffset == 0) { count = 16; }
/*  51 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  53 */       for (int i = 0; i < count; i++) {
/*  54 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  61 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/*  70 */     int meta = bAccess.func_72805_g(x, y, z);
/*  71 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  72 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  81 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  82 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  88 */     int count = (this.textureOffset == 0) ? 16 : (Global.STONE_ALL.length - 16);
/*  89 */     this.icons = new IIcon[count];
/*  90 */     for (int i = 0; i < count; i++) {
/*  91 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:sand/Sand " + Global.STONE_ALL[i + this.textureOffset]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/*  97 */     world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random random) {
/* 103 */     if (!world.field_72995_K && world.func_72873_a(x, y, z, 1)) {
/*     */       
/* 105 */       int meta = world.func_72805_g(x, y, z);
/*     */       
/* 107 */       boolean canFallOneBelow = BlockCollapsible.canFallBelow(world, x, y - 1, z);
/* 108 */       byte count = 0;
/* 109 */       List<Integer> sides = new ArrayList<Integer>();
/*     */       
/* 111 */       if (world.func_147437_c(x + 1, y, z)) {
/*     */         
/* 113 */         count = (byte)(count + 1);
/* 114 */         if (BlockCollapsible.canFallBelow(world, x + 1, y - 1, z))
/* 115 */           sides.add(Integer.valueOf(0)); 
/*     */       } 
/* 117 */       if (world.func_147437_c(x, y, z + 1)) {
/*     */         
/* 119 */         count = (byte)(count + 1);
/* 120 */         if (BlockCollapsible.canFallBelow(world, x, y - 1, z + 1))
/* 121 */           sides.add(Integer.valueOf(1)); 
/*     */       } 
/* 123 */       if (world.func_147437_c(x - 1, y, z)) {
/*     */         
/* 125 */         count = (byte)(count + 1);
/* 126 */         if (BlockCollapsible.canFallBelow(world, x - 1, y - 1, z))
/* 127 */           sides.add(Integer.valueOf(2)); 
/*     */       } 
/* 129 */       if (world.func_147437_c(x, y, z - 1)) {
/*     */         
/* 131 */         count = (byte)(count + 1);
/* 132 */         if (BlockCollapsible.canFallBelow(world, x, y - 1, z - 1)) {
/* 133 */           sides.add(Integer.valueOf(3));
/*     */         }
/*     */       } 
/* 136 */       if (!canFallOneBelow && count > 2 && !sides.isEmpty()) {
/*     */         
/* 138 */         switch (((Integer)sides.get(random.nextInt(sides.size()))).intValue()) {
/*     */ 
/*     */           
/*     */           case 0:
/* 142 */             world.func_147468_f(x, y, z);
/* 143 */             world.func_147465_d(x + 1, y, z, (Block)this, meta, 2);
/* 144 */             BlockCollapsible.tryToFall(world, x + 1, y, z, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 149 */             world.func_147468_f(x, y, z);
/* 150 */             world.func_147465_d(x, y, z + 1, (Block)this, meta, 2);
/* 151 */             BlockCollapsible.tryToFall(world, x, y, z + 1, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 156 */             world.func_147468_f(x, y, z);
/* 157 */             world.func_147465_d(x - 1, y, z, (Block)this, meta, 2);
/* 158 */             BlockCollapsible.tryToFall(world, x - 1, y, z, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 163 */             world.func_147468_f(x, y, z);
/* 164 */             world.func_147465_d(x, y, z - 1, (Block)this, meta, 2);
/* 165 */             BlockCollapsible.tryToFall(world, x, y, z - 1, (Block)this);
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/* 170 */       } else if (canFallOneBelow) {
/*     */         
/* 172 */         BlockCollapsible.tryToFall(world, x, y, z, (Block)this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 180 */     if (!world.field_72995_K) {
/*     */       
/* 182 */       BlockCollapsible.tryToFall(world, x, y, z, (Block)this);
/* 183 */       world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockSand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */