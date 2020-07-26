/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemTerraTool
/*     */   extends ItemTool
/*     */   implements ISize
/*     */ {
/*     */   public ItemTerraTool(float par2, Item.ToolMaterial par3, Set<Block> par4) {
/*  36 */     super(par2, par3, par4);
/*  37 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  38 */     setNoRepair();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  46 */     ItemTerra.addSizeInformation(is, arraylist);
/*  47 */     ItemTerra.addHeatInformation(is, arraylist);
/*     */     
/*  49 */     if (is.func_77973_b() instanceof ICausesDamage) {
/*  50 */       arraylist.add(EnumChatFormatting.AQUA + TFC_Core.translate(((ICausesDamage)this).getDamageType().toString()));
/*     */     }
/*  52 */     addSmithingBonusInformation(is, arraylist);
/*  53 */     addExtraInformation(is, player, arraylist);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSmithingBonusInformation(ItemStack is, List<String> arraylist) {
/*  58 */     if (AnvilManager.getDurabilityBuff(is) > 0.0F) {
/*  59 */       arraylist.add(TFC_Core.translate("gui.SmithingBonus") + " : +" + Helper.roundNumber(AnvilManager.getDurabilityBuff(is) * 100.0F, 10.0F) + "%");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {}
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/*  69 */     if (canStack()) {
/*  70 */       return (getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier;
/*     */     }
/*  72 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  78 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + func_77658_a().replace("item.", ""));
/*  79 */     if (TFC_Textures.brokenItem == null) TFC_Textures.brokenItem = registerer.func_94245_a("terrafirmacraft:tools/Broken Item"); 
/*  80 */     if (TFC_Textures.wip == null) TFC_Textures.wip = registerer.func_94245_a("terrafirmacraft:wip");
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77630_h(ItemStack itemStack) {
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getContainerItem(ItemStack itemStack) {
/*  98 */     ItemStack container = itemStack.func_77946_l();
/*  99 */     container.func_77964_b(container.func_77960_j() + 1);
/* 100 */     container.field_77994_a = 1;
/* 101 */     return container;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasContainerItem(ItemStack stack) {
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepairable() {
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 119 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 125 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 137 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack stack) {
/* 143 */     return (int)(func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(stack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/* 149 */     float digSpeed = super.getDigSpeed(stack, block, meta);
/*     */     
/* 151 */     if (ForgeHooks.isToolEffective(stack, block, meta))
/*     */     {
/* 153 */       return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */     }
/* 155 */     return digSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77623_v() {
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/* 167 */     NBTTagCompound nbt = stack.func_77978_p();
/* 168 */     if (pass == 1 && nbt != null && nbt.func_74764_b("broken")) {
/* 169 */       return TFC_Textures.brokenItem;
/*     */     }
/* 171 */     return func_77618_c(stack.func_77960_j(), pass);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemTerraTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */