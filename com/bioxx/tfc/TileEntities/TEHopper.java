/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.Devices.BlockChestTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import com.bioxx.tfc.api.TFCFluids;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.IHopper;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ 
/*     */ 
/*     */ public class TEHopper
/*     */   extends NetworkTileEntity
/*     */   implements IHopper
/*     */ {
/*  34 */   private ItemStack[] storage = new ItemStack[5];
/*     */   private String customName;
/*  36 */   private int cooldown = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   public int pressCooldown;
/*     */ 
/*     */   
/*     */   public ItemStack pressBlock;
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/*  48 */     super.func_145839_a(nbt);
/*  49 */     NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/*  50 */     this.storage = new ItemStack[func_70302_i_()];
/*     */     
/*  52 */     if (nbt.func_150297_b("CustomName", 8))
/*     */     {
/*  54 */       this.customName = nbt.func_74779_i("CustomName");
/*     */     }
/*     */     
/*  57 */     this.cooldown = nbt.func_74762_e("TransferCooldown");
/*     */     
/*  59 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/*  61 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/*  62 */       byte b0 = nbttagcompound1.func_74771_c("Slot");
/*     */       
/*  64 */       if (b0 >= 0 && b0 < this.storage.length)
/*     */       {
/*  66 */         this.storage[b0] = ItemStack.func_77949_a(nbttagcompound1);
/*     */       }
/*     */     } 
/*     */     
/*  70 */     this.pressCooldown = nbt.func_74762_e("pressCooldown");
/*  71 */     this.pressBlock = ItemStack.func_77949_a(nbt.func_74775_l("pressBlock"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/*  77 */     super.func_145841_b(nbt);
/*  78 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/*  80 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/*  82 */       if (this.storage[i] != null) {
/*     */         
/*  84 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*  85 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/*  86 */         this.storage[i].func_77955_b(nbttagcompound1);
/*  87 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*  92 */     nbt.func_74768_a("TransferCooldown", this.cooldown);
/*     */     
/*  94 */     if (func_145818_k_())
/*     */     {
/*  96 */       nbt.func_74778_a("CustomName", this.customName);
/*     */     }
/*     */     
/*  99 */     nbt.func_74768_a("pressCooldown", this.pressCooldown);
/*     */     
/* 101 */     if (this.pressBlock != null) {
/*     */       
/* 103 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 104 */       this.pressBlock.func_77955_b(nbttagcompound1);
/* 105 */       nbt.func_74782_a("pressBlock", (NBTBase)nbttagcompound1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/* 113 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 2), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 122 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 131 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int amount) {
/* 141 */     if (this.storage[i] != null) {
/*     */ 
/*     */ 
/*     */       
/* 145 */       if ((this.storage[i]).field_77994_a <= amount) {
/*     */         
/* 147 */         ItemStack itemStack = this.storage[i];
/* 148 */         this.storage[i] = null;
/* 149 */         return itemStack;
/*     */       } 
/*     */ 
/*     */       
/* 153 */       ItemStack itemstack = this.storage[i].func_77979_a(amount);
/*     */       
/* 155 */       if ((this.storage[i]).field_77994_a == 0)
/*     */       {
/* 157 */         this.storage[i] = null;
/*     */       }
/*     */       
/* 160 */       return itemstack;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 176 */     if (this.storage[i] != null) {
/*     */       
/* 178 */       ItemStack itemstack = this.storage[i];
/* 179 */       this.storage[i] = null;
/* 180 */       return itemstack;
/*     */     } 
/*     */ 
/*     */     
/* 184 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack is) {
/* 194 */     this.storage[i] = is;
/*     */     
/* 196 */     if (is != null && is.field_77994_a > func_70297_j_())
/*     */     {
/* 198 */       is.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 208 */     return func_145818_k_() ? this.customName : "container.hopper";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 217 */     return (this.customName != null && this.customName.length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(String s) {
/* 222 */     this.customName = s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 231 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer p) {
/* 240 */     return (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this) ? false : ((p.func_70092_e(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack is) {
/* 255 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 261 */     if (this.field_145850_b.field_72995_K) {
/*     */       
/* 263 */       if (this.pressCooldown > 0) {
/* 264 */         this.pressCooldown--;
/*     */       } else {
/* 266 */         this.pressBlock = null;
/*     */       } 
/* 268 */     } else if (this.field_145850_b != null && !this.field_145850_b.field_72995_K) {
/*     */       
/* 270 */       this.cooldown--;
/*     */       
/* 272 */       TFC_Core.handleItemTicking((IInventory)this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */       
/* 274 */       if (this.pressCooldown > 0) {
/*     */         
/* 276 */         this.pressCooldown--;
/* 277 */         if (this.pressCooldown % 20 == 0) {
/* 278 */           press();
/*     */         }
/* 280 */       } else if (this.pressCooldown == 0 && this.pressBlock != null) {
/*     */         
/* 282 */         for (int i = 0; i < this.storage.length; i++) {
/*     */           
/* 284 */           if (this.storage[i] == null || (ItemStack.func_77989_b(this.storage[i], this.pressBlock) && (this.storage[i]).field_77994_a < this.storage[i].func_77976_d())) {
/*     */             
/* 286 */             if (this.storage[i] == null) {
/* 287 */               this.storage[i] = this.pressBlock;
/*     */             } else {
/* 289 */               (this.storage[i]).field_77994_a++;
/* 290 */             }  this.pressBlock = null;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 296 */       if (!isCoolingDown())
/*     */       {
/* 298 */         setCooldown(0);
/*     */       }
/*     */       
/* 301 */       Block blockAbove = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 302 */       if (blockAbove != null && hasPressableItem() > 0)
/*     */       {
/* 304 */         if (this.pressBlock != null && !(blockAbove instanceof com.bioxx.tfc.Blocks.Terrain.BlockCobble) && !(blockAbove instanceof com.bioxx.tfc.Blocks.Terrain.BlockGravel) && !(blockAbove instanceof com.bioxx.tfc.Blocks.Terrain.BlockSand) && !(blockAbove instanceof com.bioxx.tfc.Blocks.Terrain.BlockDirt)) {
/*     */           
/* 306 */           TFC_Core.setBlockToAirWithDrops(this.field_145850_b, this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/*     */         }
/* 308 */         else if (blockAbove instanceof com.bioxx.tfc.Blocks.Terrain.BlockSmooth) {
/*     */           
/* 310 */           this.pressBlock = new ItemStack(blockAbove, 1, this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e));
/* 311 */           this.field_145850_b.func_147468_f(this.field_145851_c, this.field_145848_d + 1, this.field_145849_e);
/* 312 */           sendPressPacket();
/* 313 */           beginPressing();
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void press() {
/* 321 */     TEBarrel barrel = null;
/* 322 */     if (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e) instanceof TEBarrel) {
/* 323 */       barrel = (TEBarrel)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e);
/*     */     }
/* 325 */     ItemStack item = getPressableItem();
/* 326 */     if (item != null) {
/*     */       
/* 328 */       if (item.field_77994_a > 0) {
/* 329 */         Food.setWeight(item, Food.getWeight(item) - 0.64F);
/*     */       }
/* 331 */       if (barrel != null && barrel.canAcceptLiquids() && !barrel.getSealed())
/*     */       {
/* 333 */         barrel.addLiquid(new FluidStack(TFCFluids.OLIVEOIL, 1));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void beginPressing() {
/* 340 */     int pressWeight = hasPressableItem();
/* 341 */     if (pressWeight > 0) {
/*     */       
/* 343 */       this.pressCooldown = (int)(this.pressCooldown + pressWeight / 0.64F * 20.0F);
/* 344 */       sendCooldownPacket();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hasPressableItem() {
/* 350 */     int amount = 0;
/* 351 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 353 */       if (this.storage[i] != null && this.storage[i].func_77973_b() == TFCItems.olive)
/*     */       {
/* 355 */         amount = (int)(amount + Math.floor(Food.getWeight(this.storage[i])));
/*     */       }
/*     */     } 
/* 358 */     return amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getPressableItem() {
/* 363 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 365 */       if (this.storage[i] != null && this.storage[i].func_77973_b() == TFCItems.olive)
/*     */       {
/* 367 */         return this.storage[i];
/*     */       }
/*     */     } 
/* 370 */     return null;
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
/*     */   public void setCooldown(int time) {
/* 409 */     this.cooldown = time;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCoolingDown() {
/* 414 */     return (this.cooldown > 0);
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
/*     */   public static IInventory getInputInventory(IHopper hopper) {
/* 758 */     return searchForOutputInventory(hopper.func_145831_w(), hopper.func_96107_aA(), hopper.func_96109_aB() + 1.0D, hopper.func_96108_aC());
/*     */   }
/*     */ 
/*     */   
/*     */   public static EntityItem searchForLooseInput(World world, double x, double y, double z) {
/* 763 */     List<EntityItem> list = world.func_82733_a(EntityItem.class, AxisAlignedBB.func_72330_a(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.field_94557_a);
/* 764 */     return !list.isEmpty() ? list.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static IInventory searchForOutputInventory(World world, double x, double y, double z) {
/* 769 */     IInventory iinventory = null;
/* 770 */     int i = MathHelper.func_76128_c(x);
/* 771 */     int j = MathHelper.func_76128_c(y);
/* 772 */     int k = MathHelper.func_76128_c(z);
/* 773 */     TileEntity tileentity = world.func_147438_o(i, j, k);
/*     */ 
/*     */     
/* 776 */     if (tileentity instanceof IInventory) {
/*     */       
/* 778 */       iinventory = (IInventory)tileentity;
/*     */       
/* 780 */       if (iinventory instanceof TEChest) {
/*     */         
/* 782 */         Block block = world.func_147439_a(i, j, k);
/*     */         
/* 784 */         if (block instanceof BlockChestTFC)
/*     */         {
/* 786 */           iinventory = ((BlockChestTFC)block).getInventory(world, i, j, k);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 791 */     if (iinventory == null) {
/*     */       
/* 793 */       List<IInventory> list = world.func_94576_a((Entity)null, AxisAlignedBB.func_72330_a(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.field_96566_b);
/*     */       
/* 795 */       if (list != null && !list.isEmpty())
/*     */       {
/* 797 */         iinventory = list.get(world.field_73012_v.nextInt(list.size()));
/*     */       }
/*     */     } 
/*     */     
/* 801 */     return iinventory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 812 */     if (nbt.func_74764_b("pressBlock"))
/*     */     {
/* 814 */       this.pressBlock = ItemStack.func_77949_a(nbt.func_74775_l("pressBlock"));
/*     */     }
/* 816 */     this.pressCooldown = nbt.func_74762_e("pressCooldown");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 822 */     if (this.pressBlock != null) {
/*     */       
/* 824 */       NBTTagCompound pb = new NBTTagCompound();
/* 825 */       this.pressBlock.func_77955_b(pb);
/* 826 */       nbt.func_74782_a("pressBlock", (NBTBase)pb);
/*     */     } 
/* 828 */     nbt.func_74768_a("pressCooldown", this.pressCooldown);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 834 */     if (nbt.func_74764_b("pressBlock"))
/*     */     {
/* 836 */       this.pressBlock = ItemStack.func_77949_a(nbt.func_74775_l("pressBlock"));
/*     */     }
/* 838 */     if (nbt.func_74764_b("pressCooldown"))
/*     */     {
/* 840 */       this.pressCooldown = nbt.func_74762_e("pressCooldown");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendPressPacket() {
/* 846 */     NBTTagCompound nbt = new NBTTagCompound();
/* 847 */     if (this.pressBlock != null) {
/*     */       
/* 849 */       NBTTagCompound pb = new NBTTagCompound();
/* 850 */       this.pressBlock.func_77955_b(pb);
/* 851 */       nbt.func_74782_a("pressBlock", (NBTBase)pb);
/*     */     } 
/* 853 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendCooldownPacket() {
/* 858 */     NBTTagCompound nbt = new NBTTagCompound();
/* 859 */     nbt.func_74768_a("pressCooldown", this.pressCooldown);
/* 860 */     broadcastPacketInRange((AbstractPacket)createDataPacket(nbt));
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96107_aA() {
/* 865 */     return this.field_145851_c;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96109_aB() {
/* 870 */     return this.field_145848_d;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96108_aC() {
/* 875 */     return this.field_145849_e;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TEHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */