/*    */ package com.bioxx.tfc.Food;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.Items.ItemTerra;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.api.Enums.EnumFoodGroup;
/*    */ import com.bioxx.tfc.api.Food;
/*    */ import com.bioxx.tfc.api.Interfaces.IFood;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemEgg
/*    */   extends ItemFoodTFC
/*    */   implements IFood
/*    */ {
/*    */   public ItemEgg() {
/* 23 */     super(EnumFoodGroup.Protein, 0, 0, 0, 0, 0, false, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 29 */     list.add(createTag(new ItemStack((Item)this, 1), 2.0F));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 35 */     ItemTerra.addSizeInformation(is, arraylist);
/* 36 */     arraylist.add(getFoodGroupName(getFoodGroup()));
/* 37 */     addFoodHeatInformation(is, arraylist);
/*    */     
/* 39 */     if (is.func_77942_o()) {
/*    */       
/* 41 */       if (is.func_77978_p().func_74764_b("Fertilized")) {
/* 42 */         arraylist.add(EnumChatFormatting.GOLD + TFC_Core.translate("gui.fertilized"));
/*    */       } else {
/* 44 */         addFoodInformation(is, player, arraylist);
/*    */       } 
/*    */     } else {
/*    */       
/* 48 */       arraylist.add(TFC_Core.translate("gui.badnbt"));
/* 49 */       TerraFirmaCraft.LOG.error(TFC_Core.translate("error.error") + " " + is.func_77977_a() + " " + 
/* 50 */           TFC_Core.translate("error.NBT") + " " + TFC_Core.translate("error.Contact"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onUpdate(ItemStack is, World world, int x, int y, int z) {
/* 57 */     if (is.func_77942_o()) {
/*    */       
/* 59 */       if (is.func_77978_p().func_74764_b("Fertilized")) {
/*    */         
/* 61 */         is.field_77990_d.func_82580_o("Fertilized");
/* 62 */         is.field_77990_d.func_82580_o("Genes");
/*    */       } 
/* 64 */       if (is.func_77978_p().func_74764_b("Fertilized"))
/*    */       {
/* 66 */         return true;
/*    */       }
/*    */     } 
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getDecayRate(ItemStack is) {
/* 75 */     if (Food.isPickled(is))
/* 76 */       return 0.3F; 
/* 77 */     return 0.5F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Food\ItemEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */