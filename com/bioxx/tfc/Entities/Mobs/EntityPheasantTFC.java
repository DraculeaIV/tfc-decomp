/*     */ package com.bioxx.tfc.Entities.Mobs;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class EntityPheasantTFC
/*     */   extends EntityChickenTFC
/*     */ {
/*     */   private boolean wasRoped;
/*     */   
/*     */   public EntityPheasantTFC(World par1World) {
/*  24 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityPheasantTFC(World world, double posX, double posY, double posZ, NBTTagCompound genes) {
/*  29 */     super(world, posX, posY, posZ, genes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAI() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70692_ba() {
/*  41 */     return (this.field_70173_aa > 3000 && !this.wasRoped);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  47 */     super.func_110147_ax();
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  58 */     this.field_70887_j = 10000;
/*  59 */     if (func_110167_bD() && !this.wasRoped)
/*  60 */       this.wasRoped = true; 
/*  61 */     super.func_70636_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/*  70 */     return func_70631_g_() ? "terrafirmacraft:mob.pheasant.chick.say" : "terrafirmacraft:mob.pheasant.say";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/*  79 */     return func_70631_g_() ? null : "terrafirmacraft:mob.pheasant.hurt";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String func_70673_aS() {
/*  88 */     return func_70631_g_() ? null : "terrafirmacraft:mob.pheasant.death";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void roosterCrow() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 103 */     float ageMod = TFC_Core.getPercentGrown(this);
/* 104 */     func_145779_a(Items.field_151008_G, (int)(ageMod * getSizeMod() * (5 + this.field_70146_Z.nextInt(10))));
/*     */     
/* 106 */     if (isAdult()) {
/*     */       
/* 108 */       float foodWeight = ageMod * getSizeMod() * 40.0F;
/* 109 */       TFC_Core.animalDropMeat((Entity)this, TFCItems.chickenRaw, foodWeight);
/* 110 */       func_145779_a(Items.field_151103_aS, this.field_70146_Z.nextInt(2) + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMateWith(IAnimal animal) {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityAgeable createChildTFC(EntityAgeable entityageable) {
/* 123 */     if (entityageable instanceof IAnimal) {
/*     */       
/* 125 */       IAnimal animal = (IAnimal)entityageable;
/* 126 */       NBTTagCompound nbt = new NBTTagCompound();
/* 127 */       nbt.func_74776_a("m_size", animal.getSizeMod());
/* 128 */       nbt.func_74776_a("f_size", animal.getSizeMod());
/* 129 */       return (EntityAgeable)new EntityPheasantTFC(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, nbt);
/*     */     } 
/*     */     
/* 132 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 138 */     super.func_70037_a(nbt);
/* 139 */     this.wasRoped = nbt.func_74767_n("wasRoped");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 145 */     super.func_70014_b(nbt);
/* 146 */     nbt.func_74757_a("wasRoped", this.wasRoped);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAnimalTypeID() {
/* 152 */     return Helper.stringToInt("pheasant");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean trySetName(String name, EntityPlayer player) {
/* 157 */     if (checkFamiliarity(IAnimal.InteractionEnum.NAME, player)) {
/*     */       
/* 159 */       func_94058_c(name);
/* 160 */       return true;
/*     */     } 
/* 162 */     func_85030_a("terrafirmacraft:mob.pheasant.say", 6.0F, this.field_70146_Z.nextFloat() / 2.0F + (func_70631_g_() ? 1.25F : 0.75F));
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkFamiliarity(IAnimal.InteractionEnum interaction, EntityPlayer player) {
/* 168 */     boolean flag = false;
/* 169 */     switch (interaction) {
/*     */       case NAME:
/* 171 */         flag = (getFamiliarity() > 40);
/*     */         break;
/*     */     } 
/*     */     
/* 175 */     if (!flag && !player.field_70170_p.field_72995_K) {
/* 176 */       TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("entity.notFamiliar", new Object[0]));
/*     */     }
/* 178 */     return flag;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityPheasantTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */