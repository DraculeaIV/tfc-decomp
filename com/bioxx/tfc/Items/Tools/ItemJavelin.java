/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Entities.EntityJavelin;
/*     */ import com.bioxx.tfc.Items.ItemQuiver;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumAmmo;
/*     */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.IProjectile;
/*     */ import com.bioxx.tfc.api.Interfaces.IQuiverAmmo;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemJavelin
/*     */   extends ItemTerraTool
/*     */   implements ICausesDamage, IProjectile, IQuiverAmmo
/*     */ {
/*     */   public float weaponDamage;
/*     */   private float weaponRangeDamage;
/*     */   
/*     */   public ItemJavelin(Item.ToolMaterial par2EnumToolMaterial, float damage) {
/*  42 */     super(10.0F, par2EnumToolMaterial, Sets.newHashSet((Object[])new Block[] { Blocks.field_150350_a }));
/*  43 */     this.field_77777_bU = 1;
/*  44 */     this.weaponDamage = damage;
/*  45 */     this.weaponRangeDamage = damage;
/*  46 */     func_77656_e(par2EnumToolMaterial.func_77997_a() / 2);
/*  47 */     func_77637_a(TFCTabs.TFC_WEAPONS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  53 */     list.add(new ItemStack((Item)this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  59 */     String name = func_77658_a().replace("item.", "");
/*  60 */     name = name.replace("IgIn ", "");
/*  61 */     name = name.replace("IgEx ", "");
/*  62 */     name = name.replace("Sed ", "");
/*  63 */     name = name.replace("MM ", "");
/*  64 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77619_b() {
/*  73 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/*  82 */     return EnumAction.bow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/*  91 */     return 72000;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  97 */     Block b = world.func_147439_a(x, y, z);
/*  98 */     return (b == TFCBlocks.toolRack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 107 */     par3EntityPlayer.func_71008_a(par1ItemStack, func_77626_a(par1ItemStack));
/* 108 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack itemstack, World world, EntityPlayer player, int itemInUseCount) {
/* 117 */     if (!world.field_72995_K) {
/*     */       
/* 119 */       int var6 = func_77626_a(itemstack) - itemInUseCount;
/* 120 */       float force = Math.min(var6 / 20.0F, 1.0F);
/*     */       
/* 122 */       EntityJavelin javelin = new EntityJavelin(world, (EntityLivingBase)player, 1.5F * force);
/* 123 */       javelin.func_70239_b(getRangedDamage(itemstack));
/* 124 */       javelin.duraBuff = AnvilManager.getDurabilityBuff(itemstack);
/* 125 */       javelin.damageBuff = AnvilManager.getDamageBuff(itemstack);
/*     */       
/* 127 */       int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, itemstack);
/*     */       
/* 129 */       if (var9 > 0)
/*     */       {
/* 131 */         javelin.func_70239_b(javelin.func_70242_d() + var9 * 0.5D + 0.5D);
/*     */       }
/*     */       
/* 134 */       int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, itemstack);
/*     */       
/* 136 */       if (var10 > 0)
/*     */       {
/* 138 */         javelin.func_70239_b(javelin.func_70242_d() + var10);
/*     */       }
/*     */       
/* 141 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, itemstack) > 0)
/*     */       {
/* 143 */         javelin.func_70015_d(100);
/*     */       }
/*     */       
/* 146 */       world.func_72956_a((Entity)player, "random.bow", 1.0F, 0.3F);
/* 147 */       javelin.setDamageTaken((short)itemstack.func_77960_j());
/* 148 */       javelin.setPickupItem(itemstack.func_77973_b());
/*     */       
/* 150 */       player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = null;
/*     */       
/* 152 */       if (!consumeJavelin(player))
/*     */       {
/* 154 */         player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = consumeJavelinInQuiver(player, true);
/*     */       }
/*     */       
/* 157 */       if (!world.field_72995_K)
/*     */       {
/* 159 */         world.func_72838_d((Entity)javelin);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int getInventorySlotContainJavelin(EntityPlayer player) {
/* 166 */     for (int j = 0; j < player.field_71071_by.field_70462_a.length; j++) {
/*     */       
/* 168 */       if (player.field_71071_by.field_70462_a[j] != null && player.field_71071_by.field_70462_a[j].func_77973_b() instanceof ItemJavelin)
/*     */       {
/* 170 */         return j;
/*     */       }
/*     */     } 
/*     */     
/* 174 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack consumeJavelinInQuiver(EntityPlayer player, boolean shouldConsume) {
/* 179 */     ItemStack quiver = player.field_71071_by.func_70301_a(36);
/* 180 */     if (quiver != null && quiver.func_77973_b() instanceof ItemQuiver)
/* 181 */       return ((ItemQuiver)quiver.func_77973_b()).consumeAmmo(quiver, EnumAmmo.JAVELIN, shouldConsume); 
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consumeJavelin(EntityPlayer player) {
/* 187 */     int active = player.field_71071_by.field_70461_c;
/* 188 */     int nextJav = getInventorySlotContainJavelin(player);
/*     */     
/* 190 */     if (nextJav < 0) {
/*     */       
/* 192 */       player.field_71071_by.field_70462_a[active] = null;
/* 193 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 197 */     player.field_71071_by.field_70462_a[active] = player.field_71071_by.field_70462_a[nextJav].func_77946_l();
/* 198 */     if (--(player.field_71071_by.field_70462_a[nextJav]).field_77994_a <= 0)
/*     */     {
/* 200 */       player.field_71071_by.field_70462_a[nextJav] = null;
/*     */     }
/*     */     
/* 203 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77662_d() {
/* 209 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumDamageType getDamageType() {
/* 215 */     return EnumDamageType.PIERCING;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getRangedDamage(ItemStack is) {
/* 221 */     if (is != null) {
/* 222 */       return this.weaponRangeDamage + this.weaponRangeDamage * AnvilManager.getDamageBuff(is);
/*     */     }
/* 224 */     return this.weaponRangeDamage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap getAttributeModifiers(ItemStack stack) {
/* 230 */     HashMultimap hashMultimap = HashMultimap.create();
/* 231 */     hashMultimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", getWeaponDamage(stack), 0));
/* 232 */     return (Multimap)hashMultimap;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getWeaponDamage(ItemStack is) {
/* 237 */     return Math.floor((this.weaponDamage + this.weaponDamage * AnvilManager.getDamageBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack is) {
/* 243 */     return (int)Math.floor((func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(is)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAmmo getAmmoType() {
/* 249 */     return EnumAmmo.JAVELIN;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 254 */     return EnumItemReach.FAR;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */