/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemGem
/*    */   extends ItemTerra
/*    */ {
/* 15 */   private IIcon[] icons = new IIcon[5];
/*    */ 
/*    */   
/*    */   public ItemGem() {
/* 19 */     func_77656_e(0);
/* 20 */     func_77627_a(true);
/* 21 */     this.metaNames = new String[] { "Chipped", "Flawed", "Normal", "Flawless", "Exquisite" };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 27 */     list.add(new ItemStack(this, 1, 0));
/* 28 */     list.add(new ItemStack(this, 1, 1));
/* 29 */     list.add(new ItemStack(this, 1, 2));
/* 30 */     list.add(new ItemStack(this, 1, 3));
/* 31 */     list.add(new ItemStack(this, 1, 4));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int i) {
/* 37 */     return this.icons[i];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 43 */     this.icons[0] = registerer.func_94245_a("terrafirmacraft:gems/" + this.metaNames[0] + " " + func_77658_a().replace("item.", ""));
/* 44 */     this.icons[1] = registerer.func_94245_a("terrafirmacraft:gems/" + this.metaNames[1] + " " + func_77658_a().replace("item.", ""));
/* 45 */     this.icons[2] = registerer.func_94245_a("terrafirmacraft:gems/" + this.metaNames[2] + " " + func_77658_a().replace("item.", ""));
/* 46 */     this.icons[3] = registerer.func_94245_a("terrafirmacraft:gems/" + this.metaNames[3] + " " + func_77658_a().replace("item.", ""));
/* 47 */     this.icons[4] = registerer.func_94245_a("terrafirmacraft:gems/" + this.metaNames[4] + " " + func_77658_a().replace("item.", ""));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemGem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */