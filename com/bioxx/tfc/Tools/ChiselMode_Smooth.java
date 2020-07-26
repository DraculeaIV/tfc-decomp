/*     */ package com.bioxx.tfc.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
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
/*     */ public class ChiselMode_Smooth
/*     */   extends ChiselMode
/*     */ {
/*  19 */   private static ResourceLocation resourcelocation = new ResourceLocation("terrafirmacraft", "textures/gui/icons.png");
/*     */   
/*     */   private static int textureU;
/*     */   
/*     */   public ChiselMode_Smooth(String n) {
/*  24 */     textureU = 0;
/*  25 */     textureV = 58;
/*  26 */     div = 1;
/*     */   }
/*     */   private static int textureV; private static int div;
/*     */   
/*     */   public ResourceLocation getResourceLocation() {
/*  31 */     return resourcelocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTextureU() {
/*  36 */     return textureU;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTextureV() {
/*  41 */     return textureV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivX(Block block) {
/*  47 */     if (block instanceof com.bioxx.tfc.Blocks.Terrain.BlockStone) {
/*  48 */       return div;
/*     */     }
/*     */     
/*  51 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivY(Block block) {
/*  57 */     if (block instanceof com.bioxx.tfc.Blocks.Terrain.BlockStone) {
/*  58 */       return div;
/*     */     }
/*     */     
/*  61 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDivZ(Block block) {
/*  67 */     if (block instanceof com.bioxx.tfc.Blocks.Terrain.BlockStone) {
/*  68 */       return div;
/*     */     }
/*     */     
/*  71 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/*  78 */     if (TFC_Core.isNaturalStone(world.func_147439_a(x, y + 1, z)) && TFC_Core.isNaturalStone(world.func_147439_a(x, y + 2, z))) {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (TFC_Core.isRawStone(id)) {
/*     */       
/*  84 */       int hasChisel = hasChisel(player);
/*  85 */       if (hasChisel >= 0) {
/*  86 */         if (id == TFCBlocks.stoneIgIn) {
/*  87 */           world.func_147465_d(x, y, z, TFCBlocks.stoneIgInSmooth, meta, 2);
/*  88 */         } else if (id == TFCBlocks.stoneIgEx) {
/*  89 */           world.func_147465_d(x, y, z, TFCBlocks.stoneIgExSmooth, meta, 2);
/*  90 */         } else if (id == TFCBlocks.stoneSed) {
/*  91 */           world.func_147465_d(x, y, z, TFCBlocks.stoneSedSmooth, meta, 2);
/*  92 */         } else if (id == TFCBlocks.stoneMM) {
/*  93 */           world.func_147465_d(x, y, z, TFCBlocks.stoneMMSmooth, meta, 2);
/*     */         } 
/*     */         
/*  96 */         player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);
/*  97 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Tools\ChiselMode_Smooth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */