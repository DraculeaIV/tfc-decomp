/*     */ package com.bioxx.tfc.TileEntities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityChickenTFC;
/*     */ import com.bioxx.tfc.Food.ItemFoodTFC;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ public class TENestBox
/*     */   extends TileEntity implements IInventory {
/*  25 */   public ItemStack[] inventory = new ItemStack[4];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBird() {
/*  33 */     return (getBird() != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAnimal getBird() {
/*  38 */     List list = this.field_145850_b.func_72872_a(EntityChickenTFC.class, AxisAlignedBB.func_72330_a(this.field_145851_c + 0.1D, this.field_145848_d, this.field_145849_e + 0.1D, this.field_145851_c + 0.9D, this.field_145848_d + 1.1D, this.field_145849_e + 0.9D));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     if (!list.isEmpty())
/*     */     {
/*  54 */       for (Object e : list) {
/*     */         
/*  56 */         if (((EntityChickenTFC)e).getGender() == IAnimal.GenderEnum.FEMALE && ((EntityChickenTFC)e).isAdult() && ((EntityChickenTFC)e)
/*  57 */           .getAnimalTypeID() == Helper.stringToInt("chicken"))
/*     */         {
/*  59 */           return (EntityAnimal)e;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityAnimal getRooster() {
/*  69 */     List list = this.field_145850_b.func_72872_a(EntityChickenTFC.class, AxisAlignedBB.func_72330_a((this.field_145851_c - 5), this.field_145848_d, (this.field_145849_e - 5), (this.field_145851_c + 5), (this.field_145848_d + 2), (this.field_145849_e + 5)));
/*     */ 
/*     */ 
/*     */     
/*  73 */     if (!list.isEmpty())
/*     */     {
/*  75 */       for (Object e : list) {
/*     */         
/*  77 */         if (((EntityChickenTFC)e).getGender() == IAnimal.GenderEnum.MALE && ((EntityChickenTFC)e).isAdult())
/*  78 */           return (EntityAnimal)e; 
/*     */       } 
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/*  92 */     if (this.inventory[i] != null) {
/*     */       
/*  94 */       if ((this.inventory[i]).field_77994_a <= j) {
/*     */         
/*  96 */         ItemStack itemstack = this.inventory[i];
/*  97 */         this.inventory[i] = null;
/*  98 */         return itemstack;
/*     */       } 
/* 100 */       ItemStack itemstack1 = this.inventory[i].func_77979_a(j);
/* 101 */       if ((this.inventory[i]).field_77994_a == 0)
/* 102 */         this.inventory[i] = null; 
/* 103 */       return itemstack1;
/*     */     } 
/*     */ 
/*     */     
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ejectContents() {
/* 113 */     float f3 = 0.05F;
/*     */     
/* 115 */     Random rand = new Random();
/* 116 */     float f = rand.nextFloat() * 0.8F + 0.1F;
/* 117 */     float f1 = rand.nextFloat() * 2.0F + 0.4F;
/* 118 */     float f2 = rand.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 120 */     for (int i = 0; i < func_70302_i_(); i++) {
/*     */       
/* 122 */       if (this.inventory != null) {
/*     */         
/* 124 */         EntityItem entityitem = new EntityItem(this.field_145850_b, (this.field_145851_c + f), (this.field_145848_d + f1), (this.field_145849_e + f2), this.inventory[i]);
/* 125 */         entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/* 126 */         entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/* 127 */         entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/* 128 */         this.field_145850_b.func_72838_d((Entity)entityitem);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70297_j_() {
/* 136 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 142 */     return "NestBox";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 148 */     return 4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int i) {
/* 154 */     return this.inventory[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int var1) {
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer) {
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack) {
/* 177 */     this.inventory[i] = itemstack;
/* 178 */     if (itemstack != null && itemstack.field_77994_a > func_70297_j_()) {
/* 179 */       itemstack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {
/* 185 */     if (!this.field_145850_b.field_72995_K) {
/*     */       
/* 187 */       EntityAnimal bird = getBird();
/* 188 */       if (bird != null) {
/*     */         
/* 190 */         ItemStack item = ((EntityChickenTFC)bird).getEggs();
/*     */         
/* 192 */         EntityChickenTFC father = (EntityChickenTFC)getRooster();
/* 193 */         for (int j = 0; item != null && j < func_70302_i_(); j++) {
/*     */           
/* 195 */           if (this.inventory[j] == null) {
/*     */             
/* 197 */             ItemFoodTFC.createTag(item, 2.0F);
/* 198 */             if (father != null) {
/*     */               
/* 200 */               NBTTagCompound nbt = item.func_77978_p();
/* 201 */               nbt.func_74772_a("Fertilized", TFC_Time.getTotalTicks() + (long)(TFCOptions.animalTimeMultiplier * (float)TFC_Time.ticksInMonth * 0.75F));
/* 202 */               nbt.func_74782_a("Genes", (NBTBase)createGenes((EntityChickenTFC)bird, father));
/* 203 */               item.func_77982_d(nbt);
/*     */             } 
/* 205 */             this.field_145850_b.func_72956_a((Entity)bird, "mob.chicken.plop", 1.0F, (this.field_145850_b.field_73012_v.nextFloat() - this.field_145850_b.field_73012_v.nextFloat()) * 0.2F + 1.0F);
/* 206 */             func_70299_a(j, item);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 213 */       for (int i = 0; i < func_70302_i_(); i++) {
/*     */         
/* 215 */         if (this.inventory[i] != null)
/*     */         {
/* 217 */           if (this.inventory[i].func_77978_p() != null && this.inventory[i].func_77978_p().func_74764_b("Fertilized")) {
/*     */             
/* 219 */             long time = this.inventory[i].func_77978_p().func_74763_f("Fertilized");
/* 220 */             if (time <= TFC_Time.getTotalTicks()) {
/*     */ 
/*     */               
/* 223 */               EntityChickenTFC chick = new EntityChickenTFC(this.field_145850_b, this.field_145851_c + 0.5D, (this.field_145848_d + 1), this.field_145849_e + 0.5D, (NBTTagCompound)this.inventory[i].func_77978_p().func_74781_a("Genes"));
/* 224 */               chick.func_70012_b(this.field_145851_c + 0.5D, (this.field_145848_d + 1), this.field_145849_e + 0.5D, 0.0F, 0.0F);
/* 225 */               chick.field_70759_as = chick.field_70177_z;
/* 226 */               chick.field_70761_aq = chick.field_70177_z;
/* 227 */               this.field_145850_b.func_72838_d((Entity)chick);
/* 228 */               this.inventory[i] = null;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_145818_k_() {
/* 239 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_94041_b(int i, ItemStack itemstack) {
/* 245 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound createGenes(EntityChickenTFC mother, EntityChickenTFC father) {
/* 250 */     NBTTagCompound nbt = new NBTTagCompound();
/* 251 */     nbt.func_74776_a("m_size", mother.getSizeMod());
/* 252 */     nbt.func_74776_a("f_size", father.getSizeMod());
/* 253 */     return nbt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound nbttagcompound) {
/* 259 */     super.func_145841_b(nbttagcompound);
/* 260 */     NBTTagList nbttaglist = new NBTTagList();
/* 261 */     for (int i = 0; i < this.inventory.length; i++) {
/*     */       
/* 263 */       if (this.inventory[i] != null) {
/*     */         
/* 265 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 266 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 267 */         this.inventory[i].func_77955_b(nbttagcompound1);
/* 268 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 271 */     nbttagcompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound nbttagcompound) {
/* 277 */     super.func_145839_a(nbttagcompound);
/* 278 */     NBTTagList nbttaglist = nbttagcompound.func_150295_c("Items", 10);
/* 279 */     this.inventory = new ItemStack[func_70302_i_()];
/* 280 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */       
/* 282 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 283 */       byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 284 */       if (byte0 >= 0 && byte0 < this.inventory.length)
/* 285 */         this.inventory[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\TileEntities\TENestBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */