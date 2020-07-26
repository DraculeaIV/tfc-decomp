/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenCustomPumpkin
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 17 */     for (int var6 = 0; var6 < 64; var6++) {
/*    */       
/* 19 */       int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
/* 20 */       int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
/* 21 */       int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
/* 22 */       Block var5 = par1World.func_147439_a(var7, var8 - 1, var9);
/* 23 */       if (par1World.func_147437_c(var7, var8, var9) && TFC_Core.isSoil(var5) && TFCBlocks.pumpkin.func_149742_c(par1World, var7, var8, var9))
/*    */       {
/* 25 */         par1World.func_147465_d(var7, var8, var9, TFCBlocks.pumpkin, par2Random.nextInt(4), 2);
/*    */       }
/*    */     } 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenCustomPumpkin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */