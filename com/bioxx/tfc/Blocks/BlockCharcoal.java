/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCharcoal
/*     */   extends BlockTerra
/*     */ {
/*     */   public BlockCharcoal() {
/*  26 */     super(Material.field_151578_c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  32 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  38 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:devices/Charcoal");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149681_a(World world, int x, int y, int z, int side, EntityPlayer entityplayer) {
/*  62 */     if (!world.field_72995_K)
/*     */     {
/*  64 */       if (entityplayer.field_71075_bZ.field_75098_d) {
/*     */         
/*  66 */         world.func_147468_f(x, y, z);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/*  71 */         boolean isShovel = false;
/*  72 */         ItemStack equip = entityplayer.func_71045_bC();
/*  73 */         if (equip != null)
/*     */         {
/*  75 */           if (equip.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomShovel) {
/*  76 */             isShovel = true;
/*     */           }
/*     */         }
/*  79 */         if (isShovel) {
/*     */           
/*  81 */           int top = 0;
/*  82 */           while (world.func_147439_a(x, y + top + 1, z) == this) {
/*  83 */             top++;
/*     */           }
/*  85 */           func_149642_a(world, x, y, z, new ItemStack(TFCItems.coal, 1, 1));
/*  86 */           if (side - 1 > 0) {
/*     */             
/*  88 */             if (world.func_147439_a(x, y + 1, z) == this) {
/*     */               
/*  90 */               int m1 = world.func_72805_g(x, y + top, z);
/*  91 */               if (m1 - 1 > 0) {
/*  92 */                 world.func_72921_c(x, y + top, z, m1 - 1, 2);
/*     */               } else {
/*  94 */                 world.func_147468_f(x, y + top, z);
/*     */               } 
/*  96 */               world.func_147465_d(x, y, z, this, 8, 2);
/*     */             }
/*     */             else {
/*     */               
/* 100 */               world.func_147465_d(x, y, z, this, side - 1, 2);
/*     */             } 
/*     */             
/* 103 */             world.func_147471_g(x, y, z);
/* 104 */             world.func_147471_g(x, y + top, z);
/*     */           } else {
/*     */             
/* 107 */             world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */           } 
/*     */         } else {
/*     */           
/* 111 */           world.func_147465_d(x, y, z, this, side, 2);
/*     */         } 
/*     */         
/* 114 */         if (side == 0) {
/* 115 */           world.func_147468_f(x, y, z);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 123 */     if (world.func_72805_g(x, y, z) > 0)
/* 124 */       return false; 
/* 125 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public void combineCharcoalDown(World world, int x, int y, int z) {
/* 130 */     int meta = world.func_72805_g(x, y, z);
/* 131 */     int bottomMeta = world.func_72805_g(x, y - 1, z);
/*     */     
/* 133 */     if (bottomMeta < 8) {
/*     */       
/* 135 */       bottomMeta += meta;
/* 136 */       int m2 = 0;
/* 137 */       if (bottomMeta > 8) {
/*     */         
/* 139 */         m2 = bottomMeta - 8;
/* 140 */         bottomMeta = 8;
/*     */       } 
/*     */       
/* 143 */       world.func_147465_d(x, y - 1, z, this, bottomMeta, 2);
/*     */       
/* 145 */       if (m2 > 0) {
/*     */         
/* 147 */         world.func_147465_d(x, y, z, this, m2, 2);
/* 148 */         world.func_147460_e(x, y + 1, z, this);
/*     */       } else {
/*     */         
/* 151 */         world.func_147468_f(x, y, z);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void combineCharcoalUp(World world, int x, int y, int z) {
/* 157 */     int meta = world.func_72805_g(x, y + 1, z);
/* 158 */     int bottomMeta = world.func_72805_g(x, y, z);
/*     */     
/* 160 */     if (bottomMeta < 8) {
/*     */       
/* 162 */       bottomMeta += meta;
/* 163 */       int m2 = 0;
/* 164 */       if (bottomMeta > 8) {
/*     */         
/* 166 */         m2 = bottomMeta - 8;
/* 167 */         bottomMeta = 8;
/*     */       } 
/*     */       
/* 170 */       world.func_147465_d(x, y, z, this, bottomMeta, 2);
/*     */       
/* 172 */       if (m2 > 0) {
/*     */         
/* 174 */         world.func_147465_d(x, y + 1, z, this, m2, 2);
/* 175 */         world.func_147460_e(x, y + 2, z, this);
/*     */       } else {
/*     */         
/* 178 */         world.func_147468_f(x, y + 1, z);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 185 */     if (!world.field_72995_K)
/*     */     {
/* 187 */       if (world.func_147437_c(x, y - 1, z)) {
/*     */         
/* 189 */         int meta = world.func_72805_g(x, y, z);
/* 190 */         world.func_147465_d(x, y - 1, z, this, meta, 2);
/* 191 */         world.func_147468_f(x, y, z);
/*     */       }
/*     */       else {
/*     */         
/* 195 */         if (world.func_147439_a(x, y - 1, z) == this) {
/* 196 */           combineCharcoalDown(world, x, y, z);
/*     */         }
/* 198 */         if (world.func_147439_a(x, y + 1, z) == this) {
/* 199 */           combineCharcoalUp(world, x, y, z);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 211 */     int md = world.func_72805_g(x, y, z);
/*     */     
/* 213 */     if (md == 8) {
/* 214 */       return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), (y + 1), (z + 1));
/*     */     }
/* 216 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), (y + 0.125F * md), (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess bAccess, int x, int y, int z) {
/* 222 */     int meta = bAccess.func_72805_g(x, y, z);
/* 223 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F * meta, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion ex) {
/* 229 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion ex) {
/* 235 */     if (!world.field_72995_K) {
/*     */       
/* 237 */       int amount = world.func_72805_g(x, y, z);
/* 238 */       if (amount > 0) {
/*     */         
/* 240 */         Random rand = new Random();
/*     */         
/* 242 */         amount = rand.nextInt(amount + 1) + amount / 2;
/* 243 */         func_149642_a(world, x, y, z, new ItemStack(TFCItems.coal, amount, 1));
/*     */       } 
/*     */     } 
/*     */     
/* 247 */     super.onBlockExploded(world, x, y, z, ex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion ex) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 258 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockCharcoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */