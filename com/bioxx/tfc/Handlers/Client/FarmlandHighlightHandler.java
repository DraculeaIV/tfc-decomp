/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockFarmland;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.TileEntities.TEFarmland;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.DrawBlockHighlightEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FarmlandHighlightHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void drawBlockHighlightEvent(DrawBlockHighlightEvent evt) {
/*  35 */     World world = evt.player.field_70170_p;
/*  36 */     double var8 = evt.player.field_70142_S + (evt.player.field_70165_t - evt.player.field_70142_S) * evt.partialTicks;
/*  37 */     double var10 = evt.player.field_70137_T + (evt.player.field_70163_u - evt.player.field_70137_T) * evt.partialTicks;
/*  38 */     double var12 = evt.player.field_70136_U + (evt.player.field_70161_v - evt.player.field_70136_U) * evt.partialTicks;
/*     */     
/*  40 */     boolean isMetalHoe = false;
/*     */     
/*  42 */     if (evt.currentItem != null && evt.currentItem
/*  43 */       .func_77973_b() != TFCItems.igInHoe && evt.currentItem
/*  44 */       .func_77973_b() != TFCItems.igExHoe && evt.currentItem
/*  45 */       .func_77973_b() != TFCItems.sedHoe && evt.currentItem
/*  46 */       .func_77973_b() != TFCItems.mMHoe)
/*     */     {
/*  48 */       isMetalHoe = true;
/*     */     }
/*     */     
/*  51 */     PlayerManagerTFC manager = PlayerManagerTFC.getInstance();
/*  52 */     PlayerInfo playerInfo = (manager != null) ? manager.getClientPlayer() : null;
/*  53 */     int hoeMode = (playerInfo != null) ? playerInfo.hoeMode : -1;
/*     */     
/*  55 */     if (evt.currentItem != null && evt.currentItem.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomHoe && isMetalHoe && hoeMode == 1) {
/*     */       
/*  57 */       if (TFC_Core.getSkillStats(evt.player) != null) {
/*     */         
/*  59 */         SkillStats.SkillRank sr = TFC_Core.getSkillStats(evt.player).getSkillRank("skill.agriculture");
/*  60 */         if (sr != SkillStats.SkillRank.Expert && sr != SkillStats.SkillRank.Master) {
/*     */           return;
/*     */         }
/*     */       } 
/*  64 */       Block b = world.func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d);
/*  65 */       int crop = 0;
/*  66 */       if (b == TFCBlocks.crops && (world
/*  67 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil || world
/*  68 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil2)) {
/*     */         
/*  70 */         b = TFCBlocks.tilledSoil;
/*  71 */         crop = 1;
/*     */       } 
/*     */       
/*  74 */       if (b == TFCBlocks.tilledSoil || b == TFCBlocks.tilledSoil2)
/*     */       {
/*  76 */         TEFarmland te = (TEFarmland)world.func_147438_o(evt.target.field_72311_b, evt.target.field_72312_c - crop, evt.target.field_72309_d);
/*  77 */         te.requestNutrientData();
/*     */         
/*  79 */         float timeMultiplier = TFC_Time.daysInYear / 360.0F;
/*  80 */         int soilMax = (int)(25000.0F * timeMultiplier);
/*     */ 
/*     */         
/*  83 */         GL11.glEnable(3042);
/*  84 */         GL11.glBlendFunc(770, 771);
/*     */         
/*  86 */         GL11.glDisable(2884);
/*     */         
/*  88 */         GL11.glDisable(3553);
/*  89 */         GL11.glDepthMask(false);
/*     */         
/*  91 */         double offset = 0.0D;
/*  92 */         double fertilizer = 1.02D + te.nutrients[3] / soilMax * 0.5D;
/*  93 */         GL11.glColor4ub(TFCOptions.cropFertilizerColor[0], TFCOptions.cropFertilizerColor[1], TFCOptions.cropFertilizerColor[2], TFCOptions.cropFertilizerColor[3]);
/*  94 */         drawBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop, evt.target.field_72309_d, (evt.target.field_72311_b + 1), evt.target.field_72312_c + fertilizer - crop, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 101 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 103 */         double nutrient = 1.02D + te.nutrients[0] / soilMax * 0.5D;
/* 104 */         GL11.glColor4ub(TFCOptions.cropNutrientAColor[0], TFCOptions.cropNutrientAColor[1], TFCOptions.cropNutrientAColor[2], TFCOptions.cropNutrientAColor[3]);
/* 105 */         drawBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 112 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 114 */         offset = 0.3333D;
/* 115 */         nutrient = 1.02D + te.nutrients[1] / soilMax * 0.5D;
/* 116 */         GL11.glColor4ub(TFCOptions.cropNutrientBColor[0], TFCOptions.cropNutrientBColor[1], TFCOptions.cropNutrientBColor[2], TFCOptions.cropNutrientBColor[3]);
/* 117 */         drawBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 124 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 126 */         offset = 0.6666D;
/* 127 */         nutrient = 1.02D + te.nutrients[2] / soilMax * 0.5D;
/* 128 */         GL11.glColor4ub(TFCOptions.cropNutrientCColor[0], TFCOptions.cropNutrientCColor[1], TFCOptions.cropNutrientCColor[2], TFCOptions.cropNutrientCColor[3]);
/* 129 */         drawBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 136 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 138 */         GL11.glEnable(2884);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 145 */         GL11.glColor4f(0.1F, 0.1F, 0.1F, 1.0F);
/* 146 */         GL11.glLineWidth(3.0F);
/* 147 */         GL11.glDepthMask(false);
/*     */         
/* 149 */         offset = 0.0D;
/*     */         
/* 151 */         drawOutlinedBoundingBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop, evt.target.field_72309_d, (evt.target.field_72311_b + 1), evt.target.field_72312_c + fertilizer - crop, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 158 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 160 */         nutrient = 1.02D + te.nutrients[0] / soilMax * 0.5D;
/* 161 */         drawOutlinedBoundingBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 168 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 170 */         offset = 0.3333D;
/* 171 */         nutrient = 1.02D + te.nutrients[1] / soilMax * 0.5D;
/* 172 */         drawOutlinedBoundingBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 179 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 181 */         offset = 0.6666D;
/* 182 */         nutrient = 1.02D + te.nutrients[2] / soilMax * 0.5D;
/* 183 */         drawOutlinedBoundingBox(AxisAlignedBB.func_72330_a(evt.target.field_72311_b + offset, evt.target.field_72312_c + 1.01D - crop + fertilizer - 1.02D, evt.target.field_72309_d, evt.target.field_72311_b + offset + 0.3333D, evt.target.field_72312_c + nutrient - crop + fertilizer - 1.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 190 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */       }
/*     */     
/* 193 */     } else if (evt.currentItem != null && evt.currentItem.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomHoe && hoeMode == 2) {
/*     */       
/* 195 */       Block b = world.func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d);
/* 196 */       int crop = 0;
/* 197 */       if (b == TFCBlocks.crops && (world
/* 198 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil || world
/* 199 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil2)) {
/*     */         
/* 201 */         b = TFCBlocks.tilledSoil;
/* 202 */         crop = 1;
/*     */       } 
/*     */       
/* 205 */       if (b == TFCBlocks.tilledSoil || b == TFCBlocks.tilledSoil2)
/*     */       {
/* 207 */         boolean water = BlockFarmland.isFreshWaterNearby(world, evt.target.field_72311_b, evt.target.field_72312_c - crop, evt.target.field_72309_d);
/*     */         
/* 209 */         GL11.glEnable(3042);
/* 210 */         GL11.glBlendFunc(770, 771);
/* 211 */         if (water) {
/* 212 */           GL11.glColor4ub((byte)14, (byte)23, (byte)-44, (byte)-56);
/*     */         } else {
/* 214 */           GL11.glColor4ub((byte)0, (byte)0, (byte)0, (byte)-56);
/* 215 */         }  GL11.glDisable(2884);
/*     */         
/* 217 */         GL11.glDisable(3553);
/* 218 */         GL11.glDepthMask(false);
/*     */         
/* 220 */         drawFace(AxisAlignedBB.func_72330_a(evt.target.field_72311_b, evt.target.field_72312_c + 1.01D - crop, evt.target.field_72309_d, (evt.target.field_72311_b + 1), evt.target.field_72312_c + 1.02D - crop, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 227 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 229 */         GL11.glEnable(2884);
/*     */       }
/*     */     
/* 232 */     } else if (evt.currentItem != null && evt.currentItem.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemCustomHoe && hoeMode == 3) {
/*     */       
/* 234 */       Block b = world.func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d);
/* 235 */       if (b == TFCBlocks.crops && (world
/* 236 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil || world
/* 237 */         .func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d) == TFCBlocks.tilledSoil2)) {
/*     */         
/* 239 */         TECrop te = (TECrop)world.func_147438_o(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d);
/* 240 */         CropIndex index = CropManager.getInstance().getCropFromId(te.cropId);
/* 241 */         boolean fullyGrown = (index instanceof com.bioxx.tfc.Food.CropIndexPepper) ? ((te.growth >= (index.numGrowthStages - 1))) : ((te.growth >= index.numGrowthStages));
/*     */         
/* 243 */         GL11.glEnable(3042);
/* 244 */         GL11.glBlendFunc(770, 771);
/* 245 */         if (fullyGrown) {
/* 246 */           GL11.glColor4ub((byte)64, (byte)-56, (byte)37, (byte)-56);
/*     */         } else {
/* 248 */           GL11.glColor4ub((byte)-56, (byte)37, (byte)37, (byte)-56);
/* 249 */         }  GL11.glDisable(2884);
/*     */         
/* 251 */         GL11.glDisable(3553);
/* 252 */         GL11.glDepthMask(false);
/*     */         
/* 254 */         drawFace(AxisAlignedBB.func_72330_a(evt.target.field_72311_b, evt.target.field_72312_c + 0.01D, evt.target.field_72309_d, (evt.target.field_72311_b + 1), evt.target.field_72312_c + 0.02D, (evt.target.field_72309_d + 1))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 261 */             .func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */         
/* 263 */         GL11.glEnable(2884);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawFace(AxisAlignedBB par1AxisAlignedBB) {
/* 270 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */ 
/*     */     
/* 273 */     var2.func_78371_b(7);
/* 274 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 275 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 276 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 277 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 278 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBox(AxisAlignedBB par1AxisAlignedBB) {
/* 283 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */ 
/*     */     
/* 286 */     var2.func_78371_b(7);
/* 287 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 288 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 289 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 290 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 291 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 294 */     var2.func_78371_b(7);
/* 295 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 296 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 297 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 298 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 299 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 302 */     var2.func_78371_b(7);
/* 303 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 304 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 305 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 306 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 307 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 310 */     var2.func_78371_b(7);
/* 311 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 312 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 313 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 314 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 315 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 318 */     var2.func_78371_b(7);
/* 319 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 320 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 321 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 322 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 323 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
/* 328 */     Tessellator var2 = Tessellator.field_78398_a;
/* 329 */     var2.func_78371_b(3);
/* 330 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 331 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 332 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 333 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 334 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 335 */     var2.func_78381_a();
/* 336 */     var2.func_78371_b(3);
/* 337 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 338 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 339 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 340 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 341 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 342 */     var2.func_78381_a();
/* 343 */     var2.func_78371_b(1);
/* 344 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 345 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 346 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 347 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 348 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 349 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 350 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 351 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 352 */     var2.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\FarmlandHighlightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */