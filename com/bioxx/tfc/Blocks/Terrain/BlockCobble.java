/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
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
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockCobble
/*     */   extends BlockTerra
/*     */ {
/*     */   protected String[] names;
/*     */   protected IIcon[] icons;
/*     */   protected int looseStart;
/*     */   
/*     */   protected BlockCobble(Material material) {
/*  31 */     super(material);
/*  32 */     func_149647_a(TFCTabs.TFC_BUILDING);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  46 */     for (int i = 0; i < this.names.length; i++) {
/*  47 */       list.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int meta, Random random, int fortune) {
/*  54 */     if (meta > 7) {
/*  55 */       return TFCItems.looseRock;
/*     */     }
/*  57 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/*  66 */     return rand.nextInt(2) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  72 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */ 
/*     */     
/*  75 */     int count = (metadata > 7) ? func_149745_a(world.field_73012_v) : 1;
/*     */     
/*  77 */     for (int i = 0; i < count; i++) {
/*     */       
/*  79 */       Item item = func_149650_a(metadata, world.field_73012_v, fortune);
/*     */       
/*  81 */       if (item != null)
/*     */       {
/*  83 */         if (metadata > 7) {
/*     */ 
/*     */           
/*  86 */           int meta = this.looseStart + metadata % 8;
/*  87 */           ret.add(new ItemStack(item, 1, meta));
/*     */         } else {
/*     */           
/*  90 */           ret.add(new ItemStack(item, 1, func_149692_a(metadata)));
/*     */         }  } 
/*     */     } 
/*  93 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_149712_f(World world, int x, int y, int z) {
/* 103 */     if (world.func_72805_g(x, y, z) > 7) {
/* 104 */       return this.field_149782_v / 2.0F;
/*     */     }
/* 106 */     return this.field_149782_v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/* 115 */     return i & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 121 */     if ((j & 0x7) >= this.icons.length)
/* 122 */       return this.icons[0]; 
/* 123 */     return this.icons[j & 0x7];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 129 */     for (int i = 0; i < this.names.length; i++) {
/* 130 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:rocks/" + this.names[i] + " Cobble");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int i, int j, int k) {
/* 136 */     world.func_147464_a(i, j, k, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World world, int i, int j, int k, int l) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block l) {
/* 147 */     world.func_147464_a(i, j, k, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9) {
/* 156 */     boolean hasHammer = false;
/* 157 */     for (int i = 0; i < 9; i++) {
/*     */       
/* 159 */       if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/* 160 */         hasHammer = true; 
/*     */     } 
/* 162 */     if (entityplayer.func_71045_bC() != null && entityplayer.func_71045_bC().func_77973_b() instanceof IToolChisel && hasHammer && !world.field_72995_K && ((IToolChisel)entityplayer
/* 163 */       .func_71045_bC().func_77973_b()).canChisel(entityplayer, x, y, z)) {
/*     */       
/* 165 */       Block id = world.func_147439_a(x, y, z);
/* 166 */       byte meta = (byte)world.func_72805_g(x, y, z);
/*     */       
/* 168 */       return ((IToolChisel)entityplayer.func_71045_bC().func_77973_b()).onUsed(world, entityplayer, x, y, z, id, meta, side, par7, par8, par9);
/*     */     } 
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random random) {
/* 176 */     if (!world.field_72995_K && world.func_72873_a(i, j, k, 1) && !BlockCollapsible.isNearSupport(world, i, j, k, 4, 0.0F).booleanValue()) {
/*     */       
/* 178 */       int meta = world.func_72805_g(i, j, k);
/*     */       
/* 180 */       boolean canFallOneBelow = BlockCollapsible.canFallBelow(world, i, j - 1, k);
/* 181 */       byte count = 0;
/* 182 */       List<Integer> sides = new ArrayList<Integer>();
/*     */       
/* 184 */       if (world.func_147437_c(i + 1, j, k)) {
/*     */         
/* 186 */         count = (byte)(count + 1);
/* 187 */         if (BlockCollapsible.canFallBelow(world, i + 1, j - 1, k))
/* 188 */           sides.add(Integer.valueOf(0)); 
/*     */       } 
/* 190 */       if (world.func_147437_c(i, j, k + 1)) {
/*     */         
/* 192 */         count = (byte)(count + 1);
/* 193 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k + 1))
/* 194 */           sides.add(Integer.valueOf(1)); 
/*     */       } 
/* 196 */       if (world.func_147437_c(i - 1, j, k)) {
/*     */         
/* 198 */         count = (byte)(count + 1);
/* 199 */         if (BlockCollapsible.canFallBelow(world, i - 1, j - 1, k))
/* 200 */           sides.add(Integer.valueOf(2)); 
/*     */       } 
/* 202 */       if (world.func_147437_c(i, j, k - 1)) {
/*     */         
/* 204 */         count = (byte)(count + 1);
/* 205 */         if (BlockCollapsible.canFallBelow(world, i, j - 1, k - 1)) {
/* 206 */           sides.add(Integer.valueOf(3));
/*     */         }
/*     */       } 
/* 209 */       if (!canFallOneBelow && count > 2 && !sides.isEmpty()) {
/*     */         
/* 211 */         switch (((Integer)sides.get(random.nextInt(sides.size()))).intValue()) {
/*     */ 
/*     */           
/*     */           case 0:
/* 215 */             world.func_147468_f(i, j, k);
/* 216 */             world.func_147465_d(i + 1, j, k, (Block)this, meta, 2);
/* 217 */             BlockCollapsible.tryToFall(world, i + 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 222 */             world.func_147468_f(i, j, k);
/* 223 */             world.func_147465_d(i, j, k + 1, (Block)this, meta, 2);
/* 224 */             BlockCollapsible.tryToFall(world, i, j, k + 1, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 229 */             world.func_147468_f(i, j, k);
/* 230 */             world.func_147465_d(i - 1, j, k, (Block)this, meta, 2);
/* 231 */             BlockCollapsible.tryToFall(world, i - 1, j, k, (Block)this);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 236 */             world.func_147468_f(i, j, k);
/* 237 */             world.func_147465_d(i, j, k - 1, (Block)this, meta, 2);
/* 238 */             BlockCollapsible.tryToFall(world, i, j, k - 1, (Block)this);
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/* 243 */       } else if (canFallOneBelow) {
/*     */         
/* 245 */         BlockCollapsible.tryToFall(world, i, j, k, (Block)this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockCobble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */