/*     */ package com.bioxx.tfc.Items.Pottery;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEPottery;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPotteryBase
/*     */   extends ItemTerra
/*     */   implements ISize
/*     */ {
/*     */   public IIcon clayIcon;
/*     */   public IIcon ceramicIcon;
/*     */   
/*     */   public ItemPotteryBase() {
/*  37 */     this.field_77787_bX = true;
/*  38 */     setFolder("pottery/");
/*  39 */     func_77637_a(TFCTabs.TFC_POTTERY);
/*  40 */     this.metaNames = new String[] { "", "" };
/*  41 */     setWeight(EnumWeight.MEDIUM);
/*  42 */     setSize(EnumSize.SMALL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  48 */     this.clayIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[0]);
/*  49 */     this.ceramicIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  55 */     for (int i = 0; i < this.metaNames.length; i++) {
/*  56 */       list.add(new ItemStack((Item)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int damage) {
/*  63 */     if (damage == 0) {
/*  64 */       return this.clayIcon;
/*     */     }
/*  66 */     return this.ceramicIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/*  72 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/*  74 */       arraylist.add(TFC_Core.translate("gui.Help"));
/*  75 */       arraylist.add(TFC_Core.translate("gui.PotteryBase.Inst0"));
/*     */     } else {
/*  77 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  83 */     if (!world.field_72995_K && entityplayer.func_70093_af()) {
/*     */ 
/*     */       
/*  86 */       if (side == 1) {
/*     */         
/*  88 */         int offset = 0;
/*  89 */         if (world.func_147439_a(x, y, z) != TFCBlocks.pottery && world.func_147437_c(x, y + 1, z)) {
/*     */ 
/*     */           
/*  92 */           if (!world.isSideSolid(x, y, z, ForgeDirection.UP))
/*  93 */             return false; 
/*  94 */           world.func_147449_b(x, y + 1, z, TFCBlocks.pottery);
/*  95 */           offset = 1;
/*     */         } 
/*     */ 
/*     */         
/*  99 */         if (world.func_147438_o(x, y + offset, z) != null && world.func_147438_o(x, y + offset, z) instanceof TEPottery) {
/*     */           
/* 101 */           TEPottery te = (TEPottery)world.func_147438_o(x, y + offset, z);
/* 102 */           if (hitX < 0.5D && hitZ < 0.5D) {
/*     */             
/* 104 */             if (te.canAddItem(0))
/*     */             {
/* 106 */               te.inventory[0] = new ItemStack((Item)this, 1, itemstack.func_77960_j());
/* 107 */               (te.inventory[0]).field_77990_d = itemstack.field_77990_d;
/* 108 */               itemstack.field_77994_a--;
/* 109 */               world.func_147471_g(x, y + offset, z);
/*     */             }
/*     */           
/* 112 */           } else if (hitX > 0.5D && hitZ < 0.5D) {
/*     */             
/* 114 */             if (te.canAddItem(1))
/*     */             {
/* 116 */               te.inventory[1] = new ItemStack((Item)this, 1, itemstack.func_77960_j());
/* 117 */               (te.inventory[1]).field_77990_d = itemstack.field_77990_d;
/* 118 */               itemstack.field_77994_a--;
/* 119 */               world.func_147471_g(x, y + offset, z);
/*     */             }
/*     */           
/* 122 */           } else if (hitX < 0.5D && hitZ > 0.5D) {
/*     */             
/* 124 */             if (te.canAddItem(2))
/*     */             {
/* 126 */               te.inventory[2] = new ItemStack((Item)this, 1, itemstack.func_77960_j());
/* 127 */               (te.inventory[2]).field_77990_d = itemstack.field_77990_d;
/* 128 */               itemstack.field_77994_a--;
/* 129 */               world.func_147471_g(x, y + offset, z);
/*     */             }
/*     */           
/* 132 */           } else if (hitX > 0.5D && hitZ > 0.5D && 
/* 133 */             te.canAddItem(3)) {
/*     */             
/* 135 */             te.inventory[3] = new ItemStack((Item)this, 1, itemstack.func_77960_j());
/* 136 */             (te.inventory[3]).field_77990_d = itemstack.field_77990_d;
/* 137 */             itemstack.field_77994_a--;
/* 138 */             world.func_147471_g(x, y + offset, z);
/*     */           } 
/*     */         } 
/* 141 */         return true;
/*     */       } 
/* 143 */       return false;
/*     */     } 
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public void onDoneCooking(World world, ItemStack is, Alloy.EnumTier furnaceTier) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Pottery\ItemPotteryBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */