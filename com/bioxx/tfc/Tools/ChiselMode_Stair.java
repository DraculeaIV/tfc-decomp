/*     */ package com.bioxx.tfc.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Tools.ChiselMode;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChiselMode_Stair
/*     */   extends ChiselMode
/*     */ {
/*  21 */   private static ResourceLocation resourcelocation = new ResourceLocation("terrafirmacraft", "textures/gui/icons.png");
/*     */   
/*     */   private static int textureU;
/*     */   
/*     */   public ChiselMode_Stair(String n) {
/*  26 */     textureU = 20;
/*  27 */     textureV = 58;
/*  28 */     div = 2;
/*     */   }
/*     */   private static int textureV;
/*     */   private static int div;
/*     */   
/*     */   public ResourceLocation getResourceLocation() {
/*  34 */     return resourcelocation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextureU() {
/*  40 */     return textureU;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextureV() {
/*  46 */     return textureV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivX(Block block) {
/*  52 */     if (block == TFCBlocks.stoneStairs || isChiselable(block)) {
/*  53 */       return div;
/*     */     }
/*     */     
/*  56 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivY(Block block) {
/*  63 */     if (block == TFCBlocks.stoneStairs || isChiselable(block)) {
/*  64 */       return div;
/*     */     }
/*     */     
/*  67 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivZ(Block block) {
/*  74 */     if (block == TFCBlocks.stoneStairs || isChiselable(block)) {
/*  75 */       return div;
/*     */     }
/*     */     
/*  78 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/*  85 */     if ((TFC_Core.isNaturalStone(id) && TFC_Core.isNaturalStone(world.func_147439_a(x, y + 1, z)) && 
/*  86 */       TFC_Core.isNaturalStone(world.func_147439_a(x, y + 2, z))) || id == TFCBlocks.stoneSlabs) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     int hasChisel = hasChisel(player);
/*     */     
/*  92 */     if (hasChisel >= 0) {
/*  93 */       int hit = 0;
/*  94 */       TEPartial te = null;
/*  95 */       if (id != TFCBlocks.stoneStairs) {
/*     */         
/*  97 */         world.func_147465_d(x, y, z, TFCBlocks.stoneStairs, 0, 3);
/*  98 */         te = (TEPartial)world.func_147438_o(x, y, z);
/*  99 */         te.typeID = (short)Block.func_149682_b(id);
/* 100 */         te.metaID = (byte)meta;
/* 101 */         te.extraData = hit;
/* 102 */         te.setMaterial(world.func_147439_a(x, y, z).func_149688_o());
/* 103 */         te.func_145829_t();
/*     */       }
/*     */       else {
/*     */         
/* 107 */         te = (TEPartial)world.func_147438_o(x, y, z);
/* 108 */         world.func_147444_c(x, y, z, id);
/*     */       } 
/* 110 */       if (hitY > 0.5F) {
/*     */         
/* 112 */         if (hitX <= 0.5F && hitZ >= 0.5F && (te.extraData & 0x1L) == 0L)
/* 113 */           hit = 1; 
/* 114 */         if (hitX >= 0.5F && hitZ <= 0.5F && (te.extraData & 0x2L) == 0L)
/* 115 */           hit = 2; 
/* 116 */         if (hitX <= 0.5F && hitZ <= 0.5F && (te.extraData & 0x4L) == 0L)
/* 117 */           hit = 4; 
/* 118 */         if (hitX >= 0.5F && hitZ >= 0.5F && (te.extraData & 0x8L) == 0L) {
/* 119 */           hit = 8;
/*     */         }
/*     */       } else {
/*     */         
/* 123 */         if (hitX <= 0.5F && hitZ >= 0.5F && (te.extraData & 0x10L) == 0L)
/* 124 */           hit = 16; 
/* 125 */         if (hitX >= 0.5F && hitZ <= 0.5F && (te.extraData & 0x20L) == 0L)
/* 126 */           hit = 32; 
/* 127 */         if (hitX <= 0.5F && hitZ <= 0.5F && (te.extraData & 0x40L) == 0L)
/* 128 */           hit = 64; 
/* 129 */         if (hitX >= 0.5F && hitZ >= 0.5F && (te.extraData & 0x80L) == 0L) {
/* 130 */           hit = 128;
/*     */         }
/*     */       } 
/* 133 */       te.extraData |= hit;
/* 134 */       if (te.extraData == 255L) {
/* 135 */         world.func_147449_b(x, y, z, Blocks.field_150350_a);
/*     */       } else {
/* 137 */         te.broadcastPacketInRange();
/*     */       } 
/* 139 */       player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);
/*     */     } 
/*     */     
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Tools\ChiselMode_Stair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */