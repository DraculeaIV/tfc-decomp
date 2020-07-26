/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSapling
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemSapling(Block b) {
/* 16 */     super(b);
/* 17 */     this.metaNames = new String[16];
/* 18 */     System.arraycopy(Global.WOOD_ALL, 0, this.metaNames, 0, 16);
/* 19 */     this.icons = new IIcon[this.metaNames.length];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int index) {
/* 25 */     return this.icons[index];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 31 */     for (int i = 0; i < this.metaNames.length; i++) {
/* 32 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/trees/" + this.metaNames[i] + " Sapling");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumWeight getWeight(ItemStack is) {
/* 38 */     return EnumWeight.MEDIUM;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */