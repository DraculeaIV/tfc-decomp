/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.Devices.BlockSluice;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSluice
/*    */   extends ItemTerra
/*    */ {
/*    */   public ItemSluice() {
/* 19 */     setWeight(EnumWeight.HEAVY);
/* 20 */     setSize(EnumSize.HUGE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPlacedBlockMetadata(int i) {
/* 28 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int side, float hitX, float hitY, float hitZ) {
/* 34 */     if (!world.field_72995_K) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 39 */       int r = MathHelper.func_76128_c((entityplayer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 40 */       byte byte0 = 0;
/* 41 */       byte byte1 = 0;
/* 42 */       if (r == 0) {
/*    */         
/* 44 */         byte1 = 1;
/*    */       }
/* 46 */       else if (r == 1) {
/*    */         
/* 48 */         byte0 = -1;
/*    */       }
/* 50 */       else if (r == 2) {
/*    */         
/* 52 */         byte1 = -1;
/*    */       }
/* 54 */       else if (r == 3) {
/*    */         
/* 56 */         byte0 = 1;
/*    */       } 
/* 58 */       if (((BlockSluice)TFCBlocks.sluice).canPlace(world, i, j + 1, k, r)) {
/*    */         
/* 60 */         world.func_147465_d(i, j + 1, k, TFCBlocks.sluice, r, 2);
/* 61 */         if (world.func_147439_a(i, j + 1, k) == TFCBlocks.sluice) {
/*    */           
/* 63 */           world.func_147465_d(i + byte0, j + 1, k + byte1, TFCBlocks.sluice, r + 8, 2);
/* 64 */           if (!entityplayer.field_71075_bZ.field_75098_d)
/* 65 */             entityplayer.field_71071_by.func_70298_a(entityplayer.field_71071_by.field_70461_c, 1); 
/*    */         } 
/* 67 */         return true;
/*    */       } 
/*    */     } 
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemSluice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */