/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemMetalBlock2
/*    */   extends ItemMetalBlock {
/*    */   public ItemMetalBlock2(Block b) {
/* 11 */     super(b);
/* 12 */     this.metaNames = new String[Global.METAL_ALL.length - 16];
/* 13 */     System.arraycopy(Global.METAL_ALL, 16, this.metaNames, 0, Global.METAL_ALL.length - 16);
/* 14 */     setFolder("metal/");
/*    */   }
/*    */ 
/*    */   
/*    */   public Metal getMetalType(ItemStack is) {
/* 19 */     int dam = is.func_77960_j();
/* 20 */     switch (dam) {
/*    */       case 0:
/* 22 */         return Global.SILVER;
/* 23 */       case 1: return Global.STEEL;
/* 24 */       case 2: return Global.STERLINGSILVER;
/* 25 */       case 3: return Global.TIN;
/* 26 */       case 4: return Global.ZINC;
/* 27 */       case 5: return Global.ELECTRUM;
/* 28 */       case 6: return Global.CUPRONICKEL;
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemMetalBlock2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */