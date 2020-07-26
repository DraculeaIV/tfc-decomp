/*     */ package com.bioxx.tfc.Blocks.Vanilla;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlowerPot;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFlowerPot;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
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
/*     */ public class BlockCustomFlowerPot
/*     */   extends BlockFlowerPot
/*     */ {
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/*  37 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*     */     
/*  39 */     if (itemstack != null) {
/*     */       
/*  41 */       TileEntityFlowerPot teFlowerPot = getTileEntity(world, x, y, z);
/*     */       
/*  43 */       if (teFlowerPot != null) {
/*     */         
/*  45 */         if (teFlowerPot.func_145965_a() != null)
/*     */         {
/*  47 */           return false;
/*     */         }
/*     */         
/*  50 */         Item item = itemstack.func_77973_b();
/*  51 */         int meta = itemstack.func_77960_j();
/*     */         
/*  53 */         if (validItem(item, meta)) {
/*     */           
/*  55 */           teFlowerPot.func_145964_a(item, meta);
/*  56 */           teFlowerPot.func_70296_d();
/*     */           
/*  58 */           if (!world.func_72921_c(x, y, z, meta, 2))
/*     */           {
/*  60 */             world.func_147471_g(x, y, z);
/*     */           }
/*     */           
/*  63 */           if (!player.field_71075_bZ.field_75098_d && --itemstack.field_77994_a <= 0)
/*     */           {
/*  65 */             player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*     */           }
/*     */           
/*  68 */           return true;
/*     */         } 
/*     */ 
/*     */         
/*  72 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  77 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validItem(Item item, int meta) {
/*  88 */     if (item instanceof net.minecraft.item.ItemBlock) {
/*     */       
/*  90 */       Block block = Block.func_149634_a(item);
/*     */ 
/*     */       
/*  93 */       if (block == TFCBlocks.cactus || block == TFCBlocks.flora || block == TFCBlocks.flowers || block == TFCBlocks.flowers2 || block == TFCBlocks.fungi || block == TFCBlocks.sapling || block == TFCBlocks.sapling2 || (block == TFCBlocks.tallGrass && meta == 1))
/*     */       {
/*  95 */         return true;
/*     */       }
/*     */       
/*  98 */       if (block == Blocks.field_150327_N || block == Blocks.field_150328_O || block == Blocks.field_150434_aF || block == Blocks.field_150338_P || block == Blocks.field_150337_Q || block == Blocks.field_150345_g || block == Blocks.field_150330_I || (block == Blocks.field_150329_H && meta == 2))
/*     */       {
/* 100 */         return true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private TileEntityFlowerPot getTileEntity(World world, int x, int y, int z) {
/* 110 */     TileEntity tileentity = world.func_147438_o(x, y, z);
/* 111 */     return (tileentity != null && tileentity instanceof TileEntityFlowerPot) ? (TileEntityFlowerPot)tileentity : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149702_O() {
/* 121 */     return "terrafirmacraft:flower_pot";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random rand, int j) {
/* 127 */     return Item.func_150898_a(TFCBlocks.flowerPot);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
/* 133 */     TileEntityFlowerPot teFlowerPot = getTileEntity(world, x, y, z);
/*     */     
/* 135 */     if (teFlowerPot != null)
/*     */     {
/* 137 */       return new ItemStack(teFlowerPot.func_145965_a(), 1, teFlowerPot.func_145966_b());
/*     */     }
/* 139 */     return new ItemStack(TFCBlocks.flowerPot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 148 */     return TFCBlocks.flowerPotRenderId;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomFlowerPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */