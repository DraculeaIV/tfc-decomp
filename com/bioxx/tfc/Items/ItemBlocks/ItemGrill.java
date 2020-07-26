/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.TileEntities.TEGrill;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemGrill
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemGrill(Block par1) {
/* 21 */     super(par1);
/* 22 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 28 */     if (!world.field_72995_K)
/*    */     {
/* 30 */       if (side == 1 && world.func_147437_c(x, y + 1, z)) {
/*    */         
/* 32 */         int out = side;
/* 33 */         int hinge = 0;
/*    */         
/* 35 */         if (hitX < 0.2D) {
/* 36 */           hinge = 0;
/* 37 */         } else if (hitZ < 0.2D) {
/* 38 */           hinge = 1;
/* 39 */         } else if (hitX > 0.8D) {
/* 40 */           hinge = 2;
/* 41 */         } else if (hitZ > 0.8D) {
/* 42 */           hinge = 3;
/*    */         } else {
/* 44 */           hinge = 0;
/*    */         } 
/* 46 */         out += hinge << 4;
/*    */         
/* 48 */         TileEntity teFire = world.func_147438_o(x, y, z);
/* 49 */         if (teFire != null && teFire instanceof com.bioxx.tfc.api.TileEntities.TEFireEntity && checkSides(world, x, y, z)) {
/*    */           
/* 51 */           if (world.func_147465_d(x, y + 1, z, TFCBlocks.grill, itemstack.func_77960_j(), 2))
/*    */           {
/* 53 */             TEGrill teGrill = (TEGrill)world.func_147438_o(x, y + 1, z);
/* 54 */             teGrill.data = (byte)out;
/*    */           }
/*    */         
/*    */         }
/* 58 */         else if (world.func_147437_c(x, y + 2, z) && checkSides(world, x, y + 1, z)) {
/*    */           
/* 60 */           if (world.func_147465_d(x, y + 2, z, TFCBlocks.grill, itemstack.func_77960_j(), 2)) {
/*    */             
/* 62 */             TEGrill teGrill = (TEGrill)world.func_147438_o(x, y + 2, z);
/* 63 */             teGrill.data = (byte)out;
/*    */           } 
/*    */         } else {
/*    */           
/* 67 */           return false;
/* 68 */         }  (player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c]).field_77994_a--;
/* 69 */         return true;
/*    */       } 
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean checkSides(World world, int x, int y, int z) {
/* 77 */     int count = 0;
/* 78 */     if (world.func_147439_a(x - 1, y, z).isSideSolid((IBlockAccess)world, x - 1, y, z, ForgeDirection.WEST))
/*    */     {
/* 80 */       count++;
/*    */     }
/* 82 */     if (world.func_147439_a(x + 1, y, z).isSideSolid((IBlockAccess)world, x + 1, y, z, ForgeDirection.EAST))
/*    */     {
/* 84 */       count++;
/*    */     }
/* 86 */     if (world.func_147439_a(x, y, z - 1).isSideSolid((IBlockAccess)world, x, y, z - 1, ForgeDirection.SOUTH))
/*    */     {
/* 88 */       count++;
/*    */     }
/* 90 */     if (world.func_147439_a(x, y, z + 1).isSideSolid((IBlockAccess)world, x, y, z + 1, ForgeDirection.NORTH))
/*    */     {
/* 92 */       count++;
/*    */     }
/* 94 */     return (count >= 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumSize getSize(ItemStack is) {
/* 99 */     return EnumSize.HUGE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */