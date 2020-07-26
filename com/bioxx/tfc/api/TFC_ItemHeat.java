/*     */ package com.bioxx.tfc.api;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFC_ItemHeat
/*     */ {
/*     */   public static String getHeatColor(float temp, float meltTemp) {
/*  12 */     String phrase = "";
/*  13 */     if (temp < 80.0F) {
/*     */       
/*  15 */       phrase = TFC_Core.translate("gui.ItemHeat.Warming");
/*  16 */       if (temp > 16.0D)
/*  17 */         phrase = phrase + "★"; 
/*  18 */       if (temp > 32.0D)
/*  19 */         phrase = phrase + "★"; 
/*  20 */       if (temp > 48.0D)
/*  21 */         phrase = phrase + "★"; 
/*  22 */       if (temp > 64.0D) {
/*  23 */         phrase = phrase + "★";
/*     */       }
/*  25 */     } else if (temp >= 80.0F && temp < 210.0F) {
/*     */       
/*  27 */       phrase = TFC_Core.translate("gui.ItemHeat.Hot");
/*  28 */       if (temp > 106.0D)
/*  29 */         phrase = phrase + "★"; 
/*  30 */       if (temp > 132.0D)
/*  31 */         phrase = phrase + "★"; 
/*  32 */       if (temp > 158.0D)
/*  33 */         phrase = phrase + "★"; 
/*  34 */       if (temp > 184.0D) {
/*  35 */         phrase = phrase + "★";
/*     */       }
/*  37 */     } else if (temp >= 210.0F && temp < 480.0F) {
/*     */       
/*  39 */       phrase = TFC_Core.translate("gui.ItemHeat.VeryHot");
/*  40 */       if (temp > 264.0D)
/*  41 */         phrase = phrase + "★"; 
/*  42 */       if (temp > 318.0D)
/*  43 */         phrase = phrase + "★"; 
/*  44 */       if (temp > 372.0D)
/*  45 */         phrase = phrase + "★"; 
/*  46 */       if (temp > 426.0D) {
/*  47 */         phrase = phrase + "★";
/*     */       }
/*  49 */     } else if (temp >= 480.0F && temp < 580.0F) {
/*     */       
/*  51 */       phrase = "§4" + TFC_Core.translate("gui.ItemHeat.FaintRed");
/*  52 */       if (temp > 500.0D)
/*  53 */         phrase = phrase + "★"; 
/*  54 */       if (temp > 520.0D)
/*  55 */         phrase = phrase + "★"; 
/*  56 */       if (temp > 540.0D)
/*  57 */         phrase = phrase + "★"; 
/*  58 */       if (temp > 560.0D) {
/*  59 */         phrase = phrase + "★";
/*     */       }
/*  61 */     } else if (temp >= 580.0F && temp < 730.0F) {
/*     */       
/*  63 */       phrase = "§4" + TFC_Core.translate("gui.ItemHeat.DarkRed");
/*  64 */       if (temp > 610.0D)
/*  65 */         phrase = phrase + "★"; 
/*  66 */       if (temp > 640.0D)
/*  67 */         phrase = phrase + "★"; 
/*  68 */       if (temp > 670.0D)
/*  69 */         phrase = phrase + "★"; 
/*  70 */       if (temp > 700.0D) {
/*  71 */         phrase = phrase + "★";
/*     */       }
/*  73 */     } else if (temp >= 730.0F && temp < 930.0F) {
/*     */       
/*  75 */       phrase = "§c" + TFC_Core.translate("gui.ItemHeat.BrightRed");
/*  76 */       if (temp > 770.0D)
/*  77 */         phrase = phrase + "★"; 
/*  78 */       if (temp > 810.0D)
/*  79 */         phrase = phrase + "★"; 
/*  80 */       if (temp > 850.0D)
/*  81 */         phrase = phrase + "★"; 
/*  82 */       if (temp > 890.0D) {
/*  83 */         phrase = phrase + "★";
/*     */       }
/*  85 */     } else if (temp >= 930.0F && temp < 1100.0F) {
/*     */       
/*  87 */       phrase = "§6" + TFC_Core.translate("gui.ItemHeat.Orange");
/*  88 */       if (temp > 964.0D)
/*  89 */         phrase = phrase + "★"; 
/*  90 */       if (temp > 998.0D)
/*  91 */         phrase = phrase + "★"; 
/*  92 */       if (temp > 1032.0D)
/*  93 */         phrase = phrase + "★"; 
/*  94 */       if (temp > 1066.0D) {
/*  95 */         phrase = phrase + "★";
/*     */       }
/*  97 */     } else if (temp >= 1100.0F && temp < 1300.0F) {
/*     */       
/*  99 */       phrase = "§e" + TFC_Core.translate("gui.ItemHeat.Yellow");
/* 100 */       if (temp > 1140.0D)
/* 101 */         phrase = phrase + "★"; 
/* 102 */       if (temp > 1180.0D)
/* 103 */         phrase = phrase + "★"; 
/* 104 */       if (temp > 1220.0D)
/* 105 */         phrase = phrase + "★"; 
/* 106 */       if (temp > 1260.0D) {
/* 107 */         phrase = phrase + "★";
/*     */       }
/* 109 */     } else if (temp >= 1300.0F && temp < 1400.0F) {
/*     */       
/* 111 */       phrase = "§e" + TFC_Core.translate("gui.ItemHeat.YellowWhite");
/* 112 */       if (temp > 1320.0D)
/* 113 */         phrase = phrase + "★"; 
/* 114 */       if (temp > 1340.0D)
/* 115 */         phrase = phrase + "★"; 
/* 116 */       if (temp > 1360.0D)
/* 117 */         phrase = phrase + "★"; 
/* 118 */       if (temp > 1380.0D) {
/* 119 */         phrase = phrase + "★";
/*     */       }
/* 121 */     } else if (temp >= 1400.0F && temp < 1500.0F) {
/*     */       
/* 123 */       phrase = "§f" + TFC_Core.translate("gui.ItemHeat.White");
/* 124 */       if (temp > 1420.0D)
/* 125 */         phrase = phrase + "★"; 
/* 126 */       if (temp > 1440.0D)
/* 127 */         phrase = phrase + "★"; 
/* 128 */       if (temp > 1460.0D)
/* 129 */         phrase = phrase + "★"; 
/* 130 */       if (temp > 1480.0D) {
/* 131 */         phrase = phrase + "★";
/*     */       }
/* 133 */     } else if (temp >= 1500.0F) {
/* 134 */       phrase = "§f" + TFC_Core.translate("gui.ItemHeat.BrilliantWhite");
/*     */     } 
/* 136 */     if (temp > meltTemp) {
/* 137 */       phrase = phrase + "§f - " + TFC_Core.translate("gui.ItemHeat.Liquid");
/*     */     }
/* 139 */     return phrase;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getHeatColorFood(float temp, float meltTemp) {
/* 144 */     if (temp < meltTemp) {
/*     */       
/* 146 */       if (temp < meltTemp * 0.1F)
/* 147 */         return TFC_Core.translate("gui.FoodHeat.Cold"); 
/* 148 */       if (temp >= meltTemp * 0.1F && temp < meltTemp * 0.4F)
/* 149 */         return "§4" + TFC_Core.translate("gui.FoodHeat.Warm"); 
/* 150 */       if (temp >= meltTemp * 0.4F && temp < meltTemp * 0.8F) {
/* 151 */         return "§4" + TFC_Core.translate("gui.ItemHeat.Hot");
/*     */       }
/* 153 */       return "§4" + TFC_Core.translate("gui.ItemHeat.VeryHot");
/*     */     } 
/* 155 */     return TFC_Core.translate("gui.ClearSlot");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getHeatColorTorch(float temp, float meltTemp) {
/* 160 */     if (temp < meltTemp) {
/*     */       
/* 162 */       if (temp > 0.0F && temp < meltTemp * 0.8F)
/* 163 */         return TFC_Core.translate("gui.Torch.CatchingFire"); 
/* 164 */       if (temp >= meltTemp * 0.8F)
/* 165 */         return "§4" + TFC_Core.translate("gui.Torch.Lit"); 
/*     */     } 
/* 167 */     return TFC_Core.translate("gui.ClearSlot");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Boolean getIsLiquid(ItemStack is) {
/* 172 */     return Boolean.valueOf((getTemp(is) >= isCookable(is)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float isCookable(ItemStack is) {
/* 177 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 178 */     if (is != null && manager != null) {
/*     */       
/* 180 */       HeatIndex hi = manager.findMatchingIndex(is);
/* 181 */       if (hi != null) {
/* 182 */         return hi.meltTemp;
/*     */       }
/* 184 */       return -1.0F;
/*     */     } 
/*     */     
/* 187 */     return -1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getSpecificHeat(ItemStack is) {
/* 192 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 193 */     if (is != null && manager != null) {
/*     */       
/* 195 */       HeatIndex hi = manager.findMatchingIndex(is);
/* 196 */       if (hi != null) {
/* 197 */         return hi.specificHeat;
/*     */       }
/* 199 */       return 1.0F;
/*     */     } 
/*     */     
/* 202 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float isCookable(Metal m) {
/* 207 */     HeatRegistry manager = HeatRegistry.getInstance();
/* 208 */     if (manager != null) {
/*     */       
/* 210 */       HeatIndex hi = manager.findMatchingIndex(new ItemStack(m.meltedItem));
/* 211 */       if (hi != null) {
/* 212 */         return hi.meltTemp;
/*     */       }
/* 214 */       return -1.0F;
/*     */     } 
/*     */     
/* 217 */     return -1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getTemp(ItemStack is) {
/* 222 */     if (hasTemp(is))
/*     */     {
/* 224 */       return is.func_77978_p().func_74760_g("temperature");
/*     */     }
/* 226 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasTemp(ItemStack is) {
/* 231 */     if (is != null)
/*     */     {
/* 233 */       if (is.func_77942_o() && is.func_77978_p().func_74764_b("temperature"))
/* 234 */         return true; 
/*     */     }
/* 236 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getTempIncrease(ItemStack is) {
/* 241 */     byte debugBump = 0;
/* 242 */     if (TFCOptions.enableDebugMode)
/* 243 */       debugBump = 2; 
/* 244 */     return TFCOptions.tempIncreaseMultiplier * getSpecificHeat(is) + debugBump;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getTempDecrease(ItemStack is) {
/* 249 */     if (TFCOptions.enableDebugMode)
/* 250 */       return 0.0F; 
/* 251 */     return TFCOptions.tempDecreaseMultiplier * getSpecificHeat(is);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handleItemHeat(ItemStack is) {
/* 256 */     if (is != null)
/*     */     {
/* 258 */       if (is.func_77942_o()) {
/*     */         
/* 260 */         NBTTagCompound comp = is.func_77978_p();
/* 261 */         if (hasTemp(is)) {
/*     */           
/* 263 */           float temp = getTemp(is);
/* 264 */           if (temp > 0.0F) {
/*     */             
/* 266 */             temp -= getTempDecrease(is);
/* 267 */             comp.func_74776_a("temperature", temp);
/*     */           } 
/* 269 */           if (temp <= 0.0F)
/* 270 */             comp.func_82580_o("temperature"); 
/* 271 */           if (comp.func_82582_d()) {
/* 272 */             is.field_77990_d = null;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static Boolean setTemp(ItemStack is, float temp) {
/* 280 */     if (is != null) {
/*     */       
/* 282 */       if (is.func_77942_o()) {
/* 283 */         is.func_77978_p().func_74776_a("temperature", temp);
/* 284 */       } else if (isCookable(is) != -1.0F) {
/*     */         
/* 286 */         NBTTagCompound nbt = new NBTTagCompound();
/* 287 */         nbt.func_74776_a("temperature", temp);
/* 288 */         is.func_77982_d(nbt);
/*     */       } 
/*     */     } else {
/*     */       
/* 292 */       return Boolean.valueOf(false);
/*     */     } 
/* 294 */     if (temp <= 0.0F) {
/* 295 */       removeTempTag(is);
/*     */     }
/* 297 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeTempTag(ItemStack is) {
/* 302 */     if (is.func_77942_o() && is.func_77978_p().func_74764_b("temperature"))
/*     */     {
/* 304 */       is.func_77978_p().func_82580_o("temperature");
/*     */     }
/* 306 */     if (is.func_77942_o() && is.func_77978_p().func_82582_d())
/* 307 */       is.field_77990_d = null; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\TFC_ItemHeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */