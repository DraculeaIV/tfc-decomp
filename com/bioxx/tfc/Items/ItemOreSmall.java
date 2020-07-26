/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import com.bioxx.tfc.api.TFCOptions;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemOreSmall
/*    */   extends ItemOre
/*    */ {
/*    */   public ItemOreSmall() {
/* 21 */     setWeight(EnumWeight.HEAVY);
/* 22 */     setSize(EnumSize.TINY);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 28 */     for (int i = 0; i < 14; i++) {
/* 29 */       list.add(new ItemStack(this, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 35 */     this.metaIcons = new net.minecraft.util.IIcon[14];
/* 36 */     for (int i = 0; i < 14; i++)
/*    */     {
/* 38 */       this.metaIcons[i] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[i] + " Small Ore");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getMetalReturnAmount(ItemStack is) {
/* 45 */     int dam = is.func_77960_j();
/* 46 */     switch (dam) {
/*    */       case 0:
/*    */       case 1:
/*    */       case 2:
/*    */       case 3:
/*    */       case 4:
/*    */       case 5:
/*    */       case 6:
/*    */       case 7:
/*    */       case 8:
/*    */       case 9:
/*    */       case 10:
/*    */       case 11:
/*    */       case 12:
/*    */       case 13:
/* 61 */         return (short)TFCOptions.smallOreUnits;
/*    */       case 35: case 36:
/*    */       case 37:
/*    */       case 38:
/*    */       case 39:
/*    */       case 40:
/*    */       case 41:
/*    */       case 42:
/*    */       case 43:
/*    */       case 44:
/*    */       case 45:
/*    */       case 46:
/*    */       case 47:
/*    */       case 48:
/* 75 */         return 15;
/*    */       case 49: case 50:
/*    */       case 51:
/*    */       case 52:
/*    */       case 53:
/*    */       case 54:
/*    */       case 55:
/*    */       case 56:
/*    */       case 57:
/*    */       case 58:
/*    */       case 59:
/*    */       case 60:
/*    */       case 61:
/*    */       case 62:
/* 89 */         return 5;
/*    */     } 
/* 91 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemOreSmall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */