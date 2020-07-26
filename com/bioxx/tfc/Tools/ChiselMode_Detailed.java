/*     */ package com.bioxx.tfc.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEDetailed;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Tools.ChiselMode;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChiselMode_Detailed
/*     */   extends ChiselMode
/*     */ {
/*  24 */   private static ResourceLocation resourcelocation = new ResourceLocation("terrafirmacraft", "textures/gui/icons.png");
/*     */   private static int textureU;
/*  26 */   private static Random random = new Random();
/*     */   private static int textureV;
/*     */   
/*     */   public ChiselMode_Detailed(String n) {
/*  30 */     textureU = 60;
/*  31 */     textureV = 58;
/*  32 */     div = 8;
/*     */   }
/*     */   
/*     */   private static int div;
/*     */   
/*     */   public ResourceLocation getResourceLocation() {
/*  38 */     return resourcelocation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextureU() {
/*  44 */     return textureU;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextureV() {
/*  50 */     return textureV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivX(Block block) {
/*  56 */     return div;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivY(Block block) {
/*  62 */     return div;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivZ(Block block) {
/*  68 */     return div;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/*  74 */     if ((TFC_Core.isNaturalStone(id) && TFC_Core.isNaturalStone(world.func_147439_a(x, y + 1, z)) && 
/*  75 */       TFC_Core.isNaturalStone(world.func_147439_a(x, y + 2, z))) || id == TFCBlocks.stoneStairs) {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int hasChisel = hasChisel(player);
/*  80 */     PlayerInfo pi = playerInfo(world, player);
/*     */ 
/*     */     
/*  83 */     if (hasChisel >= 0 && pi.lockMatches(x, y, z)) {
/*     */ 
/*     */       
/*  86 */       if (id == TFCBlocks.stoneSlabs) {
/*  87 */         TEPartial tep = (TEPartial)world.func_147438_o(x, y, z);
/*  88 */         int extraX = (int)(tep.extraData & 0xFL);
/*  89 */         int extraY = (int)(tep.extraData >> 4L & 0xFL);
/*  90 */         int extraZ = (int)(tep.extraData >> 8L & 0xFL);
/*  91 */         int extraX2 = 8 - (int)(tep.extraData >> 12L & 0xFL);
/*  92 */         int extraY2 = 8 - (int)(tep.extraData >> 16L & 0xFL);
/*  93 */         int extraZ2 = 8 - (int)(tep.extraData >> 20L & 0xFL);
/*  94 */         world.func_147449_b(x, y, z, TFCBlocks.detailed);
/*  95 */         TEDetailed tEDetailed = (TEDetailed)world.func_147438_o(x, y, z);
/*  96 */         tEDetailed.typeID = tep.typeID;
/*  97 */         tEDetailed.metaID = tep.metaID;
/*     */         
/*  99 */         for (int i = 0; i < 8; i++) {
/* 100 */           for (int subZ = 0; subZ < 8; subZ++) {
/* 101 */             for (int subY = 0; subY < 8; subY++) {
/* 102 */               if (i >= extraX && i < extraX2 && subY >= extraY && subY < extraY2 && subZ >= extraZ && subZ < extraZ2) {
/* 103 */                 tEDetailed.setBlock(i, subY, subZ);
/* 104 */                 tEDetailed.setQuad(i, subY, subZ);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 109 */         return true;
/*     */       } 
/*     */       
/* 112 */       world.func_147449_b(x, y, z, TFCBlocks.detailed);
/*     */       
/* 114 */       TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/* 115 */       te.typeID = (short)Block.func_149682_b(id);
/* 116 */       te.metaID = (byte)meta;
/*     */       
/* 118 */       for (int subX = 0; subX < 8; subX++) {
/* 119 */         for (int subZ = 0; subZ < 8; subZ++) {
/* 120 */           for (int subY = 0; subY < 8; subY++) {
/* 121 */             te.setBlock(subX, subY, subZ);
/* 122 */             te.setQuad(subX, subY, subZ);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 128 */       world.func_147459_d(x, y, z, world.func_147439_a(x, y, z));
/*     */       
/* 130 */       if (random.nextInt(4) == 0)
/*     */       {
/* 132 */         player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);
/*     */       }
/*     */     } 
/*     */     
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Tools\ChiselMode_Detailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */