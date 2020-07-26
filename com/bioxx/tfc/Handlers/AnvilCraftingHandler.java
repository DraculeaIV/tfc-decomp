/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.api.Events.AnvilCraftEvent;
/*    */ import com.bioxx.tfc.api.Events.ItemCookEvent;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnvilCraftingHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onAnvilCraft(AnvilCraftEvent event) {
/* 21 */     if (event.input1.func_77973_b() == TFCItems.bloom && event.input1.func_77960_j() > 100) {
/*    */       
/* 23 */       TileEntity te = event.anvilTE;
/* 24 */       World world = te.func_145831_w();
/* 25 */       int dam = event.input1.func_77960_j();
/* 26 */       float temp = (event.input1.func_77978_p() != null) ? TFC_ItemHeat.getTemp(event.input1) : 0.0F;
/* 27 */       int count = dam / 100;
/* 28 */       int rem = dam % 100;
/* 29 */       while (count > 0) {
/*    */         
/* 31 */         ItemStack out1 = new ItemStack(TFCItems.bloom, 1, 100);
/* 32 */         TFC_ItemHeat.setTemp(out1, temp);
/*    */         
/* 34 */         EntityItem ei = new EntityItem(world, te.field_145851_c + 0.5D, te.field_145848_d + 1.5D, te.field_145849_e + 0.5D, out1);
/* 35 */         ei.field_70159_w = 0.0D; ei.field_70181_x = 0.0D; ei.field_70179_y = 0.0D; ei.field_145804_b = 0;
/* 36 */         world.func_72838_d((Entity)ei);
/*    */         
/* 38 */         count--;
/*    */       } 
/* 40 */       if (rem > 0) {
/*    */         
/* 42 */         ItemStack out2 = new ItemStack(TFCItems.bloom, 1, rem);
/* 43 */         TFC_ItemHeat.setTemp(out2, temp);
/*    */         
/* 45 */         EntityItem ei = new EntityItem(world, te.field_145851_c + 0.5D, te.field_145848_d + 1.5D, te.field_145849_e + 0.5D, out2);
/* 46 */         ei.field_70159_w = 0.0D; ei.field_70181_x = 0.0D; ei.field_70179_y = 0.0D; ei.field_145804_b = 0;
/* 47 */         world.func_72838_d((Entity)ei);
/*    */       } 
/* 49 */       event.result = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onItemMelt(ItemCookEvent event) {
/* 63 */     if (event.input1 != null)
/*    */     {
/* 65 */       if ((event.input1.func_77973_b() == TFCItems.bloom || event.input1.func_77973_b() == TFCItems.rawBloom) && event.result.func_77960_j() > 100) {
/*    */         
/* 67 */         event.result = event.input1;
/* 68 */         event.result.func_77964_b(event.result.func_77960_j() - 1);
/*    */       }
/* 70 */       else if ((event.input1.func_77973_b() == TFCItems.bloom || event.input1.func_77973_b() == TFCItems.rawBloom) && event.result.func_77960_j() <= 100) {
/*    */         
/* 72 */         event.result.func_77964_b(100 - event.input1.func_77960_j());
/*    */       }
/* 74 */       else if (event.result != null && event.result.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*    */         
/* 76 */         event.result.field_77990_d = event.input1.field_77990_d;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\AnvilCraftingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */