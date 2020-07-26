/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemCustomWoodH3
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemCustomWoodH3(Block b) {
/* 13 */     super(b);
/* 14 */     int size = Global.WOOD_ALL.length - 16;
/* 15 */     this.metaNames = new String[size * 2];
/* 16 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, 0, size);
/* 17 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, size, size);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack is) {
/*    */     try {
/* 25 */       int meta = is.func_77960_j();
/* 26 */       if (meta > 15) meta -= 16; 
/* 27 */       if (this.metaNames != null && meta < this.metaNames.length) {
/* 28 */         return func_77658_a().concat("." + this.metaNames[meta]);
/*    */       }
/* 30 */     } catch (Exception ex) {
/*    */       
/* 32 */       TerraFirmaCraft.LOG.error(ex.getLocalizedMessage());
/*    */     } 
/* 34 */     return "Unknown";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemCustomWoodH3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */