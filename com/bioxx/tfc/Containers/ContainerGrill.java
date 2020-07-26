/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotCookableFoodOnly;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEGrill;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerGrill
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TEFireEntity fire;
/*  25 */   private float firetemp = -1111.0F;
/*     */   public ContainerGrill(InventoryPlayer inventoryplayer, TEGrill grill, World world, int x, int y, int z) {
/*  27 */     if (world.func_147438_o(x, y - 1, z) instanceof TEFireEntity)
/*     */     {
/*  29 */       this.fire = (TEFireEntity)world.func_147438_o(x, y - 1, z);
/*     */     }
/*     */ 
/*     */     
/*  33 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 0, 71, 17));
/*  34 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 1, 89, 17));
/*  35 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 2, 71, 35));
/*  36 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 3, 89, 35));
/*  37 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 4, 71, 53));
/*  38 */     func_75146_a((Slot)new SlotCookableFoodOnly((IInventory)grill, 5, 89, 53));
/*     */     
/*  40 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 90, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  46 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  52 */     ItemStack origStack = null;
/*  53 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  55 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  57 */       ItemStack slotStack = slot.func_75211_c();
/*  58 */       origStack = slotStack.func_77946_l();
/*     */       
/*  60 */       if (slotNum < 6) {
/*     */         
/*  62 */         if (!func_75135_a(slotStack, 6, this.field_75151_b.size(), true)) {
/*  63 */           return null;
/*     */         
/*     */         }
/*     */       }
/*  67 */       else if (!func_75135_a(slotStack, 0, 6, false)) {
/*  68 */         return null;
/*     */       } 
/*     */       
/*  71 */       if (slotStack.field_77994_a <= 0) {
/*  72 */         slot.func_75215_d(null);
/*     */       } else {
/*  74 */         slot.func_75218_e();
/*     */       } 
/*  76 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/*  77 */         return null;
/*     */       }
/*  79 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/*  82 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  88 */     super.func_75142_b(); int var1;
/*  89 */     for (var1 = 0; var1 < this.field_75151_b.size(); var1++) {
/*     */       
/*  91 */       ItemStack var2 = ((Slot)this.field_75151_b.get(var1)).func_75211_c();
/*  92 */       ItemStack var3 = this.field_75153_a.get(var1);
/*     */       
/*  94 */       if (!ItemStack.func_77989_b(var3, var2)) {
/*     */         
/*  96 */         var3 = (var2 == null) ? null : var2.func_77946_l();
/*  97 */         this.field_75153_a.set(var1, var3);
/*     */         
/*  99 */         for (int var4 = 0; var4 < this.field_75149_d.size(); var4++) {
/* 100 */           ((ICrafting)this.field_75149_d.get(var4)).func_71111_a(this, var1, var3);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     for (var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/* 107 */       ICrafting var2 = this.field_75149_d.get(var1);
/* 108 */       if (this.fire != null && this.firetemp != this.fire.fireTemp) {
/* 109 */         var2.func_71112_a(this, 0, (int)this.fire.fireTemp);
/*     */       }
/*     */     } 
/* 112 */     if (this.fire != null)
/* 113 */     { this.firetemp = this.fire.fireTemp; }
/* 114 */     else { this.firetemp = 0.0F; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75137_b(int par1, int par2) {
/* 120 */     if (this.fire != null && par1 == 0)
/* 121 */       this.fire.fireTemp = par2; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */