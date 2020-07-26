/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TESmokeRack;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSmokeRack
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public BlockSmokeRack() {
/*  35 */     super(Material.field_151594_q);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess world, int x, int y, int z) {
/*  41 */     if ((world.func_72805_g(x, y, z) & 0x1) == 0) {
/*     */       
/*  43 */       func_149676_a(0.45F, 0.45F, 0.0F, 0.55F, 0.55F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/*  47 */       func_149676_a(0.0F, 0.45F, 0.45F, 1.0F, 0.55F, 0.55F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/*  66 */     return new ItemStack(TFCItems.woolYarn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  72 */     boolean flag = false;
/*  73 */     if (!world.field_72995_K) {
/*     */       
/*  75 */       int meta = world.func_72805_g(x, y, z);
/*  76 */       TESmokeRack te = (TESmokeRack)world.func_147438_o(x, y, z);
/*  77 */       ItemStack yarn = TFC_Core.getItemInInventory(TFCItems.woolYarn, (IInventory)entityplayer.field_71071_by);
/*  78 */       if ((meta & 0x1) == 0 && hitZ < 0.5D) {
/*     */         
/*  80 */         if (te.func_70301_a(0) == null && yarn != null && isItemValid(entityplayer.field_71071_by.func_70448_g()))
/*     */         {
/*  82 */           te.func_70299_a(0, entityplayer.field_71071_by.func_70448_g().func_77946_l());
/*  83 */           (entityplayer.field_71071_by.func_70448_g()).field_77994_a--;
/*  84 */           entityplayer.field_71071_by.func_146026_a(TFCItems.woolYarn);
/*  85 */           flag = true;
/*     */         }
/*  87 */         else if (te.func_70301_a(0) != null)
/*     */         {
/*  89 */           TFC_Core.giveItemToPlayer(te.removeStackInSlot(0), entityplayer);
/*  90 */           flag = true;
/*     */         }
/*     */       
/*  93 */       } else if ((meta & 0x1) == 0 && hitZ >= 0.5D) {
/*     */         
/*  95 */         if (te.func_70301_a(1) == null && yarn != null && isItemValid(entityplayer.field_71071_by.func_70448_g()))
/*     */         {
/*  97 */           te.func_70299_a(1, entityplayer.field_71071_by.func_70448_g().func_77946_l());
/*  98 */           (entityplayer.field_71071_by.func_70448_g()).field_77994_a--;
/*  99 */           entityplayer.field_71071_by.func_146026_a(TFCItems.woolYarn);
/* 100 */           flag = true;
/*     */         }
/* 102 */         else if (te.func_70301_a(1) != null)
/*     */         {
/* 104 */           TFC_Core.giveItemToPlayer(te.removeStackInSlot(1), entityplayer);
/* 105 */           flag = true;
/*     */         }
/*     */       
/* 108 */       } else if ((meta & 0x1) == 1 && hitX < 0.5D) {
/*     */         
/* 110 */         if (te.func_70301_a(0) == null && yarn != null && isItemValid(entityplayer.field_71071_by.func_70448_g()))
/*     */         {
/* 112 */           te.func_70299_a(0, entityplayer.field_71071_by.func_70448_g().func_77946_l());
/* 113 */           (entityplayer.field_71071_by.func_70448_g()).field_77994_a--;
/* 114 */           entityplayer.field_71071_by.func_146026_a(TFCItems.woolYarn);
/* 115 */           flag = true;
/*     */         }
/* 117 */         else if (te.func_70301_a(0) != null)
/*     */         {
/* 119 */           TFC_Core.giveItemToPlayer(te.removeStackInSlot(0), entityplayer);
/* 120 */           flag = true;
/*     */         }
/*     */       
/* 123 */       } else if ((meta & 0x1) == 1 && hitX >= 0.5D) {
/*     */         
/* 125 */         if (te.func_70301_a(1) == null && yarn != null && isItemValid(entityplayer.field_71071_by.func_70448_g())) {
/*     */           
/* 127 */           te.func_70299_a(1, entityplayer.field_71071_by.func_70448_g().func_77946_l());
/* 128 */           (entityplayer.field_71071_by.func_70448_g()).field_77994_a--;
/* 129 */           entityplayer.field_71071_by.func_146026_a(TFCItems.woolYarn);
/* 130 */           return true;
/*     */         } 
/* 132 */         if (te.func_70301_a(1) != null) {
/*     */           
/* 134 */           TFC_Core.giveItemToPlayer(te.removeStackInSlot(1), entityplayer);
/* 135 */           flag = true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 139 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isItemValid(ItemStack is) {
/* 144 */     if (is == null)
/* 145 */       return false; 
/* 146 */     if (is.func_77973_b() instanceof com.bioxx.tfc.Food.ItemFoodMeat) {
/*     */       
/* 148 */       if (!Food.isCooked(is) && Food.isBrined(is)) {
/* 149 */         return true;
/*     */       }
/* 151 */     } else if (is.func_77973_b() == TFCItems.cheese) {
/*     */       
/* 153 */       if (!Food.isCooked(is)) {
/* 154 */         return true;
/*     */       }
/*     */     } 
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 169 */     return TFCBlocks.smokeRackRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 175 */     int meta = world.func_72805_g(x, y, z);
/* 176 */     if (!world.field_72995_K) {
/*     */       
/* 178 */       if ((meta & 0x1) == 0) {
/*     */         
/* 180 */         if (!isValidNeighbor(world, x, y, z - 1, ForgeDirection.NORTH) || !isValidNeighbor(world, x, y, z + 1, ForgeDirection.SOUTH))
/*     */         {
/* 182 */           TFC_Core.destroyBlock(world, x, y, z);
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 187 */       else if (!isValidNeighbor(world, x - 1, y, z, ForgeDirection.WEST) || !isValidNeighbor(world, x + 1, y, z, ForgeDirection.EAST)) {
/*     */         
/* 189 */         TFC_Core.destroyBlock(world, x, y, z);
/*     */       } 
/*     */ 
/*     */       
/* 193 */       if (world.func_147439_a(x, y + 1, z) instanceof com.bioxx.tfc.Blocks.Terrain.BlockCollapsible)
/*     */       {
/* 195 */         TFC_Core.destroyBlock(world, x, y, z);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isValidNeighbor(World world, int x, int y, int z, ForgeDirection dir) {
/* 202 */     Block b = world.func_147439_a(x, y, z);
/* 203 */     return (b == this || b.isSideSolid((IBlockAccess)world, x, y, z, dir.getOpposite()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int i, int j, int k) {
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 221 */     if ((world.func_72805_g(x, y, z) & 0x1) == 0)
/*     */     {
/* 223 */       return AxisAlignedBB.func_72330_a(x + 0.45D, y + 0.45D, z, x + 0.55D, y + 0.55D, (z + 1));
/*     */     }
/*     */ 
/*     */     
/* 227 */     return AxisAlignedBB.func_72330_a(x, y + 0.45D, z + 0.45D, (x + 1), y + 0.55D, z + 0.55D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random rand, int j) {
/* 234 */     return TFCItems.woolYarn;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister reg) {
/* 241 */     this.field_149761_L = reg.func_94245_a("terrafirmacraft:String");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createTileEntity(World world, int meta) {
/* 247 */     return (TileEntity)new TESmokeRack();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockSmokeRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */