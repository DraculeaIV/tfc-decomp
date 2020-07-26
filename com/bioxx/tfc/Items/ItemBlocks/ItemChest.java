/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEChest;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemChest
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemChest(Block par1) {
/* 19 */     super(par1);
/* 20 */     func_77627_a(true);
/* 21 */     this.metaNames = Global.WOOD_ALL;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
/* 28 */     if (!world.func_147465_d(x, y, z, this.field_150939_a, 0, 3))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (world.func_147439_a(x, y, z) == this.field_150939_a) {
/*    */       
/* 35 */       this.field_150939_a.func_149689_a(world, x, y, z, (EntityLivingBase)player, stack);
/* 36 */       this.field_150939_a.func_149714_e(world, x, y, z, 0);
/*    */       
/* 38 */       TEChest chest = (TEChest)world.func_147438_o(x, y, z);
/* 39 */       if (metadata >= Global.WOOD_ALL.length) {
/*    */         
/* 41 */         metadata /= 2;
/* 42 */         chest.isDoubleChest = true;
/*    */       } 
/* 44 */       chest.type = metadata;
/*    */     } 
/*    */ 
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 54 */     for (int i = 0; i < Global.WOOD_ALL.length; i++)
/* 55 */       list.add(new ItemStack((Item)this, 1, i)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */