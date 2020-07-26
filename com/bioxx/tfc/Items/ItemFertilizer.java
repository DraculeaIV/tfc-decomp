/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemFertilizer
/*    */   extends ItemTerra
/*    */ {
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 21 */     if (!world.field_72995_K)
/*    */     {
/* 23 */       if (TFC_Core.isFarmland(world.func_147439_a(x, y, z))) {
/*    */         
/* 25 */         TEFarmland tef = (TEFarmland)world.func_147438_o(x, y, z);
/* 26 */         if (tef.nutrients[3] != tef.getSoilMax())
/*    */         {
/* 28 */           return tef.fertilize(itemstack, false);
/*    */         }
/*    */       }
/* 31 */       else if (world.func_147438_o(x, y, z) instanceof com.bioxx.tfc.TileEntities.TECrop && TFC_Core.isFarmland(world.func_147439_a(x, y - 1, z))) {
/*    */         
/* 33 */         TEFarmland tef = (TEFarmland)world.func_147438_o(x, y - 1, z);
/* 34 */         if (tef.nutrients[3] != tef.getSoilMax())
/*    */         {
/* 36 */           return tef.fertilize(itemstack, false);
/*    */         }
/*    */       } 
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemFertilizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */