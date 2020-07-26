/*     */ package com.bioxx.tfc.Containers;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.Slots.SlotArmorTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInventory;
/*     */ import com.bioxx.tfc.Handlers.CraftingHandler;
/*     */ import com.bioxx.tfc.Handlers.FoodCraftingHandler;
/*     */ import com.bioxx.tfc.Items.ItemTFCArmor;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.inventory.SlotCrafting;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerPlayerTFC
/*     */   extends ContainerPlayer
/*     */ {
/*     */   private final EntityPlayer thePlayer;
/*     */   
/*     */   public ContainerPlayerTFC(InventoryPlayer playerInv, boolean par2, EntityPlayer player) {
/*  27 */     super(playerInv, par2, player);
/*  28 */     this.field_75181_e = new InventoryCrafting((Container)this, 3, 3);
/*  29 */     this.field_75151_b.clear();
/*  30 */     this.field_75153_a.clear();
/*  31 */     this.thePlayer = player;
/*  32 */     func_75146_a((Slot)new SlotCrafting(player, (IInventory)this.field_75181_e, this.field_75179_f, 0, 152, 36));
/*     */     
/*     */     int x;
/*     */     
/*  36 */     for (x = 0; x < 2; x++) {
/*     */       
/*  38 */       for (int y = 0; y < 2; y++) {
/*  39 */         func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*     */       }
/*     */     } 
/*  42 */     for (x = 0; x < playerInv.field_70460_b.length; x++) {
/*     */       
/*  44 */       int index = playerInv.func_70302_i_() - 2 - x;
/*  45 */       func_75146_a((Slot)new SlotArmorTFC(this, (IInventory)playerInv, index, 8, 8 + x * 18, x));
/*     */     } 
/*  47 */     PlayerInventory.buildInventoryLayout((Container)this, playerInv, 8, 90, false, true);
/*     */ 
/*     */     
/*  50 */     if (player.getEntityData().func_74764_b("craftingTable") || !player.field_70170_p.field_72995_K) {
/*     */       
/*  52 */       x = 2; int y = 0; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*  53 */       x = 2; y = 1; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*  54 */       x = 0; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*  55 */       x = 1; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*  56 */       x = 2; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18, 18 + x * 18));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  61 */       x = 2; int y = 0; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18 - 50000, 18 + x * 18));
/*  62 */       x = 2; y = 1; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18 - 50000, 18 + x * 18));
/*  63 */       x = 0; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18 - 50000, 18 + x * 18));
/*  64 */       x = 1; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18 - 50000, 18 + x * 18));
/*  65 */       x = 2; y = 2; func_75146_a(new Slot((IInventory)this.field_75181_e, y + x * 3, 82 + y * 18 - 50000, 18 + x * 18));
/*     */     } 
/*  67 */     PlayerInventory.addExtraEquipables((Container)this, playerInv, 8, 90, false);
/*  68 */     func_75130_a((IInventory)this.field_75181_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75130_a(IInventory iinventory) {
/*  77 */     super.func_75130_a(iinventory);
/*     */     
/*  79 */     Slot craftOut = this.field_75151_b.get(0);
/*  80 */     if (craftOut != null && craftOut.func_75216_d()) {
/*     */       
/*  82 */       ItemStack craftResult = craftOut.func_75211_c();
/*  83 */       if (craftResult != null)
/*     */       {
/*  85 */         if (craftResult.func_77973_b() instanceof com.bioxx.tfc.Food.ItemFoodTFC) {
/*  86 */           FoodCraftingHandler.updateOutput(this.thePlayer, craftResult, (IInventory)this.field_75181_e);
/*     */         } else {
/*  88 */           CraftingHandler.transferNBT(false, this.thePlayer, craftResult, (IInventory)this.field_75181_e);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/*  96 */     if (!player.field_70170_p.field_72995_K) {
/*     */       
/*  98 */       super.func_75134_a(player);
/*     */       
/* 100 */       for (int i = 0; i < 9; i++) {
/*     */         
/* 102 */         ItemStack itemstack = this.field_75181_e.func_70304_b(i);
/* 103 */         if (itemstack != null) {
/* 104 */           player.func_71019_a(itemstack, false);
/*     */         }
/*     */       } 
/* 107 */       this.field_75179_f.func_70299_a(0, (ItemStack)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int slotNum) {
/* 114 */     ItemStack origStack = null;
/* 115 */     Slot slot = this.field_75151_b.get(slotNum);
/* 116 */     Slot equipmentSlot = this.field_75151_b.get(50);
/*     */     
/* 118 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 120 */       ItemStack slotStack = slot.func_75211_c();
/* 121 */       origStack = slotStack.func_77946_l();
/*     */ 
/*     */       
/* 124 */       if (slotNum == 0) {
/*     */         
/* 126 */         FoodCraftingHandler.preCraft(player, slotStack, (IInventory)this.field_75181_e);
/* 127 */         CraftingHandler.preCraft(player, slotStack, (IInventory)this.field_75181_e);
/*     */         
/* 129 */         if (!mergeItemStack(slotStack, 9, 45, true, true)) {
/* 130 */           return null;
/*     */         }
/* 132 */         slot.func_75220_a(slotStack, origStack);
/*     */       
/*     */       }
/* 135 */       else if ((slotNum >= 1 && slotNum < 5) || (player.getEntityData().func_74764_b("craftingTable") && slotNum >= 45 && slotNum < 50)) {
/*     */         
/* 137 */         if (!mergeItemStack(slotStack, 9, 45, true, false)) {
/* 138 */           return null;
/*     */         }
/*     */       }
/* 141 */       else if ((slotNum >= 5 && slotNum < 9) || slotNum == 50) {
/*     */         
/* 143 */         if (!mergeItemStack(slotStack, 9, 45, true, false)) {
/* 144 */           return null;
/*     */         }
/*     */       }
/* 147 */       else if (origStack.func_77973_b() instanceof ItemArmor) {
/*     */         
/* 149 */         int armorSlotNum = 5 + ((ItemArmor)origStack.func_77973_b()).field_77881_a;
/* 150 */         if (origStack.func_77973_b() instanceof ItemTFCArmor) {
/*     */           
/* 152 */           armorSlotNum = 5 + ((ItemTFCArmor)origStack.func_77973_b()).getUnadjustedArmorType();
/*     */           
/* 154 */           if (!((Slot)this.field_75151_b.get(armorSlotNum)).func_75216_d())
/*     */           {
/* 156 */             if (!mergeItemStack(slotStack, armorSlotNum, armorSlotNum + 1, false, false)) {
/* 157 */               return null;
/*     */             }
/*     */           }
/* 160 */         } else if (!((Slot)this.field_75151_b.get(armorSlotNum)).func_75216_d()) {
/*     */           
/* 162 */           if (!mergeItemStack(slotStack, armorSlotNum, armorSlotNum + 1, false, false)) {
/* 163 */             return null;
/*     */           }
/*     */         }
/*     */       
/* 167 */       } else if (!equipmentSlot.func_75216_d() && origStack.func_77973_b() instanceof IEquipable) {
/*     */         
/* 169 */         IEquipable equipment = (IEquipable)origStack.func_77973_b();
/* 170 */         if (equipment.getEquipType(origStack) == IEquipable.EquipType.BACK && (equipment == TFCItems.quiver || equipment.getTooHeavyToCarry(origStack)))
/*     */         {
/* 172 */           ItemStack backStack = slotStack.func_77946_l();
/* 173 */           backStack.field_77994_a = 1;
/* 174 */           equipmentSlot.func_75215_d(backStack);
/* 175 */           slotStack.field_77994_a--;
/*     */         }
/*     */       
/*     */       }
/* 179 */       else if (slotNum >= 9 && slotNum < 45 && origStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood && !(origStack.func_77973_b() instanceof com.bioxx.tfc.Food.ItemMeal) && !isCraftingGridFull()) {
/*     */         
/* 181 */         if (!mergeItemStack(slotStack, 1, 5, false, false) && slotStack.field_77994_a == 0)
/* 182 */           return null; 
/* 183 */         if (slotStack.field_77994_a > 0 && player.getEntityData().func_74764_b("craftingTable") && !func_75135_a(slotStack, 45, 50, false))
/* 184 */           return null; 
/* 185 */         if (slotStack.field_77994_a > 0 && slotNum >= 9 && slotNum < 36) {
/*     */           
/* 187 */           if (!mergeItemStack(slotStack, 36, 45, false, false)) {
/* 188 */             return null;
/*     */           }
/* 190 */         } else if (slotStack.field_77994_a > 0 && slotNum >= 36 && slotNum < 45) {
/*     */           
/* 192 */           if (!mergeItemStack(slotStack, 9, 36, false, false)) {
/* 193 */             return null;
/*     */           }
/*     */         }
/*     */       
/* 197 */       } else if (slotNum >= 9 && slotNum < 36) {
/*     */         
/* 199 */         if (!mergeItemStack(slotStack, 36, 45, false, false)) {
/* 200 */           return null;
/*     */         }
/*     */       }
/* 203 */       else if (slotNum >= 36 && slotNum < 45) {
/*     */         
/* 205 */         if (!mergeItemStack(slotStack, 9, 36, false, false)) {
/* 206 */           return null;
/*     */         }
/*     */       } 
/* 209 */       if (slotStack.field_77994_a <= 0) {
/* 210 */         slot.func_75215_d(null);
/*     */       } else {
/* 212 */         slot.func_75218_e();
/*     */       } 
/* 214 */       if (slotStack.field_77994_a == origStack.field_77994_a) {
/* 215 */         return null;
/*     */       }
/* 217 */       slot.func_82870_a(player, slotStack);
/*     */     } 
/*     */     
/* 220 */     return origStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_75144_a(int sourceSlotID, int destSlotID, int clickType, EntityPlayer p) {
/* 226 */     if (sourceSlotID >= 0 && sourceSlotID < this.field_75151_b.size()) {
/*     */       
/* 228 */       Slot sourceSlot = this.field_75151_b.get(sourceSlotID);
/* 229 */       ItemStack slotStack = sourceSlot.func_75211_c();
/*     */ 
/*     */       
/* 232 */       if (clickType == 2 && sourceSlotID == 0 && slotStack != null) {
/*     */         
/* 234 */         CraftingHandler.preCraft(p, slotStack, (IInventory)this.field_75181_e);
/*     */       
/*     */       }
/* 237 */       else if (clickType == 7 && sourceSlotID >= 9 && sourceSlotID < 45) {
/*     */         
/* 239 */         if (sourceSlot.func_82869_a(p))
/*     */         {
/* 241 */           Slot destSlot = this.field_75151_b.get(destSlotID);
/* 242 */           destSlot.func_75215_d(slotStack);
/* 243 */           sourceSlot.func_75215_d(null);
/* 244 */           return null;
/*     */         }
/*     */       
/*     */       }
/* 248 */       else if (clickType == 1 && sourceSlotID == 0 && isInventoryFull() && slotStack != null && slotStack.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/* 249 */         return null;
/*     */       } 
/* 251 */     }  return super.func_75144_a(sourceSlotID, destSlotID, clickType, p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isCraftingGridFull() {
/* 256 */     for (int i = 0; i < this.field_75181_e.func_70302_i_(); i++) {
/*     */       
/* 258 */       if (this.field_75181_e.func_70301_a(i) == null)
/* 259 */         return false; 
/*     */     } 
/* 261 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInventoryFull() {
/* 267 */     for (int i = 9; i < 45; i++) {
/*     */       
/* 269 */       if (((Slot)this.field_75151_b.get(i)).func_75211_c() == null)
/* 270 */         return false; 
/*     */     } 
/* 272 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPlayer getPlayer() {
/* 277 */     return this.thePlayer;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean mergeItemStack(ItemStack is, int slotStart, int slotFinish, boolean reverseOrder, boolean craftingOutput) {
/* 282 */     boolean merged = false;
/* 283 */     int slotIndex = slotStart;
/*     */     
/* 285 */     if (reverseOrder) {
/* 286 */       slotIndex = slotFinish - 1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 291 */     if (is.func_77985_e())
/*     */     {
/* 293 */       while (is.field_77994_a > 0 && ((!reverseOrder && slotIndex < slotFinish) || (reverseOrder && slotIndex >= slotStart))) {
/*     */         
/* 295 */         Slot slot = this.field_75151_b.get(slotIndex);
/* 296 */         ItemStack slotstack = slot.func_75211_c();
/*     */         
/* 298 */         if (slotstack != null && slotstack.func_77973_b() == is.func_77973_b() && is
/*     */           
/* 300 */           .func_77960_j() == slotstack.func_77960_j() && ItemStack.func_77970_a(is, slotstack) && slotstack.field_77994_a < slot.func_75219_a()) {
/*     */           
/* 302 */           int mergedStackSize = is.field_77994_a + getSmaller(slotstack.field_77994_a, slot.func_75219_a());
/*     */ 
/*     */           
/* 305 */           if (mergedStackSize <= is.func_77976_d() && mergedStackSize <= slot.func_75219_a()) {
/*     */             
/* 307 */             is.field_77994_a = 0;
/* 308 */             slotstack.field_77994_a = mergedStackSize;
/* 309 */             slot.func_75218_e();
/* 310 */             merged = true;
/*     */           
/*     */           }
/* 313 */           else if (!craftingOutput && slotstack.field_77994_a < is.func_77976_d() && slotstack.field_77994_a < slot.func_75219_a()) {
/*     */ 
/*     */             
/* 316 */             if (slot.func_75219_a() >= is.func_77976_d()) {
/*     */               
/* 318 */               is.field_77994_a -= is.func_77976_d() - slotstack.field_77994_a;
/* 319 */               slotstack.field_77994_a = is.func_77976_d();
/* 320 */               slot.func_75218_e();
/* 321 */               merged = true;
/*     */             
/*     */             }
/* 324 */             else if (slot.func_75219_a() < is.func_77976_d()) {
/*     */               
/* 326 */               is.field_77994_a -= slot.func_75219_a() - slotstack.field_77994_a;
/* 327 */               slotstack.field_77994_a = slot.func_75219_a();
/* 328 */               slot.func_75218_e();
/* 329 */               merged = true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 334 */         if (reverseOrder) {
/* 335 */           slotIndex--; continue;
/*     */         } 
/* 337 */         slotIndex++;
/*     */       } 
/*     */     }
/*     */     
/* 341 */     if (is.field_77994_a > 0) {
/*     */       
/* 343 */       if (reverseOrder) {
/* 344 */         slotIndex = slotFinish - 1;
/*     */       } else {
/* 346 */         slotIndex = slotStart;
/*     */       } 
/* 348 */       while ((!reverseOrder && slotIndex < slotFinish) || (reverseOrder && slotIndex >= slotStart)) {
/*     */         
/* 350 */         Slot slot = this.field_75151_b.get(slotIndex);
/* 351 */         ItemStack slotstack = slot.func_75211_c();
/* 352 */         if (slotstack == null && slot.func_75214_a(is) && slot.func_75219_a() < is.field_77994_a) {
/*     */           
/* 354 */           ItemStack copy = is.func_77946_l();
/* 355 */           copy.field_77994_a = slot.func_75219_a();
/* 356 */           is.field_77994_a -= slot.func_75219_a();
/* 357 */           slot.func_75215_d(copy);
/* 358 */           slot.func_75218_e();
/* 359 */           merged = true;
/*     */           
/*     */           break;
/*     */         } 
/* 363 */         if (slotstack == null && slot.func_75214_a(is)) {
/*     */           
/* 365 */           slot.func_75215_d(is.func_77946_l());
/* 366 */           slot.func_75218_e();
/* 367 */           is.field_77994_a = 0;
/* 368 */           merged = true;
/*     */           
/*     */           break;
/*     */         } 
/* 372 */         if (reverseOrder) {
/* 373 */           slotIndex--; continue;
/*     */         } 
/* 375 */         slotIndex++;
/*     */       } 
/*     */     } 
/*     */     
/* 379 */     return merged;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getSmaller(int i, int j) {
/* 384 */     if (i < j) {
/* 385 */       return i;
/*     */     }
/* 387 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerPlayerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */