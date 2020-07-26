/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ public class ItemYarn
/*    */   extends ItemTerra
/*    */ {
/* 16 */   protected final int[][] sidesMap = new int[][] { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemYarn() {
/* 21 */     this.field_77787_bX = false;
/* 22 */     func_77656_e(0);
/* 23 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 29 */     if (!world.field_72995_K && side > 1 && !world.func_147439_a(x, y, z).equals(TFCBlocks.loom)) {
/*    */       
/* 31 */       int length = 0;
/* 32 */       int[] map = this.sidesMap[side];
/* 33 */       ForgeDirection opp = ForgeDirection.VALID_DIRECTIONS[side].getOpposite(); int i;
/* 34 */       for (i = 1; i < 6; i++) {
/*    */         
/* 36 */         int xCoord = x + map[0] * i;
/* 37 */         int yCoord = y + map[1] * i;
/* 38 */         int zCoord = z + map[2] * i;
/* 39 */         Block b = world.func_147439_a(xCoord, yCoord, zCoord);
/*    */         
/* 41 */         if (b.func_149688_o().func_76222_j()) {
/*    */           
/* 43 */           length++;
/*    */         } else {
/* 45 */           if (!b.isSideSolid((IBlockAccess)world, xCoord, yCoord, zCoord, opp) && !(b instanceof com.bioxx.tfc.Blocks.BlockWoodSupport))
/*    */           {
/* 47 */             return false;
/*    */           }
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/*    */       
/* 54 */       if (length == 5) {
/*    */         
/* 56 */         int xCoord = x + map[0] * 6;
/* 57 */         int yCoord = y + map[1] * 6;
/* 58 */         int zCoord = z + map[2] * 6;
/* 59 */         Block b = world.func_147439_a(xCoord, yCoord, zCoord);
/* 60 */         if (!b.isSideSolid((IBlockAccess)world, xCoord, yCoord, zCoord, opp) && !(b instanceof com.bioxx.tfc.Blocks.BlockWoodSupport))
/*    */         {
/* 62 */           return false;
/*    */         }
/*    */       } 
/*    */       
/* 66 */       if (is.field_77994_a < length) {
/* 67 */         return false;
/*    */       }
/* 69 */       for (i = 1; i <= length; i++) {
/*    */         
/* 71 */         int xCoord = x + map[0] * i;
/* 72 */         int yCoord = y + map[1] * i;
/* 73 */         int zCoord = z + map[2] * i;
/* 74 */         int meta = (side & 0x4) >> 2;
/* 75 */         world.func_147465_d(xCoord, yCoord, zCoord, TFCBlocks.smokeRack, meta, 2);
/* 76 */         is.field_77994_a--;
/*    */       } 
/*    */       
/* 79 */       return true;
/*    */     } 
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemYarn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */