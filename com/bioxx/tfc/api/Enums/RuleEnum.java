/*    */ package com.bioxx.tfc.api.Enums;
/*    */ 
/*    */ 
/*    */ public enum RuleEnum
/*    */ {
/*  6 */   ANY("gui.Anvil.Rule1", -1, 0, 2),
/*  7 */   HITANY("gui.Anvil.Rule2", 0, 0, 2),
/*  8 */   HITLAST("gui.Anvil.Rule3", 0, 0, 0),
/*  9 */   HITSECONDFROMLAST("gui.Anvil.Rule4", 0, 1, 1),
/* 10 */   HITTHIRDFROMLAST("gui.Anvil.Rule5", 0, 2, 2),
/* 11 */   HITLASTTWO("gui.Anvil.Rule6", 0, 0, 1),
/* 12 */   HITNOTLAST("gui.Anvil.Rule8", 0, 1, 2),
/* 13 */   PUNCHANY("gui.Anvil.Rule9", 3, 0, 2),
/* 14 */   PUNCHLAST("gui.Anvil.Rule10", 3, 0, 0),
/* 15 */   PUNCHSECONDFROMLAST("gui.Anvil.Rule11", 3, 1, 1),
/* 16 */   PUNCHTHIRDFROMLAST("gui.Anvil.Rule12", 3, 2, 2),
/* 17 */   PUNCHLASTTWO("gui.Anvil.Rule13", 3, 0, 1),
/* 18 */   PUNCHNOTLAST("gui.Anvil.Rule15", 3, 1, 2),
/* 19 */   SHRINKANY("gui.Anvil.Rule16", 6, 0, 2),
/* 20 */   SHRINKLAST("gui.Anvil.Rule17", 6, 0, 0),
/* 21 */   SHRINKSECONDFROMLAST("gui.Anvil.Rule18", 6, 1, 1),
/* 22 */   SHRINKTHIRDFROMLAST("gui.Anvil.Rule19", 6, 2, 2),
/* 23 */   SHRINKLASTTWO("gui.Anvil.Rule20", 6, 0, 1),
/* 24 */   SHRINKNOTLAST("gui.Anvil.Rule22", 6, 1, 2),
/* 25 */   DRAWANY("gui.Anvil.Rule23", 1, 0, 2),
/* 26 */   DRAWLAST("gui.Anvil.Rule24", 1, 0, 0),
/* 27 */   DRAWSECONDFROMLAST("gui.Anvil.Rule25", 1, 1, 1),
/* 28 */   DRAWTHIRDFROMLAST("gui.Anvil.Rule26", 1, 2, 2),
/* 29 */   DRAWLASTTWO("gui.Anvil.Rule27", 1, 0, 1),
/* 30 */   DRAWNOTLAST("gui.Anvil.Rule29", 1, 1, 2),
/* 31 */   UPSETANY("gui.Anvil.Rule30", 5, 0, 2),
/* 32 */   UPSETLAST("gui.Anvil.Rule31", 5, 0, 0),
/* 33 */   UPSETSECONDFROMLAST("gui.Anvil.Rule32", 5, 1, 1),
/* 34 */   UPSETTHIRDFROMLAST("gui.Anvil.Rule33", 5, 2, 2),
/* 35 */   UPSETLASTTWO("gui.Anvil.Rule34", 5, 0, 1),
/* 36 */   UPSETNOTLAST("gui.Anvil.Rule36", 5, 1, 2),
/* 37 */   BENDANY("gui.Anvil.Rule37", 4, 0, 2),
/* 38 */   BENDLAST("gui.Anvil.Rule38", 4, 0, 0),
/* 39 */   BENDSECONDFROMLAST("gui.Anvil.Rule39", 4, 1, 1),
/* 40 */   BENDTHIRDFROMLAST("gui.Anvil.Rule40", 4, 2, 2),
/* 41 */   BENDLASTTWO("gui.Anvil.Rule41", 4, 0, 1),
/* 42 */   BENDNOTLAST("gui.Anvil.Rule43", 4, 1, 2);
/*    */   
/*    */   public final int Min;
/*    */   
/*    */   public final int Max;
/*    */   
/*    */   public final int Action;
/*    */   
/*    */   public final String Name;
/*    */   
/*    */   RuleEnum(String n, int action, int min, int max) {
/* 53 */     this.Name = n;
/* 54 */     this.Min = min;
/* 55 */     this.Max = max;
/* 56 */     this.Action = action;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(int action, int position) {
/* 61 */     if (this.Action == action || this.Action == -1)
/*    */     {
/* 63 */       if (position >= this.Min && position <= this.Max) {
/* 64 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 68 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(RuleEnum rule, int position) {
/* 73 */     if (this.Action == rule.Action || this.Action == ANY.Action)
/*    */     {
/* 75 */       if (position >= this.Min && position <= this.Max) {
/* 76 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 80 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(int[] actions, int position) {
/* 85 */     for (int i = this.Min; i <= this.Max; i++) {
/*    */       
/* 87 */       if (this.Action == actions[i] || this.Action == -1)
/*    */       {
/* 89 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Enums\RuleEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */