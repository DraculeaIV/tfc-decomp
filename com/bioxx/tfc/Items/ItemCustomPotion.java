/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemPotion;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemCustomPotion
/*    */   extends ItemPotion
/*    */ {
/*    */   public ItemCustomPotion() {
/* 25 */     func_77637_a(TFCTabs.TFC_FOODS);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/* 31 */     if (!player.field_71075_bZ.field_75098_d)
/*    */     {
/* 33 */       is.field_77994_a--;
/*    */     }
/*    */     
/* 36 */     if (!world.field_72995_K) {
/*    */       
/* 38 */       List var4 = func_77832_l(is);
/*    */       
/* 40 */       if (var4 != null) {
/*    */         
/* 42 */         Iterator<PotionEffect> var5 = var4.iterator();
/*    */         
/* 44 */         while (var5.hasNext())
/*    */         {
/* 46 */           PotionEffect var6 = var5.next();
/* 47 */           player.func_70690_d(new PotionEffect(var6));
/*    */         }
/*    */       
/*    */       } else {
/*    */         
/* 52 */         TFC_Core.getPlayerFoodStats(player).restoreWater(player, 12000);
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     if (!player.field_71075_bZ.field_75098_d) {
/*    */       
/* 58 */       boolean broken = false;
/* 59 */       if (world.field_73012_v.nextInt(50) == 0) {
/*    */         
/* 61 */         player.func_85030_a("random.glass", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F);
/* 62 */         broken = true;
/*    */       } 
/*    */       
/* 65 */       if (!broken && is.field_77994_a <= 0)
/*    */       {
/* 67 */         return new ItemStack(TFCItems.glassBottle);
/*    */       }
/*    */     } 
/*    */     
/* 71 */     return is;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemCustomPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */