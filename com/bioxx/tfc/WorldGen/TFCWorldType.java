/*    */ package com.bioxx.tfc.WorldGen;
/*    */ 
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldType;
/*    */ import net.minecraft.world.biome.WorldChunkManager;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TFCWorldType
/*    */   extends WorldType
/*    */ {
/*    */   public static TFCWorldType defaultWorldType;
/*    */   public static TFCWorldType flatWorldType;
/* 18 */   private static final TFCBiome[] BIOMES_UNKNOWN = new TFCBiome[] { TFCBiome.OCEAN };
/*    */ 
/*    */   
/* 21 */   private static final TFCBiome[] BIOMES_FLAT = new TFCBiome[] { TFCBiome.HELL };
/*    */ 
/*    */   
/* 24 */   private static final TFCBiome[] BIOMES_DEFAULT = new TFCBiome[] { TFCBiome.OCEAN, TFCBiome.HIGH_HILLS, TFCBiome.PLAINS, TFCBiome.HIGH_PLAINS, TFCBiome.SWAMPLAND, TFCBiome.ROLLING_HILLS, TFCBiome.MOUNTAINS };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TFCWorldType(int i, String par2Str) {
/* 36 */     super(i, par2Str);
/*    */   }
/*    */ 
/*    */   
/*    */   public TFCWorldType(String par2Str) {
/* 41 */     super(par2Str);
/*    */   }
/*    */ 
/*    */   
/*    */   public TFCBiome[] getBiomesForWorldType() {
/* 46 */     if (this == defaultWorldType)
/* 47 */       return (TFCBiome[])BIOMES_DEFAULT.clone(); 
/* 48 */     if (this == flatWorldType) {
/* 49 */       return (TFCBiome[])BIOMES_FLAT.clone();
/*    */     }
/* 51 */     return (TFCBiome[])BIOMES_UNKNOWN.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WorldChunkManager getChunkManager(World world) {
/* 58 */     if (this == flatWorldType)
/*    */     {
/*    */ 
/*    */       
/* 62 */       return new TFCWorldChunkManagerHell(TFCBiome.HELL, 0.5F, 0.5F, world);
/*    */     }
/*    */ 
/*    */     
/* 66 */     return new TFCWorldChunkManager(world);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
/* 73 */     return (IChunkProvider)new TFCChunkProviderGenerate(world, world.func_72905_C(), world.func_72912_H().func_76089_r());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMinimumSpawnHeight(World world) {
/* 79 */     return 145;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double getHorizon(World world) {
/* 85 */     return 144.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCWorldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */