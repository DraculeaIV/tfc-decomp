/*    */ package com.bioxx.tfc.Core.Config;
/*    */ 
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import java.io.File;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.common.config.Property;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TFC_Configuration
/*    */   extends Configuration
/*    */ {
/*    */   public TFC_Configuration(File file) {
/* 18 */     super(file, null);
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getInt(String name, String category, int defaultValue, int minValue, int maxValue, String comment, String langKey) {
/* 36 */     Property prop = get(category, name, defaultValue);
/* 37 */     prop.setLanguageKey(langKey);
/* 38 */     prop.comment = comment + " [range: " + minValue + " ~ " + maxValue + ", default: " + defaultValue + "]";
/* 39 */     prop.setMinValue(minValue);
/* 40 */     prop.setMaxValue(maxValue);
/* 41 */     if (prop.getInt(defaultValue) < minValue || prop.getInt(defaultValue) > maxValue) {
/*    */       
/* 43 */       TerraFirmaCraft.LOG.warn("An invalid value has been entered for " + name + " in the config file. Reverting to the default value.");
/* 44 */       prop.set(defaultValue);
/* 45 */       return defaultValue;
/*    */     } 
/* 47 */     return prop.getInt(defaultValue);
/*    */   }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float getFloat(String name, String category, float defaultValue, float minValue, float maxValue, String comment, String langKey) {
/* 65 */     Property prop = get(category, name, Float.toString(defaultValue), name);
/* 66 */     prop.setLanguageKey(langKey);
/* 67 */     prop.comment = comment + " [range: " + minValue + " ~ " + maxValue + ", default: " + defaultValue + "]";
/* 68 */     prop.setMinValue(minValue);
/* 69 */     prop.setMaxValue(maxValue);
/*    */     
/*    */     try {
/* 72 */       if (Float.parseFloat(prop.getString()) < minValue || Float.parseFloat(prop.getString()) > maxValue) {
/*    */         
/* 74 */         TerraFirmaCraft.LOG.warn("An invalid value has been entered for " + name + " in the config file. Reverting to the default value.");
/* 75 */         prop.set(defaultValue);
/* 76 */         return defaultValue;
/*    */       } 
/* 78 */       return Float.parseFloat(prop.getString());
/*    */     }
/* 80 */     catch (Exception e) {
/*    */       
/* 82 */       TerraFirmaCraft.LOG.catching(e);
/*    */       
/* 84 */       return defaultValue;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Config\TFC_Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */