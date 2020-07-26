/*     */ package com.bioxx.tfc.WorldGen;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SpawnerAnimalsTFC
/*     */ {
/*     */   public static boolean canCreatureTypeSpawnAtLocation(EnumCreatureType par0EnumCreatureType, World par1World, int par2, int par3, int par4) {
/*  28 */     if (par0EnumCreatureType.func_75600_c() == Material.field_151586_h)
/*     */     {
/*  30 */       return (par1World.func_147439_a(par2, par3, par4).func_149688_o().func_76224_d() && par1World
/*  31 */         .func_147439_a(par2, par3 - 1, par4).func_149688_o().func_76224_d() && 
/*  32 */         !par1World.func_147439_a(par2, par3 + 1, par4).func_149721_r());
/*     */     }
/*  34 */     if (!World.func_147466_a((IBlockAccess)par1World, par2, par3 - 1, par4))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  40 */     Block b = par1World.func_147439_a(par2, par3 - 1, par4);
/*  41 */     boolean spawnBlock = (b != null && b.canCreatureSpawn(par0EnumCreatureType, (IBlockAccess)par1World, par2, par3 - 1, par4));
/*  42 */     return (spawnBlock && b != Blocks.field_150357_h && 
/*  43 */       !par1World.func_147439_a(par2, par3, par4).func_149721_r() && 
/*  44 */       !par1World.func_147439_a(par2, par3, par4).func_149688_o().func_76224_d() && 
/*  45 */       !par1World.func_147439_a(par2, par3 + 1, par4).func_149721_r());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void performWorldGenSpawning(World world, TFCBiome biome, int par2, int par3, int par4, int par5, Random par6Random) {
/*  54 */     List<BiomeGenBase.SpawnListEntry> list = TFCChunkProviderGenerate.getCreatureSpawnsByChunk(world, biome, par2, par3);
/*  55 */     if (!list.isEmpty())
/*     */     {
/*  57 */       while (par6Random.nextFloat() < biome.func_76741_f()) {
/*     */         
/*  59 */         BiomeGenBase.SpawnListEntry spawnlistentry = (BiomeGenBase.SpawnListEntry)WeightedRandom.func_76271_a(world.field_73012_v, list);
/*  60 */         IEntityLivingData entitylivingdata = null;
/*  61 */         int i1 = spawnlistentry.field_76301_c + par6Random.nextInt(1 + spawnlistentry.field_76299_d - spawnlistentry.field_76301_c);
/*  62 */         int j1 = par2 + par6Random.nextInt(par4);
/*  63 */         int k1 = par3 + par6Random.nextInt(par5);
/*  64 */         int l1 = j1;
/*  65 */         int i2 = k1;
/*     */         
/*  67 */         for (int j2 = 0; j2 < i1; j2++) {
/*     */           
/*  69 */           boolean flag = false;
/*  70 */           for (int k2 = 0; !flag && k2 < 4; k2++) {
/*     */             
/*  72 */             int l2 = world.func_72825_h(j1, k1);
/*  73 */             if (canCreatureTypeSpawnAtLocation(EnumCreatureType.creature, world, j1, l2, k1)) {
/*     */               EntityLiving entityliving;
/*     */ 
/*     */               
/*     */               try {
/*  78 */                 entityliving = spawnlistentry.field_76300_b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
/*     */               }
/*  80 */               catch (Exception exception) {
/*     */                 
/*  82 */                 TerraFirmaCraft.LOG.catching(exception);
/*     */               } 
/*     */               
/*  85 */               if (entityliving instanceof com.bioxx.tfc.Entities.Mobs.EntityFishTFC && 
/*  86 */                 entityliving.func_70681_au().nextInt(60) > TFC_Core.getCDM(world).getFishPop(j1 >> 4, k1 >> 4)) {
/*     */                 return;
/*     */               }
/*     */ 
/*     */               
/*  91 */               float f = j1 + 0.5F;
/*  92 */               float f1 = l2;
/*  93 */               float f2 = k1 + 0.5F;
/*  94 */               entityliving.func_70012_b(f, f1, f2, par6Random.nextFloat() * 360.0F, 0.0F);
/*  95 */               world.func_72838_d((Entity)entityliving);
/*  96 */               entitylivingdata = entityliving.func_110161_a(entitylivingdata);
/*  97 */               flag = true;
/*     */             } 
/*     */             
/* 100 */             j1 += par6Random.nextInt(5) - par6Random.nextInt(5);
/* 101 */             k1 += par6Random.nextInt(5) - par6Random.nextInt(5);
/* 102 */             for (; j1 < par2 || j1 >= par2 + par4 || k1 < par3 || k1 >= par3 + par4; 
/* 103 */               k1 = i2 + par6Random.nextInt(5) - par6Random.nextInt(5))
/*     */             {
/* 105 */               j1 = l1 + par6Random.nextInt(5) - par6Random.nextInt(5);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\SpawnerAnimalsTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */