/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Entities.EntityFishHookTFC;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemFishingRod;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomFishingRod
/*     */   extends ItemFishingRod
/*     */   implements ISize
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] uncastIconArray;
/*     */   private IIcon[] castIconArray;
/*     */   
/*     */   public ItemCustomFishingRod() {
/*  37 */     func_77656_e(64);
/*  38 */     func_77625_d(1);
/*  39 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  40 */     setNoRepair();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d() {
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77629_n_() {
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack is) {
/*  69 */     if (is.field_77990_d != null && is.field_77990_d.func_74764_b("swing") && is.field_77990_d.func_74767_n("swing")) {
/*  70 */       is.field_77990_d.func_74757_a("swing", false);
/*  71 */       return false;
/*     */     } 
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  82 */     if (is.field_77990_d != null && is.field_77990_d.func_74764_b("tickReeledIn")) {
/*     */       
/*  84 */       long tickReeledIn = is.field_77990_d.func_74763_f("tickReeledIn");
/*  85 */       if (TFC_Time.getTotalTicks() <= tickReeledIn + 20L) {
/*  86 */         return is;
/*     */       }
/*     */     } 
/*  89 */     if (player.field_71104_cf != null) {
/*     */ 
/*     */ 
/*     */       
/*  93 */       if (player.field_71104_cf instanceof EntityFishHookTFC)
/*     */       {
/*  95 */         ((EntityFishHookTFC)player.field_71104_cf).reelInBobber((Entity)player, is);
/*     */       }
/*     */       else
/*     */       {
/*  99 */         player.func_71008_a(is, 1);
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 105 */       if (is.field_77990_d == null) {
/* 106 */         is.func_77982_d(new NBTTagCompound());
/*     */       }
/* 108 */       player.func_71008_a(is, func_77626_a(is));
/*     */     } 
/*     */     
/* 111 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 117 */     if (player.field_71104_cf instanceof EntityFishHookTFC)
/*     */     {
/* 119 */       ((EntityFishHookTFC)player.field_71104_cf).reelInBobber((Entity)player, is);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack is, World world, EntityPlayer player, int inUseCount) {
/* 132 */     if (player.field_71104_cf == null && is.field_77990_d != null) {
/* 133 */       world.func_72956_a((Entity)player, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 134 */       if (!world.field_72995_K) {
/* 135 */         world.func_72838_d((Entity)new EntityFishHookTFC(world, player, is.func_77988_m() - inUseCount));
/*     */         
/* 137 */         is.field_77990_d.func_74757_a("fishing", true);
/*     */       } 
/*     */       
/* 140 */       is.field_77990_d.func_74757_a("swing", true);
/* 141 */       player.func_71038_i();
/* 142 */       is.field_77990_d.func_74757_a("fishing", true);
/* 143 */       is.field_77990_d.func_74768_a("usedUses", 0);
/*     */     }
/* 145 */     else if (is.field_77990_d != null) {
/* 146 */       is.field_77990_d.func_74757_a("fishing", true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack is) {
/* 156 */     return 72000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 164 */     this.uncastIconArray = new IIcon[3];
/* 165 */     this.castIconArray = new IIcon[8]; int i;
/* 166 */     for (i = 0; i < this.castIconArray.length; i++)
/* 167 */       this.castIconArray[i] = par1IconRegister.func_94245_a("terrafirmacraft:" + func_111208_A() + "_cast_" + i); 
/* 168 */     for (i = 0; i < this.uncastIconArray.length; i++)
/* 169 */       this.uncastIconArray[i] = par1IconRegister.func_94245_a("terrafirmacraft:" + func_111208_A() + "_uncast_" + i); 
/* 170 */     this.field_77791_bV = this.uncastIconArray[0];
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getItemIconForUseDuration(int par1, boolean cast) {
/* 176 */     par1 = Math.min(Math.max(par1, 0), 7);
/* 177 */     if (cast)
/* 178 */       return this.castIconArray[par1]; 
/* 179 */     return this.uncastIconArray[par1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack is, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
/* 185 */     boolean cast = (player.field_71104_cf != null);
/*     */     
/* 187 */     if (!is.func_77942_o()) {
/* 188 */       is.func_77982_d(new NBTTagCompound());
/*     */     }
/* 190 */     is.field_77990_d.func_74757_a("fishing", cast);
/* 191 */     if (usingItem == null) {
/* 192 */       useRemaining = func_77626_a(is);
/*     */     }
/*     */     
/* 195 */     if (!cast) {
/* 196 */       int j = Math.max(Math.min(func_77626_a(is) - useRemaining + 10, 60) / 20 - 1, 0);
/* 197 */       if (!is.func_77942_o()) {
/* 198 */         is.func_77982_d(new NBTTagCompound());
/*     */       }
/* 200 */       is.field_77990_d.func_74768_a("usedUses", func_77626_a(is) - useRemaining);
/* 201 */       return getItemIconForUseDuration(Math.min(j, this.uncastIconArray.length - 1), cast);
/*     */     } 
/*     */     
/* 204 */     int tension = 0;
/* 205 */     if (is.func_77942_o() && is.field_77990_d.func_74764_b("tension")) {
/* 206 */       tension = is.field_77990_d.func_74762_e("tension");
/*     */     }
/* 208 */     int originalTex = tension / 100;
/* 209 */     int texShift = (tension % 100 + 1) % 31;
/* 210 */     return getItemIconForUseDuration(Math.min(originalTex + ((texShift == 10) ? 1 : 0), this.castIconArray.length - 1), cast);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack is, int renderPass) {
/* 217 */     if (is.func_77942_o() && is.field_77990_d.func_74764_b("fishing") && is.field_77990_d.func_74767_n("fishing")) {
/* 218 */       return this.castIconArray[0];
/*     */     }
/* 220 */     return this.uncastIconArray[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
/* 226 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 232 */     return EnumSize.TINY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 238 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack is) {
/* 247 */     if (is.field_77990_d != null && is.field_77990_d.func_74764_b("fishing") && is.field_77990_d.func_74767_n("fishing"))
/*     */     {
/* 249 */       return EnumAction.bow;
/*     */     }
/* 251 */     return EnumAction.none;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 257 */     return EnumItemReach.FAR;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 263 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomFishingRod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */