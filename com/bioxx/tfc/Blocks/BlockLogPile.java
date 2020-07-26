/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TELogPile;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLogPile
/*     */   extends BlockTerraContainer
/*     */ {
/*  33 */   private IIcon[] icons = new IIcon[3];
/*     */ 
/*     */   
/*     */   public BlockLogPile() {
/*  37 */     super(Material.field_151575_d);
/*  38 */     func_149675_a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDirectionFromMetadata(int i) {
/*  43 */     return i & 0x3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
/*  49 */     if (world.func_147438_o(x, y, z) instanceof TELogPile && side == ForgeDirection.UP)
/*     */     {
/*  51 */       if (((TELogPile)world.func_147438_o(x, y, z)).isOnFire)
/*  52 */         return true; 
/*     */     }
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  60 */     if (world.field_72995_K)
/*     */     {
/*  62 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  66 */     if ((TELogPile)world.func_147438_o(i, j, k) != null) {
/*     */ 
/*     */ 
/*     */       
/*  70 */       ItemStack is = entityplayer.func_71045_bC();
/*     */       
/*  72 */       if (is != null && is.func_77973_b() == TFCItems.logs)
/*     */       {
/*  74 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  78 */       entityplayer.openGui(TerraFirmaCraft.instance, 0, world, i, j, k);
/*     */       
/*  80 */       return true;
/*     */     } 
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  92 */     if (j == 0 || j == 2) {
/*     */       
/*  94 */       if (i == 0)
/*  95 */         return this.icons[1]; 
/*  96 */       if (i == 1)
/*  97 */         return this.icons[1]; 
/*  98 */       if (i == 2)
/*  99 */         return this.icons[2]; 
/* 100 */       if (i == 3)
/* 101 */         return this.icons[2]; 
/* 102 */       if (i == 4)
/* 103 */         return this.icons[0]; 
/* 104 */       if (i == 5) {
/* 105 */         return this.icons[0];
/*     */       }
/*     */     }
/* 108 */     else if (j == 1 || j == 3) {
/*     */       
/* 110 */       if (i == 0)
/* 111 */         return this.icons[0]; 
/* 112 */       if (i == 1)
/* 113 */         return this.icons[0]; 
/* 114 */       if (i == 2)
/* 115 */         return this.icons[0]; 
/* 116 */       if (i == 3)
/* 117 */         return this.icons[0]; 
/* 118 */       if (i == 4)
/* 119 */         return this.icons[2]; 
/* 120 */       if (i == 5) {
/* 121 */         return this.icons[2];
/*     */       }
/*     */     } 
/*     */     
/* 125 */     return this.icons[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 132 */     this.icons[0] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Log Pile Side 0");
/* 133 */     this.icons[1] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Log Pile Side 1");
/* 134 */     this.icons[2] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Log Pile End");
/*     */   }
/*     */ 
/*     */   
/*     */   public void eject(World world, int x, int y, int z) {
/* 139 */     if (!world.field_72995_K && world.func_147438_o(x, y, z) instanceof TELogPile) {
/*     */       
/* 141 */       TELogPile te = (TELogPile)world.func_147438_o(x, y, z);
/* 142 */       te.ejectContents();
/* 143 */       world.func_147475_p(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par1, Random random, int par3) {
/* 150 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
/* 156 */     eject(world, i, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion ex) {
/* 162 */     eject(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World world, int x, int y, int z, int i) {
/* 168 */     eject(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 174 */     eject(world, x, y, z);
/* 175 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 181 */     return (TileEntity)new TELogPile();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 187 */     if (!world.field_72995_K && world.func_147438_o(x, y, z) instanceof TELogPile)
/*     */     {
/* 189 */       ((TELogPile)world.func_147438_o(x, y, z)).lightNeighbors();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 202 */     if (world.func_147438_o(x, y, z) instanceof TELogPile) {
/*     */       
/* 204 */       TELogPile te = (TELogPile)world.func_147438_o(x, y, z);
/*     */       
/* 206 */       if (te.isOnFire && te.fireTimer + TFCOptions.charcoalPitBurnTime < (float)TFC_Time.getTotalHours())
/*     */       {
/* 208 */         te.createCharcoal(x, y, z, true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World world, int x, int y, int z, Random rand) {
/* 217 */     if (world.func_147438_o(x, y, z) instanceof TELogPile && ((TELogPile)world.func_147438_o(x, y, z)).isOnFire) {
/*     */       
/* 219 */       double centerX = (x + 0.5F);
/* 220 */       double centerY = (y + 2.0F);
/* 221 */       double centerZ = (z + 0.5F);
/*     */ 
/*     */       
/* 224 */       world.func_72869_a("smoke", centerX + rand.nextDouble() - 0.5D, centerY, centerZ + rand.nextDouble() - 0.5D, 0.0D, 0.1D, 0.0D);
/* 225 */       world.func_72869_a("smoke", centerX + rand.nextDouble() - 0.5D, centerY, centerZ + rand.nextDouble() - 0.5D, 0.0D, 0.15D, 0.0D);
/* 226 */       world.func_72869_a("smoke", centerX + rand.nextDouble() - 0.5D, centerY - 1.0D, centerZ + rand.nextDouble() - 0.5D, 0.0D, 0.1D, 0.0D);
/* 227 */       world.func_72869_a("smoke", centerX + rand.nextDouble() - 0.5D, centerY - 1.0D, centerZ + rand.nextDouble() - 0.5D, 0.0D, 0.15D, 0.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockLogPile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */