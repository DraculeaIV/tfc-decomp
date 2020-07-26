/*    */ package com.bioxx.tfc.WorldGen.Generators;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import java.util.Random;
/*    */ import net.minecraft.util.Direction;
/*    */ import net.minecraft.util.Facing;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenCustomVines
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean func_76484_a(World world, Random r, int x, int y, int z) {
/* 18 */     int var6 = x;
/* 19 */     int var7 = z;
/*    */     
/* 21 */     for (; y > 144; y--) {
/*    */       
/* 23 */       if (world.func_147437_c(x, y, z)) {
/*    */         
/* 25 */         for (int var8 = 2; var8 <= 5; var8++) {
/*    */           
/* 27 */           if (TFCBlocks.vine.func_149707_d(world, x, y, z, var8)) {
/*    */             
/* 29 */             world.func_147465_d(x, y, z, TFCBlocks.vine, 1 << Direction.field_71579_d[Facing.field_71588_a[var8]], 2);
/*    */ 
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } else {
/* 36 */         x = var6 + r.nextInt(4) - r.nextInt(4);
/* 37 */         z = var7 + r.nextInt(4) - r.nextInt(4);
/*    */       } 
/*    */     } 
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean generate2(World world, Random random, int x, int y, int z) {
/* 45 */     int oldX = x;
/*    */     
/* 47 */     for (int i1 = z; y < 256; y++) {
/*    */       
/* 49 */       if (world.func_147437_c(x, y, z)) {
/*    */         
/* 51 */         for (int side = 2; side <= 5; side++) {
/*    */           
/* 53 */           if (TFCBlocks.vine.func_149707_d(world, x, y, z, side)) {
/*    */             
/* 55 */             world.func_147465_d(x, y, z, TFCBlocks.vine, 1 << Direction.field_71579_d[Facing.field_71588_a[side]], 2);
/*    */ 
/*    */             
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } else {
/* 62 */         x = oldX + random.nextInt(4) - random.nextInt(4);
/* 63 */         z = i1 + random.nextInt(4) - random.nextInt(4);
/*    */       } 
/*    */     } 
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\Generators\WorldGenCustomVines.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */