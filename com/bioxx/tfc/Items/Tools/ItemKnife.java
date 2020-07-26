/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Tools.IKnife;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class ItemKnife
/*     */   extends ItemWeapon
/*     */   implements IKnife
/*     */ {
/*     */   public ItemKnife(Item.ToolMaterial e, float damage) {
/*  26 */     super(e, damage);
/*  27 */     func_77656_e(e.func_77997_a());
/*  28 */     this.damageType = EnumDamageType.PIERCING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77630_h(ItemStack itemStack) {
/*  34 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  40 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getContainerItem(ItemStack itemStack) {
/*  46 */     ItemStack container = itemStack.func_77946_l();
/*  47 */     container.func_77964_b(container.func_77960_j() + 1);
/*  48 */     container.field_77994_a = 1;
/*  49 */     return container;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasContainerItem(ItemStack stack) {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepairable() {
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  67 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  79 */     Block id = world.func_147439_a(x, y, z);
/*  80 */     if (!world.field_72995_K && id != TFCBlocks.toolRack) {
/*     */       
/*  82 */       int hasBowl = -1;
/*     */       
/*  84 */       for (int i = 0; i < 36 && hasBowl == -1; i++) {
/*     */         
/*  86 */         if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() == TFCItems.potteryBowl && entityplayer.field_71071_by.field_70462_a[i].func_77960_j() == 1) {
/*  87 */           hasBowl = i;
/*     */         }
/*     */       } 
/*  90 */       Material mat = world.func_147439_a(x, y, z).func_149688_o();
/*     */       
/*  92 */       if (side == 1 && id.isSideSolid((IBlockAccess)world, x, y, z, ForgeDirection.UP) && !TFC_Core.isSoil(id) && !TFC_Core.isWater(id) && world.func_147437_c(x, y + 1, z) && (mat == Material.field_151575_d || mat == Material.field_151576_e || mat == Material.field_151573_f)) {
/*     */ 
/*     */         
/*  95 */         world.func_147449_b(x, y + 1, z, TFCBlocks.foodPrep);
/*  96 */         TEFoodPrep te = (TEFoodPrep)world.func_147438_o(x, y + 1, z);
/*  97 */         if (hasBowl != -1 && te != null) {
/*     */           
/*  99 */           te.func_70299_a(7, entityplayer.field_71071_by.field_70462_a[hasBowl]);
/* 100 */           entityplayer.field_71071_by.field_70462_a[hasBowl] = null;
/*     */         } 
/* 102 */         return true;
/*     */       } 
/*     */     } 
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 111 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 113 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 114 */       arraylist.add(TFC_Core.translate("gui.Knife.Inst0"));
/* 115 */       arraylist.add(TFC_Core.translate("gui.Knife.Inst1"));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 120 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 126 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */