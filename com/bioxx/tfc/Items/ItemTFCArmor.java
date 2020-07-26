/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.Tools.ItemTerraTool;
/*     */ import com.bioxx.tfc.api.Armor;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.IClothing;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemTFCArmor
/*     */   extends ItemArmor implements ISize, IClothing {
/*  33 */   private static final String[] LEATHER_NAMES = new String[] { "leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay" };
/*     */   
/*     */   public Armor armorTypeTFC;
/*     */   
/*     */   public IIcon field_94605_cw;
/*     */   private int thermal;
/*     */   private int trueType;
/*     */   
/*     */   public ItemTFCArmor(Armor armor, int renderIndex, int armorSlot, int thermal, int type) {
/*  42 */     super(ItemArmor.ArmorMaterial.IRON, renderIndex, armorSlot % 4);
/*  43 */     this.armorTypeTFC = armor;
/*  44 */     this.trueType = armorSlot;
/*  45 */     func_77637_a(TFCTabs.TFC_ARMOR);
/*  46 */     func_77656_e(this.armorTypeTFC.getDurability(armorSlot));
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemTFCArmor(Armor armor, int renderIndex, int armorSlot, ItemArmor.ArmorMaterial m, int thermal, int type) {
/*  51 */     super(m, renderIndex, armorSlot % 4);
/*  52 */     this.armorTypeTFC = armor;
/*  53 */     this.trueType = armorSlot;
/*  54 */     func_77637_a(TFCTabs.TFC_ARMOR);
/*  55 */     func_77656_e(this.armorTypeTFC.getDurability(armorSlot));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/*  61 */     if (canStack()) {
/*  62 */       return (getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier;
/*     */     }
/*  64 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int par1, int par2) {
/*  75 */     return (par2 == 1) ? this.field_94605_cw : super.func_77618_c(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  81 */     if (func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
/*     */       
/*  83 */       this.field_77791_bV = registerer.func_94245_a("minecraft:" + func_111208_A());
/*  84 */       this.field_94605_cw = registerer.func_94245_a("minecraft:" + LEATHER_NAMES[this.field_77881_a]);
/*     */     } else {
/*     */       
/*  87 */       this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:armor/" + func_77658_a().replace("item.", ""));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  93 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 102 */     int i = EntityLiving.func_82159_b(par1ItemStack);
/* 103 */     ItemStack itemstack1 = par3EntityPlayer.func_82169_q((i - 1) % 4);
/*     */     
/* 105 */     if (itemstack1 == null) {
/*     */       
/* 107 */       par3EntityPlayer.func_70062_b(i, par1ItemStack.func_77946_l());
/* 108 */       par1ItemStack.field_77994_a = 0;
/*     */     } 
/*     */     
/* 111 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 123 */     ItemTerra.addSizeInformation(is, arraylist);
/* 124 */     ItemTerra.addHeatInformation(is, arraylist);
/* 125 */     ItemTerraTool.addSmithingBonusInformation(is, arraylist);
/*     */     
/* 127 */     if (TFC_Core.showShiftInformation()) {
/*     */       
/* 129 */       arraylist.add(EnumChatFormatting.WHITE + TFC_Core.translate("gui.Advanced") + ":");
/* 130 */       arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Armor.Pierce") + ": " + EnumChatFormatting.AQUA + this.armorTypeTFC.getPiercingAR());
/* 131 */       arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Armor.Slash") + ": " + EnumChatFormatting.AQUA + this.armorTypeTFC.getSlashingAR());
/* 132 */       arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Armor.Crush") + ": " + EnumChatFormatting.AQUA + this.armorTypeTFC.getCrushingAR());
/* 133 */       arraylist.add("");
/* 134 */       if (is.func_77942_o()) {
/*     */         
/* 136 */         NBTTagCompound stackTagCompound = is.func_77978_p();
/*     */         
/* 138 */         if (stackTagCompound.func_74764_b("creator")) {
/* 139 */           arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Armor.ForgedBy") + " " + stackTagCompound.func_74779_i("creator"));
/*     */         }
/*     */       } 
/*     */     } else {
/* 143 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.Advanced") + ": (" + TFC_Core.translate("gui.Hold") + " " + EnumChatFormatting.GRAY + TFC_Core.translate("gui.Shift") + EnumChatFormatting.DARK_GRAY + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MovingObjectPosition func_77621_a(World par1World, EntityPlayer par2EntityPlayer, boolean par3) {
/* 153 */     float f = 1.0F;
/* 154 */     float f1 = par2EntityPlayer.field_70127_C + (par2EntityPlayer.field_70125_A - par2EntityPlayer.field_70127_C) * f;
/* 155 */     float f2 = par2EntityPlayer.field_70126_B + (par2EntityPlayer.field_70177_z - par2EntityPlayer.field_70126_B) * f;
/* 156 */     double d0 = par2EntityPlayer.field_70169_q + (par2EntityPlayer.field_70165_t - par2EntityPlayer.field_70169_q) * f;
/* 157 */     double d1 = par2EntityPlayer.field_70167_r + (par2EntityPlayer.field_70163_u - par2EntityPlayer.field_70167_r) * f + (par1World.field_72995_K ? (par2EntityPlayer.func_70047_e() - par2EntityPlayer.getDefaultEyeHeight()) : par2EntityPlayer.func_70047_e());
/* 158 */     double d2 = par2EntityPlayer.field_70166_s + (par2EntityPlayer.field_70161_v - par2EntityPlayer.field_70166_s) * f;
/* 159 */     Vec3 vec3 = Vec3.func_72443_a(d0, d1, d2);
/* 160 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/* 161 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/* 162 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 163 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/* 164 */     float f7 = f4 * f5;
/* 165 */     float f8 = f3 * f5;
/* 166 */     double d3 = 5.0D;
/* 167 */     if (par2EntityPlayer instanceof EntityPlayerMP)
/*     */     {
/* 169 */       d3 = ((EntityPlayerMP)par2EntityPlayer).field_71134_c.getBlockReachDistance();
/*     */     }
/* 171 */     d3 *= (getReach((ItemStack)null)).multiplier;
/* 172 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/* 173 */     return par1World.func_72901_a(vec3, vec31, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack stack) {
/* 179 */     return (int)(super.getMaxDamage(stack) + super.getMaxDamage(stack) * AnvilManager.getDurabilityBuff(stack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 185 */     if (func_82812_d() == ItemArmor.ArmorMaterial.CLOTH)
/* 186 */       return EnumWeight.LIGHT; 
/* 187 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 193 */     String m = this.armorTypeTFC.metaltype.replace(" ", "").toLowerCase();
/* 194 */     return "terrafirmacraft" + String.format(":textures/models/armor/%s_%d%s.png", new Object[] { m, 
/* 195 */           Integer.valueOf((slot == 2) ? 2 : 1), (type == null) ? "" : String.format("_%s", new Object[] { type }) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThermal() {
/* 201 */     return this.thermal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUnadjustedArmorType() {
/* 207 */     return this.trueType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBodyPart() {
/* 213 */     return 3 - this.field_77881_a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 219 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemTFCArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */