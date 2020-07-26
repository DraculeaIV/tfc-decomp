/*     */ package com.bioxx.tfc.TileEntities;
/*     */ import com.bioxx.tfc.Core.Metal.Alloy;
/*     */ import com.bioxx.tfc.Core.Metal.AlloyMetal;
/*     */ import com.bioxx.tfc.Core.Metal.MetalPair;
/*     */ import com.bioxx.tfc.Core.Metal.MetalRegistry;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Interfaces.ISmeltable;
/*     */ import com.bioxx.tfc.api.Metal;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFC_ItemHeat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class TECrucible extends NetworkTileEntity implements IInventory {
/*  22 */   public Map<String, MetalPair> metals = new HashMap<String, MetalPair>();
/*     */   
/*     */   public Alloy currentAlloy;
/*     */   public int temperature;
/*     */   public ItemStack[] storage;
/*     */   public byte inputTick;
/*     */   public byte outputTick;
/*     */   public byte tempTick;
/*     */   private int cookDelay;
/*     */   public static final int MAX_UNITS = 3000;
/*     */   
/*     */   public TECrucible() {
/*  34 */     this.storage = new ItemStack[2];
/*  35 */     this.broadcastRange = 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/*  41 */     super.func_145841_b(nbt);
/*     */     
/*  43 */     nbt.func_74768_a("temp", this.temperature);
/*     */     
/*  45 */     NBTTagList nbttaglist = new NBTTagList();
/*  46 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/*  47 */     while (iter.hasNext()) {
/*     */       
/*  49 */       MetalPair m = iter.next();
/*  50 */       if (m != null) {
/*     */         
/*  52 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  53 */         nbttagcompound1.func_74768_a("ID", Item.func_150891_b(m.type.ingot));
/*  54 */         nbttagcompound1.func_74776_a("AmountF", m.amount);
/*  55 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*  58 */     nbt.func_74782_a("Metals", (NBTBase)nbttaglist);
/*     */     
/*  60 */     nbttaglist = new NBTTagList();
/*  61 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/*  63 */       if (this.storage[i] != null) {
/*     */         
/*  65 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  66 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  67 */         this.storage[i].func_77955_b(nbttagcompound1);
/*  68 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*  71 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/*  77 */     super.func_145839_a(nbt);
/*  78 */     readFromItemNBT(nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromItemNBT(NBTTagCompound nbt) {
/*  83 */     this.temperature = nbt.func_74762_e("temp");
/*  84 */     NBTTagList nbttaglist = nbt.func_150295_c("Metals", 10);
/*     */     int i;
/*  86 */     for (i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/*  88 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  89 */       int id = nbttagcompound1.func_74762_e("ID");
/*  90 */       float amount = nbttagcompound1.func_74765_d("Amount");
/*     */       
/*  92 */       float amountF = amount + nbttagcompound1.func_74760_g("AmountF");
/*  93 */       addMetal(MetalRegistry.instance.getMetalFromItem(Item.func_150899_d(id)), amountF);
/*     */     } 
/*     */     
/*  96 */     nbttaglist = nbt.func_150295_c("Items", 10);
/*  97 */     this.storage = new ItemStack[func_70302_i_()];
/*  98 */     for (i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 100 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 101 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 102 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 103 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 110 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 112 */       this.inputTick = (byte)(this.inputTick + 1);
/* 113 */       this.outputTick = (byte)(this.outputTick + 1);
/* 114 */       this.tempTick = (byte)(this.tempTick + 1);
/*     */       
/* 116 */       if (this.cookDelay > 0) {
/* 117 */         this.cookDelay--;
/*     */       }
/*     */       
/* 120 */       if (this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) == TFCBlocks.forge) {
/*     */         
/* 122 */         TEForge te = (TEForge)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/* 123 */         if (te.fireTemp >= 1.0F && TFCOptions.enableDebugMode) {
/* 124 */           this.temperature = 2000;
/* 125 */         } else if (te.fireTemp > this.temperature) {
/* 126 */           this.temperature++;
/*     */         } 
/* 128 */       }  if (this.tempTick > 22) {
/*     */         
/* 130 */         this.tempTick = 0;
/* 131 */         if (this.temperature > TFC_Climate.getHeightAdjustedTemp(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e)) {
/* 132 */           this.temperature--;
/*     */         }
/*     */       } 
/* 135 */       ItemStack stackToSmelt = this.storage[0];
/* 136 */       if (stackToSmelt != null) {
/*     */         
/* 138 */         Item itemToSmelt = stackToSmelt.func_77973_b();
/* 139 */         int newDamage = stackToSmelt.func_77960_j() + 1;
/* 140 */         int maxDamage = stackToSmelt.func_77958_k() - 1;
/*     */         
/* 142 */         if (itemToSmelt instanceof com.bioxx.tfc.Items.ItemMeltedMetal && TFC_ItemHeat.getIsLiquid(this.storage[0]).booleanValue()) {
/*     */           
/* 144 */           if (this.inputTick > 10)
/*     */           {
/* 146 */             Metal inputMetal = MetalRegistry.instance.getMetalFromItem(itemToSmelt);
/*     */             
/* 148 */             if (this.currentAlloy != null && this.currentAlloy.outputType != null && itemToSmelt == this.currentAlloy.outputType.meltedItem) {
/*     */               
/* 150 */               addMetal(inputMetal, 1.0F);
/* 151 */               if (newDamage >= maxDamage)
/*     */               {
/* 153 */                 this.storage[0] = new ItemStack(TFCItems.ceramicMold, 1, 1);
/*     */               }
/*     */               else
/*     */               {
/* 157 */                 stackToSmelt.func_77964_b(newDamage);
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 162 */               addMetal(inputMetal, 1.0F);
/* 163 */               if (newDamage >= maxDamage) {
/*     */                 
/* 165 */                 this.storage[0] = new ItemStack(TFCItems.ceramicMold, 1, 1);
/*     */               }
/*     */               else {
/*     */                 
/* 169 */                 stackToSmelt.func_77964_b(newDamage);
/*     */               } 
/*     */             } 
/* 172 */             this.inputTick = 0;
/* 173 */             updateGui((byte)0);
/*     */           }
/*     */         
/* 176 */         } else if (itemToSmelt instanceof ISmeltable && ((ISmeltable)itemToSmelt)
/* 177 */           .isSmeltable(stackToSmelt) && 
/* 178 */           !TFC_Core.isOreIron(stackToSmelt) && this.temperature >= 
/* 179 */           TFC_ItemHeat.isCookable(stackToSmelt) && this.cookDelay == 0) {
/*     */           
/* 181 */           Metal mType = ((ISmeltable)itemToSmelt).getMetalType(stackToSmelt);
/* 182 */           if (addMetal(mType, ((ISmeltable)itemToSmelt).getMetalReturnAmount(stackToSmelt))) {
/*     */             
/* 184 */             this.temperature = (int)(this.temperature * 0.9F);
/* 185 */             this.cookDelay = 40;
/* 186 */             if (stackToSmelt.field_77994_a <= 1) {
/* 187 */               this.storage[0] = null;
/*     */             } else {
/* 189 */               (this.storage[0]).field_77994_a--;
/* 190 */             }  updateGui((byte)0);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 195 */       if (this.currentAlloy != null && this.storage[1] != null && this.currentAlloy.outputType != null && this.outputTick >= 2 && this.temperature >= 
/*     */ 
/*     */ 
/*     */         
/* 199 */         TFC_ItemHeat.isCookable(this.currentAlloy.outputType)) {
/*     */         
/* 201 */         if (this.storage[1].func_77973_b() == TFCItems.ceramicMold) {
/*     */           
/* 203 */           this.storage[1] = new ItemStack(this.currentAlloy.outputType.meltedItem, 1, 99);
/* 204 */           TFC_ItemHeat.setTemp(this.storage[1], this.temperature);
/*     */           
/* 206 */           drainOutput(1.0F);
/* 207 */           updateGui((byte)1);
/*     */         }
/* 209 */         else if (this.storage[1].func_77973_b() == this.currentAlloy.outputType.meltedItem && this.storage[1].func_77960_j() > 0) {
/*     */           
/* 211 */           this.storage[1].func_77964_b(this.storage[1].func_77960_j() - 1);
/* 212 */           float inTemp = TFC_ItemHeat.getTemp(this.storage[1]);
/* 213 */           float temp = (this.temperature - inTemp) / 2.0F;
/* 214 */           TFC_ItemHeat.setTemp(this.storage[1], inTemp + temp);
/*     */           
/* 216 */           drainOutput(1.0F);
/* 217 */           (this.storage[1]).field_77994_a = 1;
/* 218 */           updateGui((byte)1);
/*     */         } 
/* 220 */         this.outputTick = 0;
/*     */       } 
/*     */       
/* 223 */       if (this.currentAlloy != null && getTotalMetal() < 1.0F) {
/*     */         
/* 225 */         this.metals = new HashMap<String, MetalPair>();
/* 226 */         updateCurrentAlloy();
/* 227 */         updateGui((byte)2);
/* 228 */         this.currentAlloy = null;
/*     */       } 
/*     */       
/* 231 */       if (this.storage[1] != null && (this.storage[1]).field_77994_a <= 0)
/* 232 */         (this.storage[1]).field_77994_a = 1; 
/* 233 */       if (this.inputTick > 10)
/* 234 */         this.inputTick = 0; 
/* 235 */       if (this.outputTick >= 2) {
/* 236 */         this.outputTick = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean drainOutput(float amount) {
/* 242 */     if (this.metals != null && this.metals.values().size() > 0) {
/*     */       
/* 244 */       for (MetalPair am : this.metals.values()) {
/*     */         
/* 246 */         float percent = this.currentAlloy.getPercentForMetal(am.type) / 100.0F;
/* 247 */         am.amount -= amount * percent;
/*     */       } 
/* 249 */       updateCurrentAlloy();
/*     */     } 
/* 251 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addMetal(Metal m, float amt) {
/* 256 */     if (getTotalMetal() + amt <= 3000.0F && m.name != null && !"Unknown".equals(m.name)) {
/*     */       
/* 258 */       if (this.metals.containsKey(m.name)) {
/* 259 */         ((MetalPair)this.metals.get(m.name)).amount += amt;
/*     */       } else {
/* 261 */         this.metals.put(m.name, new MetalPair(m, amt));
/*     */       } 
/* 263 */       updateCurrentAlloy();
/* 264 */       return true;
/*     */     } 
/* 266 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTotalMetal() {
/* 271 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/* 272 */     float totalAmount = 0.0F;
/* 273 */     while (iter.hasNext()) {
/*     */       
/* 275 */       MetalPair m = iter.next();
/* 276 */       if (m != null)
/* 277 */         totalAmount += m.amount; 
/*     */     } 
/* 279 */     return totalAmount;
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateCurrentAlloy() {
/* 284 */     List<AlloyMetal> a = new ArrayList<AlloyMetal>();
/* 285 */     Iterator<MetalPair> iter = this.metals.values().iterator();
/* 286 */     float totalAmount = getTotalMetal();
/* 287 */     iter = this.metals.values().iterator();
/* 288 */     while (iter.hasNext()) {
/*     */       
/* 290 */       MetalPair m = iter.next();
/* 291 */       if (m != null) {
/* 292 */         a.add(new AlloyMetal(m.type, m.amount / totalAmount * 100.0F));
/*     */       }
/*     */     } 
/* 295 */     Metal match = AlloyManager.INSTANCE.matchesAlloy(a, Alloy.EnumTier.TierV);
/* 296 */     if (match != null) {
/*     */       
/* 298 */       this.currentAlloy = new Alloy(match, totalAmount);
/* 299 */       this.currentAlloy.alloyIngred = a;
/*     */     }
/*     */     else {
/*     */       
/* 303 */       this.currentAlloy = new Alloy(Global.UNKNOWN, totalAmount);
/* 304 */       this.currentAlloy.alloyIngred = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 311 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 317 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 323 */     if (this.storage[i] != null) {
/*     */       
/* 325 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 327 */         ItemStack itemstack = this.storage[i];
/* 328 */         this.storage[i] = null;
/* 329 */         return itemstack;
/*     */       } 
/* 331 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/* 332 */       if ((this.storage[i]).field_77994_a == 0)
/* 333 */         this.storage[i] = null; 
/* 334 */       return itemstack1;
/*     */     } 
/*     */ 
/*     */     
/* 338 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 345 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 351 */     this.storage[i] = itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 357 */     return "Crucible";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 363 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 369 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 375 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 391 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOutCountScaled(int length) {
/* 396 */     if (this.currentAlloy != null) {
/* 397 */       return (int)this.currentAlloy.outputAmount * length / 3000;
/*     */     }
/* 399 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTemperatureScaled(int s) {
/* 404 */     return this.temperature * s / 2500;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateGui(byte action) {
/* 409 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 411 */       NBTTagCompound nbt = new NBTTagCompound();
/* 412 */       nbt.func_74774_a("action", action);
/* 413 */       if (this.currentAlloy != null) {
/* 414 */         if (action == 0) {
/* 415 */           this.currentAlloy.toNBT(nbt);
/*     */         }
/* 417 */         else if (action == 1 && this.currentAlloy != null) {
/* 418 */           nbt.func_74776_a("outputAmount", this.currentAlloy.outputAmount);
/*     */         } 
/*     */       }
/* 421 */       broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 432 */     byte action = nbt.func_74771_c("action");
/* 433 */     if (action == 0) {
/* 434 */       this.currentAlloy = (new Alloy()).fromNBT(nbt);
/* 435 */     } else if (action == 1 && this.currentAlloy != null) {
/*     */       
/* 437 */       this.currentAlloy.outputAmount = nbt.func_74760_g("outputAmount");
/*     */     }
/* 439 */     else if (action == 2) {
/* 440 */       this.currentAlloy = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TECrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */