/*    */ package com.bioxx.tfc.ModSupport;
/*    */ 
/*    */ import cpw.mods.fml.common.Optional.Method;
/*    */ import java.util.List;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ import weather2.ServerTickHandler;
/*    */ import weather2.weathersystem.WeatherManagerServer;
/*    */ import weather2.weathersystem.storm.StormObject;
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
/*    */ public class Weather2
/*    */   implements IWeather2
/*    */ {
/*    */   @Method(modid = "weather2")
/*    */   public boolean isRainingOnCoord(World worldObj, int xCoord, int yCoord, int zCoord) {
/* 25 */     int dim = worldObj.field_73011_w.field_76574_g;
/* 26 */     WeatherManagerServer wms = (WeatherManagerServer)ServerTickHandler.lookupDimToWeatherMan.get(Integer.valueOf(dim));
/* 27 */     Vec3 startVec3 = Vec3.func_72443_a(xCoord, yCoord, zCoord);
/*    */     
/* 29 */     if (wms != null && startVec3 != null) {
/* 30 */       List<StormObject> storms = wms.getStormsAround(startVec3, 200.0D);
/*    */       
/* 32 */       for (int i = 0; i < storms.size(); i++) {
/* 33 */         StormObject storm = storms.get(i);
/*    */         
/* 35 */         if (storm != null && storm.isPrecipitating()) {
/*    */           
/* 37 */           double radius = storm.size / 0.75D;
/* 38 */           Vec3 location = storm.pos;
/* 39 */           if (startVec3.func_72438_d(location) <= radius * 1.2000000476837158D)
/*    */           {
/* 41 */             return true;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ModSupport\Weather2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */