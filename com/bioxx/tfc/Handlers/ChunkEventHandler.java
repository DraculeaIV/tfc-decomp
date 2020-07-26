/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenGrowCrops;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenPlants;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenWaterPlants;
/*     */ import com.bioxx.tfc.WorldGen.WorldCacheManager;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import net.minecraftforge.event.world.ChunkDataEvent;
/*     */ import net.minecraftforge.event.world.ChunkEvent;
/*     */ import net.minecraftforge.event.world.WorldEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkEventHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onLoad(ChunkEvent.Load event) {
/*  38 */     if (!event.world.field_72995_K && TFC_Core.getCDM(event.world) != null && event.getChunk() != null) {
/*     */       
/*  40 */       ChunkData cd = TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h);
/*  41 */       if (cd == null)
/*     */         return; 
/*  43 */       BiomeGenBase biome = event.world.func_72807_a((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h);
/*  44 */       int month = TFC_Time.getSeasonAdjustedMonth((event.getChunk()).field_76647_h << 4);
/*  45 */       if (TFC_Time.getYear() > cd.lastSpringGen && month > 1 && month < 6)
/*     */       {
/*  47 */         int chunkX = (event.getChunk()).field_76635_g;
/*  48 */         int chunkZ = (event.getChunk()).field_76647_h;
/*  49 */         Random rand = new Random(event.world.func_72905_C() + (((chunkX >> 3) - (chunkZ >> 3)) * (chunkZ >> 3)));
/*     */         
/*  51 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/*  53 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/*  54 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */           
/*  56 */           if (rand.nextInt(50) == 0) {
/*     */             
/*  58 */             int waterPlantsPerChunk = 10;
/*     */             
/*  60 */             for (int var2 = 0; var2 < waterPlantsPerChunk; var2++) {
/*     */               
/*  62 */               int xCoord = (chunkX << 4) + rand.nextInt(16) + 8;
/*  63 */               int zCoord = (chunkZ << 4) + rand.nextInt(16) + 8;
/*  64 */               int yCoord = event.world.func_72874_g(xCoord, zCoord) - 1;
/*  65 */               if (TFC_Climate.getBioTemperatureHeight(event.world, xCoord, yCoord, zCoord) >= 7.0F)
/*  66 */                 (new WorldGenWaterPlants(TFCBlocks.waterPlant)).func_76484_a(event.world, rand, xCoord, yCoord, zCoord); 
/*     */             } 
/*     */           } 
/*     */         } 
/*  70 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */ 
/*     */         
/*  73 */         int cropid = rand.nextInt(CropManager.getInstance().getTotalCrops());
/*  74 */         CropIndex crop = CropManager.getInstance().getCropFromId(cropid);
/*  75 */         if (event.world.field_73012_v.nextInt(25) == 0 && crop != null) {
/*     */           
/*  77 */           int num = 1 + event.world.field_73012_v.nextInt(5);
/*  78 */           WorldGenGrowCrops cropGen = new WorldGenGrowCrops(cropid);
/*  79 */           int x = (chunkX << 4) + event.world.field_73012_v.nextInt(16) + 8;
/*  80 */           int z = (chunkZ << 4) + event.world.field_73012_v.nextInt(16) + 8;
/*  81 */           cropGen.generate(event.world, event.world.field_73012_v, x, z, num);
/*     */         } 
/*     */         
/*  84 */         if (event.world.field_73012_v.nextInt(500) == 0)
/*     */         {
/*  86 */           WorldGenPlants plants = new WorldGenPlants();
/*  87 */           plants.genBushes(rand, chunkX, chunkZ, event.world);
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/*  93 */       else if (TFC_Time.getYear() > cd.lastSpringGen && month >= 6)
/*     */       {
/*     */         
/*  96 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/*  98 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/*  99 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */         } 
/* 101 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */       }
/* 103 */       else if (TFC_Time.getYear() > cd.lastSpringGen + 1)
/*     */       {
/* 105 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/* 107 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/* 108 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */         } 
/* 110 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */       }
/*     */     
/* 113 */     } else if (TFC_Core.getCDM(event.world) != null && TFC_Climate.getCacheManager(event.world) != null) {
/*     */       
/* 115 */       Chunk chunk = event.getChunk();
/* 116 */       ChunkData data = (new ChunkData(chunk)).createNew(event.world, chunk.field_76635_g, chunk.field_76647_h);
/* 117 */       data.rainfallMap = TFC_Climate.getCacheManager(event.world).loadRainfallLayerGeneratorData(data.rainfallMap, (event.getChunk()).field_76635_g * 16, (event.getChunk()).field_76647_h * 16, 16, 16);
/* 118 */       TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onUnload(ChunkEvent.Unload event) {
/* 125 */     if (TFC_Core.getCDM(event.world) != null && 
/* 126 */       TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h) != null) {
/* 127 */       (TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h)).isUnloaded = true;
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onUnloadWorld(WorldEvent.Unload event) {
/* 133 */     TFC_Climate.removeCacheManager(event.world);
/* 134 */     TFC_Core.removeCDM(event.world);
/* 135 */     if (event.world.field_73011_w.field_76574_g == 0) {
/* 136 */       AnvilManager.getInstance().clearRecipes();
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLoadWorld(WorldEvent.Load event) {
/* 142 */     if (!event.world.field_72995_K) {
/*     */       
/* 144 */       if (event.world.field_73011_w.field_76574_g == 0 && event.world.func_82737_E() < 100L)
/* 145 */         createSpawn(event.world); 
/* 146 */       if (!event.world.field_72995_K && event.world.field_73011_w.field_76574_g == 0 && AnvilManager.getInstance().getRecipeList().size() == 0)
/*     */       {
/* 148 */         TFC_Core.setupWorld(event.world);
/*     */       }
/* 150 */       TFC_Climate.worldPair.put(event.world, new WorldCacheManager(event.world));
/* 151 */       TFC_Core.addCDM(event.world);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onDataLoad(ChunkDataEvent.Load event) {
/* 158 */     if (!event.world.field_72995_K) {
/*     */       
/* 160 */       NBTTagCompound eventTag = event.getData();
/*     */       
/* 162 */       Chunk chunk = event.getChunk();
/* 163 */       if (eventTag.func_74764_b("ChunkData")) {
/*     */         
/* 165 */         NBTTagCompound spawnProtectionTag = eventTag.func_74775_l("ChunkData");
/* 166 */         ChunkData data = new ChunkData(chunk, spawnProtectionTag);
/* 167 */         if (TFC_Core.getCDM(event.world) != null) {
/* 168 */           TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 174 */         NBTTagCompound levelTag = eventTag.func_74775_l("Level");
/* 175 */         ChunkData data = (new ChunkData(chunk)).createNew(event.world, levelTag.func_74762_e("xPos"), levelTag.func_74762_e("zPos"));
/* 176 */         if (TFC_Core.getCDM(event.world) != null) {
/* 177 */           TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onDataSave(ChunkDataEvent.Save event) {
/* 185 */     if (!event.world.field_72995_K && TFC_Core.getCDM(event.world) != null) {
/*     */       
/* 187 */       NBTTagCompound levelTag = event.getData().func_74775_l("Level");
/* 188 */       int x = levelTag.func_74762_e("xPos");
/* 189 */       int z = levelTag.func_74762_e("zPos");
/* 190 */       ChunkData data = TFC_Core.getCDM(event.world).getData(x, z);
/*     */       
/* 192 */       if (data != null) {
/*     */         
/* 194 */         NBTTagCompound spawnProtectionTag = data.getTag();
/*     */ 
/*     */         
/* 197 */         event.getData().func_74782_a("ChunkData", (NBTBase)spawnProtectionTag);
/* 198 */         if (data.isUnloaded) {
/* 199 */           TFC_Core.getCDM(event.world).removeData(x, z);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private ChunkCoordinates createSpawn(World world) {
/* 206 */     List biomeList = world.func_72959_q().func_76932_a();
/* 207 */     long seed = world.func_72912_H().func_76063_b();
/* 208 */     Random rand = new Random(seed);
/*     */     
/* 210 */     ChunkPosition chunkCoord = null;
/* 211 */     int xOffset = 0;
/* 212 */     int xCoord = 0;
/*     */     
/* 214 */     int zCoord = 10000;
/* 215 */     int startingZ = 5000 + rand.nextInt(10000);
/*     */     
/* 217 */     while (chunkCoord == null) {
/*     */       
/* 219 */       chunkCoord = world.func_72959_q().func_150795_a(xOffset, -startingZ, 64, biomeList, rand);
/* 220 */       if (chunkCoord != null) {
/*     */         
/* 222 */         xCoord = chunkCoord.field_151329_a;
/* 223 */         zCoord = chunkCoord.field_151328_c;
/*     */         
/*     */         continue;
/*     */       } 
/* 227 */       xOffset += 64;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 232 */     int var9 = 0;
/* 233 */     while (!world.field_73011_w.func_76566_a(xCoord, zCoord)) {
/*     */       
/* 235 */       xCoord += rand.nextInt(16) - rand.nextInt(16);
/* 236 */       zCoord += rand.nextInt(16) - rand.nextInt(16);
/* 237 */       var9++;
/* 238 */       if (var9 == 1000) {
/*     */         break;
/*     */       }
/*     */     } 
/* 242 */     WorldInfo info = world.func_72912_H();
/* 243 */     info.func_76081_a(xCoord, world.func_72825_h(xCoord, zCoord), zCoord);
/* 244 */     if (!info.func_76066_a().func_74764_b("superseed"))
/* 245 */       info.func_76066_a().func_74772_a("superseed", System.currentTimeMillis()); 
/* 246 */     return new ChunkCoordinates(xCoord, world.func_72825_h(xCoord, zCoord), zCoord);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\ChunkEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */