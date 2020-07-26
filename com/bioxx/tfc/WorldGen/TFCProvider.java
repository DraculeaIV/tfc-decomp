/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFCProvider
/*     */   extends WorldProvider
/*     */ {
/*     */   private int moonPhase;
/*     */   private int moonPhaseLastCalculated;
/*     */   
/*     */   protected void func_76572_b() {
/*  34 */     TFC_Climate.worldPair.put(this.field_76579_a, new WorldCacheManager(this.field_76579_a));
/*  35 */     TFC_Core.addCDM(this.field_76579_a);
/*     */     
/*  37 */     super.func_76572_b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IChunkProvider func_76555_c() {
/*  43 */     return (IChunkProvider)new TFCChunkProviderGenerate(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76566_a(int x, int z) {
/*  49 */     int y = this.field_76579_a.func_72825_h(x, z) - 1;
/*  50 */     if (y < 144 || y > 169) return false; 
/*  51 */     Block b = this.field_76579_a.func_147439_a(x, y, z);
/*  52 */     return (TFC_Core.isSand(b) || TFC_Core.isGrass(b));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_76559_b(long par1) {
/*  61 */     if (TFC_Time.getDayFromTotalHours(TFC_Time.getTotalHours()) != this.moonPhaseLastCalculated) {
/*     */       
/*  63 */       int daysPassed = (int)(par1 / 24000L);
/*  64 */       int dayOfMonth = daysPassed % TFC_Time.daysInMonth;
/*  65 */       float dayToLunarDayMultiplier = 8.0F / TFC_Time.daysInMonth;
/*     */ 
/*     */       
/*  68 */       int lunarDay = Math.round(dayOfMonth * dayToLunarDayMultiplier);
/*     */       
/*  70 */       this.moonPhase = lunarDay % 8;
/*     */       
/*  72 */       this.moonPhaseLastCalculated = TFC_Time.getDayFromTotalHours(TFC_Time.getTotalHours());
/*     */     } 
/*     */     
/*  75 */     return this.moonPhase;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_76571_f() {
/*  81 */     return 256.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isNextToShoreOrIce(int x, int y, int z) {
/*  92 */     if (this.field_76579_a.func_72904_c(x + 1, y, z, x + 1, y, z) && (
/*  93 */       this.field_76579_a.func_147439_a(x + 1, y, z) == TFCBlocks.ice || TFC_Core.isGround(this.field_76579_a.func_147439_a(x + 1, y, z))))
/*  94 */       return true; 
/*  95 */     if (this.field_76579_a.func_72904_c(x - 1, y, z, x - 1, y, z) && (
/*  96 */       this.field_76579_a.func_147439_a(x - 1, y, z) == TFCBlocks.ice || TFC_Core.isGround(this.field_76579_a.func_147439_a(x - 1, y, z))))
/*  97 */       return true; 
/*  98 */     if (this.field_76579_a.func_72904_c(x, y, z + 1, x, y, z + 1) && (
/*  99 */       this.field_76579_a.func_147439_a(x, y, z + 1) == TFCBlocks.ice || TFC_Core.isGround(this.field_76579_a.func_147439_a(x, y, z + 1))))
/* 100 */       return true; 
/* 101 */     if (this.field_76579_a.func_72904_c(x, y, z - 1, x, y, z - 1) && (
/* 102 */       this.field_76579_a.func_147439_a(x, y, z - 1) == TFCBlocks.ice || TFC_Core.isGround(this.field_76579_a.func_147439_a(x, y, z - 1))))
/* 103 */       return true; 
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
/* 110 */     Block id = this.field_76579_a.func_147439_a(x, y, z);
/* 111 */     int meta = this.field_76579_a.func_72805_g(x, y, z);
/* 112 */     float temp = TFC_Climate.getHeightAdjustedTemp(this.field_76579_a, x, y, z);
/* 113 */     BiomeGenBase biome = this.field_76579_a.func_72807_a(x, z);
/*     */     
/* 115 */     if (temp <= 0.0F && biome != TFCBiome.DEEP_OCEAN) {
/*     */       
/* 117 */       if (this.field_76579_a.func_147437_c(x, y + 1, z) && TFC_Core.isWater(id) && this.field_76579_a.field_73012_v.nextInt(4) == 0 && isNextToShoreOrIce(x, y, z))
/*     */       {
/* 119 */         Material mat = this.field_76579_a.func_147439_a(x, y, z).func_149688_o();
/* 120 */         boolean salty = TFC_Core.isSaltWaterIncludeIce(id, meta, mat);
/*     */         
/* 122 */         if (temp <= -2.0F) {
/* 123 */           salty = false;
/*     */         }
/* 125 */         if ((mat == Material.field_151586_h || mat == Material.field_151588_w) && !salty)
/*     */         {
/* 127 */           if (id == TFCBlocks.freshWaterStationary && meta == 0) {
/*     */             
/* 129 */             this.field_76579_a.func_147465_d(x, y, z, TFCBlocks.ice, 1, 2);
/*     */           }
/* 131 */           else if (id == TFCBlocks.saltWaterStationary && meta == 0) {
/*     */             
/* 133 */             this.field_76579_a.func_147465_d(x, y, z, TFCBlocks.ice, 0, 2);
/*     */           } 
/*     */         }
/* 136 */         return false;
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 141 */     else if (id == TFCBlocks.ice) {
/*     */       
/* 143 */       int chance = (int)Math.floor(Math.max(1.0F, 6.0F - temp));
/* 144 */       if (id == TFCBlocks.ice && this.field_76579_a.field_73012_v.nextInt(chance) == 0)
/*     */       {
/* 146 */         if (this.field_76579_a.func_147439_a(x, y + 1, z) == Blocks.field_150433_aE) {
/*     */           
/* 148 */           int m = this.field_76579_a.func_72805_g(x, y + 1, z);
/* 149 */           if (m > 0)
/*     */           {
/* 151 */             this.field_76579_a.func_72921_c(x, y + 1, z, m - 1, 2);
/*     */           }
/*     */           else
/*     */           {
/* 155 */             this.field_76579_a.func_147468_f(x, y + 1, z);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 160 */           int flag = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 165 */           if ((meta & 0x1) == 0) {
/*     */             
/* 167 */             this.field_76579_a.func_147465_d(x, y, z, TFCBlocks.saltWaterStationary, 0, flag);
/*     */           }
/* 169 */           else if ((meta & 0x1) == 1) {
/*     */             
/* 171 */             this.field_76579_a.func_147465_d(x, y, z, TFCBlocks.freshWaterStationary, 0, flag);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDoRainSnowIce(Chunk chunk) {
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
/* 189 */     if (TFC_Climate.getHeightAdjustedTemp(this.field_76579_a, x, y, z) > 0.0F)
/* 190 */       return false; 
/* 191 */     Material material = this.field_76579_a.func_147439_a(x, y, z).func_149688_o();
/* 192 */     if (material == Material.field_151597_y) {
/* 193 */       return false;
/*     */     }
/* 195 */     return (TFCBlocks.snow.func_149742_c(this.field_76579_a, x, y, z) && material.func_76222_j());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_80007_l() {
/* 208 */     return "DEFAULT";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkCoordinates func_76554_h() {
/* 217 */     return getSpawnPoint();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */