/*     */ package com.bioxx.tfc.TileEntities;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Enums.EnumFuelMaterial;
/*     */ import com.bioxx.tfc.api.Events.ItemCookEvent;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.HeatIndex;
/*     */ import com.bioxx.tfc.api.HeatRegistry;
/*     */ import com.bioxx.tfc.api.Interfaces.ICookableFood;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import com.bioxx.tfc.api.TileEntities.TEFireEntity;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ public class TEGrill extends NetworkTileEntity implements IInventory {
/*  29 */   public ItemStack[] storage = new ItemStack[6];
/*     */   
/*     */   public byte data;
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  35 */     TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     
/*  37 */     for (int i = 0; i < 6; i++) {
/*     */       
/*  39 */       careForInventorySlot(this.storage[i]);
/*  40 */       cookItem(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  48 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOven() {
/*  53 */     int wallCount = 0;
/*  54 */     if (TFC_Core.isWestFaceSolid(this.field_145850_b, this.field_145851_c - 1, this.field_145848_d, this.field_145849_e))
/*  55 */       wallCount++; 
/*  56 */     if (TFC_Core.isEastFaceSolid(this.field_145850_b, this.field_145851_c + 1, this.field_145848_d, this.field_145849_e))
/*  57 */       wallCount++; 
/*  58 */     if (TFC_Core.isNorthFaceSolid(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e + 1))
/*  59 */       wallCount++; 
/*  60 */     if (TFC_Core.isSouthFaceSolid(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e - 1)) {
/*  61 */       wallCount++;
/*     */     }
/*  63 */     if (TFC_Core.isBottomFaceSolid(this.field_145850_b, this.field_145851_c, this.field_145848_d + 1, this.field_145849_e)) {
/*  64 */       wallCount++;
/*     */     }
/*  66 */     if (this.field_145850_b.func_147439_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.metalTrapDoor) {
/*     */       
/*  68 */       TEMetalTrapDoor te = (TEMetalTrapDoor)this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
/*  69 */       if (te.getSide() == 4) {
/*  70 */         wallCount++;
/*     */       }
/*  72 */     } else if (this.field_145850_b.func_147439_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e) == TFCBlocks.metalTrapDoor) {
/*     */       
/*  74 */       TEMetalTrapDoor te = (TEMetalTrapDoor)this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
/*  75 */       if (te.getSide() == 5) {
/*  76 */         wallCount++;
/*     */       }
/*  78 */     } else if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1) == TFCBlocks.metalTrapDoor) {
/*     */       
/*  80 */       TEMetalTrapDoor te = (TEMetalTrapDoor)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
/*  81 */       if (te.getSide() == 2) {
/*  82 */         wallCount++;
/*     */       }
/*  84 */     } else if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1) == TFCBlocks.metalTrapDoor) {
/*     */       
/*  86 */       TEMetalTrapDoor te = (TEMetalTrapDoor)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
/*  87 */       if (te.getSide() == 3) {
/*  88 */         wallCount++;
/*     */       }
/*     */     } 
/*  91 */     return (wallCount >= 5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDoor(int x, int y, int z) {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void careForInventorySlot(ItemStack is) {
/* 102 */     TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 103 */     if (is != null && te instanceof TEFireEntity) {
/*     */       
/* 105 */       HeatRegistry manager = HeatRegistry.getInstance();
/* 106 */       HeatIndex index = manager.findMatchingIndex(is);
/*     */       
/* 108 */       if (index != null) {
/*     */         
/* 110 */         float temp = TFC_ItemHeat.getTemp(is);
/* 111 */         TEFireEntity fire = (TEFireEntity)te;
/* 112 */         if (fire.fuelTimeLeft > 0 && is.func_77973_b() instanceof com.bioxx.tfc.api.Interfaces.IFood) {
/*     */           
/* 114 */           float inc = Food.getCooked(is) + Math.min(fire.fireTemp / 700.0F, 2.0F);
/* 115 */           Food.setCooked(is, inc);
/* 116 */           temp = inc;
/*     */         }
/* 118 */         else if (fire.fireTemp > temp) {
/*     */           
/* 120 */           temp += TFC_ItemHeat.getTempIncrease(is);
/*     */         } 
/*     */         
/* 123 */         if (fire.fireTemp > temp) {
/* 124 */           temp += TFC_ItemHeat.getTempIncrease(is);
/*     */         } else {
/* 126 */           temp -= TFC_ItemHeat.getTempDecrease(is);
/* 127 */         }  TFC_ItemHeat.setTemp(is, temp);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void cookItem(int i) {
/* 134 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 135 */     Random r = new Random();
/* 136 */     if (this.storage[i] != null) {
/*     */       
/* 138 */       HeatIndex index = manager.findMatchingIndex(this.storage[i]);
/* 139 */       if (index != null && Food.isCooked(this.storage[i])) {
/*     */ 
/*     */         
/* 142 */         int[] cookedTasteProfile = { 0, 0, 0, 0, 0 };
/* 143 */         r = new Random((((ICookableFood)this.storage[i].func_77973_b()).getFoodID() + ((int)Food.getCooked(this.storage[i]) - 600) / 120));
/* 144 */         cookedTasteProfile[0] = r.nextInt(31) - 15;
/* 145 */         cookedTasteProfile[1] = r.nextInt(31) - 15;
/* 146 */         cookedTasteProfile[2] = r.nextInt(31) - 15;
/* 147 */         cookedTasteProfile[3] = r.nextInt(31) - 15;
/* 148 */         cookedTasteProfile[4] = r.nextInt(31) - 15;
/* 149 */         Food.setCookedProfile(this.storage[i], cookedTasteProfile);
/* 150 */         TileEntity te = this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 151 */         if (te instanceof TEFireEntity) {
/*     */           
/* 153 */           TEFireEntity fire = (TEFireEntity)te;
/* 154 */           Food.setFuelProfile(this.storage[i], EnumFuelMaterial.getFuelProfile(fire.fuelTasteProfile));
/*     */         } 
/*     */       } 
/*     */       
/* 158 */       if (index != null && TFC_ItemHeat.getTemp(this.storage[i]) > index.meltTemp) {
/*     */         
/* 160 */         float temp = TFC_ItemHeat.getTemp(this.storage[i]);
/* 161 */         ItemStack output = index.getOutput(this.storage[i], r);
/*     */         
/* 163 */         ItemCookEvent eventMelt = new ItemCookEvent(this.storage[i], output, this);
/* 164 */         MinecraftForge.EVENT_BUS.post((Event)eventMelt);
/* 165 */         output = eventMelt.result;
/*     */ 
/*     */         
/* 168 */         this.storage[i] = output;
/* 169 */         if (this.storage[i] != null && manager.findMatchingIndex(this.storage[i]) != null)
/*     */         {
/*     */           
/* 172 */           TFC_ItemHeat.setTemp(this.storage[i], temp);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSide() {
/* 180 */     return this.data & 0x7;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 185 */     for (ItemStack is : this.storage) {
/*     */       
/* 187 */       if (is != null) {
/* 188 */         return false;
/*     */       }
/*     */     } 
/* 191 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 197 */     super.func_145839_a(nbt);
/* 198 */     this.data = nbt.func_74771_c("data");
/* 199 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 200 */     this.storage = new ItemStack[func_70302_i_()];
/* 201 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 203 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 204 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 205 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 206 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 213 */     super.func_145841_b(nbt);
/* 214 */     nbt.func_74774_a("data", this.data);
/* 215 */     NBTTagList nbttaglist = new NBTTagList();
/* 216 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 218 */       if (this.storage[i] != null) {
/*     */         
/* 220 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 221 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 222 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 223 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 226 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 232 */     if (this.storage[i] != null) {
/*     */       
/* 234 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 236 */         ItemStack itemstack = this.storage[i];
/* 237 */         this.storage[i] = null;
/* 238 */         return itemstack;
/*     */       } 
/* 240 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/* 241 */       if ((this.storage[i]).field_77994_a == 0)
/* 242 */         this.storage[i] = null; 
/* 243 */       return itemstack1;
/*     */     } 
/*     */     
/* 246 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 254 */     Random rand = new Random();
/* 255 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 256 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 257 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 259 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 261 */       if (this.storage[i] != null) {
/*     */         
/* 263 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 264 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 265 */         this.storage[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectItem(int index) {
/* 274 */     Random rand = new Random();
/* 275 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 276 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 277 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 279 */     if (this.storage[index] != null) {
/*     */       
/* 281 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[index]);
/* 282 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 289 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 295 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 301 */     this.storage[i] = itemstack;
/* 302 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 308 */     return "grill";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 314 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer var1) {
/* 320 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {
/* 331 */     if (this.field_145850_b.field_72995_K)
/*     */     {
/* 333 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 340 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 346 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 352 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 357 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 358 */     this.data = nbt.func_74771_c("data");
/* 359 */     this.storage = new ItemStack[func_70302_i_()];
/* 360 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 362 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 363 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 364 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 365 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 371 */     NBTTagList nbttaglist = new NBTTagList();
/* 372 */     nbt.func_74774_a("data", this.data);
/* 373 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 375 */       if (this.storage[i] != null) {
/*     */         
/* 377 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 378 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 379 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 380 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 383 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */