/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSlab
/*     */   extends BlockPartial
/*     */ {
/*     */   public BlockSlab() {
/*  24 */     super(Material.field_151576_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  30 */     return TFCBlocks.slabRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
/*  41 */     TEPartial te = (TEPartial)world.func_147438_o(x, y, z);
/*  42 */     if (8 - getTopChiselLevel(te.extraData) + getBottomChiselLevel(te.extraData) < 3)
/*     */     {
/*  44 */       if (8 - getSouthChiselLevel(te.extraData) + getNorthChiselLevel(te.extraData) < 3 || 8 - 
/*  45 */         getEastChiselLevel(te.extraData) + getWestChiselLevel(te.extraData) < 3)
/*     */       {
/*  47 */         return true;
/*     */       }
/*     */     }
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_149712_f(World world, int x, int y, int z) {
/*  56 */     TEPartial te = (TEPartial)world.func_147438_o(x, y, z);
/*  57 */     if (te != null)
/*  58 */       return Block.func_149729_e(te.typeID).func_149712_f(world, x, y, z); 
/*  59 */     return this.field_149782_v;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTopChiselLevel(long data) {
/*  64 */     return (int)(data >> 16L & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBottomChiselLevel(long data) {
/*  69 */     return (int)(data >> 4L & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getEastChiselLevel(long data) {
/*  74 */     return (int)(data >> 12L & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getWestChiselLevel(long data) {
/*  79 */     return (int)(data & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getNorthChiselLevel(long data) {
/*  84 */     return (int)(data >> 8L & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getSouthChiselLevel(long data) {
/*  89 */     return (int)(data >> 20L & 0xFL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/*  99 */     TEPartial te = (TEPartial)world.func_147438_o(i, j, k);
/*     */     
/* 101 */     if (te != null) {
/*     */       
/* 103 */       short type = te.typeID;
/*     */       
/* 105 */       if (type <= 0) {
/* 106 */         return super.func_149668_a(world, i, j, k);
/*     */       }
/*     */       
/* 109 */       byte extraX = (byte)(int)(te.extraData & 0xFL);
/* 110 */       byte extraY = (byte)(int)(te.extraData >> 4L & 0xFL);
/* 111 */       byte extraZ = (byte)(int)(te.extraData >> 8L & 0xFL);
/* 112 */       byte extraX2 = (byte)(int)(te.extraData >> 12L & 0xFL);
/* 113 */       byte extraY2 = (byte)(int)(te.extraData >> 16L & 0xFL);
/* 114 */       byte extraZ2 = (byte)(int)(te.extraData >> 20L & 0xFL);
/*     */       
/* 116 */       float div = 0.125F;
/*     */       
/* 118 */       return AxisAlignedBB.func_72330_a((i + div * extraX), (j + div * extraY), (k + div * extraZ), (i + 1.0F - div * extraX2), (j + 1.0F - div * extraY2), (k + 1.0F - div * extraZ2));
/*     */     } 
/* 120 */     return AxisAlignedBB.func_72330_a(i, j, k, (i + 1), (j + 1), (k + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int i, int j, int k) {
/* 130 */     return func_149668_a(world, i, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int i, int j, int k) {
/* 136 */     TEPartial te = (TEPartial)bAccess.func_147438_o(i, j, k);
/*     */     
/* 138 */     long extraX = te.extraData & 0xFL;
/* 139 */     long extraY = te.extraData >> 4L & 0xFL;
/* 140 */     long extraZ = te.extraData >> 8L & 0xFL;
/* 141 */     long extraX2 = te.extraData >> 12L & 0xFL;
/* 142 */     long extraY2 = te.extraData >> 16L & 0xFL;
/* 143 */     long extraZ2 = te.extraData >> 20L & 0xFL;
/*     */     
/* 145 */     float div = 0.125F;
/*     */     
/* 147 */     func_149676_a(0.0F + div * (float)extraX, 0.0F + div * (float)extraY, 0.0F + div * (float)extraZ, 1.0F - div * (float)extraX2, 1.0F - div * (float)extraY2, 1.0F - div * (float)extraZ2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockDestroyedByExplosion(World world, int i, int j, int k) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
/* 169 */     TEPartial te = null;
/*     */     
/* 171 */     if (world.func_147438_o(x, y, z) instanceof TEPartial) {
/* 172 */       te = (TEPartial)world.func_147438_o(x, y, z);
/*     */     }
/* 174 */     if (te == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     long data = te.extraData;
/*     */     
/* 179 */     switch (side) {
/*     */       
/*     */       case DOWN:
/* 182 */         return (getBottomChiselLevel(data) == 0 && getNorthChiselLevel(data) == 0 && 
/* 183 */           getSouthChiselLevel(data) == 0 && getEastChiselLevel(data) == 0 && getWestChiselLevel(data) == 0);
/*     */       case UP:
/* 185 */         return (getTopChiselLevel(data) == 0 && getNorthChiselLevel(data) == 0 && 
/* 186 */           getSouthChiselLevel(data) == 0 && getEastChiselLevel(data) == 0 && getWestChiselLevel(data) == 0);
/*     */       case NORTH:
/* 188 */         return (getNorthChiselLevel(data) == 0 && getEastChiselLevel(data) == 0 && getWestChiselLevel(data) == 0 && 
/* 189 */           getTopChiselLevel(data) == 0 && getBottomChiselLevel(data) == 0);
/*     */       case SOUTH:
/* 191 */         return (getSouthChiselLevel(data) == 0 && getEastChiselLevel(data) == 0 && getWestChiselLevel(data) == 0 && 
/* 192 */           getTopChiselLevel(data) == 0 && getBottomChiselLevel(data) == 0);
/*     */       case EAST:
/* 194 */         return (getEastChiselLevel(data) == 0 && getNorthChiselLevel(data) == 0 && getSouthChiselLevel(data) == 0 && 
/* 195 */           getTopChiselLevel(data) == 0 && getBottomChiselLevel(data) == 0);
/*     */       case WEST:
/* 197 */         return (getWestChiselLevel(data) == 0 && getNorthChiselLevel(data) == 0 && getSouthChiselLevel(data) == 0 && 
/* 198 */           getTopChiselLevel(data) == 0 && getBottomChiselLevel(data) == 0);
/*     */     } 
/* 200 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 207 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */