/*     */ package com.bioxx.tfc.Handlers;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenGrowCrops;
/*     */ import com.bioxx.tfc.WorldGen.WorldCacheManager;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
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
/*  35 */     if (!event.world.field_72995_K && TFC_Core.getCDM(event.world) != null && event.getChunk() != null) {
/*     */       
/*  37 */       ChunkData cd = TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h);
/*  38 */       if (cd == null)
/*     */         return; 
/*  40 */       BiomeGenBase biome = event.world.func_72807_a((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h);
/*  41 */       int month = TFC_Time.getSeasonAdjustedMonth((event.getChunk()).field_76647_h << 4);
/*  42 */       if (TFC_Time.getYear() > cd.lastSpringGen && month > 1 && month < 6) {
/*     */         
/*  44 */         int chunkX = (event.getChunk()).field_76635_g;
/*  45 */         int chunkZ = (event.getChunk()).field_76647_h;
/*  46 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/*  48 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/*  49 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */         } 
/*  51 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */         
/*  53 */         Random rand = new Random(event.world.func_72905_C() + (((chunkX >> 3) - (chunkZ >> 3)) * (chunkZ >> 3)));
/*  54 */         int cropid = rand.nextInt(CropManager.getInstance().getTotalCrops());
/*  55 */         CropIndex crop = CropManager.getInstance().getCropFromId(cropid);
/*  56 */         if (event.world.field_73012_v.nextInt(25) == 0 && crop != null)
/*     */         {
/*  58 */           int num = 1 + event.world.field_73012_v.nextInt(5);
/*  59 */           WorldGenGrowCrops cropGen = new WorldGenGrowCrops(cropid);
/*  60 */           int x = (chunkX << 4) + event.world.field_73012_v.nextInt(16) + 8;
/*  61 */           int z = (chunkZ << 4) + event.world.field_73012_v.nextInt(16) + 8;
/*  62 */           cropGen.generate(event.world, event.world.field_73012_v, x, z, num);
/*     */         }
/*     */       
/*  65 */       } else if (TFC_Time.getYear() > cd.lastSpringGen && month >= 6) {
/*     */ 
/*     */         
/*  68 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/*  70 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/*  71 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */         } 
/*  73 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */       }
/*  75 */       else if (TFC_Time.getYear() > cd.lastSpringGen + 1) {
/*     */         
/*  77 */         if (TFC_Core.isWaterBiome(biome)) {
/*     */           
/*  79 */           cd.fishPop = (float)(cd.fishPop * Math.pow(1.2D, (cd.lastSpringGen - TFC_Time.getYear())));
/*  80 */           cd.fishPop = Math.min(cd.fishPop, 60.0F);
/*     */         } 
/*  82 */         cd.lastSpringGen = TFC_Time.getYear();
/*     */       }
/*     */     
/*  85 */     } else if (TFC_Core.getCDM(event.world) != null && TFC_Climate.getCacheManager(event.world) != null) {
/*     */       
/*  87 */       Chunk chunk = event.getChunk();
/*  88 */       ChunkData data = (new ChunkData(chunk)).createNew(event.world, chunk.field_76635_g, chunk.field_76647_h);
/*  89 */       data.rainfallMap = TFC_Climate.getCacheManager(event.world).loadRainfallLayerGeneratorData(data.rainfallMap, (event.getChunk()).field_76635_g * 16, (event.getChunk()).field_76647_h * 16, 16, 16);
/*  90 */       TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onUnload(ChunkEvent.Unload event) {
/*  97 */     if (TFC_Core.getCDM(event.world) != null && 
/*  98 */       TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h) != null) {
/*  99 */       (TFC_Core.getCDM(event.world).getData((event.getChunk()).field_76635_g, (event.getChunk()).field_76647_h)).isUnloaded = true;
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onUnloadWorld(WorldEvent.Unload event) {
/* 105 */     TFC_Climate.removeCacheManager(event.world);
/* 106 */     TFC_Core.removeCDM(event.world);
/* 107 */     if (event.world.field_73011_w.field_76574_g == 0) {
/* 108 */       AnvilManager.getInstance().clearRecipes();
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLoadWorld(WorldEvent.Load event) {
/* 114 */     if (event.world.field_73011_w.field_76574_g == 0 && event.world.func_82737_E() < 100L)
/* 115 */       createSpawn(event.world); 
/* 116 */     if (!event.world.field_72995_K && event.world.field_73011_w.field_76574_g == 0 && AnvilManager.getInstance().getRecipeList().size() == 0)
/*     */     {
/* 118 */       TFC_Core.setupWorld(event.world);
/*     */     }
/* 120 */     TFC_Climate.worldPair.put(event.world, new WorldCacheManager(event.world));
/* 121 */     TFC_Core.addCDM(event.world);
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onDataLoad(ChunkDataEvent.Load event) {
/* 127 */     if (!event.world.field_72995_K) {
/*     */       
/* 129 */       NBTTagCompound eventTag = event.getData();
/*     */       
/* 131 */       Chunk chunk = event.getChunk();
/* 132 */       if (eventTag.func_74764_b("ChunkData")) {
/*     */         
/* 134 */         NBTTagCompound spawnProtectionTag = eventTag.func_74775_l("ChunkData");
/* 135 */         ChunkData data = new ChunkData(chunk, spawnProtectionTag);
/* 136 */         if (TFC_Core.getCDM(event.world) != null) {
/* 137 */           TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */         
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 143 */         NBTTagCompound levelTag = eventTag.func_74775_l("Level");
/* 144 */         ChunkData data = (new ChunkData(chunk)).createNew(event.world, levelTag.func_74762_e("xPos"), levelTag.func_74762_e("zPos"));
/* 145 */         if (TFC_Core.getCDM(event.world) != null) {
/* 146 */           TFC_Core.getCDM(event.world).addData(chunk, data);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onDataSave(ChunkDataEvent.Save event) {
/* 154 */     if (!event.world.field_72995_K && TFC_Core.getCDM(event.world) != null) {
/*     */       
/* 156 */       NBTTagCompound levelTag = event.getData().func_74775_l("Level");
/* 157 */       int x = levelTag.func_74762_e("xPos");
/* 158 */       int z = levelTag.func_74762_e("zPos");
/* 159 */       ChunkData data = TFC_Core.getCDM(event.world).getData(x, z);
/*     */       
/* 161 */       if (data != null) {
/*     */         
/* 163 */         NBTTagCompound spawnProtectionTag = data.getTag();
/*     */ 
/*     */         
/* 166 */         event.getData().func_74782_a("ChunkData", (NBTBase)spawnProtectionTag);
/* 167 */         if (data.isUnloaded) {
/* 168 */           TFC_Core.getCDM(event.world).removeData(x, z);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private ChunkCoordinates createSpawn(World world) {
/* 175 */     List biomeList = world.func_72959_q().func_76932_a();
/* 176 */     long seed = world.func_72912_H().func_76063_b();
/* 177 */     Random rand = new Random(seed);
/*     */     
/* 179 */     ChunkPosition chunkCoord = null;
/* 180 */     int xOffset = 0;
/* 181 */     int xCoord = 0;
/*     */     
/* 183 */     int zCoord = 10000;
/* 184 */     int startingZ = 5000 + rand.nextInt(10000);
/*     */     
/* 186 */     while (chunkCoord == null) {
/*     */       
/* 188 */       chunkCoord = world.func_72959_q().func_150795_a(xOffset, -startingZ, 64, biomeList, rand);
/* 189 */       if (chunkCoord != null) {
/*     */         
/* 191 */         xCoord = chunkCoord.field_151329_a;
/* 192 */         zCoord = chunkCoord.field_151328_c;
/*     */         
/*     */         continue;
/*     */       } 
/* 196 */       xOffset += 64;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 201 */     int var9 = 0;
/* 202 */     while (!world.field_73011_w.func_76566_a(xCoord, zCoord)) {
/*     */       
/* 204 */       xCoord += rand.nextInt(16) - rand.nextInt(16);
/* 205 */       zCoord += rand.nextInt(16) - rand.nextInt(16);
/* 206 */       var9++;
/* 207 */       if (var9 == 1000) {
/*     */         break;
/*     */       }
/*     */     } 
/* 211 */     WorldInfo info = world.func_72912_H();
/* 212 */     info.func_76081_a(xCoord, world.func_72825_h(xCoord, zCoord), zCoord);
/* 213 */     if (!info.func_76066_a().func_74764_b("superseed"))
/* 214 */       info.func_76066_a().func_74772_a("superseed", System.currentTimeMillis()); 
/* 215 */     return new ChunkCoordinates(xCoord, world.func_72825_h(xCoord, zCoord), zCoord);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\ChunkEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */