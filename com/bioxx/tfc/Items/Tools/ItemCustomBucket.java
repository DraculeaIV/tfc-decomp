/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityCowTFC;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Entities.IAnimal;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.FillBucketEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomBucket
/*     */   extends ItemTerra
/*     */ {
/*     */   private Block bucketContents;
/*     */   
/*     */   public ItemCustomBucket(Block contents) {
/*  35 */     this.bucketContents = contents;
/*  36 */     setFolder("tools/");
/*  37 */     setSize(EnumSize.MEDIUM);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemCustomBucket(Block contents, Item container) {
/*  42 */     this(contents);
/*  43 */     func_77642_a(container);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  58 */     boolean isEmpty = (this.bucketContents == Blocks.field_150350_a);
/*  59 */     MovingObjectPosition mop = func_77621_a(world, player, isEmpty);
/*     */     
/*  61 */     if (mop == null)
/*     */     {
/*  63 */       return is;
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/*  69 */       int x = mop.field_72311_b;
/*  70 */       int y = mop.field_72312_c;
/*  71 */       int z = mop.field_72309_d;
/*     */       
/*  73 */       if (!world.func_72962_a(player, x, y, z)) {
/*  74 */         return is;
/*     */       }
/*  76 */       if (isEmpty) {
/*     */         
/*  78 */         if (!player.func_82247_a(x, y, z, mop.field_72310_e, is)) {
/*  79 */           return is;
/*     */         }
/*  81 */         FillBucketEvent event = new FillBucketEvent(player, is, world, mop);
/*  82 */         if (MinecraftForge.EVENT_BUS.post((Event)event) || event.isCanceled()) {
/*  83 */           return is;
/*     */         }
/*  85 */         if (event.getResult() == Event.Result.ALLOW) {
/*  86 */           return event.result;
/*     */         }
/*  88 */         if (TFC_Core.isFreshWater(world.func_147439_a(x, y, z))) {
/*     */           
/*  90 */           world.func_147468_f(x, y, z);
/*  91 */           if (player.field_71075_bZ.field_75098_d)
/*  92 */             return is; 
/*  93 */           return new ItemStack(TFCItems.woodenBucketWater);
/*     */         } 
/*  95 */         if (TFC_Core.isSaltWater(world.func_147439_a(x, y, z))) {
/*     */           
/*  97 */           world.func_147468_f(x, y, z);
/*  98 */           if (player.field_71075_bZ.field_75098_d)
/*  99 */             return is; 
/* 100 */           return new ItemStack(TFCItems.woodenBucketSaltWater);
/*     */         } 
/*     */ 
/*     */         
/* 104 */         int flowX = x;
/* 105 */         int flowY = y;
/* 106 */         int flowZ = z;
/* 107 */         switch (mop.field_72310_e) {
/*     */           
/*     */           case 0:
/* 110 */             flowY = y - 1;
/*     */             break;
/*     */           case 1:
/* 113 */             flowY = y + 1;
/*     */             break;
/*     */           case 2:
/* 116 */             flowZ = z - 1;
/*     */             break;
/*     */           case 3:
/* 119 */             flowZ = z + 1;
/*     */             break;
/*     */           case 4:
/* 122 */             flowX = x - 1;
/*     */             break;
/*     */           case 5:
/* 125 */             flowX = x + 1;
/*     */             break;
/*     */         } 
/*     */         
/* 129 */         if (TFC_Core.isFreshWater(world.func_147439_a(flowX, flowY, flowZ))) {
/*     */           
/* 131 */           world.func_147468_f(flowX, flowY, flowZ);
/* 132 */           if (player.field_71075_bZ.field_75098_d)
/* 133 */             return is; 
/* 134 */           return new ItemStack(TFCItems.woodenBucketWater);
/*     */         } 
/* 136 */         if (TFC_Core.isSaltWater(world.func_147439_a(flowX, flowY, flowZ)))
/*     */         {
/* 138 */           world.func_147468_f(flowX, flowY, flowZ);
/* 139 */           if (player.field_71075_bZ.field_75098_d)
/* 140 */             return is; 
/* 141 */           return new ItemStack(TFCItems.woodenBucketSaltWater);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 146 */         return new ItemStack(TFCItems.woodenBucketEmpty);
/*     */       }
/*     */     
/* 149 */     } else if (this.bucketContents == Blocks.field_150350_a && mop.field_72308_g instanceof EntityCowTFC && ((EntityCowTFC)mop.field_72308_g).getGender() == IAnimal.GenderEnum.FEMALE) {
/*     */       
/* 151 */       return new ItemStack(TFCItems.woodenBucketMilk);
/*     */     } 
/* 153 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 161 */     boolean isEmpty = (this.bucketContents == Blocks.field_150350_a);
/* 162 */     int[][] map = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
/*     */     
/* 164 */     if (!isEmpty && world.func_147439_a(x, y, z) != Blocks.field_150383_bp && world.func_147437_c(x + map[side][0], y + map[side][1], z + map[side][2])) {
/*     */       
/* 166 */       world.func_147465_d(x + map[side][0], y + map[side][1], z + map[side][2], TFCBlocks.freshWater, 2, 1);
/* 167 */       player.func_70062_b(0, new ItemStack(TFCItems.woodenBucketEmpty));
/* 168 */       return true;
/*     */     } 
/*     */     
/* 171 */     if (!isEmpty && world.func_147439_a(x, y, z) == Blocks.field_150383_bp) {
/*     */       
/* 173 */       int meta = world.func_72805_g(x, y, z);
/* 174 */       if (meta < 3) {
/*     */         
/* 176 */         if (!player.field_71075_bZ.field_75098_d)
/*     */         {
/* 178 */           player.func_70062_b(0, new ItemStack(TFCItems.woodenBucketEmpty));
/*     */         }
/* 180 */         world.func_72921_c(x, y, z, MathHelper.func_76125_a(3, 0, 3), 2);
/* 181 */         world.func_147453_f(x, y, z, (Block)Blocks.field_150383_bp);
/*     */         
/* 183 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 193 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */