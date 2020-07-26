/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemTerraBlock
/*     */   extends ItemBlock
/*     */   implements ISize
/*     */ {
/*     */   public String[] metaNames;
/*     */   public IIcon[] icons;
/*     */   public String folder;
/*     */   
/*     */   public ItemTerraBlock(Block b) {
/*  30 */     super(b);
/*  31 */     func_77627_a(true);
/*  32 */     this.folder = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTerraBlock setFolder(String f) {
/*  37 */     this.folder = f;
/*  38 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack is) {
/*     */     try {
/*  46 */       if (this.metaNames != null && is.func_77960_j() < this.metaNames.length) {
/*  47 */         return func_77658_a().concat("." + this.metaNames[is.func_77960_j()]);
/*     */       }
/*  49 */     } catch (Exception ex) {
/*     */       
/*  51 */       TerraFirmaCraft.LOG.error(ex.getLocalizedMessage());
/*     */     } 
/*     */     
/*  54 */     return super.func_77667_c(is);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUpdate(ItemStack is, World world, int x, int y, int z) {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77647_b(int i) {
/*  69 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  76 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */     
/*  78 */     if (is.func_77942_o())
/*     */     {
/*  80 */       if (TFC_ItemHeat.hasTemp(is)) {
/*     */         
/*  82 */         float temp = TFC_ItemHeat.getTemp(is);
/*  83 */         float meltTemp = TFC_ItemHeat.isCookable(is);
/*     */         
/*  85 */         if (meltTemp != -1.0F)
/*     */         {
/*  87 */           if (is.func_77973_b() == TFCItems.stick) {
/*  88 */             arraylist.add(TFC_ItemHeat.getHeatColorTorch(temp, meltTemp));
/*     */           } else {
/*  90 */             arraylist.add(TFC_ItemHeat.getHeatColor(temp, meltTemp));
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getItemStackLimit(ItemStack is) {
/* 105 */     if (canStack()) {
/* 106 */       return (getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier;
/*     */     }
/* 108 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 114 */     return EnumSize.VERYSMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 126 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 137 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemTerraBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */