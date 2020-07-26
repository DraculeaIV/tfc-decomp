/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBed
/*     */   extends BlockDirectional
/*     */ {
/*  37 */   public static final int[][] FOOT_HEAD_BLOCKMAP = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] bedEndIcons;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] bedSideIcons;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] bedTopIcons;
/*     */   
/*     */   public BlockBed() {
/*  47 */     super(Material.field_151577_b);
/*  48 */     setBounds();
/*  49 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
/*  58 */     if (world.field_72995_K)
/*     */     {
/*  60 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  64 */     int i1 = world.func_72805_g(x, y, z);
/*     */     
/*  66 */     if (!isBlockHeadOfBed(i1)) {
/*     */       
/*  68 */       int j1 = func_149895_l(i1);
/*  69 */       x += FOOT_HEAD_BLOCKMAP[j1][0];
/*  70 */       z += FOOT_HEAD_BLOCKMAP[j1][1];
/*     */       
/*  72 */       if (world.func_147439_a(x, y, z) != this) {
/*  73 */         return true;
/*     */       }
/*  75 */       i1 = world.func_72805_g(x, y, z);
/*     */     } 
/*     */     
/*  78 */     if (world.field_73011_w.func_76567_e() && world.func_72807_a(x, z) != TFCBiome.HELL) {
/*     */       
/*  80 */       if (isBedOccupied(i1)) {
/*     */         
/*  82 */         EntityPlayer entityplayer1 = null;
/*  83 */         Iterator<EntityPlayer> iterator = world.field_73010_i.iterator();
/*     */         
/*  85 */         while (iterator.hasNext()) {
/*     */           
/*  87 */           EntityPlayer entityplayer2 = iterator.next();
/*     */           
/*  89 */           if (entityplayer2.func_70608_bn()) {
/*     */             
/*  91 */             ChunkCoordinates chunkcoordinates = entityplayer2.field_71081_bT;
/*     */             
/*  93 */             if (chunkcoordinates.field_71574_a == x && chunkcoordinates.field_71572_b == y && chunkcoordinates.field_71573_c == z)
/*     */             {
/*  95 */               entityplayer1 = entityplayer2;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 100 */         if (entityplayer1 != null) {
/*     */           
/* 102 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
/* 103 */           return true;
/*     */         } 
/*     */         
/* 106 */         setBedOccupied(world, x, y, z, false);
/*     */       } 
/*     */       
/* 109 */       EntityPlayer.EnumStatus enumstatus = player.func_71018_a(x, y, z);
/*     */       
/* 111 */       if (enumstatus == EntityPlayer.EnumStatus.OK) {
/*     */         
/* 113 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("tile.customBed.sleep", new Object[0]));
/* 114 */         setBedOccupied(world, x, y, z, true);
/* 115 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 119 */       if (enumstatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
/* 120 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
/* 121 */       } else if (enumstatus == EntityPlayer.EnumStatus.NOT_SAFE) {
/* 122 */         TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
/*     */       } 
/* 124 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 129 */     double d0 = x + 0.5D;
/* 130 */     double d1 = y + 0.5D;
/* 131 */     double d2 = z + 0.5D;
/* 132 */     world.func_147468_f(x, y, z);
/* 133 */     int k1 = func_149895_l(i1);
/* 134 */     x += FOOT_HEAD_BLOCKMAP[k1][0];
/* 135 */     z += FOOT_HEAD_BLOCKMAP[k1][1];
/*     */     
/* 137 */     if (world.func_147439_a(x, y, z) == this) {
/*     */       
/* 139 */       world.func_147468_f(x, y, z);
/* 140 */       d0 = (d0 + x + 0.5D) / 2.0D;
/* 141 */       d1 = (d1 + y + 0.5D) / 2.0D;
/* 142 */       d2 = (d2 + z + 0.5D) / 2.0D;
/*     */     } 
/*     */     
/* 145 */     world.func_72885_a((Entity)null, (x + 0.5F), (y + 0.5F), (z + 0.5F), 5.0F, true, true);
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBed(IBlockAccess world, int x, int y, int z, EntityLivingBase player) {
/* 154 */     World w = (World)world;
/* 155 */     if (!w.field_72995_K && player != null) {
/* 156 */       ((EntityPlayer)player).field_71076_b = 50;
/*     */     }
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/* 170 */     if (par1 == 0)
/*     */     {
/* 172 */       return TFCBlocks.planks.func_149733_h(par1);
/*     */     }
/*     */ 
/*     */     
/* 176 */     int k = func_149895_l(par2);
/* 177 */     int l = Direction.field_71584_h[k][par1];
/* 178 */     int i1 = isBlockHeadOfBed(par2) ? 1 : 0;
/* 179 */     return ((i1 != 1 || l != 2) && (i1 != 0 || l != 3)) ? ((l != 5 && l != 4) ? this.bedTopIcons[i1] : this.bedSideIcons[i1]) : this.bedEndIcons[i1];
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 192 */     this.bedTopIcons = new IIcon[] { par1IconRegister.func_94245_a("terrafirmacraft:straw bed_feet_top"), par1IconRegister.func_94245_a("terrafirmacraft:straw bed_head_top") };
/* 193 */     this.bedEndIcons = new IIcon[] { par1IconRegister.func_94245_a("terrafirmacraft:straw bed_feet_end"), par1IconRegister.func_94245_a("terrafirmacraft:straw bed_head_end") };
/* 194 */     this.bedSideIcons = new IIcon[] { par1IconRegister.func_94245_a("terrafirmacraft:straw bed_feet_side"), par1IconRegister.func_94245_a("terrafirmacraft:straw bed_head_side") };
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
/*     */   public int func_149645_b() {
/* 211 */     return 14;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 220 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 239 */     setBounds();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World par1World, int par2, int par3, int par4, Block par5) {
/* 249 */     int i1 = par1World.func_72805_g(par2, par3, par4);
/* 250 */     int j1 = func_149895_l(i1);
/*     */     
/* 252 */     if (isBlockHeadOfBed(i1)) {
/*     */       
/* 254 */       if (par1World.func_147439_a(par2 - FOOT_HEAD_BLOCKMAP[j1][0], par3, par4 - FOOT_HEAD_BLOCKMAP[j1][1]) != this)
/*     */       {
/* 256 */         par1World.func_147468_f(par2, par3, par4);
/*     */       }
/*     */     }
/* 259 */     else if (par1World.func_147439_a(par2 + FOOT_HEAD_BLOCKMAP[j1][0], par3, par4 + FOOT_HEAD_BLOCKMAP[j1][1]) != this) {
/*     */       
/* 261 */       par1World.func_147468_f(par2, par3, par4);
/*     */       
/* 263 */       if (!par1World.field_72995_K)
/*     */       {
/* 265 */         func_149697_b(par1World, par2, par3, par4, i1, 0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par1, Random par2Random, int par3) {
/* 276 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setBounds() {
/* 284 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBlockHeadOfBed(int par0) {
/* 292 */     return ((par0 & 0x8) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isBedOccupied(int par0) {
/* 300 */     return ((par0 & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setBedOccupied(World par0World, int par1, int par2, int par3, boolean par4) {
/* 308 */     int l = par0World.func_72805_g(par1, par2, par3);
/*     */     
/* 310 */     if (par4) {
/* 311 */       l |= 0x4;
/*     */     } else {
/* 313 */       l &= 0xFFFFFFFB;
/*     */     } 
/* 315 */     par0World.func_72921_c(par1, par2, par3, l, 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ChunkCoordinates getNearestEmptyChunkCoordinates(World par0World, int par1, int par2, int par3, int par4) {
/* 323 */     int i1 = par0World.func_72805_g(par1, par2, par3);
/* 324 */     int j1 = BlockDirectional.func_149895_l(i1);
/*     */     
/* 326 */     for (int k1 = 0; k1 <= 1; k1++) {
/*     */       
/* 328 */       int l1 = par1 - FOOT_HEAD_BLOCKMAP[j1][0] * k1 - 1;
/* 329 */       int i2 = par3 - FOOT_HEAD_BLOCKMAP[j1][1] * k1 - 1;
/* 330 */       int j2 = l1 + 2;
/* 331 */       int k2 = i2 + 2;
/*     */       
/* 333 */       for (int l2 = l1; l2 <= j2; l2++) {
/*     */         
/* 335 */         for (int i3 = i2; i3 <= k2; i3++) {
/*     */           
/* 337 */           if (World.func_147466_a((IBlockAccess)par0World, l2, par2 - 1, i3) && !par0World.func_147439_a(l2, par2, i3).func_149688_o().func_76218_k() && !par0World.func_147439_a(l2, par2 + 1, i3).func_149688_o().func_76218_k()) {
/*     */             
/* 339 */             if (par4 <= 0) {
/* 340 */               return new ChunkCoordinates(l2, par2, i3);
/*     */             }
/* 342 */             par4--;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 348 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
/* 357 */     if (!isBlockHeadOfBed(par5)) {
/* 358 */       super.func_149690_a(par1World, par2, par3, par4, par5, par6, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 364 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/* 366 */     ret.add(new ItemStack(TFCItems.hide, 1, 2));
/* 367 */     ret.add(new ItemStack(TFCBlocks.thatch, 2, 0));
/* 368 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149656_h() {
/* 378 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149681_a(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
/* 387 */     if (par6EntityPlayer.field_71075_bZ.field_75098_d && isBlockHeadOfBed(par5)) {
/*     */       
/* 389 */       int i1 = func_149895_l(par5);
/* 390 */       par2 -= FOOT_HEAD_BLOCKMAP[i1][0];
/* 391 */       par4 -= FOOT_HEAD_BLOCKMAP[i1][1];
/*     */       
/* 393 */       if (par1World.func_147439_a(par2, par3, par4) == this)
/* 394 */         par1World.func_147468_f(par2, par3, par4); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockBed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */