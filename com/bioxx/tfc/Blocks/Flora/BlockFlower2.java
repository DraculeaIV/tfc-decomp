/*    */ package com.bioxx.tfc.Blocks.Flora;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Climate;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockFlower2
/*    */   extends BlockFlower
/*    */ {
/*    */   public boolean canGrowConditions(World world, int x, int y, int z, int flowerMeta) {
/* 19 */     float rain = TFC_Climate.getRainfall(world, x, 144, z);
/* 20 */     float bioTemperature = TFC_Climate.getBioTemperatureHeight(world, x, y, z);
/* 21 */     return (bioTemperature > 5.0F && rain > 250.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockFlower2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */