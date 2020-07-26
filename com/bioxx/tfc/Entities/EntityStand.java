/*     */ package com.bioxx.tfc.Entities;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTFCArmor;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityStand extends EntityLiving {
/*  21 */   private static int defaultArmorLength = 4;
/*  22 */   private static int defaultEquipableLength = TFC_Core.getExtraEquipInventorySize();
/*     */   
/*     */   private ItemStack[] armor;
/*     */   private ItemStack[] equipable;
/*     */   private float rotation;
/*     */   public int woodType;
/*     */   
/*     */   public EntityStand(World par1World) {
/*  30 */     super(par1World);
/*  31 */     func_70105_a(1.0F, 2.0F);
/*     */     
/*  33 */     this.field_70158_ak = true;
/*  34 */     this.armor = new ItemStack[defaultArmorLength];
/*  35 */     this.equipable = new ItemStack[defaultEquipableLength];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityStand(World par1World, float rotation, int type) {
/*  41 */     this(par1World);
/*  42 */     this.rotation = rotation;
/*  43 */     this.woodType = type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {
/*  49 */     this.field_70708_bq++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_85032_ar() {
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70626_be() {
/*  60 */     this.field_70702_br = 0.0F;
/*  61 */     this.field_70701_bs = 0.0F;
/*  62 */     func_70623_bb();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  68 */     super.func_70088_a();
/*  69 */     int start = 20;
/*     */     int i;
/*  71 */     for (i = 0; i < defaultArmorLength; i++) {
/*  72 */       this.field_70180_af.func_82709_a(start + i, 5);
/*     */     }
/*  74 */     for (i = 0; i < defaultEquipableLength; i++) {
/*  75 */       this.field_70180_af.func_82709_a(start + i + defaultArmorLength, 5);
/*     */     }
/*  77 */     this.field_70180_af.func_75682_a(start + defaultEquipableLength + defaultArmorLength, new Float(1.0F));
/*  78 */     this.field_70180_af.func_75682_a(start + defaultEquipableLength + defaultArmorLength + 1, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70692_ba() {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  93 */     super.func_70636_d();
/*  94 */     syncData();
/*     */   }
/*     */ 
/*     */   
/*     */   public void syncData() {
/*  99 */     if (this.field_70180_af != null)
/*     */     {
/* 101 */       if (this.field_70170_p.field_72995_K) {
/*     */         
/* 103 */         int start = 20; int i;
/* 104 */         for (i = 0; i < defaultArmorLength; i++) {
/* 105 */           this.armor[i] = this.field_70180_af.func_82710_f(start + i);
/*     */         }
/* 107 */         for (i = 0; i < defaultEquipableLength; i++) {
/* 108 */           this.equipable[i] = this.field_70180_af.func_82710_f(start + i + defaultArmorLength);
/*     */         }
/* 110 */         this.rotation = this.field_70180_af.func_111145_d(start + defaultEquipableLength + defaultArmorLength);
/* 111 */         this.woodType = this.field_70180_af.func_75679_c(start + defaultEquipableLength + defaultArmorLength + 1);
/*     */       }
/*     */       else {
/*     */         
/* 115 */         int start = 20;
/*     */         int i;
/* 117 */         for (i = 0; i < defaultArmorLength; i++) {
/* 118 */           this.field_70180_af.func_75692_b(start + i, this.armor[i]);
/*     */         }
/* 120 */         for (i = 0; i < defaultEquipableLength; i++) {
/* 121 */           this.field_70180_af.func_75692_b(start + i + defaultArmorLength, this.equipable[i]);
/*     */         }
/*     */         
/* 124 */         this.field_70180_af.func_75692_b(start + defaultEquipableLength + defaultArmorLength, Float.valueOf(this.rotation));
/* 125 */         this.field_70180_af.func_75692_b(start + defaultEquipableLength + defaultArmorLength + 1, Integer.valueOf(this.woodType));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 133 */     if (this.field_70170_p.func_72872_a(getClass(), this.field_70121_D).size() > 1) {
/* 134 */       func_70106_y();
/*     */     }
/*     */ 
/*     */     
/* 138 */     double tempX = this.field_70165_t;
/*     */     
/* 140 */     double tempZ = this.field_70161_v;
/* 141 */     super.func_70071_h_();
/* 142 */     if (this.field_70170_p.field_72995_K) {
/* 143 */       func_70105_a(0.125F, 2.0F);
/*     */     } else {
/* 145 */       func_70105_a(0.1F, 2.0F);
/*     */     } 
/* 147 */     func_70012_b(tempX, this.field_70163_u, tempZ, this.rotation, 0.0F);
/*     */     
/* 149 */     func_70101_b(this.rotation, 0.0F);
/* 150 */     this.field_70761_aq = this.rotation;
/* 151 */     this.field_70741_aB = this.rotation;
/* 152 */     this.field_70764_aw = this.rotation;
/* 153 */     this.field_70123_F = false;
/* 154 */     this.field_70754_ba = 0.0F;
/* 155 */     this.field_70721_aZ = 0.0F;
/* 156 */     this.field_70712_bm = this.rotation;
/* 157 */     this.field_70733_aJ = 0.0F;
/* 158 */     this.field_110158_av = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 167 */     if (!this.field_70170_p.field_72995_K) {
/* 168 */       int i; for (i = 0; i < this.armor.length; i++) {
/* 169 */         if (this.armor[i] != null) {
/* 170 */           ItemStack is = new ItemStack(this.armor[i].func_77973_b(), 1, this.armor[i].func_77960_j());
/* 171 */           func_70099_a(is, 0.0F);
/*     */         } 
/*     */       } 
/* 174 */       for (i = 0; i < this.equipable.length; i++) {
/* 175 */         if (this.equipable[i] != null) {
/* 176 */           ItemStack is = new ItemStack(this.equipable[i].func_77973_b(), 1, this.equipable[i].func_77960_j());
/* 177 */           func_70099_a(is, 0.0F);
/*     */         } 
/*     */       } 
/* 180 */       Block blockToDrop = (this.woodType < 16) ? TFCBlocks.armorStand : TFCBlocks.armorStand2;
/* 181 */       func_70099_a(new ItemStack(blockToDrop, 1, this.woodType % 16), 0.0F);
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
/*     */   private Vec3 getPlayerLook(EntityLivingBase entity, float mult) {
/* 195 */     if (mult == 1.0F) {
/*     */       
/* 197 */       float f7 = MathHelper.func_76134_b(-entity.field_70177_z * 0.017453292F - 3.1415927F);
/* 198 */       float f8 = MathHelper.func_76126_a(-entity.field_70177_z * 0.017453292F - 3.1415927F);
/* 199 */       float f9 = -MathHelper.func_76134_b(-entity.field_70125_A * 0.017453292F);
/* 200 */       float f10 = MathHelper.func_76126_a(-entity.field_70125_A * 0.017453292F);
/* 201 */       return Vec3.func_72443_a((f8 * f9), f10, (f7 * f9));
/*     */     } 
/*     */ 
/*     */     
/* 205 */     float f1 = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * mult;
/* 206 */     float f2 = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * mult;
/* 207 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/* 208 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/* 209 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 210 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/* 211 */     return Vec3.func_72443_a((f4 * f5), f6, (f3 * f5));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer ep) {
/* 217 */     if (!this.field_70170_p.field_72995_K) {
/* 218 */       ItemStack is = ep.func_71045_bC();
/* 219 */       if (is != null) {
/* 220 */         if (is.func_77973_b() instanceof ItemTFCArmor) {
/* 221 */           ItemTFCArmor tempArmor = (ItemTFCArmor)is.func_77973_b();
/* 222 */           int slot = tempArmor.getBodyPart();
/* 223 */           if (this.armor[slot] == null) {
/* 224 */             setArmor(slot, is);
/* 225 */             is.field_77994_a--;
/*     */           } 
/* 227 */           ep.func_70062_b(0, is);
/*     */         } 
/*     */       } else {
/*     */         
/* 231 */         Vec3 hitVec = getPlayerLook((EntityLivingBase)ep, 1.0F);
/* 232 */         double angleTan = hitVec.field_72448_b / Math.sqrt(hitVec.field_72450_a * hitVec.field_72450_a + hitVec.field_72449_c * hitVec.field_72449_c);
/*     */         
/* 234 */         double xzDist = Math.sqrt(Math.pow(ep.field_70165_t - this.field_70165_t, 2.0D) + Math.pow(ep.field_70161_v - this.field_70161_v, 2.0D));
/* 235 */         double yLevel = angleTan * xzDist + ep.eyeHeight + ep.field_70163_u;
/* 236 */         double y = yLevel - this.field_70163_u;
/*     */         
/* 238 */         int slot = -1;
/* 239 */         if (y >= 0.0D && y < 0.3D) {
/* 240 */           slot = 0;
/*     */         }
/* 242 */         else if (y >= 0.3D && y < 1.0D) {
/* 243 */           slot = 1;
/*     */         }
/* 245 */         else if (y >= 1.0D && y < 1.4D) {
/* 246 */           slot = 2;
/*     */         }
/* 248 */         else if (y >= 1.4D && y < 2.0D) {
/* 249 */           slot = 3;
/*     */         } 
/*     */ 
/*     */         
/* 253 */         if (slot != -1) {
/* 254 */           ItemStack i = this.armor[slot];
/* 255 */           this.armor[slot] = null;
/* 256 */           giveItemToPlayer(this.field_70170_p, ep, i);
/*     */         } 
/*     */       } 
/*     */     } 
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   public void giveItemToPlayer(World world, EntityPlayer ep, ItemStack is) {
/* 264 */     if (world != null && ep != null && is != null) {
/* 265 */       is.field_77994_a = 1;
/* 266 */       EntityItem ei = new EntityItem(world, ep.field_70165_t, ep.field_70163_u, ep.field_70161_v, is);
/* 267 */       world.func_72838_d((Entity)ei);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbttagcompound) {
/* 274 */     super.func_70037_a(nbttagcompound);
/*     */ 
/*     */ 
/*     */     
/* 278 */     this.rotation = nbttagcompound.func_74760_g("Rotation");
/* 279 */     this.woodType = nbttagcompound.func_74762_e("Wood");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     if (nbttagcompound.func_150297_b("Armor", 9)) {
/*     */       
/* 286 */       NBTTagList nbttaglist = nbttagcompound.func_150295_c("Armor", 10);
/*     */       
/* 288 */       for (int i = 0; i < defaultArmorLength; i++)
/*     */       {
/* 290 */         this.armor[i] = ItemStack.func_77949_a(nbttaglist.func_150305_b(i));
/*     */       }
/*     */     } 
/*     */     
/* 294 */     if (nbttagcompound.func_150297_b("Equipable", 9)) {
/*     */       
/* 296 */       NBTTagList nbttaglist = nbttagcompound.func_150295_c("Equipable", 10);
/*     */       
/* 298 */       for (int i = 0; i < defaultEquipableLength; i++)
/*     */       {
/* 300 */         this.equipable[i] = ItemStack.func_77949_a(nbttaglist.func_150305_b(i));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 306 */     return this.rotation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbttagcompound) {
/* 312 */     super.func_70014_b(nbttagcompound);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     nbttagcompound.func_74776_a("Rotation", this.rotation);
/* 318 */     nbttagcompound.func_74768_a("Wood", this.woodType);
/*     */     
/* 320 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/*     */     int i;
/* 323 */     for (i = 0; i < defaultArmorLength; i++) {
/*     */       
/* 325 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */       
/* 327 */       if (this.armor[i] != null)
/*     */       {
/* 329 */         this.armor[i].func_77955_b(nbttagcompound1);
/*     */       }
/*     */       
/* 332 */       nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */     } 
/*     */     
/* 335 */     nbttagcompound.func_74782_a("Armor", (NBTBase)nbttaglist);
/*     */     
/* 337 */     nbttaglist = new NBTTagList();
/* 338 */     for (i = 0; i < defaultEquipableLength; i++) {
/*     */       
/* 340 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */       
/* 342 */       if (this.equipable[i] != null)
/*     */       {
/* 344 */         this.equipable[i].func_77955_b(nbttagcompound1);
/*     */       }
/*     */       
/* 347 */       nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */     } 
/*     */     
/* 350 */     nbttagcompound.func_74782_a("Equipable", (NBTBase)nbttaglist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_70694_bm() {
/* 356 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getEquipableInSlot(int i) {
/* 362 */     if (this.equipable != null && defaultEquipableLength > i) {
/* 363 */       return this.equipable[i];
/*     */     }
/* 365 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getArmorInSlot(int i) {
/* 370 */     if (this.armor != null && defaultArmorLength > i) {
/* 371 */       return this.armor[i];
/*     */     }
/* 373 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setArmor(int i, ItemStack itemstack) {
/* 378 */     if (this.armor != null && defaultArmorLength > i) {
/* 379 */       this.armor[i] = itemstack;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEquipable(int i, ItemStack itemstack) {
/* 387 */     if (this.equipable != null && defaultEquipableLength > i)
/* 388 */       this.equipable[i] = itemstack; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */