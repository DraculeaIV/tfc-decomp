/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotLiquidVessel;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TECrucible;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ContainerCrucible
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TECrucible te;
/*     */   private float firetemp;
/*     */   
/*     */   public ContainerCrucible(InventoryPlayer inventoryplayer, TECrucible tileentityforge, World world, int x, int y, int z) {
/*  23 */     this.te = tileentityforge;
/*  24 */     this.firetemp = 0.0F;
/*     */     
/*  26 */     func_75146_a(new Slot((IInventory)tileentityforge, 0, 152, 7)
/*     */         {
/*     */           
/*     */           public boolean func_75214_a(ItemStack itemstack)
/*     */           {
/*  31 */             return (itemstack.func_77973_b() != TFCItems.rawBloom && (itemstack.func_77973_b() != TFCItems.bloom || itemstack.func_77960_j() <= 100));
/*     */           }
/*     */         });
/*     */     
/*  35 */     func_75146_a((Slot)new SlotLiquidVessel((IInventory)tileentityforge, 1, 152, 90));
/*     */     
/*  37 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 118, false, true);
/*     */     
/*  39 */     this.te.updateGui((byte)0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  51 */     ItemStack origStack = null;
/*  52 */     Slot slot = this.field_75151_b.get(slotNum);
/*     */     
/*  54 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  56 */       ItemStack slotStack = slot.func_75211_c();
/*  57 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  60 */       if (slotNum < 2) {
/*     */         
/*  62 */         if (!func_75135_a(slotStack, 2, this.field_75151_b.size(), true)) {
/*  63 */           return null;
/*     */         }
/*     */       }
/*  66 */       else if ((slotStack.func_77973_b() == TFCItems.ceramicMold && slotStack.func_77960_j() == 1) || slotStack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal) {
/*     */         
/*  68 */         if (!func_75135_a(slotStack, 1, 2, true)) {
/*  69 */           return null;
/*     */         
/*     */         }
/*     */       
/*     */       }
/*  74 */       else if (!func_75135_a(slotStack, 0, 1, true)) {
/*  75 */         return null;
/*     */       } 
/*     */       
/*  78 */       if (slotStack.field_77994_a <= 0) {
/*  79 */         slot.func_75215_d(null);
/*     */       } else {
/*  81 */         slot.func_75218_e();
/*     */       } 
/*  83 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/*  84 */         return null;
/*     */       }
/*  86 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/*  89 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  95 */     super.func_75142_b();
/*     */     
/*  97 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/*  99 */       ICrafting var2 = this.field_75149_d.get(var1);
/* 100 */       if (this.firetemp != this.te.temperature) {
/* 101 */         var2.func_71112_a(this, 0, this.te.temperature);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75137_b(int id, int value) {
/* 108 */     if (id == 0)
/* 109 */       this.te.temperature = value; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */