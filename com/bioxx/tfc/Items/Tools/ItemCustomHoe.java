/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.UseHoeEvent;
/*     */ 
/*     */ 
/*     */ public class ItemCustomHoe
/*     */   extends ItemHoe
/*     */   implements ISize
/*     */ {
/*     */   public ItemCustomHoe(Item.ToolMaterial e) {
/*  37 */     super(e);
/*  38 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  39 */     setNoRepair();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  45 */     String name = func_77658_a().replace("item.", "");
/*  46 */     name = name.replace("IgIn ", "");
/*  47 */     name = name.replace("IgEx ", "");
/*  48 */     name = name.replace("Sed ", "");
/*  49 */     name = name.replace("MM ", "");
/*  50 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  56 */     NBTTagCompound nbt = stack.func_77978_p();
/*  57 */     if (pass == 1 && nbt != null && nbt.func_74764_b("broken")) {
/*  58 */       return TFC_Textures.brokenItem;
/*     */     }
/*  60 */     return func_77618_c(stack.func_77960_j(), pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  66 */     if (world.field_72995_K || world.func_147439_a(x, y, z) == TFCBlocks.toolRack) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
/*  71 */     if (MinecraftForge.EVENT_BUS.post((Event)event)) {
/*  72 */       return false;
/*     */     }
/*  74 */     if (event.getResult() == Event.Result.ALLOW) {
/*     */       
/*  76 */       stack.func_77972_a(1, (EntityLivingBase)player);
/*  77 */       return true;
/*     */     } 
/*     */     
/*  80 */     Block var8 = world.func_147439_a(x, y, z);
/*  81 */     Block var9 = world.func_147439_a(x, y + 1, z);
/*     */     
/*  83 */     boolean isDirt = TFC_Core.isDirt(var8);
/*     */     
/*  85 */     if (side != 1 || !var9.isAir((IBlockAccess)world, x, y + 1, z) || (!TFC_Core.isGrass(var8) && !isDirt)) {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     Block var10 = (var8 == TFCBlocks.dirt || var8 == TFCBlocks.grass || var8 == TFCBlocks.dryGrass) ? TFCBlocks.dirt : ((var8 == TFCBlocks.dirt2 || var8 == TFCBlocks.grass2 || var8 == TFCBlocks.dryGrass2) ? TFCBlocks.dirt2 : null);
/*     */     
/*  91 */     if (var10 != null) {
/*     */       
/*  93 */       int meta = world.func_72805_g(x, y, z);
/*  94 */       if (var10 == TFCBlocks.dirt) {
/*     */         
/*  96 */         world.func_72908_a((x + 0.5F), (y + 0.5F), (z + 0.5F), var10.field_149762_H.func_150498_e(), (var10.field_149762_H.func_150497_c() + 1.0F) / 2.0F, var10.field_149762_H.func_150494_d() * 0.8F);
/*     */         
/*  98 */         if (world.field_72995_K) {
/*  99 */           return true;
/*     */         }
/*     */         
/* 102 */         world.func_147465_d(x, y, z, TFCBlocks.tilledSoil, meta, 2);
/* 103 */         world.func_147471_g(x, y, z);
/* 104 */         stack.func_77972_a(1, (EntityLivingBase)player);
/*     */         
/* 106 */         if (isDirt) {
/*     */           
/* 108 */           TEFarmland te = (TEFarmland)world.func_147438_o(x, y, z);
/* 109 */           te.nutrients[0] = 100;
/* 110 */           te.nutrients[1] = 100;
/* 111 */           te.nutrients[2] = 100;
/*     */         } 
/* 113 */         return true;
/*     */       } 
/*     */       
/* 116 */       if (var10 == TFCBlocks.dirt2) {
/*     */         
/* 118 */         world.func_72908_a((x + 0.5F), (y + 0.5F), (z + 0.5F), var10.field_149762_H.func_150498_e(), (var10.field_149762_H.func_150497_c() + 1.0F) / 2.0F, var10.field_149762_H.func_150494_d() * 0.8F);
/*     */         
/* 120 */         if (world.field_72995_K) {
/* 121 */           return true;
/*     */         }
/*     */         
/* 124 */         world.func_147465_d(x, y, z, TFCBlocks.tilledSoil2, meta, 2);
/* 125 */         world.func_147471_g(x, y, z);
/* 126 */         stack.func_77972_a(1, (EntityLivingBase)player);
/*     */         
/* 128 */         if (isDirt) {
/*     */           
/* 130 */           TEFarmland te = (TEFarmland)world.func_147438_o(x, y, z);
/* 131 */           te.nutrients[0] = 100;
/* 132 */           te.nutrients[1] = 100;
/* 133 */           te.nutrients[2] = 100;
/*     */         } 
/* 135 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 147 */     ItemTerra.addSizeInformation(is, arraylist);
/* 148 */     ItemTerraTool.addSmithingBonusInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/* 154 */     if (canStack()) {
/* 155 */       return (getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier;
/*     */     }
/* 157 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 163 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 175 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack stack) {
/* 181 */     return (int)(func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(stack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/* 187 */     float digSpeed = super.getDigSpeed(stack, block, meta);
/*     */     
/* 189 */     if (ForgeHooks.isToolEffective(stack, block, meta))
/*     */     {
/* 191 */       return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */     }
/* 193 */     return digSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 199 */     return EnumItemReach.FAR;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */