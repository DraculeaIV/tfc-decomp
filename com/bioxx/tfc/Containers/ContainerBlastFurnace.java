/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotTuyere;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.TileEntities.TEBlastFurnace;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerBlastFurnace
/*     */   extends ContainerTFC
/*     */ {
/*     */   private TEBlastFurnace tileentity;
/*     */   private float firetemp;
/*     */   private int orecount;
/*     */   private int coalcount;
/*     */   private int updatecounter;
/*     */   
/*     */   public ContainerBlastFurnace(InventoryPlayer inventoryplayer, TEBlastFurnace te, World world, int x, int y, int z) {
/*  24 */     this.tileentity = te;
/*  25 */     this.firetemp = 0.0F;
/*     */ 
/*     */ 
/*     */     
/*  29 */     func_75146_a((Slot)new SlotTuyere((IInventory)te, 1, 153, 7));
/*     */     
/*  31 */     PlayerInventory.buildInventoryLayout(this, inventoryplayer, 8, 90, false, true);
/*     */     
/*  33 */     this.tileentity.updateGui();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer entityplayer) {
/*  39 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/*  45 */     ItemStack origStack = null;
/*  46 */     Slot slot = this.field_75151_b.get(slotNum);
/*  47 */     Slot slotTuyere = this.field_75151_b.get(0);
/*     */     
/*  49 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/*  51 */       ItemStack slotStack = slot.func_75211_c();
/*  52 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/*  55 */       if (slotNum < 1) {
/*     */         
/*  57 */         if (!func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
/*  58 */           return null;
/*     */         
/*     */         }
/*     */       }
/*  62 */       else if (slotStack.func_77973_b() instanceof com.bioxx.tfc.Items.ItemTuyere) {
/*     */         
/*  64 */         if (slotTuyere.func_75216_d())
/*  65 */           return null; 
/*  66 */         ItemStack stack = slotStack.func_77946_l();
/*  67 */         stack.field_77994_a = 1;
/*  68 */         slotTuyere.func_75215_d(stack);
/*  69 */         slotStack.field_77994_a--;
/*     */       } 
/*     */ 
/*     */       
/*  73 */       if (slotStack.field_77994_a <= 0) {
/*  74 */         slot.func_75215_d(null);
/*     */       } else {
/*  76 */         slot.func_75218_e();
/*     */       } 
/*  78 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/*  79 */         return null;
/*     */       }
/*  81 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/*  84 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  91 */     super.func_75142_b();
/*     */     
/*  93 */     for (int var1 = 0; var1 < this.field_75149_d.size(); var1++) {
/*     */       
/*  95 */       ICrafting var2 = this.field_75149_d.get(var1);
/*  96 */       if (this.firetemp != this.tileentity.fireTemp)
/*     */       {
/*  98 */         var2.func_71112_a(this, 0, (int)this.tileentity.fireTemp);
/*     */       }
/*     */     } 
/*     */     
/* 102 */     if (this.orecount != this.tileentity.oreCount || this.coalcount != this.tileentity.charcoalCount || this.updatecounter == 1000) {
/*     */ 
/*     */       
/* 105 */       this.tileentity.func_145831_w().func_147471_g(this.tileentity.field_145851_c, this.tileentity.field_145848_d, this.tileentity.field_145849_e);
/* 106 */       this.updatecounter = 0;
/*     */     } 
/* 108 */     this.orecount = this.tileentity.oreCount;
/* 109 */     this.coalcount = this.tileentity.charcoalCount;
/* 110 */     this.firetemp = this.tileentity.fireTemp;
/* 111 */     this.updatecounter++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75137_b(int par1, int par2) {
/* 117 */     if (par1 == 0)
/*     */     {
/* 119 */       this.tileentity.fireTemp = par2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */