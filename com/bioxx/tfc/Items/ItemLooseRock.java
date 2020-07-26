/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemLooseRock
/*     */   extends ItemTerra
/*     */ {
/*     */   protected IIcon[] icons;
/*     */   protected Item specialCraftingType;
/*     */   protected ItemStack specialCraftingTypeAlternate;
/*     */   
/*     */   public ItemLooseRock() {
/*  31 */     this.field_77787_bX = true;
/*  32 */     func_77656_e(0);
/*  33 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*  34 */     this.metaNames = Global.STONE_ALL;
/*  35 */     this.icons = new IIcon[this.metaNames.length];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemTerra setMetaNames(String[] metanames) {
/*  41 */     this.metaNames = (String[])metanames.clone();
/*  42 */     if (this.metaNames != null)
/*  43 */       this.icons = new IIcon[this.metaNames.length]; 
/*  44 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setSpecialCraftingType(Item i) {
/*  49 */     this.specialCraftingType = i;
/*  50 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setSpecialCraftingType(Item i, Item j) {
/*  55 */     this.specialCraftingType = i;
/*  56 */     this.specialCraftingTypeAlternate = new ItemStack(j);
/*  57 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerra setSpecialCraftingType(Item i, ItemStack is) {
/*  62 */     this.specialCraftingType = i;
/*  63 */     this.specialCraftingTypeAlternate = is;
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getSpecialCraftingType() {
/*  69 */     return this.specialCraftingType;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getSpecialCraftingTypeAlternate() {
/*  74 */     return this.specialCraftingTypeAlternate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  80 */     PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/*  81 */     pi.specialCraftingType = new ItemStack(this.specialCraftingType, 1, is.func_77960_j());
/*  82 */     if (this.specialCraftingTypeAlternate != null) {
/*  83 */       pi.specialCraftingTypeAlternate = this.specialCraftingTypeAlternate;
/*     */     } else {
/*  85 */       pi.specialCraftingTypeAlternate = null;
/*     */     } 
/*  87 */     if (is.field_77994_a > 1)
/*     */     {
/*  89 */       player.openGui(TerraFirmaCraft.instance, 28, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */     }
/*  91 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  98 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 100 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 101 */       arraylist.add(TFC_Core.translate("gui.LooseRock.Inst0"));
/*     */     }
/*     */     else {
/*     */       
/* 105 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77663_a(ItemStack is, World world, Entity entity, int par4, boolean par5) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int meta) {
/* 119 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/* 126 */     for (int i = 0; i < this.metaNames.length; i++) {
/* 127 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:rocks/" + this.metaNames[i] + " Rock");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 133 */     for (int i = 0; i < this.metaNames.length; i++)
/*     */     {
/* 135 */       list.add(new ItemStack(this, 1, i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemLooseRock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */