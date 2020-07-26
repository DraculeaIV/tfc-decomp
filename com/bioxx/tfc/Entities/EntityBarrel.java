/*     */ package com.bioxx.tfc.Entities;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityBarrel
/*     */   extends Entity
/*     */ {
/*     */   public int fuse;
/*     */   public ItemStack origBarrel;
/*     */   private int gunpowder;
/*     */   
/*     */   public EntityBarrel(World par1World) {
/*  23 */     super(par1World);
/*  24 */     this.fuse = 60;
/*     */     
/*  26 */     this.field_70156_m = true;
/*  27 */     func_70105_a(0.98F, 0.98F);
/*  28 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityBarrel(World world, double x, double y, double z, ItemStack is, int gunpowderCount) {
/*  33 */     this(world);
/*  34 */     this.gunpowder = gunpowderCount;
/*  35 */     func_70107_b(x, y, z);
/*  36 */     float f = (float)(Math.random() * Math.PI * 2.0D);
/*  37 */     this.field_70159_w = (-((float)Math.sin(f)) * 0.02F);
/*  38 */     this.field_70181_x = 0.20000000298023224D;
/*  39 */     this.field_70179_y = (-((float)Math.cos(f)) * 0.02F);
/*  40 */     this.field_70169_q = x;
/*  41 */     this.field_70167_r = y;
/*  42 */     this.field_70166_s = z;
/*  43 */     this.origBarrel = is;
/*  44 */     this.field_70180_af.func_75692_b(20, Integer.valueOf(this.origBarrel.func_77960_j()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFuse(int f) {
/*  49 */     this.fuse = f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  55 */     this.fuse--;
/*  56 */     if (this.fuse <= 0) {
/*     */       
/*  58 */       if (!this.field_70170_p.field_72995_K)
/*  59 */         explode(); 
/*  60 */       func_70106_y();
/*     */     } 
/*  62 */     this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, (new Random()).nextFloat(), 1.0D, (new Random()).nextFloat());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_85032_ar() {
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void explode() {
/*  73 */     float f = this.gunpowder / 12.0F;
/*  74 */     this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, f, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  80 */     this.field_70180_af.func_75682_a(20, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/*  86 */     int x = (int)Math.floor(this.field_70165_t), y = (int)Math.floor(this.field_70163_u), z = (int)Math.floor(this.field_70161_v);
/*  87 */     if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_147465_d(x, y, z, TFCBlocks.barrel, getBarrelType() & 0xF, 2)) {
/*     */       
/*  89 */       TEBarrel te = (TEBarrel)this.field_70170_p.func_147438_o(x, y, z);
/*  90 */       te.readFromItemNBT(this.origBarrel.func_77978_p());
/*  91 */       func_70106_y();
/*     */     } 
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  99 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity entity) {
/* 105 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBarrelType() {
/* 110 */     return this.field_70180_af.func_75679_c(20);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {
/* 116 */     this.fuse = nbt.func_74771_c("Fuse");
/* 117 */     this.origBarrel = ItemStack.func_77949_a((NBTTagCompound)nbt.func_74781_a("item"));
/* 118 */     this.field_70180_af.func_75692_b(20, Integer.valueOf(this.origBarrel.func_77960_j()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {
/* 124 */     nbt.func_74774_a("Fuse", (byte)this.fuse);
/* 125 */     nbt.func_74782_a("item", (NBTBase)this.origBarrel.func_77955_b(new NBTTagCompound()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityBarrel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */