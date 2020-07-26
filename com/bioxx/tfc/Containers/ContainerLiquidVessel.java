/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotForShowOnly;
/*     */ import com.bioxx.tfc.Containers.Slots.SlotLiquidVessel;
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerLiquidVessel
/*     */   extends ContainerTFC
/*     */ {
/*     */   private World world;
/*     */   private EntityPlayer player;
/*  30 */   public InventoryCrafting containerInv = new InventoryCrafting(this, 1, 1);
/*     */   
/*     */   public int bagsSlotNum;
/*     */   
/*     */   public int metalAmount;
/*     */   
/*     */   public ContainerLiquidVessel(InventoryPlayer playerinv, World world, int x, int y, int z) {
/*  37 */     this.player = playerinv.field_70458_d;
/*  38 */     this.world = world;
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.bagsSlotNum = this.player.field_71071_by.field_70461_c;
/*  43 */     layoutContainer((IInventory)playerinv);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/*  49 */     super.func_75134_a(player);
/*  50 */     if (!this.world.field_72995_K) {
/*     */       
/*  52 */       ItemStack itemstack2 = this.containerInv.func_70304_b(0);
/*     */       
/*  54 */       if (itemstack2 != null) {
/*  55 */         player.func_70099_a(itemstack2, 0.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer var1) {
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void layoutContainer(IInventory playerInventory) {
/*  67 */     func_75146_a((Slot)new SlotLiquidVessel((IInventory)this.containerInv, 0, 80, 34));
/*     */ 
/*     */     
/*     */     int row;
/*     */     
/*  72 */     for (row = 0; row < 9; row++) {
/*     */       
/*  74 */       if (row == this.bagsSlotNum) {
/*  75 */         func_75146_a((Slot)new SlotForShowOnly(playerInventory, row, 8 + row * 18, 148));
/*     */       } else {
/*  77 */         func_75146_a(new Slot(playerInventory, row, 8 + row * 18, 148));
/*     */       } 
/*     */     } 
/*  80 */     for (row = 0; row < 3; row++) {
/*     */       
/*  82 */       for (int col = 0; col < 9; col++) {
/*  83 */         func_75146_a(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 90 + row * 18));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  91 */     ItemStack stack = this.player.field_71071_by.func_70301_a(this.bagsSlotNum);
/*     */     
/*  93 */     NBTTagCompound nbt = (stack != null && stack.func_77942_o()) ? stack.func_77978_p() : null;
/*     */     
/*  95 */     if (nbt != null) {
/*     */       
/*  97 */       ItemStack input = this.containerInv.func_70301_a(0);
/*     */ 
/*     */       
/* 100 */       if (input != null && input.func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold && input.func_77960_j() > 1 && input.func_77960_j() <= 5) {
/* 101 */         this.player.func_71029_a((StatBase)TFC_Achievements.achCopperAge);
/*     */       }
/* 103 */       Metal m = MetalRegistry.instance.getMetalFromString(nbt.func_74779_i("MetalType"));
/* 104 */       this.metalAmount = nbt.func_74762_e("MetalAmount");
/*     */       
/* 106 */       if (!this.world.field_72995_K && m != null && stack != null)
/*     */       {
/* 108 */         if (input != null && input.func_77973_b() == TFCItems.ceramicMold && input.func_77960_j() == 1 && input.field_77994_a == 1 && this.metalAmount > 0) {
/*     */           
/* 110 */           int amt = 99;
/* 111 */           ItemStack is = new ItemStack(m.meltedItem, 1, amt);
/* 112 */           TFC_ItemHeat.setTemp(is, (short)(int)(HeatRegistry.getInstance().getMeltingPoint(is) * 1.5F));
/* 113 */           this.containerInv.func_70299_a(0, is);
/* 114 */           if (this.metalAmount - 1 <= 0) {
/*     */             
/* 116 */             nbt.func_82580_o("MetalType");
/* 117 */             nbt.func_82580_o("MetalAmount");
/* 118 */             nbt.func_82580_o("TempTimer");
/* 119 */             stack.func_77964_b(1);
/*     */           }
/*     */           else {
/*     */             
/* 123 */             nbt.func_74768_a("MetalAmount", this.metalAmount - 2);
/*     */           } 
/*     */           
/* 126 */           stack.func_77982_d(nbt);
/*     */         }
/* 128 */         else if (input != null && input.func_77973_b() == m.meltedItem && input.func_77960_j() > 0) {
/*     */           
/* 130 */           input.func_77964_b(input.func_77960_j() - 1);
/* 131 */           TFC_ItemHeat.setTemp(input, (short)(int)(HeatRegistry.getInstance().getMeltingPoint(input) * 1.5F));
/* 132 */           if (this.metalAmount - 1 <= 0)
/*     */           {
/* 134 */             nbt.func_82580_o("MetalType");
/* 135 */             nbt.func_82580_o("MetalAmount");
/* 136 */             nbt.func_82580_o("TempTimer");
/* 137 */             stack.func_77964_b(1);
/*     */           }
/*     */           else
/*     */           {
/* 141 */             nbt.func_74768_a("MetalAmount", this.metalAmount - 1);
/*     */           }
/*     */         
/* 144 */         } else if (input != null && input.func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold && input.func_77960_j() == 1 && input.field_77994_a == 1 && this.metalAmount > 0 && ("Copper"
/* 145 */           .equals(m.name) || "Bronze".equals(m.name) || "Bismuth Bronze".equals(m.name) || "Black Bronze".equals(m.name))) {
/*     */           
/* 147 */           int amt = -1;
/* 148 */           if ("Copper".equals(m.name)) {
/* 149 */             amt = 398;
/* 150 */           } else if ("Bronze".equals(m.name)) {
/* 151 */             amt = 399;
/* 152 */           } else if ("Bismuth Bronze".equals(m.name)) {
/* 153 */             amt = 400;
/* 154 */           } else if ("Black Bronze".equals(m.name)) {
/* 155 */             amt = 401;
/*     */           } 
/* 157 */           ItemStack is = new ItemStack(input.func_77973_b(), 1, amt);
/* 158 */           TFC_ItemHeat.setTemp(is, (short)(int)(HeatRegistry.getInstance().getMeltingPoint(is) * 1.5F));
/* 159 */           this.containerInv.func_70299_a(0, is);
/* 160 */           if (this.metalAmount - 1 <= 0) {
/*     */             
/* 162 */             nbt.func_82580_o("MetalType");
/* 163 */             nbt.func_82580_o("MetalAmount");
/* 164 */             nbt.func_82580_o("TempTimer");
/* 165 */             stack.func_77964_b(1);
/*     */           }
/*     */           else {
/*     */             
/* 169 */             nbt.func_74768_a("MetalAmount", this.metalAmount - 2);
/*     */           } 
/*     */           
/* 172 */           stack.func_77982_d(nbt);
/*     */         }
/* 174 */         else if (input != null && input.func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold && input.func_77960_j() > 1) {
/*     */           
/* 176 */           boolean correctMetalFlag = false;
/* 177 */           if ("Copper".equals(m.name) && (input.func_77960_j() - 2) % 4 == 0) {
/* 178 */             correctMetalFlag = true;
/* 179 */           } else if ("Bronze".equals(m.name) && (input.func_77960_j() - 2) % 4 == 1) {
/* 180 */             correctMetalFlag = true;
/* 181 */           } else if ("Bismuth Bronze".equals(m.name) && (input.func_77960_j() - 2) % 4 == 2) {
/* 182 */             correctMetalFlag = true;
/* 183 */           } else if ("Black Bronze".equals(m.name) && (input.func_77960_j() - 2) % 4 == 3) {
/* 184 */             correctMetalFlag = true;
/*     */           } 
/* 186 */           if (correctMetalFlag)
/*     */           {
/* 188 */             if (input.func_77960_j() > 5) {
/*     */               
/* 190 */               input.func_77964_b(input.func_77960_j() - 4);
/* 191 */               TFC_ItemHeat.setTemp(input, (short)(int)(HeatRegistry.getInstance().getMeltingPoint(input) * 1.5F));
/* 192 */               if (this.metalAmount - 1 <= 0) {
/*     */                 
/* 194 */                 nbt.func_82580_o("MetalType");
/* 195 */                 nbt.func_82580_o("MetalAmount");
/* 196 */                 nbt.func_82580_o("TempTimer");
/* 197 */                 stack.func_77964_b(1);
/*     */               }
/*     */               else {
/*     */                 
/* 201 */                 nbt.func_74768_a("MetalAmount", this.metalAmount - 1);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 208 */     super.func_75142_b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
/* 214 */     ItemStack origStack = null;
/* 215 */     Slot slot = this.field_75151_b.get(slotNum);
/* 216 */     Slot outputSlot = this.field_75151_b.get(0);
/*     */     
/* 218 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 220 */       ItemStack slotStack = slot.func_75211_c();
/* 221 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/* 224 */       if (slotNum < 1) {
/*     */         
/* 226 */         if (!func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
/* 227 */           return null;
/*     */         }
/* 229 */       } else if (!outputSlot.func_75216_d() && ((slotStack
/* 230 */         .func_77973_b() == TFCItems.ceramicMold && slotStack.func_77960_j() == 1) || (slotStack
/* 231 */         .func_77973_b() instanceof com.bioxx.tfc.Items.ItemMeltedMetal && slotStack.func_77960_j() > 1) || (slotStack
/* 232 */         .func_77973_b() instanceof com.bioxx.tfc.Items.Pottery.ItemPotteryMold && slotStack.func_77960_j() > 0))) {
/*     */         
/* 234 */         ItemStack stack = slotStack.func_77946_l();
/* 235 */         stack.field_77994_a = 1;
/* 236 */         outputSlot.func_75215_d(stack);
/* 237 */         slotStack.field_77994_a--;
/*     */       } 
/*     */       
/* 240 */       if (slotStack.field_77994_a <= 0) {
/* 241 */         slot.func_75215_d(null);
/*     */       } else {
/* 243 */         slot.func_75218_e();
/*     */       } 
/* 245 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 246 */         return null;
/*     */       }
/* 248 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 251 */     return origStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerLiquidVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */