/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.InventoryPlayerTFC;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Entities.EntityProjectileTFC;
/*     */ import com.bioxx.tfc.Items.ItemQuiver;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumAmmo;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ 
/*     */ public class ItemCustomBow
/*     */   extends ItemBow
/*     */   implements ISize
/*     */ {
/*  36 */   private String[] bowPullIconNameArray = new String[] { "pulling_0", "pulling_1", "pulling_2", "pulling_3" };
/*     */   
/*     */   private IIcon[] iconArray;
/*     */ 
/*     */   
/*     */   public ItemCustomBow() {
/*  42 */     this.field_77777_bU = 1;
/*  43 */     func_77656_e(384);
/*  44 */     func_77637_a(TFCTabs.TFC_WEAPONS);
/*  45 */     setNoRepair();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consumeArrowInQuiver(EntityPlayer player, boolean shouldConsume) {
/*  50 */     ItemStack quiver = ((InventoryPlayerTFC)player.field_71071_by).extraEquipInventory[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     if (quiver != null && quiver.func_77973_b() instanceof ItemQuiver && (
/*  62 */       (ItemQuiver)quiver.func_77973_b()).consumeAmmo(quiver, EnumAmmo.ARROW, shouldConsume) != null) {
/*  63 */       return true;
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  71 */     ArrowNockEvent event = new ArrowNockEvent(player, is);
/*  72 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  73 */     if (event.isCanceled()) {
/*  74 */       return event.result;
/*     */     }
/*  76 */     if (player.field_71075_bZ.field_75098_d || player.field_71071_by.func_146028_b(TFCItems.arrow) || consumeArrowInQuiver(player, false)) {
/*  77 */       player.func_71008_a(is, func_77626_a(is));
/*     */     }
/*  79 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack is, World world, EntityPlayer player, int inUseCount) {
/*  85 */     int j = func_77626_a(is) - inUseCount;
/*     */     
/*  87 */     ArrowLooseEvent event = new ArrowLooseEvent(player, is, j);
/*  88 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  89 */     if (event.isCanceled())
/*     */       return; 
/*  91 */     j = event.charge;
/*     */     
/*  93 */     boolean flag = (player.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, is) > 0);
/*     */ 
/*     */     
/*  96 */     boolean hasAmmo = (flag || player.field_71071_by.func_146028_b(TFCItems.arrow));
/*  97 */     boolean hasAmmoInQuiver = false;
/*     */     
/*  99 */     if (!hasAmmo) {
/* 100 */       hasAmmoInQuiver = consumeArrowInQuiver(player, false);
/*     */     }
/* 102 */     if (hasAmmo || hasAmmoInQuiver) {
/*     */       
/* 104 */       float forceMult = j / getUseSpeed(player);
/*     */ 
/*     */       
/* 107 */       if (forceMult < 0.25D) {
/*     */         return;
/*     */       }
/* 110 */       if (forceMult > 1.25F) {
/* 111 */         forceMult = 1.25F;
/*     */       }
/* 113 */       EntityProjectileTFC entityarrow = new EntityProjectileTFC(world, (EntityLivingBase)player, forceMult * 2.0F);
/* 114 */       entityarrow.func_70239_b(forceMult * 150.0D);
/* 115 */       if (forceMult == 1.25F) {
/* 116 */         entityarrow.func_70243_d(true);
/*     */       }
/* 118 */       int k = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, is);
/*     */       
/* 120 */       if (k > 0) {
/* 121 */         entityarrow.func_70239_b(entityarrow.func_70242_d() + k * 0.5D + 0.5D);
/*     */       }
/* 123 */       int l = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, is);
/*     */       
/* 125 */       if (l > 0) {
/* 126 */         entityarrow.func_70240_a(l);
/*     */       }
/* 128 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, is) > 0) {
/* 129 */         entityarrow.func_70015_d(100);
/*     */       }
/* 131 */       is.func_77972_a(1, (EntityLivingBase)player);
/* 132 */       world.func_72956_a((Entity)player, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + forceMult * 0.5F);
/*     */       
/* 134 */       if (flag) {
/* 135 */         entityarrow.field_70251_a = 2;
/* 136 */       } else if (hasAmmo) {
/* 137 */         player.field_71071_by.func_146026_a(TFCItems.arrow);
/* 138 */       } else if (hasAmmoInQuiver) {
/* 139 */         consumeArrowInQuiver(player, true);
/*     */       } 
/* 141 */       if (!world.field_72995_K) {
/* 142 */         world.func_72838_d((Entity)entityarrow);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static float getUseSpeed(EntityPlayer player) {
/* 148 */     float speed = 60.0F;
/* 149 */     ItemStack[] armor = player.field_71071_by.field_70460_b;
/* 150 */     if (armor[0] != null && armor[0].func_77973_b() instanceof ISize)
/* 151 */       speed += 20.0F / (((ISize)armor[0].func_77973_b()).getWeight(armor[0])).multiplier; 
/* 152 */     if (armor[1] != null && armor[1].func_77973_b() instanceof ISize)
/* 153 */       speed += 20.0F / (((ISize)armor[1].func_77973_b()).getWeight(armor[1])).multiplier; 
/* 154 */     if (armor[2] != null && armor[2].func_77973_b() instanceof ISize)
/* 155 */       speed += 20.0F / (((ISize)armor[2].func_77973_b()).getWeight(armor[2])).multiplier; 
/* 156 */     if (armor[3] != null && armor[3].func_77973_b() instanceof ISize) {
/* 157 */       speed += 20.0F / (((ISize)armor[3].func_77973_b()).getWeight(armor[3])).multiplier;
/*     */     }
/* 159 */     return speed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
/* 165 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 171 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 177 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 190 */     this.field_77791_bV = par1IconRegister.func_94245_a("terrafirmacraft:" + func_111208_A() + "_standby");
/* 191 */     this.iconArray = new IIcon[this.bowPullIconNameArray.length];
/*     */     
/* 193 */     for (int i = 0; i < this.iconArray.length; i++) {
/* 194 */       this.iconArray[i] = par1IconRegister.func_94245_a("terrafirmacraft:" + func_111208_A() + "_" + this.bowPullIconNameArray[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_94599_c(int par1) {
/* 202 */     return this.iconArray[par1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
/* 208 */     if (usingItem != null && usingItem.func_77973_b() == this) {
/*     */       
/* 210 */       int j = usingItem.func_77988_m() - useRemaining;
/* 211 */       float force = j / getUseSpeed(player);
/*     */       
/* 213 */       if (force >= 1.25D)
/*     */       {
/* 215 */         return func_94599_c(3);
/*     */       }
/* 217 */       if (force > 0.75D)
/*     */       {
/* 219 */         return func_94599_c(2);
/*     */       }
/* 221 */       if (force > 0.25D)
/*     */       {
/* 223 */         return func_94599_c(1);
/*     */       }
/* 225 */       if (force > 0.0F)
/*     */       {
/* 227 */         return func_94599_c(0);
/*     */       }
/*     */     } 
/* 230 */     return getIcon(stack, renderPass);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 235 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomBow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */