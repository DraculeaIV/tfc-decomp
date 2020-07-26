/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Tools.IToolChisel;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockStone
/*     */   extends BlockCollapsible {
/*     */   protected String[] names;
/*     */   public IIcon[] icons;
/*     */   protected int looseStart;
/*     */   protected int gemChance;
/*     */   
/*     */   public BlockStone(Material material) {
/*  32 */     super(material);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  47 */     for (int i = 0; i < this.names.length; i++) {
/*  48 */       par3List.add(new ItemStack(par1, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/*  57 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  63 */     if ((j & 0x7) >= this.icons.length)
/*  64 */       return this.icons[0]; 
/*  65 */     return this.icons[j & 0x7];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  71 */     for (int i = 0; i < this.names.length; i++) {
/*  72 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:rocks/" + this.names[i] + " Raw");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random random, int j) {
/*  78 */     return TFCItems.looseRock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/*  87 */     return rand.nextInt(2) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  93 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*  94 */     int meta = this.looseStart + metadata;
/*     */     
/*  96 */     int count = func_149745_a(world.field_73012_v);
/*  97 */     for (int i = 0; i < count; i++) {
/*     */       
/*  99 */       Item item = func_149650_a(meta, world.field_73012_v, fortune);
/* 100 */       if (item != null)
/*     */       {
/* 102 */         ret.add(new ItemStack(item, 1, func_149692_a(meta)));
/*     */       }
/*     */     } 
/*     */     
/* 106 */     ItemStack gemStack = TFC_Core.randomGem(world.field_73012_v, this.gemChance);
/* 107 */     if (gemStack != null) {
/* 108 */       ret.add(gemStack);
/*     */     }
/* 110 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int i, int j, int k, Explosion ex) {
/* 116 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/* 119 */       Random random = new Random();
/*     */       
/* 121 */       ItemStack is = null;
/*     */       
/* 123 */       is = TFC_Core.randomGem(random, 0);
/*     */       
/* 125 */       if (is != null) {
/*     */         
/* 127 */         EntityItem item = new EntityItem(world, i, j, k, is);
/* 128 */         world.func_72838_d((Entity)item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
/* 137 */     if (world.field_73012_v.nextInt(100) < 30) {
/*     */ 
/*     */       
/* 140 */       world.func_147465_d(x, y, z, this.dropBlock, world.func_72805_g(x, y, z) + 8, 2);
/*     */     }
/*     */     else {
/*     */       
/* 144 */       super.onBlockExploded(world, x, y, z, explosion);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block l) {
/* 151 */     dropCarvedStone(world, i, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9) {
/* 157 */     boolean hasHammer = false;
/* 158 */     for (int i = 0; i < 9; i++) {
/* 159 */       if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/* 160 */         hasHammer = true; 
/*     */     } 
/* 162 */     if (entityplayer.func_71045_bC() != null && entityplayer.func_71045_bC().func_77973_b() instanceof IToolChisel && hasHammer && !world.field_72995_K && ((IToolChisel)entityplayer
/* 163 */       .func_71045_bC().func_77973_b()).canChisel(entityplayer, x, y, z)) {
/*     */       
/* 165 */       Block id = world.func_147439_a(x, y, z);
/* 166 */       byte meta = (byte)world.func_72805_g(x, y, z);
/* 167 */       return ((IToolChisel)entityplayer.func_71045_bC().func_77973_b()).onUsed(world, entityplayer, x, y, z, id, meta, side, par7, par8, par9);
/*     */     } 
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/* 175 */     func_149642_a(world, i, j, k, new ItemStack(TFCItems.looseRock, world.field_73012_v.nextInt(2) + 1, l + this.looseStart));
/*     */     
/* 177 */     super.func_149636_a(world, entityplayer, i, j, k, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World world, int i, int j, int k, int l) {
/* 183 */     if (!world.field_72995_K) {
/*     */       
/* 185 */       Random random = new Random();
/* 186 */       ItemStack is = null;
/*     */       
/* 188 */       is = TFC_Core.randomGem(random, this.gemChance);
/*     */       
/* 190 */       if (is != null) {
/*     */         
/* 192 */         EntityItem item = new EntityItem(world, i, j, k, is);
/* 193 */         world.func_72838_d((Entity)item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */