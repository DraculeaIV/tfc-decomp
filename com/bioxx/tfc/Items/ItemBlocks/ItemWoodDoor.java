/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemWoodDoor
/*     */   extends ItemTerra
/*     */ {
/*     */   private int woodType;
/*     */   
/*     */   public ItemWoodDoor(int woodID) {
/*  22 */     this.field_77777_bU = 1;
/*  23 */     func_77637_a(TFCTabs.TFC_DEVICES);
/*  24 */     this.woodType = woodID;
/*  25 */     setFolder("wood/");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int i, int j, int k, int side, float hitX, float hitY, float hitZ) {
/*  36 */     if (side != 1)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  42 */     j++;
/*     */ 
/*     */ 
/*     */     
/*  46 */     Block var11 = TFCBlocks.doors[this.woodType];
/*     */     
/*  48 */     if (player.func_82247_a(i, j, k, side, is) && player.func_82247_a(i, j + 1, k, side, is)) {
/*     */       
/*  50 */       if (!var11.func_149742_c(world, i, j, k))
/*     */       {
/*  52 */         return false;
/*     */       }
/*     */ 
/*     */       
/*  56 */       int var12 = MathHelper.func_76128_c(((player.field_70177_z + 180.0F) * 4.0F / 360.0F) - 0.5D) & 0x3;
/*  57 */       placeDoorBlock(world, i, j, k, var12, var11);
/*  58 */       is.field_77994_a--;
/*  59 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void placeDoorBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block) {
/*  71 */     byte var6 = 0;
/*  72 */     byte var7 = 0;
/*     */     
/*  74 */     if (par4 == 0)
/*     */     {
/*  76 */       var7 = 1;
/*     */     }
/*     */     
/*  79 */     if (par4 == 1)
/*     */     {
/*  81 */       var6 = -1;
/*     */     }
/*     */     
/*  84 */     if (par4 == 2)
/*     */     {
/*  86 */       var7 = -1;
/*     */     }
/*     */     
/*  89 */     if (par4 == 3)
/*     */     {
/*  91 */       var6 = 1;
/*     */     }
/*     */     
/*  94 */     int var8 = (par0World.func_147439_a(par1 - var6, par2, par3 - var7).func_149721_r() ? 1 : 0) + (par0World.func_147439_a(par1 - var6, par2 + 1, par3 - var7).func_149721_r() ? 1 : 0);
/*  95 */     int var9 = (par0World.func_147439_a(par1 + var6, par2, par3 + var7).func_149721_r() ? 1 : 0) + (par0World.func_147439_a(par1 + var6, par2 + 1, par3 + var7).func_149721_r() ? 1 : 0);
/*  96 */     boolean var10 = (par0World.func_147439_a(par1 - var6, par2, par3 - var7) == par5Block || par0World.func_147439_a(par1 - var6, par2 + 1, par3 - var7) == par5Block);
/*  97 */     boolean var11 = (par0World.func_147439_a(par1 + var6, par2, par3 + var7) == par5Block || par0World.func_147439_a(par1 + var6, par2 + 1, par3 + var7) == par5Block);
/*  98 */     boolean var12 = false;
/*     */     
/* 100 */     if (var10 && !var11) {
/*     */       
/* 102 */       var12 = true;
/*     */     }
/* 104 */     else if (var9 > var8) {
/*     */       
/* 106 */       var12 = true;
/*     */     } 
/*     */     
/* 109 */     par0World.func_147465_d(par1, par2, par3, par5Block, par4, 2);
/* 110 */     par0World.func_147465_d(par1, par2 + 1, par3, par5Block, 0x8 | (var12 ? 1 : 0), 2);
/* 111 */     par0World.func_147459_d(par1, par2, par3, par5Block);
/* 112 */     par0World.func_147459_d(par1, par2 + 1, par3, par5Block);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 117 */     return EnumSize.HUGE;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 122 */     return EnumWeight.HEAVY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemWoodDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */