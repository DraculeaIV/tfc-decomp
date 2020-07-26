/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemReeds
/*    */   extends Item {
/* 15 */   private Block reeds = TFCBlocks.reeds;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
/* 28 */     Block block = world.func_147439_a(x, y, z);
/*    */     
/* 30 */     if (block == Blocks.field_150431_aC && (world.func_72805_g(x, y, z) & 0x7) < 1) {
/*    */       
/* 32 */       side = 1;
/*    */     }
/* 34 */     else if (block != TFCBlocks.vine && block != TFCBlocks.tallGrass && block != Blocks.field_150330_I) {
/*    */       
/* 36 */       if (side == 0) y--; 
/* 37 */       if (side == 1) y++; 
/* 38 */       if (side == 2) z--; 
/* 39 */       if (side == 3) z++; 
/* 40 */       if (side == 4) x--; 
/* 41 */       if (side == 5) x++;
/*    */     
/*    */     } 
/* 44 */     if (!player.func_82247_a(x, y, z, side, is))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (is.field_77994_a == 0)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 54 */     if (world.func_147472_a(this.reeds, x, y, z, false, side, (Entity)null, is)) {
/*    */       
/* 56 */       int i1 = this.reeds.func_149660_a(world, x, y, z, side, par8, par9, par10, 0);
/* 57 */       if (world.func_147465_d(x, y, z, this.reeds, i1, 3)) {
/*    */         
/* 59 */         if (world.func_147439_a(x, y, z) == this.reeds) {
/*    */           
/* 61 */           this.reeds.func_149689_a(world, x, y, z, (EntityLivingBase)player, is);
/* 62 */           this.reeds.func_149714_e(world, x, y, z, i1);
/*    */         } 
/* 64 */         world.func_72908_a((x + 0.5F), (y + 0.5F), (z + 0.5F), this.reeds.field_149762_H.func_150496_b(), (this.reeds.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.reeds.field_149762_H.func_150494_d() * 0.8F);
/* 65 */         is.field_77994_a--;
/*    */       } 
/*    */     } 
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemReeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */