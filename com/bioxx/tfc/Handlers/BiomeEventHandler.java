/*    */ package com.bioxx.tfc.Handlers;
/*    */ 
/*    */ import com.bioxx.tfc.WorldGen.BiomeDecoratorTFC;
/*    */ import com.bioxx.tfc.WorldGen.TFCBiome;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.world.biome.BiomeDecorator;
/*    */ import net.minecraftforge.event.terraingen.BiomeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BiomeEventHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onCreateDecorator(BiomeEvent.CreateDecorator event) {
/* 15 */     event.newBiomeDecorator = (BiomeDecorator)new BiomeDecoratorTFC((TFCBiome)event.biome);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\BiomeEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */