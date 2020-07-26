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
/*     */ import net.minecraft.init.Items;
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
/*     */ public class BlockGravel
/*     */   extends BlockTerra
/*     */ {
/*     */   protected IIcon[] icons;
/*     */   protected int textureOffset;
/*     */   
/*     */   public BlockGravel(int texOff) {
/*  33 */     super(Material.field_151578_c);
/*  34 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  35 */     this.textureOffset = texOff;
/*  36 */     func_149675_a(true);
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
/*  47 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  49 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  52 */       if (this.textureOffset == 0) { count = 16; }
/*  53 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  55 */       for (int i = 0; i < count; i++) {
/*  56 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  63 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  69 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/*  71 */     if (fortune > 3)
/*     */     {
/*  73 */       fortune = 3;
/*     */     }
/*     */     
/*  76 */     if (world.field_73012_v.nextInt(10 - fortune * 3) == 0) {
/*     */       
/*  78 */       ret.add(new ItemStack(Items.field_151145_ak, 1));
/*     */     }
/*     */     else {
/*     */       
/*  82 */       ret.add(new ItemStack(Item.func_150898_a((Block)this), 1, func_149692_a(metadata)));
/*     */     } 
/*  84 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/*  90 */     int meta = bAccess.func_72805_g(x, y, z);
/*  91 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  92 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  98 */     if (meta >= this.icons.length) return this.icons[this.icons.length - 1]; 
/*  99 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 105 */     int count = (this.textureOffset == 0) ? 16 : (Global.STONE_ALL.length - 16);
/* 106 */     this.icons = new IIcon[count];
/* 107 */     for (int i = 0; i < count; i++) {
/* 108 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:soil/Gravel " + Global.STONE_ALL[i + this.textureOffset]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/* 114 */     world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World world) {
/* 120 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random random) {
/* 126 */     if (!world.field_72995_K && world.func_72873_a(i, j, k, 1) && !BlockCollapsible.isNearSupport(world, i, j, k, 4, 0.0F).booleanValue()) {
/*     */       
/* 128 */       int meta = world.func_72805_g(i, j, k);
/*     */       
/* 130 */       boolean canFallOneBelow = BlockCollapsible.canFallBelow(world, i, j - 1, k);
/* 131 */       byte count = 0;
/* 132 */       List<Integer> sides = new ArrayList<Integer>();
/*     */       
/* 134 */       if (world.func_147437_c(i + 1, j, k)) {
/*     */         
/* 136 */         count = (byte)(count + 1);
/* 137 */         if (BlockCollapsible.canFallBelow(world, i + 1, j - 1, k))
/* 138 */           sides.add(Integer.valueOf(0)); 
/*     */       } 
/* 140 */       if (world.func_147437_c(i, j, k + 1)) {
/*     */         
/* 142 */         count = (byte)(count + 1);
/* 143 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k + 1))
/* 144 */           sides.add(Integer.valueOf(1)); 
/*     */       } 
/* 146 */       if (world.func_147437_c(i - 1, j, k)) {
/*     */         
/* 148 */         count = (byte)(count + 1);
/* 149 */         if (BlockCollapsible.canFallBelow(world, i - 1, j - 1, k))
/* 150 */           sides.add(Integer.valueOf(2)); 
/*     */       } 
/* 152 */       if (world.func_147437_c(i, j, k - 1)) {
/*     */         
/* 154 */         count = (byte)(count + 1);
/* 155 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k - 1)) {
/* 156 */           sides.add(Integer.valueOf(3));
/*     */         }
/*     */       } 
/* 159 */       if (!canFallOneBelow && count > 2 && !sides.isEmpty()) {
/*     */         
/* 161 */         switch (((Integer)sides.get(random.nextInt(sides.size()))).intValue()) {
/*     */ 
/*     */           
/*     */           case 0:
/* 165 */             world.func_147468_f(i, j, k);
/* 166 */             world.func_147465_d(i + 1, j, k, (Block)this, meta, 2);
/* 167 */             BlockCollapsible.tryToFall(world, i + 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 172 */             world.func_147468_f(i, j, k);
/* 173 */             world.func_147465_d(i, j, k + 1, (Block)this, meta, 2);
/* 174 */             BlockCollapsible.tryToFall(world, i, j, k + 1, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 179 */             world.func_147468_f(i, j, k);
/* 180 */             world.func_147465_d(i - 1, j, k, (Block)this, meta, 2);
/* 181 */             BlockCollapsible.tryToFall(world, i - 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 186 */             world.func_147468_f(i, j, k);
/* 187 */             world.func_147465_d(i, j, k - 1, (Block)this, meta, 2);
/* 188 */             BlockCollapsible.tryToFall(world, i, j, k - 1, (Block)this);
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/* 193 */       } else if (canFallOneBelow) {
/*     */         
/* 195 */         BlockCollapsible.tryToFall(world, i, j, k, (Block)this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 203 */     if (!world.field_72995_K) {
/*     */       
/* 205 */       BlockCollapsible.tryToFall(world, x, y, z, (Block)this);
/* 206 */       world.func_147464_a(x, y, z, (Block)this, func_149738_a(world));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockGravel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */