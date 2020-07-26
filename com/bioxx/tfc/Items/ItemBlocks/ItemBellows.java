/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemBellows
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemBellows(Block par1) {
/* 17 */     super(par1);
/* 18 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 24 */     if (!world.field_72995_K) {
/*    */       
/* 26 */       int l = MathHelper.func_76128_c((player.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 27 */       if (side == 1 && world.func_147439_a(x, y, z).func_149721_r() && world.func_147439_a(x, y, z).func_149662_c() && world.func_147437_c(x, y + 1, z)) {
/*    */         
/* 29 */         world.func_147465_d(x, y + 1, z, TFCBlocks.bellows, l, 2);
/* 30 */         (player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c]).field_77994_a--;
/* 31 */         return true;
/*    */       } 
/*    */     } 
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumSize getSize(ItemStack is) {
/* 39 */     return EnumSize.HUGE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */