/*    */ package com.bioxx.tfc.Render.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.EntityRenderer;
/*    */ import net.minecraft.client.renderer.RenderBlocks;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderFlora
/*    */ {
/*    */   public static boolean render(Block block, int x, int y, int z, RenderBlocks renderer) {
/* 16 */     Block blockDirectlyAbove = renderer.field_147845_a.func_147439_a(x, y + 1, z);
/* 17 */     boolean hasAirTwoAbove = renderer.field_147845_a.func_147439_a(x, y + 2, z).isAir(renderer.field_147845_a, x, y + 2, z);
/* 18 */     if (TFC_Core.isWater(blockDirectlyAbove))
/*    */     {
/* 20 */       if (TFC_Core.isFreshWater(blockDirectlyAbove)) {
/*    */         
/* 22 */         if (hasAirTwoAbove)
/*    */         {
/* 24 */           renderCatTails(block, x, y + 1, z, renderer);
/*    */         }
/*    */         else
/*    */         {
/* 28 */           renderShortWaterPlant(block, x, y + 1, z, renderer, 1);
/*    */         }
/*    */       
/* 31 */       } else if (TFC_Core.isSaltWater(blockDirectlyAbove)) {
/* 32 */         renderShortWaterPlant(block, x, y + 1, z, renderer, 0);
/*    */       } 
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean renderShortWaterPlant(Block block, int x, int y, int z, RenderBlocks renderer, int plantType) {
/* 40 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 41 */     tessellator.func_78380_c(block.func_149677_c(renderer.field_147845_a, x, y, z));
/* 42 */     int l = block.func_149720_d(renderer.field_147845_a, x, y, z);
/* 43 */     float f = (l >> 16 & 0xFF) / 255.0F;
/* 44 */     float f1 = (l >> 8 & 0xFF) / 255.0F;
/* 45 */     float f2 = (l & 0xFF) / 255.0F;
/*    */     
/* 47 */     if (EntityRenderer.field_78517_a) {
/*    */       
/* 49 */       float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
/* 50 */       float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
/* 51 */       float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
/* 52 */       f = f3;
/* 53 */       f1 = f4;
/* 54 */       f2 = f5;
/*    */     } 
/*    */     
/* 57 */     tessellator.func_78386_a(f, f1, f2);
/* 58 */     double d1 = x;
/* 59 */     double d2 = y;
/* 60 */     double d0 = z;
/*    */ 
/*    */     
/* 63 */     if (block == Blocks.field_150329_H) {
/*    */       
/* 65 */       long i1 = (x * 3129871) ^ z * 116129781L ^ y;
/* 66 */       i1 = i1 * i1 * 42317861L + i1 * 11L;
/* 67 */       d1 += (((float)(i1 >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/* 68 */       d2 += (((float)(i1 >> 20L & 0xFL) / 15.0F) - 1.0D) * 0.2D;
/* 69 */       d0 += (((float)(i1 >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.5D;
/*    */     }
/* 71 */     else if (block == Blocks.field_150328_O || block == Blocks.field_150327_N) {
/*    */       
/* 73 */       long i1 = (x * 3129871) ^ z * 116129781L ^ y;
/* 74 */       i1 = i1 * i1 * 42317861L + i1 * 11L;
/* 75 */       d1 += (((float)(i1 >> 16L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/* 76 */       d0 += (((float)(i1 >> 24L & 0xFL) / 15.0F) - 0.5D) * 0.3D;
/*    */     } 
/*    */     
/* 79 */     IIcon iicon = block.func_149691_a(0, plantType);
/* 80 */     renderer.func_147765_a(iicon, d1, d2, d0, 1.0F);
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void renderCatTails(Block block, int x, int y, int z, RenderBlocks renderer) {
/* 87 */     IIcon icon = block.func_149691_a(0, 2);
/* 88 */     renderer.func_147765_a(icon, x, y, z, 2.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderFlora.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */