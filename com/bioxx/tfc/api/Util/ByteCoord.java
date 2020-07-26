/*    */ package com.bioxx.tfc.api.Util;
/*    */ 
/*    */ public class ByteCoord {
/*    */   public byte x;
/*    */   public byte y;
/*    */   public byte z;
/*    */   
/*    */   public ByteCoord(byte x, byte y, byte z) {
/*  9 */     this.x = x;
/* 10 */     this.y = y;
/* 11 */     this.z = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public ByteCoord(int x, int y, int z) {
/* 16 */     this.x = (byte)x;
/* 17 */     this.y = (byte)y;
/* 18 */     this.z = (byte)z;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 24 */     return (o instanceof ByteCoord && ((ByteCoord)o).x == this.x && ((ByteCoord)o).y == this.y && ((ByteCoord)o).z == this.z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Util\ByteCoord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */