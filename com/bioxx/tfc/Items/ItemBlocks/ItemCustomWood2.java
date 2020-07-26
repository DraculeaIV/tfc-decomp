/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class ItemCustomWood2
/*    */   extends ItemCustomWood
/*    */ {
/*    */   public ItemCustomWood2(Block b) {
/* 13 */     super(b);
/* 14 */     this.metaNames = new String[Global.WOOD_ALL.length - 16];
/* 15 */     System.arraycopy(Global.WOOD_ALL, 16, this.metaNames, 0, Global.WOOD_ALL.length - 16);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack is) {
/*    */     try {
/* 23 */       int meta = is.func_77960_j();
/* 24 */       if (meta > 15) meta -= 16; 
/* 25 */       if (this.metaNames != null && meta < this.metaNames.length) {
/* 26 */         return func_77658_a().concat("." + this.metaNames[meta]);
/*    */       }
/* 28 */     } catch (Exception ex) {
/*    */       
/* 30 */       TerraFirmaCraft.LOG.error(ex.getLocalizedMessage());
/*    */     } 
/* 32 */     return "Unknown";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemCustomWood2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */