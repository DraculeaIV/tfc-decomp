/*     */ package com.bioxx.tfc.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockSlab;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEPartial;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import com.bioxx.tfc.api.Tools.ChiselMode;
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
/*     */ public class ChiselMode_Slab
/*     */   extends ChiselMode
/*     */ {
/*  23 */   private static ResourceLocation resourcelocation = new ResourceLocation("terrafirmacraft", "textures/gui/icons.png");
/*     */   private static int textureU;
/*     */   private static int textureV;
/*     */   
/*     */   public ChiselMode_Slab(String n) {
/*  28 */     textureU = 40;
/*  29 */     textureV = 58;
/*     */   }
/*     */   
/*     */   private static int divX;
/*     */   
/*     */   public ResourceLocation getResourceLocation() {
/*  35 */     return resourcelocation;
/*     */   }
/*     */   
/*     */   private static int divY;
/*     */   
/*     */   public int getTextureU() {
/*  41 */     return textureU;
/*     */   }
/*     */   
/*     */   private static int divZ;
/*     */   
/*     */   public int getTextureV() {
/*  47 */     return textureV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivX(Block block) {
/*  53 */     if (block == TFCBlocks.stoneSlabs || isChiselable(block)) {
/*  54 */       return divX;
/*     */     }
/*     */     
/*  57 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivY(Block block) {
/*  64 */     if (block == TFCBlocks.stoneSlabs || isChiselable(block)) {
/*  65 */       return divY;
/*     */     }
/*     */     
/*  68 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivZ(Block block) {
/*  75 */     if (block == TFCBlocks.stoneSlabs || isChiselable(block)) {
/*  76 */       return divZ;
/*     */     }
/*     */     
/*  79 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDivision(int sideHit) {
/*  86 */     if (sideHit == 5 || sideHit == 4) {
/*     */       
/*  88 */       divY = divZ = 1;
/*  89 */       divX = 8;
/*     */     }
/*  91 */     else if (sideHit == 1 || sideHit == 0) {
/*     */       
/*  93 */       divX = divZ = 1;
/*  94 */       divY = 8;
/*     */     }
/*  96 */     else if (sideHit == 3 || sideHit == 2) {
/*     */       
/*  98 */       divY = divX = 1;
/*  99 */       divZ = 8;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/* 106 */     if ((TFC_Core.isNaturalStone(id) && TFC_Core.isNaturalStone(world.func_147439_a(x, y + 1, z)) && 
/* 107 */       TFC_Core.isNaturalStone(world.func_147439_a(x, y + 2, z))) || id == TFCBlocks.stoneStairs) {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     int hasChisel = hasChisel(player);
/*     */     
/* 113 */     if (hasChisel >= 0) {
/* 114 */       Block slab = TFCBlocks.stoneSlabs;
/*     */ 
/*     */       
/* 117 */       if (world.func_147439_a(x, y, z) != slab) {
/* 118 */         world.func_147465_d(x, y, z, slab, side, 2);
/* 119 */         te = (TEPartial)world.func_147438_o(x, y, z);
/* 120 */         te.typeID = (short)Block.func_149682_b(id);
/* 121 */         te.metaID = (byte)meta;
/* 122 */         te.setMaterial(world.func_147439_a(x, y, z).func_149688_o());
/*     */       } else {
/* 124 */         te = (TEPartial)world.func_147438_o(x, y, z);
/* 125 */         world.func_147444_c(x, y, z, slab);
/*     */       } 
/*     */       
/* 128 */       if (TFCOptions.enableDebugMode) {
/* 129 */         TerraFirmaCraft.LOG.info(Integer.valueOf(side));
/*     */       }
/* 131 */       long extraX = te.extraData & 0xFL;
/* 132 */       long extraY = te.extraData >> 4L & 0xFL;
/* 133 */       long extraZ = te.extraData >> 8L & 0xFL;
/* 134 */       long extraX2 = te.extraData >> 12L & 0xFL;
/* 135 */       long extraY2 = te.extraData >> 16L & 0xFL;
/* 136 */       long extraZ2 = te.extraData >> 20L & 0xFL;
/*     */       
/* 138 */       if (side == 0) {
/* 139 */         long e = extraY + 1L;
/* 140 */         long new1 = extraY << 4L;
/* 141 */         long new2 = e << 4L;
/* 142 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 144 */         if (e + BlockSlab.getTopChiselLevel(te.extraData) >= 8L) {
/* 145 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 147 */           te.extraData = old2;
/*     */         } 
/* 149 */       } else if (side == 1) {
/* 150 */         long e = extraY2 + 1L;
/* 151 */         long new1 = extraY2 << 16L;
/* 152 */         long new2 = e << 16L;
/* 153 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 155 */         if (e + BlockSlab.getBottomChiselLevel(te.extraData) >= 8L) {
/* 156 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 158 */           te.extraData = old2;
/*     */         } 
/* 160 */       } else if (side == 2) {
/* 161 */         long e = extraZ + 1L;
/* 162 */         long new1 = extraZ << 8L;
/* 163 */         long new2 = e << 8L;
/* 164 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 166 */         if (e + BlockSlab.getSouthChiselLevel(te.extraData) >= 8L) {
/* 167 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 169 */           te.extraData = old2;
/*     */         } 
/* 171 */       } else if (side == 3) {
/* 172 */         long e = extraZ2 + 1L;
/* 173 */         long new1 = extraZ2 << 20L;
/* 174 */         long new2 = e << 20L;
/* 175 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 177 */         if (e + BlockSlab.getNorthChiselLevel(te.extraData) >= 8L) {
/* 178 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 180 */           te.extraData = old2;
/*     */         } 
/* 182 */       } else if (side == 4) {
/* 183 */         long e = extraX + 1L;
/* 184 */         long new1 = extraX;
/* 185 */         long new2 = e;
/* 186 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 188 */         if (e + BlockSlab.getEastChiselLevel(te.extraData) >= 8L) {
/* 189 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 191 */           te.extraData = old2;
/*     */         } 
/* 193 */       } else if (side == 5) {
/* 194 */         long e = extraX2 + 1L;
/* 195 */         long new1 = extraX2 << 12L;
/* 196 */         long new2 = e << 12L;
/* 197 */         long old2 = new2 | te.extraData - new1;
/*     */         
/* 199 */         if (e + BlockSlab.getWestChiselLevel(te.extraData) >= 8L) {
/* 200 */           world.func_147468_f(x, y, z);
/*     */         } else {
/* 202 */           te.extraData = old2;
/*     */         } 
/*     */       } 
/*     */       
/* 206 */       if (TFCOptions.enableDebugMode) {
/* 207 */         TerraFirmaCraft.LOG.info("Extra =" + te.extraData);
/*     */       }
/*     */       
/* 210 */       TEPartial te = (TEPartial)world.func_147438_o(x, y, z);
/* 211 */       if (te != null) {
/* 212 */         world.func_147471_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*     */       }
/*     */ 
/*     */       
/* 216 */       world.func_147459_d(x, y, z, world.func_147439_a(x, y, z));
/*     */       
/* 218 */       player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);
/*     */     } 
/*     */     
/* 221 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Tools\ChiselMode_Slab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */