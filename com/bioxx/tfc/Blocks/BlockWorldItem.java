/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TileEntities.TEWorldItem;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockWorldItem
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public BlockWorldItem() {
/*  31 */     super(Material.field_151594_q);
/*  32 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/*  38 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int x, int y, int z, int meta) {
/*  49 */     if (!world.field_72995_K) {
/*     */       
/*  51 */       TileEntity te = world.func_147438_o(x, y, z);
/*  52 */       if (te instanceof IInventory) {
/*  53 */         IInventory inv = (IInventory)te;
/*  54 */         for (int i = 0; i < inv.func_70302_i_(); i++) {
/*  55 */           if (inv.func_70301_a(i) != null) {
/*  56 */             EntityItem ei = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, inv.func_70301_a(i));
/*  57 */             inv.func_70299_a(i, null);
/*  58 */             ei.field_70159_w = 0.0D;
/*  59 */             ei.field_70181_x = 0.0D;
/*  60 */             ei.field_70179_y = 0.0D;
/*  61 */             world.func_72838_d((Entity)ei);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  66 */     super.func_149725_f(world, x, y, z, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  84 */     if (!world.field_72995_K)
/*  85 */       return world.func_147468_f(x, y, z); 
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/*  98 */     if (world.func_147437_c(x, y - 1, z)) {
/*     */       
/* 100 */       world.func_147468_f(x, y, z);
/*     */       return;
/*     */     } 
/* 103 */     if (!world.func_147439_a(x, y - 1, z).isSideSolid((IBlockAccess)world, x, y - 1, z, ForgeDirection.UP)) {
/*     */       
/* 105 */       world.func_147468_f(x, y, z);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/* 131 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 137 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), y + 0.25D, (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister reg) {
/* 144 */     this.field_149761_L = TFC_Textures.invisibleTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createTileEntity(World world, int meta) {
/* 150 */     return (TileEntity)new TEWorldItem();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockWorldItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */