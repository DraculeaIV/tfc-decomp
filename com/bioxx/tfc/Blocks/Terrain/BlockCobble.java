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
/*     */   public int func_149738_a(World p_149738_1_) {
/*  39 */     return 20;
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
/*  53 */     for (int i = 0; i < this.names.length; i++) {
/*  54 */       list.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int meta, Random random, int fortune) {
/*  61 */     if (meta > 7) {
/*  62 */       return TFCItems.looseRock;
/*     */     }
/*  64 */     return Item.func_150898_a((Block)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/*  73 */     return rand.nextInt(2) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  79 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */ 
/*     */     
/*  82 */     int count = (metadata > 7) ? func_149745_a(world.field_73012_v) : 1;
/*     */     
/*  84 */     for (int i = 0; i < count; i++) {
/*     */       
/*  86 */       Item item = func_149650_a(metadata, world.field_73012_v, fortune);
/*     */       
/*  88 */       if (item != null)
/*     */       {
/*  90 */         if (metadata > 7) {
/*     */ 
/*     */           
/*  93 */           int meta = this.looseStart + metadata % 8;
/*  94 */           ret.add(new ItemStack(item, 1, meta));
/*     */         } else {
/*     */           
/*  97 */           ret.add(new ItemStack(item, 1, func_149692_a(metadata)));
/*     */         }  } 
/*     */     } 
/* 100 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_149712_f(World world, int x, int y, int z) {
/* 110 */     if (world.func_72805_g(x, y, z) > 7) {
/* 111 */       return this.field_149782_v / 2.0F;
/*     */     }
/* 113 */     return this.field_149782_v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int i) {
/* 122 */     return i & 0x7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 128 */     if ((j & 0x7) >= this.icons.length)
/* 129 */       return this.icons[0]; 
/* 130 */     return this.icons[j & 0x7];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 136 */     for (int i = 0; i < this.names.length; i++) {
/* 137 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:rocks/" + this.names[i] + " Cobble");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int i, int j, int k) {
/* 143 */     world.func_147464_a(i, j, k, (Block)this, func_149738_a(world));
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
/* 154 */     world.func_147464_a(i, j, k, (Block)this, func_149738_a(world));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9) {
/* 163 */     boolean hasHammer = false;
/* 164 */     for (int i = 0; i < 9; i++) {
/*     */       
/* 166 */       if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/* 167 */         hasHammer = true; 
/*     */     } 
/* 169 */     if (entityplayer.func_71045_bC() != null && entityplayer.func_71045_bC().func_77973_b() instanceof IToolChisel && hasHammer && !world.field_72995_K && ((IToolChisel)entityplayer
/* 170 */       .func_71045_bC().func_77973_b()).canChisel(entityplayer, x, y, z)) {
/*     */       
/* 172 */       Block id = world.func_147439_a(x, y, z);
/* 173 */       byte meta = (byte)world.func_72805_g(x, y, z);
/*     */       
/* 175 */       return ((IToolChisel)entityplayer.func_71045_bC().func_77973_b()).onUsed(world, entityplayer, x, y, z, id, meta, side, par7, par8, par9);
/*     */     } 
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int i, int j, int k, Random random) {
/* 183 */     BlockCollapsible.updateTickCollapsible(world, i, j, k, random, (Block)this, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockCobble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */