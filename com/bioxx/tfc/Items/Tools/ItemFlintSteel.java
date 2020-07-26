/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEPottery;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemFlintAndSteel;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemFlintSteel
/*     */   extends ItemFlintAndSteel
/*     */   implements ISize
/*     */ {
/*     */   public ItemFlintSteel() {
/*  32 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  38 */     if (!world.field_72995_K) {
/*     */       
/*  40 */       Block block = world.func_147439_a(x, y, z);
/*  41 */       boolean surroundSolids = TFC_Core.isSurroundedSolid(world, x, y, z);
/*     */       
/*  43 */       if ((block == TFCBlocks.charcoal && world.func_72805_g(x, y, z) > 6) || block == Blocks.field_150402_ci) {
/*     */ 
/*     */         
/*  46 */         if (TFC_Core.isSurroundedStone(world, x, y, z) && surroundSolids) {
/*     */           
/*  48 */           triggerUse(itemstack, entityplayer, world, x, y, z);
/*  49 */           world.func_147465_d(x, y, z, TFCBlocks.forge, 1, 2);
/*  50 */           return true;
/*     */         } 
/*     */       } else {
/*     */         
/*  54 */         if (block == TFCBlocks.pottery && surroundSolids) {
/*     */           
/*  56 */           TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/*  57 */           te.startPitFire();
/*  58 */           triggerUse(itemstack, entityplayer, world, x, y, z);
/*  59 */           return true;
/*     */         } 
/*     */         
/*  62 */         if (side == 1 && TFC_Core.isTopFaceSolid(world, x, y, z) && world.func_147437_c(x, y + 1, z) && block
/*  63 */           .func_149688_o() != Material.field_151575_d && block.func_149688_o() != Material.field_151580_n) {
/*     */           
/*  65 */           List list = world.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(x, (y + 1), z, (x + 1), (y + 2), (z + 1)));
/*  66 */           int numsticks = 0;
/*     */           
/*  68 */           if (list != null && !list.isEmpty()) {
/*     */             
/*  70 */             for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */               
/*  72 */               EntityItem entity = iterator.next();
/*  73 */               if (entity.func_92059_d().func_77973_b() == TFCItems.stick) {
/*  74 */                 numsticks += (entity.func_92059_d()).field_77994_a;
/*     */               }
/*     */             } 
/*  77 */             if (numsticks >= 3) {
/*     */               
/*  79 */               for (Iterator<EntityItem> iterator1 = list.iterator(); iterator1.hasNext(); ) {
/*     */                 
/*  81 */                 EntityItem entity = iterator1.next();
/*  82 */                 if (entity.func_92059_d().func_77973_b() == TFCItems.stick || entity.func_92059_d().func_77973_b() == TFCItems.straw)
/*  83 */                   entity.func_70106_y(); 
/*     */               } 
/*  85 */               triggerUse(itemstack, entityplayer, world, x, y, z);
/*  86 */               world.func_147465_d(x, y + 1, z, TFCBlocks.firepit, 1, 2);
/*  87 */               if (world.field_72995_K)
/*  88 */                 world.func_147471_g(x, y + 1, z); 
/*  89 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  95 */       if (!block.func_149727_a(world, x, y, z, entityplayer, side, hitX, hitY, hitZ))
/*     */       {
/*  97 */         return super.func_77648_a(itemstack, entityplayer, world, x, y, z, side, hitX, hitY, hitZ);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void triggerUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z) {
/* 106 */     world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, field_77697_d.nextFloat() * 0.4F + 0.8F);
/* 107 */     is.func_77972_a(1, (EntityLivingBase)player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 114 */     return EnumSize.VERYSMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 120 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 132 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
/* 138 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemFlintSteel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */