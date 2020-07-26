/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ class SlotCreativeInventoryTFC
/*     */   extends Slot
/*     */ {
/*     */   private final Slot theSlot;
/*     */   
/*     */   public SlotCreativeInventoryTFC(GuiContainerCreativeTFC par1GuiContainerCreative, Slot par2Slot, int par3) {
/*  21 */     super(par2Slot.field_75224_c, par3, 0, 0);
/*     */     
/*  23 */     this.theSlot = par2Slot;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_82870_a(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
/*  29 */     this.theSlot.func_82870_a(par1EntityPlayer, par2ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75214_a(ItemStack par1ItemStack) {
/*  38 */     return this.theSlot.func_75214_a(par1ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_75211_c() {
/*  47 */     return this.theSlot.func_75211_c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75216_d() {
/*  56 */     return this.theSlot.func_75216_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75215_d(ItemStack par1ItemStack) {
/*  65 */     this.theSlot.func_75215_d(par1ItemStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75218_e() {
/*  74 */     this.theSlot.func_75218_e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_75219_a() {
/*  84 */     return this.theSlot.func_75219_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_75212_b() {
/*  93 */     return this.theSlot.func_75212_b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_75209_a(int par1) {
/* 103 */     return this.theSlot.func_75209_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75217_a(IInventory par1IInventory, int par2) {
/* 112 */     return this.theSlot.func_75217_a(par1IInventory, par2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Slot getSlot(SlotCreativeInventoryTFC par0SlotCreativeInventory) {
/* 117 */     return par0SlotCreativeInventory.theSlot;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\SlotCreativeInventoryTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */