/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMeltedMetal
/*     */   extends ItemTerra
/*     */ {
/*     */   public ItemMeltedMetal() {
/*  26 */     func_77656_e(101);
/*  27 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*  28 */     setFolder("ingots/");
/*  29 */     setWeight(EnumWeight.MEDIUM);
/*  30 */     setSize(EnumSize.SMALL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  36 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", "").replace("Weak ", "").replace("HC ", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/*  43 */     if (isDamaged(is) || (is.func_77942_o() && TFC_ItemHeat.hasTemp(is)))
/*     */     {
/*  45 */       return 1;
/*     */     }
/*     */     
/*  48 */     return super.getItemStackLimit(is);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  54 */     if (is.func_77960_j() > 1)
/*     */     {
/*  56 */       arraylist.add(TFC_Core.translate("gui.units") + ": " + (100 - is.func_77960_j()) + " / 100");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77663_a(ItemStack is, World world, Entity entity, int i, boolean isSelected) {
/*  63 */     super.func_77663_a(is, world, entity, i, isSelected);
/*  64 */     if (is.func_77942_o()) {
/*     */ 
/*     */       
/*  67 */       if (TFC_ItemHeat.hasTemp(is) && TFC_ItemHeat.getTemp(is) >= TFC_ItemHeat.isCookable(is)) {
/*     */         
/*  69 */         if (is.func_77960_j() == 0) {
/*  70 */           is.func_77964_b(1);
/*     */         }
/*     */       }
/*  73 */       else if (is.func_77960_j() == 1) {
/*  74 */         is.func_77964_b(0);
/*     */       }
/*     */     
/*     */     }
/*  78 */     else if (is.func_77960_j() == 1) {
/*  79 */       is.func_77964_b(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDamaged(ItemStack stack) {
/*  86 */     return (stack.func_77960_j() > 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  91 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/*  93 */       arraylist.add(TFC_Core.translate("gui.Help"));
/*  94 */       arraylist.add(TFC_Core.translate("gui.MeltedMetal.Inst0"));
/*     */     }
/*     */     else {
/*     */       
/*  98 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
/* 105 */     if (itemstack.field_77994_a <= 0) {
/* 106 */       itemstack.field_77994_a = 1;
/*     */     }
/*     */     
/* 109 */     PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(entityplayer);
/* 110 */     pi.specialCraftingType = itemstack.func_77946_l();
/*     */     
/* 112 */     entityplayer.field_71071_by.func_70299_a(entityplayer.field_71071_by.field_70461_c, null);
/* 113 */     entityplayer.openGui(TerraFirmaCraft.instance, 38, world, (int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v);
/*     */     
/* 115 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemMeltedMetal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */