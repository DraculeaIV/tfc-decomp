/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEPottery;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
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
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemFirestarter
/*     */   extends ItemTerra
/*     */ {
/*     */   private boolean canBeUsed;
/*     */   private boolean isCoal;
/*     */   private boolean isPottery;
/*     */   
/*     */   public ItemFirestarter() {
/*  37 */     func_77656_e(8);
/*  38 */     this.field_77787_bX = false;
/*  39 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  45 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlacedBlockMetadata(int i) {
/*  50 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack is) {
/*  62 */     return EnumAction.bow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack is) {
/*  68 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/*  74 */     setFlags(player);
/*  75 */     MovingObjectPosition mop = func_77621_a(player.field_70170_p, player, true);
/*  76 */     if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/*  78 */       World world = player.field_70170_p;
/*  79 */       int x = mop.field_72311_b;
/*  80 */       int y = mop.field_72312_c;
/*  81 */       int z = mop.field_72309_d;
/*  82 */       double hitX = mop.field_72307_f.field_72450_a;
/*  83 */       double hitY = mop.field_72307_f.field_72448_b;
/*  84 */       double hitZ = mop.field_72307_f.field_72449_c;
/*  85 */       int chance = world.field_73012_v.nextInt(100);
/*     */       
/*  87 */       if (world.func_147439_a(x, y + 1, z) == TFCBlocks.firepit) {
/*  88 */         player.func_71034_by();
/*     */       }
/*  90 */       if (count > 0 && world.field_72995_K) {
/*     */         
/*  92 */         Boolean genSmoke = Boolean.valueOf((this.canBeUsed || this.isCoal || this.isPottery));
/*     */         
/*  94 */         if (genSmoke.booleanValue() && chance > 70) {
/*  95 */           world.func_72869_a("smoke", hitX, hitY, hitZ, 0.0D, 0.10000000149011612D, 0.0D);
/*     */         }
/*  97 */         if (count < 4 && chance > 70) {
/*  98 */           world.func_72869_a("flame", hitX, hitY, hitZ, 0.0D, 0.0D, 0.0D);
/*     */         }
/* 100 */         if (count < func_77626_a((ItemStack)null) - 4 && count % 3 == 1) {
/* 101 */           player.func_85030_a("terrafirmacraft:item.firestarter", 0.5F, 0.05F);
/*     */         }
/* 103 */       } else if (!world.field_72995_K && count == 1) {
/*     */         
/* 105 */         if (this.canBeUsed) {
/*     */           
/* 107 */           List list = world.func_72872_a(EntityItem.class, AxisAlignedBB.func_72330_a(x, (y + 1), z, (x + 1), (y + 2), (z + 1)));
/* 108 */           int numsticks = 0;
/* 109 */           int hasStraw = 0;
/*     */           
/* 111 */           if (list != null && !list.isEmpty()) {
/*     */             
/* 113 */             for (Iterator<EntityItem> iterator = list.iterator(); iterator.hasNext(); ) {
/*     */               
/* 115 */               EntityItem entity = iterator.next();
/* 116 */               if (entity.func_92059_d().func_77973_b() == TFCItems.straw) {
/* 117 */                 hasStraw = 40; continue;
/* 118 */               }  if (entity.func_92059_d().func_77973_b() == TFCItems.stick) {
/* 119 */                 numsticks += (entity.func_92059_d()).field_77994_a;
/*     */               }
/*     */             } 
/* 122 */             if (chance > 70 - hasStraw && numsticks >= 3) {
/*     */               
/* 124 */               for (Iterator<EntityItem> iterator1 = list.iterator(); iterator1.hasNext(); ) {
/*     */                 
/* 126 */                 EntityItem entity = iterator1.next();
/* 127 */                 if (entity.func_92059_d().func_77973_b() == TFCItems.stick || entity.func_92059_d().func_77973_b() == TFCItems.straw)
/* 128 */                   entity.func_70106_y(); 
/*     */               } 
/* 130 */               world.func_147465_d(x, y + 1, z, TFCBlocks.firepit, 1, 2);
/*     */             } 
/*     */           } 
/*     */           
/* 134 */           stack.func_77972_a(1, (EntityLivingBase)player);
/* 135 */           if (stack.func_77960_j() >= stack.func_77958_k()) {
/* 136 */             stack.field_77994_a = 0;
/*     */           }
/* 138 */         } else if (this.isCoal) {
/*     */           
/* 140 */           if (chance > 70)
/* 141 */             world.func_147465_d(x, y, z, TFCBlocks.forge, 1, 2); 
/* 142 */           stack.func_77972_a(1, (EntityLivingBase)player);
/*     */         }
/* 144 */         else if (this.isPottery) {
/*     */           
/* 146 */           if (chance > 70) {
/*     */             
/* 148 */             TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 149 */             te.startPitFire();
/*     */           } 
/* 151 */           stack.func_77972_a(1, (EntityLivingBase)player);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/* 160 */     if (this.canBeUsed || this.isCoal || this.isPottery)
/* 161 */       player.func_71008_a(is, func_77626_a(is)); 
/* 162 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 168 */     setFlags(player);
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 175 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFlags(EntityPlayer player) {
/* 180 */     MovingObjectPosition mop = func_77621_a(player.field_70170_p, player, true);
/* 181 */     if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 183 */       World world = player.field_70170_p;
/* 184 */       int x = mop.field_72311_b;
/* 185 */       int y = mop.field_72312_c;
/* 186 */       int z = mop.field_72309_d;
/* 187 */       int side = mop.field_72310_e;
/*     */       
/* 189 */       Block block = world.func_147439_a(x, y, z);
/* 190 */       boolean surroundSolids = TFC_Core.isSurroundedSolid(world, x, y, z);
/* 191 */       boolean surroundRock = TFC_Core.isSurroundedStone(world, x, y, z);
/* 192 */       this
/*     */ 
/*     */ 
/*     */         
/* 196 */         .canBeUsed = (side == 1 && TFC_Core.isTopFaceSolid(world, x, y, z) && block.func_149688_o() != Material.field_151575_d && block.func_149688_o() != Material.field_151580_n && world.func_147437_c(x, y + 1, z) && block != TFCBlocks.charcoal && block != Blocks.field_150402_ci && block != TFCBlocks.pottery);
/*     */ 
/*     */ 
/*     */       
/* 200 */       this.isCoal = (((block == TFCBlocks.charcoal && world.func_72805_g(x, y, z) > 6) || block == Blocks.field_150402_ci) && surroundRock && surroundSolids);
/* 201 */       this.isPottery = (block == TFCBlocks.pottery && surroundSolids);
/* 202 */       if (this.isPottery) {
/*     */         
/* 204 */         TEPottery te = (TEPottery)world.func_147438_o(x, y, z);
/* 205 */         this.isPottery = (!te.isLit() && te.wood == 8);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemFirestarter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */