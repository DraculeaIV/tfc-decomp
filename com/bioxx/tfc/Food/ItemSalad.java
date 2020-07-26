/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import com.bioxx.tfc.api.TFCCrafting;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSalad
/*    */   extends ItemMeal
/*    */ {
/*    */   public ItemSalad() {
/* 23 */     this.field_77787_bX = true;
/* 24 */     this.metaNames = new String[] { "Salad0", "Salad1", "Salad2", "Salad3" };
/* 25 */     this.metaIcons = new net.minecraft.util.IIcon[4];
/* 26 */     setFolder("food/");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 32 */     list.add(createTag(new ItemStack((Item)this, 1)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static ItemStack createTag(ItemStack is) {
/* 38 */     ItemMeal.createTag(is);
/* 39 */     int[] foodGroups = { -1, -1, -1, -1 };
/* 40 */     Food.setFoodGroups(is, foodGroups);
/* 41 */     return is;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/* 48 */     is = super.func_77654_b(is, world, player);
/*    */ 
/*    */     
/* 51 */     if (is.field_77994_a == 0)
/*    */     {
/*    */       
/* 54 */       if (TFCCrafting.enableBowlsAlwaysBreak || world.field_73012_v.nextInt(2) == 0) {
/*    */         
/* 56 */         world.func_72956_a((Entity)player, "terrafirmacraft:item.ceramicbreak", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F);
/*    */       
/*    */       }
/* 59 */       else if (!player.field_71071_by.func_70441_a(new ItemStack(TFCItems.potteryBowl, 1, 1))) {
/*    */ 
/*    */         
/* 62 */         return new ItemStack(TFCItems.potteryBowl, 1, 1);
/*    */       } 
/*    */     }
/*    */     
/* 66 */     return is;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemSalad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */