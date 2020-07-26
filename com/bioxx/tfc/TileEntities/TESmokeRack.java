/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Core.WeatherManager;
/*     */ import com.bioxx.tfc.api.Food;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TESmokeRack
/*     */   extends NetworkTileEntity
/*     */   implements IInventory {
/*  19 */   public ItemStack[] storage = new ItemStack[2];
/*  20 */   public int[] driedCounter = new int[] { 0, 0 };
/*     */ 
/*     */ 
/*     */   
/*     */   private int dryTimer;
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastSmokedTime;
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/*  33 */     float env = 1.0F;
/*  34 */     float base = 1.0F;
/*     */     
/*  36 */     if (TFC_Climate.getRainfall(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e) < 500.0F) {
/*     */       
/*  38 */       env = 0.75F; base = 0.75F;
/*     */     } 
/*     */     
/*  41 */     this.dryTimer++;
/*  42 */     if (this.dryTimer > 1000) {
/*     */       
/*  44 */       this.dryTimer = 0;
/*  45 */       dryFoods();
/*     */     } 
/*     */     
/*  48 */     if (!WeatherManager.isRainingOnCoord(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e) && TFC_Time.getTotalHours() > (this.lastSmokedTime + 1)) {
/*  49 */       TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, env, base);
/*  50 */     } else if (TFC_Climate.getHeightAdjustedTemp(this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e) > 0.0F) {
/*  51 */       TFC_Core.handleItemTicking(this, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e, env * 2.0F, base * 2.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB getRenderBoundingBox() {
/*  58 */     return AxisAlignedBB.func_72330_a(this.field_145851_c, this.field_145848_d, this.field_145849_e, (this.field_145851_c + 1), (this.field_145848_d + 1), (this.field_145849_e + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbt) {
/*  64 */     super.func_145839_a(nbt);
/*  65 */     TFC_Core.readInventoryFromNBT(nbt, this.storage);
/*  66 */     this.driedCounter = nbt.func_74759_k("driedCounter");
/*  67 */     if (this.driedCounter.length == 0) {
/*  68 */       this.driedCounter = new int[] { 0, 0 };
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbt) {
/*  74 */     super.func_145841_b(nbt);
/*  75 */     TFC_Core.writeInventoryToNBT(nbt, this.storage);
/*  76 */     nbt.func_74783_a("driedCounter", this.driedCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  82 */     return this.storage.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/*  88 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  94 */     (this.storage[i]).field_77994_a -= j;
/*  95 */     return this.storage[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int i) {
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 107 */     boolean flag = false;
/* 108 */     if (!TFC_Core.areItemsEqual(this.storage[i], itemstack))
/*     */     {
/* 110 */       flag = true;
/*     */     }
/*     */     
/* 113 */     if (itemstack != null && !ItemStack.func_77989_b(itemstack, this.storage[i])) {
/*     */       
/* 115 */       if (Food.getDried(itemstack) > 0) {
/* 116 */         this.driedCounter[i] = (int)(TFC_Time.getTotalHours() - Food.getDried(itemstack));
/*     */       } else {
/* 118 */         this.driedCounter[i] = (int)TFC_Time.getTotalHours();
/* 119 */       }  flag = true;
/*     */     } 
/* 121 */     if (flag) {
/*     */       
/* 123 */       this.storage[i] = itemstack;
/* 124 */       broadcastPacketInRange();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack removeStackInSlot(int i) {
/* 130 */     ItemStack is = func_70301_a(i).func_77946_l();
/* 131 */     Food.setDried(is, (int)TFC_Time.getTotalHours() - this.driedCounter[i]);
/* 132 */     func_70299_a(i, (ItemStack)null);
/* 133 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dryFoods() {
/* 138 */     for (int i = 0; i < this.storage.length; i++) {
/*     */       
/* 140 */       if (func_70301_a(i) != null) {
/*     */         
/* 142 */         ItemStack is = func_70301_a(i);
/* 143 */         Food.setDried(is, (int)TFC_Time.getTotalHours() - this.driedCounter[i]);
/* 144 */         this.driedCounter[i] = (int)(TFC_Time.getTotalHours() - Food.getDried(is));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 153 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 159 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 165 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 171 */     return false;
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
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleInitPacket(NBTTagCompound nbt) {
/* 193 */     TFC_Core.readInventoryFromNBT(nbt, this.storage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleDataPacket(NBTTagCompound nbt) {
/* 199 */     this.storage = new ItemStack[this.storage.length];
/* 200 */     TFC_Core.readInventoryFromNBT(nbt, this.storage);
/* 201 */     this.field_145850_b.func_147471_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createDataNBT(NBTTagCompound nbt) {
/* 207 */     TFC_Core.writeInventoryToNBT(nbt, this.storage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void createInitNBT(NBTTagCompound nbt) {
/* 213 */     TFC_Core.writeInventoryToNBT(nbt, this.storage);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TESmokeRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */