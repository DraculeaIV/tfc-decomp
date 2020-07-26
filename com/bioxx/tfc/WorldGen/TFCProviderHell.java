/*    */ package com.bioxx.tfc.WorldGen;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.ChunkProviderHell;
/*    */ import net.minecraft.world.storage.WorldInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TFCProviderHell
/*    */   extends TFCProvider
/*    */ {
/*    */   protected void func_76572_b() {
/* 19 */     this.field_76578_c = new TFCWorldChunkManagerHell(TFCBiome.HELL, 1.0F, 1.0F, this.field_76579_a);
/* 20 */     if (this.field_76579_a.field_72995_K) {
/* 21 */       TFC_Climate.worldPair.put(this.field_76579_a, new WorldCacheManager(this.field_76579_a));
/*    */     } else {
/* 23 */       TFC_Climate.worldPair.put(this.field_76579_a, new WorldCacheManager(this.field_76579_a));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_76556_a() {
/* 29 */     float var1 = 0.1F;
/* 30 */     for (int var2 = 0; var2 <= 15; var2++) {
/*    */       
/* 32 */       float var3 = 1.0F - var2 / 15.0F;
/* 33 */       this.field_76573_f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IChunkProvider func_76555_c() {
/* 40 */     return (IChunkProvider)new ChunkProviderHell(this.field_76579_a, this.field_76579_a.func_72905_C());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ChunkCoordinates getSpawnPoint() {
/* 46 */     WorldInfo info = this.field_76579_a.func_72912_H();
/* 47 */     return new ChunkCoordinates(info.func_76079_c(), info.func_76075_d(), info.func_76074_e());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76569_d() {
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76566_a(int par1, int par2) {
/* 59 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float func_76563_a(long par1, float par3) {
/* 65 */     return 0.5F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76567_e() {
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_76568_b(int par1, int par2) {
/* 78 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String func_80007_l() {
/* 84 */     return "Nether";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Vec3 func_76562_b(float par1, float par2) {
/* 90 */     return Vec3.func_72443_a(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\TFCProviderHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */