/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
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
/*     */ public class BlockClay
/*     */   extends BlockTerra
/*     */ {
/*     */   protected IIcon[] dirtTexture;
/*     */   protected int textureOffset;
/*     */   
/*     */   public BlockClay(int texOff) {
/*  29 */     super(Material.field_151571_B);
/*  30 */     func_149647_a(TFCTabs.TFC_BUILDING);
/*  31 */     this.textureOffset = texOff;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> list) {
/*  38 */     Boolean addToCreative = Boolean.valueOf(true);
/*     */     
/*  40 */     if (addToCreative.booleanValue()) {
/*     */       int count;
/*     */       
/*  43 */       if (this.textureOffset == 0) { count = 16; }
/*  44 */       else { count = Global.STONE_ALL.length - 16; }
/*     */       
/*  46 */       for (int i = 0; i < count; i++) {
/*  47 */         list.add(new ItemStack(item, 1, i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  54 */     int count = (this.textureOffset == 0) ? 16 : (Global.STONE_ALL.length - 16);
/*  55 */     this.dirtTexture = new IIcon[count];
/*  56 */     for (int i = 0; i < count; i++) {
/*  57 */       this.dirtTexture[i] = registerer.func_94245_a("terrafirmacraft:clay/Clay " + Global.STONE_ALL[i + this.textureOffset]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/*  66 */     int meta = bAccess.func_72805_g(x, y, z);
/*  67 */     if (meta >= this.dirtTexture.length) return this.dirtTexture[this.dirtTexture.length - 1]; 
/*  68 */     return this.dirtTexture[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  77 */     if (meta >= this.dirtTexture.length) return this.dirtTexture[this.dirtTexture.length - 1]; 
/*  78 */     return this.dirtTexture[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/*  87 */     return TFCItems.clayBall;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/*  96 */     return rand.nextInt(3) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 102 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 112 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 113 */     int count = func_149745_a(world.field_73012_v);
/* 114 */     Item item = func_149650_a(metadata, world.field_73012_v, fortune);
/* 115 */     for (int i = 0; i < count; i++)
/* 116 */       ret.add(new ItemStack(item, 1, 0)); 
/* 117 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockClay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */