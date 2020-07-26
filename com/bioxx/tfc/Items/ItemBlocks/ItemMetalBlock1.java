/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemMetalBlock1
/*    */   extends ItemMetalBlock
/*    */ {
/*    */   public ItemMetalBlock1(Block b) {
/* 12 */     super(b);
/* 13 */     this.metaNames = new String[16];
/* 14 */     System.arraycopy(Global.METAL_ALL, 0, this.metaNames, 0, 16);
/* 15 */     setFolder("metal/");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Metal getMetalType(ItemStack is) {
/* 21 */     int dam = is.func_77960_j();
/* 22 */     switch (dam) {
/*    */       case 0:
/* 24 */         return Global.BISMUTH;
/* 25 */       case 1: return Global.BISMUTHBRONZE;
/* 26 */       case 2: return Global.BLACKBRONZE;
/* 27 */       case 3: return Global.BLACKSTEEL;
/* 28 */       case 4: return Global.BLUESTEEL;
/* 29 */       case 5: return Global.BRASS;
/* 30 */       case 6: return Global.BRONZE;
/* 31 */       case 7: return Global.COPPER;
/* 32 */       case 8: return Global.GOLD;
/* 33 */       case 9: return Global.WROUGHTIRON;
/* 34 */       case 10: return Global.LEAD;
/* 35 */       case 11: return Global.NICKEL;
/* 36 */       case 12: return Global.PIGIRON;
/* 37 */       case 13: return Global.PLATINUM;
/* 38 */       case 14: return Global.REDSTEEL;
/* 39 */       case 15: return Global.ROSEGOLD;
/*    */     } 
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemMetalBlock1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */