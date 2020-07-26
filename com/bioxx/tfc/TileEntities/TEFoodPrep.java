/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.CreateMealPacket;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.Interfaces.IFood;
/*     */ import com.bioxx.tfc.api.Interfaces.IItemFoodBlock;
/*     */ import com.bioxx.tfc.api.TFCItems;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TEFoodPrep
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*  30 */   public ItemStack[] storage = new ItemStack[11];
/*     */   public int lastTab;
/*  32 */   private final float[] sandwichWeights = new float[] { 2.0F, 3.0F, 2.0F, 2.0F, 1.0F };
/*  33 */   private final float[] saladWeights = new float[] { 10.0F, 4.0F, 4.0F, 2.0F };
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  38 */     TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFoodIdFromItemStack(ItemStack is) {
/*  43 */     if (is != null) {
/*     */       
/*  45 */       if (is.func_77973_b() instanceof IFood)
/*  46 */         return ((IFood)is.func_77973_b()).getFoodID(); 
/*  47 */       if (is.func_77973_b() instanceof IItemFoodBlock)
/*  48 */         return ((IItemFoodBlock)is.func_77973_b()).getFoodId(is); 
/*     */     } 
/*  50 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  57 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHealAmountFromItemStack(ItemStack is) {
/*  62 */     if (is != null) {
/*     */       
/*  64 */       if (is.func_77973_b() instanceof IFood)
/*  65 */         return ((IFood)is.func_77973_b()).getFoodID(); 
/*  66 */       if (is.func_77973_b() instanceof IItemFoodBlock)
/*  67 */         return ((IItemFoodBlock)is.func_77973_b()).getHealAmount(is); 
/*     */     } 
/*  69 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionCreate(EntityPlayer player) {
/*  74 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/*  76 */       if (this.lastTab == 0) {
/*  77 */         createSandwich(player);
/*  78 */       } else if (this.lastTab == 1) {
/*  79 */         createSalad(player);
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  85 */       CreateMealPacket createMealPacket = new CreateMealPacket(0, this);
/*  86 */       broadcastPacketInRange((AbstractPacket)createMealPacket);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void createSandwich(EntityPlayer player) {
/*  92 */     if (validateSandwich()) {
/*     */       
/*  94 */       ItemStack is = new ItemStack(TFCItems.sandwich, 1);
/*     */       
/*  96 */       float w = 0.0F;
/*  97 */       for (int i = 0; i < 5; i++) {
/*     */         
/*  99 */         ItemStack f = func_70301_a(i);
/* 100 */         if (f != null && Food.getWeight(f) >= this.sandwichWeights[i]) {
/* 101 */           w += this.sandwichWeights[i];
/*     */         }
/*     */       } 
/* 104 */       ItemFoodTFC.createTag(is, w);
/* 105 */       Food.setDecayRate(is, 2.0F);
/*     */       
/* 107 */       int[] foodGroups = { -1, -1, -1, -1, -1 };
/* 108 */       if (func_70301_a(0) != null) foodGroups[0] = ((IFood)func_70301_a(0).func_77973_b()).getFoodID(); 
/* 109 */       if (func_70301_a(1) != null) foodGroups[1] = ((IFood)func_70301_a(1).func_77973_b()).getFoodID(); 
/* 110 */       if (func_70301_a(2) != null) foodGroups[2] = ((IFood)func_70301_a(2).func_77973_b()).getFoodID(); 
/* 111 */       if (func_70301_a(3) != null) foodGroups[3] = ((IFood)func_70301_a(3).func_77973_b()).getFoodID(); 
/* 112 */       if (func_70301_a(4) != null) foodGroups[4] = ((IFood)func_70301_a(4).func_77973_b()).getFoodID();
/*     */       
/* 114 */       Food.setFoodGroups(is, foodGroups);
/* 115 */       setSandwichIcon(is);
/*     */       
/* 117 */       combineTastes(is.func_77978_p(), this.sandwichWeights, new ItemStack[] { func_70301_a(0), func_70301_a(1), func_70301_a(2), func_70301_a(3), func_70301_a(4) });
/*     */       
/* 119 */       Food.setMealSkill(is, TFC_Core.getSkillStats(player).getSkillRank("skill.cooking").ordinal());
/* 120 */       func_70299_a(6, is);
/*     */       
/* 122 */       consumeFoodWeight(this.sandwichWeights, new ItemStack[] { func_70301_a(0), func_70301_a(1), func_70301_a(2), 
/* 123 */             func_70301_a(3), func_70301_a(4) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setSandwichIcon(ItemStack is) {
/* 129 */     if (func_70301_a(0).func_77973_b() == TFCItems.wheatBread) {
/* 130 */       is.func_77964_b(0);
/* 131 */     } else if (func_70301_a(0).func_77973_b() == TFCItems.oatBread) {
/* 132 */       is.func_77964_b(1);
/* 133 */     } else if (func_70301_a(0).func_77973_b() == TFCItems.barleyBread) {
/* 134 */       is.func_77964_b(2);
/* 135 */     } else if (func_70301_a(0).func_77973_b() == TFCItems.ryeBread) {
/* 136 */       is.func_77964_b(3);
/* 137 */     } else if (func_70301_a(0).func_77973_b() == TFCItems.cornBread) {
/* 138 */       is.func_77964_b(4);
/* 139 */     } else if (func_70301_a(0).func_77973_b() == TFCItems.riceBread) {
/* 140 */       is.func_77964_b(5);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void createSalad(EntityPlayer player) {
/* 145 */     if (validateSalad()) {
/*     */       
/* 147 */       ItemStack is = new ItemStack(TFCItems.salad, 1);
/*     */       
/* 149 */       float w = 0.0F;
/* 150 */       for (int i = 0; i < 4; i++) {
/*     */         
/* 152 */         ItemStack f = func_70301_a(i + 1);
/* 153 */         if (f != null && Food.getWeight(f) >= this.saladWeights[i]) {
/* 154 */           w += this.saladWeights[i];
/*     */         }
/*     */       } 
/* 157 */       ItemFoodTFC.createTag(is, w);
/* 158 */       Food.setDecayRate(is, 2.0F);
/*     */       
/* 160 */       int[] foodGroups = { -1, -1, -1, -1 };
/* 161 */       if (func_70301_a(1) != null) foodGroups[0] = ((IFood)func_70301_a(1).func_77973_b()).getFoodID(); 
/* 162 */       if (func_70301_a(2) != null) foodGroups[1] = ((IFood)func_70301_a(2).func_77973_b()).getFoodID(); 
/* 163 */       if (func_70301_a(3) != null) foodGroups[2] = ((IFood)func_70301_a(3).func_77973_b()).getFoodID(); 
/* 164 */       if (func_70301_a(4) != null) foodGroups[3] = ((IFood)func_70301_a(4).func_77973_b()).getFoodID();
/*     */       
/* 166 */       Food.setFoodGroups(is, foodGroups);
/*     */       
/* 168 */       is.func_77964_b((new Random(getIconSeed())).nextInt(((ItemTerra)TFCItems.salad).metaIcons.length));
/*     */       
/* 170 */       combineTastes(is.func_77978_p(), this.saladWeights, new ItemStack[] { func_70301_a(1), func_70301_a(2), func_70301_a(3), func_70301_a(4) });
/*     */       
/* 172 */       Food.setMealSkill(is, TFC_Core.getSkillStats(player).getSkillRank("skill.cooking").ordinal());
/* 173 */       func_70299_a(6, is);
/*     */       
/* 175 */       consumeFoodWeight(this.saladWeights, new ItemStack[] { func_70301_a(1), func_70301_a(2), func_70301_a(3), func_70301_a(4) });
/*     */       
/* 177 */       (TFC_Core.getItemInInventory(TFCItems.potteryBowl, this)).field_77994_a--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validateSandwich() {
/* 183 */     if (this.lastTab == 0) {
/*     */       
/* 185 */       if (this.storage[0] == null || this.storage[6] != null) {
/* 186 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       if (!validateIngreds(new ItemStack[] { this.storage[1], this.storage[2], this.storage[3], this.storage[4] })) {
/* 194 */         return false;
/*     */       }
/* 196 */       float weight = 0.0F;
/* 197 */       for (int i = 0; i < 5; i++) {
/*     */         
/* 199 */         ItemStack f = func_70301_a(i);
/* 200 */         if (f != null && f.func_77973_b() instanceof IFood && Food.getWeight(f) - Food.getDecay(f) >= this.sandwichWeights[i])
/*     */         {
/* 202 */           weight += this.sandwichWeights[i];
/*     */         }
/*     */       } 
/*     */       
/* 206 */       if (weight < 7.0F)
/* 207 */         return false; 
/*     */     } 
/* 209 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validateSalad() {
/* 214 */     if (this.lastTab == 1) {
/*     */       
/* 216 */       if (this.storage[6] != null) {
/* 217 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       if (!validateIngreds(new ItemStack[] { this.storage[1], this.storage[2], this.storage[3], this.storage[4] })) {
/* 227 */         return false;
/*     */       }
/* 229 */       float weight = 0.0F;
/* 230 */       for (int i = 0; i < 4; i++) {
/*     */         
/* 232 */         ItemStack f = func_70301_a(i + 1);
/* 233 */         if (f != null && Food.getWeight(f) - Food.getDecay(f) >= this.saladWeights[i])
/*     */         {
/* 235 */           weight += this.saladWeights[i];
/*     */         }
/*     */       } 
/*     */       
/* 239 */       if (weight < 14.0F) {
/* 240 */         return false;
/*     */       }
/* 242 */       ItemStack bowlStack = TFC_Core.getItemInInventory(TFCItems.potteryBowl, this);
/* 243 */       if (bowlStack == null || bowlStack.func_77960_j() != 1)
/*     */       {
/* 245 */         return false;
/*     */       }
/*     */     } 
/* 248 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean validateIngreds(ItemStack... is) {
/* 253 */     for (int i = 0; i < is.length; i++) {
/*     */       
/* 255 */       if (is[i] != null && !((IFood)is[i].func_77973_b()).isUsable(is[i]))
/* 256 */         return false; 
/* 257 */       for (int j = 0; j < is.length; j++) {
/*     */ 
/*     */         
/* 260 */         if (j != i && !compareIngred(is[i], is[j]))
/* 261 */           return false; 
/*     */       } 
/*     */     } 
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compareIngred(ItemStack is1, ItemStack is2) {
/* 269 */     return (is1 == null || is2 == null || is1.func_77973_b() != is2.func_77973_b());
/*     */   }
/*     */ 
/*     */   
/*     */   private void combineTastes(NBTTagCompound nbt, float[] weights, ItemStack... isArray) {
/* 274 */     int tasteSweet = 0;
/* 275 */     int tasteSour = 0;
/* 276 */     int tasteSalty = 0;
/* 277 */     int tasteBitter = 0;
/* 278 */     int tasteUmami = 0;
/*     */     
/* 280 */     for (int i = 0; i < isArray.length; i++) {
/*     */       
/* 282 */       float weightMult = 1.0F;
/* 283 */       if (isArray[i] != null) {
/*     */         
/* 285 */         tasteSweet = (int)(tasteSweet + ((IFood)isArray[i].func_77973_b()).getTasteSweet(isArray[i]) * weightMult);
/* 286 */         tasteSour = (int)(tasteSour + ((IFood)isArray[i].func_77973_b()).getTasteSour(isArray[i]) * weightMult);
/* 287 */         tasteSalty = (int)(tasteSalty + ((IFood)isArray[i].func_77973_b()).getTasteSalty(isArray[i]) * weightMult);
/* 288 */         tasteBitter = (int)(tasteBitter + ((IFood)isArray[i].func_77973_b()).getTasteBitter(isArray[i]) * weightMult);
/* 289 */         tasteUmami = (int)(tasteUmami + ((IFood)isArray[i].func_77973_b()).getTasteSavory(isArray[i]) * weightMult);
/*     */       } 
/*     */     } 
/* 292 */     nbt.func_74768_a("tasteSweet", tasteSweet);
/* 293 */     nbt.func_74768_a("tasteSour", tasteSour);
/* 294 */     nbt.func_74768_a("tasteSalty", tasteSalty);
/* 295 */     nbt.func_74768_a("tasteBitter", tasteBitter);
/* 296 */     nbt.func_74768_a("tasteUmami", tasteUmami);
/*     */   }
/*     */ 
/*     */   
/*     */   public void openGui(EntityPlayer player) {
/* 301 */     if (this.lastTab == 0) {
/* 302 */       player.openGui(TerraFirmaCraft.instance, 44, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 303 */     } else if (this.lastTab == 1) {
/* 304 */       player.openGui(TerraFirmaCraft.instance, 45, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getIconSeed() {
/* 322 */     int seed = 0;
/* 323 */     for (int i = 1; i < 5; i++) {
/*     */       
/* 325 */       ItemStack is = func_70301_a(i);
/* 326 */       if (is != null)
/* 327 */         seed += ((ItemFoodTFC)is.func_77973_b()).getFoodID(); 
/*     */     } 
/* 329 */     return seed + this.field_145850_b.func_72905_C();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeFoodWeight(float[] weights, ItemStack... isArray) {
/* 334 */     for (int i = 0; i < isArray.length; i++) {
/*     */       
/* 336 */       ItemStack is = isArray[i];
/* 337 */       if (is != null) {
/*     */         
/* 339 */         float oldW = Food.getWeight(is);
/* 340 */         Food.setWeight(is, oldW - weights[i]);
/* 341 */         float newW = Food.getWeight(is);
/* 342 */         if (newW <= 0.0F || newW <= Food.getDecay(is)) {
/* 343 */           is.field_77994_a = 0;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 351 */     super.func_145839_a(nbt);
/* 352 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 353 */     this.storage = new ItemStack[func_70302_i_()];
/* 354 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 356 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 357 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 358 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 359 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 366 */     super.func_145841_b(nbt);
/* 367 */     NBTTagList nbttaglist = new NBTTagList();
/* 368 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 370 */       if (this.storage[i] != null) {
/*     */         
/* 372 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 373 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 374 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 375 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 378 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 384 */     if (this.storage[i] != null) {
/*     */       
/* 386 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/* 388 */         ItemStack itemstack = this.storage[i];
/* 389 */         this.storage[i] = null;
/* 390 */         return itemstack;
/*     */       } 
/* 392 */       ItemStack itemstack1 = this.storage[i].func_77979_a(j);
/* 393 */       if ((this.storage[i]).field_77994_a == 0)
/* 394 */         this.storage[i] = null; 
/* 395 */       return itemstack1;
/*     */     } 
/*     */     
/* 398 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 404 */     float f3 = 0.05F;
/*     */     
/* 406 */     Random rand = new Random();
/* 407 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 408 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 409 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 411 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 413 */       if (this.storage[i] != null) {
/*     */         
/* 415 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 416 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 417 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 418 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 419 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/* 420 */         this.storage[i] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectItem(int index) {
/* 427 */     float f3 = 0.05F;
/*     */     
/* 429 */     Random rand = new Random();
/* 430 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 431 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 432 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 434 */     if (this.storage[index] != null) {
/*     */       
/* 436 */       EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[index]);
/* 437 */       entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 438 */       entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.05F);
/* 439 */       entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 440 */       this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 447 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 453 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 459 */     if (!TFC_Core.areItemsEqual(this.storage[i], itemstack))
/* 460 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e); 
/* 461 */     this.storage[i] = itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 467 */     return "FoodPrep";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 473 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer var1) {
/* 479 */     return false;
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
/* 490 */     if (this.field_145850_b.field_72995_K)
/*     */     {
/* 492 */       this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 504 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 510 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 516 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionSwitchTab(int tab, EntityPlayer player) {
/* 521 */     NBTTagCompound nbt = new NBTTagCompound();
/* 522 */     nbt.func_74774_a("tab", (byte)tab);
/* 523 */     nbt.func_74778_a("player", player.func_70005_c_());
/* 524 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 529 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 530 */     this.storage = new ItemStack[func_70302_i_()];
/* 531 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 533 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 534 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 535 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 536 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 542 */     NBTTagList nbttaglist = new NBTTagList();
/* 543 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 545 */       if (this.storage[i] != null) {
/*     */         
/* 547 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 548 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 549 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 550 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 553 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 559 */     if (!this.field_145850_b.field_72995_K)
/*     */     {
/* 561 */       if (nbt.func_74764_b("tab")) {
/*     */         
/* 563 */         int tab = nbt.func_74771_c("tab");
/* 564 */         EntityPlayer player = this.field_145850_b.func_72924_a(nbt.func_74779_i("player"));
/* 565 */         if (player != null && tab == 0) {
/* 566 */           player.openGui(TerraFirmaCraft.instance, 44, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 567 */         } else if (player != null && tab == 1) {
/* 568 */           player.openGui(TerraFirmaCraft.instance, 45, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */