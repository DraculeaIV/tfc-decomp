/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.ColorizerFoliageTFC;
/*     */ import com.bioxx.tfc.Core.ColorizerGrassTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockTallGrass;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ public class BlockCustomTallGrass extends BlockTallGrass implements IShearable {
/*  32 */   private static final String[] META_NAMES = new String[] { "tallgrass", "fern", "shortgrass" };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] icons;
/*     */ 
/*     */   
/*     */   public BlockCustomTallGrass() {
/*  39 */     float var3 = 0.4F;
/*  40 */     func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
/*  41 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> list) {
/*  47 */     for (int i = 0; i < META_NAMES.length; i++)
/*     */     {
/*  49 */       list.add(new ItemStack(item, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149635_D() {
/*  56 */     double var1 = 0.5D;
/*  57 */     double var3 = 1.0D;
/*  58 */     return ColorizerGrassTFC.getGrassColor(var1, var3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149741_i(int par1) {
/*  64 */     return (par1 == 0) ? 16777215 : ColorizerFoliageTFC.getFoliageColorBasic();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149720_d(IBlockAccess bAccess, int x, int y, int z) {
/*  70 */     return TerraFirmaCraft.proxy.grassColorMultiplier(bAccess, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149679_a(int i, Random rand) {
/*  82 */     return 1 + rand.nextInt(i * 2 + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer player, int i, int j, int k, int l) {
/*  88 */     super.func_149636_a(world, player, i, j, k, l);
/*     */     
/*  90 */     ItemStack is = player.field_71071_by.func_70448_g();
/*  91 */     int[] equipIDs = OreDictionary.getOreIDs(is);
/*     */     
/*  93 */     for (int id : equipIDs) {
/*     */       
/*  95 */       String name = OreDictionary.getOreName(id);
/*  96 */       if (name.startsWith("itemKnife")) {
/*     */         
/*  98 */         createStraw(world, player, i, j, k);
/*  99 */         is.func_77972_a(1, (EntityLivingBase)player);
/* 100 */         if (is.field_77994_a == 0)
/* 101 */           player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null); 
/*     */         break;
/*     */       } 
/* 104 */       if (name.startsWith("itemScythe")) {
/*     */ 
/*     */         
/* 107 */         createStraw(world, player, i, j, k);
/*     */         
/* 109 */         for (int x = -1; x < 2; x++) {
/*     */           
/* 111 */           for (int z = -1; z < 2; z++) {
/*     */             
/* 113 */             if (world.func_147439_a(i + x, j, k + z) == this) {
/*     */               
/* 115 */               createStraw(world, player, i + x, j, k + z);
/* 116 */               is.func_77972_a(1, (EntityLivingBase)player);
/* 117 */               if (is.field_77994_a == 0)
/* 118 */                 player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null); 
/* 119 */               world.func_147468_f(i + x, j, k + z);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void createStraw(World world, EntityPlayer player, int i, int j, int k) {
/* 130 */     EntityItem ei = new EntityItem(world, (i + 0.5F), (j + 0.5F), (k + 0.5F), new ItemStack(TFCItems.straw, 1));
/* 131 */     world.func_72838_d((Entity)ei);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
/* 137 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/* 139 */     ItemStack item = getSeeds(world.field_73012_v);
/* 140 */     if (item != null)
/* 141 */       ret.add(item); 
/* 142 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
/* 154 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 155 */     ret.add(new ItemStack((Block)this, 1, world.func_72805_g(x, y, z)));
/* 156 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canThisPlantGrowOnThisBlock(Block block) {
/* 161 */     return TFC_Core.isSoil(block);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 170 */     return ((world.func_72883_k(x, y, z) >= 8 || world
/* 171 */       .func_72937_j(x, y, z)) && 
/* 172 */       canThisPlantGrowOnThisBlock(world.func_147439_a(x, y - 1, z)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack getSeeds(Random r) {
/* 177 */     ItemStack is = null;
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
/* 219 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister register) {
/* 226 */     this.icons = new IIcon[META_NAMES.length];
/* 227 */     for (int i = 0; i < this.icons.length; i++)
/*     */     {
/* 229 */       this.icons[i] = register.func_94245_a(((i > 1) ? "terrafirmacraft:plants/" : "") + META_NAMES[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 237 */     if (meta >= this.icons.length) meta = 0; 
/* 238 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World w, int x, int y, int z, Random rand) {
/* 245 */     float temp = TFC_Climate.getHeightAdjustedTemp(w, x, y, z);
/*     */     
/* 247 */     if (!w.field_72995_K && w.func_72957_l(x, y, z) < 7 && temp > 12.77D) {
/*     */       
/* 249 */       if (w.field_73012_v.nextInt(Math.max((int)(160.0F / (temp - 4.0F)), 1)) < 2) {
/*     */         
/* 251 */         float vol = 0.1F + w.field_73012_v.nextFloat() * 0.2F;
/* 252 */         float pitch = temp / 100.0F * 2.0F + 0.5F + vol;
/* 253 */         w.func_72908_a(x, y, z, "terrafirmacraft:mob.cricket", vol, pitch);
/*     */       } 
/*     */       
/* 256 */       if (rand.nextInt(8) == 0) {
/* 257 */         w.func_147464_a(x, y, z, (Block)this, 5);
/*     */       }
/*     */     } 
/*     */     
/* 261 */     super.func_149674_a(w, x, y, z, rand);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomTallGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */