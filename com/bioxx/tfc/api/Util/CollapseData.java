/*    */ package com.bioxx.tfc.api.Util;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.TFCDirection;
/*    */ 
/*    */ 
/*    */ public class CollapseData
/*    */ {
/*    */   public ByteCoord coords;
/*    */   public float collapseChance;
/*    */   public TFCDirection direction;
/*    */   
/*    */   public CollapseData(ByteCoord c, float chance, TFCDirection d) {
/* 13 */     this.coords = c;
/* 14 */     this.collapseChance = chance;
/* 15 */     this.direction = d;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 21 */     return (o instanceof CollapseData && ((CollapseData)o).coords.equals(this.coords));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Util\CollapseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */