/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TELogPile;
/*    */ import com.bioxx.tfc.TileEntities.TEPottery;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemTorch
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemTorch(Block b) {
/* 17 */     super(b);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onEntityItemUpdate(EntityItem entityItem) {
/* 23 */     if (entityItem.field_70170_p.func_147439_a((int)Math.floor(entityItem.field_70165_t), (int)Math.floor(entityItem.field_70163_u) - 1, (int)Math.floor(entityItem.field_70161_v)) == TFCBlocks.logPile) {
/*    */       
/* 25 */       int count = entityItem.getEntityData().func_74762_e("torchCount");
/* 26 */       if (count > 160) {
/*    */         
/* 28 */         TELogPile te = (TELogPile)entityItem.field_70170_p.func_147438_o((int)Math.floor(entityItem.field_70165_t), (int)Math.floor(entityItem.field_70163_u) - 1, (int)Math.floor(entityItem.field_70161_v));
/* 29 */         te.activateCharcoal();
/* 30 */         te.lightNeighbors();
/* 31 */         entityItem.func_70106_y();
/*    */       }
/*    */       else {
/*    */         
/* 35 */         if (entityItem.field_70170_p.field_73012_v.nextInt(10) < 2)
/* 36 */           entityItem.field_70170_p.func_72869_a("lava", entityItem.field_70165_t, entityItem.field_70163_u, entityItem.field_70161_v, (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat()), (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat()), (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat())); 
/* 37 */         entityItem.getEntityData().func_74768_a("torchCount", count + 1);
/*    */       } 
/*    */     } 
/* 40 */     if (entityItem.field_70170_p.func_147439_a((int)Math.floor(entityItem.field_70165_t), (int)Math.floor(entityItem.field_70163_u) - 1, (int)Math.floor(entityItem.field_70161_v)) == TFCBlocks.pottery) {
/*    */       
/* 42 */       int count = entityItem.getEntityData().func_74762_e("torchCount");
/* 43 */       if (count > 80) {
/*    */         
/* 45 */         TEPottery tepot = (TEPottery)entityItem.field_70170_p.func_147438_o((int)Math.floor(entityItem.field_70165_t), (int)Math.floor(entityItem.field_70163_u) - 1, (int)Math.floor(entityItem.field_70161_v));
/* 46 */         if (!entityItem.field_70170_p.field_72995_K && tepot.wood == 8 && tepot.burnStart == 0L) {
/* 47 */           tepot.startPitFire();
/*    */         }
/*    */       } else {
/*    */         
/* 51 */         if (entityItem.field_70170_p.field_73012_v.nextInt(10) < 2)
/* 52 */           entityItem.field_70170_p.func_72869_a("lava", entityItem.field_70165_t, entityItem.field_70163_u, entityItem.field_70161_v, (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat()), (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat()), (-0.5F + entityItem.field_70170_p.field_73012_v.nextFloat())); 
/* 53 */         entityItem.getEntityData().func_74768_a("torchCount", count + 1);
/*    */       } 
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 62 */     int xCoord = x, yCoord = y, zCoord = z;
/* 63 */     if (side == 0) yCoord--; 
/* 64 */     if (side == 1) yCoord++; 
/* 65 */     if (side == 2) zCoord--; 
/* 66 */     if (side == 3) zCoord++; 
/* 67 */     if (side == 4) xCoord--; 
/* 68 */     if (side == 5) xCoord++; 
/* 69 */     Block block = world.func_147439_a(xCoord, yCoord, zCoord);
/* 70 */     if (block != TFCBlocks.torch && block != TFCBlocks.torchOff) {
/* 71 */       return super.func_77648_a(is, player, world, x, y, z, side, hitX, hitY, hitZ);
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemTorch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */