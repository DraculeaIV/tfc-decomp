/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*    */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemClay
/*    */   extends ItemLooseRock
/*    */ {
/*    */   public ItemClay() {
/* 23 */     func_77637_a(TFCTabs.TFC_POTTERY);
/* 24 */     this.icons = new IIcon[2];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
/* 31 */     if (itemstack.field_77994_a >= 5) {
/*    */       
/* 33 */       PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(entityplayer);
/* 34 */       pi.specialCraftingType = new ItemStack(this.specialCraftingType, 1, 0);
/*    */       
/* 36 */       if (this.specialCraftingTypeAlternate != null) {
/* 37 */         pi.specialCraftingTypeAlternate = this.specialCraftingTypeAlternate;
/*    */       }
/* 39 */       if (itemstack.func_77960_j() == 1) {
/*    */         
/* 41 */         pi.specialCraftingType = new ItemStack(this.specialCraftingType, 1, 2);
/* 42 */         pi.specialCraftingTypeAlternate = new ItemStack(this.specialCraftingType, 1, 3);
/*    */       } 
/*    */       
/* 45 */       entityplayer.openGui(TerraFirmaCraft.instance, 28, entityplayer.field_70170_p, (int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v);
/*    */     } 
/* 47 */     return itemstack;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 54 */     if (TFC_Core.showShiftInformation()) {
/*    */       
/* 56 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 57 */       arraylist.add(TFC_Core.translate("gui.Clay.Inst0"));
/*    */     }
/*    */     else {
/*    */       
/* 61 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int meta) {
/* 68 */     return this.icons[meta];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 74 */     this.icons[0] = registerer.func_94245_a("terrafirmacraft:Clay");
/* 75 */     this.icons[1] = registerer.func_94245_a("terrafirmacraft:Fire Clay");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemClay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */