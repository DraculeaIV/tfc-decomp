/*     */ package com.bioxx.tfc.Chunkdata;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ 
/*     */ public class ChunkData
/*     */ {
/*     */   public int chunkX;
/*     */   public int chunkZ;
/*     */   public long lastVisited;
/*     */   public long previousVisit;
/*     */   public int spawnProtection;
/*  18 */   public int protectionBuffer = (TFCOptions.protectionBuffer >= 0) ? (TFCOptions.protectionBuffer * -1) : -24;
/*     */   
/*     */   public int[] heightmap;
/*     */   
/*     */   public DataLayer[] rainfallMap;
/*     */   public int sluicedAmount;
/*  24 */   public float fishPop = -1.0F;
/*     */   
/*     */   public static final float FISH_POP_MAX = 60.0F;
/*     */   
/*     */   public int lastSpringGen;
/*     */   
/*     */   public int cropInfestation;
/*     */   public boolean isUnloaded;
/*     */   private final Chunk chunk;
/*     */   
/*     */   public ChunkData(Chunk chunk) {
/*  35 */     this.chunk = chunk;
/*     */     
/*  37 */     this.heightmap = new int[256];
/*  38 */     this.rainfallMap = new DataLayer[256];
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkData(Chunk chunk, NBTTagCompound tag) {
/*  43 */     this.chunk = chunk;
/*     */     
/*  45 */     this.chunkX = tag.func_74762_e("chunkX");
/*  46 */     this.chunkZ = tag.func_74762_e("chunkZ");
/*  47 */     this.lastVisited = tag.func_74763_f("lastVisited");
/*  48 */     this.spawnProtection = tag.func_74762_e("spawnProtection");
/*     */     
/*  50 */     updateSpawnProtection();
/*     */     
/*  52 */     this.heightmap = tag.func_74759_k("heightmap");
/*  53 */     if (this.heightmap.length == 0)
/*  54 */       this.heightmap = new int[256]; 
/*  55 */     this.sluicedAmount = tag.func_74762_e("sluicedAmount");
/*     */     
/*  57 */     this.lastSpringGen = tag.func_74762_e("lastSpringGen");
/*  58 */     this.cropInfestation = tag.func_74762_e("cropInfestation");
/*     */     
/*  60 */     this.fishPop = Math.min(tag.func_74760_g("fishPopulation"), 60.0F);
/*  61 */     this.rainfallMap = new DataLayer[256];
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound getTag() {
/*  66 */     NBTTagCompound tag = new NBTTagCompound();
/*     */     
/*  68 */     tag.func_74768_a("chunkX", this.chunkX);
/*  69 */     tag.func_74768_a("chunkZ", this.chunkZ);
/*     */     
/*  71 */     updateSpawnProtection();
/*     */     
/*  73 */     tag.func_74768_a("spawnProtection", this.spawnProtection);
/*  74 */     tag.func_74772_a("lastVisited", this.lastVisited);
/*  75 */     tag.func_74783_a("heightmap", this.heightmap);
/*  76 */     tag.func_74768_a("lastSpringGen", this.lastSpringGen);
/*  77 */     tag.func_74768_a("sluicedAmount", this.sluicedAmount);
/*  78 */     tag.func_74768_a("cropInfestation", this.cropInfestation);
/*  79 */     tag.func_74776_a("fishPopulation", Math.max(this.fishPop, -1.0F));
/*  80 */     return tag;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkData createNew(World world, int x, int z) {
/*  85 */     this.chunkX = x;
/*  86 */     this.chunkZ = z;
/*  87 */     this.lastVisited = 0L;
/*  88 */     this.spawnProtection = this.protectionBuffer;
/*  89 */     this.lastSpringGen = TFC_Time.getYear();
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSpawnProtectionWithUpdate() {
/*  95 */     updateSpawnProtection();
/*     */     
/*  97 */     if (this.spawnProtection > 24 * TFC_Time.daysInMonth * TFCOptions.maxProtectionMonths) {
/*  98 */       this.spawnProtection = 24 * TFC_Time.daysInMonth * TFCOptions.maxProtectionMonths;
/*     */     }
/* 100 */     return this.spawnProtection;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSpawnProtectionWithUpdate(int amount) {
/* 105 */     updateSpawnProtection();
/*     */     
/* 107 */     this.spawnProtection += amount;
/*     */     
/* 109 */     if (this.spawnProtection > 24 * TFC_Time.daysInMonth * TFCOptions.maxProtectionMonths) {
/* 110 */       this.spawnProtection = 24 * TFC_Time.daysInMonth * TFCOptions.maxProtectionMonths;
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateSpawnProtection() {
/* 115 */     long now = TFC_Time.getTotalTicks();
/*     */     
/* 117 */     if (this.lastVisited < now) {
/*     */       
/* 119 */       long visit = (now - this.lastVisited) / 1000L;
/* 120 */       this.spawnProtection = (int)(this.spawnProtection - visit);
/* 121 */       this.lastVisited += visit * 1000L;
/*     */       
/* 123 */       if (this.spawnProtection < this.protectionBuffer) {
/* 124 */         this.spawnProtection = this.protectionBuffer;
/*     */       }
/* 126 */       this.chunk.func_76630_e();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void infest() {
/* 132 */     Math.min(this.cropInfestation++, 10);
/*     */   }
/*     */ 
/*     */   
/*     */   public void uninfest() {
/* 137 */     Math.max(this.cropInfestation--, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getRainfall(int x, int z) {
/* 147 */     if (this.rainfallMap[x * z] != null) {
/* 148 */       return (this.rainfallMap[x * z]).floatdata1;
/*     */     }
/* 150 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Chunkdata\ChunkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */