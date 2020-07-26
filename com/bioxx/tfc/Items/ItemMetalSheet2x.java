/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemMetalSheet2x
/*    */   extends ItemMetalSheet
/*    */ {
/*    */   public ItemMetalSheet2x(int mID) {
/* 15 */     super(mID);
/* 16 */     func_77656_e(0);
/* 17 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/* 18 */     setWeight(EnumWeight.HEAVY);
/* 19 */     setSize(EnumSize.MEDIUM);
/* 20 */     this.metalAmount = 400;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemMetalSheet2x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */