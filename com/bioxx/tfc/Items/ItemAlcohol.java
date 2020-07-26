/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemAlcohol
/*     */   extends ItemTerra
/*     */ {
/*     */   public ItemAlcohol() {
/*  30 */     setFolder("food/");
/*  31 */     func_77642_a(TFCItems.glassBottle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/*  37 */     return EnumAction.drink;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  43 */     par3EntityPlayer.func_71008_a(par1ItemStack, func_77626_a(par1ItemStack));
/*  44 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/*  50 */     return 32;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  57 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:Glass Bottle Overlay");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  64 */     return (pass == 1) ? this.field_77791_bV : func_77668_q().getIcon(stack, pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack is, int pass) {
/*  71 */     return (pass == 1) ? FluidContainerRegistry.getFluidForFilledItem(is).getFluid().getColor() : super.func_82790_a(is, pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/*  85 */     if (!player.field_71075_bZ.field_75098_d)
/*     */     {
/*  87 */       is.field_77994_a--;
/*     */     }
/*     */     
/*  90 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/*  93 */       Random rand = new Random();
/*  94 */       FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(player);
/*  95 */       fs.restoreWater(player, 800);
/*  96 */       int time = 400 + rand.nextInt(1000);
/*  97 */       fs.consumeAlcohol();
/*  98 */       if (rand.nextInt(100) == 0) {
/*  99 */         player.func_70690_d(new PotionEffect(8, time, 4));
/*     */       }
/* 101 */       if (rand.nextInt(100) == 0) {
/* 102 */         player.func_70690_d(new PotionEffect(5, time, 4));
/*     */       }
/* 104 */       if (rand.nextInt(100) == 0) {
/* 105 */         player.func_70690_d(new PotionEffect(8, time, 4));
/*     */       }
/* 107 */       if (rand.nextInt(200) == 0) {
/* 108 */         player.func_70690_d(new PotionEffect(10, time, 4));
/*     */       }
/* 110 */       if (rand.nextInt(150) == 0) {
/* 111 */         player.func_70690_d(new PotionEffect(12, time, 4));
/*     */       }
/* 113 */       if (rand.nextInt(180) == 0) {
/* 114 */         player.func_70690_d(new PotionEffect(13, time, 4));
/*     */       }
/* 116 */       int levelMod = 250 * player.field_71068_ca;
/* 117 */       if (fs.soberTime > TFC_Time.getTotalTicks() + 3000L + levelMod)
/*     */       {
/*     */ 
/*     */         
/* 121 */         if (fs.soberTime > TFC_Time.getTotalTicks() + 5000L + levelMod) {
/* 122 */           if (rand.nextInt(4) == 0) {
/* 123 */             player.func_70690_d(new PotionEffect(18, time, 4));
/*     */           }
/* 125 */           if (fs.soberTime > TFC_Time.getTotalTicks() + 7000L + levelMod) {
/* 126 */             if (rand.nextInt(2) == 0) {
/* 127 */               player.func_70690_d(new PotionEffect(15, time, 4));
/*     */             }
/* 129 */             if (fs.soberTime > TFC_Time.getTotalTicks() + 8000L + levelMod && 
/* 130 */               rand.nextInt(10) == 0) {
/* 131 */               player.func_70690_d(new PotionEffect(20, time, 4));
/*     */             }
/*     */             
/* 134 */             if (fs.soberTime > TFC_Time.getTotalTicks() + 10000L + levelMod && !player.field_71075_bZ.field_75098_d) {
/* 135 */               fs.soberTime = 0L;
/*     */               
/* 137 */               player.func_70097_a((new DamageSource("alcohol")).func_76348_h().func_151518_m(), player.func_110138_aP());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 143 */       TFC_Core.setPlayerFoodStats(player, fs);
/*     */     } 
/*     */ 
/*     */     
/* 147 */     if (!player.field_71075_bZ.field_75098_d && !player.field_71071_by.func_70441_a(new ItemStack(TFCItems.glassBottle))) {
/*     */ 
/*     */       
/* 150 */       if (is.field_77994_a == 0) {
/* 151 */         return new ItemStack(TFCItems.glassBottle);
/*     */       }
/*     */       
/* 154 */       player.func_71019_a(new ItemStack(TFCItems.glassBottle), false);
/*     */     } 
/*     */     
/* 157 */     return is;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemAlcohol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */