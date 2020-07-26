/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ public enum AnvilReq
/*    */ {
/*  5 */   STONE("Stone", 0),
/*  6 */   COPPER("Copper", 1),
/*  7 */   BRONZE("Bronze", 2),
/*  8 */   WROUGHTIRON("Wrought Iron", 3),
/*  9 */   STEEL("Steel", 4),
/* 10 */   BLACKSTEEL("Black Steel", 5),
/* 11 */   REDSTEEL("Red Steel", 6),
/* 12 */   BLUESTEEL("Blue Steel", 6),
/* 13 */   BISMUTHBRONZE("Bismuth Bronze", 2),
/* 14 */   BLACKBRONZE("Black Bronze", 2),
/* 15 */   ROSEGOLD("Rose Gold", 2);
/*    */   static {
/* 17 */     RULES = new AnvilReq[] { STONE, COPPER, BRONZE, WROUGHTIRON, STEEL, BLACKSTEEL, REDSTEEL, BLUESTEEL, BISMUTHBRONZE, BLACKBRONZE, ROSEGOLD };
/*    */   }
/*    */   
/*    */   public static final AnvilReq[] RULES;
/*    */   public final int Tier;
/*    */   public final String Name;
/*    */   
/*    */   AnvilReq(String n, int tier) {
/* 25 */     this.Name = n;
/* 26 */     this.Tier = tier;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(int tier) {
/* 31 */     return (tier >= this.Tier);
/*    */   }
/*    */   
/*    */   public boolean matches(AnvilReq req) {
/* 35 */     return (req.Tier >= this.Tier);
/*    */   }
/*    */   
/*    */   public static boolean matches(int i, int j) {
/* 39 */     return (j >= i);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AnvilReq getReqFromInt(int i) {
/* 44 */     switch (i) {
/*    */       
/*    */       case 1:
/* 47 */         return COPPER;
/*    */       case 2:
/* 49 */         return BRONZE;
/*    */       case 3:
/* 51 */         return WROUGHTIRON;
/*    */       case 4:
/* 53 */         return STEEL;
/*    */       case 5:
/* 55 */         return BLACKSTEEL;
/*    */       case 6:
/* 57 */         return REDSTEEL;
/*    */       case 7:
/* 59 */         return BLUESTEEL;
/*    */     } 
/* 61 */     return STONE;
/*    */   }
/*    */ 
/*    */   
/*    */   public static AnvilReq getReqFromInt2(int i) {
/* 66 */     switch (i) {
/*    */       
/*    */       case 0:
/* 69 */         return BISMUTHBRONZE;
/*    */       case 1:
/* 71 */         return BLACKBRONZE;
/*    */       case 2:
/* 73 */         return ROSEGOLD;
/*    */     } 
/* 75 */     return BISMUTHBRONZE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\AnvilReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */