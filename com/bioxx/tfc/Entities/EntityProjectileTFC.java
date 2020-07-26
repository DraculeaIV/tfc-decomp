/*     */ package com.bioxx.tfc.Entities;
/*     */ 
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ 
/*     */ public class EntityProjectileTFC
/*     */   extends EntityArrow
/*     */   implements ICausesDamage {
/*     */   public short damageTaken;
/*  24 */   public Item pickupItem = TFCItems.arrow;
/*     */   
/*     */   public float damageBuff;
/*     */   public float duraBuff;
/*     */   
/*     */   public EntityProjectileTFC(World par1World) {
/*  30 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityProjectileTFC(World world, double i, double j, double k) {
/*  35 */     super(world, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityProjectileTFC(World world, EntityLivingBase shooter, EntityLivingBase victim, float force, float forceVariation) {
/*  40 */     super(world, shooter, victim, force, forceVariation);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityProjectileTFC(World world, EntityLivingBase par2EntityLivingBase, float force) {
/*  45 */     super(world, par2EntityLivingBase, force);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDamageTaken(short d) {
/*  50 */     this.damageTaken = d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPickupItem(Item item) {
/*  55 */     this.pickupItem = item;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70100_b_(EntityPlayer player) {
/*  61 */     if (!this.field_70170_p.field_72995_K) {
/*     */       
/*  63 */       NBTTagCompound nbt = new NBTTagCompound();
/*  64 */       func_70109_d(nbt);
/*     */       
/*  66 */       boolean inground = (nbt.func_74764_b("inGround") && nbt.func_74771_c("inGround") == 1);
/*  67 */       if (inground) {
/*     */         
/*  69 */         ItemStack is = new ItemStack(this.pickupItem, 1, this.damageTaken);
/*  70 */         if (this.duraBuff != 0.0F)
/*  71 */           AnvilManager.setDurabilityBuff(is, this.duraBuff); 
/*  72 */         if (this.damageBuff != 0.0F) {
/*  73 */           AnvilManager.setDamageBuff(is, this.damageBuff);
/*     */         }
/*  75 */         EntityItem ei = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, is);
/*     */         
/*  77 */         if (this.field_70251_a == 1) {
/*     */           
/*  79 */           EntityItemPickupEvent event = new EntityItemPickupEvent(player, ei);
/*     */           
/*  81 */           if (MinecraftForge.EVENT_BUS.post((Event)event)) {
/*     */             return;
/*     */           }
/*     */         } 
/*  85 */         ItemStack itemstack = ei.func_92059_d();
/*     */         
/*  87 */         boolean flag = (this.field_70251_a == 1 || (this.field_70251_a == 2 && player.field_71075_bZ.field_75098_d));
/*  88 */         if (itemstack.field_77994_a <= 0) {
/*  89 */           flag = true;
/*  90 */         } else if (this.field_70251_a == 1 && !player.field_71071_by.func_70441_a(itemstack)) {
/*  91 */           flag = false;
/*     */         } 
/*  93 */         if (flag) {
/*     */           
/*  95 */           func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*  96 */           player.func_71001_a((Entity)this, 1);
/*  97 */           func_70106_y();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 106 */     super.func_70071_h_();
/* 107 */     if (!this.field_70170_p.field_72995_K && this.field_70128_L) {
/*     */       
/* 109 */       int maxDamage = (this.pickupItem instanceof com.bioxx.tfc.Items.Tools.ItemJavelin) ? this.pickupItem.func_77612_l() : 1;
/* 110 */       if (this.field_70173_aa < 1200 && maxDamage > this.damageTaken) {
/* 111 */         this.field_70128_L = false;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 118 */     super.func_70037_a(nbt);
/*     */ 
/*     */     
/* 121 */     this.damageTaken = nbt.func_74765_d("damageTaken");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 127 */     super.func_70014_b(nbt);
/*     */     
/* 129 */     nbt.func_74777_a("damageTaken", this.damageTaken);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 135 */     return EnumDamageType.PIERCING;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\EntityProjectileTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */