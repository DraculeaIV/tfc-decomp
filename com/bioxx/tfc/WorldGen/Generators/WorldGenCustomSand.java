/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.WorldGen.DataLayer;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenCustomSand
/*    */   extends WorldGenerator
/*    */ {
/*    */   private Block sandBlock;
/*    */   private int radius;
/*    */   
/*    */   public WorldGenCustomSand(int par1, Block par2) {
/* 24 */     this.sandBlock = par2;
/* 25 */     this.radius = par1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random par2Random, int x, int y, int z) {
/* 31 */     if (world.func_147439_a(x, y, z).func_149688_o() != Material.field_151586_h)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 37 */     DataLayer dl = TFC_Climate.getRockLayer(world, x, y, z, 0);
/* 38 */     this.sandBlock = TFC_Core.getTypeForSand(dl.data1);
/* 39 */     int var6 = par2Random.nextInt(this.radius - 2) + 2;
/* 40 */     byte var7 = 2;
/*    */     
/* 42 */     for (int var8 = x - var6; var8 <= x + var6; var8++) {
/*    */       
/* 44 */       for (int var9 = z - var6; var9 <= z + var6; var9++) {
/*    */         
/* 46 */         int var10 = var8 - x;
/* 47 */         int var11 = var9 - z;
/* 48 */         if (var10 * var10 + var11 * var11 <= var6 * var6)
/*    */         {
/* 50 */           for (int var12 = y - var7; var12 <= y + var7; var12++) {
/*    */             
/* 52 */             Block var13 = world.func_147439_a(var8, var12, var9);
/* 53 */             boolean notCorrectSoil = (!TFC_Core.isSoil(var13) && !TFC_Core.isSand(var13));
/* 54 */             if (!notCorrectSoil)
/* 55 */               world.func_147465_d(var8, var12, var9, this.sandBlock, dl.data2, 2); 
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenCustomSand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */