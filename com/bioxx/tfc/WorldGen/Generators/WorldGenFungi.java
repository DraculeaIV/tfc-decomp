/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenFungi
/*    */   extends WorldGenerator
/*    */ {
/*    */   private int meta;
/*    */   
/*    */   public boolean genWithMeta(World world, Random rnd, int x, int y, int z, int m) {
/* 20 */     this.meta = m;
/* 21 */     return func_76484_a(world, rnd, x, y, z);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World world, Random rnd, int x, int y, int z) {
/* 27 */     for (int l = 0; l < 2; l++) {
/*    */       
/* 29 */       int i = x + rnd.nextInt(8) - rnd.nextInt(8);
/* 30 */       int j = y + rnd.nextInt(4) - rnd.nextInt(4);
/* 31 */       int k = z + rnd.nextInt(8) - rnd.nextInt(8);
/*    */       
/* 33 */       if (world.func_147437_c(i, j, k) && TFCBlocks.fungi.func_149718_j(world, i, j, k))
/*    */       {
/* 35 */         world.func_147465_d(i, j, k, TFCBlocks.fungi, this.meta, 2);
/*    */       }
/*    */     } 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenFungi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */