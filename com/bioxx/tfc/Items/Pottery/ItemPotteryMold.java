/*    */ package com.bioxx.tfc.Items.Pottery;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPotteryMold
/*    */   extends ItemPotteryBase
/*    */ {
/*    */   private IIcon copperIcon;
/*    */   private IIcon bronzeIcon;
/*    */   private IIcon bismuthBronzeIcon;
/*    */   private IIcon blackBronzeIcon;
/*    */   
/*    */   public ItemPotteryMold() {
/* 28 */     func_77656_e(401);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77645_m() {
/* 34 */     return (func_77612_l() > 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 40 */     if (is.func_77960_j() > 5) {
/*    */       
/* 42 */       int units = 100 - (is.func_77960_j() - 2) / 4;
/* 43 */       arraylist.add(TFC_Core.translate("gui.units") + ": " + units + " / 100");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDamaged(ItemStack stack) {
/* 50 */     return (stack.func_77960_j() > 5);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 56 */     this.clayIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[0]);
/* 57 */     this.ceramicIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[1]);
/* 58 */     if (this.metaNames.length > 2) {
/*    */       
/* 60 */       this.copperIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[2]);
/* 61 */       this.bronzeIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[3]);
/* 62 */       this.bismuthBronzeIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[4]);
/* 63 */       this.blackBronzeIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[5]);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_77667_c(ItemStack par1ItemStack) {
/* 69 */     if (par1ItemStack != null && par1ItemStack.func_77960_j() > 5) {
/*    */       
/* 71 */       int damage = (par1ItemStack.func_77960_j() - 2) % 4 + 2;
/* 72 */       return super.func_77667_c(par1ItemStack) + "." + this.metaNames[damage];
/*    */     } 
/* 74 */     return super.func_77667_c(par1ItemStack);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int damage) {
/* 80 */     if (damage > 5)
/*    */     {
/* 82 */       damage = (damage - 2) % 4 + 2;
/*    */     }
/* 84 */     if (damage == 0) return this.clayIcon; 
/* 85 */     if (damage == 1) return this.ceramicIcon; 
/* 86 */     if (damage == 2) return this.copperIcon; 
/* 87 */     if (damage == 3) return this.bronzeIcon; 
/* 88 */     if (damage == 4) return this.bismuthBronzeIcon; 
/* 89 */     if (damage == 5) return this.blackBronzeIcon;
/*    */     
/* 91 */     return this.clayIcon;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 98 */     list.add(new ItemStack(item, 1, 0));
/* 99 */     list.add(new ItemStack(item, 1, 1));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Pottery\ItemPotteryMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */