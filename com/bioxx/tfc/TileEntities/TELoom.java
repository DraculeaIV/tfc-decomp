/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Render.Models.ModelLoom;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Crafting.LoomManager;
/*     */ import com.bioxx.tfc.api.Crafting.LoomRecipe;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TELoom
/*     */   extends NetworkTileEntity
/*     */   implements IInventory
/*     */ {
/*     */   public byte rotation;
/*     */   public int loomType;
/*     */   private ItemStack[] storage;
/*     */   private boolean weaving;
/*     */   private boolean finished;
/*     */   private ModelLoom model;
/*     */   private int clothCompletionCount;
/*     */   public LoomRecipe recipe;
/*  41 */   private final ResourceLocation defaultTexture = new ResourceLocation("terrafirmacraft", "textures/blocks/String.png");
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUpdate() {
/*  46 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public TELoom() {
/*  51 */     this.storage = new ItemStack[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  64 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  70 */     if (this.storage[i] != null) {
/*     */       
/*  72 */       if ((this.storage[i]).field_77994_a <= j) {
/*     */         
/*  74 */         ItemStack is = this.storage[i];
/*  75 */         this.storage[i] = null;
/*  76 */         return is;
/*     */       } 
/*  78 */       ItemStack isSplit = this.storage[i].func_77979_a(j);
/*  79 */       if ((this.storage[i]).field_77994_a == 0)
/*  80 */         this.storage[i] = null; 
/*  81 */       return isSplit;
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFinished() {
/*  90 */     return this.finished;
/*     */   }
/*     */   
/*     */   public ItemStack addString(ItemStack i) {
/*  94 */     if (!isFinished() && i != null && !this.field_145850_b.field_72995_K) {
/*  95 */       this.recipe = LoomManager.getInstance().findPotentialRecipes(this.storage[0]);
/*  96 */       if (this.storage[0] != null) {
/*     */         
/*  98 */         LoomRecipe lr = LoomManager.getInstance().findPotentialRecipes(i);
/*  99 */         if (lr != null && lr.equals(this.recipe))
/*     */         {
/* 101 */           if (getStringCount() < this.recipe.getReqSize())
/*     */           {
/* 103 */             i.field_77994_a--;
/* 104 */             (this.storage[0]).field_77994_a++;
/* 105 */             updateLoom();
/*     */           }
/*     */         
/*     */         }
/* 109 */       } else if (LoomManager.getInstance().hasPotentialRecipes(i)) {
/* 110 */         i.field_77994_a--;
/* 111 */         ItemStack is = i.func_77946_l();
/* 112 */         is.field_77994_a = 1;
/* 113 */         func_70299_a(0, is);
/*     */       } 
/*     */     } 
/* 116 */     return i;
/*     */   }
/*     */   
/*     */   public ItemStack takeFinishedCloth() {
/* 120 */     if (this.finished) {
/*     */       
/* 122 */       this.finished = false;
/* 123 */       this.clothCompletionCount = 0;
/* 124 */       ItemStack is = this.storage[1].func_77946_l();
/* 125 */       this.storage[1] = null;
/* 126 */       updateLoom();
/* 127 */       return is;
/*     */     } 
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 134 */     float f3 = 0.05F;
/*     */     
/* 136 */     Random rand = new Random();
/* 137 */     float f = rand.nextFloat() * 0.3F + 0.1F;
/* 138 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 139 */     float f2 = rand.nextFloat() * 0.3F + 0.1F;
/*     */     
/* 141 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 143 */       if (this.storage[i] != null) {
/*     */         
/* 145 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.storage[i]);
/* 146 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 147 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 148 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 149 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 157 */     return getRequiredStringCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 163 */     return "Loom";
/*     */   }
/*     */   
/*     */   public ModelLoom getModel() {
/* 167 */     if (this.field_145850_b.field_72995_K) {
/* 168 */       return this.model;
/*     */     }
/* 170 */     return null;
/*     */   }
/*     */   
/*     */   public void setModel(ModelLoom loomModel) {
/* 174 */     if (this.field_145850_b.field_72995_K) {
/* 175 */       this.model = loomModel;
/* 176 */       this.model.cloth = this.clothCompletionCount;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 183 */     return 2;
/*     */   }
/*     */   
/*     */   public ResourceLocation getWoodResource() {
/* 187 */     return new ResourceLocation("terrafirmacraft", "textures/blocks/wood/WoodSheet/" + Global.WOOD_ALL[this.loomType] + ".png");
/*     */   }
/*     */   
/*     */   public ResourceLocation getStringResource() {
/* 191 */     LoomRecipe resource = null;
/*     */     
/* 193 */     if (this.storage[1] != null) {
/* 194 */       resource = LoomManager.getInstance().findMatchingResult(this.storage[1]);
/*     */     } else {
/* 196 */       resource = LoomManager.getInstance().findPotentialRecipes(this.storage[0]);
/*     */     } 
/* 198 */     ResourceLocation rl = LoomManager.getInstance().findMatchingTexture(resource);
/* 199 */     return (resource != null && rl != null) ? rl : this.defaultTexture;
/*     */   }
/*     */   
/*     */   public Item getStringType() {
/* 203 */     return (this.storage[0] != null) ? this.storage[0].func_77973_b() : null;
/*     */   }
/*     */   
/*     */   public int getStringCount() {
/* 207 */     return (this.storage[0] != null) ? (this.storage[0]).field_77994_a : 0;
/*     */   }
/*     */   
/*     */   public void setString(ItemStack is) {
/* 211 */     this.storage[0] = is;
/* 212 */     if (!this.field_145850_b.field_72995_K) {
/* 213 */       updateLoom();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setStringCount(int count) {
/* 218 */     if (this.storage[0] != null) (this.storage[0]).field_77994_a = count; 
/* 219 */     if (!this.field_145850_b.field_72995_K) {
/* 220 */       updateLoom();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 227 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 233 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInvCount() {
/* 238 */     int count = 0;
/* 239 */     for (ItemStack is : this.storage) {
/*     */       
/* 241 */       if (is != null)
/* 242 */         count++; 
/*     */     } 
/* 244 */     if (this.storage[0] != null && count == 1)
/* 245 */       return 0; 
/* 246 */     return count;
/*     */   }
/*     */   
/*     */   public boolean canWeave() {
/* 250 */     this.recipe = LoomManager.getInstance().findMatchingRecipe(this.storage[0]);
/* 251 */     return (this.recipe != null && !this.finished);
/*     */   }
/*     */   
/*     */   public void setIsWeaving(boolean isWeaving) {
/* 255 */     if (canWeave()) {
/* 256 */       this.weaving = isWeaving;
/* 257 */       if (!this.field_145850_b.field_72995_K) {
/* 258 */         updateLoom();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getIsWeaving() {
/* 264 */     return this.weaving;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 271 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack is) {
/* 282 */     this.storage[i] = is;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getInputStack() {
/* 287 */     return this.storage[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 293 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 299 */     return false;
/*     */   }
/*     */   
/*     */   public int getRequiredStringCount() {
/* 303 */     if (this.storage[0] != null) {
/*     */       
/* 305 */       this.recipe = LoomManager.getInstance().findPotentialRecipes(this.storage[0]);
/* 306 */       if (this.recipe != null) {
/* 307 */         return this.recipe.getReqSize();
/*     */       }
/*     */     }
/* 310 */     else if (this.storage[1] != null) {
/*     */       
/* 312 */       this.recipe = LoomManager.getInstance().findMatchingResult(this.storage[1]);
/* 313 */       if (this.recipe != null)
/*     */       {
/* 315 */         return this.recipe.getReqSize();
/*     */       }
/*     */     } 
/* 318 */     return 16;
/*     */   }
/*     */   
/*     */   public void finishCloth() {
/* 322 */     if (!this.finished) {
/* 323 */       NBTTagCompound nbt = new NBTTagCompound();
/* 324 */       this.weaving = false;
/* 325 */       this.finished = true;
/*     */ 
/*     */       
/* 328 */       this.recipe = LoomManager.getInstance().findMatchingRecipe(this.storage[0]);
/* 329 */       this.storage[1] = this.recipe.getResult(this.storage[0]);
/* 330 */       setString((ItemStack)null);
/* 331 */       func_145841_b(nbt);
/* 332 */       broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dropItem() {
/* 337 */     if (!this.field_145850_b.field_72995_K) {
/* 338 */       ejectContents();
/*     */     }
/*     */   }
/*     */   
/*     */   public void finishWeaveCycle() {
/* 343 */     NBTTagCompound nbt = new NBTTagCompound();
/* 344 */     this.weaving = false;
/* 345 */     this.clothCompletionCount++;
/*     */ 
/*     */     
/* 348 */     func_145841_b(nbt);
/* 349 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */   
/*     */   public void updateLoom() {
/* 353 */     NBTTagCompound nbt = new NBTTagCompound();
/*     */ 
/*     */ 
/*     */     
/* 357 */     func_145841_b(nbt);
/* 358 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCloth() {
/* 363 */     return this.clothCompletionCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/* 369 */     super.func_145841_b(nbt);
/* 370 */     nbt.func_74768_a("loomType", this.loomType);
/* 371 */     nbt.func_74774_a("rotation", this.rotation);
/* 372 */     nbt.func_74757_a("weaving", this.weaving);
/* 373 */     nbt.func_74757_a("finished", this.finished);
/* 374 */     nbt.func_74768_a("cloth", this.clothCompletionCount);
/* 375 */     NBTTagList nbttaglist = new NBTTagList();
/* 376 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 378 */       if (this.storage[i] != null) {
/*     */         
/* 380 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 381 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 382 */         this.storage[i].func_77955_b(nbttagcompound1);
/* 383 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 386 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/* 392 */     super.func_145839_a(nbt);
/* 393 */     this.loomType = nbt.func_74762_e("loomType");
/* 394 */     this.weaving = nbt.func_74767_n("weaving");
/* 395 */     this.rotation = nbt.func_74771_c("rotation");
/* 396 */     this.finished = nbt.func_74767_n("finished");
/* 397 */     this.clothCompletionCount = nbt.func_74762_e("cloth");
/* 398 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/* 399 */     this.storage = new ItemStack[func_70302_i_()];
/* 400 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 402 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 403 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 404 */       if (byte0 >= 0 && byte0 < this.storage.length) {
/* 405 */         this.storage[byte0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromItemNBT(NBTTagCompound nbt) {
/* 412 */     this.loomType = nbt.func_74762_e("loomType");
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
/*     */   public void updateGui() {
/* 427 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 434 */     func_145839_a(nbt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 483 */     func_145839_a(nbt);
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
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 496 */     func_145841_b(nbt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerRecipes() {
/* 502 */     LoomManager.getInstance().addRecipe(new LoomRecipe(new ItemStack(TFCItems.woolYarn, 16), new ItemStack(TFCItems.woolCloth, 1)), new ResourceLocation("terrafirmacraft", "textures/blocks/String.png"));
/* 503 */     LoomManager.getInstance().addRecipe(new LoomRecipe(new ItemStack(Items.field_151007_F, 24), new ItemStack(TFCItems.silkCloth, 1)), new ResourceLocation("terrafirmacraft", "textures/blocks/Silk.png"));
/* 504 */     LoomManager.getInstance().addRecipe(new LoomRecipe(new ItemStack(TFCItems.juteFiber, 12), new ItemStack(TFCItems.burlapCloth, 1)), new ResourceLocation("terrafirmacraft", "textures/blocks/Rope.png"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TELoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */