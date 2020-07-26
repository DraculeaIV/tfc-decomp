/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.GUI.GuiContainerCreativeTFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ContainerCreativeTFC
/*     */   extends Container
/*     */ {
/*  21 */   public List itemList = new ArrayList();
/*     */ 
/*     */   
/*     */   public ContainerCreativeTFC(EntityPlayer par1EntityPlayer) {
/*  25 */     InventoryPlayer inventoryplayer = par1EntityPlayer.field_71071_by;
/*     */     
/*     */     int i;
/*  28 */     for (i = 0; i < 5; i++) {
/*     */       
/*  30 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  32 */         func_75146_a(new Slot((IInventory)GuiContainerCreativeTFC.getInventory(), i * 9 + j, 9 + j * 18, 18 + i * 18));
/*     */       }
/*     */     } 
/*     */     
/*  36 */     for (i = 0; i < 9; i++)
/*     */     {
/*  38 */       func_75146_a(new Slot((IInventory)inventoryplayer, i, 9 + i * 18, 112));
/*     */     }
/*     */     
/*  41 */     scrollTo(0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
/*  47 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scrollTo(float par1) {
/*  55 */     int i = this.itemList.size() / 9 - 5 + 1;
/*  56 */     int j = (int)((par1 * i) + 0.5D);
/*     */     
/*  58 */     if (j < 0)
/*     */     {
/*  60 */       j = 0;
/*     */     }
/*     */     
/*  63 */     for (int k = 0; k < 5; k++) {
/*     */       
/*  65 */       for (int l = 0; l < 9; l++) {
/*     */         
/*  67 */         int i1 = l + (k + j) * 9;
/*     */         
/*  69 */         if (i1 >= 0 && i1 < this.itemList.size()) {
/*     */           
/*  71 */           GuiContainerCreativeTFC.getInventory().func_70299_a(l + k * 9, this.itemList.get(i1));
/*     */         }
/*     */         else {
/*     */           
/*  75 */           GuiContainerCreativeTFC.getInventory().func_70299_a(l + k * 9, (ItemStack)null);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMoreThan1PageOfItemsInList() {
/*  86 */     return (this.itemList.size() > 45);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_75133_b(int par1, int par2, boolean par3, EntityPlayer par4EntityPlayer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
/*  98 */     if (par2 >= this.field_75151_b.size() - 9 && par2 < this.field_75151_b.size()) {
/*     */       
/* 100 */       Slot slot = this.field_75151_b.get(par2);
/*     */       
/* 102 */       if (slot != null && slot.func_75216_d())
/*     */       {
/* 104 */         slot.func_75215_d((ItemStack)null);
/*     */       }
/*     */     } 
/*     */     
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot) {
/* 114 */     return (par2Slot.field_75221_f > 90);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94531_b(Slot par1Slot) {
/* 124 */     return (par1Slot.field_75224_c instanceof InventoryPlayer || (par1Slot.field_75221_f > 90 && par1Slot.field_75223_e <= 162));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerCreativeTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */