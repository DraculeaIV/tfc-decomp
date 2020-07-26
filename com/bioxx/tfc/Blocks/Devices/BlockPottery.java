/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.TileEntities.TEPottery;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
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
/*     */ public class BlockPottery
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public IIcon clay;
/*     */   public IIcon ceramic;
/*     */   public IIcon straw;
/*     */   
/*     */   public BlockPottery() {
/*  42 */     super(Material.field_151592_s);
/*  43 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
/*  44 */     func_149711_c(2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  50 */     this.clay = iconRegisterer.func_94245_a("terrafirmacraft:clay/Clay");
/*  51 */     this.ceramic = iconRegisterer.func_94245_a("terrafirmacraft:clay/Ceramic");
/*  52 */     this.straw = iconRegisterer.func_94245_a("terrafirmacraft:plants/Straw");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  58 */     return this.straw;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) {
/*  64 */     return func_149691_a(side, bAccess.func_72805_g(x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
/*  70 */     TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/*  71 */     return (side == ForgeDirection.UP && te != null && te.wood == 8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
/*  77 */     TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/*  78 */     return (te.isLit() && side == ForgeDirection.UP);
/*     */   }
/*     */ 
/*     */   
/*     */   public int idDropped(int metadata, Random rand, int fortune) {
/*  83 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/*  89 */     if (!world.field_72995_K) {
/*     */       
/*  91 */       TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/*     */       
/*  93 */       if (te.isLit() || (player.field_71071_by.func_70448_g() != null && (player.field_71071_by
/*  94 */         .func_70448_g().func_77973_b() == TFCItems.flintSteel || player.field_71071_by.func_70448_g().func_77973_b() == TFCItems.fireStarter))) {
/*  95 */         return false;
/*     */       }
/*  97 */       if (player.field_71071_by.func_70448_g() != null && player.field_71071_by.func_70448_g().func_77973_b() == TFCItems.straw && !player.func_70093_af()) {
/*     */         
/*  99 */         te.addStraw(player.field_71071_by.func_70448_g(), player);
/* 100 */         return true;
/*     */       } 
/* 102 */       if (player.field_71071_by.func_70448_g() != null && player.field_71071_by.func_70448_g().func_77973_b() instanceof com.bioxx.tfc.Items.ItemLogs && !player.func_70093_af() && te.straw == 8) {
/*     */         
/* 104 */         if (te.addLog(player.field_71071_by.func_70448_g(), player))
/*     */         {
/* 106 */           world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, TFCBlocks.logNatural.field_149762_H.func_150496_b(), (TFCBlocks.logNatural.field_149762_H.func_150497_c() + 1.0F) / 2.0F, TFCBlocks.logNatural.field_149762_H.func_150494_d() * 0.8F);
/* 107 */           return true;
/*     */         }
/*     */       
/* 110 */       } else if ((player.field_71071_by.func_70448_g() != null && !(player.field_71071_by.func_70448_g().func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryBase)) || (te
/* 111 */         .func_70301_a(0) != null && te.func_70301_a(1) != null && te.func_70301_a(2) != null && te.func_70301_a(3) != null) || player.field_71071_by
/* 112 */         .func_70448_g() == null) {
/*     */         
/* 114 */         if (te.wood > 0) {
/*     */           
/* 116 */           te.ejectItem(3 + te.wood);
/* 117 */           te.wood--;
/* 118 */           world.func_147471_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*     */         }
/* 120 */         else if (te.wood == 0 && side == 1 && player.func_70093_af()) {
/*     */           
/* 122 */           if ((te.func_70301_a(0) != null && te.func_70301_a(0).func_77973_b() instanceof net.minecraft.item.ItemBlock) || (hitX < 0.5D && hitZ < 0.5D)) {
/* 123 */             te.ejectItem(0);
/* 124 */           } else if (hitX > 0.5D && hitZ < 0.5D) {
/* 125 */             te.ejectItem(1);
/* 126 */           } else if (hitX < 0.5D && hitZ > 0.5D) {
/* 127 */             te.ejectItem(2);
/* 128 */           } else if (hitX > 0.5D && hitZ > 0.5D) {
/* 129 */             te.ejectItem(3);
/* 130 */           }  world.func_147471_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*     */         } 
/*     */       } 
/*     */     } 
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 140 */     TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 141 */     int h = 0;
/* 142 */     int w = 0;
/* 143 */     if (te != null) {
/*     */       
/* 145 */       h = (te.straw == 0) ? 1 : te.straw;
/* 146 */       w = ((te.wood > 0) ? 1 : 0) + ((te.wood > 4) ? 1 : 0);
/*     */     } 
/* 148 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), (y + 0.0625F * h + 0.25F * w), (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/* 154 */     TEPottery te = (TEPottery)access.func_147438_o(x, y, z);
/* 155 */     int h = 0;
/* 156 */     int w = 0;
/* 157 */     if (te != null) {
/*     */       
/* 159 */       h = (te.straw == 0) ? 1 : te.straw;
/* 160 */       w = ((te.wood > 0) ? 1 : 0) + ((te.wood > 4) ? 1 : 0);
/*     */     } 
/* 162 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F * h + 0.25F * w, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 168 */     return TFCBlocks.potteryRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void eject(World world, int x, int y, int z) {
/* 185 */     if (!world.field_72995_K && world.func_147438_o(x, y, z) instanceof TEPottery) {
/*     */       
/* 187 */       TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 188 */       te.ejectContents();
/* 189 */       world.func_147475_p(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 196 */     eject(world, x, y, z);
/* 197 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random rand, int j) {
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 209 */     return (TileEntity)new TEPottery();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 215 */     if (!world.field_72995_K)
/*     */     {
/* 217 */       if (!world.isSideSolid(x, y - 1, z, ForgeDirection.UP)) {
/*     */         
/* 219 */         ((TEPottery)world.func_147438_o(x, y, z)).ejectContents();
/* 220 */         world.func_147468_f(x, y, z);
/*     */         return;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess access, int x, int y, int z, int side) {
/* 230 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 236 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockPottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */